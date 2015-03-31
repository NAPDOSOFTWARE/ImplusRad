package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.Keyword;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrongType;
import kawa.lang.Record;

public class make
  extends ProcedureN
{
  public Object applyN(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    if (i == 0) {
      throw new WrongArguments(this, i);
    }
    Object localObject1 = paramArrayOfObject[0];
    Class localClass;
    if ((localObject1 instanceof Class)) {
      localClass = (Class)localObject1;
    }
    while (localClass == null)
    {
      throw new WrongType(this, 1, localObject1, "class");
      if ((localObject1 instanceof ClassType)) {
        localClass = ((ClassType)localObject1).getReflectClass();
      } else {
        localClass = null;
      }
    }
    try
    {
      Object localObject2 = localClass.newInstance();
      int j = 1;
      while (j < i)
      {
        int k = j + 1;
        Keyword localKeyword = (Keyword)paramArrayOfObject[j];
        j = k + 1;
        Record.set1(paramArrayOfObject[k], localKeyword.getName(), localObject2);
      }
      return localObject2;
    }
    catch (Exception localException)
    {
      throw new WrappedException(localException);
    }
  }
  
  public int numArgs()
  {
    return -4095;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.make
 * JD-Core Version:    0.7.0.1
 */