package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Stack;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class module_name
  extends Syntax
{
  public static final module_name module_name = new module_name();
  
  static
  {
    module_name.setName("module-name");
  }
  
  public void scanForm(Pair paramPair, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    Object localObject1 = paramPair.getCdr();
    SyntaxForm localSyntaxForm = null;
    while ((localObject1 instanceof SyntaxForm))
    {
      localSyntaxForm = (SyntaxForm)localObject1;
      localObject1 = localSyntaxForm.getDatum();
    }
    Object localObject2;
    if ((localObject1 instanceof Pair)) {
      localObject2 = ((Pair)localObject1).getCar();
    }
    while ((localObject2 instanceof SyntaxForm))
    {
      localSyntaxForm = (SyntaxForm)localObject2;
      localObject2 = localSyntaxForm.getDatum();
      continue;
      localObject2 = null;
    }
    String str1 = null;
    Declaration localDeclaration = null;
    Pair localPair2;
    String str2;
    if ((localObject2 instanceof Pair))
    {
      Pair localPair1 = (Pair)localObject2;
      if (localPair1.getCar() == "quote")
      {
        Object localObject3 = localPair1.getCdr();
        if ((localObject3 instanceof Pair))
        {
          localPair2 = (Pair)localObject3;
          if ((localPair2.getCdr() == LList.Empty) && ((localPair2.getCar() instanceof String))) {}
        }
        else
        {
          str2 = "invalid quoted symbol for 'module-name'";
        }
      }
    }
    while (str2 != null)
    {
      paramTranslator.formStack.add(paramTranslator.syntaxError(str2));
      return;
      str1 = (String)localPair2.getCar();
      localDeclaration = null;
      str2 = null;
      continue;
      if (((localObject2 instanceof FString)) || ((localObject2 instanceof String)))
      {
        str1 = localObject2.toString();
        localDeclaration = null;
        str2 = null;
      }
      else if ((localObject2 instanceof Symbol))
      {
        str1 = localObject2.toString();
        int j = str1.length();
        if ((j > 2) && (str1.charAt(0) == '<') && (str1.charAt(j - 1) == '>')) {
          str1 = str1.substring(1, j - 1);
        }
        localDeclaration = paramTranslator.define(localObject2, localSyntaxForm, paramScopeExp);
        str2 = null;
      }
      else
      {
        str2 = "un-implemented expression in module-name";
        localDeclaration = null;
        str1 = null;
      }
    }
    int i = str1.lastIndexOf('.');
    String str3 = str1;
    ModuleExp localModuleExp;
    if (i >= 0)
    {
      paramTranslator.classPrefix = str1.substring(0, i + 1);
      localModuleExp = paramTranslator.getModule();
      if (paramTranslator.mainClass != null) {
        break label527;
      }
      paramTranslator.mainClass = new ClassType(str3);
    }
    for (;;)
    {
      localModuleExp.setType(paramTranslator.mainClass);
      localModuleExp.setName(str1);
      if (localDeclaration != null)
      {
        localDeclaration.noteValue(new QuoteExp(paramTranslator.mainClass, Compilation.typeClass));
        localDeclaration.setFlag(16793600L);
        if (localModuleExp.outer == null) {
          localDeclaration.setFlag(2048L);
        }
        localDeclaration.setPrivate(true);
        localDeclaration.setType(Compilation.typeClass);
      }
      paramTranslator.mustCompileHere();
      return;
      str1 = paramTranslator.classPrefix + str1;
      str3 = paramTranslator.classPrefix + Compilation.mangleName(str1);
      break;
      label527:
      String str4 = paramTranslator.mainClass.getName();
      if (str4 == null) {
        paramTranslator.mainClass.setName(str3);
      } else if (!str4.equals(str3)) {
        paramTranslator.syntaxError("duplicate module-name: old name: " + str4);
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.module_name
 * JD-Core Version:    0.7.0.1
 */