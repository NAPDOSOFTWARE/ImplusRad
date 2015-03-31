package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.CharSeq;
import gnu.lists.FString;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.Complex;
import gnu.math.IntNum;
import gnu.math.RealNum;
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.ports;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.lib.vectors;
import kawa.standard.Scheme;
import kawa.standard.append;

public class printf
  extends ModuleBody
{
  public static final printf $instance;
  static final IntNum Lit0;
  static final IntNum Lit1;
  static final PairWithPosition Lit10;
  static final Char Lit11;
  static final Char Lit12;
  static final Char Lit13;
  static final IntNum Lit14;
  static final IntNum Lit15;
  static final IntNum Lit16;
  static final IntNum Lit17;
  static final Char Lit18;
  static final Char Lit19;
  static final PairWithPosition Lit2;
  static final Char Lit20;
  static final Char Lit21;
  static final Char Lit22;
  static final Char Lit23;
  static final Char Lit24;
  static final Char Lit25;
  static final Char Lit26;
  static final Char Lit27;
  static final Char Lit28;
  static final Char Lit29;
  static final Char Lit3;
  static final Char Lit30;
  static final Char Lit31;
  static final Char Lit32;
  static final PairWithPosition Lit33;
  static final SimpleSymbol Lit34;
  static final Char Lit35;
  static final Char Lit36;
  static final Char Lit37;
  static final Char Lit38;
  static final Char Lit39;
  static final Char Lit4;
  static final Char Lit40;
  static final Char Lit41;
  static final Char Lit42;
  static final Char Lit43;
  static final Char Lit44;
  static final IntNum Lit45;
  static final Char Lit46;
  static final Char Lit47;
  static final IntNum Lit48;
  static final Char Lit49;
  static final Char Lit5;
  static final IntNum Lit50;
  static final Char Lit51;
  static final Char Lit52;
  static final Char Lit53;
  static final Char Lit54;
  static final Char Lit55;
  static final Char Lit56;
  static final Char Lit57;
  static final Char Lit58;
  static final IntNum Lit59;
  static final Char Lit6;
  static final IntNum Lit60;
  static final IntNum Lit61;
  static final FVector Lit62;
  static final PairWithPosition Lit63;
  static final SimpleSymbol Lit64;
  static final Char Lit65;
  static final Char Lit66;
  static final SimpleSymbol Lit67;
  static final SimpleSymbol Lit68;
  static final SimpleSymbol Lit69;
  static final IntNum Lit7;
  static final SimpleSymbol Lit70;
  static final SimpleSymbol Lit71;
  static final SimpleSymbol Lit72 = (SimpleSymbol)new SimpleSymbol("fprintf").readResolve();
  static final Char Lit8;
  static final Char Lit9;
  public static final ModuleMethod fprintf;
  public static final ModuleMethod printf;
  public static final ModuleMethod sprintf;
  public static final boolean stdio$Clhex$Mnupper$Mncase$Qu;
  public static final ModuleMethod stdio$Cliprintf;
  public static final ModuleMethod stdio$Clparse$Mnfloat;
  public static final ModuleMethod stdio$Clround$Mnstring;
  
  static
  {
    Lit71 = (SimpleSymbol)new SimpleSymbol("stdio:iprintf").readResolve();
    Lit70 = (SimpleSymbol)new SimpleSymbol("stdio:round-string").readResolve();
    Lit69 = (SimpleSymbol)new SimpleSymbol("stdio:parse-float").readResolve();
    Lit68 = (SimpleSymbol)new SimpleSymbol("sprintf").readResolve();
    Lit67 = (SimpleSymbol)new SimpleSymbol("pad").readResolve();
    Lit66 = Char.make(42);
    Lit65 = Char.make(63);
    Lit64 = (SimpleSymbol)new SimpleSymbol("format-real").readResolve();
    Lit63 = PairWithPosition.make("i", LList.Empty, "printf.scm", 1634315);
    Lit62 = FVector.make(new Object[] { "y", "z", "a", "f", "p", "n", "u", "m", "", "k", "M", "G", "T", "P", "E", "Z", "Y" });
    Lit61 = IntNum.make(3);
    Lit60 = IntNum.make(-10);
    Lit59 = IntNum.make(6);
    Lit58 = Char.make(75);
    Lit57 = Char.make(107);
    Lit56 = Char.make(71);
    Lit55 = Char.make(103);
    Lit54 = Char.make(69);
    Lit53 = Char.make(66);
    Lit52 = Char.make(98);
    Lit51 = Char.make(88);
    Lit50 = IntNum.make(16);
    Lit49 = Char.make(120);
    Lit48 = IntNum.make(8);
    Lit47 = Char.make(79);
    Lit46 = Char.make(111);
    Lit45 = IntNum.make(10);
    Lit44 = Char.make(85);
    Lit43 = Char.make(117);
    Lit42 = Char.make(73);
    Lit41 = Char.make(68);
    Lit40 = Char.make(65);
    Lit39 = Char.make(97);
    Lit38 = Char.make(83);
    Lit37 = Char.make(115);
    Lit36 = Char.make(67);
    Lit35 = Char.make(99);
    Lit34 = (SimpleSymbol)new SimpleSymbol("printf").readResolve();
    Char localChar1 = Lit35;
    Char localChar2 = Lit37;
    Char localChar3 = Lit39;
    Char localChar4 = Char.make(100);
    Lit12 = localChar4;
    Char localChar5 = Char.make(105);
    Lit3 = localChar5;
    Char localChar6 = Lit43;
    Char localChar7 = Lit46;
    Char localChar8 = Lit49;
    Char localChar9 = Lit52;
    Char localChar10 = Char.make(102);
    Lit25 = localChar10;
    Char localChar11 = Char.make(101);
    Lit13 = localChar11;
    Lit33 = PairWithPosition.make(localChar1, PairWithPosition.make(localChar2, PairWithPosition.make(localChar3, PairWithPosition.make(localChar4, PairWithPosition.make(localChar5, PairWithPosition.make(localChar6, PairWithPosition.make(localChar7, PairWithPosition.make(localChar8, PairWithPosition.make(localChar9, PairWithPosition.make(localChar10, PairWithPosition.make(localChar11, PairWithPosition.make(Lit55, PairWithPosition.make(Lit57, LList.Empty, "printf.scm", 1781780), "printf.scm", 1781776), "printf.scm", 1781772), "printf.scm", 1781768), "printf.scm", 1777704), "printf.scm", 1777700), "printf.scm", 1777696), "printf.scm", 1777692), "printf.scm", 1777688), "printf.scm", 1777684), "printf.scm", 1777680), "printf.scm", 1777676), "printf.scm", 1777671);
    Lit32 = Char.make(104);
    Lit31 = Char.make(76);
    Lit30 = Char.make(108);
    Lit29 = Char.make(32);
    Lit28 = Char.make(37);
    Lit27 = Char.make(12);
    Lit26 = Char.make(70);
    Lit24 = Char.make(9);
    Lit23 = Char.make(84);
    Lit22 = Char.make(116);
    Lit21 = Char.make(10);
    Lit20 = Char.make(78);
    Lit19 = Char.make(110);
    Lit18 = Char.make(92);
    Lit17 = IntNum.make(-1);
    Lit16 = IntNum.make(9);
    Lit15 = IntNum.make(5);
    Lit14 = IntNum.make(2);
    Lit11 = Char.make(46);
    Lit10 = PairWithPosition.make(Lit13, PairWithPosition.make(Lit37, PairWithPosition.make(Lit25, PairWithPosition.make(Lit12, PairWithPosition.make(Lit30, PairWithPosition.make(Lit54, PairWithPosition.make(Lit38, PairWithPosition.make(Lit26, PairWithPosition.make(Lit41, PairWithPosition.make(Lit31, LList.Empty, "printf.scm", 266284), "printf.scm", 266280), "printf.scm", 266276), "printf.scm", 266272), "printf.scm", 266268), "printf.scm", 266264), "printf.scm", 266260), "printf.scm", 266256), "printf.scm", 266252), "printf.scm", 266247);
    Lit9 = Char.make(48);
    Lit8 = Char.make(35);
    Lit7 = IntNum.make(1);
    Lit6 = Char.make(43);
    Lit5 = Char.make(45);
    Lit4 = Char.make(64);
    Lit2 = PairWithPosition.make(Lit6, PairWithPosition.make(Lit5, LList.Empty, "printf.scm", 446503), "printf.scm", 446498);
    Lit1 = IntNum.make(0);
    Lit0 = IntNum.make(-15);
    $instance = new printf();
    printf localprintf = $instance;
    stdio$Clparse$Mnfloat = new ModuleMethod(localprintf, 22, Lit69, 8194);
    stdio$Clround$Mnstring = new ModuleMethod(localprintf, 23, Lit70, 12291);
    stdio$Cliprintf = new ModuleMethod(localprintf, 24, Lit71, -4094);
    fprintf = new ModuleMethod(localprintf, 25, Lit72, -4094);
    printf = new ModuleMethod(localprintf, 26, Lit34, -4095);
    sprintf = new ModuleMethod(localprintf, 27, Lit68, -4094);
    $instance.run();
  }
  
  public printf()
  {
    ModuleInfo.register(this);
  }
  
  public static Object fprintf$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame12 localframe12 = new frame12();
    localframe12.port = paramObject1;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    localframe12.cnt = Lit1;
    Scheme.apply.apply4(stdio$Cliprintf, localframe12.lambda$Fn18, paramObject2, localLList);
    return localframe12.cnt;
  }
  
  public static Object printf$V(Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    return Scheme.apply.apply4(fprintf, ports.current$Mnoutput$Mnport.apply0(), paramObject, localLList);
  }
  
  /* Error */
  public static Object sprintf$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 434	gnu/kawa/slib/printf$frame13
    //   3: dup
    //   4: invokespecial 435	gnu/kawa/slib/printf$frame13:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: putfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   13: aload_2
    //   14: iconst_0
    //   15: invokestatic 400	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   18: astore 4
    //   20: aload_3
    //   21: getstatic 354	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
    //   24: putfield 439	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
    //   27: aload_3
    //   28: getfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   31: invokestatic 445	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   34: ifeq +72 -> 106
    //   37: aload_3
    //   38: getfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   41: astore 7
    //   43: aload_3
    //   44: aload 7
    //   46: putfield 448	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
    //   49: aload_3
    //   50: getfield 448	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
    //   53: astore 8
    //   55: aload 8
    //   57: checkcast 450	java/lang/CharSequence
    //   60: astore 10
    //   62: aload_3
    //   63: aload 10
    //   65: invokestatic 454	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   68: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: putfield 463	gnu/kawa/slib/printf$frame13:end	Ljava/lang/Object;
    //   74: getstatic 409	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   77: getstatic 371	gnu/kawa/slib/printf:stdio$Cliprintf	Lgnu/expr/ModuleMethod;
    //   80: aload_3
    //   81: getfield 466	gnu/kawa/slib/printf$frame13:lambda$Fn19	Lgnu/expr/ModuleMethod;
    //   84: aload_1
    //   85: aload 4
    //   87: invokevirtual 418	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   90: pop
    //   91: aload_3
    //   92: getfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   95: invokestatic 445	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   98: ifeq +102 -> 200
    //   101: aload_3
    //   102: getfield 439	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
    //   105: areturn
    //   106: aload_3
    //   107: getfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   110: invokestatic 471	kawa/lib/numbers:isNumber	(Ljava/lang/Object;)Z
    //   113: ifeq +29 -> 142
    //   116: aload_3
    //   117: getfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   120: astore 18
    //   122: aload 18
    //   124: checkcast 473	java/lang/Number
    //   127: invokevirtual 477	java/lang/Number:intValue	()I
    //   130: istore 20
    //   132: iload 20
    //   134: invokestatic 481	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   137: astore 7
    //   139: goto -96 -> 43
    //   142: aload_3
    //   143: getfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   146: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   149: if_acmpne +13 -> 162
    //   152: bipush 100
    //   154: invokestatic 481	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   157: astore 7
    //   159: goto -116 -> 43
    //   162: getstatic 123	gnu/kawa/slib/printf:Lit68	Lgnu/mapping/SimpleSymbol;
    //   165: astore 5
    //   167: iconst_2
    //   168: anewarray 161	java/lang/Object
    //   171: astore 6
    //   173: aload 6
    //   175: iconst_0
    //   176: ldc_w 489
    //   179: aastore
    //   180: aload 6
    //   182: iconst_1
    //   183: aload_3
    //   184: getfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   187: aastore
    //   188: aload 5
    //   190: aload 6
    //   192: invokestatic 494	kawa/lib/misc:error$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   195: astore 7
    //   197: goto -154 -> 43
    //   200: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   203: aload_3
    //   204: getfield 463	gnu/kawa/slib/printf$frame13:end	Ljava/lang/Object;
    //   207: aload_3
    //   208: getfield 439	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
    //   211: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   214: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   217: if_acmpeq +8 -> 225
    //   220: aload_3
    //   221: getfield 448	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
    //   224: areturn
    //   225: aload_3
    //   226: getfield 448	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
    //   229: astore 12
    //   231: aload 12
    //   233: checkcast 450	java/lang/CharSequence
    //   236: astore 14
    //   238: aload_3
    //   239: getfield 439	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
    //   242: astore 15
    //   244: aload 15
    //   246: checkcast 473	java/lang/Number
    //   249: invokevirtual 477	java/lang/Number:intValue	()I
    //   252: istore 17
    //   254: aload 14
    //   256: iconst_0
    //   257: iload 17
    //   259: invokestatic 506	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   262: areturn
    //   263: astore 19
    //   265: new 508	gnu/mapping/WrongType
    //   268: dup
    //   269: aload 19
    //   271: ldc_w 510
    //   274: iconst_1
    //   275: aload 18
    //   277: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   280: athrow
    //   281: astore 9
    //   283: new 508	gnu/mapping/WrongType
    //   286: dup
    //   287: aload 9
    //   289: ldc_w 515
    //   292: iconst_1
    //   293: aload 8
    //   295: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   298: athrow
    //   299: astore 13
    //   301: new 508	gnu/mapping/WrongType
    //   304: dup
    //   305: aload 13
    //   307: ldc_w 516
    //   310: iconst_1
    //   311: aload 12
    //   313: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   316: athrow
    //   317: astore 16
    //   319: new 508	gnu/mapping/WrongType
    //   322: dup
    //   323: aload 16
    //   325: ldc_w 516
    //   328: iconst_3
    //   329: aload 15
    //   331: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   334: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	paramObject1	Object
    //   0	335	1	paramObject2	Object
    //   0	335	2	paramArrayOfObject	Object[]
    //   7	232	3	localframe13	frame13
    //   18	68	4	localLList	LList
    //   165	24	5	localSimpleSymbol	SimpleSymbol
    //   171	20	6	arrayOfObject	Object[]
    //   41	155	7	localObject1	Object
    //   53	241	8	localObject2	Object
    //   281	7	9	localClassCastException1	ClassCastException
    //   60	4	10	localCharSequence1	CharSequence
    //   229	83	12	localObject3	Object
    //   299	7	13	localClassCastException2	ClassCastException
    //   236	19	14	localCharSequence2	CharSequence
    //   242	88	15	localObject4	Object
    //   317	7	16	localClassCastException3	ClassCastException
    //   252	6	17	i	int
    //   120	156	18	localObject5	Object
    //   263	7	19	localClassCastException4	ClassCastException
    //   130	3	20	j	int
    // Exception table:
    //   from	to	target	type
    //   122	132	263	java/lang/ClassCastException
    //   55	62	281	java/lang/ClassCastException
    //   231	238	299	java/lang/ClassCastException
    //   244	254	317	java/lang/ClassCastException
  }
  
  public static Object stdio$ClIprintf$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame9 localframe9 = new frame9();
    localframe9.out = paramObject1;
    localframe9.format$Mnstring = paramObject2;
    localframe9.args = LList.makeList(paramArrayOfObject, 0);
    if (!IsEqual.apply("", localframe9.format$Mnstring))
    {
      IntNum localIntNum1 = Lit17;
      localObject1 = localframe9.format$Mnstring;
      for (;;)
      {
        try
        {
          CharSequence localCharSequence1 = (CharSequence)localObject1;
          i = strings.stringLength(localCharSequence1);
          localObject2 = localframe9.format$Mnstring;
        }
        catch (ClassCastException localClassCastException1)
        {
          int i;
          CharSequence localCharSequence2;
          Object localObject3;
          frame10 localframe10;
          Boolean localBoolean9;
          Object localObject6;
          CharSequence localCharSequence3;
          int j;
          Object localObject71;
          Object localObject72;
          Object localObject75;
          Object localObject73;
          Object localObject74;
          Boolean localBoolean1;
          Boolean localBoolean2;
          Boolean localBoolean3;
          Boolean localBoolean4;
          Boolean localBoolean5;
          IntNum localIntNum2;
          Object localObject7;
          throw new WrongType(localClassCastException1, "string-length", 1, localObject1);
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject2;
          localframe9.fc = Char.make(strings.stringRef(localCharSequence2, 0));
          localframe9.fl = i;
          localframe9.pos = localIntNum1;
          localObject3 = localframe9.args;
          localframe10 = new frame10();
          localframe10.staticLink = localframe9;
          localframe10.args = localObject3;
          localframe9.pos = AddOp.$Pl.apply2(Lit7, localframe9.pos);
          if (Scheme.numGEq.apply2(localframe9.pos, Integer.valueOf(localframe9.fl)) != Boolean.FALSE)
          {
            localframe9.fc = Boolean.FALSE;
            boolean bool1 = localframe9.lambda19isEndOfFormat();
            if (!bool1) {
              continue;
            }
            if (bool1)
            {
              localBoolean9 = Boolean.TRUE;
              localObject6 = localBoolean9;
              return localObject6;
            }
          }
          else
          {
            localObject4 = localframe9.format$Mnstring;
          }
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-ref", 1, localObject2);
        }
        try
        {
          localCharSequence3 = (CharSequence)localObject4;
          localObject5 = localframe9.pos;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 1, localObject4);
        }
        try
        {
          j = ((Number)localObject5).intValue();
          localframe9.fc = Char.make(strings.stringRef(localCharSequence3, j));
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "string-ref", 2, localObject5);
        }
        localBoolean9 = Boolean.FALSE;
        continue;
        if (Scheme.isEqv.apply2(Lit18, localframe9.fc) != Boolean.FALSE)
        {
          localframe9.lambda18mustAdvance();
          localObject71 = localframe9.fc;
          localObject72 = Scheme.isEqv.apply2(localObject71, Lit19);
          if (localObject72 != Boolean.FALSE)
          {
            if (localObject72 != Boolean.FALSE)
            {
              localObject75 = Scheme.applyToArgs.apply2(localframe9.out, Lit21);
              if (localObject75 == Boolean.FALSE) {
                continue;
              }
              localObject3 = localframe10.args;
            }
          }
          else {
            if (Scheme.isEqv.apply2(localObject71, Lit20) != Boolean.FALSE) {
              continue;
            }
          }
          localObject73 = Scheme.isEqv.apply2(localObject71, Lit22);
          if (localObject73 != Boolean.FALSE)
          {
            if (localObject73 != Boolean.FALSE) {
              localObject75 = Scheme.applyToArgs.apply2(localframe9.out, Lit24);
            }
          }
          else {
            if (Scheme.isEqv.apply2(localObject71, Lit23) != Boolean.FALSE) {
              continue;
            }
          }
          localObject74 = Scheme.isEqv.apply2(localObject71, Lit25);
          if (localObject74 != Boolean.FALSE)
          {
            if (localObject74 != Boolean.FALSE) {
              localObject75 = Scheme.applyToArgs.apply2(localframe9.out, Lit27);
            }
          }
          else {
            if (Scheme.isEqv.apply2(localObject71, Lit26) != Boolean.FALSE) {
              continue;
            }
          }
          if (Scheme.isEqv.apply2(localObject71, Lit21) != Boolean.FALSE)
          {
            localObject75 = Boolean.TRUE;
          }
          else
          {
            localObject75 = Scheme.applyToArgs.apply2(localframe9.out, localframe9.fc);
            continue;
            return localObject75;
          }
        }
        else if (Scheme.isEqv.apply2(Lit28, localframe9.fc) != Boolean.FALSE)
        {
          localframe9.lambda18mustAdvance();
          localBoolean1 = Boolean.FALSE;
          localBoolean2 = Boolean.FALSE;
          localBoolean3 = Boolean.FALSE;
          localBoolean4 = Boolean.FALSE;
          localBoolean5 = Boolean.FALSE;
          localIntNum2 = Lit1;
          localframe10.precision = Lit17;
          localframe10.width = localIntNum2;
          localframe10.leading$Mn0s = localBoolean5;
          localframe10.alternate$Mnform = localBoolean4;
          localframe10.blank = localBoolean3;
          localframe10.signed = localBoolean2;
          localframe10.left$Mnadjust = localBoolean1;
          localframe10.pad = localframe10.pad;
          localObject7 = localframe9.fc;
          if (Scheme.isEqv.apply2(localObject7, Lit5) != Boolean.FALSE)
          {
            localframe10.left$Mnadjust = Boolean.TRUE;
            localframe9.lambda18mustAdvance();
            continue;
          }
          if (Scheme.isEqv.apply2(localObject7, Lit6) != Boolean.FALSE)
          {
            localframe10.signed = Boolean.TRUE;
            continue;
          }
          if (Scheme.isEqv.apply2(localObject7, Lit29) != Boolean.FALSE)
          {
            localframe10.blank = Boolean.TRUE;
            continue;
          }
          if (Scheme.isEqv.apply2(localObject7, Lit8) != Boolean.FALSE)
          {
            localframe10.alternate$Mnform = Boolean.TRUE;
            continue;
          }
          if (Scheme.isEqv.apply2(localObject7, Lit9) != Boolean.FALSE)
          {
            localframe10.leading$Mn0s = Boolean.TRUE;
            continue;
          }
          if (localframe10.left$Mnadjust != Boolean.FALSE) {
            localframe10.leading$Mn0s = Boolean.FALSE;
          }
          if (localframe10.signed != Boolean.FALSE) {
            localframe10.blank = Boolean.FALSE;
          }
          localframe10.width = localframe10.lambda22readFormatNumber();
          localObject8 = localframe10.width;
        }
        try
        {
          RealNum localRealNum1 = LangObjType.coerceRealNum(localObject8);
          if (numbers.isNegative(localRealNum1))
          {
            localframe10.left$Mnadjust = Boolean.TRUE;
            localframe10.width = AddOp.$Mn.apply1(localframe10.width);
          }
          if (Scheme.isEqv.apply2(Lit11, localframe9.fc) != Boolean.FALSE)
          {
            localframe9.lambda18mustAdvance();
            localframe10.precision = localframe10.lambda22readFormatNumber();
          }
          localObject9 = localframe9.fc;
          Object localObject10 = Scheme.isEqv.apply2(localObject9, Lit30);
          if (localObject10 != Boolean.FALSE)
          {
            if (localObject10 != Boolean.FALSE) {
              localframe9.lambda18mustAdvance();
            }
            if (lists.isNull(localframe10.args)) {
              localObject70 = localframe9.fc;
            }
          }
        }
        catch (ClassCastException localClassCastException5)
        {
          Object localObject9;
          Char localChar3;
          Object localObject12;
          Object localObject13;
          Object localObject69;
          Object[] arrayOfObject1;
          Object localObject14;
          Symbol localSymbol2;
          RealNum localRealNum6;
          boolean bool3;
          CharSequence localCharSequence7;
          int i2;
          NumberCompare localNumberCompare3;
          Object localObject62;
          CharSequence localCharSequence8;
          Object localObject41;
          Boolean localBoolean6;
          Boolean localBoolean7;
          Object localObject42;
          RealNum localRealNum5;
          ModuleMethod localModuleMethod;
          Object localObject44;
          RealNum localRealNum4;
          ApplyToArgs localApplyToArgs3;
          Object localObject54;
          int i1;
          NumberCompare localNumberCompare2;
          Object localObject60;
          throw new WrongType(localClassCastException5, "negative?", 1, localObject8);
        }
        try
        {
          localChar3 = (Char)localObject70;
          if (lists.memv(unicode.charDowncase(localChar3), Lit33) != Boolean.FALSE)
          {
            SimpleSymbol localSimpleSymbol = Lit34;
            Object[] arrayOfObject2 = new Object[3];
            arrayOfObject2[0] = "wrong number of arguments";
            arrayOfObject2[1] = Integer.valueOf(lists.length(localframe9.args));
            arrayOfObject2[2] = localframe9.format$Mnstring;
            misc.error$V(localSimpleSymbol, arrayOfObject2);
          }
          localObject12 = localframe9.fc;
          localObject13 = Scheme.isEqv.apply2(localObject12, Lit35);
          if (localObject13 != Boolean.FALSE)
          {
            if (localObject13 != Boolean.FALSE)
            {
              ApplyToArgs localApplyToArgs4 = Scheme.applyToArgs;
              Object localObject68 = localframe9.out;
              localObject69 = lists.car.apply1(localframe10.args);
              if (!(localObject69 instanceof Object[])) {
                continue;
              }
              arrayOfObject1 = (Object[])localObject69;
              localObject6 = localApplyToArgs4.apply2(localObject68, strings.$make$string$(arrayOfObject1));
              if (localObject6 == Boolean.FALSE) {
                continue;
              }
              localObject3 = lists.cdr.apply1(localframe10.args);
              continue;
              Object localObject11 = Scheme.isEqv.apply2(localObject9, Lit31);
              if (localObject11 != Boolean.FALSE)
              {
                if (localObject11 == Boolean.FALSE) {
                  continue;
                }
                continue;
              }
              if (Scheme.isEqv.apply2(localObject9, Lit32) == Boolean.FALSE) {
                continue;
              }
              continue;
            }
          }
          else {
            if (Scheme.isEqv.apply2(localObject12, Lit36) != Boolean.FALSE) {
              continue;
            }
          }
          localObject14 = Scheme.isEqv.apply2(localObject12, Lit37);
          if (localObject14 != Boolean.FALSE)
          {
            if (localObject14 == Boolean.FALSE) {
              continue;
            }
            if (!misc.isSymbol(lists.car.apply1(localframe10.args))) {
              continue;
            }
            localObject67 = lists.car.apply1(localframe10.args);
          }
        }
        catch (ClassCastException localClassCastException30)
        {
          throw new WrongType(localClassCastException30, "char-downcase", 1, localObject70);
        }
        try
        {
          localSymbol2 = (Symbol)localObject67;
          localObject58 = misc.symbol$To$String(localSymbol2);
          localObject59 = localframe10.precision;
        }
        catch (ClassCastException localClassCastException29)
        {
          throw new WrongType(localClassCastException29, "symbol->string", 1, localObject67);
        }
        try
        {
          localRealNum6 = LangObjType.coerceRealNum(localObject59);
          bool3 = numbers.isNegative(localRealNum6);
          if (bool3) {
            if (bool3) {}
          }
        }
        catch (ClassCastException localClassCastException20)
        {
          throw new WrongType(localClassCastException20, "negative?", 1, localObject59);
        }
        try
        {
          localCharSequence7 = (CharSequence)localObject58;
          localObject61 = localframe10.precision;
        }
        catch (ClassCastException localClassCastException22)
        {
          throw new WrongType(localClassCastException22, "substring", 1, localObject58);
        }
        try
        {
          i2 = ((Number)localObject61).intValue();
          localObject58 = strings.substring(localCharSequence7, 0, i2);
          localNumberCompare3 = Scheme.numLEq;
          localObject62 = localframe10.width;
        }
        catch (ClassCastException localClassCastException23)
        {
          throw new WrongType(localClassCastException23, "substring", 3, localObject61);
        }
        try
        {
          localCharSequence8 = (CharSequence)localObject58;
          if (localNumberCompare3.apply2(localObject62, Integer.valueOf(strings.stringLength(localCharSequence8))) != Boolean.FALSE)
          {
            localObject6 = localframe9.lambda21out$St(localObject58);
            if (localObject6 == Boolean.FALSE) {
              continue;
            }
            localObject3 = lists.cdr.apply1(localframe10.args);
            continue;
            arrayOfObject1 = new Object[] { localObject69 };
            continue;
            if (Scheme.isEqv.apply2(localObject12, Lit38) != Boolean.FALSE) {
              continue;
            }
            Object localObject15 = Scheme.isEqv.apply2(localObject12, Lit39);
            if (localObject15 == Boolean.FALSE) {
              continue;
            }
            if (localObject15 == Boolean.FALSE) {
              continue;
            }
            localframe10.pr = localframe10.precision;
            localframe10.os = "";
            localObject41 = lists.car.apply1(localframe10.args);
            if (localframe10.alternate$Mnform == Boolean.FALSE) {
              continue;
            }
            localBoolean6 = Boolean.FALSE;
            localBoolean7 = Boolean.FALSE;
            localObject42 = localframe10.left$Mnadjust;
            if (localObject42 == Boolean.FALSE) {
              continue;
            }
            localObject57 = localframe10.pr;
          }
        }
        catch (ClassCastException localClassCastException24)
        {
          throw new WrongType(localClassCastException24, "string-length", 1, localObject58);
        }
        try
        {
          localRealNum5 = LangObjType.coerceRealNum(localObject57);
          if (numbers.isNegative(localRealNum5))
          {
            localframe10.pr = Lit1;
            localModuleMethod = localframe10.lambda$Fn13;
            genwrite.genericWrite(localObject41, localBoolean6, localBoolean7, localModuleMethod);
            localObject44 = localframe10.left$Mnadjust;
            if (localObject44 == Boolean.FALSE) {
              continue;
            }
            localObject56 = localframe10.precision;
          }
        }
        catch (ClassCastException localClassCastException19)
        {
          throw new WrongType(localClassCastException19, "negative?", 1, localObject57);
        }
        try
        {
          localRealNum4 = LangObjType.coerceRealNum(localObject56);
          if (numbers.isNegative(localRealNum4)) {
            if (Scheme.numGrt.apply2(localframe10.width, localframe10.pr) != Boolean.FALSE)
            {
              localApplyToArgs3 = Scheme.applyToArgs;
              localObject54 = localframe9.out;
              localObject55 = AddOp.$Mn.apply2(localframe10.width, localframe10.pr);
            }
          }
        }
        catch (ClassCastException localClassCastException18)
        {
          throw new WrongType(localClassCastException18, "negative?", 1, localObject56);
        }
        try
        {
          i1 = ((Number)localObject55).intValue();
          localApplyToArgs3.apply2(localObject54, strings.makeString(i1, Lit29));
          localObject3 = lists.cdr.apply1(localframe10.args);
        }
        catch (ClassCastException localClassCastException17)
        {
          throw new WrongType(localClassCastException17, "make-string", 1, localObject55);
        }
        if (lists.car.apply1(localframe10.args) == Boolean.FALSE)
        {
          localObject58 = "(NULL)";
        }
        else
        {
          localObject58 = lists.car.apply1(localframe10.args);
          continue;
          localNumberCompare2 = Scheme.numGEq;
          localObject60 = localframe10.precision;
        }
        try
        {
          CharSequence localCharSequence6 = (CharSequence)localObject58;
          if (localNumberCompare2.apply2(localObject60, Integer.valueOf(strings.stringLength(localCharSequence6))) != Boolean.FALSE) {
            continue;
          }
        }
        catch (ClassCastException localClassCastException21)
        {
          AddOp localAddOp3;
          Object localObject65;
          throw new WrongType(localClassCastException21, "string-length", 1, localObject58);
        }
        if (localframe10.left$Mnadjust != Boolean.FALSE)
        {
          localAddOp3 = AddOp.$Mn;
          localObject65 = localframe10.width;
        }
        try
        {
          CharSequence localCharSequence10 = (CharSequence)localObject58;
          localObject66 = localAddOp3.apply2(localObject65, Integer.valueOf(strings.stringLength(localCharSequence10)));
        }
        catch (ClassCastException localClassCastException27)
        {
          int i4;
          AddOp localAddOp2;
          Object localObject63;
          throw new WrongType(localClassCastException27, "string-length", 1, localObject58);
        }
        try
        {
          i4 = ((Number)localObject66).intValue();
          localObject58 = LList.list2(localObject58, strings.makeString(i4, Lit29));
        }
        catch (ClassCastException localClassCastException28)
        {
          throw new WrongType(localClassCastException28, "make-string", 1, localObject66);
        }
        localAddOp2 = AddOp.$Mn;
        localObject63 = localframe10.width;
        try
        {
          CharSequence localCharSequence9 = (CharSequence)localObject58;
          localObject64 = localAddOp2.apply2(localObject63, Integer.valueOf(strings.stringLength(localCharSequence9)));
        }
        catch (ClassCastException localClassCastException25)
        {
          int i3;
          Char localChar2;
          Object localObject16;
          RealNum localRealNum3;
          ApplyToArgs localApplyToArgs2;
          Object localObject52;
          throw new WrongType(localClassCastException25, "string-length", 1, localObject58);
        }
        try
        {
          i3 = ((Number)localObject64).intValue();
          if (localframe10.leading$Mn0s != Boolean.FALSE)
          {
            localChar2 = Lit9;
            localObject58 = LList.list2(strings.makeString(i3, localChar2), localObject58);
            continue;
          }
          localChar2 = Lit29;
          continue;
          if (Scheme.isEqv.apply2(localObject12, Lit40) != Boolean.FALSE) {
            continue;
          }
          localObject16 = Scheme.isEqv.apply2(localObject12, Lit12);
          if (localObject16 != Boolean.FALSE)
          {
            if (localObject16 == Boolean.FALSE) {
              continue;
            }
            localObject6 = localframe9.lambda21out$St(localframe10.lambda24integerConvert(lists.car.apply1(localframe10.args), Lit45, Boolean.FALSE));
            if (localObject6 == Boolean.FALSE) {
              continue;
            }
            localObject3 = lists.cdr.apply1(localframe10.args);
            continue;
            localBoolean6 = Boolean.TRUE;
            continue;
            if (localObject42 != Boolean.FALSE) {
              continue;
            }
            if (localframe10.left$Mnadjust != Boolean.FALSE)
            {
              localModuleMethod = localframe10.lambda$Fn14;
              continue;
            }
            localObject43 = localframe10.pr;
          }
        }
        catch (ClassCastException localClassCastException26)
        {
          throw new WrongType(localClassCastException26, "make-string", 1, localObject64);
        }
        try
        {
          localRealNum3 = LangObjType.coerceRealNum(localObject43);
          if (numbers.isNegative(localRealNum3))
          {
            localframe10.pr = localframe10.width;
            localModuleMethod = localframe10.lambda$Fn15;
            continue;
          }
          localModuleMethod = localframe10.lambda$Fn16;
        }
        catch (ClassCastException localClassCastException11)
        {
          throw new WrongType(localClassCastException11, "negative?", 1, localObject43);
        }
        if (localObject44 == Boolean.FALSE) {
          if (localframe10.left$Mnadjust != Boolean.FALSE)
          {
            if (Scheme.numGrt.apply2(localframe10.width, AddOp.$Mn.apply2(localframe10.precision, localframe10.pr)) == Boolean.FALSE) {
              continue;
            }
            localApplyToArgs2 = Scheme.applyToArgs;
            localObject52 = localframe9.out;
            localObject53 = AddOp.$Mn.apply2(localframe10.width, AddOp.$Mn.apply2(localframe10.precision, localframe10.pr));
          }
        }
        try
        {
          int n = ((Number)localObject53).intValue();
          localApplyToArgs2.apply2(localObject52, strings.makeString(n, Lit29));
        }
        catch (ClassCastException localClassCastException16)
        {
          throw new WrongType(localClassCastException16, "make-string", 1, localObject53);
        }
        localObject45 = localframe10.os;
        try
        {
          Boolean localBoolean8 = Boolean.FALSE;
          if (localObject45 != localBoolean8)
          {
            k = 1;
            if ((0x1 & k + 1) != 0) {
              continue;
            }
            localNumberCompare1 = Scheme.numLEq;
            localObject46 = localframe10.width;
            localObject47 = localframe10.os;
          }
        }
        catch (ClassCastException localClassCastException12)
        {
          int k;
          NumberCompare localNumberCompare1;
          Object localObject46;
          CharSequence localCharSequence4;
          ApplyToArgs localApplyToArgs1;
          Object localObject48;
          AddOp localAddOp1;
          Object localObject49;
          CharSequence localCharSequence5;
          int m;
          Object localObject17;
          Object localObject21;
          Object localObject18;
          Object localObject19;
          Object localObject20;
          Object localObject39;
          IntNum localIntNum4;
          Object localObject40;
          Object localObject37;
          IntNum localIntNum3;
          Object localObject38;
          Object localObject22;
          Object localObject23;
          Object localObject31;
          frame11 localframe11;
          throw new WrongType(localClassCastException12, "x", -2, localObject45);
        }
        try
        {
          localCharSequence4 = (CharSequence)localObject47;
          if (localNumberCompare1.apply2(localObject46, Integer.valueOf(strings.stringLength(localCharSequence4))) != Boolean.FALSE)
          {
            Scheme.applyToArgs.apply2(localframe9.out, localframe10.os);
            continue;
            k = 0;
            continue;
          }
          localApplyToArgs1 = Scheme.applyToArgs;
          localObject48 = localframe9.out;
          localAddOp1 = AddOp.$Mn;
          localObject49 = localframe10.width;
          localObject50 = localframe10.os;
        }
        catch (ClassCastException localClassCastException13)
        {
          throw new WrongType(localClassCastException13, "string-length", 1, localObject47);
        }
        try
        {
          localCharSequence5 = (CharSequence)localObject50;
          localObject51 = localAddOp1.apply2(localObject49, Integer.valueOf(strings.stringLength(localCharSequence5)));
        }
        catch (ClassCastException localClassCastException14)
        {
          throw new WrongType(localClassCastException14, "string-length", 1, localObject50);
        }
        try
        {
          m = ((Number)localObject51).intValue();
          if (localApplyToArgs1.apply2(localObject48, strings.makeString(m, Lit29)) == Boolean.FALSE) {
            continue;
          }
          Scheme.applyToArgs.apply2(localframe9.out, localframe10.os);
        }
        catch (ClassCastException localClassCastException15)
        {
          throw new WrongType(localClassCastException15, "make-string", 1, localObject51);
        }
        localObject17 = Scheme.isEqv.apply2(localObject12, Lit41);
        if (localObject17 != Boolean.FALSE)
        {
          if (localObject17 != Boolean.FALSE) {
            continue;
          }
          localObject21 = Scheme.isEqv.apply2(localObject12, Lit46);
          if (localObject21 != Boolean.FALSE)
          {
            if (localObject21 == Boolean.FALSE) {
              continue;
            }
            localObject6 = localframe9.lambda21out$St(localframe10.lambda24integerConvert(lists.car.apply1(localframe10.args), Lit48, Boolean.FALSE));
            if (localObject6 == Boolean.FALSE) {
              continue;
            }
            localObject3 = lists.cdr.apply1(localframe10.args);
          }
        }
        else
        {
          localObject18 = Scheme.isEqv.apply2(localObject12, Lit3);
          if (localObject18 != Boolean.FALSE)
          {
            if (localObject18 == Boolean.FALSE) {
              continue;
            }
            continue;
          }
          localObject19 = Scheme.isEqv.apply2(localObject12, Lit42);
          if (localObject19 != Boolean.FALSE)
          {
            if (localObject19 == Boolean.FALSE) {
              continue;
            }
            continue;
          }
          localObject20 = Scheme.isEqv.apply2(localObject12, Lit43);
          if (localObject20 != Boolean.FALSE)
          {
            if (localObject20 == Boolean.FALSE) {
              continue;
            }
            continue;
          }
          if (Scheme.isEqv.apply2(localObject12, Lit44) == Boolean.FALSE) {
            continue;
          }
          continue;
        }
        if (Scheme.isEqv.apply2(localObject12, Lit47) == Boolean.FALSE) {
          if (Scheme.isEqv.apply2(localObject12, Lit49) != Boolean.FALSE)
          {
            localObject39 = lists.car.apply1(localframe10.args);
            localIntNum4 = Lit50;
            if (stdio$Clhex$Mnupper$Mncase$Qu)
            {
              localObject40 = unicode.string$Mndowncase;
              localObject6 = localframe9.lambda21out$St(localframe10.lambda24integerConvert(localObject39, localIntNum4, localObject40));
              if (localObject6 != Boolean.FALSE) {
                localObject3 = lists.cdr.apply1(localframe10.args);
              }
            }
            else
            {
              localObject40 = Boolean.FALSE;
            }
          }
          else if (Scheme.isEqv.apply2(localObject12, Lit51) != Boolean.FALSE)
          {
            localObject37 = lists.car.apply1(localframe10.args);
            localIntNum3 = Lit50;
            if (stdio$Clhex$Mnupper$Mncase$Qu)
            {
              localObject38 = Boolean.FALSE;
              localObject6 = localframe9.lambda21out$St(localframe10.lambda24integerConvert(localObject37, localIntNum3, localObject38));
              if (localObject6 != Boolean.FALSE) {
                localObject3 = lists.cdr.apply1(localframe10.args);
              }
            }
            else
            {
              localObject38 = unicode.string$Mnupcase;
            }
          }
          else
          {
            localObject22 = Scheme.isEqv.apply2(localObject12, Lit52);
            if (localObject22 != Boolean.FALSE)
            {
              if (localObject22 != Boolean.FALSE)
              {
                localObject6 = localframe9.lambda21out$St(localframe10.lambda24integerConvert(lists.car.apply1(localframe10.args), Lit14, Boolean.FALSE));
                if (localObject6 == Boolean.FALSE) {
                  continue;
                }
                localObject3 = lists.cdr.apply1(localframe10.args);
              }
            }
            else {
              if (Scheme.isEqv.apply2(localObject12, Lit53) != Boolean.FALSE) {
                continue;
              }
            }
            if (Scheme.isEqv.apply2(localObject12, Lit28) != Boolean.FALSE)
            {
              localObject6 = Scheme.applyToArgs.apply2(localframe9.out, Lit28);
              if (localObject6 != Boolean.FALSE) {
                localObject3 = localframe10.args;
              }
            }
            else
            {
              localObject23 = Scheme.isEqv.apply2(localObject12, Lit25);
              if (localObject23 != Boolean.FALSE)
              {
                if (localObject23 == Boolean.FALSE) {
                  continue;
                }
                localObject30 = lists.car.apply1(localframe10.args);
                localObject31 = localframe9.fc;
                localframe11 = new frame11();
                localframe11.staticLink = localframe10;
                localframe11.fc = localObject31;
                localObject32 = localframe10.precision;
              }
            }
          }
        }
        try
        {
          RealNum localRealNum2 = LangObjType.coerceRealNum(localObject32);
          if (numbers.isNegative(localRealNum2))
          {
            localframe10.precision = Lit59;
            if (!numbers.isNumber(localObject30)) {
              continue;
            }
          }
        }
        catch (ClassCastException localClassCastException6)
        {
          Number localNumber2;
          Object localObject34;
          Object localObject35;
          throw new WrongType(localClassCastException6, "negative?", 1, localObject32);
        }
        try
        {
          localNumber2 = (Number)localObject30;
          localObject34 = numbers.number$To$String(numbers.exact$To$Inexact(localNumber2));
          localframe11.format$Mnreal = localframe11.format$Mnreal;
          localObject35 = stdio$ClParseFloat(localObject34, localframe11.lambda$Fn17);
          if (localObject35 != Boolean.FALSE)
          {
            localObject6 = localframe9.lambda21out$St(localObject35);
            if (localObject6 == Boolean.FALSE) {
              continue;
            }
            localObject3 = lists.cdr.apply1(localframe10.args);
            continue;
            Object localObject24 = Scheme.isEqv.apply2(localObject12, Lit26);
            if (localObject24 != Boolean.FALSE)
            {
              if (localObject24 != Boolean.FALSE) {
                continue;
              }
              if (!localframe9.lambda19isEndOfFormat()) {
                continue;
              }
              return localframe9.lambda20incomplete();
            }
            Object localObject25 = Scheme.isEqv.apply2(localObject12, Lit13);
            if (localObject25 != Boolean.FALSE)
            {
              if (localObject25 == Boolean.FALSE) {
                continue;
              }
              continue;
            }
            Object localObject26 = Scheme.isEqv.apply2(localObject12, Lit54);
            if (localObject26 != Boolean.FALSE)
            {
              if (localObject26 == Boolean.FALSE) {
                continue;
              }
              continue;
            }
            Object localObject27 = Scheme.isEqv.apply2(localObject12, Lit55);
            if (localObject27 != Boolean.FALSE)
            {
              if (localObject27 == Boolean.FALSE) {
                continue;
              }
              continue;
            }
            Object localObject28 = Scheme.isEqv.apply2(localObject12, Lit56);
            if (localObject28 != Boolean.FALSE)
            {
              if (localObject28 == Boolean.FALSE) {
                continue;
              }
              continue;
            }
            Object localObject29 = Scheme.isEqv.apply2(localObject12, Lit57);
            if (localObject29 != Boolean.FALSE)
            {
              if (localObject29 == Boolean.FALSE) {
                continue;
              }
              continue;
            }
            if (Scheme.isEqv.apply2(localObject12, Lit58) == Boolean.FALSE) {
              continue;
            }
            continue;
            localObject33 = localframe10.precision;
          }
          try
          {
            Number localNumber1 = (Number)localObject33;
            bool2 = numbers.isZero(localNumber1);
            if (bool2) {
              localObject36 = localframe11.fc;
            }
          }
          catch (ClassCastException localClassCastException7)
          {
            boolean bool2;
            Char localChar1;
            Symbol localSymbol1;
            throw new WrongType(localClassCastException7, "zero?", 1, localObject33);
          }
          try
          {
            localChar1 = (Char)localObject36;
            if (!unicode.isCharCi$Eq(localChar1, Lit55)) {
              continue;
            }
            localframe10.precision = Lit7;
          }
          catch (ClassCastException localClassCastException10)
          {
            throw new WrongType(localClassCastException10, "char-ci=?", 1, localObject36);
          }
          if (!bool2) {
            continue;
          }
          continue;
          if (strings.isString(localObject30))
          {
            localObject34 = localObject30;
            continue;
          }
          if (!misc.isSymbol(localObject30)) {}
        }
        catch (ClassCastException localClassCastException9)
        {
          throw new WrongType(localClassCastException9, "exact->inexact", 1, localObject30);
        }
        try
        {
          localSymbol1 = (Symbol)localObject30;
          localObject34 = misc.symbol$To$String(localSymbol1);
        }
        catch (ClassCastException localClassCastException8)
        {
          throw new WrongType(localClassCastException8, "symbol->string", 1, localObject30);
        }
        localObject34 = "???";
        continue;
        localObject35 = localframe10.lambda23pad$V("???", new Object[0]);
        continue;
        localObject6 = Scheme.applyToArgs.apply2(localframe9.out, Lit28);
        if (localObject6 != Boolean.FALSE)
        {
          localObject6 = Scheme.applyToArgs.apply2(localframe9.out, localframe9.fc);
          if (localObject6 != Boolean.FALSE)
          {
            localObject6 = Scheme.applyToArgs.apply2(localframe9.out, Lit65);
            if (localObject6 != Boolean.FALSE)
            {
              localObject3 = localframe10.args;
              continue;
              localObject6 = Scheme.applyToArgs.apply2(localframe9.out, localframe9.fc);
              if (localObject6 != Boolean.FALSE) {
                localObject3 = localframe10.args;
              }
            }
          }
        }
      }
    }
    return Values.empty;
  }
  
  public static Object stdio$ClParseFloat(Object paramObject1, Object paramObject2)
  {
    frame localframe = new frame();
    localframe.str = paramObject1;
    localframe.proc = paramObject2;
    Object localObject = localframe.str;
    try
    {
      CharSequence localCharSequence = (CharSequence)localObject;
      localframe.n = strings.stringLength(localCharSequence);
      return localframe.lambda4real(Lit1, localframe.lambda$Fn1);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "string-length", 1, localObject);
    }
  }
  
  /* Error */
  public static Object stdio$ClRoundString(CharSequence paramCharSequence, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: new 801	gnu/kawa/slib/printf$frame8
    //   3: dup
    //   4: invokespecial 802	gnu/kawa/slib/printf$frame8:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: putfield 805	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   13: iconst_m1
    //   14: aload_3
    //   15: getfield 805	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   18: invokestatic 454	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   21: iadd
    //   22: istore 4
    //   24: getstatic 808	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   27: aload_1
    //   28: getstatic 354	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
    //   31: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   34: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   37: if_acmpeq +107 -> 144
    //   40: ldc 179
    //   42: astore 9
    //   44: aload_2
    //   45: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   48: if_acmpeq +93 -> 141
    //   51: aload 9
    //   53: checkcast 450	java/lang/CharSequence
    //   56: astore 31
    //   58: iconst_m1
    //   59: aload 31
    //   61: invokestatic 454	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   64: iadd
    //   65: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: astore 32
    //   70: getstatic 670	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   73: aload 32
    //   75: aload_2
    //   76: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   79: astore 33
    //   81: aload 33
    //   83: checkcast 483	java/lang/Boolean
    //   86: invokevirtual 811	java/lang/Boolean:booleanValue	()Z
    //   89: istore 35
    //   91: iload 35
    //   93: ifeq +587 -> 680
    //   96: iload 35
    //   98: ifeq +622 -> 720
    //   101: aload 9
    //   103: checkcast 450	java/lang/CharSequence
    //   106: astore 42
    //   108: getstatic 563	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   111: aload 32
    //   113: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   116: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: astore 43
    //   121: aload 43
    //   123: checkcast 473	java/lang/Number
    //   126: invokevirtual 477	java/lang/Number:intValue	()I
    //   129: istore 45
    //   131: aload 42
    //   133: iconst_0
    //   134: iload 45
    //   136: invokestatic 506	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   139: astore 9
    //   141: aload 9
    //   143: areturn
    //   144: getstatic 814	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   147: iload 4
    //   149: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aload_1
    //   153: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   159: if_acmpeq +12 -> 171
    //   162: aload_3
    //   163: getfield 805	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   166: astore 9
    //   168: goto -124 -> 44
    //   171: getstatic 808	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   174: iload 4
    //   176: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: aload_1
    //   180: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   186: if_acmpeq +156 -> 342
    //   189: iconst_2
    //   190: anewarray 161	java/lang/Object
    //   193: astore 50
    //   195: aload 50
    //   197: iconst_0
    //   198: getstatic 354	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
    //   201: aastore
    //   202: getstatic 621	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   205: astore 51
    //   207: aload_2
    //   208: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   211: if_acmpeq +5 -> 216
    //   214: aload_2
    //   215: astore_1
    //   216: aload 50
    //   218: iconst_1
    //   219: aload 51
    //   221: aload_1
    //   222: iload 4
    //   224: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   230: aastore
    //   231: aload 50
    //   233: invokestatic 818	kawa/lib/numbers:max	([Ljava/lang/Object;)Ljava/lang/Object;
    //   236: astore 52
    //   238: aload 52
    //   240: checkcast 473	java/lang/Number
    //   243: astore 54
    //   245: aload 54
    //   247: invokestatic 751	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   250: ifeq +16 -> 266
    //   253: aload_3
    //   254: getfield 805	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   257: astore 59
    //   259: aload 59
    //   261: astore 9
    //   263: goto -219 -> 44
    //   266: iconst_2
    //   267: anewarray 161	java/lang/Object
    //   270: astore 55
    //   272: aload 55
    //   274: iconst_0
    //   275: aload_3
    //   276: getfield 805	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   279: aastore
    //   280: aload 52
    //   282: checkcast 473	java/lang/Number
    //   285: invokevirtual 477	java/lang/Number:intValue	()I
    //   288: istore 57
    //   290: aload_3
    //   291: getfield 805	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   294: iload 4
    //   296: invokestatic 538	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   299: invokestatic 133	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   302: invokestatic 822	kawa/lib/rnrs/unicode:isCharNumeric	(Lgnu/text/Char;)Z
    //   305: ifeq +29 -> 334
    //   308: getstatic 338	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
    //   311: astore 58
    //   313: aload 55
    //   315: iconst_1
    //   316: iload 57
    //   318: aload 58
    //   320: invokestatic 693	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
    //   323: aastore
    //   324: aload 55
    //   326: invokestatic 826	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   329: astore 59
    //   331: goto -72 -> 259
    //   334: getstatic 340	gnu/kawa/slib/printf:Lit8	Lgnu/text/Char;
    //   337: astore 58
    //   339: goto -26 -> 313
    //   342: aload_3
    //   343: getfield 805	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   346: astore 5
    //   348: getstatic 563	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   351: aload_1
    //   352: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   355: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   358: astore 6
    //   360: aload 6
    //   362: checkcast 473	java/lang/Number
    //   365: invokevirtual 477	java/lang/Number:intValue	()I
    //   368: istore 8
    //   370: aload 5
    //   372: iconst_0
    //   373: iload 8
    //   375: invokestatic 506	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   378: astore 9
    //   380: aload_3
    //   381: getstatic 563	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   384: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   387: aload_1
    //   388: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   391: invokevirtual 829	gnu/kawa/slib/printf$frame8:lambda17dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   394: astore 10
    //   396: getstatic 690	kawa/standard/Scheme:numGrt	Lgnu/kawa/functions/NumberCompare;
    //   399: aload 10
    //   401: getstatic 320	gnu/kawa/slib/printf:Lit15	Lgnu/math/IntNum;
    //   404: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   407: astore 11
    //   409: aload 11
    //   411: checkcast 483	java/lang/Boolean
    //   414: invokevirtual 811	java/lang/Boolean:booleanValue	()Z
    //   417: istore 13
    //   419: iload 13
    //   421: ifeq +92 -> 513
    //   424: iload 13
    //   426: ifeq -382 -> 44
    //   429: aload_1
    //   430: astore 17
    //   432: aload_3
    //   433: aload 17
    //   435: invokevirtual 829	gnu/kawa/slib/printf$frame8:lambda17dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   438: astore 18
    //   440: getstatic 808	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   443: aload 18
    //   445: getstatic 318	gnu/kawa/slib/printf:Lit16	Lgnu/math/IntNum;
    //   448: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   451: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   454: if_acmpeq +184 -> 638
    //   457: aload 9
    //   459: checkcast 831	gnu/lists/CharSeq
    //   462: astore 24
    //   464: aload 17
    //   466: checkcast 473	java/lang/Number
    //   469: invokevirtual 477	java/lang/Number:intValue	()I
    //   472: istore 26
    //   474: getstatic 563	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   477: aload 18
    //   479: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   482: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   485: astore 27
    //   487: aload 27
    //   489: checkcast 473	java/lang/Number
    //   492: astore 29
    //   494: aload 24
    //   496: iload 26
    //   498: aload 29
    //   500: invokestatic 735	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   503: iconst_0
    //   504: invokestatic 538	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   507: invokestatic 835	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   510: goto -466 -> 44
    //   513: getstatic 814	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   516: aload 10
    //   518: getstatic 320	gnu/kawa/slib/printf:Lit15	Lgnu/math/IntNum;
    //   521: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   524: astore 14
    //   526: aload 14
    //   528: checkcast 483	java/lang/Boolean
    //   531: invokevirtual 811	java/lang/Boolean:booleanValue	()Z
    //   534: istore 16
    //   536: iload 16
    //   538: ifeq +92 -> 630
    //   541: getstatic 563	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   544: getstatic 322	gnu/kawa/slib/printf:Lit14	Lgnu/math/IntNum;
    //   547: aload_1
    //   548: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   551: astore 46
    //   553: getstatic 690	kawa/standard/Scheme:numGrt	Lgnu/kawa/functions/NumberCompare;
    //   556: aload 46
    //   558: iload 4
    //   560: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   563: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   566: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   569: if_acmpeq +22 -> 591
    //   572: iconst_1
    //   573: aload_3
    //   574: aload_1
    //   575: invokevirtual 829	gnu/kawa/slib/printf$frame8:lambda17dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   578: checkcast 473	java/lang/Number
    //   581: invokevirtual 477	java/lang/Number:intValue	()I
    //   584: iand
    //   585: ifeq -541 -> 44
    //   588: goto -159 -> 429
    //   591: aload_3
    //   592: aload 46
    //   594: invokevirtual 829	gnu/kawa/slib/printf$frame8:lambda17dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   597: astore 47
    //   599: aload 47
    //   601: checkcast 473	java/lang/Number
    //   604: astore 49
    //   606: aload 49
    //   608: invokestatic 751	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   611: ifeq -182 -> 429
    //   614: getstatic 563	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   617: aload 46
    //   619: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   622: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   625: astore 46
    //   627: goto -74 -> 553
    //   630: iload 16
    //   632: ifeq -588 -> 44
    //   635: goto -206 -> 429
    //   638: aload 9
    //   640: checkcast 831	gnu/lists/CharSeq
    //   643: astore 20
    //   645: aload 17
    //   647: checkcast 473	java/lang/Number
    //   650: invokevirtual 477	java/lang/Number:intValue	()I
    //   653: istore 22
    //   655: aload 20
    //   657: iload 22
    //   659: bipush 48
    //   661: invokestatic 835	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   664: getstatic 621	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   667: aload 17
    //   669: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   672: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   675: astore 17
    //   677: goto -245 -> 432
    //   680: getstatic 338	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
    //   683: astore 36
    //   685: aload 9
    //   687: checkcast 450	java/lang/CharSequence
    //   690: astore 38
    //   692: aload 32
    //   694: checkcast 473	java/lang/Number
    //   697: invokevirtual 477	java/lang/Number:intValue	()I
    //   700: istore 40
    //   702: aload 36
    //   704: aload 38
    //   706: iload 40
    //   708: invokestatic 538	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   711: invokestatic 133	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   714: invokestatic 840	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   717: ifeq -616 -> 101
    //   720: getstatic 621	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   723: aload 32
    //   725: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   728: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   731: astore 32
    //   733: goto -663 -> 70
    //   736: astore 53
    //   738: new 508	gnu/mapping/WrongType
    //   741: dup
    //   742: aload 53
    //   744: ldc_w 778
    //   747: iconst_1
    //   748: aload 52
    //   750: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   753: athrow
    //   754: astore 56
    //   756: new 508	gnu/mapping/WrongType
    //   759: dup
    //   760: aload 56
    //   762: ldc_w 510
    //   765: iconst_1
    //   766: aload 52
    //   768: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   771: athrow
    //   772: astore 7
    //   774: new 508	gnu/mapping/WrongType
    //   777: dup
    //   778: aload 7
    //   780: ldc_w 516
    //   783: iconst_3
    //   784: aload 6
    //   786: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   789: athrow
    //   790: astore 12
    //   792: new 508	gnu/mapping/WrongType
    //   795: dup
    //   796: aload 12
    //   798: ldc_w 776
    //   801: bipush 254
    //   803: aload 11
    //   805: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   808: athrow
    //   809: astore 15
    //   811: new 508	gnu/mapping/WrongType
    //   814: dup
    //   815: aload 15
    //   817: ldc_w 776
    //   820: bipush 254
    //   822: aload 14
    //   824: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   827: athrow
    //   828: astore 48
    //   830: new 508	gnu/mapping/WrongType
    //   833: dup
    //   834: aload 48
    //   836: ldc_w 778
    //   839: iconst_1
    //   840: aload 47
    //   842: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   845: athrow
    //   846: astore 23
    //   848: new 508	gnu/mapping/WrongType
    //   851: dup
    //   852: aload 23
    //   854: ldc_w 842
    //   857: iconst_1
    //   858: aload 9
    //   860: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   863: athrow
    //   864: astore 25
    //   866: new 508	gnu/mapping/WrongType
    //   869: dup
    //   870: aload 25
    //   872: ldc_w 842
    //   875: iconst_2
    //   876: aload 17
    //   878: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   881: athrow
    //   882: astore 28
    //   884: new 508	gnu/mapping/WrongType
    //   887: dup
    //   888: aload 28
    //   890: ldc_w 844
    //   893: iconst_1
    //   894: aload 27
    //   896: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   899: athrow
    //   900: astore 19
    //   902: new 508	gnu/mapping/WrongType
    //   905: dup
    //   906: aload 19
    //   908: ldc_w 842
    //   911: iconst_1
    //   912: aload 9
    //   914: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   917: athrow
    //   918: astore 21
    //   920: new 508	gnu/mapping/WrongType
    //   923: dup
    //   924: aload 21
    //   926: ldc_w 842
    //   929: iconst_2
    //   930: aload 17
    //   932: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   935: athrow
    //   936: astore 30
    //   938: new 508	gnu/mapping/WrongType
    //   941: dup
    //   942: aload 30
    //   944: ldc_w 515
    //   947: iconst_1
    //   948: aload 9
    //   950: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   953: athrow
    //   954: astore 34
    //   956: new 508	gnu/mapping/WrongType
    //   959: dup
    //   960: aload 34
    //   962: ldc_w 776
    //   965: bipush 254
    //   967: aload 33
    //   969: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   972: athrow
    //   973: astore 37
    //   975: new 508	gnu/mapping/WrongType
    //   978: dup
    //   979: aload 37
    //   981: ldc_w 768
    //   984: iconst_1
    //   985: aload 9
    //   987: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   990: athrow
    //   991: astore 39
    //   993: new 508	gnu/mapping/WrongType
    //   996: dup
    //   997: aload 39
    //   999: ldc_w 768
    //   1002: iconst_2
    //   1003: aload 32
    //   1005: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1008: athrow
    //   1009: astore 41
    //   1011: new 508	gnu/mapping/WrongType
    //   1014: dup
    //   1015: aload 41
    //   1017: ldc_w 516
    //   1020: iconst_1
    //   1021: aload 9
    //   1023: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1026: athrow
    //   1027: astore 44
    //   1029: new 508	gnu/mapping/WrongType
    //   1032: dup
    //   1033: aload 44
    //   1035: ldc_w 516
    //   1038: iconst_3
    //   1039: aload 43
    //   1041: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1044: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1045	0	paramCharSequence	CharSequence
    //   0	1045	1	paramObject1	Object
    //   0	1045	2	paramObject2	Object
    //   7	585	3	localframe8	frame8
    //   22	537	4	i	int
    //   346	25	5	localCharSequence1	CharSequence
    //   358	427	6	localObject1	Object
    //   772	7	7	localClassCastException1	ClassCastException
    //   368	6	8	j	int
    //   42	980	9	localObject2	Object
    //   394	123	10	localObject3	Object
    //   407	397	11	localObject4	Object
    //   790	7	12	localClassCastException2	ClassCastException
    //   417	8	13	bool1	boolean
    //   524	299	14	localObject5	Object
    //   809	7	15	localClassCastException3	ClassCastException
    //   534	97	16	bool2	boolean
    //   430	501	17	localObject6	Object
    //   438	40	18	localObject7	Object
    //   900	7	19	localClassCastException4	ClassCastException
    //   643	13	20	localCharSeq1	CharSeq
    //   918	7	21	localClassCastException5	ClassCastException
    //   653	5	22	k	int
    //   846	7	23	localClassCastException6	ClassCastException
    //   462	33	24	localCharSeq2	CharSeq
    //   864	7	25	localClassCastException7	ClassCastException
    //   472	25	26	m	int
    //   485	410	27	localObject8	Object
    //   882	7	28	localClassCastException8	ClassCastException
    //   492	7	29	localNumber1	Number
    //   936	7	30	localClassCastException9	ClassCastException
    //   56	4	31	localCharSequence2	CharSequence
    //   68	936	32	localObject9	Object
    //   79	889	33	localObject10	Object
    //   954	7	34	localClassCastException10	ClassCastException
    //   89	8	35	bool3	boolean
    //   683	20	36	localChar1	Char
    //   973	7	37	localClassCastException11	ClassCastException
    //   690	15	38	localCharSequence3	CharSequence
    //   991	7	39	localClassCastException12	ClassCastException
    //   700	7	40	n	int
    //   1009	7	41	localClassCastException13	ClassCastException
    //   106	26	42	localCharSequence4	CharSequence
    //   119	921	43	localObject11	Object
    //   1027	7	44	localClassCastException14	ClassCastException
    //   129	6	45	i1	int
    //   551	75	46	localObject12	Object
    //   597	244	47	localObject13	Object
    //   828	7	48	localClassCastException15	ClassCastException
    //   604	3	49	localNumber2	Number
    //   193	39	50	arrayOfObject1	Object[]
    //   205	15	51	localAddOp	AddOp
    //   236	531	52	localObject14	Object
    //   736	7	53	localClassCastException16	ClassCastException
    //   243	3	54	localNumber3	Number
    //   270	55	55	arrayOfObject2	Object[]
    //   754	7	56	localClassCastException17	ClassCastException
    //   288	29	57	i2	int
    //   311	27	58	localChar2	Char
    //   257	73	59	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   238	245	736	java/lang/ClassCastException
    //   280	290	754	java/lang/ClassCastException
    //   360	370	772	java/lang/ClassCastException
    //   409	419	790	java/lang/ClassCastException
    //   526	536	809	java/lang/ClassCastException
    //   599	606	828	java/lang/ClassCastException
    //   457	464	846	java/lang/ClassCastException
    //   464	474	864	java/lang/ClassCastException
    //   487	494	882	java/lang/ClassCastException
    //   638	645	900	java/lang/ClassCastException
    //   645	655	918	java/lang/ClassCastException
    //   51	58	936	java/lang/ClassCastException
    //   81	91	954	java/lang/ClassCastException
    //   685	692	973	java/lang/ClassCastException
    //   692	702	991	java/lang/ClassCastException
    //   101	108	1009	java/lang/ClassCastException
    //   121	131	1027	java/lang/ClassCastException
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    if (paramModuleMethod.selector == 22) {
      return stdio$ClParseFloat(paramObject1, paramObject2);
    }
    return super.apply2(paramModuleMethod, paramObject1, paramObject2);
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramModuleMethod.selector == 23) {}
    try
    {
      CharSequence localCharSequence = (CharSequence)paramObject1;
      return stdio$ClRoundString(localCharSequence, paramObject2, paramObject3);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "stdio:round-string", 1, paramObject1);
    }
    return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
  }
  
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 24: 
      Object localObject6 = paramArrayOfObject[0];
      Object localObject7 = paramArrayOfObject[1];
      int m = -2 + paramArrayOfObject.length;
      Object[] arrayOfObject4 = new Object[m];
      for (;;)
      {
        m--;
        if (m < 0) {
          return stdio$ClIprintf$V(localObject6, localObject7, arrayOfObject4);
        }
        arrayOfObject4[m] = paramArrayOfObject[(m + 2)];
      }
    case 25: 
      Object localObject4 = paramArrayOfObject[0];
      Object localObject5 = paramArrayOfObject[1];
      int k = -2 + paramArrayOfObject.length;
      Object[] arrayOfObject3 = new Object[k];
      for (;;)
      {
        k--;
        if (k < 0) {
          return fprintf$V(localObject4, localObject5, arrayOfObject3);
        }
        arrayOfObject3[k] = paramArrayOfObject[(k + 2)];
      }
    case 26: 
      Object localObject3 = paramArrayOfObject[0];
      int j = -1 + paramArrayOfObject.length;
      Object[] arrayOfObject2 = new Object[j];
      for (;;)
      {
        j--;
        if (j < 0) {
          return printf$V(localObject3, arrayOfObject2);
        }
        arrayOfObject2[j] = paramArrayOfObject[(j + 1)];
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
        return sprintf$V(localObject1, localObject2, arrayOfObject1);
      }
      arrayOfObject1[i] = paramArrayOfObject[(i + 2)];
    }
  }
  
  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 22)
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
    if (paramModuleMethod.selector == 23)
    {
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
    }
    return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 27: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 26: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 25: 
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
    stdio$Clhex$Mnupper$Mncase$Qu = strings.isString$Eq("-F", numbers.number$To$String(Lit0, 16));
  }
  
  public class frame
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn1;
    int n;
    Object proc;
    Object str;
    
    public frame()
    {
      this$1 = new ModuleMethod(this, 12, null, 16388);
      this$1.setProperty("source-location", "printf.scm:106");
      this.lambda$Fn1 = this$1;
    }
    
    public static Boolean lambda1parseError()
    {
      return Boolean.FALSE;
    }
    
    public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      if (paramModuleMethod.selector == 12) {
        return lambda5(paramObject1, paramObject2, paramObject3, paramObject4);
      }
      return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
    }
    
    public Object lambda2sign(Object paramObject1, Object paramObject2)
    {
      if (Scheme.numLss.apply2(paramObject1, Integer.valueOf(this.n)) != Boolean.FALSE) {
        localObject1 = this.str;
      }
      try
      {
        localCharSequence = (CharSequence)localObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        CharSequence localCharSequence;
        int i;
        int j;
        Object localObject2;
        label81:
        throw new WrongType(localClassCastException1, "string-ref", 1, localObject1);
      }
      try
      {
        i = ((Number)paramObject1).intValue();
        j = strings.stringRef(localCharSequence, i);
        localObject2 = Scheme.isEqv.apply2(Char.make(j), printf.Lit5);
        if (localObject2 != Boolean.FALSE)
        {
          if (localObject2 != Boolean.FALSE) {
            return Scheme.applyToArgs.apply3(paramObject2, AddOp.$Pl.apply2(paramObject1, printf.Lit7), Char.make(j));
          }
        }
        else {
          if (Scheme.isEqv.apply2(Char.make(j), printf.Lit6) != Boolean.FALSE) {
            break label81;
          }
        }
        return Scheme.applyToArgs.apply3(paramObject2, paramObject1, printf.Lit6);
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-ref", 2, paramObject1);
      }
      return Values.empty;
    }
    
    public Object lambda3digits(Object paramObject1, Object paramObject2)
    {
      localObject1 = paramObject1;
      localObject2 = Scheme.numGEq.apply2(localObject1, Integer.valueOf(this.n));
      for (;;)
      {
        try
        {
          boolean bool1 = ((Boolean)localObject2).booleanValue();
          if (bool1)
          {
            if (bool1) {
              continue;
            }
            localObject1 = AddOp.$Pl.apply2(localObject1, printf.Lit7);
            break;
          }
          localObject3 = this.str;
        }
        catch (ClassCastException localClassCastException1)
        {
          try
          {
            CharSequence localCharSequence1;
            int i;
            boolean bool2;
            Char localChar;
            CharSequence localCharSequence2;
            int j;
            localCharSequence3 = (CharSequence)localObject5;
          }
          catch (ClassCastException localClassCastException6)
          {
            Object localObject3;
            Object localObject6;
            Object localObject4;
            Object localObject5;
            CharSequence localCharSequence3;
            int k;
            int m;
            throw new WrongType(localClassCastException6, "substring", 1, localObject5);
          }
          try
          {
            k = ((Number)paramObject1).intValue();
          }
          catch (ClassCastException localClassCastException7)
          {
            throw new WrongType(localClassCastException7, "substring", 2, paramObject1);
          }
          try
          {
            m = ((Number)localObject1).intValue();
            localObject6 = strings.substring(localCharSequence3, k, m);
          }
          catch (ClassCastException localClassCastException8)
          {
            throw new WrongType(localClassCastException8, "substring", 3, localObject1);
          }
          localClassCastException1 = localClassCastException1;
          throw new WrongType(localClassCastException1, "x", -2, localObject2);
        }
        try
        {
          localCharSequence1 = (CharSequence)localObject3;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-ref", 1, localObject3);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          bool2 = unicode.isCharNumeric(Char.make(strings.stringRef(localCharSequence1, i)));
          if (bool2)
          {
            if (bool2) {
              continue;
            }
            ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
            if (Scheme.numEqu.apply2(paramObject1, localObject1) != Boolean.FALSE)
            {
              localObject6 = "0";
              return localApplyToArgs.apply3(paramObject2, localObject1, localObject6);
            }
          }
          else
          {
            localChar = printf.Lit8;
            localObject4 = this.str;
          }
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 2, localObject1);
        }
        try
        {
          localCharSequence2 = (CharSequence)localObject4;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "string-ref", 1, localObject4);
        }
        try
        {
          j = ((Number)localObject1).intValue();
          if (!characters.isChar$Eq(localChar, Char.make(strings.stringRef(localCharSequence2, j)))) {}
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "string-ref", 2, localObject1);
        }
      }
      localObject5 = this.str;
    }
    
    public Object lambda4real(Object paramObject1, Object paramObject2)
    {
      printf.frame2 localframe2 = new printf.frame2();
      localframe2.staticLink = this;
      localframe2.cont = paramObject2;
      ModuleMethod localModuleMethod = localframe2.lambda$Fn5;
      for (;;)
      {
        Object localObject1 = Scheme.numLss.apply2(paramObject1, Integer.valueOf(-1 + this.n));
        try
        {
          bool = ((Boolean)localObject1).booleanValue();
          if (bool)
          {
            localChar = printf.Lit8;
            localObject6 = this.str;
          }
        }
        catch (ClassCastException localClassCastException1)
        {
          label269:
          try
          {
            localCharSequence2 = (CharSequence)localObject6;
          }
          catch (ClassCastException localClassCastException4)
          {
            boolean bool;
            Char localChar;
            Object localObject6;
            CharSequence localCharSequence2;
            int k;
            label102:
            CharSequence localCharSequence1;
            int i;
            int j;
            Object localObject4;
            label178:
            label239:
            throw new WrongType(localClassCastException4, "string-ref", 1, localObject6);
          }
          try
          {
            k = ((Number)paramObject1).intValue();
            if (characters.isChar$Eq(localChar, Char.make(strings.stringRef(localCharSequence2, k)))) {
              localObject2 = this.str;
            }
          }
          catch (ClassCastException localClassCastException5)
          {
            throw new WrongType(localClassCastException5, "string-ref", 2, paramObject1);
          }
          try
          {
            localCharSequence1 = (CharSequence)localObject2;
            localObject3 = AddOp.$Pl.apply2(paramObject1, printf.Lit7);
          }
          catch (ClassCastException localClassCastException2)
          {
            throw new WrongType(localClassCastException2, "string-ref", 1, localObject2);
          }
          try
          {
            i = ((Number)localObject3).intValue();
            j = strings.stringRef(localCharSequence1, i);
            localObject4 = Scheme.isEqv.apply2(Char.make(j), printf.Lit12);
            if (localObject4 != Boolean.FALSE)
            {
              if (localObject4 != Boolean.FALSE)
              {
                paramObject1 = AddOp.$Pl.apply2(paramObject1, printf.Lit14);
                continue;
                if (bool) {
                  break label102;
                }
                return Scheme.applyToArgs.apply2(localModuleMethod, paramObject1);
              }
            }
            else
            {
              Object localObject5 = Scheme.isEqv.apply2(Char.make(j), printf.Lit3);
              if (localObject5 == Boolean.FALSE) {
                break label269;
              }
              if (localObject5 != Boolean.FALSE) {
                break label178;
              }
            }
            if (Scheme.isEqv.apply2(Char.make(j), printf.Lit11) != Boolean.FALSE)
            {
              return Scheme.applyToArgs.apply2(localModuleMethod, paramObject1);
              if (Scheme.isEqv.apply2(Char.make(j), printf.Lit13) == Boolean.FALSE) {
                break label239;
              }
              break label178;
            }
            return lambda1parseError();
          }
          catch (ClassCastException localClassCastException3)
          {
            throw new WrongType(localClassCastException3, "string-ref", 2, localObject3);
          }
          localClassCastException1 = localClassCastException1;
          throw new WrongType(localClassCastException1, "x", -2, localObject1);
        }
      }
    }
    
    Object lambda5(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      printf.frame0 localframe0 = new printf.frame0();
      localframe0.staticLink = this;
      localframe0.sgn = paramObject2;
      localframe0.digs = paramObject3;
      localframe0.ex = paramObject4;
      if (Scheme.numEqu.apply2(paramObject1, Integer.valueOf(this.n)) != Boolean.FALSE) {
        return Scheme.applyToArgs.apply4(this.proc, localframe0.sgn, localframe0.digs, localframe0.ex);
      }
      localObject1 = this.str;
      try
      {
        localCharSequence1 = (CharSequence)localObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        CharSequence localCharSequence1;
        int i;
        IsEqv localIsEqv;
        CharSequence localCharSequence2;
        int j;
        CharSequence localCharSequence3;
        Complex localComplex;
        throw new WrongType(localClassCastException1, "string-ref", 1, localObject1);
      }
      try
      {
        i = ((Number)paramObject1).intValue();
        if (lists.memv(Char.make(strings.stringRef(localCharSequence1, i)), printf.Lit2) != Boolean.FALSE) {
          return lambda4real(paramObject1, localframe0.lambda$Fn2);
        }
        localIsEqv = Scheme.isEqv;
        localObject2 = this.str;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-ref", 2, paramObject1);
      }
      try
      {
        localCharSequence2 = (CharSequence)localObject2;
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "string-ref", 1, localObject2);
      }
      try
      {
        j = ((Number)paramObject1).intValue();
        if (localIsEqv.apply2(Char.make(strings.stringRef(localCharSequence2, j)), printf.Lit4) != Boolean.FALSE) {
          localObject3 = this.str;
        }
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "string-ref", 2, paramObject1);
      }
      try
      {
        localCharSequence3 = (CharSequence)localObject3;
        localframe0.num = numbers.string$To$Number(localCharSequence3);
        if (localframe0.num != Boolean.FALSE) {
          localObject4 = localframe0.num;
        }
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "string->number", 1, localObject3);
      }
      try
      {
        localComplex = (Complex)localObject4;
        return printf.stdio$ClParseFloat(numbers.number$To$String(numbers.realPart(localComplex)), localframe0.lambda$Fn3);
      }
      catch (ClassCastException localClassCastException6)
      {
        throw new WrongType(localClassCastException6, "real-part", 1, localObject4);
      }
      return lambda1parseError();
      return Boolean.FALSE;
    }
    
    public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 12)
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
  }
  
  public class frame0
    extends ModuleBody
  {
    Object digs;
    Object ex;
    final ModuleMethod lambda$Fn2;
    final ModuleMethod lambda$Fn3;
    Object num;
    Object sgn;
    printf.frame staticLink;
    
    public frame0()
    {
      this$1 = new ModuleMethod(this, 2, null, 16388);
      this$1.setProperty("source-location", "printf.scm:111");
      this.lambda$Fn2 = this$1;
      ModuleMethod localModuleMethod = new ModuleMethod(this, 3, null, 12291);
      localModuleMethod.setProperty("source-location", "printf.scm:123");
      this.lambda$Fn3 = localModuleMethod;
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 3) {
        return lambda7(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      if (paramModuleMethod.selector == 2) {
        return lambda6(paramObject1, paramObject2, paramObject3, paramObject4);
      }
      return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
    }
    
    /* Error */
    Object lambda6(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      // Byte code:
      //   0: getstatic 67	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
      //   3: aload_1
      //   4: iconst_m1
      //   5: aload_0
      //   6: getfield 69	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   9: getfield 74	gnu/kawa/slib/printf$frame:n	I
      //   12: iadd
      //   13: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   16: invokevirtual 86	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   19: astore 5
      //   21: aload 5
      //   23: checkcast 88	java/lang/Boolean
      //   26: invokevirtual 92	java/lang/Boolean:booleanValue	()Z
      //   29: istore 7
      //   31: iload 7
      //   33: ifeq +123 -> 156
      //   36: getstatic 98	gnu/kawa/slib/printf:Lit3	Lgnu/text/Char;
      //   39: astore 10
      //   41: aload_0
      //   42: getfield 69	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   45: getfield 101	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   48: astore 11
      //   50: aload 11
      //   52: checkcast 103	java/lang/CharSequence
      //   55: astore 13
      //   57: aload_1
      //   58: checkcast 105	java/lang/Number
      //   61: invokevirtual 109	java/lang/Number:intValue	()I
      //   64: istore 15
      //   66: aload 10
      //   68: aload 13
      //   70: iload 15
      //   72: invokestatic 115	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   75: invokestatic 121	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   78: invokestatic 127	kawa/lib/rnrs/unicode:isCharCi$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   81: ifeq +80 -> 161
      //   84: getstatic 131	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   87: astore 8
      //   89: bipush 7
      //   91: anewarray 133	java/lang/Object
      //   94: astore 9
      //   96: aload 9
      //   98: iconst_0
      //   99: aload_0
      //   100: getfield 69	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   103: getfield 136	gnu/kawa/slib/printf$frame:proc	Ljava/lang/Object;
      //   106: aastore
      //   107: aload 9
      //   109: iconst_1
      //   110: aload_0
      //   111: getfield 138	gnu/kawa/slib/printf$frame0:sgn	Ljava/lang/Object;
      //   114: aastore
      //   115: aload 9
      //   117: iconst_2
      //   118: aload_0
      //   119: getfield 140	gnu/kawa/slib/printf$frame0:digs	Ljava/lang/Object;
      //   122: aastore
      //   123: aload 9
      //   125: iconst_3
      //   126: aload_0
      //   127: getfield 142	gnu/kawa/slib/printf$frame0:ex	Ljava/lang/Object;
      //   130: aastore
      //   131: aload 9
      //   133: iconst_4
      //   134: aload_2
      //   135: aastore
      //   136: aload 9
      //   138: iconst_5
      //   139: aload_3
      //   140: aastore
      //   141: aload 9
      //   143: bipush 6
      //   145: aload 4
      //   147: aastore
      //   148: aload 8
      //   150: aload 9
      //   152: invokevirtual 146	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
      //   155: areturn
      //   156: iload 7
      //   158: ifne -74 -> 84
      //   161: invokestatic 150	gnu/kawa/slib/printf$frame:lambda1parseError	()Ljava/lang/Boolean;
      //   164: areturn
      //   165: astore 6
      //   167: new 152	gnu/mapping/WrongType
      //   170: dup
      //   171: aload 6
      //   173: ldc 154
      //   175: bipush 254
      //   177: aload 5
      //   179: invokespecial 157	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   182: athrow
      //   183: astore 12
      //   185: new 152	gnu/mapping/WrongType
      //   188: dup
      //   189: aload 12
      //   191: ldc 159
      //   193: iconst_1
      //   194: aload 11
      //   196: invokespecial 157	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   199: athrow
      //   200: astore 14
      //   202: new 152	gnu/mapping/WrongType
      //   205: dup
      //   206: aload 14
      //   208: ldc 159
      //   210: iconst_2
      //   211: aload_1
      //   212: invokespecial 157	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   215: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	216	0	this	frame0
      //   0	216	1	paramObject1	Object
      //   0	216	2	paramObject2	Object
      //   0	216	3	paramObject3	Object
      //   0	216	4	paramObject4	Object
      //   19	159	5	localObject1	Object
      //   165	7	6	localClassCastException1	ClassCastException
      //   29	128	7	bool	boolean
      //   87	62	8	localApplyToArgs	ApplyToArgs
      //   94	57	9	arrayOfObject	Object[]
      //   39	28	10	localChar	Char
      //   48	147	11	localObject2	Object
      //   183	7	12	localClassCastException2	ClassCastException
      //   55	14	13	localCharSequence	CharSequence
      //   200	7	14	localClassCastException3	ClassCastException
      //   64	7	15	i	int
      // Exception table:
      //   from	to	target	type
      //   21	31	165	java/lang/ClassCastException
      //   50	57	183	java/lang/ClassCastException
      //   57	66	200	java/lang/ClassCastException
    }
    
    Object lambda7(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      printf.frame1 localframe1 = new printf.frame1();
      localframe1.staticLink = this;
      localframe1.sgn = paramObject1;
      localframe1.digs = paramObject2;
      localframe1.ex = paramObject3;
      Object localObject = this.num;
      try
      {
        Complex localComplex = (Complex)localObject;
        return printf.stdio$ClParseFloat(numbers.number$To$String(numbers.imagPart(localComplex)), localframe1.lambda$Fn4);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "imag-part", 1, localObject);
      }
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 3)
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
    
    public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 2)
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
  }
  
  public class frame1
    extends ModuleBody
  {
    Object digs;
    Object ex;
    final ModuleMethod lambda$Fn4;
    Object sgn;
    printf.frame0 staticLink;
    
    public frame1()
    {
      this$1 = new ModuleMethod(this, 1, null, 12291);
      this$1.setProperty("source-location", "printf.scm:126");
      this.lambda$Fn4 = this$1;
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 1) {
        return lambda8(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda8(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      Object[] arrayOfObject = new Object[7];
      arrayOfObject[0] = this.staticLink.staticLink.proc;
      arrayOfObject[1] = this.sgn;
      arrayOfObject[2] = this.digs;
      arrayOfObject[3] = this.ex;
      arrayOfObject[4] = paramObject1;
      arrayOfObject[5] = paramObject2;
      arrayOfObject[6] = paramObject3;
      return localApplyToArgs.applyN(arrayOfObject);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 1)
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
  
  public class frame10
    extends ModuleBody
  {
    Object alternate$Mnform;
    Object args;
    Object blank;
    final ModuleMethod lambda$Fn13;
    final ModuleMethod lambda$Fn14;
    final ModuleMethod lambda$Fn15;
    final ModuleMethod lambda$Fn16;
    Object leading$Mn0s;
    Object left$Mnadjust;
    Object os;
    Procedure pad = new ModuleMethod(this, 15, printf.Lit67, -4095);
    Object pr;
    Object precision;
    Object signed;
    printf.frame9 staticLink;
    Object width;
    
    public frame10()
    {
      this$1 = new ModuleMethod(this, 16, null, 4097);
      this$1.setProperty("source-location", "printf.scm:472");
      this.lambda$Fn13 = this$1;
      ModuleMethod localModuleMethod1 = new ModuleMethod(this, 17, null, 4097);
      localModuleMethod1.setProperty("source-location", "printf.scm:476");
      this.lambda$Fn14 = localModuleMethod1;
      ModuleMethod localModuleMethod2 = new ModuleMethod(this, 18, null, 4097);
      localModuleMethod2.setProperty("source-location", "printf.scm:484");
      this.lambda$Fn15 = localModuleMethod2;
      ModuleMethod localModuleMethod3 = new ModuleMethod(this, 19, null, 4097);
      localModuleMethod3.setProperty("source-location", "printf.scm:494");
      this.lambda$Fn16 = localModuleMethod3;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply1(paramModuleMethod, paramObject);
      case 16: 
        return lambda25(paramObject);
      case 17: 
        if (lambda26(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      case 18: 
        return lambda27(paramObject);
      }
      if (lambda28(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    
    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      if (paramModuleMethod.selector == 15)
      {
        Object localObject = paramArrayOfObject[0];
        int i = -1 + paramArrayOfObject.length;
        Object[] arrayOfObject = new Object[i];
        for (;;)
        {
          i--;
          if (i < 0) {
            return lambda23pad$V(localObject, arrayOfObject);
          }
          arrayOfObject[i] = paramArrayOfObject[(i + 1)];
        }
      }
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    }
    
    public Object lambda22readFormatNumber()
    {
      if (Scheme.isEqv.apply2(printf.Lit66, this.staticLink.fc) != Boolean.FALSE)
      {
        this.staticLink.lambda18mustAdvance();
        Object localObject6 = lists.car.apply1(this.args);
        this.args = lists.cdr.apply1(this.args);
        return localObject6;
      }
      Object localObject1 = this.staticLink.fc;
      Object localObject2 = printf.Lit1;
      for (;;)
      {
        Object localObject3 = this.staticLink.fc;
        try
        {
          Char localChar = (Char)localObject3;
          if (unicode.isCharNumeric(localChar))
          {
            this.staticLink.lambda18mustAdvance();
            Object localObject4 = this.staticLink.fc;
            AddOp localAddOp = AddOp.$Pl;
            Object localObject5 = MultiplyOp.$St.apply2(localObject2, printf.Lit45);
            if ((localObject1 instanceof Object[])) {}
            for (Object[] arrayOfObject = (Object[])localObject1;; arrayOfObject = new Object[] { localObject1 })
            {
              localObject2 = localAddOp.apply2(localObject5, numbers.string$To$Number(strings.$make$string$(arrayOfObject)));
              localObject1 = localObject4;
              break;
            }
          }
          return localObject2;
        }
        catch (ClassCastException localClassCastException)
        {
          throw new WrongType(localClassCastException, "char-numeric?", 1, localObject3);
        }
      }
    }
    
    public Object lambda23pad$V(Object paramObject, Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      try
      {
        CharSequence localCharSequence1 = (CharSequence)paramObject;
        localObject1 = Integer.valueOf(strings.stringLength(localCharSequence1));
        localObject2 = localLList;
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          Object[] arrayOfObject;
          localCharSequence2 = (CharSequence)localObject3;
          Object localObject1 = localAddOp.apply2(localObject1, Integer.valueOf(strings.stringLength(localCharSequence2)));
          Object localObject2 = lists.cdr.apply1(localObject2);
        }
        catch (ClassCastException localClassCastException2)
        {
          Object localObject6;
          Object localObject5;
          Object localObject4;
          Object localObject3;
          throw new WrongType(localClassCastException2, "string-length", 1, localObject3);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "string-length", 1, paramObject);
      }
      if (Scheme.numGEq.apply2(localObject1, this.width) != Boolean.FALSE) {
        return lists.cons(paramObject, localLList);
      }
      if (lists.isNull(localObject2)) {
        if (this.left$Mnadjust != Boolean.FALSE)
        {
          arrayOfObject = new Object[2];
          arrayOfObject[0] = localLList;
          localObject6 = AddOp.$Mn.apply2(this.width, localObject1);
        }
      }
      try
      {
        int k = ((Number)localObject6).intValue();
        arrayOfObject[1] = LList.list1(strings.makeString(k, printf.Lit29));
        return lists.cons(paramObject, append.append$V(arrayOfObject));
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "make-string", 1, localObject6);
      }
      if (this.leading$Mn0s != Boolean.FALSE) {
        localObject5 = AddOp.$Mn.apply2(this.width, localObject1);
      }
      try
      {
        int j = ((Number)localObject5).intValue();
        return lists.cons(paramObject, lists.cons(strings.makeString(j, printf.Lit9), localLList));
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "make-string", 1, localObject5);
      }
      localObject4 = AddOp.$Mn.apply2(this.width, localObject1);
      try
      {
        int i = ((Number)localObject4).intValue();
        return lists.cons(strings.makeString(i, printf.Lit29), lists.cons(paramObject, localLList));
      }
      catch (ClassCastException localClassCastException3)
      {
        AddOp localAddOp;
        CharSequence localCharSequence2;
        throw new WrongType(localClassCastException3, "make-string", 1, localObject4);
      }
      localAddOp = AddOp.$Pl;
      localObject3 = lists.car.apply1(localObject2);
    }
    
    /* Error */
    public Object lambda24integerConvert(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 270	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   4: astore 4
      //   6: aload 4
      //   8: invokestatic 276	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   11: astore 6
      //   13: aload 6
      //   15: invokestatic 280	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
      //   18: ifne +765 -> 783
      //   21: aload_0
      //   22: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   25: putfield 259	gnu/kawa/slib/printf$frame10:leading$Mn0s	Ljava/lang/Object;
      //   28: aload_0
      //   29: getfield 270	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   32: astore 41
      //   34: aload 41
      //   36: checkcast 236	java/lang/Number
      //   39: astore 43
      //   41: aload 43
      //   43: invokestatic 284	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
      //   46: istore 44
      //   48: iload 44
      //   50: ifeq +199 -> 249
      //   53: getstatic 117	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   56: getstatic 154	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   59: aload_1
      //   60: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   63: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   66: if_acmpeq +7 -> 73
      //   69: ldc_w 286
      //   72: astore_1
      //   73: aload_1
      //   74: astore 7
      //   76: aload 7
      //   78: invokestatic 291	kawa/lib/misc:isSymbol	(Ljava/lang/Object;)Z
      //   81: ifeq +176 -> 257
      //   84: aload 7
      //   86: checkcast 293	gnu/mapping/Symbol
      //   89: astore 40
      //   91: aload 40
      //   93: invokestatic 297	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
      //   96: astore 12
      //   98: aload_3
      //   99: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   102: if_acmpeq +14 -> 116
      //   105: getstatic 301	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   108: aload_3
      //   109: aload 12
      //   111: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   114: astore 12
      //   116: ldc_w 286
      //   119: aload 12
      //   121: invokestatic 307	gnu/kawa/functions/IsEqual:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   124: ifeq +247 -> 371
      //   127: ldc_w 286
      //   130: astore 17
      //   132: iconst_2
      //   133: anewarray 101	java/lang/Object
      //   136: astore 18
      //   138: getstatic 310	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   141: astore 19
      //   143: aload 12
      //   145: checkcast 206	java/lang/CharSequence
      //   148: astore 21
      //   150: aload 19
      //   152: aload 21
      //   154: invokestatic 210	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   157: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   160: aload_0
      //   161: getfield 270	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   164: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   167: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   170: if_acmpeq +389 -> 559
      //   173: getstatic 234	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   176: astore 23
      //   178: aload_0
      //   179: getfield 270	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   182: astore 24
      //   184: aload 12
      //   186: checkcast 206	java/lang/CharSequence
      //   189: astore 26
      //   191: aload 23
      //   193: aload 24
      //   195: aload 26
      //   197: invokestatic 210	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   200: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   203: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   206: astore 27
      //   208: aload 27
      //   210: checkcast 236	java/lang/Number
      //   213: invokevirtual 240	java/lang/Number:intValue	()I
      //   216: istore 29
      //   218: iload 29
      //   220: getstatic 262	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
      //   223: invokestatic 247	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
      //   226: astore 22
      //   228: aload 18
      //   230: iconst_0
      //   231: aload 22
      //   233: aastore
      //   234: aload 18
      //   236: iconst_1
      //   237: aload 12
      //   239: aastore
      //   240: aload_0
      //   241: aload 17
      //   243: aload 18
      //   245: invokevirtual 105	gnu/kawa/slib/printf$frame10:lambda23pad$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   248: areturn
      //   249: iload 44
      //   251: ifeq -178 -> 73
      //   254: goto -185 -> 69
      //   257: aload 7
      //   259: invokestatic 313	kawa/lib/numbers:isNumber	(Ljava/lang/Object;)Z
      //   262: ifeq +31 -> 293
      //   265: aload 7
      //   267: checkcast 236	java/lang/Number
      //   270: astore 36
      //   272: aload_2
      //   273: checkcast 236	java/lang/Number
      //   276: invokevirtual 240	java/lang/Number:intValue	()I
      //   279: istore 38
      //   281: aload 36
      //   283: iload 38
      //   285: invokestatic 317	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;I)Ljava/lang/CharSequence;
      //   288: astore 12
      //   290: goto -192 -> 98
      //   293: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   296: astore 9
      //   298: aload 7
      //   300: aload 9
      //   302: if_acmpeq +32 -> 334
      //   305: iconst_1
      //   306: istore 10
      //   308: iconst_1
      //   309: iload 10
      //   311: iconst_1
      //   312: iadd
      //   313: iand
      //   314: istore 11
      //   316: iload 11
      //   318: ifeq +22 -> 340
      //   321: iload 11
      //   323: ifeq +25 -> 348
      //   326: ldc_w 319
      //   329: astore 12
      //   331: goto -233 -> 98
      //   334: iconst_0
      //   335: istore 10
      //   337: goto -29 -> 308
      //   340: aload 7
      //   342: invokestatic 229	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   345: ifne -19 -> 326
      //   348: aload 7
      //   350: invokestatic 322	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
      //   353: ifeq +10 -> 363
      //   356: aload 7
      //   358: astore 12
      //   360: goto -262 -> 98
      //   363: ldc_w 324
      //   366: astore 12
      //   368: goto -270 -> 98
      //   371: getstatic 117	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   374: astore 13
      //   376: getstatic 327	gnu/kawa/slib/printf:Lit5	Lgnu/text/Char;
      //   379: astore 14
      //   381: aload 12
      //   383: checkcast 206	java/lang/CharSequence
      //   386: astore 16
      //   388: aload 13
      //   390: aload 14
      //   392: aload 16
      //   394: iconst_0
      //   395: invokestatic 331	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   398: invokestatic 335	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   401: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   404: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   407: if_acmpeq +38 -> 445
      //   410: aload 12
      //   412: checkcast 206	java/lang/CharSequence
      //   415: astore 32
      //   417: aload 12
      //   419: checkcast 206	java/lang/CharSequence
      //   422: astore 34
      //   424: aload 32
      //   426: iconst_1
      //   427: aload 34
      //   429: invokestatic 210	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   432: invokestatic 339	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   435: astore 12
      //   437: ldc_w 341
      //   440: astore 17
      //   442: goto -310 -> 132
      //   445: aload_0
      //   446: getfield 343	gnu/kawa/slib/printf$frame10:signed	Ljava/lang/Object;
      //   449: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   452: if_acmpeq +11 -> 463
      //   455: ldc_w 345
      //   458: astore 17
      //   460: goto -328 -> 132
      //   463: aload_0
      //   464: getfield 347	gnu/kawa/slib/printf$frame10:blank	Ljava/lang/Object;
      //   467: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   470: if_acmpeq +11 -> 481
      //   473: ldc_w 349
      //   476: astore 17
      //   478: goto -346 -> 132
      //   481: aload_0
      //   482: getfield 351	gnu/kawa/slib/printf$frame10:alternate$Mnform	Ljava/lang/Object;
      //   485: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   488: if_acmpeq +63 -> 551
      //   491: getstatic 117	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   494: aload_2
      //   495: getstatic 354	gnu/kawa/slib/printf:Lit48	Lgnu/math/IntNum;
      //   498: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   501: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   504: if_acmpeq +15 -> 519
      //   507: ldc_w 319
      //   510: astore 30
      //   512: aload 30
      //   514: astore 17
      //   516: goto -384 -> 132
      //   519: getstatic 117	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   522: aload_2
      //   523: getstatic 357	gnu/kawa/slib/printf:Lit50	Lgnu/math/IntNum;
      //   526: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   529: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   532: if_acmpeq +11 -> 543
      //   535: ldc_w 359
      //   538: astore 30
      //   540: goto -28 -> 512
      //   543: ldc_w 286
      //   546: astore 30
      //   548: goto -36 -> 512
      //   551: ldc_w 286
      //   554: astore 17
      //   556: goto -424 -> 132
      //   559: ldc_w 286
      //   562: astore 22
      //   564: goto -336 -> 228
      //   567: astore 5
      //   569: new 193	gnu/mapping/WrongType
      //   572: dup
      //   573: aload 5
      //   575: ldc_w 361
      //   578: iconst_1
      //   579: aload 4
      //   581: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   584: athrow
      //   585: astore 42
      //   587: new 193	gnu/mapping/WrongType
      //   590: dup
      //   591: aload 42
      //   593: ldc_w 363
      //   596: iconst_1
      //   597: aload 41
      //   599: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   602: athrow
      //   603: astore 39
      //   605: new 193	gnu/mapping/WrongType
      //   608: dup
      //   609: aload 39
      //   611: ldc_w 365
      //   614: iconst_1
      //   615: aload 7
      //   617: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   620: athrow
      //   621: astore 35
      //   623: new 193	gnu/mapping/WrongType
      //   626: dup
      //   627: aload 35
      //   629: ldc_w 367
      //   632: iconst_1
      //   633: aload 7
      //   635: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   638: athrow
      //   639: astore 37
      //   641: new 193	gnu/mapping/WrongType
      //   644: dup
      //   645: aload 37
      //   647: ldc_w 367
      //   650: iconst_2
      //   651: aload_2
      //   652: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   655: athrow
      //   656: astore 8
      //   658: new 193	gnu/mapping/WrongType
      //   661: dup
      //   662: aload 8
      //   664: ldc_w 369
      //   667: bipush 254
      //   669: aload 7
      //   671: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   674: athrow
      //   675: astore 15
      //   677: new 193	gnu/mapping/WrongType
      //   680: dup
      //   681: aload 15
      //   683: ldc_w 371
      //   686: iconst_1
      //   687: aload 12
      //   689: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   692: athrow
      //   693: astore 31
      //   695: new 193	gnu/mapping/WrongType
      //   698: dup
      //   699: aload 31
      //   701: ldc_w 372
      //   704: iconst_1
      //   705: aload 12
      //   707: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   710: athrow
      //   711: astore 33
      //   713: new 193	gnu/mapping/WrongType
      //   716: dup
      //   717: aload 33
      //   719: ldc_w 264
      //   722: iconst_1
      //   723: aload 12
      //   725: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   728: athrow
      //   729: astore 20
      //   731: new 193	gnu/mapping/WrongType
      //   734: dup
      //   735: aload 20
      //   737: ldc_w 264
      //   740: iconst_1
      //   741: aload 12
      //   743: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   746: athrow
      //   747: astore 25
      //   749: new 193	gnu/mapping/WrongType
      //   752: dup
      //   753: aload 25
      //   755: ldc_w 264
      //   758: iconst_1
      //   759: aload 12
      //   761: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   764: athrow
      //   765: astore 28
      //   767: new 193	gnu/mapping/WrongType
      //   770: dup
      //   771: aload 28
      //   773: ldc_w 266
      //   776: iconst_1
      //   777: aload 27
      //   779: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   782: athrow
      //   783: aload_1
      //   784: astore 7
      //   786: goto -710 -> 76
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	789	0	this	frame10
      //   0	789	1	paramObject1	Object
      //   0	789	2	paramObject2	Object
      //   0	789	3	paramObject3	Object
      //   4	576	4	localObject1	Object
      //   567	7	5	localClassCastException1	ClassCastException
      //   11	3	6	localRealNum	RealNum
      //   74	711	7	localObject2	Object
      //   656	7	8	localClassCastException2	ClassCastException
      //   296	5	9	localBoolean	Boolean
      //   306	30	10	i	int
      //   314	8	11	j	int
      //   96	664	12	localObject3	Object
      //   374	15	13	localIsEqv	IsEqv
      //   379	12	14	localChar	Char
      //   675	7	15	localClassCastException3	ClassCastException
      //   386	7	16	localCharSequence1	CharSequence
      //   130	425	17	localObject4	Object
      //   136	108	18	arrayOfObject	Object[]
      //   141	10	19	localNumberCompare	NumberCompare
      //   729	7	20	localClassCastException4	ClassCastException
      //   148	5	21	localCharSequence2	CharSequence
      //   226	337	22	localObject5	Object
      //   176	16	23	localAddOp	AddOp
      //   182	12	24	localObject6	Object
      //   747	7	25	localClassCastException5	ClassCastException
      //   189	7	26	localCharSequence3	CharSequence
      //   206	572	27	localObject7	Object
      //   765	7	28	localClassCastException6	ClassCastException
      //   216	3	29	k	int
      //   510	37	30	str	String
      //   693	7	31	localClassCastException7	ClassCastException
      //   415	10	32	localCharSequence4	CharSequence
      //   711	7	33	localClassCastException8	ClassCastException
      //   422	6	34	localCharSequence5	CharSequence
      //   621	7	35	localClassCastException9	ClassCastException
      //   270	12	36	localNumber1	Number
      //   639	7	37	localClassCastException10	ClassCastException
      //   279	5	38	m	int
      //   603	7	39	localClassCastException11	ClassCastException
      //   89	3	40	localSymbol	Symbol
      //   32	566	41	localObject8	Object
      //   585	7	42	localClassCastException12	ClassCastException
      //   39	3	43	localNumber2	Number
      //   46	204	44	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   6	13	567	java/lang/ClassCastException
      //   34	41	585	java/lang/ClassCastException
      //   84	91	603	java/lang/ClassCastException
      //   265	272	621	java/lang/ClassCastException
      //   272	281	639	java/lang/ClassCastException
      //   293	298	656	java/lang/ClassCastException
      //   381	388	675	java/lang/ClassCastException
      //   410	417	693	java/lang/ClassCastException
      //   417	424	711	java/lang/ClassCastException
      //   143	150	729	java/lang/ClassCastException
      //   184	191	747	java/lang/ClassCastException
      //   208	218	765	java/lang/ClassCastException
    }
    
    Object lambda25(Object paramObject)
    {
      AddOp localAddOp = AddOp.$Pl;
      Object localObject = this.pr;
      try
      {
        CharSequence localCharSequence = (CharSequence)paramObject;
        this.pr = localAddOp.apply2(localObject, Integer.valueOf(strings.stringLength(localCharSequence)));
        return Scheme.applyToArgs.apply2(this.staticLink.out, paramObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "string-length", 1, paramObject);
      }
    }
    
    boolean lambda26(Object paramObject)
    {
      AddOp localAddOp = AddOp.$Mn;
      Object localObject1 = this.pr;
      for (;;)
      {
        try
        {
          CharSequence localCharSequence1 = (CharSequence)paramObject;
          localObject2 = localAddOp.apply2(localObject1, Integer.valueOf(strings.stringLength(localCharSequence1)));
        }
        catch (ClassCastException localClassCastException1)
        {
          RealNum localRealNum1;
          ApplyToArgs localApplyToArgs;
          Object localObject4;
          CharSequence localCharSequence2;
          int i;
          Object localObject3;
          RealNum localRealNum2;
          throw new WrongType(localClassCastException1, "string-length", 1, paramObject);
        }
        try
        {
          localRealNum1 = LangObjType.coerceRealNum(localObject2);
          if (numbers.isNegative(localRealNum1))
          {
            localApplyToArgs = Scheme.applyToArgs;
            localObject4 = this.staticLink.out;
          }
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "negative?", 1, localObject2);
        }
        try
        {
          localCharSequence2 = (CharSequence)paramObject;
          localObject5 = this.pr;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "substring", 1, paramObject);
        }
        try
        {
          i = ((Number)localObject5).intValue();
          localApplyToArgs.apply2(localObject4, strings.substring(localCharSequence2, 0, i));
          localObject3 = printf.Lit1;
          this.pr = localObject3;
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "substring", 3, localObject5);
        }
        try
        {
          localRealNum2 = LangObjType.coerceRealNum(localObject2);
          return numbers.isPositive(localRealNum2);
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "positive?", 1, localObject2);
        }
        Scheme.applyToArgs.apply2(this.staticLink.out, paramObject);
        localObject3 = localObject2;
      }
    }
    
    Boolean lambda27(Object paramObject)
    {
      AddOp localAddOp = AddOp.$Mn;
      Object localObject1 = this.pr;
      try
      {
        CharSequence localCharSequence = (CharSequence)paramObject;
        this.pr = localAddOp.apply2(localObject1, Integer.valueOf(strings.stringLength(localCharSequence)));
        if (this.os != Boolean.FALSE) {
          break label61;
        }
        Scheme.applyToArgs.apply2(this.staticLink.out, paramObject);
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          for (;;)
          {
            label61:
            RealNum localRealNum = LangObjType.coerceRealNum(localObject2);
            if (!numbers.isNegative(localRealNum)) {
              break;
            }
            Scheme.applyToArgs.apply2(this.staticLink.out, this.os);
            this.os = Boolean.FALSE;
            Scheme.applyToArgs.apply2(this.staticLink.out, paramObject);
          }
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = this.os;
          arrayOfObject[1] = paramObject;
          this.os = strings.stringAppend(arrayOfObject);
        }
        catch (ClassCastException localClassCastException2)
        {
          Object localObject2;
          throw new WrongType(localClassCastException2, "negative?", 1, localObject2);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "string-length", 1, paramObject);
      }
      return Boolean.TRUE;
      localObject2 = this.pr;
    }
    
    boolean lambda28(Object paramObject)
    {
      AddOp localAddOp = AddOp.$Mn;
      Object localObject1 = this.pr;
      for (;;)
      {
        try
        {
          CharSequence localCharSequence1 = (CharSequence)paramObject;
          localObject2 = localAddOp.apply2(localObject1, Integer.valueOf(strings.stringLength(localCharSequence1)));
        }
        catch (ClassCastException localClassCastException1)
        {
          RealNum localRealNum1;
          Object[] arrayOfObject2;
          CharSequence localCharSequence2;
          int i;
          RealNum localRealNum2;
          Object[] arrayOfObject1;
          throw new WrongType(localClassCastException1, "string-length", 1, paramObject);
        }
        try
        {
          localRealNum1 = LangObjType.coerceRealNum(localObject2);
          if (numbers.isNegative(localRealNum1))
          {
            arrayOfObject2 = new Object[2];
            arrayOfObject2[0] = this.os;
          }
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "negative?", 1, localObject2);
        }
        try
        {
          localCharSequence2 = (CharSequence)paramObject;
          localObject3 = this.pr;
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "substring", 1, paramObject);
        }
        try
        {
          i = ((Number)localObject3).intValue();
          arrayOfObject2[1] = strings.substring(localCharSequence2, 0, i);
          this.os = strings.stringAppend(arrayOfObject2);
          this.pr = localObject2;
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "substring", 3, localObject3);
        }
        try
        {
          localRealNum2 = LangObjType.coerceRealNum(localObject2);
          return numbers.isPositive(localRealNum2);
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "positive?", 1, localObject2);
        }
        arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = this.os;
        arrayOfObject1[1] = paramObject;
        this.os = strings.stringAppend(arrayOfObject1);
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match1(paramModuleMethod, paramObject, paramCallContext);
      case 19: 
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      case 18: 
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      case 17: 
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
    
    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 15)
      {
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      }
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    }
  }
  
  public class frame11
    extends ModuleBody
  {
    Object fc;
    Procedure format$Mnreal = new ModuleMethod(this, 13, printf.Lit64, -4092);
    final ModuleMethod lambda$Fn17;
    printf.frame10 staticLink;
    
    public frame11()
    {
      this$1 = new ModuleMethod(this, 14, null, -4093);
      this$1.setProperty("source-location", "printf.scm:401");
      this.lambda$Fn17 = this$1;
    }
    
    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.applyN(paramModuleMethod, paramArrayOfObject);
      case 13: 
        Object localObject4 = paramArrayOfObject[0];
        Object localObject5 = paramArrayOfObject[1];
        Object localObject6 = paramArrayOfObject[2];
        Object localObject7 = paramArrayOfObject[3];
        int j = -4 + paramArrayOfObject.length;
        Object[] arrayOfObject2 = new Object[j];
        for (;;)
        {
          j--;
          if (j < 0) {
            return lambda30formatReal$V(localObject4, localObject5, localObject6, localObject7, arrayOfObject2);
          }
          arrayOfObject2[j] = paramArrayOfObject[(j + 4)];
        }
      }
      Object localObject1 = paramArrayOfObject[0];
      Object localObject2 = paramArrayOfObject[1];
      Object localObject3 = paramArrayOfObject[2];
      int i = -3 + paramArrayOfObject.length;
      Object[] arrayOfObject1 = new Object[i];
      for (;;)
      {
        i--;
        if (i < 0) {
          return lambda31$V(localObject1, localObject2, localObject3, arrayOfObject1);
        }
        arrayOfObject1[i] = paramArrayOfObject[(i + 3)];
      }
    }
    
    public Object lambda29f(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      for (;;)
      {
        try
        {
          CharSequence localCharSequence1 = (CharSequence)paramObject1;
          Object localObject1 = AddOp.$Pl.apply2(paramObject2, this.staticLink.precision);
          if (paramObject3 != Boolean.FALSE)
          {
            localObject2 = paramObject2;
            localObject3 = printf.stdio$ClRoundString(localCharSequence1, localObject1, localObject2);
            if (Scheme.numGEq.apply2(paramObject2, printf.Lit1) == Boolean.FALSE) {
              continue;
            }
          }
        }
        catch (ClassCastException localClassCastException1)
        {
          Object localObject2;
          Number localNumber2;
          CharSequence localCharSequence3;
          int j;
          int k;
          CharSequence localCharSequence4;
          CharSequence localCharSequence5;
          int m;
          CharSequence localCharSequence6;
          CharSequence localCharSequence7;
          boolean bool2;
          Object localObject9;
          Object localObject5;
          Char localChar;
          throw new WrongType(localClassCastException1, "stdio:round-string", 0, paramObject1);
        }
        try
        {
          localNumber2 = (Number)paramObject2;
          if (numbers.isZero(localNumber2))
          {
            localIntNum = printf.Lit1;
            Object[] arrayOfObject2 = new Object[2];
            arrayOfObject2[0] = printf.Lit7;
            arrayOfObject2[1] = AddOp.$Pl.apply2(printf.Lit7, paramObject2);
            localObject8 = numbers.max(arrayOfObject2);
          }
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "zero?", 1, paramObject2);
        }
        try
        {
          localCharSequence3 = (CharSequence)localObject3;
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "substring", 1, localObject3);
        }
        try
        {
          j = localIntNum.intValue();
        }
        catch (ClassCastException localClassCastException7)
        {
          throw new WrongType(localClassCastException7, "substring", 2, localIntNum);
        }
        try
        {
          k = ((Number)localObject8).intValue();
          localCharSequence4 = strings.substring(localCharSequence3, j, k);
        }
        catch (ClassCastException localClassCastException8)
        {
          throw new WrongType(localClassCastException8, "substring", 3, localObject8);
        }
        try
        {
          localCharSequence5 = (CharSequence)localObject3;
        }
        catch (ClassCastException localClassCastException9)
        {
          throw new WrongType(localClassCastException9, "substring", 1, localObject3);
        }
        try
        {
          m = ((Number)localObject8).intValue();
        }
        catch (ClassCastException localClassCastException10)
        {
          throw new WrongType(localClassCastException10, "substring", 2, localObject8);
        }
        try
        {
          localCharSequence6 = (CharSequence)localObject3;
          localCharSequence7 = strings.substring(localCharSequence5, m, strings.stringLength(localCharSequence6));
          bool2 = strings.isString$Eq(localCharSequence7, "");
          if (bool2)
          {
            if (this.staticLink.alternate$Mnform != Boolean.FALSE) {
              continue;
            }
            localObject9 = LList.Empty;
            localObject5 = lists.cons(localCharSequence4, localObject9);
            return localObject5;
            localObject2 = paramObject3;
            continue;
            localChar = printf.Lit9;
          }
          try
          {
            CharSequence localCharSequence2 = (CharSequence)localObject3;
            if (characters.isChar$Eq(localChar, Char.make(strings.stringRef(localCharSequence2, 0))))
            {
              localIntNum = printf.Lit7;
              continue;
            }
            localIntNum = printf.Lit1;
          }
          catch (ClassCastException localClassCastException5)
          {
            Number localNumber1;
            boolean bool1;
            Object localObject7;
            int i;
            throw new WrongType(localClassCastException5, "string-ref", 1, localObject3);
          }
          if (bool2) {
            continue;
          }
          localObject9 = LList.list2(".", localCharSequence7);
          continue;
          localObject4 = this.staticLink.precision;
        }
        catch (ClassCastException localClassCastException11)
        {
          throw new WrongType(localClassCastException11, "string-length", 1, localObject3);
        }
        try
        {
          localNumber1 = (Number)localObject4;
          if (numbers.isZero(localNumber1))
          {
            if (this.staticLink.alternate$Mnform != Boolean.FALSE)
            {
              str = "0.";
              return LList.list1(str);
            }
            String str = "0";
            continue;
          }
          if (paramObject3 != Boolean.FALSE)
          {
            bool1 = strings.isString$Eq(localObject3, "");
            if (bool1)
            {
              localObject7 = LList.list1("0");
              localObject5 = localObject7;
              if (localObject5 != Boolean.FALSE) {
                continue;
              }
              Object[] arrayOfObject1 = new Object[2];
              arrayOfObject1[0] = this.staticLink.precision;
              arrayOfObject1[1] = AddOp.$Mn.apply2(printf.Lit17, paramObject2);
              localObject6 = numbers.min(arrayOfObject1);
            }
          }
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "zero?", 1, localObject4);
        }
        try
        {
          i = ((Number)localObject6).intValue();
          return LList.list3("0.", strings.makeString(i, printf.Lit9), localObject3);
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "make-string", 1, localObject6);
        }
        if (bool1)
        {
          localObject7 = Boolean.TRUE;
        }
        else
        {
          localObject7 = Boolean.FALSE;
          continue;
          localObject5 = paramObject3;
        }
      }
    }
    
    public Object lambda30formatReal$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      if (lists.isNull(localLList))
      {
        Char localChar1 = printf.Lit5;
        for (;;)
        {
          try
          {
            Char localChar2 = (Char)paramObject2;
            if (characters.isChar$Eq(localChar1, localChar2))
            {
              str1 = "-";
              Object localObject1 = Scheme.isEqv.apply2(this.fc, printf.Lit13);
              if (localObject1 == Boolean.FALSE) {
                continue;
              }
              if (localObject1 == Boolean.FALSE) {
                continue;
              }
              localObject11 = Boolean.FALSE;
            }
          }
          catch (ClassCastException localClassCastException1)
          {
            String str1;
            Object localObject11;
            CharSequence localCharSequence1;
            Object localObject12;
            Char localChar3;
            CharSequence localCharSequence2;
            CharSequence localCharSequence3;
            int k;
            CharSequence localCharSequence4;
            CharSequence localCharSequence5;
            CharSequence localCharSequence6;
            int m;
            Pair localPair1;
            boolean bool2;
            String str3;
            Char localChar4;
            String str4;
            RealNum localRealNum2;
            String str5;
            String str6;
            Pair localPair3;
            Number localNumber;
            Object localObject4;
            Object localObject2;
            Boolean localBoolean3;
            AddOp localAddOp2;
            IntNum localIntNum3;
            Object localObject3;
            throw new WrongType(localClassCastException1, "char=?", 2, paramObject2);
          }
          try
          {
            localCharSequence1 = (CharSequence)paramObject3;
            localObject12 = AddOp.$Pl.apply2(printf.Lit7, this.staticLink.precision);
            if (localObject11 != Boolean.FALSE) {
              localObject11 = printf.Lit1;
            }
            localObject13 = printf.stdio$ClRoundString(localCharSequence1, localObject12, localObject11);
            localChar3 = printf.Lit9;
          }
          catch (ClassCastException localClassCastException5)
          {
            throw new WrongType(localClassCastException5, "stdio:round-string", 0, paramObject3);
          }
          try
          {
            localCharSequence2 = (CharSequence)localObject13;
            if (characters.isChar$Eq(localChar3, Char.make(strings.stringRef(localCharSequence2, 0)))) {
              localIntNum2 = printf.Lit7;
            }
          }
          catch (ClassCastException localClassCastException6)
          {
            throw new WrongType(localClassCastException6, "string-ref", 1, localObject13);
          }
          try
          {
            localCharSequence3 = (CharSequence)localObject13;
            k = 1 + localIntNum2.intValue();
          }
          catch (ClassCastException localClassCastException7)
          {
            throw new WrongType(localClassCastException7, "substring", 1, localObject13);
          }
          try
          {
            localCharSequence4 = (CharSequence)localObject13;
            localCharSequence5 = strings.substring(localCharSequence3, k, strings.stringLength(localCharSequence4));
            if (!numbers.isZero(localIntNum2)) {}
          }
          catch (ClassCastException localClassCastException8)
          {
            throw new WrongType(localClassCastException8, "string-length", 1, localObject13);
          }
          try
          {
            localCharSequence6 = (CharSequence)localObject13;
          }
          catch (ClassCastException localClassCastException9)
          {
            throw new WrongType(localClassCastException9, "substring", 1, localObject13);
          }
          try
          {
            m = localIntNum2.intValue();
            localPair1 = LList.list1(strings.substring(localCharSequence6, m, 1 + localIntNum2.intValue()));
            bool2 = strings.isString$Eq(localCharSequence5, "");
            if (bool2)
            {
              if (this.staticLink.alternate$Mnform != Boolean.FALSE) {
                continue;
              }
              str3 = "";
              localObject14 = this.fc;
            }
          }
          catch (ClassCastException localClassCastException10)
          {
            throw new WrongType(localClassCastException10, "substring", 2, localIntNum2);
          }
          try
          {
            localChar4 = (Char)localObject14;
            if (unicode.isCharUpperCase(localChar4)) {
              str4 = "E";
            }
          }
          catch (ClassCastException localClassCastException11)
          {
            throw new WrongType(localClassCastException11, "char-upper-case?", 1, localObject14);
          }
          try
          {
            localRealNum2 = LangObjType.coerceRealNum(paramObject4);
            if (numbers.isNegative(localRealNum2))
            {
              str5 = "-";
              Pair localPair2 = LList.chain4(localPair1, str3, localCharSequence5, str4, str5);
              NumberCompare localNumberCompare2 = Scheme.numLss;
              IntNum localIntNum4 = printf.Lit60;
              IntNum localIntNum5 = printf.Lit45;
              if (localNumberCompare2.apply3(localIntNum4, paramObject4, localIntNum5) == Boolean.FALSE) {
                continue;
              }
              str6 = "0";
              localPair3 = LList.chain1(localPair2, str6);
            }
          }
          catch (ClassCastException localClassCastException12)
          {
            throw new WrongType(localClassCastException12, "negative?", 1, paramObject4);
          }
          try
          {
            localNumber = (Number)paramObject4;
            LList.chain1(localPair3, numbers.number$To$String(numbers.abs(localNumber)));
            localObject4 = localPair1;
            return lists.cons(str1, localObject4);
          }
          catch (ClassCastException localClassCastException13)
          {
            throw new WrongType(localClassCastException13, "abs", 1, paramObject4);
          }
          if (paramObject1 != Boolean.FALSE)
          {
            str1 = "+";
          }
          else if (this.staticLink.blank != Boolean.FALSE)
          {
            str1 = " ";
          }
          else
          {
            str1 = "";
            continue;
            if (Scheme.isEqv.apply2(this.fc, printf.Lit54) == Boolean.FALSE)
            {
              localObject2 = Scheme.isEqv.apply2(this.fc, printf.Lit25);
              if (localObject2 != Boolean.FALSE)
              {
                if (localObject2 != Boolean.FALSE)
                {
                  localBoolean3 = Boolean.FALSE;
                  localObject4 = lambda29f(paramObject3, paramObject4, localBoolean3);
                  continue;
                  localIntNum2 = printf.Lit1;
                  continue;
                  localAddOp2 = AddOp.$Mn;
                  localIntNum3 = printf.Lit7;
                  paramObject4 = localAddOp2.apply2(paramObject4, localIntNum3);
                  continue;
                  if (bool2) {
                    continue;
                  }
                  str3 = ".";
                  continue;
                  str4 = "e";
                  continue;
                  str5 = "+";
                  continue;
                  str6 = "";
                  continue;
                }
              }
              else {
                if (Scheme.isEqv.apply2(this.fc, printf.Lit26) != Boolean.FALSE) {
                  continue;
                }
              }
              localObject3 = Scheme.isEqv.apply2(this.fc, printf.Lit55);
              if (localObject3 != Boolean.FALSE)
              {
                if (localObject3 == Boolean.FALSE) {
                  continue;
                }
                localObject8 = this.staticLink.alternate$Mnform;
              }
            }
          }
          try
          {
            Boolean localBoolean1 = Boolean.FALSE;
            if (localObject8 != localBoolean1)
            {
              i = 1;
              j = 0x1 & i + 1;
              this.staticLink.alternate$Mnform = Boolean.FALSE;
              NumberCompare localNumberCompare1 = Scheme.numLEq;
              Object localObject9 = AddOp.$Mn.apply2(printf.Lit7, this.staticLink.precision);
              Object localObject10 = this.staticLink.precision;
              if (localNumberCompare1.apply3(localObject9, paramObject4, localObject10) == Boolean.FALSE) {
                continue;
              }
              this.staticLink.precision = AddOp.$Mn.apply2(this.staticLink.precision, paramObject4);
              if (j == 0) {
                continue;
              }
              localBoolean2 = Boolean.TRUE;
              localObject4 = lambda29f(paramObject3, paramObject4, localBoolean2);
              continue;
              if (Scheme.isEqv.apply2(this.fc, printf.Lit56) != Boolean.FALSE) {
                continue;
              }
              if (Scheme.isEqv.apply2(this.fc, printf.Lit57) == Boolean.FALSE) {
                continue;
              }
              str2 = "";
            }
          }
          catch (ClassCastException localClassCastException4)
          {
            int i;
            int j;
            Boolean localBoolean2;
            String str2;
            RealNum localRealNum1;
            Object localObject5;
            boolean bool1;
            Object localObject7;
            Object[] arrayOfObject4;
            FVector localFVector;
            int n;
            DivideOp localDivideOp1;
            AddOp localAddOp1;
            IntNum localIntNum1;
            Object[] arrayOfObject1;
            Object[] arrayOfObject2;
            throw new WrongType(localClassCastException4, "strip-0s", -2, localObject8);
          }
          try
          {
            localRealNum1 = LangObjType.coerceRealNum(paramObject4);
            if (numbers.isNegative(localRealNum1))
            {
              DivideOp localDivideOp2 = DivideOp.quotient;
              AddOp localAddOp4 = AddOp.$Mn;
              IntNum localIntNum6 = printf.Lit61;
              localObject5 = localDivideOp2.apply2(localAddOp4.apply2(paramObject4, localIntNum6), printf.Lit61);
              localObject6 = Scheme.numLss.apply3(printf.Lit17, AddOp.$Pl.apply2(localObject5, printf.Lit48), Integer.valueOf(vectors.vectorLength(printf.Lit62)));
            }
          }
          catch (ClassCastException localClassCastException2)
          {
            throw new WrongType(localClassCastException2, "negative?", 1, paramObject4);
          }
          try
          {
            bool1 = ((Boolean)localObject6).booleanValue();
            if (bool1)
            {
              localObject7 = localObject5;
              if (localObject7 == Boolean.FALSE) {
                continue;
              }
              AddOp localAddOp3 = AddOp.$Mn;
              Object localObject15 = MultiplyOp.$St.apply2(printf.Lit61, localObject7);
              Object localObject16 = localAddOp3.apply2(paramObject4, localObject15);
              printf.frame10 localframe10 = this.staticLink;
              Object[] arrayOfObject3 = new Object[2];
              arrayOfObject3[0] = printf.Lit1;
              arrayOfObject3[1] = AddOp.$Mn.apply2(this.staticLink.precision, localObject16);
              localframe10.precision = numbers.max(arrayOfObject3);
              arrayOfObject4 = new Object[2];
              arrayOfObject4[0] = lambda29f(paramObject3, localObject16, Boolean.FALSE);
              localFVector = printf.Lit62;
              localObject17 = AddOp.$Pl.apply2(localObject7, printf.Lit48);
            }
          }
          catch (ClassCastException localClassCastException3)
          {
            throw new WrongType(localClassCastException3, "x", -2, localObject6);
          }
          try
          {
            n = ((Number)localObject17).intValue();
            arrayOfObject4[1] = LList.list2(str2, vectors.vectorRef(localFVector, n));
            localObject4 = append.append$V(arrayOfObject4);
          }
          catch (ClassCastException localClassCastException14)
          {
            throw new WrongType(localClassCastException14, "vector-ref", 2, localObject17);
          }
          i = 0;
          continue;
          localBoolean2 = Boolean.FALSE;
          continue;
          this.staticLink.precision = AddOp.$Mn.apply2(this.staticLink.precision, printf.Lit7);
          if (j != 0)
          {
            localObject11 = Boolean.TRUE;
          }
          else
          {
            localObject11 = Boolean.FALSE;
            continue;
            localDivideOp1 = DivideOp.quotient;
            localAddOp1 = AddOp.$Mn;
            localIntNum1 = printf.Lit7;
            localObject5 = localDivideOp1.apply2(localAddOp1.apply2(paramObject4, localIntNum1), printf.Lit61);
            continue;
            if (bool1)
            {
              localObject7 = Boolean.TRUE;
            }
            else
            {
              localObject7 = Boolean.FALSE;
              continue;
              continue;
              if (Scheme.isEqv.apply2(this.fc, printf.Lit58) != Boolean.FALSE) {
                str2 = " ";
              } else {
                localObject4 = Values.empty;
              }
            }
          }
        }
      }
      arrayOfObject1 = new Object[3];
      arrayOfObject2 = new Object[0];
      arrayOfObject1[0] = lambda30formatReal$V(paramObject1, paramObject2, paramObject3, paramObject4, arrayOfObject2);
      arrayOfObject1[1] = Scheme.apply.apply3(this.format$Mnreal, Boolean.TRUE, localLList);
      arrayOfObject1[2] = printf.Lit63;
      return append.append$V(arrayOfObject1);
    }
    
    Object lambda31$V(Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      Apply localApply1 = Scheme.apply;
      Procedure localProcedure = this.staticLink.pad;
      Apply localApply2 = Scheme.apply;
      Object[] arrayOfObject = new Object[6];
      arrayOfObject[0] = this.format$Mnreal;
      arrayOfObject[1] = this.staticLink.signed;
      arrayOfObject[2] = paramObject1;
      arrayOfObject[3] = paramObject2;
      arrayOfObject[4] = paramObject3;
      arrayOfObject[5] = localLList;
      return localApply1.apply2(localProcedure, localApply2.applyN(arrayOfObject));
    }
    
    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
      case 14: 
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
  }
  
  public class frame12
    extends ModuleBody
  {
    Object cnt;
    final ModuleMethod lambda$Fn18;
    Object port;
    
    public frame12()
    {
      this$1 = new ModuleMethod(this, 20, null, 4097);
      this$1.setProperty("source-location", "printf.scm:546");
      this.lambda$Fn18 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 20) {
        return lambda32(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Boolean lambda32(Object paramObject)
    {
      AddOp localAddOp;
      if (strings.isString(paramObject)) {
        localAddOp = AddOp.$Pl;
      }
      try
      {
        CharSequence localCharSequence = (CharSequence)paramObject;
        this.cnt = localAddOp.apply2(Integer.valueOf(strings.stringLength(localCharSequence)), this.cnt);
        ports.display(paramObject, this.port);
        return Boolean.TRUE;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "string-length", 1, paramObject);
      }
      this.cnt = AddOp.$Pl.apply2(printf.Lit7, this.cnt);
      ports.display(paramObject, this.port);
      return Boolean.TRUE;
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 20)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame13
    extends ModuleBody
  {
    Object cnt;
    Object end;
    final ModuleMethod lambda$Fn19;
    Object s;
    Object str;
    
    public frame13()
    {
      this$1 = new ModuleMethod(this, 21, null, 4097);
      this$1.setProperty("source-location", "printf.scm:564");
      this.lambda$Fn19 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 21)
      {
        if (lambda33(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda33(Object paramObject)
    {
      NumberCompare localNumberCompare;
      Object localObject10;
      if (strings.isString(paramObject)) {
        if (this.str == Boolean.FALSE)
        {
          localNumberCompare = Scheme.numGEq;
          localObject10 = AddOp.$Mn.apply2(this.end, this.cnt);
        }
      }
      for (;;)
      {
        Object localObject7;
        Object localObject8;
        Object localObject9;
        try
        {
          CharSequence localCharSequence4 = (CharSequence)paramObject;
          if (localNumberCompare.apply2(localObject10, Integer.valueOf(strings.stringLength(localCharSequence4))) != Boolean.FALSE) {
            arrayOfObject2 = new Object[2];
          }
        }
        catch (ClassCastException localClassCastException11)
        {
          Object[] arrayOfObject2;
          CharSequence localCharSequence2;
          Object localObject6;
          CharSeq localCharSeq2;
          int n;
          CharSequence localCharSequence3;
          int i1;
          Object[] arrayOfObject3;
          throw new WrongType(localClassCastException11, "string-length", 1, paramObject);
        }
        try
        {
          localCharSequence2 = (CharSequence)paramObject;
          arrayOfObject2[0] = Integer.valueOf(strings.stringLength(localCharSequence2));
          arrayOfObject2[1] = AddOp.$Mn.apply2(this.end, this.cnt);
          localObject6 = numbers.min(arrayOfObject2);
          localObject7 = printf.Lit1;
          if (Scheme.numGEq.apply2(localObject7, localObject6) == Boolean.FALSE) {
            localObject8 = this.s;
          }
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "string-length", 1, paramObject);
        }
        try
        {
          localCharSeq2 = (CharSeq)localObject8;
          localObject9 = this.cnt;
        }
        catch (ClassCastException localClassCastException7)
        {
          throw new WrongType(localClassCastException7, "string-set!", 1, localObject8);
        }
        try
        {
          n = ((Number)localObject9).intValue();
        }
        catch (ClassCastException localClassCastException8)
        {
          throw new WrongType(localClassCastException8, "string-set!", 2, localObject9);
        }
        try
        {
          localCharSequence3 = (CharSequence)paramObject;
        }
        catch (ClassCastException localClassCastException9)
        {
          throw new WrongType(localClassCastException9, "string-ref", 1, paramObject);
        }
        try
        {
          i1 = ((Number)localObject7).intValue();
          strings.stringSet$Ex(localCharSeq2, n, strings.stringRef(localCharSequence3, i1));
          this.cnt = AddOp.$Pl.apply2(this.cnt, printf.Lit7);
          localObject7 = AddOp.$Pl.apply2(localObject7, printf.Lit7);
        }
        catch (ClassCastException localClassCastException10)
        {
          throw new WrongType(localClassCastException10, "string-ref", 2, localObject7);
        }
      }
      arrayOfObject3 = new Object[2];
      localObject11 = this.s;
      for (;;)
      {
        try
        {
          localCharSequence5 = (CharSequence)localObject11;
          localObject12 = this.cnt;
        }
        catch (ClassCastException localClassCastException12)
        {
          CharSequence localCharSequence5;
          int i2;
          CharSequence localCharSequence6;
          int m;
          Object localObject1;
          Boolean localBoolean;
          int i;
          int j;
          CharSequence localCharSequence1;
          CharSeq localCharSeq1;
          int k;
          char c2;
          char c1;
          throw new WrongType(localClassCastException12, "substring", 1, localObject11);
        }
        try
        {
          i2 = ((Number)localObject12).intValue();
          arrayOfObject3[0] = strings.substring(localCharSequence5, 0, i2);
          arrayOfObject3[1] = paramObject;
          this.s = strings.stringAppend(arrayOfObject3);
          localObject13 = this.s;
        }
        catch (ClassCastException localClassCastException13)
        {
          throw new WrongType(localClassCastException13, "substring", 3, localObject12);
        }
        try
        {
          localCharSequence6 = (CharSequence)localObject13;
          this.cnt = Integer.valueOf(strings.stringLength(localCharSequence6));
          this.end = this.cnt;
          if (this.str != Boolean.FALSE) {
            if (Scheme.numGEq.apply2(this.cnt, this.end) != Boolean.FALSE)
            {
              m = 1;
              return 0x1 & m + 1;
              if (this.str != Boolean.FALSE)
              {
                localObject1 = Scheme.numGEq.apply2(this.cnt, this.end);
                if (localObject1 != Boolean.FALSE) {
                  continue;
                }
                localObject2 = this.str;
              }
            }
          }
        }
        catch (ClassCastException localClassCastException14)
        {
          throw new WrongType(localClassCastException14, "string-length", 1, localObject13);
        }
        try
        {
          localBoolean = Boolean.FALSE;
          if (localObject2 != localBoolean)
          {
            i = 1;
            j = 0x1 & i + 1;
            if (j == 0) {
              continue;
            }
            if (Scheme.numGEq.apply2(this.cnt, this.end) != Boolean.FALSE)
            {
              Object[] arrayOfObject1 = new Object[2];
              arrayOfObject1[0] = this.s;
              arrayOfObject1[1] = strings.makeString(100);
              this.s = strings.stringAppend(arrayOfObject1);
              localObject3 = this.s;
            }
          }
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "x", -2, localObject2);
        }
        try
        {
          localCharSequence1 = (CharSequence)localObject3;
          this.end = Integer.valueOf(strings.stringLength(localCharSequence1));
          localObject4 = this.s;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-length", 1, localObject3);
        }
        try
        {
          localCharSeq1 = (CharSeq)localObject4;
          localObject5 = this.cnt;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-set!", 1, localObject4);
        }
        try
        {
          k = ((Number)localObject5).intValue();
          if (!characters.isChar(paramObject)) {}
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "string-set!", 2, localObject5);
        }
        try
        {
          c2 = ((Char)paramObject).charValue();
          c1 = c2;
          strings.stringSet$Ex(localCharSeq1, k, c1);
          this.cnt = AddOp.$Pl.apply2(this.cnt, printf.Lit7);
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "string-set!", 3, paramObject);
        }
        localObject1 = this.str;
        continue;
        i = 0;
        continue;
        if (j != 0)
        {
          continue;
          c1 = '?';
          continue;
          m = 0;
          continue;
          if (this.str != Boolean.FALSE) {
            m = 1;
          } else {
            m = 0;
          }
        }
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 21)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame2
    extends ModuleBody
  {
    Object cont;
    final ModuleMethod lambda$Fn5;
    final ModuleMethod lambda$Fn6;
    printf.frame staticLink;
    
    public frame2()
    {
      this$1 = new ModuleMethod(this, 10, null, 8194);
      this$1.setProperty("source-location", "printf.scm:81");
      this.lambda$Fn6 = this$1;
      ModuleMethod localModuleMethod = new ModuleMethod(this, 11, null, 4097);
      localModuleMethod.setProperty("source-location", "printf.scm:78");
      this.lambda$Fn5 = localModuleMethod;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 11) {
        return lambda9(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 10) {
        return lambda10(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda10(Object paramObject1, Object paramObject2)
    {
      printf.frame3 localframe3 = new printf.frame3();
      localframe3.staticLink = this;
      localframe3.sgn = paramObject2;
      return this.staticLink.lambda3digits(paramObject1, localframe3.lambda$Fn7);
    }
    
    Object lambda9(Object paramObject)
    {
      return this.staticLink.lambda2sign(paramObject, this.lambda$Fn6);
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
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 10)
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
  
  public class frame3
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn7;
    Object sgn;
    printf.frame2 staticLink;
    
    public frame3()
    {
      this$1 = new ModuleMethod(this, 9, null, 8194);
      this$1.setProperty("source-location", "printf.scm:84");
      this.lambda$Fn7 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 9) {
        return lambda11(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    /* Error */
    Object lambda11(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: new 47	gnu/kawa/slib/printf$frame4
      //   3: dup
      //   4: invokespecial 48	gnu/kawa/slib/printf$frame4:<init>	()V
      //   7: astore_3
      //   8: aload_3
      //   9: aload_0
      //   10: putfield 51	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   13: aload_3
      //   14: aload_2
      //   15: putfield 54	gnu/kawa/slib/printf$frame4:idigs	Ljava/lang/Object;
      //   18: aload_3
      //   19: getfield 57	gnu/kawa/slib/printf$frame4:lambda$Fn8	Lgnu/expr/ModuleMethod;
      //   22: astore 4
      //   24: getstatic 63	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   27: aload_1
      //   28: aload_0
      //   29: getfield 65	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   32: getfield 70	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   35: getfield 75	gnu/kawa/slib/printf$frame:n	I
      //   38: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   41: invokevirtual 85	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   44: astore 5
      //   46: aload 5
      //   48: checkcast 87	java/lang/Boolean
      //   51: invokevirtual 91	java/lang/Boolean:booleanValue	()Z
      //   54: istore 7
      //   56: iload 7
      //   58: ifeq +73 -> 131
      //   61: getstatic 97	gnu/kawa/slib/printf:Lit11	Lgnu/text/Char;
      //   64: astore 8
      //   66: aload_0
      //   67: getfield 65	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   70: getfield 70	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   73: getfield 100	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   76: astore 9
      //   78: aload 9
      //   80: checkcast 102	java/lang/CharSequence
      //   83: astore 11
      //   85: aload_1
      //   86: checkcast 104	java/lang/Number
      //   89: invokevirtual 108	java/lang/Number:intValue	()I
      //   92: istore 13
      //   94: aload 8
      //   96: aload 11
      //   98: iload 13
      //   100: invokestatic 114	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   103: invokestatic 120	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   106: invokestatic 126	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   109: ifeq +27 -> 136
      //   112: getstatic 130	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   115: aload 4
      //   117: getstatic 136	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   120: aload_1
      //   121: getstatic 140	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   124: invokevirtual 85	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   127: invokevirtual 85	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   130: areturn
      //   131: iload 7
      //   133: ifne -21 -> 112
      //   136: getstatic 130	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   139: aload 4
      //   141: aload_1
      //   142: invokevirtual 85	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   145: areturn
      //   146: astore 6
      //   148: new 142	gnu/mapping/WrongType
      //   151: dup
      //   152: aload 6
      //   154: ldc 144
      //   156: bipush 254
      //   158: aload 5
      //   160: invokespecial 147	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   163: athrow
      //   164: astore 10
      //   166: new 142	gnu/mapping/WrongType
      //   169: dup
      //   170: aload 10
      //   172: ldc 149
      //   174: iconst_1
      //   175: aload 9
      //   177: invokespecial 147	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   180: athrow
      //   181: astore 12
      //   183: new 142	gnu/mapping/WrongType
      //   186: dup
      //   187: aload 12
      //   189: ldc 149
      //   191: iconst_2
      //   192: aload_1
      //   193: invokespecial 147	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   196: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	197	0	this	frame3
      //   0	197	1	paramObject1	Object
      //   0	197	2	paramObject2	Object
      //   7	12	3	localframe4	printf.frame4
      //   22	118	4	localModuleMethod	ModuleMethod
      //   44	115	5	localObject1	Object
      //   146	7	6	localClassCastException1	ClassCastException
      //   54	78	7	bool	boolean
      //   64	31	8	localChar	Char
      //   76	100	9	localObject2	Object
      //   164	7	10	localClassCastException2	ClassCastException
      //   83	14	11	localCharSequence	CharSequence
      //   181	7	12	localClassCastException3	ClassCastException
      //   92	7	13	i	int
      // Exception table:
      //   from	to	target	type
      //   46	56	146	java/lang/ClassCastException
      //   78	85	164	java/lang/ClassCastException
      //   85	94	181	java/lang/ClassCastException
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
  
  public class frame4
    extends ModuleBody
  {
    Object idigs;
    final ModuleMethod lambda$Fn8;
    final ModuleMethod lambda$Fn9;
    printf.frame3 staticLink;
    
    public frame4()
    {
      this$1 = new ModuleMethod(this, 7, null, 8194);
      this$1.setProperty("source-location", "printf.scm:90");
      this.lambda$Fn9 = this$1;
      ModuleMethod localModuleMethod = new ModuleMethod(this, 8, null, 4097);
      localModuleMethod.setProperty("source-location", "printf.scm:87");
      this.lambda$Fn8 = localModuleMethod;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 8) {
        return lambda12(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 7) {
        return lambda13(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda12(Object paramObject)
    {
      return this.staticLink.staticLink.staticLink.lambda3digits(paramObject, this.lambda$Fn9);
    }
    
    /* Error */
    Object lambda13(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: new 77	gnu/kawa/slib/printf$frame5
      //   3: dup
      //   4: invokespecial 78	gnu/kawa/slib/printf$frame5:<init>	()V
      //   7: astore_3
      //   8: aload_3
      //   9: aload_0
      //   10: putfield 81	gnu/kawa/slib/printf$frame5:staticLink	Lgnu/kawa/slib/printf$frame4;
      //   13: aload_3
      //   14: aload_2
      //   15: putfield 84	gnu/kawa/slib/printf$frame5:fdigs	Ljava/lang/Object;
      //   18: aload_3
      //   19: getfield 87	gnu/kawa/slib/printf$frame5:lambda$Fn10	Lgnu/expr/ModuleMethod;
      //   22: astore 4
      //   24: aload_0
      //   25: getfield 58	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   28: getfield 63	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   31: getfield 68	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   34: astore 5
      //   36: new 89	gnu/kawa/slib/printf$frame6
      //   39: dup
      //   40: invokespecial 90	gnu/kawa/slib/printf$frame6:<init>	()V
      //   43: astore 6
      //   45: aload 6
      //   47: aload 5
      //   49: putfield 91	gnu/kawa/slib/printf$frame6:staticLink	Lgnu/kawa/slib/printf$frame;
      //   52: aload 6
      //   54: aload 4
      //   56: putfield 94	gnu/kawa/slib/printf$frame6:cont	Ljava/lang/Object;
      //   59: getstatic 100	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   62: aload_1
      //   63: aload_0
      //   64: getfield 58	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   67: getfield 63	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   70: getfield 68	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   73: getfield 103	gnu/kawa/slib/printf$frame:n	I
      //   76: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   79: invokevirtual 113	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   82: getstatic 119	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   85: if_acmpeq +19 -> 104
      //   88: getstatic 123	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   91: aload 6
      //   93: getfield 94	gnu/kawa/slib/printf$frame6:cont	Ljava/lang/Object;
      //   96: aload_1
      //   97: getstatic 129	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   100: invokevirtual 133	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   103: areturn
      //   104: aload_0
      //   105: getfield 58	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   108: getfield 63	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   111: getfield 68	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   114: getfield 136	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   117: astore 7
      //   119: aload 7
      //   121: checkcast 138	java/lang/CharSequence
      //   124: astore 9
      //   126: aload_1
      //   127: checkcast 140	java/lang/Number
      //   130: invokevirtual 144	java/lang/Number:intValue	()I
      //   133: istore 11
      //   135: aload 9
      //   137: iload 11
      //   139: invokestatic 150	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   142: invokestatic 156	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   145: getstatic 160	gnu/kawa/slib/printf:Lit10	Lgnu/lists/PairWithPosition;
      //   148: invokestatic 165	kawa/lib/lists:memv	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   151: getstatic 119	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   154: if_acmpeq +32 -> 186
      //   157: aload_0
      //   158: getfield 58	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   161: getfield 63	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   164: getfield 68	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   167: getstatic 171	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   170: aload_1
      //   171: getstatic 174	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   174: invokevirtual 113	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   177: aload 6
      //   179: getfield 177	gnu/kawa/slib/printf$frame6:lambda$Fn11	Lgnu/expr/ModuleMethod;
      //   182: invokevirtual 180	gnu/kawa/slib/printf$frame:lambda2sign	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   185: areturn
      //   186: getstatic 123	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   189: aload 6
      //   191: getfield 94	gnu/kawa/slib/printf$frame6:cont	Ljava/lang/Object;
      //   194: aload_1
      //   195: getstatic 129	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   198: invokevirtual 133	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   201: areturn
      //   202: astore 8
      //   204: new 182	gnu/mapping/WrongType
      //   207: dup
      //   208: aload 8
      //   210: ldc 184
      //   212: iconst_1
      //   213: aload 7
      //   215: invokespecial 187	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   218: athrow
      //   219: astore 10
      //   221: new 182	gnu/mapping/WrongType
      //   224: dup
      //   225: aload 10
      //   227: ldc 184
      //   229: iconst_2
      //   230: aload_1
      //   231: invokespecial 187	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   234: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	235	0	this	frame4
      //   0	235	1	paramObject1	Object
      //   0	235	2	paramObject2	Object
      //   7	12	3	localframe5	printf.frame5
      //   22	33	4	localModuleMethod	ModuleMethod
      //   34	14	5	localframe	printf.frame
      //   43	147	6	localframe6	printf.frame6
      //   117	97	7	localObject	Object
      //   202	7	8	localClassCastException1	ClassCastException
      //   124	12	9	localCharSequence	CharSequence
      //   219	7	10	localClassCastException2	ClassCastException
      //   133	5	11	i	int
      // Exception table:
      //   from	to	target	type
      //   119	126	202	java/lang/ClassCastException
      //   126	135	219	java/lang/ClassCastException
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
  
  public class frame5
    extends ModuleBody
  {
    Object fdigs;
    final ModuleMethod lambda$Fn10;
    printf.frame4 staticLink;
    
    public frame5()
    {
      this$1 = new ModuleMethod(this, 6, null, 8194);
      this$1.setProperty("source-location", "printf.scm:92");
      this.lambda$Fn10 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 6) {
        return lambda14(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda14(Object paramObject1, Object paramObject2)
    {
      Object[] arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = "0";
      arrayOfObject1[1] = this.staticLink.idigs;
      arrayOfObject1[2] = this.fdigs;
      localFString = strings.stringAppend(arrayOfObject1);
      i = strings.stringLength(localFString);
      localObject1 = printf.Lit7;
      AddOp localAddOp = AddOp.$Pl;
      localObject2 = this.staticLink.idigs;
      try
      {
        CharSequence localCharSequence = (CharSequence)localObject2;
        localObject3 = localAddOp.apply2(paramObject2, Integer.valueOf(strings.stringLength(localCharSequence)));
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          for (;;)
          {
            ApplyToArgs localApplyToArgs2;
            Object[] arrayOfObject3;
            Char localChar;
            int j = ((Number)localObject1).intValue();
            if (!characters.isChar$Eq(localChar, Char.make(strings.stringRef(localFString, j)))) {
              break;
            }
            localObject1 = AddOp.$Pl.apply2(localObject1, printf.Lit7);
            localObject3 = AddOp.$Mn.apply2(localObject3, printf.Lit7);
          }
          localApplyToArgs1 = Scheme.applyToArgs;
          arrayOfObject2 = new Object[5];
          arrayOfObject2[0] = this.staticLink.staticLink.staticLink.cont;
          arrayOfObject2[1] = paramObject1;
          arrayOfObject2[2] = this.staticLink.staticLink.sgn;
          localObject4 = AddOp.$Mn.apply2(localObject1, printf.Lit7);
        }
        catch (ClassCastException localClassCastException2)
        {
          Object localObject3;
          ApplyToArgs localApplyToArgs1;
          Object[] arrayOfObject2;
          int k;
          throw new WrongType(localClassCastException2, "string-ref", 2, localObject1);
        }
        try
        {
          k = ((Number)localObject4).intValue();
          arrayOfObject2[3] = strings.substring(localFString, k, i);
          arrayOfObject2[4] = localObject3;
          return localApplyToArgs1.applyN(arrayOfObject2);
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "substring", 2, localObject4);
        }
        localClassCastException1 = localClassCastException1;
        throw new WrongType(localClassCastException1, "string-length", 1, localObject2);
      }
      if (Scheme.numGEq.apply2(localObject1, Integer.valueOf(i)) != Boolean.FALSE)
      {
        localApplyToArgs2 = Scheme.applyToArgs;
        arrayOfObject3 = new Object[5];
        arrayOfObject3[0] = this.staticLink.staticLink.staticLink.cont;
        arrayOfObject3[1] = paramObject1;
        arrayOfObject3[2] = this.staticLink.staticLink.sgn;
        arrayOfObject3[3] = "0";
        arrayOfObject3[4] = printf.Lit7;
        return localApplyToArgs2.applyN(arrayOfObject3);
      }
      localChar = printf.Lit9;
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 6)
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
    Object cont;
    final ModuleMethod lambda$Fn11;
    printf.frame staticLink;
    
    public frame6()
    {
      this$1 = new ModuleMethod(this, 5, null, 8194);
      this$1.setProperty("source-location", "printf.scm:67");
      this.lambda$Fn11 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 5) {
        return lambda15(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda15(Object paramObject1, Object paramObject2)
    {
      printf.frame7 localframe7 = new printf.frame7();
      localframe7.staticLink = this;
      localframe7.sgn = paramObject2;
      return this.staticLink.lambda3digits(paramObject1, localframe7.lambda$Fn12);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 5)
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
    final ModuleMethod lambda$Fn12;
    Object sgn;
    printf.frame6 staticLink;
    
    public frame7()
    {
      this$1 = new ModuleMethod(this, 4, null, 8194);
      this$1.setProperty("source-location", "printf.scm:69");
      this.lambda$Fn12 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 4) {
        return lambda16(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    /* Error */
    Object lambda16(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   3: astore_3
      //   4: aload_0
      //   5: getfield 53	gnu/kawa/slib/printf$frame7:staticLink	Lgnu/kawa/slib/printf$frame6;
      //   8: getfield 58	gnu/kawa/slib/printf$frame6:cont	Ljava/lang/Object;
      //   11: astore 4
      //   13: getstatic 64	gnu/kawa/slib/printf:Lit5	Lgnu/text/Char;
      //   16: astore 5
      //   18: aload_0
      //   19: getfield 66	gnu/kawa/slib/printf$frame7:sgn	Ljava/lang/Object;
      //   22: astore 6
      //   24: aload 6
      //   26: checkcast 68	gnu/text/Char
      //   29: astore 8
      //   31: aload 5
      //   33: aload 8
      //   35: invokestatic 74	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   38: ifeq +36 -> 74
      //   41: getstatic 80	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   44: astore 12
      //   46: aload_2
      //   47: checkcast 82	java/lang/CharSequence
      //   50: astore 14
      //   52: aload 12
      //   54: aload 14
      //   56: invokestatic 88	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
      //   59: invokevirtual 94	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   62: astore 11
      //   64: aload_3
      //   65: aload 4
      //   67: aload_1
      //   68: aload 11
      //   70: invokevirtual 98	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   73: areturn
      //   74: aload_2
      //   75: checkcast 82	java/lang/CharSequence
      //   78: astore 10
      //   80: aload 10
      //   82: invokestatic 88	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
      //   85: astore 11
      //   87: goto -23 -> 64
      //   90: astore 7
      //   92: new 100	gnu/mapping/WrongType
      //   95: dup
      //   96: aload 7
      //   98: ldc 102
      //   100: iconst_2
      //   101: aload 6
      //   103: invokespecial 105	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   106: athrow
      //   107: astore 13
      //   109: new 100	gnu/mapping/WrongType
      //   112: dup
      //   113: aload 13
      //   115: ldc 107
      //   117: iconst_1
      //   118: aload_2
      //   119: invokespecial 105	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   122: athrow
      //   123: astore 9
      //   125: new 100	gnu/mapping/WrongType
      //   128: dup
      //   129: aload 9
      //   131: ldc 107
      //   133: iconst_1
      //   134: aload_2
      //   135: invokespecial 105	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   138: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	139	0	this	frame7
      //   0	139	1	paramObject1	Object
      //   0	139	2	paramObject2	Object
      //   3	62	3	localApplyToArgs	ApplyToArgs
      //   11	55	4	localObject1	Object
      //   16	16	5	localChar1	Char
      //   22	80	6	localObject2	Object
      //   90	7	7	localClassCastException1	ClassCastException
      //   29	5	8	localChar2	Char
      //   123	7	9	localClassCastException2	ClassCastException
      //   78	3	10	localCharSequence1	CharSequence
      //   62	24	11	localObject3	Object
      //   44	9	12	localAddOp	AddOp
      //   107	7	13	localClassCastException3	ClassCastException
      //   50	5	14	localCharSequence2	CharSequence
      // Exception table:
      //   from	to	target	type
      //   24	31	90	java/lang/ClassCastException
      //   46	52	107	java/lang/ClassCastException
      //   74	80	123	java/lang/ClassCastException
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 4)
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
    CharSequence str;
    
    public Object lambda17dig(Object paramObject)
    {
      CharSequence localCharSequence = this.str;
      try
      {
        int i = ((Number)paramObject).intValue();
        int j = strings.stringRef(localCharSequence, i);
        if (unicode.isCharNumeric(Char.make(j)))
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Char.make(j);
          return numbers.string$To$Number(strings.$make$string$(arrayOfObject));
        }
        return printf.Lit1;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "string-ref", 2, paramObject);
      }
    }
  }
  
  public class frame9
    extends ModuleBody
  {
    LList args;
    Object fc;
    int fl;
    Object format$Mnstring;
    Object out;
    Object pos;
    
    /* Error */
    public Object lambda18mustAdvance()
    {
      // Byte code:
      //   0: aload_0
      //   1: getstatic 27	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   4: getstatic 33	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   7: aload_0
      //   8: getfield 35	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
      //   11: invokevirtual 41	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   14: putfield 35	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
      //   17: getstatic 47	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   20: aload_0
      //   21: getfield 35	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
      //   24: aload_0
      //   25: getfield 49	gnu/kawa/slib/printf$frame9:fl	I
      //   28: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   31: invokevirtual 41	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   34: getstatic 61	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   37: if_acmpeq +8 -> 45
      //   40: aload_0
      //   41: invokevirtual 64	gnu/kawa/slib/printf$frame9:lambda20incomplete	()Ljava/lang/Object;
      //   44: areturn
      //   45: aload_0
      //   46: getfield 66	gnu/kawa/slib/printf$frame9:format$Mnstring	Ljava/lang/Object;
      //   49: astore_1
      //   50: aload_1
      //   51: checkcast 68	java/lang/CharSequence
      //   54: astore_3
      //   55: aload_0
      //   56: getfield 35	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
      //   59: astore 4
      //   61: aload 4
      //   63: checkcast 70	java/lang/Number
      //   66: invokevirtual 74	java/lang/Number:intValue	()I
      //   69: istore 6
      //   71: aload_0
      //   72: aload_3
      //   73: iload 6
      //   75: invokestatic 80	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   78: invokestatic 86	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   81: putfield 88	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
      //   84: getstatic 94	gnu/mapping/Values:empty	Lgnu/mapping/Values;
      //   87: areturn
      //   88: astore_2
      //   89: new 96	gnu/mapping/WrongType
      //   92: dup
      //   93: aload_2
      //   94: ldc 98
      //   96: iconst_1
      //   97: aload_1
      //   98: invokespecial 101	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   101: athrow
      //   102: astore 5
      //   104: new 96	gnu/mapping/WrongType
      //   107: dup
      //   108: aload 5
      //   110: ldc 98
      //   112: iconst_2
      //   113: aload 4
      //   115: invokespecial 101	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   118: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	119	0	this	frame9
      //   49	49	1	localObject1	Object
      //   88	6	2	localClassCastException1	ClassCastException
      //   54	19	3	localCharSequence	CharSequence
      //   59	55	4	localObject2	Object
      //   102	7	5	localClassCastException2	ClassCastException
      //   69	5	6	i	int
      // Exception table:
      //   from	to	target	type
      //   50	55	88	java/lang/ClassCastException
      //   61	71	102	java/lang/ClassCastException
    }
    
    public boolean lambda19isEndOfFormat()
    {
      return ((Boolean)Scheme.numGEq.apply2(this.pos, Integer.valueOf(this.fl))).booleanValue();
    }
    
    public Object lambda20incomplete()
    {
      SimpleSymbol localSimpleSymbol = printf.Lit34;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "conversion specification incomplete";
      arrayOfObject[1] = this.format$Mnstring;
      return misc.error$V(localSimpleSymbol, arrayOfObject);
    }
    
    public Object lambda21out$St(Object paramObject)
    {
      if (strings.isString(paramObject)) {
        return Scheme.applyToArgs.apply2(this.out, paramObject);
      }
      Object localObject;
      boolean bool;
      do
      {
        localObject = Scheme.applyToArgs.apply2(this.out, lists.car.apply1(paramObject));
        if (localObject == Boolean.FALSE) {
          break;
        }
        paramObject = lists.cdr.apply1(paramObject);
        bool = lists.isNull(paramObject);
      } while (!bool);
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
      return localObject;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.printf
 * JD-Core Version:    0.7.0.1
 */