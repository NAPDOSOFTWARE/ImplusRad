package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.util.IdentityHashTable;
import gnu.mapping.CallContext;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.text.SourceMessages;

public class ApplyExp
  extends Expression
{
  public static final int INLINE_IF_CONSTANT = 4;
  public static final int MAY_CONTAIN_BACK_JUMP = 8;
  public static final int TAILCALL = 2;
  Expression[] args;
  LambdaExp context;
  Expression func;
  public ApplyExp nextCall;
  protected Type type;
  
  public ApplyExp(Method paramMethod, Expression[] paramArrayOfExpression)
  {
    this.func = new QuoteExp(new PrimProcedure(paramMethod));
    this.args = paramArrayOfExpression;
  }
  
  public ApplyExp(Expression paramExpression, Expression[] paramArrayOfExpression)
  {
    this.func = paramExpression;
    this.args = paramArrayOfExpression;
  }
  
  public ApplyExp(Procedure paramProcedure, Expression[] paramArrayOfExpression)
  {
    this.func = new QuoteExp(paramProcedure);
    this.args = paramArrayOfExpression;
  }
  
  public static Inlineable asInlineable(Procedure paramProcedure)
  {
    if ((paramProcedure instanceof Inlineable)) {
      return (Inlineable)paramProcedure;
    }
    return (Inlineable)Procedure.compilerKey.get(paramProcedure);
  }
  
  public static void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    compile(paramApplyExp, paramCompilation, paramTarget, false);
  }
  
  static void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget, boolean paramBoolean)
  {
    int i = paramApplyExp.args.length;
    Expression localExpression1 = paramApplyExp.func;
    Declaration localDeclaration1 = null;
    LambdaExp localLambdaExp1;
    Object localObject1;
    if ((localExpression1 instanceof LambdaExp))
    {
      localLambdaExp1 = (LambdaExp)localExpression1;
      if (localLambdaExp1.getName() != null) {
        break label1329;
      }
      localObject1 = null;
    }
    for (;;)
    {
      if ((paramBoolean) && ((localObject1 instanceof Procedure)))
      {
        Procedure localProcedure = (Procedure)localObject1;
        if (((paramTarget instanceof IgnoreTarget)) && (localProcedure.isSideEffectFree()))
        {
          int i2 = 0;
          for (;;)
          {
            if (i2 < i)
            {
              paramApplyExp.args[i2].compile(paramCompilation, paramTarget);
              i2++;
              continue;
              if ((localExpression1 instanceof ReferenceExp))
              {
                ReferenceExp localReferenceExp1 = (ReferenceExp)localExpression1;
                localDeclaration1 = localReferenceExp1.contextDecl();
                Declaration localDeclaration2 = localReferenceExp1.binding;
                for (;;)
                {
                  ReferenceExp localReferenceExp2;
                  if ((localDeclaration2 != null) && (localDeclaration2.isAlias()) && ((localDeclaration2.value instanceof ReferenceExp)))
                  {
                    localReferenceExp2 = (ReferenceExp)localDeclaration2.value;
                    if ((localDeclaration1 == null) && (!localDeclaration2.needsContext()) && (localReferenceExp2.binding != null)) {}
                  }
                  else
                  {
                    boolean bool5 = localDeclaration2.getFlag(65536L);
                    localLambdaExp1 = null;
                    Object localObject2 = null;
                    if (!bool5)
                    {
                      Expression localExpression2 = localDeclaration2.getValue();
                      localDeclaration2.getName();
                      localLambdaExp1 = null;
                      if (localExpression2 != null)
                      {
                        boolean bool7 = localExpression2 instanceof LambdaExp;
                        localLambdaExp1 = null;
                        if (bool7) {
                          localLambdaExp1 = (LambdaExp)localExpression2;
                        }
                      }
                      localObject2 = null;
                      if (localExpression2 != null)
                      {
                        boolean bool6 = localExpression2 instanceof QuoteExp;
                        localObject2 = null;
                        if (bool6) {
                          localObject2 = ((QuoteExp)localExpression2).getValue();
                        }
                      }
                    }
                    localObject1 = localObject2;
                    break;
                  }
                  localDeclaration2 = localReferenceExp2.binding;
                  localDeclaration1 = localReferenceExp2.contextDecl();
                }
              }
              boolean bool1 = localExpression1 instanceof QuoteExp;
              localLambdaExp1 = null;
              if (!bool1) {
                break label1329;
              }
              localObject1 = ((QuoteExp)localExpression1).getValue();
              localLambdaExp1 = null;
              localDeclaration1 = null;
              break;
            }
          }
        }
        try
        {
          boolean bool4 = inlineCompile(localProcedure, paramApplyExp, paramCompilation, paramTarget);
          if (bool4) {
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          paramCompilation.getMessages().error('e', "caught exception in inline-compiler for " + localObject1 + " - " + localThrowable, localThrowable);
          return;
        }
      }
      CodeAttr localCodeAttr = paramCompilation.getCode();
      if (localLambdaExp1 != null)
      {
        if (((localLambdaExp1.max_args >= 0) && (i > localLambdaExp1.max_args)) || (i < localLambdaExp1.min_args)) {
          throw new Error("internal error - wrong number of parameters for " + localLambdaExp1);
        }
        int n = localLambdaExp1.getCallConvention();
        if ((paramCompilation.inlineOk(localLambdaExp1)) && ((n <= 2) || ((n == 3) && (!paramApplyExp.isTailCall()))))
        {
          Method localMethod2 = localLambdaExp1.getMethod(i);
          if (localMethod2 != null)
          {
            PrimProcedure localPrimProcedure = new PrimProcedure(localMethod2, localLambdaExp1);
            boolean bool3 = localMethod2.getStaticFlag();
            int i1;
            Variable localVariable1;
            if (bool3)
            {
              Variable localVariable2 = localLambdaExp1.declareClosureEnv();
              i1 = 0;
              if (localVariable2 == null) {}
            }
            else
            {
              i1 = 0;
              if (bool3) {
                i1 = 1;
              }
              if (paramCompilation.curLambda != localLambdaExp1) {
                break label632;
              }
              if (localLambdaExp1.closureEnv == null) {
                break label622;
              }
              localVariable1 = localLambdaExp1.closureEnv;
              localCodeAttr.emitLoad(localVariable1);
            }
            label601:
            if (i1 != 0) {}
            for (PrimType localPrimType = Type.voidType;; localPrimType = null)
            {
              localPrimProcedure.compile(localPrimType, paramApplyExp, paramCompilation, paramTarget);
              return;
              label622:
              localVariable1 = localLambdaExp1.thisVariable;
              break;
              label632:
              if (localDeclaration1 != null)
              {
                Target localTarget = Target.pushObject;
                localDeclaration1.load(null, 0, paramCompilation, localTarget);
                break label601;
              }
              localLambdaExp1.getOwningLambda().loadHeapFrame(paramCompilation);
              break label601;
            }
          }
        }
      }
      int j;
      if ((paramApplyExp.isTailCall()) && (localLambdaExp1 != null) && (localLambdaExp1 == paramCompilation.curLambda)) {
        j = 1;
      }
      while ((localLambdaExp1 != null) && (localLambdaExp1.getInlineOnly()) && (j == 0) && (localLambdaExp1.min_args == i))
      {
        pushArgs(localLambdaExp1, paramApplyExp.args, null, paramCompilation);
        if (localLambdaExp1.getFlag(128))
        {
          popParams(localCodeAttr, localLambdaExp1, null, false);
          localCodeAttr.emitTailCall(false, localLambdaExp1.getVarScope());
          return;
          j = 0;
        }
        else
        {
          localLambdaExp1.flags = (0x80 | localLambdaExp1.flags);
          LambdaExp localLambdaExp2 = paramCompilation.curLambda;
          paramCompilation.curLambda = localLambdaExp1;
          localLambdaExp1.allocChildClasses(paramCompilation);
          localLambdaExp1.allocParameters(paramCompilation);
          popParams(localCodeAttr, localLambdaExp1, null, false);
          localLambdaExp1.enterFunction(paramCompilation);
          localLambdaExp1.body.compileWithPosition(paramCompilation, paramTarget);
          localLambdaExp1.compileEnd(paramCompilation);
          localLambdaExp1.generateApplyMethods(paramCompilation);
          localCodeAttr.popScope();
          paramCompilation.curLambda = localLambdaExp2;
          return;
        }
      }
      if ((paramCompilation.curLambda.isHandlingTailCalls()) && ((paramApplyExp.isTailCall()) || ((paramTarget instanceof ConsumerTarget))) && (!paramCompilation.curLambda.getInlineOnly()))
      {
        ClassType localClassType = Compilation.typeCallContext;
        localExpression1.compile(paramCompilation, new StackTarget(Compilation.typeProcedure));
        if (i <= 4)
        {
          for (int m = 0; m < i; m++) {
            paramApplyExp.args[m].compileWithPosition(paramCompilation, Target.pushObject);
          }
          paramCompilation.loadCallContext();
          localCodeAttr.emitInvoke(Compilation.typeProcedure.getDeclaredMethod("check" + i, i + 1));
        }
        while (paramApplyExp.isTailCall())
        {
          localCodeAttr.emitReturn();
          return;
          compileToArray(paramApplyExp.args, paramCompilation);
          paramCompilation.loadCallContext();
          localCodeAttr.emitInvoke(Compilation.typeProcedure.getDeclaredMethod("checkN", 2));
        }
        if (((ConsumerTarget)paramTarget).isContextTarget())
        {
          paramCompilation.loadCallContext();
          localCodeAttr.emitInvoke(localClassType.getDeclaredMethod("runUntilDone", 0));
          return;
        }
        paramCompilation.loadCallContext();
        localCodeAttr.emitLoad(((ConsumerTarget)paramTarget).getConsumerVariable());
        localCodeAttr.emitInvoke(localClassType.getDeclaredMethod("runUntilValue", 1));
        return;
      }
      if (j == 0) {
        localExpression1.compile(paramCompilation, new StackTarget(Compilation.typeProcedure));
      }
      boolean bool2;
      int[] arrayOfInt;
      Method localMethod1;
      if (j != 0) {
        if (localLambdaExp1.min_args != localLambdaExp1.max_args)
        {
          bool2 = true;
          arrayOfInt = null;
          if (!bool2) {
            break label1201;
          }
          compileToArray(paramApplyExp.args, paramCompilation);
          localMethod1 = Compilation.applyNmethod;
        }
      }
      for (;;)
      {
        if (!localCodeAttr.reachableHere())
        {
          paramCompilation.error('e', "unreachable code");
          return;
          bool2 = false;
          break;
          if (i > 4)
          {
            bool2 = true;
            break;
          }
          bool2 = false;
          break;
          label1201:
          if (j != 0)
          {
            arrayOfInt = new int[paramApplyExp.args.length];
            pushArgs(localLambdaExp1, paramApplyExp.args, arrayOfInt, paramCompilation);
            localMethod1 = null;
          }
          else
          {
            for (int k = 0;; k++) {
              if (k < i)
              {
                paramApplyExp.args[k].compileWithPosition(paramCompilation, Target.pushObject);
                if (localCodeAttr.reachableHere()) {}
              }
              else
              {
                localMethod1 = Compilation.applymethods[i];
                arrayOfInt = null;
                break;
              }
            }
          }
        }
      }
      if (j != 0)
      {
        popParams(localCodeAttr, localLambdaExp1, arrayOfInt, bool2);
        localCodeAttr.emitTailCall(false, localLambdaExp1.getVarScope());
        return;
      }
      localCodeAttr.emitInvokeVirtual(localMethod1);
      paramTarget.compileFromStack(paramCompilation, Type.pointer_type);
      return;
      label1329:
      localDeclaration1 = null;
      localObject1 = null;
    }
  }
  
  public static void compileToArray(Expression[] paramArrayOfExpression, Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    if (paramArrayOfExpression.length == 0)
    {
      localCodeAttr.emitGetStatic(Compilation.noArgsField);
      return;
    }
    localCodeAttr.emitPushInt(paramArrayOfExpression.length);
    localCodeAttr.emitNewArray(Type.pointer_type);
    int i = 0;
    label33:
    Expression localExpression;
    if (i < paramArrayOfExpression.length)
    {
      localExpression = paramArrayOfExpression[i];
      if ((!paramCompilation.usingCPStyle()) || ((localExpression instanceof QuoteExp)) || ((localExpression instanceof ReferenceExp))) {
        break label112;
      }
      localExpression.compileWithPosition(paramCompilation, Target.pushObject);
      localCodeAttr.emitSwap();
      localCodeAttr.emitDup(1, 1);
      localCodeAttr.emitSwap();
      localCodeAttr.emitPushInt(i);
      localCodeAttr.emitSwap();
    }
    for (;;)
    {
      localCodeAttr.emitArrayStore(Type.pointer_type);
      i++;
      break label33;
      break;
      label112:
      localCodeAttr.emitDup(Compilation.objArrayType);
      localCodeAttr.emitPushInt(i);
      localExpression.compileWithPosition(paramCompilation, Target.pushObject);
    }
  }
  
  static Expression derefFunc(Expression paramExpression)
  {
    if ((paramExpression instanceof ReferenceExp))
    {
      Declaration localDeclaration = Declaration.followAliases(((ReferenceExp)paramExpression).binding);
      if ((localDeclaration != null) && (!localDeclaration.getFlag(65536L))) {
        paramExpression = localDeclaration.getValue();
      }
    }
    return paramExpression;
  }
  
  static boolean inlineCompile(Procedure paramProcedure, ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
    throws Throwable
  {
    Inlineable localInlineable = asInlineable(paramProcedure);
    if (localInlineable == null) {
      return false;
    }
    localInlineable.compile(paramApplyExp, paramCompilation, paramTarget);
    return true;
  }
  
  private static void popParams(CodeAttr paramCodeAttr, int paramInt1, int paramInt2, int[] paramArrayOfInt, Declaration paramDeclaration, Variable paramVariable)
  {
    int i;
    int j;
    Declaration localDeclaration;
    if (paramInt2 > 0)
    {
      i = paramInt2 - 1;
      j = paramInt1 + 1;
      localDeclaration = paramDeclaration.nextDecl();
      if (paramDeclaration.getVariable() != null) {
        break label78;
      }
    }
    label78:
    for (Variable localVariable = paramVariable;; localVariable = paramVariable.nextVar())
    {
      popParams(paramCodeAttr, j, i, paramArrayOfInt, localDeclaration, localVariable);
      if (!paramDeclaration.ignorable())
      {
        if ((paramArrayOfInt == null) || (paramArrayOfInt[paramInt1] == 65536)) {
          break;
        }
        paramCodeAttr.emitInc(paramVariable, (short)paramArrayOfInt[paramInt1]);
      }
      return;
    }
    paramCodeAttr.emitStore(paramVariable);
  }
  
  private static void popParams(CodeAttr paramCodeAttr, LambdaExp paramLambdaExp, int[] paramArrayOfInt, boolean paramBoolean)
  {
    Variable localVariable = paramLambdaExp.getVarScope().firstVar();
    Declaration localDeclaration = paramLambdaExp.firstDecl();
    if ((localVariable != null) && (localVariable.getName() == "this")) {
      localVariable = localVariable.nextVar();
    }
    if ((localVariable != null) && (localVariable.getName() == "$ctx")) {
      localVariable = localVariable.nextVar();
    }
    if ((localVariable != null) && (localVariable.getName() == "argsArray"))
    {
      if (paramBoolean)
      {
        popParams(paramCodeAttr, 0, 1, null, localDeclaration, localVariable);
        return;
      }
      localVariable = localVariable.nextVar();
    }
    popParams(paramCodeAttr, 0, paramLambdaExp.min_args, paramArrayOfInt, localDeclaration, localVariable);
  }
  
  private static void pushArgs(LambdaExp paramLambdaExp, Expression[] paramArrayOfExpression, int[] paramArrayOfInt, Compilation paramCompilation)
  {
    Declaration localDeclaration = paramLambdaExp.firstDecl();
    int i = paramArrayOfExpression.length;
    int j = 0;
    if (j < i)
    {
      Expression localExpression = paramArrayOfExpression[j];
      if (localDeclaration.ignorable()) {
        localExpression.compile(paramCompilation, Target.Ignore);
      }
      for (;;)
      {
        localDeclaration = localDeclaration.nextDecl();
        j++;
        break;
        if (paramArrayOfInt != null)
        {
          int k = SetExp.canUseInc(localExpression, localDeclaration);
          paramArrayOfInt[j] = k;
          if (k != 65536) {}
        }
        else
        {
          localExpression.compileWithPosition(paramCompilation, StackTarget.getInstance(localDeclaration.getType()));
        }
      }
    }
  }
  
  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Object localObject = this.func.eval(paramCallContext);
    int i = this.args.length;
    Object[] arrayOfObject = new Object[i];
    for (int j = 0; j < i; j++) {
      arrayOfObject[j] = this.args[j].eval(paramCallContext);
    }
    ((Procedure)localObject).checkN(arrayOfObject, paramCallContext);
  }
  
  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    compile(this, paramCompilation, paramTarget, true);
  }
  
  public Expression deepCopy(IdentityHashTable paramIdentityHashTable)
  {
    Expression localExpression = deepCopy(this.func, paramIdentityHashTable);
    Expression[] arrayOfExpression = deepCopy(this.args, paramIdentityHashTable);
    if (((localExpression == null) && (this.func != null)) || ((arrayOfExpression == null) && (this.args != null))) {
      return null;
    }
    ApplyExp localApplyExp = new ApplyExp(localExpression, arrayOfExpression);
    localApplyExp.flags = getFlags();
    return localApplyExp;
  }
  
  public Expression getArg(int paramInt)
  {
    return this.args[paramInt];
  }
  
  public final int getArgCount()
  {
    return this.args.length;
  }
  
  public final Expression[] getArgs()
  {
    return this.args;
  }
  
  public final Expression getFunction()
  {
    return this.func;
  }
  
  public final Object getFunctionValue()
  {
    if ((this.func instanceof QuoteExp)) {
      return ((QuoteExp)this.func).getValue();
    }
    return null;
  }
  
  public final Type getType()
  {
    if (this.type != null) {
      return this.type;
    }
    Expression localExpression = derefFunc(this.func);
    this.type = Type.objectType;
    if ((localExpression instanceof QuoteExp))
    {
      Object localObject = ((QuoteExp)localExpression).getValue();
      if ((localObject instanceof Procedure)) {
        this.type = ((Procedure)localObject).getReturnType(this.args);
      }
    }
    for (;;)
    {
      return this.type;
      if ((localExpression instanceof LambdaExp)) {
        this.type = ((LambdaExp)localExpression).getReturnType();
      }
    }
  }
  
  public final Type getTypeRaw()
  {
    return this.type;
  }
  
  public final Expression inlineIfConstant(Procedure paramProcedure, InlineCalls paramInlineCalls)
  {
    return inlineIfConstant(paramProcedure, paramInlineCalls.getMessages());
  }
  
  public final Expression inlineIfConstant(Procedure paramProcedure, SourceMessages paramSourceMessages)
  {
    int i = this.args.length;
    Object[] arrayOfObject = new Object[i];
    int j = i;
    j--;
    Expression localExpression;
    if (j >= 0)
    {
      localExpression = this.args[j];
      if ((localExpression instanceof ReferenceExp))
      {
        Declaration localDeclaration = ((ReferenceExp)localExpression).getBinding();
        if (localDeclaration != null)
        {
          localExpression = localDeclaration.getValue();
          if (localExpression != QuoteExp.undefined_exp) {}
        }
      }
    }
    do
    {
      do
      {
        return this;
      } while (!(localExpression instanceof QuoteExp));
      arrayOfObject[j] = ((QuoteExp)localExpression).getValue();
      break;
      try
      {
        QuoteExp localQuoteExp = new QuoteExp(paramProcedure.applyN(arrayOfObject), this.type);
        return localQuoteExp;
      }
      catch (Throwable localThrowable) {}
    } while (paramSourceMessages == null);
    paramSourceMessages.error('w', "call to " + paramProcedure + " throws " + localThrowable);
    return this;
  }
  
  public final boolean isTailCall()
  {
    return getFlag(2);
  }
  
  protected boolean mustCompile()
  {
    return false;
  }
  
  public void print(OutPort paramOutPort)
  {
    paramOutPort.startLogicalBlock("(Apply", ")", 2);
    if (isTailCall()) {
      paramOutPort.print(" [tailcall]");
    }
    if ((this.type != null) && (this.type != Type.pointer_type))
    {
      paramOutPort.print(" => ");
      paramOutPort.print(this.type);
    }
    paramOutPort.writeSpaceFill();
    printLineColumn(paramOutPort);
    this.func.print(paramOutPort);
    for (int i = 0; i < this.args.length; i++)
    {
      paramOutPort.writeSpaceLinear();
      this.args[i].print(paramOutPort);
    }
    paramOutPort.endLogicalBlock(")");
  }
  
  public void setArg(int paramInt, Expression paramExpression)
  {
    this.args[paramInt] = paramExpression;
  }
  
  public void setArgs(Expression[] paramArrayOfExpression)
  {
    this.args = paramArrayOfExpression;
  }
  
  public void setFunction(Expression paramExpression)
  {
    this.func = paramExpression;
  }
  
  public final void setTailCall(boolean paramBoolean)
  {
    setFlag(paramBoolean, 2);
  }
  
  public final void setType(Type paramType)
  {
    this.type = paramType;
  }
  
  public boolean side_effects()
  {
    Object localObject = derefFunc(this.func).valueIfConstant();
    Expression[] arrayOfExpression;
    int i;
    if (((localObject instanceof Procedure)) && (((Procedure)localObject).isSideEffectFree()))
    {
      arrayOfExpression = this.args;
      i = arrayOfExpression.length;
    }
    for (int j = 0; j < i; j++) {
      if (arrayOfExpression[j].side_effects()) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    if (this == LambdaExp.unknownContinuation) {
      return "ApplyExp[unknownContinuation]";
    }
    StringBuilder localStringBuilder = new StringBuilder().append("ApplyExp/");
    if (this.args == null) {}
    for (int i = 0;; i = this.args.length) {
      return i + '[' + this.func + ']';
    }
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    return paramExpVisitor.visitApplyExp(this, paramD);
  }
  
  public void visitArgs(InlineCalls paramInlineCalls)
  {
    this.args = paramInlineCalls.visitExps(this.args, this.args.length, null);
  }
  
  protected <R, D> void visitChildren(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    this.func = paramExpVisitor.visitAndUpdate(this.func, paramD);
    if (paramExpVisitor.exitValue == null) {
      this.args = paramExpVisitor.visitExps(this.args, this.args.length, paramD);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ApplyExp
 * JD-Core Version:    0.7.0.1
 */