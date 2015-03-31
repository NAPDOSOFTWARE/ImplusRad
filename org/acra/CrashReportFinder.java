package org.acra;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;

final class CrashReportFinder
{
  private final Context context;
  
  public CrashReportFinder(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public String[] getCrashReportFiles()
  {
    String[] arrayOfString;
    if (this.context == null)
    {
      Log.e(ACRA.LOG_TAG, "Trying to get ACRA reports but ACRA is not initialized.");
      arrayOfString = new String[0];
    }
    do
    {
      return arrayOfString;
      File localFile = this.context.getFilesDir();
      if (localFile == null)
      {
        Log.w(ACRA.LOG_TAG, "Application files directory does not exist! The application may not be installed correctly. Please try reinstalling.");
        return new String[0];
      }
      Log.d(ACRA.LOG_TAG, "Looking for error files in " + localFile.getAbsolutePath());
      arrayOfString = localFile.list(new FilenameFilter()
      {
        public boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          return paramAnonymousString.endsWith(".stacktrace");
        }
      });
    } while (arrayOfString != null);
    return new String[0];
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.CrashReportFinder
 * JD-Core Version:    0.7.0.1
 */