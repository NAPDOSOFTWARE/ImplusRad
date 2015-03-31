package gnu.mapping;

import gnu.bytecode.ArrayType;
import gnu.bytecode.Type;

public abstract class MethodProc
  extends ProcedureN
{
  public static final int NO_MATCH = -1;
  public static final int NO_MATCH_AMBIGUOUS = -851968;
  public static final int NO_MATCH_BAD_TYPE = -786432;
  public static final int NO_MATCH_TOO_FEW_ARGS = -983040;
  public static final int NO_MATCH_TOO_MANY_ARGS = -917504;
  static final Type[] unknownArgTypes;
  protected Object argTypes;
  
  static
  {
    Type[] arrayOfType = new Type[1];
    arrayOfType[0] = Type.pointer_type;
    unknownArgTypes = arrayOfType;
  }
  
  public static RuntimeException matchFailAsException(int paramInt, Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    int i = (short)paramInt;
    if ((paramInt & 0xFFFF0000) != -786432) {
      return new WrongArguments(paramProcedure, paramArrayOfObject.length);
    }
    if (i > 0) {}
    for (Object localObject = paramArrayOfObject[(i - 1)];; localObject = null) {
      return new WrongType(paramProcedure, i, localObject);
    }
  }
  
  public static int mostSpecific(MethodProc[] paramArrayOfMethodProc, int paramInt)
  {
    if (paramInt <= 1)
    {
      j = paramInt - 1;
      return j;
    }
    Object localObject = paramArrayOfMethodProc[0];
    MethodProc[] arrayOfMethodProc = null;
    int i = 1;
    int j = 0;
    label25:
    MethodProc localMethodProc1;
    MethodProc localMethodProc4;
    int m;
    if (i < paramInt)
    {
      localMethodProc1 = paramArrayOfMethodProc[i];
      if (localObject != null)
      {
        localMethodProc4 = mostSpecific((MethodProc)localObject, localMethodProc1);
        if (localMethodProc4 == null)
        {
          if (arrayOfMethodProc == null) {
            arrayOfMethodProc = new MethodProc[paramInt];
          }
          arrayOfMethodProc[0] = localObject;
          arrayOfMethodProc[1] = localMethodProc1;
          m = 2;
          localObject = null;
        }
      }
    }
    for (;;)
    {
      i++;
      j = m;
      break label25;
      if (localMethodProc4 == localMethodProc1)
      {
        localObject = localMethodProc1;
        m = i;
        continue;
        for (int k = 0;; k++)
        {
          if (k >= j) {
            break label169;
          }
          MethodProc localMethodProc2 = arrayOfMethodProc[k];
          MethodProc localMethodProc3 = mostSpecific(localMethodProc2, localMethodProc1);
          if (localMethodProc3 == localMethodProc2)
          {
            m = j;
            break;
          }
          if (localMethodProc3 == null)
          {
            m = j + 1;
            arrayOfMethodProc[j] = localMethodProc1;
            break;
          }
        }
        label169:
        localObject = localMethodProc1;
        m = i;
        continue;
        if (localObject != null) {
          break;
        }
        return -1;
      }
      m = j;
    }
  }
  
  public static MethodProc mostSpecific(MethodProc paramMethodProc1, MethodProc paramMethodProc2)
  {
    int i = paramMethodProc1.minArgs();
    int j = paramMethodProc2.minArgs();
    int k = paramMethodProc1.maxArgs();
    int m = paramMethodProc2.maxArgs();
    if (((k >= 0) && (k < j)) || ((m >= 0) && (m < i))) {
      paramMethodProc1 = null;
    }
    int i3;
    int i4;
    label114:
    do
    {
      return paramMethodProc1;
      int n = paramMethodProc1.numParameters();
      int i1 = paramMethodProc2.numParameters();
      int i2;
      if (n > i1)
      {
        i2 = n;
        i3 = 0;
        i4 = 0;
        if (k != m)
        {
          i3 = 0;
          if (k < 0) {
            i3 = 1;
          }
          i4 = 0;
          if (m < 0) {
            i4 = 1;
          }
        }
        if (i >= j) {
          break label164;
        }
        i3 = 1;
      }
      for (int i5 = 0;; i5++)
      {
        if (i5 >= i2) {
          break label197;
        }
        int i6 = paramMethodProc1.getParameterType(i5).compare(paramMethodProc2.getParameterType(i5));
        if (i6 == -1)
        {
          i4 = 1;
          if (i3 != 0)
          {
            return null;
            i2 = i1;
            break;
            if (i <= j) {
              break label114;
            }
            i4 = 1;
            break label114;
          }
        }
        if (i6 == 1)
        {
          i3 = 1;
          if (i4 != 0) {
            return null;
          }
        }
      }
    } while (i4 != 0);
    label164:
    label197:
    if (i3 != 0) {
      return paramMethodProc2;
    }
    return null;
  }
  
  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    checkArgCount(this, paramArrayOfObject.length);
    CallContext localCallContext = CallContext.getInstance();
    checkN(paramArrayOfObject, localCallContext);
    return localCallContext.runUntilValue();
  }
  
  public Type getParameterType(int paramInt)
  {
    if (!(this.argTypes instanceof Type[])) {
      resolveParameterTypes();
    }
    Type[] arrayOfType = (Type[])this.argTypes;
    if ((paramInt < arrayOfType.length) && ((paramInt < -1 + arrayOfType.length) || (maxArgs() >= 0))) {
      return arrayOfType[paramInt];
    }
    if (maxArgs() < 0)
    {
      Type localType = arrayOfType[(-1 + arrayOfType.length)];
      if ((localType instanceof ArrayType)) {
        return ((ArrayType)localType).getComponentType();
      }
    }
    return Type.objectType;
  }
  
  public int isApplicable(Type[] paramArrayOfType)
  {
    int i = paramArrayOfType.length;
    int j = numArgs();
    int k;
    if ((i < (j & 0xFFF)) || ((j >= 0) && (i > j >> 12))) {
      k = -1;
    }
    for (;;)
    {
      return k;
      k = 1;
      int m = i;
      for (;;)
      {
        m--;
        if (m < 0) {
          break;
        }
        int n = getParameterType(m).compare(paramArrayOfType[m]);
        if (n == -3) {
          return -1;
        }
        if (n < 0) {
          k = 0;
        }
      }
    }
  }
  
  public int numParameters()
  {
    int i = numArgs();
    int j = i >> 12;
    if (j >= 0) {
      return j;
    }
    return 1 + (i & 0xFFF);
  }
  
  protected void resolveParameterTypes()
  {
    this.argTypes = unknownArgTypes;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.MethodProc
 * JD-Core Version:    0.7.0.1
 */