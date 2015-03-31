package gnu.kawa.slib;

import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.Quote;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.prim_syntax;
import kawa.lib.std_syntax;
import kawa.standard.syntax_case;

public class enums
  extends ModuleBody
{
  public static final Macro $Prvt$$Pcdefine$Mnenum;
  public static final enums $instance;
  static final PairWithPosition Lit0;
  static final PairWithPosition Lit1;
  static final PairWithPosition Lit10;
  static final SimpleSymbol Lit11;
  static final SyntaxPattern Lit12;
  static final SyntaxTemplate Lit13;
  static final SyntaxTemplate Lit14;
  static final SyntaxPattern Lit15;
  static final SyntaxTemplate Lit16;
  static final SyntaxPattern Lit17;
  static final SyntaxPattern Lit18;
  static final SyntaxPattern Lit19;
  static final PairWithPosition Lit2;
  static final SyntaxTemplate Lit20;
  static final SimpleSymbol Lit21;
  static final SyntaxPattern Lit22;
  static final SyntaxTemplate Lit23;
  static final SimpleSymbol Lit24;
  static final SyntaxTemplate Lit25;
  static final SyntaxTemplate Lit26;
  static final SyntaxTemplate Lit27;
  static final SyntaxTemplate Lit28;
  static final SyntaxTemplate Lit29;
  static final PairWithPosition Lit3;
  static final SyntaxTemplate Lit30;
  static final SyntaxTemplate Lit31;
  static final SyntaxTemplate Lit32;
  static final SyntaxTemplate Lit33;
  static final SyntaxTemplate Lit34;
  static final SyntaxTemplate Lit35;
  static final SyntaxTemplate Lit36;
  static final SyntaxTemplate Lit37;
  static final SyntaxTemplate Lit38;
  static final SyntaxTemplate Lit39;
  static final PairWithPosition Lit4;
  static final SimpleSymbol Lit40;
  static final SimpleSymbol Lit41;
  static final SimpleSymbol Lit42;
  static final SimpleSymbol Lit43;
  static final SimpleSymbol Lit44;
  static final SimpleSymbol Lit45;
  static final Keyword Lit46;
  static final SimpleSymbol Lit47;
  static final Keyword Lit48;
  static final SimpleSymbol Lit49;
  static final PairWithPosition Lit5;
  static final SimpleSymbol Lit50;
  static final SimpleSymbol Lit51;
  static final SimpleSymbol Lit52;
  static final SimpleSymbol Lit53 = (SimpleSymbol)new SimpleSymbol("final").readResolve();
  static final PairWithPosition Lit6;
  static final PairWithPosition Lit7;
  static final PairWithPosition Lit8;
  static final PairWithPosition Lit9;
  public static final Macro define$Mnenum;
  
  static
  {
    Lit52 = (SimpleSymbol)new SimpleSymbol("enum").readResolve();
    Lit51 = (SimpleSymbol)new SimpleSymbol("num").readResolve();
    Lit50 = (SimpleSymbol)new SimpleSymbol("str").readResolve();
    Lit49 = (SimpleSymbol)new SimpleSymbol("*init*").readResolve();
    Lit48 = Keyword.make("access");
    Lit47 = (SimpleSymbol)new SimpleSymbol("String").readResolve();
    Lit46 = Keyword.make("allocation");
    Lit45 = (SimpleSymbol)new SimpleSymbol("static").readResolve();
    Lit44 = (SimpleSymbol)new SimpleSymbol("java.lang.Enum").readResolve();
    Lit43 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    Lit42 = (SimpleSymbol)new SimpleSymbol("::").readResolve();
    Lit41 = (SimpleSymbol)new SimpleSymbol("s").readResolve();
    Lit40 = (SimpleSymbol)new SimpleSymbol("valueOf").readResolve();
    Lit39 = new SyntaxTemplate("\001\001\001\003\003", "\020", new Object[0], 0);
    Lit38 = new SyntaxTemplate("\001\001\001\003\003", "\020", new Object[0], 0);
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = PairWithPosition.make(Lit41, LList.Empty, "enums.scm", 290882);
    Lit37 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", arrayOfObject1, 0);
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("$lookup$").readResolve(), Pair.make(Lit44, Pair.make(Pair.make((SimpleSymbol)new SimpleSymbol("quasiquote").readResolve(), Pair.make(Lit40, LList.Empty)), LList.Empty)), "enums.scm", 290823);
    Lit36 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", arrayOfObject2, 0);
    Object[] arrayOfObject3 = new Object[1];
    arrayOfObject3[0] = PairWithPosition.make(Lit43, PairWithPosition.make(Lit45, LList.Empty, "enums.scm", 286739), "enums.scm", 286739);
    Lit35 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", arrayOfObject3, 0);
    Object[] arrayOfObject4 = new Object[1];
    arrayOfObject4[0] = PairWithPosition.make(Lit46, LList.Empty, "enums.scm", 286726);
    Lit34 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", arrayOfObject4, 0);
    Object[] arrayOfObject5 = new Object[1];
    arrayOfObject5[0] = PairWithPosition.make(Lit42, LList.Empty, "enums.scm", 282649);
    Lit33 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", arrayOfObject5, 0);
    Object[] arrayOfObject6 = new Object[1];
    arrayOfObject6[0] = PairWithPosition.make(Lit40, PairWithPosition.make(Lit41, PairWithPosition.make(Lit42, PairWithPosition.make(Lit47, LList.Empty, "enums.scm", 282642), "enums.scm", 282640), "enums.scm", 282639), "enums.scm", 282630);
    Lit32 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", arrayOfObject6, 0);
    Object[] arrayOfObject7 = new Object[1];
    arrayOfObject7[0] = PairWithPosition.make(Lit43, PairWithPosition.make(PairWithPosition.make(Lit52, PairWithPosition.make(Lit53, LList.Empty, "enums.scm", 266284), "enums.scm", 266278), LList.Empty, "enums.scm", 266278), "enums.scm", 266278);
    Lit31 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", arrayOfObject7, 0);
    Object[] arrayOfObject8 = new Object[1];
    arrayOfObject8[0] = PairWithPosition.make(Lit48, LList.Empty, "enums.scm", 266269);
    Lit30 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", arrayOfObject8, 0);
    Object[] arrayOfObject9 = new Object[1];
    arrayOfObject9[0] = PairWithPosition.make(Lit44, LList.Empty, "enums.scm", 266252);
    Lit29 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", arrayOfObject9, 0);
    Object[] arrayOfObject10 = new Object[1];
    arrayOfObject10[0] = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("define-simple-class").readResolve(), LList.Empty, "enums.scm", 262154);
    Lit28 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", arrayOfObject10, 0);
    Lit27 = new SyntaxTemplate("\001\001\001\003\003", "\b%#", new Object[0], 1);
    Lit26 = new SyntaxTemplate("\001\001\001\003\003", "\023", new Object[0], 0);
    Lit25 = new SyntaxTemplate("\001\001\001\003\003", "\b\035\033", new Object[0], 1);
    Lit24 = (SimpleSymbol)new SimpleSymbol("[]").readResolve();
    Lit23 = new SyntaxTemplate("\001\001\001\003\003", "\013", new Object[0], 0);
    Lit22 = new SyntaxPattern("\f\007\f\017\f\027,\r\037\030\b\b\r' \b\b", new Object[0], 5);
    Lit21 = (SimpleSymbol)new SimpleSymbol("%define-enum").readResolve();
    Object[] arrayOfObject11 = new Object[2];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("define-enum").readResolve();
    Lit11 = localSimpleSymbol1;
    arrayOfObject11[0] = localSimpleSymbol1;
    arrayOfObject11[1] = "findkeywords";
    Lit20 = new SyntaxTemplate("\001\001\003", "\021\030\004\021\030\f\t\013\t\020\b\025\023", arrayOfObject11, 1);
    Lit19 = new SyntaxPattern("\f\007\f\017\r\027\020\b\b", new Object[0], 3);
    Lit18 = new SyntaxPattern("\f\007\f\017\b", new Object[0], 2);
    Lit17 = new SyntaxPattern("\f\007\b", new Object[0], 1);
    Object[] arrayOfObject12 = new Object[1];
    arrayOfObject12[0] = Lit21;
    Lit16 = new SyntaxTemplate("\001\001\003\003", "\021\030\004\t\013\031\b\025\023\b\035\033", arrayOfObject12, 1);
    Lit15 = new SyntaxPattern("\f\007\f\002\f\017,\r\027\020\b\b\r\037\030\b\b", new Object[] { "findkeywords" }, 4);
    Object[] arrayOfObject13 = new Object[2];
    arrayOfObject13[0] = Lit11;
    arrayOfObject13[1] = "findkeywords";
    Lit14 = new SyntaxTemplate("\001\001\003\001\001\003", "\021\030\004\021\030\f\t\0139\t\033\t#\b\025\023\b-+", arrayOfObject13, 1);
    Lit13 = new SyntaxTemplate("\001\001\003\001\001\003", "\033", new Object[0], 0);
    Lit12 = new SyntaxPattern("\f\007\f\002\f\017,\r\027\020\b\b\f\037\f'\r/(\b\b", new Object[] { "findkeywords" }, 6);
    Lit10 = PairWithPosition.make(Lit43, PairWithPosition.make(Lit45, LList.Empty, "enums.scm", 127013), "enums.scm", 127013);
    Lit9 = PairWithPosition.make(Lit46, LList.Empty, "enums.scm", 127000);
    Lit8 = PairWithPosition.make(Lit42, LList.Empty, "enums.scm", 126990);
    Lit7 = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("values").readResolve(), LList.Empty, "enums.scm", 126981);
    Lit6 = PairWithPosition.make(PairWithPosition.make(Lit49, PairWithPosition.make(PairWithPosition.make(Lit50, PairWithPosition.make(Lit42, PairWithPosition.make(Lit47, LList.Empty, "enums.scm", 90133), "enums.scm", 90130), "enums.scm", 90125), PairWithPosition.make(PairWithPosition.make(Lit51, PairWithPosition.make(Lit42, PairWithPosition.make((SimpleSymbol)new SimpleSymbol("int").readResolve(), LList.Empty, "enums.scm", 90149), "enums.scm", 90146), "enums.scm", 90141), LList.Empty, "enums.scm", 90141), "enums.scm", 90125), "enums.scm", 90117), PairWithPosition.make(Lit48, PairWithPosition.make(PairWithPosition.make(Lit43, PairWithPosition.make((SimpleSymbol)new SimpleSymbol("private").readResolve(), LList.Empty, "enums.scm", 94222), "enums.scm", 94222), PairWithPosition.make(PairWithPosition.make((SimpleSymbol)new SimpleSymbol("invoke-special").readResolve(), PairWithPosition.make(Lit44, PairWithPosition.make(PairWithPosition.make((SimpleSymbol)new SimpleSymbol("this").readResolve(), LList.Empty, "enums.scm", 98340), PairWithPosition.make(PairWithPosition.make(Lit43, PairWithPosition.make(Lit49, LList.Empty, "enums.scm", 98348), "enums.scm", 98348), PairWithPosition.make(Lit50, PairWithPosition.make(Lit51, LList.Empty, "enums.scm", 98359), "enums.scm", 98355), "enums.scm", 98347), "enums.scm", 98340), "enums.scm", 98325), "enums.scm", 98309), LList.Empty, "enums.scm", 98309), "enums.scm", 94221), "enums.scm", 94213), "enums.scm", 90116);
    Lit5 = PairWithPosition.make(Keyword.make("init"), LList.Empty, "enums.scm", 73741);
    Lit4 = PairWithPosition.make(Lit43, PairWithPosition.make(PairWithPosition.make(Lit52, PairWithPosition.make(Lit53, LList.Empty, "enums.scm", 69680), "enums.scm", 69674), LList.Empty, "enums.scm", 69674), "enums.scm", 69674);
    Lit3 = PairWithPosition.make(Lit48, LList.Empty, "enums.scm", 69665);
    Lit2 = PairWithPosition.make(Lit43, PairWithPosition.make(Lit45, LList.Empty, "enums.scm", 69658), "enums.scm", 69658);
    Lit1 = PairWithPosition.make(Lit46, LList.Empty, "enums.scm", 69645);
    Lit0 = PairWithPosition.make(Lit42, LList.Empty, "enums.scm", 65549);
    $instance = new enums();
    SimpleSymbol localSimpleSymbol2 = Lit11;
    enums localenums = $instance;
    define$Mnenum = Macro.make(localSimpleSymbol2, new ModuleMethod(localenums, 1, null, 4097), $instance);
    $Prvt$$Pcdefine$Mnenum = Macro.make(Lit21, new ModuleMethod(localenums, 2, null, 4097), $instance);
    $instance.run();
  }
  
  public enums()
  {
    ModuleInfo.register(this);
  }
  
  static Object lambda1(Object paramObject)
  {
    Object[] arrayOfObject1 = SyntaxPattern.allocVars(6, null);
    if (Lit12.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope3 = TemplateScope.make();
      if (std_syntax.isIdentifier(Lit13.execute(arrayOfObject1, localTemplateScope3)))
      {
        TemplateScope localTemplateScope4 = TemplateScope.make();
        return Lit14.execute(arrayOfObject1, localTemplateScope4);
      }
    }
    if (Lit15.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return Lit16.execute(arrayOfObject1, localTemplateScope2);
    }
    if (Lit17.match(paramObject, arrayOfObject1, 0))
    {
      if (("no enum type name given" instanceof Object[])) {}
      for (Object[] arrayOfObject3 = (Object[])"no enum type name given";; arrayOfObject3 = new Object[] { "no enum type name given" }) {
        return prim_syntax.syntaxError(paramObject, arrayOfObject3);
      }
    }
    if (Lit18.match(paramObject, arrayOfObject1, 0))
    {
      if (("no enum constants given" instanceof Object[])) {}
      for (Object[] arrayOfObject2 = (Object[])"no enum constants given";; arrayOfObject2 = new Object[] { "no enum constants given" }) {
        return prim_syntax.syntaxError(paramObject, arrayOfObject2);
      }
    }
    if (Lit19.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      return Lit20.execute(arrayOfObject1, localTemplateScope1);
    }
    return syntax_case.error("syntax-case", paramObject);
  }
  
  static Object lambda2(Object paramObject)
  {
    Object[] arrayOfObject1 = SyntaxPattern.allocVars(5, null);
    if (Lit22.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      localObject1 = Lit23.execute(arrayOfObject1, localTemplateScope1);
    }
    try
    {
      localSymbol = (Symbol)localObject1;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = localSymbol;
      arrayOfObject2[1] = Lit24;
      localSimpleSymbol = symbolAppend$V(arrayOfObject2);
      TemplateScope localTemplateScope2 = TemplateScope.make();
      localObject2 = Lit25.execute(arrayOfObject1, localTemplateScope2);
    }
    catch (ClassCastException localClassCastException1)
    {
      Symbol localSymbol;
      SimpleSymbol localSimpleSymbol;
      LList localLList1;
      LList localLList2;
      PairWithPosition localPairWithPosition;
      Pair localPair1;
      TemplateScope localTemplateScope3;
      LList localLList3;
      TemplateScope localTemplateScope4;
      LList localLList4;
      TemplateScope localTemplateScope5;
      Object[] arrayOfObject3;
      Object[] arrayOfObject4;
      Object localObject5;
      Object[] arrayOfObject5;
      Object localObject6;
      Object[] arrayOfObject6;
      Object[] arrayOfObject7;
      Object[] arrayOfObject8;
      Object localObject7;
      Object[] arrayOfObject9;
      Object[] arrayOfObject10;
      Object[] arrayOfObject11;
      Object localObject8;
      Object localObject9;
      Object[] arrayOfObject12;
      Pair localPair2;
      Object[] arrayOfObject13;
      Object[] arrayOfObject14;
      throw new WrongType(localClassCastException1, "t-name", -2, localObject1);
    }
    try
    {
      localLList1 = (LList)localObject2;
      lists.length(localLList1);
      localLList2 = mapNames(localSymbol, localLList1, 0);
      localPairWithPosition = makeInit();
      localPair1 = makeValues(localSimpleSymbol, localLList1);
      localTemplateScope3 = TemplateScope.make();
      localObject3 = Lit26.execute(arrayOfObject1, localTemplateScope3);
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "e-names", -2, localObject2);
    }
    try
    {
      localLList3 = (LList)localObject3;
      localTemplateScope4 = TemplateScope.make();
      localObject4 = Lit27.execute(arrayOfObject1, localTemplateScope4);
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "opts", -2, localObject3);
    }
    try
    {
      localLList4 = (LList)localObject4;
      localTemplateScope5 = TemplateScope.make();
      arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = Lit28.execute(arrayOfObject1, localTemplateScope5);
      arrayOfObject4 = new Object[2];
      arrayOfObject4[0] = std_syntax.datum$To$SyntaxObject(paramObject, localSymbol);
      localObject5 = Lit29.execute(arrayOfObject1, localTemplateScope5);
      arrayOfObject5 = new Object[2];
      arrayOfObject5[0] = Lit30.execute(arrayOfObject1, localTemplateScope5);
      localObject6 = Lit31.execute(arrayOfObject1, localTemplateScope5);
      arrayOfObject6 = new Object[2];
      arrayOfObject6[0] = std_syntax.datum$To$SyntaxObject(paramObject, localLList3);
      arrayOfObject7 = new Object[2];
      arrayOfObject7[0] = std_syntax.datum$To$SyntaxObject(paramObject, localPairWithPosition);
      arrayOfObject8 = new Object[2];
      arrayOfObject8[0] = std_syntax.datum$To$SyntaxObject(paramObject, localPair1);
      localObject7 = Lit32.execute(arrayOfObject1, localTemplateScope5);
      arrayOfObject9 = new Object[2];
      arrayOfObject9[0] = Lit33.execute(arrayOfObject1, localTemplateScope5);
      arrayOfObject10 = new Object[2];
      arrayOfObject10[0] = std_syntax.datum$To$SyntaxObject(paramObject, localSymbol);
      arrayOfObject11 = new Object[2];
      arrayOfObject11[0] = Lit34.execute(arrayOfObject1, localTemplateScope5);
      localObject8 = Lit35.execute(arrayOfObject1, localTemplateScope5);
      localObject9 = Lit36.execute(arrayOfObject1, localTemplateScope5);
      arrayOfObject12 = new Object[2];
      arrayOfObject12[0] = std_syntax.datum$To$SyntaxObject(paramObject, localSymbol);
      arrayOfObject12[1] = Lit37.execute(arrayOfObject1, localTemplateScope5);
      arrayOfObject11[1] = Pair.make(localObject8, Pair.make(Pair.make(localObject9, Quote.consX$V(arrayOfObject12)), Lit38.execute(arrayOfObject1, localTemplateScope5)));
      arrayOfObject10[1] = Quote.append$V(arrayOfObject11);
      arrayOfObject9[1] = Quote.consX$V(arrayOfObject10);
      localPair2 = Pair.make(localObject7, Quote.append$V(arrayOfObject9));
      arrayOfObject13 = new Object[2];
      arrayOfObject13[0] = std_syntax.datum$To$SyntaxObject(paramObject, localLList2);
      arrayOfObject14 = new Object[2];
      arrayOfObject14[0] = std_syntax.datum$To$SyntaxObject(paramObject, localLList4);
      arrayOfObject14[1] = Lit39.execute(arrayOfObject1, localTemplateScope5);
      arrayOfObject13[1] = Quote.append$V(arrayOfObject14);
      arrayOfObject8[1] = Pair.make(localPair2, Quote.append$V(arrayOfObject13));
      arrayOfObject7[1] = Quote.consX$V(arrayOfObject8);
      arrayOfObject6[1] = Quote.consX$V(arrayOfObject7);
      arrayOfObject5[1] = Pair.make(localObject6, Quote.append$V(arrayOfObject6));
      arrayOfObject4[1] = Pair.make(localObject5, Quote.append$V(arrayOfObject5));
      arrayOfObject3[1] = Quote.consX$V(arrayOfObject4);
      return Quote.append$V(arrayOfObject3);
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "other-defs", -2, localObject4);
    }
    return syntax_case.error("syntax-case", paramObject);
  }
  
  static Object makeFieldDesc(Symbol paramSymbol1, Symbol paramSymbol2, int paramInt)
  {
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = paramSymbol2;
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Lit0;
    Object[] arrayOfObject3 = new Object[2];
    arrayOfObject3[0] = paramSymbol1;
    Object[] arrayOfObject4 = new Object[2];
    arrayOfObject4[0] = Lit1;
    PairWithPosition localPairWithPosition1 = Lit2;
    Object[] arrayOfObject5 = new Object[2];
    arrayOfObject5[0] = Lit3;
    PairWithPosition localPairWithPosition2 = Lit4;
    Object[] arrayOfObject6 = new Object[2];
    arrayOfObject6[0] = Lit5;
    Object[] arrayOfObject7 = new Object[2];
    arrayOfObject7[0] = paramSymbol1;
    Object[] arrayOfObject8 = new Object[2];
    arrayOfObject8[0] = misc.symbol$To$String(paramSymbol2);
    Object[] arrayOfObject9 = new Object[2];
    arrayOfObject9[0] = Integer.valueOf(paramInt);
    arrayOfObject9[1] = LList.Empty;
    arrayOfObject8[1] = Quote.consX$V(arrayOfObject9);
    arrayOfObject7[1] = Quote.consX$V(arrayOfObject8);
    arrayOfObject6[1] = Pair.make(Quote.consX$V(arrayOfObject7), LList.Empty);
    arrayOfObject5[1] = Pair.make(localPairWithPosition2, Quote.append$V(arrayOfObject6));
    arrayOfObject4[1] = Pair.make(localPairWithPosition1, Quote.append$V(arrayOfObject5));
    arrayOfObject3[1] = Quote.append$V(arrayOfObject4);
    arrayOfObject2[1] = Quote.consX$V(arrayOfObject3);
    arrayOfObject1[1] = Quote.append$V(arrayOfObject2);
    return Quote.consX$V(arrayOfObject1);
  }
  
  static PairWithPosition makeInit()
  {
    return Lit6;
  }
  
  static Pair makeValues(Symbol paramSymbol, LList paramLList)
  {
    PairWithPosition localPairWithPosition1 = Lit7;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Lit8;
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = paramSymbol;
    Object[] arrayOfObject3 = new Object[2];
    arrayOfObject3[0] = Lit9;
    PairWithPosition localPairWithPosition2 = Lit10;
    Object[] arrayOfObject4 = new Object[2];
    arrayOfObject4[0] = paramSymbol;
    Object[] arrayOfObject5 = new Object[2];
    arrayOfObject5[0] = paramLList;
    arrayOfObject5[1] = LList.Empty;
    arrayOfObject4[1] = Quote.append$V(arrayOfObject5);
    arrayOfObject3[1] = Pair.make(localPairWithPosition2, Pair.make(Quote.consX$V(arrayOfObject4), LList.Empty));
    arrayOfObject2[1] = Quote.append$V(arrayOfObject3);
    arrayOfObject1[1] = Quote.consX$V(arrayOfObject2);
    return Pair.make(localPairWithPosition1, Quote.append$V(arrayOfObject1));
  }
  
  /* Error */
  static LList mapNames(Symbol paramSymbol, LList paramLList, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 505	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   4: ifeq +7 -> 11
    //   7: getstatic 163	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   10: areturn
    //   11: getstatic 509	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   14: aload_1
    //   15: invokevirtual 514	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: astore_3
    //   19: aload_3
    //   20: checkcast 441	gnu/mapping/Symbol
    //   23: astore 5
    //   25: aload_0
    //   26: aload 5
    //   28: iload_2
    //   29: invokestatic 516	gnu/kawa/slib/enums:makeFieldDesc	(Lgnu/mapping/Symbol;Lgnu/mapping/Symbol;I)Ljava/lang/Object;
    //   32: astore 6
    //   34: getstatic 519	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   37: aload_1
    //   38: invokevirtual 514	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: astore 7
    //   43: aload 7
    //   45: checkcast 159	gnu/lists/LList
    //   48: astore 9
    //   50: aload 6
    //   52: aload_0
    //   53: aload 9
    //   55: iload_2
    //   56: iconst_1
    //   57: iadd
    //   58: invokestatic 455	gnu/kawa/slib/enums:mapNames	(Lgnu/mapping/Symbol;Lgnu/lists/LList;I)Lgnu/lists/LList;
    //   61: invokestatic 522	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   64: areturn
    //   65: astore 4
    //   67: new 478	gnu/mapping/WrongType
    //   70: dup
    //   71: aload 4
    //   73: ldc_w 524
    //   76: iconst_1
    //   77: aload_3
    //   78: invokespecial 483	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   81: athrow
    //   82: astore 8
    //   84: new 478	gnu/mapping/WrongType
    //   87: dup
    //   88: aload 8
    //   90: ldc_w 526
    //   93: iconst_1
    //   94: aload 7
    //   96: invokespecial 483	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramSymbol	Symbol
    //   0	100	1	paramLList	LList
    //   0	100	2	paramInt	int
    //   18	60	3	localObject1	Object
    //   65	7	4	localClassCastException1	ClassCastException
    //   23	4	5	localSymbol	Symbol
    //   32	19	6	localObject2	Object
    //   41	54	7	localObject3	Object
    //   82	7	8	localClassCastException2	ClassCastException
    //   48	6	9	localLList	LList
    // Exception table:
    //   from	to	target	type
    //   19	25	65	java/lang/ClassCastException
    //   43	50	82	java/lang/ClassCastException
  }
  
  /* Error */
  static SimpleSymbol symbolAppend$V(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: invokestatic 530	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: astore_1
    //   6: getstatic 536	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   9: astore_2
    //   10: getstatic 542	kawa/lib/strings:string$Mnappend	Lgnu/expr/ModuleMethod;
    //   13: astore_3
    //   14: getstatic 163	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   17: astore 4
    //   19: aload_1
    //   20: astore 5
    //   22: aload 5
    //   24: getstatic 163	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   27: if_acmpne +28 -> 55
    //   30: aload_2
    //   31: aload_3
    //   32: aload 4
    //   34: invokestatic 546	gnu/lists/LList:reverseInPlace	(Ljava/lang/Object;)Lgnu/lists/LList;
    //   37: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: astore 12
    //   42: aload 12
    //   44: checkcast 551	java/lang/CharSequence
    //   47: astore 14
    //   49: aload 14
    //   51: invokestatic 555	kawa/lib/misc:string$To$Symbol	(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
    //   54: areturn
    //   55: aload 5
    //   57: checkcast 181	gnu/lists/Pair
    //   60: astore 7
    //   62: aload 7
    //   64: invokevirtual 558	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   67: astore 8
    //   69: aload 7
    //   71: invokevirtual 561	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   74: astore 9
    //   76: aload 9
    //   78: checkcast 441	gnu/mapping/Symbol
    //   81: astore 11
    //   83: aload 11
    //   85: invokestatic 497	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   88: aload 4
    //   90: invokestatic 184	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   93: astore 4
    //   95: aload 8
    //   97: astore 5
    //   99: goto -77 -> 22
    //   102: astore 6
    //   104: new 478	gnu/mapping/WrongType
    //   107: dup
    //   108: aload 6
    //   110: ldc_w 563
    //   113: bipush 254
    //   115: aload 5
    //   117: invokespecial 483	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   120: athrow
    //   121: astore 10
    //   123: new 478	gnu/mapping/WrongType
    //   126: dup
    //   127: aload 10
    //   129: ldc_w 565
    //   132: iconst_1
    //   133: aload 9
    //   135: invokespecial 483	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   138: athrow
    //   139: astore 13
    //   141: new 478	gnu/mapping/WrongType
    //   144: dup
    //   145: aload 13
    //   147: ldc_w 567
    //   150: iconst_1
    //   151: aload 12
    //   153: invokespecial 483	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramArrayOfObject	Object[]
    //   5	15	1	localLList	LList
    //   9	22	2	localApply	gnu.kawa.functions.Apply
    //   13	19	3	localModuleMethod	ModuleMethod
    //   17	77	4	localObject1	Object
    //   20	96	5	localObject2	Object
    //   102	7	6	localClassCastException1	ClassCastException
    //   60	10	7	localPair	Pair
    //   67	29	8	localObject3	Object
    //   74	60	9	localObject4	Object
    //   121	7	10	localClassCastException2	ClassCastException
    //   81	3	11	localSymbol	Symbol
    //   40	112	12	localObject5	Object
    //   139	7	13	localClassCastException3	ClassCastException
    //   47	3	14	localCharSequence	java.lang.CharSequence
    // Exception table:
    //   from	to	target	type
    //   55	62	102	java/lang/ClassCastException
    //   76	83	121	java/lang/ClassCastException
    //   42	49	139	java/lang/ClassCastException
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 1: 
      return lambda1(paramObject);
    }
    return lambda2(paramObject);
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
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
  
  public final void run(CallContext paramCallContext) {}
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.enums
 * JD-Core Version:    0.7.0.1
 */