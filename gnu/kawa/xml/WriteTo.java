package gnu.kawa.xml;

import gnu.mapping.OutPort;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;
import gnu.text.Path;
import gnu.xml.XMLPrinter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class WriteTo
  extends Procedure2
{
  public static final WriteTo writeTo = new WriteTo();
  public static final WriteTo writeToIfChanged = new WriteTo();
  boolean ifChanged;
  
  static
  {
    writeToIfChanged.ifChanged = true;
  }
  
  public static void writeTo(Object paramObject, Path paramPath, OutputStream paramOutputStream)
    throws Throwable
  {
    OutPort localOutPort = new OutPort(paramOutputStream, paramPath);
    XMLPrinter localXMLPrinter = new XMLPrinter(localOutPort, false);
    if ("html".equals(paramPath.getExtension())) {
      localXMLPrinter.setStyle("html");
    }
    Values.writeValues(paramObject, localXMLPrinter);
    localOutPort.close();
  }
  
  public static void writeTo(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    Path localPath = Path.valueOf(paramObject2);
    writeTo(paramObject1, localPath, localPath.openOutputStream());
  }
  
  public static void writeToIfChanged(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    Path localPath = Path.valueOf(paramObject2);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    writeTo(paramObject1, localPath, localByteArrayOutputStream);
    byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
    for (;;)
    {
      try
      {
        localBufferedInputStream = new BufferedInputStream(localPath.openInputStream());
        i = 0;
        j = localBufferedInputStream.read();
        if (i != arrayOfByte.length) {
          continue;
        }
        k = 1;
      }
      catch (Throwable localThrowable)
      {
        BufferedInputStream localBufferedInputStream;
        int i;
        int j;
        int k;
        BufferedOutputStream localBufferedOutputStream;
        int m;
        int n;
        continue;
      }
      localBufferedInputStream.close();
      localBufferedOutputStream = new BufferedOutputStream(localPath.openOutputStream());
      localBufferedOutputStream.write(arrayOfByte);
      localBufferedOutputStream.close();
      return;
      k = 0;
      continue;
      localBufferedInputStream.close();
      return;
      if (k == 0)
      {
        m = i + 1;
        n = arrayOfByte[i];
        if (n == j) {
          i = m;
        }
      }
      else
      {
        continue;
        if (j < 0) {
          if (k != 0) {}
        }
      }
    }
  }
  
  public Object apply2(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    if (this.ifChanged) {
      writeToIfChanged(paramObject1, paramObject2.toString());
    }
    for (;;)
    {
      return Values.empty;
      writeTo(paramObject1, paramObject2.toString());
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.WriteTo
 * JD-Core Version:    0.7.0.1
 */