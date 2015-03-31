package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;

public class BindingInitializer
  extends Initializer
{
  static final ClassType typeThreadLocation = ClassType.make("gnu.mapping.ThreadLocation");
  Declaration decl;
  Expression value;
  
  public BindingInitializer(Declaration paramDeclaration, Expression paramExpression)
  {
    this.decl = paramDeclaration;
    this.value = paramExpression;
    this.field = paramDeclaration.field;
  }
  
  public static void create(Declaration paramDeclaration, Expression paramExpression, Compilation paramCompilation)
  {
    BindingInitializer localBindingInitializer = new BindingInitializer(paramDeclaration, paramExpression);
    if (paramDeclaration.field != null)
    {
      if (!paramDeclaration.field.getStaticFlag()) {}
    }
    else {
      while (paramDeclaration.isStatic())
      {
        localBindingInitializer.next = paramCompilation.clinitChain;
        paramCompilation.clinitChain = localBindingInitializer;
        return;
      }
    }
    localBindingInitializer.next = paramCompilation.mainLambda.initChain;
    paramCompilation.mainLambda.initChain = localBindingInitializer;
  }
  
  public static Method makeLocationMethod(Object paramObject)
  {
    Type[] arrayOfType = new Type[1];
    if ((paramObject instanceof Symbol)) {
      arrayOfType[0] = Compilation.typeSymbol;
    }
    for (;;)
    {
      return Compilation.typeLocation.getDeclaredMethod("make", arrayOfType);
      arrayOfType[0] = Type.javalangStringType;
    }
  }
  
  public void emit(Compilation paramCompilation)
  {
    if (this.decl.ignorable()) {
      if (this.value != null) {
        this.value.compile(paramCompilation, Target.Ignore);
      }
    }
    CodeAttr localCodeAttr;
    Object localObject3;
    do
    {
      return;
      localCodeAttr = paramCompilation.getCode();
      if (!(this.value instanceof QuoteExp)) {
        break;
      }
      localObject3 = ((QuoteExp)this.value).getValue();
    } while ((localObject3 != null) && (!(localObject3 instanceof String)) && (paramCompilation.litTable.findLiteral(localObject3).field == this.field));
    int i = this.decl.getLineNumber();
    SourceMessages localSourceMessages = paramCompilation.getMessages();
    SourceLocator localSourceLocator = localSourceMessages.swapSourceLocator(this.decl);
    if (i > 0) {
      localCodeAttr.putLineNumber(this.decl.getFileName(), i);
    }
    if ((this.field != null) && (!this.field.getStaticFlag())) {
      localCodeAttr.emitPushThis();
    }
    Object localObject1;
    Object localObject2;
    if (this.value == null) {
      if ((paramCompilation.getLanguage().hasSeparateFunctionNamespace()) && (this.decl.isProcedureDecl()))
      {
        localObject1 = EnvironmentKey.FUNCTION;
        localObject2 = this.decl.getSymbol();
        if (!this.decl.getFlag(268500992L)) {
          break label320;
        }
        if ((localObject2 instanceof String)) {
          localObject2 = Namespace.EmptyNamespace.getSymbol((String)localObject2);
        }
        paramCompilation.compileConstant(localObject2, Target.pushObject);
        if (localObject1 != null) {
          break label308;
        }
        localCodeAttr.emitPushNull();
        label243:
        localCodeAttr.emitInvokeStatic(typeThreadLocation.getDeclaredMethod("getInstance", 2));
        label256:
        if (this.field != null) {
          break label454;
        }
        Variable localVariable = this.decl.getVariable();
        if (localVariable == null) {
          localVariable = this.decl.allocateVariable(localCodeAttr);
        }
        localCodeAttr.emitStore(localVariable);
      }
    }
    for (;;)
    {
      localSourceMessages.swapSourceLocator(localSourceLocator);
      return;
      localObject1 = null;
      break;
      label308:
      paramCompilation.compileConstant(localObject1, Target.pushObject);
      break label243;
      label320:
      if (this.decl.isFluid())
      {
        Type[] arrayOfType = new Type[1];
        if ((localObject2 instanceof Symbol)) {}
        for (ClassType localClassType = Compilation.typeSymbol;; localClassType = Type.toStringType)
        {
          arrayOfType[0] = localClassType;
          paramCompilation.compileConstant(localObject2, Target.pushObject);
          localCodeAttr.emitInvokeStatic(typeThreadLocation.getDeclaredMethod("makeAnonymous", arrayOfType));
          break;
        }
      }
      paramCompilation.compileConstant(localObject2, Target.pushObject);
      localCodeAttr.emitInvokeStatic(makeLocationMethod(localObject2));
      break label256;
      if (this.field == null) {}
      for (Type localType = this.decl.getType();; localType = this.field.getType())
      {
        this.value.compileWithPosition(paramCompilation, StackTarget.getInstance(localType));
        break;
      }
      label454:
      if (this.field.getStaticFlag()) {
        localCodeAttr.emitPutStatic(this.field);
      } else {
        localCodeAttr.emitPutField(this.field);
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.BindingInitializer
 * JD-Core Version:    0.7.0.1
 */