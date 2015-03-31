package org.acra;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.os.Looper;
import android.os.Process;
import android.text.format.Time;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.acra.annotation.ReportsCrashes;
import org.acra.collector.ConfigurationCollector;
import org.acra.collector.CrashReportData;
import org.acra.collector.CrashReportDataFactory;
import org.acra.sender.EmailIntentSender;
import org.acra.sender.GoogleFormSender;
import org.acra.sender.HttpPostSender;
import org.acra.sender.ReportSender;
import org.acra.util.PackageManagerWrapper;
import org.acra.util.ToastSender;

public class ErrorReporter
  implements Thread.UncaughtExceptionHandler
{
  private static boolean toastWaitEnded = true;
  private Thread brokenThread;
  private final CrashReportDataFactory crashReportDataFactory;
  private boolean enabled = false;
  private final CrashReportFileNameParser fileNameParser = new CrashReportFileNameParser();
  private final Context mContext;
  private final Thread.UncaughtExceptionHandler mDfltExceptionHandler;
  private final List<ReportSender> mReportSenders = new ArrayList();
  private final SharedPreferences prefs;
  private Throwable unhandledThrowable;
  
  ErrorReporter(Context paramContext, SharedPreferences paramSharedPreferences, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.prefs = paramSharedPreferences;
    this.enabled = paramBoolean;
    String str = ConfigurationCollector.collectConfiguration(this.mContext);
    Time localTime = new Time();
    localTime.setToNow();
    this.crashReportDataFactory = new CrashReportDataFactory(this.mContext, paramSharedPreferences, localTime, str);
    this.mDfltExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
    checkReportsOnApplicationStart();
  }
  
  private boolean containsOnlySilentOrApprovedReports(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramArrayOfString[j];
      if (!this.fileNameParser.isApproved(str)) {
        return false;
      }
    }
    return true;
  }
  
  private void deletePendingReports(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    String[] arrayOfString = new CrashReportFinder(this.mContext).getCrashReportFiles();
    Arrays.sort(arrayOfString);
    if (arrayOfString != null) {
      for (int i = 0; i < arrayOfString.length - paramInt; i++)
      {
        String str = arrayOfString[i];
        boolean bool = this.fileNameParser.isApproved(str);
        if (((bool) && (paramBoolean1)) || ((!bool) && (paramBoolean2)))
        {
          File localFile = new File(this.mContext.getFilesDir(), str);
          if (!localFile.delete()) {
            Log.e(ACRA.LOG_TAG, "Could not delete report : " + localFile);
          }
        }
      }
    }
  }
  
  private void endApplication()
  {
    if ((ACRA.getConfig().mode() == ReportingInteractionMode.SILENT) || ((ACRA.getConfig().mode() == ReportingInteractionMode.TOAST) && (ACRA.getConfig().forceCloseDialogAfterToast())))
    {
      this.mDfltExceptionHandler.uncaughtException(this.brokenThread, this.unhandledThrowable);
      return;
    }
    Log.e(ACRA.LOG_TAG, this.mContext.getPackageName() + " fatal error : " + this.unhandledThrowable.getMessage(), this.unhandledThrowable);
    Process.killProcess(Process.myPid());
    System.exit(10);
  }
  
  public static ErrorReporter getInstance()
  {
    return ACRA.getErrorReporter();
  }
  
  private String getLatestNonSilentReport(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      for (int i = -1 + paramArrayOfString.length; i >= 0; i--) {
        if (!this.fileNameParser.isSilent(paramArrayOfString[i])) {
          return paramArrayOfString[i];
        }
      }
      return paramArrayOfString[(-1 + paramArrayOfString.length)];
    }
    return null;
  }
  
  private String getReportFileName(CrashReportData paramCrashReportData)
  {
    Time localTime = new Time();
    localTime.setToNow();
    long l = localTime.toMillis(false);
    String str1 = paramCrashReportData.getProperty(ReportField.IS_SILENT);
    StringBuilder localStringBuilder = new StringBuilder().append("").append(l);
    if (str1 != null) {}
    for (String str2 = ACRAConstants.SILENT_SUFFIX;; str2 = "") {
      return str2 + ".stacktrace";
    }
  }
  
  private void handleException(Throwable paramThrowable, ReportingInteractionMode paramReportingInteractionMode, boolean paramBoolean1, final boolean paramBoolean2)
  {
    final boolean bool1 = true;
    if (!this.enabled) {
      return;
    }
    boolean bool2 = false;
    boolean bool3;
    label74:
    final String str;
    SendWorker localSendWorker1;
    label171:
    final SendWorker localSendWorker2;
    if (paramReportingInteractionMode == null)
    {
      paramReportingInteractionMode = ACRA.getConfig().mode();
      if (paramThrowable == null) {
        paramThrowable = new Exception("Report requested by developer");
      }
      if ((paramReportingInteractionMode != ReportingInteractionMode.TOAST) && ((ACRA.getConfig().resToastText() == 0) || ((paramReportingInteractionMode != ReportingInteractionMode.NOTIFICATION) && (paramReportingInteractionMode != ReportingInteractionMode.DIALOG)))) {
        break label281;
      }
      bool3 = bool1;
      if (bool3) {
        new Thread()
        {
          public void run()
          {
            Looper.prepare();
            ToastSender.sendToast(ErrorReporter.this.mContext, ACRA.getConfig().resToastText(), 1);
            Looper.loop();
          }
        }.start();
      }
      CrashReportData localCrashReportData = this.crashReportDataFactory.createCrashData(paramThrowable, paramBoolean1, this.brokenThread);
      str = getReportFileName(localCrashReportData);
      saveCrashReportFile(str, localCrashReportData);
      if ((paramReportingInteractionMode != ReportingInteractionMode.SILENT) && (paramReportingInteractionMode != ReportingInteractionMode.TOAST) && (!this.prefs.getBoolean("acra.alwaysaccept", false))) {
        break label287;
      }
      Log.d(ACRA.LOG_TAG, "About to start ReportSenderWorker from #handleException");
      localSendWorker1 = startSendingReports(bool2, bool1);
      if (bool3)
      {
        toastWaitEnded = false;
        new Thread()
        {
          public void run()
          {
            Time localTime1 = new Time();
            Time localTime2 = new Time();
            localTime1.setToNow();
            long l1 = localTime1.toMillis(false);
            long l2 = 0L;
            for (;;)
            {
              if (l2 < 3000L) {
                try
                {
                  Thread.sleep(3000L);
                  localTime2.setToNow();
                  l2 = localTime2.toMillis(false) - l1;
                }
                catch (InterruptedException localInterruptedException)
                {
                  for (;;)
                  {
                    Log.d(ACRA.LOG_TAG, "Interrupted while waiting for Toast to end.", localInterruptedException);
                  }
                }
              }
            }
            ErrorReporter.access$102(true);
          }
        }.start();
      }
      localSendWorker2 = localSendWorker1;
      if ((paramReportingInteractionMode != ReportingInteractionMode.DIALOG) || (this.prefs.getBoolean("acra.alwaysaccept", false))) {
        break label323;
      }
    }
    for (;;)
    {
      new Thread()
      {
        public void run()
        {
          Log.d(ACRA.LOG_TAG, "Waiting for Toast + worker...");
          while ((!ErrorReporter.toastWaitEnded) || ((localSendWorker2 != null) && (localSendWorker2.isAlive()))) {
            try
            {
              Thread.sleep(100L);
            }
            catch (InterruptedException localInterruptedException)
            {
              Log.e(ACRA.LOG_TAG, "Error : ", localInterruptedException);
            }
          }
          if (bool1)
          {
            Log.d(ACRA.LOG_TAG, "About to create DIALOG from #handleException");
            ErrorReporter.this.notifyDialog(str);
          }
          Log.d(ACRA.LOG_TAG, "Wait for Toast + worker ended. Kill Application ? " + paramBoolean2);
          if (paramBoolean2) {
            ErrorReporter.this.endApplication();
          }
        }
      }.start();
      return;
      ReportingInteractionMode localReportingInteractionMode1 = ReportingInteractionMode.SILENT;
      bool2 = false;
      if (paramReportingInteractionMode != localReportingInteractionMode1) {
        break;
      }
      ReportingInteractionMode localReportingInteractionMode2 = ACRA.getConfig().mode();
      ReportingInteractionMode localReportingInteractionMode3 = ReportingInteractionMode.SILENT;
      bool2 = false;
      if (localReportingInteractionMode2 == localReportingInteractionMode3) {
        break;
      }
      bool2 = true;
      break;
      label281:
      bool3 = false;
      break label74;
      label287:
      ReportingInteractionMode localReportingInteractionMode4 = ReportingInteractionMode.NOTIFICATION;
      localSendWorker1 = null;
      if (paramReportingInteractionMode != localReportingInteractionMode4) {
        break label171;
      }
      Log.d(ACRA.LOG_TAG, "About to send status bar notification from #handleException");
      notifySendReport(str);
      localSendWorker1 = null;
      break label171;
      label323:
      bool1 = false;
    }
  }
  
  private void notifySendReport(String paramString)
  {
    NotificationManager localNotificationManager = (NotificationManager)this.mContext.getSystemService("notification");
    ACRAConfiguration localACRAConfiguration = ACRA.getConfig();
    Notification localNotification = new Notification(localACRAConfiguration.resNotifIcon(), this.mContext.getText(localACRAConfiguration.resNotifTickerText()), System.currentTimeMillis());
    CharSequence localCharSequence1 = this.mContext.getText(localACRAConfiguration.resNotifTitle());
    CharSequence localCharSequence2 = this.mContext.getText(localACRAConfiguration.resNotifText());
    Intent localIntent = new Intent(this.mContext, CrashReportDialog.class);
    Log.d(ACRA.LOG_TAG, "Creating Notification for " + paramString);
    localIntent.putExtra("REPORT_FILE_NAME", paramString);
    PendingIntent localPendingIntent = PendingIntent.getActivity(this.mContext, 0, localIntent, 134217728);
    localNotification.setLatestEventInfo(this.mContext, localCharSequence1, localCharSequence2, localPendingIntent);
    localNotificationManager.cancelAll();
    localNotificationManager.notify(666, localNotification);
  }
  
  private void saveCrashReportFile(String paramString, CrashReportData paramCrashReportData)
  {
    try
    {
      Log.d(ACRA.LOG_TAG, "Writing crash report file " + paramString + ".");
      new CrashReportPersister(this.mContext).store(paramCrashReportData, paramString);
      return;
    }
    catch (Exception localException)
    {
      Log.e(ACRA.LOG_TAG, "An error occurred while writing the report file...", localException);
    }
  }
  
  @Deprecated
  public void addCustomData(String paramString1, String paramString2)
  {
    this.crashReportDataFactory.putCustomData(paramString1, paramString2);
  }
  
  public void addReportSender(ReportSender paramReportSender)
  {
    this.mReportSenders.add(paramReportSender);
  }
  
  public void checkReportsOnApplicationStart()
  {
    long l = this.prefs.getInt("acra.lastVersionNr", 0);
    PackageInfo localPackageInfo = new PackageManagerWrapper(this.mContext).getPackageInfo();
    int i;
    String[] arrayOfString2;
    if ((localPackageInfo != null) && (localPackageInfo.versionCode > l))
    {
      i = 1;
      if (i != 0)
      {
        if (ACRA.getConfig().deleteOldUnsentReportsOnApplicationStart()) {
          deletePendingReports();
        }
        SharedPreferences.Editor localEditor = this.prefs.edit();
        localEditor.putInt("acra.lastVersionNr", localPackageInfo.versionCode);
        localEditor.commit();
      }
      if (((ACRA.getConfig().mode() == ReportingInteractionMode.NOTIFICATION) || (ACRA.getConfig().mode() == ReportingInteractionMode.DIALOG)) && (ACRA.getConfig().deleteUnapprovedReportsOnApplicationStart())) {
        deletePendingNonApprovedReports(true);
      }
      CrashReportFinder localCrashReportFinder = new CrashReportFinder(this.mContext);
      String[] arrayOfString1 = localCrashReportFinder.getCrashReportFiles();
      if ((arrayOfString1 != null) && (arrayOfString1.length > 0))
      {
        ReportingInteractionMode localReportingInteractionMode = ACRA.getConfig().mode();
        arrayOfString2 = localCrashReportFinder.getCrashReportFiles();
        boolean bool = containsOnlySilentOrApprovedReports(arrayOfString2);
        if ((localReportingInteractionMode != ReportingInteractionMode.SILENT) && (localReportingInteractionMode != ReportingInteractionMode.TOAST) && ((!bool) || ((localReportingInteractionMode != ReportingInteractionMode.NOTIFICATION) && (localReportingInteractionMode != ReportingInteractionMode.DIALOG)))) {
          break label279;
        }
        if ((localReportingInteractionMode == ReportingInteractionMode.TOAST) && (!bool)) {
          ToastSender.sendToast(this.mContext, ACRA.getConfig().resToastText(), 1);
        }
        Log.v(ACRA.LOG_TAG, "About to start ReportSenderWorker from #checkReportOnApplicationStart");
        startSendingReports(false, false);
      }
    }
    label279:
    do
    {
      return;
      i = 0;
      break;
      if (ACRA.getConfig().mode() == ReportingInteractionMode.NOTIFICATION)
      {
        notifySendReport(getLatestNonSilentReport(arrayOfString2));
        return;
      }
    } while (ACRA.getConfig().mode() != ReportingInteractionMode.DIALOG);
    notifyDialog(getLatestNonSilentReport(arrayOfString2));
  }
  
  void deletePendingNonApprovedReports(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      deletePendingReports(false, true, i);
      return;
    }
  }
  
  void deletePendingReports()
  {
    deletePendingReports(true, true, 0);
  }
  
  public String getCustomData(String paramString)
  {
    return this.crashReportDataFactory.getCustomData(paramString);
  }
  
  public void handleException(Throwable paramThrowable)
  {
    handleException(paramThrowable, ACRA.getConfig().mode(), false, false);
  }
  
  public void handleException(Throwable paramThrowable, boolean paramBoolean)
  {
    handleException(paramThrowable, ACRA.getConfig().mode(), false, paramBoolean);
  }
  
  public void handleSilentException(Throwable paramThrowable)
  {
    if (this.enabled)
    {
      handleException(paramThrowable, ReportingInteractionMode.SILENT, true, false);
      Log.d(ACRA.LOG_TAG, "ACRA sent Silent report.");
      return;
    }
    Log.d(ACRA.LOG_TAG, "ACRA is disabled. Silent report not sent.");
  }
  
  void notifyDialog(String paramString)
  {
    Log.d(ACRA.LOG_TAG, "Creating Dialog for " + paramString);
    Intent localIntent = new Intent(this.mContext, CrashReportDialog.class);
    localIntent.putExtra("REPORT_FILE_NAME", paramString);
    localIntent.setFlags(268435456);
    this.mContext.startActivity(localIntent);
  }
  
  public String putCustomData(String paramString1, String paramString2)
  {
    return this.crashReportDataFactory.putCustomData(paramString1, paramString2);
  }
  
  public void removeAllReportSenders()
  {
    this.mReportSenders.clear();
  }
  
  public String removeCustomData(String paramString)
  {
    return this.crashReportDataFactory.removeCustomData(paramString);
  }
  
  public void removeReportSender(ReportSender paramReportSender)
  {
    this.mReportSenders.remove(paramReportSender);
  }
  
  public void removeReportSenders(Class<?> paramClass)
  {
    if (ReportSender.class.isAssignableFrom(paramClass))
    {
      Iterator localIterator = this.mReportSenders.iterator();
      while (localIterator.hasNext())
      {
        ReportSender localReportSender = (ReportSender)localIterator.next();
        if (paramClass.isInstance(localReportSender)) {
          this.mReportSenders.remove(localReportSender);
        }
      }
    }
  }
  
  public void setDefaultReportSenders()
  {
    ACRAConfiguration localACRAConfiguration = ACRA.getConfig();
    Application localApplication = ACRA.getApplication();
    removeAllReportSenders();
    if (!"".equals(localACRAConfiguration.mailTo()))
    {
      Log.w(ACRA.LOG_TAG, localApplication.getPackageName() + " reports will be sent by email (if accepted by user).");
      setReportSender(new EmailIntentSender(localApplication));
    }
    do
    {
      return;
      if (!new PackageManagerWrapper(localApplication).hasPermission("android.permission.INTERNET"))
      {
        Log.e(ACRA.LOG_TAG, localApplication.getPackageName() + " should be granted permission " + "android.permission.INTERNET" + " if you want your crash reports to be sent. If you don't want to add this permission to your application you can also enable sending reports by email. If this is your will then provide your email address in @ReportsCrashes(mailTo=\"your.account@domain.com\"");
        return;
      }
      if ((localACRAConfiguration.formUri() != null) && (!"".equals(localACRAConfiguration.formUri())))
      {
        setReportSender(new HttpPostSender(null));
        return;
      }
    } while ((localACRAConfiguration.formKey() == null) || ("".equals(localACRAConfiguration.formKey().trim())));
    addReportSender(new GoogleFormSender());
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    String str1 = ACRA.LOG_TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("ACRA is ");
    if (paramBoolean) {}
    for (String str2 = "enabled";; str2 = "disabled")
    {
      Log.i(str1, str2 + " for " + this.mContext.getPackageName());
      this.enabled = paramBoolean;
      return;
    }
  }
  
  public void setReportSender(ReportSender paramReportSender)
  {
    removeAllReportSenders();
    addReportSender(paramReportSender);
  }
  
  SendWorker startSendingReports(boolean paramBoolean1, boolean paramBoolean2)
  {
    SendWorker localSendWorker = new SendWorker(this.mContext, this.mReportSenders, paramBoolean1, paramBoolean2);
    localSendWorker.start();
    return localSendWorker;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      if (!this.enabled)
      {
        if (this.mDfltExceptionHandler != null)
        {
          Log.e(ACRA.LOG_TAG, "ACRA is disabled for " + this.mContext.getPackageName() + " - forwarding uncaught Exception on to default ExceptionHandler");
          this.mDfltExceptionHandler.uncaughtException(paramThread, paramThrowable);
          return;
        }
        Log.e(ACRA.LOG_TAG, "ACRA is disabled for " + this.mContext.getPackageName() + " - no default ExceptionHandler");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (this.mDfltExceptionHandler != null)
      {
        this.mDfltExceptionHandler.uncaughtException(paramThread, paramThrowable);
        return;
        this.brokenThread = paramThread;
        this.unhandledThrowable = paramThrowable;
        Log.e(ACRA.LOG_TAG, "ACRA caught a " + paramThrowable.getClass().getSimpleName() + " exception for " + this.mContext.getPackageName() + ". Building report.");
        handleException(paramThrowable, ACRA.getConfig().mode(), false, true);
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.ErrorReporter
 * JD-Core Version:    0.7.0.1
 */