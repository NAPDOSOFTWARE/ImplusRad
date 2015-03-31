package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;

public class IgnoreTarget
  extends Target
{
  public void compileFromStack(Compilation paramCompilation, Type paramType)
  {
    if (!paramType.isVoid()) {
      paramCompilation.getCode().emitPop(1);
    }
  }
  
  public Type getType()
  {
    return Type.voidType;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.IgnoreTarget
 * JD-Core Version:    0.7.0.1
 */