package gnu.bytecode;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class ClassFileInput
  extends DataInputStream
{
  ClassType ctype;
  InputStream str;
  
  public ClassFileInput(ClassType paramClassType, InputStream paramInputStream)
    throws IOException, ClassFormatError
  {
    super(paramInputStream);
    this.ctype = paramClassType;
    if (!readHeader()) {
      throw new ClassFormatError("invalid magic number");
    }
    paramClassType.constants = readConstants();
    readClassInfo();
    readFields();
    readMethods();
    readAttributes(paramClassType);
  }
  
  public ClassFileInput(InputStream paramInputStream)
    throws IOException
  {
    super(paramInputStream);
  }
  
  public static ClassType readClassType(InputStream paramInputStream)
    throws IOException, ClassFormatError
  {
    ClassType localClassType = new ClassType();
    new ClassFileInput(localClassType, paramInputStream);
    return localClassType;
  }
  
  CpoolClass getClassConstant(int paramInt)
  {
    return (CpoolClass)this.ctype.constants.getForced(paramInt, 7);
  }
  
  public Attribute readAttribute(String paramString, int paramInt, AttrContainer paramAttrContainer)
    throws IOException
  {
    Object localObject;
    if ((paramString == "SourceFile") && ((paramAttrContainer instanceof ClassType))) {
      localObject = new SourceFileAttr(readUnsignedShort(), (ClassType)paramAttrContainer);
    }
    for (;;)
    {
      return localObject;
      if ((paramString == "Code") && ((paramAttrContainer instanceof Method)))
      {
        CodeAttr localCodeAttr2 = new CodeAttr((Method)paramAttrContainer);
        localCodeAttr2.fixup_count = -1;
        localCodeAttr2.setMaxStack(readUnsignedShort());
        localCodeAttr2.setMaxLocals(readUnsignedShort());
        byte[] arrayOfByte5 = new byte[readInt()];
        readFully(arrayOfByte5);
        localCodeAttr2.setCode(arrayOfByte5);
        int i8 = readUnsignedShort();
        for (int i9 = 0; i9 < i8; i9++) {
          localCodeAttr2.addHandler(readUnsignedShort(), readUnsignedShort(), readUnsignedShort(), readUnsignedShort());
        }
        readAttributes(localCodeAttr2);
        return localCodeAttr2;
      }
      if ((paramString == "LineNumberTable") && ((paramAttrContainer instanceof CodeAttr)))
      {
        int i6 = 2 * readUnsignedShort();
        short[] arrayOfShort3 = new short[i6];
        for (int i7 = 0; i7 < i6; i7++) {
          arrayOfShort3[i7] = readShort();
        }
        return new LineNumbersAttr(arrayOfShort3, (CodeAttr)paramAttrContainer);
      }
      if ((paramString != "LocalVariableTable") || (!(paramAttrContainer instanceof CodeAttr))) {
        break;
      }
      CodeAttr localCodeAttr1 = (CodeAttr)paramAttrContainer;
      localObject = new LocalVarsAttr(localCodeAttr1);
      Method localMethod2 = ((LocalVarsAttr)localObject).getMethod();
      if (((LocalVarsAttr)localObject).parameter_scope == null) {
        ((LocalVarsAttr)localObject).parameter_scope = localMethod2.pushScope();
      }
      Scope localScope1 = ((LocalVarsAttr)localObject).parameter_scope;
      if (localScope1.end == null)
      {
        Label localLabel1 = new Label(localCodeAttr1.PC);
        localScope1.end = localLabel1;
      }
      ConstantPool localConstantPool = localMethod2.getConstants();
      int n = readUnsignedShort();
      int i1 = localScope1.start.position;
      int i2 = localScope1.end.position;
      for (int i3 = 0; i3 < n; i3++)
      {
        Variable localVariable = new Variable();
        int i4 = readUnsignedShort();
        int i5 = i4 + readUnsignedShort();
        if ((i4 != i1) || (i5 != i2))
        {
          while ((localScope1.parent != null) && ((i4 < localScope1.start.position) || (i5 > localScope1.end.position))) {
            localScope1 = localScope1.parent;
          }
          Scope localScope2 = localScope1;
          Label localLabel2 = new Label(i4);
          Label localLabel3 = new Label(i5);
          localScope1 = new Scope(localLabel2, localLabel3);
          localScope1.linkChild(localScope2);
          i1 = i4;
          i2 = i5;
        }
        localScope1.addVariable(localVariable);
        localVariable.setName(readUnsignedShort(), localConstantPool);
        localVariable.setSignature(readUnsignedShort(), localConstantPool);
        localVariable.offset = readUnsignedShort();
      }
    }
    if ((paramString == "Signature") && ((paramAttrContainer instanceof Member))) {
      return new SignatureAttr(readUnsignedShort(), (Member)paramAttrContainer);
    }
    if ((paramString == "StackMapTable") && ((paramAttrContainer instanceof CodeAttr)))
    {
      byte[] arrayOfByte4 = new byte[paramInt];
      readFully(arrayOfByte4, 0, paramInt);
      return new StackMapTableAttr(arrayOfByte4, (CodeAttr)paramAttrContainer);
    }
    if (((paramString == "RuntimeVisibleAnnotations") || (paramString == "RuntimeInvisibleAnnotations")) && (((paramAttrContainer instanceof Field)) || ((paramAttrContainer instanceof Method)) || ((paramAttrContainer instanceof ClassType))))
    {
      byte[] arrayOfByte1 = new byte[paramInt];
      readFully(arrayOfByte1, 0, paramInt);
      return new RuntimeAnnotationsAttr(paramString, arrayOfByte1, paramAttrContainer);
    }
    if ((paramString == "ConstantValue") && ((paramAttrContainer instanceof Field))) {
      return new ConstantValueAttr(readUnsignedShort());
    }
    if ((paramString == "InnerClasses") && ((paramAttrContainer instanceof ClassType)))
    {
      int k = 4 * readUnsignedShort();
      short[] arrayOfShort2 = new short[k];
      for (int m = 0; m < k; m++) {
        arrayOfShort2[m] = readShort();
      }
      return new InnerClassesAttr(arrayOfShort2, (ClassType)paramAttrContainer);
    }
    if ((paramString == "EnclosingMethod") && ((paramAttrContainer instanceof ClassType))) {
      return new EnclosingMethodAttr(readUnsignedShort(), readUnsignedShort(), (ClassType)paramAttrContainer);
    }
    if ((paramString == "Exceptions") && ((paramAttrContainer instanceof Method)))
    {
      Method localMethod1 = (Method)paramAttrContainer;
      int i = readUnsignedShort();
      short[] arrayOfShort1 = new short[i];
      for (int j = 0; j < i; j++) {
        arrayOfShort1[j] = readShort();
      }
      localMethod1.setExceptions(arrayOfShort1);
      return localMethod1.getExceptionAttr();
    }
    if ((paramString == "SourceDebugExtension") && ((paramAttrContainer instanceof ClassType)))
    {
      SourceDebugExtAttr localSourceDebugExtAttr = new SourceDebugExtAttr((ClassType)paramAttrContainer);
      byte[] arrayOfByte3 = new byte[paramInt];
      readFully(arrayOfByte3, 0, paramInt);
      localSourceDebugExtAttr.data = arrayOfByte3;
      localSourceDebugExtAttr.dlength = paramInt;
      return localSourceDebugExtAttr;
    }
    byte[] arrayOfByte2 = new byte[paramInt];
    readFully(arrayOfByte2, 0, paramInt);
    return new MiscAttr(paramString, arrayOfByte2);
  }
  
  public int readAttributes(AttrContainer paramAttrContainer)
    throws IOException
  {
    int i = readUnsignedShort();
    Object localObject = paramAttrContainer.getAttributes();
    int j = 0;
    if (j < i)
    {
      label25:
      Attribute localAttribute2;
      Attribute localAttribute1;
      if (localObject != null)
      {
        localAttribute2 = ((Attribute)localObject).getNext();
        if (localAttribute2 != null) {}
      }
      else
      {
        int k = readUnsignedShort();
        CpoolUtf8 localCpoolUtf8 = (CpoolUtf8)this.ctype.constants.getForced(k, 1);
        int m = readInt();
        localCpoolUtf8.intern();
        localAttribute1 = readAttribute(localCpoolUtf8.string, m, paramAttrContainer);
        if (localAttribute1 != null)
        {
          if (localAttribute1.getNameIndex() == 0) {
            localAttribute1.setNameIndex(k);
          }
          if (localObject != null) {
            break label132;
          }
          paramAttrContainer.setAttributes(localAttribute1);
        }
      }
      for (;;)
      {
        localObject = localAttribute1;
        j++;
        break;
        localObject = localAttribute2;
        break label25;
        label132:
        if (paramAttrContainer.getAttributes() == localAttribute1)
        {
          paramAttrContainer.setAttributes(localAttribute1.getNext());
          localAttribute1.setNext(null);
        }
        ((Attribute)localObject).setNext(localAttribute1);
      }
    }
    return i;
  }
  
  public void readClassInfo()
    throws IOException
  {
    this.ctype.access_flags = readUnsignedShort();
    this.ctype.thisClassIndex = readUnsignedShort();
    String str1 = getClassConstant(this.ctype.thisClassIndex).name.string;
    this.ctype.this_name = str1.replace('/', '.');
    this.ctype.setSignature("L" + str1 + ";");
    this.ctype.superClassIndex = readUnsignedShort();
    if (this.ctype.superClassIndex == 0) {
      this.ctype.setSuper((ClassType)null);
    }
    for (;;)
    {
      int i = readUnsignedShort();
      if (i <= 0) {
        break;
      }
      this.ctype.interfaces = new ClassType[i];
      this.ctype.interfaceIndexes = new int[i];
      for (int j = 0; j < i; j++)
      {
        int k = readUnsignedShort();
        this.ctype.interfaceIndexes[j] = k;
        String str3 = ((CpoolClass)this.ctype.constants.getForced(k, 7)).name.string.replace('/', '.');
        this.ctype.interfaces[j] = ClassType.make(str3);
      }
      String str2 = getClassConstant(this.ctype.superClassIndex).name.string;
      this.ctype.setSuper(str2.replace('/', '.'));
    }
  }
  
  public ConstantPool readConstants()
    throws IOException
  {
    return new ConstantPool(this);
  }
  
  public void readFields()
    throws IOException
  {
    int i = readUnsignedShort();
    ConstantPool localConstantPool = this.ctype.constants;
    for (int j = 0; j < i; j++)
    {
      int k = readUnsignedShort();
      int m = readUnsignedShort();
      int n = readUnsignedShort();
      Field localField = this.ctype.addField();
      localField.setName(m, localConstantPool);
      localField.setSignature(n, localConstantPool);
      localField.flags = k;
      readAttributes(localField);
    }
  }
  
  public void readFormatVersion()
    throws IOException
  {
    int i = readUnsignedShort();
    int j = readUnsignedShort();
    this.ctype.classfileFormatVersion = (i + 65536 * j);
  }
  
  public boolean readHeader()
    throws IOException
  {
    if (readInt() != -889275714) {
      return false;
    }
    readFormatVersion();
    return true;
  }
  
  public void readMethods()
    throws IOException
  {
    int i = readUnsignedShort();
    for (int j = 0; j < i; j++)
    {
      int k = readUnsignedShort();
      int m = readUnsignedShort();
      int n = readUnsignedShort();
      Method localMethod = this.ctype.addMethod(null, k);
      localMethod.setName(m);
      localMethod.setSignature(n);
      readAttributes(localMethod);
    }
  }
  
  public final void skipAttribute(int paramInt)
    throws IOException
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = (int)skip(paramInt - i);
      if (j == 0)
      {
        if (read() < 0) {
          throw new EOFException("EOF while reading class files attributes");
        }
        j = 1;
      }
      i += j;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.ClassFileInput
 * JD-Core Version:    0.7.0.1
 */