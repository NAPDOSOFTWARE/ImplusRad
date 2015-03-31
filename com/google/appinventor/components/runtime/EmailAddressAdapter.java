package com.google.appinventor.components.runtime;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.provider.Contacts.ContactMethods;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import com.google.appinventor.components.runtime.util.HoneycombUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;

public class EmailAddressAdapter
  extends ResourceCursorAdapter
{
  private static final boolean DEBUG = false;
  private static final String[] POST_HONEYCOMB_PROJECTION = HoneycombUtil.getEmailAdapterProjection();
  public static final int PRE_HONEYCOMB_DATA_INDEX = 2;
  public static final int PRE_HONEYCOMB_NAME_INDEX = 1;
  private static final String[] PRE_HONEYCOMB_PROJECTION = { "_id", "name", "data" };
  private static String SORT_ORDER;
  private static final String TAG = "EmailAddressAdapter";
  private ContentResolver contentResolver;
  private Context context;
  
  public EmailAddressAdapter(Context paramContext)
  {
    super(paramContext, 17367050, null);
    this.contentResolver = paramContext.getContentResolver();
    this.context = paramContext;
    if (SdkLevel.getLevel() >= 12)
    {
      SORT_ORDER = HoneycombUtil.getTimesContacted() + " DESC, " + HoneycombUtil.getDisplayName();
      return;
    }
    SORT_ORDER = "times_contacted DESC, name";
  }
  
  private final String makeDisplayString(Cursor paramCursor)
  {
    int i = paramCursor.getColumnIndex(HoneycombUtil.getDisplayName());
    int j = paramCursor.getColumnIndex(HoneycombUtil.getEmailAddress());
    StringBuilder localStringBuilder = new StringBuilder();
    String str1;
    if (SdkLevel.getLevel() >= 12) {
      str1 = paramCursor.getString(i);
    }
    for (String str2 = paramCursor.getString(j);; str2 = paramCursor.getString(2))
    {
      boolean bool = TextUtils.isEmpty(str1);
      int k = 0;
      if (!bool)
      {
        localStringBuilder.append(str1);
        k = 1;
      }
      if (k != 0) {
        localStringBuilder.append(" <");
      }
      localStringBuilder.append(str2);
      if (k != 0) {
        localStringBuilder.append(">");
      }
      return localStringBuilder.toString();
      str1 = paramCursor.getString(1);
    }
  }
  
  public final void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    ((TextView)paramView).setText(makeDisplayString(paramCursor));
  }
  
  public final String convertToString(Cursor paramCursor)
  {
    int i = paramCursor.getColumnIndex(HoneycombUtil.getDisplayName());
    int j = paramCursor.getColumnIndex(HoneycombUtil.getEmailAddress());
    String str1;
    if (SdkLevel.getLevel() >= 12) {
      str1 = paramCursor.getString(i);
    }
    for (String str2 = paramCursor.getString(j);; str2 = paramCursor.getString(2))
    {
      return new Rfc822Token(str1, str2, null).toString();
      str1 = paramCursor.getString(1);
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Uri localUri = null;
    String str2;
    if (paramCharSequence != null)
    {
      str2 = DatabaseUtils.sqlEscapeString(paramCharSequence.toString() + '%');
      if (SdkLevel.getLevel() < 12) {
        break label157;
      }
      localUri = HoneycombUtil.getDataContentUri();
      localStringBuilder.append("(" + HoneycombUtil.getDataMimeType() + "='" + HoneycombUtil.getEmailType() + "')");
      localStringBuilder.append(" AND ");
      localStringBuilder.append("(display_name LIKE ");
      localStringBuilder.append(str2);
      localStringBuilder.append(")");
    }
    String str1;
    for (;;)
    {
      str1 = localStringBuilder.toString();
      if (SdkLevel.getLevel() < 12) {
        break;
      }
      return this.contentResolver.query(localUri, POST_HONEYCOMB_PROJECTION, str1, null, SORT_ORDER);
      label157:
      localUri = Contacts.ContactMethods.CONTENT_EMAIL_URI;
      localStringBuilder.append("(name LIKE ");
      localStringBuilder.append(str2);
      localStringBuilder.append(") OR (display_name LIKE ");
      localStringBuilder.append(str2);
      localStringBuilder.append(")");
    }
    return this.contentResolver.query(localUri, PRE_HONEYCOMB_PROJECTION, str1, null, SORT_ORDER);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.EmailAddressAdapter
 * JD-Core Version:    0.7.0.1
 */