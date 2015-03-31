package kawa.standard;

import gnu.expr.Special;
import gnu.lists.FString;
import gnu.mapping.Values;
import gnu.text.LineBufferedReader;
import java.io.IOException;

public class read_line
{
  public static Object apply(LineBufferedReader paramLineBufferedReader, String paramString)
    throws IOException
  {
    Object localObject;
    if (paramLineBufferedReader.read() < 0)
    {
      localObject = Special.eof;
      return localObject;
    }
    int i = -1 + paramLineBufferedReader.pos;
    int j = paramLineBufferedReader.limit;
    char[] arrayOfChar = paramLineBufferedReader.buffer;
    int k = -1;
    int i3;
    for (int m = i;; m = i3)
    {
      int n;
      if (m < j)
      {
        i3 = m + 1;
        int i4 = arrayOfChar[m];
        if ((i4 == 13) || (i4 == 10))
        {
          n = i3 - 1;
          int i5;
          if ((paramString == "trim") || (paramString == "peek"))
          {
            if (paramString == "peek") {
              k = 0;
            }
            if (i4 == 10) {
              i5 = 1;
            }
          }
          for (paramLineBufferedReader.pos = (n + i5);; paramLineBufferedReader.pos = n)
          {
            return new FString(arrayOfChar, i, n - i);
            if (n + 1 >= j) {
              break label194;
            }
            if (arrayOfChar[(n + 1)] == '\n') {}
            for (i5 = 2;; i5 = 1) {
              break;
            }
            if ((paramString != "concat") || (i4 != 10)) {
              break label194;
            }
            n++;
          }
        }
      }
      else
      {
        n = m;
        label194:
        StringBuffer localStringBuffer = new StringBuffer(100);
        if (n > i) {
          localStringBuffer.append(arrayOfChar, i, n - i);
        }
        paramLineBufferedReader.pos = n;
        char c;
        if (paramString == "peek") {
          c = 'P';
        }
        int i1;
        for (;;)
        {
          paramLineBufferedReader.readLine(localStringBuffer, c);
          i1 = localStringBuffer.length();
          if (paramString == "split")
          {
            if (i1 != 0) {
              break label351;
            }
            k = 0;
          }
          localObject = new FString(localStringBuffer, 0, i1);
          if (paramString != "split") {
            break;
          }
          return new Values(new Object[] { localObject, new FString(localStringBuffer, i1 - k, k) });
          if ((paramString == "concat") || (paramString == "split")) {
            c = 'A';
          } else {
            c = 'I';
          }
        }
        label351:
        int i2 = localStringBuffer.charAt(i1 - 1);
        if (i2 == 13) {
          k = 1;
        }
        for (;;)
        {
          i1 -= k;
          break;
          if (i2 != 10) {
            k = 0;
          } else if ((i2 > 2) && (localStringBuffer.charAt(i1 - 2) == '\r')) {
            k = 2;
          } else {
            k = 1;
          }
        }
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.read_line
 * JD-Core Version:    0.7.0.1
 */