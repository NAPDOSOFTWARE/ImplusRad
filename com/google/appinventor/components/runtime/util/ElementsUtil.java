package com.google.appinventor.components.runtime.util;

import com.google.appinventor.components.runtime.errors.YailRuntimeError;

public class ElementsUtil
{
  public static YailList elements(YailList paramYailList, String paramString)
  {
    String[] arrayOfString = paramYailList.toStringArray();
    for (int i = 0; i < arrayOfString.length; i++) {
      if (!(arrayOfString[i] instanceof String)) {
        throw new YailRuntimeError("Items passed to " + paramString + " must be Strings", "Error");
      }
    }
    return paramYailList;
  }
  
  public static YailList elementsFromString(String paramString)
  {
    YailList localYailList = new YailList();
    if (paramString.length() > 0) {
      localYailList = YailList.makeList((Object[])paramString.split(" *, *"));
    }
    return localYailList;
  }
  
  public static int selectionIndex(int paramInt, YailList paramYailList)
  {
    if ((paramInt <= 0) || (paramInt > paramYailList.size())) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  public static int setSelectedIndexFromValue(String paramString, YailList paramYailList)
  {
    for (int i = 0; i < paramYailList.size(); i++) {
      if (paramYailList.getString(i).equals(paramString)) {
        return i + 1;
      }
    }
    return 0;
  }
  
  public static String setSelectionFromIndex(int paramInt, YailList paramYailList)
  {
    if (paramInt == 0) {
      return "";
    }
    return paramYailList.getString(paramInt - 1);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.ElementsUtil
 * JD-Core Version:    0.7.0.1
 */