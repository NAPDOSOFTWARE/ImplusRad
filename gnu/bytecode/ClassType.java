package gnu.bytecode;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.Externalizable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class ClassType
  extends ObjectType
  implements AttrContainer, Externalizable, Member
{
  public static final int JDK_1_1_VERSION = 2949123;
  public static final int JDK_1_2_VERSION = 3014656;
  public static final int JDK_1_3_VERSION = 3080192;
  public static final int JDK_1_4_VERSION = 3145728;
  public static final int JDK_1_5_VERSION = 3211264;
  public static final int JDK_1_6_VERSION = 3276800;
  public static final int JDK_1_7_VERSION = 3342336;
  public static final ClassType[] noClasses = new ClassType[0];
  int Code_name_index;
  int ConstantValue_name_index;
  int LineNumberTable_name_index;
  int LocalVariableTable_name_index;
  int access_flags;
  Attribute attributes;
  int classfileFormatVersion = 2949123;
  ConstantPool constants;
  public Method constructor;
  boolean emitDebugInfo = true;
  Member enclosingMember;
  Field fields;
  int fields_count;
  ClassType firstInnerClass;
  int[] interfaceIndexes;
  ClassType[] interfaces;
  Field last_field;
  Method last_method;
  Method methods;
  int methods_count;
  ClassType nextInnerClass;
  SourceDebugExtAttr sourceDbgExt;
  ClassType superClass;
  int superClassIndex = -1;
  int thisClassIndex;
  
  public ClassType() {}
  
  public ClassType(String paramString)
  {
    setName(paramString);
  }
  
  public static ClassType make(String paramString)
  {
    return (ClassType)Type.getType(paramString);
  }
  
  public static ClassType make(String paramString, ClassType paramClassType)
  {
    ClassType localClassType = make(paramString);
    if (localClassType.superClass == null) {
      localClassType.setSuper(paramClassType);
    }
    return localClassType;
  }
  
  public static byte[] to_utf8(String paramString)
  {
    if (paramString == null)
    {
      arrayOfByte = null;
      return arrayOfByte;
    }
    int i = paramString.length();
    int j = 0;
    int k = 0;
    if (k < i)
    {
      int i7 = paramString.charAt(k);
      if ((i7 > 0) && (i7 <= 127)) {
        j++;
      }
      for (;;)
      {
        k++;
        break;
        if (i7 <= 2047) {
          j += 2;
        } else {
          j += 3;
        }
      }
    }
    byte[] arrayOfByte = new byte[j];
    int m = 0;
    int n = 0;
    label83:
    int i1;
    int i4;
    if (m < i)
    {
      i1 = paramString.charAt(m);
      if ((i1 <= 0) || (i1 > 127)) {
        break label133;
      }
      i4 = n + 1;
      arrayOfByte[n] = ((byte)i1);
    }
    for (;;)
    {
      m++;
      n = i4;
      break label83;
      break;
      label133:
      if (i1 <= 2047)
      {
        int i5 = n + 1;
        arrayOfByte[n] = ((byte)(0xC0 | 0x1F & i1 >> 6));
        int i6 = i5 + 1;
        arrayOfByte[i5] = ((byte)(0x80 | 0x3F & i1 >> 0));
        i4 = i6;
      }
      else
      {
        int i2 = n + 1;
        arrayOfByte[n] = ((byte)(0xE0 | 0xF & i1 >> 12));
        int i3 = i2 + 1;
        arrayOfByte[i2] = ((byte)(0x80 | 0x3F & i1 >> 6));
        i4 = i3 + 1;
        arrayOfByte[i3] = ((byte)(0x80 | 0x3F & i1 >> 0));
      }
    }
  }
  
  void addEnclosingMember()
  {
    for (;;)
    {
      Class localClass2;
      try
      {
        int i = this.flags;
        if ((i & 0x18) != 16) {
          return;
        }
        Class localClass1 = getReflectClass();
        this.flags = (0x8 | this.flags);
        localClass2 = localClass1.getEnclosingClass();
        if (localClass2 == null) {
          continue;
        }
        if (localClass1.isMemberClass()) {
          break label106;
        }
        java.lang.reflect.Method localMethod = localClass1.getEnclosingMethod();
        if (localMethod != null)
        {
          this.enclosingMember = addMethod(localMethod);
          continue;
        }
        localConstructor = localClass1.getEnclosingConstructor();
      }
      finally {}
      Constructor localConstructor;
      if (localConstructor != null) {
        this.enclosingMember = addMethod(localConstructor);
      } else {
        label106:
        this.enclosingMember = ((ClassType)Type.make(localClass2));
      }
    }
  }
  
  public Field addField()
  {
    return new Field(this);
  }
  
  public Field addField(String paramString)
  {
    Field localField = new Field(this);
    localField.setName(paramString);
    return localField;
  }
  
  public final Field addField(String paramString, Type paramType)
  {
    Field localField = new Field(this);
    localField.setName(paramString);
    localField.setType(paramType);
    return localField;
  }
  
  public final Field addField(String paramString, Type paramType, int paramInt)
  {
    Field localField = addField(paramString, paramType);
    localField.flags = paramInt;
    return localField;
  }
  
  /* Error */
  public void addFields()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 115	gnu/bytecode/ClassType:getReflectClass	()Ljava/lang/Class;
    //   6: astore_2
    //   7: aload_2
    //   8: invokevirtual 168	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   11: astore 9
    //   13: aload 9
    //   15: astore 4
    //   17: aload 4
    //   19: arraylength
    //   20: istore 5
    //   22: iconst_0
    //   23: istore 6
    //   25: iload 6
    //   27: iload 5
    //   29: if_icmpge +73 -> 102
    //   32: aload 4
    //   34: iload 6
    //   36: aaload
    //   37: astore 7
    //   39: ldc 170
    //   41: aload 7
    //   43: invokevirtual 176	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   46: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifeq +14 -> 63
    //   52: aload_0
    //   53: bipush 32
    //   55: aload_0
    //   56: getfield 111	gnu/bytecode/ClassType:flags	I
    //   59: ior
    //   60: putfield 111	gnu/bytecode/ClassType:flags	I
    //   63: aload_0
    //   64: aload 7
    //   66: invokevirtual 176	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   69: aload 7
    //   71: invokevirtual 182	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   74: invokestatic 144	gnu/bytecode/Type:make	(Ljava/lang/Class;)Lgnu/bytecode/Type;
    //   77: aload 7
    //   79: invokevirtual 185	java/lang/reflect/Field:getModifiers	()I
    //   82: invokevirtual 187	gnu/bytecode/ClassType:addField	(Ljava/lang/String;Lgnu/bytecode/Type;I)Lgnu/bytecode/Field;
    //   85: pop
    //   86: iinc 6 1
    //   89: goto -64 -> 25
    //   92: astore_3
    //   93: aload_2
    //   94: invokevirtual 190	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   97: astore 4
    //   99: goto -82 -> 17
    //   102: aload_0
    //   103: iconst_1
    //   104: aload_0
    //   105: getfield 111	gnu/bytecode/ClassType:flags	I
    //   108: ior
    //   109: putfield 111	gnu/bytecode/ClassType:flags	I
    //   112: aload_0
    //   113: monitorexit
    //   114: return
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	ClassType
    //   115	4	1	localObject	Object
    //   6	88	2	localClass	Class
    //   92	1	3	localSecurityException	SecurityException
    //   15	83	4	arrayOfField1	java.lang.reflect.Field[]
    //   20	10	5	i	int
    //   23	64	6	j	int
    //   37	41	7	localField	java.lang.reflect.Field
    //   11	3	9	arrayOfField2	java.lang.reflect.Field[]
    // Exception table:
    //   from	to	target	type
    //   7	13	92	java/lang/SecurityException
    //   2	7	115	finally
    //   7	13	115	finally
    //   17	22	115	finally
    //   32	63	115	finally
    //   63	86	115	finally
    //   93	99	115	finally
    //   102	112	115	finally
  }
  
  public void addInterface(ClassType paramClassType)
  {
    int i;
    if ((this.interfaces == null) || (this.interfaces.length == 0)) {
      i = 0;
    }
    ClassType[] arrayOfClassType;
    for (this.interfaces = new ClassType[1];; this.interfaces = arrayOfClassType)
    {
      this.interfaces[i] = paramClassType;
      return;
      i = this.interfaces.length;
      int j = i;
      do
      {
        j--;
        if (j < 0) {
          break;
        }
      } while (this.interfaces[j] != paramClassType);
      return;
      arrayOfClassType = new ClassType[i + 1];
      System.arraycopy(this.interfaces, 0, arrayOfClassType, 0, i);
    }
  }
  
  public void addMemberClass(ClassType paramClassType)
  {
    Object localObject = null;
    for (ClassType localClassType = this.firstInnerClass; localClassType != null; localClassType = localClassType.nextInnerClass)
    {
      if (localClassType == paramClassType) {
        return;
      }
      localObject = localClassType;
    }
    if (localObject == null)
    {
      this.firstInnerClass = paramClassType;
      return;
    }
    localObject.nextInnerClass = paramClassType;
  }
  
  /* Error */
  public void addMemberClasses()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 111	gnu/bytecode/ClassType:flags	I
    //   6: istore_2
    //   7: iload_2
    //   8: bipush 20
    //   10: iand
    //   11: bipush 16
    //   13: if_icmpeq +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: invokevirtual 115	gnu/bytecode/ClassType:getReflectClass	()Ljava/lang/Class;
    //   23: astore_3
    //   24: aload_0
    //   25: iconst_4
    //   26: aload_0
    //   27: getfield 111	gnu/bytecode/ClassType:flags	I
    //   30: ior
    //   31: putfield 111	gnu/bytecode/ClassType:flags	I
    //   34: aload_3
    //   35: invokevirtual 209	java/lang/Class:getClasses	()[Ljava/lang/Class;
    //   38: astore 4
    //   40: aload 4
    //   42: arraylength
    //   43: istore 5
    //   45: iload 5
    //   47: ifle -31 -> 16
    //   50: iconst_0
    //   51: istore 6
    //   53: iload 6
    //   55: iload 5
    //   57: if_icmpge -41 -> 16
    //   60: aload_0
    //   61: aload 4
    //   63: iload 6
    //   65: aaload
    //   66: invokestatic 144	gnu/bytecode/Type:make	(Ljava/lang/Class;)Lgnu/bytecode/Type;
    //   69: checkcast 2	gnu/bytecode/ClassType
    //   72: invokevirtual 211	gnu/bytecode/ClassType:addMemberClass	(Lgnu/bytecode/ClassType;)V
    //   75: iinc 6 1
    //   78: goto -25 -> 53
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	ClassType
    //   81	4	1	localObject	Object
    //   6	5	2	i	int
    //   23	12	3	localClass	Class
    //   38	24	4	arrayOfClass	Class[]
    //   43	15	5	j	int
    //   51	25	6	k	int
    // Exception table:
    //   from	to	target	type
    //   2	7	81	finally
    //   19	45	81	finally
    //   60	75	81	finally
  }
  
  Method addMethod()
  {
    return new Method(this, 0);
  }
  
  public Method addMethod(String paramString)
  {
    return addMethod(paramString, 0);
  }
  
  public Method addMethod(String paramString, int paramInt)
  {
    Method localMethod = new Method(this, paramInt);
    localMethod.setName(paramString);
    return localMethod;
  }
  
  /* Error */
  public Method addMethod(String paramString, int paramInt, Type[] paramArrayOfType, Type paramType)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: aload_3
    //   5: invokevirtual 227	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;[Lgnu/bytecode/Type;)Lgnu/bytecode/Method;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnull +40 -> 52
    //   15: aload 4
    //   17: aload 6
    //   19: invokevirtual 231	gnu/bytecode/Method:getReturnType	()Lgnu/bytecode/Type;
    //   22: invokevirtual 234	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +27 -> 52
    //   28: aload 6
    //   30: getfield 236	gnu/bytecode/Method:access_flags	I
    //   33: istore 9
    //   35: iload 9
    //   37: iload_2
    //   38: iand
    //   39: iload_2
    //   40: if_icmpne +12 -> 52
    //   43: aload 6
    //   45: astore 8
    //   47: aload_0
    //   48: monitorexit
    //   49: aload 8
    //   51: areturn
    //   52: aload_0
    //   53: aload_1
    //   54: iload_2
    //   55: invokevirtual 221	gnu/bytecode/ClassType:addMethod	(Ljava/lang/String;I)Lgnu/bytecode/Method;
    //   58: astore 7
    //   60: aload 7
    //   62: aload_3
    //   63: putfield 240	gnu/bytecode/Method:arg_types	[Lgnu/bytecode/Type;
    //   66: aload 7
    //   68: aload 4
    //   70: putfield 244	gnu/bytecode/Method:return_type	Lgnu/bytecode/Type;
    //   73: aload 7
    //   75: astore 8
    //   77: goto -30 -> 47
    //   80: astore 5
    //   82: aload_0
    //   83: monitorexit
    //   84: aload 5
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	ClassType
    //   0	87	1	paramString	String
    //   0	87	2	paramInt	int
    //   0	87	3	paramArrayOfType	Type[]
    //   0	87	4	paramType	Type
    //   80	5	5	localObject1	Object
    //   8	36	6	localMethod1	Method
    //   58	16	7	localMethod2	Method
    //   45	31	8	localObject2	Object
    //   33	6	9	i	int
    // Exception table:
    //   from	to	target	type
    //   2	10	80	finally
    //   15	35	80	finally
    //   52	73	80	finally
  }
  
  public Method addMethod(String paramString1, String paramString2, int paramInt)
  {
    Method localMethod = addMethod(paramString1, paramInt);
    localMethod.setSignature(paramString2);
    return localMethod;
  }
  
  public Method addMethod(String paramString, Type[] paramArrayOfType, Type paramType, int paramInt)
  {
    return addMethod(paramString, paramInt, paramArrayOfType, paramType);
  }
  
  public Method addMethod(Constructor paramConstructor)
  {
    Class[] arrayOfClass = paramConstructor.getParameterTypes();
    int i = paramConstructor.getModifiers();
    int j = arrayOfClass.length;
    Type[] arrayOfType = new Type[j];
    for (;;)
    {
      j--;
      if (j < 0) {
        break;
      }
      arrayOfType[j] = Type.make(arrayOfClass[j]);
    }
    return addMethod("<init>", i, arrayOfType, Type.voidType);
  }
  
  public Method addMethod(java.lang.reflect.Method paramMethod)
  {
    int i = paramMethod.getModifiers();
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int j = arrayOfClass.length;
    Type[] arrayOfType = new Type[j];
    for (;;)
    {
      j--;
      if (j < 0) {
        break;
      }
      arrayOfType[j] = Type.make(arrayOfClass[j]);
    }
    Type localType = Type.make(paramMethod.getReturnType());
    return addMethod(paramMethod.getName(), i, arrayOfType, localType);
  }
  
  public void addMethods(Class paramClass)
  {
    int j;
    try
    {
      this.flags = (0x2 | this.flags);
      try
      {
        java.lang.reflect.Method[] arrayOfMethod2 = paramClass.getDeclaredMethods();
        arrayOfMethod1 = arrayOfMethod2;
      }
      catch (SecurityException localSecurityException1)
      {
        java.lang.reflect.Method localMethod;
        for (;;)
        {
          int i;
          java.lang.reflect.Method[] arrayOfMethod1 = paramClass.getMethods();
        }
        addMethod(localMethod);
      }
      i = arrayOfMethod1.length;
      j = 0;
      if (j < i)
      {
        localMethod = arrayOfMethod1[j];
        if (!localMethod.getDeclaringClass().equals(paramClass)) {
          break label155;
        }
      }
      try
      {
        Constructor[] arrayOfConstructor2 = paramClass.getDeclaredConstructors();
        arrayOfConstructor1 = arrayOfConstructor2;
      }
      catch (SecurityException localSecurityException2)
      {
        for (;;)
        {
          int k;
          Constructor[] arrayOfConstructor1 = paramClass.getConstructors();
        }
        addMethod(localConstructor);
      }
    }
    finally {}
    k = arrayOfConstructor1.length;
    for (int m = 0;; m++)
    {
      Constructor localConstructor;
      if (m < k)
      {
        localConstructor = arrayOfConstructor1[m];
        if (!localConstructor.getDeclaringClass().equals(paramClass)) {}
      }
      else
      {
        return;
        label155:
        j++;
        break;
      }
    }
  }
  
  public final void addModifiers(int paramInt)
  {
    this.access_flags = (paramInt | this.access_flags);
  }
  
  public Method checkSingleAbstractMethod()
  {
    Method[] arrayOfMethod = getAbstractMethods();
    int i = arrayOfMethod.length;
    Object localObject = null;
    int j = 0;
    Method localMethod1;
    if (j < i)
    {
      localMethod1 = arrayOfMethod[j];
      Method localMethod2 = getMethod(localMethod1.getName(), localMethod1.getParameterTypes());
      if ((localMethod2 == null) || (localMethod2.isAbstract())) {}
    }
    for (;;)
    {
      j++;
      break;
      if (localObject != null)
      {
        localObject = null;
        return localObject;
      }
      localObject = localMethod1;
    }
  }
  
  public void cleanupAfterCompilation()
  {
    for (Method localMethod = this.methods; localMethod != null; localMethod = localMethod.getNext()) {
      localMethod.cleanupAfterCompilation();
    }
    this.constants = null;
    this.attributes = null;
    this.sourceDbgExt = null;
  }
  
  public int compare(Type paramType)
  {
    int i = -1;
    if (paramType == nullType) {}
    do
    {
      ClassType localClassType;
      do
      {
        do
        {
          return 1;
          if (!(paramType instanceof ClassType)) {
            return swappedCompareResult(paramType.compare(this));
          }
          String str = getName();
          if ((str != null) && (str.equals(paramType.getName()))) {
            return 0;
          }
          localClassType = (ClassType)paramType;
          if (isSubclass(localClassType)) {
            return i;
          }
        } while (localClassType.isSubclass(this));
        if (this == toStringType)
        {
          if (localClassType == Type.javalangObjectType) {}
          for (;;)
          {
            return i;
            i = 1;
          }
        }
        if (localClassType != toStringType) {
          break;
        }
      } while (this == Type.javalangObjectType);
      return i;
      if (isInterface())
      {
        if (localClassType == Type.javalangObjectType) {}
        for (;;)
        {
          return i;
          i = -2;
        }
      }
      if (!localClassType.isInterface()) {
        break;
      }
    } while (this == Type.javalangObjectType);
    return -2;
    return -3;
  }
  
  public final int countMethods(Filter paramFilter, int paramInt)
  {
    Vector localVector = new Vector();
    getMethods(paramFilter, paramInt, localVector);
    return localVector.size();
  }
  
  public void doFixups()
  {
    if (this.constants == null) {
      this.constants = new ConstantPool();
    }
    if (this.thisClassIndex == 0) {
      this.thisClassIndex = this.constants.addClass(this).index;
    }
    if (this.superClass == this) {
      setSuper((ClassType)null);
    }
    if (this.superClassIndex < 0) {
      if (this.superClass != null) {
        break label148;
      }
    }
    label148:
    for (int m = 0;; m = this.constants.addClass(this.superClass).index)
    {
      this.superClassIndex = m;
      if ((this.interfaces == null) || (this.interfaceIndexes != null)) {
        break;
      }
      int j = this.interfaces.length;
      this.interfaceIndexes = new int[j];
      for (int k = 0; k < j; k++) {
        this.interfaceIndexes[k] = this.constants.addClass(this.interfaces[k]).index;
      }
    }
    for (Field localField = this.fields; localField != null; localField = localField.next) {
      localField.assign_constants(this);
    }
    for (Method localMethod = this.methods; localMethod != null; localMethod = localMethod.next) {
      localMethod.assignConstants();
    }
    if ((this.enclosingMember instanceof Method))
    {
      EnclosingMethodAttr localEnclosingMethodAttr = EnclosingMethodAttr.getFirstEnclosingMethod(getAttributes());
      if (localEnclosingMethodAttr == null) {
        localEnclosingMethodAttr = new EnclosingMethodAttr(this);
      }
      localEnclosingMethodAttr.method = ((Method)this.enclosingMember);
    }
    for (;;)
    {
      for (ClassType localClassType = this.firstInnerClass; localClassType != null; localClassType = localClassType.nextInnerClass) {
        this.constants.addClass(localClassType);
      }
      if ((this.enclosingMember instanceof ClassType)) {
        this.constants.addClass((ClassType)this.enclosingMember);
      }
    }
    InnerClassesAttr localInnerClassesAttr = InnerClassesAttr.getFirstInnerClasses(getAttributes());
    if (localInnerClassesAttr != null) {
      localInnerClassesAttr.setSkipped(true);
    }
    Attribute.assignConstants(this, this);
    int i = 1;
    if (i <= this.constants.count)
    {
      CpoolEntry localCpoolEntry = this.constants.pool[i];
      if (!(localCpoolEntry instanceof CpoolClass)) {}
      for (;;)
      {
        i++;
        break;
        CpoolClass localCpoolClass = (CpoolClass)localCpoolEntry;
        if (((localCpoolClass.clas instanceof ClassType)) && (((ClassType)localCpoolClass.clas).getEnclosingMember() != null))
        {
          if (localInnerClassesAttr == null) {
            localInnerClassesAttr = new InnerClassesAttr(this);
          }
          localInnerClassesAttr.addClass(localCpoolClass, this);
        }
      }
    }
    if (localInnerClassesAttr != null)
    {
      localInnerClassesAttr.setSkipped(false);
      localInnerClassesAttr.assignConstants(this);
    }
  }
  
  public Method[] getAbstractMethods()
  {
    return getMethods(AbstractMethodFilter.instance, 2);
  }
  
  public final Attribute getAttributes()
  {
    return this.attributes;
  }
  
  public short getClassfileMajorVersion()
  {
    return (short)(this.classfileFormatVersion >> 16);
  }
  
  public short getClassfileMinorVersion()
  {
    return (short)(0xFFFF & this.classfileFormatVersion);
  }
  
  public int getClassfileVersion()
  {
    return this.classfileFormatVersion;
  }
  
  public final CpoolEntry getConstant(int paramInt)
  {
    if ((this.constants == null) || (this.constants.pool == null) || (paramInt > this.constants.count)) {
      return null;
    }
    return this.constants.pool[paramInt];
  }
  
  public final ConstantPool getConstants()
  {
    return this.constants;
  }
  
  public ClassType getDeclaredClass(String paramString)
  {
    addMemberClasses();
    for (ClassType localClassType = this.firstInnerClass; localClassType != null; localClassType = localClassType.nextInnerClass) {
      if (paramString.equals(localClassType.getSimpleName())) {
        return localClassType;
      }
    }
    return null;
  }
  
  public Field getDeclaredField(String paramString)
  {
    for (Field localField = getFields(); localField != null; localField = localField.next) {
      if (paramString.equals(localField.name)) {
        return localField;
      }
    }
    return null;
  }
  
  public Method getDeclaredMethod(String paramString, int paramInt)
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        if (("<init>".equals(paramString)) && (hasOuterLink()))
        {
          i = 1;
          localMethod = getDeclaredMethods();
          if (localMethod == null) {
            break;
          }
          if ((!paramString.equals(localMethod.getName())) || (paramInt + i != localMethod.getParameterTypes().length)) {
            break label139;
          }
          if (localObject1 == null) {
            break label136;
          }
          throw new Error("ambiguous call to getDeclaredMethod(\"" + paramString + "\", " + paramInt + ")\n - " + localObject1 + "\n - " + localMethod);
        }
      }
      finally {}
      int i = 0;
      continue;
      label136:
      localObject1 = localMethod;
      label139:
      Method localMethod = localMethod.next;
    }
    return localObject1;
  }
  
  public Method getDeclaredMethod(String paramString, Type[] paramArrayOfType)
  {
    int i;
    Method localMethod;
    if (("<init>".equals(paramString)) && (hasOuterLink()))
    {
      i = 1;
      localMethod = getDeclaredMethods();
      label25:
      if (localMethod == null) {
        break label154;
      }
      if (paramString.equals(localMethod.getName())) {
        break label57;
      }
    }
    label57:
    int j;
    do
    {
      Type[] arrayOfType;
      do
      {
        localMethod = localMethod.next;
        break label25;
        i = 0;
        break;
        arrayOfType = localMethod.getParameterTypes();
        if ((paramArrayOfType == null) || ((paramArrayOfType == arrayOfType) && (i == 0))) {
          return localMethod;
        }
        j = paramArrayOfType.length;
      } while (j != arrayOfType.length - i);
      Type localType1;
      Type localType2;
      do
      {
        j--;
        if (j < 0) {
          break;
        }
        localType1 = arrayOfType[(j + i)];
        localType2 = paramArrayOfType[j];
      } while ((localType1 == localType2) || (localType2 == null) || (localType1.getSignature().equals(localType2.getSignature())));
    } while (j >= 0);
    return localMethod;
    label154:
    return null;
  }
  
  public final Method getDeclaredMethods()
  {
    try
    {
      if ((0x12 & this.flags) == 16) {
        addMethods(getReflectClass());
      }
      Method localMethod = this.methods;
      return localMethod;
    }
    finally {}
  }
  
  public ClassType getDeclaringClass()
  {
    addEnclosingMember();
    if ((this.enclosingMember instanceof ClassType)) {
      return (ClassType)this.enclosingMember;
    }
    return null;
  }
  
  public Member getEnclosingMember()
  {
    addEnclosingMember();
    return this.enclosingMember;
  }
  
  public Field getField(String paramString)
  {
    return getField(paramString, 1);
  }
  
  public Field getField(String paramString, int paramInt)
  {
    Object localObject1 = this;
    label116:
    for (;;)
    {
      try
      {
        Field localField1 = ((ClassType)localObject1).getDeclaredField(paramString);
        Object localObject3;
        if (localField1 != null) {
          if (paramInt != -1)
          {
            int j = localField1.getModifiers();
            if ((j & paramInt) == 0) {}
          }
          else
          {
            localObject3 = localField1;
            return localObject3;
          }
        }
        ClassType[] arrayOfClassType = ((ClassType)localObject1).getInterfaces();
        int i;
        if (arrayOfClassType != null)
        {
          i = 0;
          if (i < arrayOfClassType.length)
          {
            Field localField2 = arrayOfClassType[i].getField(paramString, paramInt);
            if (localField2 == null) {
              break label116;
            }
            localObject3 = localField2;
            continue;
          }
        }
        ClassType localClassType = ((ClassType)localObject1).getSuperclass();
        localObject1 = localClassType;
        if (localObject1 == null)
        {
          localObject3 = null;
          continue;
          i++;
        }
      }
      finally {}
    }
  }
  
  public final int getFieldCount()
  {
    return this.fields_count;
  }
  
  public final Field getFields()
  {
    try
    {
      if ((0x11 & this.flags) == 16) {
        addFields();
      }
      Field localField = this.fields;
      return localField;
    }
    finally {}
  }
  
  public ClassType[] getInterfaces()
  {
    try
    {
      if ((this.interfaces == null) && ((0x10 & this.flags) != 0) && (getReflectClass() != null))
      {
        Class[] arrayOfClass = this.reflectClass.getInterfaces();
        int i = arrayOfClass.length;
        if (i == 0) {}
        for (ClassType[] arrayOfClassType2 = noClasses;; arrayOfClassType2 = new ClassType[i])
        {
          this.interfaces = arrayOfClassType2;
          for (int j = 0; j < i; j++) {
            this.interfaces[j] = ((ClassType)Type.make(arrayOfClass[j]));
          }
        }
      }
      ClassType[] arrayOfClassType1 = this.interfaces;
      return arrayOfClassType1;
    }
    finally {}
  }
  
  public Method[] getMatchingMethods(String paramString, Type[] paramArrayOfType, int paramInt)
  {
    int i = 0;
    Vector localVector = new Vector(10);
    Method localMethod = this.methods;
    if (localMethod != null)
    {
      if (!paramString.equals(localMethod.getName())) {}
      for (;;)
      {
        localMethod = localMethod.getNext();
        break;
        if (((paramInt & 0x8) == (0x8 & localMethod.access_flags)) && ((paramInt & 0x1) <= (0x1 & localMethod.access_flags)) && (localMethod.arg_types.length == paramArrayOfType.length))
        {
          i++;
          localVector.addElement(localMethod);
        }
      }
    }
    Method[] arrayOfMethod = new Method[i];
    localVector.copyInto(arrayOfMethod);
    return arrayOfMethod;
  }
  
  /* Error */
  public Method getMethod(String paramString, Type[] paramArrayOfType)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: astore_3
    //   4: aload_3
    //   5: aload_1
    //   6: aload_2
    //   7: invokevirtual 227	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;[Lgnu/bytecode/Type;)Lgnu/bytecode/Method;
    //   10: astore 5
    //   12: aload 5
    //   14: astore 6
    //   16: aload 6
    //   18: ifnull +8 -> 26
    //   21: aload_0
    //   22: monitorexit
    //   23: aload 6
    //   25: areturn
    //   26: aload_3
    //   27: invokevirtual 524	gnu/bytecode/ClassType:getSuperclass	()Lgnu/bytecode/ClassType;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnonnull -28 -> 4
    //   35: aload_0
    //   36: astore 7
    //   38: aload 7
    //   40: invokevirtual 521	gnu/bytecode/ClassType:getInterfaces	()[Lgnu/bytecode/ClassType;
    //   43: astore 8
    //   45: aload 8
    //   47: ifnull +37 -> 84
    //   50: iconst_0
    //   51: istore 10
    //   53: iload 10
    //   55: aload 8
    //   57: arraylength
    //   58: if_icmpge +26 -> 84
    //   61: aload 8
    //   63: iload 10
    //   65: aaload
    //   66: aload_1
    //   67: aload_2
    //   68: invokevirtual 227	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;[Lgnu/bytecode/Type;)Lgnu/bytecode/Method;
    //   71: astore 6
    //   73: aload 6
    //   75: ifnonnull -54 -> 21
    //   78: iinc 10 1
    //   81: goto -28 -> 53
    //   84: aload 7
    //   86: invokevirtual 524	gnu/bytecode/ClassType:getSuperclass	()Lgnu/bytecode/ClassType;
    //   89: astore 9
    //   91: aload 9
    //   93: astore 7
    //   95: aload 7
    //   97: ifnonnull -59 -> 38
    //   100: aconst_null
    //   101: astore 6
    //   103: goto -82 -> 21
    //   106: astore 4
    //   108: aload_0
    //   109: monitorexit
    //   110: aload 4
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	ClassType
    //   0	113	1	paramString	String
    //   0	113	2	paramArrayOfType	Type[]
    //   3	29	3	localClassType1	ClassType
    //   106	5	4	localObject1	Object
    //   10	3	5	localMethod1	Method
    //   14	88	6	localMethod2	Method
    //   36	60	7	localObject2	Object
    //   43	19	8	arrayOfClassType	ClassType[]
    //   89	3	9	localClassType2	ClassType
    //   51	28	10	i	int
    // Exception table:
    //   from	to	target	type
    //   4	12	106	finally
    //   26	31	106	finally
    //   38	45	106	finally
    //   53	73	106	finally
    //   84	91	106	finally
  }
  
  public Method getMethod(java.lang.reflect.Method paramMethod)
  {
    String str = paramMethod.getName();
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    Type[] arrayOfType = new Type[arrayOfClass.length];
    int i = arrayOfClass.length;
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      arrayOfType[i] = Type.make(arrayOfClass[i]);
    }
    return addMethod(str, paramMethod.getModifiers(), arrayOfType, Type.make(paramMethod.getReturnType()));
  }
  
  public final int getMethodCount()
  {
    return this.methods_count;
  }
  
  public int getMethods(Filter paramFilter, int paramInt, List<Method> paramList)
  {
    int i = 0;
    Object localObject = null;
    for (ClassType localClassType = this;; localClassType = localClassType.getSuperclass())
    {
      if (localClassType != null)
      {
        String str = localClassType.getPackageName();
        Method localMethod = localClassType.getDeclaredMethods();
        if (localMethod != null)
        {
          int k;
          if (localClassType != this)
          {
            k = localMethod.getModifiers();
            if ((k & 0x2) == 0) {}
          }
          for (;;)
          {
            localMethod = localMethod.getNext();
            break;
            if (((k & 0x5) != 0) || (str.equals(localObject))) {
              if (paramFilter.select(localMethod))
              {
                if (paramList != null) {
                  paramList.add(localMethod);
                }
                i++;
              }
            }
          }
        }
        localObject = str;
        if (paramInt != 0) {}
      }
      else
      {
        return i;
      }
      if (paramInt > 1)
      {
        ClassType[] arrayOfClassType = localClassType.getInterfaces();
        if (arrayOfClassType != null) {
          for (int j = 0; j < arrayOfClassType.length; j++) {
            i += arrayOfClassType[j].getMethods(paramFilter, paramInt, paramList);
          }
        }
      }
    }
  }
  
  public int getMethods(Filter paramFilter, int paramInt1, Method[] paramArrayOfMethod, int paramInt2)
  {
    Vector localVector = new Vector();
    getMethods(paramFilter, paramInt1, localVector);
    int i = localVector.size();
    for (int j = 0; j < i; j++) {
      paramArrayOfMethod[(paramInt2 + j)] = ((Method)localVector.elementAt(j));
    }
    return i;
  }
  
  public final Method getMethods()
  {
    return this.methods;
  }
  
  public Method[] getMethods(Filter paramFilter, int paramInt)
  {
    Vector localVector = new Vector();
    getMethods(paramFilter, paramInt, localVector);
    int i = localVector.size();
    Method[] arrayOfMethod = new Method[i];
    for (int j = 0; j < i; j++) {
      arrayOfMethod[j] = ((Method)localVector.elementAt(j));
    }
    return arrayOfMethod;
  }
  
  public Method[] getMethods(Filter paramFilter, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return getMethods(paramFilter, i);
    }
  }
  
  public final int getModifiers()
  {
    try
    {
      if ((this.access_flags == 0) && ((0x10 & this.flags) != 0) && (getReflectClass() != null)) {
        this.access_flags = this.reflectClass.getModifiers();
      }
      int i = this.access_flags;
      return i;
    }
    finally {}
  }
  
  public ClassType getOuterLinkType()
  {
    if (!hasOuterLink()) {
      return null;
    }
    return (ClassType)getDeclaredField("this$0").getType();
  }
  
  public String getPackageName()
  {
    String str = getName();
    int i = str.lastIndexOf('.');
    if (i < 0) {
      return "";
    }
    return str.substring(0, i);
  }
  
  /* Error */
  public String getSimpleName()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: bipush 16
    //   4: aload_0
    //   5: getfield 111	gnu/bytecode/ClassType:flags	I
    //   8: iand
    //   9: ifeq +32 -> 41
    //   12: aload_0
    //   13: invokevirtual 115	gnu/bytecode/ClassType:getReflectClass	()Ljava/lang/Class;
    //   16: astore 9
    //   18: aload 9
    //   20: ifnull +21 -> 41
    //   23: aload_0
    //   24: getfield 533	gnu/bytecode/ClassType:reflectClass	Ljava/lang/Class;
    //   27: invokevirtual 586	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   30: astore 11
    //   32: aload 11
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: areturn
    //   39: astore 10
    //   41: aload_0
    //   42: invokevirtual 334	gnu/bytecode/ClassType:getName	()Ljava/lang/String;
    //   45: astore_2
    //   46: aload_2
    //   47: bipush 46
    //   49: invokevirtual 577	java/lang/String:lastIndexOf	(I)I
    //   52: istore_3
    //   53: iload_3
    //   54: ifle +11 -> 65
    //   57: aload_2
    //   58: iload_3
    //   59: iconst_1
    //   60: iadd
    //   61: invokevirtual 589	java/lang/String:substring	(I)Ljava/lang/String;
    //   64: astore_2
    //   65: aload_2
    //   66: bipush 36
    //   68: invokevirtual 577	java/lang/String:lastIndexOf	(I)I
    //   71: istore 4
    //   73: iload 4
    //   75: iflt -40 -> 35
    //   78: aload_2
    //   79: invokevirtual 103	java/lang/String:length	()I
    //   82: istore 5
    //   84: iload 4
    //   86: iconst_1
    //   87: iadd
    //   88: istore 6
    //   90: iload 6
    //   92: iload 5
    //   94: if_icmpge +31 -> 125
    //   97: aload_2
    //   98: iload 6
    //   100: invokevirtual 107	java/lang/String:charAt	(I)C
    //   103: istore 7
    //   105: iload 7
    //   107: bipush 48
    //   109: if_icmplt +16 -> 125
    //   112: iload 7
    //   114: bipush 57
    //   116: if_icmpgt +9 -> 125
    //   119: iinc 6 1
    //   122: goto -32 -> 90
    //   125: aload_2
    //   126: iload 6
    //   128: invokevirtual 589	java/lang/String:substring	(I)Ljava/lang/String;
    //   131: astore 8
    //   133: aload 8
    //   135: astore_2
    //   136: goto -101 -> 35
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	ClassType
    //   139	4	1	localObject1	Object
    //   34	102	2	localObject2	Object
    //   52	9	3	i	int
    //   71	17	4	j	int
    //   82	13	5	k	int
    //   88	39	6	m	int
    //   103	14	7	n	int
    //   131	3	8	str1	String
    //   16	3	9	localClass	Class
    //   39	1	10	localThrowable	java.lang.Throwable
    //   30	3	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   23	32	39	java/lang/Throwable
    //   2	18	139	finally
    //   23	32	139	finally
    //   41	53	139	finally
    //   57	65	139	finally
    //   65	73	139	finally
    //   78	84	139	finally
    //   97	105	139	finally
    //   125	133	139	finally
  }
  
  public final boolean getStaticFlag()
  {
    return (0x8 & getModifiers()) != 0;
  }
  
  public ClassType getSuperclass()
  {
    try
    {
      if ((this.superClass == null) && (!isInterface()) && (!"java.lang.Object".equals(getName())) && ((0x10 & this.flags) != 0) && (getReflectClass() != null)) {
        this.superClass = ((ClassType)make(this.reflectClass.getSuperclass()));
      }
      ClassType localClassType = this.superClass;
      return localClassType;
    }
    finally {}
  }
  
  public final boolean hasOuterLink()
  {
    getFields();
    return (0x20 & this.flags) != 0;
  }
  
  public final boolean implementsInterface(ClassType paramClassType)
  {
    if (this == paramClassType) {}
    ClassType localClassType;
    do
    {
      return true;
      localClassType = getSuperclass();
    } while ((localClassType != null) && (localClassType.implementsInterface(paramClassType)));
    ClassType[] arrayOfClassType = getInterfaces();
    if (arrayOfClassType != null)
    {
      int i = arrayOfClassType.length;
      do
      {
        i--;
        if (i < 0) {
          break;
        }
      } while (!arrayOfClassType[i].implementsInterface(paramClassType));
      return true;
    }
    return false;
  }
  
  public boolean isAccessible(ClassType paramClassType, ObjectType paramObjectType, int paramInt)
  {
    int i = paramClassType.getModifiers();
    if (((paramInt & 0x1) != 0) && ((i & 0x1) != 0)) {}
    label126:
    do
    {
      for (;;)
      {
        return true;
        String str1 = getName();
        String str2 = paramClassType.getName();
        if (!str1.equals(str2))
        {
          if ((paramInt & 0x2) != 0) {
            return false;
          }
          int j = str1.lastIndexOf('.');
          String str3;
          int k;
          if (j >= 0)
          {
            str3 = str1.substring(0, j);
            k = str2.lastIndexOf('.');
            if (k < 0) {
              break label126;
            }
          }
          for (String str4 = str2.substring(0, k);; str4 = "")
          {
            if (str3.equals(str4)) {
              break label132;
            }
            if ((i & 0x1) != 0) {
              break label134;
            }
            return false;
            str3 = "";
            break;
          }
        }
      }
    } while (((paramInt & 0x4) != 0) && (isSubclass(paramClassType)) && ((!(paramObjectType instanceof ClassType)) || (((ClassType)paramObjectType).isSubclass(this))));
    label132:
    label134:
    return false;
  }
  
  public boolean isAccessible(Member paramMember, ObjectType paramObjectType)
  {
    if (paramMember.getStaticFlag()) {
      paramObjectType = null;
    }
    return isAccessible(paramMember.getDeclaringClass(), paramObjectType, paramMember.getModifiers());
  }
  
  public final boolean isInterface()
  {
    return (0x200 & getModifiers()) != 0;
  }
  
  public final boolean isSubclass(ClassType paramClassType)
  {
    boolean bool = true;
    if (paramClassType.isInterface()) {
      bool = implementsInterface(paramClassType);
    }
    while (((this == toStringType) && (paramClassType == javalangStringType)) || ((this == javalangStringType) && (paramClassType == toStringType))) {
      return bool;
    }
    for (ClassType localClassType = this;; localClassType = localClassType.getSuperclass())
    {
      if (localClassType == null) {
        break label64;
      }
      if (localClassType == paramClassType) {
        break;
      }
    }
    label64:
    return false;
  }
  
  public final boolean isSubclass(String paramString)
  {
    ClassType localClassType = this;
    do
    {
      if (paramString.equals(localClassType.getName())) {
        return true;
      }
      localClassType = localClassType.getSuperclass();
    } while (localClassType != null);
    return false;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    setName(paramObjectInput.readUTF());
    this.flags = (0x10 | this.flags);
  }
  
  public Object readResolve()
    throws ObjectStreamException
  {
    String str = getName();
    synchronized (mapNameToType)
    {
      Type localType = (Type)???.get(str);
      if (localType != null) {
        return localType;
      }
      ???.put(str, this);
      return this;
    }
  }
  
  public final void setAttributes(Attribute paramAttribute)
  {
    this.attributes = paramAttribute;
  }
  
  public void setClassfileVersion(int paramInt)
  {
    this.classfileFormatVersion = paramInt;
  }
  
  public void setClassfileVersion(int paramInt1, int paramInt2)
  {
    this.classfileFormatVersion = (65536 * (paramInt1 & 0xFFFF) + paramInt2 * 65535);
  }
  
  public void setClassfileVersionJava5()
  {
    setClassfileVersion(3211264);
  }
  
  public void setEnclosingMember(Member paramMember)
  {
    this.enclosingMember = paramMember;
  }
  
  public final void setInterface(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.access_flags = (0x600 | this.access_flags);
      return;
    }
    this.access_flags = (0xFFFFFDFF & this.access_flags);
  }
  
  public void setInterfaces(ClassType[] paramArrayOfClassType)
  {
    this.interfaces = paramArrayOfClassType;
  }
  
  public final void setModifiers(int paramInt)
  {
    this.access_flags = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.this_name = paramString;
    setSignature("L" + paramString.replace('.', '/') + ";");
  }
  
  public final Field setOuterLink(ClassType paramClassType)
  {
    if ((0x10 & this.flags) != 0) {
      throw new Error("setOuterLink called for existing class " + getName());
    }
    Field localField = getDeclaredField("this$0");
    if (localField == null)
    {
      localField = addField("this$0", paramClassType);
      this.flags = (0x20 | this.flags);
      for (Method localMethod = this.methods; localMethod != null; localMethod = localMethod.getNext()) {
        if ("<init>".equals(localMethod.getName()))
        {
          if (localMethod.code != null) {
            throw new Error("setOuterLink called when " + localMethod + " has code");
          }
          Type[] arrayOfType1 = localMethod.arg_types;
          Type[] arrayOfType2 = new Type[1 + arrayOfType1.length];
          System.arraycopy(arrayOfType1, 0, arrayOfType2, 1, arrayOfType1.length);
          arrayOfType2[0] = paramClassType;
          localMethod.arg_types = arrayOfType2;
          localMethod.signature = null;
        }
      }
    }
    if (!paramClassType.equals(localField.getType())) {
      throw new Error("inconsistent setOuterLink call for " + getName());
    }
    return localField;
  }
  
  public void setSourceFile(String paramString)
  {
    if (this.sourceDbgExt != null)
    {
      this.sourceDbgExt.addFile(paramString);
      if (this.sourceDbgExt.fileCount > 1) {
        return;
      }
    }
    String str = SourceFileAttr.fixSourceFile(paramString);
    int i = str.lastIndexOf('/');
    if (i >= 0) {
      str = str.substring(i + 1);
    }
    SourceFileAttr.setSourceFile(this, str);
  }
  
  public void setStratum(String paramString)
  {
    if (this.sourceDbgExt == null) {
      this.sourceDbgExt = new SourceDebugExtAttr(this);
    }
    this.sourceDbgExt.addStratum(paramString);
  }
  
  public void setSuper(ClassType paramClassType)
  {
    this.superClass = paramClassType;
  }
  
  public void setSuper(String paramString)
  {
    if (paramString == null) {}
    for (ClassType localClassType = Type.pointer_type;; localClassType = make(paramString))
    {
      setSuper(localClassType);
      return;
    }
  }
  
  public String toString()
  {
    return "ClassType " + getName();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeUTF(getName());
  }
  
  public byte[] writeToArray()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(500);
    try
    {
      writeToStream(localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException localIOException)
    {
      throw new InternalError(localIOException.toString());
    }
  }
  
  public void writeToFile()
    throws IOException
  {
    writeToFile(this.this_name.replace('.', File.separatorChar) + ".class");
  }
  
  public void writeToFile(String paramString)
    throws IOException
  {
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramString));
    writeToStream(localBufferedOutputStream);
    localBufferedOutputStream.close();
  }
  
  public void writeToStream(OutputStream paramOutputStream)
    throws IOException
  {
    DataOutputStream localDataOutputStream = new DataOutputStream(paramOutputStream);
    doFixups();
    localDataOutputStream.writeInt(-889275714);
    localDataOutputStream.writeShort(getClassfileMinorVersion());
    localDataOutputStream.writeShort(getClassfileMajorVersion());
    if (this.constants == null)
    {
      localDataOutputStream.writeShort(1);
      localDataOutputStream.writeShort(this.access_flags);
      localDataOutputStream.writeShort(this.thisClassIndex);
      localDataOutputStream.writeShort(this.superClassIndex);
      if (this.interfaceIndexes != null) {
        break label131;
      }
      localDataOutputStream.writeShort(0);
    }
    for (;;)
    {
      localDataOutputStream.writeShort(this.fields_count);
      for (Field localField = this.fields; localField != null; localField = localField.next) {
        localField.write(localDataOutputStream, this);
      }
      this.constants.write(localDataOutputStream);
      break;
      label131:
      int i = this.interfaceIndexes.length;
      localDataOutputStream.writeShort(i);
      for (int j = 0; j < i; j++) {
        localDataOutputStream.writeShort(this.interfaceIndexes[j]);
      }
    }
    localDataOutputStream.writeShort(this.methods_count);
    for (Method localMethod = this.methods; localMethod != null; localMethod = localMethod.next) {
      localMethod.write(localDataOutputStream, this);
    }
    Attribute.writeAll(this, localDataOutputStream);
    this.flags = (0x3 | this.flags);
  }
  
  static class AbstractMethodFilter
    implements Filter
  {
    public static final AbstractMethodFilter instance = new AbstractMethodFilter();
    
    public boolean select(Object paramObject)
    {
      return ((Method)paramObject).isAbstract();
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.ClassType
 * JD-Core Version:    0.7.0.1
 */