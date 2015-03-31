package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class InnerClassesAttr
  extends Attribute
{
  int count;
  short[] data;
  
  public InnerClassesAttr(ClassType paramClassType)
  {
    super("InnerClasses");
    addToFrontOf(paramClassType);
  }
  
  public InnerClassesAttr(short[] paramArrayOfShort, ClassType paramClassType)
  {
    this(paramClassType);
    this.count = ((short)(paramArrayOfShort.length >> 2));
    this.data = paramArrayOfShort;
  }
  
  public static InnerClassesAttr getFirstInnerClasses(Attribute paramAttribute)
  {
    for (;;)
    {
      if ((paramAttribute == null) || ((paramAttribute instanceof InnerClassesAttr))) {
        return (InnerClassesAttr)paramAttribute;
      }
      paramAttribute = paramAttribute.next;
    }
  }
  
  void addClass(CpoolClass paramCpoolClass, ClassType paramClassType)
  {
    int i = this.count;
    this.count = (i + 1);
    int j = i * 4;
    ConstantPool localConstantPool;
    ClassType localClassType1;
    String str;
    int k;
    label70:
    ClassType localClassType2;
    short[] arrayOfShort2;
    int m;
    int n;
    if (this.data == null)
    {
      this.data = new short[16];
      localConstantPool = paramClassType.constants;
      localClassType1 = (ClassType)paramCpoolClass.getClassType();
      str = localClassType1.getSimpleName();
      if ((str != null) && (str.length() != 0)) {
        break label191;
      }
      k = 0;
      this.data[j] = ((short)paramCpoolClass.index);
      localClassType2 = localClassType1.getDeclaringClass();
      arrayOfShort2 = this.data;
      m = j + 1;
      n = 0;
      if (localClassType2 != null) {
        break label206;
      }
    }
    for (;;)
    {
      arrayOfShort2[m] = n;
      this.data[(j + 2)] = ((short)k);
      int i1 = 0xFFFFFFDF & localClassType1.getModifiers();
      this.data[(j + 3)] = ((short)i1);
      return;
      if (j < this.data.length) {
        break;
      }
      short[] arrayOfShort1 = new short[j * 2];
      System.arraycopy(this.data, 0, arrayOfShort1, 0, j);
      this.data = arrayOfShort1;
      break;
      label191:
      k = localConstantPool.addUtf8(str).index;
      break label70;
      label206:
      n = (short)localConstantPool.addClass(localClassType2).index;
    }
  }
  
  public void assignConstants(ClassType paramClassType)
  {
    super.assignConstants(paramClassType);
  }
  
  public int getLength()
  {
    return 2 + 8 * this.count;
  }
  
  public void print(ClassTypeWriter paramClassTypeWriter)
  {
    ClassType localClassType1 = (ClassType)this.container;
    ConstantPool localConstantPool;
    int i;
    label62:
    int j;
    label78:
    CpoolClass localCpoolClass;
    label90:
    ClassType localClassType2;
    label116:
    int k;
    label139:
    String str1;
    label173:
    String str2;
    if (this.data == null)
    {
      localConstantPool = null;
      paramClassTypeWriter.print("Attribute \"");
      paramClassTypeWriter.print(getName());
      paramClassTypeWriter.print("\", length:");
      paramClassTypeWriter.print(getLength());
      paramClassTypeWriter.print(", count: ");
      paramClassTypeWriter.println(this.count);
      i = 0;
      if (i >= this.count) {
        return;
      }
      if (localConstantPool != null) {
        break label319;
      }
      j = 0;
      if ((localConstantPool != null) && (j != 0)) {
        break label336;
      }
      localCpoolClass = null;
      if ((localCpoolClass == null) || (!(localCpoolClass.clas instanceof ClassType))) {
        break label347;
      }
      localClassType2 = (ClassType)localCpoolClass.clas;
      paramClassTypeWriter.print(' ');
      if ((j != 0) || (localClassType2 == null)) {
        break label353;
      }
      k = localClassType2.getModifiers();
      paramClassTypeWriter.print(Access.toString(k, 'I'));
      paramClassTypeWriter.print(' ');
      if ((j != 0) || (localClassType2 == null)) {
        break label372;
      }
      str1 = localClassType2.getSimpleName();
      paramClassTypeWriter.print(str1);
      paramClassTypeWriter.print(" = ");
      if (localCpoolClass == null) {
        break label431;
      }
      str2 = localCpoolClass.getClassName();
      label197:
      paramClassTypeWriter.print(str2);
      paramClassTypeWriter.print("; ");
      if ((j != 0) || (localClassType2 == null)) {
        break label455;
      }
      String str3 = localClassType2.getName();
      int i1 = str3.lastIndexOf('.');
      if (i1 > 0) {
        str3 = str3.substring(i1 + 1);
      }
      int i2 = 1 + str3.lastIndexOf('$');
      if (i2 >= str3.length()) {
        break label438;
      }
      int i3 = str3.charAt(i2);
      if ((i3 < 48) || (i3 > 57)) {
        break label438;
      }
      paramClassTypeWriter.print("not a member");
    }
    for (;;)
    {
      paramClassTypeWriter.println();
      i++;
      break label62;
      localConstantPool = localClassType1.getConstants();
      break;
      label319:
      j = 0xFFFF & this.data[(i * 4)];
      break label78;
      label336:
      localCpoolClass = localConstantPool.getForcedClass(j);
      break label90;
      label347:
      localClassType2 = null;
      break label116;
      label353:
      k = 0xFFFF & this.data[(3 + i * 4)];
      break label139;
      label372:
      int m = 0xFFFF & this.data[(2 + i * 4)];
      if ((localConstantPool == null) || (m == 0))
      {
        str1 = "(Anonymous)";
        break label173;
      }
      paramClassTypeWriter.printOptionalIndex(m);
      str1 = ((CpoolUtf8)localConstantPool.getForced(m, 1)).string;
      break label173;
      label431:
      str2 = "(Unknown)";
      break label197;
      label438:
      paramClassTypeWriter.print("member of ");
      paramClassTypeWriter.print(localClassType1.getName());
      continue;
      label455:
      int n = 0xFFFF & this.data[(1 + i * 4)];
      if (n == 0)
      {
        paramClassTypeWriter.print("not a member");
      }
      else
      {
        paramClassTypeWriter.print("member of ");
        paramClassTypeWriter.print(((CpoolClass)localConstantPool.getForced(n, 7)).getStringName());
      }
    }
  }
  
  public void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    paramDataOutputStream.writeShort(this.count);
    for (int i = 0; i < this.count; i++)
    {
      paramDataOutputStream.writeShort(this.data[(i * 4)]);
      paramDataOutputStream.writeShort(this.data[(1 + i * 4)]);
      paramDataOutputStream.writeShort(this.data[(2 + i * 4)]);
      paramDataOutputStream.writeShort(this.data[(3 + i * 4)]);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.InnerClassesAttr
 * JD-Core Version:    0.7.0.1
 */