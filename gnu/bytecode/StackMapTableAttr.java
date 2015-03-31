package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class StackMapTableAttr
  extends MiscAttr
{
  public static boolean compressStackMapTable = true;
  int countLocals;
  int countStack;
  int[] encodedLocals;
  int[] encodedStack;
  int numEntries;
  int prevPosition = -1;
  
  public StackMapTableAttr()
  {
    super("StackMapTable", null, 0, 0);
    put2(0);
  }
  
  public StackMapTableAttr(byte[] paramArrayOfByte, CodeAttr paramCodeAttr)
  {
    super("StackMapTable", paramArrayOfByte, 0, paramArrayOfByte.length);
    addToFrontOf(paramCodeAttr);
    this.numEntries = u2(0);
  }
  
  static int[] reallocBuffer(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      paramArrayOfInt = new int[paramInt + 10];
    }
    while (paramInt <= paramArrayOfInt.length) {
      return paramArrayOfInt;
    }
    int[] arrayOfInt = new int[paramInt + 10];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramArrayOfInt.length);
    return arrayOfInt;
  }
  
  public void emitStackMapEntry(Label paramLabel, CodeAttr paramCodeAttr)
  {
    int i = -1 + (paramLabel.position - this.prevPosition);
    int j = paramLabel.localTypes.length;
    if (j > this.encodedLocals.length)
    {
      int[] arrayOfInt4 = new int[j + this.encodedLocals.length];
      System.arraycopy(this.encodedLocals, 0, arrayOfInt4, 0, this.countLocals);
      this.encodedLocals = arrayOfInt4;
    }
    int k = paramLabel.stackTypes.length;
    if (k > this.encodedStack.length)
    {
      int[] arrayOfInt3 = new int[k + this.encodedStack.length];
      System.arraycopy(this.encodedStack, 0, arrayOfInt3, 0, this.countStack);
      this.encodedStack = arrayOfInt3;
    }
    int m = 0;
    int n = 0;
    int i13;
    for (int i1 = 0; n < j; i1 = i13)
    {
      int i11 = this.encodedLocals[i1];
      int i12 = encodeVerificationType(paramLabel.localTypes[n], paramCodeAttr);
      if ((i11 == i12) && (m == i1)) {
        m = i1 + 1;
      }
      int[] arrayOfInt2 = this.encodedLocals;
      i13 = i1 + 1;
      arrayOfInt2[i1] = i12;
      if ((i12 == 3) || (i12 == 4)) {
        n++;
      }
      n++;
    }
    for (;;)
    {
      int i2;
      if ((i2 > 0) && (this.encodedLocals[(i2 - 1)] == 0))
      {
        i2--;
      }
      else
      {
        int i3 = 0;
        int i10;
        for (int i4 = 0; i3 < k; i4 = i10)
        {
          this.encodedStack[i4];
          Type localType = paramLabel.stackTypes[i3];
          PrimType localPrimType = Type.voidType;
          if (localType == localPrimType)
          {
            Type[] arrayOfType = paramLabel.stackTypes;
            i3++;
            localType = arrayOfType[i3];
          }
          int i9 = encodeVerificationType(localType, paramCodeAttr);
          int[] arrayOfInt1 = this.encodedStack;
          i10 = i4 + 1;
          arrayOfInt1[i4] = i9;
          i3++;
        }
        int i5 = i2 - this.countLocals;
        if ((compressStackMapTable) && (i5 == 0) && (i2 == m) && (i4 <= 1)) {
          if (i4 == 0) {
            if (i <= 63) {
              put1(i);
            }
          }
        }
        for (;;)
        {
          this.countLocals = i2;
          this.countStack = i4;
          this.prevPosition = paramLabel.position;
          this.numEntries = (1 + this.numEntries);
          return;
          put1(251);
          put2(i);
          continue;
          if (i <= 63) {
            put1(i + 64);
          }
          for (;;)
          {
            emitVerificationType(this.encodedStack[0]);
            break;
            put1(247);
            put2(i);
          }
          if ((compressStackMapTable) && (i4 == 0) && (i2 < this.countLocals) && (m == i2) && (i5 >= -3))
          {
            put1(i5 + 251);
            put2(i);
          }
          else if ((compressStackMapTable) && (i4 == 0) && (this.countLocals == m) && (i5 <= 3))
          {
            put1(i5 + 251);
            put2(i);
            for (int i8 = 0; i8 < i5; i8++) {
              emitVerificationType(this.encodedLocals[(m + i8)]);
            }
          }
          else
          {
            put1(255);
            put2(i);
            put2(i2);
            for (int i6 = 0; i6 < i2; i6++) {
              emitVerificationType(this.encodedLocals[i6]);
            }
            put2(i4);
            for (int i7 = 0; i7 < i4; i7++) {
              emitVerificationType(this.encodedStack[i7]);
            }
          }
        }
        i2 = i1;
      }
    }
  }
  
  void emitVerificationType(int paramInt)
  {
    int i = paramInt & 0xFF;
    put1(i);
    if (i >= 7) {
      put2(paramInt >> 8);
    }
  }
  
  int encodeVerificationType(Type paramType, CodeAttr paramCodeAttr)
  {
    if (paramType == null) {
      return 0;
    }
    if ((paramType instanceof UninitializedType))
    {
      Label localLabel = ((UninitializedType)paramType).label;
      if (localLabel == null) {
        return 6;
      }
      return 0x8 | localLabel.position << 8;
    }
    Type localType = paramType.getImplementationType();
    if ((localType instanceof PrimType))
    {
      switch (localType.signature.charAt(0))
      {
      default: 
        return 0;
      case 'B': 
      case 'C': 
      case 'I': 
      case 'S': 
      case 'Z': 
        return 1;
      case 'J': 
        return 4;
      case 'F': 
        return 2;
      }
      return 3;
    }
    if (localType == Type.nullType) {
      return 5;
    }
    return 0x7 | paramCodeAttr.getConstants().addClass((ObjectType)localType).index << 8;
  }
  
  int extractVerificationType(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 7) || (paramInt2 == 8)) {
      paramInt2 |= u2(paramInt1 + 1) << 8;
    }
    return paramInt2;
  }
  
  int extractVerificationTypes(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    int i = paramInt1;
    int i1;
    for (int j = paramInt3;; j = i1)
    {
      paramInt2--;
      if (paramInt2 < 0) {
        break label97;
      }
      if (i < this.dataLength) {
        break;
      }
      m = -1;
      i1 = j + 1;
      paramArrayOfInt[j] = m;
    }
    int k = this.data[i];
    int m = extractVerificationType(i, k);
    if ((k == 7) || (k == 8)) {}
    for (int n = 3;; n = 1)
    {
      i += n;
      break;
    }
    label97:
    return i;
  }
  
  public Method getMethod()
  {
    return ((CodeAttr)this.container).getMethod();
  }
  
  public void print(ClassTypeWriter paramClassTypeWriter)
  {
    paramClassTypeWriter.print("Attribute \"");
    paramClassTypeWriter.print(getName());
    paramClassTypeWriter.print("\", length:");
    paramClassTypeWriter.print(getLength());
    paramClassTypeWriter.print(", number of entries: ");
    paramClassTypeWriter.println(this.numEntries);
    int i = 2;
    int j = -1;
    Method localMethod = getMethod();
    int[] arrayOfInt1 = null;
    int k;
    int m;
    if (localMethod.getStaticFlag())
    {
      k = 0;
      m = k + localMethod.arg_types.length;
    }
    label205:
    label610:
    for (int n = 0;; n++)
    {
      if ((n >= this.numEntries) || (i >= this.dataLength))
      {
        return;
        k = 1;
        break;
      }
      int i1 = i + 1;
      int i2 = u1(i);
      int i3 = j + 1;
      if (i2 <= 127)
      {
        j = i3 + (i2 & 0x3F);
        i = i1;
        paramClassTypeWriter.print("  offset: ");
        paramClassTypeWriter.print(j);
        if (i2 > 63) {
          break label205;
        }
        paramClassTypeWriter.println(" - same_frame");
      }
      for (;;)
      {
        if (i >= 0) {
          break label610;
        }
        paramClassTypeWriter.println("<ERROR - missing data>");
        return;
        if (i1 + 1 >= this.dataLength) {
          return;
        }
        j = i3 + u2(i1);
        i = i1 + 2;
        break;
        if ((i2 <= 127) || (i2 == 247))
        {
          if (i2 <= 127) {}
          for (String str = " - same_locals_1_stack_item_frame";; str = " - same_locals_1_stack_item_frame_extended")
          {
            paramClassTypeWriter.println(str);
            arrayOfInt1 = reallocBuffer(arrayOfInt1, 1);
            i = extractVerificationTypes(i, 1, 0, arrayOfInt1);
            printVerificationTypes(arrayOfInt1, 0, 1, paramClassTypeWriter);
            break;
          }
        }
        if (i2 <= 246)
        {
          paramClassTypeWriter.print(" - tag reserved for future use - ");
          paramClassTypeWriter.println(i2);
          return;
        }
        if (i2 <= 250)
        {
          int i11 = 251 - i2;
          paramClassTypeWriter.print(" - chop_frame - undefine ");
          paramClassTypeWriter.print(i11);
          paramClassTypeWriter.println(" locals");
          m -= i11;
        }
        else if (i2 == 251)
        {
          paramClassTypeWriter.println(" - same_frame_extended");
        }
        else if (i2 <= 254)
        {
          int i10 = i2 - 251;
          paramClassTypeWriter.print(" - append_frame - define ");
          paramClassTypeWriter.print(i10);
          paramClassTypeWriter.println(" more locals");
          arrayOfInt1 = reallocBuffer(arrayOfInt1, m + i10);
          i = extractVerificationTypes(i, i10, m, arrayOfInt1);
          printVerificationTypes(arrayOfInt1, m, i10, paramClassTypeWriter);
          m += i10;
        }
        else
        {
          if (i + 1 >= this.dataLength) {
            return;
          }
          int i4 = u2(i);
          int i5 = i + 2;
          paramClassTypeWriter.print(" - full_frame.  Locals count: ");
          paramClassTypeWriter.println(i4);
          int[] arrayOfInt2 = reallocBuffer(arrayOfInt1, i4);
          int i6 = extractVerificationTypes(i5, i4, 0, arrayOfInt2);
          printVerificationTypes(arrayOfInt2, 0, i4, paramClassTypeWriter);
          m = i4;
          if (i6 + 1 >= this.dataLength) {
            return;
          }
          int i7 = u2(i6);
          int i8 = i6 + 2;
          paramClassTypeWriter.print("    (end of locals)");
          int i9 = Integer.toString(j).length();
          for (;;)
          {
            i9--;
            if (i9 < 0) {
              break;
            }
            paramClassTypeWriter.print(' ');
          }
          paramClassTypeWriter.print("       Stack count: ");
          paramClassTypeWriter.println(i7);
          arrayOfInt1 = reallocBuffer(arrayOfInt2, i7);
          i = extractVerificationTypes(i8, i7, 0, arrayOfInt1);
          printVerificationTypes(arrayOfInt1, 0, i7, paramClassTypeWriter);
        }
      }
    }
  }
  
  void printVerificationType(int paramInt, ClassTypeWriter paramClassTypeWriter)
  {
    int i = paramInt & 0xFF;
    switch (i)
    {
    default: 
      paramClassTypeWriter.print("<bad verification type tag " + i + '>');
      return;
    case 0: 
      paramClassTypeWriter.print("top/unavailable");
      return;
    case 1: 
      paramClassTypeWriter.print("integer");
      return;
    case 2: 
      paramClassTypeWriter.print("float");
      return;
    case 3: 
      paramClassTypeWriter.print("double");
      return;
    case 4: 
      paramClassTypeWriter.print("long");
      return;
    case 5: 
      paramClassTypeWriter.print("null");
      return;
    case 6: 
      paramClassTypeWriter.print("uninitialized this");
      return;
    case 7: 
      int k = paramInt >> 8;
      paramClassTypeWriter.printOptionalIndex(k);
      paramClassTypeWriter.printConstantTersely(k, 7);
      return;
    }
    int j = paramInt >> 8;
    paramClassTypeWriter.print("uninitialized object created at ");
    paramClassTypeWriter.print(j);
  }
  
  void printVerificationTypes(int[] paramArrayOfInt, int paramInt1, int paramInt2, ClassTypeWriter paramClassTypeWriter)
  {
    int i = 0;
    int j = 0;
    if (j < paramInt1 + paramInt2)
    {
      int k = paramArrayOfInt[j];
      int m = k & 0xFF;
      if (j >= paramInt1)
      {
        paramClassTypeWriter.print("  ");
        if (i < 100) {
          break label101;
        }
      }
      for (;;)
      {
        paramClassTypeWriter.print(i);
        paramClassTypeWriter.print(": ");
        printVerificationType(k, paramClassTypeWriter);
        paramClassTypeWriter.println();
        i++;
        if ((m == 3) || (m == 4)) {
          i++;
        }
        j++;
        break;
        label101:
        if (i < 10) {
          paramClassTypeWriter.print(' ');
        }
        paramClassTypeWriter.print(' ');
      }
    }
  }
  
  public void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    put2(0, this.numEntries);
    super.write(paramDataOutputStream);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.StackMapTableAttr
 * JD-Core Version:    0.7.0.1
 */