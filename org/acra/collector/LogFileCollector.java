package org.acra.collector;

import android.content.Context;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.acra.util.BoundedLinkedList;

class LogFileCollector
{
  public static String collectLogFile(Context paramContext, String paramString, int paramInt)
    throws IOException
  {
    BoundedLinkedList localBoundedLinkedList = new BoundedLinkedList(paramInt);
    if (paramString.contains("/")) {}
    for (BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(paramString)), 1024);; localBufferedReader = new BufferedReader(new InputStreamReader(paramContext.openFileInput(paramString)), 1024)) {
      for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine()) {
        localBoundedLinkedList.add(str + "\n");
      }
    }
    return localBoundedLinkedList.toString();
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.collector.LogFileCollector
 * JD-Core Version:    0.7.0.1
 */