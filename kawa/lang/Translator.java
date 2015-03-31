package kawa.lang;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ClassType;
import gnu.bytecode.Member;
import gnu.bytecode.Type;
import gnu.bytecode.ZipLoader;
import gnu.expr.ApplyExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.Special;
import gnu.expr.ThisExp;
import gnu.kawa.functions.AppendValues;
import gnu.kawa.functions.CompileNamedPart;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.reflect.FieldLocation;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.xml.MakeAttribute;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.xml.NamespaceBinding;
import java.util.Stack;
import java.util.Vector;
import kawa.standard.begin;
import kawa.standard.object;
import kawa.standard.require;

public class Translator
  extends Compilation
{
  private static Expression errorExp = new ErrorExp("unknown syntax error");
  public static final Declaration getNamedPartDecl = Declaration.getDeclarationFromStatic("gnu.kawa.functions.GetNamedPart", "getNamedPart");
  public LambdaExp curMethodLambda;
  public Macro currentMacroDefinition;
  Syntax currentSyntax;
  private Environment env = Environment.getCurrent();
  public int firstForm;
  public Stack formStack = new Stack();
  Declaration macroContext;
  public Declaration matchArray;
  Vector notedAccess;
  public PatternScope patternScope;
  public Object pendingForm;
  PairWithPosition positionPair;
  Stack renamedAliasStack;
  public Declaration templateScopeDecl;
  public NamespaceBinding xmlElementNamespaces = NamespaceBinding.predefinedXML;
  
  static
  {
    LispLanguage.getNamedPartLocation.setDeclaration(getNamedPartDecl);
  }
  
  public Translator(Language paramLanguage, SourceMessages paramSourceMessages, NameLookup paramNameLookup)
  {
    super(paramLanguage, paramSourceMessages, paramNameLookup);
  }
  
  static ReferenceExp getOriginalRef(Declaration paramDeclaration)
  {
    if ((paramDeclaration != null) && (paramDeclaration.isAlias()) && (!paramDeclaration.isIndirectBinding()))
    {
      Expression localExpression = paramDeclaration.getValue();
      if ((localExpression instanceof ReferenceExp)) {
        return (ReferenceExp)localExpression;
      }
    }
    return null;
  }
  
  public static int listLength(Object paramObject)
  {
    int i = 0;
    Object localObject1 = paramObject;
    Object localObject2 = paramObject;
    do
    {
      while ((localObject2 instanceof SyntaxForm)) {
        localObject2 = ((SyntaxForm)localObject2).getDatum();
      }
      while ((localObject1 instanceof SyntaxForm)) {
        localObject1 = ((SyntaxForm)localObject1).getDatum();
      }
      if (localObject2 == LList.Empty) {
        return i;
      }
      if (!(localObject2 instanceof Pair)) {
        return -1 - i;
      }
      int j = i + 1;
      for (Object localObject3 = ((Pair)localObject2).getCdr(); (localObject3 instanceof SyntaxForm); localObject3 = ((SyntaxForm)localObject3).getDatum()) {}
      if (localObject3 == LList.Empty) {
        return j;
      }
      if (!(localObject3 instanceof Pair)) {
        return -1 - j;
      }
      localObject1 = ((Pair)localObject1).getCdr();
      localObject2 = ((Pair)localObject3).getCdr();
      i = j + 1;
    } while (localObject2 != localObject1);
    return -2147483648;
  }
  
  private Expression makeBody(int paramInt, ScopeExp paramScopeExp)
  {
    int i = this.formStack.size() - paramInt;
    if (i == 0) {
      return QuoteExp.voidExp;
    }
    if (i == 1) {
      return (Expression)this.formStack.pop();
    }
    Expression[] arrayOfExpression = new Expression[i];
    for (int j = 0; j < i; j++) {
      arrayOfExpression[j] = ((Expression)this.formStack.elementAt(paramInt + j));
    }
    this.formStack.setSize(paramInt);
    if ((paramScopeExp instanceof ModuleExp)) {
      return new ApplyExp(AppendValues.appendValues, arrayOfExpression);
    }
    return ((LispLanguage)getLanguage()).makeBody(arrayOfExpression);
  }
  
  public static Pair makePair(Pair paramPair, Object paramObject1, Object paramObject2)
  {
    if ((paramPair instanceof PairWithPosition)) {
      return new PairWithPosition((PairWithPosition)paramPair, paramObject1, paramObject2);
    }
    return new Pair(paramObject1, paramObject2);
  }
  
  private void rewriteBody(LList paramLList)
  {
    while (paramLList != LList.Empty)
    {
      Pair localPair = (Pair)paramLList;
      Object localObject1 = pushPositionOf(localPair);
      try
      {
        rewriteInBody(localPair.getCar());
        popPositionOf(localObject1);
        paramLList = (LList)localPair.getCdr();
      }
      finally
      {
        popPositionOf(localObject1);
      }
    }
  }
  
  public static Object safeCar(Object paramObject)
  {
    while ((paramObject instanceof SyntaxForm)) {
      paramObject = ((SyntaxForm)paramObject).getDatum();
    }
    if (!(paramObject instanceof Pair)) {
      return null;
    }
    return stripSyntax(((Pair)paramObject).getCar());
  }
  
  public static Object safeCdr(Object paramObject)
  {
    while ((paramObject instanceof SyntaxForm)) {
      paramObject = ((SyntaxForm)paramObject).getDatum();
    }
    if (!(paramObject instanceof Pair)) {
      return null;
    }
    return stripSyntax(((Pair)paramObject).getCdr());
  }
  
  public static void setLine(Declaration paramDeclaration, Object paramObject)
  {
    if ((paramObject instanceof SourceLocator)) {
      paramDeclaration.setLocation((SourceLocator)paramObject);
    }
  }
  
  public static void setLine(Expression paramExpression, Object paramObject)
  {
    if ((paramObject instanceof SourceLocator)) {
      paramExpression.setLocation((SourceLocator)paramObject);
    }
  }
  
  public static Object stripSyntax(Object paramObject)
  {
    while ((paramObject instanceof SyntaxForm)) {
      paramObject = ((SyntaxForm)paramObject).getDatum();
    }
    return paramObject;
  }
  
  static void vectorReverse(Vector paramVector, int paramInt1, int paramInt2)
  {
    int i = paramInt2 / 2;
    int j = -1 + (paramInt1 + paramInt2);
    for (int k = 0; k < i; k++)
    {
      Object localObject = paramVector.elementAt(paramInt1 + k);
      paramVector.setElementAt(paramVector.elementAt(j - k), paramInt1 + k);
      paramVector.setElementAt(localObject, j - k);
    }
  }
  
  public static Object wrapSyntax(Object paramObject, SyntaxForm paramSyntaxForm)
  {
    if ((paramSyntaxForm == null) || ((paramObject instanceof Expression))) {
      return paramObject;
    }
    return SyntaxForms.fromDatumIfNeeded(paramObject, paramSyntaxForm);
  }
  
  Expression apply_rewrite(Syntax paramSyntax, Pair paramPair)
  {
    Syntax localSyntax = this.currentSyntax;
    this.currentSyntax = paramSyntax;
    try
    {
      Expression localExpression = paramSyntax.rewriteForm(paramPair, this);
      return localExpression;
    }
    finally
    {
      this.currentSyntax = localSyntax;
    }
  }
  
  Syntax check_if_Syntax(Declaration paramDeclaration)
  {
    Declaration localDeclaration1 = Declaration.followAliases(paramDeclaration);
    Expression localExpression = localDeclaration1.getValue();
    Object localObject1;
    if ((localExpression != null) && (localDeclaration1.getFlag(32768L)))
    {
      try
      {
        if (!(paramDeclaration.getValue() instanceof ReferenceExp)) {
          break label154;
        }
        Declaration localDeclaration2 = ((ReferenceExp)paramDeclaration.getValue()).contextDecl();
        if (localDeclaration2 == null) {
          break label85;
        }
        this.macroContext = localDeclaration2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject2;
          localThrowable.printStackTrace();
          error('e', "unable to evaluate macro for " + paramDeclaration.getSymbol());
          localObject1 = null;
          continue;
          if ((this.current_scope instanceof TemplateScope)) {
            this.macroContext = ((TemplateScope)this.current_scope).macroContext;
          }
        }
      }
      localObject2 = localExpression.eval(this.env);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!(localObject1 instanceof Syntax)) {
        break label225;
      }
      return (Syntax)localObject1;
      label85:
      if (!(this.current_scope instanceof TemplateScope)) {
        break;
      }
      this.macroContext = ((TemplateScope)this.current_scope).macroContext;
      break;
      label154:
      boolean bool1 = paramDeclaration.getFlag(32768L);
      localObject1 = null;
      if (bool1)
      {
        boolean bool2 = paramDeclaration.needsContext();
        localObject1 = null;
        if (!bool2) {
          localObject1 = StaticFieldLocation.make(paramDeclaration).get(null);
        }
      }
    }
    label225:
    return null;
  }
  
  public Declaration define(Object paramObject, SyntaxForm paramSyntaxForm, ScopeExp paramScopeExp)
  {
    int i;
    if ((paramSyntaxForm != null) && (paramSyntaxForm.getScope() != currentScope()))
    {
      i = 1;
      if (i == 0) {
        break label95;
      }
    }
    label95:
    for (Object localObject = new String(paramObject.toString());; localObject = paramObject)
    {
      Declaration localDeclaration1 = paramScopeExp.getDefine(localObject, 'w', this);
      if (i != 0)
      {
        Declaration localDeclaration2 = makeRenamedAlias(paramObject, localDeclaration1, paramSyntaxForm.getScope());
        paramSyntaxForm.getScope().addDeclaration(localDeclaration2);
      }
      push(localDeclaration1);
      return localDeclaration1;
      i = 0;
      break;
    }
  }
  
  public Type exp2Type(Pair paramPair)
  {
    Object localObject1 = pushPositionOf(paramPair);
    Object localObject3;
    label154:
    try
    {
      localExpression = InlineCalls.inlineCalls(rewrite_car(paramPair, false), this);
      boolean bool = localExpression instanceof ErrorExp;
      if (bool) {
        return null;
      }
      Type localType1 = getLanguage().getTypeFor(localExpression);
      localObject3 = localType1;
      if (localObject3 != null) {}
    }
    finally
    {
      Expression localExpression;
      Object localObject4;
      Type localType2;
      label90:
      popPositionOf(localObject1);
    }
    try
    {
      localObject4 = localExpression.eval(this.env);
      if (!(localObject4 instanceof Class)) {
        break label154;
      }
      localType2 = Type.make((Class)localObject4);
      localObject3 = localType2;
    }
    catch (Throwable localThrowable)
    {
      break label90;
    }
    if (localObject3 == null)
    {
      if ((localExpression instanceof ReferenceExp)) {
        error('e', "unknown type name '" + ((ReferenceExp)localExpression).getName() + '\'');
      }
      for (;;)
      {
        ClassType localClassType = Type.pointer_type;
        popPositionOf(localObject1);
        return localClassType;
        if (!(localObject4 instanceof Type)) {
          break;
        }
        localObject3 = (Type)localObject4;
        break;
        error('e', "invalid type spec (must be \"type\" or 'type or <type>)");
      }
    }
    popPositionOf(localObject1);
    return localObject3;
  }
  
  public void finishModule(ModuleExp paramModuleExp)
  {
    boolean bool = paramModuleExp.isStatic();
    Declaration localDeclaration = paramModuleExp.firstDecl();
    if (localDeclaration != null)
    {
      String str;
      if (localDeclaration.getFlag(512L))
      {
        if (localDeclaration.getFlag(1024L))
        {
          str = "' exported but never defined";
          label39:
          error('e', localDeclaration, "'", str);
        }
      }
      else
      {
        if ((paramModuleExp.getFlag(16384)) || ((this.generateMain) && (!this.immediate)))
        {
          if (!localDeclaration.getFlag(1024L)) {
            break label165;
          }
          if (localDeclaration.isPrivate())
          {
            if (localDeclaration.getFlag(16777216L)) {
              error('e', localDeclaration, "'", "' is declared both private and exported");
            }
            localDeclaration.setPrivate(false);
          }
        }
        label120:
        if (!bool) {
          break label173;
        }
        localDeclaration.setFlag(2048L);
      }
      for (;;)
      {
        localDeclaration = localDeclaration.nextDecl();
        break;
        if (localDeclaration.getFlag(2048L))
        {
          str = "' declared static but never defined";
          break label39;
        }
        str = "' declared but never defined";
        break label39;
        label165:
        localDeclaration.setPrivate(true);
        break label120;
        label173:
        if (((paramModuleExp.getFlag(65536)) && (!localDeclaration.getFlag(2048L))) || (Compilation.moduleStatic < 0) || (paramModuleExp.getFlag(131072))) {
          localDeclaration.setFlag(4096L);
        }
      }
    }
  }
  
  public Syntax getCurrentSyntax()
  {
    return this.currentSyntax;
  }
  
  public final Environment getGlobalEnvironment()
  {
    return this.env;
  }
  
  public Declaration lookup(Object paramObject, int paramInt)
  {
    Declaration localDeclaration = this.lexical.lookup(paramObject, paramInt);
    if ((localDeclaration != null) && (getLanguage().hasNamespace(localDeclaration, paramInt))) {
      return localDeclaration;
    }
    return currentModule().lookup(paramObject, getLanguage(), paramInt);
  }
  
  public Declaration lookupGlobal(Object paramObject)
  {
    return lookupGlobal(paramObject, -1);
  }
  
  public Declaration lookupGlobal(Object paramObject, int paramInt)
  {
    ModuleExp localModuleExp = currentModule();
    Declaration localDeclaration = localModuleExp.lookup(paramObject, getLanguage(), paramInt);
    if (localDeclaration == null)
    {
      localDeclaration = localModuleExp.getNoDefine(paramObject);
      localDeclaration.setIndirectBinding(true);
    }
    return localDeclaration;
  }
  
  public Declaration makeRenamedAlias(Declaration paramDeclaration, ScopeExp paramScopeExp)
  {
    if (paramScopeExp == null) {
      return paramDeclaration;
    }
    return makeRenamedAlias(paramDeclaration.getSymbol(), paramDeclaration, paramScopeExp);
  }
  
  public Declaration makeRenamedAlias(Object paramObject, Declaration paramDeclaration, ScopeExp paramScopeExp)
  {
    Declaration localDeclaration = new Declaration(paramObject);
    localDeclaration.setAlias(true);
    localDeclaration.setPrivate(true);
    localDeclaration.context = paramScopeExp;
    ReferenceExp localReferenceExp = new ReferenceExp(paramDeclaration);
    localReferenceExp.setDontDereference(true);
    localDeclaration.noteValue(localReferenceExp);
    return localDeclaration;
  }
  
  public Object matchQuoted(Pair paramPair)
  {
    if ((matches(paramPair.getCar(), "quote")) && ((paramPair.getCdr() instanceof Pair)))
    {
      Pair localPair = (Pair)paramPair.getCdr();
      if (localPair.getCdr() == LList.Empty) {
        return localPair.getCar();
      }
    }
    return null;
  }
  
  public final boolean matches(Object paramObject, String paramString)
  {
    return matches(paramObject, null, paramString);
  }
  
  public boolean matches(Object paramObject, SyntaxForm paramSyntaxForm, Symbol paramSymbol)
  {
    if ((paramSyntaxForm == null) || ((paramObject instanceof SyntaxForm))) {
      paramObject = ((SyntaxForm)paramObject).getDatum();
    }
    if (((paramObject instanceof SimpleSymbol)) && (!selfEvaluatingSymbol(paramObject)))
    {
      ReferenceExp localReferenceExp = getOriginalRef(this.lexical.lookup(paramObject, -1));
      if (localReferenceExp != null) {
        paramObject = localReferenceExp.getSymbol();
      }
    }
    return paramObject == paramSymbol;
  }
  
  public boolean matches(Object paramObject, SyntaxForm paramSyntaxForm, String paramString)
  {
    if ((paramSyntaxForm == null) || ((paramObject instanceof SyntaxForm))) {
      paramObject = ((SyntaxForm)paramObject).getDatum();
    }
    if (((paramObject instanceof SimpleSymbol)) && (!selfEvaluatingSymbol(paramObject)))
    {
      ReferenceExp localReferenceExp = getOriginalRef(this.lexical.lookup(paramObject, -1));
      if (localReferenceExp != null) {
        paramObject = localReferenceExp.getSymbol();
      }
    }
    return ((paramObject instanceof SimpleSymbol)) && (((Symbol)paramObject).getLocalPart() == paramString);
  }
  
  public Symbol namespaceResolve(Expression paramExpression1, Expression paramExpression2)
  {
    return namespaceResolve(namespaceResolvePrefix(paramExpression1), paramExpression2);
  }
  
  public Symbol namespaceResolve(Namespace paramNamespace, Expression paramExpression)
  {
    if ((paramNamespace != null) && ((paramExpression instanceof QuoteExp))) {
      return paramNamespace.getSymbol(((QuoteExp)paramExpression).getValue().toString().intern());
    }
    return null;
  }
  
  public Object namespaceResolve(Object paramObject)
  {
    if ((!(paramObject instanceof SimpleSymbol)) && ((paramObject instanceof Pair)))
    {
      Pair localPair1 = (Pair)paramObject;
      if ((safeCar(localPair1) == LispLanguage.lookup_sym) && ((localPair1.getCdr() instanceof Pair)))
      {
        Pair localPair2 = (Pair)localPair1.getCdr();
        if ((localPair2.getCdr() instanceof Pair))
        {
          Expression localExpression1 = rewrite(localPair2.getCar());
          Expression localExpression2 = rewrite(((Pair)localPair2.getCdr()).getCar());
          Symbol localSymbol = namespaceResolve(localExpression1, localExpression2);
          if (localSymbol != null) {
            return localSymbol;
          }
          String str = CompileNamedPart.combineName(localExpression1, localExpression2);
          if (str != null) {
            return Namespace.EmptyNamespace.getSymbol(str);
          }
        }
      }
    }
    return paramObject;
  }
  
  public Namespace namespaceResolvePrefix(Expression paramExpression)
  {
    if ((paramExpression instanceof ReferenceExp))
    {
      ReferenceExp localReferenceExp = (ReferenceExp)paramExpression;
      Declaration localDeclaration = localReferenceExp.getBinding();
      Object localObject1;
      Symbol localSymbol;
      Object localObject2;
      if ((localDeclaration == null) || (localDeclaration.getFlag(65536L)))
      {
        localObject1 = localReferenceExp.getSymbol();
        if ((localObject1 instanceof Symbol))
        {
          localSymbol = (Symbol)localObject1;
          localObject2 = this.env.get(localSymbol, null);
        }
      }
      for (;;)
      {
        if (!(localObject2 instanceof Namespace)) {
          break label147;
        }
        Namespace localNamespace = (Namespace)localObject2;
        String str = localNamespace.getName();
        if ((str != null) && (str.startsWith("class:"))) {
          localNamespace = null;
        }
        return localNamespace;
        localSymbol = this.env.getSymbol(localObject1.toString());
        break;
        if (localDeclaration.isNamespaceDecl()) {
          localObject2 = localDeclaration.getConstantValue();
        } else {
          localObject2 = null;
        }
      }
    }
    label147:
    return null;
  }
  
  public void noteAccess(Object paramObject, ScopeExp paramScopeExp)
  {
    if (this.notedAccess == null) {
      this.notedAccess = new Vector();
    }
    this.notedAccess.addElement(paramObject);
    this.notedAccess.addElement(paramScopeExp);
  }
  
  public Expression parse(Object paramObject)
  {
    return rewrite(paramObject);
  }
  
  public Object popForms(int paramInt)
  {
    int i = this.formStack.size();
    if (i == paramInt) {
      return Values.empty;
    }
    if (i == paramInt + 1) {}
    Values localValues;
    for (Object localObject = this.formStack.elementAt(paramInt);; localObject = localValues)
    {
      this.formStack.setSize(paramInt);
      return localObject;
      localValues = new Values();
      for (int j = paramInt; j < i; j++) {
        localValues.writeObject(this.formStack.elementAt(j));
      }
    }
  }
  
  public void popPositionOf(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      setLine(paramObject);
      this.positionPair = ((PairWithPosition)paramObject);
    } while (this.positionPair.getCar() != Special.eof);
    this.positionPair = ((PairWithPosition)this.positionPair.getCdr());
  }
  
  public void popRenamedAlias(int paramInt)
  {
    for (;;)
    {
      
      if (paramInt < 0) {
        break;
      }
      ScopeExp localScopeExp = (ScopeExp)this.renamedAliasStack.pop();
      Declaration localDeclaration = (Declaration)this.renamedAliasStack.pop();
      getOriginalRef(localDeclaration).getBinding().setSymbol(localDeclaration.getSymbol());
      localScopeExp.remove(localDeclaration);
      Object localObject = this.renamedAliasStack.pop();
      if (localObject != null) {
        localScopeExp.addDeclaration((Declaration)localObject);
      }
    }
  }
  
  public void processAccesses()
  {
    if (this.notedAccess == null) {}
    ScopeExp localScopeExp1;
    do
    {
      return;
      int i = this.notedAccess.size();
      localScopeExp1 = this.current_scope;
      for (int j = 0; j < i; j += 2)
      {
        Object localObject = this.notedAccess.elementAt(j);
        ScopeExp localScopeExp2 = (ScopeExp)this.notedAccess.elementAt(j + 1);
        if (this.current_scope != localScopeExp2) {
          setCurrentScope(localScopeExp2);
        }
        Declaration localDeclaration = this.lexical.lookup(localObject, -1);
        if ((localDeclaration != null) && (!localDeclaration.getFlag(65536L)))
        {
          localDeclaration.getContext().currentLambda().capture(localDeclaration);
          localDeclaration.setCanRead(true);
          localDeclaration.setSimple(false);
          localDeclaration.setFlag(524288L);
        }
      }
    } while (this.current_scope == localScopeExp1);
    setCurrentScope(localScopeExp1);
  }
  
  public Object pushPositionOf(Object paramObject)
  {
    if ((paramObject instanceof SyntaxForm)) {
      paramObject = ((SyntaxForm)paramObject).getDatum();
    }
    if (!(paramObject instanceof PairWithPosition)) {
      return null;
    }
    PairWithPosition localPairWithPosition1 = (PairWithPosition)paramObject;
    if ((this.positionPair == null) || (this.positionPair.getFileName() != getFileName()) || (this.positionPair.getLineNumber() != getLineNumber()) || (this.positionPair.getColumnNumber() != getColumnNumber())) {}
    for (PairWithPosition localPairWithPosition2 = new PairWithPosition(this, Special.eof, this.positionPair);; localPairWithPosition2 = this.positionPair)
    {
      setLine(paramObject);
      this.positionPair = localPairWithPosition1;
      return localPairWithPosition2;
    }
  }
  
  public void pushRenamedAlias(Declaration paramDeclaration)
  {
    Declaration localDeclaration1 = getOriginalRef(paramDeclaration).getBinding();
    ScopeExp localScopeExp = paramDeclaration.context;
    localDeclaration1.setSymbol(null);
    Declaration localDeclaration2 = localScopeExp.lookup(localDeclaration1.getSymbol());
    if (localDeclaration2 != null) {
      localScopeExp.remove(localDeclaration2);
    }
    localScopeExp.addDeclaration(paramDeclaration);
    if (this.renamedAliasStack == null) {
      this.renamedAliasStack = new Stack();
    }
    this.renamedAliasStack.push(localDeclaration2);
    this.renamedAliasStack.push(paramDeclaration);
    this.renamedAliasStack.push(localScopeExp);
  }
  
  public void resolveModule(ModuleExp paramModuleExp)
  {
    if (this.pendingImports == null) {}
    for (int i = 0;; i = this.pendingImports.size())
    {
      int j = 0;
      while (j < i)
      {
        Stack localStack1 = this.pendingImports;
        int k = j + 1;
        ModuleInfo localModuleInfo = (ModuleInfo)localStack1.elementAt(j);
        Stack localStack2 = this.pendingImports;
        int m = k + 1;
        ScopeExp localScopeExp = (ScopeExp)localStack2.elementAt(k);
        Stack localStack3 = this.pendingImports;
        int n = m + 1;
        Expression localExpression = (Expression)localStack3.elementAt(m);
        Stack localStack4 = this.pendingImports;
        j = n + 1;
        Integer localInteger = (Integer)localStack4.elementAt(n);
        if (paramModuleExp == localScopeExp)
        {
          ReferenceExp localReferenceExp = new ReferenceExp((Object)null);
          localReferenceExp.setLine(this);
          setLine(localExpression);
          int i1 = this.formStack.size();
          require.importDefinitions(null, localModuleInfo, null, this.formStack, localScopeExp, this);
          int i2 = localInteger.intValue();
          if (localInteger.intValue() != i1)
          {
            int i3 = this.formStack.size();
            int i4 = i3 - i2;
            vectorReverse(this.formStack, i2, i1 - i2);
            vectorReverse(this.formStack, i1, i3 - i1);
            vectorReverse(this.formStack, i2, i4);
          }
          setLine(localReferenceExp);
        }
      }
    }
    this.pendingImports = null;
    processAccesses();
    setModule(paramModuleExp);
    Compilation localCompilation = Compilation.setSaveCurrent(this);
    try
    {
      rewriteInBody(popForms(this.firstForm));
      paramModuleExp.body = makeBody(this.firstForm, paramModuleExp);
      if (!this.immediate) {
        this.lexical.pop(paramModuleExp);
      }
      return;
    }
    finally
    {
      Compilation.restoreCurrent(localCompilation);
    }
  }
  
  public Expression rewrite(Object paramObject)
  {
    return rewrite(paramObject, false);
  }
  
  public Expression rewrite(Object paramObject, boolean paramBoolean)
  {
    if ((paramObject instanceof SyntaxForm))
    {
      SyntaxForm localSyntaxForm = (SyntaxForm)paramObject;
      ScopeExp localScopeExp3 = this.current_scope;
      try
      {
        setCurrentScope(localSyntaxForm.getScope());
        Expression localExpression2 = rewrite(localSyntaxForm.getDatum(), paramBoolean);
        return localExpression2;
      }
      finally
      {
        setCurrentScope(localScopeExp3);
      }
    }
    if ((paramObject instanceof PairWithPosition)) {
      return rewrite_with_position(paramObject, paramBoolean, (PairWithPosition)paramObject);
    }
    if ((paramObject instanceof Pair)) {
      return rewrite_pair((Pair)paramObject, paramBoolean);
    }
    Declaration localDeclaration1;
    Object localObject1;
    label163:
    Object localObject2;
    Object localObject3;
    label263:
    Symbol localSymbol;
    boolean bool1;
    label349:
    label358:
    label487:
    Environment localEnvironment;
    if (((paramObject instanceof Symbol)) && (!selfEvaluatingSymbol(paramObject)))
    {
      localDeclaration1 = this.lexical.lookup(paramObject, paramBoolean);
      localObject1 = null;
      ScopeExp localScopeExp1 = this.current_scope;
      int i;
      String str;
      if (localDeclaration1 == null)
      {
        i = -1;
        if ((!(paramObject instanceof Symbol)) || (!((Symbol)paramObject).hasEmptyNamespace())) {
          break label349;
        }
        str = paramObject.toString();
        if (localScopeExp1 != null)
        {
          if ((!(localScopeExp1 instanceof LambdaExp)) || (!(localScopeExp1.outer instanceof ClassExp)) || (!((LambdaExp)localScopeExp1).isClassMethod())) {
            break label464;
          }
          if (i < ScopeExp.nesting(localScopeExp1.outer)) {
            break label358;
          }
        }
        if (localDeclaration1 == null) {
          break label552;
        }
        localObject2 = localDeclaration1.getSymbol();
        ReferenceExp localReferenceExp2 = getOriginalRef(localDeclaration1);
        Object localObject5 = null;
        if (localReferenceExp2 != null)
        {
          localDeclaration1 = localReferenceExp2.getBinding();
          localObject5 = null;
          if (localDeclaration1 == null)
          {
            localObject5 = localReferenceExp2.getSymbol();
            localObject2 = localObject5;
          }
        }
        localObject3 = localObject5;
        localSymbol = (Symbol)localObject3;
        bool1 = getLanguage().hasSeparateFunctionNamespace();
        if (localDeclaration1 == null) {
          break label663;
        }
        if ((!(this.current_scope instanceof TemplateScope)) || (!localDeclaration1.needsContext())) {
          break label561;
        }
        localObject1 = ((TemplateScope)this.current_scope).macroContext;
      }
      label427:
      label464:
      label480:
      boolean bool6;
      label552:
      label561:
      do
      {
        boolean bool5;
        do
        {
          if (localDeclaration1 == null) {
            break label1036;
          }
          if ((paramBoolean) || (!(localDeclaration1.getConstantValue() instanceof object))) {
            break label992;
          }
          return QuoteExp.getInstance(Object.class);
          i = ScopeExp.nesting(localDeclaration1.context);
          break;
          str = null;
          localScopeExp1 = null;
          break label163;
          LambdaExp localLambdaExp = (LambdaExp)localScopeExp1;
          ClassExp localClassExp = (ClassExp)localScopeExp1.outer;
          ClassType localClassType = localClassExp.getClassType();
          Member localMember = SlotGet.lookupMember(localClassType, str, localClassType);
          int j;
          if ((localLambdaExp == localClassExp.clinitMethod) || ((localLambdaExp != localClassExp.initMethod) && (localLambdaExp.nameDecl.isStatic())))
          {
            j = 1;
            if (localMember != null) {
              break label487;
            }
            if (j == 0) {
              break label480;
            }
          }
          for (char c = 'S';; c = 'V')
          {
            Language localLanguage = this.language;
            if (ClassMethods.getMethods(localClassType, str, c, localClassType, localLanguage).length != 0) {
              break label487;
            }
            localScopeExp1 = localScopeExp1.outer;
            break;
            j = 0;
            break label427;
          }
          Declaration localDeclaration4;
          if (j != 0) {
            localDeclaration4 = ((ClassExp)localLambdaExp.outer).nameDecl;
          }
          Declaration localDeclaration3;
          for (Object localObject6 = new ReferenceExp(localDeclaration4);; localObject6 = new ThisExp(localDeclaration3))
          {
            QuoteExp localQuoteExp = QuoteExp.getInstance(str);
            return CompileNamedPart.makeExp((Expression)localObject6, localQuoteExp);
            localDeclaration3 = localLambdaExp.firstDecl();
          }
          localObject2 = paramObject;
          localObject3 = paramObject;
          break label263;
          bool5 = localDeclaration1.getFlag(1048576L);
          localObject1 = null;
        } while (!bool5);
        bool6 = localDeclaration1.isStatic();
        localObject1 = null;
      } while (bool6);
      for (ScopeExp localScopeExp2 = currentScope();; localScopeExp2 = localScopeExp2.outer)
      {
        if (localScopeExp2 == null) {
          throw new Error("internal error: missing " + localDeclaration1);
        }
        if (localScopeExp2.outer == localDeclaration1.context)
        {
          localObject1 = localScopeExp2.firstDecl();
          break;
        }
      }
      label663:
      localEnvironment = this.env;
      if ((!paramBoolean) || (!bool1)) {
        break label1150;
      }
    }
    label992:
    label1142:
    label1150:
    for (Object localObject4 = EnvironmentKey.FUNCTION;; localObject4 = null)
    {
      for (;;)
      {
        Location localLocation;
        Declaration localDeclaration2;
        for (;;)
        {
          localLocation = localEnvironment.lookup(localSymbol, localObject4);
          if (localLocation != null) {
            localLocation = localLocation.getBase();
          }
          if ((localLocation instanceof FieldLocation))
          {
            FieldLocation localFieldLocation = (FieldLocation)localLocation;
            Class localClass;
            ClassLoader localClassLoader;
            boolean bool3;
            try
            {
              localDeclaration1 = localFieldLocation.getDeclaration();
              if ((!inlineOk(null)) && (localDeclaration1 != getNamedPartDecl) && ((!"objectSyntax".equals(localFieldLocation.getMemberName())) || (!"kawa.standard.object".equals(localFieldLocation.getDeclaringClass().getName())))) {
                break label1142;
              }
              if (this.immediate)
              {
                boolean bool4 = localDeclaration1.isStatic();
                localObject1 = null;
                if (bool4) {
                  break;
                }
                localDeclaration2 = new Declaration("(module-instance)");
              }
            }
            catch (Throwable localThrowable1) {}
          }
        }
        try
        {
          localDeclaration2.setValue(new QuoteExp(localFieldLocation.getInstance()));
          localObject1 = localDeclaration2;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            boolean bool2;
            Expression localExpression1;
            ReferenceExp localReferenceExp1;
            localObject1 = localDeclaration2;
          }
        }
      }
      if (localDeclaration1.isStatic())
      {
        localClass = localFieldLocation.getRClass();
        if (localClass != null)
        {
          localClassLoader = localClass.getClassLoader();
          if (!(localClassLoader instanceof ZipLoader))
          {
            bool3 = localClassLoader instanceof ArrayClassLoader;
            localObject1 = null;
            if (!bool3) {
              break;
            }
          }
        }
        localObject1 = null;
        localDeclaration1 = null;
        break;
      }
      localObject1 = null;
      localDeclaration1 = null;
      break;
      error('e', "exception loading '" + localObject3 + "' - " + localThrowable1.getMessage());
      localDeclaration1 = null;
      break;
      if (localLocation != null)
      {
        bool2 = localLocation.isBound();
        localObject1 = null;
        if (bool2) {
          break;
        }
      }
      localExpression1 = ((LispLanguage)getLanguage()).checkDefaultBinding(localSymbol, this);
      localObject1 = null;
      if (localExpression1 == null) {
        break;
      }
      return localExpression1;
      if ((localDeclaration1.getContext() instanceof PatternScope)) {
        return syntaxError("reference to pattern variable " + localDeclaration1.getName() + " outside syntax template");
      }
      localReferenceExp1 = new ReferenceExp(localObject2, localDeclaration1);
      localReferenceExp1.setContextDecl((Declaration)localObject1);
      localReferenceExp1.setLine(this);
      if ((paramBoolean) && (bool1)) {
        localReferenceExp1.setFlag(8);
      }
      return localReferenceExp1;
      if ((paramObject instanceof LangExp)) {
        return rewrite(((LangExp)paramObject).getLangValue(), paramBoolean);
      }
      if ((paramObject instanceof Expression)) {
        return (Expression)paramObject;
      }
      if (paramObject == Special.abstractSpecial) {
        return QuoteExp.abstractExp;
      }
      return QuoteExp.getInstance(Quote.quote(paramObject, this), this);
      localObject1 = null;
      localDeclaration1 = null;
      break;
    }
  }
  
  public void rewriteInBody(Object paramObject)
  {
    SyntaxForm localSyntaxForm;
    ScopeExp localScopeExp;
    if ((paramObject instanceof SyntaxForm))
    {
      localSyntaxForm = (SyntaxForm)paramObject;
      localScopeExp = this.current_scope;
    }
    for (;;)
    {
      try
      {
        setCurrentScope(localSyntaxForm.getScope());
        rewriteInBody(localSyntaxForm.getDatum());
        return;
      }
      finally
      {
        setCurrentScope(localScopeExp);
      }
      if (!(paramObject instanceof Values)) {
        break;
      }
      Object[] arrayOfObject = ((Values)paramObject).getValues();
      for (int i = 0; i < arrayOfObject.length; i++) {
        rewriteInBody(arrayOfObject[i]);
      }
    }
    this.formStack.add(rewrite(paramObject, false));
  }
  
  public Expression rewrite_body(Object paramObject)
  {
    Object localObject1 = pushPositionOf(paramObject);
    LetExp localLetExp = new LetExp(null);
    int i = this.formStack.size();
    localLetExp.outer = this.current_scope;
    this.current_scope = localLetExp;
    LList localLList;
    int j;
    try
    {
      localLList = scanBody(paramObject, localLetExp, true);
      if (localLList.isEmpty()) {
        this.formStack.add(syntaxError("body with no expressions"));
      }
      j = localLetExp.countNonDynamicDecls();
      if (j != 0)
      {
        Expression[] arrayOfExpression = new Expression[j];
        int k = j;
        for (;;)
        {
          k--;
          if (k < 0) {
            break;
          }
          arrayOfExpression[k] = QuoteExp.undefined_exp;
        }
        localLetExp.inits = arrayOfExpression;
      }
    }
    finally
    {
      pop(localLetExp);
      popPositionOf(localObject1);
    }
    rewriteBody(localLList);
    Expression localExpression = makeBody(i, null);
    setLineOf(localExpression);
    if (j == 0)
    {
      pop(localLetExp);
      popPositionOf(localObject1);
      return localExpression;
    }
    localLetExp.body = localExpression;
    setLineOf(localLetExp);
    pop(localLetExp);
    popPositionOf(localObject1);
    return localLetExp;
  }
  
  public final Expression rewrite_car(Pair paramPair, SyntaxForm paramSyntaxForm)
  {
    if ((paramSyntaxForm == null) || (paramSyntaxForm.getScope() == this.current_scope) || ((paramPair.getCar() instanceof SyntaxForm))) {
      return rewrite_car(paramPair, false);
    }
    ScopeExp localScopeExp = this.current_scope;
    try
    {
      setCurrentScope(paramSyntaxForm.getScope());
      Expression localExpression = rewrite_car(paramPair, false);
      return localExpression;
    }
    finally
    {
      setCurrentScope(localScopeExp);
    }
  }
  
  public final Expression rewrite_car(Pair paramPair, boolean paramBoolean)
  {
    Object localObject = paramPair.getCar();
    if ((paramPair instanceof PairWithPosition)) {
      return rewrite_with_position(localObject, paramBoolean, (PairWithPosition)paramPair);
    }
    return rewrite(localObject, paramBoolean);
  }
  
  public Expression rewrite_pair(Pair paramPair, boolean paramBoolean)
  {
    Expression localExpression1 = rewrite_car(paramPair, true);
    if ((localExpression1 instanceof QuoteExp))
    {
      Object localObject7 = localExpression1.valueIfConstant();
      if ((localObject7 instanceof Syntax)) {
        return apply_rewrite((Syntax)localObject7, paramPair);
      }
    }
    ReferenceExp localReferenceExp;
    Declaration localDeclaration1;
    Object localObject6;
    if ((localExpression1 instanceof ReferenceExp))
    {
      localReferenceExp = (ReferenceExp)localExpression1;
      localDeclaration1 = localReferenceExp.getBinding();
      if (localDeclaration1 != null) {
        break label271;
      }
      Object localObject4 = localReferenceExp.getSymbol();
      Symbol localSymbol2;
      Environment localEnvironment;
      if (((localObject4 instanceof Symbol)) && (!selfEvaluatingSymbol(localObject4)))
      {
        localSymbol2 = (Symbol)localObject4;
        localSymbol2.getName();
        localEnvironment = this.env;
        if (!getLanguage().hasSeparateFunctionNamespace()) {
          break label174;
        }
      }
      label174:
      for (Object localObject5 = EnvironmentKey.FUNCTION;; localObject5 = null)
      {
        localObject6 = localEnvironment.get(localSymbol2, localObject5, null);
        if (!(localObject6 instanceof Syntax)) {
          break label180;
        }
        return apply_rewrite((Syntax)localObject6, paramPair);
        String str = localObject4.toString();
        localSymbol2 = this.env.getSymbol(str);
        break;
      }
      label180:
      if (!(localObject6 instanceof AutoloadProcedure)) {}
    }
    Object localObject1;
    int i;
    for (;;)
    {
      try
      {
        ((AutoloadProcedure)localObject6).getLoaded();
        localReferenceExp.setProcedureName(true);
        if (getLanguage().hasSeparateFunctionNamespace()) {
          localExpression1.setFlag(8);
        }
        localObject1 = paramPair.getCdr();
        i = listLength(localObject1);
        if (i != -1) {
          break;
        }
        return syntaxError("circular list is not allowed after " + paramPair.getCar());
      }
      catch (RuntimeException localRuntimeException)
      {
        continue;
      }
      label271:
      Declaration localDeclaration2 = this.macroContext;
      Syntax localSyntax = check_if_Syntax(localDeclaration1);
      if (localSyntax != null)
      {
        Expression localExpression4 = apply_rewrite(localSyntax, paramPair);
        this.macroContext = localDeclaration2;
        return localExpression4;
      }
    }
    if (i < 0) {
      return syntaxError("dotted list [" + localObject1 + "] is not allowed after " + paramPair.getCar());
    }
    Stack localStack = new Stack();
    ScopeExp localScopeExp = this.current_scope;
    int j = 0;
    if (j < i)
    {
      if ((localObject1 instanceof SyntaxForm))
      {
        SyntaxForm localSyntaxForm = (SyntaxForm)localObject1;
        localObject1 = localSyntaxForm.getDatum();
        setCurrentScope(localSyntaxForm.getScope());
      }
      Pair localPair = (Pair)localObject1;
      Object localObject2 = rewrite_car(localPair, false);
      j++;
      if (0 != 0)
      {
        if ((j & 0x1) != 0) {
          break label497;
        }
        Expression[] arrayOfExpression2 = new Expression[2];
        arrayOfExpression2[0] = ((Expression)localStack.pop());
        arrayOfExpression2[1] = localObject2;
        localObject2 = new ApplyExp(MakeAttribute.makeAttribute, arrayOfExpression2);
      }
      for (;;)
      {
        localStack.addElement(localObject2);
        localObject1 = localPair.getCdr();
        break;
        label497:
        if ((localObject2 instanceof QuoteExp))
        {
          Object localObject3 = ((QuoteExp)localObject2).getValue();
          if (((localObject3 instanceof Keyword)) && (j < i)) {
            localObject2 = new QuoteExp(((Keyword)localObject3).asSymbol());
          }
        }
      }
    }
    Expression[] arrayOfExpression1 = new Expression[localStack.size()];
    localStack.copyInto(arrayOfExpression1);
    if (localScopeExp != this.current_scope) {
      setCurrentScope(localScopeExp);
    }
    if (((localExpression1 instanceof ReferenceExp)) && (((ReferenceExp)localExpression1).getBinding() == getNamedPartDecl))
    {
      Expression localExpression2 = arrayOfExpression1[0];
      Expression localExpression3 = arrayOfExpression1[1];
      Symbol localSymbol1 = namespaceResolve(localExpression2, localExpression3);
      if (localSymbol1 != null) {
        return rewrite(localSymbol1, paramBoolean);
      }
      return CompileNamedPart.makeExp(localExpression2, localExpression3);
    }
    return ((LispLanguage)getLanguage()).makeApply(localExpression1, arrayOfExpression1);
  }
  
  public Expression rewrite_with_position(Object paramObject, boolean paramBoolean, PairWithPosition paramPairWithPosition)
  {
    localObject1 = pushPositionOf(paramPairWithPosition);
    if (paramObject == paramPairWithPosition) {}
    for (;;)
    {
      try
      {
        localObject3 = rewrite_pair(paramPairWithPosition, paramBoolean);
        setLineOf((Expression)localObject3);
        return localObject3;
      }
      finally
      {
        Object localObject3;
        Expression localExpression;
        popPositionOf(localObject1);
      }
      localExpression = rewrite(paramObject, paramBoolean);
      localObject3 = localExpression;
    }
  }
  
  public LList scanBody(Object paramObject, ScopeExp paramScopeExp, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = LList.Empty;
      localObject2 = null;
    }
    for (;;)
    {
      for (;;)
      {
        SyntaxForm localSyntaxForm;
        ScopeExp localScopeExp;
        if (paramObject != LList.Empty)
        {
          if ((paramObject instanceof SyntaxForm))
          {
            localSyntaxForm = (SyntaxForm)paramObject;
            localScopeExp = this.current_scope;
          }
        }
        else {
          try
          {
            setCurrentScope(localSyntaxForm.getScope());
            int m = this.formStack.size();
            LList localLList1 = scanBody(localSyntaxForm.getDatum(), paramScopeExp, paramBoolean);
            if (paramBoolean)
            {
              LList localLList2 = (LList)SyntaxForms.fromDatumIfNeeded(localLList1, localSyntaxForm);
              if (localObject2 == null)
              {
                setCurrentScope(localScopeExp);
                localObject1 = localLList2;
                return localObject1;
                localObject1 = null;
                break;
              }
              localObject2.setCdrBackdoor(localLList2);
              return localObject1;
            }
            this.formStack.add(wrapSyntax(popForms(m), localSyntaxForm));
            return null;
          }
          finally
          {
            setCurrentScope(localScopeExp);
          }
        }
      }
      if (!(paramObject instanceof Pair)) {
        break label345;
      }
      Pair localPair1 = (Pair)paramObject;
      int i = this.formStack.size();
      scanForm(localPair1.getCar(), paramScopeExp);
      if (getState() == 2)
      {
        if (localPair1.getCar() != this.pendingForm) {
          localPair1 = makePair(localPair1, this.pendingForm, localPair1.getCdr());
        }
        this.pendingForm = new Pair(begin.begin, localPair1);
        return LList.Empty;
      }
      int j = this.formStack.size();
      if (paramBoolean)
      {
        int k = i;
        if (k < j)
        {
          Pair localPair2 = makePair(localPair1, this.formStack.elementAt(k), LList.Empty);
          if (localObject2 == null) {
            localObject1 = localPair2;
          }
          for (;;)
          {
            localObject2 = localPair2;
            k++;
            break;
            localObject2.setCdrBackdoor(localPair2);
          }
        }
        this.formStack.setSize(i);
      }
      paramObject = localPair1.getCdr();
    }
    label345:
    this.formStack.add(syntaxError("body is not a proper list"));
    return localObject1;
  }
  
  public void scanForm(Object paramObject, ScopeExp paramScopeExp)
  {
    if ((paramObject instanceof SyntaxForm))
    {
      SyntaxForm localSyntaxForm2 = (SyntaxForm)paramObject;
      ScopeExp localScopeExp2 = currentScope();
      try
      {
        setCurrentScope(localSyntaxForm2.getScope());
        int m = this.formStack.size();
        scanForm(localSyntaxForm2.getDatum(), paramScopeExp);
        this.formStack.add(wrapSyntax(popForms(m), localSyntaxForm2));
        return;
      }
      finally
      {
        setCurrentScope(localScopeExp2);
      }
    }
    Pair localPair1;
    Declaration localDeclaration1;
    ScopeExp localScopeExp1;
    Object localObject1;
    if ((paramObject instanceof Values))
    {
      Values localValues = Values.empty;
      if (paramObject == localValues) {
        paramObject = QuoteExp.voidExp;
      }
    }
    else
    {
      if (!(paramObject instanceof Pair)) {
        break label687;
      }
      localPair1 = (Pair)paramObject;
      localDeclaration1 = this.macroContext;
      localScopeExp1 = this.current_scope;
      localObject1 = pushPositionOf(paramObject);
      if (((paramObject instanceof SourceLocator)) && (paramScopeExp.getLineNumber() < 0)) {
        paramScopeExp.setLocation((SourceLocator)paramObject);
      }
    }
    String str;
    int i;
    int j;
    for (;;)
    {
      try
      {
        localObject3 = localPair1.getCar();
        if ((localObject3 instanceof SyntaxForm))
        {
          SyntaxForm localSyntaxForm1 = (SyntaxForm)localPair1.getCar();
          setCurrentScope(localSyntaxForm1.getScope());
          localObject3 = localSyntaxForm1.getDatum();
        }
        boolean bool1 = localObject3 instanceof Pair;
        localObject4 = null;
        Object localObject6;
        Object localObject7;
        if (bool1)
        {
          Pair localPair2 = (Pair)localObject3;
          Object localObject5 = localPair2.getCar();
          Symbol localSymbol = LispLanguage.lookup_sym;
          localObject4 = null;
          if (localObject5 == localSymbol)
          {
            boolean bool2 = localPair2.getCdr() instanceof Pair;
            localObject4 = null;
            if (bool2)
            {
              Pair localPair3 = (Pair)localPair2.getCdr();
              boolean bool3 = localPair3.getCdr() instanceof Pair;
              localObject4 = null;
              if (bool3)
              {
                localExpression1 = rewrite(localPair3.getCar());
                localExpression2 = rewrite(((Pair)localPair3.getCdr()).getCar());
                localObject6 = localExpression1.valueIfConstant();
                localObject7 = localExpression2.valueIfConstant();
                if (!(localObject6 instanceof Class)) {
                  continue;
                }
                boolean bool4 = localObject7 instanceof Symbol;
                if (!bool4) {
                  continue;
                }
              }
            }
          }
        }
        try
        {
          localObject3 = GetNamedPart.getNamedPart(localObject6, (Symbol)localObject7);
          boolean bool5 = localObject3 instanceof Syntax;
          localObject4 = null;
          if (bool5) {
            localObject4 = (Syntax)localObject3;
          }
        }
        catch (Throwable localThrowable)
        {
          Expression localExpression3;
          Declaration localDeclaration2;
          Syntax localSyntax;
          Object[] arrayOfObject;
          int k;
          localObject3 = null;
          localObject4 = null;
          continue;
        }
        if (((localObject3 instanceof Symbol)) && (!selfEvaluatingSymbol(localObject3)))
        {
          localExpression3 = rewrite(localObject3, true);
          if ((localExpression3 instanceof ReferenceExp))
          {
            localDeclaration2 = ((ReferenceExp)localExpression3).getBinding();
            if (localDeclaration2 != null)
            {
              localSyntax = check_if_Syntax(localDeclaration2);
              localObject4 = localSyntax;
            }
          }
          else
          {
            if (localScopeExp1 != this.current_scope) {
              setCurrentScope(localScopeExp1);
            }
            popPositionOf(localObject1);
            if (localObject4 == null) {
              break label687;
            }
            str = getFileName();
            i = getLineNumber();
            j = getColumnNumber();
          }
        }
      }
      finally
      {
        Object localObject3;
        Object localObject4;
        Expression localExpression1;
        Expression localExpression2;
        Object localObject9;
        if (localScopeExp1 != this.current_scope) {
          setCurrentScope(localScopeExp1);
        }
        popPositionOf(localObject1);
      }
      try
      {
        setLine(localPair1);
        ((Syntax)localObject4).scanForm(localPair1, paramScopeExp, this);
        this.macroContext = localDeclaration1;
        setLine(str, i, j);
        return;
      }
      finally
      {
        this.macroContext = localDeclaration1;
        setLine(str, i, j);
      }
      arrayOfObject = ((Values)paramObject).getValues();
      k = 0;
      if (k < arrayOfObject.length)
      {
        scanForm(arrayOfObject[k], paramScopeExp);
        k++;
      }
      else
      {
        break;
        localObject3 = namespaceResolve(localExpression1, localExpression2);
        localObject4 = null;
        continue;
        localObject9 = resolve(localObject3, true);
        if ((localObject9 instanceof Syntax))
        {
          localObject4 = (Syntax)localObject9;
          continue;
          if (localObject3 == begin.begin) {
            localObject4 = (Syntax)localObject3;
          }
        }
      }
    }
    label687:
    this.formStack.add(paramObject);
  }
  
  public final boolean selfEvaluatingSymbol(Object paramObject)
  {
    return ((LispLanguage)getLanguage()).selfEvaluatingSymbol(paramObject);
  }
  
  public void setLineOf(Expression paramExpression)
  {
    if ((paramExpression instanceof QuoteExp)) {
      return;
    }
    paramExpression.setLocation(this);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.Translator
 * JD-Core Version:    0.7.0.1
 */