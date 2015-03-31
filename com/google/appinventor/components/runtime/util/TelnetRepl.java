package com.google.appinventor.components.runtime.util;

import android.util.Log;
import gnu.expr.Language;
import gnu.mapping.Environment;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure0;
import gnu.mapping.TtyInPort;
import gnu.mapping.Values;
import gnu.text.FilePath;
import java.io.IOException;
import java.net.Socket;
import kawa.Shell;
import kawa.Telnet;
import kawa.TelnetInputStream;
import kawa.TelnetOutputStream;

public class TelnetRepl
  extends Procedure0
{
  private static final int REPL_STACK_SIZE = 262144;
  Language language;
  Socket socket;
  
  public TelnetRepl(Language paramLanguage, Socket paramSocket)
  {
    this.language = paramLanguage;
    this.socket = paramSocket;
  }
  
  public static Thread serve(Language paramLanguage, Socket paramSocket)
    throws IOException
  {
    Telnet localTelnet = new Telnet(paramSocket, true);
    TelnetOutputStream localTelnetOutputStream = localTelnet.getOutputStream();
    TelnetInputStream localTelnetInputStream = localTelnet.getInputStream();
    OutPort localOutPort = new OutPort(localTelnetOutputStream, FilePath.valueOf("/dev/stdout"));
    TtyInPort localTtyInPort = new TtyInPort(localTelnetInputStream, FilePath.valueOf("/dev/stdin"), localOutPort);
    BiggerFuture localBiggerFuture = new BiggerFuture(new TelnetRepl(paramLanguage, paramSocket), localTtyInPort, localOutPort, localOutPort, "Telnet Repl Thread", 262144L);
    localBiggerFuture.start();
    return localBiggerFuture;
  }
  
  public Object apply0()
  {
    Thread localThread = Thread.currentThread();
    if (localThread.getContextClassLoader() == null) {
      localThread.setContextClassLoader(Telnet.class.getClassLoader());
    }
    try
    {
      Shell.run(this.language, Environment.getCurrent());
      Values localValues = Values.empty;
      label93:
      return localValues;
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException = localRuntimeException;
      Log.d("TelnetRepl", "Repl is exiting with error " + localRuntimeException.getMessage());
      localRuntimeException.printStackTrace();
      throw localRuntimeException;
    }
    finally
    {
      try
      {
        this.socket.close();
        throw localObject;
      }
      catch (IOException localIOException1)
      {
        break label93;
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.TelnetRepl
 * JD-Core Version:    0.7.0.1
 */