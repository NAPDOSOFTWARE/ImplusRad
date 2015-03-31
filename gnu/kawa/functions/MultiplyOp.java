package gnu.kawa.functions;

import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RatNum;
import java.math.BigDecimal;
import java.math.BigInteger;

public class MultiplyOp
  extends ArithOp
{
  public static final MultiplyOp $St = new MultiplyOp("*");
  
  public MultiplyOp(String paramString)
  {
    super(paramString, 3);
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyArithOp");
    Procedure.compilerKey.set(this, "*gnu.kawa.functions.CompileArith:forMul");
  }
  
  public static Object apply(Object paramObject1, Object paramObject2)
  {
    return ((Numeric)paramObject1).mul(paramObject2);
  }
  
  public Object applyN(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    Object localObject1;
    if (i == 0) {
      localObject1 = IntNum.one();
    }
    int j;
    int k;
    do
    {
      return localObject1;
      localObject1 = (Number)paramArrayOfObject[0];
      j = Arithmetic.classifyValue(localObject1);
      k = 1;
    } while (k >= i);
    Object localObject2 = paramArrayOfObject[k];
    int m = Arithmetic.classifyValue(localObject2);
    if (j < m) {
      j = m;
    }
    switch (j)
    {
    default: 
      localObject1 = Arithmetic.asNumeric(localObject1).mul(Arithmetic.asNumeric(localObject2));
    }
    for (;;)
    {
      k++;
      break;
      localObject1 = new Integer(Arithmetic.asInt(localObject1) * Arithmetic.asInt(localObject2));
      continue;
      localObject1 = new Long(Arithmetic.asLong(localObject1) * Arithmetic.asLong(localObject2));
      continue;
      localObject1 = Arithmetic.asBigInteger(localObject1).multiply(Arithmetic.asBigInteger(localObject2));
      continue;
      localObject1 = IntNum.times(Arithmetic.asIntNum(localObject1), Arithmetic.asIntNum(localObject2));
      continue;
      localObject1 = Arithmetic.asBigDecimal(localObject1).multiply(Arithmetic.asBigDecimal(localObject2));
      continue;
      localObject1 = RatNum.times(Arithmetic.asRatNum(localObject1), Arithmetic.asRatNum(localObject2));
      continue;
      localObject1 = new Float(Arithmetic.asFloat(localObject1) * Arithmetic.asFloat(localObject2));
      continue;
      localObject1 = new Double(Arithmetic.asDouble(localObject1) * Arithmetic.asDouble(localObject2));
      continue;
      localObject1 = new DFloNum(Arithmetic.asDouble(localObject1) * Arithmetic.asDouble(localObject2));
    }
  }
  
  public Object defaultResult()
  {
    return IntNum.one();
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.MultiplyOp
 * JD-Core Version:    0.7.0.1
 */