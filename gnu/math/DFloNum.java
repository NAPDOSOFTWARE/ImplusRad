package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class DFloNum
  extends RealNum
  implements Externalizable
{
  private static final DFloNum one = new DFloNum(1.0D);
  double value;
  
  public DFloNum() {}
  
  public DFloNum(double paramDouble)
  {
    this.value = paramDouble;
  }
  
  public DFloNum(String paramString)
    throws NumberFormatException
  {
    this.value = Double.valueOf(paramString).doubleValue();
    if ((this.value == 0.0D) && (paramString.charAt(0) == '-')) {
      this.value = 0.0D;
    }
  }
  
  public static DFloNum asDFloNumOrNull(Object paramObject)
  {
    if ((paramObject instanceof DFloNum)) {
      return (DFloNum)paramObject;
    }
    if (((paramObject instanceof RealNum)) || ((paramObject instanceof Number))) {
      return new DFloNum(((Number)paramObject).doubleValue());
    }
    return null;
  }
  
  public static int compare(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 > paramDouble2) {
      return 1;
    }
    if (paramDouble1 < paramDouble2) {
      return -1;
    }
    if (paramDouble1 == paramDouble2) {
      return 0;
    }
    return -2;
  }
  
  public static int compare(IntNum paramIntNum1, IntNum paramIntNum2, double paramDouble)
  {
    int i = 1;
    if (Double.isNaN(paramDouble)) {
      i = -2;
    }
    do
    {
      do
      {
        return i;
        if (!Double.isInfinite(paramDouble)) {
          break;
        }
        if (paramDouble >= 0.0D) {
          i = -1;
        }
      } while (!paramIntNum2.isZero());
      if (paramIntNum1.isZero()) {
        return -2;
      }
      i >>= 1;
    } while (paramIntNum1.isNegative());
    return i ^ 0xFFFFFFFF;
    long l1 = Double.doubleToLongBits(paramDouble);
    int j;
    int k;
    long l2;
    long l3;
    label117:
    IntNum localIntNum;
    if (l1 < 0L)
    {
      j = i;
      k = 0x7FF & (int)(l1 >> 52);
      l2 = l1 & 0xFFFFFFFF;
      if (k != 0) {
        break label172;
      }
      l3 = l2 << i;
      if (j != 0) {
        l3 = -l3;
      }
      localIntNum = IntNum.make(l3);
      if (k < 1075) {
        break label183;
      }
      localIntNum = IntNum.shift(localIntNum, k - 1075);
    }
    for (;;)
    {
      return IntNum.compare(paramIntNum1, IntNum.times(localIntNum, paramIntNum2));
      j = 0;
      break;
      label172:
      l3 = l2 | 0x0;
      break label117;
      label183:
      paramIntNum1 = IntNum.shift(paramIntNum1, 1075 - k);
    }
  }
  
  public static DFloNum make(double paramDouble)
  {
    return new DFloNum(paramDouble);
  }
  
  public static final DFloNum one()
  {
    return one;
  }
  
  public static RatNum toExact(double paramDouble)
  {
    int i = 1;
    if (Double.isInfinite(paramDouble))
    {
      if (paramDouble >= 0.0D) {}
      for (;;)
      {
        return RatNum.infinity(i);
        i = -1;
      }
    }
    if (Double.isNaN(paramDouble)) {
      throw new ArithmeticException("cannot convert NaN to exact rational");
    }
    long l1 = Double.doubleToLongBits(paramDouble);
    int j;
    int k;
    long l2;
    if (l1 < 0L)
    {
      j = i;
      k = 0x7FF & (int)(l1 >> 52);
      l2 = l1 & 0xFFFFFFFF;
      if (k != 0) {
        break label128;
      }
    }
    IntNum localIntNum;
    label128:
    for (long l3 = l2 << i;; l3 = l2 | 0x0)
    {
      if (j != 0) {
        l3 = -l3;
      }
      localIntNum = IntNum.make(l3);
      if (k < 1075) {
        break label139;
      }
      return IntNum.shift(localIntNum, k - 1075);
      j = 0;
      break;
    }
    label139:
    return RatNum.make(localIntNum, IntNum.shift(IntNum.one(), 1075 - k));
  }
  
  public Numeric add(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof RealNum)) {
      return new DFloNum(this.value + paramInt * ((RealNum)paramObject).doubleValue());
    }
    if (!(paramObject instanceof Numeric)) {
      throw new IllegalArgumentException();
    }
    return ((Numeric)paramObject).addReversed(this, paramInt);
  }
  
  public Numeric addReversed(Numeric paramNumeric, int paramInt)
  {
    if ((paramNumeric instanceof RealNum)) {
      return new DFloNum(((RealNum)paramNumeric).doubleValue() + paramInt * this.value);
    }
    throw new IllegalArgumentException();
  }
  
  public int compare(Object paramObject)
  {
    if ((paramObject instanceof RatNum))
    {
      RatNum localRatNum = (RatNum)paramObject;
      int i = compare(localRatNum.numerator(), localRatNum.denominator(), this.value);
      if (i < -1) {
        return i;
      }
      return -i;
    }
    return compare(this.value, ((RealNum)paramObject).doubleValue());
  }
  
  public int compareReversed(Numeric paramNumeric)
  {
    if ((paramNumeric instanceof RatNum))
    {
      RatNum localRatNum = (RatNum)paramNumeric;
      return compare(localRatNum.numerator(), localRatNum.denominator(), this.value);
    }
    return compare(((RealNum)paramNumeric).doubleValue(), this.value);
  }
  
  public Numeric div(Object paramObject)
  {
    if ((paramObject instanceof RealNum)) {
      return new DFloNum(this.value / ((RealNum)paramObject).doubleValue());
    }
    if (!(paramObject instanceof Numeric)) {
      throw new IllegalArgumentException();
    }
    return ((Numeric)paramObject).divReversed(this);
  }
  
  public Numeric divReversed(Numeric paramNumeric)
  {
    if ((paramNumeric instanceof RealNum)) {
      return new DFloNum(((RealNum)paramNumeric).doubleValue() / this.value);
    }
    throw new IllegalArgumentException();
  }
  
  public final double doubleValue()
  {
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof DFloNum)) && (Double.doubleToLongBits(((DFloNum)paramObject).value) == Double.doubleToLongBits(this.value));
  }
  
  public int hashCode()
  {
    return (int)this.value;
  }
  
  public boolean isExact()
  {
    return false;
  }
  
  public boolean isNegative()
  {
    return this.value < 0.0D;
  }
  
  public boolean isZero()
  {
    return this.value == 0.0D;
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public Numeric mul(Object paramObject)
  {
    if ((paramObject instanceof RealNum)) {
      return new DFloNum(this.value * ((RealNum)paramObject).doubleValue());
    }
    if (!(paramObject instanceof Numeric)) {
      throw new IllegalArgumentException();
    }
    return ((Numeric)paramObject).mulReversed(this);
  }
  
  public Numeric mulReversed(Numeric paramNumeric)
  {
    if ((paramNumeric instanceof RealNum)) {
      return new DFloNum(((RealNum)paramNumeric).doubleValue() * this.value);
    }
    throw new IllegalArgumentException();
  }
  
  public Numeric neg()
  {
    return new DFloNum(-this.value);
  }
  
  public Numeric power(IntNum paramIntNum)
  {
    return new DFloNum(Math.pow(doubleValue(), paramIntNum.doubleValue()));
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.value = paramObjectInput.readDouble();
  }
  
  public int sign()
  {
    if (this.value > 0.0D) {
      return 1;
    }
    if (this.value < 0.0D) {
      return -1;
    }
    if (this.value == 0.0D) {
      return 0;
    }
    return -2;
  }
  
  public String toString()
  {
    if (this.value == (1.0D / 0.0D)) {
      return "+inf.0";
    }
    if (this.value == (-1.0D / 0.0D)) {
      return "-inf.0";
    }
    if (Double.isNaN(this.value)) {
      return "+nan.0";
    }
    return Double.toString(this.value);
  }
  
  public String toString(int paramInt)
  {
    if (paramInt == 10) {
      return toString();
    }
    return "#d" + toString();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeDouble(this.value);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.math.DFloNum
 * JD-Core Version:    0.7.0.1
 */