package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import kawa.lang.PatternScope;
import kawa.lang.Quote;
import kawa.lang.SyntaxTemplate;
import kawa.lang.Translator;

public class syntax
  extends Quote
{
  static final Method makeTemplateScopeMethod = typeTemplateScope.getDeclaredMethod("make", 0);
  public static final syntax quasiSyntax;
  public static final syntax syntax = new syntax("syntax", false);
  static final ClassType typeTemplateScope;
  
  static
  {
    quasiSyntax = new syntax("quasisyntax", true);
    typeTemplateScope = ClassType.make("kawa.lang.TemplateScope");
  }
  
  public syntax(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  static Expression makeSyntax(Object paramObject, Translator paramTranslator)
  {
    SyntaxTemplate localSyntaxTemplate = new SyntaxTemplate(paramObject, null, paramTranslator);
    Object localObject = QuoteExp.nullExp;
    PatternScope localPatternScope = paramTranslator.patternScope;
    if ((localPatternScope != null) && (localPatternScope.matchArray != null)) {
      localObject = new ReferenceExp(localPatternScope.matchArray);
    }
    Expression[] arrayOfExpression = new Expression[3];
    arrayOfExpression[0] = new QuoteExp(localSyntaxTemplate);
    arrayOfExpression[1] = localObject;
    arrayOfExpression[2] = new ReferenceExp(paramTranslator.templateScopeDecl);
    return new ApplyExp(ClassType.make("kawa.lang.SyntaxTemplate").getDeclaredMethod("execute", 2), arrayOfExpression);
  }
  
  protected boolean expandColonForms()
  {
    return false;
  }
  
  protected Expression leaf(Object paramObject, Translator paramTranslator)
  {
    return makeSyntax(paramObject, paramTranslator);
  }
  
  /* Error */
  public Expression rewriteForm(gnu.lists.Pair paramPair, Translator paramTranslator)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 102	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   4: instanceof 98
    //   7: ifeq +24 -> 31
    //   10: aload_1
    //   11: invokevirtual 102	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   14: checkcast 98	gnu/lists/Pair
    //   17: checkcast 98	gnu/lists/Pair
    //   20: astore_3
    //   21: aload_3
    //   22: invokevirtual 102	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   25: getstatic 108	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   28: if_acmpeq +10 -> 38
    //   31: aload_2
    //   32: ldc 110
    //   34: invokevirtual 114	kawa/lang/Translator:syntaxError	(Ljava/lang/String;)Lgnu/expr/Expression;
    //   37: areturn
    //   38: aload_2
    //   39: getfield 80	kawa/lang/Translator:templateScopeDecl	Lgnu/expr/Declaration;
    //   42: astore 4
    //   44: aload 4
    //   46: ifnonnull +49 -> 95
    //   49: aload_2
    //   50: invokevirtual 117	kawa/lang/Translator:letStart	()V
    //   53: new 82	gnu/expr/ApplyExp
    //   56: dup
    //   57: getstatic 41	kawa/standard/syntax:makeTemplateScopeMethod	Lgnu/bytecode/Method;
    //   60: getstatic 121	gnu/expr/Expression:noExpressions	[Lgnu/expr/Expression;
    //   63: invokespecial 89	gnu/expr/ApplyExp:<init>	(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V
    //   66: astore 10
    //   68: aload_2
    //   69: aconst_null
    //   70: getstatic 34	kawa/standard/syntax:typeTemplateScope	Lgnu/bytecode/ClassType;
    //   73: aload 10
    //   75: invokevirtual 125	kawa/lang/Translator:letVariable	(Ljava/lang/Object;Lgnu/bytecode/Type;Lgnu/expr/Expression;)Lgnu/expr/Declaration;
    //   78: astore 11
    //   80: aload 11
    //   82: invokevirtual 130	gnu/expr/Declaration:setCanRead	()V
    //   85: aload_2
    //   86: aload 11
    //   88: putfield 80	kawa/lang/Translator:templateScopeDecl	Lgnu/expr/Declaration;
    //   91: aload_2
    //   92: invokevirtual 133	kawa/lang/Translator:letEnter	()V
    //   95: aload_3
    //   96: invokevirtual 136	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   99: astore 6
    //   101: aload_0
    //   102: getfield 140	kawa/standard/syntax:isQuasi	Z
    //   105: ifeq +48 -> 153
    //   108: iconst_1
    //   109: istore 7
    //   111: aload_0
    //   112: aload_0
    //   113: aload 6
    //   115: iload 7
    //   117: aload_2
    //   118: invokevirtual 144	kawa/standard/syntax:expand	(Ljava/lang/Object;ILkawa/lang/Translator;)Ljava/lang/Object;
    //   121: aload_2
    //   122: invokevirtual 147	kawa/standard/syntax:coerceExpression	(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    //   125: astore 8
    //   127: aload 4
    //   129: ifnonnull +15 -> 144
    //   132: aload_2
    //   133: aload 8
    //   135: invokevirtual 151	kawa/lang/Translator:letDone	(Lgnu/expr/Expression;)Lgnu/expr/LetExp;
    //   138: astore 9
    //   140: aload 9
    //   142: astore 8
    //   144: aload_2
    //   145: aload 4
    //   147: putfield 80	kawa/lang/Translator:templateScopeDecl	Lgnu/expr/Declaration;
    //   150: aload 8
    //   152: areturn
    //   153: iconst_m1
    //   154: istore 7
    //   156: goto -45 -> 111
    //   159: astore 5
    //   161: aload_2
    //   162: aload 4
    //   164: putfield 80	kawa/lang/Translator:templateScopeDecl	Lgnu/expr/Declaration;
    //   167: aload 5
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	syntax
    //   0	170	1	paramPair	gnu.lists.Pair
    //   0	170	2	paramTranslator	Translator
    //   20	76	3	localPair	gnu.lists.Pair
    //   42	121	4	localDeclaration1	gnu.expr.Declaration
    //   159	9	5	localObject1	Object
    //   99	15	6	localObject2	Object
    //   109	46	7	i	int
    //   125	26	8	localObject3	Object
    //   138	3	9	localLetExp	gnu.expr.LetExp
    //   66	8	10	localApplyExp	ApplyExp
    //   78	9	11	localDeclaration2	gnu.expr.Declaration
    // Exception table:
    //   from	to	target	type
    //   95	108	159	finally
    //   111	127	159	finally
    //   132	140	159	finally
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.syntax
 * JD-Core Version:    0.7.0.1
 */