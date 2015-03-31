package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.collect.Lists;
import com.google.appinventor.components.runtime.collect.Maps;
import com.google.appinventor.components.runtime.collect.Sets;
import com.google.appinventor.components.runtime.util.AlignmentUtil;
import com.google.appinventor.components.runtime.util.AnimationUtil;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.FullScreenVideoUtil;
import com.google.appinventor.components.runtime.util.JsonUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.OnInitializeListener;
import com.google.appinventor.components.runtime.util.SdkLevel;
import com.google.appinventor.components.runtime.util.ViewUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;

@DesignerComponent(category=ComponentCategory.LAYOUT, description="Top-level component containing all other components in the program", showOnPalette=false, version=14)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.INTERNET,android.permission.ACCESS_WIFI_STATE,android.permission.ACCESS_NETWORK_STATE")
public class Form
  extends Activity
  implements Component, ComponentContainer, HandlesEventDispatching
{
  public static final String APPINVENTOR_URL_SCHEME = "appinventor";
  private static final String ARGUMENT_NAME = "APP_INVENTOR_START";
  private static final String LOG_TAG = "Form";
  private static final String RESULT_NAME = "APP_INVENTOR_RESULT";
  private static final int SWITCH_FORM_REQUEST_CODE = 1;
  protected static Form activeForm;
  private static boolean applicationIsBeingClosed;
  private static long minimumToastWait = 10000000000L;
  private static int nextRequestCode = 2;
  private String aboutScreen;
  private final HashMap<Integer, ActivityResultListener> activityResultMap = Maps.newHashMap();
  private AlignmentUtil alignmentSetter;
  private final Handler androidUIHandler = new Handler();
  private int backgroundColor;
  private Drawable backgroundDrawable;
  private String backgroundImagePath = "";
  private String closeAnimType;
  protected String formName;
  private FrameLayout frameLayout;
  private FullScreenVideoUtil fullScreenVideoUtil;
  private int horizontalAlignment;
  private long lastToastTime = System.nanoTime() - minimumToastWait;
  private String nextFormName;
  private final Set<OnDestroyListener> onDestroyListeners = Sets.newHashSet();
  private final Set<OnInitializeListener> onInitializeListeners = Sets.newHashSet();
  private final Set<OnNewIntentListener> onNewIntentListeners = Sets.newHashSet();
  private final Set<OnPauseListener> onPauseListeners = Sets.newHashSet();
  private final Set<OnResumeListener> onResumeListeners = Sets.newHashSet();
  private final Set<OnStopListener> onStopListeners = Sets.newHashSet();
  private String openAnimType;
  private boolean screenInitialized;
  private boolean scrollable;
  protected String startupValue = "";
  private int verticalAlignment;
  private LinearLayout viewLayout;
  private String yandexTranslateTagline = "";
  
  private void closeApplication()
  {
    applicationIsBeingClosed = true;
    finish();
    if (this.formName.equals("Screen1")) {
      System.exit(0);
    }
  }
  
  private void closeApplicationFromMenu()
  {
    closeApplication();
  }
  
  private static Object decodeJSONStringForForm(String paramString1, String paramString2)
  {
    Log.i("Form", "decodeJSONStringForForm -- decoding JSON representation:" + paramString1);
    Object localObject = "";
    try
    {
      localObject = JsonUtil.getObjectFromJson(paramString1);
      Log.i("Form", "decodeJSONStringForForm -- got decoded JSON:" + localObject.toString());
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      activeForm.dispatchErrorOccurredEvent(activeForm, paramString2, 903, new Object[] { paramString1 });
    }
    return localObject;
  }
  
  private void defaultPropertyValues()
  {
    Scrollable(false);
    BackgroundImage("");
    AboutScreen("");
    BackgroundColor(-1);
    AlignHorizontal(1);
    AlignVertical(1);
    Title("");
  }
  
  public static void finishActivity()
  {
    if (activeForm != null)
    {
      activeForm.closeForm(null);
      return;
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  public static void finishActivityWithResult(Object paramObject)
  {
    if (activeForm != null)
    {
      if ((activeForm instanceof ReplForm))
      {
        ((ReplForm)activeForm).setResult(paramObject);
        activeForm.closeForm(null);
        return;
      }
      String str = jsonEncodeForForm(paramObject, "close screen with value");
      Intent localIntent = new Intent();
      localIntent.putExtra("APP_INVENTOR_RESULT", str);
      activeForm.closeForm(localIntent);
      return;
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  public static void finishActivityWithTextResult(String paramString)
  {
    if (activeForm != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("APP_INVENTOR_RESULT", paramString);
      activeForm.closeForm(localIntent);
      return;
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  public static void finishApplication()
  {
    if (activeForm != null)
    {
      activeForm.closeApplicationFromBlocks();
      return;
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  private static int generateNewRequestCode()
  {
    int i = nextRequestCode;
    nextRequestCode = i + 1;
    return i;
  }
  
  public static Form getActiveForm()
  {
    return activeForm;
  }
  
  public static String getStartText()
  {
    if (activeForm != null) {
      return activeForm.startupValue;
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  public static Object getStartValue()
  {
    if (activeForm != null) {
      return decodeJSONStringForForm(activeForm.startupValue, "get start value");
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  protected static String jsonEncodeForForm(Object paramObject, String paramString)
  {
    String str = "";
    Log.i("Form", "jsonEncodeForForm -- creating JSON representation:" + paramObject.toString());
    try
    {
      str = JsonUtil.getJsonRepresentation(paramObject);
      Log.i("Form", "jsonEncodeForForm -- got JSON representation:" + str);
      return str;
    }
    catch (JSONException localJSONException)
    {
      Form localForm1 = activeForm;
      Form localForm2 = activeForm;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramObject.toString();
      localForm1.dispatchErrorOccurredEvent(localForm2, paramString, 904, arrayOfObject);
    }
    return str;
  }
  
  private void showAboutApplicationNotification()
  {
    Notifier.oneButtonAlert(this, (this.aboutScreen + "<p><small><em>Invented with MIT App Inventor<br>appinventor.mit.edu</em></small></p>" + this.yandexTranslateTagline).replaceAll("\\n", "<br>"), "About this app", "Got it");
  }
  
  private void showExitApplicationNotification()
  {
    Runnable local7 = new Runnable()
    {
      public void run()
      {
        Form.this.closeApplicationFromMenu();
      }
    };
    Runnable local8 = new Runnable()
    {
      public void run() {}
    };
    Notifier.twoButtonDialog(this, "Stop this application and exit? You'll need to relaunch the application to use it again.", "Stop application?", "Stop and exit", "Don't stop", false, local7, local8, local8);
  }
  
  public static void switchForm(String paramString)
  {
    if (activeForm != null)
    {
      activeForm.startNewForm(paramString, null);
      return;
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  public static void switchFormWithStartValue(String paramString, Object paramObject)
  {
    Log.i("Form", "Open another screen with start value:" + paramString);
    if (activeForm != null)
    {
      activeForm.startNewForm(paramString, paramObject);
      return;
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  public void $add(AndroidViewComponent paramAndroidViewComponent)
  {
    this.viewLayout.add(paramAndroidViewComponent);
  }
  
  public Activity $context()
  {
    return this;
  }
  
  protected void $define()
  {
    throw new UnsupportedOperationException();
  }
  
  public Form $form()
  {
    return this;
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="Information about the screen.  It appears when \"About this Application\" is selected from the system menu. Use it to inform people about your app.  In multiple screen apps, each screen has its own AboutScreen info.")
  public String AboutScreen()
  {
    return this.aboutScreen;
  }
  
  @DesignerProperty(defaultValue="", editorType="textArea")
  @SimpleProperty
  public void AboutScreen(String paramString)
  {
    this.aboutScreen = paramString;
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="A number that encodes how contents of the screen are aligned  horizontally. The choices are: 1 = left aligned, 2 = horizontally centered,  3 = right aligned.")
  public int AlignHorizontal()
  {
    return this.horizontalAlignment;
  }
  
  @DesignerProperty(defaultValue="1", editorType="horizontal_alignment")
  @SimpleProperty
  public void AlignHorizontal(int paramInt)
  {
    try
    {
      this.alignmentSetter.setHorizontalAlignment(paramInt);
      this.horizontalAlignment = paramInt;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      dispatchErrorOccurredEvent(this, "HorizontalAlignment", 1401, arrayOfObject);
    }
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="A number that encodes how the contents of the arrangement are aligned vertically. The choices are: 1 = aligned at the top, 2 = vertically centered, 3 = aligned at the bottom. Vertical alignment has no effect if the screen is scrollable.")
  public int AlignVertical()
  {
    return this.verticalAlignment;
  }
  
  @DesignerProperty(defaultValue="1", editorType="vertical_alignment")
  @SimpleProperty
  public void AlignVertical(int paramInt)
  {
    try
    {
      this.alignmentSetter.setVerticalAlignment(paramInt);
      this.verticalAlignment = paramInt;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      dispatchErrorOccurredEvent(this, "VerticalAlignment", 1402, arrayOfObject);
    }
  }
  
  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty(description="This is the display name of the installed application in the phone.If the AppName is blank, it will be set to the name of the project when the project is built.", userVisible=false)
  public void AppName(String paramString) {}
  
  @SimpleEvent(description="Device back button pressed.")
  public boolean BackPressed()
  {
    return EventDispatcher.dispatchEvent(this, "BackPressed", new Object[0]);
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public int BackgroundColor()
  {
    return this.backgroundColor;
  }
  
  @DesignerProperty(defaultValue="&HFFFFFFFF", editorType="color")
  @SimpleProperty
  public void BackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
    if (paramInt != 0)
    {
      this.viewLayout.getLayoutManager().setBackgroundColor(paramInt);
      this.frameLayout.setBackgroundColor(paramInt);
      return;
    }
    this.viewLayout.getLayoutManager().setBackgroundColor(-1);
    this.frameLayout.setBackgroundColor(-1);
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The screen background image.")
  public String BackgroundImage()
  {
    return this.backgroundImagePath;
  }
  
  @DesignerProperty(defaultValue="", editorType="asset")
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The screen background image.")
  public void BackgroundImage(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    this.backgroundImagePath = paramString;
    try
    {
      this.backgroundDrawable = MediaUtil.getBitmapDrawable(this, this.backgroundImagePath);
      ViewUtil.setBackgroundImage(this.frameLayout, this.backgroundDrawable);
      this.frameLayout.invalidate();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("Form", "Unable to load " + this.backgroundImagePath);
        this.backgroundDrawable = null;
      }
    }
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The animation for closing current screen and returning  to the previous screen. Valid options are default, fade, zoom, slidehorizontal, slidevertical, and none")
  public String CloseScreenAnimation()
  {
    return this.closeAnimType;
  }
  
  @DesignerProperty(defaultValue="default", editorType="screen_animation")
  @SimpleProperty
  public void CloseScreenAnimation(String paramString)
  {
    if ((paramString != "default") && (paramString != "fade") && (paramString != "zoom") && (paramString != "slidehorizontal") && (paramString != "slidevertical") && (paramString != "none"))
    {
      dispatchErrorOccurredEvent(this, "Screen", 905, new Object[] { paramString });
      return;
    }
    this.closeAnimType = paramString;
  }
  
  @SimpleEvent(description="Event raised when an error occurs. Only some errors will raise this condition.  For those errors, the system will show a notification by default.  You can use this event handler to prescribe an error behavior different than the default.")
  public void ErrorOccurred(Component paramComponent, String paramString1, int paramInt, String paramString2)
  {
    String str1 = paramComponent.getClass().getName();
    String str2 = str1.substring(1 + str1.lastIndexOf("."));
    Log.e("Form", "Form " + this.formName + " ErrorOccurred, errorNumber = " + paramInt + ", componentType = " + str2 + ", functionName = " + paramString1 + ", messages = " + paramString2);
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramComponent;
    arrayOfObject[1] = paramString1;
    arrayOfObject[2] = Integer.valueOf(paramInt);
    arrayOfObject[3] = paramString2;
    if ((!EventDispatcher.dispatchEvent(this, "ErrorOccurred", arrayOfObject)) && (this.screenInitialized)) {
      new Notifier(this).ShowAlert("Error " + paramInt + ": " + paramString2);
    }
  }
  
  public void ErrorOccurredDialog(Component paramComponent, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    String str1 = paramComponent.getClass().getName();
    String str2 = str1.substring(1 + str1.lastIndexOf("."));
    Log.e("Form", "Form " + this.formName + " ErrorOccurred, errorNumber = " + paramInt + ", componentType = " + str2 + ", functionName = " + paramString1 + ", messages = " + paramString2);
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramComponent;
    arrayOfObject[1] = paramString1;
    arrayOfObject[2] = Integer.valueOf(paramInt);
    arrayOfObject[3] = paramString2;
    if ((!EventDispatcher.dispatchEvent(this, "ErrorOccurred", arrayOfObject)) && (this.screenInitialized)) {
      new Notifier(this).ShowMessageDialog("Error " + paramInt + ": " + paramString2, paramString3, paramString4);
    }
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="Screen height (y-size).")
  public int Height()
  {
    return this.frameLayout.getHeight();
  }
  
  @DesignerProperty(defaultValue="", editorType="asset")
  @SimpleProperty(userVisible=false)
  public void Icon(String paramString) {}
  
  @SimpleEvent(description="Screen starting")
  public void Initialize()
  {
    this.androidUIHandler.post(new Runnable()
    {
      public void run()
      {
        if ((Form.this.frameLayout != null) && (Form.this.frameLayout.getWidth() != 0) && (Form.this.frameLayout.getHeight() != 0))
        {
          EventDispatcher.dispatchEvent(Form.this, "Initialize", new Object[0]);
          Form.access$202(Form.this, true);
          Iterator localIterator = Form.this.onInitializeListeners.iterator();
          while (localIterator.hasNext()) {
            ((OnInitializeListener)localIterator.next()).onInitialize();
          }
          if ((Form.activeForm instanceof ReplForm)) {
            ((ReplForm)Form.activeForm).HandleReturnValues();
          }
          return;
        }
        Form.this.androidUIHandler.post(this);
      }
    });
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The animation for switching to another screen. Valid options are default, fade, zoom, slidehorizontal, slidevertical, and none")
  public String OpenScreenAnimation()
  {
    return this.openAnimType;
  }
  
  @DesignerProperty(defaultValue="default", editorType="screen_animation")
  @SimpleProperty
  public void OpenScreenAnimation(String paramString)
  {
    if ((paramString != "default") && (paramString != "fade") && (paramString != "zoom") && (paramString != "slidehorizontal") && (paramString != "slidevertical") && (paramString != "none"))
    {
      dispatchErrorOccurredEvent(this, "Screen", 905, new Object[] { paramString });
      return;
    }
    this.openAnimType = paramString;
  }
  
  @SimpleEvent(description="Event raised when another screen has closed and control has returned to this screen.")
  public void OtherScreenClosed(String paramString, Object paramObject)
  {
    Log.i("Form", "Form " + this.formName + " OtherScreenClosed, otherScreenName = " + paramString + ", result = " + paramObject.toString());
    EventDispatcher.dispatchEvent(this, "OtherScreenClosed", new Object[] { paramString, paramObject });
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The requested screen orientation. Commonly used values are unspecified (-1), landscape (0), portrait (1), sensor (4), and user (2).  See the Android developer docuemntation for ActivityInfo.Screen_Orientation for the complete list of possible settings.")
  public String ScreenOrientation()
  {
    switch (getRequestedOrientation())
    {
    default: 
      return "unspecified";
    case 3: 
      return "behind";
    case 0: 
      return "landscape";
    case 5: 
      return "nosensor";
    case 1: 
      return "portrait";
    case 4: 
      return "sensor";
    case -1: 
      return "unspecified";
    case 2: 
      return "user";
    case 10: 
      return "fullSensor";
    case 8: 
      return "reverseLandscape";
    case 9: 
      return "reversePortrait";
    case 6: 
      return "sensorLandscape";
    }
    return "sensorPortrait";
  }
  
  @DesignerProperty(defaultValue="unspecified", editorType="screen_orientation")
  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public void ScreenOrientation(String paramString)
  {
    if (paramString.equalsIgnoreCase("behind"))
    {
      setRequestedOrientation(3);
      return;
    }
    if (paramString.equalsIgnoreCase("landscape"))
    {
      setRequestedOrientation(0);
      return;
    }
    if (paramString.equalsIgnoreCase("nosensor"))
    {
      setRequestedOrientation(5);
      return;
    }
    if (paramString.equalsIgnoreCase("portrait"))
    {
      setRequestedOrientation(1);
      return;
    }
    if (paramString.equalsIgnoreCase("sensor"))
    {
      setRequestedOrientation(4);
      return;
    }
    if (paramString.equalsIgnoreCase("unspecified"))
    {
      setRequestedOrientation(-1);
      return;
    }
    if (paramString.equalsIgnoreCase("user"))
    {
      setRequestedOrientation(2);
      return;
    }
    if (SdkLevel.getLevel() >= 9)
    {
      if (paramString.equalsIgnoreCase("fullSensor"))
      {
        setRequestedOrientation(10);
        return;
      }
      if (paramString.equalsIgnoreCase("reverseLandscape"))
      {
        setRequestedOrientation(8);
        return;
      }
      if (paramString.equalsIgnoreCase("reversePortrait"))
      {
        setRequestedOrientation(9);
        return;
      }
      if (paramString.equalsIgnoreCase("sensorLandscape"))
      {
        setRequestedOrientation(6);
        return;
      }
      if (paramString.equalsIgnoreCase("sensorPortrait"))
      {
        setRequestedOrientation(7);
        return;
      }
      dispatchErrorOccurredEvent(this, "ScreenOrientation", 901, new Object[] { paramString });
      return;
    }
    dispatchErrorOccurredEvent(this, "ScreenOrientation", 901, new Object[] { paramString });
  }
  
  @SimpleEvent(description="Screen orientation changed")
  public void ScreenOrientationChanged()
  {
    EventDispatcher.dispatchEvent(this, "ScreenOrientationChanged", new Object[0]);
  }
  
  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty
  public void Scrollable(boolean paramBoolean)
  {
    if ((this.scrollable == paramBoolean) && (this.frameLayout != null)) {
      return;
    }
    if (this.frameLayout != null) {
      this.frameLayout.removeAllViews();
    }
    this.scrollable = paramBoolean;
    if (paramBoolean) {}
    for (Object localObject = new ScrollView(this);; localObject = new FrameLayout(this))
    {
      this.frameLayout = ((FrameLayout)localObject);
      this.frameLayout.addView(this.viewLayout.getLayoutManager(), new ViewGroup.LayoutParams(-1, -1));
      this.frameLayout.setBackgroundColor(this.backgroundColor);
      if (this.backgroundDrawable != null) {
        ViewUtil.setBackgroundImage(this.frameLayout, this.backgroundDrawable);
      }
      setContentView(this.frameLayout);
      this.frameLayout.requestLayout();
      return;
    }
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="When checked, there will be a vertical scrollbar on the screen, and the height of the application can exceed the physical height of the device. When unchecked, the application height is constrained to the height of the device.")
  public boolean Scrollable()
  {
    return this.scrollable;
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The caption for the form, which apears in the title bar")
  public String Title()
  {
    return getTitle().toString();
  }
  
  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void Title(String paramString)
  {
    setTitle(paramString);
  }
  
  @DesignerProperty(defaultValue="1", editorType="non_negative_integer")
  @SimpleProperty(description="An integer value which must be incremented each time a new Android Application Package File (APK) is created for the Google Play Store.", userVisible=false)
  public void VersionCode(int paramInt) {}
  
  @DesignerProperty(defaultValue="1.0", editorType="string")
  @SimpleProperty(description="A string which can be changed to allow Google Play Store users to distinguish between different versions of the App.", userVisible=false)
  public void VersionName(String paramString) {}
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="Screen width (x-size).")
  public int Width()
  {
    return this.frameLayout.getWidth();
  }
  
  public void addAboutInfoToMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 2, "About this application").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        Form.this.showAboutApplicationNotification();
        return true;
      }
    }).setIcon(17301651);
  }
  
  public void addExitButtonToMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 1, "Stop this application").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        Form.this.showExitApplicationNotification();
        return true;
      }
    }).setIcon(17301594);
  }
  
  /* Error */
  public void callInitialize(Object paramObject)
    throws java.lang.Throwable
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 500	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: ldc_w 710
    //   7: aconst_null
    //   8: checkcast 712	[Ljava/lang/Class;
    //   11: invokevirtual 716	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   14: astore 5
    //   16: ldc 34
    //   18: new 200	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 718
    //   28: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 228	java/lang/Object:toString	()Ljava/lang/String;
    //   35: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 217	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   44: pop
    //   45: aload 5
    //   47: aload_1
    //   48: aconst_null
    //   49: checkcast 720	[Ljava/lang/Object;
    //   52: invokevirtual 726	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: return
    //   57: astore_3
    //   58: ldc 34
    //   60: new 200	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   67: ldc_w 728
    //   70: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_3
    //   74: invokevirtual 731	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   77: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 217	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   86: pop
    //   87: return
    //   88: astore_2
    //   89: return
    //   90: astore 6
    //   92: ldc 34
    //   94: new 200	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 733
    //   104: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 6
    //   109: invokevirtual 734	java/lang/reflect/InvocationTargetException:getMessage	()Ljava/lang/String;
    //   112: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 217	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   121: pop
    //   122: aload 6
    //   124: invokevirtual 738	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	Form
    //   0	128	1	paramObject	Object
    //   88	1	2	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   57	17	3	localSecurityException	java.lang.SecurityException
    //   14	32	5	localMethod	java.lang.reflect.Method
    //   90	33	6	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    // Exception table:
    //   from	to	target	type
    //   0	16	57	java/lang/SecurityException
    //   0	16	88	java/lang/NoSuchMethodException
    //   16	56	90	java/lang/reflect/InvocationTargetException
  }
  
  public boolean canDispatchEvent(Component paramComponent, String paramString)
  {
    if ((this.screenInitialized) || ((paramComponent == this) && (paramString.equals("Initialize")))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        activeForm = this;
      }
      return bool;
    }
  }
  
  public void clear()
  {
    this.viewLayout.getLayoutManager().removeAllViews();
    defaultPropertyValues();
    this.screenInitialized = false;
  }
  
  protected void closeApplicationFromBlocks()
  {
    closeApplication();
  }
  
  protected void closeForm(Intent paramIntent)
  {
    if (paramIntent != null) {
      setResult(-1, paramIntent);
    }
    finish();
    AnimationUtil.ApplyCloseScreenAnimation(this, this.closeAnimType);
  }
  
  public void deleteComponent(Object paramObject)
  {
    if ((paramObject instanceof OnStopListener))
    {
      OnStopListener localOnStopListener = (OnStopListener)paramObject;
      if (this.onStopListeners.contains(localOnStopListener)) {
        this.onStopListeners.remove(localOnStopListener);
      }
    }
    if ((paramObject instanceof OnResumeListener))
    {
      OnResumeListener localOnResumeListener = (OnResumeListener)paramObject;
      if (this.onResumeListeners.contains(localOnResumeListener)) {
        this.onResumeListeners.remove(localOnResumeListener);
      }
    }
    if ((paramObject instanceof OnPauseListener))
    {
      OnPauseListener localOnPauseListener = (OnPauseListener)paramObject;
      if (this.onPauseListeners.contains(localOnPauseListener)) {
        this.onPauseListeners.remove(localOnPauseListener);
      }
    }
    if ((paramObject instanceof OnDestroyListener))
    {
      OnDestroyListener localOnDestroyListener = (OnDestroyListener)paramObject;
      if (this.onDestroyListeners.contains(localOnDestroyListener)) {
        this.onDestroyListeners.remove(localOnDestroyListener);
      }
    }
    if ((paramObject instanceof Deleteable)) {
      ((Deleteable)paramObject).onDelete();
    }
  }
  
  public void dispatchErrorOccurredEvent(final Component paramComponent, final String paramString, final int paramInt, final Object... paramVarArgs)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        String str = ErrorMessages.formatMessage(paramInt, paramVarArgs);
        Form.this.ErrorOccurred(paramComponent, paramString, paramInt, str);
      }
    });
  }
  
  public void dispatchErrorOccurredEventDialog(final Component paramComponent, final String paramString, final int paramInt, final Object... paramVarArgs)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        String str = ErrorMessages.formatMessage(paramInt, paramVarArgs);
        Form.this.ErrorOccurredDialog(paramComponent, paramString, paramInt, str, "Error in " + paramString, "Dismiss");
      }
    });
  }
  
  public boolean dispatchEvent(Component paramComponent, String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public void dontGrabTouchEventsForComponent()
  {
    this.frameLayout.requestDisallowInterceptTouchEvent(true);
  }
  
  public Bundle fullScreenVideoAction(int paramInt, VideoPlayer paramVideoPlayer, Object paramObject)
  {
    try
    {
      Bundle localBundle = this.fullScreenVideoUtil.performAction(paramInt, paramVideoPlayer, paramObject);
      return localBundle;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public HandlesEventDispatching getDispatchDelegate()
  {
    return this;
  }
  
  public String getOpenAnimType()
  {
    return this.openAnimType;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.i("Form", "Form " + this.formName + " got onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2);
    String str;
    if (paramInt1 == 1) {
      if ((paramIntent != null) && (paramIntent.hasExtra("APP_INVENTOR_RESULT")))
      {
        str = paramIntent.getStringExtra("APP_INVENTOR_RESULT");
        Object localObject = decodeJSONStringForForm(str, "other screen closed");
        OtherScreenClosed(this.nextFormName, localObject);
      }
    }
    ActivityResultListener localActivityResultListener;
    do
    {
      return;
      str = "";
      break;
      localActivityResultListener = (ActivityResultListener)this.activityResultMap.get(Integer.valueOf(paramInt1));
    } while (localActivityResultListener == null);
    localActivityResultListener.resultReturned(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    final int i = paramConfiguration.orientation;
    if ((i == 2) || (i == 1)) {
      this.androidUIHandler.post(new Runnable()
      {
        public void run()
        {
          FrameLayout localFrameLayout = Form.this.frameLayout;
          int i = 0;
          if (localFrameLayout != null)
          {
            if (i != 2) {
              break label69;
            }
            int m = Form.this.frameLayout.getWidth();
            int n = Form.this.frameLayout.getHeight();
            i = 0;
            if (m >= n) {
              i = 1;
            }
          }
          while (i != 0)
          {
            Form.this.ScreenOrientationChanged();
            return;
            label69:
            int j = Form.this.frameLayout.getHeight();
            int k = Form.this.frameLayout.getWidth();
            i = 0;
            if (j >= k) {
              i = 1;
            }
          }
          Form.this.androidUIHandler.post(this);
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    String str = getClass().getName();
    this.formName = str.substring(1 + str.lastIndexOf('.'));
    Log.d("Form", "Form " + this.formName + " got onCreate");
    activeForm = this;
    Log.i("Form", "activeForm is now " + activeForm.formName);
    this.viewLayout = new LinearLayout(this, 1);
    this.alignmentSetter = new AlignmentUtil(this.viewLayout);
    defaultPropertyValues();
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("APP_INVENTOR_START"))) {
      this.startupValue = localIntent.getStringExtra("APP_INVENTOR_START");
    }
    this.fullScreenVideoUtil = new FullScreenVideoUtil(this, this.androidUIHandler);
    int i = getWindow().getAttributes().softInputMode;
    getWindow().setSoftInputMode(i | 0x10);
    $define();
    Initialize();
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    return this.fullScreenVideoUtil.createFullScreenVideoDialog();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    addExitButtonToMenu(paramMenu);
    addAboutInfoToMenu(paramMenu);
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Log.i("Form", "Form " + this.formName + " got onDestroy");
    EventDispatcher.removeDispatchDelegate(this);
    Iterator localIterator = this.onDestroyListeners.iterator();
    while (localIterator.hasNext()) {
      ((OnDestroyListener)localIterator.next()).onDestroy();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (!BackPressed())
      {
        boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
        AnimationUtil.ApplyCloseScreenAnimation(this, this.closeAnimType);
        return bool;
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Log.d("Form", "Form " + this.formName + " got onNewIntent " + paramIntent);
    Iterator localIterator = this.onNewIntentListeners.iterator();
    while (localIterator.hasNext()) {
      ((OnNewIntentListener)localIterator.next()).onNewIntent(paramIntent);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    Log.i("Form", "Form " + this.formName + " got onPause");
    Iterator localIterator = this.onPauseListeners.iterator();
    while (localIterator.hasNext()) {
      ((OnPauseListener)localIterator.next()).onPause();
    }
  }
  
  public void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default: 
      super.onPrepareDialog(paramInt, paramDialog);
      return;
    }
    this.fullScreenVideoUtil.prepareFullScreenVideoDialog(paramDialog);
  }
  
  protected void onResume()
  {
    super.onResume();
    Log.i("Form", "Form " + this.formName + " got onResume");
    activeForm = this;
    if (applicationIsBeingClosed) {
      closeApplication();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.onResumeListeners.iterator();
      while (localIterator.hasNext()) {
        ((OnResumeListener)localIterator.next()).onResume();
      }
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    Log.i("Form", "Form " + this.formName + " got onStop");
    Iterator localIterator = this.onStopListeners.iterator();
    while (localIterator.hasNext()) {
      ((OnStopListener)localIterator.next()).onStop();
    }
  }
  
  public int registerForActivityResult(ActivityResultListener paramActivityResultListener)
  {
    int i = generateNewRequestCode();
    this.activityResultMap.put(Integer.valueOf(i), paramActivityResultListener);
    return i;
  }
  
  public void registerForOnDestroy(OnDestroyListener paramOnDestroyListener)
  {
    this.onDestroyListeners.add(paramOnDestroyListener);
  }
  
  public void registerForOnInitialize(OnInitializeListener paramOnInitializeListener)
  {
    this.onInitializeListeners.add(paramOnInitializeListener);
  }
  
  public void registerForOnNewIntent(OnNewIntentListener paramOnNewIntentListener)
  {
    this.onNewIntentListeners.add(paramOnNewIntentListener);
  }
  
  public void registerForOnPause(OnPauseListener paramOnPauseListener)
  {
    this.onPauseListeners.add(paramOnPauseListener);
  }
  
  public void registerForOnResume(OnResumeListener paramOnResumeListener)
  {
    this.onResumeListeners.add(paramOnResumeListener);
  }
  
  public void registerForOnStop(OnStopListener paramOnStopListener)
  {
    this.onStopListeners.add(paramOnStopListener);
  }
  
  public void setChildHeight(AndroidViewComponent paramAndroidViewComponent, int paramInt)
  {
    ViewUtil.setChildHeightForVerticalLayout(paramAndroidViewComponent.getView(), paramInt);
  }
  
  public void setChildWidth(AndroidViewComponent paramAndroidViewComponent, int paramInt)
  {
    ViewUtil.setChildWidthForVerticalLayout(paramAndroidViewComponent.getView(), paramInt);
  }
  
  void setYandexTranslateTagline()
  {
    this.yandexTranslateTagline = "<p><small>Language translation powered by Yandex.Translate</small></p>";
  }
  
  protected void startNewForm(String paramString, Object paramObject)
  {
    Log.i("Form", "startNewForm:" + paramString);
    Intent localIntent = new Intent();
    localIntent.setClassName(this, getPackageName() + "." + paramString);
    String str1;
    String str2;
    if (paramObject == null)
    {
      str1 = "open another screen";
      if (paramObject == null) {
        break label235;
      }
      Log.i("Form", "StartNewForm about to JSON encode:" + paramObject);
      str2 = jsonEncodeForForm(paramObject, str1);
      Log.i("Form", "StartNewForm got JSON encoding:" + str2);
    }
    for (;;)
    {
      localIntent.putExtra("APP_INVENTOR_START", str2);
      this.nextFormName = paramString;
      Log.i("Form", "about to start new form" + paramString);
      try
      {
        Log.i("Form", "startNewForm starting activity:" + localIntent);
        startActivityForResult(localIntent, 1);
        AnimationUtil.ApplyOpenScreenAnimation(this, this.openAnimType);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        label235:
        dispatchErrorOccurredEvent(this, str1, 902, new Object[] { paramString });
      }
      str1 = "open another screen with start value";
      break;
      str2 = "";
    }
  }
  
  protected boolean toastAllowed()
  {
    long l = System.nanoTime();
    if (l > this.lastToastTime + minimumToastWait)
    {
      this.lastToastTime = l;
      return true;
    }
    return false;
  }
  
  public void unregisterForActivityResult(ActivityResultListener paramActivityResultListener)
  {
    ArrayList localArrayList = Lists.newArrayList();
    Iterator localIterator1 = this.activityResultMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      if (paramActivityResultListener.equals(localEntry.getValue())) {
        localArrayList.add(localEntry.getKey());
      }
    }
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
    {
      Integer localInteger = (Integer)localIterator2.next();
      this.activityResultMap.remove(localInteger);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.Form
 * JD-Core Version:    0.7.0.1
 */