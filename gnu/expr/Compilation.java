package gnu.expr;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.SwitchState;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.functions.Convert;
import gnu.mapping.Environment;
import gnu.mapping.Namespace;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.text.Lexer;
import gnu.text.Options;
import gnu.text.Options.OptionInfo;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;
import java.util.Vector;
import java.util.jar.JarOutputStream;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compilation
  implements SourceLocator
{
  public static final int BODY_PARSED = 4;
  public static final int CALL_WITH_CONSUMER = 2;
  public static final int CALL_WITH_CONTINUATIONS = 4;
  public static final int CALL_WITH_RETURN = 1;
  public static final int CALL_WITH_TAILCALLS = 3;
  public static final int CALL_WITH_UNSPECIFIED = 0;
  public static final int CLASS_WRITTEN = 14;
  public static final int COMPILED = 12;
  public static final int COMPILE_SETUP = 10;
  public static final int ERROR_SEEN = 100;
  public static final int MODULE_NONSTATIC = -1;
  public static final int MODULE_STATIC = 1;
  public static final int MODULE_STATIC_DEFAULT = 0;
  public static final int MODULE_STATIC_RUN = 2;
  public static final int PROLOG_PARSED = 2;
  public static final int PROLOG_PARSING = 1;
  public static final int RESOLVED = 6;
  public static final int WALKED = 8;
  public static Type[] apply0args;
  public static Method apply0method;
  public static Type[] apply1args;
  public static Method apply1method;
  public static Type[] apply2args;
  public static Method apply2method;
  public static Method apply3method;
  public static Method apply4method;
  private static Type[] applyCpsArgs;
  public static Method applyCpsMethod;
  public static Type[] applyNargs;
  public static Method applyNmethod;
  public static Method[] applymethods;
  public static gnu.bytecode.Field argsCallContextField;
  private static Compilation chainUninitialized;
  static Method checkArgCountMethod;
  public static String classPrefixDefault;
  private static final ThreadLocal<Compilation> current = new InheritableThreadLocal();
  public static boolean debugPrintExpr = false;
  public static boolean debugPrintFinalExpr;
  public static int defaultCallConvention;
  public static int defaultClassFileVersion;
  public static boolean emitSourceDebugExtAttr;
  public static final gnu.bytecode.Field falseConstant;
  public static boolean generateMainDefault;
  public static Method getCallContextInstanceMethod;
  public static Method getCurrentEnvironmentMethod;
  public static final Method getLocation1EnvironmentMethod;
  public static final Method getLocation2EnvironmentMethod;
  public static final Method getLocationMethod;
  public static final Method getProcedureBindingMethod;
  public static final Method getSymbolProcedureMethod;
  public static final Method getSymbolValueMethod;
  public static boolean inlineOk;
  public static final Type[] int1Args;
  public static ClassType javaStringType;
  static Method makeListMethod;
  public static int moduleStatic;
  public static gnu.bytecode.Field noArgsField;
  public static final ArrayType objArrayType;
  public static Options options = new Options();
  public static gnu.bytecode.Field pcCallContextField;
  public static gnu.bytecode.Field procCallContextField;
  public static ClassType scmBooleanType;
  public static ClassType scmKeywordType;
  public static ClassType scmListType;
  public static ClassType scmSequenceType;
  static final Method setNameMethod;
  public static final Type[] string1Arg;
  public static final Type[] sym1Arg;
  public static final gnu.bytecode.Field trueConstant;
  public static ClassType typeApplet;
  public static ClassType typeCallContext;
  public static ClassType typeClass;
  public static ClassType typeClassType;
  public static final ClassType typeConsumer;
  public static ClassType typeEnvironment;
  public static ClassType typeLanguage;
  public static ClassType typeLocation;
  public static ClassType typeMethodProc;
  public static ClassType typeModuleBody;
  public static ClassType typeModuleMethod;
  public static ClassType typeModuleWithContext;
  public static ClassType typeObject;
  public static ClassType typeObjectType;
  public static ClassType typePair;
  public static ClassType typeProcedure;
  public static ClassType typeProcedure0;
  public static ClassType typeProcedure1;
  public static ClassType typeProcedure2;
  public static ClassType typeProcedure3;
  public static ClassType typeProcedure4;
  public static ClassType[] typeProcedureArray;
  public static ClassType typeProcedureN;
  public static ClassType typeRunnable;
  public static ClassType typeServlet;
  public static ClassType typeString;
  public static ClassType typeSymbol;
  public static ClassType typeType;
  public static ClassType typeValues;
  public static Options.OptionInfo warnAsError;
  public static Options.OptionInfo warnInvokeUnknownMethod;
  public static Options.OptionInfo warnUndefinedVariable = options.add("warn-undefined-variable", 1, Boolean.TRUE, "warn if no compiler-visible binding for a variable");
  public static Options.OptionInfo warnUnknownMember = options.add("warn-unknown-member", 1, Boolean.TRUE, "warn if referencing an unknown method or field");
  Variable callContextVar;
  Variable callContextVarForInit;
  public String classPrefix = classPrefixDefault;
  ClassType[] classes;
  Initializer clinitChain;
  Method clinitMethod;
  public ClassType curClass;
  public LambdaExp curLambda;
  public Options currentOptions = new Options(options);
  protected ScopeExp current_scope;
  public boolean explicit;
  public Stack<Expression> exprStack;
  Method forNameHelper;
  SwitchState fswitch;
  gnu.bytecode.Field fswitchIndex;
  public boolean generateMain = generateMainDefault;
  public boolean immediate;
  private int keyUninitialized;
  int langOptions;
  protected Language language;
  public Lexer lexer;
  public NameLookup lexical;
  LitTable litTable;
  ArrayClassLoader loader;
  int localFieldIndex;
  public ClassType mainClass;
  public ModuleExp mainLambda;
  int maxSelectorValue;
  protected SourceMessages messages;
  public Method method;
  int method_counter;
  public ModuleInfo minfo;
  public ClassType moduleClass;
  gnu.bytecode.Field moduleInstanceMainField;
  Variable moduleInstanceVar;
  public boolean mustCompile = ModuleExp.alwaysCompile;
  private Compilation nextUninitialized;
  int numClasses;
  boolean pedantic;
  public Stack<Object> pendingImports;
  private int state;
  public Variable thisDecl;
  
  static
  {
    warnInvokeUnknownMethod = options.add("warn-invoke-unknown-method", 1, warnUnknownMember, "warn if invoke calls an unknown method (subsumed by warn-unknown-member)");
    warnAsError = options.add("warn-as-error", 1, Boolean.FALSE, "Make all warnings into errors");
    defaultClassFileVersion = 3211264;
    moduleStatic = 0;
    typeObject = Type.objectType;
    scmBooleanType = ClassType.make("java.lang.Boolean");
    typeString = ClassType.make("java.lang.String");
    javaStringType = typeString;
    scmKeywordType = ClassType.make("gnu.expr.Keyword");
    scmSequenceType = ClassType.make("gnu.lists.Sequence");
    scmListType = ClassType.make("gnu.lists.LList");
    typePair = ClassType.make("gnu.lists.Pair");
    objArrayType = ArrayType.make(typeObject);
    typeRunnable = ClassType.make("java.lang.Runnable");
    typeType = ClassType.make("gnu.bytecode.Type");
    typeObjectType = ClassType.make("gnu.bytecode.ObjectType");
    typeClass = Type.javalangClassType;
    typeClassType = ClassType.make("gnu.bytecode.ClassType");
    typeProcedure = ClassType.make("gnu.mapping.Procedure");
    typeLanguage = ClassType.make("gnu.expr.Language");
    typeEnvironment = ClassType.make("gnu.mapping.Environment");
    typeLocation = ClassType.make("gnu.mapping.Location");
    typeSymbol = ClassType.make("gnu.mapping.Symbol");
    getSymbolValueMethod = typeLanguage.getDeclaredMethod("getSymbolValue", 1);
    getSymbolProcedureMethod = typeLanguage.getDeclaredMethod("getSymbolProcedure", 1);
    getLocationMethod = typeLocation.addMethod("get", Type.typeArray0, Type.objectType, 1);
    getProcedureBindingMethod = typeSymbol.addMethod("getProcedure", Type.typeArray0, typeProcedure, 1);
    trueConstant = scmBooleanType.getDeclaredField("TRUE");
    falseConstant = scmBooleanType.getDeclaredField("FALSE");
    setNameMethod = typeProcedure.getDeclaredMethod("setName", 1);
    Type[] arrayOfType1 = new Type[1];
    arrayOfType1[0] = Type.intType;
    int1Args = arrayOfType1;
    Type[] arrayOfType2 = new Type[1];
    arrayOfType2[0] = javaStringType;
    string1Arg = arrayOfType2;
    sym1Arg = string1Arg;
    getLocation1EnvironmentMethod = typeEnvironment.getDeclaredMethod("getLocation", 1);
    Type[] arrayOfType3 = new Type[2];
    arrayOfType3[0] = typeSymbol;
    arrayOfType3[1] = Type.objectType;
    getLocation2EnvironmentMethod = typeEnvironment.addMethod("getLocation", arrayOfType3, typeLocation, 17);
    Type[] arrayOfType4 = new Type[2];
    arrayOfType4[0] = objArrayType;
    arrayOfType4[1] = Type.intType;
    makeListMethod = scmListType.addMethod("makeList", arrayOfType4, scmListType, 9);
    getCurrentEnvironmentMethod = typeEnvironment.addMethod("getCurrent", Type.typeArray0, typeEnvironment, 9);
    apply0args = Type.typeArray0;
    Type[] arrayOfType5 = new Type[1];
    arrayOfType5[0] = typeObject;
    apply1args = arrayOfType5;
    Type[] arrayOfType6 = new Type[2];
    arrayOfType6[0] = typeObject;
    arrayOfType6[1] = typeObject;
    apply2args = arrayOfType6;
    Type[] arrayOfType7 = new Type[1];
    arrayOfType7[0] = objArrayType;
    applyNargs = arrayOfType7;
    apply0method = typeProcedure.addMethod("apply0", apply0args, typeObject, 17);
    apply1method = typeProcedure.addMethod("apply1", apply1args, typeObject, 1);
    apply2method = typeProcedure.addMethod("apply2", apply2args, typeObject, 1);
    Type[] arrayOfType8 = new Type[3];
    arrayOfType8[0] = typeObject;
    arrayOfType8[1] = typeObject;
    arrayOfType8[2] = typeObject;
    apply3method = typeProcedure.addMethod("apply3", arrayOfType8, typeObject, 1);
    Type[] arrayOfType9 = new Type[4];
    arrayOfType9[0] = typeObject;
    arrayOfType9[1] = typeObject;
    arrayOfType9[2] = typeObject;
    arrayOfType9[3] = typeObject;
    apply4method = typeProcedure.addMethod("apply4", arrayOfType9, typeObject, 1);
    applyNmethod = typeProcedure.addMethod("applyN", applyNargs, typeObject, 1);
    Type[] arrayOfType10 = new Type[2];
    arrayOfType10[0] = typeProcedure;
    arrayOfType10[1] = Type.intType;
    checkArgCountMethod = typeProcedure.addMethod("checkArgCount", arrayOfType10, Type.voidType, 9);
    Method[] arrayOfMethod = new Method[6];
    arrayOfMethod[0] = apply0method;
    arrayOfMethod[1] = apply1method;
    arrayOfMethod[2] = apply2method;
    arrayOfMethod[3] = apply3method;
    arrayOfMethod[4] = apply4method;
    arrayOfMethod[5] = applyNmethod;
    applymethods = arrayOfMethod;
    typeProcedure0 = ClassType.make("gnu.mapping.Procedure0");
    typeProcedure1 = ClassType.make("gnu.mapping.Procedure1");
    typeProcedure2 = ClassType.make("gnu.mapping.Procedure2");
    typeProcedure3 = ClassType.make("gnu.mapping.Procedure3");
    typeProcedure4 = ClassType.make("gnu.mapping.Procedure4");
    typeProcedureN = ClassType.make("gnu.mapping.ProcedureN");
    typeModuleBody = ClassType.make("gnu.expr.ModuleBody");
    typeModuleWithContext = ClassType.make("gnu.expr.ModuleWithContext");
    typeApplet = ClassType.make("java.applet.Applet");
    typeServlet = ClassType.make("gnu.kawa.servlet.KawaServlet");
    typeCallContext = ClassType.make("gnu.mapping.CallContext");
    typeConsumer = ClassType.make("gnu.lists.Consumer");
    getCallContextInstanceMethod = typeCallContext.getDeclaredMethod("getInstance", 0);
    typeValues = ClassType.make("gnu.mapping.Values");
    noArgsField = typeValues.getDeclaredField("noArgs");
    pcCallContextField = typeCallContext.getDeclaredField("pc");
    typeMethodProc = ClassType.make("gnu.mapping.MethodProc");
    typeModuleMethod = ClassType.make("gnu.expr.ModuleMethod");
    argsCallContextField = typeCallContext.getDeclaredField("values");
    procCallContextField = typeCallContext.getDeclaredField("proc");
    Type[] arrayOfType11 = new Type[1];
    arrayOfType11[0] = typeCallContext;
    applyCpsArgs = arrayOfType11;
    applyCpsMethod = typeProcedure.addMethod("apply", applyCpsArgs, Type.voidType, 1);
    ClassType[] arrayOfClassType = new ClassType[5];
    arrayOfClassType[0] = typeProcedure0;
    arrayOfClassType[1] = typeProcedure1;
    arrayOfClassType[2] = typeProcedure2;
    arrayOfClassType[3] = typeProcedure3;
    arrayOfClassType[4] = typeProcedure4;
    typeProcedureArray = arrayOfClassType;
    generateMainDefault = false;
    inlineOk = true;
    classPrefixDefault = "";
    emitSourceDebugExtAttr = true;
  }
  
  public Compilation(Language paramLanguage, SourceMessages paramSourceMessages, NameLookup paramNameLookup)
  {
    this.language = paramLanguage;
    this.messages = paramSourceMessages;
    this.lexical = paramNameLookup;
  }
  
  private void checkLoop()
  {
    if (((LambdaExp)this.current_scope).getName() != "%do%loop") {
      throw new Error("internal error - bad loop state");
    }
  }
  
  public static char demangle2(char paramChar1, char paramChar2)
  {
    int i = 37;
    switch (paramChar2 | paramChar1 << '\020')
    {
    default: 
      i = 65535;
    case 'c': 
    case 'c': 
      return i;
    case 'm': 
      return '&';
    case 't': 
      return '@';
    case 'l': 
      return ':';
    case 'm': 
      return ',';
    case 'q': 
      return '"';
    case 't': 
      return '.';
    case 'q': 
      return '=';
    case 'x': 
      return '!';
    case 'r': 
      return '>';
    case 'B': 
      return '[';
    case 'C': 
      return '{';
    case 'P': 
      return '(';
    case 's': 
      return '<';
    case 'n': 
      return '-';
    case 'm': 
      return '#';
    case 'l': 
      return '+';
    case 'u': 
      return '?';
    case 'B': 
      return ']';
    case 'C': 
      return '}';
    case 'P': 
      return ')';
    case 'C': 
      return ';';
    case 'l': 
      return '/';
    case 'q': 
      return '\\';
    case 't': 
      return '*';
    case 'l': 
      return '~';
    case 'p': 
      return '^';
    }
    return '|';
  }
  
  public static String demangleName(String paramString)
  {
    return demangleName(paramString, false);
  }
  
  public static String demangleName(String paramString, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramString.length();
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    if (n < i)
    {
      char c1 = paramString.charAt(n);
      if ((m != 0) && (!paramBoolean))
      {
        c1 = Character.toLowerCase(c1);
        m = 0;
      }
      if ((!paramBoolean) && (c1 == 'i') && (n == 0) && (i > 2) && (paramString.charAt(n + 1) == 's'))
      {
        char c4 = paramString.charAt(n + 2);
        if (!Character.isLowerCase(c4))
        {
          j = 1;
          k = 1;
          n++;
          if ((Character.isUpperCase(c4)) || (Character.isTitleCase(c4)))
          {
            localStringBuffer.append(Character.toLowerCase(c4));
            n++;
          }
        }
      }
      for (;;)
      {
        n++;
        break;
        if ((c1 == '$') && (n + 2 < i))
        {
          char c2 = paramString.charAt(n + 1);
          char c3 = paramString.charAt(n + 2);
          int i1 = demangle2(c2, c3);
          if (i1 != 65535)
          {
            localStringBuffer.append(i1);
            n += 2;
            j = 1;
            m = 1;
            continue;
          }
          if ((c2 == 'T') && (c3 == 'o') && (n + 3 < i) && (paramString.charAt(n + 3) == '$'))
          {
            localStringBuffer.append("->");
            n += 3;
            j = 1;
            m = 1;
          }
        }
        else if ((!paramBoolean) && (n > 1) && ((Character.isUpperCase(c1)) || (Character.isTitleCase(c1))) && (Character.isLowerCase(paramString.charAt(n - 1))))
        {
          localStringBuffer.append('-');
          j = 1;
          c1 = Character.toLowerCase(c1);
        }
        localStringBuffer.append(c1);
      }
    }
    if (k != 0) {
      localStringBuffer.append('?');
    }
    if (j != 0) {
      paramString = localStringBuffer.toString();
    }
    return paramString;
  }
  
  private void dumpInitializers(Initializer paramInitializer)
  {
    for (Initializer localInitializer = Initializer.reverse(paramInitializer); localInitializer != null; localInitializer = localInitializer.next) {
      localInitializer.emit(this);
    }
  }
  
  public static Compilation findForImmediateLiterals(int paramInt)
  {
    Object localObject1 = null;
    for (;;)
    {
      Compilation localCompilation;
      try
      {
        localObject3 = chainUninitialized;
        localCompilation = ((Compilation)localObject3).nextUninitialized;
        if (((Compilation)localObject3).keyUninitialized == paramInt)
        {
          if (localObject1 == null)
          {
            chainUninitialized = localCompilation;
            ((Compilation)localObject3).nextUninitialized = null;
            return localObject3;
          }
          localObject1.nextUninitialized = localCompilation;
          continue;
        }
        localObject1 = localObject3;
      }
      finally {}
      Object localObject3 = localCompilation;
    }
  }
  
  public static final Method getConstructor(ClassType paramClassType, LambdaExp paramLambdaExp)
  {
    Method localMethod = paramClassType.getDeclaredMethod("<init>", 0);
    if (localMethod != null) {
      return localMethod;
    }
    Type[] arrayOfType;
    if (((paramLambdaExp instanceof ClassExp)) && (paramLambdaExp.staticLinkField != null))
    {
      arrayOfType = new Type[1];
      arrayOfType[0] = paramLambdaExp.staticLinkField.getType();
    }
    for (;;)
    {
      return paramClassType.addMethod("<init>", 1, arrayOfType, Type.voidType);
      arrayOfType = apply0args;
    }
  }
  
  public static Compilation getCurrent()
  {
    return (Compilation)current.get();
  }
  
  public static boolean isValidJavaName(String paramString)
  {
    int i = paramString.length();
    if ((i == 0) || (!Character.isJavaIdentifierStart(paramString.charAt(0)))) {
      return false;
    }
    int j = i;
    do
    {
      j--;
      if (j <= 0) {
        break;
      }
    } while (Character.isJavaIdentifierPart(paramString.charAt(j)));
    return false;
    return true;
  }
  
  public static ApplyExp makeCoercion(Expression paramExpression1, Expression paramExpression2)
  {
    Expression[] arrayOfExpression = { paramExpression2, paramExpression1 };
    return new ApplyExp(new QuoteExp(Convert.getInstance()), arrayOfExpression);
  }
  
  public static Expression makeCoercion(Expression paramExpression, Type paramType)
  {
    return makeCoercion(paramExpression, new QuoteExp(paramType));
  }
  
  public static String mangleName(String paramString)
  {
    return mangleName(paramString, -1);
  }
  
  public static String mangleName(String paramString, int paramInt)
  {
    int i;
    int j;
    if (paramInt >= 0)
    {
      i = 1;
      j = paramString.length();
      if ((j != 6) || (!paramString.equals("*init*"))) {
        break label38;
      }
      paramString = "<init>";
    }
    label38:
    label580:
    String str1;
    label145:
    do
    {
      return paramString;
      i = 0;
      break;
      StringBuffer localStringBuffer = new StringBuffer(j);
      int k = 0;
      int m = 0;
      if (m < j)
      {
        char c1 = paramString.charAt(m);
        if (k != 0)
        {
          c1 = Character.toTitleCase(c1);
          k = 0;
        }
        if (Character.isDigit(c1))
        {
          if (m == 0) {
            localStringBuffer.append("$N");
          }
          localStringBuffer.append(c1);
        }
        for (;;)
        {
          m++;
          break;
          if ((!Character.isLetter(c1)) && (c1 != '_')) {
            break label145;
          }
          localStringBuffer.append(c1);
        }
        if (c1 == '$')
        {
          if (paramInt > 1) {}
          for (String str2 = "$$";; str2 = "$")
          {
            localStringBuffer.append(str2);
            break;
          }
        }
        switch (c1)
        {
        default: 
          localStringBuffer.append('$');
          localStringBuffer.append(Character.forDigit(0xF & c1 >> '\f', 16));
          localStringBuffer.append(Character.forDigit(0xF & c1 >> '\b', 16));
          localStringBuffer.append(Character.forDigit(0xF & c1 >> '\004', 16));
          localStringBuffer.append(Character.forDigit(c1 & 0xF, 16));
        }
        while (i == 0)
        {
          k = 1;
          break;
          localStringBuffer.append("$Pl");
          continue;
          if (i != 0)
          {
            localStringBuffer.append("$Mn");
          }
          else
          {
            if (m + 1 < j) {}
            for (char c3 = paramString.charAt(m + 1);; c3 = '\000')
            {
              if (c3 != '>') {
                break label580;
              }
              localStringBuffer.append("$To$");
              m++;
              break;
            }
            if (!Character.isLowerCase(c3))
            {
              localStringBuffer.append("$Mn");
              continue;
              localStringBuffer.append("$St");
              continue;
              localStringBuffer.append("$Sl");
              continue;
              localStringBuffer.append("$Eq");
              continue;
              localStringBuffer.append("$Ls");
              continue;
              localStringBuffer.append("$Gr");
              continue;
              localStringBuffer.append("$At");
              continue;
              localStringBuffer.append("$Tl");
              continue;
              localStringBuffer.append("$Pc");
              continue;
              localStringBuffer.append("$Dt");
              continue;
              localStringBuffer.append("$Cm");
              continue;
              localStringBuffer.append("$LP");
              continue;
              localStringBuffer.append("$RP");
              continue;
              localStringBuffer.append("$LB");
              continue;
              localStringBuffer.append("$RB");
              continue;
              localStringBuffer.append("$LC");
              continue;
              localStringBuffer.append("$RC");
              continue;
              localStringBuffer.append("$Sq");
              continue;
              localStringBuffer.append("$Dq");
              continue;
              localStringBuffer.append("$Am");
              continue;
              localStringBuffer.append("$Nm");
              continue;
              if (localStringBuffer.length() > 0) {}
              for (char c2 = localStringBuffer.charAt(0);; c2 = '\000')
              {
                if ((i != 0) || (m + 1 != j) || (!Character.isLowerCase(c2))) {
                  break label906;
                }
                localStringBuffer.setCharAt(0, Character.toTitleCase(c2));
                localStringBuffer.insert(0, "is");
                break;
              }
              localStringBuffer.append("$Qu");
              continue;
              localStringBuffer.append("$Ex");
              continue;
              localStringBuffer.append("$Cl");
              continue;
              localStringBuffer.append("$SC");
              continue;
              localStringBuffer.append("$Up");
              continue;
              localStringBuffer.append("$VB");
            }
          }
        }
      }
      str1 = localStringBuffer.toString();
    } while (str1.equals(paramString));
    label906:
    return str1;
  }
  
  public static String mangleName(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = -1) {
      return mangleName(paramString, i);
    }
  }
  
  public static String mangleNameIfNeeded(String paramString)
  {
    if ((paramString == null) || (isValidJavaName(paramString))) {
      return paramString;
    }
    return mangleName(paramString, 0);
  }
  
  public static String mangleURI(String paramString)
  {
    if (paramString.indexOf('/') >= 0) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = paramString.length();
      if ((j <= 6) || (!paramString.startsWith("class:"))) {
        break;
      }
      return paramString.substring(6);
    }
    int k;
    StringBuffer localStringBuffer;
    if ((j > 5) && (paramString.charAt(4) == ':') && (paramString.substring(0, 4).equalsIgnoreCase("http")))
    {
      paramString = paramString.substring(5);
      j -= 5;
      i = 1;
      k = 0;
      localStringBuffer = new StringBuffer();
    }
    for (;;)
    {
      int m = paramString.indexOf('/', k);
      int n;
      label113:
      int i1;
      if (m < 0)
      {
        n = j;
        if (localStringBuffer.length() != 0) {
          break label236;
        }
        i1 = 1;
        label124:
        if ((i1 == 0) || (i == 0)) {
          break label242;
        }
        String str = paramString.substring(k, n);
        if ((n - k > 4) && (str.startsWith("www."))) {
          str = str.substring(4);
        }
        putURLWords(str, localStringBuffer);
      }
      for (;;)
      {
        if (m >= 0) {
          break label348;
        }
        return localStringBuffer.toString();
        if ((j <= 4) || (paramString.charAt(3) != ':') || (!paramString.substring(0, 3).equalsIgnoreCase("uri"))) {
          break;
        }
        paramString = paramString.substring(4);
        j -= 4;
        break;
        n = m;
        break label113;
        label236:
        i1 = 0;
        break label124;
        label242:
        if (k != n)
        {
          if (i1 == 0) {
            localStringBuffer.append('.');
          }
          if (n == j)
          {
            int i2 = paramString.lastIndexOf('.', j);
            if ((i2 > k + 1) && (i1 == 0))
            {
              int i3 = j - i2;
              if ((i3 <= 4) || ((i3 == 5) && (paramString.endsWith("html"))))
              {
                j -= i3;
                n = j;
                paramString = paramString.substring(0, j);
              }
            }
          }
          localStringBuffer.append(paramString.substring(k, n));
        }
      }
      label348:
      k = m + 1;
    }
  }
  
  private static void putURLWords(String paramString, StringBuffer paramStringBuffer)
  {
    int i = paramString.indexOf('.');
    if (i > 0)
    {
      putURLWords(paramString.substring(i + 1), paramStringBuffer);
      paramStringBuffer.append('.');
      paramString = paramString.substring(0, i);
    }
    paramStringBuffer.append(paramString);
  }
  
  private void registerClass(ClassType paramClassType)
  {
    if (this.classes == null)
    {
      this.classes = new ClassType[20];
      if (!paramClassType.isInterface()) {
        break label134;
      }
    }
    label134:
    for (int i = 1;; i = 33)
    {
      paramClassType.addModifiers(i);
      if ((paramClassType == this.mainClass) && (this.numClasses > 0))
      {
        paramClassType = this.classes[0];
        this.classes[0] = this.mainClass;
      }
      ClassType[] arrayOfClassType2 = this.classes;
      int j = this.numClasses;
      this.numClasses = (j + 1);
      arrayOfClassType2[j] = paramClassType;
      return;
      if (this.numClasses < this.classes.length) {
        break;
      }
      ClassType[] arrayOfClassType1 = new ClassType[2 * this.classes.length];
      System.arraycopy(this.classes, 0, arrayOfClassType1, 0, this.numClasses);
      this.classes = arrayOfClassType1;
      break;
    }
  }
  
  public static int registerForImmediateLiterals(Compilation paramCompilation)
  {
    int i = 0;
    try
    {
      for (Compilation localCompilation = chainUninitialized; localCompilation != null; localCompilation = localCompilation.nextUninitialized) {
        if (i <= localCompilation.keyUninitialized) {
          i = 1 + localCompilation.keyUninitialized;
        }
      }
      paramCompilation.keyUninitialized = i;
      paramCompilation.nextUninitialized = chainUninitialized;
      chainUninitialized = paramCompilation;
      return i;
    }
    finally {}
  }
  
  public static void restoreCurrent(Compilation paramCompilation)
  {
    current.set(paramCompilation);
  }
  
  public static void setCurrent(Compilation paramCompilation)
  {
    current.set(paramCompilation);
  }
  
  public static Compilation setSaveCurrent(Compilation paramCompilation)
  {
    Compilation localCompilation = (Compilation)current.get();
    current.set(paramCompilation);
    return localCompilation;
  }
  
  public static void setupLiterals(int paramInt)
  {
    Compilation localCompilation = findForImmediateLiterals(paramInt);
    try
    {
      Class localClass = localCompilation.loader.loadClass(localCompilation.mainClass.getName());
      for (Literal localLiteral = localCompilation.litTable.literalsChain; localLiteral != null; localLiteral = localLiteral.next) {
        localClass.getDeclaredField(localLiteral.field.getName()).set(null, localLiteral.value);
      }
      localCompilation.litTable = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new WrappedException("internal error", localThrowable);
    }
  }
  
  private Method startClassInit()
  {
    this.method = this.curClass.addMethod("<clinit>", apply0args, Type.voidType, 9);
    CodeAttr localCodeAttr = this.method.startCode();
    if ((this.generateMain) || (generatingApplet()) || (generatingServlet()))
    {
      Method localMethod = ((ClassType)Type.make(getLanguage().getClass())).getDeclaredMethod("registerEnvironment", 0);
      if (localMethod != null) {
        localCodeAttr.emitInvokeStatic(localMethod);
      }
    }
    return this.method;
  }
  
  private void varArgsToArray(LambdaExp paramLambdaExp, int paramInt, Variable paramVariable1, Type paramType, Variable paramVariable2)
  {
    CodeAttr localCodeAttr = getCode();
    Type localType = ((ArrayType)paramType).getComponentType();
    if (!"java.lang.Object".equals(localType.getName())) {}
    for (int i = 1; (paramVariable2 != null) && (i == 0); i = 0)
    {
      localCodeAttr.emitLoad(paramVariable2);
      localCodeAttr.emitPushInt(paramInt);
      localCodeAttr.emitInvokeVirtual(typeCallContext.getDeclaredMethod("getRestArgsArray", 1));
      return;
    }
    if ((paramInt == 0) && (i == 0))
    {
      localCodeAttr.emitLoad(localCodeAttr.getArg(2));
      return;
    }
    localCodeAttr.pushScope();
    Label localLabel1;
    Label localLabel2;
    if (paramVariable1 == null)
    {
      paramVariable1 = localCodeAttr.addLocal(Type.intType);
      if (paramVariable2 != null)
      {
        localCodeAttr.emitLoad(paramVariable2);
        localCodeAttr.emitInvoke(typeCallContext.getDeclaredMethod("getArgCount", 0));
        if (paramInt != 0)
        {
          localCodeAttr.emitPushInt(paramInt);
          localCodeAttr.emitSub(Type.intType);
        }
        localCodeAttr.emitStore(paramVariable1);
      }
    }
    else
    {
      localCodeAttr.emitLoad(paramVariable1);
      localCodeAttr.emitNewArray(localType.getImplementationType());
      localLabel1 = new Label(localCodeAttr);
      localLabel2 = new Label(localCodeAttr);
      localLabel2.setTypes(localCodeAttr);
      localCodeAttr.emitGoto(localLabel1);
      localLabel2.define(localCodeAttr);
      localCodeAttr.emitDup(1);
      localCodeAttr.emitLoad(paramVariable1);
      if (paramVariable2 == null) {
        break label374;
      }
      localCodeAttr.emitLoad(paramVariable2);
      label252:
      localCodeAttr.emitLoad(paramVariable1);
      if (paramInt != 0)
      {
        localCodeAttr.emitPushInt(paramInt);
        localCodeAttr.emitAdd(Type.intType);
      }
      if (paramVariable2 == null) {
        break label388;
      }
      localCodeAttr.emitInvokeVirtual(typeCallContext.getDeclaredMethod("getArgAsObject", 1));
    }
    for (;;)
    {
      if (i != 0) {
        CheckedTarget.emitCheckedCoerce(this, paramLambdaExp, paramLambdaExp.getName(), 0, localType, null);
      }
      localCodeAttr.emitArrayStore(localType);
      localLabel1.define(localCodeAttr);
      localCodeAttr.emitInc(paramVariable1, (short)-1);
      localCodeAttr.emitLoad(paramVariable1);
      localCodeAttr.emitGotoIfIntGeZero(localLabel2);
      localCodeAttr.popScope();
      return;
      localCodeAttr.emitLoad(localCodeAttr.getArg(2));
      localCodeAttr.emitArrayLength();
      break;
      label374:
      localCodeAttr.emitLoad(localCodeAttr.getArg(2));
      break label252;
      label388:
      localCodeAttr.emitArrayLoad(Type.objectType);
    }
  }
  
  public void addClass(ClassType paramClassType)
  {
    if (this.mainLambda.filename != null)
    {
      if (emitSourceDebugExtAttr) {
        paramClassType.setStratum(getLanguage().getName());
      }
      paramClassType.setSourceFile(this.mainLambda.filename);
    }
    registerClass(paramClassType);
    paramClassType.setClassfileVersion(defaultClassFileVersion);
  }
  
  public void addMainClass(ModuleExp paramModuleExp)
  {
    this.mainClass = paramModuleExp.classFor(this);
    ClassType localClassType1 = this.mainClass;
    ClassType[] arrayOfClassType = paramModuleExp.getInterfaces();
    if (arrayOfClassType != null) {
      localClassType1.setInterfaces(arrayOfClassType);
    }
    ClassType localClassType2 = paramModuleExp.getSuperType();
    if (localClassType2 == null)
    {
      if (!generatingApplet()) {
        break label91;
      }
      localClassType2 = typeApplet;
    }
    for (;;)
    {
      if (makeRunnable()) {
        localClassType1.addInterface(typeRunnable);
      }
      localClassType1.setSuper(localClassType2);
      paramModuleExp.type = localClassType1;
      addClass(localClassType1);
      getConstructor(this.mainClass, paramModuleExp);
      return;
      label91:
      if (generatingServlet()) {
        localClassType2 = typeServlet;
      } else {
        localClassType2 = getModuleType();
      }
    }
  }
  
  public gnu.bytecode.Field allocLocalField(Type paramType, String paramString)
  {
    if (paramString == null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("tmp_");
      int i = 1 + this.localFieldIndex;
      this.localFieldIndex = i;
      paramString = i;
    }
    return this.curClass.addField(paramString, paramType, 0);
  }
  
  void callInitMethods(ClassType paramClassType, Vector<ClassType> paramVector)
  {
    if (paramClassType == null) {}
    String str;
    do
    {
      return;
      str = paramClassType.getName();
    } while ("java.lang.Object".equals(str));
    int i = paramVector.size();
    do
    {
      i--;
      if (i < 0) {
        break;
      }
    } while (((ClassType)paramVector.elementAt(i)).getName() != str);
    return;
    paramVector.addElement(paramClassType);
    ClassType[] arrayOfClassType = paramClassType.getInterfaces();
    if (arrayOfClassType != null)
    {
      int k = arrayOfClassType.length;
      for (int m = 0; m < k; m++) {
        callInitMethods(arrayOfClassType[m], paramVector);
      }
    }
    int j = 1;
    if (paramClassType.isInterface()) {
      if ((paramClassType instanceof PairClassType)) {
        paramClassType = ((PairClassType)paramClassType).instanceType;
      }
    }
    for (;;)
    {
      Method localMethod = paramClassType.getDeclaredMethod("$finit$", j);
      if (localMethod == null) {
        break;
      }
      CodeAttr localCodeAttr = getCode();
      localCodeAttr.emitPushThis();
      localCodeAttr.emitInvoke(localMethod);
      return;
      try
      {
        paramClassType = (ClassType)Type.make(Class.forName(paramClassType.getName() + "$class"));
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      j = 0;
    }
  }
  
  public void cleanupAfterCompilation()
  {
    for (int i = 0; i < this.numClasses; i++) {
      this.classes[i].cleanupAfterCompilation();
    }
    this.classes = null;
    this.minfo.comp = null;
    if (this.minfo.exp != null) {
      this.minfo.exp.body = null;
    }
    this.mainLambda.body = null;
    this.mainLambda = null;
    if (!this.immediate) {
      this.litTable = null;
    }
  }
  
  public void compileConstant(Object paramObject)
  {
    CodeAttr localCodeAttr = getCode();
    if (paramObject == null)
    {
      localCodeAttr.emitPushNull();
      return;
    }
    if (((paramObject instanceof String)) && (!this.immediate))
    {
      localCodeAttr.emitPushString((String)paramObject);
      return;
    }
    localCodeAttr.emitGetStatic(compileConstantToField(paramObject));
  }
  
  public void compileConstant(Object paramObject, Target paramTarget)
  {
    if ((paramTarget instanceof IgnoreTarget)) {}
    for (;;)
    {
      return;
      if (!(paramObject instanceof Values)) {
        break;
      }
      Object[] arrayOfObject = ((Values)paramObject).getValues();
      int k = arrayOfObject.length;
      if (!(paramTarget instanceof ConsumerTarget)) {
        break;
      }
      for (int m = 0; m < k; m++) {
        compileConstant(arrayOfObject[m], paramTarget);
      }
    }
    if ((paramTarget instanceof ConditionalTarget))
    {
      ConditionalTarget localConditionalTarget = (ConditionalTarget)paramTarget;
      CodeAttr localCodeAttr2 = getCode();
      if (getLanguage().isTrue(paramObject)) {}
      for (Label localLabel = localConditionalTarget.ifTrue;; localLabel = localConditionalTarget.ifFalse)
      {
        localCodeAttr2.emitGoto(localLabel);
        return;
      }
    }
    Type localType2;
    if ((paramTarget instanceof StackTarget))
    {
      localType2 = ((StackTarget)paramTarget).getType();
      if (!(localType2 instanceof PrimType)) {}
    }
    for (;;)
    {
      String str;
      CodeAttr localCodeAttr1;
      Number localNumber;
      try
      {
        str = localType2.getSignature();
        localCodeAttr1 = getCode();
        if (str == null) {
          break label549;
        }
        if (str.length() == 1) {
          break label292;
        }
      }
      catch (ClassCastException localClassCastException) {}
      if ((paramObject instanceof Number)) {
        localNumber = (Number)paramObject;
      }
      switch (i)
      {
      default: 
        if (i == 67)
        {
          localCodeAttr1.emitPushInt(((PrimType)localType2).charValue(paramObject));
          return;
        }
        break;
      }
      for (;;)
      {
        if ((localType2 == typeClass) && ((paramObject instanceof ClassType)))
        {
          loadClassRef((ClassType)paramObject);
          return;
          label292:
          i = str.charAt(0);
          break;
          localCodeAttr1.emitPushInt(localNumber.intValue());
          return;
          localCodeAttr1.emitPushInt(localNumber.shortValue());
          return;
          localCodeAttr1.emitPushInt(localNumber.byteValue());
          return;
          localCodeAttr1.emitPushLong(localNumber.longValue());
          return;
          localCodeAttr1.emitPushFloat(localNumber.floatValue());
          return;
          localCodeAttr1.emitPushDouble(localNumber.doubleValue());
          return;
          if (i == 90)
          {
            if (PrimType.booleanValue(paramObject)) {}
            for (int j = 1;; j = 0)
            {
              localCodeAttr1.emitPushInt(j);
              return;
            }
          }
        }
      }
      try
      {
        Object localObject = localType2.coerceFromObject(paramObject);
        paramObject = localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Type localType1;
          StringBuffer localStringBuffer = new StringBuffer();
          Values localValues = Values.empty;
          if (paramObject == localValues)
          {
            localStringBuffer.append("cannot convert void to ");
            localStringBuffer.append(localType2.getName());
            error('w', localStringBuffer.toString());
          }
          else
          {
            localStringBuffer.append("cannot convert literal (of type ");
            if (paramObject == null) {
              localStringBuffer.append("<null>");
            }
            for (;;)
            {
              localStringBuffer.append(") to ");
              break;
              localStringBuffer.append(paramObject.getClass().getName());
            }
            localType1 = Type.make(paramObject.getClass());
          }
        }
      }
      compileConstant(paramObject);
      if (paramObject == null)
      {
        localType1 = paramTarget.getType();
        paramTarget.compileFromStack(this, localType1);
        return;
      }
      label549:
      int i = 32;
    }
  }
  
  public gnu.bytecode.Field compileConstantToField(Object paramObject)
  {
    Literal localLiteral = this.litTable.findLiteral(paramObject);
    if (localLiteral.field == null) {
      localLiteral.assign(this.litTable);
    }
    return localLiteral.field;
  }
  
  public void compileToArchive(ModuleExp paramModuleExp, String paramString)
    throws IOException
  {
    int i;
    File localFile;
    if (paramString.endsWith(".zip"))
    {
      i = 0;
      process(12);
      localFile = new File(paramString);
      if (localFile.exists()) {
        localFile.delete();
      }
      if (i == 0) {
        break label261;
      }
    }
    label261:
    for (Object localObject = new JarOutputStream(new FileOutputStream(localFile));; localObject = new ZipOutputStream(new FileOutputStream(localFile)))
    {
      byte[][] arrayOfByte = new byte[this.numClasses][];
      CRC32 localCRC32 = new CRC32();
      for (int j = 0; j < this.numClasses; j++)
      {
        ClassType localClassType = this.classes[j];
        arrayOfByte[j] = localClassType.writeToArray();
        ZipEntry localZipEntry = new ZipEntry(localClassType.getName().replace('.', '/') + ".class");
        localZipEntry.setSize(arrayOfByte[j].length);
        localCRC32.reset();
        localCRC32.update(arrayOfByte[j], 0, arrayOfByte[j].length);
        localZipEntry.setCrc(localCRC32.getValue());
        ((ZipOutputStream)localObject).putNextEntry(localZipEntry);
        ((ZipOutputStream)localObject).write(arrayOfByte[j]);
      }
      if (paramString.endsWith(".jar"))
      {
        i = 1;
        break;
      }
      paramString = paramString + ".zip";
      i = 0;
      break;
    }
    ((ZipOutputStream)localObject).close();
  }
  
  public LambdaExp currentLambda()
  {
    return this.current_scope.currentLambda();
  }
  
  public ModuleExp currentModule()
  {
    return this.current_scope.currentModule();
  }
  
  public ScopeExp currentScope()
  {
    return this.current_scope;
  }
  
  public void error(char paramChar, Declaration paramDeclaration, String paramString1, String paramString2)
  {
    error(paramChar, paramString1 + paramDeclaration.getName() + paramString2, null, paramDeclaration);
  }
  
  public void error(char paramChar, String paramString)
  {
    if ((paramChar == 'w') && (warnAsError())) {
      paramChar = 'e';
    }
    this.messages.error(paramChar, this, paramString);
  }
  
  public void error(char paramChar, String paramString, SourceLocator paramSourceLocator)
  {
    String str = paramSourceLocator.getFileName();
    int i = paramSourceLocator.getLineNumber();
    int j = paramSourceLocator.getColumnNumber();
    if ((str == null) || (i <= 0))
    {
      str = getFileName();
      i = getLineNumber();
      j = getColumnNumber();
    }
    if ((paramChar == 'w') && (warnAsError())) {
      paramChar = 'e';
    }
    this.messages.error(paramChar, str, i, j, paramString);
  }
  
  public void error(char paramChar, String paramString1, String paramString2, Declaration paramDeclaration)
  {
    if ((paramChar == 'w') && (warnAsError())) {
      paramChar = 'e';
    }
    String str = getFileName();
    int i = getLineNumber();
    int j = getColumnNumber();
    int k = paramDeclaration.getLineNumber();
    if (k > 0)
    {
      str = paramDeclaration.getFileName();
      i = k;
      j = paramDeclaration.getColumnNumber();
    }
    this.messages.error(paramChar, str, i, j, paramString1, paramString2);
  }
  
  public ClassType findNamedClass(String paramString)
  {
    for (int i = 0; i < this.numClasses; i++) {
      if (paramString.equals(this.classes[i].getName())) {
        return this.classes[i];
      }
    }
    return null;
  }
  
  public void freeLocalField(gnu.bytecode.Field paramField) {}
  
  public void generateApplyMethodsWithContext(LambdaExp paramLambdaExp)
  {
    if (paramLambdaExp.applyMethods == null) {}
    for (int i = 0; i == 0; i = paramLambdaExp.applyMethods.size()) {
      return;
    }
    ClassType localClassType = this.curClass;
    this.curClass = paramLambdaExp.getHeapFrameType();
    if (!this.curClass.getSuperclass().isSubtype(typeModuleWithContext)) {
      this.curClass = this.moduleClass;
    }
    Method localMethod1 = this.method;
    Type[] arrayOfType1 = new Type[1];
    arrayOfType1[0] = typeCallContext;
    this.method = this.curClass.addMethod("apply", arrayOfType1, Type.voidType, 1);
    CodeAttr localCodeAttr = this.method.startCode();
    Variable localVariable1 = localCodeAttr.getArg(1);
    localCodeAttr.emitLoad(localVariable1);
    localCodeAttr.emitGetField(pcCallContextField);
    SwitchState localSwitchState = localCodeAttr.startSwitch();
    for (int j = 0; j < i; j++)
    {
      LambdaExp localLambdaExp = (LambdaExp)paramLambdaExp.applyMethods.elementAt(j);
      Method[] arrayOfMethod = localLambdaExp.primMethods;
      int k = arrayOfMethod.length;
      for (int m = 0; m < k; m++)
      {
        int n;
        SourceLocator localSourceLocator1;
        Method localMethod2;
        Type[] arrayOfType2;
        int i3;
        int i4;
        Variable localVariable2;
        int i5;
        label402:
        int i6;
        label410:
        int i7;
        label424:
        Declaration localDeclaration;
        int i8;
        if ((m == k - 1) && ((localLambdaExp.max_args < 0) || (localLambdaExp.max_args >= k + localLambdaExp.min_args)))
        {
          n = 1;
          int i1 = m;
          localSwitchState.addCase(m + localLambdaExp.getSelectorValue(this), localCodeAttr);
          localSourceLocator1 = this.messages.swapSourceLocator(localLambdaExp);
          int i2 = localLambdaExp.getLineNumber();
          if (i2 > 0) {
            localCodeAttr.putLineNumber(localLambdaExp.getFileName(), i2);
          }
          localMethod2 = arrayOfMethod[i1];
          arrayOfType2 = localMethod2.getParameterTypes();
          i3 = i1 + localLambdaExp.min_args;
          i4 = 0;
          localVariable2 = null;
          if (m > 4)
          {
            localVariable2 = null;
            if (k > 1)
            {
              localVariable2 = localCodeAttr.addLocal(Type.intType);
              localCodeAttr.emitLoad(localVariable1);
              localCodeAttr.emitInvoke(typeCallContext.getDeclaredMethod("getArgCount", 0));
              if (localLambdaExp.min_args != 0)
              {
                localCodeAttr.emitPushInt(localLambdaExp.min_args);
                localCodeAttr.emitSub(Type.intType);
              }
              localCodeAttr.emitStore(localVariable2);
            }
          }
          if (!localMethod2.getStaticFlag()) {
            break label703;
          }
          i5 = 0;
          if (n == 0) {
            break label709;
          }
          i6 = 2;
          if (i6 + i3 >= arrayOfType2.length) {
            break label715;
          }
          i7 = 1;
          if (i5 + i7 > 0)
          {
            localCodeAttr.emitPushThis();
            if ((this.curClass == this.moduleClass) && (this.mainClass != this.moduleClass)) {
              localCodeAttr.emitGetField(this.moduleInstanceMainField);
            }
          }
          localDeclaration = localLambdaExp.firstDecl();
          if ((localDeclaration != null) && (localDeclaration.isThisParameter())) {
            localDeclaration = localDeclaration.nextDecl();
          }
          i8 = 0;
          label498:
          if (i8 >= i3) {
            break label753;
          }
          if (localVariable2 != null)
          {
            int i9 = localLambdaExp.min_args;
            if (i8 >= i9)
            {
              localCodeAttr.emitLoad(localVariable2);
              localCodeAttr.emitIfIntLEqZero();
              localCodeAttr.emitLoad(localVariable1);
              localCodeAttr.emitInvoke(arrayOfMethod[(i8 - localLambdaExp.min_args)]);
              localCodeAttr.emitElse();
              i4++;
              localCodeAttr.emitInc(localVariable2, (short)-1);
            }
          }
          localCodeAttr.emitLoad(localVariable1);
          if ((i8 > 4) || (n != 0) || (localLambdaExp.max_args > 4)) {
            break label721;
          }
          localCodeAttr.emitGetField(typeCallContext.getDeclaredField("value" + (i8 + 1)));
        }
        for (;;)
        {
          Type localType2 = localDeclaration.getType();
          if (localType2 != Type.objectType)
          {
            SourceLocator localSourceLocator2 = this.messages.swapSourceLocator(localDeclaration);
            CheckedTarget.emitCheckedCoerce(this, localLambdaExp, i8 + 1, localType2);
            this.messages.swapSourceLocator(localSourceLocator2);
          }
          localDeclaration = localDeclaration.nextDecl();
          i8++;
          break label498;
          n = 0;
          break;
          label703:
          i5 = 1;
          break label402;
          label709:
          i6 = 1;
          break label410;
          label715:
          i7 = 0;
          break label424;
          label721:
          localCodeAttr.emitGetField(typeCallContext.getDeclaredField("values"));
          localCodeAttr.emitPushInt(i8);
          localCodeAttr.emitArrayLoad(Type.objectType);
        }
        label753:
        Type localType1;
        if (n != 0)
        {
          localType1 = arrayOfType2[(i7 + i3)];
          if (!(localType1 instanceof ArrayType)) {
            break label820;
          }
          varArgsToArray(localLambdaExp, i3, localVariable2, localType1, localVariable1);
        }
        for (;;)
        {
          localCodeAttr.emitLoad(localVariable1);
          localCodeAttr.emitInvoke(localMethod2);
          for (;;)
          {
            i4--;
            if (i4 < 0) {
              break;
            }
            localCodeAttr.emitFi();
          }
          label820:
          if ("gnu.lists.LList".equals(localType1.getName()))
          {
            localCodeAttr.emitLoad(localVariable1);
            localCodeAttr.emitPushInt(i3);
            localCodeAttr.emitInvokeVirtual(typeCallContext.getDeclaredMethod("getRestArgsList", 1));
          }
          else
          {
            if (localType1 != typeCallContext) {
              break;
            }
            localCodeAttr.emitLoad(localVariable1);
          }
        }
        throw new RuntimeException("unsupported #!rest type:" + localType1);
        if (defaultCallConvention < 2) {
          Target.pushObject.compileFromStack(this, localLambdaExp.getReturnType());
        }
        this.messages.swapSourceLocator(localSourceLocator1);
        localCodeAttr.emitReturn();
      }
    }
    localSwitchState.addDefault(localCodeAttr);
    localCodeAttr.emitInvokeStatic(typeModuleMethod.getDeclaredMethod("applyError", 0));
    localCodeAttr.emitReturn();
    localSwitchState.finish(localCodeAttr);
    this.method = localMethod1;
    this.curClass = localClassType;
  }
  
  public void generateApplyMethodsWithoutContext(LambdaExp paramLambdaExp)
  {
    if (paramLambdaExp.applyMethods == null) {}
    for (int i = 0; i == 0; i = paramLambdaExp.applyMethods.size()) {
      return;
    }
    ClassType localClassType1 = this.curClass;
    this.curClass = paramLambdaExp.getHeapFrameType();
    ClassType localClassType2 = typeModuleMethod;
    if (!this.curClass.getSuperclass().isSubtype(typeModuleBody)) {
      this.curClass = this.moduleClass;
    }
    Method localMethod1 = this.method;
    CodeAttr localCodeAttr = null;
    int j;
    int k;
    SwitchState localSwitchState;
    String str;
    Type[] arrayOfType1;
    int m;
    label108:
    LambdaExp localLambdaExp;
    Method[] arrayOfMethod;
    int i3;
    int i4;
    label167:
    int i7;
    int i6;
    if (defaultCallConvention >= 2)
    {
      j = 5;
      if (j >= 6) {
        break label1267;
      }
      k = 0;
      localSwitchState = null;
      str = null;
      arrayOfType1 = null;
      m = 0;
      if (m >= i) {
        break label1145;
      }
      localLambdaExp = (LambdaExp)paramLambdaExp.applyMethods.elementAt(m);
      arrayOfMethod = localLambdaExp.primMethods;
      i3 = arrayOfMethod.length;
      if ((localLambdaExp.max_args >= 0) && (localLambdaExp.max_args < i3 + localLambdaExp.min_args)) {
        break label252;
      }
      i4 = 1;
      if (j >= 5) {
        break label258;
      }
      i7 = j - localLambdaExp.min_args;
      if ((i7 >= 0) && (i7 < i3))
      {
        int i19 = i3 - 1;
        int i20 = i7;
        i6 = 0;
        if (i20 == i19)
        {
          i6 = 0;
          if (i4 == 0) {}
        }
      }
      else
      {
        i6 = 1;
      }
      i3 = 1;
      i4 = 0;
      label232:
      if (i6 == 0) {
        break label309;
      }
    }
    for (;;)
    {
      m++;
      break label108;
      localCodeAttr = null;
      j = 0;
      break;
      label252:
      i4 = 0;
      break label167;
      label258:
      int i5 = 5 - localLambdaExp.min_args;
      i6 = 0;
      if (i5 > 0)
      {
        int i18 = i3;
        i6 = 0;
        if (i18 <= i5)
        {
          i6 = 0;
          if (i4 == 0) {
            i6 = 1;
          }
        }
      }
      i7 = i3 - 1;
      break label232;
      label309:
      Object localObject;
      SourceLocator localSourceLocator1;
      Method localMethod2;
      Type[] arrayOfType2;
      int i9;
      int i10;
      Variable localVariable1;
      int i11;
      label644:
      int i12;
      label652:
      int i13;
      label666:
      Declaration localDeclaration;
      int i14;
      label740:
      Variable localVariable2;
      if (k == 0)
      {
        if (j < 5)
        {
          str = "apply" + j;
          arrayOfType1 = new Type[j + 1];
          for (int i17 = j; i17 > 0; i17--) {
            arrayOfType1[i17] = typeObject;
          }
        }
        str = "applyN";
        arrayOfType1 = new Type[2];
        arrayOfType1[1] = objArrayType;
        arrayOfType1[0] = localClassType2;
        ClassType localClassType3 = this.curClass;
        if (defaultCallConvention >= 2)
        {
          localObject = Type.voidType;
          this.method = localClassType3.addMethod(str, arrayOfType1, (Type)localObject, 1);
          localCodeAttr = this.method.startCode();
          localCodeAttr.emitLoad(localCodeAttr.getArg(1));
          localCodeAttr.emitGetField(localClassType2.getField("selector"));
          localSwitchState = localCodeAttr.startSwitch();
          k = 1;
        }
      }
      else
      {
        localSwitchState.addCase(localLambdaExp.getSelectorValue(this), localCodeAttr);
        localSourceLocator1 = this.messages.swapSourceLocator(localLambdaExp);
        int i8 = localLambdaExp.getLineNumber();
        if (i8 > 0) {
          localCodeAttr.putLineNumber(localLambdaExp.getFileName(), i8);
        }
        localMethod2 = arrayOfMethod[i7];
        arrayOfType2 = localMethod2.getParameterTypes();
        i9 = i7 + localLambdaExp.min_args;
        i10 = 0;
        localVariable1 = null;
        if (j > 4)
        {
          int i16 = i3;
          localVariable1 = null;
          if (i16 > 1)
          {
            localVariable1 = localCodeAttr.addLocal(Type.intType);
            localCodeAttr.emitLoad(localCodeAttr.getArg(2));
            localCodeAttr.emitArrayLength();
            if (localLambdaExp.min_args != 0)
            {
              localCodeAttr.emitPushInt(localLambdaExp.min_args);
              localCodeAttr.emitSub(Type.intType);
            }
            localCodeAttr.emitStore(localVariable1);
          }
        }
        if (!localMethod2.getStaticFlag()) {
          break label905;
        }
        i11 = 0;
        if (i4 == 0) {
          break label911;
        }
        i12 = 1;
        if (i12 + i9 >= arrayOfType2.length) {
          break label917;
        }
        i13 = 1;
        if (i11 + i13 > 0)
        {
          localCodeAttr.emitPushThis();
          if ((this.curClass == this.moduleClass) && (this.mainClass != this.moduleClass)) {
            localCodeAttr.emitGetField(this.moduleInstanceMainField);
          }
        }
        localDeclaration = localLambdaExp.firstDecl();
        if ((localDeclaration != null) && (localDeclaration.isThisParameter())) {
          localDeclaration = localDeclaration.nextDecl();
        }
        i14 = 0;
        if (i14 >= i9) {
          break label955;
        }
        if (localVariable1 != null)
        {
          int i15 = localLambdaExp.min_args;
          if (i14 >= i15)
          {
            localCodeAttr.emitLoad(localVariable1);
            localCodeAttr.emitIfIntLEqZero();
            localCodeAttr.emitInvoke(arrayOfMethod[(i14 - localLambdaExp.min_args)]);
            localCodeAttr.emitElse();
            i10++;
            localCodeAttr.emitInc(localVariable1, (short)-1);
          }
        }
        if (j > 4) {
          break label923;
        }
        localVariable2 = localCodeAttr.getArg(i14 + 2);
        localCodeAttr.emitLoad(localVariable2);
      }
      for (;;)
      {
        Type localType2 = localDeclaration.getType();
        if (localType2 != Type.objectType)
        {
          SourceLocator localSourceLocator2 = this.messages.swapSourceLocator(localDeclaration);
          CheckedTarget.emitCheckedCoerce(this, localLambdaExp, i14 + 1, localType2, localVariable2);
          this.messages.swapSourceLocator(localSourceLocator2);
        }
        localDeclaration = localDeclaration.nextDecl();
        i14++;
        break label740;
        localObject = Type.objectType;
        break;
        label905:
        i11 = 1;
        break label644;
        label911:
        i12 = 0;
        break label652;
        label917:
        i13 = 0;
        break label666;
        label923:
        localCodeAttr.emitLoad(localCodeAttr.getArg(2));
        localCodeAttr.emitPushInt(i14);
        localCodeAttr.emitArrayLoad(Type.objectType);
        localVariable2 = null;
      }
      label955:
      Type localType1;
      if (i4 != 0)
      {
        localType1 = arrayOfType2[(i13 + i9)];
        if (!(localType1 instanceof ArrayType)) {
          break label1014;
        }
        varArgsToArray(localLambdaExp, i9, localVariable1, localType1, null);
      }
      for (;;)
      {
        localCodeAttr.emitInvoke(localMethod2);
        for (;;)
        {
          i10--;
          if (i10 < 0) {
            break;
          }
          localCodeAttr.emitFi();
        }
        label1014:
        if ("gnu.lists.LList".equals(localType1.getName()))
        {
          localCodeAttr.emitLoad(localCodeAttr.getArg(2));
          localCodeAttr.emitPushInt(i9);
          localCodeAttr.emitInvokeStatic(makeListMethod);
        }
        else
        {
          if (localType1 != typeCallContext) {
            break;
          }
          localCodeAttr.emitLoad(localCodeAttr.getArg(2));
        }
      }
      throw new RuntimeException("unsupported #!rest type:" + localType1);
      if (defaultCallConvention < 2) {
        Target.pushObject.compileFromStack(this, localLambdaExp.getReturnType());
      }
      this.messages.swapSourceLocator(localSourceLocator1);
      localCodeAttr.emitReturn();
    }
    label1145:
    if (k != 0)
    {
      localSwitchState.addDefault(localCodeAttr);
      if (defaultCallConvention < 2) {
        break label1197;
      }
      localCodeAttr.emitInvokeStatic(typeModuleMethod.getDeclaredMethod("applyError", 0));
    }
    for (;;)
    {
      localCodeAttr.emitReturn();
      localSwitchState.finish(localCodeAttr);
      j++;
      break;
      label1197:
      if (j > 4) {}
      for (int n = 2;; n = j + 1)
      {
        int i1 = n + 1;
        for (int i2 = 0; i2 < i1; i2++) {
          localCodeAttr.emitLoad(localCodeAttr.getArg(i2));
        }
      }
      localCodeAttr.emitInvokeSpecial(typeModuleBody.getDeclaredMethod(str, arrayOfType1));
    }
    label1267:
    this.method = localMethod1;
    this.curClass = localClassType1;
  }
  
  /* Error */
  void generateBytecode()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1611	gnu/expr/Compilation:getModule	()Lgnu/expr/ModuleExp;
    //   4: astore_1
    //   5: getstatic 1613	gnu/expr/Compilation:debugPrintFinalExpr	Z
    //   8: ifeq +76 -> 84
    //   11: invokestatic 1619	gnu/mapping/OutPort:errDefault	()Lgnu/mapping/OutPort;
    //   14: astore 61
    //   16: aload 61
    //   18: new 1139	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 1140	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 1621
    //   28: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 1622	gnu/expr/ModuleExp:getName	()Ljava/lang/String;
    //   35: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 1624
    //   41: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield 872	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   48: invokevirtual 897	gnu/bytecode/ClassType:getName	()Ljava/lang/String;
    //   51: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc_w 1626
    //   57: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 1151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokevirtual 1629	gnu/mapping/OutPort:println	(Ljava/lang/String;)V
    //   66: aload_1
    //   67: aload 61
    //   69: invokevirtual 1633	gnu/expr/ModuleExp:print	(Lgnu/mapping/OutPort;)V
    //   72: aload 61
    //   74: bipush 93
    //   76: invokevirtual 1636	gnu/mapping/OutPort:println	(C)V
    //   79: aload 61
    //   81: invokevirtual 1639	gnu/mapping/OutPort:flush	()V
    //   84: aload_0
    //   85: invokevirtual 1135	gnu/expr/Compilation:getModuleType	()Lgnu/bytecode/ClassType;
    //   88: astore_2
    //   89: aload_0
    //   90: getfield 872	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   93: invokevirtual 1484	gnu/bytecode/ClassType:getSuperclass	()Lgnu/bytecode/ClassType;
    //   96: aload_2
    //   97: invokevirtual 1488	gnu/bytecode/ClassType:isSubtype	(Lgnu/bytecode/Type;)Z
    //   100: ifeq +466 -> 566
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 872	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   108: putfield 1490	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   111: aload_0
    //   112: aload_1
    //   113: getfield 1128	gnu/expr/ModuleExp:type	Lgnu/bytecode/ClassType;
    //   116: putfield 944	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   119: aload_0
    //   120: getfield 1641	gnu/expr/Compilation:curLambda	Lgnu/expr/LambdaExp;
    //   123: astore_3
    //   124: aload_0
    //   125: aload_1
    //   126: putfield 1641	gnu/expr/Compilation:curLambda	Lgnu/expr/LambdaExp;
    //   129: aload_1
    //   130: invokevirtual 1644	gnu/expr/ModuleExp:isHandlingTailCalls	()Z
    //   133: ifeq +479 -> 612
    //   136: iconst_1
    //   137: anewarray 248	gnu/bytecode/Type
    //   140: astore 4
    //   142: aload 4
    //   144: iconst_0
    //   145: getstatic 485	gnu/expr/Compilation:typeCallContext	Lgnu/bytecode/ClassType;
    //   148: aastore
    //   149: aload_1
    //   150: getfield 1647	gnu/expr/ModuleExp:heapFrame	Lgnu/bytecode/Variable;
    //   153: astore 5
    //   155: aload_1
    //   156: invokevirtual 1650	gnu/expr/ModuleExp:isStatic	()Z
    //   159: istore 6
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 944	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   166: ldc_w 1652
    //   169: aload 4
    //   171: getstatic 435	gnu/bytecode/Type:voidType	Lgnu/bytecode/PrimType;
    //   174: bipush 17
    //   176: invokevirtual 354	gnu/bytecode/ClassType:addMethod	(Ljava/lang/String;[Lgnu/bytecode/Type;Lgnu/bytecode/Type;I)Lgnu/bytecode/Method;
    //   179: putfield 947	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   182: aload_0
    //   183: getfield 947	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   186: invokevirtual 1655	gnu/bytecode/Method:initCode	()V
    //   189: aload_0
    //   190: invokevirtual 981	gnu/expr/Compilation:getCode	()Lgnu/bytecode/CodeAttr;
    //   193: astore 7
    //   195: aload_0
    //   196: getfield 947	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   199: invokevirtual 1532	gnu/bytecode/Method:getStaticFlag	()Z
    //   202: ifeq +488 -> 690
    //   205: aconst_null
    //   206: astore 8
    //   208: aload_0
    //   209: aload 8
    //   211: putfield 1657	gnu/expr/Compilation:thisDecl	Lgnu/bytecode/Variable;
    //   214: aload_1
    //   215: aload_1
    //   216: getfield 1660	gnu/expr/ModuleExp:thisVariable	Lgnu/bytecode/Variable;
    //   219: putfield 1663	gnu/expr/ModuleExp:closureEnv	Lgnu/bytecode/Variable;
    //   222: aload_1
    //   223: invokevirtual 1650	gnu/expr/ModuleExp:isStatic	()Z
    //   226: ifeq +477 -> 703
    //   229: aconst_null
    //   230: astore 9
    //   232: aload_1
    //   233: aload 9
    //   235: putfield 1647	gnu/expr/ModuleExp:heapFrame	Lgnu/bytecode/Variable;
    //   238: aload_1
    //   239: aload_0
    //   240: invokevirtual 1666	gnu/expr/ModuleExp:allocChildClasses	(Lgnu/expr/Compilation;)V
    //   243: aload_1
    //   244: invokevirtual 1644	gnu/expr/ModuleExp:isHandlingTailCalls	()Z
    //   247: ifne +10 -> 257
    //   250: aload_0
    //   251: invokevirtual 1669	gnu/expr/Compilation:usingCPStyle	()Z
    //   254: ifeq +43 -> 297
    //   257: aload_0
    //   258: new 1671	gnu/bytecode/Variable
    //   261: dup
    //   262: ldc_w 1673
    //   265: getstatic 485	gnu/expr/Compilation:typeCallContext	Lgnu/bytecode/ClassType;
    //   268: invokespecial 1676	gnu/bytecode/Variable:<init>	(Ljava/lang/String;Lgnu/bytecode/Type;)V
    //   271: putfield 1678	gnu/expr/Compilation:callContextVar	Lgnu/bytecode/Variable;
    //   274: aload_1
    //   275: invokevirtual 1681	gnu/expr/ModuleExp:getVarScope	()Lgnu/bytecode/Scope;
    //   278: aload_0
    //   279: getfield 1657	gnu/expr/Compilation:thisDecl	Lgnu/bytecode/Variable;
    //   282: aload_0
    //   283: getfield 1678	gnu/expr/Compilation:callContextVar	Lgnu/bytecode/Variable;
    //   286: invokevirtual 1687	gnu/bytecode/Scope:addVariableAfter	(Lgnu/bytecode/Variable;Lgnu/bytecode/Variable;)V
    //   289: aload_0
    //   290: getfield 1678	gnu/expr/Compilation:callContextVar	Lgnu/bytecode/Variable;
    //   293: iconst_1
    //   294: invokevirtual 1691	gnu/bytecode/Variable:setParameter	(Z)V
    //   297: aload_1
    //   298: invokevirtual 1692	gnu/expr/ModuleExp:getLineNumber	()I
    //   301: istore 10
    //   303: iload 10
    //   305: ifle +14 -> 319
    //   308: aload 7
    //   310: aload_1
    //   311: invokevirtual 1693	gnu/expr/ModuleExp:getFileName	()Ljava/lang/String;
    //   314: iload 10
    //   316: invokevirtual 1525	gnu/bytecode/CodeAttr:putLineNumber	(Ljava/lang/String;I)V
    //   319: aload_1
    //   320: aload_0
    //   321: invokevirtual 1696	gnu/expr/ModuleExp:allocParameters	(Lgnu/expr/Compilation;)V
    //   324: aload_1
    //   325: aload_0
    //   326: invokevirtual 1699	gnu/expr/ModuleExp:enterFunction	(Lgnu/expr/Compilation;)V
    //   329: aload_0
    //   330: invokevirtual 1669	gnu/expr/Compilation:usingCPStyle	()Z
    //   333: ifeq +35 -> 368
    //   336: aload_0
    //   337: invokevirtual 1702	gnu/expr/Compilation:loadCallContext	()V
    //   340: aload 7
    //   342: getstatic 505	gnu/expr/Compilation:pcCallContextField	Lgnu/bytecode/Field;
    //   345: invokevirtual 1493	gnu/bytecode/CodeAttr:emitGetField	(Lgnu/bytecode/Field;)V
    //   348: aload_0
    //   349: aload 7
    //   351: invokevirtual 1497	gnu/bytecode/CodeAttr:startSwitch	()Lgnu/bytecode/SwitchState;
    //   354: putfield 1704	gnu/expr/Compilation:fswitch	Lgnu/bytecode/SwitchState;
    //   357: aload_0
    //   358: getfield 1704	gnu/expr/Compilation:fswitch	Lgnu/bytecode/SwitchState;
    //   361: iconst_0
    //   362: aload 7
    //   364: invokevirtual 1515	gnu/bytecode/SwitchState:addCase	(ILgnu/bytecode/CodeAttr;)Z
    //   367: pop
    //   368: aload_1
    //   369: aload_0
    //   370: invokevirtual 1707	gnu/expr/ModuleExp:compileBody	(Lgnu/expr/Compilation;)V
    //   373: aload_1
    //   374: aload_0
    //   375: invokevirtual 1710	gnu/expr/ModuleExp:compileEnd	(Lgnu/expr/Compilation;)V
    //   378: aload_0
    //   379: getfield 944	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   382: astore 11
    //   384: aload_0
    //   385: getfield 872	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   388: astore 12
    //   390: aconst_null
    //   391: astore 13
    //   393: aconst_null
    //   394: astore 14
    //   396: aconst_null
    //   397: astore 15
    //   399: aload 11
    //   401: aload 12
    //   403: if_acmpne +628 -> 1031
    //   406: aload_0
    //   407: getfield 947	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   410: astore 49
    //   412: aload_0
    //   413: getfield 1678	gnu/expr/Compilation:callContextVar	Lgnu/bytecode/Variable;
    //   416: astore 50
    //   418: aload_0
    //   419: aconst_null
    //   420: putfield 1678	gnu/expr/Compilation:callContextVar	Lgnu/bytecode/Variable;
    //   423: aload_0
    //   424: invokespecial 1712	gnu/expr/Compilation:startClassInit	()Lgnu/bytecode/Method;
    //   427: astore 14
    //   429: aload_0
    //   430: aload 14
    //   432: putfield 1714	gnu/expr/Compilation:clinitMethod	Lgnu/bytecode/Method;
    //   435: aload_0
    //   436: invokevirtual 981	gnu/expr/Compilation:getCode	()Lgnu/bytecode/CodeAttr;
    //   439: astore 51
    //   441: new 1032	gnu/bytecode/Label
    //   444: dup
    //   445: aload 51
    //   447: invokespecial 1035	gnu/bytecode/Label:<init>	(Lgnu/bytecode/CodeAttr;)V
    //   450: astore 15
    //   452: new 1032	gnu/bytecode/Label
    //   455: dup
    //   456: aload 51
    //   458: invokespecial 1035	gnu/bytecode/Label:<init>	(Lgnu/bytecode/CodeAttr;)V
    //   461: astore 13
    //   463: aload 51
    //   465: aload 13
    //   467: aload 15
    //   469: invokevirtual 1718	gnu/bytecode/CodeAttr:fixupChain	(Lgnu/bytecode/Label;Lgnu/bytecode/Label;)V
    //   472: iload 6
    //   474: ifeq +67 -> 541
    //   477: aload_0
    //   478: aload_1
    //   479: invokevirtual 1721	gnu/expr/Compilation:generateConstructor	(Lgnu/expr/LambdaExp;)V
    //   482: aload 51
    //   484: aload_0
    //   485: getfield 1490	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   488: invokevirtual 1724	gnu/bytecode/CodeAttr:emitNew	(Lgnu/bytecode/ClassType;)V
    //   491: aload 51
    //   493: aload_0
    //   494: getfield 1490	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   497: invokevirtual 1726	gnu/bytecode/CodeAttr:emitDup	(Lgnu/bytecode/Type;)V
    //   500: aload 51
    //   502: aload_0
    //   503: getfield 1490	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   506: getfield 1729	gnu/bytecode/ClassType:constructor	Lgnu/bytecode/Method;
    //   509: invokevirtual 1605	gnu/bytecode/CodeAttr:emitInvokeSpecial	(Lgnu/bytecode/Method;)V
    //   512: aload_0
    //   513: aload_0
    //   514: getfield 1490	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   517: ldc_w 1731
    //   520: aload_0
    //   521: getfield 1490	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   524: bipush 25
    //   526: invokevirtual 1155	gnu/bytecode/ClassType:addField	(Ljava/lang/String;Lgnu/bytecode/Type;I)Lgnu/bytecode/Field;
    //   529: putfield 1534	gnu/expr/Compilation:moduleInstanceMainField	Lgnu/bytecode/Field;
    //   532: aload 51
    //   534: aload_0
    //   535: getfield 1534	gnu/expr/Compilation:moduleInstanceMainField	Lgnu/bytecode/Field;
    //   538: invokevirtual 1734	gnu/bytecode/CodeAttr:emitPutStatic	(Lgnu/bytecode/Field;)V
    //   541: aload_0
    //   542: getfield 1736	gnu/expr/Compilation:clinitChain	Lgnu/expr/Initializer;
    //   545: astore 52
    //   547: aload 52
    //   549: ifnull +163 -> 712
    //   552: aload_0
    //   553: aconst_null
    //   554: putfield 1736	gnu/expr/Compilation:clinitChain	Lgnu/expr/Initializer;
    //   557: aload_0
    //   558: aload 52
    //   560: invokespecial 1738	gnu/expr/Compilation:dumpInitializers	(Lgnu/expr/Initializer;)V
    //   563: goto -22 -> 541
    //   566: aload_0
    //   567: new 257	gnu/bytecode/ClassType
    //   570: dup
    //   571: aload_0
    //   572: ldc_w 1740
    //   575: invokevirtual 1743	gnu/expr/Compilation:generateClassName	(Ljava/lang/String;)Ljava/lang/String;
    //   578: invokespecial 1744	gnu/bytecode/ClassType:<init>	(Ljava/lang/String;)V
    //   581: putfield 1490	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   584: aload_0
    //   585: getfield 1490	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   588: aload_2
    //   589: invokevirtual 1125	gnu/bytecode/ClassType:setSuper	(Lgnu/bytecode/ClassType;)V
    //   592: aload_0
    //   593: aload_0
    //   594: getfield 1490	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   597: invokevirtual 1130	gnu/expr/Compilation:addClass	(Lgnu/bytecode/ClassType;)V
    //   600: aload_0
    //   601: aload_0
    //   602: getfield 1490	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   605: aconst_null
    //   606: invokevirtual 1747	gnu/expr/Compilation:generateConstructor	(Lgnu/bytecode/ClassType;Lgnu/expr/LambdaExp;)V
    //   609: goto -498 -> 111
    //   612: aload_1
    //   613: getfield 1748	gnu/expr/ModuleExp:min_args	I
    //   616: aload_1
    //   617: getfield 1749	gnu/expr/ModuleExp:max_args	I
    //   620: if_icmpne +11 -> 631
    //   623: aload_1
    //   624: getfield 1748	gnu/expr/ModuleExp:min_args	I
    //   627: iconst_4
    //   628: if_icmple +26 -> 654
    //   631: iconst_1
    //   632: anewarray 248	gnu/bytecode/Type
    //   635: astore 4
    //   637: aload 4
    //   639: iconst_0
    //   640: new 287	gnu/bytecode/ArrayType
    //   643: dup
    //   644: getstatic 253	gnu/expr/Compilation:typeObject	Lgnu/bytecode/ClassType;
    //   647: invokespecial 1751	gnu/bytecode/ArrayType:<init>	(Lgnu/bytecode/Type;)V
    //   650: aastore
    //   651: goto -502 -> 149
    //   654: aload_1
    //   655: getfield 1748	gnu/expr/ModuleExp:min_args	I
    //   658: istore 59
    //   660: iload 59
    //   662: anewarray 248	gnu/bytecode/Type
    //   665: astore 4
    //   667: iload 59
    //   669: istore 60
    //   671: iinc 60 255
    //   674: iload 60
    //   676: iflt -527 -> 149
    //   679: aload 4
    //   681: iload 60
    //   683: getstatic 253	gnu/expr/Compilation:typeObject	Lgnu/bytecode/ClassType;
    //   686: aastore
    //   687: goto -16 -> 671
    //   690: aload_1
    //   691: aload_1
    //   692: getfield 1128	gnu/expr/ModuleExp:type	Lgnu/bytecode/ClassType;
    //   695: invokevirtual 1755	gnu/expr/ModuleExp:declareThis	(Lgnu/bytecode/ClassType;)Lgnu/bytecode/Variable;
    //   698: astore 8
    //   700: goto -492 -> 208
    //   703: aload_1
    //   704: getfield 1660	gnu/expr/ModuleExp:thisVariable	Lgnu/bytecode/Variable;
    //   707: astore 9
    //   709: goto -477 -> 232
    //   712: aload_1
    //   713: invokevirtual 1758	gnu/expr/ModuleExp:staticInitRun	()Z
    //   716: ifeq +27 -> 743
    //   719: aload 51
    //   721: aload_0
    //   722: getfield 1534	gnu/expr/Compilation:moduleInstanceMainField	Lgnu/bytecode/Field;
    //   725: invokevirtual 1221	gnu/bytecode/CodeAttr:emitGetStatic	(Lgnu/bytecode/Field;)V
    //   728: aload 51
    //   730: getstatic 469	gnu/expr/Compilation:typeModuleBody	Lgnu/bytecode/ClassType;
    //   733: ldc_w 1652
    //   736: iconst_0
    //   737: invokevirtual 339	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;I)Lgnu/bytecode/Method;
    //   740: invokevirtual 1016	gnu/bytecode/CodeAttr:emitInvoke	(Lgnu/bytecode/Method;)V
    //   743: aload 51
    //   745: invokevirtual 1582	gnu/bytecode/CodeAttr:emitReturn	()V
    //   748: aload_0
    //   749: getfield 1490	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   752: aload_0
    //   753: getfield 872	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   756: if_acmpeq +263 -> 1019
    //   759: iload 6
    //   761: ifne +258 -> 1019
    //   764: aload_0
    //   765: getfield 560	gnu/expr/Compilation:generateMain	Z
    //   768: ifne +251 -> 1019
    //   771: aload_0
    //   772: getfield 1206	gnu/expr/Compilation:immediate	Z
    //   775: ifne +244 -> 1019
    //   778: aload_0
    //   779: aload_0
    //   780: getfield 944	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   783: ldc_w 1652
    //   786: iconst_1
    //   787: getstatic 350	gnu/bytecode/Type:typeArray0	[Lgnu/bytecode/Type;
    //   790: getstatic 435	gnu/bytecode/Type:voidType	Lgnu/bytecode/PrimType;
    //   793: invokevirtual 677	gnu/bytecode/ClassType:addMethod	(Ljava/lang/String;I[Lgnu/bytecode/Type;Lgnu/bytecode/Type;)Lgnu/bytecode/Method;
    //   796: putfield 947	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   799: aload_0
    //   800: getfield 947	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   803: invokevirtual 951	gnu/bytecode/Method:startCode	()Lgnu/bytecode/CodeAttr;
    //   806: astore 53
    //   808: aload 53
    //   810: getstatic 485	gnu/expr/Compilation:typeCallContext	Lgnu/bytecode/ClassType;
    //   813: invokevirtual 1011	gnu/bytecode/CodeAttr:addLocal	(Lgnu/bytecode/Type;)Lgnu/bytecode/Variable;
    //   816: astore 54
    //   818: aload 53
    //   820: getstatic 489	gnu/expr/Compilation:typeConsumer	Lgnu/bytecode/ClassType;
    //   823: invokevirtual 1011	gnu/bytecode/CodeAttr:addLocal	(Lgnu/bytecode/Type;)Lgnu/bytecode/Variable;
    //   826: astore 55
    //   828: aload 53
    //   830: getstatic 1761	gnu/bytecode/Type:javalangThrowableType	Lgnu/bytecode/ClassType;
    //   833: invokevirtual 1011	gnu/bytecode/CodeAttr:addLocal	(Lgnu/bytecode/Type;)Lgnu/bytecode/Variable;
    //   836: astore 56
    //   838: aload 53
    //   840: getstatic 493	gnu/expr/Compilation:getCallContextInstanceMethod	Lgnu/bytecode/Method;
    //   843: invokevirtual 976	gnu/bytecode/CodeAttr:emitInvokeStatic	(Lgnu/bytecode/Method;)V
    //   846: aload 53
    //   848: aload 54
    //   850: invokevirtual 1023	gnu/bytecode/CodeAttr:emitStore	(Lgnu/bytecode/Variable;)V
    //   853: getstatic 485	gnu/expr/Compilation:typeCallContext	Lgnu/bytecode/ClassType;
    //   856: ldc_w 1763
    //   859: invokevirtual 365	gnu/bytecode/ClassType:getDeclaredField	(Ljava/lang/String;)Lgnu/bytecode/Field;
    //   862: astore 57
    //   864: aload 53
    //   866: aload 54
    //   868: invokevirtual 991	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   871: aload 53
    //   873: aload 57
    //   875: invokevirtual 1493	gnu/bytecode/CodeAttr:emitGetField	(Lgnu/bytecode/Field;)V
    //   878: aload 53
    //   880: aload 55
    //   882: invokevirtual 1023	gnu/bytecode/CodeAttr:emitStore	(Lgnu/bytecode/Variable;)V
    //   885: aload 53
    //   887: aload 54
    //   889: invokevirtual 991	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   892: aload 53
    //   894: ldc_w 1765
    //   897: invokestatic 261	gnu/bytecode/ClassType:make	(Ljava/lang/String;)Lgnu/bytecode/ClassType;
    //   900: ldc_w 1767
    //   903: invokevirtual 365	gnu/bytecode/ClassType:getDeclaredField	(Ljava/lang/String;)Lgnu/bytecode/Field;
    //   906: invokevirtual 1221	gnu/bytecode/CodeAttr:emitGetStatic	(Lgnu/bytecode/Field;)V
    //   909: aload 53
    //   911: aload 57
    //   913: invokevirtual 1770	gnu/bytecode/CodeAttr:emitPutField	(Lgnu/bytecode/Field;)V
    //   916: aload 53
    //   918: iconst_0
    //   919: getstatic 435	gnu/bytecode/Type:voidType	Lgnu/bytecode/PrimType;
    //   922: invokevirtual 1774	gnu/bytecode/CodeAttr:emitTryStart	(ZLgnu/bytecode/Type;)V
    //   925: aload 53
    //   927: invokevirtual 1182	gnu/bytecode/CodeAttr:emitPushThis	()V
    //   930: aload 53
    //   932: aload 54
    //   934: invokevirtual 991	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   937: aload 53
    //   939: aload 49
    //   941: invokevirtual 999	gnu/bytecode/CodeAttr:emitInvokeVirtual	(Lgnu/bytecode/Method;)V
    //   944: aload 53
    //   946: invokevirtual 1210	gnu/bytecode/CodeAttr:emitPushNull	()V
    //   949: aload 53
    //   951: aload 56
    //   953: invokevirtual 1023	gnu/bytecode/CodeAttr:emitStore	(Lgnu/bytecode/Variable;)V
    //   956: aload 53
    //   958: invokevirtual 1777	gnu/bytecode/CodeAttr:emitTryEnd	()V
    //   961: aload 53
    //   963: aload 56
    //   965: invokevirtual 1780	gnu/bytecode/CodeAttr:emitCatchStart	(Lgnu/bytecode/Variable;)V
    //   968: aload 53
    //   970: invokevirtual 1783	gnu/bytecode/CodeAttr:emitCatchEnd	()V
    //   973: aload 53
    //   975: invokevirtual 1786	gnu/bytecode/CodeAttr:emitTryCatchEnd	()V
    //   978: aload 53
    //   980: aload 54
    //   982: invokevirtual 991	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   985: aload 53
    //   987: aload 56
    //   989: invokevirtual 991	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   992: aload 53
    //   994: aload 55
    //   996: invokevirtual 991	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   999: aload 53
    //   1001: getstatic 469	gnu/expr/Compilation:typeModuleBody	Lgnu/bytecode/ClassType;
    //   1004: ldc_w 1788
    //   1007: iconst_3
    //   1008: invokevirtual 339	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;I)Lgnu/bytecode/Method;
    //   1011: invokevirtual 976	gnu/bytecode/CodeAttr:emitInvokeStatic	(Lgnu/bytecode/Method;)V
    //   1014: aload 53
    //   1016: invokevirtual 1582	gnu/bytecode/CodeAttr:emitReturn	()V
    //   1019: aload_0
    //   1020: aload 49
    //   1022: putfield 947	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1025: aload_0
    //   1026: aload 50
    //   1028: putfield 1678	gnu/expr/Compilation:callContextVar	Lgnu/bytecode/Variable;
    //   1031: aload_1
    //   1032: aload_0
    //   1033: invokevirtual 1791	gnu/expr/ModuleExp:generateApplyMethods	(Lgnu/expr/Compilation;)V
    //   1036: aload_0
    //   1037: aload_3
    //   1038: putfield 1641	gnu/expr/Compilation:curLambda	Lgnu/expr/LambdaExp;
    //   1041: aload_1
    //   1042: aload 5
    //   1044: putfield 1647	gnu/expr/ModuleExp:heapFrame	Lgnu/bytecode/Variable;
    //   1047: aload_0
    //   1048: invokevirtual 1669	gnu/expr/Compilation:usingCPStyle	()Z
    //   1051: ifeq +18 -> 1069
    //   1054: aload_0
    //   1055: invokevirtual 981	gnu/expr/Compilation:getCode	()Lgnu/bytecode/CodeAttr;
    //   1058: astore 48
    //   1060: aload_0
    //   1061: getfield 1704	gnu/expr/Compilation:fswitch	Lgnu/bytecode/SwitchState;
    //   1064: aload 48
    //   1066: invokevirtual 1590	gnu/bytecode/SwitchState:finish	(Lgnu/bytecode/CodeAttr;)V
    //   1069: aload 15
    //   1071: ifnonnull +10 -> 1081
    //   1074: aload_0
    //   1075: getfield 1678	gnu/expr/Compilation:callContextVar	Lgnu/bytecode/Variable;
    //   1078: ifnull +102 -> 1180
    //   1081: aload_0
    //   1082: aload 14
    //   1084: putfield 947	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1087: aload_0
    //   1088: invokevirtual 981	gnu/expr/Compilation:getCode	()Lgnu/bytecode/CodeAttr;
    //   1091: astore 16
    //   1093: new 1032	gnu/bytecode/Label
    //   1096: dup
    //   1097: aload 16
    //   1099: invokespecial 1035	gnu/bytecode/Label:<init>	(Lgnu/bytecode/CodeAttr;)V
    //   1102: astore 17
    //   1104: aload 16
    //   1106: aload 15
    //   1108: aload 17
    //   1110: invokevirtual 1718	gnu/bytecode/CodeAttr:fixupChain	(Lgnu/bytecode/Label;Lgnu/bytecode/Label;)V
    //   1113: aload_0
    //   1114: getfield 1793	gnu/expr/Compilation:callContextVarForInit	Lgnu/bytecode/Variable;
    //   1117: ifnull +20 -> 1137
    //   1120: aload 16
    //   1122: getstatic 493	gnu/expr/Compilation:getCallContextInstanceMethod	Lgnu/bytecode/Method;
    //   1125: invokevirtual 976	gnu/bytecode/CodeAttr:emitInvokeStatic	(Lgnu/bytecode/Method;)V
    //   1128: aload 16
    //   1130: aload_0
    //   1131: getfield 1793	gnu/expr/Compilation:callContextVarForInit	Lgnu/bytecode/Variable;
    //   1134: invokevirtual 1023	gnu/bytecode/CodeAttr:emitStore	(Lgnu/bytecode/Variable;)V
    //   1137: aload_0
    //   1138: getfield 1206	gnu/expr/Compilation:immediate	Z
    //   1141: ifeq +646 -> 1787
    //   1144: aload 16
    //   1146: aload_0
    //   1147: invokestatic 1795	gnu/expr/Compilation:registerForImmediateLiterals	(Lgnu/expr/Compilation;)I
    //   1150: invokevirtual 994	gnu/bytecode/CodeAttr:emitPushInt	(I)V
    //   1153: aload 16
    //   1155: ldc_w 1797
    //   1158: invokestatic 261	gnu/bytecode/ClassType:make	(Ljava/lang/String;)Lgnu/bytecode/ClassType;
    //   1161: ldc_w 1798
    //   1164: iconst_1
    //   1165: invokevirtual 339	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;I)Lgnu/bytecode/Method;
    //   1168: invokevirtual 976	gnu/bytecode/CodeAttr:emitInvokeStatic	(Lgnu/bytecode/Method;)V
    //   1171: aload 16
    //   1173: aload 17
    //   1175: aload 13
    //   1177: invokevirtual 1718	gnu/bytecode/CodeAttr:fixupChain	(Lgnu/bytecode/Label;Lgnu/bytecode/Label;)V
    //   1180: aload_0
    //   1181: getfield 560	gnu/expr/Compilation:generateMain	Z
    //   1184: ifeq +161 -> 1345
    //   1187: aload_0
    //   1188: getfield 944	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   1191: aload_0
    //   1192: getfield 872	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   1195: if_acmpne +150 -> 1345
    //   1198: iconst_1
    //   1199: anewarray 248	gnu/bytecode/Type
    //   1202: astore 46
    //   1204: aload 46
    //   1206: iconst_0
    //   1207: new 287	gnu/bytecode/ArrayType
    //   1210: dup
    //   1211: getstatic 269	gnu/expr/Compilation:javaStringType	Lgnu/bytecode/ClassType;
    //   1214: invokespecial 1751	gnu/bytecode/ArrayType:<init>	(Lgnu/bytecode/Type;)V
    //   1217: aastore
    //   1218: aload_0
    //   1219: aload_0
    //   1220: getfield 944	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   1223: ldc_w 1800
    //   1226: bipush 9
    //   1228: aload 46
    //   1230: getstatic 435	gnu/bytecode/Type:voidType	Lgnu/bytecode/PrimType;
    //   1233: invokevirtual 677	gnu/bytecode/ClassType:addMethod	(Ljava/lang/String;I[Lgnu/bytecode/Type;Lgnu/bytecode/Type;)Lgnu/bytecode/Method;
    //   1236: putfield 947	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1239: aload_0
    //   1240: getfield 947	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1243: invokevirtual 951	gnu/bytecode/Method:startCode	()Lgnu/bytecode/CodeAttr;
    //   1246: astore 47
    //   1248: getstatic 1805	kawa/Shell:defaultFormatName	Ljava/lang/String;
    //   1251: ifnull +29 -> 1280
    //   1254: aload 47
    //   1256: getstatic 1805	kawa/Shell:defaultFormatName	Ljava/lang/String;
    //   1259: invokevirtual 1213	gnu/bytecode/CodeAttr:emitPushString	(Ljava/lang/String;)V
    //   1262: aload 47
    //   1264: ldc_w 1807
    //   1267: invokestatic 261	gnu/bytecode/ClassType:make	(Ljava/lang/String;)Lgnu/bytecode/ClassType;
    //   1270: ldc_w 1809
    //   1273: iconst_1
    //   1274: invokevirtual 339	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;I)Lgnu/bytecode/Method;
    //   1277: invokevirtual 976	gnu/bytecode/CodeAttr:emitInvokeStatic	(Lgnu/bytecode/Method;)V
    //   1280: aload 47
    //   1282: aload 47
    //   1284: iconst_0
    //   1285: invokevirtual 1003	gnu/bytecode/CodeAttr:getArg	(I)Lgnu/bytecode/Variable;
    //   1288: invokevirtual 991	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   1291: aload 47
    //   1293: ldc_w 1811
    //   1296: invokestatic 261	gnu/bytecode/ClassType:make	(Ljava/lang/String;)Lgnu/bytecode/ClassType;
    //   1299: ldc_w 1813
    //   1302: iconst_1
    //   1303: invokevirtual 339	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;I)Lgnu/bytecode/Method;
    //   1306: invokevirtual 976	gnu/bytecode/CodeAttr:emitInvokeStatic	(Lgnu/bytecode/Method;)V
    //   1309: aload_0
    //   1310: getfield 1534	gnu/expr/Compilation:moduleInstanceMainField	Lgnu/bytecode/Field;
    //   1313: ifnull +516 -> 1829
    //   1316: aload 47
    //   1318: aload_0
    //   1319: getfield 1534	gnu/expr/Compilation:moduleInstanceMainField	Lgnu/bytecode/Field;
    //   1322: invokevirtual 1221	gnu/bytecode/CodeAttr:emitGetStatic	(Lgnu/bytecode/Field;)V
    //   1325: aload 47
    //   1327: getstatic 469	gnu/expr/Compilation:typeModuleBody	Lgnu/bytecode/ClassType;
    //   1330: ldc_w 1815
    //   1333: iconst_0
    //   1334: invokevirtual 339	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;I)Lgnu/bytecode/Method;
    //   1337: invokevirtual 999	gnu/bytecode/CodeAttr:emitInvokeVirtual	(Lgnu/bytecode/Method;)V
    //   1340: aload 47
    //   1342: invokevirtual 1582	gnu/bytecode/CodeAttr:emitReturn	()V
    //   1345: aload_0
    //   1346: getfield 1192	gnu/expr/Compilation:minfo	Lgnu/expr/ModuleInfo;
    //   1349: ifnull +635 -> 1984
    //   1352: aload_0
    //   1353: getfield 1192	gnu/expr/Compilation:minfo	Lgnu/expr/ModuleInfo;
    //   1356: invokevirtual 1818	gnu/expr/ModuleInfo:getNamespaceUri	()Ljava/lang/String;
    //   1359: ifnull +625 -> 1984
    //   1362: invokestatic 1823	gnu/expr/ModuleManager:getInstance	()Lgnu/expr/ModuleManager;
    //   1365: astore 19
    //   1367: aload_0
    //   1368: getfield 872	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   1371: invokevirtual 897	gnu/bytecode/ClassType:getName	()Ljava/lang/String;
    //   1374: astore 20
    //   1376: aload 20
    //   1378: bipush 46
    //   1380: invokevirtual 1825	java/lang/String:lastIndexOf	(I)I
    //   1383: istore 21
    //   1385: iload 21
    //   1387: ifge +475 -> 1862
    //   1390: ldc_w 535
    //   1393: astore 24
    //   1395: new 257	gnu/bytecode/ClassType
    //   1398: dup
    //   1399: new 1139	java/lang/StringBuilder
    //   1402: dup
    //   1403: invokespecial 1140	java/lang/StringBuilder:<init>	()V
    //   1406: aload 24
    //   1408: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1411: ldc_w 1827
    //   1414: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: invokevirtual 1151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1420: invokespecial 1744	gnu/bytecode/ClassType:<init>	(Ljava/lang/String;)V
    //   1423: astore 25
    //   1425: ldc_w 1829
    //   1428: invokestatic 261	gnu/bytecode/ClassType:make	(Ljava/lang/String;)Lgnu/bytecode/ClassType;
    //   1431: astore 26
    //   1433: aload 25
    //   1435: aload 26
    //   1437: invokevirtual 1125	gnu/bytecode/ClassType:setSuper	(Lgnu/bytecode/ClassType;)V
    //   1440: aload_0
    //   1441: aload 25
    //   1443: invokespecial 1095	gnu/expr/Compilation:registerClass	(Lgnu/bytecode/ClassType;)V
    //   1446: aload_0
    //   1447: aload 25
    //   1449: ldc_w 663
    //   1452: iconst_1
    //   1453: getstatic 400	gnu/expr/Compilation:apply0args	[Lgnu/bytecode/Type;
    //   1456: getstatic 435	gnu/bytecode/Type:voidType	Lgnu/bytecode/PrimType;
    //   1459: invokevirtual 677	gnu/bytecode/ClassType:addMethod	(Ljava/lang/String;I[Lgnu/bytecode/Type;Lgnu/bytecode/Type;)Lgnu/bytecode/Method;
    //   1462: putfield 947	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1465: aload 26
    //   1467: ldc_w 663
    //   1470: iconst_1
    //   1471: getstatic 400	gnu/expr/Compilation:apply0args	[Lgnu/bytecode/Type;
    //   1474: getstatic 435	gnu/bytecode/Type:voidType	Lgnu/bytecode/PrimType;
    //   1477: invokevirtual 677	gnu/bytecode/ClassType:addMethod	(Ljava/lang/String;I[Lgnu/bytecode/Type;Lgnu/bytecode/Type;)Lgnu/bytecode/Method;
    //   1480: astore 27
    //   1482: aload_0
    //   1483: getfield 947	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1486: invokevirtual 951	gnu/bytecode/Method:startCode	()Lgnu/bytecode/CodeAttr;
    //   1489: astore 28
    //   1491: aload 28
    //   1493: invokevirtual 1182	gnu/bytecode/CodeAttr:emitPushThis	()V
    //   1496: aload 28
    //   1498: aload 27
    //   1500: invokevirtual 1605	gnu/bytecode/CodeAttr:emitInvokeSpecial	(Lgnu/bytecode/Method;)V
    //   1503: aload 28
    //   1505: invokevirtual 1582	gnu/bytecode/CodeAttr:emitReturn	()V
    //   1508: ldc_w 1831
    //   1511: invokestatic 261	gnu/bytecode/ClassType:make	(Ljava/lang/String;)Lgnu/bytecode/ClassType;
    //   1514: astore 29
    //   1516: aload_0
    //   1517: aload 25
    //   1519: ldc_w 1833
    //   1522: iconst_1
    //   1523: anewarray 248	gnu/bytecode/Type
    //   1526: dup
    //   1527: iconst_0
    //   1528: aload 29
    //   1530: aastore
    //   1531: getstatic 435	gnu/bytecode/Type:voidType	Lgnu/bytecode/PrimType;
    //   1534: iconst_1
    //   1535: invokevirtual 354	gnu/bytecode/ClassType:addMethod	(Ljava/lang/String;[Lgnu/bytecode/Type;Lgnu/bytecode/Type;I)Lgnu/bytecode/Method;
    //   1538: putfield 947	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1541: aload_0
    //   1542: getfield 947	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1545: invokevirtual 951	gnu/bytecode/Method:startCode	()Lgnu/bytecode/CodeAttr;
    //   1548: astore 30
    //   1550: aload 29
    //   1552: ldc_w 1833
    //   1555: iconst_3
    //   1556: invokevirtual 339	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;I)Lgnu/bytecode/Method;
    //   1559: astore 31
    //   1561: aload 19
    //   1563: getfield 1836	gnu/expr/ModuleManager:numModules	I
    //   1566: istore 32
    //   1568: iinc 32 255
    //   1571: iload 32
    //   1573: iflt +406 -> 1979
    //   1576: aload 19
    //   1578: getfield 1840	gnu/expr/ModuleManager:modules	[Lgnu/expr/ModuleInfo;
    //   1581: iload 32
    //   1583: aaload
    //   1584: astore 33
    //   1586: aload 33
    //   1588: invokevirtual 1843	gnu/expr/ModuleInfo:getClassName	()Ljava/lang/String;
    //   1591: astore 34
    //   1593: aload 34
    //   1595: ifnull -27 -> 1568
    //   1598: aload 34
    //   1600: aload 24
    //   1602: invokevirtual 828	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1605: ifeq -37 -> 1568
    //   1608: aload 33
    //   1610: getfield 1846	gnu/expr/ModuleInfo:sourcePath	Ljava/lang/String;
    //   1613: astore 35
    //   1615: aload 33
    //   1617: invokevirtual 1818	gnu/expr/ModuleInfo:getNamespaceUri	()Ljava/lang/String;
    //   1620: astore 36
    //   1622: aload 30
    //   1624: aload 30
    //   1626: iconst_1
    //   1627: invokevirtual 1003	gnu/bytecode/CodeAttr:getArg	(I)Lgnu/bytecode/Variable;
    //   1630: invokevirtual 991	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   1633: aload_0
    //   1634: aload 34
    //   1636: invokevirtual 1312	gnu/expr/Compilation:compileConstant	(Ljava/lang/Object;)V
    //   1639: aload 35
    //   1641: invokestatic 1852	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   1644: invokevirtual 1855	gnu/text/Path:isAbsolute	()Z
    //   1647: ifne +118 -> 1765
    //   1650: getstatic 1859	java/io/File:separatorChar	C
    //   1653: istore 39
    //   1655: aload 19
    //   1657: invokevirtual 1862	gnu/expr/ModuleManager:getCompilationDirectory	()Ljava/lang/String;
    //   1660: astore 40
    //   1662: new 1139	java/lang/StringBuilder
    //   1665: dup
    //   1666: invokespecial 1140	java/lang/StringBuilder:<init>	()V
    //   1669: aload 40
    //   1671: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1674: aload 24
    //   1676: bipush 46
    //   1678: iload 39
    //   1680: invokevirtual 1387	java/lang/String:replace	(CC)Ljava/lang/String;
    //   1683: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: invokevirtual 1151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1689: invokestatic 1866	gnu/text/Path:toURL	(Ljava/lang/String;)Ljava/net/URL;
    //   1692: invokevirtual 1869	java/net/URL:toString	()Ljava/lang/String;
    //   1695: astore 41
    //   1697: aload 41
    //   1699: invokevirtual 603	java/lang/String:length	()I
    //   1702: istore 42
    //   1704: iload 42
    //   1706: ifle +43 -> 1749
    //   1709: iload 42
    //   1711: iconst_1
    //   1712: isub
    //   1713: istore 44
    //   1715: aload 41
    //   1717: iload 44
    //   1719: invokevirtual 607	java/lang/String:charAt	(I)C
    //   1722: iload 39
    //   1724: if_icmpeq +25 -> 1749
    //   1727: new 1139	java/lang/StringBuilder
    //   1730: dup
    //   1731: invokespecial 1140	java/lang/StringBuilder:<init>	()V
    //   1734: aload 41
    //   1736: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: iload 39
    //   1741: invokevirtual 1872	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1744: invokevirtual 1151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1747: astore 41
    //   1749: aload 33
    //   1751: invokevirtual 1875	gnu/expr/ModuleInfo:getSourceAbsPathname	()Ljava/lang/String;
    //   1754: aload 41
    //   1756: invokestatic 1879	gnu/text/Path:relativize	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1759: astore 43
    //   1761: aload 43
    //   1763: astore 35
    //   1765: aload_0
    //   1766: aload 35
    //   1768: invokevirtual 1312	gnu/expr/Compilation:compileConstant	(Ljava/lang/Object;)V
    //   1771: aload_0
    //   1772: aload 36
    //   1774: invokevirtual 1312	gnu/expr/Compilation:compileConstant	(Ljava/lang/Object;)V
    //   1777: aload 30
    //   1779: aload 31
    //   1781: invokevirtual 999	gnu/bytecode/CodeAttr:emitInvokeVirtual	(Lgnu/bytecode/Method;)V
    //   1784: goto -216 -> 1568
    //   1787: aload_0
    //   1788: getfield 905	gnu/expr/Compilation:litTable	Lgnu/expr/LitTable;
    //   1791: invokevirtual 1881	gnu/expr/LitTable:emit	()V
    //   1794: goto -623 -> 1171
    //   1797: astore 18
    //   1799: aload_0
    //   1800: bipush 101
    //   1802: new 1139	java/lang/StringBuilder
    //   1805: dup
    //   1806: invokespecial 1140	java/lang/StringBuilder:<init>	()V
    //   1809: ldc_w 1883
    //   1812: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1815: aload 18
    //   1817: invokevirtual 1569	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1820: invokevirtual 1151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1823: invokevirtual 1329	gnu/expr/Compilation:error	(CLjava/lang/String;)V
    //   1826: goto -655 -> 1171
    //   1829: aload 47
    //   1831: aload_0
    //   1832: getfield 944	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   1835: invokevirtual 1724	gnu/bytecode/CodeAttr:emitNew	(Lgnu/bytecode/ClassType;)V
    //   1838: aload 47
    //   1840: aload_0
    //   1841: getfield 944	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   1844: invokevirtual 1726	gnu/bytecode/CodeAttr:emitDup	(Lgnu/bytecode/Type;)V
    //   1847: aload 47
    //   1849: aload_0
    //   1850: getfield 944	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   1853: getfield 1729	gnu/bytecode/ClassType:constructor	Lgnu/bytecode/Method;
    //   1856: invokevirtual 1605	gnu/bytecode/CodeAttr:emitInvokeSpecial	(Lgnu/bytecode/Method;)V
    //   1859: goto -534 -> 1325
    //   1862: aload 20
    //   1864: iconst_0
    //   1865: iload 21
    //   1867: invokevirtual 835	java/lang/String:substring	(II)Ljava/lang/String;
    //   1870: astore 22
    //   1872: aload 19
    //   1874: aload 22
    //   1876: invokevirtual 1886	gnu/expr/ModuleManager:loadPackageInfo	(Ljava/lang/String;)V
    //   1879: aload 20
    //   1881: iconst_0
    //   1882: iload 21
    //   1884: iconst_1
    //   1885: iadd
    //   1886: invokevirtual 835	java/lang/String:substring	(II)Ljava/lang/String;
    //   1889: astore 24
    //   1891: goto -496 -> 1395
    //   1894: astore 45
    //   1896: aload_0
    //   1897: bipush 101
    //   1899: new 1139	java/lang/StringBuilder
    //   1902: dup
    //   1903: invokespecial 1140	java/lang/StringBuilder:<init>	()V
    //   1906: ldc_w 1888
    //   1909: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1912: aload 22
    //   1914: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1917: ldc_w 1890
    //   1920: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: aload 45
    //   1925: invokevirtual 1569	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1928: invokevirtual 1151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1931: invokevirtual 1329	gnu/expr/Compilation:error	(CLjava/lang/String;)V
    //   1934: goto -55 -> 1879
    //   1937: astore 37
    //   1939: new 935	gnu/mapping/WrappedException
    //   1942: dup
    //   1943: new 1139	java/lang/StringBuilder
    //   1946: dup
    //   1947: invokespecial 1140	java/lang/StringBuilder:<init>	()V
    //   1950: ldc_w 1892
    //   1953: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1956: aload 35
    //   1958: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1961: bipush 39
    //   1963: invokevirtual 1872	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1966: invokevirtual 1151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1969: aload 37
    //   1971: invokespecial 940	gnu/mapping/WrappedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1974: astore 38
    //   1976: aload 38
    //   1978: athrow
    //   1979: aload 30
    //   1981: invokevirtual 1582	gnu/bytecode/CodeAttr:emitReturn	()V
    //   1984: return
    //   1985: astore 23
    //   1987: goto -108 -> 1879
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1990	0	this	Compilation
    //   4	1038	1	localModuleExp	ModuleExp
    //   88	501	2	localClassType1	ClassType
    //   123	915	3	localLambdaExp	LambdaExp
    //   140	540	4	arrayOfType1	Type[]
    //   153	890	5	localVariable1	Variable
    //   159	601	6	bool	boolean
    //   193	170	7	localCodeAttr1	CodeAttr
    //   206	493	8	localVariable2	Variable
    //   230	478	9	localVariable3	Variable
    //   301	14	10	i	int
    //   382	18	11	localClassType2	ClassType
    //   388	14	12	localClassType3	ClassType
    //   391	785	13	localLabel1	Label
    //   394	689	14	localMethod1	Method
    //   397	710	15	localLabel2	Label
    //   1091	81	16	localCodeAttr2	CodeAttr
    //   1102	72	17	localLabel3	Label
    //   1797	19	18	localThrowable1	Throwable
    //   1365	508	19	localModuleManager	ModuleManager
    //   1374	506	20	str1	String
    //   1383	503	21	j	int
    //   1870	43	22	str2	String
    //   1985	1	23	localClassNotFoundException	java.lang.ClassNotFoundException
    //   1393	497	24	str3	String
    //   1423	95	25	localClassType4	ClassType
    //   1431	35	26	localClassType5	ClassType
    //   1480	19	27	localMethod2	Method
    //   1489	15	28	localCodeAttr3	CodeAttr
    //   1514	37	29	localClassType6	ClassType
    //   1548	432	30	localCodeAttr4	CodeAttr
    //   1559	221	31	localMethod3	Method
    //   1566	16	32	k	int
    //   1584	166	33	localModuleInfo	ModuleInfo
    //   1591	44	34	str4	String
    //   1613	344	35	localObject	Object
    //   1620	153	36	str5	String
    //   1937	33	37	localThrowable2	Throwable
    //   1974	3	38	localWrappedException	WrappedException
    //   1653	87	39	c	char
    //   1660	10	40	str6	String
    //   1695	60	41	str7	String
    //   1702	11	42	m	int
    //   1759	3	43	str8	String
    //   1713	5	44	n	int
    //   1894	30	45	localThrowable3	Throwable
    //   1202	27	46	arrayOfType2	Type[]
    //   1246	602	47	localCodeAttr5	CodeAttr
    //   1058	7	48	localCodeAttr6	CodeAttr
    //   410	611	49	localMethod4	Method
    //   416	611	50	localVariable4	Variable
    //   439	305	51	localCodeAttr7	CodeAttr
    //   545	14	52	localInitializer	Initializer
    //   806	209	53	localCodeAttr8	CodeAttr
    //   816	165	54	localVariable5	Variable
    //   826	169	55	localVariable6	Variable
    //   836	152	56	localVariable7	Variable
    //   862	50	57	localField	gnu.bytecode.Field
    //   658	10	59	i1	int
    //   669	13	60	i2	int
    //   14	66	61	localOutPort	OutPort
    // Exception table:
    //   from	to	target	type
    //   1137	1171	1797	java/lang/Throwable
    //   1787	1794	1797	java/lang/Throwable
    //   1872	1879	1894	java/lang/Throwable
    //   1650	1704	1937	java/lang/Throwable
    //   1715	1749	1937	java/lang/Throwable
    //   1749	1761	1937	java/lang/Throwable
    //   1872	1879	1985	java/lang/ClassNotFoundException
  }
  
  public String generateClassName(String paramString)
  {
    String str1 = mangleName(paramString, true);
    if (this.mainClass != null) {
      str1 = this.mainClass.getName() + '$' + str1;
    }
    while (findNamedClass(str1) == null)
    {
      return str1;
      if (this.classPrefix != null) {
        str1 = this.classPrefix + str1;
      }
    }
    for (int i = 0;; i++)
    {
      String str2 = str1 + i;
      if (findNamedClass(str2) == null) {
        return str2;
      }
    }
  }
  
  public final void generateConstructor(ClassType paramClassType, LambdaExp paramLambdaExp)
  {
    Method localMethod1 = this.method;
    Variable localVariable = this.callContextVar;
    this.callContextVar = null;
    ClassType localClassType = this.curClass;
    this.curClass = paramClassType;
    Method localMethod2 = getConstructor(paramClassType, paramLambdaExp);
    paramClassType.constructor = localMethod2;
    this.method = localMethod2;
    CodeAttr localCodeAttr = localMethod2.startCode();
    if (((paramLambdaExp instanceof ClassExp)) && (paramLambdaExp.staticLinkField != null))
    {
      localCodeAttr.emitPushThis();
      localCodeAttr.emitLoad(localCodeAttr.getCurrentScope().getVariable(1));
      localCodeAttr.emitPutField(paramLambdaExp.staticLinkField);
    }
    ClassExp.invokeDefaultSuperConstructor(paramClassType.getSuperclass(), this, paramLambdaExp);
    if ((this.curClass == this.mainClass) && (this.minfo != null) && (this.minfo.sourcePath != null))
    {
      localCodeAttr.emitPushThis();
      localCodeAttr.emitInvokeStatic(ClassType.make("gnu.expr.ModuleInfo").getDeclaredMethod("register", 1));
    }
    if ((paramLambdaExp != null) && (paramLambdaExp.initChain != null))
    {
      LambdaExp localLambdaExp = this.curLambda;
      this.curLambda = new LambdaExp();
      this.curLambda.closureEnv = localCodeAttr.getArg(0);
      this.curLambda.outer = localLambdaExp;
      for (;;)
      {
        Initializer localInitializer = paramLambdaExp.initChain;
        if (localInitializer == null) {
          break;
        }
        paramLambdaExp.initChain = null;
        dumpInitializers(localInitializer);
      }
      this.curLambda = localLambdaExp;
    }
    if ((paramLambdaExp instanceof ClassExp)) {
      callInitMethods(((ClassExp)paramLambdaExp).getCompiledClassType(this), new Vector(10));
    }
    localCodeAttr.emitReturn();
    this.method = localMethod1;
    this.curClass = localClassType;
    this.callContextVar = localVariable;
  }
  
  public final void generateConstructor(LambdaExp paramLambdaExp)
  {
    generateConstructor(paramLambdaExp.getHeapFrameType(), paramLambdaExp);
  }
  
  public void generateMatchMethods(LambdaExp paramLambdaExp)
  {
    if (paramLambdaExp.applyMethods == null) {}
    for (int i = 0; i == 0; i = paramLambdaExp.applyMethods.size()) {
      return;
    }
    Method localMethod = this.method;
    ClassType localClassType1 = this.curClass;
    ClassType localClassType2 = typeModuleMethod;
    this.curClass = paramLambdaExp.getHeapFrameType();
    if (!this.curClass.getSuperclass().isSubtype(typeModuleBody)) {
      this.curClass = this.moduleClass;
    }
    CodeAttr localCodeAttr = null;
    for (int j = 0; j <= 5; j++)
    {
      int k = 0;
      SwitchState localSwitchState = null;
      String str = null;
      Type[] arrayOfType = null;
      int m = i;
      LambdaExp localLambdaExp;
      int i3;
      int i4;
      label157:
      int i6;
      do
      {
        m--;
        if (m < 0) {
          break label883;
        }
        localLambdaExp = (LambdaExp)paramLambdaExp.applyMethods.elementAt(m);
        i3 = localLambdaExp.primMethods.length;
        if ((localLambdaExp.max_args >= 0) && (localLambdaExp.max_args < i3 + localLambdaExp.min_args)) {
          break;
        }
        i4 = 1;
        if (j >= 5) {
          break label273;
        }
        i6 = j - localLambdaExp.min_args;
      } while ((i6 < 0) || (i6 >= i3) || ((i6 == i3 - 1) && (i4 != 0)));
      label273:
      for (;;)
      {
        label199:
        if (k == 0)
        {
          if (j >= 5) {
            break label642;
          }
          str = "match" + j;
          arrayOfType = new Type[j + 2];
          int i10 = j;
          for (;;)
          {
            if (i10 >= 0)
            {
              arrayOfType[(i10 + 1)] = typeObject;
              i10--;
              continue;
              i4 = 0;
              break label157;
              int i5 = 5 - localLambdaExp.min_args;
              if ((i5 > 0) && (i3 <= i5) && (i4 == 0)) {
                break;
              }
              i6 = i3 - 1;
              break label199;
            }
          }
          arrayOfType[(j + 1)] = typeCallContext;
          arrayOfType[0] = localClassType2;
          this.method = this.curClass.addMethod(str, arrayOfType, Type.intType, 1);
          localCodeAttr = this.method.startCode();
          localCodeAttr.emitLoad(localCodeAttr.getArg(1));
          localCodeAttr.emitGetField(localClassType2.getField("selector"));
          localSwitchState = localCodeAttr.startSwitch();
          k = 1;
        }
      }
      localSwitchState.addCase(localLambdaExp.getSelectorValue(this), localCodeAttr);
      int i7 = localLambdaExp.getLineNumber();
      if (i7 > 0) {
        localCodeAttr.putLineNumber(localLambdaExp.getFileName(), i7);
      }
      int i8;
      label433:
      Variable localVariable;
      Declaration localDeclaration;
      int i9;
      label458:
      Type localType;
      if (j == 5)
      {
        i8 = 3;
        localVariable = localCodeAttr.getArg(i8);
        if (j >= 5) {
          break label744;
        }
        localDeclaration = localLambdaExp.firstDecl();
        i9 = 1;
        if (i9 > j) {
          break label776;
        }
        localCodeAttr.emitLoad(localVariable);
        localCodeAttr.emitLoad(localCodeAttr.getArg(i9 + 1));
        localType = localDeclaration.getType();
        if (localType != Type.objectType)
        {
          if (!(localType instanceof TypeValue)) {
            break label679;
          }
          Label localLabel1 = new Label(localCodeAttr);
          Label localLabel2 = new Label(localCodeAttr);
          ConditionalTarget localConditionalTarget = new ConditionalTarget(localLabel1, localLabel2, getLanguage());
          localCodeAttr.emitDup();
          ((TypeValue)localType).emitIsInstance(null, this, localConditionalTarget);
          localLabel2.define(localCodeAttr);
          localCodeAttr.emitPushInt(0xFFF40000 | i9);
          localCodeAttr.emitReturn();
          localLabel1.define(localCodeAttr);
        }
      }
      for (;;)
      {
        localCodeAttr.emitPutField(typeCallContext.getField("value" + i9));
        localDeclaration = localDeclaration.nextDecl();
        i9++;
        break label458;
        label642:
        str = "matchN";
        arrayOfType = new Type[3];
        arrayOfType[1] = objArrayType;
        arrayOfType[2] = typeCallContext;
        break;
        i8 = j + 2;
        break label433;
        label679:
        if (((localType instanceof ClassType)) && (localType != Type.objectType) && (localType != Type.toStringType))
        {
          localCodeAttr.emitDup();
          localType.emitIsInstance(localCodeAttr);
          localCodeAttr.emitIfIntEqZero();
          localCodeAttr.emitPushInt(0xFFF40000 | i9);
          localCodeAttr.emitReturn();
          localCodeAttr.emitFi();
        }
      }
      label744:
      localCodeAttr.emitLoad(localVariable);
      localCodeAttr.emitLoad(localCodeAttr.getArg(2));
      localCodeAttr.emitPutField(typeCallContext.getField("values"));
      label776:
      localCodeAttr.emitLoad(localVariable);
      if (defaultCallConvention < 2)
      {
        localCodeAttr.emitLoad(localCodeAttr.getArg(1));
        label801:
        localCodeAttr.emitPutField(procCallContextField);
        localCodeAttr.emitLoad(localVariable);
        if (defaultCallConvention < 2) {
          break label873;
        }
        localCodeAttr.emitPushInt(i6 + localLambdaExp.getSelectorValue(this));
      }
      for (;;)
      {
        localCodeAttr.emitPutField(pcCallContextField);
        localCodeAttr.emitPushInt(0);
        localCodeAttr.emitReturn();
        break;
        localCodeAttr.emitLoad(localCodeAttr.getArg(0));
        break label801;
        label873:
        localCodeAttr.emitPushInt(j);
      }
      label883:
      if (k != 0)
      {
        localSwitchState.addDefault(localCodeAttr);
        if (j > 4) {}
        for (int n = 2;; n = j + 1)
        {
          int i1 = n + 1;
          for (int i2 = 0; i2 <= i1; i2++) {
            localCodeAttr.emitLoad(localCodeAttr.getArg(i2));
          }
        }
        localCodeAttr.emitInvokeSpecial(typeModuleBody.getDeclaredMethod(str, arrayOfType.length));
        localCodeAttr.emitReturn();
        localSwitchState.finish(localCodeAttr);
      }
    }
    this.method = localMethod;
    this.curClass = localClassType1;
  }
  
  public boolean generatingApplet()
  {
    return (0x10 & this.langOptions) != 0;
  }
  
  public boolean generatingServlet()
  {
    return (0x20 & this.langOptions) != 0;
  }
  
  public final boolean getBooleanOption(String paramString)
  {
    return this.currentOptions.getBoolean(paramString);
  }
  
  public final boolean getBooleanOption(String paramString, boolean paramBoolean)
  {
    return this.currentOptions.getBoolean(paramString, paramBoolean);
  }
  
  public final CodeAttr getCode()
  {
    return this.method.getCode();
  }
  
  public final int getColumnNumber()
  {
    return this.messages.getColumnNumber();
  }
  
  public final Method getConstructor(LambdaExp paramLambdaExp)
  {
    return getConstructor(paramLambdaExp.getHeapFrameType(), paramLambdaExp);
  }
  
  public final String getFileName()
  {
    return this.messages.getFileName();
  }
  
  public Method getForNameHelper()
  {
    if (this.forNameHelper == null)
    {
      Method localMethod = this.method;
      this.method = this.curClass.addMethod("class$", 9, string1Arg, typeClass);
      this.forNameHelper = this.method;
      CodeAttr localCodeAttr = this.method.startCode();
      localCodeAttr.emitLoad(localCodeAttr.getArg(0));
      localCodeAttr.emitPushInt(0);
      localCodeAttr.emitPushString(this.mainClass.getName());
      localCodeAttr.emitInvokeStatic(typeClass.getDeclaredMethod("forName", 1));
      localCodeAttr.emitInvokeVirtual(typeClass.getDeclaredMethod("getClassLoader", 0));
      localCodeAttr.emitInvokeStatic(typeClass.getDeclaredMethod("forName", 3));
      localCodeAttr.emitReturn();
      this.method = localMethod;
    }
    return this.forNameHelper;
  }
  
  public Language getLanguage()
  {
    return this.language;
  }
  
  public final int getLineNumber()
  {
    return this.messages.getLineNumber();
  }
  
  public SourceMessages getMessages()
  {
    return this.messages;
  }
  
  public final ModuleExp getModule()
  {
    return this.mainLambda;
  }
  
  public final ClassType getModuleType()
  {
    if (defaultCallConvention >= 2) {
      return typeModuleWithContext;
    }
    return typeModuleBody;
  }
  
  public String getPublicId()
  {
    return this.messages.getPublicId();
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public String getSystemId()
  {
    return this.messages.getSystemId();
  }
  
  public boolean inlineOk(Expression paramExpression)
  {
    if ((paramExpression instanceof LambdaExp))
    {
      LambdaExp localLambdaExp = (LambdaExp)paramExpression;
      Declaration localDeclaration = localLambdaExp.nameDecl;
      if ((localDeclaration == null) || (localDeclaration.getSymbol() == null) || (!(localDeclaration.context instanceof ModuleExp))) {
        return true;
      }
      if ((this.immediate) && (localDeclaration.isPublic()) && (!localLambdaExp.getFlag(2048)) && ((this.curLambda == null) || (localLambdaExp.topLevel() != this.curLambda.topLevel()))) {
        return false;
      }
    }
    return inlineOk;
  }
  
  public boolean inlineOk(Procedure paramProcedure)
  {
    if ((this.immediate) && ((paramProcedure instanceof ModuleMethod)) && ((((ModuleMethod)paramProcedure).module.getClass().getClassLoader() instanceof ArrayClassLoader))) {
      return false;
    }
    return inlineOk;
  }
  
  public boolean isPedantic()
  {
    return this.pedantic;
  }
  
  public boolean isStableSourceLocation()
  {
    return false;
  }
  
  public boolean isStatic()
  {
    return this.mainLambda.isStatic();
  }
  
  public LetExp letDone(Expression paramExpression)
  {
    LetExp localLetExp = (LetExp)this.current_scope;
    localLetExp.body = paramExpression;
    pop(localLetExp);
    return localLetExp;
  }
  
  public void letEnter()
  {
    LetExp localLetExp = (LetExp)this.current_scope;
    Expression[] arrayOfExpression = new Expression[localLetExp.countDecls()];
    Declaration localDeclaration = localLetExp.firstDecl();
    int j;
    for (int i = 0; localDeclaration != null; i = j)
    {
      j = i + 1;
      arrayOfExpression[i] = localDeclaration.getValue();
      localDeclaration = localDeclaration.nextDecl();
    }
    localLetExp.inits = arrayOfExpression;
    this.lexical.push(localLetExp);
  }
  
  public void letStart()
  {
    pushScope(new LetExp(null));
  }
  
  public Declaration letVariable(Object paramObject, Type paramType, Expression paramExpression)
  {
    Declaration localDeclaration = ((LetExp)this.current_scope).addDeclaration(paramObject, paramType);
    localDeclaration.noteValue(paramExpression);
    return localDeclaration;
  }
  
  public final void loadCallContext()
  {
    CodeAttr localCodeAttr = getCode();
    if ((this.callContextVar != null) && (!this.callContextVar.dead()))
    {
      localCodeAttr.emitLoad(this.callContextVar);
      return;
    }
    if (this.method == this.clinitMethod)
    {
      this.callContextVar = new Variable("$ctx", typeCallContext);
      this.callContextVar.reserveLocal(localCodeAttr.getMaxLocals(), localCodeAttr);
      localCodeAttr.emitLoad(this.callContextVar);
      this.callContextVarForInit = this.callContextVar;
      return;
    }
    localCodeAttr.emitInvokeStatic(getCallContextInstanceMethod);
    localCodeAttr.emitDup();
    this.callContextVar = new Variable("$ctx", typeCallContext);
    localCodeAttr.getCurrentScope().addVariable(localCodeAttr, this.callContextVar);
    localCodeAttr.emitStore(this.callContextVar);
  }
  
  public void loadClassRef(ObjectType paramObjectType)
  {
    CodeAttr localCodeAttr = getCode();
    if (this.curClass.getClassfileVersion() >= 3211264)
    {
      localCodeAttr.emitPushClass(paramObjectType);
      return;
    }
    if ((paramObjectType == this.mainClass) && (this.mainLambda.isStatic()) && (this.moduleInstanceMainField != null))
    {
      localCodeAttr.emitGetStatic(this.moduleInstanceMainField);
      localCodeAttr.emitInvokeVirtual(Type.objectType.getDeclaredMethod("getClass", 0));
      return;
    }
    if ((paramObjectType instanceof ClassType)) {}
    for (String str = paramObjectType.getName();; str = paramObjectType.getInternalName().replace('/', '.'))
    {
      localCodeAttr.emitPushString(str);
      localCodeAttr.emitInvokeStatic(getForNameHelper());
      return;
    }
  }
  
  public Declaration lookup(Object paramObject, int paramInt)
  {
    return this.lexical.lookup(paramObject, paramInt);
  }
  
  public void loopBody(Expression paramExpression)
  {
    ((LambdaExp)this.current_scope).body = paramExpression;
  }
  
  public void loopCond(Expression paramExpression)
  {
    checkLoop();
    this.exprStack.push(paramExpression);
  }
  
  public void loopEnter()
  {
    checkLoop();
    LambdaExp localLambdaExp = (LambdaExp)this.current_scope;
    int i = localLambdaExp.min_args;
    localLambdaExp.max_args = i;
    Expression[] arrayOfExpression = new Expression[i];
    int j = i;
    for (;;)
    {
      j--;
      if (j < 0) {
        break;
      }
      arrayOfExpression[j] = ((Expression)this.exprStack.pop());
    }
    LetExp localLetExp = (LetExp)localLambdaExp.outer;
    localLetExp.setBody(new ApplyExp(new ReferenceExp(localLetExp.firstDecl()), arrayOfExpression));
    this.lexical.push(localLambdaExp);
  }
  
  public Expression loopRepeat()
  {
    return loopRepeat(Expression.noExpressions);
  }
  
  public Expression loopRepeat(Expression paramExpression)
  {
    return loopRepeat(new Expression[] { paramExpression });
  }
  
  public Expression loopRepeat(Expression[] paramArrayOfExpression)
  {
    LambdaExp localLambdaExp = (LambdaExp)this.current_scope;
    ScopeExp localScopeExp = localLambdaExp.outer;
    Declaration localDeclaration = localScopeExp.firstDecl();
    Expression localExpression = (Expression)this.exprStack.pop();
    ApplyExp localApplyExp = new ApplyExp(new ReferenceExp(localDeclaration), paramArrayOfExpression);
    localLambdaExp.body = new IfExp(localExpression, new BeginExp(localLambdaExp.body, localApplyExp), QuoteExp.voidExp);
    this.lexical.pop(localLambdaExp);
    this.current_scope = localScopeExp.outer;
    return localScopeExp;
  }
  
  public void loopStart()
  {
    LambdaExp localLambdaExp = new LambdaExp();
    LetExp localLetExp = new LetExp(new Expression[] { localLambdaExp });
    localLetExp.addDeclaration("%do%loop").noteValue(localLambdaExp);
    localLambdaExp.setName("%do%loop");
    localLetExp.outer = this.current_scope;
    localLambdaExp.outer = localLetExp;
    this.current_scope = localLambdaExp;
  }
  
  public Declaration loopVariable(Object paramObject, Type paramType, Expression paramExpression)
  {
    checkLoop();
    LambdaExp localLambdaExp = (LambdaExp)this.current_scope;
    Declaration localDeclaration = localLambdaExp.addDeclaration(paramObject, paramType);
    if (this.exprStack == null) {
      this.exprStack = new Stack();
    }
    this.exprStack.push(paramExpression);
    localLambdaExp.min_args = (1 + localLambdaExp.min_args);
    return localDeclaration;
  }
  
  public boolean makeRunnable()
  {
    return (!generatingServlet()) && (!generatingApplet()) && (!getModule().staticInitRun());
  }
  
  public void mustCompileHere()
  {
    if ((!this.mustCompile) && (!ModuleExp.compilerAvailable))
    {
      error('w', "this expression claimed that it must be compiled, but compiler is unavailable");
      return;
    }
    this.mustCompile = true;
  }
  
  public void outputClass(String paramString)
    throws IOException
  {
    char c = File.separatorChar;
    for (int i = 0; i < this.numClasses; i++)
    {
      ClassType localClassType = this.classes[i];
      String str1 = paramString + localClassType.getName().replace('.', c) + ".class";
      String str2 = new File(str1).getParent();
      if (str2 != null) {
        new File(str2).mkdirs();
      }
      localClassType.writeToFile(str1);
    }
    this.minfo.cleanupAfterCompilation();
  }
  
  public Expression parse(Object paramObject)
  {
    throw new Error("unimeplemented parse");
  }
  
  public final void pop()
  {
    pop(this.current_scope);
  }
  
  public void pop(ScopeExp paramScopeExp)
  {
    this.lexical.pop(paramScopeExp);
    this.current_scope = paramScopeExp.outer;
  }
  
  /* Error */
  public void process(int paramInt)
  {
    // Byte code:
    //   0: bipush 10
    //   2: istore_2
    //   3: bipush 8
    //   5: istore_3
    //   6: bipush 6
    //   8: istore 4
    //   10: bipush 100
    //   12: istore 5
    //   14: aload_0
    //   15: invokestatic 2169	gnu/expr/Compilation:setSaveCurrent	(Lgnu/expr/Compilation;)Lgnu/expr/Compilation;
    //   18: astore 6
    //   20: aload_0
    //   21: invokevirtual 1611	gnu/expr/Compilation:getModule	()Lgnu/expr/ModuleExp;
    //   24: astore 10
    //   26: iload_1
    //   27: iconst_4
    //   28: if_icmplt +81 -> 109
    //   31: aload_0
    //   32: invokevirtual 2171	gnu/expr/Compilation:getState	()I
    //   35: iconst_3
    //   36: if_icmpge +73 -> 109
    //   39: aload_0
    //   40: iconst_3
    //   41: invokevirtual 2174	gnu/expr/Compilation:setState	(I)V
    //   44: aload_0
    //   45: getfield 564	gnu/expr/Compilation:language	Lgnu/expr/Language;
    //   48: aload_0
    //   49: iconst_0
    //   50: invokevirtual 2177	gnu/expr/Language:parse	(Lgnu/expr/Compilation;I)Z
    //   53: pop
    //   54: aload_0
    //   55: getfield 2179	gnu/expr/Compilation:lexer	Lgnu/text/Lexer;
    //   58: invokevirtual 2182	gnu/text/Lexer:close	()V
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 2179	gnu/expr/Compilation:lexer	Lgnu/text/Lexer;
    //   66: aload_0
    //   67: getfield 566	gnu/expr/Compilation:messages	Lgnu/text/SourceMessages;
    //   70: invokevirtual 2185	gnu/text/SourceMessages:seenErrors	()Z
    //   73: ifeq +30 -> 103
    //   76: iload 5
    //   78: istore 12
    //   80: aload_0
    //   81: iload 12
    //   83: invokevirtual 2174	gnu/expr/Compilation:setState	(I)V
    //   86: aload_0
    //   87: getfield 2187	gnu/expr/Compilation:pendingImports	Ljava/util/Stack;
    //   90: astore 13
    //   92: aload 13
    //   94: ifnull +15 -> 109
    //   97: aload 6
    //   99: invokestatic 2189	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   102: return
    //   103: iconst_4
    //   104: istore 12
    //   106: goto -26 -> 80
    //   109: iload_1
    //   110: iload 4
    //   112: if_icmplt +46 -> 158
    //   115: aload_0
    //   116: invokevirtual 2171	gnu/expr/Compilation:getState	()I
    //   119: iload 4
    //   121: if_icmpge +37 -> 158
    //   124: aload_0
    //   125: aload 10
    //   127: invokevirtual 2191	gnu/expr/Compilation:addMainClass	(Lgnu/expr/ModuleExp;)V
    //   130: aload_0
    //   131: getfield 564	gnu/expr/Compilation:language	Lgnu/expr/Language;
    //   134: aload_0
    //   135: invokevirtual 2194	gnu/expr/Language:resolve	(Lgnu/expr/Compilation;)V
    //   138: aload_0
    //   139: getfield 566	gnu/expr/Compilation:messages	Lgnu/text/SourceMessages;
    //   142: invokevirtual 2185	gnu/text/SourceMessages:seenErrors	()Z
    //   145: ifeq +7 -> 152
    //   148: iload 5
    //   150: istore 4
    //   152: aload_0
    //   153: iload 4
    //   155: invokevirtual 2174	gnu/expr/Compilation:setState	(I)V
    //   158: aload_0
    //   159: getfield 2196	gnu/expr/Compilation:explicit	Z
    //   162: ifne +39 -> 201
    //   165: aload_0
    //   166: getfield 1206	gnu/expr/Compilation:immediate	Z
    //   169: ifne +32 -> 201
    //   172: aload_0
    //   173: getfield 1192	gnu/expr/Compilation:minfo	Lgnu/expr/ModuleInfo;
    //   176: invokestatic 1823	gnu/expr/ModuleManager:getInstance	()Lgnu/expr/ModuleManager;
    //   179: invokestatic 2199	java/lang/System:currentTimeMillis	()J
    //   182: invokevirtual 2203	gnu/expr/ModuleInfo:checkCurrent	(Lgnu/expr/ModuleManager;J)Z
    //   185: ifeq +16 -> 201
    //   188: aload_0
    //   189: getfield 1192	gnu/expr/Compilation:minfo	Lgnu/expr/ModuleInfo;
    //   192: invokevirtual 2161	gnu/expr/ModuleInfo:cleanupAfterCompilation	()V
    //   195: aload_0
    //   196: bipush 14
    //   198: invokevirtual 2174	gnu/expr/Compilation:setState	(I)V
    //   201: iload_1
    //   202: iload_3
    //   203: if_icmplt +35 -> 238
    //   206: aload_0
    //   207: invokevirtual 2171	gnu/expr/Compilation:getState	()I
    //   210: iload_3
    //   211: if_icmpge +27 -> 238
    //   214: aload_0
    //   215: aload 10
    //   217: invokevirtual 2206	gnu/expr/Compilation:walkModule	(Lgnu/expr/ModuleExp;)V
    //   220: aload_0
    //   221: getfield 566	gnu/expr/Compilation:messages	Lgnu/text/SourceMessages;
    //   224: invokevirtual 2185	gnu/text/SourceMessages:seenErrors	()Z
    //   227: ifeq +6 -> 233
    //   230: iload 5
    //   232: istore_3
    //   233: aload_0
    //   234: iload_3
    //   235: invokevirtual 2174	gnu/expr/Compilation:setState	(I)V
    //   238: iload_1
    //   239: iload_2
    //   240: if_icmplt +65 -> 305
    //   243: aload_0
    //   244: invokevirtual 2171	gnu/expr/Compilation:getState	()I
    //   247: iload_2
    //   248: if_icmpge +57 -> 305
    //   251: aload_0
    //   252: new 907	gnu/expr/LitTable
    //   255: dup
    //   256: aload_0
    //   257: invokespecial 2208	gnu/expr/LitTable:<init>	(Lgnu/expr/Compilation;)V
    //   260: putfield 905	gnu/expr/Compilation:litTable	Lgnu/expr/LitTable;
    //   263: aload 10
    //   265: iconst_1
    //   266: invokevirtual 2211	gnu/expr/ModuleExp:setCanRead	(Z)V
    //   269: aload 10
    //   271: aload_0
    //   272: invokestatic 2217	gnu/expr/FindCapturedVars:findCapturedVars	(Lgnu/expr/Expression;Lgnu/expr/Compilation;)V
    //   275: aload 10
    //   277: aload_0
    //   278: invokevirtual 2220	gnu/expr/ModuleExp:allocFields	(Lgnu/expr/Compilation;)V
    //   281: aload 10
    //   283: aload_0
    //   284: invokevirtual 2223	gnu/expr/ModuleExp:allocChildMethods	(Lgnu/expr/Compilation;)V
    //   287: aload_0
    //   288: getfield 566	gnu/expr/Compilation:messages	Lgnu/text/SourceMessages;
    //   291: invokevirtual 2185	gnu/text/SourceMessages:seenErrors	()Z
    //   294: ifeq +6 -> 300
    //   297: iload 5
    //   299: istore_2
    //   300: aload_0
    //   301: iload_2
    //   302: invokevirtual 2174	gnu/expr/Compilation:setState	(I)V
    //   305: iload_1
    //   306: bipush 12
    //   308: if_icmplt +53 -> 361
    //   311: aload_0
    //   312: invokevirtual 2171	gnu/expr/Compilation:getState	()I
    //   315: bipush 12
    //   317: if_icmpge +44 -> 361
    //   320: aload_0
    //   321: getfield 1206	gnu/expr/Compilation:immediate	Z
    //   324: ifeq +17 -> 341
    //   327: aload_0
    //   328: new 899	gnu/bytecode/ArrayClassLoader
    //   331: dup
    //   332: invokestatic 2226	gnu/bytecode/ObjectType:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   335: invokespecial 2229	gnu/bytecode/ArrayClassLoader:<init>	(Ljava/lang/ClassLoader;)V
    //   338: putfield 896	gnu/expr/Compilation:loader	Lgnu/bytecode/ArrayClassLoader;
    //   341: aload_0
    //   342: invokevirtual 2231	gnu/expr/Compilation:generateBytecode	()V
    //   345: aload_0
    //   346: getfield 566	gnu/expr/Compilation:messages	Lgnu/text/SourceMessages;
    //   349: invokevirtual 2185	gnu/text/SourceMessages:seenErrors	()Z
    //   352: ifeq +46 -> 398
    //   355: aload_0
    //   356: iload 5
    //   358: invokevirtual 2174	gnu/expr/Compilation:setState	(I)V
    //   361: iload_1
    //   362: bipush 14
    //   364: if_icmplt +28 -> 392
    //   367: aload_0
    //   368: invokevirtual 2171	gnu/expr/Compilation:getState	()I
    //   371: bipush 14
    //   373: if_icmpge +19 -> 392
    //   376: aload_0
    //   377: invokestatic 1823	gnu/expr/ModuleManager:getInstance	()Lgnu/expr/ModuleManager;
    //   380: invokevirtual 1862	gnu/expr/ModuleManager:getCompilationDirectory	()Ljava/lang/String;
    //   383: invokevirtual 2233	gnu/expr/Compilation:outputClass	(Ljava/lang/String;)V
    //   386: aload_0
    //   387: bipush 14
    //   389: invokevirtual 2174	gnu/expr/Compilation:setState	(I)V
    //   392: aload 6
    //   394: invokestatic 2189	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   397: return
    //   398: bipush 12
    //   400: istore 5
    //   402: goto -47 -> 355
    //   405: astore 9
    //   407: aload_0
    //   408: bipush 100
    //   410: invokevirtual 2174	gnu/expr/Compilation:setState	(I)V
    //   413: aload 9
    //   415: invokevirtual 2235	gnu/text/SyntaxException:getMessages	()Lgnu/text/SourceMessages;
    //   418: aload_0
    //   419: invokevirtual 2236	gnu/expr/Compilation:getMessages	()Lgnu/text/SourceMessages;
    //   422: if_acmpeq +42 -> 464
    //   425: new 1564	java/lang/RuntimeException
    //   428: dup
    //   429: new 1139	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 1140	java/lang/StringBuilder:<init>	()V
    //   436: ldc_w 2238
    //   439: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload 9
    //   444: invokevirtual 1569	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 1151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokespecial 1570	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   453: athrow
    //   454: astore 8
    //   456: aload 6
    //   458: invokestatic 2189	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   461: aload 8
    //   463: athrow
    //   464: aload 6
    //   466: invokestatic 2189	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   469: return
    //   470: astore 7
    //   472: aload 7
    //   474: invokevirtual 2241	java/io/IOException:printStackTrace	()V
    //   477: aload_0
    //   478: bipush 102
    //   480: new 1139	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 1140	java/lang/StringBuilder:<init>	()V
    //   487: ldc_w 2243
    //   490: invokevirtual 1145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: aload 7
    //   495: invokevirtual 1569	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 1151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokevirtual 1329	gnu/expr/Compilation:error	(CLjava/lang/String;)V
    //   504: aload_0
    //   505: bipush 100
    //   507: invokevirtual 2174	gnu/expr/Compilation:setState	(I)V
    //   510: aload 6
    //   512: invokestatic 2189	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   515: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	516	0	this	Compilation
    //   0	516	1	paramInt	int
    //   2	300	2	i	int
    //   5	230	3	j	int
    //   8	146	4	k	int
    //   12	389	5	m	int
    //   18	493	6	localCompilation	Compilation
    //   470	24	7	localIOException	IOException
    //   454	8	8	localObject	Object
    //   405	38	9	localSyntaxException	gnu.text.SyntaxException
    //   24	258	10	localModuleExp	ModuleExp
    //   78	27	12	n	int
    //   90	3	13	localStack	Stack
    // Exception table:
    //   from	to	target	type
    //   20	26	405	gnu/text/SyntaxException
    //   31	76	405	gnu/text/SyntaxException
    //   80	92	405	gnu/text/SyntaxException
    //   115	148	405	gnu/text/SyntaxException
    //   152	158	405	gnu/text/SyntaxException
    //   158	201	405	gnu/text/SyntaxException
    //   206	230	405	gnu/text/SyntaxException
    //   233	238	405	gnu/text/SyntaxException
    //   243	297	405	gnu/text/SyntaxException
    //   300	305	405	gnu/text/SyntaxException
    //   311	341	405	gnu/text/SyntaxException
    //   341	355	405	gnu/text/SyntaxException
    //   355	361	405	gnu/text/SyntaxException
    //   367	392	405	gnu/text/SyntaxException
    //   20	26	454	finally
    //   31	76	454	finally
    //   80	92	454	finally
    //   115	148	454	finally
    //   152	158	454	finally
    //   158	201	454	finally
    //   206	230	454	finally
    //   233	238	454	finally
    //   243	297	454	finally
    //   300	305	454	finally
    //   311	341	454	finally
    //   341	355	454	finally
    //   355	361	454	finally
    //   367	392	454	finally
    //   407	454	454	finally
    //   472	510	454	finally
    //   20	26	470	java/io/IOException
    //   31	76	470	java/io/IOException
    //   80	92	470	java/io/IOException
    //   115	148	470	java/io/IOException
    //   152	158	470	java/io/IOException
    //   158	201	470	java/io/IOException
    //   206	230	470	java/io/IOException
    //   233	238	470	java/io/IOException
    //   243	297	470	java/io/IOException
    //   300	305	470	java/io/IOException
    //   311	341	470	java/io/IOException
    //   341	355	470	java/io/IOException
    //   355	361	470	java/io/IOException
    //   367	392	470	java/io/IOException
  }
  
  public void push(Declaration paramDeclaration)
  {
    this.lexical.push(paramDeclaration);
  }
  
  public void push(ScopeExp paramScopeExp)
  {
    pushScope(paramScopeExp);
    this.lexical.push(paramScopeExp);
  }
  
  void pushChain(ScopeExp paramScopeExp1, ScopeExp paramScopeExp2)
  {
    if (paramScopeExp1 != paramScopeExp2)
    {
      pushChain(paramScopeExp1.outer, paramScopeExp2);
      pushScope(paramScopeExp1);
      this.lexical.push(paramScopeExp1);
    }
  }
  
  public ModuleExp pushNewModule(Lexer paramLexer)
  {
    this.lexer = paramLexer;
    return pushNewModule(paramLexer.getName());
  }
  
  public ModuleExp pushNewModule(String paramString)
  {
    ModuleExp localModuleExp = new ModuleExp();
    if (paramString != null) {
      localModuleExp.setFile(paramString);
    }
    if ((generatingApplet()) || (generatingServlet())) {
      localModuleExp.setFlag(131072);
    }
    if (this.immediate)
    {
      localModuleExp.setFlag(1048576);
      new ModuleInfo().setCompilation(this);
    }
    this.mainLambda = localModuleExp;
    push(localModuleExp);
    return localModuleExp;
  }
  
  public void pushPendingImport(ModuleInfo paramModuleInfo, ScopeExp paramScopeExp, int paramInt)
  {
    if (this.pendingImports == null) {
      this.pendingImports = new Stack();
    }
    this.pendingImports.push(paramModuleInfo);
    this.pendingImports.push(paramScopeExp);
    ReferenceExp localReferenceExp = new ReferenceExp((Object)null);
    localReferenceExp.setLine(this);
    this.pendingImports.push(localReferenceExp);
    this.pendingImports.push(Integer.valueOf(paramInt));
  }
  
  public final void pushScope(ScopeExp paramScopeExp)
  {
    if ((!this.mustCompile) && ((paramScopeExp.mustCompile()) || ((ModuleExp.compilerAvailable) && ((paramScopeExp instanceof LambdaExp)) && (!(paramScopeExp instanceof ModuleExp))))) {
      mustCompileHere();
    }
    paramScopeExp.outer = this.current_scope;
    this.current_scope = paramScopeExp;
  }
  
  public Object resolve(Object paramObject, boolean paramBoolean)
  {
    Environment localEnvironment = Environment.getCurrent();
    if ((paramObject instanceof String)) {}
    for (Symbol localSymbol = localEnvironment.defaultNamespace().lookup((String)paramObject); localSymbol == null; localSymbol = (Symbol)paramObject) {
      return null;
    }
    if ((paramBoolean) && (getLanguage().hasSeparateFunctionNamespace())) {
      return localEnvironment.getFunction(localSymbol, null);
    }
    return localEnvironment.get(localSymbol, null);
  }
  
  public void setColumn(int paramInt)
  {
    this.messages.setColumn(paramInt);
  }
  
  public void setCurrentScope(ScopeExp paramScopeExp)
  {
    int i = ScopeExp.nesting(paramScopeExp);
    for (int j = ScopeExp.nesting(this.current_scope); j > i; j--) {
      pop(this.current_scope);
    }
    ScopeExp localScopeExp = paramScopeExp;
    while (i > j)
    {
      localScopeExp = localScopeExp.outer;
      i--;
    }
    while (localScopeExp != this.current_scope)
    {
      pop(this.current_scope);
      localScopeExp = localScopeExp.outer;
    }
    pushChain(paramScopeExp, localScopeExp);
  }
  
  public void setFile(String paramString)
  {
    this.messages.setFile(paramString);
  }
  
  public void setLine(int paramInt)
  {
    this.messages.setLine(paramInt);
  }
  
  public final void setLine(Expression paramExpression)
  {
    this.messages.setLocation(paramExpression);
  }
  
  public void setLine(Object paramObject)
  {
    if ((paramObject instanceof SourceLocator)) {
      this.messages.setLocation((SourceLocator)paramObject);
    }
  }
  
  public void setLine(String paramString, int paramInt1, int paramInt2)
  {
    this.messages.setLine(paramString, paramInt1, paramInt2);
  }
  
  public final void setLocation(SourceLocator paramSourceLocator)
  {
    this.messages.setLocation(paramSourceLocator);
  }
  
  public void setMessages(SourceMessages paramSourceMessages)
  {
    this.messages = paramSourceMessages;
  }
  
  public void setModule(ModuleExp paramModuleExp)
  {
    this.mainLambda = paramModuleExp;
  }
  
  public void setSharedModuleDefs(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.langOptions = (0x2 | this.langOptions);
      return;
    }
    this.langOptions = (0xFFFFFFFD & this.langOptions);
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
  
  public boolean sharedModuleDefs()
  {
    return (0x2 & this.langOptions) != 0;
  }
  
  public Expression syntaxError(String paramString)
  {
    error('e', paramString);
    return new ErrorExp(paramString);
  }
  
  public String toString()
  {
    return "<compilation " + this.mainLambda + ">";
  }
  
  public void usedClass(Type paramType)
  {
    while ((paramType instanceof ArrayType)) {
      paramType = ((ArrayType)paramType).getComponentType();
    }
    if ((this.immediate) && ((paramType instanceof ClassType))) {
      this.loader.addClass((ClassType)paramType);
    }
  }
  
  public boolean usingCPStyle()
  {
    return defaultCallConvention == 4;
  }
  
  public boolean usingTailCalls()
  {
    return defaultCallConvention >= 3;
  }
  
  public void walkModule(ModuleExp paramModuleExp)
  {
    if (debugPrintExpr)
    {
      OutPort localOutPort = OutPort.errDefault();
      localOutPort.println("[Module:" + paramModuleExp.getName());
      paramModuleExp.print(localOutPort);
      localOutPort.println(']');
      localOutPort.flush();
    }
    InlineCalls.inlineCalls(paramModuleExp, this);
    PushApply.pushApply(paramModuleExp);
    ChainLambdas.chainLambdas(paramModuleExp, this);
    FindTailCalls.findTailCalls(paramModuleExp, this);
  }
  
  public boolean warnAsError()
  {
    return this.currentOptions.getBoolean(warnAsError);
  }
  
  public boolean warnInvokeUnknownMethod()
  {
    return this.currentOptions.getBoolean(warnInvokeUnknownMethod);
  }
  
  public boolean warnUndefinedVariable()
  {
    return this.currentOptions.getBoolean(warnUndefinedVariable);
  }
  
  public boolean warnUnknownMember()
  {
    return this.currentOptions.getBoolean(warnUnknownMember);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.Compilation
 * JD-Core Version:    0.7.0.1
 */