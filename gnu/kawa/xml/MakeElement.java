package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.Special;
import gnu.expr.Target;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Symbol;
import gnu.xml.NamespaceBinding;
import gnu.xml.XMLFilter;
import gnu.xml.XName;

public class MakeElement
  extends NodeConstructor
{
  static final Method endElementMethod = typeMakeElement.getDeclaredMethod("endElement", 2);
  public static final MakeElement makeElement = new MakeElement();
  static final Method startElementMethod3;
  static final Method startElementMethod4;
  static final ClassType typeMakeElement = ClassType.make("gnu.kawa.xml.MakeElement");
  public int copyNamespacesMode = 1;
  private boolean handlingKeywordParameters;
  NamespaceBinding namespaceNodes;
  public Symbol tag;
  
  static
  {
    startElementMethod3 = typeMakeElement.getDeclaredMethod("startElement", 3);
    startElementMethod4 = typeMakeElement.getDeclaredMethod("startElement", 4);
  }
  
  public static void endElement(Consumer paramConsumer, Object paramObject)
  {
    paramConsumer.endElement();
  }
  
  public static Symbol getTagName(ApplyExp paramApplyExp)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if (arrayOfExpression.length > 0)
    {
      Expression localExpression = arrayOfExpression[0];
      if ((localExpression instanceof QuoteExp))
      {
        Object localObject = ((QuoteExp)localExpression).getValue();
        if ((localObject instanceof Symbol)) {
          return (Symbol)localObject;
        }
      }
    }
    return null;
  }
  
  public static void startElement(Consumer paramConsumer, Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Symbol)) {}
    for (Symbol localSymbol = (Symbol)paramObject;; localSymbol = Symbol.make("", paramObject.toString(), ""))
    {
      if ((paramConsumer instanceof XMLFilter)) {
        ((XMLFilter)paramConsumer).copyNamespacesMode = paramInt;
      }
      paramConsumer.startElement(localSymbol);
      return;
    }
  }
  
  public static void startElement(Consumer paramConsumer, Object paramObject, int paramInt, NamespaceBinding paramNamespaceBinding)
  {
    if ((paramObject instanceof Symbol)) {}
    for (XName localXName = new XName((Symbol)paramObject, paramNamespaceBinding);; localXName = new XName(Symbol.make("", paramObject.toString(), ""), paramNamespaceBinding))
    {
      if ((paramConsumer instanceof XMLFilter)) {
        ((XMLFilter)paramConsumer).copyNamespacesMode = paramInt;
      }
      paramConsumer.startElement(localXName);
      return;
    }
  }
  
  public void apply(CallContext paramCallContext)
  {
    Consumer localConsumer = paramCallContext.consumer;
    XMLFilter localXMLFilter = pushNodeContext(paramCallContext);
    label143:
    label150:
    for (;;)
    {
      Object localObject3;
      try
      {
        Object localObject2;
        if (this.tag != null)
        {
          localObject2 = this.tag;
          if (this.namespaceNodes != null)
          {
            startElement(localXMLFilter, localObject2, this.copyNamespacesMode, this.namespaceNodes);
            Special localSpecial = Special.dfault;
            localObject3 = paramCallContext.getNextArg(localSpecial);
            if (localObject3 != localSpecial) {
              break label108;
            }
            endElement(localXMLFilter, localObject2);
          }
        }
        else
        {
          localObject2 = paramCallContext.getNextArg();
          continue;
        }
        startElement(localXMLFilter, localObject2, this.copyNamespacesMode);
        continue;
        if (!(localObject3 instanceof Consumable)) {
          break label143;
        }
      }
      finally
      {
        popNodeContext(localConsumer, paramCallContext);
      }
      label108:
      ((Consumable)localObject3).consume(localXMLFilter);
      for (;;)
      {
        if (!isHandlingKeywordParameters()) {
          break label150;
        }
        localXMLFilter.endAttribute();
        break;
        paramCallContext.writeValue(localObject3);
      }
    }
  }
  
  public void compileToNode(ApplyExp paramApplyExp, Compilation paramCompilation, ConsumerTarget paramConsumerTarget)
  {
    Variable localVariable = paramConsumerTarget.getConsumerVariable();
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    int i = arrayOfExpression.length;
    CodeAttr localCodeAttr = paramCompilation.getCode();
    localCodeAttr.emitLoad(localVariable);
    localCodeAttr.emitDup();
    int j;
    if (this.tag == null)
    {
      arrayOfExpression[0].compile(paramCompilation, Target.pushObject);
      j = 1;
      localCodeAttr.emitDup(1, 1);
      localCodeAttr.emitPushInt(this.copyNamespacesMode);
      if (this.namespaceNodes == null) {
        break label160;
      }
      paramCompilation.compileConstant(this.namespaceNodes, Target.pushObject);
      localCodeAttr.emitInvokeStatic(startElementMethod4);
    }
    for (;;)
    {
      if (j >= i) {
        break label171;
      }
      compileChild(arrayOfExpression[j], paramCompilation, paramConsumerTarget);
      if (isHandlingKeywordParameters())
      {
        localCodeAttr.emitLoad(localVariable);
        localCodeAttr.emitInvokeInterface(MakeAttribute.endAttributeMethod);
      }
      j++;
      continue;
      paramCompilation.compileConstant(this.tag, Target.pushObject);
      j = 0;
      break;
      label160:
      localCodeAttr.emitInvokeStatic(startElementMethod3);
    }
    label171:
    localCodeAttr.emitInvokeStatic(endElementMethod);
  }
  
  public NamespaceBinding getNamespaceNodes()
  {
    return this.namespaceNodes;
  }
  
  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Compilation.typeObject;
  }
  
  public boolean isHandlingKeywordParameters()
  {
    return this.handlingKeywordParameters;
  }
  
  public int numArgs()
  {
    if (this.tag == null) {
      return -4095;
    }
    return -4096;
  }
  
  public void setHandlingKeywordParameters(boolean paramBoolean)
  {
    this.handlingKeywordParameters = paramBoolean;
  }
  
  public void setNamespaceNodes(NamespaceBinding paramNamespaceBinding)
  {
    this.namespaceNodes = paramNamespaceBinding;
  }
  
  public String toString()
  {
    return "makeElement[" + this.tag + "]";
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.MakeElement
 * JD-Core Version:    0.7.0.1
 */