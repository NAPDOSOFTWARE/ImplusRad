package kawa.lib.rnrs;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.util.AbstractHashTable;
import gnu.kawa.util.HashNode;
import gnu.lists.FVector;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.lib.kawa.hashtable;
import kawa.lib.kawa.hashtable.HashTable;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;

public class hashtables
  extends ModuleBody
{
  public static final hashtables $instance;
  static final SimpleSymbol Lit0;
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
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22 = (SimpleSymbol)new SimpleSymbol("symbol-hash").readResolve();
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod equal$Mnhash;
  static final ModuleMethod hash$Mnby$Mnidentity;
  static final ModuleMethod hash$Mnfor$Mneqv;
  public static final ModuleMethod hashtable$Mnclear$Ex;
  public static final ModuleMethod hashtable$Mncontains$Qu;
  public static final ModuleMethod hashtable$Mncopy;
  public static final ModuleMethod hashtable$Mndelete$Ex;
  public static final ModuleMethod hashtable$Mnentries;
  public static final ModuleMethod hashtable$Mnequivalence$Mnfunction;
  public static final ModuleMethod hashtable$Mnhash$Mnfunction;
  public static final ModuleMethod hashtable$Mnkeys;
  public static final ModuleMethod hashtable$Mnmutable$Qu;
  public static final ModuleMethod hashtable$Mnref;
  public static final ModuleMethod hashtable$Mnset$Ex;
  public static final ModuleMethod hashtable$Mnsize;
  public static final ModuleMethod hashtable$Mnupdate$Ex;
  public static final ModuleMethod hashtable$Qu;
  public static final ModuleMethod make$Mneq$Mnhashtable;
  public static final ModuleMethod make$Mneqv$Mnhashtable;
  public static final ModuleMethod make$Mnhashtable;
  public static final ModuleMethod string$Mnci$Mnhash;
  public static final ModuleMethod string$Mnhash;
  public static final ModuleMethod symbol$Mnhash;
  
  static
  {
    Lit21 = (SimpleSymbol)new SimpleSymbol("string-ci-hash").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("string-hash").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("equal-hash").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("hashtable-mutable?").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("hashtable-hash-function").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("hashtable-equivalence-function").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("hashtable-entries").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("hashtable-keys").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("hashtable-clear!").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("hashtable-copy").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("hashtable-update!").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("hashtable-contains?").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("hashtable-delete!").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("hashtable-set!").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("hashtable-ref").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("hashtable-size").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("hashtable?").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("make-hashtable").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("make-eqv-hashtable").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("make-eq-hashtable").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("hash-for-eqv").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("hash-by-identity").readResolve();
    $instance = new hashtables();
    hashtables localhashtables = $instance;
    hash$Mnby$Mnidentity = new ModuleMethod(localhashtables, 1, Lit0, 4097);
    hash$Mnfor$Mneqv = new ModuleMethod(localhashtables, 2, Lit1, 4097);
    make$Mneq$Mnhashtable = new ModuleMethod(localhashtables, 3, Lit2, 4096);
    make$Mneqv$Mnhashtable = new ModuleMethod(localhashtables, 5, Lit3, 4096);
    make$Mnhashtable = new ModuleMethod(localhashtables, 7, Lit4, 12290);
    hashtable$Qu = new ModuleMethod(localhashtables, 9, Lit5, 4097);
    hashtable$Mnsize = new ModuleMethod(localhashtables, 10, Lit6, 4097);
    hashtable$Mnref = new ModuleMethod(localhashtables, 11, Lit7, 12291);
    hashtable$Mnset$Ex = new ModuleMethod(localhashtables, 12, Lit8, 12291);
    hashtable$Mndelete$Ex = new ModuleMethod(localhashtables, 13, Lit9, 8194);
    hashtable$Mncontains$Qu = new ModuleMethod(localhashtables, 14, Lit10, 8194);
    hashtable$Mnupdate$Ex = new ModuleMethod(localhashtables, 15, Lit11, 16388);
    hashtable$Mncopy = new ModuleMethod(localhashtables, 16, Lit12, 8193);
    hashtable$Mnclear$Ex = new ModuleMethod(localhashtables, 18, Lit13, 8193);
    hashtable$Mnkeys = new ModuleMethod(localhashtables, 20, Lit14, 4097);
    hashtable$Mnentries = new ModuleMethod(localhashtables, 21, Lit15, 4097);
    hashtable$Mnequivalence$Mnfunction = new ModuleMethod(localhashtables, 22, Lit16, 4097);
    hashtable$Mnhash$Mnfunction = new ModuleMethod(localhashtables, 23, Lit17, 4097);
    hashtable$Mnmutable$Qu = new ModuleMethod(localhashtables, 24, Lit18, 4097);
    equal$Mnhash = new ModuleMethod(localhashtables, 25, Lit19, 4097);
    string$Mnhash = new ModuleMethod(localhashtables, 26, Lit20, 4097);
    string$Mnci$Mnhash = new ModuleMethod(localhashtables, 27, Lit21, 4097);
    symbol$Mnhash = new ModuleMethod(localhashtables, 28, Lit22, 4097);
    $instance.run();
  }
  
  public hashtables()
  {
    ModuleInfo.register(this);
  }
  
  public static int equalHash(Object paramObject)
  {
    return paramObject.hashCode();
  }
  
  static int hashByIdentity(Object paramObject)
  {
    return System.identityHashCode(paramObject);
  }
  
  static int hashForEqv(Object paramObject)
  {
    return paramObject.hashCode();
  }
  
  public static void hashtableClear$Ex(hashtable.HashTable paramHashTable)
  {
    hashtableClear$Ex(paramHashTable, 64);
  }
  
  public static void hashtableClear$Ex(hashtable.HashTable paramHashTable, int paramInt)
  {
    hashtable.hashtableCheckMutable(paramHashTable);
    paramHashTable.clear();
  }
  
  public static hashtable.HashTable hashtableCopy(hashtable.HashTable paramHashTable)
  {
    return hashtableCopy(paramHashTable, false);
  }
  
  public static hashtable.HashTable hashtableCopy(hashtable.HashTable paramHashTable, boolean paramBoolean)
  {
    return new hashtable.HashTable(paramHashTable, paramBoolean);
  }
  
  public static void hashtableDelete$Ex(hashtable.HashTable paramHashTable, Object paramObject)
  {
    hashtable.hashtableCheckMutable(paramHashTable);
    paramHashTable.remove(paramObject);
  }
  
  public static Object hashtableEntries(hashtable.HashTable paramHashTable)
  {
    Pair localPair = paramHashTable.entriesVectorPair();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = lists.car.apply1(localPair);
    arrayOfObject[1] = lists.cdr.apply1(localPair);
    return misc.values(arrayOfObject);
  }
  
  public static Procedure hashtableEquivalenceFunction(hashtable.HashTable paramHashTable)
  {
    return (Procedure)paramHashTable.equivalenceFunction.apply1(paramHashTable);
  }
  
  public static Object hashtableHashFunction(hashtable.HashTable paramHashTable)
  {
    Object localObject1 = paramHashTable.hashFunction.apply1(paramHashTable);
    Object localObject2 = Scheme.isEqv.apply2(localObject1, hash$Mnby$Mnidentity);
    if (localObject2 != Boolean.FALSE) {
      if (localObject2 == Boolean.FALSE) {}
    }
    for (;;)
    {
      localObject1 = Boolean.FALSE;
      do
      {
        return localObject1;
      } while (Scheme.isEqv.apply2(localObject1, hash$Mnfor$Mneqv) == Boolean.FALSE);
    }
  }
  
  public static FVector hashtableKeys(hashtable.HashTable paramHashTable)
  {
    return paramHashTable.keysVector();
  }
  
  public static Object hashtableRef(hashtable.HashTable paramHashTable, Object paramObject1, Object paramObject2)
  {
    HashNode localHashNode = paramHashTable.getNode(paramObject1);
    if (localHashNode == null) {
      return paramObject2;
    }
    return localHashNode.getValue();
  }
  
  public static void hashtableSet$Ex(hashtable.HashTable paramHashTable, Object paramObject1, Object paramObject2)
  {
    hashtable.hashtableCheckMutable(paramHashTable);
    paramHashTable.put(paramObject1, paramObject2);
  }
  
  public static int hashtableSize(hashtable.HashTable paramHashTable)
  {
    return paramHashTable.size();
  }
  
  public static Object hashtableUpdate$Ex(hashtable.HashTable paramHashTable, Object paramObject1, Procedure paramProcedure, Object paramObject2)
  {
    hashtable.hashtableCheckMutable(paramHashTable);
    HashNode localHashNode = paramHashTable.getNode(paramObject1);
    if (localHashNode == null)
    {
      hashtableSet$Ex(paramHashTable, paramObject1, paramProcedure.apply1(paramObject2));
      return Values.empty;
    }
    return localHashNode.setValue(paramProcedure.apply1(localHashNode.getValue()));
  }
  
  public static boolean isHashtable(Object paramObject)
  {
    return paramObject instanceof hashtable.HashTable;
  }
  
  public static boolean isHashtableContains(hashtable.HashTable paramHashTable, Object paramObject)
  {
    if (paramHashTable.getNode(paramObject) == null) {}
    for (int i = 1;; i = 0) {
      return 0x1 & i + 1;
    }
  }
  
  public static Object isHashtableMutable(hashtable.HashTable paramHashTable)
  {
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    if (paramHashTable.mutable) {}
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE) {
      return localApplyToArgs.apply1(localBoolean);
    }
  }
  
  public static hashtable.HashTable makeEqHashtable()
  {
    return makeEqHashtable(AbstractHashTable.DEFAULT_INITIAL_SIZE);
  }
  
  public static hashtable.HashTable makeEqHashtable(int paramInt)
  {
    return new hashtable.HashTable(Scheme.isEq, hash$Mnby$Mnidentity, AbstractHashTable.DEFAULT_INITIAL_SIZE);
  }
  
  public static hashtable.HashTable makeEqvHashtable()
  {
    return makeEqvHashtable(AbstractHashTable.DEFAULT_INITIAL_SIZE);
  }
  
  public static hashtable.HashTable makeEqvHashtable(int paramInt)
  {
    return new hashtable.HashTable(Scheme.isEqv, hash$Mnfor$Mneqv, AbstractHashTable.DEFAULT_INITIAL_SIZE);
  }
  
  public static hashtable.HashTable makeHashtable(Procedure paramProcedure1, Procedure paramProcedure2)
  {
    return makeHashtable(paramProcedure1, paramProcedure2, AbstractHashTable.DEFAULT_INITIAL_SIZE);
  }
  
  public static hashtable.HashTable makeHashtable(Procedure paramProcedure1, Procedure paramProcedure2, int paramInt)
  {
    return new hashtable.HashTable(paramProcedure1, paramProcedure2, paramInt);
  }
  
  public static int stringCiHash(CharSequence paramCharSequence)
  {
    return paramCharSequence.toString().toLowerCase().hashCode();
  }
  
  public static int stringHash(CharSequence paramCharSequence)
  {
    return paramCharSequence.hashCode();
  }
  
  public static int symbolHash(Symbol paramSymbol)
  {
    return paramSymbol.hashCode();
  }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    case 4: 
    default: 
      return super.apply0(paramModuleMethod);
    case 3: 
      return makeEqHashtable();
    }
    return makeEqvHashtable();
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 17: 
    case 19: 
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 1: 
      return Integer.valueOf(hashByIdentity(paramObject));
    case 2: 
      return Integer.valueOf(hashForEqv(paramObject));
    }
    try
    {
      int j = ((Number)paramObject).intValue();
      return makeEqHashtable(j);
    }
    catch (ClassCastException localClassCastException13)
    {
      try
      {
        int i;
        localCharSequence2 = (CharSequence)paramObject;
        return Integer.valueOf(stringHash(localCharSequence2));
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "string-hash", 1, paramObject);
      }
      try
      {
        localCharSequence1 = (CharSequence)paramObject;
        return Integer.valueOf(stringCiHash(localCharSequence1));
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-ci-hash", 1, paramObject);
      }
      try
      {
        localSymbol = (Symbol)paramObject;
        return Integer.valueOf(symbolHash(localSymbol));
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "symbol-hash", 1, paramObject);
      }
      localClassCastException13 = localClassCastException13;
      throw new WrongType(localClassCastException13, "make-eq-hashtable", 1, paramObject);
    }
    try
    {
      i = ((Number)paramObject).intValue();
      return makeEqvHashtable(i);
    }
    catch (ClassCastException localClassCastException12)
    {
      throw new WrongType(localClassCastException12, "make-eqv-hashtable", 1, paramObject);
    }
    if (isHashtable(paramObject)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    try
    {
      hashtable.HashTable localHashTable8 = (hashtable.HashTable)paramObject;
      return Integer.valueOf(hashtableSize(localHashTable8));
    }
    catch (ClassCastException localClassCastException11)
    {
      hashtable.HashTable localHashTable7;
      hashtable.HashTable localHashTable6;
      hashtable.HashTable localHashTable5;
      hashtable.HashTable localHashTable4;
      hashtable.HashTable localHashTable3;
      hashtable.HashTable localHashTable2;
      hashtable.HashTable localHashTable1;
      CharSequence localCharSequence2;
      CharSequence localCharSequence1;
      Symbol localSymbol;
      throw new WrongType(localClassCastException11, "hashtable-size", 1, paramObject);
    }
    try
    {
      localHashTable7 = (hashtable.HashTable)paramObject;
      return hashtableCopy(localHashTable7);
    }
    catch (ClassCastException localClassCastException10)
    {
      throw new WrongType(localClassCastException10, "hashtable-copy", 1, paramObject);
    }
    try
    {
      localHashTable6 = (hashtable.HashTable)paramObject;
      hashtableClear$Ex(localHashTable6);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException9)
    {
      throw new WrongType(localClassCastException9, "hashtable-clear!", 1, paramObject);
    }
    try
    {
      localHashTable5 = (hashtable.HashTable)paramObject;
      return hashtableKeys(localHashTable5);
    }
    catch (ClassCastException localClassCastException8)
    {
      throw new WrongType(localClassCastException8, "hashtable-keys", 1, paramObject);
    }
    try
    {
      localHashTable4 = (hashtable.HashTable)paramObject;
      return hashtableEntries(localHashTable4);
    }
    catch (ClassCastException localClassCastException7)
    {
      throw new WrongType(localClassCastException7, "hashtable-entries", 1, paramObject);
    }
    try
    {
      localHashTable3 = (hashtable.HashTable)paramObject;
      return hashtableEquivalenceFunction(localHashTable3);
    }
    catch (ClassCastException localClassCastException6)
    {
      throw new WrongType(localClassCastException6, "hashtable-equivalence-function", 1, paramObject);
    }
    try
    {
      localHashTable2 = (hashtable.HashTable)paramObject;
      return hashtableHashFunction(localHashTable2);
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "hashtable-hash-function", 1, paramObject);
    }
    try
    {
      localHashTable1 = (hashtable.HashTable)paramObject;
      return isHashtableMutable(localHashTable1);
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "hashtable-mutable?", 1, paramObject);
    }
    return Integer.valueOf(equalHash(paramObject));
  }
  
  /* Error */
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_1
    //   4: getfield 427	gnu/expr/ModuleMethod:selector	I
    //   7: lookupswitch	default:+49->56, 7:+57->64, 13:+77->84, 14:+93->100, 16:+116->123, 18:+147->154
    //   57: aload_1
    //   58: aload_2
    //   59: aload_3
    //   60: invokespecial 487	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   63: areturn
    //   64: aload_2
    //   65: checkcast 281	gnu/mapping/Procedure
    //   68: astore 18
    //   70: aload_3
    //   71: checkcast 281	gnu/mapping/Procedure
    //   74: astore 20
    //   76: aload 18
    //   78: aload 20
    //   80: invokestatic 489	kawa/lib/rnrs/hashtables:makeHashtable	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Lkawa/lib/kawa/hashtable$HashTable;
    //   83: areturn
    //   84: aload_2
    //   85: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   88: astore 16
    //   90: aload 16
    //   92: aload_3
    //   93: invokestatic 491	kawa/lib/rnrs/hashtables:hashtableDelete$Ex	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)V
    //   96: getstatic 356	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   99: areturn
    //   100: aload_2
    //   101: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   104: astore 14
    //   106: aload 14
    //   108: aload_3
    //   109: invokestatic 493	kawa/lib/rnrs/hashtables:isHashtableContains	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)Z
    //   112: ifeq +7 -> 119
    //   115: getstatic 375	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   118: areturn
    //   119: getstatic 319	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   122: areturn
    //   123: aload_2
    //   124: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   127: astore 10
    //   129: getstatic 319	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   132: astore 12
    //   134: aload_3
    //   135: aload 12
    //   137: if_acmpeq +11 -> 148
    //   140: aload 10
    //   142: iload 4
    //   144: invokestatic 258	kawa/lib/rnrs/hashtables:hashtableCopy	(Lkawa/lib/kawa/hashtable$HashTable;Z)Lkawa/lib/kawa/hashtable$HashTable;
    //   147: areturn
    //   148: iconst_0
    //   149: istore 4
    //   151: goto -11 -> 140
    //   154: aload_2
    //   155: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   158: astore 6
    //   160: aload_3
    //   161: checkcast 450	java/lang/Number
    //   164: invokevirtual 453	java/lang/Number:intValue	()I
    //   167: istore 8
    //   169: aload 6
    //   171: iload 8
    //   173: invokestatic 243	kawa/lib/rnrs/hashtables:hashtableClear$Ex	(Lkawa/lib/kawa/hashtable$HashTable;I)V
    //   176: getstatic 356	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   179: areturn
    //   180: astore 17
    //   182: new 481	gnu/mapping/WrongType
    //   185: dup
    //   186: aload 17
    //   188: ldc 140
    //   190: iload 4
    //   192: aload_2
    //   193: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   196: athrow
    //   197: astore 19
    //   199: new 481	gnu/mapping/WrongType
    //   202: dup
    //   203: aload 19
    //   205: ldc 140
    //   207: iconst_2
    //   208: aload_3
    //   209: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   212: athrow
    //   213: astore 15
    //   215: new 481	gnu/mapping/WrongType
    //   218: dup
    //   219: aload 15
    //   221: ldc 120
    //   223: iload 4
    //   225: aload_2
    //   226: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   229: athrow
    //   230: astore 13
    //   232: new 481	gnu/mapping/WrongType
    //   235: dup
    //   236: aload 13
    //   238: ldc 116
    //   240: iload 4
    //   242: aload_2
    //   243: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   246: athrow
    //   247: astore 9
    //   249: new 481	gnu/mapping/WrongType
    //   252: dup
    //   253: aload 9
    //   255: ldc 108
    //   257: iload 4
    //   259: aload_2
    //   260: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   263: athrow
    //   264: astore 11
    //   266: new 481	gnu/mapping/WrongType
    //   269: dup
    //   270: aload 11
    //   272: ldc 108
    //   274: iconst_2
    //   275: aload_3
    //   276: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   279: athrow
    //   280: astore 5
    //   282: new 481	gnu/mapping/WrongType
    //   285: dup
    //   286: aload 5
    //   288: ldc 104
    //   290: iload 4
    //   292: aload_2
    //   293: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   296: athrow
    //   297: astore 7
    //   299: new 481	gnu/mapping/WrongType
    //   302: dup
    //   303: aload 7
    //   305: ldc 104
    //   307: iconst_2
    //   308: aload_3
    //   309: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   312: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	hashtables
    //   0	313	1	paramModuleMethod	ModuleMethod
    //   0	313	2	paramObject1	Object
    //   0	313	3	paramObject2	Object
    //   1	290	4	i	int
    //   280	7	5	localClassCastException1	ClassCastException
    //   158	12	6	localHashTable1	hashtable.HashTable
    //   297	7	7	localClassCastException2	ClassCastException
    //   167	5	8	j	int
    //   247	7	9	localClassCastException3	ClassCastException
    //   127	14	10	localHashTable2	hashtable.HashTable
    //   264	7	11	localClassCastException4	ClassCastException
    //   132	4	12	localBoolean	Boolean
    //   230	7	13	localClassCastException5	ClassCastException
    //   104	3	14	localHashTable3	hashtable.HashTable
    //   213	7	15	localClassCastException6	ClassCastException
    //   88	3	16	localHashTable4	hashtable.HashTable
    //   180	7	17	localClassCastException7	ClassCastException
    //   68	9	18	localProcedure1	Procedure
    //   197	7	19	localClassCastException8	ClassCastException
    //   74	5	20	localProcedure2	Procedure
    // Exception table:
    //   from	to	target	type
    //   64	70	180	java/lang/ClassCastException
    //   70	76	197	java/lang/ClassCastException
    //   84	90	213	java/lang/ClassCastException
    //   100	106	230	java/lang/ClassCastException
    //   123	129	247	java/lang/ClassCastException
    //   129	134	264	java/lang/ClassCastException
    //   154	160	280	java/lang/ClassCastException
    //   160	169	297	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 427	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+40 -> 44, 7:+50->54, 8:+40->44, 9:+40->44, 10:+40->44, 11:+82->86, 12:+97->101
    //   45: aload_1
    //   46: aload_2
    //   47: aload_3
    //   48: aload 4
    //   50: invokespecial 497	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: areturn
    //   54: aload_2
    //   55: checkcast 281	gnu/mapping/Procedure
    //   58: astore 10
    //   60: aload_3
    //   61: checkcast 281	gnu/mapping/Procedure
    //   64: astore 12
    //   66: aload 4
    //   68: checkcast 450	java/lang/Number
    //   71: invokevirtual 453	java/lang/Number:intValue	()I
    //   74: istore 14
    //   76: aload 10
    //   78: aload 12
    //   80: iload 14
    //   82: invokestatic 401	kawa/lib/rnrs/hashtables:makeHashtable	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;I)Lkawa/lib/kawa/hashtable$HashTable;
    //   85: areturn
    //   86: aload_2
    //   87: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   90: astore 8
    //   92: aload 8
    //   94: aload_3
    //   95: aload 4
    //   97: invokestatic 499	kawa/lib/rnrs/hashtables:hashtableRef	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: areturn
    //   101: aload_2
    //   102: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   105: astore 6
    //   107: aload 6
    //   109: aload_3
    //   110: aload 4
    //   112: invokestatic 350	kawa/lib/rnrs/hashtables:hashtableSet$Ex	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)V
    //   115: getstatic 356	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   118: areturn
    //   119: astore 9
    //   121: new 481	gnu/mapping/WrongType
    //   124: dup
    //   125: aload 9
    //   127: ldc 140
    //   129: iconst_1
    //   130: aload_2
    //   131: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   134: athrow
    //   135: astore 11
    //   137: new 481	gnu/mapping/WrongType
    //   140: dup
    //   141: aload 11
    //   143: ldc 140
    //   145: iconst_2
    //   146: aload_3
    //   147: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   150: athrow
    //   151: astore 13
    //   153: new 481	gnu/mapping/WrongType
    //   156: dup
    //   157: aload 13
    //   159: ldc 140
    //   161: iconst_3
    //   162: aload 4
    //   164: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   167: athrow
    //   168: astore 7
    //   170: new 481	gnu/mapping/WrongType
    //   173: dup
    //   174: aload 7
    //   176: ldc 128
    //   178: iconst_1
    //   179: aload_2
    //   180: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   183: athrow
    //   184: astore 5
    //   186: new 481	gnu/mapping/WrongType
    //   189: dup
    //   190: aload 5
    //   192: ldc 124
    //   194: iconst_1
    //   195: aload_2
    //   196: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   199: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	hashtables
    //   0	200	1	paramModuleMethod	ModuleMethod
    //   0	200	2	paramObject1	Object
    //   0	200	3	paramObject2	Object
    //   0	200	4	paramObject3	Object
    //   184	7	5	localClassCastException1	ClassCastException
    //   105	3	6	localHashTable1	hashtable.HashTable
    //   168	7	7	localClassCastException2	ClassCastException
    //   90	3	8	localHashTable2	hashtable.HashTable
    //   119	7	9	localClassCastException3	ClassCastException
    //   58	19	10	localProcedure1	Procedure
    //   135	7	11	localClassCastException4	ClassCastException
    //   64	15	12	localProcedure2	Procedure
    //   151	7	13	localClassCastException5	ClassCastException
    //   74	7	14	i	int
    // Exception table:
    //   from	to	target	type
    //   54	60	119	java/lang/ClassCastException
    //   60	66	135	java/lang/ClassCastException
    //   66	76	151	java/lang/ClassCastException
    //   86	92	168	java/lang/ClassCastException
    //   101	107	184	java/lang/ClassCastException
  }
  
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (paramModuleMethod.selector == 15) {}
    try
    {
      localHashTable = (hashtable.HashTable)paramObject1;
    }
    catch (ClassCastException localClassCastException1)
    {
      hashtable.HashTable localHashTable;
      Procedure localProcedure;
      throw new WrongType(localClassCastException1, "hashtable-update!", 1, paramObject1);
    }
    try
    {
      localProcedure = (Procedure)paramObject3;
      return hashtableUpdate$Ex(localHashTable, paramObject2, localProcedure, paramObject4);
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "hashtable-update!", 3, paramObject3);
    }
    return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 4: 
    default: 
      return super.match0(paramModuleMethod, paramCallContext);
    case 5: 
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
    int i = -786431;
    switch (paramModuleMethod.selector)
    {
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 17: 
    case 19: 
    default: 
      i = super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 28: 
    case 27: 
    case 26: 
    case 25: 
    case 24: 
    case 23: 
    case 22: 
    case 21: 
    case 20: 
    case 18: 
    case 16: 
    case 10: 
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
                      do
                      {
                        do
                        {
                          do
                          {
                            return i;
                          } while (!(paramObject instanceof Symbol));
                          paramCallContext.value1 = paramObject;
                          paramCallContext.proc = paramModuleMethod;
                          paramCallContext.pc = 1;
                          return 0;
                        } while (!(paramObject instanceof CharSequence));
                        paramCallContext.value1 = paramObject;
                        paramCallContext.proc = paramModuleMethod;
                        paramCallContext.pc = 1;
                        return 0;
                      } while (!(paramObject instanceof CharSequence));
                      paramCallContext.value1 = paramObject;
                      paramCallContext.proc = paramModuleMethod;
                      paramCallContext.pc = 1;
                      return 0;
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
      } while (!(paramObject instanceof hashtable.HashTable));
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 9: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 5: 
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
        } while (!(paramObject1 instanceof hashtable.HashTable));
        paramCallContext.value1 = paramObject1;
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
  }
  
  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    int i = -786431;
    switch (paramModuleMethod.selector)
    {
    case 8: 
    case 9: 
    case 10: 
    default: 
      i = super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
    do
    {
      do
      {
        do
        {
          return i;
        } while (!(paramObject1 instanceof hashtable.HashTable));
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      } while (!(paramObject1 instanceof hashtable.HashTable));
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    } while (!(paramObject1 instanceof Procedure));
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
    if (paramModuleMethod.selector == 15)
    {
      if (!(paramObject1 instanceof hashtable.HashTable)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
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
  
  public final void run(CallContext paramCallContext) {}
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.rnrs.hashtables
 * JD-Core Version:    0.7.0.1
 */