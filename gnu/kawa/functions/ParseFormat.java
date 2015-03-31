package gnu.kawa.functions;

import gnu.mapping.Procedure1;
import gnu.text.CompoundFormat;
import gnu.text.LineBufferedReader;
import gnu.text.LiteralFormat;
import gnu.text.PadFormat;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.util.Vector;

public class ParseFormat
  extends Procedure1
{
  public static final int PARAM_FROM_LIST = -1610612736;
  public static final int PARAM_UNSPECIFIED = -1073741824;
  public static final int SEEN_HASH = 16;
  public static final int SEEN_MINUS = 1;
  public static final int SEEN_PLUS = 2;
  public static final int SEEN_SPACE = 4;
  public static final int SEEN_ZERO = 8;
  public static final ParseFormat parseFormat = new ParseFormat(false);
  boolean emacsStyle = true;
  
  public ParseFormat(boolean paramBoolean)
  {
    this.emacsStyle = paramBoolean;
  }
  
  /* Error */
  public static ReportFormat asFormat(Object paramObject, char paramChar)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 45
    //   4: ifeq +8 -> 12
    //   7: aload_0
    //   8: checkcast 45	gnu/text/ReportFormat
    //   11: areturn
    //   12: iload_1
    //   13: bipush 126
    //   15: if_icmpne +15 -> 30
    //   18: new 47	gnu/kawa/functions/LispFormat
    //   21: dup
    //   22: aload_0
    //   23: invokevirtual 53	java/lang/Object:toString	()Ljava/lang/String;
    //   26: invokespecial 56	gnu/kawa/functions/LispFormat:<init>	(Ljava/lang/String;)V
    //   29: areturn
    //   30: aload_0
    //   31: instanceof 58
    //   34: ifeq +79 -> 113
    //   37: aload_0
    //   38: checkcast 58	gnu/lists/FString
    //   41: astore 8
    //   43: new 60	gnu/mapping/CharArrayInPort
    //   46: dup
    //   47: aload 8
    //   49: getfield 64	gnu/lists/FString:data	[C
    //   52: aload 8
    //   54: getfield 67	gnu/lists/FString:size	I
    //   57: invokespecial 70	gnu/mapping/CharArrayInPort:<init>	([CI)V
    //   60: astore 5
    //   62: aload 5
    //   64: iload_1
    //   65: invokestatic 73	gnu/kawa/functions/ParseFormat:parseFormat	(Lgnu/text/LineBufferedReader;C)Lgnu/text/ReportFormat;
    //   68: astore 7
    //   70: aload 5
    //   72: invokevirtual 78	gnu/mapping/InPort:close	()V
    //   75: aload 7
    //   77: areturn
    //   78: astore 4
    //   80: new 80	java/lang/RuntimeException
    //   83: dup
    //   84: new 82	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   91: ldc 85
    //   93: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 4
    //   98: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   101: ldc 94
    //   103: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokespecial 96	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   112: athrow
    //   113: new 60	gnu/mapping/CharArrayInPort
    //   116: dup
    //   117: aload_0
    //   118: invokevirtual 53	java/lang/Object:toString	()Ljava/lang/String;
    //   121: invokespecial 97	gnu/mapping/CharArrayInPort:<init>	(Ljava/lang/String;)V
    //   124: astore 5
    //   126: goto -64 -> 62
    //   129: astore 6
    //   131: aload 5
    //   133: invokevirtual 78	gnu/mapping/InPort:close	()V
    //   136: aload 6
    //   138: athrow
    //   139: astore_3
    //   140: new 80	java/lang/RuntimeException
    //   143: dup
    //   144: new 82	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   151: ldc 99
    //   153: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_3
    //   157: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: ldc 94
    //   162: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokespecial 96	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   171: athrow
    //   172: astore_2
    //   173: new 80	java/lang/RuntimeException
    //   176: dup
    //   177: ldc 101
    //   179: invokespecial 96	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramObject	Object
    //   0	183	1	paramChar	char
    //   172	1	2	localIndexOutOfBoundsException	java.lang.IndexOutOfBoundsException
    //   139	18	3	localParseException	ParseException
    //   78	19	4	localIOException	IOException
    //   60	72	5	localCharArrayInPort	gnu.mapping.CharArrayInPort
    //   129	8	6	localObject	Object
    //   68	8	7	localReportFormat	ReportFormat
    //   41	12	8	localFString	gnu.lists.FString
    // Exception table:
    //   from	to	target	type
    //   0	12	78	java/io/IOException
    //   18	30	78	java/io/IOException
    //   30	62	78	java/io/IOException
    //   70	75	78	java/io/IOException
    //   113	126	78	java/io/IOException
    //   131	139	78	java/io/IOException
    //   62	70	129	finally
    //   0	12	139	java/text/ParseException
    //   18	30	139	java/text/ParseException
    //   30	62	139	java/text/ParseException
    //   70	75	139	java/text/ParseException
    //   113	126	139	java/text/ParseException
    //   131	139	139	java/text/ParseException
    //   0	12	172	java/lang/IndexOutOfBoundsException
    //   18	30	172	java/lang/IndexOutOfBoundsException
    //   30	62	172	java/lang/IndexOutOfBoundsException
    //   70	75	172	java/lang/IndexOutOfBoundsException
    //   113	126	172	java/lang/IndexOutOfBoundsException
    //   131	139	172	java/lang/IndexOutOfBoundsException
  }
  
  public static ReportFormat parseFormat(LineBufferedReader paramLineBufferedReader, char paramChar)
    throws ParseException, IOException
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    int i = 0;
    Vector localVector = new Vector();
    char c1;
    for (;;)
    {
      c1 = paramLineBufferedReader.read();
      if (c1 < 0) {
        break;
      }
      if (c1 != paramChar)
      {
        localStringBuffer.append((char)c1);
      }
      else
      {
        c1 = paramLineBufferedReader.read();
        if (c1 != paramChar) {
          break;
        }
        localStringBuffer.append((char)c1);
      }
    }
    int j = localStringBuffer.length();
    if (j > 0)
    {
      char[] arrayOfChar = new char[j];
      localStringBuffer.getChars(0, j, arrayOfChar, 0);
      localStringBuffer.setLength(0);
      localVector.addElement(new LiteralFormat(arrayOfChar));
    }
    int i10;
    int k;
    int m;
    label307:
    int i1;
    label558:
    boolean bool;
    label605:
    Object localObject1;
    label622:
    char c2;
    label639:
    int i2;
    if (c1 < 0)
    {
      i10 = localVector.size();
      if (i10 == 1)
      {
        Object localObject3 = localVector.elementAt(0);
        if ((localObject3 instanceof ReportFormat)) {
          return (ReportFormat)localObject3;
        }
      }
    }
    else
    {
      if (c1 == '$')
      {
        int i8 = Character.digit((char)paramLineBufferedReader.read(), 10);
        if (i8 < 0) {
          throw new ParseException("missing number (position) after '%$'", -1);
        }
        int i9;
        do
        {
          i8 = i9 + i8 * 10;
          c1 = paramLineBufferedReader.read();
          i9 = Character.digit((char)c1, 10);
        } while (i9 >= 0);
        i = i8 - 1;
      }
      k = 0;
      int i7;
      switch ((char)c1)
      {
      default: 
        m = -1073741824;
        int n = Character.digit((char)c1, 10);
        if (n >= 0)
        {
          m = n;
          c1 = paramLineBufferedReader.read();
          i7 = Character.digit((char)c1, 10);
          if (i7 >= 0) {
            break;
          }
        }
        break;
      }
      for (;;)
      {
        i1 = -1073741824;
        if (c1 == '.')
        {
          if (c1 != '*') {
            break label558;
          }
          i1 = -1610612736;
        }
        switch (c1)
        {
        default: 
          throw new ParseException("unknown format character '" + c1 + "'", -1);
          k |= 0x1;
          for (;;)
          {
            c1 = paramLineBufferedReader.read();
            break;
            k |= 0x2;
            continue;
            k |= 0x4;
            continue;
            k |= 0x8;
            continue;
            k |= 0x10;
          }
          m = i7 + m * 10;
          break label307;
          if (c1 == '*') {
            m = -1610612736;
          }
          break;
        }
      }
      int i6;
      for (i1 = 0;; i1 = i6 + i1 * 10)
      {
        c1 = paramLineBufferedReader.read();
        i6 = Character.digit((char)c1, 10);
        if (i6 < 0) {
          break;
        }
      }
      if (c1 == 'S')
      {
        bool = true;
        ObjectFormat localObjectFormat2 = new ObjectFormat(bool, i1);
        localObject1 = localObjectFormat2;
        if (m <= 0) {
          break label945;
        }
        if ((k & 0x8) == 0) {
          break label895;
        }
        c2 = '0';
        if ((k & 0x1) == 0) {
          break label902;
        }
        i2 = 100;
      }
    }
    label650:
    label945:
    for (Object localObject2 = new PadFormat((Format)localObject1, m, c2, i2);; localObject2 = localObject1)
    {
      localVector.addElement(localObject2);
      i++;
      break;
      bool = false;
      break label605;
      int i3 = 0;
      int i4;
      if ((c1 == 'd') || (c1 == 'i'))
      {
        i4 = 10;
        label707:
        if ((k & 0x9) != 8) {
          break label851;
        }
      }
      label851:
      for (int i5 = 48;; i5 = 32)
      {
        if ((k & 0x10) != 0) {
          i3 |= 0x8;
        }
        if ((k & 0x2) != 0) {
          i3 |= 0x2;
        }
        if ((k & 0x1) != 0) {
          i3 |= 0x10;
        }
        if ((k & 0x4) != 0) {
          i3 |= 0x4;
        }
        if (i1 == -1073741824) {
          break label858;
        }
        k &= 0xFFFFFFF7;
        localObject1 = IntegerFormat.getInstance(i4, i1, 48, -1073741824, -1073741824, i3 | 0x40);
        break;
        if (c1 == 'o')
        {
          i4 = 8;
          i3 = 0;
          break label707;
        }
        i4 = 16;
        i3 = 0;
        if (c1 != 'X') {
          break label707;
        }
        i3 = 32;
        break label707;
      }
      label858:
      localObject1 = IntegerFormat.getInstance(i4, m, i5, -1073741824, -1073741824, i3);
      break label622;
      ObjectFormat localObjectFormat1 = new ObjectFormat(false);
      localObject1 = localObjectFormat1;
      break label622;
      label895:
      c2 = ' ';
      break label639;
      if (c2 == '0')
      {
        i2 = -1;
        break label650;
      }
      i2 = 0;
      break label650;
      Format[] arrayOfFormat = new Format[i10];
      localVector.copyInto(arrayOfFormat);
      return new CompoundFormat(arrayOfFormat);
    }
  }
  
  public Object apply1(Object paramObject)
  {
    if (this.emacsStyle) {}
    for (char c = '?';; c = '~') {
      return asFormat(paramObject, c);
    }
  }
  
  public ReportFormat parseFormat(LineBufferedReader paramLineBufferedReader)
    throws ParseException, IOException
  {
    if (this.emacsStyle) {}
    for (char c = '?';; c = '~') {
      return parseFormat(paramLineBufferedReader, c);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.ParseFormat
 * JD-Core Version:    0.7.0.1
 */