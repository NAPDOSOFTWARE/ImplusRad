package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Duration
  extends Quantity
  implements Externalizable
{
  int months;
  int nanos;
  long seconds;
  public Unit unit;
  
  public static Duration add(Duration paramDuration1, Duration paramDuration2, int paramInt)
  {
    long l1 = paramDuration1.months + paramInt * paramDuration2.months;
    long l2 = 1000000000L * paramDuration1.seconds + paramDuration1.nanos + paramInt * (1000000000L * paramDuration2.seconds + paramDuration2.nanos);
    Duration localDuration = new Duration();
    localDuration.months = ((int)l1);
    localDuration.seconds = ((int)(l2 / 1000000000L));
    localDuration.nanos = ((int)(l2 % 1000000000L));
    if ((paramDuration1.unit != paramDuration2.unit) || (paramDuration1.unit == Unit.duration)) {
      throw new ArithmeticException("cannot add these duration types");
    }
    localDuration.unit = paramDuration1.unit;
    return localDuration;
  }
  
  static void appendNanoSeconds(int paramInt, StringBuffer paramStringBuffer)
  {
    if (paramInt == 0) {
      return;
    }
    paramStringBuffer.append('.');
    int i = paramStringBuffer.length();
    paramStringBuffer.append(paramInt);
    int j = paramStringBuffer.length();
    int k = i + 9 - j;
    for (;;)
    {
      k--;
      if (k < 0) {
        break;
      }
      paramStringBuffer.insert(i, '0');
    }
    int m = i + 9;
    do
    {
      m--;
    } while (paramStringBuffer.charAt(m) == '0');
    paramStringBuffer.setLength(m + 1);
  }
  
  public static int compare(Duration paramDuration1, Duration paramDuration2)
  {
    long l1 = paramDuration1.months - paramDuration2.months;
    long l2 = 1000000000L * paramDuration1.seconds + paramDuration1.nanos - (1000000000L * paramDuration2.seconds + paramDuration2.nanos);
    if ((l1 < 0L) && (l2 <= 0L)) {}
    do
    {
      return -1;
      if ((l1 > 0L) && (l2 >= 0L)) {
        return 1;
      }
      if (l1 != 0L) {
        break;
      }
    } while (l2 < 0L);
    if (l2 > 0L) {
      return 1;
    }
    return 0;
    return -2;
  }
  
  public static double div(Duration paramDuration1, Duration paramDuration2)
  {
    int i = paramDuration1.months;
    int j = paramDuration2.months;
    double d1 = paramDuration1.seconds + 1.E-009D * paramDuration1.nanos;
    double d2 = paramDuration2.seconds + 1.E-009D * paramDuration1.nanos;
    if ((j == 0) && (d2 == 0.0D)) {
      throw new ArithmeticException("divide duration by zero");
    }
    if (j == 0)
    {
      if (i == 0) {
        return d1 / d2;
      }
    }
    else if ((d2 == 0.0D) && (d1 == 0.0D)) {
      return i / j;
    }
    throw new ArithmeticException("divide of incompatible durations");
  }
  
  public static boolean equals(Duration paramDuration1, Duration paramDuration2)
  {
    return (paramDuration1.months == paramDuration2.months) && (paramDuration1.seconds == paramDuration2.seconds) && (paramDuration1.nanos == paramDuration2.nanos);
  }
  
  public static Duration make(int paramInt1, long paramLong, int paramInt2, Unit paramUnit)
  {
    Duration localDuration = new Duration();
    localDuration.months = paramInt1;
    localDuration.seconds = paramLong;
    localDuration.nanos = paramInt2;
    localDuration.unit = paramUnit;
    return localDuration;
  }
  
  public static Duration makeMinutes(int paramInt)
  {
    Duration localDuration = new Duration();
    localDuration.unit = Unit.second;
    localDuration.seconds = (paramInt * 60);
    return localDuration;
  }
  
  public static Duration makeMonths(int paramInt)
  {
    Duration localDuration = new Duration();
    localDuration.unit = Unit.month;
    localDuration.months = paramInt;
    return localDuration;
  }
  
  public static Duration parse(String paramString, Unit paramUnit)
  {
    Duration localDuration = valueOf(paramString, paramUnit);
    if (localDuration == null) {
      throw new IllegalArgumentException("not a valid " + paramUnit.getName() + " duration: '" + paramString + "'");
    }
    return localDuration;
  }
  
  public static Duration parseDayTimeDuration(String paramString)
  {
    return parse(paramString, Unit.second);
  }
  
  public static Duration parseDuration(String paramString)
  {
    return parse(paramString, Unit.duration);
  }
  
  public static Duration parseYearMonthDuration(String paramString)
  {
    return parse(paramString, Unit.month);
  }
  
  private static long scanPart(String paramString, int paramInt)
  {
    long l1 = -1L;
    int i = paramInt;
    long l2 = -1L;
    int j = paramString.length();
    if (i < j)
    {
      c = paramString.charAt(i);
      i++;
      k = Character.digit(c, 10);
      if (k < 0) {
        if (l2 < 0L) {
          l1 = paramInt << 16;
        }
      }
    }
    while (l2 >= 0L)
    {
      char c;
      int k;
      return l1;
      return l2 << 32 | i << 16 | c;
      if (l2 < 0L) {}
      for (l2 = k; l2 > 2147483647L; l2 = 10L * l2 + k) {
        return l1;
      }
      break;
    }
    return paramInt << 16;
  }
  
  public static Duration times(Duration paramDuration, double paramDouble)
  {
    if (paramDuration.unit == Unit.duration) {
      throw new IllegalArgumentException("cannot multiply general duration");
    }
    double d1 = paramDouble * paramDuration.months;
    if ((Double.isInfinite(d1)) || (Double.isNaN(d1))) {
      throw new ArithmeticException("overflow/NaN when multiplying a duration");
    }
    double d2 = paramDouble * (1000000000L * paramDuration.seconds + paramDuration.nanos);
    Duration localDuration = new Duration();
    localDuration.months = ((int)Math.floor(0.5D + d1));
    localDuration.seconds = ((int)(d2 / 1000000000.0D));
    localDuration.nanos = ((int)(d2 % 1000000000.0D));
    localDuration.unit = paramDuration.unit;
    return localDuration;
  }
  
  public static Duration valueOf(String paramString, Unit paramUnit)
  {
    String str = paramString.trim();
    int i = str.length();
    int j;
    if ((i < 0) && (str.charAt(0) == '-')) {
      j = 1;
    }
    for (int k = 0 + 1; (k + 1 >= i) || (str.charAt(k) != 'P'); k = 0)
    {
      return null;
      j = 0;
    }
    int m = k + 1;
    long l1 = 0L;
    long l2 = scanPart(str, m);
    int n = (int)l2 >> 16;
    int i1 = (char)(int)l2;
    if ((paramUnit == Unit.second) && ((i1 == 89) || (i1 == 77))) {
      return null;
    }
    int i2 = 0;
    if (i1 == 89)
    {
      i2 = 12 * (int)(l2 >> 32);
      n = (int)l2 >> 16;
      l2 = scanPart(str, n);
      i1 = (char)(int)l2;
    }
    if (i1 == 77)
    {
      i2 = (int)(i2 + (l2 >> 32));
      n = (int)l2 >> 16;
      l2 = scanPart(str, n);
      i1 = (char)(int)l2;
    }
    if ((paramUnit == Unit.month) && (n != i)) {
      return null;
    }
    if (i1 == 68)
    {
      if (paramUnit == Unit.month) {
        return null;
      }
      l1 = 86400L * (int)(l2 >> 32);
      n = (int)l2 >> 16;
      l2 = scanPart(str, n);
    }
    if (l2 != n << 16) {
      return null;
    }
    int i3 = 0;
    if (n == i) {}
    char c;
    int i6;
    int i7;
    int i10;
    int i8;
    for (;;)
    {
      if (n != i)
      {
        return null;
        if (str.charAt(n) == 'T')
        {
          n++;
          if (n != i) {}
        }
        else
        {
          return null;
        }
        if (paramUnit == Unit.month) {
          return null;
        }
        long l3 = scanPart(str, n);
        c = (char)(int)l3;
        if (c == 'H')
        {
          l1 += 3600 * (int)(l3 >> 32);
          n = (int)l3 >> 16;
          l3 = scanPart(str, n);
          c = (char)(int)l3;
        }
        if (c == 'M')
        {
          l1 += 60 * (int)(l3 >> 32);
          n = (int)l3 >> 16;
          l3 = scanPart(str, n);
          c = (char)(int)l3;
        }
        if ((c == 'S') || (c == '.'))
        {
          l1 += (int)(l3 >> 32);
          n = (int)l3 >> 16;
        }
        i3 = 0;
        if (c == '.')
        {
          int i4 = n + 1;
          i3 = 0;
          if (i4 < i)
          {
            int i5 = Character.digit(str.charAt(n), 10);
            i3 = 0;
            if (i5 >= 0)
            {
              i6 = 0;
              i7 = n;
              if (i7 >= i) {
                break label691;
              }
              n = i7 + 1;
              c = str.charAt(i7);
              i10 = Character.digit(c, 10);
              if (i10 < 0) {
                i8 = i6;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      int i9 = i8 + 1;
      if (i8 < 9)
      {
        i3 *= 10;
        i8 = i9;
        continue;
        if (i6 < 9) {}
        for (i3 = i10 + i3 * 10;; i3++) {
          do
          {
            i6++;
            i7 = n;
            break;
          } while ((i6 != 9) || (i10 < 5));
        }
      }
      else
      {
        if (c == 'S') {
          break;
        }
        return null;
        Duration localDuration = new Duration();
        if (j != 0)
        {
          i2 = -i2;
          l1 = -l1;
          i3 = -i3;
        }
        localDuration.months = i2;
        localDuration.seconds = l1;
        localDuration.nanos = i3;
        localDuration.unit = paramUnit;
        return localDuration;
        label691:
        i8 = i6;
        n = i7;
      }
    }
  }
  
  public Numeric add(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Duration)) {
      return add(this, (Duration)paramObject, paramInt);
    }
    if (((paramObject instanceof DateTime)) && (paramInt == 1)) {
      return DateTime.add((DateTime)paramObject, this, 1);
    }
    throw new IllegalArgumentException();
  }
  
  public int compare(Object paramObject)
  {
    if ((paramObject instanceof Duration)) {
      return compare(this, (Duration)paramObject);
    }
    throw new IllegalArgumentException();
  }
  
  public Numeric div(Object paramObject)
  {
    if ((paramObject instanceof RealNum))
    {
      double d = ((RealNum)paramObject).doubleValue();
      if ((d == 0.0D) || (Double.isNaN(d))) {
        throw new ArithmeticException("divide of duration by 0 or NaN");
      }
      return times(this, 1.0D / d);
    }
    if ((paramObject instanceof Duration)) {
      return new DFloNum(div(this, (Duration)paramObject));
    }
    return ((Numeric)paramObject).divReversed(this);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Duration))) {
      return false;
    }
    return equals(this, (Duration)paramObject);
  }
  
  public int getDays()
  {
    return (int)(this.seconds / 86400L);
  }
  
  public int getHours()
  {
    return (int)(this.seconds / 3600L % 24L);
  }
  
  public int getMinutes()
  {
    return (int)(this.seconds / 60L % 60L);
  }
  
  public int getMonths()
  {
    return this.months % 12;
  }
  
  public long getNanoSeconds()
  {
    return 1000000000L * this.seconds + this.nanos;
  }
  
  public int getNanoSecondsOnly()
  {
    return this.nanos;
  }
  
  public int getSecondsOnly()
  {
    return (int)(this.seconds % 60L);
  }
  
  public long getTotalMinutes()
  {
    return this.seconds / 60L;
  }
  
  public int getTotalMonths()
  {
    return this.months;
  }
  
  public long getTotalSeconds()
  {
    return this.seconds;
  }
  
  public int getYears()
  {
    return this.months / 12;
  }
  
  public int hashCode()
  {
    return this.months ^ (int)this.seconds ^ this.nanos;
  }
  
  public boolean isExact()
  {
    return false;
  }
  
  public boolean isZero()
  {
    return (this.months == 0) && (this.seconds == 0L) && (this.nanos == 0);
  }
  
  public Numeric mul(Object paramObject)
  {
    if ((paramObject instanceof RealNum)) {
      return times(this, ((RealNum)paramObject).doubleValue());
    }
    return ((Numeric)paramObject).mulReversed(this);
  }
  
  public Numeric mulReversed(Numeric paramNumeric)
  {
    if (!(paramNumeric instanceof RealNum)) {
      throw new IllegalArgumentException();
    }
    return times(this, ((RealNum)paramNumeric).doubleValue());
  }
  
  public Complex number()
  {
    throw new Error("number needs to be implemented!");
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.months = paramObjectInput.readInt();
    this.seconds = paramObjectInput.readLong();
    this.nanos = paramObjectInput.readInt();
    this.unit = ((Unit)paramObjectInput.readObject());
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = this.months;
    long l1 = this.seconds;
    int j = this.nanos;
    int k;
    if ((i < 0) || (l1 < 0L) || (j < 0))
    {
      k = 1;
      if (k != 0)
      {
        i = -i;
        l1 = -l1;
        j = -j;
        localStringBuffer.append('-');
      }
      localStringBuffer.append('P');
      int m = i / 12;
      if (m != 0)
      {
        localStringBuffer.append(m);
        localStringBuffer.append('Y');
        i -= m * 12;
      }
      if (i != 0)
      {
        localStringBuffer.append(i);
        localStringBuffer.append('M');
      }
      long l2 = l1 / 86400L;
      if (l2 != 0L)
      {
        localStringBuffer.append(l2);
        localStringBuffer.append('D');
        l1 -= 86400L * l2;
      }
      if ((l1 == 0L) && (j == 0)) {
        break label292;
      }
      localStringBuffer.append('T');
      l3 = l1 / 3600L;
      if (l3 != 0L)
      {
        localStringBuffer.append(l3);
        localStringBuffer.append('H');
        l1 -= 3600L * l3;
      }
      l4 = l1 / 60L;
      if (l4 != 0L)
      {
        localStringBuffer.append(l4);
        localStringBuffer.append('M');
        l1 -= 60L * l4;
      }
      if ((l1 != 0L) || (j != 0))
      {
        localStringBuffer.append(l1);
        appendNanoSeconds(j, localStringBuffer);
        localStringBuffer.append('S');
      }
    }
    label292:
    while (localStringBuffer.length() != 1)
    {
      long l3;
      long l4;
      return localStringBuffer.toString();
      k = 0;
      break;
    }
    if (this.unit == Unit.month) {}
    for (String str = "0M";; str = "T0S")
    {
      localStringBuffer.append(str);
      break;
    }
  }
  
  public Unit unit()
  {
    return this.unit;
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeInt(this.months);
    paramObjectOutput.writeLong(this.seconds);
    paramObjectOutput.writeInt(this.nanos);
    paramObjectOutput.writeObject(this.unit);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.math.Duration
 * JD-Core Version:    0.7.0.1
 */