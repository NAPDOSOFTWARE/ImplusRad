package kawa.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.functions.CompileNamedPart;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Environment;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import java.util.IdentityHashMap;
import java.util.Vector;

public class Quote
  extends Syntax
{
  private static final Object CYCLE;
  protected static final int QUOTE_DEPTH = -1;
  private static final Object WORKING;
  static final Method appendMethod = quoteType.getDeclaredMethod("append$V", 1);
  static final Method consXMethod;
  static final Method makePairMethod = Compilation.typePair.getDeclaredMethod("make", 2);
  static final Method makeVectorMethod = ClassType.make("gnu.lists.FVector").getDeclaredMethod("make", 1);
  public static final Quote plainQuote = new Quote("quote", false);
  public static final Quote quasiQuote = new Quote("quasiquote", true);
  static final ClassType quoteType;
  static final Method vectorAppendMethod;
  protected boolean isQuasi;
  
  static
  {
    WORKING = new String("(working)");
    CYCLE = new String("(cycle)");
    vectorAppendMethod = ClassType.make("kawa.standard.vector_append").getDeclaredMethod("apply$V", 1);
    quoteType = ClassType.make("kawa.lang.Quote");
    consXMethod = quoteType.getDeclaredMethod("consX$V", 1);
  }
  
  public Quote(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.isQuasi = paramBoolean;
  }
  
  public static Object append$V(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    if (i == 0)
    {
      localObject2 = LList.Empty;
      return localObject2;
    }
    Object localObject1 = paramArrayOfObject[(i - 1)];
    int j = i - 1;
    Object localObject2 = localObject1;
    label28:
    j--;
    Object localObject3;
    Object localObject4;
    SyntaxForm localSyntaxForm;
    Object localObject5;
    if (j >= 0)
    {
      localObject3 = paramArrayOfObject[j];
      localObject4 = null;
      localSyntaxForm = null;
      localObject5 = null;
      while ((localObject3 instanceof SyntaxForm))
      {
        localSyntaxForm = (SyntaxForm)localObject3;
        localObject3 = localSyntaxForm.getDatum();
      }
      if (localObject3 != LList.Empty) {
        break label103;
      }
      if (localObject4 == null) {
        break label197;
      }
      localObject4.setCdr(localObject2);
    }
    for (;;)
    {
      localObject2 = localObject5;
      break label28;
      break;
      label103:
      Pair localPair1 = (Pair)localObject3;
      Object localObject6 = localPair1.getCar();
      if ((localSyntaxForm != null) && (!(localObject6 instanceof SyntaxForm))) {
        localObject6 = SyntaxForms.makeForm(localObject6, localSyntaxForm.getScope());
      }
      Pair localPair2 = new Pair(localObject6, null);
      if (localObject4 == null) {}
      for (Object localObject7 = localPair2;; localObject7 = localObject5)
      {
        localObject4 = localPair2;
        localObject3 = localPair1.getCdr();
        localObject5 = localObject7;
        break;
        localObject4.setCdr(localPair2);
      }
      label197:
      localObject5 = localObject2;
    }
  }
  
  public static Object consX$V(Object[] paramArrayOfObject)
  {
    return LList.consX(paramArrayOfObject);
  }
  
  private static ApplyExp makeInvokeMakeVector(Expression[] paramArrayOfExpression)
  {
    return new ApplyExp(makeVectorMethod, paramArrayOfExpression);
  }
  
  public static Symbol makeSymbol(Namespace paramNamespace, Object paramObject)
  {
    if ((paramObject instanceof CharSequence)) {}
    for (String str = ((CharSequence)paramObject).toString();; str = (String)paramObject) {
      return paramNamespace.getSymbol(str.intern());
    }
  }
  
  public static Object quote(Object paramObject)
  {
    return plainQuote.expand(paramObject, -1, (Translator)Compilation.getCurrent());
  }
  
  public static Object quote(Object paramObject, Translator paramTranslator)
  {
    return plainQuote.expand(paramObject, -1, paramTranslator);
  }
  
  protected Expression coerceExpression(Object paramObject, Translator paramTranslator)
  {
    if ((paramObject instanceof Expression)) {
      return (Expression)paramObject;
    }
    return leaf(paramObject, paramTranslator);
  }
  
  Object expand(Object paramObject1, int paramInt, SyntaxForm paramSyntaxForm, Object paramObject2, Translator paramTranslator)
  {
    IdentityHashMap localIdentityHashMap = (IdentityHashMap)paramObject2;
    Object localObject1 = localIdentityHashMap.get(paramObject1);
    if (localObject1 == WORKING) {
      localIdentityHashMap.put(paramObject1, CYCLE);
    }
    while ((localObject1 == CYCLE) || (localObject1 != null)) {
      return localObject1;
    }
    Object localObject2;
    if ((paramObject1 instanceof Pair)) {
      localObject2 = expand_pair((Pair)paramObject1, paramInt, paramSyntaxForm, paramObject2, paramTranslator);
    }
    for (;;)
    {
      if ((paramObject1 != localObject2) && (localIdentityHashMap.get(paramObject1) == CYCLE)) {
        paramTranslator.error('e', "cycle in non-literal data");
      }
      localIdentityHashMap.put(paramObject1, localObject2);
      return localObject2;
      if ((paramObject1 instanceof SyntaxForm))
      {
        SyntaxForm localSyntaxForm = (SyntaxForm)paramObject1;
        localObject2 = expand(localSyntaxForm.getDatum(), paramInt, localSyntaxForm, paramObject2, paramTranslator);
      }
      else
      {
        if ((paramObject1 instanceof FVector))
        {
          FVector localFVector = (FVector)paramObject1;
          int i = localFVector.size();
          Object[] arrayOfObject1 = new Object[i];
          byte[] arrayOfByte = new byte[i];
          int j = 0;
          int k = 0;
          if (k < i)
          {
            Object localObject4 = localFVector.get(k);
            int n = paramInt;
            if (((localObject4 instanceof Pair)) && (paramInt > -1))
            {
              Pair localPair1 = (Pair)localObject4;
              if (paramTranslator.matches(localPair1.getCar(), paramSyntaxForm, "unquote-splicing"))
              {
                n--;
                if (n == 0)
                {
                  Pair localPair2;
                  if ((localPair1.getCdr() instanceof Pair))
                  {
                    localPair2 = (Pair)localPair1.getCdr();
                    if (localPair2.getCdr() == LList.Empty) {}
                  }
                  else
                  {
                    return paramTranslator.syntaxError("invalid used of " + localPair1.getCar() + " in quasiquote template");
                  }
                  arrayOfObject1[k] = paramTranslator.rewrite_car(localPair2, paramSyntaxForm);
                  arrayOfByte[k] = 3;
                }
              }
            }
            for (;;)
            {
              if (arrayOfByte[k] > j) {
                j = arrayOfByte[k];
              }
              k++;
              break;
              arrayOfObject1[k] = expand(localObject4, n, paramSyntaxForm, paramObject2, paramTranslator);
              if (arrayOfObject1[k] == localObject4) {
                arrayOfByte[k] = 0;
              } else if ((arrayOfObject1[k] instanceof Expression)) {
                arrayOfByte[k] = 2;
              } else {
                arrayOfByte[k] = 1;
              }
            }
          }
          Object localObject3;
          if (j == 0) {
            localObject3 = localFVector;
          }
          for (;;)
          {
            localObject2 = localObject3;
            break;
            if (j == 1)
            {
              localObject3 = new FVector(arrayOfObject1);
            }
            else
            {
              Expression[] arrayOfExpression1 = new Expression[i];
              int m = 0;
              if (m < i)
              {
                if (arrayOfByte[m] == 3) {
                  arrayOfExpression1[m] = ((Expression)arrayOfObject1[m]);
                }
                for (;;)
                {
                  m++;
                  break;
                  if (j < 3)
                  {
                    arrayOfExpression1[m] = coerceExpression(arrayOfObject1[m], paramTranslator);
                  }
                  else if (arrayOfByte[m] < 2)
                  {
                    Object[] arrayOfObject2 = new Object[1];
                    arrayOfObject2[0] = arrayOfObject1[m];
                    arrayOfExpression1[m] = leaf(new FVector(arrayOfObject2), paramTranslator);
                  }
                  else
                  {
                    Expression[] arrayOfExpression2 = new Expression[1];
                    arrayOfExpression2[0] = ((Expression)arrayOfObject1[m]);
                    arrayOfExpression1[m] = makeInvokeMakeVector(arrayOfExpression2);
                  }
                }
              }
              if (j < 3)
              {
                localObject3 = makeInvokeMakeVector(arrayOfExpression1);
              }
              else
              {
                Method localMethod = vectorAppendMethod;
                localObject3 = new ApplyExp(localMethod, arrayOfExpression1);
              }
            }
          }
        }
        localObject2 = paramObject1;
      }
    }
  }
  
  protected Object expand(Object paramObject, int paramInt, Translator paramTranslator)
  {
    return expand(paramObject, paramInt, null, new IdentityHashMap(), paramTranslator);
  }
  
  protected boolean expandColonForms()
  {
    return true;
  }
  
  Object expand_pair(Pair paramPair, int paramInt, SyntaxForm paramSyntaxForm, Object paramObject, Translator paramTranslator)
  {
    Pair localPair1 = paramPair;
    Pair localPair2 = localPair1;
    Pair localPair7;
    Expression localExpression2;
    Expression localExpression3;
    Namespace localNamespace;
    Symbol localSymbol1;
    Object localObject3;
    Object localObject4;
    if ((expandColonForms()) && (localPair1 == paramPair) && (paramTranslator.matches(localPair1.getCar(), paramSyntaxForm, LispLanguage.lookup_sym)) && ((localPair1.getCdr() instanceof Pair)))
    {
      localPair7 = (Pair)localPair1.getCdr();
      if ((localPair7 instanceof Pair))
      {
        Pair localPair8 = (Pair)localPair7.getCdr();
        if (((localPair8 instanceof Pair)) && (localPair8.getCdr() == LList.Empty))
        {
          localExpression2 = paramTranslator.rewrite_car(localPair7, false);
          localExpression3 = paramTranslator.rewrite_car(localPair8, false);
          localNamespace = paramTranslator.namespaceResolvePrefix(localExpression2);
          localSymbol1 = paramTranslator.namespaceResolve(localNamespace, localExpression3);
          if (localSymbol1 != null)
          {
            localObject3 = localPair2;
            localObject4 = localSymbol1;
          }
        }
      }
    }
    for (;;)
    {
      if (paramPair != localObject3) {
        break label1086;
      }
      return localObject4;
      if ((localNamespace != null) && (paramInt == 1))
      {
        Method localMethod2 = quoteType.getDeclaredMethod("makeSymbol", 2);
        Expression[] arrayOfExpression4 = new Expression[2];
        arrayOfExpression4[0] = QuoteExp.getInstance(localNamespace);
        arrayOfExpression4[1] = localExpression3;
        ApplyExp localApplyExp2 = new ApplyExp(localMethod2, arrayOfExpression4);
        localObject3 = localPair2;
        localObject4 = localApplyExp2;
      }
      else if (((localExpression2 instanceof ReferenceExp)) && ((localExpression3 instanceof QuoteExp)))
      {
        Symbol localSymbol3 = paramTranslator.getGlobalEnvironment().getSymbol(((ReferenceExp)localExpression2).getName() + ':' + ((QuoteExp)localExpression3).getValue().toString());
        localObject3 = localPair2;
        localObject4 = localSymbol3;
      }
      else
      {
        String str = CompileNamedPart.combineName(localExpression2, localExpression3);
        if (str != null)
        {
          Symbol localSymbol2 = paramTranslator.getGlobalEnvironment().getSymbol(str);
          localObject3 = localPair2;
          localObject4 = localSymbol2;
        }
        else
        {
          Object localObject11 = paramTranslator.pushPositionOf(localPair1);
          paramTranslator.error('e', "'" + localPair7.getCar() + "' is not a valid prefix");
          paramTranslator.popPositionOf(localObject11);
          localObject3 = localPair2;
          localObject4 = localSymbol1;
          continue;
          if (paramInt < 0) {}
          label899:
          for (;;)
          {
            label406:
            if ((paramInt == 1) && ((localPair1.getCar() instanceof Pair)))
            {
              Object localObject7 = localPair1.getCar();
              SyntaxForm localSyntaxForm = paramSyntaxForm;
              for (;;)
              {
                if ((localObject7 instanceof SyntaxForm))
                {
                  localSyntaxForm = (SyntaxForm)localObject7;
                  localObject7 = localSyntaxForm.getDatum();
                  continue;
                  if (paramTranslator.matches(localPair1.getCar(), paramSyntaxForm, "quasiquote"))
                  {
                    paramInt++;
                    break label406;
                  }
                  if (paramTranslator.matches(localPair1.getCar(), paramSyntaxForm, "unquote"))
                  {
                    paramInt--;
                    Pair localPair6;
                    if ((localPair1.getCdr() instanceof Pair))
                    {
                      localPair6 = (Pair)localPair1.getCdr();
                      if (localPair6.getCdr() == LList.Empty) {}
                    }
                    else
                    {
                      return paramTranslator.syntaxError("invalid used of " + localPair1.getCar() + " in quasiquote template");
                    }
                    if (paramInt != 0) {
                      break label406;
                    }
                    Expression localExpression1 = paramTranslator.rewrite_car(localPair6, paramSyntaxForm);
                    localObject3 = localPair2;
                    localObject4 = localExpression1;
                    break;
                  }
                  if (!paramTranslator.matches(localPair1.getCar(), paramSyntaxForm, "unquote-splicing")) {
                    break label406;
                  }
                  return paramTranslator.syntaxError("invalid used of " + localPair1.getCar() + " in quasiquote template");
                }
              }
              int n = -1;
              Object localObject10;
              label681:
              Object localObject8;
              Vector localVector;
              label705:
              Object localObject9;
              Expression[] arrayOfExpression3;
              if ((localObject7 instanceof Pair))
              {
                localObject10 = ((Pair)localObject7).getCar();
                if (paramTranslator.matches(localObject10, localSyntaxForm, "unquote")) {
                  n = 0;
                }
              }
              else
              {
                if (n < 0) {
                  break label907;
                }
                localObject8 = ((Pair)localObject7).getCdr();
                localVector = new Vector();
                if ((localObject8 instanceof SyntaxForm))
                {
                  localSyntaxForm = (SyntaxForm)localObject8;
                  localObject8 = localSyntaxForm.getDatum();
                }
                if (localObject8 != LList.Empty) {
                  break label852;
                }
                int i1 = 1 + localVector.size();
                localObject9 = expand(localPair1.getCdr(), 1, paramSyntaxForm, paramObject, paramTranslator);
                if (i1 > 1)
                {
                  arrayOfExpression3 = new Expression[i1];
                  localVector.copyInto(arrayOfExpression3);
                  arrayOfExpression3[(i1 - 1)] = coerceExpression(localObject9, paramTranslator);
                  if (n != 0) {
                    break label899;
                  }
                }
              }
              for (Method localMethod1 = consXMethod;; localMethod1 = appendMethod)
              {
                localObject9 = new ApplyExp(localMethod1, arrayOfExpression3);
                localObject3 = localPair1;
                localObject4 = localObject9;
                break;
                if (!paramTranslator.matches(localObject10, localSyntaxForm, "unquote-splicing")) {
                  break label681;
                }
                n = 1;
                break label681;
                label852:
                if ((localObject8 instanceof Pair))
                {
                  localVector.addElement(paramTranslator.rewrite_car((Pair)localObject8, localSyntaxForm));
                  localObject8 = ((Pair)localObject8).getCdr();
                  break label705;
                }
                return paramTranslator.syntaxError("improper list argument to unquote");
              }
            }
          }
          label907:
          Object localObject1 = expand(localPair1.getCar(), paramInt, paramSyntaxForm, paramObject, paramTranslator);
          if (localObject1 == localPair1.getCar())
          {
            localObject3 = localPair1.getCdr();
            if ((localObject3 instanceof Pair))
            {
              localPair1 = (Pair)localObject3;
              break;
            }
            localObject4 = expand(localObject3, paramInt, paramSyntaxForm, paramObject, paramTranslator);
            continue;
          }
          Object localObject2 = expand(localPair1.getCdr(), paramInt, paramSyntaxForm, paramObject, paramTranslator);
          if (((localObject1 instanceof Expression)) || ((localObject2 instanceof Expression)))
          {
            Expression[] arrayOfExpression1 = new Expression[2];
            arrayOfExpression1[0] = coerceExpression(localObject1, paramTranslator);
            arrayOfExpression1[1] = coerceExpression(localObject2, paramTranslator);
            ApplyExp localApplyExp1 = new ApplyExp(makePairMethod, arrayOfExpression1);
            localObject3 = localPair2;
            localObject4 = localApplyExp1;
          }
          else
          {
            Pair localPair5 = Translator.makePair(localPair1, localObject1, localObject2);
            localObject3 = localPair2;
            localObject4 = localPair5;
          }
        }
      }
    }
    label1086:
    Pair localPair3 = paramPair;
    Object localObject5 = new Pair[20];
    int i = 0;
    int j = localObject5.length;
    if (i >= j)
    {
      Pair[] arrayOfPair = new Pair[i * 2];
      System.arraycopy(localObject5, 0, arrayOfPair, 0, i);
      localObject5 = arrayOfPair;
    }
    int k = i + 1;
    localObject5[i] = localPair3;
    if (localPair3.getCdr() == localObject3) {
      if (!(localObject4 instanceof Expression)) {
        break label1224;
      }
    }
    int m;
    label1224:
    for (Object localObject6 = LList.Empty;; localObject6 = localObject4)
    {
      m = k;
      for (;;)
      {
        m--;
        if (m < 0) {
          break;
        }
        Pair localPair4 = localObject5[m];
        localObject6 = Translator.makePair(localPair4, localPair4.getCar(), localObject6);
      }
      localPair3 = (Pair)localPair3.getCdr();
      i = k;
      break;
    }
    if ((localObject4 instanceof Expression))
    {
      Expression[] arrayOfExpression2 = new Expression[2];
      arrayOfExpression2[1] = ((Expression)localObject4);
      if (m == 1)
      {
        arrayOfExpression2[0] = leaf(paramPair.getCar(), paramTranslator);
        return new ApplyExp(makePairMethod, arrayOfExpression2);
      }
      arrayOfExpression2[0] = leaf(localObject6, paramTranslator);
      return new ApplyExp(appendMethod, arrayOfExpression2);
    }
    return localObject6;
  }
  
  protected Expression leaf(Object paramObject, Translator paramTranslator)
  {
    return new QuoteExp(paramObject);
  }
  
  public Expression rewrite(Object paramObject, Translator paramTranslator)
  {
    Pair localPair;
    if ((paramObject instanceof Pair))
    {
      localPair = (Pair)paramObject;
      if (localPair.getCdr() == LList.Empty) {}
    }
    else
    {
      return paramTranslator.syntaxError("wrong number of arguments to quote");
    }
    Object localObject = localPair.getCar();
    if (this.isQuasi) {}
    for (int i = 1;; i = -1) {
      return coerceExpression(expand(localObject, i, paramTranslator), paramTranslator);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.Quote
 * JD-Core Version:    0.7.0.1
 */