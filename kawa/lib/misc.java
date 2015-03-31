package kawa.lib;

import gnu.expr.GenericProc;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Symbols;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.xml.KNode;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Path;
import kawa.Version;
import kawa.lang.Promise;
import kawa.standard.Scheme;
import kawa.standard.throw_name;

public class misc
  extends ModuleBody
{
  public static final misc $instance;
  static final IntNum Lit0;
  static final IntNum Lit1;
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
  static final Keyword Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final SimpleSymbol Lit28 = (SimpleSymbol)new SimpleSymbol("add-procedure-properties").readResolve();
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod add$Mnprocedure$Mnproperties;
  public static final ModuleMethod base$Mnuri;
  public static final ModuleMethod boolean$Qu;
  public static final ModuleMethod dynamic$Mnwind;
  public static final ModuleMethod environment$Mnbound$Qu;
  public static final ModuleMethod error;
  public static final ModuleMethod force;
  public static final ModuleMethod gentemp;
  public static final ModuleMethod interaction$Mnenvironment;
  static final ModuleMethod lambda$Fn1;
  static final ModuleMethod lambda$Fn2;
  public static final ModuleMethod namespace$Mnprefix;
  public static final ModuleMethod namespace$Mnuri;
  public static final ModuleMethod null$Mnenvironment;
  public static final GenericProc procedure$Mnproperty;
  static final ModuleMethod procedure$Mnproperty$Fn3;
  public static final ModuleMethod procedure$Qu;
  public static final ModuleMethod scheme$Mnimplementation$Mnversion;
  public static final ModuleMethod scheme$Mnreport$Mnenvironment;
  public static final ModuleMethod set$Mnprocedure$Mnproperty$Ex;
  public static final ModuleMethod string$Mn$Grsymbol;
  public static final GenericProc symbol$Eq$Qu;
  public static final ModuleMethod symbol$Mn$Grstring;
  public static final ModuleMethod symbol$Mnlocal$Mnname;
  public static final ModuleMethod symbol$Mnnamespace;
  public static final ModuleMethod symbol$Mnnamespace$Mnuri;
  public static final ModuleMethod symbol$Mnprefix;
  public static final ModuleMethod symbol$Qu;
  public static final ModuleMethod values;
  
  static
  {
    Lit27 = (SimpleSymbol)new SimpleSymbol("gentemp").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("base-uri").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("error").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("force").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("dynamic-wind").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("procedure-property").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("set-procedure-property!").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("scheme-implementation-version").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("interaction-environment").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("scheme-report-environment").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("null-environment").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("environment-bound?").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("values").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("procedure?").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("string->symbol").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("namespace-prefix").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("namespace-uri").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("symbol-prefix").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("symbol-namespace-uri").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("symbol-namespace").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("symbol-local-name").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("symbol->string").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("symbol?").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("boolean?").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("misc-error").readResolve();
    Lit2 = Keyword.make("setter");
    Lit1 = IntNum.make(5);
    Lit0 = IntNum.make(4);
    $instance = new misc();
    misc localmisc = $instance;
    boolean$Qu = new ModuleMethod(localmisc, 3, Lit4, 4097);
    symbol$Qu = new ModuleMethod(localmisc, 4, Lit5, 4097);
    symbol$Mn$Grstring = new ModuleMethod(localmisc, 5, Lit6, 4097);
    ModuleMethod localModuleMethod1 = new ModuleMethod(localmisc, 6, null, 8194);
    localModuleMethod1.setProperty("source-location", "misc.scm:25");
    lambda$Fn1 = localModuleMethod1;
    ModuleMethod localModuleMethod2 = new ModuleMethod(localmisc, 7, null, -4094);
    localModuleMethod2.setProperty("source-location", "misc.scm:27");
    lambda$Fn2 = localModuleMethod2;
    symbol$Mnlocal$Mnname = new ModuleMethod(localmisc, 8, Lit7, 4097);
    symbol$Mnnamespace = new ModuleMethod(localmisc, 9, Lit8, 4097);
    symbol$Mnnamespace$Mnuri = new ModuleMethod(localmisc, 10, Lit9, 4097);
    symbol$Mnprefix = new ModuleMethod(localmisc, 11, Lit10, 4097);
    namespace$Mnuri = new ModuleMethod(localmisc, 12, Lit11, 4097);
    namespace$Mnprefix = new ModuleMethod(localmisc, 13, Lit12, 4097);
    string$Mn$Grsymbol = new ModuleMethod(localmisc, 14, Lit13, 4097);
    procedure$Qu = new ModuleMethod(localmisc, 15, Lit14, 4097);
    values = new ModuleMethod(localmisc, 16, Lit15, -4096);
    environment$Mnbound$Qu = new ModuleMethod(localmisc, 17, Lit16, 8194);
    null$Mnenvironment = new ModuleMethod(localmisc, 18, Lit17, 4096);
    scheme$Mnreport$Mnenvironment = new ModuleMethod(localmisc, 20, Lit18, 4097);
    interaction$Mnenvironment = new ModuleMethod(localmisc, 21, Lit19, 0);
    scheme$Mnimplementation$Mnversion = new ModuleMethod(localmisc, 22, Lit20, 0);
    set$Mnprocedure$Mnproperty$Ex = new ModuleMethod(localmisc, 23, Lit21, 12291);
    procedure$Mnproperty$Fn3 = new ModuleMethod(localmisc, 24, Lit22, 12290);
    dynamic$Mnwind = new ModuleMethod(localmisc, 26, Lit23, 12291);
    force = new ModuleMethod(localmisc, 27, Lit24, 4097);
    error = new ModuleMethod(localmisc, 28, Lit25, -4095);
    base$Mnuri = new ModuleMethod(localmisc, 29, Lit26, 4096);
    gentemp = new ModuleMethod(localmisc, 31, Lit27, 0);
    add$Mnprocedure$Mnproperties = new ModuleMethod(localmisc, 32, Lit28, -4095);
    $instance.run();
  }
  
  public misc()
  {
    ModuleInfo.register(this);
  }
  
  public static void addProcedureProperties(GenericProc paramGenericProc, Object... paramVarArgs)
  {
    paramGenericProc.setProperties(paramVarArgs);
  }
  
  public static Object baseUri()
  {
    return baseUri(null);
  }
  
  public static Object baseUri(Object paramObject)
  {
    if (paramObject == null) {}
    for (Object localObject = Path.currentPath();; localObject = ((KNode)paramObject).baseURI())
    {
      if (localObject == Values.empty) {
        localObject = Boolean.FALSE;
      }
      return localObject;
    }
  }
  
  public static Object dynamicWind(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Scheme.applyToArgs.apply1(paramObject1);
    try
    {
      Object localObject2 = Scheme.applyToArgs.apply1(paramObject2);
      return localObject2;
    }
    finally
    {
      Scheme.applyToArgs.apply1(paramObject3);
    }
  }
  
  public static Object error$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame localframe = new frame();
    localframe.msg = paramObject;
    LList localLList1 = LList.makeList(paramArrayOfObject, 0);
    localframe.msg = ports.callWithOutputString(localframe.lambda$Fn4);
    Object localObject1 = LList.Empty;
    Object localObject2 = localLList1;
    for (;;)
    {
      if (localObject2 == LList.Empty)
      {
        LList localLList2 = LList.reverseInPlace(localObject1);
        return Scheme.apply.apply4(throw_name.throwName, Lit3, localframe.msg, localLList2);
      }
      try
      {
        Pair localPair = (Pair)localObject2;
        Object localObject3 = localPair.getCdr();
        Object localObject4 = localPair.getCar();
        frame0 localframe0 = new frame0();
        localframe0.arg = localObject4;
        localObject1 = Pair.make(ports.callWithOutputString(localframe0.lambda$Fn5), localObject1);
        localObject2 = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject2);
      }
    }
  }
  
  public static Object force(Object paramObject)
  {
    return Promise.force(paramObject);
  }
  
  public static Symbol gentemp()
  {
    return Symbols.gentemp();
  }
  
  public static Environment interactionEnvironment()
  {
    return Environment.user();
  }
  
  public static boolean isBoolean(Object paramObject)
  {
    if (paramObject == Boolean.TRUE) {}
    for (boolean bool = true; bool; bool = false) {
      return bool;
    }
    return paramObject == Boolean.FALSE;
  }
  
  public static boolean isEnvironmentBound(Environment paramEnvironment, Object paramObject)
  {
    return paramEnvironment.isBound(LispLanguage.langSymbolToSymbol(paramObject));
  }
  
  public static boolean isProcedure(Object paramObject)
  {
    boolean bool = paramObject instanceof Procedure;
    if (bool) {
      return bool;
    }
    return paramObject instanceof LangObjType;
  }
  
  public static boolean isSymbol(Object paramObject)
  {
    return paramObject instanceof Symbol;
  }
  
  static boolean lambda1(Symbol paramSymbol1, Symbol paramSymbol2)
  {
    return Symbol.equals(paramSymbol1, paramSymbol2);
  }
  
  static boolean lambda2$V(Symbol paramSymbol1, Symbol paramSymbol2, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    boolean bool1 = Symbol.equals(paramSymbol1, paramSymbol2);
    if (bool1)
    {
      Object localObject = Scheme.apply.apply3(symbol$Eq$Qu, paramSymbol2, localLList);
      Boolean localBoolean = Boolean.FALSE;
      boolean bool2 = false;
      if (localObject != localBoolean) {
        bool2 = true;
      }
      return bool2;
    }
    return bool1;
  }
  
  public static CharSequence namespacePrefix(Namespace paramNamespace)
  {
    return paramNamespace.getPrefix();
  }
  
  public static CharSequence namespaceUri(Namespace paramNamespace)
  {
    return paramNamespace.getName();
  }
  
  public static Environment nullEnvironment()
  {
    return nullEnvironment(Boolean.FALSE);
  }
  
  public static Environment nullEnvironment(Object paramObject)
  {
    return Scheme.nullEnvironment;
  }
  
  public static Object procedureProperty(Procedure paramProcedure, Object paramObject)
  {
    return procedureProperty(paramProcedure, paramObject, Boolean.FALSE);
  }
  
  public static Object procedureProperty(Procedure paramProcedure, Object paramObject1, Object paramObject2)
  {
    return paramProcedure.getProperty(paramObject1, paramObject2);
  }
  
  public static String schemeImplementationVersion()
  {
    return Version.getVersion();
  }
  
  public static Object schemeReportEnvironment(Object paramObject)
  {
    if (Scheme.isEqv.apply2(paramObject, Lit0) != Boolean.FALSE) {
      return Scheme.r4Environment;
    }
    if (Scheme.isEqv.apply2(paramObject, Lit1) != Boolean.FALSE) {
      return Scheme.r5Environment;
    }
    return error$V("scheme-report-environment version must be 4 or 5", new Object[0]);
  }
  
  public static void setProcedureProperty$Ex(Procedure paramProcedure, Object paramObject1, Object paramObject2)
  {
    paramProcedure.setProperty(paramObject1, paramObject2);
  }
  
  public static SimpleSymbol string$To$Symbol(CharSequence paramCharSequence)
  {
    return SimpleSymbol.valueOf(paramCharSequence.toString());
  }
  
  public static String symbol$To$String(Symbol paramSymbol)
  {
    return paramSymbol.toString();
  }
  
  public static String symbolLocalName(Symbol paramSymbol)
  {
    return paramSymbol.getLocalPart();
  }
  
  public static Namespace symbolNamespace(Symbol paramSymbol)
  {
    return paramSymbol.getNamespace();
  }
  
  public static String symbolNamespaceUri(Symbol paramSymbol)
  {
    return paramSymbol.getNamespaceURI();
  }
  
  public static String symbolPrefix(Symbol paramSymbol)
  {
    return paramSymbol.getPrefix();
  }
  
  public static Object values(Object... paramVarArgs)
  {
    return Values.make(paramVarArgs);
  }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply0(paramModuleMethod);
    case 18: 
      return nullEnvironment();
    case 21: 
      return interactionEnvironment();
    case 22: 
      return schemeImplementationVersion();
    case 29: 
      return baseUri();
    }
    return gentemp();
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 6: 
    case 7: 
    case 16: 
    case 17: 
    case 19: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 28: 
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 3: 
      if (isBoolean(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 4: 
      if (isSymbol(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    try
    {
      Symbol localSymbol5 = (Symbol)paramObject;
      return symbol$To$String(localSymbol5);
    }
    catch (ClassCastException localClassCastException8)
    {
      Symbol localSymbol4;
      Symbol localSymbol3;
      Symbol localSymbol2;
      Symbol localSymbol1;
      Namespace localNamespace2;
      Namespace localNamespace1;
      CharSequence localCharSequence;
      throw new WrongType(localClassCastException8, "symbol->string", 1, paramObject);
    }
    try
    {
      localSymbol4 = (Symbol)paramObject;
      return symbolLocalName(localSymbol4);
    }
    catch (ClassCastException localClassCastException7)
    {
      throw new WrongType(localClassCastException7, "symbol-local-name", 1, paramObject);
    }
    try
    {
      localSymbol3 = (Symbol)paramObject;
      return symbolNamespace(localSymbol3);
    }
    catch (ClassCastException localClassCastException6)
    {
      throw new WrongType(localClassCastException6, "symbol-namespace", 1, paramObject);
    }
    try
    {
      localSymbol2 = (Symbol)paramObject;
      return symbolNamespaceUri(localSymbol2);
    }
    catch (ClassCastException localClassCastException5)
    {
      throw new WrongType(localClassCastException5, "symbol-namespace-uri", 1, paramObject);
    }
    try
    {
      localSymbol1 = (Symbol)paramObject;
      return symbolPrefix(localSymbol1);
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "symbol-prefix", 1, paramObject);
    }
    try
    {
      localNamespace2 = (Namespace)paramObject;
      return namespaceUri(localNamespace2);
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "namespace-uri", 1, paramObject);
    }
    try
    {
      localNamespace1 = (Namespace)paramObject;
      return namespacePrefix(localNamespace1);
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new WrongType(localClassCastException2, "namespace-prefix", 1, paramObject);
    }
    try
    {
      localCharSequence = (CharSequence)paramObject;
      return string$To$Symbol(localCharSequence);
    }
    catch (ClassCastException localClassCastException1)
    {
      throw new WrongType(localClassCastException1, "string->symbol", 1, paramObject);
    }
    if (isProcedure(paramObject)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    return nullEnvironment(paramObject);
    return schemeReportEnvironment(paramObject);
    return force(paramObject);
    return baseUri(paramObject);
  }
  
  /* Error */
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 556	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+36->40, 6:+44->48, 17:+74->78, 24:+97->101
    //   41: aload_1
    //   42: aload_2
    //   43: aload_3
    //   44: invokespecial 599	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: areturn
    //   48: aload_2
    //   49: checkcast 448	gnu/mapping/Symbol
    //   52: astore 9
    //   54: aload_3
    //   55: checkcast 448	gnu/mapping/Symbol
    //   58: astore 11
    //   60: aload 9
    //   62: aload 11
    //   64: invokestatic 601	kawa/lib/misc:lambda1	(Lgnu/mapping/Symbol;Lgnu/mapping/Symbol;)Z
    //   67: ifeq +7 -> 74
    //   70: getstatic 430	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   73: areturn
    //   74: getstatic 315	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   77: areturn
    //   78: aload_2
    //   79: checkcast 422	gnu/mapping/Environment
    //   82: astore 7
    //   84: aload 7
    //   86: aload_3
    //   87: invokestatic 603	kawa/lib/misc:isEnvironmentBound	(Lgnu/mapping/Environment;Ljava/lang/Object;)Z
    //   90: ifeq +7 -> 97
    //   93: getstatic 430	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   96: areturn
    //   97: getstatic 315	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   100: areturn
    //   101: aload_2
    //   102: checkcast 330	gnu/mapping/Procedure
    //   105: astore 5
    //   107: aload 5
    //   109: aload_3
    //   110: invokestatic 605	kawa/lib/misc:procedureProperty	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: areturn
    //   114: astore 8
    //   116: new 403	gnu/mapping/WrongType
    //   119: dup
    //   120: aload 8
    //   122: ldc_w 607
    //   125: iconst_1
    //   126: aload_2
    //   127: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   130: athrow
    //   131: astore 10
    //   133: new 403	gnu/mapping/WrongType
    //   136: dup
    //   137: aload 10
    //   139: ldc_w 607
    //   142: iconst_2
    //   143: aload_3
    //   144: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   147: athrow
    //   148: astore 6
    //   150: new 403	gnu/mapping/WrongType
    //   153: dup
    //   154: aload 6
    //   156: ldc 128
    //   158: iconst_1
    //   159: aload_2
    //   160: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   163: athrow
    //   164: astore 4
    //   166: new 403	gnu/mapping/WrongType
    //   169: dup
    //   170: aload 4
    //   172: ldc 104
    //   174: iconst_1
    //   175: aload_2
    //   176: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	misc
    //   0	180	1	paramModuleMethod	ModuleMethod
    //   0	180	2	paramObject1	Object
    //   0	180	3	paramObject2	Object
    //   164	7	4	localClassCastException1	ClassCastException
    //   105	3	5	localProcedure	Procedure
    //   148	7	6	localClassCastException2	ClassCastException
    //   82	3	7	localEnvironment	Environment
    //   114	7	8	localClassCastException3	ClassCastException
    //   52	9	9	localSymbol1	Symbol
    //   131	7	10	localClassCastException4	ClassCastException
    //   58	5	11	localSymbol2	Symbol
    // Exception table:
    //   from	to	target	type
    //   48	54	114	java/lang/ClassCastException
    //   54	60	131	java/lang/ClassCastException
    //   78	84	148	java/lang/ClassCastException
    //   101	107	164	java/lang/ClassCastException
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (paramModuleMethod.selector)
    {
    case 25: 
    default: 
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    try
    {
      Procedure localProcedure2 = (Procedure)paramObject1;
      setProcedureProperty$Ex(localProcedure2, paramObject2, paramObject3);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException2)
    {
      Procedure localProcedure1;
      throw new WrongType(localClassCastException2, "set-procedure-property!", 1, paramObject1);
    }
    try
    {
      localProcedure1 = (Procedure)paramObject1;
      return procedureProperty(localProcedure1, paramObject2, paramObject3);
    }
    catch (ClassCastException localClassCastException1)
    {
      throw new WrongType(localClassCastException1, "procedure-property", 1, paramObject1);
    }
    return dynamicWind(paramObject1, paramObject2, paramObject3);
  }
  
  /* Error */
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 556	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+44->48, 7:+51->55, 16:+131->135, 28:+136->140, 32:+184->188
    //   49: aload_1
    //   50: aload_2
    //   51: invokespecial 618	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   54: areturn
    //   55: aload_2
    //   56: iconst_0
    //   57: aaload
    //   58: astore 11
    //   60: aload 11
    //   62: checkcast 448	gnu/mapping/Symbol
    //   65: astore 13
    //   67: aload_2
    //   68: iconst_1
    //   69: aaload
    //   70: astore 14
    //   72: aload 14
    //   74: checkcast 448	gnu/mapping/Symbol
    //   77: astore 16
    //   79: bipush 254
    //   81: aload_2
    //   82: arraylength
    //   83: iadd
    //   84: istore 17
    //   86: iload 17
    //   88: anewarray 512	java/lang/Object
    //   91: astore 18
    //   93: iinc 17 255
    //   96: iload 17
    //   98: ifge +19 -> 117
    //   101: aload 13
    //   103: aload 16
    //   105: aload 18
    //   107: invokestatic 620	kawa/lib/misc:lambda2$V	(Lgnu/mapping/Symbol;Lgnu/mapping/Symbol;[Ljava/lang/Object;)Z
    //   110: ifeq +21 -> 131
    //   113: getstatic 430	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   116: areturn
    //   117: aload 18
    //   119: iload 17
    //   121: aload_2
    //   122: iload 17
    //   124: iconst_2
    //   125: iadd
    //   126: aaload
    //   127: aastore
    //   128: goto -35 -> 93
    //   131: getstatic 315	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   134: areturn
    //   135: aload_2
    //   136: invokestatic 622	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   139: areturn
    //   140: aload_2
    //   141: iconst_0
    //   142: aaload
    //   143: astore 8
    //   145: iconst_m1
    //   146: aload_2
    //   147: arraylength
    //   148: iadd
    //   149: istore 9
    //   151: iload 9
    //   153: anewarray 512	java/lang/Object
    //   156: astore 10
    //   158: iinc 9 255
    //   161: iload 9
    //   163: ifge +11 -> 174
    //   166: aload 8
    //   168: aload 10
    //   170: invokestatic 514	kawa/lib/misc:error$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   173: areturn
    //   174: aload 10
    //   176: iload 9
    //   178: aload_2
    //   179: iload 9
    //   181: iconst_1
    //   182: iadd
    //   183: aaload
    //   184: aastore
    //   185: goto -27 -> 158
    //   188: aload_2
    //   189: iconst_0
    //   190: aaload
    //   191: astore_3
    //   192: aload_3
    //   193: checkcast 289	gnu/expr/GenericProc
    //   196: astore 5
    //   198: iconst_m1
    //   199: aload_2
    //   200: arraylength
    //   201: iadd
    //   202: istore 6
    //   204: iload 6
    //   206: anewarray 512	java/lang/Object
    //   209: astore 7
    //   211: iinc 6 255
    //   214: iload 6
    //   216: ifge +14 -> 230
    //   219: aload 5
    //   221: aload 7
    //   223: invokestatic 624	kawa/lib/misc:addProcedureProperties	(Lgnu/expr/GenericProc;[Ljava/lang/Object;)V
    //   226: getstatic 309	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   229: areturn
    //   230: aload 7
    //   232: iload 6
    //   234: aload_2
    //   235: iload 6
    //   237: iconst_1
    //   238: iadd
    //   239: aaload
    //   240: aastore
    //   241: goto -30 -> 211
    //   244: astore 12
    //   246: new 403	gnu/mapping/WrongType
    //   249: dup
    //   250: aload 12
    //   252: ldc_w 607
    //   255: iconst_1
    //   256: aload 11
    //   258: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   261: athrow
    //   262: astore 15
    //   264: new 403	gnu/mapping/WrongType
    //   267: dup
    //   268: aload 15
    //   270: ldc_w 607
    //   273: iconst_2
    //   274: aload 14
    //   276: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   279: athrow
    //   280: astore 4
    //   282: new 403	gnu/mapping/WrongType
    //   285: dup
    //   286: aload 4
    //   288: ldc 75
    //   290: iconst_1
    //   291: aload_3
    //   292: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   295: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	misc
    //   0	296	1	paramModuleMethod	ModuleMethod
    //   0	296	2	paramArrayOfObject	Object[]
    //   191	101	3	localObject1	Object
    //   280	7	4	localClassCastException1	ClassCastException
    //   196	24	5	localGenericProc	GenericProc
    //   202	37	6	i	int
    //   209	22	7	arrayOfObject1	Object[]
    //   143	24	8	localObject2	Object
    //   149	34	9	j	int
    //   156	19	10	arrayOfObject2	Object[]
    //   58	199	11	localObject3	Object
    //   244	7	12	localClassCastException2	ClassCastException
    //   65	37	13	localSymbol1	Symbol
    //   70	205	14	localObject4	Object
    //   262	7	15	localClassCastException3	ClassCastException
    //   77	27	16	localSymbol2	Symbol
    //   84	42	17	k	int
    //   91	27	18	arrayOfObject3	Object[]
    // Exception table:
    //   from	to	target	type
    //   60	67	244	java/lang/ClassCastException
    //   72	79	262	java/lang/ClassCastException
    //   192	198	280	java/lang/ClassCastException
  }
  
  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match0(paramModuleMethod, paramCallContext);
    case 31: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 29: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 22: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 21: 
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
    switch (paramModuleMethod.selector)
    {
    case 6: 
    case 7: 
    case 16: 
    case 17: 
    case 19: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 28: 
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
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
    case 20: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 18: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 15: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 14: 
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 13: 
      if (!(paramObject instanceof Namespace)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 12: 
      if (!(paramObject instanceof Namespace)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 11: 
      if (!(paramObject instanceof Symbol)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 10: 
      if (!(paramObject instanceof Symbol)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 9: 
      if (!(paramObject instanceof Symbol)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 8: 
      if (!(paramObject instanceof Symbol)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 5: 
      if (!(paramObject instanceof Symbol)) {
        return -786431;
      }
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
        } while (!(paramObject1 instanceof Procedure));
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      } while (!(paramObject1 instanceof Environment));
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    } while (!(paramObject1 instanceof Symbol));
    paramCallContext.value1 = paramObject1;
    if (!(paramObject2 instanceof Symbol)) {
      return -786430;
    }
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }
  
  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 25: 
    default: 
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 26: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 24: 
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
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 32: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 28: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 16: 
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
    symbol$Eq$Qu = new GenericProc("symbol=?");
    GenericProc localGenericProc1 = symbol$Eq$Qu;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = lambda$Fn1;
    arrayOfObject1[1] = lambda$Fn2;
    localGenericProc1.setProperties(arrayOfObject1);
    procedure$Mnproperty = new GenericProc("procedure-property");
    GenericProc localGenericProc2 = procedure$Mnproperty;
    Object[] arrayOfObject2 = new Object[3];
    arrayOfObject2[0] = Lit2;
    arrayOfObject2[1] = set$Mnprocedure$Mnproperty$Ex;
    arrayOfObject2[2] = procedure$Mnproperty$Fn3;
    localGenericProc2.setProperties(arrayOfObject2);
  }
  
  public class frame
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn4;
    Object msg;
    
    public frame()
    {
      this$1 = new ModuleMethod(this, 2, null, 4097);
      this$1.setProperty("source-location", "misc.scm:104");
      this.lambda$Fn4 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 2)
      {
        lambda3(paramObject);
        return Values.empty;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    void lambda3(Object paramObject)
    {
      ports.display(this.msg, paramObject);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 2)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame0
    extends ModuleBody
  {
    Object arg;
    final ModuleMethod lambda$Fn5;
    
    public frame0()
    {
      this$1 = new ModuleMethod(this, 1, null, 4097);
      this$1.setProperty("source-location", "misc.scm:107");
      this.lambda$Fn5 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 1)
      {
        lambda4(paramObject);
        return Values.empty;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    void lambda4(Object paramObject)
    {
      ports.write(this.arg, paramObject);
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
 * Qualified Name:     kawa.lib.misc
 * JD-Core Version:    0.7.0.1
 */