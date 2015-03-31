package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.FileUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

@DesignerComponent(category=ComponentCategory.STORAGE, description="Non-visible component for storing and retrieving files. Use this component to write or read files on your device. The default behaviour is to write files to the private data directory associated with your App. The Companion is special cased to write files to /sdcard/AppInventor/data to facilitate debugging. If the file path starts with a slash (/), then the file is created relative to /sdcard. For example writing a file to /myFile.txt will write the file in /sdcard/myFile.txt.", iconName="images/file.png", nonVisible=true, version=1)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.WRITE_EXTERNAL_STORAGE, android.permission.READ_EXTERNAL_STORAGE")
public class File
  extends AndroidNonvisibleComponent
  implements Component
{
  private static final String LOG_TAG = "FileComponent";
  public static final String NO_ASSETS = "No_Assets";
  private final int BUFFER_LENGTH = 4096;
  private final Activity activity;
  private boolean isRepl = false;
  
  public File(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    if ((this.form instanceof ReplForm)) {
      this.isRepl = true;
    }
    this.activity = paramComponentContainer.$context();
  }
  
  private String AbsoluteFileName(String paramString)
  {
    if (paramString.startsWith("/")) {
      return Environment.getExternalStorageDirectory().getPath() + paramString;
    }
    java.io.File localFile = this.activity.getFilesDir();
    if (this.isRepl)
    {
      localFile = new java.io.File(Environment.getExternalStorageDirectory().getPath() + "/AppInventor/data/");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
    return localFile.getPath() + "/" + paramString;
  }
  
  /* Error */
  private void AsyncRead(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 120	java/io/InputStreamReader
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 123	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   10: astore 4
    //   12: new 125	java/io/StringWriter
    //   15: dup
    //   16: invokespecial 126	java/io/StringWriter:<init>	()V
    //   19: astore 5
    //   21: sipush 4096
    //   24: newarray char
    //   26: astore 14
    //   28: aload 4
    //   30: aload 14
    //   32: iconst_0
    //   33: sipush 4096
    //   36: invokevirtual 130	java/io/InputStreamReader:read	([CII)I
    //   39: istore 15
    //   41: iload 15
    //   43: ifle +61 -> 104
    //   46: aload 5
    //   48: aload 14
    //   50: iconst_0
    //   51: iload 15
    //   53: invokevirtual 134	java/io/StringWriter:write	([CII)V
    //   56: goto -28 -> 28
    //   59: astore 11
    //   61: aload 4
    //   63: astore_3
    //   64: ldc 25
    //   66: ldc 136
    //   68: aload 11
    //   70: invokestatic 142	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   73: pop
    //   74: aload_0
    //   75: getfield 53	com/google/appinventor/components/runtime/File:form	Lcom/google/appinventor/components/runtime/Form;
    //   78: aload_0
    //   79: ldc 144
    //   81: sipush 2101
    //   84: iconst_1
    //   85: anewarray 146	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_2
    //   91: aastore
    //   92: invokevirtual 152	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   95: aload_3
    //   96: ifnull +7 -> 103
    //   99: aload_3
    //   100: invokevirtual 155	java/io/InputStreamReader:close	()V
    //   103: return
    //   104: aload_0
    //   105: aload 5
    //   107: invokevirtual 156	java/io/StringWriter:toString	()Ljava/lang/String;
    //   110: invokespecial 159	com/google/appinventor/components/runtime/File:normalizeNewLines	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore 16
    //   115: aload_0
    //   116: getfield 61	com/google/appinventor/components/runtime/File:activity	Landroid/app/Activity;
    //   119: new 161	com/google/appinventor/components/runtime/File$3
    //   122: dup
    //   123: aload_0
    //   124: aload 16
    //   126: invokespecial 164	com/google/appinventor/components/runtime/File$3:<init>	(Lcom/google/appinventor/components/runtime/File;Ljava/lang/String;)V
    //   129: invokevirtual 168	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   132: aload 4
    //   134: ifnull +101 -> 235
    //   137: aload 4
    //   139: invokevirtual 155	java/io/InputStreamReader:close	()V
    //   142: return
    //   143: astore 17
    //   145: return
    //   146: astore 6
    //   148: ldc 25
    //   150: ldc 170
    //   152: aload 6
    //   154: invokestatic 142	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   157: pop
    //   158: aload_0
    //   159: getfield 53	com/google/appinventor/components/runtime/File:form	Lcom/google/appinventor/components/runtime/Form;
    //   162: aload_0
    //   163: ldc 144
    //   165: sipush 2102
    //   168: iconst_1
    //   169: anewarray 146	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_2
    //   175: aastore
    //   176: invokevirtual 152	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   179: aload_3
    //   180: ifnull -77 -> 103
    //   183: aload_3
    //   184: invokevirtual 155	java/io/InputStreamReader:close	()V
    //   187: return
    //   188: astore 10
    //   190: return
    //   191: astore 7
    //   193: aload_3
    //   194: ifnull +7 -> 201
    //   197: aload_3
    //   198: invokevirtual 155	java/io/InputStreamReader:close	()V
    //   201: aload 7
    //   203: athrow
    //   204: astore 13
    //   206: return
    //   207: astore 8
    //   209: goto -8 -> 201
    //   212: astore 7
    //   214: aload 4
    //   216: astore_3
    //   217: goto -24 -> 193
    //   220: astore 6
    //   222: aload 4
    //   224: astore_3
    //   225: goto -77 -> 148
    //   228: astore 11
    //   230: aconst_null
    //   231: astore_3
    //   232: goto -168 -> 64
    //   235: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	File
    //   0	236	1	paramInputStream	InputStream
    //   0	236	2	paramString	String
    //   1	231	3	localObject1	Object
    //   10	213	4	localInputStreamReader	java.io.InputStreamReader
    //   19	87	5	localStringWriter	java.io.StringWriter
    //   146	7	6	localIOException1	IOException
    //   220	1	6	localIOException2	IOException
    //   191	11	7	localObject2	Object
    //   212	1	7	localObject3	Object
    //   207	1	8	localIOException3	IOException
    //   188	1	10	localIOException4	IOException
    //   59	10	11	localFileNotFoundException1	FileNotFoundException
    //   228	1	11	localFileNotFoundException2	FileNotFoundException
    //   204	1	13	localIOException5	IOException
    //   26	23	14	arrayOfChar	char[]
    //   39	13	15	i	int
    //   113	12	16	str	String
    //   143	1	17	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   12	28	59	java/io/FileNotFoundException
    //   28	41	59	java/io/FileNotFoundException
    //   46	56	59	java/io/FileNotFoundException
    //   104	132	59	java/io/FileNotFoundException
    //   137	142	143	java/io/IOException
    //   2	12	146	java/io/IOException
    //   183	187	188	java/io/IOException
    //   2	12	191	finally
    //   64	95	191	finally
    //   148	179	191	finally
    //   99	103	204	java/io/IOException
    //   197	201	207	java/io/IOException
    //   12	28	212	finally
    //   28	41	212	finally
    //   46	56	212	finally
    //   104	132	212	finally
    //   12	28	220	java/io/IOException
    //   28	41	220	java/io/IOException
    //   46	56	220	java/io/IOException
    //   104	132	220	java/io/IOException
    //   2	12	228	java/io/FileNotFoundException
  }
  
  private void Write(final String paramString1, final String paramString2, final boolean paramBoolean)
  {
    if (paramString1.startsWith("//"))
    {
      if (paramBoolean)
      {
        this.form.dispatchErrorOccurredEvent(this, "AppendTo", 2106, new Object[] { paramString1 });
        return;
      }
      this.form.dispatchErrorOccurredEvent(this, "SaveFile", 2106, new Object[] { paramString1 });
      return;
    }
    AsynchUtil.runAsynchronously(new Runnable()
    {
      public void run()
      {
        str = File.this.AbsoluteFileName(paramString1);
        java.io.File localFile = new java.io.File(str);
        if (!localFile.exists()) {}
        try
        {
          localFile.createNewFile();
          FileOutputStream localFileOutputStream;
          OutputStreamWriter localOutputStreamWriter;
          return;
        }
        catch (IOException localIOException2)
        {
          try
          {
            localFileOutputStream = new FileOutputStream(localFile, paramBoolean);
            localOutputStreamWriter = new OutputStreamWriter(localFileOutputStream);
            localOutputStreamWriter.write(paramString2);
            localOutputStreamWriter.flush();
            localOutputStreamWriter.close();
            localFileOutputStream.close();
            return;
          }
          catch (IOException localIOException1)
          {
            if (!paramBoolean) {
              break label182;
            }
            File.this.form.dispatchErrorOccurredEvent(File.this, "AppendTo", 2104, new Object[] { str });
            return;
            File.this.form.dispatchErrorOccurredEvent(File.this, "SaveFile", 2104, new Object[] { str });
          }
          localIOException2 = localIOException2;
          if (paramBoolean)
          {
            File.this.form.dispatchErrorOccurredEvent(File.this, "AppendTo", 2103, new Object[] { str });
            return;
          }
          File.this.form.dispatchErrorOccurredEvent(File.this, "SaveFile", 2103, new Object[] { str });
          return;
        }
      }
    });
  }
  
  private String normalizeNewLines(String paramString)
  {
    return paramString.replaceAll("\r\n", "\n");
  }
  
  @SimpleFunction(description="Appends text to the end of a file storage, creating the file if it does not exist. See the help text under SaveFile for information about where files are written.")
  public void AppendToFile(String paramString1, String paramString2)
  {
    if (paramString2.startsWith("/")) {
      FileUtil.checkExternalStorageWriteable();
    }
    Write(paramString2, paramString1, true);
  }
  
  @SimpleFunction(description="Deletes a file from storage. Prefix the filename with / to delete a specific file in the SD card, for instance /myFile.txt. will delete the file /sdcard/myFile.txt. If the file does not begin with a /, then the file located in the programs private storage will be deleted. Starting the file with // is an error because assets files cannot be deleted.")
  public void Delete(String paramString)
  {
    if (paramString.startsWith("//"))
    {
      this.form.dispatchErrorOccurredEvent(this, "DeleteFile", 2105, new Object[] { paramString });
      return;
    }
    new java.io.File(AbsoluteFileName(paramString)).delete();
  }
  
  @SimpleEvent(description="Event indicating that the contents from the file have been read.")
  public void GotText(String paramString)
  {
    EventDispatcher.dispatchEvent(this, "GotText", new Object[] { paramString });
  }
  
  @SimpleFunction(description="Reads text from a file in storage. Prefix the filename with / to read from a specific file on the SD card. for instance /myFile.txt will read the file /sdcard/myFile.txt. To read assets packaged with an application (also works for the Companion) start the filename with // (two slashes). If a filename does not start with a slash, it will be read from the applications private storage (for packaged apps) and from /sdcard/AppInventor/data for the Companion.")
  public void ReadFrom(final String paramString)
  {
    try
    {
      Object localObject;
      if (paramString.startsWith("//")) {
        if (this.isRepl) {
          localObject = new FileInputStream(Environment.getExternalStorageDirectory().getPath() + "/AppInventor/assets/" + paramString);
        }
      }
      for (;;)
      {
        AsynchUtil.runAsynchronously(new Runnable()
        {
          public void run()
          {
            File.this.AsyncRead(this.val$asyncInputStream, paramString);
          }
        });
        return;
        localObject = this.form.getAssets().open(paramString.substring(2));
        continue;
        String str = AbsoluteFileName(paramString);
        Log.d("FileComponent", "filepath = " + str);
        localObject = new FileInputStream(str);
      }
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Log.e("FileComponent", "FileNotFoundException", localFileNotFoundException);
      this.form.dispatchErrorOccurredEvent(this, "ReadFrom", 2101, new Object[] { paramString });
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("FileComponent", "IOException", localIOException);
      this.form.dispatchErrorOccurredEvent(this, "ReadFrom", 2101, new Object[] { paramString });
    }
  }
  
  @SimpleFunction(description="Saves text to a file. If the filename begins with a slash (/) the file is written to the sdcard. For example writing to /myFile.txt will write the file to /sdcard/myFile.txt. If the filename does not start with a slash, it will be written in the programs private data directory where it will not be accessible to other programs on the phone. There is a special exception for the AI Companion where these files are written to /sdcard/AppInventor/data to facilitate debugging. Note that this block will overwrite a file if it already exists.\n\nIf you want to add content to a file use the append block.")
  public void SaveFile(String paramString1, String paramString2)
  {
    if (paramString2.startsWith("/")) {
      FileUtil.checkExternalStorageWriteable();
    }
    Write(paramString2, paramString1, false);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.File
 * JD-Core Version:    0.7.0.1
 */