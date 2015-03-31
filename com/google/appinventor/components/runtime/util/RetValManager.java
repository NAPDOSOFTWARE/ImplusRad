package com.google.appinventor.components.runtime.util;

import android.util.Log;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RetValManager
{
  private static final String LOG_TAG = "RetValManager";
  private static final long TENSECONDS = 10000L;
  private static ArrayList<JSONObject> currentArray = new ArrayList(10);
  private static final Object semaphore = new Object();
  
  public static void appendReturnValue(String paramString1, String paramString2, String paramString3)
  {
    synchronized (semaphore)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("status", paramString2);
        localJSONObject.put("type", "return");
        localJSONObject.put("value", paramString3);
        localJSONObject.put("blockid", paramString1);
        boolean bool = currentArray.isEmpty();
        currentArray.add(localJSONObject);
        if (bool) {
          semaphore.notifyAll();
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e("RetValManager", "Error building retval", localJSONException);
        return;
      }
    }
  }
  
  public static String fetch(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    synchronized (semaphore)
    {
      for (;;)
      {
        JSONArray localJSONArray;
        JSONObject localJSONObject;
        if ((!currentArray.isEmpty()) || (!paramBoolean) || (System.currentTimeMillis() - l > 9900L))
        {
          localJSONArray = new JSONArray(currentArray);
          localJSONObject = new JSONObject();
        }
        for (;;)
        {
          try
          {
            localJSONObject.put("status", "OK");
            localJSONObject.put("values", localJSONArray);
            currentArray.clear();
            String str = localJSONObject.toString();
            return str;
          }
          catch (JSONException localJSONException)
          {
            Log.e("RetValManager", "Error fetching retvals", localJSONException);
            return "{\"status\" : \"BAD\", \"message\" : \"Failure in RetValManager\"}";
          }
          try
          {
            semaphore.wait(10000L);
          }
          catch (InterruptedException localInterruptedException) {}
        }
      }
    }
  }
  
  public static void popScreen(String paramString)
  {
    synchronized (semaphore)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("status", "OK");
        localJSONObject.put("type", "popScreen");
        if (paramString != null) {
          localJSONObject.put("value", paramString.toString());
        }
        boolean bool = currentArray.isEmpty();
        currentArray.add(localJSONObject);
        if (bool) {
          semaphore.notifyAll();
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e("RetValManager", "Error building retval", localJSONException);
        return;
      }
    }
  }
  
  public static void pushScreen(String paramString, Object paramObject)
  {
    synchronized (semaphore)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("status", "OK");
        localJSONObject.put("type", "pushScreen");
        localJSONObject.put("screen", paramString);
        if (paramObject != null) {
          localJSONObject.put("value", paramObject.toString());
        }
        boolean bool = currentArray.isEmpty();
        currentArray.add(localJSONObject);
        if (bool) {
          semaphore.notifyAll();
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e("RetValManager", "Error building retval", localJSONException);
        return;
      }
    }
  }
  
  public static void sendError(String paramString)
  {
    synchronized (semaphore)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("status", "OK");
        localJSONObject.put("type", "error");
        localJSONObject.put("value", paramString);
        boolean bool = currentArray.isEmpty();
        currentArray.add(localJSONObject);
        if (bool) {
          semaphore.notifyAll();
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e("RetValManager", "Error building retval", localJSONException);
        return;
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.RetValManager
 * JD-Core Version:    0.7.0.1
 */