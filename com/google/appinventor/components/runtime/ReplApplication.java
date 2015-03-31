package com.google.appinventor.components.runtime;

import android.app.Application;
import android.util.Log;
import com.google.appinventor.common.version.GitBuildId;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.ErrorReporter;
import org.acra.annotation.ReportsCrashes;

@ReportsCrashes(formKey="")
public class ReplApplication
  extends Application
{
  private static ReplApplication thisInstance;
  private boolean active = false;
  
  public static void reportError(Throwable paramThrowable)
  {
    if ((thisInstance != null) && (thisInstance.active)) {
      ACRA.getErrorReporter().handleException(paramThrowable);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    thisInstance = this;
    String str = GitBuildId.getAcraUri();
    if (str.equals(""))
    {
      Log.i("ReplApplication", "ACRA Not Active");
      return;
    }
    Log.i("ReplApplication", "ACRA Active, URI = " + str);
    ACRAConfiguration localACRAConfiguration = ACRA.getNewDefaultConfig(this);
    localACRAConfiguration.setFormUri(str);
    localACRAConfiguration.setDisableSSLCertValidation(true);
    ACRA.setConfig(localACRAConfiguration);
    ACRA.init(this);
    this.active = true;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.ReplApplication
 * JD-Core Version:    0.7.0.1
 */