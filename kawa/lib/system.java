package kawa.lib;

import gnu.expr.ApplicationMainSupport;
import gnu.expr.Compilation;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.IsEqual;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.InputStream;
import kawa.lang.CompileFile;
import kawa.lang.NamedException;

public class system
  extends ModuleBody
{
  public static final system $instance;
  static final IntNum Lit0;
  static final IntNum Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11 = (SimpleSymbol)new SimpleSymbol("process-command-line-assignments").readResolve();
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod jdField_catch;
  public static Procedure command$Mnparse;
  public static final ModuleMethod compile$Mnfile;
  public static final ModuleMethod convert$Mnlist$Mnto$Mnstring$Mnarray;
  public static final ModuleMethod convert$Mnvector$Mnto$Mnstring$Mnarray;
  public static final ModuleMethod make$Mnprocess;
  public static final ModuleMethod open$Mninput$Mnpipe;
  public static final ModuleMethod process$Mncommand$Mnline$Mnassignments;
  public static final ModuleMethod system;
  public static final ModuleMethod tokenize$Mnstring$Mnto$Mnstring$Mnarray;
  public static final ModuleMethod tokenize$Mnstring$Mnusing$Mnshell;
  
  static
  {
    Lit10 = (SimpleSymbol)new SimpleSymbol("jdField_catch").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("compile-file").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("tokenize-string-using-shell").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("tokenize-string-to-string-array").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("convert-list-to-string-array").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("convert-vector-to-string-array").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("system").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("open-input-pipe").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("make-process").readResolve();
    Lit1 = IntNum.make(1);
    Lit0 = IntNum.make(0);
    $instance = new system();
    system localsystem = $instance;
    make$Mnprocess = new ModuleMethod(localsystem, 1, Lit2, 8194);
    open$Mninput$Mnpipe = new ModuleMethod(localsystem, 2, Lit3, 4097);
    system = new ModuleMethod(localsystem, 3, Lit4, 4097);
    convert$Mnvector$Mnto$Mnstring$Mnarray = new ModuleMethod(localsystem, 4, Lit5, 4097);
    convert$Mnlist$Mnto$Mnstring$Mnarray = new ModuleMethod(localsystem, 5, Lit6, 4097);
    tokenize$Mnstring$Mnto$Mnstring$Mnarray = new ModuleMethod(localsystem, 6, Lit7, 4097);
    tokenize$Mnstring$Mnusing$Mnshell = new ModuleMethod(localsystem, 7, Lit8, 4097);
    compile$Mnfile = new ModuleMethod(localsystem, 8, Lit9, 8194);
    jdField_catch = new ModuleMethod(localsystem, 9, Lit10, 12291);
    process$Mncommand$Mnline$Mnassignments = new ModuleMethod(localsystem, 10, Lit11, 0);
    $instance.run();
  }
  
  public system()
  {
    ModuleInfo.register(this);
  }
  
  public static Object jdField_catch(Object paramObject, Procedure paramProcedure1, Procedure paramProcedure2)
  {
    try
    {
      Object localObject = paramProcedure1.apply0();
      return localObject;
    }
    catch (NamedException localNamedException)
    {
      return localNamedException.applyHandler(paramObject, paramProcedure2);
    }
  }
  
  public static void compileFile(CharSequence paramCharSequence, String paramString)
  {
    SourceMessages localSourceMessages = new SourceMessages();
    Compilation localCompilation = CompileFile.read(paramCharSequence.toString(), localSourceMessages);
    localCompilation.explicit = true;
    if (localSourceMessages.seenErrors()) {
      throw ((Throwable)new SyntaxException(localSourceMessages));
    }
    localCompilation.compileToArchive(localCompilation.getModule(), paramString);
    if (localSourceMessages.seenErrors()) {
      throw ((Throwable)new SyntaxException(localSourceMessages));
    }
  }
  
  /* Error */
  public static Object convertListToStringArray(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 192	gnu/lists/LList
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 198	kawa/lib/lists:length	(Lgnu/lists/LList;)I
    //   9: anewarray 200	java/lang/String
    //   12: astore_3
    //   13: iconst_0
    //   14: istore 4
    //   16: aload_0
    //   17: astore 5
    //   19: aload 5
    //   21: invokestatic 204	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   24: ifeq +5 -> 29
    //   27: aload_3
    //   28: areturn
    //   29: aload 5
    //   31: checkcast 206	gnu/lists/Pair
    //   34: astore 7
    //   36: aload 7
    //   38: invokevirtual 209	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   41: astore 8
    //   43: aload 8
    //   45: ifnonnull +25 -> 70
    //   48: aconst_null
    //   49: astore 9
    //   51: aload_3
    //   52: iload 4
    //   54: aload 9
    //   56: aastore
    //   57: aload 7
    //   59: invokevirtual 212	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   62: astore 5
    //   64: iinc 4 1
    //   67: goto -48 -> 19
    //   70: aload 8
    //   72: invokevirtual 215	java/lang/Object:toString	()Ljava/lang/String;
    //   75: astore 9
    //   77: goto -26 -> 51
    //   80: astore_1
    //   81: new 217	gnu/mapping/WrongType
    //   84: dup
    //   85: aload_1
    //   86: ldc 218
    //   88: iconst_1
    //   89: aload_0
    //   90: invokespecial 221	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   93: athrow
    //   94: astore 6
    //   96: new 217	gnu/mapping/WrongType
    //   99: dup
    //   100: aload 6
    //   102: ldc 223
    //   104: bipush 254
    //   106: aload 5
    //   108: invokespecial 221	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramObject	Object
    //   80	6	1	localClassCastException1	ClassCastException
    //   4	2	2	localLList	gnu.lists.LList
    //   12	40	3	arrayOfString	String[]
    //   14	51	4	i	int
    //   17	90	5	localObject1	Object
    //   94	7	6	localClassCastException2	ClassCastException
    //   34	24	7	localPair	gnu.lists.Pair
    //   41	30	8	localObject2	Object
    //   49	27	9	str	String
    // Exception table:
    //   from	to	target	type
    //   0	5	80	java/lang/ClassCastException
    //   29	36	94	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object convertVectorToStringArray(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 226	gnu/lists/FVector
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 232	kawa/lib/vectors:vectorLength	(Lgnu/lists/FVector;)I
    //   9: istore_3
    //   10: iload_3
    //   11: anewarray 200	java/lang/String
    //   14: astore 4
    //   16: getstatic 93	kawa/lib/system:Lit0	Lgnu/math/IntNum;
    //   19: astore 5
    //   21: getstatic 238	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   24: aload 5
    //   26: iload_3
    //   27: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: invokevirtual 248	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   33: getstatic 254	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   36: if_acmpne +129 -> 165
    //   39: aload 5
    //   41: checkcast 256	java/lang/Number
    //   44: invokevirtual 260	java/lang/Number:intValue	()I
    //   47: istore 6
    //   49: aload_0
    //   50: checkcast 226	gnu/lists/FVector
    //   53: astore 8
    //   55: aload 5
    //   57: checkcast 256	java/lang/Number
    //   60: invokevirtual 260	java/lang/Number:intValue	()I
    //   63: istore 10
    //   65: aload 8
    //   67: iload 10
    //   69: invokestatic 264	kawa/lib/vectors:vectorRef	(Lgnu/lists/FVector;I)Ljava/lang/Object;
    //   72: astore 11
    //   74: aload 11
    //   76: ifnonnull +29 -> 105
    //   79: aconst_null
    //   80: astore 12
    //   82: aload 4
    //   84: iload 6
    //   86: aload 12
    //   88: aastore
    //   89: getstatic 270	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   92: aload 5
    //   94: getstatic 91	kawa/lib/system:Lit1	Lgnu/math/IntNum;
    //   97: invokevirtual 248	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: astore 5
    //   102: goto -81 -> 21
    //   105: aload 11
    //   107: invokevirtual 215	java/lang/Object:toString	()Ljava/lang/String;
    //   110: astore 12
    //   112: goto -30 -> 82
    //   115: astore_1
    //   116: new 217	gnu/mapping/WrongType
    //   119: dup
    //   120: aload_1
    //   121: ldc_w 272
    //   124: iconst_1
    //   125: aload_0
    //   126: invokespecial 221	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   129: athrow
    //   130: astore 7
    //   132: new 217	gnu/mapping/WrongType
    //   135: dup
    //   136: aload 7
    //   138: ldc_w 274
    //   141: iconst_1
    //   142: aload_0
    //   143: invokespecial 221	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   146: athrow
    //   147: astore 9
    //   149: new 217	gnu/mapping/WrongType
    //   152: dup
    //   153: aload 9
    //   155: ldc_w 274
    //   158: iconst_2
    //   159: aload 5
    //   161: invokespecial 221	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   164: athrow
    //   165: aload 4
    //   167: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramObject	Object
    //   115	6	1	localClassCastException1	ClassCastException
    //   4	2	2	localFVector1	gnu.lists.FVector
    //   9	18	3	i	int
    //   14	152	4	arrayOfString	String[]
    //   19	141	5	localObject1	Object
    //   47	38	6	j	int
    //   130	7	7	localClassCastException2	ClassCastException
    //   53	13	8	localFVector2	gnu.lists.FVector
    //   147	7	9	localClassCastException3	ClassCastException
    //   63	5	10	k	int
    //   72	34	11	localObject2	Object
    //   80	31	12	str	String
    // Exception table:
    //   from	to	target	type
    //   0	5	115	java/lang/ClassCastException
    //   49	55	130	java/lang/ClassCastException
    //   55	65	147	java/lang/ClassCastException
  }
  
  public static Process makeProcess(Object paramObject1, Object paramObject2)
  {
    if (vectors.isVector(paramObject1)) {
      localObject = convertVectorToStringArray(paramObject1);
    }
    for (;;)
    {
      Runtime localRuntime = Runtime.getRuntime();
      try
      {
        arrayOfString1 = (String[])localObject;
      }
      catch (ClassCastException localClassCastException1)
      {
        String[] arrayOfString1;
        String[] arrayOfString2;
        throw new WrongType(localClassCastException1, "java.lang.Runtime.exec(java.lang.String[],java.lang.String[])", 2, localObject);
      }
      try
      {
        arrayOfString2 = (String[])paramObject2;
        return localRuntime.exec(arrayOfString1, arrayOfString2);
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "java.lang.Runtime.exec(java.lang.String[],java.lang.String[])", 3, paramObject2);
      }
      if (lists.isList(paramObject1)) {
        localObject = convertListToStringArray(paramObject1);
      } else if (strings.isString(paramObject1)) {
        localObject = command$Mnparse.apply1(paramObject1);
      } else if ((paramObject1 instanceof String[])) {
        localObject = paramObject1;
      } else {
        localObject = misc.error$V("invalid arguments to make-process", new Object[0]);
      }
    }
  }
  
  public static InputStream openInputPipe(Object paramObject)
  {
    return makeProcess(paramObject, null).getInputStream();
  }
  
  public static void processCommandLineAssignments() {}
  
  public static int system(Object paramObject)
  {
    return makeProcess(paramObject, null).waitFor();
  }
  
  /* Error */
  public static Object tokenizeStringToStringArray(String paramString)
  {
    // Byte code:
    //   0: new 342	java/util/StringTokenizer
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 343	java/util/StringTokenizer:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: getstatic 347	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   12: astore_2
    //   13: aload_1
    //   14: invokevirtual 350	java/util/StringTokenizer:hasMoreTokens	()Z
    //   17: ifeq +15 -> 32
    //   20: aload_1
    //   21: invokevirtual 353	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   24: aload_2
    //   25: invokestatic 357	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   28: astore_2
    //   29: goto -16 -> 13
    //   32: aload_2
    //   33: checkcast 192	gnu/lists/LList
    //   36: astore 4
    //   38: aload 4
    //   40: invokestatic 198	kawa/lib/lists:length	(Lgnu/lists/LList;)I
    //   43: istore 5
    //   45: iload 5
    //   47: anewarray 200	java/lang/String
    //   50: astore 6
    //   52: iload 5
    //   54: iconst_1
    //   55: isub
    //   56: istore 7
    //   58: aload_2
    //   59: astore 8
    //   61: aload 8
    //   63: invokestatic 204	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   66: ifeq +6 -> 72
    //   69: aload 6
    //   71: areturn
    //   72: aload 8
    //   74: checkcast 206	gnu/lists/Pair
    //   77: astore 10
    //   79: aload 10
    //   81: invokevirtual 209	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   84: astore 11
    //   86: aload 11
    //   88: ifnonnull +26 -> 114
    //   91: aconst_null
    //   92: astore 12
    //   94: aload 6
    //   96: iload 7
    //   98: aload 12
    //   100: aastore
    //   101: aload 10
    //   103: invokevirtual 212	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   106: astore 8
    //   108: iinc 7 255
    //   111: goto -50 -> 61
    //   114: aload 11
    //   116: invokevirtual 215	java/lang/Object:toString	()Ljava/lang/String;
    //   119: astore 12
    //   121: goto -27 -> 94
    //   124: astore_3
    //   125: new 217	gnu/mapping/WrongType
    //   128: dup
    //   129: aload_3
    //   130: ldc 218
    //   132: iconst_1
    //   133: aload_2
    //   134: invokespecial 221	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   137: athrow
    //   138: astore 9
    //   140: new 217	gnu/mapping/WrongType
    //   143: dup
    //   144: aload 9
    //   146: ldc 223
    //   148: bipush 254
    //   150: aload 8
    //   152: invokespecial 221	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramString	String
    //   8	13	1	localStringTokenizer	java.util.StringTokenizer
    //   12	122	2	localObject1	Object
    //   124	6	3	localClassCastException1	ClassCastException
    //   36	3	4	localLList	gnu.lists.LList
    //   43	13	5	i	int
    //   50	45	6	arrayOfString	String[]
    //   56	53	7	j	int
    //   59	92	8	localObject2	Object
    //   138	7	9	localClassCastException2	ClassCastException
    //   77	25	10	localPair	gnu.lists.Pair
    //   84	31	11	localObject3	Object
    //   92	28	12	str	String
    // Exception table:
    //   from	to	target	type
    //   32	38	124	java/lang/ClassCastException
    //   72	79	138	java/lang/ClassCastException
  }
  
  public static String[] tokenizeStringUsingShell(Object paramObject)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "/bin/sh";
    arrayOfString[1] = "-c";
    if (paramObject == null) {}
    for (String str = null;; str = paramObject.toString())
    {
      arrayOfString[2] = str;
      return arrayOfString;
    }
  }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    if (paramModuleMethod.selector == 10)
    {
      processCommandLineAssignments();
      return Values.empty;
    }
    return super.apply0(paramModuleMethod);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 2: 
      return openInputPipe(paramObject);
    case 3: 
      return Integer.valueOf(system(paramObject));
    case 4: 
      return convertVectorToStringArray(paramObject);
    case 5: 
      return convertListToStringArray(paramObject);
    case 6: 
      if (paramObject == null) {}
      for (String str = null;; str = paramObject.toString()) {
        return tokenizeStringToStringArray(str);
      }
    }
    return tokenizeStringUsingShell(paramObject);
  }
  
  /* Error */
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 368	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+28->32, 1:+36->40, 8:+42->46
    //   33: aload_1
    //   34: aload_2
    //   35: aload_3
    //   36: invokespecial 392	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   39: areturn
    //   40: aload_2
    //   41: aload_3
    //   42: invokestatic 322	kawa/lib/system:makeProcess	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Process;
    //   45: areturn
    //   46: aload_2
    //   47: checkcast 151	java/lang/CharSequence
    //   50: astore 5
    //   52: aload_3
    //   53: ifnonnull +17 -> 70
    //   56: aconst_null
    //   57: astore 6
    //   59: aload 5
    //   61: aload 6
    //   63: invokestatic 394	kawa/lib/system:compileFile	(Ljava/lang/CharSequence;Ljava/lang/String;)V
    //   66: getstatic 376	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   69: areturn
    //   70: aload_3
    //   71: invokevirtual 215	java/lang/Object:toString	()Ljava/lang/String;
    //   74: astore 6
    //   76: goto -17 -> 59
    //   79: astore 4
    //   81: new 217	gnu/mapping/WrongType
    //   84: dup
    //   85: aload 4
    //   87: ldc 54
    //   89: iconst_1
    //   90: aload_2
    //   91: invokespecial 221	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	system
    //   0	95	1	paramModuleMethod	ModuleMethod
    //   0	95	2	paramObject1	Object
    //   0	95	3	paramObject2	Object
    //   79	7	4	localClassCastException	ClassCastException
    //   50	10	5	localCharSequence	CharSequence
    //   57	18	6	str	String
    // Exception table:
    //   from	to	target	type
    //   46	52	79	java/lang/ClassCastException
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramModuleMethod.selector == 9) {}
    try
    {
      localProcedure1 = (Procedure)paramObject2;
    }
    catch (ClassCastException localClassCastException1)
    {
      Procedure localProcedure1;
      Procedure localProcedure2;
      throw new WrongType(localClassCastException1, "jdField_catch", 2, paramObject2);
    }
    try
    {
      localProcedure2 = (Procedure)paramObject3;
      return jdField_catch(paramObject1, localProcedure1, localProcedure2);
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "jdField_catch", 3, paramObject3);
    }
    return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
  }
  
  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 10)
    {
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }
    return super.match0(paramModuleMethod, paramCallContext);
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
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
    case 8: 
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
    }
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
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure)) {
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
  
  public final void run(CallContext paramCallContext)
  {
    if (IsEqual.apply(System.getProperty("file.separator"), "/")) {}
    for (ModuleMethod localModuleMethod = tokenize$Mnstring$Mnusing$Mnshell;; localModuleMethod = tokenize$Mnstring$Mnto$Mnstring$Mnarray)
    {
      command$Mnparse = localModuleMethod;
      return;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.system
 * JD-Core Version:    0.7.0.1
 */