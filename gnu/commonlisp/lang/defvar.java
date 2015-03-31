package gnu.commonlisp.lang;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class defvar
  extends Syntax
{
  boolean force;
  
  public defvar(boolean paramBoolean)
  {
    this.force = paramBoolean;
  }
  
  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Object localObject1 = paramPair.getCdr();
    boolean bool1 = localObject1 instanceof Pair;
    Declaration localDeclaration = null;
    Object localObject2 = null;
    Expression localExpression = null;
    Pair localPair1;
    if (bool1)
    {
      localPair1 = (Pair)localObject1;
      boolean bool2 = localPair1.getCar() instanceof Declaration;
      localDeclaration = null;
      localObject2 = null;
      localExpression = null;
      if (bool2)
      {
        localDeclaration = (Declaration)localPair1.getCar();
        localObject2 = localDeclaration.getSymbol();
        if (!(localPair1.getCdr() instanceof Pair)) {
          break label151;
        }
        Pair localPair2 = (Pair)localPair1.getCdr();
        localExpression = paramTranslator.rewrite(localPair2.getCar());
        if (localPair2.getCdr() == LList.Empty) {}
      }
    }
    Object localObject3;
    if (localObject2 == null) {
      localObject3 = paramTranslator.syntaxError("invalid syntax for " + getName());
    }
    label151:
    do
    {
      return localObject3;
      Object localObject4 = localPair1.getCdr();
      LList localLList = LList.Empty;
      localExpression = null;
      if (localObject4 == localLList) {
        break;
      }
      localObject2 = null;
      localExpression = null;
      break;
      if (localExpression == null)
      {
        if (!this.force) {
          break label275;
        }
        localExpression = CommonLisp.nilExpr;
      }
      localObject3 = new SetExp(localObject2, localExpression);
      if (!this.force) {
        ((SetExp)localObject3).setSetIfUnbound(true);
      }
      ((SetExp)localObject3).setDefining(true);
    } while (localDeclaration == null);
    ((SetExp)localObject3).setBinding(localDeclaration);
    if (((localDeclaration.context instanceof ModuleExp)) && (localDeclaration.getCanWrite())) {
      localExpression = null;
    }
    localDeclaration.noteValue(localExpression);
    return localObject3;
    label275:
    return new QuoteExp(localObject2);
  }
  
  public boolean scanForDefinitions(Pair paramPair, Vector paramVector, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    if (!(paramPair.getCdr() instanceof Pair)) {
      return super.scanForDefinitions(paramPair, paramVector, paramScopeExp, paramTranslator);
    }
    Pair localPair = (Pair)paramPair.getCdr();
    Object localObject = localPair.getCar();
    Declaration localDeclaration;
    if (((localObject instanceof String)) || ((localObject instanceof Symbol)))
    {
      localDeclaration = paramScopeExp.lookup(localObject);
      if (localDeclaration != null) {
        break label134;
      }
      localDeclaration = new Declaration(localObject);
      localDeclaration.setFlag(268435456L);
      paramScopeExp.addDeclaration(localDeclaration);
    }
    for (;;)
    {
      paramPair = Translator.makePair(paramPair, this, Translator.makePair(localPair, localDeclaration, localPair.getCdr()));
      if ((paramScopeExp instanceof ModuleExp))
      {
        localDeclaration.setCanRead(true);
        localDeclaration.setCanWrite(true);
      }
      paramVector.addElement(paramPair);
      return true;
      label134:
      paramTranslator.error('w', "duplicate declaration for `" + localObject + "'");
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.commonlisp.lang.defvar
 * JD-Core Version:    0.7.0.1
 */