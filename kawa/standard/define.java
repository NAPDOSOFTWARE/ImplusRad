package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Stack;
import kawa.lang.Lambda;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class define
  extends Syntax
{
  public static final define defineRaw = new define(SchemeCompilation.lambda);
  Lambda lambda;
  
  public define(Lambda paramLambda)
  {
    this.lambda = paramLambda;
  }
  
  String getName(int paramInt)
  {
    if ((paramInt & 0x4) != 0) {
      return "define-private";
    }
    if ((paramInt & 0x8) != 0) {
      return "define-constant";
    }
    return "define";
  }
  
  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Pair localPair1 = (Pair)paramPair.getCdr();
    Pair localPair2 = (Pair)localPair1.getCdr();
    Pair localPair3 = (Pair)((Pair)localPair2.getCdr()).getCdr();
    Object localObject1 = Translator.stripSyntax(localPair1.getCar());
    int i = ((Number)Translator.stripSyntax(localPair2.getCar())).intValue();
    int j;
    Object localObject4;
    if ((i & 0x4) != 0)
    {
      j = 1;
      if ((localObject1 instanceof Declaration)) {
        break label115;
      }
      localObject4 = paramTranslator.syntaxError(getName(i) + " is only allowed in a <body>");
    }
    label115:
    Declaration localDeclaration;
    do
    {
      return localObject4;
      j = 0;
      break;
      localDeclaration = (Declaration)localObject1;
      if (localDeclaration.getFlag(8192L))
      {
        Expression localExpression = localDeclaration.getTypeExp();
        if ((localExpression instanceof LangExp)) {
          localDeclaration.setType(paramTranslator.exp2Type((Pair)((LangExp)localExpression).getLangValue()));
        }
      }
      if ((i & 0x2) == 0) {
        break label285;
      }
      LambdaExp localLambdaExp = (LambdaExp)localDeclaration.getValue();
      Object localObject5 = localPair3.getCdr();
      this.lambda.rewriteBody(localLambdaExp, localObject5, paramTranslator);
      localObject2 = localLambdaExp;
      if (!Compilation.inlineOk) {
        localDeclaration.noteValue(null);
      }
      localObject4 = new SetExp(localDeclaration, (Expression)localObject2);
      ((SetExp)localObject4).setDefining(true);
    } while ((j == 0) || ((paramTranslator.currentScope() instanceof ModuleExp)));
    paramTranslator.error('w', "define-private not at top level " + paramTranslator.currentScope());
    return localObject4;
    label285:
    Object localObject2 = paramTranslator.rewrite(localPair3.getCar());
    if (((localDeclaration.context instanceof ModuleExp)) && (j == 0) && (localDeclaration.getCanWrite())) {}
    for (Object localObject3 = null;; localObject3 = localObject2)
    {
      localDeclaration.noteValue((Expression)localObject3);
      break;
    }
  }
  
  public void scanForm(Pair paramPair, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    Pair localPair1 = (Pair)paramPair.getCdr();
    Pair localPair2 = (Pair)localPair1.getCdr();
    Pair localPair3 = (Pair)localPair2.getCdr();
    Pair localPair4 = (Pair)localPair3.getCdr();
    SyntaxForm localSyntaxForm = null;
    for (Object localObject1 = localPair1.getCar(); (localObject1 instanceof SyntaxForm); localObject1 = localSyntaxForm.getDatum()) {
      localSyntaxForm = (SyntaxForm)localObject1;
    }
    int i = ((Number)Translator.stripSyntax(localPair2.getCar())).intValue();
    int j;
    if ((i & 0x4) != 0)
    {
      j = 1;
      if ((i & 0x8) == 0) {
        break label504;
      }
    }
    label504:
    for (int k = 1;; k = 0)
    {
      paramTranslator.currentScope();
      Object localObject2 = paramTranslator.namespaceResolve(localObject1);
      if (!(localObject2 instanceof Symbol))
      {
        paramTranslator.error('e', "'" + localObject2 + "' is not a valid identifier");
        localObject2 = null;
      }
      Object localObject3 = paramTranslator.pushPositionOf(localPair1);
      Declaration localDeclaration = paramTranslator.define(localObject2, localSyntaxForm, paramScopeExp);
      paramTranslator.popPositionOf(localObject3);
      Object localObject4 = localDeclaration.getSymbol();
      if (j != 0)
      {
        localDeclaration.setFlag(16777216L);
        localDeclaration.setPrivate(true);
      }
      if (k != 0) {
        localDeclaration.setFlag(16384L);
      }
      localDeclaration.setFlag(262144L);
      if ((i & 0x2) != 0)
      {
        LambdaExp localLambdaExp = new LambdaExp();
        localLambdaExp.setSymbol(localObject4);
        if (Compilation.inlineOk)
        {
          localDeclaration.setProcedureDecl(true);
          localDeclaration.setType(Compilation.typeProcedure);
          localLambdaExp.nameDecl = localDeclaration;
        }
        Object localObject5 = localPair4.getCar();
        Object localObject6 = localPair4.getCdr();
        Translator.setLine(localLambdaExp, localPair1);
        this.lambda.rewriteFormals(localLambdaExp, localObject5, paramTranslator, null);
        Object localObject7 = this.lambda.rewriteAttrs(localLambdaExp, localObject6, paramTranslator);
        if (localObject7 != localObject6)
        {
          Object localObject8 = localPair2.getCar();
          Object localObject9 = localPair3.getCar();
          Pair localPair6 = new Pair(localObject5, localObject7);
          localPair2 = new Pair(localObject8, new Pair(localObject9, localPair6));
        }
        localDeclaration.noteValue(localLambdaExp);
      }
      if (((paramScopeExp instanceof ModuleExp)) && (j == 0) && ((!Compilation.inlineOk) || (paramTranslator.sharedModuleDefs()))) {
        localDeclaration.setCanWrite(true);
      }
      if ((i & 0x1) != 0)
      {
        LangExp localLangExp = new LangExp(localPair3);
        localDeclaration.setTypeExp(localLangExp);
        localDeclaration.setFlag(8192L);
      }
      Pair localPair5 = Translator.makePair(paramPair, this, Translator.makePair(localPair1, localDeclaration, localPair2));
      Translator.setLine(localDeclaration, localPair1);
      paramTranslator.formStack.addElement(localPair5);
      return;
      j = 0;
      break;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.define
 * JD-Core Version:    0.7.0.1
 */