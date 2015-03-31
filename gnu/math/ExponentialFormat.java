package gnu.math;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class ExponentialFormat
  extends Format
{
  static final double LOG10 = Math.log(10.0D);
  public int expDigits;
  public char exponentChar = 'E';
  public boolean exponentShowSign;
  public int fracDigits = -1;
  public boolean general;
  public int intDigits;
  public char overflowChar;
  public char padChar;
  public boolean showPlus;
  public int width;
  
  static boolean addOne(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    for (;;)
    {
      if (i == paramInt1)
      {
        paramStringBuffer.insert(i, '1');
        return true;
      }
      i--;
      int j = paramStringBuffer.charAt(i);
      if (j != 57)
      {
        paramStringBuffer.setCharAt(i, (char)(j + 1));
        return false;
      }
      paramStringBuffer.setCharAt(i, '0');
    }
  }
  
  StringBuffer format(double paramDouble, String paramString, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    int i = this.intDigits;
    int j = this.fracDigits;
    int k;
    int m;
    int n;
    label57:
    int i1;
    int i2;
    label81:
    int i26;
    int i28;
    label147:
    int i4;
    if (paramDouble < 0.0D)
    {
      k = 1;
      if (k != 0) {
        paramDouble = -paramDouble;
      }
      m = paramStringBuffer.length();
      n = 1;
      if (k == 0) {
        break label209;
      }
      if (j >= 0) {
        paramStringBuffer.append('-');
      }
      i1 = paramStringBuffer.length();
      if ((!Double.isNaN(paramDouble)) && (!Double.isInfinite(paramDouble))) {
        break label233;
      }
      i2 = 1;
      if ((j >= 0) && (i2 == 0)) {
        break label527;
      }
      if (paramString == null) {
        paramString = Double.toString(paramDouble);
      }
      int i3 = paramString.indexOf('E');
      if (i3 < 0) {
        break label516;
      }
      paramStringBuffer.append(paramString);
      i26 = i3 + i1;
      int i27 = i26 + 1;
      if (paramString.charAt(i27) != '-') {
        break label239;
      }
      i28 = 1;
      i4 = 0;
      if (i28 == 0) {
        break label245;
      }
    }
    label209:
    label233:
    label239:
    label245:
    for (int i29 = 2;; i29 = 1)
    {
      for (int i30 = i26 + i29;; i30++)
      {
        int i31 = paramStringBuffer.length();
        if (i30 >= i31) {
          break;
        }
        i4 = i4 * 10 + ('￐' + paramStringBuffer.charAt(i30));
      }
      k = 0;
      break;
      if (this.showPlus)
      {
        paramStringBuffer.append('+');
        break label57;
      }
      n = 0;
      break label57;
      i2 = 0;
      break label81;
      i28 = 0;
      break label147;
    }
    if (i28 != 0) {
      i4 = -i4;
    }
    paramStringBuffer.setLength(i26);
    if (k != 0) {
      i1++;
    }
    paramStringBuffer.deleteCharAt(i1 + 1);
    int i5 = paramStringBuffer.length() - i1;
    if ((i5 > 1) && (paramStringBuffer.charAt(-1 + (i1 + i5)) == '0'))
    {
      i5--;
      paramStringBuffer.setLength(i1 + i5);
    }
    int i6 = -1 + (i5 - i4);
    int i7 = i4 - (i - 1);
    int i8;
    label360:
    label371:
    int i10;
    int i11;
    label399:
    int i12;
    if (i7 < 0)
    {
      i8 = -i7;
      if (i8 < 1000) {
        break label626;
      }
      i9 = 4;
      if (this.expDigits > i9) {
        i9 = this.expDigits;
      }
      i10 = 1;
      if (this.general) {
        break label658;
      }
      i11 = 0;
      if (j >= 0) {
        break label682;
      }
      i12 = 1;
      label407:
      if ((this.general) || (i12 != 0))
      {
        int i13 = i5 - i6;
        if (i12 != 0)
        {
          if (i13 >= 7) {
            break label688;
          }
          j = i13;
          label442:
          if (i5 > j) {
            j = i5;
          }
        }
        int i14 = j - i13;
        if ((!this.general) || (i13 < 0) || (i14 < 0)) {
          break label695;
        }
        i5 = j;
        i = i13;
        i10 = 0;
      }
    }
    int i15;
    label516:
    label527:
    label535:
    label608:
    label626:
    label761:
    for (;;)
    {
      i15 = i1 + i5;
      while (paramStringBuffer.length() < i15) {
        paramStringBuffer.append('0');
      }
      i4 = RealNum.toStringScientific(paramString, paramStringBuffer);
      break;
      int i32;
      int i33;
      if (i > 0)
      {
        i32 = 1;
        i5 = j + i32;
        i33 = (int)(1000.0D + Math.log(paramDouble) / LOG10);
        if (i33 != -2147483648) {
          break label608;
        }
      }
      for (int i34 = 0;; i34 = i33 - 1000)
      {
        i6 = -1 + (i5 - i34);
        RealNum.toScaledInt(paramDouble, i6).format(10, paramStringBuffer);
        i4 = i5 - 1 - i6;
        break;
        i32 = i;
        break label535;
      }
      i8 = i7;
      break label360;
      if (i8 >= 100)
      {
        i9 = 3;
        break label371;
      }
      if (i8 >= 10)
      {
        i9 = 2;
        break label371;
      }
      i9 = 1;
      break label371;
      if (this.expDigits > 0)
      {
        i11 = 2 + this.expDigits;
        break label399;
      }
      i11 = 4;
      break label399;
      i12 = 0;
      break label407;
      j = 7;
      break label442;
      if (i12 != 0)
      {
        if (this.width <= 0) {
          i5 = j;
        }
        for (;;)
        {
          if (i5 > 0) {
            break label761;
          }
          i5 = 1;
          break;
          i5 = -3 + (this.width - n - i9);
          if (i < 0) {
            i5 -= i;
          }
          if (i5 > j) {
            i5 = j;
          }
        }
      }
    }
    label658:
    label682:
    label688:
    label695:
    int i16;
    if (i15 == paramStringBuffer.length())
    {
      i16 = 48;
      if (i16 < 53) {
        break label872;
      }
    }
    int i18;
    label872:
    for (int i17 = 1;; i17 = 0)
    {
      if ((i17 != 0) && (addOne(paramStringBuffer, i1, i15))) {
        i6++;
      }
      (i6 - (paramStringBuffer.length() - i15));
      paramStringBuffer.setLength(i15);
      i18 = i1;
      if (i >= 0) {
        break label878;
      }
      int i25 = i;
      for (;;)
      {
        i25++;
        if (i25 > 0) {
          break;
        }
        paramStringBuffer.insert(i1, '0');
      }
      i16 = paramStringBuffer.charAt(i15);
      break;
    }
    label878:
    while (i1 + i > i15)
    {
      paramStringBuffer.append('0');
      i15++;
    }
    i18 += i;
    if (i2 != 0)
    {
      i10 = 0;
      if (i10 == 0) {
        break label1047;
      }
      paramStringBuffer.append(this.exponentChar);
      if ((this.exponentShowSign) || (i7 < 0)) {
        if (i7 < 0) {
          break label1040;
        }
      }
    }
    label1040:
    for (char c = '+';; c = '-')
    {
      paramStringBuffer.append(c);
      int i22 = paramStringBuffer.length();
      paramStringBuffer.append(i8);
      int i23 = paramStringBuffer.length();
      int i24 = this.expDigits - (i23 - i22);
      if (i24 <= 0) {
        break label1050;
      }
      (i23 + i24);
      for (;;)
      {
        i24--;
        if (i24 < 0) {
          break;
        }
        paramStringBuffer.insert(i22, '0');
      }
      paramStringBuffer.insert(i18, '.');
      break;
    }
    label1047:
    int i9 = 0;
    label1050:
    int i19 = paramStringBuffer.length() - m;
    int i20 = this.width - i19;
    if ((i12 != 0) && ((i18 + 1 == paramStringBuffer.length()) || (paramStringBuffer.charAt(i18 + 1) == this.exponentChar)) && ((this.width <= 0) || (i20 > 0)))
    {
      i20--;
      paramStringBuffer.insert(i18 + 1, '0');
    }
    if (((i20 >= 0) || (this.width <= 0)) && ((i10 == 0) || (i9 <= this.expDigits) || (this.expDigits <= 0) || (this.overflowChar == 0)))
    {
      if ((i <= 0) && ((i20 > 0) || (this.width <= 0)))
      {
        paramStringBuffer.insert(i1, '0');
        i20--;
      }
      if ((i10 == 0) && (this.width > 0)) {
        for (;;)
        {
          i11--;
          if (i11 < 0) {
            break;
          }
          paramStringBuffer.append(' ');
          i20--;
        }
      }
      for (;;)
      {
        i20--;
        if (i20 < 0) {
          break;
        }
        paramStringBuffer.insert(m, this.padChar);
      }
    }
    if (this.overflowChar != 0)
    {
      paramStringBuffer.setLength(m);
      int i21 = this.width;
      for (;;)
      {
        i21--;
        if (i21 < 0) {
          break;
        }
        paramStringBuffer.append(this.overflowChar);
      }
    }
    return paramStringBuffer;
  }
  
  public StringBuffer format(double paramDouble, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    if (this.fracDigits < 0) {}
    for (String str = Double.toString(paramDouble);; str = null) {
      return format(paramDouble, str, paramStringBuffer, paramFieldPosition);
    }
  }
  
  public StringBuffer format(float paramFloat, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    double d = paramFloat;
    if (this.fracDigits < 0) {}
    for (String str = Float.toString(paramFloat);; str = null) {
      return format(d, str, paramStringBuffer, paramFieldPosition);
    }
  }
  
  public StringBuffer format(long paramLong, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    return format(paramLong, paramStringBuffer, paramFieldPosition);
  }
  
  public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    return format(((RealNum)paramObject).doubleValue(), paramStringBuffer, paramFieldPosition);
  }
  
  public Number parse(String paramString, ParsePosition paramParsePosition)
  {
    throw new Error("ExponentialFormat.parse - not implemented");
  }
  
  public Object parseObject(String paramString, ParsePosition paramParsePosition)
  {
    throw new Error("ExponentialFormat.parseObject - not implemented");
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.math.ExponentialFormat
 * JD-Core Version:    0.7.0.1
 */