package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.math.RealNum;
import kawa.standard.Scheme;
import kawa.standard.append;

public class srfi95
  extends ModuleBody
{
  public static final ModuleMethod $Pcsort$Mnlist;
  public static final ModuleMethod $Pcsort$Mnvector;
  public static final ModuleMethod $Pcvector$Mnsort$Ex;
  public static final srfi95 $instance;
  static final IntNum Lit0;
  static final IntNum Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12 = (SimpleSymbol)new SimpleSymbol("sort").readResolve();
  static final IntNum Lit2;
  static final IntNum Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  static final ModuleMethod identity;
  public static final ModuleMethod merge;
  public static final ModuleMethod merge$Ex;
  public static final ModuleMethod sort;
  public static final ModuleMethod sort$Ex;
  public static final ModuleMethod sorted$Qu;
  
  public static Object $PcSortList(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    localframe0 = new frame0();
    localframe0.seq = paramObject1;
    localframe0.less$Qu = paramObject2;
    localframe0.keyer = Special.undefined;
    Object localObject1;
    if (paramObject3 != Boolean.FALSE)
    {
      localObject1 = lists.car;
      localframe0.keyer = localObject1;
      if (paramObject3 == Boolean.FALSE) {
        break label204;
      }
      localObject3 = localframe0.seq;
      if (!lists.isNull(localObject3)) {
        break label120;
      }
      localObject4 = localframe0.seq;
    }
    for (;;)
    {
      Object localObject5;
      try
      {
        for (;;)
        {
          LList localLList2 = (LList)localObject4;
          localframe0.seq = localframe0.lambda2step(Integer.valueOf(lists.length(localLList2)));
          localObject5 = localframe0.seq;
          if (lists.isNull(localObject5))
          {
            return localframe0.seq;
            localObject1 = identity;
            break;
          }
          try
          {
            label120:
            Pair localPair1 = (Pair)localObject3;
            lists.setCar$Ex(localPair1, lists.cons(Scheme.applyToArgs.apply2(paramObject3, lists.car.apply1(localObject3)), lists.car.apply1(localObject3)));
            localObject3 = lists.cdr.apply1(localObject3);
          }
          catch (ClassCastException localClassCastException2)
          {
            try
            {
              Pair localPair2;
              label204:
              LList localLList1 = (LList)localObject2;
              return localframe0.lambda2step(Integer.valueOf(lists.length(localLList1)));
            }
            catch (ClassCastException localClassCastException1)
            {
              Object localObject2;
              throw new WrongType(localClassCastException1, "length", 1, localObject2);
            }
            localClassCastException2 = localClassCastException2;
            throw new WrongType(localClassCastException2, "set-car!", 1, localObject3);
          }
        }
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "length", 1, localObject4);
      }
      try
      {
        localPair2 = (Pair)localObject5;
        lists.setCar$Ex(localPair2, lists.cdar.apply1(localObject5));
        localObject5 = lists.cdr.apply1(localObject5);
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "set-car!", 1, localObject5);
      }
    }
    localObject2 = localframe0.seq;
  }
  
  public static void $PcSortVector(Sequence paramSequence, Object paramObject)
  {
    $PcSortVector(paramSequence, paramObject, Boolean.FALSE);
  }
  
  public static void $PcSortVector(Sequence paramSequence, Object paramObject1, Object paramObject2)
  {
    FVector localFVector = vectors.makeVector(paramSequence.size());
    Object localObject1 = $PcSortList(rank$Mn1Array$To$List(paramSequence), paramObject1, paramObject2);
    Object localObject2 = Lit3;
    while (!lists.isNull(localObject1)) {
      try
      {
        int i = ((Number)localObject2).intValue();
        vectors.vectorSet$Ex(localFVector, i, lists.car.apply1(localObject1));
        localObject1 = lists.cdr.apply1(localObject1);
        localObject2 = AddOp.$Pl.apply2(localObject2, Lit2);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "vector-set!", 2, localObject2);
      }
    }
  }
  
  public static Object $PcVectorSort$Ex(Sequence paramSequence, Object paramObject1, Object paramObject2)
  {
    Object localObject1 = $PcSortList(rank$Mn1Array$To$List(paramSequence), paramObject1, paramObject2);
    for (Object localObject2 = Lit3; !lists.isNull(localObject1); localObject2 = AddOp.$Pl.apply2(localObject2, Lit2))
    {
      paramSequence.set(((Number)localObject2).intValue(), lists.car.apply1(localObject1));
      localObject1 = lists.cdr.apply1(localObject1);
    }
    return paramSequence;
  }
  
  static
  {
    Lit11 = (SimpleSymbol)new SimpleSymbol("%sort-vector").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("%vector-sort!").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("sort!").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("%sort-list").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("merge!").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("merge").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("sorted?").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("identity").readResolve();
    Lit3 = IntNum.make(0);
    Lit2 = IntNum.make(1);
    Lit1 = IntNum.make(2);
    Lit0 = IntNum.make(-1);
    $instance = new srfi95();
    srfi95 localsrfi95 = $instance;
    identity = new ModuleMethod(localsrfi95, 1, Lit4, 4097);
    sorted$Qu = new ModuleMethod(localsrfi95, 2, Lit5, 12290);
    merge = new ModuleMethod(localsrfi95, 4, Lit6, 16387);
    merge$Ex = new ModuleMethod(localsrfi95, 6, Lit7, 16387);
    $Pcsort$Mnlist = new ModuleMethod(localsrfi95, 8, Lit8, 12291);
    sort$Ex = new ModuleMethod(localsrfi95, 9, Lit9, 12290);
    $Pcvector$Mnsort$Ex = new ModuleMethod(localsrfi95, 11, Lit10, 12291);
    $Pcsort$Mnvector = new ModuleMethod(localsrfi95, 12, Lit11, 12290);
    sort = new ModuleMethod(localsrfi95, 14, Lit12, 12290);
    $instance.run();
  }
  
  public srfi95()
  {
    ModuleInfo.register(this);
  }
  
  static Object identity(Object paramObject)
  {
    return paramObject;
  }
  
  public static Object isSorted(Object paramObject1, Object paramObject2)
  {
    return isSorted(paramObject1, paramObject2, identity);
  }
  
  public static Object isSorted(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (lists.isNull(paramObject1)) {
      return Boolean.TRUE;
    }
    if ((paramObject1 instanceof Sequence)) {}
    for (;;)
    {
      try
      {
        localSequence = (Sequence)paramObject1;
        int k = -1 + localSequence.size();
        int m;
        if (k <= 1)
        {
          m = 1;
          if (m == 0) {
            continue;
          }
          if (m != 0) {
            return Boolean.TRUE;
          }
        }
        else
        {
          m = 0;
          continue;
        }
        return Boolean.FALSE;
        localObject5 = Integer.valueOf(k - 1);
        localObject6 = Scheme.applyToArgs.apply2(paramObject3, localSequence.get(k));
      }
      catch (ClassCastException localClassCastException2)
      {
        try
        {
          Sequence localSequence;
          Object localObject6;
          RealNum localRealNum;
          boolean bool2;
          ApplyToArgs localApplyToArgs;
          int n;
          Object localObject7;
          Object localObject8;
          Object localObject1;
          Object localObject2;
          boolean bool1;
          Object localObject3;
          Boolean localBoolean = Boolean.FALSE;
          int i;
          int j;
          if (localObject4 != localBoolean)
          {
            i = 1;
            j = 0x1 & i + 1;
            if (j != 0)
            {
              localObject2 = lists.cdr.apply1(localObject2);
              localObject1 = localObject3;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          if (j != 0) {
            return Boolean.TRUE;
          }
          return Boolean.FALSE;
        }
        catch (ClassCastException localClassCastException1)
        {
          Object localObject5;
          Object localObject4;
          throw new WrongType(localClassCastException1, "x", -2, localObject4);
        }
        localClassCastException2 = localClassCastException2;
        throw new WrongType(localClassCastException2, "arr", -2, paramObject1);
      }
      try
      {
        localRealNum = LangObjType.coerceRealNum(localObject5);
        bool2 = numbers.isNegative(localRealNum);
        if (bool2)
        {
          if (bool2) {
            return Boolean.TRUE;
          }
          return Boolean.FALSE;
        }
        localApplyToArgs = Scheme.applyToArgs;
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "negative?", 1, localObject5);
      }
      try
      {
        n = ((Number)localObject5).intValue();
        localObject7 = localApplyToArgs.apply2(paramObject3, localSequence.get(n));
        localObject8 = Scheme.applyToArgs.apply3(paramObject2, localObject7, localObject6);
        if (localObject8 != Boolean.FALSE)
        {
          localObject5 = AddOp.$Pl.apply2(Lit0, localObject5);
          localObject6 = localObject7;
        }
        else
        {
          return localObject8;
        }
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "gnu.lists.Sequence.get(int)", 2, localObject5);
      }
    }
    if (lists.isNull(lists.cdr.apply1(paramObject1))) {
      return Boolean.TRUE;
    }
    localObject1 = Scheme.applyToArgs.apply2(paramObject3, lists.car.apply1(paramObject1));
    localObject2 = lists.cdr.apply1(paramObject1);
    bool1 = lists.isNull(localObject2);
    if (bool1)
    {
      if (bool1) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    localObject3 = Scheme.applyToArgs.apply2(paramObject3, lists.car.apply1(localObject2));
    localObject4 = Scheme.applyToArgs.apply3(paramObject2, localObject3, localObject1);
  }
  
  public static Object merge(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return merge(paramObject1, paramObject2, paramObject3, identity);
  }
  
  public static Object merge(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    frame localframe = new frame();
    localframe.less$Qu = paramObject3;
    localframe.key = paramObject4;
    if (lists.isNull(paramObject1)) {
      return paramObject2;
    }
    if (lists.isNull(paramObject2)) {
      return paramObject1;
    }
    return localframe.lambda1loop(lists.car.apply1(paramObject1), Scheme.applyToArgs.apply2(localframe.key, lists.car.apply1(paramObject1)), lists.cdr.apply1(paramObject1), lists.car.apply1(paramObject2), Scheme.applyToArgs.apply2(localframe.key, lists.car.apply1(paramObject2)), lists.cdr.apply1(paramObject2));
  }
  
  public static Object merge$Ex(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return merge$Ex(paramObject1, paramObject2, paramObject3, identity);
  }
  
  public static Object merge$Ex(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    return sort$ClMerge$Ex(paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  static Object rank$Mn1Array$To$List(Sequence paramSequence)
  {
    int i = -1 + paramSequence.size();
    Object localObject = LList.Empty;
    for (;;)
    {
      if (i < 0) {
        return localObject;
      }
      localObject = lists.cons(paramSequence.get(i), localObject);
      i--;
    }
  }
  
  public static Object sort(Sequence paramSequence, Object paramObject)
  {
    return sort(paramSequence, paramObject, Boolean.FALSE);
  }
  
  public static Object sort(Sequence paramSequence, Object paramObject1, Object paramObject2)
  {
    if (lists.isList(paramSequence))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramSequence;
      arrayOfObject[1] = LList.Empty;
      return $PcSortList(append.append$V(arrayOfObject), paramObject1, paramObject2);
    }
    $PcSortVector(paramSequence, paramObject1, paramObject2);
    return Values.empty;
  }
  
  static Object sort$ClMerge$Ex(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    frame1 localframe1 = new frame1();
    localframe1.less$Qu = paramObject3;
    localframe1.key = paramObject4;
    if (lists.isNull(paramObject1)) {
      return paramObject2;
    }
    if (lists.isNull(paramObject2)) {
      return paramObject1;
    }
    Object localObject1 = Scheme.applyToArgs.apply2(localframe1.key, lists.car.apply1(paramObject1));
    Object localObject2 = Scheme.applyToArgs.apply2(localframe1.key, lists.car.apply1(paramObject2));
    if ((Scheme.applyToArgs.apply3(localframe1.less$Qu, localObject2, localObject1) == Boolean.FALSE) || (lists.isNull(lists.cdr.apply1(paramObject2)))) {}
    try
    {
      Pair localPair2 = (Pair)paramObject2;
      lists.setCdr$Ex(localPair2, paramObject1);
      return paramObject2;
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "set-cdr!", 1, paramObject2);
    }
    localframe1.lambda3loop(paramObject2, paramObject1, localObject1, lists.cdr.apply1(paramObject2), Scheme.applyToArgs.apply2(localframe1.key, lists.cadr.apply1(paramObject2)));
    return paramObject2;
    if (lists.isNull(lists.cdr.apply1(paramObject1))) {}
    for (;;)
    {
      try
      {
        Pair localPair1 = (Pair)paramObject1;
        lists.setCdr$Ex(localPair1, paramObject2);
        return paramObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "set-cdr!", 1, paramObject1);
      }
      localframe1.lambda3loop(paramObject1, lists.cdr.apply1(paramObject1), Scheme.applyToArgs.apply2(localframe1.key, lists.cadr.apply1(paramObject1)), paramObject2, localObject2);
    }
  }
  
  public static Object sort$Ex(Sequence paramSequence, Object paramObject)
  {
    return sort$Ex(paramSequence, paramObject, Boolean.FALSE);
  }
  
  public static Object sort$Ex(Sequence paramSequence, Object paramObject1, Object paramObject2)
  {
    if (lists.isList(paramSequence))
    {
      localObject1 = $PcSortList(paramSequence, paramObject1, paramObject2);
      if (localObject1 != paramSequence) {
        for (localObject2 = localObject1; lists.cdr.apply1(localObject2) != paramSequence; localObject2 = lists.cdr.apply1(localObject2)) {}
      }
    }
    try
    {
      Pair localPair1 = (Pair)localObject2;
      lists.setCdr$Ex(localPair1, localObject1);
      localObject3 = lists.car.apply1(paramSequence);
      localObject4 = lists.cdr.apply1(paramSequence);
    }
    catch (ClassCastException localClassCastException1)
    {
      Object localObject3;
      Object localObject4;
      Pair localPair2;
      Pair localPair3;
      Pair localPair4;
      Pair localPair5;
      throw new WrongType(localClassCastException1, "set-cdr!", 1, localObject2);
    }
    try
    {
      localPair2 = (Pair)paramSequence;
      lists.setCar$Ex(localPair2, lists.car.apply1(localObject1));
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "set-car!", 1, paramSequence);
    }
    try
    {
      localPair3 = (Pair)paramSequence;
      lists.setCdr$Ex(localPair3, lists.cdr.apply1(localObject1));
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "set-cdr!", 1, paramSequence);
    }
    try
    {
      localPair4 = (Pair)localObject1;
      lists.setCar$Ex(localPair4, localObject3);
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "set-car!", 1, localObject1);
    }
    try
    {
      localPair5 = (Pair)localObject1;
      lists.setCdr$Ex(localPair5, localObject4);
      return paramSequence;
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "set-cdr!", 1, localObject1);
    }
    return $PcVectorSort$Ex(paramSequence, paramObject1, paramObject2);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    if (paramModuleMethod.selector == 1) {
      return identity(paramObject);
    }
    return super.apply1(paramModuleMethod, paramObject);
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    case 2: 
      return isSorted(paramObject1, paramObject2);
    }
    try
    {
      Sequence localSequence3 = (Sequence)paramObject1;
      return sort$Ex(localSequence3, paramObject2);
    }
    catch (ClassCastException localClassCastException3)
    {
      try
      {
        Sequence localSequence2 = (Sequence)paramObject1;
        $PcSortVector(localSequence2, paramObject2);
        return Values.empty;
      }
      catch (ClassCastException localClassCastException2)
      {
        Sequence localSequence1;
        throw new WrongType(localClassCastException2, "%sort-vector", 1, paramObject1);
      }
      try
      {
        localSequence1 = (Sequence)paramObject1;
        return sort(localSequence1, paramObject2);
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "sort", 1, paramObject1);
      }
      localClassCastException3 = localClassCastException3;
      throw new WrongType(localClassCastException3, "sort!", 1, paramObject1);
    }
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (paramModuleMethod.selector)
    {
    case 3: 
    case 5: 
    case 7: 
    case 10: 
    case 13: 
    default: 
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    case 2: 
      return isSorted(paramObject1, paramObject2, paramObject3);
    case 4: 
      return merge(paramObject1, paramObject2, paramObject3);
    case 6: 
      return merge$Ex(paramObject1, paramObject2, paramObject3);
    case 8: 
      return $PcSortList(paramObject1, paramObject2, paramObject3);
    }
    try
    {
      Sequence localSequence4 = (Sequence)paramObject1;
      return sort$Ex(localSequence4, paramObject2, paramObject3);
    }
    catch (ClassCastException localClassCastException4)
    {
      try
      {
        Sequence localSequence3 = (Sequence)paramObject1;
        return $PcVectorSort$Ex(localSequence3, paramObject2, paramObject3);
      }
      catch (ClassCastException localClassCastException3)
      {
        Sequence localSequence2;
        Sequence localSequence1;
        throw new WrongType(localClassCastException3, "%vector-sort!", 1, paramObject1);
      }
      try
      {
        localSequence2 = (Sequence)paramObject1;
        $PcSortVector(localSequence2, paramObject2, paramObject3);
        return Values.empty;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "%sort-vector", 1, paramObject1);
      }
      try
      {
        localSequence1 = (Sequence)paramObject1;
        return sort(localSequence1, paramObject2, paramObject3);
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "sort", 1, paramObject1);
      }
      localClassCastException4 = localClassCastException4;
      throw new WrongType(localClassCastException4, "sort!", 1, paramObject1);
    }
  }
  
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    switch (paramModuleMethod.selector)
    {
    case 5: 
    default: 
      return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
    case 4: 
      return merge(paramObject1, paramObject2, paramObject3, paramObject4);
    }
    return merge$Ex(paramObject1, paramObject2, paramObject3, paramObject4);
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
  
  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    int i = -786431;
    switch (paramModuleMethod.selector)
    {
    default: 
      i = super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 14: 
    case 12: 
    case 9: 
      do
      {
        do
        {
          do
          {
            return i;
          } while (!(paramObject1 instanceof Sequence));
          paramCallContext.value1 = paramObject1;
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        } while (!(paramObject1 instanceof Sequence));
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      } while (!(paramObject1 instanceof Sequence));
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
    int i = -786431;
    switch (paramModuleMethod.selector)
    {
    case 3: 
    case 5: 
    case 7: 
    case 10: 
    case 13: 
    default: 
      i = super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 14: 
    case 12: 
    case 11: 
    case 9: 
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
            } while (!(paramObject1 instanceof Sequence));
            paramCallContext.value1 = paramObject1;
            paramCallContext.value2 = paramObject2;
            paramCallContext.value3 = paramObject3;
            paramCallContext.proc = paramModuleMethod;
            paramCallContext.pc = 3;
            return 0;
          } while (!(paramObject1 instanceof Sequence));
          paramCallContext.value1 = paramObject1;
          paramCallContext.value2 = paramObject2;
          paramCallContext.value3 = paramObject3;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 3;
          return 0;
        } while (!(paramObject1 instanceof Sequence));
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      } while (!(paramObject1 instanceof Sequence));
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 8: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 6: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 4: 
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
    case 5: 
    default: 
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    case 6: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.value4 = paramObject4;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 4;
    return 0;
  }
  
  public final void run(CallContext paramCallContext) {}
  
  public class frame
    extends ModuleBody
  {
    Object key;
    Object less$Qu;
    
    public Object lambda1loop(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
    {
      if (Scheme.applyToArgs.apply3(this.less$Qu, paramObject5, paramObject2) != Boolean.FALSE)
      {
        if (lists.isNull(paramObject6)) {
          return lists.cons(paramObject4, lists.cons(paramObject1, paramObject3));
        }
        return lists.cons(paramObject4, lambda1loop(paramObject1, paramObject2, paramObject3, lists.car.apply1(paramObject6), Scheme.applyToArgs.apply2(this.key, lists.car.apply1(paramObject6)), lists.cdr.apply1(paramObject6)));
      }
      if (lists.isNull(paramObject3)) {
        return lists.cons(paramObject1, lists.cons(paramObject4, paramObject6));
      }
      return lists.cons(paramObject1, lambda1loop(lists.car.apply1(paramObject3), Scheme.applyToArgs.apply2(this.key, lists.car.apply1(paramObject3)), lists.cdr.apply1(paramObject3), paramObject4, paramObject5, paramObject6));
    }
  }
  
  public class frame0
    extends ModuleBody
  {
    Object keyer;
    Object less$Qu;
    Object seq;
    
    public Object lambda2step(Object paramObject)
    {
      if (Scheme.numGrt.apply2(paramObject, srfi95.Lit1) != Boolean.FALSE)
      {
        Object localObject7 = DivideOp.quotient.apply2(paramObject, srfi95.Lit1);
        return srfi95.sort$ClMerge$Ex(lambda2step(localObject7), lambda2step(AddOp.$Mn.apply2(paramObject, localObject7)), this.less$Qu, this.keyer);
      }
      Object localObject2;
      Object localObject3;
      if (Scheme.numEqu.apply2(paramObject, srfi95.Lit1) != Boolean.FALSE)
      {
        localObject2 = lists.car.apply1(this.seq);
        localObject3 = lists.cadr.apply1(this.seq);
        localObject4 = this.seq;
        this.seq = lists.cddr.apply1(this.seq);
        if (Scheme.applyToArgs.apply3(this.less$Qu, Scheme.applyToArgs.apply2(this.keyer, localObject3), Scheme.applyToArgs.apply2(this.keyer, localObject2)) == Boolean.FALSE) {}
      }
      try
      {
        Pair localPair3 = (Pair)localObject4;
        lists.setCar$Ex(localPair3, localObject3);
        localObject6 = lists.cdr.apply1(localObject4);
      }
      catch (ClassCastException localClassCastException3)
      {
        Pair localPair4;
        Pair localPair2;
        throw new WrongType(localClassCastException3, "set-car!", 1, localObject4);
      }
      try
      {
        localPair4 = (Pair)localObject6;
        lists.setCar$Ex(localPair4, localObject2);
        localObject5 = lists.cdr.apply1(localObject4);
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "set-car!", 1, localObject6);
      }
      try
      {
        localPair2 = (Pair)localObject5;
        lists.setCdr$Ex(localPair2, LList.Empty);
        return localObject4;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "set-cdr!", 1, localObject5);
      }
      if (Scheme.numEqu.apply2(paramObject, srfi95.Lit2) != Boolean.FALSE)
      {
        localObject1 = this.seq;
        this.seq = lists.cdr.apply1(this.seq);
      }
      try
      {
        Pair localPair1 = (Pair)localObject1;
        lists.setCdr$Ex(localPair1, LList.Empty);
        return localObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "set-cdr!", 1, localObject1);
      }
      return LList.Empty;
    }
  }
  
  public class frame1
    extends ModuleBody
  {
    Object key;
    Object less$Qu;
    
    public Object lambda3loop(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
    {
      if (Scheme.applyToArgs.apply3(this.less$Qu, paramObject5, paramObject3) != Boolean.FALSE) {}
      try
      {
        Pair localPair3 = (Pair)paramObject1;
        lists.setCdr$Ex(localPair3, paramObject4);
        if (!lists.isNull(lists.cdr.apply1(paramObject4))) {}
      }
      catch (ClassCastException localClassCastException3)
      {
        Pair localPair4;
        throw new WrongType(localClassCastException3, "set-cdr!", 1, paramObject1);
      }
      try
      {
        localPair4 = (Pair)paramObject4;
        lists.setCdr$Ex(localPair4, paramObject2);
        return Values.empty;
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "set-cdr!", 1, paramObject4);
      }
      return lambda3loop(paramObject4, paramObject2, paramObject3, lists.cdr.apply1(paramObject4), Scheme.applyToArgs.apply2(this.key, lists.cadr.apply1(paramObject4)));
      try
      {
        Pair localPair1 = (Pair)paramObject1;
        lists.setCdr$Ex(localPair1, paramObject2);
        if (!lists.isNull(lists.cdr.apply1(paramObject2))) {}
      }
      catch (ClassCastException localClassCastException1)
      {
        Pair localPair2;
        throw new WrongType(localClassCastException1, "set-cdr!", 1, paramObject1);
      }
      try
      {
        localPair2 = (Pair)paramObject2;
        lists.setCdr$Ex(localPair2, paramObject4);
        return Values.empty;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "set-cdr!", 1, paramObject2);
      }
      return lambda3loop(paramObject2, lists.cdr.apply1(paramObject2), Scheme.applyToArgs.apply2(this.key, lists.cadr.apply1(paramObject2)), paramObject4, paramObject5);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.srfi95
 * JD-Core Version:    0.7.0.1
 */