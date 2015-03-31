package com.google.appinventor.components.runtime.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.gsm.SmsMessage;
import android.util.Log;
import com.google.appinventor.components.runtime.ReplForm;
import com.google.appinventor.components.runtime.Texting;

public class SmsBroadcastReceiver
  extends BroadcastReceiver
{
  public static final int NOTIFICATION_ID = 8647;
  public static final String TAG = "SmsBroadcastReceiver";
  
  private String getMessage(Intent paramIntent)
  {
    String str = "";
    if (paramIntent.getAction().equals("com.google.android.apps.googlevoice.SMS_RECEIVED")) {
      str = paramIntent.getExtras().getString("com.google.android.apps.googlevoice.TEXT");
    }
    for (;;)
    {
      return str;
      Object[] arrayOfObject = (Object[])paramIntent.getExtras().get("pdus");
      int i = arrayOfObject.length;
      for (int j = 0; j < i; j++) {
        str = SmsMessage.createFromPdu((byte[])arrayOfObject[j]).getMessageBody();
      }
    }
  }
  
  private String getPhoneNumber(Intent paramIntent)
  {
    String str = "";
    if (paramIntent.getAction().equals("com.google.android.apps.googlevoice.SMS_RECEIVED")) {
      str = PhoneNumberUtils.formatNumber(paramIntent.getExtras().getString("com.google.android.apps.googlevoice.PHONE_NUMBER"));
    }
    for (;;)
    {
      return str;
      Object[] arrayOfObject = (Object[])paramIntent.getExtras().get("pdus");
      int i = arrayOfObject.length;
      for (int j = 0; j < i; j++) {
        str = PhoneNumberUtils.formatNumber(SmsMessage.createFromPdu((byte[])arrayOfObject[j]).getOriginatingAddress());
      }
    }
  }
  
  private boolean isRepl(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      boolean bool1 = Class.forName(str + ".Screen1").getSuperclass().equals(ReplForm.class);
      boolean bool2 = false;
      if (bool1) {
        bool2 = true;
      }
      return bool2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
    return false;
  }
  
  private void sendNotification(Context paramContext, String paramString1, String paramString2)
  {
    Log.i("SmsBroadcastReceiver", "sendingNotification " + paramString1 + ":" + paramString2);
    String str1 = paramContext.getPackageName();
    Log.i("SmsBroadcastReceiver", "Package name : " + str1);
    try
    {
      String str2 = str1 + ".Screen1";
      Intent localIntent = new Intent(paramContext, Class.forName(str2));
      NotificationManager localNotificationManager;
      Notification localNotification;
      PendingIntent localPendingIntent;
      localClassNotFoundException1.printStackTrace();
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      try
      {
        localIntent.setAction("android.intent.action.MAIN");
        localIntent.addCategory("android.intent.category.LAUNCHER");
        localIntent.addFlags(805306368);
        localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
        localNotification = new Notification(17301648, paramString1 + " : " + paramString2, System.currentTimeMillis());
        localNotification.flags = (0x10 | localNotification.flags);
        localNotification.defaults = (0x1 | localNotification.defaults);
        localPendingIntent = PendingIntent.getActivity(paramContext, 0, localIntent, 134217728);
        localNotification.setLatestEventInfo(paramContext, "Sms from " + paramString1, paramString2, localPendingIntent);
        localNotification.number = Texting.getCachedMsgCount();
        localNotificationManager.notify(null, 8647, localNotification);
        Log.i("SmsBroadcastReceiver", "Notification sent, classname: " + str2);
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        break label287;
      }
      localClassNotFoundException1 = localClassNotFoundException1;
    }
    label287:
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.i("SmsBroadcastReceiver", "onReceive");
    String str1 = getPhoneNumber(paramIntent);
    String str2 = getMessage(paramIntent);
    Log.i("SmsBroadcastReceiver", "Received " + str1 + " : " + str2);
    int i = Texting.isReceivingEnabled(paramContext);
    if (i == 1)
    {
      Log.i("SmsBroadcastReceiver", paramContext.getApplicationInfo().packageName + " Receiving is not enabled, ignoring message.");
      return;
    }
    if (((i == 2) || (isRepl(paramContext))) && (!Texting.isRunning()))
    {
      Log.i("SmsBroadcastReceiver", paramContext.getApplicationInfo().packageName + " Texting isn't running, and either receivingEnabled is FOREGROUND or we are the repl.");
      return;
    }
    Texting.handledReceivedMessage(paramContext, str1, str2);
    if (Texting.isRunning())
    {
      Log.i("SmsBroadcastReceiver", paramContext.getApplicationInfo().packageName + " App in Foreground, delivering message.");
      return;
    }
    Log.i("SmsBroadcastReceiver", paramContext.getApplicationInfo().packageName + " Texting isn't running, but receivingEnabled == 2, sending notification.");
    sendNotification(paramContext, str1, str2);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.SmsBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */