package com.google.appinventor.components.runtime.collect;

import java.util.HashMap;
import java.util.TreeMap;

public class Maps
{
  public static <K, V> HashMap<K, V> newHashMap()
  {
    return new HashMap();
  }
  
  public static <K, V> TreeMap<K, V> newTreeMap()
  {
    return new TreeMap();
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.collect.Maps
 * JD-Core Version:    0.7.0.1
 */