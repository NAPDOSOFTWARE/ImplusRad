package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class module_static
  extends Syntax
{
  public static final module_static module_static = new module_static();
  
  static
  {
    module_static.setName("module-static");
  }
  
  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    return null;
  }
  
  public boolean scanForDefinitions(Pair paramPair, Vector paramVector, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    Object localObject = paramPair.getCdr();
    if (!(paramScopeExp instanceof ModuleExp))
    {
      paramTranslator.error('e', "'" + getName() + "' not at module level");
      return true;
    }
    ModuleExp localModuleExp = (ModuleExp)paramScopeExp;
    if ((localObject instanceof Pair))
    {
      Pair localPair5 = (Pair)localObject;
      if ((localPair5.getCdr() == LList.Empty) && ((localPair5.getCar() instanceof Boolean))) {
        if (localPair5.getCar() == Boolean.FALSE) {
          localModuleExp.setFlag(65536);
        }
      }
    }
    for (;;)
    {
      if ((localModuleExp.getFlag(65536)) && (localModuleExp.getFlag(32768)))
      {
        paramTranslator.error('e', "inconsistent module-static specifiers");
        return true;
        localModuleExp.setFlag(32768);
        continue;
        if (!(localObject instanceof Pair)) {
          break label308;
        }
        Pair localPair2 = (Pair)localObject;
        if ((localPair2.getCdr() != LList.Empty) || (!(localPair2.getCar() instanceof Pair))) {
          break label308;
        }
        Pair localPair3 = (Pair)localPair2.getCar();
        if (!paramTranslator.matches(localPair3.getCar(), "quote")) {
          break label308;
        }
        Pair localPair4 = (Pair)localPair3.getCdr();
        if ((localPair4 != LList.Empty) && ((localPair4.getCar() instanceof SimpleSymbol)) && (localPair4.getCar().toString() == "init-run"))
        {
          localModuleExp.setFlag(32768);
          localModuleExp.setFlag(262144);
        }
      }
      else
      {
        break;
      }
      paramTranslator.error('e', "invalid quoted symbol for '" + getName() + '\'');
      return false;
      label308:
      localModuleExp.setFlag(65536);
      while (localObject != LList.Empty)
      {
        Pair localPair1;
        if ((localObject instanceof Pair))
        {
          localPair1 = (Pair)localObject;
          if ((localPair1.getCar() instanceof Symbol)) {}
        }
        else
        {
          paramTranslator.error('e', "invalid syntax in '" + getName() + '\'');
          return false;
        }
        Declaration localDeclaration = paramScopeExp.getNoDefine((Symbol)localPair1.getCar());
        if (localDeclaration.getFlag(512L)) {
          Translator.setLine(localDeclaration, localPair1);
        }
        localDeclaration.setFlag(2048L);
        localObject = localPair1.getCdr();
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.module_static
 * JD-Core Version:    0.7.0.1
 */