package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrongType;

public class SlotGet
  extends Procedure2
  implements HasSetter, Inlineable
{
  public static final SlotGet field = new SlotGet("field", false, SlotSet.set$Mnfield$Ex);
  static Class[] noClasses = new Class[0];
  public static final SlotGet slotRef = new SlotGet("slot-ref", false, SlotSet.set$Mnfield$Ex);
  public static final SlotGet staticField = new SlotGet("static-field", true, SlotSet.set$Mnstatic$Mnfield$Ex);
  boolean isStatic;
  Procedure setter;
  
  public SlotGet(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.isStatic = paramBoolean;
    setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplySlotGet");
  }
  
  public SlotGet(String paramString, boolean paramBoolean, Procedure paramProcedure)
  {
    this(paramString, paramBoolean);
    this.setter = paramProcedure;
  }
  
  static Class coerceToClass(Object paramObject)
  {
    if ((paramObject instanceof Class)) {
      return (Class)paramObject;
    }
    if ((paramObject instanceof Type)) {
      return ((Type)paramObject).getReflectClass();
    }
    throw new RuntimeException("argument is neither Class nor Type");
  }
  
  public static Object field(Object paramObject, String paramString)
  {
    return field.apply2(paramObject, paramString);
  }
  
  /* Error */
  public static Object getSlotValue(boolean paramBoolean, Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4, Language paramLanguage)
  {
    // Byte code:
    //   0: iload_0
    //   1: ifeq +35 -> 36
    //   4: aload_1
    //   5: invokestatic 100	gnu/kawa/reflect/SlotGet:coerceToClass	(Ljava/lang/Object;)Ljava/lang/Class;
    //   8: astore 7
    //   10: aload_3
    //   11: ldc 102
    //   13: if_acmpne +32 -> 45
    //   16: aload 7
    //   18: invokevirtual 106	java/lang/Class:isArray	()Z
    //   21: ifeq +24 -> 45
    //   24: aload_1
    //   25: invokestatic 112	java/lang/reflect/Array:getLength	(Ljava/lang/Object;)I
    //   28: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: astore 7
    //   33: aload 7
    //   35: areturn
    //   36: aload_1
    //   37: invokevirtual 123	java/lang/Object:getClass	()Ljava/lang/Class;
    //   40: astore 7
    //   42: goto -32 -> 10
    //   45: aload_3
    //   46: ldc 125
    //   48: if_acmpeq -15 -> 33
    //   51: iconst_0
    //   52: istore 8
    //   54: aload_3
    //   55: ifnull +104 -> 159
    //   58: aload 7
    //   60: aload_3
    //   61: invokevirtual 129	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   64: astore 24
    //   66: aload 24
    //   68: astore 20
    //   70: iconst_0
    //   71: istore 8
    //   73: aload 20
    //   75: ifnull +84 -> 159
    //   78: iload_0
    //   79: ifeq +54 -> 133
    //   82: bipush 8
    //   84: aload 20
    //   86: invokevirtual 135	java/lang/reflect/Field:getModifiers	()I
    //   89: iand
    //   90: ifne +43 -> 133
    //   93: new 80	java/lang/RuntimeException
    //   96: dup
    //   97: new 137	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   104: ldc 141
    //   106: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: bipush 39
    //   115: invokevirtual 148	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   118: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokespecial 83	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   124: athrow
    //   125: astore 19
    //   127: aconst_null
    //   128: astore 20
    //   130: goto -60 -> 70
    //   133: aload 6
    //   135: aload 20
    //   137: invokevirtual 155	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   140: aload 20
    //   142: aload_1
    //   143: invokevirtual 159	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   146: invokevirtual 165	gnu/expr/Language:coerceToObject	(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;
    //   149: astore 23
    //   151: aload 23
    //   153: areturn
    //   154: astore 22
    //   156: iconst_1
    //   157: istore 8
    //   159: aload 4
    //   161: ifnull +95 -> 256
    //   164: aload 4
    //   166: astore 12
    //   168: aload 7
    //   170: aload 12
    //   172: getstatic 24	gnu/kawa/reflect/SlotGet:noClasses	[Ljava/lang/Class;
    //   175: invokevirtual 169	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   178: astore 18
    //   180: aload 18
    //   182: astore 13
    //   184: iload_0
    //   185: ifeq +123 -> 308
    //   188: bipush 8
    //   190: aload 13
    //   192: invokevirtual 172	java/lang/reflect/Method:getModifiers	()I
    //   195: iand
    //   196: ifne +112 -> 308
    //   199: new 80	java/lang/RuntimeException
    //   202: dup
    //   203: new 137	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   210: ldc 174
    //   212: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 12
    //   217: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: bipush 39
    //   222: invokevirtual 148	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   225: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokespecial 83	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   231: athrow
    //   232: astore 16
    //   234: aload 16
    //   236: invokevirtual 178	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   239: invokestatic 184	gnu/mapping/WrappedException:wrapIfNeeded	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   242: athrow
    //   243: astore 21
    //   245: aload 21
    //   247: invokevirtual 187	java/lang/Exception:printStackTrace	()V
    //   250: iconst_0
    //   251: istore 8
    //   253: goto -94 -> 159
    //   256: ldc 188
    //   258: aload_2
    //   259: invokestatic 194	gnu/expr/ClassExp:slotToMethodName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   262: astore 17
    //   264: aload 17
    //   266: astore 12
    //   268: goto -100 -> 168
    //   271: astore 11
    //   273: aload 5
    //   275: ifnull +22 -> 297
    //   278: aload 5
    //   280: astore 12
    //   282: aload 7
    //   284: aload 12
    //   286: getstatic 24	gnu/kawa/reflect/SlotGet:noClasses	[Ljava/lang/Class;
    //   289: invokevirtual 169	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   292: astore 13
    //   294: goto -110 -> 184
    //   297: ldc 196
    //   299: aload_2
    //   300: invokestatic 194	gnu/expr/ClassExp:slotToMethodName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   303: astore 12
    //   305: goto -23 -> 282
    //   308: aload 13
    //   310: aload_1
    //   311: getstatic 202	gnu/mapping/Values:noArgs	[Ljava/lang/Object;
    //   314: invokevirtual 206	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   317: astore 14
    //   319: aload 6
    //   321: aload 13
    //   323: invokevirtual 209	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   326: aload 14
    //   328: invokevirtual 165	gnu/expr/Language:coerceToObject	(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;
    //   331: astore 15
    //   333: aload 15
    //   335: areturn
    //   336: astore 10
    //   338: iconst_1
    //   339: istore 8
    //   341: iload 8
    //   343: ifeq +30 -> 373
    //   346: new 80	java/lang/RuntimeException
    //   349: dup
    //   350: new 137	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   357: ldc 211
    //   359: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_3
    //   363: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokespecial 83	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   372: athrow
    //   373: new 80	java/lang/RuntimeException
    //   376: dup
    //   377: new 137	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   384: ldc 213
    //   386: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_3
    //   390: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: ldc 215
    //   395: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload 7
    //   400: invokevirtual 218	java/lang/Class:getName	()Ljava/lang/String;
    //   403: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokespecial 83	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   412: athrow
    //   413: astore 9
    //   415: goto -74 -> 341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramBoolean	boolean
    //   0	418	1	paramObject	Object
    //   0	418	2	paramString1	String
    //   0	418	3	paramString2	String
    //   0	418	4	paramString3	String
    //   0	418	5	paramString4	String
    //   0	418	6	paramLanguage	Language
    //   8	391	7	localObject1	Object
    //   52	290	8	i	int
    //   413	1	9	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   336	1	10	localIllegalAccessException1	java.lang.IllegalAccessException
    //   271	1	11	localException1	java.lang.Exception
    //   166	138	12	localObject2	Object
    //   182	140	13	localMethod1	java.lang.reflect.Method
    //   317	10	14	localObject3	Object
    //   331	3	15	localObject4	Object
    //   232	3	16	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   262	3	17	str	String
    //   178	3	18	localMethod2	java.lang.reflect.Method
    //   125	1	19	localException2	java.lang.Exception
    //   68	73	20	localField1	java.lang.reflect.Field
    //   243	3	21	localException3	java.lang.Exception
    //   154	1	22	localIllegalAccessException2	java.lang.IllegalAccessException
    //   149	3	23	localObject5	Object
    //   64	3	24	localField2	java.lang.reflect.Field
    // Exception table:
    //   from	to	target	type
    //   58	66	125	java/lang/Exception
    //   133	151	154	java/lang/IllegalAccessException
    //   168	180	232	java/lang/reflect/InvocationTargetException
    //   188	232	232	java/lang/reflect/InvocationTargetException
    //   256	264	232	java/lang/reflect/InvocationTargetException
    //   282	294	232	java/lang/reflect/InvocationTargetException
    //   297	305	232	java/lang/reflect/InvocationTargetException
    //   308	333	232	java/lang/reflect/InvocationTargetException
    //   133	151	243	java/lang/Exception
    //   168	180	271	java/lang/Exception
    //   256	264	271	java/lang/Exception
    //   168	180	336	java/lang/IllegalAccessException
    //   188	232	336	java/lang/IllegalAccessException
    //   256	264	336	java/lang/IllegalAccessException
    //   282	294	336	java/lang/IllegalAccessException
    //   297	305	336	java/lang/IllegalAccessException
    //   308	333	336	java/lang/IllegalAccessException
    //   168	180	413	java/lang/NoSuchMethodException
    //   188	232	413	java/lang/NoSuchMethodException
    //   256	264	413	java/lang/NoSuchMethodException
    //   282	294	413	java/lang/NoSuchMethodException
    //   297	305	413	java/lang/NoSuchMethodException
    //   308	333	413	java/lang/NoSuchMethodException
  }
  
  public static Member lookupMember(ObjectType paramObjectType, String paramString, ClassType paramClassType)
  {
    Field localField = paramObjectType.getField(Compilation.mangleNameIfNeeded(paramString), -1);
    if (localField != null)
    {
      if (paramClassType == null) {
        paramClassType = Type.pointer_type;
      }
      if (!paramClassType.isAccessible(localField, paramObjectType)) {}
    }
    Method localMethod;
    do
    {
      return localField;
      localMethod = paramObjectType.getMethod(ClassExp.slotToMethodName("get", paramString), Type.typeArray0);
    } while (localMethod == null);
    return localMethod;
  }
  
  public static ApplyExp makeGetField(Expression paramExpression, String paramString)
  {
    Expression[] arrayOfExpression = new Expression[2];
    arrayOfExpression[0] = paramExpression;
    arrayOfExpression[1] = new QuoteExp(paramString);
    return new ApplyExp(field, arrayOfExpression);
  }
  
  public static Object staticField(Object paramObject, String paramString)
  {
    return staticField.apply2(paramObject, paramString);
  }
  
  public Object apply2(Object paramObject1, Object paramObject2)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    String str2;
    String str1;
    if ((paramObject2 instanceof Field))
    {
      str2 = ((Field)paramObject2).getName();
      str1 = Compilation.demangleName(str2, true);
      if (!"class".equals(str2)) {
        break label182;
      }
      str2 = "class";
    }
    for (;;)
    {
      return getSlotValue(this.isStatic, paramObject1, str1, str2, (String)localObject1, (String)localObject2, Language.getDefaultLanguage());
      if ((paramObject2 instanceof Method))
      {
        String str3 = ((Method)paramObject2).getName();
        str1 = Compilation.demangleName(str3, false);
        if (str3.startsWith("get")) {
          localObject1 = str3;
        }
        for (;;)
        {
          str2 = null;
          break;
          boolean bool = str3.startsWith("is");
          localObject1 = null;
          localObject2 = null;
          if (bool)
          {
            localObject2 = str3;
            localObject1 = null;
          }
        }
      }
      if (((paramObject2 instanceof SimpleSymbol)) || ((paramObject2 instanceof CharSequence)))
      {
        str1 = paramObject2.toString();
        str2 = Compilation.mangleNameIfNeeded(str1);
        localObject1 = null;
        localObject2 = null;
        break;
      }
      throw new WrongType(this, 2, paramObject2, "string");
      label182:
      if ("length".equals(str2)) {
        str2 = "length";
      }
    }
  }
  
  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    Expression localExpression1 = arrayOfExpression[0];
    Expression localExpression2 = arrayOfExpression[1];
    Language localLanguage = paramCompilation.getLanguage();
    Type localType;
    CodeAttr localCodeAttr;
    ObjectType localObjectType;
    Object localObject;
    Field localField;
    int i;
    label108:
    Target localTarget2;
    if (this.isStatic)
    {
      localType = localLanguage.getTypeFor(localExpression1);
      localCodeAttr = paramCompilation.getCode();
      if ((!(localType instanceof ObjectType)) || (!(localExpression2 instanceof QuoteExp))) {
        break label295;
      }
      localObjectType = (ObjectType)localType;
      localObject = ((QuoteExp)localExpression2).getValue();
      if (!(localObject instanceof Field)) {
        break label200;
      }
      localField = (Field)localObject;
      if ((0x8 & localField.getModifiers()) == 0) {
        break label174;
      }
      i = 1;
      Expression localExpression4 = arrayOfExpression[0];
      if (i == 0) {
        break label180;
      }
      localTarget2 = Target.Ignore;
      label124:
      localExpression4.compile(paramCompilation, localTarget2);
      if (i == 0) {
        break label190;
      }
      if (0 == 0) {
        localCodeAttr.emitGetStatic(localField);
      }
    }
    for (;;)
    {
      paramTarget.compileFromStack(paramCompilation, localLanguage.getLangTypeFor(localField.getType()));
      return;
      localType = localExpression1.getType();
      break;
      label174:
      i = 0;
      break label108;
      label180:
      localTarget2 = Target.pushValue(localObjectType);
      break label124;
      label190:
      localCodeAttr.emitGetField(localField);
    }
    label200:
    if ((localObject instanceof Method))
    {
      Method localMethod = (Method)localObject;
      localMethod.getModifiers();
      boolean bool = localMethod.getStaticFlag();
      Expression localExpression3 = arrayOfExpression[0];
      Target localTarget1;
      if (bool)
      {
        localTarget1 = Target.Ignore;
        localExpression3.compile(paramCompilation, localTarget1);
        if (!bool) {
          break label285;
        }
        localCodeAttr.emitInvokeStatic(localMethod);
      }
      for (;;)
      {
        paramTarget.compileFromStack(paramCompilation, localMethod.getReturnType());
        return;
        localTarget1 = Target.pushValue(localObjectType);
        break;
        localCodeAttr.emitInvoke(localMethod);
      }
    }
    label285:
    label295:
    String str = ClassMethods.checkName(localExpression2);
    if (((localType instanceof ArrayType)) && ("length".equals(str)) && (!this.isStatic))
    {
      arrayOfExpression[0].compile(paramCompilation, Target.pushValue(localType));
      localCodeAttr.emitArrayLength();
      paramTarget.compileFromStack(paramCompilation, LangPrimType.intType);
      return;
    }
    ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
  }
  
  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    if (paramArrayOfExpression.length == 2)
    {
      Expression localExpression1 = paramArrayOfExpression[0];
      Expression localExpression2 = paramArrayOfExpression[1];
      if ((localExpression2 instanceof QuoteExp))
      {
        Object localObject = ((QuoteExp)localExpression2).getValue();
        if ((localObject instanceof Field)) {
          return ((Field)localObject).getType();
        }
        if ((localObject instanceof Method)) {
          return ((Method)localObject).getReturnType();
        }
        if ((!this.isStatic) && ((localExpression1.getType() instanceof ArrayType)) && ("length".equals(ClassMethods.checkName(localExpression2, true)))) {
          return LangPrimType.intType;
        }
      }
    }
    return Type.pointer_type;
  }
  
  public Procedure getSetter()
  {
    if (this.setter == null) {
      return super.getSetter();
    }
    return this.setter;
  }
  
  public void set2(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    SlotSet.apply(this.isStatic, paramObject1, (String)paramObject2, paramObject3);
  }
  
  public void setN(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    if (i != 3) {
      throw new WrongArguments(getSetter(), i);
    }
    set2(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2]);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.SlotGet
 * JD-Core Version:    0.7.0.1
 */