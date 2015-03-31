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

public class HttpPostSender
  implements ReportSender
{
  private final Uri mFormUri;
  private final Map<ReportField, String> mMapping;
  
  public HttpPostSender(String paramString, Map<ReportField, String> paramMap)
  {
    this.mFormUri = Uri.parse(paramString);
    this.mMapping = paramMap;
  }
  
  public HttpPostSender(Map<ReportField, String> paramMap)
  {
    this.mFormUri = null;
    this.mMapping = paramMap;
  }
  
  private static boolean isNull(String paramString)
  {
    return (paramString == null) || ("ACRA-NULL-STRING".equals(paramString));
  }
  
  private Map<String, String> remap(Map<ReportField, String> paramMap)
  {
    ReportField[] arrayOfReportField1 = ACRA.getConfig().customReportContent();
    if (arrayOfReportField1.length == 0) {
      arrayOfReportField1 = ACRA.DEFAULT_REPORT_FIELDS;
    }
    HashMap localHashMap = new HashMap(paramMap.size());
    ReportField[] arrayOfReportField2 = arrayOfReportField1;
    int i = arrayOfReportField2.length;
    int j = 0;
    if (j < i)
    {
      ReportField localReportField = arrayOfReportField2[j];
      if ((this.mMapping == null) || (this.mMapping.get(localReportField) == null)) {
        localHashMap.put(localReportField.toString(), paramMap.get(localReportField));
      }
      for (;;)
      {
        j++;
        break;
        localHashMap.put(this.mMapping.get(localReportField), paramMap.get(localReportField));
      }
    }
    return localHashMap;
  }
  
  public void send(CrashReportData paramCrashReportData)
    throws ReportSenderException
  {
    for (;;)
    {
      try
      {
        Map localMap = remap(paramCrashReportData);
        URL localURL;
        if (this.mFormUri == null)
        {
          localURL = new URL(ACRA.getConfig().formUri());
          Log.d(ACRA.LOG_TAG, "Connect to " + localURL.toString());
          if (isNull(ACRA.getConfig().formUriBasicAuthLogin()))
          {
            str1 = null;
            boolean bool = isNull(ACRA.getConfig().formUriBasicAuthPassword());
            localObject = null;
            if (!bool) {
              break label199;
            }
            HttpRequest localHttpRequest = new HttpRequest();
            localHttpRequest.setConnectionTimeOut(ACRA.getConfig().connectionTimeout());
            localHttpRequest.setSocketTimeOut(ACRA.getConfig().socketTimeout());
            localHttpRequest.setMaxNrRetries(ACRA.getConfig().maxNumberOfRequestRetries());
            localHttpRequest.setLogin(str1);
            localHttpRequest.setPassword((String)localObject);
            localHttpRequest.sendPost(localURL, localMap);
          }
        }
        else
        {
          localURL = new URL(this.mFormUri.toString());
          continue;
        }
        String str1 = ACRA.getConfig().formUriBasicAuthLogin();
      }
      catch (IOException localIOException)
      {
        throw new ReportSenderException("Error while sending report to Http Post Form.", localIOException);
      }
      continue;
      label199:
      String str2 = ACRA.getConfig().formUriBasicAuthPassword();
      Object localObject = str2;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.sender.HttpPostSender
 * JD-Core Version:    0.7.0.1
 */