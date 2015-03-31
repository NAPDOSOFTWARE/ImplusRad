package org.acra;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.IOException;
import org.acra.collector.CrashReportData;
import org.acra.util.ToastSender;

public final class CrashReportDialog
  extends Activity
{
  private static final String STATE_COMMENT = "comment";
  private static final String STATE_EMAIL = "email";
  String mReportFileName;
  private SharedPreferences prefs;
  private EditText userComment;
  private EditText userEmail;
  
  protected void cancelNotification()
  {
    ((NotificationManager)getSystemService("notification")).cancel(666);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mReportFileName = getIntent().getStringExtra("REPORT_FILE_NAME");
    Log.d(ACRA.LOG_TAG, "Opening CrashReportDialog for " + this.mReportFileName);
    if (this.mReportFileName == null) {
      finish();
    }
    requestWindowFeature(3);
    LinearLayout localLinearLayout1 = new LinearLayout(this);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setPadding(10, 10, 10, 10);
    localLinearLayout1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localLinearLayout1.setFocusable(true);
    localLinearLayout1.setFocusableInTouchMode(true);
    final ScrollView localScrollView = new ScrollView(this);
    localLinearLayout1.addView(localScrollView, new LinearLayout.LayoutParams(-1, -1, 1.0F));
    LinearLayout localLinearLayout2 = new LinearLayout(this);
    localLinearLayout2.setOrientation(1);
    localScrollView.addView(localLinearLayout2);
    TextView localTextView1 = new TextView(this);
    localTextView1.setText(getText(ACRA.getConfig().resDialogText()));
    localLinearLayout2.addView(localTextView1);
    int i = ACRA.getConfig().resDialogCommentPrompt();
    if (i != 0)
    {
      TextView localTextView2 = new TextView(this);
      localTextView2.setText(getText(i));
      localTextView2.setPadding(localTextView2.getPaddingLeft(), 10, localTextView2.getPaddingRight(), localTextView2.getPaddingBottom());
      localLinearLayout2.addView(localTextView2, new LinearLayout.LayoutParams(-1, -2));
      this.userComment = new EditText(this);
      this.userComment.setLines(2);
      if (paramBundle != null)
      {
        String str2 = paramBundle.getString("comment");
        if (str2 != null) {
          this.userComment.setText(str2);
        }
      }
      localLinearLayout2.addView(this.userComment);
    }
    int j = ACRA.getConfig().resDialogEmailPrompt();
    if (j != 0)
    {
      TextView localTextView3 = new TextView(this);
      localTextView3.setText(getText(j));
      localTextView3.setPadding(localTextView3.getPaddingLeft(), 10, localTextView3.getPaddingRight(), localTextView3.getPaddingBottom());
      localLinearLayout2.addView(localTextView3);
      this.userEmail = new EditText(this);
      this.userEmail.setSingleLine();
      this.userEmail.setInputType(33);
      this.prefs = getSharedPreferences(ACRA.getConfig().sharedPreferencesName(), ACRA.getConfig().sharedPreferencesMode());
      String str1 = null;
      if (paramBundle != null) {
        str1 = paramBundle.getString("email");
      }
      if (str1 == null) {
        break label699;
      }
      this.userEmail.setText(str1);
    }
    for (;;)
    {
      localLinearLayout2.addView(this.userEmail);
      LinearLayout localLinearLayout3 = new LinearLayout(this);
      localLinearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      localLinearLayout3.setPadding(localLinearLayout3.getPaddingLeft(), 10, localLinearLayout3.getPaddingRight(), localLinearLayout3.getPaddingBottom());
      Button localButton1 = new Button(this);
      localButton1.setText(17039379);
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          String str1;
          if (CrashReportDialog.this.userComment != null) {
            str1 = CrashReportDialog.this.userComment.getText().toString();
          }
          for (;;)
          {
            String str2;
            CrashReportPersister localCrashReportPersister;
            if ((CrashReportDialog.this.prefs != null) && (CrashReportDialog.this.userEmail != null))
            {
              str2 = CrashReportDialog.this.userEmail.getText().toString();
              SharedPreferences.Editor localEditor = CrashReportDialog.this.prefs.edit();
              localEditor.putString("acra.user.email", str2);
              localEditor.commit();
              localCrashReportPersister = new CrashReportPersister(CrashReportDialog.this.getApplicationContext());
            }
            try
            {
              Log.d(ACRA.LOG_TAG, "Add user comment to " + CrashReportDialog.this.mReportFileName);
              CrashReportData localCrashReportData = localCrashReportPersister.load(CrashReportDialog.this.mReportFileName);
              localCrashReportData.put(ReportField.USER_COMMENT, str1);
              localCrashReportData.put(ReportField.USER_EMAIL, str2);
              localCrashReportPersister.store(localCrashReportData, CrashReportDialog.this.mReportFileName);
              Log.v(ACRA.LOG_TAG, "About to start SenderWorker from CrashReportDialog");
              ACRA.getErrorReporter().startSendingReports(false, true);
              int i = ACRA.getConfig().resDialogOkToast();
              if (i != 0) {
                ToastSender.sendToast(CrashReportDialog.this.getApplicationContext(), i, 1);
              }
              CrashReportDialog.this.finish();
              return;
              str1 = "";
              continue;
              str2 = "";
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                Log.w(ACRA.LOG_TAG, "User comment not added: ", localIOException);
              }
            }
          }
        }
      });
      localLinearLayout3.addView(localButton1, new LinearLayout.LayoutParams(-1, -2, 1.0F));
      Button localButton2 = new Button(this);
      localButton2.setText(17039369);
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ACRA.getErrorReporter().deletePendingNonApprovedReports(false);
          CrashReportDialog.this.finish();
        }
      });
      localLinearLayout3.addView(localButton2, new LinearLayout.LayoutParams(-1, -2, 1.0F));
      localLinearLayout1.addView(localLinearLayout3, new LinearLayout.LayoutParams(-1, -2));
      setContentView(localLinearLayout1);
      int k = ACRA.getConfig().resDialogTitle();
      if (k != 0) {
        setTitle(k);
      }
      getWindow().setFeatureDrawableResource(3, ACRA.getConfig().resDialogIcon());
      cancelNotification();
      localScrollView.post(new Runnable()
      {
        public void run()
        {
          localScrollView.scrollTo(0, 0);
        }
      });
      return;
      label699:
      this.userEmail.setText(this.prefs.getString("acra.user.email", ""));
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      ACRA.getErrorReporter().deletePendingNonApprovedReports(false);
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if ((this.userComment != null) && (this.userComment.getText() != null)) {
      paramBundle.putString("comment", this.userComment.getText().toString());
    }
    if ((this.userEmail != null) && (this.userEmail.getText() != null)) {
      paramBundle.putString("email", this.userEmail.getText().toString());
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.CrashReportDialog
 * JD-Core Version:    0.7.0.1
 */