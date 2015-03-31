package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.LambdaExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class ValuesMap
  extends MethodProc
  implements Inlineable
{
  public static final ValuesMap valuesMap = new ValuesMap(-1);
  public static final ValuesMap valuesMapWithPos = new ValuesMap(1);
  private final int startCounter;
  
  private ValuesMap(int paramInt)
  {
    this.startCounter = paramInt;
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyValuesMap");
  }
  
  static LambdaExp canInline(ApplyExp paramApplyExp, ValuesMap paramValuesMap)
  {
    int i = 2;
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if (arrayOfExpression.length == i)
    {
      Expression localExpression = arrayOfExpression[0];
      if ((localExpression instanceof LambdaExp))
      {
        LambdaExp localLambdaExp = (LambdaExp)localExpression;
        if (localLambdaExp.min_args == localLambdaExp.max_args)
        {
          int j = localLambdaExp.min_args;
          if (paramValuesMap.startCounter >= 0) {}
          while (j == i)
          {
            return localLambdaExp;
            i = 1;
          }
        }
      }
    }
    return null;
  }
  
  public static void compileInlined(LambdaExp paramLambdaExp, Expression paramExpression, int paramInt, Method paramMethod, Compilation paramCompilation, Target paramTarget)
  {
    Declaration localDeclaration1 = paramLambdaExp.firstDecl();
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Scope localScope = localCodeAttr.pushScope();
    Type localType = localDeclaration1.getType();
    Variable localVariable1;
    Declaration localDeclaration2;
    label89:
    Expression[] arrayOfExpression1;
    if (paramInt >= 0)
    {
      localVariable1 = localScope.addVariable(localCodeAttr, Type.intType, "position");
      localCodeAttr.emitPushInt(paramInt);
      localCodeAttr.emitStore(localVariable1);
      localDeclaration2 = new Declaration(localVariable1);
      if ((!localDeclaration1.isSimple()) || (paramMethod != null)) {
        break label479;
      }
      localDeclaration1.allocateVariable(localCodeAttr);
      if (paramInt < 0) {
        break label513;
      }
      arrayOfExpression1 = new Expression[2];
      ReferenceExp localReferenceExp4 = new ReferenceExp(localDeclaration1);
      arrayOfExpression1[0] = localReferenceExp4;
      ReferenceExp localReferenceExp5 = new ReferenceExp(localDeclaration2);
      arrayOfExpression1[1] = localReferenceExp5;
    }
    for (;;)
    {
      Object localObject = new ApplyExp(paramLambdaExp, arrayOfExpression1);
      if (paramMethod != null)
      {
        if (((Expression)localObject).getType().getImplementationType() != Type.booleanType)
        {
          Expression[] arrayOfExpression2 = new Expression[2];
          arrayOfExpression2[0] = localObject;
          ReferenceExp localReferenceExp3 = new ReferenceExp(localDeclaration2);
          arrayOfExpression2[1] = localReferenceExp3;
          localObject = new ApplyExp(paramMethod, arrayOfExpression2);
        }
        ReferenceExp localReferenceExp2 = new ReferenceExp(localDeclaration1);
        localObject = new IfExp((Expression)localObject, localReferenceExp2, QuoteExp.voidExp);
      }
      Variable localVariable2 = localCodeAttr.addLocal(Type.intType);
      Variable localVariable3 = localCodeAttr.addLocal(Type.pointer_type);
      Variable localVariable4 = localCodeAttr.addLocal(Type.intType);
      paramExpression.compileWithPosition(paramCompilation, Target.pushObject);
      localCodeAttr.emitStore(localVariable3);
      localCodeAttr.emitPushInt(0);
      localCodeAttr.emitStore(localVariable2);
      Label localLabel1 = new Label(localCodeAttr);
      Label localLabel2 = new Label(localCodeAttr);
      localLabel1.define(localCodeAttr);
      localCodeAttr.emitLoad(localVariable3);
      localCodeAttr.emitLoad(localVariable2);
      localCodeAttr.emitInvokeStatic(Compilation.typeValues.getDeclaredMethod("nextIndex", 2));
      localCodeAttr.emitDup(Type.intType);
      localCodeAttr.emitStore(localVariable4);
      localCodeAttr.emitGotoIfIntLtZero(localLabel2);
      localCodeAttr.emitLoad(localVariable3);
      localCodeAttr.emitLoad(localVariable2);
      localCodeAttr.emitInvokeStatic(Compilation.typeValues.getDeclaredMethod("nextValue", 2));
      StackTarget.convert(paramCompilation, Type.objectType, localType);
      localDeclaration1.compileStore(paramCompilation);
      ((Expression)localObject).compile(paramCompilation, paramTarget);
      if (paramInt >= 0) {
        localCodeAttr.emitInc(localVariable1, (short)1);
      }
      localCodeAttr.emitLoad(localVariable4);
      localCodeAttr.emitStore(localVariable2);
      localCodeAttr.emitGoto(localLabel1);
      localLabel2.define(localCodeAttr);
      localCodeAttr.popScope();
      return;
      localVariable1 = null;
      localDeclaration2 = null;
      break;
      label479:
      String str = Compilation.mangleNameIfNeeded(localDeclaration1.getName());
      localDeclaration1 = new Declaration(localCodeAttr.addLocal(localType.getImplementationType(), str));
      break label89;
      label513:
      arrayOfExpression1 = new Expression[1];
      ReferenceExp localReferenceExp1 = new ReferenceExp(localDeclaration1);
      arrayOfExpression1[0] = localReferenceExp1;
    }
  }
  
  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Procedure localProcedure = (Procedure)paramCallContext.getNextArg();
    Object localObject1 = paramCallContext.getNextArg();
    Procedure.checkArgCount(localProcedure, 1);
    if ((localObject1 instanceof Values))
    {
      int i = 0;
      int j = this.startCounter;
      Values localValues = (Values)localObject1;
      i = localValues.nextPos(i);
      if (i != 0)
      {
        Object localObject2 = localValues.getPosPrevious(i);
        if (this.startCounter >= 0)
        {
          int k = j + 1;
          localProcedure.check2(localObject2, IntNum.make(j), paramCallContext);
          j = k;
        }
        for (;;)
        {
          paramCallContext.runUntilDone();
          break;
          localProcedure.check1(localObject2, paramCallContext);
        }
      }
    }
    else
    {
      if (this.startCounter < 0) {
        break label143;
      }
      localProcedure.check2(localObject1, IntNum.make(this.startCounter), paramCallContext);
    }
    for (;;)
    {
      paramCallContext.runUntilDone();
      return;
      label143:
      localProcedure.check1(localObject1, paramCallContext);
    }
  }
  
  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    LambdaExp localLambdaExp = canInline(paramApplyExp, this);
    if (localLambdaExp == null)
    {
      ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
      return;
    }
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if ((!(paramTarget instanceof IgnoreTarget)) && (!(paramTarget instanceof ConsumerTarget)))
    {
      ConsumerTarget.compileUsingConsumer(paramApplyExp, paramCompilation, paramTarget);
      return;
    }
    compileInlined(localLambdaExp, arrayOfExpression[1], this.startCounter, null, paramCompilation, paramTarget);
  }
  
  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Type.pointer_type;
  }
  
  public int numArgs()
  {
    return 8194;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.ValuesMap
 * JD-Core Version:    0.7.0.1
 */