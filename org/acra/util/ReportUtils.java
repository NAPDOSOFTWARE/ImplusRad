package org.acra.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import org.acra.ACRA;

public final class ReportUtils
{
  public static String getApplicationFilePath(Context paramContext)
  {
    File localFile = paramContext.getFilesDir();
    if (localFile != null) {
      return localFile.getAbsolutePath();
    }
    Log.w(ACRA.LOG_TAG, "Couldn't retrieve ApplicationFilePath for : " + paramContext.getPackageName());
    return "Couldn't retrieve ApplicationFilePath";
  }
  
  public static long getAvailableInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getAvailableBlocks();
  }
  
  public static String getDeviceId(Context paramContext)
  {
    try
    {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return str;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w(ACRA.LOG_TAG, "Couldn't retrieve DeviceId for : " + paramContext.getPackageName(), localRuntimeException);
    }
    return null;
  }
  
  public static String getDisplayDetails(Context paramContext)
  {
    try
    {
      Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      localDisplay.getMetrics(localDisplayMetrics);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("width=").append(localDisplay.getWidth()).append('\n');
      localStringBuilder.append("height=").append(localDisplay.getHeight()).append('\n');
      localStringBuilder.append("pixelFormat=").append(localDisplay.getPixelFormat()).append('\n');
      localStringBuilder.append("refreshRate=").append(localDisplay.getRefreshRate()).append("fps").append('\n');
      localStringBuilder.append("metrics.density=x").append(localDisplayMetrics.density).append('\n');
      localStringBuilder.append("metrics.scaledDensity=x").append(localDisplayMetrics.scaledDensity).append('\n');
      localStringBuilder.append("metrics.widthPixels=").append(localDisplayMetrics.widthPixels).append('\n');
      localStringBuilder.append("metrics.heightPixels=").append(localDisplayMetrics.heightPixels).append('\n');
      localStringBuilder.append("metrics.xdpi=").append(localDisplayMetrics.xdpi).append('\n');
      localStringBuilder.append("metrics.ydpi=").append(localDisplayMetrics.ydpi);
      String str = localStringBuilder.toString();
      return str;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w(ACRA.LOG_TAG, "Couldn't retrieve DisplayDetails for : " + paramContext.getPackageName(), localRuntimeException);
    }
    return "Couldn't retrieve Display Details";
  }
  
  public static long getTotalInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getBlockCount();
  }
  
  public static String sparseArrayToString(SparseArray<?> paramSparseArray)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramSparseArray == null) {
      return "null";
    }
    localStringBuilder.append('{');
    int i = 0;
    if (i < paramSparseArray.size())
    {
      localStringBuilder.append(paramSparseArray.keyAt(i));
      localStringBuilder.append(" => ");
      if (paramSparseArray.valueAt(i) == null) {
        localStringBuilder.append("null");
      }
      for (;;)
      {
        if (i < -1 + paramSparseArray.size()) {
          localStringBuilder.append(", ");
        }
        i++;
        break;
        localStringBuilder.append(paramSparseArray.valueAt(i).toString());
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.util.ReportUtils
 * JD-Core Version:    0.7.0.1
 */