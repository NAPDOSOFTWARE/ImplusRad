package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.mapping.OutPort;
import java.util.Hashtable;
import java.util.Vector;

public class ClassExp
  extends LambdaExp
{
  public static final int CLASS_SPECIFIED = 65536;
  public static final int HAS_SUBCLASS = 131072;
  public static final int INTERFACE_SPECIFIED = 32768;
  public static final int IS_ABSTRACT = 16384;
  public String classNameSpecifier;
  public LambdaExp clinitMethod;
  boolean explicitInit;
  public LambdaExp initMethod;
  ClassType instanceType;
  boolean partsDeclared;
  boolean simple;
  public int superClassIndex = -1;
  public Expression[] supers;
  
  public ClassExp() {}
  
  public ClassExp(boolean paramBoolean)
  {
    this.simple = paramBoolean;
    ClassType localClassType = new ClassType();
    this.type = localClassType;
    this.instanceType = localClassType;
  }
  
  static void getImplMethods(ClassType paramClassType, String paramString, Type[] paramArrayOfType, Vector paramVector)
  {
    ClassType localClassType;
    if ((paramClassType instanceof PairClassType))
    {
      localClassType = ((PairClassType)paramClassType).instanceType;
      Type[] arrayOfType = new Type[1 + paramArrayOfType.length];
      arrayOfType[0] = paramClassType;
      System.arraycopy(paramArrayOfType, 0, arrayOfType, 1, paramArrayOfType.length);
      Method localMethod = localClassType.getDeclaredMethod(paramString, arrayOfType);
      if (localMethod == null) {
        break label152;
      }
      int j = paramVector.size();
      if ((j == 0) || (!paramVector.elementAt(j - 1).equals(localMethod))) {
        paramVector.addElement(localMethod);
      }
    }
    for (;;)
    {
      for (;;)
      {
        return;
        if (paramClassType.isInterface()) {
          try
          {
            Class localClass = paramClassType.getReflectClass();
            if (localClass != null) {
              localClassType = (ClassType)Type.make(Class.forName(paramClassType.getName() + "$class", false, localClass.getClassLoader()));
            }
          }
          catch (Throwable localThrowable)
          {
            return;
          }
        }
      }
      label152:
      ClassType[] arrayOfClassType = paramClassType.getInterfaces();
      for (int i = 0; i < arrayOfClassType.length; i++) {
        getImplMethods(arrayOfClassType[i], paramString, paramArrayOfType, paramVector);
      }
    }
  }
  
  static void invokeDefaultSuperConstructor(ClassType paramClassType, Compilation paramCompilation, LambdaExp paramLambdaExp)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Method localMethod = paramClassType.getDeclaredMethod("<init>", 0);
    if (localMethod == null)
    {
      paramCompilation.error('e', "super class does not have a default constructor");
      return;
    }
    localCodeAttr.emitPushThis();
    if ((paramClassType.hasOuterLink()) && ((paramLambdaExp instanceof ClassExp)))
    {
      ClassExp localClassExp = (ClassExp)paramLambdaExp;
      loadSuperStaticLink(localClassExp.supers[localClassExp.superClassIndex], paramClassType, paramCompilation);
    }
    localCodeAttr.emitInvokeSpecial(localMethod);
  }
  
  static void loadSuperStaticLink(Expression paramExpression, ClassType paramClassType, Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    paramExpression.compile(paramCompilation, Target.pushValue(Compilation.typeClassType));
    localCodeAttr.emitInvokeStatic(ClassType.make("gnu.expr.PairClassType").getDeclaredMethod("extractStaticLink", 1));
    localCodeAttr.emitCheckcast(paramClassType.getOuterLinkType());
  }
  
  public static String slotToMethodName(String paramString1, String paramString2)
  {
    if (!Compilation.isValidJavaName(paramString2)) {
      paramString2 = Compilation.mangleName(paramString2, false);
    }
    int i = paramString2.length();
    StringBuffer localStringBuffer = new StringBuffer(i + 3);
    localStringBuffer.append(paramString1);
    if (i > 0)
    {
      localStringBuffer.append(Character.toTitleCase(paramString2.charAt(0)));
      localStringBuffer.append(paramString2.substring(1));
    }
    return localStringBuffer.toString();
  }
  
  private static void usedSuperClasses(ClassType paramClassType, Compilation paramCompilation)
  {
    paramCompilation.usedClass(paramClassType.getSuperclass());
    ClassType[] arrayOfClassType = paramClassType.getInterfaces();
    if (arrayOfClassType != null)
    {
      int i = arrayOfClassType.length;
      for (;;)
      {
        i--;
        if (i < 0) {
          break;
        }
        paramCompilation.usedClass(arrayOfClassType[i]);
      }
    }
  }
  
  public Declaration addMethod(LambdaExp paramLambdaExp, Object paramObject)
  {
    Declaration localDeclaration = addDeclaration(paramObject, Compilation.typeProcedure);
    paramLambdaExp.outer = this;
    paramLambdaExp.setClassMethod(true);
    localDeclaration.noteValue(paramLambdaExp);
    localDeclaration.setFlag(1048576L);
    localDeclaration.setProcedureDecl(true);
    paramLambdaExp.setSymbol(paramObject);
    return localDeclaration;
  }
  
  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    if ((paramTarget instanceof IgnoreTarget)) {
      return;
    }
    compileMembers(paramCompilation);
    compilePushClass(paramCompilation, paramTarget);
  }
  
  public ClassType compileMembers(Compilation paramCompilation)
  {
    ClassType localClassType1 = paramCompilation.curClass;
    Method localMethod1 = paramCompilation.method;
    ClassType localClassType2;
    LambdaExp localLambdaExp2;
    for (;;)
    {
      LambdaExp localLambdaExp3;
      ClassType localClassType4;
      try
      {
        localClassType2 = getCompiledClassType(paramCompilation);
        paramCompilation.curClass = localClassType2;
        LambdaExp localLambdaExp1 = outerLambda();
        Object localObject2;
        if ((localLambdaExp1 instanceof ClassExp))
        {
          localObject2 = localLambdaExp1.type;
          if (localObject2 != null)
          {
            localClassType2.setEnclosingMember((Member)localObject2);
            if ((localObject2 instanceof ClassType)) {
              ((ClassType)localObject2).addMemberClass(localClassType2);
            }
          }
          if (this.instanceType != localClassType2)
          {
            this.instanceType.setEnclosingMember(this.type);
            this.type.addMemberClass(this.instanceType);
          }
          usedSuperClasses(this.type, paramCompilation);
          if (this.type != this.instanceType) {
            usedSuperClasses(this.instanceType, paramCompilation);
          }
          String str1 = getFileName();
          if (str1 != null) {
            localClassType2.setSourceFile(str1);
          }
          localLambdaExp2 = paramCompilation.curLambda;
          paramCompilation.curLambda = this;
          allocFrame(paramCompilation);
          localLambdaExp3 = this.firstChild;
          if (localLambdaExp3 == null) {
            break;
          }
          if (localLambdaExp3.isAbstract())
          {
            localLambdaExp3 = localLambdaExp3.nextSibling;
            continue;
          }
        }
        else
        {
          if ((localLambdaExp1 != null) && (!(localLambdaExp1 instanceof ModuleExp)))
          {
            localObject2 = localMethod1;
            continue;
          }
          boolean bool6 = localLambdaExp1 instanceof ModuleExp;
          localObject2 = null;
          if (!bool6) {
            continue;
          }
          int i1 = this.type.getName().indexOf('$');
          localObject2 = null;
          if (i1 <= 0) {
            continue;
          }
          localObject2 = localLambdaExp1.type;
          continue;
        }
        Method localMethod2 = paramCompilation.method;
        LambdaExp localLambdaExp4 = paramCompilation.curLambda;
        String str2 = paramCompilation.getFileName();
        int i = paramCompilation.getLineNumber();
        int j = paramCompilation.getColumnNumber();
        paramCompilation.setLine(localLambdaExp3);
        paramCompilation.method = localLambdaExp3.getMainMethod();
        Declaration localDeclaration = localLambdaExp3.nameDecl;
        if ((localDeclaration == null) || (!localDeclaration.getFlag(2048L))) {
          localLambdaExp3.declareThis(paramCompilation.curClass);
        }
        paramCompilation.curClass = this.instanceType;
        paramCompilation.curLambda = localLambdaExp3;
        paramCompilation.method.initCode();
        localLambdaExp3.allocChildClasses(paramCompilation);
        localLambdaExp3.allocParameters(paramCompilation);
        if (!"*init*".equals(localLambdaExp3.getName())) {
          break label772;
        }
        CodeAttr localCodeAttr1 = paramCompilation.getCode();
        if (this.staticLinkField != null)
        {
          localCodeAttr1.emitPushThis();
          localCodeAttr1.emitLoad(localCodeAttr1.getCurrentScope().getVariable(1));
          localCodeAttr1.emitPutField(this.staticLinkField);
        }
        Expression localExpression1 = localLambdaExp3.body;
        if ((localExpression1 instanceof BeginExp))
        {
          BeginExp localBeginExp = (BeginExp)localExpression1;
          if (localBeginExp.length == 0)
          {
            localExpression1 = null;
            continue;
          }
          localExpression1 = localBeginExp.exps[0];
          continue;
        }
        boolean bool1 = localExpression1 instanceof ApplyExp;
        ClassType localClassType3 = null;
        if (bool1)
        {
          Expression localExpression2 = ((ApplyExp)localExpression1).func;
          boolean bool2 = localExpression2 instanceof QuoteExp;
          localClassType3 = null;
          if (bool2)
          {
            Object localObject3 = ((QuoteExp)localExpression2).getValue();
            boolean bool3 = localObject3 instanceof PrimProcedure;
            localClassType3 = null;
            if (bool3)
            {
              PrimProcedure localPrimProcedure = (PrimProcedure)localObject3;
              boolean bool4 = localPrimProcedure.isSpecial();
              localClassType3 = null;
              if (bool4)
              {
                boolean bool5 = "<init>".equals(localPrimProcedure.method.getName());
                localClassType3 = null;
                if (bool5) {
                  localClassType3 = localPrimProcedure.method.getDeclaringClass();
                }
              }
            }
          }
        }
        localClassType4 = this.instanceType.getSuperclass();
        if (localClassType3 != null)
        {
          localExpression1.compileWithPosition(paramCompilation, Target.Ignore);
          if ((localClassType3 != this.instanceType) && (localClassType3 != localClassType4)) {
            paramCompilation.error('e', "call to <init> for not this or super class");
          }
          localLambdaExp3.enterFunction(paramCompilation);
          if (localClassType3 != this.instanceType) {
            paramCompilation.callInitMethods(getCompiledClassType(paramCompilation), new Vector(10));
          }
          if (localClassType3 == null) {
            break label763;
          }
          Expression.compileButFirst(localLambdaExp3.body, paramCompilation);
          localLambdaExp3.compileEnd(paramCompilation);
          localLambdaExp3.generateApplyMethods(paramCompilation);
          paramCompilation.method = localMethod2;
          paramCompilation.curClass = localClassType2;
          paramCompilation.curLambda = localLambdaExp4;
          paramCompilation.setLine(str2, i, j);
          continue;
        }
        if (localClassType4 == null) {
          continue;
        }
      }
      finally
      {
        paramCompilation.curClass = localClassType1;
        paramCompilation.method = localMethod1;
      }
      invokeDefaultSuperConstructor(localClassType4, paramCompilation, this);
      continue;
      label763:
      localLambdaExp3.compileBody(paramCompilation);
      continue;
      label772:
      localLambdaExp3.enterFunction(paramCompilation);
      localLambdaExp3.compileBody(paramCompilation);
    }
    if ((!this.explicitInit) && (!this.instanceType.isInterface())) {
      paramCompilation.generateConstructor(this.instanceType, this);
    }
    int m;
    Method localMethod3;
    String str3;
    Type[] arrayOfType;
    Type localType1;
    while (isAbstract())
    {
      arrayOfMethod = null;
      k = 0;
      break label1332;
      if (m >= k) {
        break label1308;
      }
      localMethod3 = arrayOfMethod[m];
      str3 = localMethod3.getName();
      arrayOfType = localMethod3.getParameterTypes();
      localType1 = localMethod3.getReturnType();
      Method localMethod4 = this.instanceType.getMethod(str3, arrayOfType);
      if ((localMethod4 == null) || (localMethod4.isAbstract())) {
        break label931;
      }
      break label1338;
      if (this.initChain != null) {
        this.initChain.reportError("unimplemented: explicit constructor cannot initialize ", paramCompilation);
      }
    }
    Method[] arrayOfMethod = this.type.getAbstractMethods();
    int k = arrayOfMethod.length;
    break label1332;
    label931:
    if ((str3.length() > 3) && (str3.charAt(2) == 't') && (str3.charAt(1) == 'e'))
    {
      int n = str3.charAt(0);
      if ((n == 103) || (n == 115))
      {
        Type localType2;
        Field localField;
        CodeAttr localCodeAttr3;
        if ((n == 115) && (localType1.isVoid()) && (arrayOfType.length == 1))
        {
          localType2 = arrayOfType[0];
          String str5 = Character.toLowerCase(str3.charAt(3)) + str3.substring(4);
          localField = this.instanceType.getField(str5);
          if (localField == null) {
            localField = this.instanceType.addField(str5, localType2, 1);
          }
          localCodeAttr3 = this.instanceType.addMethod(str3, 1, arrayOfType, localType1).startCode();
          localCodeAttr3.emitPushThis();
          if (n != 103) {
            break label1141;
          }
          localCodeAttr3.emitGetField(localField);
        }
        for (;;)
        {
          localCodeAttr3.emitReturn();
          break label1338;
          if ((n != 103) || (arrayOfType.length != 0)) {
            break label1338;
          }
          localType2 = localType1;
          break;
          label1141:
          localCodeAttr3.emitLoad(localCodeAttr3.getArg(1));
          localCodeAttr3.emitPutField(localField);
        }
      }
    }
    Vector localVector = new Vector();
    getImplMethods(this.type, str3, arrayOfType, localVector);
    if (localVector.size() != 1) {
      if (localVector.size() != 0) {
        break label1344;
      }
    }
    label1308:
    label1332:
    label1338:
    label1344:
    for (String str4 = "missing implementation for ";; str4 = "ambiguous implementation for ")
    {
      paramCompilation.error('e', str4 + localMethod3);
      break label1338;
      CodeAttr localCodeAttr2 = this.instanceType.addMethod(str3, 1, arrayOfType, localType1).startCode();
      for (Variable localVariable = localCodeAttr2.getCurrentScope().firstVar(); localVariable != null; localVariable = localVariable.nextVar()) {
        localCodeAttr2.emitLoad(localVariable);
      }
      localCodeAttr2.emitInvokeStatic((Method)localVector.elementAt(0));
      localCodeAttr2.emitReturn();
      break label1338;
      generateApplyMethods(paramCompilation);
      paramCompilation.curLambda = localLambdaExp2;
      paramCompilation.curClass = localClassType1;
      paramCompilation.method = localMethod1;
      return localClassType2;
      m = 0;
      break;
      m++;
      break;
    }
  }
  
  public void compilePushClass(Compilation paramCompilation, Target paramTarget)
  {
    ClassType localClassType1 = this.type;
    CodeAttr localCodeAttr = paramCompilation.getCode();
    paramCompilation.loadClassRef(localClassType1);
    boolean bool = getNeedsClosureEnv();
    if ((isSimple()) && (!bool)) {
      return;
    }
    ClassType localClassType2;
    int i;
    if ((isMakingClassPair()) || (bool)) {
      if (localClassType1 == this.instanceType)
      {
        localCodeAttr.emitDup(this.instanceType);
        localClassType2 = ClassType.make("gnu.expr.PairClassType");
        if (!bool) {
          break label147;
        }
        i = 3;
      }
    }
    Type[] arrayOfType;
    for (;;)
    {
      arrayOfType = new Type[i];
      if (bool)
      {
        getOwningLambda().loadHeapFrame(paramCompilation);
        i--;
        arrayOfType[i] = Type.pointer_type;
      }
      ClassType localClassType3 = ClassType.make("java.lang.Class");
      for (;;)
      {
        i--;
        if (i < 0) {
          break;
        }
        arrayOfType[i] = localClassType3;
      }
      paramCompilation.loadClassRef(this.instanceType);
      break;
      label147:
      i = 2;
      continue;
      localClassType2 = ClassType.make("gnu.bytecode.Type");
      i = 1;
    }
    localCodeAttr.emitInvokeStatic(localClassType2.addMethod("make", arrayOfType, localClassType2, 9));
    paramTarget.compileFromStack(paramCompilation, localClassType2);
  }
  
  public Field compileSetField(Compilation paramCompilation)
  {
    return new ClassInitializer(this, paramCompilation).field;
  }
  
  public void declareParts(Compilation paramCompilation)
  {
    if (this.partsDeclared) {}
    label154:
    do
    {
      return;
      this.partsDeclared = true;
      Hashtable localHashtable = new Hashtable();
      Declaration localDeclaration1 = firstDecl();
      if (localDeclaration1 != null)
      {
        int i;
        if (localDeclaration1.getCanRead())
        {
          i = localDeclaration1.getAccessFlags((short)1);
          if (localDeclaration1.getFlag(2048L)) {
            i |= 0x8;
          }
          if (!isMakingClassPair()) {
            break label154;
          }
          int j = i | 0x400;
          Type localType = localDeclaration1.getType().getImplementationType();
          this.type.addMethod(slotToMethodName("get", localDeclaration1.getName()), j, Type.typeArray0, localType);
          Type[] arrayOfType = { localType };
          this.type.addMethod(slotToMethodName("set", localDeclaration1.getName()), j, arrayOfType, Type.voidType);
        }
        for (;;)
        {
          localDeclaration1 = localDeclaration1.nextDecl();
          break;
          String str = Compilation.mangleNameIfNeeded(localDeclaration1.getName());
          localDeclaration1.field = this.instanceType.addField(str, localDeclaration1.getType(), i);
          localDeclaration1.setSimple(false);
          Declaration localDeclaration2 = (Declaration)localHashtable.get(str);
          if (localDeclaration2 != null) {
            duplicateDeclarationError(localDeclaration2, localDeclaration1, paramCompilation);
          }
          localHashtable.put(str, localDeclaration1);
        }
      }
      for (LambdaExp localLambdaExp = this.firstChild; localLambdaExp != null; localLambdaExp = localLambdaExp.nextSibling)
      {
        if (localLambdaExp.isAbstract()) {
          setFlag(16384);
        }
        if ("*init*".equals(localLambdaExp.getName()))
        {
          this.explicitInit = true;
          if (localLambdaExp.isAbstract()) {
            paramCompilation.error('e', "*init* method cannot be abstract", localLambdaExp);
          }
          if ((this.type instanceof PairClassType)) {
            paramCompilation.error('e', "'*init*' methods only supported for simple classes");
          }
        }
        localLambdaExp.outer = this;
        if (((localLambdaExp != this.initMethod) && (localLambdaExp != this.clinitMethod) && (localLambdaExp.nameDecl != null) && (!localLambdaExp.nameDecl.getFlag(2048L))) || (!isMakingClassPair())) {
          localLambdaExp.addMethodFor(this.type, paramCompilation, null);
        }
        if (isMakingClassPair()) {
          localLambdaExp.addMethodFor(this.instanceType, paramCompilation, this.type);
        }
      }
      if ((!this.explicitInit) && (!this.instanceType.isInterface())) {
        Compilation.getConstructor(this.instanceType, this);
      }
      if (isAbstract()) {
        this.instanceType.setModifiers(0x400 | this.instanceType.getModifiers());
      }
    } while (this.nameDecl == null);
    this.instanceType.setModifiers(0xFFFFFFFE & this.instanceType.getModifiers() | this.nameDecl.getAccessFlags((short)1));
  }
  
  public ClassType getClassType()
  {
    return this.type;
  }
  
  protected ClassType getCompiledClassType(Compilation paramCompilation)
  {
    return this.type;
  }
  
  public Type getType()
  {
    if (this.simple) {
      return Compilation.typeClass;
    }
    return Compilation.typeClassType;
  }
  
  public final boolean isAbstract()
  {
    return getFlag(16384);
  }
  
  public boolean isMakingClassPair()
  {
    return this.type != this.instanceType;
  }
  
  public boolean isSimple()
  {
    return this.simple;
  }
  
  protected boolean mustCompile()
  {
    return true;
  }
  
  public void print(OutPort paramOutPort)
  {
    paramOutPort.startLogicalBlock("(" + getExpClassName() + "/", ")", 2);
    Object localObject = getSymbol();
    if (localObject != null)
    {
      paramOutPort.print(localObject);
      paramOutPort.print('/');
    }
    paramOutPort.print(this.id);
    paramOutPort.print("/fl:");
    paramOutPort.print(Integer.toHexString(this.flags));
    if (this.supers.length > 0)
    {
      paramOutPort.writeSpaceFill();
      paramOutPort.startLogicalBlock("supers:", "", 2);
      for (int j = 0; j < this.supers.length; j++)
      {
        this.supers[j].print(paramOutPort);
        paramOutPort.writeSpaceFill();
      }
      paramOutPort.endLogicalBlock("");
    }
    paramOutPort.print('(');
    int i = 0;
    if (this.keywords == null) {}
    for (;;)
    {
      for (Declaration localDeclaration = firstDecl(); localDeclaration != null; localDeclaration = localDeclaration.nextDecl())
      {
        if (i > 0) {
          paramOutPort.print(' ');
        }
        localDeclaration.printInfo(paramOutPort);
        i++;
      }
      this.keywords.length;
    }
    paramOutPort.print(") ");
    for (LambdaExp localLambdaExp = this.firstChild; localLambdaExp != null; localLambdaExp = localLambdaExp.nextSibling)
    {
      paramOutPort.writeBreakLinear();
      localLambdaExp.print(paramOutPort);
    }
    if (this.body != null)
    {
      paramOutPort.writeBreakLinear();
      this.body.print(paramOutPort);
    }
    paramOutPort.endLogicalBlock(")");
  }
  
  public void setSimple(boolean paramBoolean)
  {
    this.simple = paramBoolean;
  }
  
  public void setTypes(Compilation paramCompilation)
  {
    int i;
    ClassType[] arrayOfClassType1;
    Object localObject;
    int j;
    int k;
    label23:
    Type localType;
    int i9;
    if (this.supers == null)
    {
      i = 0;
      arrayOfClassType1 = new ClassType[i];
      localObject = null;
      j = 0;
      k = 0;
      if (j >= i) {
        break label232;
      }
      localType = Language.getDefaultLanguage().getTypeFor(this.supers[j]);
      if ((localType instanceof ClassType)) {
        break label95;
      }
      paramCompilation.setLine(this.supers[j]);
      paramCompilation.error('e', "invalid super type");
      i9 = k;
    }
    label95:
    ClassType localClassType2;
    for (;;)
    {
      j++;
      k = i9;
      break label23;
      i = this.supers.length;
      break;
      localClassType2 = (ClassType)localType;
      try
      {
        int i10 = localClassType2.getModifiers();
        i8 = i10;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          int i8 = 0;
          if (paramCompilation != null)
          {
            paramCompilation.error('e', "unknown super-type " + localClassType2.getName());
            i8 = 0;
          }
        }
        i9 = k + 1;
        arrayOfClassType1[k] = localClassType2;
      }
      if ((i8 & 0x200) == 0)
      {
        if (k < j) {
          paramCompilation.error('e', "duplicate superclass for " + this);
        }
        localObject = localClassType2;
        this.superClassIndex = j;
        i9 = k;
      }
    }
    label232:
    if ((localObject != null) && ((0x8000 & this.flags) != 0)) {
      paramCompilation.error('e', "cannot be interface since has superclass");
    }
    ClassType[] arrayOfClassType2;
    label399:
    String str1;
    label431:
    StringBuffer localStringBuffer1;
    int n;
    int i1;
    label487:
    String str2;
    if ((!this.simple) && (localObject == null) && ((0x10000 & this.flags) == 0) && ((getFlag(131072)) || ((this.nameDecl != null) && (this.nameDecl.isPublic()))))
    {
      PairClassType localPairClassType = new PairClassType();
      this.type = localPairClassType;
      localPairClassType.setInterface(true);
      localPairClassType.instanceType = this.instanceType;
      ClassType[] arrayOfClassType3 = new ClassType[1];
      arrayOfClassType3[0] = this.type;
      this.instanceType.setSuper(Type.pointer_type);
      this.instanceType.setInterfaces(arrayOfClassType3);
      ClassType localClassType1 = this.type;
      if (localObject == null) {
        localObject = Type.pointer_type;
      }
      localClassType1.setSuper((ClassType)localObject);
      if (k != i) {
        break label596;
      }
      arrayOfClassType2 = arrayOfClassType1;
      this.type.setInterfaces(arrayOfClassType2);
      if (this.type.getName() == null)
      {
        if (this.classNameSpecifier == null) {
          break label616;
        }
        str1 = this.classNameSpecifier;
        if (str1 != null) {
          break label693;
        }
        localStringBuffer1 = new StringBuffer(100);
        paramCompilation.getModule().classFor(paramCompilation);
        localStringBuffer1.append(paramCompilation.mainClass.getName());
        localStringBuffer1.append('$');
        n = localStringBuffer1.length();
        i1 = 0;
        localStringBuffer1.append(i1);
        str2 = localStringBuffer1.toString();
        if (paramCompilation.findNamedClass(str2) != null) {
          break label680;
        }
      }
    }
    for (;;)
    {
      this.type.setName(str2);
      paramCompilation.addClass(this.type);
      if (isMakingClassPair())
      {
        this.instanceType.setName(this.type.getName() + "$class");
        paramCompilation.addClass(this.instanceType);
      }
      return;
      if (!getFlag(32768)) {
        break;
      }
      this.instanceType.setInterface(true);
      break;
      label596:
      arrayOfClassType2 = new ClassType[k];
      System.arraycopy(arrayOfClassType1, 0, arrayOfClassType2, 0, k);
      break label399;
      label616:
      str1 = getName();
      if (str1 == null) {
        break label431;
      }
      int m = str1.length();
      if ((m <= 2) || (str1.charAt(0) != '<') || (str1.charAt(m - 1) != '>')) {
        break label431;
      }
      str1 = str1.substring(1, m - 1);
      break label431;
      label680:
      localStringBuffer1.setLength(n);
      i1++;
      break label487;
      label693:
      if ((isSimple()) && (!(this instanceof ObjectExp))) {
        break label718;
      }
      str2 = paramCompilation.generateClassName(str1);
    }
    label718:
    int i2 = 0;
    StringBuffer localStringBuffer2 = new StringBuffer(100);
    label732:
    int i3 = str1.indexOf('.', i2);
    String str3;
    label763:
    int i7;
    if (i3 < 0)
    {
      if (i2 != 0) {
        break label925;
      }
      if (paramCompilation.mainClass != null) {
        break label881;
      }
      str3 = null;
      if (str3 != null) {
        break label893;
      }
      i7 = -1;
      label771:
      if (i7 <= 0) {
        break label905;
      }
      localStringBuffer2.append(str3.substring(0, i7 + 1));
    }
    for (;;)
    {
      int i6 = str1.length();
      if (i2 < i6) {
        localStringBuffer2.append(Compilation.mangleNameIfNeeded(str1.substring(i2)));
      }
      str2 = localStringBuffer2.toString();
      break;
      localStringBuffer2.append(Compilation.mangleNameIfNeeded(str1.substring(i2, i3)));
      i2 = i3 + 1;
      int i4 = str1.length();
      if (i2 >= i4) {
        break label732;
      }
      localStringBuffer2.append('.');
      break label732;
      label881:
      str3 = paramCompilation.mainClass.getName();
      break label763;
      label893:
      i7 = str3.lastIndexOf('.');
      break label771;
      label905:
      if (paramCompilation.classPrefix != null)
      {
        localStringBuffer2.append(paramCompilation.classPrefix);
        continue;
        label925:
        if (i2 == 1)
        {
          int i5 = str1.length();
          if (i2 < i5)
          {
            localStringBuffer2.setLength(0);
            localStringBuffer2.append(paramCompilation.mainClass.getName());
            localStringBuffer2.append('$');
          }
        }
      }
    }
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    Compilation localCompilation = paramExpVisitor.getCompilation();
    if (localCompilation == null) {
      return paramExpVisitor.visitClassExp(this, paramD);
    }
    ClassType localClassType = localCompilation.curClass;
    try
    {
      localCompilation.curClass = this.type;
      Object localObject2 = paramExpVisitor.visitClassExp(this, paramD);
      return localObject2;
    }
    finally
    {
      localCompilation.curClass = localClassType;
    }
  }
  
  protected <R, D> void visitChildren(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    LambdaExp localLambdaExp1 = paramExpVisitor.currentLambda;
    paramExpVisitor.currentLambda = this;
    this.supers = paramExpVisitor.visitExps(this.supers, this.supers.length, paramD);
    try
    {
      for (LambdaExp localLambdaExp2 = this.firstChild; (localLambdaExp2 != null) && (paramExpVisitor.exitValue == null); localLambdaExp2 = localLambdaExp2.nextSibling)
      {
        if (this.instanceType != null)
        {
          Declaration localDeclaration = localLambdaExp2.firstDecl();
          if ((localDeclaration != null) && (localDeclaration.isThisParameter())) {
            localDeclaration.setType(this.type);
          }
        }
        paramExpVisitor.visitLambdaExp(localLambdaExp2, paramD);
      }
      return;
    }
    finally
    {
      paramExpVisitor.currentLambda = localLambdaExp1;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ClassExp
 * JD-Core Version:    0.7.0.1
 */