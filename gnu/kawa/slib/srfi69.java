package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.util.HashNode;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lib.kawa.hashtable;
import kawa.lib.kawa.hashtable.HashTable;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.rnrs.hashtables;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.standard.Scheme;

public class srfi69
  extends ModuleBody
{
  public static final srfi69 $instance;
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
  static final SimpleSymbol Lit19 = (SimpleSymbol)new SimpleSymbol("hash-table-values").readResolve();
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod alist$Mn$Grhash$Mntable;
  public static final ModuleMethod hash;
  public static final ModuleMethod hash$Mnby$Mnidentity;
  public static final ModuleMethod hash$Mntable$Mn$Gralist;
  public static final ModuleMethod hash$Mntable$Mncopy;
  public static final Location hash$Mntable$Mndelete$Ex;
  public static final ModuleMethod hash$Mntable$Mnequivalence$Mnfunction;
  public static final Location hash$Mntable$Mnexists$Qu;
  public static final ModuleMethod hash$Mntable$Mnfold;
  public static final ModuleMethod hash$Mntable$Mnhash$Mnfunction;
  public static final ModuleMethod hash$Mntable$Mnkeys;
  public static final ModuleMethod hash$Mntable$Mnmerge$Ex;
  public static final ModuleMethod hash$Mntable$Mnref;
  public static final ModuleMethod hash$Mntable$Mnref$Sldefault;
  public static final Location hash$Mntable$Mnset$Ex;
  public static final Location hash$Mntable$Mnsize;
  public static final ModuleMethod hash$Mntable$Mnupdate$Ex;
  public static final ModuleMethod hash$Mntable$Mnupdate$Ex$Sldefault;
  public static final ModuleMethod hash$Mntable$Mnvalues;
  public static final ModuleMethod hash$Mntable$Mnwalk;
  public static final Location hash$Mntable$Qu;
  static final ModuleMethod lambda$Fn1;
  static final ModuleMethod lambda$Fn2;
  static final ModuleMethod lambda$Fn3;
  public static final ModuleMethod make$Mnhash$Mntable;
  public static final ModuleMethod string$Mnci$Mnhash;
  public static final ModuleMethod string$Mnhash;
  
  static
  {
    Lit18 = (SimpleSymbol)new SimpleSymbol("hash-table-keys").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("hash-table-merge!").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("hash-table-copy").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("hash-table->alist").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("alist->hash-table").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("hash-table-fold").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("hash-table-walk").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("hash-table-update!/default").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("hash-table-update!").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("hash-table-ref/default").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("hash-table-ref").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("make-hash-table").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("hash-table-hash-function").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("hash-table-equivalence-function").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("hash-by-identity").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("hash").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("string-ci-hash").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("string-hash").readResolve();
    Lit0 = IntNum.make(64);
    $instance = new srfi69();
    hash$Mntable$Qu = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Qu");
    hash$Mntable$Mnsize = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mnsize");
    hash$Mntable$Mnset$Ex = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mnset$Ex");
    hash$Mntable$Mndelete$Ex = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mndelete$Ex");
    hash$Mntable$Mnexists$Qu = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mncontains$Qu");
    srfi69 localsrfi69 = $instance;
    string$Mnhash = new ModuleMethod(localsrfi69, 1, Lit1, 8193);
    string$Mnci$Mnhash = new ModuleMethod(localsrfi69, 3, Lit2, 8193);
    hash = new ModuleMethod(localsrfi69, 5, Lit3, 8193);
    hash$Mnby$Mnidentity = new ModuleMethod(localsrfi69, 7, Lit4, 8193);
    hash$Mntable$Mnequivalence$Mnfunction = new ModuleMethod(localsrfi69, 9, Lit5, 4097);
    hash$Mntable$Mnhash$Mnfunction = new ModuleMethod(localsrfi69, 10, Lit6, 4097);
    make$Mnhash$Mntable = new ModuleMethod(localsrfi69, 11, Lit7, 12288);
    hash$Mntable$Mnref = new ModuleMethod(localsrfi69, 15, Lit8, 12290);
    hash$Mntable$Mnref$Sldefault = new ModuleMethod(localsrfi69, 17, Lit9, 12291);
    hash$Mntable$Mnupdate$Ex = new ModuleMethod(localsrfi69, 18, Lit10, 16387);
    hash$Mntable$Mnupdate$Ex$Sldefault = new ModuleMethod(localsrfi69, 20, Lit11, 16388);
    hash$Mntable$Mnwalk = new ModuleMethod(localsrfi69, 21, Lit12, 8194);
    hash$Mntable$Mnfold = new ModuleMethod(localsrfi69, 22, Lit13, 12291);
    ModuleMethod localModuleMethod1 = new ModuleMethod(localsrfi69, 23, null, 4097);
    localModuleMethod1.setProperty("source-location", "srfi69.scm:166");
    lambda$Fn1 = localModuleMethod1;
    alist$Mn$Grhash$Mntable = new ModuleMethod(localsrfi69, 24, Lit14, 16385);
    hash$Mntable$Mn$Gralist = new ModuleMethod(localsrfi69, 28, Lit15, 4097);
    hash$Mntable$Mncopy = new ModuleMethod(localsrfi69, 29, Lit16, 4097);
    hash$Mntable$Mnmerge$Ex = new ModuleMethod(localsrfi69, 30, Lit17, 8194);
    ModuleMethod localModuleMethod2 = new ModuleMethod(localsrfi69, 31, null, 12291);
    localModuleMethod2.setProperty("source-location", "srfi69.scm:183");
    lambda$Fn2 = localModuleMethod2;
    hash$Mntable$Mnkeys = new ModuleMethod(localsrfi69, 32, Lit18, 4097);
    ModuleMethod localModuleMethod3 = new ModuleMethod(localsrfi69, 33, null, 12291);
    localModuleMethod3.setProperty("source-location", "srfi69.scm:186");
    lambda$Fn3 = localModuleMethod3;
    hash$Mntable$Mnvalues = new ModuleMethod(localsrfi69, 34, Lit19, 4097);
    $instance.run();
  }
  
  public srfi69()
  {
    ModuleInfo.register(this);
  }
  
  public static hashtable.HashTable alist$To$HashTable(Object paramObject)
  {
    return alist$To$HashTable(paramObject, Scheme.isEqual);
  }
  
  public static hashtable.HashTable alist$To$HashTable(Object paramObject1, Object paramObject2)
  {
    return alist$To$HashTable(paramObject1, paramObject2, appropriateHashFunctionFor(paramObject2));
  }
  
  public static hashtable.HashTable alist$To$HashTable(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Lit0;
    try
    {
      LList localLList = (LList)paramObject1;
      arrayOfObject[1] = Integer.valueOf(2 * lists.length(localLList));
      return alist$To$HashTable(paramObject1, paramObject2, paramObject3, numbers.max(arrayOfObject));
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "length", 1, paramObject1);
    }
  }
  
  /* Error */
  public static hashtable.HashTable alist$To$HashTable(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 309	gnu/mapping/Procedure
    //   4: astore 5
    //   6: aload_2
    //   7: checkcast 309	gnu/mapping/Procedure
    //   10: astore 7
    //   12: aload_3
    //   13: checkcast 311	java/lang/Number
    //   16: invokevirtual 315	java/lang/Number:intValue	()I
    //   19: istore 9
    //   21: aload 5
    //   23: aload 7
    //   25: iload 9
    //   27: invokestatic 319	gnu/kawa/slib/srfi69:makeHashTable	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;I)Lkawa/lib/kawa/hashtable$HashTable;
    //   30: astore 10
    //   32: aload_0
    //   33: astore 11
    //   35: aload 11
    //   37: getstatic 323	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   40: if_acmpne +6 -> 46
    //   43: aload 10
    //   45: areturn
    //   46: aload 11
    //   48: checkcast 325	gnu/lists/Pair
    //   51: astore 13
    //   53: aload 13
    //   55: invokevirtual 328	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   58: astore 14
    //   60: aload 10
    //   62: getstatic 332	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   65: aload 14
    //   67: invokevirtual 336	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   70: getstatic 226	gnu/kawa/slib/srfi69:lambda$Fn1	Lgnu/expr/ModuleMethod;
    //   73: getstatic 339	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   76: aload 14
    //   78: invokevirtual 336	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: invokestatic 343	gnu/kawa/slib/srfi69:hashTableUpdate$Ex$SlDefault	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   84: aload 13
    //   86: invokevirtual 346	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   89: astore 11
    //   91: goto -56 -> 35
    //   94: astore 4
    //   96: new 303	gnu/mapping/WrongType
    //   99: dup
    //   100: aload 4
    //   102: ldc 119
    //   104: iconst_0
    //   105: aload_1
    //   106: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   109: athrow
    //   110: astore 6
    //   112: new 303	gnu/mapping/WrongType
    //   115: dup
    //   116: aload 6
    //   118: ldc 119
    //   120: iconst_1
    //   121: aload_2
    //   122: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   125: athrow
    //   126: astore 8
    //   128: new 303	gnu/mapping/WrongType
    //   131: dup
    //   132: aload 8
    //   134: ldc 119
    //   136: iconst_2
    //   137: aload_3
    //   138: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   141: athrow
    //   142: astore 12
    //   144: new 303	gnu/mapping/WrongType
    //   147: dup
    //   148: aload 12
    //   150: ldc_w 348
    //   153: bipush 254
    //   155: aload 11
    //   157: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramObject1	Object
    //   0	161	1	paramObject2	Object
    //   0	161	2	paramObject3	Object
    //   0	161	3	paramObject4	Object
    //   94	7	4	localClassCastException1	ClassCastException
    //   4	18	5	localProcedure1	Procedure
    //   110	7	6	localClassCastException2	ClassCastException
    //   10	14	7	localProcedure2	Procedure
    //   126	7	8	localClassCastException3	ClassCastException
    //   19	7	9	i	int
    //   30	31	10	localHashTable	hashtable.HashTable
    //   33	123	11	localObject1	Object
    //   142	7	12	localClassCastException4	ClassCastException
    //   51	34	13	localPair	Pair
    //   58	19	14	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	6	94	java/lang/ClassCastException
    //   6	12	110	java/lang/ClassCastException
    //   12	21	126	java/lang/ClassCastException
    //   46	53	142	java/lang/ClassCastException
  }
  
  static Procedure appropriateHashFunctionFor(Object paramObject)
  {
    int i;
    Object localObject1;
    if (paramObject == Scheme.isEq)
    {
      i = 1;
      if (i == 0) {
        break label34;
      }
      localObject1 = hash$Mnby$Mnidentity;
    }
    for (;;)
    {
      if (localObject1 == Boolean.FALSE) {
        break label52;
      }
      return (Procedure)localObject1;
      i = 0;
      break;
      label34:
      if (i != 0) {
        localObject1 = Boolean.TRUE;
      } else {
        localObject1 = Boolean.FALSE;
      }
    }
    label52:
    int j;
    Object localObject2;
    if (paramObject == strings.string$Eq$Qu)
    {
      j = 1;
      if (j == 0) {
        break label89;
      }
      localObject2 = string$Mnhash;
    }
    for (;;)
    {
      if (localObject2 == Boolean.FALSE) {
        break label109;
      }
      return (Procedure)localObject2;
      j = 0;
      break;
      label89:
      if (j != 0) {
        localObject2 = Boolean.TRUE;
      } else {
        localObject2 = Boolean.FALSE;
      }
    }
    label109:
    int k;
    Object localObject3;
    if (paramObject == unicode.string$Mnci$Eq$Qu)
    {
      k = 1;
      if (k == 0) {
        break label149;
      }
      localObject3 = string$Mnci$Mnhash;
    }
    for (;;)
    {
      if (localObject3 == Boolean.FALSE) {
        break label170;
      }
      return (Procedure)localObject3;
      k = 0;
      break;
      label149:
      if (k != 0) {
        localObject3 = Boolean.TRUE;
      } else {
        localObject3 = Boolean.FALSE;
      }
    }
    label170:
    return hash;
  }
  
  public static Object hash(Object paramObject)
  {
    return hash(paramObject, null);
  }
  
  public static Object hash(Object paramObject, IntNum paramIntNum)
  {
    if (paramObject == null) {}
    for (int i = 0; paramIntNum == null; i = paramObject.hashCode()) {
      return Integer.valueOf(i);
    }
    return IntNum.modulo(IntNum.make(i), paramIntNum);
  }
  
  public static Object hashByIdentity(Object paramObject)
  {
    return hashByIdentity(paramObject, null);
  }
  
  public static Object hashByIdentity(Object paramObject, IntNum paramIntNum)
  {
    int i = System.identityHashCode(paramObject);
    if (paramIntNum == null) {
      return Integer.valueOf(i);
    }
    return IntNum.modulo(IntNum.make(i), paramIntNum);
  }
  
  public static Object hashTable$To$Alist(hashtable.HashTable paramHashTable)
  {
    return paramHashTable.toAlist();
  }
  
  public static hashtable.HashTable hashTableCopy(hashtable.HashTable paramHashTable)
  {
    return new hashtable.HashTable(paramHashTable, true);
  }
  
  public static Procedure hashTableEquivalenceFunction(hashtable.HashTable paramHashTable)
  {
    return paramHashTable.equivalenceFunction;
  }
  
  public static Object hashTableFold(hashtable.HashTable paramHashTable, Procedure paramProcedure, Object paramObject)
  {
    return paramHashTable.fold(paramProcedure, paramObject);
  }
  
  public static Procedure hashTableHashFunction(hashtable.HashTable paramHashTable)
  {
    return paramHashTable.hashFunction;
  }
  
  public static Object hashTableKeys(hashtable.HashTable paramHashTable)
  {
    return hashTableFold(paramHashTable, lambda$Fn2, LList.Empty);
  }
  
  public static void hashTableMerge$Ex(hashtable.HashTable paramHashTable1, hashtable.HashTable paramHashTable2)
  {
    paramHashTable1.putAll(paramHashTable2);
  }
  
  public static Object hashTableRef(hashtable.HashTable paramHashTable, Object paramObject)
  {
    return hashTableRef(paramHashTable, paramObject, Boolean.FALSE);
  }
  
  public static Object hashTableRef(hashtable.HashTable paramHashTable, Object paramObject1, Object paramObject2)
  {
    HashNode localHashNode = paramHashTable.getNode(paramObject1);
    if (localHashNode == null)
    {
      if (paramObject2 != Boolean.FALSE) {
        return Scheme.applyToArgs.apply1(paramObject2);
      }
      return misc.error$V("hash-table-ref: no value associated with", new Object[] { paramObject1 });
    }
    return localHashNode.getValue();
  }
  
  public static Object hashTableRef$SlDefault(hashtable.HashTable paramHashTable, Object paramObject1, Object paramObject2)
  {
    return paramHashTable.get(paramObject1, paramObject2);
  }
  
  public static void hashTableUpdate$Ex(hashtable.HashTable paramHashTable, Object paramObject1, Object paramObject2)
  {
    hashTableUpdate$Ex(paramHashTable, paramObject1, paramObject2, Boolean.FALSE);
  }
  
  public static void hashTableUpdate$Ex(hashtable.HashTable paramHashTable, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    hashtable.hashtableCheckMutable(paramHashTable);
    HashNode localHashNode = paramHashTable.getNode(paramObject1);
    if (localHashNode == null)
    {
      if (paramObject3 != Boolean.FALSE)
      {
        hashtables.hashtableSet$Ex(paramHashTable, paramObject1, Scheme.applyToArgs.apply2(paramObject2, Scheme.applyToArgs.apply1(paramObject3)));
        return;
      }
      misc.error$V("hash-table-update!: no value exists for key", new Object[] { paramObject1 });
      return;
    }
    localHashNode.setValue(Scheme.applyToArgs.apply2(paramObject2, localHashNode.getValue()));
  }
  
  public static void hashTableUpdate$Ex$SlDefault(hashtable.HashTable paramHashTable, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    hashtable.hashtableCheckMutable(paramHashTable);
    HashNode localHashNode = paramHashTable.getNode(paramObject1);
    if (localHashNode == null)
    {
      hashtables.hashtableSet$Ex(paramHashTable, paramObject1, Scheme.applyToArgs.apply2(paramObject2, paramObject3));
      return;
    }
    localHashNode.setValue(Scheme.applyToArgs.apply2(paramObject2, localHashNode.getValue()));
  }
  
  public static Object hashTableValues(hashtable.HashTable paramHashTable)
  {
    return hashTableFold(paramHashTable, lambda$Fn3, LList.Empty);
  }
  
  public static void hashTableWalk(hashtable.HashTable paramHashTable, Procedure paramProcedure)
  {
    paramHashTable.walk(paramProcedure);
  }
  
  static Object lambda1(Object paramObject)
  {
    return paramObject;
  }
  
  static Pair lambda2(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return lists.cons(paramObject1, paramObject3);
  }
  
  static Pair lambda3(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return lists.cons(paramObject2, paramObject3);
  }
  
  public static hashtable.HashTable makeHashTable()
  {
    return makeHashTable(Scheme.isEqual);
  }
  
  public static hashtable.HashTable makeHashTable(Procedure paramProcedure)
  {
    return makeHashTable(paramProcedure, appropriateHashFunctionFor(paramProcedure), 64);
  }
  
  public static hashtable.HashTable makeHashTable(Procedure paramProcedure1, Procedure paramProcedure2)
  {
    return makeHashTable(paramProcedure1, paramProcedure2, 64);
  }
  
  public static hashtable.HashTable makeHashTable(Procedure paramProcedure1, Procedure paramProcedure2, int paramInt)
  {
    return new hashtable.HashTable(paramProcedure1, paramProcedure2, paramInt);
  }
  
  public static Object stringCiHash(Object paramObject)
  {
    return stringCiHash(paramObject, null);
  }
  
  public static Object stringCiHash(Object paramObject, IntNum paramIntNum)
  {
    int i = paramObject.toString().toLowerCase().hashCode();
    if (paramIntNum == null) {
      return Integer.valueOf(i);
    }
    return IntNum.modulo(IntNum.make(i), paramIntNum);
  }
  
  public static Object stringHash(CharSequence paramCharSequence)
  {
    return stringHash(paramCharSequence, null);
  }
  
  public static Object stringHash(CharSequence paramCharSequence, IntNum paramIntNum)
  {
    int i = paramCharSequence.hashCode();
    if (paramIntNum == null) {
      return Integer.valueOf(i);
    }
    return IntNum.modulo(IntNum.make(i), paramIntNum);
  }
  
  static Object symbolHash(Symbol paramSymbol)
  {
    return symbolHash(paramSymbol, null);
  }
  
  static Object symbolHash(Symbol paramSymbol, IntNum paramIntNum)
  {
    int i = paramSymbol.hashCode();
    if (paramIntNum == null) {
      return Integer.valueOf(i);
    }
    return IntNum.modulo(IntNum.make(i), paramIntNum);
  }
  
  static Object vectorHash(Object paramObject)
  {
    return vectorHash(paramObject, null);
  }
  
  static Object vectorHash(Object paramObject, IntNum paramIntNum)
  {
    int i = paramObject.hashCode();
    if (paramIntNum == null) {
      return Integer.valueOf(i);
    }
    return IntNum.modulo(IntNum.make(i), paramIntNum);
  }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    if (paramModuleMethod.selector == 11) {
      return makeHashTable();
    }
    return super.apply0(paramModuleMethod);
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
      CharSequence localCharSequence = (CharSequence)paramObject;
      return stringHash(localCharSequence);
    }
    catch (ClassCastException localClassCastException8)
    {
      try
      {
        localHashTable4 = (hashtable.HashTable)paramObject;
        return hashTable$To$Alist(localHashTable4);
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "hash-table->alist", 1, paramObject);
      }
      try
      {
        localHashTable3 = (hashtable.HashTable)paramObject;
        return hashTableCopy(localHashTable3);
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "hash-table-copy", 1, paramObject);
      }
      try
      {
        localHashTable2 = (hashtable.HashTable)paramObject;
        return hashTableKeys(localHashTable2);
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "hash-table-keys", 1, paramObject);
      }
      try
      {
        localHashTable1 = (hashtable.HashTable)paramObject;
        return hashTableValues(localHashTable1);
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "hash-table-values", 1, paramObject);
      }
      localClassCastException8 = localClassCastException8;
      throw new WrongType(localClassCastException8, "string-hash", 1, paramObject);
    }
    return stringCiHash(paramObject);
    return hash(paramObject);
    return hashByIdentity(paramObject);
    try
    {
      hashtable.HashTable localHashTable6 = (hashtable.HashTable)paramObject;
      return hashTableEquivalenceFunction(localHashTable6);
    }
    catch (ClassCastException localClassCastException7)
    {
      hashtable.HashTable localHashTable5;
      Procedure localProcedure;
      hashtable.HashTable localHashTable4;
      hashtable.HashTable localHashTable3;
      hashtable.HashTable localHashTable2;
      hashtable.HashTable localHashTable1;
      throw new WrongType(localClassCastException7, "hash-table-equivalence-function", 1, paramObject);
    }
    try
    {
      localHashTable5 = (hashtable.HashTable)paramObject;
      return hashTableHashFunction(localHashTable5);
    }
    catch (ClassCastException localClassCastException6)
    {
      throw new WrongType(localClassCastException6, "hash-table-hash-function", 1, paramObject);
    }
    try
    {
      localProcedure = (Procedure)paramObject;
      return makeHashTable(localProcedure);
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "make-hash-table", 1, paramObject);
    }
    return lambda1(paramObject);
    return alist$To$HashTable(paramObject);
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
      localCharSequence = (CharSequence)paramObject1;
    }
    catch (ClassCastException localClassCastException11)
    {
      try
      {
        CharSequence localCharSequence;
        IntNum localIntNum4;
        IntNum localIntNum3;
        IntNum localIntNum2;
        IntNum localIntNum1;
        Procedure localProcedure2;
        Procedure localProcedure3;
        hashtable.HashTable localHashTable4;
        hashtable.HashTable localHashTable3;
        Procedure localProcedure1;
        localHashTable1 = (hashtable.HashTable)paramObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        hashtable.HashTable localHashTable1;
        hashtable.HashTable localHashTable2;
        throw new WrongType(localClassCastException1, "hash-table-merge!", 1, paramObject1);
      }
      try
      {
        localHashTable2 = (hashtable.HashTable)paramObject2;
        hashTableMerge$Ex(localHashTable1, localHashTable2);
        return Values.empty;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "hash-table-merge!", 2, paramObject2);
      }
      localClassCastException11 = localClassCastException11;
      throw new WrongType(localClassCastException11, "string-hash", 1, paramObject1);
    }
    try
    {
      localIntNum4 = LangObjType.coerceIntNum(paramObject2);
      return stringHash(localCharSequence, localIntNum4);
    }
    catch (ClassCastException localClassCastException12)
    {
      throw new WrongType(localClassCastException12, "string-hash", 2, paramObject2);
    }
    try
    {
      localIntNum3 = LangObjType.coerceIntNum(paramObject2);
      return stringCiHash(paramObject1, localIntNum3);
    }
    catch (ClassCastException localClassCastException10)
    {
      throw new WrongType(localClassCastException10, "string-ci-hash", 2, paramObject2);
    }
    try
    {
      localIntNum2 = LangObjType.coerceIntNum(paramObject2);
      return hash(paramObject1, localIntNum2);
    }
    catch (ClassCastException localClassCastException9)
    {
      throw new WrongType(localClassCastException9, "hash", 2, paramObject2);
    }
    try
    {
      localIntNum1 = LangObjType.coerceIntNum(paramObject2);
      return hashByIdentity(paramObject1, localIntNum1);
    }
    catch (ClassCastException localClassCastException8)
    {
      throw new WrongType(localClassCastException8, "hash-by-identity", 2, paramObject2);
    }
    try
    {
      localProcedure2 = (Procedure)paramObject1;
    }
    catch (ClassCastException localClassCastException6)
    {
      throw new WrongType(localClassCastException6, "make-hash-table", 1, paramObject1);
    }
    try
    {
      localProcedure3 = (Procedure)paramObject2;
      return makeHashTable(localProcedure2, localProcedure3);
    }
    catch (ClassCastException localClassCastException7)
    {
      throw new WrongType(localClassCastException7, "make-hash-table", 2, paramObject2);
    }
    try
    {
      localHashTable4 = (hashtable.HashTable)paramObject1;
      return hashTableRef(localHashTable4, paramObject2);
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "hash-table-ref", 1, paramObject1);
    }
    try
    {
      localHashTable3 = (hashtable.HashTable)paramObject1;
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "hash-table-walk", 1, paramObject1);
    }
    try
    {
      localProcedure1 = (Procedure)paramObject2;
      hashTableWalk(localHashTable3, localProcedure1);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "hash-table-walk", 2, paramObject2);
    }
    return alist$To$HashTable(paramObject1, paramObject2);
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
      localProcedure2 = (Procedure)paramObject1;
    }
    catch (ClassCastException localClassCastException6)
    {
      Procedure localProcedure2;
      Procedure localProcedure3;
      int i;
      hashtable.HashTable localHashTable4;
      hashtable.HashTable localHashTable3;
      hashtable.HashTable localHashTable2;
      hashtable.HashTable localHashTable1;
      Procedure localProcedure1;
      throw new WrongType(localClassCastException6, "make-hash-table", 1, paramObject1);
    }
    try
    {
      localProcedure3 = (Procedure)paramObject2;
    }
    catch (ClassCastException localClassCastException7)
    {
      throw new WrongType(localClassCastException7, "make-hash-table", 2, paramObject2);
    }
    try
    {
      i = ((Number)paramObject3).intValue();
      return makeHashTable(localProcedure2, localProcedure3, i);
    }
    catch (ClassCastException localClassCastException8)
    {
      throw new WrongType(localClassCastException8, "make-hash-table", 3, paramObject3);
    }
    try
    {
      localHashTable4 = (hashtable.HashTable)paramObject1;
      return hashTableRef(localHashTable4, paramObject2, paramObject3);
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "hash-table-ref", 1, paramObject1);
    }
    try
    {
      localHashTable3 = (hashtable.HashTable)paramObject1;
      return hashTableRef$SlDefault(localHashTable3, paramObject2, paramObject3);
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "hash-table-ref/default", 1, paramObject1);
    }
    try
    {
      localHashTable2 = (hashtable.HashTable)paramObject1;
      hashTableUpdate$Ex(localHashTable2, paramObject2, paramObject3);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "hash-table-update!", 1, paramObject1);
    }
    try
    {
      localHashTable1 = (hashtable.HashTable)paramObject1;
    }
    catch (ClassCastException localClassCastException1)
    {
      throw new WrongType(localClassCastException1, "hash-table-fold", 1, paramObject1);
    }
    try
    {
      localProcedure1 = (Procedure)paramObject2;
      return hashTableFold(localHashTable1, localProcedure1, paramObject3);
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "hash-table-fold", 2, paramObject2);
    }
    return alist$To$HashTable(paramObject1, paramObject2, paramObject3);
    return lambda2(paramObject1, paramObject2, paramObject3);
    return lambda3(paramObject1, paramObject2, paramObject3);
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
      hashtable.HashTable localHashTable2 = (hashtable.HashTable)paramObject1;
      hashTableUpdate$Ex(localHashTable2, paramObject2, paramObject3, paramObject4);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException2)
    {
      hashtable.HashTable localHashTable1;
      throw new WrongType(localClassCastException2, "hash-table-update!", 1, paramObject1);
    }
    try
    {
      localHashTable1 = (hashtable.HashTable)paramObject1;
      hashTableUpdate$Ex$SlDefault(localHashTable1, paramObject2, paramObject3, paramObject4);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException1)
    {
      throw new WrongType(localClassCastException1, "hash-table-update!/default", 1, paramObject1);
    }
    return alist$To$HashTable(paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 11)
    {
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }
    return super.match0(paramModuleMethod, paramCallContext);
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    int i = -786431;
    switch (paramModuleMethod.selector)
    {
    default: 
      i = super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return i;
                  } while (!(paramObject instanceof hashtable.HashTable));
                  paramCallContext.value1 = paramObject;
                  paramCallContext.proc = paramModuleMethod;
                  paramCallContext.pc = 1;
                  return 0;
                } while (!(paramObject instanceof hashtable.HashTable));
                paramCallContext.value1 = paramObject;
                paramCallContext.proc = paramModuleMethod;
                paramCallContext.pc = 1;
                return 0;
              } while (!(paramObject instanceof hashtable.HashTable));
              paramCallContext.value1 = paramObject;
              paramCallContext.proc = paramModuleMethod;
              paramCallContext.pc = 1;
              return 0;
            } while (!(paramObject instanceof hashtable.HashTable));
            paramCallContext.value1 = paramObject;
            paramCallContext.proc = paramModuleMethod;
            paramCallContext.pc = 1;
            return 0;
            paramCallContext.value1 = paramObject;
            paramCallContext.proc = paramModuleMethod;
            paramCallContext.pc = 1;
            return 0;
            paramCallContext.value1 = paramObject;
            paramCallContext.proc = paramModuleMethod;
            paramCallContext.pc = 1;
            return 0;
          } while (!(paramObject instanceof Procedure));
          paramCallContext.value1 = paramObject;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 1;
          return 0;
        } while (!(paramObject instanceof hashtable.HashTable));
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      } while (!(paramObject instanceof hashtable.HashTable));
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    } while (!(paramObject instanceof CharSequence));
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
    default: 
      i = super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
            } while (!(paramObject1 instanceof hashtable.HashTable));
            paramCallContext.value1 = paramObject1;
            if (!(paramObject2 instanceof hashtable.HashTable)) {
              return -786430;
            }
            paramCallContext.value2 = paramObject2;
            paramCallContext.proc = paramModuleMethod;
            paramCallContext.pc = 2;
            return 0;
            paramCallContext.value1 = paramObject1;
            paramCallContext.value2 = paramObject2;
            paramCallContext.proc = paramModuleMethod;
            paramCallContext.pc = 2;
            return 0;
          } while (!(paramObject1 instanceof hashtable.HashTable));
          paramCallContext.value1 = paramObject1;
          if (!(paramObject2 instanceof Procedure)) {
            return -786430;
          }
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        } while (!(paramObject1 instanceof hashtable.HashTable));
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      } while (!(paramObject1 instanceof Procedure));
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    } while (!(paramObject1 instanceof CharSequence));
    paramCallContext.value1 = paramObject1;
    if (IntNum.asIntNumOrNull(paramObject2) != null)
    {
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    return -786430;
  }
  
  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 33: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 31: 
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
    case 22: 
      if (!(paramObject1 instanceof hashtable.HashTable)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 18: 
      if (!(paramObject1 instanceof hashtable.HashTable)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 17: 
      if (!(paramObject1 instanceof hashtable.HashTable)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 15: 
      if (!(paramObject1 instanceof hashtable.HashTable)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    }
    if (!(paramObject1 instanceof Procedure)) {
      return -786431;
    }
    paramCallContext.value1 = paramObject1;
    if (!(paramObject2 instanceof Procedure)) {
      return -786430;
    }
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
    case 24: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    case 20: 
      if (!(paramObject1 instanceof hashtable.HashTable)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    }
    if (!(paramObject1 instanceof hashtable.HashTable)) {
      return -786431;
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
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.srfi69
 * JD-Core Version:    0.7.0.1
 */