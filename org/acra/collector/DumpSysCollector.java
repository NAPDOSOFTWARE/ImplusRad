package org.acra.collector;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.acra.ACRA;

final class DumpSysCollector
{
  public static String collectMemInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("dumpsys");
        localArrayList.add("meminfo");
        localArrayList.add(Integer.toString(android.os.Process.myPid()));
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String[])localArrayList.toArray(new String[localArrayList.size()])).getInputStream()), 8192);
        str = localBufferedReader.readLine();
        if (str != null) {
          continue;
        }
      }
      catch (IOException localIOException)
      {
        String str;
        Log.e(ACRA.LOG_TAG, "DumpSysCollector.meminfo could not retrieve data", localIOException);
        continue;
      }
      return localStringBuilder.toString();
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.collector.DumpSysCollector
 * JD-Core Version:    0.7.0.1
 */