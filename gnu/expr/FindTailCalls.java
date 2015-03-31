package gnu.expr;

import gnu.bytecode.Type;
import gnu.kawa.functions.AppendValues;
import java.util.HashSet;
import java.util.Set;

public class FindTailCalls
  extends ExpExpVisitor<Expression>
{
  public static void findTailCalls(Expression paramExpression, Compilation paramCompilation)
  {
    FindTailCalls localFindTailCalls = new FindTailCalls();
    localFindTailCalls.setContext(paramCompilation);
    localFindTailCalls.visit(paramExpression, paramExpression);
  }
  
  public void postVisitDecls(ScopeExp paramScopeExp)
  {
    for (Declaration localDeclaration1 = paramScopeExp.firstDecl(); localDeclaration1 != null; localDeclaration1 = localDeclaration1.nextDecl())
    {
      Expression localExpression = localDeclaration1.getValue();
      if ((localExpression instanceof LambdaExp))
      {
        LambdaExp localLambdaExp = (LambdaExp)localExpression;
        if (localDeclaration1.getCanRead()) {
          localLambdaExp.setCanRead(true);
        }
        if (localDeclaration1.getCanCall()) {
          localLambdaExp.setCanCall(true);
        }
      }
      if ((localDeclaration1.getFlag(1024L)) && ((localExpression instanceof ReferenceExp)))
      {
        Declaration localDeclaration2 = ((ReferenceExp)localExpression).contextDecl();
        if ((localDeclaration2 != null) && (localDeclaration2.isPrivate())) {
          localDeclaration2.setFlag(524288L);
        }
      }
    }
  }
  
  protected Expression visitApplyExp(ApplyExp paramApplyExp, Expression paramExpression)
  {
    int i;
    LambdaExp localLambdaExp;
    if (paramExpression == this.currentLambda.body)
    {
      i = 1;
      if (i != 0) {
        paramApplyExp.setTailCall(true);
      }
      paramApplyExp.context = this.currentLambda;
      if (!(paramApplyExp.func instanceof ReferenceExp)) {
        break label175;
      }
      Declaration localDeclaration = Declaration.followAliases(((ReferenceExp)paramApplyExp.func).binding);
      localLambdaExp = null;
      if (localDeclaration != null)
      {
        if (!localDeclaration.getFlag(2048L))
        {
          paramApplyExp.nextCall = localDeclaration.firstCall;
          localDeclaration.firstCall = paramApplyExp;
        }
        Compilation localCompilation = getCompilation();
        localDeclaration.setCanCall();
        if (!localCompilation.mustCompile) {
          localDeclaration.setCanRead();
        }
        Expression localExpression = localDeclaration.getValue();
        boolean bool = localExpression instanceof LambdaExp;
        localLambdaExp = null;
        if (bool) {
          localLambdaExp = (LambdaExp)localExpression;
        }
      }
      label142:
      if ((localLambdaExp != null) && (localLambdaExp.returnContinuation != paramExpression)) {
        break label274;
      }
    }
    for (;;)
    {
      paramApplyExp.args = visitExps(paramApplyExp.args);
      return paramApplyExp;
      i = 0;
      break;
      label175:
      if (((paramApplyExp.func instanceof LambdaExp)) && (!(paramApplyExp.func instanceof ClassExp)))
      {
        localLambdaExp = (LambdaExp)paramApplyExp.func;
        visitLambdaExp(localLambdaExp, false);
        localLambdaExp.setCanCall(true);
        break label142;
      }
      if (((paramApplyExp.func instanceof QuoteExp)) && (((QuoteExp)paramApplyExp.func).getValue() == AppendValues.appendValues))
      {
        localLambdaExp = null;
        break label142;
      }
      paramApplyExp.func = visitExpression(paramApplyExp.func, paramApplyExp.func);
      localLambdaExp = null;
      break label142;
      label274:
      if ((localLambdaExp != this.currentLambda) || (i == 0)) {
        if (i != 0)
        {
          if (localLambdaExp.tailCallers == null) {
            localLambdaExp.tailCallers = new HashSet();
          }
          localLambdaExp.tailCallers.add(this.currentLambda);
        }
        else if (localLambdaExp.returnContinuation == null)
        {
          localLambdaExp.returnContinuation = paramExpression;
          localLambdaExp.inlineHome = this.currentLambda;
        }
        else
        {
          localLambdaExp.returnContinuation = LambdaExp.unknownContinuation;
          localLambdaExp.inlineHome = null;
        }
      }
    }
  }
  
  protected Expression visitBeginExp(BeginExp paramBeginExp, Expression paramExpression)
  {
    int i = -1 + paramBeginExp.length;
    int j = 0;
    if (j <= i)
    {
      Expression[] arrayOfExpression = paramBeginExp.exps;
      Expression localExpression1 = paramBeginExp.exps[j];
      if (j == i) {}
      for (Expression localExpression2 = paramExpression;; localExpression2 = paramBeginExp.exps[j])
      {
        arrayOfExpression[j] = ((Expression)localExpression1.visit(this, localExpression2));
        j++;
        break;
      }
    }
    return paramBeginExp;
  }
  
  protected Expression visitBlockExp(BlockExp paramBlockExp, Expression paramExpression)
  {
    paramBlockExp.body = ((Expression)paramBlockExp.body.visit(this, paramExpression));
    if (paramBlockExp.exitBody != null) {
      paramBlockExp.exitBody = ((Expression)paramBlockExp.exitBody.visit(this, paramBlockExp.exitBody));
    }
    return paramBlockExp;
  }
  
  protected Expression visitClassExp(ClassExp paramClassExp, Expression paramExpression)
  {
    LambdaExp localLambdaExp1 = this.currentLambda;
    this.currentLambda = paramClassExp;
    try
    {
      for (LambdaExp localLambdaExp2 = paramClassExp.firstChild; (localLambdaExp2 != null) && (this.exitValue == null); localLambdaExp2 = localLambdaExp2.nextSibling) {
        visitLambdaExp(localLambdaExp2, false);
      }
      return paramClassExp;
    }
    finally
    {
      this.currentLambda = localLambdaExp1;
    }
  }
  
  protected Expression visitExpression(Expression paramExpression1, Expression paramExpression2)
  {
    return (Expression)super.visitExpression(paramExpression1, paramExpression1);
  }
  
  public Expression[] visitExps(Expression[] paramArrayOfExpression)
  {
    int i = paramArrayOfExpression.length;
    for (int j = 0; j < i; j++)
    {
      Expression localExpression = paramArrayOfExpression[j];
      paramArrayOfExpression[j] = ((Expression)visit(localExpression, localExpression));
    }
    return paramArrayOfExpression;
  }
  
  protected Expression visitFluidLetExp(FluidLetExp paramFluidLetExp, Expression paramExpression)
  {
    for (Declaration localDeclaration = paramFluidLetExp.firstDecl(); localDeclaration != null; localDeclaration = localDeclaration.nextDecl())
    {
      localDeclaration.setCanRead(true);
      if (localDeclaration.base != null) {
        localDeclaration.base.setCanRead(true);
      }
    }
    visitLetDecls(paramFluidLetExp);
    paramFluidLetExp.body = ((Expression)paramFluidLetExp.body.visit(this, paramFluidLetExp.body));
    postVisitDecls(paramFluidLetExp);
    return paramFluidLetExp;
  }
  
  protected Expression visitIfExp(IfExp paramIfExp, Expression paramExpression)
  {
    paramIfExp.test = ((Expression)paramIfExp.test.visit(this, paramIfExp.test));
    paramIfExp.then_clause = ((Expression)paramIfExp.then_clause.visit(this, paramExpression));
    Expression localExpression = paramIfExp.else_clause;
    if (localExpression != null) {
      paramIfExp.else_clause = ((Expression)localExpression.visit(this, paramExpression));
    }
    return paramIfExp;
  }
  
  protected Expression visitLambdaExp(LambdaExp paramLambdaExp, Expression paramExpression)
  {
    visitLambdaExp(paramLambdaExp, true);
    return paramLambdaExp;
  }
  
  /* Error */
  final void visitLambdaExp(LambdaExp paramLambdaExp, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 79	gnu/expr/FindTailCalls:currentLambda	Lgnu/expr/LambdaExp;
    //   4: astore_3
    //   5: aload_0
    //   6: aload_1
    //   7: putfield 79	gnu/expr/FindTailCalls:currentLambda	Lgnu/expr/LambdaExp;
    //   10: iload_2
    //   11: ifeq +8 -> 19
    //   14: aload_1
    //   15: iconst_1
    //   16: invokevirtual 44	gnu/expr/LambdaExp:setCanRead	(Z)V
    //   19: aload_1
    //   20: getfield 268	gnu/expr/LambdaExp:defaultArgs	[Lgnu/expr/Expression;
    //   23: ifnull +15 -> 38
    //   26: aload_1
    //   27: aload_0
    //   28: aload_1
    //   29: getfield 268	gnu/expr/LambdaExp:defaultArgs	[Lgnu/expr/Expression;
    //   32: invokevirtual 136	gnu/expr/FindTailCalls:visitExps	([Lgnu/expr/Expression;)[Lgnu/expr/Expression;
    //   35: putfield 268	gnu/expr/LambdaExp:defaultArgs	[Lgnu/expr/Expression;
    //   38: aload_0
    //   39: getfield 218	gnu/expr/FindTailCalls:exitValue	Ljava/lang/Object;
    //   42: ifnonnull +41 -> 83
    //   45: aload_1
    //   46: getfield 83	gnu/expr/LambdaExp:body	Lgnu/expr/Expression;
    //   49: ifnull +34 -> 83
    //   52: aload_1
    //   53: getfield 83	gnu/expr/LambdaExp:body	Lgnu/expr/Expression;
    //   56: astore 5
    //   58: aload_1
    //   59: invokevirtual 271	gnu/expr/LambdaExp:getInlineOnly	()Z
    //   62: ifeq +32 -> 94
    //   65: aload_1
    //   66: astore 6
    //   68: aload_1
    //   69: aload 5
    //   71: aload_0
    //   72: aload 6
    //   74: invokevirtual 195	gnu/expr/Expression:visit	(Lgnu/expr/ExpVisitor;Ljava/lang/Object;)Ljava/lang/Object;
    //   77: checkcast 179	gnu/expr/Expression
    //   80: putfield 83	gnu/expr/LambdaExp:body	Lgnu/expr/Expression;
    //   83: aload_0
    //   84: aload_3
    //   85: putfield 79	gnu/expr/FindTailCalls:currentLambda	Lgnu/expr/LambdaExp;
    //   88: aload_0
    //   89: aload_1
    //   90: invokevirtual 242	gnu/expr/FindTailCalls:postVisitDecls	(Lgnu/expr/ScopeExp;)V
    //   93: return
    //   94: aload_1
    //   95: getfield 83	gnu/expr/LambdaExp:body	Lgnu/expr/Expression;
    //   98: astore 6
    //   100: goto -32 -> 68
    //   103: astore 4
    //   105: aload_0
    //   106: aload_3
    //   107: putfield 79	gnu/expr/FindTailCalls:currentLambda	Lgnu/expr/LambdaExp;
    //   110: aload 4
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	FindTailCalls
    //   0	113	1	paramLambdaExp	LambdaExp
    //   0	113	2	paramBoolean	boolean
    //   4	103	3	localLambdaExp	LambdaExp
    //   103	8	4	localObject1	Object
    //   56	14	5	localExpression	Expression
    //   66	33	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   19	38	103	finally
    //   38	65	103	finally
    //   68	83	103	finally
    //   94	100	103	finally
  }
  
  void visitLetDecls(LetExp paramLetExp)
  {
    Declaration localDeclaration = paramLetExp.firstDecl();
    int i = paramLetExp.inits.length;
    int j = 0;
    while (j < i)
    {
      Object localObject = visitSetExp(localDeclaration, paramLetExp.inits[j]);
      if (localObject == QuoteExp.undefined_exp)
      {
        Expression localExpression = localDeclaration.getValue();
        if (((localExpression instanceof LambdaExp)) || ((localExpression != localObject) && ((localExpression instanceof QuoteExp)))) {
          localObject = localExpression;
        }
      }
      paramLetExp.inits[j] = localObject;
      j++;
      localDeclaration = localDeclaration.nextDecl();
    }
  }
  
  protected Expression visitLetExp(LetExp paramLetExp, Expression paramExpression)
  {
    visitLetDecls(paramLetExp);
    paramLetExp.body = ((Expression)paramLetExp.body.visit(this, paramExpression));
    postVisitDecls(paramLetExp);
    return paramLetExp;
  }
  
  protected Expression visitReferenceExp(ReferenceExp paramReferenceExp, Expression paramExpression)
  {
    Declaration localDeclaration1 = Declaration.followAliases(paramReferenceExp.binding);
    if (localDeclaration1 != null)
    {
      Type localType = localDeclaration1.type;
      if ((localType != null) && (localType.isVoid())) {
        paramReferenceExp = QuoteExp.voidExp;
      }
    }
    Declaration localDeclaration2;
    do
    {
      return paramReferenceExp;
      localDeclaration1.setCanRead(true);
      localDeclaration2 = paramReferenceExp.contextDecl();
    } while (localDeclaration2 == null);
    localDeclaration2.setCanRead(true);
    return paramReferenceExp;
  }
  
  final Expression visitSetExp(Declaration paramDeclaration, Expression paramExpression)
  {
    if ((paramDeclaration != null) && (paramDeclaration.getValue() == paramExpression) && ((paramExpression instanceof LambdaExp)) && (!(paramExpression instanceof ClassExp)) && (!paramDeclaration.isPublic()))
    {
      LambdaExp localLambdaExp = (LambdaExp)paramExpression;
      visitLambdaExp(localLambdaExp, false);
      return localLambdaExp;
    }
    return (Expression)paramExpression.visit(this, paramExpression);
  }
  
  protected Expression visitSetExp(SetExp paramSetExp, Expression paramExpression)
  {
    Declaration localDeclaration1 = paramSetExp.binding;
    if ((localDeclaration1 != null) && (localDeclaration1.isAlias()))
    {
      if (paramSetExp.isDefining())
      {
        paramSetExp.new_value = ((Expression)paramSetExp.new_value.visit(this, paramSetExp.new_value));
        return paramSetExp;
      }
      localDeclaration1 = Declaration.followAliases(localDeclaration1);
    }
    Declaration localDeclaration2 = paramSetExp.contextDecl();
    if (localDeclaration2 != null) {
      localDeclaration2.setCanRead(true);
    }
    Expression localExpression = visitSetExp(localDeclaration1, paramSetExp.new_value);
    if ((localDeclaration1 != null) && ((localDeclaration1.context instanceof LetExp)) && (localExpression == localDeclaration1.getValue()) && (((localExpression instanceof LambdaExp)) || ((localExpression instanceof QuoteExp)))) {
      return QuoteExp.voidExp;
    }
    paramSetExp.new_value = localExpression;
    return paramSetExp;
  }
  
  protected Expression visitSynchronizedExp(SynchronizedExp paramSynchronizedExp, Expression paramExpression)
  {
    paramSynchronizedExp.object = ((Expression)paramSynchronizedExp.object.visit(this, paramSynchronizedExp.object));
    paramSynchronizedExp.body = ((Expression)paramSynchronizedExp.body.visit(this, paramSynchronizedExp.body));
    return paramSynchronizedExp;
  }
  
  protected Expression visitTryExp(TryExp paramTryExp, Expression paramExpression)
  {
    Expression localExpression1;
    CatchClause localCatchClause;
    if (paramTryExp.finally_clause == null)
    {
      localExpression1 = paramExpression;
      paramTryExp.try_clause = ((Expression)paramTryExp.try_clause.visit(this, localExpression1));
      localCatchClause = paramTryExp.catch_clauses;
      label31:
      if ((this.exitValue != null) || (localCatchClause == null)) {
        break label100;
      }
      if (paramTryExp.finally_clause != null) {
        break label90;
      }
    }
    label90:
    for (Expression localExpression3 = paramExpression;; localExpression3 = localCatchClause.body)
    {
      localCatchClause.body = ((Expression)localCatchClause.body.visit(this, localExpression3));
      localCatchClause = localCatchClause.getNext();
      break label31;
      localExpression1 = paramTryExp.try_clause;
      break;
    }
    label100:
    Expression localExpression2 = paramTryExp.finally_clause;
    if (localExpression2 != null) {
      paramTryExp.finally_clause = ((Expression)localExpression2.visit(this, localExpression2));
    }
    return paramTryExp;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.FindTailCalls
 * JD-Core Version:    0.7.0.1
 */