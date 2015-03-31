package gnu.kawa.slib;

import gnu.expr.GenericProc;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.IsEqual;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Path;
import kawa.lang.Eval;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.parameters;
import kawa.lib.ports;
import kawa.lib.std_syntax;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.readchar;
import kawa.standard.syntax_case;

public class testing
  extends ModuleBody
{
  public static final ModuleMethod $Pctest$Mnbegin;
  static final ModuleMethod $Pctest$Mnnull$Mncallback;
  public static final ModuleMethod $Prvt$$Pctest$Mnapproximimate$Eq;
  public static final ModuleMethod $Prvt$$Pctest$Mnas$Mnspecifier;
  public static final Macro $Prvt$$Pctest$Mncomp1body;
  public static final Macro $Prvt$$Pctest$Mncomp2body;
  public static final ModuleMethod $Prvt$$Pctest$Mnend;
  public static final Macro $Prvt$$Pctest$Mnerror;
  public static final Macro $Prvt$$Pctest$Mnevaluate$Mnwith$Mncatch;
  public static final ModuleMethod $Prvt$$Pctest$Mnmatch$Mnall;
  public static final ModuleMethod $Prvt$$Pctest$Mnmatch$Mnany;
  public static final ModuleMethod $Prvt$$Pctest$Mnmatch$Mnnth;
  public static final ModuleMethod $Prvt$$Pctest$Mnon$Mntest$Mnbegin;
  public static final ModuleMethod $Prvt$$Pctest$Mnon$Mntest$Mnend;
  public static final ModuleMethod $Prvt$$Pctest$Mnreport$Mnresult;
  public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist;
  public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist$Ex;
  public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist;
  public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist$Ex;
  public static final ModuleMethod $Prvt$$Pctest$Mnshould$Mnexecute;
  public static final Macro $Prvt$test$Mngroup;
  public static final testing $instance;
  static final IntNum Lit0;
  static final SimpleSymbol Lit1;
  static final PairWithPosition Lit10;
  static final SyntaxPattern Lit100;
  static final SyntaxTemplate Lit101;
  static final SyntaxPattern Lit102;
  static final SyntaxTemplate Lit103;
  static final SimpleSymbol Lit104;
  static final SyntaxTemplate Lit105;
  static final SimpleSymbol Lit106;
  static final SyntaxTemplate Lit107;
  static final SimpleSymbol Lit108;
  static final SyntaxTemplate Lit109;
  static final PairWithPosition Lit11;
  static final SimpleSymbol Lit110;
  static final SyntaxPattern Lit111;
  static final SyntaxTemplate Lit112;
  static final SyntaxPattern Lit113;
  static final SyntaxTemplate Lit114;
  static final SimpleSymbol Lit115;
  static final SyntaxRules Lit116;
  static final SimpleSymbol Lit117;
  static final SyntaxPattern Lit118;
  static final SyntaxTemplate Lit119;
  static final SimpleSymbol Lit12;
  static final SyntaxPattern Lit120;
  static final SyntaxTemplate Lit121;
  static final SyntaxPattern Lit122;
  static final SyntaxTemplate Lit123;
  static final SimpleSymbol Lit124;
  static final SimpleSymbol Lit125;
  static final SyntaxRules Lit126;
  static final SimpleSymbol Lit127;
  static final SimpleSymbol Lit128;
  static final SyntaxRules Lit129;
  static final IntNum Lit13;
  static final SimpleSymbol Lit130;
  static final SimpleSymbol Lit131;
  static final SyntaxRules Lit132;
  static final SimpleSymbol Lit133;
  static final SimpleSymbol Lit134;
  static final SyntaxRules Lit135;
  static final SimpleSymbol Lit136;
  static final SimpleSymbol Lit137;
  static final SyntaxRules Lit138;
  static final SimpleSymbol Lit139;
  static final SimpleSymbol Lit14;
  static final SyntaxRules Lit140;
  static final SimpleSymbol Lit141;
  static final SimpleSymbol Lit142;
  static final SimpleSymbol Lit143;
  static final SimpleSymbol Lit144;
  static final SimpleSymbol Lit145;
  static final SimpleSymbol Lit146;
  static final SimpleSymbol Lit147;
  static final SimpleSymbol Lit148;
  static final SimpleSymbol Lit149;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit150;
  static final SimpleSymbol Lit151;
  static final SimpleSymbol Lit152;
  static final SimpleSymbol Lit153;
  static final SimpleSymbol Lit154;
  static final SimpleSymbol Lit155;
  static final SimpleSymbol Lit156;
  static final SimpleSymbol Lit157;
  static final SimpleSymbol Lit158;
  static final SimpleSymbol Lit159;
  static final SyntaxPattern Lit16;
  static final SimpleSymbol Lit160;
  static final SimpleSymbol Lit161;
  static final SimpleSymbol Lit162;
  static final SimpleSymbol Lit163;
  static final SimpleSymbol Lit164;
  static final SimpleSymbol Lit165 = (SimpleSymbol)new SimpleSymbol("dynamic-wind").readResolve();
  static final SyntaxTemplate Lit17;
  static final SyntaxPattern Lit18;
  static final SyntaxTemplate Lit19;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final SimpleSymbol Lit28;
  static final SimpleSymbol Lit29;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit30;
  static final SimpleSymbol Lit31;
  static final SimpleSymbol Lit32;
  static final SimpleSymbol Lit33;
  static final SimpleSymbol Lit34;
  static final SimpleSymbol Lit35;
  static final SimpleSymbol Lit36;
  static final SimpleSymbol Lit37;
  static final SimpleSymbol Lit38;
  static final SimpleSymbol Lit39;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit40;
  static final SimpleSymbol Lit41;
  static final SimpleSymbol Lit42;
  static final SimpleSymbol Lit43;
  static final SimpleSymbol Lit44;
  static final SimpleSymbol Lit45;
  static final SimpleSymbol Lit46;
  static final SimpleSymbol Lit47;
  static final SimpleSymbol Lit48;
  static final SimpleSymbol Lit49;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit50;
  static final SimpleSymbol Lit51;
  static final SimpleSymbol Lit52;
  static final SimpleSymbol Lit53;
  static final SimpleSymbol Lit54;
  static final SimpleSymbol Lit55;
  static final SimpleSymbol Lit56;
  static final SimpleSymbol Lit57;
  static final SimpleSymbol Lit58;
  static final SimpleSymbol Lit59;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit60;
  static final SimpleSymbol Lit61;
  static final SimpleSymbol Lit62;
  static final SimpleSymbol Lit63;
  static final SimpleSymbol Lit64;
  static final SimpleSymbol Lit65;
  static final SimpleSymbol Lit66;
  static final SimpleSymbol Lit67;
  static final SimpleSymbol Lit68;
  static final SimpleSymbol Lit69;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit70;
  static final SyntaxRules Lit71;
  static final SimpleSymbol Lit72;
  static final SyntaxRules Lit73;
  static final SimpleSymbol Lit74;
  static final SimpleSymbol Lit75;
  static final SyntaxRules Lit76;
  static final SimpleSymbol Lit77;
  static final SimpleSymbol Lit78;
  static final SimpleSymbol Lit79;
  static final PairWithPosition Lit8;
  static final SimpleSymbol Lit80;
  static final SimpleSymbol Lit81;
  static final SimpleSymbol Lit82;
  static final SimpleSymbol Lit83;
  static final SimpleSymbol Lit84;
  static final SyntaxRules Lit85;
  static final SimpleSymbol Lit86;
  static final SimpleSymbol Lit87;
  static final SimpleSymbol Lit88;
  static final SimpleSymbol Lit89;
  static final SimpleSymbol Lit9;
  static final SyntaxRules Lit90;
  static final SimpleSymbol Lit91;
  static final SimpleSymbol Lit92;
  static final SyntaxRules Lit93;
  static final SimpleSymbol Lit94;
  static final SyntaxPattern Lit95;
  static final SyntaxTemplate Lit96;
  static final SyntaxPattern Lit97;
  static final SyntaxTemplate Lit98;
  static final SimpleSymbol Lit99;
  static final ModuleMethod lambda$Fn1;
  static final ModuleMethod lambda$Fn2;
  static final ModuleMethod lambda$Fn3;
  public static final ModuleMethod test$Mnapply;
  public static final Macro test$Mnapproximate;
  public static final Macro test$Mnassert;
  public static final Macro test$Mnend;
  public static final Macro test$Mneq;
  public static final Macro test$Mnequal;
  public static final Macro test$Mneqv;
  public static final Macro test$Mnerror;
  public static final Macro test$Mnexpect$Mnfail;
  public static final Macro test$Mngroup$Mnwith$Mncleanup;
  public static Boolean test$Mnlog$Mnto$Mnfile;
  public static final Macro test$Mnmatch$Mnall;
  public static final Macro test$Mnmatch$Mnany;
  public static final ModuleMethod test$Mnmatch$Mnname;
  public static final Macro test$Mnmatch$Mnnth;
  public static final ModuleMethod test$Mnon$Mnbad$Mncount$Mnsimple;
  public static final ModuleMethod test$Mnon$Mnbad$Mnend$Mnname$Mnsimple;
  public static final ModuleMethod test$Mnon$Mnfinal$Mnsimple;
  public static final ModuleMethod test$Mnon$Mngroup$Mnbegin$Mnsimple;
  public static final ModuleMethod test$Mnon$Mngroup$Mnend$Mnsimple;
  static final ModuleMethod test$Mnon$Mntest$Mnbegin$Mnsimple;
  public static final ModuleMethod test$Mnon$Mntest$Mnend$Mnsimple;
  public static final ModuleMethod test$Mnpassed$Qu;
  public static final ModuleMethod test$Mnread$Mneval$Mnstring;
  public static final ModuleMethod test$Mnresult$Mnalist;
  public static final ModuleMethod test$Mnresult$Mnalist$Ex;
  public static final ModuleMethod test$Mnresult$Mnclear;
  public static final ModuleMethod test$Mnresult$Mnkind;
  public static final Macro test$Mnresult$Mnref;
  public static final ModuleMethod test$Mnresult$Mnremove;
  public static final ModuleMethod test$Mnresult$Mnset$Ex;
  static final Class test$Mnrunner;
  public static final ModuleMethod test$Mnrunner$Mnaux$Mnvalue;
  public static final ModuleMethod test$Mnrunner$Mnaux$Mnvalue$Ex;
  public static final ModuleMethod test$Mnrunner$Mncreate;
  public static Object test$Mnrunner$Mncurrent;
  public static Object test$Mnrunner$Mnfactory;
  public static final ModuleMethod test$Mnrunner$Mnfail$Mncount;
  public static final ModuleMethod test$Mnrunner$Mnfail$Mncount$Ex;
  public static final ModuleMethod test$Mnrunner$Mnget;
  public static final ModuleMethod test$Mnrunner$Mngroup$Mnpath;
  public static final ModuleMethod test$Mnrunner$Mngroup$Mnstack;
  public static final ModuleMethod test$Mnrunner$Mngroup$Mnstack$Ex;
  public static final ModuleMethod test$Mnrunner$Mnnull;
  public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mncount;
  public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mncount$Ex;
  public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mnend$Mnname;
  public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mnend$Mnname$Ex;
  public static final ModuleMethod test$Mnrunner$Mnon$Mnfinal;
  public static final ModuleMethod test$Mnrunner$Mnon$Mnfinal$Ex;
  public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnbegin;
  public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnbegin$Ex;
  public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnend;
  public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnend$Ex;
  public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnbegin;
  public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnbegin$Ex;
  public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnend;
  public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnend$Ex;
  public static final ModuleMethod test$Mnrunner$Mnpass$Mncount;
  public static final ModuleMethod test$Mnrunner$Mnpass$Mncount$Ex;
  public static final ModuleMethod test$Mnrunner$Mnreset;
  public static final ModuleMethod test$Mnrunner$Mnsimple;
  public static final ModuleMethod test$Mnrunner$Mnskip$Mncount;
  public static final ModuleMethod test$Mnrunner$Mnskip$Mncount$Ex;
  public static final ModuleMethod test$Mnrunner$Mntest$Mnname;
  public static final ModuleMethod test$Mnrunner$Mnxfail$Mncount;
  public static final ModuleMethod test$Mnrunner$Mnxfail$Mncount$Ex;
  public static final ModuleMethod test$Mnrunner$Mnxpass$Mncount;
  public static final ModuleMethod test$Mnrunner$Mnxpass$Mncount$Ex;
  public static final ModuleMethod test$Mnrunner$Qu;
  public static final Macro test$Mnskip;
  public static final Macro test$Mnwith$Mnrunner;
  
  static Object $PcTestAnySpecifierMatches(Object paramObject1, Object paramObject2)
  {
    Boolean localBoolean = Boolean.FALSE;
    for (Object localObject = paramObject1;; localObject = lists.cdr.apply1(localObject))
    {
      if (lists.isNull(localObject)) {
        return localBoolean;
      }
      if ($PcTestSpecificierMatches(lists.car.apply1(localObject), paramObject2) != Boolean.FALSE) {
        localBoolean = Boolean.TRUE;
      }
    }
  }
  
  public static Procedure $PcTestApproximimate$Eq(Object paramObject)
  {
    frame0 localframe0 = new frame0();
    localframe0.error = paramObject;
    return localframe0.lambda$Fn4;
  }
  
  public static Object $PcTestAsSpecifier(Object paramObject)
  {
    if (misc.isProcedure(paramObject)) {
      return paramObject;
    }
    if (numbers.isInteger(paramObject)) {
      return $PcTestMatchNth(Lit13, paramObject);
    }
    if (strings.isString(paramObject)) {
      return testMatchName(paramObject);
    }
    return misc.error$V("not a valid test specifier", new Object[0]);
  }
  
  /* Error */
  public static void $PcTestBegin(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 364	gnu/kawa/slib/testing:test$Mnrunner$Mncurrent	Ljava/lang/Object;
    //   3: checkcast 298	gnu/mapping/Procedure
    //   6: invokevirtual 368	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
    //   9: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   12: if_acmpne +16 -> 28
    //   15: getstatic 364	gnu/kawa/slib/testing:test$Mnrunner$Mncurrent	Ljava/lang/Object;
    //   18: checkcast 298	gnu/mapping/Procedure
    //   21: invokestatic 371	gnu/kawa/slib/testing:testRunnerCreate	()Ljava/lang/Object;
    //   24: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: pop
    //   28: getstatic 364	gnu/kawa/slib/testing:test$Mnrunner$Mncurrent	Ljava/lang/Object;
    //   31: checkcast 298	gnu/mapping/Procedure
    //   34: invokevirtual 368	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
    //   37: astore_2
    //   38: getstatic 377	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   41: astore_3
    //   42: aload_2
    //   43: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   46: astore 5
    //   48: aload_3
    //   49: aload 5
    //   51: invokestatic 383	gnu/kawa/slib/testing:testRunnerOnGroupBegin	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   54: aload_2
    //   55: aload_0
    //   56: aload_1
    //   57: invokevirtual 387	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   60: pop
    //   61: aload_2
    //   62: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   65: astore 8
    //   67: aload_2
    //   68: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   71: astore 10
    //   73: aload 10
    //   75: invokestatic 390	gnu/kawa/slib/testing:$PcTestRunnerSkipList	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   78: astore 11
    //   80: aload_2
    //   81: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   84: astore 13
    //   86: aload 8
    //   88: aload 11
    //   90: aload 13
    //   92: invokestatic 393	gnu/kawa/slib/testing:$PcTestRunnerSkipSave	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   95: invokestatic 397	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   98: invokestatic 401	gnu/kawa/slib/testing:$PcTestRunnerSkipSave$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   101: aload_2
    //   102: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   105: astore 15
    //   107: aload_2
    //   108: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   111: astore 17
    //   113: aload 17
    //   115: invokestatic 404	gnu/kawa/slib/testing:$PcTestRunnerFailList	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   118: astore 18
    //   120: aload_2
    //   121: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   124: astore 20
    //   126: aload 15
    //   128: aload 18
    //   130: aload 20
    //   132: invokestatic 407	gnu/kawa/slib/testing:$PcTestRunnerFailSave	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   135: invokestatic 397	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   138: invokestatic 410	gnu/kawa/slib/testing:$PcTestRunnerFailSave$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   141: aload_2
    //   142: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   145: astore 22
    //   147: aload_2
    //   148: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   151: astore 24
    //   153: aload 24
    //   155: invokestatic 413	gnu/kawa/slib/testing:$PcTestRunnerTotalCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   158: aload_1
    //   159: invokestatic 397	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   162: astore 25
    //   164: aload_2
    //   165: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   168: astore 27
    //   170: aload 22
    //   172: aload 25
    //   174: aload 27
    //   176: invokestatic 416	gnu/kawa/slib/testing:$PcTestRunnerCountList	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   179: invokestatic 397	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   182: invokestatic 419	gnu/kawa/slib/testing:$PcTestRunnerCountList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   185: aload_2
    //   186: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   189: astore 29
    //   191: aload_2
    //   192: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   195: astore 31
    //   197: aload 29
    //   199: aload_0
    //   200: aload 31
    //   202: invokestatic 422	gnu/kawa/slib/testing:testRunnerGroupStack	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   205: invokestatic 397	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   208: invokestatic 425	gnu/kawa/slib/testing:testRunnerGroupStack$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   211: return
    //   212: astore 4
    //   214: new 427	gnu/mapping/WrongType
    //   217: dup
    //   218: aload 4
    //   220: ldc_w 429
    //   223: iconst_0
    //   224: aload_2
    //   225: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   228: athrow
    //   229: astore 7
    //   231: new 427	gnu/mapping/WrongType
    //   234: dup
    //   235: aload 7
    //   237: ldc_w 434
    //   240: iconst_0
    //   241: aload_2
    //   242: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   245: athrow
    //   246: astore 9
    //   248: new 427	gnu/mapping/WrongType
    //   251: dup
    //   252: aload 9
    //   254: ldc_w 436
    //   257: iconst_0
    //   258: aload_2
    //   259: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   262: athrow
    //   263: astore 12
    //   265: new 427	gnu/mapping/WrongType
    //   268: dup
    //   269: aload 12
    //   271: ldc_w 438
    //   274: iconst_0
    //   275: aload_2
    //   276: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   279: athrow
    //   280: astore 14
    //   282: new 427	gnu/mapping/WrongType
    //   285: dup
    //   286: aload 14
    //   288: ldc_w 440
    //   291: iconst_0
    //   292: aload_2
    //   293: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   296: athrow
    //   297: astore 16
    //   299: new 427	gnu/mapping/WrongType
    //   302: dup
    //   303: aload 16
    //   305: ldc_w 442
    //   308: iconst_0
    //   309: aload_2
    //   310: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   313: athrow
    //   314: astore 19
    //   316: new 427	gnu/mapping/WrongType
    //   319: dup
    //   320: aload 19
    //   322: ldc_w 444
    //   325: iconst_0
    //   326: aload_2
    //   327: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   330: athrow
    //   331: astore 21
    //   333: new 427	gnu/mapping/WrongType
    //   336: dup
    //   337: aload 21
    //   339: ldc_w 446
    //   342: iconst_0
    //   343: aload_2
    //   344: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   347: athrow
    //   348: astore 23
    //   350: new 427	gnu/mapping/WrongType
    //   353: dup
    //   354: aload 23
    //   356: ldc_w 448
    //   359: iconst_0
    //   360: aload_2
    //   361: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   364: athrow
    //   365: astore 26
    //   367: new 427	gnu/mapping/WrongType
    //   370: dup
    //   371: aload 26
    //   373: ldc_w 450
    //   376: iconst_0
    //   377: aload_2
    //   378: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   381: athrow
    //   382: astore 28
    //   384: new 427	gnu/mapping/WrongType
    //   387: dup
    //   388: aload 28
    //   390: ldc_w 452
    //   393: iconst_0
    //   394: aload_2
    //   395: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   398: athrow
    //   399: astore 30
    //   401: new 427	gnu/mapping/WrongType
    //   404: dup
    //   405: aload 30
    //   407: ldc_w 454
    //   410: iconst_0
    //   411: aload_2
    //   412: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   415: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	paramObject1	Object
    //   0	416	1	paramObject2	Object
    //   37	375	2	localObject1	Object
    //   41	8	3	localApplyToArgs	ApplyToArgs
    //   212	7	4	localClassCastException1	ClassCastException
    //   46	4	5	localMnrunner1	test.Mnrunner
    //   229	7	7	localClassCastException2	ClassCastException
    //   65	22	8	localMnrunner2	test.Mnrunner
    //   246	7	9	localClassCastException3	ClassCastException
    //   71	3	10	localMnrunner3	test.Mnrunner
    //   78	11	11	localObject2	Object
    //   263	7	12	localClassCastException4	ClassCastException
    //   84	7	13	localMnrunner4	test.Mnrunner
    //   280	7	14	localClassCastException5	ClassCastException
    //   105	22	15	localMnrunner5	test.Mnrunner
    //   297	7	16	localClassCastException6	ClassCastException
    //   111	3	17	localMnrunner6	test.Mnrunner
    //   118	11	18	localObject3	Object
    //   314	7	19	localClassCastException7	ClassCastException
    //   124	7	20	localMnrunner7	test.Mnrunner
    //   331	7	21	localClassCastException8	ClassCastException
    //   145	26	22	localMnrunner8	test.Mnrunner
    //   348	7	23	localClassCastException9	ClassCastException
    //   151	3	24	localMnrunner9	test.Mnrunner
    //   162	11	25	localPair	Pair
    //   365	7	26	localClassCastException10	ClassCastException
    //   168	7	27	localMnrunner10	test.Mnrunner
    //   382	7	28	localClassCastException11	ClassCastException
    //   189	9	29	localMnrunner11	test.Mnrunner
    //   399	7	30	localClassCastException12	ClassCastException
    //   195	6	31	localMnrunner12	test.Mnrunner
    // Exception table:
    //   from	to	target	type
    //   42	48	212	java/lang/ClassCastException
    //   61	67	229	java/lang/ClassCastException
    //   67	73	246	java/lang/ClassCastException
    //   80	86	263	java/lang/ClassCastException
    //   101	107	280	java/lang/ClassCastException
    //   107	113	297	java/lang/ClassCastException
    //   120	126	314	java/lang/ClassCastException
    //   141	147	331	java/lang/ClassCastException
    //   147	153	348	java/lang/ClassCastException
    //   164	170	365	java/lang/ClassCastException
    //   185	191	382	java/lang/ClassCastException
    //   191	197	399	java/lang/ClassCastException
  }
  
  static Object $PcTestComp2(Object paramObject1, Object paramObject2)
  {
    Pair localPair = LList.list3(paramObject2, LList.list2(Lit15, $PcTestSourceLine2(paramObject2)), paramObject1);
    Object[] arrayOfObject = SyntaxPattern.allocVars(6, null);
    if (Lit16.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return Lit17.execute(arrayOfObject, localTemplateScope2);
    }
    if (Lit18.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      return Lit19.execute(arrayOfObject, localTemplateScope1);
    }
    return syntax_case.error("syntax-case", localPair);
  }
  
  public static Object $PcTestEnd(Object paramObject1, Object paramObject2)
  {
    localObject1 = testRunnerGet();
    for (;;)
    {
      try
      {
        test.Mnrunner localMnrunner1 = (test.Mnrunner)localObject1;
        localObject2 = testRunnerGroupStack(localMnrunner1);
        localObject3 = $PcTestFormatLine(localObject1);
      }
      catch (ClassCastException localClassCastException1)
      {
        Object localObject2;
        Object localObject3;
        test.Mnrunner localMnrunner2;
        ApplyToArgs localApplyToArgs1;
        test.Mnrunner localMnrunner3;
        test.Mnrunner localMnrunner4;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        AddOp localAddOp;
        test.Mnrunner localMnrunner5;
        Object localObject7;
        ApplyToArgs localApplyToArgs2;
        test.Mnrunner localMnrunner6;
        ApplyToArgs localApplyToArgs3;
        test.Mnrunner localMnrunner7;
        test.Mnrunner localMnrunner8;
        GenericProc localGenericProc1;
        test.Mnrunner localMnrunner9;
        test.Mnrunner localMnrunner10;
        GenericProc localGenericProc2;
        test.Mnrunner localMnrunner11;
        test.Mnrunner localMnrunner12;
        GenericProc localGenericProc3;
        test.Mnrunner localMnrunner13;
        test.Mnrunner localMnrunner14;
        GenericProc localGenericProc4;
        test.Mnrunner localMnrunner15;
        test.Mnrunner localMnrunner16;
        GenericProc localGenericProc5;
        test.Mnrunner localMnrunner17;
        test.Mnrunner localMnrunner18;
        test.Mnrunner localMnrunner19;
        ApplyToArgs localApplyToArgs4;
        test.Mnrunner localMnrunner20;
        throw new WrongType(localClassCastException1, "test-runner-group-stack", 0, localObject1);
      }
      try
      {
        localMnrunner2 = (test.Mnrunner)localObject1;
        testResultAlist$Ex(localMnrunner2, paramObject2);
        if (lists.isNull(localObject2)) {
          misc.error$V(strings.stringAppend(new Object[] { localObject3, "test-end not in a group" }), new Object[0]);
        }
        if (paramObject1 != Boolean.FALSE) {
          if (!IsEqual.apply(paramObject1, lists.car.apply1(localObject2))) {
            localApplyToArgs1 = Scheme.applyToArgs;
          }
        }
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "test-result-alist!", 0, localObject1);
      }
      try
      {
        localMnrunner3 = (test.Mnrunner)localObject1;
        localApplyToArgs1.apply4(testRunnerOnBadEndName(localMnrunner3), localObject1, paramObject1, lists.car.apply1(localObject2));
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "test-runner-on-bad-end-name", 0, localObject1);
      }
      try
      {
        localMnrunner4 = (test.Mnrunner)localObject1;
        localObject4 = $PcTestRunnerCountList(localMnrunner4);
        localObject5 = lists.cdar.apply1(localObject4);
        localObject6 = lists.caar.apply1(localObject4);
        localAddOp = AddOp.$Mn;
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "%test-runner-count-list", 0, localObject1);
      }
      try
      {
        localMnrunner5 = (test.Mnrunner)localObject1;
        localObject7 = localAddOp.apply2($PcTestRunnerTotalCount(localMnrunner5), localObject6);
        if (localObject5 != Boolean.FALSE) {
          if (Scheme.numEqu.apply2(localObject5, localObject7) == Boolean.FALSE) {
            localApplyToArgs2 = Scheme.applyToArgs;
          }
        }
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "%test-runner-total-count", 0, localObject1);
      }
      try
      {
        localMnrunner6 = (test.Mnrunner)localObject1;
        localApplyToArgs2.apply4(testRunnerOnBadCount(localMnrunner6), localObject1, localObject7, localObject5);
        localApplyToArgs3 = Scheme.applyToArgs;
      }
      catch (ClassCastException localClassCastException6)
      {
        throw new WrongType(localClassCastException6, "test-runner-on-bad-count", 0, localObject1);
      }
      try
      {
        localMnrunner7 = (test.Mnrunner)localObject1;
        localApplyToArgs3.apply2(testRunnerOnGroupEnd(localMnrunner7), localObject1);
      }
      catch (ClassCastException localClassCastException7)
      {
        throw new WrongType(localClassCastException7, "test-runner-on-group-end", 0, localObject1);
      }
      try
      {
        localMnrunner8 = (test.Mnrunner)localObject1;
        localGenericProc1 = lists.cdr;
      }
      catch (ClassCastException localClassCastException8)
      {
        throw new WrongType(localClassCastException8, "test-runner-group-stack!", 0, localObject1);
      }
      try
      {
        localMnrunner9 = (test.Mnrunner)localObject1;
        testRunnerGroupStack$Ex(localMnrunner8, localGenericProc1.apply1(testRunnerGroupStack(localMnrunner9)));
      }
      catch (ClassCastException localClassCastException9)
      {
        throw new WrongType(localClassCastException9, "test-runner-group-stack", 0, localObject1);
      }
      try
      {
        localMnrunner10 = (test.Mnrunner)localObject1;
        localGenericProc2 = lists.car;
      }
      catch (ClassCastException localClassCastException10)
      {
        throw new WrongType(localClassCastException10, "%test-runner-skip-list!", 0, localObject1);
      }
      try
      {
        localMnrunner11 = (test.Mnrunner)localObject1;
        $PcTestRunnerSkipList$Ex(localMnrunner10, localGenericProc2.apply1($PcTestRunnerSkipSave(localMnrunner11)));
      }
      catch (ClassCastException localClassCastException11)
      {
        throw new WrongType(localClassCastException11, "%test-runner-skip-save", 0, localObject1);
      }
      try
      {
        localMnrunner12 = (test.Mnrunner)localObject1;
        localGenericProc3 = lists.cdr;
      }
      catch (ClassCastException localClassCastException12)
      {
        throw new WrongType(localClassCastException12, "%test-runner-skip-save!", 0, localObject1);
      }
      try
      {
        localMnrunner13 = (test.Mnrunner)localObject1;
        $PcTestRunnerSkipSave$Ex(localMnrunner12, localGenericProc3.apply1($PcTestRunnerSkipSave(localMnrunner13)));
      }
      catch (ClassCastException localClassCastException13)
      {
        throw new WrongType(localClassCastException13, "%test-runner-skip-save", 0, localObject1);
      }
      try
      {
        localMnrunner14 = (test.Mnrunner)localObject1;
        localGenericProc4 = lists.car;
      }
      catch (ClassCastException localClassCastException14)
      {
        throw new WrongType(localClassCastException14, "%test-runner-fail-list!", 0, localObject1);
      }
      try
      {
        localMnrunner15 = (test.Mnrunner)localObject1;
        $PcTestRunnerFailList$Ex(localMnrunner14, localGenericProc4.apply1($PcTestRunnerFailSave(localMnrunner15)));
      }
      catch (ClassCastException localClassCastException15)
      {
        throw new WrongType(localClassCastException15, "%test-runner-fail-save", 0, localObject1);
      }
      try
      {
        localMnrunner16 = (test.Mnrunner)localObject1;
        localGenericProc5 = lists.cdr;
      }
      catch (ClassCastException localClassCastException16)
      {
        throw new WrongType(localClassCastException16, "%test-runner-fail-save!", 0, localObject1);
      }
      try
      {
        localMnrunner17 = (test.Mnrunner)localObject1;
        $PcTestRunnerFailSave$Ex(localMnrunner16, localGenericProc5.apply1($PcTestRunnerFailSave(localMnrunner17)));
      }
      catch (ClassCastException localClassCastException17)
      {
        throw new WrongType(localClassCastException17, "%test-runner-fail-save", 0, localObject1);
      }
      try
      {
        localMnrunner18 = (test.Mnrunner)localObject1;
        $PcTestRunnerCountList$Ex(localMnrunner18, lists.cdr.apply1(localObject4));
      }
      catch (ClassCastException localClassCastException18)
      {
        throw new WrongType(localClassCastException18, "%test-runner-count-list!", 0, localObject1);
      }
      try
      {
        localMnrunner19 = (test.Mnrunner)localObject1;
        if (lists.isNull(testRunnerGroupStack(localMnrunner19))) {
          localApplyToArgs4 = Scheme.applyToArgs;
        }
      }
      catch (ClassCastException localClassCastException19)
      {
        throw new WrongType(localClassCastException19, "test-runner-group-stack", 0, localObject1);
      }
      try
      {
        localMnrunner20 = (test.Mnrunner)localObject1;
        return localApplyToArgs4.apply2(testRunnerOnFinal(localMnrunner20), localObject1);
      }
      catch (ClassCastException localClassCastException20)
      {
        throw new WrongType(localClassCastException20, "test-runner-on-final", 0, localObject1);
      }
      if (paramObject1 != Boolean.FALSE)
      {
        continue;
        if (localObject5 == Boolean.FALSE) {}
      }
    }
    return Values.empty;
  }
  
  static void $PcTestFinalReport1(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (Scheme.numGrt.apply2(paramObject1, Lit0) != Boolean.FALSE)
    {
      ports.display(paramObject2, paramObject3);
      ports.display(paramObject1, paramObject3);
      ports.newline(paramObject3);
    }
  }
  
  /* Error */
  static void $PcTestFinalReportSimple(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   4: astore_3
    //   5: aload_3
    //   6: invokestatic 608	gnu/kawa/slib/testing:testRunnerPassCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   9: ldc_w 610
    //   12: aload_1
    //   13: invokestatic 612	gnu/kawa/slib/testing:$PcTestFinalReport1	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   16: aload_0
    //   17: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   20: astore 5
    //   22: aload 5
    //   24: invokestatic 615	gnu/kawa/slib/testing:testRunnerXfailCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   27: ldc_w 617
    //   30: aload_1
    //   31: invokestatic 612	gnu/kawa/slib/testing:$PcTestFinalReport1	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   34: aload_0
    //   35: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   38: astore 7
    //   40: aload 7
    //   42: invokestatic 620	gnu/kawa/slib/testing:testRunnerXpassCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   45: ldc_w 622
    //   48: aload_1
    //   49: invokestatic 612	gnu/kawa/slib/testing:$PcTestFinalReport1	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   52: aload_0
    //   53: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   56: astore 9
    //   58: aload 9
    //   60: invokestatic 625	gnu/kawa/slib/testing:testRunnerFailCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   63: ldc_w 627
    //   66: aload_1
    //   67: invokestatic 612	gnu/kawa/slib/testing:$PcTestFinalReport1	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   70: aload_0
    //   71: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   74: astore 11
    //   76: aload 11
    //   78: invokestatic 630	gnu/kawa/slib/testing:testRunnerSkipCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   81: ldc_w 632
    //   84: aload_1
    //   85: invokestatic 612	gnu/kawa/slib/testing:$PcTestFinalReport1	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   88: return
    //   89: astore_2
    //   90: new 427	gnu/mapping/WrongType
    //   93: dup
    //   94: aload_2
    //   95: ldc_w 634
    //   98: iconst_0
    //   99: aload_0
    //   100: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   103: athrow
    //   104: astore 4
    //   106: new 427	gnu/mapping/WrongType
    //   109: dup
    //   110: aload 4
    //   112: ldc_w 636
    //   115: iconst_0
    //   116: aload_0
    //   117: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   120: athrow
    //   121: astore 6
    //   123: new 427	gnu/mapping/WrongType
    //   126: dup
    //   127: aload 6
    //   129: ldc_w 638
    //   132: iconst_0
    //   133: aload_0
    //   134: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   137: athrow
    //   138: astore 8
    //   140: new 427	gnu/mapping/WrongType
    //   143: dup
    //   144: aload 8
    //   146: ldc_w 640
    //   149: iconst_0
    //   150: aload_0
    //   151: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   154: athrow
    //   155: astore 10
    //   157: new 427	gnu/mapping/WrongType
    //   160: dup
    //   161: aload 10
    //   163: ldc_w 642
    //   166: iconst_0
    //   167: aload_0
    //   168: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramObject1	Object
    //   0	172	1	paramObject2	Object
    //   89	6	2	localClassCastException1	ClassCastException
    //   4	2	3	localMnrunner1	test.Mnrunner
    //   104	7	4	localClassCastException2	ClassCastException
    //   20	3	5	localMnrunner2	test.Mnrunner
    //   121	7	6	localClassCastException3	ClassCastException
    //   38	3	7	localMnrunner3	test.Mnrunner
    //   138	7	8	localClassCastException4	ClassCastException
    //   56	3	9	localMnrunner4	test.Mnrunner
    //   155	7	10	localClassCastException5	ClassCastException
    //   74	3	11	localMnrunner5	test.Mnrunner
    // Exception table:
    //   from	to	target	type
    //   0	5	89	java/lang/ClassCastException
    //   16	22	104	java/lang/ClassCastException
    //   34	40	121	java/lang/ClassCastException
    //   52	58	138	java/lang/ClassCastException
    //   70	76	155	java/lang/ClassCastException
  }
  
  static Object $PcTestFormatLine(Object paramObject)
  {
    for (;;)
    {
      try
      {
        test.Mnrunner localMnrunner = (test.Mnrunner)paramObject;
        Object localObject1 = testResultAlist(localMnrunner);
        Object localObject2 = lists.assq(Lit4, localObject1);
        Object localObject3 = lists.assq(Lit5, localObject1);
        if (localObject2 != Boolean.FALSE)
        {
          localObject4 = lists.cdr.apply1(localObject2);
          if (localObject3 == Boolean.FALSE) {
            continue;
          }
          arrayOfObject = new Object[4];
          arrayOfObject[0] = localObject4;
          arrayOfObject[1] = ":";
          localObject5 = lists.cdr.apply1(localObject3);
        }
      }
      catch (ClassCastException localClassCastException1)
      {
        Object localObject4;
        Object[] arrayOfObject;
        Number localNumber;
        throw new WrongType(localClassCastException1, "test-result-alist", 0, paramObject);
      }
      try
      {
        localNumber = (Number)localObject5;
        arrayOfObject[2] = numbers.number$To$String(localNumber);
        arrayOfObject[3] = ": ";
        return strings.stringAppend(arrayOfObject);
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "number->string", 1, localObject5);
      }
      localObject4 = "";
    }
    return "";
  }
  
  public static Procedure $PcTestMatchAll$V(Object[] paramArrayOfObject)
  {
    frame3 localframe3 = new frame3();
    localframe3.pred$Mnlist = LList.makeList(paramArrayOfObject, 0);
    return localframe3.lambda$Fn12;
  }
  
  public static Procedure $PcTestMatchAny$V(Object[] paramArrayOfObject)
  {
    frame4 localframe4 = new frame4();
    localframe4.pred$Mnlist = LList.makeList(paramArrayOfObject, 0);
    return localframe4.lambda$Fn13;
  }
  
  public static Procedure $PcTestMatchNth(Object paramObject1, Object paramObject2)
  {
    frame2 localframe2 = new frame2();
    localframe2.n = paramObject1;
    localframe2.count = paramObject2;
    localframe2.i = Lit0;
    return localframe2.lambda$Fn11;
  }
  
  static Boolean $PcTestNullCallback(Object paramObject)
  {
    return Boolean.FALSE;
  }
  
  static void $PcTestOnBadCountWrite(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    ports.display("*** Total number of tests was ", paramObject4);
    ports.display(paramObject2, paramObject4);
    ports.display(" but should be ", paramObject4);
    ports.display(paramObject3, paramObject4);
    ports.display(". ***", paramObject4);
    ports.newline(paramObject4);
    ports.display("*** Discrepancy indicates testsuite error or exceptions. ***", paramObject4);
    ports.newline(paramObject4);
  }
  
  /* Error */
  public static boolean $PcTestOnTestBegin(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 723	gnu/kawa/slib/testing:$PcTestShouldExecute	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: getstatic 377	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   8: astore_2
    //   9: aload_0
    //   10: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   13: astore 4
    //   15: aload_2
    //   16: aload 4
    //   18: invokestatic 726	gnu/kawa/slib/testing:testRunnerOnTestBegin	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   21: aload_0
    //   22: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   25: pop
    //   26: getstatic 728	gnu/kawa/slib/testing:Lit2	Lgnu/mapping/SimpleSymbol;
    //   29: astore 6
    //   31: getstatic 730	gnu/kawa/slib/testing:Lit1	Lgnu/mapping/SimpleSymbol;
    //   34: astore 7
    //   36: aload_0
    //   37: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   40: astore 9
    //   42: aload 7
    //   44: aload 9
    //   46: invokestatic 645	gnu/kawa/slib/testing:testResultAlist	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   49: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: astore 10
    //   54: aload 10
    //   56: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   59: if_acmpeq +30 -> 89
    //   62: getstatic 311	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   65: aload 10
    //   67: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   70: astore 11
    //   72: aload 6
    //   74: aload 11
    //   76: if_acmpne +21 -> 97
    //   79: iconst_1
    //   80: istore 12
    //   82: iconst_1
    //   83: iload 12
    //   85: iconst_1
    //   86: iadd
    //   87: iand
    //   88: ireturn
    //   89: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   92: astore 11
    //   94: goto -22 -> 72
    //   97: iconst_0
    //   98: istore 12
    //   100: goto -18 -> 82
    //   103: astore_3
    //   104: new 427	gnu/mapping/WrongType
    //   107: dup
    //   108: aload_3
    //   109: ldc_w 732
    //   112: iconst_0
    //   113: aload_0
    //   114: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   117: athrow
    //   118: astore 8
    //   120: new 427	gnu/mapping/WrongType
    //   123: dup
    //   124: aload 8
    //   126: ldc_w 666
    //   129: iconst_0
    //   130: aload_0
    //   131: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramObject	Object
    //   8	8	2	localApplyToArgs	ApplyToArgs
    //   103	6	3	localClassCastException1	ClassCastException
    //   13	4	4	localMnrunner1	test.Mnrunner
    //   29	44	6	localSimpleSymbol1	SimpleSymbol
    //   34	9	7	localSimpleSymbol2	SimpleSymbol
    //   118	7	8	localClassCastException2	ClassCastException
    //   40	5	9	localMnrunner2	test.Mnrunner
    //   52	14	10	localObject1	Object
    //   70	23	11	localObject2	Object
    //   80	19	12	i	int
    // Exception table:
    //   from	to	target	type
    //   9	15	103	java/lang/ClassCastException
    //   36	42	118	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object $PcTestOnTestEnd(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 730	gnu/kawa/slib/testing:Lit1	Lgnu/mapping/SimpleSymbol;
    //   3: astore_2
    //   4: getstatic 730	gnu/kawa/slib/testing:Lit1	Lgnu/mapping/SimpleSymbol;
    //   7: astore_3
    //   8: aload_0
    //   9: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   12: astore 5
    //   14: aload_3
    //   15: aload 5
    //   17: invokestatic 645	gnu/kawa/slib/testing:testResultAlist	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   20: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   23: astore 6
    //   25: aload 6
    //   27: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   30: if_acmpeq +41 -> 71
    //   33: getstatic 311	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   36: aload 6
    //   38: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: astore 7
    //   43: aload 7
    //   45: getstatic 735	gnu/kawa/slib/testing:Lit3	Lgnu/mapping/SimpleSymbol;
    //   48: if_acmpne +39 -> 87
    //   51: aload_1
    //   52: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   55: if_acmpeq +24 -> 79
    //   58: getstatic 737	gnu/kawa/slib/testing:Lit9	Lgnu/mapping/SimpleSymbol;
    //   61: astore 8
    //   63: aload_0
    //   64: aload_2
    //   65: aload 8
    //   67: invokestatic 741	gnu/kawa/slib/testing:testResultSet$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: areturn
    //   71: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   74: astore 7
    //   76: goto -33 -> 43
    //   79: getstatic 735	gnu/kawa/slib/testing:Lit3	Lgnu/mapping/SimpleSymbol;
    //   82: astore 8
    //   84: goto -21 -> 63
    //   87: aload_1
    //   88: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   91: if_acmpeq +11 -> 102
    //   94: getstatic 743	gnu/kawa/slib/testing:Lit12	Lgnu/mapping/SimpleSymbol;
    //   97: astore 8
    //   99: goto -36 -> 63
    //   102: getstatic 745	gnu/kawa/slib/testing:Lit14	Lgnu/mapping/SimpleSymbol;
    //   105: astore 8
    //   107: goto -44 -> 63
    //   110: astore 4
    //   112: new 427	gnu/mapping/WrongType
    //   115: dup
    //   116: aload 4
    //   118: ldc_w 666
    //   121: iconst_0
    //   122: aload_0
    //   123: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramObject1	Object
    //   0	127	1	paramObject2	Object
    //   3	62	2	localSimpleSymbol1	SimpleSymbol
    //   7	8	3	localSimpleSymbol2	SimpleSymbol
    //   110	7	4	localClassCastException	ClassCastException
    //   12	4	5	localMnrunner	test.Mnrunner
    //   23	14	6	localObject1	Object
    //   41	34	7	localObject2	Object
    //   61	45	8	localSimpleSymbol3	SimpleSymbol
    // Exception table:
    //   from	to	target	type
    //   8	14	110	java/lang/ClassCastException
  }
  
  public static Object $PcTestReportResult()
  {
    localObject1 = testRunnerGet();
    Object localObject2 = testResultKind$V(new Object[] { localObject1 });
    if (Scheme.isEqv.apply2(localObject2, Lit12) != Boolean.FALSE) {}
    for (;;)
    {
      try
      {
        localMnrunner12 = (test.Mnrunner)localObject1;
        localAddOp6 = AddOp.$Pl;
        localIntNum6 = Lit13;
      }
      catch (ClassCastException localClassCastException12)
      {
        try
        {
          test.Mnrunner localMnrunner12;
          AddOp localAddOp6;
          IntNum localIntNum6;
          test.Mnrunner localMnrunner13;
          test.Mnrunner localMnrunner3;
          AddOp localAddOp2;
          IntNum localIntNum2;
          test.Mnrunner localMnrunner4;
          ApplyToArgs localApplyToArgs;
          test.Mnrunner localMnrunner5;
          localMnrunner6 = (test.Mnrunner)localObject1;
          localAddOp3 = AddOp.$Pl;
          localIntNum3 = Lit13;
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "test-runner-xfail-count!", 0, localObject1);
        }
        try
        {
          localMnrunner7 = (test.Mnrunner)localObject1;
          testRunnerXfailCount$Ex(localMnrunner6, localAddOp3.apply2(localIntNum3, testRunnerXfailCount(localMnrunner7)));
        }
        catch (ClassCastException localClassCastException7)
        {
          throw new WrongType(localClassCastException7, "test-runner-xfail-count", 0, localObject1);
        }
        try
        {
          localMnrunner1 = (test.Mnrunner)localObject1;
          localAddOp1 = AddOp.$Pl;
          localIntNum1 = Lit13;
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "test-runner-skip-count!", 0, localObject1);
        }
        try
        {
          localMnrunner2 = (test.Mnrunner)localObject1;
          testRunnerSkipCount$Ex(localMnrunner1, localAddOp1.apply2(localIntNum1, testRunnerSkipCount(localMnrunner2)));
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "test-runner-skip-count", 0, localObject1);
        }
        localClassCastException12 = localClassCastException12;
        throw new WrongType(localClassCastException12, "test-runner-pass-count!", 0, localObject1);
      }
      try
      {
        localMnrunner13 = (test.Mnrunner)localObject1;
        testRunnerPassCount$Ex(localMnrunner12, localAddOp6.apply2(localIntNum6, testRunnerPassCount(localMnrunner13)));
      }
      catch (ClassCastException localClassCastException13)
      {
        throw new WrongType(localClassCastException13, "test-runner-pass-count", 0, localObject1);
      }
      try
      {
        localMnrunner3 = (test.Mnrunner)localObject1;
        localAddOp2 = AddOp.$Pl;
        localIntNum2 = Lit13;
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "%test-runner-total-count!", 0, localObject1);
      }
      try
      {
        localMnrunner4 = (test.Mnrunner)localObject1;
        $PcTestRunnerTotalCount$Ex(localMnrunner3, localAddOp2.apply2(localIntNum2, $PcTestRunnerTotalCount(localMnrunner4)));
        localApplyToArgs = Scheme.applyToArgs;
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "%test-runner-total-count", 0, localObject1);
      }
      try
      {
        localMnrunner5 = (test.Mnrunner)localObject1;
        return localApplyToArgs.apply2(testRunnerOnTestEnd(localMnrunner5), localObject1);
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "test-runner-on-test-end", 0, localObject1);
      }
      if (Scheme.isEqv.apply2(localObject2, Lit14) != Boolean.FALSE) {}
      try
      {
        localMnrunner10 = (test.Mnrunner)localObject1;
        localAddOp5 = AddOp.$Pl;
        localIntNum5 = Lit13;
      }
      catch (ClassCastException localClassCastException10)
      {
        test.Mnrunner localMnrunner10;
        AddOp localAddOp5;
        IntNum localIntNum5;
        test.Mnrunner localMnrunner11;
        throw new WrongType(localClassCastException10, "test-runner-fail-count!", 0, localObject1);
      }
      try
      {
        localMnrunner11 = (test.Mnrunner)localObject1;
        testRunnerFailCount$Ex(localMnrunner10, localAddOp5.apply2(localIntNum5, testRunnerFailCount(localMnrunner11)));
      }
      catch (ClassCastException localClassCastException11)
      {
        throw new WrongType(localClassCastException11, "test-runner-fail-count", 0, localObject1);
      }
      if (Scheme.isEqv.apply2(localObject2, Lit9) != Boolean.FALSE) {}
      try
      {
        localMnrunner8 = (test.Mnrunner)localObject1;
        localAddOp4 = AddOp.$Pl;
        localIntNum4 = Lit13;
      }
      catch (ClassCastException localClassCastException8)
      {
        test.Mnrunner localMnrunner8;
        AddOp localAddOp4;
        IntNum localIntNum4;
        test.Mnrunner localMnrunner9;
        test.Mnrunner localMnrunner6;
        AddOp localAddOp3;
        IntNum localIntNum3;
        test.Mnrunner localMnrunner7;
        test.Mnrunner localMnrunner1;
        AddOp localAddOp1;
        IntNum localIntNum1;
        test.Mnrunner localMnrunner2;
        throw new WrongType(localClassCastException8, "test-runner-xpass-count!", 0, localObject1);
      }
      try
      {
        localMnrunner9 = (test.Mnrunner)localObject1;
        testRunnerXpassCount$Ex(localMnrunner8, localAddOp4.apply2(localIntNum4, testRunnerXpassCount(localMnrunner9)));
      }
      catch (ClassCastException localClassCastException9)
      {
        throw new WrongType(localClassCastException9, "test-runner-xpass-count", 0, localObject1);
      }
    }
    if (Scheme.isEqv.apply2(localObject2, Lit3) == Boolean.FALSE) {}
  }
  
  static test.Mnrunner $PcTestRunnerAlloc()
  {
    return new test.Mnrunner();
  }
  
  static Object $PcTestRunnerCountList(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.count$Mnlist;
  }
  
  static void $PcTestRunnerCountList$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.count$Mnlist = paramObject;
  }
  
  public static Object $PcTestRunnerFailList(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.fail$Mnlist;
  }
  
  public static void $PcTestRunnerFailList$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.fail$Mnlist = paramObject;
  }
  
  static Object $PcTestRunnerFailSave(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.fail$Mnsave;
  }
  
  static void $PcTestRunnerFailSave$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.fail$Mnsave = paramObject;
  }
  
  static Object $PcTestRunnerRunList(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.run$Mnlist;
  }
  
  static void $PcTestRunnerRunList$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.run$Mnlist = paramObject;
  }
  
  public static Object $PcTestRunnerSkipList(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.skip$Mnlist;
  }
  
  public static void $PcTestRunnerSkipList$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.skip$Mnlist = paramObject;
  }
  
  static Object $PcTestRunnerSkipSave(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.skip$Mnsave;
  }
  
  static void $PcTestRunnerSkipSave$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.skip$Mnsave = paramObject;
  }
  
  static Object $PcTestRunnerTotalCount(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.total$Mncount;
  }
  
  static void $PcTestRunnerTotalCount$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.total$Mncount = paramObject;
  }
  
  public static Object $PcTestShouldExecute(Object paramObject)
  {
    for (;;)
    {
      try
      {
        test.Mnrunner localMnrunner1 = (test.Mnrunner)paramObject;
        localObject1 = $PcTestRunnerRunList(localMnrunner1);
        if (localObject1 != Boolean.TRUE) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          Object localObject1;
          int j;
          Boolean localBoolean = Boolean.FALSE;
          if (localObject2 != localBoolean)
          {
            i = 1;
            continue;
          }
          int i = 0;
        }
        catch (ClassCastException localClassCastException2)
        {
          Object localObject2;
          test.Mnrunner localMnrunner2;
          test.Mnrunner localMnrunner3;
          throw new WrongType(localClassCastException2, "x", -2, localObject2);
        }
        try
        {
          localMnrunner2 = (test.Mnrunner)paramObject;
          if ($PcTestAnySpecifierMatches($PcTestRunnerSkipList(localMnrunner2), paramObject) != Boolean.FALSE) {
            continue;
          }
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "%test-runner-skip-list", 0, paramObject);
        }
        try
        {
          localMnrunner3 = (test.Mnrunner)paramObject;
          if ($PcTestAnySpecifierMatches($PcTestRunnerFailList(localMnrunner3), paramObject) != Boolean.FALSE)
          {
            testResultSet$Ex(paramObject, Lit1, Lit3);
            return Lit3;
          }
          return Boolean.TRUE;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "%test-runner-fail-list", 0, paramObject);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "%test-runner-run-list", 0, paramObject);
      }
      j = 0x1 & i + 1;
      if (j == 0) {
        continue;
      }
      if (j == 0) {
        continue;
      }
      testResultSet$Ex(paramObject, Lit1, Lit2);
      return Boolean.FALSE;
      i = 0;
    }
    localObject2 = $PcTestAnySpecifierMatches(localObject1, paramObject);
  }
  
  static Pair $PcTestSourceLine2(Object paramObject)
  {
    Object localObject1 = std_syntax.syntaxLine(paramObject);
    Object localObject2 = $PcTestSyntaxFile(paramObject);
    if (localObject1 != Boolean.FALSE) {}
    for (Object localObject3 = LList.list1(lists.cons(Lit5, localObject1));; localObject3 = LList.Empty)
    {
      Pair localPair = lists.cons(Lit6, std_syntax.syntaxObject$To$Datum(paramObject));
      if (localObject2 != Boolean.FALSE) {
        localObject3 = lists.cons(lists.cons(Lit4, localObject2), localObject3);
      }
      return lists.cons(localPair, localObject3);
    }
  }
  
  static Object $PcTestSpecificierMatches(Object paramObject1, Object paramObject2)
  {
    return Scheme.applyToArgs.apply2(paramObject1, paramObject2);
  }
  
  static Object $PcTestSyntaxFile(Object paramObject)
  {
    return std_syntax.syntaxSource(paramObject);
  }
  
  static Object $PcTestWriteResult1(Object paramObject1, Object paramObject2)
  {
    ports.display("  ", paramObject2);
    ports.display(lists.car.apply1(paramObject1), paramObject2);
    ports.display(": ", paramObject2);
    ports.write(lists.cdr.apply1(paramObject1), paramObject2);
    ports.newline(paramObject2);
    return Values.empty;
  }
  
  static
  {
    Lit164 = (SimpleSymbol)new SimpleSymbol("p").readResolve();
    Lit163 = (SimpleSymbol)new SimpleSymbol("exp").readResolve();
    Lit162 = (SimpleSymbol)new SimpleSymbol("res").readResolve();
    Lit161 = (SimpleSymbol)new SimpleSymbol("if").readResolve();
    Lit160 = (SimpleSymbol)new SimpleSymbol("name").readResolve();
    Lit159 = (SimpleSymbol)new SimpleSymbol("instance?").readResolve();
    Lit158 = (SimpleSymbol)new SimpleSymbol("cond").readResolve();
    Lit157 = (SimpleSymbol)new SimpleSymbol("actual-error").readResolve();
    Lit156 = (SimpleSymbol)new SimpleSymbol("<java.lang.Throwable>").readResolve();
    Lit155 = (SimpleSymbol)new SimpleSymbol("actual-value").readResolve();
    Lit154 = (SimpleSymbol)new SimpleSymbol("try-catch").readResolve();
    Lit153 = (SimpleSymbol)new SimpleSymbol("et").readResolve();
    Lit152 = (SimpleSymbol)new SimpleSymbol("expected-error").readResolve();
    Lit151 = (SimpleSymbol)new SimpleSymbol("ex").readResolve();
    Lit150 = (SimpleSymbol)new SimpleSymbol("let*").readResolve();
    Lit149 = (SimpleSymbol)new SimpleSymbol("r").readResolve();
    Lit148 = (SimpleSymbol)new SimpleSymbol("saved-runner").readResolve();
    Lit147 = (SimpleSymbol)new SimpleSymbol("lambda").readResolve();
    Lit146 = (SimpleSymbol)new SimpleSymbol("test-runner-current").readResolve();
    Lit145 = (SimpleSymbol)new SimpleSymbol("cons").readResolve();
    Lit144 = (SimpleSymbol)new SimpleSymbol("let").readResolve();
    Lit143 = (SimpleSymbol)new SimpleSymbol("runner").readResolve();
    Lit142 = (SimpleSymbol)new SimpleSymbol("test-read-eval-string").readResolve();
    Lit141 = (SimpleSymbol)new SimpleSymbol("test-match-name").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("test-expect-fail").readResolve();
    Lit139 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("", new Object[0], 1);
    Object[] arrayOfObject2 = new Object[8];
    arrayOfObject2[0] = Lit144;
    SimpleSymbol localSimpleSymbol2 = Lit143;
    SimpleSymbol localSimpleSymbol3 = (SimpleSymbol)new SimpleSymbol("test-runner-get").readResolve();
    Lit60 = localSimpleSymbol3;
    arrayOfObject2[1] = PairWithPosition.make(PairWithPosition.make(localSimpleSymbol2, PairWithPosition.make(PairWithPosition.make(localSimpleSymbol3, LList.Empty, "testing.scm", 3952660), LList.Empty, "testing.scm", 3952660), "testing.scm", 3952652), LList.Empty, "testing.scm", 3952651);
    SimpleSymbol localSimpleSymbol4 = (SimpleSymbol)new SimpleSymbol("%test-runner-fail-list!").readResolve();
    Lit34 = localSimpleSymbol4;
    arrayOfObject2[2] = localSimpleSymbol4;
    arrayOfObject2[3] = Lit143;
    arrayOfObject2[4] = Lit145;
    SimpleSymbol localSimpleSymbol5 = (SimpleSymbol)new SimpleSymbol("test-match-all").readResolve();
    Lit131 = localSimpleSymbol5;
    arrayOfObject2[5] = localSimpleSymbol5;
    SimpleSymbol localSimpleSymbol6 = (SimpleSymbol)new SimpleSymbol("%test-as-specifier").readResolve();
    Lit136 = localSimpleSymbol6;
    arrayOfObject2[6] = localSimpleSymbol6;
    SimpleSymbol localSimpleSymbol7 = (SimpleSymbol)new SimpleSymbol("%test-runner-fail-list").readResolve();
    Lit33 = localSimpleSymbol7;
    arrayOfObject2[7] = PairWithPosition.make(PairWithPosition.make(localSimpleSymbol7, PairWithPosition.make(Lit143, LList.Empty, "testing.scm", 3964958), "testing.scm", 3964934), LList.Empty, "testing.scm", 3964934);
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\003", "\021\030\004\021\030\f\b\021\030\024\021\030\034\b\021\030$Q\021\030,\b\005\021\0304\b\003\030<", arrayOfObject2, 1);
    Lit140 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 1);
    Object[] arrayOfObject3 = new Object[1];
    SimpleSymbol localSimpleSymbol8 = (SimpleSymbol)new SimpleSymbol("test-skip").readResolve();
    Lit137 = localSimpleSymbol8;
    arrayOfObject3[0] = localSimpleSymbol8;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("", new Object[0], 1);
    Object[] arrayOfObject4 = new Object[8];
    arrayOfObject4[0] = Lit144;
    arrayOfObject4[1] = PairWithPosition.make(PairWithPosition.make(Lit143, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 3919892), LList.Empty, "testing.scm", 3919892), "testing.scm", 3919884), LList.Empty, "testing.scm", 3919883);
    SimpleSymbol localSimpleSymbol9 = (SimpleSymbol)new SimpleSymbol("%test-runner-skip-list!").readResolve();
    Lit32 = localSimpleSymbol9;
    arrayOfObject4[2] = localSimpleSymbol9;
    arrayOfObject4[3] = Lit143;
    arrayOfObject4[4] = Lit145;
    arrayOfObject4[5] = Lit131;
    arrayOfObject4[6] = Lit136;
    SimpleSymbol localSimpleSymbol10 = (SimpleSymbol)new SimpleSymbol("%test-runner-skip-list").readResolve();
    Lit31 = localSimpleSymbol10;
    arrayOfObject4[7] = PairWithPosition.make(PairWithPosition.make(localSimpleSymbol10, PairWithPosition.make(Lit143, LList.Empty, "testing.scm", 3932190), "testing.scm", 3932166), LList.Empty, "testing.scm", 3932166);
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern2, "\003", "\021\030\004\021\030\f\b\021\030\024\021\030\034\b\021\030$Q\021\030,\b\005\021\0304\b\003\030<", arrayOfObject4, 1);
    Lit138 = new SyntaxRules(arrayOfObject3, arrayOfSyntaxRule2, 1);
    Object[] arrayOfObject5 = new Object[1];
    SimpleSymbol localSimpleSymbol11 = (SimpleSymbol)new SimpleSymbol("test-match-any").readResolve();
    Lit134 = localSimpleSymbol11;
    arrayOfObject5[0] = localSimpleSymbol11;
    SyntaxRule[] arrayOfSyntaxRule3 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("", new Object[0], 1);
    Object[] arrayOfObject6 = new Object[2];
    SimpleSymbol localSimpleSymbol12 = (SimpleSymbol)new SimpleSymbol("%test-match-any").readResolve();
    Lit133 = localSimpleSymbol12;
    arrayOfObject6[0] = localSimpleSymbol12;
    arrayOfObject6[1] = Lit136;
    arrayOfSyntaxRule3[0] = new SyntaxRule(localSyntaxPattern3, "\003", "\021\030\004\b\005\021\030\f\b\003", arrayOfObject6, 1);
    Lit135 = new SyntaxRules(arrayOfObject5, arrayOfSyntaxRule3, 1);
    Object[] arrayOfObject7 = new Object[1];
    arrayOfObject7[0] = Lit131;
    SyntaxRule[] arrayOfSyntaxRule4 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern4 = new SyntaxPattern("", new Object[0], 1);
    Object[] arrayOfObject8 = new Object[2];
    SimpleSymbol localSimpleSymbol13 = (SimpleSymbol)new SimpleSymbol("%test-match-all").readResolve();
    Lit130 = localSimpleSymbol13;
    arrayOfObject8[0] = localSimpleSymbol13;
    arrayOfObject8[1] = Lit136;
    arrayOfSyntaxRule4[0] = new SyntaxRule(localSyntaxPattern4, "\003", "\021\030\004\b\005\021\030\f\b\003", arrayOfObject8, 1);
    Lit132 = new SyntaxRules(arrayOfObject7, arrayOfSyntaxRule4, 1);
    Object[] arrayOfObject9 = new Object[1];
    SimpleSymbol localSimpleSymbol14 = (SimpleSymbol)new SimpleSymbol("test-match-nth").readResolve();
    Lit128 = localSimpleSymbol14;
    arrayOfObject9[0] = localSimpleSymbol14;
    SyntaxRule[] arrayOfSyntaxRule5 = new SyntaxRule[2];
    SyntaxPattern localSyntaxPattern5 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject10 = new Object[2];
    arrayOfObject10[0] = Lit128;
    IntNum localIntNum = IntNum.make(1);
    Lit13 = localIntNum;
    arrayOfObject10[1] = PairWithPosition.make(localIntNum, LList.Empty, "testing.scm", 3727384);
    arrayOfSyntaxRule5[0] = new SyntaxRule(localSyntaxPattern5, "\001", "\021\030\004\t\003\030\f", arrayOfObject10, 0);
    SyntaxPattern localSyntaxPattern6 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject11 = new Object[1];
    SimpleSymbol localSimpleSymbol15 = (SimpleSymbol)new SimpleSymbol("%test-match-nth").readResolve();
    Lit127 = localSimpleSymbol15;
    arrayOfObject11[0] = localSimpleSymbol15;
    arrayOfSyntaxRule5[1] = new SyntaxRule(localSyntaxPattern6, "\001\001", "\021\030\004\t\003\b\013", arrayOfObject11, 0);
    Lit129 = new SyntaxRules(arrayOfObject9, arrayOfSyntaxRule5, 2);
    Object[] arrayOfObject12 = new Object[1];
    SimpleSymbol localSimpleSymbol16 = (SimpleSymbol)new SimpleSymbol("test-with-runner").readResolve();
    Lit125 = localSimpleSymbol16;
    arrayOfObject12[0] = localSimpleSymbol16;
    SyntaxRule[] arrayOfSyntaxRule6 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern7 = new SyntaxPattern("\f\030\f\007\r\017\b\b\b", new Object[0], 2);
    Object[] arrayOfObject13 = new Object[6];
    arrayOfObject13[0] = Lit144;
    arrayOfObject13[1] = PairWithPosition.make(PairWithPosition.make(Lit148, PairWithPosition.make(PairWithPosition.make(Lit146, LList.Empty, "testing.scm", 3657754), LList.Empty, "testing.scm", 3657754), "testing.scm", 3657740), LList.Empty, "testing.scm", 3657739);
    arrayOfObject13[2] = Lit165;
    arrayOfObject13[3] = Lit147;
    arrayOfObject13[4] = Lit146;
    arrayOfObject13[5] = PairWithPosition.make(PairWithPosition.make(Lit147, PairWithPosition.make(LList.Empty, PairWithPosition.make(PairWithPosition.make(Lit146, PairWithPosition.make(Lit148, LList.Empty, "testing.scm", 3674156), "testing.scm", 3674135), LList.Empty, "testing.scm", 3674135), "testing.scm", 3674132), "testing.scm", 3674124), LList.Empty, "testing.scm", 3674124);
    arrayOfSyntaxRule6[0] = new SyntaxRule(localSyntaxPattern7, "\001\003", "\021\030\004\021\030\f\b\021\030\024Y\021\030\034\t\020\b\021\030$\b\003A\021\030\034\t\020\b\r\013\030,", arrayOfObject13, 1);
    Lit126 = new SyntaxRules(arrayOfObject12, arrayOfSyntaxRule6, 2);
    Lit124 = (SimpleSymbol)new SimpleSymbol("test-apply").readResolve();
    Object[] arrayOfObject14 = new Object[6];
    arrayOfObject14[0] = Lit150;
    arrayOfObject14[1] = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 3514382), LList.Empty, "testing.scm", 3514382), "testing.scm", 3514379), LList.Empty, "testing.scm", 3514378);
    SimpleSymbol localSimpleSymbol17 = (SimpleSymbol)new SimpleSymbol("test-result-alist!").readResolve();
    Lit52 = localSimpleSymbol17;
    arrayOfObject14[2] = localSimpleSymbol17;
    arrayOfObject14[3] = Lit149;
    SimpleSymbol localSimpleSymbol18 = (SimpleSymbol)new SimpleSymbol("%test-error").readResolve();
    Lit115 = localSimpleSymbol18;
    arrayOfObject14[4] = localSimpleSymbol18;
    arrayOfObject14[5] = Boolean.TRUE;
    Lit123 = new SyntaxTemplate("\001\001\001", "\021\030\004\021\030\fA\021\030\024\021\030\034\b\023\b\021\030$\021\030\034\021\030,\b\013", arrayOfObject14, 0);
    Lit122 = new SyntaxPattern(",\f\007\f\017\b\f\027\b", new Object[0], 3);
    Object[] arrayOfObject15 = new Object[5];
    arrayOfObject15[0] = Lit150;
    arrayOfObject15[1] = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 3493902), LList.Empty, "testing.scm", 3493902), "testing.scm", 3493899), LList.Empty, "testing.scm", 3493898);
    arrayOfObject15[2] = Lit52;
    arrayOfObject15[3] = Lit149;
    arrayOfObject15[4] = Lit115;
    Lit121 = new SyntaxTemplate("\001\001\001\001", "\021\030\004\021\030\fA\021\030\024\021\030\034\b\033\b\021\030$\021\030\034\t\013\b\023", arrayOfObject15, 0);
    Lit120 = new SyntaxPattern("<\f\007\f\017\f\027\b\f\037\b", new Object[0], 4);
    Object[] arrayOfObject16 = new Object[8];
    arrayOfObject16[0] = Lit150;
    arrayOfObject16[1] = PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 3469326), LList.Empty, "testing.scm", 3469326), "testing.scm", 3469323);
    arrayOfObject16[2] = Lit160;
    arrayOfObject16[3] = Lit52;
    arrayOfObject16[4] = Lit149;
    arrayOfObject16[5] = Lit145;
    SimpleSymbol localSimpleSymbol19 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    Lit15 = localSimpleSymbol19;
    SimpleSymbol localSimpleSymbol20 = (SimpleSymbol)new SimpleSymbol("test-name").readResolve();
    Lit7 = localSimpleSymbol20;
    arrayOfObject16[6] = PairWithPosition.make(localSimpleSymbol19, PairWithPosition.make(localSimpleSymbol20, LList.Empty, "testing.scm", 3477545), "testing.scm", 3477545);
    arrayOfObject16[7] = Lit115;
    Lit119 = new SyntaxTemplate("\001\001\001\001\001", "\021\030\004I\021\030\f\b\021\030\024\b\013©\021\030\034\021\030$\b\021\030,A\021\030,\021\0304\b\013\b#\b\021\030<\021\030$\t\023\b\033", arrayOfObject16, 0);
    Lit118 = new SyntaxPattern("L\f\007\f\017\f\027\f\037\b\f'\b", new Object[0], 5);
    Lit117 = (SimpleSymbol)new SimpleSymbol("test-error").readResolve();
    Object[] arrayOfObject17 = new Object[1];
    arrayOfObject17[0] = Lit115;
    SyntaxRule[] arrayOfSyntaxRule7 = new SyntaxRule[2];
    Object[] arrayOfObject18 = new Object[1];
    arrayOfObject18[0] = Boolean.TRUE;
    SyntaxPattern localSyntaxPattern8 = new SyntaxPattern("\f\030\f\007\f\002\f\017\b", arrayOfObject18, 2);
    Object[] arrayOfObject19 = new Object[14];
    arrayOfObject19[0] = Lit158;
    SimpleSymbol localSimpleSymbol21 = (SimpleSymbol)new SimpleSymbol("%test-on-test-begin").readResolve();
    Lit86 = localSimpleSymbol21;
    arrayOfObject19[1] = localSimpleSymbol21;
    SimpleSymbol localSimpleSymbol22 = (SimpleSymbol)new SimpleSymbol("test-result-set!").readResolve();
    Lit78 = localSimpleSymbol22;
    arrayOfObject19[2] = localSimpleSymbol22;
    arrayOfObject19[3] = PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit152, LList.Empty, "testing.scm", 3223581), "testing.scm", 3223581), PairWithPosition.make(Boolean.TRUE, LList.Empty, "testing.scm", 3223596), "testing.scm", 3223580);
    SimpleSymbol localSimpleSymbol23 = (SimpleSymbol)new SimpleSymbol("%test-on-test-end").readResolve();
    Lit87 = localSimpleSymbol23;
    arrayOfObject19[4] = localSimpleSymbol23;
    arrayOfObject19[5] = Lit154;
    arrayOfObject19[6] = Lit144;
    arrayOfObject19[7] = PairWithPosition.make(Lit15, PairWithPosition.make(Lit155, LList.Empty, "testing.scm", 3239966), "testing.scm", 3239966);
    arrayOfObject19[8] = PairWithPosition.make(Boolean.FALSE, LList.Empty, "testing.scm", 3244041);
    arrayOfObject19[9] = Lit151;
    arrayOfObject19[10] = Lit156;
    arrayOfObject19[11] = PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit157, LList.Empty, "testing.scm", 3252256), "testing.scm", 3252256), PairWithPosition.make(Lit151, LList.Empty, "testing.scm", 3252269), "testing.scm", 3252255);
    arrayOfObject19[12] = PairWithPosition.make(Boolean.TRUE, LList.Empty, "testing.scm", 3256331);
    SimpleSymbol localSimpleSymbol24 = (SimpleSymbol)new SimpleSymbol("%test-report-result").readResolve();
    Lit83 = localSimpleSymbol24;
    arrayOfObject19[13] = PairWithPosition.make(PairWithPosition.make(localSimpleSymbol24, LList.Empty, "testing.scm", 3260424), LList.Empty, "testing.scm", 3260424);
    arrayOfSyntaxRule7[0] = new SyntaxRule(localSyntaxPattern8, "\001\001", "\021\030\004\b)\021\030\f\b\0039\021\030\024\t\003\030\034ũ\021\030$\t\003\b\021\030,\021\0304\t\020Q\021\030\024\t\003\021\030<\b\013\030D\b\021\030L\021\030T9\021\030\024\t\003\030\\\030d\030l", arrayOfObject19, 0);
    SyntaxPattern localSyntaxPattern9 = new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3);
    Object[] arrayOfObject20 = new Object[15];
    arrayOfObject20[0] = Lit161;
    arrayOfObject20[1] = Lit86;
    arrayOfObject20[2] = Lit144;
    arrayOfObject20[3] = Lit153;
    arrayOfObject20[4] = Lit78;
    arrayOfObject20[5] = PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit152, LList.Empty, "testing.scm", 3276828), "testing.scm", 3276828), PairWithPosition.make(Lit153, LList.Empty, "testing.scm", 3276843), "testing.scm", 3276827);
    arrayOfObject20[6] = Lit87;
    arrayOfObject20[7] = Lit154;
    arrayOfObject20[8] = PairWithPosition.make(Lit15, PairWithPosition.make(Lit155, LList.Empty, "testing.scm", 3293213), "testing.scm", 3293213);
    arrayOfObject20[9] = PairWithPosition.make(Boolean.FALSE, LList.Empty, "testing.scm", 3297288);
    arrayOfObject20[10] = Lit151;
    arrayOfObject20[11] = Lit156;
    arrayOfObject20[12] = PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit157, LList.Empty, "testing.scm", 3305503), "testing.scm", 3305503), PairWithPosition.make(Lit151, LList.Empty, "testing.scm", 3305516), "testing.scm", 3305502);
    arrayOfObject20[13] = PairWithPosition.make(PairWithPosition.make(Lit158, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make((SimpleSymbol)new SimpleSymbol("and").readResolve(), PairWithPosition.make(PairWithPosition.make(Lit159, PairWithPosition.make(Lit153, PairWithPosition.make((SimpleSymbol)new SimpleSymbol("<gnu.bytecode.ClassType>").readResolve(), LList.Empty, "testing.scm", 3309604), "testing.scm", 3309601), "testing.scm", 3309590), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make((SimpleSymbol)new SimpleSymbol("$lookup$").readResolve(), Pair.make((SimpleSymbol)new SimpleSymbol("gnu.bytecode.ClassType").readResolve(), Pair.make(Pair.make((SimpleSymbol)new SimpleSymbol("quasiquote").readResolve(), Pair.make((SimpleSymbol)new SimpleSymbol("isSubclass").readResolve(), LList.Empty)), LList.Empty)), "testing.scm", 3313673), PairWithPosition.make(Lit153, PairWithPosition.make(Lit156, LList.Empty, "testing.scm", 3313710), "testing.scm", 3313707), "testing.scm", 3313672), LList.Empty, "testing.scm", 3313672), "testing.scm", 3309590), "testing.scm", 3309585), PairWithPosition.make(PairWithPosition.make(Lit159, PairWithPosition.make(Lit151, PairWithPosition.make(Lit153, LList.Empty, "testing.scm", 3317784), "testing.scm", 3317781), "testing.scm", 3317770), LList.Empty, "testing.scm", 3317770), "testing.scm", 3309584), PairWithPosition.make(PairWithPosition.make((SimpleSymbol)new SimpleSymbol("else").readResolve(), PairWithPosition.make(Boolean.TRUE, LList.Empty, "testing.scm", 3321871), "testing.scm", 3321865), LList.Empty, "testing.scm", 3321865), "testing.scm", 3309584), "testing.scm", 3309578), LList.Empty, "testing.scm", 3309578);
    arrayOfObject20[14] = PairWithPosition.make(PairWithPosition.make(Lit83, LList.Empty, "testing.scm", 3325959), LList.Empty, "testing.scm", 3325959);
    arrayOfSyntaxRule7[1] = new SyntaxRule(localSyntaxPattern9, "\001\001\001", "\021\030\004)\021\030\f\b\003\b\021\030\0241\b\021\030\034\b\0139\021\030$\t\003\030,ũ\021\0304\t\003\b\021\030<\021\030\024\t\020Q\021\030$\t\003\021\030D\b\023\030L\b\021\030T\021\030\\9\021\030$\t\003\030d\030l\030t", arrayOfObject20, 0);
    Lit116 = new SyntaxRules(arrayOfObject17, arrayOfSyntaxRule7, 3);
    Object[] arrayOfObject21 = new Object[6];
    arrayOfObject21[0] = Lit150;
    arrayOfObject21[1] = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 2916364), LList.Empty, "testing.scm", 2916364), "testing.scm", 2916361), LList.Empty, "testing.scm", 2916360);
    arrayOfObject21[2] = Lit52;
    arrayOfObject21[3] = Lit149;
    SimpleSymbol localSimpleSymbol25 = (SimpleSymbol)new SimpleSymbol("%test-comp2body").readResolve();
    Lit89 = localSimpleSymbol25;
    arrayOfObject21[4] = localSimpleSymbol25;
    SimpleSymbol localSimpleSymbol26 = (SimpleSymbol)new SimpleSymbol("%test-approximimate=").readResolve();
    Lit91 = localSimpleSymbol26;
    arrayOfObject21[5] = localSimpleSymbol26;
    Lit114 = new SyntaxTemplate("\001\001\001\001\001", "\021\030\004\021\030\fA\021\030\024\021\030\034\b#\b\021\030$\021\030\034)\021\030,\b\033\t\013\b\023", arrayOfObject21, 0);
    Lit113 = new SyntaxPattern("L\f\007\f\017\f\027\f\037\b\f'\b", new Object[0], 5);
    Object[] arrayOfObject22 = new Object[9];
    arrayOfObject22[0] = Lit150;
    arrayOfObject22[1] = PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 2891788), LList.Empty, "testing.scm", 2891788), "testing.scm", 2891785);
    arrayOfObject22[2] = Lit160;
    arrayOfObject22[3] = Lit52;
    arrayOfObject22[4] = Lit149;
    arrayOfObject22[5] = Lit145;
    arrayOfObject22[6] = PairWithPosition.make(Lit15, PairWithPosition.make(Lit7, LList.Empty, "testing.scm", 2900007), "testing.scm", 2900007);
    arrayOfObject22[7] = Lit89;
    arrayOfObject22[8] = Lit91;
    Lit112 = new SyntaxTemplate("\001\001\001\001\001\001", "\021\030\004I\021\030\f\b\021\030\024\b\013©\021\030\034\021\030$\b\021\030,A\021\030,\021\0304\b\013\b+\b\021\030<\021\030$)\021\030D\b#\t\023\b\033", arrayOfObject22, 0);
    Lit111 = new SyntaxPattern("\\\f\007\f\017\f\027\f\037\f'\b\f/\b", new Object[0], 6);
    Lit110 = (SimpleSymbol)new SimpleSymbol("test-approximate").readResolve();
    Object[] arrayOfObject23 = new Object[1];
    arrayOfObject23[0] = ((SimpleSymbol)new SimpleSymbol("equal?").readResolve());
    Lit109 = new SyntaxTemplate("", "\030\004", arrayOfObject23, 0);
    Lit108 = (SimpleSymbol)new SimpleSymbol("test-equal").readResolve();
    Object[] arrayOfObject24 = new Object[1];
    arrayOfObject24[0] = ((SimpleSymbol)new SimpleSymbol("eq?").readResolve());
    Lit107 = new SyntaxTemplate("", "\030\004", arrayOfObject24, 0);
    Lit106 = (SimpleSymbol)new SimpleSymbol("test-eq").readResolve();
    Object[] arrayOfObject25 = new Object[1];
    arrayOfObject25[0] = ((SimpleSymbol)new SimpleSymbol("eqv?").readResolve());
    Lit105 = new SyntaxTemplate("", "\030\004", arrayOfObject25, 0);
    Lit104 = (SimpleSymbol)new SimpleSymbol("test-eqv").readResolve();
    Object[] arrayOfObject26 = new Object[5];
    arrayOfObject26[0] = Lit150;
    arrayOfObject26[1] = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 2781198), LList.Empty, "testing.scm", 2781198), "testing.scm", 2781195), LList.Empty, "testing.scm", 2781194);
    arrayOfObject26[2] = Lit52;
    arrayOfObject26[3] = Lit149;
    SimpleSymbol localSimpleSymbol27 = (SimpleSymbol)new SimpleSymbol("%test-comp1body").readResolve();
    Lit92 = localSimpleSymbol27;
    arrayOfObject26[4] = localSimpleSymbol27;
    Lit103 = new SyntaxTemplate("\001\001\001", "\021\030\004\021\030\fA\021\030\024\021\030\034\b\023\b\021\030$\021\030\034\b\013", arrayOfObject26, 0);
    Lit102 = new SyntaxPattern(",\f\007\f\017\b\f\027\b", new Object[0], 3);
    Object[] arrayOfObject27 = new Object[8];
    arrayOfObject27[0] = Lit150;
    arrayOfObject27[1] = PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 2756622), LList.Empty, "testing.scm", 2756622), "testing.scm", 2756619);
    arrayOfObject27[2] = Lit160;
    arrayOfObject27[3] = Lit52;
    arrayOfObject27[4] = Lit149;
    arrayOfObject27[5] = Lit145;
    arrayOfObject27[6] = PairWithPosition.make(Lit15, PairWithPosition.make(Lit7, LList.Empty, "testing.scm", 2764841), "testing.scm", 2764841);
    arrayOfObject27[7] = Lit92;
    Lit101 = new SyntaxTemplate("\001\001\001\001", "\021\030\004I\021\030\f\b\021\030\024\b\013©\021\030\034\021\030$\b\021\030,A\021\030,\021\0304\b\013\b\033\b\021\030<\021\030$\b\023", arrayOfObject27, 0);
    Lit100 = new SyntaxPattern("<\f\007\f\017\f\027\b\f\037\b", new Object[0], 4);
    Lit99 = (SimpleSymbol)new SimpleSymbol("test-assert").readResolve();
    Object[] arrayOfObject28 = new Object[2];
    SimpleSymbol localSimpleSymbol28 = (SimpleSymbol)new SimpleSymbol("%test-end").readResolve();
    Lit69 = localSimpleSymbol28;
    arrayOfObject28[0] = localSimpleSymbol28;
    arrayOfObject28[1] = Boolean.FALSE;
    Lit98 = new SyntaxTemplate("\001\001", "\021\030\004\021\030\f\b\013", arrayOfObject28, 0);
    Lit97 = new SyntaxPattern("\034\f\007\b\f\017\b", new Object[0], 2);
    Object[] arrayOfObject29 = new Object[1];
    arrayOfObject29[0] = Lit69;
    Lit96 = new SyntaxTemplate("\001\001\001", "\021\030\004\t\013\b\023", arrayOfObject29, 0);
    Lit95 = new SyntaxPattern(",\f\007\f\017\b\f\027\b", new Object[0], 3);
    Lit94 = (SimpleSymbol)new SimpleSymbol("test-end").readResolve();
    Object[] arrayOfObject30 = new Object[1];
    arrayOfObject30[0] = Lit92;
    SyntaxRule[] arrayOfSyntaxRule8 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern10 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject31 = new Object[10];
    arrayOfObject31[0] = Lit144;
    arrayOfObject31[1] = Lit161;
    arrayOfObject31[2] = Lit86;
    arrayOfObject31[3] = Lit162;
    SimpleSymbol localSimpleSymbol29 = (SimpleSymbol)new SimpleSymbol("%test-evaluate-with-catch").readResolve();
    Lit84 = localSimpleSymbol29;
    arrayOfObject31[4] = localSimpleSymbol29;
    arrayOfObject31[5] = Lit78;
    arrayOfObject31[6] = PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit155, LList.Empty, "testing.scm", 2666526), "testing.scm", 2666526), PairWithPosition.make(Lit162, LList.Empty, "testing.scm", 2666539), "testing.scm", 2666525);
    arrayOfObject31[7] = Lit87;
    arrayOfObject31[8] = PairWithPosition.make(Lit162, LList.Empty, "testing.scm", 2670622);
    arrayOfObject31[9] = PairWithPosition.make(PairWithPosition.make(Lit83, LList.Empty, "testing.scm", 2674696), LList.Empty, "testing.scm", 2674696);
    arrayOfSyntaxRule8[0] = new SyntaxRule(localSyntaxPattern10, "\001\001", "\021\030\004\t\020ű\021\030\f)\021\030\024\b\003\b\021\030\004\t\020\b\021\030\004Q\b\021\030\034\b\021\030$\b\0139\021\030,\t\003\0304\b\021\030<\t\003\030D\030L", arrayOfObject31, 0);
    Lit93 = new SyntaxRules(arrayOfObject30, arrayOfSyntaxRule8, 2);
    Object[] arrayOfObject32 = new Object[1];
    arrayOfObject32[0] = Lit89;
    SyntaxRule[] arrayOfSyntaxRule9 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern11 = new SyntaxPattern("\f\030\f\007\f\017\f\027\f\037\b", new Object[0], 4);
    Object[] arrayOfObject33 = new Object[12];
    arrayOfObject33[0] = Lit144;
    arrayOfObject33[1] = Lit161;
    arrayOfObject33[2] = Lit86;
    arrayOfObject33[3] = Lit163;
    arrayOfObject33[4] = Lit78;
    arrayOfObject33[5] = PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make((SimpleSymbol)new SimpleSymbol("expected-value").readResolve(), LList.Empty, "testing.scm", 2592794), "testing.scm", 2592794), PairWithPosition.make(Lit163, LList.Empty, "testing.scm", 2592809), "testing.scm", 2592793);
    arrayOfObject33[6] = Lit162;
    arrayOfObject33[7] = Lit84;
    arrayOfObject33[8] = PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit155, LList.Empty, "testing.scm", 2600988), "testing.scm", 2600988), PairWithPosition.make(Lit162, LList.Empty, "testing.scm", 2601001), "testing.scm", 2600987);
    arrayOfObject33[9] = Lit87;
    arrayOfObject33[10] = PairWithPosition.make(Lit163, PairWithPosition.make(Lit162, LList.Empty, "testing.scm", 2605094), "testing.scm", 2605090);
    arrayOfObject33[11] = PairWithPosition.make(PairWithPosition.make(Lit83, LList.Empty, "testing.scm", 2609158), LList.Empty, "testing.scm", 2609158);
    arrayOfSyntaxRule9[0] = new SyntaxRule(localSyntaxPattern11, "\001\001\001\001", "\021\030\004\t\020Ǳ\021\030\f)\021\030\024\b\003\b\021\030\0041\b\021\030\034\b\0239\021\030$\t\003\030,\b\021\030\004Q\b\021\0304\b\021\030<\b\0339\021\030$\t\003\030D\b\021\030L\t\003\b\t\013\030T\030\\", arrayOfObject33, 0);
    Lit90 = new SyntaxRules(arrayOfObject32, arrayOfSyntaxRule9, 4);
    Lit88 = (SimpleSymbol)new SimpleSymbol("test-runner-test-name").readResolve();
    Object[] arrayOfObject34 = new Object[1];
    arrayOfObject34[0] = Lit84;
    SyntaxRule[] arrayOfSyntaxRule10 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern12 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject35 = new Object[2];
    arrayOfObject35[0] = Lit154;
    arrayOfObject35[1] = PairWithPosition.make(PairWithPosition.make(Lit151, PairWithPosition.make(Lit156, PairWithPosition.make(PairWithPosition.make(Lit78, PairWithPosition.make(PairWithPosition.make(Lit146, LList.Empty, "testing.scm", 2347035), PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit157, LList.Empty, "testing.scm", 2347058), "testing.scm", 2347058), PairWithPosition.make(Lit151, LList.Empty, "testing.scm", 2347071), "testing.scm", 2347057), "testing.scm", 2347035), "testing.scm", 2347017), PairWithPosition.make(Boolean.FALSE, LList.Empty, "testing.scm", 2351113), "testing.scm", 2347017), "testing.scm", 2342921), "testing.scm", 2342917), LList.Empty, "testing.scm", 2342917);
    arrayOfSyntaxRule10[0] = new SyntaxRule(localSyntaxPattern12, "\001", "\021\030\004\t\003\030\f", arrayOfObject35, 0);
    Lit85 = new SyntaxRules(arrayOfObject34, arrayOfSyntaxRule10, 1);
    Lit82 = (SimpleSymbol)new SimpleSymbol("test-passed?").readResolve();
    Lit81 = (SimpleSymbol)new SimpleSymbol("test-result-kind").readResolve();
    Lit80 = (SimpleSymbol)new SimpleSymbol("test-result-remove").readResolve();
    Lit79 = (SimpleSymbol)new SimpleSymbol("test-result-clear").readResolve();
    Lit77 = (SimpleSymbol)new SimpleSymbol("test-on-test-end-simple").readResolve();
    Object[] arrayOfObject36 = new Object[1];
    SimpleSymbol localSimpleSymbol30 = (SimpleSymbol)new SimpleSymbol("test-result-ref").readResolve();
    Lit75 = localSimpleSymbol30;
    arrayOfObject36[0] = localSimpleSymbol30;
    SyntaxRule[] arrayOfSyntaxRule11 = new SyntaxRule[2];
    SyntaxPattern localSyntaxPattern13 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject37 = new Object[2];
    arrayOfObject37[0] = Lit75;
    arrayOfObject37[1] = PairWithPosition.make(Boolean.FALSE, LList.Empty, "testing.scm", 1933348);
    arrayOfSyntaxRule11[0] = new SyntaxRule(localSyntaxPattern13, "\001\001", "\021\030\004\t\003\t\013\030\f", arrayOfObject37, 0);
    SyntaxPattern localSyntaxPattern14 = new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3);
    Object[] arrayOfObject38 = new Object[6];
    arrayOfObject38[0] = Lit144;
    arrayOfObject38[1] = Lit164;
    arrayOfObject38[2] = ((SimpleSymbol)new SimpleSymbol("assq").readResolve());
    SimpleSymbol localSimpleSymbol31 = (SimpleSymbol)new SimpleSymbol("test-result-alist").readResolve();
    Lit51 = localSimpleSymbol31;
    arrayOfObject38[3] = localSimpleSymbol31;
    arrayOfObject38[4] = Lit161;
    arrayOfObject38[5] = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("cdr").readResolve(), PairWithPosition.make(Lit164, LList.Empty, "testing.scm", 1945619), "testing.scm", 1945614);
    arrayOfSyntaxRule11[1] = new SyntaxRule(localSyntaxPattern14, "\001\001\001", "\021\030\004\b\021\030\f\b\021\030\024\t\013\b\021\030\034\b\003\b\021\030$\021\030\f\021\030,\b\023", arrayOfObject38, 0);
    Lit76 = new SyntaxRules(arrayOfObject36, arrayOfSyntaxRule11, 3);
    Lit74 = (SimpleSymbol)new SimpleSymbol("test-on-test-begin-simple").readResolve();
    Object[] arrayOfObject39 = new Object[1];
    SimpleSymbol localSimpleSymbol32 = (SimpleSymbol)new SimpleSymbol("test-group-with-cleanup").readResolve();
    Lit72 = localSimpleSymbol32;
    arrayOfObject39[0] = localSimpleSymbol32;
    SyntaxRule[] arrayOfSyntaxRule12 = new SyntaxRule[3];
    SyntaxPattern localSyntaxPattern15 = new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3);
    Object[] arrayOfObject40 = new Object[4];
    SimpleSymbol localSimpleSymbol33 = (SimpleSymbol)new SimpleSymbol("test-group").readResolve();
    Lit70 = localSimpleSymbol33;
    arrayOfObject40[0] = localSimpleSymbol33;
    arrayOfObject40[1] = Lit165;
    arrayOfObject40[2] = PairWithPosition.make(Lit147, PairWithPosition.make(LList.Empty, PairWithPosition.make(Boolean.FALSE, LList.Empty, "testing.scm", 1826831), "testing.scm", 1826828), "testing.scm", 1826820);
    arrayOfObject40[3] = Lit147;
    arrayOfSyntaxRule12[0] = new SyntaxRule(localSyntaxPattern15, "\001\001\001", "\021\030\004\t\003\b\021\030\f\021\030\0249\021\030\034\t\020\b\013\b\021\030\034\t\020\b\023", arrayOfObject40, 0);
    SyntaxPattern localSyntaxPattern16 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject41 = new Object[2];
    arrayOfObject41[0] = Lit72;
    arrayOfObject41[1] = Boolean.FALSE;
    arrayOfSyntaxRule12[1] = new SyntaxRule(localSyntaxPattern16, "\001\001", "\021\030\004\t\003\021\030\f\b\013", arrayOfObject41, 0);
    SyntaxPattern localSyntaxPattern17 = new SyntaxPattern("\f\030\f\007\f\017\f\027\f\037#", new Object[0], 5);
    Object[] arrayOfObject42 = new Object[2];
    arrayOfObject42[0] = Lit72;
    arrayOfObject42[1] = ((SimpleSymbol)new SimpleSymbol("begin").readResolve());
    arrayOfSyntaxRule12[2] = new SyntaxRule(localSyntaxPattern17, "", "\021\030\004\t\0039\021\030\f\t\013\b\023\t\033\"", arrayOfObject42, 0);
    Lit73 = new SyntaxRules(arrayOfObject39, arrayOfSyntaxRule12, 5);
    Object[] arrayOfObject43 = new Object[1];
    arrayOfObject43[0] = Lit70;
    SyntaxRule[] arrayOfSyntaxRule13 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern18 = new SyntaxPattern("\f\030\f\007\013", new Object[0], 2);
    Object[] arrayOfObject44 = new Object[13];
    arrayOfObject44[0] = Lit144;
    arrayOfObject44[1] = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit146, LList.Empty, "testing.scm", 1769487), LList.Empty, "testing.scm", 1769487), "testing.scm", 1769484), LList.Empty, "testing.scm", 1769483);
    arrayOfObject44[2] = Lit52;
    arrayOfObject44[3] = Lit149;
    arrayOfObject44[4] = ((SimpleSymbol)new SimpleSymbol("list").readResolve());
    arrayOfObject44[5] = Lit145;
    arrayOfObject44[6] = PairWithPosition.make(Lit15, PairWithPosition.make(Lit7, LList.Empty, "testing.scm", 1777707), "testing.scm", 1777707);
    arrayOfObject44[7] = Lit161;
    SimpleSymbol localSimpleSymbol34 = (SimpleSymbol)new SimpleSymbol("%test-should-execute").readResolve();
    Lit62 = localSimpleSymbol34;
    arrayOfObject44[8] = PairWithPosition.make(localSimpleSymbol34, PairWithPosition.make(Lit149, LList.Empty, "testing.scm", 1781794), "testing.scm", 1781772);
    arrayOfObject44[9] = Lit165;
    arrayOfObject44[10] = Lit147;
    arrayOfObject44[11] = ((SimpleSymbol)new SimpleSymbol("test-begin").readResolve());
    arrayOfObject44[12] = Lit94;
    arrayOfSyntaxRule13[0] = new SyntaxRule(localSyntaxPattern18, "", "\021\030\004\021\030\f\021\030\024\021\030\034\b\021\030$\b\021\030,\021\0304\b\003\b\021\030<\021\030D\b\021\030LY\021\030T\t\020\b\021\030\\\b\0031\021\030T\t\020\n\b\021\030T\t\020\b\021\030d\b\003", arrayOfObject44, 0);
    Lit71 = new SyntaxRules(arrayOfObject43, arrayOfSyntaxRule13, 2);
    Lit68 = (SimpleSymbol)new SimpleSymbol("test-on-final-simple").readResolve();
    Lit67 = (SimpleSymbol)new SimpleSymbol("test-on-bad-end-name-simple").readResolve();
    Lit66 = (SimpleSymbol)new SimpleSymbol("test-on-bad-count-simple").readResolve();
    Lit65 = (SimpleSymbol)new SimpleSymbol("test-on-group-end-simple").readResolve();
    Lit64 = (SimpleSymbol)new SimpleSymbol("test-on-group-begin-simple").readResolve();
    Lit63 = (SimpleSymbol)new SimpleSymbol("%test-begin").readResolve();
    Lit61 = (SimpleSymbol)new SimpleSymbol("test-runner-create").readResolve();
    Lit59 = (SimpleSymbol)new SimpleSymbol("test-runner-simple").readResolve();
    Lit58 = (SimpleSymbol)new SimpleSymbol("test-runner-null").readResolve();
    Lit57 = (SimpleSymbol)new SimpleSymbol("%test-null-callback").readResolve();
    Lit56 = (SimpleSymbol)new SimpleSymbol("test-runner-group-path").readResolve();
    Lit55 = (SimpleSymbol)new SimpleSymbol("test-runner-reset").readResolve();
    Lit54 = (SimpleSymbol)new SimpleSymbol("test-runner-aux-value!").readResolve();
    Lit53 = (SimpleSymbol)new SimpleSymbol("test-runner-aux-value").readResolve();
    Lit50 = (SimpleSymbol)new SimpleSymbol("test-runner-on-bad-end-name!").readResolve();
    Lit49 = (SimpleSymbol)new SimpleSymbol("test-runner-on-bad-end-name").readResolve();
    Lit48 = (SimpleSymbol)new SimpleSymbol("test-runner-on-bad-count!").readResolve();
    Lit47 = (SimpleSymbol)new SimpleSymbol("test-runner-on-bad-count").readResolve();
    Lit46 = (SimpleSymbol)new SimpleSymbol("test-runner-on-final!").readResolve();
    Lit45 = (SimpleSymbol)new SimpleSymbol("test-runner-on-final").readResolve();
    Lit44 = (SimpleSymbol)new SimpleSymbol("test-runner-on-group-end!").readResolve();
    Lit43 = (SimpleSymbol)new SimpleSymbol("test-runner-on-group-end").readResolve();
    Lit42 = (SimpleSymbol)new SimpleSymbol("test-runner-on-group-begin!").readResolve();
    Lit41 = (SimpleSymbol)new SimpleSymbol("test-runner-on-group-begin").readResolve();
    Lit40 = (SimpleSymbol)new SimpleSymbol("test-runner-on-test-end!").readResolve();
    Lit39 = (SimpleSymbol)new SimpleSymbol("test-runner-on-test-end").readResolve();
    Lit38 = (SimpleSymbol)new SimpleSymbol("test-runner-on-test-begin!").readResolve();
    Lit37 = (SimpleSymbol)new SimpleSymbol("test-runner-on-test-begin").readResolve();
    Lit36 = (SimpleSymbol)new SimpleSymbol("test-runner-group-stack!").readResolve();
    Lit35 = (SimpleSymbol)new SimpleSymbol("test-runner-group-stack").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("test-runner-skip-count!").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("test-runner-skip-count").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("test-runner-xfail-count!").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("test-runner-xfail-count").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("test-runner-xpass-count!").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("test-runner-xpass-count").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("test-runner-fail-count!").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("test-runner-fail-count").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("test-runner-pass-count!").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("test-runner-pass-count").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("test-runner?").readResolve();
    Object[] arrayOfObject45 = new Object[5];
    arrayOfObject45[0] = Lit150;
    arrayOfObject45[1] = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 2834444), LList.Empty, "testing.scm", 2834444), "testing.scm", 2834441), LList.Empty, "testing.scm", 2834440);
    arrayOfObject45[2] = Lit52;
    arrayOfObject45[3] = Lit149;
    arrayOfObject45[4] = Lit89;
    Lit19 = new SyntaxTemplate("\001\001\001\001\001", "\021\030\004\021\030\fA\021\030\024\021\030\034\b\033\b\021\030$\021\030\034\t#\t\013\b\023", arrayOfObject45, 0);
    Lit18 = new SyntaxPattern("<\f\007\f\017\f\027\b\f\037\f'\b", new Object[0], 5);
    Object[] arrayOfObject46 = new Object[8];
    arrayOfObject46[0] = Lit150;
    arrayOfObject46[1] = PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 2809868), LList.Empty, "testing.scm", 2809868), "testing.scm", 2809865);
    arrayOfObject46[2] = Lit160;
    arrayOfObject46[3] = Lit52;
    arrayOfObject46[4] = Lit149;
    arrayOfObject46[5] = Lit145;
    arrayOfObject46[6] = PairWithPosition.make(Lit15, PairWithPosition.make(Lit7, LList.Empty, "testing.scm", 2818087), "testing.scm", 2818087);
    arrayOfObject46[7] = Lit89;
    Lit17 = new SyntaxTemplate("\001\001\001\001\001\001", "\021\030\004I\021\030\f\b\021\030\024\b\013©\021\030\034\021\030$\b\021\030,A\021\030,\021\0304\b\013\b#\b\021\030<\021\030$\t+\t\023\b\033", arrayOfObject46, 0);
    Lit16 = new SyntaxPattern("L\f\007\f\017\f\027\f\037\b\f'\f/\b", new Object[0], 6);
    Lit14 = (SimpleSymbol)new SimpleSymbol("fail").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("pass").readResolve();
    SimpleSymbol localSimpleSymbol35 = Lit12;
    SimpleSymbol localSimpleSymbol36 = (SimpleSymbol)new SimpleSymbol("xpass").readResolve();
    Lit9 = localSimpleSymbol36;
    Lit11 = PairWithPosition.make(localSimpleSymbol35, PairWithPosition.make(localSimpleSymbol36, LList.Empty, "testing.scm", 2220088), "testing.scm", 2220082);
    SimpleSymbol localSimpleSymbol37 = Lit7;
    SimpleSymbol localSimpleSymbol38 = (SimpleSymbol)new SimpleSymbol("source-file").readResolve();
    Lit4 = localSimpleSymbol38;
    SimpleSymbol localSimpleSymbol39 = (SimpleSymbol)new SimpleSymbol("source-line").readResolve();
    Lit5 = localSimpleSymbol39;
    SimpleSymbol localSimpleSymbol40 = (SimpleSymbol)new SimpleSymbol("source-form").readResolve();
    Lit6 = localSimpleSymbol40;
    Lit10 = PairWithPosition.make(localSimpleSymbol37, PairWithPosition.make(localSimpleSymbol38, PairWithPosition.make(localSimpleSymbol39, PairWithPosition.make(localSimpleSymbol40, LList.Empty, "testing.scm", 2072618), "testing.scm", 2072606), "testing.scm", 2072594), "testing.scm", 2072583);
    Lit8 = PairWithPosition.make(Lit14, PairWithPosition.make(Lit9, LList.Empty, "testing.scm", 1966107), "testing.scm", 1966101);
    Lit3 = (SimpleSymbol)new SimpleSymbol("xfail").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("skip").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("result-kind").readResolve();
    Lit0 = IntNum.make(0);
    $instance = new testing();
    test$Mnrunner = test.Mnrunner.class;
    testing localtesting = $instance;
    test$Mnrunner$Qu = new ModuleMethod(localtesting, 12, Lit20, 4097);
    test$Mnrunner$Mnpass$Mncount = new ModuleMethod(localtesting, 13, Lit21, 4097);
    test$Mnrunner$Mnpass$Mncount$Ex = new ModuleMethod(localtesting, 14, Lit22, 8194);
    test$Mnrunner$Mnfail$Mncount = new ModuleMethod(localtesting, 15, Lit23, 4097);
    test$Mnrunner$Mnfail$Mncount$Ex = new ModuleMethod(localtesting, 16, Lit24, 8194);
    test$Mnrunner$Mnxpass$Mncount = new ModuleMethod(localtesting, 17, Lit25, 4097);
    test$Mnrunner$Mnxpass$Mncount$Ex = new ModuleMethod(localtesting, 18, Lit26, 8194);
    test$Mnrunner$Mnxfail$Mncount = new ModuleMethod(localtesting, 19, Lit27, 4097);
    test$Mnrunner$Mnxfail$Mncount$Ex = new ModuleMethod(localtesting, 20, Lit28, 8194);
    test$Mnrunner$Mnskip$Mncount = new ModuleMethod(localtesting, 21, Lit29, 4097);
    test$Mnrunner$Mnskip$Mncount$Ex = new ModuleMethod(localtesting, 22, Lit30, 8194);
    $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist = new ModuleMethod(localtesting, 23, Lit31, 4097);
    $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist$Ex = new ModuleMethod(localtesting, 24, Lit32, 8194);
    $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist = new ModuleMethod(localtesting, 25, Lit33, 4097);
    $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist$Ex = new ModuleMethod(localtesting, 26, Lit34, 8194);
    test$Mnrunner$Mngroup$Mnstack = new ModuleMethod(localtesting, 27, Lit35, 4097);
    test$Mnrunner$Mngroup$Mnstack$Ex = new ModuleMethod(localtesting, 28, Lit36, 8194);
    test$Mnrunner$Mnon$Mntest$Mnbegin = new ModuleMethod(localtesting, 29, Lit37, 4097);
    test$Mnrunner$Mnon$Mntest$Mnbegin$Ex = new ModuleMethod(localtesting, 30, Lit38, 8194);
    test$Mnrunner$Mnon$Mntest$Mnend = new ModuleMethod(localtesting, 31, Lit39, 4097);
    test$Mnrunner$Mnon$Mntest$Mnend$Ex = new ModuleMethod(localtesting, 32, Lit40, 8194);
    test$Mnrunner$Mnon$Mngroup$Mnbegin = new ModuleMethod(localtesting, 33, Lit41, 4097);
    test$Mnrunner$Mnon$Mngroup$Mnbegin$Ex = new ModuleMethod(localtesting, 34, Lit42, 8194);
    test$Mnrunner$Mnon$Mngroup$Mnend = new ModuleMethod(localtesting, 35, Lit43, 4097);
    test$Mnrunner$Mnon$Mngroup$Mnend$Ex = new ModuleMethod(localtesting, 36, Lit44, 8194);
    test$Mnrunner$Mnon$Mnfinal = new ModuleMethod(localtesting, 37, Lit45, 4097);
    test$Mnrunner$Mnon$Mnfinal$Ex = new ModuleMethod(localtesting, 38, Lit46, 8194);
    test$Mnrunner$Mnon$Mnbad$Mncount = new ModuleMethod(localtesting, 39, Lit47, 4097);
    test$Mnrunner$Mnon$Mnbad$Mncount$Ex = new ModuleMethod(localtesting, 40, Lit48, 8194);
    test$Mnrunner$Mnon$Mnbad$Mnend$Mnname = new ModuleMethod(localtesting, 41, Lit49, 4097);
    test$Mnrunner$Mnon$Mnbad$Mnend$Mnname$Ex = new ModuleMethod(localtesting, 42, Lit50, 8194);
    test$Mnresult$Mnalist = new ModuleMethod(localtesting, 43, Lit51, 4097);
    test$Mnresult$Mnalist$Ex = new ModuleMethod(localtesting, 44, Lit52, 8194);
    test$Mnrunner$Mnaux$Mnvalue = new ModuleMethod(localtesting, 45, Lit53, 4097);
    test$Mnrunner$Mnaux$Mnvalue$Ex = new ModuleMethod(localtesting, 46, Lit54, 8194);
    test$Mnrunner$Mnreset = new ModuleMethod(localtesting, 47, Lit55, 4097);
    test$Mnrunner$Mngroup$Mnpath = new ModuleMethod(localtesting, 48, Lit56, 4097);
    $Pctest$Mnnull$Mncallback = new ModuleMethod(localtesting, 49, Lit57, 4097);
    ModuleMethod localModuleMethod1 = new ModuleMethod(localtesting, 50, null, 12291);
    localModuleMethod1.setProperty("source-location", "testing.scm:182");
    lambda$Fn1 = localModuleMethod1;
    ModuleMethod localModuleMethod2 = new ModuleMethod(localtesting, 51, null, 12291);
    localModuleMethod2.setProperty("source-location", "testing.scm:187");
    lambda$Fn2 = localModuleMethod2;
    ModuleMethod localModuleMethod3 = new ModuleMethod(localtesting, 52, null, 12291);
    localModuleMethod3.setProperty("source-location", "testing.scm:188");
    lambda$Fn3 = localModuleMethod3;
    test$Mnrunner$Mnnull = new ModuleMethod(localtesting, 53, Lit58, 0);
    test$Mnrunner$Mnsimple = new ModuleMethod(localtesting, 54, Lit59, 0);
    test$Mnrunner$Mnget = new ModuleMethod(localtesting, 55, Lit60, 0);
    test$Mnrunner$Mncreate = new ModuleMethod(localtesting, 56, Lit61, 0);
    $Prvt$$Pctest$Mnshould$Mnexecute = new ModuleMethod(localtesting, 57, Lit62, 4097);
    $Pctest$Mnbegin = new ModuleMethod(localtesting, 58, Lit63, 8194);
    test$Mnon$Mngroup$Mnbegin$Mnsimple = new ModuleMethod(localtesting, 59, Lit64, 12291);
    test$Mnon$Mngroup$Mnend$Mnsimple = new ModuleMethod(localtesting, 60, Lit65, 4097);
    test$Mnon$Mnbad$Mncount$Mnsimple = new ModuleMethod(localtesting, 61, Lit66, 12291);
    test$Mnon$Mnbad$Mnend$Mnname$Mnsimple = new ModuleMethod(localtesting, 62, Lit67, 12291);
    test$Mnon$Mnfinal$Mnsimple = new ModuleMethod(localtesting, 63, Lit68, 4097);
    $Prvt$$Pctest$Mnend = new ModuleMethod(localtesting, 64, Lit69, 8194);
    $Prvt$test$Mngroup = Macro.make(Lit70, Lit71, $instance);
    test$Mngroup$Mnwith$Mncleanup = Macro.make(Lit72, Lit73, $instance);
    test$Mnon$Mntest$Mnbegin$Mnsimple = new ModuleMethod(localtesting, 65, Lit74, 4097);
    test$Mnresult$Mnref = Macro.make(Lit75, Lit76, $instance);
    test$Mnon$Mntest$Mnend$Mnsimple = new ModuleMethod(localtesting, 66, Lit77, 4097);
    test$Mnresult$Mnset$Ex = new ModuleMethod(localtesting, 67, Lit78, 12291);
    test$Mnresult$Mnclear = new ModuleMethod(localtesting, 68, Lit79, 4097);
    test$Mnresult$Mnremove = new ModuleMethod(localtesting, 69, Lit80, 8194);
    test$Mnresult$Mnkind = new ModuleMethod(localtesting, 70, Lit81, -4096);
    test$Mnpassed$Qu = new ModuleMethod(localtesting, 71, Lit82, -4096);
    $Prvt$$Pctest$Mnreport$Mnresult = new ModuleMethod(localtesting, 72, Lit83, 0);
    $Prvt$$Pctest$Mnevaluate$Mnwith$Mncatch = Macro.make(Lit84, Lit85, $instance);
    $Prvt$$Pctest$Mnon$Mntest$Mnbegin = new ModuleMethod(localtesting, 73, Lit86, 4097);
    $Prvt$$Pctest$Mnon$Mntest$Mnend = new ModuleMethod(localtesting, 74, Lit87, 8194);
    test$Mnrunner$Mntest$Mnname = new ModuleMethod(localtesting, 75, Lit88, 4097);
    $Prvt$$Pctest$Mncomp2body = Macro.make(Lit89, Lit90, $instance);
    $Prvt$$Pctest$Mnapproximimate$Eq = new ModuleMethod(localtesting, 76, Lit91, 4097);
    $Prvt$$Pctest$Mncomp1body = Macro.make(Lit92, Lit93, $instance);
    SimpleSymbol localSimpleSymbol41 = Lit94;
    ModuleMethod localModuleMethod4 = new ModuleMethod(localtesting, 77, null, 4097);
    localModuleMethod4.setProperty("source-location", "testing.scm:660");
    test$Mnend = Macro.make(localSimpleSymbol41, localModuleMethod4, $instance);
    SimpleSymbol localSimpleSymbol42 = Lit99;
    ModuleMethod localModuleMethod5 = new ModuleMethod(localtesting, 78, null, 4097);
    localModuleMethod5.setProperty("source-location", "testing.scm:669");
    test$Mnassert = Macro.make(localSimpleSymbol42, localModuleMethod5, $instance);
    SimpleSymbol localSimpleSymbol43 = Lit104;
    ModuleMethod localModuleMethod6 = new ModuleMethod(localtesting, 79, null, 4097);
    localModuleMethod6.setProperty("source-location", "testing.scm:696");
    test$Mneqv = Macro.make(localSimpleSymbol43, localModuleMethod6, $instance);
    SimpleSymbol localSimpleSymbol44 = Lit106;
    ModuleMethod localModuleMethod7 = new ModuleMethod(localtesting, 80, null, 4097);
    localModuleMethod7.setProperty("source-location", "testing.scm:698");
    test$Mneq = Macro.make(localSimpleSymbol44, localModuleMethod7, $instance);
    SimpleSymbol localSimpleSymbol45 = Lit108;
    ModuleMethod localModuleMethod8 = new ModuleMethod(localtesting, 81, null, 4097);
    localModuleMethod8.setProperty("source-location", "testing.scm:700");
    test$Mnequal = Macro.make(localSimpleSymbol45, localModuleMethod8, $instance);
    SimpleSymbol localSimpleSymbol46 = Lit110;
    ModuleMethod localModuleMethod9 = new ModuleMethod(localtesting, 82, null, 4097);
    localModuleMethod9.setProperty("source-location", "testing.scm:702");
    test$Mnapproximate = Macro.make(localSimpleSymbol46, localModuleMethod9, $instance);
    $Prvt$$Pctest$Mnerror = Macro.make(Lit115, Lit116, $instance);
    SimpleSymbol localSimpleSymbol47 = Lit117;
    ModuleMethod localModuleMethod10 = new ModuleMethod(localtesting, 83, null, 4097);
    localModuleMethod10.setProperty("source-location", "testing.scm:843");
    test$Mnerror = Macro.make(localSimpleSymbol47, localModuleMethod10, $instance);
    test$Mnapply = new ModuleMethod(localtesting, 84, Lit124, -4095);
    test$Mnwith$Mnrunner = Macro.make(Lit125, Lit126, $instance);
    $Prvt$$Pctest$Mnmatch$Mnnth = new ModuleMethod(localtesting, 85, Lit127, 8194);
    test$Mnmatch$Mnnth = Macro.make(Lit128, Lit129, $instance);
    $Prvt$$Pctest$Mnmatch$Mnall = new ModuleMethod(localtesting, 86, Lit130, -4096);
    test$Mnmatch$Mnall = Macro.make(Lit131, Lit132, $instance);
    $Prvt$$Pctest$Mnmatch$Mnany = new ModuleMethod(localtesting, 87, Lit133, -4096);
    test$Mnmatch$Mnany = Macro.make(Lit134, Lit135, $instance);
    $Prvt$$Pctest$Mnas$Mnspecifier = new ModuleMethod(localtesting, 88, Lit136, 4097);
    test$Mnskip = Macro.make(Lit137, Lit138, $instance);
    test$Mnexpect$Mnfail = Macro.make(Lit139, Lit140, $instance);
    test$Mnmatch$Mnname = new ModuleMethod(localtesting, 89, Lit141, 4097);
    test$Mnread$Mneval$Mnstring = new ModuleMethod(localtesting, 90, Lit142, 4097);
    $instance.run();
  }
  
  public testing()
  {
    ModuleInfo.register(this);
  }
  
  /* Error */
  public static Object isTestPassed$V(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: invokestatic 677	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: astore_1
    //   6: aload_1
    //   7: invokestatic 1886	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   10: ifeq +59 -> 69
    //   13: getstatic 296	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   16: aload_1
    //   17: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: astore_2
    //   21: getstatic 730	gnu/kawa/slib/testing:Lit1	Lgnu/mapping/SimpleSymbol;
    //   24: astore_3
    //   25: aload_2
    //   26: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   29: astore 5
    //   31: aload_3
    //   32: aload 5
    //   34: invokestatic 645	gnu/kawa/slib/testing:testResultAlist	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   37: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: astore 6
    //   42: aload 6
    //   44: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   47: if_acmpeq +29 -> 76
    //   50: getstatic 311	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   53: aload 6
    //   55: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: astore 7
    //   60: aload 7
    //   62: getstatic 1625	gnu/kawa/slib/testing:Lit11	Lgnu/lists/PairWithPosition;
    //   65: invokestatic 1889	kawa/lib/lists:memq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   68: areturn
    //   69: invokestatic 513	gnu/kawa/slib/testing:testRunnerGet	()Ljava/lang/Object;
    //   72: astore_2
    //   73: goto -52 -> 21
    //   76: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   79: astore 7
    //   81: goto -21 -> 60
    //   84: astore 4
    //   86: new 427	gnu/mapping/WrongType
    //   89: dup
    //   90: aload 4
    //   92: ldc_w 666
    //   95: iconst_0
    //   96: aload_2
    //   97: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramArrayOfObject	Object[]
    //   5	12	1	localLList	LList
    //   20	77	2	localObject1	Object
    //   24	8	3	localSimpleSymbol	SimpleSymbol
    //   84	7	4	localClassCastException	ClassCastException
    //   29	4	5	localMnrunner	test.Mnrunner
    //   40	14	6	localObject2	Object
    //   58	22	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   25	31	84	java/lang/ClassCastException
  }
  
  public static boolean isTestRunner(Object paramObject)
  {
    return paramObject instanceof test.Mnrunner;
  }
  
  static Boolean lambda1(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return Boolean.FALSE;
  }
  
  static Object lambda16(Object paramObject)
  {
    Pair localPair = LList.list2(paramObject, LList.list2(Lit15, $PcTestSourceLine2(paramObject)));
    Object[] arrayOfObject = SyntaxPattern.allocVars(3, null);
    if (Lit95.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return Lit96.execute(arrayOfObject, localTemplateScope2);
    }
    if (Lit97.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      return Lit98.execute(arrayOfObject, localTemplateScope1);
    }
    return syntax_case.error("syntax-case", localPair);
  }
  
  static Object lambda17(Object paramObject)
  {
    Pair localPair = LList.list2(paramObject, LList.list2(Lit15, $PcTestSourceLine2(paramObject)));
    Object[] arrayOfObject = SyntaxPattern.allocVars(4, null);
    if (Lit100.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return Lit101.execute(arrayOfObject, localTemplateScope2);
    }
    if (Lit102.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      return Lit103.execute(arrayOfObject, localTemplateScope1);
    }
    return syntax_case.error("syntax-case", localPair);
  }
  
  static Object lambda18(Object paramObject)
  {
    TemplateScope localTemplateScope = TemplateScope.make();
    return $PcTestComp2(Lit105.execute(null, localTemplateScope), paramObject);
  }
  
  static Object lambda19(Object paramObject)
  {
    TemplateScope localTemplateScope = TemplateScope.make();
    return $PcTestComp2(Lit107.execute(null, localTemplateScope), paramObject);
  }
  
  static Boolean lambda2(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return Boolean.FALSE;
  }
  
  static Object lambda20(Object paramObject)
  {
    TemplateScope localTemplateScope = TemplateScope.make();
    return $PcTestComp2(Lit109.execute(null, localTemplateScope), paramObject);
  }
  
  static Object lambda21(Object paramObject)
  {
    Pair localPair = LList.list2(paramObject, LList.list2(Lit15, $PcTestSourceLine2(paramObject)));
    Object[] arrayOfObject = SyntaxPattern.allocVars(6, null);
    if (Lit111.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return Lit112.execute(arrayOfObject, localTemplateScope2);
    }
    if (Lit113.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      return Lit114.execute(arrayOfObject, localTemplateScope1);
    }
    return syntax_case.error("syntax-case", localPair);
  }
  
  static Object lambda22(Object paramObject)
  {
    Pair localPair = LList.list2(paramObject, LList.list2(Lit15, $PcTestSourceLine2(paramObject)));
    Object[] arrayOfObject = SyntaxPattern.allocVars(5, null);
    if (Lit118.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope3 = TemplateScope.make();
      return Lit119.execute(arrayOfObject, localTemplateScope3);
    }
    if (Lit120.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return Lit121.execute(arrayOfObject, localTemplateScope2);
    }
    if (Lit122.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      return Lit123.execute(arrayOfObject, localTemplateScope1);
    }
    return syntax_case.error("syntax-case", localPair);
  }
  
  static Boolean lambda3(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return Boolean.FALSE;
  }
  
  public static Object testApply$V(Object paramObject, Object[] paramArrayOfObject)
  {
    localframe1 = new frame1();
    localframe1.first = paramObject;
    localframe1.rest = LList.makeList(paramArrayOfObject, 0);
    if (isTestRunner(localframe1.first))
    {
      localframe1.saved$Mnrunner$1 = ((Procedure)test$Mnrunner$Mncurrent).apply0();
      return misc.dynamicWind(localframe1.lambda$Fn5, localframe1.lambda$Fn6, localframe1.lambda$Fn7);
    }
    localObject1 = ((Procedure)test$Mnrunner$Mncurrent).apply0();
    if (localObject1 != Boolean.FALSE) {
      for (;;)
      {
        try
        {
          test.Mnrunner localMnrunner2 = (test.Mnrunner)localObject1;
          localObject3 = $PcTestRunnerRunList(localMnrunner2);
          if (!lists.isNull(localframe1.rest)) {}
        }
        catch (ClassCastException localClassCastException2)
        {
          try
          {
            test.Mnrunner localMnrunner5;
            LList localLList;
            test.Mnrunner localMnrunner3;
            Pair localPair;
            test.Mnrunner localMnrunner4;
            ApplyToArgs localApplyToArgs;
            test.Mnrunner localMnrunner1 = (test.Mnrunner)localObject2;
            return localApplyToArgs.apply2(testRunnerOnFinal(localMnrunner1), localframe1.r);
          }
          catch (ClassCastException localClassCastException1)
          {
            Object localObject3;
            Object localObject2;
            throw new WrongType(localClassCastException1, "test-runner-on-final", 0, localObject2);
          }
          localClassCastException2 = localClassCastException2;
          throw new WrongType(localClassCastException2, "%test-runner-run-list", 0, localObject1);
        }
        try
        {
          localMnrunner5 = (test.Mnrunner)localObject1;
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "%test-runner-run-list!", 0, localObject1);
        }
        try
        {
          localLList = (LList)localObject3;
          $PcTestRunnerRunList$Ex(localMnrunner5, lists.reverse$Ex(localLList));
          return Scheme.applyToArgs.apply1(localframe1.first);
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "reverse!", 1, localObject3);
        }
        try
        {
          localMnrunner3 = (test.Mnrunner)localObject1;
          if (localObject3 == Boolean.TRUE)
          {
            localPair = LList.list1(localframe1.first);
            $PcTestRunnerRunList$Ex(localMnrunner3, localPair);
            Scheme.apply.apply2(test$Mnapply, localframe1.rest);
          }
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "%test-runner-run-list!", 0, localObject1);
        }
        try
        {
          localMnrunner4 = (test.Mnrunner)localObject1;
          $PcTestRunnerRunList$Ex(localMnrunner4, localObject3);
          return Values.empty;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "%test-runner-run-list!", 0, localObject1);
        }
        localPair = lists.cons(localframe1.first, localObject3);
      }
    }
    localframe1.r = testRunnerCreate();
    localframe1.saved$Mnrunner = ((Procedure)test$Mnrunner$Mncurrent).apply0();
    misc.dynamicWind(localframe1.lambda$Fn8, localframe1.lambda$Fn9, localframe1.lambda$Fn10);
    localApplyToArgs = Scheme.applyToArgs;
    localObject2 = localframe1.r;
  }
  
  public static Procedure testMatchName(Object paramObject)
  {
    frame5 localframe5 = new frame5();
    localframe5.name = paramObject;
    return localframe5.lambda$Fn14;
  }
  
  public static void testOnBadCountSimple(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    $PcTestOnBadCountWrite(paramObject1, paramObject2, paramObject3, ports.current$Mnoutput$Mnport.apply0());
    try
    {
      test.Mnrunner localMnrunner = (test.Mnrunner)paramObject1;
      Object localObject = testRunnerAuxValue(localMnrunner);
      if (ports.isOutputPort(localObject)) {
        $PcTestOnBadCountWrite(paramObject1, paramObject2, paramObject3, localObject);
      }
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "test-runner-aux-value", 0, paramObject1);
    }
  }
  
  public static Object testOnBadEndNameSimple(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = $PcTestFormatLine(paramObject1);
    arrayOfObject[1] = "test-end ";
    arrayOfObject[2] = paramObject2;
    arrayOfObject[3] = " does not match test-begin ";
    arrayOfObject[4] = paramObject3;
    return misc.error$V(strings.stringAppend(arrayOfObject), new Object[0]);
  }
  
  public static void testOnFinalSimple(Object paramObject)
  {
    $PcTestFinalReportSimple(paramObject, ports.current$Mnoutput$Mnport.apply0());
    try
    {
      test.Mnrunner localMnrunner = (test.Mnrunner)paramObject;
      Object localObject = testRunnerAuxValue(localMnrunner);
      if (ports.isOutputPort(localObject)) {
        $PcTestFinalReportSimple(paramObject, localObject);
      }
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "test-runner-aux-value", 0, paramObject);
    }
  }
  
  public static Boolean testOnGroupBeginSimple(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    for (;;)
    {
      try
      {
        test.Mnrunner localMnrunner1 = (test.Mnrunner)paramObject1;
        if (lists.isNull(testRunnerGroupStack(localMnrunner1)))
        {
          ports.display("%%%% Starting test ");
          ports.display(paramObject2);
          if (!strings.isString(Boolean.TRUE)) {
            continue;
          }
          localObject2 = Boolean.TRUE;
        }
      }
      catch (ClassCastException localClassCastException1)
      {
        Path localPath;
        OutPort localOutPort;
        test.Mnrunner localMnrunner3;
        test.Mnrunner localMnrunner2;
        Object localObject1;
        throw new WrongType(localClassCastException1, "test-runner-group-stack", 0, paramObject1);
      }
      try
      {
        localPath = Path.valueOf(localObject2);
        localOutPort = ports.openOutputFile(localPath);
        ports.display("%%%% Starting test ", localOutPort);
        ports.display(paramObject2, localOutPort);
        ports.newline(localOutPort);
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "open-output-file", 1, localObject2);
      }
      try
      {
        localMnrunner3 = (test.Mnrunner)paramObject1;
        testRunnerAuxValue$Ex(localMnrunner3, localOutPort);
        ports.display("  (Writing full log to \"");
        ports.display(localObject2);
        ports.display("\")");
        ports.newline();
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "test-runner-aux-value!", 0, paramObject1);
      }
      try
      {
        localMnrunner2 = (test.Mnrunner)paramObject1;
        localObject1 = testRunnerAuxValue(localMnrunner2);
        if (ports.isOutputPort(localObject1))
        {
          ports.display("Group begin: ", localObject1);
          ports.display(paramObject2, localObject1);
          ports.newline(localObject1);
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "test-runner-aux-value", 0, paramObject1);
      }
      localObject2 = strings.stringAppend(new Object[] { paramObject2, ".log" });
    }
  }
  
  /* Error */
  public static Boolean testOnGroupEndSimple(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 1975	gnu/kawa/slib/testing:testRunnerAuxValue	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   9: astore_3
    //   10: aload_3
    //   11: invokestatic 1978	kawa/lib/ports:isOutputPort	(Ljava/lang/Object;)Z
    //   14: ifeq +39 -> 53
    //   17: ldc_w 2019
    //   20: aload_3
    //   21: invokestatic 600	kawa/lib/ports:display	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   24: getstatic 296	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   27: astore 4
    //   29: aload_0
    //   30: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   33: astore 6
    //   35: aload 4
    //   37: aload 6
    //   39: invokestatic 422	gnu/kawa/slib/testing:testRunnerGroupStack	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   42: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: aload_3
    //   46: invokestatic 600	kawa/lib/ports:display	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   49: aload_3
    //   50: invokestatic 604	kawa/lib/ports:newline	(Ljava/lang/Object;)V
    //   53: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   56: areturn
    //   57: astore_1
    //   58: new 427	gnu/mapping/WrongType
    //   61: dup
    //   62: aload_1
    //   63: ldc_w 1529
    //   66: iconst_0
    //   67: aload_0
    //   68: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   71: athrow
    //   72: astore 5
    //   74: new 427	gnu/mapping/WrongType
    //   77: dup
    //   78: aload 5
    //   80: ldc_w 454
    //   83: iconst_0
    //   84: aload_0
    //   85: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramObject	Object
    //   57	6	1	localClassCastException1	ClassCastException
    //   4	2	2	localMnrunner1	test.Mnrunner
    //   9	41	3	localObject	Object
    //   27	9	4	localGenericProc	GenericProc
    //   72	7	5	localClassCastException2	ClassCastException
    //   33	5	6	localMnrunner2	test.Mnrunner
    // Exception table:
    //   from	to	target	type
    //   0	5	57	java/lang/ClassCastException
    //   29	35	72	java/lang/ClassCastException
  }
  
  static Object testOnTestBeginSimple(Object paramObject)
  {
    try
    {
      test.Mnrunner localMnrunner1 = (test.Mnrunner)paramObject;
      localObject1 = testRunnerAuxValue(localMnrunner1);
      if (!ports.isOutputPort(localObject1)) {}
    }
    catch (ClassCastException localClassCastException1)
    {
      Object localObject1;
      test.Mnrunner localMnrunner2;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      throw new WrongType(localClassCastException1, "test-runner-aux-value", 0, paramObject);
    }
    try
    {
      localMnrunner2 = (test.Mnrunner)paramObject;
      localObject2 = testResultAlist(localMnrunner2);
      localObject3 = lists.assq(Lit4, localObject2);
      localObject4 = lists.assq(Lit5, localObject2);
      localObject5 = lists.assq(Lit6, localObject2);
      localObject6 = lists.assq(Lit7, localObject2);
      ports.display("Test begin:", localObject1);
      ports.newline(localObject1);
      if (localObject6 != Boolean.FALSE) {
        $PcTestWriteResult1(localObject6, localObject1);
      }
      if (localObject3 != Boolean.FALSE) {
        $PcTestWriteResult1(localObject3, localObject1);
      }
      if (localObject4 != Boolean.FALSE) {
        $PcTestWriteResult1(localObject4, localObject1);
      }
      if (localObject3 != Boolean.FALSE) {
        return $PcTestWriteResult1(localObject5, localObject1);
      }
      return Values.empty;
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "test-result-alist", 0, paramObject);
    }
    return Values.empty;
  }
  
  public static Object testOnTestEndSimple(Object paramObject)
  {
    for (;;)
    {
      try
      {
        test.Mnrunner localMnrunner1 = (test.Mnrunner)paramObject;
        localObject1 = testRunnerAuxValue(localMnrunner1);
        localSimpleSymbol = Lit1;
      }
      catch (ClassCastException localClassCastException1)
      {
        Object localObject1;
        SimpleSymbol localSimpleSymbol;
        test.Mnrunner localMnrunner2;
        Object localObject2;
        Object localObject3;
        test.Mnrunner localMnrunner4;
        Object localObject6;
        Object localObject7;
        Object localObject8;
        Object localObject9;
        String str;
        test.Mnrunner localMnrunner3;
        Object localObject4;
        throw new WrongType(localClassCastException1, "test-runner-aux-value", 0, paramObject);
      }
      try
      {
        localMnrunner2 = (test.Mnrunner)paramObject;
        localObject2 = lists.assq(localSimpleSymbol, testResultAlist(localMnrunner2));
        if (localObject2 != Boolean.FALSE)
        {
          localObject3 = lists.cdr.apply1(localObject2);
          if (lists.memq(localObject3, Lit8) == Boolean.FALSE) {}
        }
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "test-result-alist", 0, paramObject);
      }
      try
      {
        localMnrunner4 = (test.Mnrunner)paramObject;
        localObject6 = testResultAlist(localMnrunner4);
        localObject7 = lists.assq(Lit4, localObject6);
        localObject8 = lists.assq(Lit5, localObject6);
        localObject9 = lists.assq(Lit7, localObject6);
        if ((localObject7 != Boolean.FALSE) || (localObject8 != Boolean.FALSE))
        {
          if (localObject7 != Boolean.FALSE) {
            ports.display(lists.cdr.apply1(localObject7));
          }
          ports.display(":");
          if (localObject8 != Boolean.FALSE) {
            ports.display(lists.cdr.apply1(localObject8));
          }
          ports.display(": ");
        }
        if (localObject3 == Lit9)
        {
          str = "XPASS";
          ports.display(str);
          if (localObject9 != Boolean.FALSE)
          {
            ports.display(" ");
            ports.display(lists.cdr.apply1(localObject9));
          }
          ports.newline();
          if (!ports.isOutputPort(localObject1)) {
            continue;
          }
          ports.display("Test end:", localObject1);
          ports.newline(localObject1);
        }
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "test-result-alist", 0, paramObject);
      }
      try
      {
        localMnrunner3 = (test.Mnrunner)paramObject;
        localObject4 = testResultAlist(localMnrunner3);
        if (lists.isPair(localObject4))
        {
          Object localObject5 = lists.car.apply1(localObject4);
          if (lists.memq(lists.car.apply1(localObject5), Lit10) == Boolean.FALSE) {
            $PcTestWriteResult1(localObject5, localObject1);
          }
          localObject4 = lists.cdr.apply1(localObject4);
          continue;
          localObject3 = Boolean.FALSE;
          continue;
          str = "FAIL";
        }
        else
        {
          return Values.empty;
        }
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "test-result-alist", 0, paramObject);
      }
    }
    return Values.empty;
  }
  
  public static Object testReadEvalString(Object paramObject)
  {
    try
    {
      CharSequence localCharSequence = (CharSequence)paramObject;
      InPort localInPort = ports.openInputString(localCharSequence);
      Object localObject = ports.read(localInPort);
      if (ports.isEofObject(readchar.readChar.apply1(localInPort))) {
        return Eval.eval.apply1(localObject);
      }
      return misc.error$V("(not at eof)", new Object[0]);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "open-input-string", 1, paramObject);
    }
  }
  
  public static Object testResultAlist(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.result$Mnalist;
  }
  
  public static void testResultAlist$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.result$Mnalist = paramObject;
  }
  
  public static void testResultClear(Object paramObject)
  {
    try
    {
      test.Mnrunner localMnrunner = (test.Mnrunner)paramObject;
      testResultAlist$Ex(localMnrunner, LList.Empty);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "test-result-alist!", 0, paramObject);
    }
  }
  
  public static Object testResultKind$V(Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    Object localObject1;
    if (lists.isPair(localLList)) {
      localObject1 = lists.car.apply1(localLList);
    }
    for (;;)
    {
      SimpleSymbol localSimpleSymbol = Lit1;
      try
      {
        test.Mnrunner localMnrunner = (test.Mnrunner)localObject1;
        Object localObject2 = lists.assq(localSimpleSymbol, testResultAlist(localMnrunner));
        if (localObject2 != Boolean.FALSE)
        {
          return lists.cdr.apply1(localObject2);
          localObject1 = ((Procedure)test$Mnrunner$Mncurrent).apply0();
          continue;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "test-result-alist", 0, localObject1);
      }
    }
  }
  
  /* Error */
  public static void testResultRemove(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: new 2070	gnu/kawa/slib/testing$frame
    //   3: dup
    //   4: invokespecial 2071	gnu/kawa/slib/testing$frame:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   12: astore 4
    //   14: aload 4
    //   16: invokestatic 645	gnu/kawa/slib/testing:testResultAlist	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   19: astore 5
    //   21: aload_2
    //   22: aload_1
    //   23: aload 5
    //   25: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: putfield 2073	gnu/kawa/slib/testing$frame:p	Ljava/lang/Object;
    //   31: aload_2
    //   32: getfield 2073	gnu/kawa/slib/testing$frame:p	Ljava/lang/Object;
    //   35: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   38: if_acmpeq +20 -> 58
    //   41: aload_0
    //   42: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   45: astore 7
    //   47: aload 7
    //   49: aload_2
    //   50: aload 5
    //   52: invokevirtual 2076	gnu/kawa/slib/testing$frame:lambda4loop	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: invokestatic 519	gnu/kawa/slib/testing:testResultAlist$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   58: return
    //   59: astore_3
    //   60: new 427	gnu/mapping/WrongType
    //   63: dup
    //   64: aload_3
    //   65: ldc_w 666
    //   68: iconst_0
    //   69: aload_0
    //   70: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    //   74: astore 6
    //   76: new 427	gnu/mapping/WrongType
    //   79: dup
    //   80: aload 6
    //   82: ldc_w 576
    //   85: iconst_0
    //   86: aload_0
    //   87: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramObject1	Object
    //   0	91	1	paramObject2	Object
    //   7	43	2	localframe	frame
    //   59	6	3	localClassCastException1	ClassCastException
    //   12	3	4	localMnrunner1	test.Mnrunner
    //   19	32	5	localObject	Object
    //   74	7	6	localClassCastException2	ClassCastException
    //   45	3	7	localMnrunner2	test.Mnrunner
    // Exception table:
    //   from	to	target	type
    //   8	14	59	java/lang/ClassCastException
    //   41	47	74	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object testResultSet$Ex(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   4: astore 4
    //   6: aload 4
    //   8: invokestatic 645	gnu/kawa/slib/testing:testResultAlist	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   11: astore 5
    //   13: aload_1
    //   14: aload 5
    //   16: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   19: astore 6
    //   21: aload 6
    //   23: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   26: if_acmpeq +20 -> 46
    //   29: aload 6
    //   31: checkcast 1214	gnu/lists/Pair
    //   34: astore 10
    //   36: aload 10
    //   38: aload_2
    //   39: invokestatic 2080	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   42: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   45: areturn
    //   46: aload_0
    //   47: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   50: astore 8
    //   52: aload 8
    //   54: aload_1
    //   55: aload_2
    //   56: invokestatic 397	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   59: aload 5
    //   61: invokestatic 397	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   64: invokestatic 519	gnu/kawa/slib/testing:testResultAlist$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   67: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   70: areturn
    //   71: astore_3
    //   72: new 427	gnu/mapping/WrongType
    //   75: dup
    //   76: aload_3
    //   77: ldc_w 666
    //   80: iconst_0
    //   81: aload_0
    //   82: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   85: athrow
    //   86: astore 9
    //   88: new 427	gnu/mapping/WrongType
    //   91: dup
    //   92: aload 9
    //   94: ldc_w 2082
    //   97: iconst_1
    //   98: aload 6
    //   100: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   103: athrow
    //   104: astore 7
    //   106: new 427	gnu/mapping/WrongType
    //   109: dup
    //   110: aload 7
    //   112: ldc_w 576
    //   115: iconst_0
    //   116: aload_0
    //   117: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramObject1	Object
    //   0	121	1	paramObject2	Object
    //   0	121	2	paramObject3	Object
    //   71	6	3	localClassCastException1	ClassCastException
    //   4	3	4	localMnrunner1	test.Mnrunner
    //   11	49	5	localObject1	Object
    //   19	80	6	localObject2	Object
    //   104	7	7	localClassCastException2	ClassCastException
    //   50	3	8	localMnrunner2	test.Mnrunner
    //   86	7	9	localClassCastException3	ClassCastException
    //   34	3	10	localPair	Pair
    // Exception table:
    //   from	to	target	type
    //   0	6	71	java/lang/ClassCastException
    //   29	36	86	java/lang/ClassCastException
    //   46	52	104	java/lang/ClassCastException
  }
  
  public static Object testRunnerAuxValue(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.aux$Mnvalue;
  }
  
  public static void testRunnerAuxValue$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.aux$Mnvalue = paramObject;
  }
  
  public static Object testRunnerCreate()
  {
    return Scheme.applyToArgs.apply1(((Procedure)test$Mnrunner$Mnfactory).apply0());
  }
  
  public static Object testRunnerFailCount(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.fail$Mncount;
  }
  
  public static void testRunnerFailCount$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.fail$Mncount = paramObject;
  }
  
  public static Object testRunnerGet()
  {
    Object localObject = ((Procedure)test$Mnrunner$Mncurrent).apply0();
    if (localObject == Boolean.FALSE) {
      misc.error$V("test-runner not initialized - test-begin missing?", new Object[0]);
    }
    return localObject;
  }
  
  /* Error */
  public static LList testRunnerGroupPath(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 422	gnu/kawa/slib/testing:testRunnerGroupStack	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   9: astore_3
    //   10: aload_3
    //   11: checkcast 463	gnu/lists/LList
    //   14: astore 5
    //   16: aload 5
    //   18: invokestatic 2097	kawa/lib/lists:reverse	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   21: areturn
    //   22: astore_1
    //   23: new 427	gnu/mapping/WrongType
    //   26: dup
    //   27: aload_1
    //   28: ldc_w 454
    //   31: iconst_0
    //   32: aload_0
    //   33: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   36: athrow
    //   37: astore 4
    //   39: new 427	gnu/mapping/WrongType
    //   42: dup
    //   43: aload 4
    //   45: ldc_w 2098
    //   48: iconst_1
    //   49: aload_3
    //   50: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramObject	Object
    //   22	6	1	localClassCastException1	ClassCastException
    //   4	2	2	localMnrunner	test.Mnrunner
    //   9	41	3	localObject	Object
    //   37	7	4	localClassCastException2	ClassCastException
    //   14	3	5	localLList	LList
    // Exception table:
    //   from	to	target	type
    //   0	5	22	java/lang/ClassCastException
    //   10	16	37	java/lang/ClassCastException
  }
  
  public static Object testRunnerGroupStack(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.group$Mnstack;
  }
  
  public static void testRunnerGroupStack$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.group$Mnstack = paramObject;
  }
  
  public static test.Mnrunner testRunnerNull()
  {
    test.Mnrunner localMnrunner = $PcTestRunnerAlloc();
    testRunnerReset(localMnrunner);
    testRunnerOnGroupBegin$Ex(localMnrunner, lambda$Fn1);
    testRunnerOnGroupEnd$Ex(localMnrunner, $Pctest$Mnnull$Mncallback);
    testRunnerOnFinal$Ex(localMnrunner, $Pctest$Mnnull$Mncallback);
    testRunnerOnTestBegin$Ex(localMnrunner, $Pctest$Mnnull$Mncallback);
    testRunnerOnTestEnd$Ex(localMnrunner, $Pctest$Mnnull$Mncallback);
    testRunnerOnBadCount$Ex(localMnrunner, lambda$Fn2);
    testRunnerOnBadEndName$Ex(localMnrunner, lambda$Fn3);
    return localMnrunner;
  }
  
  public static Object testRunnerOnBadCount(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.on$Mnbad$Mncount;
  }
  
  public static void testRunnerOnBadCount$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.on$Mnbad$Mncount = paramObject;
  }
  
  public static Object testRunnerOnBadEndName(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.on$Mnbad$Mnend$Mnname;
  }
  
  public static void testRunnerOnBadEndName$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.on$Mnbad$Mnend$Mnname = paramObject;
  }
  
  public static Object testRunnerOnFinal(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.on$Mnfinal;
  }
  
  public static void testRunnerOnFinal$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.on$Mnfinal = paramObject;
  }
  
  public static Object testRunnerOnGroupBegin(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.on$Mngroup$Mnbegin;
  }
  
  public static void testRunnerOnGroupBegin$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.on$Mngroup$Mnbegin = paramObject;
  }
  
  public static Object testRunnerOnGroupEnd(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.on$Mngroup$Mnend;
  }
  
  public static void testRunnerOnGroupEnd$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.on$Mngroup$Mnend = paramObject;
  }
  
  public static Object testRunnerOnTestBegin(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.on$Mntest$Mnbegin;
  }
  
  public static void testRunnerOnTestBegin$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.on$Mntest$Mnbegin = paramObject;
  }
  
  public static Object testRunnerOnTestEnd(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.on$Mntest$Mnend;
  }
  
  public static void testRunnerOnTestEnd$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.on$Mntest$Mnend = paramObject;
  }
  
  public static Object testRunnerPassCount(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.pass$Mncount;
  }
  
  public static void testRunnerPassCount$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.pass$Mncount = paramObject;
  }
  
  /* Error */
  public static void testRunnerReset(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   4: astore_2
    //   5: aload_2
    //   6: getstatic 845	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   9: invokestatic 519	gnu/kawa/slib/testing:testResultAlist$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   12: aload_0
    //   13: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   16: astore 4
    //   18: aload 4
    //   20: getstatic 595	gnu/kawa/slib/testing:Lit0	Lgnu/math/IntNum;
    //   23: invokestatic 760	gnu/kawa/slib/testing:testRunnerPassCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   26: aload_0
    //   27: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   30: astore 6
    //   32: aload 6
    //   34: getstatic 595	gnu/kawa/slib/testing:Lit0	Lgnu/math/IntNum;
    //   37: invokestatic 769	gnu/kawa/slib/testing:testRunnerFailCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   40: aload_0
    //   41: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   44: astore 8
    //   46: aload 8
    //   48: getstatic 595	gnu/kawa/slib/testing:Lit0	Lgnu/math/IntNum;
    //   51: invokestatic 772	gnu/kawa/slib/testing:testRunnerXpassCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   54: aload_0
    //   55: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   58: astore 10
    //   60: aload 10
    //   62: getstatic 595	gnu/kawa/slib/testing:Lit0	Lgnu/math/IntNum;
    //   65: invokestatic 775	gnu/kawa/slib/testing:testRunnerXfailCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   68: aload_0
    //   69: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   72: astore 12
    //   74: aload 12
    //   76: getstatic 595	gnu/kawa/slib/testing:Lit0	Lgnu/math/IntNum;
    //   79: invokestatic 778	gnu/kawa/slib/testing:testRunnerSkipCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   82: aload_0
    //   83: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   86: astore 14
    //   88: aload 14
    //   90: getstatic 595	gnu/kawa/slib/testing:Lit0	Lgnu/math/IntNum;
    //   93: invokestatic 763	gnu/kawa/slib/testing:$PcTestRunnerTotalCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   96: aload_0
    //   97: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   100: astore 16
    //   102: aload 16
    //   104: getstatic 845	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   107: invokestatic 419	gnu/kawa/slib/testing:$PcTestRunnerCountList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   110: aload_0
    //   111: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   114: astore 18
    //   116: aload 18
    //   118: getstatic 308	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   121: invokestatic 1936	gnu/kawa/slib/testing:$PcTestRunnerRunList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   124: aload_0
    //   125: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   128: astore 20
    //   130: aload 20
    //   132: getstatic 845	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   135: invokestatic 562	gnu/kawa/slib/testing:$PcTestRunnerSkipList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   138: aload_0
    //   139: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   142: astore 22
    //   144: aload 22
    //   146: getstatic 845	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   149: invokestatic 565	gnu/kawa/slib/testing:$PcTestRunnerFailList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   152: aload_0
    //   153: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   156: astore 24
    //   158: aload 24
    //   160: getstatic 845	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   163: invokestatic 401	gnu/kawa/slib/testing:$PcTestRunnerSkipSave$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   166: aload_0
    //   167: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   170: astore 26
    //   172: aload 26
    //   174: getstatic 845	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   177: invokestatic 410	gnu/kawa/slib/testing:$PcTestRunnerFailSave$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   180: aload_0
    //   181: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   184: astore 28
    //   186: aload 28
    //   188: getstatic 845	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   191: invokestatic 425	gnu/kawa/slib/testing:testRunnerGroupStack$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   194: return
    //   195: astore_1
    //   196: new 427	gnu/mapping/WrongType
    //   199: dup
    //   200: aload_1
    //   201: ldc_w 576
    //   204: iconst_0
    //   205: aload_0
    //   206: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   209: athrow
    //   210: astore_3
    //   211: new 427	gnu/mapping/WrongType
    //   214: dup
    //   215: aload_3
    //   216: ldc_w 780
    //   219: iconst_0
    //   220: aload_0
    //   221: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   224: athrow
    //   225: astore 5
    //   227: new 427	gnu/mapping/WrongType
    //   230: dup
    //   231: aload 5
    //   233: ldc_w 782
    //   236: iconst_0
    //   237: aload_0
    //   238: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   241: athrow
    //   242: astore 7
    //   244: new 427	gnu/mapping/WrongType
    //   247: dup
    //   248: aload 7
    //   250: ldc_w 784
    //   253: iconst_0
    //   254: aload_0
    //   255: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   258: athrow
    //   259: astore 9
    //   261: new 427	gnu/mapping/WrongType
    //   264: dup
    //   265: aload 9
    //   267: ldc_w 786
    //   270: iconst_0
    //   271: aload_0
    //   272: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   275: athrow
    //   276: astore 11
    //   278: new 427	gnu/mapping/WrongType
    //   281: dup
    //   282: aload 11
    //   284: ldc_w 788
    //   287: iconst_0
    //   288: aload_0
    //   289: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   292: athrow
    //   293: astore 13
    //   295: new 427	gnu/mapping/WrongType
    //   298: dup
    //   299: aload 13
    //   301: ldc_w 790
    //   304: iconst_0
    //   305: aload_0
    //   306: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   309: athrow
    //   310: astore 15
    //   312: new 427	gnu/mapping/WrongType
    //   315: dup
    //   316: aload 15
    //   318: ldc_w 446
    //   321: iconst_0
    //   322: aload_0
    //   323: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   326: athrow
    //   327: astore 17
    //   329: new 427	gnu/mapping/WrongType
    //   332: dup
    //   333: aload 17
    //   335: ldc_w 1955
    //   338: iconst_0
    //   339: aload_0
    //   340: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   343: athrow
    //   344: astore 19
    //   346: new 427	gnu/mapping/WrongType
    //   349: dup
    //   350: aload 19
    //   352: ldc_w 584
    //   355: iconst_0
    //   356: aload_0
    //   357: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   360: athrow
    //   361: astore 21
    //   363: new 427	gnu/mapping/WrongType
    //   366: dup
    //   367: aload 21
    //   369: ldc_w 586
    //   372: iconst_0
    //   373: aload_0
    //   374: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   377: athrow
    //   378: astore 23
    //   380: new 427	gnu/mapping/WrongType
    //   383: dup
    //   384: aload 23
    //   386: ldc_w 434
    //   389: iconst_0
    //   390: aload_0
    //   391: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   394: athrow
    //   395: astore 25
    //   397: new 427	gnu/mapping/WrongType
    //   400: dup
    //   401: aload 25
    //   403: ldc_w 440
    //   406: iconst_0
    //   407: aload_0
    //   408: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   411: athrow
    //   412: astore 27
    //   414: new 427	gnu/mapping/WrongType
    //   417: dup
    //   418: aload 27
    //   420: ldc_w 452
    //   423: iconst_0
    //   424: aload_0
    //   425: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   428: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	paramObject	Object
    //   195	6	1	localClassCastException1	ClassCastException
    //   4	2	2	localMnrunner1	test.Mnrunner
    //   210	6	3	localClassCastException2	ClassCastException
    //   16	3	4	localMnrunner2	test.Mnrunner
    //   225	7	5	localClassCastException3	ClassCastException
    //   30	3	6	localMnrunner3	test.Mnrunner
    //   242	7	7	localClassCastException4	ClassCastException
    //   44	3	8	localMnrunner4	test.Mnrunner
    //   259	7	9	localClassCastException5	ClassCastException
    //   58	3	10	localMnrunner5	test.Mnrunner
    //   276	7	11	localClassCastException6	ClassCastException
    //   72	3	12	localMnrunner6	test.Mnrunner
    //   293	7	13	localClassCastException7	ClassCastException
    //   86	3	14	localMnrunner7	test.Mnrunner
    //   310	7	15	localClassCastException8	ClassCastException
    //   100	3	16	localMnrunner8	test.Mnrunner
    //   327	7	17	localClassCastException9	ClassCastException
    //   114	3	18	localMnrunner9	test.Mnrunner
    //   344	7	19	localClassCastException10	ClassCastException
    //   128	3	20	localMnrunner10	test.Mnrunner
    //   361	7	21	localClassCastException11	ClassCastException
    //   142	3	22	localMnrunner11	test.Mnrunner
    //   378	7	23	localClassCastException12	ClassCastException
    //   156	3	24	localMnrunner12	test.Mnrunner
    //   395	7	25	localClassCastException13	ClassCastException
    //   170	3	26	localMnrunner13	test.Mnrunner
    //   412	7	27	localClassCastException14	ClassCastException
    //   184	3	28	localMnrunner14	test.Mnrunner
    // Exception table:
    //   from	to	target	type
    //   0	5	195	java/lang/ClassCastException
    //   12	18	210	java/lang/ClassCastException
    //   26	32	225	java/lang/ClassCastException
    //   40	46	242	java/lang/ClassCastException
    //   54	60	259	java/lang/ClassCastException
    //   68	74	276	java/lang/ClassCastException
    //   82	88	293	java/lang/ClassCastException
    //   96	102	310	java/lang/ClassCastException
    //   110	116	327	java/lang/ClassCastException
    //   124	130	344	java/lang/ClassCastException
    //   138	144	361	java/lang/ClassCastException
    //   152	158	378	java/lang/ClassCastException
    //   166	172	395	java/lang/ClassCastException
    //   180	186	412	java/lang/ClassCastException
  }
  
  public static test.Mnrunner testRunnerSimple()
  {
    test.Mnrunner localMnrunner = $PcTestRunnerAlloc();
    testRunnerReset(localMnrunner);
    testRunnerOnGroupBegin$Ex(localMnrunner, test$Mnon$Mngroup$Mnbegin$Mnsimple);
    testRunnerOnGroupEnd$Ex(localMnrunner, test$Mnon$Mngroup$Mnend$Mnsimple);
    testRunnerOnFinal$Ex(localMnrunner, test$Mnon$Mnfinal$Mnsimple);
    testRunnerOnTestBegin$Ex(localMnrunner, test$Mnon$Mntest$Mnbegin$Mnsimple);
    testRunnerOnTestEnd$Ex(localMnrunner, test$Mnon$Mntest$Mnend$Mnsimple);
    testRunnerOnBadCount$Ex(localMnrunner, test$Mnon$Mnbad$Mncount$Mnsimple);
    testRunnerOnBadEndName$Ex(localMnrunner, test$Mnon$Mnbad$Mnend$Mnname$Mnsimple);
    return localMnrunner;
  }
  
  public static Object testRunnerSkipCount(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.skip$Mncount;
  }
  
  public static void testRunnerSkipCount$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.skip$Mncount = paramObject;
  }
  
  public static Object testRunnerTestName(Object paramObject)
  {
    SimpleSymbol localSimpleSymbol = Lit7;
    try
    {
      test.Mnrunner localMnrunner = (test.Mnrunner)paramObject;
      Object localObject = lists.assq(localSimpleSymbol, testResultAlist(localMnrunner));
      if (localObject != Boolean.FALSE) {
        return lists.cdr.apply1(localObject);
      }
      return "";
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "test-result-alist", 0, paramObject);
    }
  }
  
  public static Object testRunnerXfailCount(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.xfail$Mncount;
  }
  
  public static void testRunnerXfailCount$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.xfail$Mncount = paramObject;
  }
  
  public static Object testRunnerXpassCount(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.xpass$Mncount;
  }
  
  public static void testRunnerXpassCount$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.xpass$Mncount = paramObject;
  }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply0(paramModuleMethod);
    case 53: 
      return testRunnerNull();
    case 54: 
      return testRunnerSimple();
    case 55: 
      return testRunnerGet();
    case 56: 
      return testRunnerCreate();
    }
    return $PcTestReportResult();
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 14: 
    case 16: 
    case 18: 
    case 20: 
    case 22: 
    case 24: 
    case 26: 
    case 28: 
    case 30: 
    case 32: 
    case 34: 
    case 36: 
    case 38: 
    case 40: 
    case 42: 
    case 44: 
    case 46: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 58: 
    case 59: 
    case 61: 
    case 62: 
    case 64: 
    case 67: 
    case 69: 
    case 70: 
    case 71: 
    case 72: 
    case 74: 
    case 84: 
    case 85: 
    case 86: 
    case 87: 
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 12: 
      if (isTestRunner(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    try
    {
      test.Mnrunner localMnrunner17 = (test.Mnrunner)paramObject;
      return testRunnerPassCount(localMnrunner17);
    }
    catch (ClassCastException localClassCastException17)
    {
      test.Mnrunner localMnrunner16;
      test.Mnrunner localMnrunner15;
      test.Mnrunner localMnrunner14;
      test.Mnrunner localMnrunner13;
      test.Mnrunner localMnrunner12;
      test.Mnrunner localMnrunner11;
      test.Mnrunner localMnrunner10;
      test.Mnrunner localMnrunner9;
      test.Mnrunner localMnrunner8;
      test.Mnrunner localMnrunner7;
      test.Mnrunner localMnrunner6;
      test.Mnrunner localMnrunner5;
      test.Mnrunner localMnrunner4;
      test.Mnrunner localMnrunner3;
      test.Mnrunner localMnrunner2;
      test.Mnrunner localMnrunner1;
      throw new WrongType(localClassCastException17, "test-runner-pass-count", 1, paramObject);
    }
    try
    {
      localMnrunner16 = (test.Mnrunner)paramObject;
      return testRunnerFailCount(localMnrunner16);
    }
    catch (ClassCastException localClassCastException16)
    {
      throw new WrongType(localClassCastException16, "test-runner-fail-count", 1, paramObject);
    }
    try
    {
      localMnrunner15 = (test.Mnrunner)paramObject;
      return testRunnerXpassCount(localMnrunner15);
    }
    catch (ClassCastException localClassCastException15)
    {
      throw new WrongType(localClassCastException15, "test-runner-xpass-count", 1, paramObject);
    }
    try
    {
      localMnrunner14 = (test.Mnrunner)paramObject;
      return testRunnerXfailCount(localMnrunner14);
    }
    catch (ClassCastException localClassCastException14)
    {
      throw new WrongType(localClassCastException14, "test-runner-xfail-count", 1, paramObject);
    }
    try
    {
      localMnrunner13 = (test.Mnrunner)paramObject;
      return testRunnerSkipCount(localMnrunner13);
    }
    catch (ClassCastException localClassCastException13)
    {
      throw new WrongType(localClassCastException13, "test-runner-skip-count", 1, paramObject);
    }
    try
    {
      localMnrunner12 = (test.Mnrunner)paramObject;
      return $PcTestRunnerSkipList(localMnrunner12);
    }
    catch (ClassCastException localClassCastException12)
    {
      throw new WrongType(localClassCastException12, "%test-runner-skip-list", 1, paramObject);
    }
    try
    {
      localMnrunner11 = (test.Mnrunner)paramObject;
      return $PcTestRunnerFailList(localMnrunner11);
    }
    catch (ClassCastException localClassCastException11)
    {
      throw new WrongType(localClassCastException11, "%test-runner-fail-list", 1, paramObject);
    }
    try
    {
      localMnrunner10 = (test.Mnrunner)paramObject;
      return testRunnerGroupStack(localMnrunner10);
    }
    catch (ClassCastException localClassCastException10)
    {
      throw new WrongType(localClassCastException10, "test-runner-group-stack", 1, paramObject);
    }
    try
    {
      localMnrunner9 = (test.Mnrunner)paramObject;
      return testRunnerOnTestBegin(localMnrunner9);
    }
    catch (ClassCastException localClassCastException9)
    {
      throw new WrongType(localClassCastException9, "test-runner-on-test-begin", 1, paramObject);
    }
    try
    {
      localMnrunner8 = (test.Mnrunner)paramObject;
      return testRunnerOnTestEnd(localMnrunner8);
    }
    catch (ClassCastException localClassCastException8)
    {
      throw new WrongType(localClassCastException8, "test-runner-on-test-end", 1, paramObject);
    }
    try
    {
      localMnrunner7 = (test.Mnrunner)paramObject;
      return testRunnerOnGroupBegin(localMnrunner7);
    }
    catch (ClassCastException localClassCastException7)
    {
      throw new WrongType(localClassCastException7, "test-runner-on-group-begin", 1, paramObject);
    }
    try
    {
      localMnrunner6 = (test.Mnrunner)paramObject;
      return testRunnerOnGroupEnd(localMnrunner6);
    }
    catch (ClassCastException localClassCastException6)
    {
      throw new WrongType(localClassCastException6, "test-runner-on-group-end", 1, paramObject);
    }
    try
    {
      localMnrunner5 = (test.Mnrunner)paramObject;
      return testRunnerOnFinal(localMnrunner5);
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "test-runner-on-final", 1, paramObject);
    }
    try
    {
      localMnrunner4 = (test.Mnrunner)paramObject;
      return testRunnerOnBadCount(localMnrunner4);
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "test-runner-on-bad-count", 1, paramObject);
    }
    try
    {
      localMnrunner3 = (test.Mnrunner)paramObject;
      return testRunnerOnBadEndName(localMnrunner3);
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "test-runner-on-bad-end-name", 1, paramObject);
    }
    try
    {
      localMnrunner2 = (test.Mnrunner)paramObject;
      return testResultAlist(localMnrunner2);
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "test-result-alist", 1, paramObject);
    }
    try
    {
      localMnrunner1 = (test.Mnrunner)paramObject;
      return testRunnerAuxValue(localMnrunner1);
    }
    catch (ClassCastException localClassCastException1)
    {
      throw new WrongType(localClassCastException1, "test-runner-aux-value", 1, paramObject);
    }
    testRunnerReset(paramObject);
    return Values.empty;
    return testRunnerGroupPath(paramObject);
    return $PcTestNullCallback(paramObject);
    return $PcTestShouldExecute(paramObject);
    return testOnGroupEndSimple(paramObject);
    testOnFinalSimple(paramObject);
    return Values.empty;
    return testOnTestBeginSimple(paramObject);
    return testOnTestEndSimple(paramObject);
    testResultClear(paramObject);
    return Values.empty;
    if ($PcTestOnTestBegin(paramObject)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    return testRunnerTestName(paramObject);
    return $PcTestApproximimate$Eq(paramObject);
    return $PcTestAsSpecifier(paramObject);
    return testMatchName(paramObject);
    return testReadEvalString(paramObject);
    return lambda16(paramObject);
    return lambda17(paramObject);
    return lambda18(paramObject);
    return lambda19(paramObject);
    return lambda20(paramObject);
    return lambda21(paramObject);
    return lambda22(paramObject);
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    try
    {
      test.Mnrunner localMnrunner17 = (test.Mnrunner)paramObject1;
      testRunnerPassCount$Ex(localMnrunner17, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException17)
    {
      test.Mnrunner localMnrunner16;
      test.Mnrunner localMnrunner15;
      test.Mnrunner localMnrunner14;
      test.Mnrunner localMnrunner13;
      test.Mnrunner localMnrunner12;
      test.Mnrunner localMnrunner11;
      test.Mnrunner localMnrunner10;
      test.Mnrunner localMnrunner9;
      test.Mnrunner localMnrunner8;
      test.Mnrunner localMnrunner7;
      test.Mnrunner localMnrunner6;
      test.Mnrunner localMnrunner5;
      test.Mnrunner localMnrunner4;
      test.Mnrunner localMnrunner3;
      test.Mnrunner localMnrunner2;
      test.Mnrunner localMnrunner1;
      throw new WrongType(localClassCastException17, "test-runner-pass-count!", 1, paramObject1);
    }
    try
    {
      localMnrunner16 = (test.Mnrunner)paramObject1;
      testRunnerFailCount$Ex(localMnrunner16, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException16)
    {
      throw new WrongType(localClassCastException16, "test-runner-fail-count!", 1, paramObject1);
    }
    try
    {
      localMnrunner15 = (test.Mnrunner)paramObject1;
      testRunnerXpassCount$Ex(localMnrunner15, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException15)
    {
      throw new WrongType(localClassCastException15, "test-runner-xpass-count!", 1, paramObject1);
    }
    try
    {
      localMnrunner14 = (test.Mnrunner)paramObject1;
      testRunnerXfailCount$Ex(localMnrunner14, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException14)
    {
      throw new WrongType(localClassCastException14, "test-runner-xfail-count!", 1, paramObject1);
    }
    try
    {
      localMnrunner13 = (test.Mnrunner)paramObject1;
      testRunnerSkipCount$Ex(localMnrunner13, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException13)
    {
      throw new WrongType(localClassCastException13, "test-runner-skip-count!", 1, paramObject1);
    }
    try
    {
      localMnrunner12 = (test.Mnrunner)paramObject1;
      $PcTestRunnerSkipList$Ex(localMnrunner12, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException12)
    {
      throw new WrongType(localClassCastException12, "%test-runner-skip-list!", 1, paramObject1);
    }
    try
    {
      localMnrunner11 = (test.Mnrunner)paramObject1;
      $PcTestRunnerFailList$Ex(localMnrunner11, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException11)
    {
      throw new WrongType(localClassCastException11, "%test-runner-fail-list!", 1, paramObject1);
    }
    try
    {
      localMnrunner10 = (test.Mnrunner)paramObject1;
      testRunnerGroupStack$Ex(localMnrunner10, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException10)
    {
      throw new WrongType(localClassCastException10, "test-runner-group-stack!", 1, paramObject1);
    }
    try
    {
      localMnrunner9 = (test.Mnrunner)paramObject1;
      testRunnerOnTestBegin$Ex(localMnrunner9, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException9)
    {
      throw new WrongType(localClassCastException9, "test-runner-on-test-begin!", 1, paramObject1);
    }
    try
    {
      localMnrunner8 = (test.Mnrunner)paramObject1;
      testRunnerOnTestEnd$Ex(localMnrunner8, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException8)
    {
      throw new WrongType(localClassCastException8, "test-runner-on-test-end!", 1, paramObject1);
    }
    try
    {
      localMnrunner7 = (test.Mnrunner)paramObject1;
      testRunnerOnGroupBegin$Ex(localMnrunner7, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException7)
    {
      throw new WrongType(localClassCastException7, "test-runner-on-group-begin!", 1, paramObject1);
    }
    try
    {
      localMnrunner6 = (test.Mnrunner)paramObject1;
      testRunnerOnGroupEnd$Ex(localMnrunner6, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException6)
    {
      throw new WrongType(localClassCastException6, "test-runner-on-group-end!", 1, paramObject1);
    }
    try
    {
      localMnrunner5 = (test.Mnrunner)paramObject1;
      testRunnerOnFinal$Ex(localMnrunner5, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "test-runner-on-final!", 1, paramObject1);
    }
    try
    {
      localMnrunner4 = (test.Mnrunner)paramObject1;
      testRunnerOnBadCount$Ex(localMnrunner4, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "test-runner-on-bad-count!", 1, paramObject1);
    }
    try
    {
      localMnrunner3 = (test.Mnrunner)paramObject1;
      testRunnerOnBadEndName$Ex(localMnrunner3, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "test-runner-on-bad-end-name!", 1, paramObject1);
    }
    try
    {
      localMnrunner2 = (test.Mnrunner)paramObject1;
      testResultAlist$Ex(localMnrunner2, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "test-result-alist!", 1, paramObject1);
    }
    try
    {
      localMnrunner1 = (test.Mnrunner)paramObject1;
      testRunnerAuxValue$Ex(localMnrunner1, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException1)
    {
      throw new WrongType(localClassCastException1, "test-runner-aux-value!", 1, paramObject1);
    }
    $PcTestBegin(paramObject1, paramObject2);
    return Values.empty;
    return $PcTestEnd(paramObject1, paramObject2);
    testResultRemove(paramObject1, paramObject2);
    return Values.empty;
    return $PcTestOnTestEnd(paramObject1, paramObject2);
    return $PcTestMatchNth(paramObject1, paramObject2);
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    case 50: 
      return lambda1(paramObject1, paramObject2, paramObject3);
    case 51: 
      return lambda2(paramObject1, paramObject2, paramObject3);
    case 52: 
      return lambda3(paramObject1, paramObject2, paramObject3);
    case 59: 
      return testOnGroupBeginSimple(paramObject1, paramObject2, paramObject3);
    case 61: 
      testOnBadCountSimple(paramObject1, paramObject2, paramObject3);
      return Values.empty;
    case 62: 
      return testOnBadEndNameSimple(paramObject1, paramObject2, paramObject3);
    }
    return testResultSet$Ex(paramObject1, paramObject2, paramObject3);
  }
  
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 70: 
      return testResultKind$V(paramArrayOfObject);
    case 71: 
      return isTestPassed$V(paramArrayOfObject);
    case 84: 
      Object localObject = paramArrayOfObject[0];
      int i = -1 + paramArrayOfObject.length;
      Object[] arrayOfObject = new Object[i];
      for (;;)
      {
        i--;
        if (i < 0) {
          return testApply$V(localObject, arrayOfObject);
        }
        arrayOfObject[i] = paramArrayOfObject[(i + 1)];
      }
    case 86: 
      return $PcTestMatchAll$V(paramArrayOfObject);
    }
    return $PcTestMatchAny$V(paramArrayOfObject);
  }
  
  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match0(paramModuleMethod, paramCallContext);
    case 72: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 56: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 55: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 54: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 0;
    return 0;
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 14: 
    case 16: 
    case 18: 
    case 20: 
    case 22: 
    case 24: 
    case 26: 
    case 28: 
    case 30: 
    case 32: 
    case 34: 
    case 36: 
    case 38: 
    case 40: 
    case 42: 
    case 44: 
    case 46: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 58: 
    case 59: 
    case 61: 
    case 62: 
    case 64: 
    case 67: 
    case 69: 
    case 70: 
    case 71: 
    case 72: 
    case 74: 
    case 84: 
    case 85: 
    case 86: 
    case 87: 
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 83: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 82: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 81: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 80: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 79: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 78: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 77: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 90: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 89: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 88: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 76: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 75: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 73: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 68: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 66: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 65: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 63: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 60: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 57: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 49: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 48: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 47: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 45: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 43: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 41: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 39: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 37: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 35: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 33: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 31: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 29: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 27: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 25: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 23: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 21: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 19: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 17: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 15: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 13: 
      if (!(paramObject instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }
  
  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 85: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 74: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 69: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 64: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 58: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 46: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 44: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 42: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 40: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 38: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 36: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 34: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 32: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 30: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 28: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 26: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 24: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 22: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 20: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 18: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 16: 
      if (!(paramObject1 instanceof test.Mnrunner)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    if (!(paramObject1 instanceof test.Mnrunner)) {
      return -786431;
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }
  
  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 67: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 62: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 61: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 59: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 52: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 51: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 3;
    return 0;
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 87: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 86: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 84: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 71: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    }
    paramCallContext.values = paramArrayOfObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 5;
    return 0;
  }
  
  public final void run(CallContext paramCallContext)
  {
    test$Mnlog$Mnto$Mnfile = Boolean.TRUE;
    test$Mnrunner$Mncurrent = parameters.makeParameter(Boolean.FALSE);
    test$Mnrunner$Mnfactory = parameters.makeParameter(test$Mnrunner$Mnsimple);
  }
  
  public class frame
    extends ModuleBody
  {
    Object p;
    
    public Object lambda4loop(Object paramObject)
    {
      if (paramObject == this.p) {
        return lists.cdr.apply1(paramObject);
      }
      return lists.cons(lists.car.apply1(paramObject), lambda4loop(lists.cdr.apply1(paramObject)));
    }
  }
  
  public class frame0
    extends ModuleBody
  {
    Object error;
    final ModuleMethod lambda$Fn4;
    
    public frame0()
    {
      this$1 = new ModuleMethod(this, 1, null, 8194);
      this$1.setProperty("source-location", "testing.scm:640");
      this.lambda$Fn4 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 1)
      {
        if (lambda5(paramObject1, paramObject2)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    boolean lambda5(Object paramObject1, Object paramObject2)
    {
      Object localObject = Scheme.numGEq.apply2(paramObject1, AddOp.$Mn.apply2(paramObject2, this.error));
      try
      {
        boolean bool1 = ((Boolean)localObject).booleanValue();
        boolean bool2 = bool1;
        if (bool2) {
          bool2 = ((Boolean)Scheme.numLEq.apply2(paramObject1, AddOp.$Pl.apply2(paramObject2, this.error))).booleanValue();
        }
        return bool2;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "x", -2, localObject);
      }
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 1)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame1
    extends ModuleBody
  {
    Object first;
    final ModuleMethod lambda$Fn10;
    final ModuleMethod lambda$Fn5 = new ModuleMethod(this, 2, null, 0);
    final ModuleMethod lambda$Fn6 = new ModuleMethod(this, 3, null, 0);
    final ModuleMethod lambda$Fn7;
    final ModuleMethod lambda$Fn8;
    final ModuleMethod lambda$Fn9;
    Object r;
    LList rest;
    Object saved$Mnrunner;
    Object saved$Mnrunner$1;
    
    public frame1()
    {
      this$1 = new ModuleMethod(this, 4, null, 0);
      this$1.setProperty("source-location", "testing.scm:897");
      this.lambda$Fn7 = this$1;
      this.lambda$Fn8 = new ModuleMethod(this, 5, null, 0);
      this.lambda$Fn9 = new ModuleMethod(this, 6, null, 0);
      ModuleMethod localModuleMethod = new ModuleMethod(this, 7, null, 0);
      localModuleMethod.setProperty("source-location", "testing.scm:897");
      this.lambda$Fn10 = localModuleMethod;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply0(paramModuleMethod);
      case 2: 
        return lambda6();
      case 3: 
        return lambda7();
      case 4: 
        return lambda8();
      case 5: 
        return lambda9();
      case 6: 
        return lambda10();
      }
      return lambda11();
    }
    
    Object lambda10()
    {
      return Scheme.apply.apply3(testing.test$Mnapply, this.first, this.rest);
    }
    
    Object lambda11()
    {
      return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(this.saved$Mnrunner);
    }
    
    Object lambda6()
    {
      return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(this.first);
    }
    
    Object lambda7()
    {
      return Scheme.apply.apply2(testing.test$Mnapply, this.rest);
    }
    
    Object lambda8()
    {
      return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(this.saved$Mnrunner$1);
    }
    
    Object lambda9()
    {
      return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(this.r);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match0(paramModuleMethod, paramCallContext);
      case 7: 
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      case 6: 
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      case 5: 
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      case 4: 
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      case 3: 
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }
  }
  
  public class frame2
    extends ModuleBody
  {
    Object count;
    Object i;
    final ModuleMethod lambda$Fn11;
    Object n;
    
    public frame2()
    {
      this$1 = new ModuleMethod(this, 8, null, 4097);
      this$1.setProperty("source-location", "testing.scm:903");
      this.lambda$Fn11 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 8)
      {
        if (lambda12(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda12(Object paramObject)
    {
      this.i = AddOp.$Pl.apply2(this.i, testing.Lit13);
      Object localObject = Scheme.numGEq.apply2(this.i, this.n);
      try
      {
        boolean bool1 = ((Boolean)localObject).booleanValue();
        boolean bool2 = bool1;
        if (bool2) {
          bool2 = ((Boolean)Scheme.numLss.apply2(this.i, AddOp.$Pl.apply2(this.n, this.count))).booleanValue();
        }
        return bool2;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "x", -2, localObject);
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 8)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame3
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn12;
    LList pred$Mnlist;
    
    public frame3()
    {
      this$1 = new ModuleMethod(this, 9, null, 4097);
      this$1.setProperty("source-location", "testing.scm:915");
      this.lambda$Fn12 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 9) {
        return lambda13(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda13(Object paramObject)
    {
      Boolean localBoolean = Boolean.TRUE;
      for (Object localObject = this.pred$Mnlist;; localObject = lists.cdr.apply1(localObject))
      {
        if (lists.isNull(localObject)) {
          return localBoolean;
        }
        if (Scheme.applyToArgs.apply2(lists.car.apply1(localObject), paramObject) == Boolean.FALSE) {
          localBoolean = Boolean.FALSE;
        }
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 9)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame4
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn13;
    LList pred$Mnlist;
    
    public frame4()
    {
      this$1 = new ModuleMethod(this, 10, null, 4097);
      this$1.setProperty("source-location", "testing.scm:931");
      this.lambda$Fn13 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 10) {
        return lambda14(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda14(Object paramObject)
    {
      Boolean localBoolean = Boolean.FALSE;
      for (Object localObject = this.pred$Mnlist;; localObject = lists.cdr.apply1(localObject))
      {
        if (lists.isNull(localObject)) {
          return localBoolean;
        }
        if (Scheme.applyToArgs.apply2(lists.car.apply1(localObject), paramObject) != Boolean.FALSE) {
          localBoolean = Boolean.TRUE;
        }
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 10)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame5
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn14;
    Object name;
    
    public frame5()
    {
      this$1 = new ModuleMethod(this, 11, null, 4097);
      this$1.setProperty("source-location", "testing.scm:971");
      this.lambda$Fn14 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 11)
      {
        if (lambda15(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda15(Object paramObject)
    {
      return IsEqual.apply(this.name, testing.testRunnerTestName(paramObject));
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 11)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.testing
 * JD-Core Version:    0.7.0.1
 */