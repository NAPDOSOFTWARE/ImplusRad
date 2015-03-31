package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.SimpleObject;

@SimpleObject
public abstract class AndroidNonvisibleComponent
  implements Component
{
  protected final Form form;
  
  protected AndroidNonvisibleComponent(Form paramForm)
  {
    this.form = paramForm;
  }
  
  public HandlesEventDispatching getDispatchDelegate()
  {
    return this.form;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.AndroidNonvisibleComponent
 * JD-Core Version:    0.7.0.1
 */