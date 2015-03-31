package org.acra.collector;

import android.content.Context;
import android.text.format.Time;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;

final class DropBoxCollector
{
  private static final String NO_RESULT = "N/A";
  private static final String[] SYSTEM_TAGS = { "system_app_anr", "system_app_wtf", "system_app_crash", "system_server_anr", "system_server_wtf", "system_server_crash", "BATTERY_DISCHARGE_INFO", "SYSTEM_RECOVERY_LOG", "SYSTEM_BOOT", "SYSTEM_LAST_KMSG", "APANIC_CONSOLE", "APANIC_THREADS", "SYSTEM_RESTART", "SYSTEM_TOMBSTONE", "data_app_strictmode" };
  
  public static String read(Context paramContext, String[] paramArrayOfString)
  {
    for (;;)
    {
      try
      {
        String str1 = Compatibility.getDropBoxServiceName();
        if (str1 == null) {
          return "N/A";
        }
        localObject1 = paramContext.getSystemService(str1);
        Class localClass1 = localObject1.getClass();
        Class[] arrayOfClass1 = new Class[2];
        arrayOfClass1[0] = String.class;
        arrayOfClass1[1] = Long.TYPE;
        localMethod1 = localClass1.getMethod("getNextEntry", arrayOfClass1);
        if (localMethod1 == null) {
          return "";
        }
        localTime = new Time();
        localTime.setToNow();
        localTime.minute -= ACRA.getConfig().dropboxCollectionMinutes();
        localTime.normalize(false);
        l1 = localTime.toMillis(false);
        ArrayList localArrayList = new ArrayList();
        if (ACRA.getConfig().includeDropBoxSystemTags()) {
          localArrayList.addAll(Arrays.asList(SYSTEM_TAGS));
        }
        if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
          localArrayList.addAll(Arrays.asList(paramArrayOfString));
        }
        if (localArrayList.isEmpty()) {
          return "No tag configured for collection.";
        }
        localStringBuilder = new StringBuilder();
        localIterator = localArrayList.iterator();
      }
      catch (SecurityException localSecurityException)
      {
        Object localObject1;
        Method localMethod1;
        Time localTime;
        long l1;
        Iterator localIterator;
        String str3;
        Object[] arrayOfObject1;
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
        return "N/A";
        Class localClass2 = localObject2.getClass();
        Class[] arrayOfClass2 = new Class[1];
        arrayOfClass2[0] = Integer.TYPE;
        Method localMethod2 = localClass2.getMethod("getText", arrayOfClass2);
        Method localMethod3 = localObject2.getClass().getMethod("getTimeMillis", (Class[])null);
        Method localMethod4 = localObject2.getClass().getMethod("close", (Class[])null);
        if (localObject2 == null) {
          continue;
        }
        long l2 = ((Long)localMethod3.invoke(localObject2, (Object[])null)).longValue();
        localTime.set(l2);
        localStringBuilder.append("@").append(localTime.format2445()).append('\n');
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(500);
        String str4 = (String)localMethod2.invoke(localObject2, arrayOfObject2);
        if (str4 == null) {
          continue;
        }
        localStringBuilder.append("Text: ").append(str4).append('\n');
        localMethod4.invoke(localObject2, (Object[])null);
        Object[] arrayOfObject3 = new Object[2];
        arrayOfObject3[0] = str3;
        arrayOfObject3[1] = Long.valueOf(l2);
        Object localObject2 = localMethod1.invoke(localObject1, arrayOfObject3);
        continue;
        localStringBuilder.append("Not Text!").append('\n');
        continue;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        StringBuilder localStringBuilder;
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
        continue;
        String str2 = localStringBuilder.toString();
        return str2;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
        continue;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
        continue;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
        continue;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
        continue;
      }
      if (!localIterator.hasNext()) {
        continue;
      }
      str3 = (String)localIterator.next();
      localStringBuilder.append("Tag: ").append(str3).append('\n');
      arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = str3;
      arrayOfObject1[1] = Long.valueOf(l1);
      localObject2 = localMethod1.invoke(localObject1, arrayOfObject1);
      if (localObject2 != null) {
        continue;
      }
      localStringBuilder.append("Nothing.").append('\n');
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.collector.DropBoxCollector
 * JD-Core Version:    0.7.0.1
 */