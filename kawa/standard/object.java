package kawa.standard;

import gnu.bytecode.Type;
import gnu.expr.BeginExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.ObjectExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.expr.ThisExp;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Lambda;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;

public class object
  extends Syntax
{
  public static final Keyword accessKeyword;
  public static final Keyword allocationKeyword;
  public static final Keyword classNameKeyword;
  static final Symbol coloncolon = Namespace.EmptyNamespace.getSymbol("::");
  static final Keyword initKeyword;
  static final Keyword init_formKeyword;
  static final Keyword init_keywordKeyword;
  static final Keyword init_valueKeyword;
  static final Keyword initformKeyword;
  public static final Keyword interfaceKeyword;
  public static final object objectSyntax = new object(SchemeCompilation.lambda);
  public static final Keyword throwsKeyword;
  static final Keyword typeKeyword;
  Lambda lambda;
  
  static
  {
    objectSyntax.setName("object");
    accessKeyword = Keyword.make("access");
    classNameKeyword = Keyword.make("class-name");
    interfaceKeyword = Keyword.make("interface");
    throwsKeyword = Keyword.make("throws");
    typeKeyword = Keyword.make("type");
    allocationKeyword = Keyword.make("allocation");
    initKeyword = Keyword.make("init");
    initformKeyword = Keyword.make("initform");
    init_formKeyword = Keyword.make("init-form");
    init_valueKeyword = Keyword.make("init-value");
    init_keywordKeyword = Keyword.make("init-keyword");
  }
  
  public object(Lambda paramLambda)
  {
    this.lambda = paramLambda;
  }
  
  static long addAccessFlags(Object paramObject, long paramLong1, long paramLong2, String paramString, Translator paramTranslator)
  {
    long l = matchAccess(paramObject, paramTranslator);
    if (l == 0L) {
      paramTranslator.error('e', "unknown access specifier " + paramObject);
    }
    for (;;)
    {
      return paramLong1 | l;
      if ((l & (0xFFFFFFFF ^ paramLong2)) != 0L) {
        paramTranslator.error('e', "invalid " + paramString + " access specifier " + paramObject);
      } else if ((paramLong1 & l) != 0L) {
        paramTranslator.error('w', "duplicate " + paramString + " access specifiers " + paramObject);
      }
    }
  }
  
  static long matchAccess(Object paramObject, Translator paramTranslator)
  {
    while ((paramObject instanceof SyntaxForm)) {
      paramObject = ((SyntaxForm)paramObject).getDatum();
    }
    if ((paramObject instanceof Pair))
    {
      ((Pair)paramObject);
      paramObject = paramTranslator.matchQuoted((Pair)paramObject);
      if ((paramObject instanceof Pair)) {
        return matchAccess2((Pair)paramObject, paramTranslator);
      }
    }
    return matchAccess1(paramObject, paramTranslator);
  }
  
  private static long matchAccess1(Object paramObject, Translator paramTranslator)
  {
    if ((paramObject instanceof Keyword)) {
      paramObject = ((Keyword)paramObject).getName();
    }
    while ("private".equals(paramObject))
    {
      return 16777216L;
      if ((paramObject instanceof FString)) {
        paramObject = ((FString)paramObject).toString();
      } else if ((paramObject instanceof SimpleSymbol)) {
        paramObject = paramObject.toString();
      }
    }
    if ("protected".equals(paramObject)) {
      return 33554432L;
    }
    if ("public".equals(paramObject)) {
      return 67108864L;
    }
    if ("package".equals(paramObject)) {
      return 134217728L;
    }
    if ("volatile".equals(paramObject)) {
      return 2147483648L;
    }
    if ("transient".equals(paramObject)) {
      return 4294967296L;
    }
    if ("enum".equals(paramObject)) {
      return 8589934592L;
    }
    if ("final".equals(paramObject)) {
      return 17179869184L;
    }
    return 0L;
  }
  
  private static long matchAccess2(Pair paramPair, Translator paramTranslator)
  {
    long l1 = matchAccess1(paramPair.getCar(), paramTranslator);
    Object localObject = paramPair.getCdr();
    if ((localObject == LList.Empty) || (l1 == 0L)) {
      return l1;
    }
    if ((localObject instanceof Pair))
    {
      long l2 = matchAccess2((Pair)localObject, paramTranslator);
      if (l2 != 0L) {
        return l1 | l2;
      }
    }
    return 0L;
  }
  
  static boolean matches(Object paramObject, String paramString, Translator paramTranslator)
  {
    String str;
    if ((paramObject instanceof Keyword)) {
      str = ((Keyword)paramObject).getName();
    }
    for (;;)
    {
      boolean bool2;
      if (paramString != null)
      {
        boolean bool4 = paramString.equals(str);
        bool2 = false;
        if (!bool4) {}
      }
      else
      {
        bool2 = true;
      }
      Object localObject;
      boolean bool3;
      do
      {
        boolean bool1;
        do
        {
          return bool2;
          if ((paramObject instanceof FString))
          {
            str = ((FString)paramObject).toString();
            break;
          }
          bool1 = paramObject instanceof Pair;
          bool2 = false;
        } while (!bool1);
        localObject = paramTranslator.matchQuoted((Pair)paramObject);
        bool3 = localObject instanceof SimpleSymbol;
        bool2 = false;
      } while (!bool3);
      str = localObject.toString();
    }
  }
  
  private static void rewriteInit(Object paramObject, ClassExp paramClassExp, Pair paramPair, Translator paramTranslator, SyntaxForm paramSyntaxForm)
  {
    boolean bool;
    LambdaExp localLambdaExp1;
    label30:
    label84:
    LambdaExp localLambdaExp2;
    Expression localExpression;
    SetExp localSetExp;
    if ((paramObject instanceof Declaration))
    {
      bool = ((Declaration)paramObject).getFlag(2048L);
      if (!bool) {
        break label214;
      }
      localLambdaExp1 = paramClassExp.clinitMethod;
      if (localLambdaExp1 == null)
      {
        localLambdaExp1 = new LambdaExp(new BeginExp());
        localLambdaExp1.setClassMethod(true);
        localLambdaExp1.setReturnType(Type.voidType);
        if (!bool) {
          break label223;
        }
        localLambdaExp1.setName("$clinit$");
        paramClassExp.clinitMethod = localLambdaExp1;
        localLambdaExp1.nextSibling = paramClassExp.firstChild;
        paramClassExp.firstChild = localLambdaExp1;
      }
      paramTranslator.push(localLambdaExp1);
      localLambdaExp2 = paramTranslator.curMethodLambda;
      paramTranslator.curMethodLambda = localLambdaExp1;
      localExpression = paramTranslator.rewrite_car(paramPair, paramSyntaxForm);
      if (!(paramObject instanceof Declaration)) {
        break label256;
      }
      Declaration localDeclaration = (Declaration)paramObject;
      localSetExp = new SetExp(localDeclaration, localExpression);
      localSetExp.setLocation(localDeclaration);
      localDeclaration.noteValue(null);
    }
    label256:
    for (Object localObject = localSetExp;; localObject = Compilation.makeCoercion(localExpression, new QuoteExp(Type.voidType)))
    {
      ((BeginExp)localLambdaExp1.body).add((Expression)localObject);
      paramTranslator.curMethodLambda = localLambdaExp2;
      paramTranslator.pop(localLambdaExp1);
      return;
      if (paramObject == Boolean.TRUE)
      {
        bool = true;
        break;
      }
      bool = false;
      break;
      label214:
      localLambdaExp1 = paramClassExp.initMethod;
      break label30;
      label223:
      localLambdaExp1.setName("$finit$");
      paramClassExp.initMethod = localLambdaExp1;
      localLambdaExp1.add(null, new Declaration(ThisExp.THIS_NAME));
      break label84;
    }
  }
  
  public void rewriteClassDef(Object[] paramArrayOfObject, Translator paramTranslator)
  {
    ClassExp localClassExp = (ClassExp)paramArrayOfObject[0];
    Object localObject1 = paramArrayOfObject[1];
    Vector localVector = (Vector)paramArrayOfObject[2];
    LambdaExp localLambdaExp1 = (LambdaExp)paramArrayOfObject[3];
    Object localObject2 = paramArrayOfObject[4];
    Object localObject3 = paramArrayOfObject[5];
    localClassExp.firstChild = localLambdaExp1;
    int i = Translator.listLength(localObject2);
    if (i < 0)
    {
      paramTranslator.error('e', "object superclass specification not a list");
      i = 0;
    }
    Expression[] arrayOfExpression = new Expression[i];
    for (int j = 0; j < i; j++)
    {
      while ((localObject2 instanceof SyntaxForm)) {
        localObject2 = ((SyntaxForm)localObject2).getDatum();
      }
      Pair localPair6 = (Pair)localObject2;
      arrayOfExpression[j] = paramTranslator.rewrite_car(localPair6, false);
      if ((arrayOfExpression[j] instanceof ReferenceExp))
      {
        Declaration localDeclaration = Declaration.followAliases(((ReferenceExp)arrayOfExpression[j]).getBinding());
        if (localDeclaration != null)
        {
          Expression localExpression = localDeclaration.getValue();
          if ((localExpression instanceof ClassExp)) {
            ((ClassExp)localExpression).setFlag(131072);
          }
        }
      }
      localObject2 = localPair6.getCdr();
    }
    if (localObject3 != null)
    {
      Object localObject22 = paramTranslator.rewrite_car((Pair)localObject3, false).valueIfConstant();
      if (!(localObject22 instanceof CharSequence)) {
        break label315;
      }
      String str = localObject22.toString();
      if (str.length() <= 0) {
        break label315;
      }
      localClassExp.classNameSpecifier = str;
    }
    for (;;)
    {
      localClassExp.supers = arrayOfExpression;
      localClassExp.setTypes(paramTranslator);
      int k = localVector.size();
      for (int m = 0; m < k; m += 2)
      {
        Object localObject21 = localVector.elementAt(m + 1);
        if (localObject21 != null) {
          rewriteInit(localVector.elementAt(m), localClassExp, (Pair)localObject21, paramTranslator, null);
        }
      }
      label315:
      Object localObject23 = paramTranslator.pushPositionOf(localObject3);
      paramTranslator.error('e', "class-name specifier must be a non-empty string literal");
      paramTranslator.popPositionOf(localObject23);
    }
    paramTranslator.push(localClassExp);
    LambdaExp localLambdaExp2 = localLambdaExp1;
    int n = 0;
    SyntaxForm localSyntaxForm1 = null;
    Object localObject4 = localObject1;
    LList localLList = LList.Empty;
    Object localObject5;
    SyntaxForm localSyntaxForm2;
    Pair localPair2;
    Object localObject9;
    SyntaxForm localSyntaxForm3;
    label582:
    int i1;
    Pair localPair4;
    Object localObject15;
    label758:
    Object localObject11;
    label769:
    label778:
    label829:
    SyntaxForm localSyntaxForm4;
    Object localObject12;
    label920:
    int i2;
    if (localObject4 != localLList)
    {
      while ((localObject4 instanceof SyntaxForm))
      {
        localSyntaxForm1 = (SyntaxForm)localObject4;
        localObject4 = localSyntaxForm1.getDatum();
      }
      Pair localPair1 = (Pair)localObject4;
      localObject5 = paramTranslator.pushPositionOf(localPair1);
      Object localObject6 = localPair1.getCar();
      localSyntaxForm2 = localSyntaxForm1;
      while ((localObject6 instanceof SyntaxForm))
      {
        localSyntaxForm2 = (SyntaxForm)localObject6;
        localObject6 = localSyntaxForm2.getDatum();
      }
      for (;;)
      {
        Object localObject10;
        Pair localPair3;
        Object localObject13;
        Object localObject14;
        try
        {
          localObject4 = localPair1.getCdr();
          if (((localObject6 instanceof Keyword)) && ((localObject4 instanceof Pair)))
          {
            Object localObject20 = ((Pair)localObject4).getCdr();
            localObject4 = localObject20;
            paramTranslator.popPositionOf(localObject5);
            break;
          }
          localPair2 = (Pair)localObject6;
          localObject9 = localPair2.getCar();
          localSyntaxForm3 = localSyntaxForm2;
          if ((localObject9 instanceof SyntaxForm))
          {
            localSyntaxForm3 = (SyntaxForm)localObject9;
            localObject9 = localSyntaxForm3.getDatum();
            continue;
          }
          if ((!(localObject9 instanceof String)) && (!(localObject9 instanceof Symbol)) && (!(localObject9 instanceof Keyword))) {
            break label1014;
          }
          if ((localObject9 instanceof Keyword))
          {
            localObject10 = localPair2;
            break label1242;
            if (localObject10 == LList.Empty) {
              break label920;
            }
            if ((localObject10 instanceof SyntaxForm))
            {
              localSyntaxForm2 = (SyntaxForm)localObject10;
              localObject10 = localSyntaxForm2.getDatum();
              continue;
            }
          }
          else
          {
            localObject10 = localPair2.getCdr();
            break label1242;
          }
          localPair3 = (Pair)localObject10;
          localObject13 = localPair3.getCar();
          if ((localObject13 instanceof SyntaxForm))
          {
            localObject13 = ((SyntaxForm)localObject13).getDatum();
            continue;
          }
          localObject14 = paramTranslator.pushPositionOf(localPair3);
          localObject10 = localPair3.getCdr();
          Symbol localSymbol1 = coloncolon;
          if (((localObject13 != localSymbol1) && (!(localObject13 instanceof Keyword))) || (!(localObject10 instanceof Pair))) {
            break label829;
          }
          i1++;
          localPair4 = (Pair)localObject10;
          localObject15 = localPair4.getCar();
          localObject10 = localPair4.getCdr();
          Symbol localSymbol2 = coloncolon;
          if (localObject13 == localSymbol2) {
            break label1257;
          }
          Keyword localKeyword1 = typeKeyword;
          if (localObject13 != localKeyword1) {
            break label778;
          }
          break label1257;
        }
        finally {}
        paramTranslator.popPositionOf(localObject14);
        continue;
        paramTranslator.popPositionOf(localObject5);
        throw localObject7;
        Keyword localKeyword2 = initKeyword;
        if (localObject13 == localKeyword2) {
          break label1264;
        }
        Keyword localKeyword3 = initformKeyword;
        if (localObject13 == localKeyword3) {
          break label1264;
        }
        Keyword localKeyword4 = init_formKeyword;
        if (localObject13 == localKeyword4) {
          break label1264;
        }
        Keyword localKeyword5 = init_valueKeyword;
        if (localObject13 == localKeyword5)
        {
          break label1264;
          if ((localObject10 == LList.Empty) && (localObject11 == null))
          {
            localObject11 = localPair3;
            localSyntaxForm4 = localSyntaxForm2;
          }
          else
          {
            if ((!(localObject10 instanceof Pair)) || (i1 != 0) || (localObject11 != null) || (localObject12 != null)) {
              break label920;
            }
            Pair localPair5 = (Pair)localObject10;
            if (localPair5.getCdr() != LList.Empty) {
              break label920;
            }
            localObject12 = localObject13;
            localObject11 = localPair5;
            localSyntaxForm4 = localSyntaxForm2;
            Object localObject17 = localPair5.getCdr();
            localObject10 = localObject17;
          }
        }
      }
      if (localObject11 != null) {
        i2 = n + 1;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject16 = localVector.elementAt(n);
        if ((localObject16 instanceof Declaration))
        {
          ((Declaration)localObject16).getFlag(2048L);
          n = i2 + 1;
          if (localVector.elementAt(i2) == null) {
            rewriteInit(localObject16, localClassExp, (Pair)localObject11, paramTranslator, localSyntaxForm4);
          }
          paramTranslator.popPositionOf(localObject5);
          break;
        }
        Boolean localBoolean = Boolean.TRUE;
        if (localObject16 == localBoolean) {
          continue;
        }
        continue;
        label1014:
        if ((localObject9 instanceof Pair))
        {
          ScopeExp localScopeExp = paramTranslator.currentScope();
          if (localSyntaxForm2 != null) {
            paramTranslator.setCurrentScope(localSyntaxForm2.getScope());
          }
          if ("*init*".equals(localLambdaExp2.getName())) {
            localLambdaExp2.setReturnType(Type.voidType);
          }
          Translator.setLine(localLambdaExp2, localPair2);
          LambdaExp localLambdaExp3 = paramTranslator.curMethodLambda;
          paramTranslator.curMethodLambda = localLambdaExp2;
          Lambda localLambda = this.lambda;
          Object localObject18 = ((Pair)localObject9).getCdr();
          Object localObject19 = localPair2.getCdr();
          if ((localSyntaxForm3 == null) || ((localSyntaxForm2 != null) && (localSyntaxForm3.getScope() == localSyntaxForm2.getScope()))) {
            break label1275;
          }
          localTemplateScope = localSyntaxForm3.getScope();
          localLambda.rewrite(localLambdaExp2, localObject18, localObject19, paramTranslator, localTemplateScope);
          paramTranslator.curMethodLambda = localLambdaExp3;
          if (localSyntaxForm2 != null) {
            paramTranslator.setCurrentScope(localScopeExp);
          }
          localLambdaExp2 = localLambdaExp2.nextSibling;
          continue;
        }
        paramTranslator.syntaxError("invalid field/method definition");
        continue;
        if (localClassExp.initMethod != null) {
          localClassExp.initMethod.outer = localClassExp;
        }
        if (localClassExp.clinitMethod != null) {
          localClassExp.clinitMethod.outer = localClassExp;
        }
        paramTranslator.pop(localClassExp);
        localClassExp.declareParts(paramTranslator);
        return;
      }
      finally {}
      break label769;
      label1242:
      localObject11 = null;
      localSyntaxForm4 = null;
      i1 = 0;
      localObject12 = null;
      break label582;
      label1257:
      localObject12 = localObject15;
      break label758;
      label1264:
      localObject11 = localPair4;
      localSyntaxForm4 = localSyntaxForm2;
      break label758;
      label1275:
      TemplateScope localTemplateScope = null;
    }
  }
  
  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Object localObject;
    if (!(paramPair.getCdr() instanceof Pair)) {
      localObject = paramTranslator.syntaxError("missing superclass specification in object");
    }
    Object[] arrayOfObject;
    do
    {
      return localObject;
      Pair localPair = (Pair)paramPair.getCdr();
      localObject = new ObjectExp();
      if ((localPair.getCar() instanceof FString))
      {
        if (!(localPair.getCdr() instanceof Pair)) {
          return paramTranslator.syntaxError("missing superclass specification after object class name");
        }
        localPair = (Pair)localPair.getCdr();
      }
      arrayOfObject = scanClassDef(localPair, (ClassExp)localObject, paramTranslator);
    } while (arrayOfObject == null);
    rewriteClassDef(arrayOfObject, paramTranslator);
    return localObject;
  }
  
  public Object[] scanClassDef(Pair paramPair, ClassExp paramClassExp, Translator paramTranslator)
  {
    paramTranslator.mustCompileHere();
    Object localObject1 = paramPair.getCar();
    Object localObject2 = paramPair.getCdr();
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    long l1 = 0L;
    Vector localVector = new Vector(20);
    Object localObject6 = localObject2;
    Object localObject7;
    Object localObject8;
    for (;;)
    {
      LList localLList = LList.Empty;
      if (localObject6 == localLList) {
        break label1489;
      }
      while ((localObject6 instanceof SyntaxForm)) {
        localObject6 = ((SyntaxForm)localObject6).getDatum();
      }
      if (!(localObject6 instanceof Pair))
      {
        paramTranslator.error('e', "object member not a list");
        return null;
      }
      Pair localPair1 = (Pair)localObject6;
      for (localObject7 = localPair1.getCar(); (localObject7 instanceof SyntaxForm); localObject7 = ((SyntaxForm)localObject7).getDatum()) {}
      localObject6 = localPair1.getCdr();
      localObject8 = paramTranslator.pushPositionOf(localPair1);
      if (!(localObject7 instanceof Keyword)) {
        break;
      }
      while ((localObject6 instanceof SyntaxForm)) {
        localObject6 = ((SyntaxForm)localObject6).getDatum();
      }
      if (!(localObject6 instanceof Pair)) {
        break;
      }
      Keyword localKeyword10 = interfaceKeyword;
      if (localObject7 == localKeyword10)
      {
        if (((Pair)localObject6).getCar() == Boolean.FALSE) {
          paramClassExp.setFlag(65536);
        }
        for (;;)
        {
          localObject6 = ((Pair)localObject6).getCdr();
          paramTranslator.popPositionOf(localObject8);
          break;
          paramClassExp.setFlag(32768);
        }
      }
      Keyword localKeyword11 = classNameKeyword;
      if (localObject7 == localKeyword11)
      {
        if (localObject3 != null) {
          paramTranslator.error('e', "duplicate class-name specifiers");
        }
        localObject3 = localObject6;
        localObject6 = ((Pair)localObject6).getCdr();
        paramTranslator.popPositionOf(localObject8);
      }
      else
      {
        Keyword localKeyword12 = accessKeyword;
        if (localObject7 != localKeyword12) {
          break;
        }
        Object localObject21 = paramTranslator.pushPositionOf(localObject6);
        l1 = addAccessFlags(((Pair)localObject6).getCar(), l1, 25820135424L, "class", paramTranslator);
        if (paramClassExp.nameDecl == null) {
          paramTranslator.error('e', "access specifier for anonymous class");
        }
        paramTranslator.popPositionOf(localObject21);
        localObject6 = ((Pair)localObject6).getCdr();
        paramTranslator.popPositionOf(localObject8);
      }
    }
    if (!(localObject7 instanceof Pair))
    {
      paramTranslator.error('e', "object member not a list");
      return null;
    }
    Pair localPair2 = (Pair)localObject7;
    for (Object localObject9 = localPair2.getCar(); (localObject9 instanceof SyntaxForm); localObject9 = ((SyntaxForm)localObject9).getDatum()) {}
    if (((localObject9 instanceof String)) || ((localObject9 instanceof Symbol)) || ((localObject9 instanceof Keyword)))
    {
      Object localObject10 = null;
      Object localObject11 = localObject9;
      int i = 0;
      long l2 = 0L;
      Declaration localDeclaration;
      if ((localObject11 instanceof Keyword)) {
        localDeclaration = null;
      }
      int j;
      int k;
      Object localObject13;
      Object localObject15;
      for (Object localObject12 = localPair2;; localObject12 = localPair2.getCdr())
      {
        j = 0;
        k = 0;
        localObject13 = null;
        if (localObject12 == LList.Empty) {
          break label1141;
        }
        for (localObject15 = localObject12; (localObject15 instanceof SyntaxForm); localObject15 = ((SyntaxForm)localObject15).getDatum()) {}
        localDeclaration = paramClassExp.addDeclaration(localObject11);
        localDeclaration.setSimple(false);
        localDeclaration.setFlag(1048576L);
        Translator.setLine(localDeclaration, localPair2);
      }
      Pair localPair3 = (Pair)localObject15;
      for (Object localObject16 = localPair3.getCar(); (localObject16 instanceof SyntaxForm); localObject16 = ((SyntaxForm)localObject16).getDatum()) {}
      Object localObject17 = paramTranslator.pushPositionOf(localPair3);
      localObject12 = localPair3.getCdr();
      Symbol localSymbol1 = coloncolon;
      Pair localPair5;
      Object localObject18;
      if (((localObject16 == localSymbol1) || ((localObject16 instanceof Keyword))) && ((localObject12 instanceof Pair)))
      {
        j++;
        localPair5 = (Pair)localObject12;
        localObject18 = localPair5.getCar();
        localObject12 = localPair5.getCdr();
        Symbol localSymbol2 = coloncolon;
        if (localObject16 != localSymbol2)
        {
          Keyword localKeyword1 = typeKeyword;
          if (localObject16 != localKeyword1) {}
        }
        else
        {
          localObject10 = localPair5;
        }
      }
      for (;;)
      {
        paramTranslator.popPositionOf(localObject17);
        break;
        Keyword localKeyword2 = allocationKeyword;
        if (localObject16 == localKeyword2)
        {
          if (i != 0) {
            paramTranslator.error('e', "duplicate allocation: specification");
          }
          if ((matches(localObject18, "class", paramTranslator)) || (matches(localObject18, "static", paramTranslator))) {
            i = 2048;
          } else if (matches(localObject18, "instance", paramTranslator)) {
            i = 4096;
          } else {
            paramTranslator.error('e', "unknown allocation kind '" + localObject18 + "'");
          }
        }
        else
        {
          Keyword localKeyword3 = initKeyword;
          if (localObject16 != localKeyword3)
          {
            Keyword localKeyword5 = initformKeyword;
            if (localObject16 != localKeyword5)
            {
              Keyword localKeyword6 = init_formKeyword;
              if (localObject16 != localKeyword6)
              {
                Keyword localKeyword7 = init_valueKeyword;
                if (localObject16 != localKeyword7) {
                  break label912;
                }
              }
            }
          }
          if (k != 0) {
            paramTranslator.error('e', "duplicate initialization");
          }
          k = 1;
          Keyword localKeyword4 = initKeyword;
          if (localObject16 != localKeyword4)
          {
            localObject13 = localPair5;
            continue;
            label912:
            Keyword localKeyword8 = init_keywordKeyword;
            if (localObject16 == localKeyword8)
            {
              if (!(localObject18 instanceof Keyword)) {
                paramTranslator.error('e', "invalid 'init-keyword' - not a keyword");
              } else if (((Keyword)localObject18).getName() != localObject11.toString()) {
                paramTranslator.error('w', "init-keyword option ignored");
              }
            }
            else
            {
              Keyword localKeyword9 = accessKeyword;
              if (localObject16 == localKeyword9)
              {
                Object localObject19 = paramTranslator.pushPositionOf(localPair5);
                l2 = addAccessFlags(localObject18, l2, 32463912960L, "field", paramTranslator);
                paramTranslator.popPositionOf(localObject19);
              }
              else
              {
                paramTranslator.error('w', "unknown slot keyword '" + localObject16 + "'");
                continue;
                if ((localObject12 == LList.Empty) && (k == 0))
                {
                  localObject13 = localPair3;
                  k = 1;
                }
                else
                {
                  if ((!(localObject12 instanceof Pair)) || (j != 0) || (k != 0) || (localObject10 != null)) {
                    break label1138;
                  }
                  Pair localPair4 = (Pair)localObject12;
                  if (localPair4.getCdr() != LList.Empty) {
                    break label1138;
                  }
                  localObject10 = localPair3;
                  localObject13 = localPair4;
                  localObject12 = localPair4.getCdr();
                  k = 1;
                }
              }
            }
          }
        }
      }
      label1138:
      localObject12 = null;
      label1141:
      if (localObject12 != LList.Empty)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("invalid argument list for slot '").append(localObject11).append('\'').append(" args:");
        if (localObject12 == null) {}
        for (String str = "null";; str = localObject12.getClass().getName())
        {
          paramTranslator.error('e', str);
          return null;
        }
      }
      int m;
      Object localObject14;
      if (k != 0)
      {
        if (i != 2048) {
          break label1281;
        }
        m = 1;
        if (localDeclaration == null) {
          break label1287;
        }
        localObject14 = localDeclaration;
      }
      for (;;)
      {
        localVector.addElement(localObject14);
        localVector.addElement(localObject13);
        if (localDeclaration != null) {
          break label1308;
        }
        if (k != 0) {
          break label1371;
        }
        paramTranslator.error('e', "missing field name");
        return null;
        label1281:
        m = 0;
        break;
        label1287:
        if (m != 0) {
          localObject14 = Boolean.TRUE;
        } else {
          localObject14 = Boolean.FALSE;
        }
      }
      label1308:
      if (localObject10 != null)
      {
        Type localType = paramTranslator.exp2Type(localObject10);
        localDeclaration.setType(localType);
      }
      if (i != 0)
      {
        long l3 = i;
        localDeclaration.setFlag(l3);
      }
      if (l2 != 0L) {
        localDeclaration.setFlag(l2);
      }
      localDeclaration.setCanRead(true);
      localDeclaration.setCanWrite(true);
    }
    for (;;)
    {
      label1371:
      paramTranslator.popPositionOf(localObject8);
      break;
      if ((localObject9 instanceof Pair))
      {
        Pair localPair6 = (Pair)localObject9;
        Object localObject20 = localPair6.getCar();
        if ((!(localObject20 instanceof String)) && (!(localObject20 instanceof Symbol)))
        {
          paramTranslator.error('e', "missing method name");
          return null;
        }
        LambdaExp localLambdaExp = new LambdaExp();
        Translator.setLine(paramClassExp.addMethod(localLambdaExp, localObject20), localPair6);
        if (localObject5 == null) {
          localObject4 = localLambdaExp;
        }
        for (;;)
        {
          localObject5 = localLambdaExp;
          break;
          localObject5.nextSibling = localLambdaExp;
        }
      }
      paramTranslator.error('e', "invalid field/method definition");
    }
    label1489:
    if (l1 != 0L) {
      paramClassExp.nameDecl.setFlag(l1);
    }
    return new Object[] { paramClassExp, localObject2, localVector, localObject4, localObject1, localObject3 };
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.object
 * JD-Core Version:    0.7.0.1
 */