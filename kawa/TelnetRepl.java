package kawa;

import gnu.expr.Language;
import gnu.mapping.Environment;
import gnu.mapping.Future;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure0;
import gnu.mapping.TtyInPort;
import gnu.mapping.Values;
import gnu.text.FilePath;
import java.io.IOException;
import java.net.Socket;

public class TelnetRepl
  extends Procedure0
{
  Language language;
  Socket socket;
  
  public TelnetRepl(Language paramLanguage, Socket paramSocket)
  {
    this.language = paramLanguage;
    this.socket = paramSocket;
  }
  
  public static void serve(Language paramLanguage, Socket paramSocket)
    throws IOException
  {
    Telnet localTelnet = new Telnet(paramSocket, true);
    TelnetOutputStream localTelnetOutputStream = localTelnet.getOutputStream();
    TelnetInputStream localTelnetInputStream = localTelnet.getInputStream();
    OutPort localOutPort = new OutPort(localTelnetOutputStream, FilePath.valueOf("/dev/stdout"));
    TtyInPort localTtyInPort = new TtyInPort(localTelnetInputStream, FilePath.valueOf("/dev/stdin"), localOutPort);
    new Future(new TelnetRepl(paramLanguage, paramSocket), localTtyInPort, localOutPort, localOutPort).start();
  }
  
  public Object apply0()
  {
    try
    {
      Shell.run(this.language, Environment.getCurrent());
      Values localValues = Values.empty;
      label34:
      return localValues;
    }
    finally
    {
      try
      {
        this.socket.close();
        return localValues;
      }
      catch (IOException localIOException2) {}
      localObject = finally;
      try
      {
        this.socket.close();
        throw localObject;
      }
      catch (IOException localIOException1)
      {
        break label34;
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.TelnetRepl
 * JD-Core Version:    0.7.0.1
 */