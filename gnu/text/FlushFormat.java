package gnu.text;

import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

public class FlushFormat
  extends ReportFormat
{
  private static FlushFormat flush;
  
  public static FlushFormat getInstance()
  {
    if (flush == null) {
      flush = new FlushFormat();
    }
    return flush;
  }
  
  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    paramWriter.flush();
    return paramInt;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.text.FlushFormat
 * JD-Core Version:    0.7.0.1
 */