package gnu.commonlisp.lang;

import gnu.expr.BeginExp;
import gnu.expr.Expression;
import gnu.expr.SetExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class setq
  extends Syntax
{
  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Object localObject1 = paramPair.getCdr();
    Vector localVector = null;
    while (localObject1 != LList.Empty)
    {
      Object localObject5;
      if (!(localObject1 instanceof Pair)) {
        localObject5 = paramTranslator.syntaxError("invalid syntax for setq");
      }
      label110:
      do
      {
        return localObject5;
        Pair localPair1 = (Pair)localObject1;
        Object localObject2 = localPair1.getCar();
        if (((localObject2 instanceof Symbol)) || ((localObject2 instanceof String))) {}
        Object localObject4;
        for (Object localObject3 = localObject2;; localObject3 = "nil")
        {
          localObject4 = localPair1.getCdr();
          if ((localObject4 instanceof Pair)) {
            break label110;
          }
          return paramTranslator.syntaxError("wrong number of arguments for setq");
          if (localObject2 != CommonLisp.FALSE) {
            break;
          }
        }
        return paramTranslator.syntaxError("invalid variable name in setq");
        Pair localPair2 = (Pair)localObject4;
        Expression localExpression = paramTranslator.rewrite(localPair2.getCar());
        localObject1 = localPair2.getCdr();
        localObject5 = new SetExp(localObject3, localExpression);
        ((SetExp)localObject5).setFlag(8);
        if (localObject1 != LList.Empty) {
          break;
        }
        ((SetExp)localObject5).setHasValue(true);
      } while (localVector == null);
      if (localVector == null) {
        localVector = new Vector(10);
      }
      localVector.addElement(localObject5);
    }
    if (localVector == null) {
      return CommonLisp.nilExpr;
    }
    Expression[] arrayOfExpression = new Expression[localVector.size()];
    localVector.copyInto(arrayOfExpression);
    return new BeginExp(arrayOfExpression);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.commonlisp.lang.setq
 * JD-Core Version:    0.7.0.1
 */