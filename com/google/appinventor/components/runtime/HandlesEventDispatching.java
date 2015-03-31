package com.google.appinventor.components.runtime;

public abstract interface HandlesEventDispatching
{
  public abstract boolean canDispatchEvent(Component paramComponent, String paramString);
  
  public abstract boolean dispatchEvent(Component paramComponent, String paramString1, String paramString2, Object[] paramArrayOfObject);
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.HandlesEventDispatching
 * JD-Core Version:    0.7.0.1
 */