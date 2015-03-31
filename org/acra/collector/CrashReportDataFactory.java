package org.acra.collector;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.format.Time;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.ReportField;
import org.acra.annotation.ReportsCrashes;
import org.acra.util.Installation;
import org.acra.util.PackageManagerWrapper;
import org.acra.util.ReportUtils;

public final class CrashReportDataFactory
{
  private final Time appStartDate;
  private final Context context;
  private final List<ReportField> crashReportFields;
  private final Map<String, String> customParameters = new HashMap();
  private final String initialConfiguration;
  private final SharedPreferences prefs;
  
  public CrashReportDataFactory(Context paramContext, SharedPreferences paramSharedPreferences, Time paramTime, String paramString)
  {
    this.context = paramContext;
    this.prefs = paramSharedPreferences;
    this.appStartDate = paramTime;
    this.initialConfiguration = paramString;
    ACRAConfiguration localACRAConfiguration = ACRA.getConfig();
    ReportField[] arrayOfReportField1 = localACRAConfiguration.customReportContent();
    ReportField[] arrayOfReportField2;
    if (arrayOfReportField1.length != 0)
    {
      Log.d(ACRA.LOG_TAG, "Using custom Report Fields");
      arrayOfReportField2 = arrayOfReportField1;
    }
    for (;;)
    {
      this.crashReportFields = Arrays.asList(arrayOfReportField2);
      return;
      if ((localACRAConfiguration.mailTo() == null) || ("".equals(localACRAConfiguration.mailTo())))
      {
        Log.d(ACRA.LOG_TAG, "Using default Report Fields");
        arrayOfReportField2 = ACRA.DEFAULT_REPORT_FIELDS;
      }
      else
      {
        Log.d(ACRA.LOG_TAG, "Using default Mail Report Fields");
        arrayOfReportField2 = ACRA.DEFAULT_MAIL_REPORT_FIELDS;
      }
    }
  }
  
