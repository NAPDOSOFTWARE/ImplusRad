package gnu.text;

import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;

public class PadFormat
  extends ReportFormat
{
  Format fmt;
  int minWidth;
  char padChar;
  int where;
  
  public PadFormat(Format paramFormat, int paramInt)
  {
    this(paramFormat, paramInt, ' ', 100);
  }
  
  public PadFormat(Format paramFormat, int paramInt1, char paramChar, int paramInt2)
  {
    this.fmt = paramFormat;
    this.minWidth = paramInt1;
    this.padChar = paramChar;
    this.where = paramInt2;
  }
  
  public static int format(Format paramFormat, Object[] paramArrayOfObject, int paramInt1, Writer paramWriter, char paramChar, int paramInt2, int paramInt3, int paramInt4, int paramInt5, FieldPosition paramFieldPosition)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer(200);
    int i;
    if ((paramFormat instanceof ReportFormat)) {
      i = ((ReportFormat)paramFormat).format(paramArrayOfObject, paramInt1, localStringBuffer, paramFieldPosition);
    }
    String str;
    int m;
    for (;;)
    {
      int j = localStringBuffer.length();
      int k = padNeeded(j, paramInt2, paramInt3, paramInt4);
      str = localStringBuffer.toString();
      if (k <= 0) {
        break label293;
      }
      if (paramInt5 == -1)
      {
        if (j > 0)
        {
          int i1 = str.charAt(0);
          int i2;
          if (i1 != 45)
          {
            i2 = 0;
            if (i1 != 43) {}
          }
          else
          {
            i2 = 0 + 1;
            paramWriter.write(i1);
          }
          if ((j - i2 > 2) && (str.charAt(i2) == '0'))
          {
            paramWriter.write(48);
            i2++;
            int i3 = str.charAt(i2);
            if ((i3 == 120) || (i3 == 88))
            {
              i2++;
              paramWriter.write(i3);
            }
          }
          if (i2 > 0) {
            str = str.substring(i2);
          }
        }
        paramInt5 = 0;
      }
      m = k * paramInt5 / 100;
      int n = k - m;
      for (;;)
      {
        n--;
        if (n < 0) {
          break;
        }
        paramWriter.write(paramChar);
      }
      if ((paramFormat instanceof MessageFormat))
      {
        paramFormat.format(paramArrayOfObject, localStringBuffer, paramFieldPosition);
        i = paramArrayOfObject.length;
      }
      else
      {
        paramFormat.format(paramArrayOfObject[paramInt1], localStringBuffer, paramFieldPosition);
        i = paramInt1 + 1;
      }
    }
    paramWriter.write(str);
    for (;;)
    {
      m--;
      if (m < 0) {
        break;
      }
      paramWriter.write(paramChar);
    }
    label293:
    paramWriter.write(str);
    return i;
  }
  
  public static int padNeeded(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1 + paramInt4;
    if (paramInt3 <= 1) {
      paramInt3 = paramInt2 - i;
    }
    while (i < paramInt2) {
      i += paramInt3;
    }
    return i - paramInt1;
  }
  
  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    return format(this.fmt, paramArrayOfObject, paramInt, paramWriter, this.padChar, this.minWidth, 1, 0, this.where, paramFieldPosition);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.text.PadFormat
 * JD-Core Version:    0.7.0.1
 */