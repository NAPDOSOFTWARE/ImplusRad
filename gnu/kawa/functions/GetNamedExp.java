package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.PrimProcedure;
import gnu.expr.ReferenceExp;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.Symbol;

class GetNamedExp
  extends ApplyExp
{
  static final Declaration castDecl = Declaration.getDeclarationFromStatic("gnu.kawa.functions.Convert", "as");
  static final Declaration fieldDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.SlotGet", "field");
  static final Declaration instanceOfDecl;
  static final Declaration invokeDecl;
  static final Declaration invokeStaticDecl;
  static final Declaration makeDecl;
  static final Declaration staticFieldDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.SlotGet", "staticField");
  public String combinedName;
  char kind;
  PrimProcedure[] methods;
  
  static
  {
    makeDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.Invoke", "make");
    invokeDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.Invoke", "invoke");
    invokeStaticDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.Invoke", "invokeStatic");
    instanceOfDecl = Declaration.getDeclarationFromStatic("kawa.standard.Scheme", "instanceOf");
  }
  
  public GetNamedExp(Expression[] paramArrayOfExpression)
  {
    super(GetNamedPart.getNamedPart, paramArrayOfExpression);
  }
  
  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    if (this.combinedName != null)
    {
      Environment localEnvironment = Environment.getCurrent();
      Symbol localSymbol = localEnvironment.getSymbol(this.combinedName);
      String str = Location.UNBOUND;
      Object localObject = localEnvironment.get(localSymbol, null, str);
      if (localObject != str)
      {
        paramCallContext.writeValue(localObject);
        return;
      }
    }
    super.apply(paramCallContext);
  }
  
  protected GetNamedExp setProcedureKind(char paramChar)
  {
    this.type = Compilation.typeProcedure;
    this.kind = paramChar;
    return this;
  }
  
  public boolean side_effects()
  {
    if ((this.kind == 'S') || (this.kind == 'N') || (this.kind == 'C') || (this.kind == 'I')) {
      return false;
    }
    if (this.kind == 'M') {
      return getArgs()[0].side_effects();
    }
    return true;
  }
  
  public Expression validateApply(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Declaration paramDeclaration)
  {
    Expression[] arrayOfExpression1 = getArgs();
    Expression localExpression = arrayOfExpression1[0];
    Expression[] arrayOfExpression2 = paramApplyExp.getArgs();
    Declaration localDeclaration;
    Expression[] arrayOfExpression3;
    switch (this.kind)
    {
    default: 
      return paramApplyExp;
    case 'M': 
      localDeclaration = invokeDecl;
      arrayOfExpression3 = new Expression[2 + arrayOfExpression2.length];
      arrayOfExpression3[0] = arrayOfExpression1[0];
      arrayOfExpression3[1] = arrayOfExpression1[1];
      System.arraycopy(arrayOfExpression2, 0, arrayOfExpression3, 2, arrayOfExpression2.length);
    }
    for (;;)
    {
      ApplyExp localApplyExp = new ApplyExp(new ReferenceExp(localDeclaration), arrayOfExpression3);
      localApplyExp.setLine(paramApplyExp);
      return paramInlineCalls.visit(localApplyExp, paramType);
      localDeclaration = makeDecl;
      arrayOfExpression3 = new Expression[1 + arrayOfExpression2.length];
      System.arraycopy(arrayOfExpression2, 0, arrayOfExpression3, 1, arrayOfExpression2.length);
      arrayOfExpression3[0] = localExpression;
      continue;
      localDeclaration = instanceOfDecl;
      arrayOfExpression3 = new Expression[1 + arrayOfExpression2.length];
      System.arraycopy(arrayOfExpression2, 1, arrayOfExpression3, 2, -1 + arrayOfExpression2.length);
      arrayOfExpression3[0] = arrayOfExpression2[0];
      arrayOfExpression3[1] = localExpression;
      continue;
      localDeclaration = castDecl;
      arrayOfExpression3 = new Expression[1 + arrayOfExpression2.length];
      System.arraycopy(arrayOfExpression2, 1, arrayOfExpression3, 2, -1 + arrayOfExpression2.length);
      arrayOfExpression3[0] = localExpression;
      arrayOfExpression3[1] = arrayOfExpression2[0];
      continue;
      localDeclaration = invokeStaticDecl;
      arrayOfExpression3 = new Expression[2 + arrayOfExpression2.length];
      arrayOfExpression3[0] = localExpression;
      arrayOfExpression3[1] = arrayOfExpression1[1];
      System.arraycopy(arrayOfExpression2, 0, arrayOfExpression3, 2, arrayOfExpression2.length);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.GetNamedExp
 * JD-Core Version:    0.7.0.1
 */