  private String createCustomInfoString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.customParameters.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)this.customParameters.get(str1);
      localStringBuilder.append(str1);
      localStringBuilder.append(" = ");
      localStringBuilder.append(str2);
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }
  
  private String getStackTrace(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    for (Throwable localThrowable = paramThrowable; localThrowable != null; localThrowable = localThrowable.getCause()) {
      localThrowable.printStackTrace(localPrintWriter);
    }
    String str = localStringWriter.toString();
    localPrintWriter.close();
    return str;
  }
  
  public CrashReportData createCrashData(Throwable paramThrowable, boolean paramBoolean, Thread paramThread)
  {
    CrashReportData localCrashReportData = new CrashReportData();
    for (;;)
    {
      String str2;
      try
      {
        localCrashReportData.put(ReportField.STACK_TRACE, getStackTrace(paramThrowable));
        localCrashReportData.put(ReportField.USER_APP_START_DATE, this.appStartDate.format3339(false));
        if (paramBoolean) {
          localCrashReportData.put(ReportField.IS_SILENT, "true");
        }
        if (this.crashReportFields.contains(ReportField.REPORT_ID)) {
          localCrashReportData.put(ReportField.REPORT_ID, UUID.randomUUID().toString());
        }
        if (this.crashReportFields.contains(ReportField.INSTALLATION_ID)) {
          localCrashReportData.put(ReportField.INSTALLATION_ID, Installation.id(this.context));
        }
        if (this.crashReportFields.contains(ReportField.INITIAL_CONFIGURATION)) {
          localCrashReportData.put(ReportField.INITIAL_CONFIGURATION, this.initialConfiguration);
        }
        if (this.crashReportFields.contains(ReportField.CRASH_CONFIGURATION)) {
          localCrashReportData.put(ReportField.CRASH_CONFIGURATION, ConfigurationCollector.collectConfiguration(this.context));
        }
        if ((!(paramThrowable instanceof OutOfMemoryError)) && (this.crashReportFields.contains(ReportField.DUMPSYS_MEMINFO))) {
          localCrashReportData.put(ReportField.DUMPSYS_MEMINFO, DumpSysCollector.collectMemInfo());
        }
        if (this.crashReportFields.contains(ReportField.PACKAGE_NAME)) {
          localCrashReportData.put(ReportField.PACKAGE_NAME, this.context.getPackageName());
        }
        if (this.crashReportFields.contains(ReportField.BUILD)) {
          localCrashReportData.put(ReportField.BUILD, ReflectionCollector.collectConstants(Build.class));
        }
        if (this.crashReportFields.contains(ReportField.PHONE_MODEL)) {
          localCrashReportData.put(ReportField.PHONE_MODEL, Build.MODEL);
        }
        if (this.crashReportFields.contains(ReportField.ANDROID_VERSION)) {
          localCrashReportData.put(ReportField.ANDROID_VERSION, Build.VERSION.RELEASE);
        }
        if (this.crashReportFields.contains(ReportField.BRAND)) {
          localCrashReportData.put(ReportField.BRAND, Build.BRAND);
        }
        if (this.crashReportFields.contains(ReportField.PRODUCT)) {
          localCrashReportData.put(ReportField.PRODUCT, Build.PRODUCT);
        }
        if (this.crashReportFields.contains(ReportField.TOTAL_MEM_SIZE)) {
          localCrashReportData.put(ReportField.TOTAL_MEM_SIZE, Long.toString(ReportUtils.getTotalInternalMemorySize()));
        }
        if (this.crashReportFields.contains(ReportField.AVAILABLE_MEM_SIZE)) {
          localCrashReportData.put(ReportField.AVAILABLE_MEM_SIZE, Long.toString(ReportUtils.getAvailableInternalMemorySize()));
        }
        if (this.crashReportFields.contains(ReportField.FILE_PATH)) {
          localCrashReportData.put(ReportField.FILE_PATH, ReportUtils.getApplicationFilePath(this.context));
        }
        if (this.crashReportFields.contains(ReportField.DISPLAY)) {
          localCrashReportData.put(ReportField.DISPLAY, ReportUtils.getDisplayDetails(this.context));
        }
        if (this.crashReportFields.contains(ReportField.USER_CRASH_DATE))
        {
          Time localTime = new Time();
          localTime.setToNow();
          localCrashReportData.put(ReportField.USER_CRASH_DATE, localTime.format3339(false));
        }
        if (this.crashReportFields.contains(ReportField.CUSTOM_DATA)) {
          localCrashReportData.put(ReportField.CUSTOM_DATA, createCustomInfoString());
        }
        if (this.crashReportFields.contains(ReportField.USER_EMAIL)) {
          localCrashReportData.put(ReportField.USER_EMAIL, this.prefs.getString("acra.user.email", "N/A"));
        }
        if (this.crashReportFields.contains(ReportField.DEVICE_FEATURES)) {
          localCrashReportData.put(ReportField.DEVICE_FEATURES, DeviceFeaturesCollector.getFeatures(this.context));
        }
        if (this.crashReportFields.contains(ReportField.ENVIRONMENT)) {
          localCrashReportData.put(ReportField.ENVIRONMENT, ReflectionCollector.collectStaticGettersResults(Environment.class));
        }
        if (this.crashReportFields.contains(ReportField.SETTINGS_SYSTEM)) {
          localCrashReportData.put(ReportField.SETTINGS_SYSTEM, SettingsCollector.collectSystemSettings(this.context));
        }
        if (this.crashReportFields.contains(ReportField.SETTINGS_SECURE)) {
          localCrashReportData.put(ReportField.SETTINGS_SECURE, SettingsCollector.collectSecureSettings(this.context));
        }
        if (this.crashReportFields.contains(ReportField.SHARED_PREFERENCES)) {
          localCrashReportData.put(ReportField.SHARED_PREFERENCES, SharedPreferencesCollector.collect(this.context));
        }
        PackageManagerWrapper localPackageManagerWrapper = new PackageManagerWrapper(this.context);
        PackageInfo localPackageInfo = localPackageManagerWrapper.getPackageInfo();
        if (localPackageInfo == null) {
          continue;
        }
        if (this.crashReportFields.contains(ReportField.APP_VERSION_CODE)) {
          localCrashReportData.put(ReportField.APP_VERSION_CODE, Integer.toString(localPackageInfo.versionCode));
        }
        if (this.crashReportFields.contains(ReportField.APP_VERSION_NAME))
        {
          ReportField localReportField = ReportField.APP_VERSION_NAME;
          if (localPackageInfo.versionName == null) {
            break label1339;
          }
          str2 = localPackageInfo.versionName;
          localCrashReportData.put(localReportField, str2);
        }
        if ((this.crashReportFields.contains(ReportField.DEVICE_ID)) && (this.prefs.getBoolean("acra.deviceid.enable", true)) && (localPackageManagerWrapper.hasPermission("android.permission.READ_PHONE_STATE")))
        {
          String str1 = ReportUtils.getDeviceId(this.context);
          if (str1 != null) {
            localCrashReportData.put(ReportField.DEVICE_ID, str1);
          }
        }
        if (((!this.prefs.getBoolean("acra.syslog.enable", true)) || (!localPackageManagerWrapper.hasPermission("android.permission.READ_LOGS"))) && (Compatibility.getAPILevel() < 16)) {
          continue;
        }
        Log.i(ACRA.LOG_TAG, "READ_LOGS granted! ACRA can include LogCat and DropBox data.");
        if (this.crashReportFields.contains(ReportField.LOGCAT)) {
          localCrashReportData.put(ReportField.LOGCAT, LogCatCollector.collectLogCat(null));
        }
        if (this.crashReportFields.contains(ReportField.EVENTSLOG)) {
          localCrashReportData.put(ReportField.EVENTSLOG, LogCatCollector.collectLogCat("events"));
        }
        if (this.crashReportFields.contains(ReportField.RADIOLOG)) {
          localCrashReportData.put(ReportField.RADIOLOG, LogCatCollector.collectLogCat("radio"));
        }
        if (this.crashReportFields.contains(ReportField.DROPBOX)) {
          localCrashReportData.put(ReportField.DROPBOX, DropBoxCollector.read(this.context, ACRA.getConfig().additionalDropBoxTags()));
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        Log.e(ACRA.LOG_TAG, "Error while retrieving crash data", localRuntimeException);
        return localCrashReportData;
        Log.i(ACRA.LOG_TAG, "READ_LOGS not allowed. ACRA will not include LogCat and DropBox data.");
        continue;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Log.e(ACRA.LOG_TAG, "Error : application log file " + ACRA.getConfig().applicationLogFile() + " not found.", localFileNotFoundException);
        return localCrashReportData;
      }
      catch (IOException localIOException)
      {
        Log.e(ACRA.LOG_TAG, "Error while reading application log file " + ACRA.getConfig().applicationLogFile() + ".", localIOException);
      }
      if (this.crashReportFields.contains(ReportField.APPLICATION_LOG)) {
        localCrashReportData.put(ReportField.APPLICATION_LOG, LogFileCollector.collectLogFile(this.context, ACRA.getConfig().applicationLogFile(), ACRA.getConfig().applicationLogFileLines()));
      }
      if (this.crashReportFields.contains(ReportField.MEDIA_CODEC_LIST)) {
        localCrashReportData.put(ReportField.MEDIA_CODEC_LIST, MediaCodecListCollector.collecMediaCodecList());
      }
      if (this.crashReportFields.contains(ReportField.THREAD_DETAILS))
      {
        localCrashReportData.put(ReportField.THREAD_DETAILS, ThreadCollector.collect(paramThread));
        return localCrashReportData;
        localCrashReportData.put(ReportField.APP_VERSION_NAME, "Package info unavailable");
      }
      else
      {
        return localCrashReportData;
        label1339:
        str2 = "not set";
      }
    }
  }
  
  public String getCustomData(String paramString)
  {
    return (String)this.customParameters.get(paramString);
  }
  
  public String putCustomData(String paramString1, String paramString2)
  {
    return (String)this.customParameters.put(paramString1, paramString2);
  }
  
  public String removeCustomData(String paramString)
  {
    return (String)this.customParameters.remove(paramString);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.collector.CrashReportDataFactory
 * JD-Core Version:    0.7.0.1
 */