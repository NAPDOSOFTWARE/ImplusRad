package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class DComplex
  extends Complex
  implements Externalizable
{
  double imag;
  double real;
  
  public DComplex() {}
  
  public DComplex(double paramDouble1, double paramDouble2)
  {
    this.real = paramDouble1;
    this.imag = paramDouble2;
  }
  
  public static DComplex div(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d5;
    double d2;
    double d3;
    if (Math.abs(paramDouble3) <= Math.abs(paramDouble4))
    {
      d5 = paramDouble3 / paramDouble4;
      d2 = paramDouble4 * (1.0D + d5 * d5);
      d3 = paramDouble2 + paramDouble1 * d5;
    }
    double d1;
    for (double d4 = paramDouble2 * d5 - paramDouble1;; d4 = paramDouble2 - paramDouble1 * d1)
    {
      return new DComplex(d3 / d2, d4 / d2);
      d1 = paramDouble4 / paramDouble3;
      d2 = paramDouble3 * (1.0D + d1 * d1);
      d3 = paramDouble1 + paramDouble2 * d1;
    }
  }
  
  public static Complex log(double paramDouble1, double paramDouble2)
  {
    return make(Math.log(Math.hypot(paramDouble1, paramDouble2)), Math.atan2(paramDouble2, paramDouble1));
  }
  
  public static DComplex power(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d1 = Math.log(Math.hypot(paramDouble1, paramDouble2));
    double d2 = Math.atan2(paramDouble2, paramDouble1);
    return Complex.polar(Math.exp(d1 * paramDouble3 - paramDouble4 * d2), paramDouble4 * d1 + paramDouble3 * d2);
  }
  
  public static Complex sqrt(double paramDouble1, double paramDouble2)
  {
    double d1 = Math.hypot(paramDouble1, paramDouble2);
    double d2;
    double d3;
    if (d1 == 0.0D)
    {
      d2 = d1;
      d3 = d1;
    }
    for (;;)
    {
      return new DComplex(d3, d2);
      if (paramDouble1 > 0.0D)
      {
        d3 = Math.sqrt(0.5D * (d1 + paramDouble1));
        d2 = paramDouble2 / d3 / 2.0D;
      }
      else
      {
        d2 = Math.sqrt(0.5D * (d1 - paramDouble1));
        if (paramDouble2 < 0.0D) {
          d2 = -d2;
        }
        d3 = paramDouble2 / d2 / 2.0D;
      }
    }
  }
  
  public Numeric add(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Complex))
    {
      Complex localComplex = (Complex)paramObject;
      if (localComplex.dimensions() != Dimensions.Empty) {
        throw new ArithmeticException("units mis-match");
      }
      return new DComplex(this.real + paramInt * localComplex.reValue(), this.imag + paramInt * localComplex.imValue());
    }
    return ((Numeric)paramObject).addReversed(this, paramInt);
  }
  
  public Numeric div(Object paramObject)
  {
    if ((paramObject instanceof Complex))
    {
      Complex localComplex = (Complex)paramObject;
      return div(this.real, this.imag, localComplex.doubleValue(), localComplex.doubleImagValue());
    }
    return ((Numeric)paramObject).divReversed(this);
  }
  
  public double doubleImagValue()
  {
    return this.imag;
  }
  
  public double doubleValue()
  {
    return this.real;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Complex))) {}
    Complex localComplex;
    do
    {
      return false;
      localComplex = (Complex)paramObject;
    } while ((localComplex.unit() != Unit.Empty) || (Double.doubleToLongBits(this.real) != Double.doubleToLongBits(localComplex.reValue())) || (Double.doubleToLongBits(this.imag) != Double.doubleToLongBits(localComplex.imValue())));
    return true;
  }
  
  public RealNum im()
  {
    return new DFloNum(this.imag);
  }
  
  public boolean isExact()
  {
    return false;
  }
  
  public Numeric mul(Object paramObject)
  {
    if ((paramObject instanceof Complex))
    {
      Complex localComplex = (Complex)paramObject;
      if (localComplex.unit() == Unit.Empty)
      {
        double d1 = localComplex.reValue();
        double d2 = localComplex.imValue();
        return new DComplex(d1 * this.real - d2 * this.imag, d2 * this.real + d1 * this.imag);
      }
      return Complex.times(this, localComplex);
    }
    return ((Numeric)paramObject).mulReversed(this);
  }
  
  public final Numeric neg()
  {
    return new DComplex(-this.real, -this.imag);
  }
  
  public RealNum re()
  {
    return new DFloNum(this.real);
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.real = paramObjectInput.readDouble();
    this.imag = paramObjectInput.readDouble();
  }
  
  public Complex toExact()
  {
    return new CComplex(DFloNum.toExact(this.real), DFloNum.toExact(this.imag));
  }
  
  public String toString()
  {
    String str1 = "";
    String str2;
    if (this.real == (1.0D / 0.0D))
    {
      str1 = "#i";
      str2 = "1/0";
    }
    while (Double.doubleToLongBits(this.imag) == 0L)
    {
      return str1 + str2;
      if (this.real == (-1.0D / 0.0D))
      {
        str1 = "#i";
        str2 = "-1/0";
      }
      else if (Double.isNaN(this.real))
      {
        str1 = "#i";
        str2 = "0/0";
      }
      else
      {
        str2 = Double.toString(this.real);
      }
    }
    String str3;
    StringBuilder localStringBuilder;
    if (this.imag == (1.0D / 0.0D))
    {
      str1 = "#i";
      str3 = "+1/0i";
      localStringBuilder = new StringBuilder();
      if (Double.doubleToLongBits(this.real) != 0L) {
        break label255;
      }
    }
    label255:
    for (String str4 = str1;; str4 = str1 + str2)
    {
      return str4 + str3;
      if (this.imag == (-1.0D / 0.0D))
      {
        str1 = "#i";
        str3 = "-1/0i";
        break;
      }
      if (Double.isNaN(this.imag))
      {
        str1 = "#i";
        str3 = "+0/0i";
        break;
      }
      str3 = Double.toString(this.imag) + "i";
      if (str3.charAt(0) == '-') {
        break;
      }
      str3 = "+" + str3;
      break;
    }
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
    paramObjectOutput.writeDouble(this.real);
    paramObjectOutput.writeDouble(this.imag);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.math.DComplex
 * JD-Core Version:    0.7.0.1
 */