package com.google.appinventor.components.runtime.collect;

import java.util.ArrayList;
import java.util.Collections;

public class Lists
{
  public static <E> ArrayList<E> newArrayList()
  {
    return new ArrayList();
  }
  
  public static <E> ArrayList<E> newArrayList(E... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(5 + 110 * paramVarArgs.length / 100);
    Collections.addAll(localArrayList, paramVarArgs);
    return localArrayList;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.collect.Lists
 * JD-Core Version:    0.7.0.1
 */