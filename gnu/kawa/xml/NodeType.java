package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConditionalTarget;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.kawa.reflect.InstanceOf;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.mapping.Procedure;
import gnu.xml.NodeTree;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class NodeType
  extends ObjectType
  implements TypeValue, NodePredicate, Externalizable
{
  public static final int ATTRIBUTE_OK = 4;
  public static final int COMMENT_OK = 16;
  public static final int DOCUMENT_OK = 8;
  public static final int ELEMENT_OK = 2;
  public static final int PI_OK = 32;
  public static final int TEXT_OK = 1;
  public static final NodeType anyNodeTest = new NodeType("node");
  static final Method coerceMethod;
  static final Method coerceOrNullMethod;
  public static final NodeType commentNodeTest;
  public static final NodeType documentNodeTest;
  public static final NodeType nodeType;
  public static final NodeType textNodeTest;
  public static final ClassType typeKNode = ClassType.make("gnu.kawa.xml.KNode");
  public static final ClassType typeNodeType = ClassType.make("gnu.kawa.xml.NodeType");
  int kinds = -1;
  
  static
  {
    nodeType = new NodeType("gnu.kawa.xml.KNode");
    coerceMethod = typeNodeType.getDeclaredMethod("coerceForce", 2);
    coerceOrNullMethod = typeNodeType.getDeclaredMethod("coerceOrNull", 2);
    documentNodeTest = new NodeType("document-node", 8);
    textNodeTest = new NodeType("text", 1);
    commentNodeTest = new NodeType("comment", 16);
  }
  
  public NodeType(String paramString)
  {
    this(paramString, -1);
  }
  
  public NodeType(String paramString, int paramInt)
  {
    super(paramString);
    this.kinds = paramInt;
  }
  
  public static KNode coerceForce(Object paramObject, int paramInt)
  {
    KNode localKNode = coerceOrNull(paramObject, paramInt);
    if (localKNode == null) {
      throw new ClassCastException("coerce from " + paramObject.getClass());
    }
    return localKNode;
  }
  
  public static KNode coerceOrNull(Object paramObject, int paramInt)
  {
    KNode localKNode2;
    if ((paramObject instanceof NodeTree))
    {
      localKNode2 = KNode.make((NodeTree)paramObject);
      if (!isInstance(localKNode2.sequence, localKNode2.ipos, paramInt)) {
        break label58;
      }
    }
    for (;;)
    {
      KNode localKNode1 = localKNode2;
      boolean bool;
      do
      {
        return localKNode1;
        bool = paramObject instanceof KNode;
        localKNode1 = null;
      } while (!bool);
      localKNode2 = (KNode)paramObject;
      break;
      label58:
      localKNode2 = null;
    }
  }
  
  public static boolean isInstance(AbstractSequence paramAbstractSequence, int paramInt1, int paramInt2)
  {
    int i = paramAbstractSequence.getNextKind(paramInt1);
    if (paramInt2 < 0) {
      if (i == 0) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                return false;
                switch (i)
                {
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 30: 
                case 31: 
                default: 
                  return true;
                case 0: 
                  return false;
                }
              } while ((paramInt2 & 0x1) != 0);
              return false;
            } while ((paramInt2 & 0x2) != 0);
            return false;
          } while ((paramInt2 & 0x4) != 0);
          return false;
        } while ((paramInt2 & 0x8) != 0);
        return false;
      } while ((paramInt2 & 0x10) != 0);
      return false;
    } while ((paramInt2 & 0x20) != 0);
    return false;
  }
  
  public Object coerceFromObject(Object paramObject)
  {
    return coerceForce(paramObject, this.kinds);
  }
  
  public int compare(Type paramType)
  {
    return getImplementationType().compare(paramType);
  }
  
  public Expression convertValue(Expression paramExpression)
  {
    ApplyExp localApplyExp = new ApplyExp(coerceMethod, new Expression[] { paramExpression });
    localApplyExp.setType(this);
    return localApplyExp;
  }
  
  public void emitCoerceFromObject(CodeAttr paramCodeAttr)
  {
    paramCodeAttr.emitPushInt(this.kinds);
    paramCodeAttr.emitInvokeStatic(coerceMethod);
  }
  
  protected void emitCoerceOrNullMethod(Variable paramVariable, Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    if (paramVariable != null) {
      localCodeAttr.emitLoad(paramVariable);
    }
    localCodeAttr.emitPushInt(this.kinds);
    localCodeAttr.emitInvokeStatic(coerceOrNullMethod);
  }
  
  public void emitIsInstance(Variable paramVariable, Compilation paramCompilation, Target paramTarget)
  {
    if ((paramTarget instanceof ConditionalTarget))
    {
      ConditionalTarget localConditionalTarget = (ConditionalTarget)paramTarget;
      emitCoerceOrNullMethod(paramVariable, paramCompilation);
      CodeAttr localCodeAttr = paramCompilation.getCode();
      if (localConditionalTarget.trueBranchComesFirst) {
        localCodeAttr.emitGotoIfCompare1(localConditionalTarget.ifFalse, 198);
      }
      for (;;)
      {
        localConditionalTarget.emitGotoFirstBranch(localCodeAttr);
        return;
        localCodeAttr.emitGotoIfCompare1(localConditionalTarget.ifTrue, 199);
      }
    }
    InstanceOf.emitIsInstance(this, paramVariable, paramCompilation, paramTarget);
  }
  
  public void emitTestIf(Variable paramVariable, Declaration paramDeclaration, Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    emitCoerceOrNullMethod(paramVariable, paramCompilation);
    if (paramDeclaration != null)
    {
      localCodeAttr.emitDup();
      paramDeclaration.compileStore(paramCompilation);
    }
    localCodeAttr.emitIfNotNull();
  }
  
  public Procedure getConstructor()
  {
    return null;
  }
  
  public Type getImplementationType()
  {
    return typeKNode;
  }
  
  public boolean isInstance(Object paramObject)
  {
    if ((paramObject instanceof KNode))
    {
      KNode localKNode = (KNode)paramObject;
      return isInstancePos(localKNode.sequence, localKNode.getPos());
    }
    return false;
  }
  
  public boolean isInstancePos(AbstractSequence paramAbstractSequence, int paramInt)
  {
    return isInstance(paramAbstractSequence, paramInt, this.kinds);
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    String str = paramObjectInput.readUTF();
    if (str.length() > 0) {
      setName(str);
    }
    this.kinds = paramObjectInput.readInt();
  }
  
  public String toString()
  {
    return "NodeType " + getName();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    String str = getName();
    if (str == null) {
      str = "";
    }
    paramObjectOutput.writeUTF(str);
    paramObjectOutput.writeInt(this.kinds);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.NodeType
 * JD-Core Version:    0.7.0.1
 */