package gnu.text;

import gnu.lists.CharSeq;
import java.io.Reader;

public class QueueReader
  extends Reader
  implements Appendable
{
  boolean EOFseen;
  char[] buffer;
  int limit;
  int mark;
  int pos;
  int readAheadLimit;
  
  public QueueReader append(char paramChar)
  {
    try
    {
      reserveSpace(1);
      char[] arrayOfChar = this.buffer;
      int i = this.limit;
      this.limit = (i + 1);
      arrayOfChar[i] = paramChar;
      notifyAll();
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public QueueReader append(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      paramCharSequence = "null";
    }
    return append(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public QueueReader append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramCharSequence == null) {
      paramCharSequence = "null";
    }
    int i = paramInt2 - paramInt1;
    for (;;)
    {
      int j;
      char[] arrayOfChar;
      try
      {
        reserveSpace(i);
        j = this.limit;
        arrayOfChar = this.buffer;
        if ((paramCharSequence instanceof String))
        {
          ((String)paramCharSequence).getChars(paramInt1, paramInt2, arrayOfChar, j);
          this.limit = (j + i);
          notifyAll();
          return this;
        }
        if ((paramCharSequence instanceof CharSeq))
        {
          ((CharSeq)paramCharSequence).getChars(paramInt1, paramInt2, arrayOfChar, j);
          continue;
        }
        k = paramInt1;
      }
      finally {}
      int k;
      int n;
      for (int m = j; k < paramInt2; m = n)
      {
        n = m + 1;
        arrayOfChar[m] = paramCharSequence.charAt(k);
        k++;
      }
    }
  }
  
  public void append(char[] paramArrayOfChar)
  {
    append(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public void append(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    try
    {
      reserveSpace(paramInt2);
      System.arraycopy(paramArrayOfChar, paramInt1, this.buffer, this.limit, paramInt2);
      this.limit = (paramInt2 + this.limit);
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void appendEOF()
  {
    try
    {
      this.EOFseen = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void checkAvailable() {}
  
  public void close()
  {
    try
    {
      this.pos = 0;
      this.limit = 0;
      this.mark = 0;
      this.EOFseen = true;
      this.buffer = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.readAheadLimit = paramInt;
      this.mark = this.pos;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  /* Error */
  public int read()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 85	gnu/text/QueueReader:pos	I
    //   6: aload_0
    //   7: getfield 29	gnu/text/QueueReader:limit	I
    //   10: if_icmplt +38 -> 48
    //   13: aload_0
    //   14: getfield 81	gnu/text/QueueReader:EOFseen	Z
    //   17: istore 5
    //   19: iload 5
    //   21: ifeq +11 -> 32
    //   24: iconst_m1
    //   25: istore 4
    //   27: aload_0
    //   28: monitorexit
    //   29: iload 4
    //   31: ireturn
    //   32: aload_0
    //   33: invokevirtual 96	gnu/text/QueueReader:checkAvailable	()V
    //   36: aload_0
    //   37: invokevirtual 99	java/lang/Object:wait	()V
    //   40: goto -38 -> 2
    //   43: astore 6
    //   45: goto -43 -> 2
    //   48: aload_0
    //   49: getfield 27	gnu/text/QueueReader:buffer	[C
    //   52: astore_2
    //   53: aload_0
    //   54: getfield 85	gnu/text/QueueReader:pos	I
    //   57: istore_3
    //   58: aload_0
    //   59: iload_3
    //   60: iconst_1
    //   61: iadd
    //   62: putfield 85	gnu/text/QueueReader:pos	I
    //   65: aload_2
    //   66: iload_3
    //   67: caload
    //   68: istore 4
    //   70: goto -43 -> 27
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	QueueReader
    //   73	4	1	localObject	Object
    //   52	14	2	arrayOfChar	char[]
    //   57	10	3	i	int
    //   25	44	4	j	int
    //   17	3	5	bool	boolean
    //   43	1	6	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   36	40	43	java/lang/InterruptedException
    //   2	19	73	finally
    //   32	36	73	finally
    //   36	40	73	finally
    //   48	70	73	finally
  }
  
  /* Error */
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifne +19 -> 22
    //   6: iconst_0
    //   7: istore 6
    //   9: aload_0
    //   10: monitorexit
    //   11: iload 6
    //   13: ireturn
    //   14: aload_0
    //   15: invokevirtual 96	gnu/text/QueueReader:checkAvailable	()V
    //   18: aload_0
    //   19: invokevirtual 99	java/lang/Object:wait	()V
    //   22: aload_0
    //   23: getfield 85	gnu/text/QueueReader:pos	I
    //   26: aload_0
    //   27: getfield 29	gnu/text/QueueReader:limit	I
    //   30: if_icmplt +16 -> 46
    //   33: aload_0
    //   34: getfield 81	gnu/text/QueueReader:EOFseen	Z
    //   37: ifeq -23 -> 14
    //   40: iconst_m1
    //   41: istore 6
    //   43: goto -34 -> 9
    //   46: aload_0
    //   47: getfield 29	gnu/text/QueueReader:limit	I
    //   50: aload_0
    //   51: getfield 85	gnu/text/QueueReader:pos	I
    //   54: isub
    //   55: istore 5
    //   57: iload_3
    //   58: iload 5
    //   60: if_icmple +6 -> 66
    //   63: iload 5
    //   65: istore_3
    //   66: aload_0
    //   67: getfield 27	gnu/text/QueueReader:buffer	[C
    //   70: aload_0
    //   71: getfield 85	gnu/text/QueueReader:pos	I
    //   74: aload_1
    //   75: iload_2
    //   76: iload_3
    //   77: invokestatic 78	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   80: aload_0
    //   81: iload_3
    //   82: aload_0
    //   83: getfield 85	gnu/text/QueueReader:pos	I
    //   86: iadd
    //   87: putfield 85	gnu/text/QueueReader:pos	I
    //   90: iload_3
    //   91: istore 6
    //   93: goto -84 -> 9
    //   96: astore 7
    //   98: goto -76 -> 22
    //   101: astore 4
    //   103: aload_0
    //   104: monitorexit
    //   105: aload 4
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	QueueReader
    //   0	108	1	paramArrayOfChar	char[]
    //   0	108	2	paramInt1	int
    //   0	108	3	paramInt2	int
    //   101	5	4	localObject	Object
    //   55	9	5	i	int
    //   7	85	6	j	int
    //   96	1	7	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   18	22	96	java/lang/InterruptedException
    //   14	18	101	finally
    //   18	22	101	finally
    //   22	40	101	finally
    //   46	57	101	finally
    //   66	90	101	finally
  }
  
  /* Error */
  public boolean ready()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 85	gnu/text/QueueReader:pos	I
    //   6: aload_0
    //   7: getfield 29	gnu/text/QueueReader:limit	I
    //   10: if_icmplt +12 -> 22
    //   13: aload_0
    //   14: getfield 81	gnu/text/QueueReader:EOFseen	Z
    //   17: istore_3
    //   18: iload_3
    //   19: ifeq +9 -> 28
    //   22: iconst_1
    //   23: istore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_2
    //   27: ireturn
    //   28: iconst_0
    //   29: istore_2
    //   30: goto -6 -> 24
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	QueueReader
    //   33	4	1	localObject	Object
    //   23	7	2	bool1	boolean
    //   17	2	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	33	finally
  }
  
  protected void reserveSpace(int paramInt)
  {
    if (this.buffer == null) {
      this.buffer = new char[paramInt + 100];
    }
    while (this.buffer.length >= paramInt + this.limit) {
      return;
    }
    resize(paramInt);
  }
  
  public void reset()
  {
    try
    {
      if (this.readAheadLimit > 0) {
        this.pos = this.mark;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void resize(int paramInt)
  {
    int i = this.limit - this.pos;
    if ((this.readAheadLimit > 0) && (this.pos - this.mark <= this.readAheadLimit))
    {
      i = this.limit - this.mark;
      if (this.buffer.length >= i + paramInt) {
        break label116;
      }
    }
    label116:
    for (char[] arrayOfChar = new char[paramInt + i * 2];; arrayOfChar = this.buffer)
    {
      System.arraycopy(this.buffer, this.mark, arrayOfChar, 0, i);
      this.buffer = arrayOfChar;
      this.pos -= this.mark;
      this.mark = 0;
      this.limit = i;
      return;
      this.mark = this.pos;
      break;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.text.QueueReader
 * JD-Core Version:    0.7.0.1
 */