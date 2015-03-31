package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.InPort;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.text.Path;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class require
  extends Syntax
{
  private static final String SLIB_PREFIX = "gnu.kawa.slib.";
  static Hashtable featureMap;
  public static final require require = new require();
  
  static
  {
    require.setName("require");
    featureMap = new Hashtable();
    map("generic-write", "gnu.kawa.slib.genwrite");
    map("pretty-print", "gnu.kawa.slib.pp");
    map("pprint-file", "gnu.kawa.slib.ppfile");
    map("printf", "gnu.kawa.slib.printf");
    map("xml", "gnu.kawa.slib.XML");
    map("readtable", "gnu.kawa.slib.readtable");
    map("srfi-10", "gnu.kawa.slib.readtable");
    map("http", "gnu.kawa.servlet.HTTP");
    map("servlets", "gnu.kawa.servlet.servlets");
    map("srfi-1", "gnu.kawa.slib.srfi1");
    map("list-lib", "gnu.kawa.slib.srfi1");
    map("srfi-2", "gnu.kawa.slib.srfi2");
    map("and-let*", "gnu.kawa.slib.srfi2");
    map("srfi-13", "gnu.kawa.slib.srfi13");
    map("string-lib", "gnu.kawa.slib.srfi13");
    map("srfi-34", "gnu.kawa.slib.srfi34");
    map("srfi-35", "gnu.kawa.slib.conditions");
    map("condition", "gnu.kawa.slib.conditions");
    map("conditions", "gnu.kawa.slib.conditions");
    map("srfi-37", "gnu.kawa.slib.srfi37");
    map("args-fold", "gnu.kawa.slib.srfi37");
    map("srfi-64", "gnu.kawa.slib.testing");
    map("testing", "gnu.kawa.slib.testing");
    map("srfi-69", "gnu.kawa.slib.srfi69");
    map("hash-table", "gnu.kawa.slib.srfi69");
    map("basic-hash-tables", "gnu.kawa.slib.srfi69");
    map("srfi-95", "kawa.lib.srfi95");
    map("sorting-and-merging", "kawa.lib.srfi95");
    map("regex", "kawa.lib.kawa.regex");
    map("pregexp", "gnu.kawa.slib.pregexp");
    map("gui", "gnu.kawa.slib.gui");
    map("swing-gui", "gnu.kawa.slib.swing");
    map("android-defs", "gnu.kawa.android.defs");
    map("syntax-utils", "gnu.kawa.slib.syntaxutils");
  }
  
  public static Object find(String paramString)
  {
    return ModuleManager.getInstance().findWithClassName(paramString).getInstance();
  }
  
  public static boolean importDefinitions(String paramString, ModuleInfo paramModuleInfo, Procedure paramProcedure, Vector paramVector, ScopeExp paramScopeExp, Compilation paramCompilation)
  {
    ModuleManager localModuleManager = ModuleManager.getInstance();
    SourceMessages localSourceMessages;
    Language localLanguage2;
    if (((0x1 & paramModuleInfo.getState()) == 0) && (paramModuleInfo.getCompilation() == null) && (!paramModuleInfo.checkCurrent(localModuleManager, System.currentTimeMillis())))
    {
      localSourceMessages = paramCompilation.getMessages();
      localLanguage2 = Language.getDefaultLanguage();
    }
    try
    {
      InPort localInPort = InPort.openFile(paramModuleInfo.getSourceAbsPath());
      paramModuleInfo.clearClass();
      paramModuleInfo.setClassName(paramString);
      int n = 8;
      if (paramCompilation.immediate) {
        n |= 0x1;
      }
      Compilation localCompilation = localLanguage2.parse(localInPort, localSourceMessages, n, paramModuleInfo);
      paramModuleInfo.setClassName(localCompilation.getModule().classFor(localCompilation).getName());
      if ((paramCompilation.minfo != null) && (paramCompilation.getState() < 4))
      {
        paramCompilation.minfo.addDependency(paramModuleInfo);
        if ((!paramModuleInfo.loadEager(12)) && (paramModuleInfo.getState() < 6))
        {
          paramCompilation.pushPendingImport(paramModuleInfo, paramScopeExp, paramVector.size());
          return true;
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      paramCompilation.error('e', "not found: " + localFileNotFoundException.getMessage());
      return false;
    }
    catch (IOException localIOException)
    {
      paramCompilation.error('e', "caught " + localIOException);
      return false;
    }
    catch (SyntaxException localSyntaxException)
    {
      if (localSyntaxException.getMessages() != localSourceMessages) {
        throw new RuntimeException("confussing syntax error: " + localSyntaxException);
      }
      return false;
    }
    ClassType localClassType1 = paramModuleInfo.getClassType();
    String str = localClassType1.getName();
    boolean bool1 = paramCompilation.sharedModuleDefs();
    boolean bool2;
    Declaration localDeclaration1;
    Object localObject1;
    Field localField;
    Language localLanguage1;
    int i;
    Vector localVector;
    Declaration localDeclaration2;
    if (paramModuleInfo.getState() < 6)
    {
      bool2 = paramModuleInfo.getCompilation().makeRunnable();
      localDeclaration1 = null;
      ClassType localClassType2 = ClassType.make("kawa.standard.require");
      Expression[] arrayOfExpression1 = new Expression[1];
      QuoteExp localQuoteExp1 = new QuoteExp(str);
      arrayOfExpression1[0] = localQuoteExp1;
      localObject1 = Invoke.makeInvokeStatic(localClassType2, "find", arrayOfExpression1);
      localField = null;
      localLanguage1 = paramCompilation.getLanguage();
      ((Expression)localObject1).setLine(paramCompilation);
      i = paramVector.size();
      ModuleExp localModuleExp = paramModuleInfo.setupModuleExp();
      localVector = new Vector();
      localDeclaration2 = localModuleExp.firstDecl();
      label409:
      if (localDeclaration2 == null) {
        break label1117;
      }
      if (!localDeclaration2.isPrivate()) {
        break label445;
      }
    }
    label445:
    Symbol localSymbol;
    boolean bool3;
    label727:
    int m;
    label755:
    Declaration localDeclaration7;
    do
    {
      for (;;)
      {
        localDeclaration2 = localDeclaration2.nextDecl();
        break label409;
        bool2 = localClassType1.isSubtype(Compilation.typeRunnable);
        break;
        localSymbol = (Symbol)localDeclaration2.getSymbol();
        if (paramProcedure != null)
        {
          try
          {
            Object localObject3 = paramProcedure.apply1(localSymbol);
            localObject2 = localObject3;
          }
          catch (Throwable localThrowable)
          {
            Object localObject2;
            for (;;)
            {
              localObject2 = localThrowable;
            }
            localSymbol = (Symbol)localObject2;
          }
          if (localObject2 == null) {
            continue;
          }
          if (!(localObject2 instanceof Symbol))
          {
            paramCompilation.error('e', "internal error - import name mapper returned non-symbol: " + localObject2.getClass().getName());
            continue;
          }
        }
        bool3 = localDeclaration2.getFlag(2048L);
        if ((!bool3) && (localDeclaration1 == null))
        {
          localDeclaration1 = new Declaration(SimpleSymbol.valueOf(str.replace('.', '$') + "$instance"), localClassType1);
          localDeclaration1.setPrivate(true);
          localDeclaration1.setFlag(1073758208L);
          paramScopeExp.addDeclaration(localDeclaration1);
          localDeclaration1.noteValue((Expression)localObject1);
          SetExp localSetExp2 = new SetExp(localDeclaration1, (Expression)localObject1);
          localSetExp2.setLine(paramCompilation);
          localSetExp2.setDefining(true);
          paramVector.addElement(localSetExp2);
          i = paramVector.size();
          localDeclaration1.setFlag(536870912L);
          if (bool2) {
            localDeclaration1.setSimple(false);
          }
          localDeclaration1.setFlag(8192L);
        }
        if ((localDeclaration2.field == null) || (!localDeclaration2.field.getName().equals("$instance"))) {
          break label727;
        }
        localField = localDeclaration2.field;
      }
      if ((localDeclaration2.field == null) || (!localDeclaration2.field.getName().endsWith("$instance"))) {
        break label1003;
      }
      m = 1;
      localDeclaration7 = paramScopeExp.lookup(localSymbol, localLanguage1, localLanguage1.getNamespaceOf(localDeclaration2));
      if (m == 0) {
        break label1009;
      }
    } while (localDeclaration7 != null);
    Declaration localDeclaration8 = paramScopeExp.addDeclaration(localSymbol);
    localDeclaration8.setFlag(1073758208L);
    localDeclaration8.setType(localDeclaration2.getType());
    localDeclaration8.setFlag(8192L);
    localDeclaration8.setLocation(paramCompilation);
    ReferenceExp localReferenceExp2 = new ReferenceExp(localDeclaration2);
    localReferenceExp2.setContextDecl(localDeclaration1);
    if (m == 0)
    {
      localReferenceExp2.setDontDereference(true);
      if (!bool1) {
        localDeclaration8.setPrivate(true);
      }
    }
    localDeclaration8.setFlag(16384L);
    if (localDeclaration2.getFlag(32768L)) {
      localDeclaration8.setFlag(32768L);
    }
    if (localDeclaration2.isProcedureDecl()) {
      localDeclaration8.setProcedureDecl(true);
    }
    if (bool3) {
      localDeclaration8.setFlag(2048L);
    }
    SetExp localSetExp1 = new SetExp(localDeclaration8, localReferenceExp2);
    localDeclaration8.setFlag(536870912L);
    localSetExp1.setDefining(true);
    if (m != 0)
    {
      paramVector.insertElementAt(localSetExp1, i);
      i++;
    }
    for (;;)
    {
      localVector.add(localDeclaration8);
      localVector.add(localDeclaration2);
      localDeclaration8.noteValue(localReferenceExp2);
      localDeclaration8.setFlag(131072L);
      paramCompilation.push(localDeclaration8);
      break;
      label1003:
      m = 0;
      break label755;
      label1009:
      if ((localDeclaration7 != null) && (!localDeclaration7.getFlag(512L)) && (Declaration.followAliases(localDeclaration7) == Declaration.followAliases(localDeclaration2))) {
        break;
      }
      if ((localDeclaration7 != null) && (localDeclaration7.getFlag(66048L)))
      {
        localDeclaration7.setFlag(false, 66048L);
        localDeclaration8 = localDeclaration7;
      }
      for (;;)
      {
        localDeclaration8.setAlias(true);
        localDeclaration8.setIndirectBinding(true);
        break;
        localDeclaration8 = paramScopeExp.addDeclaration(localSymbol);
        if (localDeclaration7 != null) {
          ScopeExp.duplicateDeclarationError(localDeclaration7, localDeclaration8, paramCompilation);
        }
      }
      paramVector.addElement(localSetExp1);
    }
    label1117:
    int j = localVector.size();
    for (int k = 0; k < j; k += 2)
    {
      Declaration localDeclaration3 = (Declaration)localVector.elementAt(k);
      Declaration localDeclaration4 = (Declaration)localVector.elementAt(k + 1);
      Expression localExpression = localDeclaration4.getValue();
      if ((localDeclaration4.isIndirectBinding()) && ((localExpression instanceof ReferenceExp)))
      {
        ReferenceExp localReferenceExp1 = (ReferenceExp)localDeclaration3.getValue();
        Declaration localDeclaration5 = ((ReferenceExp)localExpression).getBinding();
        localReferenceExp1.setBinding(localDeclaration5);
        if (localDeclaration5.needsContext())
        {
          Declaration localDeclaration6 = paramScopeExp.lookup(SimpleSymbol.valueOf(localDeclaration5.field.getDeclaringClass().getName().replace('.', '$') + "$instance"));
          localDeclaration6.setFlag(1024L);
          localReferenceExp1.setContextDecl(localDeclaration6);
        }
      }
    }
    Method localMethod;
    if (bool2)
    {
      localMethod = Compilation.typeRunnable.getDeclaredMethod("run", 0);
      if (localDeclaration1 == null) {
        break label1354;
      }
      localObject1 = new ReferenceExp(localDeclaration1);
    }
    for (;;)
    {
      ApplyExp localApplyExp = new ApplyExp(localMethod, new Expression[] { localObject1 });
      localApplyExp.setLine(paramCompilation);
      paramVector.addElement(localApplyExp);
      return true;
      label1354:
      if (localField != null)
      {
        Expression[] arrayOfExpression2 = new Expression[2];
        QuoteExp localQuoteExp2 = new QuoteExp(localClassType1);
        arrayOfExpression2[0] = localQuoteExp2;
        arrayOfExpression2[1] = new QuoteExp("$instance");
        localObject1 = new ApplyExp(SlotGet.staticField, arrayOfExpression2);
      }
    }
  }
  
  public static ModuleInfo lookupModuleFromSourcePath(String paramString, ScopeExp paramScopeExp)
  {
    ModuleManager localModuleManager = ModuleManager.getInstance();
    String str = paramScopeExp.getFileName();
    if (str != null) {
      paramString = Path.valueOf(str).resolve(paramString).toString();
    }
    return localModuleManager.findWithSourcePath(paramString);
  }
  
  static void map(String paramString1, String paramString2)
  {
    featureMap.put(paramString1, paramString2);
  }
  
  public static String mapFeature(String paramString)
  {
    return (String)featureMap.get(paramString);
  }
  
  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    return null;
  }
  
  public boolean scanForDefinitions(Pair paramPair, Vector paramVector, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    if (paramTranslator.getState() == 1)
    {
      paramTranslator.setState(2);
      paramTranslator.pendingForm = paramPair;
      return true;
    }
    Pair localPair1 = (Pair)paramPair.getCdr();
    Object localObject1 = localPair1.getCar();
    Object localObject2;
    if ((localObject1 instanceof Pair))
    {
      Pair localPair2 = (Pair)localObject1;
      if (paramTranslator.matches(localPair2.getCar(), "quote"))
      {
        Object localObject4 = localPair2.getCdr();
        Pair localPair3;
        if ((localObject4 instanceof Pair))
        {
          localPair3 = (Pair)localObject4;
          if ((localPair3.getCdr() == LList.Empty) && ((localPair3.getCar() instanceof Symbol))) {}
        }
        else
        {
          paramTranslator.error('e', "invalid quoted symbol for 'require'");
          return false;
        }
        String str3 = mapFeature(localPair3.getCar().toString());
        if (str3 == null)
        {
          paramTranslator.error('e', "unknown feature name '" + localPair3.getCar() + "' for 'require'");
          return false;
        }
        localObject2 = ClassType.make((String)str3);
      }
    }
    while (!(localObject2 instanceof ClassType))
    {
      paramTranslator.error('e', "invalid specifier for 'require'");
      return false;
      if ((localObject1 instanceof CharSequence))
      {
        String str2 = localObject1.toString();
        ModuleInfo localModuleInfo3 = lookupModuleFromSourcePath(str2, paramScopeExp);
        if (localModuleInfo3 == null)
        {
          paramTranslator.error('e', "malformed URL: " + str2);
          return false;
        }
        return importDefinitions(null, localModuleInfo3, null, paramVector, paramScopeExp, paramTranslator);
      }
      boolean bool1 = localObject1 instanceof Symbol;
      localObject2 = null;
      if (bool1)
      {
        boolean bool2 = paramTranslator.selfEvaluatingSymbol(localObject1);
        localObject2 = null;
        if (!bool2)
        {
          localObject2 = paramTranslator.getLanguage().getTypeFor(paramTranslator.rewrite(localObject1, false));
          if (((localObject2 instanceof ClassType)) && ((localPair1.getCdr() instanceof Pair)))
          {
            Object localObject3 = ((Pair)localPair1.getCdr()).getCar();
            if ((localObject3 instanceof CharSequence))
            {
              String str1 = localObject3.toString();
              ModuleInfo localModuleInfo1 = lookupModuleFromSourcePath(str1, paramScopeExp);
              if (localModuleInfo1 == null)
              {
                paramTranslator.error('e', "malformed URL: " + str1);
                return false;
              }
              return importDefinitions(((Type)localObject2).getName(), localModuleInfo1, null, paramVector, paramScopeExp, paramTranslator);
            }
          }
        }
      }
    }
    try
    {
      ModuleInfo localModuleInfo2 = ModuleInfo.find((ClassType)localObject2);
      importDefinitions(null, localModuleInfo2, null, paramVector, paramScopeExp, paramTranslator);
      return true;
    }
    catch (Exception localException)
    {
      paramTranslator.error('e', "unknown class " + ((Type)localObject2).getName());
    }
    return false;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.require
 * JD-Core Version:    0.7.0.1
 */