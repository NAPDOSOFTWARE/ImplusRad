package org.acra;

final class CrashReportFileNameParser
{
  public boolean isApproved(String paramString)
  {
    return (isSilent(paramString)) || (paramString.contains("-approved"));
  }
  
  public boolean isSilent(String paramString)
  {
    return paramString.contains(ACRAConstants.SILENT_SUFFIX);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.CrashReportFileNameParser
 * JD-Core Version:    0.7.0.1
 */