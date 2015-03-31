package kawa.standard;

import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongType;

public class append
  extends ProcedureN
{
  public static final append append = new append();
  
  static
  {
    append.setName("append");
  }
  
  public static Object append$V(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    if (i == 0)
    {
      localObject2 = LList.Empty;
      return localObject2;
    }
    Object localObject1 = paramArrayOfObject[(i - 1)];
    int j = i - 1;
    Object localObject2 = localObject1;
    label28:
    j--;
    Object localObject5;
    if (j >= 0)
    {
      Object localObject3 = paramArrayOfObject[j];
      Object localObject4 = null;
      localObject5 = null;
      if ((localObject3 instanceof Pair))
      {
        Pair localPair1 = (Pair)localObject3;
        Pair localPair2 = new Pair(localPair1.getCar(), null);
        if (localObject4 == null) {}
        for (Object localObject6 = localPair2;; localObject6 = localObject5)
        {
          localObject4 = localPair2;
          localObject3 = localPair1.getCdr();
          localObject5 = localObject6;
          break;
          localObject4.setCdr(localPair2);
        }
      }
      if (localObject3 != LList.Empty) {
        throw new WrongType(append, j + 1, paramArrayOfObject[j], "list");
      }
      if (localObject4 == null) {
        break label163;
      }
      localObject4.setCdr(localObject2);
    }
    for (;;)
    {
      localObject2 = localObject5;
      break label28;
      break;
      label163:
      localObject5 = localObject2;
    }
  }
  
  public Object applyN(Object[] paramArrayOfObject)
  {
    return append$V(paramArrayOfObject);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.append
 * JD-Core Version:    0.7.0.1
 */