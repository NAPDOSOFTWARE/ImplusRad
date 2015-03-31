package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.BitwiseOp;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.Invoke;
import gnu.lists.CharSeq;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.math.RealNum;
import gnu.text.Char;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.characters;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.lib.vectors;
import kawa.standard.Scheme;
import kawa.standard.call_with_values;

public class srfi13
  extends ModuleBody
{
  public static final ModuleMethod $Pccheck$Mnbounds;
  public static final ModuleMethod $Pcfinish$Mnstring$Mnconcatenate$Mnreverse;
  public static final ModuleMethod $Pckmp$Mnsearch;
  public static final ModuleMethod $Pcmultispan$Mnrepcopy$Ex;
  public static final ModuleMethod $Pcstring$Mncompare;
  public static final ModuleMethod $Pcstring$Mncompare$Mnci;
  public static final ModuleMethod $Pcstring$Mncopy$Ex;
  public static final ModuleMethod $Pcstring$Mnhash;
  public static final ModuleMethod $Pcstring$Mnmap;
  public static final ModuleMethod $Pcstring$Mnmap$Ex;
  public static final ModuleMethod $Pcstring$Mnprefix$Mnci$Qu;
  public static final ModuleMethod $Pcstring$Mnprefix$Mnlength;
  public static final ModuleMethod $Pcstring$Mnprefix$Mnlength$Mnci;
  public static final ModuleMethod $Pcstring$Mnprefix$Qu;
  public static final ModuleMethod $Pcstring$Mnsuffix$Mnci$Qu;
  public static final ModuleMethod $Pcstring$Mnsuffix$Mnlength;
  public static final ModuleMethod $Pcstring$Mnsuffix$Mnlength$Mnci;
  public static final ModuleMethod $Pcstring$Mnsuffix$Qu;
  public static final ModuleMethod $Pcstring$Mntitlecase$Ex;
  public static final ModuleMethod $Pcsubstring$Slshared;
  public static final srfi13 $instance;
  static final IntNum Lit0;
  static final IntNum Lit1;
  static final IntNum Lit10;
  static final SimpleSymbol Lit100;
  static final SimpleSymbol Lit101;
  static final SimpleSymbol Lit102;
  static final SimpleSymbol Lit103;
  static final SimpleSymbol Lit104;
  static final SimpleSymbol Lit105;
  static final SimpleSymbol Lit106;
  static final SimpleSymbol Lit107;
  static final SimpleSymbol Lit108;
  static final SimpleSymbol Lit109;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit110;
  static final SimpleSymbol Lit111;
  static final SimpleSymbol Lit112;
  static final SimpleSymbol Lit113;
  static final SimpleSymbol Lit114;
  static final SimpleSymbol Lit115;
  static final SimpleSymbol Lit116;
  static final SimpleSymbol Lit117;
  static final SimpleSymbol Lit118;
  static final SimpleSymbol Lit119;
  static final Char Lit12;
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
  static final IntNum Lit13;
  static final SimpleSymbol Lit130;
  static final SimpleSymbol Lit131;
  static final SimpleSymbol Lit132;
  static final SimpleSymbol Lit133;
  static final SimpleSymbol Lit134;
  static final SimpleSymbol Lit135;
  static final SimpleSymbol Lit136;
  static final SimpleSymbol Lit137;
  static final SimpleSymbol Lit138;
  static final SimpleSymbol Lit139;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit140;
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
  static final SimpleSymbol Lit150 = (SimpleSymbol)new SimpleSymbol("receive").readResolve();
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final IntNum Lit2;
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
  static final IntNum Lit3;
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
  static final IntNum Lit4;
  static final SimpleSymbol Lit40;
  static final SimpleSymbol Lit41;
  static final SyntaxRules Lit42;
  static final SimpleSymbol Lit43;
  static final SyntaxRules Lit44;
  static final SimpleSymbol Lit45;
  static final SimpleSymbol Lit46;
  static final SimpleSymbol Lit47;
  static final SimpleSymbol Lit48;
  static final SimpleSymbol Lit49;
  static final IntNum Lit5;
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
  static final IntNum Lit6;
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
  static final IntNum Lit7;
  static final SimpleSymbol Lit70;
  static final SimpleSymbol Lit71;
  static final SimpleSymbol Lit72;
  static final SimpleSymbol Lit73;
  static final SimpleSymbol Lit74;
  static final SimpleSymbol Lit75;
  static final SimpleSymbol Lit76;
  static final SimpleSymbol Lit77;
  static final SimpleSymbol Lit78;
  static final SimpleSymbol Lit79;
  static final IntNum Lit8;
  static final SimpleSymbol Lit80;
  static final SimpleSymbol Lit81;
  static final SimpleSymbol Lit82;
  static final SimpleSymbol Lit83;
  static final SimpleSymbol Lit84;
  static final SimpleSymbol Lit85;
  static final SimpleSymbol Lit86;
  static final SimpleSymbol Lit87;
  static final SimpleSymbol Lit88;
  static final SimpleSymbol Lit89;
  static final IntNum Lit9;
  static final SimpleSymbol Lit90;
  static final SimpleSymbol Lit91;
  static final SimpleSymbol Lit92;
  static final SimpleSymbol Lit93;
  static final SimpleSymbol Lit94;
  static final SimpleSymbol Lit95;
  static final SimpleSymbol Lit96;
  static final SimpleSymbol Lit97;
  static final SimpleSymbol Lit98;
  static final SimpleSymbol Lit99;
  public static final ModuleMethod check$Mnsubstring$Mnspec;
  public static final ModuleMethod kmp$Mnstep;
  static final ModuleMethod lambda$Fn100;
  static final ModuleMethod lambda$Fn105;
  static final ModuleMethod lambda$Fn106;
  static final ModuleMethod lambda$Fn111;
  static final ModuleMethod lambda$Fn116;
  static final ModuleMethod lambda$Fn117;
  static final ModuleMethod lambda$Fn122;
  static final ModuleMethod lambda$Fn123;
  static final ModuleMethod lambda$Fn128;
  static final ModuleMethod lambda$Fn133;
  static final ModuleMethod lambda$Fn138;
  static final ModuleMethod lambda$Fn163;
  static final ModuleMethod lambda$Fn166;
  static final ModuleMethod lambda$Fn17;
  static final ModuleMethod lambda$Fn18;
  static final ModuleMethod lambda$Fn210;
  static final ModuleMethod lambda$Fn216;
  static final ModuleMethod lambda$Fn220;
  static final ModuleMethod lambda$Fn27;
  static final ModuleMethod lambda$Fn5;
  static final ModuleMethod lambda$Fn72;
  static final ModuleMethod lambda$Fn73;
  static final ModuleMethod lambda$Fn78;
  static final ModuleMethod lambda$Fn83;
  static final ModuleMethod lambda$Fn84;
  static final ModuleMethod lambda$Fn89;
  static final ModuleMethod lambda$Fn90;
  static final ModuleMethod lambda$Fn95;
  public static final Macro let$Mnstring$Mnstart$Plend;
  public static final Macro let$Mnstring$Mnstart$Plend2;
  static final Location loc$$Cloptional;
  static final Location loc$base;
  static final Location loc$bound;
  static final Location loc$c$Eq;
  static final Location loc$char$Mncased$Qu;
  static final Location loc$char$Mnset;
  static final Location loc$char$Mnset$Mncontains$Qu;
  static final Location loc$char$Mnset$Qu;
  static final Location loc$check$Mnarg;
  static final Location loc$criterion;
  static final Location loc$delim;
  static final Location loc$end;
  static final Location loc$final;
  static final Location loc$grammar;
  static final Location loc$let$Mnoptionals$St;
  static final Location loc$make$Mnfinal;
  static final Location loc$p$Mnstart;
  static final Location loc$rest;
  static final Location loc$s$Mnend;
  static final Location loc$s$Mnstart;
  static final Location loc$start;
  static final Location loc$token$Mnchars;
  public static final ModuleMethod make$Mnkmp$Mnrestart$Mnvector;
  public static final ModuleMethod reverse$Mnlist$Mn$Grstring;
  public static final ModuleMethod string$Eq;
  public static final ModuleMethod string$Gr;
  public static final ModuleMethod string$Gr$Eq;
  public static final ModuleMethod string$Ls;
  public static final ModuleMethod string$Ls$Eq;
  public static final ModuleMethod string$Ls$Gr;
  public static final ModuleMethod string$Mn$Grlist;
  public static final ModuleMethod string$Mnany;
  public static final ModuleMethod string$Mnappend$Slshared;
  public static final ModuleMethod string$Mnci$Eq;
  public static final ModuleMethod string$Mnci$Gr;
  public static final ModuleMethod string$Mnci$Gr$Eq;
  public static final ModuleMethod string$Mnci$Ls;
  public static final ModuleMethod string$Mnci$Ls$Eq;
  public static final ModuleMethod string$Mnci$Ls$Gr;
  public static final ModuleMethod string$Mncompare;
  public static final ModuleMethod string$Mncompare$Mnci;
  public static final ModuleMethod string$Mnconcatenate;
  public static final ModuleMethod string$Mnconcatenate$Mnreverse;
  public static final ModuleMethod string$Mnconcatenate$Mnreverse$Slshared;
  public static final ModuleMethod string$Mnconcatenate$Slshared;
  public static final ModuleMethod string$Mncontains;
  public static final ModuleMethod string$Mncontains$Mnci;
  public static final ModuleMethod string$Mncopy;
  public static final ModuleMethod string$Mncopy$Ex;
  public static final ModuleMethod string$Mncount;
  public static final ModuleMethod string$Mndelete;
  public static final ModuleMethod string$Mndowncase;
  public static final ModuleMethod string$Mndowncase$Ex;
  public static final ModuleMethod string$Mndrop;
  public static final ModuleMethod string$Mndrop$Mnright;
  public static final ModuleMethod string$Mnevery;
  public static final ModuleMethod string$Mnfill$Ex;
  public static final ModuleMethod string$Mnfilter;
  public static final ModuleMethod string$Mnfold;
  public static final ModuleMethod string$Mnfold$Mnright;
  public static final ModuleMethod string$Mnfor$Mneach;
  public static final ModuleMethod string$Mnfor$Mneach$Mnindex;
  public static final ModuleMethod string$Mnhash;
  public static final ModuleMethod string$Mnhash$Mnci;
  public static final ModuleMethod string$Mnindex;
  public static final ModuleMethod string$Mnindex$Mnright;
  public static final ModuleMethod string$Mnjoin;
  public static final ModuleMethod string$Mnkmp$Mnpartial$Mnsearch;
  public static final ModuleMethod string$Mnmap;
  public static final ModuleMethod string$Mnmap$Ex;
  public static final ModuleMethod string$Mnnull$Qu;
  public static final ModuleMethod string$Mnpad;
  public static final ModuleMethod string$Mnpad$Mnright;
  public static final ModuleMethod string$Mnparse$Mnfinal$Mnstart$Plend;
  public static final ModuleMethod string$Mnparse$Mnstart$Plend;
  public static final ModuleMethod string$Mnprefix$Mnci$Qu;
  public static final ModuleMethod string$Mnprefix$Mnlength;
  public static final ModuleMethod string$Mnprefix$Mnlength$Mnci;
  public static final ModuleMethod string$Mnprefix$Qu;
  public static final ModuleMethod string$Mnreplace;
  public static final ModuleMethod string$Mnreverse;
  public static final ModuleMethod string$Mnreverse$Ex;
  public static final ModuleMethod string$Mnskip;
  public static final ModuleMethod string$Mnskip$Mnright;
  public static final ModuleMethod string$Mnsuffix$Mnci$Qu;
  public static final ModuleMethod string$Mnsuffix$Mnlength;
  public static final ModuleMethod string$Mnsuffix$Mnlength$Mnci;
  public static final ModuleMethod string$Mnsuffix$Qu;
  public static final ModuleMethod string$Mntabulate;
  public static final ModuleMethod string$Mntake;
  public static final ModuleMethod string$Mntake$Mnright;
  public static final ModuleMethod string$Mntitlecase;
  public static final ModuleMethod string$Mntitlecase$Ex;
  public static final ModuleMethod string$Mntokenize;
  public static final ModuleMethod string$Mntrim;
  public static final ModuleMethod string$Mntrim$Mnboth;
  public static final ModuleMethod string$Mntrim$Mnright;
  public static final ModuleMethod string$Mnunfold;
  public static final ModuleMethod string$Mnunfold$Mnright;
  public static final ModuleMethod string$Mnupcase;
  public static final ModuleMethod string$Mnupcase$Ex;
  public static final ModuleMethod string$Mnxcopy$Ex;
  public static final ModuleMethod substring$Mnspec$Mnok$Qu;
  public static final ModuleMethod substring$Slshared;
  public static final ModuleMethod xsubstring;
  
  public static Object $PcCheckBounds(Object paramObject, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = paramObject;
      arrayOfObject2[1] = Integer.valueOf(paramInt1);
      arrayOfObject2[2] = paramCharSequence;
      return misc.error$V("Illegal substring START spec", arrayOfObject2);
    }
    if (paramInt1 > paramInt2) {
      return misc.error$V("Illegal substring START/END spec", new Object[0]);
    }
    if (paramInt2 > strings.stringLength(paramCharSequence))
    {
      Object[] arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = paramObject;
      arrayOfObject1[1] = Integer.valueOf(paramInt2);
      arrayOfObject1[2] = paramCharSequence;
      return misc.error$V("Illegal substring END spec", arrayOfObject1);
    }
    return Values.empty;
  }
  
  static Object $PcCheckSubstringSpec(Object paramObject, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < 0)
    {
      i = 1;
      if (i == 0) {
        break label64;
      }
      if (i == 0) {
        break label82;
      }
    }
    for (;;)
    {
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = paramObject;
      arrayOfObject[1] = paramCharSequence;
      arrayOfObject[2] = Integer.valueOf(paramInt1);
      arrayOfObject[3] = Integer.valueOf(paramInt2);
      return misc.error$V("Illegal substring spec.", arrayOfObject);
      i = 0;
      break;
      label64:
      int j;
      if (paramInt1 > paramInt2)
      {
        j = 1;
        if (j == 0) {
          break label92;
        }
        if (j != 0) {
          continue;
        }
      }
      label82:
      label92:
      while (paramInt2 <= strings.stringLength(paramCharSequence))
      {
        return Values.empty;
        j = 0;
        break;
      }
    }
  }
  
  /* Error */
  public static Object $PcFinishStringConcatenateReverse(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: getstatic 368	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   3: aload_3
    //   4: aload_0
    //   5: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: astore 4
    //   10: aload 4
    //   12: checkcast 376	java/lang/Number
    //   15: invokevirtual 380	java/lang/Number:intValue	()I
    //   18: istore 6
    //   20: iload 6
    //   22: invokestatic 384	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   25: astore 7
    //   27: aload_0
    //   28: checkcast 376	java/lang/Number
    //   31: invokevirtual 380	java/lang/Number:intValue	()I
    //   34: istore 9
    //   36: aload_2
    //   37: checkcast 386	java/lang/CharSequence
    //   40: astore 11
    //   42: aload_3
    //   43: checkcast 376	java/lang/Number
    //   46: invokevirtual 380	java/lang/Number:intValue	()I
    //   49: istore 13
    //   51: aload 7
    //   53: iload 9
    //   55: aload 11
    //   57: iconst_0
    //   58: iload 13
    //   60: invokestatic 390	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   63: pop
    //   64: aload_0
    //   65: astore 15
    //   67: aload_1
    //   68: invokestatic 396	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   71: ifeq +209 -> 280
    //   74: getstatic 400	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   77: aload_1
    //   78: invokevirtual 404	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: astore 16
    //   83: getstatic 407	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   86: aload_1
    //   87: invokevirtual 404	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: astore 17
    //   92: aload 16
    //   94: checkcast 386	java/lang/CharSequence
    //   97: astore 19
    //   99: aload 19
    //   101: invokestatic 347	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   104: istore 20
    //   106: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   109: aload 15
    //   111: iload 20
    //   113: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   116: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: astore 15
    //   121: aload 15
    //   123: checkcast 376	java/lang/Number
    //   126: invokevirtual 380	java/lang/Number:intValue	()I
    //   129: istore 22
    //   131: aload 16
    //   133: checkcast 386	java/lang/CharSequence
    //   136: astore 24
    //   138: aload 7
    //   140: iload 22
    //   142: aload 24
    //   144: iconst_0
    //   145: iload 20
    //   147: invokestatic 390	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   150: pop
    //   151: aload 17
    //   153: astore_1
    //   154: goto -87 -> 67
    //   157: astore 5
    //   159: new 412	gnu/mapping/WrongType
    //   162: dup
    //   163: aload 5
    //   165: ldc_w 414
    //   168: iconst_1
    //   169: aload 4
    //   171: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   174: athrow
    //   175: astore 8
    //   177: new 412	gnu/mapping/WrongType
    //   180: dup
    //   181: aload 8
    //   183: ldc_w 420
    //   186: iconst_1
    //   187: aload_0
    //   188: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   191: athrow
    //   192: astore 10
    //   194: new 412	gnu/mapping/WrongType
    //   197: dup
    //   198: aload 10
    //   200: ldc_w 420
    //   203: iconst_2
    //   204: aload_2
    //   205: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   208: athrow
    //   209: astore 12
    //   211: new 412	gnu/mapping/WrongType
    //   214: dup
    //   215: aload 12
    //   217: ldc_w 420
    //   220: iconst_4
    //   221: aload_3
    //   222: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   225: athrow
    //   226: astore 18
    //   228: new 412	gnu/mapping/WrongType
    //   231: dup
    //   232: aload 18
    //   234: ldc_w 422
    //   237: iconst_1
    //   238: aload 16
    //   240: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   243: athrow
    //   244: astore 21
    //   246: new 412	gnu/mapping/WrongType
    //   249: dup
    //   250: aload 21
    //   252: ldc_w 420
    //   255: iconst_1
    //   256: aload 15
    //   258: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   261: athrow
    //   262: astore 23
    //   264: new 412	gnu/mapping/WrongType
    //   267: dup
    //   268: aload 23
    //   270: ldc_w 420
    //   273: iconst_2
    //   274: aload 16
    //   276: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   279: athrow
    //   280: aload 7
    //   282: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramObject1	Object
    //   0	283	1	paramObject2	Object
    //   0	283	2	paramObject3	Object
    //   0	283	3	paramObject4	Object
    //   8	162	4	localObject1	Object
    //   157	7	5	localClassCastException1	ClassCastException
    //   18	3	6	i	int
    //   25	256	7	localCharSequence1	CharSequence
    //   175	7	8	localClassCastException2	ClassCastException
    //   34	20	9	j	int
    //   192	7	10	localClassCastException3	ClassCastException
    //   40	16	11	localCharSequence2	CharSequence
    //   209	7	12	localClassCastException4	ClassCastException
    //   49	10	13	k	int
    //   65	192	15	localObject2	Object
    //   81	194	16	localObject3	Object
    //   90	62	17	localObject4	Object
    //   226	7	18	localClassCastException5	ClassCastException
    //   97	3	19	localCharSequence3	CharSequence
    //   104	42	20	m	int
    //   244	7	21	localClassCastException6	ClassCastException
    //   129	12	22	n	int
    //   262	7	23	localClassCastException7	ClassCastException
    //   136	7	24	localCharSequence4	CharSequence
    // Exception table:
    //   from	to	target	type
    //   10	20	157	java/lang/ClassCastException
    //   27	36	175	java/lang/ClassCastException
    //   36	42	192	java/lang/ClassCastException
    //   42	51	209	java/lang/ClassCastException
    //   92	99	226	java/lang/ClassCastException
    //   121	131	244	java/lang/ClassCastException
    //   131	138	262	java/lang/ClassCastException
  }
  
  public static Object $PcKmpSearch(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7)
  {
    Object localObject1 = AddOp.$Mn.apply2(paramObject5, paramObject4);
    localObject2 = makeKmpRestartVector$V(paramObject1, new Object[] { paramObject3, paramObject4, paramObject5 });
    IntNum localIntNum1 = Lit0;
    Object localObject3 = AddOp.$Mn.apply2(paramObject7, paramObject6);
    localObject4 = paramObject6;
    Object localObject5 = localObject1;
    localObject6 = localIntNum1;
    for (;;)
    {
      if (Scheme.numEqu.apply2(localObject6, localObject1) != Boolean.FALSE) {
        return AddOp.$Mn.apply2(localObject4, localObject1);
      }
      Object localObject7 = Scheme.numLEq.apply2(localObject5, localObject3);
      Object localObject8;
      try
      {
        bool = ((Boolean)localObject7).booleanValue();
        if (bool) {
          localApplyToArgs = Scheme.applyToArgs;
        }
      }
      catch (ClassCastException localClassCastException1)
      {
        boolean bool;
        ApplyToArgs localApplyToArgs;
        CharSequence localCharSequence1;
        int i;
        Char localChar;
        CharSequence localCharSequence2;
        int j;
        FVector localFVector;
        int k;
        Object localObject9;
        throw new WrongType(localClassCastException1, "x", -2, localObject7);
      }
      try
      {
        localCharSequence1 = (CharSequence)paramObject2;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-ref", 1, paramObject2);
      }
      try
      {
        i = ((Number)localObject4).intValue();
        localChar = Char.make(strings.stringRef(localCharSequence1, i));
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "string-ref", 2, localObject4);
      }
      try
      {
        localCharSequence2 = (CharSequence)paramObject1;
        localObject8 = AddOp.$Pl.apply2(paramObject4, localObject6);
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "string-ref", 1, paramObject1);
      }
      try
      {
        j = ((Number)localObject8).intValue();
        if (localApplyToArgs.apply3(paramObject3, localChar, Char.make(strings.stringRef(localCharSequence2, j))) != Boolean.FALSE)
        {
          localObject4 = AddOp.$Pl.apply2(Lit1, localObject4);
          Object localObject10 = AddOp.$Pl.apply2(Lit1, localObject6);
          localObject3 = AddOp.$Mn.apply2(localObject3, Lit1);
          localObject5 = AddOp.$Mn.apply2(localObject5, Lit1);
          localObject6 = localObject10;
        }
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "string-ref", 2, localObject8);
      }
      try
      {
        localFVector = (FVector)localObject2;
      }
      catch (ClassCastException localClassCastException6)
      {
        throw new WrongType(localClassCastException6, "vector-ref", 1, localObject2);
      }
      try
      {
        k = ((Number)localObject6).intValue();
        localObject9 = vectors.vectorRef(localFVector, k);
        if (Scheme.numEqu.apply2(localObject9, Lit13) != Boolean.FALSE)
        {
          localObject4 = AddOp.$Pl.apply2(localObject4, Lit1);
          IntNum localIntNum2 = Lit0;
          localObject3 = AddOp.$Mn.apply2(localObject3, Lit1);
          localObject5 = localObject1;
          localObject6 = localIntNum2;
        }
        else
        {
          localObject5 = AddOp.$Mn.apply2(localObject1, localObject9);
          localObject6 = localObject9;
        }
      }
      catch (ClassCastException localClassCastException7)
      {
        throw new WrongType(localClassCastException7, "vector-ref", 2, localObject6);
      }
    }
    if (bool) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  /* Error */
  public static Object $PcMultispanRepcopy$Ex(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7)
  {
    // Byte code:
    //   0: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   3: aload 6
    //   5: aload 5
    //   7: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   10: astore 7
    //   12: getstatic 368	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   15: aload 5
    //   17: getstatic 494	gnu/kawa/functions/DivideOp:modulo	Lgnu/kawa/functions/DivideOp;
    //   20: aload_3
    //   21: aload 7
    //   23: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   26: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: astore 8
    //   31: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   34: aload 4
    //   36: aload_3
    //   37: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: astore 9
    //   42: aload_0
    //   43: checkcast 386	java/lang/CharSequence
    //   46: astore 11
    //   48: aload_1
    //   49: checkcast 376	java/lang/Number
    //   52: invokevirtual 380	java/lang/Number:intValue	()I
    //   55: istore 13
    //   57: aload_2
    //   58: checkcast 386	java/lang/CharSequence
    //   61: astore 15
    //   63: aload 8
    //   65: checkcast 376	java/lang/Number
    //   68: invokevirtual 380	java/lang/Number:intValue	()I
    //   71: istore 17
    //   73: aload 6
    //   75: checkcast 376	java/lang/Number
    //   78: invokevirtual 380	java/lang/Number:intValue	()I
    //   81: istore 19
    //   83: aload 11
    //   85: iload 13
    //   87: aload 15
    //   89: iload 17
    //   91: iload 19
    //   93: invokestatic 390	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   96: pop
    //   97: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   100: aload 6
    //   102: aload 8
    //   104: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: astore 21
    //   109: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   112: aload 9
    //   114: aload 21
    //   116: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: astore 22
    //   121: getstatic 497	gnu/kawa/functions/DivideOp:quotient	Lgnu/kawa/functions/DivideOp;
    //   124: aload 22
    //   126: aload 7
    //   128: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   131: astore 23
    //   133: getstatic 368	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   136: aload_1
    //   137: aload 21
    //   139: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: astore 24
    //   144: aload 23
    //   146: checkcast 376	java/lang/Number
    //   149: astore 26
    //   151: aload 26
    //   153: invokestatic 503	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   156: ifne +87 -> 243
    //   159: aload_0
    //   160: checkcast 386	java/lang/CharSequence
    //   163: astore 39
    //   165: aload 24
    //   167: checkcast 376	java/lang/Number
    //   170: invokevirtual 380	java/lang/Number:intValue	()I
    //   173: istore 41
    //   175: aload_2
    //   176: checkcast 386	java/lang/CharSequence
    //   179: astore 43
    //   181: aload 5
    //   183: checkcast 376	java/lang/Number
    //   186: invokevirtual 380	java/lang/Number:intValue	()I
    //   189: istore 45
    //   191: aload 6
    //   193: checkcast 376	java/lang/Number
    //   196: invokevirtual 380	java/lang/Number:intValue	()I
    //   199: istore 47
    //   201: aload 39
    //   203: iload 41
    //   205: aload 43
    //   207: iload 45
    //   209: iload 47
    //   211: invokestatic 390	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   214: pop
    //   215: getstatic 368	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   218: aload 24
    //   220: aload 7
    //   222: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   225: astore 24
    //   227: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   230: aload 23
    //   232: getstatic 468	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   235: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   238: astore 23
    //   240: goto -96 -> 144
    //   243: aload_0
    //   244: checkcast 386	java/lang/CharSequence
    //   247: astore 28
    //   249: aload 24
    //   251: checkcast 376	java/lang/Number
    //   254: invokevirtual 380	java/lang/Number:intValue	()I
    //   257: istore 30
    //   259: aload_2
    //   260: checkcast 386	java/lang/CharSequence
    //   263: astore 32
    //   265: aload 5
    //   267: checkcast 376	java/lang/Number
    //   270: invokevirtual 380	java/lang/Number:intValue	()I
    //   273: istore 34
    //   275: getstatic 368	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   278: aload 5
    //   280: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   283: aload 9
    //   285: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   288: aload 24
    //   290: aload_1
    //   291: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   294: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   297: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   300: astore 35
    //   302: aload 35
    //   304: checkcast 376	java/lang/Number
    //   307: invokevirtual 380	java/lang/Number:intValue	()I
    //   310: istore 37
    //   312: aload 28
    //   314: iload 30
    //   316: aload 32
    //   318: iload 34
    //   320: iload 37
    //   322: invokestatic 390	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   325: areturn
    //   326: astore 10
    //   328: new 412	gnu/mapping/WrongType
    //   331: dup
    //   332: aload 10
    //   334: ldc_w 420
    //   337: iconst_0
    //   338: aload_0
    //   339: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   342: athrow
    //   343: astore 12
    //   345: new 412	gnu/mapping/WrongType
    //   348: dup
    //   349: aload 12
    //   351: ldc_w 420
    //   354: iconst_1
    //   355: aload_1
    //   356: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   359: athrow
    //   360: astore 14
    //   362: new 412	gnu/mapping/WrongType
    //   365: dup
    //   366: aload 14
    //   368: ldc_w 420
    //   371: iconst_2
    //   372: aload_2
    //   373: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   376: athrow
    //   377: astore 16
    //   379: new 412	gnu/mapping/WrongType
    //   382: dup
    //   383: aload 16
    //   385: ldc_w 420
    //   388: iconst_3
    //   389: aload 8
    //   391: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   394: athrow
    //   395: astore 18
    //   397: new 412	gnu/mapping/WrongType
    //   400: dup
    //   401: aload 18
    //   403: ldc_w 420
    //   406: iconst_4
    //   407: aload 6
    //   409: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   412: athrow
    //   413: astore 25
    //   415: new 412	gnu/mapping/WrongType
    //   418: dup
    //   419: aload 25
    //   421: ldc_w 505
    //   424: iconst_1
    //   425: aload 23
    //   427: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   430: athrow
    //   431: astore 38
    //   433: new 412	gnu/mapping/WrongType
    //   436: dup
    //   437: aload 38
    //   439: ldc_w 420
    //   442: iconst_0
    //   443: aload_0
    //   444: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   447: athrow
    //   448: astore 40
    //   450: new 412	gnu/mapping/WrongType
    //   453: dup
    //   454: aload 40
    //   456: ldc_w 420
    //   459: iconst_1
    //   460: aload 24
    //   462: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   465: athrow
    //   466: astore 42
    //   468: new 412	gnu/mapping/WrongType
    //   471: dup
    //   472: aload 42
    //   474: ldc_w 420
    //   477: iconst_2
    //   478: aload_2
    //   479: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   482: athrow
    //   483: astore 44
    //   485: new 412	gnu/mapping/WrongType
    //   488: dup
    //   489: aload 44
    //   491: ldc_w 420
    //   494: iconst_3
    //   495: aload 5
    //   497: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   500: athrow
    //   501: astore 46
    //   503: new 412	gnu/mapping/WrongType
    //   506: dup
    //   507: aload 46
    //   509: ldc_w 420
    //   512: iconst_4
    //   513: aload 6
    //   515: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   518: athrow
    //   519: astore 27
    //   521: new 412	gnu/mapping/WrongType
    //   524: dup
    //   525: aload 27
    //   527: ldc_w 420
    //   530: iconst_0
    //   531: aload_0
    //   532: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   535: athrow
    //   536: astore 29
    //   538: new 412	gnu/mapping/WrongType
    //   541: dup
    //   542: aload 29
    //   544: ldc_w 420
    //   547: iconst_1
    //   548: aload 24
    //   550: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   553: athrow
    //   554: astore 31
    //   556: new 412	gnu/mapping/WrongType
    //   559: dup
    //   560: aload 31
    //   562: ldc_w 420
    //   565: iconst_2
    //   566: aload_2
    //   567: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   570: athrow
    //   571: astore 33
    //   573: new 412	gnu/mapping/WrongType
    //   576: dup
    //   577: aload 33
    //   579: ldc_w 420
    //   582: iconst_3
    //   583: aload 5
    //   585: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   588: athrow
    //   589: astore 36
    //   591: new 412	gnu/mapping/WrongType
    //   594: dup
    //   595: aload 36
    //   597: ldc_w 420
    //   600: iconst_4
    //   601: aload 35
    //   603: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   606: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	607	0	paramObject1	Object
    //   0	607	1	paramObject2	Object
    //   0	607	2	paramObject3	Object
    //   0	607	3	paramObject4	Object
    //   0	607	4	paramObject5	Object
    //   0	607	5	paramObject6	Object
    //   0	607	6	paramObject7	Object
    //   10	211	7	localObject1	Object
    //   29	361	8	localObject2	Object
    //   40	244	9	localObject3	Object
    //   326	7	10	localClassCastException1	ClassCastException
    //   46	38	11	localCharSequence1	CharSequence
    //   343	7	12	localClassCastException2	ClassCastException
    //   55	31	13	i	int
    //   360	7	14	localClassCastException3	ClassCastException
    //   61	27	15	localCharSequence2	CharSequence
    //   377	7	16	localClassCastException4	ClassCastException
    //   71	19	17	j	int
    //   395	7	18	localClassCastException5	ClassCastException
    //   81	11	19	k	int
    //   107	31	21	localObject4	Object
    //   119	6	22	localObject5	Object
    //   131	295	23	localObject6	Object
    //   142	407	24	localObject7	Object
    //   413	7	25	localClassCastException6	ClassCastException
    //   149	3	26	localNumber	Number
    //   519	7	27	localClassCastException7	ClassCastException
    //   247	66	28	localCharSequence3	CharSequence
    //   536	7	29	localClassCastException8	ClassCastException
    //   257	58	30	m	int
    //   554	7	31	localClassCastException9	ClassCastException
    //   263	54	32	localCharSequence4	CharSequence
    //   571	7	33	localClassCastException10	ClassCastException
    //   273	46	34	n	int
    //   300	302	35	localObject8	Object
    //   589	7	36	localClassCastException11	ClassCastException
    //   310	11	37	i1	int
    //   431	7	38	localClassCastException12	ClassCastException
    //   163	39	39	localCharSequence5	CharSequence
    //   448	7	40	localClassCastException13	ClassCastException
    //   173	31	41	i2	int
    //   466	7	42	localClassCastException14	ClassCastException
    //   179	27	43	localCharSequence6	CharSequence
    //   483	7	44	localClassCastException15	ClassCastException
    //   189	19	45	i3	int
    //   501	7	46	localClassCastException16	ClassCastException
    //   199	11	47	i4	int
    // Exception table:
    //   from	to	target	type
    //   42	48	326	java/lang/ClassCastException
    //   48	57	343	java/lang/ClassCastException
    //   57	63	360	java/lang/ClassCastException
    //   63	73	377	java/lang/ClassCastException
    //   73	83	395	java/lang/ClassCastException
    //   144	151	413	java/lang/ClassCastException
    //   159	165	431	java/lang/ClassCastException
    //   165	175	448	java/lang/ClassCastException
    //   175	181	466	java/lang/ClassCastException
    //   181	191	483	java/lang/ClassCastException
    //   191	201	501	java/lang/ClassCastException
    //   243	249	519	java/lang/ClassCastException
    //   249	259	536	java/lang/ClassCastException
    //   259	265	554	java/lang/ClassCastException
    //   265	275	571	java/lang/ClassCastException
    //   302	312	589	java/lang/ClassCastException
  }
  
  public static Object $PcStringCompare(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9)
  {
    Object localObject1 = AddOp.$Mn.apply2(paramObject3, paramObject2);
    Object localObject2 = AddOp.$Mn.apply2(paramObject6, paramObject5);
    Object localObject3 = $PcStringPrefixLength(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6);
    if (Scheme.numEqu.apply2(localObject3, localObject1) != Boolean.FALSE)
    {
      ApplyToArgs localApplyToArgs2 = Scheme.applyToArgs;
      if (Scheme.numEqu.apply2(localObject3, localObject2) != Boolean.FALSE) {}
      for (;;)
      {
        return localApplyToArgs2.apply2(paramObject8, paramObject3);
        paramObject8 = paramObject7;
      }
    }
    ApplyToArgs localApplyToArgs1 = Scheme.applyToArgs;
    if (Scheme.numEqu.apply2(localObject3, localObject2) != Boolean.FALSE) {}
    for (;;)
    {
      Object localObject6 = AddOp.$Pl.apply2(localObject3, paramObject2);
      return localApplyToArgs1.apply2(paramObject9, localObject6);
      try
      {
        localCharSequence1 = (CharSequence)paramObject1;
        localObject4 = AddOp.$Pl.apply2(paramObject2, localObject3);
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          CharSequence localCharSequence1;
          int i = ((Number)localObject4).intValue();
          localChar = Char.make(strings.stringRef(localCharSequence1, i));
        }
        catch (ClassCastException localClassCastException2)
        {
          Object localObject4;
          Char localChar;
          CharSequence localCharSequence2;
          int j;
          throw new WrongType(localClassCastException2, "string-ref", 2, localObject4);
        }
        try
        {
          localCharSequence2 = (CharSequence)paramObject4;
          localObject5 = AddOp.$Pl.apply2(paramObject5, localObject3);
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 1, paramObject4);
        }
        try
        {
          j = ((Number)localObject5).intValue();
          if (!characters.isChar$Ls(localChar, Char.make(strings.stringRef(localCharSequence2, j)))) {
            continue;
          }
          paramObject9 = paramObject7;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "string-ref", 2, localObject5);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "string-ref", 1, paramObject1);
      }
    }
  }
  
  /* Error */
  public static Object $PcStringCompareCi(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9)
  {
    // Byte code:
    //   0: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   3: aload_2
    //   4: aload_1
    //   5: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: astore 9
    //   10: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   13: aload 5
    //   15: aload 4
    //   17: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   20: astore 10
    //   22: aload_1
    //   23: checkcast 376	java/lang/Number
    //   26: invokevirtual 380	java/lang/Number:intValue	()I
    //   29: istore 12
    //   31: aload_2
    //   32: checkcast 376	java/lang/Number
    //   35: invokevirtual 380	java/lang/Number:intValue	()I
    //   38: istore 14
    //   40: aload 4
    //   42: checkcast 376	java/lang/Number
    //   45: invokevirtual 380	java/lang/Number:intValue	()I
    //   48: istore 16
    //   50: aload 5
    //   52: checkcast 376	java/lang/Number
    //   55: invokevirtual 380	java/lang/Number:intValue	()I
    //   58: istore 18
    //   60: aload_0
    //   61: iload 12
    //   63: iload 14
    //   65: aload_3
    //   66: iload 16
    //   68: iload 18
    //   70: invokestatic 522	gnu/kawa/slib/srfi13:$PcStringPrefixLengthCi	(Ljava/lang/Object;IILjava/lang/Object;II)I
    //   73: istore 19
    //   75: getstatic 435	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   78: iload 19
    //   80: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: aload 9
    //   85: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   91: if_acmpeq +43 -> 134
    //   94: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   97: astore 33
    //   99: getstatic 435	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   102: iload 19
    //   104: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aload 10
    //   109: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   115: if_acmpeq +12 -> 127
    //   118: aload 33
    //   120: aload 7
    //   122: aload_2
    //   123: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: areturn
    //   127: aload 6
    //   129: astore 7
    //   131: goto -13 -> 118
    //   134: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   137: astore 20
    //   139: getstatic 435	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   142: iload 19
    //   144: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: aload 10
    //   149: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   155: if_acmpeq +27 -> 182
    //   158: getstatic 368	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   161: aload_1
    //   162: iload 19
    //   164: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   167: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   170: astore 32
    //   172: aload 20
    //   174: aload 8
    //   176: aload 32
    //   178: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   181: areturn
    //   182: aload_0
    //   183: checkcast 386	java/lang/CharSequence
    //   186: astore 22
    //   188: getstatic 368	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   191: aload_1
    //   192: iload 19
    //   194: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   200: astore 23
    //   202: aload 23
    //   204: checkcast 376	java/lang/Number
    //   207: invokevirtual 380	java/lang/Number:intValue	()I
    //   210: istore 25
    //   212: aload 22
    //   214: iload 25
    //   216: invokestatic 456	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   219: invokestatic 462	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   222: astore 26
    //   224: aload_3
    //   225: checkcast 386	java/lang/CharSequence
    //   228: astore 28
    //   230: getstatic 368	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   233: aload 4
    //   235: iload 19
    //   237: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   240: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   243: astore 29
    //   245: aload 29
    //   247: checkcast 376	java/lang/Number
    //   250: invokevirtual 380	java/lang/Number:intValue	()I
    //   253: istore 31
    //   255: aload 26
    //   257: aload 28
    //   259: iload 31
    //   261: invokestatic 456	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   264: invokestatic 462	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   267: invokestatic 527	kawa/lib/rnrs/unicode:isCharCi$Ls	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   270: ifeq -112 -> 158
    //   273: aload 6
    //   275: astore 8
    //   277: goto -119 -> 158
    //   280: astore 11
    //   282: new 412	gnu/mapping/WrongType
    //   285: dup
    //   286: aload 11
    //   288: ldc_w 529
    //   291: iconst_1
    //   292: aload_1
    //   293: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   296: athrow
    //   297: astore 13
    //   299: new 412	gnu/mapping/WrongType
    //   302: dup
    //   303: aload 13
    //   305: ldc_w 529
    //   308: iconst_2
    //   309: aload_2
    //   310: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   313: athrow
    //   314: astore 15
    //   316: new 412	gnu/mapping/WrongType
    //   319: dup
    //   320: aload 15
    //   322: ldc_w 529
    //   325: iconst_4
    //   326: aload 4
    //   328: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   331: athrow
    //   332: astore 17
    //   334: new 412	gnu/mapping/WrongType
    //   337: dup
    //   338: aload 17
    //   340: ldc_w 529
    //   343: iconst_5
    //   344: aload 5
    //   346: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   349: athrow
    //   350: astore 21
    //   352: new 412	gnu/mapping/WrongType
    //   355: dup
    //   356: aload 21
    //   358: ldc_w 485
    //   361: iconst_1
    //   362: aload_0
    //   363: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   366: athrow
    //   367: astore 24
    //   369: new 412	gnu/mapping/WrongType
    //   372: dup
    //   373: aload 24
    //   375: ldc_w 485
    //   378: iconst_2
    //   379: aload 23
    //   381: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   384: athrow
    //   385: astore 27
    //   387: new 412	gnu/mapping/WrongType
    //   390: dup
    //   391: aload 27
    //   393: ldc_w 485
    //   396: iconst_1
    //   397: aload_3
    //   398: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   401: athrow
    //   402: astore 30
    //   404: new 412	gnu/mapping/WrongType
    //   407: dup
    //   408: aload 30
    //   410: ldc_w 485
    //   413: iconst_2
    //   414: aload 29
    //   416: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   419: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	paramObject1	Object
    //   0	420	1	paramObject2	Object
    //   0	420	2	paramObject3	Object
    //   0	420	3	paramObject4	Object
    //   0	420	4	paramObject5	Object
    //   0	420	5	paramObject6	Object
    //   0	420	6	paramObject7	Object
    //   0	420	7	paramObject8	Object
    //   0	420	8	paramObject9	Object
    //   8	76	9	localObject1	Object
    //   20	128	10	localObject2	Object
    //   280	7	11	localClassCastException1	ClassCastException
    //   29	33	12	i	int
    //   297	7	13	localClassCastException2	ClassCastException
    //   38	26	14	j	int
    //   314	7	15	localClassCastException3	ClassCastException
    //   48	19	16	k	int
    //   332	7	17	localClassCastException4	ClassCastException
    //   58	11	18	m	int
    //   73	163	19	n	int
    //   137	36	20	localApplyToArgs1	ApplyToArgs
    //   350	7	21	localClassCastException5	ClassCastException
    //   186	27	22	localCharSequence1	CharSequence
    //   200	180	23	localObject3	Object
    //   367	7	24	localClassCastException6	ClassCastException
    //   210	5	25	i1	int
    //   222	34	26	localChar	Char
    //   385	7	27	localClassCastException7	ClassCastException
    //   228	30	28	localCharSequence2	CharSequence
    //   243	172	29	localObject4	Object
    //   402	7	30	localClassCastException8	ClassCastException
    //   253	7	31	i2	int
    //   170	7	32	localObject5	Object
    //   97	22	33	localApplyToArgs2	ApplyToArgs
    // Exception table:
    //   from	to	target	type
    //   22	31	280	java/lang/ClassCastException
    //   31	40	297	java/lang/ClassCastException
    //   40	50	314	java/lang/ClassCastException
    //   50	60	332	java/lang/ClassCastException
    //   182	188	350	java/lang/ClassCastException
    //   202	212	367	java/lang/ClassCastException
    //   224	230	385	java/lang/ClassCastException
    //   245	255	402	java/lang/ClassCastException
  }
  
  public static Object $PcStringCopy$Ex(CharSequence paramCharSequence1, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3)
  {
    int k;
    int m;
    if (paramInt2 > paramInt1)
    {
      k = paramInt1;
      m = paramInt2;
    }
    for (;;)
    {
      if (m < paramInt3) {}
      try
      {
        CharSeq localCharSeq2 = (CharSeq)paramCharSequence1;
        strings.stringSet$Ex(localCharSeq2, k, strings.stringRef(paramCharSequence2, m));
        k++;
        m++;
      }
      catch (ClassCastException localClassCastException2)
      {
        int i;
        int j;
        throw new WrongType(localClassCastException2, "string-set!", 1, paramCharSequence1);
      }
    }
    return Values.empty;
    i = paramInt1 - 1 + (paramInt3 - paramInt2);
    j = paramInt3 - 1;
    for (;;)
    {
      if (j >= paramInt2) {}
      try
      {
        CharSeq localCharSeq1 = (CharSeq)paramCharSequence1;
        strings.stringSet$Ex(localCharSeq1, i, strings.stringRef(paramCharSequence2, j));
        i--;
        j--;
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "string-set!", 1, paramCharSequence1);
      }
    }
    return Values.empty;
  }
  
  public static Object $PcStringHash(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    frame55 localframe55 = new frame55();
    localframe55.char$Mn$Grint = paramObject2;
    Object localObject1 = Lit5;
    Object localObject2;
    Object localObject3;
    if (Scheme.numGEq.apply2(localObject1, paramObject3) != Boolean.FALSE)
    {
      localObject2 = AddOp.$Mn.apply2(localObject1, Lit1);
      localObject3 = Lit0;
      localObject4 = paramObject4;
    }
    for (;;)
    {
      if (Scheme.numGEq.apply2(localObject4, paramObject5) != Boolean.FALSE)
      {
        return DivideOp.modulo.apply2(localObject3, paramObject3);
        localObject1 = AddOp.$Pl.apply2(localObject1, localObject1);
        break;
      }
      Object localObject5 = AddOp.$Pl.apply2(localObject4, Lit1);
      BitwiseOp localBitwiseOp = BitwiseOp.and;
      AddOp localAddOp = AddOp.$Pl;
      Object localObject6 = MultiplyOp.$St.apply2(Lit6, localObject3);
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      Object localObject7 = localframe55.char$Mn$Grint;
      try
      {
        localCharSequence = (CharSequence)paramObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          CharSequence localCharSequence;
          int i = ((Number)localObject4).intValue();
          localObject3 = localBitwiseOp.apply2(localObject2, localAddOp.apply2(localObject6, localApplyToArgs.apply2(localObject7, Char.make(strings.stringRef(localCharSequence, i)))));
          localObject4 = localObject5;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-ref", 2, localObject4);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "string-ref", 1, paramObject1);
      }
    }
  }
  
  /* Error */
  public static Object $PcStringMap(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   3: aload_3
    //   4: aload_2
    //   5: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: astore 4
    //   10: aload 4
    //   12: checkcast 376	java/lang/Number
    //   15: invokevirtual 380	java/lang/Number:intValue	()I
    //   18: istore 6
    //   20: iload 6
    //   22: invokestatic 384	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   25: astore 7
    //   27: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   30: aload_3
    //   31: getstatic 468	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   34: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   37: astore 8
    //   39: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   42: aload 4
    //   44: getstatic 468	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   47: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: astore 9
    //   52: getstatic 571	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   55: aload 9
    //   57: getstatic 429	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   60: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   63: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   66: if_acmpne +214 -> 280
    //   69: aload 7
    //   71: checkcast 531	gnu/lists/CharSeq
    //   74: astore 11
    //   76: aload 9
    //   78: checkcast 376	java/lang/Number
    //   81: invokevirtual 380	java/lang/Number:intValue	()I
    //   84: istore 13
    //   86: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   89: astore 14
    //   91: aload_1
    //   92: checkcast 386	java/lang/CharSequence
    //   95: astore 16
    //   97: aload 8
    //   99: checkcast 376	java/lang/Number
    //   102: invokevirtual 380	java/lang/Number:intValue	()I
    //   105: istore 18
    //   107: aload 14
    //   109: aload_0
    //   110: aload 16
    //   112: iload 18
    //   114: invokestatic 456	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   117: invokestatic 462	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   120: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   123: astore 19
    //   125: aload 19
    //   127: checkcast 458	gnu/text/Char
    //   130: invokevirtual 575	gnu/text/Char:charValue	()C
    //   133: istore 21
    //   135: aload 11
    //   137: iload 13
    //   139: iload 21
    //   141: invokestatic 535	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   144: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   147: aload 8
    //   149: getstatic 468	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   152: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   155: astore 8
    //   157: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   160: aload 9
    //   162: getstatic 468	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   165: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   168: astore 9
    //   170: goto -118 -> 52
    //   173: astore 5
    //   175: new 412	gnu/mapping/WrongType
    //   178: dup
    //   179: aload 5
    //   181: ldc_w 414
    //   184: iconst_1
    //   185: aload 4
    //   187: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   190: athrow
    //   191: astore 10
    //   193: new 412	gnu/mapping/WrongType
    //   196: dup
    //   197: aload 10
    //   199: ldc_w 537
    //   202: iconst_1
    //   203: aload 7
    //   205: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   208: athrow
    //   209: astore 12
    //   211: new 412	gnu/mapping/WrongType
    //   214: dup
    //   215: aload 12
    //   217: ldc_w 537
    //   220: iconst_2
    //   221: aload 9
    //   223: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   226: athrow
    //   227: astore 15
    //   229: new 412	gnu/mapping/WrongType
    //   232: dup
    //   233: aload 15
    //   235: ldc_w 485
    //   238: iconst_1
    //   239: aload_1
    //   240: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   243: athrow
    //   244: astore 17
    //   246: new 412	gnu/mapping/WrongType
    //   249: dup
    //   250: aload 17
    //   252: ldc_w 485
    //   255: iconst_2
    //   256: aload 8
    //   258: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   261: athrow
    //   262: astore 20
    //   264: new 412	gnu/mapping/WrongType
    //   267: dup
    //   268: aload 20
    //   270: ldc_w 537
    //   273: iconst_3
    //   274: aload 19
    //   276: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   279: athrow
    //   280: aload 7
    //   282: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramObject1	Object
    //   0	283	1	paramObject2	Object
    //   0	283	2	paramObject3	Object
    //   0	283	3	paramObject4	Object
    //   8	178	4	localObject1	Object
    //   173	7	5	localClassCastException1	ClassCastException
    //   18	3	6	i	int
    //   25	256	7	localCharSequence1	CharSequence
    //   37	220	8	localObject2	Object
    //   50	172	9	localObject3	Object
    //   191	7	10	localClassCastException2	ClassCastException
    //   74	62	11	localCharSeq	CharSeq
    //   209	7	12	localClassCastException3	ClassCastException
    //   84	54	13	j	int
    //   89	19	14	localApplyToArgs	ApplyToArgs
    //   227	7	15	localClassCastException4	ClassCastException
    //   95	16	16	localCharSequence2	CharSequence
    //   244	7	17	localClassCastException5	ClassCastException
    //   105	8	18	k	int
    //   123	152	19	localObject4	Object
    //   262	7	20	localClassCastException6	ClassCastException
    //   133	7	21	c	char
    // Exception table:
    //   from	to	target	type
    //   10	20	173	java/lang/ClassCastException
    //   69	76	191	java/lang/ClassCastException
    //   76	86	209	java/lang/ClassCastException
    //   91	97	227	java/lang/ClassCastException
    //   97	107	244	java/lang/ClassCastException
    //   125	135	262	java/lang/ClassCastException
  }
  
  public static Object $PcStringMap$Ex(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    localObject1 = AddOp.$Mn.apply2(paramObject4, Lit1);
    for (;;)
    {
      if (Scheme.numLss.apply2(localObject1, paramObject3) == Boolean.FALSE) {}
      Object localObject2;
      try
      {
        localCharSeq = (CharSeq)paramObject2;
      }
      catch (ClassCastException localClassCastException1)
      {
        CharSeq localCharSeq;
        int i;
        ApplyToArgs localApplyToArgs;
        CharSequence localCharSequence;
        int j;
        char c;
        throw new WrongType(localClassCastException1, "string-set!", 1, paramObject2);
      }
      try
      {
        i = ((Number)localObject1).intValue();
        localApplyToArgs = Scheme.applyToArgs;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-set!", 2, localObject1);
      }
      try
      {
        localCharSequence = (CharSequence)paramObject2;
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "string-ref", 1, paramObject2);
      }
      try
      {
        j = ((Number)localObject1).intValue();
        localObject2 = localApplyToArgs.apply2(paramObject1, Char.make(strings.stringRef(localCharSequence, j)));
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "string-ref", 2, localObject1);
      }
      try
      {
        c = ((Char)localObject2).charValue();
        strings.stringSet$Ex(localCharSeq, i, c);
        localObject1 = AddOp.$Mn.apply2(localObject1, Lit1);
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "string-set!", 3, localObject2);
      }
    }
    return Values.empty;
  }
  
  public static Object $PcStringPrefix$Qu(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    Object localObject1 = AddOp.$Mn.apply2(paramObject3, paramObject2);
    Object localObject2 = Scheme.numLEq.apply2(localObject1, AddOp.$Mn.apply2(paramObject6, paramObject5));
    try
    {
      boolean bool = ((Boolean)localObject2).booleanValue();
      if (bool) {
        return Scheme.numEqu.apply2($PcStringPrefixLength(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6), localObject1);
      }
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "x", -2, localObject2);
    }
  }
  
  public static Object $PcStringPrefixCi$Qu(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    Object localObject1 = AddOp.$Mn.apply2(paramObject3, paramObject2);
    localObject2 = Scheme.numLEq.apply2(localObject1, AddOp.$Mn.apply2(paramObject6, paramObject5));
    try
    {
      bool = ((Boolean)localObject2).booleanValue();
      if (bool) {
        localNumberCompare = Scheme.numEqu;
      }
    }
    catch (ClassCastException localClassCastException1)
    {
      boolean bool;
      NumberCompare localNumberCompare;
      int i;
      int j;
      int k;
      int m;
      throw new WrongType(localClassCastException1, "x", -2, localObject2);
    }
    try
    {
      i = ((Number)paramObject2).intValue();
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "%string-prefix-length-ci", 1, paramObject2);
    }
    try
    {
      j = ((Number)paramObject3).intValue();
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "%string-prefix-length-ci", 2, paramObject3);
    }
    try
    {
      k = ((Number)paramObject5).intValue();
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "%string-prefix-length-ci", 4, paramObject5);
    }
    try
    {
      m = ((Number)paramObject6).intValue();
      return localNumberCompare.apply2(localObject1, Integer.valueOf($PcStringPrefixLengthCi(paramObject1, i, j, paramObject4, k, m)));
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "%string-prefix-length-ci", 5, paramObject6);
    }
    if (bool) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static Object $PcStringPrefixLength(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = AddOp.$Mn.apply2(paramObject3, paramObject2);
    arrayOfObject[1] = AddOp.$Mn.apply2(paramObject6, paramObject5);
    Object localObject1 = numbers.min(arrayOfObject);
    Object localObject2 = AddOp.$Pl.apply2(paramObject2, localObject1);
    int i = 0;
    if (paramObject1 == paramObject4) {
      i = 1;
    }
    if (i != 0)
    {
      if (Scheme.numEqu.apply2(paramObject2, paramObject5) == Boolean.FALSE) {}
    }
    else {
      while (i != 0) {
        return localObject1;
      }
    }
    localObject3 = paramObject2;
    localObject4 = paramObject5;
    for (;;)
    {
      Object localObject5 = Scheme.numGEq.apply2(localObject3, localObject2);
      try
      {
        boolean bool = ((Boolean)localObject5).booleanValue();
        if (bool)
        {
          if (!bool) {
            break label200;
          }
          label128:
          return AddOp.$Mn.apply2(localObject3, paramObject2);
        }
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          localCharSequence1 = (CharSequence)paramObject1;
        }
        catch (ClassCastException localClassCastException2)
        {
          CharSequence localCharSequence1;
          int j;
          Char localChar;
          CharSequence localCharSequence2;
          int k;
          label200:
          throw new WrongType(localClassCastException2, "string-ref", 1, paramObject1);
        }
        try
        {
          j = ((Number)localObject3).intValue();
          localChar = Char.make(strings.stringRef(localCharSequence1, j));
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 2, localObject3);
        }
        try
        {
          localCharSequence2 = (CharSequence)paramObject4;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "string-ref", 1, paramObject4);
        }
        try
        {
          k = ((Number)localObject4).intValue();
          if (!characters.isChar$Eq(localChar, Char.make(strings.stringRef(localCharSequence2, k)))) {
            break label128;
          }
          localObject3 = AddOp.$Pl.apply2(localObject3, Lit1);
          localObject4 = AddOp.$Pl.apply2(localObject4, Lit1);
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "string-ref", 2, localObject4);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "x", -2, localObject5);
      }
    }
  }
  
  public static int $PcStringPrefixLengthCi(Object paramObject1, int paramInt1, int paramInt2, Object paramObject2, int paramInt3, int paramInt4)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt2 - paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt4 - paramInt3);
    localObject = numbers.min(arrayOfObject);
    try
    {
      int i = ((Number)localObject).intValue();
      j = paramInt1 + i;
      int k;
      if (paramObject1 == paramObject2)
      {
        k = 1;
        if (k == 0) {
          break label79;
        }
        if (paramInt1 != paramInt3) {
          break label84;
        }
      }
      label79:
      while (k != 0)
      {
        return i;
        k = 0;
        break;
      }
      label84:
      m = paramInt1;
    }
    catch (ClassCastException localClassCastException1)
    {
      for (;;)
      {
        try
        {
          int j;
          int n;
          CharSequence localCharSequence1 = (CharSequence)paramObject1;
          localChar = Char.make(strings.stringRef(localCharSequence1, m));
        }
        catch (ClassCastException localClassCastException2)
        {
          int m;
          Char localChar;
          CharSequence localCharSequence2;
          throw new WrongType(localClassCastException2, "string-ref", 1, paramObject1);
        }
        try
        {
          localCharSequence2 = (CharSequence)paramObject2;
          if (unicode.isCharCi$Eq(localChar, Char.make(strings.stringRef(localCharSequence2, paramInt3))))
          {
            int i1 = paramInt3 + 1;
            m++;
            paramInt3 = i1;
          }
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 1, paramObject2);
        }
      }
      localClassCastException1 = localClassCastException1;
      throw new WrongType(localClassCastException1, "delta", -2, localObject);
    }
    if (m >= j) {}
    for (n = 1; n != 0; n = 0)
    {
      if (n == 0) {
        break label160;
      }
      return m - paramInt1;
    }
  }
  
  public static Object $PcStringSuffix$Qu(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    Object localObject1 = AddOp.$Mn.apply2(paramObject3, paramObject2);
    Object localObject2 = Scheme.numLEq.apply2(localObject1, AddOp.$Mn.apply2(paramObject6, paramObject5));
    try
    {
      boolean bool = ((Boolean)localObject2).booleanValue();
      if (bool) {
        return Scheme.numEqu.apply2(localObject1, $PcStringSuffixLength(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6));
      }
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "x", -2, localObject2);
    }
  }
  
  public static Object $PcStringSuffixCi$Qu(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    Object localObject1 = AddOp.$Mn.apply2(paramObject3, paramObject2);
    localObject2 = Scheme.numLEq.apply2(localObject1, AddOp.$Mn.apply2(paramObject6, paramObject5));
    try
    {
      bool = ((Boolean)localObject2).booleanValue();
      if (bool) {
        localNumberCompare = Scheme.numEqu;
      }
    }
    catch (ClassCastException localClassCastException1)
    {
      boolean bool;
      NumberCompare localNumberCompare;
      int i;
      int j;
      int k;
      int m;
      throw new WrongType(localClassCastException1, "x", -2, localObject2);
    }
    try
    {
      i = ((Number)paramObject2).intValue();
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "%string-suffix-length-ci", 1, paramObject2);
    }
    try
    {
      j = ((Number)paramObject3).intValue();
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "%string-suffix-length-ci", 2, paramObject3);
    }
    try
    {
      k = ((Number)paramObject5).intValue();
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "%string-suffix-length-ci", 4, paramObject5);
    }
    try
    {
      m = ((Number)paramObject6).intValue();
      return localNumberCompare.apply2(localObject1, Integer.valueOf($PcStringSuffixLengthCi(paramObject1, i, j, paramObject4, k, m)));
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "%string-suffix-length-ci", 5, paramObject6);
    }
    if (bool) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static Object $PcStringSuffixLength(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = AddOp.$Mn.apply2(paramObject3, paramObject2);
    arrayOfObject[1] = AddOp.$Mn.apply2(paramObject6, paramObject5);
    Object localObject1 = numbers.min(arrayOfObject);
    Object localObject2 = AddOp.$Mn.apply2(paramObject3, localObject1);
    int i = 0;
    if (paramObject1 == paramObject4) {
      i = 1;
    }
    if (i != 0)
    {
      if (Scheme.numEqu.apply2(paramObject3, paramObject6) == Boolean.FALSE) {}
    }
    else {
      while (i != 0) {
        return localObject1;
      }
    }
    localObject3 = AddOp.$Mn.apply2(paramObject3, Lit1);
    localObject4 = AddOp.$Mn.apply2(paramObject6, Lit1);
    for (;;)
    {
      Object localObject5 = Scheme.numLss.apply2(localObject3, localObject2);
      try
      {
        boolean bool = ((Boolean)localObject5).booleanValue();
        if (bool)
        {
          if (!bool) {
            break label227;
          }
          label146:
          return AddOp.$Mn.apply2(AddOp.$Mn.apply2(paramObject3, localObject3), Lit1);
        }
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          localCharSequence1 = (CharSequence)paramObject1;
        }
        catch (ClassCastException localClassCastException2)
        {
          CharSequence localCharSequence1;
          int j;
          Char localChar;
          CharSequence localCharSequence2;
          int k;
          label227:
          throw new WrongType(localClassCastException2, "string-ref", 1, paramObject1);
        }
        try
        {
          j = ((Number)localObject3).intValue();
          localChar = Char.make(strings.stringRef(localCharSequence1, j));
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 2, localObject3);
        }
        try
        {
          localCharSequence2 = (CharSequence)paramObject4;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "string-ref", 1, paramObject4);
        }
        try
        {
          k = ((Number)localObject4).intValue();
          if (!characters.isChar$Eq(localChar, Char.make(strings.stringRef(localCharSequence2, k)))) {
            break label146;
          }
          localObject3 = AddOp.$Mn.apply2(localObject3, Lit1);
          localObject4 = AddOp.$Mn.apply2(localObject4, Lit1);
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "string-ref", 2, localObject4);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "x", -2, localObject5);
      }
    }
  }
  
  public static int $PcStringSuffixLengthCi(Object paramObject1, int paramInt1, int paramInt2, Object paramObject2, int paramInt3, int paramInt4)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt2 - paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt4 - paramInt3);
    localObject = numbers.min(arrayOfObject);
    try
    {
      int i = ((Number)localObject).intValue();
      j = paramInt2 - i;
      int k;
      if (paramObject1 == paramObject2)
      {
        k = 1;
        if (k == 0) {
          break label79;
        }
        if (paramInt2 != paramInt4) {
          break label84;
        }
      }
      label79:
      while (k != 0)
      {
        return i;
        k = 0;
        break;
      }
      label84:
      m = paramInt2 - 1;
      n = paramInt4 - 1;
    }
    catch (ClassCastException localClassCastException1)
    {
      for (;;)
      {
        try
        {
          int j;
          int i1;
          CharSequence localCharSequence1 = (CharSequence)paramObject1;
          localChar = Char.make(strings.stringRef(localCharSequence1, m));
        }
        catch (ClassCastException localClassCastException2)
        {
          int m;
          int n;
          Char localChar;
          CharSequence localCharSequence2;
          throw new WrongType(localClassCastException2, "string-ref", 1, paramObject1);
        }
        try
        {
          localCharSequence2 = (CharSequence)paramObject2;
          if (unicode.isCharCi$Eq(localChar, Char.make(strings.stringRef(localCharSequence2, n))))
          {
            n--;
            m--;
          }
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 1, paramObject2);
        }
      }
      localClassCastException1 = localClassCastException1;
      throw new WrongType(localClassCastException1, "delta", -2, localObject);
    }
    if (m < j) {}
    for (i1 = 1; i1 != 0; i1 = 0)
    {
      if (i1 == 0) {
        break label170;
      }
      return -1 + (paramInt2 - m);
    }
  }
  
  public static Object $PcStringTitlecase$Ex(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject1 = paramObject2;
    for (;;)
    {
      Location localLocation1 = loc$char$Mncased$Qu;
      Object localObject3;
      Char localChar;
      try
      {
        Object localObject2 = localLocation1.get();
        localObject3 = stringIndex$V(paramObject1, localObject2, new Object[] { localObject1, paramObject3 });
        if (localObject3 == Boolean.FALSE) {}
      }
      catch (UnboundLocationException localUnboundLocationException1)
      {
        CharSeq localCharSeq;
        int i;
        CharSequence localCharSequence;
        int j;
        char c;
        Object localObject4;
        Location localLocation2;
        Object localObject5;
        Object localObject6;
        localUnboundLocationException1.setLine("srfi13.scm", 955, 28);
        throw localUnboundLocationException1;
      }
      try
      {
        localCharSeq = (CharSeq)paramObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "string-set!", 1, paramObject1);
      }
      try
      {
        i = ((Number)localObject3).intValue();
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-set!", 2, localObject3);
      }
      try
      {
        localCharSequence = (CharSequence)paramObject1;
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "string-ref", 1, paramObject1);
      }
      try
      {
        j = ((Number)localObject3).intValue();
        localChar = unicode.charTitlecase(Char.make(strings.stringRef(localCharSequence, j)));
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "string-ref", 2, localObject3);
      }
      try
      {
        c = localChar.charValue();
        strings.stringSet$Ex(localCharSeq, i, c);
        localObject4 = AddOp.$Pl.apply2(localObject3, Lit1);
        localLocation2 = loc$char$Mncased$Qu;
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "string-set!", 3, localChar);
      }
      try
      {
        localObject5 = localLocation2.get();
        localObject6 = stringSkip$V(paramObject1, localObject5, new Object[] { localObject4, paramObject3 });
        if (localObject6 != Boolean.FALSE)
        {
          stringDowncase$Ex$V(paramObject1, new Object[] { localObject4, localObject6 });
          localObject1 = AddOp.$Pl.apply2(localObject6, Lit1);
        }
        else
        {
          return stringDowncase$Ex$V(paramObject1, new Object[] { localObject4, paramObject3 });
        }
      }
      catch (UnboundLocationException localUnboundLocationException2)
      {
        localUnboundLocationException2.setLine("srfi13.scm", 959, 31);
        throw localUnboundLocationException2;
      }
    }
    return Values.empty;
  }
  
  public static Object $PcSubstring$SlShared(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    boolean bool = numbers.isZero(Integer.valueOf(paramInt1));
    if (bool)
    {
      if (paramInt2 != strings.stringLength(paramCharSequence)) {}
    }
    else {
      while (bool) {
        return paramCharSequence;
      }
    }
    return strings.substring(paramCharSequence, paramInt1, paramInt2);
  }
  
  static
  {
    Lit149 = (SimpleSymbol)new SimpleSymbol("string-join").readResolve();
    Lit148 = (SimpleSymbol)new SimpleSymbol("%multispan-repcopy!").readResolve();
    Lit147 = (SimpleSymbol)new SimpleSymbol("string-xcopy!").readResolve();
    Lit146 = (SimpleSymbol)new SimpleSymbol("xsubstring").readResolve();
    Lit145 = (SimpleSymbol)new SimpleSymbol("string-tokenize").readResolve();
    Lit144 = (SimpleSymbol)new SimpleSymbol("string-replace").readResolve();
    Lit143 = (SimpleSymbol)new SimpleSymbol("%finish-string-concatenate-reverse").readResolve();
    Lit142 = (SimpleSymbol)new SimpleSymbol("string-concatenate-reverse/shared").readResolve();
    Lit141 = (SimpleSymbol)new SimpleSymbol("string-concatenate-reverse").readResolve();
    Lit140 = (SimpleSymbol)new SimpleSymbol("string-concatenate").readResolve();
    Lit139 = (SimpleSymbol)new SimpleSymbol("string-concatenate/shared").readResolve();
    Lit138 = (SimpleSymbol)new SimpleSymbol("string-append/shared").readResolve();
    Lit137 = (SimpleSymbol)new SimpleSymbol("string->list").readResolve();
    Lit136 = (SimpleSymbol)new SimpleSymbol("reverse-list->string").readResolve();
    Lit135 = (SimpleSymbol)new SimpleSymbol("string-reverse!").readResolve();
    Lit134 = (SimpleSymbol)new SimpleSymbol("string-reverse").readResolve();
    Lit133 = (SimpleSymbol)new SimpleSymbol("string-null?").readResolve();
    Lit132 = (SimpleSymbol)new SimpleSymbol("string-kmp-partial-search").readResolve();
    Lit131 = (SimpleSymbol)new SimpleSymbol("kmp-step").readResolve();
    Lit130 = (SimpleSymbol)new SimpleSymbol("make-kmp-restart-vector").readResolve();
    Lit129 = (SimpleSymbol)new SimpleSymbol("%kmp-search").readResolve();
    Lit128 = (SimpleSymbol)new SimpleSymbol("string-contains-ci").readResolve();
    Lit127 = (SimpleSymbol)new SimpleSymbol("string-contains").readResolve();
    Lit126 = (SimpleSymbol)new SimpleSymbol("%string-copy!").readResolve();
    Lit125 = (SimpleSymbol)new SimpleSymbol("string-copy!").readResolve();
    Lit124 = (SimpleSymbol)new SimpleSymbol("string-fill!").readResolve();
    Lit123 = (SimpleSymbol)new SimpleSymbol("string-count").readResolve();
    Lit122 = (SimpleSymbol)new SimpleSymbol("string-skip-right").readResolve();
    Lit121 = (SimpleSymbol)new SimpleSymbol("string-skip").readResolve();
    Lit120 = (SimpleSymbol)new SimpleSymbol("string-index-right").readResolve();
    Lit119 = (SimpleSymbol)new SimpleSymbol("string-index").readResolve();
    Lit118 = (SimpleSymbol)new SimpleSymbol("string-filter").readResolve();
    Lit117 = (SimpleSymbol)new SimpleSymbol("string-delete").readResolve();
    Lit116 = (SimpleSymbol)new SimpleSymbol("string-pad").readResolve();
    Lit115 = (SimpleSymbol)new SimpleSymbol("string-pad-right").readResolve();
    Lit114 = (SimpleSymbol)new SimpleSymbol("string-trim-both").readResolve();
    Lit113 = (SimpleSymbol)new SimpleSymbol("string-trim-right").readResolve();
    Lit112 = (SimpleSymbol)new SimpleSymbol("string-trim").readResolve();
    Lit111 = (SimpleSymbol)new SimpleSymbol("string-drop-right").readResolve();
    Lit110 = (SimpleSymbol)new SimpleSymbol("string-drop").readResolve();
    Lit109 = (SimpleSymbol)new SimpleSymbol("string-take-right").readResolve();
    Lit108 = (SimpleSymbol)new SimpleSymbol("string-take").readResolve();
    Lit107 = (SimpleSymbol)new SimpleSymbol("string-titlecase").readResolve();
    Lit106 = (SimpleSymbol)new SimpleSymbol("string-titlecase!").readResolve();
    Lit105 = (SimpleSymbol)new SimpleSymbol("%string-titlecase!").readResolve();
    Lit104 = (SimpleSymbol)new SimpleSymbol("string-downcase!").readResolve();
    Lit103 = (SimpleSymbol)new SimpleSymbol("string-downcase").readResolve();
    Lit102 = (SimpleSymbol)new SimpleSymbol("string-upcase!").readResolve();
    Lit101 = (SimpleSymbol)new SimpleSymbol("string-upcase").readResolve();
    Lit100 = (SimpleSymbol)new SimpleSymbol("string-hash-ci").readResolve();
    Lit99 = (SimpleSymbol)new SimpleSymbol("string-hash").readResolve();
    Lit98 = (SimpleSymbol)new SimpleSymbol("%string-hash").readResolve();
    Lit97 = (SimpleSymbol)new SimpleSymbol("string-ci>=").readResolve();
    Lit96 = (SimpleSymbol)new SimpleSymbol("string-ci<=").readResolve();
    Lit95 = (SimpleSymbol)new SimpleSymbol("string-ci>").readResolve();
    Lit94 = (SimpleSymbol)new SimpleSymbol("string-ci<").readResolve();
    Lit93 = (SimpleSymbol)new SimpleSymbol("string-ci<>").readResolve();
    Lit92 = (SimpleSymbol)new SimpleSymbol("string-ci=").readResolve();
    Lit91 = (SimpleSymbol)new SimpleSymbol("string>=").readResolve();
    Lit90 = (SimpleSymbol)new SimpleSymbol("string<=").readResolve();
    Lit89 = (SimpleSymbol)new SimpleSymbol("string>").readResolve();
    Lit88 = (SimpleSymbol)new SimpleSymbol("string<").readResolve();
    Lit87 = (SimpleSymbol)new SimpleSymbol("string<>").readResolve();
    Lit86 = (SimpleSymbol)new SimpleSymbol("string=").readResolve();
    Lit85 = (SimpleSymbol)new SimpleSymbol("string-compare-ci").readResolve();
    Lit84 = (SimpleSymbol)new SimpleSymbol("string-compare").readResolve();
    Lit83 = (SimpleSymbol)new SimpleSymbol("%string-compare-ci").readResolve();
    Lit82 = (SimpleSymbol)new SimpleSymbol("%string-compare").readResolve();
    Lit81 = (SimpleSymbol)new SimpleSymbol("%string-suffix-ci?").readResolve();
    Lit80 = (SimpleSymbol)new SimpleSymbol("%string-prefix-ci?").readResolve();
    Lit79 = (SimpleSymbol)new SimpleSymbol("%string-suffix?").readResolve();
    Lit78 = (SimpleSymbol)new SimpleSymbol("%string-prefix?").readResolve();
    Lit77 = (SimpleSymbol)new SimpleSymbol("string-suffix-ci?").readResolve();
    Lit76 = (SimpleSymbol)new SimpleSymbol("string-prefix-ci?").readResolve();
    Lit75 = (SimpleSymbol)new SimpleSymbol("string-suffix?").readResolve();
    Lit74 = (SimpleSymbol)new SimpleSymbol("string-prefix?").readResolve();
    Lit73 = (SimpleSymbol)new SimpleSymbol("string-suffix-length-ci").readResolve();
    Lit72 = (SimpleSymbol)new SimpleSymbol("string-prefix-length-ci").readResolve();
    Lit71 = (SimpleSymbol)new SimpleSymbol("string-suffix-length").readResolve();
    Lit70 = (SimpleSymbol)new SimpleSymbol("string-prefix-length").readResolve();
    Lit69 = (SimpleSymbol)new SimpleSymbol("%string-suffix-length-ci").readResolve();
    Lit68 = (SimpleSymbol)new SimpleSymbol("%string-prefix-length-ci").readResolve();
    Lit67 = (SimpleSymbol)new SimpleSymbol("%string-suffix-length").readResolve();
    Lit66 = (SimpleSymbol)new SimpleSymbol("%string-prefix-length").readResolve();
    Lit65 = (SimpleSymbol)new SimpleSymbol("string-tabulate").readResolve();
    Lit64 = (SimpleSymbol)new SimpleSymbol("string-any").readResolve();
    Lit63 = (SimpleSymbol)new SimpleSymbol("string-every").readResolve();
    Lit62 = (SimpleSymbol)new SimpleSymbol("string-for-each-index").readResolve();
    Lit61 = (SimpleSymbol)new SimpleSymbol("string-for-each").readResolve();
    Lit60 = (SimpleSymbol)new SimpleSymbol("string-unfold-right").readResolve();
    Lit59 = (SimpleSymbol)new SimpleSymbol("string-unfold").readResolve();
    Lit58 = (SimpleSymbol)new SimpleSymbol("string-fold-right").readResolve();
    Lit57 = (SimpleSymbol)new SimpleSymbol("string-fold").readResolve();
    Lit56 = (SimpleSymbol)new SimpleSymbol("%string-map!").readResolve();
    Lit55 = (SimpleSymbol)new SimpleSymbol("string-map!").readResolve();
    Lit54 = (SimpleSymbol)new SimpleSymbol("%string-map").readResolve();
    Lit53 = (SimpleSymbol)new SimpleSymbol("string-map").readResolve();
    Lit52 = (SimpleSymbol)new SimpleSymbol("string-copy").readResolve();
    Lit51 = (SimpleSymbol)new SimpleSymbol("%substring/shared").readResolve();
    Lit50 = (SimpleSymbol)new SimpleSymbol("substring/shared").readResolve();
    Lit49 = (SimpleSymbol)new SimpleSymbol("check-substring-spec").readResolve();
    Lit48 = (SimpleSymbol)new SimpleSymbol("substring-spec-ok?").readResolve();
    Lit47 = (SimpleSymbol)new SimpleSymbol("string-parse-final-start+end").readResolve();
    Lit46 = (SimpleSymbol)new SimpleSymbol("%check-bounds").readResolve();
    Lit45 = (SimpleSymbol)new SimpleSymbol("string-parse-start+end").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = ((SimpleSymbol)new SimpleSymbol("l-s-s+e2").readResolve());
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("\f\030L\f\007\f\017\f\027\f\037\b\f'\f/\f7\f?\rG@\b\b", new Object[0], 9);
    Object[] arrayOfObject2 = new Object[5];
    arrayOfObject2[0] = ((SimpleSymbol)new SimpleSymbol("let").readResolve());
    arrayOfObject2[1] = ((SimpleSymbol)new SimpleSymbol("procv").readResolve());
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("let-string-start+end").readResolve();
    Lit41 = localSimpleSymbol1;
    arrayOfObject2[2] = localSimpleSymbol1;
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("rest").readResolve();
    Lit27 = localSimpleSymbol2;
    arrayOfObject2[3] = PairWithPosition.make(localSimpleSymbol2, LList.Empty, "srfi13.scm", 553003);
    arrayOfObject2[4] = Lit27;
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\001\001\001\001\001\001\001\001\003", "\021\030\0041\b\021\030\f\b#\b\021\030\0241\t\003\t\013\030\034\021\030\f\t+\t;\b\021\030\024!\t\023\b\033\021\030\f\t3\021\030$\bEC", arrayOfObject2, 1);
    Lit44 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 9);
    Lit43 = (SimpleSymbol)new SimpleSymbol("let-string-start+end2").readResolve();
    Object[] arrayOfObject3 = new Object[1];
    arrayOfObject3[0] = Lit41;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[2];
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030,\f\007\f\017\b\f\027\f\037\f'\r/(\b\b", new Object[0], 6);
    Object[] arrayOfObject4 = new Object[2];
    arrayOfObject4[0] = Lit150;
    arrayOfObject4[1] = Lit47;
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern2, "\001\001\001\001\001\003", "\021\030\004!\t\003\b\013I\021\030\f\t\023\t\033\b#\b-+", arrayOfObject4, 1);
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("\f\030<\f\007\f\017\f\027\b\f\037\f'\f/\r70\b\b", new Object[0], 7);
    Object[] arrayOfObject5 = new Object[2];
    arrayOfObject5[0] = Lit150;
    arrayOfObject5[1] = Lit45;
    arrayOfSyntaxRule2[1] = new SyntaxRule(localSyntaxPattern3, "\001\001\001\001\001\001\003", "\021\030\0041\t\023\t\003\b\013I\021\030\f\t\033\t#\b+\b53", arrayOfObject5, 1);
    Lit42 = new SyntaxRules(arrayOfObject3, arrayOfSyntaxRule2, 7);
    Lit40 = (SimpleSymbol)new SimpleSymbol("grammar").readResolve();
    Lit39 = (SimpleSymbol)new SimpleSymbol("delim").readResolve();
    Lit38 = (SimpleSymbol)new SimpleSymbol("token-chars").readResolve();
    Lit37 = (SimpleSymbol)new SimpleSymbol("final").readResolve();
    Lit36 = (SimpleSymbol)new SimpleSymbol("s-end").readResolve();
    Lit35 = (SimpleSymbol)new SimpleSymbol("s-start").readResolve();
    Lit34 = (SimpleSymbol)new SimpleSymbol("p-start").readResolve();
    Lit33 = (SimpleSymbol)new SimpleSymbol("end").readResolve();
    Lit32 = (SimpleSymbol)new SimpleSymbol("start").readResolve();
    Lit31 = (SimpleSymbol)new SimpleSymbol("c=").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("char-set").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("criterion").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("char-cased?").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("bound").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("char-set-contains?").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("char-set?").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("make-final").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("base").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("let-optionals*").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol(":optional").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("check-arg").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("suffix").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("prefix").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("strict-infix").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("infix").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("graphic").readResolve();
    Lit13 = IntNum.make(-1);
    Lit12 = Char.make(32);
    Lit11 = (SimpleSymbol)new SimpleSymbol("whitespace").readResolve();
    Lit10 = IntNum.make(4194304);
    Lit9 = IntNum.make(4194304);
    Lit8 = IntNum.make(4194304);
    Lit7 = IntNum.make(4194304);
    Lit6 = IntNum.make(37);
    Lit5 = IntNum.make(65536);
    Lit4 = IntNum.make(4096);
    Lit3 = IntNum.make(40);
    Lit2 = IntNum.make(4096);
    Lit1 = IntNum.make(1);
    Lit0 = IntNum.make(0);
    $instance = new srfi13();
    loc$check$Mnarg = ThreadLocation.getInstance(Lit19, null);
    loc$$Cloptional = ThreadLocation.getInstance(Lit20, null);
    loc$let$Mnoptionals$St = ThreadLocation.getInstance(Lit21, null);
    loc$base = ThreadLocation.getInstance(Lit22, null);
    loc$make$Mnfinal = ThreadLocation.getInstance(Lit23, null);
    loc$char$Mnset$Qu = ThreadLocation.getInstance(Lit24, null);
    loc$char$Mnset$Mncontains$Qu = ThreadLocation.getInstance(Lit25, null);
    loc$bound = ThreadLocation.getInstance(Lit26, null);
    loc$rest = ThreadLocation.getInstance(Lit27, null);
    loc$char$Mncased$Qu = ThreadLocation.getInstance(Lit28, null);
    loc$criterion = ThreadLocation.getInstance(Lit29, null);
    loc$char$Mnset = ThreadLocation.getInstance(Lit30, null);
    loc$c$Eq = ThreadLocation.getInstance(Lit31, null);
    loc$start = ThreadLocation.getInstance(Lit32, null);
    loc$end = ThreadLocation.getInstance(Lit33, null);
    loc$p$Mnstart = ThreadLocation.getInstance(Lit34, null);
    loc$s$Mnstart = ThreadLocation.getInstance(Lit35, null);
    loc$s$Mnend = ThreadLocation.getInstance(Lit36, null);
    loc$final = ThreadLocation.getInstance(Lit37, null);
    loc$token$Mnchars = ThreadLocation.getInstance(Lit38, null);
    loc$delim = ThreadLocation.getInstance(Lit39, null);
    loc$grammar = ThreadLocation.getInstance(Lit40, null);
    let$Mnstring$Mnstart$Plend = Macro.make(Lit41, Lit42, $instance);
    let$Mnstring$Mnstart$Plend2 = Macro.make(Lit43, Lit44, $instance);
    srfi13 localsrfi13 = $instance;
    string$Mnparse$Mnstart$Plend = new ModuleMethod(localsrfi13, 194, Lit45, 12291);
    $Pccheck$Mnbounds = new ModuleMethod(localsrfi13, 195, Lit46, 16388);
    string$Mnparse$Mnfinal$Mnstart$Plend = new ModuleMethod(localsrfi13, 196, Lit47, 12291);
    substring$Mnspec$Mnok$Qu = new ModuleMethod(localsrfi13, 197, Lit48, 12291);
    check$Mnsubstring$Mnspec = new ModuleMethod(localsrfi13, 198, Lit49, 16388);
    ModuleMethod localModuleMethod1 = new ModuleMethod(localsrfi13, 199, null, 4097);
    localModuleMethod1.setProperty("source-location", "srfi13.scm:223");
    lambda$Fn5 = localModuleMethod1;
    substring$Slshared = new ModuleMethod(localsrfi13, 200, Lit50, -4094);
    $Pcsubstring$Slshared = new ModuleMethod(localsrfi13, 201, Lit51, 12291);
    string$Mncopy = new ModuleMethod(localsrfi13, 202, Lit52, -4095);
    string$Mnmap = new ModuleMethod(localsrfi13, 203, Lit53, -4094);
    $Pcstring$Mnmap = new ModuleMethod(localsrfi13, 204, Lit54, 16388);
    string$Mnmap$Ex = new ModuleMethod(localsrfi13, 205, Lit55, -4094);
    $Pcstring$Mnmap$Ex = new ModuleMethod(localsrfi13, 206, Lit56, 16388);
    string$Mnfold = new ModuleMethod(localsrfi13, 207, Lit57, -4093);
    string$Mnfold$Mnright = new ModuleMethod(localsrfi13, 208, Lit58, -4093);
    ModuleMethod localModuleMethod2 = new ModuleMethod(localsrfi13, 209, null, 4097);
    localModuleMethod2.setProperty("source-location", "srfi13.scm:377");
    lambda$Fn17 = localModuleMethod2;
    string$Mnunfold = new ModuleMethod(localsrfi13, 210, Lit59, -4092);
    ModuleMethod localModuleMethod3 = new ModuleMethod(localsrfi13, 211, null, 4097);
    localModuleMethod3.setProperty("source-location", "srfi13.scm:422");
    lambda$Fn18 = localModuleMethod3;
    string$Mnunfold$Mnright = new ModuleMethod(localsrfi13, 212, Lit60, -4092);
    string$Mnfor$Mneach = new ModuleMethod(localsrfi13, 213, Lit61, -4094);
    string$Mnfor$Mneach$Mnindex = new ModuleMethod(localsrfi13, 214, Lit62, -4094);
    string$Mnevery = new ModuleMethod(localsrfi13, 215, Lit63, -4094);
    string$Mnany = new ModuleMethod(localsrfi13, 216, Lit64, -4094);
    ModuleMethod localModuleMethod4 = new ModuleMethod(localsrfi13, 217, null, 4097);
    localModuleMethod4.setProperty("source-location", "srfi13.scm:535");
    lambda$Fn27 = localModuleMethod4;
    string$Mntabulate = new ModuleMethod(localsrfi13, 218, Lit65, 8194);
    $Pcstring$Mnprefix$Mnlength = new ModuleMethod(localsrfi13, 219, Lit66, 24582);
    $Pcstring$Mnsuffix$Mnlength = new ModuleMethod(localsrfi13, 220, Lit67, 24582);
    $Pcstring$Mnprefix$Mnlength$Mnci = new ModuleMethod(localsrfi13, 221, Lit68, 24582);
    $Pcstring$Mnsuffix$Mnlength$Mnci = new ModuleMethod(localsrfi13, 222, Lit69, 24582);
    string$Mnprefix$Mnlength = new ModuleMethod(localsrfi13, 223, Lit70, -4094);
    string$Mnsuffix$Mnlength = new ModuleMethod(localsrfi13, 224, Lit71, -4094);
    string$Mnprefix$Mnlength$Mnci = new ModuleMethod(localsrfi13, 225, Lit72, -4094);
    string$Mnsuffix$Mnlength$Mnci = new ModuleMethod(localsrfi13, 226, Lit73, -4094);
    string$Mnprefix$Qu = new ModuleMethod(localsrfi13, 227, Lit74, -4094);
    string$Mnsuffix$Qu = new ModuleMethod(localsrfi13, 228, Lit75, -4094);
    string$Mnprefix$Mnci$Qu = new ModuleMethod(localsrfi13, 229, Lit76, -4094);
    string$Mnsuffix$Mnci$Qu = new ModuleMethod(localsrfi13, 230, Lit77, -4094);
    $Pcstring$Mnprefix$Qu = new ModuleMethod(localsrfi13, 231, Lit78, 24582);
    $Pcstring$Mnsuffix$Qu = new ModuleMethod(localsrfi13, 232, Lit79, 24582);
    $Pcstring$Mnprefix$Mnci$Qu = new ModuleMethod(localsrfi13, 233, Lit80, 24582);
    $Pcstring$Mnsuffix$Mnci$Qu = new ModuleMethod(localsrfi13, 234, Lit81, 24582);
    $Pcstring$Mncompare = new ModuleMethod(localsrfi13, 235, Lit82, 36873);
    $Pcstring$Mncompare$Mnci = new ModuleMethod(localsrfi13, 236, Lit83, 36873);
    string$Mncompare = new ModuleMethod(localsrfi13, 237, Lit84, -4091);
    string$Mncompare$Mnci = new ModuleMethod(localsrfi13, 238, Lit85, -4091);
    ModuleMethod localModuleMethod5 = new ModuleMethod(localsrfi13, 239, null, 4097);
    localModuleMethod5.setProperty("source-location", "srfi13.scm:756");
    lambda$Fn72 = localModuleMethod5;
    ModuleMethod localModuleMethod6 = new ModuleMethod(localsrfi13, 240, null, 4097);
    localModuleMethod6.setProperty("source-location", "srfi13.scm:758");
    lambda$Fn73 = localModuleMethod6;
    string$Eq = new ModuleMethod(localsrfi13, 241, Lit86, -4094);
    ModuleMethod localModuleMethod7 = new ModuleMethod(localsrfi13, 242, null, 4097);
    localModuleMethod7.setProperty("source-location", "srfi13.scm:767");
    lambda$Fn78 = localModuleMethod7;
    string$Ls$Gr = new ModuleMethod(localsrfi13, 243, Lit87, -4094);
    ModuleMethod localModuleMethod8 = new ModuleMethod(localsrfi13, 244, null, 4097);
    localModuleMethod8.setProperty("source-location", "srfi13.scm:778");
    lambda$Fn83 = localModuleMethod8;
    ModuleMethod localModuleMethod9 = new ModuleMethod(localsrfi13, 245, null, 4097);
    localModuleMethod9.setProperty("source-location", "srfi13.scm:779");
    lambda$Fn84 = localModuleMethod9;
    string$Ls = new ModuleMethod(localsrfi13, 246, Lit88, -4094);
    ModuleMethod localModuleMethod10 = new ModuleMethod(localsrfi13, 247, null, 4097);
    localModuleMethod10.setProperty("source-location", "srfi13.scm:788");
    lambda$Fn89 = localModuleMethod10;
    ModuleMethod localModuleMethod11 = new ModuleMethod(localsrfi13, 248, null, 4097);
    localModuleMethod11.setProperty("source-location", "srfi13.scm:789");
    lambda$Fn90 = localModuleMethod11;
    string$Gr = new ModuleMethod(localsrfi13, 249, Lit89, -4094);
    ModuleMethod localModuleMethod12 = new ModuleMethod(localsrfi13, 250, null, 4097);
    localModuleMethod12.setProperty("source-location", "srfi13.scm:801");
    lambda$Fn95 = localModuleMethod12;
    string$Ls$Eq = new ModuleMethod(localsrfi13, 251, Lit90, -4094);
    ModuleMethod localModuleMethod13 = new ModuleMethod(localsrfi13, 252, null, 4097);
    localModuleMethod13.setProperty("source-location", "srfi13.scm:810");
    lambda$Fn100 = localModuleMethod13;
    string$Gr$Eq = new ModuleMethod(localsrfi13, 253, Lit91, -4094);
    ModuleMethod localModuleMethod14 = new ModuleMethod(localsrfi13, 254, null, 4097);
    localModuleMethod14.setProperty("source-location", "srfi13.scm:820");
    lambda$Fn105 = localModuleMethod14;
    ModuleMethod localModuleMethod15 = new ModuleMethod(localsrfi13, 255, null, 4097);
    localModuleMethod15.setProperty("source-location", "srfi13.scm:822");
    lambda$Fn106 = localModuleMethod15;
    string$Mnci$Eq = new ModuleMethod(localsrfi13, 256, Lit92, -4094);
    ModuleMethod localModuleMethod16 = new ModuleMethod(localsrfi13, 257, null, 4097);
    localModuleMethod16.setProperty("source-location", "srfi13.scm:831");
    lambda$Fn111 = localModuleMethod16;
    string$Mnci$Ls$Gr = new ModuleMethod(localsrfi13, 258, Lit93, -4094);
    ModuleMethod localModuleMethod17 = new ModuleMethod(localsrfi13, 259, null, 4097);
    localModuleMethod17.setProperty("source-location", "srfi13.scm:842");
    lambda$Fn116 = localModuleMethod17;
    ModuleMethod localModuleMethod18 = new ModuleMethod(localsrfi13, 260, null, 4097);
    localModuleMethod18.setProperty("source-location", "srfi13.scm:843");
    lambda$Fn117 = localModuleMethod18;
    string$Mnci$Ls = new ModuleMethod(localsrfi13, 261, Lit94, -4094);
    ModuleMethod localModuleMethod19 = new ModuleMethod(localsrfi13, 262, null, 4097);
    localModuleMethod19.setProperty("source-location", "srfi13.scm:852");
    lambda$Fn122 = localModuleMethod19;
    ModuleMethod localModuleMethod20 = new ModuleMethod(localsrfi13, 263, null, 4097);
    localModuleMethod20.setProperty("source-location", "srfi13.scm:853");
    lambda$Fn123 = localModuleMethod20;
    string$Mnci$Gr = new ModuleMethod(localsrfi13, 264, Lit95, -4094);
    ModuleMethod localModuleMethod21 = new ModuleMethod(localsrfi13, 265, null, 4097);
    localModuleMethod21.setProperty("source-location", "srfi13.scm:865");
    lambda$Fn128 = localModuleMethod21;
    string$Mnci$Ls$Eq = new ModuleMethod(localsrfi13, 266, Lit96, -4094);
    ModuleMethod localModuleMethod22 = new ModuleMethod(localsrfi13, 267, null, 4097);
    localModuleMethod22.setProperty("source-location", "srfi13.scm:874");
    lambda$Fn133 = localModuleMethod22;
    string$Mnci$Gr$Eq = new ModuleMethod(localsrfi13, 268, Lit97, -4094);
    $Pcstring$Mnhash = new ModuleMethod(localsrfi13, 269, Lit98, 20485);
    string$Mnhash = new ModuleMethod(localsrfi13, 270, Lit99, -4095);
    ModuleMethod localModuleMethod23 = new ModuleMethod(localsrfi13, 271, null, 4097);
    localModuleMethod23.setProperty("source-location", "srfi13.scm:922");
    lambda$Fn138 = localModuleMethod23;
    string$Mnhash$Mnci = new ModuleMethod(localsrfi13, 272, Lit100, -4095);
    string$Mnupcase = new ModuleMethod(localsrfi13, 273, Lit101, -4095);
    string$Mnupcase$Ex = new ModuleMethod(localsrfi13, 274, Lit102, -4095);
    string$Mndowncase = new ModuleMethod(localsrfi13, 275, Lit103, -4095);
    string$Mndowncase$Ex = new ModuleMethod(localsrfi13, 276, Lit104, -4095);
    $Pcstring$Mntitlecase$Ex = new ModuleMethod(localsrfi13, 277, Lit105, 12291);
    string$Mntitlecase$Ex = new ModuleMethod(localsrfi13, 278, Lit106, -4095);
    string$Mntitlecase = new ModuleMethod(localsrfi13, 279, Lit107, -4095);
    string$Mntake = new ModuleMethod(localsrfi13, 280, Lit108, 8194);
    string$Mntake$Mnright = new ModuleMethod(localsrfi13, 281, Lit109, 8194);
    string$Mndrop = new ModuleMethod(localsrfi13, 282, Lit110, 8194);
    string$Mndrop$Mnright = new ModuleMethod(localsrfi13, 283, Lit111, 8194);
    string$Mntrim = new ModuleMethod(localsrfi13, 284, Lit112, -4095);
    string$Mntrim$Mnright = new ModuleMethod(localsrfi13, 285, Lit113, -4095);
    string$Mntrim$Mnboth = new ModuleMethod(localsrfi13, 286, Lit114, -4095);
    ModuleMethod localModuleMethod24 = new ModuleMethod(localsrfi13, 287, null, 4097);
    localModuleMethod24.setProperty("source-location", "srfi13.scm:1047");
    lambda$Fn163 = localModuleMethod24;
    string$Mnpad$Mnright = new ModuleMethod(localsrfi13, 288, Lit115, -4094);
    ModuleMethod localModuleMethod25 = new ModuleMethod(localsrfi13, 289, null, 4097);
    localModuleMethod25.setProperty("source-location", "srfi13.scm:1059");
    lambda$Fn166 = localModuleMethod25;
    string$Mnpad = new ModuleMethod(localsrfi13, 290, Lit116, -4094);
    string$Mndelete = new ModuleMethod(localsrfi13, 291, Lit117, -4094);
    string$Mnfilter = new ModuleMethod(localsrfi13, 292, Lit118, -4094);
    string$Mnindex = new ModuleMethod(localsrfi13, 293, Lit119, -4094);
    string$Mnindex$Mnright = new ModuleMethod(localsrfi13, 294, Lit120, -4094);
    string$Mnskip = new ModuleMethod(localsrfi13, 295, Lit121, -4094);
    string$Mnskip$Mnright = new ModuleMethod(localsrfi13, 296, Lit122, -4094);
    string$Mncount = new ModuleMethod(localsrfi13, 297, Lit123, -4094);
    string$Mnfill$Ex = new ModuleMethod(localsrfi13, 298, Lit124, -4094);
    string$Mncopy$Ex = new ModuleMethod(localsrfi13, 299, Lit125, 20483);
    $Pcstring$Mncopy$Ex = new ModuleMethod(localsrfi13, 302, Lit126, 20485);
    string$Mncontains = new ModuleMethod(localsrfi13, 303, Lit127, -4094);
    string$Mncontains$Mnci = new ModuleMethod(localsrfi13, 304, Lit128, -4094);
    $Pckmp$Mnsearch = new ModuleMethod(localsrfi13, 305, Lit129, 28679);
    make$Mnkmp$Mnrestart$Mnvector = new ModuleMethod(localsrfi13, 306, Lit130, -4095);
    kmp$Mnstep = new ModuleMethod(localsrfi13, 307, Lit131, 24582);
    string$Mnkmp$Mnpartial$Mnsearch = new ModuleMethod(localsrfi13, 308, Lit132, -4092);
    string$Mnnull$Qu = new ModuleMethod(localsrfi13, 309, Lit133, 4097);
    string$Mnreverse = new ModuleMethod(localsrfi13, 310, Lit134, -4095);
    string$Mnreverse$Ex = new ModuleMethod(localsrfi13, 311, Lit135, -4095);
    reverse$Mnlist$Mn$Grstring = new ModuleMethod(localsrfi13, 312, Lit136, 4097);
    string$Mn$Grlist = new ModuleMethod(localsrfi13, 313, Lit137, -4095);
    string$Mnappend$Slshared = new ModuleMethod(localsrfi13, 314, Lit138, -4096);
    string$Mnconcatenate$Slshared = new ModuleMethod(localsrfi13, 315, Lit139, 4097);
    string$Mnconcatenate = new ModuleMethod(localsrfi13, 316, Lit140, 4097);
    string$Mnconcatenate$Mnreverse = new ModuleMethod(localsrfi13, 317, Lit141, -4095);
    string$Mnconcatenate$Mnreverse$Slshared = new ModuleMethod(localsrfi13, 318, Lit142, -4095);
    $Pcfinish$Mnstring$Mnconcatenate$Mnreverse = new ModuleMethod(localsrfi13, 319, Lit143, 16388);
    string$Mnreplace = new ModuleMethod(localsrfi13, 320, Lit144, -4092);
    string$Mntokenize = new ModuleMethod(localsrfi13, 321, Lit145, -4095);
    ModuleMethod localModuleMethod26 = new ModuleMethod(localsrfi13, 322, null, 4097);
    localModuleMethod26.setProperty("source-location", "srfi13.scm:1738");
    lambda$Fn210 = localModuleMethod26;
    xsubstring = new ModuleMethod(localsrfi13, 323, Lit146, -4094);
    ModuleMethod localModuleMethod27 = new ModuleMethod(localsrfi13, 324, null, 4097);
    localModuleMethod27.setProperty("source-location", "srfi13.scm:1779");
    lambda$Fn216 = localModuleMethod27;
    ModuleMethod localModuleMethod28 = new ModuleMethod(localsrfi13, 325, null, 4097);
    localModuleMethod28.setProperty("source-location", "srfi13.scm:1785");
    lambda$Fn220 = localModuleMethod28;
    string$Mnxcopy$Ex = new ModuleMethod(localsrfi13, 326, Lit147, -4092);
    $Pcmultispan$Mnrepcopy$Ex = new ModuleMethod(localsrfi13, 327, Lit148, 28679);
    string$Mnjoin = new ModuleMethod(localsrfi13, 328, Lit149, -4095);
    $instance.run();
  }
  
  public srfi13()
  {
    ModuleInfo.register(this);
  }
  
  public static Object checkSubstringSpec(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (!isSubstringSpecOk(paramObject2, paramObject3, paramObject4)) {
      return misc.error$V("Illegal substring spec.", new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
    }
    return Values.empty;
  }
  
  public static boolean isStringNull(Object paramObject)
  {
    try
    {
      CharSequence localCharSequence = (CharSequence)paramObject;
      return numbers.isZero(Integer.valueOf(strings.stringLength(localCharSequence)));
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "string-length", 1, paramObject);
    }
  }
  
  public static Object isStringPrefix$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame19 localframe19 = new frame19();
    localframe19.s1 = paramObject1;
    localframe19.s2 = paramObject2;
    localframe19.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe19.lambda$Fn44, localframe19.lambda$Fn45);
  }
  
  public static Object isStringPrefixCi$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame23 localframe23 = new frame23();
    localframe23.s1 = paramObject1;
    localframe23.s2 = paramObject2;
    localframe23.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe23.lambda$Fn52, localframe23.lambda$Fn53);
  }
  
  public static Object isStringSuffix$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame21 localframe21 = new frame21();
    localframe21.s1 = paramObject1;
    localframe21.s2 = paramObject2;
    localframe21.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe21.lambda$Fn48, localframe21.lambda$Fn49);
  }
  
  public static Object isStringSuffixCi$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame25 localframe25 = new frame25();
    localframe25.s1 = paramObject1;
    localframe25.s2 = paramObject2;
    localframe25.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe25.lambda$Fn56, localframe25.lambda$Fn57);
  }
  
  /* Error */
  public static boolean isSubstringSpecOk(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 1744	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   4: istore_3
    //   5: iload_3
    //   6: ifeq +127 -> 133
    //   9: aload_1
    //   10: invokestatic 1747	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +118 -> 133
    //   18: aload_1
    //   19: invokestatic 1750	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   22: istore_3
    //   23: iload_3
    //   24: ifeq +109 -> 133
    //   27: aload_2
    //   28: invokestatic 1747	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   31: istore_3
    //   32: iload_3
    //   33: ifeq +100 -> 133
    //   36: aload_2
    //   37: invokestatic 1750	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   40: istore_3
    //   41: iload_3
    //   42: ifeq +91 -> 133
    //   45: getstatic 444	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   48: getstatic 429	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   51: aload_1
    //   52: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: astore 4
    //   57: aload 4
    //   59: checkcast 437	java/lang/Boolean
    //   62: invokevirtual 448	java/lang/Boolean:booleanValue	()Z
    //   65: istore 6
    //   67: iload 6
    //   69: istore_3
    //   70: iload_3
    //   71: ifeq +62 -> 133
    //   74: getstatic 444	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   77: aload_1
    //   78: aload_2
    //   79: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   82: astore 7
    //   84: aload 7
    //   86: checkcast 437	java/lang/Boolean
    //   89: invokevirtual 448	java/lang/Boolean:booleanValue	()Z
    //   92: istore 9
    //   94: iload 9
    //   96: istore_3
    //   97: iload_3
    //   98: ifeq +35 -> 133
    //   101: getstatic 444	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   104: astore 10
    //   106: aload_0
    //   107: checkcast 386	java/lang/CharSequence
    //   110: astore 12
    //   112: aload 10
    //   114: aload_2
    //   115: aload 12
    //   117: invokestatic 347	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   120: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast 437	java/lang/Boolean
    //   129: invokevirtual 448	java/lang/Boolean:booleanValue	()Z
    //   132: istore_3
    //   133: iload_3
    //   134: ireturn
    //   135: astore 5
    //   137: new 412	gnu/mapping/WrongType
    //   140: dup
    //   141: aload 5
    //   143: ldc_w 483
    //   146: bipush 254
    //   148: aload 4
    //   150: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   153: athrow
    //   154: astore 8
    //   156: new 412	gnu/mapping/WrongType
    //   159: dup
    //   160: aload 8
    //   162: ldc_w 483
    //   165: bipush 254
    //   167: aload 7
    //   169: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   172: athrow
    //   173: astore 11
    //   175: new 412	gnu/mapping/WrongType
    //   178: dup
    //   179: aload 11
    //   181: ldc_w 422
    //   184: iconst_1
    //   185: aload_0
    //   186: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramObject1	Object
    //   0	190	1	paramObject2	Object
    //   0	190	2	paramObject3	Object
    //   4	130	3	bool1	boolean
    //   55	94	4	localObject1	Object
    //   135	7	5	localClassCastException1	ClassCastException
    //   65	3	6	bool2	boolean
    //   82	86	7	localObject2	Object
    //   154	7	8	localClassCastException2	ClassCastException
    //   92	3	9	bool3	boolean
    //   104	9	10	localNumberCompare	NumberCompare
    //   173	7	11	localClassCastException3	ClassCastException
    //   110	6	12	localCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   57	67	135	java/lang/ClassCastException
    //   84	94	154	java/lang/ClassCastException
    //   106	112	173	java/lang/ClassCastException
  }
  
  public static Object kmpStep(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    for (;;)
    {
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      try
      {
        localCharSequence = (CharSequence)paramObject1;
        localObject = AddOp.$Pl.apply2(paramObject4, paramObject6);
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          CharSequence localCharSequence;
          int i = ((Number)localObject).intValue();
          if (localApplyToArgs.apply3(paramObject5, paramObject3, Char.make(strings.stringRef(localCharSequence, i))) != Boolean.FALSE) {
            return AddOp.$Pl.apply2(paramObject4, Lit1);
          }
        }
        catch (ClassCastException localClassCastException2)
        {
          Object localObject;
          FVector localFVector;
          int j;
          throw new WrongType(localClassCastException2, "string-ref", 2, localObject);
        }
        try
        {
          localFVector = (FVector)paramObject2;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "vector-ref", 1, paramObject2);
        }
        try
        {
          j = ((Number)paramObject4).intValue();
          paramObject4 = vectors.vectorRef(localFVector, j);
          if (Scheme.numEqu.apply2(paramObject4, Lit13) == Boolean.FALSE) {
            continue;
          }
          return Lit0;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "vector-ref", 2, paramObject4);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "string-ref", 1, paramObject1);
      }
    }
  }
  
  static String lambda17(Object paramObject)
  {
    return "";
  }
  
  static String lambda18(Object paramObject)
  {
    return "";
  }
  
  public static Object lambda222buildit(Object paramObject1, Object paramObject2)
  {
    frame96 localframe96 = new frame96();
    localframe96.jdField_final = paramObject2;
    return localframe96.lambda223recur(paramObject1);
  }
  
  static boolean lambda27(Object paramObject)
  {
    boolean bool = numbers.isInteger(paramObject);
    if (bool)
    {
      bool = numbers.isExact(paramObject);
      if (bool) {
        bool = ((Boolean)Scheme.numLEq.apply2(Lit0, paramObject)).booleanValue();
      }
    }
    return bool;
  }
  
  public static Object makeKmpRestartVector$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame87 localframe87 = new frame87();
    localframe87.pattern = paramObject;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs1 = Scheme.applyToArgs;
    Location localLocation1 = loc$let$Mnoptionals$St;
    for (;;)
    {
      Object localObject10;
      Object localObject12;
      Object localObject13;
      Object localObject15;
      Object localObject17;
      Object localObject26;
      Object localObject28;
      Object localObject29;
      Object localObject19;
      Object localObject20;
      Object localObject22;
      Object localObject23;
      try
      {
        localObject1 = localLocation1.get();
        localApplyToArgs2 = Scheme.applyToArgs;
        localApplyToArgs3 = Scheme.applyToArgs;
        localLocation2 = loc$c$Eq;
      }
      catch (UnboundLocationException localUnboundLocationException1)
      {
        Object localObject1;
        ApplyToArgs localApplyToArgs2;
        ApplyToArgs localApplyToArgs3;
        Location localLocation2;
        Object localObject2;
        ModuleMethod localModuleMethod;
        Location localLocation3;
        Object localObject3;
        Boolean localBoolean;
        Object localObject4;
        ApplyToArgs localApplyToArgs4;
        ApplyToArgs localApplyToArgs5;
        Location localLocation4;
        Object localObject5;
        Location localLocation5;
        Object localObject6;
        Object localObject7;
        AddOp localAddOp1;
        Location localLocation6;
        Object localObject8;
        Location localLocation7;
        Object localObject9;
        int i;
        FVector localFVector;
        Object localObject11;
        CharSequence localCharSequence1;
        Location localLocation8;
        int j;
        int k;
        Object localObject14;
        Location localLocation9;
        Object localObject16;
        ApplyToArgs localApplyToArgs7;
        Location localLocation12;
        Object localObject27;
        CharSequence localCharSequence4;
        AddOp localAddOp4;
        IntNum localIntNum2;
        int i3;
        int i4;
        AddOp localAddOp5;
        IntNum localIntNum3;
        Object localObject30;
        ApplyToArgs localApplyToArgs6;
        Location localLocation10;
        localUnboundLocationException1.setLine("srfi13.scm", 1397, 3);
        throw localUnboundLocationException1;
      }
      try
      {
        localObject2 = localLocation2.get();
        localModuleMethod = characters.char$Eq$Qu;
        localLocation3 = loc$c$Eq;
      }
      catch (UnboundLocationException localUnboundLocationException2)
      {
        localUnboundLocationException2.setLine("srfi13.scm", 1398, 20);
        throw localUnboundLocationException2;
      }
      try
      {
        localObject3 = localLocation3.get();
        if (misc.isProcedure(localObject3))
        {
          localBoolean = Boolean.TRUE;
          localObject4 = localApplyToArgs3.apply3(localObject2, localModuleMethod, localBoolean);
          localApplyToArgs4 = Scheme.applyToArgs;
          localApplyToArgs5 = Scheme.applyToArgs;
          localLocation4 = loc$start;
        }
      }
      catch (UnboundLocationException localUnboundLocationException3)
      {
        localUnboundLocationException3.setLine("srfi13.scm", 1398, 43);
        throw localUnboundLocationException3;
      }
      try
      {
        localObject5 = localLocation4.get();
        localLocation5 = loc$end;
      }
      catch (UnboundLocationException localUnboundLocationException4)
      {
        localUnboundLocationException4.setLine("srfi13.scm", 1399, 7);
        throw localUnboundLocationException4;
      }
      try
      {
        localObject6 = localLocation5.get();
        localObject7 = localApplyToArgs2.apply2(localObject4, localApplyToArgs4.apply2(localApplyToArgs5.apply2(localObject5, localObject6), localframe87.lambda$Fn197));
        localAddOp1 = AddOp.$Mn;
        localLocation6 = loc$end;
      }
      catch (UnboundLocationException localUnboundLocationException5)
      {
        localUnboundLocationException5.setLine("srfi13.scm", 1399, 14);
        throw localUnboundLocationException5;
      }
      try
      {
        localObject8 = localLocation6.get();
        localLocation7 = loc$start;
      }
      catch (UnboundLocationException localUnboundLocationException6)
      {
        localUnboundLocationException6.setLine("srfi13.scm", 1402, 22);
        throw localUnboundLocationException6;
      }
      try
      {
        localObject9 = localLocation7.get();
        localObject10 = localAddOp1.apply2(localObject8, localObject9);
      }
      catch (UnboundLocationException localUnboundLocationException7)
      {
        localUnboundLocationException7.setLine("srfi13.scm", 1402, 26);
        throw localUnboundLocationException7;
      }
      try
      {
        i = ((Number)localObject10).intValue();
        localFVector = vectors.makeVector(i, Lit13);
        if (Scheme.numGrt.apply2(localObject10, Lit0) != Boolean.FALSE)
        {
          localObject11 = AddOp.$Mn.apply2(localObject10, Lit1);
          localObject12 = localframe87.pattern;
        }
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "make-vector", 1, localObject10);
      }
      try
      {
        localCharSequence1 = (CharSequence)localObject12;
        localLocation8 = loc$start;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-ref", 1, localObject12);
      }
      try
      {
        localObject13 = localLocation8.get();
      }
      catch (UnboundLocationException localUnboundLocationException8)
      {
        localUnboundLocationException8.setLine("srfi13.scm", 1406, 27);
        throw localUnboundLocationException8;
      }
      try
      {
        j = ((Number)localObject13).intValue();
        k = strings.stringRef(localCharSequence1, j);
        localObject14 = Lit0;
        localObject15 = Lit13;
        localLocation9 = loc$start;
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "string-ref", 2, localObject13);
      }
      try
      {
        localObject16 = localLocation9.get();
        localObject17 = localObject16;
        if (Scheme.numLss.apply2(localObject14, localObject11) != Boolean.FALSE) {
          if (Scheme.numEqu.apply2(localObject15, Lit13) != Boolean.FALSE)
          {
            localObject26 = AddOp.$Pl.apply2(Lit1, localObject14);
            localApplyToArgs7 = Scheme.applyToArgs;
            localLocation12 = loc$c$Eq;
          }
        }
      }
      catch (UnboundLocationException localUnboundLocationException9)
      {
        localUnboundLocationException9.setLine("srfi13.scm", 1410, 6);
        throw localUnboundLocationException9;
      }
      try
      {
        localObject27 = localLocation12.get();
        localObject28 = localframe87.pattern;
      }
      catch (UnboundLocationException localUnboundLocationException12)
      {
        localUnboundLocationException12.setLine("srfi13.scm", 1418, 18);
        throw localUnboundLocationException12;
      }
      try
      {
        localCharSequence4 = (CharSequence)localObject28;
        localAddOp4 = AddOp.$Pl;
        localIntNum2 = Lit1;
        localObject29 = localAddOp4.apply2(localObject17, localIntNum2);
      }
      catch (ClassCastException localClassCastException10)
      {
        throw new WrongType(localClassCastException10, "string-ref", 1, localObject28);
      }
      try
      {
        i3 = ((Number)localObject29).intValue();
        if (localApplyToArgs7.apply3(localObject27, Char.make(strings.stringRef(localCharSequence4, i3)), Char.make(k)) != Boolean.FALSE) {}
      }
      catch (ClassCastException localClassCastException11)
      {
        throw new WrongType(localClassCastException11, "string-ref", 2, localObject29);
      }
      try
      {
        i4 = ((Number)localObject26).intValue();
        vectors.vectorSet$Ex(localFVector, i4, Lit0);
        localObject15 = Lit0;
        localAddOp5 = AddOp.$Pl;
        localIntNum3 = Lit1;
        localObject30 = localAddOp5.apply2(localObject17, localIntNum3);
        localObject14 = localObject26;
        localObject17 = localObject30;
      }
      catch (ClassCastException localClassCastException12)
      {
        throw new WrongType(localClassCastException12, "vector-set!", 2, localObject26);
      }
      localBoolean = Boolean.FALSE;
      continue;
      localApplyToArgs6 = Scheme.applyToArgs;
      localLocation10 = loc$c$Eq;
      try
      {
        localObject18 = localLocation10.get();
        localObject19 = localframe87.pattern;
      }
      catch (UnboundLocationException localUnboundLocationException10)
      {
        Object localObject18;
        CharSequence localCharSequence2;
        int m;
        Char localChar;
        CharSequence localCharSequence3;
        AddOp localAddOp2;
        Location localLocation11;
        Object localObject21;
        int n;
        Object localObject24;
        int i2;
        AddOp localAddOp3;
        IntNum localIntNum1;
        Object localObject25;
        int i1;
        localUnboundLocationException10.setLine("srfi13.scm", 1422, 7);
        throw localUnboundLocationException10;
      }
      try
      {
        localCharSequence2 = (CharSequence)localObject19;
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "string-ref", 1, localObject19);
      }
      try
      {
        m = ((Number)localObject17).intValue();
        localChar = Char.make(strings.stringRef(localCharSequence2, m));
        localObject20 = localframe87.pattern;
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "string-ref", 2, localObject17);
      }
      try
      {
        localCharSequence3 = (CharSequence)localObject20;
        localAddOp2 = AddOp.$Pl;
        localLocation11 = loc$start;
      }
      catch (ClassCastException localClassCastException6)
      {
        throw new WrongType(localClassCastException6, "string-ref", 1, localObject20);
      }
      try
      {
        localObject21 = localLocation11.get();
        localObject22 = localAddOp2.apply2(localObject15, localObject21);
      }
      catch (UnboundLocationException localUnboundLocationException11)
      {
        localUnboundLocationException11.setLine("srfi13.scm", 1422, 59);
        throw localUnboundLocationException11;
      }
      try
      {
        n = ((Number)localObject22).intValue();
        if (localApplyToArgs6.apply3(localObject18, localChar, Char.make(strings.stringRef(localCharSequence3, n))) != Boolean.FALSE)
        {
          localObject23 = AddOp.$Pl.apply2(Lit1, localObject14);
          localObject24 = AddOp.$Pl.apply2(Lit1, localObject15);
        }
      }
      catch (ClassCastException localClassCastException7)
      {
        throw new WrongType(localClassCastException7, "string-ref", 2, localObject22);
      }
      try
      {
        i2 = ((Number)localObject23).intValue();
        vectors.vectorSet$Ex(localFVector, i2, localObject24);
        localAddOp3 = AddOp.$Pl;
        localIntNum1 = Lit1;
        localObject25 = localAddOp3.apply2(localObject17, localIntNum1);
        localObject15 = localObject24;
        localObject14 = localObject23;
        localObject17 = localObject25;
      }
      catch (ClassCastException localClassCastException9)
      {
        throw new WrongType(localClassCastException9, "vector-set!", 2, localObject23);
      }
      try
      {
        i1 = ((Number)localObject15).intValue();
        localObject15 = vectors.vectorRef(localFVector, i1);
      }
      catch (ClassCastException localClassCastException8)
      {
        throw new WrongType(localClassCastException8, "vector-ref", 2, localObject15);
      }
    }
    return localApplyToArgs1.apply4(localObject1, localLList, localObject7, localFVector);
  }
  
  /* Error */
  public static CharSequence reverseList$To$String(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 1088	gnu/lists/LList
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 1805	kawa/lib/lists:length	(Lgnu/lists/LList;)I
    //   9: istore_3
    //   10: iload_3
    //   11: invokestatic 384	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   14: astore 4
    //   16: iload_3
    //   17: iconst_1
    //   18: isub
    //   19: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: astore 5
    //   24: aload_0
    //   25: invokestatic 396	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   28: ifeq +141 -> 169
    //   31: aload 4
    //   33: checkcast 531	gnu/lists/CharSeq
    //   36: astore 7
    //   38: aload 5
    //   40: checkcast 376	java/lang/Number
    //   43: invokevirtual 380	java/lang/Number:intValue	()I
    //   46: istore 9
    //   48: getstatic 400	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   51: aload_0
    //   52: invokevirtual 404	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: astore 10
    //   57: aload 10
    //   59: checkcast 458	gnu/text/Char
    //   62: invokevirtual 575	gnu/text/Char:charValue	()C
    //   65: istore 12
    //   67: aload 7
    //   69: iload 9
    //   71: iload 12
    //   73: invokestatic 535	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   76: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   79: aload 5
    //   81: getstatic 468	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   84: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: astore 5
    //   89: getstatic 407	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   92: aload_0
    //   93: invokevirtual 404	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: astore_0
    //   97: goto -73 -> 24
    //   100: astore_1
    //   101: new 412	gnu/mapping/WrongType
    //   104: dup
    //   105: aload_1
    //   106: ldc_w 1806
    //   109: iconst_1
    //   110: aload_0
    //   111: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   114: athrow
    //   115: astore 6
    //   117: new 412	gnu/mapping/WrongType
    //   120: dup
    //   121: aload 6
    //   123: ldc_w 537
    //   126: iconst_1
    //   127: aload 4
    //   129: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   132: athrow
    //   133: astore 8
    //   135: new 412	gnu/mapping/WrongType
    //   138: dup
    //   139: aload 8
    //   141: ldc_w 537
    //   144: iconst_2
    //   145: aload 5
    //   147: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   150: athrow
    //   151: astore 11
    //   153: new 412	gnu/mapping/WrongType
    //   156: dup
    //   157: aload 11
    //   159: ldc_w 537
    //   162: iconst_3
    //   163: aload 10
    //   165: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   168: athrow
    //   169: aload 4
    //   171: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramObject	Object
    //   100	6	1	localClassCastException1	ClassCastException
    //   4	2	2	localLList	LList
    //   9	10	3	i	int
    //   14	156	4	localCharSequence	CharSequence
    //   22	124	5	localObject1	Object
    //   115	7	6	localClassCastException2	ClassCastException
    //   36	32	7	localCharSeq	CharSeq
    //   133	7	8	localClassCastException3	ClassCastException
    //   46	24	9	j	int
    //   55	109	10	localObject2	Object
    //   151	7	11	localClassCastException4	ClassCastException
    //   65	7	12	c	char
    // Exception table:
    //   from	to	target	type
    //   0	5	100	java/lang/ClassCastException
    //   31	38	115	java/lang/ClassCastException
    //   38	48	133	java/lang/ClassCastException
    //   57	67	151	java/lang/ClassCastException
  }
  
  public static Object string$Eq$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame31 localframe31 = new frame31();
    localframe31.s1 = paramObject1;
    localframe31.s2 = paramObject2;
    localframe31.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe31.lambda$Fn68, localframe31.lambda$Fn69);
  }
  
  public static Object string$Gr$Eq$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame41 localframe41 = new frame41();
    localframe41.s1 = paramObject1;
    localframe41.s2 = paramObject2;
    localframe41.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe41.lambda$Fn96, localframe41.lambda$Fn97);
  }
  
  public static Object string$Gr$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame37 localframe37 = new frame37();
    localframe37.s1 = paramObject1;
    localframe37.s2 = paramObject2;
    localframe37.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe37.lambda$Fn85, localframe37.lambda$Fn86);
  }
  
  public static Object string$Ls$Eq$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame39 localframe39 = new frame39();
    localframe39.s1 = paramObject1;
    localframe39.s2 = paramObject2;
    localframe39.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe39.lambda$Fn91, localframe39.lambda$Fn92);
  }
  
  public static Object string$Ls$Gr$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame33 localframe33 = new frame33();
    localframe33.s1 = paramObject1;
    localframe33.s2 = paramObject2;
    localframe33.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe33.lambda$Fn74, localframe33.lambda$Fn75);
  }
  
  public static Object string$Ls$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame35 localframe35 = new frame35();
    localframe35.s1 = paramObject1;
    localframe35.s2 = paramObject2;
    localframe35.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe35.lambda$Fn79, localframe35.lambda$Fn80);
  }
  
  public static Object string$To$List$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame91 localframe91 = new frame91();
    localframe91.s = paramObject;
    localframe91.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe91.lambda$Fn204, localframe91.lambda$Fn205);
  }
  
  public static Object stringAny$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame10 localframe10 = new frame10();
    localframe10.criterion = paramObject1;
    localframe10.s = paramObject2;
    localframe10.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe10.lambda$Fn25, localframe10.lambda$Fn26);
  }
  
  public static Object stringAppend$SlShared$V(Object[] paramArrayOfObject)
  {
    return stringConcatenate$SlShared(LList.makeList(paramArrayOfObject, 0));
  }
  
  public static Object stringCi$Eq$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame43 localframe43 = new frame43();
    localframe43.s1 = paramObject1;
    localframe43.s2 = paramObject2;
    localframe43.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe43.lambda$Fn101, localframe43.lambda$Fn102);
  }
  
  public static Object stringCi$Gr$Eq$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame53 localframe53 = new frame53();
    localframe53.s1 = paramObject1;
    localframe53.s2 = paramObject2;
    localframe53.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe53.lambda$Fn129, localframe53.lambda$Fn130);
  }
  
  public static Object stringCi$Gr$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame49 localframe49 = new frame49();
    localframe49.s1 = paramObject1;
    localframe49.s2 = paramObject2;
    localframe49.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe49.lambda$Fn118, localframe49.lambda$Fn119);
  }
  
  public static Object stringCi$Ls$Eq$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame51 localframe51 = new frame51();
    localframe51.s1 = paramObject1;
    localframe51.s2 = paramObject2;
    localframe51.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe51.lambda$Fn124, localframe51.lambda$Fn125);
  }
  
  public static Object stringCi$Ls$Gr$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame45 localframe45 = new frame45();
    localframe45.s1 = paramObject1;
    localframe45.s2 = paramObject2;
    localframe45.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe45.lambda$Fn107, localframe45.lambda$Fn108);
  }
  
  public static Object stringCi$Ls$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame47 localframe47 = new frame47();
    localframe47.s1 = paramObject1;
    localframe47.s2 = paramObject2;
    localframe47.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe47.lambda$Fn112, localframe47.lambda$Fn113);
  }
  
  /* Error */
  public static Object stringCompare$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 2000	gnu/kawa/slib/srfi13$frame27
    //   3: dup
    //   4: invokespecial 2001	gnu/kawa/slib/srfi13$frame27:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_0
    //   12: putfield 2002	gnu/kawa/slib/srfi13$frame27:s1	Ljava/lang/Object;
    //   15: aload 6
    //   17: aload_1
    //   18: putfield 2003	gnu/kawa/slib/srfi13$frame27:s2	Ljava/lang/Object;
    //   21: aload 6
    //   23: aload_2
    //   24: putfield 2006	gnu/kawa/slib/srfi13$frame27:proc$Ls	Ljava/lang/Object;
    //   27: aload 6
    //   29: aload_3
    //   30: putfield 2009	gnu/kawa/slib/srfi13$frame27:proc$Eq	Ljava/lang/Object;
    //   33: aload 6
    //   35: aload 4
    //   37: putfield 2012	gnu/kawa/slib/srfi13$frame27:proc$Gr	Ljava/lang/Object;
    //   40: aload 6
    //   42: aload 5
    //   44: iconst_0
    //   45: invokestatic 1687	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   48: putfield 2013	gnu/kawa/slib/srfi13$frame27:maybe$Mnstarts$Plends	Lgnu/lists/LList;
    //   51: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   54: astore 7
    //   56: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   59: astore 8
    //   61: aload 8
    //   63: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   66: astore 10
    //   68: aload 7
    //   70: aload 10
    //   72: getstatic 2016	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   75: aload 6
    //   77: getfield 2006	gnu/kawa/slib/srfi13$frame27:proc$Ls	Ljava/lang/Object;
    //   80: getstatic 1431	gnu/kawa/slib/srfi13:string$Mncompare	Lgnu/expr/ModuleMethod;
    //   83: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: pop
    //   87: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   90: astore 12
    //   92: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   95: astore 13
    //   97: aload 13
    //   99: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   102: astore 15
    //   104: aload 12
    //   106: aload 15
    //   108: getstatic 2016	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   111: aload 6
    //   113: getfield 2009	gnu/kawa/slib/srfi13$frame27:proc$Eq	Ljava/lang/Object;
    //   116: getstatic 1431	gnu/kawa/slib/srfi13:string$Mncompare	Lgnu/expr/ModuleMethod;
    //   119: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   122: pop
    //   123: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   126: astore 17
    //   128: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   131: astore 18
    //   133: aload 18
    //   135: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   138: astore 20
    //   140: aload 17
    //   142: aload 20
    //   144: getstatic 2016	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   147: aload 6
    //   149: getfield 2012	gnu/kawa/slib/srfi13$frame27:proc$Gr	Ljava/lang/Object;
    //   152: getstatic 1431	gnu/kawa/slib/srfi13:string$Mncompare	Lgnu/expr/ModuleMethod;
    //   155: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: pop
    //   159: aload 6
    //   161: getfield 2019	gnu/kawa/slib/srfi13$frame27:lambda$Fn60	Lgnu/expr/ModuleMethod;
    //   164: aload 6
    //   166: getfield 2022	gnu/kawa/slib/srfi13$frame27:lambda$Fn61	Lgnu/expr/ModuleMethod;
    //   169: invokestatic 1702	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   172: areturn
    //   173: astore 9
    //   175: aload 9
    //   177: ldc_w 627
    //   180: sipush 726
    //   183: iconst_3
    //   184: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   187: aload 9
    //   189: athrow
    //   190: astore 14
    //   192: aload 14
    //   194: ldc_w 627
    //   197: sipush 727
    //   200: iconst_3
    //   201: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   204: aload 14
    //   206: athrow
    //   207: astore 19
    //   209: aload 19
    //   211: ldc_w 627
    //   214: sipush 728
    //   217: iconst_3
    //   218: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   221: aload 19
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramObject1	Object
    //   0	224	1	paramObject2	Object
    //   0	224	2	paramObject3	Object
    //   0	224	3	paramObject4	Object
    //   0	224	4	paramObject5	Object
    //   0	224	5	paramArrayOfObject	Object[]
    //   7	158	6	localframe27	frame27
    //   54	15	7	localApplyToArgs1	ApplyToArgs
    //   59	3	8	localLocation1	Location
    //   173	15	9	localUnboundLocationException1	UnboundLocationException
    //   66	5	10	localObject1	Object
    //   90	15	12	localApplyToArgs2	ApplyToArgs
    //   95	3	13	localLocation2	Location
    //   190	15	14	localUnboundLocationException2	UnboundLocationException
    //   102	5	15	localObject2	Object
    //   126	15	17	localApplyToArgs3	ApplyToArgs
    //   131	3	18	localLocation3	Location
    //   207	15	19	localUnboundLocationException3	UnboundLocationException
    //   138	5	20	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   61	68	173	gnu/mapping/UnboundLocationException
    //   97	104	190	gnu/mapping/UnboundLocationException
    //   133	140	207	gnu/mapping/UnboundLocationException
  }
  
  /* Error */
  public static Object stringCompareCi$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 2025	gnu/kawa/slib/srfi13$frame29
    //   3: dup
    //   4: invokespecial 2026	gnu/kawa/slib/srfi13$frame29:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_0
    //   12: putfield 2027	gnu/kawa/slib/srfi13$frame29:s1	Ljava/lang/Object;
    //   15: aload 6
    //   17: aload_1
    //   18: putfield 2028	gnu/kawa/slib/srfi13$frame29:s2	Ljava/lang/Object;
    //   21: aload 6
    //   23: aload_2
    //   24: putfield 2029	gnu/kawa/slib/srfi13$frame29:proc$Ls	Ljava/lang/Object;
    //   27: aload 6
    //   29: aload_3
    //   30: putfield 2030	gnu/kawa/slib/srfi13$frame29:proc$Eq	Ljava/lang/Object;
    //   33: aload 6
    //   35: aload 4
    //   37: putfield 2031	gnu/kawa/slib/srfi13$frame29:proc$Gr	Ljava/lang/Object;
    //   40: aload 6
    //   42: aload 5
    //   44: iconst_0
    //   45: invokestatic 1687	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   48: putfield 2032	gnu/kawa/slib/srfi13$frame29:maybe$Mnstarts$Plends	Lgnu/lists/LList;
    //   51: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   54: astore 7
    //   56: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   59: astore 8
    //   61: aload 8
    //   63: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   66: astore 10
    //   68: aload 7
    //   70: aload 10
    //   72: getstatic 2016	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   75: aload 6
    //   77: getfield 2029	gnu/kawa/slib/srfi13$frame29:proc$Ls	Ljava/lang/Object;
    //   80: getstatic 1433	gnu/kawa/slib/srfi13:string$Mncompare$Mnci	Lgnu/expr/ModuleMethod;
    //   83: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: pop
    //   87: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   90: astore 12
    //   92: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   95: astore 13
    //   97: aload 13
    //   99: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   102: astore 15
    //   104: aload 12
    //   106: aload 15
    //   108: getstatic 2016	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   111: aload 6
    //   113: getfield 2030	gnu/kawa/slib/srfi13$frame29:proc$Eq	Ljava/lang/Object;
    //   116: getstatic 1433	gnu/kawa/slib/srfi13:string$Mncompare$Mnci	Lgnu/expr/ModuleMethod;
    //   119: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   122: pop
    //   123: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   126: astore 17
    //   128: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   131: astore 18
    //   133: aload 18
    //   135: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   138: astore 20
    //   140: aload 17
    //   142: aload 20
    //   144: getstatic 2016	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   147: aload 6
    //   149: getfield 2031	gnu/kawa/slib/srfi13$frame29:proc$Gr	Ljava/lang/Object;
    //   152: getstatic 1433	gnu/kawa/slib/srfi13:string$Mncompare$Mnci	Lgnu/expr/ModuleMethod;
    //   155: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: pop
    //   159: aload 6
    //   161: getfield 2035	gnu/kawa/slib/srfi13$frame29:lambda$Fn64	Lgnu/expr/ModuleMethod;
    //   164: aload 6
    //   166: getfield 2038	gnu/kawa/slib/srfi13$frame29:lambda$Fn65	Lgnu/expr/ModuleMethod;
    //   169: invokestatic 1702	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   172: areturn
    //   173: astore 9
    //   175: aload 9
    //   177: ldc_w 627
    //   180: sipush 734
    //   183: iconst_3
    //   184: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   187: aload 9
    //   189: athrow
    //   190: astore 14
    //   192: aload 14
    //   194: ldc_w 627
    //   197: sipush 735
    //   200: iconst_3
    //   201: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   204: aload 14
    //   206: athrow
    //   207: astore 19
    //   209: aload 19
    //   211: ldc_w 627
    //   214: sipush 736
    //   217: iconst_3
    //   218: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   221: aload 19
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramObject1	Object
    //   0	224	1	paramObject2	Object
    //   0	224	2	paramObject3	Object
    //   0	224	3	paramObject4	Object
    //   0	224	4	paramObject5	Object
    //   0	224	5	paramArrayOfObject	Object[]
    //   7	158	6	localframe29	frame29
    //   54	15	7	localApplyToArgs1	ApplyToArgs
    //   59	3	8	localLocation1	Location
    //   173	15	9	localUnboundLocationException1	UnboundLocationException
    //   66	5	10	localObject1	Object
    //   90	15	12	localApplyToArgs2	ApplyToArgs
    //   95	3	13	localLocation2	Location
    //   190	15	14	localUnboundLocationException2	UnboundLocationException
    //   102	5	15	localObject2	Object
    //   126	15	17	localApplyToArgs3	ApplyToArgs
    //   131	3	18	localLocation3	Location
    //   207	15	19	localUnboundLocationException3	UnboundLocationException
    //   138	5	20	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   61	68	173	gnu/mapping/UnboundLocationException
    //   97	104	190	gnu/mapping/UnboundLocationException
    //   133	140	207	gnu/mapping/UnboundLocationException
  }
  
  /* Error */
  public static CharSequence stringConcatenate(Object paramObject)
  {
    // Byte code:
    //   0: getstatic 429	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   3: astore_1
    //   4: aload_0
    //   5: astore_2
    //   6: aload_2
    //   7: invokestatic 396	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   10: ifeq +54 -> 64
    //   13: getstatic 407	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   16: aload_2
    //   17: invokevirtual 404	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: astore 16
    //   22: getstatic 368	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   25: astore 17
    //   27: getstatic 400	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   30: aload_2
    //   31: invokevirtual 404	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   34: astore 18
    //   36: aload 18
    //   38: checkcast 386	java/lang/CharSequence
    //   41: astore 20
    //   43: aload 17
    //   45: aload_1
    //   46: aload 20
    //   48: invokestatic 347	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   51: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   57: astore_1
    //   58: aload 16
    //   60: astore_2
    //   61: goto -55 -> 6
    //   64: aload_1
    //   65: checkcast 376	java/lang/Number
    //   68: invokevirtual 380	java/lang/Number:intValue	()I
    //   71: istore 4
    //   73: iload 4
    //   75: invokestatic 384	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   78: astore 5
    //   80: getstatic 429	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   83: astore 6
    //   85: aload_0
    //   86: invokestatic 396	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   89: ifeq +169 -> 258
    //   92: getstatic 400	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   95: aload_0
    //   96: invokevirtual 404	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   99: astore 7
    //   101: aload 7
    //   103: checkcast 386	java/lang/CharSequence
    //   106: astore 9
    //   108: aload 9
    //   110: invokestatic 347	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   113: istore 10
    //   115: aload 6
    //   117: checkcast 376	java/lang/Number
    //   120: invokevirtual 380	java/lang/Number:intValue	()I
    //   123: istore 12
    //   125: aload 7
    //   127: checkcast 386	java/lang/CharSequence
    //   130: astore 14
    //   132: aload 5
    //   134: iload 12
    //   136: aload 14
    //   138: iconst_0
    //   139: iload 10
    //   141: invokestatic 390	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   144: pop
    //   145: getstatic 368	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   148: aload 6
    //   150: iload 10
    //   152: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: astore 6
    //   160: getstatic 407	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   163: aload_0
    //   164: invokevirtual 404	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   167: astore_0
    //   168: goto -83 -> 85
    //   171: astore 19
    //   173: new 412	gnu/mapping/WrongType
    //   176: dup
    //   177: aload 19
    //   179: ldc_w 422
    //   182: iconst_1
    //   183: aload 18
    //   185: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   188: athrow
    //   189: astore_3
    //   190: new 412	gnu/mapping/WrongType
    //   193: dup
    //   194: aload_3
    //   195: ldc_w 414
    //   198: iconst_1
    //   199: aload_1
    //   200: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   203: athrow
    //   204: astore 8
    //   206: new 412	gnu/mapping/WrongType
    //   209: dup
    //   210: aload 8
    //   212: ldc_w 422
    //   215: iconst_1
    //   216: aload 7
    //   218: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   221: athrow
    //   222: astore 11
    //   224: new 412	gnu/mapping/WrongType
    //   227: dup
    //   228: aload 11
    //   230: ldc_w 420
    //   233: iconst_1
    //   234: aload 6
    //   236: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   239: athrow
    //   240: astore 13
    //   242: new 412	gnu/mapping/WrongType
    //   245: dup
    //   246: aload 13
    //   248: ldc_w 420
    //   251: iconst_2
    //   252: aload 7
    //   254: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   257: athrow
    //   258: aload 5
    //   260: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramObject	Object
    //   3	197	1	localObject1	Object
    //   5	56	2	localObject2	Object
    //   189	6	3	localClassCastException1	ClassCastException
    //   71	3	4	i	int
    //   78	181	5	localCharSequence1	CharSequence
    //   83	152	6	localObject3	Object
    //   99	154	7	localObject4	Object
    //   204	7	8	localClassCastException2	ClassCastException
    //   106	3	9	localCharSequence2	CharSequence
    //   113	38	10	j	int
    //   222	7	11	localClassCastException3	ClassCastException
    //   123	12	12	k	int
    //   240	7	13	localClassCastException4	ClassCastException
    //   130	7	14	localCharSequence3	CharSequence
    //   20	39	16	localObject5	Object
    //   25	19	17	localAddOp	AddOp
    //   34	150	18	localObject6	Object
    //   171	7	19	localClassCastException5	ClassCastException
    //   41	6	20	localCharSequence4	CharSequence
    // Exception table:
    //   from	to	target	type
    //   36	43	171	java/lang/ClassCastException
    //   64	73	189	java/lang/ClassCastException
    //   101	108	204	java/lang/ClassCastException
    //   115	125	222	java/lang/ClassCastException
    //   125	132	240	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringConcatenate$SlShared(Object paramObject)
  {
    // Byte code:
    //   0: getstatic 429	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   3: astore_1
    //   4: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   7: astore_2
    //   8: aload_0
    //   9: invokestatic 396	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   12: ifeq +83 -> 95
    //   15: getstatic 400	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   18: aload_0
    //   19: invokevirtual 404	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: astore 23
    //   24: getstatic 407	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   27: aload_0
    //   28: invokevirtual 404	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: astore 24
    //   33: aload 23
    //   35: checkcast 386	java/lang/CharSequence
    //   38: astore 26
    //   40: aload 26
    //   42: invokestatic 347	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   45: istore 27
    //   47: iload 27
    //   49: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: invokestatic 503	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   55: ifeq +9 -> 64
    //   58: aload 24
    //   60: astore_0
    //   61: goto -53 -> 8
    //   64: getstatic 368	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   67: aload_1
    //   68: iload 27
    //   70: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: astore_1
    //   77: aload_2
    //   78: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   81: if_acmpeq +9 -> 90
    //   84: aload 24
    //   86: astore_0
    //   87: goto -79 -> 8
    //   90: aload_0
    //   91: astore_2
    //   92: goto -8 -> 84
    //   95: aload_1
    //   96: checkcast 376	java/lang/Number
    //   99: astore 4
    //   101: aload 4
    //   103: invokestatic 503	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   106: ifeq +11 -> 117
    //   109: ldc_w 1755
    //   112: astore 11
    //   114: aload 11
    //   116: areturn
    //   117: getstatic 435	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   120: astore 5
    //   122: getstatic 400	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   125: aload_2
    //   126: invokevirtual 404	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   129: astore 6
    //   131: aload 6
    //   133: checkcast 386	java/lang/CharSequence
    //   136: astore 8
    //   138: aload 5
    //   140: aload_1
    //   141: aload 8
    //   143: invokestatic 347	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   146: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   149: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   155: if_acmpeq +11 -> 166
    //   158: getstatic 400	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   161: aload_2
    //   162: invokevirtual 404	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   165: areturn
    //   166: aload_1
    //   167: checkcast 376	java/lang/Number
    //   170: invokevirtual 380	java/lang/Number:intValue	()I
    //   173: istore 10
    //   175: iload 10
    //   177: invokestatic 384	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   180: astore 11
    //   182: getstatic 429	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   185: astore 12
    //   187: aload_2
    //   188: astore 13
    //   190: aload 13
    //   192: invokestatic 396	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   195: ifeq -81 -> 114
    //   198: getstatic 400	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   201: aload 13
    //   203: invokevirtual 404	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   206: astore 14
    //   208: aload 14
    //   210: checkcast 386	java/lang/CharSequence
    //   213: astore 16
    //   215: aload 16
    //   217: invokestatic 347	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   220: istore 17
    //   222: aload 12
    //   224: checkcast 376	java/lang/Number
    //   227: invokevirtual 380	java/lang/Number:intValue	()I
    //   230: istore 19
    //   232: aload 14
    //   234: checkcast 386	java/lang/CharSequence
    //   237: astore 21
    //   239: aload 11
    //   241: iload 19
    //   243: aload 21
    //   245: iconst_0
    //   246: iload 17
    //   248: invokestatic 390	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   251: pop
    //   252: getstatic 407	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   255: aload 13
    //   257: invokevirtual 404	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   260: astore 13
    //   262: getstatic 368	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   265: aload 12
    //   267: iload 17
    //   269: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   275: astore 12
    //   277: goto -87 -> 190
    //   280: astore 25
    //   282: new 412	gnu/mapping/WrongType
    //   285: dup
    //   286: aload 25
    //   288: ldc_w 422
    //   291: iconst_1
    //   292: aload 23
    //   294: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   297: athrow
    //   298: astore_3
    //   299: new 412	gnu/mapping/WrongType
    //   302: dup
    //   303: aload_3
    //   304: ldc_w 505
    //   307: iconst_1
    //   308: aload_1
    //   309: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   312: athrow
    //   313: astore 7
    //   315: new 412	gnu/mapping/WrongType
    //   318: dup
    //   319: aload 7
    //   321: ldc_w 422
    //   324: iconst_1
    //   325: aload 6
    //   327: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   330: athrow
    //   331: astore 9
    //   333: new 412	gnu/mapping/WrongType
    //   336: dup
    //   337: aload 9
    //   339: ldc_w 414
    //   342: iconst_1
    //   343: aload_1
    //   344: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   347: athrow
    //   348: astore 15
    //   350: new 412	gnu/mapping/WrongType
    //   353: dup
    //   354: aload 15
    //   356: ldc_w 422
    //   359: iconst_1
    //   360: aload 14
    //   362: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   365: athrow
    //   366: astore 18
    //   368: new 412	gnu/mapping/WrongType
    //   371: dup
    //   372: aload 18
    //   374: ldc_w 420
    //   377: iconst_1
    //   378: aload 12
    //   380: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   383: athrow
    //   384: astore 20
    //   386: new 412	gnu/mapping/WrongType
    //   389: dup
    //   390: aload 20
    //   392: ldc_w 420
    //   395: iconst_2
    //   396: aload 14
    //   398: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   401: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	paramObject	Object
    //   3	341	1	localObject1	Object
    //   7	181	2	localObject2	Object
    //   298	6	3	localClassCastException1	ClassCastException
    //   99	3	4	localNumber	Number
    //   120	19	5	localNumberCompare	NumberCompare
    //   129	197	6	localObject3	Object
    //   313	7	7	localClassCastException2	ClassCastException
    //   136	6	8	localCharSequence1	CharSequence
    //   331	7	9	localClassCastException3	ClassCastException
    //   173	3	10	i	int
    //   112	128	11	localObject4	Object
    //   185	194	12	localObject5	Object
    //   188	73	13	localObject6	Object
    //   206	191	14	localObject7	Object
    //   348	7	15	localClassCastException4	ClassCastException
    //   213	3	16	localCharSequence2	CharSequence
    //   220	48	17	j	int
    //   366	7	18	localClassCastException5	ClassCastException
    //   230	12	19	k	int
    //   384	7	20	localClassCastException6	ClassCastException
    //   237	7	21	localCharSequence3	CharSequence
    //   22	271	23	localObject8	Object
    //   31	54	24	localObject9	Object
    //   280	7	25	localClassCastException7	ClassCastException
    //   38	3	26	localCharSequence4	CharSequence
    //   45	24	27	m	int
    // Exception table:
    //   from	to	target	type
    //   33	40	280	java/lang/ClassCastException
    //   95	101	298	java/lang/ClassCastException
    //   131	138	313	java/lang/ClassCastException
    //   166	175	331	java/lang/ClassCastException
    //   208	215	348	java/lang/ClassCastException
    //   222	232	366	java/lang/ClassCastException
    //   232	239	384	java/lang/ClassCastException
  }
  
  public static Object stringConcatenateReverse$SlShared$V(Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs1 = Scheme.applyToArgs;
    Location localLocation1 = loc$let$Mnoptionals$St;
    for (;;)
    {
      try
      {
        localObject1 = localLocation1.get();
        localApplyToArgs2 = Scheme.applyToArgs;
        localApplyToArgs3 = Scheme.applyToArgs;
        localLocation2 = loc$final;
      }
      catch (UnboundLocationException localUnboundLocationException1)
      {
        try
        {
          Object localObject1;
          ApplyToArgs localApplyToArgs2;
          ApplyToArgs localApplyToArgs3;
          Location localLocation2;
          Object localObject2;
          Location localLocation3;
          Object localObject3;
          Boolean localBoolean;
          Object localObject4;
          ApplyToArgs localApplyToArgs4;
          Location localLocation4;
          Object localObject5;
          Location localLocation5;
          CharSequence localCharSequence1;
          Integer localInteger;
          Location localLocation6;
          Object localObject7;
          boolean bool1;
          Location localLocation12;
          Object localObject20;
          boolean bool3;
          NumberCompare localNumberCompare2;
          IntNum localIntNum2;
          Location localLocation13;
          Object localObject21;
          Location localLocation14;
          CharSequence localCharSequence4;
          Object localObject8;
          Object localObject9;
          CharSequence localCharSequence3;
          int i;
          Number localNumber1;
          Location localLocation10;
          Object localObject17;
          IntNum localIntNum1;
          Object[] arrayOfObject;
          Location localLocation11;
          Object localObject18;
          Location localLocation7;
          localObject12 = localLocation7.get();
        }
        catch (UnboundLocationException localUnboundLocationException7)
        {
          Object localObject6;
          Object localObject22;
          Object localObject10;
          Object localObject11;
          Object localObject19;
          Object localObject15;
          Number localNumber2;
          boolean bool2;
          NumberCompare localNumberCompare1;
          CharSequence localCharSequence2;
          Location localLocation8;
          Object localObject13;
          Location localLocation9;
          Object localObject14;
          localUnboundLocationException7.setLine("srfi13.scm", 1649, 16);
          throw localUnboundLocationException7;
        }
        try
        {
          localNumber2 = (Number)localObject12;
          bool2 = numbers.isZero(localNumber2);
          if (bool2)
          {
            localNumberCompare1 = Scheme.numEqu;
            localObject16 = lists.car.apply1(localObject11);
          }
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "zero?", 1, localObject12);
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject16;
          if (localNumberCompare1.apply2(localObject10, Integer.valueOf(strings.stringLength(localCharSequence2))) != Boolean.FALSE)
          {
            localObject15 = lists.car.apply1(localObject11);
            continue;
            if (bool2) {
              continue;
            }
          }
          localLocation8 = loc$final;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "string-length", 1, localObject16);
        }
        try
        {
          localObject13 = localLocation8.get();
          localLocation9 = loc$end;
        }
        catch (UnboundLocationException localUnboundLocationException8)
        {
          localUnboundLocationException8.setLine("srfi13.scm", 1652, 56);
          throw localUnboundLocationException8;
        }
        try
        {
          localObject14 = localLocation9.get();
          localObject15 = $PcFinishStringConcatenateReverse(localObject10, localObject11, localObject13, localObject14);
        }
        catch (UnboundLocationException localUnboundLocationException9)
        {
          localUnboundLocationException9.setLine("srfi13.scm", 1652, 62);
          throw localUnboundLocationException9;
        }
        localUnboundLocationException1 = localUnboundLocationException1;
        localUnboundLocationException1.setLine("srfi13.scm", 1630, 3);
        throw localUnboundLocationException1;
      }
      try
      {
        localObject2 = localLocation2.get();
        localLocation3 = loc$final;
      }
      catch (UnboundLocationException localUnboundLocationException2)
      {
        localUnboundLocationException2.setLine("srfi13.scm", 1630, 36);
        throw localUnboundLocationException2;
      }
      try
      {
        localObject3 = localLocation3.get();
        if (strings.isString(localObject3))
        {
          localBoolean = Boolean.TRUE;
          localObject4 = localApplyToArgs3.apply3(localObject2, "", localBoolean);
          localApplyToArgs4 = Scheme.applyToArgs;
          localLocation4 = loc$end;
        }
      }
      catch (UnboundLocationException localUnboundLocationException3)
      {
        localUnboundLocationException3.setLine("srfi13.scm", 1630, 55);
        throw localUnboundLocationException3;
      }
      try
      {
        localObject5 = localLocation4.get();
        localLocation5 = loc$final;
      }
      catch (UnboundLocationException localUnboundLocationException4)
      {
        localUnboundLocationException4.setLine("srfi13.scm", 1631, 8);
        throw localUnboundLocationException4;
      }
      try
      {
        localObject6 = localLocation5.get();
      }
      catch (UnboundLocationException localUnboundLocationException5)
      {
        localUnboundLocationException5.setLine("srfi13.scm", 1631, 28);
        throw localUnboundLocationException5;
      }
      try
      {
        localCharSequence1 = (CharSequence)localObject6;
        localInteger = Integer.valueOf(strings.stringLength(localCharSequence1));
        localLocation6 = loc$end;
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "string-length", 1, localObject6);
      }
      try
      {
        localObject7 = localLocation6.get();
        bool1 = numbers.isInteger(localObject7);
        if (bool1) {
          localLocation12 = loc$end;
        }
      }
      catch (UnboundLocationException localUnboundLocationException6)
      {
        localUnboundLocationException6.setLine("srfi13.scm", 1632, 21);
        throw localUnboundLocationException6;
      }
      try
      {
        localObject20 = localLocation12.get();
        bool3 = numbers.isExact(localObject20);
        if (bool3)
        {
          localNumberCompare2 = Scheme.numLEq;
          localIntNum2 = Lit0;
          localLocation13 = loc$end;
        }
      }
      catch (UnboundLocationException localUnboundLocationException12)
      {
        localUnboundLocationException12.setLine("srfi13.scm", 1633, 19);
        throw localUnboundLocationException12;
      }
      try
      {
        localObject21 = localLocation13.get();
        localLocation14 = loc$final;
      }
      catch (UnboundLocationException localUnboundLocationException13)
      {
        localUnboundLocationException13.setLine("srfi13.scm", 1634, 17);
        throw localUnboundLocationException13;
      }
      try
      {
        localObject22 = localLocation14.get();
      }
      catch (UnboundLocationException localUnboundLocationException14)
      {
        localUnboundLocationException14.setLine("srfi13.scm", 1634, 36);
        throw localUnboundLocationException14;
      }
      try
      {
        localCharSequence4 = (CharSequence)localObject22;
        localObject8 = localNumberCompare2.apply3(localIntNum2, localObject21, Integer.valueOf(strings.stringLength(localCharSequence4)));
        localObject9 = localApplyToArgs2.apply2(localObject4, localApplyToArgs4.apply3(localObject5, localInteger, localObject8));
        localObject10 = Lit0;
        localObject11 = Boolean.FALSE;
        if (lists.isPair(paramObject)) {
          localObject19 = lists.car.apply1(paramObject);
        }
      }
      catch (ClassCastException localClassCastException6)
      {
        throw new WrongType(localClassCastException6, "string-length", 1, localObject22);
      }
      try
      {
        localCharSequence3 = (CharSequence)localObject19;
        i = strings.stringLength(localCharSequence3);
        localObject10 = AddOp.$Pl.apply2(localObject10, Integer.valueOf(i));
        if ((localObject11 != Boolean.FALSE) || (numbers.isZero(Integer.valueOf(i))))
        {
          paramObject = lists.cdr.apply1(paramObject);
          continue;
          localBoolean = Boolean.FALSE;
          continue;
          if (bool3)
          {
            localObject8 = Boolean.TRUE;
          }
          else
          {
            localObject8 = Boolean.FALSE;
            continue;
            if (bool1) {
              localObject8 = Boolean.TRUE;
            } else {
              localObject8 = Boolean.FALSE;
            }
          }
        }
        else
        {
          localObject11 = paramObject;
        }
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "string-length", 1, localObject19);
      }
    }
    try
    {
      localNumber1 = (Number)localObject10;
      if (numbers.isZero(localNumber1)) {
        localLocation10 = loc$final;
      }
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "zero?", 1, localObject10);
    }
    try
    {
      localObject17 = localLocation10.get();
      localIntNum1 = Lit0;
      arrayOfObject = new Object[1];
      localLocation11 = loc$end;
    }
    catch (UnboundLocationException localUnboundLocationException10)
    {
      localUnboundLocationException10.setLine("srfi13.scm", 1645, 41);
      throw localUnboundLocationException10;
    }
    try
    {
      localObject18 = localLocation11.get();
      arrayOfObject[0] = localObject18;
      localObject15 = substring$SlShared$V(localObject17, localIntNum1, arrayOfObject);
      return localApplyToArgs1.apply4(localObject1, localLList, localObject9, localObject15);
    }
    catch (UnboundLocationException localUnboundLocationException11)
    {
      localUnboundLocationException11.setLine("srfi13.scm", 1645, 49);
      throw localUnboundLocationException11;
    }
    localLocation7 = loc$end;
  }
  
  public static Object stringConcatenateReverse$V(Object paramObject, Object[] paramArrayOfObject)
  {
    localLList = LList.makeList(paramArrayOfObject, 0);
    localApplyToArgs1 = Scheme.applyToArgs;
    Location localLocation1 = loc$let$Mnoptionals$St;
    for (;;)
    {
      try
      {
        localObject1 = localLocation1.get();
        localApplyToArgs2 = Scheme.applyToArgs;
        localApplyToArgs3 = Scheme.applyToArgs;
        localLocation2 = loc$final;
      }
      catch (UnboundLocationException localUnboundLocationException1)
      {
        try
        {
          ApplyToArgs localApplyToArgs2;
          ApplyToArgs localApplyToArgs3;
          Location localLocation2;
          Object localObject2;
          Location localLocation3;
          Object localObject3;
          Boolean localBoolean;
          Object localObject4;
          ApplyToArgs localApplyToArgs4;
          Location localLocation4;
          Object localObject5;
          Location localLocation5;
          CharSequence localCharSequence1;
          Integer localInteger;
          Location localLocation6;
          Object localObject7;
          boolean bool1;
          Location localLocation9;
          Object localObject16;
          boolean bool2;
          NumberCompare localNumberCompare;
          IntNum localIntNum2;
          Location localLocation10;
          Object localObject17;
          Location localLocation11;
          CharSequence localCharSequence3;
          Object localObject8;
          IntNum localIntNum1;
          Object localObject10;
          AddOp localAddOp;
          CharSequence localCharSequence2;
          Object localObject15;
          Location localLocation7;
          localObject12 = localLocation7.get();
          localLocation8 = loc$end;
        }
        catch (UnboundLocationException localUnboundLocationException7)
        {
          Object localObject1;
          Object localObject6;
          Object localObject18;
          Object localObject9;
          Object localObject11;
          Object localObject14;
          Object localObject12;
          Location localLocation8;
          Object localObject13;
          localUnboundLocationException7.setLine("srfi13.scm", 1627, 59);
          throw localUnboundLocationException7;
        }
        try
        {
          localObject13 = localLocation8.get();
          return localApplyToArgs1.apply4(localObject1, localLList, localObject9, $PcFinishStringConcatenateReverse(localObject11, paramObject, localObject12, localObject13));
        }
        catch (UnboundLocationException localUnboundLocationException8)
        {
          localUnboundLocationException8.setLine("srfi13.scm", 1627, 65);
          throw localUnboundLocationException8;
        }
        localUnboundLocationException1 = localUnboundLocationException1;
        localUnboundLocationException1.setLine("srfi13.scm", 1617, 3);
        throw localUnboundLocationException1;
      }
      try
      {
        localObject2 = localLocation2.get();
        localLocation3 = loc$final;
      }
      catch (UnboundLocationException localUnboundLocationException2)
      {
        localUnboundLocationException2.setLine("srfi13.scm", 1617, 36);
        throw localUnboundLocationException2;
      }
      try
      {
        localObject3 = localLocation3.get();
        if (strings.isString(localObject3))
        {
          localBoolean = Boolean.TRUE;
          localObject4 = localApplyToArgs3.apply3(localObject2, "", localBoolean);
          localApplyToArgs4 = Scheme.applyToArgs;
          localLocation4 = loc$end;
        }
      }
      catch (UnboundLocationException localUnboundLocationException3)
      {
        localUnboundLocationException3.setLine("srfi13.scm", 1617, 55);
        throw localUnboundLocationException3;
      }
      try
      {
        localObject5 = localLocation4.get();
        localLocation5 = loc$final;
      }
      catch (UnboundLocationException localUnboundLocationException4)
      {
        localUnboundLocationException4.setLine("srfi13.scm", 1618, 8);
        throw localUnboundLocationException4;
      }
      try
      {
        localObject6 = localLocation5.get();
      }
      catch (UnboundLocationException localUnboundLocationException5)
      {
        localUnboundLocationException5.setLine("srfi13.scm", 1618, 28);
        throw localUnboundLocationException5;
      }
      try
      {
        localCharSequence1 = (CharSequence)localObject6;
        localInteger = Integer.valueOf(strings.stringLength(localCharSequence1));
        localLocation6 = loc$end;
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "string-length", 1, localObject6);
      }
      try
      {
        localObject7 = localLocation6.get();
        bool1 = numbers.isInteger(localObject7);
        if (bool1) {
          localLocation9 = loc$end;
        }
      }
      catch (UnboundLocationException localUnboundLocationException6)
      {
        localUnboundLocationException6.setLine("srfi13.scm", 1619, 21);
        throw localUnboundLocationException6;
      }
      try
      {
        localObject16 = localLocation9.get();
        bool2 = numbers.isExact(localObject16);
        if (bool2)
        {
          localNumberCompare = Scheme.numLEq;
          localIntNum2 = Lit0;
          localLocation10 = loc$end;
        }
      }
      catch (UnboundLocationException localUnboundLocationException9)
      {
        localUnboundLocationException9.setLine("srfi13.scm", 1620, 19);
        throw localUnboundLocationException9;
      }
      try
      {
        localObject17 = localLocation10.get();
        localLocation11 = loc$final;
      }
      catch (UnboundLocationException localUnboundLocationException10)
      {
        localUnboundLocationException10.setLine("srfi13.scm", 1621, 17);
        throw localUnboundLocationException10;
      }
      try
      {
        localObject18 = localLocation11.get();
      }
      catch (UnboundLocationException localUnboundLocationException11)
      {
        localUnboundLocationException11.setLine("srfi13.scm", 1621, 36);
        throw localUnboundLocationException11;
      }
      try
      {
        localCharSequence3 = (CharSequence)localObject18;
        localObject8 = localNumberCompare.apply3(localIntNum2, localObject17, Integer.valueOf(strings.stringLength(localCharSequence3)));
        localObject9 = localApplyToArgs2.apply2(localObject4, localApplyToArgs4.apply3(localObject5, localInteger, localObject8));
        localIntNum1 = Lit0;
        localObject10 = paramObject;
        localObject11 = localIntNum1;
        if (lists.isPair(localObject10))
        {
          localAddOp = AddOp.$Pl;
          localObject14 = lists.car.apply1(localObject10);
        }
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "string-length", 1, localObject18);
      }
      try
      {
        localCharSequence2 = (CharSequence)localObject14;
        localObject15 = localAddOp.apply2(localObject11, Integer.valueOf(strings.stringLength(localCharSequence2)));
        localObject10 = lists.cdr.apply1(localObject10);
        localObject11 = localObject15;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-length", 1, localObject14);
      }
      localBoolean = Boolean.FALSE;
      continue;
      if (bool2)
      {
        localObject8 = Boolean.TRUE;
      }
      else
      {
        localObject8 = Boolean.FALSE;
        continue;
        if (bool1) {
          localObject8 = Boolean.TRUE;
        } else {
          localObject8 = Boolean.FALSE;
        }
      }
    }
    localLocation7 = loc$final;
  }
  
  public static Object stringContains$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame83 localframe83 = new frame83();
    localframe83.text = paramObject1;
    localframe83.pattern = paramObject2;
    localframe83.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe83.lambda$Fn189, localframe83.lambda$Fn190);
  }
  
  public static Object stringContainsCi$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame85 localframe85 = new frame85();
    localframe85.text = paramObject1;
    localframe85.pattern = paramObject2;
    localframe85.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe85.lambda$Fn193, localframe85.lambda$Fn194);
  }
  
  public static Object stringCopy$Ex(Object paramObject, int paramInt, CharSequence paramCharSequence)
  {
    return stringCopy$Ex(paramObject, paramInt, paramCharSequence, 0);
  }
  
  public static Object stringCopy$Ex(Object paramObject, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    return stringCopy$Ex(paramObject, paramInt1, paramCharSequence, paramInt2, paramCharSequence.length());
  }
  
  /* Error */
  public static Object stringCopy$Ex(Object paramObject, int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: getstatic 1597	gnu/kawa/slib/srfi13:string$Mncopy$Ex	Lgnu/expr/ModuleMethod;
    //   3: aload_2
    //   4: iload_3
    //   5: iload 4
    //   7: invokestatic 2086	gnu/kawa/slib/srfi13:$PcCheckBounds	(Ljava/lang/Object;Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   10: pop
    //   11: getstatic 1597	gnu/kawa/slib/srfi13:string$Mncopy$Ex	Lgnu/expr/ModuleMethod;
    //   14: astore 6
    //   16: aload_0
    //   17: checkcast 386	java/lang/CharSequence
    //   20: astore 8
    //   22: aload 6
    //   24: aload 8
    //   26: iload_1
    //   27: iload_1
    //   28: iload 4
    //   30: iload_3
    //   31: isub
    //   32: iadd
    //   33: invokestatic 2088	gnu/kawa/slib/srfi13:$PcCheckSubstringSpec	(Ljava/lang/Object;Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   36: pop
    //   37: aload_0
    //   38: checkcast 386	java/lang/CharSequence
    //   41: astore 11
    //   43: aload 11
    //   45: iload_1
    //   46: aload_2
    //   47: iload_3
    //   48: iload 4
    //   50: invokestatic 390	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   53: areturn
    //   54: astore 7
    //   56: new 412	gnu/mapping/WrongType
    //   59: dup
    //   60: aload 7
    //   62: ldc_w 2090
    //   65: iconst_1
    //   66: aload_0
    //   67: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   70: athrow
    //   71: astore 10
    //   73: new 412	gnu/mapping/WrongType
    //   76: dup
    //   77: aload 10
    //   79: ldc_w 420
    //   82: iconst_0
    //   83: aload_0
    //   84: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramObject	Object
    //   0	88	1	paramInt1	int
    //   0	88	2	paramCharSequence	CharSequence
    //   0	88	3	paramInt2	int
    //   0	88	4	paramInt3	int
    //   14	9	6	localModuleMethod	ModuleMethod
    //   54	7	7	localClassCastException1	ClassCastException
    //   20	5	8	localCharSequence1	CharSequence
    //   71	7	10	localClassCastException2	ClassCastException
    //   41	3	11	localCharSequence2	CharSequence
    // Exception table:
    //   from	to	target	type
    //   16	22	54	java/lang/ClassCastException
    //   37	43	71	java/lang/ClassCastException
  }
  
  public static Object stringCopy$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame2 localframe2 = new frame2();
    localframe2.s = paramObject;
    localframe2.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe2.lambda$Fn7, localframe2.lambda$Fn8);
  }
  
  public static Object stringCount$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame81 localframe81 = new frame81();
    localframe81.s = paramObject1;
    localframe81.criterion = paramObject2;
    localframe81.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe81.lambda$Fn185, localframe81.lambda$Fn186);
  }
  
  public static Object stringDelete$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame73 localframe73 = new frame73();
    localframe73.criterion = paramObject1;
    localframe73.s = paramObject2;
    localframe73.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe73.lambda$Fn167, localframe73.lambda$Fn168);
  }
  
  public static Object stringDowncase$Ex$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame61 localframe61 = new frame61();
    localframe61.s = paramObject;
    localframe61.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe61.lambda$Fn145, localframe61.lambda$Fn146);
  }
  
  public static Object stringDowncase$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame60 localframe60 = new frame60();
    localframe60.s = paramObject;
    localframe60.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe60.lambda$Fn143, localframe60.lambda$Fn144);
  }
  
  /* Error */
  public static Object stringDrop(CharSequence paramCharSequence, Object paramObject)
  {
    // Byte code:
    //   0: new 2155	gnu/kawa/slib/srfi13$frame66
    //   3: dup
    //   4: invokespecial 2156	gnu/kawa/slib/srfi13$frame66:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_1
    //   10: putfield 2159	gnu/kawa/slib/srfi13$frame66:n	Ljava/lang/Object;
    //   13: aload_2
    //   14: aload_0
    //   15: invokestatic 347	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   18: putfield 2163	gnu/kawa/slib/srfi13$frame66:len	I
    //   21: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   24: astore_3
    //   25: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   28: astore 4
    //   30: aload 4
    //   32: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   35: astore 6
    //   37: aload_3
    //   38: aload 6
    //   40: aload_2
    //   41: getfield 2166	gnu/kawa/slib/srfi13$frame66:lambda$Fn153	Lgnu/expr/ModuleMethod;
    //   44: aload_2
    //   45: getfield 2159	gnu/kawa/slib/srfi13$frame66:n	Ljava/lang/Object;
    //   48: getstatic 1559	gnu/kawa/slib/srfi13:string$Mndrop	Lgnu/expr/ModuleMethod;
    //   51: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload_2
    //   56: getfield 2159	gnu/kawa/slib/srfi13$frame66:n	Ljava/lang/Object;
    //   59: astore 8
    //   61: aload 8
    //   63: checkcast 376	java/lang/Number
    //   66: invokevirtual 380	java/lang/Number:intValue	()I
    //   69: istore 10
    //   71: aload_0
    //   72: iload 10
    //   74: aload_2
    //   75: getfield 2163	gnu/kawa/slib/srfi13$frame66:len	I
    //   78: invokestatic 2168	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   81: areturn
    //   82: astore 5
    //   84: aload 5
    //   86: ldc_w 627
    //   89: sipush 1010
    //   92: iconst_5
    //   93: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   96: aload 5
    //   98: athrow
    //   99: astore 9
    //   101: new 412	gnu/mapping/WrongType
    //   104: dup
    //   105: aload 9
    //   107: ldc_w 1037
    //   110: iconst_1
    //   111: aload 8
    //   113: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramCharSequence	CharSequence
    //   0	117	1	paramObject	Object
    //   7	68	2	localframe66	frame66
    //   24	14	3	localApplyToArgs	ApplyToArgs
    //   28	3	4	localLocation	Location
    //   82	15	5	localUnboundLocationException	UnboundLocationException
    //   35	4	6	localObject1	Object
    //   59	53	8	localObject2	Object
    //   99	7	9	localClassCastException	ClassCastException
    //   69	4	10	i	int
    // Exception table:
    //   from	to	target	type
    //   30	37	82	gnu/mapping/UnboundLocationException
    //   61	71	99	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringDropRight(CharSequence paramCharSequence, Object paramObject)
  {
    // Byte code:
    //   0: new 2171	gnu/kawa/slib/srfi13$frame67
    //   3: dup
    //   4: invokespecial 2172	gnu/kawa/slib/srfi13$frame67:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_1
    //   10: putfield 2173	gnu/kawa/slib/srfi13$frame67:n	Ljava/lang/Object;
    //   13: aload_2
    //   14: aload_0
    //   15: invokestatic 347	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   18: putfield 2174	gnu/kawa/slib/srfi13$frame67:len	I
    //   21: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   24: astore_3
    //   25: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   28: astore 4
    //   30: aload 4
    //   32: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   35: astore 6
    //   37: aload_3
    //   38: aload 6
    //   40: aload_2
    //   41: getfield 2177	gnu/kawa/slib/srfi13$frame67:lambda$Fn154	Lgnu/expr/ModuleMethod;
    //   44: aload_2
    //   45: getfield 2173	gnu/kawa/slib/srfi13$frame67:n	Ljava/lang/Object;
    //   48: getstatic 1561	gnu/kawa/slib/srfi13:string$Mndrop$Mnright	Lgnu/expr/ModuleMethod;
    //   51: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   58: aload_2
    //   59: getfield 2174	gnu/kawa/slib/srfi13$frame67:len	I
    //   62: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aload_2
    //   66: getfield 2173	gnu/kawa/slib/srfi13$frame67:n	Ljava/lang/Object;
    //   69: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   72: astore 8
    //   74: aload 8
    //   76: checkcast 376	java/lang/Number
    //   79: invokevirtual 380	java/lang/Number:intValue	()I
    //   82: istore 10
    //   84: aload_0
    //   85: iconst_0
    //   86: iload 10
    //   88: invokestatic 2168	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   91: areturn
    //   92: astore 5
    //   94: aload 5
    //   96: ldc_w 627
    //   99: sipush 1016
    //   102: iconst_5
    //   103: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   106: aload 5
    //   108: athrow
    //   109: astore 9
    //   111: new 412	gnu/mapping/WrongType
    //   114: dup
    //   115: aload 9
    //   117: ldc_w 1037
    //   120: iconst_2
    //   121: aload 8
    //   123: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramCharSequence	CharSequence
    //   0	127	1	paramObject	Object
    //   7	59	2	localframe67	frame67
    //   24	14	3	localApplyToArgs	ApplyToArgs
    //   28	3	4	localLocation	Location
    //   92	15	5	localUnboundLocationException	UnboundLocationException
    //   35	4	6	localObject1	Object
    //   72	50	8	localObject2	Object
    //   109	7	9	localClassCastException	ClassCastException
    //   82	5	10	i	int
    // Exception table:
    //   from	to	target	type
    //   30	37	92	gnu/mapping/UnboundLocationException
    //   74	84	109	java/lang/ClassCastException
  }
  
  public static Object stringEvery$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame9 localframe9 = new frame9();
    localframe9.criterion = paramObject1;
    localframe9.s = paramObject2;
    localframe9.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe9.lambda$Fn23, localframe9.lambda$Fn24);
  }
  
  public static Object stringFill$Ex$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame82 localframe82 = new frame82();
    localframe82.s = paramObject1;
    localframe82.jdField_char = paramObject2;
    localframe82.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    Location localLocation = loc$check$Mnarg;
    try
    {
      Object localObject = localLocation.get();
      localApplyToArgs.apply4(localObject, characters.char$Qu, localframe82.jdField_char, string$Mnfill$Ex);
      return call_with_values.callWithValues(localframe82.lambda$Fn187, localframe82.lambda$Fn188);
    }
    catch (UnboundLocationException localUnboundLocationException)
    {
      localUnboundLocationException.setLine("srfi13.scm", 1270, 3);
      throw localUnboundLocationException;
    }
  }
  
  public static Object stringFilter$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame75 localframe75 = new frame75();
    localframe75.criterion = paramObject1;
    localframe75.s = paramObject2;
    localframe75.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe75.lambda$Fn172, localframe75.lambda$Fn173);
  }
  
  public static Object stringFold$V(Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
  {
    frame5 localframe5 = new frame5();
    localframe5.kons = paramObject1;
    localframe5.knil = paramObject2;
    localframe5.s = paramObject3;
    localframe5.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    Location localLocation = loc$check$Mnarg;
    try
    {
      Object localObject = localLocation.get();
      localApplyToArgs.apply4(localObject, misc.procedure$Qu, localframe5.kons, string$Mnfold);
      return call_with_values.callWithValues(localframe5.lambda$Fn13, localframe5.lambda$Fn14);
    }
    catch (UnboundLocationException localUnboundLocationException)
    {
      localUnboundLocationException.setLine("srfi13.scm", 295, 3);
      throw localUnboundLocationException;
    }
  }
  
  public static Object stringFoldRight$V(Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
  {
    frame6 localframe6 = new frame6();
    localframe6.kons = paramObject1;
    localframe6.knil = paramObject2;
    localframe6.s = paramObject3;
    localframe6.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    Location localLocation = loc$check$Mnarg;
    try
    {
      Object localObject = localLocation.get();
      localApplyToArgs.apply4(localObject, misc.procedure$Qu, localframe6.kons, string$Mnfold$Mnright);
      return call_with_values.callWithValues(localframe6.lambda$Fn15, localframe6.lambda$Fn16);
    }
    catch (UnboundLocationException localUnboundLocationException)
    {
      localUnboundLocationException.setLine("srfi13.scm", 302, 3);
      throw localUnboundLocationException;
    }
  }
  
  public static Object stringForEach$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame7 localframe7 = new frame7();
    localframe7.proc = paramObject1;
    localframe7.s = paramObject2;
    localframe7.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    Location localLocation = loc$check$Mnarg;
    try
    {
      Object localObject = localLocation.get();
      localApplyToArgs.apply4(localObject, misc.procedure$Qu, localframe7.proc, string$Mnfor$Mneach);
      return call_with_values.callWithValues(localframe7.lambda$Fn19, localframe7.lambda$Fn20);
    }
    catch (UnboundLocationException localUnboundLocationException)
    {
      localUnboundLocationException.setLine("srfi13.scm", 468, 3);
      throw localUnboundLocationException;
    }
  }
  
  public static Object stringForEachIndex$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame8 localframe8 = new frame8();
    localframe8.proc = paramObject1;
    localframe8.s = paramObject2;
    localframe8.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    Location localLocation = loc$check$Mnarg;
    try
    {
      Object localObject = localLocation.get();
      localApplyToArgs.apply4(localObject, misc.procedure$Qu, localframe8.proc, string$Mnfor$Mneach$Mnindex);
      return call_with_values.callWithValues(localframe8.lambda$Fn21, localframe8.lambda$Fn22);
    }
    catch (UnboundLocationException localUnboundLocationException)
    {
      localUnboundLocationException.setLine("srfi13.scm", 476, 3);
      throw localUnboundLocationException;
    }
  }
  
  /* Error */
  public static Object stringHash$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 2285	gnu/kawa/slib/srfi13$frame56
    //   3: dup
    //   4: invokespecial 2286	gnu/kawa/slib/srfi13$frame56:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: putfield 2287	gnu/kawa/slib/srfi13$frame56:s	Ljava/lang/Object;
    //   13: aload_1
    //   14: iconst_0
    //   15: invokestatic 1687	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   18: astore_3
    //   19: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   22: astore 4
    //   24: getstatic 1276	gnu/kawa/slib/srfi13:loc$let$Mnoptionals$St	Lgnu/mapping/Location;
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   34: astore 7
    //   36: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   39: astore 8
    //   41: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   44: astore 9
    //   46: getstatic 1286	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   49: astore 10
    //   51: aload 10
    //   53: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   56: astore 12
    //   58: getstatic 1254	gnu/kawa/slib/srfi13:Lit7	Lgnu/math/IntNum;
    //   61: astore 13
    //   63: getstatic 1286	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   66: astore 14
    //   68: aload 14
    //   70: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   73: astore 16
    //   75: aload 16
    //   77: invokestatic 1747	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   80: istore 17
    //   82: iload 17
    //   84: ifeq +177 -> 261
    //   87: getstatic 1286	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   90: astore 33
    //   92: aload 33
    //   94: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   97: astore 35
    //   99: aload 35
    //   101: invokestatic 1750	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   104: istore 36
    //   106: iload 36
    //   108: ifeq +132 -> 240
    //   111: getstatic 444	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   114: astore 37
    //   116: getstatic 429	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   119: astore 38
    //   121: getstatic 1286	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   124: astore 39
    //   126: aload 39
    //   128: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   131: astore 41
    //   133: aload 37
    //   135: aload 38
    //   137: aload 41
    //   139: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: astore 18
    //   144: aload 9
    //   146: aload 12
    //   148: aload 13
    //   150: aload 18
    //   152: invokevirtual 466	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   155: astore 19
    //   157: getstatic 1288	gnu/kawa/slib/srfi13:loc$rest	Lgnu/mapping/Location;
    //   160: astore 20
    //   162: aload 20
    //   164: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   167: astore 22
    //   169: aload 8
    //   171: aload 19
    //   173: aload 22
    //   175: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   178: astore 23
    //   180: getstatic 1286	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   183: astore 24
    //   185: aload 24
    //   187: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   190: astore 26
    //   192: aload 26
    //   194: checkcast 376	java/lang/Number
    //   197: astore 28
    //   199: aload 28
    //   201: invokestatic 503	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   204: ifeq +78 -> 282
    //   207: getstatic 1252	gnu/kawa/slib/srfi13:Lit8	Lgnu/math/IntNum;
    //   210: astore 32
    //   212: aload_2
    //   213: aload 32
    //   215: putfield 2289	gnu/kawa/slib/srfi13$frame56:bound	Ljava/lang/Object;
    //   218: aload 4
    //   220: aload 7
    //   222: aload_3
    //   223: aload 23
    //   225: aload_2
    //   226: getfield 2292	gnu/kawa/slib/srfi13$frame56:lambda$Fn134	Lgnu/expr/ModuleMethod;
    //   229: aload_2
    //   230: getfield 2295	gnu/kawa/slib/srfi13$frame56:lambda$Fn135	Lgnu/expr/ModuleMethod;
    //   233: invokestatic 1702	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   236: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   239: areturn
    //   240: iload 36
    //   242: ifeq +11 -> 253
    //   245: getstatic 481	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   248: astore 18
    //   250: goto -106 -> 144
    //   253: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   256: astore 18
    //   258: goto -114 -> 144
    //   261: iload 17
    //   263: ifeq +11 -> 274
    //   266: getstatic 481	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   269: astore 18
    //   271: goto -127 -> 144
    //   274: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   277: astore 18
    //   279: goto -135 -> 144
    //   282: getstatic 1286	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   285: astore 29
    //   287: aload 29
    //   289: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   292: astore 31
    //   294: aload 31
    //   296: astore 32
    //   298: goto -86 -> 212
    //   301: astore 6
    //   303: aload 6
    //   305: ldc_w 627
    //   308: sipush 907
    //   311: iconst_3
    //   312: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   315: aload 6
    //   317: athrow
    //   318: astore 11
    //   320: aload 11
    //   322: ldc_w 627
    //   325: sipush 907
    //   328: bipush 42
    //   330: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   333: aload 11
    //   335: athrow
    //   336: astore 15
    //   338: aload 15
    //   340: ldc_w 627
    //   343: sipush 907
    //   346: bipush 72
    //   348: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   351: aload 15
    //   353: athrow
    //   354: astore 34
    //   356: aload 34
    //   358: ldc_w 627
    //   361: sipush 908
    //   364: bipush 21
    //   366: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   369: aload 34
    //   371: athrow
    //   372: astore 40
    //   374: aload 40
    //   376: ldc_w 627
    //   379: sipush 909
    //   382: bipush 19
    //   384: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   387: aload 40
    //   389: athrow
    //   390: astore 21
    //   392: aload 21
    //   394: ldc_w 627
    //   397: sipush 910
    //   400: bipush 7
    //   402: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   405: aload 21
    //   407: athrow
    //   408: astore 25
    //   410: aload 25
    //   412: ldc_w 627
    //   415: sipush 911
    //   418: bipush 29
    //   420: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   423: aload 25
    //   425: athrow
    //   426: astore 27
    //   428: new 412	gnu/mapping/WrongType
    //   431: dup
    //   432: aload 27
    //   434: ldc_w 505
    //   437: iconst_1
    //   438: aload 26
    //   440: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   443: athrow
    //   444: astore 30
    //   446: aload 30
    //   448: ldc_w 627
    //   451: sipush 911
    //   454: bipush 18
    //   456: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   459: aload 30
    //   461: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	paramObject	Object
    //   0	462	1	paramArrayOfObject	Object[]
    //   7	223	2	localframe56	frame56
    //   18	205	3	localLList	LList
    //   22	197	4	localApplyToArgs1	ApplyToArgs
    //   27	3	5	localLocation1	Location
    //   301	15	6	localUnboundLocationException1	UnboundLocationException
    //   34	187	7	localObject1	Object
    //   39	131	8	localApplyToArgs2	ApplyToArgs
    //   44	101	9	localApplyToArgs3	ApplyToArgs
    //   49	3	10	localLocation2	Location
    //   318	16	11	localUnboundLocationException2	UnboundLocationException
    //   56	91	12	localObject2	Object
    //   61	88	13	localIntNum1	IntNum
    //   66	3	14	localLocation3	Location
    //   336	16	15	localUnboundLocationException3	UnboundLocationException
    //   73	3	16	localObject3	Object
    //   80	182	17	bool1	boolean
    //   142	136	18	localObject4	Object
    //   155	17	19	localObject5	Object
    //   160	3	20	localLocation4	Location
    //   390	16	21	localUnboundLocationException4	UnboundLocationException
    //   167	7	22	localObject6	Object
    //   178	46	23	localObject7	Object
    //   183	3	24	localLocation5	Location
    //   408	16	25	localUnboundLocationException5	UnboundLocationException
    //   190	249	26	localObject8	Object
    //   426	7	27	localClassCastException	ClassCastException
    //   197	3	28	localNumber	Number
    //   285	3	29	localLocation6	Location
    //   444	16	30	localUnboundLocationException6	UnboundLocationException
    //   292	3	31	localObject9	Object
    //   210	87	32	localObject10	Object
    //   90	3	33	localLocation7	Location
    //   354	16	34	localUnboundLocationException7	UnboundLocationException
    //   97	3	35	localObject11	Object
    //   104	137	36	bool2	boolean
    //   114	20	37	localNumberCompare	NumberCompare
    //   119	17	38	localIntNum2	IntNum
    //   124	3	39	localLocation8	Location
    //   372	16	40	localUnboundLocationException8	UnboundLocationException
    //   131	7	41	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   29	36	301	gnu/mapping/UnboundLocationException
    //   51	58	318	gnu/mapping/UnboundLocationException
    //   68	75	336	gnu/mapping/UnboundLocationException
    //   92	99	354	gnu/mapping/UnboundLocationException
    //   126	133	372	gnu/mapping/UnboundLocationException
    //   162	169	390	gnu/mapping/UnboundLocationException
    //   185	192	408	gnu/mapping/UnboundLocationException
    //   192	199	426	java/lang/ClassCastException
    //   287	294	444	gnu/mapping/UnboundLocationException
  }
  
  /* Error */
  public static Object stringHashCi$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 2298	gnu/kawa/slib/srfi13$frame57
    //   3: dup
    //   4: invokespecial 2299	gnu/kawa/slib/srfi13$frame57:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: putfield 2300	gnu/kawa/slib/srfi13$frame57:s	Ljava/lang/Object;
    //   13: aload_1
    //   14: iconst_0
    //   15: invokestatic 1687	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   18: astore_3
    //   19: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   22: astore 4
    //   24: getstatic 1276	gnu/kawa/slib/srfi13:loc$let$Mnoptionals$St	Lgnu/mapping/Location;
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   34: astore 7
    //   36: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   39: astore 8
    //   41: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   44: astore 9
    //   46: getstatic 1286	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   49: astore 10
    //   51: aload 10
    //   53: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   56: astore 12
    //   58: getstatic 1250	gnu/kawa/slib/srfi13:Lit9	Lgnu/math/IntNum;
    //   61: astore 13
    //   63: getstatic 1286	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   66: astore 14
    //   68: aload 14
    //   70: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   73: astore 16
    //   75: aload 16
    //   77: invokestatic 1747	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   80: istore 17
    //   82: iload 17
    //   84: ifeq +177 -> 261
    //   87: getstatic 1286	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   90: astore 33
    //   92: aload 33
    //   94: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   97: astore 35
    //   99: aload 35
    //   101: invokestatic 1750	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   104: istore 36
    //   106: iload 36
    //   108: ifeq +132 -> 240
    //   111: getstatic 444	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   114: astore 37
    //   116: getstatic 429	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   119: astore 38
    //   121: getstatic 1286	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   124: astore 39
    //   126: aload 39
    //   128: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   131: astore 41
    //   133: aload 37
    //   135: aload 38
    //   137: aload 41
    //   139: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: astore 18
    //   144: aload 9
    //   146: aload 12
    //   148: aload 13
    //   150: aload 18
    //   152: invokevirtual 466	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   155: astore 19
    //   157: getstatic 1288	gnu/kawa/slib/srfi13:loc$rest	Lgnu/mapping/Location;
    //   160: astore 20
    //   162: aload 20
    //   164: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   167: astore 22
    //   169: aload 8
    //   171: aload 19
    //   173: aload 22
    //   175: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   178: astore 23
    //   180: getstatic 1286	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   183: astore 24
    //   185: aload 24
    //   187: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   190: astore 26
    //   192: aload 26
    //   194: checkcast 376	java/lang/Number
    //   197: astore 28
    //   199: aload 28
    //   201: invokestatic 503	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   204: ifeq +78 -> 282
    //   207: getstatic 1248	gnu/kawa/slib/srfi13:Lit10	Lgnu/math/IntNum;
    //   210: astore 32
    //   212: aload_2
    //   213: aload 32
    //   215: putfield 2301	gnu/kawa/slib/srfi13$frame57:bound	Ljava/lang/Object;
    //   218: aload 4
    //   220: aload 7
    //   222: aload_3
    //   223: aload 23
    //   225: aload_2
    //   226: getfield 2304	gnu/kawa/slib/srfi13$frame57:lambda$Fn136	Lgnu/expr/ModuleMethod;
    //   229: aload_2
    //   230: getfield 2307	gnu/kawa/slib/srfi13$frame57:lambda$Fn137	Lgnu/expr/ModuleMethod;
    //   233: invokestatic 1702	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   236: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   239: areturn
    //   240: iload 36
    //   242: ifeq +11 -> 253
    //   245: getstatic 481	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   248: astore 18
    //   250: goto -106 -> 144
    //   253: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   256: astore 18
    //   258: goto -114 -> 144
    //   261: iload 17
    //   263: ifeq +11 -> 274
    //   266: getstatic 481	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   269: astore 18
    //   271: goto -127 -> 144
    //   274: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   277: astore 18
    //   279: goto -135 -> 144
    //   282: getstatic 1286	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   285: astore 29
    //   287: aload 29
    //   289: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   292: astore 31
    //   294: aload 31
    //   296: astore 32
    //   298: goto -86 -> 212
    //   301: astore 6
    //   303: aload 6
    //   305: ldc_w 627
    //   308: sipush 916
    //   311: iconst_3
    //   312: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   315: aload 6
    //   317: athrow
    //   318: astore 11
    //   320: aload 11
    //   322: ldc_w 627
    //   325: sipush 916
    //   328: bipush 42
    //   330: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   333: aload 11
    //   335: athrow
    //   336: astore 15
    //   338: aload 15
    //   340: ldc_w 627
    //   343: sipush 916
    //   346: bipush 72
    //   348: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   351: aload 15
    //   353: athrow
    //   354: astore 34
    //   356: aload 34
    //   358: ldc_w 627
    //   361: sipush 917
    //   364: bipush 21
    //   366: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   369: aload 34
    //   371: athrow
    //   372: astore 40
    //   374: aload 40
    //   376: ldc_w 627
    //   379: sipush 918
    //   382: bipush 19
    //   384: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   387: aload 40
    //   389: athrow
    //   390: astore 21
    //   392: aload 21
    //   394: ldc_w 627
    //   397: sipush 919
    //   400: bipush 7
    //   402: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   405: aload 21
    //   407: athrow
    //   408: astore 25
    //   410: aload 25
    //   412: ldc_w 627
    //   415: sipush 920
    //   418: bipush 29
    //   420: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   423: aload 25
    //   425: athrow
    //   426: astore 27
    //   428: new 412	gnu/mapping/WrongType
    //   431: dup
    //   432: aload 27
    //   434: ldc_w 505
    //   437: iconst_1
    //   438: aload 26
    //   440: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   443: athrow
    //   444: astore 30
    //   446: aload 30
    //   448: ldc_w 627
    //   451: sipush 920
    //   454: bipush 18
    //   456: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   459: aload 30
    //   461: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	paramObject	Object
    //   0	462	1	paramArrayOfObject	Object[]
    //   7	223	2	localframe57	frame57
    //   18	205	3	localLList	LList
    //   22	197	4	localApplyToArgs1	ApplyToArgs
    //   27	3	5	localLocation1	Location
    //   301	15	6	localUnboundLocationException1	UnboundLocationException
    //   34	187	7	localObject1	Object
    //   39	131	8	localApplyToArgs2	ApplyToArgs
    //   44	101	9	localApplyToArgs3	ApplyToArgs
    //   49	3	10	localLocation2	Location
    //   318	16	11	localUnboundLocationException2	UnboundLocationException
    //   56	91	12	localObject2	Object
    //   61	88	13	localIntNum1	IntNum
    //   66	3	14	localLocation3	Location
    //   336	16	15	localUnboundLocationException3	UnboundLocationException
    //   73	3	16	localObject3	Object
    //   80	182	17	bool1	boolean
    //   142	136	18	localObject4	Object
    //   155	17	19	localObject5	Object
    //   160	3	20	localLocation4	Location
    //   390	16	21	localUnboundLocationException4	UnboundLocationException
    //   167	7	22	localObject6	Object
    //   178	46	23	localObject7	Object
    //   183	3	24	localLocation5	Location
    //   408	16	25	localUnboundLocationException5	UnboundLocationException
    //   190	249	26	localObject8	Object
    //   426	7	27	localClassCastException	ClassCastException
    //   197	3	28	localNumber	Number
    //   285	3	29	localLocation6	Location
    //   444	16	30	localUnboundLocationException6	UnboundLocationException
    //   292	3	31	localObject9	Object
    //   210	87	32	localObject10	Object
    //   90	3	33	localLocation7	Location
    //   354	16	34	localUnboundLocationException7	UnboundLocationException
    //   97	3	35	localObject11	Object
    //   104	137	36	bool2	boolean
    //   114	20	37	localNumberCompare	NumberCompare
    //   119	17	38	localIntNum2	IntNum
    //   124	3	39	localLocation8	Location
    //   372	16	40	localUnboundLocationException8	UnboundLocationException
    //   131	7	41	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   29	36	301	gnu/mapping/UnboundLocationException
    //   51	58	318	gnu/mapping/UnboundLocationException
    //   68	75	336	gnu/mapping/UnboundLocationException
    //   92	99	354	gnu/mapping/UnboundLocationException
    //   126	133	372	gnu/mapping/UnboundLocationException
    //   162	169	390	gnu/mapping/UnboundLocationException
    //   185	192	408	gnu/mapping/UnboundLocationException
    //   192	199	426	java/lang/ClassCastException
    //   287	294	444	gnu/mapping/UnboundLocationException
  }
  
  public static Object stringIndex$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame77 localframe77 = new frame77();
    localframe77.str = paramObject1;
    localframe77.criterion = paramObject2;
    localframe77.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe77.lambda$Fn177, localframe77.lambda$Fn178);
  }
  
  public static Object stringIndexRight$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame78 localframe78 = new frame78();
    localframe78.str = paramObject1;
    localframe78.criterion = paramObject2;
    localframe78.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe78.lambda$Fn179, localframe78.lambda$Fn180);
  }
  
  public static Object stringJoin$V(Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs1 = Scheme.applyToArgs;
    Location localLocation1 = loc$let$Mnoptionals$St;
    for (;;)
    {
      try
      {
        localObject1 = localLocation1.get();
        localApplyToArgs2 = Scheme.applyToArgs;
        localApplyToArgs3 = Scheme.applyToArgs;
        localLocation2 = loc$delim;
      }
      catch (UnboundLocationException localUnboundLocationException1)
      {
        try
        {
          Object localObject1;
          ApplyToArgs localApplyToArgs2;
          ApplyToArgs localApplyToArgs3;
          Location localLocation2;
          Object localObject2;
          Location localLocation3;
          Object localObject3;
          Boolean localBoolean;
          Object localObject4;
          ApplyToArgs localApplyToArgs4;
          Location localLocation4;
          Object localObject5;
          Object localObject6;
          Location localLocation6;
          Object localObject9;
          Object localObject10;
          Object localObject12;
          Object localObject13;
          Object localObject14;
          Location localLocation8;
          Object localObject15;
          Object[] arrayOfObject3;
          Location localLocation7;
          localObject7 = localLocation5.get();
          if (localObject7 == Lit16)
          {
            arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = string$Mnjoin;
            localObject8 = misc.error$V("Empty list cannot be joined with STRICT-INFIX grammar.", arrayOfObject1);
            continue;
          }
          Object localObject8 = "";
        }
        catch (UnboundLocationException localUnboundLocationException5)
        {
          localUnboundLocationException5.setLine("srfi13.scm", 1880, 13);
          throw localUnboundLocationException5;
        }
        localUnboundLocationException1 = localUnboundLocationException1;
        localUnboundLocationException1.setLine("srfi13.scm", 1852, 3);
        throw localUnboundLocationException1;
      }
      try
      {
        localObject2 = localLocation2.get();
        localLocation3 = loc$delim;
      }
      catch (UnboundLocationException localUnboundLocationException2)
      {
        localUnboundLocationException2.setLine("srfi13.scm", 1852, 34);
        throw localUnboundLocationException2;
      }
      try
      {
        localObject3 = localLocation3.get();
        if (strings.isString(localObject3))
        {
          localBoolean = Boolean.TRUE;
          localObject4 = localApplyToArgs3.apply3(localObject2, " ", localBoolean);
          localApplyToArgs4 = Scheme.applyToArgs;
          localLocation4 = loc$grammar;
        }
      }
      catch (UnboundLocationException localUnboundLocationException3)
      {
        localUnboundLocationException3.setLine("srfi13.scm", 1852, 54);
        throw localUnboundLocationException3;
      }
      try
      {
        localObject5 = localLocation4.get();
        localObject6 = localApplyToArgs2.apply2(localObject4, localApplyToArgs4.apply2(localObject5, Lit15));
        if (lists.isPair(paramObject)) {
          localLocation6 = loc$grammar;
        }
      }
      catch (UnboundLocationException localUnboundLocationException4)
      {
        localUnboundLocationException4.setLine("srfi13.scm", 1853, 6);
        throw localUnboundLocationException4;
      }
      try
      {
        localObject9 = localLocation6.get();
        localObject10 = Scheme.isEqv.apply2(localObject9, Lit15);
        if (localObject10 != Boolean.FALSE)
        {
          if (localObject10 != Boolean.FALSE)
          {
            localObject12 = lists.cons(lists.car.apply1(paramObject), lambda222buildit(lists.cdr.apply1(paramObject), LList.Empty));
            localObject8 = stringConcatenate(localObject12);
            return localApplyToArgs1.apply4(localObject1, localLList, localObject6, localObject8);
            localBoolean = Boolean.FALSE;
          }
        }
        else {
          if (Scheme.isEqv.apply2(localObject9, Lit16) != Boolean.FALSE) {
            continue;
          }
        }
        if (Scheme.isEqv.apply2(localObject9, Lit17) != Boolean.FALSE)
        {
          localObject12 = lambda222buildit(paramObject, LList.Empty);
          continue;
        }
        if (Scheme.isEqv.apply2(localObject9, Lit18) != Boolean.FALSE)
        {
          localObject13 = lists.car.apply1(paramObject);
          localObject14 = lists.cdr.apply1(paramObject);
          localLocation8 = loc$delim;
        }
      }
      catch (UnboundLocationException localUnboundLocationException6)
      {
        localUnboundLocationException6.setLine("srfi13.scm", 1862, 14);
        throw localUnboundLocationException6;
      }
      try
      {
        localObject15 = localLocation8.get();
        localObject12 = lists.cons(localObject13, lambda222buildit(localObject14, LList.list1(localObject15)));
      }
      catch (UnboundLocationException localUnboundLocationException8)
      {
        localUnboundLocationException8.setLine("srfi13.scm", 1870, 53);
        throw localUnboundLocationException8;
      }
      arrayOfObject3 = new Object[2];
      localLocation7 = loc$grammar;
      try
      {
        Object localObject11 = localLocation7.get();
        arrayOfObject3[0] = localObject11;
        arrayOfObject3[1] = string$Mnjoin;
        localObject12 = misc.error$V("Illegal join grammar", arrayOfObject3);
      }
      catch (UnboundLocationException localUnboundLocationException7)
      {
        Object[] arrayOfObject2;
        Location localLocation5;
        Object localObject7;
        Object[] arrayOfObject1;
        localUnboundLocationException7.setLine("srfi13.scm", 1873, 9);
        throw localUnboundLocationException7;
      }
      if (lists.isNull(paramObject)) {
        continue;
      }
      arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramObject;
      arrayOfObject2[1] = string$Mnjoin;
      localObject8 = misc.error$V("STRINGS parameter not list.", arrayOfObject2);
    }
    localLocation5 = loc$grammar;
  }
  
  /* Error */
  public static Object stringKmpPartialSearch$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 2366	gnu/kawa/slib/srfi13$frame88
    //   3: dup
    //   4: invokespecial 2367	gnu/kawa/slib/srfi13$frame88:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: aload_2
    //   12: putfield 2368	gnu/kawa/slib/srfi13$frame88:s	Ljava/lang/Object;
    //   15: aload 4
    //   17: iconst_0
    //   18: invokestatic 1687	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   21: astore 6
    //   23: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   26: astore 7
    //   28: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   31: astore 8
    //   33: aload 8
    //   35: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   38: astore 10
    //   40: aload 7
    //   42: aload 10
    //   44: getstatic 2371	kawa/lib/vectors:vector$Qu	Lgnu/expr/ModuleMethod;
    //   47: aload_1
    //   48: getstatic 1611	gnu/kawa/slib/srfi13:string$Mnkmp$Mnpartial$Mnsearch	Lgnu/expr/ModuleMethod;
    //   51: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   58: astore 12
    //   60: getstatic 1276	gnu/kawa/slib/srfi13:loc$let$Mnoptionals$St	Lgnu/mapping/Location;
    //   63: astore 13
    //   65: aload 13
    //   67: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   70: astore 15
    //   72: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   75: astore 16
    //   77: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   80: astore 17
    //   82: getstatic 1294	gnu/kawa/slib/srfi13:loc$c$Eq	Lgnu/mapping/Location;
    //   85: astore 18
    //   87: aload 18
    //   89: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   92: astore 20
    //   94: getstatic 1775	kawa/lib/characters:char$Eq$Qu	Lgnu/expr/ModuleMethod;
    //   97: astore 21
    //   99: getstatic 1294	gnu/kawa/slib/srfi13:loc$c$Eq	Lgnu/mapping/Location;
    //   102: astore 22
    //   104: aload 22
    //   106: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   109: astore 24
    //   111: aload 24
    //   113: invokestatic 1778	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   116: ifeq +316 -> 432
    //   119: getstatic 481	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   122: astore 25
    //   124: aload 17
    //   126: aload 20
    //   128: aload 21
    //   130: aload 25
    //   132: invokevirtual 466	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: astore 26
    //   137: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   140: astore 27
    //   142: getstatic 1300	gnu/kawa/slib/srfi13:loc$p$Mnstart	Lgnu/mapping/Location;
    //   145: astore 28
    //   147: aload 28
    //   149: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   152: astore 30
    //   154: getstatic 429	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   157: astore 31
    //   159: getstatic 1300	gnu/kawa/slib/srfi13:loc$p$Mnstart	Lgnu/mapping/Location;
    //   162: astore 32
    //   164: aload 32
    //   166: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   169: astore 34
    //   171: aload 34
    //   173: invokestatic 1747	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   176: istore 35
    //   178: iload 35
    //   180: ifeq +281 -> 461
    //   183: getstatic 1300	gnu/kawa/slib/srfi13:loc$p$Mnstart	Lgnu/mapping/Location;
    //   186: astore 87
    //   188: aload 87
    //   190: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   193: astore 89
    //   195: aload 89
    //   197: invokestatic 1750	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   200: istore 90
    //   202: iload 90
    //   204: ifeq +236 -> 440
    //   207: getstatic 444	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   210: astore 91
    //   212: getstatic 429	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   215: astore 92
    //   217: getstatic 1300	gnu/kawa/slib/srfi13:loc$p$Mnstart	Lgnu/mapping/Location;
    //   220: astore 93
    //   222: aload 93
    //   224: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   227: astore 95
    //   229: aload 91
    //   231: aload 92
    //   233: aload 95
    //   235: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   238: astore 36
    //   240: aload 27
    //   242: aload 30
    //   244: aload 31
    //   246: aload 36
    //   248: invokevirtual 466	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   251: astore 37
    //   253: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   256: astore 38
    //   258: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   261: astore 39
    //   263: getstatic 1302	gnu/kawa/slib/srfi13:loc$s$Mnstart	Lgnu/mapping/Location;
    //   266: astore 40
    //   268: aload 40
    //   270: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   273: astore 42
    //   275: getstatic 1304	gnu/kawa/slib/srfi13:loc$s$Mnend	Lgnu/mapping/Location;
    //   278: astore 43
    //   280: aload 43
    //   282: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   285: astore 45
    //   287: aload 16
    //   289: aload 26
    //   291: aload 37
    //   293: aload 38
    //   295: aload 39
    //   297: aload 42
    //   299: aload 45
    //   301: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   304: aload 5
    //   306: getfield 2374	gnu/kawa/slib/srfi13$frame88:lambda$Fn198	Lgnu/expr/ModuleMethod;
    //   309: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   312: invokevirtual 466	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   315: astore 46
    //   317: aload_1
    //   318: checkcast 470	gnu/lists/FVector
    //   321: astore 48
    //   323: aload 5
    //   325: aload 48
    //   327: invokestatic 2378	kawa/lib/vectors:vectorLength	(Lgnu/lists/FVector;)I
    //   330: putfield 2381	gnu/kawa/slib/srfi13$frame88:patlen	I
    //   333: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   336: astore 49
    //   338: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   341: astore 50
    //   343: aload 50
    //   345: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   348: astore 52
    //   350: aload 49
    //   352: aload 52
    //   354: aload 5
    //   356: getfield 2384	gnu/kawa/slib/srfi13$frame88:lambda$Fn199	Lgnu/expr/ModuleMethod;
    //   359: aload_3
    //   360: getstatic 1611	gnu/kawa/slib/srfi13:string$Mnkmp$Mnpartial$Mnsearch	Lgnu/expr/ModuleMethod;
    //   363: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   366: pop
    //   367: getstatic 1302	gnu/kawa/slib/srfi13:loc$s$Mnstart	Lgnu/mapping/Location;
    //   370: astore 54
    //   372: aload 54
    //   374: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   377: astore 56
    //   379: aload 56
    //   381: astore 57
    //   383: aload_3
    //   384: astore 58
    //   386: getstatic 435	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   389: aload 58
    //   391: aload 5
    //   393: getfield 2381	gnu/kawa/slib/srfi13$frame88:patlen	I
    //   396: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   399: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   402: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   405: if_acmpeq +77 -> 482
    //   408: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   411: aload 57
    //   413: invokevirtual 404	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   416: astore 58
    //   418: aload 12
    //   420: aload 15
    //   422: aload 6
    //   424: aload 46
    //   426: aload 58
    //   428: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   431: areturn
    //   432: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   435: astore 25
    //   437: goto -313 -> 124
    //   440: iload 90
    //   442: ifeq +11 -> 453
    //   445: getstatic 481	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   448: astore 36
    //   450: goto -210 -> 240
    //   453: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   456: astore 36
    //   458: goto -218 -> 240
    //   461: iload 35
    //   463: ifeq +11 -> 474
    //   466: getstatic 481	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   469: astore 36
    //   471: goto -231 -> 240
    //   474: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   477: astore 36
    //   479: goto -239 -> 240
    //   482: getstatic 435	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   485: astore 59
    //   487: getstatic 1304	gnu/kawa/slib/srfi13:loc$s$Mnend	Lgnu/mapping/Location;
    //   490: astore 60
    //   492: aload 60
    //   494: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   497: astore 62
    //   499: aload 59
    //   501: aload 57
    //   503: aload 62
    //   505: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   508: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   511: if_acmpne -93 -> 418
    //   514: aload 5
    //   516: getfield 2368	gnu/kawa/slib/srfi13$frame88:s	Ljava/lang/Object;
    //   519: astore 63
    //   521: aload 63
    //   523: checkcast 386	java/lang/CharSequence
    //   526: astore 65
    //   528: aload 57
    //   530: checkcast 376	java/lang/Number
    //   533: invokevirtual 380	java/lang/Number:intValue	()I
    //   536: istore 67
    //   538: aload 65
    //   540: iload 67
    //   542: invokestatic 456	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   545: istore 68
    //   547: getstatic 368	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   550: aload 57
    //   552: getstatic 468	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   555: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   558: astore 57
    //   560: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   563: astore 69
    //   565: getstatic 1294	gnu/kawa/slib/srfi13:loc$c$Eq	Lgnu/mapping/Location;
    //   568: astore 70
    //   570: aload 70
    //   572: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   575: astore 72
    //   577: iload 68
    //   579: invokestatic 462	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   582: astore 73
    //   584: aload_0
    //   585: checkcast 386	java/lang/CharSequence
    //   588: astore 75
    //   590: getstatic 368	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   593: astore 76
    //   595: getstatic 1300	gnu/kawa/slib/srfi13:loc$p$Mnstart	Lgnu/mapping/Location;
    //   598: astore 77
    //   600: aload 77
    //   602: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   605: astore 79
    //   607: aload 76
    //   609: aload 58
    //   611: aload 79
    //   613: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   616: astore 80
    //   618: aload 80
    //   620: checkcast 376	java/lang/Number
    //   623: invokevirtual 380	java/lang/Number:intValue	()I
    //   626: istore 82
    //   628: aload 69
    //   630: aload 72
    //   632: aload 73
    //   634: aload 75
    //   636: iload 82
    //   638: invokestatic 456	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   641: invokestatic 462	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   644: invokevirtual 466	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   647: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   650: if_acmpeq +19 -> 669
    //   653: getstatic 368	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   656: aload 58
    //   658: getstatic 468	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   661: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   664: astore 58
    //   666: goto -280 -> 386
    //   669: aload_1
    //   670: checkcast 470	gnu/lists/FVector
    //   673: astore 84
    //   675: aload 58
    //   677: checkcast 376	java/lang/Number
    //   680: invokevirtual 380	java/lang/Number:intValue	()I
    //   683: istore 86
    //   685: aload 84
    //   687: iload 86
    //   689: invokestatic 476	kawa/lib/vectors:vectorRef	(Lgnu/lists/FVector;I)Ljava/lang/Object;
    //   692: astore 58
    //   694: getstatic 435	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   697: aload 58
    //   699: getstatic 478	gnu/kawa/slib/srfi13:Lit13	Lgnu/math/IntNum;
    //   702: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   705: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   708: if_acmpeq -148 -> 560
    //   711: getstatic 429	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   714: astore 58
    //   716: goto -50 -> 666
    //   719: astore 9
    //   721: aload 9
    //   723: ldc_w 627
    //   726: sipush 1464
    //   729: iconst_3
    //   730: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   733: aload 9
    //   735: athrow
    //   736: astore 14
    //   738: aload 14
    //   740: ldc_w 627
    //   743: sipush 1465
    //   746: iconst_3
    //   747: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   750: aload 14
    //   752: athrow
    //   753: astore 19
    //   755: aload 19
    //   757: ldc_w 627
    //   760: sipush 1466
    //   763: bipush 6
    //   765: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   768: aload 19
    //   770: athrow
    //   771: astore 23
    //   773: aload 23
    //   775: ldc_w 627
    //   778: sipush 1466
    //   781: bipush 34
    //   783: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   786: aload 23
    //   788: athrow
    //   789: astore 29
    //   791: aload 29
    //   793: ldc_w 627
    //   796: sipush 1467
    //   799: bipush 6
    //   801: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   804: aload 29
    //   806: athrow
    //   807: astore 33
    //   809: aload 33
    //   811: ldc_w 627
    //   814: sipush 1467
    //   817: bipush 32
    //   819: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   822: aload 33
    //   824: athrow
    //   825: astore 88
    //   827: aload 88
    //   829: ldc_w 627
    //   832: sipush 1467
    //   835: bipush 49
    //   837: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   840: aload 88
    //   842: athrow
    //   843: astore 94
    //   845: aload 94
    //   847: ldc_w 627
    //   850: sipush 1467
    //   853: bipush 64
    //   855: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   858: aload 94
    //   860: athrow
    //   861: astore 41
    //   863: aload 41
    //   865: ldc_w 627
    //   868: sipush 1468
    //   871: bipush 7
    //   873: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   876: aload 41
    //   878: athrow
    //   879: astore 44
    //   881: aload 44
    //   883: ldc_w 627
    //   886: sipush 1468
    //   889: bipush 16
    //   891: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   894: aload 44
    //   896: athrow
    //   897: astore 47
    //   899: new 412	gnu/mapping/WrongType
    //   902: dup
    //   903: aload 47
    //   905: ldc_w 2386
    //   908: iconst_1
    //   909: aload_1
    //   910: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   913: athrow
    //   914: astore 51
    //   916: aload 51
    //   918: ldc_w 627
    //   921: sipush 1472
    //   924: bipush 7
    //   926: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   929: aload 51
    //   931: athrow
    //   932: astore 55
    //   934: aload 55
    //   936: ldc_w 627
    //   939: sipush 1476
    //   942: bipush 7
    //   944: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   947: aload 55
    //   949: athrow
    //   950: astore 61
    //   952: aload 61
    //   954: ldc_w 627
    //   957: sipush 1479
    //   960: bipush 15
    //   962: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   965: aload 61
    //   967: athrow
    //   968: astore 64
    //   970: new 412	gnu/mapping/WrongType
    //   973: dup
    //   974: aload 64
    //   976: ldc_w 485
    //   979: iconst_1
    //   980: aload 63
    //   982: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   985: athrow
    //   986: astore 66
    //   988: new 412	gnu/mapping/WrongType
    //   991: dup
    //   992: aload 66
    //   994: ldc_w 485
    //   997: iconst_2
    //   998: aload 57
    //   1000: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1003: athrow
    //   1004: astore 71
    //   1006: aload 71
    //   1008: ldc_w 627
    //   1011: sipush 1484
    //   1014: bipush 14
    //   1016: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   1019: aload 71
    //   1021: athrow
    //   1022: astore 74
    //   1024: new 412	gnu/mapping/WrongType
    //   1027: dup
    //   1028: aload 74
    //   1030: ldc_w 485
    //   1033: iconst_1
    //   1034: aload_0
    //   1035: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1038: athrow
    //   1039: astore 78
    //   1041: aload 78
    //   1043: ldc_w 627
    //   1046: sipush 1484
    //   1049: bipush 42
    //   1051: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   1054: aload 78
    //   1056: athrow
    //   1057: astore 81
    //   1059: new 412	gnu/mapping/WrongType
    //   1062: dup
    //   1063: aload 81
    //   1065: ldc_w 485
    //   1068: iconst_2
    //   1069: aload 80
    //   1071: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1074: athrow
    //   1075: astore 83
    //   1077: new 412	gnu/mapping/WrongType
    //   1080: dup
    //   1081: aload 83
    //   1083: ldc_w 487
    //   1086: iconst_1
    //   1087: aload_1
    //   1088: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1091: athrow
    //   1092: astore 85
    //   1094: new 412	gnu/mapping/WrongType
    //   1097: dup
    //   1098: aload 85
    //   1100: ldc_w 487
    //   1103: iconst_2
    //   1104: aload 58
    //   1106: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1110	0	paramObject1	Object
    //   0	1110	1	paramObject2	Object
    //   0	1110	2	paramObject3	Object
    //   0	1110	3	paramObject4	Object
    //   0	1110	4	paramArrayOfObject	Object[]
    //   7	508	5	localframe88	frame88
    //   21	402	6	localLList	LList
    //   26	15	7	localApplyToArgs1	ApplyToArgs
    //   31	3	8	localLocation1	Location
    //   719	15	9	localUnboundLocationException1	UnboundLocationException
    //   38	5	10	localObject1	Object
    //   58	361	12	localApplyToArgs2	ApplyToArgs
    //   63	3	13	localLocation2	Location
    //   736	15	14	localUnboundLocationException2	UnboundLocationException
    //   70	351	15	localObject2	Object
    //   75	213	16	localApplyToArgs3	ApplyToArgs
    //   80	45	17	localApplyToArgs4	ApplyToArgs
    //   85	3	18	localLocation3	Location
    //   753	16	19	localUnboundLocationException3	UnboundLocationException
    //   92	35	20	localObject3	Object
    //   97	32	21	localModuleMethod	ModuleMethod
    //   102	3	22	localLocation4	Location
    //   771	16	23	localUnboundLocationException4	UnboundLocationException
    //   109	3	24	localObject4	Object
    //   122	314	25	localBoolean	Boolean
    //   135	155	26	localObject5	Object
    //   140	101	27	localApplyToArgs5	ApplyToArgs
    //   145	3	28	localLocation5	Location
    //   789	16	29	localUnboundLocationException5	UnboundLocationException
    //   152	91	30	localObject6	Object
    //   157	88	31	localIntNum1	IntNum
    //   162	3	32	localLocation6	Location
    //   807	16	33	localUnboundLocationException6	UnboundLocationException
    //   169	3	34	localObject7	Object
    //   176	286	35	bool1	boolean
    //   238	240	36	localObject8	Object
    //   251	41	37	localObject9	Object
    //   256	38	38	localApplyToArgs6	ApplyToArgs
    //   261	35	39	localApplyToArgs7	ApplyToArgs
    //   266	3	40	localLocation7	Location
    //   861	16	41	localUnboundLocationException7	UnboundLocationException
    //   273	25	42	localObject10	Object
    //   278	3	43	localLocation8	Location
    //   879	16	44	localUnboundLocationException8	UnboundLocationException
    //   285	15	45	localObject11	Object
    //   315	110	46	localObject12	Object
    //   897	7	47	localClassCastException1	ClassCastException
    //   321	5	48	localFVector1	FVector
    //   336	15	49	localApplyToArgs8	ApplyToArgs
    //   341	3	50	localLocation9	Location
    //   914	16	51	localUnboundLocationException9	UnboundLocationException
    //   348	5	52	localObject13	Object
    //   370	3	54	localLocation10	Location
    //   932	16	55	localUnboundLocationException10	UnboundLocationException
    //   377	3	56	localObject14	Object
    //   381	618	57	localObject15	Object
    //   384	721	58	localObject16	Object
    //   485	15	59	localNumberCompare1	NumberCompare
    //   490	3	60	localLocation11	Location
    //   950	16	61	localUnboundLocationException11	UnboundLocationException
    //   497	7	62	localObject17	Object
    //   519	462	63	localObject18	Object
    //   968	7	64	localClassCastException2	ClassCastException
    //   526	13	65	localCharSequence1	CharSequence
    //   986	7	66	localClassCastException3	ClassCastException
    //   536	5	67	i	int
    //   545	33	68	j	int
    //   563	66	69	localApplyToArgs9	ApplyToArgs
    //   568	3	70	localLocation12	Location
    //   1004	16	71	localUnboundLocationException12	UnboundLocationException
    //   575	56	72	localObject19	Object
    //   582	51	73	localChar	Char
    //   1022	7	74	localClassCastException4	ClassCastException
    //   588	47	75	localCharSequence2	CharSequence
    //   593	15	76	localAddOp	AddOp
    //   598	3	77	localLocation13	Location
    //   1039	16	78	localUnboundLocationException13	UnboundLocationException
    //   605	7	79	localObject20	Object
    //   616	454	80	localObject21	Object
    //   1057	7	81	localClassCastException5	ClassCastException
    //   626	11	82	k	int
    //   1075	7	83	localClassCastException6	ClassCastException
    //   673	13	84	localFVector2	FVector
    //   1092	7	85	localClassCastException7	ClassCastException
    //   683	5	86	m	int
    //   186	3	87	localLocation14	Location
    //   825	16	88	localUnboundLocationException14	UnboundLocationException
    //   193	3	89	localObject22	Object
    //   200	241	90	bool2	boolean
    //   210	20	91	localNumberCompare2	NumberCompare
    //   215	17	92	localIntNum2	IntNum
    //   220	3	93	localLocation15	Location
    //   843	16	94	localUnboundLocationException15	UnboundLocationException
    //   227	7	95	localObject23	Object
    // Exception table:
    //   from	to	target	type
    //   33	40	719	gnu/mapping/UnboundLocationException
    //   65	72	736	gnu/mapping/UnboundLocationException
    //   87	94	753	gnu/mapping/UnboundLocationException
    //   104	111	771	gnu/mapping/UnboundLocationException
    //   147	154	789	gnu/mapping/UnboundLocationException
    //   164	171	807	gnu/mapping/UnboundLocationException
    //   188	195	825	gnu/mapping/UnboundLocationException
    //   222	229	843	gnu/mapping/UnboundLocationException
    //   268	275	861	gnu/mapping/UnboundLocationException
    //   280	287	879	gnu/mapping/UnboundLocationException
    //   317	323	897	java/lang/ClassCastException
    //   343	350	914	gnu/mapping/UnboundLocationException
    //   372	379	932	gnu/mapping/UnboundLocationException
    //   492	499	950	gnu/mapping/UnboundLocationException
    //   521	528	968	java/lang/ClassCastException
    //   528	538	986	java/lang/ClassCastException
    //   570	577	1004	gnu/mapping/UnboundLocationException
    //   584	590	1022	java/lang/ClassCastException
    //   600	607	1039	gnu/mapping/UnboundLocationException
    //   618	628	1057	java/lang/ClassCastException
    //   669	675	1075	java/lang/ClassCastException
    //   675	685	1092	java/lang/ClassCastException
  }
  
  public static Object stringMap$Ex$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame4 localframe4 = new frame4();
    localframe4.proc = paramObject1;
    localframe4.s = paramObject2;
    localframe4.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    Location localLocation = loc$check$Mnarg;
    try
    {
      Object localObject = localLocation.get();
      localApplyToArgs.apply4(localObject, misc.procedure$Qu, localframe4.proc, string$Mnmap$Ex);
      return call_with_values.callWithValues(localframe4.lambda$Fn11, localframe4.lambda$Fn12);
    }
    catch (UnboundLocationException localUnboundLocationException)
    {
      localUnboundLocationException.setLine("srfi13.scm", 285, 3);
      throw localUnboundLocationException;
    }
  }
  
  public static Object stringMap$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame3 localframe3 = new frame3();
    localframe3.proc = paramObject1;
    localframe3.s = paramObject2;
    localframe3.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    Location localLocation = loc$check$Mnarg;
    try
    {
      Object localObject = localLocation.get();
      localApplyToArgs.apply4(localObject, misc.procedure$Qu, localframe3.proc, string$Mnmap);
      return call_with_values.callWithValues(localframe3.lambda$Fn9, localframe3.lambda$Fn10);
    }
    catch (UnboundLocationException localUnboundLocationException)
    {
      localUnboundLocationException.setLine("srfi13.scm", 271, 3);
      throw localUnboundLocationException;
    }
  }
  
  public static Object stringPad$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame72 localframe72 = new frame72();
    localframe72.s = paramObject1;
    localframe72.n = paramObject2;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs1 = Scheme.applyToArgs;
    Location localLocation1 = loc$let$Mnoptionals$St;
    for (;;)
    {
      try
      {
        localObject1 = localLocation1.get();
        localApplyToArgs2 = Scheme.applyToArgs;
        Invoke localInvoke = Invoke.make;
        LangPrimType localLangPrimType = LangPrimType.charType;
        Char localChar = Lit12;
        if (characters.isChar(LangPrimType.charType))
        {
          localBoolean = Boolean.TRUE;
          localObject2 = localInvoke.apply3(localLangPrimType, localChar, localBoolean);
          localLocation2 = loc$rest;
        }
      }
      catch (UnboundLocationException localUnboundLocationException1)
      {
        Object localObject1;
        ApplyToArgs localApplyToArgs2;
        Boolean localBoolean;
        Object localObject2;
        Location localLocation2;
        Object localObject3;
        localUnboundLocationException1.setLine("srfi13.scm", 1057, 3);
        throw localUnboundLocationException1;
      }
      try
      {
        localObject3 = localLocation2.get();
        return localApplyToArgs1.apply4(localObject1, localLList, localApplyToArgs2.apply2(localObject2, localObject3), call_with_values.callWithValues(localframe72.lambda$Fn164, localframe72.lambda$Fn165));
      }
      catch (UnboundLocationException localUnboundLocationException2)
      {
        localUnboundLocationException2.setLine("srfi13.scm", 1057, 63);
        throw localUnboundLocationException2;
      }
      localBoolean = Boolean.FALSE;
    }
  }
  
  public static Object stringPadRight$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame71 localframe71 = new frame71();
    localframe71.s = paramObject1;
    localframe71.n = paramObject2;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs1 = Scheme.applyToArgs;
    Location localLocation1 = loc$let$Mnoptionals$St;
    for (;;)
    {
      try
      {
        localObject1 = localLocation1.get();
        localApplyToArgs2 = Scheme.applyToArgs;
        Invoke localInvoke = Invoke.make;
        LangPrimType localLangPrimType = LangPrimType.charType;
        Char localChar = Lit12;
        if (characters.isChar(LangPrimType.charType))
        {
          localBoolean = Boolean.TRUE;
          localObject2 = localInvoke.apply3(localLangPrimType, localChar, localBoolean);
          localLocation2 = loc$rest;
        }
      }
      catch (UnboundLocationException localUnboundLocationException1)
      {
        Object localObject1;
        ApplyToArgs localApplyToArgs2;
        Boolean localBoolean;
        Object localObject2;
        Location localLocation2;
        Object localObject3;
        localUnboundLocationException1.setLine("srfi13.scm", 1045, 3);
        throw localUnboundLocationException1;
      }
      try
      {
        localObject3 = localLocation2.get();
        return localApplyToArgs1.apply4(localObject1, localLList, localApplyToArgs2.apply2(localObject2, localObject3), call_with_values.callWithValues(localframe71.lambda$Fn161, localframe71.lambda$Fn162));
      }
      catch (UnboundLocationException localUnboundLocationException2)
      {
        localUnboundLocationException2.setLine("srfi13.scm", 1045, 63);
        throw localUnboundLocationException2;
      }
      localBoolean = Boolean.FALSE;
    }
  }
  
  public static Object stringParseFinalStart$PlEnd(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame0 localframe0 = new frame0();
    localframe0.proc = paramObject1;
    localframe0.s = paramObject2;
    localframe0.args = paramObject3;
    return call_with_values.callWithValues(localframe0.lambda$Fn3, localframe0.lambda$Fn4);
  }
  
  public static Object stringParseStart$PlEnd(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame localframe = new frame();
    localframe.proc = paramObject1;
    localframe.s = paramObject2;
    if (!strings.isString(localframe.s))
    {
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = localframe.proc;
      arrayOfObject3[1] = localframe.s;
      misc.error$V("Non-string value", arrayOfObject3);
    }
    Object localObject1 = localframe.s;
    try
    {
      CharSequence localCharSequence = (CharSequence)localObject1;
      localframe.slen = strings.stringLength(localCharSequence);
      if (lists.isPair(paramObject3))
      {
        Object localObject2 = lists.car.apply1(paramObject3);
        localframe.args = lists.cdr.apply1(paramObject3);
        localframe.start = localObject2;
        boolean bool1 = numbers.isInteger(localframe.start);
        boolean bool2;
        if (bool1)
        {
          bool2 = numbers.isExact(localframe.start);
          if (bool2) {
            if (Scheme.numGEq.apply2(localframe.start, Lit0) == Boolean.FALSE) {
              break label178;
            }
          }
        }
        for (;;)
        {
          return call_with_values.callWithValues(localframe.lambda$Fn1, localframe.lambda$Fn2);
          if (!bool2) {
            label178:
            do
            {
              Object[] arrayOfObject2 = new Object[3];
              arrayOfObject2[0] = localframe.proc;
              arrayOfObject2[1] = localframe.start;
              arrayOfObject2[2] = localframe.s;
              return misc.error$V("Illegal substring START spec", arrayOfObject2);
            } while (!bool1);
          }
        }
      }
      Object[] arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = LList.Empty;
      arrayOfObject1[1] = Lit0;
      arrayOfObject1[2] = Integer.valueOf(localframe.slen);
      return misc.values(arrayOfObject1);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "string-length", 1, localObject1);
    }
  }
  
  public static Object stringPrefixLength$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame11 localframe11 = new frame11();
    localframe11.s1 = paramObject1;
    localframe11.s2 = paramObject2;
    localframe11.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe11.lambda$Fn28, localframe11.lambda$Fn29);
  }
  
  public static Object stringPrefixLengthCi$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame15 localframe15 = new frame15();
    localframe15.s1 = paramObject1;
    localframe15.s2 = paramObject2;
    localframe15.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe15.lambda$Fn36, localframe15.lambda$Fn37);
  }
  
  public static Object stringReplace$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object[] paramArrayOfObject)
  {
    frame92 localframe92 = new frame92();
    localframe92.s1 = paramObject1;
    localframe92.s2 = paramObject2;
    localframe92.start1 = paramObject3;
    localframe92.end1 = paramObject4;
    localframe92.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    checkSubstringSpec(string$Mnreplace, localframe92.s1, localframe92.start1, localframe92.end1);
    return call_with_values.callWithValues(localframe92.lambda$Fn206, localframe92.lambda$Fn207);
  }
  
  public static Object stringReverse$Ex$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame90 localframe90 = new frame90();
    localframe90.s = paramObject;
    localframe90.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe90.lambda$Fn202, localframe90.lambda$Fn203);
  }
  
  public static Object stringReverse$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame89 localframe89 = new frame89();
    localframe89.s = paramObject;
    localframe89.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe89.lambda$Fn200, localframe89.lambda$Fn201);
  }
  
  public static Object stringSkip$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame79 localframe79 = new frame79();
    localframe79.str = paramObject1;
    localframe79.criterion = paramObject2;
    localframe79.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe79.lambda$Fn181, localframe79.lambda$Fn182);
  }
  
  public static Object stringSkipRight$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame80 localframe80 = new frame80();
    localframe80.str = paramObject1;
    localframe80.criterion = paramObject2;
    localframe80.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe80.lambda$Fn183, localframe80.lambda$Fn184);
  }
  
  public static Object stringSuffixLength$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame13 localframe13 = new frame13();
    localframe13.s1 = paramObject1;
    localframe13.s2 = paramObject2;
    localframe13.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe13.lambda$Fn32, localframe13.lambda$Fn33);
  }
  
  public static Object stringSuffixLengthCi$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame17 localframe17 = new frame17();
    localframe17.s1 = paramObject1;
    localframe17.s2 = paramObject2;
    localframe17.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe17.lambda$Fn40, localframe17.lambda$Fn41);
  }
  
  /* Error */
  public static CharSequence stringTabulate(Object paramObject, int paramInt)
  {
    // Byte code:
    //   0: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   3: astore_2
    //   4: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   7: astore_3
    //   8: aload_3
    //   9: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   12: astore 5
    //   14: aload_2
    //   15: aload 5
    //   17: getstatic 2016	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   20: aload_0
    //   21: getstatic 1392	gnu/kawa/slib/srfi13:string$Mntabulate	Lgnu/expr/ModuleMethod;
    //   24: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   27: pop
    //   28: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   31: astore 7
    //   33: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   36: astore 8
    //   38: aload 8
    //   40: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   43: astore 10
    //   45: aload 7
    //   47: aload 10
    //   49: getstatic 1390	gnu/kawa/slib/srfi13:lambda$Fn27	Lgnu/expr/ModuleMethod;
    //   52: iload_1
    //   53: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: getstatic 1392	gnu/kawa/slib/srfi13:string$Mntabulate	Lgnu/expr/ModuleMethod;
    //   59: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: iload_1
    //   64: invokestatic 384	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   67: astore 12
    //   69: iload_1
    //   70: iconst_1
    //   71: isub
    //   72: istore 13
    //   74: iload 13
    //   76: iflt +119 -> 195
    //   79: aload 12
    //   81: checkcast 531	gnu/lists/CharSeq
    //   84: astore 15
    //   86: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   89: aload_0
    //   90: iload 13
    //   92: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   98: astore 16
    //   100: aload 16
    //   102: checkcast 458	gnu/text/Char
    //   105: invokevirtual 575	gnu/text/Char:charValue	()C
    //   108: istore 18
    //   110: aload 15
    //   112: iload 13
    //   114: iload 18
    //   116: invokestatic 535	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   119: iinc 13 255
    //   122: goto -48 -> 74
    //   125: astore 4
    //   127: aload 4
    //   129: ldc_w 627
    //   132: sipush 534
    //   135: iconst_3
    //   136: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   139: aload 4
    //   141: athrow
    //   142: astore 9
    //   144: aload 9
    //   146: ldc_w 627
    //   149: sipush 535
    //   152: iconst_3
    //   153: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   156: aload 9
    //   158: athrow
    //   159: astore 14
    //   161: new 412	gnu/mapping/WrongType
    //   164: dup
    //   165: aload 14
    //   167: ldc_w 537
    //   170: iconst_1
    //   171: aload 12
    //   173: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   176: athrow
    //   177: astore 17
    //   179: new 412	gnu/mapping/WrongType
    //   182: dup
    //   183: aload 17
    //   185: ldc_w 537
    //   188: iconst_3
    //   189: aload 16
    //   191: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   194: athrow
    //   195: aload 12
    //   197: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramObject	Object
    //   0	198	1	paramInt	int
    //   3	12	2	localApplyToArgs1	ApplyToArgs
    //   7	2	3	localLocation1	Location
    //   125	15	4	localUnboundLocationException1	UnboundLocationException
    //   12	4	5	localObject1	Object
    //   31	15	7	localApplyToArgs2	ApplyToArgs
    //   36	3	8	localLocation2	Location
    //   142	15	9	localUnboundLocationException2	UnboundLocationException
    //   43	5	10	localObject2	Object
    //   67	129	12	localCharSequence	CharSequence
    //   72	48	13	i	int
    //   159	7	14	localClassCastException1	ClassCastException
    //   84	27	15	localCharSeq	CharSeq
    //   98	92	16	localObject3	Object
    //   177	7	17	localClassCastException2	ClassCastException
    //   108	7	18	c	char
    // Exception table:
    //   from	to	target	type
    //   8	14	125	gnu/mapping/UnboundLocationException
    //   38	45	142	gnu/mapping/UnboundLocationException
    //   79	86	159	java/lang/ClassCastException
    //   100	110	177	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringTake(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: new 2615	gnu/kawa/slib/srfi13$frame64
    //   3: dup
    //   4: invokespecial 2616	gnu/kawa/slib/srfi13$frame64:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: putfield 2617	gnu/kawa/slib/srfi13$frame64:s	Ljava/lang/Object;
    //   13: aload_2
    //   14: aload_1
    //   15: putfield 2618	gnu/kawa/slib/srfi13$frame64:n	Ljava/lang/Object;
    //   18: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   21: astore_3
    //   22: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   25: astore 4
    //   27: aload 4
    //   29: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   32: astore 6
    //   34: aload_3
    //   35: aload 6
    //   37: getstatic 2621	kawa/lib/strings:string$Qu	Lgnu/expr/ModuleMethod;
    //   40: aload_2
    //   41: getfield 2617	gnu/kawa/slib/srfi13$frame64:s	Ljava/lang/Object;
    //   44: getstatic 1555	gnu/kawa/slib/srfi13:string$Mntake	Lgnu/expr/ModuleMethod;
    //   47: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   54: astore 8
    //   56: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   59: astore 9
    //   61: aload 9
    //   63: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   66: astore 11
    //   68: aload 8
    //   70: aload 11
    //   72: aload_2
    //   73: getfield 2624	gnu/kawa/slib/srfi13$frame64:lambda$Fn151	Lgnu/expr/ModuleMethod;
    //   76: aload_2
    //   77: getfield 2618	gnu/kawa/slib/srfi13$frame64:n	Ljava/lang/Object;
    //   80: getstatic 1555	gnu/kawa/slib/srfi13:string$Mntake	Lgnu/expr/ModuleMethod;
    //   83: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: pop
    //   87: aload_2
    //   88: getfield 2617	gnu/kawa/slib/srfi13$frame64:s	Ljava/lang/Object;
    //   91: astore 13
    //   93: aload 13
    //   95: checkcast 386	java/lang/CharSequence
    //   98: astore 15
    //   100: aload_2
    //   101: getfield 2618	gnu/kawa/slib/srfi13$frame64:n	Ljava/lang/Object;
    //   104: astore 16
    //   106: aload 16
    //   108: checkcast 376	java/lang/Number
    //   111: invokevirtual 380	java/lang/Number:intValue	()I
    //   114: istore 18
    //   116: aload 15
    //   118: iconst_0
    //   119: iload 18
    //   121: invokestatic 2168	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   124: areturn
    //   125: astore 5
    //   127: aload 5
    //   129: ldc_w 627
    //   132: sipush 995
    //   135: iconst_3
    //   136: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   139: aload 5
    //   141: athrow
    //   142: astore 10
    //   144: aload 10
    //   146: ldc_w 627
    //   149: sipush 996
    //   152: iconst_3
    //   153: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   156: aload 10
    //   158: athrow
    //   159: astore 14
    //   161: new 412	gnu/mapping/WrongType
    //   164: dup
    //   165: aload 14
    //   167: ldc_w 1037
    //   170: iconst_0
    //   171: aload 13
    //   173: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   176: athrow
    //   177: astore 17
    //   179: new 412	gnu/mapping/WrongType
    //   182: dup
    //   183: aload 17
    //   185: ldc_w 1037
    //   188: iconst_2
    //   189: aload 16
    //   191: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   194: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramObject1	Object
    //   0	195	1	paramObject2	Object
    //   7	94	2	localframe64	frame64
    //   21	14	3	localApplyToArgs1	ApplyToArgs
    //   25	3	4	localLocation1	Location
    //   125	15	5	localUnboundLocationException1	UnboundLocationException
    //   32	4	6	localObject1	Object
    //   54	15	8	localApplyToArgs2	ApplyToArgs
    //   59	3	9	localLocation2	Location
    //   142	15	10	localUnboundLocationException2	UnboundLocationException
    //   66	5	11	localObject2	Object
    //   91	81	13	localObject3	Object
    //   159	7	14	localClassCastException1	ClassCastException
    //   98	19	15	localCharSequence	CharSequence
    //   104	86	16	localObject4	Object
    //   177	7	17	localClassCastException2	ClassCastException
    //   114	6	18	i	int
    // Exception table:
    //   from	to	target	type
    //   27	34	125	gnu/mapping/UnboundLocationException
    //   61	68	142	gnu/mapping/UnboundLocationException
    //   93	100	159	java/lang/ClassCastException
    //   106	116	177	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringTakeRight(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: new 2627	gnu/kawa/slib/srfi13$frame65
    //   3: dup
    //   4: invokespecial 2628	gnu/kawa/slib/srfi13$frame65:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_1
    //   10: putfield 2629	gnu/kawa/slib/srfi13$frame65:n	Ljava/lang/Object;
    //   13: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   16: astore_3
    //   17: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   20: astore 4
    //   22: aload 4
    //   24: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   27: astore 6
    //   29: aload_3
    //   30: aload 6
    //   32: getstatic 2621	kawa/lib/strings:string$Qu	Lgnu/expr/ModuleMethod;
    //   35: aload_0
    //   36: getstatic 1557	gnu/kawa/slib/srfi13:string$Mntake$Mnright	Lgnu/expr/ModuleMethod;
    //   39: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   42: pop
    //   43: aload_0
    //   44: checkcast 386	java/lang/CharSequence
    //   47: astore 9
    //   49: aload_2
    //   50: aload 9
    //   52: invokestatic 347	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   55: putfield 2630	gnu/kawa/slib/srfi13$frame65:len	I
    //   58: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   61: astore 10
    //   63: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   66: astore 11
    //   68: aload 11
    //   70: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   73: astore 13
    //   75: aload 10
    //   77: aload 13
    //   79: aload_2
    //   80: getfield 2633	gnu/kawa/slib/srfi13$frame65:lambda$Fn152	Lgnu/expr/ModuleMethod;
    //   83: aload_2
    //   84: getfield 2629	gnu/kawa/slib/srfi13$frame65:n	Ljava/lang/Object;
    //   87: getstatic 1557	gnu/kawa/slib/srfi13:string$Mntake$Mnright	Lgnu/expr/ModuleMethod;
    //   90: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: aload_0
    //   95: checkcast 386	java/lang/CharSequence
    //   98: astore 16
    //   100: getstatic 410	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   103: aload_2
    //   104: getfield 2630	gnu/kawa/slib/srfi13$frame65:len	I
    //   107: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: aload_2
    //   111: getfield 2629	gnu/kawa/slib/srfi13$frame65:n	Ljava/lang/Object;
    //   114: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   117: astore 17
    //   119: aload 17
    //   121: checkcast 376	java/lang/Number
    //   124: invokevirtual 380	java/lang/Number:intValue	()I
    //   127: istore 19
    //   129: aload 16
    //   131: iload 19
    //   133: aload_2
    //   134: getfield 2630	gnu/kawa/slib/srfi13$frame65:len	I
    //   137: invokestatic 2168	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   140: areturn
    //   141: astore 5
    //   143: aload 5
    //   145: ldc_w 627
    //   148: sipush 1002
    //   151: iconst_3
    //   152: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   155: aload 5
    //   157: athrow
    //   158: astore 8
    //   160: new 412	gnu/mapping/WrongType
    //   163: dup
    //   164: aload 8
    //   166: ldc_w 422
    //   169: iconst_1
    //   170: aload_0
    //   171: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   174: athrow
    //   175: astore 12
    //   177: aload 12
    //   179: ldc_w 627
    //   182: sipush 1004
    //   185: iconst_5
    //   186: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   189: aload 12
    //   191: athrow
    //   192: astore 15
    //   194: new 412	gnu/mapping/WrongType
    //   197: dup
    //   198: aload 15
    //   200: ldc_w 1037
    //   203: iconst_0
    //   204: aload_0
    //   205: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   208: athrow
    //   209: astore 18
    //   211: new 412	gnu/mapping/WrongType
    //   214: dup
    //   215: aload 18
    //   217: ldc_w 1037
    //   220: iconst_1
    //   221: aload 17
    //   223: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   226: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramObject1	Object
    //   0	227	1	paramObject2	Object
    //   7	127	2	localframe65	frame65
    //   16	14	3	localApplyToArgs1	ApplyToArgs
    //   20	3	4	localLocation1	Location
    //   141	15	5	localUnboundLocationException1	UnboundLocationException
    //   27	4	6	localObject1	Object
    //   158	7	8	localClassCastException1	ClassCastException
    //   47	4	9	localCharSequence1	CharSequence
    //   61	15	10	localApplyToArgs2	ApplyToArgs
    //   66	3	11	localLocation2	Location
    //   175	15	12	localUnboundLocationException2	UnboundLocationException
    //   73	5	13	localObject2	Object
    //   192	7	15	localClassCastException2	ClassCastException
    //   98	32	16	localCharSequence2	CharSequence
    //   117	105	17	localObject3	Object
    //   209	7	18	localClassCastException3	ClassCastException
    //   127	5	19	i	int
    // Exception table:
    //   from	to	target	type
    //   22	29	141	gnu/mapping/UnboundLocationException
    //   43	49	158	java/lang/ClassCastException
    //   68	75	175	gnu/mapping/UnboundLocationException
    //   94	100	192	java/lang/ClassCastException
    //   119	129	209	java/lang/ClassCastException
  }
  
  public static Object stringTitlecase$Ex$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame62 localframe62 = new frame62();
    localframe62.s = paramObject;
    localframe62.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe62.lambda$Fn147, localframe62.lambda$Fn148);
  }
  
  public static Object stringTitlecase$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame63 localframe63 = new frame63();
    localframe63.s = paramObject;
    localframe63.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe63.lambda$Fn149, localframe63.lambda$Fn150);
  }
  
  /* Error */
  public static Object stringTokenize$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 2660	gnu/kawa/slib/srfi13$frame93
    //   3: dup
    //   4: invokespecial 2661	gnu/kawa/slib/srfi13$frame93:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: putfield 2662	gnu/kawa/slib/srfi13$frame93:s	Ljava/lang/Object;
    //   13: aload_1
    //   14: iconst_0
    //   15: invokestatic 1687	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   18: astore_3
    //   19: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   22: astore 4
    //   24: getstatic 1276	gnu/kawa/slib/srfi13:loc$let$Mnoptionals$St	Lgnu/mapping/Location;
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   34: astore 7
    //   36: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   39: astore 8
    //   41: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   44: astore 9
    //   46: getstatic 1308	gnu/kawa/slib/srfi13:loc$token$Mnchars	Lgnu/mapping/Location;
    //   49: astore 10
    //   51: aload 10
    //   53: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   56: astore 12
    //   58: getstatic 2668	gnu/kawa/functions/GetNamedPart:getNamedPart	Lgnu/kawa/functions/GetNamedPart;
    //   61: astore 13
    //   63: getstatic 1292	gnu/kawa/slib/srfi13:loc$char$Mnset	Lgnu/mapping/Location;
    //   66: astore 14
    //   68: aload 14
    //   70: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   73: astore 16
    //   75: aload 13
    //   77: aload 16
    //   79: getstatic 1234	gnu/kawa/slib/srfi13:Lit14	Lgnu/mapping/SimpleSymbol;
    //   82: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: astore 17
    //   87: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   90: astore 18
    //   92: getstatic 1282	gnu/kawa/slib/srfi13:loc$char$Mnset$Qu	Lgnu/mapping/Location;
    //   95: astore 19
    //   97: aload 19
    //   99: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   102: astore 21
    //   104: getstatic 1308	gnu/kawa/slib/srfi13:loc$token$Mnchars	Lgnu/mapping/Location;
    //   107: astore 22
    //   109: aload 22
    //   111: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   114: astore 24
    //   116: aload 9
    //   118: aload 12
    //   120: aload 17
    //   122: aload 18
    //   124: aload 21
    //   126: aload 24
    //   128: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   131: invokevirtual 466	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   134: astore 25
    //   136: getstatic 1288	gnu/kawa/slib/srfi13:loc$rest	Lgnu/mapping/Location;
    //   139: astore 26
    //   141: aload 26
    //   143: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   146: astore 28
    //   148: aload 4
    //   150: aload 7
    //   152: aload_3
    //   153: aload 8
    //   155: aload 25
    //   157: aload 28
    //   159: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   162: aload_2
    //   163: getfield 2671	gnu/kawa/slib/srfi13$frame93:lambda$Fn208	Lgnu/expr/ModuleMethod;
    //   166: aload_2
    //   167: getfield 2674	gnu/kawa/slib/srfi13$frame93:lambda$Fn209	Lgnu/expr/ModuleMethod;
    //   170: invokestatic 1702	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   173: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: areturn
    //   177: astore 6
    //   179: aload 6
    //   181: ldc_w 627
    //   184: sipush 1694
    //   187: iconst_3
    //   188: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   191: aload 6
    //   193: athrow
    //   194: astore 11
    //   196: aload 11
    //   198: ldc_w 627
    //   201: sipush 1695
    //   204: bipush 20
    //   206: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   209: aload 11
    //   211: athrow
    //   212: astore 15
    //   214: aload 15
    //   216: ldc_w 627
    //   219: sipush 1695
    //   222: bipush 33
    //   224: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   227: aload 15
    //   229: athrow
    //   230: astore 20
    //   232: aload 20
    //   234: ldc_w 627
    //   237: sipush 1695
    //   240: bipush 50
    //   242: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   245: aload 20
    //   247: athrow
    //   248: astore 23
    //   250: aload 23
    //   252: ldc_w 627
    //   255: sipush 1695
    //   258: bipush 61
    //   260: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   263: aload 23
    //   265: athrow
    //   266: astore 27
    //   268: aload 27
    //   270: ldc_w 627
    //   273: sipush 1695
    //   276: bipush 75
    //   278: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   281: aload 27
    //   283: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	paramObject	Object
    //   0	284	1	paramArrayOfObject	Object[]
    //   7	160	2	localframe93	frame93
    //   18	135	3	localLList	LList
    //   22	127	4	localApplyToArgs1	ApplyToArgs
    //   27	3	5	localLocation1	Location
    //   177	15	6	localUnboundLocationException1	UnboundLocationException
    //   34	117	7	localObject1	Object
    //   39	115	8	localApplyToArgs2	ApplyToArgs
    //   44	73	9	localApplyToArgs3	ApplyToArgs
    //   49	3	10	localLocation2	Location
    //   194	16	11	localUnboundLocationException2	UnboundLocationException
    //   56	63	12	localObject2	Object
    //   61	15	13	localGetNamedPart	gnu.kawa.functions.GetNamedPart
    //   66	3	14	localLocation3	Location
    //   212	16	15	localUnboundLocationException3	UnboundLocationException
    //   73	5	16	localObject3	Object
    //   85	36	17	localObject4	Object
    //   90	33	18	localApplyToArgs4	ApplyToArgs
    //   95	3	19	localLocation4	Location
    //   230	16	20	localUnboundLocationException4	UnboundLocationException
    //   102	23	21	localObject5	Object
    //   107	3	22	localLocation5	Location
    //   248	16	23	localUnboundLocationException5	UnboundLocationException
    //   114	13	24	localObject6	Object
    //   134	22	25	localObject7	Object
    //   139	3	26	localLocation6	Location
    //   266	16	27	localUnboundLocationException6	UnboundLocationException
    //   146	12	28	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   29	36	177	gnu/mapping/UnboundLocationException
    //   51	58	194	gnu/mapping/UnboundLocationException
    //   68	75	212	gnu/mapping/UnboundLocationException
    //   97	104	230	gnu/mapping/UnboundLocationException
    //   109	116	248	gnu/mapping/UnboundLocationException
    //   141	148	266	gnu/mapping/UnboundLocationException
  }
  
  /* Error */
  public static Object stringTrim$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 2677	gnu/kawa/slib/srfi13$frame68
    //   3: dup
    //   4: invokespecial 2678	gnu/kawa/slib/srfi13$frame68:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: putfield 2679	gnu/kawa/slib/srfi13$frame68:s	Ljava/lang/Object;
    //   13: aload_1
    //   14: iconst_0
    //   15: invokestatic 1687	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   18: astore_3
    //   19: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   22: astore 4
    //   24: getstatic 1276	gnu/kawa/slib/srfi13:loc$let$Mnoptionals$St	Lgnu/mapping/Location;
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   34: astore 7
    //   36: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   39: astore 8
    //   41: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   44: astore 9
    //   46: getstatic 1290	gnu/kawa/slib/srfi13:loc$criterion	Lgnu/mapping/Location;
    //   49: astore 10
    //   51: aload 10
    //   53: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   56: astore 12
    //   58: getstatic 2668	gnu/kawa/functions/GetNamedPart:getNamedPart	Lgnu/kawa/functions/GetNamedPart;
    //   61: astore 13
    //   63: getstatic 1292	gnu/kawa/slib/srfi13:loc$char$Mnset	Lgnu/mapping/Location;
    //   66: astore 14
    //   68: aload 14
    //   70: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   73: astore 16
    //   75: aload 9
    //   77: aload 12
    //   79: aload 13
    //   81: aload 16
    //   83: getstatic 1245	gnu/kawa/slib/srfi13:Lit11	Lgnu/mapping/SimpleSymbol;
    //   86: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore 17
    //   94: getstatic 1288	gnu/kawa/slib/srfi13:loc$rest	Lgnu/mapping/Location;
    //   97: astore 18
    //   99: aload 18
    //   101: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   104: astore 20
    //   106: aload 4
    //   108: aload 7
    //   110: aload_3
    //   111: aload 8
    //   113: aload 17
    //   115: aload 20
    //   117: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   120: aload_2
    //   121: getfield 2682	gnu/kawa/slib/srfi13$frame68:lambda$Fn155	Lgnu/expr/ModuleMethod;
    //   124: aload_2
    //   125: getfield 2685	gnu/kawa/slib/srfi13$frame68:lambda$Fn156	Lgnu/expr/ModuleMethod;
    //   128: invokestatic 1702	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   131: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   134: areturn
    //   135: astore 6
    //   137: aload 6
    //   139: ldc_w 627
    //   142: sipush 1022
    //   145: iconst_3
    //   146: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   149: aload 6
    //   151: athrow
    //   152: astore 11
    //   154: aload 11
    //   156: ldc_w 627
    //   159: sipush 1022
    //   162: bipush 40
    //   164: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   167: aload 11
    //   169: athrow
    //   170: astore 15
    //   172: aload 15
    //   174: ldc_w 627
    //   177: sipush 1022
    //   180: bipush 51
    //   182: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   185: aload 15
    //   187: athrow
    //   188: astore 19
    //   190: aload 19
    //   192: ldc_w 627
    //   195: sipush 1022
    //   198: bipush 72
    //   200: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   203: aload 19
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramObject	Object
    //   0	206	1	paramArrayOfObject	Object[]
    //   7	118	2	localframe68	frame68
    //   18	93	3	localLList	LList
    //   22	85	4	localApplyToArgs1	ApplyToArgs
    //   27	3	5	localLocation1	Location
    //   135	15	6	localUnboundLocationException1	UnboundLocationException
    //   34	75	7	localObject1	Object
    //   39	73	8	localApplyToArgs2	ApplyToArgs
    //   44	32	9	localApplyToArgs3	ApplyToArgs
    //   49	3	10	localLocation2	Location
    //   152	16	11	localUnboundLocationException2	UnboundLocationException
    //   56	22	12	localObject2	Object
    //   61	19	13	localGetNamedPart	gnu.kawa.functions.GetNamedPart
    //   66	3	14	localLocation3	Location
    //   170	16	15	localUnboundLocationException3	UnboundLocationException
    //   73	9	16	localObject3	Object
    //   92	22	17	localObject4	Object
    //   97	3	18	localLocation4	Location
    //   188	16	19	localUnboundLocationException4	UnboundLocationException
    //   104	12	20	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   29	36	135	gnu/mapping/UnboundLocationException
    //   51	58	152	gnu/mapping/UnboundLocationException
    //   68	75	170	gnu/mapping/UnboundLocationException
    //   99	106	188	gnu/mapping/UnboundLocationException
  }
  
  /* Error */
  public static Object stringTrimBoth$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 2688	gnu/kawa/slib/srfi13$frame70
    //   3: dup
    //   4: invokespecial 2689	gnu/kawa/slib/srfi13$frame70:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: putfield 2690	gnu/kawa/slib/srfi13$frame70:s	Ljava/lang/Object;
    //   13: aload_1
    //   14: iconst_0
    //   15: invokestatic 1687	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   18: astore_3
    //   19: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   22: astore 4
    //   24: getstatic 1276	gnu/kawa/slib/srfi13:loc$let$Mnoptionals$St	Lgnu/mapping/Location;
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   34: astore 7
    //   36: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   39: astore 8
    //   41: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   44: astore 9
    //   46: getstatic 1290	gnu/kawa/slib/srfi13:loc$criterion	Lgnu/mapping/Location;
    //   49: astore 10
    //   51: aload 10
    //   53: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   56: astore 12
    //   58: getstatic 2668	gnu/kawa/functions/GetNamedPart:getNamedPart	Lgnu/kawa/functions/GetNamedPart;
    //   61: astore 13
    //   63: getstatic 1292	gnu/kawa/slib/srfi13:loc$char$Mnset	Lgnu/mapping/Location;
    //   66: astore 14
    //   68: aload 14
    //   70: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   73: astore 16
    //   75: aload 9
    //   77: aload 12
    //   79: aload 13
    //   81: aload 16
    //   83: getstatic 1245	gnu/kawa/slib/srfi13:Lit11	Lgnu/mapping/SimpleSymbol;
    //   86: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore 17
    //   94: getstatic 1288	gnu/kawa/slib/srfi13:loc$rest	Lgnu/mapping/Location;
    //   97: astore 18
    //   99: aload 18
    //   101: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   104: astore 20
    //   106: aload 4
    //   108: aload 7
    //   110: aload_3
    //   111: aload 8
    //   113: aload 17
    //   115: aload 20
    //   117: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   120: aload_2
    //   121: getfield 2693	gnu/kawa/slib/srfi13$frame70:lambda$Fn159	Lgnu/expr/ModuleMethod;
    //   124: aload_2
    //   125: getfield 2696	gnu/kawa/slib/srfi13$frame70:lambda$Fn160	Lgnu/expr/ModuleMethod;
    //   128: invokestatic 1702	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   131: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   134: areturn
    //   135: astore 6
    //   137: aload 6
    //   139: ldc_w 627
    //   142: sipush 1036
    //   145: iconst_3
    //   146: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   149: aload 6
    //   151: athrow
    //   152: astore 11
    //   154: aload 11
    //   156: ldc_w 627
    //   159: sipush 1036
    //   162: bipush 40
    //   164: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   167: aload 11
    //   169: athrow
    //   170: astore 15
    //   172: aload 15
    //   174: ldc_w 627
    //   177: sipush 1036
    //   180: bipush 51
    //   182: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   185: aload 15
    //   187: athrow
    //   188: astore 19
    //   190: aload 19
    //   192: ldc_w 627
    //   195: sipush 1036
    //   198: bipush 72
    //   200: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   203: aload 19
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramObject	Object
    //   0	206	1	paramArrayOfObject	Object[]
    //   7	118	2	localframe70	frame70
    //   18	93	3	localLList	LList
    //   22	85	4	localApplyToArgs1	ApplyToArgs
    //   27	3	5	localLocation1	Location
    //   135	15	6	localUnboundLocationException1	UnboundLocationException
    //   34	75	7	localObject1	Object
    //   39	73	8	localApplyToArgs2	ApplyToArgs
    //   44	32	9	localApplyToArgs3	ApplyToArgs
    //   49	3	10	localLocation2	Location
    //   152	16	11	localUnboundLocationException2	UnboundLocationException
    //   56	22	12	localObject2	Object
    //   61	19	13	localGetNamedPart	gnu.kawa.functions.GetNamedPart
    //   66	3	14	localLocation3	Location
    //   170	16	15	localUnboundLocationException3	UnboundLocationException
    //   73	9	16	localObject3	Object
    //   92	22	17	localObject4	Object
    //   97	3	18	localLocation4	Location
    //   188	16	19	localUnboundLocationException4	UnboundLocationException
    //   104	12	20	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   29	36	135	gnu/mapping/UnboundLocationException
    //   51	58	152	gnu/mapping/UnboundLocationException
    //   68	75	170	gnu/mapping/UnboundLocationException
    //   99	106	188	gnu/mapping/UnboundLocationException
  }
  
  /* Error */
  public static Object stringTrimRight$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 2699	gnu/kawa/slib/srfi13$frame69
    //   3: dup
    //   4: invokespecial 2700	gnu/kawa/slib/srfi13$frame69:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: putfield 2701	gnu/kawa/slib/srfi13$frame69:s	Ljava/lang/Object;
    //   13: aload_1
    //   14: iconst_0
    //   15: invokestatic 1687	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   18: astore_3
    //   19: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   22: astore 4
    //   24: getstatic 1276	gnu/kawa/slib/srfi13:loc$let$Mnoptionals$St	Lgnu/mapping/Location;
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   34: astore 7
    //   36: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   39: astore 8
    //   41: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   44: astore 9
    //   46: getstatic 1290	gnu/kawa/slib/srfi13:loc$criterion	Lgnu/mapping/Location;
    //   49: astore 10
    //   51: aload 10
    //   53: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   56: astore 12
    //   58: getstatic 2668	gnu/kawa/functions/GetNamedPart:getNamedPart	Lgnu/kawa/functions/GetNamedPart;
    //   61: astore 13
    //   63: getstatic 1292	gnu/kawa/slib/srfi13:loc$char$Mnset	Lgnu/mapping/Location;
    //   66: astore 14
    //   68: aload 14
    //   70: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   73: astore 16
    //   75: aload 9
    //   77: aload 12
    //   79: aload 13
    //   81: aload 16
    //   83: getstatic 1245	gnu/kawa/slib/srfi13:Lit11	Lgnu/mapping/SimpleSymbol;
    //   86: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore 17
    //   94: getstatic 1288	gnu/kawa/slib/srfi13:loc$rest	Lgnu/mapping/Location;
    //   97: astore 18
    //   99: aload 18
    //   101: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   104: astore 20
    //   106: aload 4
    //   108: aload 7
    //   110: aload_3
    //   111: aload 8
    //   113: aload 17
    //   115: aload 20
    //   117: invokevirtual 374	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   120: aload_2
    //   121: getfield 2704	gnu/kawa/slib/srfi13$frame69:lambda$Fn157	Lgnu/expr/ModuleMethod;
    //   124: aload_2
    //   125: getfield 2707	gnu/kawa/slib/srfi13$frame69:lambda$Fn158	Lgnu/expr/ModuleMethod;
    //   128: invokestatic 1702	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   131: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   134: areturn
    //   135: astore 6
    //   137: aload 6
    //   139: ldc_w 627
    //   142: sipush 1029
    //   145: iconst_3
    //   146: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   149: aload 6
    //   151: athrow
    //   152: astore 11
    //   154: aload 11
    //   156: ldc_w 627
    //   159: sipush 1029
    //   162: bipush 40
    //   164: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   167: aload 11
    //   169: athrow
    //   170: astore 15
    //   172: aload 15
    //   174: ldc_w 627
    //   177: sipush 1029
    //   180: bipush 51
    //   182: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   185: aload 15
    //   187: athrow
    //   188: astore 19
    //   190: aload 19
    //   192: ldc_w 627
    //   195: sipush 1029
    //   198: bipush 72
    //   200: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   203: aload 19
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramObject	Object
    //   0	206	1	paramArrayOfObject	Object[]
    //   7	118	2	localframe69	frame69
    //   18	93	3	localLList	LList
    //   22	85	4	localApplyToArgs1	ApplyToArgs
    //   27	3	5	localLocation1	Location
    //   135	15	6	localUnboundLocationException1	UnboundLocationException
    //   34	75	7	localObject1	Object
    //   39	73	8	localApplyToArgs2	ApplyToArgs
    //   44	32	9	localApplyToArgs3	ApplyToArgs
    //   49	3	10	localLocation2	Location
    //   152	16	11	localUnboundLocationException2	UnboundLocationException
    //   56	22	12	localObject2	Object
    //   61	19	13	localGetNamedPart	gnu.kawa.functions.GetNamedPart
    //   66	3	14	localLocation3	Location
    //   170	16	15	localUnboundLocationException3	UnboundLocationException
    //   73	9	16	localObject3	Object
    //   92	22	17	localObject4	Object
    //   97	3	18	localLocation4	Location
    //   188	16	19	localUnboundLocationException4	UnboundLocationException
    //   104	12	20	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   29	36	135	gnu/mapping/UnboundLocationException
    //   51	58	152	gnu/mapping/UnboundLocationException
    //   68	75	170	gnu/mapping/UnboundLocationException
    //   99	106	188	gnu/mapping/UnboundLocationException
  }
  
  public static Object stringUnfold$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object[] paramArrayOfObject)
  {
    localLList = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs1 = Scheme.applyToArgs;
    Location localLocation1 = loc$check$Mnarg;
    for (;;)
    {
      try
      {
        Object localObject1 = localLocation1.get();
        localApplyToArgs1.apply4(localObject1, misc.procedure$Qu, paramObject1, string$Mnunfold);
        localApplyToArgs2 = Scheme.applyToArgs;
        localLocation2 = loc$check$Mnarg;
      }
      catch (UnboundLocationException localUnboundLocationException1)
      {
        try
        {
          ApplyToArgs localApplyToArgs2;
          Location localLocation2;
          Object localObject2;
          ApplyToArgs localApplyToArgs3;
          Location localLocation3;
          Object localObject3;
          Location localLocation4;
          ApplyToArgs localApplyToArgs5;
          ApplyToArgs localApplyToArgs6;
          Location localLocation5;
          Object localObject5;
          Location localLocation6;
          Object localObject6;
          Boolean localBoolean1;
          Object localObject7;
          ApplyToArgs localApplyToArgs7;
          Location localLocation7;
          Object localObject8;
          ModuleMethod localModuleMethod;
          Location localLocation8;
          Object localObject9;
          Boolean localBoolean2;
          Object localObject11;
          int i;
          int j;
          int k;
          CharSeq localCharSeq2;
          int i8;
          char c2;
          int i6;
          Object[] arrayOfObject;
          localObject20 = localLocation11.get();
        }
        catch (UnboundLocationException localUnboundLocationException11)
        {
          ApplyToArgs localApplyToArgs4;
          Object localObject4;
          Object localObject10;
          Object localObject12;
          Object localObject13;
          Object localObject22;
          Object localObject23;
          CharSequence localCharSequence9;
          localUnboundLocationException11.setLine("srfi13.scm", 416, 29);
          throw localUnboundLocationException11;
        }
        try
        {
          localCharSequence6 = (CharSequence)localObject20;
          $PcStringCopy$Ex(localCharSequence3, 0, localCharSequence6, 0, n);
          return localApplyToArgs4.apply4(localObject4, localLList, localObject10, localCharSequence3);
        }
        catch (ClassCastException localClassCastException8)
        {
          WrongType localWrongType8 = new WrongType(localClassCastException8, "%string-copy!", 2, localObject20);
          throw localWrongType8;
        }
        localUnboundLocationException1 = localUnboundLocationException1;
        localUnboundLocationException1.setLine("srfi13.scm", 372, 3);
        throw localUnboundLocationException1;
      }
      try
      {
        localObject2 = localLocation2.get();
        localApplyToArgs2.apply4(localObject2, misc.procedure$Qu, paramObject2, string$Mnunfold);
        localApplyToArgs3 = Scheme.applyToArgs;
        localLocation3 = loc$check$Mnarg;
      }
      catch (UnboundLocationException localUnboundLocationException2)
      {
        localUnboundLocationException2.setLine("srfi13.scm", 373, 3);
        throw localUnboundLocationException2;
      }
      try
      {
        localObject3 = localLocation3.get();
        localApplyToArgs3.apply4(localObject3, misc.procedure$Qu, paramObject3, string$Mnunfold);
        localApplyToArgs4 = Scheme.applyToArgs;
        localLocation4 = loc$let$Mnoptionals$St;
      }
      catch (UnboundLocationException localUnboundLocationException3)
      {
        localUnboundLocationException3.setLine("srfi13.scm", 374, 3);
        throw localUnboundLocationException3;
      }
      try
      {
        localObject4 = localLocation4.get();
        localApplyToArgs5 = Scheme.applyToArgs;
        localApplyToArgs6 = Scheme.applyToArgs;
        localLocation5 = loc$base;
      }
      catch (UnboundLocationException localUnboundLocationException4)
      {
        localUnboundLocationException4.setLine("srfi13.scm", 375, 3);
        throw localUnboundLocationException4;
      }
      try
      {
        localObject5 = localLocation5.get();
        localLocation6 = loc$base;
      }
      catch (UnboundLocationException localUnboundLocationException5)
      {
        localUnboundLocationException5.setLine("srfi13.scm", 376, 20);
        throw localUnboundLocationException5;
      }
      try
      {
        localObject6 = localLocation6.get();
        if (strings.isString(localObject6))
        {
          localBoolean1 = Boolean.TRUE;
          localObject7 = localApplyToArgs6.apply3(localObject5, "", localBoolean1);
          localApplyToArgs7 = Scheme.applyToArgs;
          localLocation7 = loc$make$Mnfinal;
        }
      }
      catch (UnboundLocationException localUnboundLocationException6)
      {
        localUnboundLocationException6.setLine("srfi13.scm", 376, 57);
        throw localUnboundLocationException6;
      }
      try
      {
        localObject8 = localLocation7.get();
        localModuleMethod = lambda$Fn17;
        localLocation8 = loc$make$Mnfinal;
      }
      catch (UnboundLocationException localUnboundLocationException7)
      {
        localUnboundLocationException7.setLine("srfi13.scm", 377, 6);
        throw localUnboundLocationException7;
      }
      try
      {
        localObject9 = localLocation8.get();
        if (misc.isProcedure(localObject9))
        {
          localBoolean2 = Boolean.TRUE;
          localObject10 = localApplyToArgs5.apply2(localObject7, localApplyToArgs7.apply3(localObject8, localModuleMethod, localBoolean2));
          localObject11 = LList.Empty;
          i = 0;
          localObject12 = strings.makeString(40);
          j = 40;
          k = 0;
          localObject13 = Integer.valueOf(k);
          if (Scheme.applyToArgs.apply2(paramObject1, paramObject4) != Boolean.FALSE) {
            continue;
          }
          localObject22 = Scheme.applyToArgs.apply2(paramObject2, paramObject4);
          paramObject4 = Scheme.applyToArgs.apply2(paramObject3, paramObject4);
          if (Scheme.numLss.apply2(localObject13, Integer.valueOf(j)) == Boolean.FALSE) {
            continue;
          }
        }
      }
      catch (UnboundLocationException localUnboundLocationException8)
      {
        localUnboundLocationException8.setLine("srfi13.scm", 377, 46);
        throw localUnboundLocationException8;
      }
      try
      {
        localCharSeq2 = (CharSeq)localObject12;
      }
      catch (ClassCastException localClassCastException15)
      {
        localWrongType15 = new WrongType(localClassCastException15, "string-set!", 1, localObject12);
        throw localWrongType15;
      }
      try
      {
        i8 = ((Number)localObject13).intValue();
      }
      catch (ClassCastException localClassCastException16)
      {
        localWrongType16 = new WrongType(localClassCastException16, "string-set!", 2, localObject13);
        throw localWrongType16;
      }
      try
      {
        c2 = ((Char)localObject22).charValue();
        strings.stringSet$Ex(localCharSeq2, i8, c2);
        localObject13 = AddOp.$Pl.apply2(localObject13, Lit1);
      }
      catch (ClassCastException localClassCastException17)
      {
        localWrongType17 = new WrongType(localClassCastException17, "string-set!", 3, localObject22);
        throw localWrongType17;
      }
      localBoolean1 = Boolean.FALSE;
      continue;
      localBoolean2 = Boolean.FALSE;
      continue;
      i6 = j + i;
      arrayOfObject = new Object[2];
      arrayOfObject[0] = Lit2;
      arrayOfObject[1] = Integer.valueOf(i6);
      localObject23 = numbers.min(arrayOfObject);
      try
      {
        i7 = ((Number)localObject23).intValue();
        localCharSequence9 = strings.makeString(i7);
      }
      catch (ClassCastException localClassCastException12)
      {
        int i7;
        CharSeq localCharSeq1;
        char c1;
        ApplyToArgs localApplyToArgs8;
        Location localLocation9;
        localWrongType12 = new WrongType(localClassCastException12, "chunk-len2", -2, localObject23);
        throw localWrongType12;
      }
      try
      {
        localCharSeq1 = (CharSeq)localCharSequence9;
      }
      catch (ClassCastException localClassCastException13)
      {
        localWrongType13 = new WrongType(localClassCastException13, "string-set!", 1, localCharSequence9);
        throw localWrongType13;
      }
      try
      {
        c1 = ((Char)localObject22).charValue();
        strings.stringSet$Ex(localCharSeq1, 0, c1);
        localObject11 = lists.cons(localObject12, localObject11);
        i += j;
        k = 1;
        j = i7;
        localObject12 = localCharSequence9;
      }
      catch (ClassCastException localClassCastException14)
      {
        localWrongType14 = new WrongType(localClassCastException14, "string-set!", 3, localObject22);
        throw localWrongType14;
      }
    }
    localApplyToArgs8 = Scheme.applyToArgs;
    localLocation9 = loc$make$Mnfinal;
    for (;;)
    {
      Object localObject15;
      Object localObject16;
      Object localObject17;
      Object localObject18;
      Object localObject19;
      Object localObject21;
      try
      {
        Object localObject14 = localLocation9.get();
        localObject15 = localApplyToArgs8.apply2(localObject14, paramObject4);
      }
      catch (UnboundLocationException localUnboundLocationException9)
      {
        CharSequence localCharSequence1;
        int m;
        Location localLocation10;
        CharSequence localCharSequence2;
        int n;
        int i1;
        CharSequence localCharSequence3;
        CharSequence localCharSequence4;
        int i2;
        CharSequence localCharSequence5;
        int i3;
        CharSequence localCharSequence7;
        int i4;
        AddOp localAddOp;
        Integer localInteger;
        int i5;
        CharSequence localCharSequence8;
        Location localLocation11;
        CharSequence localCharSequence6;
        WrongType localWrongType15;
        WrongType localWrongType16;
        WrongType localWrongType17;
        WrongType localWrongType12;
        WrongType localWrongType13;
        WrongType localWrongType14;
        localUnboundLocationException9.setLine("srfi13.scm", 400, 20);
        throw localUnboundLocationException9;
      }
      try
      {
        localCharSequence1 = (CharSequence)localObject15;
        m = strings.stringLength(localCharSequence1);
        localLocation10 = loc$base;
      }
      catch (ClassCastException localClassCastException1)
      {
        WrongType localWrongType1 = new WrongType(localClassCastException1, "string-length", 1, localObject15);
        throw localWrongType1;
      }
      try
      {
        localObject16 = localLocation10.get();
      }
      catch (UnboundLocationException localUnboundLocationException10)
      {
        localUnboundLocationException10.setLine("srfi13.scm", 402, 38);
        throw localUnboundLocationException10;
      }
      try
      {
        localCharSequence2 = (CharSequence)localObject16;
        n = strings.stringLength(localCharSequence2);
        localObject17 = AddOp.$Pl.apply2(Integer.valueOf(n + i), localObject13);
      }
      catch (ClassCastException localClassCastException2)
      {
        WrongType localWrongType2 = new WrongType(localClassCastException2, "string-length", 1, localObject16);
        throw localWrongType2;
      }
      try
      {
        i1 = ((Number)localObject17).intValue();
        localCharSequence3 = strings.makeString(i1 + m);
      }
      catch (ClassCastException localClassCastException3)
      {
        WrongType localWrongType3 = new WrongType(localClassCastException3, "j", -2, localObject17);
        throw localWrongType3;
      }
      try
      {
        localCharSequence4 = (CharSequence)localObject15;
        $PcStringCopy$Ex(localCharSequence3, i1, localCharSequence4, 0, m);
        localObject18 = AddOp.$Mn.apply2(Integer.valueOf(i1), localObject13);
      }
      catch (ClassCastException localClassCastException4)
      {
        WrongType localWrongType4 = new WrongType(localClassCastException4, "%string-copy!", 2, localObject15);
        throw localWrongType4;
      }
      try
      {
        i2 = ((Number)localObject18).intValue();
      }
      catch (ClassCastException localClassCastException5)
      {
        WrongType localWrongType5 = new WrongType(localClassCastException5, "j", -2, localObject18);
        throw localWrongType5;
      }
      try
      {
        localCharSequence5 = (CharSequence)localObject12;
      }
      catch (ClassCastException localClassCastException6)
      {
        WrongType localWrongType6 = new WrongType(localClassCastException6, "%string-copy!", 2, localObject12);
        throw localWrongType6;
      }
      try
      {
        i3 = ((Number)localObject13).intValue();
        $PcStringCopy$Ex(localCharSequence3, i2, localCharSequence5, 0, i3);
        localObject19 = Integer.valueOf(i2);
        if (lists.isPair(localObject11))
        {
          localObject21 = lists.car.apply1(localObject11);
          localObject11 = lists.cdr.apply1(localObject11);
        }
      }
      catch (ClassCastException localClassCastException7)
      {
        WrongType localWrongType7 = new WrongType(localClassCastException7, "%string-copy!", 4, localObject13);
        throw localWrongType7;
      }
      try
      {
        localCharSequence7 = (CharSequence)localObject21;
        i4 = strings.stringLength(localCharSequence7);
        localAddOp = AddOp.$Mn;
        localInteger = Integer.valueOf(i4);
        localObject19 = localAddOp.apply2(localObject19, localInteger);
      }
      catch (ClassCastException localClassCastException9)
      {
        WrongType localWrongType9 = new WrongType(localClassCastException9, "string-length", 1, localObject21);
        throw localWrongType9;
      }
      try
      {
        i5 = ((Number)localObject19).intValue();
      }
      catch (ClassCastException localClassCastException10)
      {
        WrongType localWrongType10 = new WrongType(localClassCastException10, "%string-copy!", 1, localObject19);
        throw localWrongType10;
      }
      try
      {
        localCharSequence8 = (CharSequence)localObject21;
        $PcStringCopy$Ex(localCharSequence3, i5, localCharSequence8, 0, i4);
      }
      catch (ClassCastException localClassCastException11)
      {
        WrongType localWrongType11 = new WrongType(localClassCastException11, "%string-copy!", 2, localObject21);
        throw localWrongType11;
      }
    }
    localLocation11 = loc$base;
  }
  
  public static Object stringUnfoldRight$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object[] paramArrayOfObject)
  {
    localLList = LList.makeList(paramArrayOfObject, 0);
    localApplyToArgs1 = Scheme.applyToArgs;
    Location localLocation1 = loc$let$Mnoptionals$St;
    for (;;)
    {
      try
      {
        localObject1 = localLocation1.get();
        localApplyToArgs2 = Scheme.applyToArgs;
        localApplyToArgs3 = Scheme.applyToArgs;
        localLocation2 = loc$base;
      }
      catch (UnboundLocationException localUnboundLocationException1)
      {
        try
        {
          ApplyToArgs localApplyToArgs2;
          ApplyToArgs localApplyToArgs3;
          Location localLocation2;
          Object localObject2;
          Location localLocation3;
          Object localObject3;
          Boolean localBoolean1;
          Object localObject4;
          ApplyToArgs localApplyToArgs4;
          Location localLocation4;
          Object localObject5;
          ModuleMethod localModuleMethod;
          Location localLocation5;
          Object localObject6;
          Boolean localBoolean2;
          CharSeq localCharSeq2;
          int i6;
          char c2;
          Object localObject23;
          Object[] arrayOfObject;
          localObject13 = localLocation6.get();
          localObject14 = localApplyToArgs5.apply2(localObject13, paramObject4);
        }
        catch (UnboundLocationException localUnboundLocationException6)
        {
          Object localObject1;
          Object localObject7;
          Object localObject8;
          Object localObject9;
          Object localObject22;
          Object localObject24;
          CharSequence localCharSequence9;
          localUnboundLocationException6.setLine("srfi13.scm", 447, 20);
          throw localUnboundLocationException6;
        }
        try
        {
          localCharSequence1 = (CharSequence)localObject14;
          i = strings.stringLength(localCharSequence1);
          localLocation7 = loc$base;
        }
        catch (ClassCastException localClassCastException1)
        {
          WrongType localWrongType1 = new WrongType(localClassCastException1, "string-length", 1, localObject14);
          throw localWrongType1;
        }
        try
        {
          localObject15 = localLocation7.get();
        }
        catch (UnboundLocationException localUnboundLocationException7)
        {
          localUnboundLocationException7.setLine("srfi13.scm", 449, 31);
          throw localUnboundLocationException7;
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject15;
          j = strings.stringLength(localCharSequence2);
          localObject16 = AddOp.$Mn.apply2(localObject11, localObject12);
          localObject17 = AddOp.$Pl.apply2(AddOp.$Pl.apply2(Integer.valueOf(j), localObject9), localObject16);
          localObject18 = AddOp.$Pl.apply2(localObject17, Integer.valueOf(i));
        }
        catch (ClassCastException localClassCastException2)
        {
          WrongType localWrongType2 = new WrongType(localClassCastException2, "string-length", 1, localObject15);
          throw localWrongType2;
        }
        try
        {
          k = ((Number)localObject18).intValue();
          localCharSequence3 = strings.makeString(k);
        }
        catch (ClassCastException localClassCastException3)
        {
          WrongType localWrongType3 = new WrongType(localClassCastException3, "make-string", 1, localObject18);
          throw localWrongType3;
        }
        try
        {
          localCharSequence4 = (CharSequence)localObject14;
          $PcStringCopy$Ex(localCharSequence3, 0, localCharSequence4, 0, i);
        }
        catch (ClassCastException localClassCastException4)
        {
          WrongType localWrongType4 = new WrongType(localClassCastException4, "%string-copy!", 2, localObject14);
          throw localWrongType4;
        }
        try
        {
          localCharSequence5 = (CharSequence)localObject10;
        }
        catch (ClassCastException localClassCastException5)
        {
          WrongType localWrongType5 = new WrongType(localClassCastException5, "%string-copy!", 2, localObject10);
          throw localWrongType5;
        }
        try
        {
          m = ((Number)localObject12).intValue();
        }
        catch (ClassCastException localClassCastException6)
        {
          WrongType localWrongType6 = new WrongType(localClassCastException6, "%string-copy!", 3, localObject12);
          throw localWrongType6;
        }
        try
        {
          n = ((Number)localObject11).intValue();
          $PcStringCopy$Ex(localCharSequence3, i, localCharSequence5, m, n);
          localObject19 = AddOp.$Pl.apply2(Integer.valueOf(i), localObject16);
          if (lists.isPair(localObject8))
          {
            localObject21 = lists.car.apply1(localObject8);
            localObject8 = lists.cdr.apply1(localObject8);
          }
        }
        catch (ClassCastException localClassCastException7)
        {
          WrongType localWrongType7 = new WrongType(localClassCastException7, "%string-copy!", 4, localObject11);
          throw localWrongType7;
        }
        try
        {
          localCharSequence7 = (CharSequence)localObject21;
          i2 = strings.stringLength(localCharSequence7);
        }
        catch (ClassCastException localClassCastException10)
        {
          WrongType localWrongType10 = new WrongType(localClassCastException10, "string-length", 1, localObject21);
          throw localWrongType10;
        }
        try
        {
          i3 = ((Number)localObject19).intValue();
        }
        catch (ClassCastException localClassCastException11)
        {
          WrongType localWrongType11 = new WrongType(localClassCastException11, "%string-copy!", 1, localObject19);
          throw localWrongType11;
        }
        try
        {
          localCharSequence8 = (CharSequence)localObject21;
          $PcStringCopy$Ex(localCharSequence3, i3, localCharSequence8, 0, i2);
          localAddOp1 = AddOp.$Pl;
          localInteger = Integer.valueOf(i2);
          localObject19 = localAddOp1.apply2(localObject19, localInteger);
        }
        catch (ClassCastException localClassCastException12)
        {
          WrongType localWrongType12 = new WrongType(localClassCastException12, "%string-copy!", 2, localObject21);
          throw localWrongType12;
        }
        try
        {
          i1 = ((Number)localObject19).intValue();
          localLocation8 = loc$base;
        }
        catch (ClassCastException localClassCastException8)
        {
          WrongType localWrongType8 = new WrongType(localClassCastException8, "%string-copy!", 1, localObject19);
          throw localWrongType8;
        }
        try
        {
          localObject20 = localLocation8.get();
        }
        catch (UnboundLocationException localUnboundLocationException8)
        {
          localUnboundLocationException8.setLine("srfi13.scm", 463, 30);
          throw localUnboundLocationException8;
        }
        try
        {
          localCharSequence6 = (CharSequence)localObject20;
          $PcStringCopy$Ex(localCharSequence3, i1, localCharSequence6, 0, j);
          return localApplyToArgs1.apply4(localObject1, localLList, localObject7, localCharSequence3);
        }
        catch (ClassCastException localClassCastException9)
        {
          WrongType localWrongType9 = new WrongType(localClassCastException9, "%string-copy!", 2, localObject20);
          throw localWrongType9;
        }
        localUnboundLocationException1 = localUnboundLocationException1;
        localUnboundLocationException1.setLine("srfi13.scm", 420, 3);
        throw localUnboundLocationException1;
      }
      try
      {
        localObject2 = localLocation2.get();
        localLocation3 = loc$base;
      }
      catch (UnboundLocationException localUnboundLocationException2)
      {
        localUnboundLocationException2.setLine("srfi13.scm", 421, 20);
        throw localUnboundLocationException2;
      }
      try
      {
        localObject3 = localLocation3.get();
        if (strings.isString(localObject3))
        {
          localBoolean1 = Boolean.TRUE;
          localObject4 = localApplyToArgs3.apply3(localObject2, "", localBoolean1);
          localApplyToArgs4 = Scheme.applyToArgs;
          localLocation4 = loc$make$Mnfinal;
        }
      }
      catch (UnboundLocationException localUnboundLocationException3)
      {
        localUnboundLocationException3.setLine("srfi13.scm", 421, 57);
        throw localUnboundLocationException3;
      }
      try
      {
        localObject5 = localLocation4.get();
        localModuleMethod = lambda$Fn18;
        localLocation5 = loc$make$Mnfinal;
      }
      catch (UnboundLocationException localUnboundLocationException4)
      {
        localUnboundLocationException4.setLine("srfi13.scm", 422, 6);
        throw localUnboundLocationException4;
      }
      try
      {
        localObject6 = localLocation5.get();
        if (misc.isProcedure(localObject6))
        {
          localBoolean2 = Boolean.TRUE;
          localObject7 = localApplyToArgs2.apply2(localObject4, localApplyToArgs4.apply3(localObject5, localModuleMethod, localBoolean2));
          localObject8 = LList.Empty;
          localObject9 = Lit0;
          localObject10 = strings.makeString(40);
          localObject11 = Lit3;
          localObject12 = Lit3;
          if (Scheme.applyToArgs.apply2(paramObject1, paramObject4) != Boolean.FALSE) {
            continue;
          }
          localObject22 = Scheme.applyToArgs.apply2(paramObject2, paramObject4);
          paramObject4 = Scheme.applyToArgs.apply2(paramObject3, paramObject4);
          NumberCompare localNumberCompare = Scheme.numGrt;
          IntNum localIntNum1 = Lit0;
          if (localNumberCompare.apply2(localObject12, localIntNum1) == Boolean.FALSE) {
            continue;
          }
          AddOp localAddOp2 = AddOp.$Mn;
          IntNum localIntNum2 = Lit1;
          localObject12 = localAddOp2.apply2(localObject12, localIntNum2);
        }
      }
      catch (UnboundLocationException localUnboundLocationException5)
      {
        localUnboundLocationException5.setLine("srfi13.scm", 422, 46);
        throw localUnboundLocationException5;
      }
      try
      {
        localCharSeq2 = (CharSeq)localObject10;
      }
      catch (ClassCastException localClassCastException17)
      {
        localWrongType17 = new WrongType(localClassCastException17, "string-set!", 1, localObject10);
        throw localWrongType17;
      }
      try
      {
        i6 = ((Number)localObject12).intValue();
      }
      catch (ClassCastException localClassCastException18)
      {
        localWrongType18 = new WrongType(localClassCastException18, "string-set!", 2, localObject12);
        throw localWrongType18;
      }
      try
      {
        c2 = ((Char)localObject22).charValue();
        strings.stringSet$Ex(localCharSeq2, i6, c2);
      }
      catch (ClassCastException localClassCastException19)
      {
        localWrongType19 = new WrongType(localClassCastException19, "string-set!", 3, localObject22);
        throw localWrongType19;
      }
      localBoolean1 = Boolean.FALSE;
      continue;
      localBoolean2 = Boolean.FALSE;
      continue;
      localObject23 = AddOp.$Pl.apply2(localObject11, localObject9);
      arrayOfObject = new Object[2];
      arrayOfObject[0] = Lit4;
      arrayOfObject[1] = localObject23;
      localObject24 = numbers.min(arrayOfObject);
      try
      {
        int i4 = ((Number)localObject24).intValue();
        localCharSequence9 = strings.makeString(i4);
        localObject12 = AddOp.$Mn.apply2(localObject24, Lit1);
      }
      catch (ClassCastException localClassCastException13)
      {
        CharSeq localCharSeq1;
        int i5;
        char c1;
        ApplyToArgs localApplyToArgs5;
        Location localLocation6;
        Object localObject13;
        CharSequence localCharSequence1;
        int i;
        Location localLocation7;
        CharSequence localCharSequence2;
        int j;
        Object localObject16;
        Object localObject17;
        int k;
        CharSequence localCharSequence3;
        CharSequence localCharSequence4;
        CharSequence localCharSequence5;
        int m;
        int n;
        CharSequence localCharSequence7;
        int i2;
        int i3;
        CharSequence localCharSequence8;
        AddOp localAddOp1;
        Integer localInteger;
        int i1;
        Location localLocation8;
        CharSequence localCharSequence6;
        WrongType localWrongType17;
        WrongType localWrongType18;
        WrongType localWrongType19;
        WrongType localWrongType13 = new WrongType(localClassCastException13, "make-string", 1, localObject24);
        throw localWrongType13;
      }
      try
      {
        localCharSeq1 = (CharSeq)localCharSequence9;
      }
      catch (ClassCastException localClassCastException14)
      {
        WrongType localWrongType14 = new WrongType(localClassCastException14, "string-set!", 1, localCharSequence9);
        throw localWrongType14;
      }
      try
      {
        i5 = ((Number)localObject12).intValue();
      }
      catch (ClassCastException localClassCastException15)
      {
        WrongType localWrongType15 = new WrongType(localClassCastException15, "string-set!", 2, localObject12);
        throw localWrongType15;
      }
      try
      {
        c1 = ((Char)localObject22).charValue();
        strings.stringSet$Ex(localCharSeq1, i5, c1);
        localObject8 = lists.cons(localObject10, localObject8);
        localObject9 = AddOp.$Pl.apply2(localObject9, localObject11);
        localObject11 = localObject24;
        localObject10 = localCharSequence9;
      }
      catch (ClassCastException localClassCastException16)
      {
        WrongType localWrongType16 = new WrongType(localClassCastException16, "string-set!", 3, localObject22);
        throw localWrongType16;
      }
    }
    localApplyToArgs5 = Scheme.applyToArgs;
    localLocation6 = loc$make$Mnfinal;
  }
  
  public static Object stringUpcase$Ex$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame59 localframe59 = new frame59();
    localframe59.s = paramObject;
    localframe59.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe59.lambda$Fn141, localframe59.lambda$Fn142);
  }
  
  public static Object stringUpcase$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame58 localframe58 = new frame58();
    localframe58.s = paramObject;
    localframe58.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe58.lambda$Fn139, localframe58.lambda$Fn140);
  }
  
  public static Object stringXcopy$Ex$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object[] paramArrayOfObject)
  {
    frame95 localframe95 = new frame95();
    localframe95.target = paramObject1;
    localframe95.tstart = paramObject2;
    localframe95.s = paramObject3;
    localframe95.sfrom = paramObject4;
    localframe95.maybe$Mnsto$Plstart$Plend = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    Location localLocation = loc$check$Mnarg;
    try
    {
      Object localObject = localLocation.get();
      localApplyToArgs.apply4(localObject, lambda$Fn216, localframe95.sfrom, string$Mnxcopy$Ex);
      return call_with_values.callWithValues(localframe95.lambda$Fn217, localframe95.lambda$Fn221);
    }
    catch (UnboundLocationException localUnboundLocationException)
    {
      localUnboundLocationException.setLine("srfi13.scm", 1779, 3);
      throw localUnboundLocationException;
    }
  }
  
  /* Error */
  public static Object substring$SlShared$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 2762	gnu/kawa/slib/srfi13$frame1
    //   3: dup
    //   4: invokespecial 2763	gnu/kawa/slib/srfi13$frame1:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: putfield 2764	gnu/kawa/slib/srfi13$frame1:start	Ljava/lang/Object;
    //   13: aload_2
    //   14: iconst_0
    //   15: invokestatic 1687	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   18: astore 4
    //   20: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   23: astore 5
    //   25: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   28: astore 6
    //   30: aload 6
    //   32: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   35: astore 8
    //   37: aload 5
    //   39: aload 8
    //   41: getstatic 2621	kawa/lib/strings:string$Qu	Lgnu/expr/ModuleMethod;
    //   44: aload_0
    //   45: getstatic 1350	gnu/kawa/slib/srfi13:substring$Slshared	Lgnu/expr/ModuleMethod;
    //   48: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: aload_0
    //   53: checkcast 386	java/lang/CharSequence
    //   56: astore 11
    //   58: aload_3
    //   59: aload 11
    //   61: invokestatic 347	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   64: putfield 2765	gnu/kawa/slib/srfi13$frame1:slen	I
    //   67: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   70: astore 12
    //   72: getstatic 1272	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   75: astore 13
    //   77: aload 13
    //   79: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   82: astore 15
    //   84: aload 12
    //   86: aload 15
    //   88: getstatic 1348	gnu/kawa/slib/srfi13:lambda$Fn5	Lgnu/expr/ModuleMethod;
    //   91: aload_3
    //   92: getfield 2764	gnu/kawa/slib/srfi13$frame1:start	Ljava/lang/Object;
    //   95: getstatic 1350	gnu/kawa/slib/srfi13:substring$Slshared	Lgnu/expr/ModuleMethod;
    //   98: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   101: pop
    //   102: aload_0
    //   103: checkcast 386	java/lang/CharSequence
    //   106: astore 18
    //   108: aload_3
    //   109: getfield 2764	gnu/kawa/slib/srfi13$frame1:start	Ljava/lang/Object;
    //   112: astore 19
    //   114: aload 19
    //   116: checkcast 376	java/lang/Number
    //   119: invokevirtual 380	java/lang/Number:intValue	()I
    //   122: istore 21
    //   124: getstatic 452	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   127: astore 22
    //   129: getstatic 1274	gnu/kawa/slib/srfi13:loc$$Cloptional	Lgnu/mapping/Location;
    //   132: astore 23
    //   134: aload 23
    //   136: invokevirtual 611	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   139: astore 25
    //   141: aload 22
    //   143: aload 25
    //   145: aload 4
    //   147: aload_3
    //   148: getfield 2765	gnu/kawa/slib/srfi13$frame1:slen	I
    //   151: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   154: aload_3
    //   155: getfield 2768	gnu/kawa/slib/srfi13$frame1:lambda$Fn6	Lgnu/expr/ModuleMethod;
    //   158: invokevirtual 1795	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: astore 26
    //   163: aload 26
    //   165: checkcast 376	java/lang/Number
    //   168: invokevirtual 380	java/lang/Number:intValue	()I
    //   171: istore 28
    //   173: aload 18
    //   175: iload 21
    //   177: iload 28
    //   179: invokestatic 2168	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   182: areturn
    //   183: astore 7
    //   185: aload 7
    //   187: ldc_w 627
    //   190: sipush 221
    //   193: iconst_3
    //   194: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   197: aload 7
    //   199: athrow
    //   200: astore 10
    //   202: new 412	gnu/mapping/WrongType
    //   205: dup
    //   206: aload 10
    //   208: ldc_w 422
    //   211: iconst_1
    //   212: aload_0
    //   213: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   216: athrow
    //   217: astore 14
    //   219: aload 14
    //   221: ldc_w 627
    //   224: sipush 223
    //   227: iconst_5
    //   228: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   231: aload 14
    //   233: athrow
    //   234: astore 17
    //   236: new 412	gnu/mapping/WrongType
    //   239: dup
    //   240: aload 17
    //   242: ldc_w 1037
    //   245: iconst_0
    //   246: aload_0
    //   247: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   250: athrow
    //   251: astore 20
    //   253: new 412	gnu/mapping/WrongType
    //   256: dup
    //   257: aload 20
    //   259: ldc_w 1037
    //   262: iconst_1
    //   263: aload 19
    //   265: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   268: athrow
    //   269: astore 24
    //   271: aload 24
    //   273: ldc_w 627
    //   276: sipush 226
    //   279: bipush 10
    //   281: invokevirtual 631	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   284: aload 24
    //   286: athrow
    //   287: astore 27
    //   289: new 412	gnu/mapping/WrongType
    //   292: dup
    //   293: aload 27
    //   295: ldc_w 1037
    //   298: iconst_2
    //   299: aload 26
    //   301: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   304: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	paramObject1	Object
    //   0	305	1	paramObject2	Object
    //   0	305	2	paramArrayOfObject	Object[]
    //   7	148	3	localframe1	frame1
    //   18	128	4	localLList	LList
    //   23	15	5	localApplyToArgs1	ApplyToArgs
    //   28	3	6	localLocation1	Location
    //   183	15	7	localUnboundLocationException1	UnboundLocationException
    //   35	5	8	localObject1	Object
    //   200	7	10	localClassCastException1	ClassCastException
    //   56	4	11	localCharSequence1	CharSequence
    //   70	15	12	localApplyToArgs2	ApplyToArgs
    //   75	3	13	localLocation2	Location
    //   217	15	14	localUnboundLocationException2	UnboundLocationException
    //   82	5	15	localObject2	Object
    //   234	7	17	localClassCastException2	ClassCastException
    //   106	68	18	localCharSequence2	CharSequence
    //   112	152	19	localObject3	Object
    //   251	7	20	localClassCastException3	ClassCastException
    //   122	54	21	i	int
    //   127	15	22	localApplyToArgs3	ApplyToArgs
    //   132	3	23	localLocation3	Location
    //   269	16	24	localUnboundLocationException3	UnboundLocationException
    //   139	5	25	localObject4	Object
    //   161	139	26	localObject5	Object
    //   287	7	27	localClassCastException4	ClassCastException
    //   171	7	28	j	int
    // Exception table:
    //   from	to	target	type
    //   30	37	183	gnu/mapping/UnboundLocationException
    //   52	58	200	java/lang/ClassCastException
    //   77	84	217	gnu/mapping/UnboundLocationException
    //   102	108	234	java/lang/ClassCastException
    //   114	124	251	java/lang/ClassCastException
    //   134	141	269	gnu/mapping/UnboundLocationException
    //   163	173	287	java/lang/ClassCastException
  }
  
  public static Object xsubstring$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame94 localframe94 = new frame94();
    localframe94.s = paramObject1;
    localframe94.from = paramObject2;
    localframe94.maybe$Mnto$Plstart$Plend = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    Location localLocation = loc$check$Mnarg;
    try
    {
      Object localObject = localLocation.get();
      localApplyToArgs.apply4(localObject, lambda$Fn210, localframe94.from, xsubstring);
      return call_with_values.callWithValues(localframe94.lambda$Fn211, localframe94.lambda$Fn215);
    }
    catch (UnboundLocationException localUnboundLocationException)
    {
      localUnboundLocationException.setLine("srfi13.scm", 1738, 3);
      throw localUnboundLocationException;
    }
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 199: 
      if (frame1.lambda5(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 209: 
      return lambda17(paramObject);
    case 211: 
      return lambda18(paramObject);
    case 217: 
      if (lambda27(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 239: 
      return frame32.lambda72(paramObject);
    case 240: 
      return frame32.lambda73(paramObject);
    case 242: 
      return frame34.lambda78(paramObject);
    case 244: 
      return frame36.lambda83(paramObject);
    case 245: 
      return frame36.lambda84(paramObject);
    case 247: 
      return frame38.lambda89(paramObject);
    case 248: 
      return frame38.lambda90(paramObject);
    case 250: 
      return frame40.lambda95(paramObject);
    case 252: 
      return frame42.lambda100(paramObject);
    case 254: 
      return frame44.lambda105(paramObject);
    case 255: 
      return frame44.lambda106(paramObject);
    case 257: 
      return frame46.lambda111(paramObject);
    case 259: 
      return frame48.lambda116(paramObject);
    case 260: 
      return frame48.lambda117(paramObject);
    case 262: 
      return frame50.lambda122(paramObject);
    case 263: 
      return frame50.lambda123(paramObject);
    case 265: 
      return frame52.lambda128(paramObject);
    case 267: 
      return frame54.lambda133(paramObject);
    case 271: 
      return Integer.valueOf(frame57.lambda138(paramObject));
    case 287: 
      if (frame71.lambda163(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 289: 
      if (frame72.lambda166(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 309: 
      if (isStringNull(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 312: 
      return reverseList$To$String(paramObject);
    case 315: 
      return stringConcatenate$SlShared(paramObject);
    case 316: 
      return stringConcatenate(paramObject);
    case 322: 
      if (frame94.lambda210(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 324: 
      if (frame95.lambda216(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    if (frame95.lambda220(paramObject)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
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
      int i = ((Number)paramObject2).intValue();
      return stringTabulate(paramObject1, i);
    }
    catch (ClassCastException localClassCastException3)
    {
      try
      {
        CharSequence localCharSequence2 = (CharSequence)paramObject1;
        return stringDrop(localCharSequence2, paramObject2);
      }
      catch (ClassCastException localClassCastException2)
      {
        CharSequence localCharSequence1;
        throw new WrongType(localClassCastException2, "string-drop", 1, paramObject1);
      }
      try
      {
        localCharSequence1 = (CharSequence)paramObject1;
        return stringDropRight(localCharSequence1, paramObject2);
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "string-drop-right", 1, paramObject1);
      }
      localClassCastException3 = localClassCastException3;
      throw new WrongType(localClassCastException3, "string-tabulate", 2, paramObject2);
    }
    return stringTake(paramObject1, paramObject2);
    return stringTakeRight(paramObject1, paramObject2);
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    case 194: 
      return stringParseStart$PlEnd(paramObject1, paramObject2, paramObject3);
    case 196: 
      return stringParseFinalStart$PlEnd(paramObject1, paramObject2, paramObject3);
    case 197: 
      if (isSubstringSpecOk(paramObject1, paramObject2, paramObject3)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    try
    {
      localCharSequence2 = (CharSequence)paramObject1;
    }
    catch (ClassCastException localClassCastException3)
    {
      try
      {
        CharSequence localCharSequence2;
        int j;
        int k;
        i = ((Number)paramObject2).intValue();
      }
      catch (ClassCastException localClassCastException1)
      {
        int i;
        CharSequence localCharSequence1;
        throw new WrongType(localClassCastException1, "string-copy!", 2, paramObject2);
      }
      try
      {
        localCharSequence1 = (CharSequence)paramObject3;
        return stringCopy$Ex(paramObject1, i, localCharSequence1);
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-copy!", 3, paramObject3);
      }
      localClassCastException3 = localClassCastException3;
      throw new WrongType(localClassCastException3, "%substring/shared", 1, paramObject1);
    }
    try
    {
      j = ((Number)paramObject2).intValue();
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "%substring/shared", 2, paramObject2);
    }
    try
    {
      k = ((Number)paramObject3).intValue();
      return $PcSubstring$SlShared(localCharSequence2, j, k);
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "%substring/shared", 3, paramObject3);
    }
    return $PcStringTitlecase$Ex(paramObject1, paramObject2, paramObject3);
  }
  
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
    }
    try
    {
      localCharSequence2 = (CharSequence)paramObject2;
    }
    catch (ClassCastException localClassCastException4)
    {
      CharSequence localCharSequence2;
      int k;
      int m;
      throw new WrongType(localClassCastException4, "%check-bounds", 2, paramObject2);
    }
    try
    {
      k = ((Number)paramObject3).intValue();
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "%check-bounds", 3, paramObject3);
    }
    try
    {
      m = ((Number)paramObject4).intValue();
      return $PcCheckBounds(paramObject1, localCharSequence2, k, m);
    }
    catch (ClassCastException localClassCastException6)
    {
      throw new WrongType(localClassCastException6, "%check-bounds", 4, paramObject4);
    }
    return checkSubstringSpec(paramObject1, paramObject2, paramObject3, paramObject4);
    return $PcStringMap(paramObject1, paramObject2, paramObject3, paramObject4);
    return $PcStringMap$Ex(paramObject1, paramObject2, paramObject3, paramObject4);
    try
    {
      i = ((Number)paramObject2).intValue();
    }
    catch (ClassCastException localClassCastException1)
    {
      int i;
      CharSequence localCharSequence1;
      int j;
      throw new WrongType(localClassCastException1, "string-copy!", 2, paramObject2);
    }
    try
    {
      localCharSequence1 = (CharSequence)paramObject3;
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "string-copy!", 3, paramObject3);
    }
    try
    {
      j = ((Number)paramObject4).intValue();
      return stringCopy$Ex(paramObject1, i, localCharSequence1, j);
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "string-copy!", 4, paramObject4);
    }
    return $PcFinishStringConcatenateReverse(paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  /* Error */
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 2789	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+532 -> 536, 200:+539->543, 201:+532->536, 202:+622->626, 203:+693->697, 204:+532->536, 205:+776->780, 206:+532->536, 207:+859->863, 208:+953->957, 209:+532->536, 210:+1047->1051, 211:+532->536, 212:+1152->1156, 213:+1257->1261, 214:+1340->1344, 215:+1423->1427, 216:+1506->1510, 217:+532->536, 218:+532->536, 219:+1589->1593, 220:+1611->1615, 221:+1633->1637, 222:+1762->1766, 223:+1887->1891, 224:+1943->1947, 225:+1999->2003, 226:+2055->2059, 227:+2111->2115, 228:+2167->2171, 229:+2223->2227, 230:+2279->2283, 231:+2335->2339, 232:+2357->2361, 233:+2379->2383, 234:+2401->2405, 235:+2423->2427, 236:+2457->2461, 237:+2491->2495, 238:+2568->2572, 239:+532->536, 240:+532->536, 241:+2645->2649, 242:+532->536, 243:+2701->2705, 244:+532->536, 245:+532->536, 246:+2757->2761, 247:+532->536, 248:+532->536, 249:+2813->2817, 250:+532->536, 251:+2869->2873, 252:+532->536, 253:+2925->2929, 254:+532->536, 255:+532->536, 256:+2981->2985, 257:+532->536, 258:+3037->3041, 259:+532->536, 260:+532->536, 261:+3093->3097, 262:+532->536, 263:+532->536, 264:+3149->3153, 265:+532->536, 266:+3205->3209, 267:+532->536, 268:+3261->3265, 269:+3317->3321, 270:+3336->3340, 271:+532->536, 272:+3384->3388, 273:+3432->3436, 274:+3480->3484, 275:+3528->3532, 276:+3576->3580, 277:+532->536, 278:+3624->3628, 279:+3672->3676, 280:+532->536, 281:+532->536, 282:+532->536, 283:+532->536, 284:+3720->3724, 285:+3768->3772, 286:+3816->3820, 287:+532->536, 288:+3864->3868, 289:+532->536, 290:+3920->3924, 291:+3976->3980, 292:+4032->4036, 293:+4088->4092, 294:+4144->4148, 295:+4200->4204, 296:+4256->4260, 297:+4312->4316, 298:+4368->4372, 299:+4424->4428, 300:+532->536, 301:+532->536, 302:+4550->4554, 303:+4633->4637, 304:+4689->4693, 305:+4745->4749, 306:+4771->4775, 307:+4819->4823, 308:+4841->4845, 309:+532->536, 310:+4911->4915, 311:+4959->4963, 312:+532->536, 313:+5007->5011, 314:+5055->5059, 315:+532->536, 316:+532->536, 317:+5060->5064, 318:+5108->5112, 319:+532->536, 320:+5156->5160, 321:+5226->5230, 322:+532->536, 323:+5274->5278, 324:+532->536, 325:+532->536, 326:+5330->5334, 327:+5400->5404, 328:+5426->5430
    //   537: aload_1
    //   538: aload_2
    //   539: invokespecial 2937	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   542: areturn
    //   543: aload_2
    //   544: iconst_0
    //   545: aaload
    //   546: wide
    //   550: aload_2
    //   551: iconst_1
    //   552: aaload
    //   553: wide
    //   557: bipush 254
    //   559: aload_2
    //   560: arraylength
    //   561: iadd
    //   562: wide
    //   566: wide
    //   570: anewarray 325	java/lang/Object
    //   573: wide
    //   577: wide
    //   583: wide
    //   587: ifge +19 -> 606
    //   590: wide
    //   594: wide
    //   598: wide
    //   602: invokestatic 2043	gnu/kawa/slib/srfi13:substring$SlShared$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   605: areturn
    //   606: wide
    //   610: wide
    //   614: aload_2
    //   615: wide
    //   619: iconst_2
    //   620: iadd
    //   621: aaload
    //   622: aastore
    //   623: goto -46 -> 577
    //   626: aload_2
    //   627: iconst_0
    //   628: aaload
    //   629: wide
    //   633: iconst_m1
    //   634: aload_2
    //   635: arraylength
    //   636: iadd
    //   637: wide
    //   641: wide
    //   645: anewarray 325	java/lang/Object
    //   648: wide
    //   652: wide
    //   658: wide
    //   662: ifge +15 -> 677
    //   665: wide
    //   669: wide
    //   673: invokestatic 2939	gnu/kawa/slib/srfi13:stringCopy$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   676: areturn
    //   677: wide
    //   681: wide
    //   685: aload_2
    //   686: wide
    //   690: iconst_1
    //   691: iadd
    //   692: aaload
    //   693: aastore
    //   694: goto -42 -> 652
    //   697: aload_2
    //   698: iconst_0
    //   699: aaload
    //   700: wide
    //   704: aload_2
    //   705: iconst_1
    //   706: aaload
    //   707: wide
    //   711: bipush 254
    //   713: aload_2
    //   714: arraylength
    //   715: iadd
    //   716: wide
    //   720: wide
    //   724: anewarray 325	java/lang/Object
    //   727: wide
    //   731: wide
    //   737: wide
    //   741: ifge +19 -> 760
    //   744: wide
    //   748: wide
    //   752: wide
    //   756: invokestatic 2941	gnu/kawa/slib/srfi13:stringMap$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   759: areturn
    //   760: wide
    //   764: wide
    //   768: aload_2
    //   769: wide
    //   773: iconst_2
    //   774: iadd
    //   775: aaload
    //   776: aastore
    //   777: goto -46 -> 731
    //   780: aload_2
    //   781: iconst_0
    //   782: aaload
    //   783: wide
    //   787: aload_2
    //   788: iconst_1
    //   789: aaload
    //   790: wide
    //   794: bipush 254
    //   796: aload_2
    //   797: arraylength
    //   798: iadd
    //   799: wide
    //   803: wide
    //   807: anewarray 325	java/lang/Object
    //   810: wide
    //   814: wide
    //   820: wide
    //   824: ifge +19 -> 843
    //   827: wide
    //   831: wide
    //   835: wide
    //   839: invokestatic 2943	gnu/kawa/slib/srfi13:stringMap$Ex$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   842: areturn
    //   843: wide
    //   847: wide
    //   851: aload_2
    //   852: wide
    //   856: iconst_2
    //   857: iadd
    //   858: aaload
    //   859: aastore
    //   860: goto -46 -> 814
    //   863: aload_2
    //   864: iconst_0
    //   865: aaload
    //   866: wide
    //   870: aload_2
    //   871: iconst_1
    //   872: aaload
    //   873: wide
    //   877: aload_2
    //   878: iconst_2
    //   879: aaload
    //   880: wide
    //   884: bipush 253
    //   886: aload_2
    //   887: arraylength
    //   888: iadd
    //   889: wide
    //   893: wide
    //   897: anewarray 325	java/lang/Object
    //   900: wide
    //   904: wide
    //   910: wide
    //   914: ifge +23 -> 937
    //   917: wide
    //   921: wide
    //   925: wide
    //   929: wide
    //   933: invokestatic 2945	gnu/kawa/slib/srfi13:stringFold$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   936: areturn
    //   937: wide
    //   941: wide
    //   945: aload_2
    //   946: wide
    //   950: iconst_3
    //   951: iadd
    //   952: aaload
    //   953: aastore
    //   954: goto -50 -> 904
    //   957: aload_2
    //   958: iconst_0
    //   959: aaload
    //   960: wide
    //   964: aload_2
    //   965: iconst_1
    //   966: aaload
    //   967: wide
    //   971: aload_2
    //   972: iconst_2
    //   973: aaload
    //   974: wide
    //   978: bipush 253
    //   980: aload_2
    //   981: arraylength
    //   982: iadd
    //   983: wide
    //   987: wide
    //   991: anewarray 325	java/lang/Object
    //   994: wide
    //   998: wide
    //   1004: wide
    //   1008: ifge +23 -> 1031
    //   1011: wide
    //   1015: wide
    //   1019: wide
    //   1023: wide
    //   1027: invokestatic 2947	gnu/kawa/slib/srfi13:stringFoldRight$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1030: areturn
    //   1031: wide
    //   1035: wide
    //   1039: aload_2
    //   1040: wide
    //   1044: iconst_3
    //   1045: iadd
    //   1046: aaload
    //   1047: aastore
    //   1048: goto -50 -> 998
    //   1051: aload_2
    //   1052: iconst_0
    //   1053: aaload
    //   1054: wide
    //   1058: aload_2
    //   1059: iconst_1
    //   1060: aaload
    //   1061: wide
    //   1065: aload_2
    //   1066: iconst_2
    //   1067: aaload
    //   1068: wide
    //   1072: aload_2
    //   1073: iconst_3
    //   1074: aaload
    //   1075: wide
    //   1079: bipush 252
    //   1081: aload_2
    //   1082: arraylength
    //   1083: iadd
    //   1084: wide
    //   1088: wide
    //   1092: anewarray 325	java/lang/Object
    //   1095: wide
    //   1099: wide
    //   1105: wide
    //   1109: ifge +27 -> 1136
    //   1112: wide
    //   1116: wide
    //   1120: wide
    //   1124: wide
    //   1128: wide
    //   1132: invokestatic 2949	gnu/kawa/slib/srfi13:stringUnfold$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1135: areturn
    //   1136: wide
    //   1140: wide
    //   1144: aload_2
    //   1145: wide
    //   1149: iconst_4
    //   1150: iadd
    //   1151: aaload
    //   1152: aastore
    //   1153: goto -54 -> 1099
    //   1156: aload_2
    //   1157: iconst_0
    //   1158: aaload
    //   1159: wide
    //   1163: aload_2
    //   1164: iconst_1
    //   1165: aaload
    //   1166: wide
    //   1170: aload_2
    //   1171: iconst_2
    //   1172: aaload
    //   1173: wide
    //   1177: aload_2
    //   1178: iconst_3
    //   1179: aaload
    //   1180: wide
    //   1184: bipush 252
    //   1186: aload_2
    //   1187: arraylength
    //   1188: iadd
    //   1189: wide
    //   1193: wide
    //   1197: anewarray 325	java/lang/Object
    //   1200: wide
    //   1204: wide
    //   1210: wide
    //   1214: ifge +27 -> 1241
    //   1217: wide
    //   1221: wide
    //   1225: wide
    //   1229: wide
    //   1233: wide
    //   1237: invokestatic 2951	gnu/kawa/slib/srfi13:stringUnfoldRight$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1240: areturn
    //   1241: wide
    //   1245: wide
    //   1249: aload_2
    //   1250: wide
    //   1254: iconst_4
    //   1255: iadd
    //   1256: aaload
    //   1257: aastore
    //   1258: goto -54 -> 1204
    //   1261: aload_2
    //   1262: iconst_0
    //   1263: aaload
    //   1264: wide
    //   1268: aload_2
    //   1269: iconst_1
    //   1270: aaload
    //   1271: wide
    //   1275: bipush 254
    //   1277: aload_2
    //   1278: arraylength
    //   1279: iadd
    //   1280: wide
    //   1284: wide
    //   1288: anewarray 325	java/lang/Object
    //   1291: wide
    //   1295: wide
    //   1301: wide
    //   1305: ifge +19 -> 1324
    //   1308: wide
    //   1312: wide
    //   1316: wide
    //   1320: invokestatic 2953	gnu/kawa/slib/srfi13:stringForEach$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1323: areturn
    //   1324: wide
    //   1328: wide
    //   1332: aload_2
    //   1333: wide
    //   1337: iconst_2
    //   1338: iadd
    //   1339: aaload
    //   1340: aastore
    //   1341: goto -46 -> 1295
    //   1344: aload_2
    //   1345: iconst_0
    //   1346: aaload
    //   1347: wide
    //   1351: aload_2
    //   1352: iconst_1
    //   1353: aaload
    //   1354: wide
    //   1358: bipush 254
    //   1360: aload_2
    //   1361: arraylength
    //   1362: iadd
    //   1363: wide
    //   1367: wide
    //   1371: anewarray 325	java/lang/Object
    //   1374: wide
    //   1378: wide
    //   1384: wide
    //   1388: ifge +19 -> 1407
    //   1391: wide
    //   1395: wide
    //   1399: wide
    //   1403: invokestatic 2955	gnu/kawa/slib/srfi13:stringForEachIndex$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1406: areturn
    //   1407: wide
    //   1411: wide
    //   1415: aload_2
    //   1416: wide
    //   1420: iconst_2
    //   1421: iadd
    //   1422: aaload
    //   1423: aastore
    //   1424: goto -46 -> 1378
    //   1427: aload_2
    //   1428: iconst_0
    //   1429: aaload
    //   1430: wide
    //   1434: aload_2
    //   1435: iconst_1
    //   1436: aaload
    //   1437: wide
    //   1441: bipush 254
    //   1443: aload_2
    //   1444: arraylength
    //   1445: iadd
    //   1446: wide
    //   1450: wide
    //   1454: anewarray 325	java/lang/Object
    //   1457: wide
    //   1461: wide
    //   1467: wide
    //   1471: ifge +19 -> 1490
    //   1474: wide
    //   1478: wide
    //   1482: wide
    //   1486: invokestatic 2957	gnu/kawa/slib/srfi13:stringEvery$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1489: areturn
    //   1490: wide
    //   1494: wide
    //   1498: aload_2
    //   1499: wide
    //   1503: iconst_2
    //   1504: iadd
    //   1505: aaload
    //   1506: aastore
    //   1507: goto -46 -> 1461
    //   1510: aload_2
    //   1511: iconst_0
    //   1512: aaload
    //   1513: wide
    //   1517: aload_2
    //   1518: iconst_1
    //   1519: aaload
    //   1520: wide
    //   1524: bipush 254
    //   1526: aload_2
    //   1527: arraylength
    //   1528: iadd
    //   1529: wide
    //   1533: wide
    //   1537: anewarray 325	java/lang/Object
    //   1540: wide
    //   1544: wide
    //   1550: wide
    //   1554: ifge +19 -> 1573
    //   1557: wide
    //   1561: wide
    //   1565: wide
    //   1569: invokestatic 2959	gnu/kawa/slib/srfi13:stringAny$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1572: areturn
    //   1573: wide
    //   1577: wide
    //   1581: aload_2
    //   1582: wide
    //   1586: iconst_2
    //   1587: iadd
    //   1588: aaload
    //   1589: aastore
    //   1590: goto -46 -> 1544
    //   1593: aload_2
    //   1594: iconst_0
    //   1595: aaload
    //   1596: aload_2
    //   1597: iconst_1
    //   1598: aaload
    //   1599: aload_2
    //   1600: iconst_2
    //   1601: aaload
    //   1602: aload_2
    //   1603: iconst_3
    //   1604: aaload
    //   1605: aload_2
    //   1606: iconst_4
    //   1607: aaload
    //   1608: aload_2
    //   1609: iconst_5
    //   1610: aaload
    //   1611: invokestatic 511	gnu/kawa/slib/srfi13:$PcStringPrefixLength	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1614: areturn
    //   1615: aload_2
    //   1616: iconst_0
    //   1617: aaload
    //   1618: aload_2
    //   1619: iconst_1
    //   1620: aaload
    //   1621: aload_2
    //   1622: iconst_2
    //   1623: aaload
    //   1624: aload_2
    //   1625: iconst_3
    //   1626: aaload
    //   1627: aload_2
    //   1628: iconst_4
    //   1629: aaload
    //   1630: aload_2
    //   1631: iconst_5
    //   1632: aaload
    //   1633: invokestatic 594	gnu/kawa/slib/srfi13:$PcStringSuffixLength	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1636: areturn
    //   1637: aload_2
    //   1638: iconst_0
    //   1639: aaload
    //   1640: wide
    //   1644: aload_2
    //   1645: iconst_1
    //   1646: aaload
    //   1647: wide
    //   1651: wide
    //   1655: checkcast 376	java/lang/Number
    //   1658: invokevirtual 380	java/lang/Number:intValue	()I
    //   1661: wide
    //   1665: aload_2
    //   1666: iconst_2
    //   1667: aaload
    //   1668: wide
    //   1672: wide
    //   1676: checkcast 376	java/lang/Number
    //   1679: invokevirtual 380	java/lang/Number:intValue	()I
    //   1682: wide
    //   1686: aload_2
    //   1687: iconst_3
    //   1688: aaload
    //   1689: wide
    //   1693: aload_2
    //   1694: iconst_4
    //   1695: aaload
    //   1696: wide
    //   1700: wide
    //   1704: checkcast 376	java/lang/Number
    //   1707: invokevirtual 380	java/lang/Number:intValue	()I
    //   1710: wide
    //   1714: aload_2
    //   1715: iconst_5
    //   1716: aaload
    //   1717: wide
    //   1721: wide
    //   1725: checkcast 376	java/lang/Number
    //   1728: invokevirtual 380	java/lang/Number:intValue	()I
    //   1731: wide
    //   1735: wide
    //   1739: wide
    //   1743: wide
    //   1747: wide
    //   1751: wide
    //   1755: wide
    //   1759: invokestatic 522	gnu/kawa/slib/srfi13:$PcStringPrefixLengthCi	(Ljava/lang/Object;IILjava/lang/Object;II)I
    //   1762: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1765: areturn
    //   1766: aload_2
    //   1767: iconst_0
    //   1768: aaload
    //   1769: astore 255
    //   1771: aload_2
    //   1772: iconst_1
    //   1773: aaload
    //   1774: wide
    //   1778: wide
    //   1782: checkcast 376	java/lang/Number
    //   1785: invokevirtual 380	java/lang/Number:intValue	()I
    //   1788: wide
    //   1792: aload_2
    //   1793: iconst_2
    //   1794: aaload
    //   1795: wide
    //   1799: wide
    //   1803: checkcast 376	java/lang/Number
    //   1806: invokevirtual 380	java/lang/Number:intValue	()I
    //   1809: wide
    //   1813: aload_2
    //   1814: iconst_3
    //   1815: aaload
    //   1816: wide
    //   1820: aload_2
    //   1821: iconst_4
    //   1822: aaload
    //   1823: wide
    //   1827: wide
    //   1831: checkcast 376	java/lang/Number
    //   1834: invokevirtual 380	java/lang/Number:intValue	()I
    //   1837: wide
    //   1841: aload_2
    //   1842: iconst_5
    //   1843: aaload
    //   1844: wide
    //   1848: wide
    //   1852: checkcast 376	java/lang/Number
    //   1855: invokevirtual 380	java/lang/Number:intValue	()I
    //   1858: wide
    //   1862: aload 255
    //   1864: wide
    //   1868: wide
    //   1872: wide
    //   1876: wide
    //   1880: wide
    //   1884: invokestatic 598	gnu/kawa/slib/srfi13:$PcStringSuffixLengthCi	(Ljava/lang/Object;IILjava/lang/Object;II)I
    //   1887: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1890: areturn
    //   1891: aload_2
    //   1892: iconst_0
    //   1893: aaload
    //   1894: astore 251
    //   1896: aload_2
    //   1897: iconst_1
    //   1898: aaload
    //   1899: astore 252
    //   1901: bipush 254
    //   1903: aload_2
    //   1904: arraylength
    //   1905: iadd
    //   1906: istore 253
    //   1908: iload 253
    //   1910: anewarray 325	java/lang/Object
    //   1913: astore 254
    //   1915: iinc 253 255
    //   1918: iload 253
    //   1920: ifge +13 -> 1933
    //   1923: aload 251
    //   1925: aload 252
    //   1927: aload 254
    //   1929: invokestatic 2961	gnu/kawa/slib/srfi13:stringPrefixLength$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1932: areturn
    //   1933: aload 254
    //   1935: iload 253
    //   1937: aload_2
    //   1938: iload 253
    //   1940: iconst_2
    //   1941: iadd
    //   1942: aaload
    //   1943: aastore
    //   1944: goto -29 -> 1915
    //   1947: aload_2
    //   1948: iconst_0
    //   1949: aaload
    //   1950: astore 247
    //   1952: aload_2
    //   1953: iconst_1
    //   1954: aaload
    //   1955: astore 248
    //   1957: bipush 254
    //   1959: aload_2
    //   1960: arraylength
    //   1961: iadd
    //   1962: istore 249
    //   1964: iload 249
    //   1966: anewarray 325	java/lang/Object
    //   1969: astore 250
    //   1971: iinc 249 255
    //   1974: iload 249
    //   1976: ifge +13 -> 1989
    //   1979: aload 247
    //   1981: aload 248
    //   1983: aload 250
    //   1985: invokestatic 2963	gnu/kawa/slib/srfi13:stringSuffixLength$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1988: areturn
    //   1989: aload 250
    //   1991: iload 249
    //   1993: aload_2
    //   1994: iload 249
    //   1996: iconst_2
    //   1997: iadd
    //   1998: aaload
    //   1999: aastore
    //   2000: goto -29 -> 1971
    //   2003: aload_2
    //   2004: iconst_0
    //   2005: aaload
    //   2006: astore 243
    //   2008: aload_2
    //   2009: iconst_1
    //   2010: aaload
    //   2011: astore 244
    //   2013: bipush 254
    //   2015: aload_2
    //   2016: arraylength
    //   2017: iadd
    //   2018: istore 245
    //   2020: iload 245
    //   2022: anewarray 325	java/lang/Object
    //   2025: astore 246
    //   2027: iinc 245 255
    //   2030: iload 245
    //   2032: ifge +13 -> 2045
    //   2035: aload 243
    //   2037: aload 244
    //   2039: aload 246
    //   2041: invokestatic 2965	gnu/kawa/slib/srfi13:stringPrefixLengthCi$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2044: areturn
    //   2045: aload 246
    //   2047: iload 245
    //   2049: aload_2
    //   2050: iload 245
    //   2052: iconst_2
    //   2053: iadd
    //   2054: aaload
    //   2055: aastore
    //   2056: goto -29 -> 2027
    //   2059: aload_2
    //   2060: iconst_0
    //   2061: aaload
    //   2062: astore 239
    //   2064: aload_2
    //   2065: iconst_1
    //   2066: aaload
    //   2067: astore 240
    //   2069: bipush 254
    //   2071: aload_2
    //   2072: arraylength
    //   2073: iadd
    //   2074: istore 241
    //   2076: iload 241
    //   2078: anewarray 325	java/lang/Object
    //   2081: astore 242
    //   2083: iinc 241 255
    //   2086: iload 241
    //   2088: ifge +13 -> 2101
    //   2091: aload 239
    //   2093: aload 240
    //   2095: aload 242
    //   2097: invokestatic 2967	gnu/kawa/slib/srfi13:stringSuffixLengthCi$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2100: areturn
    //   2101: aload 242
    //   2103: iload 241
    //   2105: aload_2
    //   2106: iload 241
    //   2108: iconst_2
    //   2109: iadd
    //   2110: aaload
    //   2111: aastore
    //   2112: goto -29 -> 2083
    //   2115: aload_2
    //   2116: iconst_0
    //   2117: aaload
    //   2118: astore 235
    //   2120: aload_2
    //   2121: iconst_1
    //   2122: aaload
    //   2123: astore 236
    //   2125: bipush 254
    //   2127: aload_2
    //   2128: arraylength
    //   2129: iadd
    //   2130: istore 237
    //   2132: iload 237
    //   2134: anewarray 325	java/lang/Object
    //   2137: astore 238
    //   2139: iinc 237 255
    //   2142: iload 237
    //   2144: ifge +13 -> 2157
    //   2147: aload 235
    //   2149: aload 236
    //   2151: aload 238
    //   2153: invokestatic 2969	gnu/kawa/slib/srfi13:isStringPrefix$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2156: areturn
    //   2157: aload 238
    //   2159: iload 237
    //   2161: aload_2
    //   2162: iload 237
    //   2164: iconst_2
    //   2165: iadd
    //   2166: aaload
    //   2167: aastore
    //   2168: goto -29 -> 2139
    //   2171: aload_2
    //   2172: iconst_0
    //   2173: aaload
    //   2174: astore 231
    //   2176: aload_2
    //   2177: iconst_1
    //   2178: aaload
    //   2179: astore 232
    //   2181: bipush 254
    //   2183: aload_2
    //   2184: arraylength
    //   2185: iadd
    //   2186: istore 233
    //   2188: iload 233
    //   2190: anewarray 325	java/lang/Object
    //   2193: astore 234
    //   2195: iinc 233 255
    //   2198: iload 233
    //   2200: ifge +13 -> 2213
    //   2203: aload 231
    //   2205: aload 232
    //   2207: aload 234
    //   2209: invokestatic 2971	gnu/kawa/slib/srfi13:isStringSuffix$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2212: areturn
    //   2213: aload 234
    //   2215: iload 233
    //   2217: aload_2
    //   2218: iload 233
    //   2220: iconst_2
    //   2221: iadd
    //   2222: aaload
    //   2223: aastore
    //   2224: goto -29 -> 2195
    //   2227: aload_2
    //   2228: iconst_0
    //   2229: aaload
    //   2230: astore 227
    //   2232: aload_2
    //   2233: iconst_1
    //   2234: aaload
    //   2235: astore 228
    //   2237: bipush 254
    //   2239: aload_2
    //   2240: arraylength
    //   2241: iadd
    //   2242: istore 229
    //   2244: iload 229
    //   2246: anewarray 325	java/lang/Object
    //   2249: astore 230
    //   2251: iinc 229 255
    //   2254: iload 229
    //   2256: ifge +13 -> 2269
    //   2259: aload 227
    //   2261: aload 228
    //   2263: aload 230
    //   2265: invokestatic 2973	gnu/kawa/slib/srfi13:isStringPrefixCi$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2268: areturn
    //   2269: aload 230
    //   2271: iload 229
    //   2273: aload_2
    //   2274: iload 229
    //   2276: iconst_2
    //   2277: iadd
    //   2278: aaload
    //   2279: aastore
    //   2280: goto -29 -> 2251
    //   2283: aload_2
    //   2284: iconst_0
    //   2285: aaload
    //   2286: astore 223
    //   2288: aload_2
    //   2289: iconst_1
    //   2290: aaload
    //   2291: astore 224
    //   2293: bipush 254
    //   2295: aload_2
    //   2296: arraylength
    //   2297: iadd
    //   2298: istore 225
    //   2300: iload 225
    //   2302: anewarray 325	java/lang/Object
    //   2305: astore 226
    //   2307: iinc 225 255
    //   2310: iload 225
    //   2312: ifge +13 -> 2325
    //   2315: aload 223
    //   2317: aload 224
    //   2319: aload 226
    //   2321: invokestatic 2975	gnu/kawa/slib/srfi13:isStringSuffixCi$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2324: areturn
    //   2325: aload 226
    //   2327: iload 225
    //   2329: aload_2
    //   2330: iload 225
    //   2332: iconst_2
    //   2333: iadd
    //   2334: aaload
    //   2335: aastore
    //   2336: goto -29 -> 2307
    //   2339: aload_2
    //   2340: iconst_0
    //   2341: aaload
    //   2342: aload_2
    //   2343: iconst_1
    //   2344: aaload
    //   2345: aload_2
    //   2346: iconst_2
    //   2347: aaload
    //   2348: aload_2
    //   2349: iconst_3
    //   2350: aaload
    //   2351: aload_2
    //   2352: iconst_4
    //   2353: aaload
    //   2354: aload_2
    //   2355: iconst_5
    //   2356: aaload
    //   2357: invokestatic 2977	gnu/kawa/slib/srfi13:$PcStringPrefix$Qu	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2360: areturn
    //   2361: aload_2
    //   2362: iconst_0
    //   2363: aaload
    //   2364: aload_2
    //   2365: iconst_1
    //   2366: aaload
    //   2367: aload_2
    //   2368: iconst_2
    //   2369: aaload
    //   2370: aload_2
    //   2371: iconst_3
    //   2372: aaload
    //   2373: aload_2
    //   2374: iconst_4
    //   2375: aaload
    //   2376: aload_2
    //   2377: iconst_5
    //   2378: aaload
    //   2379: invokestatic 2979	gnu/kawa/slib/srfi13:$PcStringSuffix$Qu	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2382: areturn
    //   2383: aload_2
    //   2384: iconst_0
    //   2385: aaload
    //   2386: aload_2
    //   2387: iconst_1
    //   2388: aaload
    //   2389: aload_2
    //   2390: iconst_2
    //   2391: aaload
    //   2392: aload_2
    //   2393: iconst_3
    //   2394: aaload
    //   2395: aload_2
    //   2396: iconst_4
    //   2397: aaload
    //   2398: aload_2
    //   2399: iconst_5
    //   2400: aaload
    //   2401: invokestatic 2981	gnu/kawa/slib/srfi13:$PcStringPrefixCi$Qu	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2404: areturn
    //   2405: aload_2
    //   2406: iconst_0
    //   2407: aaload
    //   2408: aload_2
    //   2409: iconst_1
    //   2410: aaload
    //   2411: aload_2
    //   2412: iconst_2
    //   2413: aaload
    //   2414: aload_2
    //   2415: iconst_3
    //   2416: aaload
    //   2417: aload_2
    //   2418: iconst_4
    //   2419: aaload
    //   2420: aload_2
    //   2421: iconst_5
    //   2422: aaload
    //   2423: invokestatic 2983	gnu/kawa/slib/srfi13:$PcStringSuffixCi$Qu	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2426: areturn
    //   2427: aload_2
    //   2428: iconst_0
    //   2429: aaload
    //   2430: aload_2
    //   2431: iconst_1
    //   2432: aaload
    //   2433: aload_2
    //   2434: iconst_2
    //   2435: aaload
    //   2436: aload_2
    //   2437: iconst_3
    //   2438: aaload
    //   2439: aload_2
    //   2440: iconst_4
    //   2441: aaload
    //   2442: aload_2
    //   2443: iconst_5
    //   2444: aaload
    //   2445: aload_2
    //   2446: bipush 6
    //   2448: aaload
    //   2449: aload_2
    //   2450: bipush 7
    //   2452: aaload
    //   2453: aload_2
    //   2454: bipush 8
    //   2456: aaload
    //   2457: invokestatic 2985	gnu/kawa/slib/srfi13:$PcStringCompare	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2460: areturn
    //   2461: aload_2
    //   2462: iconst_0
    //   2463: aaload
    //   2464: aload_2
    //   2465: iconst_1
    //   2466: aaload
    //   2467: aload_2
    //   2468: iconst_2
    //   2469: aaload
    //   2470: aload_2
    //   2471: iconst_3
    //   2472: aaload
    //   2473: aload_2
    //   2474: iconst_4
    //   2475: aaload
    //   2476: aload_2
    //   2477: iconst_5
    //   2478: aaload
    //   2479: aload_2
    //   2480: bipush 6
    //   2482: aaload
    //   2483: aload_2
    //   2484: bipush 7
    //   2486: aaload
    //   2487: aload_2
    //   2488: bipush 8
    //   2490: aaload
    //   2491: invokestatic 2987	gnu/kawa/slib/srfi13:$PcStringCompareCi	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2494: areturn
    //   2495: aload_2
    //   2496: iconst_0
    //   2497: aaload
    //   2498: astore 216
    //   2500: aload_2
    //   2501: iconst_1
    //   2502: aaload
    //   2503: astore 217
    //   2505: aload_2
    //   2506: iconst_2
    //   2507: aaload
    //   2508: astore 218
    //   2510: aload_2
    //   2511: iconst_3
    //   2512: aaload
    //   2513: astore 219
    //   2515: aload_2
    //   2516: iconst_4
    //   2517: aaload
    //   2518: astore 220
    //   2520: bipush 251
    //   2522: aload_2
    //   2523: arraylength
    //   2524: iadd
    //   2525: istore 221
    //   2527: iload 221
    //   2529: anewarray 325	java/lang/Object
    //   2532: astore 222
    //   2534: iinc 221 255
    //   2537: iload 221
    //   2539: ifge +19 -> 2558
    //   2542: aload 216
    //   2544: aload 217
    //   2546: aload 218
    //   2548: aload 219
    //   2550: aload 220
    //   2552: aload 222
    //   2554: invokestatic 2989	gnu/kawa/slib/srfi13:stringCompare$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2557: areturn
    //   2558: aload 222
    //   2560: iload 221
    //   2562: aload_2
    //   2563: iload 221
    //   2565: iconst_5
    //   2566: iadd
    //   2567: aaload
    //   2568: aastore
    //   2569: goto -35 -> 2534
    //   2572: aload_2
    //   2573: iconst_0
    //   2574: aaload
    //   2575: astore 209
    //   2577: aload_2
    //   2578: iconst_1
    //   2579: aaload
    //   2580: astore 210
    //   2582: aload_2
    //   2583: iconst_2
    //   2584: aaload
    //   2585: astore 211
    //   2587: aload_2
    //   2588: iconst_3
    //   2589: aaload
    //   2590: astore 212
    //   2592: aload_2
    //   2593: iconst_4
    //   2594: aaload
    //   2595: astore 213
    //   2597: bipush 251
    //   2599: aload_2
    //   2600: arraylength
    //   2601: iadd
    //   2602: istore 214
    //   2604: iload 214
    //   2606: anewarray 325	java/lang/Object
    //   2609: astore 215
    //   2611: iinc 214 255
    //   2614: iload 214
    //   2616: ifge +19 -> 2635
    //   2619: aload 209
    //   2621: aload 210
    //   2623: aload 211
    //   2625: aload 212
    //   2627: aload 213
    //   2629: aload 215
    //   2631: invokestatic 2991	gnu/kawa/slib/srfi13:stringCompareCi$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2634: areturn
    //   2635: aload 215
    //   2637: iload 214
    //   2639: aload_2
    //   2640: iload 214
    //   2642: iconst_5
    //   2643: iadd
    //   2644: aaload
    //   2645: aastore
    //   2646: goto -35 -> 2611
    //   2649: aload_2
    //   2650: iconst_0
    //   2651: aaload
    //   2652: astore 205
    //   2654: aload_2
    //   2655: iconst_1
    //   2656: aaload
    //   2657: astore 206
    //   2659: bipush 254
    //   2661: aload_2
    //   2662: arraylength
    //   2663: iadd
    //   2664: istore 207
    //   2666: iload 207
    //   2668: anewarray 325	java/lang/Object
    //   2671: astore 208
    //   2673: iinc 207 255
    //   2676: iload 207
    //   2678: ifge +13 -> 2691
    //   2681: aload 205
    //   2683: aload 206
    //   2685: aload 208
    //   2687: invokestatic 2993	gnu/kawa/slib/srfi13:string$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2690: areturn
    //   2691: aload 208
    //   2693: iload 207
    //   2695: aload_2
    //   2696: iload 207
    //   2698: iconst_2
    //   2699: iadd
    //   2700: aaload
    //   2701: aastore
    //   2702: goto -29 -> 2673
    //   2705: aload_2
    //   2706: iconst_0
    //   2707: aaload
    //   2708: astore 201
    //   2710: aload_2
    //   2711: iconst_1
    //   2712: aaload
    //   2713: astore 202
    //   2715: bipush 254
    //   2717: aload_2
    //   2718: arraylength
    //   2719: iadd
    //   2720: istore 203
    //   2722: iload 203
    //   2724: anewarray 325	java/lang/Object
    //   2727: astore 204
    //   2729: iinc 203 255
    //   2732: iload 203
    //   2734: ifge +13 -> 2747
    //   2737: aload 201
    //   2739: aload 202
    //   2741: aload 204
    //   2743: invokestatic 2995	gnu/kawa/slib/srfi13:string$Ls$Gr$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2746: areturn
    //   2747: aload 204
    //   2749: iload 203
    //   2751: aload_2
    //   2752: iload 203
    //   2754: iconst_2
    //   2755: iadd
    //   2756: aaload
    //   2757: aastore
    //   2758: goto -29 -> 2729
    //   2761: aload_2
    //   2762: iconst_0
    //   2763: aaload
    //   2764: astore 197
    //   2766: aload_2
    //   2767: iconst_1
    //   2768: aaload
    //   2769: astore 198
    //   2771: bipush 254
    //   2773: aload_2
    //   2774: arraylength
    //   2775: iadd
    //   2776: istore 199
    //   2778: iload 199
    //   2780: anewarray 325	java/lang/Object
    //   2783: astore 200
    //   2785: iinc 199 255
    //   2788: iload 199
    //   2790: ifge +13 -> 2803
    //   2793: aload 197
    //   2795: aload 198
    //   2797: aload 200
    //   2799: invokestatic 2997	gnu/kawa/slib/srfi13:string$Ls$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2802: areturn
    //   2803: aload 200
    //   2805: iload 199
    //   2807: aload_2
    //   2808: iload 199
    //   2810: iconst_2
    //   2811: iadd
    //   2812: aaload
    //   2813: aastore
    //   2814: goto -29 -> 2785
    //   2817: aload_2
    //   2818: iconst_0
    //   2819: aaload
    //   2820: astore 193
    //   2822: aload_2
    //   2823: iconst_1
    //   2824: aaload
    //   2825: astore 194
    //   2827: bipush 254
    //   2829: aload_2
    //   2830: arraylength
    //   2831: iadd
    //   2832: istore 195
    //   2834: iload 195
    //   2836: anewarray 325	java/lang/Object
    //   2839: astore 196
    //   2841: iinc 195 255
    //   2844: iload 195
    //   2846: ifge +13 -> 2859
    //   2849: aload 193
    //   2851: aload 194
    //   2853: aload 196
    //   2855: invokestatic 2999	gnu/kawa/slib/srfi13:string$Gr$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2858: areturn
    //   2859: aload 196
    //   2861: iload 195
    //   2863: aload_2
    //   2864: iload 195
    //   2866: iconst_2
    //   2867: iadd
    //   2868: aaload
    //   2869: aastore
    //   2870: goto -29 -> 2841
    //   2873: aload_2
    //   2874: iconst_0
    //   2875: aaload
    //   2876: astore 189
    //   2878: aload_2
    //   2879: iconst_1
    //   2880: aaload
    //   2881: astore 190
    //   2883: bipush 254
    //   2885: aload_2
    //   2886: arraylength
    //   2887: iadd
    //   2888: istore 191
    //   2890: iload 191
    //   2892: anewarray 325	java/lang/Object
    //   2895: astore 192
    //   2897: iinc 191 255
    //   2900: iload 191
    //   2902: ifge +13 -> 2915
    //   2905: aload 189
    //   2907: aload 190
    //   2909: aload 192
    //   2911: invokestatic 3001	gnu/kawa/slib/srfi13:string$Ls$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2914: areturn
    //   2915: aload 192
    //   2917: iload 191
    //   2919: aload_2
    //   2920: iload 191
    //   2922: iconst_2
    //   2923: iadd
    //   2924: aaload
    //   2925: aastore
    //   2926: goto -29 -> 2897
    //   2929: aload_2
    //   2930: iconst_0
    //   2931: aaload
    //   2932: astore 185
    //   2934: aload_2
    //   2935: iconst_1
    //   2936: aaload
    //   2937: astore 186
    //   2939: bipush 254
    //   2941: aload_2
    //   2942: arraylength
    //   2943: iadd
    //   2944: istore 187
    //   2946: iload 187
    //   2948: anewarray 325	java/lang/Object
    //   2951: astore 188
    //   2953: iinc 187 255
    //   2956: iload 187
    //   2958: ifge +13 -> 2971
    //   2961: aload 185
    //   2963: aload 186
    //   2965: aload 188
    //   2967: invokestatic 3003	gnu/kawa/slib/srfi13:string$Gr$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2970: areturn
    //   2971: aload 188
    //   2973: iload 187
    //   2975: aload_2
    //   2976: iload 187
    //   2978: iconst_2
    //   2979: iadd
    //   2980: aaload
    //   2981: aastore
    //   2982: goto -29 -> 2953
    //   2985: aload_2
    //   2986: iconst_0
    //   2987: aaload
    //   2988: astore 181
    //   2990: aload_2
    //   2991: iconst_1
    //   2992: aaload
    //   2993: astore 182
    //   2995: bipush 254
    //   2997: aload_2
    //   2998: arraylength
    //   2999: iadd
    //   3000: istore 183
    //   3002: iload 183
    //   3004: anewarray 325	java/lang/Object
    //   3007: astore 184
    //   3009: iinc 183 255
    //   3012: iload 183
    //   3014: ifge +13 -> 3027
    //   3017: aload 181
    //   3019: aload 182
    //   3021: aload 184
    //   3023: invokestatic 3005	gnu/kawa/slib/srfi13:stringCi$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3026: areturn
    //   3027: aload 184
    //   3029: iload 183
    //   3031: aload_2
    //   3032: iload 183
    //   3034: iconst_2
    //   3035: iadd
    //   3036: aaload
    //   3037: aastore
    //   3038: goto -29 -> 3009
    //   3041: aload_2
    //   3042: iconst_0
    //   3043: aaload
    //   3044: astore 177
    //   3046: aload_2
    //   3047: iconst_1
    //   3048: aaload
    //   3049: astore 178
    //   3051: bipush 254
    //   3053: aload_2
    //   3054: arraylength
    //   3055: iadd
    //   3056: istore 179
    //   3058: iload 179
    //   3060: anewarray 325	java/lang/Object
    //   3063: astore 180
    //   3065: iinc 179 255
    //   3068: iload 179
    //   3070: ifge +13 -> 3083
    //   3073: aload 177
    //   3075: aload 178
    //   3077: aload 180
    //   3079: invokestatic 3007	gnu/kawa/slib/srfi13:stringCi$Ls$Gr$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3082: areturn
    //   3083: aload 180
    //   3085: iload 179
    //   3087: aload_2
    //   3088: iload 179
    //   3090: iconst_2
    //   3091: iadd
    //   3092: aaload
    //   3093: aastore
    //   3094: goto -29 -> 3065
    //   3097: aload_2
    //   3098: iconst_0
    //   3099: aaload
    //   3100: astore 173
    //   3102: aload_2
    //   3103: iconst_1
    //   3104: aaload
    //   3105: astore 174
    //   3107: bipush 254
    //   3109: aload_2
    //   3110: arraylength
    //   3111: iadd
    //   3112: istore 175
    //   3114: iload 175
    //   3116: anewarray 325	java/lang/Object
    //   3119: astore 176
    //   3121: iinc 175 255
    //   3124: iload 175
    //   3126: ifge +13 -> 3139
    //   3129: aload 173
    //   3131: aload 174
    //   3133: aload 176
    //   3135: invokestatic 3009	gnu/kawa/slib/srfi13:stringCi$Ls$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3138: areturn
    //   3139: aload 176
    //   3141: iload 175
    //   3143: aload_2
    //   3144: iload 175
    //   3146: iconst_2
    //   3147: iadd
    //   3148: aaload
    //   3149: aastore
    //   3150: goto -29 -> 3121
    //   3153: aload_2
    //   3154: iconst_0
    //   3155: aaload
    //   3156: astore 169
    //   3158: aload_2
    //   3159: iconst_1
    //   3160: aaload
    //   3161: astore 170
    //   3163: bipush 254
    //   3165: aload_2
    //   3166: arraylength
    //   3167: iadd
    //   3168: istore 171
    //   3170: iload 171
    //   3172: anewarray 325	java/lang/Object
    //   3175: astore 172
    //   3177: iinc 171 255
    //   3180: iload 171
    //   3182: ifge +13 -> 3195
    //   3185: aload 169
    //   3187: aload 170
    //   3189: aload 172
    //   3191: invokestatic 3011	gnu/kawa/slib/srfi13:stringCi$Gr$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3194: areturn
    //   3195: aload 172
    //   3197: iload 171
    //   3199: aload_2
    //   3200: iload 171
    //   3202: iconst_2
    //   3203: iadd
    //   3204: aaload
    //   3205: aastore
    //   3206: goto -29 -> 3177
    //   3209: aload_2
    //   3210: iconst_0
    //   3211: aaload
    //   3212: astore 165
    //   3214: aload_2
    //   3215: iconst_1
    //   3216: aaload
    //   3217: astore 166
    //   3219: bipush 254
    //   3221: aload_2
    //   3222: arraylength
    //   3223: iadd
    //   3224: istore 167
    //   3226: iload 167
    //   3228: anewarray 325	java/lang/Object
    //   3231: astore 168
    //   3233: iinc 167 255
    //   3236: iload 167
    //   3238: ifge +13 -> 3251
    //   3241: aload 165
    //   3243: aload 166
    //   3245: aload 168
    //   3247: invokestatic 3013	gnu/kawa/slib/srfi13:stringCi$Ls$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3250: areturn
    //   3251: aload 168
    //   3253: iload 167
    //   3255: aload_2
    //   3256: iload 167
    //   3258: iconst_2
    //   3259: iadd
    //   3260: aaload
    //   3261: aastore
    //   3262: goto -29 -> 3233
    //   3265: aload_2
    //   3266: iconst_0
    //   3267: aaload
    //   3268: astore 161
    //   3270: aload_2
    //   3271: iconst_1
    //   3272: aaload
    //   3273: astore 162
    //   3275: bipush 254
    //   3277: aload_2
    //   3278: arraylength
    //   3279: iadd
    //   3280: istore 163
    //   3282: iload 163
    //   3284: anewarray 325	java/lang/Object
    //   3287: astore 164
    //   3289: iinc 163 255
    //   3292: iload 163
    //   3294: ifge +13 -> 3307
    //   3297: aload 161
    //   3299: aload 162
    //   3301: aload 164
    //   3303: invokestatic 3015	gnu/kawa/slib/srfi13:stringCi$Gr$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3306: areturn
    //   3307: aload 164
    //   3309: iload 163
    //   3311: aload_2
    //   3312: iload 163
    //   3314: iconst_2
    //   3315: iadd
    //   3316: aaload
    //   3317: aastore
    //   3318: goto -29 -> 3289
    //   3321: aload_2
    //   3322: iconst_0
    //   3323: aaload
    //   3324: aload_2
    //   3325: iconst_1
    //   3326: aaload
    //   3327: aload_2
    //   3328: iconst_2
    //   3329: aaload
    //   3330: aload_2
    //   3331: iconst_3
    //   3332: aaload
    //   3333: aload_2
    //   3334: iconst_4
    //   3335: aaload
    //   3336: invokestatic 3017	gnu/kawa/slib/srfi13:$PcStringHash	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3339: areturn
    //   3340: aload_2
    //   3341: iconst_0
    //   3342: aaload
    //   3343: astore 158
    //   3345: iconst_m1
    //   3346: aload_2
    //   3347: arraylength
    //   3348: iadd
    //   3349: istore 159
    //   3351: iload 159
    //   3353: anewarray 325	java/lang/Object
    //   3356: astore 160
    //   3358: iinc 159 255
    //   3361: iload 159
    //   3363: ifge +11 -> 3374
    //   3366: aload 158
    //   3368: aload 160
    //   3370: invokestatic 3019	gnu/kawa/slib/srfi13:stringHash$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3373: areturn
    //   3374: aload 160
    //   3376: iload 159
    //   3378: aload_2
    //   3379: iload 159
    //   3381: iconst_1
    //   3382: iadd
    //   3383: aaload
    //   3384: aastore
    //   3385: goto -27 -> 3358
    //   3388: aload_2
    //   3389: iconst_0
    //   3390: aaload
    //   3391: astore 155
    //   3393: iconst_m1
    //   3394: aload_2
    //   3395: arraylength
    //   3396: iadd
    //   3397: istore 156
    //   3399: iload 156
    //   3401: anewarray 325	java/lang/Object
    //   3404: astore 157
    //   3406: iinc 156 255
    //   3409: iload 156
    //   3411: ifge +11 -> 3422
    //   3414: aload 155
    //   3416: aload 157
    //   3418: invokestatic 3021	gnu/kawa/slib/srfi13:stringHashCi$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3421: areturn
    //   3422: aload 157
    //   3424: iload 156
    //   3426: aload_2
    //   3427: iload 156
    //   3429: iconst_1
    //   3430: iadd
    //   3431: aaload
    //   3432: aastore
    //   3433: goto -27 -> 3406
    //   3436: aload_2
    //   3437: iconst_0
    //   3438: aaload
    //   3439: astore 152
    //   3441: iconst_m1
    //   3442: aload_2
    //   3443: arraylength
    //   3444: iadd
    //   3445: istore 153
    //   3447: iload 153
    //   3449: anewarray 325	java/lang/Object
    //   3452: astore 154
    //   3454: iinc 153 255
    //   3457: iload 153
    //   3459: ifge +11 -> 3470
    //   3462: aload 152
    //   3464: aload 154
    //   3466: invokestatic 3023	gnu/kawa/slib/srfi13:stringUpcase$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3469: areturn
    //   3470: aload 154
    //   3472: iload 153
    //   3474: aload_2
    //   3475: iload 153
    //   3477: iconst_1
    //   3478: iadd
    //   3479: aaload
    //   3480: aastore
    //   3481: goto -27 -> 3454
    //   3484: aload_2
    //   3485: iconst_0
    //   3486: aaload
    //   3487: astore 149
    //   3489: iconst_m1
    //   3490: aload_2
    //   3491: arraylength
    //   3492: iadd
    //   3493: istore 150
    //   3495: iload 150
    //   3497: anewarray 325	java/lang/Object
    //   3500: astore 151
    //   3502: iinc 150 255
    //   3505: iload 150
    //   3507: ifge +11 -> 3518
    //   3510: aload 149
    //   3512: aload 151
    //   3514: invokestatic 3025	gnu/kawa/slib/srfi13:stringUpcase$Ex$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3517: areturn
    //   3518: aload 151
    //   3520: iload 150
    //   3522: aload_2
    //   3523: iload 150
    //   3525: iconst_1
    //   3526: iadd
    //   3527: aaload
    //   3528: aastore
    //   3529: goto -27 -> 3502
    //   3532: aload_2
    //   3533: iconst_0
    //   3534: aaload
    //   3535: astore 146
    //   3537: iconst_m1
    //   3538: aload_2
    //   3539: arraylength
    //   3540: iadd
    //   3541: istore 147
    //   3543: iload 147
    //   3545: anewarray 325	java/lang/Object
    //   3548: astore 148
    //   3550: iinc 147 255
    //   3553: iload 147
    //   3555: ifge +11 -> 3566
    //   3558: aload 146
    //   3560: aload 148
    //   3562: invokestatic 3027	gnu/kawa/slib/srfi13:stringDowncase$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3565: areturn
    //   3566: aload 148
    //   3568: iload 147
    //   3570: aload_2
    //   3571: iload 147
    //   3573: iconst_1
    //   3574: iadd
    //   3575: aaload
    //   3576: aastore
    //   3577: goto -27 -> 3550
    //   3580: aload_2
    //   3581: iconst_0
    //   3582: aaload
    //   3583: astore 143
    //   3585: iconst_m1
    //   3586: aload_2
    //   3587: arraylength
    //   3588: iadd
    //   3589: istore 144
    //   3591: iload 144
    //   3593: anewarray 325	java/lang/Object
    //   3596: astore 145
    //   3598: iinc 144 255
    //   3601: iload 144
    //   3603: ifge +11 -> 3614
    //   3606: aload 143
    //   3608: aload 145
    //   3610: invokestatic 625	gnu/kawa/slib/srfi13:stringDowncase$Ex$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3613: areturn
    //   3614: aload 145
    //   3616: iload 144
    //   3618: aload_2
    //   3619: iload 144
    //   3621: iconst_1
    //   3622: iadd
    //   3623: aaload
    //   3624: aastore
    //   3625: goto -27 -> 3598
    //   3628: aload_2
    //   3629: iconst_0
    //   3630: aaload
    //   3631: astore 140
    //   3633: iconst_m1
    //   3634: aload_2
    //   3635: arraylength
    //   3636: iadd
    //   3637: istore 141
    //   3639: iload 141
    //   3641: anewarray 325	java/lang/Object
    //   3644: astore 142
    //   3646: iinc 141 255
    //   3649: iload 141
    //   3651: ifge +11 -> 3662
    //   3654: aload 140
    //   3656: aload 142
    //   3658: invokestatic 3029	gnu/kawa/slib/srfi13:stringTitlecase$Ex$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3661: areturn
    //   3662: aload 142
    //   3664: iload 141
    //   3666: aload_2
    //   3667: iload 141
    //   3669: iconst_1
    //   3670: iadd
    //   3671: aaload
    //   3672: aastore
    //   3673: goto -27 -> 3646
    //   3676: aload_2
    //   3677: iconst_0
    //   3678: aaload
    //   3679: astore 137
    //   3681: iconst_m1
    //   3682: aload_2
    //   3683: arraylength
    //   3684: iadd
    //   3685: istore 138
    //   3687: iload 138
    //   3689: anewarray 325	java/lang/Object
    //   3692: astore 139
    //   3694: iinc 138 255
    //   3697: iload 138
    //   3699: ifge +11 -> 3710
    //   3702: aload 137
    //   3704: aload 139
    //   3706: invokestatic 3031	gnu/kawa/slib/srfi13:stringTitlecase$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3709: areturn
    //   3710: aload 139
    //   3712: iload 138
    //   3714: aload_2
    //   3715: iload 138
    //   3717: iconst_1
    //   3718: iadd
    //   3719: aaload
    //   3720: aastore
    //   3721: goto -27 -> 3694
    //   3724: aload_2
    //   3725: iconst_0
    //   3726: aaload
    //   3727: astore 134
    //   3729: iconst_m1
    //   3730: aload_2
    //   3731: arraylength
    //   3732: iadd
    //   3733: istore 135
    //   3735: iload 135
    //   3737: anewarray 325	java/lang/Object
    //   3740: astore 136
    //   3742: iinc 135 255
    //   3745: iload 135
    //   3747: ifge +11 -> 3758
    //   3750: aload 134
    //   3752: aload 136
    //   3754: invokestatic 3033	gnu/kawa/slib/srfi13:stringTrim$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3757: areturn
    //   3758: aload 136
    //   3760: iload 135
    //   3762: aload_2
    //   3763: iload 135
    //   3765: iconst_1
    //   3766: iadd
    //   3767: aaload
    //   3768: aastore
    //   3769: goto -27 -> 3742
    //   3772: aload_2
    //   3773: iconst_0
    //   3774: aaload
    //   3775: astore 131
    //   3777: iconst_m1
    //   3778: aload_2
    //   3779: arraylength
    //   3780: iadd
    //   3781: istore 132
    //   3783: iload 132
    //   3785: anewarray 325	java/lang/Object
    //   3788: astore 133
    //   3790: iinc 132 255
    //   3793: iload 132
    //   3795: ifge +11 -> 3806
    //   3798: aload 131
    //   3800: aload 133
    //   3802: invokestatic 3035	gnu/kawa/slib/srfi13:stringTrimRight$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3805: areturn
    //   3806: aload 133
    //   3808: iload 132
    //   3810: aload_2
    //   3811: iload 132
    //   3813: iconst_1
    //   3814: iadd
    //   3815: aaload
    //   3816: aastore
    //   3817: goto -27 -> 3790
    //   3820: aload_2
    //   3821: iconst_0
    //   3822: aaload
    //   3823: astore 128
    //   3825: iconst_m1
    //   3826: aload_2
    //   3827: arraylength
    //   3828: iadd
    //   3829: istore 129
    //   3831: iload 129
    //   3833: anewarray 325	java/lang/Object
    //   3836: astore 130
    //   3838: iinc 129 255
    //   3841: iload 129
    //   3843: ifge +11 -> 3854
    //   3846: aload 128
    //   3848: aload 130
    //   3850: invokestatic 3037	gnu/kawa/slib/srfi13:stringTrimBoth$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3853: areturn
    //   3854: aload 130
    //   3856: iload 129
    //   3858: aload_2
    //   3859: iload 129
    //   3861: iconst_1
    //   3862: iadd
    //   3863: aaload
    //   3864: aastore
    //   3865: goto -27 -> 3838
    //   3868: aload_2
    //   3869: iconst_0
    //   3870: aaload
    //   3871: astore 124
    //   3873: aload_2
    //   3874: iconst_1
    //   3875: aaload
    //   3876: astore 125
    //   3878: bipush 254
    //   3880: aload_2
    //   3881: arraylength
    //   3882: iadd
    //   3883: istore 126
    //   3885: iload 126
    //   3887: anewarray 325	java/lang/Object
    //   3890: astore 127
    //   3892: iinc 126 255
    //   3895: iload 126
    //   3897: ifge +13 -> 3910
    //   3900: aload 124
    //   3902: aload 125
    //   3904: aload 127
    //   3906: invokestatic 3039	gnu/kawa/slib/srfi13:stringPadRight$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3909: areturn
    //   3910: aload 127
    //   3912: iload 126
    //   3914: aload_2
    //   3915: iload 126
    //   3917: iconst_2
    //   3918: iadd
    //   3919: aaload
    //   3920: aastore
    //   3921: goto -29 -> 3892
    //   3924: aload_2
    //   3925: iconst_0
    //   3926: aaload
    //   3927: astore 120
    //   3929: aload_2
    //   3930: iconst_1
    //   3931: aaload
    //   3932: astore 121
    //   3934: bipush 254
    //   3936: aload_2
    //   3937: arraylength
    //   3938: iadd
    //   3939: istore 122
    //   3941: iload 122
    //   3943: anewarray 325	java/lang/Object
    //   3946: astore 123
    //   3948: iinc 122 255
    //   3951: iload 122
    //   3953: ifge +13 -> 3966
    //   3956: aload 120
    //   3958: aload 121
    //   3960: aload 123
    //   3962: invokestatic 3041	gnu/kawa/slib/srfi13:stringPad$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3965: areturn
    //   3966: aload 123
    //   3968: iload 122
    //   3970: aload_2
    //   3971: iload 122
    //   3973: iconst_2
    //   3974: iadd
    //   3975: aaload
    //   3976: aastore
    //   3977: goto -29 -> 3948
    //   3980: aload_2
    //   3981: iconst_0
    //   3982: aaload
    //   3983: astore 116
    //   3985: aload_2
    //   3986: iconst_1
    //   3987: aaload
    //   3988: astore 117
    //   3990: bipush 254
    //   3992: aload_2
    //   3993: arraylength
    //   3994: iadd
    //   3995: istore 118
    //   3997: iload 118
    //   3999: anewarray 325	java/lang/Object
    //   4002: astore 119
    //   4004: iinc 118 255
    //   4007: iload 118
    //   4009: ifge +13 -> 4022
    //   4012: aload 116
    //   4014: aload 117
    //   4016: aload 119
    //   4018: invokestatic 3043	gnu/kawa/slib/srfi13:stringDelete$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   4021: areturn
    //   4022: aload 119
    //   4024: iload 118
    //   4026: aload_2
    //   4027: iload 118
    //   4029: iconst_2
    //   4030: iadd
    //   4031: aaload
    //   4032: aastore
    //   4033: goto -29 -> 4004
    //   4036: aload_2
    //   4037: iconst_0
    //   4038: aaload
    //   4039: astore 112
    //   4041: aload_2
    //   4042: iconst_1
    //   4043: aaload
    //   4044: astore 113
    //   4046: bipush 254
    //   4048: aload_2
    //   4049: arraylength
    //   4050: iadd
    //   4051: istore 114
    //   4053: iload 114
    //   4055: anewarray 325	java/lang/Object
    //   4058: astore 115
    //   4060: iinc 114 255
    //   4063: iload 114
    //   4065: ifge +13 -> 4078
    //   4068: aload 112
    //   4070: aload 113
    //   4072: aload 115
    //   4074: invokestatic 3045	gnu/kawa/slib/srfi13:stringFilter$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   4077: areturn
    //   4078: aload 115
    //   4080: iload 114
    //   4082: aload_2
    //   4083: iload 114
    //   4085: iconst_2
    //   4086: iadd
    //   4087: aaload
    //   4088: aastore
    //   4089: goto -29 -> 4060
    //   4092: aload_2
    //   4093: iconst_0
    //   4094: aaload
    //   4095: astore 108
    //   4097: aload_2
    //   4098: iconst_1
    //   4099: aaload
    //   4100: astore 109
    //   4102: bipush 254
    //   4104: aload_2
    //   4105: arraylength
    //   4106: iadd
    //   4107: istore 110
    //   4109: iload 110
    //   4111: anewarray 325	java/lang/Object
    //   4114: astore 111
    //   4116: iinc 110 255
    //   4119: iload 110
    //   4121: ifge +13 -> 4134
    //   4124: aload 108
    //   4126: aload 109
    //   4128: aload 111
    //   4130: invokestatic 615	gnu/kawa/slib/srfi13:stringIndex$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   4133: areturn
    //   4134: aload 111
    //   4136: iload 110
    //   4138: aload_2
    //   4139: iload 110
    //   4141: iconst_2
    //   4142: iadd
    //   4143: aaload
    //   4144: aastore
    //   4145: goto -29 -> 4116
    //   4148: aload_2
    //   4149: iconst_0
    //   4150: aaload
    //   4151: astore 104
    //   4153: aload_2
    //   4154: iconst_1
    //   4155: aaload
    //   4156: astore 105
    //   4158: bipush 254
    //   4160: aload_2
    //   4161: arraylength
    //   4162: iadd
    //   4163: istore 106
    //   4165: iload 106
    //   4167: anewarray 325	java/lang/Object
    //   4170: astore 107
    //   4172: iinc 106 255
    //   4175: iload 106
    //   4177: ifge +13 -> 4190
    //   4180: aload 104
    //   4182: aload 105
    //   4184: aload 107
    //   4186: invokestatic 3047	gnu/kawa/slib/srfi13:stringIndexRight$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   4189: areturn
    //   4190: aload 107
    //   4192: iload 106
    //   4194: aload_2
    //   4195: iload 106
    //   4197: iconst_2
    //   4198: iadd
    //   4199: aaload
    //   4200: aastore
    //   4201: goto -29 -> 4172
    //   4204: aload_2
    //   4205: iconst_0
    //   4206: aaload
    //   4207: astore 100
    //   4209: aload_2
    //   4210: iconst_1
    //   4211: aaload
    //   4212: astore 101
    //   4214: bipush 254
    //   4216: aload_2
    //   4217: arraylength
    //   4218: iadd
    //   4219: istore 102
    //   4221: iload 102
    //   4223: anewarray 325	java/lang/Object
    //   4226: astore 103
    //   4228: iinc 102 255
    //   4231: iload 102
    //   4233: ifge +13 -> 4246
    //   4236: aload 100
    //   4238: aload 101
    //   4240: aload 103
    //   4242: invokestatic 622	gnu/kawa/slib/srfi13:stringSkip$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   4245: areturn
    //   4246: aload 103
    //   4248: iload 102
    //   4250: aload_2
    //   4251: iload 102
    //   4253: iconst_2
    //   4254: iadd
    //   4255: aaload
    //   4256: aastore
    //   4257: goto -29 -> 4228
    //   4260: aload_2
    //   4261: iconst_0
    //   4262: aaload
    //   4263: astore 96
    //   4265: aload_2
    //   4266: iconst_1
    //   4267: aaload
    //   4268: astore 97
    //   4270: bipush 254
    //   4272: aload_2
    //   4273: arraylength
    //   4274: iadd
    //   4275: istore 98
    //   4277: iload 98
    //   4279: anewarray 325	java/lang/Object
    //   4282: astore 99
    //   4284: iinc 98 255
    //   4287: iload 98
    //   4289: ifge +13 -> 4302
    //   4292: aload 96
    //   4294: aload 97
    //   4296: aload 99
    //   4298: invokestatic 3049	gnu/kawa/slib/srfi13:stringSkipRight$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   4301: areturn
    //   4302: aload 99
    //   4304: iload 98
    //   4306: aload_2
    //   4307: iload 98
    //   4309: iconst_2
    //   4310: iadd
    //   4311: aaload
    //   4312: aastore
    //   4313: goto -29 -> 4284
    //   4316: aload_2
    //   4317: iconst_0
    //   4318: aaload
    //   4319: astore 92
    //   4321: aload_2
    //   4322: iconst_1
    //   4323: aaload
    //   4324: astore 93
    //   4326: bipush 254
    //   4328: aload_2
    //   4329: arraylength
    //   4330: iadd
    //   4331: istore 94
    //   4333: iload 94
    //   4335: anewarray 325	java/lang/Object
    //   4338: astore 95
    //   4340: iinc 94 255
    //   4343: iload 94
    //   4345: ifge +13 -> 4358
    //   4348: aload 92
    //   4350: aload 93
    //   4352: aload 95
    //   4354: invokestatic 3051	gnu/kawa/slib/srfi13:stringCount$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   4357: areturn
    //   4358: aload 95
    //   4360: iload 94
    //   4362: aload_2
    //   4363: iload 94
    //   4365: iconst_2
    //   4366: iadd
    //   4367: aaload
    //   4368: aastore
    //   4369: goto -29 -> 4340
    //   4372: aload_2
    //   4373: iconst_0
    //   4374: aaload
    //   4375: astore 88
    //   4377: aload_2
    //   4378: iconst_1
    //   4379: aaload
    //   4380: astore 89
    //   4382: bipush 254
    //   4384: aload_2
    //   4385: arraylength
    //   4386: iadd
    //   4387: istore 90
    //   4389: iload 90
    //   4391: anewarray 325	java/lang/Object
    //   4394: astore 91
    //   4396: iinc 90 255
    //   4399: iload 90
    //   4401: ifge +13 -> 4414
    //   4404: aload 88
    //   4406: aload 89
    //   4408: aload 91
    //   4410: invokestatic 3053	gnu/kawa/slib/srfi13:stringFill$Ex$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   4413: areturn
    //   4414: aload 91
    //   4416: iload 90
    //   4418: aload_2
    //   4419: iload 90
    //   4421: iconst_2
    //   4422: iadd
    //   4423: aaload
    //   4424: aastore
    //   4425: goto -29 -> 4396
    //   4428: bipush 253
    //   4430: aload_2
    //   4431: arraylength
    //   4432: iadd
    //   4433: istore 72
    //   4435: aload_2
    //   4436: iconst_0
    //   4437: aaload
    //   4438: astore 73
    //   4440: aload_2
    //   4441: iconst_1
    //   4442: aaload
    //   4443: astore 74
    //   4445: aload 74
    //   4447: checkcast 376	java/lang/Number
    //   4450: invokevirtual 380	java/lang/Number:intValue	()I
    //   4453: istore 76
    //   4455: aload_2
    //   4456: iconst_2
    //   4457: aaload
    //   4458: astore 77
    //   4460: aload 77
    //   4462: checkcast 386	java/lang/CharSequence
    //   4465: astore 79
    //   4467: iload 72
    //   4469: ifgt +13 -> 4482
    //   4472: aload 73
    //   4474: iload 76
    //   4476: aload 79
    //   4478: invokestatic 2926	gnu/kawa/slib/srfi13:stringCopy$Ex	(Ljava/lang/Object;ILjava/lang/CharSequence;)Ljava/lang/Object;
    //   4481: areturn
    //   4482: iload 72
    //   4484: iconst_1
    //   4485: isub
    //   4486: istore 80
    //   4488: aload_2
    //   4489: iconst_3
    //   4490: aaload
    //   4491: astore 81
    //   4493: aload 81
    //   4495: checkcast 376	java/lang/Number
    //   4498: invokevirtual 380	java/lang/Number:intValue	()I
    //   4501: istore 83
    //   4503: iload 80
    //   4505: ifgt +15 -> 4520
    //   4508: aload 73
    //   4510: iload 76
    //   4512: aload 79
    //   4514: iload 83
    //   4516: invokestatic 2079	gnu/kawa/slib/srfi13:stringCopy$Ex	(Ljava/lang/Object;ILjava/lang/CharSequence;I)Ljava/lang/Object;
    //   4519: areturn
    //   4520: iload 80
    //   4522: iconst_1
    //   4523: isub
    //   4524: pop
    //   4525: aload_2
    //   4526: iconst_4
    //   4527: aaload
    //   4528: astore 85
    //   4530: aload 85
    //   4532: checkcast 376	java/lang/Number
    //   4535: invokevirtual 380	java/lang/Number:intValue	()I
    //   4538: istore 87
    //   4540: aload 73
    //   4542: iload 76
    //   4544: aload 79
    //   4546: iload 83
    //   4548: iload 87
    //   4550: invokestatic 2084	gnu/kawa/slib/srfi13:stringCopy$Ex	(Ljava/lang/Object;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   4553: areturn
    //   4554: aload_2
    //   4555: iconst_0
    //   4556: aaload
    //   4557: astore 57
    //   4559: aload 57
    //   4561: checkcast 386	java/lang/CharSequence
    //   4564: astore 59
    //   4566: aload_2
    //   4567: iconst_1
    //   4568: aaload
    //   4569: astore 60
    //   4571: aload 60
    //   4573: checkcast 376	java/lang/Number
    //   4576: invokevirtual 380	java/lang/Number:intValue	()I
    //   4579: istore 62
    //   4581: aload_2
    //   4582: iconst_2
    //   4583: aaload
    //   4584: astore 63
    //   4586: aload 63
    //   4588: checkcast 386	java/lang/CharSequence
    //   4591: astore 65
    //   4593: aload_2
    //   4594: iconst_3
    //   4595: aaload
    //   4596: astore 66
    //   4598: aload 66
    //   4600: checkcast 376	java/lang/Number
    //   4603: invokevirtual 380	java/lang/Number:intValue	()I
    //   4606: istore 68
    //   4608: aload_2
    //   4609: iconst_4
    //   4610: aaload
    //   4611: astore 69
    //   4613: aload 69
    //   4615: checkcast 376	java/lang/Number
    //   4618: invokevirtual 380	java/lang/Number:intValue	()I
    //   4621: istore 71
    //   4623: aload 59
    //   4625: iload 62
    //   4627: aload 65
    //   4629: iload 68
    //   4631: iload 71
    //   4633: invokestatic 390	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   4636: areturn
    //   4637: aload_2
    //   4638: iconst_0
    //   4639: aaload
    //   4640: astore 53
    //   4642: aload_2
    //   4643: iconst_1
    //   4644: aaload
    //   4645: astore 54
    //   4647: bipush 254
    //   4649: aload_2
    //   4650: arraylength
    //   4651: iadd
    //   4652: istore 55
    //   4654: iload 55
    //   4656: anewarray 325	java/lang/Object
    //   4659: astore 56
    //   4661: iinc 55 255
    //   4664: iload 55
    //   4666: ifge +13 -> 4679
    //   4669: aload 53
    //   4671: aload 54
    //   4673: aload 56
    //   4675: invokestatic 3055	gnu/kawa/slib/srfi13:stringContains$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   4678: areturn
    //   4679: aload 56
    //   4681: iload 55
    //   4683: aload_2
    //   4684: iload 55
    //   4686: iconst_2
    //   4687: iadd
    //   4688: aaload
    //   4689: aastore
    //   4690: goto -29 -> 4661
    //   4693: aload_2
    //   4694: iconst_0
    //   4695: aaload
    //   4696: astore 49
    //   4698: aload_2
    //   4699: iconst_1
    //   4700: aaload
    //   4701: astore 50
    //   4703: bipush 254
    //   4705: aload_2
    //   4706: arraylength
    //   4707: iadd
    //   4708: istore 51
    //   4710: iload 51
    //   4712: anewarray 325	java/lang/Object
    //   4715: astore 52
    //   4717: iinc 51 255
    //   4720: iload 51
    //   4722: ifge +13 -> 4735
    //   4725: aload 49
    //   4727: aload 50
    //   4729: aload 52
    //   4731: invokestatic 3057	gnu/kawa/slib/srfi13:stringContainsCi$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   4734: areturn
    //   4735: aload 52
    //   4737: iload 51
    //   4739: aload_2
    //   4740: iload 51
    //   4742: iconst_2
    //   4743: iadd
    //   4744: aaload
    //   4745: aastore
    //   4746: goto -29 -> 4717
    //   4749: aload_2
    //   4750: iconst_0
    //   4751: aaload
    //   4752: aload_2
    //   4753: iconst_1
    //   4754: aaload
    //   4755: aload_2
    //   4756: iconst_2
    //   4757: aaload
    //   4758: aload_2
    //   4759: iconst_3
    //   4760: aaload
    //   4761: aload_2
    //   4762: iconst_4
    //   4763: aaload
    //   4764: aload_2
    //   4765: iconst_5
    //   4766: aaload
    //   4767: aload_2
    //   4768: bipush 6
    //   4770: aaload
    //   4771: invokestatic 3059	gnu/kawa/slib/srfi13:$PcKmpSearch	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4774: areturn
    //   4775: aload_2
    //   4776: iconst_0
    //   4777: aaload
    //   4778: astore 46
    //   4780: iconst_m1
    //   4781: aload_2
    //   4782: arraylength
    //   4783: iadd
    //   4784: istore 47
    //   4786: iload 47
    //   4788: anewarray 325	java/lang/Object
    //   4791: astore 48
    //   4793: iinc 47 255
    //   4796: iload 47
    //   4798: ifge +11 -> 4809
    //   4801: aload 46
    //   4803: aload 48
    //   4805: invokestatic 427	gnu/kawa/slib/srfi13:makeKmpRestartVector$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   4808: areturn
    //   4809: aload 48
    //   4811: iload 47
    //   4813: aload_2
    //   4814: iload 47
    //   4816: iconst_1
    //   4817: iadd
    //   4818: aaload
    //   4819: aastore
    //   4820: goto -27 -> 4793
    //   4823: aload_2
    //   4824: iconst_0
    //   4825: aaload
    //   4826: aload_2
    //   4827: iconst_1
    //   4828: aaload
    //   4829: aload_2
    //   4830: iconst_2
    //   4831: aaload
    //   4832: aload_2
    //   4833: iconst_3
    //   4834: aaload
    //   4835: aload_2
    //   4836: iconst_4
    //   4837: aaload
    //   4838: aload_2
    //   4839: iconst_5
    //   4840: aaload
    //   4841: invokestatic 3061	gnu/kawa/slib/srfi13:kmpStep	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4844: areturn
    //   4845: aload_2
    //   4846: iconst_0
    //   4847: aaload
    //   4848: astore 40
    //   4850: aload_2
    //   4851: iconst_1
    //   4852: aaload
    //   4853: astore 41
    //   4855: aload_2
    //   4856: iconst_2
    //   4857: aaload
    //   4858: astore 42
    //   4860: aload_2
    //   4861: iconst_3
    //   4862: aaload
    //   4863: astore 43
    //   4865: bipush 252
    //   4867: aload_2
    //   4868: arraylength
    //   4869: iadd
    //   4870: istore 44
    //   4872: iload 44
    //   4874: anewarray 325	java/lang/Object
    //   4877: astore 45
    //   4879: iinc 44 255
    //   4882: iload 44
    //   4884: ifge +17 -> 4901
    //   4887: aload 40
    //   4889: aload 41
    //   4891: aload 42
    //   4893: aload 43
    //   4895: aload 45
    //   4897: invokestatic 3063	gnu/kawa/slib/srfi13:stringKmpPartialSearch$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   4900: areturn
    //   4901: aload 45
    //   4903: iload 44
    //   4905: aload_2
    //   4906: iload 44
    //   4908: iconst_4
    //   4909: iadd
    //   4910: aaload
    //   4911: aastore
    //   4912: goto -33 -> 4879
    //   4915: aload_2
    //   4916: iconst_0
    //   4917: aaload
    //   4918: astore 37
    //   4920: iconst_m1
    //   4921: aload_2
    //   4922: arraylength
    //   4923: iadd
    //   4924: istore 38
    //   4926: iload 38
    //   4928: anewarray 325	java/lang/Object
    //   4931: astore 39
    //   4933: iinc 38 255
    //   4936: iload 38
    //   4938: ifge +11 -> 4949
    //   4941: aload 37
    //   4943: aload 39
    //   4945: invokestatic 3065	gnu/kawa/slib/srfi13:stringReverse$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   4948: areturn
    //   4949: aload 39
    //   4951: iload 38
    //   4953: aload_2
    //   4954: iload 38
    //   4956: iconst_1
    //   4957: iadd
    //   4958: aaload
    //   4959: aastore
    //   4960: goto -27 -> 4933
    //   4963: aload_2
    //   4964: iconst_0
    //   4965: aaload
    //   4966: astore 34
    //   4968: iconst_m1
    //   4969: aload_2
    //   4970: arraylength
    //   4971: iadd
    //   4972: istore 35
    //   4974: iload 35
    //   4976: anewarray 325	java/lang/Object
    //   4979: astore 36
    //   4981: iinc 35 255
    //   4984: iload 35
    //   4986: ifge +11 -> 4997
    //   4989: aload 34
    //   4991: aload 36
    //   4993: invokestatic 3067	gnu/kawa/slib/srfi13:stringReverse$Ex$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   4996: areturn
    //   4997: aload 36
    //   4999: iload 35
    //   5001: aload_2
    //   5002: iload 35
    //   5004: iconst_1
    //   5005: iadd
    //   5006: aaload
    //   5007: aastore
    //   5008: goto -27 -> 4981
    //   5011: aload_2
    //   5012: iconst_0
    //   5013: aaload
    //   5014: astore 31
    //   5016: iconst_m1
    //   5017: aload_2
    //   5018: arraylength
    //   5019: iadd
    //   5020: istore 32
    //   5022: iload 32
    //   5024: anewarray 325	java/lang/Object
    //   5027: astore 33
    //   5029: iinc 32 255
    //   5032: iload 32
    //   5034: ifge +11 -> 5045
    //   5037: aload 31
    //   5039: aload 33
    //   5041: invokestatic 3069	gnu/kawa/slib/srfi13:string$To$List$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   5044: areturn
    //   5045: aload 33
    //   5047: iload 32
    //   5049: aload_2
    //   5050: iload 32
    //   5052: iconst_1
    //   5053: iadd
    //   5054: aaload
    //   5055: aastore
    //   5056: goto -27 -> 5029
    //   5059: aload_2
    //   5060: invokestatic 3071	gnu/kawa/slib/srfi13:stringAppend$SlShared$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   5063: areturn
    //   5064: aload_2
    //   5065: iconst_0
    //   5066: aaload
    //   5067: astore 28
    //   5069: iconst_m1
    //   5070: aload_2
    //   5071: arraylength
    //   5072: iadd
    //   5073: istore 29
    //   5075: iload 29
    //   5077: anewarray 325	java/lang/Object
    //   5080: astore 30
    //   5082: iinc 29 255
    //   5085: iload 29
    //   5087: ifge +11 -> 5098
    //   5090: aload 28
    //   5092: aload 30
    //   5094: invokestatic 3073	gnu/kawa/slib/srfi13:stringConcatenateReverse$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   5097: areturn
    //   5098: aload 30
    //   5100: iload 29
    //   5102: aload_2
    //   5103: iload 29
    //   5105: iconst_1
    //   5106: iadd
    //   5107: aaload
    //   5108: aastore
    //   5109: goto -27 -> 5082
    //   5112: aload_2
    //   5113: iconst_0
    //   5114: aaload
    //   5115: astore 25
    //   5117: iconst_m1
    //   5118: aload_2
    //   5119: arraylength
    //   5120: iadd
    //   5121: istore 26
    //   5123: iload 26
    //   5125: anewarray 325	java/lang/Object
    //   5128: astore 27
    //   5130: iinc 26 255
    //   5133: iload 26
    //   5135: ifge +11 -> 5146
    //   5138: aload 25
    //   5140: aload 27
    //   5142: invokestatic 3075	gnu/kawa/slib/srfi13:stringConcatenateReverse$SlShared$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   5145: areturn
    //   5146: aload 27
    //   5148: iload 26
    //   5150: aload_2
    //   5151: iload 26
    //   5153: iconst_1
    //   5154: iadd
    //   5155: aaload
    //   5156: aastore
    //   5157: goto -27 -> 5130
    //   5160: aload_2
    //   5161: iconst_0
    //   5162: aaload
    //   5163: astore 19
    //   5165: aload_2
    //   5166: iconst_1
    //   5167: aaload
    //   5168: astore 20
    //   5170: aload_2
    //   5171: iconst_2
    //   5172: aaload
    //   5173: astore 21
    //   5175: aload_2
    //   5176: iconst_3
    //   5177: aaload
    //   5178: astore 22
    //   5180: bipush 252
    //   5182: aload_2
    //   5183: arraylength
    //   5184: iadd
    //   5185: istore 23
    //   5187: iload 23
    //   5189: anewarray 325	java/lang/Object
    //   5192: astore 24
    //   5194: iinc 23 255
    //   5197: iload 23
    //   5199: ifge +17 -> 5216
    //   5202: aload 19
    //   5204: aload 20
    //   5206: aload 21
    //   5208: aload 22
    //   5210: aload 24
    //   5212: invokestatic 3077	gnu/kawa/slib/srfi13:stringReplace$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   5215: areturn
    //   5216: aload 24
    //   5218: iload 23
    //   5220: aload_2
    //   5221: iload 23
    //   5223: iconst_4
    //   5224: iadd
    //   5225: aaload
    //   5226: aastore
    //   5227: goto -33 -> 5194
    //   5230: aload_2
    //   5231: iconst_0
    //   5232: aaload
    //   5233: astore 16
    //   5235: iconst_m1
    //   5236: aload_2
    //   5237: arraylength
    //   5238: iadd
    //   5239: istore 17
    //   5241: iload 17
    //   5243: anewarray 325	java/lang/Object
    //   5246: astore 18
    //   5248: iinc 17 255
    //   5251: iload 17
    //   5253: ifge +11 -> 5264
    //   5256: aload 16
    //   5258: aload 18
    //   5260: invokestatic 3079	gnu/kawa/slib/srfi13:stringTokenize$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   5263: areturn
    //   5264: aload 18
    //   5266: iload 17
    //   5268: aload_2
    //   5269: iload 17
    //   5271: iconst_1
    //   5272: iadd
    //   5273: aaload
    //   5274: aastore
    //   5275: goto -27 -> 5248
    //   5278: aload_2
    //   5279: iconst_0
    //   5280: aaload
    //   5281: astore 12
    //   5283: aload_2
    //   5284: iconst_1
    //   5285: aaload
    //   5286: astore 13
    //   5288: bipush 254
    //   5290: aload_2
    //   5291: arraylength
    //   5292: iadd
    //   5293: istore 14
    //   5295: iload 14
    //   5297: anewarray 325	java/lang/Object
    //   5300: astore 15
    //   5302: iinc 14 255
    //   5305: iload 14
    //   5307: ifge +13 -> 5320
    //   5310: aload 12
    //   5312: aload 13
    //   5314: aload 15
    //   5316: invokestatic 3081	gnu/kawa/slib/srfi13:xsubstring$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   5319: areturn
    //   5320: aload 15
    //   5322: iload 14
    //   5324: aload_2
    //   5325: iload 14
    //   5327: iconst_2
    //   5328: iadd
    //   5329: aaload
    //   5330: aastore
    //   5331: goto -29 -> 5302
    //   5334: aload_2
    //   5335: iconst_0
    //   5336: aaload
    //   5337: astore 6
    //   5339: aload_2
    //   5340: iconst_1
    //   5341: aaload
    //   5342: astore 7
    //   5344: aload_2
    //   5345: iconst_2
    //   5346: aaload
    //   5347: astore 8
    //   5349: aload_2
    //   5350: iconst_3
    //   5351: aaload
    //   5352: astore 9
    //   5354: bipush 252
    //   5356: aload_2
    //   5357: arraylength
    //   5358: iadd
    //   5359: istore 10
    //   5361: iload 10
    //   5363: anewarray 325	java/lang/Object
    //   5366: astore 11
    //   5368: iinc 10 255
    //   5371: iload 10
    //   5373: ifge +17 -> 5390
    //   5376: aload 6
    //   5378: aload 7
    //   5380: aload 8
    //   5382: aload 9
    //   5384: aload 11
    //   5386: invokestatic 3083	gnu/kawa/slib/srfi13:stringXcopy$Ex$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   5389: areturn
    //   5390: aload 11
    //   5392: iload 10
    //   5394: aload_2
    //   5395: iload 10
    //   5397: iconst_4
    //   5398: iadd
    //   5399: aaload
    //   5400: aastore
    //   5401: goto -33 -> 5368
    //   5404: aload_2
    //   5405: iconst_0
    //   5406: aaload
    //   5407: aload_2
    //   5408: iconst_1
    //   5409: aaload
    //   5410: aload_2
    //   5411: iconst_2
    //   5412: aaload
    //   5413: aload_2
    //   5414: iconst_3
    //   5415: aaload
    //   5416: aload_2
    //   5417: iconst_4
    //   5418: aaload
    //   5419: aload_2
    //   5420: iconst_5
    //   5421: aaload
    //   5422: aload_2
    //   5423: bipush 6
    //   5425: aaload
    //   5426: invokestatic 3085	gnu/kawa/slib/srfi13:$PcMultispanRepcopy$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5429: areturn
    //   5430: aload_2
    //   5431: iconst_0
    //   5432: aaload
    //   5433: astore_3
    //   5434: iconst_m1
    //   5435: aload_2
    //   5436: arraylength
    //   5437: iadd
    //   5438: istore 4
    //   5440: iload 4
    //   5442: anewarray 325	java/lang/Object
    //   5445: astore 5
    //   5447: iinc 4 255
    //   5450: iload 4
    //   5452: ifge +10 -> 5462
    //   5455: aload_3
    //   5456: aload 5
    //   5458: invokestatic 3087	gnu/kawa/slib/srfi13:stringJoin$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   5461: areturn
    //   5462: aload 5
    //   5464: iload 4
    //   5466: aload_2
    //   5467: iload 4
    //   5469: iconst_1
    //   5470: iadd
    //   5471: aaload
    //   5472: aastore
    //   5473: goto -26 -> 5447
    //   5476: wide
    //   5480: new 412	gnu/mapping/WrongType
    //   5483: dup
    //   5484: wide
    //   5488: ldc_w 529
    //   5491: iconst_2
    //   5492: wide
    //   5496: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5499: athrow
    //   5500: wide
    //   5504: new 412	gnu/mapping/WrongType
    //   5507: dup
    //   5508: wide
    //   5512: ldc_w 529
    //   5515: iconst_3
    //   5516: wide
    //   5520: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5523: athrow
    //   5524: wide
    //   5528: new 412	gnu/mapping/WrongType
    //   5531: dup
    //   5532: wide
    //   5536: ldc_w 529
    //   5539: iconst_5
    //   5540: wide
    //   5544: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5547: athrow
    //   5548: wide
    //   5552: new 412	gnu/mapping/WrongType
    //   5555: dup
    //   5556: wide
    //   5560: ldc_w 529
    //   5563: bipush 6
    //   5565: wide
    //   5569: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5572: athrow
    //   5573: wide
    //   5577: new 412	gnu/mapping/WrongType
    //   5580: dup
    //   5581: wide
    //   5585: ldc_w 600
    //   5588: iconst_2
    //   5589: wide
    //   5593: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5596: athrow
    //   5597: wide
    //   5601: new 412	gnu/mapping/WrongType
    //   5604: dup
    //   5605: wide
    //   5609: ldc_w 600
    //   5612: iconst_3
    //   5613: wide
    //   5617: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5620: athrow
    //   5621: wide
    //   5625: new 412	gnu/mapping/WrongType
    //   5628: dup
    //   5629: wide
    //   5633: ldc_w 600
    //   5636: iconst_5
    //   5637: wide
    //   5641: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5644: athrow
    //   5645: wide
    //   5649: new 412	gnu/mapping/WrongType
    //   5652: dup
    //   5653: wide
    //   5657: ldc_w 600
    //   5660: bipush 6
    //   5662: wide
    //   5666: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5669: athrow
    //   5670: astore 75
    //   5672: new 412	gnu/mapping/WrongType
    //   5675: dup
    //   5676: aload 75
    //   5678: ldc_w 745
    //   5681: iconst_2
    //   5682: aload 74
    //   5684: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5687: athrow
    //   5688: astore 78
    //   5690: new 412	gnu/mapping/WrongType
    //   5693: dup
    //   5694: aload 78
    //   5696: ldc_w 745
    //   5699: iconst_3
    //   5700: aload 77
    //   5702: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5705: athrow
    //   5706: astore 82
    //   5708: new 412	gnu/mapping/WrongType
    //   5711: dup
    //   5712: aload 82
    //   5714: ldc_w 745
    //   5717: iconst_4
    //   5718: aload 81
    //   5720: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5723: athrow
    //   5724: astore 86
    //   5726: new 412	gnu/mapping/WrongType
    //   5729: dup
    //   5730: aload 86
    //   5732: ldc_w 745
    //   5735: iconst_5
    //   5736: aload 85
    //   5738: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5741: athrow
    //   5742: astore 58
    //   5744: new 412	gnu/mapping/WrongType
    //   5747: dup
    //   5748: aload 58
    //   5750: ldc_w 420
    //   5753: iconst_1
    //   5754: aload 57
    //   5756: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5759: athrow
    //   5760: astore 61
    //   5762: new 412	gnu/mapping/WrongType
    //   5765: dup
    //   5766: aload 61
    //   5768: ldc_w 420
    //   5771: iconst_2
    //   5772: aload 60
    //   5774: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5777: athrow
    //   5778: astore 64
    //   5780: new 412	gnu/mapping/WrongType
    //   5783: dup
    //   5784: aload 64
    //   5786: ldc_w 420
    //   5789: iconst_3
    //   5790: aload 63
    //   5792: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5795: athrow
    //   5796: astore 67
    //   5798: new 412	gnu/mapping/WrongType
    //   5801: dup
    //   5802: aload 67
    //   5804: ldc_w 420
    //   5807: iconst_4
    //   5808: aload 66
    //   5810: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5813: athrow
    //   5814: astore 70
    //   5816: new 412	gnu/mapping/WrongType
    //   5819: dup
    //   5820: aload 70
    //   5822: ldc_w 420
    //   5825: iconst_5
    //   5826: aload 69
    //   5828: invokespecial 418	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   5831: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5832	0	this	srfi13
    //   0	5832	1	paramModuleMethod	ModuleMethod
    //   0	5832	2	paramArrayOfObject	Object[]
    //   546	1	332	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   1651	1665	5476	java/lang/ClassCastException
    //   1672	1686	5500	java/lang/ClassCastException
    //   1700	1714	5524	java/lang/ClassCastException
    //   1721	1735	5548	java/lang/ClassCastException
    //   1778	1792	5573	java/lang/ClassCastException
    //   1799	1813	5597	java/lang/ClassCastException
    //   1827	1841	5621	java/lang/ClassCastException
    //   1848	1862	5645	java/lang/ClassCastException
    //   4445	4455	5670	java/lang/ClassCastException
    //   4460	4467	5688	java/lang/ClassCastException
    //   4493	4503	5706	java/lang/ClassCastException
    //   4530	4540	5724	java/lang/ClassCastException
    //   4559	4566	5742	java/lang/ClassCastException
    //   4571	4581	5760	java/lang/ClassCastException
    //   4586	4593	5778	java/lang/ClassCastException
    //   4598	4608	5796	java/lang/ClassCastException
    //   4613	4623	5814	java/lang/ClassCastException
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 325: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 324: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 322: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 316: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 315: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 312: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 309: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 289: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 287: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 271: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 267: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 265: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 263: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 262: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 260: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 259: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 257: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 255: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 254: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 252: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 250: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 248: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 247: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 245: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 244: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 242: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 240: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 239: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 217: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 211: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 209: 
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
    case 283: 
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
    case 282: 
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
    case 281: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 280: 
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
    default: 
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 299: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      if ((paramObject3 instanceof CharSequence))
      {
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786429;
    case 277: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 201: 
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786431;
    case 197: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 196: 
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
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    case 319: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    case 299: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      if ((paramObject3 instanceof CharSequence))
      {
        paramCallContext.value3 = paramObject3;
        paramCallContext.value4 = paramObject4;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 4;
        return 0;
      }
      return -786429;
    case 206: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    case 204: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    case 198: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    }
    paramCallContext.value1 = paramObject1;
    if ((paramObject2 instanceof CharSequence))
    {
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    }
    return -786430;
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 201: 
    case 204: 
    case 206: 
    case 209: 
    case 211: 
    case 217: 
    case 218: 
    case 239: 
    case 240: 
    case 242: 
    case 244: 
    case 245: 
    case 247: 
    case 248: 
    case 250: 
    case 252: 
    case 254: 
    case 255: 
    case 257: 
    case 259: 
    case 260: 
    case 262: 
    case 263: 
    case 265: 
    case 267: 
    case 271: 
    case 277: 
    case 280: 
    case 281: 
    case 282: 
    case 283: 
    case 287: 
    case 289: 
    case 300: 
    case 301: 
    case 309: 
    case 312: 
    case 315: 
    case 316: 
    case 319: 
    case 322: 
    case 324: 
    case 325: 
    default: 
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 328: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 327: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 326: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 323: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 321: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 320: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 318: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 317: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 314: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 313: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 311: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 310: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 308: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 307: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 306: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 305: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 304: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 303: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 302: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 299: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 298: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 297: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 296: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 295: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 294: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 293: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 292: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 291: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 290: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 288: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 286: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 285: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 284: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 279: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 278: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 276: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 275: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 274: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 273: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 272: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 270: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 269: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 268: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 266: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 264: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 261: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 258: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 256: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 253: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 251: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 249: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 246: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 243: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 241: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 238: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 237: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 236: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 235: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 234: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 233: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 232: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 231: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 230: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 229: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 228: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 227: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 226: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 225: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 224: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 223: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 222: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 221: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 220: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 219: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 216: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 215: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 214: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 213: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 212: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 210: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 208: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 207: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 205: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 203: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 202: 
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
  
  public final void run(CallContext paramCallContext) {}
  
  public class frame
    extends ModuleBody
  {
    Object args;
    final ModuleMethod lambda$Fn1 = new ModuleMethod(this, 1, null, 0);
    final ModuleMethod lambda$Fn2;
    Object proc;
    Object s;
    int slen;
    Object start;
    
    public frame()
    {
      this$1 = new ModuleMethod(this, 2, null, 8194);
      this$1.setProperty("source-location", "srfi13.scm:150");
      this.lambda$Fn2 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 1) {
        return lambda1();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 2) {
        return lambda2(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda1()
    {
      if (lists.isPair(this.args))
      {
        Object localObject1 = lists.car.apply1(this.args);
        Object localObject2 = lists.cdr.apply1(this.args);
        boolean bool1 = numbers.isInteger(localObject1);
        boolean bool2;
        if (bool1)
        {
          bool2 = numbers.isExact(localObject1);
          if (bool2) {
            if (Scheme.numLEq.apply2(localObject1, Integer.valueOf(this.slen)) == Boolean.FALSE) {
              break label95;
            }
          }
        }
        for (;;)
        {
          return misc.values(new Object[] { localObject1, localObject2 });
          if (!bool2) {
            label95:
            do
            {
              Object[] arrayOfObject2 = new Object[3];
              arrayOfObject2[0] = this.proc;
              arrayOfObject2[1] = localObject1;
              arrayOfObject2[2] = this.s;
              return misc.error$V("Illegal substring END spec", arrayOfObject2);
            } while (!bool1);
          }
        }
      }
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(this.slen);
      arrayOfObject1[1] = this.args;
      return misc.values(arrayOfObject1);
    }
    
    Object lambda2(Object paramObject1, Object paramObject2)
    {
      if (Scheme.numLEq.apply2(this.start, paramObject1) != Boolean.FALSE)
      {
        Object[] arrayOfObject2 = new Object[3];
        arrayOfObject2[0] = paramObject2;
        arrayOfObject2[1] = this.start;
        arrayOfObject2[2] = paramObject1;
        return misc.values(arrayOfObject2);
      }
      Object[] arrayOfObject1 = new Object[4];
      arrayOfObject1[0] = this.proc;
      arrayOfObject1[1] = this.start;
      arrayOfObject1[2] = paramObject1;
      arrayOfObject1[3] = this.s;
      return misc.error$V("Illegal substring START/END spec", arrayOfObject1);
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
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 2)
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
  
  public class frame0
    extends ModuleBody
  {
    Object args;
    final ModuleMethod lambda$Fn3 = new ModuleMethod(this, 3, null, 0);
    final ModuleMethod lambda$Fn4;
    Object proc;
    Object s;
    
    public frame0()
    {
      this$1 = new ModuleMethod(this, 4, null, 12291);
      this$1.setProperty("source-location", "srfi13.scm:174");
      this.lambda$Fn4 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 3) {
        return lambda3();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 4) {
        return lambda4(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda3()
    {
      return srfi13.stringParseStart$PlEnd(this.proc, this.s, this.args);
    }
    
    Object lambda4(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (lists.isPair(paramObject1))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.proc;
        arrayOfObject[1] = paramObject1;
        return misc.error$V("Extra arguments to procedure", arrayOfObject);
      }
      return misc.values(new Object[] { paramObject2, paramObject3 });
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 3)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 4)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame1
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn6;
    int slen;
    Object start;
    
    public frame1()
    {
      this$1 = new ModuleMethod(this, 5, null, 4097);
      this$1.setProperty("source-location", "srfi13.scm:227");
      this.lambda$Fn6 = this$1;
    }
    
    static boolean lambda5(Object paramObject)
    {
      boolean bool = numbers.isInteger(paramObject);
      if (bool)
      {
        bool = numbers.isExact(paramObject);
        if (bool) {
          bool = ((Boolean)Scheme.numLEq.apply2(srfi13.Lit0, paramObject)).booleanValue();
        }
      }
      return bool;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 5)
      {
        if (lambda6(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda6(Object paramObject)
    {
      boolean bool1 = numbers.isInteger(paramObject);
      Object localObject;
      if (bool1)
      {
        bool1 = numbers.isExact(paramObject);
        if (bool1) {
          localObject = Scheme.numLEq.apply2(this.start, paramObject);
        }
      }
      try
      {
        boolean bool2 = ((Boolean)localObject).booleanValue();
        bool1 = bool2;
        if (bool1) {
          bool1 = ((Boolean)Scheme.numLEq.apply2(paramObject, Integer.valueOf(this.slen))).booleanValue();
        }
        return bool1;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "x", -2, localObject);
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 5)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame10
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn25 = new ModuleMethod(this, 22, null, 0);
    final ModuleMethod lambda$Fn26 = new ModuleMethod(this, 23, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 22) {
        return lambda25();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 23) {
        return lambda26(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda25()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnany, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda26(Object paramObject1, Object paramObject2)
    {
      if (characters.isChar(this.criterion))
      {
        localObject12 = paramObject1;
        localObject13 = Scheme.numLss.apply2(localObject12, paramObject2);
      }
      for (;;)
      {
        Object localObject7;
        Object localObject3;
        for (;;)
        {
          Object localObject14;
          Object localObject15;
          try
          {
            bool3 = ((Boolean)localObject13).booleanValue();
            if (bool3) {
              localObject14 = this.criterion;
            }
          }
          catch (ClassCastException localClassCastException7)
          {
            boolean bool3;
            Char localChar;
            CharSequence localCharSequence3;
            int m;
            boolean bool4;
            Boolean localBoolean;
            Object localObject6;
            ApplyToArgs localApplyToArgs1;
            Location localLocation1;
            Object localObject1;
            boolean bool2;
            ApplyToArgs localApplyToArgs2;
            Location localLocation2;
            Object localObject9;
            Object localObject10;
            CharSequence localCharSequence2;
            int k;
            boolean bool1;
            CharSequence localCharSequence1;
            int i;
            int j;
            Object localObject5;
            Object[] arrayOfObject;
            throw new WrongType(localClassCastException7, "x", -2, localObject13);
          }
          try
          {
            localChar = (Char)localObject14;
            localObject15 = this.s;
          }
          catch (ClassCastException localClassCastException8)
          {
            throw new WrongType(localClassCastException8, "char=?", 1, localObject14);
          }
          try
          {
            localCharSequence3 = (CharSequence)localObject15;
          }
          catch (ClassCastException localClassCastException9)
          {
            throw new WrongType(localClassCastException9, "string-ref", 1, localObject15);
          }
          try
          {
            m = ((Number)localObject12).intValue();
            bool4 = characters.isChar$Eq(localChar, Char.make(strings.stringRef(localCharSequence3, m)));
            if (bool4)
            {
              if (bool4)
              {
                localBoolean = Boolean.TRUE;
                localObject6 = localBoolean;
                return localObject6;
              }
              localBoolean = Boolean.FALSE;
              continue;
            }
            localObject12 = AddOp.$Pl.apply2(localObject12, srfi13.Lit1);
          }
          catch (ClassCastException localClassCastException10)
          {
            throw new WrongType(localClassCastException10, "string-ref", 2, localObject12);
          }
        }
        if (bool3)
        {
          localBoolean = Boolean.TRUE;
        }
        else
        {
          localBoolean = Boolean.FALSE;
          continue;
          localApplyToArgs1 = Scheme.applyToArgs;
          localLocation1 = srfi13.loc$char$Mnset$Qu;
        }
        Object localObject8;
        Object localObject11;
        Object localObject4;
        try
        {
          localObject1 = localLocation1.get();
          if (localApplyToArgs1.apply2(localObject1, this.criterion) != Boolean.FALSE)
          {
            localObject7 = paramObject1;
            localObject8 = Scheme.numLss.apply2(localObject7, paramObject2);
          }
        }
        catch (UnboundLocationException localUnboundLocationException1)
        {
          localUnboundLocationException1.setLine("srfi13.scm", 515, 5);
          throw localUnboundLocationException1;
        }
        try
        {
          bool2 = ((Boolean)localObject8).booleanValue();
          if (bool2)
          {
            localApplyToArgs2 = Scheme.applyToArgs;
            localLocation2 = srfi13.loc$char$Mnset$Mncontains$Qu;
          }
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "x", -2, localObject8);
        }
        try
        {
          localObject9 = localLocation2.get();
          localObject10 = this.criterion;
          localObject11 = this.s;
        }
        catch (UnboundLocationException localUnboundLocationException2)
        {
          localUnboundLocationException2.setLine("srfi13.scm", 518, 9);
          throw localUnboundLocationException2;
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject11;
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "string-ref", 1, localObject11);
        }
        try
        {
          k = ((Number)localObject7).intValue();
          localObject6 = localApplyToArgs2.apply3(localObject9, localObject10, Char.make(strings.stringRef(localCharSequence2, k)));
          if (localObject6 != Boolean.FALSE) {
            continue;
          }
          localObject7 = AddOp.$Pl.apply2(localObject7, srfi13.Lit1);
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "string-ref", 2, localObject7);
        }
        if (bool2) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        if (!misc.isProcedure(this.criterion)) {
          continue;
        }
        Object localObject2 = Scheme.numLss.apply2(paramObject1, paramObject2);
        try
        {
          bool1 = ((Boolean)localObject2).booleanValue();
          if (bool1)
          {
            localObject3 = paramObject1;
            localObject4 = this.s;
          }
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "x", -2, localObject2);
        }
        try
        {
          localCharSequence1 = (CharSequence)localObject4;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-ref", 1, localObject4);
        }
        try
        {
          i = ((Number)localObject3).intValue();
          j = strings.stringRef(localCharSequence1, i);
          localObject5 = AddOp.$Pl.apply2(localObject3, srfi13.Lit1);
          if (Scheme.numEqu.apply2(localObject5, paramObject2) != Boolean.FALSE) {
            return Scheme.applyToArgs.apply2(this.criterion, Char.make(j));
          }
          localObject6 = Scheme.applyToArgs.apply2(this.criterion, Char.make(j));
          if (localObject6 == Boolean.FALSE) {
            localObject3 = localObject5;
          }
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 2, localObject3);
        }
      }
      if (bool1) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
      arrayOfObject = new Object[2];
      arrayOfObject[0] = srfi13.string$Mnany;
      arrayOfObject[1] = this.criterion;
      return misc.error$V("Second param is neither char-set, char, or predicate procedure.", arrayOfObject);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 22)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 23)
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
  
  public class frame11
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn28 = new ModuleMethod(this, 26, null, 0);
    final ModuleMethod lambda$Fn29 = new ModuleMethod(this, 27, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 26) {
        return lambda28();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 27) {
        return lambda29(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda28()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnprefix$Mnlength, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda29(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame12 localframe12 = new srfi13.frame12();
      localframe12.staticLink = this;
      localframe12.rest = paramObject1;
      localframe12.start1 = paramObject2;
      localframe12.end1 = paramObject3;
      return call_with_values.callWithValues(localframe12.lambda$Fn30, localframe12.lambda$Fn31);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 26)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 27)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame12
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn30 = new ModuleMethod(this, 24, null, 0);
    final ModuleMethod lambda$Fn31 = new ModuleMethod(this, 25, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame11 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 24) {
        return lambda30();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 25) {
        return lambda31(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda30()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnprefix$Mnlength, this.staticLink.s2, this.rest);
    }
    
    Object lambda31(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringPrefixLength(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 24)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 25)
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
  
  public class frame13
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn32 = new ModuleMethod(this, 30, null, 0);
    final ModuleMethod lambda$Fn33 = new ModuleMethod(this, 31, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 30) {
        return lambda32();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 31) {
        return lambda33(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda32()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnsuffix$Mnlength, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda33(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame14 localframe14 = new srfi13.frame14();
      localframe14.staticLink = this;
      localframe14.rest = paramObject1;
      localframe14.start1 = paramObject2;
      localframe14.end1 = paramObject3;
      return call_with_values.callWithValues(localframe14.lambda$Fn34, localframe14.lambda$Fn35);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 30)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 31)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame14
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn34 = new ModuleMethod(this, 28, null, 0);
    final ModuleMethod lambda$Fn35 = new ModuleMethod(this, 29, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame13 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 28) {
        return lambda34();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 29) {
        return lambda35(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda34()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnsuffix$Mnlength, this.staticLink.s2, this.rest);
    }
    
    Object lambda35(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringSuffixLength(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 28)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 29)
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
  
  public class frame15
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn36 = new ModuleMethod(this, 34, null, 0);
    final ModuleMethod lambda$Fn37 = new ModuleMethod(this, 35, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 34) {
        return lambda36();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 35) {
        return lambda37(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda36()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnprefix$Mnlength$Mnci, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda37(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame16 localframe16 = new srfi13.frame16();
      localframe16.staticLink = this;
      localframe16.rest = paramObject1;
      localframe16.start1 = paramObject2;
      localframe16.end1 = paramObject3;
      return call_with_values.callWithValues(localframe16.lambda$Fn38, localframe16.lambda$Fn39);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 34)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 35)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame16
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn38 = new ModuleMethod(this, 32, null, 0);
    final ModuleMethod lambda$Fn39 = new ModuleMethod(this, 33, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame15 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 32) {
        return lambda38();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 33) {
        return Integer.valueOf(lambda39(paramObject1, paramObject2));
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda38()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnprefix$Mnlength$Mnci, this.staticLink.s2, this.rest);
    }
    
    /* Error */
    int lambda39(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 59	gnu/kawa/slib/srfi13$frame16:staticLink	Lgnu/kawa/slib/srfi13$frame15;
      //   4: getfield 75	gnu/kawa/slib/srfi13$frame15:s1	Ljava/lang/Object;
      //   7: astore_3
      //   8: aload_0
      //   9: getfield 77	gnu/kawa/slib/srfi13$frame16:start1	Ljava/lang/Object;
      //   12: astore 4
      //   14: aload 4
      //   16: checkcast 79	java/lang/Number
      //   19: invokevirtual 83	java/lang/Number:intValue	()I
      //   22: istore 6
      //   24: aload_0
      //   25: getfield 85	gnu/kawa/slib/srfi13$frame16:end1	Ljava/lang/Object;
      //   28: astore 7
      //   30: aload 7
      //   32: checkcast 79	java/lang/Number
      //   35: invokevirtual 83	java/lang/Number:intValue	()I
      //   38: istore 9
      //   40: aload_0
      //   41: getfield 59	gnu/kawa/slib/srfi13$frame16:staticLink	Lgnu/kawa/slib/srfi13$frame15;
      //   44: getfield 64	gnu/kawa/slib/srfi13$frame15:s2	Ljava/lang/Object;
      //   47: astore 10
      //   49: aload_1
      //   50: checkcast 79	java/lang/Number
      //   53: invokevirtual 83	java/lang/Number:intValue	()I
      //   56: istore 12
      //   58: aload_2
      //   59: checkcast 79	java/lang/Number
      //   62: invokevirtual 83	java/lang/Number:intValue	()I
      //   65: istore 14
      //   67: aload_3
      //   68: iload 6
      //   70: iload 9
      //   72: aload 10
      //   74: iload 12
      //   76: iload 14
      //   78: invokestatic 89	gnu/kawa/slib/srfi13:$PcStringPrefixLengthCi	(Ljava/lang/Object;IILjava/lang/Object;II)I
      //   81: ireturn
      //   82: astore 5
      //   84: new 91	gnu/mapping/WrongType
      //   87: dup
      //   88: aload 5
      //   90: ldc 93
      //   92: iconst_1
      //   93: aload 4
      //   95: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   98: athrow
      //   99: astore 8
      //   101: new 91	gnu/mapping/WrongType
      //   104: dup
      //   105: aload 8
      //   107: ldc 93
      //   109: iconst_2
      //   110: aload 7
      //   112: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   115: athrow
      //   116: astore 11
      //   118: new 91	gnu/mapping/WrongType
      //   121: dup
      //   122: aload 11
      //   124: ldc 93
      //   126: iconst_4
      //   127: aload_1
      //   128: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   131: athrow
      //   132: astore 13
      //   134: new 91	gnu/mapping/WrongType
      //   137: dup
      //   138: aload 13
      //   140: ldc 93
      //   142: iconst_5
      //   143: aload_2
      //   144: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   147: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	148	0	this	frame16
      //   0	148	1	paramObject1	Object
      //   0	148	2	paramObject2	Object
      //   7	61	3	localObject1	Object
      //   12	82	4	localObject2	Object
      //   82	7	5	localClassCastException1	ClassCastException
      //   22	47	6	i	int
      //   28	83	7	localObject3	Object
      //   99	7	8	localClassCastException2	ClassCastException
      //   38	33	9	j	int
      //   47	26	10	localObject4	Object
      //   116	7	11	localClassCastException3	ClassCastException
      //   56	19	12	k	int
      //   132	7	13	localClassCastException4	ClassCastException
      //   65	12	14	m	int
      // Exception table:
      //   from	to	target	type
      //   14	24	82	java/lang/ClassCastException
      //   30	40	99	java/lang/ClassCastException
      //   49	58	116	java/lang/ClassCastException
      //   58	67	132	java/lang/ClassCastException
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 32)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 33)
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
  
  public class frame17
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn40 = new ModuleMethod(this, 38, null, 0);
    final ModuleMethod lambda$Fn41 = new ModuleMethod(this, 39, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 38) {
        return lambda40();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 39) {
        return lambda41(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda40()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnsuffix$Mnlength$Mnci, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda41(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame18 localframe18 = new srfi13.frame18();
      localframe18.staticLink = this;
      localframe18.rest = paramObject1;
      localframe18.start1 = paramObject2;
      localframe18.end1 = paramObject3;
      return call_with_values.callWithValues(localframe18.lambda$Fn42, localframe18.lambda$Fn43);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 38)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 39)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame18
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn42 = new ModuleMethod(this, 36, null, 0);
    final ModuleMethod lambda$Fn43 = new ModuleMethod(this, 37, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame17 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 36) {
        return lambda42();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 37) {
        return Integer.valueOf(lambda43(paramObject1, paramObject2));
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda42()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnsuffix$Mnlength$Mnci, this.staticLink.s2, this.rest);
    }
    
    /* Error */
    int lambda43(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 59	gnu/kawa/slib/srfi13$frame18:staticLink	Lgnu/kawa/slib/srfi13$frame17;
      //   4: getfield 75	gnu/kawa/slib/srfi13$frame17:s1	Ljava/lang/Object;
      //   7: astore_3
      //   8: aload_0
      //   9: getfield 77	gnu/kawa/slib/srfi13$frame18:start1	Ljava/lang/Object;
      //   12: astore 4
      //   14: aload 4
      //   16: checkcast 79	java/lang/Number
      //   19: invokevirtual 83	java/lang/Number:intValue	()I
      //   22: istore 6
      //   24: aload_0
      //   25: getfield 85	gnu/kawa/slib/srfi13$frame18:end1	Ljava/lang/Object;
      //   28: astore 7
      //   30: aload 7
      //   32: checkcast 79	java/lang/Number
      //   35: invokevirtual 83	java/lang/Number:intValue	()I
      //   38: istore 9
      //   40: aload_0
      //   41: getfield 59	gnu/kawa/slib/srfi13$frame18:staticLink	Lgnu/kawa/slib/srfi13$frame17;
      //   44: getfield 64	gnu/kawa/slib/srfi13$frame17:s2	Ljava/lang/Object;
      //   47: astore 10
      //   49: aload_1
      //   50: checkcast 79	java/lang/Number
      //   53: invokevirtual 83	java/lang/Number:intValue	()I
      //   56: istore 12
      //   58: aload_2
      //   59: checkcast 79	java/lang/Number
      //   62: invokevirtual 83	java/lang/Number:intValue	()I
      //   65: istore 14
      //   67: aload_3
      //   68: iload 6
      //   70: iload 9
      //   72: aload 10
      //   74: iload 12
      //   76: iload 14
      //   78: invokestatic 89	gnu/kawa/slib/srfi13:$PcStringSuffixLengthCi	(Ljava/lang/Object;IILjava/lang/Object;II)I
      //   81: ireturn
      //   82: astore 5
      //   84: new 91	gnu/mapping/WrongType
      //   87: dup
      //   88: aload 5
      //   90: ldc 93
      //   92: iconst_1
      //   93: aload 4
      //   95: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   98: athrow
      //   99: astore 8
      //   101: new 91	gnu/mapping/WrongType
      //   104: dup
      //   105: aload 8
      //   107: ldc 93
      //   109: iconst_2
      //   110: aload 7
      //   112: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   115: athrow
      //   116: astore 11
      //   118: new 91	gnu/mapping/WrongType
      //   121: dup
      //   122: aload 11
      //   124: ldc 93
      //   126: iconst_4
      //   127: aload_1
      //   128: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   131: athrow
      //   132: astore 13
      //   134: new 91	gnu/mapping/WrongType
      //   137: dup
      //   138: aload 13
      //   140: ldc 93
      //   142: iconst_5
      //   143: aload_2
      //   144: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   147: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	148	0	this	frame18
      //   0	148	1	paramObject1	Object
      //   0	148	2	paramObject2	Object
      //   7	61	3	localObject1	Object
      //   12	82	4	localObject2	Object
      //   82	7	5	localClassCastException1	ClassCastException
      //   22	47	6	i	int
      //   28	83	7	localObject3	Object
      //   99	7	8	localClassCastException2	ClassCastException
      //   38	33	9	j	int
      //   47	26	10	localObject4	Object
      //   116	7	11	localClassCastException3	ClassCastException
      //   56	19	12	k	int
      //   132	7	13	localClassCastException4	ClassCastException
      //   65	12	14	m	int
      // Exception table:
      //   from	to	target	type
      //   14	24	82	java/lang/ClassCastException
      //   30	40	99	java/lang/ClassCastException
      //   49	58	116	java/lang/ClassCastException
      //   58	67	132	java/lang/ClassCastException
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 36)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 37)
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
  
  public class frame19
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn44 = new ModuleMethod(this, 42, null, 0);
    final ModuleMethod lambda$Fn45 = new ModuleMethod(this, 43, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 42) {
        return lambda44();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 43) {
        return lambda45(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda44()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnprefix$Qu, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda45(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame20 localframe20 = new srfi13.frame20();
      localframe20.staticLink = this;
      localframe20.rest = paramObject1;
      localframe20.start1 = paramObject2;
      localframe20.end1 = paramObject3;
      return call_with_values.callWithValues(localframe20.lambda$Fn46, localframe20.lambda$Fn47);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 42)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 43)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame2
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn7 = new ModuleMethod(this, 6, null, 0);
    final ModuleMethod lambda$Fn8 = new ModuleMethod(this, 7, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 6) {
        return lambda7();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 7) {
        return lambda8(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda7()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncopy, this.s, this.maybe$Mnstart$Plend);
    }
    
    /* Error */
    CharSequence lambda8(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 51	gnu/kawa/slib/srfi13$frame2:s	Ljava/lang/Object;
      //   4: astore_3
      //   5: aload_3
      //   6: checkcast 61	java/lang/CharSequence
      //   9: astore 5
      //   11: aload_1
      //   12: checkcast 63	java/lang/Number
      //   15: invokevirtual 67	java/lang/Number:intValue	()I
      //   18: istore 7
      //   20: aload_2
      //   21: checkcast 63	java/lang/Number
      //   24: invokevirtual 67	java/lang/Number:intValue	()I
      //   27: istore 9
      //   29: aload 5
      //   31: iload 7
      //   33: iload 9
      //   35: invokestatic 73	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   38: areturn
      //   39: astore 4
      //   41: new 75	gnu/mapping/WrongType
      //   44: dup
      //   45: aload 4
      //   47: ldc 76
      //   49: iconst_1
      //   50: aload_3
      //   51: invokespecial 79	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   54: athrow
      //   55: astore 6
      //   57: new 75	gnu/mapping/WrongType
      //   60: dup
      //   61: aload 6
      //   63: ldc 76
      //   65: iconst_2
      //   66: aload_1
      //   67: invokespecial 79	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   70: athrow
      //   71: astore 8
      //   73: new 75	gnu/mapping/WrongType
      //   76: dup
      //   77: aload 8
      //   79: ldc 76
      //   81: iconst_3
      //   82: aload_2
      //   83: invokespecial 79	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   86: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	87	0	this	frame2
      //   0	87	1	paramObject1	Object
      //   0	87	2	paramObject2	Object
      //   4	47	3	localObject	Object
      //   39	7	4	localClassCastException1	ClassCastException
      //   9	21	5	localCharSequence	CharSequence
      //   55	7	6	localClassCastException2	ClassCastException
      //   18	14	7	i	int
      //   71	7	8	localClassCastException3	ClassCastException
      //   27	7	9	j	int
      // Exception table:
      //   from	to	target	type
      //   5	11	39	java/lang/ClassCastException
      //   11	20	55	java/lang/ClassCastException
      //   20	29	71	java/lang/ClassCastException
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 6)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 7)
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
  
  public class frame20
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn46 = new ModuleMethod(this, 40, null, 0);
    final ModuleMethod lambda$Fn47 = new ModuleMethod(this, 41, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame19 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 40) {
        return lambda46();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 41) {
        return lambda47(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda46()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnprefix$Qu, this.staticLink.s2, this.rest);
    }
    
    Object lambda47(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringPrefix$Qu(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 40)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 41)
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
  
  public class frame21
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn48 = new ModuleMethod(this, 46, null, 0);
    final ModuleMethod lambda$Fn49 = new ModuleMethod(this, 47, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 46) {
        return lambda48();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 47) {
        return lambda49(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda48()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnsuffix$Qu, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda49(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame22 localframe22 = new srfi13.frame22();
      localframe22.staticLink = this;
      localframe22.rest = paramObject1;
      localframe22.start1 = paramObject2;
      localframe22.end1 = paramObject3;
      return call_with_values.callWithValues(localframe22.lambda$Fn50, localframe22.lambda$Fn51);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 46)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 47)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame22
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn50 = new ModuleMethod(this, 44, null, 0);
    final ModuleMethod lambda$Fn51 = new ModuleMethod(this, 45, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame21 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 44) {
        return lambda50();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 45) {
        return lambda51(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda50()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnsuffix$Qu, this.staticLink.s2, this.rest);
    }
    
    Object lambda51(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringSuffix$Qu(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 44)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 45)
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
  
  public class frame23
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn52 = new ModuleMethod(this, 50, null, 0);
    final ModuleMethod lambda$Fn53 = new ModuleMethod(this, 51, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 50) {
        return lambda52();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 51) {
        return lambda53(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda52()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnprefix$Mnci$Qu, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda53(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame24 localframe24 = new srfi13.frame24();
      localframe24.staticLink = this;
      localframe24.rest = paramObject1;
      localframe24.start1 = paramObject2;
      localframe24.end1 = paramObject3;
      return call_with_values.callWithValues(localframe24.lambda$Fn54, localframe24.lambda$Fn55);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 50)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 51)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame24
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn54 = new ModuleMethod(this, 48, null, 0);
    final ModuleMethod lambda$Fn55 = new ModuleMethod(this, 49, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame23 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 48) {
        return lambda54();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 49) {
        return lambda55(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda54()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnprefix$Mnci$Qu, this.staticLink.s2, this.rest);
    }
    
    Object lambda55(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringPrefixCi$Qu(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 48)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 49)
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
  
  public class frame25
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn56 = new ModuleMethod(this, 54, null, 0);
    final ModuleMethod lambda$Fn57 = new ModuleMethod(this, 55, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 54) {
        return lambda56();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 55) {
        return lambda57(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda56()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnsuffix$Mnci$Qu, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda57(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame26 localframe26 = new srfi13.frame26();
      localframe26.staticLink = this;
      localframe26.rest = paramObject1;
      localframe26.start1 = paramObject2;
      localframe26.end1 = paramObject3;
      return call_with_values.callWithValues(localframe26.lambda$Fn58, localframe26.lambda$Fn59);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 54)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 55)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame26
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn58 = new ModuleMethod(this, 52, null, 0);
    final ModuleMethod lambda$Fn59 = new ModuleMethod(this, 53, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame25 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 52) {
        return lambda58();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 53) {
        return lambda59(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda58()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnsuffix$Mnci$Qu, this.staticLink.s2, this.rest);
    }
    
    Object lambda59(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringSuffixCi$Qu(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 52)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 53)
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
  
  public class frame27
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn60 = new ModuleMethod(this, 58, null, 0);
    final ModuleMethod lambda$Fn61 = new ModuleMethod(this, 59, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object proc$Eq;
    Object proc$Gr;
    Object proc$Ls;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 58) {
        return lambda60();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 59) {
        return lambda61(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda60()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mncompare, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda61(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame28 localframe28 = new srfi13.frame28();
      localframe28.staticLink = this;
      localframe28.rest = paramObject1;
      localframe28.start1 = paramObject2;
      localframe28.end1 = paramObject3;
      return call_with_values.callWithValues(localframe28.lambda$Fn62, localframe28.lambda$Fn63);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 58)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 59)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame28
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn62 = new ModuleMethod(this, 56, null, 0);
    final ModuleMethod lambda$Fn63 = new ModuleMethod(this, 57, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame27 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 56) {
        return lambda62();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 57) {
        return lambda63(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda62()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncompare, this.staticLink.s2, this.rest);
    }
    
    Object lambda63(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringCompare(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, this.staticLink.proc$Ls, this.staticLink.proc$Eq, this.staticLink.proc$Gr);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 56)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 57)
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
  
  public class frame29
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn64 = new ModuleMethod(this, 62, null, 0);
    final ModuleMethod lambda$Fn65 = new ModuleMethod(this, 63, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object proc$Eq;
    Object proc$Gr;
    Object proc$Ls;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 62) {
        return lambda64();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 63) {
        return lambda65(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda64()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mncompare$Mnci, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda65(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame30 localframe30 = new srfi13.frame30();
      localframe30.staticLink = this;
      localframe30.rest = paramObject1;
      localframe30.start1 = paramObject2;
      localframe30.end1 = paramObject3;
      return call_with_values.callWithValues(localframe30.lambda$Fn66, localframe30.lambda$Fn67);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 62)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 63)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame3
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn10 = new ModuleMethod(this, 9, null, 8194);
    final ModuleMethod lambda$Fn9 = new ModuleMethod(this, 8, null, 0);
    LList maybe$Mnstart$Plend;
    Object proc;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 8) {
        return lambda9();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 9) {
        return lambda10(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda10(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringMap(this.proc, this.s, paramObject1, paramObject2);
    }
    
    Object lambda9()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnmap, this.s, this.maybe$Mnstart$Plend);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 8)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 9)
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
  
  public class frame30
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn66 = new ModuleMethod(this, 60, null, 0);
    final ModuleMethod lambda$Fn67 = new ModuleMethod(this, 61, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame29 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 60) {
        return lambda66();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 61) {
        return lambda67(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda66()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncompare$Mnci, this.staticLink.s2, this.rest);
    }
    
    Object lambda67(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringCompareCi(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, this.staticLink.proc$Ls, this.staticLink.proc$Eq, this.staticLink.proc$Gr);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 60)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 61)
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
  
  public class frame31
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn68 = new ModuleMethod(this, 66, null, 0);
    final ModuleMethod lambda$Fn69 = new ModuleMethod(this, 67, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 66) {
        return lambda68();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 67) {
        return lambda69(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda68()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Eq, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda69(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame32 localframe32 = new srfi13.frame32();
      localframe32.staticLink = this;
      localframe32.rest = paramObject1;
      localframe32.start1 = paramObject2;
      localframe32.end1 = paramObject3;
      return call_with_values.callWithValues(localframe32.lambda$Fn70, localframe32.lambda$Fn71);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 66)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 67)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame32
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn70 = new ModuleMethod(this, 64, null, 0);
    final ModuleMethod lambda$Fn71 = new ModuleMethod(this, 65, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame31 staticLink;
    
    static Boolean lambda72(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda73(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 64) {
        return lambda70();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 65) {
        return lambda71(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda70()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Eq, this.staticLink.s2, this.rest);
    }
    
    Object lambda71(Object paramObject1, Object paramObject2)
    {
      localObject1 = Scheme.numEqu.apply2(AddOp.$Mn.apply2(this.end1, this.start1), AddOp.$Mn.apply2(paramObject2, paramObject1));
      for (;;)
      {
        Object localObject2;
        try
        {
          bool1 = ((Boolean)localObject1).booleanValue();
          if (bool1) {
            if (this.staticLink.s1 == this.staticLink.s2)
            {
              i = 1;
              if (i != 0) {
                localObject2 = Scheme.numEqu.apply2(this.start1, paramObject1);
              }
            }
          }
        }
        catch (ClassCastException localClassCastException1)
        {
          boolean bool1;
          int i;
          boolean bool2;
          throw new WrongType(localClassCastException1, "x", -2, localObject1);
        }
        try
        {
          bool2 = ((Boolean)localObject2).booleanValue();
          i = bool2;
          if (i != 0)
          {
            if (i != 0)
            {
              return Boolean.TRUE;
              i = 0;
            }
            else
            {
              return Boolean.FALSE;
            }
          }
          else {
            return srfi13.$PcStringCompare(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, srfi13.lambda$Fn72, misc.values, srfi13.lambda$Fn73);
          }
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "x", -2, localObject2);
        }
      }
      if (bool1) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 64)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 65)
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
  
  public class frame33
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn74 = new ModuleMethod(this, 70, null, 0);
    final ModuleMethod lambda$Fn75 = new ModuleMethod(this, 71, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 70) {
        return lambda74();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 71) {
        return lambda75(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda74()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Ls$Gr, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda75(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame34 localframe34 = new srfi13.frame34();
      localframe34.staticLink = this;
      localframe34.rest = paramObject1;
      localframe34.start1 = paramObject2;
      localframe34.end1 = paramObject3;
      return call_with_values.callWithValues(localframe34.lambda$Fn76, localframe34.lambda$Fn77);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 70)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 71)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame34
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn76 = new ModuleMethod(this, 68, null, 0);
    final ModuleMethod lambda$Fn77 = new ModuleMethod(this, 69, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame33 staticLink;
    
    static Boolean lambda78(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 68) {
        return lambda76();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 69) {
        return lambda77(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda76()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Ls$Gr, this.staticLink.s2, this.rest);
    }
    
    Object lambda77(Object paramObject1, Object paramObject2)
    {
      i = 1;
      localObject1 = Scheme.numEqu.apply2(AddOp.$Mn.apply2(this.end1, this.start1), AddOp.$Mn.apply2(paramObject2, paramObject1));
      try
      {
        Boolean localBoolean1 = Boolean.FALSE;
        if (localObject1 != localBoolean1) {}
        for (int j = i;; j = 0)
        {
          int k = 0x1 & j + 1;
          if (k == 0) {
            break label79;
          }
          if (k == 0) {
            break;
          }
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        label79:
        if (this.staticLink.s1 != this.staticLink.s2) {
          break label178;
        }
        m = i;
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          int m;
          Boolean localBoolean2 = Boolean.FALSE;
          if (localObject2 != localBoolean2) {}
          int n;
          for (;;)
          {
            n = 0x1 & i + 1;
            if (n == 0) {
              break label195;
            }
            return srfi13.$PcStringCompare(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, misc.values, srfi13.lambda$Fn78, misc.values);
            m = 0;
            break;
            i = 0;
            continue;
            i = m;
          }
          if (n != 0) {
            return Boolean.TRUE;
          }
          return Boolean.FALSE;
        }
        catch (ClassCastException localClassCastException2)
        {
          Object localObject2;
          throw new WrongType(localClassCastException2, "x", -2, localObject2);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "x", -2, localObject1);
      }
      if (m != 0) {
        localObject2 = Scheme.numEqu.apply2(this.start1, paramObject1);
      }
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 68)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 69)
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
  
  public class frame35
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn79 = new ModuleMethod(this, 74, null, 0);
    final ModuleMethod lambda$Fn80 = new ModuleMethod(this, 75, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 74) {
        return lambda79();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 75) {
        return lambda80(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda79()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Ls, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda80(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame36 localframe36 = new srfi13.frame36();
      localframe36.staticLink = this;
      localframe36.rest = paramObject1;
      localframe36.start1 = paramObject2;
      localframe36.end1 = paramObject3;
      return call_with_values.callWithValues(localframe36.lambda$Fn81, localframe36.lambda$Fn82);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 74)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 75)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame36
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn81 = new ModuleMethod(this, 72, null, 0);
    final ModuleMethod lambda$Fn82 = new ModuleMethod(this, 73, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame35 staticLink;
    
    static Boolean lambda83(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda84(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 72) {
        return lambda81();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 73) {
        return lambda82(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda81()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Ls, this.staticLink.s2, this.rest);
    }
    
    Object lambda82(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numLss.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompare(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, misc.values, srfi13.lambda$Fn83, srfi13.lambda$Fn84);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 72)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 73)
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
  
  public class frame37
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn85 = new ModuleMethod(this, 78, null, 0);
    final ModuleMethod lambda$Fn86 = new ModuleMethod(this, 79, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 78) {
        return lambda85();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 79) {
        return lambda86(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda85()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Gr, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda86(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame38 localframe38 = new srfi13.frame38();
      localframe38.staticLink = this;
      localframe38.rest = paramObject1;
      localframe38.start1 = paramObject2;
      localframe38.end1 = paramObject3;
      return call_with_values.callWithValues(localframe38.lambda$Fn87, localframe38.lambda$Fn88);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 78)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 79)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame38
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn87 = new ModuleMethod(this, 76, null, 0);
    final ModuleMethod lambda$Fn88 = new ModuleMethod(this, 77, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame37 staticLink;
    
    static Boolean lambda89(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda90(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 76) {
        return lambda87();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 77) {
        return lambda88(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda87()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Gr, this.staticLink.s2, this.rest);
    }
    
    Object lambda88(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numGrt.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompare(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, srfi13.lambda$Fn89, srfi13.lambda$Fn90, misc.values);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 76)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 77)
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
  
  public class frame39
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn91 = new ModuleMethod(this, 82, null, 0);
    final ModuleMethod lambda$Fn92 = new ModuleMethod(this, 83, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 82) {
        return lambda91();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 83) {
        return lambda92(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda91()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Ls$Eq, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda92(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame40 localframe40 = new srfi13.frame40();
      localframe40.staticLink = this;
      localframe40.rest = paramObject1;
      localframe40.start1 = paramObject2;
      localframe40.end1 = paramObject3;
      return call_with_values.callWithValues(localframe40.lambda$Fn93, localframe40.lambda$Fn94);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 82)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 83)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame4
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn11 = new ModuleMethod(this, 10, null, 0);
    final ModuleMethod lambda$Fn12 = new ModuleMethod(this, 11, null, 8194);
    LList maybe$Mnstart$Plend;
    Object proc;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 10) {
        return lambda11();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 11) {
        return lambda12(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda11()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnmap$Ex, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda12(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringMap$Ex(this.proc, this.s, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 10)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 11)
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
  
  public class frame40
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn93 = new ModuleMethod(this, 80, null, 0);
    final ModuleMethod lambda$Fn94 = new ModuleMethod(this, 81, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame39 staticLink;
    
    static Boolean lambda95(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 80) {
        return lambda93();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 81) {
        return lambda94(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda93()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Ls$Eq, this.staticLink.s2, this.rest);
    }
    
    Object lambda94(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numLEq.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompare(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, misc.values, misc.values, srfi13.lambda$Fn95);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 80)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 81)
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
  
  public class frame41
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn96 = new ModuleMethod(this, 86, null, 0);
    final ModuleMethod lambda$Fn97 = new ModuleMethod(this, 87, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 86) {
        return lambda96();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 87) {
        return lambda97(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda96()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Gr$Eq, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda97(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame42 localframe42 = new srfi13.frame42();
      localframe42.staticLink = this;
      localframe42.rest = paramObject1;
      localframe42.start1 = paramObject2;
      localframe42.end1 = paramObject3;
      return call_with_values.callWithValues(localframe42.lambda$Fn98, localframe42.lambda$Fn99);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 86)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 87)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame42
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn98 = new ModuleMethod(this, 84, null, 0);
    final ModuleMethod lambda$Fn99 = new ModuleMethod(this, 85, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame41 staticLink;
    
    static Boolean lambda100(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 84) {
        return lambda98();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 85) {
        return lambda99(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda98()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Gr$Eq, this.staticLink.s2, this.rest);
    }
    
    Object lambda99(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numGEq.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompare(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, srfi13.lambda$Fn100, misc.values, misc.values);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 84)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 85)
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
  
  public class frame43
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn101 = new ModuleMethod(this, 90, null, 0);
    final ModuleMethod lambda$Fn102 = new ModuleMethod(this, 91, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 90) {
        return lambda101();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 91) {
        return lambda102(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda101()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnci$Eq, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda102(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame44 localframe44 = new srfi13.frame44();
      localframe44.staticLink = this;
      localframe44.rest = paramObject1;
      localframe44.start1 = paramObject2;
      localframe44.end1 = paramObject3;
      return call_with_values.callWithValues(localframe44.lambda$Fn103, localframe44.lambda$Fn104);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 90)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 91)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame44
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn103 = new ModuleMethod(this, 88, null, 0);
    final ModuleMethod lambda$Fn104 = new ModuleMethod(this, 89, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame43 staticLink;
    
    static Boolean lambda105(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda106(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 88) {
        return lambda103();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 89) {
        return lambda104(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda103()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnci$Eq, this.staticLink.s2, this.rest);
    }
    
    Object lambda104(Object paramObject1, Object paramObject2)
    {
      localObject1 = Scheme.numEqu.apply2(AddOp.$Mn.apply2(this.end1, this.start1), AddOp.$Mn.apply2(paramObject2, paramObject1));
      for (;;)
      {
        Object localObject2;
        try
        {
          bool1 = ((Boolean)localObject1).booleanValue();
          if (bool1) {
            if (this.staticLink.s1 == this.staticLink.s2)
            {
              i = 1;
              if (i != 0) {
                localObject2 = Scheme.numEqu.apply2(this.start1, paramObject1);
              }
            }
          }
        }
        catch (ClassCastException localClassCastException1)
        {
          boolean bool1;
          int i;
          boolean bool2;
          throw new WrongType(localClassCastException1, "x", -2, localObject1);
        }
        try
        {
          bool2 = ((Boolean)localObject2).booleanValue();
          i = bool2;
          if (i != 0)
          {
            if (i != 0)
            {
              return Boolean.TRUE;
              i = 0;
            }
            else
            {
              return Boolean.FALSE;
            }
          }
          else {
            return srfi13.$PcStringCompareCi(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, srfi13.lambda$Fn105, misc.values, srfi13.lambda$Fn106);
          }
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "x", -2, localObject2);
        }
      }
      if (bool1) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 88)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 89)
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
  
  public class frame45
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn107 = new ModuleMethod(this, 94, null, 0);
    final ModuleMethod lambda$Fn108 = new ModuleMethod(this, 95, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 94) {
        return lambda107();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 95) {
        return lambda108(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda107()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnci$Ls$Gr, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda108(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame46 localframe46 = new srfi13.frame46();
      localframe46.staticLink = this;
      localframe46.rest = paramObject1;
      localframe46.start1 = paramObject2;
      localframe46.end1 = paramObject3;
      return call_with_values.callWithValues(localframe46.lambda$Fn109, localframe46.lambda$Fn110);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 94)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 95)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame46
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn109 = new ModuleMethod(this, 92, null, 0);
    final ModuleMethod lambda$Fn110 = new ModuleMethod(this, 93, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame45 staticLink;
    
    static Boolean lambda111(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 92) {
        return lambda109();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 93) {
        return lambda110(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda109()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnci$Ls$Gr, this.staticLink.s2, this.rest);
    }
    
    Object lambda110(Object paramObject1, Object paramObject2)
    {
      i = 1;
      localObject1 = Scheme.numEqu.apply2(AddOp.$Mn.apply2(this.end1, this.start1), AddOp.$Mn.apply2(paramObject2, paramObject1));
      try
      {
        Boolean localBoolean1 = Boolean.FALSE;
        if (localObject1 != localBoolean1) {}
        for (int j = i;; j = 0)
        {
          int k = 0x1 & j + 1;
          if (k == 0) {
            break label79;
          }
          if (k == 0) {
            break;
          }
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        label79:
        if (this.staticLink.s1 != this.staticLink.s2) {
          break label178;
        }
        m = i;
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          int m;
          Boolean localBoolean2 = Boolean.FALSE;
          if (localObject2 != localBoolean2) {}
          int n;
          for (;;)
          {
            n = 0x1 & i + 1;
            if (n == 0) {
              break label195;
            }
            return srfi13.$PcStringCompareCi(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, misc.values, srfi13.lambda$Fn111, misc.values);
            m = 0;
            break;
            i = 0;
            continue;
            i = m;
          }
          if (n != 0) {
            return Boolean.TRUE;
          }
          return Boolean.FALSE;
        }
        catch (ClassCastException localClassCastException2)
        {
          Object localObject2;
          throw new WrongType(localClassCastException2, "x", -2, localObject2);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "x", -2, localObject1);
      }
      if (m != 0) {
        localObject2 = Scheme.numEqu.apply2(this.start1, paramObject1);
      }
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 92)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 93)
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
  
  public class frame47
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn112 = new ModuleMethod(this, 98, null, 0);
    final ModuleMethod lambda$Fn113 = new ModuleMethod(this, 99, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 98) {
        return lambda112();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 99) {
        return lambda113(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda112()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnci$Ls, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda113(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame48 localframe48 = new srfi13.frame48();
      localframe48.staticLink = this;
      localframe48.rest = paramObject1;
      localframe48.start1 = paramObject2;
      localframe48.end1 = paramObject3;
      return call_with_values.callWithValues(localframe48.lambda$Fn114, localframe48.lambda$Fn115);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 98)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 99)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame48
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn114 = new ModuleMethod(this, 96, null, 0);
    final ModuleMethod lambda$Fn115 = new ModuleMethod(this, 97, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame47 staticLink;
    
    static Boolean lambda116(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda117(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 96) {
        return lambda114();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 97) {
        return lambda115(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda114()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnci$Ls, this.staticLink.s2, this.rest);
    }
    
    Object lambda115(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numLss.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompareCi(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, misc.values, srfi13.lambda$Fn116, srfi13.lambda$Fn117);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 96)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 97)
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
  
  public class frame49
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn118 = new ModuleMethod(this, 102, null, 0);
    final ModuleMethod lambda$Fn119 = new ModuleMethod(this, 103, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 102) {
        return lambda118();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 103) {
        return lambda119(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda118()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnci$Gr, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda119(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame50 localframe50 = new srfi13.frame50();
      localframe50.staticLink = this;
      localframe50.rest = paramObject1;
      localframe50.start1 = paramObject2;
      localframe50.end1 = paramObject3;
      return call_with_values.callWithValues(localframe50.lambda$Fn120, localframe50.lambda$Fn121);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 102)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 103)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame5
    extends ModuleBody
  {
    Object knil;
    Object kons;
    final ModuleMethod lambda$Fn13 = new ModuleMethod(this, 12, null, 0);
    final ModuleMethod lambda$Fn14 = new ModuleMethod(this, 13, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 12) {
        return lambda13();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 13) {
        return lambda14(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda13()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnfold, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda14(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = this.knil;
      Object localObject2 = paramObject1;
      for (;;)
      {
        if (Scheme.numLss.apply2(localObject2, paramObject2) != Boolean.FALSE)
        {
          ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
          Object localObject3 = this.kons;
          Object localObject4 = this.s;
          try
          {
            localCharSequence = (CharSequence)localObject4;
          }
          catch (ClassCastException localClassCastException1)
          {
            try
            {
              CharSequence localCharSequence;
              int i = ((Number)localObject2).intValue();
              localObject1 = localApplyToArgs.apply3(localObject3, Char.make(strings.stringRef(localCharSequence, i)), localObject1);
              localObject2 = AddOp.$Pl.apply2(localObject2, srfi13.Lit1);
            }
            catch (ClassCastException localClassCastException2)
            {
              throw new WrongType(localClassCastException2, "string-ref", 2, localObject2);
            }
            localClassCastException1 = localClassCastException1;
            throw new WrongType(localClassCastException1, "string-ref", 1, localObject4);
          }
        }
      }
      return localObject1;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 12)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 13)
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
  
  public class frame50
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn120 = new ModuleMethod(this, 100, null, 0);
    final ModuleMethod lambda$Fn121 = new ModuleMethod(this, 101, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame49 staticLink;
    
    static Boolean lambda122(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda123(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 100) {
        return lambda120();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 101) {
        return lambda121(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda120()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnci$Gr, this.staticLink.s2, this.rest);
    }
    
    Object lambda121(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numGrt.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompareCi(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, srfi13.lambda$Fn122, srfi13.lambda$Fn123, misc.values);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 100)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 101)
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
  
  public class frame51
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn124 = new ModuleMethod(this, 106, null, 0);
    final ModuleMethod lambda$Fn125 = new ModuleMethod(this, 107, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 106) {
        return lambda124();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 107) {
        return lambda125(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda124()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnci$Ls$Eq, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda125(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame52 localframe52 = new srfi13.frame52();
      localframe52.staticLink = this;
      localframe52.rest = paramObject1;
      localframe52.start1 = paramObject2;
      localframe52.end1 = paramObject3;
      return call_with_values.callWithValues(localframe52.lambda$Fn126, localframe52.lambda$Fn127);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 106)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 107)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame52
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn126 = new ModuleMethod(this, 104, null, 0);
    final ModuleMethod lambda$Fn127 = new ModuleMethod(this, 105, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame51 staticLink;
    
    static Boolean lambda128(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 104) {
        return lambda126();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 105) {
        return lambda127(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda126()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnci$Ls$Eq, this.staticLink.s2, this.rest);
    }
    
    Object lambda127(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numLEq.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompareCi(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, misc.values, misc.values, srfi13.lambda$Fn128);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 104)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 105)
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
  
  public class frame53
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn129 = new ModuleMethod(this, 110, null, 0);
    final ModuleMethod lambda$Fn130 = new ModuleMethod(this, 111, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 110) {
        return lambda129();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 111) {
        return lambda130(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda129()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnci$Gr$Eq, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda130(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame54 localframe54 = new srfi13.frame54();
      localframe54.staticLink = this;
      localframe54.rest = paramObject1;
      localframe54.start1 = paramObject2;
      localframe54.end1 = paramObject3;
      return call_with_values.callWithValues(localframe54.lambda$Fn131, localframe54.lambda$Fn132);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 110)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 111)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame54
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn131 = new ModuleMethod(this, 108, null, 0);
    final ModuleMethod lambda$Fn132 = new ModuleMethod(this, 109, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame53 staticLink;
    
    static Boolean lambda133(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 108) {
        return lambda131();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 109) {
        return lambda132(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda131()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnci$Gr$Eq, this.staticLink.s2, this.rest);
    }
    
    Object lambda132(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numGEq.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompareCi(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, srfi13.lambda$Fn133, misc.values, misc.values);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 108)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 109)
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
  
  public class frame55
    extends ModuleBody
  {
    Object char$Mn$Grint;
  }
  
  public class frame56
    extends ModuleBody
  {
    Object bound;
    final ModuleMethod lambda$Fn134 = new ModuleMethod(this, 112, null, 0);
    final ModuleMethod lambda$Fn135 = new ModuleMethod(this, 113, null, 8194);
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 112) {
        return lambda134();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 113) {
        return lambda135(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda134()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mnhash;
      Object localObject1 = this.s;
      Location localLocation = srfi13.loc$rest;
      try
      {
        Object localObject2 = localLocation.get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("srfi13.scm", 912, 55);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda135(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringHash(this.s, characters.char$Mn$Grinteger, this.bound, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 112)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 113)
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
  
  public class frame57
    extends ModuleBody
  {
    Object bound;
    final ModuleMethod lambda$Fn136 = new ModuleMethod(this, 114, null, 0);
    final ModuleMethod lambda$Fn137 = new ModuleMethod(this, 115, null, 8194);
    Object s;
    
    static int lambda138(Object paramObject)
    {
      try
      {
        Char localChar = (Char)paramObject;
        return characters.char$To$Integer(unicode.charDowncase(localChar));
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "char-downcase", 1, paramObject);
      }
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 114) {
        return lambda136();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 115) {
        return lambda137(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda136()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mnhash$Mnci;
      Object localObject1 = this.s;
      Location localLocation = srfi13.loc$rest;
      try
      {
        Object localObject2 = localLocation.get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("srfi13.scm", 921, 58);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda137(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringHash(this.s, srfi13.lambda$Fn138, this.bound, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 114)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 115)
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
  
  public class frame58
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn139 = new ModuleMethod(this, 116, null, 0);
    final ModuleMethod lambda$Fn140 = new ModuleMethod(this, 117, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 116) {
        return lambda139();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 117) {
        return lambda140(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda139()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnupcase, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda140(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringMap(unicode.char$Mnupcase, this.s, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 116)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 117)
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
  
  public class frame59
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn141 = new ModuleMethod(this, 118, null, 0);
    final ModuleMethod lambda$Fn142 = new ModuleMethod(this, 119, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 118) {
        return lambda141();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 119) {
        return lambda142(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda141()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnupcase$Ex, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda142(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringMap$Ex(unicode.char$Mnupcase, this.s, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 118)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 119)
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
  
  public class frame6
    extends ModuleBody
  {
    Object knil;
    Object kons;
    final ModuleMethod lambda$Fn15 = new ModuleMethod(this, 14, null, 0);
    final ModuleMethod lambda$Fn16 = new ModuleMethod(this, 15, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 14) {
        return lambda15();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 15) {
        return lambda16(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda15()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnfold$Mnright, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda16(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = this.knil;
      Object localObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
      for (;;)
      {
        if (Scheme.numGEq.apply2(localObject2, paramObject1) != Boolean.FALSE)
        {
          ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
          Object localObject3 = this.kons;
          Object localObject4 = this.s;
          try
          {
            localCharSequence = (CharSequence)localObject4;
          }
          catch (ClassCastException localClassCastException1)
          {
            try
            {
              CharSequence localCharSequence;
              int i = ((Number)localObject2).intValue();
              localObject1 = localApplyToArgs.apply3(localObject3, Char.make(strings.stringRef(localCharSequence, i)), localObject1);
              localObject2 = AddOp.$Mn.apply2(localObject2, srfi13.Lit1);
            }
            catch (ClassCastException localClassCastException2)
            {
              throw new WrongType(localClassCastException2, "string-ref", 2, localObject2);
            }
            localClassCastException1 = localClassCastException1;
            throw new WrongType(localClassCastException1, "string-ref", 1, localObject4);
          }
        }
      }
      return localObject1;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 14)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 15)
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
  
  public class frame60
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn143 = new ModuleMethod(this, 120, null, 0);
    final ModuleMethod lambda$Fn144 = new ModuleMethod(this, 121, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 120) {
        return lambda143();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 121) {
        return lambda144(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda143()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mndowncase, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda144(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringMap(unicode.char$Mndowncase, this.s, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 120)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 121)
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
  
  public class frame61
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn145 = new ModuleMethod(this, 122, null, 0);
    final ModuleMethod lambda$Fn146 = new ModuleMethod(this, 123, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 122) {
        return lambda145();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 123) {
        return lambda146(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda145()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mndowncase$Ex, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda146(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringMap$Ex(unicode.char$Mndowncase, this.s, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 122)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 123)
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
  
  public class frame62
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn147 = new ModuleMethod(this, 124, null, 0);
    final ModuleMethod lambda$Fn148 = new ModuleMethod(this, 125, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 124) {
        return lambda147();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 125) {
        return lambda148(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda147()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mntitlecase$Ex, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda148(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringTitlecase$Ex(this.s, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 124)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 125)
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
  
  public class frame63
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn149 = new ModuleMethod(this, 126, null, 0);
    final ModuleMethod lambda$Fn150 = new ModuleMethod(this, 127, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 126) {
        return lambda149();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 127) {
        return lambda150(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda149()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mntitlecase$Ex, this.s, this.maybe$Mnstart$Plend);
    }
    
    /* Error */
    CharSequence lambda150(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 51	gnu/kawa/slib/srfi13$frame63:s	Ljava/lang/Object;
      //   4: astore_3
      //   5: aload_3
      //   6: checkcast 61	java/lang/CharSequence
      //   9: astore 5
      //   11: aload_1
      //   12: checkcast 63	java/lang/Number
      //   15: invokevirtual 67	java/lang/Number:intValue	()I
      //   18: istore 7
      //   20: aload_2
      //   21: checkcast 63	java/lang/Number
      //   24: invokevirtual 67	java/lang/Number:intValue	()I
      //   27: istore 9
      //   29: aload 5
      //   31: iload 7
      //   33: iload 9
      //   35: invokestatic 73	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   38: astore 10
      //   40: aload 10
      //   42: getstatic 77	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
      //   45: getstatic 83	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   48: aload_2
      //   49: aload_1
      //   50: invokevirtual 88	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   53: invokestatic 91	gnu/kawa/slib/srfi13:$PcStringTitlecase$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   56: pop
      //   57: aload 10
      //   59: areturn
      //   60: astore 4
      //   62: new 93	gnu/mapping/WrongType
      //   65: dup
      //   66: aload 4
      //   68: ldc 94
      //   70: iconst_1
      //   71: aload_3
      //   72: invokespecial 97	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   75: athrow
      //   76: astore 6
      //   78: new 93	gnu/mapping/WrongType
      //   81: dup
      //   82: aload 6
      //   84: ldc 94
      //   86: iconst_2
      //   87: aload_1
      //   88: invokespecial 97	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   91: athrow
      //   92: astore 8
      //   94: new 93	gnu/mapping/WrongType
      //   97: dup
      //   98: aload 8
      //   100: ldc 94
      //   102: iconst_3
      //   103: aload_2
      //   104: invokespecial 97	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   107: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	108	0	this	frame63
      //   0	108	1	paramObject1	Object
      //   0	108	2	paramObject2	Object
      //   4	68	3	localObject	Object
      //   60	7	4	localClassCastException1	ClassCastException
      //   9	21	5	localCharSequence1	CharSequence
      //   76	7	6	localClassCastException2	ClassCastException
      //   18	14	7	i	int
      //   92	7	8	localClassCastException3	ClassCastException
      //   27	7	9	j	int
      //   38	20	10	localCharSequence2	CharSequence
      // Exception table:
      //   from	to	target	type
      //   5	11	60	java/lang/ClassCastException
      //   11	20	76	java/lang/ClassCastException
      //   20	29	92	java/lang/ClassCastException
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 126)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 127)
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
  
  public class frame64
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn151;
    Object n;
    Object s;
    
    public frame64()
    {
      this$1 = new ModuleMethod(this, 128, null, 4097);
      this$1.setProperty("source-location", "srfi13.scm:996");
      this.lambda$Fn151 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 128)
      {
        if (lambda151(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda151(Object paramObject)
    {
      boolean bool = numbers.isInteger(this.n);
      NumberCompare localNumberCompare;
      IntNum localIntNum;
      Object localObject1;
      Object localObject2;
      if (bool)
      {
        bool = numbers.isExact(this.n);
        if (bool)
        {
          localNumberCompare = Scheme.numLEq;
          localIntNum = srfi13.Lit0;
          localObject1 = this.n;
          localObject2 = this.s;
        }
      }
      try
      {
        CharSequence localCharSequence = (CharSequence)localObject2;
        bool = ((Boolean)localNumberCompare.apply3(localIntNum, localObject1, Integer.valueOf(strings.stringLength(localCharSequence)))).booleanValue();
        return bool;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "string-length", 1, localObject2);
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 128)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame65
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn152;
    int len;
    Object n;
    
    public frame65()
    {
      this$1 = new ModuleMethod(this, 129, null, 4097);
      this$1.setProperty("source-location", "srfi13.scm:1004");
      this.lambda$Fn152 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 129)
      {
        if (lambda152(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda152(Object paramObject)
    {
      boolean bool = numbers.isInteger(this.n);
      if (bool)
      {
        bool = numbers.isExact(this.n);
        if (bool) {
          bool = ((Boolean)Scheme.numLEq.apply3(srfi13.Lit0, this.n, Integer.valueOf(this.len))).booleanValue();
        }
      }
      return bool;
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 129)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame66
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn153;
    int len;
    Object n;
    
    public frame66()
    {
      this$1 = new ModuleMethod(this, 130, null, 4097);
      this$1.setProperty("source-location", "srfi13.scm:1010");
      this.lambda$Fn153 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 130)
      {
        if (lambda153(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda153(Object paramObject)
    {
      boolean bool = numbers.isInteger(this.n);
      if (bool)
      {
        bool = numbers.isExact(this.n);
        if (bool) {
          bool = ((Boolean)Scheme.numLEq.apply3(srfi13.Lit0, this.n, Integer.valueOf(this.len))).booleanValue();
        }
      }
      return bool;
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 130)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame67
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn154;
    int len;
    Object n;
    
    public frame67()
    {
      this$1 = new ModuleMethod(this, 131, null, 4097);
      this$1.setProperty("source-location", "srfi13.scm:1016");
      this.lambda$Fn154 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 131)
      {
        if (lambda154(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda154(Object paramObject)
    {
      boolean bool = numbers.isInteger(this.n);
      if (bool)
      {
        bool = numbers.isExact(this.n);
        if (bool) {
          bool = ((Boolean)Scheme.numLEq.apply3(srfi13.Lit0, this.n, Integer.valueOf(this.len))).booleanValue();
        }
      }
      return bool;
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 131)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame68
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn155 = new ModuleMethod(this, 132, null, 0);
    final ModuleMethod lambda$Fn156 = new ModuleMethod(this, 133, null, 8194);
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 132) {
        return lambda155();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 133) {
        return lambda156(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda155()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mntrim;
      Object localObject1 = this.s;
      Location localLocation = srfi13.loc$rest;
      try
      {
        Object localObject2 = localLocation.get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("srfi13.scm", 1023, 53);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda156(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = this.s;
      Location localLocation = srfi13.loc$criterion;
      try
      {
        Object localObject2 = localLocation.get();
        localObject3 = srfi13.stringSkip$V(localObject1, localObject2, new Object[] { paramObject1, paramObject2 });
        if (localObject3 != Boolean.FALSE) {
          localObject4 = this.s;
        }
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        CharSequence localCharSequence;
        int i;
        int j;
        localUnboundLocationException.setLine("srfi13.scm", 1024, 29);
        throw localUnboundLocationException;
      }
      try
      {
        localCharSequence = (CharSequence)localObject4;
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "%substring/shared", 0, localObject4);
      }
      try
      {
        i = ((Number)localObject3).intValue();
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "%substring/shared", 1, localObject3);
      }
      try
      {
        j = ((Number)paramObject2).intValue();
        return srfi13.$PcSubstring$SlShared(localCharSequence, i, j);
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "%substring/shared", 2, paramObject2);
      }
      return "";
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 132)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 133)
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
  
  public class frame69
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn157 = new ModuleMethod(this, 134, null, 0);
    final ModuleMethod lambda$Fn158 = new ModuleMethod(this, 135, null, 8194);
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 134) {
        return lambda157();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 135) {
        return lambda158(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda157()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mntrim$Mnright;
      Object localObject1 = this.s;
      Location localLocation = srfi13.loc$rest;
      try
      {
        Object localObject2 = localLocation.get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("srfi13.scm", 1030, 59);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda158(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = this.s;
      Location localLocation = srfi13.loc$criterion;
      try
      {
        Object localObject2 = localLocation.get();
        localObject3 = srfi13.stringSkipRight$V(localObject1, localObject2, new Object[] { paramObject1, paramObject2 });
        if (localObject3 != Boolean.FALSE) {
          localObject4 = this.s;
        }
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        Object localObject3;
        CharSequence localCharSequence;
        int i;
        localUnboundLocationException.setLine("srfi13.scm", 1031, 35);
        throw localUnboundLocationException;
      }
      try
      {
        localCharSequence = (CharSequence)localObject4;
        localObject5 = AddOp.$Pl.apply2(srfi13.Lit1, localObject3);
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "%substring/shared", 0, localObject4);
      }
      try
      {
        i = ((Number)localObject5).intValue();
        return srfi13.$PcSubstring$SlShared(localCharSequence, 0, i);
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "%substring/shared", 2, localObject5);
      }
      return "";
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 134)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 135)
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
  
  public class frame7
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn19 = new ModuleMethod(this, 16, null, 0);
    final ModuleMethod lambda$Fn20 = new ModuleMethod(this, 17, null, 8194);
    LList maybe$Mnstart$Plend;
    Object proc;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 16) {
        return lambda19();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 17) {
        return lambda20(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda19()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnfor$Mneach, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda20(Object paramObject1, Object paramObject2)
    {
      localObject1 = paramObject1;
      for (;;)
      {
        ApplyToArgs localApplyToArgs;
        Object localObject2;
        Object localObject3;
        if (Scheme.numLss.apply2(localObject1, paramObject2) != Boolean.FALSE)
        {
          localApplyToArgs = Scheme.applyToArgs;
          localObject2 = this.proc;
          localObject3 = this.s;
        }
        try
        {
          localCharSequence = (CharSequence)localObject3;
        }
        catch (ClassCastException localClassCastException1)
        {
          CharSequence localCharSequence;
          int i;
          throw new WrongType(localClassCastException1, "string-ref", 1, localObject3);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          localApplyToArgs.apply2(localObject2, Char.make(strings.stringRef(localCharSequence, i)));
          localObject1 = AddOp.$Pl.apply2(localObject1, srfi13.Lit1);
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-ref", 2, localObject1);
        }
      }
      return Values.empty;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 16)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 17)
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
  
  public class frame70
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn159 = new ModuleMethod(this, 136, null, 0);
    final ModuleMethod lambda$Fn160 = new ModuleMethod(this, 137, null, 8194);
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 136) {
        return lambda159();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 137) {
        return lambda160(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda159()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mntrim$Mnboth;
      Object localObject1 = this.s;
      Location localLocation = srfi13.loc$rest;
      try
      {
        Object localObject2 = localLocation.get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("srfi13.scm", 1037, 58);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda160(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = this.s;
      Location localLocation1 = srfi13.loc$criterion;
      try
      {
        Object localObject2 = localLocation1.get();
        localObject3 = srfi13.stringSkip$V(localObject1, localObject2, new Object[] { paramObject1, paramObject2 });
        if (localObject3 != Boolean.FALSE) {
          localObject4 = this.s;
        }
      }
      catch (UnboundLocationException localUnboundLocationException1)
      {
        CharSequence localCharSequence;
        int i;
        AddOp localAddOp;
        IntNum localIntNum;
        Object localObject5;
        Location localLocation2;
        Object localObject6;
        int j;
        localUnboundLocationException1.setLine("srfi13.scm", 1038, 29);
        throw localUnboundLocationException1;
      }
      try
      {
        localCharSequence = (CharSequence)localObject4;
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "%substring/shared", 0, localObject4);
      }
      try
      {
        i = ((Number)localObject3).intValue();
        localAddOp = AddOp.$Pl;
        localIntNum = srfi13.Lit1;
        localObject5 = this.s;
        localLocation2 = srfi13.loc$criterion;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "%substring/shared", 1, localObject3);
      }
      try
      {
        localObject6 = localLocation2.get();
        localObject7 = localAddOp.apply2(localIntNum, srfi13.stringSkipRight$V(localObject5, localObject6, new Object[] { localObject3, paramObject2 }));
      }
      catch (UnboundLocationException localUnboundLocationException2)
      {
        localUnboundLocationException2.setLine("srfi13.scm", 1040, 58);
        throw localUnboundLocationException2;
      }
      try
      {
        j = ((Number)localObject7).intValue();
        return srfi13.$PcSubstring$SlShared(localCharSequence, i, j);
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "%substring/shared", 2, localObject7);
      }
      return "";
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 136)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 137)
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
  
  public class frame71
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn161 = new ModuleMethod(this, 138, null, 0);
    final ModuleMethod lambda$Fn162 = new ModuleMethod(this, 139, null, 8194);
    Object n;
    Object s;
    
    static boolean lambda163(Object paramObject)
    {
      boolean bool = numbers.isInteger(paramObject);
      if (bool)
      {
        bool = numbers.isExact(paramObject);
        if (bool) {
          bool = ((Boolean)Scheme.numLEq.apply2(srfi13.Lit0, paramObject)).booleanValue();
        }
      }
      return bool;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 138) {
        return lambda161();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 139) {
        return lambda162(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda161()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mnpad$Mnright;
      Object localObject1 = this.s;
      Location localLocation = srfi13.loc$rest;
      try
      {
        Object localObject2 = localLocation.get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("srfi13.scm", 1046, 58);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda162(Object paramObject1, Object paramObject2)
    {
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      Location localLocation = srfi13.loc$check$Mnarg;
      try
      {
        Object localObject1 = localLocation.get();
        localApplyToArgs.apply4(localObject1, srfi13.lambda$Fn163, this.n, srfi13.string$Mnpad$Mnright);
        Object localObject2 = AddOp.$Mn.apply2(paramObject2, paramObject1);
        if (Scheme.numLEq.apply2(this.n, localObject2) != Boolean.FALSE) {
          localObject5 = this.s;
        }
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        try
        {
          CharSequence localCharSequence3;
          int m;
          int i1;
          int i = ((Number)localObject3).intValue();
          localCharSequence1 = strings.makeString(i, LangPrimType.charType);
          localObject4 = this.s;
        }
        catch (ClassCastException localClassCastException1)
        {
          Object localObject5;
          Object localObject6;
          Object localObject3;
          CharSequence localCharSequence1;
          CharSequence localCharSequence2;
          int j;
          int k;
          throw new WrongType(localClassCastException1, "make-string", 1, localObject3);
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject4;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "%string-copy!", 2, localObject4);
        }
        try
        {
          j = ((Number)paramObject1).intValue();
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "%string-copy!", 3, paramObject1);
        }
        try
        {
          k = ((Number)paramObject2).intValue();
          srfi13.$PcStringCopy$Ex(localCharSequence1, 0, localCharSequence2, j, k);
          return localCharSequence1;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "%string-copy!", 4, paramObject2);
        }
        localUnboundLocationException = localUnboundLocationException;
        localUnboundLocationException.setLine("srfi13.scm", 1047, 7);
        throw localUnboundLocationException;
      }
      try
      {
        localCharSequence3 = (CharSequence)localObject5;
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "%substring/shared", 0, localObject5);
      }
      try
      {
        m = ((Number)paramObject1).intValue();
        localObject6 = AddOp.$Pl.apply2(paramObject1, this.n);
      }
      catch (ClassCastException localClassCastException6)
      {
        throw new WrongType(localClassCastException6, "%substring/shared", 1, paramObject1);
      }
      try
      {
        i1 = ((Number)localObject6).intValue();
        return srfi13.$PcSubstring$SlShared(localCharSequence3, m, i1);
      }
      catch (ClassCastException localClassCastException7)
      {
        throw new WrongType(localClassCastException7, "%substring/shared", 2, localObject6);
      }
      localObject3 = this.n;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 138)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 139)
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
  
  public class frame72
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn164 = new ModuleMethod(this, 140, null, 0);
    final ModuleMethod lambda$Fn165 = new ModuleMethod(this, 141, null, 8194);
    Object n;
    Object s;
    
    static boolean lambda166(Object paramObject)
    {
      boolean bool = numbers.isInteger(paramObject);
      if (bool)
      {
        bool = numbers.isExact(paramObject);
        if (bool) {
          bool = ((Boolean)Scheme.numLEq.apply2(srfi13.Lit0, paramObject)).booleanValue();
        }
      }
      return bool;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 140) {
        return lambda164();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 141) {
        return lambda165(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda164()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mnpad;
      Object localObject1 = this.s;
      Location localLocation = srfi13.loc$rest;
      try
      {
        Object localObject2 = localLocation.get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("srfi13.scm", 1058, 52);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda165(Object paramObject1, Object paramObject2)
    {
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      Location localLocation = srfi13.loc$check$Mnarg;
      try
      {
        Object localObject1 = localLocation.get();
        localApplyToArgs.apply4(localObject1, srfi13.lambda$Fn166, this.n, srfi13.string$Mnpad);
        localObject2 = AddOp.$Mn.apply2(paramObject2, paramObject1);
        if (Scheme.numLEq.apply2(this.n, localObject2) != Boolean.FALSE) {
          localObject6 = this.s;
        }
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        try
        {
          Object localObject2;
          CharSequence localCharSequence3;
          int i1;
          int i2;
          int i = ((Number)localObject3).intValue();
          localCharSequence1 = strings.makeString(i, LangPrimType.charType);
          localObject4 = AddOp.$Mn.apply2(this.n, localObject2);
        }
        catch (ClassCastException localClassCastException1)
        {
          Object localObject6;
          Object localObject7;
          Object localObject3;
          CharSequence localCharSequence1;
          int j;
          CharSequence localCharSequence2;
          int k;
          int m;
          throw new WrongType(localClassCastException1, "make-string", 1, localObject3);
        }
        try
        {
          j = ((Number)localObject4).intValue();
          localObject5 = this.s;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "%string-copy!", 1, localObject4);
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject5;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "%string-copy!", 2, localObject5);
        }
        try
        {
          k = ((Number)paramObject1).intValue();
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "%string-copy!", 3, paramObject1);
        }
        try
        {
          m = ((Number)paramObject2).intValue();
          srfi13.$PcStringCopy$Ex(localCharSequence1, j, localCharSequence2, k, m);
          return localCharSequence1;
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "%string-copy!", 4, paramObject2);
        }
        localUnboundLocationException = localUnboundLocationException;
        localUnboundLocationException.setLine("srfi13.scm", 1059, 7);
        throw localUnboundLocationException;
      }
      try
      {
        localCharSequence3 = (CharSequence)localObject6;
        localObject7 = AddOp.$Mn.apply2(paramObject2, this.n);
      }
      catch (ClassCastException localClassCastException6)
      {
        throw new WrongType(localClassCastException6, "%substring/shared", 0, localObject6);
      }
      try
      {
        i1 = ((Number)localObject7).intValue();
      }
      catch (ClassCastException localClassCastException7)
      {
        throw new WrongType(localClassCastException7, "%substring/shared", 1, localObject7);
      }
      try
      {
        i2 = ((Number)paramObject2).intValue();
        return srfi13.$PcSubstring$SlShared(localCharSequence3, i1, i2);
      }
      catch (ClassCastException localClassCastException8)
      {
        throw new WrongType(localClassCastException8, "%substring/shared", 2, paramObject2);
      }
      localObject3 = this.n;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 140)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 141)
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
  
  public class frame73
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn167 = new ModuleMethod(this, 145, null, 0);
    final ModuleMethod lambda$Fn168 = new ModuleMethod(this, 146, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 145) {
        return lambda167();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 146) {
        return lambda168(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda167()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mndelete, this.s, this.maybe$Mnstart$Plend);
    }
    
    CharSequence lambda168(Object paramObject1, Object paramObject2)
    {
      srfi13.frame74 localframe74 = new srfi13.frame74();
      localframe74.staticLink = this;
      if (misc.isProcedure(this.criterion)) {
        localObject5 = AddOp.$Mn.apply2(paramObject2, paramObject1);
      }
      try
      {
        int j = ((Number)localObject5).intValue();
        localframe74.temp = strings.makeString(j);
        localObject6 = srfi13.stringFold$V(localframe74.lambda$Fn169, srfi13.Lit0, this.s, new Object[] { paramObject1, paramObject2 });
        if (Scheme.numEqu.apply2(localObject6, localObject5) != Boolean.FALSE) {
          return localframe74.temp;
        }
        localCharSequence = localframe74.temp;
      }
      catch (ClassCastException localClassCastException2)
      {
        CharSequence localCharSequence;
        int k;
        ApplyToArgs localApplyToArgs1;
        Location localLocation1;
        throw new WrongType(localClassCastException2, "make-string", 1, localObject5);
      }
      try
      {
        k = ((Number)localObject6).intValue();
        return strings.substring(localCharSequence, 0, k);
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "substring", 3, localObject6);
      }
      localApplyToArgs1 = Scheme.applyToArgs;
      localLocation1 = srfi13.loc$char$Mnset$Qu;
      for (;;)
      {
        try
        {
          Object localObject1 = localLocation1.get();
          if (localApplyToArgs1.apply2(localObject1, this.criterion) != Boolean.FALSE)
          {
            localObject2 = this.criterion;
            localframe74.cset = localObject2;
            localObject3 = srfi13.stringFold$V(localframe74.lambda$Fn170, srfi13.Lit0, this.s, new Object[] { paramObject1, paramObject2 });
          }
        }
        catch (UnboundLocationException localUnboundLocationException1)
        {
          Object localObject2;
          int i;
          ApplyToArgs localApplyToArgs2;
          Location localLocation2;
          localUnboundLocationException1.setLine("srfi13.scm", 1096, 22);
          throw localUnboundLocationException1;
        }
        try
        {
          i = ((Number)localObject3).intValue();
          localframe74.ans = strings.makeString(i);
          srfi13.stringFold$V(localframe74.lambda$Fn171, srfi13.Lit0, this.s, new Object[] { paramObject1, paramObject2 });
          return localframe74.ans;
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "make-string", 1, localObject3);
        }
        if (characters.isChar(this.criterion))
        {
          localApplyToArgs2 = Scheme.applyToArgs;
          localLocation2 = srfi13.loc$char$Mnset;
        }
        try
        {
          Object localObject4 = localLocation2.get();
          localObject2 = localApplyToArgs2.apply2(localObject4, this.criterion);
        }
        catch (UnboundLocationException localUnboundLocationException2)
        {
          Object[] arrayOfObject;
          localUnboundLocationException2.setLine("srfi13.scm", 1097, 26);
          throw localUnboundLocationException2;
        }
        arrayOfObject = new Object[1];
        arrayOfObject[0] = this.criterion;
        localObject2 = misc.error$V("string-delete criterion not predicate, char or char-set", arrayOfObject);
      }
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 145)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 146)
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
  
  public class frame74
    extends ModuleBody
  {
    CharSequence ans;
    Object cset;
    final ModuleMethod lambda$Fn169;
    final ModuleMethod lambda$Fn170;
    final ModuleMethod lambda$Fn171;
    srfi13.frame73 staticLink;
    CharSequence temp;
    
    public frame74()
    {
      this$1 = new ModuleMethod(this, 142, null, 8194);
      this$1.setProperty("source-location", "srfi13.scm:1089");
      this.lambda$Fn169 = this$1;
      ModuleMethod localModuleMethod1 = new ModuleMethod(this, 143, null, 8194);
      localModuleMethod1.setProperty("source-location", "srfi13.scm:1099");
      this.lambda$Fn170 = localModuleMethod1;
      ModuleMethod localModuleMethod2 = new ModuleMethod(this, 144, null, 8194);
      localModuleMethod2.setProperty("source-location", "srfi13.scm:1104");
      this.lambda$Fn171 = localModuleMethod2;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply2(paramModuleMethod, paramObject1, paramObject2);
      case 142: 
        return lambda169(paramObject1, paramObject2);
      case 143: 
        return lambda170(paramObject1, paramObject2);
      }
      return lambda171(paramObject1, paramObject2);
    }
    
    /* Error */
    Object lambda169(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 70	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   3: aload_0
      //   4: getfield 72	gnu/kawa/slib/srfi13$frame74:staticLink	Lgnu/kawa/slib/srfi13$frame73;
      //   7: getfield 77	gnu/kawa/slib/srfi13$frame73:criterion	Ljava/lang/Object;
      //   10: aload_1
      //   11: invokevirtual 81	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   14: getstatic 87	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   17: if_acmpeq +5 -> 22
      //   20: aload_2
      //   21: areturn
      //   22: aload_0
      //   23: getfield 89	gnu/kawa/slib/srfi13$frame74:temp	Ljava/lang/CharSequence;
      //   26: astore_3
      //   27: aload_3
      //   28: checkcast 91	gnu/lists/CharSeq
      //   31: astore 5
      //   33: aload_2
      //   34: checkcast 93	java/lang/Number
      //   37: invokevirtual 97	java/lang/Number:intValue	()I
      //   40: istore 7
      //   42: aload_1
      //   43: checkcast 99	gnu/text/Char
      //   46: invokevirtual 103	gnu/text/Char:charValue	()C
      //   49: istore 9
      //   51: aload 5
      //   53: iload 7
      //   55: iload 9
      //   57: invokestatic 109	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
      //   60: getstatic 115	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   63: aload_2
      //   64: getstatic 121	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   67: invokevirtual 81	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   70: areturn
      //   71: astore 4
      //   73: new 123	gnu/mapping/WrongType
      //   76: dup
      //   77: aload 4
      //   79: ldc 125
      //   81: iconst_1
      //   82: aload_3
      //   83: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   86: athrow
      //   87: astore 6
      //   89: new 123	gnu/mapping/WrongType
      //   92: dup
      //   93: aload 6
      //   95: ldc 125
      //   97: iconst_2
      //   98: aload_2
      //   99: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   102: athrow
      //   103: astore 8
      //   105: new 123	gnu/mapping/WrongType
      //   108: dup
      //   109: aload 8
      //   111: ldc 125
      //   113: iconst_3
      //   114: aload_1
      //   115: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   118: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	119	0	this	frame74
      //   0	119	1	paramObject1	Object
      //   0	119	2	paramObject2	Object
      //   26	57	3	localCharSequence	CharSequence
      //   71	7	4	localClassCastException1	ClassCastException
      //   31	21	5	localCharSeq	CharSeq
      //   87	7	6	localClassCastException2	ClassCastException
      //   40	14	7	i	int
      //   103	7	8	localClassCastException3	ClassCastException
      //   49	7	9	c	char
      // Exception table:
      //   from	to	target	type
      //   27	33	71	java/lang/ClassCastException
      //   33	42	87	java/lang/ClassCastException
      //   42	51	103	java/lang/ClassCastException
    }
    
    Object lambda170(Object paramObject1, Object paramObject2)
    {
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      Location localLocation = srfi13.loc$char$Mnset$Mncontains$Qu;
      try
      {
        Object localObject = localLocation.get();
        if (localApplyToArgs.apply3(localObject, this.cset, paramObject1) != Boolean.FALSE) {
          return paramObject2;
        }
        return AddOp.$Pl.apply2(paramObject2, srfi13.Lit1);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("srfi13.scm", 1099, 45);
        throw localUnboundLocationException;
      }
    }
    
    /* Error */
    Object lambda171(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 70	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   3: astore_3
      //   4: getstatic 134	gnu/kawa/slib/srfi13:loc$char$Mnset$Mncontains$Qu	Lgnu/mapping/Location;
      //   7: astore 4
      //   9: aload 4
      //   11: invokevirtual 140	gnu/mapping/Location:get	()Ljava/lang/Object;
      //   14: astore 6
      //   16: aload_3
      //   17: aload 6
      //   19: aload_0
      //   20: getfield 142	gnu/kawa/slib/srfi13$frame74:cset	Ljava/lang/Object;
      //   23: aload_1
      //   24: invokevirtual 146	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   27: getstatic 87	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   30: if_acmpeq +5 -> 35
      //   33: aload_2
      //   34: areturn
      //   35: aload_0
      //   36: getfield 154	gnu/kawa/slib/srfi13$frame74:ans	Ljava/lang/CharSequence;
      //   39: astore 7
      //   41: aload 7
      //   43: checkcast 91	gnu/lists/CharSeq
      //   46: astore 9
      //   48: aload_2
      //   49: checkcast 93	java/lang/Number
      //   52: invokevirtual 97	java/lang/Number:intValue	()I
      //   55: istore 11
      //   57: aload_1
      //   58: checkcast 99	gnu/text/Char
      //   61: invokevirtual 103	gnu/text/Char:charValue	()C
      //   64: istore 13
      //   66: aload 9
      //   68: iload 11
      //   70: iload 13
      //   72: invokestatic 109	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
      //   75: getstatic 115	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   78: aload_2
      //   79: getstatic 121	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   82: invokevirtual 81	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   85: areturn
      //   86: astore 5
      //   88: aload 5
      //   90: ldc 148
      //   92: sipush 1104
      //   95: bipush 35
      //   97: invokevirtual 152	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
      //   100: aload 5
      //   102: athrow
      //   103: astore 8
      //   105: new 123	gnu/mapping/WrongType
      //   108: dup
      //   109: aload 8
      //   111: ldc 125
      //   113: iconst_1
      //   114: aload 7
      //   116: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   119: athrow
      //   120: astore 10
      //   122: new 123	gnu/mapping/WrongType
      //   125: dup
      //   126: aload 10
      //   128: ldc 125
      //   130: iconst_2
      //   131: aload_2
      //   132: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   135: athrow
      //   136: astore 12
      //   138: new 123	gnu/mapping/WrongType
      //   141: dup
      //   142: aload 12
      //   144: ldc 125
      //   146: iconst_3
      //   147: aload_1
      //   148: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   151: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	152	0	this	frame74
      //   0	152	1	paramObject1	Object
      //   0	152	2	paramObject2	Object
      //   3	14	3	localApplyToArgs	ApplyToArgs
      //   7	3	4	localLocation	Location
      //   86	15	5	localUnboundLocationException	UnboundLocationException
      //   14	4	6	localObject	Object
      //   39	76	7	localCharSequence	CharSequence
      //   103	7	8	localClassCastException1	ClassCastException
      //   46	21	9	localCharSeq	CharSeq
      //   120	7	10	localClassCastException2	ClassCastException
      //   55	14	11	i	int
      //   136	7	12	localClassCastException3	ClassCastException
      //   64	7	13	c	char
      // Exception table:
      //   from	to	target	type
      //   9	16	86	gnu/mapping/UnboundLocationException
      //   41	48	103	java/lang/ClassCastException
      //   48	57	120	java/lang/ClassCastException
      //   57	66	136	java/lang/ClassCastException
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
      case 144: 
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      case 143: 
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
  }
  
  public class frame75
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn172 = new ModuleMethod(this, 150, null, 0);
    final ModuleMethod lambda$Fn173 = new ModuleMethod(this, 151, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 150) {
        return lambda172();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 151) {
        return lambda173(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda172()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnfilter, this.s, this.maybe$Mnstart$Plend);
    }
    
    CharSequence lambda173(Object paramObject1, Object paramObject2)
    {
      srfi13.frame76 localframe76 = new srfi13.frame76();
      localframe76.staticLink = this;
      if (misc.isProcedure(this.criterion)) {
        localObject5 = AddOp.$Mn.apply2(paramObject2, paramObject1);
      }
      try
      {
        int j = ((Number)localObject5).intValue();
        localframe76.temp = strings.makeString(j);
        localObject6 = srfi13.stringFold$V(localframe76.lambda$Fn174, srfi13.Lit0, this.s, new Object[] { paramObject1, paramObject2 });
        if (Scheme.numEqu.apply2(localObject6, localObject5) != Boolean.FALSE) {
          return localframe76.temp;
        }
        localCharSequence = localframe76.temp;
      }
      catch (ClassCastException localClassCastException2)
      {
        CharSequence localCharSequence;
        int k;
        ApplyToArgs localApplyToArgs1;
        Location localLocation1;
        throw new WrongType(localClassCastException2, "make-string", 1, localObject5);
      }
      try
      {
        k = ((Number)localObject6).intValue();
        return strings.substring(localCharSequence, 0, k);
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "substring", 3, localObject6);
      }
      localApplyToArgs1 = Scheme.applyToArgs;
      localLocation1 = srfi13.loc$char$Mnset$Qu;
      for (;;)
      {
        try
        {
          Object localObject1 = localLocation1.get();
          if (localApplyToArgs1.apply2(localObject1, this.criterion) != Boolean.FALSE)
          {
            localObject2 = this.criterion;
            localframe76.cset = localObject2;
            localObject3 = srfi13.stringFold$V(localframe76.lambda$Fn175, srfi13.Lit0, this.s, new Object[] { paramObject1, paramObject2 });
          }
        }
        catch (UnboundLocationException localUnboundLocationException1)
        {
          Object localObject2;
          int i;
          ApplyToArgs localApplyToArgs2;
          Location localLocation2;
          localUnboundLocationException1.setLine("srfi13.scm", 1124, 22);
          throw localUnboundLocationException1;
        }
        try
        {
          i = ((Number)localObject3).intValue();
          localframe76.ans = strings.makeString(i);
          srfi13.stringFold$V(localframe76.lambda$Fn176, srfi13.Lit0, this.s, new Object[] { paramObject1, paramObject2 });
          return localframe76.ans;
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "make-string", 1, localObject3);
        }
        if (characters.isChar(this.criterion))
        {
          localApplyToArgs2 = Scheme.applyToArgs;
          localLocation2 = srfi13.loc$char$Mnset;
        }
        try
        {
          Object localObject4 = localLocation2.get();
          localObject2 = localApplyToArgs2.apply2(localObject4, this.criterion);
        }
        catch (UnboundLocationException localUnboundLocationException2)
        {
          Object[] arrayOfObject;
          localUnboundLocationException2.setLine("srfi13.scm", 1125, 26);
          throw localUnboundLocationException2;
        }
        arrayOfObject = new Object[1];
        arrayOfObject[0] = this.criterion;
        localObject2 = misc.error$V("string-delete criterion not predicate, char or char-set", arrayOfObject);
      }
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 150)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 151)
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
  
  public class frame76
    extends ModuleBody
  {
    CharSequence ans;
    Object cset;
    final ModuleMethod lambda$Fn174;
    final ModuleMethod lambda$Fn175;
    final ModuleMethod lambda$Fn176;
    srfi13.frame75 staticLink;
    CharSequence temp;
    
    public frame76()
    {
      this$1 = new ModuleMethod(this, 147, null, 8194);
      this$1.setProperty("source-location", "srfi13.scm:1116");
      this.lambda$Fn174 = this$1;
      ModuleMethod localModuleMethod1 = new ModuleMethod(this, 148, null, 8194);
      localModuleMethod1.setProperty("source-location", "srfi13.scm:1128");
      this.lambda$Fn175 = localModuleMethod1;
      ModuleMethod localModuleMethod2 = new ModuleMethod(this, 149, null, 8194);
      localModuleMethod2.setProperty("source-location", "srfi13.scm:1133");
      this.lambda$Fn176 = localModuleMethod2;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply2(paramModuleMethod, paramObject1, paramObject2);
      case 147: 
        return lambda174(paramObject1, paramObject2);
      case 148: 
        return lambda175(paramObject1, paramObject2);
      }
      return lambda176(paramObject1, paramObject2);
    }
    
    /* Error */
    Object lambda174(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 70	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   3: aload_0
      //   4: getfield 72	gnu/kawa/slib/srfi13$frame76:staticLink	Lgnu/kawa/slib/srfi13$frame75;
      //   7: getfield 77	gnu/kawa/slib/srfi13$frame75:criterion	Ljava/lang/Object;
      //   10: aload_1
      //   11: invokevirtual 81	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   14: getstatic 87	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   17: if_acmpeq +52 -> 69
      //   20: aload_0
      //   21: getfield 89	gnu/kawa/slib/srfi13$frame76:temp	Ljava/lang/CharSequence;
      //   24: astore_3
      //   25: aload_3
      //   26: checkcast 91	gnu/lists/CharSeq
      //   29: astore 5
      //   31: aload_2
      //   32: checkcast 93	java/lang/Number
      //   35: invokevirtual 97	java/lang/Number:intValue	()I
      //   38: istore 7
      //   40: aload_1
      //   41: checkcast 99	gnu/text/Char
      //   44: invokevirtual 103	gnu/text/Char:charValue	()C
      //   47: istore 9
      //   49: aload 5
      //   51: iload 7
      //   53: iload 9
      //   55: invokestatic 109	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
      //   58: getstatic 115	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   61: aload_2
      //   62: getstatic 121	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   65: invokevirtual 81	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   68: astore_2
      //   69: aload_2
      //   70: areturn
      //   71: astore 4
      //   73: new 123	gnu/mapping/WrongType
      //   76: dup
      //   77: aload 4
      //   79: ldc 125
      //   81: iconst_1
      //   82: aload_3
      //   83: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   86: athrow
      //   87: astore 6
      //   89: new 123	gnu/mapping/WrongType
      //   92: dup
      //   93: aload 6
      //   95: ldc 125
      //   97: iconst_2
      //   98: aload_2
      //   99: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   102: athrow
      //   103: astore 8
      //   105: new 123	gnu/mapping/WrongType
      //   108: dup
      //   109: aload 8
      //   111: ldc 125
      //   113: iconst_3
      //   114: aload_1
      //   115: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   118: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	119	0	this	frame76
      //   0	119	1	paramObject1	Object
      //   0	119	2	paramObject2	Object
      //   24	59	3	localCharSequence	CharSequence
      //   71	7	4	localClassCastException1	ClassCastException
      //   29	21	5	localCharSeq	CharSeq
      //   87	7	6	localClassCastException2	ClassCastException
      //   38	14	7	i	int
      //   103	7	8	localClassCastException3	ClassCastException
      //   47	7	9	c	char
      // Exception table:
      //   from	to	target	type
      //   25	31	71	java/lang/ClassCastException
      //   31	40	87	java/lang/ClassCastException
      //   40	49	103	java/lang/ClassCastException
    }
    
    Object lambda175(Object paramObject1, Object paramObject2)
    {
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      Location localLocation = srfi13.loc$char$Mnset$Mncontains$Qu;
      try
      {
        Object localObject = localLocation.get();
        if (localApplyToArgs.apply3(localObject, this.cset, paramObject1) != Boolean.FALSE) {
          paramObject2 = AddOp.$Pl.apply2(paramObject2, srfi13.Lit1);
        }
        return paramObject2;
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("srfi13.scm", 1128, 45);
        throw localUnboundLocationException;
      }
    }
    
    /* Error */
    Object lambda176(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 70	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   3: astore_3
      //   4: getstatic 134	gnu/kawa/slib/srfi13:loc$char$Mnset$Mncontains$Qu	Lgnu/mapping/Location;
      //   7: astore 4
      //   9: aload 4
      //   11: invokevirtual 140	gnu/mapping/Location:get	()Ljava/lang/Object;
      //   14: astore 6
      //   16: aload_3
      //   17: aload 6
      //   19: aload_0
      //   20: getfield 142	gnu/kawa/slib/srfi13$frame76:cset	Ljava/lang/Object;
      //   23: aload_1
      //   24: invokevirtual 146	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   27: getstatic 87	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   30: if_acmpeq +54 -> 84
      //   33: aload_0
      //   34: getfield 154	gnu/kawa/slib/srfi13$frame76:ans	Ljava/lang/CharSequence;
      //   37: astore 7
      //   39: aload 7
      //   41: checkcast 91	gnu/lists/CharSeq
      //   44: astore 9
      //   46: aload_2
      //   47: checkcast 93	java/lang/Number
      //   50: invokevirtual 97	java/lang/Number:intValue	()I
      //   53: istore 11
      //   55: aload_1
      //   56: checkcast 99	gnu/text/Char
      //   59: invokevirtual 103	gnu/text/Char:charValue	()C
      //   62: istore 13
      //   64: aload 9
      //   66: iload 11
      //   68: iload 13
      //   70: invokestatic 109	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
      //   73: getstatic 115	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   76: aload_2
      //   77: getstatic 121	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   80: invokevirtual 81	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   83: astore_2
      //   84: aload_2
      //   85: areturn
      //   86: astore 5
      //   88: aload 5
      //   90: ldc 148
      //   92: sipush 1133
      //   95: bipush 35
      //   97: invokevirtual 152	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
      //   100: aload 5
      //   102: athrow
      //   103: astore 8
      //   105: new 123	gnu/mapping/WrongType
      //   108: dup
      //   109: aload 8
      //   111: ldc 125
      //   113: iconst_1
      //   114: aload 7
      //   116: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   119: athrow
      //   120: astore 10
      //   122: new 123	gnu/mapping/WrongType
      //   125: dup
      //   126: aload 10
      //   128: ldc 125
      //   130: iconst_2
      //   131: aload_2
      //   132: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   135: athrow
      //   136: astore 12
      //   138: new 123	gnu/mapping/WrongType
      //   141: dup
      //   142: aload 12
      //   144: ldc 125
      //   146: iconst_3
      //   147: aload_1
      //   148: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   151: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	152	0	this	frame76
      //   0	152	1	paramObject1	Object
      //   0	152	2	paramObject2	Object
      //   3	14	3	localApplyToArgs	ApplyToArgs
      //   7	3	4	localLocation	Location
      //   86	15	5	localUnboundLocationException	UnboundLocationException
      //   14	4	6	localObject	Object
      //   37	78	7	localCharSequence	CharSequence
      //   103	7	8	localClassCastException1	ClassCastException
      //   44	21	9	localCharSeq	CharSeq
      //   120	7	10	localClassCastException2	ClassCastException
      //   53	14	11	i	int
      //   136	7	12	localClassCastException3	ClassCastException
      //   62	7	13	c	char
      // Exception table:
      //   from	to	target	type
      //   9	16	86	gnu/mapping/UnboundLocationException
      //   39	46	103	java/lang/ClassCastException
      //   46	55	120	java/lang/ClassCastException
      //   55	64	136	java/lang/ClassCastException
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
      case 149: 
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      case 148: 
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
  }
  
  public class frame77
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn177 = new ModuleMethod(this, 152, null, 0);
    final ModuleMethod lambda$Fn178 = new ModuleMethod(this, 153, null, 8194);
    LList maybe$Mnstart$Plend;
    Object str;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 152) {
        return lambda177();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 153) {
        return lambda178(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda177()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnindex, this.str, this.maybe$Mnstart$Plend);
    }
    
    Object lambda178(Object paramObject1, Object paramObject2)
    {
      if (characters.isChar(this.criterion))
      {
        localObject2 = paramObject1;
        localObject10 = Scheme.numLss.apply2(localObject2, paramObject2);
      }
      for (;;)
      {
        Object localObject6;
        Object localObject5;
        for (;;)
        {
          Object localObject11;
          Object localObject12;
          try
          {
            bool3 = ((Boolean)localObject10).booleanValue();
            if (bool3) {
              localObject11 = this.criterion;
            }
          }
          catch (ClassCastException localClassCastException7)
          {
            boolean bool3;
            Char localChar;
            CharSequence localCharSequence3;
            int k;
            ApplyToArgs localApplyToArgs1;
            Location localLocation1;
            Object localObject1;
            boolean bool2;
            ApplyToArgs localApplyToArgs3;
            Location localLocation2;
            Object localObject7;
            Object localObject8;
            CharSequence localCharSequence2;
            int j;
            boolean bool1;
            ApplyToArgs localApplyToArgs2;
            Object localObject4;
            CharSequence localCharSequence1;
            int i;
            Object[] arrayOfObject;
            throw new WrongType(localClassCastException7, "x", -2, localObject10);
          }
          try
          {
            localChar = (Char)localObject11;
            localObject12 = this.str;
          }
          catch (ClassCastException localClassCastException8)
          {
            throw new WrongType(localClassCastException8, "char=?", 1, localObject11);
          }
          try
          {
            localCharSequence3 = (CharSequence)localObject12;
          }
          catch (ClassCastException localClassCastException9)
          {
            throw new WrongType(localClassCastException9, "string-ref", 1, localObject12);
          }
          try
          {
            k = ((Number)localObject2).intValue();
            if (characters.isChar$Eq(localChar, Char.make(strings.stringRef(localCharSequence3, k)))) {
              return localObject2;
            }
            localObject2 = AddOp.$Pl.apply2(localObject2, srfi13.Lit1);
          }
          catch (ClassCastException localClassCastException10)
          {
            throw new WrongType(localClassCastException10, "string-ref", 2, localObject2);
          }
        }
        if (bool3) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        localApplyToArgs1 = Scheme.applyToArgs;
        localLocation1 = srfi13.loc$char$Mnset$Qu;
        Object localObject9;
        try
        {
          localObject1 = localLocation1.get();
          if (localApplyToArgs1.apply2(localObject1, this.criterion) != Boolean.FALSE)
          {
            localObject2 = paramObject1;
            localObject6 = Scheme.numLss.apply2(localObject2, paramObject2);
          }
        }
        catch (UnboundLocationException localUnboundLocationException1)
        {
          localUnboundLocationException1.setLine("srfi13.scm", 1159, 5);
          throw localUnboundLocationException1;
        }
        try
        {
          bool2 = ((Boolean)localObject6).booleanValue();
          if (bool2)
          {
            localApplyToArgs3 = Scheme.applyToArgs;
            localLocation2 = srfi13.loc$char$Mnset$Mncontains$Qu;
          }
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "x", -2, localObject6);
        }
        try
        {
          localObject7 = localLocation2.get();
          localObject8 = this.criterion;
          localObject9 = this.str;
        }
        catch (UnboundLocationException localUnboundLocationException2)
        {
          localUnboundLocationException2.setLine("srfi13.scm", 1162, 9);
          throw localUnboundLocationException2;
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject9;
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "string-ref", 1, localObject9);
        }
        try
        {
          j = ((Number)localObject2).intValue();
          if (localApplyToArgs3.apply3(localObject7, localObject8, Char.make(strings.stringRef(localCharSequence2, j))) != Boolean.FALSE) {
            continue;
          }
          localObject2 = AddOp.$Pl.apply2(localObject2, srfi13.Lit1);
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "string-ref", 2, localObject2);
        }
        if (bool2) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        if (!misc.isProcedure(this.criterion)) {
          continue;
        }
        localObject2 = paramObject1;
        Object localObject3 = Scheme.numLss.apply2(localObject2, paramObject2);
        try
        {
          bool1 = ((Boolean)localObject3).booleanValue();
          if (bool1)
          {
            localApplyToArgs2 = Scheme.applyToArgs;
            localObject4 = this.criterion;
            localObject5 = this.str;
          }
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "x", -2, localObject3);
        }
        try
        {
          localCharSequence1 = (CharSequence)localObject5;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-ref", 1, localObject5);
        }
        try
        {
          i = ((Number)localObject2).intValue();
          if (localApplyToArgs2.apply2(localObject4, Char.make(strings.stringRef(localCharSequence1, i))) == Boolean.FALSE) {
            localObject2 = AddOp.$Pl.apply2(localObject2, srfi13.Lit1);
          }
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 2, localObject2);
        }
      }
      if (bool1) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
      arrayOfObject = new Object[2];
      arrayOfObject[0] = srfi13.string$Mnindex;
      arrayOfObject[1] = this.criterion;
      return misc.error$V("Second param is neither char-set, char, or predicate procedure.", arrayOfObject);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 152)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 153)
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
  
  public class frame78
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn179 = new ModuleMethod(this, 154, null, 0);
    final ModuleMethod lambda$Fn180 = new ModuleMethod(this, 155, null, 8194);
    LList maybe$Mnstart$Plend;
    Object str;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 154) {
        return lambda179();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 155) {
        return lambda180(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda179()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnindex$Mnright, this.str, this.maybe$Mnstart$Plend);
    }
    
    Object lambda180(Object paramObject1, Object paramObject2)
    {
      if (characters.isChar(this.criterion))
      {
        localObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
        localObject10 = Scheme.numGEq.apply2(localObject2, paramObject1);
      }
      for (;;)
      {
        Object localObject6;
        Object localObject5;
        for (;;)
        {
          Object localObject11;
          Object localObject12;
          try
          {
            bool3 = ((Boolean)localObject10).booleanValue();
            if (bool3) {
              localObject11 = this.criterion;
            }
          }
          catch (ClassCastException localClassCastException7)
          {
            boolean bool3;
            Char localChar;
            CharSequence localCharSequence3;
            int k;
            ApplyToArgs localApplyToArgs1;
            Location localLocation1;
            Object localObject1;
            boolean bool2;
            ApplyToArgs localApplyToArgs3;
            Location localLocation2;
            Object localObject7;
            Object localObject8;
            CharSequence localCharSequence2;
            int j;
            boolean bool1;
            ApplyToArgs localApplyToArgs2;
            Object localObject4;
            CharSequence localCharSequence1;
            int i;
            Object[] arrayOfObject;
            throw new WrongType(localClassCastException7, "x", -2, localObject10);
          }
          try
          {
            localChar = (Char)localObject11;
            localObject12 = this.str;
          }
          catch (ClassCastException localClassCastException8)
          {
            throw new WrongType(localClassCastException8, "char=?", 1, localObject11);
          }
          try
          {
            localCharSequence3 = (CharSequence)localObject12;
          }
          catch (ClassCastException localClassCastException9)
          {
            throw new WrongType(localClassCastException9, "string-ref", 1, localObject12);
          }
          try
          {
            k = ((Number)localObject2).intValue();
            if (characters.isChar$Eq(localChar, Char.make(strings.stringRef(localCharSequence3, k)))) {
              return localObject2;
            }
            localObject2 = AddOp.$Mn.apply2(localObject2, srfi13.Lit1);
          }
          catch (ClassCastException localClassCastException10)
          {
            throw new WrongType(localClassCastException10, "string-ref", 2, localObject2);
          }
        }
        if (bool3) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        localApplyToArgs1 = Scheme.applyToArgs;
        localLocation1 = srfi13.loc$char$Mnset$Qu;
        Object localObject9;
        try
        {
          localObject1 = localLocation1.get();
          if (localApplyToArgs1.apply2(localObject1, this.criterion) != Boolean.FALSE)
          {
            localObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
            localObject6 = Scheme.numGEq.apply2(localObject2, paramObject1);
          }
        }
        catch (UnboundLocationException localUnboundLocationException1)
        {
          localUnboundLocationException1.setLine("srfi13.scm", 1179, 5);
          throw localUnboundLocationException1;
        }
        try
        {
          bool2 = ((Boolean)localObject6).booleanValue();
          if (bool2)
          {
            localApplyToArgs3 = Scheme.applyToArgs;
            localLocation2 = srfi13.loc$char$Mnset$Mncontains$Qu;
          }
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "x", -2, localObject6);
        }
        try
        {
          localObject7 = localLocation2.get();
          localObject8 = this.criterion;
          localObject9 = this.str;
        }
        catch (UnboundLocationException localUnboundLocationException2)
        {
          localUnboundLocationException2.setLine("srfi13.scm", 1182, 9);
          throw localUnboundLocationException2;
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject9;
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "string-ref", 1, localObject9);
        }
        try
        {
          j = ((Number)localObject2).intValue();
          if (localApplyToArgs3.apply3(localObject7, localObject8, Char.make(strings.stringRef(localCharSequence2, j))) != Boolean.FALSE) {
            continue;
          }
          localObject2 = AddOp.$Mn.apply2(localObject2, srfi13.Lit1);
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "string-ref", 2, localObject2);
        }
        if (bool2) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        if (!misc.isProcedure(this.criterion)) {
          continue;
        }
        localObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
        Object localObject3 = Scheme.numGEq.apply2(localObject2, paramObject1);
        try
        {
          bool1 = ((Boolean)localObject3).booleanValue();
          if (bool1)
          {
            localApplyToArgs2 = Scheme.applyToArgs;
            localObject4 = this.criterion;
            localObject5 = this.str;
          }
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "x", -2, localObject3);
        }
        try
        {
          localCharSequence1 = (CharSequence)localObject5;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-ref", 1, localObject5);
        }
        try
        {
          i = ((Number)localObject2).intValue();
          if (localApplyToArgs2.apply2(localObject4, Char.make(strings.stringRef(localCharSequence1, i))) == Boolean.FALSE) {
            localObject2 = AddOp.$Mn.apply2(localObject2, srfi13.Lit1);
          }
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 2, localObject2);
        }
      }
      if (bool1) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
      arrayOfObject = new Object[2];
      arrayOfObject[0] = srfi13.string$Mnindex$Mnright;
      arrayOfObject[1] = this.criterion;
      return misc.error$V("Second param is neither char-set, char, or predicate procedure.", arrayOfObject);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 154)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 155)
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
  
  public class frame79
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn181 = new ModuleMethod(this, 156, null, 0);
    final ModuleMethod lambda$Fn182 = new ModuleMethod(this, 157, null, 8194);
    LList maybe$Mnstart$Plend;
    Object str;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 156) {
        return lambda181();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 157) {
        return lambda182(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda181()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnskip, this.str, this.maybe$Mnstart$Plend);
    }
    
    Object lambda182(Object paramObject1, Object paramObject2)
    {
      if (characters.isChar(this.criterion))
      {
        localObject2 = paramObject1;
        localObject10 = Scheme.numLss.apply2(localObject2, paramObject2);
      }
      for (;;)
      {
        Object localObject6;
        Object localObject5;
        for (;;)
        {
          Object localObject11;
          Object localObject12;
          try
          {
            bool3 = ((Boolean)localObject10).booleanValue();
            if (bool3) {
              localObject11 = this.criterion;
            }
          }
          catch (ClassCastException localClassCastException7)
          {
            boolean bool3;
            Char localChar;
            CharSequence localCharSequence3;
            int k;
            ApplyToArgs localApplyToArgs1;
            Location localLocation1;
            Object localObject1;
            boolean bool2;
            ApplyToArgs localApplyToArgs3;
            Location localLocation2;
            Object localObject7;
            Object localObject8;
            CharSequence localCharSequence2;
            int j;
            boolean bool1;
            ApplyToArgs localApplyToArgs2;
            Object localObject4;
            CharSequence localCharSequence1;
            int i;
            Object[] arrayOfObject;
            throw new WrongType(localClassCastException7, "x", -2, localObject10);
          }
          try
          {
            localChar = (Char)localObject11;
            localObject12 = this.str;
          }
          catch (ClassCastException localClassCastException8)
          {
            throw new WrongType(localClassCastException8, "char=?", 1, localObject11);
          }
          try
          {
            localCharSequence3 = (CharSequence)localObject12;
          }
          catch (ClassCastException localClassCastException9)
          {
            throw new WrongType(localClassCastException9, "string-ref", 1, localObject12);
          }
          try
          {
            k = ((Number)localObject2).intValue();
            if (characters.isChar$Eq(localChar, Char.make(strings.stringRef(localCharSequence3, k))))
            {
              localObject2 = AddOp.$Pl.apply2(localObject2, srfi13.Lit1);
              break;
              if (!bool3) {
                continue;
              }
              localObject2 = Boolean.TRUE;
            }
            return localObject2;
            return Boolean.FALSE;
          }
          catch (ClassCastException localClassCastException10)
          {
            throw new WrongType(localClassCastException10, "string-ref", 2, localObject2);
          }
        }
        localApplyToArgs1 = Scheme.applyToArgs;
        localLocation1 = srfi13.loc$char$Mnset$Qu;
        Object localObject9;
        try
        {
          localObject1 = localLocation1.get();
          if (localApplyToArgs1.apply2(localObject1, this.criterion) != Boolean.FALSE)
          {
            localObject2 = paramObject1;
            localObject6 = Scheme.numLss.apply2(localObject2, paramObject2);
          }
        }
        catch (UnboundLocationException localUnboundLocationException1)
        {
          localUnboundLocationException1.setLine("srfi13.scm", 1200, 5);
          throw localUnboundLocationException1;
        }
        try
        {
          bool2 = ((Boolean)localObject6).booleanValue();
          if (bool2)
          {
            localApplyToArgs3 = Scheme.applyToArgs;
            localLocation2 = srfi13.loc$char$Mnset$Mncontains$Qu;
          }
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "x", -2, localObject6);
        }
        try
        {
          localObject7 = localLocation2.get();
          localObject8 = this.criterion;
          localObject9 = this.str;
        }
        catch (UnboundLocationException localUnboundLocationException2)
        {
          localUnboundLocationException2.setLine("srfi13.scm", 1203, 9);
          throw localUnboundLocationException2;
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject9;
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "string-ref", 1, localObject9);
        }
        try
        {
          j = ((Number)localObject2).intValue();
          if (localApplyToArgs3.apply3(localObject7, localObject8, Char.make(strings.stringRef(localCharSequence2, j))) == Boolean.FALSE) {
            continue;
          }
          localObject2 = AddOp.$Pl.apply2(localObject2, srfi13.Lit1);
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "string-ref", 2, localObject2);
        }
        if (bool2) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        if (!misc.isProcedure(this.criterion)) {
          continue;
        }
        localObject2 = paramObject1;
        Object localObject3 = Scheme.numLss.apply2(localObject2, paramObject2);
        try
        {
          bool1 = ((Boolean)localObject3).booleanValue();
          if (bool1)
          {
            localApplyToArgs2 = Scheme.applyToArgs;
            localObject4 = this.criterion;
            localObject5 = this.str;
          }
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "x", -2, localObject3);
        }
        try
        {
          localCharSequence1 = (CharSequence)localObject5;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-ref", 1, localObject5);
        }
        try
        {
          i = ((Number)localObject2).intValue();
          if (localApplyToArgs2.apply2(localObject4, Char.make(strings.stringRef(localCharSequence1, i))) != Boolean.FALSE) {
            localObject2 = AddOp.$Pl.apply2(localObject2, srfi13.Lit1);
          }
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 2, localObject2);
        }
      }
      if (bool1) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
      arrayOfObject = new Object[2];
      arrayOfObject[0] = srfi13.string$Mnskip;
      arrayOfObject[1] = this.criterion;
      return misc.error$V("Second param is neither char-set, char, or predicate procedure.", arrayOfObject);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 156)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 157)
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
  
  public class frame8
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn21 = new ModuleMethod(this, 18, null, 0);
    final ModuleMethod lambda$Fn22 = new ModuleMethod(this, 19, null, 8194);
    LList maybe$Mnstart$Plend;
    Object proc;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 18) {
        return lambda21();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 19) {
        return lambda22(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda21()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnfor$Mneach$Mnindex, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda22(Object paramObject1, Object paramObject2)
    {
      for (Object localObject = paramObject1; Scheme.numLss.apply2(localObject, paramObject2) != Boolean.FALSE; localObject = AddOp.$Pl.apply2(localObject, srfi13.Lit1)) {
        Scheme.applyToArgs.apply2(this.proc, localObject);
      }
      return Values.empty;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 18)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 19)
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
  
  public class frame80
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn183 = new ModuleMethod(this, 158, null, 0);
    final ModuleMethod lambda$Fn184 = new ModuleMethod(this, 159, null, 8194);
    LList maybe$Mnstart$Plend;
    Object str;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 158) {
        return lambda183();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 159) {
        return lambda184(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda183()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnskip$Mnright, this.str, this.maybe$Mnstart$Plend);
    }
    
    Object lambda184(Object paramObject1, Object paramObject2)
    {
      if (characters.isChar(this.criterion))
      {
        localObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
        localObject10 = Scheme.numGEq.apply2(localObject2, paramObject1);
      }
      for (;;)
      {
        Object localObject6;
        Object localObject5;
        for (;;)
        {
          Object localObject11;
          Object localObject12;
          try
          {
            bool3 = ((Boolean)localObject10).booleanValue();
            if (bool3) {
              localObject11 = this.criterion;
            }
          }
          catch (ClassCastException localClassCastException7)
          {
            boolean bool3;
            Char localChar;
            CharSequence localCharSequence3;
            int k;
            ApplyToArgs localApplyToArgs1;
            Location localLocation1;
            Object localObject1;
            boolean bool2;
            ApplyToArgs localApplyToArgs3;
            Location localLocation2;
            Object localObject7;
            Object localObject8;
            CharSequence localCharSequence2;
            int j;
            boolean bool1;
            ApplyToArgs localApplyToArgs2;
            Object localObject4;
            CharSequence localCharSequence1;
            int i;
            Object[] arrayOfObject;
            throw new WrongType(localClassCastException7, "x", -2, localObject10);
          }
          try
          {
            localChar = (Char)localObject11;
            localObject12 = this.str;
          }
          catch (ClassCastException localClassCastException8)
          {
            throw new WrongType(localClassCastException8, "char=?", 1, localObject11);
          }
          try
          {
            localCharSequence3 = (CharSequence)localObject12;
          }
          catch (ClassCastException localClassCastException9)
          {
            throw new WrongType(localClassCastException9, "string-ref", 1, localObject12);
          }
          try
          {
            k = ((Number)localObject2).intValue();
            if (characters.isChar$Eq(localChar, Char.make(strings.stringRef(localCharSequence3, k))))
            {
              localObject2 = AddOp.$Mn.apply2(localObject2, srfi13.Lit1);
              break;
              if (!bool3) {
                continue;
              }
              localObject2 = Boolean.TRUE;
            }
            return localObject2;
            return Boolean.FALSE;
          }
          catch (ClassCastException localClassCastException10)
          {
            throw new WrongType(localClassCastException10, "string-ref", 2, localObject2);
          }
        }
        localApplyToArgs1 = Scheme.applyToArgs;
        localLocation1 = srfi13.loc$char$Mnset$Qu;
        Object localObject9;
        try
        {
          localObject1 = localLocation1.get();
          if (localApplyToArgs1.apply2(localObject1, this.criterion) != Boolean.FALSE)
          {
            localObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
            localObject6 = Scheme.numGEq.apply2(localObject2, paramObject1);
          }
        }
        catch (UnboundLocationException localUnboundLocationException1)
        {
          localUnboundLocationException1.setLine("srfi13.scm", 1222, 5);
          throw localUnboundLocationException1;
        }
        try
        {
          bool2 = ((Boolean)localObject6).booleanValue();
          if (bool2)
          {
            localApplyToArgs3 = Scheme.applyToArgs;
            localLocation2 = srfi13.loc$char$Mnset$Mncontains$Qu;
          }
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "x", -2, localObject6);
        }
        try
        {
          localObject7 = localLocation2.get();
          localObject8 = this.criterion;
          localObject9 = this.str;
        }
        catch (UnboundLocationException localUnboundLocationException2)
        {
          localUnboundLocationException2.setLine("srfi13.scm", 1225, 9);
          throw localUnboundLocationException2;
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject9;
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "string-ref", 1, localObject9);
        }
        try
        {
          j = ((Number)localObject2).intValue();
          if (localApplyToArgs3.apply3(localObject7, localObject8, Char.make(strings.stringRef(localCharSequence2, j))) == Boolean.FALSE) {
            continue;
          }
          localObject2 = AddOp.$Mn.apply2(localObject2, srfi13.Lit1);
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "string-ref", 2, localObject2);
        }
        if (bool2) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        if (!misc.isProcedure(this.criterion)) {
          continue;
        }
        localObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
        Object localObject3 = Scheme.numGEq.apply2(localObject2, paramObject1);
        try
        {
          bool1 = ((Boolean)localObject3).booleanValue();
          if (bool1)
          {
            localApplyToArgs2 = Scheme.applyToArgs;
            localObject4 = this.criterion;
            localObject5 = this.str;
          }
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "x", -2, localObject3);
        }
        try
        {
          localCharSequence1 = (CharSequence)localObject5;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-ref", 1, localObject5);
        }
        try
        {
          i = ((Number)localObject2).intValue();
          if (localApplyToArgs2.apply2(localObject4, Char.make(strings.stringRef(localCharSequence1, i))) != Boolean.FALSE) {
            localObject2 = AddOp.$Mn.apply2(localObject2, srfi13.Lit1);
          }
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 2, localObject2);
        }
      }
      if (bool1) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
      arrayOfObject = new Object[2];
      arrayOfObject[0] = srfi13.string$Mnskip$Mnright;
      arrayOfObject[1] = this.criterion;
      return misc.error$V("CRITERION param is neither char-set or char.", arrayOfObject);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 158)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 159)
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
  
  public class frame81
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn185 = new ModuleMethod(this, 160, null, 0);
    final ModuleMethod lambda$Fn186 = new ModuleMethod(this, 161, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 160) {
        return lambda185();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 161) {
        return lambda186(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda185()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncount, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda186(Object paramObject1, Object paramObject2)
    {
      if (characters.isChar(this.criterion))
      {
        localObject2 = srfi13.Lit0;
        localObject12 = paramObject1;
      }
      for (;;)
      {
        if (Scheme.numGEq.apply2(localObject12, paramObject2) != Boolean.FALSE) {
          break label432;
        }
        Object localObject13 = AddOp.$Pl.apply2(localObject12, srfi13.Lit1);
        Object localObject14 = this.criterion;
        Object localObject15;
        try
        {
          localChar = (Char)localObject14;
          localObject15 = this.s;
        }
        catch (ClassCastException localClassCastException5)
        {
          Char localChar;
          CharSequence localCharSequence3;
          int k;
          ApplyToArgs localApplyToArgs1;
          Location localLocation1;
          throw new WrongType(localClassCastException5, "char=?", 1, localObject14);
        }
        try
        {
          localCharSequence3 = (CharSequence)localObject15;
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "string-ref", 1, localObject15);
        }
        try
        {
          k = ((Number)localObject12).intValue();
          if (characters.isChar$Eq(localChar, Char.make(strings.stringRef(localCharSequence3, k)))) {
            localObject2 = AddOp.$Pl.apply2(localObject2, srfi13.Lit1);
          }
          localObject12 = localObject13;
        }
        catch (ClassCastException localClassCastException7)
        {
          throw new WrongType(localClassCastException7, "string-ref", 2, localObject12);
        }
      }
      localApplyToArgs1 = Scheme.applyToArgs;
      localLocation1 = srfi13.loc$char$Mnset$Qu;
      for (;;)
      {
        Object localObject7;
        Object localObject11;
        try
        {
          Object localObject1 = localLocation1.get();
          if (localApplyToArgs1.apply2(localObject1, this.criterion) != Boolean.FALSE)
          {
            localObject2 = srfi13.Lit0;
            localObject7 = paramObject1;
            if (Scheme.numGEq.apply2(localObject7, paramObject2) != Boolean.FALSE) {
              continue;
            }
            localObject8 = AddOp.$Pl.apply2(localObject7, srfi13.Lit1);
            localApplyToArgs3 = Scheme.applyToArgs;
            localLocation2 = srfi13.loc$char$Mnset$Mncontains$Qu;
          }
        }
        catch (UnboundLocationException localUnboundLocationException1)
        {
          Object localObject8;
          ApplyToArgs localApplyToArgs3;
          Location localLocation2;
          Object localObject9;
          Object localObject10;
          CharSequence localCharSequence2;
          int j;
          localUnboundLocationException1.setLine("srfi13.scm", 1246, 5);
          throw localUnboundLocationException1;
        }
        try
        {
          localObject9 = localLocation2.get();
          localObject10 = this.criterion;
          localObject11 = this.s;
        }
        catch (UnboundLocationException localUnboundLocationException2)
        {
          localUnboundLocationException2.setLine("srfi13.scm", 1248, 16);
          throw localUnboundLocationException2;
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject11;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 1, localObject11);
        }
        try
        {
          j = ((Number)localObject7).intValue();
          if (localApplyToArgs3.apply3(localObject9, localObject10, Char.make(strings.stringRef(localCharSequence2, j))) != Boolean.FALSE) {
            localObject2 = AddOp.$Pl.apply2(localObject2, srfi13.Lit1);
          }
          localObject7 = localObject8;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "string-ref", 2, localObject7);
        }
      }
      if (misc.isProcedure(this.criterion))
      {
        localObject2 = srfi13.Lit0;
        localObject3 = paramObject1;
      }
      for (;;)
      {
        if (Scheme.numGEq.apply2(localObject3, paramObject2) != Boolean.FALSE) {
          break label432;
        }
        Object localObject4 = AddOp.$Pl.apply2(localObject3, srfi13.Lit1);
        ApplyToArgs localApplyToArgs2 = Scheme.applyToArgs;
        Object localObject5 = this.criterion;
        Object localObject6 = this.s;
        try
        {
          localCharSequence1 = (CharSequence)localObject6;
        }
        catch (ClassCastException localClassCastException1)
        {
          CharSequence localCharSequence1;
          int i;
          Object[] arrayOfObject;
          throw new WrongType(localClassCastException1, "string-ref", 1, localObject6);
        }
        try
        {
          i = ((Number)localObject3).intValue();
          if (localApplyToArgs2.apply2(localObject5, Char.make(strings.stringRef(localCharSequence1, i))) != Boolean.FALSE) {
            localObject2 = AddOp.$Pl.apply2(localObject2, srfi13.Lit1);
          }
          localObject3 = localObject4;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-ref", 2, localObject3);
        }
      }
      arrayOfObject = new Object[2];
      arrayOfObject[0] = srfi13.string$Mncount;
      arrayOfObject[1] = this.criterion;
      Object localObject2 = misc.error$V("CRITERION param is neither char-set or char.", arrayOfObject);
      label432:
      return localObject2;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 160)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 161)
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
  
  public class frame82
    extends ModuleBody
  {
    Object jdField_char;
    final ModuleMethod lambda$Fn187 = new ModuleMethod(this, 162, null, 0);
    final ModuleMethod lambda$Fn188 = new ModuleMethod(this, 163, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 162) {
        return lambda187();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 163) {
        return lambda188(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda187()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnfill$Ex, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda188(Object paramObject1, Object paramObject2)
    {
      localObject1 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
      for (;;)
      {
        Object localObject2;
        if (Scheme.numLss.apply2(localObject1, paramObject1) == Boolean.FALSE) {
          localObject2 = this.s;
        }
        Object localObject3;
        try
        {
          localCharSeq = (CharSeq)localObject2;
        }
        catch (ClassCastException localClassCastException1)
        {
          CharSeq localCharSeq;
          int i;
          char c;
          throw new WrongType(localClassCastException1, "string-set!", 1, localObject2);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          localObject3 = this.jdField_char;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-set!", 2, localObject1);
        }
        try
        {
          c = ((Char)localObject3).charValue();
          strings.stringSet$Ex(localCharSeq, i, c);
          localObject1 = AddOp.$Mn.apply2(localObject1, srfi13.Lit1);
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-set!", 3, localObject3);
        }
      }
      return Values.empty;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 162)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 163)
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
  
  public class frame83
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn189 = new ModuleMethod(this, 166, null, 0);
    final ModuleMethod lambda$Fn190 = new ModuleMethod(this, 167, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object pattern;
    Object text;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 166) {
        return lambda189();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 167) {
        return lambda190(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda189()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mncontains, this.text, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda190(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame84 localframe84 = new srfi13.frame84();
      localframe84.staticLink = this;
      localframe84.rest = paramObject1;
      localframe84.t$Mnstart = paramObject2;
      localframe84.t$Mnend = paramObject3;
      return call_with_values.callWithValues(localframe84.lambda$Fn191, localframe84.lambda$Fn192);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 166)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 167)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame84
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn191 = new ModuleMethod(this, 164, null, 0);
    final ModuleMethod lambda$Fn192 = new ModuleMethod(this, 165, null, 8194);
    Object rest;
    srfi13.frame83 staticLink;
    Object t$Mnend;
    Object t$Mnstart;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 164) {
        return lambda191();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 165) {
        return lambda192(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda191()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncontains, this.staticLink.pattern, this.rest);
    }
    
    Object lambda192(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcKmpSearch(this.staticLink.pattern, this.staticLink.text, characters.char$Eq$Qu, paramObject1, paramObject2, this.t$Mnstart, this.t$Mnend);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 164)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 165)
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
  
  public class frame85
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn193 = new ModuleMethod(this, 170, null, 0);
    final ModuleMethod lambda$Fn194 = new ModuleMethod(this, 171, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object pattern;
    Object text;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 170) {
        return lambda193();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 171) {
        return lambda194(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda193()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mncontains$Mnci, this.text, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda194(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame86 localframe86 = new srfi13.frame86();
      localframe86.staticLink = this;
      localframe86.rest = paramObject1;
      localframe86.t$Mnstart = paramObject2;
      localframe86.t$Mnend = paramObject3;
      return call_with_values.callWithValues(localframe86.lambda$Fn195, localframe86.lambda$Fn196);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 170)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 171)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame86
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn195 = new ModuleMethod(this, 168, null, 0);
    final ModuleMethod lambda$Fn196 = new ModuleMethod(this, 169, null, 8194);
    Object rest;
    srfi13.frame85 staticLink;
    Object t$Mnend;
    Object t$Mnstart;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 168) {
        return lambda195();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 169) {
        return lambda196(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda195()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncontains$Mnci, this.staticLink.pattern, this.rest);
    }
    
    Object lambda196(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcKmpSearch(this.staticLink.pattern, this.staticLink.text, unicode.char$Mnci$Eq$Qu, paramObject1, paramObject2, this.t$Mnstart, this.t$Mnend);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 168)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 169)
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
  
  public class frame87
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn197;
    Object pattern;
    
    public frame87()
    {
      this$1 = new ModuleMethod(this, 172, null, 4097);
      this$1.setProperty("source-location", "srfi13.scm:1399");
      this.lambda$Fn197 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 172) {
        return lambda197(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda197(Object paramObject)
    {
      return srfi13.stringParseStart$PlEnd(srfi13.make$Mnkmp$Mnrestart$Mnvector, this.pattern, paramObject);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 172)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame88
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn198;
    final ModuleMethod lambda$Fn199;
    int patlen;
    Object s;
    
    public frame88()
    {
      this$1 = new ModuleMethod(this, 173, null, 4097);
      this$1.setProperty("source-location", "srfi13.scm:1468");
      this.lambda$Fn198 = this$1;
      ModuleMethod localModuleMethod = new ModuleMethod(this, 174, null, 4097);
      localModuleMethod.setProperty("source-location", "srfi13.scm:1472");
      this.lambda$Fn199 = localModuleMethod;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply1(paramModuleMethod, paramObject);
      case 173: 
        return lambda198(paramObject);
      }
      if (lambda199(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    
    Object lambda198(Object paramObject)
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnkmp$Mnpartial$Mnsearch, this.s, paramObject);
    }
    
    boolean lambda199(Object paramObject)
    {
      boolean bool1 = numbers.isInteger(paramObject);
      Object localObject;
      if (bool1)
      {
        bool1 = numbers.isExact(paramObject);
        if (bool1) {
          localObject = Scheme.numLEq.apply2(srfi13.Lit0, paramObject);
        }
      }
      try
      {
        boolean bool2 = ((Boolean)localObject).booleanValue();
        bool1 = bool2;
        if (bool1) {
          bool1 = ((Boolean)Scheme.numLss.apply2(paramObject, Integer.valueOf(this.patlen))).booleanValue();
        }
        return bool1;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "x", -2, localObject);
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match1(paramModuleMethod, paramObject, paramCallContext);
      case 174: 
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
  
  public class frame89
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn200 = new ModuleMethod(this, 175, null, 0);
    final ModuleMethod lambda$Fn201 = new ModuleMethod(this, 176, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 175) {
        return lambda200();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 176) {
        return lambda201(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda200()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnreverse, this.s, this.maybe$Mnstart$Plend);
    }
    
    /* Error */
    CharSequence lambda201(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 65	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   3: aload_2
      //   4: aload_1
      //   5: invokevirtual 70	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   8: astore_3
      //   9: aload_3
      //   10: checkcast 72	java/lang/Number
      //   13: invokevirtual 76	java/lang/Number:intValue	()I
      //   16: istore 5
      //   18: iload 5
      //   20: invokestatic 82	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
      //   23: astore 6
      //   25: getstatic 65	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   28: aload_3
      //   29: getstatic 86	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   32: invokevirtual 70	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   35: astore 7
      //   37: aload_1
      //   38: astore 8
      //   40: getstatic 92	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   43: aload 7
      //   45: getstatic 95	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
      //   48: invokevirtual 70	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   51: getstatic 101	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   54: if_acmpne +170 -> 224
      //   57: aload 6
      //   59: checkcast 103	gnu/lists/CharSeq
      //   62: astore 10
      //   64: aload 7
      //   66: checkcast 72	java/lang/Number
      //   69: invokevirtual 76	java/lang/Number:intValue	()I
      //   72: istore 12
      //   74: aload_0
      //   75: getfield 51	gnu/kawa/slib/srfi13$frame89:s	Ljava/lang/Object;
      //   78: astore 13
      //   80: aload 13
      //   82: checkcast 105	java/lang/CharSequence
      //   85: astore 15
      //   87: aload 8
      //   89: checkcast 72	java/lang/Number
      //   92: invokevirtual 76	java/lang/Number:intValue	()I
      //   95: istore 17
      //   97: aload 10
      //   99: iload 12
      //   101: aload 15
      //   103: iload 17
      //   105: invokestatic 109	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   108: invokestatic 113	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
      //   111: getstatic 116	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   114: aload 8
      //   116: getstatic 86	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   119: invokevirtual 70	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   122: astore 8
      //   124: getstatic 65	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   127: aload 7
      //   129: getstatic 86	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   132: invokevirtual 70	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   135: astore 7
      //   137: goto -97 -> 40
      //   140: astore 4
      //   142: new 118	gnu/mapping/WrongType
      //   145: dup
      //   146: aload 4
      //   148: ldc 120
      //   150: iconst_1
      //   151: aload_3
      //   152: invokespecial 123	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   155: athrow
      //   156: astore 9
      //   158: new 118	gnu/mapping/WrongType
      //   161: dup
      //   162: aload 9
      //   164: ldc 125
      //   166: iconst_1
      //   167: aload 6
      //   169: invokespecial 123	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   172: athrow
      //   173: astore 11
      //   175: new 118	gnu/mapping/WrongType
      //   178: dup
      //   179: aload 11
      //   181: ldc 125
      //   183: iconst_2
      //   184: aload 7
      //   186: invokespecial 123	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   189: athrow
      //   190: astore 14
      //   192: new 118	gnu/mapping/WrongType
      //   195: dup
      //   196: aload 14
      //   198: ldc 127
      //   200: iconst_1
      //   201: aload 13
      //   203: invokespecial 123	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   206: athrow
      //   207: astore 16
      //   209: new 118	gnu/mapping/WrongType
      //   212: dup
      //   213: aload 16
      //   215: ldc 127
      //   217: iconst_2
      //   218: aload 8
      //   220: invokespecial 123	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   223: athrow
      //   224: aload 6
      //   226: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	227	0	this	frame89
      //   0	227	1	paramObject1	Object
      //   0	227	2	paramObject2	Object
      //   8	144	3	localObject1	Object
      //   140	7	4	localClassCastException1	ClassCastException
      //   16	3	5	i	int
      //   23	202	6	localCharSequence1	CharSequence
      //   35	150	7	localObject2	Object
      //   38	181	8	localObject3	Object
      //   156	7	9	localClassCastException2	ClassCastException
      //   62	36	10	localCharSeq	CharSeq
      //   173	7	11	localClassCastException3	ClassCastException
      //   72	28	12	j	int
      //   78	124	13	localObject4	Object
      //   190	7	14	localClassCastException4	ClassCastException
      //   85	17	15	localCharSequence2	CharSequence
      //   207	7	16	localClassCastException5	ClassCastException
      //   95	9	17	k	int
      // Exception table:
      //   from	to	target	type
      //   9	18	140	java/lang/ClassCastException
      //   57	64	156	java/lang/ClassCastException
      //   64	74	173	java/lang/ClassCastException
      //   80	87	190	java/lang/ClassCastException
      //   87	97	207	java/lang/ClassCastException
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 175)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 176)
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
  
  public class frame9
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn23 = new ModuleMethod(this, 20, null, 0);
    final ModuleMethod lambda$Fn24 = new ModuleMethod(this, 21, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 20) {
        return lambda23();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 21) {
        return lambda24(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda23()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnevery, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda24(Object paramObject1, Object paramObject2)
    {
      if (characters.isChar(this.criterion)) {
        localObject13 = paramObject1;
      }
      for (;;)
      {
        Object localObject14 = Scheme.numGEq.apply2(localObject13, paramObject2);
        Object localObject15;
        Object localObject16;
        try
        {
          boolean bool3 = ((Boolean)localObject14).booleanValue();
          if (bool3)
          {
            if (bool3) {
              return Boolean.TRUE;
            }
            return Boolean.FALSE;
          }
          localObject15 = this.criterion;
        }
        catch (ClassCastException localClassCastException7)
        {
          Char localChar;
          CharSequence localCharSequence3;
          int m;
          boolean bool4;
          ApplyToArgs localApplyToArgs1;
          Location localLocation1;
          throw new WrongType(localClassCastException7, "x", -2, localObject14);
        }
        try
        {
          localChar = (Char)localObject15;
          localObject16 = this.s;
        }
        catch (ClassCastException localClassCastException8)
        {
          throw new WrongType(localClassCastException8, "char=?", 1, localObject15);
        }
        try
        {
          localCharSequence3 = (CharSequence)localObject16;
        }
        catch (ClassCastException localClassCastException9)
        {
          throw new WrongType(localClassCastException9, "string-ref", 1, localObject16);
        }
        try
        {
          m = ((Number)localObject13).intValue();
          bool4 = characters.isChar$Eq(localChar, Char.make(strings.stringRef(localCharSequence3, m)));
          if (bool4)
          {
            localObject13 = AddOp.$Pl.apply2(localObject13, srfi13.Lit1);
          }
          else
          {
            if (bool4) {
              return Boolean.TRUE;
            }
            return Boolean.FALSE;
          }
        }
        catch (ClassCastException localClassCastException10)
        {
          throw new WrongType(localClassCastException10, "string-ref", 2, localObject13);
        }
      }
      localApplyToArgs1 = Scheme.applyToArgs;
      localLocation1 = srfi13.loc$char$Mnset$Qu;
      for (;;)
      {
        Object localObject7;
        Object localObject8;
        Object localObject11;
        try
        {
          Object localObject1 = localLocation1.get();
          if (localApplyToArgs1.apply2(localObject1, this.criterion) != Boolean.FALSE)
          {
            localObject7 = paramObject1;
            localObject8 = Scheme.numGEq.apply2(localObject7, paramObject2);
          }
        }
        catch (UnboundLocationException localUnboundLocationException1)
        {
          boolean bool2;
          ApplyToArgs localApplyToArgs2;
          Location localLocation2;
          Object localObject9;
          Object localObject10;
          CharSequence localCharSequence2;
          int k;
          Object localObject12;
          localUnboundLocationException1.setLine("srfi13.scm", 489, 5);
          throw localUnboundLocationException1;
        }
        try
        {
          bool2 = ((Boolean)localObject8).booleanValue();
          if (bool2)
          {
            if (bool2) {
              return Boolean.TRUE;
            }
            return Boolean.FALSE;
          }
          localApplyToArgs2 = Scheme.applyToArgs;
          localLocation2 = srfi13.loc$char$Mnset$Mncontains$Qu;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "x", -2, localObject8);
        }
        try
        {
          localObject9 = localLocation2.get();
          localObject10 = this.criterion;
          localObject11 = this.s;
        }
        catch (UnboundLocationException localUnboundLocationException2)
        {
          localUnboundLocationException2.setLine("srfi13.scm", 492, 9);
          throw localUnboundLocationException2;
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject11;
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "string-ref", 1, localObject11);
        }
        try
        {
          k = ((Number)localObject7).intValue();
          localObject12 = localApplyToArgs2.apply3(localObject9, localObject10, Char.make(strings.stringRef(localCharSequence2, k)));
          if (localObject12 != Boolean.FALSE) {
            localObject7 = AddOp.$Pl.apply2(localObject7, srfi13.Lit1);
          } else {
            return localObject12;
          }
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "string-ref", 2, localObject7);
        }
      }
      if (misc.isProcedure(this.criterion)) {
        localObject2 = Scheme.numEqu.apply2(paramObject1, paramObject2);
      }
      for (;;)
      {
        Object localObject3;
        Object localObject4;
        try
        {
          boolean bool1 = ((Boolean)localObject2).booleanValue();
          if (bool1)
          {
            if (bool1) {
              return Boolean.TRUE;
            }
            return Boolean.FALSE;
          }
          localObject3 = paramObject1;
          localObject4 = this.s;
        }
        catch (ClassCastException localClassCastException1)
        {
          CharSequence localCharSequence1;
          int i;
          int j;
          Object localObject5;
          Object localObject6;
          Object[] arrayOfObject;
          throw new WrongType(localClassCastException1, "x", -2, localObject2);
        }
        try
        {
          localCharSequence1 = (CharSequence)localObject4;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-ref", 1, localObject4);
        }
        try
        {
          i = ((Number)localObject3).intValue();
          j = strings.stringRef(localCharSequence1, i);
          localObject5 = AddOp.$Pl.apply2(localObject3, srfi13.Lit1);
          if (Scheme.numEqu.apply2(localObject5, paramObject2) != Boolean.FALSE) {
            return Scheme.applyToArgs.apply2(this.criterion, Char.make(j));
          }
          localObject6 = Scheme.applyToArgs.apply2(this.criterion, Char.make(j));
          if (localObject6 != Boolean.FALSE) {
            localObject3 = localObject5;
          } else {
            return localObject6;
          }
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 2, localObject3);
        }
      }
      arrayOfObject = new Object[2];
      arrayOfObject[0] = srfi13.string$Mnevery;
      arrayOfObject[1] = this.criterion;
      return misc.error$V("Second param is neither char-set, char, or predicate procedure.", arrayOfObject);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 20)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 21)
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
  
  public class frame90
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn202 = new ModuleMethod(this, 177, null, 0);
    final ModuleMethod lambda$Fn203 = new ModuleMethod(this, 178, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 177) {
        return lambda202();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 178) {
        return lambda203(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda202()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnreverse$Ex, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda203(Object paramObject1, Object paramObject2)
    {
      localObject1 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
      localObject2 = paramObject1;
      for (;;)
      {
        Object localObject3;
        if (Scheme.numLEq.apply2(localObject1, localObject2) == Boolean.FALSE) {
          localObject3 = this.s;
        }
        Object localObject4;
        Object localObject5;
        Object localObject6;
        try
        {
          localCharSequence1 = (CharSequence)localObject3;
        }
        catch (ClassCastException localClassCastException1)
        {
          CharSequence localCharSequence1;
          int i;
          char c;
          CharSeq localCharSeq1;
          int j;
          CharSequence localCharSequence2;
          int k;
          CharSeq localCharSeq2;
          int m;
          throw new WrongType(localClassCastException1, "string-ref", 1, localObject3);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          c = strings.stringRef(localCharSequence1, i);
          localObject4 = this.s;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-ref", 2, localObject1);
        }
        try
        {
          localCharSeq1 = (CharSeq)localObject4;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-set!", 1, localObject4);
        }
        try
        {
          j = ((Number)localObject1).intValue();
          localObject5 = this.s;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "string-set!", 2, localObject1);
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject5;
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "string-ref", 1, localObject5);
        }
        try
        {
          k = ((Number)localObject2).intValue();
          strings.stringSet$Ex(localCharSeq1, j, strings.stringRef(localCharSequence2, k));
          localObject6 = this.s;
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "string-ref", 2, localObject2);
        }
        try
        {
          localCharSeq2 = (CharSeq)localObject6;
        }
        catch (ClassCastException localClassCastException7)
        {
          throw new WrongType(localClassCastException7, "string-set!", 1, localObject6);
        }
        try
        {
          m = ((Number)localObject2).intValue();
          strings.stringSet$Ex(localCharSeq2, m, c);
          localObject1 = AddOp.$Mn.apply2(localObject1, srfi13.Lit1);
          localObject2 = AddOp.$Pl.apply2(localObject2, srfi13.Lit1);
        }
        catch (ClassCastException localClassCastException8)
        {
          throw new WrongType(localClassCastException8, "string-set!", 2, localObject2);
        }
      }
      return Values.empty;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 177)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 178)
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
  
  public class frame91
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn204 = new ModuleMethod(this, 179, null, 0);
    final ModuleMethod lambda$Fn205 = new ModuleMethod(this, 180, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 179) {
        return lambda204();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 180) {
        return lambda205(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda204()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mn$Grlist, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda205(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
      Object localObject2 = LList.Empty;
      for (;;)
      {
        if (Scheme.numLss.apply2(localObject1, paramObject1) == Boolean.FALSE)
        {
          Object localObject3 = AddOp.$Mn.apply2(localObject1, srfi13.Lit1);
          Object localObject4 = this.s;
          try
          {
            localCharSequence = (CharSequence)localObject4;
          }
          catch (ClassCastException localClassCastException1)
          {
            try
            {
              CharSequence localCharSequence;
              int i = ((Number)localObject1).intValue();
              localObject2 = lists.cons(Char.make(strings.stringRef(localCharSequence, i)), localObject2);
              localObject1 = localObject3;
            }
            catch (ClassCastException localClassCastException2)
            {
              throw new WrongType(localClassCastException2, "string-ref", 2, localObject1);
            }
            localClassCastException1 = localClassCastException1;
            throw new WrongType(localClassCastException1, "string-ref", 1, localObject4);
          }
        }
      }
      return localObject2;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 179)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 180)
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
  
  public class frame92
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn206 = new ModuleMethod(this, 181, null, 0);
    final ModuleMethod lambda$Fn207 = new ModuleMethod(this, 182, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s1;
    Object s2;
    Object start1;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 181) {
        return lambda206();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 182) {
        return lambda207(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda206()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnreplace, this.s2, this.maybe$Mnstart$Plend);
    }
    
    /* Error */
    CharSequence lambda207(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 64	gnu/kawa/slib/srfi13$frame92:s1	Ljava/lang/Object;
      //   4: astore_3
      //   5: aload_3
      //   6: checkcast 66	java/lang/CharSequence
      //   9: astore 5
      //   11: aload 5
      //   13: invokestatic 72	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   16: istore 6
      //   18: getstatic 78	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   21: aload_2
      //   22: aload_1
      //   23: invokevirtual 83	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   26: astore 7
      //   28: getstatic 86	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   31: getstatic 78	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   34: iload 6
      //   36: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   39: getstatic 78	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   42: aload_0
      //   43: getfield 94	gnu/kawa/slib/srfi13$frame92:end1	Ljava/lang/Object;
      //   46: aload_0
      //   47: getfield 96	gnu/kawa/slib/srfi13$frame92:start1	Ljava/lang/Object;
      //   50: invokevirtual 83	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   53: invokevirtual 83	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   56: aload 7
      //   58: invokevirtual 83	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   61: astore 8
      //   63: aload 8
      //   65: checkcast 98	java/lang/Number
      //   68: invokevirtual 102	java/lang/Number:intValue	()I
      //   71: istore 10
      //   73: iload 10
      //   75: invokestatic 106	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
      //   78: astore 11
      //   80: aload_0
      //   81: getfield 64	gnu/kawa/slib/srfi13$frame92:s1	Ljava/lang/Object;
      //   84: astore 12
      //   86: aload 12
      //   88: checkcast 66	java/lang/CharSequence
      //   91: astore 14
      //   93: aload_0
      //   94: getfield 96	gnu/kawa/slib/srfi13$frame92:start1	Ljava/lang/Object;
      //   97: astore 15
      //   99: aload 15
      //   101: checkcast 98	java/lang/Number
      //   104: invokevirtual 102	java/lang/Number:intValue	()I
      //   107: istore 17
      //   109: aload 11
      //   111: iconst_0
      //   112: aload 14
      //   114: iconst_0
      //   115: iload 17
      //   117: invokestatic 110	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
      //   120: pop
      //   121: aload_0
      //   122: getfield 96	gnu/kawa/slib/srfi13$frame92:start1	Ljava/lang/Object;
      //   125: astore 19
      //   127: aload 19
      //   129: checkcast 98	java/lang/Number
      //   132: invokevirtual 102	java/lang/Number:intValue	()I
      //   135: istore 21
      //   137: aload_0
      //   138: getfield 54	gnu/kawa/slib/srfi13$frame92:s2	Ljava/lang/Object;
      //   141: astore 22
      //   143: aload 22
      //   145: checkcast 66	java/lang/CharSequence
      //   148: astore 24
      //   150: aload_1
      //   151: checkcast 98	java/lang/Number
      //   154: invokevirtual 102	java/lang/Number:intValue	()I
      //   157: istore 26
      //   159: aload_2
      //   160: checkcast 98	java/lang/Number
      //   163: invokevirtual 102	java/lang/Number:intValue	()I
      //   166: istore 28
      //   168: aload 11
      //   170: iload 21
      //   172: aload 24
      //   174: iload 26
      //   176: iload 28
      //   178: invokestatic 110	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
      //   181: pop
      //   182: getstatic 86	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   185: aload_0
      //   186: getfield 96	gnu/kawa/slib/srfi13$frame92:start1	Ljava/lang/Object;
      //   189: aload 7
      //   191: invokevirtual 83	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   194: astore 30
      //   196: aload 30
      //   198: checkcast 98	java/lang/Number
      //   201: invokevirtual 102	java/lang/Number:intValue	()I
      //   204: istore 32
      //   206: aload_0
      //   207: getfield 64	gnu/kawa/slib/srfi13$frame92:s1	Ljava/lang/Object;
      //   210: astore 33
      //   212: aload 33
      //   214: checkcast 66	java/lang/CharSequence
      //   217: astore 35
      //   219: aload_0
      //   220: getfield 94	gnu/kawa/slib/srfi13$frame92:end1	Ljava/lang/Object;
      //   223: astore 36
      //   225: aload 36
      //   227: checkcast 98	java/lang/Number
      //   230: invokevirtual 102	java/lang/Number:intValue	()I
      //   233: istore 38
      //   235: aload 11
      //   237: iload 32
      //   239: aload 35
      //   241: iload 38
      //   243: iload 6
      //   245: invokestatic 110	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
      //   248: pop
      //   249: aload 11
      //   251: areturn
      //   252: astore 4
      //   254: new 112	gnu/mapping/WrongType
      //   257: dup
      //   258: aload 4
      //   260: ldc 114
      //   262: iconst_1
      //   263: aload_3
      //   264: invokespecial 117	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   267: athrow
      //   268: astore 9
      //   270: new 112	gnu/mapping/WrongType
      //   273: dup
      //   274: aload 9
      //   276: ldc 119
      //   278: iconst_1
      //   279: aload 8
      //   281: invokespecial 117	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   284: athrow
      //   285: astore 13
      //   287: new 112	gnu/mapping/WrongType
      //   290: dup
      //   291: aload 13
      //   293: ldc 121
      //   295: iconst_2
      //   296: aload 12
      //   298: invokespecial 117	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   301: athrow
      //   302: astore 16
      //   304: new 112	gnu/mapping/WrongType
      //   307: dup
      //   308: aload 16
      //   310: ldc 121
      //   312: iconst_4
      //   313: aload 15
      //   315: invokespecial 117	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   318: athrow
      //   319: astore 20
      //   321: new 112	gnu/mapping/WrongType
      //   324: dup
      //   325: aload 20
      //   327: ldc 121
      //   329: iconst_1
      //   330: aload 19
      //   332: invokespecial 117	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   335: athrow
      //   336: astore 23
      //   338: new 112	gnu/mapping/WrongType
      //   341: dup
      //   342: aload 23
      //   344: ldc 121
      //   346: iconst_2
      //   347: aload 22
      //   349: invokespecial 117	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   352: athrow
      //   353: astore 25
      //   355: new 112	gnu/mapping/WrongType
      //   358: dup
      //   359: aload 25
      //   361: ldc 121
      //   363: iconst_3
      //   364: aload_1
      //   365: invokespecial 117	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   368: athrow
      //   369: astore 27
      //   371: new 112	gnu/mapping/WrongType
      //   374: dup
      //   375: aload 27
      //   377: ldc 121
      //   379: iconst_4
      //   380: aload_2
      //   381: invokespecial 117	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   384: athrow
      //   385: astore 31
      //   387: new 112	gnu/mapping/WrongType
      //   390: dup
      //   391: aload 31
      //   393: ldc 121
      //   395: iconst_1
      //   396: aload 30
      //   398: invokespecial 117	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   401: athrow
      //   402: astore 34
      //   404: new 112	gnu/mapping/WrongType
      //   407: dup
      //   408: aload 34
      //   410: ldc 121
      //   412: iconst_2
      //   413: aload 33
      //   415: invokespecial 117	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   418: athrow
      //   419: astore 37
      //   421: new 112	gnu/mapping/WrongType
      //   424: dup
      //   425: aload 37
      //   427: ldc 121
      //   429: iconst_3
      //   430: aload 36
      //   432: invokespecial 117	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   435: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	436	0	this	frame92
      //   0	436	1	paramObject1	Object
      //   0	436	2	paramObject2	Object
      //   4	260	3	localObject1	Object
      //   252	7	4	localClassCastException1	ClassCastException
      //   9	3	5	localCharSequence1	CharSequence
      //   16	228	6	i	int
      //   26	164	7	localObject2	Object
      //   61	219	8	localObject3	Object
      //   268	7	9	localClassCastException2	ClassCastException
      //   71	3	10	j	int
      //   78	172	11	localCharSequence2	CharSequence
      //   84	213	12	localObject4	Object
      //   285	7	13	localClassCastException3	ClassCastException
      //   91	22	14	localCharSequence3	CharSequence
      //   97	217	15	localObject5	Object
      //   302	7	16	localClassCastException4	ClassCastException
      //   107	9	17	k	int
      //   125	206	19	localObject6	Object
      //   319	7	20	localClassCastException5	ClassCastException
      //   135	36	21	m	int
      //   141	207	22	localObject7	Object
      //   336	7	23	localClassCastException6	ClassCastException
      //   148	25	24	localCharSequence4	CharSequence
      //   353	7	25	localClassCastException7	ClassCastException
      //   157	18	26	n	int
      //   369	7	27	localClassCastException8	ClassCastException
      //   166	11	28	i1	int
      //   194	203	30	localObject8	Object
      //   385	7	31	localClassCastException9	ClassCastException
      //   204	34	32	i2	int
      //   210	204	33	localObject9	Object
      //   402	7	34	localClassCastException10	ClassCastException
      //   217	23	35	localCharSequence5	CharSequence
      //   223	208	36	localObject10	Object
      //   419	7	37	localClassCastException11	ClassCastException
      //   233	9	38	i3	int
      // Exception table:
      //   from	to	target	type
      //   5	11	252	java/lang/ClassCastException
      //   63	73	268	java/lang/ClassCastException
      //   86	93	285	java/lang/ClassCastException
      //   99	109	302	java/lang/ClassCastException
      //   127	137	319	java/lang/ClassCastException
      //   143	150	336	java/lang/ClassCastException
      //   150	159	353	java/lang/ClassCastException
      //   159	168	369	java/lang/ClassCastException
      //   196	206	385	java/lang/ClassCastException
      //   212	219	402	java/lang/ClassCastException
      //   225	235	419	java/lang/ClassCastException
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 181)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 182)
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
  
  public class frame93
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn208 = new ModuleMethod(this, 183, null, 0);
    final ModuleMethod lambda$Fn209 = new ModuleMethod(this, 184, null, 8194);
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 183) {
        return lambda208();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 184) {
        return lambda209(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda208()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mntokenize;
      Object localObject1 = this.s;
      Location localLocation = srfi13.loc$rest;
      try
      {
        Object localObject2 = localLocation.get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("srfi13.scm", 1696, 57);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda209(Object paramObject1, Object paramObject2)
    {
      localObject1 = LList.Empty;
      Object localObject2 = paramObject2;
      localObject3 = Scheme.numLss.apply2(paramObject1, localObject2);
      for (;;)
      {
        for (;;)
        {
          try
          {
            bool = ((Boolean)localObject3).booleanValue();
            if (bool)
            {
              localObject12 = this.s;
              localLocation2 = srfi13.loc$token$Mnchars;
            }
          }
          catch (ClassCastException localClassCastException1)
          {
            try
            {
              boolean bool;
              Object localObject12;
              Location localLocation2;
              Object localObject13;
              Object localObject4;
              Object localObject6;
              Location localLocation1;
              Object localObject7;
              Object localObject8;
              CharSequence localCharSequence2;
              int k;
              int m;
              localCharSequence1 = (CharSequence)localObject9;
            }
            catch (ClassCastException localClassCastException2)
            {
              Object localObject10;
              Object localObject11;
              Object localObject9;
              CharSequence localCharSequence1;
              int i;
              int j;
              throw new WrongType(localClassCastException2, "substring", 1, localObject9);
            }
            try
            {
              i = ((Number)paramObject1).intValue();
            }
            catch (ClassCastException localClassCastException3)
            {
              throw new WrongType(localClassCastException3, "substring", 2, paramObject1);
            }
            try
            {
              j = ((Number)localObject5).intValue();
              localObject1 = lists.cons(strings.substring(localCharSequence1, i, j), localObject1);
              return localObject1;
            }
            catch (ClassCastException localClassCastException4)
            {
              throw new WrongType(localClassCastException4, "substring", 3, localObject5);
            }
            localClassCastException1 = localClassCastException1;
            throw new WrongType(localClassCastException1, "x", -2, localObject3);
          }
          try
          {
            localObject13 = localLocation2.get();
            localObject4 = srfi13.stringIndexRight$V(localObject12, localObject13, new Object[] { paramObject1, localObject2 });
            if (localObject4 != Boolean.FALSE)
            {
              localObject5 = AddOp.$Pl.apply2(srfi13.Lit1, localObject4);
              localObject6 = this.s;
              localLocation1 = srfi13.loc$token$Mnchars;
            }
          }
          catch (UnboundLocationException localUnboundLocationException2)
          {
            localUnboundLocationException2.setLine("srfi13.scm", 1698, 48);
            throw localUnboundLocationException2;
          }
          try
          {
            localObject7 = localLocation1.get();
            localObject8 = srfi13.stringSkipRight$V(localObject6, localObject7, new Object[] { paramObject1, localObject4 });
            if (localObject8 != Boolean.FALSE) {
              localObject10 = this.s;
            }
          }
          catch (UnboundLocationException localUnboundLocationException1)
          {
            localUnboundLocationException1.setLine("srfi13.scm", 1701, 34);
            throw localUnboundLocationException1;
          }
          try
          {
            localCharSequence2 = (CharSequence)localObject10;
            localObject11 = AddOp.$Pl.apply2(srfi13.Lit1, localObject8);
          }
          catch (ClassCastException localClassCastException5)
          {
            throw new WrongType(localClassCastException5, "substring", 1, localObject10);
          }
          try
          {
            k = ((Number)localObject11).intValue();
          }
          catch (ClassCastException localClassCastException6)
          {
            throw new WrongType(localClassCastException6, "substring", 2, localObject11);
          }
          try
          {
            m = ((Number)localObject5).intValue();
            localObject1 = lists.cons(strings.substring(localCharSequence2, k, m), localObject1);
            localObject2 = localObject8;
          }
          catch (ClassCastException localClassCastException7)
          {
            throw new WrongType(localClassCastException7, "substring", 3, localObject5);
          }
        }
        if (bool) {
          localObject4 = Boolean.TRUE;
        } else {
          localObject4 = Boolean.FALSE;
        }
      }
      localObject9 = this.s;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 183)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 184)
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
  
  public class frame94
    extends ModuleBody
  {
    Object from;
    final ModuleMethod lambda$Fn211;
    final ModuleMethod lambda$Fn212 = new ModuleMethod(this, 185, null, 0);
    final ModuleMethod lambda$Fn213;
    final ModuleMethod lambda$Fn214;
    final ModuleMethod lambda$Fn215;
    LList maybe$Mnto$Plstart$Plend;
    Object s;
    
    public frame94()
    {
      this$1 = new ModuleMethod(this, 186, null, 4097);
      this$1.setProperty("source-location", "srfi13.scm:1744");
      this.lambda$Fn214 = this$1;
      this.lambda$Fn213 = new ModuleMethod(this, 187, null, 8194);
      this.lambda$Fn211 = new ModuleMethod(this, 188, null, 0);
      ModuleMethod localModuleMethod = new ModuleMethod(this, 189, null, 12291);
      localModuleMethod.setProperty("source-location", "srfi13.scm:1740");
      this.lambda$Fn215 = localModuleMethod;
    }
    
    static boolean lambda210(Object paramObject)
    {
      boolean bool = numbers.isInteger(paramObject);
      if (bool) {
        bool = numbers.isExact(paramObject);
      }
      return bool;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      switch (paramModuleMethod.selector)
      {
      case 186: 
      case 187: 
      default: 
        return super.apply0(paramModuleMethod);
      case 185: 
        return lambda212();
      }
      return lambda211();
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 186)
      {
        if (lambda214(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 187) {
        return lambda213(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 189) {
        return lambda215(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    /* Error */
    Object lambda211()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 109	gnu/kawa/slib/srfi13$frame94:maybe$Mnto$Plstart$Plend	Lgnu/lists/LList;
      //   4: invokestatic 114	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   7: ifeq +15 -> 22
      //   10: aload_0
      //   11: getfield 26	gnu/kawa/slib/srfi13$frame94:lambda$Fn212	Lgnu/expr/ModuleMethod;
      //   14: aload_0
      //   15: getfield 40	gnu/kawa/slib/srfi13$frame94:lambda$Fn213	Lgnu/expr/ModuleMethod;
      //   18: invokestatic 120	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   21: areturn
      //   22: getstatic 126	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   25: astore_1
      //   26: getstatic 132	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
      //   29: astore_2
      //   30: aload_2
      //   31: invokevirtual 137	gnu/mapping/Location:get	()Ljava/lang/Object;
      //   34: astore 4
      //   36: aload_1
      //   37: aload 4
      //   39: getstatic 142	kawa/lib/strings:string$Qu	Lgnu/expr/ModuleMethod;
      //   42: aload_0
      //   43: getfield 144	gnu/kawa/slib/srfi13$frame94:s	Ljava/lang/Object;
      //   46: getstatic 147	gnu/kawa/slib/srfi13:xsubstring	Lgnu/expr/ModuleMethod;
      //   49: invokevirtual 153	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   52: astore 5
      //   54: aload 5
      //   56: checkcast 155	java/lang/CharSequence
      //   59: astore 7
      //   61: aload 7
      //   63: invokestatic 159	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   66: istore 8
      //   68: iconst_3
      //   69: anewarray 161	java/lang/Object
      //   72: astore 9
      //   74: aload 9
      //   76: iconst_0
      //   77: getstatic 167	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   80: aload_0
      //   81: getfield 169	gnu/kawa/slib/srfi13$frame94:from	Ljava/lang/Object;
      //   84: iload 8
      //   86: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   89: invokevirtual 177	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   92: aastore
      //   93: aload 9
      //   95: iconst_1
      //   96: getstatic 181	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
      //   99: aastore
      //   100: aload 9
      //   102: iconst_2
      //   103: iload 8
      //   105: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   108: aastore
      //   109: aload 9
      //   111: invokestatic 187	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
      //   114: areturn
      //   115: astore_3
      //   116: aload_3
      //   117: ldc 189
      //   119: sipush 1749
      //   122: bipush 36
      //   124: invokevirtual 193	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
      //   127: aload_3
      //   128: athrow
      //   129: astore 6
      //   131: new 195	gnu/mapping/WrongType
      //   134: dup
      //   135: aload 6
      //   137: ldc 197
      //   139: iconst_1
      //   140: aload 5
      //   142: invokespecial 200	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   145: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	146	0	this	frame94
      //   25	12	1	localApplyToArgs	ApplyToArgs
      //   29	2	2	localLocation	Location
      //   115	13	3	localUnboundLocationException	UnboundLocationException
      //   34	4	4	localObject1	Object
      //   52	89	5	localObject2	Object
      //   129	7	6	localClassCastException	ClassCastException
      //   59	3	7	localCharSequence	CharSequence
      //   66	38	8	i	int
      //   72	38	9	arrayOfObject	Object[]
      // Exception table:
      //   from	to	target	type
      //   30	36	115	gnu/mapping/UnboundLocationException
      //   54	61	129	java/lang/ClassCastException
    }
    
    Object lambda212()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.xsubstring, this.s, lists.cdr.apply1(this.maybe$Mnto$Plstart$Plend));
    }
    
    Object lambda213(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = lists.car.apply1(this.maybe$Mnto$Plstart$Plend);
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      Location localLocation = srfi13.loc$check$Mnarg;
      try
      {
        Object localObject2 = localLocation.get();
        localApplyToArgs.apply4(localObject2, this.lambda$Fn214, localObject1, srfi13.xsubstring);
        return misc.values(new Object[] { localObject1, paramObject1, paramObject2 });
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("srfi13.scm", 1744, 6);
        throw localUnboundLocationException;
      }
    }
    
    boolean lambda214(Object paramObject)
    {
      boolean bool = numbers.isInteger(paramObject);
      if (bool)
      {
        bool = numbers.isExact(paramObject);
        if (bool) {
          bool = ((Boolean)Scheme.numLEq.apply2(this.from, paramObject)).booleanValue();
        }
      }
      return bool;
    }
    
    Object lambda215(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      localObject1 = AddOp.$Mn.apply2(paramObject3, paramObject2);
      localObject2 = AddOp.$Mn.apply2(paramObject1, this.from);
      try
      {
        Number localNumber1 = (Number)localObject2;
        if (numbers.isZero(localNumber1)) {
          return "";
        }
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          Number localNumber2;
          int m;
          CharSequence localCharSequence3;
          int n;
          RealNum localRealNum1 = LangObjType.coerceRealNum(localObject3);
          d = numbers.floor(localRealNum1).doubleValue();
          localObject4 = DivideOp.$Sl.apply2(paramObject1, localObject1);
        }
        catch (ClassCastException localClassCastException3)
        {
          Object localObject8;
          Object localObject3;
          double d;
          RealNum localRealNum2;
          CharSequence localCharSequence2;
          int j;
          int k;
          int i;
          CharSequence localCharSequence1;
          throw new WrongType(localClassCastException3, "floor", 1, localObject3);
        }
        try
        {
          localRealNum2 = LangObjType.coerceRealNum(localObject4);
          if (d == numbers.floor(localRealNum2).doubleValue()) {
            localObject5 = this.s;
          }
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "floor", 1, localObject4);
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject5;
          localObject6 = AddOp.$Pl.apply2(paramObject2, DivideOp.modulo.apply2(this.from, localObject1));
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "substring", 1, localObject5);
        }
        try
        {
          j = ((Number)localObject6).intValue();
          localObject7 = AddOp.$Pl.apply2(paramObject2, DivideOp.modulo.apply2(paramObject1, localObject1));
        }
        catch (ClassCastException localClassCastException7)
        {
          throw new WrongType(localClassCastException7, "substring", 2, localObject6);
        }
        try
        {
          k = ((Number)localObject7).intValue();
          return strings.substring(localCharSequence2, j, k);
        }
        catch (ClassCastException localClassCastException8)
        {
          throw new WrongType(localClassCastException8, "substring", 3, localObject7);
        }
        try
        {
          i = ((Number)localObject2).intValue();
          localCharSequence1 = strings.makeString(i);
          srfi13.$PcMultispanRepcopy$Ex(localCharSequence1, srfi13.Lit0, this.s, this.from, paramObject1, paramObject2, paramObject3);
          return localCharSequence1;
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "make-string", 1, localObject2);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "zero?", 1, localObject2);
      }
      try
      {
        localNumber2 = (Number)localObject1;
        if (numbers.isZero(localNumber2))
        {
          Object[] arrayOfObject = new Object[6];
          arrayOfObject[0] = srfi13.xsubstring;
          arrayOfObject[1] = this.s;
          arrayOfObject[2] = this.from;
          arrayOfObject[3] = paramObject1;
          arrayOfObject[4] = paramObject2;
          arrayOfObject[5] = paramObject3;
          return misc.error$V("Cannot replicate empty (sub)string", arrayOfObject);
        }
        if (Scheme.numEqu.apply2(srfi13.Lit1, localObject1) == Boolean.FALSE) {}
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "zero?", 1, localObject1);
      }
      try
      {
        m = ((Number)localObject2).intValue();
        localObject8 = this.s;
      }
      catch (ClassCastException localClassCastException9)
      {
        throw new WrongType(localClassCastException9, "make-string", 1, localObject2);
      }
      try
      {
        localCharSequence3 = (CharSequence)localObject8;
      }
      catch (ClassCastException localClassCastException10)
      {
        throw new WrongType(localClassCastException10, "string-ref", 1, localObject8);
      }
      try
      {
        n = ((Number)paramObject2).intValue();
        return strings.makeString(m, Char.make(strings.stringRef(localCharSequence3, n)));
      }
      catch (ClassCastException localClassCastException11)
      {
        throw new WrongType(localClassCastException11, "string-ref", 2, paramObject2);
      }
      localObject3 = DivideOp.$Sl.apply2(this.from, localObject1);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      case 186: 
      case 187: 
      default: 
        return super.match0(paramModuleMethod, paramCallContext);
      case 188: 
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
      if (paramModuleMethod.selector == 186)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 187)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 189)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame95
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn217 = new ModuleMethod(this, 192, null, 0);
    final ModuleMethod lambda$Fn218 = new ModuleMethod(this, 190, null, 0);
    final ModuleMethod lambda$Fn219 = new ModuleMethod(this, 191, null, 8194);
    final ModuleMethod lambda$Fn221;
    LList maybe$Mnsto$Plstart$Plend;
    Object s;
    Object sfrom;
    Object target;
    Object tstart;
    
    public frame95()
    {
      this$1 = new ModuleMethod(this, 193, null, 12291);
      this$1.setProperty("source-location", "srfi13.scm:1781");
      this.lambda$Fn221 = this$1;
    }
    
    static boolean lambda216(Object paramObject)
    {
      boolean bool = numbers.isInteger(paramObject);
      if (bool) {
        bool = numbers.isExact(paramObject);
      }
      return bool;
    }
    
    static boolean lambda220(Object paramObject)
    {
      boolean bool = numbers.isInteger(paramObject);
      if (bool) {
        bool = numbers.isExact(paramObject);
      }
      return bool;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      switch (paramModuleMethod.selector)
      {
      case 191: 
      default: 
        return super.apply0(paramModuleMethod);
      case 190: 
        return lambda218();
      }
      return lambda217();
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 191) {
        return lambda219(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 193) {
        return lambda221(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda217()
    {
      if (lists.isPair(this.maybe$Mnsto$Plstart$Plend)) {
        return call_with_values.callWithValues(this.lambda$Fn218, this.lambda$Fn219);
      }
      Object localObject = this.s;
      try
      {
        CharSequence localCharSequence = (CharSequence)localObject;
        int i = strings.stringLength(localCharSequence);
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = AddOp.$Pl.apply2(this.sfrom, Integer.valueOf(i));
        arrayOfObject[1] = srfi13.Lit0;
        arrayOfObject[2] = Integer.valueOf(i);
        return misc.values(arrayOfObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "string-length", 1, localObject);
      }
    }
    
    Object lambda218()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnxcopy$Ex, this.s, lists.cdr.apply1(this.maybe$Mnsto$Plstart$Plend));
    }
    
    Object lambda219(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = lists.car.apply1(this.maybe$Mnsto$Plstart$Plend);
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      Location localLocation = srfi13.loc$check$Mnarg;
      try
      {
        Object localObject2 = localLocation.get();
        localApplyToArgs.apply4(localObject2, srfi13.lambda$Fn220, localObject1, srfi13.string$Mnxcopy$Ex);
        return misc.values(new Object[] { localObject1, paramObject1, paramObject2 });
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("srfi13.scm", 1785, 6);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda221(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      localObject1 = AddOp.$Mn.apply2(paramObject1, this.sfrom);
      Object localObject2 = AddOp.$Pl.apply2(this.tstart, localObject1);
      localObject3 = AddOp.$Mn.apply2(paramObject3, paramObject2);
      srfi13.checkSubstringSpec(srfi13.string$Mnxcopy$Ex, this.target, this.tstart, localObject2);
      try
      {
        Number localNumber1 = (Number)localObject1;
        boolean bool = numbers.isZero(localNumber1);
        if (bool)
        {
          if (bool) {
            return Boolean.TRUE;
          }
          return Boolean.FALSE;
        }
      }
      catch (ClassCastException localClassCastException1)
      {
        Number localNumber2;
        Object localObject11;
        CharSequence localCharSequence3;
        int m;
        Char localChar;
        Object[] arrayOfObject1;
        throw new WrongType(localClassCastException1, "zero?", 1, localObject1);
      }
      try
      {
        localNumber2 = (Number)localObject3;
        if (numbers.isZero(localNumber2))
        {
          Object[] arrayOfObject2 = new Object[8];
          arrayOfObject2[0] = srfi13.string$Mnxcopy$Ex;
          arrayOfObject2[1] = this.target;
          arrayOfObject2[2] = this.tstart;
          arrayOfObject2[3] = this.s;
          arrayOfObject2[4] = this.sfrom;
          arrayOfObject2[5] = paramObject1;
          arrayOfObject2[6] = paramObject2;
          arrayOfObject2[7] = paramObject3;
          return misc.error$V("Cannot replicate empty (sub)string", arrayOfObject2);
        }
        if (Scheme.numEqu.apply2(srfi13.Lit1, localObject3) != Boolean.FALSE)
        {
          localObject11 = this.target;
          localObject12 = this.s;
        }
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "zero?", 1, localObject3);
      }
      try
      {
        localCharSequence3 = (CharSequence)localObject12;
      }
      catch (ClassCastException localClassCastException10)
      {
        throw new WrongType(localClassCastException10, "string-ref", 1, localObject12);
      }
      try
      {
        m = ((Number)paramObject2).intValue();
        localChar = Char.make(strings.stringRef(localCharSequence3, m));
        arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = this.tstart;
        arrayOfObject1[1] = localObject2;
        return srfi13.stringFill$Ex$V(localObject11, localChar, arrayOfObject1);
      }
      catch (ClassCastException localClassCastException11)
      {
        throw new WrongType(localClassCastException11, "string-ref", 2, paramObject2);
      }
      localObject4 = DivideOp.$Sl.apply2(this.sfrom, localObject3);
      try
      {
        RealNum localRealNum1 = LangObjType.coerceRealNum(localObject4);
        d = numbers.floor(localRealNum1).doubleValue();
        localObject5 = DivideOp.$Sl.apply2(paramObject1, localObject3);
      }
      catch (ClassCastException localClassCastException3)
      {
        double d;
        RealNum localRealNum2;
        CharSequence localCharSequence1;
        int i;
        CharSequence localCharSequence2;
        int j;
        int k;
        throw new WrongType(localClassCastException3, "floor", 1, localObject4);
      }
      try
      {
        localRealNum2 = LangObjType.coerceRealNum(localObject5);
        if (d == numbers.floor(localRealNum2).doubleValue()) {
          localObject6 = this.target;
        }
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "floor", 1, localObject5);
      }
      try
      {
        localCharSequence1 = (CharSequence)localObject6;
        localObject7 = this.tstart;
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "%string-copy!", 0, localObject6);
      }
      try
      {
        i = ((Number)localObject7).intValue();
        localObject8 = this.s;
      }
      catch (ClassCastException localClassCastException6)
      {
        throw new WrongType(localClassCastException6, "%string-copy!", 1, localObject7);
      }
      try
      {
        localCharSequence2 = (CharSequence)localObject8;
        localObject9 = AddOp.$Pl.apply2(paramObject2, DivideOp.modulo.apply2(this.sfrom, localObject3));
      }
      catch (ClassCastException localClassCastException7)
      {
        throw new WrongType(localClassCastException7, "%string-copy!", 2, localObject8);
      }
      try
      {
        j = ((Number)localObject9).intValue();
        localObject10 = AddOp.$Pl.apply2(paramObject2, DivideOp.modulo.apply2(paramObject1, localObject3));
      }
      catch (ClassCastException localClassCastException8)
      {
        throw new WrongType(localClassCastException8, "%string-copy!", 3, localObject9);
      }
      try
      {
        k = ((Number)localObject10).intValue();
        return srfi13.$PcStringCopy$Ex(localCharSequence1, i, localCharSequence2, j, k);
      }
      catch (ClassCastException localClassCastException9)
      {
        throw new WrongType(localClassCastException9, "%string-copy!", 4, localObject10);
      }
      return srfi13.$PcMultispanRepcopy$Ex(this.target, this.tstart, this.s, this.sfrom, paramObject1, paramObject2, paramObject3);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      case 191: 
      default: 
        return super.match0(paramModuleMethod, paramCallContext);
      case 192: 
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 191)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 193)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame96
    extends ModuleBody
  {
    Object jdField_final;
    
    public Object lambda223recur(Object paramObject)
    {
      Location localLocation;
      if (lists.isPair(paramObject)) {
        localLocation = srfi13.loc$delim;
      }
      try
      {
        Object localObject = localLocation.get();
        return lists.cons(localObject, lists.cons(lists.car.apply1(paramObject), lambda223recur(lists.cdr.apply1(paramObject))));
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("srfi13.scm", 1857, 13);
        throw localUnboundLocationException;
      }
      return this.jdField_final;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.srfi13
 * JD-Core Version:    0.7.0.1
 */