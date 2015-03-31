package org.acra.sender;

import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.ReportField;
import org.acra.collector.CrashReportData;
import org.acra.util.HttpRequest;

public class GoogleFormSender
  implements ReportSender
{
  private final Uri mFormUri;
  
  public GoogleFormSender()
  {
    this.mFormUri = null;
  }
  
  public GoogleFormSender(String paramString)
  {
    this.mFormUri = Uri.parse(String.format(ACRA.getConfig().googleFormUrlFormat(), new Object[] { paramString }));
  }
  
  private Map<String, String> remap(Map<ReportField, String> paramMap)
  {
    ReportField[] arrayOfReportField1 = ACRA.getConfig().customReportContent();
    if (arrayOfReportField1.length == 0) {
      arrayOfReportField1 = ACRA.DEFAULT_REPORT_FIELDS;
    }
    int i = 0;
    HashMap localHashMap = new HashMap();
    ReportField[] arrayOfReportField2 = arrayOfReportField1;
    int j = arrayOfReportField2.length;
    int k = 0;
    if (k < j)
    {
      ReportField localReportField = arrayOfReportField2[k];
      switch (1.$SwitchMap$org$acra$ReportField[localReportField.ordinal()])
      {
      default: 
        localHashMap.put("entry." + i + ".single", paramMap.get(localReportField));
      }
      for (;;)
      {
        i++;
        k++;
        break;
        localHashMap.put("entry." + i + ".single", "'" + (String)paramMap.get(localReportField));
        continue;
        localHashMap.put("entry." + i + ".single", "'" + (String)paramMap.get(localReportField));
      }
    }
    return localHashMap;
  }
  
  public void send(CrashReportData paramCrashReportData)
    throws ReportSenderException
  {
    String str;
    Object[] arrayOfObject;
    if (this.mFormUri == null)
    {
      str = ACRA.getConfig().googleFormUrlFormat();
      arrayOfObject = new Object[1];
      arrayOfObject[0] = ACRA.getConfig().formKey();
    }
    for (Uri localUri = Uri.parse(String.format(str, arrayOfObject));; localUri = this.mFormUri)
    {
      Map localMap = remap(paramCrashReportData);
      localMap.put("pageNumber", "0");
      localMap.put("backupCache", "");
      localMap.put("submit", "Envoyer");
      try
      {
        URL localURL = new URL(localUri.toString());
        Log.d(ACRA.LOG_TAG, "Sending report " + (String)paramCrashReportData.get(ReportField.REPORT_ID));
        Log.d(ACRA.LOG_TAG, "Connect to " + localURL);
        HttpRequest localHttpRequest = new HttpRequest();
        localHttpRequest.setConnectionTimeOut(ACRA.getConfig().connectionTimeout());
        localHttpRequest.setSocketTimeOut(ACRA.getConfig().socketTimeout());
        localHttpRequest.setMaxNrRetries(ACRA.getConfig().maxNumberOfRequestRetries());
        localHttpRequest.sendPost(localURL, localMap);
        return;
      }
      catch (IOException localIOException)
      {
        throw new ReportSenderException("Error while sending report to Google Form.", localIOException);
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.sender.GoogleFormSender
 * JD-Core Version:    0.7.0.1
 */