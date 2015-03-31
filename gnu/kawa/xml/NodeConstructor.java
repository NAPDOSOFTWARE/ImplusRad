package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.xml.NodeTree;
import gnu.xml.XMLFilter;

public abstract class NodeConstructor
  extends MethodProc
  implements Inlineable
{
  static final Method popNodeConsumerMethod = typeNodeConstructor.getDeclaredMethod("popNodeConsumer", 2);
  static final Method popNodeContextMethod;
  static final Method pushNodeConsumerMethod;
  static final Method pushNodeContextMethod;
  static final ClassType typeKNode;
  static final ClassType typeNodeConstructor;
  static final ClassType typeXMLFilter = ClassType.make("gnu.xml.XMLFilter");
  
  static
  {
    typeKNode = ClassType.make("gnu.kawa.xml.KNode");
    typeNodeConstructor = ClassType.make("gnu.kawa.xml.NodeConstructor");
    pushNodeContextMethod = typeNodeConstructor.getDeclaredMethod("pushNodeContext", 1);
    popNodeContextMethod = typeNodeConstructor.getDeclaredMethod("popNodeContext", 2);
    pushNodeConsumerMethod = typeNodeConstructor.getDeclaredMethod("pushNodeConsumer", 1);
  }
  
  public static void compileChild(Expression paramExpression, Compilation paramCompilation, ConsumerTarget paramConsumerTarget)
  {
    if ((paramExpression instanceof ApplyExp))
    {
      ApplyExp localApplyExp = (ApplyExp)paramExpression;
      Expression localExpression = localApplyExp.getFunction();
      if ((localExpression instanceof QuoteExp))
      {
        Object localObject = ((QuoteExp)localExpression).getValue();
        if ((localObject instanceof NodeConstructor))
        {
          ((NodeConstructor)localObject).compileToNode(localApplyExp, paramCompilation, paramConsumerTarget);
          return;
        }
      }
    }
    paramExpression.compileWithPosition(paramCompilation, paramConsumerTarget);
  }
  
  public static void compileUsingNodeTree(Expression paramExpression, Compilation paramCompilation, Target paramTarget)
  {
    ConsumerTarget.compileUsingConsumer(paramExpression, paramCompilation, paramTarget, typeNodeConstructor.getDeclaredMethod("makeNode", 0), typeNodeConstructor.getDeclaredMethod("finishNode", 1));
  }
  
  public static KNode finishNode(XMLFilter paramXMLFilter)
  {
    return KNode.make((NodeTree)paramXMLFilter.out);
  }
  
  public static XMLFilter makeNode()
  {
    return new XMLFilter(new NodeTree());
  }
  
  public static void popNodeConsumer(Consumer paramConsumer1, Consumer paramConsumer2)
  {
    if (paramConsumer1 != paramConsumer2)
    {
      if ((paramConsumer2 instanceof XMLFilter)) {
        paramConsumer2 = KNode.make((NodeTree)((XMLFilter)paramConsumer2).out);
      }
      paramConsumer1.writeObject(paramConsumer2);
    }
  }
  
  public static void popNodeContext(Consumer paramConsumer, CallContext paramCallContext)
  {
    Object localObject = paramCallContext.consumer;
    if (paramConsumer != localObject)
    {
      if ((localObject instanceof XMLFilter)) {
        localObject = KNode.make((NodeTree)((XMLFilter)localObject).out);
      }
      paramConsumer.writeObject(localObject);
      paramCallContext.consumer = paramConsumer;
    }
  }
  
  public static XMLFilter pushNodeConsumer(Consumer paramConsumer)
  {
    if ((paramConsumer instanceof XMLFilter)) {
      return (XMLFilter)paramConsumer;
    }
    return new XMLFilter(new NodeTree());
  }
  
  public static XMLFilter pushNodeContext(CallContext paramCallContext)
  {
    Consumer localConsumer = paramCallContext.consumer;
    if ((localConsumer instanceof XMLFilter)) {
      return (XMLFilter)localConsumer;
    }
    XMLFilter localXMLFilter = new XMLFilter(new NodeTree());
    paramCallContext.consumer = localXMLFilter;
    return localXMLFilter;
  }
  
  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    if ((paramTarget instanceof IgnoreTarget))
    {
      ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
      return;
    }
    if (!(paramTarget instanceof ConsumerTarget))
    {
      compileUsingNodeTree(paramApplyExp, paramCompilation, paramTarget);
      return;
    }
    ConsumerTarget localConsumerTarget = (ConsumerTarget)paramTarget;
    Variable localVariable1 = localConsumerTarget.getConsumerVariable();
    if (localVariable1.getType().isSubtype(typeXMLFilter))
    {
      compileToNode(paramApplyExp, paramCompilation, localConsumerTarget);
      return;
    }
    paramApplyExp.getArgs().length;
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Variable localVariable2 = localCodeAttr.pushScope().addVariable(localCodeAttr, typeXMLFilter, null);
    if (localConsumerTarget.isContextTarget())
    {
      paramCompilation.loadCallContext();
      localCodeAttr.emitInvokeStatic(pushNodeContextMethod);
      localCodeAttr.emitStore(localVariable2);
      localCodeAttr.emitTryStart(true, Type.void_type);
      compileToNode(paramApplyExp, paramCompilation, new ConsumerTarget(localVariable2));
      localCodeAttr.emitTryEnd();
      localCodeAttr.emitFinallyStart();
      localCodeAttr.emitLoad(localVariable1);
      if (!localConsumerTarget.isContextTarget()) {
        break label215;
      }
      paramCompilation.loadCallContext();
      localCodeAttr.emitInvokeStatic(popNodeContextMethod);
    }
    for (;;)
    {
      localCodeAttr.emitFinallyEnd();
      localCodeAttr.emitTryCatchEnd();
      localCodeAttr.popScope();
      return;
      localCodeAttr.emitLoad(localVariable1);
      localCodeAttr.emitInvokeStatic(pushNodeConsumerMethod);
      break;
      label215:
      localCodeAttr.emitLoad(localVariable2);
      localCodeAttr.emitInvokeStatic(popNodeConsumerMethod);
    }
  }
  
  public abstract void compileToNode(ApplyExp paramApplyExp, Compilation paramCompilation, ConsumerTarget paramConsumerTarget);
  
  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Compilation.typeObject;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.NodeConstructor
 * JD-Core Version:    0.7.0.1
 */