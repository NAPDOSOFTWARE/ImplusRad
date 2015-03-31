package kawa;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Telnet
  implements Runnable
{
  public static final int DO = 253;
  public static final int DONT = 254;
  public static final int ECHO = 1;
  static final int EOF = 236;
  static final int IAC = 255;
  static final int IP = 244;
  static final int LINEMODE = 34;
  static final int NAWS = 31;
  static final int NOP = 241;
  static final int OPTION_NO = 0;
  static final int OPTION_WANTNO = 1;
  static final int OPTION_WANTNO_OPPOSITE = 2;
  static final int OPTION_WANTYES = 3;
  static final int OPTION_WANTYES_OPPOSITE = 4;
  static final int OPTION_YES = 5;
  static final int SB = 250;
  static final int SE = 240;
  public static final int SUPPRESS_GO_AHEAD = 3;
  static final int TM = 6;
  static final int TTYPE = 24;
  public static final int WILL = 251;
  public static final int WONT = 252;
  TelnetInputStream in;
  boolean isServer;
  final byte[] optionsState = new byte[256];
  TelnetOutputStream out;
  final byte preferredLineMode = 3;
  InputStream sin;
  OutputStream sout;
  public byte[] terminalType;
  public short windowHeight;
  public short windowWidth;
  
  public Telnet(Socket paramSocket, boolean paramBoolean)
    throws IOException
  {
    this.sin = paramSocket.getInputStream();
    this.sout = paramSocket.getOutputStream();
    this.out = new TelnetOutputStream(this.sout);
    this.in = new TelnetInputStream(this.sin, this);
    this.isServer = paramBoolean;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length == 0) {
      usage();
    }
    String str = paramArrayOfString[0];
    int i = 23;
    if (paramArrayOfString.length > 1) {
      i = Integer.parseInt(paramArrayOfString[1]);
    }
    try
    {
      Telnet localTelnet = new Telnet(new Socket(str, i), false);
      TelnetOutputStream localTelnetOutputStream = localTelnet.getOutputStream();
      Thread localThread = new Thread(localTelnet);
      localThread.setPriority(1 + Thread.currentThread().getPriority());
      localThread.start();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int j = System.in.read();
        if (j < 0)
        {
          localThread.stop();
          return;
        }
        arrayOfByte[0] = ((byte)j);
        int k = System.in.available();
        if (k > 0)
        {
          if (k > -1 + arrayOfByte.length) {
            k = -1 + arrayOfByte.length;
          }
          k = System.in.read(arrayOfByte, 1, k);
        }
        localTelnetOutputStream.write(arrayOfByte, 0, k + 1);
      }
      return;
    }
    catch (Exception localException)
    {
      System.err.println(localException);
    }
  }
  
  static void usage()
  {
    System.err.println("Usage:  [java] kawa.Telnet HOST [PORT#]");
    System.exit(-1);
  }
  
  boolean change(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 6) {}
    do
    {
      do
      {
        return true;
      } while ((this.isServer) && (paramInt2 == 31));
      if ((this.isServer) && (paramInt1 == 251) && (paramInt2 == 34))
      {
        byte[] arrayOfByte2 = { 1, 3 };
        try
        {
          this.out.writeSubCommand(34, arrayOfByte2);
          return true;
        }
        catch (IOException localIOException2)
        {
          return true;
        }
      }
      if ((this.isServer) && (paramInt1 == 251) && (paramInt2 == 24))
      {
        byte[] arrayOfByte1 = { 1 };
        try
        {
          this.out.writeSubCommand(paramInt2, arrayOfByte1);
          return true;
        }
        catch (IOException localIOException1)
        {
          return true;
        }
      }
      if ((this.isServer) || (paramInt2 != 1)) {
        break;
      }
      if (paramInt1 == 253) {
        return false;
      }
    } while (paramInt1 == 251);
    return false;
  }
  
  public TelnetInputStream getInputStream()
  {
    return this.in;
  }
  
  public TelnetOutputStream getOutputStream()
  {
    return this.out;
  }
  
  void handle(int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 1;
    int j = 254;
    int k = 253;
    int m;
    label27:
    int n;
    if (paramInt1 < k)
    {
      m = i;
      if ((paramInt1 & 0x1) == 0) {
        break label130;
      }
      n = this.optionsState[paramInt2];
      if (m != 0) {
        n = (byte)(n >> 3);
      }
      switch (0x7 & n >> 3)
      {
      default: 
        label92:
        if (m == 0) {
          break;
        }
      }
    }
    for (int i1 = (byte)(0xC7 & this.optionsState[paramInt2] | n << 3);; i1 = (byte)(n | 0xF8 & this.optionsState[paramInt2]))
    {
      this.optionsState[paramInt2] = i1;
      label130:
      do
      {
        do
        {
          return;
          m = 0;
          break;
          i = 0;
          break label27;
        } while (i != 0);
        change(paramInt1, paramInt2);
        TelnetOutputStream localTelnetOutputStream5 = this.out;
        if (m != 0) {}
        for (int i3 = j;; i3 = 252)
        {
          localTelnetOutputStream5.writeCommand(i3, paramInt2);
          n = 0;
          break;
        }
      } while (i == 0);
      if (change(paramInt1, paramInt2))
      {
        n = 5;
        TelnetOutputStream localTelnetOutputStream4 = this.out;
        if (m != 0) {}
        for (int i2 = k;; i2 = 251)
        {
          localTelnetOutputStream4.writeCommand(i2, paramInt2);
          break;
        }
      }
      TelnetOutputStream localTelnetOutputStream3 = this.out;
      if (m != 0) {}
      for (;;)
      {
        localTelnetOutputStream3.writeCommand(j, paramInt2);
        break;
        j = 252;
      }
      n = 0;
      break label92;
      n = 3;
      TelnetOutputStream localTelnetOutputStream2 = this.out;
      if (m != 0) {}
      for (;;)
      {
        localTelnetOutputStream2.writeCommand(k, paramInt2);
        break;
        k = 251;
      }
      if (i != 0)
      {
        n = 5;
        change(paramInt1, paramInt2);
        break label92;
      }
      n = 0;
      break label92;
      if (i != 0)
      {
        n = 1;
        TelnetOutputStream localTelnetOutputStream1 = this.out;
        if (m != 0) {}
        for (;;)
        {
          localTelnetOutputStream1.writeCommand(j, paramInt2);
          break;
          j = 252;
        }
      }
      n = 0;
      break label92;
    }
  }
  
  public void request(int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 1;
    int j;
    label18:
    int k;
    if (paramInt1 >= 253)
    {
      j = i;
      if ((paramInt1 & 0x1) == 0) {
        break label118;
      }
      k = this.optionsState[paramInt2];
      if (j != 0) {
        k = (byte)(k >> 3);
      }
      switch (k & 0x7)
      {
      default: 
        label80:
        if (j == 0) {
          break;
        }
      }
    }
    for (int m = (byte)(0xC7 & this.optionsState[paramInt2] | k << 3);; m = (byte)(k | 0xF8 & this.optionsState[paramInt2]))
    {
      this.optionsState[paramInt2] = m;
      return;
      j = 0;
      break;
      label118:
      i = 0;
      break label18;
      if (i == 0) {
        break label80;
      }
      k = 3;
      this.out.writeCommand(paramInt1, paramInt2);
      break label80;
      if (i != 0) {
        break label80;
      }
      k = 1;
      this.out.writeCommand(paramInt1, paramInt2);
      break label80;
      if (i == 0) {
        break label80;
      }
      k = 2;
      break label80;
      if (i != 0) {
        break label80;
      }
      k = 1;
      break label80;
      if (i == 0) {
        k = 4;
      }
      if (i == 0) {
        break label80;
      }
      k = 3;
      break label80;
    }
  }
  
  public void run()
  {
    try
    {
      TelnetInputStream localTelnetInputStream = getInputStream();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = localTelnetInputStream.read();
        if (i < 0) {
          return;
        }
        arrayOfByte[0] = ((byte)i);
        int j = localTelnetInputStream.available();
        if (j > 0)
        {
          if (j > -1 + arrayOfByte.length) {
            j = -1 + arrayOfByte.length;
          }
          j = localTelnetInputStream.read(arrayOfByte, 1, j);
        }
        System.out.write(arrayOfByte, 0, j + 1);
      }
      return;
    }
    catch (IOException localIOException)
    {
      System.err.println(localIOException);
      System.exit(-1);
    }
  }
  
  public void subCommand(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[paramInt1])
    {
    }
    for (;;)
    {
      return;
      if (paramInt2 == 5)
      {
        this.windowWidth = ((short)((paramArrayOfByte[1] << 8) + (0xFF & paramArrayOfByte[2])));
        this.windowHeight = ((short)((paramArrayOfByte[3] << 8) + (0xFF & paramArrayOfByte[4])));
        return;
        byte[] arrayOfByte = new byte[paramInt2 - 1];
        System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, paramInt2 - 1);
        this.terminalType = arrayOfByte;
        System.err.println("terminal type: '" + new String(arrayOfByte) + "'");
        return;
        System.err.println("SBCommand LINEMODE " + paramArrayOfByte[1] + " len:" + paramInt2);
        if (paramArrayOfByte[1] == 3) {
          for (int i = 2; i + 2 < paramInt2; i += 3) {
            System.err.println("  " + paramArrayOfByte[i] + "," + paramArrayOfByte[(i + 1)] + "," + paramArrayOfByte[(i + 2)]);
          }
        }
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.Telnet
 * JD-Core Version:    0.7.0.1
 */