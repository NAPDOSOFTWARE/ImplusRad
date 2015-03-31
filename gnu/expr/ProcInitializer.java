package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.LocalVarsAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.mapping.Environment;
import gnu.mapping.PropertySet;
import gnu.mapping.Symbol;

public class ProcInitializer
  extends Initializer
{
  LambdaExp proc;
  
  public ProcInitializer(LambdaExp paramLambdaExp, Compilation paramCompilation, Field paramField)
  {
    this.field = paramField;
    this.proc = paramLambdaExp;
    if (paramField.getStaticFlag()) {}
    for (Object localObject = paramCompilation.getModule(); ((localObject instanceof ModuleExp)) && (paramCompilation.isStatic()); localObject = paramLambdaExp.getOwningLambda())
    {
      this.next = paramCompilation.clinitChain;
      paramCompilation.clinitChain = this;
      return;
    }
    this.next = ((LambdaExp)localObject).initChain;
    ((LambdaExp)localObject).initChain = this;
  }
  
  public static void emitLoadModuleMethod(LambdaExp paramLambdaExp, Compilation paramCompilation)
  {
    Declaration localDeclaration = paramLambdaExp.nameDecl;
    Object localObject1;
    ModuleMethod localModuleMethod;
    Symbol localSymbol;
    label60:
    CodeAttr localCodeAttr;
    ClassType localClassType;
    String str;
    label140:
    Object localObject2;
    label163:
    label193:
    int j;
    label230:
    int m;
    label267:
    Object localObject4;
    Target localTarget;
    if (localDeclaration == null)
    {
      localObject1 = paramLambdaExp.getName();
      boolean bool1 = paramCompilation.immediate;
      localModuleMethod = null;
      if (bool1)
      {
        localModuleMethod = null;
        if (localObject1 != null)
        {
          localModuleMethod = null;
          if (localDeclaration != null)
          {
            Environment localEnvironment = Environment.getCurrent();
            if (!(localObject1 instanceof Symbol)) {
              break label373;
            }
            localSymbol = (Symbol)localObject1;
            Object localObject5 = paramCompilation.getLanguage().getEnvPropertyFor(paramLambdaExp.nameDecl);
            Object localObject6 = localEnvironment.get(localSymbol, localObject5, null);
            boolean bool2 = localObject6 instanceof ModuleMethod;
            localModuleMethod = null;
            if (bool2) {
              localModuleMethod = (ModuleMethod)localObject6;
            }
          }
        }
      }
      localCodeAttr = paramCompilation.getCode();
      localClassType = Compilation.typeModuleMethod;
      if (localModuleMethod != null) {
        break label390;
      }
      localCodeAttr.emitNew(localClassType);
      localCodeAttr.emitDup(1);
      str = "<init>";
      Method localMethod = localClassType.getDeclaredMethod(str, 4);
      if (!paramLambdaExp.getNeedsClosureEnv()) {
        break label408;
      }
      localObject2 = paramLambdaExp.getOwningLambda();
      if ((!(localObject2 instanceof ClassExp)) || (((LambdaExp)localObject2).staticLinkField == null)) {
        break label417;
      }
      localCodeAttr.emitLoad(localCodeAttr.getCurrentScope().getVariable(1));
      localCodeAttr.emitPushInt(paramLambdaExp.getSelectorValue(paramCompilation));
      paramCompilation.compileConstant(localObject1, Target.pushObject);
      int i = paramLambdaExp.min_args;
      if (paramLambdaExp.keywords != null) {
        break label608;
      }
      j = paramLambdaExp.max_args;
      localCodeAttr.emitPushInt(i | j << 12);
      localCodeAttr.emitInvoke(localMethod);
      if (paramLambdaExp.properties == null) {
        return;
      }
      int k = paramLambdaExp.properties.length;
      m = 0;
      if (m >= k) {
        return;
      }
      Object localObject3 = paramLambdaExp.properties[m];
      if ((localObject3 != null) && (localObject3 != PropertySet.nameKey))
      {
        localObject4 = paramLambdaExp.properties[(m + 1)];
        localCodeAttr.emitDup(1);
        paramCompilation.compileConstant(localObject3);
        localTarget = Target.pushObject;
        if (!(localObject4 instanceof Expression)) {
          break label614;
        }
        ((Expression)localObject4).compile(paramCompilation, localTarget);
      }
    }
    for (;;)
    {
      localCodeAttr.emitInvokeVirtual(ClassType.make("gnu.mapping.PropertySet").getDeclaredMethod("setProperty", 2));
      m += 2;
      break label267;
      localObject1 = localDeclaration.getSymbol();
      break;
      label373:
      localSymbol = Symbol.make("", localObject1.toString().intern());
      break label60;
      label390:
      paramCompilation.compileConstant(localModuleMethod, Target.pushValue(localClassType));
      str = "init";
      break label140;
      label408:
      localObject2 = paramCompilation.getModule();
      break label163;
      label417:
      if ((!(localObject2 instanceof ModuleExp)) || ((paramCompilation.moduleClass == paramCompilation.mainClass) && (!paramCompilation.method.getStaticFlag())))
      {
        localCodeAttr.emitPushThis();
        break label193;
      }
      if (paramCompilation.moduleInstanceVar == null)
      {
        paramCompilation.moduleInstanceVar = localCodeAttr.locals.current_scope.addVariable(localCodeAttr, paramCompilation.moduleClass, "$instance");
        if ((paramCompilation.moduleClass == paramCompilation.mainClass) || (paramCompilation.isStatic())) {
          break label596;
        }
        localCodeAttr.emitNew(paramCompilation.moduleClass);
        localCodeAttr.emitDup(paramCompilation.moduleClass);
        localCodeAttr.emitInvokeSpecial(paramCompilation.moduleClass.constructor);
        paramCompilation.moduleInstanceMainField = paramCompilation.moduleClass.addField("$main", paramCompilation.mainClass, 0);
        localCodeAttr.emitDup(paramCompilation.moduleClass);
        localCodeAttr.emitPushThis();
        localCodeAttr.emitPutField(paramCompilation.moduleInstanceMainField);
      }
      for (;;)
      {
        localCodeAttr.emitStore(paramCompilation.moduleInstanceVar);
        localCodeAttr.emitLoad(paramCompilation.moduleInstanceVar);
        break;
        label596:
        localCodeAttr.emitGetStatic(paramCompilation.moduleInstanceMainField);
      }
      label608:
      j = -1;
      break label230;
      label614:
      paramCompilation.compileConstant(localObject4, localTarget);
    }
  }
  
  public void emit(Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    if (!this.field.getStaticFlag()) {
      localCodeAttr.emitPushThis();
    }
    emitLoadModuleMethod(this.proc, paramCompilation);
    if (this.field.getStaticFlag())
    {
      localCodeAttr.emitPutStatic(this.field);
      return;
    }
    localCodeAttr.emitPutField(this.field);
  }
  
  public void reportError(String paramString, Compilation paramCompilation)
  {
    String str1 = paramCompilation.getFileName();
    int i = paramCompilation.getLineNumber();
    int j = paramCompilation.getColumnNumber();
    paramCompilation.setLocation(this.proc);
    String str2 = this.proc.getName();
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    if (str2 == null) {
      localStringBuffer.append("unnamed procedure");
    }
    for (;;)
    {
      paramCompilation.error('e', localStringBuffer.toString());
      paramCompilation.setLine(str1, i, j);
      return;
      localStringBuffer.append("procedure ");
      localStringBuffer.append(str2);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ProcInitializer
 * JD-Core Version:    0.7.0.1
 */