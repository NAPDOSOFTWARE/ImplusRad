package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.util.IdentityHashTable;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.IntNum;
import gnu.text.SourceMessages;
import java.lang.reflect.InvocationTargetException;

public class InlineCalls
  extends ExpExpVisitor<Type>
{
  private static Class[] inlinerMethodArgTypes;
  
  public InlineCalls(Compilation paramCompilation)
  {
    setContext(paramCompilation);
  }
  
  public static Integer checkIntValue(Expression paramExpression)
  {
    if ((paramExpression instanceof QuoteExp))
    {
      QuoteExp localQuoteExp = (QuoteExp)paramExpression;
      Object localObject = localQuoteExp.getValue();
      if ((!localQuoteExp.isExplicitlyTyped()) && ((localObject instanceof IntNum)))
      {
        IntNum localIntNum = (IntNum)localObject;
        if (localIntNum.inIntRange()) {
          return Integer.valueOf(localIntNum.intValue());
        }
      }
    }
    return null;
  }
  
  public static Long checkLongValue(Expression paramExpression)
  {
    if ((paramExpression instanceof QuoteExp))
    {
      QuoteExp localQuoteExp = (QuoteExp)paramExpression;
      Object localObject = localQuoteExp.getValue();
      if ((!localQuoteExp.isExplicitlyTyped()) && ((localObject instanceof IntNum)))
      {
        IntNum localIntNum = (IntNum)localObject;
        if (localIntNum.inLongRange()) {
          return Long.valueOf(localIntNum.longValue());
        }
      }
    }
    return null;
  }
  
  private static Class[] getInlinerMethodArgTypes()
    throws Exception
  {
    try
    {
      Class[] arrayOfClass = inlinerMethodArgTypes;
      if (arrayOfClass == null)
      {
        arrayOfClass = new Class[4];
        arrayOfClass[0] = Class.forName("gnu.expr.ApplyExp");
        arrayOfClass[1] = Class.forName("gnu.expr.InlineCalls");
        arrayOfClass[2] = Class.forName("gnu.bytecode.Type");
        arrayOfClass[3] = Class.forName("gnu.mapping.Procedure");
        inlinerMethodArgTypes = arrayOfClass;
      }
      return arrayOfClass;
    }
    finally {}
  }
  
  public static Expression inlineCall(LambdaExp paramLambdaExp, Expression[] paramArrayOfExpression, boolean paramBoolean)
  {
    if ((paramLambdaExp.keywords != null) || ((paramLambdaExp.nameDecl != null) && (!paramBoolean))) {
      return null;
    }
    int i;
    if (paramLambdaExp.max_args < 0) {
      i = 1;
    }
    while (((paramLambdaExp.min_args == paramLambdaExp.max_args) && (paramLambdaExp.min_args == paramArrayOfExpression.length)) || ((i != 0) && (paramLambdaExp.min_args == 0)))
    {
      Object localObject1 = null;
      int j = 0;
      IdentityHashTable localIdentityHashTable;
      Expression[] arrayOfExpression1;
      if (paramBoolean)
      {
        localIdentityHashTable = new IdentityHashTable();
        arrayOfExpression1 = Expression.deepCopy(paramArrayOfExpression, localIdentityHashTable);
        if ((arrayOfExpression1 == null) && (paramArrayOfExpression != null))
        {
          return null;
          i = 0;
        }
      }
      else
      {
        localIdentityHashTable = null;
        arrayOfExpression1 = paramArrayOfExpression;
      }
      if (i != 0)
      {
        Expression[] arrayOfExpression2 = new Expression[1 + paramArrayOfExpression.length];
        arrayOfExpression2[0] = QuoteExp.getInstance(paramLambdaExp.firstDecl().type);
        System.arraycopy(paramArrayOfExpression, 0, arrayOfExpression2, 1, paramArrayOfExpression.length);
        arrayOfExpression1 = new Expression[1];
        arrayOfExpression1[0] = new ApplyExp(Invoke.make, arrayOfExpression2);
      }
      LetExp localLetExp = new LetExp(arrayOfExpression1);
      Object localObject2 = paramLambdaExp.firstDecl();
      if (localObject2 != null)
      {
        Declaration localDeclaration1 = ((Declaration)localObject2).nextDecl();
        if (paramBoolean)
        {
          Declaration localDeclaration2 = localLetExp.addDeclaration(((Declaration)localObject2).symbol, ((Declaration)localObject2).type);
          if (((Declaration)localObject2).typeExp != null)
          {
            localDeclaration2.typeExp = Expression.deepCopy(((Declaration)localObject2).typeExp);
            if (localDeclaration2.typeExp == null) {
              return null;
            }
          }
          localIdentityHashTable.put(localObject2, localDeclaration2);
        }
        for (;;)
        {
          if ((i == 0) && (!((Declaration)localObject2).getCanWrite())) {
            ((Declaration)localObject2).setValue(arrayOfExpression1[j]);
          }
          localObject1 = localObject2;
          localObject2 = localDeclaration1;
          j++;
          break;
          paramLambdaExp.remove(localObject1, (Declaration)localObject2);
          localLetExp.add(localObject1, (Declaration)localObject2);
        }
      }
      Expression localExpression = paramLambdaExp.body;
      if (paramBoolean)
      {
        localExpression = Expression.deepCopy(localExpression, localIdentityHashTable);
        if ((localExpression == null) && (paramLambdaExp.body != null)) {
          return null;
        }
      }
      localLetExp.body = localExpression;
      return localLetExp;
    }
    return null;
  }
  
  public static Expression inlineCalls(Expression paramExpression, Compilation paramCompilation)
  {
    return new InlineCalls(paramCompilation).visit(paramExpression, null);
  }
  
  public Expression checkType(Expression paramExpression, Type paramType)
  {
    int i = 1;
    Object localObject = paramExpression.getType();
    if (((paramType instanceof ClassType)) && (((ClassType)paramType).isInterface()) && (((Type)localObject).isSubtype(Compilation.typeProcedure)) && (!((Type)localObject).isSubtype(paramType)))
    {
      if ((paramExpression instanceof LambdaExp))
      {
        gnu.bytecode.Method localMethod = ((ClassType)paramType).checkSingleAbstractMethod();
        if (localMethod != null)
        {
          LambdaExp localLambdaExp = (LambdaExp)paramExpression;
          ObjectExp localObjectExp = new ObjectExp();
          localObjectExp.setLocation(paramExpression);
          Expression[] arrayOfExpression = new Expression[i];
          arrayOfExpression[0] = new QuoteExp(paramType);
          localObjectExp.supers = arrayOfExpression;
          localObjectExp.setTypes(getCompilation());
          String str = localMethod.getName();
          localObjectExp.addMethod(localLambdaExp, str);
          localObjectExp.addDeclaration(str, Compilation.typeProcedure);
          localObjectExp.firstChild = localLambdaExp;
          localObjectExp.declareParts(this.comp);
          return visit(localObjectExp, paramType);
        }
      }
      i = 1;
    }
    label303:
    for (;;)
    {
      if (i != 0)
      {
        Language localLanguage = this.comp.getLanguage();
        this.comp.error('w', "type " + localLanguage.formatType((Type)localObject) + " is incompatible with required type " + localLanguage.formatType(paramType), paramExpression);
      }
      return paramExpression;
      if (localObject == Type.toStringType) {
        localObject = Type.javalangStringType;
      }
      if ((paramType != null) && (paramType.compare((Type)localObject) == -3)) {}
      for (;;)
      {
        if ((i == 0) || (!(paramType instanceof TypeValue))) {
          break label303;
        }
        Expression localExpression = ((TypeValue)paramType).convertValue(paramExpression);
        if (localExpression == null) {
          break;
        }
        return localExpression;
        i = 0;
      }
    }
  }
  
  public QuoteExp fixIntValue(Expression paramExpression)
  {
    Integer localInteger = checkIntValue(paramExpression);
    if (localInteger != null) {
      return new QuoteExp(localInteger, this.comp.getLanguage().getTypeFor(Integer.TYPE));
    }
    return null;
  }
  
  public QuoteExp fixLongValue(Expression paramExpression)
  {
    Long localLong = checkLongValue(paramExpression);
    if (localLong != null) {
      return new QuoteExp(localLong, this.comp.getLanguage().getTypeFor(Long.TYPE));
    }
    return null;
  }
  
  public Expression maybeInline(ApplyExp paramApplyExp, Type paramType, Procedure paramProcedure)
  {
    for (;;)
    {
      java.lang.reflect.Method localMethod;
      Object[] arrayOfObject;
      try
      {
        try
        {
          localObject2 = paramProcedure.getProperty(Procedure.validateApplyKey, null);
          if ((localObject2 instanceof String))
          {
            String str1 = (String)localObject2;
            int i = str1.indexOf(':');
            localMethod = null;
            if (i > 0)
            {
              String str2 = str1.substring(0, i);
              String str3 = str1.substring(i + 1);
              localMethod = Class.forName(str2, true, paramProcedure.getClass().getClassLoader()).getDeclaredMethod(str3, getInlinerMethodArgTypes());
            }
            if (localMethod != null) {
              break label282;
            }
            error('e', "inliner property string for " + paramProcedure + " is not of the form CLASS:METHOD");
            return null;
          }
          if (localObject2 != null)
          {
            arrayOfObject = new Object[] { paramApplyExp, this, paramType, paramProcedure };
            if (!(localObject2 instanceof Procedure)) {
              break label255;
            }
            Expression localExpression2 = (Expression)((Procedure)localObject2).applyN(arrayOfObject);
            return localExpression2;
          }
        }
        finally {}
        Throwable localThrowable2;
        return null;
      }
      catch (Throwable localThrowable1)
      {
        if ((localThrowable1 instanceof InvocationTargetException)) {
          localThrowable2 = ((InvocationTargetException)localThrowable1).getTargetException();
        }
        this.messages.error('e', "caught exception in inliner for " + paramProcedure + " - " + localThrowable2, localThrowable2);
      }
      label255:
      while (!(localObject2 instanceof java.lang.reflect.Method)) {}
      Expression localExpression1 = (Expression)((java.lang.reflect.Method)localObject2).invoke(null, arrayOfObject);
      return localExpression1;
      label282:
      Object localObject2 = localMethod;
    }
  }
  
  public Expression visit(Expression paramExpression, Type paramType)
  {
    if (!paramExpression.getFlag(1))
    {
      paramExpression.setFlag(1);
      paramExpression = (Expression)super.visit(paramExpression, paramType);
      paramExpression.setFlag(1);
    }
    return checkType(paramExpression, paramType);
  }
  
  protected Expression visitApplyExp(ApplyExp paramApplyExp, Type paramType)
  {
    Expression localExpression1 = paramApplyExp.func;
    if ((localExpression1 instanceof LambdaExp))
    {
      ((LambdaExp)localExpression1);
      Expression localExpression3 = inlineCall((LambdaExp)localExpression1, paramApplyExp.args, false);
      if (localExpression3 != null) {
        return visit(localExpression3, paramType);
      }
    }
    Expression localExpression2 = visit(localExpression1, null);
    paramApplyExp.func = localExpression2;
    return localExpression2.validateApply(paramApplyExp, this, paramType, null);
  }
  
  public final Expression visitApplyOnly(ApplyExp paramApplyExp, Type paramType)
  {
    return paramApplyExp.func.validateApply(paramApplyExp, this, paramType, null);
  }
  
  protected Expression visitBeginExp(BeginExp paramBeginExp, Type paramType)
  {
    int i = -1 + paramBeginExp.length;
    int j = 0;
    if (j <= i)
    {
      Expression[] arrayOfExpression = paramBeginExp.exps;
      Expression localExpression = paramBeginExp.exps[j];
      if (j < i) {}
      for (Type localType = null;; localType = paramType)
      {
        arrayOfExpression[j] = visit(localExpression, localType);
        j++;
        break;
      }
    }
    return paramBeginExp;
  }
  
  protected Expression visitIfExp(IfExp paramIfExp, Type paramType)
  {
    Object localObject = (Expression)paramIfExp.test.visit(this, null);
    if ((localObject instanceof ReferenceExp))
    {
      Declaration localDeclaration = ((ReferenceExp)localObject).getBinding();
      if (localDeclaration != null)
      {
        Expression localExpression = localDeclaration.getValue();
        if (((localExpression instanceof QuoteExp)) && (localExpression != QuoteExp.undefined_exp)) {
          localObject = localExpression;
        }
      }
    }
    paramIfExp.test = ((Expression)localObject);
    if (this.exitValue == null) {
      paramIfExp.then_clause = visit(paramIfExp.then_clause, paramType);
    }
    if ((this.exitValue == null) && (paramIfExp.else_clause != null)) {
      paramIfExp.else_clause = visit(paramIfExp.else_clause, paramType);
    }
    if ((localObject instanceof QuoteExp)) {
      paramIfExp = paramIfExp.select(this.comp.getLanguage().isTrue(((QuoteExp)localObject).getValue()));
    }
    while (!((Expression)localObject).getType().isVoid()) {
      return paramIfExp;
    }
    boolean bool = this.comp.getLanguage().isTrue(Values.empty);
    this.comp.error('w', "void-valued condition is always " + bool);
    return new BeginExp((Expression)localObject, paramIfExp.select(bool));
  }
  
  protected Expression visitLambdaExp(LambdaExp paramLambdaExp, Type paramType)
  {
    Declaration localDeclaration = paramLambdaExp.firstDecl();
    if ((localDeclaration != null) && (localDeclaration.isThisParameter()) && (!paramLambdaExp.isClassMethod()) && (localDeclaration.type == null)) {
      localDeclaration.setType(this.comp.mainClass);
    }
    return visitScopeExp(paramLambdaExp, paramType);
  }
  
  protected Expression visitLetExp(LetExp paramLetExp, Type paramType)
  {
    Declaration localDeclaration1 = paramLetExp.firstDecl();
    int i = paramLetExp.inits.length;
    int j = 0;
    if (j < i)
    {
      Expression localExpression3 = paramLetExp.inits[j];
      boolean bool = localDeclaration1.getFlag(8192L);
      if ((bool) && (localExpression3 != QuoteExp.undefined_exp)) {}
      for (Type localType = localDeclaration1.getType();; localType = null)
      {
        Expression localExpression4 = visit(localExpression3, localType);
        paramLetExp.inits[j] = localExpression4;
        if (localDeclaration1.value == localExpression3)
        {
          localDeclaration1.value = localExpression4;
          if (!bool) {
            localDeclaration1.setType(localExpression4.getType());
          }
        }
        j++;
        localDeclaration1 = localDeclaration1.nextDecl();
        break;
      }
    }
    if (this.exitValue == null) {
      paramLetExp.body = visit(paramLetExp.body, paramType);
    }
    if ((paramLetExp.body instanceof ReferenceExp))
    {
      ReferenceExp localReferenceExp = (ReferenceExp)paramLetExp.body;
      Declaration localDeclaration2 = localReferenceExp.getBinding();
      if ((localDeclaration2 != null) && (localDeclaration2.context == paramLetExp) && (!localReferenceExp.getDontDereference()) && (i == 1))
      {
        Expression localExpression1 = paramLetExp.inits[0];
        Expression localExpression2 = localDeclaration2.getTypeExp();
        if (localExpression2 != QuoteExp.classObjectExp) {
          localExpression1 = visitApplyOnly(Compilation.makeCoercion(localExpression1, localExpression2), null);
        }
        return localExpression1;
      }
    }
    return paramLetExp;
  }
  
  protected Expression visitQuoteExp(QuoteExp paramQuoteExp, Type paramType)
  {
    int i;
    QuoteExp localQuoteExp;
    if ((paramQuoteExp.getRawType() == null) && (!paramQuoteExp.isSharedConstant()))
    {
      Object localObject1 = paramQuoteExp.getValue();
      if (localObject1 != null)
      {
        Object localObject2 = this.comp.getLanguage().getTypeFor(localObject1.getClass());
        if (localObject2 == Type.toStringType) {
          localObject2 = Type.javalangStringType;
        }
        paramQuoteExp.type = ((Type)localObject2);
        if ((paramType instanceof PrimType))
        {
          i = paramType.getSignature().charAt(0);
          if (i != 73) {
            break label99;
          }
          localQuoteExp = fixIntValue(paramQuoteExp);
        }
      }
    }
    for (;;)
    {
      if (localQuoteExp != null) {
        paramQuoteExp = localQuoteExp;
      }
      return paramQuoteExp;
      label99:
      if (i == 74) {
        localQuoteExp = fixLongValue(paramQuoteExp);
      } else {
        localQuoteExp = null;
      }
    }
  }
  
  protected Expression visitReferenceExp(ReferenceExp paramReferenceExp, Type paramType)
  {
    Declaration localDeclaration1 = paramReferenceExp.getBinding();
    if ((localDeclaration1 != null) && (localDeclaration1.field == null) && (!localDeclaration1.getCanWrite()))
    {
      Expression localExpression = localDeclaration1.getValue();
      if (((localExpression instanceof QuoteExp)) && (localExpression != QuoteExp.undefined_exp)) {
        return visitQuoteExp((QuoteExp)localExpression, paramType);
      }
      if (((localExpression instanceof ReferenceExp)) && (!localDeclaration1.isAlias()))
      {
        ReferenceExp localReferenceExp = (ReferenceExp)localExpression;
        Declaration localDeclaration2 = localReferenceExp.getBinding();
        Type localType = localDeclaration1.getType();
        if ((localDeclaration2 != null) && (!localDeclaration2.getCanWrite()) && ((localType == null) || (localType == Type.pointer_type) || (localType == localDeclaration2.getType())) && (!localReferenceExp.getDontDereference())) {
          return visitReferenceExp(localReferenceExp, paramType);
        }
      }
      if ((!paramReferenceExp.isProcedureName()) && ((0x100080 & localDeclaration1.flags) == 1048704L))
      {
        this.comp.error('e', "unimplemented: reference to method " + localDeclaration1.getName() + " as variable");
        this.comp.error('e', localDeclaration1, "here is the definition of ", "");
      }
    }
    return (Expression)super.visitReferenceExp(paramReferenceExp, paramType);
  }
  
  protected Expression visitScopeExp(ScopeExp paramScopeExp, Type paramType)
  {
    paramScopeExp.visitChildren(this, null);
    visitDeclarationTypes(paramScopeExp);
    Declaration localDeclaration = paramScopeExp.firstDecl();
    if (localDeclaration != null)
    {
      Expression localExpression;
      if (localDeclaration.type == null)
      {
        localExpression = localDeclaration.getValue();
        localDeclaration.type = Type.objectType;
        if ((localExpression == null) || (localExpression == QuoteExp.undefined_exp)) {
          break label74;
        }
      }
      label74:
      for (Object localObject = localExpression.getType();; localObject = Type.objectType)
      {
        localDeclaration.setType((Type)localObject);
        localDeclaration = localDeclaration.nextDecl();
        break;
      }
    }
    return paramScopeExp;
  }
  
  protected Expression visitSetExp(SetExp paramSetExp, Type paramType)
  {
    Declaration localDeclaration = paramSetExp.getBinding();
    super.visitSetExp(paramSetExp, paramType);
    if ((!paramSetExp.isDefining()) && (localDeclaration != null) && ((0x100080 & localDeclaration.flags) == 1048704L)) {
      this.comp.error('e', "can't assign to method " + localDeclaration.getName(), paramSetExp);
    }
    if ((localDeclaration != null) && (localDeclaration.getFlag(8192L)) && (CompileReflect.checkKnownClass(localDeclaration.getType(), this.comp) < 0)) {
      localDeclaration.setType(Type.errorType);
    }
    return paramSetExp;
  }
  
  protected Expression visitSetExpValue(Expression paramExpression, Type paramType, Declaration paramDeclaration)
  {
    if ((paramDeclaration == null) || (paramDeclaration.isAlias())) {}
    for (Type localType = null;; localType = paramDeclaration.type) {
      return visit(paramExpression, localType);
    }
  }
  
  protected Expression visitTryExp(TryExp paramTryExp, Type paramType)
  {
    if ((paramTryExp.getCatchClauses() == null) && (paramTryExp.getFinallyClause() == null)) {
      return visit(paramTryExp.try_clause, paramType);
    }
    return (Expression)super.visitTryExp(paramTryExp, paramType);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.InlineCalls
 * JD-Core Version:    0.7.0.1
 */