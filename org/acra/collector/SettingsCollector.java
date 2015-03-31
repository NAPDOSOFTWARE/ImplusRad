package org.acra.collector;

import android.content.Context;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.util.Log;
import java.lang.reflect.Field;
import org.acra.ACRA;

final class SettingsCollector
{
  public static String collectSecureSettings(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Field[] arrayOfField = Settings.Secure.class.getFields();
    int i = arrayOfField.length;
    int j = 0;
    for (;;)
    {
      if (j >= i) {
        break label146;
      }
      Field localField = arrayOfField[j];
      if ((!localField.isAnnotationPresent(Deprecated.class)) && (localField.getType() == String.class) && (isAuthorized(localField))) {}
      try
      {
        String str = Settings.Secure.getString(paramContext.getContentResolver(), (String)localField.get(null));
        if (str != null) {
          localStringBuilder.append(localField.getName()).append("=").append(str).append("\n");
        }
        j++;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          Log.w(ACRA.LOG_TAG, "Error : ", localIllegalArgumentException);
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          Log.w(ACRA.LOG_TAG, "Error : ", localIllegalAccessException);
        }
      }
    }
    label146:
    return localStringBuilder.toString();
  }
  
  public static String collectSystemSettings(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Field[] arrayOfField = Settings.System.class.getFields();
    int i = arrayOfField.length;
    int j = 0;
    for (;;)
    {
      if (j >= i) {
        break label138;
      }
      Field localField = arrayOfField[j];
      if ((!localField.isAnnotationPresent(Deprecated.class)) && (localField.getType() == String.class)) {}
      try
      {
        String str = Settings.System.getString(paramContext.getContentResolver(), (String)localField.get(null));
        if (str != null) {
          localStringBuilder.append(localField.getName()).append("=").append(str).append("\n");
        }
        j++;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          Log.w(ACRA.LOG_TAG, "Error : ", localIllegalArgumentException);
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          Log.w(ACRA.LOG_TAG, "Error : ", localIllegalAccessException);
        }
      }
    }
    label138:
    return localStringBuilder.toString();
  }
  
  private static boolean isAuthorized(Field paramField)
  {
    return (paramField != null) && (!paramField.getName().startsWith("WIFI_AP"));
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.collector.SettingsCollector
 * JD-Core Version:    0.7.0.1
 */