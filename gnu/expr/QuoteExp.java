package gnu.expr;

import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.kawa.util.IdentityHashTable;
import gnu.lists.AbstractFormat;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.mapping.WrongArguments;
import gnu.text.SourceLocator;

public class QuoteExp
  extends Expression
{
  public static final int EXPLICITLY_TYPED = 2;
  public static final int SHARED_CONSTANT = 4;
  public static QuoteExp abstractExp;
  public static final QuoteExp classObjectExp = makeShared(Type.objectType);
  public static QuoteExp falseExp;
  public static QuoteExp nullExp;
  public static QuoteExp trueExp;
  public static QuoteExp undefined_exp = makeShared(Special.undefined);
  public static QuoteExp voidExp;
  protected Type type;
  Object value;
  
  static
  {
    abstractExp = makeShared(Special.abstractSpecial);
    voidExp = makeShared(Values.empty, Type.voidType);
    trueExp = makeShared(Boolean.TRUE);
    falseExp = makeShared(Boolean.FALSE);
    nullExp = makeShared(null, Type.nullType);
  }
  
  public QuoteExp(Object paramObject)
  {
    this.value = paramObject;
  }
  
  public QuoteExp(Object paramObject, Type paramType)
  {
    this.value = paramObject;
    setType(paramType);
  }
  
  public static QuoteExp getInstance(Object paramObject)
  {
    return getInstance(paramObject, null);
  }
  
  public static QuoteExp getInstance(Object paramObject, SourceLocator paramSourceLocator)
  {
    if (paramObject == null) {
      return nullExp;
    }
    if (paramObject == Type.pointer_type) {
      return classObjectExp;
    }
    if (paramObject == Special.undefined) {
      return undefined_exp;
    }
    if (paramObject == Values.empty) {
      return voidExp;
    }
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue()) {
        return trueExp;
      }
      return falseExp;
    }
    QuoteExp localQuoteExp = new QuoteExp(paramObject);
    if (paramSourceLocator != null) {
      localQuoteExp.setLocation(paramSourceLocator);
    }
    return localQuoteExp;
  }
  
  static QuoteExp makeShared(Object paramObject)
  {
    QuoteExp localQuoteExp = new QuoteExp(paramObject);
    localQuoteExp.setFlag(4);
    return localQuoteExp;
  }
  
  static QuoteExp makeShared(Object paramObject, Type paramType)
  {
    QuoteExp localQuoteExp = new QuoteExp(paramObject, paramType);
    localQuoteExp.setFlag(4);
    return localQuoteExp;
  }
  
  public void apply(CallContext paramCallContext)
  {
    paramCallContext.writeValue(this.value);
  }
  
  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    if ((this.type == null) || (this.type == Type.pointer_type) || ((paramTarget instanceof IgnoreTarget)) || (((this.type instanceof ObjectType)) && (this.type.isInstance(this.value))))
    {
      paramCompilation.compileConstant(this.value, paramTarget);
      return;
    }
    paramCompilation.compileConstant(this.value, StackTarget.getInstance(this.type));
    paramTarget.compileFromStack(paramCompilation, this.type);
  }
  
  public Expression deepCopy(IdentityHashTable paramIdentityHashTable)
  {
    return this;
  }
  
  public final Type getRawType()
  {
    return this.type;
  }
  
  public final Type getType()
  {
    if (this.type != null) {
      return this.type;
    }
    if (this.value == Values.empty) {
      return Type.voidType;
    }
    if (this.value == null) {
      return Type.nullType;
    }
    if (this == undefined_exp) {
      return Type.pointer_type;
    }
    return Type.make(this.value.getClass());
  }
  
  public final Object getValue()
  {
    return this.value;
  }
  
  public boolean isExplicitlyTyped()
  {
    return getFlag(2);
  }
  
  public boolean isSharedConstant()
  {
    return getFlag(4);
  }
  
  protected boolean mustCompile()
  {
    return false;
  }
  
  public void print(OutPort paramOutPort)
  {
    paramOutPort.startLogicalBlock("(Quote", ")", 2);
    paramOutPort.writeSpaceLinear();
    Object localObject1 = this.value;
    if ((localObject1 instanceof Expression)) {
      localObject1 = localObject1.toString();
    }
    AbstractFormat localAbstractFormat = paramOutPort.objectFormat;
    try
    {
      paramOutPort.objectFormat = Language.getDefaultLanguage().getFormat(true);
      paramOutPort.print(localObject1);
      if (this.type != null)
      {
        paramOutPort.print(" ::");
        paramOutPort.print(this.type.getName());
      }
      paramOutPort.objectFormat = localAbstractFormat;
      paramOutPort.endLogicalBlock(")");
      return;
    }
    finally
    {
      paramOutPort.objectFormat = localAbstractFormat;
    }
  }
  
  public void setType(Type paramType)
  {
    this.type = paramType;
    setFlag(2);
  }
  
  public boolean side_effects()
  {
    return false;
  }
  
  public String toString()
  {
    return "QuoteExp[" + this.value + "]";
  }
  
  public Expression validateApply(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Declaration paramDeclaration)
  {
    if (this == undefined_exp) {}
    int i;
    label165:
    label249:
    label255:
    PrimProcedure localPrimProcedure;
    do
    {
      Procedure localProcedure;
      Compilation localCompilation;
      do
      {
        do
        {
          return paramApplyExp;
          Object localObject = getValue();
          if (!(localObject instanceof Procedure))
          {
            if ((paramDeclaration == null) || (localObject == null)) {}
            for (String str2 = "called value is not a procedure";; str2 = "calling " + paramDeclaration.getName() + " which is a " + localObject.getClass().getName()) {
              return paramInlineCalls.noteError(str2);
            }
          }
          localProcedure = (Procedure)localObject;
          i = paramApplyExp.getArgCount();
          String str1 = WrongArguments.checkArgCount(localProcedure, i);
          if (str1 != null) {
            return paramInlineCalls.noteError(str1);
          }
          Expression localExpression1 = paramInlineCalls.maybeInline(paramApplyExp, paramType, localProcedure);
          if (localExpression1 != null) {
            return localExpression1;
          }
          Expression[] arrayOfExpression1 = paramApplyExp.args;
          MethodProc localMethodProc;
          int j;
          if ((localProcedure instanceof MethodProc))
          {
            localMethodProc = (MethodProc)localProcedure;
            j = 0;
            if (j >= i) {
              break label255;
            }
            if (localMethodProc == null) {
              break label249;
            }
          }
          for (Type localType = localMethodProc.getParameterType(j);; localType = null)
          {
            if ((j == i - 1) && (localType != null) && (localMethodProc.maxArgs() < 0) && (j == localMethodProc.minArgs())) {
              localType = null;
            }
            arrayOfExpression1[j] = paramInlineCalls.visit(arrayOfExpression1[j], localType);
            j++;
            break label165;
            localMethodProc = null;
            break;
          }
          if (paramApplyExp.getFlag(4))
          {
            Expression localExpression2 = paramApplyExp.inlineIfConstant(localProcedure, paramInlineCalls);
            if (localExpression2 != paramApplyExp) {
              return paramInlineCalls.visit(localExpression2, paramType);
            }
          }
          localCompilation = paramInlineCalls.getCompilation();
        } while (!localCompilation.inlineOk(localProcedure));
        if (ApplyExp.asInlineable(localProcedure) == null) {
          break;
        }
      } while (paramApplyExp.getFunction() == this);
      ApplyExp localApplyExp2 = new ApplyExp(this, paramApplyExp.getArgs());
      return localApplyExp2.setLine(paramApplyExp);
      localPrimProcedure = PrimProcedure.getMethodFor(localProcedure, paramDeclaration, paramApplyExp.args, localCompilation.getLanguage());
    } while (localPrimProcedure == null);
    if ((localPrimProcedure.getStaticFlag()) || (paramDeclaration == null)) {}
    Expression[] arrayOfExpression2;
    for (ApplyExp localApplyExp1 = new ApplyExp(localPrimProcedure, paramApplyExp.args);; localApplyExp1 = new ApplyExp(localPrimProcedure, arrayOfExpression2))
    {
      return localApplyExp1.setLine(paramApplyExp);
      if (paramDeclaration.base == null) {
        break;
      }
      arrayOfExpression2 = new Expression[i + 1];
      System.arraycopy(paramApplyExp.getArgs(), 0, arrayOfExpression2, 1, i);
      arrayOfExpression2[0] = new ReferenceExp(paramDeclaration.base);
    }
  }
  
  public final Object valueIfConstant()
  {
    return this.value;
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    return paramExpVisitor.visitQuoteExp(this, paramD);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.QuoteExp
 * JD-Core Version:    0.7.0.1
 */