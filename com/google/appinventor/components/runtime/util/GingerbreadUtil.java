package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Parcelable;
import android.util.Log;
import com.google.appinventor.components.runtime.NearField;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.nio.charset.Charset;
import java.util.Locale;

public class GingerbreadUtil
{
  public static boolean clearCookies(CookieHandler paramCookieHandler)
  {
    if ((paramCookieHandler instanceof CookieManager))
    {
      CookieStore localCookieStore = ((CookieManager)paramCookieHandler).getCookieStore();
      if (localCookieStore != null)
      {
        localCookieStore.removeAll();
        return true;
      }
    }
    return false;
  }
  
  public static NdefRecord createTextRecord(String paramString, boolean paramBoolean)
  {
    byte[] arrayOfByte1 = Locale.getDefault().getLanguage().getBytes(Charset.forName("US-ASCII"));
    Charset localCharset;
    byte[] arrayOfByte2;
    if (paramBoolean)
    {
      localCharset = Charset.forName("UTF-8");
      arrayOfByte2 = paramString.getBytes(localCharset);
      if (!paramBoolean) {
        break label117;
      }
    }
    label117:
    for (int i = 0;; i = 128)
    {
      int j = (char)(i + arrayOfByte1.length);
      byte[] arrayOfByte3 = new byte[1 + arrayOfByte1.length + arrayOfByte2.length];
      arrayOfByte3[0] = ((byte)j);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 1, arrayOfByte1.length);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 1 + arrayOfByte1.length, arrayOfByte2.length);
      return new NdefRecord((short)1, NdefRecord.RTD_TEXT, new byte[0], arrayOfByte3);
      localCharset = Charset.forName("UTF-16");
      break;
    }
  }
  
  public static void disableNFCAdapter(Activity paramActivity, NfcAdapter paramNfcAdapter)
  {
    paramNfcAdapter.disableForegroundNdefPush(paramActivity);
  }
  
  public static void enableNFCWriteMode(Activity paramActivity, NfcAdapter paramNfcAdapter, String paramString)
  {
    paramNfcAdapter.enableForegroundNdefPush(paramActivity, new NdefMessage(new NdefRecord[] { createTextRecord(paramString, true) }));
  }
  
  public static CookieHandler newCookieManager()
  {
    return new CookieManager();
  }
  
  public static NfcAdapter newNfcAdapter(Context paramContext)
  {
    return NfcAdapter.getDefaultAdapter(paramContext);
  }
  
  public static void resolveNFCIntent(Intent paramIntent, NearField paramNearField)
  {
    if ("android.nfc.action.NDEF_DISCOVERED".equals(paramIntent.getAction()))
    {
      if (paramNearField.ReadMode())
      {
        Parcelable[] arrayOfParcelable = paramIntent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
        if (arrayOfParcelable != null)
        {
          arrayOfNdefMessage = new NdefMessage[arrayOfParcelable.length];
          for (int j = 0; j < arrayOfParcelable.length; j++) {
            arrayOfNdefMessage[j] = ((NdefMessage)arrayOfParcelable[j]);
          }
        }
        byte[] arrayOfByte = new byte[0];
        NdefMessage[] arrayOfNdefMessage = { new NdefMessage(new NdefRecord[] { new NdefRecord(5, arrayOfByte, arrayOfByte, arrayOfByte) }) };
        paramNearField.TagRead(new String(arrayOfNdefMessage[0].getRecords()[0].getPayload()).substring(3));
      }
      Tag localTag;
      NdefMessage localNdefMessage;
      do
      {
        return;
        localTag = (Tag)paramIntent.getParcelableExtra("android.nfc.extra.TAG");
        int i = paramNearField.WriteType();
        localNdefMessage = null;
        if (i == 1) {
          localNdefMessage = new NdefMessage(new NdefRecord[] { createTextRecord(paramNearField.TextToWrite(), true) });
        }
      } while (!writeNFCTag(localNdefMessage, localTag));
      paramNearField.TagWritten();
      return;
    }
    Log.e("nearfield", "Unknown intent " + paramIntent);
  }
  
  public static boolean writeNFCTag(NdefMessage paramNdefMessage, Tag paramTag)
  {
    int i = paramNdefMessage.toByteArray().length;
    try
    {
      Ndef localNdef = Ndef.get(paramTag);
      if (localNdef != null)
      {
        localNdef.connect();
        if (!localNdef.isWritable()) {
          return false;
        }
        if (localNdef.getMaxSize() >= i)
        {
          localNdef.writeNdefMessage(paramNdefMessage);
          return true;
        }
      }
      else
      {
        NdefFormatable localNdefFormatable = NdefFormatable.get(paramTag);
        if (localNdefFormatable != null) {
          try
          {
            localNdefFormatable.connect();
            localNdefFormatable.format(paramNdefMessage);
            return true;
          }
          catch (IOException localIOException)
          {
            return false;
          }
        }
      }
      return false;
    }
    catch (Exception localException) {}
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.GingerbreadUtil
 * JD-Core Version:    0.7.0.1
 */