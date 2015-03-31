package kawa.lib;

import gnu.expr.GenericProc;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LispReader;
import gnu.lists.FString;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.BitOps;
import gnu.math.Complex;
import gnu.math.DComplex;
import gnu.math.Duration;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.Quantity;
import gnu.math.RatNum;
import gnu.math.RealNum;
import gnu.math.Unit;
import java.math.BigDecimal;
import java.math.BigInteger;
import kawa.standard.Scheme;

public class numbers
  extends ModuleBody
{
  public static final numbers $instance;
  static final IntNum Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit15;
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
  static final SimpleSymbol Lit63 = (SimpleSymbol)new SimpleSymbol("duration").readResolve();
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod abs;
  public static final ModuleMethod acos;
  public static final ModuleMethod angle;
  public static final ModuleMethod asin;
  public static final GenericProc atan;
  public static final ModuleMethod bitwise$Mnbit$Mncount;
  public static final ModuleMethod bitwise$Mnbit$Mnfield;
  public static final ModuleMethod bitwise$Mnbit$Mnset$Qu;
  public static final ModuleMethod bitwise$Mncopy$Mnbit;
  public static final ModuleMethod bitwise$Mncopy$Mnbit$Mnfield;
  public static final ModuleMethod bitwise$Mnfirst$Mnbit$Mnset;
  public static final ModuleMethod bitwise$Mnif;
  public static final ModuleMethod bitwise$Mnlength;
  public static final ModuleMethod bitwise$Mnreverse$Mnbit$Mnfield;
  public static final ModuleMethod bitwise$Mnrotate$Mnbit$Mnfield;
  public static final ModuleMethod ceiling;
  public static final ModuleMethod complex$Qu;
  public static final ModuleMethod cos;
  public static final ModuleMethod denominator;
  public static final ModuleMethod div$Mnand$Mnmod;
  public static final ModuleMethod div0$Mnand$Mnmod0;
  public static final ModuleMethod duration;
  public static final ModuleMethod exact;
  public static final ModuleMethod exact$Mn$Grinexact;
  public static final ModuleMethod exact$Qu;
  public static final ModuleMethod exp;
  public static final ModuleMethod floor;
  public static final ModuleMethod gcd;
  public static final ModuleMethod imag$Mnpart;
  public static final ModuleMethod inexact;
  public static final ModuleMethod inexact$Mn$Grexact;
  public static final ModuleMethod inexact$Qu;
  public static final ModuleMethod integer$Qu;
  static final ModuleMethod lambda$Fn1;
  static final ModuleMethod lambda$Fn2;
  static final ModuleMethod lambda$Fn3;
  static final ModuleMethod lambda$Fn4;
  public static final ModuleMethod lcm;
  public static final ModuleMethod log;
  public static final ModuleMethod logcount;
  public static final ModuleMethod logop;
  public static final ModuleMethod logtest;
  public static final ModuleMethod magnitude;
  public static final ModuleMethod make$Mnpolar;
  public static final ModuleMethod make$Mnquantity;
  public static final ModuleMethod make$Mnrectangular;
  public static final ModuleMethod max;
  public static final ModuleMethod min;
  public static final ModuleMethod negative$Qu;
  public static final ModuleMethod number$Mn$Grstring;
  public static final ModuleMethod number$Qu;
  public static final ModuleMethod numerator;
  public static final ModuleMethod positive$Qu;
  public static final ModuleMethod quantity$Mn$Grnumber;
  public static final ModuleMethod quantity$Mn$Grunit;
  public static final ModuleMethod quantity$Qu;
  public static final ModuleMethod rational$Qu;
  public static final ModuleMethod rationalize;
  public static final ModuleMethod real$Mnpart;
  public static final ModuleMethod real$Qu;
  public static final ModuleMethod round;
  public static final ModuleMethod sin;
  public static final GenericProc sqrt;
  public static final ModuleMethod string$Mn$Grnumber;
  public static final ModuleMethod tan;
  public static final ModuleMethod truncate;
  public static final ModuleMethod zero$Qu;
  
  static
  {
    Lit62 = (SimpleSymbol)new SimpleSymbol("make-quantity").readResolve();
    Lit61 = (SimpleSymbol)new SimpleSymbol("quantity->unit").readResolve();
    Lit60 = (SimpleSymbol)new SimpleSymbol("quantity->number").readResolve();
    Lit59 = (SimpleSymbol)new SimpleSymbol("string->number").readResolve();
    Lit58 = (SimpleSymbol)new SimpleSymbol("number->string").readResolve();
    Lit57 = (SimpleSymbol)new SimpleSymbol("bitwise-reverse-bit-field").readResolve();
    Lit56 = (SimpleSymbol)new SimpleSymbol("bitwise-rotate-bit-field").readResolve();
    Lit55 = (SimpleSymbol)new SimpleSymbol("bitwise-first-bit-set").readResolve();
    Lit54 = (SimpleSymbol)new SimpleSymbol("bitwise-length").readResolve();
    Lit53 = (SimpleSymbol)new SimpleSymbol("bitwise-bit-count").readResolve();
    Lit52 = (SimpleSymbol)new SimpleSymbol("logcount").readResolve();
    Lit51 = (SimpleSymbol)new SimpleSymbol("logtest").readResolve();
    Lit50 = (SimpleSymbol)new SimpleSymbol("bitwise-if").readResolve();
    Lit49 = (SimpleSymbol)new SimpleSymbol("bitwise-bit-field").readResolve();
    Lit48 = (SimpleSymbol)new SimpleSymbol("bitwise-copy-bit-field").readResolve();
    Lit47 = (SimpleSymbol)new SimpleSymbol("bitwise-copy-bit").readResolve();
    Lit46 = (SimpleSymbol)new SimpleSymbol("bitwise-bit-set?").readResolve();
    Lit45 = (SimpleSymbol)new SimpleSymbol("logop").readResolve();
    Lit44 = (SimpleSymbol)new SimpleSymbol("inexact->exact").readResolve();
    Lit43 = (SimpleSymbol)new SimpleSymbol("exact->inexact").readResolve();
    Lit42 = (SimpleSymbol)new SimpleSymbol("exact").readResolve();
    Lit41 = (SimpleSymbol)new SimpleSymbol("inexact").readResolve();
    Lit40 = (SimpleSymbol)new SimpleSymbol("angle").readResolve();
    Lit39 = (SimpleSymbol)new SimpleSymbol("magnitude").readResolve();
    Lit38 = (SimpleSymbol)new SimpleSymbol("imag-part").readResolve();
    Lit37 = (SimpleSymbol)new SimpleSymbol("real-part").readResolve();
    Lit36 = (SimpleSymbol)new SimpleSymbol("make-polar").readResolve();
    Lit35 = (SimpleSymbol)new SimpleSymbol("make-rectangular").readResolve();
    Lit34 = (SimpleSymbol)new SimpleSymbol("acos").readResolve();
    Lit33 = (SimpleSymbol)new SimpleSymbol("asin").readResolve();
    Lit32 = (SimpleSymbol)new SimpleSymbol("tan").readResolve();
    Lit31 = (SimpleSymbol)new SimpleSymbol("cos").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("sin").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("log").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("exp").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("rationalize").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("round").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("truncate").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("ceiling").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("floor").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("denominator").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("numerator").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("lcm").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("gcd").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("div0-and-mod0").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("div-and-mod").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("abs").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("min").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("max").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("negative?").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("positive?").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("zero?").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("inexact?").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("exact?").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("integer?").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("rational?").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("real?").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("complex?").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("quantity?").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("number?").readResolve();
    Lit2 = IntNum.make(1);
    Lit1 = (SimpleSymbol)new SimpleSymbol("signum").readResolve();
    Lit0 = IntNum.make(0);
    $instance = new numbers();
    numbers localnumbers = $instance;
    number$Qu = new ModuleMethod(localnumbers, 1, Lit3, 4097);
    quantity$Qu = new ModuleMethod(localnumbers, 2, Lit4, 4097);
    complex$Qu = new ModuleMethod(localnumbers, 3, Lit5, 4097);
    real$Qu = new ModuleMethod(localnumbers, 4, Lit6, 4097);
    rational$Qu = new ModuleMethod(localnumbers, 5, Lit7, 4097);
    integer$Qu = new ModuleMethod(localnumbers, 6, Lit8, 4097);
    exact$Qu = new ModuleMethod(localnumbers, 7, Lit9, 4097);
    inexact$Qu = new ModuleMethod(localnumbers, 8, Lit10, 4097);
    zero$Qu = new ModuleMethod(localnumbers, 9, Lit11, 4097);
    positive$Qu = new ModuleMethod(localnumbers, 10, Lit12, 4097);
    negative$Qu = new ModuleMethod(localnumbers, 11, Lit13, 4097);
    max = new ModuleMethod(localnumbers, 12, Lit14, -4096);
    min = new ModuleMethod(localnumbers, 13, Lit15, -4096);
    abs = new ModuleMethod(localnumbers, 14, Lit16, 4097);
    div$Mnand$Mnmod = new ModuleMethod(localnumbers, 15, Lit17, 8194);
    div0$Mnand$Mnmod0 = new ModuleMethod(localnumbers, 16, Lit18, 8194);
    gcd = new ModuleMethod(localnumbers, 17, Lit19, -4096);
    lcm = new ModuleMethod(localnumbers, 18, Lit20, -4096);
    numerator = new ModuleMethod(localnumbers, 19, Lit21, 4097);
    denominator = new ModuleMethod(localnumbers, 20, Lit22, 4097);
    floor = new ModuleMethod(localnumbers, 21, Lit23, 4097);
    ceiling = new ModuleMethod(localnumbers, 22, Lit24, 4097);
    truncate = new ModuleMethod(localnumbers, 23, Lit25, 4097);
    round = new ModuleMethod(localnumbers, 24, Lit26, 4097);
    rationalize = new ModuleMethod(localnumbers, 25, Lit27, 8194);
    exp = new ModuleMethod(localnumbers, 26, Lit28, 4097);
    log = new ModuleMethod(localnumbers, 27, Lit29, 4097);
    sin = new ModuleMethod(localnumbers, 28, Lit30, 4097);
    cos = new ModuleMethod(localnumbers, 29, Lit31, 4097);
    tan = new ModuleMethod(localnumbers, 30, Lit32, 4097);
    asin = new ModuleMethod(localnumbers, 31, Lit33, 4097);
    acos = new ModuleMethod(localnumbers, 32, Lit34, 4097);
    ModuleMethod localModuleMethod1 = new ModuleMethod(localnumbers, 33, null, 8194);
    localModuleMethod1.setProperty("source-location", "numbers.scm:146");
    lambda$Fn1 = localModuleMethod1;
    ModuleMethod localModuleMethod2 = new ModuleMethod(localnumbers, 34, null, 4097);
    localModuleMethod2.setProperty("source-location", "numbers.scm:148");
    lambda$Fn2 = localModuleMethod2;
    ModuleMethod localModuleMethod3 = new ModuleMethod(localnumbers, 35, null, 4097);
    localModuleMethod3.setProperty("source-location", "numbers.scm:152");
    lambda$Fn3 = localModuleMethod3;
    ModuleMethod localModuleMethod4 = new ModuleMethod(localnumbers, 36, null, 4097);
    localModuleMethod4.setProperty("source-location", "numbers.scm:156");
    lambda$Fn4 = localModuleMethod4;
    make$Mnrectangular = new ModuleMethod(localnumbers, 37, Lit35, 8194);
    make$Mnpolar = new ModuleMethod(localnumbers, 38, Lit36, 8194);
    real$Mnpart = new ModuleMethod(localnumbers, 39, Lit37, 4097);
    imag$Mnpart = new ModuleMethod(localnumbers, 40, Lit38, 4097);
    magnitude = new ModuleMethod(localnumbers, 41, Lit39, 4097);
    angle = new ModuleMethod(localnumbers, 42, Lit40, 4097);
    inexact = new ModuleMethod(localnumbers, 43, Lit41, 4097);
    exact = new ModuleMethod(localnumbers, 44, Lit42, 4097);
    exact$Mn$Grinexact = new ModuleMethod(localnumbers, 45, Lit43, 4097);
    inexact$Mn$Grexact = new ModuleMethod(localnumbers, 46, Lit44, 4097);
    logop = new ModuleMethod(localnumbers, 47, Lit45, 12291);
    bitwise$Mnbit$Mnset$Qu = new ModuleMethod(localnumbers, 48, Lit46, 8194);
    bitwise$Mncopy$Mnbit = new ModuleMethod(localnumbers, 49, Lit47, 12291);
    bitwise$Mncopy$Mnbit$Mnfield = new ModuleMethod(localnumbers, 50, Lit48, 16388);
    bitwise$Mnbit$Mnfield = new ModuleMethod(localnumbers, 51, Lit49, 12291);
    bitwise$Mnif = new ModuleMethod(localnumbers, 52, Lit50, 12291);
    logtest = new ModuleMethod(localnumbers, 53, Lit51, 8194);
    logcount = new ModuleMethod(localnumbers, 54, Lit52, 4097);
    bitwise$Mnbit$Mncount = new ModuleMethod(localnumbers, 55, Lit53, 4097);
    bitwise$Mnlength = new ModuleMethod(localnumbers, 56, Lit54, 4097);
    bitwise$Mnfirst$Mnbit$Mnset = new ModuleMethod(localnumbers, 57, Lit55, 4097);
    bitwise$Mnrotate$Mnbit$Mnfield = new ModuleMethod(localnumbers, 58, Lit56, 16388);
    bitwise$Mnreverse$Mnbit$Mnfield = new ModuleMethod(localnumbers, 59, Lit57, 12291);
    number$Mn$Grstring = new ModuleMethod(localnumbers, 60, Lit58, 8193);
    string$Mn$Grnumber = new ModuleMethod(localnumbers, 62, Lit59, 8193);
    quantity$Mn$Grnumber = new ModuleMethod(localnumbers, 64, Lit60, 4097);
    quantity$Mn$Grunit = new ModuleMethod(localnumbers, 65, Lit61, 4097);
    make$Mnquantity = new ModuleMethod(localnumbers, 66, Lit62, 8194);
    duration = new ModuleMethod(localnumbers, 67, Lit63, 4097);
    $instance.run();
  }
  
  public numbers()
  {
    ModuleInfo.register(this);
  }
  
  public static Number abs(Number paramNumber)
  {
    if ((paramNumber instanceof Numeric)) {
      paramNumber = ((Numeric)paramNumber).abs();
    }
    while (Scheme.numGEq.apply2(paramNumber, Lit0) != Boolean.FALSE) {
      return paramNumber;
    }
    return (Number)AddOp.$Mn.apply1(paramNumber);
  }
  
  public static double acos(double paramDouble)
  {
    return Math.acos(paramDouble);
  }
  
  public static RealNum angle(Complex paramComplex)
  {
    return paramComplex.angle();
  }
  
  public static double asin(double paramDouble)
  {
    return Math.asin(paramDouble);
  }
  
  public static int bitwiseBitCount(IntNum paramIntNum)
  {
    if (IntNum.compare(paramIntNum, 0L) >= 0) {
      return BitOps.bitCount(paramIntNum);
    }
    return -1 - BitOps.bitCount(BitOps.not(paramIntNum));
  }
  
  public static IntNum bitwiseBitField(IntNum paramIntNum, int paramInt1, int paramInt2)
  {
    return BitOps.extract(paramIntNum, paramInt1, paramInt2);
  }
  
  public static IntNum bitwiseCopyBit(IntNum paramIntNum, int paramInt1, int paramInt2)
  {
    return BitOps.setBitValue(paramIntNum, paramInt1, paramInt2);
  }
  
  public static IntNum bitwiseCopyBitField(IntNum paramIntNum1, int paramInt1, int paramInt2, IntNum paramIntNum2)
  {
    int i = IntNum.shift(-1, paramInt1);
    IntNum localIntNum = BitOps.not(IntNum.make(IntNum.shift(-1, paramInt2)));
    return bitwiseIf(BitOps.and(IntNum.make(i), localIntNum), IntNum.shift(paramIntNum2, paramInt1), paramIntNum1);
  }
  
  public static int bitwiseFirstBitSet(IntNum paramIntNum)
  {
    return BitOps.lowestBitSet(paramIntNum);
  }
  
  public static IntNum bitwiseIf(IntNum paramIntNum1, IntNum paramIntNum2, IntNum paramIntNum3)
  {
    return BitOps.ior(BitOps.and(paramIntNum1, paramIntNum2), BitOps.and(BitOps.not(paramIntNum1), paramIntNum3));
  }
  
  public static int bitwiseLength(IntNum paramIntNum)
  {
    return paramIntNum.intLength();
  }
  
  public static IntNum bitwiseReverseBitField(IntNum paramIntNum, int paramInt1, int paramInt2)
  {
    return BitOps.reverseBits(paramIntNum, paramInt1, paramInt2);
  }
  
  public static IntNum bitwiseRotateBitField(IntNum paramIntNum, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - paramInt1;
    int j;
    if (i > 0)
    {
      j = paramInt3 % i;
      if (j >= 0) {
        break label65;
      }
    }
    label65:
    for (int k = j + i;; k = j)
    {
      IntNum localIntNum = bitwiseBitField(paramIntNum, paramInt1, paramInt2);
      paramIntNum = bitwiseCopyBitField(paramIntNum, paramInt1, paramInt2, BitOps.ior(IntNum.shift(localIntNum, k), IntNum.shift(localIntNum, k - i)));
      return paramIntNum;
    }
  }
  
  public static RealNum ceiling(RealNum paramRealNum)
  {
    return paramRealNum.toInt(Numeric.CEILING);
  }
  
  public static double cos(double paramDouble)
  {
    return Math.cos(paramDouble);
  }
  
  public static IntNum denominator(RatNum paramRatNum)
  {
    return paramRatNum.denominator();
  }
  
  /* Error */
  public static Object div0AndMod0(RealNum paramRealNum1, RealNum paramRealNum2)
  {
    // Byte code:
    //   0: getstatic 690	gnu/kawa/functions/DivideOp:div0	Lgnu/kawa/functions/DivideOp;
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 567	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: astore_2
    //   9: aload_2
    //   10: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   13: astore 4
    //   15: getstatic 579	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   18: aload_0
    //   19: getstatic 702	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   22: aload 4
    //   24: aload_1
    //   25: invokevirtual 567	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: invokevirtual 567	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   31: astore 5
    //   33: aload 5
    //   35: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   38: astore 7
    //   40: iconst_2
    //   41: anewarray 704	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload 4
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload 7
    //   53: aastore
    //   54: invokestatic 710	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   57: areturn
    //   58: astore_3
    //   59: new 712	gnu/mapping/WrongType
    //   62: dup
    //   63: aload_3
    //   64: ldc_w 714
    //   67: bipush 254
    //   69: aload_2
    //   70: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    //   74: astore 6
    //   76: new 712	gnu/mapping/WrongType
    //   79: dup
    //   80: aload 6
    //   82: ldc_w 719
    //   85: bipush 254
    //   87: aload 5
    //   89: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramRealNum1	RealNum
    //   0	93	1	paramRealNum2	RealNum
    //   8	62	2	localObject1	Object
    //   58	6	3	localClassCastException1	ClassCastException
    //   13	34	4	localRealNum1	RealNum
    //   31	57	5	localObject2	Object
    //   74	7	6	localClassCastException2	ClassCastException
    //   38	14	7	localRealNum2	RealNum
    // Exception table:
    //   from	to	target	type
    //   9	15	58	java/lang/ClassCastException
    //   33	40	74	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object divAndMod(RealNum paramRealNum1, RealNum paramRealNum2)
  {
    // Byte code:
    //   0: getstatic 723	gnu/kawa/functions/DivideOp:div	Lgnu/kawa/functions/DivideOp;
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 567	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: astore_2
    //   9: aload_2
    //   10: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   13: astore 4
    //   15: getstatic 579	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   18: aload_0
    //   19: getstatic 702	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   22: aload 4
    //   24: aload_1
    //   25: invokevirtual 567	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: invokevirtual 567	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   31: astore 5
    //   33: aload 5
    //   35: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   38: astore 7
    //   40: iconst_2
    //   41: anewarray 704	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload 4
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload 7
    //   53: aastore
    //   54: invokestatic 710	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   57: areturn
    //   58: astore_3
    //   59: new 712	gnu/mapping/WrongType
    //   62: dup
    //   63: aload_3
    //   64: ldc_w 714
    //   67: bipush 254
    //   69: aload_2
    //   70: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    //   74: astore 6
    //   76: new 712	gnu/mapping/WrongType
    //   79: dup
    //   80: aload 6
    //   82: ldc_w 719
    //   85: bipush 254
    //   87: aload 5
    //   89: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramRealNum1	RealNum
    //   0	93	1	paramRealNum2	RealNum
    //   8	62	2	localObject1	Object
    //   58	6	3	localClassCastException1	ClassCastException
    //   13	34	4	localRealNum1	RealNum
    //   31	57	5	localObject2	Object
    //   74	7	6	localClassCastException2	ClassCastException
    //   38	14	7	localRealNum2	RealNum
    // Exception table:
    //   from	to	target	type
    //   9	15	58	java/lang/ClassCastException
    //   33	40	74	java/lang/ClassCastException
  }
  
  public static Duration duration(Object paramObject)
  {
    if (paramObject == null) {}
    for (String str = null;; str = paramObject.toString()) {
      return Duration.parseDuration(str);
    }
  }
  
  public static Number exact(Number paramNumber)
  {
    return Arithmetic.toExact(paramNumber);
  }
  
  public static Number exact$To$Inexact(Number paramNumber)
  {
    return Arithmetic.toInexact(paramNumber);
  }
  
  public static Complex exp(Complex paramComplex)
  {
    return paramComplex.exp();
  }
  
  public static RealNum floor(RealNum paramRealNum)
  {
    return paramRealNum.toInt(Numeric.FLOOR);
  }
  
  public static IntNum gcd(IntNum... paramVarArgs)
  {
    int i = paramVarArgs.length;
    IntNum localIntNum;
    if (i == 0) {
      localIntNum = Lit0;
    }
    for (;;)
    {
      return localIntNum;
      localIntNum = paramVarArgs[0];
      for (int j = 1; j < i; j++) {
        localIntNum = IntNum.gcd(localIntNum, paramVarArgs[j]);
      }
    }
  }
  
  public static RealNum imagPart(Complex paramComplex)
  {
    return paramComplex.im();
  }
  
  public static Number inexact(Number paramNumber)
  {
    return Arithmetic.toInexact(paramNumber);
  }
  
  public static Number inexact$To$Exact(Number paramNumber)
  {
    return Arithmetic.toExact(paramNumber);
  }
  
  public static boolean isBitwiseBitSet(IntNum paramIntNum, int paramInt)
  {
    return BitOps.bitValue(paramIntNum, paramInt);
  }
  
  public static boolean isComplex(Object paramObject)
  {
    return paramObject instanceof Complex;
  }
  
  public static boolean isExact(Object paramObject)
  {
    boolean bool = paramObject instanceof Number;
    if (bool) {
      bool = Arithmetic.isExact((Number)paramObject);
    }
    return bool;
  }
  
  public static boolean isInexact(Object paramObject)
  {
    boolean bool = paramObject instanceof Number;
    int i;
    if (bool) {
      i = 0x1 & true + Arithmetic.isExact((Number)paramObject);
    }
    return i;
  }
  
  /* Error */
  public static boolean isInteger(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 372
    //   4: istore_1
    //   5: iload_1
    //   6: ifeq +5 -> 11
    //   9: iload_1
    //   10: ireturn
    //   11: aload_0
    //   12: instanceof 773
    //   15: istore_1
    //   16: iload_1
    //   17: ifeq +27 -> 44
    //   20: aload_0
    //   21: checkcast 773	gnu/math/DFloNum
    //   24: astore_3
    //   25: aload_3
    //   26: invokevirtual 777	gnu/math/DFloNum:doubleValue	()D
    //   29: dconst_1
    //   30: invokestatic 781	java/lang/Math:IEEEremainder	(DD)D
    //   33: dconst_0
    //   34: dcmpg
    //   35: ifne +54 -> 89
    //   38: iconst_1
    //   39: istore 4
    //   41: iload 4
    //   43: istore_1
    //   44: iload_1
    //   45: ifne -36 -> 9
    //   48: aload_0
    //   49: instanceof 585
    //   52: istore_1
    //   53: iload_1
    //   54: ifeq -45 -> 9
    //   57: aload_0
    //   58: instanceof 783
    //   61: istore_1
    //   62: iload_1
    //   63: ifne -54 -> 9
    //   66: aload_0
    //   67: instanceof 785
    //   70: istore_1
    //   71: iload_1
    //   72: ifne -63 -> 9
    //   75: aload_0
    //   76: instanceof 787
    //   79: istore_1
    //   80: iload_1
    //   81: ifne -72 -> 9
    //   84: aload_0
    //   85: instanceof 789
    //   88: ireturn
    //   89: iconst_0
    //   90: istore 4
    //   92: goto -51 -> 41
    //   95: astore_2
    //   96: new 712	gnu/mapping/WrongType
    //   99: dup
    //   100: aload_2
    //   101: ldc_w 791
    //   104: iconst_1
    //   105: aload_0
    //   106: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramObject	Object
    //   4	77	1	bool1	boolean
    //   95	6	2	localClassCastException	ClassCastException
    //   24	2	3	localDFloNum	gnu.math.DFloNum
    //   39	52	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   20	25	95	java/lang/ClassCastException
  }
  
  public static boolean isNegative(RealNum paramRealNum)
  {
    return paramRealNum.isNegative();
  }
  
  public static boolean isNumber(Object paramObject)
  {
    return paramObject instanceof Number;
  }
  
  public static boolean isPositive(RealNum paramRealNum)
  {
    return paramRealNum.sign() > 0;
  }
  
  public static boolean isQuantity(Object paramObject)
  {
    return paramObject instanceof Quantity;
  }
  
  public static boolean isRational(Object paramObject)
  {
    return RatNum.asRatNumOrNull(paramObject) != null;
  }
  
  public static boolean isReal(Object paramObject)
  {
    return RealNum.asRealNumOrNull(paramObject) != null;
  }
  
  public static boolean isZero(Number paramNumber)
  {
    boolean bool = true;
    if ((paramNumber instanceof Numeric)) {
      bool = ((Numeric)paramNumber).isZero();
    }
    do
    {
      do
      {
        do
        {
          return bool;
          if (!(paramNumber instanceof BigInteger)) {
            break;
          }
        } while (Scheme.numEqu.apply2(Lit0, GetNamedPart.getNamedPart.apply2((BigInteger)paramNumber, Lit1)) != Boolean.FALSE);
        return false;
        if (!(paramNumber instanceof BigDecimal)) {
          break;
        }
      } while (Scheme.numEqu.apply2(Lit0, GetNamedPart.getNamedPart.apply2((BigDecimal)paramNumber, Lit1)) != Boolean.FALSE);
      return false;
    } while (paramNumber.doubleValue() == 0.0D);
    return false;
  }
  
  static double lambda1(double paramDouble1, double paramDouble2)
  {
    return Math.atan2(paramDouble1, paramDouble2);
  }
  
  static double lambda2(double paramDouble)
  {
    return Math.atan(paramDouble);
  }
  
  static Quantity lambda3(Quantity paramQuantity)
  {
    return Quantity.make(paramQuantity.number().sqrt(), paramQuantity.unit().sqrt());
  }
  
  static double lambda4(double paramDouble)
  {
    return Math.sqrt(paramDouble);
  }
  
  public static IntNum lcm(IntNum... paramVarArgs)
  {
    int i = paramVarArgs.length;
    IntNum localIntNum;
    if (i == 0) {
      localIntNum = Lit2;
    }
    for (;;)
    {
      return localIntNum;
      localIntNum = IntNum.abs(paramVarArgs[0]);
      for (int j = 1; j < i; j++) {
        localIntNum = IntNum.lcm(localIntNum, paramVarArgs[j]);
      }
    }
  }
  
  public static Complex log(Complex paramComplex)
  {
    return paramComplex.log();
  }
  
  public static int logcount(IntNum paramIntNum)
  {
    if (IntNum.compare(paramIntNum, 0L) >= 0) {}
    for (;;)
    {
      return BitOps.bitCount(paramIntNum);
      paramIntNum = BitOps.not(paramIntNum);
    }
  }
  
  public static IntNum logop(int paramInt, IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return BitOps.bitOp(paramInt, paramIntNum1, paramIntNum2);
  }
  
  public static boolean logtest(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return BitOps.test(paramIntNum1, paramIntNum2);
  }
  
  public static Number magnitude(Number paramNumber)
  {
    return abs(paramNumber);
  }
  
  public static DComplex makePolar(double paramDouble1, double paramDouble2)
  {
    return Complex.polar(paramDouble1, paramDouble2);
  }
  
  /* Error */
  public static Quantity makeQuantity(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 848
    //   4: ifeq +48 -> 52
    //   7: aload_1
    //   8: checkcast 848	gnu/math/Unit
    //   11: astore 7
    //   13: aload 7
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +57 -> 74
    //   20: new 881	java/lang/IllegalArgumentException
    //   23: dup
    //   24: iconst_0
    //   25: iconst_2
    //   26: anewarray 704	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: ldc_w 883
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: aload_1
    //   38: aastore
    //   39: invokestatic 889	gnu/kawa/functions/Format:formatToString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   42: invokevirtual 892	java/lang/String:toString	()Ljava/lang/String;
    //   45: invokespecial 893	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   48: checkcast 895	java/lang/Throwable
    //   51: athrow
    //   52: aload_1
    //   53: ifnonnull +13 -> 66
    //   56: aconst_null
    //   57: astore_2
    //   58: aload_2
    //   59: invokestatic 899	gnu/math/Unit:lookup	(Ljava/lang/String;)Lgnu/math/NamedUnit;
    //   62: astore_3
    //   63: goto -47 -> 16
    //   66: aload_1
    //   67: invokevirtual 734	java/lang/Object:toString	()Ljava/lang/String;
    //   70: astore_2
    //   71: goto -13 -> 58
    //   74: aload_0
    //   75: checkcast 593	gnu/math/Complex
    //   78: astore 5
    //   80: aload 5
    //   82: aload_3
    //   83: invokestatic 853	gnu/math/Quantity:make	(Lgnu/math/Complex;Lgnu/math/Unit;)Lgnu/math/Quantity;
    //   86: areturn
    //   87: astore 6
    //   89: new 712	gnu/mapping/WrongType
    //   92: dup
    //   93: aload 6
    //   95: ldc_w 901
    //   98: bipush 254
    //   100: aload_1
    //   101: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   104: athrow
    //   105: astore 4
    //   107: new 712	gnu/mapping/WrongType
    //   110: dup
    //   111: aload 4
    //   113: ldc_w 903
    //   116: iconst_1
    //   117: aload_0
    //   118: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramObject1	Object
    //   0	122	1	paramObject2	Object
    //   57	14	2	str	String
    //   15	68	3	localObject	Object
    //   105	7	4	localClassCastException1	ClassCastException
    //   78	3	5	localComplex	Complex
    //   87	7	6	localClassCastException2	ClassCastException
    //   11	3	7	localUnit	Unit
    // Exception table:
    //   from	to	target	type
    //   7	13	87	java/lang/ClassCastException
    //   74	80	105	java/lang/ClassCastException
  }
  
  public static Complex makeRectangular(RealNum paramRealNum1, RealNum paramRealNum2)
  {
    return Complex.make(paramRealNum1, paramRealNum2);
  }
  
  public static Object max(Object... paramVarArgs)
  {
    int i = paramVarArgs.length;
    Object localObject1 = paramVarArgs[0];
    RealNum localRealNum2;
    try
    {
      RealNum localRealNum1 = LangObjType.coerceRealNum(localObject1);
      localRealNum2 = localRealNum1;
      j = 1;
    }
    catch (ClassCastException localClassCastException1)
    {
      try
      {
        int j;
        RealNum localRealNum3 = LangObjType.coerceRealNum(localObject2);
        localRealNum2 = localRealNum2.max(localRealNum3);
        j++;
      }
      catch (ClassCastException localClassCastException2)
      {
        Object localObject2;
        throw new WrongType(localClassCastException2, "gnu.math.RealNum.max(real)", 2, localObject2);
      }
      localClassCastException1 = localClassCastException1;
      throw new WrongType(localClassCastException1, "result", -2, localObject1);
    }
    if (j < i) {
      localObject2 = paramVarArgs[j];
    }
    return localRealNum2;
  }
  
  public static Object min(Object... paramVarArgs)
  {
    int i = paramVarArgs.length;
    Object localObject1 = paramVarArgs[0];
    RealNum localRealNum2;
    try
    {
      RealNum localRealNum1 = LangObjType.coerceRealNum(localObject1);
      localRealNum2 = localRealNum1;
      j = 0;
    }
    catch (ClassCastException localClassCastException1)
    {
      try
      {
        int j;
        RealNum localRealNum3 = LangObjType.coerceRealNum(localObject2);
        localRealNum2 = localRealNum2.min(localRealNum3);
        j++;
      }
      catch (ClassCastException localClassCastException2)
      {
        Object localObject2;
        throw new WrongType(localClassCastException2, "gnu.math.RealNum.min(real)", 2, localObject2);
      }
      localClassCastException1 = localClassCastException1;
      throw new WrongType(localClassCastException1, "result", -2, localObject1);
    }
    if (j < i) {
      localObject2 = paramVarArgs[j];
    }
    return localRealNum2;
  }
  
  public static CharSequence number$To$String(Number paramNumber)
  {
    return number$To$String(paramNumber, 10);
  }
  
  public static CharSequence number$To$String(Number paramNumber, int paramInt)
  {
    return new FString(Arithmetic.toString(paramNumber, paramInt));
  }
  
  public static IntNum numerator(RatNum paramRatNum)
  {
    return paramRatNum.numerator();
  }
  
  public static Complex quantity$To$Number(Quantity paramQuantity)
  {
    paramQuantity.unit();
    if (paramQuantity.doubleValue() == 1.0D) {
      return paramQuantity.number();
    }
    return Complex.make(paramQuantity.reValue(), paramQuantity.imValue());
  }
  
  public static Unit quantity$To$Unit(Quantity paramQuantity)
  {
    return paramQuantity.unit();
  }
  
  public static RealNum rationalize(RealNum paramRealNum1, RealNum paramRealNum2)
  {
    return RatNum.rationalize(LangObjType.coerceRealNum(paramRealNum1.sub(paramRealNum2)), LangObjType.coerceRealNum(paramRealNum1.add(paramRealNum2)));
  }
  
  public static RealNum realPart(Complex paramComplex)
  {
    return paramComplex.re();
  }
  
  public static RealNum round(RealNum paramRealNum)
  {
    return paramRealNum.toInt(Numeric.ROUND);
  }
  
  public static double sin(double paramDouble)
  {
    return Math.sin(paramDouble);
  }
  
  public static Object string$To$Number(CharSequence paramCharSequence)
  {
    return string$To$Number(paramCharSequence, 10);
  }
  
  public static Object string$To$Number(CharSequence paramCharSequence, int paramInt)
  {
    Object localObject = LispReader.parseNumber(paramCharSequence, paramInt);
    if ((localObject instanceof Numeric)) {
      return localObject;
    }
    return Boolean.FALSE;
  }
  
  public static double tan(double paramDouble)
  {
    return Math.tan(paramDouble);
  }
  
  public static RealNum truncate(RealNum paramRealNum)
  {
    return paramRealNum.toInt(Numeric.TRUNCATE);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 12: 
    case 13: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 25: 
    case 33: 
    case 37: 
    case 38: 
    case 47: 
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 58: 
    case 59: 
    case 61: 
    case 63: 
    case 66: 
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 1: 
      if (isNumber(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 2: 
      if (isQuantity(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 3: 
      if (isComplex(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 4: 
      if (isReal(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 5: 
      if (isRational(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 6: 
      if (isInteger(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 7: 
      if (isExact(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 8: 
      if (isInexact(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    try
    {
      Number localNumber8 = (Number)paramObject;
      if (isZero(localNumber8)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException36)
    {
      RealNum localRealNum6;
      RealNum localRealNum5;
      Number localNumber7;
      RatNum localRatNum2;
      RatNum localRatNum1;
      RealNum localRealNum4;
      RealNum localRealNum3;
      RealNum localRealNum2;
      RealNum localRealNum1;
      Complex localComplex5;
      Complex localComplex4;
      double d7;
      double d6;
      double d5;
      double d4;
      double d3;
      double d2;
      Quantity localQuantity3;
      double d1;
      Complex localComplex3;
      Complex localComplex2;
      Number localNumber6;
      Complex localComplex1;
      Number localNumber5;
      Number localNumber4;
      Number localNumber3;
      Number localNumber2;
      IntNum localIntNum4;
      IntNum localIntNum3;
      IntNum localIntNum2;
      IntNum localIntNum1;
      Number localNumber1;
      CharSequence localCharSequence;
      Quantity localQuantity2;
      Quantity localQuantity1;
      throw new WrongType(localClassCastException36, "zero?", 1, paramObject);
    }
    try
    {
      localRealNum6 = LangObjType.coerceRealNum(paramObject);
      if (isPositive(localRealNum6)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException35)
    {
      throw new WrongType(localClassCastException35, "positive?", 1, paramObject);
    }
    try
    {
      localRealNum5 = LangObjType.coerceRealNum(paramObject);
      if (isNegative(localRealNum5)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException34)
    {
      throw new WrongType(localClassCastException34, "negative?", 1, paramObject);
    }
    try
    {
      localNumber7 = (Number)paramObject;
      return abs(localNumber7);
    }
    catch (ClassCastException localClassCastException33)
    {
      throw new WrongType(localClassCastException33, "abs", 1, paramObject);
    }
    try
    {
      localRatNum2 = LangObjType.coerceRatNum(paramObject);
      return numerator(localRatNum2);
    }
    catch (ClassCastException localClassCastException32)
    {
      throw new WrongType(localClassCastException32, "numerator", 1, paramObject);
    }
    try
    {
      localRatNum1 = LangObjType.coerceRatNum(paramObject);
      return denominator(localRatNum1);
    }
    catch (ClassCastException localClassCastException31)
    {
      throw new WrongType(localClassCastException31, "denominator", 1, paramObject);
    }
    try
    {
      localRealNum4 = LangObjType.coerceRealNum(paramObject);
      return floor(localRealNum4);
    }
    catch (ClassCastException localClassCastException30)
    {
      throw new WrongType(localClassCastException30, "floor", 1, paramObject);
    }
    try
    {
      localRealNum3 = LangObjType.coerceRealNum(paramObject);
      return ceiling(localRealNum3);
    }
    catch (ClassCastException localClassCastException29)
    {
      throw new WrongType(localClassCastException29, "ceiling", 1, paramObject);
    }
    try
    {
      localRealNum2 = LangObjType.coerceRealNum(paramObject);
      return truncate(localRealNum2);
    }
    catch (ClassCastException localClassCastException28)
    {
      throw new WrongType(localClassCastException28, "truncate", 1, paramObject);
    }
    try
    {
      localRealNum1 = LangObjType.coerceRealNum(paramObject);
      return round(localRealNum1);
    }
    catch (ClassCastException localClassCastException27)
    {
      throw new WrongType(localClassCastException27, "round", 1, paramObject);
    }
    try
    {
      localComplex5 = (Complex)paramObject;
      return exp(localComplex5);
    }
    catch (ClassCastException localClassCastException26)
    {
      throw new WrongType(localClassCastException26, "exp", 1, paramObject);
    }
    try
    {
      localComplex4 = (Complex)paramObject;
      return log(localComplex4);
    }
    catch (ClassCastException localClassCastException25)
    {
      throw new WrongType(localClassCastException25, "log", 1, paramObject);
    }
    try
    {
      d7 = ((Number)paramObject).doubleValue();
      return Double.valueOf(sin(d7));
    }
    catch (ClassCastException localClassCastException24)
    {
      throw new WrongType(localClassCastException24, "sin", 1, paramObject);
    }
    try
    {
      d6 = ((Number)paramObject).doubleValue();
      return Double.valueOf(cos(d6));
    }
    catch (ClassCastException localClassCastException23)
    {
      throw new WrongType(localClassCastException23, "cos", 1, paramObject);
    }
    try
    {
      d5 = ((Number)paramObject).doubleValue();
      return Double.valueOf(tan(d5));
    }
    catch (ClassCastException localClassCastException22)
    {
      throw new WrongType(localClassCastException22, "tan", 1, paramObject);
    }
    try
    {
      d4 = ((Number)paramObject).doubleValue();
      return Double.valueOf(asin(d4));
    }
    catch (ClassCastException localClassCastException21)
    {
      throw new WrongType(localClassCastException21, "asin", 1, paramObject);
    }
    try
    {
      d3 = ((Number)paramObject).doubleValue();
      return Double.valueOf(acos(d3));
    }
    catch (ClassCastException localClassCastException20)
    {
      throw new WrongType(localClassCastException20, "acos", 1, paramObject);
    }
    try
    {
      d2 = ((Number)paramObject).doubleValue();
      return Double.valueOf(lambda2(d2));
    }
    catch (ClassCastException localClassCastException19)
    {
      throw new WrongType(localClassCastException19, "lambda", 1, paramObject);
    }
    try
    {
      localQuantity3 = (Quantity)paramObject;
      return lambda3(localQuantity3);
    }
    catch (ClassCastException localClassCastException18)
    {
      throw new WrongType(localClassCastException18, "lambda", 1, paramObject);
    }
    try
    {
      d1 = ((Number)paramObject).doubleValue();
      return Double.valueOf(lambda4(d1));
    }
    catch (ClassCastException localClassCastException17)
    {
      throw new WrongType(localClassCastException17, "lambda", 1, paramObject);
    }
    try
    {
      localComplex3 = (Complex)paramObject;
      return realPart(localComplex3);
    }
    catch (ClassCastException localClassCastException16)
    {
      throw new WrongType(localClassCastException16, "real-part", 1, paramObject);
    }
    try
    {
      localComplex2 = (Complex)paramObject;
      return imagPart(localComplex2);
    }
    catch (ClassCastException localClassCastException15)
    {
      throw new WrongType(localClassCastException15, "imag-part", 1, paramObject);
    }
    try
    {
      localNumber6 = (Number)paramObject;
      return magnitude(localNumber6);
    }
    catch (ClassCastException localClassCastException14)
    {
      throw new WrongType(localClassCastException14, "magnitude", 1, paramObject);
    }
    try
    {
      localComplex1 = (Complex)paramObject;
      return angle(localComplex1);
    }
    catch (ClassCastException localClassCastException13)
    {
      throw new WrongType(localClassCastException13, "angle", 1, paramObject);
    }
    try
    {
      localNumber5 = (Number)paramObject;
      return inexact(localNumber5);
    }
    catch (ClassCastException localClassCastException12)
    {
      throw new WrongType(localClassCastException12, "inexact", 1, paramObject);
    }
    try
    {
      localNumber4 = (Number)paramObject;
      return exact(localNumber4);
    }
    catch (ClassCastException localClassCastException11)
    {
      throw new WrongType(localClassCastException11, "exact", 1, paramObject);
    }
    try
    {
      localNumber3 = (Number)paramObject;
      return exact$To$Inexact(localNumber3);
    }
    catch (ClassCastException localClassCastException10)
    {
      throw new WrongType(localClassCastException10, "exact->inexact", 1, paramObject);
    }
    try
    {
      localNumber2 = (Number)paramObject;
      return inexact$To$Exact(localNumber2);
    }
    catch (ClassCastException localClassCastException9)
    {
      throw new WrongType(localClassCastException9, "inexact->exact", 1, paramObject);
    }
    try
    {
      localIntNum4 = LangObjType.coerceIntNum(paramObject);
      return Integer.valueOf(logcount(localIntNum4));
    }
    catch (ClassCastException localClassCastException8)
    {
      throw new WrongType(localClassCastException8, "logcount", 1, paramObject);
    }
    try
    {
      localIntNum3 = LangObjType.coerceIntNum(paramObject);
      return Integer.valueOf(bitwiseBitCount(localIntNum3));
    }
    catch (ClassCastException localClassCastException7)
    {
      throw new WrongType(localClassCastException7, "bitwise-bit-count", 1, paramObject);
    }
    try
    {
      localIntNum2 = LangObjType.coerceIntNum(paramObject);
      return Integer.valueOf(bitwiseLength(localIntNum2));
    }
    catch (ClassCastException localClassCastException6)
    {
      throw new WrongType(localClassCastException6, "bitwise-length", 1, paramObject);
    }
    try
    {
      localIntNum1 = LangObjType.coerceIntNum(paramObject);
      return Integer.valueOf(bitwiseFirstBitSet(localIntNum1));
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "bitwise-first-bit-set", 1, paramObject);
    }
    try
    {
      localNumber1 = (Number)paramObject;
      return number$To$String(localNumber1);
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "number->string", 1, paramObject);
    }
    try
    {
      localCharSequence = (CharSequence)paramObject;
      return string$To$Number(localCharSequence);
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "string->number", 1, paramObject);
    }
    try
    {
      localQuantity2 = (Quantity)paramObject;
      return quantity$To$Number(localQuantity2);
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "quantity->number", 1, paramObject);
    }
    try
    {
      localQuantity1 = (Quantity)paramObject;
      return quantity$To$Unit(localQuantity1);
    }
    catch (ClassCastException localClassCastException1)
    {
      throw new WrongType(localClassCastException1, "quantity->unit", 1, paramObject);
    }
    return duration(paramObject);
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
      localRealNum7 = LangObjType.coerceRealNum(paramObject1);
    }
    catch (ClassCastException localClassCastException19)
    {
      RealNum localRealNum7;
      RealNum localRealNum8;
      RealNum localRealNum5;
      RealNum localRealNum6;
      RealNum localRealNum3;
      RealNum localRealNum4;
      double d3;
      double d4;
      RealNum localRealNum1;
      RealNum localRealNum2;
      double d1;
      double d2;
      IntNum localIntNum3;
      int k;
      IntNum localIntNum1;
      IntNum localIntNum2;
      Number localNumber;
      int j;
      CharSequence localCharSequence;
      int i;
      throw new WrongType(localClassCastException19, "div-and-mod", 1, paramObject1);
    }
    try
    {
      localRealNum8 = LangObjType.coerceRealNum(paramObject2);
      return divAndMod(localRealNum7, localRealNum8);
    }
    catch (ClassCastException localClassCastException20)
    {
      throw new WrongType(localClassCastException20, "div-and-mod", 2, paramObject2);
    }
    try
    {
      localRealNum5 = LangObjType.coerceRealNum(paramObject1);
    }
    catch (ClassCastException localClassCastException17)
    {
      throw new WrongType(localClassCastException17, "div0-and-mod0", 1, paramObject1);
    }
    try
    {
      localRealNum6 = LangObjType.coerceRealNum(paramObject2);
      return div0AndMod0(localRealNum5, localRealNum6);
    }
    catch (ClassCastException localClassCastException18)
    {
      throw new WrongType(localClassCastException18, "div0-and-mod0", 2, paramObject2);
    }
    try
    {
      localRealNum3 = LangObjType.coerceRealNum(paramObject1);
    }
    catch (ClassCastException localClassCastException15)
    {
      throw new WrongType(localClassCastException15, "rationalize", 1, paramObject1);
    }
    try
    {
      localRealNum4 = LangObjType.coerceRealNum(paramObject2);
      return rationalize(localRealNum3, localRealNum4);
    }
    catch (ClassCastException localClassCastException16)
    {
      throw new WrongType(localClassCastException16, "rationalize", 2, paramObject2);
    }
    try
    {
      d3 = ((Number)paramObject1).doubleValue();
    }
    catch (ClassCastException localClassCastException13)
    {
      throw new WrongType(localClassCastException13, "lambda", 1, paramObject1);
    }
    try
    {
      d4 = ((Number)paramObject2).doubleValue();
      return Double.valueOf(lambda1(d3, d4));
    }
    catch (ClassCastException localClassCastException14)
    {
      throw new WrongType(localClassCastException14, "lambda", 2, paramObject2);
    }
    try
    {
      localRealNum1 = LangObjType.coerceRealNum(paramObject1);
    }
    catch (ClassCastException localClassCastException11)
    {
      throw new WrongType(localClassCastException11, "make-rectangular", 1, paramObject1);
    }
    try
    {
      localRealNum2 = LangObjType.coerceRealNum(paramObject2);
      return makeRectangular(localRealNum1, localRealNum2);
    }
    catch (ClassCastException localClassCastException12)
    {
      throw new WrongType(localClassCastException12, "make-rectangular", 2, paramObject2);
    }
    try
    {
      d1 = ((Number)paramObject1).doubleValue();
    }
    catch (ClassCastException localClassCastException9)
    {
      throw new WrongType(localClassCastException9, "make-polar", 1, paramObject1);
    }
    try
    {
      d2 = ((Number)paramObject2).doubleValue();
      return makePolar(d1, d2);
    }
    catch (ClassCastException localClassCastException10)
    {
      throw new WrongType(localClassCastException10, "make-polar", 2, paramObject2);
    }
    try
    {
      localIntNum3 = LangObjType.coerceIntNum(paramObject1);
    }
    catch (ClassCastException localClassCastException7)
    {
      throw new WrongType(localClassCastException7, "bitwise-bit-set?", 1, paramObject1);
    }
    try
    {
      k = ((Number)paramObject2).intValue();
      if (isBitwiseBitSet(localIntNum3, k)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException8)
    {
      throw new WrongType(localClassCastException8, "bitwise-bit-set?", 2, paramObject2);
    }
    try
    {
      localIntNum1 = LangObjType.coerceIntNum(paramObject1);
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "logtest", 1, paramObject1);
    }
    try
    {
      localIntNum2 = LangObjType.coerceIntNum(paramObject2);
      if (logtest(localIntNum1, localIntNum2)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException6)
    {
      throw new WrongType(localClassCastException6, "logtest", 2, paramObject2);
    }
    try
    {
      localNumber = (Number)paramObject1;
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "number->string", 1, paramObject1);
    }
    try
    {
      j = ((Number)paramObject2).intValue();
      return number$To$String(localNumber, j);
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "number->string", 2, paramObject2);
    }
    try
    {
      localCharSequence = (CharSequence)paramObject1;
    }
    catch (ClassCastException localClassCastException1)
    {
      throw new WrongType(localClassCastException1, "string->number", 1, paramObject1);
    }
    try
    {
      i = ((Number)paramObject2).intValue();
      return string$To$Number(localCharSequence, i);
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "string->number", 2, paramObject2);
    }
    return makeQuantity(paramObject1, paramObject2);
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 984	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+52->56, 47:+62->66, 49:+94->98, 51:+129->133, 52:+164->168, 59:+193->197
    //   57: aload_1
    //   58: aload_2
    //   59: aload_3
    //   60: aload 4
    //   62: invokespecial 1119	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: areturn
    //   66: aload_2
    //   67: checkcast 585	java/lang/Number
    //   70: invokevirtual 1109	java/lang/Number:intValue	()I
    //   73: istore 30
    //   75: aload_3
    //   76: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   79: astore 32
    //   81: aload 4
    //   83: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   86: astore 34
    //   88: iload 30
    //   90: aload 32
    //   92: aload 34
    //   94: invokestatic 1121	kawa/lib/numbers:logop	(ILgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    //   97: areturn
    //   98: aload_2
    //   99: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   102: astore 24
    //   104: aload_3
    //   105: checkcast 585	java/lang/Number
    //   108: invokevirtual 1109	java/lang/Number:intValue	()I
    //   111: istore 26
    //   113: aload 4
    //   115: checkcast 585	java/lang/Number
    //   118: invokevirtual 1109	java/lang/Number:intValue	()I
    //   121: istore 28
    //   123: aload 24
    //   125: iload 26
    //   127: iload 28
    //   129: invokestatic 1123	kawa/lib/numbers:bitwiseCopyBit	(Lgnu/math/IntNum;II)Lgnu/math/IntNum;
    //   132: areturn
    //   133: aload_2
    //   134: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   137: astore 18
    //   139: aload_3
    //   140: checkcast 585	java/lang/Number
    //   143: invokevirtual 1109	java/lang/Number:intValue	()I
    //   146: istore 20
    //   148: aload 4
    //   150: checkcast 585	java/lang/Number
    //   153: invokevirtual 1109	java/lang/Number:intValue	()I
    //   156: istore 22
    //   158: aload 18
    //   160: iload 20
    //   162: iload 22
    //   164: invokestatic 659	kawa/lib/numbers:bitwiseBitField	(Lgnu/math/IntNum;II)Lgnu/math/IntNum;
    //   167: areturn
    //   168: aload_2
    //   169: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   172: astore 12
    //   174: aload_3
    //   175: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   178: astore 14
    //   180: aload 4
    //   182: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   185: astore 16
    //   187: aload 12
    //   189: aload 14
    //   191: aload 16
    //   193: invokestatic 639	kawa/lib/numbers:bitwiseIf	(Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    //   196: areturn
    //   197: aload_2
    //   198: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   201: astore 6
    //   203: aload_3
    //   204: checkcast 585	java/lang/Number
    //   207: invokevirtual 1109	java/lang/Number:intValue	()I
    //   210: istore 8
    //   212: aload 4
    //   214: checkcast 585	java/lang/Number
    //   217: invokevirtual 1109	java/lang/Number:intValue	()I
    //   220: istore 10
    //   222: aload 6
    //   224: iload 8
    //   226: iload 10
    //   228: invokestatic 1125	kawa/lib/numbers:bitwiseReverseBitField	(Lgnu/math/IntNum;II)Lgnu/math/IntNum;
    //   231: areturn
    //   232: astore 29
    //   234: new 712	gnu/mapping/WrongType
    //   237: dup
    //   238: aload 29
    //   240: ldc 223
    //   242: iconst_1
    //   243: aload_2
    //   244: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   247: athrow
    //   248: astore 31
    //   250: new 712	gnu/mapping/WrongType
    //   253: dup
    //   254: aload 31
    //   256: ldc 223
    //   258: iconst_2
    //   259: aload_3
    //   260: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   263: athrow
    //   264: astore 33
    //   266: new 712	gnu/mapping/WrongType
    //   269: dup
    //   270: aload 33
    //   272: ldc 223
    //   274: iconst_3
    //   275: aload 4
    //   277: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   280: athrow
    //   281: astore 23
    //   283: new 712	gnu/mapping/WrongType
    //   286: dup
    //   287: aload 23
    //   289: ldc 216
    //   291: iconst_1
    //   292: aload_2
    //   293: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   296: athrow
    //   297: astore 25
    //   299: new 712	gnu/mapping/WrongType
    //   302: dup
    //   303: aload 25
    //   305: ldc 216
    //   307: iconst_2
    //   308: aload_3
    //   309: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   312: athrow
    //   313: astore 27
    //   315: new 712	gnu/mapping/WrongType
    //   318: dup
    //   319: aload 27
    //   321: ldc 216
    //   323: iconst_3
    //   324: aload 4
    //   326: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   329: athrow
    //   330: astore 17
    //   332: new 712	gnu/mapping/WrongType
    //   335: dup
    //   336: aload 17
    //   338: ldc 208
    //   340: iconst_1
    //   341: aload_2
    //   342: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   345: athrow
    //   346: astore 19
    //   348: new 712	gnu/mapping/WrongType
    //   351: dup
    //   352: aload 19
    //   354: ldc 208
    //   356: iconst_2
    //   357: aload_3
    //   358: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   361: athrow
    //   362: astore 21
    //   364: new 712	gnu/mapping/WrongType
    //   367: dup
    //   368: aload 21
    //   370: ldc 208
    //   372: iconst_3
    //   373: aload 4
    //   375: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   378: athrow
    //   379: astore 11
    //   381: new 712	gnu/mapping/WrongType
    //   384: dup
    //   385: aload 11
    //   387: ldc 204
    //   389: iconst_1
    //   390: aload_2
    //   391: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   394: athrow
    //   395: astore 13
    //   397: new 712	gnu/mapping/WrongType
    //   400: dup
    //   401: aload 13
    //   403: ldc 204
    //   405: iconst_2
    //   406: aload_3
    //   407: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   410: athrow
    //   411: astore 15
    //   413: new 712	gnu/mapping/WrongType
    //   416: dup
    //   417: aload 15
    //   419: ldc 204
    //   421: iconst_3
    //   422: aload 4
    //   424: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   427: athrow
    //   428: astore 5
    //   430: new 712	gnu/mapping/WrongType
    //   433: dup
    //   434: aload 5
    //   436: ldc 178
    //   438: iconst_1
    //   439: aload_2
    //   440: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   443: athrow
    //   444: astore 7
    //   446: new 712	gnu/mapping/WrongType
    //   449: dup
    //   450: aload 7
    //   452: ldc 178
    //   454: iconst_2
    //   455: aload_3
    //   456: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   459: athrow
    //   460: astore 9
    //   462: new 712	gnu/mapping/WrongType
    //   465: dup
    //   466: aload 9
    //   468: ldc 178
    //   470: iconst_3
    //   471: aload 4
    //   473: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   476: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	477	0	this	numbers
    //   0	477	1	paramModuleMethod	ModuleMethod
    //   0	477	2	paramObject1	Object
    //   0	477	3	paramObject2	Object
    //   0	477	4	paramObject3	Object
    //   428	7	5	localClassCastException1	ClassCastException
    //   201	22	6	localIntNum1	IntNum
    //   444	7	7	localClassCastException2	ClassCastException
    //   210	15	8	i	int
    //   460	7	9	localClassCastException3	ClassCastException
    //   220	7	10	j	int
    //   379	7	11	localClassCastException4	ClassCastException
    //   172	16	12	localIntNum2	IntNum
    //   395	7	13	localClassCastException5	ClassCastException
    //   178	12	14	localIntNum3	IntNum
    //   411	7	15	localClassCastException6	ClassCastException
    //   185	7	16	localIntNum4	IntNum
    //   330	7	17	localClassCastException7	ClassCastException
    //   137	22	18	localIntNum5	IntNum
    //   346	7	19	localClassCastException8	ClassCastException
    //   146	15	20	k	int
    //   362	7	21	localClassCastException9	ClassCastException
    //   156	7	22	m	int
    //   281	7	23	localClassCastException10	ClassCastException
    //   102	22	24	localIntNum6	IntNum
    //   297	7	25	localClassCastException11	ClassCastException
    //   111	15	26	n	int
    //   313	7	27	localClassCastException12	ClassCastException
    //   121	7	28	i1	int
    //   232	7	29	localClassCastException13	ClassCastException
    //   73	16	30	i2	int
    //   248	7	31	localClassCastException14	ClassCastException
    //   79	12	32	localIntNum7	IntNum
    //   264	7	33	localClassCastException15	ClassCastException
    //   86	7	34	localIntNum8	IntNum
    // Exception table:
    //   from	to	target	type
    //   66	75	232	java/lang/ClassCastException
    //   75	81	248	java/lang/ClassCastException
    //   81	88	264	java/lang/ClassCastException
    //   98	104	281	java/lang/ClassCastException
    //   104	113	297	java/lang/ClassCastException
    //   113	123	313	java/lang/ClassCastException
    //   133	139	330	java/lang/ClassCastException
    //   139	148	346	java/lang/ClassCastException
    //   148	158	362	java/lang/ClassCastException
    //   168	174	379	java/lang/ClassCastException
    //   174	180	395	java/lang/ClassCastException
    //   180	187	411	java/lang/ClassCastException
    //   197	203	428	java/lang/ClassCastException
    //   203	212	444	java/lang/ClassCastException
    //   212	222	460	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 984	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+28->32, 50:+40->44, 58:+84->88
    //   33: aload_1
    //   34: aload_2
    //   35: aload_3
    //   36: aload 4
    //   38: aload 5
    //   40: invokespecial 1129	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: areturn
    //   44: aload_2
    //   45: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   48: astore 15
    //   50: aload_3
    //   51: checkcast 585	java/lang/Number
    //   54: invokevirtual 1109	java/lang/Number:intValue	()I
    //   57: istore 17
    //   59: aload 4
    //   61: checkcast 585	java/lang/Number
    //   64: invokevirtual 1109	java/lang/Number:intValue	()I
    //   67: istore 19
    //   69: aload 5
    //   71: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   74: astore 21
    //   76: aload 15
    //   78: iload 17
    //   80: iload 19
    //   82: aload 21
    //   84: invokestatic 661	kawa/lib/numbers:bitwiseCopyBitField	(Lgnu/math/IntNum;IILgnu/math/IntNum;)Lgnu/math/IntNum;
    //   87: areturn
    //   88: aload_2
    //   89: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   92: astore 7
    //   94: aload_3
    //   95: checkcast 585	java/lang/Number
    //   98: invokevirtual 1109	java/lang/Number:intValue	()I
    //   101: istore 9
    //   103: aload 4
    //   105: checkcast 585	java/lang/Number
    //   108: invokevirtual 1109	java/lang/Number:intValue	()I
    //   111: istore 11
    //   113: aload 5
    //   115: checkcast 585	java/lang/Number
    //   118: invokevirtual 1109	java/lang/Number:intValue	()I
    //   121: istore 13
    //   123: aload 7
    //   125: iload 9
    //   127: iload 11
    //   129: iload 13
    //   131: invokestatic 1131	kawa/lib/numbers:bitwiseRotateBitField	(Lgnu/math/IntNum;III)Lgnu/math/IntNum;
    //   134: areturn
    //   135: astore 14
    //   137: new 712	gnu/mapping/WrongType
    //   140: dup
    //   141: aload 14
    //   143: ldc 212
    //   145: iconst_1
    //   146: aload_2
    //   147: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   150: athrow
    //   151: astore 16
    //   153: new 712	gnu/mapping/WrongType
    //   156: dup
    //   157: aload 16
    //   159: ldc 212
    //   161: iconst_2
    //   162: aload_3
    //   163: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   166: athrow
    //   167: astore 18
    //   169: new 712	gnu/mapping/WrongType
    //   172: dup
    //   173: aload 18
    //   175: ldc 212
    //   177: iconst_3
    //   178: aload 4
    //   180: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   183: athrow
    //   184: astore 20
    //   186: new 712	gnu/mapping/WrongType
    //   189: dup
    //   190: aload 20
    //   192: ldc 212
    //   194: iconst_4
    //   195: aload 5
    //   197: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   200: athrow
    //   201: astore 6
    //   203: new 712	gnu/mapping/WrongType
    //   206: dup
    //   207: aload 6
    //   209: ldc 182
    //   211: iconst_1
    //   212: aload_2
    //   213: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   216: athrow
    //   217: astore 8
    //   219: new 712	gnu/mapping/WrongType
    //   222: dup
    //   223: aload 8
    //   225: ldc 182
    //   227: iconst_2
    //   228: aload_3
    //   229: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   232: athrow
    //   233: astore 10
    //   235: new 712	gnu/mapping/WrongType
    //   238: dup
    //   239: aload 10
    //   241: ldc 182
    //   243: iconst_3
    //   244: aload 4
    //   246: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   249: athrow
    //   250: astore 12
    //   252: new 712	gnu/mapping/WrongType
    //   255: dup
    //   256: aload 12
    //   258: ldc 182
    //   260: iconst_4
    //   261: aload 5
    //   263: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   266: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	numbers
    //   0	267	1	paramModuleMethod	ModuleMethod
    //   0	267	2	paramObject1	Object
    //   0	267	3	paramObject2	Object
    //   0	267	4	paramObject3	Object
    //   0	267	5	paramObject4	Object
    //   201	7	6	localClassCastException1	ClassCastException
    //   92	32	7	localIntNum1	IntNum
    //   217	7	8	localClassCastException2	ClassCastException
    //   101	25	9	i	int
    //   233	7	10	localClassCastException3	ClassCastException
    //   111	17	11	j	int
    //   250	7	12	localClassCastException4	ClassCastException
    //   121	9	13	k	int
    //   135	7	14	localClassCastException5	ClassCastException
    //   48	29	15	localIntNum2	IntNum
    //   151	7	16	localClassCastException6	ClassCastException
    //   57	22	17	m	int
    //   167	7	18	localClassCastException7	ClassCastException
    //   67	14	19	n	int
    //   184	7	20	localClassCastException8	ClassCastException
    //   74	9	21	localIntNum3	IntNum
    // Exception table:
    //   from	to	target	type
    //   44	50	135	java/lang/ClassCastException
    //   50	59	151	java/lang/ClassCastException
    //   59	69	167	java/lang/ClassCastException
    //   69	76	184	java/lang/ClassCastException
    //   88	94	201	java/lang/ClassCastException
    //   94	103	217	java/lang/ClassCastException
    //   103	113	233	java/lang/ClassCastException
    //   113	123	250	java/lang/ClassCastException
  }
  
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    int j;
    IntNum[] arrayOfIntNum2;
    switch (paramModuleMethod.selector)
    {
    case 14: 
    case 15: 
    case 16: 
    default: 
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 12: 
      return max(paramArrayOfObject);
    case 13: 
      return min(paramArrayOfObject);
    case 17: 
      j = paramArrayOfObject.length;
      arrayOfIntNum2 = new IntNum[j];
    }
    for (;;)
    {
      j--;
      if (j < 0) {
        return gcd(arrayOfIntNum2);
      }
      Object localObject2 = paramArrayOfObject[j];
      try
      {
        IntNum localIntNum2 = LangObjType.coerceIntNum(localObject2);
        arrayOfIntNum2[j] = localIntNum2;
      }
      catch (ClassCastException localClassCastException2)
      {
        try
        {
          int i;
          IntNum[] arrayOfIntNum1;
          IntNum localIntNum1 = LangObjType.coerceIntNum(localObject1);
          arrayOfIntNum1[i] = localIntNum1;
        }
        catch (ClassCastException localClassCastException1)
        {
          Object localObject1;
          throw new WrongType(localClassCastException1, "lcm", 0, localObject1);
        }
        localClassCastException2 = localClassCastException2;
        throw new WrongType(localClassCastException2, "gcd", 0, localObject2);
      }
    }
    i = paramArrayOfObject.length;
    arrayOfIntNum1 = new IntNum[i];
    i--;
    if (i < 0) {
      return lcm(arrayOfIntNum1);
    }
    localObject1 = paramArrayOfObject[i];
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 12: 
    case 13: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 25: 
    case 33: 
    case 37: 
    case 38: 
    case 47: 
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 58: 
    case 59: 
    case 61: 
    case 63: 
    case 66: 
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 67: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 65: 
      if (!(paramObject instanceof Quantity)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 64: 
      if (!(paramObject instanceof Quantity)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 62: 
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 60: 
      if (!(paramObject instanceof Number)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 57: 
      if (IntNum.asIntNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 56: 
      if (IntNum.asIntNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 55: 
      if (IntNum.asIntNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 54: 
      if (IntNum.asIntNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 46: 
      if (!(paramObject instanceof Number)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 45: 
      if (!(paramObject instanceof Number)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 44: 
      if (!(paramObject instanceof Number)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 43: 
      if (!(paramObject instanceof Number)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 42: 
      if (!(paramObject instanceof Complex)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 41: 
      if (!(paramObject instanceof Number)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 40: 
      if (!(paramObject instanceof Complex)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 39: 
      if (!(paramObject instanceof Complex)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 36: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 35: 
      if (!(paramObject instanceof Quantity)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 34: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 32: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 31: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 30: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 29: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 28: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 27: 
      if (!(paramObject instanceof Complex)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 26: 
      if (!(paramObject instanceof Complex)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 24: 
      if (RealNum.asRealNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 23: 
      if (RealNum.asRealNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 22: 
      if (RealNum.asRealNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 21: 
      if (RealNum.asRealNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 20: 
      if (RatNum.asRatNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 19: 
      if (RatNum.asRatNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 14: 
      if (!(paramObject instanceof Number)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 11: 
      if (RealNum.asRealNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 10: 
      if (RealNum.asRealNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 9: 
      if (!(paramObject instanceof Number)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 8: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 7: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 6: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 5: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 4: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 3: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2: 
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
    case 66: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 62: 
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
    case 60: 
      if (!(paramObject1 instanceof Number)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 53: 
      if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (IntNum.asIntNumOrNull(paramObject2) != null)
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 48: 
      if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
    case 38: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 37: 
      if (RealNum.asRealNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (RealNum.asRealNumOrNull(paramObject2) != null)
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 33: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 25: 
      if (RealNum.asRealNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (RealNum.asRealNumOrNull(paramObject2) != null)
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 16: 
      if (RealNum.asRealNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (RealNum.asRealNumOrNull(paramObject2) != null)
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    }
    if (RealNum.asRealNumOrNull(paramObject1) != null)
    {
      paramCallContext.value1 = paramObject1;
      if (RealNum.asRealNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
    }
    else
    {
      return -786431;
    }
    return -786430;
  }
  
  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 59: 
      if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786431;
    case 52: 
      if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (IntNum.asIntNumOrNull(paramObject2) != null)
        {
          paramCallContext.value2 = paramObject2;
          if (IntNum.asIntNumOrNull(paramObject3) == null) {
            break label175;
          }
          paramCallContext.value3 = paramObject3;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 3;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
      return -786429;
    case 51: 
      if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786431;
    case 49: 
      label175:
      if (IntNum.asIntNumOrNull(paramObject1) != null)
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
    paramCallContext.value1 = paramObject1;
    if (IntNum.asIntNumOrNull(paramObject2) != null)
    {
      paramCallContext.value2 = paramObject2;
      if (IntNum.asIntNumOrNull(paramObject3) != null)
      {
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
    }
    else
    {
      return -786430;
    }
    return -786429;
  }
  
  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    case 58: 
      if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.value4 = paramObject4;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 4;
        return 0;
      }
      return -786431;
    }
    if (IntNum.asIntNumOrNull(paramObject1) != null)
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      if (IntNum.asIntNumOrNull(paramObject4) != null)
      {
        paramCallContext.value4 = paramObject4;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 4;
        return 0;
      }
    }
    else
    {
      return -786431;
    }
    return -786428;
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 14: 
    case 15: 
    case 16: 
    default: 
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 18: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 17: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 13: 
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
    atan = new GenericProc("atan");
    GenericProc localGenericProc1 = atan;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = lambda$Fn1;
    arrayOfObject1[1] = lambda$Fn2;
    localGenericProc1.setProperties(arrayOfObject1);
    sqrt = new GenericProc("sqrt");
    GenericProc localGenericProc2 = sqrt;
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = lambda$Fn3;
    arrayOfObject2[1] = lambda$Fn4;
    localGenericProc2.setProperties(arrayOfObject2);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.numbers
 * JD-Core Version:    0.7.0.1
 */