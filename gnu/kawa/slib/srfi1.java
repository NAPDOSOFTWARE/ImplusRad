package gnu.kawa.slib;

import gnu.expr.GenericProc;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.Map;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.math.Numeric;
import kawa.lang.Continuation;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.standard.Scheme;
import kawa.standard.append;
import kawa.standard.call_with_values;

public class srfi1
  extends ModuleBody
{
  public static final Macro $Pcevery;
  public static final int $Pcprovide$Pclist$Mnlib = 123;
  public static final int $Pcprovide$Pcsrfi$Mn1 = 123;
  public static final srfi1 $instance;
  static final IntNum Lit0;
  static final IntNum Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit100;
  static final SimpleSymbol Lit101;
  static final SimpleSymbol Lit102;
  static final SimpleSymbol Lit103;
  static final SimpleSymbol Lit104 = (SimpleSymbol)new SimpleSymbol("cdr").readResolve();
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
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
  static final SimpleSymbol Lit71;
  static final SimpleSymbol Lit72;
  static final SimpleSymbol Lit73;
  static final SimpleSymbol Lit74;
  static final SimpleSymbol Lit75;
  static final SimpleSymbol Lit76;
  static final SimpleSymbol Lit77;
  static final SimpleSymbol Lit78;
  static final SimpleSymbol Lit79;
  static final SimpleSymbol Lit8;
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
  public static final ModuleMethod alist$Mncons;
  public static final ModuleMethod alist$Mncopy;
  public static final ModuleMethod alist$Mndelete;
  public static final ModuleMethod alist$Mndelete$Ex;
  public static final ModuleMethod any;
  public static final ModuleMethod append$Ex;
  public static final ModuleMethod append$Mnmap;
  public static final ModuleMethod append$Mnmap$Ex;
  public static final ModuleMethod append$Mnreverse;
  public static final ModuleMethod append$Mnreverse$Ex;
  public static final ModuleMethod jdField_break;
  public static final ModuleMethod break$Ex;
  public static final ModuleMethod car$Plcdr;
  public static final ModuleMethod circular$Mnlist;
  public static final ModuleMethod circular$Mnlist$Qu;
  public static final ModuleMethod concatenate;
  public static final ModuleMethod concatenate$Ex;
  public static final ModuleMethod cons$St;
  public static final ModuleMethod count;
  public static final ModuleMethod delete;
  public static final ModuleMethod delete$Ex;
  public static final ModuleMethod delete$Mnduplicates;
  public static final ModuleMethod delete$Mnduplicates$Ex;
  public static final ModuleMethod dotted$Mnlist$Qu;
  public static final ModuleMethod drop;
  public static final ModuleMethod drop$Mnright;
  public static final ModuleMethod drop$Mnright$Ex;
  public static final ModuleMethod drop$Mnwhile;
  public static final ModuleMethod eighth;
  public static final ModuleMethod every;
  public static final ModuleMethod fifth;
  public static final ModuleMethod filter;
  public static final ModuleMethod filter$Ex;
  public static final ModuleMethod filter$Mnmap;
  public static final ModuleMethod find;
  public static final ModuleMethod find$Mntail;
  public static GenericProc first;
  public static final ModuleMethod fold;
  public static final ModuleMethod fold$Mnright;
  public static GenericProc fourth;
  public static final ModuleMethod iota;
  static final ModuleMethod lambda$Fn64;
  static final ModuleMethod lambda$Fn78;
  public static final ModuleMethod last;
  public static final ModuleMethod last$Mnpair;
  public static final ModuleMethod length$Pl;
  public static final ModuleMethod list$Eq;
  public static final ModuleMethod list$Mncopy;
  public static final ModuleMethod list$Mnindex;
  public static final ModuleMethod list$Mntabulate;
  public static final ModuleMethod lset$Eq;
  public static final ModuleMethod lset$Ls$Eq;
  public static final ModuleMethod lset$Mnadjoin;
  public static final ModuleMethod lset$Mndiff$Plintersection;
  public static final ModuleMethod lset$Mndiff$Plintersection$Ex;
  public static final ModuleMethod lset$Mndifference;
  public static final ModuleMethod lset$Mndifference$Ex;
  public static final ModuleMethod lset$Mnintersection;
  public static final ModuleMethod lset$Mnintersection$Ex;
  public static final ModuleMethod lset$Mnunion;
  public static final ModuleMethod lset$Mnunion$Ex;
  public static final ModuleMethod lset$Mnxor;
  public static final ModuleMethod lset$Mnxor$Ex;
  public static final ModuleMethod make$Mnlist;
  public static final ModuleMethod map$Ex;
  public static Map map$Mnin$Mnorder;
  public static final ModuleMethod ninth;
  public static final ModuleMethod not$Mnpair$Qu;
  public static final ModuleMethod null$Mnlist$Qu;
  public static final ModuleMethod pair$Mnfold;
  public static final ModuleMethod pair$Mnfold$Mnright;
  public static final ModuleMethod pair$Mnfor$Mneach;
  public static final ModuleMethod partition;
  public static final ModuleMethod partition$Ex;
  public static final ModuleMethod proper$Mnlist$Qu;
  public static final ModuleMethod reduce;
  public static final ModuleMethod reduce$Mnright;
  public static final ModuleMethod remove;
  public static final ModuleMethod remove$Ex;
  public static GenericProc second;
  public static final ModuleMethod seventh;
  public static final ModuleMethod sixth;
  public static final ModuleMethod span;
  public static final ModuleMethod span$Ex;
  public static final ModuleMethod split$Mnat;
  public static final ModuleMethod split$Mnat$Ex;
  public static final ModuleMethod take;
  public static final ModuleMethod take$Ex;
  public static final ModuleMethod take$Mnright;
  public static final ModuleMethod take$Mnwhile;
  public static final ModuleMethod take$Mnwhile$Ex;
  public static final ModuleMethod tenth;
  public static GenericProc third;
  public static final ModuleMethod unfold;
  public static final ModuleMethod unfold$Mnright;
  public static final ModuleMethod unzip1;
  public static final ModuleMethod unzip2;
  public static final ModuleMethod unzip3;
  public static final ModuleMethod unzip4;
  public static final ModuleMethod unzip5;
  public static final ModuleMethod xcons;
  public static final ModuleMethod zip;
  
  static Object $PcCars$Pl(Object paramObject1, Object paramObject2)
  {
    frame56 localframe56 = new frame56();
    localframe56.last$Mnelt = paramObject2;
    return localframe56.lambda75recur(paramObject1);
  }
  
  static Object $PcCars$PlCdrs(Object paramObject)
  {
    Continuation localContinuation = new Continuation(CallContext.getInstance());
    try
    {
      frame57 localframe57 = new frame57();
      localframe57.abort = localContinuation;
      localObject = localframe57.lambda76recur(paramObject);
      localContinuation.invoked = true;
    }
    finally
    {
      Object localObject;
      return Continuation.handleException(localThrowable, localContinuation);
    }
  }
  
  static Object $PcCars$PlCdrs$Pl(Object paramObject1, Object paramObject2)
  {
    frame62 localframe62 = new frame62();
    localframe62.cars$Mnfinal = paramObject2;
    Continuation localContinuation = new Continuation(CallContext.getInstance());
    try
    {
      frame63 localframe63 = new frame63();
      localframe63.staticLink = localframe62;
      localframe63.abort = localContinuation;
      localObject = localframe63.lambda85recur(paramObject1);
      localContinuation.invoked = true;
    }
    finally
    {
      Object localObject;
      return Continuation.handleException(localThrowable, localContinuation);
    }
  }
  
  static Object $PcCars$PlCdrs$SlNoTest(Object paramObject)
  {
    new frame67();
    return frame67.lambda92recur(paramObject);
  }
  
  static Object $PcCars$PlCdrs$SlNoTest$SlPair(Object paramObject)
  {
    frame71 localframe71 = new frame71();
    localframe71.lists = paramObject;
    return call_with_values.callWithValues(localframe71.lambda$Fn77, lambda$Fn78);
  }
  
  static Object $PcCars$PlCdrs$SlPair(Object paramObject)
  {
    frame61 localframe61 = new frame61();
    localframe61.lists = paramObject;
    return call_with_values.callWithValues(localframe61.lambda$Fn63, lambda$Fn64);
  }
  
  static Object $PcCdrs(Object paramObject)
  {
    Continuation localContinuation = new Continuation(CallContext.getInstance());
    try
    {
      frame55 localframe55 = new frame55();
      localframe55.abort = localContinuation;
      localObject = localframe55.lambda74recur(paramObject);
      localContinuation.invoked = true;
    }
    finally
    {
      Object localObject;
      return Continuation.handleException(localThrowable, localContinuation);
    }
  }
  
  static Object $PcLset2$Ls$Eq(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame72 localframe72 = new frame72();
    localframe72.$Eq = paramObject1;
    localframe72.lis2 = paramObject3;
    return every$V(localframe72.lambda$Fn79, paramObject2, new Object[0]);
  }
  
  static
  {
    Lit103 = (SimpleSymbol)new SimpleSymbol("car").readResolve();
    Lit102 = (SimpleSymbol)new SimpleSymbol("lp").readResolve();
    Lit101 = (SimpleSymbol)new SimpleSymbol("head").readResolve();
    Lit100 = (SimpleSymbol)new SimpleSymbol("tail").readResolve();
    Lit99 = (SimpleSymbol)new SimpleSymbol("lset-diff+intersection!").readResolve();
    Lit98 = (SimpleSymbol)new SimpleSymbol("lset-diff+intersection").readResolve();
    Lit97 = (SimpleSymbol)new SimpleSymbol("lset-xor!").readResolve();
    Lit96 = (SimpleSymbol)new SimpleSymbol("lset-xor").readResolve();
    Lit95 = (SimpleSymbol)new SimpleSymbol("lset-difference!").readResolve();
    Lit94 = (SimpleSymbol)new SimpleSymbol("lset-difference").readResolve();
    Lit93 = (SimpleSymbol)new SimpleSymbol("lset-intersection!").readResolve();
    Lit92 = (SimpleSymbol)new SimpleSymbol("lset-intersection").readResolve();
    Lit91 = (SimpleSymbol)new SimpleSymbol("lset-union!").readResolve();
    Lit90 = (SimpleSymbol)new SimpleSymbol("lset-union").readResolve();
    Lit89 = (SimpleSymbol)new SimpleSymbol("lset-adjoin").readResolve();
    Lit88 = (SimpleSymbol)new SimpleSymbol("lset=").readResolve();
    Lit87 = (SimpleSymbol)new SimpleSymbol("lset<=").readResolve();
    Lit86 = (SimpleSymbol)new SimpleSymbol("list-index").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("%every").readResolve();
    Lit84 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject2 = new Object[10];
    arrayOfObject2[0] = ((SimpleSymbol)new SimpleSymbol("let").readResolve());
    arrayOfObject2[1] = Lit102;
    arrayOfObject2[2] = Lit101;
    arrayOfObject2[3] = Lit103;
    arrayOfObject2[4] = Lit100;
    arrayOfObject2[5] = Lit104;
    arrayOfObject2[6] = ((SimpleSymbol)new SimpleSymbol("and").readResolve());
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("null-list?").readResolve();
    Lit14 = localSimpleSymbol2;
    arrayOfObject2[7] = PairWithPosition.make(localSimpleSymbol2, PairWithPosition.make(Lit100, LList.Empty, "srfi1.scm", 5722136), "srfi1.scm", 5722124);
    arrayOfObject2[8] = PairWithPosition.make(Lit101, LList.Empty, "srfi1.scm", 5722148);
    arrayOfObject2[9] = PairWithPosition.make(PairWithPosition.make(Lit102, PairWithPosition.make(PairWithPosition.make(Lit103, PairWithPosition.make(Lit100, LList.Empty, "srfi1.scm", 5722163), "srfi1.scm", 5722158), PairWithPosition.make(PairWithPosition.make(Lit104, PairWithPosition.make(Lit100, LList.Empty, "srfi1.scm", 5722174), "srfi1.scm", 5722169), LList.Empty, "srfi1.scm", 5722169), "srfi1.scm", 5722158), "srfi1.scm", 5722154), LList.Empty, "srfi1.scm", 5722154);
    arrayOfSyntaxRule[0] = new SyntaxRule(localSyntaxPattern, "\001\001", "\021\030\004\021\030\f¡I\021\030\024\b\021\030\034\b\013\b\021\030$\b\021\030,\b\013\b\021\0304\021\030<!\t\003\030D\030L", arrayOfObject2, 0);
    Lit85 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule, 2);
    Lit83 = (SimpleSymbol)new SimpleSymbol("every").readResolve();
    Lit82 = (SimpleSymbol)new SimpleSymbol("any").readResolve();
    Lit81 = (SimpleSymbol)new SimpleSymbol("break!").readResolve();
    Lit80 = (SimpleSymbol)new SimpleSymbol("jdField_break").readResolve();
    Lit79 = (SimpleSymbol)new SimpleSymbol("span!").readResolve();
    Lit78 = (SimpleSymbol)new SimpleSymbol("span").readResolve();
    Lit77 = (SimpleSymbol)new SimpleSymbol("take-while!").readResolve();
    Lit76 = (SimpleSymbol)new SimpleSymbol("drop-while").readResolve();
    Lit75 = (SimpleSymbol)new SimpleSymbol("take-while").readResolve();
    Lit74 = (SimpleSymbol)new SimpleSymbol("find-tail").readResolve();
    Lit73 = (SimpleSymbol)new SimpleSymbol("find").readResolve();
    Lit72 = (SimpleSymbol)new SimpleSymbol("alist-delete!").readResolve();
    Lit71 = (SimpleSymbol)new SimpleSymbol("alist-delete").readResolve();
    Lit70 = (SimpleSymbol)new SimpleSymbol("alist-copy").readResolve();
    Lit69 = (SimpleSymbol)new SimpleSymbol("alist-cons").readResolve();
    Lit68 = (SimpleSymbol)new SimpleSymbol("delete-duplicates!").readResolve();
    Lit67 = (SimpleSymbol)new SimpleSymbol("delete-duplicates").readResolve();
    Lit66 = (SimpleSymbol)new SimpleSymbol("delete!").readResolve();
    Lit65 = (SimpleSymbol)new SimpleSymbol("delete").readResolve();
    Lit64 = (SimpleSymbol)new SimpleSymbol("remove!").readResolve();
    Lit63 = (SimpleSymbol)new SimpleSymbol("remove").readResolve();
    Lit62 = (SimpleSymbol)new SimpleSymbol("partition!").readResolve();
    Lit61 = (SimpleSymbol)new SimpleSymbol("partition").readResolve();
    Lit60 = (SimpleSymbol)new SimpleSymbol("filter!").readResolve();
    Lit59 = (SimpleSymbol)new SimpleSymbol("filter").readResolve();
    Lit58 = (SimpleSymbol)new SimpleSymbol("filter-map").readResolve();
    Lit57 = (SimpleSymbol)new SimpleSymbol("map!").readResolve();
    Lit56 = (SimpleSymbol)new SimpleSymbol("pair-for-each").readResolve();
    Lit55 = (SimpleSymbol)new SimpleSymbol("append-map!").readResolve();
    Lit54 = (SimpleSymbol)new SimpleSymbol("append-map").readResolve();
    Lit53 = (SimpleSymbol)new SimpleSymbol("reduce-right").readResolve();
    Lit52 = (SimpleSymbol)new SimpleSymbol("reduce").readResolve();
    Lit51 = (SimpleSymbol)new SimpleSymbol("pair-fold").readResolve();
    Lit50 = (SimpleSymbol)new SimpleSymbol("pair-fold-right").readResolve();
    Lit49 = (SimpleSymbol)new SimpleSymbol("fold-right").readResolve();
    Lit48 = (SimpleSymbol)new SimpleSymbol("fold").readResolve();
    Lit47 = (SimpleSymbol)new SimpleSymbol("unfold").readResolve();
    Lit46 = (SimpleSymbol)new SimpleSymbol("unfold-right").readResolve();
    Lit45 = (SimpleSymbol)new SimpleSymbol("count").readResolve();
    Lit44 = (SimpleSymbol)new SimpleSymbol("concatenate!").readResolve();
    Lit43 = (SimpleSymbol)new SimpleSymbol("concatenate").readResolve();
    Lit42 = (SimpleSymbol)new SimpleSymbol("append-reverse!").readResolve();
    Lit41 = (SimpleSymbol)new SimpleSymbol("append-reverse").readResolve();
    Lit40 = (SimpleSymbol)new SimpleSymbol("append!").readResolve();
    Lit39 = (SimpleSymbol)new SimpleSymbol("unzip5").readResolve();
    Lit38 = (SimpleSymbol)new SimpleSymbol("unzip4").readResolve();
    Lit37 = (SimpleSymbol)new SimpleSymbol("unzip3").readResolve();
    Lit36 = (SimpleSymbol)new SimpleSymbol("unzip2").readResolve();
    Lit35 = (SimpleSymbol)new SimpleSymbol("unzip1").readResolve();
    Lit34 = (SimpleSymbol)new SimpleSymbol("last-pair").readResolve();
    Lit33 = (SimpleSymbol)new SimpleSymbol("last").readResolve();
    Lit32 = (SimpleSymbol)new SimpleSymbol("split-at!").readResolve();
    Lit31 = (SimpleSymbol)new SimpleSymbol("split-at").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("drop-right!").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("drop-right").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("take-right").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("take!").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("drop").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("take").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("car+cdr").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("tenth").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("ninth").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("eighth").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("seventh").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("sixth").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("fifth").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("zip").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("length+").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("list=").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("not-pair?").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("circular-list?").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("dotted-list?").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("proper-list?").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("circular-list").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("iota").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("list-copy").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("cons*").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("list-tabulate").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("make-list").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("xcons").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("tmp").readResolve();
    Lit1 = IntNum.make(1);
    Lit0 = IntNum.make(0);
    $instance = new srfi1();
    $Pcprovide$Pcsrfi$Mn1 = 123;
    $Pcprovide$Pclist$Mnlib = 123;
    srfi1 localsrfi1 = $instance;
    xcons = new ModuleMethod(localsrfi1, 78, Lit3, 8194);
    make$Mnlist = new ModuleMethod(localsrfi1, 79, Lit4, -4095);
    list$Mntabulate = new ModuleMethod(localsrfi1, 80, Lit5, 8194);
    cons$St = new ModuleMethod(localsrfi1, 81, Lit6, -4096);
    list$Mncopy = new ModuleMethod(localsrfi1, 82, Lit7, 4097);
    iota = new ModuleMethod(localsrfi1, 83, Lit8, 12289);
    circular$Mnlist = new ModuleMethod(localsrfi1, 86, Lit9, -4095);
    proper$Mnlist$Qu = new ModuleMethod(localsrfi1, 87, Lit10, 4097);
    dotted$Mnlist$Qu = new ModuleMethod(localsrfi1, 88, Lit11, 4097);
    circular$Mnlist$Qu = new ModuleMethod(localsrfi1, 89, Lit12, 4097);
    not$Mnpair$Qu = new ModuleMethod(localsrfi1, 90, Lit13, 4097);
    null$Mnlist$Qu = new ModuleMethod(localsrfi1, 91, Lit14, 4097);
    list$Eq = new ModuleMethod(localsrfi1, 92, Lit15, -4095);
    length$Pl = new ModuleMethod(localsrfi1, 93, Lit16, 4097);
    zip = new ModuleMethod(localsrfi1, 94, Lit17, -4095);
    fifth = new ModuleMethod(localsrfi1, 95, Lit18, 4097);
    sixth = new ModuleMethod(localsrfi1, 96, Lit19, 4097);
    seventh = new ModuleMethod(localsrfi1, 97, Lit20, 4097);
    eighth = new ModuleMethod(localsrfi1, 98, Lit21, 4097);
    ninth = new ModuleMethod(localsrfi1, 99, Lit22, 4097);
    tenth = new ModuleMethod(localsrfi1, 100, Lit23, 4097);
    car$Plcdr = new ModuleMethod(localsrfi1, 101, Lit24, 4097);
    take = new ModuleMethod(localsrfi1, 102, Lit25, 8194);
    drop = new ModuleMethod(localsrfi1, 103, Lit26, 8194);
    take$Ex = new ModuleMethod(localsrfi1, 104, Lit27, 8194);
    take$Mnright = new ModuleMethod(localsrfi1, 105, Lit28, 8194);
    drop$Mnright = new ModuleMethod(localsrfi1, 106, Lit29, 8194);
    drop$Mnright$Ex = new ModuleMethod(localsrfi1, 107, Lit30, 8194);
    split$Mnat = new ModuleMethod(localsrfi1, 108, Lit31, 8194);
    split$Mnat$Ex = new ModuleMethod(localsrfi1, 109, Lit32, 8194);
    last = new ModuleMethod(localsrfi1, 110, Lit33, 4097);
    last$Mnpair = new ModuleMethod(localsrfi1, 111, Lit34, 4097);
    unzip1 = new ModuleMethod(localsrfi1, 112, Lit35, 4097);
    unzip2 = new ModuleMethod(localsrfi1, 113, Lit36, 4097);
    unzip3 = new ModuleMethod(localsrfi1, 114, Lit37, 4097);
    unzip4 = new ModuleMethod(localsrfi1, 115, Lit38, 4097);
    unzip5 = new ModuleMethod(localsrfi1, 116, Lit39, 4097);
    append$Ex = new ModuleMethod(localsrfi1, 117, Lit40, -4096);
    append$Mnreverse = new ModuleMethod(localsrfi1, 118, Lit41, 8194);
    append$Mnreverse$Ex = new ModuleMethod(localsrfi1, 119, Lit42, 8194);
    concatenate = new ModuleMethod(localsrfi1, 120, Lit43, 4097);
    concatenate$Ex = new ModuleMethod(localsrfi1, 121, Lit44, 4097);
    count = new ModuleMethod(localsrfi1, 122, Lit45, -4094);
    unfold$Mnright = new ModuleMethod(localsrfi1, 123, Lit46, 20484);
    unfold = new ModuleMethod(localsrfi1, 125, Lit47, -4092);
    fold = new ModuleMethod(localsrfi1, 126, Lit48, -4093);
    fold$Mnright = new ModuleMethod(localsrfi1, 127, Lit49, -4093);
    pair$Mnfold$Mnright = new ModuleMethod(localsrfi1, 128, Lit50, -4093);
    pair$Mnfold = new ModuleMethod(localsrfi1, 129, Lit51, -4093);
    reduce = new ModuleMethod(localsrfi1, 130, Lit52, 12291);
    reduce$Mnright = new ModuleMethod(localsrfi1, 131, Lit53, 12291);
    append$Mnmap = new ModuleMethod(localsrfi1, 132, Lit54, -4094);
    append$Mnmap$Ex = new ModuleMethod(localsrfi1, 133, Lit55, -4094);
    pair$Mnfor$Mneach = new ModuleMethod(localsrfi1, 134, Lit56, -4094);
    map$Ex = new ModuleMethod(localsrfi1, 135, Lit57, -4094);
    filter$Mnmap = new ModuleMethod(localsrfi1, 136, Lit58, -4094);
    filter = new ModuleMethod(localsrfi1, 137, Lit59, 8194);
    filter$Ex = new ModuleMethod(localsrfi1, 138, Lit60, 8194);
    partition = new ModuleMethod(localsrfi1, 139, Lit61, 8194);
    partition$Ex = new ModuleMethod(localsrfi1, 140, Lit62, 8194);
    remove = new ModuleMethod(localsrfi1, 141, Lit63, 8194);
    remove$Ex = new ModuleMethod(localsrfi1, 142, Lit64, 8194);
    delete = new ModuleMethod(localsrfi1, 143, Lit65, 12290);
    delete$Ex = new ModuleMethod(localsrfi1, 145, Lit66, 12290);
    delete$Mnduplicates = new ModuleMethod(localsrfi1, 147, Lit67, 8193);
    delete$Mnduplicates$Ex = new ModuleMethod(localsrfi1, 149, Lit68, 8193);
    alist$Mncons = new ModuleMethod(localsrfi1, 151, Lit69, 12291);
    alist$Mncopy = new ModuleMethod(localsrfi1, 152, Lit70, 4097);
    alist$Mndelete = new ModuleMethod(localsrfi1, 153, Lit71, 12290);
    alist$Mndelete$Ex = new ModuleMethod(localsrfi1, 155, Lit72, 12290);
    find = new ModuleMethod(localsrfi1, 157, Lit73, 8194);
    find$Mntail = new ModuleMethod(localsrfi1, 158, Lit74, 8194);
    take$Mnwhile = new ModuleMethod(localsrfi1, 159, Lit75, 8194);
    drop$Mnwhile = new ModuleMethod(localsrfi1, 160, Lit76, 8194);
    take$Mnwhile$Ex = new ModuleMethod(localsrfi1, 161, Lit77, 8194);
    span = new ModuleMethod(localsrfi1, 162, Lit78, 8194);
    span$Ex = new ModuleMethod(localsrfi1, 163, Lit79, 8194);
    jdField_break = new ModuleMethod(localsrfi1, 164, Lit80, 8194);
    break$Ex = new ModuleMethod(localsrfi1, 165, Lit81, 8194);
    any = new ModuleMethod(localsrfi1, 166, Lit82, -4094);
    every = new ModuleMethod(localsrfi1, 167, Lit83, -4094);
    $Pcevery = Macro.make(Lit84, Lit85, $instance);
    list$Mnindex = new ModuleMethod(localsrfi1, 168, Lit86, -4094);
    lset$Ls$Eq = new ModuleMethod(localsrfi1, 169, Lit87, -4095);
    lset$Eq = new ModuleMethod(localsrfi1, 170, Lit88, -4095);
    lset$Mnadjoin = new ModuleMethod(localsrfi1, 171, Lit89, -4094);
    lset$Mnunion = new ModuleMethod(localsrfi1, 172, Lit90, -4095);
    lset$Mnunion$Ex = new ModuleMethod(localsrfi1, 173, Lit91, -4095);
    lset$Mnintersection = new ModuleMethod(localsrfi1, 174, Lit92, -4094);
    lset$Mnintersection$Ex = new ModuleMethod(localsrfi1, 175, Lit93, -4094);
    lset$Mndifference = new ModuleMethod(localsrfi1, 176, Lit94, -4094);
    lset$Mndifference$Ex = new ModuleMethod(localsrfi1, 177, Lit95, -4094);
    lset$Mnxor = new ModuleMethod(localsrfi1, 178, Lit96, -4095);
    lset$Mnxor$Ex = new ModuleMethod(localsrfi1, 179, Lit97, -4095);
    lset$Mndiff$Plintersection = new ModuleMethod(localsrfi1, 180, Lit98, -4094);
    lset$Mndiff$Plintersection$Ex = new ModuleMethod(localsrfi1, 181, Lit99, -4094);
    lambda$Fn64 = new ModuleMethod(localsrfi1, 182, null, 8194);
    lambda$Fn78 = new ModuleMethod(localsrfi1, 183, null, 8194);
    $instance.run();
  }
  
  public srfi1()
  {
    ModuleInfo.register(this);
  }
  
  public static Pair alistCons(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return lists.cons(lists.cons(paramObject1, paramObject2), paramObject3);
  }
  
  public static LList alistCopy(Object paramObject)
  {
    Object localObject1 = LList.Empty;
    Object localObject2 = paramObject;
    for (;;)
    {
      if (localObject2 == LList.Empty) {
        return LList.reverseInPlace(localObject1);
      }
      try
      {
        Pair localPair = (Pair)localObject2;
        Object localObject3 = localPair.getCdr();
        Object localObject4 = localPair.getCar();
        localObject1 = Pair.make(lists.cons(lists.car.apply1(localObject4), lists.cdr.apply1(localObject4)), localObject1);
        localObject2 = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject2);
      }
    }
  }
  
  public static Object alistDelete(Object paramObject1, Object paramObject2)
  {
    return alistDelete(paramObject1, paramObject2, Scheme.isEqual);
  }
  
  public static Object alistDelete(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame21 localframe21 = new frame21();
    localframe21.key = paramObject1;
    localframe21.maybe$Mn$Eq = paramObject3;
    return filter(localframe21.lambda$Fn18, paramObject2);
  }
  
  public static Object alistDelete$Ex(Object paramObject1, Object paramObject2)
  {
    return alistDelete$Ex(paramObject1, paramObject2, Scheme.isEqual);
  }
  
  public static Object alistDelete$Ex(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame22 localframe22 = new frame22();
    localframe22.key = paramObject1;
    localframe22.maybe$Mn$Eq = paramObject3;
    return filter$Ex(localframe22.lambda$Fn19, paramObject2);
  }
  
  public static Object any$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame26 localframe26 = new frame26();
    localframe26.pred = paramProcedure;
    localframe26.lis1 = paramObject;
    localframe26.lists = LList.makeList(paramArrayOfObject, 0);
    Object localObject4;
    if (lists.isPair(localframe26.lists)) {
      localObject4 = call_with_values.callWithValues(localframe26.lambda$Fn22, localframe26.lambda$Fn23);
    }
    for (;;)
    {
      return localObject4;
      Object localObject1 = isNullList(localframe26.lis1);
      try
      {
        Boolean localBoolean = Boolean.FALSE;
        int i = 0;
        if (localObject1 != localBoolean) {
          i = 1;
        }
        int j = 0x1 & i + 1;
        if (j != 0)
        {
          Object localObject2 = lists.car.apply1(localframe26.lis1);
          for (Object localObject3 = lists.cdr.apply1(localframe26.lis1);; localObject3 = lists.cdr.apply1(localObject3))
          {
            if (isNullList(localObject3) != Boolean.FALSE) {
              return localframe26.pred.apply1(localObject2);
            }
            localObject4 = localframe26.pred.apply1(localObject2);
            if (localObject4 != Boolean.FALSE) {
              break;
            }
            localObject2 = lists.car.apply1(localObject3);
          }
        }
        if (j != 0) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "x", -2, localObject1);
      }
    }
  }
  
  public static Object append$Ex$V(Object[] paramArrayOfObject)
  {
    Object localObject1 = LList.makeList(paramArrayOfObject, 0);
    Object localObject2 = LList.Empty;
    Object localObject4;
    for (;;)
    {
      if (!lists.isPair(localObject1)) {
        return localObject2;
      }
      localObject3 = lists.car.apply1(localObject1);
      localObject4 = lists.cdr.apply1(localObject1);
      if (lists.isPair(localObject3)) {
        break;
      }
      localObject2 = localObject3;
      localObject1 = localObject4;
    }
    for (;;)
    {
      Object localObject5;
      Object localObject6;
      try
      {
        Pair localPair1 = (Pair)localObject3;
        localObject5 = lastPair(localPair1);
        if (lists.isPair(localObject4))
        {
          localObject6 = lists.car.apply1(localObject4);
          localObject4 = lists.cdr.apply1(localObject4);
        }
      }
      catch (ClassCastException localClassCastException1)
      {
        Pair localPair2;
        Pair localPair3;
        throw new WrongType(localClassCastException1, "last-pair", 0, localObject3);
      }
      try
      {
        localPair2 = (Pair)localObject5;
        lists.setCdr$Ex(localPair2, localObject6);
        if (!lists.isPair(localObject6)) {}
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "set-cdr!", 1, localObject5);
      }
      try
      {
        localPair3 = (Pair)localObject6;
        localObject5 = lastPair(localPair3);
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "last-pair", 0, localObject6);
      }
    }
    return localObject3;
  }
  
  public static Object appendMap$Ex$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList)) {
      return Scheme.apply.apply2(append$Ex, Scheme.apply.apply4(Scheme.map, paramObject1, paramObject2, localLList));
    }
    Apply localApply = Scheme.apply;
    ModuleMethod localModuleMethod = append$Ex;
    Object localObject1 = LList.Empty;
    Object localObject2 = paramObject2;
    for (;;)
    {
      if (localObject2 == LList.Empty) {
        return localApply.apply2(localModuleMethod, LList.reverseInPlace(localObject1));
      }
      try
      {
        Pair localPair = (Pair)localObject2;
        Object localObject3 = localPair.getCdr();
        localObject1 = Pair.make(Scheme.applyToArgs.apply2(paramObject1, localPair.getCar()), localObject1);
        localObject2 = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject2);
      }
    }
  }
  
  public static Object appendMap$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList)) {
      return Scheme.apply.apply2(append.append, Scheme.apply.apply4(Scheme.map, paramObject1, paramObject2, localLList));
    }
    Apply localApply = Scheme.apply;
    append localappend = append.append;
    Object localObject1 = LList.Empty;
    Object localObject2 = paramObject2;
    for (;;)
    {
      if (localObject2 == LList.Empty) {
        return localApply.apply2(localappend, LList.reverseInPlace(localObject1));
      }
      try
      {
        Pair localPair = (Pair)localObject2;
        Object localObject3 = localPair.getCdr();
        localObject1 = Pair.make(Scheme.applyToArgs.apply2(paramObject1, localPair.getCar()), localObject1);
        localObject2 = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject2);
      }
    }
  }
  
  public static Object appendReverse(Object paramObject1, Object paramObject2)
  {
    for (;;)
    {
      if (isNullList(paramObject1) != Boolean.FALSE) {
        return paramObject2;
      }
      Object localObject = lists.cdr.apply1(paramObject1);
      paramObject2 = lists.cons(lists.car.apply1(paramObject1), paramObject2);
      paramObject1 = localObject;
    }
  }
  
  public static Object appendReverse$Ex(Object paramObject1, Object paramObject2)
  {
    for (;;)
    {
      if (isNullList(paramObject1) != Boolean.FALSE) {
        return paramObject2;
      }
      Object localObject = lists.cdr.apply1(paramObject1);
      try
      {
        Pair localPair = (Pair)paramObject1;
        lists.setCdr$Ex(localPair, paramObject2);
        paramObject2 = paramObject1;
        paramObject1 = localObject;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-cdr!", 1, paramObject1);
      }
    }
  }
  
  public static Object jdField_break(Object paramObject1, Object paramObject2)
  {
    frame24 localframe24 = new frame24();
    localframe24.pred = paramObject1;
    return span(localframe24.lambda$Fn20, paramObject2);
  }
  
  public static Object break$Ex(Object paramObject1, Object paramObject2)
  {
    frame25 localframe25 = new frame25();
    localframe25.pred = paramObject1;
    return span$Ex(localframe25.lambda$Fn21, paramObject2);
  }
  
  public static Object car$PlCdr(Object paramObject)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = lists.car.apply1(paramObject);
    arrayOfObject[1] = lists.cdr.apply1(paramObject);
    return misc.values(arrayOfObject);
  }
  
  public static Pair circularList$V(Object paramObject, Object[] paramArrayOfObject)
  {
    Pair localPair1 = lists.cons(paramObject, LList.makeList(paramArrayOfObject, 0));
    Object localObject = lastPair(localPair1);
    try
    {
      Pair localPair2 = (Pair)localObject;
      lists.setCdr$Ex(localPair2, localPair1);
      return localPair1;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "set-cdr!", 1, localObject);
    }
  }
  
  public static Object concatenate(Object paramObject)
  {
    return reduceRight(append.append, LList.Empty, paramObject);
  }
  
  public static Object concatenate$Ex(Object paramObject)
  {
    return reduceRight(append$Ex, LList.Empty, paramObject);
  }
  
  public static Object cons$St(Object... paramVarArgs)
  {
    return LList.consX(paramVarArgs);
  }
  
  public static Object count$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    Object localObject1 = LList.makeList(paramArrayOfObject, 0);
    Object localObject2;
    if (lists.isPair(localObject1))
    {
      localObject2 = Lit0;
      if (isNullList(paramObject) == Boolean.FALSE) {}
    }
    for (;;)
    {
      return localObject2;
      Object localObject5 = $PcCars$PlCdrs$SlPair(localObject1);
      Object localObject6 = lists.car.apply1(localObject5);
      Object localObject7 = lists.cdr.apply1(localObject5);
      if (!lists.isNull(localObject6))
      {
        Object localObject8 = lists.cdr.apply1(paramObject);
        if (Scheme.apply.apply3(paramProcedure, lists.car.apply1(paramObject), localObject6) != Boolean.FALSE) {
          localObject2 = AddOp.$Pl.apply2(localObject2, Lit1);
        }
        localObject1 = localObject7;
        paramObject = localObject8;
        break;
        localObject2 = Lit0;
        Object localObject4;
        for (Object localObject3 = paramObject; isNullList(localObject3) == Boolean.FALSE; localObject3 = localObject4)
        {
          localObject4 = lists.cdr.apply1(localObject3);
          if (paramProcedure.apply1(lists.car.apply1(localObject3)) != Boolean.FALSE) {
            localObject2 = AddOp.$Pl.apply2(localObject2, Lit1);
          }
        }
      }
    }
  }
  
  public static Object delete(Object paramObject1, Object paramObject2)
  {
    return delete(paramObject1, paramObject2, Scheme.isEqual);
  }
  
  public static Object delete(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame17 localframe17 = new frame17();
    localframe17.x = paramObject1;
    localframe17.maybe$Mn$Eq = paramObject3;
    return filter(localframe17.lambda$Fn16, paramObject2);
  }
  
  public static Object delete$Ex(Object paramObject1, Object paramObject2)
  {
    return delete$Ex(paramObject1, paramObject2, Scheme.isEqual);
  }
  
  public static Object delete$Ex(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame18 localframe18 = new frame18();
    localframe18.x = paramObject1;
    localframe18.maybe$Mn$Eq = paramObject3;
    return filter$Ex(localframe18.lambda$Fn17, paramObject2);
  }
  
  public static Object deleteDuplicates(Object paramObject)
  {
    return deleteDuplicates(paramObject, Scheme.isEqual);
  }
  
  public static Object deleteDuplicates(Object paramObject, Procedure paramProcedure)
  {
    frame19 localframe19 = new frame19();
    localframe19.maybe$Mn$Eq = paramProcedure;
    return localframe19.lambda30recur(paramObject);
  }
  
  public static Object deleteDuplicates$Ex(Object paramObject)
  {
    return deleteDuplicates$Ex(paramObject, Scheme.isEqual);
  }
  
  public static Object deleteDuplicates$Ex(Object paramObject, Procedure paramProcedure)
  {
    frame20 localframe20 = new frame20();
    localframe20.maybe$Mn$Eq = paramProcedure;
    return localframe20.lambda31recur(paramObject);
  }
  
  /* Error */
  public static Object drop(Object paramObject, IntNum paramIntNum)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 1271	java/lang/Number
    //   4: astore_3
    //   5: aload_3
    //   6: invokestatic 1277	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   9: ifeq +5 -> 14
    //   12: aload_0
    //   13: areturn
    //   14: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   17: aload_0
    //   18: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: astore_0
    //   22: getstatic 1280	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   25: aload_1
    //   26: getstatic 795	gnu/kawa/slib/srfi1:Lit1	Lgnu/math/IntNum;
    //   29: invokevirtual 1163	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: astore_1
    //   33: goto -33 -> 0
    //   36: astore_2
    //   37: new 1052	gnu/mapping/WrongType
    //   40: dup
    //   41: aload_2
    //   42: ldc_w 1282
    //   45: iconst_1
    //   46: aload_1
    //   47: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	paramObject	Object
    //   0	51	1	paramIntNum	IntNum
    //   36	6	2	localClassCastException	ClassCastException
    //   4	2	3	localNumber	Number
    // Exception table:
    //   from	to	target	type
    //   0	5	36	java/lang/ClassCastException
  }
  
  public static Object dropRight(Object paramObject, IntNum paramIntNum)
  {
    return lambda1recur(paramObject, drop(paramObject, paramIntNum));
  }
  
  public static Object dropRight$Ex(Object paramObject, IntNum paramIntNum)
  {
    Object localObject1 = drop(paramObject, paramIntNum);
    if (lists.isPair(localObject1))
    {
      Object localObject2 = lists.cdr.apply1(localObject1);
      localObject3 = paramObject;
      while (lists.isPair(localObject2))
      {
        localObject3 = lists.cdr.apply1(localObject3);
        localObject2 = lists.cdr.apply1(localObject2);
      }
    }
    try
    {
      Pair localPair = (Pair)localObject3;
      lists.setCdr$Ex(localPair, LList.Empty);
      return paramObject;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "set-cdr!", 1, localObject3);
    }
    return LList.Empty;
  }
  
  public static Object dropWhile(Procedure paramProcedure, Object paramObject)
  {
    for (;;)
    {
      if (isNullList(paramObject) != Boolean.FALSE) {
        paramObject = LList.Empty;
      }
      while (paramProcedure.apply1(lists.car.apply1(paramObject)) == Boolean.FALSE) {
        return paramObject;
      }
      paramObject = lists.cdr.apply1(paramObject);
    }
  }
  
  public static Object eighth(Object paramObject)
  {
    return lists.cadddr.apply1(lists.cddddr.apply1(paramObject));
  }
  
  public static Object every$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame27 localframe27 = new frame27();
    localframe27.pred = paramProcedure;
    localframe27.lis1 = paramObject;
    localframe27.lists = LList.makeList(paramArrayOfObject, 0);
    Object localObject1;
    if (lists.isPair(localframe27.lists)) {
      localObject1 = call_with_values.callWithValues(localframe27.lambda$Fn24, localframe27.lambda$Fn25);
    }
    do
    {
      return localObject1;
      localObject1 = isNullList(localframe27.lis1);
    } while (localObject1 != Boolean.FALSE);
    Object localObject2 = lists.car.apply1(localframe27.lis1);
    for (Object localObject3 = lists.cdr.apply1(localframe27.lis1);; localObject3 = lists.cdr.apply1(localObject3))
    {
      if (isNullList(localObject3) != Boolean.FALSE) {
        return localframe27.pred.apply1(localObject2);
      }
      localObject1 = localframe27.pred.apply1(localObject2);
      if (localObject1 == Boolean.FALSE) {
        break;
      }
      localObject2 = lists.car.apply1(localObject3);
    }
  }
  
  public static Object fifth(Object paramObject)
  {
    return lists.car.apply1(lists.cddddr.apply1(paramObject));
  }
  
  public static Object filter(Procedure paramProcedure, Object paramObject)
  {
    localObject1 = LList.Empty;
    for (;;)
    {
      if (isNullList(paramObject) != Boolean.FALSE) {}
      try
      {
        LList localLList = (LList)localObject1;
        return lists.reverse$Ex(localLList);
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject2;
        Object localObject3;
        throw new WrongType(localClassCastException, "reverse!", 1, localObject1);
      }
      localObject2 = lists.car.apply1(paramObject);
      localObject3 = lists.cdr.apply1(paramObject);
      if (paramProcedure.apply1(localObject2) != Boolean.FALSE)
      {
        localObject1 = lists.cons(localObject2, localObject1);
        paramObject = localObject3;
      }
      else
      {
        paramObject = localObject3;
      }
    }
  }
  
  public static Object filter$Ex(Procedure paramProcedure, Object paramObject)
  {
    localObject1 = paramObject;
    if (isNullList(localObject1) != Boolean.FALSE) {}
    Object localObject2;
    for (;;)
    {
      return localObject1;
      if (paramProcedure.apply1(lists.car.apply1(localObject1)) == Boolean.FALSE)
      {
        localObject1 = lists.cdr.apply1(localObject1);
        break;
      }
      localObject2 = lists.cdr.apply1(localObject1);
      localObject3 = localObject1;
      while (lists.isPair(localObject2))
      {
        if (paramProcedure.apply1(lists.car.apply1(localObject2)) == Boolean.FALSE) {
          break label95;
        }
        Object localObject6 = lists.cdr.apply1(localObject2);
        localObject3 = localObject2;
        localObject2 = localObject6;
      }
    }
    label95:
    for (localObject4 = lists.cdr.apply1(localObject2);; localObject4 = lists.cdr.apply1(localObject4)) {
      for (;;)
      {
        if ((!lists.isPair(localObject4)) || (paramProcedure.apply1(lists.car.apply1(localObject4)) != Boolean.FALSE)) {}
        try
        {
          Pair localPair2 = (Pair)localObject3;
          lists.setCdr$Ex(localPair2, localObject4);
          Object localObject5 = lists.cdr.apply1(localObject4);
          localObject3 = localObject4;
          localObject2 = localObject5;
        }
        catch (ClassCastException localClassCastException2)
        {
          try
          {
            Pair localPair1 = (Pair)localObject3;
            lists.setCdr$Ex(localPair1, localObject4);
            return localObject1;
          }
          catch (ClassCastException localClassCastException1)
          {
            throw new WrongType(localClassCastException1, "set-cdr!", 1, localObject3);
          }
          localClassCastException2 = localClassCastException2;
          throw new WrongType(localClassCastException2, "set-cdr!", 1, localObject3);
        }
      }
    }
  }
  
  public static Object filterMap$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame13 localframe13 = new frame13();
    localframe13.f = paramProcedure;
    LList localLList1 = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList1)) {
      return localframe13.lambda23recur(lists.cons(paramObject, localLList1), LList.Empty);
    }
    localObject1 = LList.Empty;
    Object localObject2 = paramObject;
    for (;;)
    {
      if (isNullList(localObject2) != Boolean.FALSE) {}
      try
      {
        LList localLList2 = (LList)localObject1;
        return lists.reverse$Ex(localLList2);
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject3;
        Object localObject4;
        throw new WrongType(localClassCastException, "reverse!", 1, localObject1);
      }
      localObject3 = localframe13.f.apply1(lists.car.apply1(localObject2));
      localObject4 = lists.cdr.apply1(localObject2);
      if (localObject3 != Boolean.FALSE)
      {
        localObject1 = lists.cons(localObject3, localObject1);
        localObject2 = localObject4;
      }
      else
      {
        localObject2 = localObject4;
      }
    }
  }
  
  public static Object find(Object paramObject1, Object paramObject2)
  {
    try
    {
      Procedure localProcedure = (Procedure)paramObject1;
      Object localObject = findTail(localProcedure, paramObject2);
      if (localObject != Boolean.FALSE) {
        return lists.car.apply1(localObject);
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "find-tail", 0, paramObject1);
    }
  }
  
  public static Object findTail(Procedure paramProcedure, Object paramObject)
  {
    for (;;)
    {
      Object localObject = isNullList(paramObject);
      try
      {
        Boolean localBoolean = Boolean.FALSE;
        if (localObject != localBoolean) {}
        int j;
        for (int i = 1;; i = 0)
        {
          j = 0x1 & i + 1;
          if (j == 0) {
            break label68;
          }
          if (paramProcedure.apply1(lists.car.apply1(paramObject)) == Boolean.FALSE) {
            break;
          }
          return paramObject;
        }
        paramObject = lists.cdr.apply1(paramObject);
        continue;
        label68:
        if (j != 0) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "x", -2, localObject);
      }
    }
  }
  
  public static Object fold$V(Procedure paramProcedure, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame7 localframe7 = new frame7();
    localframe7.kons = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList)) {
      paramObject1 = localframe7.lambda14lp(lists.cons(paramObject2, localLList), paramObject1);
    }
    for (;;)
    {
      return paramObject1;
      Object localObject2;
      for (Object localObject1 = paramObject2; isNullList(localObject1) == Boolean.FALSE; localObject1 = localObject2)
      {
        localObject2 = lists.cdr.apply1(localObject1);
        paramObject1 = localframe7.kons.apply2(lists.car.apply1(localObject1), paramObject1);
      }
    }
  }
  
  public static Object foldRight$V(Procedure paramProcedure, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame9 localframe9 = new frame9();
    localframe9.kons = paramProcedure;
    localframe9.knil = paramObject1;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList)) {
      return localframe9.lambda17recur(lists.cons(paramObject2, localLList));
    }
    return localframe9.lambda18recur(paramObject2);
  }
  
  public static Object iota(IntNum paramIntNum)
  {
    return iota(paramIntNum, Lit0, Lit1);
  }
  
  public static Object iota(IntNum paramIntNum, Numeric paramNumeric)
  {
    return iota(paramIntNum, paramNumeric, Lit1);
  }
  
  public static Object iota(IntNum paramIntNum, Numeric paramNumeric1, Numeric paramNumeric2)
  {
    if (IntNum.compare(paramIntNum, 0L) < 0)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = iota;
      arrayOfObject[1] = paramIntNum;
      misc.error$V("Negative step count", arrayOfObject);
    }
    Object localObject1 = AddOp.$Pl.apply2(paramNumeric1, MultiplyOp.$St.apply2(IntNum.add(paramIntNum, -1), paramNumeric2));
    try
    {
      Object localObject2 = (Numeric)localObject1;
      Object localObject3 = LList.Empty;
      while (Scheme.numLEq.apply2(paramIntNum, Lit0) == Boolean.FALSE)
      {
        paramIntNum = AddOp.$Mn.apply2(paramIntNum, Lit1);
        Object localObject4 = AddOp.$Mn.apply2(localObject2, paramNumeric2);
        localObject3 = lists.cons(localObject2, localObject3);
        localObject2 = localObject4;
      }
      return localObject3;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "last-val", -2, localObject1);
    }
  }
  
  public static Object isCircularList(Object paramObject)
  {
    Object localObject1 = paramObject;
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      bool1 = lists.isPair(paramObject);
      if (!bool1) {
        break label94;
      }
      Object localObject2 = lists.cdr.apply1(paramObject);
      bool2 = lists.isPair(localObject2);
      if (!bool2) {
        break;
      }
      paramObject = lists.cdr.apply1(localObject2);
      localObject1 = lists.cdr.apply1(localObject1);
      int i;
      if (paramObject == localObject1) {
        i = 1;
      }
      while (i != 0) {
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
    }
    if (bool2) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    label94:
    if (bool1) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static Object isDottedList(Object paramObject)
  {
    Object localObject1 = paramObject;
    if (lists.isPair(paramObject))
    {
      Object localObject2 = lists.cdr.apply1(paramObject);
      if (lists.isPair(localObject2))
      {
        paramObject = lists.cdr.apply1(localObject2);
        localObject1 = lists.cdr.apply1(localObject1);
        if (paramObject == localObject1) {}
        int j;
        for (int i = 1;; i = 0)
        {
          j = 0x1 & i + 1;
          if (j == 0) {
            break label67;
          }
          break;
        }
        label67:
        if (j != 0) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      if (lists.isNull(localObject2)) {
        return Boolean.FALSE;
      }
      return Boolean.TRUE;
    }
    if (lists.isNull(paramObject)) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public static boolean isNotPair(Object paramObject)
  {
    return 0x1 & true + lists.isPair(paramObject);
  }
  
  public static Object isNullList(Object paramObject)
  {
    if ((paramObject instanceof Pair)) {
      return Boolean.FALSE;
    }
    if (paramObject == LList.Empty) {
      return Boolean.TRUE;
    }
    return misc.error$V("null-list?: argument out of domain", new Object[] { paramObject });
  }
  
  public static Object isProperList(Object paramObject)
  {
    Object localObject1 = paramObject;
    if (lists.isPair(paramObject))
    {
      Object localObject2 = lists.cdr.apply1(paramObject);
      if (lists.isPair(localObject2))
      {
        paramObject = lists.cdr.apply1(localObject2);
        localObject1 = lists.cdr.apply1(localObject1);
        if (paramObject == localObject1) {}
        int j;
        for (int i = 1;; i = 0)
        {
          j = 0x1 & i + 1;
          if (j == 0) {
            break label67;
          }
          break;
        }
        label67:
        if (j != 0) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      if (lists.isNull(localObject2)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    if (lists.isNull(paramObject)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static Object lambda1recur(Object paramObject1, Object paramObject2)
  {
    if (lists.isPair(paramObject2)) {
      return lists.cons(lists.car.apply1(paramObject1), lambda1recur(lists.cdr.apply1(paramObject1), lists.cdr.apply1(paramObject2)));
    }
    return LList.Empty;
  }
  
  public static Object last(Object paramObject)
  {
    GenericProc localGenericProc = lists.car;
    try
    {
      Pair localPair = (Pair)paramObject;
      return localGenericProc.apply1(lastPair(localPair));
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "last-pair", 0, paramObject);
    }
  }
  
  public static Object lastPair(Pair paramPair)
  {
    for (;;)
    {
      Object localObject = lists.cdr.apply1(paramPair);
      if (!lists.isPair(localObject)) {
        break;
      }
      paramPair = localObject;
    }
    return paramPair;
  }
  
  public static Object length$Pl(Object paramObject)
  {
    Object localObject1 = Lit0;
    Object localObject2 = paramObject;
    if (lists.isPair(paramObject))
    {
      Object localObject3 = lists.cdr.apply1(paramObject);
      Object localObject4 = AddOp.$Pl.apply2(localObject1, Lit1);
      if (lists.isPair(localObject3))
      {
        paramObject = lists.cdr.apply1(localObject3);
        localObject2 = lists.cdr.apply1(localObject2);
        localObject1 = AddOp.$Pl.apply2(localObject4, Lit1);
        if (paramObject == localObject2) {}
        int j;
        for (int i = 1;; i = 0)
        {
          j = 0x1 & i + 1;
          if (j == 0) {
            break label98;
          }
          break;
        }
        label98:
        if (j != 0) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return localObject4;
    }
    return localObject1;
  }
  
  public static Object list$Eq$V(Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    boolean bool1 = lists.isNull(localLList);
    if (bool1)
    {
      if (bool1) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    Object localObject1 = lists.car.apply1(localLList);
    Object localObject2 = lists.cdr.apply1(localLList);
    Object localObject3;
    for (;;)
    {
      boolean bool2 = lists.isNull(localObject2);
      if (bool2)
      {
        if (bool2) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      localObject3 = lists.car.apply1(localObject2);
      localObject2 = lists.cdr.apply1(localObject2);
      if (localObject1 != localObject3) {
        break;
      }
      localObject1 = localObject3;
    }
    Object localObject4 = localObject3;
    for (;;)
    {
      if (isNullList(localObject1) != Boolean.FALSE)
      {
        Object localObject7 = isNullList(localObject4);
        if (localObject7 != Boolean.FALSE)
        {
          localObject1 = localObject4;
          break;
        }
        return localObject7;
      }
      Object localObject5 = isNullList(localObject4);
      try
      {
        Boolean localBoolean = Boolean.FALSE;
        if (localObject5 != localBoolean) {}
        int j;
        Object localObject6;
        for (int i = 1;; i = 0)
        {
          j = 0x1 & i + 1;
          if (j == 0) {
            break label244;
          }
          localObject6 = Scheme.applyToArgs.apply3(paramObject, lists.car.apply1(localObject1), lists.car.apply1(localObject4));
          if (localObject6 == Boolean.FALSE) {
            break label241;
          }
          localObject1 = lists.cdr.apply1(localObject1);
          localObject4 = lists.cdr.apply1(localObject4);
          break;
        }
        label241:
        return localObject6;
        label244:
        if (j != 0) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "x", -2, localObject5);
      }
    }
  }
  
  public static LList listCopy(LList paramLList)
  {
    Object localObject1 = LList.Empty;
    Object localObject2 = LList.Empty;
    if (lists.isPair(paramLList))
    {
      Pair localPair1 = lists.cons(lists.car.apply1(paramLList), LList.Empty);
      if (localObject2 == LList.Empty) {
        localObject1 = localPair1;
      }
      for (;;)
      {
        localObject2 = localPair1;
        paramLList = (LList)lists.cdr.apply1(paramLList);
        break;
        try
        {
          Pair localPair2 = (Pair)localObject2;
          lists.setCdr$Ex(localPair2, localPair1);
        }
        catch (ClassCastException localClassCastException)
        {
          throw new WrongType(localClassCastException, "set-cdr!", 1, localObject2);
        }
      }
    }
    return localObject1;
  }
  
  public static Object listIndex$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame30 localframe30 = new frame30();
    localframe30.pred = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    Object localObject1;
    if (lists.isPair(localLList)) {
      localObject1 = localframe30.lambda44lp(lists.cons(paramObject, localLList), Lit0);
    }
    for (;;)
    {
      return localObject1;
      localObject1 = Lit0;
      Object localObject2 = paramObject;
      label54:
      Object localObject3 = isNullList(localObject2);
      try
      {
        Boolean localBoolean = Boolean.FALSE;
        if (localObject3 != localBoolean) {}
        int j;
        for (int i = 1;; i = 0)
        {
          j = 0x1 & i + 1;
          if (j == 0) {
            break label142;
          }
          if (localframe30.pred.apply1(lists.car.apply1(localObject2)) != Boolean.FALSE) {
            break;
          }
          localObject2 = lists.cdr.apply1(localObject2);
          localObject1 = AddOp.$Pl.apply2(localObject1, Lit1);
          break label54;
        }
        label142:
        if (j != 0) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "x", -2, localObject3);
      }
    }
  }
  
  public static Object listTabulate(Object paramObject, Procedure paramProcedure)
  {
    int i = 0x1 & true + numbers.isInteger(paramObject);
    if (i != 0) {
      if (i == 0) {}
    }
    Object localObject2;
    for (;;)
    {
      misc.error$V("list-tabulate arg#1 must be a non-negative integer", new Object[0]);
      do
      {
        Object localObject1 = AddOp.$Mn.apply2(paramObject, Lit1);
        localObject2 = LList.Empty;
        while (Scheme.numLss.apply2(localObject1, Lit0) == Boolean.FALSE)
        {
          Object localObject3 = AddOp.$Mn.apply2(localObject1, Lit1);
          localObject2 = lists.cons(paramProcedure.apply1(localObject1), localObject2);
          localObject1 = localObject3;
        }
      } while (Scheme.numLss.apply2(paramObject, Lit0) == Boolean.FALSE);
    }
    return localObject2;
  }
  
  public static Object lset$Eq$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    int i = 0x1 & true + lists.isPair(localLList);
    if (i != 0)
    {
      if (i != 0) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    Object localObject1 = lists.car.apply1(localLList);
    Object localObject2 = lists.cdr.apply1(localLList);
    int j = 0x1 & true + lists.isPair(localObject2);
    if (j != 0)
    {
      if (j != 0) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    Object localObject3 = lists.car.apply1(localObject2);
    localObject2 = lists.cdr.apply1(localObject2);
    int k;
    label108:
    Boolean localBoolean;
    label123:
    Object localObject4;
    if (localObject1 == localObject3)
    {
      k = 1;
      if (k == 0) {
        break label156;
      }
      if (k == 0) {
        break label148;
      }
      localBoolean = Boolean.TRUE;
      localObject4 = localBoolean;
    }
    for (;;)
    {
      if (localObject4 == Boolean.FALSE) {
        break label187;
      }
      localObject1 = localObject3;
      break;
      k = 0;
      break label108;
      label148:
      localBoolean = Boolean.FALSE;
      break label123;
      label156:
      localObject4 = $PcLset2$Ls$Eq(paramProcedure, localObject1, localObject3);
      if (localObject4 != Boolean.FALSE) {
        localObject4 = $PcLset2$Ls$Eq(paramProcedure, localObject3, localObject1);
      }
    }
    label187:
    return localObject4;
  }
  
  public static Object lset$Ls$Eq$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    int i = 0x1 & true + lists.isPair(localLList);
    if (i != 0)
    {
      if (i != 0) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    Object localObject1 = lists.car.apply1(localLList);
    Object localObject2 = lists.cdr.apply1(localLList);
    int j = 0x1 & true + lists.isPair(localObject2);
    if (j != 0)
    {
      if (j != 0) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    Object localObject3 = lists.car.apply1(localObject2);
    localObject2 = lists.cdr.apply1(localObject2);
    int k;
    label108:
    Boolean localBoolean;
    if (localObject3 == localObject1)
    {
      k = 1;
      if (k == 0) {
        break label156;
      }
      if (k == 0) {
        break label148;
      }
      localBoolean = Boolean.TRUE;
    }
    label123:
    for (Object localObject4 = localBoolean;; localObject4 = $PcLset2$Ls$Eq(paramProcedure, localObject1, localObject3))
    {
      if (localObject4 == Boolean.FALSE) {
        break label169;
      }
      localObject1 = localObject3;
      break;
      k = 0;
      break label108;
      localBoolean = Boolean.FALSE;
      break label123;
    }
    label148:
    label156:
    label169:
    return localObject4;
  }
  
  public static Object lsetAdjoin$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame32 localframe32 = new frame32();
    localframe32.$Eq = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    return fold$V(localframe32.lambda$Fn30, paramObject, localLList, new Object[0]);
  }
  
  public static Object lsetDiff$PlIntersection$Ex$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame53 localframe53 = new frame53();
    localframe53.$Eq = paramProcedure;
    localframe53.lists = LList.makeList(paramArrayOfObject, 0);
    if (every$V(null$Mnlist$Qu, localframe53.lists, new Object[0]) != Boolean.FALSE)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramObject;
      arrayOfObject2[1] = LList.Empty;
      return misc.values(arrayOfObject2);
    }
    if (lists.memq(paramObject, localframe53.lists) != Boolean.FALSE)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = LList.Empty;
      arrayOfObject1[1] = paramObject;
      return misc.values(arrayOfObject1);
    }
    return partition$Ex(localframe53.lambda$Fn55, paramObject);
  }
  
  public static Object lsetDiff$PlIntersection$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame51 localframe51 = new frame51();
    localframe51.$Eq = paramProcedure;
    localframe51.lists = LList.makeList(paramArrayOfObject, 0);
    if (every$V(null$Mnlist$Qu, localframe51.lists, new Object[0]) != Boolean.FALSE)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramObject;
      arrayOfObject2[1] = LList.Empty;
      return misc.values(arrayOfObject2);
    }
    if (lists.memq(paramObject, localframe51.lists) != Boolean.FALSE)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = LList.Empty;
      arrayOfObject1[1] = paramObject;
      return misc.values(arrayOfObject1);
    }
    return partition(localframe51.lambda$Fn53, paramObject);
  }
  
  public static Object lsetDifference$Ex$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame43 localframe43 = new frame43();
    localframe43.$Eq = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    localframe43.lists = filter(lists.pair$Qu, localLList);
    if (lists.isNull(localframe43.lists)) {
      return paramObject;
    }
    if (lists.memq(paramObject, localframe43.lists) != Boolean.FALSE) {
      return LList.Empty;
    }
    return filter$Ex(localframe43.lambda$Fn43, paramObject);
  }
  
  public static Object lsetDifference$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame41 localframe41 = new frame41();
    localframe41.$Eq = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    localframe41.lists = filter(lists.pair$Qu, localLList);
    if (lists.isNull(localframe41.lists)) {
      return paramObject;
    }
    if (lists.memq(paramObject, localframe41.lists) != Boolean.FALSE) {
      return LList.Empty;
    }
    return filter(localframe41.lambda$Fn41, paramObject);
  }
  
  public static Object lsetIntersection$Ex$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame39 localframe39 = new frame39();
    localframe39.$Eq = paramProcedure;
    localframe39.lists = delete(paramObject, LList.makeList(paramArrayOfObject, 0), Scheme.isEq);
    if (any$V(null$Mnlist$Qu, localframe39.lists, new Object[0]) != Boolean.FALSE) {
      paramObject = LList.Empty;
    }
    while (lists.isNull(localframe39.lists)) {
      return paramObject;
    }
    return filter$Ex(localframe39.lambda$Fn39, paramObject);
  }
  
  public static Object lsetIntersection$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame37 localframe37 = new frame37();
    localframe37.$Eq = paramProcedure;
    localframe37.lists = delete(paramObject, LList.makeList(paramArrayOfObject, 0), Scheme.isEq);
    if (any$V(null$Mnlist$Qu, localframe37.lists, new Object[0]) != Boolean.FALSE) {
      paramObject = LList.Empty;
    }
    while (lists.isNull(localframe37.lists)) {
      return paramObject;
    }
    return filter(localframe37.lambda$Fn37, paramObject);
  }
  
  public static Object lsetUnion$Ex$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    frame35 localframe35 = new frame35();
    localframe35.$Eq = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    return reduce(localframe35.lambda$Fn34, LList.Empty, localLList);
  }
  
  public static Object lsetUnion$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    frame33 localframe33 = new frame33();
    localframe33.$Eq = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    return reduce(localframe33.lambda$Fn31, LList.Empty, localLList);
  }
  
  public static Object lsetXor$Ex$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    frame48 localframe48 = new frame48();
    localframe48.$Eq = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    return reduce(localframe48.lambda$Fn49, LList.Empty, localLList);
  }
  
  public static Object lsetXor$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    frame45 localframe45 = new frame45();
    localframe45.$Eq = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    return reduce(localframe45.lambda$Fn45, LList.Empty, localLList);
  }
  
  public static Object makeList$V(Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    int i = 0x1 & true + numbers.isInteger(paramObject);
    label34:
    Object localObject1;
    if (i != 0)
    {
      if (i != 0) {
        misc.error$V("make-list arg#1 must be a non-negative integer", new Object[0]);
      }
      if (!lists.isNull(localLList)) {
        break label115;
      }
      localObject1 = Boolean.FALSE;
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = LList.Empty;
      Object localObject3 = paramObject;
      while (Scheme.numLEq.apply2(localObject3, Lit0) == Boolean.FALSE)
      {
        localObject3 = AddOp.$Mn.apply2(localObject3, Lit1);
        localObject2 = lists.cons(localObject1, localObject2);
      }
      if (Scheme.numLss.apply2(paramObject, Lit0) == Boolean.FALSE) {
        break label34;
      }
      break;
      label115:
      if (lists.isNull(lists.cdr.apply1(localLList)))
      {
        localObject1 = lists.car.apply1(localLList);
      }
      else
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = lists.cons(paramObject, localLList);
        localObject1 = misc.error$V("Too many arguments to MAKE-LIST", arrayOfObject);
      }
    }
    return localObject2;
  }
  
  public static Object map$Ex$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame12 localframe12 = new frame12();
    localframe12.f = paramProcedure;
    Object localObject1 = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localObject1)) {
      localObject2 = paramObject;
    }
    for (;;)
    {
      if (isNullList(localObject2) != Boolean.FALSE) {
        break label131;
      }
      Object localObject3 = $PcCars$PlCdrs$SlNoTest$SlPair(localObject1);
      Object localObject4 = lists.car.apply1(localObject3);
      Object localObject5 = lists.cdr.apply1(localObject3);
      try
      {
        Pair localPair = (Pair)localObject2;
        lists.setCar$Ex(localPair, Scheme.apply.apply3(localframe12.f, lists.car.apply1(localObject2), localObject4));
        localObject2 = lists.cdr.apply1(localObject2);
        localObject1 = localObject5;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-car!", 1, localObject2);
      }
    }
    pairForEach$V(localframe12.lambda$Fn11, paramObject, new Object[0]);
    label131:
    return paramObject;
  }
  
  public static Object ninth(Object paramObject)
  {
    return lists.car.apply1(lists.cddddr.apply1(lists.cddddr.apply1(paramObject)));
  }
  
  public static Object pairFold$V(Procedure paramProcedure, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    Object localObject4;
    Object localObject5;
    if (lists.isPair(localLList))
    {
      localObject4 = lists.cons(paramObject2, localLList);
      localObject5 = $PcCdrs(localObject4);
      if (!lists.isNull(localObject5)) {}
    }
    for (;;)
    {
      return paramObject1;
      Apply localApply = Scheme.apply;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localObject4;
      arrayOfObject[1] = LList.list1(paramObject1);
      Object localObject6 = localApply.apply2(paramProcedure, append$Ex$V(arrayOfObject));
      localObject4 = localObject5;
      paramObject1 = localObject6;
      break;
      Object localObject1 = paramObject2;
      while (isNullList(localObject1) == Boolean.FALSE)
      {
        Object localObject2 = lists.cdr.apply1(localObject1);
        Object localObject3 = paramProcedure.apply2(localObject1, paramObject1);
        localObject1 = localObject2;
        paramObject1 = localObject3;
      }
    }
  }
  
  public static Object pairFoldRight$V(Procedure paramProcedure, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame10 localframe10 = new frame10();
    localframe10.f = paramProcedure;
    localframe10.zero = paramObject1;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList)) {
      return localframe10.lambda19recur(lists.cons(paramObject2, localLList));
    }
    return localframe10.lambda20recur(paramObject2);
  }
  
  public static Object pairForEach$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList))
    {
      Object localObject4;
      for (Object localObject3 = lists.cons(paramObject, localLList);; localObject3 = localObject4)
      {
        localObject4 = $PcCdrs(localObject3);
        if (!lists.isPair(localObject4)) {
          break;
        }
        Scheme.apply.apply2(paramProcedure, localObject3);
      }
      return Values.empty;
    }
    Object localObject2;
    for (Object localObject1 = paramObject; isNullList(localObject1) == Boolean.FALSE; localObject1 = localObject2)
    {
      localObject2 = lists.cdr.apply1(localObject1);
      paramProcedure.apply1(localObject1);
    }
    return Values.empty;
  }
  
  public static Object partition(Procedure paramProcedure, Object paramObject)
  {
    localObject1 = LList.Empty;
    localObject2 = LList.Empty;
    for (;;)
    {
      Object[] arrayOfObject;
      if (isNullList(paramObject) != Boolean.FALSE) {
        arrayOfObject = new Object[2];
      }
      try
      {
        LList localLList1 = (LList)localObject1;
        arrayOfObject[0] = lists.reverse$Ex(localLList1);
      }
      catch (ClassCastException localClassCastException1)
      {
        LList localLList2;
        Object localObject3;
        Object localObject4;
        throw new WrongType(localClassCastException1, "reverse!", 1, localObject1);
      }
      try
      {
        localLList2 = (LList)localObject2;
        arrayOfObject[1] = lists.reverse$Ex(localLList2);
        return misc.values(arrayOfObject);
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "reverse!", 1, localObject2);
      }
      localObject3 = lists.car.apply1(paramObject);
      localObject4 = lists.cdr.apply1(paramObject);
      if (paramProcedure.apply1(localObject3) != Boolean.FALSE)
      {
        localObject1 = lists.cons(localObject3, localObject1);
        paramObject = localObject4;
      }
      else
      {
        localObject2 = lists.cons(localObject3, localObject2);
        paramObject = localObject4;
      }
    }
  }
  
  public static Object partition$Ex(Procedure paramProcedure, Object paramObject)
  {
    Pair localPair1 = lists.cons(Lit2, LList.Empty);
    Pair localPair2 = lists.cons(Lit2, LList.Empty);
    localObject1 = localPair1;
    localObject2 = localPair2;
    for (;;)
    {
      if (isNotPair(paramObject)) {}
      try
      {
        Pair localPair5 = (Pair)localObject1;
        lists.setCdr$Ex(localPair5, LList.Empty);
        try
        {
          Pair localPair6 = (Pair)localObject2;
          lists.setCdr$Ex(localPair6, LList.Empty);
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = lists.cdr.apply1(localPair1);
          arrayOfObject[1] = lists.cdr.apply1(localPair2);
          return misc.values(arrayOfObject);
        }
        catch (ClassCastException localClassCastException4)
        {
          Pair localPair4;
          Object localObject4;
          Pair localPair3;
          Object localObject3;
          throw new WrongType(localClassCastException4, "set-cdr!", 1, localObject2);
        }
        if (paramProcedure.apply1(lists.car.apply1(paramObject)) == Boolean.FALSE) {}
      }
      catch (ClassCastException localClassCastException3)
      {
        try
        {
          localPair4 = (Pair)localObject1;
          lists.setCdr$Ex(localPair4, paramObject);
          localObject4 = lists.cdr.apply1(paramObject);
          localObject1 = paramObject;
          paramObject = localObject4;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "set-cdr!", 1, localObject1);
        }
        try
        {
          localPair3 = (Pair)localObject2;
          lists.setCdr$Ex(localPair3, paramObject);
          localObject3 = lists.cdr.apply1(paramObject);
          localObject2 = paramObject;
          paramObject = localObject3;
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "set-cdr!", 1, localObject2);
        }
        localClassCastException3 = localClassCastException3;
        throw new WrongType(localClassCastException3, "set-cdr!", 1, localObject1);
      }
    }
  }
  
  public static Object reduce(Procedure paramProcedure, Object paramObject1, Object paramObject2)
  {
    if (isNullList(paramObject2) != Boolean.FALSE) {
      return paramObject1;
    }
    return fold$V(paramProcedure, lists.car.apply1(paramObject2), lists.cdr.apply1(paramObject2), new Object[0]);
  }
  
  public static Object reduceRight(Procedure paramProcedure, Object paramObject1, Object paramObject2)
  {
    frame11 localframe11 = new frame11();
    localframe11.f = paramProcedure;
    if (isNullList(paramObject2) != Boolean.FALSE) {
      return paramObject1;
    }
    return localframe11.lambda21recur(lists.car.apply1(paramObject2), lists.cdr.apply1(paramObject2));
  }
  
  public static Object remove(Object paramObject1, Object paramObject2)
  {
    frame15 localframe15 = new frame15();
    localframe15.pred = paramObject1;
    return filter(localframe15.lambda$Fn14, paramObject2);
  }
  
  public static Object remove$Ex(Object paramObject1, Object paramObject2)
  {
    frame16 localframe16 = new frame16();
    localframe16.pred = paramObject1;
    return filter$Ex(localframe16.lambda$Fn15, paramObject2);
  }
  
  public static Object seventh(Object paramObject)
  {
    return lists.caddr.apply1(lists.cddddr.apply1(paramObject));
  }
  
  public static Object sixth(Object paramObject)
  {
    return lists.cadr.apply1(lists.cddddr.apply1(paramObject));
  }
  
  public static Object span(Procedure paramProcedure, Object paramObject)
  {
    for (localObject1 = LList.Empty;; localObject1 = lists.cons(localObject2, localObject1))
    {
      Object[] arrayOfObject2;
      if (isNullList(paramObject) != Boolean.FALSE) {
        arrayOfObject2 = new Object[2];
      }
      try
      {
        LList localLList2 = (LList)localObject1;
        arrayOfObject2[0] = lists.reverse$Ex(localLList2);
        arrayOfObject2[1] = paramObject;
        return misc.values(arrayOfObject2);
      }
      catch (ClassCastException localClassCastException2)
      {
        try
        {
          Object localObject2;
          Object[] arrayOfObject1;
          LList localLList1 = (LList)localObject1;
          arrayOfObject1[0] = lists.reverse$Ex(localLList1);
          arrayOfObject1[1] = paramObject;
          return misc.values(arrayOfObject1);
        }
        catch (ClassCastException localClassCastException1)
        {
          throw new WrongType(localClassCastException1, "reverse!", 1, localObject1);
        }
        localClassCastException2 = localClassCastException2;
        throw new WrongType(localClassCastException2, "reverse!", 1, localObject1);
      }
      localObject2 = lists.car.apply1(paramObject);
      if (paramProcedure.apply1(localObject2) == Boolean.FALSE) {
        break;
      }
      paramObject = lists.cdr.apply1(paramObject);
    }
    arrayOfObject1 = new Object[2];
  }
  
  public static Object span$Ex(Procedure paramProcedure, Object paramObject)
  {
    Object localObject1 = isNullList(paramObject);
    if (localObject1 != Boolean.FALSE)
    {
      if (localObject1 == Boolean.FALSE) {}
    }
    else {
      while (paramProcedure.apply1(lists.car.apply1(paramObject)) == Boolean.FALSE)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = LList.Empty;
        arrayOfObject[1] = paramObject;
        return misc.values(arrayOfObject);
      }
    }
    Object localObject2 = lists.cdr.apply1(paramObject);
    Object localObject3 = paramObject;
    Object localObject4;
    if (isNullList(localObject2) != Boolean.FALSE) {
      localObject4 = localObject2;
    }
    for (;;)
    {
      return misc.values(new Object[] { paramObject, localObject4 });
      if (paramProcedure.apply1(lists.car.apply1(localObject2)) != Boolean.FALSE)
      {
        Object localObject5 = lists.cdr.apply1(localObject2);
        localObject3 = localObject2;
        localObject2 = localObject5;
        break;
      }
      try
      {
        Pair localPair = (Pair)localObject3;
        lists.setCdr$Ex(localPair, LList.Empty);
        localObject4 = localObject2;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-cdr!", 1, localObject3);
      }
    }
  }
  
  public static Object splitAt(Object paramObject, IntNum paramIntNum)
  {
    localObject1 = LList.Empty;
    for (;;)
    {
      try
      {
        Number localNumber = (Number)paramIntNum;
        if (numbers.isZero(localNumber)) {
          arrayOfObject = new Object[2];
        }
      }
      catch (ClassCastException localClassCastException1)
      {
        Object[] arrayOfObject;
        LList localLList;
        Object localObject2;
        throw new WrongType(localClassCastException1, "zero?", 1, paramIntNum);
      }
      try
      {
        localLList = (LList)localObject1;
        arrayOfObject[0] = lists.reverse$Ex(localLList);
        arrayOfObject[1] = paramObject;
        return misc.values(arrayOfObject);
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "reverse!", 1, localObject1);
      }
      localObject1 = lists.cons(lists.car.apply1(paramObject), localObject1);
      localObject2 = lists.cdr.apply1(paramObject);
      paramIntNum = AddOp.$Mn.apply2(paramIntNum, Lit1);
      paramObject = localObject2;
    }
  }
  
  public static Object splitAt$Ex(Object paramObject, IntNum paramIntNum)
  {
    if (numbers.isZero(paramIntNum))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = LList.Empty;
      arrayOfObject[1] = paramObject;
      return misc.values(arrayOfObject);
    }
    Object localObject1 = drop(paramObject, IntNum.add(paramIntNum, -1));
    Object localObject2 = lists.cdr.apply1(localObject1);
    try
    {
      Pair localPair = (Pair)localObject1;
      lists.setCdr$Ex(localPair, LList.Empty);
      return misc.values(new Object[] { paramObject, localObject2 });
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "set-cdr!", 1, localObject1);
    }
  }
  
  public static Object take(Object paramObject, IntNum paramIntNum)
  {
    localObject1 = LList.Empty;
    for (;;)
    {
      try
      {
        Number localNumber = (Number)paramIntNum;
        if (!numbers.isZero(localNumber)) {}
      }
      catch (ClassCastException localClassCastException1)
      {
        LList localLList;
        Object localObject2;
        throw new WrongType(localClassCastException1, "zero?", 1, paramIntNum);
      }
      try
      {
        localLList = (LList)localObject1;
        return lists.reverse$Ex(localLList);
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "reverse!", 1, localObject1);
      }
      localObject2 = lists.cdr.apply1(paramObject);
      paramIntNum = AddOp.$Mn.apply2(paramIntNum, Lit1);
      localObject1 = lists.cons(lists.car.apply1(paramObject), localObject1);
      paramObject = localObject2;
    }
  }
  
  public static Object take$Ex(Object paramObject, IntNum paramIntNum)
  {
    if (numbers.isZero(paramIntNum)) {
      return LList.Empty;
    }
    Object localObject = drop(paramObject, IntNum.add(paramIntNum, -1));
    try
    {
      Pair localPair = (Pair)localObject;
      lists.setCdr$Ex(localPair, LList.Empty);
      return paramObject;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "set-cdr!", 1, localObject);
    }
  }
  
  public static Object takeRight(Object paramObject, IntNum paramIntNum)
  {
    Object localObject1 = drop(paramObject, paramIntNum);
    Object localObject2 = paramObject;
    while (lists.isPair(localObject1))
    {
      localObject2 = lists.cdr.apply1(localObject2);
      localObject1 = lists.cdr.apply1(localObject1);
    }
    return localObject2;
  }
  
  public static Object takeWhile(Procedure paramProcedure, Object paramObject)
  {
    frame23 localframe23 = new frame23();
    localframe23.pred = paramProcedure;
    return localframe23.lambda34recur(paramObject);
  }
  
  public static Object takeWhile$Ex(Procedure paramProcedure, Object paramObject)
  {
    Object localObject1 = isNullList(paramObject);
    if (localObject1 != Boolean.FALSE)
    {
      if (localObject1 == Boolean.FALSE) {
        break label42;
      }
      paramObject = LList.Empty;
    }
    label42:
    Object localObject3;
    for (;;)
    {
      return paramObject;
      if (paramProcedure.apply1(lists.car.apply1(paramObject)) == Boolean.FALSE) {
        break;
      }
      Object localObject2 = lists.cdr.apply1(paramObject);
      localObject3 = paramObject;
      while (lists.isPair(localObject2))
      {
        if (paramProcedure.apply1(lists.car.apply1(localObject2)) == Boolean.FALSE) {
          break label95;
        }
        Object localObject4 = lists.cdr.apply1(localObject2);
        localObject3 = localObject2;
        localObject2 = localObject4;
      }
    }
    try
    {
      label95:
      Pair localPair = (Pair)localObject3;
      lists.setCdr$Ex(localPair, LList.Empty);
      return paramObject;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "set-cdr!", 1, localObject3);
    }
  }
  
  public static Object tenth(Object paramObject)
  {
    return lists.cadr.apply1(lists.cddddr.apply1(lists.cddddr.apply1(paramObject)));
  }
  
  public static Object unfold$V(Procedure paramProcedure1, Procedure paramProcedure2, Procedure paramProcedure3, Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList1 = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList1))
    {
      Object localObject3 = lists.car.apply1(localLList1);
      if (lists.isPair(lists.cdr.apply1(localLList1)))
      {
        Apply localApply = Scheme.apply;
        Object[] arrayOfObject = new Object[8];
        arrayOfObject[0] = misc.error;
        arrayOfObject[1] = "Too many arguments";
        arrayOfObject[2] = unfold;
        arrayOfObject[3] = paramProcedure1;
        arrayOfObject[4] = paramProcedure2;
        arrayOfObject[5] = paramProcedure3;
        arrayOfObject[6] = paramObject;
        arrayOfObject[7] = localLList1;
        return localApply.applyN(arrayOfObject);
      }
      Object localObject4 = LList.Empty;
      for (;;)
      {
        if (paramProcedure1.apply1(paramObject) != Boolean.FALSE) {
          return appendReverse$Ex(localObject4, Scheme.applyToArgs.apply2(localObject3, paramObject));
        }
        Object localObject5 = paramProcedure3.apply1(paramObject);
        localObject4 = lists.cons(paramProcedure2.apply1(paramObject), localObject4);
        paramObject = localObject5;
      }
    }
    localObject1 = LList.Empty;
    for (;;)
    {
      if (paramProcedure1.apply1(paramObject) != Boolean.FALSE) {}
      try
      {
        LList localLList2 = (LList)localObject1;
        return lists.reverse$Ex(localLList2);
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject2;
        throw new WrongType(localClassCastException, "reverse!", 1, localObject1);
      }
      localObject2 = paramProcedure3.apply1(paramObject);
      localObject1 = lists.cons(paramProcedure2.apply1(paramObject), localObject1);
      paramObject = localObject2;
    }
  }
  
  public static Object unfoldRight(Procedure paramProcedure1, Procedure paramProcedure2, Procedure paramProcedure3, Object paramObject)
  {
    return unfoldRight(paramProcedure1, paramProcedure2, paramProcedure3, paramObject, LList.Empty);
  }
  
  public static Object unfoldRight(Procedure paramProcedure1, Procedure paramProcedure2, Procedure paramProcedure3, Object paramObject1, Object paramObject2)
  {
    for (;;)
    {
      if (paramProcedure1.apply1(paramObject1) != Boolean.FALSE) {
        return paramObject2;
      }
      Object localObject = paramProcedure3.apply1(paramObject1);
      paramObject2 = lists.cons(paramProcedure2.apply1(paramObject1), paramObject2);
      paramObject1 = localObject;
    }
  }
  
  public static LList unzip1(Object paramObject)
  {
    Object localObject1 = LList.Empty;
    Object localObject2 = paramObject;
    for (;;)
    {
      if (localObject2 == LList.Empty) {
        return LList.reverseInPlace(localObject1);
      }
      try
      {
        Pair localPair = (Pair)localObject2;
        Object localObject3 = localPair.getCdr();
        localObject1 = Pair.make(lists.car.apply1(localPair.getCar()), localObject1);
        localObject2 = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject2);
      }
    }
  }
  
  public static Object unzip2(Object paramObject)
  {
    new frame();
    return frame.lambda2recur(paramObject);
  }
  
  public static Object unzip3(Object paramObject)
  {
    new frame1();
    return frame1.lambda5recur(paramObject);
  }
  
  public static Object unzip4(Object paramObject)
  {
    new frame3();
    return frame3.lambda8recur(paramObject);
  }
  
  public static Object unzip5(Object paramObject)
  {
    new frame5();
    return frame5.lambda11recur(paramObject);
  }
  
  public static Pair xcons(Object paramObject1, Object paramObject2)
  {
    return lists.cons(paramObject2, paramObject1);
  }
  
  public static Object zip$V(Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    return Scheme.apply.apply4(Scheme.map, LangObjType.listType, paramObject, localLList);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    }
    try
    {
      LList localLList = (LList)paramObject;
      return listCopy(localLList);
    }
    catch (ClassCastException localClassCastException3)
    {
      IntNum localIntNum;
      throw new WrongType(localClassCastException3, "list-copy", 1, paramObject);
    }
    try
    {
      localIntNum = LangObjType.coerceIntNum(paramObject);
      return iota(localIntNum);
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "iota", 1, paramObject);
    }
    return isProperList(paramObject);
    return isDottedList(paramObject);
    return isCircularList(paramObject);
    if (isNotPair(paramObject)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    return isNullList(paramObject);
    return length$Pl(paramObject);
    return fifth(paramObject);
    return sixth(paramObject);
    return seventh(paramObject);
    return eighth(paramObject);
    return ninth(paramObject);
    return tenth(paramObject);
    return car$PlCdr(paramObject);
    return last(paramObject);
    try
    {
      Pair localPair = (Pair)paramObject;
      return lastPair(localPair);
    }
    catch (ClassCastException localClassCastException1)
    {
      throw new WrongType(localClassCastException1, "last-pair", 1, paramObject);
    }
    return unzip1(paramObject);
    return unzip2(paramObject);
    return unzip3(paramObject);
    return unzip4(paramObject);
    return unzip5(paramObject);
    return concatenate(paramObject);
    return concatenate$Ex(paramObject);
    return deleteDuplicates(paramObject);
    return deleteDuplicates$Ex(paramObject);
    return alistCopy(paramObject);
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    case 78: 
      return xcons(paramObject1, paramObject2);
    }
    try
    {
      Procedure localProcedure13 = (Procedure)paramObject2;
      return listTabulate(paramObject1, localProcedure13);
    }
    catch (ClassCastException localClassCastException23)
    {
      IntNum localIntNum9;
      Numeric localNumeric;
      IntNum localIntNum8;
      IntNum localIntNum7;
      IntNum localIntNum6;
      IntNum localIntNum5;
      IntNum localIntNum4;
      IntNum localIntNum3;
      IntNum localIntNum2;
      IntNum localIntNum1;
      throw new WrongType(localClassCastException23, "list-tabulate", 2, paramObject2);
    }
    try
    {
      localIntNum9 = LangObjType.coerceIntNum(paramObject1);
    }
    catch (ClassCastException localClassCastException21)
    {
      throw new WrongType(localClassCastException21, "iota", 1, paramObject1);
    }
    try
    {
      localNumeric = LangObjType.coerceNumeric(paramObject2);
      return iota(localIntNum9, localNumeric);
    }
    catch (ClassCastException localClassCastException22)
    {
      throw new WrongType(localClassCastException22, "iota", 2, paramObject2);
    }
    try
    {
      localIntNum8 = LangObjType.coerceIntNum(paramObject2);
      return take(paramObject1, localIntNum8);
    }
    catch (ClassCastException localClassCastException20)
    {
      throw new WrongType(localClassCastException20, "take", 2, paramObject2);
    }
    try
    {
      localIntNum7 = LangObjType.coerceIntNum(paramObject2);
      return drop(paramObject1, localIntNum7);
    }
    catch (ClassCastException localClassCastException19)
    {
      throw new WrongType(localClassCastException19, "drop", 2, paramObject2);
    }
    try
    {
      localIntNum6 = LangObjType.coerceIntNum(paramObject2);
      return take$Ex(paramObject1, localIntNum6);
    }
    catch (ClassCastException localClassCastException18)
    {
      throw new WrongType(localClassCastException18, "take!", 2, paramObject2);
    }
    try
    {
      localIntNum5 = LangObjType.coerceIntNum(paramObject2);
      return takeRight(paramObject1, localIntNum5);
    }
    catch (ClassCastException localClassCastException17)
    {
      throw new WrongType(localClassCastException17, "take-right", 2, paramObject2);
    }
    try
    {
      localIntNum4 = LangObjType.coerceIntNum(paramObject2);
      return dropRight(paramObject1, localIntNum4);
    }
    catch (ClassCastException localClassCastException16)
    {
      throw new WrongType(localClassCastException16, "drop-right", 2, paramObject2);
    }
    try
    {
      localIntNum3 = LangObjType.coerceIntNum(paramObject2);
      return dropRight$Ex(paramObject1, localIntNum3);
    }
    catch (ClassCastException localClassCastException15)
    {
      throw new WrongType(localClassCastException15, "drop-right!", 2, paramObject2);
    }
    try
    {
      localIntNum2 = LangObjType.coerceIntNum(paramObject2);
      return splitAt(paramObject1, localIntNum2);
    }
    catch (ClassCastException localClassCastException14)
    {
      throw new WrongType(localClassCastException14, "split-at", 2, paramObject2);
    }
    try
    {
      localIntNum1 = LangObjType.coerceIntNum(paramObject2);
      return splitAt$Ex(paramObject1, localIntNum1);
    }
    catch (ClassCastException localClassCastException13)
    {
      throw new WrongType(localClassCastException13, "split-at!", 2, paramObject2);
    }
    return appendReverse(paramObject1, paramObject2);
    return appendReverse$Ex(paramObject1, paramObject2);
    try
    {
      Procedure localProcedure12 = (Procedure)paramObject1;
      return filter(localProcedure12, paramObject2);
    }
    catch (ClassCastException localClassCastException12)
    {
      Procedure localProcedure11;
      Procedure localProcedure10;
      Procedure localProcedure9;
      throw new WrongType(localClassCastException12, "filter", 1, paramObject1);
    }
    try
    {
      localProcedure11 = (Procedure)paramObject1;
      return filter$Ex(localProcedure11, paramObject2);
    }
    catch (ClassCastException localClassCastException11)
    {
      throw new WrongType(localClassCastException11, "filter!", 1, paramObject1);
    }
    try
    {
      localProcedure10 = (Procedure)paramObject1;
      return partition(localProcedure10, paramObject2);
    }
    catch (ClassCastException localClassCastException10)
    {
      throw new WrongType(localClassCastException10, "partition", 1, paramObject1);
    }
    try
    {
      localProcedure9 = (Procedure)paramObject1;
      return partition$Ex(localProcedure9, paramObject2);
    }
    catch (ClassCastException localClassCastException9)
    {
      throw new WrongType(localClassCastException9, "partition!", 1, paramObject1);
    }
    return remove(paramObject1, paramObject2);
    return remove$Ex(paramObject1, paramObject2);
    return delete(paramObject1, paramObject2);
    return delete$Ex(paramObject1, paramObject2);
    try
    {
      Procedure localProcedure8 = (Procedure)paramObject2;
      return deleteDuplicates(paramObject1, localProcedure8);
    }
    catch (ClassCastException localClassCastException8)
    {
      Procedure localProcedure7;
      throw new WrongType(localClassCastException8, "delete-duplicates", 2, paramObject2);
    }
    try
    {
      localProcedure7 = (Procedure)paramObject2;
      return deleteDuplicates$Ex(paramObject1, localProcedure7);
    }
    catch (ClassCastException localClassCastException7)
    {
      throw new WrongType(localClassCastException7, "delete-duplicates!", 2, paramObject2);
    }
    return alistDelete(paramObject1, paramObject2);
    return alistDelete$Ex(paramObject1, paramObject2);
    return find(paramObject1, paramObject2);
    try
    {
      Procedure localProcedure6 = (Procedure)paramObject1;
      return findTail(localProcedure6, paramObject2);
    }
    catch (ClassCastException localClassCastException6)
    {
      Procedure localProcedure5;
      Procedure localProcedure4;
      Procedure localProcedure3;
      Procedure localProcedure2;
      Procedure localProcedure1;
      throw new WrongType(localClassCastException6, "find-tail", 1, paramObject1);
    }
    try
    {
      localProcedure5 = (Procedure)paramObject1;
      return takeWhile(localProcedure5, paramObject2);
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "take-while", 1, paramObject1);
    }
    try
    {
      localProcedure4 = (Procedure)paramObject1;
      return dropWhile(localProcedure4, paramObject2);
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "drop-while", 1, paramObject1);
    }
    try
    {
      localProcedure3 = (Procedure)paramObject1;
      return takeWhile$Ex(localProcedure3, paramObject2);
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "take-while!", 1, paramObject1);
    }
    try
    {
      localProcedure2 = (Procedure)paramObject1;
      return span(localProcedure2, paramObject2);
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "span", 1, paramObject1);
    }
    try
    {
      localProcedure1 = (Procedure)paramObject1;
      return span$Ex(localProcedure1, paramObject2);
    }
    catch (ClassCastException localClassCastException1)
    {
      throw new WrongType(localClassCastException1, "span!", 1, paramObject1);
    }
    return jdField_break(paramObject1, paramObject2);
    return break$Ex(paramObject1, paramObject2);
    return frame61.lambda84(paramObject1, paramObject2);
    return frame71.lambda100(paramObject1, paramObject2);
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
      localIntNum = LangObjType.coerceIntNum(paramObject1);
    }
    catch (ClassCastException localClassCastException3)
    {
      IntNum localIntNum;
      Numeric localNumeric1;
      Numeric localNumeric2;
      Procedure localProcedure2;
      Procedure localProcedure1;
      throw new WrongType(localClassCastException3, "iota", 1, paramObject1);
    }
    try
    {
      localNumeric1 = LangObjType.coerceNumeric(paramObject2);
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "iota", 2, paramObject2);
    }
    try
    {
      localNumeric2 = LangObjType.coerceNumeric(paramObject3);
      return iota(localIntNum, localNumeric1, localNumeric2);
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "iota", 3, paramObject3);
    }
    try
    {
      localProcedure2 = (Procedure)paramObject1;
      return reduce(localProcedure2, paramObject2, paramObject3);
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "reduce", 1, paramObject1);
    }
    try
    {
      localProcedure1 = (Procedure)paramObject1;
      return reduceRight(localProcedure1, paramObject2, paramObject3);
    }
    catch (ClassCastException localClassCastException1)
    {
      throw new WrongType(localClassCastException1, "reduce-right", 1, paramObject1);
    }
    return delete(paramObject1, paramObject2, paramObject3);
    return delete$Ex(paramObject1, paramObject2, paramObject3);
    return alistCons(paramObject1, paramObject2, paramObject3);
    return alistDelete(paramObject1, paramObject2, paramObject3);
    return alistDelete$Ex(paramObject1, paramObject2, paramObject3);
  }
  
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (paramModuleMethod.selector == 123) {}
    try
    {
      localProcedure1 = (Procedure)paramObject1;
    }
    catch (ClassCastException localClassCastException1)
    {
      Procedure localProcedure1;
      Procedure localProcedure2;
      Procedure localProcedure3;
      throw new WrongType(localClassCastException1, "unfold-right", 1, paramObject1);
    }
    try
    {
      localProcedure2 = (Procedure)paramObject2;
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "unfold-right", 2, paramObject2);
    }
    try
    {
      localProcedure3 = (Procedure)paramObject3;
      return unfoldRight(localProcedure1, localProcedure2, localProcedure3, paramObject4);
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "unfold-right", 3, paramObject3);
    }
    return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  /* Error */
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1675	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+284->288, 79:+291->295, 81:+339->343, 86:+344->348, 92:+392->396, 94:+440->444, 117:+488->492, 122:+493->497, 123:+556->560, 125:+641->645, 126:+732->736, 127:+802->806, 128:+872->876, 129:+942->946, 132:+1012->1016, 133:+1068->1072, 134:+1124->1128, 135:+1187->1191, 136:+1250->1254, 166:+1313->1317, 167:+1376->1380, 168:+1439->1443, 169:+1502->1506, 170:+1557->1561, 171:+1612->1616, 172:+1675->1679, 173:+1730->1734, 174:+1785->1789, 175:+1848->1852, 176:+1911->1915, 177:+1974->1978, 178:+2037->2041, 179:+2092->2096, 180:+2147->2151, 181:+2210->2214
    //   289: aload_1
    //   290: aload_2
    //   291: invokespecial 1801	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   294: areturn
    //   295: aload_2
    //   296: iconst_0
    //   297: aaload
    //   298: astore 186
    //   300: iconst_m1
    //   301: aload_2
    //   302: arraylength
    //   303: iadd
    //   304: istore 187
    //   306: iload 187
    //   308: anewarray 348	java/lang/Object
    //   311: astore 188
    //   313: iinc 187 255
    //   316: iload 187
    //   318: ifge +11 -> 329
    //   321: aload 186
    //   323: aload 188
    //   325: invokestatic 1803	gnu/kawa/slib/srfi1:makeList$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   328: areturn
    //   329: aload 188
    //   331: iload 187
    //   333: aload_2
    //   334: iload 187
    //   336: iconst_1
    //   337: iadd
    //   338: aaload
    //   339: aastore
    //   340: goto -27 -> 313
    //   343: aload_2
    //   344: invokestatic 1805	gnu/kawa/slib/srfi1:cons$St	([Ljava/lang/Object;)Ljava/lang/Object;
    //   347: areturn
    //   348: aload_2
    //   349: iconst_0
    //   350: aaload
    //   351: astore 183
    //   353: iconst_m1
    //   354: aload_2
    //   355: arraylength
    //   356: iadd
    //   357: istore 184
    //   359: iload 184
    //   361: anewarray 348	java/lang/Object
    //   364: astore 185
    //   366: iinc 184 255
    //   369: iload 184
    //   371: ifge +11 -> 382
    //   374: aload 183
    //   376: aload 185
    //   378: invokestatic 1807	gnu/kawa/slib/srfi1:circularList$V	(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/Pair;
    //   381: areturn
    //   382: aload 185
    //   384: iload 184
    //   386: aload_2
    //   387: iload 184
    //   389: iconst_1
    //   390: iadd
    //   391: aaload
    //   392: aastore
    //   393: goto -27 -> 366
    //   396: aload_2
    //   397: iconst_0
    //   398: aaload
    //   399: astore 180
    //   401: iconst_m1
    //   402: aload_2
    //   403: arraylength
    //   404: iadd
    //   405: istore 181
    //   407: iload 181
    //   409: anewarray 348	java/lang/Object
    //   412: astore 182
    //   414: iinc 181 255
    //   417: iload 181
    //   419: ifge +11 -> 430
    //   422: aload 180
    //   424: aload 182
    //   426: invokestatic 1809	gnu/kawa/slib/srfi1:list$Eq$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   429: areturn
    //   430: aload 182
    //   432: iload 181
    //   434: aload_2
    //   435: iload 181
    //   437: iconst_1
    //   438: iadd
    //   439: aaload
    //   440: aastore
    //   441: goto -27 -> 414
    //   444: aload_2
    //   445: iconst_0
    //   446: aaload
    //   447: astore 177
    //   449: iconst_m1
    //   450: aload_2
    //   451: arraylength
    //   452: iadd
    //   453: istore 178
    //   455: iload 178
    //   457: anewarray 348	java/lang/Object
    //   460: astore 179
    //   462: iinc 178 255
    //   465: iload 178
    //   467: ifge +11 -> 478
    //   470: aload 177
    //   472: aload 179
    //   474: invokestatic 1811	gnu/kawa/slib/srfi1:zip$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   477: areturn
    //   478: aload 179
    //   480: iload 178
    //   482: aload_2
    //   483: iload 178
    //   485: iconst_1
    //   486: iadd
    //   487: aaload
    //   488: aastore
    //   489: goto -27 -> 462
    //   492: aload_2
    //   493: invokestatic 1562	gnu/kawa/slib/srfi1:append$Ex$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   496: areturn
    //   497: aload_2
    //   498: iconst_0
    //   499: aaload
    //   500: astore 171
    //   502: aload 171
    //   504: checkcast 1043	gnu/mapping/Procedure
    //   507: astore 173
    //   509: aload_2
    //   510: iconst_1
    //   511: aaload
    //   512: astore 174
    //   514: bipush 254
    //   516: aload_2
    //   517: arraylength
    //   518: iadd
    //   519: istore 175
    //   521: iload 175
    //   523: anewarray 348	java/lang/Object
    //   526: astore 176
    //   528: iinc 175 255
    //   531: iload 175
    //   533: ifge +13 -> 546
    //   536: aload 173
    //   538: aload 174
    //   540: aload 176
    //   542: invokestatic 1813	gnu/kawa/slib/srfi1:count$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   545: areturn
    //   546: aload 176
    //   548: iload 175
    //   550: aload_2
    //   551: iload 175
    //   553: iconst_2
    //   554: iadd
    //   555: aaload
    //   556: aastore
    //   557: goto -29 -> 528
    //   560: bipush 252
    //   562: aload_2
    //   563: arraylength
    //   564: iadd
    //   565: istore 159
    //   567: aload_2
    //   568: iconst_0
    //   569: aaload
    //   570: astore 160
    //   572: aload 160
    //   574: checkcast 1043	gnu/mapping/Procedure
    //   577: astore 162
    //   579: aload_2
    //   580: iconst_1
    //   581: aaload
    //   582: astore 163
    //   584: aload 163
    //   586: checkcast 1043	gnu/mapping/Procedure
    //   589: astore 165
    //   591: aload_2
    //   592: iconst_2
    //   593: aaload
    //   594: astore 166
    //   596: aload 166
    //   598: checkcast 1043	gnu/mapping/Procedure
    //   601: astore 168
    //   603: aload_2
    //   604: iconst_3
    //   605: aaload
    //   606: astore 169
    //   608: iload 159
    //   610: ifgt +15 -> 625
    //   613: aload 162
    //   615: aload 165
    //   617: aload 168
    //   619: aload 169
    //   621: invokestatic 1796	gnu/kawa/slib/srfi1:unfoldRight	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   624: areturn
    //   625: iload 159
    //   627: iconst_1
    //   628: isub
    //   629: pop
    //   630: aload 162
    //   632: aload 165
    //   634: aload 168
    //   636: aload 169
    //   638: aload_2
    //   639: iconst_4
    //   640: aaload
    //   641: invokestatic 1640	gnu/kawa/slib/srfi1:unfoldRight	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   644: areturn
    //   645: aload_2
    //   646: iconst_0
    //   647: aaload
    //   648: astore 147
    //   650: aload 147
    //   652: checkcast 1043	gnu/mapping/Procedure
    //   655: astore 149
    //   657: aload_2
    //   658: iconst_1
    //   659: aaload
    //   660: astore 150
    //   662: aload 150
    //   664: checkcast 1043	gnu/mapping/Procedure
    //   667: astore 152
    //   669: aload_2
    //   670: iconst_2
    //   671: aaload
    //   672: astore 153
    //   674: aload 153
    //   676: checkcast 1043	gnu/mapping/Procedure
    //   679: astore 155
    //   681: aload_2
    //   682: iconst_3
    //   683: aaload
    //   684: astore 156
    //   686: bipush 252
    //   688: aload_2
    //   689: arraylength
    //   690: iadd
    //   691: istore 157
    //   693: iload 157
    //   695: anewarray 348	java/lang/Object
    //   698: astore 158
    //   700: iinc 157 255
    //   703: iload 157
    //   705: ifge +17 -> 722
    //   708: aload 149
    //   710: aload 152
    //   712: aload 155
    //   714: aload 156
    //   716: aload 158
    //   718: invokestatic 1815	gnu/kawa/slib/srfi1:unfold$V	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   721: areturn
    //   722: aload 158
    //   724: iload 157
    //   726: aload_2
    //   727: iload 157
    //   729: iconst_4
    //   730: iadd
    //   731: aaload
    //   732: aastore
    //   733: goto -33 -> 700
    //   736: aload_2
    //   737: iconst_0
    //   738: aaload
    //   739: astore 140
    //   741: aload 140
    //   743: checkcast 1043	gnu/mapping/Procedure
    //   746: astore 142
    //   748: aload_2
    //   749: iconst_1
    //   750: aaload
    //   751: astore 143
    //   753: aload_2
    //   754: iconst_2
    //   755: aaload
    //   756: astore 144
    //   758: bipush 253
    //   760: aload_2
    //   761: arraylength
    //   762: iadd
    //   763: istore 145
    //   765: iload 145
    //   767: anewarray 348	java/lang/Object
    //   770: astore 146
    //   772: iinc 145 255
    //   775: iload 145
    //   777: ifge +15 -> 792
    //   780: aload 142
    //   782: aload 143
    //   784: aload 144
    //   786: aload 146
    //   788: invokestatic 1426	gnu/kawa/slib/srfi1:fold$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   791: areturn
    //   792: aload 146
    //   794: iload 145
    //   796: aload_2
    //   797: iload 145
    //   799: iconst_3
    //   800: iadd
    //   801: aaload
    //   802: aastore
    //   803: goto -31 -> 772
    //   806: aload_2
    //   807: iconst_0
    //   808: aaload
    //   809: astore 133
    //   811: aload 133
    //   813: checkcast 1043	gnu/mapping/Procedure
    //   816: astore 135
    //   818: aload_2
    //   819: iconst_1
    //   820: aaload
    //   821: astore 136
    //   823: aload_2
    //   824: iconst_2
    //   825: aaload
    //   826: astore 137
    //   828: bipush 253
    //   830: aload_2
    //   831: arraylength
    //   832: iadd
    //   833: istore 138
    //   835: iload 138
    //   837: anewarray 348	java/lang/Object
    //   840: astore 139
    //   842: iinc 138 255
    //   845: iload 138
    //   847: ifge +15 -> 862
    //   850: aload 135
    //   852: aload 136
    //   854: aload 137
    //   856: aload 139
    //   858: invokestatic 1817	gnu/kawa/slib/srfi1:foldRight$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   861: areturn
    //   862: aload 139
    //   864: iload 138
    //   866: aload_2
    //   867: iload 138
    //   869: iconst_3
    //   870: iadd
    //   871: aaload
    //   872: aastore
    //   873: goto -31 -> 842
    //   876: aload_2
    //   877: iconst_0
    //   878: aaload
    //   879: astore 126
    //   881: aload 126
    //   883: checkcast 1043	gnu/mapping/Procedure
    //   886: astore 128
    //   888: aload_2
    //   889: iconst_1
    //   890: aaload
    //   891: astore 129
    //   893: aload_2
    //   894: iconst_2
    //   895: aaload
    //   896: astore 130
    //   898: bipush 253
    //   900: aload_2
    //   901: arraylength
    //   902: iadd
    //   903: istore 131
    //   905: iload 131
    //   907: anewarray 348	java/lang/Object
    //   910: astore 132
    //   912: iinc 131 255
    //   915: iload 131
    //   917: ifge +15 -> 932
    //   920: aload 128
    //   922: aload 129
    //   924: aload 130
    //   926: aload 132
    //   928: invokestatic 1819	gnu/kawa/slib/srfi1:pairFoldRight$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   931: areturn
    //   932: aload 132
    //   934: iload 131
    //   936: aload_2
    //   937: iload 131
    //   939: iconst_3
    //   940: iadd
    //   941: aaload
    //   942: aastore
    //   943: goto -31 -> 912
    //   946: aload_2
    //   947: iconst_0
    //   948: aaload
    //   949: astore 119
    //   951: aload 119
    //   953: checkcast 1043	gnu/mapping/Procedure
    //   956: astore 121
    //   958: aload_2
    //   959: iconst_1
    //   960: aaload
    //   961: astore 122
    //   963: aload_2
    //   964: iconst_2
    //   965: aaload
    //   966: astore 123
    //   968: bipush 253
    //   970: aload_2
    //   971: arraylength
    //   972: iadd
    //   973: istore 124
    //   975: iload 124
    //   977: anewarray 348	java/lang/Object
    //   980: astore 125
    //   982: iinc 124 255
    //   985: iload 124
    //   987: ifge +15 -> 1002
    //   990: aload 121
    //   992: aload 122
    //   994: aload 123
    //   996: aload 125
    //   998: invokestatic 1821	gnu/kawa/slib/srfi1:pairFold$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1001: areturn
    //   1002: aload 125
    //   1004: iload 124
    //   1006: aload_2
    //   1007: iload 124
    //   1009: iconst_3
    //   1010: iadd
    //   1011: aaload
    //   1012: aastore
    //   1013: goto -31 -> 982
    //   1016: aload_2
    //   1017: iconst_0
    //   1018: aaload
    //   1019: astore 115
    //   1021: aload_2
    //   1022: iconst_1
    //   1023: aaload
    //   1024: astore 116
    //   1026: bipush 254
    //   1028: aload_2
    //   1029: arraylength
    //   1030: iadd
    //   1031: istore 117
    //   1033: iload 117
    //   1035: anewarray 348	java/lang/Object
    //   1038: astore 118
    //   1040: iinc 117 255
    //   1043: iload 117
    //   1045: ifge +13 -> 1058
    //   1048: aload 115
    //   1050: aload 116
    //   1052: aload 118
    //   1054: invokestatic 1823	gnu/kawa/slib/srfi1:appendMap$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1057: areturn
    //   1058: aload 118
    //   1060: iload 117
    //   1062: aload_2
    //   1063: iload 117
    //   1065: iconst_2
    //   1066: iadd
    //   1067: aaload
    //   1068: aastore
    //   1069: goto -29 -> 1040
    //   1072: aload_2
    //   1073: iconst_0
    //   1074: aaload
    //   1075: astore 111
    //   1077: aload_2
    //   1078: iconst_1
    //   1079: aaload
    //   1080: astore 112
    //   1082: bipush 254
    //   1084: aload_2
    //   1085: arraylength
    //   1086: iadd
    //   1087: istore 113
    //   1089: iload 113
    //   1091: anewarray 348	java/lang/Object
    //   1094: astore 114
    //   1096: iinc 113 255
    //   1099: iload 113
    //   1101: ifge +13 -> 1114
    //   1104: aload 111
    //   1106: aload 112
    //   1108: aload 114
    //   1110: invokestatic 1825	gnu/kawa/slib/srfi1:appendMap$Ex$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1113: areturn
    //   1114: aload 114
    //   1116: iload 113
    //   1118: aload_2
    //   1119: iload 113
    //   1121: iconst_2
    //   1122: iadd
    //   1123: aaload
    //   1124: aastore
    //   1125: goto -29 -> 1096
    //   1128: aload_2
    //   1129: iconst_0
    //   1130: aaload
    //   1131: astore 105
    //   1133: aload 105
    //   1135: checkcast 1043	gnu/mapping/Procedure
    //   1138: astore 107
    //   1140: aload_2
    //   1141: iconst_1
    //   1142: aaload
    //   1143: astore 108
    //   1145: bipush 254
    //   1147: aload_2
    //   1148: arraylength
    //   1149: iadd
    //   1150: istore 109
    //   1152: iload 109
    //   1154: anewarray 348	java/lang/Object
    //   1157: astore 110
    //   1159: iinc 109 255
    //   1162: iload 109
    //   1164: ifge +13 -> 1177
    //   1167: aload 107
    //   1169: aload 108
    //   1171: aload 110
    //   1173: invokestatic 1551	gnu/kawa/slib/srfi1:pairForEach$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1176: areturn
    //   1177: aload 110
    //   1179: iload 109
    //   1181: aload_2
    //   1182: iload 109
    //   1184: iconst_2
    //   1185: iadd
    //   1186: aaload
    //   1187: aastore
    //   1188: goto -29 -> 1159
    //   1191: aload_2
    //   1192: iconst_0
    //   1193: aaload
    //   1194: astore 99
    //   1196: aload 99
    //   1198: checkcast 1043	gnu/mapping/Procedure
    //   1201: astore 101
    //   1203: aload_2
    //   1204: iconst_1
    //   1205: aaload
    //   1206: astore 102
    //   1208: bipush 254
    //   1210: aload_2
    //   1211: arraylength
    //   1212: iadd
    //   1213: istore 103
    //   1215: iload 103
    //   1217: anewarray 348	java/lang/Object
    //   1220: astore 104
    //   1222: iinc 103 255
    //   1225: iload 103
    //   1227: ifge +13 -> 1240
    //   1230: aload 101
    //   1232: aload 102
    //   1234: aload 104
    //   1236: invokestatic 1827	gnu/kawa/slib/srfi1:map$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1239: areturn
    //   1240: aload 104
    //   1242: iload 103
    //   1244: aload_2
    //   1245: iload 103
    //   1247: iconst_2
    //   1248: iadd
    //   1249: aaload
    //   1250: aastore
    //   1251: goto -29 -> 1222
    //   1254: aload_2
    //   1255: iconst_0
    //   1256: aaload
    //   1257: astore 93
    //   1259: aload 93
    //   1261: checkcast 1043	gnu/mapping/Procedure
    //   1264: astore 95
    //   1266: aload_2
    //   1267: iconst_1
    //   1268: aaload
    //   1269: astore 96
    //   1271: bipush 254
    //   1273: aload_2
    //   1274: arraylength
    //   1275: iadd
    //   1276: istore 97
    //   1278: iload 97
    //   1280: anewarray 348	java/lang/Object
    //   1283: astore 98
    //   1285: iinc 97 255
    //   1288: iload 97
    //   1290: ifge +13 -> 1303
    //   1293: aload 95
    //   1295: aload 96
    //   1297: aload 98
    //   1299: invokestatic 1829	gnu/kawa/slib/srfi1:filterMap$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1302: areturn
    //   1303: aload 98
    //   1305: iload 97
    //   1307: aload_2
    //   1308: iload 97
    //   1310: iconst_2
    //   1311: iadd
    //   1312: aaload
    //   1313: aastore
    //   1314: goto -29 -> 1285
    //   1317: aload_2
    //   1318: iconst_0
    //   1319: aaload
    //   1320: astore 87
    //   1322: aload 87
    //   1324: checkcast 1043	gnu/mapping/Procedure
    //   1327: astore 89
    //   1329: aload_2
    //   1330: iconst_1
    //   1331: aaload
    //   1332: astore 90
    //   1334: bipush 254
    //   1336: aload_2
    //   1337: arraylength
    //   1338: iadd
    //   1339: istore 91
    //   1341: iload 91
    //   1343: anewarray 348	java/lang/Object
    //   1346: astore 92
    //   1348: iinc 91 255
    //   1351: iload 91
    //   1353: ifge +13 -> 1366
    //   1356: aload 89
    //   1358: aload 90
    //   1360: aload 92
    //   1362: invokestatic 1484	gnu/kawa/slib/srfi1:any$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1365: areturn
    //   1366: aload 92
    //   1368: iload 91
    //   1370: aload_2
    //   1371: iload 91
    //   1373: iconst_2
    //   1374: iadd
    //   1375: aaload
    //   1376: aastore
    //   1377: goto -29 -> 1348
    //   1380: aload_2
    //   1381: iconst_0
    //   1382: aaload
    //   1383: astore 81
    //   1385: aload 81
    //   1387: checkcast 1043	gnu/mapping/Procedure
    //   1390: astore 83
    //   1392: aload_2
    //   1393: iconst_1
    //   1394: aaload
    //   1395: astore 84
    //   1397: bipush 254
    //   1399: aload_2
    //   1400: arraylength
    //   1401: iadd
    //   1402: istore 85
    //   1404: iload 85
    //   1406: anewarray 348	java/lang/Object
    //   1409: astore 86
    //   1411: iinc 85 255
    //   1414: iload 85
    //   1416: ifge +13 -> 1429
    //   1419: aload 83
    //   1421: aload 84
    //   1423: aload 86
    //   1425: invokestatic 352	gnu/kawa/slib/srfi1:every$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1428: areturn
    //   1429: aload 86
    //   1431: iload 85
    //   1433: aload_2
    //   1434: iload 85
    //   1436: iconst_2
    //   1437: iadd
    //   1438: aaload
    //   1439: aastore
    //   1440: goto -29 -> 1411
    //   1443: aload_2
    //   1444: iconst_0
    //   1445: aaload
    //   1446: astore 75
    //   1448: aload 75
    //   1450: checkcast 1043	gnu/mapping/Procedure
    //   1453: astore 77
    //   1455: aload_2
    //   1456: iconst_1
    //   1457: aaload
    //   1458: astore 78
    //   1460: bipush 254
    //   1462: aload_2
    //   1463: arraylength
    //   1464: iadd
    //   1465: istore 79
    //   1467: iload 79
    //   1469: anewarray 348	java/lang/Object
    //   1472: astore 80
    //   1474: iinc 79 255
    //   1477: iload 79
    //   1479: ifge +13 -> 1492
    //   1482: aload 77
    //   1484: aload 78
    //   1486: aload 80
    //   1488: invokestatic 1831	gnu/kawa/slib/srfi1:listIndex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1491: areturn
    //   1492: aload 80
    //   1494: iload 79
    //   1496: aload_2
    //   1497: iload 79
    //   1499: iconst_2
    //   1500: iadd
    //   1501: aaload
    //   1502: aastore
    //   1503: goto -29 -> 1474
    //   1506: aload_2
    //   1507: iconst_0
    //   1508: aaload
    //   1509: astore 70
    //   1511: aload 70
    //   1513: checkcast 1043	gnu/mapping/Procedure
    //   1516: astore 72
    //   1518: iconst_m1
    //   1519: aload_2
    //   1520: arraylength
    //   1521: iadd
    //   1522: istore 73
    //   1524: iload 73
    //   1526: anewarray 348	java/lang/Object
    //   1529: astore 74
    //   1531: iinc 73 255
    //   1534: iload 73
    //   1536: ifge +11 -> 1547
    //   1539: aload 72
    //   1541: aload 74
    //   1543: invokestatic 1833	gnu/kawa/slib/srfi1:lset$Ls$Eq$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1546: areturn
    //   1547: aload 74
    //   1549: iload 73
    //   1551: aload_2
    //   1552: iload 73
    //   1554: iconst_1
    //   1555: iadd
    //   1556: aaload
    //   1557: aastore
    //   1558: goto -27 -> 1531
    //   1561: aload_2
    //   1562: iconst_0
    //   1563: aaload
    //   1564: astore 65
    //   1566: aload 65
    //   1568: checkcast 1043	gnu/mapping/Procedure
    //   1571: astore 67
    //   1573: iconst_m1
    //   1574: aload_2
    //   1575: arraylength
    //   1576: iadd
    //   1577: istore 68
    //   1579: iload 68
    //   1581: anewarray 348	java/lang/Object
    //   1584: astore 69
    //   1586: iinc 68 255
    //   1589: iload 68
    //   1591: ifge +11 -> 1602
    //   1594: aload 67
    //   1596: aload 69
    //   1598: invokestatic 1835	gnu/kawa/slib/srfi1:lset$Eq$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1601: areturn
    //   1602: aload 69
    //   1604: iload 68
    //   1606: aload_2
    //   1607: iload 68
    //   1609: iconst_1
    //   1610: iadd
    //   1611: aaload
    //   1612: aastore
    //   1613: goto -27 -> 1586
    //   1616: aload_2
    //   1617: iconst_0
    //   1618: aaload
    //   1619: astore 59
    //   1621: aload 59
    //   1623: checkcast 1043	gnu/mapping/Procedure
    //   1626: astore 61
    //   1628: aload_2
    //   1629: iconst_1
    //   1630: aaload
    //   1631: astore 62
    //   1633: bipush 254
    //   1635: aload_2
    //   1636: arraylength
    //   1637: iadd
    //   1638: istore 63
    //   1640: iload 63
    //   1642: anewarray 348	java/lang/Object
    //   1645: astore 64
    //   1647: iinc 63 255
    //   1650: iload 63
    //   1652: ifge +13 -> 1665
    //   1655: aload 61
    //   1657: aload 62
    //   1659: aload 64
    //   1661: invokestatic 1837	gnu/kawa/slib/srfi1:lsetAdjoin$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1664: areturn
    //   1665: aload 64
    //   1667: iload 63
    //   1669: aload_2
    //   1670: iload 63
    //   1672: iconst_2
    //   1673: iadd
    //   1674: aaload
    //   1675: aastore
    //   1676: goto -29 -> 1647
    //   1679: aload_2
    //   1680: iconst_0
    //   1681: aaload
    //   1682: astore 54
    //   1684: aload 54
    //   1686: checkcast 1043	gnu/mapping/Procedure
    //   1689: astore 56
    //   1691: iconst_m1
    //   1692: aload_2
    //   1693: arraylength
    //   1694: iadd
    //   1695: istore 57
    //   1697: iload 57
    //   1699: anewarray 348	java/lang/Object
    //   1702: astore 58
    //   1704: iinc 57 255
    //   1707: iload 57
    //   1709: ifge +11 -> 1720
    //   1712: aload 56
    //   1714: aload 58
    //   1716: invokestatic 1839	gnu/kawa/slib/srfi1:lsetUnion$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1719: areturn
    //   1720: aload 58
    //   1722: iload 57
    //   1724: aload_2
    //   1725: iload 57
    //   1727: iconst_1
    //   1728: iadd
    //   1729: aaload
    //   1730: aastore
    //   1731: goto -27 -> 1704
    //   1734: aload_2
    //   1735: iconst_0
    //   1736: aaload
    //   1737: astore 49
    //   1739: aload 49
    //   1741: checkcast 1043	gnu/mapping/Procedure
    //   1744: astore 51
    //   1746: iconst_m1
    //   1747: aload_2
    //   1748: arraylength
    //   1749: iadd
    //   1750: istore 52
    //   1752: iload 52
    //   1754: anewarray 348	java/lang/Object
    //   1757: astore 53
    //   1759: iinc 52 255
    //   1762: iload 52
    //   1764: ifge +11 -> 1775
    //   1767: aload 51
    //   1769: aload 53
    //   1771: invokestatic 1841	gnu/kawa/slib/srfi1:lsetUnion$Ex$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1774: areturn
    //   1775: aload 53
    //   1777: iload 52
    //   1779: aload_2
    //   1780: iload 52
    //   1782: iconst_1
    //   1783: iadd
    //   1784: aaload
    //   1785: aastore
    //   1786: goto -27 -> 1759
    //   1789: aload_2
    //   1790: iconst_0
    //   1791: aaload
    //   1792: astore 43
    //   1794: aload 43
    //   1796: checkcast 1043	gnu/mapping/Procedure
    //   1799: astore 45
    //   1801: aload_2
    //   1802: iconst_1
    //   1803: aaload
    //   1804: astore 46
    //   1806: bipush 254
    //   1808: aload_2
    //   1809: arraylength
    //   1810: iadd
    //   1811: istore 47
    //   1813: iload 47
    //   1815: anewarray 348	java/lang/Object
    //   1818: astore 48
    //   1820: iinc 47 255
    //   1823: iload 47
    //   1825: ifge +13 -> 1838
    //   1828: aload 45
    //   1830: aload 46
    //   1832: aload 48
    //   1834: invokestatic 1843	gnu/kawa/slib/srfi1:lsetIntersection$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1837: areturn
    //   1838: aload 48
    //   1840: iload 47
    //   1842: aload_2
    //   1843: iload 47
    //   1845: iconst_2
    //   1846: iadd
    //   1847: aaload
    //   1848: aastore
    //   1849: goto -29 -> 1820
    //   1852: aload_2
    //   1853: iconst_0
    //   1854: aaload
    //   1855: astore 37
    //   1857: aload 37
    //   1859: checkcast 1043	gnu/mapping/Procedure
    //   1862: astore 39
    //   1864: aload_2
    //   1865: iconst_1
    //   1866: aaload
    //   1867: astore 40
    //   1869: bipush 254
    //   1871: aload_2
    //   1872: arraylength
    //   1873: iadd
    //   1874: istore 41
    //   1876: iload 41
    //   1878: anewarray 348	java/lang/Object
    //   1881: astore 42
    //   1883: iinc 41 255
    //   1886: iload 41
    //   1888: ifge +13 -> 1901
    //   1891: aload 39
    //   1893: aload 40
    //   1895: aload 42
    //   1897: invokestatic 1845	gnu/kawa/slib/srfi1:lsetIntersection$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1900: areturn
    //   1901: aload 42
    //   1903: iload 41
    //   1905: aload_2
    //   1906: iload 41
    //   1908: iconst_2
    //   1909: iadd
    //   1910: aaload
    //   1911: aastore
    //   1912: goto -29 -> 1883
    //   1915: aload_2
    //   1916: iconst_0
    //   1917: aaload
    //   1918: astore 31
    //   1920: aload 31
    //   1922: checkcast 1043	gnu/mapping/Procedure
    //   1925: astore 33
    //   1927: aload_2
    //   1928: iconst_1
    //   1929: aaload
    //   1930: astore 34
    //   1932: bipush 254
    //   1934: aload_2
    //   1935: arraylength
    //   1936: iadd
    //   1937: istore 35
    //   1939: iload 35
    //   1941: anewarray 348	java/lang/Object
    //   1944: astore 36
    //   1946: iinc 35 255
    //   1949: iload 35
    //   1951: ifge +13 -> 1964
    //   1954: aload 33
    //   1956: aload 34
    //   1958: aload 36
    //   1960: invokestatic 1847	gnu/kawa/slib/srfi1:lsetDifference$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1963: areturn
    //   1964: aload 36
    //   1966: iload 35
    //   1968: aload_2
    //   1969: iload 35
    //   1971: iconst_2
    //   1972: iadd
    //   1973: aaload
    //   1974: aastore
    //   1975: goto -29 -> 1946
    //   1978: aload_2
    //   1979: iconst_0
    //   1980: aaload
    //   1981: astore 25
    //   1983: aload 25
    //   1985: checkcast 1043	gnu/mapping/Procedure
    //   1988: astore 27
    //   1990: aload_2
    //   1991: iconst_1
    //   1992: aaload
    //   1993: astore 28
    //   1995: bipush 254
    //   1997: aload_2
    //   1998: arraylength
    //   1999: iadd
    //   2000: istore 29
    //   2002: iload 29
    //   2004: anewarray 348	java/lang/Object
    //   2007: astore 30
    //   2009: iinc 29 255
    //   2012: iload 29
    //   2014: ifge +13 -> 2027
    //   2017: aload 27
    //   2019: aload 28
    //   2021: aload 30
    //   2023: invokestatic 1849	gnu/kawa/slib/srfi1:lsetDifference$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2026: areturn
    //   2027: aload 30
    //   2029: iload 29
    //   2031: aload_2
    //   2032: iload 29
    //   2034: iconst_2
    //   2035: iadd
    //   2036: aaload
    //   2037: aastore
    //   2038: goto -29 -> 2009
    //   2041: aload_2
    //   2042: iconst_0
    //   2043: aaload
    //   2044: astore 20
    //   2046: aload 20
    //   2048: checkcast 1043	gnu/mapping/Procedure
    //   2051: astore 22
    //   2053: iconst_m1
    //   2054: aload_2
    //   2055: arraylength
    //   2056: iadd
    //   2057: istore 23
    //   2059: iload 23
    //   2061: anewarray 348	java/lang/Object
    //   2064: astore 24
    //   2066: iinc 23 255
    //   2069: iload 23
    //   2071: ifge +11 -> 2082
    //   2074: aload 22
    //   2076: aload 24
    //   2078: invokestatic 1851	gnu/kawa/slib/srfi1:lsetXor$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2081: areturn
    //   2082: aload 24
    //   2084: iload 23
    //   2086: aload_2
    //   2087: iload 23
    //   2089: iconst_1
    //   2090: iadd
    //   2091: aaload
    //   2092: aastore
    //   2093: goto -27 -> 2066
    //   2096: aload_2
    //   2097: iconst_0
    //   2098: aaload
    //   2099: astore 15
    //   2101: aload 15
    //   2103: checkcast 1043	gnu/mapping/Procedure
    //   2106: astore 17
    //   2108: iconst_m1
    //   2109: aload_2
    //   2110: arraylength
    //   2111: iadd
    //   2112: istore 18
    //   2114: iload 18
    //   2116: anewarray 348	java/lang/Object
    //   2119: astore 19
    //   2121: iinc 18 255
    //   2124: iload 18
    //   2126: ifge +11 -> 2137
    //   2129: aload 17
    //   2131: aload 19
    //   2133: invokestatic 1853	gnu/kawa/slib/srfi1:lsetXor$Ex$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2136: areturn
    //   2137: aload 19
    //   2139: iload 18
    //   2141: aload_2
    //   2142: iload 18
    //   2144: iconst_1
    //   2145: iadd
    //   2146: aaload
    //   2147: aastore
    //   2148: goto -27 -> 2121
    //   2151: aload_2
    //   2152: iconst_0
    //   2153: aaload
    //   2154: astore 9
    //   2156: aload 9
    //   2158: checkcast 1043	gnu/mapping/Procedure
    //   2161: astore 11
    //   2163: aload_2
    //   2164: iconst_1
    //   2165: aaload
    //   2166: astore 12
    //   2168: bipush 254
    //   2170: aload_2
    //   2171: arraylength
    //   2172: iadd
    //   2173: istore 13
    //   2175: iload 13
    //   2177: anewarray 348	java/lang/Object
    //   2180: astore 14
    //   2182: iinc 13 255
    //   2185: iload 13
    //   2187: ifge +13 -> 2200
    //   2190: aload 11
    //   2192: aload 12
    //   2194: aload 14
    //   2196: invokestatic 1855	gnu/kawa/slib/srfi1:lsetDiff$PlIntersection$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2199: areturn
    //   2200: aload 14
    //   2202: iload 13
    //   2204: aload_2
    //   2205: iload 13
    //   2207: iconst_2
    //   2208: iadd
    //   2209: aaload
    //   2210: aastore
    //   2211: goto -29 -> 2182
    //   2214: aload_2
    //   2215: iconst_0
    //   2216: aaload
    //   2217: astore_3
    //   2218: aload_3
    //   2219: checkcast 1043	gnu/mapping/Procedure
    //   2222: astore 5
    //   2224: aload_2
    //   2225: iconst_1
    //   2226: aaload
    //   2227: astore 6
    //   2229: bipush 254
    //   2231: aload_2
    //   2232: arraylength
    //   2233: iadd
    //   2234: istore 7
    //   2236: iload 7
    //   2238: anewarray 348	java/lang/Object
    //   2241: astore 8
    //   2243: iinc 7 255
    //   2246: iload 7
    //   2248: ifge +13 -> 2261
    //   2251: aload 5
    //   2253: aload 6
    //   2255: aload 8
    //   2257: invokestatic 1857	gnu/kawa/slib/srfi1:lsetDiff$PlIntersection$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2260: areturn
    //   2261: aload 8
    //   2263: iload 7
    //   2265: aload_2
    //   2266: iload 7
    //   2268: iconst_2
    //   2269: iadd
    //   2270: aaload
    //   2271: aastore
    //   2272: goto -29 -> 2243
    //   2275: astore 172
    //   2277: new 1052	gnu/mapping/WrongType
    //   2280: dup
    //   2281: aload 172
    //   2283: ldc_w 636
    //   2286: iconst_1
    //   2287: aload 171
    //   2289: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2292: athrow
    //   2293: astore 161
    //   2295: new 1052	gnu/mapping/WrongType
    //   2298: dup
    //   2299: aload 161
    //   2301: ldc_w 633
    //   2304: iconst_1
    //   2305: aload 160
    //   2307: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2310: athrow
    //   2311: astore 164
    //   2313: new 1052	gnu/mapping/WrongType
    //   2316: dup
    //   2317: aload 164
    //   2319: ldc_w 633
    //   2322: iconst_2
    //   2323: aload 163
    //   2325: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2328: athrow
    //   2329: astore 167
    //   2331: new 1052	gnu/mapping/WrongType
    //   2334: dup
    //   2335: aload 167
    //   2337: ldc_w 633
    //   2340: iconst_3
    //   2341: aload 166
    //   2343: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2346: athrow
    //   2347: astore 148
    //   2349: new 1052	gnu/mapping/WrongType
    //   2352: dup
    //   2353: aload 148
    //   2355: ldc_w 629
    //   2358: iconst_1
    //   2359: aload 147
    //   2361: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2364: athrow
    //   2365: astore 151
    //   2367: new 1052	gnu/mapping/WrongType
    //   2370: dup
    //   2371: aload 151
    //   2373: ldc_w 629
    //   2376: iconst_2
    //   2377: aload 150
    //   2379: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2382: athrow
    //   2383: astore 154
    //   2385: new 1052	gnu/mapping/WrongType
    //   2388: dup
    //   2389: aload 154
    //   2391: ldc_w 629
    //   2394: iconst_3
    //   2395: aload 153
    //   2397: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2400: athrow
    //   2401: astore 141
    //   2403: new 1052	gnu/mapping/WrongType
    //   2406: dup
    //   2407: aload 141
    //   2409: ldc_w 626
    //   2412: iconst_1
    //   2413: aload 140
    //   2415: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2418: athrow
    //   2419: astore 134
    //   2421: new 1052	gnu/mapping/WrongType
    //   2424: dup
    //   2425: aload 134
    //   2427: ldc_w 623
    //   2430: iconst_1
    //   2431: aload 133
    //   2433: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2436: athrow
    //   2437: astore 127
    //   2439: new 1052	gnu/mapping/WrongType
    //   2442: dup
    //   2443: aload 127
    //   2445: ldc_w 619
    //   2448: iconst_1
    //   2449: aload 126
    //   2451: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2454: athrow
    //   2455: astore 120
    //   2457: new 1052	gnu/mapping/WrongType
    //   2460: dup
    //   2461: aload 120
    //   2463: ldc_w 615
    //   2466: iconst_1
    //   2467: aload 119
    //   2469: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2472: athrow
    //   2473: astore 106
    //   2475: new 1052	gnu/mapping/WrongType
    //   2478: dup
    //   2479: aload 106
    //   2481: ldc_w 596
    //   2484: iconst_1
    //   2485: aload 105
    //   2487: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2490: athrow
    //   2491: astore 100
    //   2493: new 1052	gnu/mapping/WrongType
    //   2496: dup
    //   2497: aload 100
    //   2499: ldc_w 592
    //   2502: iconst_1
    //   2503: aload 99
    //   2505: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2508: athrow
    //   2509: astore 94
    //   2511: new 1052	gnu/mapping/WrongType
    //   2514: dup
    //   2515: aload 94
    //   2517: ldc_w 588
    //   2520: iconst_1
    //   2521: aload 93
    //   2523: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2526: athrow
    //   2527: astore 88
    //   2529: new 1052	gnu/mapping/WrongType
    //   2532: dup
    //   2533: aload 88
    //   2535: ldc_w 499
    //   2538: iconst_1
    //   2539: aload 87
    //   2541: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2544: athrow
    //   2545: astore 82
    //   2547: new 1052	gnu/mapping/WrongType
    //   2550: dup
    //   2551: aload 82
    //   2553: ldc_w 496
    //   2556: iconst_1
    //   2557: aload 81
    //   2559: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2562: athrow
    //   2563: astore 76
    //   2565: new 1052	gnu/mapping/WrongType
    //   2568: dup
    //   2569: aload 76
    //   2571: ldc_w 436
    //   2574: iconst_1
    //   2575: aload 75
    //   2577: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2580: athrow
    //   2581: astore 71
    //   2583: new 1052	gnu/mapping/WrongType
    //   2586: dup
    //   2587: aload 71
    //   2589: ldc_w 432
    //   2592: iconst_1
    //   2593: aload 70
    //   2595: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2598: athrow
    //   2599: astore 66
    //   2601: new 1052	gnu/mapping/WrongType
    //   2604: dup
    //   2605: aload 66
    //   2607: ldc_w 428
    //   2610: iconst_1
    //   2611: aload 65
    //   2613: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2616: athrow
    //   2617: astore 60
    //   2619: new 1052	gnu/mapping/WrongType
    //   2622: dup
    //   2623: aload 60
    //   2625: ldc_w 424
    //   2628: iconst_1
    //   2629: aload 59
    //   2631: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2634: athrow
    //   2635: astore 55
    //   2637: new 1052	gnu/mapping/WrongType
    //   2640: dup
    //   2641: aload 55
    //   2643: ldc_w 420
    //   2646: iconst_1
    //   2647: aload 54
    //   2649: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2652: athrow
    //   2653: astore 50
    //   2655: new 1052	gnu/mapping/WrongType
    //   2658: dup
    //   2659: aload 50
    //   2661: ldc_w 416
    //   2664: iconst_1
    //   2665: aload 49
    //   2667: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2670: athrow
    //   2671: astore 44
    //   2673: new 1052	gnu/mapping/WrongType
    //   2676: dup
    //   2677: aload 44
    //   2679: ldc_w 412
    //   2682: iconst_1
    //   2683: aload 43
    //   2685: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2688: athrow
    //   2689: astore 38
    //   2691: new 1052	gnu/mapping/WrongType
    //   2694: dup
    //   2695: aload 38
    //   2697: ldc_w 408
    //   2700: iconst_1
    //   2701: aload 37
    //   2703: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2706: athrow
    //   2707: astore 32
    //   2709: new 1052	gnu/mapping/WrongType
    //   2712: dup
    //   2713: aload 32
    //   2715: ldc_w 404
    //   2718: iconst_1
    //   2719: aload 31
    //   2721: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2724: athrow
    //   2725: astore 26
    //   2727: new 1052	gnu/mapping/WrongType
    //   2730: dup
    //   2731: aload 26
    //   2733: ldc_w 400
    //   2736: iconst_1
    //   2737: aload 25
    //   2739: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2742: athrow
    //   2743: astore 21
    //   2745: new 1052	gnu/mapping/WrongType
    //   2748: dup
    //   2749: aload 21
    //   2751: ldc_w 396
    //   2754: iconst_1
    //   2755: aload 20
    //   2757: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2760: athrow
    //   2761: astore 16
    //   2763: new 1052	gnu/mapping/WrongType
    //   2766: dup
    //   2767: aload 16
    //   2769: ldc_w 392
    //   2772: iconst_1
    //   2773: aload 15
    //   2775: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2778: athrow
    //   2779: astore 10
    //   2781: new 1052	gnu/mapping/WrongType
    //   2784: dup
    //   2785: aload 10
    //   2787: ldc_w 388
    //   2790: iconst_1
    //   2791: aload 9
    //   2793: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2796: athrow
    //   2797: astore 4
    //   2799: new 1052	gnu/mapping/WrongType
    //   2802: dup
    //   2803: aload 4
    //   2805: ldc_w 384
    //   2808: iconst_1
    //   2809: aload_3
    //   2810: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2813: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2814	0	this	srfi1
    //   0	2814	1	paramModuleMethod	ModuleMethod
    //   0	2814	2	paramArrayOfObject	Object[]
    //   2217	593	3	localObject1	Object
    //   2797	7	4	localClassCastException1	ClassCastException
    //   2222	30	5	localProcedure1	Procedure
    //   2227	27	6	localObject2	Object
    //   2234	36	7	i	int
    //   2241	21	8	arrayOfObject1	Object[]
    //   2154	638	9	localObject3	Object
    //   2779	7	10	localClassCastException2	ClassCastException
    //   2161	30	11	localProcedure2	Procedure
    //   2166	27	12	localObject4	Object
    //   2173	36	13	j	int
    //   2180	21	14	arrayOfObject2	Object[]
    //   2099	675	15	localObject5	Object
    //   2761	7	16	localClassCastException3	ClassCastException
    //   2106	24	17	localProcedure3	Procedure
    //   2112	34	18	k	int
    //   2119	19	19	arrayOfObject3	Object[]
    //   2044	712	20	localObject6	Object
    //   2743	7	21	localClassCastException4	ClassCastException
    //   2051	24	22	localProcedure4	Procedure
    //   2057	34	23	m	int
    //   2064	19	24	arrayOfObject4	Object[]
    //   1981	757	25	localObject7	Object
    //   2725	7	26	localClassCastException5	ClassCastException
    //   1988	30	27	localProcedure5	Procedure
    //   1993	27	28	localObject8	Object
    //   2000	36	29	n	int
    //   2007	21	30	arrayOfObject5	Object[]
    //   1918	802	31	localObject9	Object
    //   2707	7	32	localClassCastException6	ClassCastException
    //   1925	30	33	localProcedure6	Procedure
    //   1930	27	34	localObject10	Object
    //   1937	36	35	i1	int
    //   1944	21	36	arrayOfObject6	Object[]
    //   1855	847	37	localObject11	Object
    //   2689	7	38	localClassCastException7	ClassCastException
    //   1862	30	39	localProcedure7	Procedure
    //   1867	27	40	localObject12	Object
    //   1874	36	41	i2	int
    //   1881	21	42	arrayOfObject7	Object[]
    //   1792	892	43	localObject13	Object
    //   2671	7	44	localClassCastException8	ClassCastException
    //   1799	30	45	localProcedure8	Procedure
    //   1804	27	46	localObject14	Object
    //   1811	36	47	i3	int
    //   1818	21	48	arrayOfObject8	Object[]
    //   1737	929	49	localObject15	Object
    //   2653	7	50	localClassCastException9	ClassCastException
    //   1744	24	51	localProcedure9	Procedure
    //   1750	34	52	i4	int
    //   1757	19	53	arrayOfObject9	Object[]
    //   1682	966	54	localObject16	Object
    //   2635	7	55	localClassCastException10	ClassCastException
    //   1689	24	56	localProcedure10	Procedure
    //   1695	34	57	i5	int
    //   1702	19	58	arrayOfObject10	Object[]
    //   1619	1011	59	localObject17	Object
    //   2617	7	60	localClassCastException11	ClassCastException
    //   1626	30	61	localProcedure11	Procedure
    //   1631	27	62	localObject18	Object
    //   1638	36	63	i6	int
    //   1645	21	64	arrayOfObject11	Object[]
    //   1564	1048	65	localObject19	Object
    //   2599	7	66	localClassCastException12	ClassCastException
    //   1571	24	67	localProcedure12	Procedure
    //   1577	34	68	i7	int
    //   1584	19	69	arrayOfObject12	Object[]
    //   1509	1085	70	localObject20	Object
    //   2581	7	71	localClassCastException13	ClassCastException
    //   1516	24	72	localProcedure13	Procedure
    //   1522	34	73	i8	int
    //   1529	19	74	arrayOfObject13	Object[]
    //   1446	1130	75	localObject21	Object
    //   2563	7	76	localClassCastException14	ClassCastException
    //   1453	30	77	localProcedure14	Procedure
    //   1458	27	78	localObject22	Object
    //   1465	36	79	i9	int
    //   1472	21	80	arrayOfObject14	Object[]
    //   1383	1175	81	localObject23	Object
    //   2545	7	82	localClassCastException15	ClassCastException
    //   1390	30	83	localProcedure15	Procedure
    //   1395	27	84	localObject24	Object
    //   1402	36	85	i10	int
    //   1409	21	86	arrayOfObject15	Object[]
    //   1320	1220	87	localObject25	Object
    //   2527	7	88	localClassCastException16	ClassCastException
    //   1327	30	89	localProcedure16	Procedure
    //   1332	27	90	localObject26	Object
    //   1339	36	91	i11	int
    //   1346	21	92	arrayOfObject16	Object[]
    //   1257	1265	93	localObject27	Object
    //   2509	7	94	localClassCastException17	ClassCastException
    //   1264	30	95	localProcedure17	Procedure
    //   1269	27	96	localObject28	Object
    //   1276	36	97	i12	int
    //   1283	21	98	arrayOfObject17	Object[]
    //   1194	1310	99	localObject29	Object
    //   2491	7	100	localClassCastException18	ClassCastException
    //   1201	30	101	localProcedure18	Procedure
    //   1206	27	102	localObject30	Object
    //   1213	36	103	i13	int
    //   1220	21	104	arrayOfObject18	Object[]
    //   1131	1355	105	localObject31	Object
    //   2473	7	106	localClassCastException19	ClassCastException
    //   1138	30	107	localProcedure19	Procedure
    //   1143	27	108	localObject32	Object
    //   1150	36	109	i14	int
    //   1157	21	110	arrayOfObject19	Object[]
    //   1075	30	111	localObject33	Object
    //   1080	27	112	localObject34	Object
    //   1087	36	113	i15	int
    //   1094	21	114	arrayOfObject20	Object[]
    //   1019	30	115	localObject35	Object
    //   1024	27	116	localObject36	Object
    //   1031	36	117	i16	int
    //   1038	21	118	arrayOfObject21	Object[]
    //   949	1519	119	localObject37	Object
    //   2455	7	120	localClassCastException20	ClassCastException
    //   956	35	121	localProcedure20	Procedure
    //   961	32	122	localObject38	Object
    //   966	29	123	localObject39	Object
    //   973	38	124	i17	int
    //   980	23	125	arrayOfObject22	Object[]
    //   879	1571	126	localObject40	Object
    //   2437	7	127	localClassCastException21	ClassCastException
    //   886	35	128	localProcedure21	Procedure
    //   891	32	129	localObject41	Object
    //   896	29	130	localObject42	Object
    //   903	38	131	i18	int
    //   910	23	132	arrayOfObject23	Object[]
    //   809	1623	133	localObject43	Object
    //   2419	7	134	localClassCastException22	ClassCastException
    //   816	35	135	localProcedure22	Procedure
    //   821	32	136	localObject44	Object
    //   826	29	137	localObject45	Object
    //   833	38	138	i19	int
    //   840	23	139	arrayOfObject24	Object[]
    //   739	1675	140	localObject46	Object
    //   2401	7	141	localClassCastException23	ClassCastException
    //   746	35	142	localProcedure23	Procedure
    //   751	32	143	localObject47	Object
    //   756	29	144	localObject48	Object
    //   763	38	145	i20	int
    //   770	23	146	arrayOfObject25	Object[]
    //   648	1712	147	localObject49	Object
    //   2347	7	148	localClassCastException24	ClassCastException
    //   655	54	149	localProcedure24	Procedure
    //   660	1718	150	localObject50	Object
    //   2365	7	151	localClassCastException25	ClassCastException
    //   667	44	152	localProcedure25	Procedure
    //   672	1724	153	localObject51	Object
    //   2383	7	154	localClassCastException26	ClassCastException
    //   679	34	155	localProcedure26	Procedure
    //   684	31	156	localObject52	Object
    //   691	40	157	i21	int
    //   698	25	158	arrayOfObject26	Object[]
    //   565	64	159	i22	int
    //   570	1736	160	localObject53	Object
    //   2293	7	161	localClassCastException27	ClassCastException
    //   577	54	162	localProcedure27	Procedure
    //   582	1742	163	localObject54	Object
    //   2311	7	164	localClassCastException28	ClassCastException
    //   589	44	165	localProcedure28	Procedure
    //   594	1748	166	localObject55	Object
    //   2329	7	167	localClassCastException29	ClassCastException
    //   601	34	168	localProcedure29	Procedure
    //   606	31	169	localObject56	Object
    //   500	1788	171	localObject57	Object
    //   2275	7	172	localClassCastException30	ClassCastException
    //   507	30	173	localProcedure30	Procedure
    //   512	27	174	localObject58	Object
    //   519	36	175	i23	int
    //   526	21	176	arrayOfObject27	Object[]
    //   447	24	177	localObject59	Object
    //   453	34	178	i24	int
    //   460	19	179	arrayOfObject28	Object[]
    //   399	24	180	localObject60	Object
    //   405	34	181	i25	int
    //   412	19	182	arrayOfObject29	Object[]
    //   351	24	183	localObject61	Object
    //   357	34	184	i26	int
    //   364	19	185	arrayOfObject30	Object[]
    //   298	24	186	localObject62	Object
    //   304	34	187	i27	int
    //   311	19	188	arrayOfObject31	Object[]
    // Exception table:
    //   from	to	target	type
    //   502	509	2275	java/lang/ClassCastException
    //   572	579	2293	java/lang/ClassCastException
    //   584	591	2311	java/lang/ClassCastException
    //   596	603	2329	java/lang/ClassCastException
    //   650	657	2347	java/lang/ClassCastException
    //   662	669	2365	java/lang/ClassCastException
    //   674	681	2383	java/lang/ClassCastException
    //   741	748	2401	java/lang/ClassCastException
    //   811	818	2419	java/lang/ClassCastException
    //   881	888	2437	java/lang/ClassCastException
    //   951	958	2455	java/lang/ClassCastException
    //   1133	1140	2473	java/lang/ClassCastException
    //   1196	1203	2491	java/lang/ClassCastException
    //   1259	1266	2509	java/lang/ClassCastException
    //   1322	1329	2527	java/lang/ClassCastException
    //   1385	1392	2545	java/lang/ClassCastException
    //   1448	1455	2563	java/lang/ClassCastException
    //   1511	1518	2581	java/lang/ClassCastException
    //   1566	1573	2599	java/lang/ClassCastException
    //   1621	1628	2617	java/lang/ClassCastException
    //   1684	1691	2635	java/lang/ClassCastException
    //   1739	1746	2653	java/lang/ClassCastException
    //   1794	1801	2671	java/lang/ClassCastException
    //   1857	1864	2689	java/lang/ClassCastException
    //   1920	1927	2707	java/lang/ClassCastException
    //   1983	1990	2725	java/lang/ClassCastException
    //   2046	2053	2743	java/lang/ClassCastException
    //   2101	2108	2761	java/lang/ClassCastException
    //   2156	2163	2779	java/lang/ClassCastException
    //   2218	2224	2797	java/lang/ClassCastException
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 152: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 149: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 147: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 121: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 120: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 116: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 115: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 114: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 113: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 112: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 111: 
      if (!(paramObject instanceof Pair)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 110: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 101: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 100: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 99: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 98: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 97: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 96: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 95: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 93: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 91: 
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
    case 87: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 83: 
      if (IntNum.asIntNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    }
    if ((paramObject instanceof LList))
    {
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    return -786431;
  }
  
  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 183: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 182: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 165: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 164: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 163: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 162: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 161: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 160: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 159: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 158: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 157: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 155: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 153: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 149: 
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 147: 
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 145: 
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
    case 142: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 141: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 140: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 139: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 138: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 137: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 119: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 118: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 109: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 108: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 107: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 106: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 105: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 104: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 103: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 102: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 83: 
      if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (Numeric.asNumericOrNull(paramObject2) != null)
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
    case 80: 
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure)) {
        return -786430;
      }
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
    case 155: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 153: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 151: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 145: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 143: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 131: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 130: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    }
    if (IntNum.asIntNumOrNull(paramObject1) != null)
    {
      paramCallContext.value1 = paramObject1;
      if (Numeric.asNumericOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        if (Numeric.asNumericOrNull(paramObject3) == null) {
          break label408;
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
    label408:
    return -786429;
  }
  
  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 123)
    {
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      if (!(paramObject3 instanceof Procedure)) {
        return -786429;
      }
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
    case 181: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 180: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 179: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 178: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 177: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 176: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 175: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 174: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 173: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 172: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 171: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 170: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 169: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 168: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 167: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 166: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 136: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 135: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 134: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 133: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 132: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 129: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 128: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 127: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 126: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 125: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 123: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 122: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 117: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 94: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 92: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 86: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 81: 
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
    first = lists.car;
    second = lists.cadr;
    third = lists.caddr;
    fourth = lists.cadddr;
    map$Mnin$Mnorder = Scheme.map;
  }
  
  public class frame
    extends ModuleBody
  {
    public static Object lambda2recur(Object paramObject)
    {
      srfi1.frame0 localframe0 = new srfi1.frame0();
      localframe0.lis = paramObject;
      if (srfi1.isNullList(localframe0.lis) != Boolean.FALSE)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localframe0.lis;
        arrayOfObject[1] = localframe0.lis;
        return misc.values(arrayOfObject);
      }
      localframe0.elt = lists.car.apply1(localframe0.lis);
      return call_with_values.callWithValues(localframe0.lambda$Fn1, localframe0.lambda$Fn2);
    }
  }
  
  public class frame0
    extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn1 = new ModuleMethod(this, 1, null, 0);
    final ModuleMethod lambda$Fn2;
    Object lis;
    
    public frame0()
    {
      this$1 = new ModuleMethod(this, 2, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:627");
      this.lambda$Fn2 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 1) {
        return lambda3();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 2) {
        return lambda4(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda3()
    {
      return srfi1.frame.lambda2recur(lists.cdr.apply1(this.lis));
    }
    
    Object lambda4(Object paramObject1, Object paramObject2)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = lists.cons(lists.car.apply1(this.elt), paramObject1);
      arrayOfObject[1] = lists.cons(lists.cadr.apply1(this.elt), paramObject2);
      return misc.values(arrayOfObject);
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
  
  public class frame1
    extends ModuleBody
  {
    public static Object lambda5recur(Object paramObject)
    {
      srfi1.frame2 localframe2 = new srfi1.frame2();
      localframe2.lis = paramObject;
      if (srfi1.isNullList(localframe2.lis) != Boolean.FALSE)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = localframe2.lis;
        arrayOfObject[1] = localframe2.lis;
        arrayOfObject[2] = localframe2.lis;
        return misc.values(arrayOfObject);
      }
      localframe2.elt = lists.car.apply1(localframe2.lis);
      return call_with_values.callWithValues(localframe2.lambda$Fn3, localframe2.lambda$Fn4);
    }
  }
  
  public class frame10
    extends ModuleBody
  {
    Procedure f;
    Object zero;
    
    public Object lambda19recur(Object paramObject)
    {
      Object localObject = srfi1.$PcCdrs(paramObject);
      if (lists.isNull(localObject)) {
        return this.zero;
      }
      Apply localApply = Scheme.apply;
      Procedure localProcedure = this.f;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramObject;
      arrayOfObject[1] = LList.list1(lambda19recur(localObject));
      return localApply.apply2(localProcedure, srfi1.append$Ex$V(arrayOfObject));
    }
    
    public Object lambda20recur(Object paramObject)
    {
      if (srfi1.isNullList(paramObject) != Boolean.FALSE) {
        return this.zero;
      }
      return this.f.apply2(paramObject, lambda20recur(lists.cdr.apply1(paramObject)));
    }
  }
  
  public class frame11
    extends ModuleBody
  {
    Procedure f;
    
    public Object lambda21recur(Object paramObject1, Object paramObject2)
    {
      if (lists.isPair(paramObject2)) {
        paramObject1 = this.f.apply2(paramObject1, lambda21recur(lists.car.apply1(paramObject2), lists.cdr.apply1(paramObject2)));
      }
      return paramObject1;
    }
  }
  
  public class frame12
    extends ModuleBody
  {
    Procedure f;
    final ModuleMethod lambda$Fn11;
    
    public frame12()
    {
      this$1 = new ModuleMethod(this, 11, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:961");
      this.lambda$Fn11 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 11)
      {
        lambda22(paramObject);
        return Values.empty;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    void lambda22(Object paramObject)
    {
      try
      {
        Pair localPair = (Pair)paramObject;
        lists.setCar$Ex(localPair, this.f.apply1(lists.car.apply1(paramObject)));
        return;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-car!", 1, paramObject);
      }
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
  
  public class frame13
    extends ModuleBody
  {
    Procedure f;
    
    public Object lambda23recur(Object paramObject1, Object paramObject2)
    {
      srfi1.frame14 localframe14 = new srfi1.frame14();
      localframe14.staticLink = this;
      localframe14.lists = paramObject1;
      localframe14.res = paramObject2;
      return call_with_values.callWithValues(localframe14.lambda$Fn12, localframe14.lambda$Fn13);
    }
  }
  
  public class frame14
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn12 = new ModuleMethod(this, 12, null, 0);
    final ModuleMethod lambda$Fn13;
    Object lists;
    Object res;
    srfi1.frame13 staticLink;
    
    public frame14()
    {
      this$1 = new ModuleMethod(this, 13, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:969");
      this.lambda$Fn13 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 12) {
        return lambda24();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 13) {
        return lambda25(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda24()
    {
      return srfi1.$PcCars$PlCdrs(this.lists);
    }
    
    Object lambda25(Object paramObject1, Object paramObject2)
    {
      if (srfi1.isNotPair(paramObject1)) {
        localObject2 = this.res;
      }
      try
      {
        LList localLList = (LList)localObject2;
        return lists.reverse$Ex(localLList);
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject1;
        throw new WrongType(localClassCastException, "reverse!", 1, localObject2);
      }
      localObject1 = Scheme.apply.apply2(this.staticLink.f, paramObject1);
      if (localObject1 != Boolean.FALSE) {
        return this.staticLink.lambda23recur(paramObject2, lists.cons(localObject1, this.res));
      }
      return this.staticLink.lambda23recur(paramObject2, this.res);
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
  
  public class frame15
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn14;
    Object pred;
    
    public frame15()
    {
      this$1 = new ModuleMethod(this, 14, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1199");
      this.lambda$Fn14 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 14)
      {
        if (lambda26(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda26(Object paramObject)
    {
      if (Scheme.applyToArgs.apply2(this.pred, paramObject) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return 0x1 & i + 1;
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 14)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame16
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn15;
    Object pred;
    
    public frame16()
    {
      this$1 = new ModuleMethod(this, 15, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1200");
      this.lambda$Fn15 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 15)
      {
        if (lambda27(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda27(Object paramObject)
    {
      if (Scheme.applyToArgs.apply2(this.pred, paramObject) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return 0x1 & i + 1;
      }
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
  
  public class frame17
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn16;
    Object maybe$Mn$Eq;
    Object x;
    
    public frame17()
    {
      this$1 = new ModuleMethod(this, 16, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1222");
      this.lambda$Fn16 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 16)
      {
        if (lambda28(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda28(Object paramObject)
    {
      if (Scheme.applyToArgs.apply3(this.maybe$Mn$Eq, this.x, paramObject) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return 0x1 & i + 1;
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 16)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame18
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn17;
    Object maybe$Mn$Eq;
    Object x;
    
    public frame18()
    {
      this$1 = new ModuleMethod(this, 17, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1225");
      this.lambda$Fn17 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 17)
      {
        if (lambda29(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda29(Object paramObject)
    {
      if (Scheme.applyToArgs.apply3(this.maybe$Mn$Eq, this.x, paramObject) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return 0x1 & i + 1;
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 17)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame19
    extends ModuleBody
  {
    Procedure maybe$Mn$Eq;
    
    public Object lambda30recur(Object paramObject)
    {
      if (srfi1.isNullList(paramObject) != Boolean.FALSE) {}
      Object localObject1;
      Object localObject2;
      Object localObject3;
      do
      {
        return paramObject;
        localObject1 = lists.car.apply1(paramObject);
        localObject2 = lists.cdr.apply1(paramObject);
        localObject3 = lambda30recur(srfi1.delete(localObject1, localObject2, this.maybe$Mn$Eq));
      } while (localObject2 == localObject3);
      return lists.cons(localObject1, localObject3);
    }
  }
  
  public class frame2
    extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn3 = new ModuleMethod(this, 3, null, 0);
    final ModuleMethod lambda$Fn4;
    Object lis;
    
    public frame2()
    {
      this$1 = new ModuleMethod(this, 4, null, 12291);
      this$1.setProperty("source-location", "srfi1.scm:635");
      this.lambda$Fn4 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 3) {
        return lambda6();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 4) {
        return lambda7(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda6()
    {
      return srfi1.frame1.lambda5recur(lists.cdr.apply1(this.lis));
    }
    
    Object lambda7(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = lists.cons(lists.car.apply1(this.elt), paramObject1);
      arrayOfObject[1] = lists.cons(lists.cadr.apply1(this.elt), paramObject2);
      arrayOfObject[2] = lists.cons(lists.caddr.apply1(this.elt), paramObject3);
      return misc.values(arrayOfObject);
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
  
  public class frame20
    extends ModuleBody
  {
    Procedure maybe$Mn$Eq;
    
    public Object lambda31recur(Object paramObject)
    {
      if (srfi1.isNullList(paramObject) != Boolean.FALSE) {}
      Object localObject1;
      Object localObject2;
      Object localObject3;
      do
      {
        return paramObject;
        localObject1 = lists.car.apply1(paramObject);
        localObject2 = lists.cdr.apply1(paramObject);
        localObject3 = lambda31recur(srfi1.delete$Ex(localObject1, localObject2, this.maybe$Mn$Eq));
      } while (localObject2 == localObject3);
      return lists.cons(localObject1, localObject3);
    }
  }
  
  public class frame21
    extends ModuleBody
  {
    Object key;
    final ModuleMethod lambda$Fn18;
    Object maybe$Mn$Eq;
    
    public frame21()
    {
      this$1 = new ModuleMethod(this, 18, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1280");
      this.lambda$Fn18 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 18)
      {
        if (lambda32(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda32(Object paramObject)
    {
      if (Scheme.applyToArgs.apply3(this.maybe$Mn$Eq, this.key, lists.car.apply1(paramObject)) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return 0x1 & i + 1;
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 18)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame22
    extends ModuleBody
  {
    Object key;
    final ModuleMethod lambda$Fn19;
    Object maybe$Mn$Eq;
    
    public frame22()
    {
      this$1 = new ModuleMethod(this, 19, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1283");
      this.lambda$Fn19 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 19)
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
      if (Scheme.applyToArgs.apply3(this.maybe$Mn$Eq, this.key, lists.car.apply1(paramObject)) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return 0x1 & i + 1;
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 19)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame23
    extends ModuleBody
  {
    Procedure pred;
    
    public Object lambda34recur(Object paramObject)
    {
      if (srfi1.isNullList(paramObject) != Boolean.FALSE) {
        return LList.Empty;
      }
      Object localObject = lists.car.apply1(paramObject);
      if (this.pred.apply1(localObject) != Boolean.FALSE) {
        return lists.cons(localObject, lambda34recur(lists.cdr.apply1(paramObject)));
      }
      return LList.Empty;
    }
  }
  
  public class frame24
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn20;
    Object pred;
    
    public frame24()
    {
      this$1 = new ModuleMethod(this, 20, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1343");
      this.lambda$Fn20 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 20)
      {
        if (lambda35(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda35(Object paramObject)
    {
      if (Scheme.applyToArgs.apply2(this.pred, paramObject) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return 0x1 & i + 1;
      }
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
  
  public class frame25
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn21;
    Object pred;
    
    public frame25()
    {
      this$1 = new ModuleMethod(this, 21, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1344");
      this.lambda$Fn21 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 21)
      {
        if (lambda36(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda36(Object paramObject)
    {
      if (Scheme.applyToArgs.apply2(this.pred, paramObject) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return 0x1 & i + 1;
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
  
  public class frame26
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn22 = new ModuleMethod(this, 22, null, 0);
    final ModuleMethod lambda$Fn23;
    Object lis1;
    LList lists;
    Procedure pred;
    
    public frame26()
    {
      this$1 = new ModuleMethod(this, 23, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1350");
      this.lambda$Fn23 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 22) {
        return lambda37();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 23) {
        return lambda38(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda37()
    {
      return srfi1.$PcCars$PlCdrs(lists.cons(this.lis1, this.lists));
    }
    
    Object lambda38(Object paramObject1, Object paramObject2)
    {
      boolean bool = lists.isPair(paramObject1);
      if (bool)
      {
        for (;;)
        {
          Object localObject1 = srfi1.$PcCars$PlCdrs$SlPair(paramObject2);
          Object localObject2 = lists.car.apply1(localObject1);
          Object localObject3 = lists.cdr.apply1(localObject1);
          if (!lists.isPair(localObject2)) {
            break;
          }
          Object localObject4 = Scheme.apply.apply2(this.pred, paramObject1);
          if (localObject4 != Boolean.FALSE) {
            return localObject4;
          }
          paramObject2 = localObject3;
          paramObject1 = localObject2;
        }
        return Scheme.apply.apply2(this.pred, paramObject1);
      }
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
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
  
  public class frame27
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn24 = new ModuleMethod(this, 26, null, 0);
    final ModuleMethod lambda$Fn25;
    Object lis1;
    LList lists;
    Procedure pred;
    
    public frame27()
    {
      this$1 = new ModuleMethod(this, 27, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1378");
      this.lambda$Fn25 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 26) {
        return lambda39();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 27) {
        return lambda40(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda39()
    {
      return srfi1.$PcCars$PlCdrs(lists.cons(this.lis1, this.lists));
    }
    
    Object lambda40(Object paramObject1, Object paramObject2)
    {
      srfi1.frame28 localframe28 = new srfi1.frame28();
      localframe28.staticLink = this;
      int i = 0x1 & true + lists.isPair(paramObject1);
      if (i != 0)
      {
        if (i != 0) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return localframe28.lambda41lp(paramObject1, paramObject2);
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
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 27)
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
  
  public class frame28
    extends ModuleBody
  {
    srfi1.frame27 staticLink;
    
    public Object lambda41lp(Object paramObject1, Object paramObject2)
    {
      srfi1.frame29 localframe29 = new srfi1.frame29();
      localframe29.staticLink = this;
      localframe29.heads = paramObject1;
      localframe29.tails = paramObject2;
      return call_with_values.callWithValues(localframe29.lambda$Fn26, localframe29.lambda$Fn27);
    }
  }
  
  public class frame29
    extends ModuleBody
  {
    Object heads;
    final ModuleMethod lambda$Fn26 = new ModuleMethod(this, 24, null, 0);
    final ModuleMethod lambda$Fn27;
    srfi1.frame28 staticLink;
    Object tails;
    
    public frame29()
    {
      this$1 = new ModuleMethod(this, 25, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1381");
      this.lambda$Fn27 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 24) {
        return lambda42();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 25) {
        return lambda43(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda42()
    {
      return srfi1.$PcCars$PlCdrs(this.tails);
    }
    
    Object lambda43(Object paramObject1, Object paramObject2)
    {
      if (lists.isPair(paramObject1))
      {
        Object localObject = Scheme.apply.apply2(this.staticLink.staticLink.pred, this.heads);
        if (localObject != Boolean.FALSE) {
          localObject = this.staticLink.lambda41lp(paramObject1, paramObject2);
        }
        return localObject;
      }
      return Scheme.apply.apply2(this.staticLink.staticLink.pred, this.heads);
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
  
  public class frame3
    extends ModuleBody
  {
    public static Object lambda8recur(Object paramObject)
    {
      srfi1.frame4 localframe4 = new srfi1.frame4();
      localframe4.lis = paramObject;
      if (srfi1.isNullList(localframe4.lis) != Boolean.FALSE)
      {
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = localframe4.lis;
        arrayOfObject[1] = localframe4.lis;
        arrayOfObject[2] = localframe4.lis;
        arrayOfObject[3] = localframe4.lis;
        return misc.values(arrayOfObject);
      }
      localframe4.elt = lists.car.apply1(localframe4.lis);
      return call_with_values.callWithValues(localframe4.lambda$Fn5, localframe4.lambda$Fn6);
    }
  }
  
  public class frame30
    extends ModuleBody
  {
    Procedure pred;
    
    public Object lambda44lp(Object paramObject1, Object paramObject2)
    {
      srfi1.frame31 localframe31 = new srfi1.frame31();
      localframe31.staticLink = this;
      localframe31.lists = paramObject1;
      localframe31.n = paramObject2;
      return call_with_values.callWithValues(localframe31.lambda$Fn28, localframe31.lambda$Fn29);
    }
  }
  
  public class frame31
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn28 = new ModuleMethod(this, 28, null, 0);
    final ModuleMethod lambda$Fn29;
    Object lists;
    Object n;
    srfi1.frame30 staticLink;
    
    public frame31()
    {
      this$1 = new ModuleMethod(this, 29, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1404");
      this.lambda$Fn29 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 28) {
        return lambda45();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 29) {
        return lambda46(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda45()
    {
      return srfi1.$PcCars$PlCdrs(this.lists);
    }
    
    Object lambda46(Object paramObject1, Object paramObject2)
    {
      boolean bool = lists.isPair(paramObject1);
      if (bool)
      {
        if (Scheme.apply.apply2(this.staticLink.pred, paramObject1) != Boolean.FALSE) {
          return this.n;
        }
        return this.staticLink.lambda44lp(paramObject2, AddOp.$Pl.apply2(this.n, srfi1.Lit1));
      }
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
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
  
  public class frame32
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn30;
    
    public frame32()
    {
      this$1 = new ModuleMethod(this, 30, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1466");
      this.lambda$Fn30 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 30) {
        return lambda47(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda47(Object paramObject1, Object paramObject2)
    {
      if (lists.member(paramObject1, paramObject2, this.$Eq) != Boolean.FALSE) {
        return paramObject2;
      }
      return lists.cons(paramObject1, paramObject2);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 30)
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
    Procedure $Eq;
    final ModuleMethod lambda$Fn31;
    final ModuleMethod lambda$Fn32;
    
    public frame33()
    {
      this$1 = new ModuleMethod(this, 32, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1476");
      this.lambda$Fn32 = this$1;
      ModuleMethod localModuleMethod = new ModuleMethod(this, 33, null, 8194);
      localModuleMethod.setProperty("source-location", "srfi1.scm:1471");
      this.lambda$Fn31 = localModuleMethod;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply2(paramModuleMethod, paramObject1, paramObject2);
      case 32: 
        return lambda49(paramObject1, paramObject2);
      }
      return lambda48(paramObject1, paramObject2);
    }
    
    Object lambda48(Object paramObject1, Object paramObject2)
    {
      if (lists.isNull(paramObject1)) {}
      do
      {
        return paramObject2;
        if (lists.isNull(paramObject2)) {
          return paramObject1;
        }
      } while (paramObject1 == paramObject2);
      return srfi1.fold$V(this.lambda$Fn32, paramObject2, paramObject1, new Object[0]);
    }
    
    Object lambda49(Object paramObject1, Object paramObject2)
    {
      srfi1.frame34 localframe34 = new srfi1.frame34();
      localframe34.staticLink = this;
      localframe34.elt = paramObject1;
      if (srfi1.any$V(localframe34.lambda$Fn33, paramObject2, new Object[0]) != Boolean.FALSE) {
        return paramObject2;
      }
      return lists.cons(localframe34.elt, paramObject2);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
      case 33: 
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
  
  public class frame34
    extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn33;
    srfi1.frame33 staticLink;
    
    public frame34()
    {
      this$1 = new ModuleMethod(this, 31, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1476");
      this.lambda$Fn33 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 31) {
        return lambda50(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda50(Object paramObject)
    {
      return this.staticLink.$Eq.apply2(paramObject, this.elt);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 31)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame35
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn34;
    final ModuleMethod lambda$Fn35;
    
    public frame35()
    {
      this$1 = new ModuleMethod(this, 35, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1488");
      this.lambda$Fn35 = this$1;
      ModuleMethod localModuleMethod = new ModuleMethod(this, 36, null, 8194);
      localModuleMethod.setProperty("source-location", "srfi1.scm:1483");
      this.lambda$Fn34 = localModuleMethod;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply2(paramModuleMethod, paramObject1, paramObject2);
      case 35: 
        return lambda52(paramObject1, paramObject2);
      }
      return lambda51(paramObject1, paramObject2);
    }
    
    Object lambda51(Object paramObject1, Object paramObject2)
    {
      if (lists.isNull(paramObject1)) {}
      do
      {
        return paramObject2;
        if (lists.isNull(paramObject2)) {
          return paramObject1;
        }
      } while (paramObject1 == paramObject2);
      return srfi1.pairFold$V(this.lambda$Fn35, paramObject2, paramObject1, new Object[0]);
    }
    
    Object lambda52(Object paramObject1, Object paramObject2)
    {
      srfi1.frame36 localframe36 = new srfi1.frame36();
      localframe36.staticLink = this;
      localframe36.elt = lists.car.apply1(paramObject1);
      if (srfi1.any$V(localframe36.lambda$Fn36, paramObject2, new Object[0]) != Boolean.FALSE) {
        return paramObject2;
      }
      try
      {
        Pair localPair = (Pair)paramObject1;
        lists.setCdr$Ex(localPair, paramObject2);
        return paramObject1;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-cdr!", 1, paramObject1);
      }
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
      case 36: 
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
  
  public class frame36
    extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn36;
    srfi1.frame35 staticLink;
    
    public frame36()
    {
      this$1 = new ModuleMethod(this, 34, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1490");
      this.lambda$Fn36 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 34) {
        return lambda53(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda53(Object paramObject)
    {
      return this.staticLink.$Eq.apply2(paramObject, this.elt);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 34)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame37
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn37;
    Object lists;
    
    public frame37()
    {
      this$1 = new ModuleMethod(this, 38, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1501");
      this.lambda$Fn37 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 38) {
        return lambda54(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda54(Object paramObject)
    {
      srfi1.frame38 localframe38 = new srfi1.frame38();
      localframe38.staticLink = this;
      localframe38.x = paramObject;
      return srfi1.every$V(localframe38.lambda$Fn38, this.lists, new Object[0]);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 38)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame38
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn38;
    srfi1.frame37 staticLink;
    Object x;
    
    public frame38()
    {
      this$1 = new ModuleMethod(this, 37, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1502");
      this.lambda$Fn38 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 37) {
        return lambda55(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda55(Object paramObject)
    {
      return lists.member(this.x, paramObject, this.staticLink.$Eq);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 37)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame39
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn39;
    Object lists;
    
    public frame39()
    {
      this$1 = new ModuleMethod(this, 40, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1509");
      this.lambda$Fn39 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 40) {
        return lambda56(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda56(Object paramObject)
    {
      srfi1.frame40 localframe40 = new srfi1.frame40();
      localframe40.staticLink = this;
      localframe40.x = paramObject;
      return srfi1.every$V(localframe40.lambda$Fn40, this.lists, new Object[0]);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 40)
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
    Object elt;
    final ModuleMethod lambda$Fn5 = new ModuleMethod(this, 5, null, 0);
    final ModuleMethod lambda$Fn6;
    Object lis;
    
    public frame4()
    {
      this$1 = new ModuleMethod(this, 6, null, 16388);
      this$1.setProperty("source-location", "srfi1.scm:644");
      this.lambda$Fn6 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 5) {
        return lambda9();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      if (paramModuleMethod.selector == 6) {
        return lambda10(paramObject1, paramObject2, paramObject3, paramObject4);
      }
      return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
    }
    
    Object lambda10(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = lists.cons(lists.car.apply1(this.elt), paramObject1);
      arrayOfObject[1] = lists.cons(lists.cadr.apply1(this.elt), paramObject2);
      arrayOfObject[2] = lists.cons(lists.caddr.apply1(this.elt), paramObject3);
      arrayOfObject[3] = lists.cons(lists.cadddr.apply1(this.elt), paramObject4);
      return misc.values(arrayOfObject);
    }
    
    Object lambda9()
    {
      return srfi1.frame3.lambda8recur(lists.cdr.apply1(this.lis));
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
    
    public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 6)
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
  
  public class frame40
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn40;
    srfi1.frame39 staticLink;
    Object x;
    
    public frame40()
    {
      this$1 = new ModuleMethod(this, 39, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1510");
      this.lambda$Fn40 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 39) {
        return lambda57(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda57(Object paramObject)
    {
      return lists.member(this.x, paramObject, this.staticLink.$Eq);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 39)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame41
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn41;
    Object lists;
    
    public frame41()
    {
      this$1 = new ModuleMethod(this, 42, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1518");
      this.lambda$Fn41 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 42) {
        return lambda58(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda58(Object paramObject)
    {
      srfi1.frame42 localframe42 = new srfi1.frame42();
      localframe42.staticLink = this;
      localframe42.x = paramObject;
      return srfi1.every$V(localframe42.lambda$Fn42, this.lists, new Object[0]);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 42)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame42
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn42;
    srfi1.frame41 staticLink;
    Object x;
    
    public frame42()
    {
      this$1 = new ModuleMethod(this, 41, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1519");
      this.lambda$Fn42 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 41)
      {
        if (lambda59(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda59(Object paramObject)
    {
      if (lists.member(this.x, paramObject, this.staticLink.$Eq) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return 0x1 & i + 1;
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 41)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame43
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn43;
    Object lists;
    
    public frame43()
    {
      this$1 = new ModuleMethod(this, 44, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1527");
      this.lambda$Fn43 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 44) {
        return lambda60(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda60(Object paramObject)
    {
      srfi1.frame44 localframe44 = new srfi1.frame44();
      localframe44.staticLink = this;
      localframe44.x = paramObject;
      return srfi1.every$V(localframe44.lambda$Fn44, this.lists, new Object[0]);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 44)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame44
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn44;
    srfi1.frame43 staticLink;
    Object x;
    
    public frame44()
    {
      this$1 = new ModuleMethod(this, 43, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1528");
      this.lambda$Fn44 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 43)
      {
        if (lambda61(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda61(Object paramObject)
    {
      if (lists.member(this.x, paramObject, this.staticLink.$Eq) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return 0x1 & i + 1;
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 43)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame45
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn45;
    
    public frame45()
    {
      this$1 = new ModuleMethod(this, 48, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1534");
      this.lambda$Fn45 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 48) {
        return lambda62(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda62(Object paramObject1, Object paramObject2)
    {
      srfi1.frame46 localframe46 = new srfi1.frame46();
      localframe46.staticLink = this;
      localframe46.b = paramObject1;
      localframe46.a = paramObject2;
      return call_with_values.callWithValues(localframe46.lambda$Fn46, localframe46.lambda$Fn47);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 48)
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
  
  public class frame46
    extends ModuleBody
  {
    Object a;
    Object b;
    final ModuleMethod lambda$Fn46 = new ModuleMethod(this, 46, null, 0);
    final ModuleMethod lambda$Fn47;
    srfi1.frame45 staticLink;
    
    public frame46()
    {
      this$1 = new ModuleMethod(this, 47, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1544");
      this.lambda$Fn47 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 46) {
        return lambda63();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 47) {
        return lambda64(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda63()
    {
      Procedure localProcedure = this.staticLink.$Eq;
      Object localObject = this.a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.b;
      return srfi1.lsetDiff$PlIntersection$V(localProcedure, localObject, arrayOfObject);
    }
    
    Object lambda64(Object paramObject1, Object paramObject2)
    {
      srfi1.frame47 localframe47 = new srfi1.frame47();
      localframe47.staticLink = this;
      localframe47.a$Mnint$Mnb = paramObject2;
      if (lists.isNull(paramObject1))
      {
        Procedure localProcedure = this.staticLink.$Eq;
        Object localObject = this.b;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.a;
        return srfi1.lsetDifference$V(localProcedure, localObject, arrayOfObject2);
      }
      if (lists.isNull(localframe47.a$Mnint$Mnb))
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = this.b;
        arrayOfObject1[1] = this.a;
        return append.append$V(arrayOfObject1);
      }
      return srfi1.fold$V(localframe47.lambda$Fn48, paramObject1, this.b, new Object[0]);
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
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 47)
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
    Object a$Mnint$Mnb;
    final ModuleMethod lambda$Fn48;
    srfi1.frame46 staticLink;
    
    public frame47()
    {
      this$1 = new ModuleMethod(this, 45, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1547");
      this.lambda$Fn48 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 45) {
        return lambda65(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda65(Object paramObject1, Object paramObject2)
    {
      if (lists.member(paramObject1, this.a$Mnint$Mnb, this.staticLink.staticLink.$Eq) != Boolean.FALSE) {
        return paramObject2;
      }
      return lists.cons(paramObject1, paramObject2);
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
  
  public class frame48
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn49;
    
    public frame48()
    {
      this$1 = new ModuleMethod(this, 52, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1555");
      this.lambda$Fn49 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 52) {
        return lambda66(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda66(Object paramObject1, Object paramObject2)
    {
      srfi1.frame49 localframe49 = new srfi1.frame49();
      localframe49.staticLink = this;
      localframe49.b = paramObject1;
      localframe49.a = paramObject2;
      return call_with_values.callWithValues(localframe49.lambda$Fn50, localframe49.lambda$Fn51);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 52)
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
    Object a;
    Object b;
    final ModuleMethod lambda$Fn50 = new ModuleMethod(this, 50, null, 0);
    final ModuleMethod lambda$Fn51;
    srfi1.frame48 staticLink;
    
    public frame49()
    {
      this$1 = new ModuleMethod(this, 51, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1565");
      this.lambda$Fn51 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 50) {
        return lambda67();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 51) {
        return lambda68(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda67()
    {
      Procedure localProcedure = this.staticLink.$Eq;
      Object localObject = this.a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.b;
      return srfi1.lsetDiff$PlIntersection$Ex$V(localProcedure, localObject, arrayOfObject);
    }
    
    Object lambda68(Object paramObject1, Object paramObject2)
    {
      srfi1.frame50 localframe50 = new srfi1.frame50();
      localframe50.staticLink = this;
      localframe50.a$Mnint$Mnb = paramObject2;
      if (lists.isNull(paramObject1))
      {
        Procedure localProcedure = this.staticLink.$Eq;
        Object localObject = this.b;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.a;
        return srfi1.lsetDifference$Ex$V(localProcedure, localObject, arrayOfObject2);
      }
      if (lists.isNull(localframe50.a$Mnint$Mnb))
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = this.b;
        arrayOfObject1[1] = this.a;
        return srfi1.append$Ex$V(arrayOfObject1);
      }
      return srfi1.pairFold$V(localframe50.lambda$Fn52, paramObject1, this.b, new Object[0]);
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
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 51)
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
    public static Object lambda11recur(Object paramObject)
    {
      srfi1.frame6 localframe6 = new srfi1.frame6();
      localframe6.lis = paramObject;
      if (srfi1.isNullList(localframe6.lis) != Boolean.FALSE)
      {
        Object[] arrayOfObject = new Object[5];
        arrayOfObject[0] = localframe6.lis;
        arrayOfObject[1] = localframe6.lis;
        arrayOfObject[2] = localframe6.lis;
        arrayOfObject[3] = localframe6.lis;
        arrayOfObject[4] = localframe6.lis;
        return misc.values(arrayOfObject);
      }
      localframe6.elt = lists.car.apply1(localframe6.lis);
      return call_with_values.callWithValues(localframe6.lambda$Fn7, localframe6.lambda$Fn8);
    }
  }
  
  public class frame50
    extends ModuleBody
  {
    Object a$Mnint$Mnb;
    final ModuleMethod lambda$Fn52;
    srfi1.frame49 staticLink;
    
    public frame50()
    {
      this$1 = new ModuleMethod(this, 49, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1568");
      this.lambda$Fn52 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 49) {
        return lambda69(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda69(Object paramObject1, Object paramObject2)
    {
      if (lists.member(lists.car.apply1(paramObject1), this.a$Mnint$Mnb, this.staticLink.staticLink.$Eq) != Boolean.FALSE) {
        return paramObject2;
      }
      try
      {
        Pair localPair = (Pair)paramObject1;
        lists.setCdr$Ex(localPair, paramObject2);
        return paramObject1;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-cdr!", 1, paramObject1);
      }
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
  
  public class frame51
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn53;
    LList lists;
    
    public frame51()
    {
      this$1 = new ModuleMethod(this, 54, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1579");
      this.lambda$Fn53 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 54)
      {
        if (lambda70(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda70(Object paramObject)
    {
      srfi1.frame52 localframe52 = new srfi1.frame52();
      localframe52.staticLink = this;
      localframe52.elt = paramObject;
      Object localObject = srfi1.any$V(localframe52.lambda$Fn54, this.lists, new Object[0]);
      Boolean localBoolean = Boolean.FALSE;
      int i = 0;
      if (localObject != localBoolean) {
        i = 1;
      }
      return 0x1 & i + 1;
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 54)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame52
    extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn54;
    srfi1.frame51 staticLink;
    
    public frame52()
    {
      this$1 = new ModuleMethod(this, 53, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1580");
      this.lambda$Fn54 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 53) {
        return lambda71(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda71(Object paramObject)
    {
      return lists.member(this.elt, paramObject, this.staticLink.$Eq);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 53)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame53
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn55;
    LList lists;
    
    public frame53()
    {
      this$1 = new ModuleMethod(this, 56, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1587");
      this.lambda$Fn55 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 56)
      {
        if (lambda72(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda72(Object paramObject)
    {
      srfi1.frame54 localframe54 = new srfi1.frame54();
      localframe54.staticLink = this;
      localframe54.elt = paramObject;
      Object localObject = srfi1.any$V(localframe54.lambda$Fn56, this.lists, new Object[0]);
      Boolean localBoolean = Boolean.FALSE;
      int i = 0;
      if (localObject != localBoolean) {
        i = 1;
      }
      return 0x1 & i + 1;
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 56)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame54
    extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn56;
    srfi1.frame53 staticLink;
    
    public frame54()
    {
      this$1 = new ModuleMethod(this, 55, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1588");
      this.lambda$Fn56 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 55) {
        return lambda73(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda73(Object paramObject)
    {
      return lists.member(this.elt, paramObject, this.staticLink.$Eq);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 55)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame55
    extends ModuleBody
  {
    Continuation abort;
    
    public Object lambda74recur(Object paramObject)
    {
      if (lists.isPair(paramObject))
      {
        Object localObject = lists.car.apply1(paramObject);
        if (srfi1.isNullList(localObject) != Boolean.FALSE) {
          return this.abort.apply1(LList.Empty);
        }
        return lists.cons(lists.cdr.apply1(localObject), lambda74recur(lists.cdr.apply1(paramObject)));
      }
      return LList.Empty;
    }
  }
  
  public class frame56
    extends ModuleBody
  {
    Object last$Mnelt;
    
    public Object lambda75recur(Object paramObject)
    {
      if (lists.isPair(paramObject)) {
        return lists.cons(lists.caar.apply1(paramObject), lambda75recur(lists.cdr.apply1(paramObject)));
      }
      return LList.list1(this.last$Mnelt);
    }
  }
  
  public class frame57
    extends ModuleBody
  {
    Continuation abort;
    
    public Object lambda76recur(Object paramObject)
    {
      srfi1.frame58 localframe58 = new srfi1.frame58();
      localframe58.staticLink = this;
      localframe58.lists = paramObject;
      if (lists.isPair(localframe58.lists)) {
        return call_with_values.callWithValues(localframe58.lambda$Fn57, localframe58.lambda$Fn58);
      }
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = LList.Empty;
      arrayOfObject[1] = LList.Empty;
      return misc.values(arrayOfObject);
    }
  }
  
  public class frame58
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn57 = new ModuleMethod(this, 61, null, 0);
    final ModuleMethod lambda$Fn58;
    Object lists;
    srfi1.frame57 staticLink;
    
    public frame58()
    {
      this$1 = new ModuleMethod(this, 62, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:762");
      this.lambda$Fn58 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 61) {
        return lambda77();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 62) {
        return lambda78(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda77()
    {
      return srfi1.car$PlCdr(this.lists);
    }
    
    Object lambda78(Object paramObject1, Object paramObject2)
    {
      srfi1.frame59 localframe59 = new srfi1.frame59();
      localframe59.staticLink = this;
      localframe59.list = paramObject1;
      localframe59.other$Mnlists = paramObject2;
      if (srfi1.isNullList(localframe59.list) != Boolean.FALSE) {
        return this.staticLink.abort.apply2(LList.Empty, LList.Empty);
      }
      return call_with_values.callWithValues(localframe59.lambda$Fn59, localframe59.lambda$Fn60);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 61)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 62)
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
    final ModuleMethod lambda$Fn59 = new ModuleMethod(this, 59, null, 0);
    final ModuleMethod lambda$Fn60;
    Object list;
    Object other$Mnlists;
    srfi1.frame58 staticLink;
    
    public frame59()
    {
      this$1 = new ModuleMethod(this, 60, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:764");
      this.lambda$Fn60 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 59) {
        return lambda79();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 60) {
        return lambda80(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda79()
    {
      return srfi1.car$PlCdr(this.list);
    }
    
    Object lambda80(Object paramObject1, Object paramObject2)
    {
      srfi1.frame60 localframe60 = new srfi1.frame60();
      localframe60.staticLink = this;
      localframe60.a = paramObject1;
      localframe60.d = paramObject2;
      return call_with_values.callWithValues(localframe60.lambda$Fn61, localframe60.lambda$Fn62);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 59)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 60)
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
    Object elt;
    final ModuleMethod lambda$Fn7 = new ModuleMethod(this, 7, null, 0);
    final ModuleMethod lambda$Fn8;
    Object lis;
    
    public frame6()
    {
      this$1 = new ModuleMethod(this, 8, null, 20485);
      this$1.setProperty("source-location", "srfi1.scm:654");
      this.lambda$Fn8 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 7) {
        return lambda12();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      if (paramModuleMethod.selector == 8) {
        return lambda13(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4]);
      }
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    }
    
    Object lambda12()
    {
      return srfi1.frame5.lambda11recur(lists.cdr.apply1(this.lis));
    }
    
    Object lambda13(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
    {
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = lists.cons(lists.car.apply1(this.elt), paramObject1);
      arrayOfObject[1] = lists.cons(lists.cadr.apply1(this.elt), paramObject2);
      arrayOfObject[2] = lists.cons(lists.caddr.apply1(this.elt), paramObject3);
      arrayOfObject[3] = lists.cons(lists.cadddr.apply1(this.elt), paramObject4);
      arrayOfObject[4] = lists.cons(lists.car.apply1(lists.cddddr.apply1(this.elt)), paramObject5);
      return misc.values(arrayOfObject);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 7)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 8)
      {
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      }
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    }
  }
  
  public class frame60
    extends ModuleBody
  {
    Object a;
    Object d;
    final ModuleMethod lambda$Fn61 = new ModuleMethod(this, 57, null, 0);
    final ModuleMethod lambda$Fn62;
    srfi1.frame59 staticLink;
    
    public frame60()
    {
      this$1 = new ModuleMethod(this, 58, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:765");
      this.lambda$Fn62 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 57) {
        return lambda81();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 58) {
        return lambda82(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda81()
    {
      return this.staticLink.staticLink.staticLink.lambda76recur(this.staticLink.other$Mnlists);
    }
    
    Object lambda82(Object paramObject1, Object paramObject2)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = lists.cons(this.a, paramObject1);
      arrayOfObject[1] = lists.cons(this.d, paramObject2);
      return misc.values(arrayOfObject);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 57)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 58)
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
    final ModuleMethod lambda$Fn63 = new ModuleMethod(this, 63, null, 0);
    Object lists;
    
    static Pair lambda84(Object paramObject1, Object paramObject2)
    {
      return lists.cons(paramObject1, paramObject2);
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 63) {
        return lambda83();
      }
      return super.apply0(paramModuleMethod);
    }
    
    Object lambda83()
    {
      return srfi1.$PcCars$PlCdrs(this.lists);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 63)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
  }
  
  public class frame62
    extends ModuleBody
  {
    Object cars$Mnfinal;
  }
  
  public class frame63
    extends ModuleBody
  {
    Continuation abort;
    srfi1.frame62 staticLink;
    
    public Object lambda85recur(Object paramObject)
    {
      srfi1.frame64 localframe64 = new srfi1.frame64();
      localframe64.staticLink = this;
      localframe64.lists = paramObject;
      if (lists.isPair(localframe64.lists)) {
        return call_with_values.callWithValues(localframe64.lambda$Fn65, localframe64.lambda$Fn66);
      }
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = LList.list1(this.staticLink.cars$Mnfinal);
      arrayOfObject[1] = LList.Empty;
      return misc.values(arrayOfObject);
    }
  }
  
  public class frame64
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn65 = new ModuleMethod(this, 68, null, 0);
    final ModuleMethod lambda$Fn66;
    Object lists;
    srfi1.frame63 staticLink;
    
    public frame64()
    {
      this$1 = new ModuleMethod(this, 69, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:783");
      this.lambda$Fn66 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 68) {
        return lambda86();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 69) {
        return lambda87(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda86()
    {
      return srfi1.car$PlCdr(this.lists);
    }
    
    Object lambda87(Object paramObject1, Object paramObject2)
    {
      srfi1.frame65 localframe65 = new srfi1.frame65();
      localframe65.staticLink = this;
      localframe65.list = paramObject1;
      localframe65.other$Mnlists = paramObject2;
      if (srfi1.isNullList(localframe65.list) != Boolean.FALSE) {
        return this.staticLink.abort.apply2(LList.Empty, LList.Empty);
      }
      return call_with_values.callWithValues(localframe65.lambda$Fn67, localframe65.lambda$Fn68);
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
  
  public class frame65
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn67 = new ModuleMethod(this, 66, null, 0);
    final ModuleMethod lambda$Fn68;
    Object list;
    Object other$Mnlists;
    srfi1.frame64 staticLink;
    
    public frame65()
    {
      this$1 = new ModuleMethod(this, 67, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:785");
      this.lambda$Fn68 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 66) {
        return lambda88();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 67) {
        return lambda89(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda88()
    {
      return srfi1.car$PlCdr(this.list);
    }
    
    Object lambda89(Object paramObject1, Object paramObject2)
    {
      srfi1.frame66 localframe66 = new srfi1.frame66();
      localframe66.staticLink = this;
      localframe66.a = paramObject1;
      localframe66.d = paramObject2;
      return call_with_values.callWithValues(localframe66.lambda$Fn69, localframe66.lambda$Fn70);
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
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 67)
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
  
  public class frame66
    extends ModuleBody
  {
    Object a;
    Object d;
    final ModuleMethod lambda$Fn69 = new ModuleMethod(this, 64, null, 0);
    final ModuleMethod lambda$Fn70;
    srfi1.frame65 staticLink;
    
    public frame66()
    {
      this$1 = new ModuleMethod(this, 65, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:786");
      this.lambda$Fn70 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 64) {
        return lambda90();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 65) {
        return lambda91(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda90()
    {
      return this.staticLink.staticLink.staticLink.lambda85recur(this.staticLink.other$Mnlists);
    }
    
    Object lambda91(Object paramObject1, Object paramObject2)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = lists.cons(this.a, paramObject1);
      arrayOfObject[1] = lists.cons(this.d, paramObject2);
      return misc.values(arrayOfObject);
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
  
  public class frame67
    extends ModuleBody
  {
    public static Object lambda92recur(Object paramObject)
    {
      srfi1.frame68 localframe68 = new srfi1.frame68();
      localframe68.lists = paramObject;
      if (lists.isPair(localframe68.lists)) {
        return call_with_values.callWithValues(localframe68.lambda$Fn71, localframe68.lambda$Fn72);
      }
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = LList.Empty;
      arrayOfObject[1] = LList.Empty;
      return misc.values(arrayOfObject);
    }
  }
  
  public class frame68
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn71 = new ModuleMethod(this, 74, null, 0);
    final ModuleMethod lambda$Fn72;
    Object lists;
    
    public frame68()
    {
      this$1 = new ModuleMethod(this, 75, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:794");
      this.lambda$Fn72 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 74) {
        return lambda93();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 75) {
        return lambda94(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda93()
    {
      return srfi1.car$PlCdr(this.lists);
    }
    
    Object lambda94(Object paramObject1, Object paramObject2)
    {
      srfi1.frame69 localframe69 = new srfi1.frame69();
      localframe69.staticLink = this;
      localframe69.list = paramObject1;
      localframe69.other$Mnlists = paramObject2;
      return call_with_values.callWithValues(localframe69.lambda$Fn73, localframe69.lambda$Fn74);
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
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 75)
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
    final ModuleMethod lambda$Fn73 = new ModuleMethod(this, 72, null, 0);
    final ModuleMethod lambda$Fn74;
    Object list;
    Object other$Mnlists;
    srfi1.frame68 staticLink;
    
    public frame69()
    {
      this$1 = new ModuleMethod(this, 73, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:795");
      this.lambda$Fn74 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 72) {
        return lambda95();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 73) {
        return lambda96(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda95()
    {
      return srfi1.car$PlCdr(this.list);
    }
    
    Object lambda96(Object paramObject1, Object paramObject2)
    {
      srfi1.frame70 localframe70 = new srfi1.frame70();
      localframe70.staticLink = this;
      localframe70.a = paramObject1;
      localframe70.d = paramObject2;
      return call_with_values.callWithValues(localframe70.lambda$Fn75, localframe70.lambda$Fn76);
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
  
  public class frame7
    extends ModuleBody
  {
    Procedure kons;
    
    public Object lambda14lp(Object paramObject1, Object paramObject2)
    {
      srfi1.frame8 localframe8 = new srfi1.frame8();
      localframe8.staticLink = this;
      localframe8.lists = paramObject1;
      localframe8.ans = paramObject2;
      return call_with_values.callWithValues(localframe8.lambda$Fn9, localframe8.lambda$Fn10);
    }
  }
  
  public class frame70
    extends ModuleBody
  {
    Object a;
    Object d;
    final ModuleMethod lambda$Fn75 = new ModuleMethod(this, 70, null, 0);
    final ModuleMethod lambda$Fn76;
    srfi1.frame69 staticLink;
    
    public frame70()
    {
      this$1 = new ModuleMethod(this, 71, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:796");
      this.lambda$Fn76 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 70) {
        return lambda97();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 71) {
        return lambda98(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda97()
    {
      return srfi1.frame67.lambda92recur(this.staticLink.other$Mnlists);
    }
    
    Object lambda98(Object paramObject1, Object paramObject2)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = lists.cons(this.a, paramObject1);
      arrayOfObject[1] = lists.cons(this.d, paramObject2);
      return misc.values(arrayOfObject);
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
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 71)
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
    final ModuleMethod lambda$Fn77 = new ModuleMethod(this, 76, null, 0);
    Object lists;
    
    static Pair lambda100(Object paramObject1, Object paramObject2)
    {
      return lists.cons(paramObject1, paramObject2);
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 76) {
        return lambda99();
      }
      return super.apply0(paramModuleMethod);
    }
    
    Object lambda99()
    {
      return srfi1.$PcCars$PlCdrs$SlNoTest(this.lists);
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
  }
  
  public class frame72
    extends ModuleBody
  {
    Object $Eq;
    final ModuleMethod lambda$Fn79;
    Object lis2;
    
    public frame72()
    {
      this$1 = new ModuleMethod(this, 77, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1443");
      this.lambda$Fn79 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 77) {
        return lambda101(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda101(Object paramObject)
    {
      Object localObject1 = this.lis2;
      Object localObject2 = this.$Eq;
      try
      {
        Procedure localProcedure = (Procedure)localObject2;
        return lists.member(paramObject, localObject1, localProcedure);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "member", 3, localObject2);
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 77)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame8
    extends ModuleBody
  {
    Object ans;
    final ModuleMethod lambda$Fn10;
    final ModuleMethod lambda$Fn9 = new ModuleMethod(this, 9, null, 0);
    Object lists;
    srfi1.frame7 staticLink;
    
    public frame8()
    {
      this$1 = new ModuleMethod(this, 10, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:859");
      this.lambda$Fn10 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 9) {
        return lambda15();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 10) {
        return lambda16(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda15()
    {
      return srfi1.$PcCars$PlCdrs$Pl(this.lists, this.ans);
    }
    
    Object lambda16(Object paramObject1, Object paramObject2)
    {
      if (lists.isNull(paramObject1)) {
        return this.ans;
      }
      return this.staticLink.lambda14lp(paramObject2, Scheme.apply.apply2(this.staticLink.kons, paramObject1));
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 9)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
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
  
  public class frame9
    extends ModuleBody
  {
    Object knil;
    Procedure kons;
    
    public Object lambda17recur(Object paramObject)
    {
      Object localObject = srfi1.$PcCdrs(paramObject);
      if (lists.isNull(localObject)) {
        return this.knil;
      }
      return Scheme.apply.apply2(this.kons, srfi1.$PcCars$Pl(paramObject, lambda17recur(localObject)));
    }
    
    public Object lambda18recur(Object paramObject)
    {
      if (srfi1.isNullList(paramObject) != Boolean.FALSE) {
        return this.knil;
      }
      Object localObject = lists.car.apply1(paramObject);
      return this.kons.apply2(localObject, lambda18recur(lists.cdr.apply1(paramObject)));
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.srfi1
 * JD-Core Version:    0.7.0.1
 */