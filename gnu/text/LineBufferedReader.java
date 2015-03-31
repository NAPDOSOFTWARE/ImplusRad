package gnu.text;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class LineBufferedReader
  extends Reader
{
  public static final int BUFFER_SIZE = 8192;
  private static final int CONVERT_CR = 1;
  private static final int DONT_KEEP_FULL_LINES = 8;
  private static final int PREV_WAS_CR = 4;
  private static final int USER_BUFFER = 2;
  public char[] buffer;
  private int flags;
  int highestPos;
  protected Reader in;
  public int limit;
  protected int lineNumber;
  private int lineStartPos;
  protected int markPos;
  Path path;
  public int pos;
  protected int readAheadLimit = 0;
  public char readState = '\n';
  
  public LineBufferedReader(InputStream paramInputStream)
  {
    this.in = new InputStreamReader(paramInputStream);
  }
  
  public LineBufferedReader(Reader paramReader)
  {
    this.in = paramReader;
  }
  
  private void clearMark()
  {
    this.readAheadLimit = 0;
    int i = this.lineStartPos;
    int j = 0;
    if (i < 0) {}
    for (;;)
    {
      j++;
      if (j >= this.pos)
      {
        return;
        j = this.lineStartPos;
      }
      else
      {
        int k = this.buffer[(j - 1)];
        if ((k == 10) || ((k == 13) && ((!getConvertCR()) || (this.buffer[j] != '\n'))))
        {
          this.lineNumber = (1 + this.lineNumber);
          this.lineStartPos = j;
        }
      }
    }
  }
  
  static int countLines(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    for (int k = paramInt1; k < paramInt2; k++)
    {
      int m = paramArrayOfChar[k];
      if (((m == 10) && (j != 13)) || (m == 13)) {
        i++;
      }
      j = m;
    }
    return i;
  }
  
  private void reserve(char[] paramArrayOfChar, int paramInt)
    throws IOException
  {
    int i = paramInt + this.limit;
    if (i <= paramArrayOfChar.length)
    {
      j = 0;
      if (this.limit > 0) {
        System.arraycopy(this.buffer, j, paramArrayOfChar, 0, this.limit);
      }
      this.buffer = paramArrayOfChar;
      return;
    }
    int j = this.pos;
    label108:
    int k;
    if ((this.readAheadLimit > 0) && (this.markPos < this.pos))
    {
      if ((this.pos - this.markPos > this.readAheadLimit) || (((0x2 & this.flags) != 0) && (i - this.markPos > paramArrayOfChar.length))) {
        clearMark();
      }
    }
    else
    {
      k = i - paramArrayOfChar.length;
      if ((k > j) || ((j > this.lineStartPos) && ((0x8 & this.flags) == 0))) {
        break label207;
      }
    }
    for (;;)
    {
      this.lineStartPos -= j;
      this.limit -= j;
      this.markPos -= j;
      this.pos -= j;
      this.highestPos -= j;
      break;
      j = this.markPos;
      break label108;
      label207:
      if ((k <= this.lineStartPos) && (j > this.lineStartPos))
      {
        j = this.lineStartPos;
      }
      else if ((0x2 & this.flags) != 0)
      {
        j -= (j - k >> 2);
      }
      else
      {
        if (this.lineStartPos >= 0) {
          j = this.lineStartPos;
        }
        paramArrayOfChar = new char[2 * paramArrayOfChar.length];
      }
    }
  }
  
  public void close()
    throws IOException
  {
    this.in.close();
  }
  
  public int fill(int paramInt)
    throws IOException
  {
    return this.in.read(this.buffer, this.pos, paramInt);
  }
  
  public int getColumnNumber()
  {
    if (this.pos > 0)
    {
      int i2 = this.buffer[(-1 + this.pos)];
      if ((i2 == 10) || (i2 == 13)) {
        return 0;
      }
    }
    if (this.readAheadLimit <= 0) {
      return this.pos - this.lineStartPos;
    }
    int i = this.lineStartPos;
    int j = 0;
    if (i < 0) {}
    for (;;)
    {
      int n;
      for (int k = j; k < this.pos; k = n)
      {
        char[] arrayOfChar = this.buffer;
        n = k + 1;
        int i1 = arrayOfChar[k];
        if ((i1 == 10) || (i1 == 13)) {
          j = n;
        }
      }
      j = this.lineStartPos;
    }
    int m = this.pos - j;
    if (this.lineStartPos < 0) {
      m -= this.lineStartPos;
    }
    return m;
  }
  
  public final boolean getConvertCR()
  {
    return (0x1 & this.flags) != 0;
  }
  
  public int getLineNumber()
  {
    int i = this.lineNumber;
    if (this.readAheadLimit == 0)
    {
      if ((this.pos > 0) && (this.pos > this.lineStartPos))
      {
        int k = this.buffer[(-1 + this.pos)];
        if ((k == 10) || (k == 13)) {
          i++;
        }
      }
      return i;
    }
    char[] arrayOfChar = this.buffer;
    if (this.lineStartPos < 0) {}
    for (int j = 0;; j = this.lineStartPos) {
      return i + countLines(arrayOfChar, j, this.pos);
    }
  }
  
  public String getName()
  {
    if (this.path == null) {
      return null;
    }
    return this.path.toString();
  }
  
  public Path getPath()
  {
    return this.path;
  }
  
  public char getReadState()
  {
    return this.readState;
  }
  
  public void incrLineNumber(int paramInt1, int paramInt2)
  {
    this.lineNumber = (paramInt1 + this.lineNumber);
    this.lineStartPos = paramInt2;
  }
  
  public void lineStart(boolean paramBoolean)
    throws IOException
  {}
  
  public void mark(int paramInt)
  {
    try
    {
      if (this.readAheadLimit > 0) {
        clearMark();
      }
      this.readAheadLimit = paramInt;
      this.markPos = this.pos;
      return;
    }
    finally {}
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int peek()
    throws IOException
  {
    if ((this.pos < this.limit) && (this.pos > 0))
    {
      int j = this.buffer[(-1 + this.pos)];
      if ((j != 10) && (j != 13))
      {
        int k = this.buffer[this.pos];
        if ((k == 13) && (getConvertCR())) {
          k = 10;
        }
        return k;
      }
    }
    int i = read();
    if (i >= 0) {
      unread_quick();
    }
    return i;
  }
  
  public int read()
    throws IOException
  {
    int i;
    boolean bool;
    label91:
    label114:
    label119:
    int m;
    label160:
    label183:
    int k;
    if (this.pos > 0)
    {
      i = this.buffer[(-1 + this.pos)];
      if ((i == 13) || (i == 10))
      {
        if ((this.lineStartPos < this.pos) && ((this.readAheadLimit == 0) || (this.pos <= this.markPos)))
        {
          this.lineStartPos = this.pos;
          this.lineNumber = (1 + this.lineNumber);
        }
        if (this.pos >= this.highestPos) {
          break label243;
        }
        bool = true;
        if (i == 10)
        {
          if (this.pos > 1) {
            break label248;
          }
          if ((0x4 & this.flags) != 0) {}
        }
        else
        {
          lineStart(bool);
        }
        if (!bool) {
          this.highestPos = (1 + this.pos);
        }
      }
      if (this.pos < this.limit) {
        break label317;
      }
      if (this.buffer != null) {
        break label268;
      }
      this.buffer = new char[8192];
      if (this.pos == 0)
      {
        if (i != 13) {
          break label292;
        }
        this.flags = (0x4 | this.flags);
      }
      m = fill(this.buffer.length - this.pos);
      if (m > 0) {
        break label306;
      }
      k = -1;
    }
    label243:
    label248:
    do
    {
      do
      {
        do
        {
          return k;
          if ((0x4 & this.flags) != 0)
          {
            i = 13;
            break;
          }
          if (this.lineStartPos >= 0)
          {
            i = 10;
            break;
          }
          i = 0;
          break;
          bool = false;
          break label91;
          if (this.buffer[(-2 + this.pos)] == '\r') {
            break label119;
          }
          break label114;
          if (this.limit != this.buffer.length) {
            break label160;
          }
          reserve(this.buffer, 1);
          break label160;
          this.flags = (0xFFFFFFFB & this.flags);
          break label183;
          this.limit = (m + this.limit);
          char[] arrayOfChar = this.buffer;
          int j = this.pos;
          this.pos = (j + 1);
          k = arrayOfChar[j];
          if (k != 10) {
            break label400;
          }
        } while (i != 13);
        if (this.lineStartPos == -1 + this.pos)
        {
          this.lineNumber = (-1 + this.lineNumber);
          this.lineStartPos = (-1 + this.lineStartPos);
        }
      } while (!getConvertCR());
      return read();
    } while ((k != 13) || (!getConvertCR()));
    label268:
    label292:
    label306:
    label317:
    return 10;
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    int i;
    int j;
    int k;
    if (this.pos >= this.limit)
    {
      i = 0;
      j = paramInt2;
      k = paramInt1;
    }
    for (;;)
    {
      if (j > 0)
      {
        if ((this.pos >= this.limit) || (i == 10) || (i == 13))
        {
          if ((this.pos >= this.limit) && (j < paramInt2))
          {
            return paramInt2 - j;
            if (this.pos > 0)
            {
              i = this.buffer[(-1 + this.pos)];
              break;
            }
            if (((0x4 & this.flags) != 0) || (this.lineStartPos >= 0))
            {
              i = 10;
              break;
            }
            i = 0;
            break;
          }
          i = read();
          if (i < 0)
          {
            int n = paramInt2 - j;
            if (n <= 0) {
              return -1;
            }
            return n;
          }
          int m = k + 1;
          paramArrayOfChar[k] = ((char)i);
          j--;
          k = m;
          continue;
        }
        int i1 = this.pos;
        int i2 = this.limit;
        if (j < i2 - i1) {
          i2 = i1 + j;
        }
        for (;;)
        {
          if (i1 < i2)
          {
            i = this.buffer[i1];
            if ((i != 10) && (i != 13)) {}
          }
          else
          {
            j -= i1 - this.pos;
            this.pos = i1;
            break;
          }
          int i3 = k + 1;
          paramArrayOfChar[k] = ((char)i);
          i1++;
          k = i3;
        }
      }
    }
    return paramInt2;
  }
  
  public String readLine()
    throws IOException
  {
    int i = read();
    if (i < 0) {
      return null;
    }
    if ((i == 13) || (i == 10)) {
      return "";
    }
    int j = -1 + this.pos;
    int n;
    while (this.pos < this.limit)
    {
      char[] arrayOfChar = this.buffer;
      int k = this.pos;
      this.pos = (k + 1);
      int m = arrayOfChar[k];
      if ((m == 13) || (m == 10))
      {
        n = -1 + this.pos;
        if ((m == 10) || (getConvertCR())) {
          break label190;
        }
        if (this.pos < this.limit) {
          break label166;
        }
        this.pos = (-1 + this.pos);
      }
    }
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append(this.buffer, j, this.pos - j);
    readLine(localStringBuffer, 'I');
    return localStringBuffer.toString();
    label166:
    if (this.buffer[this.pos] == '\n') {
      this.pos = (1 + this.pos);
    }
    label190:
    return new String(this.buffer, j, n - j);
  }
  
  public void readLine(StringBuffer paramStringBuffer, char paramChar)
    throws IOException
  {
    for (;;)
    {
      if (read() < 0) {}
      int i;
      int m;
      do
      {
        do
        {
          do
          {
            return;
            i = -1 + this.pos;
            this.pos = i;
            int k;
            do
            {
              if (this.pos >= this.limit) {
                break;
              }
              char[] arrayOfChar = this.buffer;
              int j = this.pos;
              this.pos = (j + 1);
              k = arrayOfChar[j];
            } while ((k != 13) && (k != 10));
            paramStringBuffer.append(this.buffer, i, -1 + this.pos - i);
            if (paramChar == 'P')
            {
              this.pos = (-1 + this.pos);
              return;
            }
            if ((!getConvertCR()) && (k != 10)) {
              break;
            }
          } while (paramChar == 'I');
          paramStringBuffer.append('\n');
          return;
          if (paramChar != 'I') {
            paramStringBuffer.append('\r');
          }
          m = read();
          if (m != 10) {
            break;
          }
        } while (paramChar == 'I');
        paramStringBuffer.append('\n');
        return;
      } while (m < 0);
      unread_quick();
      return;
      paramStringBuffer.append(this.buffer, i, this.pos - i);
    }
  }
  
  public boolean ready()
    throws IOException
  {
    return (this.pos < this.limit) || (this.in.ready());
  }
  
  public void reset()
    throws IOException
  {
    if (this.readAheadLimit <= 0) {
      throw new IOException("mark invalid");
    }
    if (this.pos > this.highestPos) {
      this.highestPos = this.pos;
    }
    this.pos = this.markPos;
    this.readAheadLimit = 0;
  }
  
  public void setBuffer(char[] paramArrayOfChar)
    throws IOException
  {
    if (paramArrayOfChar == null)
    {
      if (this.buffer != null)
      {
        char[] arrayOfChar = new char[this.buffer.length];
        System.arraycopy(this.buffer, 0, arrayOfChar, 0, this.buffer.length);
        this.buffer = arrayOfChar;
      }
      this.flags = (0xFFFFFFFD & this.flags);
      return;
    }
    if (this.limit - this.pos > paramArrayOfChar.length) {
      throw new IOException("setBuffer - too short");
    }
    this.flags = (0x2 | this.flags);
    reserve(paramArrayOfChar, 0);
  }
  
  public final void setConvertCR(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0x1 | this.flags);
      return;
    }
    this.flags = (0xFFFFFFFE & this.flags);
  }
  
  public void setKeepFullLines(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0xFFFFFFF7 & this.flags);
      return;
    }
    this.flags = (0x8 | this.flags);
  }
  
  public void setLineNumber(int paramInt)
  {
    this.lineNumber += paramInt - getLineNumber();
  }
  
  public void setName(Object paramObject)
  {
    setPath(Path.valueOf(paramObject));
  }
  
  public void setPath(Path paramPath)
  {
    this.path = paramPath;
  }
  
  public int skip(int paramInt)
    throws IOException
  {
    if (paramInt < 0)
    {
      for (int n = -paramInt; (n > 0) && (this.pos > 0); n--) {
        unread();
      }
      paramInt += n;
      return paramInt;
    }
    int i = paramInt;
    int j;
    if (this.pos >= this.limit) {
      j = 0;
    }
    label52:
    int k;
    int m;
    for (;;)
    {
      if (i > 0) {
        if ((j == 10) || (j == 13) || (this.pos >= this.limit))
        {
          j = read();
          if (j < 0)
          {
            return paramInt - i;
            if (this.pos > 0) {
              j = this.buffer[(-1 + this.pos)];
            } else if (((0x4 & this.flags) != 0) || (this.lineStartPos >= 0)) {
              j = 10;
            } else {
              j = 0;
            }
          }
          else
          {
            i--;
          }
        }
        else
        {
          k = this.pos;
          m = this.limit;
          if (i < m - k) {
            m = k + i;
          }
        }
      }
    }
    for (;;)
    {
      if (k < m)
      {
        j = this.buffer[k];
        if ((j != 10) && (j != 13)) {}
      }
      else
      {
        i -= k - this.pos;
        this.pos = k;
        break label52;
        break;
      }
      k++;
    }
  }
  
  public void skip()
    throws IOException
  {
    read();
  }
  
  public void skipRestOfLine()
    throws IOException
  {
    int i;
    do
    {
      i = read();
      if (i < 0) {}
      int j;
      do
      {
        return;
        if (i != 13) {
          break;
        }
        j = read();
      } while ((j < 0) || (j == 10));
      unread();
      return;
    } while (i != 10);
  }
  
  public final void skip_quick()
    throws IOException
  {
    this.pos = (1 + this.pos);
  }
  
  public void unread()
    throws IOException
  {
    if (this.pos == 0) {
      throw new IOException("unread too much");
    }
    this.pos = (-1 + this.pos);
    int i = this.buffer[this.pos];
    if ((i == 10) || (i == 13))
    {
      if ((this.pos > 0) && (i == 10) && (getConvertCR()) && (this.buffer[(-1 + this.pos)] == '\r')) {
        this.pos = (-1 + this.pos);
      }
      if (this.pos < this.lineStartPos)
      {
        this.lineNumber = (-1 + this.lineNumber);
        for (int j = this.pos; j > 0; j++)
        {
          label121:
          char[] arrayOfChar = this.buffer;
          j--;
          int k = arrayOfChar[j];
          if ((k != 13) && (k != 10)) {
            break label121;
          }
        }
        this.lineStartPos = j;
      }
    }
  }
  
  public void unread_quick()
  {
    this.pos = (-1 + this.pos);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.text.LineBufferedReader
 * JD-Core Version:    0.7.0.1
 */