package kawa.standard;

import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.text.Options;
import java.util.Stack;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class with_compile_options
  extends Syntax
{
  public static final with_compile_options with_compile_options = new with_compile_options();
  
  static
  {
    with_compile_options.setName("with-compile-options");
  }
  
  /* Error */
  public static Object getOptions(Object paramObject, Stack paramStack, Syntax paramSyntax, Translator paramTranslator)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_3
    //   4: getfield 28	kawa/lang/Translator:currentOptions	Lgnu/text/Options;
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_0
    //   13: instanceof 30
    //   16: ifeq +20 -> 36
    //   19: aload_0
    //   20: checkcast 30	kawa/lang/SyntaxForm
    //   23: astore 6
    //   25: aload 6
    //   27: invokeinterface 34 1 0
    //   32: astore_0
    //   33: goto -21 -> 12
    //   36: aload_0
    //   37: instanceof 36
    //   40: ifne +43 -> 83
    //   43: iload 4
    //   45: ifne +31 -> 76
    //   48: aload_3
    //   49: bipush 101
    //   51: new 38	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   58: ldc 41
    //   60: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_2
    //   64: invokevirtual 49	kawa/lang/Syntax:getName	()Ljava/lang/String;
    //   67: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokevirtual 56	kawa/lang/Translator:error	(CLjava/lang/String;)V
    //   76: aload_0
    //   77: aload 6
    //   79: invokestatic 60	kawa/lang/Translator:wrapSyntax	(Ljava/lang/Object;Lkawa/lang/SyntaxForm;)Ljava/lang/Object;
    //   82: areturn
    //   83: aload_0
    //   84: checkcast 36	gnu/lists/Pair
    //   87: astore 7
    //   89: aload 7
    //   91: invokevirtual 63	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   94: invokestatic 67	kawa/lang/Translator:stripSyntax	(Ljava/lang/Object;)Ljava/lang/Object;
    //   97: astore 8
    //   99: aload 8
    //   101: instanceof 69
    //   104: ifeq -61 -> 43
    //   107: aload 8
    //   109: checkcast 69	gnu/expr/Keyword
    //   112: invokevirtual 70	gnu/expr/Keyword:getName	()Ljava/lang/String;
    //   115: astore 9
    //   117: iconst_1
    //   118: istore 4
    //   120: aload_3
    //   121: aload 7
    //   123: invokevirtual 73	kawa/lang/Translator:pushPositionOf	(Ljava/lang/Object;)Ljava/lang/Object;
    //   126: astore 10
    //   128: aload 7
    //   130: invokevirtual 76	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   133: astore 12
    //   135: aload 12
    //   137: instanceof 30
    //   140: ifeq +22 -> 162
    //   143: aload 12
    //   145: checkcast 30	kawa/lang/SyntaxForm
    //   148: astore 6
    //   150: aload 6
    //   152: invokeinterface 34 1 0
    //   157: astore 12
    //   159: goto -24 -> 135
    //   162: aload 12
    //   164: instanceof 36
    //   167: ifne +48 -> 215
    //   170: aload_3
    //   171: bipush 101
    //   173: new 38	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   180: ldc 78
    //   182: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload 9
    //   187: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 80
    //   192: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokevirtual 56	kawa/lang/Translator:error	(CLjava/lang/String;)V
    //   201: getstatic 86	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   204: astore 19
    //   206: aload_3
    //   207: aload 10
    //   209: invokevirtual 90	kawa/lang/Translator:popPositionOf	(Ljava/lang/Object;)V
    //   212: aload 19
    //   214: areturn
    //   215: aload 12
    //   217: checkcast 36	gnu/lists/Pair
    //   220: astore 13
    //   222: aload 13
    //   224: invokevirtual 63	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   227: invokestatic 67	kawa/lang/Translator:stripSyntax	(Ljava/lang/Object;)Ljava/lang/Object;
    //   230: astore 14
    //   232: aload 13
    //   234: invokevirtual 76	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   237: astore_0
    //   238: aload 5
    //   240: aload 9
    //   242: invokevirtual 96	gnu/text/Options:getLocal	(Ljava/lang/String;)Ljava/lang/Object;
    //   245: astore 15
    //   247: aload 5
    //   249: aload 9
    //   251: invokevirtual 100	gnu/text/Options:getInfo	(Ljava/lang/String;)Lgnu/text/Options$OptionInfo;
    //   254: ifnonnull +38 -> 292
    //   257: aload_3
    //   258: bipush 119
    //   260: new 38	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   267: ldc 102
    //   269: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload 9
    //   274: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokevirtual 56	kawa/lang/Translator:error	(CLjava/lang/String;)V
    //   283: aload_3
    //   284: aload 10
    //   286: invokevirtual 90	kawa/lang/Translator:popPositionOf	(Ljava/lang/Object;)V
    //   289: goto -277 -> 12
    //   292: aload 14
    //   294: instanceof 104
    //   297: ifeq +57 -> 354
    //   300: aload 14
    //   302: invokevirtual 107	java/lang/Object:toString	()Ljava/lang/String;
    //   305: astore 14
    //   307: aload 5
    //   309: aload 9
    //   311: aload 14
    //   313: aload_3
    //   314: invokevirtual 111	kawa/lang/Translator:getMessages	()Lgnu/text/SourceMessages;
    //   317: invokevirtual 115	gnu/text/Options:set	(Ljava/lang/String;Ljava/lang/Object;Lgnu/text/SourceMessages;)V
    //   320: aload_1
    //   321: ifnull +24 -> 345
    //   324: aload_1
    //   325: aload 9
    //   327: invokevirtual 120	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   330: pop
    //   331: aload_1
    //   332: aload 15
    //   334: invokevirtual 120	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   337: pop
    //   338: aload_1
    //   339: aload 14
    //   341: invokevirtual 120	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   344: pop
    //   345: aload_3
    //   346: aload 10
    //   348: invokevirtual 90	kawa/lang/Translator:popPositionOf	(Ljava/lang/Object;)V
    //   351: goto -339 -> 12
    //   354: aload 14
    //   356: instanceof 122
    //   359: ifne -52 -> 307
    //   362: aload 14
    //   364: instanceof 124
    //   367: ifne -60 -> 307
    //   370: aload_3
    //   371: bipush 101
    //   373: new 38	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   380: ldc 126
    //   382: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload 9
    //   387: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokevirtual 56	kawa/lang/Translator:error	(CLjava/lang/String;)V
    //   396: aconst_null
    //   397: astore 14
    //   399: goto -92 -> 307
    //   402: astore 11
    //   404: aload_3
    //   405: aload 10
    //   407: invokevirtual 90	kawa/lang/Translator:popPositionOf	(Ljava/lang/Object;)V
    //   410: aload 11
    //   412: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	paramObject	Object
    //   0	413	1	paramStack	Stack
    //   0	413	2	paramSyntax	Syntax
    //   0	413	3	paramTranslator	Translator
    //   1	118	4	i	int
    //   7	301	5	localOptions	Options
    //   10	141	6	localSyntaxForm	kawa.lang.SyntaxForm
    //   87	42	7	localPair1	Pair
    //   97	11	8	localObject1	Object
    //   115	271	9	str	java.lang.String
    //   126	280	10	localObject2	Object
    //   402	9	11	localObject3	Object
    //   133	83	12	localObject4	Object
    //   220	13	13	localPair2	Pair
    //   230	168	14	localObject5	Object
    //   245	88	15	localObject6	Object
    //   204	9	19	localLList	LList
    // Exception table:
    //   from	to	target	type
    //   128	135	402	finally
    //   135	159	402	finally
    //   162	206	402	finally
    //   215	283	402	finally
    //   292	307	402	finally
    //   307	320	402	finally
    //   324	345	402	finally
    //   354	396	402	finally
  }
  
  /* Error */
  public gnu.expr.Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 76	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: instanceof 36
    //   9: ifeq +88 -> 97
    //   12: aload_3
    //   13: checkcast 36	gnu/lists/Pair
    //   16: astore 9
    //   18: aload 9
    //   20: invokevirtual 63	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   23: instanceof 117
    //   26: ifeq +71 -> 97
    //   29: aload 9
    //   31: invokevirtual 63	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   34: checkcast 117	java/util/Stack
    //   37: astore 4
    //   39: aload 9
    //   41: invokevirtual 76	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   44: astore 5
    //   46: aload_2
    //   47: getfield 28	kawa/lang/Translator:currentOptions	Lgnu/text/Options;
    //   50: aload 4
    //   52: invokevirtual 132	gnu/text/Options:pushOptionValues	(Ljava/util/Vector;)V
    //   55: aload_2
    //   56: aload 5
    //   58: invokevirtual 136	kawa/lang/Translator:rewrite_body	(Ljava/lang/Object;)Lgnu/expr/Expression;
    //   61: astore 7
    //   63: aload 7
    //   65: instanceof 138
    //   68: ifeq +51 -> 119
    //   71: aload 7
    //   73: checkcast 138	gnu/expr/BeginExp
    //   76: astore 8
    //   78: aload 8
    //   80: aload 4
    //   82: invokevirtual 141	gnu/expr/BeginExp:setCompileOptions	(Ljava/util/Vector;)V
    //   85: aload_2
    //   86: getfield 28	kawa/lang/Translator:currentOptions	Lgnu/text/Options;
    //   89: aload 4
    //   91: invokevirtual 144	gnu/text/Options:popOptionValues	(Ljava/util/Vector;)V
    //   94: aload 8
    //   96: areturn
    //   97: new 117	java/util/Stack
    //   100: dup
    //   101: invokespecial 145	java/util/Stack:<init>	()V
    //   104: astore 4
    //   106: aload_3
    //   107: aload 4
    //   109: aload_0
    //   110: aload_2
    //   111: invokestatic 147	kawa/standard/with_compile_options:getOptions	(Ljava/lang/Object;Ljava/util/Stack;Lkawa/lang/Syntax;Lkawa/lang/Translator;)Ljava/lang/Object;
    //   114: astore 5
    //   116: goto -61 -> 55
    //   119: new 138	gnu/expr/BeginExp
    //   122: dup
    //   123: iconst_1
    //   124: anewarray 149	gnu/expr/Expression
    //   127: dup
    //   128: iconst_0
    //   129: aload 7
    //   131: aastore
    //   132: invokespecial 152	gnu/expr/BeginExp:<init>	([Lgnu/expr/Expression;)V
    //   135: astore 8
    //   137: goto -59 -> 78
    //   140: astore 6
    //   142: aload_2
    //   143: getfield 28	kawa/lang/Translator:currentOptions	Lgnu/text/Options;
    //   146: aload 4
    //   148: invokevirtual 144	gnu/text/Options:popOptionValues	(Ljava/util/Vector;)V
    //   151: aload 6
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	with_compile_options
    //   0	154	1	paramPair	Pair
    //   0	154	2	paramTranslator	Translator
    //   4	103	3	localObject1	Object
    //   37	110	4	localStack	Stack
    //   44	71	5	localObject2	Object
    //   140	12	6	localObject3	Object
    //   61	69	7	localExpression	gnu.expr.Expression
    //   76	60	8	localBeginExp	gnu.expr.BeginExp
    //   16	24	9	localPair	Pair
    // Exception table:
    //   from	to	target	type
    //   55	78	140	finally
    //   78	85	140	finally
    //   119	137	140	finally
  }
  
  public void scanForm(Pair paramPair, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    Stack localStack = new Stack();
    Object localObject = getOptions(paramPair.getCdr(), localStack, this, paramTranslator);
    if (localObject == LList.Empty) {
      return;
    }
    if (localObject == paramPair.getCdr())
    {
      paramTranslator.scanBody(localObject, paramScopeExp, false);
      return;
    }
    Pair localPair = new Pair(localStack, paramTranslator.scanBody(localObject, paramScopeExp, true));
    paramTranslator.currentOptions.popOptionValues(localStack);
    paramTranslator.formStack.add(Translator.makePair(paramPair, paramPair.getCar(), localPair));
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.with_compile_options
 * JD-Core Version:    0.7.0.1
 */