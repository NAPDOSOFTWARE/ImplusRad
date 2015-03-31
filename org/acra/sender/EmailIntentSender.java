package org.acra.sender;

import android.content.Context;
import android.content.Intent;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.ReportField;
import org.acra.collector.CrashReportData;

public class EmailIntentSender
  implements ReportSender
{
  private final Context mContext;
  
  public EmailIntentSender(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private String buildBody(CrashReportData paramCrashReportData)
  {
    ReportField[] arrayOfReportField1 = ACRA.getConfig().customReportContent();
    if (arrayOfReportField1.length == 0) {
      arrayOfReportField1 = ACRA.DEFAULT_MAIL_REPORT_FIELDS;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    for (ReportField localReportField : arrayOfReportField1)
    {
      localStringBuilder.append(localReportField.toString()).append("=");
      localStringBuilder.append((String)paramCrashReportData.get(localReportField));
      localStringBuilder.append('\n');
    }
    return localStringBuilder.toString();
  }
  
  public void send(CrashReportData paramCrashReportData)
    throws ReportSenderException
  {
    String str1 = this.mContext.getPackageName() + " Crash Report";
    String str2 = buildBody(paramCrashReportData);
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.addFlags(268435456);
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.SUBJECT", str1);
    localIntent.putExtra("android.intent.extra.TEXT", str2);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ACRA.getConfig().mailTo();
    localIntent.putExtra("android.intent.extra.EMAIL", arrayOfString);
    this.mContext.startActivity(localIntent);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.sender.EmailIntentSender
 * JD-Core Version:    0.7.0.1
 */