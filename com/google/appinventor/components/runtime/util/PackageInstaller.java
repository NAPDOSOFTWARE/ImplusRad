package com.google.appinventor.components.runtime.util;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.google.appinventor.components.runtime.Form;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class PackageInstaller
{
  private static final String LOG_TAG = "PackageInstaller(AppInventor)";
  private static final String REPL_ASSET_DIR = "/sdcard/AppInventor/assets/";
  
  public static void doPackageInstall(final Form paramForm, String paramString)
  {
    AsynchUtil.runAsynchronously(new Runnable()
    {
      public void run()
      {
        File localFile;
        FileOutputStream localFileOutputStream;
        try
        {
          URLConnection localURLConnection = new URL(this.val$inurl).openConnection();
          localFile = new File("/sdcard/AppInventor/assets/");
          BufferedInputStream localBufferedInputStream = new BufferedInputStream(localURLConnection.getInputStream());
          localFileOutputStream = new FileOutputStream(new File(localFile + "/package.apk"));
          byte[] arrayOfByte = new byte[32768];
          for (;;)
          {
            int i = localBufferedInputStream.read(arrayOfByte, 0, 32768);
            if (i <= 0) {
              break;
            }
            localFileOutputStream.write(arrayOfByte, 0, i);
          }
          Form localForm1;
          Form localForm2;
          Object[] arrayOfObject;
          localBufferedInputStream.close();
        }
        catch (Exception localException)
        {
          localForm1 = paramForm;
          localForm2 = paramForm;
          arrayOfObject = new Object[1];
          arrayOfObject[0] = this.val$inurl;
          localForm1.dispatchErrorOccurredEvent(localForm2, "PackageInstaller", 1101, arrayOfObject);
          return;
        }
        localFileOutputStream.close();
        Log.d("PackageInstaller(AppInventor)", "About to Install package from " + this.val$inurl);
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setDataAndType(Uri.fromFile(new File(localFile + "/package.apk")), "application/vnd.android.package-archive");
        paramForm.startActivity(localIntent);
      }
    });
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.PackageInstaller
 * JD-Core Version:    0.7.0.1
 */