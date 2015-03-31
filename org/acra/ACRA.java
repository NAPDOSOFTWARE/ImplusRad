package org.acra;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.preference.PreferenceManager;
import org.acra.annotation.ReportsCrashes;
import org.acra.log.ACRALog;
import org.acra.log.AndroidLogDelegate;

public class ACRA
{
  public static final ReportField[] DEFAULT_MAIL_REPORT_FIELDS;
  public static final ReportField[] DEFAULT_REPORT_FIELDS;
  public static final boolean DEV_LOGGING = false;
  public static final String LOG_TAG = ACRA.class.getSimpleName();
  public static final String PREF_ALWAYS_ACCEPT = "acra.alwaysaccept";
  public static final String PREF_DISABLE_ACRA = "acra.disable";
  public static final String PREF_ENABLE_ACRA = "acra.enable";
  public static final String PREF_ENABLE_DEVICE_ID = "acra.deviceid.enable";
  public static final String PREF_ENABLE_SYSTEM_LOGS = "acra.syslog.enable";
  public static final String PREF_LAST_VERSION_NR = "acra.lastVersionNr";
  public static final String PREF_USER_EMAIL_ADDRESS = "acra.user.email";
  private static ACRAConfiguration configProxy;
  private static ErrorReporter errorReporterSingleton;
  public static ACRALog log = new AndroidLogDelegate();
  private static Application mApplication;
  private static SharedPreferences.OnSharedPreferenceChangeListener mPrefListener;
  private static ReportsCrashes mReportsCrashes;
  
  static
  {
    ReportField[] arrayOfReportField1 = new ReportField[7];
    arrayOfReportField1[0] = ReportField.USER_COMMENT;
    arrayOfReportField1[1] = ReportField.ANDROID_VERSION;
    arrayOfReportField1[2] = ReportField.APP_VERSION_NAME;
    arrayOfReportField1[3] = ReportField.BRAND;
    arrayOfReportField1[4] = ReportField.PHONE_MODEL;
    arrayOfReportField1[5] = ReportField.CUSTOM_DATA;
    arrayOfReportField1[6] = ReportField.STACK_TRACE;
    DEFAULT_MAIL_REPORT_FIELDS = arrayOfReportField1;
    ReportField[] arrayOfReportField2 = new ReportField[30];
    arrayOfReportField2[0] = ReportField.REPORT_ID;
    arrayOfReportField2[1] = ReportField.APP_VERSION_CODE;
    arrayOfReportField2[2] = ReportField.APP_VERSION_NAME;
    arrayOfReportField2[3] = ReportField.PACKAGE_NAME;
    arrayOfReportField2[4] = ReportField.FILE_PATH;
    arrayOfReportField2[5] = ReportField.PHONE_MODEL;
    arrayOfReportField2[6] = ReportField.BRAND;
    arrayOfReportField2[7] = ReportField.PRODUCT;
    arrayOfReportField2[8] = ReportField.ANDROID_VERSION;
    arrayOfReportField2[9] = ReportField.BUILD;
    arrayOfReportField2[10] = ReportField.TOTAL_MEM_SIZE;
    arrayOfReportField2[11] = ReportField.AVAILABLE_MEM_SIZE;
    arrayOfReportField2[12] = ReportField.CUSTOM_DATA;
    arrayOfReportField2[13] = ReportField.IS_SILENT;
    arrayOfReportField2[14] = ReportField.STACK_TRACE;
    arrayOfReportField2[15] = ReportField.INITIAL_CONFIGURATION;
    arrayOfReportField2[16] = ReportField.CRASH_CONFIGURATION;
    arrayOfReportField2[17] = ReportField.DISPLAY;
    arrayOfReportField2[18] = ReportField.USER_COMMENT;
    arrayOfReportField2[19] = ReportField.USER_EMAIL;
    arrayOfReportField2[20] = ReportField.USER_APP_START_DATE;
    arrayOfReportField2[21] = ReportField.USER_CRASH_DATE;
    arrayOfReportField2[22] = ReportField.DUMPSYS_MEMINFO;
    arrayOfReportField2[23] = ReportField.LOGCAT;
    arrayOfReportField2[24] = ReportField.INSTALLATION_ID;
    arrayOfReportField2[25] = ReportField.DEVICE_FEATURES;
    arrayOfReportField2[26] = ReportField.ENVIRONMENT;
    arrayOfReportField2[27] = ReportField.SHARED_PREFERENCES;
    arrayOfReportField2[28] = ReportField.SETTINGS_SYSTEM;
    arrayOfReportField2[29] = ReportField.SETTINGS_SECURE;
    DEFAULT_REPORT_FIELDS = arrayOfReportField2;
  }
  
