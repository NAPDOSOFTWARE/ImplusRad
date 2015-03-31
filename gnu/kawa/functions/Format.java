package gnu.kawa.functions;

import gnu.lists.FString;
import gnu.mapping.CharArrayOutPort;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Values;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.text.MessageFormat;

public class Format
  extends ProcedureN
{
  public static final Format format = new Format();
  
  static
  {
    format.setName("format");
    format.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyFormat");
  }
  
  static Object[] drop2(Object[] paramArrayOfObject)
  {
    int i = -2 + paramArrayOfObject.length;
    Object[] arrayOfObject = new Object[i];
    System.arraycopy(paramArrayOfObject, 2, arrayOfObject, 0, i);
    return arrayOfObject;
  }
  
  public static Object format(Object... paramVarArgs)
  {
    Object localObject = paramVarArgs[0];
    if (localObject == Boolean.TRUE)
    {
      format(OutPort.outDefault(), paramVarArgs, 1);
      return Values.empty;
    }
    if (localObject == Boolean.FALSE) {
      return formatToString(1, paramVarArgs);
    }
    if (((localObject instanceof MessageFormat)) || ((localObject instanceof CharSequence)) || ((localObject instanceof ReportFormat))) {
      return formatToString(0, paramVarArgs);
    }
    if ((localObject instanceof Writer))
    {
      format((Writer)localObject, paramVarArgs, 1);
      return Values.empty;
    }
    if ((localObject instanceof OutputStream))
    {
      formatToOutputStream((OutputStream)localObject, paramVarArgs[1], drop2(paramVarArgs));
      return Values.empty;
    }
    throw new RuntimeException("bad first argument to format");
  }
  
  public static void format(Writer paramWriter, Object[] paramArrayOfObject, int paramInt)
  {
    int i = paramInt + 1;
    Object localObject = paramArrayOfObject[paramInt];
    Object[] arrayOfObject = new Object[paramArrayOfObject.length - i];
    System.arraycopy(paramArrayOfObject, i, arrayOfObject, 0, arrayOfObject.length);
    formatToWriter(paramWriter, localObject, arrayOfObject);
  }
  
  public static FString formatToFString(char paramChar, Object paramObject, Object[] paramArrayOfObject)
  {
    ReportFormat localReportFormat = ParseFormat.asFormat(paramObject, paramChar);
    CharArrayOutPort localCharArrayOutPort = new CharArrayOutPort();
    try
    {
      localReportFormat.format(paramArrayOfObject, 0, localCharArrayOutPort, null);
      char[] arrayOfChar = localCharArrayOutPort.toCharArray();
      localCharArrayOutPort.close();
      return new FString(arrayOfChar);
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Error in format: " + localIOException);
    }
  }
  
  public static void formatToOutputStream(OutputStream paramOutputStream, Object paramObject, Object... paramVarArgs)
  {
    OutPort localOutPort = new OutPort(paramOutputStream);
    format(new Object[] { localOutPort, paramObject, paramVarArgs });
    localOutPort.closeThis();
  }
  
  public static String formatToString(int paramInt, Object... paramVarArgs)
  {
    CharArrayOutPort localCharArrayOutPort = new CharArrayOutPort();
    format(localCharArrayOutPort, paramVarArgs, paramInt);
    String str = localCharArrayOutPort.toString();
    localCharArrayOutPort.close();
    return str;
  }
  
  public static void formatToWriter(Writer paramWriter, Object paramObject, Object... paramVarArgs)
  {
    if (paramWriter == null) {
      paramWriter = OutPort.outDefault();
    }
    try
    {
      if ((paramObject instanceof MessageFormat))
      {
        paramWriter.write(((MessageFormat)paramObject).format(paramVarArgs));
        return;
      }
      if (!(paramObject instanceof ReportFormat)) {
        paramObject = ParseFormat.parseFormat.apply1(paramObject);
      }
      ((ReportFormat)paramObject).format(paramVarArgs, 0, paramWriter, null);
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Error in format: " + localIOException);
    }
  }
  
  public Object applyN(Object[] paramArrayOfObject)
  {
    return format(paramArrayOfObject);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.Format
 * JD-Core Version:    0.7.0.1
 */