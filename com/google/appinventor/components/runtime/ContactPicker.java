package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts.People;
import android.provider.Contacts.Phones;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.HoneycombUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DesignerComponent(category=ComponentCategory.SOCIAL, description="A button that, when clicked on, displays a list of the contacts to choose among. After the user has made a selection, the following properties will be set to information about the chosen contact: <ul>\n<li> <code>ContactName</code>: the contact's name </li>\n <li> <code>EmailAddress</code>: the contact's primary email address </li>\n <li> <code>EmailAddressList</code>: a list of the contact's email addresses </li>\n <li> <code>PhoneNumber</code>: the contact's primary phone number (on Later Android Verisons)</li>\n <li> <code>PhoneNumberList</code>: a list of the contact's phone numbers (on Later Android Versions)</li>\n <li> <code>Picture</code>: the name of the file containing the contact's image, which can be used as a <code>Picture</code> property value for the <code>Image</code> or <code>ImageSprite</code> component.</li></ul>\n</p><p>Other properties affect the appearance of the button (<code>TextAlignment</code>, <code>BackgroundColor</code>, etc.) and whether it can be clicked on (<code>Enabled</code>).\n</p><p>The ContactPicker component might not work on all phones. For example, on Android systems before system 3.0, it cannot pick phone numbers, and the list of email addresses will contain only one email.", version=5)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.READ_CONTACTS")
public class ContactPicker
  extends Picker
  implements ActivityResultListener
{
  private static String[] CONTACT_PROJECTION;
  private static String[] DATA_PROJECTION;
  private static final int EMAIL_INDEX = 1;
  private static final int NAME_INDEX = 0;
  private static final int PHONE_INDEX = 2;
  private static final String[] PROJECTION = { "name", "primary_email" };
  protected final Activity activityContext;
  protected String contactName;
  protected String contactPictureUri;
  protected String emailAddress;
  protected List emailAddressList;
  private final Uri intentUri;
  protected String phoneNumber;
  protected List phoneNumberList;
  
  public ContactPicker(ComponentContainer paramComponentContainer)
  {
    this(paramComponentContainer, Contacts.People.CONTENT_URI);
  }
  
  protected ContactPicker(ComponentContainer paramComponentContainer, Uri paramUri)
  {
    super(paramComponentContainer);
    this.activityContext = paramComponentContainer.$context();
    if ((SdkLevel.getLevel() >= 12) && (paramUri.equals(Contacts.People.CONTENT_URI)))
    {
      this.intentUri = HoneycombUtil.getContentUri();
      return;
    }
    if ((SdkLevel.getLevel() >= 12) && (paramUri.equals(Contacts.Phones.CONTENT_URI)))
    {
      this.intentUri = HoneycombUtil.getPhoneContentUri();
      return;
    }
    this.intentUri = paramUri;
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String ContactName()
  {
    return ensureNotNull(this.contactName);
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String EmailAddress()
  {
    return ensureNotNull(this.emailAddress);
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public List EmailAddressList()
  {
    return ensureNotNull(this.emailAddressList);
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String PhoneNumber()
  {
    return ensureNotNull(this.phoneNumber);
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public List PhoneNumberList()
  {
    return ensureNotNull(this.phoneNumberList);
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String Picture()
  {
    return ensureNotNull(this.contactPictureUri);
  }
  
  protected boolean checkContactUri(Uri paramUri, String paramString)
  {
    Log.i("ContactPicker", "contactUri is " + paramUri);
    if ((paramUri == null) || (!"content".equals(paramUri.getScheme())))
    {
      Log.i("ContactPicker", "checkContactUri failed: A");
      puntContactSelection(1107);
      return false;
    }
    if (!paramUri.getSchemeSpecificPart().startsWith(paramString))
    {
      Log.i("ContactPicker", "checkContactUri failed: C");
      Log.i("ContactPicker", paramUri.getPath());
      puntContactSelection(1107);
      return false;
    }
    return true;
  }
  
  protected String ensureNotNull(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    return paramString;
  }
  
  protected List ensureNotNull(List paramList)
  {
    if (paramList == null) {
      paramList = new ArrayList();
    }
    return paramList;
  }
  
  /* Error */
  protected String getEmailAddress(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 191	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4: istore_3
    //   5: ldc 179
    //   7: astore 4
    //   9: new 133	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   16: ldc 193
    //   18: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_3
    //   22: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 5
    //   30: iconst_1
    //   31: anewarray 45	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc 198
    //   38: aastore
    //   39: astore 6
    //   41: aload_0
    //   42: getfield 71	com/google/appinventor/components/runtime/ContactPicker:activityContext	Landroid/app/Activity;
    //   45: invokevirtual 204	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   48: getstatic 209	android/provider/Contacts$ContactMethods:CONTENT_EMAIL_URI	Landroid/net/Uri;
    //   51: aload 6
    //   53: aload 5
    //   55: aconst_null
    //   56: aconst_null
    //   57: invokevirtual 215	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 7
    //   62: aload 7
    //   64: invokeinterface 221 1 0
    //   69: ifeq +16 -> 85
    //   72: aload_0
    //   73: aload 7
    //   75: iconst_0
    //   76: invokevirtual 225	com/google/appinventor/components/runtime/ContactPicker:guardCursorGetString	(Landroid/database/Cursor;I)Ljava/lang/String;
    //   79: astore 9
    //   81: aload 9
    //   83: astore 4
    //   85: aload 7
    //   87: invokeinterface 228 1 0
    //   92: aload_0
    //   93: aload 4
    //   95: invokevirtual 108	com/google/appinventor/components/runtime/ContactPicker:ensureNotNull	(Ljava/lang/String;)Ljava/lang/String;
    //   98: areturn
    //   99: astore_2
    //   100: ldc 179
    //   102: areturn
    //   103: astore 8
    //   105: aload 7
    //   107: invokeinterface 228 1 0
    //   112: aload 8
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	ContactPicker
    //   0	115	1	paramString	String
    //   99	1	2	localNumberFormatException	java.lang.NumberFormatException
    //   4	18	3	i	int
    //   7	87	4	localObject1	Object
    //   28	26	5	str1	String
    //   39	13	6	arrayOfString	String[]
    //   60	46	7	localCursor	Cursor
    //   103	10	8	localObject2	Object
    //   79	3	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	5	99	java/lang/NumberFormatException
    //   62	81	103	finally
  }
  
  protected Intent getIntent()
  {
    return new Intent("android.intent.action.PICK", this.intentUri);
  }
  
  protected String guardCursorGetString(Cursor paramCursor, int paramInt)
  {
    try
    {
      String str2 = paramCursor.getString(paramInt);
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1 = "";
      }
    }
    return ensureNotNull(str1);
  }
  
  public void postHoneycombGetContactEmailAndPhone(Cursor paramCursor)
  {
    this.phoneNumber = "";
    this.emailAddress = "";
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramCursor.moveToFirst())
    {
      int i = HoneycombUtil.getPhoneIndex(paramCursor);
      int j = HoneycombUtil.getEmailIndex(paramCursor);
      int k = HoneycombUtil.getMimeIndex(paramCursor);
      String str1 = HoneycombUtil.getPhoneType();
      String str2 = HoneycombUtil.getEmailType();
      if (!paramCursor.isAfterLast())
      {
        String str3 = guardCursorGetString(paramCursor, k);
        if (str3.contains(str1)) {
          localArrayList1.add(guardCursorGetString(paramCursor, i));
        }
        for (;;)
        {
          paramCursor.moveToNext();
          break;
          if (str3.contains(str2)) {
            localArrayList2.add(guardCursorGetString(paramCursor, j));
          } else {
            Log.i("ContactPicker", "Type mismatch: " + str3 + " not " + str1 + " or " + str2);
          }
        }
      }
    }
    if (!localArrayList1.isEmpty()) {
      this.phoneNumber = ((String)localArrayList1.get(0));
    }
    if (!localArrayList2.isEmpty()) {
      this.emailAddress = ((String)localArrayList2.get(0));
    }
    this.phoneNumberList = localArrayList1;
    this.emailAddressList = localArrayList2;
  }
  
  public String postHoneycombGetContactNameAndPicture(Cursor paramCursor)
  {
    String str = "";
    if (paramCursor.moveToFirst())
    {
      int i = HoneycombUtil.getIdIndex(paramCursor);
      int j = HoneycombUtil.getNameIndex(paramCursor);
      int k = HoneycombUtil.getThumbnailIndex(paramCursor);
      int m = HoneycombUtil.getPhotoIndex(paramCursor);
      str = guardCursorGetString(paramCursor, i);
      this.contactName = guardCursorGetString(paramCursor, j);
      this.contactPictureUri = guardCursorGetString(paramCursor, k);
      Log.i("ContactPicker", "photo_uri=" + guardCursorGetString(paramCursor, m));
    }
    return str;
  }
  
  public void preHoneycombGetContactInfo(Cursor paramCursor, Uri paramUri)
  {
    if (paramCursor.moveToFirst())
    {
      this.contactName = guardCursorGetString(paramCursor, 0);
      this.emailAddress = getEmailAddress(guardCursorGetString(paramCursor, 1));
      this.contactPictureUri = paramUri.toString();
      if (!this.emailAddress.equals("")) {
        break label67;
      }
    }
    label67:
    String[] arrayOfString;
    for (Object localObject = new ArrayList();; localObject = Arrays.asList(arrayOfString))
    {
      this.emailAddressList = ((List)localObject);
      return;
      arrayOfString = new String[1];
      arrayOfString[0] = this.emailAddress;
    }
  }
  
  protected void puntContactSelection(int paramInt)
  {
    this.contactName = "";
    this.emailAddress = "";
    this.contactPictureUri = "";
    this.container.$form().dispatchErrorOccurredEvent(this, "", paramInt, new Object[0]);
  }
  
  public void resultReturned(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Uri localUri;
    String str1;
    if ((paramInt1 == this.requestCode) && (paramInt2 == -1))
    {
      Log.i("ContactPicker", "received intent is " + paramIntent);
      localUri = paramIntent.getData();
      if (SdkLevel.getLevel() < 12) {
        break label250;
      }
      str1 = "//com.android.contacts/contact";
      if (checkContactUri(localUri, str1)) {
        localCursor1 = null;
      }
    }
    for (localCursor2 = null;; localCursor2 = null)
    {
      try
      {
        int i = SdkLevel.getLevel();
        localCursor1 = null;
        localCursor2 = null;
        if (i < 12) {
          break label258;
        }
        CONTACT_PROJECTION = HoneycombUtil.getContactProjection();
        localCursor1 = this.activityContext.getContentResolver().query(localUri, CONTACT_PROJECTION, null, null, null);
        String str2 = postHoneycombGetContactNameAndPicture(localCursor1);
        DATA_PROJECTION = HoneycombUtil.getDataProjection();
        localCursor2 = HoneycombUtil.getDataCursor(str2, this.activityContext, DATA_PROJECTION);
        postHoneycombGetContactEmailAndPhone(localCursor2);
        Log.i("ContactPicker", "Contact name = " + this.contactName + ", email address = " + this.emailAddress + ", phone number = " + this.phoneNumber + ", contactPhotoUri = " + this.contactPictureUri);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label250:
          Log.i("ContactPicker", "checkContactUri failed: D");
          label258:
          puntContactSelection(1107);
          if (localCursor1 != null) {
            localCursor1.close();
          }
          if (localCursor2 != null) {
            localCursor2.close();
          }
        }
      }
      finally
      {
        if (localCursor1 == null) {
          break label351;
        }
        localCursor1.close();
        if (localCursor2 == null) {
          break label363;
        }
        localCursor2.close();
      }
      AfterPicking();
      return;
      str1 = "//contacts/people";
      break;
      localCursor1 = this.activityContext.getContentResolver().query(localUri, PROJECTION, null, null, null);
      preHoneycombGetContactInfo(localCursor1, localUri);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.ContactPicker
 * JD-Core Version:    0.7.0.1
 */