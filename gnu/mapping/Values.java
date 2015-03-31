package gnu.mapping;

import gnu.lists.Consumer;
import gnu.lists.TreeList;
import gnu.text.Printable;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Iterator;
import java.util.List;

public class Values
  extends TreeList
  implements Printable, Externalizable
{
  public static final Values empty = new Values(noArgs);
  public static final Object[] noArgs = new Object[0];
  
  public Values() {}
  
  public Values(Object[] paramArrayOfObject)
  {
    for (int i = 0; i < paramArrayOfObject.length; i++) {
      writeObject(paramArrayOfObject[i]);
    }
  }
  
  public static int countValues(Object paramObject)
  {
    if ((paramObject instanceof Values)) {
      return ((Values)paramObject).size();
    }
    return 1;
  }
  
  public static Values make()
  {
    return new Values();
  }
  
  public static Object make(TreeList paramTreeList)
  {
    return make(paramTreeList, 0, paramTreeList.data.length);
  }
  
  public static Object make(TreeList paramTreeList, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 != paramInt2)
    {
      i = paramTreeList.nextDataIndex(paramInt1);
      if (i > 0) {}
    }
    else
    {
      return empty;
    }
    if ((i == paramInt2) || (paramTreeList.nextDataIndex(i) < 0)) {
      return paramTreeList.getPosNext(paramInt1 << 1);
    }
    Values localValues = new Values();
    paramTreeList.consumeIRange(paramInt1, paramInt2, localValues);
    return localValues;
  }
  
  public static Object make(List paramList)
  {
    int i;
    Values localValues;
    if (paramList == null)
    {
      i = 0;
      if (i != 0) {
        break label26;
      }
      localValues = empty;
    }
    for (;;)
    {
      return localValues;
      i = paramList.size();
      break;
      label26:
      if (i == 1) {
        return paramList.get(0);
      }
      localValues = new Values();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localValues.writeObject(localIterator.next());
      }
    }
  }
  
  public static Object make(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length == 1) {
      return paramArrayOfObject[0];
    }
    if (paramArrayOfObject.length == 0) {
      return empty;
    }
    return new Values(paramArrayOfObject);
  }
  
  public static int nextIndex(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Values)) {
      return ((Values)paramObject).nextDataIndex(paramInt);
    }
    if (paramInt == 0) {
      return 1;
    }
    return -1;
  }
  
  public static Object nextValue(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Values))
    {
      Values localValues = (Values)paramObject;
      if (paramInt >= localValues.gapEnd) {
        paramInt -= localValues.gapEnd - localValues.gapStart;
      }
      paramObject = ((Values)paramObject).getPosNext(paramInt << 1);
    }
    return paramObject;
  }
  
  public static Object values(Object... paramVarArgs)
  {
    return make(paramVarArgs);
  }
  
  public static void writeValues(Object paramObject, Consumer paramConsumer)
  {
    if ((paramObject instanceof Values))
    {
      ((Values)paramObject).consume(paramConsumer);
      return;
    }
    paramConsumer.writeObject(paramObject);
  }
  
  public Object call_with(Procedure paramProcedure)
    throws Throwable
  {
    return paramProcedure.applyN(toArray());
  }
  
  public final Object canonicalize()
  {
    if (this.gapEnd == this.data.length)
    {
      if (this.gapStart != 0) {
        break label25;
      }
      this = empty;
    }
    label25:
    while (nextDataIndex(0) != this.gapStart) {
      return this;
    }
    return getPosNext(0);
  }
  
  public Object[] getValues()
  {
    if (isEmpty()) {
      return noArgs;
    }
    return toArray();
  }
  
  public void print(Consumer paramConsumer)
  {
    if (this == empty) {
      paramConsumer.write("#!void");
    }
    int i;
    int j;
    do
    {
      return;
      toArray().length;
      if (1 != 0) {
        paramConsumer.write("#<values");
      }
      i = 0;
      j = nextDataIndex(i);
      if (j >= 0) {
        break;
      }
    } while (1 == 0);
    paramConsumer.write(62);
    return;
    paramConsumer.write(32);
    if (i >= this.gapEnd) {
      i -= this.gapEnd - this.gapStart;
    }
    Object localObject = getPosNext(i << 1);
    if ((localObject instanceof Printable)) {
      ((Printable)localObject).print(paramConsumer);
    }
    for (;;)
    {
      i = j;
      break;
      paramConsumer.writeObject(localObject);
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    int i = paramObjectInput.readInt();
    for (int j = 0; j < i; j++) {
      writeObject(paramObjectInput.readObject());
    }
  }
  
  public Object readResolve()
    throws ObjectStreamException
  {
    if (isEmpty()) {
      this = empty;
    }
    return this;
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    Object[] arrayOfObject = toArray();
    int i = arrayOfObject.length;
    paramObjectOutput.writeInt(i);
    for (int j = 0; j < i; j++) {
      paramObjectOutput.writeObject(arrayOfObject[j]);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.Values
 * JD-Core Version:    0.7.0.1
 */