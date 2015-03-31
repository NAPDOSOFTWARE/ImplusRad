package com.google.appinventor.common.version;

public final class GitBuildId
{
  public static final String ACRA_URI = "${acra.uri}";
  public static final String ANT_BUILD_DATE = "February 11 2015";
  public static final String GIT_BUILD_FINGERPRINT = "b5329d0ad81f41b919db26ea5b7e79db303abe5d";
  public static final String GIT_BUILD_VERSION = "nb140";
  
  public static String getAcraUri()
  {
    if ("${acra.uri}".equals("${acra.uri}")) {
      return "";
    }
    return "${acra.uri}".trim();
  }
  
  public static String getDate()
  {
    return "February 11 2015";
  }
  
  public static String getFingerprint()
  {
    return "b5329d0ad81f41b919db26ea5b7e79db303abe5d";
  }
  
  public static String getVersion()
  {
    String str = "nb140";
    if ((str == "") || (str.contains(" "))) {
      str = "none";
    }
    return str;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.common.version.GitBuildId
 * JD-Core Version:    0.7.0.1
 */