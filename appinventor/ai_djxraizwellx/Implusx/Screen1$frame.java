package appinventor.ai_djxraizwellx.Implusx;

import com.google.appinventor.components.runtime.Component;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;

public class Screen1$frame
  extends ModuleBody
{
  Screen1 $main;
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    case 22: 
    default: 
      return super.apply0(paramModuleMethod);
    case 15: 
      return Screen1.lambda2();
    case 16: 
      this.$main.$define();
      return Values.empty;
    case 17: 
      return Screen1.lambda3();
    case 18: 
      return Screen1.lambda4();
    case 19: 
      return Screen1.lambda5();
    case 20: 
      return Screen1.lambda6();
    case 21: 
      return Screen1.lambda7();
    case 23: 
      return Screen1.lambda8();
    case 24: 
      return Screen1.lambda9();
    case 25: 
      return Screen1.lambda10();
    case 26: 
      return Screen1.lambda11();
    case 27: 
      return Screen1.lambda12();
    case 28: 
      return Screen1.lambda13();
    case 29: 
      return this.$main.Button1$Click();
    case 30: 
      return Screen1.lambda14();
    case 31: 
      return Screen1.lambda15();
    case 32: 
      return this.$main.Button2$Click();
    case 33: 
      return Screen1.lambda16();
    }
    return Screen1.lambda17();
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    Screen1 localScreen12;
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 1: 
      this.$main.androidLogForm(paramObject);
      return Values.empty;
    case 3: 
      localScreen12 = this.$main;
    }
    try
    {
      Symbol localSymbol2 = (Symbol)paramObject;
      return localScreen12.lookupInFormEnvironment(localSymbol2);
    }
    catch (ClassCastException localClassCastException2)
    {
      Screen1 localScreen11;
      throw new WrongType(localClassCastException2, "lookup-in-form-environment", 1, paramObject);
    }
    localScreen11 = this.$main;
    try
    {
      Symbol localSymbol1 = (Symbol)paramObject;
      if (localScreen11.isBoundInFormEnvironment(localSymbol1)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException1)
    {
      throw new WrongType(localClassCastException1, "is-bound-in-form-environment", 1, paramObject);
    }
    this.$main.addToFormDoAfterCreation(paramObject);
    return Values.empty;
    this.$main.sendError(paramObject);
    return Values.empty;
    this.$main.processException(paramObject);
    return Values.empty;
    return this.$main.Slider1$PositionChanged(paramObject);
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    Screen1 localScreen13;
    switch (paramModuleMethod.selector)
    {
    case 4: 
    case 5: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    case 2: 
      localScreen13 = this.$main;
    }
    try
    {
      Symbol localSymbol3 = (Symbol)paramObject1;
      localScreen13.addToFormEnvironment(localSymbol3, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException3)
    {
      Screen1 localScreen12;
      throw new WrongType(localClassCastException3, "add-to-form-environment", 1, paramObject1);
    }
    localScreen12 = this.$main;
    try
    {
      Symbol localSymbol2 = (Symbol)paramObject1;
      return localScreen12.lookupInFormEnvironment(localSymbol2, paramObject2);
    }
    catch (ClassCastException localClassCastException2)
    {
      Screen1 localScreen11;
      throw new WrongType(localClassCastException2, "lookup-in-form-environment", 1, paramObject1);
    }
    localScreen11 = this.$main;
    try
    {
      Symbol localSymbol1 = (Symbol)paramObject1;
      localScreen11.addToGlobalVarEnvironment(localSymbol1, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException1)
    {
      throw new WrongType(localClassCastException1, "add-to-global-var-environment", 1, paramObject1);
    }
    this.$main.addToEvents(paramObject1, paramObject2);
    return Values.empty;
    this.$main.addToGlobalVars(paramObject1, paramObject2);
    return Values.empty;
    return this.$main.lookupHandler(paramObject1, paramObject2);
  }
  
  /* Error */
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 18	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+28->32, 8:+40->44, 13:+57->61
    //   33: aload_1
    //   34: aload_2
    //   35: aload_3
    //   36: aload 4
    //   38: aload 5
    //   40: invokespecial 172	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: areturn
    //   44: aload_0
    //   45: getfield 28	appinventor/ai_djxraizwellx/Implusx/Screen1$frame:$main	Lappinventor/ai_djxraizwellx/Implusx/Screen1;
    //   48: aload_2
    //   49: aload_3
    //   50: aload 4
    //   52: aload 5
    //   54: invokevirtual 176	appinventor/ai_djxraizwellx/Implusx/Screen1:addToComponents	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   57: getstatic 37	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   60: areturn
    //   61: aload_0
    //   62: getfield 28	appinventor/ai_djxraizwellx/Implusx/Screen1$frame:$main	Lappinventor/ai_djxraizwellx/Implusx/Screen1;
    //   65: astore 6
    //   67: aload_2
    //   68: checkcast 178	com/google/appinventor/components/runtime/Component
    //   71: astore 8
    //   73: aload_3
    //   74: checkcast 180	java/lang/String
    //   77: astore 10
    //   79: aload 4
    //   81: checkcast 180	java/lang/String
    //   84: astore 12
    //   86: aload 5
    //   88: checkcast 182	[Ljava/lang/Object;
    //   91: astore 14
    //   93: aload 6
    //   95: aload 8
    //   97: aload 10
    //   99: aload 12
    //   101: aload 14
    //   103: invokevirtual 186	appinventor/ai_djxraizwellx/Implusx/Screen1:dispatchEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Z
    //   106: ifeq +7 -> 113
    //   109: getstatic 114	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   112: areturn
    //   113: getstatic 117	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   116: areturn
    //   117: astore 7
    //   119: new 132	gnu/mapping/WrongType
    //   122: dup
    //   123: aload 7
    //   125: ldc 187
    //   127: iconst_1
    //   128: aload_2
    //   129: invokespecial 137	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   132: athrow
    //   133: astore 9
    //   135: new 132	gnu/mapping/WrongType
    //   138: dup
    //   139: aload 9
    //   141: ldc 187
    //   143: iconst_2
    //   144: aload_3
    //   145: invokespecial 137	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   148: athrow
    //   149: astore 11
    //   151: new 132	gnu/mapping/WrongType
    //   154: dup
    //   155: aload 11
    //   157: ldc 187
    //   159: iconst_3
    //   160: aload 4
    //   162: invokespecial 137	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   165: athrow
    //   166: astore 13
    //   168: new 132	gnu/mapping/WrongType
    //   171: dup
    //   172: aload 13
    //   174: ldc 187
    //   176: iconst_4
    //   177: aload 5
    //   179: invokespecial 137	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	frame
    //   0	183	1	paramModuleMethod	ModuleMethod
    //   0	183	2	paramObject1	Object
    //   0	183	3	paramObject2	Object
    //   0	183	4	paramObject3	Object
    //   0	183	5	paramObject4	Object
    //   65	29	6	localScreen1	Screen1
    //   117	7	7	localClassCastException1	ClassCastException
    //   71	25	8	localComponent	Component
    //   133	7	9	localClassCastException2	ClassCastException
    //   77	21	10	str1	String
    //   149	7	11	localClassCastException3	ClassCastException
    //   84	16	12	str2	String
    //   166	7	13	localClassCastException4	ClassCastException
    //   91	11	14	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   67	73	117	java/lang/ClassCastException
    //   73	79	133	java/lang/ClassCastException
    //   79	86	149	java/lang/ClassCastException
    //   86	93	166	java/lang/ClassCastException
  }
  
  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 22: 
    default: 
      return super.match0(paramModuleMethod, paramCallContext);
    case 34: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 33: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 32: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 31: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 30: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 29: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 28: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 27: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 26: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 25: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 24: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 23: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 21: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 20: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 19: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 18: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 17: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 16: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 0;
    return 0;
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 22: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 12: 
      if (!(paramObject instanceof Screen1)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 11: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 10: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 5: 
      if (!(paramObject instanceof Symbol)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 3: 
      if (!(paramObject instanceof Symbol)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }
  
  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 4: 
    case 5: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 14: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 9: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 7: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 6: 
      if (!(paramObject1 instanceof Symbol)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 3: 
      if (!(paramObject1 instanceof Symbol)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    if (!(paramObject1 instanceof Symbol)) {
      return -786431;
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }
  
  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    case 13: 
      if (!(paramObject1 instanceof Screen1)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Component)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      if (!(paramObject3 instanceof String)) {
        return -786429;
      }
      paramCallContext.value3 = paramObject3;
      if (!(paramObject4 instanceof String)) {
        return -786428;
      }
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.value4 = paramObject4;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 4;
    return 0;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     appinventor.ai_djxraizwellx.Implusx.Screen1.frame
 * JD-Core Version:    0.7.0.1
 */