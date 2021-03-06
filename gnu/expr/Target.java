package gnu.expr;

import gnu.bytecode.Type;

public abstract class Target
{
  public static final Target Ignore = new IgnoreTarget();
  public static final Target pushObject = new StackTarget(Type.pointer_type);
  
  public static Target pushValue(Type paramType)
  {
    if (paramType.isVoid()) {
      return Ignore;
    }
    return StackTarget.getInstance(paramType);
  }
  
  public abstract void compileFromStack(Compilation paramCompilation, Type paramType);
  
  public abstract Type getType();
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.Target
 * JD-Core Version:    0.7.0.1
 */