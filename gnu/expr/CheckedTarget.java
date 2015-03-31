package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;

public class CheckedTarget
  extends StackTarget
{
  static Method initWrongTypeProcMethod;
  static Method initWrongTypeStringMethod;
  static ClassType typeClassCastException;
  static ClassType typeWrongType;
  int argno;
  LambdaExp proc;
  String procname;
  
  public CheckedTarget(Type paramType)
  {
    super(paramType);
    this.argno = -4;
  }
  
  public CheckedTarget(Type paramType, LambdaExp paramLambdaExp, int paramInt)
  {
    super(paramType);
    this.proc = paramLambdaExp;
    this.procname = paramLambdaExp.getName();
    this.argno = paramInt;
  }
  
  public CheckedTarget(Type paramType, String paramString, int paramInt)
  {
    super(paramType);
    this.procname = paramString;
    this.argno = paramInt;
  }
  
  public static void emitCheckedCoerce(Compilation paramCompilation, LambdaExp paramLambdaExp, int paramInt, Type paramType)
  {
    emitCheckedCoerce(paramCompilation, paramLambdaExp, paramLambdaExp.getName(), paramInt, paramType, null);
  }
  
  public static void emitCheckedCoerce(Compilation paramCompilation, LambdaExp paramLambdaExp, int paramInt, Type paramType, Variable paramVariable)
  {
    emitCheckedCoerce(paramCompilation, paramLambdaExp, paramLambdaExp.getName(), paramInt, paramType, paramVariable);
  }
  
  static void emitCheckedCoerce(Compilation paramCompilation, LambdaExp paramLambdaExp, String paramString, int paramInt, Type paramType, Variable paramVariable)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    boolean bool1 = localCodeAttr.isInTry();
    initWrongType();
    Label localLabel1 = new Label(localCodeAttr);
    Scope localScope;
    if ((paramVariable == null) && (paramType != Type.toStringType))
    {
      localScope = localCodeAttr.pushScope();
      paramVariable = localCodeAttr.addLocal(Type.objectType);
      localCodeAttr.emitDup(1);
      localCodeAttr.emitStore(paramVariable);
    }
    for (;;)
    {
      int i = localCodeAttr.getPC();
      localLabel1.define(localCodeAttr);
      emitCoerceFromObject(paramType, paramCompilation);
      if ((localCodeAttr.getPC() != i) && (paramType != Type.toStringType)) {
        break;
      }
      if (localScope != null) {
        localCodeAttr.popScope();
      }
      return;
      localScope = null;
    }
    Label localLabel2 = new Label(localCodeAttr);
    localLabel2.define(localCodeAttr);
    Label localLabel3 = new Label(localCodeAttr);
    localLabel3.setTypes(localCodeAttr);
    if (bool1) {
      localCodeAttr.emitGoto(localLabel3);
    }
    localCodeAttr.setUnreachable();
    int j = 0;
    if (!bool1) {
      j = localCodeAttr.beginFragment(localLabel3);
    }
    localCodeAttr.addHandler(localLabel1, localLabel2, typeClassCastException);
    int k = 0;
    if (paramLambdaExp != null)
    {
      boolean bool2 = paramLambdaExp.isClassGenerated();
      k = 0;
      if (bool2)
      {
        boolean bool3 = paramCompilation.method.getStaticFlag();
        k = 0;
        if (!bool3)
        {
          ClassType localClassType1 = paramCompilation.method.getDeclaringClass();
          ClassType localClassType2 = paramLambdaExp.getCompiledClassType(paramCompilation);
          k = 0;
          if (localClassType1 == localClassType2) {
            k = 1;
          }
        }
      }
    }
    int m = paramCompilation.getLineNumber();
    if (m > 0) {
      localCodeAttr.putLineNumber(m);
    }
    localCodeAttr.emitNew(typeWrongType);
    localCodeAttr.emitDupX();
    localCodeAttr.emitSwap();
    if (k != 0)
    {
      localCodeAttr.emitPushThis();
      localCodeAttr.emitPushInt(paramInt);
      localCodeAttr.emitLoad(paramVariable);
      if (k == 0) {
        break label402;
      }
    }
    label402:
    for (Method localMethod = initWrongTypeProcMethod;; localMethod = initWrongTypeStringMethod)
    {
      localCodeAttr.emitInvokeSpecial(localMethod);
      if (localScope != null) {
        localCodeAttr.popScope();
      }
      localCodeAttr.emitThrow();
      if (!bool1) {
        break label410;
      }
      localLabel3.define(localCodeAttr);
      return;
      if ((paramString == null) && (paramInt != -4)) {
        paramString = "lambda";
      }
      localCodeAttr.emitPushString(paramString);
      break;
    }
    label410:
    localCodeAttr.endFragment(j);
  }
  
  public static void emitCheckedCoerce(Compilation paramCompilation, String paramString, int paramInt, Type paramType)
  {
    emitCheckedCoerce(paramCompilation, null, paramString, paramInt, paramType, null);
  }
  
  public static Target getInstance(Type paramType)
  {
    if (paramType == Type.objectType) {
      return Target.pushObject;
    }
    return new CheckedTarget(paramType);
  }
  
  public static Target getInstance(Type paramType, LambdaExp paramLambdaExp, int paramInt)
  {
    if (paramType == Type.objectType) {
      return Target.pushObject;
    }
    return new CheckedTarget(paramType, paramLambdaExp, paramInt);
  }
  
  public static Target getInstance(Type paramType, String paramString, int paramInt)
  {
    if (paramType == Type.objectType) {
      return Target.pushObject;
    }
    return new CheckedTarget(paramType, paramString, paramInt);
  }
  
  public static Target getInstance(Declaration paramDeclaration)
  {
    return getInstance(paramDeclaration.getType(), paramDeclaration.getName(), -2);
  }
  
  private static void initWrongType()
  {
    if (typeClassCastException == null) {
      typeClassCastException = ClassType.make("java.lang.ClassCastException");
    }
    if (typeWrongType == null)
    {
      typeWrongType = ClassType.make("gnu.mapping.WrongType");
      Type[] arrayOfType1 = new Type[4];
      arrayOfType1[0] = typeClassCastException;
      arrayOfType1[1] = Compilation.javaStringType;
      arrayOfType1[2] = Type.intType;
      arrayOfType1[3] = Type.objectType;
      initWrongTypeStringMethod = typeWrongType.addMethod("<init>", 1, arrayOfType1, Type.voidType);
      Type[] arrayOfType2 = new Type[4];
      arrayOfType2[0] = typeClassCastException;
      arrayOfType2[1] = Compilation.typeProcedure;
      arrayOfType2[2] = Type.intType;
      arrayOfType2[3] = Type.objectType;
      initWrongTypeProcMethod = typeWrongType.addMethod("<init>", 1, arrayOfType2, Type.voidType);
    }
  }
  
  public void compileFromStack(Compilation paramCompilation, Type paramType)
  {
    if (!compileFromStack0(paramCompilation, paramType)) {
      emitCheckedCoerce(paramCompilation, this.proc, this.procname, this.argno, this.type, null);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.CheckedTarget
 * JD-Core Version:    0.7.0.1
 */