  static void checkCrashResources()
    throws ACRAConfigurationException
  {
    ACRAConfiguration localACRAConfiguration = getConfig();
    switch (2.$SwitchMap$org$acra$ReportingInteractionMode[localACRAConfiguration.mode().ordinal()])
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (localACRAConfiguration.resToastText() != 0);
        throw new ACRAConfigurationException("TOAST mode: you have to define the resToastText parameter in your application @ReportsCrashes() annotation.");
      } while ((localACRAConfiguration.resNotifTickerText() != 0) && (localACRAConfiguration.resNotifTitle() != 0) && (localACRAConfiguration.resNotifText() != 0) && (localACRAConfiguration.resDialogText() != 0));
      throw new ACRAConfigurationException("NOTIFICATION mode: you have to define at least the resNotifTickerText, resNotifTitle, resNotifText, resDialogText parameters in your application @ReportsCrashes() annotation.");
    } while (localACRAConfiguration.resDialogText() != 0);
    throw new ACRAConfigurationException("DIALOG mode: you have to define at least the resDialogText parameters in your application @ReportsCrashes() annotation.");
  }
  
  public static SharedPreferences getACRASharedPreferences()
  {
    ACRAConfiguration localACRAConfiguration = getConfig();
    if (!"".equals(localACRAConfiguration.sharedPreferencesName())) {
      return mApplication.getSharedPreferences(localACRAConfiguration.sharedPreferencesName(), localACRAConfiguration.sharedPreferencesMode());
    }
    return PreferenceManager.getDefaultSharedPreferences(mApplication);
  }
  
  static Application getApplication()
  {
    return mApplication;
  }
  
  public static ACRAConfiguration getConfig()
  {
    if (configProxy == null)
    {
      if (mApplication == null) {
        log.w(LOG_TAG, "Calling ACRA.getConfig() before ACRA.init() gives you an empty configuration instance. You might prefer calling ACRA.getNewDefaultConfig(Application) to get an instance with default values taken from a @ReportsCrashes annotation.");
      }
      configProxy = getNewDefaultConfig(mApplication);
    }
    return configProxy;
  }
  
  public static ErrorReporter getErrorReporter()
  {
    if (errorReporterSingleton == null) {
      throw new IllegalStateException("Cannot access ErrorReporter before ACRA#init");
    }
    return errorReporterSingleton;
  }
  
  public static ACRAConfiguration getNewDefaultConfig(Application paramApplication)
  {
    if (paramApplication != null) {
      return new ACRAConfiguration((ReportsCrashes)paramApplication.getClass().getAnnotation(ReportsCrashes.class));
    }
    return new ACRAConfiguration(null);
  }
  
  public static void init(Application paramApplication)
  {
    if (mApplication != null) {
      throw new IllegalStateException("ACRA#init called more than once");
    }
    mApplication = paramApplication;
    mReportsCrashes = (ReportsCrashes)mApplication.getClass().getAnnotation(ReportsCrashes.class);
    if (mReportsCrashes == null)
    {
      log.e(LOG_TAG, "ACRA#init called but no ReportsCrashes annotation on Application " + mApplication.getPackageName());
      return;
    }
    SharedPreferences localSharedPreferences = getACRASharedPreferences();
    for (;;)
    {
      try
      {
        checkCrashResources();
        log.d(LOG_TAG, "ACRA is enabled for " + mApplication.getPackageName() + ", intializing...");
        if (shouldDisableACRA(localSharedPreferences)) {
          continue;
        }
        bool = true;
        ErrorReporter localErrorReporter = new ErrorReporter(mApplication.getApplicationContext(), localSharedPreferences, bool);
        localErrorReporter.setDefaultReportSenders();
        errorReporterSingleton = localErrorReporter;
      }
      catch (ACRAConfigurationException localACRAConfigurationException)
      {
        boolean bool;
        log.w(LOG_TAG, "Error : ", localACRAConfigurationException);
        continue;
      }
      mPrefListener = new SharedPreferences.OnSharedPreferenceChangeListener()
      {
        public void onSharedPreferenceChanged(SharedPreferences paramAnonymousSharedPreferences, String paramAnonymousString)
        {
          if (("acra.disable".equals(paramAnonymousString)) || ("acra.enable".equals(paramAnonymousString))) {
            if (ACRA.shouldDisableACRA(paramAnonymousSharedPreferences)) {
              break label35;
            }
          }
          label35:
          for (boolean bool = true;; bool = false)
          {
            ACRA.getErrorReporter().setEnabled(bool);
            return;
          }
        }
      };
      localSharedPreferences.registerOnSharedPreferenceChangeListener(mPrefListener);
      return;
      bool = false;
    }
  }
  
  static boolean isDebuggable()
  {
    PackageManager localPackageManager = mApplication.getPackageManager();
    try
    {
      int i = localPackageManager.getApplicationInfo(mApplication.getPackageName(), 0).flags;
      int j = i & 0x2;
      boolean bool = false;
      if (j > 0) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  public static void setConfig(ACRAConfiguration paramACRAConfiguration)
  {
    configProxy = paramACRAConfiguration;
  }
  
  public static void setLog(ACRALog paramACRALog)
  {
    log = paramACRALog;
  }
  
  private static boolean shouldDisableACRA(SharedPreferences paramSharedPreferences)
  {
    boolean bool1 = true;
    try
    {
      if (!paramSharedPreferences.getBoolean("acra.enable", true)) {}
      for (;;)
      {
        boolean bool2 = paramSharedPreferences.getBoolean("acra.disable", bool1);
        return bool2;
        bool1 = false;
      }
      return false;
    }
    catch (Exception localException) {}
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.ACRA
 * JD-Core Version:    0.7.0.1
 */