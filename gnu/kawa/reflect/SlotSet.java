package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.CheckedTarget;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.lists.FString;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure3;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import kawa.standard.Scheme;

public class SlotSet
  extends Procedure3
  implements Inlineable
{
  public static final SlotSet set$Mnfield$Ex = new SlotSet("set-field!", false);
  public static final SlotSet set$Mnstatic$Mnfield$Ex = new SlotSet("set-static-field!", true);
  public static final SlotSet setFieldReturnObject = new SlotSet("set-field-return-object!", false);
  static final Type[] type1Array = new Type[1];
  boolean isStatic;
  boolean returnSelf;
  
  static
  {
    setFieldReturnObject.returnSelf = true;
  }
  
  public SlotSet(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.isStatic = paramBoolean;
    setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplySlotSet");
  }
  
  /* Error */
  public static void apply(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: invokestatic 74	gnu/expr/Language:getDefaultLanguage	()Lgnu/expr/Language;
    //   3: astore 4
    //   5: aload_2
    //   6: instanceof 76
    //   9: ifne +17 -> 26
    //   12: aload_2
    //   13: instanceof 78
    //   16: ifne +10 -> 26
    //   19: aload_2
    //   20: instanceof 80
    //   23: ifeq +69 -> 92
    //   26: aload_2
    //   27: invokevirtual 86	java/lang/Object:toString	()Ljava/lang/String;
    //   30: astore 5
    //   32: aload 5
    //   34: invokestatic 92	gnu/expr/Compilation:mangleNameIfNeeded	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 6
    //   39: iload_0
    //   40: ifeq +43 -> 83
    //   43: aload_1
    //   44: invokestatic 98	gnu/kawa/reflect/SlotGet:coerceToClass	(Ljava/lang/Object;)Ljava/lang/Class;
    //   47: astore 7
    //   49: aload_2
    //   50: instanceof 100
    //   53: ifeq +60 -> 113
    //   56: aload_2
    //   57: checkcast 100	gnu/bytecode/Field
    //   60: invokevirtual 104	gnu/bytecode/Field:getReflectField	()Ljava/lang/reflect/Field;
    //   63: astore 30
    //   65: aload 30
    //   67: aload_1
    //   68: aload 4
    //   70: aload 30
    //   72: invokevirtual 110	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   75: aload_3
    //   76: invokevirtual 114	gnu/expr/Language:coerceFromObject	(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;
    //   79: invokevirtual 117	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   82: return
    //   83: aload_1
    //   84: invokevirtual 120	java/lang/Object:getClass	()Ljava/lang/Class;
    //   87: astore 7
    //   89: goto -40 -> 49
    //   92: aload_2
    //   93: checkcast 122	gnu/bytecode/Member
    //   96: invokeinterface 125 1 0
    //   101: astore 5
    //   103: aload 5
    //   105: astore 6
    //   107: aconst_null
    //   108: astore 7
    //   110: goto -61 -> 49
    //   113: aload 7
    //   115: aload 6
    //   117: invokevirtual 131	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   120: astore 29
    //   122: aload 29
    //   124: astore 30
    //   126: goto -61 -> 65
    //   129: astore 28
    //   131: iconst_1
    //   132: istore 9
    //   134: aload_2
    //   135: instanceof 133
    //   138: istore 13
    //   140: iload 13
    //   142: ifeq +143 -> 285
    //   145: aload 6
    //   147: astore 15
    //   149: iload 13
    //   151: ifeq +20 -> 171
    //   154: aload 15
    //   156: ldc 134
    //   158: invokevirtual 138	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   161: istore 16
    //   163: iload 16
    //   165: ifne +6 -> 171
    //   168: iconst_0
    //   169: istore 13
    //   171: iload 13
    //   173: ifeq +128 -> 301
    //   176: new 140	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   183: ldc 144
    //   185: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 15
    //   190: iconst_3
    //   191: invokevirtual 152	java/lang/String:substring	(I)Ljava/lang/String;
    //   194: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: astore 26
    //   202: aload 7
    //   204: aload 26
    //   206: getstatic 157	gnu/kawa/reflect/SlotGet:noClasses	[Ljava/lang/Class;
    //   209: invokevirtual 161	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   212: astore 27
    //   214: aload 27
    //   216: astore 20
    //   218: iconst_1
    //   219: anewarray 127	java/lang/Class
    //   222: astore 21
    //   224: aload 21
    //   226: iconst_0
    //   227: aload 20
    //   229: invokevirtual 166	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   232: aastore
    //   233: aload 7
    //   235: aload 15
    //   237: aload 21
    //   239: invokevirtual 161	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   242: astore 22
    //   244: iconst_1
    //   245: anewarray 82	java/lang/Object
    //   248: astore 23
    //   250: aload 23
    //   252: iconst_0
    //   253: aload 4
    //   255: aload 21
    //   257: iconst_0
    //   258: aaload
    //   259: aload_3
    //   260: invokevirtual 114	gnu/expr/Language:coerceFromObject	(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;
    //   263: aastore
    //   264: aload 22
    //   266: aload_1
    //   267: aload 23
    //   269: invokevirtual 170	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   272: pop
    //   273: return
    //   274: astore 12
    //   276: aload 12
    //   278: invokevirtual 174	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   281: invokestatic 180	gnu/mapping/WrappedException:wrapIfNeeded	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   284: athrow
    //   285: ldc 134
    //   287: aload 5
    //   289: invokestatic 186	gnu/expr/ClassExp:slotToMethodName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   292: astore 14
    //   294: aload 14
    //   296: astore 15
    //   298: goto -149 -> 149
    //   301: ldc 144
    //   303: aload 5
    //   305: invokestatic 186	gnu/expr/ClassExp:slotToMethodName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   308: astore 25
    //   310: aload 25
    //   312: astore 26
    //   314: goto -112 -> 202
    //   317: astore 17
    //   319: iload 13
    //   321: ifeq +44 -> 365
    //   324: new 140	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   331: ldc 188
    //   333: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload 15
    //   338: iconst_3
    //   339: invokevirtual 152	java/lang/String:substring	(I)Ljava/lang/String;
    //   342: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: astore 19
    //   350: aload 7
    //   352: aload 19
    //   354: getstatic 157	gnu/kawa/reflect/SlotGet:noClasses	[Ljava/lang/Class;
    //   357: invokevirtual 161	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   360: astore 20
    //   362: goto -144 -> 218
    //   365: ldc 188
    //   367: aload 5
    //   369: invokestatic 186	gnu/expr/ClassExp:slotToMethodName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   372: astore 18
    //   374: aload 18
    //   376: astore 19
    //   378: goto -28 -> 350
    //   381: astore 11
    //   383: iconst_1
    //   384: istore 9
    //   386: iload 9
    //   388: ifeq +31 -> 419
    //   391: new 190	java/lang/RuntimeException
    //   394: dup
    //   395: new 140	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   402: ldc 192
    //   404: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload 5
    //   409: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokespecial 193	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   418: athrow
    //   419: new 190	java/lang/RuntimeException
    //   422: dup
    //   423: new 140	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   430: ldc 195
    //   432: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload 5
    //   437: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: ldc 197
    //   442: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload 7
    //   447: invokevirtual 198	java/lang/Class:getName	()Ljava/lang/String;
    //   450: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokespecial 193	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   459: athrow
    //   460: astore 10
    //   462: goto -76 -> 386
    //   465: astore 8
    //   467: iconst_0
    //   468: istore 9
    //   470: goto -336 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	paramBoolean	boolean
    //   0	473	1	paramObject1	Object
    //   0	473	2	paramObject2	Object
    //   0	473	3	paramObject3	Object
    //   3	251	4	localLanguage	Language
    //   30	406	5	str1	String
    //   37	109	6	str2	String
    //   47	399	7	localClass	java.lang.Class
    //   465	1	8	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   132	337	9	i	int
    //   460	1	10	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   381	1	11	localIllegalAccessException1	java.lang.IllegalAccessException
    //   274	3	12	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   138	182	13	bool1	boolean
    //   292	3	14	str3	String
    //   147	190	15	localObject1	Object
    //   161	3	16	bool2	boolean
    //   317	1	17	localException	java.lang.Exception
    //   372	3	18	str4	String
    //   348	29	19	localObject2	Object
    //   216	145	20	localMethod1	java.lang.reflect.Method
    //   222	34	21	arrayOfClass	java.lang.Class[]
    //   242	23	22	localMethod2	java.lang.reflect.Method
    //   248	20	23	arrayOfObject	Object[]
    //   308	3	25	str5	String
    //   200	113	26	localObject3	Object
    //   212	3	27	localMethod3	java.lang.reflect.Method
    //   129	1	28	localIllegalAccessException2	java.lang.IllegalAccessException
    //   120	3	29	localField	java.lang.reflect.Field
    //   63	62	30	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   49	65	129	java/lang/IllegalAccessException
    //   65	82	129	java/lang/IllegalAccessException
    //   113	122	129	java/lang/IllegalAccessException
    //   134	140	274	java/lang/reflect/InvocationTargetException
    //   154	163	274	java/lang/reflect/InvocationTargetException
    //   176	202	274	java/lang/reflect/InvocationTargetException
    //   202	214	274	java/lang/reflect/InvocationTargetException
    //   218	273	274	java/lang/reflect/InvocationTargetException
    //   285	294	274	java/lang/reflect/InvocationTargetException
    //   301	310	274	java/lang/reflect/InvocationTargetException
    //   324	350	274	java/lang/reflect/InvocationTargetException
    //   350	362	274	java/lang/reflect/InvocationTargetException
    //   365	374	274	java/lang/reflect/InvocationTargetException
    //   176	202	317	java/lang/Exception
    //   202	214	317	java/lang/Exception
    //   301	310	317	java/lang/Exception
    //   134	140	381	java/lang/IllegalAccessException
    //   154	163	381	java/lang/IllegalAccessException
    //   176	202	381	java/lang/IllegalAccessException
    //   202	214	381	java/lang/IllegalAccessException
    //   218	273	381	java/lang/IllegalAccessException
    //   285	294	381	java/lang/IllegalAccessException
    //   301	310	381	java/lang/IllegalAccessException
    //   324	350	381	java/lang/IllegalAccessException
    //   350	362	381	java/lang/IllegalAccessException
    //   365	374	381	java/lang/IllegalAccessException
    //   134	140	460	java/lang/NoSuchMethodException
    //   154	163	460	java/lang/NoSuchMethodException
    //   176	202	460	java/lang/NoSuchMethodException
    //   202	214	460	java/lang/NoSuchMethodException
    //   218	273	460	java/lang/NoSuchMethodException
    //   285	294	460	java/lang/NoSuchMethodException
    //   301	310	460	java/lang/NoSuchMethodException
    //   324	350	460	java/lang/NoSuchMethodException
    //   350	362	460	java/lang/NoSuchMethodException
    //   365	374	460	java/lang/NoSuchMethodException
    //   49	65	465	java/lang/NoSuchFieldException
    //   65	82	465	java/lang/NoSuchFieldException
    //   113	122	465	java/lang/NoSuchFieldException
  }
  
  static void compileSet(Procedure paramProcedure, ObjectType paramObjectType, Expression paramExpression, Object paramObject, Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Language localLanguage = paramCompilation.getLanguage();
    int i;
    Field localField;
    if (((paramProcedure instanceof SlotSet)) && (((SlotSet)paramProcedure).isStatic))
    {
      i = 1;
      if (!(paramObject instanceof Field)) {
        break label161;
      }
      localField = (Field)paramObject;
      boolean bool2 = localField.getStaticFlag();
      Type localType = localLanguage.getLangTypeFor(localField.getType());
      if ((i != 0) && (!bool2)) {
        paramCompilation.error('e', "cannot access non-static field `" + localField.getName() + "' using `" + paramProcedure.getName() + '\'');
      }
      paramExpression.compile(paramCompilation, CheckedTarget.getInstance(localType));
      if (!bool2) {
        break label153;
      }
      localCodeAttr.emitPutStatic(localField);
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label153:
      localCodeAttr.emitPutField(localField);
      return;
      label161:
      if ((paramObject instanceof Method))
      {
        Method localMethod = (Method)paramObject;
        boolean bool1 = localMethod.getStaticFlag();
        if ((i != 0) && (!bool1)) {
          paramCompilation.error('e', "cannot call non-static getter method `" + localMethod.getName() + "' using `" + paramProcedure.getName() + '\'');
        }
        paramExpression.compile(paramCompilation, CheckedTarget.getInstance(localLanguage.getLangTypeFor(localMethod.getParameterTypes()[0])));
        if (bool1) {
          localCodeAttr.emitInvokeStatic(localMethod);
        }
        while (!localMethod.getReturnType().isVoid())
        {
          localCodeAttr.emitPop(1);
          return;
          localCodeAttr.emitInvoke(localMethod);
        }
      }
    }
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
      localMethod = paramObjectType.getMethod(ClassExp.slotToMethodName("set", paramString), type1Array);
    } while (localMethod == null);
    return localMethod;
  }
  
  public static void setField(Object paramObject1, String paramString, Object paramObject2)
  {
    apply(false, paramObject1, paramString, paramObject2);
  }
  
  public static void setStaticField(Object paramObject1, String paramString, Object paramObject2)
  {
    apply(true, paramObject1, paramString, paramObject2);
  }
  
  public Object apply3(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    apply(this.isStatic, paramObject1, paramObject2, paramObject3);
    if (this.returnSelf) {
      return paramObject1;
    }
    return Values.empty;
  }
  
  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    int i = arrayOfExpression.length;
    if (i != 3)
    {
      if (i < 3) {}
      for (String str2 = "too few";; str2 = "too many")
      {
        paramCompilation.error('e', str2 + " arguments to `" + getName() + '\'');
        paramCompilation.compileConstant(null, paramTarget);
        return;
      }
    }
    Expression localExpression1 = arrayOfExpression[0];
    Expression localExpression2 = arrayOfExpression[1];
    arrayOfExpression[2];
    Type localType;
    Object localObject;
    ObjectType localObjectType;
    ClassType localClassType;
    label159:
    String str1;
    Member localMember;
    label262:
    int j;
    label283:
    Expression localExpression3;
    if (this.isStatic)
    {
      localType = Scheme.exp2Type(localExpression1);
      if ((!(localType instanceof ObjectType)) || (!(localExpression2 instanceof QuoteExp))) {
        break label503;
      }
      localObject = ((QuoteExp)localExpression2).getValue();
      localObjectType = (ObjectType)localType;
      if (paramCompilation.curClass == null) {
        break label433;
      }
      localClassType = paramCompilation.curClass;
      if ((!(localObject instanceof String)) && (!(localObject instanceof FString)) && (!(localObject instanceof Symbol))) {
        break label442;
      }
      str1 = localObject.toString();
      localMember = lookupMember(localObjectType, str1, localClassType);
      if ((localMember == null) && (localType != Type.pointer_type) && (paramCompilation.warnUnknownMember())) {
        paramCompilation.error('w', "no slot `" + str1 + "' in " + localObjectType.getName());
      }
      if (localMember == null) {
        break label503;
      }
      if ((0x8 & localMember.getModifiers()) == 0) {
        break label478;
      }
      j = 1;
      if ((localClassType != null) && (!localClassType.isAccessible(localMember, localObjectType))) {
        paramCompilation.error('e', "slot '" + str1 + "' in " + localMember.getDeclaringClass().getName() + " not accessible here");
      }
      localExpression3 = arrayOfExpression[0];
      if (j == 0) {
        break label484;
      }
    }
    label433:
    label442:
    label478:
    label484:
    for (Target localTarget = Target.Ignore;; localTarget = Target.pushValue(localObjectType))
    {
      localExpression3.compile(paramCompilation, localTarget);
      if (this.returnSelf) {
        paramCompilation.getCode().emitDup(localObjectType.getImplementationType());
      }
      compileSet(this, localObjectType, arrayOfExpression[2], localMember, paramCompilation);
      if (!this.returnSelf) {
        break label494;
      }
      paramTarget.compileFromStack(paramCompilation, localObjectType);
      return;
      localType = localExpression1.getType();
      break;
      localClassType = paramCompilation.mainClass;
      break label159;
      if ((localObject instanceof Member))
      {
        localMember = (Member)localObject;
        str1 = localMember.getName();
        break label262;
      }
      str1 = null;
      localMember = null;
      break label262;
      j = 0;
      break label283;
    }
    label494:
    paramCompilation.compileConstant(Values.empty, paramTarget);
    return;
    label503:
    ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.SlotSet
 * JD-Core Version:    0.7.0.1
 */