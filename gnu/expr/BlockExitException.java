package gnu.expr;

class BlockExitException
  extends RuntimeException
{
  ExitExp exit;
  Object result;
  
  public BlockExitException(ExitExp paramExitExp, Object paramObject)
  {
    this.exit = paramExitExp;
    this.result = paramObject;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.BlockExitException
 * JD-Core Version:    0.7.0.1
 */