package kawa.lang;

import gnu.mapping.CallContext;

public class CalledContinuation
  extends RuntimeException
{
  public Continuation continuation;
  public CallContext ctx;
  public Object[] values;
  
  CalledContinuation(Object[] paramArrayOfObject, Continuation paramContinuation, CallContext paramCallContext)
  {
    super("call/cc called");
    this.values = paramArrayOfObject;
    this.continuation = paramContinuation;
    this.ctx = paramCallContext;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.CalledContinuation
 * JD-Core Version:    0.7.0.1
 */