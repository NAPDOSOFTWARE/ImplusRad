package gnu.kawa.slib;

import gnu.expr.GenericProc;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.ports;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.append;

public class pregexp
  extends ModuleBody
{
  public static Char $Stpregexp$Mncomment$Mnchar$St;
  public static Object $Stpregexp$Mnnul$Mnchar$Mnint$St;
  public static Object $Stpregexp$Mnreturn$Mnchar$St;
  public static Object $Stpregexp$Mnspace$Mnsensitive$Qu$St;
  public static Object $Stpregexp$Mntab$Mnchar$St;
  public static IntNum $Stpregexp$Mnversion$St;
  public static final pregexp $instance;
  static final IntNum Lit0;
  static final Char Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit100;
  static final SimpleSymbol Lit101;
  static final SimpleSymbol Lit102;
  static final SimpleSymbol Lit103;
  static final SimpleSymbol Lit104;
  static final SimpleSymbol Lit105;
  static final PairWithPosition Lit106;
  static final SimpleSymbol Lit107;
  static final PairWithPosition Lit108;
  static final SimpleSymbol Lit109;
  static final Char Lit11;
  static final SimpleSymbol Lit110;
  static final SimpleSymbol Lit111;
  static final SimpleSymbol Lit112;
  static final Char Lit113;
  static final SimpleSymbol Lit114;
  static final SimpleSymbol Lit115;
  static final PairWithPosition Lit116;
  static final SimpleSymbol Lit117;
  static final SimpleSymbol Lit118;
  static final SimpleSymbol Lit119;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit120;
  static final SimpleSymbol Lit121;
  static final SimpleSymbol Lit122;
  static final SimpleSymbol Lit123;
  static final SimpleSymbol Lit124;
  static final SimpleSymbol Lit125;
  static final SimpleSymbol Lit126;
  static final SimpleSymbol Lit127;
  static final SimpleSymbol Lit128;
  static final SimpleSymbol Lit129;
  static final Char Lit13;
  static final SimpleSymbol Lit130;
  static final SimpleSymbol Lit131;
  static final SimpleSymbol Lit132;
  static final SimpleSymbol Lit133;
  static final SimpleSymbol Lit134;
  static final SimpleSymbol Lit135 = (SimpleSymbol)new SimpleSymbol("pregexp-quote").readResolve();
  static final SimpleSymbol Lit14;
  static final Char Lit15;
  static final IntNum Lit16;
  static final SimpleSymbol Lit17;
  static final Char Lit18;
  static final Char Lit19;
  static final Char Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final Char Lit24;
  static final Char Lit25;
  static final SimpleSymbol Lit26;
  static final Char Lit27;
  static final SimpleSymbol Lit28;
  static final Char Lit29;
  static final Char Lit3;
  static final SimpleSymbol Lit30;
  static final Char Lit31;
  static final PairWithPosition Lit32;
  static final Char Lit33;
  static final Char Lit34;
  static final Char Lit35;
  static final SimpleSymbol Lit36;
  static final Char Lit37;
  static final PairWithPosition Lit38;
  static final Char Lit39;
  static final SimpleSymbol Lit4;
  static final Char Lit40;
  static final SimpleSymbol Lit41;
  static final Char Lit42;
  static final PairWithPosition Lit43;
  static final Char Lit44;
  static final SimpleSymbol Lit45;
  static final Char Lit46;
  static final Char Lit47;
  static final Char Lit48;
  static final PairWithPosition Lit49;
  static final SimpleSymbol Lit5;
  static final Char Lit50;
  static final PairWithPosition Lit51;
  static final Char Lit52;
  static final PairWithPosition Lit53;
  static final Char Lit54;
  static final PairWithPosition Lit55;
  static final PairWithPosition Lit56;
  static final SimpleSymbol Lit57;
  static final Char Lit58;
  static final Char Lit59;
  static final Char Lit6;
  static final SimpleSymbol Lit60;
  static final SimpleSymbol Lit61;
  static final Char Lit62;
  static final PairWithPosition Lit63;
  static final SimpleSymbol Lit64;
  static final Char Lit65;
  static final Char Lit66;
  static final Char Lit67;
  static final SimpleSymbol Lit68;
  static final SimpleSymbol Lit69;
  static final Char Lit7;
  static final SimpleSymbol Lit70;
  static final SimpleSymbol Lit71;
  static final SimpleSymbol Lit72;
  static final IntNum Lit73;
  static final SimpleSymbol Lit74;
  static final SimpleSymbol Lit75;
  static final SimpleSymbol Lit76;
  static final Char Lit77;
  static final Char Lit78;
  static final SimpleSymbol Lit79;
  static final IntNum Lit8;
  static final SimpleSymbol Lit80;
  static final SimpleSymbol Lit81;
  static final SimpleSymbol Lit82;
  static final SimpleSymbol Lit83;
  static final Char Lit84;
  static final SimpleSymbol Lit85;
  static final SimpleSymbol Lit86;
  static final SimpleSymbol Lit87;
  static final SimpleSymbol Lit88;
  static final SimpleSymbol Lit89;
  static final Char Lit9;
  static final SimpleSymbol Lit90;
  static final SimpleSymbol Lit91;
  static final SimpleSymbol Lit92;
  static final SimpleSymbol Lit93;
  static final SimpleSymbol Lit94;
  static final SimpleSymbol Lit95;
  static final Char Lit96;
  static final Char Lit97;
  static final Char Lit98;
  static final SimpleSymbol Lit99;
  static final ModuleMethod lambda$Fn1;
  static final ModuleMethod lambda$Fn10;
  static final ModuleMethod lambda$Fn6;
  static final ModuleMethod lambda$Fn7;
  static final ModuleMethod lambda$Fn8;
  static final ModuleMethod lambda$Fn9;
  public static final ModuleMethod pregexp;
  public static final ModuleMethod pregexp$Mnat$Mnword$Mnboundary$Qu;
  public static final ModuleMethod pregexp$Mnchar$Mnword$Qu;
  public static final ModuleMethod pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu;
  public static final ModuleMethod pregexp$Mnerror;
  public static final ModuleMethod pregexp$Mninvert$Mnchar$Mnlist;
  public static final ModuleMethod pregexp$Mnlist$Mnref;
  public static final ModuleMethod pregexp$Mnmake$Mnbackref$Mnlist;
  public static final ModuleMethod pregexp$Mnmatch;
  public static final ModuleMethod pregexp$Mnmatch$Mnpositions;
  public static final ModuleMethod pregexp$Mnmatch$Mnpositions$Mnaux;
  public static final ModuleMethod pregexp$Mnquote;
  public static final ModuleMethod pregexp$Mnread$Mnbranch;
  public static final ModuleMethod pregexp$Mnread$Mnchar$Mnlist;
  public static final ModuleMethod pregexp$Mnread$Mncluster$Mntype;
  public static final ModuleMethod pregexp$Mnread$Mnescaped$Mnchar;
  public static final ModuleMethod pregexp$Mnread$Mnescaped$Mnnumber;
  public static final ModuleMethod pregexp$Mnread$Mnnums;
  public static final ModuleMethod pregexp$Mnread$Mnpattern;
  public static final ModuleMethod pregexp$Mnread$Mnpiece;
  public static final ModuleMethod pregexp$Mnread$Mnposix$Mnchar$Mnclass;
  public static final ModuleMethod pregexp$Mnread$Mnsubpattern;
  public static final ModuleMethod pregexp$Mnreplace;
  public static final ModuleMethod pregexp$Mnreplace$Mnaux;
  public static final ModuleMethod pregexp$Mnreplace$St;
  public static final ModuleMethod pregexp$Mnreverse$Ex;
  public static final ModuleMethod pregexp$Mnsplit;
  public static final ModuleMethod pregexp$Mnstring$Mnmatch;
  public static final ModuleMethod pregexp$Mnwrap$Mnquantifier$Mnif$Mnany;
  
  static
  {
    Lit134 = (SimpleSymbol)new SimpleSymbol("pregexp-replace*").readResolve();
    Lit133 = (SimpleSymbol)new SimpleSymbol("pregexp-replace").readResolve();
    Lit132 = (SimpleSymbol)new SimpleSymbol("pregexp-split").readResolve();
    Lit131 = (SimpleSymbol)new SimpleSymbol("pregexp-match").readResolve();
    Lit130 = (SimpleSymbol)new SimpleSymbol("pregexp").readResolve();
    Lit129 = (SimpleSymbol)new SimpleSymbol("pregexp-replace-aux").readResolve();
    Lit128 = (SimpleSymbol)new SimpleSymbol("pregexp-make-backref-list").readResolve();
    Lit127 = (SimpleSymbol)new SimpleSymbol("pregexp-list-ref").readResolve();
    Lit126 = (SimpleSymbol)new SimpleSymbol("pregexp-at-word-boundary?").readResolve();
    Lit125 = (SimpleSymbol)new SimpleSymbol("pregexp-char-word?").readResolve();
    Lit124 = (SimpleSymbol)new SimpleSymbol("pregexp-string-match").readResolve();
    Lit123 = (SimpleSymbol)new SimpleSymbol("pregexp-invert-char-list").readResolve();
    Lit122 = (SimpleSymbol)new SimpleSymbol("pregexp-read-escaped-char").readResolve();
    Lit121 = (SimpleSymbol)new SimpleSymbol("pregexp-read-escaped-number").readResolve();
    Lit120 = (SimpleSymbol)new SimpleSymbol("pregexp-read-branch").readResolve();
    Lit119 = (SimpleSymbol)new SimpleSymbol("pregexp-read-pattern").readResolve();
    Lit118 = (SimpleSymbol)new SimpleSymbol("pregexp-error").readResolve();
    Lit117 = (SimpleSymbol)new SimpleSymbol("pregexp-reverse!").readResolve();
    Char localChar1 = Char.make(92);
    Lit19 = localChar1;
    Char localChar2 = Char.make(46);
    Lit13 = localChar2;
    Char localChar3 = Char.make(63);
    Lit47 = localChar3;
    Char localChar4 = Char.make(42);
    Lit65 = localChar4;
    Char localChar5 = Char.make(43);
    Lit66 = localChar5;
    Char localChar6 = Char.make(124);
    Lit7 = localChar6;
    Char localChar7 = Char.make(94);
    Lit9 = localChar7;
    Char localChar8 = Char.make(36);
    Lit11 = localChar8;
    Char localChar9 = Char.make(91);
    Lit15 = localChar9;
    Char localChar10 = Char.make(93);
    Lit46 = localChar10;
    Char localChar11 = Char.make(123);
    Lit67 = localChar11;
    Char localChar12 = Char.make(125);
    Lit78 = localChar12;
    Char localChar13 = Char.make(40);
    Lit18 = localChar13;
    Char localChar14 = Char.make(41);
    Lit6 = localChar14;
    Lit116 = PairWithPosition.make(localChar1, PairWithPosition.make(localChar2, PairWithPosition.make(localChar3, PairWithPosition.make(localChar4, PairWithPosition.make(localChar5, PairWithPosition.make(localChar6, PairWithPosition.make(localChar7, PairWithPosition.make(localChar8, PairWithPosition.make(localChar9, PairWithPosition.make(localChar10, PairWithPosition.make(localChar11, PairWithPosition.make(localChar12, PairWithPosition.make(localChar13, PairWithPosition.make(localChar14, LList.Empty, "pregexp.scm", 3153977), "pregexp.scm", 3153973), "pregexp.scm", 3153969), "pregexp.scm", 3153965), "pregexp.scm", 3153961), "pregexp.scm", 3153957), "pregexp.scm", 3149885), "pregexp.scm", 3149881), "pregexp.scm", 3149877), "pregexp.scm", 3149873), "pregexp.scm", 3149869), "pregexp.scm", 3149865), "pregexp.scm", 3149861), "pregexp.scm", 3149856);
    Lit115 = (SimpleSymbol)new SimpleSymbol("pattern-must-be-compiled-or-string-regexp").readResolve();
    Lit114 = (SimpleSymbol)new SimpleSymbol("pregexp-match-positions").readResolve();
    Lit113 = Char.make(38);
    Lit112 = (SimpleSymbol)new SimpleSymbol("identity").readResolve();
    Lit111 = (SimpleSymbol)new SimpleSymbol("fk").readResolve();
    Lit110 = (SimpleSymbol)new SimpleSymbol("greedy-quantifier-operand-could-be-empty").readResolve();
    Lit109 = (SimpleSymbol)new SimpleSymbol(":no-backtrack").readResolve();
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol(":between").readResolve();
    Lit68 = localSimpleSymbol1;
    Boolean localBoolean1 = Boolean.FALSE;
    IntNum localIntNum = IntNum.make(0);
    Lit73 = localIntNum;
    Boolean localBoolean2 = Boolean.FALSE;
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol(":any").readResolve();
    Lit14 = localSimpleSymbol2;
    Lit108 = PairWithPosition.make(localSimpleSymbol1, PairWithPosition.make(localBoolean1, PairWithPosition.make(localIntNum, PairWithPosition.make(localBoolean2, PairWithPosition.make(localSimpleSymbol2, LList.Empty, "pregexp.scm", 2338881), "pregexp.scm", 2338878), "pregexp.scm", 2338876), "pregexp.scm", 2338873), "pregexp.scm", 2338863);
    Lit107 = (SimpleSymbol)new SimpleSymbol(":neg-lookbehind").readResolve();
    Lit106 = PairWithPosition.make(Lit68, PairWithPosition.make(Boolean.FALSE, PairWithPosition.make(Lit73, PairWithPosition.make(Boolean.FALSE, PairWithPosition.make(Lit14, LList.Empty, "pregexp.scm", 2302017), "pregexp.scm", 2302014), "pregexp.scm", 2302012), "pregexp.scm", 2302009), "pregexp.scm", 2301999);
    Lit105 = (SimpleSymbol)new SimpleSymbol(":lookbehind").readResolve();
    Lit104 = (SimpleSymbol)new SimpleSymbol(":neg-lookahead").readResolve();
    Lit103 = (SimpleSymbol)new SimpleSymbol(":lookahead").readResolve();
    Lit102 = (SimpleSymbol)new SimpleSymbol("non-existent-backref").readResolve();
    Lit101 = (SimpleSymbol)new SimpleSymbol("pregexp-match-positions-aux").readResolve();
    Lit100 = (SimpleSymbol)new SimpleSymbol(":sub").readResolve();
    Lit99 = (SimpleSymbol)new SimpleSymbol("pregexp-check-if-in-char-class?").readResolve();
    Lit98 = Char.make(102);
    Lit97 = Char.make(101);
    Lit96 = Char.make(99);
    Lit95 = (SimpleSymbol)new SimpleSymbol(":xdigit").readResolve();
    Lit94 = (SimpleSymbol)new SimpleSymbol(":upper").readResolve();
    Lit93 = (SimpleSymbol)new SimpleSymbol(":punct").readResolve();
    Lit92 = (SimpleSymbol)new SimpleSymbol(":print").readResolve();
    Lit91 = (SimpleSymbol)new SimpleSymbol(":lower").readResolve();
    Lit90 = (SimpleSymbol)new SimpleSymbol(":graph").readResolve();
    Lit89 = (SimpleSymbol)new SimpleSymbol(":cntrl").readResolve();
    Lit88 = (SimpleSymbol)new SimpleSymbol(":blank").readResolve();
    Lit87 = (SimpleSymbol)new SimpleSymbol(":ascii").readResolve();
    Lit86 = (SimpleSymbol)new SimpleSymbol(":alpha").readResolve();
    Lit85 = (SimpleSymbol)new SimpleSymbol(":alnum").readResolve();
    Lit84 = Char.make(95);
    Lit83 = (SimpleSymbol)new SimpleSymbol(":char-range").readResolve();
    Lit82 = (SimpleSymbol)new SimpleSymbol(":one-of-chars").readResolve();
    Lit81 = (SimpleSymbol)new SimpleSymbol("character-class-ended-too-soon").readResolve();
    Lit80 = (SimpleSymbol)new SimpleSymbol("pregexp-read-char-list").readResolve();
    Lit79 = (SimpleSymbol)new SimpleSymbol(":none-of-chars").readResolve();
    Lit77 = Char.make(44);
    Lit76 = (SimpleSymbol)new SimpleSymbol("pregexp-read-nums").readResolve();
    Lit75 = (SimpleSymbol)new SimpleSymbol("left-brace-must-be-followed-by-number").readResolve();
    Lit74 = (SimpleSymbol)new SimpleSymbol("pregexp-wrap-quantifier-if-any").readResolve();
    Lit72 = (SimpleSymbol)new SimpleSymbol("next-i").readResolve();
    Lit71 = (SimpleSymbol)new SimpleSymbol("at-most").readResolve();
    Lit70 = (SimpleSymbol)new SimpleSymbol("at-least").readResolve();
    Lit69 = (SimpleSymbol)new SimpleSymbol("minimal?").readResolve();
    Lit64 = (SimpleSymbol)new SimpleSymbol("pregexp-read-subpattern").readResolve();
    Lit63 = PairWithPosition.make(Lit100, LList.Empty, "pregexp.scm", 942102);
    Lit62 = Char.make(120);
    Lit61 = (SimpleSymbol)new SimpleSymbol(":case-insensitive").readResolve();
    Lit60 = (SimpleSymbol)new SimpleSymbol(":case-sensitive").readResolve();
    Lit59 = Char.make(105);
    Lit58 = Char.make(45);
    Lit57 = (SimpleSymbol)new SimpleSymbol("pregexp-read-cluster-type").readResolve();
    Lit56 = PairWithPosition.make(Lit107, LList.Empty, "pregexp.scm", 876575);
    Lit55 = PairWithPosition.make(Lit105, LList.Empty, "pregexp.scm", 872479);
    Lit54 = Char.make(60);
    Lit53 = PairWithPosition.make(Lit109, LList.Empty, "pregexp.scm", 860188);
    Lit52 = Char.make(62);
    Lit51 = PairWithPosition.make(Lit104, LList.Empty, "pregexp.scm", 856092);
    Lit50 = Char.make(33);
    Lit49 = PairWithPosition.make(Lit103, LList.Empty, "pregexp.scm", 851996);
    Lit48 = Char.make(61);
    Lit45 = (SimpleSymbol)new SimpleSymbol("pregexp-read-posix-char-class").readResolve();
    Lit44 = Char.make(58);
    SimpleSymbol localSimpleSymbol3 = (SimpleSymbol)new SimpleSymbol(":neg-char").readResolve();
    Lit17 = localSimpleSymbol3;
    SimpleSymbol localSimpleSymbol4 = (SimpleSymbol)new SimpleSymbol(":word").readResolve();
    Lit41 = localSimpleSymbol4;
    Lit43 = PairWithPosition.make(localSimpleSymbol3, PairWithPosition.make(localSimpleSymbol4, LList.Empty, "pregexp.scm", 696359), "pregexp.scm", 696348);
    Lit42 = Char.make(87);
    Lit40 = Char.make(119);
    Lit39 = Char.make(116);
    SimpleSymbol localSimpleSymbol5 = Lit17;
    SimpleSymbol localSimpleSymbol6 = (SimpleSymbol)new SimpleSymbol(":space").readResolve();
    Lit36 = localSimpleSymbol6;
    Lit38 = PairWithPosition.make(localSimpleSymbol5, PairWithPosition.make(localSimpleSymbol6, LList.Empty, "pregexp.scm", 684071), "pregexp.scm", 684060);
    Lit37 = Char.make(83);
    Lit35 = Char.make(115);
    Lit34 = Char.make(114);
    Lit33 = Char.make(110);
    SimpleSymbol localSimpleSymbol7 = Lit17;
    SimpleSymbol localSimpleSymbol8 = (SimpleSymbol)new SimpleSymbol(":digit").readResolve();
    Lit30 = localSimpleSymbol8;
    Lit32 = PairWithPosition.make(localSimpleSymbol7, PairWithPosition.make(localSimpleSymbol8, LList.Empty, "pregexp.scm", 667687), "pregexp.scm", 667676);
    Lit31 = Char.make(68);
    Lit29 = Char.make(100);
    Lit28 = (SimpleSymbol)new SimpleSymbol(":not-wbdry").readResolve();
    Lit27 = Char.make(66);
    Lit26 = (SimpleSymbol)new SimpleSymbol(":wbdry").readResolve();
    Lit25 = Char.make(98);
    Lit24 = Char.make(10);
    Lit23 = (SimpleSymbol)new SimpleSymbol(":empty").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("backslash").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("pregexp-read-piece").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol(":backref").readResolve();
    Lit16 = IntNum.make(2);
    Lit12 = (SimpleSymbol)new SimpleSymbol(":eos").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol(":bos").readResolve();
    Lit8 = IntNum.make(1);
    Lit5 = (SimpleSymbol)new SimpleSymbol(":seq").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol(":or").readResolve();
    Lit3 = Char.make(32);
    Lit2 = Char.make(97);
    Lit1 = Char.make(59);
    Lit0 = IntNum.make(20050502);
    $instance = new pregexp();
    pregexp localpregexp = $instance;
    ModuleMethod localModuleMethod1 = new ModuleMethod(localpregexp, 16, Lit117, 4097);
    localModuleMethod1.setProperty("source-location", "pregexp.scm:47");
    pregexp$Mnreverse$Ex = localModuleMethod1;
    ModuleMethod localModuleMethod2 = new ModuleMethod(localpregexp, 17, Lit118, -4096);
    localModuleMethod2.setProperty("source-location", "pregexp.scm:57");
    pregexp$Mnerror = localModuleMethod2;
    ModuleMethod localModuleMethod3 = new ModuleMethod(localpregexp, 18, Lit119, 12291);
    localModuleMethod3.setProperty("source-location", "pregexp.scm:65");
    pregexp$Mnread$Mnpattern = localModuleMethod3;
    ModuleMethod localModuleMethod4 = new ModuleMethod(localpregexp, 19, Lit120, 12291);
    localModuleMethod4.setProperty("source-location", "pregexp.scm:79");
    pregexp$Mnread$Mnbranch = localModuleMethod4;
    ModuleMethod localModuleMethod5 = new ModuleMethod(localpregexp, 20, Lit21, 12291);
    localModuleMethod5.setProperty("source-location", "pregexp.scm:91");
    pregexp$Mnread$Mnpiece = localModuleMethod5;
    ModuleMethod localModuleMethod6 = new ModuleMethod(localpregexp, 21, Lit121, 12291);
    localModuleMethod6.setProperty("source-location", "pregexp.scm:138");
    pregexp$Mnread$Mnescaped$Mnnumber = localModuleMethod6;
    ModuleMethod localModuleMethod7 = new ModuleMethod(localpregexp, 22, Lit122, 12291);
    localModuleMethod7.setProperty("source-location", "pregexp.scm:155");
    pregexp$Mnread$Mnescaped$Mnchar = localModuleMethod7;
    ModuleMethod localModuleMethod8 = new ModuleMethod(localpregexp, 23, Lit45, 12291);
    localModuleMethod8.setProperty("source-location", "pregexp.scm:174");
    pregexp$Mnread$Mnposix$Mnchar$Mnclass = localModuleMethod8;
    ModuleMethod localModuleMethod9 = new ModuleMethod(localpregexp, 24, Lit57, 12291);
    localModuleMethod9.setProperty("source-location", "pregexp.scm:200");
    pregexp$Mnread$Mncluster$Mntype = localModuleMethod9;
    ModuleMethod localModuleMethod10 = new ModuleMethod(localpregexp, 25, Lit64, 12291);
    localModuleMethod10.setProperty("source-location", "pregexp.scm:233");
    pregexp$Mnread$Mnsubpattern = localModuleMethod10;
    ModuleMethod localModuleMethod11 = new ModuleMethod(localpregexp, 26, Lit74, 12291);
    localModuleMethod11.setProperty("source-location", "pregexp.scm:254");
    pregexp$Mnwrap$Mnquantifier$Mnif$Mnany = localModuleMethod11;
    ModuleMethod localModuleMethod12 = new ModuleMethod(localpregexp, 27, Lit76, 12291);
    localModuleMethod12.setProperty("source-location", "pregexp.scm:300");
    pregexp$Mnread$Mnnums = localModuleMethod12;
    ModuleMethod localModuleMethod13 = new ModuleMethod(localpregexp, 28, Lit123, 4097);
    localModuleMethod13.setProperty("source-location", "pregexp.scm:323");
    pregexp$Mninvert$Mnchar$Mnlist = localModuleMethod13;
    ModuleMethod localModuleMethod14 = new ModuleMethod(localpregexp, 29, Lit80, 12291);
    localModuleMethod14.setProperty("source-location", "pregexp.scm:330");
    pregexp$Mnread$Mnchar$Mnlist = localModuleMethod14;
    ModuleMethod localModuleMethod15 = new ModuleMethod(localpregexp, 30, Lit124, 24582);
    localModuleMethod15.setProperty("source-location", "pregexp.scm:368");
    pregexp$Mnstring$Mnmatch = localModuleMethod15;
    ModuleMethod localModuleMethod16 = new ModuleMethod(localpregexp, 31, Lit125, 4097);
    localModuleMethod16.setProperty("source-location", "pregexp.scm:379");
    pregexp$Mnchar$Mnword$Qu = localModuleMethod16;
    ModuleMethod localModuleMethod17 = new ModuleMethod(localpregexp, 32, Lit126, 12291);
    localModuleMethod17.setProperty("source-location", "pregexp.scm:387");
    pregexp$Mnat$Mnword$Mnboundary$Qu = localModuleMethod17;
    ModuleMethod localModuleMethod18 = new ModuleMethod(localpregexp, 33, Lit99, 8194);
    localModuleMethod18.setProperty("source-location", "pregexp.scm:399");
    pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu = localModuleMethod18;
    ModuleMethod localModuleMethod19 = new ModuleMethod(localpregexp, 34, Lit127, 8194);
    localModuleMethod19.setProperty("source-location", "pregexp.scm:429");
    pregexp$Mnlist$Mnref = localModuleMethod19;
    ModuleMethod localModuleMethod20 = new ModuleMethod(localpregexp, 35, Lit128, 4097);
    localModuleMethod20.setProperty("source-location", "pregexp.scm:448");
    pregexp$Mnmake$Mnbackref$Mnlist = localModuleMethod20;
    ModuleMethod localModuleMethod21 = new ModuleMethod(localpregexp, 36, null, 0);
    localModuleMethod21.setProperty("source-location", "pregexp.scm:463");
    lambda$Fn1 = localModuleMethod21;
    ModuleMethod localModuleMethod22 = new ModuleMethod(localpregexp, 37, null, 0);
    localModuleMethod22.setProperty("source-location", "pregexp.scm:551");
    lambda$Fn6 = localModuleMethod22;
    ModuleMethod localModuleMethod23 = new ModuleMethod(localpregexp, 38, null, 0);
    localModuleMethod23.setProperty("source-location", "pregexp.scm:556");
    lambda$Fn7 = localModuleMethod23;
    ModuleMethod localModuleMethod24 = new ModuleMethod(localpregexp, 39, null, 0);
    localModuleMethod24.setProperty("source-location", "pregexp.scm:564");
    lambda$Fn8 = localModuleMethod24;
    ModuleMethod localModuleMethod25 = new ModuleMethod(localpregexp, 40, null, 0);
    localModuleMethod25.setProperty("source-location", "pregexp.scm:573");
    lambda$Fn9 = localModuleMethod25;
    ModuleMethod localModuleMethod26 = new ModuleMethod(localpregexp, 41, null, 0);
    localModuleMethod26.setProperty("source-location", "pregexp.scm:578");
    lambda$Fn10 = localModuleMethod26;
    ModuleMethod localModuleMethod27 = new ModuleMethod(localpregexp, 42, Lit101, 24582);
    localModuleMethod27.setProperty("source-location", "pregexp.scm:459");
    pregexp$Mnmatch$Mnpositions$Mnaux = localModuleMethod27;
    ModuleMethod localModuleMethod28 = new ModuleMethod(localpregexp, 43, Lit129, 16388);
    localModuleMethod28.setProperty("source-location", "pregexp.scm:639");
    pregexp$Mnreplace$Mnaux = localModuleMethod28;
    ModuleMethod localModuleMethod29 = new ModuleMethod(localpregexp, 44, Lit130, 4097);
    localModuleMethod29.setProperty("source-location", "pregexp.scm:665");
    pregexp = localModuleMethod29;
    ModuleMethod localModuleMethod30 = new ModuleMethod(localpregexp, 45, Lit114, -4094);
    localModuleMethod30.setProperty("source-location", "pregexp.scm:670");
    pregexp$Mnmatch$Mnpositions = localModuleMethod30;
    ModuleMethod localModuleMethod31 = new ModuleMethod(localpregexp, 46, Lit131, -4094);
    localModuleMethod31.setProperty("source-location", "pregexp.scm:690");
    pregexp$Mnmatch = localModuleMethod31;
    ModuleMethod localModuleMethod32 = new ModuleMethod(localpregexp, 47, Lit132, 8194);
    localModuleMethod32.setProperty("source-location", "pregexp.scm:700");
    pregexp$Mnsplit = localModuleMethod32;
    ModuleMethod localModuleMethod33 = new ModuleMethod(localpregexp, 48, Lit133, 12291);
    localModuleMethod33.setProperty("source-location", "pregexp.scm:723");
    pregexp$Mnreplace = localModuleMethod33;
    ModuleMethod localModuleMethod34 = new ModuleMethod(localpregexp, 49, Lit134, 12291);
    localModuleMethod34.setProperty("source-location", "pregexp.scm:736");
    pregexp$Mnreplace$St = localModuleMethod34;
    ModuleMethod localModuleMethod35 = new ModuleMethod(localpregexp, 50, Lit135, 4097);
    localModuleMethod35.setProperty("source-location", "pregexp.scm:764");
    pregexp$Mnquote = localModuleMethod35;
    $instance.run();
  }
  
  public pregexp()
  {
    ModuleInfo.register(this);
  }
  
  /* Error */
  public static Object isPregexpAtWordBoundary(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 870	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   3: aload_1
    //   4: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   7: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   10: astore_3
    //   11: aload_3
    //   12: checkcast 371	java/lang/Boolean
    //   15: invokevirtual 880	java/lang/Boolean:booleanValue	()Z
    //   18: istore 5
    //   20: iload 5
    //   22: ifeq +16 -> 38
    //   25: iload 5
    //   27: ifeq +7 -> 34
    //   30: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   33: areturn
    //   34: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   37: areturn
    //   38: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   46: astore 6
    //   48: aload 6
    //   50: checkcast 371	java/lang/Boolean
    //   53: invokevirtual 880	java/lang/Boolean:booleanValue	()Z
    //   56: istore 8
    //   58: iload 8
    //   60: ifeq +16 -> 76
    //   63: iload 8
    //   65: ifeq +7 -> 72
    //   68: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   71: areturn
    //   72: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   75: areturn
    //   76: aload_0
    //   77: checkcast 888	java/lang/CharSequence
    //   80: astore 10
    //   82: aload_1
    //   83: checkcast 890	java/lang/Number
    //   86: invokevirtual 894	java/lang/Number:intValue	()I
    //   89: istore 12
    //   91: aload 10
    //   93: iload 12
    //   95: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   98: istore 13
    //   100: aload_0
    //   101: checkcast 888	java/lang/CharSequence
    //   104: astore 15
    //   106: getstatic 906	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   109: aload_1
    //   110: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   113: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   116: astore 16
    //   118: aload 16
    //   120: checkcast 890	java/lang/Number
    //   123: invokevirtual 894	java/lang/Number:intValue	()I
    //   126: istore 18
    //   128: aload 15
    //   130: iload 18
    //   132: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   135: istore 19
    //   137: iload 13
    //   139: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   142: getstatic 596	gnu/kawa/slib/pregexp:Lit41	Lgnu/mapping/SimpleSymbol;
    //   145: invokestatic 909	gnu/kawa/slib/pregexp:isPregexpCheckIfInCharClass	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   148: astore 20
    //   150: iload 19
    //   152: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   155: getstatic 596	gnu/kawa/slib/pregexp:Lit41	Lgnu/mapping/SimpleSymbol;
    //   158: invokestatic 909	gnu/kawa/slib/pregexp:isPregexpCheckIfInCharClass	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: astore 21
    //   163: aload 20
    //   165: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   168: if_acmpeq +39 -> 207
    //   171: aload 21
    //   173: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   176: if_acmpeq +23 -> 199
    //   179: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   182: astore 27
    //   184: aload 27
    //   186: astore 22
    //   188: aload 22
    //   190: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   193: if_acmpeq +21 -> 214
    //   196: aload 22
    //   198: areturn
    //   199: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   202: astore 27
    //   204: goto -20 -> 184
    //   207: aload 20
    //   209: astore 22
    //   211: goto -23 -> 188
    //   214: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   217: astore 24
    //   219: aload 20
    //   221: aload 24
    //   223: if_acmpeq +22 -> 245
    //   226: iconst_1
    //   227: istore 25
    //   229: iconst_1
    //   230: iload 25
    //   232: iconst_1
    //   233: iadd
    //   234: iand
    //   235: istore 26
    //   237: iload 26
    //   239: ifeq +12 -> 251
    //   242: aload 21
    //   244: areturn
    //   245: iconst_0
    //   246: istore 25
    //   248: goto -19 -> 229
    //   251: iload 26
    //   253: ifeq +7 -> 260
    //   256: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   259: areturn
    //   260: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   263: areturn
    //   264: astore 4
    //   266: new 911	gnu/mapping/WrongType
    //   269: dup
    //   270: aload 4
    //   272: ldc_w 913
    //   275: bipush 254
    //   277: aload_3
    //   278: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   281: athrow
    //   282: astore 7
    //   284: new 911	gnu/mapping/WrongType
    //   287: dup
    //   288: aload 7
    //   290: ldc_w 913
    //   293: bipush 254
    //   295: aload 6
    //   297: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   300: athrow
    //   301: astore 9
    //   303: new 911	gnu/mapping/WrongType
    //   306: dup
    //   307: aload 9
    //   309: ldc_w 918
    //   312: iconst_1
    //   313: aload_0
    //   314: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   317: athrow
    //   318: astore 11
    //   320: new 911	gnu/mapping/WrongType
    //   323: dup
    //   324: aload 11
    //   326: ldc_w 918
    //   329: iconst_2
    //   330: aload_1
    //   331: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   334: athrow
    //   335: astore 14
    //   337: new 911	gnu/mapping/WrongType
    //   340: dup
    //   341: aload 14
    //   343: ldc_w 918
    //   346: iconst_1
    //   347: aload_0
    //   348: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   351: athrow
    //   352: astore 17
    //   354: new 911	gnu/mapping/WrongType
    //   357: dup
    //   358: aload 17
    //   360: ldc_w 918
    //   363: iconst_2
    //   364: aload 16
    //   366: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   369: athrow
    //   370: astore 23
    //   372: new 911	gnu/mapping/WrongType
    //   375: dup
    //   376: aload 23
    //   378: ldc_w 913
    //   381: bipush 254
    //   383: aload 20
    //   385: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   388: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	paramObject1	Object
    //   0	389	1	paramObject2	Object
    //   0	389	2	paramObject3	Object
    //   10	268	3	localObject1	Object
    //   264	7	4	localClassCastException1	ClassCastException
    //   18	8	5	bool1	boolean
    //   46	250	6	localObject2	Object
    //   282	7	7	localClassCastException2	ClassCastException
    //   56	8	8	bool2	boolean
    //   301	7	9	localClassCastException3	ClassCastException
    //   80	12	10	localCharSequence1	CharSequence
    //   318	7	11	localClassCastException4	ClassCastException
    //   89	5	12	i	int
    //   98	40	13	j	int
    //   335	7	14	localClassCastException5	ClassCastException
    //   104	25	15	localCharSequence2	CharSequence
    //   116	249	16	localObject3	Object
    //   352	7	17	localClassCastException6	ClassCastException
    //   126	5	18	k	int
    //   135	16	19	m	int
    //   148	236	20	localObject4	Object
    //   161	82	21	localObject5	Object
    //   186	24	22	localObject6	Object
    //   370	7	23	localClassCastException7	ClassCastException
    //   217	5	24	localBoolean1	Boolean
    //   227	20	25	n	int
    //   235	17	26	i1	int
    //   182	21	27	localBoolean2	Boolean
    // Exception table:
    //   from	to	target	type
    //   11	20	264	java/lang/ClassCastException
    //   48	58	282	java/lang/ClassCastException
    //   76	82	301	java/lang/ClassCastException
    //   82	91	318	java/lang/ClassCastException
    //   100	106	335	java/lang/ClassCastException
    //   118	128	352	java/lang/ClassCastException
    //   214	219	370	java/lang/ClassCastException
  }
  
  public static boolean isPregexpCharWord(Object paramObject)
  {
    try
    {
      Char localChar1 = (Char)paramObject;
      bool = unicode.isCharAlphabetic(localChar1);
      if (!bool) {
        break label16;
      }
    }
    catch (ClassCastException localClassCastException1)
    {
      try
      {
        boolean bool;
        label16:
        do
        {
          Char localChar2 = (Char)paramObject;
          bool = unicode.isCharNumeric(localChar2);
        } while (bool);
      }
      catch (ClassCastException localClassCastException2)
      {
        Char localChar3;
        throw new WrongType(localClassCastException2, "char-numeric?", 1, paramObject);
      }
      try
      {
        localChar3 = (Char)paramObject;
        return characters.isChar$Eq(localChar3, Lit84);
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "char=?", 1, paramObject);
      }
      localClassCastException1 = localClassCastException1;
      throw new WrongType(localClassCastException1, "char-alphabetic?", 1, paramObject);
    }
    return bool;
  }
  
  public static Object isPregexpCheckIfInCharClass(Object paramObject1, Object paramObject2)
  {
    if (Scheme.isEqv.apply2(paramObject2, Lit14) != Boolean.FALSE) {}
    try
    {
      Char localChar30 = (Char)paramObject1;
      if (characters.isChar$Eq(localChar30, Lit24)) {
        return Boolean.FALSE;
      }
      return Boolean.TRUE;
    }
    catch (ClassCastException localClassCastException30)
    {
      throw new WrongType(localClassCastException30, "char=?", 1, paramObject1);
    }
    if (Scheme.isEqv.apply2(paramObject2, Lit85) != Boolean.FALSE) {}
    try
    {
      Char localChar28 = (Char)paramObject1;
      boolean bool10 = unicode.isCharAlphabetic(localChar28);
      if (bool10)
      {
        if (bool10) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
    }
    catch (ClassCastException localClassCastException28)
    {
      Char localChar29;
      throw new WrongType(localClassCastException28, "char-alphabetic?", 1, paramObject1);
    }
    try
    {
      localChar29 = (Char)paramObject1;
      if (unicode.isCharNumeric(localChar29)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException29)
    {
      throw new WrongType(localClassCastException29, "char-numeric?", 1, paramObject1);
    }
    if (Scheme.isEqv.apply2(paramObject2, Lit86) != Boolean.FALSE) {}
    try
    {
      Char localChar27 = (Char)paramObject1;
      if (unicode.isCharAlphabetic(localChar27)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException27)
    {
      throw new WrongType(localClassCastException27, "char-alphabetic?", 1, paramObject1);
    }
    if (Scheme.isEqv.apply2(paramObject2, Lit87) != Boolean.FALSE) {}
    try
    {
      Char localChar26 = (Char)paramObject1;
      if (characters.char$To$Integer(localChar26) < 128) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException26)
    {
      throw new WrongType(localClassCastException26, "char->integer", 1, paramObject1);
    }
    if (Scheme.isEqv.apply2(paramObject2, Lit88) != Boolean.FALSE) {}
    try
    {
      Char localChar23 = (Char)paramObject1;
      boolean bool9 = characters.isChar$Eq(localChar23, Lit3);
      if (bool9)
      {
        if (bool9) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
    }
    catch (ClassCastException localClassCastException23)
    {
      Char localChar24;
      Char localChar25;
      throw new WrongType(localClassCastException23, "char=?", 1, paramObject1);
    }
    try
    {
      localChar24 = (Char)paramObject1;
      localObject = $Stpregexp$Mntab$Mnchar$St;
    }
    catch (ClassCastException localClassCastException24)
    {
      throw new WrongType(localClassCastException24, "char=?", 1, paramObject1);
    }
    try
    {
      localChar25 = (Char)localObject;
      if (characters.isChar$Eq(localChar24, localChar25)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException25)
    {
      throw new WrongType(localClassCastException25, "char=?", 2, localObject);
    }
    if (Scheme.isEqv.apply2(paramObject2, Lit89) != Boolean.FALSE) {}
    try
    {
      Char localChar22 = (Char)paramObject1;
      if (characters.char$To$Integer(localChar22) < 32) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException22)
    {
      throw new WrongType(localClassCastException22, "char->integer", 1, paramObject1);
    }
    if (Scheme.isEqv.apply2(paramObject2, Lit30) != Boolean.FALSE) {}
    try
    {
      Char localChar21 = (Char)paramObject1;
      if (unicode.isCharNumeric(localChar21)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException21)
    {
      throw new WrongType(localClassCastException21, "char-numeric?", 1, paramObject1);
    }
    if (Scheme.isEqv.apply2(paramObject2, Lit90) != Boolean.FALSE) {}
    try
    {
      Char localChar19 = (Char)paramObject1;
      int n = characters.char$To$Integer(localChar19);
      i1 = 0;
      if (n >= 32) {
        i1 = 1;
      }
      if (i1 == 0) {}
    }
    catch (ClassCastException localClassCastException19)
    {
      int i1;
      Char localChar20;
      throw new WrongType(localClassCastException19, "char->integer", 1, paramObject1);
    }
    try
    {
      localChar20 = (Char)paramObject1;
      if (unicode.isCharWhitespace(localChar20)) {
        return Boolean.FALSE;
      }
      return Boolean.TRUE;
    }
    catch (ClassCastException localClassCastException20)
    {
      throw new WrongType(localClassCastException20, "char-whitespace?", 1, paramObject1);
    }
    if (i1 != 0) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    if (Scheme.isEqv.apply2(paramObject2, Lit91) != Boolean.FALSE) {}
    try
    {
      Char localChar18 = (Char)paramObject1;
      if (unicode.isCharLowerCase(localChar18)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException18)
    {
      throw new WrongType(localClassCastException18, "char-lower-case?", 1, paramObject1);
    }
    if (Scheme.isEqv.apply2(paramObject2, Lit92) != Boolean.FALSE) {}
    try
    {
      Char localChar17 = (Char)paramObject1;
      if (characters.char$To$Integer(localChar17) >= 32) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException17)
    {
      throw new WrongType(localClassCastException17, "char->integer", 1, paramObject1);
    }
    if (Scheme.isEqv.apply2(paramObject2, Lit93) != Boolean.FALSE) {}
    try
    {
      Char localChar13 = (Char)paramObject1;
      int i = characters.char$To$Integer(localChar13);
      j = 0;
      if (i >= 32) {
        j = 1;
      }
      if (j == 0) {}
    }
    catch (ClassCastException localClassCastException13)
    {
      int j;
      Char localChar14;
      int k;
      Char localChar15;
      int m;
      Char localChar16;
      throw new WrongType(localClassCastException13, "char->integer", 1, paramObject1);
    }
    try
    {
      localChar14 = (Char)paramObject1;
      k = 0x1 & true + unicode.isCharWhitespace(localChar14);
      if (k == 0) {}
    }
    catch (ClassCastException localClassCastException14)
    {
      throw new WrongType(localClassCastException14, "char-whitespace?", 1, paramObject1);
    }
    try
    {
      localChar15 = (Char)paramObject1;
      m = 0x1 & true + unicode.isCharAlphabetic(localChar15);
      if (m == 0) {}
    }
    catch (ClassCastException localClassCastException15)
    {
      throw new WrongType(localClassCastException15, "char-alphabetic?", 1, paramObject1);
    }
    try
    {
      localChar16 = (Char)paramObject1;
      if (unicode.isCharNumeric(localChar16)) {
        return Boolean.FALSE;
      }
      return Boolean.TRUE;
    }
    catch (ClassCastException localClassCastException16)
    {
      throw new WrongType(localClassCastException16, "char-numeric?", 1, paramObject1);
    }
    if (m != 0) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    if (k != 0) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    if (j != 0) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    if (Scheme.isEqv.apply2(paramObject2, Lit36) != Boolean.FALSE) {}
    try
    {
      Char localChar12 = (Char)paramObject1;
      if (unicode.isCharWhitespace(localChar12)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException12)
    {
      throw new WrongType(localClassCastException12, "char-whitespace?", 1, paramObject1);
    }
    if (Scheme.isEqv.apply2(paramObject2, Lit94) != Boolean.FALSE) {}
    try
    {
      Char localChar11 = (Char)paramObject1;
      if (unicode.isCharUpperCase(localChar11)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException11)
    {
      throw new WrongType(localClassCastException11, "char-upper-case?", 1, paramObject1);
    }
    if (Scheme.isEqv.apply2(paramObject2, Lit41) != Boolean.FALSE) {}
    try
    {
      Char localChar8 = (Char)paramObject1;
      boolean bool7 = unicode.isCharAlphabetic(localChar8);
      if (bool7)
      {
        if (bool7) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
    }
    catch (ClassCastException localClassCastException8)
    {
      Char localChar9;
      boolean bool8;
      Char localChar10;
      throw new WrongType(localClassCastException8, "char-alphabetic?", 1, paramObject1);
    }
    try
    {
      localChar9 = (Char)paramObject1;
      bool8 = unicode.isCharNumeric(localChar9);
      if (bool8)
      {
        if (bool8) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
    }
    catch (ClassCastException localClassCastException9)
    {
      throw new WrongType(localClassCastException9, "char-numeric?", 1, paramObject1);
    }
    try
    {
      localChar10 = (Char)paramObject1;
      if (characters.isChar$Eq(localChar10, Lit84)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException10)
    {
      throw new WrongType(localClassCastException10, "char=?", 1, paramObject1);
    }
    if (Scheme.isEqv.apply2(paramObject2, Lit95) != Boolean.FALSE) {}
    try
    {
      Char localChar1 = (Char)paramObject1;
      boolean bool1 = unicode.isCharNumeric(localChar1);
      if (bool1)
      {
        if (bool1) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
    }
    catch (ClassCastException localClassCastException1)
    {
      Char localChar2;
      boolean bool2;
      Char localChar3;
      boolean bool3;
      Char localChar4;
      boolean bool4;
      Char localChar5;
      boolean bool5;
      Char localChar6;
      boolean bool6;
      Char localChar7;
      Object[] arrayOfObject;
      throw new WrongType(localClassCastException1, "char-numeric?", 1, paramObject1);
    }
    try
    {
      localChar2 = (Char)paramObject1;
      bool2 = unicode.isCharCi$Eq(localChar2, Lit2);
      if (bool2)
      {
        if (bool2) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "char-ci=?", 1, paramObject1);
    }
    try
    {
      localChar3 = (Char)paramObject1;
      bool3 = unicode.isCharCi$Eq(localChar3, Lit25);
      if (bool3)
      {
        if (bool3) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "char-ci=?", 1, paramObject1);
    }
    try
    {
      localChar4 = (Char)paramObject1;
      bool4 = unicode.isCharCi$Eq(localChar4, Lit96);
      if (bool4)
      {
        if (bool4) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "char-ci=?", 1, paramObject1);
    }
    try
    {
      localChar5 = (Char)paramObject1;
      bool5 = unicode.isCharCi$Eq(localChar5, Lit29);
      if (bool5)
      {
        if (bool5) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "char-ci=?", 1, paramObject1);
    }
    try
    {
      localChar6 = (Char)paramObject1;
      bool6 = unicode.isCharCi$Eq(localChar6, Lit97);
      if (bool6)
      {
        if (bool6) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
    }
    catch (ClassCastException localClassCastException6)
    {
      throw new WrongType(localClassCastException6, "char-ci=?", 1, paramObject1);
    }
    try
    {
      localChar7 = (Char)paramObject1;
      if (unicode.isCharCi$Eq(localChar7, Lit98)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException7)
    {
      throw new WrongType(localClassCastException7, "char-ci=?", 1, paramObject1);
    }
    arrayOfObject = new Object[1];
    arrayOfObject[0] = Lit99;
    return pregexpError$V(arrayOfObject);
  }
  
  public static Object lambda1sub(Object paramObject)
  {
    if (lists.isPair(paramObject))
    {
      Object localObject1 = lists.car.apply1(paramObject);
      Object localObject2 = lambda1sub(lists.cdr.apply1(paramObject));
      if (Scheme.isEqv.apply2(localObject1, Lit100) != Boolean.FALSE) {
        return lists.cons(lists.cons(paramObject, Boolean.FALSE), localObject2);
      }
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = lambda1sub(localObject1);
      arrayOfObject[1] = localObject2;
      return append.append$V(arrayOfObject);
    }
    return LList.Empty;
  }
  
  public static Pair pregexp(Object paramObject)
  {
    $Stpregexp$Mnspace$Mnsensitive$Qu$St = Boolean.TRUE;
    SimpleSymbol localSimpleSymbol = Lit100;
    GenericProc localGenericProc = lists.car;
    IntNum localIntNum = Lit73;
    try
    {
      CharSequence localCharSequence = (CharSequence)paramObject;
      return LList.list2(localSimpleSymbol, localGenericProc.apply1(pregexpReadPattern(paramObject, localIntNum, Integer.valueOf(strings.stringLength(localCharSequence)))));
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "string-length", 1, paramObject);
    }
  }
  
  public static Object pregexpError$V(Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    ports.display("Error:");
    Object localObject1 = localLList;
    for (;;)
    {
      if (localObject1 == LList.Empty)
      {
        ports.newline();
        return misc.error$V("pregexp-error", new Object[0]);
      }
      try
      {
        Pair localPair = (Pair)localObject1;
        Object localObject2 = localPair.getCar();
        ports.display(Lit3);
        ports.write(localObject2);
        localObject1 = localPair.getCdr();
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject1);
      }
    }
  }
  
  public static Object pregexpInvertCharList(Object paramObject)
  {
    Object localObject = lists.car.apply1(paramObject);
    try
    {
      Pair localPair = (Pair)localObject;
      lists.setCar$Ex(localPair, Lit79);
      return paramObject;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "set-car!", 1, localObject);
    }
  }
  
  public static Object pregexpListRef(Object paramObject1, Object paramObject2)
  {
    for (Object localObject = Lit73;; localObject = AddOp.$Pl.apply2(localObject, Lit8))
    {
      if (lists.isNull(paramObject1)) {
        return Boolean.FALSE;
      }
      if (Scheme.numEqu.apply2(localObject, paramObject2) != Boolean.FALSE) {
        return lists.car.apply1(paramObject1);
      }
      paramObject1 = lists.cdr.apply1(paramObject1);
    }
  }
  
  public static Object pregexpMakeBackrefList(Object paramObject)
  {
    return lambda1sub(paramObject);
  }
  
  public static Object pregexpMatch$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    Object localObject1 = Scheme.apply.apply4(pregexp$Mnmatch$Mnpositions, paramObject1, paramObject2, localLList);
    Object localObject2;
    Object localObject3;
    if (localObject1 != Boolean.FALSE)
    {
      localObject2 = LList.Empty;
      localObject3 = localObject1;
    }
    for (;;)
    {
      if (localObject3 == LList.Empty)
      {
        localObject1 = LList.reverseInPlace(localObject2);
        return localObject1;
      }
      try
      {
        Pair localPair = (Pair)localObject3;
        localObject4 = localPair.getCdr();
        localObject5 = localPair.getCar();
        if (localObject5 == Boolean.FALSE) {}
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          localCharSequence = (CharSequence)paramObject2;
          localObject6 = lists.car.apply1(localObject5);
        }
        catch (ClassCastException localClassCastException2)
        {
          Object localObject4;
          Object localObject5;
          CharSequence localCharSequence;
          int i;
          int j;
          throw new WrongType(localClassCastException2, "substring", 1, paramObject2);
        }
        try
        {
          i = ((Number)localObject6).intValue();
          localObject7 = lists.cdr.apply1(localObject5);
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "substring", 2, localObject6);
        }
        try
        {
          j = ((Number)localObject7).intValue();
          localObject5 = strings.substring(localCharSequence, i, j);
          localObject2 = Pair.make(localObject5, localObject2);
          localObject3 = localObject4;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "substring", 3, localObject7);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "arg0", -2, localObject3);
      }
    }
  }
  
  public static Object pregexpMatchPositions$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    if (strings.isString(paramObject1)) {
      paramObject1 = pregexp(paramObject1);
    }
    try
    {
      CharSequence localCharSequence = (CharSequence)paramObject2;
      i = strings.stringLength(localCharSequence);
      if (lists.isNull(localLList))
      {
        localObject1 = Lit73;
        if (!lists.isNull(localLList)) {
          break label189;
        }
        localObject3 = Integer.valueOf(i);
        localObject4 = localObject1;
        localObject5 = Scheme.numLEq.apply2(localObject4, localObject3);
      }
    }
    catch (ClassCastException localClassCastException1)
    {
      try
      {
        boolean bool;
        for (;;)
        {
          int i;
          Object localObject1;
          bool = ((Boolean)localObject5).booleanValue();
          if (!bool) {
            break;
          }
          Integer localInteger = Integer.valueOf(i);
          Object localObject6 = pregexpMatchPositionsAux(paramObject1, paramObject2, localInteger, localObject1, localObject3, localObject4);
          if (localObject6 != Boolean.FALSE)
          {
            return localObject6;
            if (lists.isPair(paramObject1)) {
              continue;
            }
            Object[] arrayOfObject = new Object[3];
            arrayOfObject[0] = Lit114;
            arrayOfObject[1] = Lit115;
            arrayOfObject[2] = paramObject1;
            pregexpError$V(arrayOfObject);
            continue;
            localObject1 = lists.car.apply1(localLList);
            localObject2 = lists.cdr.apply1(localLList);
          }
          try
          {
            localLList = (LList)localObject2;
          }
          catch (ClassCastException localClassCastException2)
          {
            label189:
            throw new WrongType(localClassCastException2, "opt-args", -2, localObject2);
          }
          Object localObject3 = lists.car.apply1(localLList);
          continue;
          Object localObject4 = AddOp.$Pl.apply2(localObject4, Lit8);
        }
        if (bool) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException3)
      {
        Object localObject5;
        Object localObject2;
        throw new WrongType(localClassCastException3, "x", -2, localObject5);
      }
      localClassCastException1 = localClassCastException1;
      throw new WrongType(localClassCastException1, "string-length", 1, paramObject2);
    }
  }
  
  public static Object pregexpMatchPositionsAux(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    frame localframe = new frame();
    localframe.s = paramObject2;
    localframe.sn = paramObject3;
    localframe.start = paramObject4;
    localframe.n = paramObject5;
    Procedure localProcedure = localframe.identity;
    Object localObject1 = pregexpMakeBackrefList(paramObject1);
    localframe.case$Mnsensitive$Qu = Boolean.TRUE;
    localframe.backrefs = localObject1;
    localframe.identity = localProcedure;
    localframe.lambda3sub(paramObject1, paramObject6, localframe.identity, lambda$Fn1);
    localObject2 = localframe.backrefs;
    Object localObject3 = LList.Empty;
    for (;;)
    {
      Object localObject5;
      if (localObject2 == LList.Empty)
      {
        LList localLList = LList.reverseInPlace(localObject3);
        localObject5 = lists.car.apply1(localLList);
        if (localObject5 == Boolean.FALSE) {
          break label173;
        }
        return localLList;
      }
      try
      {
        Pair localPair = (Pair)localObject2;
        Object localObject4 = localPair.getCdr();
        localObject3 = Pair.make(lists.cdr.apply1(localPair.getCar()), localObject3);
        localObject2 = localObject4;
      }
      catch (ClassCastException localClassCastException)
      {
        label173:
        throw new WrongType(localClassCastException, "arg0", -2, localObject2);
      }
    }
    return localObject5;
  }
  
  /* Error */
  public static Object pregexpQuote(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 888	java/lang/CharSequence
    //   4: astore_2
    //   5: iconst_m1
    //   6: aload_2
    //   7: invokestatic 1014	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   10: iadd
    //   11: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   14: astore_3
    //   15: getstatic 316	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   18: astore 4
    //   20: getstatic 1145	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   23: aload_3
    //   24: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   27: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   30: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   33: if_acmpeq +16 -> 49
    //   36: aload 4
    //   38: checkcast 312	gnu/lists/LList
    //   41: astore 13
    //   43: aload 13
    //   45: invokestatic 1149	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   48: areturn
    //   49: getstatic 906	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   52: aload_3
    //   53: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   56: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: astore 5
    //   61: aload_0
    //   62: checkcast 888	java/lang/CharSequence
    //   65: astore 7
    //   67: aload_3
    //   68: checkcast 890	java/lang/Number
    //   71: invokevirtual 894	java/lang/Number:intValue	()I
    //   74: istore 9
    //   76: aload 7
    //   78: iload 9
    //   80: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   83: istore 10
    //   85: iload 10
    //   87: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   90: getstatic 339	gnu/kawa/slib/pregexp:Lit116	Lgnu/lists/PairWithPosition;
    //   93: invokestatic 1152	kawa/lib/lists:memv	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   96: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   99: if_acmpeq +31 -> 130
    //   102: getstatic 284	gnu/kawa/slib/pregexp:Lit19	Lgnu/text/Char;
    //   105: iload 10
    //   107: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   110: aload 4
    //   112: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   115: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   118: astore 11
    //   120: aload 11
    //   122: astore 4
    //   124: aload 5
    //   126: astore_3
    //   127: goto -107 -> 20
    //   130: iload 10
    //   132: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   135: aload 4
    //   137: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   140: astore 11
    //   142: goto -22 -> 120
    //   145: astore_1
    //   146: new 911	gnu/mapping/WrongType
    //   149: dup
    //   150: aload_1
    //   151: ldc_w 1028
    //   154: iconst_1
    //   155: aload_0
    //   156: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   159: athrow
    //   160: astore 12
    //   162: new 911	gnu/mapping/WrongType
    //   165: dup
    //   166: aload 12
    //   168: ldc_w 1154
    //   171: iconst_1
    //   172: aload 4
    //   174: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   177: athrow
    //   178: astore 6
    //   180: new 911	gnu/mapping/WrongType
    //   183: dup
    //   184: aload 6
    //   186: ldc_w 918
    //   189: iconst_1
    //   190: aload_0
    //   191: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   194: athrow
    //   195: astore 8
    //   197: new 911	gnu/mapping/WrongType
    //   200: dup
    //   201: aload 8
    //   203: ldc_w 918
    //   206: iconst_2
    //   207: aload_3
    //   208: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   211: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	paramObject	Object
    //   145	6	1	localClassCastException1	ClassCastException
    //   4	3	2	localCharSequence1	CharSequence
    //   14	194	3	localObject1	Object
    //   18	155	4	localObject2	Object
    //   59	66	5	localObject3	Object
    //   178	7	6	localClassCastException2	ClassCastException
    //   65	12	7	localCharSequence2	CharSequence
    //   195	7	8	localClassCastException3	ClassCastException
    //   74	5	9	i	int
    //   83	48	10	j	int
    //   118	23	11	localPair	Pair
    //   160	7	12	localClassCastException4	ClassCastException
    //   41	3	13	localLList	LList
    // Exception table:
    //   from	to	target	type
    //   0	5	145	java/lang/ClassCastException
    //   36	43	160	java/lang/ClassCastException
    //   61	67	178	java/lang/ClassCastException
    //   67	76	195	java/lang/ClassCastException
  }
  
  public static Object pregexpReadBranch(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject1 = LList.Empty;
    for (;;)
    {
      if (Scheme.numGEq.apply2(paramObject2, paramObject3) != Boolean.FALSE) {
        return LList.list2(lists.cons(Lit5, pregexpReverse$Ex(localObject1)), paramObject2);
      }
      try
      {
        localCharSequence = (CharSequence)paramObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          CharSequence localCharSequence;
          int i = ((Number)paramObject2).intValue();
          int j = strings.stringRef(localCharSequence, i);
          boolean bool = characters.isChar$Eq(Char.make(j), Lit7);
          if (bool)
          {
            if (!bool) {}
          }
          else {
            while (characters.isChar$Eq(Char.make(j), Lit6)) {
              return LList.list2(lists.cons(Lit5, pregexpReverse$Ex(localObject1)), paramObject2);
            }
          }
          Object localObject2 = pregexpReadPiece(paramObject1, paramObject2, paramObject3);
          localObject1 = lists.cons(lists.car.apply1(localObject2), localObject1);
          paramObject2 = lists.cadr.apply1(localObject2);
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-ref", 2, paramObject2);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "string-ref", 1, paramObject1);
      }
    }
  }
  
  public static Object pregexpReadCharList(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject1 = LList.Empty;
    for (;;)
    {
      if (Scheme.numGEq.apply2(paramObject2, paramObject3) != Boolean.FALSE)
      {
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = Lit80;
        arrayOfObject2[1] = Lit81;
        return pregexpError$V(arrayOfObject2);
      }
      for (;;)
      {
        for (;;)
        {
          Object localObject4;
          Object localObject5;
          Object localObject7;
          for (;;)
          {
            try
            {
              localCharSequence1 = (CharSequence)paramObject1;
            }
            catch (ClassCastException localClassCastException1)
            {
              CharSequence localCharSequence1;
              int i;
              int j;
              boolean bool2;
              CharSequence localCharSequence4;
              int n;
              Object localObject6;
              SimpleSymbol localSimpleSymbol;
              CharSequence localCharSequence3;
              int m;
              CharSequence localCharSequence2;
              int k;
              Object localObject3;
              throw new WrongType(localClassCastException1, "string-ref", 1, paramObject1);
            }
            try
            {
              i = ((Number)paramObject2).intValue();
              j = strings.stringRef(localCharSequence1, i);
              if (Scheme.isEqv.apply2(Char.make(j), Lit46) != Boolean.FALSE)
              {
                if (lists.isNull(localObject1))
                {
                  localObject1 = lists.cons(Char.make(j), localObject1);
                  paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
                  break;
                }
                return LList.list2(lists.cons(Lit82, pregexpReverse$Ex(localObject1)), AddOp.$Pl.apply2(paramObject2, Lit8));
              }
              if (Scheme.isEqv.apply2(Char.make(j), Lit19) != Boolean.FALSE)
              {
                Object localObject8 = pregexpReadEscapedChar(paramObject1, paramObject2, paramObject3);
                if (localObject8 != Boolean.FALSE)
                {
                  localObject1 = lists.cons(lists.car.apply1(localObject8), localObject1);
                  paramObject2 = lists.cadr.apply1(localObject8);
                  break;
                }
                Object[] arrayOfObject1 = new Object[2];
                arrayOfObject1[0] = Lit80;
                arrayOfObject1[1] = Lit22;
                return pregexpError$V(arrayOfObject1);
              }
              if (Scheme.isEqv.apply2(Char.make(j), Lit58) != Boolean.FALSE)
              {
                boolean bool1 = lists.isNull(localObject1);
                if (bool1)
                {
                  if (!bool1) {
                    continue;
                  }
                  localObject1 = lists.cons(Char.make(j), localObject1);
                  paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
                  break;
                }
                localObject4 = AddOp.$Pl.apply2(paramObject2, Lit8);
                localObject5 = Scheme.numLss.apply2(localObject4, paramObject3);
              }
            }
            catch (ClassCastException localClassCastException2)
            {
              throw new WrongType(localClassCastException2, "string-ref", 2, paramObject2);
            }
          }
          try
          {
            bool2 = ((Boolean)localObject5).booleanValue();
            if (!bool2) {}
          }
          catch (ClassCastException localClassCastException5)
          {
            throw new WrongType(localClassCastException5, "x", -2, localObject5);
          }
          try
          {
            localCharSequence4 = (CharSequence)paramObject1;
          }
          catch (ClassCastException localClassCastException8)
          {
            throw new WrongType(localClassCastException8, "string-ref", 1, paramObject1);
          }
          try
          {
            n = ((Number)localObject4).intValue();
            if (characters.isChar$Eq(Char.make(strings.stringRef(localCharSequence4, n)), Lit46)) {
              continue;
            }
            localObject6 = lists.car.apply1(localObject1);
            if (characters.isChar(localObject6)) {
              localSimpleSymbol = Lit83;
            }
          }
          catch (ClassCastException localClassCastException9)
          {
            throw new WrongType(localClassCastException9, "string-ref", 2, localObject4);
          }
          try
          {
            localCharSequence3 = (CharSequence)paramObject1;
            localObject7 = AddOp.$Pl.apply2(paramObject2, Lit8);
          }
          catch (ClassCastException localClassCastException6)
          {
            throw new WrongType(localClassCastException6, "string-ref", 1, paramObject1);
          }
          try
          {
            m = ((Number)localObject7).intValue();
            localObject1 = lists.cons(LList.list3(localSimpleSymbol, localObject6, Char.make(strings.stringRef(localCharSequence3, m))), lists.cdr.apply1(localObject1));
            paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit16);
          }
          catch (ClassCastException localClassCastException7)
          {
            throw new WrongType(localClassCastException7, "string-ref", 2, localObject7);
          }
        }
        if (!bool2) {}
      }
      localObject1 = lists.cons(Char.make(j), localObject1);
      paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
      continue;
      if (Scheme.isEqv.apply2(Char.make(j), Lit15) != Boolean.FALSE) {}
      try
      {
        localCharSequence2 = (CharSequence)paramObject1;
        localObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "string-ref", 1, paramObject1);
      }
      try
      {
        k = ((Number)localObject2).intValue();
        if (characters.isChar$Eq(Char.make(strings.stringRef(localCharSequence2, k)), Lit44))
        {
          localObject3 = pregexpReadPosixCharClass(paramObject1, AddOp.$Pl.apply2(paramObject2, Lit16), paramObject3);
          localObject1 = lists.cons(lists.car.apply1(localObject3), localObject1);
          paramObject2 = lists.cadr.apply1(localObject3);
          continue;
        }
        localObject1 = lists.cons(Char.make(j), localObject1);
        paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "string-ref", 2, localObject2);
      }
      localObject1 = lists.cons(Char.make(j), localObject1);
      paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
    }
  }
  
  public static Object pregexpReadClusterType(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      try
      {
        localCharSequence1 = (CharSequence)paramObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        CharSequence localCharSequence1;
        int i;
        int j;
        CharSequence localCharSequence2;
        int k;
        int m;
        CharSequence localCharSequence4;
        int i2;
        int i3;
        Object localObject4;
        Object[] arrayOfObject2;
        Object localObject2;
        Boolean localBoolean;
        CharSequence localCharSequence3;
        int n;
        int i1;
        throw new WrongType(localClassCastException1, "string-ref", 1, paramObject1);
      }
      try
      {
        i = ((Number)paramObject2).intValue();
        j = strings.stringRef(localCharSequence1, i);
        if (Scheme.isEqv.apply2(Char.make(j), Lit47) != Boolean.FALSE) {
          localObject1 = AddOp.$Pl.apply2(paramObject2, Lit8);
        }
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-ref", 2, paramObject2);
      }
      try
      {
        localCharSequence2 = (CharSequence)paramObject1;
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "string-ref", 1, paramObject1);
      }
      try
      {
        k = ((Number)localObject1).intValue();
        m = strings.stringRef(localCharSequence2, k);
        if (Scheme.isEqv.apply2(Char.make(m), Lit44) != Boolean.FALSE) {
          return LList.list2(LList.Empty, AddOp.$Pl.apply2(localObject1, Lit8));
        }
        if (Scheme.isEqv.apply2(Char.make(m), Lit48) != Boolean.FALSE) {
          return LList.list2(Lit49, AddOp.$Pl.apply2(localObject1, Lit8));
        }
        if (Scheme.isEqv.apply2(Char.make(m), Lit50) != Boolean.FALSE) {
          return LList.list2(Lit51, AddOp.$Pl.apply2(localObject1, Lit8));
        }
        if (Scheme.isEqv.apply2(Char.make(m), Lit52) != Boolean.FALSE) {
          return LList.list2(Lit53, AddOp.$Pl.apply2(localObject1, Lit8));
        }
        if (Scheme.isEqv.apply2(Char.make(m), Lit54) == Boolean.FALSE) {}
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "string-ref", 2, localObject1);
      }
      try
      {
        localCharSequence4 = (CharSequence)paramObject1;
        localObject3 = AddOp.$Pl.apply2(localObject1, Lit8);
      }
      catch (ClassCastException localClassCastException7)
      {
        throw new WrongType(localClassCastException7, "string-ref", 1, paramObject1);
      }
      try
      {
        i2 = ((Number)localObject3).intValue();
        i3 = strings.stringRef(localCharSequence4, i2);
        if (Scheme.isEqv.apply2(Char.make(i3), Lit48) != Boolean.FALSE)
        {
          localObject4 = Lit55;
          return LList.list2(localObject4, AddOp.$Pl.apply2(localObject1, Lit16));
        }
        if (Scheme.isEqv.apply2(Char.make(i3), Lit50) != Boolean.FALSE)
        {
          localObject4 = Lit56;
          continue;
        }
        arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Lit57;
        localObject4 = pregexpError$V(arrayOfObject2);
        continue;
        localObject2 = LList.Empty;
        localBoolean = Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException8)
      {
        throw new WrongType(localClassCastException8, "string-ref", 2, localObject3);
      }
      try
      {
        localCharSequence3 = (CharSequence)paramObject1;
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "string-ref", 1, paramObject1);
      }
      try
      {
        n = ((Number)localObject1).intValue();
        i1 = strings.stringRef(localCharSequence3, n);
        if (Scheme.isEqv.apply2(Char.make(i1), Lit58) != Boolean.FALSE)
        {
          localObject1 = AddOp.$Pl.apply2(localObject1, Lit8);
          localBoolean = Boolean.TRUE;
        }
        else if (Scheme.isEqv.apply2(Char.make(i1), Lit59) != Boolean.FALSE)
        {
          localObject1 = AddOp.$Pl.apply2(localObject1, Lit8);
          SimpleSymbol localSimpleSymbol;
          if (localBoolean != Boolean.FALSE)
          {
            localSimpleSymbol = Lit60;
            localObject2 = lists.cons(localSimpleSymbol, localObject2);
            localBoolean = Boolean.FALSE;
          }
          else
          {
            localSimpleSymbol = Lit61;
          }
        }
        else if (Scheme.isEqv.apply2(Char.make(i1), Lit62) != Boolean.FALSE)
        {
          $Stpregexp$Mnspace$Mnsensitive$Qu$St = localBoolean;
          localObject1 = AddOp.$Pl.apply2(localObject1, Lit8);
          localBoolean = Boolean.FALSE;
        }
        else
        {
          if (Scheme.isEqv.apply2(Char.make(i1), Lit44) != Boolean.FALSE) {
            return LList.list2(localObject2, AddOp.$Pl.apply2(localObject1, Lit8));
          }
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = Lit57;
          return pregexpError$V(arrayOfObject1);
        }
      }
      catch (ClassCastException localClassCastException6)
      {
        throw new WrongType(localClassCastException6, "string-ref", 2, localObject1);
      }
    }
    return LList.list2(Lit63, paramObject2);
  }
  
  public static Object pregexpReadEscapedChar(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    localObject1 = Scheme.numLss.apply2(AddOp.$Pl.apply2(paramObject2, Lit8), paramObject3);
    try
    {
      bool = ((Boolean)localObject1).booleanValue();
      if (!bool) {}
    }
    catch (ClassCastException localClassCastException1)
    {
      boolean bool;
      CharSequence localCharSequence;
      int i;
      int j;
      throw new WrongType(localClassCastException1, "x", -2, localObject1);
    }
    try
    {
      localCharSequence = (CharSequence)paramObject1;
      localObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "string-ref", 1, paramObject1);
    }
    try
    {
      i = ((Number)localObject2).intValue();
      j = strings.stringRef(localCharSequence, i);
      if (Scheme.isEqv.apply2(Char.make(j), Lit25) != Boolean.FALSE) {
        return LList.list2(Lit26, AddOp.$Pl.apply2(paramObject2, Lit16));
      }
      if (Scheme.isEqv.apply2(Char.make(j), Lit27) != Boolean.FALSE) {
        return LList.list2(Lit28, AddOp.$Pl.apply2(paramObject2, Lit16));
      }
      if (Scheme.isEqv.apply2(Char.make(j), Lit29) != Boolean.FALSE) {
        return LList.list2(Lit30, AddOp.$Pl.apply2(paramObject2, Lit16));
      }
      if (Scheme.isEqv.apply2(Char.make(j), Lit31) != Boolean.FALSE) {
        return LList.list2(Lit32, AddOp.$Pl.apply2(paramObject2, Lit16));
      }
      if (Scheme.isEqv.apply2(Char.make(j), Lit33) != Boolean.FALSE) {
        return LList.list2(Lit24, AddOp.$Pl.apply2(paramObject2, Lit16));
      }
      if (Scheme.isEqv.apply2(Char.make(j), Lit34) != Boolean.FALSE) {
        return LList.list2($Stpregexp$Mnreturn$Mnchar$St, AddOp.$Pl.apply2(paramObject2, Lit16));
      }
      if (Scheme.isEqv.apply2(Char.make(j), Lit35) != Boolean.FALSE) {
        return LList.list2(Lit36, AddOp.$Pl.apply2(paramObject2, Lit16));
      }
      if (Scheme.isEqv.apply2(Char.make(j), Lit37) != Boolean.FALSE) {
        return LList.list2(Lit38, AddOp.$Pl.apply2(paramObject2, Lit16));
      }
      if (Scheme.isEqv.apply2(Char.make(j), Lit39) != Boolean.FALSE) {
        return LList.list2($Stpregexp$Mntab$Mnchar$St, AddOp.$Pl.apply2(paramObject2, Lit16));
      }
      if (Scheme.isEqv.apply2(Char.make(j), Lit40) != Boolean.FALSE) {
        return LList.list2(Lit41, AddOp.$Pl.apply2(paramObject2, Lit16));
      }
      if (Scheme.isEqv.apply2(Char.make(j), Lit42) != Boolean.FALSE) {
        return LList.list2(Lit43, AddOp.$Pl.apply2(paramObject2, Lit16));
      }
      return LList.list2(Char.make(j), AddOp.$Pl.apply2(paramObject2, Lit16));
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "string-ref", 2, localObject2);
    }
    if (bool) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static Object pregexpReadEscapedNumber(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    localObject1 = Scheme.numLss.apply2(AddOp.$Pl.apply2(paramObject2, Lit8), paramObject3);
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      Object localObject5;
      try
      {
        bool1 = ((Boolean)localObject1).booleanValue();
        if (!bool1) {}
      }
      catch (ClassCastException localClassCastException1)
      {
        boolean bool1;
        CharSequence localCharSequence1;
        int i;
        int j;
        boolean bool2;
        Pair localPair;
        LList localLList2;
        CharSequence localCharSequence2;
        int k;
        int m;
        LList localLList1;
        throw new WrongType(localClassCastException1, "x", -2, localObject1);
      }
      try
      {
        localCharSequence1 = (CharSequence)paramObject1;
        localObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-ref", 1, paramObject1);
      }
      try
      {
        i = ((Number)localObject2).intValue();
        j = strings.stringRef(localCharSequence1, i);
        bool2 = unicode.isCharNumeric(Char.make(j));
        if (bool2)
        {
          localObject3 = AddOp.$Pl.apply2(paramObject2, Lit16);
          localPair = LList.list1(Char.make(j));
          if (Scheme.numGEq.apply2(localObject3, paramObject3) != Boolean.FALSE) {
            localObject5 = pregexpReverse$Ex(localPair);
          }
        }
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "string-ref", 2, localObject2);
      }
      try
      {
        localLList2 = (LList)localObject5;
        return LList.list2(numbers.string$To$Number(strings.list$To$String(localLList2)), localObject3);
      }
      catch (ClassCastException localClassCastException7)
      {
        throw new WrongType(localClassCastException7, "list->string", 1, localObject5);
      }
      try
      {
        localCharSequence2 = (CharSequence)paramObject1;
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "string-ref", 1, paramObject1);
      }
      try
      {
        k = ((Number)localObject3).intValue();
        m = strings.stringRef(localCharSequence2, k);
        if (unicode.isCharNumeric(Char.make(m)))
        {
          localObject3 = AddOp.$Pl.apply2(localObject3, Lit8);
          localPair = lists.cons(Char.make(m), localPair);
        }
        else
        {
          localObject4 = pregexpReverse$Ex(localPair);
        }
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "string-ref", 2, localObject3);
      }
    }
    try
    {
      localLList1 = (LList)localObject4;
      return LList.list2(numbers.string$To$Number(strings.list$To$String(localLList1)), localObject3);
    }
    catch (ClassCastException localClassCastException6)
    {
      throw new WrongType(localClassCastException6, "list->string", 1, localObject4);
    }
    if (bool2) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    if (bool1) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static Object pregexpReadNums(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject1 = LList.Empty;
    Object localObject2 = LList.Empty;
    IntNum localIntNum = Lit8;
    localObject3 = paramObject2;
    for (;;)
    {
      if (Scheme.numGEq.apply2(localObject3, paramObject3) != Boolean.FALSE)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Lit76;
        pregexpError$V(arrayOfObject);
      }
      try
      {
        localCharSequence = (CharSequence)paramObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        CharSequence localCharSequence;
        int i;
        int j;
        LList localLList1;
        LList localLList2;
        Object localObject7;
        Boolean localBoolean;
        int k;
        label362:
        int m;
        label392:
        label415:
        throw new WrongType(localClassCastException1, "string-ref", 1, paramObject1);
      }
      try
      {
        i = ((Number)localObject3).intValue();
        j = strings.stringRef(localCharSequence, i);
        if (unicode.isCharNumeric(Char.make(j)))
        {
          if (Scheme.numEqu.apply2(localIntNum, Lit8) != Boolean.FALSE)
          {
            localObject1 = lists.cons(Char.make(j), localObject1);
            Object localObject10 = AddOp.$Pl.apply2(localObject3, Lit8);
            localIntNum = Lit8;
            localObject3 = localObject10;
          }
          else
          {
            localObject2 = lists.cons(Char.make(j), localObject2);
            Object localObject9 = AddOp.$Pl.apply2(localObject3, Lit8);
            localIntNum = Lit16;
            localObject3 = localObject9;
          }
        }
        else
        {
          boolean bool1 = unicode.isCharWhitespace(Char.make(j));
          if (bool1)
          {
            if ($Stpregexp$Mnspace$Mnsensitive$Qu$St != Boolean.FALSE) {}
          }
          else {
            while (bool1)
            {
              localObject3 = AddOp.$Pl.apply2(localObject3, Lit8);
              break;
            }
          }
          boolean bool2 = characters.isChar$Eq(Char.make(j), Lit77);
          if (bool2)
          {
            if (Scheme.numEqu.apply2(localIntNum, Lit8) == Boolean.FALSE) {}
          }
          else {
            while (bool2)
            {
              Object localObject8 = AddOp.$Pl.apply2(localObject3, Lit8);
              localIntNum = Lit16;
              localObject3 = localObject8;
              break;
            }
          }
          if (characters.isChar$Eq(Char.make(j), Lit78)) {
            localObject4 = pregexpReverse$Ex(localObject1);
          }
        }
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-ref", 2, localObject3);
      }
    }
    try
    {
      localLList1 = (LList)localObject4;
      localObject5 = numbers.string$To$Number(strings.list$To$String(localLList1));
      localObject6 = pregexpReverse$Ex(localObject2);
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "list->string", 1, localObject4);
    }
    try
    {
      localLList2 = (LList)localObject6;
      localObject7 = numbers.string$To$Number(strings.list$To$String(localLList2));
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "list->string", 1, localObject6);
    }
    try
    {
      localBoolean = Boolean.FALSE;
      if (localObject5 != localBoolean)
      {
        k = 1;
        m = 0x1 & k + 1;
        if (m != 0)
        {
          if (Scheme.numEqu.apply2(localIntNum, Lit8) == Boolean.FALSE) {
            break label415;
          }
          return LList.list3(Lit73, Boolean.FALSE, localObject3);
        }
      }
      else
      {
        k = 0;
        break label362;
      }
      if (m != 0) {
        break label392;
      }
      if (Scheme.numEqu.apply2(localIntNum, Lit8) != Boolean.FALSE) {
        return LList.list3(localObject5, localObject5, localObject3);
      }
      return LList.list3(localObject5, localObject7, localObject3);
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "x", -2, localObject5);
    }
    return Boolean.FALSE;
  }
  
  public static Object pregexpReadPattern(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (Scheme.numGEq.apply2(paramObject2, paramObject3) != Boolean.FALSE) {
      return LList.list2(LList.list2(Lit4, LList.list1(Lit5)), paramObject2);
    }
    Object localObject1 = LList.Empty;
    for (;;)
    {
      Object localObject2 = Scheme.numGEq.apply2(paramObject2, paramObject3);
      try
      {
        boolean bool = ((Boolean)localObject2).booleanValue();
        if (bool)
        {
          if (!bool) {
            break label114;
          }
          return LList.list2(lists.cons(Lit4, pregexpReverse$Ex(localObject1)), paramObject2);
        }
      }
      catch (ClassCastException localClassCastException1)
      {
        for (;;)
        {
          try
          {
            localCharSequence1 = (CharSequence)paramObject1;
          }
          catch (ClassCastException localClassCastException2)
          {
            CharSequence localCharSequence1;
            int i;
            label114:
            CharSequence localCharSequence2;
            int j;
            Object localObject3;
            throw new WrongType(localClassCastException2, "string-ref", 1, paramObject1);
          }
          try
          {
            i = ((Number)paramObject2).intValue();
            if (characters.isChar$Eq(Char.make(strings.stringRef(localCharSequence1, i)), Lit6)) {}
          }
          catch (ClassCastException localClassCastException3)
          {
            throw new WrongType(localClassCastException3, "string-ref", 2, paramObject2);
          }
        }
        try
        {
          localCharSequence2 = (CharSequence)paramObject1;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "string-ref", 1, paramObject1);
        }
        try
        {
          j = ((Number)paramObject2).intValue();
          if (characters.isChar$Eq(Char.make(strings.stringRef(localCharSequence2, j)), Lit7)) {
            paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
          }
          localObject3 = pregexpReadBranch(paramObject1, paramObject2, paramObject3);
          localObject1 = lists.cons(lists.car.apply1(localObject3), localObject1);
          paramObject2 = lists.cadr.apply1(localObject3);
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "string-ref", 2, paramObject2);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "x", -2, localObject2);
      }
    }
  }
  
  /* Error */
  public static Object pregexpReadPiece(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 888	java/lang/CharSequence
    //   4: astore 4
    //   6: aload_1
    //   7: checkcast 890	java/lang/Number
    //   10: invokevirtual 894	java/lang/Number:intValue	()I
    //   13: istore 6
    //   15: aload 4
    //   17: iload 6
    //   19: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   22: istore 7
    //   24: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   27: iload 7
    //   29: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   32: getstatic 296	gnu/kawa/slib/pregexp:Lit9	Lgnu/text/Char;
    //   35: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   41: if_acmpeq +20 -> 61
    //   44: getstatic 674	gnu/kawa/slib/pregexp:Lit10	Lgnu/mapping/SimpleSymbol;
    //   47: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   50: aload_1
    //   51: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   54: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   57: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   60: areturn
    //   61: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   64: iload 7
    //   66: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   69: getstatic 298	gnu/kawa/slib/pregexp:Lit11	Lgnu/text/Char;
    //   72: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   75: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   78: if_acmpeq +20 -> 98
    //   81: getstatic 670	gnu/kawa/slib/pregexp:Lit12	Lgnu/mapping/SimpleSymbol;
    //   84: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   87: aload_1
    //   88: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   91: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   97: areturn
    //   98: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   101: iload 7
    //   103: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   106: getstatic 286	gnu/kawa/slib/pregexp:Lit13	Lgnu/text/Char;
    //   109: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   115: if_acmpeq +25 -> 140
    //   118: getstatic 386	gnu/kawa/slib/pregexp:Lit14	Lgnu/mapping/SimpleSymbol;
    //   121: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   124: aload_1
    //   125: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   128: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   131: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   134: aload_0
    //   135: aload_2
    //   136: invokestatic 1197	gnu/kawa/slib/pregexp:pregexpWrapQuantifierIfAny	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: areturn
    //   140: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   143: iload 7
    //   145: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   148: getstatic 300	gnu/kawa/slib/pregexp:Lit15	Lgnu/text/Char;
    //   151: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   154: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   157: if_acmpeq +171 -> 328
    //   160: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   163: aload_1
    //   164: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   167: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   170: astore 20
    //   172: getstatic 1145	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   175: aload 20
    //   177: aload_2
    //   178: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   181: astore 21
    //   183: aload 21
    //   185: checkcast 371	java/lang/Boolean
    //   188: invokevirtual 880	java/lang/Boolean:booleanValue	()Z
    //   191: istore 23
    //   193: iload 23
    //   195: ifeq +100 -> 295
    //   198: aload_0
    //   199: checkcast 888	java/lang/CharSequence
    //   202: astore 28
    //   204: aload 20
    //   206: checkcast 890	java/lang/Number
    //   209: invokevirtual 894	java/lang/Number:intValue	()I
    //   212: istore 30
    //   214: aload 28
    //   216: iload 30
    //   218: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   221: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   224: astore 24
    //   226: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   229: aload 24
    //   231: getstatic 296	gnu/kawa/slib/pregexp:Lit9	Lgnu/text/Char;
    //   234: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   240: if_acmpeq +76 -> 316
    //   243: aload_0
    //   244: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   247: aload_1
    //   248: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   251: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   254: aload_2
    //   255: invokestatic 1199	gnu/kawa/slib/pregexp:pregexpReadCharList	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   258: astore 26
    //   260: getstatic 592	gnu/kawa/slib/pregexp:Lit17	Lgnu/mapping/SimpleSymbol;
    //   263: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   266: aload 26
    //   268: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   271: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   274: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   277: aload 26
    //   279: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   282: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   285: astore 25
    //   287: aload 25
    //   289: aload_0
    //   290: aload_2
    //   291: invokestatic 1197	gnu/kawa/slib/pregexp:pregexpWrapQuantifierIfAny	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   294: areturn
    //   295: iload 23
    //   297: ifeq +11 -> 308
    //   300: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   303: astore 24
    //   305: goto -79 -> 226
    //   308: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   311: astore 24
    //   313: goto -87 -> 226
    //   316: aload_0
    //   317: aload 20
    //   319: aload_2
    //   320: invokestatic 1199	gnu/kawa/slib/pregexp:pregexpReadCharList	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   323: astore 25
    //   325: goto -38 -> 287
    //   328: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   331: iload 7
    //   333: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   336: getstatic 308	gnu/kawa/slib/pregexp:Lit18	Lgnu/text/Char;
    //   339: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   342: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   345: if_acmpeq +24 -> 369
    //   348: aload_0
    //   349: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   352: aload_1
    //   353: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   356: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   359: aload_2
    //   360: invokestatic 1202	gnu/kawa/slib/pregexp:pregexpReadSubpattern	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   363: aload_0
    //   364: aload_2
    //   365: invokestatic 1197	gnu/kawa/slib/pregexp:pregexpWrapQuantifierIfAny	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   368: areturn
    //   369: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   372: iload 7
    //   374: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   377: getstatic 284	gnu/kawa/slib/pregexp:Lit19	Lgnu/text/Char;
    //   380: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   383: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   386: if_acmpeq +124 -> 510
    //   389: aload_0
    //   390: aload_1
    //   391: aload_2
    //   392: invokestatic 1204	gnu/kawa/slib/pregexp:pregexpReadEscapedNumber	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   395: astore 16
    //   397: aload 16
    //   399: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   402: if_acmpeq +38 -> 440
    //   405: getstatic 664	gnu/kawa/slib/pregexp:Lit20	Lgnu/mapping/SimpleSymbol;
    //   408: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   411: aload 16
    //   413: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   416: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   419: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   422: aload 16
    //   424: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   427: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   430: astore 19
    //   432: aload 19
    //   434: aload_0
    //   435: aload_2
    //   436: invokestatic 1197	gnu/kawa/slib/pregexp:pregexpWrapQuantifierIfAny	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   439: areturn
    //   440: aload_0
    //   441: aload_1
    //   442: aload_2
    //   443: invokestatic 1168	gnu/kawa/slib/pregexp:pregexpReadEscapedChar	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   446: astore 17
    //   448: aload 17
    //   450: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   453: if_acmpeq +27 -> 480
    //   456: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   459: aload 17
    //   461: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   464: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   467: aload 17
    //   469: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   472: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   475: astore 19
    //   477: goto -45 -> 432
    //   480: iconst_2
    //   481: anewarray 965	java/lang/Object
    //   484: astore 18
    //   486: aload 18
    //   488: iconst_0
    //   489: getstatic 660	gnu/kawa/slib/pregexp:Lit21	Lgnu/mapping/SimpleSymbol;
    //   492: aastore
    //   493: aload 18
    //   495: iconst_1
    //   496: getstatic 656	gnu/kawa/slib/pregexp:Lit22	Lgnu/mapping/SimpleSymbol;
    //   499: aastore
    //   500: aload 18
    //   502: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   505: astore 19
    //   507: goto -75 -> 432
    //   510: getstatic 1010	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   513: astore 8
    //   515: aload 8
    //   517: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   520: if_acmpeq +35 -> 555
    //   523: aload 8
    //   525: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   528: if_acmpeq +60 -> 588
    //   531: iload 7
    //   533: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   536: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   539: aload_1
    //   540: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   543: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   546: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   549: aload_0
    //   550: aload_2
    //   551: invokestatic 1197	gnu/kawa/slib/pregexp:pregexpWrapQuantifierIfAny	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   554: areturn
    //   555: iconst_1
    //   556: iconst_1
    //   557: iload 7
    //   559: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   562: invokestatic 954	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
    //   565: iadd
    //   566: iand
    //   567: istore 9
    //   569: iload 9
    //   571: ifeq +44 -> 615
    //   574: iload 7
    //   576: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   579: getstatic 690	gnu/kawa/slib/pregexp:Lit1	Lgnu/text/Char;
    //   582: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   585: ifeq -54 -> 531
    //   588: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   591: astore 10
    //   593: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   596: aload_1
    //   597: aload_2
    //   598: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   601: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   604: if_acmpeq +19 -> 623
    //   607: getstatic 652	gnu/kawa/slib/pregexp:Lit23	Lgnu/mapping/SimpleSymbol;
    //   610: aload_1
    //   611: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   614: areturn
    //   615: iload 9
    //   617: ifeq -29 -> 588
    //   620: goto -89 -> 531
    //   623: aload_0
    //   624: checkcast 888	java/lang/CharSequence
    //   627: astore 12
    //   629: aload_1
    //   630: checkcast 890	java/lang/Number
    //   633: invokevirtual 894	java/lang/Number:intValue	()I
    //   636: istore 14
    //   638: aload 12
    //   640: iload 14
    //   642: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   645: istore 15
    //   647: aload 10
    //   649: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   652: if_acmpeq +44 -> 696
    //   655: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   658: aload_1
    //   659: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   662: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   665: astore_1
    //   666: iload 15
    //   668: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   671: getstatic 648	gnu/kawa/slib/pregexp:Lit24	Lgnu/text/Char;
    //   674: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   677: ifeq +11 -> 688
    //   680: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   683: astore 10
    //   685: goto -92 -> 593
    //   688: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   691: astore 10
    //   693: goto -8 -> 685
    //   696: iload 15
    //   698: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   701: invokestatic 954	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
    //   704: ifeq +22 -> 726
    //   707: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   710: aload_1
    //   711: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   714: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   717: astore_1
    //   718: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   721: astore 10
    //   723: goto -130 -> 593
    //   726: iload 15
    //   728: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   731: getstatic 690	gnu/kawa/slib/pregexp:Lit1	Lgnu/text/Char;
    //   734: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   737: ifeq +22 -> 759
    //   740: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   743: aload_1
    //   744: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   747: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   750: astore_1
    //   751: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   754: astore 10
    //   756: goto -163 -> 593
    //   759: getstatic 652	gnu/kawa/slib/pregexp:Lit23	Lgnu/mapping/SimpleSymbol;
    //   762: aload_1
    //   763: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   766: areturn
    //   767: astore_3
    //   768: new 911	gnu/mapping/WrongType
    //   771: dup
    //   772: aload_3
    //   773: ldc_w 918
    //   776: iconst_1
    //   777: aload_0
    //   778: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   781: athrow
    //   782: astore 5
    //   784: new 911	gnu/mapping/WrongType
    //   787: dup
    //   788: aload 5
    //   790: ldc_w 918
    //   793: iconst_2
    //   794: aload_1
    //   795: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   798: athrow
    //   799: astore 22
    //   801: new 911	gnu/mapping/WrongType
    //   804: dup
    //   805: aload 22
    //   807: ldc_w 913
    //   810: bipush 254
    //   812: aload 21
    //   814: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   817: athrow
    //   818: astore 27
    //   820: new 911	gnu/mapping/WrongType
    //   823: dup
    //   824: aload 27
    //   826: ldc_w 918
    //   829: iconst_1
    //   830: aload_0
    //   831: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   834: athrow
    //   835: astore 29
    //   837: new 911	gnu/mapping/WrongType
    //   840: dup
    //   841: aload 29
    //   843: ldc_w 918
    //   846: iconst_2
    //   847: aload 20
    //   849: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   852: athrow
    //   853: astore 11
    //   855: new 911	gnu/mapping/WrongType
    //   858: dup
    //   859: aload 11
    //   861: ldc_w 918
    //   864: iconst_1
    //   865: aload_0
    //   866: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   869: athrow
    //   870: astore 13
    //   872: new 911	gnu/mapping/WrongType
    //   875: dup
    //   876: aload 13
    //   878: ldc_w 918
    //   881: iconst_2
    //   882: aload_1
    //   883: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   886: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	887	0	paramObject1	Object
    //   0	887	1	paramObject2	Object
    //   0	887	2	paramObject3	Object
    //   767	6	3	localClassCastException1	ClassCastException
    //   4	12	4	localCharSequence1	CharSequence
    //   782	7	5	localClassCastException2	ClassCastException
    //   13	5	6	i	int
    //   22	553	7	j	int
    //   513	11	8	localObject1	Object
    //   567	49	9	k	int
    //   591	164	10	localBoolean	Boolean
    //   853	7	11	localClassCastException3	ClassCastException
    //   627	12	12	localCharSequence2	CharSequence
    //   870	7	13	localClassCastException4	ClassCastException
    //   636	5	14	m	int
    //   645	82	15	n	int
    //   395	28	16	localObject2	Object
    //   446	22	17	localObject3	Object
    //   484	17	18	arrayOfObject	Object[]
    //   430	76	19	localObject4	Object
    //   170	678	20	localObject5	Object
    //   181	632	21	localObject6	Object
    //   799	7	22	localClassCastException5	ClassCastException
    //   191	105	23	bool	boolean
    //   224	88	24	localObject7	Object
    //   285	39	25	localObject8	Object
    //   258	20	26	localObject9	Object
    //   818	7	27	localClassCastException6	ClassCastException
    //   202	13	28	localCharSequence3	CharSequence
    //   835	7	29	localClassCastException7	ClassCastException
    //   212	5	30	i1	int
    // Exception table:
    //   from	to	target	type
    //   0	6	767	java/lang/ClassCastException
    //   6	15	782	java/lang/ClassCastException
    //   183	193	799	java/lang/ClassCastException
    //   198	204	818	java/lang/ClassCastException
    //   204	214	835	java/lang/ClassCastException
    //   623	629	853	java/lang/ClassCastException
    //   629	638	870	java/lang/ClassCastException
  }
  
  public static Object pregexpReadPosixCharClass(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Boolean localBoolean = Boolean.FALSE;
    Pair localPair = LList.list1(Lit44);
    if (Scheme.numGEq.apply2(paramObject2, paramObject3) != Boolean.FALSE)
    {
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = Lit45;
      return pregexpError$V(arrayOfObject3);
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      for (;;)
      {
        try
        {
          localCharSequence1 = (CharSequence)paramObject1;
        }
        catch (ClassCastException localClassCastException1)
        {
          CharSequence localCharSequence1;
          int i;
          int j;
          boolean bool;
          Object[] arrayOfObject2;
          CharSequence localCharSequence2;
          int k;
          LList localLList;
          Object localObject4;
          Object[] arrayOfObject1;
          throw new WrongType(localClassCastException1, "string-ref", 1, paramObject1);
        }
        try
        {
          i = ((Number)paramObject2).intValue();
          j = strings.stringRef(localCharSequence1, i);
          if (characters.isChar$Eq(Char.make(j), Lit9))
          {
            localBoolean = Boolean.TRUE;
            paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
            break;
          }
          if (unicode.isCharAlphabetic(Char.make(j)))
          {
            paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
            localPair = lists.cons(Char.make(j), localPair);
            break;
          }
          if (characters.isChar$Eq(Char.make(j), Lit44)) {
            localObject1 = Scheme.numGEq.apply2(AddOp.$Pl.apply2(paramObject2, Lit8), paramObject3);
          }
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-ref", 2, paramObject2);
        }
      }
      try
      {
        bool = ((Boolean)localObject1).booleanValue();
        if (bool)
        {
          if (!bool) {
            continue;
          }
          arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Lit45;
          return pregexpError$V(arrayOfObject2);
        }
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "x", -2, localObject1);
      }
      try
      {
        localCharSequence2 = (CharSequence)paramObject1;
        localObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "string-ref", 1, paramObject1);
      }
      try
      {
        k = ((Number)localObject2).intValue();
        if (characters.isChar$Eq(Char.make(strings.stringRef(localCharSequence2, k)), Lit46)) {
          localObject3 = pregexpReverse$Ex(localPair);
        }
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "string-ref", 2, localObject2);
      }
    }
    try
    {
      localLList = (LList)localObject3;
      localObject4 = misc.string$To$Symbol(strings.list$To$String(localLList));
      if (localBoolean != Boolean.FALSE) {
        localObject4 = LList.list2(Lit17, localObject4);
      }
      return LList.list2(localObject4, AddOp.$Pl.apply2(paramObject2, Lit16));
    }
    catch (ClassCastException localClassCastException6)
    {
      throw new WrongType(localClassCastException6, "list->string", 1, localObject3);
    }
    arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Lit45;
    return pregexpError$V(arrayOfObject1);
  }
  
  /* Error */
  public static Object pregexpReadSubpattern(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 1010	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_0
    //   5: aload_1
    //   6: aload_2
    //   7: invokestatic 1210	gnu/kawa/slib/pregexp:pregexpReadClusterType	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   10: astore 4
    //   12: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   15: aload 4
    //   17: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: astore 5
    //   22: aload_0
    //   23: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   26: aload 4
    //   28: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: aload_2
    //   32: invokestatic 1023	gnu/kawa/slib/pregexp:pregexpReadPattern	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: astore 6
    //   37: aload_3
    //   38: putstatic 1010	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   41: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   44: aload 6
    //   46: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore 7
    //   51: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   54: aload 6
    //   56: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: astore 8
    //   61: getstatic 1145	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   64: aload 8
    //   66: aload_2
    //   67: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: astore 9
    //   72: aload 9
    //   74: checkcast 371	java/lang/Boolean
    //   77: invokevirtual 880	java/lang/Boolean:booleanValue	()Z
    //   80: istore 11
    //   82: iload 11
    //   84: ifeq +63 -> 147
    //   87: aload_0
    //   88: checkcast 888	java/lang/CharSequence
    //   91: astore 15
    //   93: aload 8
    //   95: checkcast 890	java/lang/Number
    //   98: invokevirtual 894	java/lang/Number:intValue	()I
    //   101: istore 17
    //   103: aload 15
    //   105: iload 17
    //   107: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   110: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   113: getstatic 310	gnu/kawa/slib/pregexp:Lit6	Lgnu/text/Char;
    //   116: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   119: ifeq +33 -> 152
    //   122: aload 5
    //   124: invokestatic 1072	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   127: ifeq +44 -> 171
    //   130: aload 7
    //   132: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   135: aload 8
    //   137: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   140: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   143: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   146: areturn
    //   147: iload 11
    //   149: ifne -27 -> 122
    //   152: iconst_1
    //   153: anewarray 965	java/lang/Object
    //   156: astore 12
    //   158: aload 12
    //   160: iconst_0
    //   161: getstatic 538	gnu/kawa/slib/pregexp:Lit64	Lgnu/mapping/SimpleSymbol;
    //   164: aastore
    //   165: aload 12
    //   167: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   170: areturn
    //   171: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   174: aload 5
    //   176: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   179: astore 13
    //   181: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   184: aload 5
    //   186: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   189: aload 7
    //   191: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   194: astore 7
    //   196: aload 13
    //   198: astore 5
    //   200: goto -78 -> 122
    //   203: astore 10
    //   205: new 911	gnu/mapping/WrongType
    //   208: dup
    //   209: aload 10
    //   211: ldc_w 913
    //   214: bipush 254
    //   216: aload 9
    //   218: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   221: athrow
    //   222: astore 14
    //   224: new 911	gnu/mapping/WrongType
    //   227: dup
    //   228: aload 14
    //   230: ldc_w 918
    //   233: iconst_1
    //   234: aload_0
    //   235: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   238: athrow
    //   239: astore 16
    //   241: new 911	gnu/mapping/WrongType
    //   244: dup
    //   245: aload 16
    //   247: ldc_w 918
    //   250: iconst_2
    //   251: aload 8
    //   253: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   256: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramObject1	Object
    //   0	257	1	paramObject2	Object
    //   0	257	2	paramObject3	Object
    //   3	35	3	localObject1	Object
    //   10	17	4	localObject2	Object
    //   20	179	5	localObject3	Object
    //   35	20	6	localObject4	Object
    //   49	146	7	localObject5	Object
    //   59	193	8	localObject6	Object
    //   70	147	9	localObject7	Object
    //   203	7	10	localClassCastException1	ClassCastException
    //   80	68	11	bool	boolean
    //   156	10	12	arrayOfObject	Object[]
    //   179	18	13	localObject8	Object
    //   222	7	14	localClassCastException2	ClassCastException
    //   91	13	15	localCharSequence	CharSequence
    //   239	7	16	localClassCastException3	ClassCastException
    //   101	5	17	i	int
    // Exception table:
    //   from	to	target	type
    //   72	82	203	java/lang/ClassCastException
    //   87	93	222	java/lang/ClassCastException
    //   93	103	239	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpReplace(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 888	java/lang/CharSequence
    //   4: astore 4
    //   6: aload 4
    //   8: invokestatic 1014	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   11: istore 5
    //   13: iconst_2
    //   14: anewarray 965	java/lang/Object
    //   17: astore 6
    //   19: aload 6
    //   21: iconst_0
    //   22: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   25: aastore
    //   26: aload 6
    //   28: iconst_1
    //   29: iload 5
    //   31: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: aastore
    //   35: aload_0
    //   36: aload_1
    //   37: aload 6
    //   39: invokestatic 1213	gnu/kawa/slib/pregexp:pregexpMatchPositions$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   42: astore 7
    //   44: aload 7
    //   46: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   49: if_acmpne +5 -> 54
    //   52: aload_1
    //   53: areturn
    //   54: aload_2
    //   55: checkcast 888	java/lang/CharSequence
    //   58: astore 9
    //   60: aload 9
    //   62: invokestatic 1014	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   65: istore 10
    //   67: getstatic 1216	kawa/lib/lists:caar	Lgnu/expr/GenericProc;
    //   70: aload 7
    //   72: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: astore 11
    //   77: getstatic 1219	kawa/lib/lists:cdar	Lgnu/expr/GenericProc;
    //   80: aload 7
    //   82: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   85: astore 12
    //   87: iconst_3
    //   88: anewarray 965	java/lang/Object
    //   91: astore 13
    //   93: aload_1
    //   94: checkcast 888	java/lang/CharSequence
    //   97: astore 15
    //   99: aload 11
    //   101: checkcast 890	java/lang/Number
    //   104: invokevirtual 894	java/lang/Number:intValue	()I
    //   107: istore 17
    //   109: aload 13
    //   111: iconst_0
    //   112: aload 15
    //   114: iconst_0
    //   115: iload 17
    //   117: invokestatic 1094	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   120: aastore
    //   121: aload 13
    //   123: iconst_1
    //   124: aload_1
    //   125: aload_2
    //   126: iload 10
    //   128: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   131: aload 7
    //   133: invokestatic 1222	gnu/kawa/slib/pregexp:pregexpReplaceAux	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: aastore
    //   137: aload_1
    //   138: checkcast 888	java/lang/CharSequence
    //   141: astore 19
    //   143: aload 12
    //   145: checkcast 890	java/lang/Number
    //   148: invokevirtual 894	java/lang/Number:intValue	()I
    //   151: istore 21
    //   153: aload 13
    //   155: iconst_2
    //   156: aload 19
    //   158: iload 21
    //   160: iload 5
    //   162: invokestatic 1094	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   165: aastore
    //   166: aload 13
    //   168: invokestatic 1226	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   171: areturn
    //   172: astore_3
    //   173: new 911	gnu/mapping/WrongType
    //   176: dup
    //   177: aload_3
    //   178: ldc_w 1028
    //   181: iconst_1
    //   182: aload_1
    //   183: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   186: athrow
    //   187: astore 8
    //   189: new 911	gnu/mapping/WrongType
    //   192: dup
    //   193: aload 8
    //   195: ldc_w 1028
    //   198: iconst_1
    //   199: aload_2
    //   200: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   203: athrow
    //   204: astore 14
    //   206: new 911	gnu/mapping/WrongType
    //   209: dup
    //   210: aload 14
    //   212: ldc_w 1097
    //   215: iconst_1
    //   216: aload_1
    //   217: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   220: athrow
    //   221: astore 16
    //   223: new 911	gnu/mapping/WrongType
    //   226: dup
    //   227: aload 16
    //   229: ldc_w 1097
    //   232: iconst_3
    //   233: aload 11
    //   235: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   238: athrow
    //   239: astore 18
    //   241: new 911	gnu/mapping/WrongType
    //   244: dup
    //   245: aload 18
    //   247: ldc_w 1097
    //   250: iconst_1
    //   251: aload_1
    //   252: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   255: athrow
    //   256: astore 20
    //   258: new 911	gnu/mapping/WrongType
    //   261: dup
    //   262: aload 20
    //   264: ldc_w 1097
    //   267: iconst_2
    //   268: aload 12
    //   270: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   273: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramObject1	Object
    //   0	274	1	paramObject2	Object
    //   0	274	2	paramObject3	Object
    //   172	6	3	localClassCastException1	ClassCastException
    //   4	3	4	localCharSequence1	CharSequence
    //   11	150	5	i	int
    //   17	21	6	arrayOfObject1	Object[]
    //   42	90	7	localObject1	Object
    //   187	7	8	localClassCastException2	ClassCastException
    //   58	3	9	localCharSequence2	CharSequence
    //   65	62	10	j	int
    //   75	159	11	localObject2	Object
    //   85	184	12	localObject3	Object
    //   91	76	13	arrayOfObject2	Object[]
    //   204	7	14	localClassCastException3	ClassCastException
    //   97	16	15	localCharSequence3	CharSequence
    //   221	7	16	localClassCastException4	ClassCastException
    //   107	9	17	k	int
    //   239	7	18	localClassCastException5	ClassCastException
    //   141	16	19	localCharSequence4	CharSequence
    //   256	7	20	localClassCastException6	ClassCastException
    //   151	8	21	m	int
    // Exception table:
    //   from	to	target	type
    //   0	6	172	java/lang/ClassCastException
    //   54	60	187	java/lang/ClassCastException
    //   93	99	204	java/lang/ClassCastException
    //   99	109	221	java/lang/ClassCastException
    //   137	143	239	java/lang/ClassCastException
    //   143	153	256	java/lang/ClassCastException
  }
  
  public static Object pregexpReplace$St(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (strings.isString(paramObject1)) {
      paramObject1 = pregexp(paramObject1);
    }
    for (;;)
    {
      try
      {
        CharSequence localCharSequence1 = (CharSequence)paramObject2;
        i = strings.stringLength(localCharSequence1);
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          int i;
          CharSequence localCharSequence2;
          Object[] arrayOfObject1;
          Object[] arrayOfObject3;
          CharSequence localCharSequence4;
          int n;
          localCharSequence3 = (CharSequence)paramObject2;
        }
        catch (ClassCastException localClassCastException3)
        {
          int j;
          Object localObject2;
          Object localObject3;
          Object localObject4;
          Object[] arrayOfObject2;
          CharSequence localCharSequence3;
          int k;
          int m;
          throw new WrongType(localClassCastException3, "substring", 1, paramObject2);
        }
        try
        {
          k = ((Number)localObject1).intValue();
          localObject5 = lists.caar.apply1(localObject3);
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "substring", 2, localObject1);
        }
        try
        {
          m = ((Number)localObject5).intValue();
          arrayOfObject2[1] = strings.substring(localCharSequence3, k, m);
          arrayOfObject2[2] = pregexpReplaceAux(paramObject2, paramObject3, Integer.valueOf(j), localObject3);
          localObject2 = strings.stringAppend(arrayOfObject2);
          localObject1 = localObject4;
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "substring", 3, localObject5);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "string-length", 1, paramObject2);
      }
      try
      {
        localCharSequence2 = (CharSequence)paramObject3;
        j = strings.stringLength(localCharSequence2);
        localObject1 = Lit73;
        localObject2 = "";
        if (Scheme.numGEq.apply2(localObject1, Integer.valueOf(i)) != Boolean.FALSE) {
          return localObject2;
        }
        arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = localObject1;
        arrayOfObject1[1] = Integer.valueOf(i);
        localObject3 = pregexpMatchPositions$V(paramObject1, paramObject2, arrayOfObject1);
        if (localObject3 == Boolean.FALSE)
        {
          if (Scheme.numEqu.apply2(localObject1, Lit73) != Boolean.FALSE) {
            return paramObject2;
          }
          arrayOfObject3 = new Object[2];
          arrayOfObject3[0] = localObject2;
        }
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-length", 1, paramObject3);
      }
      try
      {
        localCharSequence4 = (CharSequence)paramObject2;
      }
      catch (ClassCastException localClassCastException6)
      {
        throw new WrongType(localClassCastException6, "substring", 1, paramObject2);
      }
      try
      {
        n = ((Number)localObject1).intValue();
        arrayOfObject3[1] = strings.substring(localCharSequence4, n, i);
        paramObject2 = strings.stringAppend(arrayOfObject3);
      }
      catch (ClassCastException localClassCastException7)
      {
        throw new WrongType(localClassCastException7, "substring", 2, localObject1);
      }
    }
    localObject4 = lists.cdar.apply1(localObject3);
    arrayOfObject2 = new Object[3];
    arrayOfObject2[0] = localObject2;
  }
  
  public static Object pregexpReplaceAux(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    localObject1 = Lit73;
    for (Object localObject2 = "";; localObject2 = strings.stringAppend(arrayOfObject1))
    {
      for (;;)
      {
        if (Scheme.numGEq.apply2(localObject1, paramObject3) != Boolean.FALSE) {
          return localObject2;
        }
        for (;;)
        {
          for (;;)
          {
            Object localObject4;
            try
            {
              localCharSequence1 = (CharSequence)paramObject2;
            }
            catch (ClassCastException localClassCastException1)
            {
              CharSequence localCharSequence1;
              int i;
              int j;
              Object localObject5;
              CharSequence localCharSequence4;
              int i1;
              int i2;
              throw new WrongType(localClassCastException1, "string-ref", 1, paramObject2);
            }
            try
            {
              i = ((Number)localObject1).intValue();
              j = strings.stringRef(localCharSequence1, i);
              if (characters.isChar$Eq(Char.make(j), Lit19))
              {
                Object localObject3 = pregexpReadEscapedNumber(paramObject2, localObject1, paramObject3);
                if (localObject3 != Boolean.FALSE)
                {
                  localObject5 = lists.car.apply1(localObject3);
                  if (localObject3 == Boolean.FALSE) {
                    continue;
                  }
                  localObject1 = lists.cadr.apply1(localObject3);
                  if (localObject5 != Boolean.FALSE) {
                    continue;
                  }
                }
              }
            }
            catch (ClassCastException localClassCastException2)
            {
              throw new WrongType(localClassCastException2, "string-ref", 2, localObject1);
            }
            try
            {
              localCharSequence4 = (CharSequence)paramObject2;
            }
            catch (ClassCastException localClassCastException8)
            {
              throw new WrongType(localClassCastException8, "string-ref", 1, paramObject2);
            }
            try
            {
              i1 = ((Number)localObject1).intValue();
              i2 = strings.stringRef(localCharSequence4, i1);
              localObject1 = AddOp.$Pl.apply2(localObject1, Lit8);
              if (characters.isChar$Eq(Char.make(i2), Lit11)) {
                break;
              }
              try
              {
                localCharSequence2 = (CharSequence)paramObject2;
                localObject4 = AddOp.$Pl.apply2(localObject1, Lit8);
              }
              catch (ClassCastException localClassCastException3)
              {
                CharSequence localCharSequence2;
                int k;
                Object[] arrayOfObject4;
                Object[] arrayOfObject5;
                Object localObject6;
                Object[] arrayOfObject3;
                CharSequence localCharSequence3;
                int m;
                int n;
                Object[] arrayOfObject1;
                Object[] arrayOfObject2;
                throw new WrongType(localClassCastException3, "string-ref", 1, paramObject2);
              }
              try
              {
                k = ((Number)localObject4).intValue();
                if (characters.isChar$Eq(Char.make(strings.stringRef(localCharSequence2, k)), Lit113))
                {
                  localObject5 = Lit73;
                  continue;
                }
                localObject5 = Boolean.FALSE;
              }
              catch (ClassCastException localClassCastException4)
              {
                throw new WrongType(localClassCastException4, "string-ref", 2, localObject4);
              }
              if (localObject5 != Boolean.FALSE) {
                localObject1 = AddOp.$Pl.apply2(localObject1, Lit16);
              } else {
                localObject1 = AddOp.$Pl.apply2(localObject1, Lit8);
              }
            }
            catch (ClassCastException localClassCastException9)
            {
              throw new WrongType(localClassCastException9, "string-ref", 2, localObject1);
            }
          }
          arrayOfObject4 = new Object[2];
          arrayOfObject4[0] = localObject2;
          arrayOfObject5 = new Object[1];
          arrayOfObject5[0] = Char.make(i2);
          arrayOfObject4[1] = strings.$make$string$(arrayOfObject5);
          localObject2 = strings.stringAppend(arrayOfObject4);
          continue;
          localObject6 = pregexpListRef(paramObject4, localObject5);
          if (localObject6 != Boolean.FALSE)
          {
            arrayOfObject3 = new Object[2];
            arrayOfObject3[0] = localObject2;
          }
        }
        Object localObject7;
        Object localObject8;
        try
        {
          localCharSequence3 = (CharSequence)paramObject1;
          localObject7 = lists.car.apply1(localObject6);
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "substring", 1, paramObject1);
        }
        try
        {
          m = ((Number)localObject7).intValue();
          localObject8 = lists.cdr.apply1(localObject6);
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "substring", 2, localObject7);
        }
        try
        {
          n = ((Number)localObject8).intValue();
          arrayOfObject3[1] = strings.substring(localCharSequence3, m, n);
          localObject2 = strings.stringAppend(arrayOfObject3);
        }
        catch (ClassCastException localClassCastException7)
        {
          throw new WrongType(localClassCastException7, "substring", 3, localObject8);
        }
      }
      localObject1 = AddOp.$Pl.apply2(localObject1, Lit8);
      arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = localObject2;
      arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Char.make(j);
      arrayOfObject1[1] = strings.$make$string$(arrayOfObject2);
    }
  }
  
  public static Object pregexpReverse$Ex(Object paramObject)
  {
    Object localObject1 = LList.Empty;
    for (;;)
    {
      if (lists.isNull(paramObject)) {
        return localObject1;
      }
      Object localObject2 = lists.cdr.apply1(paramObject);
      try
      {
        Pair localPair = (Pair)paramObject;
        lists.setCdr$Ex(localPair, localObject1);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-cdr!", 1, paramObject);
      }
    }
  }
  
  public static Object pregexpSplit(Object paramObject1, Object paramObject2)
  {
    for (;;)
    {
      try
      {
        CharSequence localCharSequence1 = (CharSequence)paramObject2;
        i = strings.stringLength(localCharSequence1);
        localObject1 = Lit73;
        localObject2 = LList.Empty;
        localBoolean = Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          Object[] arrayOfObject;
          Object localObject3;
          Object localObject4;
          Object localObject6;
          Object localObject8;
          localCharSequence2 = (CharSequence)paramObject2;
        }
        catch (ClassCastException localClassCastException2)
        {
          int i;
          Object localObject2;
          Boolean localBoolean;
          Object localObject5;
          Object localObject9;
          Object localObject7;
          throw new WrongType(localClassCastException2, "substring", 1, paramObject2);
        }
        try
        {
          j = ((Number)localObject1).intValue();
          localObject2 = lists.cons(strings.substring(localCharSequence2, j, i), localObject2);
          localBoolean = Boolean.FALSE;
          localObject1 = localInteger;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "substring", 2, localObject1);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "string-length", 1, paramObject2);
      }
      if (Scheme.numGEq.apply2(localObject1, Integer.valueOf(i)) != Boolean.FALSE) {
        return pregexpReverse$Ex(localObject2);
      }
      arrayOfObject = new Object[2];
      arrayOfObject[0] = localObject1;
      arrayOfObject[1] = Integer.valueOf(i);
      localObject3 = pregexpMatchPositions$V(paramObject1, paramObject2, arrayOfObject);
      if (localObject3 != Boolean.FALSE)
      {
        localObject4 = lists.car.apply1(localObject3);
        localObject5 = lists.car.apply1(localObject4);
        localObject6 = lists.cdr.apply1(localObject4);
        if (Scheme.numEqu.apply2(localObject5, localObject6) != Boolean.FALSE) {
          localObject8 = AddOp.$Pl.apply2(localObject6, Lit8);
        }
      }
      try
      {
        localCharSequence4 = (CharSequence)paramObject2;
      }
      catch (ClassCastException localClassCastException8)
      {
        CharSequence localCharSequence4;
        int n;
        int i1;
        throw new WrongType(localClassCastException8, "substring", 1, paramObject2);
      }
      try
      {
        n = ((Number)localObject1).intValue();
        localObject9 = AddOp.$Pl.apply2(localObject5, Lit8);
      }
      catch (ClassCastException localClassCastException9)
      {
        throw new WrongType(localClassCastException9, "substring", 2, localObject1);
      }
      try
      {
        i1 = ((Number)localObject9).intValue();
        localObject2 = lists.cons(strings.substring(localCharSequence4, n, i1), localObject2);
        localBoolean = Boolean.TRUE;
        localObject1 = localObject8;
      }
      catch (ClassCastException localClassCastException10)
      {
        throw new WrongType(localClassCastException10, "substring", 3, localObject9);
      }
      localObject7 = Scheme.numEqu.apply2(localObject5, localObject1);
      try
      {
        boolean bool = ((Boolean)localObject7).booleanValue();
        if (bool)
        {
          if (localBoolean != Boolean.FALSE)
          {
            localBoolean = Boolean.FALSE;
            localObject1 = localObject6;
          }
        }
        else {
          if (bool) {
            continue;
          }
        }
      }
      catch (ClassCastException localClassCastException4)
      {
        CharSequence localCharSequence3;
        int k;
        int m;
        Integer localInteger;
        CharSequence localCharSequence2;
        int j;
        throw new WrongType(localClassCastException4, "x", -2, localObject7);
      }
      try
      {
        localCharSequence3 = (CharSequence)paramObject2;
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "substring", 1, paramObject2);
      }
      try
      {
        k = ((Number)localObject1).intValue();
      }
      catch (ClassCastException localClassCastException6)
      {
        throw new WrongType(localClassCastException6, "substring", 2, localObject1);
      }
      try
      {
        m = ((Number)localObject5).intValue();
        localObject2 = lists.cons(strings.substring(localCharSequence3, k, m), localObject2);
        localBoolean = Boolean.FALSE;
        localObject1 = localObject6;
      }
      catch (ClassCastException localClassCastException7)
      {
        throw new WrongType(localClassCastException7, "substring", 3, localObject5);
      }
    }
    localInteger = Integer.valueOf(i);
  }
  
  public static Object pregexpStringMatch(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    try
    {
      CharSequence localCharSequence1 = (CharSequence)paramObject1;
      i = strings.stringLength(localCharSequence1);
      if (Scheme.numGrt.apply2(Integer.valueOf(i), paramObject4) != Boolean.FALSE) {
        return Scheme.applyToArgs.apply1(paramObject6);
      }
      localObject1 = Lit73;
      localObject2 = paramObject3;
    }
    catch (ClassCastException localClassCastException1)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        try
        {
          int i;
          localCharSequence2 = (CharSequence)paramObject1;
        }
        catch (ClassCastException localClassCastException2)
        {
          CharSequence localCharSequence2;
          int j;
          Char localChar;
          CharSequence localCharSequence3;
          int k;
          throw new WrongType(localClassCastException2, "string-ref", 1, paramObject1);
        }
        try
        {
          j = ((Number)localObject1).intValue();
          localChar = Char.make(strings.stringRef(localCharSequence2, j));
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 2, localObject1);
        }
        try
        {
          localCharSequence3 = (CharSequence)paramObject2;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "string-ref", 1, paramObject2);
        }
        try
        {
          k = ((Number)localObject2).intValue();
          if (characters.isChar$Eq(localChar, Char.make(strings.stringRef(localCharSequence3, k))))
          {
            localObject1 = AddOp.$Pl.apply2(localObject1, Lit8);
            localObject2 = AddOp.$Pl.apply2(localObject2, Lit8);
          }
          else
          {
            return Scheme.applyToArgs.apply1(paramObject6);
          }
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "string-ref", 2, localObject2);
        }
      }
      localClassCastException1 = localClassCastException1;
      throw new WrongType(localClassCastException1, "string-length", 1, paramObject1);
    }
    if (Scheme.numGEq.apply2(localObject1, Integer.valueOf(i)) != Boolean.FALSE) {
      return Scheme.applyToArgs.apply2(paramObject5, localObject2);
    }
    if (Scheme.numGEq.apply2(localObject2, paramObject4) != Boolean.FALSE) {
      return Scheme.applyToArgs.apply1(paramObject6);
    }
  }
  
  /* Error */
  public static Object pregexpWrapQuantifierIfAny(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   3: aload_0
    //   4: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7: astore_3
    //   8: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   11: aload_0
    //   12: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: astore 4
    //   17: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   20: aload 4
    //   22: aload_2
    //   23: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   26: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   29: if_acmpeq +5 -> 34
    //   32: aload_0
    //   33: areturn
    //   34: aload_1
    //   35: checkcast 888	java/lang/CharSequence
    //   38: astore 6
    //   40: aload 4
    //   42: checkcast 890	java/lang/Number
    //   45: invokevirtual 894	java/lang/Number:intValue	()I
    //   48: istore 8
    //   50: aload 6
    //   52: iload 8
    //   54: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   57: istore 9
    //   59: iload 9
    //   61: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   64: invokestatic 954	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
    //   67: istore 10
    //   69: iload 10
    //   71: ifeq +28 -> 99
    //   74: getstatic 1010	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   77: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   80: if_acmpne +24 -> 104
    //   83: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   86: aload 4
    //   88: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   91: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: astore 4
    //   96: goto -79 -> 17
    //   99: iload 10
    //   101: ifne -18 -> 83
    //   104: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   107: iload 9
    //   109: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   112: getstatic 290	gnu/kawa/slib/pregexp:Lit65	Lgnu/text/Char;
    //   115: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   118: astore 11
    //   120: aload 11
    //   122: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   125: if_acmpeq +195 -> 320
    //   128: aload 11
    //   130: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   133: if_acmpeq -101 -> 32
    //   136: getstatic 369	gnu/kawa/slib/pregexp:Lit68	Lgnu/mapping/SimpleSymbol;
    //   139: invokestatic 1185	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   142: astore 14
    //   144: aload 14
    //   146: getstatic 534	gnu/kawa/slib/pregexp:Lit69	Lgnu/mapping/SimpleSymbol;
    //   149: getstatic 530	gnu/kawa/slib/pregexp:Lit70	Lgnu/mapping/SimpleSymbol;
    //   152: getstatic 526	gnu/kawa/slib/pregexp:Lit71	Lgnu/mapping/SimpleSymbol;
    //   155: aload_3
    //   156: invokestatic 1253	gnu/lists/LList:chain4	(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   159: pop
    //   160: aload 14
    //   162: getstatic 522	gnu/kawa/slib/pregexp:Lit72	Lgnu/mapping/SimpleSymbol;
    //   165: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   168: astore 16
    //   170: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   173: iload 9
    //   175: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   178: getstatic 290	gnu/kawa/slib/pregexp:Lit65	Lgnu/text/Char;
    //   181: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   184: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   187: if_acmpeq +226 -> 413
    //   190: getstatic 1256	kawa/lib/lists:cddr	Lgnu/expr/GenericProc;
    //   193: aload 14
    //   195: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   198: astore 63
    //   200: aload 63
    //   202: checkcast 1050	gnu/lists/Pair
    //   205: astore 65
    //   207: aload 65
    //   209: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   212: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   215: getstatic 1259	kawa/lib/lists:cdddr	Lgnu/expr/GenericProc;
    //   218: aload 14
    //   220: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   223: astore 66
    //   225: aload 66
    //   227: checkcast 1050	gnu/lists/Pair
    //   230: astore 68
    //   232: aload 68
    //   234: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   237: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   240: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   243: aload 4
    //   245: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   248: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   251: astore 24
    //   253: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   256: aload 24
    //   258: aload_2
    //   259: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   262: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   265: if_acmpeq +439 -> 704
    //   268: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   271: aload 14
    //   273: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   276: astore 43
    //   278: aload 43
    //   280: checkcast 1050	gnu/lists/Pair
    //   283: astore 45
    //   285: aload 45
    //   287: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   290: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   293: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   296: aload 16
    //   298: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   301: astore 46
    //   303: aload 46
    //   305: checkcast 1050	gnu/lists/Pair
    //   308: astore 48
    //   310: aload 48
    //   312: aload 24
    //   314: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   317: aload 16
    //   319: areturn
    //   320: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   323: iload 9
    //   325: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   328: getstatic 292	gnu/kawa/slib/pregexp:Lit66	Lgnu/text/Char;
    //   331: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   334: astore 12
    //   336: aload 12
    //   338: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   341: if_acmpeq +14 -> 355
    //   344: aload 12
    //   346: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   349: if_acmpeq -317 -> 32
    //   352: goto -216 -> 136
    //   355: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   358: iload 9
    //   360: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   363: getstatic 288	gnu/kawa/slib/pregexp:Lit47	Lgnu/text/Char;
    //   366: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   369: astore 13
    //   371: aload 13
    //   373: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   376: if_acmpeq +14 -> 390
    //   379: aload 13
    //   381: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   384: if_acmpeq -352 -> 32
    //   387: goto -251 -> 136
    //   390: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   393: iload 9
    //   395: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   398: getstatic 304	gnu/kawa/slib/pregexp:Lit67	Lgnu/text/Char;
    //   401: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   404: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   407: if_acmpeq -375 -> 32
    //   410: goto -274 -> 136
    //   413: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   416: iload 9
    //   418: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   421: getstatic 292	gnu/kawa/slib/pregexp:Lit66	Lgnu/text/Char;
    //   424: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   427: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   430: if_acmpeq +56 -> 486
    //   433: getstatic 1256	kawa/lib/lists:cddr	Lgnu/expr/GenericProc;
    //   436: aload 14
    //   438: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   441: astore 57
    //   443: aload 57
    //   445: checkcast 1050	gnu/lists/Pair
    //   448: astore 59
    //   450: aload 59
    //   452: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   455: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   458: getstatic 1259	kawa/lib/lists:cdddr	Lgnu/expr/GenericProc;
    //   461: aload 14
    //   463: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   466: astore 60
    //   468: aload 60
    //   470: checkcast 1050	gnu/lists/Pair
    //   473: astore 62
    //   475: aload 62
    //   477: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   480: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   483: goto -243 -> 240
    //   486: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   489: iload 9
    //   491: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   494: getstatic 288	gnu/kawa/slib/pregexp:Lit47	Lgnu/text/Char;
    //   497: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   500: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   503: if_acmpeq +56 -> 559
    //   506: getstatic 1256	kawa/lib/lists:cddr	Lgnu/expr/GenericProc;
    //   509: aload 14
    //   511: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   514: astore 51
    //   516: aload 51
    //   518: checkcast 1050	gnu/lists/Pair
    //   521: astore 53
    //   523: aload 53
    //   525: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   528: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   531: getstatic 1259	kawa/lib/lists:cdddr	Lgnu/expr/GenericProc;
    //   534: aload 14
    //   536: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   539: astore 54
    //   541: aload 54
    //   543: checkcast 1050	gnu/lists/Pair
    //   546: astore 56
    //   548: aload 56
    //   550: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   553: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   556: goto -316 -> 240
    //   559: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   562: iload 9
    //   564: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   567: getstatic 304	gnu/kawa/slib/pregexp:Lit67	Lgnu/text/Char;
    //   570: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   573: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   576: if_acmpeq -336 -> 240
    //   579: aload_1
    //   580: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   583: aload 4
    //   585: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   588: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   591: aload_2
    //   592: invokestatic 1261	gnu/kawa/slib/pregexp:pregexpReadNums	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   595: astore 17
    //   597: aload 17
    //   599: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   602: if_acmpne +29 -> 631
    //   605: iconst_2
    //   606: anewarray 965	java/lang/Object
    //   609: astore 49
    //   611: aload 49
    //   613: iconst_0
    //   614: getstatic 518	gnu/kawa/slib/pregexp:Lit74	Lgnu/mapping/SimpleSymbol;
    //   617: aastore
    //   618: aload 49
    //   620: iconst_1
    //   621: getstatic 514	gnu/kawa/slib/pregexp:Lit75	Lgnu/mapping/SimpleSymbol;
    //   624: aastore
    //   625: aload 49
    //   627: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   630: pop
    //   631: getstatic 1256	kawa/lib/lists:cddr	Lgnu/expr/GenericProc;
    //   634: aload 14
    //   636: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   639: astore 18
    //   641: aload 18
    //   643: checkcast 1050	gnu/lists/Pair
    //   646: astore 20
    //   648: aload 20
    //   650: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   653: aload 17
    //   655: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   658: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   661: getstatic 1259	kawa/lib/lists:cdddr	Lgnu/expr/GenericProc;
    //   664: aload 14
    //   666: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   669: astore 21
    //   671: aload 21
    //   673: checkcast 1050	gnu/lists/Pair
    //   676: astore 23
    //   678: aload 23
    //   680: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   683: aload 17
    //   685: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   688: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   691: getstatic 1264	kawa/lib/lists:caddr	Lgnu/expr/GenericProc;
    //   694: aload 17
    //   696: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   699: astore 4
    //   701: goto -461 -> 240
    //   704: aload_1
    //   705: checkcast 888	java/lang/CharSequence
    //   708: astore 26
    //   710: aload 24
    //   712: checkcast 890	java/lang/Number
    //   715: invokevirtual 894	java/lang/Number:intValue	()I
    //   718: istore 28
    //   720: aload 26
    //   722: iload 28
    //   724: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   727: istore 29
    //   729: iload 29
    //   731: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   734: invokestatic 954	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
    //   737: istore 30
    //   739: iload 30
    //   741: ifeq +28 -> 769
    //   744: getstatic 1010	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   747: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   750: if_acmpne +24 -> 774
    //   753: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   756: aload 24
    //   758: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   761: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   764: astore 24
    //   766: goto -513 -> 253
    //   769: iload 30
    //   771: ifne -18 -> 753
    //   774: iload 29
    //   776: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   779: getstatic 288	gnu/kawa/slib/pregexp:Lit47	Lgnu/text/Char;
    //   782: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   785: ifeq +64 -> 849
    //   788: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   791: aload 14
    //   793: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   796: astore 37
    //   798: aload 37
    //   800: checkcast 1050	gnu/lists/Pair
    //   803: astore 39
    //   805: aload 39
    //   807: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   810: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   813: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   816: aload 16
    //   818: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   821: astore 40
    //   823: aload 40
    //   825: checkcast 1050	gnu/lists/Pair
    //   828: astore 42
    //   830: aload 42
    //   832: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   835: aload 24
    //   837: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   840: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   843: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   846: goto -529 -> 317
    //   849: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   852: aload 14
    //   854: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   857: astore 31
    //   859: aload 31
    //   861: checkcast 1050	gnu/lists/Pair
    //   864: astore 33
    //   866: aload 33
    //   868: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   871: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   874: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   877: aload 16
    //   879: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   882: astore 34
    //   884: aload 34
    //   886: checkcast 1050	gnu/lists/Pair
    //   889: astore 36
    //   891: aload 36
    //   893: aload 24
    //   895: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   898: goto -581 -> 317
    //   901: astore 5
    //   903: new 911	gnu/mapping/WrongType
    //   906: dup
    //   907: aload 5
    //   909: ldc_w 918
    //   912: iconst_1
    //   913: aload_1
    //   914: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   917: athrow
    //   918: astore 7
    //   920: new 911	gnu/mapping/WrongType
    //   923: dup
    //   924: aload 7
    //   926: ldc_w 918
    //   929: iconst_2
    //   930: aload 4
    //   932: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   935: athrow
    //   936: astore 64
    //   938: new 911	gnu/mapping/WrongType
    //   941: dup
    //   942: aload 64
    //   944: ldc_w 1068
    //   947: iconst_1
    //   948: aload 63
    //   950: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   953: athrow
    //   954: astore 67
    //   956: new 911	gnu/mapping/WrongType
    //   959: dup
    //   960: aload 67
    //   962: ldc_w 1068
    //   965: iconst_1
    //   966: aload 66
    //   968: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   971: athrow
    //   972: astore 58
    //   974: new 911	gnu/mapping/WrongType
    //   977: dup
    //   978: aload 58
    //   980: ldc_w 1068
    //   983: iconst_1
    //   984: aload 57
    //   986: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   989: athrow
    //   990: astore 61
    //   992: new 911	gnu/mapping/WrongType
    //   995: dup
    //   996: aload 61
    //   998: ldc_w 1068
    //   1001: iconst_1
    //   1002: aload 60
    //   1004: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1007: athrow
    //   1008: astore 52
    //   1010: new 911	gnu/mapping/WrongType
    //   1013: dup
    //   1014: aload 52
    //   1016: ldc_w 1068
    //   1019: iconst_1
    //   1020: aload 51
    //   1022: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1025: athrow
    //   1026: astore 55
    //   1028: new 911	gnu/mapping/WrongType
    //   1031: dup
    //   1032: aload 55
    //   1034: ldc_w 1068
    //   1037: iconst_1
    //   1038: aload 54
    //   1040: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1043: athrow
    //   1044: astore 19
    //   1046: new 911	gnu/mapping/WrongType
    //   1049: dup
    //   1050: aload 19
    //   1052: ldc_w 1068
    //   1055: iconst_1
    //   1056: aload 18
    //   1058: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1061: athrow
    //   1062: astore 22
    //   1064: new 911	gnu/mapping/WrongType
    //   1067: dup
    //   1068: aload 22
    //   1070: ldc_w 1068
    //   1073: iconst_1
    //   1074: aload 21
    //   1076: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1079: athrow
    //   1080: astore 44
    //   1082: new 911	gnu/mapping/WrongType
    //   1085: dup
    //   1086: aload 44
    //   1088: ldc_w 1068
    //   1091: iconst_1
    //   1092: aload 43
    //   1094: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1097: athrow
    //   1098: astore 47
    //   1100: new 911	gnu/mapping/WrongType
    //   1103: dup
    //   1104: aload 47
    //   1106: ldc_w 1068
    //   1109: iconst_1
    //   1110: aload 46
    //   1112: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1115: athrow
    //   1116: astore 25
    //   1118: new 911	gnu/mapping/WrongType
    //   1121: dup
    //   1122: aload 25
    //   1124: ldc_w 918
    //   1127: iconst_1
    //   1128: aload_1
    //   1129: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1132: athrow
    //   1133: astore 27
    //   1135: new 911	gnu/mapping/WrongType
    //   1138: dup
    //   1139: aload 27
    //   1141: ldc_w 918
    //   1144: iconst_2
    //   1145: aload 24
    //   1147: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1150: athrow
    //   1151: astore 38
    //   1153: new 911	gnu/mapping/WrongType
    //   1156: dup
    //   1157: aload 38
    //   1159: ldc_w 1068
    //   1162: iconst_1
    //   1163: aload 37
    //   1165: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1168: athrow
    //   1169: astore 41
    //   1171: new 911	gnu/mapping/WrongType
    //   1174: dup
    //   1175: aload 41
    //   1177: ldc_w 1068
    //   1180: iconst_1
    //   1181: aload 40
    //   1183: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1186: athrow
    //   1187: astore 32
    //   1189: new 911	gnu/mapping/WrongType
    //   1192: dup
    //   1193: aload 32
    //   1195: ldc_w 1068
    //   1198: iconst_1
    //   1199: aload 31
    //   1201: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1204: athrow
    //   1205: astore 35
    //   1207: new 911	gnu/mapping/WrongType
    //   1210: dup
    //   1211: aload 35
    //   1213: ldc_w 1068
    //   1216: iconst_1
    //   1217: aload 34
    //   1219: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1223	0	paramObject1	Object
    //   0	1223	1	paramObject2	Object
    //   0	1223	2	paramObject3	Object
    //   7	149	3	localObject1	Object
    //   15	916	4	localObject2	Object
    //   901	7	5	localClassCastException1	ClassCastException
    //   38	13	6	localCharSequence1	CharSequence
    //   918	7	7	localClassCastException2	ClassCastException
    //   48	5	8	i	int
    //   57	506	9	j	int
    //   67	33	10	bool1	boolean
    //   118	11	11	localObject3	Object
    //   334	11	12	localObject4	Object
    //   369	11	13	localObject5	Object
    //   142	711	14	localPair1	Pair
    //   168	710	16	localPair2	Pair
    //   595	100	17	localObject6	Object
    //   639	418	18	localObject7	Object
    //   1044	7	19	localClassCastException3	ClassCastException
    //   646	3	20	localPair3	Pair
    //   669	406	21	localObject8	Object
    //   1062	7	22	localClassCastException4	ClassCastException
    //   676	3	23	localPair4	Pair
    //   251	895	24	localObject9	Object
    //   1116	7	25	localClassCastException5	ClassCastException
    //   708	13	26	localCharSequence2	CharSequence
    //   1133	7	27	localClassCastException6	ClassCastException
    //   718	5	28	k	int
    //   727	48	29	m	int
    //   737	33	30	bool2	boolean
    //   857	343	31	localObject10	Object
    //   1187	7	32	localClassCastException7	ClassCastException
    //   864	3	33	localPair5	Pair
    //   882	336	34	localObject11	Object
    //   1205	7	35	localClassCastException8	ClassCastException
    //   889	3	36	localPair6	Pair
    //   796	368	37	localObject12	Object
    //   1151	7	38	localClassCastException9	ClassCastException
    //   803	3	39	localPair7	Pair
    //   821	361	40	localObject13	Object
    //   1169	7	41	localClassCastException10	ClassCastException
    //   828	3	42	localPair8	Pair
    //   276	817	43	localObject14	Object
    //   1080	7	44	localClassCastException11	ClassCastException
    //   283	3	45	localPair9	Pair
    //   301	810	46	localObject15	Object
    //   1098	7	47	localClassCastException12	ClassCastException
    //   308	3	48	localPair10	Pair
    //   609	17	49	arrayOfObject	Object[]
    //   514	507	51	localObject16	Object
    //   1008	7	52	localClassCastException13	ClassCastException
    //   521	3	53	localPair11	Pair
    //   539	500	54	localObject17	Object
    //   1026	7	55	localClassCastException14	ClassCastException
    //   546	3	56	localPair12	Pair
    //   441	544	57	localObject18	Object
    //   972	7	58	localClassCastException15	ClassCastException
    //   448	3	59	localPair13	Pair
    //   466	537	60	localObject19	Object
    //   990	7	61	localClassCastException16	ClassCastException
    //   473	3	62	localPair14	Pair
    //   198	751	63	localObject20	Object
    //   936	7	64	localClassCastException17	ClassCastException
    //   205	3	65	localPair15	Pair
    //   223	744	66	localObject21	Object
    //   954	7	67	localClassCastException18	ClassCastException
    //   230	3	68	localPair16	Pair
    // Exception table:
    //   from	to	target	type
    //   34	40	901	java/lang/ClassCastException
    //   40	50	918	java/lang/ClassCastException
    //   200	207	936	java/lang/ClassCastException
    //   225	232	954	java/lang/ClassCastException
    //   443	450	972	java/lang/ClassCastException
    //   468	475	990	java/lang/ClassCastException
    //   516	523	1008	java/lang/ClassCastException
    //   541	548	1026	java/lang/ClassCastException
    //   641	648	1044	java/lang/ClassCastException
    //   671	678	1062	java/lang/ClassCastException
    //   278	285	1080	java/lang/ClassCastException
    //   303	310	1098	java/lang/ClassCastException
    //   704	710	1116	java/lang/ClassCastException
    //   710	720	1133	java/lang/ClassCastException
    //   798	805	1151	java/lang/ClassCastException
    //   823	830	1169	java/lang/ClassCastException
    //   859	866	1187	java/lang/ClassCastException
    //   884	891	1205	java/lang/ClassCastException
  }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply0(paramModuleMethod);
    case 36: 
      return frame.lambda4();
    case 37: 
      return frame0.lambda13();
    case 38: 
      return frame0.lambda14();
    case 39: 
      return frame0.lambda15();
    case 40: 
      return frame0.lambda16();
    }
    return frame0.lambda17();
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 16: 
      return pregexpReverse$Ex(paramObject);
    case 28: 
      return pregexpInvertCharList(paramObject);
    case 31: 
      if (isPregexpCharWord(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 35: 
      return pregexpMakeBackrefList(paramObject);
    case 44: 
      return pregexp(paramObject);
    }
    return pregexpQuote(paramObject);
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    case 33: 
      return isPregexpCheckIfInCharClass(paramObject1, paramObject2);
    case 34: 
      return pregexpListRef(paramObject1, paramObject2);
    }
    return pregexpSplit(paramObject1, paramObject2);
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (paramModuleMethod.selector)
    {
    case 28: 
    case 30: 
    case 31: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
    default: 
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    case 18: 
      return pregexpReadPattern(paramObject1, paramObject2, paramObject3);
    case 19: 
      return pregexpReadBranch(paramObject1, paramObject2, paramObject3);
    case 20: 
      return pregexpReadPiece(paramObject1, paramObject2, paramObject3);
    case 21: 
      return pregexpReadEscapedNumber(paramObject1, paramObject2, paramObject3);
    case 22: 
      return pregexpReadEscapedChar(paramObject1, paramObject2, paramObject3);
    case 23: 
      return pregexpReadPosixCharClass(paramObject1, paramObject2, paramObject3);
    case 24: 
      return pregexpReadClusterType(paramObject1, paramObject2, paramObject3);
    case 25: 
      return pregexpReadSubpattern(paramObject1, paramObject2, paramObject3);
    case 26: 
      return pregexpWrapQuantifierIfAny(paramObject1, paramObject2, paramObject3);
    case 27: 
      return pregexpReadNums(paramObject1, paramObject2, paramObject3);
    case 29: 
      return pregexpReadCharList(paramObject1, paramObject2, paramObject3);
    case 32: 
      return isPregexpAtWordBoundary(paramObject1, paramObject2, paramObject3);
    case 48: 
      return pregexpReplace(paramObject1, paramObject2, paramObject3);
    }
    return pregexpReplace$St(paramObject1, paramObject2, paramObject3);
  }
  
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (paramModuleMethod.selector == 43) {
      return pregexpReplaceAux(paramObject1, paramObject2, paramObject3, paramObject4);
    }
    return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 17: 
      return pregexpError$V(paramArrayOfObject);
    case 30: 
      return pregexpStringMatch(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5]);
    case 42: 
      return pregexpMatchPositionsAux(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5]);
    case 45: 
      Object localObject3 = paramArrayOfObject[0];
      Object localObject4 = paramArrayOfObject[1];
      int j = -2 + paramArrayOfObject.length;
      Object[] arrayOfObject2 = new Object[j];
      for (;;)
      {
        j--;
        if (j < 0) {
          return pregexpMatchPositions$V(localObject3, localObject4, arrayOfObject2);
        }
        arrayOfObject2[j] = paramArrayOfObject[(j + 2)];
      }
    }
    Object localObject1 = paramArrayOfObject[0];
    Object localObject2 = paramArrayOfObject[1];
    int i = -2 + paramArrayOfObject.length;
    Object[] arrayOfObject1 = new Object[i];
    for (;;)
    {
      i--;
      if (i < 0) {
        return pregexpMatch$V(localObject1, localObject2, arrayOfObject1);
      }
      arrayOfObject1[i] = paramArrayOfObject[(i + 2)];
    }
  }
  
  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match0(paramModuleMethod, paramCallContext);
    case 41: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 40: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 39: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 38: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 37: 
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
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 50: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 44: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 35: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 31: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 28: 
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
    case 47: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 34: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
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
    case 28: 
    case 30: 
    case 31: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
    default: 
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 49: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 48: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 32: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 29: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 27: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 26: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 25: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 24: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 23: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 22: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 21: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 20: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 19: 
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
  
  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 43)
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    }
    return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 46: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 45: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 42: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 30: 
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
    $Stpregexp$Mnversion$St = Lit0;
    $Stpregexp$Mncomment$Mnchar$St = Lit1;
    $Stpregexp$Mnnul$Mnchar$Mnint$St = Integer.valueOf(-97 + characters.char$To$Integer(Lit2));
    $Stpregexp$Mnreturn$Mnchar$St = characters.integer$To$Char(13 + ((Number)$Stpregexp$Mnnul$Mnchar$Mnint$St).intValue());
    $Stpregexp$Mntab$Mnchar$St = characters.integer$To$Char(9 + ((Number)$Stpregexp$Mnnul$Mnchar$Mnint$St).intValue());
    $Stpregexp$Mnspace$Mnsensitive$Qu$St = Boolean.TRUE;
  }
  
  public class frame
    extends ModuleBody
  {
    Object backrefs;
    Object case$Mnsensitive$Qu;
    Procedure identity;
    Object n;
    Object s;
    Object sn;
    Object start;
    
    public frame()
    {
      this$1 = new ModuleMethod(this, 15, pregexp.Lit112, 4097);
      this$1.setProperty("source-location", "pregexp.scm:460");
      this.identity = this$1;
    }
    
    public static Object lambda2identity(Object paramObject)
    {
      return paramObject;
    }
    
    static Boolean lambda4()
    {
      return Boolean.FALSE;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 15) {
        return lambda2identity(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    public Object lambda3sub(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      pregexp.frame0 localframe0 = new pregexp.frame0();
      localframe0.staticLink = this;
      localframe0.re$1 = paramObject1;
      localframe0.i = paramObject2;
      localframe0.sk = paramObject3;
      localframe0.fk = paramObject4;
      if (Scheme.isEqv.apply2(localframe0.re$1, pregexp.Lit10) != Boolean.FALSE)
      {
        if (Scheme.numEqu.apply2(localframe0.i, this.start) != Boolean.FALSE) {
          return Scheme.applyToArgs.apply2(localframe0.sk, localframe0.i);
        }
        return Scheme.applyToArgs.apply1(localframe0.fk);
      }
      if (Scheme.isEqv.apply2(localframe0.re$1, pregexp.Lit12) != Boolean.FALSE)
      {
        if (Scheme.numGEq.apply2(localframe0.i, this.n) != Boolean.FALSE) {
          return Scheme.applyToArgs.apply2(localframe0.sk, localframe0.i);
        }
        return Scheme.applyToArgs.apply1(localframe0.fk);
      }
      if (Scheme.isEqv.apply2(localframe0.re$1, pregexp.Lit23) != Boolean.FALSE) {
        return Scheme.applyToArgs.apply2(localframe0.sk, localframe0.i);
      }
      if (Scheme.isEqv.apply2(localframe0.re$1, pregexp.Lit26) != Boolean.FALSE)
      {
        if (pregexp.isPregexpAtWordBoundary(this.s, localframe0.i, this.n) != Boolean.FALSE) {
          return Scheme.applyToArgs.apply2(localframe0.sk, localframe0.i);
        }
        return Scheme.applyToArgs.apply1(localframe0.fk);
      }
      if (Scheme.isEqv.apply2(localframe0.re$1, pregexp.Lit28) != Boolean.FALSE)
      {
        if (pregexp.isPregexpAtWordBoundary(this.s, localframe0.i, this.n) != Boolean.FALSE) {
          return Scheme.applyToArgs.apply1(localframe0.fk);
        }
        return Scheme.applyToArgs.apply2(localframe0.sk, localframe0.i);
      }
      boolean bool1 = characters.isChar(localframe0.re$1);
      ModuleMethod localModuleMethod2;
      if (bool1)
      {
        if (Scheme.numLss.apply2(localframe0.i, this.n) == Boolean.FALSE) {
          break label497;
        }
        if (this.case$Mnsensitive$Qu == Boolean.FALSE) {
          break label617;
        }
        localModuleMethod2 = characters.char$Eq$Qu;
        label410:
        localObject23 = this.s;
      }
      for (;;)
      {
        for (;;)
        {
          label497:
          Object localObject21;
          Object localObject22;
          for (;;)
          {
            Object localObject24;
            try
            {
              localCharSequence4 = (CharSequence)localObject23;
              localObject24 = localframe0.i;
            }
            catch (ClassCastException localClassCastException10)
            {
              CharSequence localCharSequence4;
              int i6;
              int i;
              CharSequence localCharSequence3;
              int i5;
              label617:
              boolean bool2;
              Object localObject20;
              CharSequence localCharSequence1;
              int j;
              int k;
              ModuleMethod localModuleMethod1;
              Object localObject3;
              Object localObject4;
              Object[] arrayOfObject4;
              Object localObject15;
              Object localObject16;
              CharSequence localCharSequence2;
              int i3;
              int i4;
              Object[] arrayOfObject3;
              Object localObject12;
              Object localObject13;
              Object localObject14;
              Object localObject9;
              Object localObject10;
              Object localObject11;
              Object localObject8;
              Object localObject5;
              throw new WrongType(localClassCastException10, "string-ref", 1, localObject23);
            }
            try
            {
              i6 = ((Number)localObject24).intValue();
              if (localModuleMethod2.apply2(Char.make(strings.stringRef(localCharSequence4, i6)), localframe0.re$1) != Boolean.FALSE)
              {
                return Scheme.applyToArgs.apply2(localframe0.sk, AddOp.$Pl.apply2(localframe0.i, pregexp.Lit8));
                if (bool1) {
                  break;
                }
                i = 0x1 & true + lists.isPair(localframe0.re$1);
                if (i == 0) {
                  continue;
                }
                if (Scheme.numLss.apply2(localframe0.i, this.n) == Boolean.FALSE) {
                  continue;
                }
                localObject21 = this.s;
              }
            }
            catch (ClassCastException localClassCastException11)
            {
              throw new WrongType(localClassCastException11, "string-ref", 2, localObject24);
            }
          }
          try
          {
            localCharSequence3 = (CharSequence)localObject21;
            localObject22 = localframe0.i;
          }
          catch (ClassCastException localClassCastException8)
          {
            throw new WrongType(localClassCastException8, "string-ref", 1, localObject21);
          }
          try
          {
            i5 = ((Number)localObject22).intValue();
            if (pregexp.isPregexpCheckIfInCharClass(Char.make(strings.stringRef(localCharSequence3, i5)), localframe0.re$1) != Boolean.FALSE)
            {
              return Scheme.applyToArgs.apply2(localframe0.sk, AddOp.$Pl.apply2(localframe0.i, pregexp.Lit8));
              localModuleMethod2 = unicode.char$Mnci$Eq$Qu;
              break label410;
              return Scheme.applyToArgs.apply1(localframe0.fk);
              if (i != 0) {
                continue;
              }
              bool2 = lists.isPair(localframe0.re$1);
              if (!bool2) {
                continue;
              }
              localObject20 = Scheme.isEqv.apply2(lists.car.apply1(localframe0.re$1), pregexp.Lit83);
              if (localObject20 == Boolean.FALSE) {
                continue;
              }
              if (Scheme.numLss.apply2(localframe0.i, this.n) == Boolean.FALSE) {
                continue;
              }
              localObject1 = this.s;
            }
          }
          catch (ClassCastException localClassCastException9)
          {
            throw new WrongType(localClassCastException9, "string-ref", 2, localObject22);
          }
        }
        try
        {
          localCharSequence1 = (CharSequence)localObject1;
          localObject2 = localframe0.i;
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "string-ref", 1, localObject1);
        }
        try
        {
          j = ((Number)localObject2).intValue();
          k = strings.stringRef(localCharSequence1, j);
          if (this.case$Mnsensitive$Qu != Boolean.FALSE)
          {
            localModuleMethod1 = characters.char$Ls$Eq$Qu;
            localObject3 = localModuleMethod1.apply2(lists.cadr.apply1(localframe0.re$1), Char.make(k));
            if (localObject3 != Boolean.FALSE)
            {
              if (localModuleMethod1.apply2(Char.make(k), lists.caddr.apply1(localframe0.re$1)) == Boolean.FALSE) {
                continue;
              }
              return Scheme.applyToArgs.apply2(localframe0.sk, AddOp.$Pl.apply2(localframe0.i, pregexp.Lit8));
              return Scheme.applyToArgs.apply1(localframe0.fk);
              if (localObject20 != Boolean.FALSE) {
                continue;
              }
              if (!lists.isPair(localframe0.re$1)) {
                continue;
              }
              localObject4 = lists.car.apply1(localframe0.re$1);
              if (Scheme.isEqv.apply2(localObject4, pregexp.Lit83) == Boolean.FALSE) {
                continue;
              }
              if (Scheme.numGEq.apply2(localframe0.i, this.n) == Boolean.FALSE) {
                continue;
              }
              return Scheme.applyToArgs.apply1(localframe0.fk);
              if (!bool2) {
                continue;
              }
            }
          }
          else
          {
            localModuleMethod1 = unicode.char$Mnci$Ls$Eq$Qu;
            continue;
          }
          if (localObject3 != Boolean.FALSE) {
            continue;
          }
          return Scheme.applyToArgs.apply1(localframe0.fk);
          arrayOfObject4 = new Object[1];
          arrayOfObject4[0] = pregexp.Lit101;
          return pregexp.pregexpError$V(arrayOfObject4);
          if (Scheme.isEqv.apply2(localObject4, pregexp.Lit82) != Boolean.FALSE)
          {
            if (Scheme.numGEq.apply2(localframe0.i, this.n) != Boolean.FALSE) {
              return Scheme.applyToArgs.apply1(localframe0.fk);
            }
            return localframe0.lambda5loupOneOfChars(lists.cdr.apply1(localframe0.re$1));
          }
          if (Scheme.isEqv.apply2(localObject4, pregexp.Lit17) != Boolean.FALSE)
          {
            if (Scheme.numGEq.apply2(localframe0.i, this.n) != Boolean.FALSE) {
              return Scheme.applyToArgs.apply1(localframe0.fk);
            }
            return lambda3sub(lists.cadr.apply1(localframe0.re$1), localframe0.i, localframe0.lambda$Fn2, localframe0.lambda$Fn3);
          }
          if (Scheme.isEqv.apply2(localObject4, pregexp.Lit5) != Boolean.FALSE) {
            return localframe0.lambda6loupSeq(lists.cdr.apply1(localframe0.re$1), localframe0.i);
          }
          if (Scheme.isEqv.apply2(localObject4, pregexp.Lit4) != Boolean.FALSE) {
            return localframe0.lambda7loupOr(lists.cdr.apply1(localframe0.re$1));
          }
          if (Scheme.isEqv.apply2(localObject4, pregexp.Lit20) != Boolean.FALSE)
          {
            localObject15 = pregexp.pregexpListRef(this.backrefs, lists.cadr.apply1(localframe0.re$1));
            if (localObject15 != Boolean.FALSE)
            {
              localObject16 = lists.cdr.apply1(localObject15);
              if (localObject16 == Boolean.FALSE) {
                continue;
              }
              localObject17 = this.s;
            }
          }
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-ref", 2, localObject2);
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject17;
          localObject18 = lists.car.apply1(localObject16);
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "substring", 1, localObject17);
        }
        try
        {
          i3 = ((Number)localObject18).intValue();
          localObject19 = lists.cdr.apply1(localObject16);
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "substring", 2, localObject18);
        }
        try
        {
          i4 = ((Number)localObject19).intValue();
          return pregexp.pregexpStringMatch(strings.substring(localCharSequence2, i3, i4), this.s, localframe0.i, this.n, localframe0.lambda$Fn4, localframe0.fk);
        }
        catch (ClassCastException localClassCastException7)
        {
          throw new WrongType(localClassCastException7, "substring", 3, localObject19);
        }
        arrayOfObject3 = new Object[3];
        arrayOfObject3[0] = pregexp.Lit101;
        arrayOfObject3[1] = pregexp.Lit102;
        arrayOfObject3[2] = localframe0.re$1;
        pregexp.pregexpError$V(arrayOfObject3);
        localObject16 = Boolean.FALSE;
      }
      return Scheme.applyToArgs.apply2(localframe0.sk, localframe0.i);
      if (Scheme.isEqv.apply2(localObject4, pregexp.Lit100) != Boolean.FALSE) {
        return lambda3sub(lists.cadr.apply1(localframe0.re$1), localframe0.i, localframe0.lambda$Fn5, localframe0.fk);
      }
      if (Scheme.isEqv.apply2(localObject4, pregexp.Lit103) != Boolean.FALSE)
      {
        if (lambda3sub(lists.cadr.apply1(localframe0.re$1), localframe0.i, this.identity, pregexp.lambda$Fn6) != Boolean.FALSE) {
          return Scheme.applyToArgs.apply2(localframe0.sk, localframe0.i);
        }
        return Scheme.applyToArgs.apply1(localframe0.fk);
      }
      if (Scheme.isEqv.apply2(localObject4, pregexp.Lit104) != Boolean.FALSE)
      {
        if (lambda3sub(lists.cadr.apply1(localframe0.re$1), localframe0.i, this.identity, pregexp.lambda$Fn7) != Boolean.FALSE) {
          return Scheme.applyToArgs.apply1(localframe0.fk);
        }
        return Scheme.applyToArgs.apply2(localframe0.sk, localframe0.i);
      }
      if (Scheme.isEqv.apply2(localObject4, pregexp.Lit105) != Boolean.FALSE)
      {
        localObject12 = this.n;
        localObject13 = this.sn;
        this.n = localframe0.i;
        this.sn = localframe0.i;
        localObject14 = lambda3sub(LList.list4(pregexp.Lit5, pregexp.Lit106, lists.cadr.apply1(localframe0.re$1), pregexp.Lit12), pregexp.Lit73, this.identity, pregexp.lambda$Fn8);
        this.n = localObject12;
        this.sn = localObject13;
        if (localObject14 != Boolean.FALSE) {
          return Scheme.applyToArgs.apply2(localframe0.sk, localframe0.i);
        }
        return Scheme.applyToArgs.apply1(localframe0.fk);
      }
      if (Scheme.isEqv.apply2(localObject4, pregexp.Lit107) != Boolean.FALSE)
      {
        localObject9 = this.n;
        localObject10 = this.sn;
        this.n = localframe0.i;
        this.sn = localframe0.i;
        localObject11 = lambda3sub(LList.list4(pregexp.Lit5, pregexp.Lit108, lists.cadr.apply1(localframe0.re$1), pregexp.Lit12), pregexp.Lit73, this.identity, pregexp.lambda$Fn9);
        this.n = localObject9;
        this.sn = localObject10;
        if (localObject11 != Boolean.FALSE) {
          return Scheme.applyToArgs.apply1(localframe0.fk);
        }
        return Scheme.applyToArgs.apply2(localframe0.sk, localframe0.i);
      }
      if (Scheme.isEqv.apply2(localObject4, pregexp.Lit109) != Boolean.FALSE)
      {
        localObject8 = lambda3sub(lists.cadr.apply1(localframe0.re$1), localframe0.i, this.identity, pregexp.lambda$Fn10);
        if (localObject8 != Boolean.FALSE) {
          return Scheme.applyToArgs.apply2(localframe0.sk, localObject8);
        }
        return Scheme.applyToArgs.apply1(localframe0.fk);
      }
      localObject5 = Scheme.isEqv.apply2(localObject4, pregexp.Lit60);
      if (localObject5 != Boolean.FALSE)
      {
        if (localObject5 == Boolean.FALSE) {}
      }
      else {
        while (Scheme.isEqv.apply2(localObject4, pregexp.Lit61) != Boolean.FALSE)
        {
          localframe0.old = this.case$Mnsensitive$Qu;
          this.case$Mnsensitive$Qu = Scheme.isEqv.apply2(lists.car.apply1(localframe0.re$1), pregexp.Lit60);
          return lambda3sub(lists.cadr.apply1(localframe0.re$1), localframe0.i, localframe0.lambda$Fn11, localframe0.lambda$Fn12);
        }
      }
      if (Scheme.isEqv.apply2(localObject4, pregexp.Lit68) != Boolean.FALSE) {
        localObject6 = lists.cadr.apply1(localframe0.re$1);
      }
      for (;;)
      {
        Object localObject7;
        try
        {
          Boolean localBoolean1 = Boolean.FALSE;
          if (localObject6 != localBoolean1)
          {
            m = 1;
            localframe0.maximal$Qu = (0x1 & m + 1);
            localframe0.p = lists.caddr.apply1(localframe0.re$1);
            localframe0.q = lists.cadddr.apply1(localframe0.re$1);
            if (!localframe0.maximal$Qu) {
              continue;
            }
            localObject7 = localframe0.q;
          }
        }
        catch (ClassCastException localClassCastException3)
        {
          int m;
          Boolean localBoolean2;
          int i2;
          Object[] arrayOfObject1;
          throw new WrongType(localClassCastException3, "maximal?", -2, localObject6);
        }
        try
        {
          localBoolean2 = Boolean.FALSE;
          if (localObject7 != localBoolean2)
          {
            i2 = 1;
            int i1 = 0x1 & i2 + 1;
            localframe0.could$Mnloop$Mninfinitely$Qu = i1;
            localframe0.re = lists.car.apply1(lists.cddddr.apply1(localframe0.re$1));
            return localframe0.lambda8loupP(pregexp.Lit73, localframe0.i);
            m = 0;
          }
          else
          {
            i2 = 0;
            continue;
            boolean bool3 = localframe0.maximal$Qu;
            continue;
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = pregexp.Lit101;
            return pregexp.pregexpError$V(arrayOfObject2);
          }
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "could-loop-infinitely?", -2, localObject7);
        }
      }
      if (Scheme.numGEq.apply2(localframe0.i, this.n) != Boolean.FALSE) {
        return Scheme.applyToArgs.apply1(localframe0.fk);
      }
      arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = pregexp.Lit101;
      return pregexp.pregexpError$V(arrayOfObject1);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 15)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame0
    extends ModuleBody
  {
    boolean could$Mnloop$Mninfinitely$Qu;
    Object fk;
    Object i;
    final ModuleMethod lambda$Fn11;
    final ModuleMethod lambda$Fn12;
    final ModuleMethod lambda$Fn2;
    final ModuleMethod lambda$Fn3;
    final ModuleMethod lambda$Fn4;
    final ModuleMethod lambda$Fn5;
    boolean maximal$Qu;
    Object old;
    Object p;
    Object q;
    Object re;
    Object re$1;
    Object sk;
    pregexp.frame staticLink;
    
    public frame0()
    {
      this$1 = new ModuleMethod(this, 9, null, 4097);
      this$1.setProperty("source-location", "pregexp.scm:513");
      this.lambda$Fn2 = this$1;
      ModuleMethod localModuleMethod1 = new ModuleMethod(this, 10, null, 0);
      localModuleMethod1.setProperty("source-location", "pregexp.scm:514");
      this.lambda$Fn3 = localModuleMethod1;
      ModuleMethod localModuleMethod2 = new ModuleMethod(this, 11, null, 4097);
      localModuleMethod2.setProperty("source-location", "pregexp.scm:541");
      this.lambda$Fn4 = localModuleMethod2;
      ModuleMethod localModuleMethod3 = new ModuleMethod(this, 12, null, 4097);
      localModuleMethod3.setProperty("source-location", "pregexp.scm:545");
      this.lambda$Fn5 = localModuleMethod3;
      ModuleMethod localModuleMethod4 = new ModuleMethod(this, 13, null, 4097);
      localModuleMethod4.setProperty("source-location", "pregexp.scm:587");
      this.lambda$Fn11 = localModuleMethod4;
      ModuleMethod localModuleMethod5 = new ModuleMethod(this, 14, null, 0);
      localModuleMethod5.setProperty("source-location", "pregexp.scm:590");
      this.lambda$Fn12 = localModuleMethod5;
    }
    
    static Boolean lambda13()
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda14()
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda15()
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda16()
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda17()
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply0(paramModuleMethod);
      case 10: 
        return lambda10();
      }
      return lambda19();
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (paramModuleMethod.selector)
      {
      case 10: 
      default: 
        return super.apply1(paramModuleMethod, paramObject);
      case 9: 
        return lambda9(paramObject);
      case 11: 
        return lambda11(paramObject);
      case 12: 
        return lambda12(paramObject);
      }
      return lambda18(paramObject);
    }
    
    Object lambda10()
    {
      return Scheme.applyToArgs.apply2(this.sk, AddOp.$Pl.apply2(this.i, pregexp.Lit8));
    }
    
    Object lambda11(Object paramObject)
    {
      return Scheme.applyToArgs.apply2(this.sk, paramObject);
    }
    
    Object lambda12(Object paramObject)
    {
      Object localObject = lists.assv(this.re$1, this.staticLink.backrefs);
      try
      {
        Pair localPair = (Pair)localObject;
        lists.setCdr$Ex(localPair, lists.cons(this.i, paramObject));
        return Scheme.applyToArgs.apply2(this.sk, paramObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-cdr!", 1, localObject);
      }
    }
    
    Object lambda18(Object paramObject)
    {
      this.staticLink.case$Mnsensitive$Qu = this.old;
      return Scheme.applyToArgs.apply2(this.sk, paramObject);
    }
    
    Object lambda19()
    {
      this.staticLink.case$Mnsensitive$Qu = this.old;
      return Scheme.applyToArgs.apply1(this.fk);
    }
    
    public Object lambda5loupOneOfChars(Object paramObject)
    {
      pregexp.frame1 localframe1 = new pregexp.frame1();
      localframe1.staticLink = this;
      localframe1.chars = paramObject;
      if (lists.isNull(localframe1.chars)) {
        return Scheme.applyToArgs.apply1(this.fk);
      }
      return this.staticLink.lambda3sub(lists.car.apply1(localframe1.chars), this.i, this.sk, localframe1.lambda$Fn13);
    }
    
    public Object lambda6loupSeq(Object paramObject1, Object paramObject2)
    {
      pregexp.frame2 localframe2 = new pregexp.frame2();
      localframe2.staticLink = this;
      localframe2.res = paramObject1;
      if (lists.isNull(localframe2.res)) {
        return Scheme.applyToArgs.apply2(this.sk, paramObject2);
      }
      return this.staticLink.lambda3sub(lists.car.apply1(localframe2.res), paramObject2, localframe2.lambda$Fn14, this.fk);
    }
    
    public Object lambda7loupOr(Object paramObject)
    {
      pregexp.frame3 localframe3 = new pregexp.frame3();
      localframe3.staticLink = this;
      localframe3.res = paramObject;
      if (lists.isNull(localframe3.res)) {
        return Scheme.applyToArgs.apply1(this.fk);
      }
      return this.staticLink.lambda3sub(lists.car.apply1(localframe3.res), this.i, localframe3.lambda$Fn15, localframe3.lambda$Fn16);
    }
    
    public Object lambda8loupP(Object paramObject1, Object paramObject2)
    {
      pregexp.frame4 localframe4 = new pregexp.frame4();
      localframe4.staticLink = this;
      localframe4.k = paramObject1;
      localframe4.i = paramObject2;
      if (Scheme.numLss.apply2(localframe4.k, this.p) != Boolean.FALSE) {
        return this.staticLink.lambda3sub(this.re, localframe4.i, localframe4.lambda$Fn17, this.fk);
      }
      if (this.q != Boolean.FALSE) {}
      for (Object localObject = AddOp.$Mn.apply2(this.q, this.p);; localObject = this.q)
      {
        localframe4.q = localObject;
        return localframe4.lambda24loupQ(pregexp.Lit73, localframe4.i);
      }
    }
    
    Object lambda9(Object paramObject)
    {
      return Scheme.applyToArgs.apply1(this.fk);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match0(paramModuleMethod, paramCallContext);
      case 14: 
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
      case 10: 
      default: 
        return super.match1(paramModuleMethod, paramObject, paramCallContext);
      case 13: 
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      case 12: 
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      case 11: 
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
  }
  
  public class frame1
    extends ModuleBody
  {
    Object chars;
    final ModuleMethod lambda$Fn13;
    pregexp.frame0 staticLink;
    
    public frame1()
    {
      this$1 = new ModuleMethod(this, 1, null, 0);
      this$1.setProperty("source-location", "pregexp.scm:508");
      this.lambda$Fn13 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 1) {
        return lambda20();
      }
      return super.apply0(paramModuleMethod);
    }
    
    Object lambda20()
    {
      return this.staticLink.lambda5loupOneOfChars(lists.cdr.apply1(this.chars));
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 1)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
  }
  
  public class frame2
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn14;
    Object res;
    pregexp.frame0 staticLink;
    
    public frame2()
    {
      this$1 = new ModuleMethod(this, 2, null, 4097);
      this$1.setProperty("source-location", "pregexp.scm:519");
      this.lambda$Fn14 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 2) {
        return lambda21(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda21(Object paramObject)
    {
      return this.staticLink.lambda6loupSeq(lists.cdr.apply1(this.res), paramObject);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 2)
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
    final ModuleMethod lambda$Fn15;
    final ModuleMethod lambda$Fn16;
    Object res;
    pregexp.frame0 staticLink;
    
    public frame3()
    {
      this$1 = new ModuleMethod(this, 3, null, 4097);
      this$1.setProperty("source-location", "pregexp.scm:526");
      this.lambda$Fn15 = this$1;
      ModuleMethod localModuleMethod = new ModuleMethod(this, 4, null, 0);
      localModuleMethod.setProperty("source-location", "pregexp.scm:529");
      this.lambda$Fn16 = localModuleMethod;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 4) {
        return lambda23();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 3) {
        return lambda22(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda22(Object paramObject)
    {
      Object localObject = Scheme.applyToArgs.apply2(this.staticLink.sk, paramObject);
      if (localObject != Boolean.FALSE) {
        return localObject;
      }
      return this.staticLink.lambda7loupOr(lists.cdr.apply1(this.res));
    }
    
    Object lambda23()
    {
      return this.staticLink.lambda7loupOr(lists.cdr.apply1(this.res));
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 4)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 3)
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
    Object i;
    Object k;
    final ModuleMethod lambda$Fn17;
    Object q;
    pregexp.frame0 staticLink;
    
    public frame4()
    {
      this$1 = new ModuleMethod(this, 8, null, 4097);
      this$1.setProperty("source-location", "pregexp.scm:602");
      this.lambda$Fn17 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 8) {
        return lambda25(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    public Object lambda24loupQ(Object paramObject1, Object paramObject2)
    {
      pregexp.frame5 localframe5 = new pregexp.frame5();
      localframe5.staticLink = this;
      localframe5.k = paramObject1;
      localframe5.i = paramObject2;
      localframe5.fk = localframe5.fk;
      Object localObject;
      if (this.q != Boolean.FALSE)
      {
        if (Scheme.numGEq.apply2(localframe5.k, this.q) == Boolean.FALSE) {
          break label80;
        }
        localObject = localframe5.lambda26fk();
      }
      label80:
      do
      {
        return localObject;
        if (this.q != Boolean.FALSE) {
          break;
        }
        if (this.staticLink.maximal$Qu) {
          return this.staticLink.staticLink.lambda3sub(this.staticLink.re, localframe5.i, localframe5.lambda$Fn18, localframe5.fk);
        }
        localObject = localframe5.lambda26fk();
      } while (localObject != Boolean.FALSE);
      return this.staticLink.staticLink.lambda3sub(this.staticLink.re, localframe5.i, localframe5.lambda$Fn19, localframe5.fk);
    }
    
    Object lambda25(Object paramObject)
    {
      if (this.staticLink.could$Mnloop$Mninfinitely$Qu) {
        if (Scheme.numEqu.apply2(paramObject, this.i) == Boolean.FALSE) {}
      }
      for (;;)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = pregexp.Lit101;
        arrayOfObject[1] = pregexp.Lit110;
        pregexp.pregexpError$V(arrayOfObject);
        do
        {
          return this.staticLink.lambda8loupP(AddOp.$Pl.apply2(this.k, pregexp.Lit8), paramObject);
        } while (!this.staticLink.could$Mnloop$Mninfinitely$Qu);
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
  
  public class frame5
    extends ModuleBody
  {
    Procedure fk;
    Object i;
    Object k;
    final ModuleMethod lambda$Fn18;
    final ModuleMethod lambda$Fn19;
    pregexp.frame4 staticLink;
    
    public frame5()
    {
      this$1 = new ModuleMethod(this, 5, pregexp.Lit111, 0);
      this$1.setProperty("source-location", "pregexp.scm:612");
      this.fk = this$1;
      ModuleMethod localModuleMethod1 = new ModuleMethod(this, 6, null, 4097);
      localModuleMethod1.setProperty("source-location", "pregexp.scm:617");
      this.lambda$Fn18 = localModuleMethod1;
      ModuleMethod localModuleMethod2 = new ModuleMethod(this, 7, null, 4097);
      localModuleMethod2.setProperty("source-location", "pregexp.scm:628");
      this.lambda$Fn19 = localModuleMethod2;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 5) {
        return lambda26fk();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply1(paramModuleMethod, paramObject);
      case 6: 
        return lambda27(paramObject);
      }
      return lambda28(paramObject);
    }
    
    public Object lambda26fk()
    {
      return Scheme.applyToArgs.apply2(this.staticLink.staticLink.sk, this.i);
    }
    
    Object lambda27(Object paramObject)
    {
      if (this.staticLink.staticLink.could$Mnloop$Mninfinitely$Qu) {
        if (Scheme.numEqu.apply2(paramObject, this.i) == Boolean.FALSE) {}
      }
      for (;;)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = pregexp.Lit101;
        arrayOfObject[1] = pregexp.Lit110;
        pregexp.pregexpError$V(arrayOfObject);
        do
        {
          Object localObject = this.staticLink.lambda24loupQ(AddOp.$Pl.apply2(this.k, pregexp.Lit8), paramObject);
          if (localObject == Boolean.FALSE) {
            break;
          }
          return localObject;
        } while (!this.staticLink.staticLink.could$Mnloop$Mninfinitely$Qu);
      }
      return lambda26fk();
    }
    
    Object lambda28(Object paramObject)
    {
      return this.staticLink.lambda24loupQ(AddOp.$Pl.apply2(this.k, pregexp.Lit8), paramObject);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 5)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match1(paramModuleMethod, paramObject, paramCallContext);
      case 7: 
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
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.pregexp
 * JD-Core Version:    0.7.0.1
 */