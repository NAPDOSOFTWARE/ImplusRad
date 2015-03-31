package com.google.appinventor.components.runtime.util;

import android.util.Log;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.Vector;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NanoHTTPD
{
  public static final String HTTP_BADREQUEST = "400 Bad Request";
  public static final String HTTP_FORBIDDEN = "403 Forbidden";
  public static final String HTTP_INTERNALERROR = "500 Internal Server Error";
  public static final String HTTP_NOTFOUND = "404 Not Found";
  public static final String HTTP_NOTIMPLEMENTED = "501 Not Implemented";
  public static final String HTTP_NOTMODIFIED = "304 Not Modified";
  public static final String HTTP_OK = "200 OK";
  public static final String HTTP_PARTIALCONTENT = "206 Partial Content";
  public static final String HTTP_RANGE_NOT_SATISFIABLE = "416 Requested Range Not Satisfiable";
  public static final String HTTP_REDIRECT = "301 Moved Permanently";
  private static final String LICENCE = "Copyright (C) 2001,2005-2011 by Jarno Elonen <elonen@iki.fi>\nand Copyright (C) 2010 by Konstantinos Togias <info@ktogias.gr>\n\nRedistribution and use in source and binary forms, with or without\nmodification, are permitted provided that the following conditions\nare met:\n\nRedistributions of source code must retain the above copyright notice,\nthis list of conditions and the following disclaimer. Redistributions in\nbinary form must reproduce the above copyright notice, this list of\nconditions and the following disclaimer in the documentation and/or other\nmaterials provided with the distribution. The name of the author may not\nbe used to endorse or promote products derived from this software without\nspecific prior written permission. \n \nTHIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR\nIMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES\nOF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.\nIN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,\nINCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT\nNOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,\nDATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY\nTHEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT\n(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE\nOF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.";
  private static final String LOG_TAG = "AppInvHTTPD";
  public static final String MIME_DEFAULT_BINARY = "application/octet-stream";
  public static final String MIME_HTML = "text/html";
  public static final String MIME_PLAINTEXT = "text/plain";
  public static final String MIME_XML = "text/xml";
  private static final int REPL_STACK_SIZE = 262144;
  private static SimpleDateFormat gmtFrmt;
  protected static PrintStream myErr;
  protected static PrintStream myOut;
  private static int theBufferSize;
  private static Hashtable theMimeTypes = new Hashtable();
  private ThreadPoolExecutor myExecutor = new ThreadPoolExecutor(2, 10, 5L, TimeUnit.SECONDS, new SynchronousQueue(), new myThreadFactory(null));
  private File myRootDir;
  private final ServerSocket myServerSocket;
  private int myTcpPort;
  private Thread myThread;
  
  static
  {
    StringTokenizer localStringTokenizer = new StringTokenizer("css            text/css htm            text/html html           text/html xml            text/xml txt            text/plain asc            text/plain gif            image/gif jpg            image/jpeg jpeg           image/jpeg png            image/png mp3            audio/mpeg m3u            audio/mpeg-url mp4            video/mp4 ogv            video/ogg flv            video/x-flv mov            video/quicktime swf            application/x-shockwave-flash js                     application/javascript pdf            application/pdf doc            application/msword ogg            application/x-ogg zip            application/octet-stream exe            application/octet-stream class          application/octet-stream ");
    while (localStringTokenizer.hasMoreTokens()) {
      theMimeTypes.put(localStringTokenizer.nextToken(), localStringTokenizer.nextToken());
    }
    theBufferSize = 16384;
    myOut = System.out;
    myErr = System.err;
    gmtFrmt = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
    gmtFrmt.setTimeZone(TimeZone.getTimeZone("GMT"));
  }
  
  public NanoHTTPD(int paramInt, File paramFile)
    throws IOException
  {
    this.myTcpPort = paramInt;
    this.myRootDir = paramFile;
    this.myServerSocket = new ServerSocket(this.myTcpPort);
    this.myThread = new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          for (;;)
          {
            new NanoHTTPD.HTTPSession(NanoHTTPD.this, NanoHTTPD.this.myServerSocket.accept());
          }
          return;
        }
        catch (IOException localIOException) {}
      }
    });
    this.myThread.setDaemon(true);
    this.myThread.start();
  }
  
  private String encodeUri(String paramString)
  {
    String str1 = "";
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "/ ", true);
    while (localStringTokenizer.hasMoreTokens())
    {
      String str2 = localStringTokenizer.nextToken();
      if (str2.equals("/")) {
        str1 = str1 + "/";
      } else if (str2.equals(" ")) {
        str1 = str1 + "%20";
      } else {
        str1 = str1 + URLEncoder.encode(str2);
      }
    }
    return str1;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    myOut.println("NanoHTTPD 1.25 (C) 2001,2005-2011 Jarno Elonen and (C) 2010 Konstantinos Togias\n(Command line options: [-p port] [-d root-dir] [--licence])\n");
    int i = 80;
    File localFile = new File(".").getAbsoluteFile();
    int j = 0;
    if (j < paramArrayOfString.length)
    {
      if (paramArrayOfString[j].equalsIgnoreCase("-p")) {
        i = Integer.parseInt(paramArrayOfString[(j + 1)]);
      }
      label91:
      do
      {
        for (;;)
        {
          j++;
          break;
          if (!paramArrayOfString[j].equalsIgnoreCase("-d")) {
            break label91;
          }
          localFile = new File(paramArrayOfString[(j + 1)]).getAbsoluteFile();
        }
      } while (!paramArrayOfString[j].toLowerCase().endsWith("licence"));
      myOut.println("Copyright (C) 2001,2005-2011 by Jarno Elonen <elonen@iki.fi>\nand Copyright (C) 2010 by Konstantinos Togias <info@ktogias.gr>\n\nRedistribution and use in source and binary forms, with or without\nmodification, are permitted provided that the following conditions\nare met:\n\nRedistributions of source code must retain the above copyright notice,\nthis list of conditions and the following disclaimer. Redistributions in\nbinary form must reproduce the above copyright notice, this list of\nconditions and the following disclaimer in the documentation and/or other\nmaterials provided with the distribution. The name of the author may not\nbe used to endorse or promote products derived from this software without\nspecific prior written permission. \n \nTHIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR\nIMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES\nOF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.\nIN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,\nINCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT\nNOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,\nDATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY\nTHEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT\n(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE\nOF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.\n");
    }
    try
    {
      new NanoHTTPD(i, localFile);
      myOut.println("Now serving files in port " + i + " from \"" + localFile + "\"");
      myOut.println("Hit Enter to stop.\n");
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          System.in.read();
          return;
        }
        catch (Throwable localThrowable) {}
        localIOException = localIOException;
        myErr.println("Couldn't start server:\n" + localIOException);
        System.exit(-1);
      }
    }
  }
  
  public Response serve(String paramString1, String paramString2, Properties paramProperties1, Properties paramProperties2, Properties paramProperties3, Socket paramSocket)
  {
    myOut.println(paramString2 + " '" + paramString1 + "' ");
    Enumeration localEnumeration1 = paramProperties1.propertyNames();
    while (localEnumeration1.hasMoreElements())
    {
      String str3 = (String)localEnumeration1.nextElement();
      myOut.println("  HDR: '" + str3 + "' = '" + paramProperties1.getProperty(str3) + "'");
    }
    Enumeration localEnumeration2 = paramProperties2.propertyNames();
    while (localEnumeration2.hasMoreElements())
    {
      String str2 = (String)localEnumeration2.nextElement();
      myOut.println("  PRM: '" + str2 + "' = '" + paramProperties2.getProperty(str2) + "'");
    }
    Enumeration localEnumeration3 = paramProperties3.propertyNames();
    while (localEnumeration3.hasMoreElements())
    {
      String str1 = (String)localEnumeration3.nextElement();
      myOut.println("  UPLOADED: '" + str1 + "' = '" + paramProperties3.getProperty(str1) + "'");
    }
    return serveFile(paramString1, paramProperties1, this.myRootDir, true);
  }
  
  public Response serveFile(String paramString, Properties paramProperties, File paramFile, boolean paramBoolean)
  {
    boolean bool1 = paramFile.isDirectory();
    Response localResponse1 = null;
    if (!bool1) {
      localResponse1 = new Response("500 Internal Server Error", "text/plain", "INTERNAL ERRROR: serveFile(): given homeDir is not a directory.");
    }
    if (localResponse1 == null)
    {
      paramString = paramString.trim().replace(File.separatorChar, '/');
      if (paramString.indexOf('?') >= 0)
      {
        int i5 = paramString.indexOf('?');
        paramString = paramString.substring(0, i5);
      }
      if ((paramString.startsWith("..")) || (paramString.endsWith("..")) || (paramString.indexOf("../") >= 0)) {
        localResponse1 = new Response("403 Forbidden", "text/plain", "FORBIDDEN: Won't serve ../ for security reasons.");
      }
    }
    File localFile1 = new File(paramFile, paramString);
    if ((localResponse1 == null) && (!localFile1.exists())) {
      localResponse1 = new Response("404 Not Found", "text/plain", "Error 404, file not found.");
    }
    Object localObject1;
    if ((localResponse1 == null) && (localFile1.isDirectory()))
    {
      if (!paramString.endsWith("/"))
      {
        paramString = paramString + "/";
        String str14 = "<html><body>Redirected: <a href=\"" + paramString + "\">" + paramString + "</a></body></html>";
        localResponse1 = new Response("301 Moved Permanently", "text/html", str14);
        localResponse1.addHeader("Location", paramString);
      }
      if (localResponse1 == null)
      {
        File localFile2 = new File(localFile1, "index.html");
        if (localFile2.exists())
        {
          localFile1 = new File(paramFile, paramString + "/index.html");
          localObject1 = localResponse1;
          if (localObject1 != null) {
            break label1668;
          }
        }
      }
    }
    for (;;)
    {
      String str1;
      Object localObject2;
      try
      {
        int i = localFile1.getCanonicalPath().lastIndexOf('.');
        str1 = null;
        if (i < 0) {
          break label1682;
        }
        str1 = (String)theMimeTypes.get(localFile1.getCanonicalPath().substring(i + 1).toLowerCase());
      }
      catch (IOException localIOException1)
      {
        String str2;
        long l1;
        long l2;
        String str3;
        int j;
        int k;
        continue;
      }
      str2 = Integer.toHexString((localFile1.getAbsolutePath() + localFile1.lastModified() + "" + localFile1.length()).hashCode());
      l1 = 0L;
      l2 = -1L;
      str3 = paramProperties.getProperty("range");
      if ((str3 != null) && (str3.startsWith("bytes=")))
      {
        j = "bytes=".length();
        str3 = str3.substring(j);
        k = str3.indexOf('-');
        if (k <= 0) {}
      }
      try
      {
        l1 = Long.parseLong(str3.substring(0, k));
        int m = k + 1;
        long l6 = Long.parseLong(str3.substring(m));
        l2 = l6;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        long l3;
        File localFile3;
        String[] arrayOfString;
        String str8;
        int i2;
        String str13;
        int i3;
        StringBuilder localStringBuilder;
        int i4;
        int n;
        int i1;
        File localFile4;
        boolean bool2;
        String str10;
        long l7;
        String str11;
        String str12;
        String str9;
        Response localResponse3;
        Response localResponse2;
        long l4;
        final long l5;
        FileInputStream local2;
        String str6;
        String str7;
        FileInputStream localFileInputStream;
        String str4;
        continue;
      }
      l3 = localFile1.length();
      if ((str3 != null) && (l1 >= 0L))
      {
        if (l1 >= l3) {
          localObject2 = new Response("416 Requested Range Not Satisfiable", "text/plain", "");
        }
        try
        {
          String str5 = "bytes 0-0/" + l3;
          ((Response)localObject2).addHeader("Content-Range", str5);
          ((Response)localObject2).addHeader("ETag", str2);
          ((Response)localObject2).addHeader("Accept-Ranges", "bytes");
          return localObject2;
        }
        catch (IOException localIOException2) {}
        localFile3 = new File(localFile1, "index.htm");
        if (localFile3.exists())
        {
          localFile1 = new File(paramFile, paramString + "/index.htm");
          localObject1 = localResponse1;
          break;
        }
        if ((paramBoolean) && (localFile1.canRead()))
        {
          arrayOfString = localFile1.list();
          str8 = "<html><body><h1>Directory " + paramString + "</h1><br/>";
          if (paramString.length() > 1)
          {
            i2 = -1 + paramString.length();
            str13 = paramString.substring(0, i2);
            i3 = str13.lastIndexOf('/');
            if ((i3 >= 0) && (i3 < str13.length()))
            {
              localStringBuilder = new StringBuilder().append(str8).append("<b><a href=\"");
              i4 = i3 + 1;
              str8 = paramString.substring(0, i4) + "\">..</a></b><br/>";
            }
          }
          if (arrayOfString != null)
          {
            n = 0;
            i1 = arrayOfString.length;
            if (n < i1)
            {
              localFile4 = new File(localFile1, arrayOfString[n]);
              bool2 = localFile4.isDirectory();
              if (bool2)
              {
                str8 = str8 + "<b>";
                arrayOfString[n] = (arrayOfString[n] + "/");
              }
              str10 = str8 + "<a href=\"" + encodeUri(new StringBuilder().append(paramString).append(arrayOfString[n]).toString()) + "\">" + arrayOfString[n] + "</a>";
              if (localFile4.isFile())
              {
                l7 = localFile4.length();
                str11 = str10 + " &nbsp;<font size=2>(";
                if (l7 < 1024L)
                {
                  str12 = str11 + l7 + " bytes";
                  str10 = str12 + ")</font>";
                }
              }
              else
              {
                str8 = str10 + "<br/>";
                if (bool2) {
                  str8 = str8 + "</b>";
                }
                n++;
                continue;
              }
              if (l7 < 1048576L)
              {
                str12 = str11 + l7 / 1024L + "." + l7 % 1024L / 10L % 100L + " KB";
                continue;
              }
              str12 = str11 + l7 / 1048576L + "." + l7 % 1048576L / 10L % 100L + " MB";
              continue;
            }
          }
          str9 = str8 + "</body></html>";
          localResponse3 = new Response("200 OK", "text/html", str9);
          localObject1 = localResponse3;
          break;
        }
        localResponse2 = new Response("403 Forbidden", "text/plain", "FORBIDDEN: No directory listing.");
        localObject1 = localResponse2;
        break;
        if (l2 < 0L) {
          l2 = l3 - 1L;
        }
        l4 = 1L + (l2 - l1);
        if (l4 < 0L) {
          l4 = 0L;
        }
        l5 = l4;
        local2 = new FileInputStream(localFile1)
        {
          public int available()
            throws IOException
          {
            return (int)l5;
          }
        };
        local2.skip(l1);
        localObject2 = new Response("206 Partial Content", str1, local2);
        str6 = "" + l5;
        ((Response)localObject2).addHeader("Content-Length", str6);
        str7 = "bytes " + l1 + "-" + l2 + "/" + l3;
        ((Response)localObject2).addHeader("Content-Range", str7);
        ((Response)localObject2).addHeader("ETag", str2);
        continue;
        localObject2 = new Response("403 Forbidden", "text/plain", "FORBIDDEN: Reading file failed.");
        continue;
      }
      if (str2.equals(paramProperties.getProperty("if-none-match")))
      {
        localObject2 = new Response("304 Not Modified", str1, "");
      }
      else
      {
        localFileInputStream = new FileInputStream(localFile1);
        localObject2 = new Response("200 OK", str1, localFileInputStream);
        str4 = "" + l3;
        ((Response)localObject2).addHeader("Content-Length", str4);
        ((Response)localObject2).addHeader("ETag", str2);
        continue;
        label1668:
        localObject2 = localObject1;
        continue;
        localObject1 = localResponse1;
        break;
        label1682:
        if (str1 == null) {
          str1 = "application/octet-stream";
        }
      }
    }
  }
  
  public void stop()
  {
    try
    {
      this.myServerSocket.close();
      this.myThread.join();
      return;
    }
    catch (InterruptedException localInterruptedException) {}catch (IOException localIOException) {}
  }
  
  private class HTTPSession
    implements Runnable
  {
    private Socket mySocket;
    
    public HTTPSession(Socket paramSocket)
    {
      this.mySocket = paramSocket;
      Log.d("AppInvHTTPD", "NanoHTTPD: getPoolSize() = " + NanoHTTPD.this.myExecutor.getPoolSize());
      NanoHTTPD.this.myExecutor.execute(this);
    }
    
    private void decodeHeader(BufferedReader paramBufferedReader, Properties paramProperties1, Properties paramProperties2, Properties paramProperties3)
      throws InterruptedException
    {
      try
      {
        String str1 = paramBufferedReader.readLine();
        if (str1 == null) {
          return;
        }
        StringTokenizer localStringTokenizer = new StringTokenizer(str1);
        if (!localStringTokenizer.hasMoreTokens()) {
          sendError("400 Bad Request", "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
        }
        paramProperties1.put("method", localStringTokenizer.nextToken());
        if (!localStringTokenizer.hasMoreTokens()) {
          sendError("400 Bad Request", "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
        }
        String str2 = localStringTokenizer.nextToken();
        int i = str2.indexOf('?');
        if (i >= 0) {
          decodeParms(str2.substring(i + 1), paramProperties2);
        }
        for (String str3 = decodePercent(str2.substring(0, i)); localStringTokenizer.hasMoreTokens(); str3 = decodePercent(str2)) {
          for (String str4 = paramBufferedReader.readLine(); (str4 != null) && (str4.trim().length() > 0); str4 = paramBufferedReader.readLine())
          {
            int j = str4.indexOf(':');
            if (j >= 0) {
              paramProperties3.put(str4.substring(0, j).trim().toLowerCase(), str4.substring(j + 1).trim());
            }
          }
        }
        paramProperties1.put("uri", str3);
        return;
      }
      catch (IOException localIOException)
      {
        sendError("500 Internal Server Error", "SERVER INTERNAL ERROR: IOException: " + localIOException.getMessage());
      }
    }
    
    private void decodeMultipartData(String paramString, byte[] paramArrayOfByte, BufferedReader paramBufferedReader, Properties paramProperties1, Properties paramProperties2)
      throws InterruptedException
    {
      for (;;)
      {
        int[] arrayOfInt;
        int i;
        String str1;
        Properties localProperties1;
        Properties localProperties2;
        try
        {
          arrayOfInt = getBoundaryPositions(paramArrayOfByte, paramString.getBytes());
          i = 1;
          str1 = paramBufferedReader.readLine();
          if (str1 != null)
          {
            if (str1.indexOf(paramString) == -1) {
              sendError("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but next chunk does not start with boundary. Usage: GET /example/file.html");
            }
            i++;
            localProperties1 = new Properties();
            str1 = paramBufferedReader.readLine();
            if ((str1 != null) && (str1.trim().length() > 0))
            {
              int n = str1.indexOf(':');
              if (n != -1) {
                localProperties1.put(str1.substring(0, n).trim().toLowerCase(), str1.substring(n + 1).trim());
              }
              str1 = paramBufferedReader.readLine();
              continue;
            }
            if (str1 == null) {
              continue;
            }
            String str2 = localProperties1.getProperty("content-disposition");
            if (str2 == null) {
              sendError("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but no content-disposition info found. Usage: GET /example/file.html");
            }
            StringTokenizer localStringTokenizer = new StringTokenizer(str2, "; ");
            localProperties2 = new Properties();
            if (localStringTokenizer.hasMoreTokens())
            {
              String str7 = localStringTokenizer.nextToken();
              int m = str7.indexOf('=');
              if (m == -1) {
                continue;
              }
              localProperties2.put(str7.substring(0, m).trim().toLowerCase(), str7.substring(m + 1).trim());
              continue;
            }
          }
          else
          {
            return;
          }
        }
        catch (IOException localIOException)
        {
          sendError("500 Internal Server Error", "SERVER INTERNAL ERROR: IOException: " + localIOException.getMessage());
        }
        String str3 = localProperties2.getProperty("name");
        String str4 = str3.substring(1, -1 + str3.length());
        String str5 = "";
        if (localProperties1.getProperty("content-type") == null) {
          while ((str1 != null) && (str1.indexOf(paramString) == -1))
          {
            str1 = paramBufferedReader.readLine();
            if (str1 != null)
            {
              int j = str1.indexOf(paramString);
              if (j == -1) {
                str5 = str5 + str1;
              } else {
                str5 = str5 + str1.substring(0, j - 2);
              }
            }
          }
        }
        if (i > arrayOfInt.length) {
          sendError("500 Internal Server Error", "Error processing request");
        }
        int k = stripMultipartHeaders(paramArrayOfByte, arrayOfInt[(i - 2)]);
        paramProperties2.put(str4, saveTmpFile(paramArrayOfByte, k, -4 + (arrayOfInt[(i - 1)] - k)));
        String str6 = localProperties2.getProperty("filename");
        str5 = str6.substring(1, -1 + str6.length());
        do
        {
          str1 = paramBufferedReader.readLine();
        } while ((str1 != null) && (str1.indexOf(paramString) == -1));
        paramProperties1.put(str4, str5);
      }
    }
    
    private void decodeParms(String paramString, Properties paramProperties)
      throws InterruptedException
    {
      if (paramString == null) {}
      for (;;)
      {
        return;
        StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "&");
        while (localStringTokenizer.hasMoreTokens())
        {
          String str = localStringTokenizer.nextToken();
          int i = str.indexOf('=');
          if (i >= 0) {
            paramProperties.put(decodePercent(str.substring(0, i)).trim(), decodePercent(str.substring(i + 1)));
          }
        }
      }
    }
    
    private String decodePercent(String paramString)
      throws InterruptedException
    {
      for (;;)
      {
        StringBuffer localStringBuffer;
        int i;
        try
        {
          localStringBuffer = new StringBuffer();
          i = 0;
          if (i >= paramString.length()) {
            break label119;
          }
          char c = paramString.charAt(i);
          switch (c)
          {
          default: 
            localStringBuffer.append(c);
          }
        }
        catch (Exception localException)
        {
          sendError("400 Bad Request", "BAD REQUEST: Bad percent-encoding.");
          return null;
        }
        localStringBuffer.append(' ');
        break label128;
        int j = i + 1;
        int k = i + 3;
        localStringBuffer.append((char)Integer.parseInt(paramString.substring(j, k), 16));
        i += 2;
        break label128;
        label119:
        String str = localStringBuffer.toString();
        return str;
        label128:
        i++;
      }
    }
    
    private String saveTmpFile(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      Object localObject = "";
      String str1;
      if (paramInt2 > 0) {
        str1 = System.getProperty("java.io.tmpdir");
      }
      try
      {
        File localFile = File.createTempFile("NanoHTTPD", "", new File(str1));
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        localFileOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
        localFileOutputStream.close();
        String str2 = localFile.getAbsolutePath();
        localObject = str2;
        return localObject;
      }
      catch (Exception localException)
      {
        NanoHTTPD.myErr.println("Error: " + localException.getMessage());
      }
      return localObject;
    }
    
    private void sendError(String paramString1, String paramString2)
      throws InterruptedException
    {
      sendResponse(paramString1, "text/plain", null, new ByteArrayInputStream(paramString2.getBytes()));
      throw new InterruptedException();
    }
    
    private void sendResponse(String paramString1, String paramString2, Properties paramProperties, InputStream paramInputStream)
    {
      if (paramString1 == null) {
        try
        {
          throw new Error("sendResponse(): Status can't be null.");
        }
        catch (IOException localIOException) {}
      }
      try
      {
        this.mySocket.close();
        return;
      }
      catch (Throwable localThrowable)
      {
        OutputStream localOutputStream;
        PrintWriter localPrintWriter;
        Enumeration localEnumeration;
        byte[] arrayOfByte;
        return;
      }
      localOutputStream = this.mySocket.getOutputStream();
      localPrintWriter = new PrintWriter(localOutputStream);
      localPrintWriter.print("HTTP/1.0 " + paramString1 + " \r\n");
      if (paramString2 != null) {
        localPrintWriter.print("Content-Type: " + paramString2 + "\r\n");
      }
      if ((paramProperties == null) || (paramProperties.getProperty("Date") == null)) {
        localPrintWriter.print("Date: " + NanoHTTPD.gmtFrmt.format(new Date()) + "\r\n");
      }
      if (paramProperties != null)
      {
        localEnumeration = paramProperties.keys();
        while (localEnumeration.hasMoreElements())
        {
          String str1 = (String)localEnumeration.nextElement();
          String str2 = paramProperties.getProperty(str1);
          localPrintWriter.print(str1 + ": " + str2 + "\r\n");
        }
      }
      localPrintWriter.print("\r\n");
      localPrintWriter.flush();
      int i;
      if (paramInputStream != null)
      {
        i = paramInputStream.available();
        arrayOfByte = new byte[NanoHTTPD.theBufferSize];
        label280:
        if (i > 0) {
          if (i <= NanoHTTPD.theBufferSize) {
            break label359;
          }
        }
      }
      label359:
      for (int j = NanoHTTPD.theBufferSize;; j = i)
      {
        int k = paramInputStream.read(arrayOfByte, 0, j);
        if (k <= 0)
        {
          localOutputStream.flush();
          localOutputStream.close();
          if (paramInputStream == null) {
            break;
          }
          paramInputStream.close();
          return;
        }
        localOutputStream.write(arrayOfByte, 0, k);
        i -= k;
        break label280;
      }
    }
    
    private int stripMultipartHeaders(byte[] paramArrayOfByte, int paramInt)
    {
      for (int i = paramInt;; i++) {
        if (i < paramArrayOfByte.length)
        {
          if (paramArrayOfByte[i] == 13)
          {
            i++;
            if (paramArrayOfByte[i] == 10)
            {
              i++;
              if (paramArrayOfByte[i] == 13)
              {
                i++;
                if (paramArrayOfByte[i] != 10) {}
              }
            }
          }
        }
        else {
          return i + 1;
        }
      }
    }
    
    public int[] getBoundaryPositions(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      int i = 0;
      int j = -1;
      Vector localVector = new Vector();
      int k = 0;
      if (k < paramArrayOfByte1.length)
      {
        if (paramArrayOfByte1[k] == paramArrayOfByte2[i])
        {
          if (i == 0) {
            j = k;
          }
          i++;
          if (i == paramArrayOfByte2.length)
          {
            localVector.addElement(new Integer(j));
            i = 0;
            j = -1;
          }
        }
        for (;;)
        {
          k++;
          break;
          k -= i;
          j = -1;
          i = 0;
        }
      }
      int[] arrayOfInt = new int[localVector.size()];
      for (int m = 0; m < arrayOfInt.length; m++) {
        arrayOfInt[m] = ((Integer)localVector.elementAt(m)).intValue();
      }
      return arrayOfInt;
    }
    
    public void run()
    {
      for (;;)
      {
        try
        {
          localInputStream = this.mySocket.getInputStream();
          if (localInputStream == null) {
            return;
          }
          arrayOfByte1 = new byte[8192];
          i = localInputStream.read(arrayOfByte1, 0, 8192);
          if (i <= 0) {
            continue;
          }
          ByteArrayInputStream localByteArrayInputStream1 = new ByteArrayInputStream(arrayOfByte1, 0, i);
          BufferedReader localBufferedReader1 = new BufferedReader(new InputStreamReader(localByteArrayInputStream1));
          Properties localProperties1 = new Properties();
          localProperties2 = new Properties();
          localProperties3 = new Properties();
          localProperties4 = new Properties();
          decodeHeader(localBufferedReader1, localProperties1, localProperties2, localProperties3);
          str1 = localProperties1.getProperty("method");
          str2 = localProperties1.getProperty("uri");
          l = 9223372036854775807L;
          str3 = localProperties3.getProperty("content-length");
          if (str3 == null) {}
        }
        catch (IOException localIOException)
        {
          InputStream localInputStream;
          int i;
          Properties localProperties2;
          Properties localProperties3;
          Properties localProperties4;
          String str1;
          String str2;
          int j;
          int n;
          int i1;
          ByteArrayOutputStream localByteArrayOutputStream;
          try
          {
            byte[] arrayOfByte1;
            String str3;
            int i3;
            int k;
            int m;
            byte[] arrayOfByte2;
            sendError("500 Internal Server Error", "SERVER INTERNAL ERROR: IOException: " + localIOException.getMessage());
            return;
          }
          catch (Throwable localThrowable)
          {
            return;
          }
          j++;
          continue;
          if ((n != 0) && (l != 9223372036854775807L)) {
            continue;
          }
          long l = 0L;
          continue;
          byte[] arrayOfByte3 = localByteArrayOutputStream.toByteArray();
          ByteArrayInputStream localByteArrayInputStream2 = new ByteArrayInputStream(arrayOfByte3);
          BufferedReader localBufferedReader2 = new BufferedReader(new InputStreamReader(localByteArrayInputStream2));
          NanoHTTPD.Response localResponse;
          if (str1.equalsIgnoreCase("POST"))
          {
            String str4 = "";
            String str5 = localProperties3.getProperty("content-type");
            StringTokenizer localStringTokenizer1 = new StringTokenizer(str5, "; ");
            if (localStringTokenizer1.hasMoreTokens()) {
              str4 = localStringTokenizer1.nextToken();
            }
            if (str4.equalsIgnoreCase("multipart/form-data"))
            {
              if (!localStringTokenizer1.hasMoreTokens()) {
                sendError("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
              }
              String str7 = localStringTokenizer1.nextToken();
              StringTokenizer localStringTokenizer2 = new StringTokenizer(str7, "=");
              if (localStringTokenizer2.countTokens() != 2) {
                sendError("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but boundary syntax error. Usage: GET /example/file.html");
              }
              localStringTokenizer2.nextToken();
              decodeMultipartData(localStringTokenizer2.nextToken(), arrayOfByte3, localBufferedReader2, localProperties2, localProperties4);
            }
          }
          else
          {
            if (str1.equalsIgnoreCase("PUT")) {
              localProperties4.put("content", saveTmpFile(arrayOfByte3, 0, localByteArrayOutputStream.size()));
            }
            localResponse = NanoHTTPD.this.serve(str2, str1, localProperties3, localProperties2, localProperties4, this.mySocket);
            if (localResponse != null) {
              continue;
            }
            sendError("500 Internal Server Error", "SERVER INTERNAL ERROR: Serve() returned a null response.");
            localBufferedReader2.close();
            localInputStream.close();
            return;
          }
          String str6 = "";
          char[] arrayOfChar = new char[512];
          int i2 = localBufferedReader2.read(arrayOfChar);
          if ((i2 >= 0) && (!str6.endsWith("\r\n")))
          {
            str6 = str6 + String.valueOf(arrayOfChar, 0, i2);
            i2 = localBufferedReader2.read(arrayOfChar);
            continue;
          }
          decodeParms(str6.trim(), localProperties2);
          continue;
          sendResponse(localResponse.status, localResponse.mimeType, localResponse.header, localResponse.data);
          continue;
          return;
          if (i1 >= i) {
            continue;
          }
          l -= 1 + (i - i1);
          continue;
        }
        catch (InterruptedException localInterruptedException) {}
        try
        {
          i3 = Integer.parseInt(str3);
          l = i3;
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
      j = 0;
      k = j;
      m = i;
      n = 0;
      if (k < m)
      {
        if (arrayOfByte1[j] == 13)
        {
          j++;
          if (arrayOfByte1[j] == 10)
          {
            j++;
            if (arrayOfByte1[j] == 13)
            {
              j++;
              if (arrayOfByte1[j] == 10) {
                n = 1;
              }
            }
          }
        }
      }
      else
      {
        i1 = j + 1;
        localByteArrayOutputStream = new ByteArrayOutputStream();
        if (i1 >= i) {
          break label779;
        }
        localByteArrayOutputStream.write(arrayOfByte1, i1, i - i1);
        break label779;
        arrayOfByte2 = new byte[512];
        while ((i >= 0) && (l > 0L))
        {
          i = localInputStream.read(arrayOfByte2, 0, 512);
          l -= i;
          if (i > 0) {
            localByteArrayOutputStream.write(arrayOfByte2, 0, i);
          }
        }
      }
      label779:
    }
  }
  
  public class Response
  {
    public InputStream data;
    public Properties header = new Properties();
    public String mimeType;
    public String status;
    
    public Response()
    {
      this.status = "200 OK";
    }
    
    public Response(String paramString1, String paramString2, InputStream paramInputStream)
    {
      this.status = paramString1;
      this.mimeType = paramString2;
      this.data = paramInputStream;
    }
    
    public Response(String paramString1, String paramString2, String paramString3)
    {
      this.status = paramString1;
      this.mimeType = paramString2;
      try
      {
        this.data = new ByteArrayInputStream(paramString3.getBytes("UTF-8"));
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    
    public void addHeader(String paramString1, String paramString2)
    {
      this.header.put(paramString1, paramString2);
    }
  }
  
  private class myThreadFactory
    implements ThreadFactory
  {
    private myThreadFactory() {}
    
    public Thread newThread(Runnable paramRunnable)
    {
      Thread localThread = new Thread(new ThreadGroup("biggerstack"), paramRunnable, "HTTPD Session", 262144L);
      localThread.setDaemon(true);
      return localThread;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.NanoHTTPD
 * JD-Core Version:    0.7.0.1
 */