package com.google.appinventor.components.runtime.util;

import java.util.Locale;

public abstract interface ITextToSpeech
{
  public abstract void onDestroy();
  
  public abstract void onResume();
  
  public abstract void onStop();
  
  public abstract void setPitch(float paramFloat);
  
  public abstract void setSpeechRate(float paramFloat);
  
  public abstract void speak(String paramString, Locale paramLocale);
  
  public static abstract interface TextToSpeechCallback
  {
    public abstract void onFailure();
    
    public abstract void onSuccess();
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.ITextToSpeech
 * JD-Core Version:    0.7.0.1
 */