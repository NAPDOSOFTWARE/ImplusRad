package gnu.kawa.functions;

import gnu.lists.Array;
import gnu.lists.FVector;
import gnu.lists.GeneralArray;
import gnu.lists.SimpleVector;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class Arrays
{
  static final int[] shapeStrides = { 2, 1 };
  static final int[] zeros2 = new int[2];
  
  public static int effectiveIndex(Array paramArray, Procedure paramProcedure, Object[] paramArrayOfObject, int[] paramArrayOfInt)
    throws Throwable
  {
    Object localObject = paramProcedure.applyN(paramArrayOfObject);
    if ((localObject instanceof Values))
    {
      Values localValues = (Values)localObject;
      int i = 0;
      for (int j = 0;; j++)
      {
        i = localValues.nextPos(i);
        if (i == 0) {
          break;
        }
        paramArrayOfInt[j] = ((Number)localValues.getPosPrevious(i)).intValue();
      }
    }
    paramArrayOfInt[0] = ((Number)localObject).intValue();
    return paramArray.getEffectiveIndex(paramArrayOfInt);
  }
  
  public static Array make(Array paramArray, Object paramObject)
  {
    int i = paramArray.getSize(0);
    int[] arrayOfInt1 = new int[i];
    int[] arrayOfInt2 = null;
    int j = 1;
    int k = i;
    for (;;)
    {
      k--;
      if (k < 0) {
        break;
      }
      int m = ((Number)paramArray.getRowMajor(k * 2)).intValue();
      int n = ((Number)paramArray.getRowMajor(1 + k * 2)).intValue() - m;
      arrayOfInt1[k] = n;
      if (m != 0)
      {
        if (arrayOfInt2 == null) {
          arrayOfInt2 = new int[i];
        }
        arrayOfInt2[k] = m;
      }
      j *= n;
    }
    return GeneralArray.makeSimple(arrayOfInt2, arrayOfInt1, new FVector(j, paramObject));
  }
  
  public static Array makeSimple(Array paramArray, SimpleVector paramSimpleVector)
  {
    int i = paramArray.getSize(0);
    int[] arrayOfInt1 = new int[i];
    int[] arrayOfInt2 = null;
    int j = i;
    for (;;)
    {
      j--;
      if (j < 0) {
        break;
      }
      int k = ((Number)paramArray.getRowMajor(j * 2)).intValue();
      arrayOfInt1[j] = (((Number)paramArray.getRowMajor(1 + j * 2)).intValue() - k);
      if (k != 0)
      {
        if (arrayOfInt2 == null) {
          arrayOfInt2 = new int[i];
        }
        arrayOfInt2[j] = k;
      }
    }
    return GeneralArray.makeSimple(arrayOfInt2, arrayOfInt1, paramSimpleVector);
  }
  
  public static Array shape(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    if ((i & 0x1) != 0) {
      throw new RuntimeException("shape: not an even number of arguments");
    }
    int[] arrayOfInt = { i >> 1, 2 };
    return new FVector(paramArrayOfObject).transpose(zeros2, arrayOfInt, 0, shapeStrides);
  }
  
  public static Array shareArray(Array paramArray1, Array paramArray2, Procedure paramProcedure)
    throws Throwable
  {
    int i = paramArray2.getSize(0);
    Object[] arrayOfObject = new Object[i];
    int[] arrayOfInt1 = new int[i];
    int[] arrayOfInt2 = new int[i];
    int j = 0;
    int k = i;
    for (;;)
    {
      k--;
      if (k < 0) {
        break;
      }
      Object localObject2 = paramArray2.getRowMajor(k * 2);
      arrayOfObject[k] = localObject2;
      int i4 = ((Number)localObject2).intValue();
      arrayOfInt2[k] = i4;
      int i5 = ((Number)paramArray2.getRowMajor(1 + k * 2)).intValue() - i4;
      arrayOfInt1[k] = i5;
      if (i5 <= 0) {
        j = 1;
      }
    }
    int m = paramArray1.rank();
    int[] arrayOfInt3 = new int[i];
    int n;
    if (j != 0) {
      n = 0;
    }
    for (;;)
    {
      return paramArray1.transpose(arrayOfInt2, arrayOfInt1, n, arrayOfInt3);
      int[] arrayOfInt4 = new int[m];
      n = effectiveIndex(paramArray1, paramProcedure, arrayOfObject, arrayOfInt4);
      int i1 = i;
      for (;;)
      {
        i1--;
        if (i1 < 0) {
          break;
        }
        int i2 = arrayOfInt1[i1];
        int i3 = arrayOfInt2[i1];
        if (i2 <= 1)
        {
          arrayOfInt3[i1] = 0;
        }
        else
        {
          Object localObject1 = arrayOfObject[i1];
          arrayOfObject[i1] = IntNum.make(i3 + 1);
          arrayOfInt3[i1] = (effectiveIndex(paramArray1, paramProcedure, arrayOfObject, arrayOfInt4) - n);
          arrayOfObject[i1] = localObject1;
        }
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.Arrays
 * JD-Core Version:    0.7.0.1
 */