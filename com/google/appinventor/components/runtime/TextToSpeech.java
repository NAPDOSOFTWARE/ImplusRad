package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.collect.Maps;
import com.google.appinventor.components.runtime.util.ExternalTextToSpeech;
import com.google.appinventor.components.runtime.util.ITextToSpeech;
import com.google.appinventor.components.runtime.util.ITextToSpeech.TextToSpeechCallback;
import com.google.appinventor.components.runtime.util.InternalTextToSpeech;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;

@DesignerComponent(category=ComponentCategory.MEDIA, description="Component for using TextToSpeech to speak a message", iconName="images/textToSpeech.png", nonVisible=true, version=2)
@SimpleObject
public class TextToSpeech
  extends AndroidNonvisibleComponent
  implements Component, OnStopListener, OnResumeListener, OnDestroyListener
{
  private static final String LOG_TAG = "TextToSpeech";
  private static final Map<String, Locale> iso3CountryToLocaleMap;
  private static final Map<String, Locale> iso3LanguageToLocaleMap = ;
  private String country;
  private String iso2Country;
  private String iso2Language;
  private String language;
  private float pitch = 1.0F;
  private boolean result = false;
  private float speechRate = 1.0F;
  private final ITextToSpeech tts;
  
  static
  {
    iso3CountryToLocaleMap = Maps.newHashMap();
    initLocaleMaps();
  }
  
  public TextToSpeech(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    Language("");
    Country("");
    int i = SdkLevel.getLevel();
    int j = 0;
    if (i < 4) {
      j = 1;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("Using ");
    String str;
    ITextToSpeech.TextToSpeechCallback local1;
    if (j != 0)
    {
      str = "external";
      Log.v("TextToSpeech", str + " TTS library.");
      local1 = new ITextToSpeech.TextToSpeechCallback()
      {
        public void onFailure()
        {
          TextToSpeech.access$002(TextToSpeech.this, false);
          TextToSpeech.this.AfterSpeaking(false);
        }
        
        public void onSuccess()
        {
          TextToSpeech.access$002(TextToSpeech.this, true);
          TextToSpeech.this.AfterSpeaking(true);
        }
      };
      if (j == 0) {
        break label165;
      }
    }
    label165:
    for (Object localObject = new ExternalTextToSpeech(paramComponentContainer, local1);; localObject = new InternalTextToSpeech(paramComponentContainer.$context(), local1))
    {
      this.tts = ((ITextToSpeech)localObject);
      this.form.registerForOnStop(this);
      this.form.registerForOnResume(this);
      this.form.registerForOnDestroy(this);
      this.form.setVolumeControlStream(3);
      return;
      str = "internal";
      break;
    }
  }
  
  private static void initLocaleMaps()
  {
    Locale[] arrayOfLocale = Locale.getAvailableLocales();
    int i = arrayOfLocale.length;
    int j = 0;
    for (;;)
    {
      Locale localLocale;
      if (j < i) {
        localLocale = arrayOfLocale[j];
      }
      try
      {
        String str2 = localLocale.getISO3Country();
        if (str2.length() > 0) {
          iso3CountryToLocaleMap.put(str2, localLocale);
        }
        try
        {
          label44:
          String str1 = localLocale.getISO3Language();
          if (str1.length() > 0) {
            iso3LanguageToLocaleMap.put(str1, localLocale);
          }
          label70:
          j++;
          continue;
          return;
        }
        catch (MissingResourceException localMissingResourceException2)
        {
          break label70;
        }
      }
      catch (MissingResourceException localMissingResourceException1)
      {
        break label44;
      }
    }
  }
  
  private static Locale iso3CountryToLocale(String paramString)
  {
    Locale localLocale = (Locale)iso3CountryToLocaleMap.get(paramString);
    if (localLocale == null) {
      localLocale = (Locale)iso3CountryToLocaleMap.get(paramString.toUpperCase(Locale.ENGLISH));
    }
    if (localLocale == null) {
      localLocale = Locale.getDefault();
    }
    return localLocale;
  }
  
  private static Locale iso3LanguageToLocale(String paramString)
  {
    Locale localLocale = (Locale)iso3LanguageToLocaleMap.get(paramString);
    if (localLocale == null) {
      localLocale = (Locale)iso3LanguageToLocaleMap.get(paramString.toLowerCase(Locale.ENGLISH));
    }
    if (localLocale == null) {
      localLocale = Locale.getDefault();
    }
    return localLocale;
  }
  
  @SimpleEvent
  public void AfterSpeaking(boolean paramBoolean)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Boolean.valueOf(paramBoolean);
    EventDispatcher.dispatchEvent(this, "AfterSpeaking", arrayOfObject);
  }
  
  @SimpleEvent
  public void BeforeSpeaking()
  {
    EventDispatcher.dispatchEvent(this, "BeforeSpeaking", new Object[0]);
  }
  
  @SimpleProperty
  public String Country()
  {
    return this.country;
  }
  
  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public void Country(String paramString)
  {
    Locale localLocale;
    switch (paramString.length())
    {
    default: 
      localLocale = Locale.getDefault();
      this.country = localLocale.getCountry();
    }
    for (;;)
    {
      this.iso2Country = localLocale.getCountry();
      return;
      localLocale = iso3CountryToLocale(paramString);
      this.country = localLocale.getISO3Country();
      continue;
      localLocale = new Locale(paramString);
      this.country = localLocale.getCountry();
    }
  }
  
  @SimpleProperty
  public String Language()
  {
    return this.language;
  }
  
  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Sets the language for TextToSpeech")
  public void Language(String paramString)
  {
    Locale localLocale;
    switch (paramString.length())
    {
    default: 
      localLocale = Locale.getDefault();
      this.language = localLocale.getLanguage();
    }
    for (;;)
    {
      this.iso2Language = localLocale.getLanguage();
      return;
      localLocale = iso3LanguageToLocale(paramString);
      this.language = localLocale.getISO3Language();
      continue;
      localLocale = new Locale(paramString);
      this.language = localLocale.getLanguage();
    }
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Returns current value of Pitch")
  public float Pitch()
  {
    return this.pitch;
  }
  
  @DesignerProperty(defaultValue="1.0", editorType="float")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Sets the Pitch for tts. The values should be between 0 and 2 where lower values lower the tone of synthesized voice and greater values increases it")
  public void Pitch(float paramFloat)
  {
    if ((paramFloat < 0.0F) || (paramFloat > 2.0F))
    {
      Log.i("TextToSpeech", "Pitch value should be between 0 and 2, but user specified: " + paramFloat);
      return;
    }
    this.pitch = paramFloat;
    ITextToSpeech localITextToSpeech = this.tts;
    if (paramFloat == 0.0F) {
      paramFloat = 0.1F;
    }
    localITextToSpeech.setPitch(paramFloat);
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public boolean Result()
  {
    return this.result;
  }
  
  @SimpleFunction
  public void Speak(String paramString)
  {
    BeforeSpeaking();
    Locale localLocale = new Locale(this.iso2Language, this.iso2Country);
    this.tts.speak(paramString, localLocale);
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Returns current value of SpeechRate")
  public float SpeechRate()
  {
    return this.speechRate;
  }
  
  @DesignerProperty(defaultValue="1.0", editorType="float")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Sets the SpeechRate for tts. The values should be between 0 and 2 where lower values slow down the pitch and greater values accelerate it")
  public void SpeechRate(float paramFloat)
  {
    if ((paramFloat < 0.0F) || (paramFloat > 2.0F))
    {
      Log.i("TextToSpeech", "speechRate value should be between 0 and 2, but user specified: " + paramFloat);
      return;
    }
    this.speechRate = paramFloat;
    ITextToSpeech localITextToSpeech = this.tts;
    if (paramFloat == 0.0F) {
      paramFloat = 0.1F;
    }
    localITextToSpeech.setSpeechRate(paramFloat);
  }
  
  public void onDestroy()
  {
    this.tts.onDestroy();
  }
  
  public void onResume()
  {
    this.tts.onResume();
  }
  
  public void onStop()
  {
    this.tts.onStop();
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.TextToSpeech
 * JD-Core Version:    0.7.0.1
 */