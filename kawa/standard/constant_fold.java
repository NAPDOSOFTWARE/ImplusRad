package kawa.standard;

import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class constant_fold
  extends Syntax
{
  public static final constant_fold constant_fold = new constant_fold();
  
  static
  {
    constant_fold.setName("constant-fold");
  }
  
  static Object checkConstant(Expression paramExpression, Translator paramTranslator)
  {
    Object localObject;
    if ((paramExpression instanceof QuoteExp)) {
      localObject = ((QuoteExp)paramExpression).getValue();
    }
    boolean bool;
    do
    {
      return localObject;
      bool = paramExpression instanceof ReferenceExp;
      localObject = null;
    } while (!bool);
    ReferenceExp localReferenceExp = (ReferenceExp)paramExpression;
    Declaration localDeclaration = localReferenceExp.getBinding();
    if ((localDeclaration == null) || (localDeclaration.getFlag(65536L))) {
      return Environment.user().get(localReferenceExp.getName(), null);
    }
    return Declaration.followAliases(localDeclaration).getConstantValue();
  }
  
  public Expression rewrite(Object paramObject, Translator paramTranslator)
  {
    Expression localExpression1 = paramTranslator.rewrite(paramObject);
    if (!(localExpression1 instanceof ApplyExp)) {
      return localExpression1;
    }
    ApplyExp localApplyExp = (ApplyExp)localExpression1;
    Object localObject1 = checkConstant(localApplyExp.getFunction(), paramTranslator);
    if (!(localObject1 instanceof Procedure)) {
      return localExpression1;
    }
    Expression[] arrayOfExpression = localApplyExp.getArgs();
    int i = arrayOfExpression.length;
    Object[] arrayOfObject = new Object[i];
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      Object localObject2 = checkConstant(arrayOfExpression[i], paramTranslator);
      if (localObject2 == null) {
        return localExpression1;
      }
      arrayOfObject[i] = localObject2;
    }
    try
    {
      QuoteExp localQuoteExp = new QuoteExp(((Procedure)localObject1).applyN(arrayOfObject));
      return localQuoteExp;
    }
    catch (Throwable localThrowable)
    {
      Expression localExpression2 = paramTranslator.syntaxError("caught exception in constant-fold:");
      paramTranslator.syntaxError(localThrowable.toString());
      return localExpression2;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.constant_fold
 * JD-Core Version:    0.7.0.1
 */