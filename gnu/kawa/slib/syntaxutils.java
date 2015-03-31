package gnu.kawa.slib;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.LetExp;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Convert;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.SlotGet;
import gnu.lists.EofClass;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.text.Char;
import kawa.lang.Macro;
import kawa.lang.Quote;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;

public class syntaxutils
  extends ModuleBody
{
  public static final Macro $Prvt$$Ex;
  public static final Macro $Prvt$typecase$Pc;
  public static final syntaxutils $instance;
  static final Keyword Lit0;
  static final PairWithPosition Lit1;
  static final PairWithPosition Lit10;
  static final PairWithPosition Lit11;
  static final PairWithPosition Lit12;
  static final SimpleSymbol Lit13;
  static final SyntaxRules Lit14;
  static final SimpleSymbol Lit15;
  static final SyntaxRules Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final Keyword Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26 = (SimpleSymbol)new SimpleSymbol("lambda").readResolve();
  static final PairWithPosition Lit3;
  static final PairWithPosition Lit4;
  static final PairWithPosition Lit5;
  static final PairWithPosition Lit6;
  static final IntNum Lit7;
  static final IntNum Lit8;
  static final PairWithPosition Lit9;
  public static final ModuleMethod expand;
  
  static
  {
    Lit25 = (SimpleSymbol)new SimpleSymbol("as").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("else").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("let").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("cond").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("begin").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("or").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("eql").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("expand").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("!").readResolve();
    Lit15 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("\f\030\f\007\f\017\r\027\020\b\b", new Object[0], 3);
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = ((SimpleSymbol)new SimpleSymbol("invoke").readResolve());
    arrayOfObject2[1] = Lit19;
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\001\001\003", "\021\030\004\t\013)\021\030\f\b\003\b\025\023", arrayOfObject2, 1);
    Lit16 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 3);
    Object[] arrayOfObject3 = new Object[3];
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("typecase%").readResolve();
    Lit13 = localSimpleSymbol2;
    arrayOfObject3[0] = localSimpleSymbol2;
    arrayOfObject3[1] = Lit18;
    arrayOfObject3[2] = Lit20;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[6];
    Object[] arrayOfObject4 = new Object[1];
    arrayOfObject4[0] = Boolean.TRUE;
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030\f\007<\f\002\r\017\b\b\b\r\027\020\b\b", arrayOfObject4, 3);
    Object[] arrayOfObject5 = new Object[1];
    arrayOfObject5[0] = Lit21;
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern2, "\001\003\003", "\021\030\004\b\r\013", arrayOfObject5, 1);
    Object[] arrayOfObject6 = new Object[1];
    arrayOfObject6[0] = Lit18;
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("\f\030\f\007\\,\f\002\f\017\b\r\027\020\b\b\r\037\030\b\b", arrayOfObject6, 4);
    Object[] arrayOfObject7 = new Object[5];
    arrayOfObject7[0] = Lit22;
    arrayOfObject7[1] = ((SimpleSymbol)new SimpleSymbol("eqv?").readResolve());
    arrayOfObject7[2] = Lit19;
    arrayOfObject7[3] = Lit24;
    arrayOfObject7[4] = Lit13;
    arrayOfSyntaxRule2[1] = new SyntaxRule(localSyntaxPattern3, "\001\001\003\003", "\021\030\004yY\021\030\f\t\003\b\021\030\024\b\013\b\025\023\b\021\030\034\b\021\030$\t\003\b\035\033", arrayOfObject7, 1);
    Object[] arrayOfObject8 = new Object[1];
    arrayOfObject8[0] = Lit20;
    SyntaxPattern localSyntaxPattern4 = new SyntaxPattern("\f\030\f\007\\,\f\002\f\017\b\r\027\020\b\b\r\037\030\b\b", arrayOfObject8, 4);
    Object[] arrayOfObject9 = new Object[1];
    arrayOfObject9[0] = Lit13;
    arrayOfSyntaxRule2[2] = new SyntaxRule(localSyntaxPattern4, "\001\001\003\003", "\021\030\004\t\003)\t\013\b\025\023\b\035\033", arrayOfObject9, 1);
    Object[] arrayOfObject10 = new Object[1];
    arrayOfObject10[0] = Lit20;
    SyntaxPattern localSyntaxPattern5 = new SyntaxPattern("\f\030\f\007l<\f\002\r\017\b\b\b\r\027\020\b\b\r\037\030\b\b", arrayOfObject10, 4);
    Object[] arrayOfObject11 = new Object[6];
    arrayOfObject11[0] = Lit23;
    arrayOfObject11[1] = ((SimpleSymbol)new SimpleSymbol("f").readResolve());
    arrayOfObject11[2] = Lit26;
    arrayOfObject11[3] = Lit21;
    arrayOfObject11[4] = Lit13;
    arrayOfObject11[5] = Boolean.TRUE;
    arrayOfSyntaxRule2[3] = new SyntaxRule(localSyntaxPattern5, "\001\003\003\003", "\021\030\004\b\021\030\f\b\021\030\024\021\b\003\b\021\030\034\b\025\023\b\021\030$\t\003I\r\t\013\b\021\030\f\b\003\b\021\030,\b\021\030$\t\003\b\035\033", arrayOfObject11, 1);
    SyntaxPattern localSyntaxPattern6 = new SyntaxPattern("\f\030\f\007<\f\017\r\027\020\b\b\r\037\030\b\b", new Object[0], 4);
    Object[] arrayOfObject12 = new Object[7];
    arrayOfObject12[0] = Lit22;
    arrayOfObject12[1] = ((SimpleSymbol)new SimpleSymbol("instance?").readResolve());
    arrayOfObject12[2] = Lit23;
    arrayOfObject12[3] = ((SimpleSymbol)new SimpleSymbol("::").readResolve());
    arrayOfObject12[4] = Lit21;
    arrayOfObject12[5] = Lit24;
    arrayOfObject12[6] = Lit13;
    arrayOfSyntaxRule2[4] = new SyntaxRule(localSyntaxPattern6, "\001\001\003\003", "\021\030\004ñ9\021\030\f\t\003\b\013\b\021\030\024Q\b\t\003\021\030\034\t\013\b\003\b\021\030$\b\025\023\b\021\030,\b\021\0304\t\003\b\035\033", arrayOfObject12, 1);
    SyntaxPattern localSyntaxPattern7 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject13 = new Object[6];
    arrayOfObject13[0] = ((SimpleSymbol)new SimpleSymbol("error").readResolve());
    arrayOfObject13[1] = "typecase% failed";
    arrayOfObject13[2] = Lit15;
    arrayOfObject13[3] = ((SimpleSymbol)new SimpleSymbol("getClass").readResolve());
    arrayOfObject13[4] = Lit25;
    arrayOfObject13[5] = ((SimpleSymbol)new SimpleSymbol("<object>").readResolve());
    arrayOfSyntaxRule2[5] = new SyntaxRule(localSyntaxPattern7, "\001", "\021\030\004\021\030\f\t\003\b\021\030\024\021\030\034\b\021\030$\021\030,\b\003", arrayOfObject13, 0);
    Lit14 = new SyntaxRules(arrayOfObject3, arrayOfSyntaxRule2, 4);
    Lit12 = PairWithPosition.make((SimpleSymbol)new SimpleSymbol(":").readResolve(), LList.Empty, "syntaxutils.scm", 634896);
    Lit11 = PairWithPosition.make(Lit25, LList.Empty, "syntaxutils.scm", 626704);
    Lit10 = PairWithPosition.make(Lit19, LList.Empty, "syntaxutils.scm", 552972);
    Lit9 = PairWithPosition.make(Lit23, LList.Empty, "syntaxutils.scm", 479236);
    Lit8 = IntNum.make(1);
    Lit7 = IntNum.make(0);
    Lit6 = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("if").readResolve(), LList.Empty, "syntaxutils.scm", 417799);
    Lit5 = PairWithPosition.make(Lit21, LList.Empty, "syntaxutils.scm", 409627);
    Lit4 = PairWithPosition.make(Lit26, LList.Empty, "syntaxutils.scm", 376839);
    Lit3 = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("set").readResolve(), LList.Empty, "syntaxutils.scm", 368647);
    Lit2 = Keyword.make("lang");
    Lit1 = PairWithPosition.make(Lit21, LList.Empty, "syntaxutils.scm", 278557);
    Lit0 = Keyword.make("env");
    $instance = new syntaxutils();
    $Prvt$typecase$Pc = Macro.make(Lit13, Lit14, $instance);
    $Prvt$$Ex = Macro.make(Lit15, Lit16, $instance);
    expand = new ModuleMethod($instance, 1, Lit17, -4095);
    $instance.run();
  }
  
  public syntaxutils()
  {
    ModuleInfo.register(this);
  }
  
  public static Object expand$V(Object paramObject, Object[] paramArrayOfObject)
  {
    Object localObject1 = Keyword.searchForKeyword(paramArrayOfObject, 0, Lit0);
    if (localObject1 == Special.dfault) {
      localObject1 = misc.interactionEnvironment();
    }
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Lit1;
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = paramObject;
    arrayOfObject2[1] = LList.Empty;
    arrayOfObject1[1] = Quote.consX$V(arrayOfObject2);
    Object localObject2 = Quote.append$V(arrayOfObject1);
    Object[] arrayOfObject3 = new Object[2];
    arrayOfObject3[0] = Lit0;
    arrayOfObject3[1] = localObject1;
    return unrewrite(rewriteForm$V(localObject2, arrayOfObject3));
  }
  
  /* Error */
  static Expression rewriteForm$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: getstatic 245	gnu/kawa/slib/syntaxutils:Lit2	Lgnu/expr/Keyword;
    //   5: invokestatic 288	gnu/expr/Keyword:searchForKeyword	([Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;
    //   8: astore_2
    //   9: aload_2
    //   10: getstatic 294	gnu/expr/Special:dfault	Lgnu/expr/Special;
    //   13: if_acmpne +7 -> 20
    //   16: invokestatic 325	gnu/expr/Language:getDefaultLanguage	()Lgnu/expr/Language;
    //   19: astore_2
    //   20: aload_1
    //   21: iconst_0
    //   22: getstatic 252	gnu/kawa/slib/syntaxutils:Lit0	Lgnu/expr/Keyword;
    //   25: invokestatic 288	gnu/expr/Keyword:searchForKeyword	([Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;
    //   28: astore_3
    //   29: aload_3
    //   30: getstatic 294	gnu/expr/Special:dfault	Lgnu/expr/Special;
    //   33: if_acmpne +7 -> 40
    //   36: invokestatic 300	kawa/lib/misc:interactionEnvironment	()Lgnu/mapping/Environment;
    //   39: astore_3
    //   40: aload_3
    //   41: checkcast 327	gnu/mapping/Environment
    //   44: astore 5
    //   46: aload_2
    //   47: checkcast 321	gnu/expr/Language
    //   50: astore 7
    //   52: aload 5
    //   54: aload 7
    //   56: invokestatic 333	gnu/expr/NameLookup:getInstance	(Lgnu/mapping/Environment;Lgnu/expr/Language;)Lgnu/expr/NameLookup;
    //   59: astore 8
    //   61: new 335	gnu/text/SourceMessages
    //   64: dup
    //   65: invokespecial 336	gnu/text/SourceMessages:<init>	()V
    //   68: astore 9
    //   70: aload_2
    //   71: checkcast 321	gnu/expr/Language
    //   74: astore 11
    //   76: new 338	kawa/lang/Translator
    //   79: dup
    //   80: aload 11
    //   82: aload 9
    //   84: aload 8
    //   86: invokespecial 341	kawa/lang/Translator:<init>	(Lgnu/expr/Language;Lgnu/text/SourceMessages;Lgnu/expr/NameLookup;)V
    //   89: astore 12
    //   91: aload 12
    //   93: aconst_null
    //   94: invokevirtual 345	kawa/lang/Translator:pushNewModule	(Ljava/lang/String;)Lgnu/expr/ModuleExp;
    //   97: pop
    //   98: aload 12
    //   100: invokestatic 351	gnu/expr/Compilation:setSaveCurrent	(Lgnu/expr/Compilation;)Lgnu/expr/Compilation;
    //   103: astore 14
    //   105: aload 12
    //   107: aload_0
    //   108: invokevirtual 355	kawa/lang/Translator:rewrite	(Ljava/lang/Object;)Lgnu/expr/Expression;
    //   111: astore 16
    //   113: aload 14
    //   115: invokestatic 359	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   118: aload 16
    //   120: areturn
    //   121: astore 15
    //   123: aload 14
    //   125: invokestatic 359	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   128: aload 15
    //   130: athrow
    //   131: astore 4
    //   133: new 361	gnu/mapping/WrongType
    //   136: dup
    //   137: aload 4
    //   139: ldc_w 363
    //   142: iconst_1
    //   143: aload_3
    //   144: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   147: athrow
    //   148: astore 6
    //   150: new 361	gnu/mapping/WrongType
    //   153: dup
    //   154: aload 6
    //   156: ldc_w 363
    //   159: iconst_2
    //   160: aload_2
    //   161: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   164: athrow
    //   165: astore 10
    //   167: new 361	gnu/mapping/WrongType
    //   170: dup
    //   171: aload 10
    //   173: ldc_w 368
    //   176: iconst_1
    //   177: aload_2
    //   178: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramObject	Object
    //   0	182	1	paramArrayOfObject	Object[]
    //   8	170	2	localObject1	Object
    //   28	116	3	localObject2	Object
    //   131	7	4	localClassCastException1	ClassCastException
    //   44	9	5	localEnvironment	gnu.mapping.Environment
    //   148	7	6	localClassCastException2	ClassCastException
    //   50	5	7	localLanguage1	gnu.expr.Language
    //   59	26	8	localNameLookup	gnu.expr.NameLookup
    //   68	15	9	localSourceMessages	gnu.text.SourceMessages
    //   165	7	10	localClassCastException3	ClassCastException
    //   74	7	11	localLanguage2	gnu.expr.Language
    //   89	17	12	localTranslator	kawa.lang.Translator
    //   103	21	14	localCompilation	gnu.expr.Compilation
    //   121	8	15	localObject3	Object
    //   111	8	16	localExpression	Expression
    // Exception table:
    //   from	to	target	type
    //   105	113	121	finally
    //   40	46	131	java/lang/ClassCastException
    //   46	52	148	java/lang/ClassCastException
    //   70	76	165	java/lang/ClassCastException
  }
  
  /* Error */
  static Object unrewrite(Expression paramExpression)
  {
    // Byte code:
    //   0: new 370	gnu/kawa/slib/syntaxutils$frame
    //   3: dup
    //   4: invokespecial 371	gnu/kawa/slib/syntaxutils$frame:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: instanceof 373
    //   12: ifeq +17 -> 29
    //   15: aload_0
    //   16: checkcast 373	gnu/expr/LetExp
    //   19: astore 31
    //   21: aload 31
    //   23: invokestatic 377	gnu/kawa/slib/syntaxutils:unrewriteLet	(Lgnu/expr/LetExp;)Ljava/lang/Object;
    //   26: astore_0
    //   27: aload_0
    //   28: areturn
    //   29: aload_0
    //   30: instanceof 379
    //   33: ifeq +15 -> 48
    //   36: aload_0
    //   37: checkcast 379	gnu/expr/QuoteExp
    //   40: astore 29
    //   42: aload 29
    //   44: invokestatic 383	gnu/kawa/slib/syntaxutils:unrewriteQuote	(Lgnu/expr/QuoteExp;)Ljava/lang/Object;
    //   47: areturn
    //   48: aload_0
    //   49: instanceof 385
    //   52: ifeq +86 -> 138
    //   55: aload_0
    //   56: checkcast 385	gnu/expr/SetExp
    //   59: astore 24
    //   61: iconst_2
    //   62: anewarray 96	java/lang/Object
    //   65: astore 25
    //   67: aload 25
    //   69: iconst_0
    //   70: getstatic 236	gnu/kawa/slib/syntaxutils:Lit3	Lgnu/lists/PairWithPosition;
    //   73: aastore
    //   74: iconst_2
    //   75: anewarray 96	java/lang/Object
    //   78: astore 26
    //   80: aload 26
    //   82: iconst_0
    //   83: aload 24
    //   85: invokevirtual 388	gnu/expr/SetExp:getSymbol	()Ljava/lang/Object;
    //   88: aastore
    //   89: iconst_2
    //   90: anewarray 96	java/lang/Object
    //   93: astore 27
    //   95: aload 27
    //   97: iconst_0
    //   98: aload 24
    //   100: invokevirtual 392	gnu/expr/SetExp:getNewValue	()Lgnu/expr/Expression;
    //   103: invokestatic 317	gnu/kawa/slib/syntaxutils:unrewrite	(Lgnu/expr/Expression;)Ljava/lang/Object;
    //   106: aastore
    //   107: aload 27
    //   109: iconst_1
    //   110: getstatic 191	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   113: aastore
    //   114: aload 26
    //   116: iconst_1
    //   117: aload 27
    //   119: invokestatic 306	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   122: aastore
    //   123: aload 25
    //   125: iconst_1
    //   126: aload 26
    //   128: invokestatic 306	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   131: aastore
    //   132: aload 25
    //   134: invokestatic 309	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   137: areturn
    //   138: aload_0
    //   139: instanceof 394
    //   142: ifeq +133 -> 275
    //   145: aload_0
    //   146: checkcast 394	gnu/expr/LambdaExp
    //   149: astore 18
    //   151: iconst_2
    //   152: anewarray 96	java/lang/Object
    //   155: astore 19
    //   157: aload 19
    //   159: iconst_0
    //   160: getstatic 231	gnu/kawa/slib/syntaxutils:Lit4	Lgnu/lists/PairWithPosition;
    //   163: aastore
    //   164: iconst_2
    //   165: anewarray 96	java/lang/Object
    //   168: astore 20
    //   170: aload_1
    //   171: getstatic 191	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   174: putfield 397	gnu/kawa/slib/syntaxutils$frame:pack	Lgnu/lists/LList;
    //   177: aload 18
    //   179: invokevirtual 401	gnu/expr/LambdaExp:firstDecl	()Lgnu/expr/Declaration;
    //   182: astore 21
    //   184: aload 21
    //   186: ifnull +29 -> 215
    //   189: aload_1
    //   190: aload 21
    //   192: invokevirtual 404	gnu/expr/Declaration:getSymbol	()Ljava/lang/Object;
    //   195: aload_1
    //   196: getfield 397	gnu/kawa/slib/syntaxutils$frame:pack	Lgnu/lists/LList;
    //   199: invokestatic 410	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   202: putfield 397	gnu/kawa/slib/syntaxutils$frame:pack	Lgnu/lists/LList;
    //   205: aload 21
    //   207: invokevirtual 413	gnu/expr/Declaration:nextDecl	()Lgnu/expr/Declaration;
    //   210: astore 21
    //   212: goto -28 -> 184
    //   215: aload 20
    //   217: iconst_0
    //   218: aload_1
    //   219: getfield 397	gnu/kawa/slib/syntaxutils$frame:pack	Lgnu/lists/LList;
    //   222: invokestatic 417	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   225: aastore
    //   226: iconst_2
    //   227: anewarray 96	java/lang/Object
    //   230: astore 22
    //   232: aload 22
    //   234: iconst_0
    //   235: aload 18
    //   237: getfield 421	gnu/expr/LambdaExp:body	Lgnu/expr/Expression;
    //   240: invokestatic 317	gnu/kawa/slib/syntaxutils:unrewrite	(Lgnu/expr/Expression;)Ljava/lang/Object;
    //   243: aastore
    //   244: aload 22
    //   246: iconst_1
    //   247: getstatic 191	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   250: aastore
    //   251: aload 20
    //   253: iconst_1
    //   254: aload 22
    //   256: invokestatic 306	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   259: aastore
    //   260: aload 19
    //   262: iconst_1
    //   263: aload 20
    //   265: invokestatic 306	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   268: aastore
    //   269: aload 19
    //   271: invokestatic 309	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   274: areturn
    //   275: aload_0
    //   276: instanceof 423
    //   279: ifeq +15 -> 294
    //   282: aload_0
    //   283: checkcast 423	gnu/expr/ReferenceExp
    //   286: astore 16
    //   288: aload 16
    //   290: invokevirtual 424	gnu/expr/ReferenceExp:getSymbol	()Ljava/lang/Object;
    //   293: areturn
    //   294: aload_0
    //   295: instanceof 426
    //   298: ifeq +15 -> 313
    //   301: aload_0
    //   302: checkcast 426	gnu/expr/ApplyExp
    //   305: astore 14
    //   307: aload 14
    //   309: invokestatic 430	gnu/kawa/slib/syntaxutils:unrewriteApply	(Lgnu/expr/ApplyExp;)Ljava/lang/Object;
    //   312: areturn
    //   313: aload_0
    //   314: instanceof 432
    //   317: ifeq +40 -> 357
    //   320: aload_0
    //   321: checkcast 432	gnu/expr/BeginExp
    //   324: astore 11
    //   326: iconst_2
    //   327: anewarray 96	java/lang/Object
    //   330: astore 12
    //   332: aload 12
    //   334: iconst_0
    //   335: getstatic 228	gnu/kawa/slib/syntaxutils:Lit5	Lgnu/lists/PairWithPosition;
    //   338: aastore
    //   339: aload 12
    //   341: iconst_1
    //   342: aload 11
    //   344: invokevirtual 436	gnu/expr/BeginExp:getExpressions	()[Lgnu/expr/Expression;
    //   347: invokestatic 440	gnu/kawa/slib/syntaxutils:unrewrite$St	([Lgnu/expr/Expression;)Ljava/lang/Object;
    //   350: aastore
    //   351: aload 12
    //   353: invokestatic 309	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   356: areturn
    //   357: aload_0
    //   358: instanceof 442
    //   361: ifeq -334 -> 27
    //   364: aload_0
    //   365: checkcast 442	gnu/expr/IfExp
    //   368: astore_3
    //   369: iconst_2
    //   370: anewarray 96	java/lang/Object
    //   373: astore 4
    //   375: aload 4
    //   377: iconst_0
    //   378: getstatic 225	gnu/kawa/slib/syntaxutils:Lit6	Lgnu/lists/PairWithPosition;
    //   381: aastore
    //   382: iconst_2
    //   383: anewarray 96	java/lang/Object
    //   386: astore 5
    //   388: aload 5
    //   390: iconst_0
    //   391: aload_3
    //   392: invokevirtual 445	gnu/expr/IfExp:getTest	()Lgnu/expr/Expression;
    //   395: invokestatic 317	gnu/kawa/slib/syntaxutils:unrewrite	(Lgnu/expr/Expression;)Ljava/lang/Object;
    //   398: aastore
    //   399: iconst_2
    //   400: anewarray 96	java/lang/Object
    //   403: astore 6
    //   405: aload 6
    //   407: iconst_0
    //   408: aload_3
    //   409: invokevirtual 448	gnu/expr/IfExp:getThenClause	()Lgnu/expr/Expression;
    //   412: invokestatic 317	gnu/kawa/slib/syntaxutils:unrewrite	(Lgnu/expr/Expression;)Ljava/lang/Object;
    //   415: aastore
    //   416: iconst_2
    //   417: anewarray 96	java/lang/Object
    //   420: astore 7
    //   422: aload_3
    //   423: invokevirtual 451	gnu/expr/IfExp:getElseClause	()Lgnu/expr/Expression;
    //   426: astore 8
    //   428: aload 8
    //   430: ifnonnull +54 -> 484
    //   433: getstatic 191	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   436: astore 9
    //   438: aload 7
    //   440: iconst_0
    //   441: aload 9
    //   443: aastore
    //   444: aload 7
    //   446: iconst_1
    //   447: getstatic 191	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   450: aastore
    //   451: aload 6
    //   453: iconst_1
    //   454: aload 7
    //   456: invokestatic 309	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   459: aastore
    //   460: aload 5
    //   462: iconst_1
    //   463: aload 6
    //   465: invokestatic 306	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   468: aastore
    //   469: aload 4
    //   471: iconst_1
    //   472: aload 5
    //   474: invokestatic 306	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   477: aastore
    //   478: aload 4
    //   480: invokestatic 309	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   483: areturn
    //   484: aload 8
    //   486: invokestatic 317	gnu/kawa/slib/syntaxutils:unrewrite	(Lgnu/expr/Expression;)Ljava/lang/Object;
    //   489: invokestatic 455	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   492: astore 9
    //   494: goto -56 -> 438
    //   497: astore 30
    //   499: new 361	gnu/mapping/WrongType
    //   502: dup
    //   503: aload 30
    //   505: ldc_w 457
    //   508: bipush 254
    //   510: aload_0
    //   511: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   514: athrow
    //   515: astore 28
    //   517: new 361	gnu/mapping/WrongType
    //   520: dup
    //   521: aload 28
    //   523: ldc_w 457
    //   526: bipush 254
    //   528: aload_0
    //   529: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   532: athrow
    //   533: astore 23
    //   535: new 361	gnu/mapping/WrongType
    //   538: dup
    //   539: aload 23
    //   541: ldc_w 457
    //   544: bipush 254
    //   546: aload_0
    //   547: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   550: athrow
    //   551: astore 17
    //   553: new 361	gnu/mapping/WrongType
    //   556: dup
    //   557: aload 17
    //   559: ldc_w 457
    //   562: bipush 254
    //   564: aload_0
    //   565: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   568: athrow
    //   569: astore 15
    //   571: new 361	gnu/mapping/WrongType
    //   574: dup
    //   575: aload 15
    //   577: ldc_w 457
    //   580: bipush 254
    //   582: aload_0
    //   583: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   586: athrow
    //   587: astore 13
    //   589: new 361	gnu/mapping/WrongType
    //   592: dup
    //   593: aload 13
    //   595: ldc_w 457
    //   598: bipush 254
    //   600: aload_0
    //   601: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   604: athrow
    //   605: astore 10
    //   607: new 361	gnu/mapping/WrongType
    //   610: dup
    //   611: aload 10
    //   613: ldc_w 457
    //   616: bipush 254
    //   618: aload_0
    //   619: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   622: athrow
    //   623: astore_2
    //   624: new 361	gnu/mapping/WrongType
    //   627: dup
    //   628: aload_2
    //   629: ldc_w 457
    //   632: bipush 254
    //   634: aload_0
    //   635: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   638: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	639	0	paramExpression	Expression
    //   7	212	1	localframe	frame
    //   623	6	2	localClassCastException1	ClassCastException
    //   368	55	3	localIfExp	gnu.expr.IfExp
    //   373	106	4	arrayOfObject1	Object[]
    //   386	87	5	arrayOfObject2	Object[]
    //   403	61	6	arrayOfObject3	Object[]
    //   420	35	7	arrayOfObject4	Object[]
    //   426	59	8	localExpression	Expression
    //   436	57	9	localObject	Object
    //   605	7	10	localClassCastException2	ClassCastException
    //   324	19	11	localBeginExp	gnu.expr.BeginExp
    //   330	22	12	arrayOfObject5	Object[]
    //   587	7	13	localClassCastException3	ClassCastException
    //   305	3	14	localApplyExp	ApplyExp
    //   569	7	15	localClassCastException4	ClassCastException
    //   286	3	16	localReferenceExp	ReferenceExp
    //   551	7	17	localClassCastException5	ClassCastException
    //   149	87	18	localLambdaExp	gnu.expr.LambdaExp
    //   155	115	19	arrayOfObject6	Object[]
    //   168	96	20	arrayOfObject7	Object[]
    //   182	29	21	localDeclaration	Declaration
    //   230	25	22	arrayOfObject8	Object[]
    //   533	7	23	localClassCastException6	ClassCastException
    //   59	40	24	localSetExp	gnu.expr.SetExp
    //   65	68	25	arrayOfObject9	Object[]
    //   78	49	26	arrayOfObject10	Object[]
    //   93	25	27	arrayOfObject11	Object[]
    //   515	7	28	localClassCastException7	ClassCastException
    //   40	3	29	localQuoteExp	QuoteExp
    //   497	7	30	localClassCastException8	ClassCastException
    //   19	3	31	localLetExp	LetExp
    // Exception table:
    //   from	to	target	type
    //   15	21	497	java/lang/ClassCastException
    //   36	42	515	java/lang/ClassCastException
    //   55	61	533	java/lang/ClassCastException
    //   145	151	551	java/lang/ClassCastException
    //   282	288	569	java/lang/ClassCastException
    //   301	307	587	java/lang/ClassCastException
    //   320	326	605	java/lang/ClassCastException
    //   364	369	623	java/lang/ClassCastException
  }
  
  static Object unrewrite$St(Expression[] paramArrayOfExpression)
  {
    frame0 localframe0 = new frame0();
    localframe0.pack = LList.Empty;
    Integer localInteger = Integer.valueOf(paramArrayOfExpression.length);
    for (Object localObject = Lit7; Scheme.numEqu.apply2(localObject, localInteger) == Boolean.FALSE; localObject = AddOp.$Pl.apply2(localObject, Lit8)) {
      localframe0.pack = lists.cons(unrewrite(paramArrayOfExpression[((java.lang.Number)localObject).intValue()]), localframe0.pack);
    }
    return lists.reverse$Ex(localframe0.pack);
  }
  
  static Object unrewriteApply(ApplyExp paramApplyExp)
  {
    Expression localExpression = paramApplyExp.getFunction();
    Object localObject1 = unrewrite$St(paramApplyExp.getArgs());
    if ((localExpression instanceof ReferenceExp)) {}
    try
    {
      ReferenceExp localReferenceExp = (ReferenceExp)localExpression;
      Declaration localDeclaration1 = localReferenceExp.getBinding();
      Declaration localDeclaration2 = Declaration.getDeclarationFromStatic("kawa.standard.Scheme", "applyToArgs");
      Object localObject2 = paramApplyExp.getFunctionValue();
      int i;
      label56:
      int j;
      int k;
      label77:
      int m;
      if (localDeclaration1 == null)
      {
        i = 1;
        j = 0x1 & i + 1;
        if (j == 0) {
          break label186;
        }
        if (localDeclaration2 != null) {
          break label131;
        }
        k = 1;
        m = 0x1 & k + 1;
        if (m == 0) {
          break label137;
        }
        if (SlotGet.getSlotValue(false, localDeclaration1, "field", "field", "getField", "isField", Scheme.instance) != localDeclaration2.field) {
          break label142;
        }
      }
      label131:
      label137:
      while (m != 0)
      {
        return localObject1;
        localDeclaration1 = null;
        break;
        i = 0;
        break label56;
        k = 0;
        break label77;
      }
      label142:
      Object localObject3;
      if ((localObject2 instanceof Convert))
      {
        Object[] arrayOfObject3 = new Object[2];
        arrayOfObject3[0] = Lit11;
        arrayOfObject3[1] = localObject1;
        localObject3 = Quote.append$V(arrayOfObject3);
      }
      for (;;)
      {
        if (localObject3 == Boolean.FALSE) {
          break label237;
        }
        return localObject3;
        label186:
        if (j == 0) {
          break;
        }
        return localObject1;
        if ((localObject2 instanceof GetNamedPart))
        {
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = Lit12;
          arrayOfObject2[1] = localObject1;
          localObject3 = Quote.append$V(arrayOfObject2);
        }
        else
        {
          localObject3 = Boolean.FALSE;
        }
      }
      label237:
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = unrewrite(localExpression);
      arrayOfObject1[1] = localObject1;
      return Quote.consX$V(arrayOfObject1);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "fun", -2, localExpression);
    }
  }
  
  static Object unrewriteLet(LetExp paramLetExp)
  {
    frame1 localframe1 = new frame1();
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Lit9;
    Object[] arrayOfObject2 = new Object[2];
    localframe1.pack = LList.Empty;
    Declaration localDeclaration = paramLetExp.firstDecl();
    for (Object localObject = Lit7; localDeclaration != null; localObject = AddOp.$Pl.apply2(localObject, Lit8))
    {
      localframe1.pack = lists.cons(LList.list2(localDeclaration.getSymbol(), unrewrite(paramLetExp.inits[((java.lang.Number)localObject).intValue()])), localframe1.pack);
      localDeclaration = localDeclaration.nextDecl();
    }
    arrayOfObject2[0] = lists.reverse$Ex(localframe1.pack);
    Object[] arrayOfObject3 = new Object[2];
    arrayOfObject3[0] = unrewrite(paramLetExp.body);
    arrayOfObject3[1] = LList.Empty;
    arrayOfObject2[1] = Quote.consX$V(arrayOfObject3);
    arrayOfObject1[1] = Quote.consX$V(arrayOfObject2);
    return Quote.append$V(arrayOfObject1);
  }
  
  static Object unrewriteQuote(QuoteExp paramQuoteExp)
  {
    localObject = paramQuoteExp.getValue();
    if (Numeric.asNumericOrNull(localObject) != null) {}
    label63:
    do
    {
      try
      {
        Numeric localNumeric = LangObjType.coerceNumeric(localObject);
        localObject = localNumeric;
        return localObject;
      }
      catch (ClassCastException localClassCastException7)
      {
        throw new WrongType(localClassCastException7, "val", -2, localObject);
      }
      if ((localObject instanceof Boolean)) {}
      try
      {
        Boolean localBoolean1 = Boolean.FALSE;
        int i;
        if (localObject != localBoolean1)
        {
          i = 1;
          if (i == 0) {
            break label63;
          }
        }
        for (Boolean localBoolean2 = Boolean.TRUE;; localBoolean2 = Boolean.FALSE)
        {
          return localBoolean2;
          i = 0;
          break;
        }
        if (!(localObject instanceof Char)) {}
      }
      catch (ClassCastException localClassCastException6)
      {
        Char localChar;
        throw new WrongType(localClassCastException6, "val", -2, localObject);
      }
      try
      {
        localChar = (Char)localObject;
        return localChar;
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "val", -2, localObject);
      }
      if ((localObject instanceof Keyword)) {}
      try
      {
        Keyword localKeyword = (Keyword)localObject;
        return localKeyword;
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "val", -2, localObject);
      }
      if ((localObject instanceof CharSequence)) {}
      try
      {
        CharSequence localCharSequence = (CharSequence)localObject;
        return localCharSequence;
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "val", -2, localObject);
      }
    } while ((localObject == Special.undefined) || (localObject == EofClass.eofValue));
    if ((localObject instanceof Type)) {}
    for (;;)
    {
      try
      {
        Type localType = (Type)localObject;
        str = localType.getName();
        return misc.string$To$Symbol(Format.formatToString(0, new Object[] { "<~a>", str }));
      }
      catch (ClassCastException localClassCastException2)
      {
        String str;
        throw new WrongType(localClassCastException2, "val", -2, localObject);
      }
      if ((localObject instanceof Class)) {}
      try
      {
        Class localClass = (Class)localObject;
        str = localClass.getName();
      }
      catch (ClassCastException localClassCastException1)
      {
        Object[] arrayOfObject1;
        Object[] arrayOfObject2;
        throw new WrongType(localClassCastException1, "val", -2, localObject);
      }
    }
    arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Lit10;
    arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = localObject;
    arrayOfObject2[1] = LList.Empty;
    arrayOfObject1[1] = Quote.consX$V(arrayOfObject2);
    return Quote.append$V(arrayOfObject1);
  }
  
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    if (paramModuleMethod.selector == 1)
    {
      Object localObject = paramArrayOfObject[0];
      int i = -1 + paramArrayOfObject.length;
      Object[] arrayOfObject = new Object[i];
      for (;;)
      {
        i--;
        if (i < 0) {
          return expand$V(localObject, arrayOfObject);
        }
        arrayOfObject[i] = paramArrayOfObject[(i + 1)];
      }
    }
    return super.applyN(paramModuleMethod, paramArrayOfObject);
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 1)
    {
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    }
    return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
  }
  
  public final void run(CallContext paramCallContext) {}
  
  public class frame
    extends ModuleBody
  {
    LList pack;
  }
  
  public class frame0
    extends ModuleBody
  {
    LList pack;
  }
  
  public class frame1
    extends ModuleBody
  {
    LList pack;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.syntaxutils
 * JD-Core Version:    0.7.0.1
 */