package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.AppInvHTTPD;
import com.google.appinventor.components.runtime.util.PackageInstaller;
import java.security.MessageDigest;
import java.util.Formatter;

@DesignerComponent(category=ComponentCategory.INTERNAL, description="Component that returns information about the phone.", iconName="images/phoneip.png", nonVisible=true, version=1)
@SimpleObject
public class PhoneStatus
  extends AndroidNonvisibleComponent
  implements Component
{
  private static final String LOG_TAG = "PhoneStatus";
  private static Activity activity;
  private static PhoneStatus mainInstance = null;
  private final Form form;
  
  public PhoneStatus(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.form = paramComponentContainer.$form();
    activity = paramComponentContainer.$context();
    if (mainInstance == null) {
      mainInstance = this;
    }
  }
  
  @SimpleFunction(description="Returns the IP address of the phone in the form of a String")
  public static String GetWifiIpAddress()
  {
    int i = ((WifiManager)activity.getSystemService("wifi")).getDhcpInfo().ipAddress;
    if (isConnected()) {
      return intToIp(i);
    }
    return "Error: No Wifi Connection";
  }
  
  @SimpleFunction(description="Causes an Exception, used to debug exception processing.")
  public static void doFault()
    throws Exception
  {
    throw new Exception("doFault called!");
  }
  
  static void doSettings()
  {
    Log.d("PhoneStatus", "doSettings called.");
    if (mainInstance != null)
    {
      mainInstance.OnSettings();
      return;
    }
    Log.d("PhoneStatus", "mainStance is null on doSettings");
  }
  
  public static String intToIp(int paramInt)
  {
    return (paramInt & 0xFF) + "." + (0xFF & paramInt >> 8) + "." + (0xFF & paramInt >> 16) + "." + (0xFF & paramInt >> 24);
  }
  
  @SimpleFunction(description="Returns TRUE if the phone is on Wifi, FALSE otherwise")
  public static boolean isConnected()
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)activity.getSystemService("connectivity");
    NetworkInfo localNetworkInfo = null;
    if (localConnectivityManager != null) {
      localNetworkInfo = localConnectivityManager.getNetworkInfo(1);
    }
    if (localNetworkInfo == null) {
      return false;
    }
    return localNetworkInfo.isConnected();
  }
  
  @SimpleEvent
  public void OnSettings()
  {
    EventDispatcher.dispatchEvent(this, "OnSettings", new Object[0]);
  }
  
  @SimpleFunction(description="Obtain the Android Application Version")
  public String getVersionName()
  {
    try
    {
      String str = this.form.getPackageManager().getPackageInfo(this.form.getPackageName(), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("PhoneStatus", "Exception fetching package name.", localNameNotFoundException);
    }
    return "";
  }
  
  @SimpleFunction(description="Downloads the URL and installs it as an Android Package")
  public void installURL(String paramString)
  {
    PackageInstaller.doPackageInstall(this.form, paramString);
  }
  
  @SimpleFunction(description="Returns true if we are running in the emulator or USB Connection")
  public boolean isDirect()
  {
    Log.d("PhoneStatus", "android.os.Build.VERSION.RELEASE = " + Build.VERSION.RELEASE);
    Log.d("PhoneStatus", "android.os.Build.PRODUCT = " + Build.PRODUCT);
    if (Build.PRODUCT.contains("google_sdk")) {
      return true;
    }
    if ((this.form instanceof ReplForm)) {
      return ((ReplForm)this.form).isDirect();
    }
    return false;
  }
  
  @SimpleFunction(description="Declare that we have loaded our initial assets and other assets should come from the sdcard")
  public void setAssetsLoaded()
  {
    if ((this.form instanceof ReplForm)) {
      ((ReplForm)this.form).setAssetsLoaded();
    }
  }
  
  @SimpleFunction(description="Establish the secret seed for HOTP generation. Return the SHA1 of the provided seed, this will be used to contact the rendezvous server.")
  public String setHmacSeedReturnCode(String paramString)
  {
    AppInvHTTPD.setHmacKey(paramString);
    StringBuffer localStringBuffer;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      localMessageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = localMessageDigest.digest();
      localStringBuffer = new StringBuffer(2 * arrayOfByte.length);
      Formatter localFormatter = new Formatter(localStringBuffer);
      int i = arrayOfByte.length;
      for (int j = 0; j < i; j++)
      {
        byte b = arrayOfByte[j];
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Byte.valueOf(b);
        localFormatter.format("%02x", arrayOfObject);
      }
      Log.d("PhoneStatus", "Seed = " + paramString);
    }
    catch (Exception localException)
    {
      Log.e("PhoneStatus", "Exception getting SHA1 Instance", localException);
      return "";
    }
    Log.d("PhoneStatus", "Code = " + localStringBuffer.toString());
    return localStringBuffer.toString();
  }
  
  @SimpleFunction(description="Really Exit the Application")
  public void shutdown()
  {
    this.form.finish();
    System.exit(0);
  }
  
  @SimpleFunction(description="Start the internal AppInvHTTPD to listen for incoming forms. FOR REPL USE ONLY!")
  public void startHTTPD(boolean paramBoolean)
  {
    ReplForm.topform.startHTTPD(paramBoolean);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.PhoneStatus
 * JD-Core Version:    0.7.0.1
 */