package com.google.appinventor.components.runtime.util;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Environment;
import android.provider.Contacts.People;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.VideoView;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.ReplForm;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MediaUtil
{
  private static final String LOG_TAG = "MediaUtil";
  private static final String REPL_ASSET_DIR = "/sdcard/AppInventor/assets/";
  private static ConcurrentHashMap<String, String> pathCache = new ConcurrentHashMap(2);
  private static final Map<String, File> tempFileMap = new HashMap();
  
  private static File cacheMediaTempFile(Form paramForm, String paramString, MediaSource paramMediaSource)
    throws IOException
  {
    File localFile = (File)tempFileMap.get(paramString);
    if ((localFile == null) || (!localFile.exists()))
    {
      Log.i("MediaUtil", "Copying media " + paramString + " to temp file...");
      localFile = copyMediaToTempFile(paramForm, paramString, paramMediaSource);
      Log.i("MediaUtil", "Finished copying media " + paramString + " to temp file " + localFile.getAbsolutePath());
      tempFileMap.put(paramString, localFile);
    }
    return localFile;
  }
  
  public static File copyMediaToTempFile(Form paramForm, String paramString)
    throws IOException
  {
    return copyMediaToTempFile(paramForm, paramString, determineMediaSource(paramForm, paramString));
  }
  
  private static File copyMediaToTempFile(Form paramForm, String paramString, MediaSource paramMediaSource)
    throws IOException
  {
    InputStream localInputStream = openMedia(paramForm, paramString, paramMediaSource);
    File localFile = null;
    for (;;)
    {
      try
      {
        localFile = File.createTempFile("AI_Media_", null);
        localFile.deleteOnExit();
        FileUtil.writeStreamToFile(localInputStream, localFile.getAbsolutePath());
        return localFile;
      }
      catch (IOException localIOException)
      {
        if (localFile != null)
        {
          Log.e("MediaUtil", "Could not copy media " + paramString + " to temp file " + localFile.getAbsolutePath());
          localFile.delete();
          throw localIOException;
        }
      }
      finally
      {
        localInputStream.close();
      }
      Log.e("MediaUtil", "Could not copy media " + paramString + " to temp file.");
    }
  }
  
  private static Bitmap decodeStream(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    return BitmapFactory.decodeStream(new FlushedInputStream(paramInputStream), paramRect, paramOptions);
  }
  
  private static MediaSource determineMediaSource(Form paramForm, String paramString)
  {
    if ((paramString.startsWith("/sdcard/")) || (paramString.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath()))) {
      return MediaSource.SDCARD;
    }
    if (paramString.startsWith("content://contacts/")) {
      return MediaSource.CONTACT_URI;
    }
    if (paramString.startsWith("content://")) {
      return MediaSource.CONTENT_URI;
    }
    try
    {
      new URL(paramString);
      if (paramString.startsWith("file:")) {
        return MediaSource.FILE_URL;
      }
      MediaSource localMediaSource = MediaSource.URL;
      return localMediaSource;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      if ((paramForm instanceof ReplForm))
      {
        if (((ReplForm)paramForm).isAssetsLoaded()) {
          return MediaSource.REPL_ASSET;
        }
        return MediaSource.ASSET;
      }
    }
    return MediaSource.ASSET;
  }
  
  static String fileUrlToFilePath(String paramString)
    throws IOException
  {
    try
    {
      String str = new File(new URL(paramString).toURI()).getAbsolutePath();
      return str;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new IOException("Unable to determine file path of file url " + paramString);
    }
    catch (Exception localException)
    {
      throw new IOException("Unable to determine file path of file url " + paramString);
    }
  }
  
  private static String findCaseinsensitivePath(Form paramForm, String paramString)
    throws IOException
  {
    if (!pathCache.containsKey(paramString))
    {
      String str = findCaseinsensitivePathWithoutCache(paramForm, paramString);
      if (str == null) {
        return null;
      }
      pathCache.put(paramString, str);
    }
    return (String)pathCache.get(paramString);
  }
  
  private static String findCaseinsensitivePathWithoutCache(Form paramForm, String paramString)
    throws IOException
  {
    String[] arrayOfString = paramForm.getAssets().list("");
    int i = Array.getLength(arrayOfString);
    for (int j = 0; j < i; j++)
    {
      String str = arrayOfString[j];
      if (str.equalsIgnoreCase(paramString)) {
        return str;
      }
    }
    return null;
  }
  
  private static AssetFileDescriptor getAssetsIgnoreCaseAfd(Form paramForm, String paramString)
    throws IOException
  {
    try
    {
      AssetFileDescriptor localAssetFileDescriptor = paramForm.getAssets().openFd(paramString);
      return localAssetFileDescriptor;
    }
    catch (IOException localIOException)
    {
      String str = findCaseinsensitivePath(paramForm, paramString);
      if (str == null) {
        throw localIOException;
      }
      return paramForm.getAssets().openFd(str);
    }
  }
  
  private static InputStream getAssetsIgnoreCaseInputStream(Form paramForm, String paramString)
    throws IOException
  {
    try
    {
      InputStream localInputStream = paramForm.getAssets().open(paramString);
      return localInputStream;
    }
    catch (IOException localIOException)
    {
      String str = findCaseinsensitivePath(paramForm, paramString);
      if (str == null) {
        throw localIOException;
      }
      return paramForm.getAssets().open(str);
    }
  }
  
  public static BitmapDrawable getBitmapDrawable(Form paramForm, String paramString)
    throws IOException
  {
    BitmapDrawable localBitmapDrawable;
    if ((paramString == null) || (paramString.length() == 0)) {
      localBitmapDrawable = null;
    }
    for (;;)
    {
      return localBitmapDrawable;
      MediaSource localMediaSource = determineMediaSource(paramForm, paramString);
      try
      {
        localInputStream1 = openMedia(paramForm, paramString, localMediaSource);
      }
      catch (IOException localIOException)
      {
        try
        {
          localOptions = getBitmapOptions(paramForm, localInputStream1);
          localInputStream1.close();
          localInputStream2 = openMedia(paramForm, paramString, localMediaSource);
        }
        finally
        {
          InputStream localInputStream1;
          BitmapFactory.Options localOptions;
          localInputStream1.close();
        }
        try
        {
          localBitmapDrawable = new BitmapDrawable(decodeStream(localInputStream2, null, localOptions));
          if (localInputStream2 == null) {
            continue;
          }
          localInputStream2.close();
          return localBitmapDrawable;
        }
        finally
        {
          if (localInputStream2 == null) {
            break label131;
          }
          localInputStream2.close();
        }
        localIOException = localIOException;
        if (localMediaSource == MediaSource.CONTACT_URI) {
          return new BitmapDrawable(BitmapFactory.decodeResource(paramForm.getResources(), 17301606, null));
        }
        throw localIOException;
      }
    }
  }
  
  private static BitmapFactory.Options getBitmapOptions(Form paramForm, InputStream paramInputStream)
  {
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    localOptions1.inJustDecodeBounds = true;
    decodeStream(paramInputStream, null, localOptions1);
    int i = localOptions1.outWidth;
    int j = localOptions1.outHeight;
    Display localDisplay = ((WindowManager)paramForm.getSystemService("window")).getDefaultDisplay();
    int k = 2 * localDisplay.getWidth();
    int m = 2 * localDisplay.getHeight();
    int n = 1;
    while ((i / n > k) && (j / n > m)) {
      n *= 2;
    }
    BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
    localOptions2.inSampleSize = n;
    return localOptions2;
  }
  
  public static void loadMediaPlayer(MediaPlayer paramMediaPlayer, Form paramForm, String paramString)
    throws IOException
  {
    MediaSource localMediaSource = determineMediaSource(paramForm, paramString);
    switch (1.$SwitchMap$com$google$appinventor$components$runtime$util$MediaUtil$MediaSource[localMediaSource.ordinal()])
    {
    default: 
      throw new IOException("Unable to load audio or video " + paramString + ".");
    case 1: 
      AssetFileDescriptor localAssetFileDescriptor = getAssetsIgnoreCaseAfd(paramForm, paramString);
      try
      {
        paramMediaPlayer.setDataSource(localAssetFileDescriptor.getFileDescriptor(), localAssetFileDescriptor.getStartOffset(), localAssetFileDescriptor.getLength());
        return;
      }
      finally
      {
        localAssetFileDescriptor.close();
      }
    case 2: 
      paramMediaPlayer.setDataSource(replAssetPath(paramString));
      return;
    case 3: 
      paramMediaPlayer.setDataSource(paramString);
      return;
    case 4: 
      paramMediaPlayer.setDataSource(fileUrlToFilePath(paramString));
      return;
    case 5: 
      paramMediaPlayer.setDataSource(paramString);
      return;
    case 6: 
      paramMediaPlayer.setDataSource(paramForm, Uri.parse(paramString));
      return;
    }
    throw new IOException("Unable to load audio or video for contact " + paramString + ".");
  }
  
  public static int loadSoundPool(SoundPool paramSoundPool, Form paramForm, String paramString)
    throws IOException
  {
    MediaSource localMediaSource = determineMediaSource(paramForm, paramString);
    switch (1.$SwitchMap$com$google$appinventor$components$runtime$util$MediaUtil$MediaSource[localMediaSource.ordinal()])
    {
    default: 
      throw new IOException("Unable to load audio " + paramString + ".");
    case 1: 
      return paramSoundPool.load(getAssetsIgnoreCaseAfd(paramForm, paramString), 1);
    case 2: 
      return paramSoundPool.load(replAssetPath(paramString), 1);
    case 3: 
      return paramSoundPool.load(paramString, 1);
    case 4: 
      return paramSoundPool.load(fileUrlToFilePath(paramString), 1);
    case 5: 
    case 6: 
      return paramSoundPool.load(cacheMediaTempFile(paramForm, paramString, localMediaSource).getAbsolutePath(), 1);
    }
    throw new IOException("Unable to load audio for contact " + paramString + ".");
  }
  
  public static void loadVideoView(VideoView paramVideoView, Form paramForm, String paramString)
    throws IOException
  {
    MediaSource localMediaSource = determineMediaSource(paramForm, paramString);
    switch (1.$SwitchMap$com$google$appinventor$components$runtime$util$MediaUtil$MediaSource[localMediaSource.ordinal()])
    {
    default: 
      throw new IOException("Unable to load video " + paramString + ".");
    case 1: 
    case 5: 
      paramVideoView.setVideoPath(cacheMediaTempFile(paramForm, paramString, localMediaSource).getAbsolutePath());
      return;
    case 2: 
      paramVideoView.setVideoPath(replAssetPath(paramString));
      return;
    case 3: 
      paramVideoView.setVideoPath(paramString);
      return;
    case 4: 
      paramVideoView.setVideoPath(fileUrlToFilePath(paramString));
      return;
    case 6: 
      paramVideoView.setVideoURI(Uri.parse(paramString));
      return;
    }
    throw new IOException("Unable to load video for contact " + paramString + ".");
  }
  
  public static InputStream openMedia(Form paramForm, String paramString)
    throws IOException
  {
    return openMedia(paramForm, paramString, determineMediaSource(paramForm, paramString));
  }
  
  private static InputStream openMedia(Form paramForm, String paramString, MediaSource paramMediaSource)
    throws IOException
  {
    InputStream localInputStream;
    switch (1.$SwitchMap$com$google$appinventor$components$runtime$util$MediaUtil$MediaSource[paramMediaSource.ordinal()])
    {
    default: 
      throw new IOException("Unable to open media " + paramString + ".");
    case 1: 
      localInputStream = getAssetsIgnoreCaseInputStream(paramForm, paramString);
    }
    for (;;)
    {
      return localInputStream;
      return new FileInputStream(replAssetPath(paramString));
      return new FileInputStream(paramString);
      return new URL(paramString).openStream();
      return paramForm.getContentResolver().openInputStream(Uri.parse(paramString));
      if (SdkLevel.getLevel() >= 12) {}
      for (localInputStream = HoneycombUtil.openContactPhotoInputStreamHelper(paramForm.getContentResolver(), Uri.parse(paramString)); localInputStream == null; localInputStream = Contacts.People.openContactPhotoInputStream(paramForm.getContentResolver(), Uri.parse(paramString))) {
        throw new IOException("Unable to open contact photo " + paramString + ".");
      }
    }
  }
  
  private static String replAssetPath(String paramString)
  {
    return "/sdcard/AppInventor/assets/" + paramString;
  }
  
  private static class FlushedInputStream
    extends FilterInputStream
  {
    public FlushedInputStream(InputStream paramInputStream)
    {
      super();
    }
    
    public long skip(long paramLong)
      throws IOException
    {
      long l2;
      for (long l1 = 0L;; l1 += l2)
      {
        if (l1 < paramLong)
        {
          l2 = this.in.skip(paramLong - l1);
          if (l2 != 0L) {
            continue;
          }
          if (read() >= 0) {}
        }
        else
        {
          return l1;
        }
        l2 = 1L;
      }
    }
  }
  
  private static enum MediaSource
  {
    static
    {
      FILE_URL = new MediaSource("FILE_URL", 3);
      URL = new MediaSource("URL", 4);
      CONTENT_URI = new MediaSource("CONTENT_URI", 5);
      CONTACT_URI = new MediaSource("CONTACT_URI", 6);
      MediaSource[] arrayOfMediaSource = new MediaSource[7];
      arrayOfMediaSource[0] = ASSET;
      arrayOfMediaSource[1] = REPL_ASSET;
      arrayOfMediaSource[2] = SDCARD;
      arrayOfMediaSource[3] = FILE_URL;
      arrayOfMediaSource[4] = URL;
      arrayOfMediaSource[5] = CONTENT_URI;
      arrayOfMediaSource[6] = CONTACT_URI;
      $VALUES = arrayOfMediaSource;
    }
    
    private MediaSource() {}
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.MediaUtil
 * JD-Core Version:    0.7.0.1
 */