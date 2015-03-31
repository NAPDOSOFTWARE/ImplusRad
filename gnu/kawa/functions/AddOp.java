package gnu.kawa.functions;

import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RatNum;
import java.math.BigDecimal;
import java.math.BigInteger;

public class AddOp
  extends ArithOp
{
  public static final AddOp $Mn = new AddOp("-", -1);
  public static final AddOp $Pl = new AddOp("+", 1);
  int plusOrMinus;
  
  public static Object $Mn(Object paramObject)
  {
    switch (Arithmetic.classifyValue(paramObject))
    {
    default: 
      return Arithmetic.asNumeric(paramObject).neg();
    case 1: 
      return new Integer(-Arithmetic.asInt(paramObject));
    case 2: 
      return new Long(-Arithmetic.asLong(paramObject));
    case 3: 
      return Arithmetic.asBigInteger(paramObject).negate();
    case 4: 
      return IntNum.neg(Arithmetic.asIntNum(paramObject));
    case 5: 
      return Arithmetic.asBigDecimal(paramObject).negate();
    case 6: 
      return RatNum.neg(Arithmetic.asRatNum(paramObject));
    case 7: 
      return new Float(-Arithmetic.asFloat(paramObject));
    case 8: 
      return new Double(-Arithmetic.asDouble(paramObject));
    }
    return new DFloNum(-Arithmetic.asDouble(paramObject));
  }
  
  public static Object $Mn(Object paramObject1, Object paramObject2)
  {
    return apply2(-1, paramObject1, paramObject2);
  }
  
  public static Object $Mn$V(Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
  {
    return applyN(-1, apply2(-1, apply2(-1, paramObject1, paramObject2), paramObject3), paramArrayOfObject);
  }
  
  public static Object $Pl(Object paramObject1, Object paramObject2)
  {
    return apply2(1, paramObject1, paramObject2);
  }
  
  public static Object $Pl$V(Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
  {
    return applyN(1, apply2(1, apply2(1, paramObject1, paramObject2), paramObject3), paramArrayOfObject);
  }
  
  public AddOp(String paramString, int paramInt) {}
  
  public static Object apply2(int paramInt, Object paramObject1, Object paramObject2)
  {
    int i = Arithmetic.classifyValue(paramObject1);
    int j = Arithmetic.classifyValue(paramObject2);
    if (i < j) {}
    for (int k = j;; k = i) {
      switch (k)
      {
      default: 
        return Arithmetic.asNumeric(paramObject1).add(Arithmetic.asNumeric(paramObject2), paramInt);
      }
    }
    int m = Arithmetic.asInt(paramObject1);
    int n = Arithmetic.asInt(paramObject2);
    if (paramInt > 0) {}
    for (int i1 = m + n;; i1 = m - n)
    {
      Integer localInteger = new Integer(i1);
      return localInteger;
    }
    long l1 = Arithmetic.asLong(paramObject1);
    long l2 = Arithmetic.asLong(paramObject2);
    if (paramInt > 0) {}
    for (long l3 = l1 + l2;; l3 = l1 - l2)
    {
      Long localLong = new Long(l3);
      return localLong;
    }
    BigInteger localBigInteger1 = Arithmetic.asBigInteger(paramObject1);
    BigInteger localBigInteger2 = Arithmetic.asBigInteger(paramObject2);
    if (paramInt > 0) {
      return localBigInteger1.add(localBigInteger2);
    }
    return localBigInteger1.subtract(localBigInteger2);
    return IntNum.add(Arithmetic.asIntNum(paramObject1), Arithmetic.asIntNum(paramObject2), paramInt);
    BigDecimal localBigDecimal1 = Arithmetic.asBigDecimal(paramObject1);
    BigDecimal localBigDecimal2 = Arithmetic.asBigDecimal(paramObject2);
    if (paramInt > 0) {
      return localBigDecimal1.add(localBigDecimal2);
    }
    return localBigDecimal1.subtract(localBigDecimal2);
    return RatNum.add(Arithmetic.asRatNum(paramObject1), Arithmetic.asRatNum(paramObject2), paramInt);
    float f1 = Arithmetic.asFloat(paramObject1);
    float f2 = Arithmetic.asFloat(paramObject2);
    if (paramInt > 0) {}
    for (float f3 = f1 + f2;; f3 = f1 - f2)
    {
      Float localFloat = new Float(f3);
      return localFloat;
    }
    double d4 = Arithmetic.asDouble(paramObject1);
    double d5 = Arithmetic.asDouble(paramObject2);
    if (paramInt > 0) {}
    for (double d6 = d4 + d5;; d6 = d4 - d5)
    {
      Double localDouble = new Double(d6);
      return localDouble;
    }
    double d1 = Arithmetic.asDouble(paramObject1);
    double d2 = Arithmetic.asDouble(paramObject2);
    if (paramInt > 0) {}
    for (double d3 = d1 + d2;; d3 = d1 - d2)
    {
      DFloNum localDFloNum = new DFloNum(d3);
      return localDFloNum;
    }
  }
  
  public static Object applyN(int paramInt, Object paramObject, Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    Object localObject = paramObject;
    for (int j = 0; j < i; j++) {
      localObject = apply2(paramInt, localObject, paramArrayOfObject[j]);
    }
    return localObject;
  }
  
  public static Object applyN(int paramInt, Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    Object localObject;
    if (i == 0) {
      localObject = IntNum.zero();
    }
    for (;;)
    {
      return localObject;
      localObject = paramArrayOfObject[0];
      if ((i == 1) && (paramInt < 0)) {
        return $Mn(localObject);
      }
      for (int j = 1; j < i; j++) {
        localObject = apply2(paramInt, localObject, paramArrayOfObject[j]);
      }
    }
  }
  
  public Object applyN(Object[] paramArrayOfObject)
  {
    return applyN(this.plusOrMinus, paramArrayOfObject);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.AddOp
 * JD-Core Version:    0.7.0.1
 */