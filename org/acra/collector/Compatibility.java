package org.acra.collector;

import android.content.Context;
import android.os.Build.VERSION;
import java.lang.reflect.Field;

class Compatibility
{
  public static int getAPILevel()
  {
    try
    {
      int i = Build.VERSION.class.getField("SDK_INT").getInt(null);
      return i;
    }
    catch (SecurityException localSecurityException)
    {
      return Integer.parseInt(Build.VERSION.SDK);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      return Integer.parseInt(Build.VERSION.SDK);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      return Integer.parseInt(Build.VERSION.SDK);
    }
    catch (IllegalAccessException localIllegalAccessException) {}
    return Integer.parseInt(Build.VERSION.SDK);
  }
  
  public static String getDropBoxServiceName()
    throws NoSuchFieldException, IllegalAccessException
  {
    Field localField = Context.class.getField("DROPBOX_SERVICE");
    String str = null;
    if (localField != null) {
      str = (String)localField.get(null);
    }
    return str;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.collector.Compatibility
 * JD-Core Version:    0.7.0.1
 */