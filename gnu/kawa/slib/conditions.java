package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.IsEq;
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
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;
import kawa.standard.append;

public class conditions
  extends ModuleBody
{
  public static Object $Amcondition;
  public static Object $Amerror;
  public static Object $Ammessage;
  public static Object $Amserious;
  static final Class $Lscondition$Mntype$Gr;
  public static final Class $Prvt$$Lscondition$Gr;
  public static final ModuleMethod $Prvt$type$Mnfield$Mnalist$Mn$Grcondition;
  public static final conditions $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SyntaxRules Lit14;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SyntaxRules Lit19;
  static final PairWithPosition Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22 = (SimpleSymbol)new SimpleSymbol("thing").readResolve();
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SyntaxRules Lit9;
  public static final Macro condition;
  public static final ModuleMethod condition$Mnhas$Mntype$Qu;
  public static final ModuleMethod condition$Mnref;
  static final Macro condition$Mntype$Mnfield$Mnalist;
  public static final ModuleMethod condition$Mntype$Qu;
  public static final ModuleMethod condition$Qu;
  public static final Macro define$Mncondition$Mntype;
  public static final ModuleMethod extract$Mncondition;
  public static final ModuleMethod make$Mncompound$Mncondition;
  public static final ModuleMethod make$Mncondition;
  public static final ModuleMethod make$Mncondition$Mntype;
  
  static
  {
    Lit21 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("type-field-alist->condition").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("condition").readResolve();
    Lit18 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("", new Object[0], 3);
    Object[] arrayOfObject2 = new Object[4];
    arrayOfObject2[0] = Lit20;
    arrayOfObject2[1] = ((SimpleSymbol)new SimpleSymbol("list").readResolve());
    arrayOfObject2[2] = ((SimpleSymbol)new SimpleSymbol("cons").readResolve());
    arrayOfObject2[3] = Lit21;
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\003\005\005", "\021\030\004\b\021\030\f\b\005\021\030\024\t\003\b\021\030\f\b\r\021\030\024)\021\030\034\b\013\b\023", arrayOfObject2, 2);
    Lit19 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 3);
    Lit17 = (SimpleSymbol)new SimpleSymbol("extract-condition").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("make-compound-condition").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("condition-ref").readResolve();
    Object[] arrayOfObject3 = new Object[1];
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("condition-type-field-alist").readResolve();
    Lit13 = localSimpleSymbol2;
    arrayOfObject3[0] = localSimpleSymbol2;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject4 = new Object[3];
    arrayOfObject4[0] = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("$lookup$").readResolve(), Pair.make((SimpleSymbol)new SimpleSymbol("*").readResolve(), Pair.make(Pair.make((SimpleSymbol)new SimpleSymbol("quasiquote").readResolve(), Pair.make((SimpleSymbol)new SimpleSymbol(".type-field-alist").readResolve(), LList.Empty)), LList.Empty)), "conditions.scm", 581639);
    arrayOfObject4[1] = ((SimpleSymbol)new SimpleSymbol("as").readResolve());
    arrayOfObject4[2] = ((SimpleSymbol)new SimpleSymbol("<condition>").readResolve());
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern2, "\001", "\021\030\004\b\021\030\f\021\030\024\b\003", arrayOfObject4, 0);
    Lit14 = new SyntaxRules(arrayOfObject3, arrayOfSyntaxRule2, 1);
    Lit12 = (SimpleSymbol)new SimpleSymbol("condition-has-type?").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("make-condition").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("condition?").readResolve();
    Object[] arrayOfObject5 = new Object[1];
    SimpleSymbol localSimpleSymbol3 = (SimpleSymbol)new SimpleSymbol("define-condition-type").readResolve();
    Lit8 = localSimpleSymbol3;
    arrayOfObject5[0] = localSimpleSymbol3;
    SyntaxRule[] arrayOfSyntaxRule3 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("\f\030\f\007\f\017\f\027-\f\037\f'\b\030\020\b", new Object[0], 5);
    Object[] arrayOfObject6 = new Object[13];
    arrayOfObject6[0] = ((SimpleSymbol)new SimpleSymbol("begin").readResolve());
    arrayOfObject6[1] = ((SimpleSymbol)new SimpleSymbol("define").readResolve());
    SimpleSymbol localSimpleSymbol4 = (SimpleSymbol)new SimpleSymbol("make-condition-type").readResolve();
    Lit7 = localSimpleSymbol4;
    arrayOfObject6[2] = localSimpleSymbol4;
    arrayOfObject6[3] = Lit21;
    arrayOfObject6[4] = PairWithPosition.make(Lit22, LList.Empty, "conditions.scm", 327708);
    arrayOfObject6[5] = ((SimpleSymbol)new SimpleSymbol("and").readResolve());
    arrayOfObject6[6] = PairWithPosition.make(Lit10, PairWithPosition.make(Lit22, LList.Empty, "conditions.scm", 331803), "conditions.scm", 331791);
    arrayOfObject6[7] = Lit12;
    arrayOfObject6[8] = Lit22;
    arrayOfObject6[9] = PairWithPosition.make(Lit18, LList.Empty, "conditions.scm", 339996);
    arrayOfObject6[10] = Lit15;
    arrayOfObject6[11] = Lit17;
    arrayOfObject6[12] = Lit18;
    arrayOfSyntaxRule3[0] = new SyntaxRule(localSyntaxPattern3, "\001\001\001\003\003", "\021\030\004É\021\030\f\t\003\b\021\030\024)\021\030\034\b\003\t\013\b\021\030\034\b\b\035\033Á\021\030\f!\t\023\030$\b\021\030,\021\0304\b\021\030<\021\030D\b\003\b%\021\030\f!\t#\030L\b\021\030TA\021\030\\\021\030d\b\003\b\021\030\034\b\033", arrayOfObject6, 1);
    Lit9 = new SyntaxRules(arrayOfObject5, arrayOfSyntaxRule3, 5);
    Lit6 = (SimpleSymbol)new SimpleSymbol("condition-type?").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("message").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("&error").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("&serious").readResolve();
    Lit2 = PairWithPosition.make(Lit5, LList.Empty, "conditions.scm", 925699);
    Lit1 = (SimpleSymbol)new SimpleSymbol("&message").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("&condition").readResolve();
    $instance = new conditions();
    $Lscondition$Mntype$Gr = condition.Mntype.class;
    conditions localconditions = $instance;
    condition$Mntype$Qu = new ModuleMethod(localconditions, 2, Lit6, 4097);
    make$Mncondition$Mntype = new ModuleMethod(localconditions, 3, Lit7, 12291);
    define$Mncondition$Mntype = Macro.make(Lit8, Lit9, $instance);
    $Prvt$$Lscondition$Gr = condition.class;
    condition$Qu = new ModuleMethod(localconditions, 4, Lit10, 4097);
    make$Mncondition = new ModuleMethod(localconditions, 5, Lit11, -4095);
    condition$Mnhas$Mntype$Qu = new ModuleMethod(localconditions, 6, Lit12, 8194);
    condition$Mntype$Mnfield$Mnalist = Macro.make(Lit13, Lit14, $instance);
    condition$Mnref = new ModuleMethod(localconditions, 7, Lit15, 8194);
    make$Mncompound$Mncondition = new ModuleMethod(localconditions, 8, Lit16, -4095);
    extract$Mncondition = new ModuleMethod(localconditions, 9, Lit17, 8194);
    condition = Macro.make(Lit18, Lit19, $instance);
    $Prvt$type$Mnfield$Mnalist$Mn$Grcondition = new ModuleMethod(localconditions, 10, Lit20, 4097);
    $instance.run();
  }
  
  public conditions()
  {
    ModuleInfo.register(this);
  }
  
  static Object checkConditionTypeFieldAlist(Object paramObject)
  {
    Object localObject1 = paramObject;
    Object localObject2;
    if (!lists.isNull(localObject1))
    {
      localObject2 = lists.car.apply1(localObject1);
      localObject3 = lists.car.apply1(localObject2);
    }
    for (;;)
    {
      Object localObject6;
      Object localObject9;
      Object localObject11;
      Object localObject13;
      try
      {
        localMntype1 = (condition.Mntype)localObject3;
        Object localObject4 = lists.cdr.apply1(localObject2);
        localObject5 = LList.Empty;
        localObject6 = localObject4;
        if (localObject6 == LList.Empty)
        {
          LList localLList = LList.reverseInPlace(localObject5);
          Object localObject8 = localMntype1.all$Mnfields;
          localObject9 = srfi1.lsetDifference$V(Scheme.isEq, localObject8, new Object[] { localLList });
          if (localObject9 != LList.Empty) {
            continue;
          }
          localObject1 = lists.cdr.apply1(localObject1);
        }
      }
      catch (ClassCastException localClassCastException1)
      {
        condition.Mntype localMntype1;
        Object localObject5;
        Pair localPair1;
        Object localObject7;
        Pair localPair2;
        Object localObject10;
        Object localObject12;
        condition.Mntype localMntype2;
        condition.Mntype localMntype3;
        boolean bool;
        WrongType localWrongType1 = new WrongType(localClassCastException1, "type", -2, localObject3);
        throw localWrongType1;
      }
      try
      {
        localPair1 = (Pair)localObject6;
        localObject7 = localPair1.getCdr();
        localObject5 = Pair.make(lists.car.apply1(localPair1.getCar()), localObject5);
        localObject6 = localObject7;
      }
      catch (ClassCastException localClassCastException2)
      {
        WrongType localWrongType2 = new WrongType(localClassCastException2, "arg0", -2, localObject6);
        throw localWrongType2;
      }
      try
      {
        localPair2 = (Pair)localObject9;
        localObject10 = localPair2.getCar();
        localObject11 = conditionTypeFieldSupertype(localMntype1, localObject10);
        localObject12 = paramObject;
        localObject13 = lists.car.apply1(lists.car.apply1(localObject12));
      }
      catch (ClassCastException localClassCastException3)
      {
        WrongType localWrongType3 = new WrongType(localClassCastException3, "arg0", -2, localObject9);
        throw localWrongType3;
      }
      try
      {
        localMntype2 = (condition.Mntype)localObject13;
      }
      catch (ClassCastException localClassCastException4)
      {
        WrongType localWrongType4 = new WrongType(localClassCastException4, "condition-subtype?", 0, localObject13);
        throw localWrongType4;
      }
      try
      {
        localMntype3 = (condition.Mntype)localObject11;
        bool = isConditionSubtype(localMntype2, localMntype3);
        if (bool)
        {
          if (!bool) {
            misc.error$V("missing field in condition construction", new Object[] { localMntype1, localObject10 });
          }
          localObject9 = localPair2.getCdr();
        }
        else
        {
          localObject12 = lists.cdr.apply1(localObject12);
        }
      }
      catch (ClassCastException localClassCastException5)
      {
        WrongType localWrongType5 = new WrongType(localClassCastException5, "condition-subtype?", 1, localObject11);
        throw localWrongType5;
      }
    }
    return Values.empty;
  }
  
  /* Error */
  static Object conditionMessage(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 257	gnu/kawa/slib/condition
    //   4: astore_2
    //   5: getstatic 370	gnu/kawa/slib/conditions:$Ammessage	Ljava/lang/Object;
    //   8: astore_3
    //   9: aload_3
    //   10: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   13: astore 5
    //   15: aload_2
    //   16: aload 5
    //   18: invokestatic 374	gnu/kawa/slib/conditions:extractCondition	(Lgnu/kawa/slib/condition;Lgnu/kawa/slib/condition$Mntype;)Lgnu/kawa/slib/condition;
    //   21: getstatic 212	gnu/kawa/slib/conditions:Lit5	Lgnu/mapping/SimpleSymbol;
    //   24: invokestatic 378	gnu/kawa/slib/conditions:conditionRef	(Lgnu/kawa/slib/condition;Ljava/lang/Object;)Ljava/lang/Object;
    //   27: areturn
    //   28: astore_1
    //   29: new 358	gnu/mapping/WrongType
    //   32: dup
    //   33: aload_1
    //   34: ldc 112
    //   36: iconst_0
    //   37: aload_0
    //   38: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   41: athrow
    //   42: astore 4
    //   44: new 358	gnu/mapping/WrongType
    //   47: dup
    //   48: aload 4
    //   50: ldc 112
    //   52: iconst_1
    //   53: aload_3
    //   54: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramObject	Object
    //   28	6	1	localClassCastException1	ClassCastException
    //   4	12	2	localcondition	condition
    //   8	46	3	localObject	Object
    //   42	7	4	localClassCastException2	ClassCastException
    //   13	4	5	localMntype	condition.Mntype
    // Exception table:
    //   from	to	target	type
    //   0	5	28	java/lang/ClassCastException
    //   9	15	42	java/lang/ClassCastException
  }
  
  public static Object conditionRef(condition paramcondition, Object paramObject)
  {
    return typeFieldAlistRef(paramcondition.type$Mnfield$Mnalist, paramObject);
  }
  
  static Object conditionTypeFieldSupertype(condition.Mntype paramMntype, Object paramObject)
  {
    for (;;)
    {
      if (paramMntype == Boolean.FALSE) {
        paramMntype = Boolean.FALSE;
      }
      while (lists.memq(paramObject, paramMntype.fields) != Boolean.FALSE) {
        return paramMntype;
      }
      paramMntype = (condition.Mntype)paramMntype.supertype;
    }
  }
  
  static Object conditionTypes(Object paramObject)
  {
    Object localObject1 = ((condition)paramObject).type$Mnfield$Mnalist;
    Object localObject2 = LList.Empty;
    for (;;)
    {
      if (localObject1 == LList.Empty) {
        return LList.reverseInPlace(localObject2);
      }
      try
      {
        Pair localPair = (Pair)localObject1;
        Object localObject3 = localPair.getCdr();
        localObject2 = Pair.make(lists.car.apply1(localPair.getCar()), localObject2);
        localObject1 = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject1);
      }
    }
  }
  
  public static condition extractCondition(condition paramcondition, condition.Mntype paramMntype)
  {
    frame localframe = new frame();
    localframe.type = paramMntype;
    Object localObject1 = srfi1.find(localframe.lambda$Fn1, paramcondition.type$Mnfield$Mnalist);
    if (localObject1 == Boolean.FALSE)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramcondition;
      arrayOfObject[1] = localframe.type;
      misc.error$V("extract-condition: invalid condition type", arrayOfObject);
    }
    condition.Mntype localMntype = localframe.type;
    Object localObject2 = localframe.type.all$Mnfields;
    Object localObject3 = LList.Empty;
    for (;;)
    {
      if (localObject2 == LList.Empty) {
        return new condition(LList.list1(lists.cons(localMntype, LList.reverseInPlace(localObject3))));
      }
      try
      {
        Pair localPair = (Pair)localObject2;
        Object localObject4 = localPair.getCdr();
        localObject3 = Pair.make(lists.assq(localPair.getCar(), lists.cdr.apply1(localObject1)), localObject3);
        localObject2 = localObject4;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject2);
      }
    }
  }
  
  public static boolean isCondition(Object paramObject)
  {
    return paramObject instanceof condition;
  }
  
  public static boolean isConditionHasType(Object paramObject, condition.Mntype paramMntype)
  {
    Object localObject1 = conditionTypes(paramObject);
    for (;;)
    {
      Object localObject2 = lists.car.apply1(localObject1);
      try
      {
        condition.Mntype localMntype = (condition.Mntype)localObject2;
        boolean bool = isConditionSubtype(localMntype, paramMntype);
        if (bool) {
          return bool;
        }
        localObject1 = lists.cdr.apply1(localObject1);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "condition-subtype?", 0, localObject2);
      }
    }
  }
  
  static boolean isConditionSubtype(condition.Mntype paramMntype1, condition.Mntype paramMntype2)
  {
    for (;;)
    {
      if (paramMntype1 == Boolean.FALSE) {
        return false;
      }
      if (paramMntype1 == paramMntype2) {
        return true;
      }
      paramMntype1 = (condition.Mntype)paramMntype1.supertype;
    }
  }
  
  public static boolean isConditionType(Object paramObject)
  {
    return paramObject instanceof condition.Mntype;
  }
  
  static boolean isError(Object paramObject)
  {
    boolean bool = isCondition(paramObject);
    Object localObject;
    if (bool) {
      localObject = $Amerror;
    }
    try
    {
      condition.Mntype localMntype = (condition.Mntype)localObject;
      bool = isConditionHasType(paramObject, localMntype);
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "condition-has-type?", 1, localObject);
    }
  }
  
  static boolean isMessageCondition(Object paramObject)
  {
    boolean bool = isCondition(paramObject);
    Object localObject;
    if (bool) {
      localObject = $Ammessage;
    }
    try
    {
      condition.Mntype localMntype = (condition.Mntype)localObject;
      bool = isConditionHasType(paramObject, localMntype);
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "condition-has-type?", 1, localObject);
    }
  }
  
  static boolean isSeriousCondition(Object paramObject)
  {
    boolean bool = isCondition(paramObject);
    Object localObject;
    if (bool) {
      localObject = $Amserious;
    }
    try
    {
      condition.Mntype localMntype = (condition.Mntype)localObject;
      bool = isConditionHasType(paramObject, localMntype);
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "condition-has-type?", 1, localObject);
    }
  }
  
  public static Object lambda1label(Object paramObject)
  {
    if (lists.isNull(paramObject)) {
      return LList.Empty;
    }
    return lists.cons(lists.cons(lists.car.apply1(paramObject), lists.cadr.apply1(paramObject)), lambda1label(lists.cddr.apply1(paramObject)));
  }
  
  public static condition makeCompoundCondition$V(Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    Apply localApply = Scheme.apply;
    append localappend = append.append;
    Object localObject1 = lists.cons(paramObject, localLList);
    Object localObject2 = LList.Empty;
    for (;;)
    {
      if (localObject1 == LList.Empty) {
        return new condition(localApply.apply2(localappend, LList.reverseInPlace(localObject2)));
      }
      try
      {
        Pair localPair = (Pair)localObject1;
        Object localObject3 = localPair.getCdr();
        localObject2 = Pair.make(Scheme.applyToArgs.apply2(condition$Mntype$Mnfield$Mnalist, localPair.getCar()), localObject2);
        localObject1 = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject1);
      }
    }
  }
  
  public static condition makeCondition$V(condition.Mntype paramMntype, Object[] paramArrayOfObject)
  {
    Object localObject1 = lambda1label(LList.makeList(paramArrayOfObject, 0));
    IsEq localIsEq = Scheme.isEq;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramMntype.all$Mnfields;
    Object localObject2 = LList.Empty;
    Object localObject3 = localObject1;
    for (;;)
    {
      if (localObject3 == LList.Empty)
      {
        arrayOfObject[1] = LList.reverseInPlace(localObject2);
        if (srfi1.lset$Eq$V(localIsEq, arrayOfObject) == Boolean.FALSE) {
          misc.error$V("condition fields don't match condition type", new Object[0]);
        }
        return new condition(LList.list1(lists.cons(paramMntype, localObject1)));
      }
      try
      {
        Pair localPair = (Pair)localObject3;
        Object localObject4 = localPair.getCdr();
        localObject2 = Pair.make(lists.car.apply1(localPair.getCar()), localObject2);
        localObject3 = localObject4;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject3);
      }
    }
  }
  
  public static condition.Mntype makeConditionType(Symbol paramSymbol, condition.Mntype paramMntype, Object paramObject)
  {
    if (!lists.isNull(srfi1.lsetIntersection$V(Scheme.isEq, paramMntype.all$Mnfields, new Object[] { paramObject }))) {
      misc.error$V("duplicate field name", new Object[0]);
    }
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramMntype.all$Mnfields;
    arrayOfObject[1] = paramObject;
    return new condition.Mntype(paramSymbol, paramMntype, paramObject, append.append$V(arrayOfObject));
  }
  
  /* Error */
  public static condition typeFieldAlist$To$Condition(Object paramObject)
  {
    // Byte code:
    //   0: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   3: astore_1
    //   4: aload_0
    //   5: astore_2
    //   6: aload_1
    //   7: astore_3
    //   8: aload_2
    //   9: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   12: if_acmpne +15 -> 27
    //   15: new 257	gnu/kawa/slib/condition
    //   18: dup
    //   19: aload_3
    //   20: invokestatic 313	gnu/lists/LList:reverseInPlace	(Ljava/lang/Object;)Lgnu/lists/LList;
    //   23: invokespecial 423	gnu/kawa/slib/condition:<init>	(Ljava/lang/Object;)V
    //   26: areturn
    //   27: aload_2
    //   28: checkcast 144	gnu/lists/Pair
    //   31: astore 5
    //   33: aload 5
    //   35: invokevirtual 331	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   38: astore 6
    //   40: aload 5
    //   42: invokevirtual 334	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   45: astore 7
    //   47: getstatic 301	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   50: aload 7
    //   52: invokevirtual 306	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: astore 8
    //   57: getstatic 301	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   60: aload 7
    //   62: invokevirtual 306	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   68: getfield 316	gnu/kawa/slib/condition$Mntype:all$Mnfields	Ljava/lang/Object;
    //   71: astore 9
    //   73: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   76: astore 10
    //   78: aload 9
    //   80: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   83: if_acmpne +24 -> 107
    //   86: aload 8
    //   88: aload 10
    //   90: invokestatic 313	gnu/lists/LList:reverseInPlace	(Ljava/lang/Object;)Lgnu/lists/LList;
    //   93: invokestatic 417	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   96: aload_3
    //   97: invokestatic 148	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   100: astore_3
    //   101: aload 6
    //   103: astore_2
    //   104: goto -96 -> 8
    //   107: aload 9
    //   109: checkcast 144	gnu/lists/Pair
    //   112: astore 12
    //   114: aload 12
    //   116: invokevirtual 331	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   119: astore 13
    //   121: aload 12
    //   123: invokevirtual 334	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   126: astore 14
    //   128: aload 14
    //   130: getstatic 309	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   133: aload 7
    //   135: invokevirtual 306	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   138: invokestatic 426	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: astore 15
    //   143: aload 15
    //   145: getstatic 391	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   148: if_acmpeq +19 -> 167
    //   151: aload 15
    //   153: aload 10
    //   155: invokestatic 148	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   158: astore 10
    //   160: aload 13
    //   162: astore 9
    //   164: goto -86 -> 78
    //   167: aload 14
    //   169: aload_0
    //   170: aload 14
    //   172: invokestatic 385	gnu/kawa/slib/conditions:typeFieldAlistRef	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: invokestatic 417	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   178: astore 15
    //   180: goto -29 -> 151
    //   183: astore 4
    //   185: new 358	gnu/mapping/WrongType
    //   188: dup
    //   189: aload 4
    //   191: ldc_w 365
    //   194: bipush 254
    //   196: aload_2
    //   197: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   200: athrow
    //   201: astore 11
    //   203: new 358	gnu/mapping/WrongType
    //   206: dup
    //   207: aload 11
    //   209: ldc_w 365
    //   212: bipush 254
    //   214: aload 9
    //   216: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramObject	Object
    //   3	4	1	localLList	LList
    //   5	192	2	localObject1	Object
    //   7	94	3	localObject2	Object
    //   183	7	4	localClassCastException1	ClassCastException
    //   31	10	5	localPair1	Pair
    //   38	64	6	localObject3	Object
    //   45	89	7	localObject4	Object
    //   55	32	8	localObject5	Object
    //   71	144	9	localObject6	Object
    //   76	83	10	localObject7	Object
    //   201	7	11	localClassCastException2	ClassCastException
    //   112	10	12	localPair2	Pair
    //   119	42	13	localObject8	Object
    //   126	45	14	localObject9	Object
    //   141	38	15	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   27	33	183	java/lang/ClassCastException
    //   107	114	201	java/lang/ClassCastException
  }
  
  static Object typeFieldAlistRef(Object paramObject1, Object paramObject2)
  {
    for (;;)
    {
      if (lists.isNull(paramObject1)) {
        return misc.error$V("type-field-alist-ref: field not found", new Object[] { paramObject1, paramObject2 });
      }
      Object localObject = lists.assq(paramObject2, lists.cdr.apply1(lists.car.apply1(paramObject1)));
      if (localObject != Boolean.FALSE) {
        return lists.cdr.apply1(localObject);
      }
      paramObject1 = lists.cdr.apply1(paramObject1);
    }
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 2: 
      if (isConditionType(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 4: 
      if (isCondition(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    return typeFieldAlist$To$Condition(paramObject);
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    case 8: 
    default: 
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    try
    {
      condition.Mntype localMntype2 = (condition.Mntype)paramObject2;
      if (isConditionHasType(paramObject1, localMntype2)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException4)
    {
      try
      {
        condition localcondition2 = (condition)paramObject1;
        return conditionRef(localcondition2, paramObject2);
      }
      catch (ClassCastException localClassCastException3)
      {
        condition localcondition1;
        condition.Mntype localMntype1;
        throw new WrongType(localClassCastException3, "condition-ref", 1, paramObject1);
      }
      try
      {
        localcondition1 = (condition)paramObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "extract-condition", 1, paramObject1);
      }
      try
      {
        localMntype1 = (condition.Mntype)paramObject2;
        return extractCondition(localcondition1, localMntype1);
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "extract-condition", 2, paramObject2);
      }
      localClassCastException4 = localClassCastException4;
      throw new WrongType(localClassCastException4, "condition-has-type?", 2, paramObject2);
    }
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramModuleMethod.selector == 3) {}
    try
    {
      localSymbol = (Symbol)paramObject1;
    }
    catch (ClassCastException localClassCastException1)
    {
      Symbol localSymbol;
      condition.Mntype localMntype;
      throw new WrongType(localClassCastException1, "make-condition-type", 1, paramObject1);
    }
    try
    {
      localMntype = (condition.Mntype)paramObject2;
      return makeConditionType(localSymbol, localMntype, paramObject3);
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "make-condition-type", 2, paramObject2);
    }
    return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
  }
  
  /* Error */
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 506	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+32 -> 36, 5:+39->43, 6:+32->36, 7:+32->36, 8:+94->98
    //   37: aload_1
    //   38: aload_2
    //   39: invokespecial 530	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   42: areturn
    //   43: aload_2
    //   44: iconst_0
    //   45: aaload
    //   46: astore 6
    //   48: aload 6
    //   50: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   53: astore 8
    //   55: iconst_m1
    //   56: aload_2
    //   57: arraylength
    //   58: iadd
    //   59: istore 9
    //   61: iload 9
    //   63: anewarray 80	java/lang/Object
    //   66: astore 10
    //   68: iinc 9 255
    //   71: iload 9
    //   73: ifge +11 -> 84
    //   76: aload 8
    //   78: aload 10
    //   80: invokestatic 532	gnu/kawa/slib/conditions:makeCondition$V	(Lgnu/kawa/slib/condition$Mntype;[Ljava/lang/Object;)Lgnu/kawa/slib/condition;
    //   83: areturn
    //   84: aload 10
    //   86: iload 9
    //   88: aload_2
    //   89: iload 9
    //   91: iconst_1
    //   92: iadd
    //   93: aaload
    //   94: aastore
    //   95: goto -27 -> 68
    //   98: aload_2
    //   99: iconst_0
    //   100: aaload
    //   101: astore_3
    //   102: iconst_m1
    //   103: aload_2
    //   104: arraylength
    //   105: iadd
    //   106: istore 4
    //   108: iload 4
    //   110: anewarray 80	java/lang/Object
    //   113: astore 5
    //   115: iinc 4 255
    //   118: iload 4
    //   120: ifge +10 -> 130
    //   123: aload_3
    //   124: aload 5
    //   126: invokestatic 534	gnu/kawa/slib/conditions:makeCompoundCondition$V	(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/kawa/slib/condition;
    //   129: areturn
    //   130: aload 5
    //   132: iload 4
    //   134: aload_2
    //   135: iload 4
    //   137: iconst_1
    //   138: iadd
    //   139: aaload
    //   140: aastore
    //   141: goto -26 -> 115
    //   144: astore 7
    //   146: new 358	gnu/mapping/WrongType
    //   149: dup
    //   150: aload 7
    //   152: ldc 172
    //   154: iconst_1
    //   155: aload 6
    //   157: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	conditions
    //   0	161	1	paramModuleMethod	ModuleMethod
    //   0	161	2	paramArrayOfObject	Object[]
    //   101	23	3	localObject1	Object
    //   106	33	4	i	int
    //   113	18	5	arrayOfObject1	Object[]
    //   46	110	6	localObject2	Object
    //   144	7	7	localClassCastException	ClassCastException
    //   53	24	8	localMntype	condition.Mntype
    //   59	34	9	j	int
    //   66	19	10	arrayOfObject2	Object[]
    // Exception table:
    //   from	to	target	type
    //   48	55	144	java/lang/ClassCastException
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 10: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 4: 
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
    int i = -786431;
    switch (paramModuleMethod.selector)
    {
    case 8: 
    default: 
      i = super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 9: 
    case 7: 
      do
      {
        do
        {
          return i;
        } while (!(paramObject1 instanceof condition));
        paramCallContext.value1 = paramObject1;
        if (!(paramObject2 instanceof condition.Mntype)) {
          return -786430;
        }
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      } while (!(paramObject1 instanceof condition));
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    paramCallContext.value1 = paramObject1;
    if (!(paramObject2 instanceof condition.Mntype)) {
      return -786430;
    }
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }
  
  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 3)
    {
      if (!(paramObject1 instanceof Symbol)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof condition.Mntype)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    }
    return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 6: 
    case 7: 
    default: 
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 8: 
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
  
  /* Error */
  public final void run(CallContext paramCallContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 579	gnu/mapping/CallContext:consumer	Lgnu/lists/Consumer;
    //   4: pop
    //   5: new 237	gnu/kawa/slib/condition$Mntype
    //   8: dup
    //   9: getstatic 231	gnu/kawa/slib/conditions:Lit0	Lgnu/mapping/SimpleSymbol;
    //   12: getstatic 391	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   15: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   18: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   21: invokespecial 497	gnu/kawa/slib/condition$Mntype:<init>	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   24: putstatic 581	gnu/kawa/slib/conditions:$Amcondition	Ljava/lang/Object;
    //   27: getstatic 227	gnu/kawa/slib/conditions:Lit1	Lgnu/mapping/SimpleSymbol;
    //   30: astore_3
    //   31: getstatic 581	gnu/kawa/slib/conditions:$Amcondition	Ljava/lang/Object;
    //   34: astore 4
    //   36: aload 4
    //   38: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   41: astore 6
    //   43: aload_3
    //   44: aload 6
    //   46: getstatic 223	gnu/kawa/slib/conditions:Lit2	Lgnu/lists/PairWithPosition;
    //   49: invokestatic 524	gnu/kawa/slib/conditions:makeConditionType	(Lgnu/mapping/Symbol;Lgnu/kawa/slib/condition$Mntype;Ljava/lang/Object;)Lgnu/kawa/slib/condition$Mntype;
    //   52: putstatic 370	gnu/kawa/slib/conditions:$Ammessage	Ljava/lang/Object;
    //   55: getstatic 220	gnu/kawa/slib/conditions:Lit3	Lgnu/mapping/SimpleSymbol;
    //   58: astore 7
    //   60: getstatic 581	gnu/kawa/slib/conditions:$Amcondition	Ljava/lang/Object;
    //   63: astore 8
    //   65: aload 8
    //   67: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   70: astore 10
    //   72: aload 7
    //   74: aload 10
    //   76: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   79: invokestatic 524	gnu/kawa/slib/conditions:makeConditionType	(Lgnu/mapping/Symbol;Lgnu/kawa/slib/condition$Mntype;Ljava/lang/Object;)Lgnu/kawa/slib/condition$Mntype;
    //   82: putstatic 443	gnu/kawa/slib/conditions:$Amserious	Ljava/lang/Object;
    //   85: getstatic 216	gnu/kawa/slib/conditions:Lit4	Lgnu/mapping/SimpleSymbol;
    //   88: astore 11
    //   90: getstatic 443	gnu/kawa/slib/conditions:$Amserious	Ljava/lang/Object;
    //   93: astore 12
    //   95: aload 12
    //   97: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   100: astore 14
    //   102: aload 11
    //   104: aload 14
    //   106: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   109: invokestatic 524	gnu/kawa/slib/conditions:makeConditionType	(Lgnu/mapping/Symbol;Lgnu/kawa/slib/condition$Mntype;Ljava/lang/Object;)Lgnu/kawa/slib/condition$Mntype;
    //   112: putstatic 437	gnu/kawa/slib/conditions:$Amerror	Ljava/lang/Object;
    //   115: return
    //   116: astore 5
    //   118: new 358	gnu/mapping/WrongType
    //   121: dup
    //   122: aload 5
    //   124: ldc 190
    //   126: iconst_1
    //   127: aload 4
    //   129: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   132: athrow
    //   133: astore 9
    //   135: new 358	gnu/mapping/WrongType
    //   138: dup
    //   139: aload 9
    //   141: ldc 190
    //   143: iconst_1
    //   144: aload 8
    //   146: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   149: athrow
    //   150: astore 13
    //   152: new 358	gnu/mapping/WrongType
    //   155: dup
    //   156: aload 13
    //   158: ldc 190
    //   160: iconst_1
    //   161: aload 12
    //   163: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	conditions
    //   0	167	1	paramCallContext	CallContext
    //   30	14	3	localSimpleSymbol1	SimpleSymbol
    //   34	94	4	localObject1	Object
    //   116	7	5	localClassCastException1	ClassCastException
    //   41	4	6	localMntype1	condition.Mntype
    //   58	15	7	localSimpleSymbol2	SimpleSymbol
    //   63	82	8	localObject2	Object
    //   133	7	9	localClassCastException2	ClassCastException
    //   70	5	10	localMntype2	condition.Mntype
    //   88	15	11	localSimpleSymbol3	SimpleSymbol
    //   93	69	12	localObject3	Object
    //   150	7	13	localClassCastException3	ClassCastException
    //   100	5	14	localMntype3	condition.Mntype
    // Exception table:
    //   from	to	target	type
    //   36	43	116	java/lang/ClassCastException
    //   65	72	133	java/lang/ClassCastException
    //   95	102	150	java/lang/ClassCastException
  }
  
  public class frame
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn1;
    condition.Mntype type;
    
    public frame()
    {
      this$1 = new ModuleMethod(this, 1, null, 4097);
      this$1.setProperty("source-location", "conditions.scm:166");
      this.lambda$Fn1 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 1)
      {
        if (lambda2(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda2(Object paramObject)
    {
      Object localObject = lists.car.apply1(paramObject);
      try
      {
        condition.Mntype localMntype = (condition.Mntype)localObject;
        return conditions.isConditionSubtype(localMntype, this.type);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "condition-subtype?", 0, localObject);
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 1)
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
 * Qualified Name:     gnu.kawa.slib.conditions
 * JD-Core Version:    0.7.0.1
 */