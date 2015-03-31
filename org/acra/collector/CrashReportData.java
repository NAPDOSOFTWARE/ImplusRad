package org.acra.collector;

import java.util.EnumMap;
import org.acra.ReportField;

public final class CrashReportData
  extends EnumMap<ReportField, String>
{
  private static final long serialVersionUID = 4112578634029874840L;
  
  public CrashReportData()
  {
    super(ReportField.class);
  }
  
  public String getProperty(ReportField paramReportField)
  {
    return (String)super.get(paramReportField);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.collector.CrashReportData
 * JD-Core Version:    0.7.0.1
 */