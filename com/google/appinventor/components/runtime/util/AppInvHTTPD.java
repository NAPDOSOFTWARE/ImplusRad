package com.google.appinventor.components.runtime.util;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import com.google.appinventor.components.runtime.ReplForm;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.Properties;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kawa.standard.Scheme;

public class AppInvHTTPD
  extends NanoHTTPD
{
  private static final String LOG_TAG = "AppInvHTTPD";
  private static final String MIME_JSON = "application/json";
  private static final int YAV_SKEW_BACKWARD = 4;
  private static final int YAV_SKEW_FORWARD = 1;
  private static byte[] hmacKey;
  private static int seq;
  private final Handler androidUIHandler = new Handler();
  private ReplForm form;
  private File rootDir;
  private Language scheme;
  private boolean secure;
  
  public AppInvHTTPD(int paramInt, File paramFile, boolean paramBoolean, ReplForm paramReplForm)
    throws IOException
  {
    super(paramInt, paramFile);
    this.rootDir = paramFile;
    this.scheme = Scheme.getInstance("scheme");
    this.form = paramReplForm;
    this.secure = paramBoolean;
    ModuleExp.mustNeverCompile();
  }
  
  private void copyFile(File paramFile1, File paramFile2)
  {
    FileOutputStream localFileOutputStream;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile1);
      localFileOutputStream = new FileOutputStream(paramFile2);
      byte[] arrayOfByte = new byte[32768];
      for (;;)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
      localFileInputStream.close();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    localFileOutputStream.close();
  }
  
  private void doPackageUpdate(String paramString)
  {
    PackageInstaller.doPackageInstall(this.form, paramString);
  }
  
  public static void setHmacKey(String paramString)
  {
    hmacKey = paramString.getBytes();
    seq = 1;
  }
  
  public void resetSeq()
  {
    seq = 1;
  }
  
  public NanoHTTPD.Response serve(String paramString1, String paramString2, Properties paramProperties1, Properties paramProperties2, Properties paramProperties3, Socket paramSocket)
  {
    Log.d("AppInvHTTPD", paramString2 + " '" + paramString1 + "' ");
    NanoHTTPD.Response localResponse11;
    if (this.secure)
    {
      String str25 = paramSocket.getInetAddress().getHostAddress();
      if (!str25.equals("127.0.0.1"))
      {
        Log.d("AppInvHTTPD", "Debug: hostAddress = " + str25 + " while in secure mode, closing connection.");
        String str26 = "{\"status\" : \"BAD\", \"message\" : \"Security Error: Invalid Source Location " + str25 + "\"}";
        localResponse11 = new NanoHTTPD.Response(this, "200 OK", "application/json", str26);
        localResponse11.addHeader("Access-Control-Allow-Origin", "*");
        localResponse11.addHeader("Access-Control-Allow-Headers", "origin, content-type");
        localResponse11.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
        localResponse11.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
        return localResponse11;
      }
    }
    if (paramString2.equals("OPTIONS"))
    {
      Enumeration localEnumeration4 = paramProperties1.propertyNames();
      while (localEnumeration4.hasMoreElements())
      {
        String str24 = (String)localEnumeration4.nextElement();
        Log.d("AppInvHTTPD", "  HDR: '" + str24 + "' = '" + paramProperties1.getProperty(str24) + "'");
      }
      NanoHTTPD.Response localResponse17 = new NanoHTTPD.Response(this, "200 OK", "text/plain", "OK");
      localResponse17.addHeader("Access-Control-Allow-Origin", "*");
      localResponse17.addHeader("Access-Control-Allow-Headers", "origin, content-type");
      localResponse17.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
      localResponse17.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
      return localResponse17;
    }
    String str17;
    if (paramString1.equals("/_newblocks"))
    {
      String str16 = paramProperties2.getProperty("seq", "0");
      int k = Integer.parseInt(str16);
      str17 = paramProperties2.getProperty("blockid");
      String str18 = paramProperties2.getProperty("code");
      String str19 = paramProperties2.getProperty("mac", "no key provided");
      String str21;
      if (hmacKey != null)
      {
        try
        {
          Mac localMac2 = Mac.getInstance("HmacSHA1");
          SecretKeySpec localSecretKeySpec2 = new SecretKeySpec(hmacKey, "RAW");
          localMac2.init(localSecretKeySpec2);
          byte[] arrayOfByte2 = localMac2.doFinal((str18 + str16 + str17).getBytes());
          StringBuffer localStringBuffer2 = new StringBuffer(2 * arrayOfByte2.length);
          Formatter localFormatter2 = new Formatter(localStringBuffer2);
          int m = arrayOfByte2.length;
          for (int n = 0; n < m; n++)
          {
            byte b2 = arrayOfByte2[n];
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = Byte.valueOf(b2);
            localFormatter2.format("%02x", arrayOfObject2);
          }
          String str20 = localStringBuffer2.toString();
          Log.d("AppInvHTTPD", "Incoming Mac = " + str19);
          Log.d("AppInvHTTPD", "Computed Mac = " + str20);
          Log.d("AppInvHTTPD", "Incoming seq = " + str16);
          Log.d("AppInvHTTPD", "Computed seq = " + seq);
          Log.d("AppInvHTTPD", "blockid = " + str17);
          if (!str19.equals(str20))
          {
            Log.e("AppInvHTTPD", "Hmac does not match");
            this.form.dispatchErrorOccurredEvent(this.form, "AppInvHTTPD", 1801, new Object[] { "Invalid HMAC" });
            NanoHTTPD.Response localResponse16 = new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"status\" : \"BAD\", \"message\" : \"Security Error: Invalid MAC\"}");
            return localResponse16;
          }
        }
        catch (Exception localException2)
        {
          Log.e("AppInvHTTPD", "Error working with hmac", localException2);
          this.form.dispatchErrorOccurredEvent(this.form, "AppInvHTTPD", 1801, new Object[] { "Exception working on HMAC" });
          NanoHTTPD.Response localResponse13 = new NanoHTTPD.Response(this, "200 OK", "text/plain", "NOT");
          return localResponse13;
        }
        if ((seq != k) && (seq != k + 1))
        {
          Log.e("AppInvHTTPD", "Seq does not match");
          this.form.dispatchErrorOccurredEvent(this.form, "AppInvHTTPD", 1801, new Object[] { "Invalid Seq" });
          NanoHTTPD.Response localResponse15 = new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"status\" : \"BAD\", \"message\" : \"Security Error: Invalid Seq\"}");
          return localResponse15;
        }
        if (seq == k + 1) {
          Log.e("AppInvHTTPD", "Seq Fixup Invoked");
        }
        seq = k + 1;
        str21 = "(begin (require <com.google.youngandroid.runtime>) (process-repl-input " + str17 + " (begin " + str18 + " )))";
        Log.d("AppInvHTTPD", "To Eval: " + str21);
      }
      for (;;)
      {
        try
        {
          if (!str18.equals("#f")) {
            continue;
          }
          Log.e("AppInvHTTPD", "Skipping evaluation of #f");
          String str23 = RetValManager.fetch(false);
          localResponse14 = new NanoHTTPD.Response(this, "200 OK", "application/json", str23);
        }
        catch (Throwable localThrowable)
        {
          NanoHTTPD.Response localResponse12;
          Log.e("AppInvHTTPD", "newblocks: Scheme Failure", localThrowable);
          RetValManager.appendReturnValue(str17, "BAD", localThrowable.toString());
          String str22 = RetValManager.fetch(false);
          NanoHTTPD.Response localResponse14 = new NanoHTTPD.Response(this, "200 OK", "application/json", str22);
          continue;
        }
        localResponse14.addHeader("Access-Control-Allow-Origin", "*");
        localResponse14.addHeader("Access-Control-Allow-Headers", "origin, content-type");
        localResponse14.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
        localResponse14.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
        return localResponse14;
        Log.e("AppInvHTTPD", "No HMAC Key");
        this.form.dispatchErrorOccurredEvent(this.form, "AppInvHTTPD", 1801, new Object[] { "No HMAC Key" });
        localResponse12 = new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"status\" : \"BAD\", \"message\" : \"Security Error: No HMAC Key\"}");
        return localResponse12;
        this.scheme.eval(str21);
      }
    }
    if (paramString1.equals("/_values"))
    {
      NanoHTTPD.Response localResponse1 = new NanoHTTPD.Response(this, "200 OK", "application/json", RetValManager.fetch(true));
      localResponse1.addHeader("Access-Control-Allow-Origin", "*");
      localResponse1.addHeader("Access-Control-Allow-Headers", "origin, content-type");
      localResponse1.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
      localResponse1.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
      return localResponse1;
    }
    if (paramString1.equals("/_getversion")) {
      for (;;)
      {
        try
        {
          String str12 = this.form.getPackageName();
          PackageInfo localPackageInfo = this.form.getPackageManager().getPackageInfo(str12, 0);
          if (SdkLevel.getLevel() < 5) {
            continue;
          }
          str13 = EclairUtil.getInstallerPackageName("edu.mit.appinventor.aicompanion3", this.form);
          String str14 = localPackageInfo.versionName;
          if (str13 == null) {
            str13 = "Not Known";
          }
          String str15 = "{\"version\" : \"" + str14 + "\", \"fingerprint\" : \"" + Build.FINGERPRINT + "\"," + " \"installer\" : \"" + str13 + "\", \"package\" : \"" + str12 + "\" }";
          localResponse11 = new NanoHTTPD.Response(this, "200 OK", "application/json", str15);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          String str13;
          Handler localHandler;
          Runnable local1;
          localNameNotFoundException.printStackTrace();
          localResponse11 = new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"verison\" : \"Unknown\"");
          continue;
        }
        localResponse11.addHeader("Access-Control-Allow-Origin", "*");
        localResponse11.addHeader("Access-Control-Allow-Headers", "origin, content-type");
        localResponse11.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
        localResponse11.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
        if (!this.secure) {
          break;
        }
        seq = 1;
        localHandler = this.androidUIHandler;
        local1 = new Runnable()
        {
          public void run()
          {
            AppInvHTTPD.this.form.clear();
          }
        };
        localHandler.post(local1);
        return localResponse11;
        str13 = "Not Known";
      }
    }
    if ((paramString1.equals("/_update")) || (paramString1.equals("/_install")))
    {
      String str1 = paramProperties2.getProperty("url", "");
      String str2 = paramProperties2.getProperty("mac", "");
      if ((!str1.equals("")) && (hmacKey != null) && (!str2.equals("")))
      {
        try
        {
          SecretKeySpec localSecretKeySpec1 = new SecretKeySpec(hmacKey, "RAW");
          Mac localMac1 = Mac.getInstance("HmacSHA1");
          localMac1.init(localSecretKeySpec1);
          byte[] arrayOfByte1 = localMac1.doFinal(str1.getBytes());
          StringBuffer localStringBuffer1 = new StringBuffer(2 * arrayOfByte1.length);
          Formatter localFormatter1 = new Formatter(localStringBuffer1);
          int i = arrayOfByte1.length;
          for (int j = 0; j < i; j++)
          {
            byte b1 = arrayOfByte1[j];
            Object[] arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = Byte.valueOf(b1);
            localFormatter1.format("%02x", arrayOfObject1);
          }
          String str3 = localStringBuffer1.toString();
          Log.d("AppInvHTTPD", "Incoming Mac (update) = " + str2);
          Log.d("AppInvHTTPD", "Computed Mac (update) = " + str3);
          if (!str2.equals(str3))
          {
            Log.e("AppInvHTTPD", "Hmac does not match");
            this.form.dispatchErrorOccurredEvent(this.form, "AppInvHTTPD", 1801, new Object[] { "Invalid HMAC (update)" });
            NanoHTTPD.Response localResponse5 = new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"status\" : \"BAD\", \"message\" : \"Security Error: Invalid MAC\"}");
            localResponse5.addHeader("Access-Control-Allow-Origin", "*");
            localResponse5.addHeader("Access-Control-Allow-Headers", "origin, content-type");
            localResponse5.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
            localResponse5.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
            return localResponse5;
          }
        }
        catch (Exception localException1)
        {
          Log.e("AppInvHTTPD", "Error verifying update", localException1);
          this.form.dispatchErrorOccurredEvent(this.form, "AppInvHTTPD", 1801, new Object[] { "Exception working on HMAC for update" });
          NanoHTTPD.Response localResponse3 = new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"status\" : \"BAD\", \"message\" : \"Security Error: Exception processing MAC\"}");
          localResponse3.addHeader("Access-Control-Allow-Origin", "*");
          localResponse3.addHeader("Access-Control-Allow-Headers", "origin, content-type");
          localResponse3.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
          localResponse3.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
          return localResponse3;
        }
        doPackageUpdate(str1);
        NanoHTTPD.Response localResponse4 = new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"status\" : \"OK\", \"message\" : \"Update Should Happen\"}");
        localResponse4.addHeader("Access-Control-Allow-Origin", "*");
        localResponse4.addHeader("Access-Control-Allow-Headers", "origin, content-type");
        localResponse4.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
        localResponse4.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
        return localResponse4;
      }
      NanoHTTPD.Response localResponse2 = new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"status\" : \"BAD\", \"message\" : \"Missing Parameters\"}");
      localResponse2.addHeader("Access-Control-Allow-Origin", "*");
      localResponse2.addHeader("Access-Control-Allow-Headers", "origin, content-type");
      localResponse2.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
      localResponse2.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
      return localResponse2;
    }
    if (paramString1.equals("/_package"))
    {
      String str11 = paramProperties2.getProperty("package", null);
      if (str11 == null)
      {
        NanoHTTPD.Response localResponse9 = new NanoHTTPD.Response(this, "200 OK", "text/plain", "NOT OK");
        return localResponse9;
      }
      Log.d("AppInvHTTPD", this.rootDir + "/" + str11);
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.fromFile(new File(this.rootDir + "/" + str11)), "application/vnd.android.package-archive");
      this.form.startActivity(localIntent);
      NanoHTTPD.Response localResponse10 = new NanoHTTPD.Response(this, "200 OK", "text/plain", "OK");
      return localResponse10;
    }
    if (paramString2.equals("PUT"))
    {
      Boolean localBoolean = Boolean.valueOf(false);
      String str9 = paramProperties3.getProperty("content", null);
      File localFile3;
      if (str9 != null)
      {
        localFile3 = new File(str9);
        String str10 = paramProperties2.getProperty("filename", null);
        if ((str10 != null) && ((str10.startsWith("..")) || (str10.endsWith("..")) || (str10.indexOf("../") >= 0)))
        {
          Log.d("AppInvHTTPD", " Ignoring invalid filename: " + str10);
          str10 = null;
        }
        if (str10 != null)
        {
          File localFile4 = new File(this.rootDir + "/" + str10);
          if (!localFile3.renameTo(localFile4))
          {
            copyFile(localFile3, localFile4);
            localFile3.delete();
          }
        }
      }
      while (localBoolean.booleanValue())
      {
        NanoHTTPD.Response localResponse7 = new NanoHTTPD.Response(this, "200 OK", "text/plain", "NOTOK");
        localResponse7.addHeader("Access-Control-Allow-Origin", "*");
        localResponse7.addHeader("Access-Control-Allow-Headers", "origin, content-type");
        localResponse7.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
        localResponse7.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
        return localResponse7;
        localFile3.delete();
        Log.e("AppInvHTTPD", "Received content without a file name!");
        localBoolean = Boolean.valueOf(true);
        continue;
        Log.e("AppInvHTTPD", "Received PUT without content.");
        localBoolean = Boolean.valueOf(true);
      }
      NanoHTTPD.Response localResponse8 = new NanoHTTPD.Response(this, "200 OK", "text/plain", "OK");
      localResponse8.addHeader("Access-Control-Allow-Origin", "*");
      localResponse8.addHeader("Access-Control-Allow-Headers", "origin, content-type");
      localResponse8.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
      localResponse8.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
      return localResponse8;
    }
    Enumeration localEnumeration1 = paramProperties1.propertyNames();
    while (localEnumeration1.hasMoreElements())
    {
      String str8 = (String)localEnumeration1.nextElement();
      Log.d("AppInvHTTPD", "  HDR: '" + str8 + "' = '" + paramProperties1.getProperty(str8) + "'");
    }
    Enumeration localEnumeration2 = paramProperties2.propertyNames();
    while (localEnumeration2.hasMoreElements())
    {
      String str7 = (String)localEnumeration2.nextElement();
      Log.d("AppInvHTTPD", "  PRM: '" + str7 + "' = '" + paramProperties2.getProperty(str7) + "'");
    }
    Enumeration localEnumeration3 = paramProperties3.propertyNames();
    if (localEnumeration3.hasMoreElements())
    {
      String str4 = (String)localEnumeration3.nextElement();
      String str5 = paramProperties3.getProperty(str4);
      String str6 = paramProperties2.getProperty(str4);
      if ((str6.startsWith("..")) || (str6.endsWith("..")) || (str6.indexOf("../") >= 0))
      {
        Log.d("AppInvHTTPD", " Ignoring invalid filename: " + str6);
        str6 = null;
      }
      File localFile1 = new File(str5);
      if (str6 == null) {
        localFile1.delete();
      }
      for (;;)
      {
        Log.d("AppInvHTTPD", " UPLOADED: '" + str6 + "' was at '" + str5 + "'");
        NanoHTTPD.Response localResponse6 = new NanoHTTPD.Response(this, "200 OK", "text/plain", "OK");
        localResponse6.addHeader("Access-Control-Allow-Origin", "*");
        localResponse6.addHeader("Access-Control-Allow-Headers", "origin, content-type");
        localResponse6.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
        localResponse6.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
        return localResponse6;
        File localFile2 = new File(this.rootDir + "/" + str6);
        if (!localFile1.renameTo(localFile2))
        {
          copyFile(localFile1, localFile2);
          localFile1.delete();
        }
      }
    }
    return serveFile(paramString1, paramProperties1, this.rootDir, true);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.AppInvHTTPD
 * JD-Core Version:    0.7.0.1
 */