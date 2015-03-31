package org.acra.collector;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.util.BoundedLinkedList;

class LogCatCollector
{
  private static final int DEFAULT_TAIL_COUNT = 100;
  
  public static String collectLogCat(String paramString)
  {
    int i = android.os.Process.myPid();
    boolean bool = ACRA.getConfig().logcatFilterByPid();
    String str1 = null;
    if (bool)
    {
      str1 = null;
      if (i > 0) {
        str1 = Integer.toString(i) + "):";
      }
    }
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add("logcat");
    if (paramString != null)
    {
      localArrayList1.add("-b");
      localArrayList1.add(paramString);
    }
    ArrayList localArrayList2 = new ArrayList(Arrays.asList(ACRA.getConfig().logcatArguments()));
    int j = localArrayList2.indexOf("-t");
    int k;
    label199:
    BoundedLinkedList localBoundedLinkedList;
    if ((j > -1) && (j < localArrayList2.size()))
    {
      k = Integer.parseInt((String)localArrayList2.get(j + 1));
      if (Compatibility.getAPILevel() < 8)
      {
        localArrayList2.remove(j + 1);
        localArrayList2.remove(j);
        localArrayList2.add("-d");
      }
      if (k <= 0) {
        break label301;
      }
      localBoundedLinkedList = new BoundedLinkedList(k);
      localArrayList1.addAll(localArrayList2);
    }
    for (;;)
    {
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String[])localArrayList1.toArray(new String[localArrayList1.size()])).getInputStream()), 8192);
        Log.d(ACRA.LOG_TAG, "Retrieving logcat output...");
        str2 = localBufferedReader.readLine();
        if (str2 != null) {
          continue;
        }
      }
      catch (IOException localIOException)
      {
        String str2;
        label301:
        Log.e(ACRA.LOG_TAG, "LogCatCollector.collectLogCat could not retrieve data.", localIOException);
        continue;
      }
      return localBoundedLinkedList.toString();
      k = -1;
      break;
      k = 100;
      break label199;
      if ((str1 == null) || (str2.contains(str1))) {
        localBoundedLinkedList.add(str2 + "\n");
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.collector.LogCatCollector
 * JD-Core Version:    0.7.0.1
 */