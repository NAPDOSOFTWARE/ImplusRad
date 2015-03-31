package gnu.kawa.functions;

import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrongType;

public class Apply
  extends ProcedureN
{
  ApplyToArgs applyToArgs;
  
  public Apply(String paramString, ApplyToArgs paramApplyToArgs)
  {
    super(paramString);
    this.applyToArgs = paramApplyToArgs;
  }
  
  public static Object[] getArguments(Object[] paramArrayOfObject, int paramInt, Procedure paramProcedure)
  {
    int i = paramArrayOfObject.length;
    if (i < paramInt + 1) {
      throw new WrongArguments("apply", 2, "(apply proc [args] args) [count:" + i + " skip:" + paramInt + "]");
    }
    Object localObject = paramArrayOfObject[(i - 1)];
    int j;
    if ((localObject instanceof Object[]))
    {
      Object[] arrayOfObject2 = (Object[])localObject;
      if (i == 2) {
        return arrayOfObject2;
      }
      j = arrayOfObject2.length;
    }
    while (j < 0)
    {
      throw new WrongType(paramProcedure, i, localObject, "sequence or array");
      if ((localObject instanceof Sequence)) {
        j = ((Sequence)localObject).size();
      } else {
        j = -1;
      }
    }
    Object[] arrayOfObject1 = new Object[j + (-1 + (i - paramInt))];
    for (int k = 0; k < -1 + (i - paramInt); k++) {
      arrayOfObject1[k] = paramArrayOfObject[(k + paramInt)];
    }
    if ((localObject instanceof Object[])) {
      System.arraycopy((Object[])localObject, 0, arrayOfObject1, k, j);
    }
    int n;
    for (;;)
    {
      return arrayOfObject1;
      while ((localObject instanceof Pair))
      {
        Pair localPair = (Pair)localObject;
        int i2 = k + 1;
        arrayOfObject1[k] = localPair.getCar();
        localObject = localPair.getCdr();
        j--;
        k = i2;
      }
      if (j > 0)
      {
        Sequence localSequence = (Sequence)localObject;
        int m = 0;
        int i1;
        for (n = k; m < j; n = i1)
        {
          i1 = n + 1;
          arrayOfObject1[n] = localSequence.get(m);
          m++;
        }
      }
    }
  }
  
  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Object[] arrayOfObject = paramCallContext.getArgs();
    this.applyToArgs.checkN(getArguments(arrayOfObject, 0, this), paramCallContext);
  }
  
  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    return this.applyToArgs.applyN(getArguments(paramArrayOfObject, 0, this));
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.Apply
 * JD-Core Version:    0.7.0.1
 */