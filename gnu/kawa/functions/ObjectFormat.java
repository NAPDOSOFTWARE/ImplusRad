package gnu.kawa.functions;

import gnu.mapping.OutPort;
import gnu.text.ReportFormat;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.ParsePosition;

public class ObjectFormat
  extends ReportFormat
{
  private static ObjectFormat plainFormat;
  private static ObjectFormat readableFormat;
  int maxChars;
  boolean readable;
  
  public ObjectFormat(boolean paramBoolean)
  {
    this.readable = paramBoolean;
    this.maxChars = -1073741824;
  }
  
  public ObjectFormat(boolean paramBoolean, int paramInt)
  {
    this.readable = paramBoolean;
    this.maxChars = paramInt;
  }
  
  public static int format(Object[] paramArrayOfObject, int paramInt1, Writer paramWriter, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    Object localObject;
    if (paramInt1 >= paramArrayOfObject.length)
    {
      localObject = "#<missing format argument>";
      paramInt1--;
      paramBoolean = false;
      paramInt2 = -1;
    }
    for (;;)
    {
      format(localObject, paramWriter, paramInt2, paramBoolean);
      return paramInt1 + 1;
      localObject = paramArrayOfObject[paramInt1];
    }
  }
  
  public static boolean format(Object paramObject, Writer paramWriter, int paramInt, boolean paramBoolean)
    throws IOException
  {
    if ((paramInt < 0) && ((paramWriter instanceof OutPort)))
    {
      print(paramObject, (OutPort)paramWriter, paramBoolean);
      return true;
    }
    if ((paramInt < 0) && ((paramWriter instanceof CharArrayWriter)))
    {
      OutPort localOutPort2 = new OutPort(paramWriter);
      print(paramObject, localOutPort2, paramBoolean);
      localOutPort2.close();
      return true;
    }
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    OutPort localOutPort1 = new OutPort(localCharArrayWriter);
    print(paramObject, localOutPort1, paramBoolean);
    localOutPort1.close();
    int i = localCharArrayWriter.size();
    if ((paramInt < 0) || (i <= paramInt))
    {
      localCharArrayWriter.writeTo(paramWriter);
      return true;
    }
    paramWriter.write(localCharArrayWriter.toCharArray(), 0, paramInt);
    return false;
  }
  
  public static ObjectFormat getInstance(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (readableFormat == null) {
        readableFormat = new ObjectFormat(true);
      }
      return readableFormat;
    }
    if (plainFormat == null) {
      plainFormat = new ObjectFormat(false);
    }
    return plainFormat;
  }
  
  /* Error */
  private static void print(Object paramObject, OutPort paramOutPort, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 74	gnu/mapping/OutPort:printReadable	Z
    //   4: istore_3
    //   5: aload_1
    //   6: getfield 78	gnu/mapping/OutPort:objectFormat	Lgnu/lists/AbstractFormat;
    //   9: astore 4
    //   11: aload_1
    //   12: iload_2
    //   13: putfield 74	gnu/mapping/OutPort:printReadable	Z
    //   16: iload_2
    //   17: ifeq +33 -> 50
    //   20: getstatic 83	kawa/standard/Scheme:writeFormat	Lgnu/lists/AbstractFormat;
    //   23: astore 6
    //   25: aload_1
    //   26: aload 6
    //   28: putfield 78	gnu/mapping/OutPort:objectFormat	Lgnu/lists/AbstractFormat;
    //   31: aload 6
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 89	gnu/lists/AbstractFormat:writeObject	(Ljava/lang/Object;Lgnu/lists/Consumer;)V
    //   38: aload_1
    //   39: iload_3
    //   40: putfield 74	gnu/mapping/OutPort:printReadable	Z
    //   43: aload_1
    //   44: aload 4
    //   46: putfield 78	gnu/mapping/OutPort:objectFormat	Lgnu/lists/AbstractFormat;
    //   49: return
    //   50: getstatic 92	kawa/standard/Scheme:displayFormat	Lgnu/lists/AbstractFormat;
    //   53: astore 6
    //   55: goto -30 -> 25
    //   58: astore 5
    //   60: aload_1
    //   61: iload_3
    //   62: putfield 74	gnu/mapping/OutPort:printReadable	Z
    //   65: aload_1
    //   66: aload 4
    //   68: putfield 78	gnu/mapping/OutPort:objectFormat	Lgnu/lists/AbstractFormat;
    //   71: aload 5
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramObject	Object
    //   0	74	1	paramOutPort	OutPort
    //   0	74	2	paramBoolean	boolean
    //   4	58	3	bool	boolean
    //   9	58	4	localAbstractFormat1	gnu.lists.AbstractFormat
    //   58	14	5	localObject	Object
    //   23	31	6	localAbstractFormat2	gnu.lists.AbstractFormat
    // Exception table:
    //   from	to	target	type
    //   11	16	58	finally
    //   20	25	58	finally
    //   25	38	58	finally
    //   50	55	58	finally
  }
  
  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    int i = getParam(this.maxChars, -1, paramArrayOfObject, paramInt);
    if (this.maxChars == -1610612736) {
      paramInt++;
    }
    return format(paramArrayOfObject, paramInt, paramWriter, i, this.readable);
  }
  
  public Object parseObject(String paramString, ParsePosition paramParsePosition)
  {
    throw new RuntimeException("ObjectFormat.parseObject - not implemented");
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.ObjectFormat
 * JD-Core Version:    0.7.0.1
 */