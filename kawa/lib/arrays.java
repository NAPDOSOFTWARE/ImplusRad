package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Arrays;
import gnu.lists.Array;
import gnu.lists.FVector;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;

public class arrays
  extends ModuleBody
{
  public static final Class $Lsarray$Gr;
  public static final arrays $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7 = (SimpleSymbol)new SimpleSymbol("share-array").readResolve();
  public static final ModuleMethod array;
  public static final ModuleMethod array$Mnend;
  public static final ModuleMethod array$Mnrank;
  public static final ModuleMethod array$Mnstart;
  public static final ModuleMethod array$Qu;
  public static final ModuleMethod make$Mnarray;
  public static final ModuleMethod shape;
  public static final ModuleMethod share$Mnarray;
  
  static
  {
    Lit6 = (SimpleSymbol)new SimpleSymbol("array-end").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("array-start").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("array-rank").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("array").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("make-array").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("shape").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("array?").readResolve();
    $Lsarray$Gr = Array.class;
    $instance = new arrays();
    arrays localarrays = $instance;
    array$Qu = new ModuleMethod(localarrays, 1, Lit0, 4097);
    shape = new ModuleMethod(localarrays, 2, Lit1, -4096);
    make$Mnarray = new ModuleMethod(localarrays, 3, Lit2, 8193);
    array = new ModuleMethod(localarrays, 5, Lit3, -4095);
    array$Mnrank = new ModuleMethod(localarrays, 6, Lit4, 4097);
    array$Mnstart = new ModuleMethod(localarrays, 7, Lit5, 8194);
    array$Mnend = new ModuleMethod(localarrays, 8, Lit6, 8194);
    share$Mnarray = new ModuleMethod(localarrays, 9, Lit7, 12291);
    $instance.run();
  }
  
  public arrays()
  {
    ModuleInfo.register(this);
  }
  
  public static Array array(Array paramArray, Object... paramVarArgs)
  {
    return Arrays.makeSimple(paramArray, new FVector(paramVarArgs));
  }
  
  public static int arrayEnd(Array paramArray, int paramInt)
  {
    return paramArray.getLowBound(paramInt) + paramArray.getSize(paramInt);
  }
  
  public static int arrayRank(Array paramArray)
  {
    return paramArray.rank();
  }
  
  public static int arrayStart(Array paramArray, int paramInt)
  {
    return paramArray.getLowBound(paramInt);
  }
  
  public static boolean isArray(Object paramObject)
  {
    return paramObject instanceof Array;
  }
  
  public static Array makeArray(Array paramArray)
  {
    return makeArray(paramArray, null);
  }
  
  public static Array makeArray(Array paramArray, Object paramObject)
  {
    return Arrays.make(paramArray, paramObject);
  }
  
  public static Array shape(Object... paramVarArgs)
  {
    return Arrays.shape(paramVarArgs);
  }
  
  public static Array shareArray(Array paramArray1, Array paramArray2, Procedure paramProcedure)
  {
    return Arrays.shareArray(paramArray1, paramArray2, paramProcedure);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 2: 
    case 4: 
    case 5: 
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 1: 
      if (isArray(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    try
    {
      Array localArray2 = (Array)paramObject;
      return makeArray(localArray2);
    }
    catch (ClassCastException localClassCastException2)
    {
      try
      {
        Array localArray1 = (Array)paramObject;
        return Integer.valueOf(arrayRank(localArray1));
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "array-rank", 1, paramObject);
      }
      localClassCastException2 = localClassCastException2;
      throw new WrongType(localClassCastException2, "make-array", 1, paramObject);
    }
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    case 4: 
    case 5: 
    case 6: 
    default: 
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    try
    {
      Array localArray3 = (Array)paramObject1;
      return makeArray(localArray3, paramObject2);
    }
    catch (ClassCastException localClassCastException5)
    {
      try
      {
        localArray2 = (Array)paramObject1;
      }
      catch (ClassCastException localClassCastException3)
      {
        Array localArray2;
        int j;
        Array localArray1;
        int i;
        throw new WrongType(localClassCastException3, "array-start", 1, paramObject1);
      }
      try
      {
        j = ((Number)paramObject2).intValue();
        return Integer.valueOf(arrayStart(localArray2, j));
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "array-start", 2, paramObject2);
      }
      try
      {
        localArray1 = (Array)paramObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "array-end", 1, paramObject1);
      }
      try
      {
        i = ((Number)paramObject2).intValue();
        return Integer.valueOf(arrayEnd(localArray1, i));
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "array-end", 2, paramObject2);
      }
      localClassCastException5 = localClassCastException5;
      throw new WrongType(localClassCastException5, "make-array", 1, paramObject1);
    }
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramModuleMethod.selector == 9) {}
    try
    {
      localArray1 = (Array)paramObject1;
    }
    catch (ClassCastException localClassCastException1)
    {
      Array localArray1;
      Array localArray2;
      Procedure localProcedure;
      throw new WrongType(localClassCastException1, "share-array", 1, paramObject1);
    }
    try
    {
      localArray2 = (Array)paramObject2;
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "share-array", 2, paramObject2);
    }
    try
    {
      localProcedure = (Procedure)paramObject3;
      return shareArray(localArray1, localArray2, localProcedure);
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "share-array", 3, paramObject3);
    }
    return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
  }
  
  /* Error */
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 160	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+32 -> 36, 2:+39->43, 3:+32->36, 4:+32->36, 5:+44->48
    //   37: aload_1
    //   38: aload_2
    //   39: invokespecial 212	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   42: areturn
    //   43: aload_2
    //   44: invokestatic 213	kawa/lib/arrays:shape	([Ljava/lang/Object;)Lgnu/lists/Array;
    //   47: areturn
    //   48: aload_2
    //   49: iconst_0
    //   50: aaload
    //   51: astore_3
    //   52: aload_3
    //   53: checkcast 70	gnu/lists/Array
    //   56: astore 5
    //   58: iconst_m1
    //   59: aload_2
    //   60: arraylength
    //   61: iadd
    //   62: istore 6
    //   64: iload 6
    //   66: anewarray 215	java/lang/Object
    //   69: astore 7
    //   71: iinc 6 255
    //   74: iload 6
    //   76: ifge +11 -> 87
    //   79: aload 5
    //   81: aload 7
    //   83: invokestatic 217	kawa/lib/arrays:array	(Lgnu/lists/Array;[Ljava/lang/Object;)Lgnu/lists/Array;
    //   86: areturn
    //   87: aload 7
    //   89: iload 6
    //   91: aload_2
    //   92: iload 6
    //   94: iconst_1
    //   95: iadd
    //   96: aaload
    //   97: aastore
    //   98: goto -27 -> 71
    //   101: astore 4
    //   103: new 185	gnu/mapping/WrongType
    //   106: dup
    //   107: aload 4
    //   109: ldc 55
    //   111: iconst_1
    //   112: aload_3
    //   113: invokespecial 188	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	arrays
    //   0	117	1	paramModuleMethod	ModuleMethod
    //   0	117	2	paramArrayOfObject	Object[]
    //   51	62	3	localObject	Object
    //   101	7	4	localClassCastException	ClassCastException
    //   56	24	5	localArray	Array
    //   62	34	6	i	int
    //   69	19	7	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   52	58	101	java/lang/ClassCastException
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    int i = -786431;
    switch (paramModuleMethod.selector)
    {
    case 2: 
    case 4: 
    case 5: 
    default: 
      i = super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 6: 
    case 3: 
      do
      {
        do
        {
          return i;
        } while (!(paramObject instanceof Array));
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      } while (!(paramObject instanceof Array));
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
    case 4: 
    case 5: 
    case 6: 
    default: 
      i = super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
    do
    {
      do
      {
        do
        {
          return i;
        } while (!(paramObject1 instanceof Array));
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      } while (!(paramObject1 instanceof Array));
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    } while (!(paramObject1 instanceof Array));
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }
  
  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 9)
    {
      if (!(paramObject1 instanceof Array)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Array)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      if (!(paramObject3 instanceof Procedure)) {
        return -786429;
      }
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
    case 3: 
    case 4: 
    default: 
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 5: 
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
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.arrays
 * JD-Core Version:    0.7.0.1
 */