package gnu.kawa.functions;

import gnu.math.IntNum;
import gnu.math.RealNum;
import gnu.text.EnglishIntegerFormat;
import gnu.text.RomanIntegerFormat;
import java.text.Format;

public class IntegerFormat
  extends gnu.text.IntegerFormat
{
  private static IntegerFormat plainDecimalFormat;
  
  public static IntegerFormat getInstance()
  {
    if (plainDecimalFormat == null) {
      plainDecimalFormat = new IntegerFormat();
    }
    return plainDecimalFormat;
  }
  
  public static Format getInstance(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = 1;
    if (paramInt1 == -1073741824)
    {
      if ((paramInt3 == -1073741824) && (paramInt3 == -1073741824) && (paramInt4 == -1073741824) && (paramInt5 == -1073741824))
      {
        if ((paramInt6 & 0x1) != 0) {}
        while ((paramInt6 & 0x2) != 0)
        {
          return RomanIntegerFormat.getInstance(i);
          i = 0;
        }
        return EnglishIntegerFormat.getInstance(i);
      }
      paramInt1 = 10;
    }
    if (paramInt2 == -1073741824) {
      paramInt2 = 1;
    }
    if (paramInt3 == -1073741824) {
      paramInt3 = 32;
    }
    if (paramInt4 == -1073741824) {
      paramInt4 = 44;
    }
    if (paramInt5 == -1073741824) {
      paramInt5 = 3;
    }
    if ((paramInt1 == 10) && (paramInt2 == i) && (paramInt3 == 32) && (paramInt4 == 44) && (paramInt5 == 3) && (paramInt6 == 0)) {
      return getInstance();
    }
    IntegerFormat localIntegerFormat = new IntegerFormat();
    localIntegerFormat.base = paramInt1;
    localIntegerFormat.minWidth = paramInt2;
    localIntegerFormat.padChar = paramInt3;
    localIntegerFormat.commaChar = paramInt4;
    localIntegerFormat.commaInterval = paramInt5;
    localIntegerFormat.flags = paramInt6;
    return localIntegerFormat;
  }
  
  public String convertToIntegerString(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof RealNum)) {
      return ((RealNum)paramObject).toExactInt(4).toString(paramInt);
    }
    return super.convertToIntegerString(paramObject, paramInt);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.IntegerFormat
 * JD-Core Version:    0.7.0.1
 */