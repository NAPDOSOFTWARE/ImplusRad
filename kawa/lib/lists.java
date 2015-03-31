package kawa.lib;

import gnu.expr.GenericProc;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.reflect.SlotSet;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.standard.Scheme;

public class lists
  extends ModuleBody
{
  public static final Location $Prvt$define$Mnprocedure;
  public static final lists $instance;
  static final Keyword Lit0;
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
  static final SimpleSymbol Lit19 = (SimpleSymbol)new SimpleSymbol("assoc").readResolve();
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod assoc;
  public static final ModuleMethod assq;
  public static final ModuleMethod assv;
  public static final GenericProc caaaar;
  static final ModuleMethod caaaar$Fn28;
  public static final GenericProc caaadr;
  static final ModuleMethod caaadr$Fn30;
  public static final GenericProc caaar;
  static final ModuleMethod caaar$Fn12;
  public static final GenericProc caadar;
  static final ModuleMethod caadar$Fn32;
  public static final GenericProc caaddr;
  static final ModuleMethod caaddr$Fn34;
  public static final GenericProc caadr;
  static final ModuleMethod caadr$Fn14;
  public static final GenericProc caar;
  static final ModuleMethod caar$Fn4;
  public static final GenericProc cadaar;
  static final ModuleMethod cadaar$Fn36;
  public static final GenericProc cadadr;
  static final ModuleMethod cadadr$Fn38;
  public static final GenericProc cadar;
  static final ModuleMethod cadar$Fn16;
  public static final GenericProc caddar;
  static final ModuleMethod caddar$Fn40;
  public static final GenericProc cadddr;
  static final ModuleMethod cadddr$Fn42;
  public static final GenericProc caddr;
  static final ModuleMethod caddr$Fn18;
  public static final GenericProc cadr;
  static final ModuleMethod cadr$Fn6;
  public static final GenericProc car;
  static final ModuleMethod car$Fn1;
  public static final GenericProc cdaaar;
  static final ModuleMethod cdaaar$Fn44;
  public static final GenericProc cdaadr;
  static final ModuleMethod cdaadr$Fn46;
  public static final GenericProc cdaar;
  static final ModuleMethod cdaar$Fn20;
  public static final GenericProc cdadar;
  static final ModuleMethod cdadar$Fn48;
  public static final GenericProc cdaddr;
  static final ModuleMethod cdaddr$Fn50;
  public static final GenericProc cdadr;
  static final ModuleMethod cdadr$Fn22;
  public static final GenericProc cdar;
  static final ModuleMethod cdar$Fn8;
  public static final GenericProc cddaar;
  static final ModuleMethod cddaar$Fn52;
  public static final GenericProc cddadr;
  static final ModuleMethod cddadr$Fn54;
  public static final GenericProc cddar;
  static final ModuleMethod cddar$Fn24;
  public static final GenericProc cdddar;
  static final ModuleMethod cdddar$Fn56;
  public static final GenericProc cddddr;
  static final ModuleMethod cddddr$Fn58;
  public static final GenericProc cdddr;
  static final ModuleMethod cdddr$Fn26;
  public static final GenericProc cddr;
  static final ModuleMethod cddr$Fn10;
  public static final GenericProc cdr;
  static final ModuleMethod cdr$Fn2;
  public static final ModuleMethod cons;
  static final ModuleMethod lambda$Fn11;
  static final ModuleMethod lambda$Fn13;
  static final ModuleMethod lambda$Fn15;
  static final ModuleMethod lambda$Fn17;
  static final ModuleMethod lambda$Fn19;
  static final ModuleMethod lambda$Fn21;
  static final ModuleMethod lambda$Fn23;
  static final ModuleMethod lambda$Fn25;
  static final ModuleMethod lambda$Fn27;
  static final ModuleMethod lambda$Fn29;
  static final ModuleMethod lambda$Fn3;
  static final ModuleMethod lambda$Fn31;
  static final ModuleMethod lambda$Fn33;
  static final ModuleMethod lambda$Fn35;
  static final ModuleMethod lambda$Fn37;
  static final ModuleMethod lambda$Fn39;
  static final ModuleMethod lambda$Fn41;
  static final ModuleMethod lambda$Fn43;
  static final ModuleMethod lambda$Fn45;
  static final ModuleMethod lambda$Fn47;
  static final ModuleMethod lambda$Fn49;
  static final ModuleMethod lambda$Fn5;
  static final ModuleMethod lambda$Fn51;
  static final ModuleMethod lambda$Fn53;
  static final ModuleMethod lambda$Fn55;
  static final ModuleMethod lambda$Fn57;
  static final ModuleMethod lambda$Fn7;
  static final ModuleMethod lambda$Fn9;
  public static final ModuleMethod length;
  public static final ModuleMethod list$Mnref;
  public static final ModuleMethod list$Mntail;
  public static final ModuleMethod list$Qu;
  public static final ModuleMethod member;
  public static final ModuleMethod memq;
  public static final ModuleMethod memv;
  public static final ModuleMethod null$Qu;
  public static final ModuleMethod pair$Qu;
  public static final ModuleMethod reverse;
  public static final ModuleMethod reverse$Ex;
  public static final ModuleMethod set$Mncar$Ex;
  public static final ModuleMethod set$Mncdr$Ex;
  
  static
  {
    Lit18 = (SimpleSymbol)new SimpleSymbol("assv").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("assq").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("member").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("memv").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("memq").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("reverse!").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("list?").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("list-ref").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("list-tail").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("reverse").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("length").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("set-cdr!").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("set-car!").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("null?").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("cons").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("pair?").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("cdr").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("car").readResolve();
    Lit0 = Keyword.make("setter");
    $instance = new lists();
    $Prvt$define$Mnprocedure = StaticFieldLocation.make("kawa.lib.std_syntax", "define$Mnprocedure");
    lists locallists = $instance;
    pair$Qu = new ModuleMethod(locallists, 1, Lit3, 4097);
    cons = new ModuleMethod(locallists, 2, Lit4, 8194);
    null$Qu = new ModuleMethod(locallists, 3, Lit5, 4097);
    set$Mncar$Ex = new ModuleMethod(locallists, 4, Lit6, 8194);
    set$Mncdr$Ex = new ModuleMethod(locallists, 5, Lit7, 8194);
    ModuleMethod localModuleMethod1 = new ModuleMethod(locallists, 6, "car", 4097);
    localModuleMethod1.setProperty("source-location", "lists.scm:31");
    car$Fn1 = localModuleMethod1;
    ModuleMethod localModuleMethod2 = new ModuleMethod(locallists, 7, "cdr", 4097);
    localModuleMethod2.setProperty("source-location", "lists.scm:36");
    cdr$Fn2 = localModuleMethod2;
    lambda$Fn3 = new ModuleMethod(locallists, 8, null, 8194);
    caar$Fn4 = new ModuleMethod(locallists, 9, "caar", 4097);
    lambda$Fn5 = new ModuleMethod(locallists, 10, null, 8194);
    cadr$Fn6 = new ModuleMethod(locallists, 11, "cadr", 4097);
    lambda$Fn7 = new ModuleMethod(locallists, 12, null, 8194);
    cdar$Fn8 = new ModuleMethod(locallists, 13, "cdar", 4097);
    lambda$Fn9 = new ModuleMethod(locallists, 14, null, 8194);
    cddr$Fn10 = new ModuleMethod(locallists, 15, "cddr", 4097);
    lambda$Fn11 = new ModuleMethod(locallists, 16, null, 8194);
    caaar$Fn12 = new ModuleMethod(locallists, 17, "caaar", 4097);
    lambda$Fn13 = new ModuleMethod(locallists, 18, null, 8194);
    caadr$Fn14 = new ModuleMethod(locallists, 19, "caadr", 4097);
    lambda$Fn15 = new ModuleMethod(locallists, 20, null, 8194);
    cadar$Fn16 = new ModuleMethod(locallists, 21, "cadar", 4097);
    lambda$Fn17 = new ModuleMethod(locallists, 22, null, 8194);
    caddr$Fn18 = new ModuleMethod(locallists, 23, "caddr", 4097);
    lambda$Fn19 = new ModuleMethod(locallists, 24, null, 8194);
    cdaar$Fn20 = new ModuleMethod(locallists, 25, "cdaar", 4097);
    lambda$Fn21 = new ModuleMethod(locallists, 26, null, 8194);
    cdadr$Fn22 = new ModuleMethod(locallists, 27, "cdadr", 4097);
    lambda$Fn23 = new ModuleMethod(locallists, 28, null, 8194);
    cddar$Fn24 = new ModuleMethod(locallists, 29, "cddar", 4097);
    lambda$Fn25 = new ModuleMethod(locallists, 30, null, 8194);
    cdddr$Fn26 = new ModuleMethod(locallists, 31, "cdddr", 4097);
    lambda$Fn27 = new ModuleMethod(locallists, 32, null, 8194);
    caaaar$Fn28 = new ModuleMethod(locallists, 33, "caaaar", 4097);
    lambda$Fn29 = new ModuleMethod(locallists, 34, null, 8194);
    caaadr$Fn30 = new ModuleMethod(locallists, 35, "caaadr", 4097);
    lambda$Fn31 = new ModuleMethod(locallists, 36, null, 8194);
    caadar$Fn32 = new ModuleMethod(locallists, 37, "caadar", 4097);
    lambda$Fn33 = new ModuleMethod(locallists, 38, null, 8194);
    caaddr$Fn34 = new ModuleMethod(locallists, 39, "caaddr", 4097);
    lambda$Fn35 = new ModuleMethod(locallists, 40, null, 8194);
    cadaar$Fn36 = new ModuleMethod(locallists, 41, "cadaar", 4097);
    lambda$Fn37 = new ModuleMethod(locallists, 42, null, 8194);
    cadadr$Fn38 = new ModuleMethod(locallists, 43, "cadadr", 4097);
    lambda$Fn39 = new ModuleMethod(locallists, 44, null, 8194);
    caddar$Fn40 = new ModuleMethod(locallists, 45, "caddar", 4097);
    lambda$Fn41 = new ModuleMethod(locallists, 46, null, 8194);
    cadddr$Fn42 = new ModuleMethod(locallists, 47, "cadddr", 4097);
    lambda$Fn43 = new ModuleMethod(locallists, 48, null, 8194);
    cdaaar$Fn44 = new ModuleMethod(locallists, 49, "cdaaar", 4097);
    lambda$Fn45 = new ModuleMethod(locallists, 50, null, 8194);
    cdaadr$Fn46 = new ModuleMethod(locallists, 51, "cdaadr", 4097);
    lambda$Fn47 = new ModuleMethod(locallists, 52, null, 8194);
    cdadar$Fn48 = new ModuleMethod(locallists, 53, "cdadar", 4097);
    lambda$Fn49 = new ModuleMethod(locallists, 54, null, 8194);
    cdaddr$Fn50 = new ModuleMethod(locallists, 55, "cdaddr", 4097);
    lambda$Fn51 = new ModuleMethod(locallists, 56, null, 8194);
    cddaar$Fn52 = new ModuleMethod(locallists, 57, "cddaar", 4097);
    lambda$Fn53 = new ModuleMethod(locallists, 58, null, 8194);
    cddadr$Fn54 = new ModuleMethod(locallists, 59, "cddadr", 4097);
    lambda$Fn55 = new ModuleMethod(locallists, 60, null, 8194);
    cdddar$Fn56 = new ModuleMethod(locallists, 61, "cdddar", 4097);
    lambda$Fn57 = new ModuleMethod(locallists, 62, null, 8194);
    cddddr$Fn58 = new ModuleMethod(locallists, 63, "cddddr", 4097);
    length = new ModuleMethod(locallists, 64, Lit8, 4097);
    reverse = new ModuleMethod(locallists, 65, Lit9, 4097);
    list$Mntail = new ModuleMethod(locallists, 66, Lit10, 8194);
    list$Mnref = new ModuleMethod(locallists, 67, Lit11, 8194);
    list$Qu = new ModuleMethod(locallists, 68, Lit12, 4097);
    reverse$Ex = new ModuleMethod(locallists, 69, Lit13, 4097);
    memq = new ModuleMethod(locallists, 70, Lit14, 8194);
    memv = new ModuleMethod(locallists, 71, Lit15, 8194);
    member = new ModuleMethod(locallists, 72, Lit16, 12290);
    assq = new ModuleMethod(locallists, 74, Lit17, 8194);
    assv = new ModuleMethod(locallists, 75, Lit18, 8194);
    assoc = new ModuleMethod(locallists, 76, Lit19, 12290);
    $instance.run();
  }
  
  public lists()
  {
    ModuleInfo.register(this);
  }
  
  public static Object assoc(Object paramObject1, Object paramObject2)
  {
    return assoc(paramObject1, paramObject2, Scheme.isEqual);
  }
  
  public static Object assoc(Object paramObject1, Object paramObject2, Procedure paramProcedure)
  {
    for (;;)
    {
      Object localObject2;
      if (paramObject2 == LList.Empty)
      {
        localObject2 = Boolean.FALSE;
        label12:
        return localObject2;
      }
      Object localObject1 = car.apply1(paramObject2);
      try
      {
        localObject2 = (Pair)localObject1;
        if (paramProcedure.apply2(((Pair)localObject2).getCar(), paramObject1) != Boolean.FALSE) {
          break label12;
        }
        paramObject2 = cdr.apply1(paramObject2);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "pair", -2, localObject1);
      }
    }
  }
  
  public static Object assq(Object paramObject1, Object paramObject2)
  {
    for (;;)
    {
      Object localObject2;
      if (paramObject2 == LList.Empty)
      {
        localObject2 = Boolean.FALSE;
        label12:
        return localObject2;
      }
      Object localObject1 = car.apply1(paramObject2);
      try
      {
        localObject2 = (Pair)localObject1;
        if (((Pair)localObject2).getCar() == paramObject1) {
          break label12;
        }
        paramObject2 = cdr.apply1(paramObject2);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "pair", -2, localObject1);
      }
    }
  }
  
  public static Object assv(Object paramObject1, Object paramObject2)
  {
    for (;;)
    {
      Object localObject2;
      if (paramObject2 == LList.Empty)
      {
        localObject2 = Boolean.FALSE;
        label12:
        return localObject2;
      }
      Object localObject1 = car.apply1(paramObject2);
      try
      {
        localObject2 = (Pair)localObject1;
        if (Scheme.isEqv.apply2(((Pair)localObject2).getCar(), paramObject1) != Boolean.FALSE) {
          break label12;
        }
        paramObject2 = cdr.apply1(paramObject2);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "pair", -2, localObject1);
      }
    }
  }
  
  static Object caaaar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCar()).getCar()).getCar();
  }
  
  static Object caaadr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCar()).getCar()).getCar();
  }
  
  static Object caaar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCar()).getCar()).getCar();
  }
  
  static Object caadar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCdr()).getCar()).getCar();
  }
  
  static Object caaddr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCdr()).getCar()).getCar();
  }
  
  static Object caadr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCdr()).getCar()).getCar();
  }
  
  static Object caar(Object paramObject)
  {
    return ((Pair)((Pair)paramObject).getCar()).getCar();
  }
  
  static Object cadaar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCar()).getCdr()).getCar();
  }
  
  static Object cadadr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCar()).getCdr()).getCar();
  }
  
  static Object cadar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCar()).getCdr()).getCar();
  }
  
  static Object caddar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCdr()).getCdr()).getCar();
  }
  
  static Object cadddr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCdr()).getCdr()).getCar();
  }
  
  static Object caddr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCdr()).getCdr()).getCar();
  }
  
  static Object cadr(Object paramObject)
  {
    return ((Pair)((Pair)paramObject).getCdr()).getCar();
  }
  
  static Object car(Pair paramPair)
  {
    return paramPair.getCar();
  }
  
  static Object cdaaar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCar()).getCar()).getCdr();
  }
  
  static Object cdaadr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCar()).getCar()).getCdr();
  }
  
  static Object cdaar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCar()).getCar()).getCdr();
  }
  
  static Object cdadar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCdr()).getCar()).getCdr();
  }
  
  static Object cdaddr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCdr()).getCar()).getCdr();
  }
  
  static Object cdadr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCdr()).getCar()).getCdr();
  }
  
  static Object cdar(Object paramObject)
  {
    return ((Pair)((Pair)paramObject).getCar()).getCdr();
  }
  
  static Object cddaar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCar()).getCdr()).getCdr();
  }
  
  static Object cddadr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCar()).getCdr()).getCdr();
  }
  
  static Object cddar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCar()).getCdr()).getCdr();
  }
  
  static Object cdddar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCdr()).getCdr()).getCdr();
  }
  
  static Object cddddr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCdr()).getCdr()).getCdr();
  }
  
  static Object cdddr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCdr()).getCdr()).getCdr();
  }
  
  static Object cddr(Object paramObject)
  {
    return ((Pair)((Pair)paramObject).getCdr()).getCdr();
  }
  
  static Object cdr(Pair paramPair)
  {
    return paramPair.getCdr();
  }
  
  public static Pair cons(Object paramObject1, Object paramObject2)
  {
    return new Pair(paramObject1, paramObject2);
  }
  
  public static boolean isList(Object paramObject)
  {
    int i = LList.listLength(paramObject, false);
    boolean bool = false;
    if (i >= 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isNull(Object paramObject)
  {
    return paramObject == LList.Empty;
  }
  
  public static boolean isPair(Object paramObject)
  {
    return paramObject instanceof Pair;
  }
  
  static void lambda1(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)paramObject1).getCar(), Lit1, paramObject2);
  }
  
  static void lambda10(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCdr()).getCar(), Lit2, paramObject2);
  }
  
  static void lambda11(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCar()).getCdr(), Lit2, paramObject2);
  }
  
  static void lambda12(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCdr()).getCdr(), Lit2, paramObject2);
  }
  
  static void lambda13(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCar()).getCar(), Lit1, paramObject2);
  }
  
  static void lambda14(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCar()).getCar(), Lit1, paramObject2);
  }
  
  static void lambda15(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCdr()).getCar(), Lit1, paramObject2);
  }
  
  static void lambda16(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCdr()).getCar(), Lit1, paramObject2);
  }
  
  static void lambda17(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCar()).getCdr(), Lit1, paramObject2);
  }
  
  static void lambda18(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCar()).getCdr(), Lit1, paramObject2);
  }
  
  static void lambda19(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCdr()).getCdr(), Lit1, paramObject2);
  }
  
  static void lambda2(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)paramObject1).getCdr(), Lit1, paramObject2);
  }
  
  static void lambda20(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCdr()).getCdr(), Lit1, paramObject2);
  }
  
  static void lambda21(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCar()).getCar(), Lit2, paramObject2);
  }
  
  static void lambda22(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCar()).getCar(), Lit2, paramObject2);
  }
  
  static void lambda23(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCdr()).getCar(), Lit2, paramObject2);
  }
  
  static void lambda24(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCdr()).getCar(), Lit2, paramObject2);
  }
  
  static void lambda25(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCar()).getCdr(), Lit2, paramObject2);
  }
  
  static void lambda26(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCar()).getCdr(), Lit2, paramObject2);
  }
  
  static void lambda27(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCdr()).getCdr(), Lit2, paramObject2);
  }
  
  static void lambda28(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCdr()).getCdr(), Lit2, paramObject2);
  }
  
  static void lambda3(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)paramObject1).getCar(), Lit2, paramObject2);
  }
  
  static void lambda4(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)paramObject1).getCdr(), Lit2, paramObject2);
  }
  
  static void lambda5(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCar()).getCar(), Lit1, paramObject2);
  }
  
  static void lambda6(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCdr()).getCar(), Lit1, paramObject2);
  }
  
  static void lambda7(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCar()).getCdr(), Lit1, paramObject2);
  }
  
  static void lambda8(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCdr()).getCdr(), Lit1, paramObject2);
  }
  
  static void lambda9(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCar()).getCar(), Lit2, paramObject2);
  }
  
  public static int length(LList paramLList)
  {
    return LList.length(paramLList);
  }
  
  public static Object listRef(Object paramObject, int paramInt)
  {
    return car.apply1(listTail(paramObject, paramInt));
  }
  
  public static Object listTail(Object paramObject, int paramInt)
  {
    return LList.listTail(paramObject, paramInt);
  }
  
  public static Object member(Object paramObject1, Object paramObject2)
  {
    return member(paramObject1, paramObject2, Scheme.isEqual);
  }
  
  public static Object member(Object paramObject1, Object paramObject2, Procedure paramProcedure)
  {
    localObject = paramObject2;
    for (;;)
    {
      boolean bool = localObject instanceof Pair;
      if (bool) {}
      try
      {
        Pair localPair = (Pair)localObject;
        if (paramProcedure.apply2(paramObject1, localPair.getCar()) != Boolean.FALSE) {
          return localObject;
        }
        localObject = localPair.getCdr();
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "p", -2, localObject);
      }
    }
    if (bool) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static Object memq(Object paramObject1, Object paramObject2)
  {
    localObject = paramObject2;
    for (;;)
    {
      boolean bool = localObject instanceof Pair;
      if (bool) {}
      try
      {
        Pair localPair = (Pair)localObject;
        if (paramObject1 == localPair.getCar()) {
          return localObject;
        }
        localObject = localPair.getCdr();
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "p", -2, localObject);
      }
    }
    if (bool) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static Object memv(Object paramObject1, Object paramObject2)
  {
    localObject = paramObject2;
    for (;;)
    {
      boolean bool = localObject instanceof Pair;
      if (bool) {}
      try
      {
        Pair localPair = (Pair)localObject;
        if (Scheme.isEqv.apply2(paramObject1, localPair.getCar()) != Boolean.FALSE) {
          return localObject;
        }
        localObject = localPair.getCdr();
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "p", -2, localObject);
      }
    }
    if (bool) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static LList reverse(LList paramLList)
  {
    Object localObject1 = LList.Empty;
    Object localObject2 = paramLList;
    for (;;)
    {
      if (isNull(localObject2)) {
        return (LList)localObject1;
      }
      try
      {
        Pair localPair = (Pair)localObject2;
        localObject2 = cdr.apply1(localPair);
        localObject1 = cons(car.apply1(localPair), localObject1);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "pair", -2, localObject2);
      }
    }
  }
  
  public static LList reverse$Ex(LList paramLList)
  {
    return LList.reverseInPlace(paramLList);
  }
  
  public static void setCar$Ex(Pair paramPair, Object paramObject)
  {
    paramPair.setCar(paramObject);
  }
  
  public static void setCdr$Ex(Pair paramPair, Object paramObject)
  {
    paramPair.setCdr(paramObject);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 2: 
    case 4: 
    case 5: 
    case 8: 
    case 10: 
    case 12: 
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
    case 48: 
    case 50: 
    case 52: 
    case 54: 
    case 56: 
    case 58: 
    case 60: 
    case 62: 
    case 66: 
    case 67: 
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 1: 
      if (isPair(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 3: 
      if (isNull(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    try
    {
      Pair localPair2 = (Pair)paramObject;
      return car(localPair2);
    }
    catch (ClassCastException localClassCastException5)
    {
      try
      {
        Pair localPair1;
        localLList1 = (LList)paramObject;
        return reverse$Ex(localLList1);
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "reverse!", 1, paramObject);
      }
      localClassCastException5 = localClassCastException5;
      throw new WrongType(localClassCastException5, "car", 1, paramObject);
    }
    try
    {
      localPair1 = (Pair)paramObject;
      return cdr(localPair1);
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "cdr", 1, paramObject);
    }
    return caar(paramObject);
    return cadr(paramObject);
    return cdar(paramObject);
    return cddr(paramObject);
    return caaar(paramObject);
    return caadr(paramObject);
    return cadar(paramObject);
    return caddr(paramObject);
    return cdaar(paramObject);
    return cdadr(paramObject);
    return cddar(paramObject);
    return cdddr(paramObject);
    return caaaar(paramObject);
    return caaadr(paramObject);
    return caadar(paramObject);
    return caaddr(paramObject);
    return cadaar(paramObject);
    return cadadr(paramObject);
    return caddar(paramObject);
    return cadddr(paramObject);
    return cdaaar(paramObject);
    return cdaadr(paramObject);
    return cdadar(paramObject);
    return cdaddr(paramObject);
    return cddaar(paramObject);
    return cddadr(paramObject);
    return cdddar(paramObject);
    return cddddr(paramObject);
    try
    {
      LList localLList3 = (LList)paramObject;
      return Integer.valueOf(length(localLList3));
    }
    catch (ClassCastException localClassCastException3)
    {
      LList localLList2;
      LList localLList1;
      throw new WrongType(localClassCastException3, "length", 1, paramObject);
    }
    try
    {
      localLList2 = (LList)paramObject;
      return reverse(localLList2);
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "reverse", 1, paramObject);
    }
    if (isList(paramObject)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    case 3: 
    case 6: 
    case 7: 
    case 9: 
    case 11: 
    case 13: 
    case 15: 
    case 17: 
    case 19: 
    case 21: 
    case 23: 
    case 25: 
    case 27: 
    case 29: 
    case 31: 
    case 33: 
    case 35: 
    case 37: 
    case 39: 
    case 41: 
    case 43: 
    case 45: 
    case 47: 
    case 49: 
    case 51: 
    case 53: 
    case 55: 
    case 57: 
    case 59: 
    case 61: 
    case 63: 
    case 64: 
    case 65: 
    case 68: 
    case 69: 
    case 73: 
    default: 
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    case 2: 
      return cons(paramObject1, paramObject2);
    }
    try
    {
      Pair localPair2 = (Pair)paramObject1;
      setCar$Ex(localPair2, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException4)
    {
      Pair localPair1;
      throw new WrongType(localClassCastException4, "set-car!", 1, paramObject1);
    }
    try
    {
      localPair1 = (Pair)paramObject1;
      setCdr$Ex(localPair1, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "set-cdr!", 1, paramObject1);
    }
    lambda1(paramObject1, paramObject2);
    return Values.empty;
    lambda2(paramObject1, paramObject2);
    return Values.empty;
    lambda3(paramObject1, paramObject2);
    return Values.empty;
    lambda4(paramObject1, paramObject2);
    return Values.empty;
    lambda5(paramObject1, paramObject2);
    return Values.empty;
    lambda6(paramObject1, paramObject2);
    return Values.empty;
    lambda7(paramObject1, paramObject2);
    return Values.empty;
    lambda8(paramObject1, paramObject2);
    return Values.empty;
    lambda9(paramObject1, paramObject2);
    return Values.empty;
    lambda10(paramObject1, paramObject2);
    return Values.empty;
    lambda11(paramObject1, paramObject2);
    return Values.empty;
    lambda12(paramObject1, paramObject2);
    return Values.empty;
    lambda13(paramObject1, paramObject2);
    return Values.empty;
    lambda14(paramObject1, paramObject2);
    return Values.empty;
    lambda15(paramObject1, paramObject2);
    return Values.empty;
    lambda16(paramObject1, paramObject2);
    return Values.empty;
    lambda17(paramObject1, paramObject2);
    return Values.empty;
    lambda18(paramObject1, paramObject2);
    return Values.empty;
    lambda19(paramObject1, paramObject2);
    return Values.empty;
    lambda20(paramObject1, paramObject2);
    return Values.empty;
    lambda21(paramObject1, paramObject2);
    return Values.empty;
    lambda22(paramObject1, paramObject2);
    return Values.empty;
    lambda23(paramObject1, paramObject2);
    return Values.empty;
    lambda24(paramObject1, paramObject2);
    return Values.empty;
    lambda25(paramObject1, paramObject2);
    return Values.empty;
    lambda26(paramObject1, paramObject2);
    return Values.empty;
    lambda27(paramObject1, paramObject2);
    return Values.empty;
    lambda28(paramObject1, paramObject2);
    return Values.empty;
    try
    {
      int j = ((Number)paramObject2).intValue();
      return listTail(paramObject1, j);
    }
    catch (ClassCastException localClassCastException2)
    {
      int i;
      throw new WrongType(localClassCastException2, "list-tail", 2, paramObject2);
    }
    try
    {
      i = ((Number)paramObject2).intValue();
      return listRef(paramObject1, i);
    }
    catch (ClassCastException localClassCastException1)
    {
      throw new WrongType(localClassCastException1, "list-ref", 2, paramObject2);
    }
    return memq(paramObject1, paramObject2);
    return memv(paramObject1, paramObject2);
    return member(paramObject1, paramObject2);
    return assq(paramObject1, paramObject2);
    return assv(paramObject1, paramObject2);
    return assoc(paramObject1, paramObject2);
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    try
    {
      Procedure localProcedure2 = (Procedure)paramObject3;
      return member(paramObject1, paramObject2, localProcedure2);
    }
    catch (ClassCastException localClassCastException2)
    {
      try
      {
        Procedure localProcedure1 = (Procedure)paramObject3;
        return assoc(paramObject1, paramObject2, localProcedure1);
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "assoc", 3, paramObject3);
      }
      localClassCastException2 = localClassCastException2;
      throw new WrongType(localClassCastException2, "member", 3, paramObject3);
    }
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 2: 
    case 4: 
    case 5: 
    case 8: 
    case 10: 
    case 12: 
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
    case 48: 
    case 50: 
    case 52: 
    case 54: 
    case 56: 
    case 58: 
    case 60: 
    case 62: 
    case 66: 
    case 67: 
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 69: 
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 68: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 65: 
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 64: 
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 63: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 61: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 59: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 57: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 55: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 53: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 51: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 49: 
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
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 43: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 41: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 39: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 37: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 35: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 33: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 31: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 29: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 27: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 25: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 23: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 21: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 19: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 17: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 15: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 13: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 11: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 9: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 7: 
      if (!(paramObject instanceof Pair)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 6: 
      if (!(paramObject instanceof Pair)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 3: 
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
    case 3: 
    case 6: 
    case 7: 
    case 9: 
    case 11: 
    case 13: 
    case 15: 
    case 17: 
    case 19: 
    case 21: 
    case 23: 
    case 25: 
    case 27: 
    case 29: 
    case 31: 
    case 33: 
    case 35: 
    case 37: 
    case 39: 
    case 41: 
    case 43: 
    case 45: 
    case 47: 
    case 49: 
    case 51: 
    case 53: 
    case 55: 
    case 57: 
    case 59: 
    case 61: 
    case 63: 
    case 64: 
    case 65: 
    case 68: 
    case 69: 
    case 73: 
    default: 
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 76: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 75: 
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
    case 72: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 71: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 70: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 67: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 66: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 62: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 60: 
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
    case 56: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 54: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 52: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 50: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 48: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 46: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 44: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 42: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 40: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 38: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 36: 
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
    case 32: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 30: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 28: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 26: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 24: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 22: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 20: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 18: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 16: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 14: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 12: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 10: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 8: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 5: 
      if (!(paramObject1 instanceof Pair)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 4: 
      if (!(paramObject1 instanceof Pair)) {
        return -786431;
      }
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
    int i = -786429;
    switch (paramModuleMethod.selector)
    {
    default: 
      i = super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
    do
    {
      do
      {
        return i;
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
      } while (!(paramObject3 instanceof Procedure));
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
    } while (!(paramObject3 instanceof Procedure));
    paramCallContext.value3 = paramObject3;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 3;
    return 0;
  }
  
  public final void run(CallContext paramCallContext)
  {
    car = new GenericProc("car");
    GenericProc localGenericProc1 = car;
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = Lit0;
    arrayOfObject1[1] = set$Mncar$Ex;
    arrayOfObject1[2] = car$Fn1;
    localGenericProc1.setProperties(arrayOfObject1);
    cdr = new GenericProc("cdr");
    GenericProc localGenericProc2 = cdr;
    Object[] arrayOfObject2 = new Object[3];
    arrayOfObject2[0] = Lit0;
    arrayOfObject2[1] = set$Mncdr$Ex;
    arrayOfObject2[2] = cdr$Fn2;
    localGenericProc2.setProperties(arrayOfObject2);
    caar = new GenericProc("caar");
    GenericProc localGenericProc3 = caar;
    Object[] arrayOfObject3 = new Object[3];
    arrayOfObject3[0] = Lit0;
    arrayOfObject3[1] = lambda$Fn3;
    arrayOfObject3[2] = caar$Fn4;
    localGenericProc3.setProperties(arrayOfObject3);
    cadr = new GenericProc("cadr");
    GenericProc localGenericProc4 = cadr;
    Object[] arrayOfObject4 = new Object[3];
    arrayOfObject4[0] = Lit0;
    arrayOfObject4[1] = lambda$Fn5;
    arrayOfObject4[2] = cadr$Fn6;
    localGenericProc4.setProperties(arrayOfObject4);
    cdar = new GenericProc("cdar");
    GenericProc localGenericProc5 = cdar;
    Object[] arrayOfObject5 = new Object[3];
    arrayOfObject5[0] = Lit0;
    arrayOfObject5[1] = lambda$Fn7;
    arrayOfObject5[2] = cdar$Fn8;
    localGenericProc5.setProperties(arrayOfObject5);
    cddr = new GenericProc("cddr");
    GenericProc localGenericProc6 = cddr;
    Object[] arrayOfObject6 = new Object[3];
    arrayOfObject6[0] = Lit0;
    arrayOfObject6[1] = lambda$Fn9;
    arrayOfObject6[2] = cddr$Fn10;
    localGenericProc6.setProperties(arrayOfObject6);
    caaar = new GenericProc("caaar");
    GenericProc localGenericProc7 = caaar;
    Object[] arrayOfObject7 = new Object[3];
    arrayOfObject7[0] = Lit0;
    arrayOfObject7[1] = lambda$Fn11;
    arrayOfObject7[2] = caaar$Fn12;
    localGenericProc7.setProperties(arrayOfObject7);
    caadr = new GenericProc("caadr");
    GenericProc localGenericProc8 = caadr;
    Object[] arrayOfObject8 = new Object[3];
    arrayOfObject8[0] = Lit0;
    arrayOfObject8[1] = lambda$Fn13;
    arrayOfObject8[2] = caadr$Fn14;
    localGenericProc8.setProperties(arrayOfObject8);
    cadar = new GenericProc("cadar");
    GenericProc localGenericProc9 = cadar;
    Object[] arrayOfObject9 = new Object[3];
    arrayOfObject9[0] = Lit0;
    arrayOfObject9[1] = lambda$Fn15;
    arrayOfObject9[2] = cadar$Fn16;
    localGenericProc9.setProperties(arrayOfObject9);
    caddr = new GenericProc("caddr");
    GenericProc localGenericProc10 = caddr;
    Object[] arrayOfObject10 = new Object[3];
    arrayOfObject10[0] = Lit0;
    arrayOfObject10[1] = lambda$Fn17;
    arrayOfObject10[2] = caddr$Fn18;
    localGenericProc10.setProperties(arrayOfObject10);
    cdaar = new GenericProc("cdaar");
    GenericProc localGenericProc11 = cdaar;
    Object[] arrayOfObject11 = new Object[3];
    arrayOfObject11[0] = Lit0;
    arrayOfObject11[1] = lambda$Fn19;
    arrayOfObject11[2] = cdaar$Fn20;
    localGenericProc11.setProperties(arrayOfObject11);
    cdadr = new GenericProc("cdadr");
    GenericProc localGenericProc12 = cdadr;
    Object[] arrayOfObject12 = new Object[3];
    arrayOfObject12[0] = Lit0;
    arrayOfObject12[1] = lambda$Fn21;
    arrayOfObject12[2] = cdadr$Fn22;
    localGenericProc12.setProperties(arrayOfObject12);
    cddar = new GenericProc("cddar");
    GenericProc localGenericProc13 = cddar;
    Object[] arrayOfObject13 = new Object[3];
    arrayOfObject13[0] = Lit0;
    arrayOfObject13[1] = lambda$Fn23;
    arrayOfObject13[2] = cddar$Fn24;
    localGenericProc13.setProperties(arrayOfObject13);
    cdddr = new GenericProc("cdddr");
    GenericProc localGenericProc14 = cdddr;
    Object[] arrayOfObject14 = new Object[3];
    arrayOfObject14[0] = Lit0;
    arrayOfObject14[1] = lambda$Fn25;
    arrayOfObject14[2] = cdddr$Fn26;
    localGenericProc14.setProperties(arrayOfObject14);
    caaaar = new GenericProc("caaaar");
    GenericProc localGenericProc15 = caaaar;
    Object[] arrayOfObject15 = new Object[3];
    arrayOfObject15[0] = Lit0;
    arrayOfObject15[1] = lambda$Fn27;
    arrayOfObject15[2] = caaaar$Fn28;
    localGenericProc15.setProperties(arrayOfObject15);
    caaadr = new GenericProc("caaadr");
    GenericProc localGenericProc16 = caaadr;
    Object[] arrayOfObject16 = new Object[3];
    arrayOfObject16[0] = Lit0;
    arrayOfObject16[1] = lambda$Fn29;
    arrayOfObject16[2] = caaadr$Fn30;
    localGenericProc16.setProperties(arrayOfObject16);
    caadar = new GenericProc("caadar");
    GenericProc localGenericProc17 = caadar;
    Object[] arrayOfObject17 = new Object[3];
    arrayOfObject17[0] = Lit0;
    arrayOfObject17[1] = lambda$Fn31;
    arrayOfObject17[2] = caadar$Fn32;
    localGenericProc17.setProperties(arrayOfObject17);
    caaddr = new GenericProc("caaddr");
    GenericProc localGenericProc18 = caaddr;
    Object[] arrayOfObject18 = new Object[3];
    arrayOfObject18[0] = Lit0;
    arrayOfObject18[1] = lambda$Fn33;
    arrayOfObject18[2] = caaddr$Fn34;
    localGenericProc18.setProperties(arrayOfObject18);
    cadaar = new GenericProc("cadaar");
    GenericProc localGenericProc19 = cadaar;
    Object[] arrayOfObject19 = new Object[3];
    arrayOfObject19[0] = Lit0;
    arrayOfObject19[1] = lambda$Fn35;
    arrayOfObject19[2] = cadaar$Fn36;
    localGenericProc19.setProperties(arrayOfObject19);
    cadadr = new GenericProc("cadadr");
    GenericProc localGenericProc20 = cadadr;
    Object[] arrayOfObject20 = new Object[3];
    arrayOfObject20[0] = Lit0;
    arrayOfObject20[1] = lambda$Fn37;
    arrayOfObject20[2] = cadadr$Fn38;
    localGenericProc20.setProperties(arrayOfObject20);
    caddar = new GenericProc("caddar");
    GenericProc localGenericProc21 = caddar;
    Object[] arrayOfObject21 = new Object[3];
    arrayOfObject21[0] = Lit0;
    arrayOfObject21[1] = lambda$Fn39;
    arrayOfObject21[2] = caddar$Fn40;
    localGenericProc21.setProperties(arrayOfObject21);
    cadddr = new GenericProc("cadddr");
    GenericProc localGenericProc22 = cadddr;
    Object[] arrayOfObject22 = new Object[3];
    arrayOfObject22[0] = Lit0;
    arrayOfObject22[1] = lambda$Fn41;
    arrayOfObject22[2] = cadddr$Fn42;
    localGenericProc22.setProperties(arrayOfObject22);
    cdaaar = new GenericProc("cdaaar");
    GenericProc localGenericProc23 = cdaaar;
    Object[] arrayOfObject23 = new Object[3];
    arrayOfObject23[0] = Lit0;
    arrayOfObject23[1] = lambda$Fn43;
    arrayOfObject23[2] = cdaaar$Fn44;
    localGenericProc23.setProperties(arrayOfObject23);
    cdaadr = new GenericProc("cdaadr");
    GenericProc localGenericProc24 = cdaadr;
    Object[] arrayOfObject24 = new Object[3];
    arrayOfObject24[0] = Lit0;
    arrayOfObject24[1] = lambda$Fn45;
    arrayOfObject24[2] = cdaadr$Fn46;
    localGenericProc24.setProperties(arrayOfObject24);
    cdadar = new GenericProc("cdadar");
    GenericProc localGenericProc25 = cdadar;
    Object[] arrayOfObject25 = new Object[3];
    arrayOfObject25[0] = Lit0;
    arrayOfObject25[1] = lambda$Fn47;
    arrayOfObject25[2] = cdadar$Fn48;
    localGenericProc25.setProperties(arrayOfObject25);
    cdaddr = new GenericProc("cdaddr");
    GenericProc localGenericProc26 = cdaddr;
    Object[] arrayOfObject26 = new Object[3];
    arrayOfObject26[0] = Lit0;
    arrayOfObject26[1] = lambda$Fn49;
    arrayOfObject26[2] = cdaddr$Fn50;
    localGenericProc26.setProperties(arrayOfObject26);
    cddaar = new GenericProc("cddaar");
    GenericProc localGenericProc27 = cddaar;
    Object[] arrayOfObject27 = new Object[3];
    arrayOfObject27[0] = Lit0;
    arrayOfObject27[1] = lambda$Fn51;
    arrayOfObject27[2] = cddaar$Fn52;
    localGenericProc27.setProperties(arrayOfObject27);
    cddadr = new GenericProc("cddadr");
    GenericProc localGenericProc28 = cddadr;
    Object[] arrayOfObject28 = new Object[3];
    arrayOfObject28[0] = Lit0;
    arrayOfObject28[1] = lambda$Fn53;
    arrayOfObject28[2] = cddadr$Fn54;
    localGenericProc28.setProperties(arrayOfObject28);
    cdddar = new GenericProc("cdddar");
    GenericProc localGenericProc29 = cdddar;
    Object[] arrayOfObject29 = new Object[3];
    arrayOfObject29[0] = Lit0;
    arrayOfObject29[1] = lambda$Fn55;
    arrayOfObject29[2] = cdddar$Fn56;
    localGenericProc29.setProperties(arrayOfObject29);
    cddddr = new GenericProc("cddddr");
    GenericProc localGenericProc30 = cddddr;
    Object[] arrayOfObject30 = new Object[3];
    arrayOfObject30[0] = Lit0;
    arrayOfObject30[1] = lambda$Fn57;
    arrayOfObject30[2] = cddddr$Fn58;
    localGenericProc30.setProperties(arrayOfObject30);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.lists
 * JD-Core Version:    0.7.0.1
 */