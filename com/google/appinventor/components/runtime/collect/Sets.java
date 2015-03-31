package com.google.appinventor.components.runtime.collect;

import java.util.Collections;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Sets
{
  public static <K> HashSet<K> newHashSet()
  {
    return new HashSet();
  }
  
  public static <E> HashSet<E> newHashSet(E... paramVarArgs)
  {
    HashSet localHashSet = new HashSet(1 + 4 * paramVarArgs.length / 3);
    Collections.addAll(localHashSet, paramVarArgs);
    return localHashSet;
  }
  
  public static <E> SortedSet<E> newSortedSet(E... paramVarArgs)
  {
    TreeSet localTreeSet = new TreeSet();
    Collections.addAll(localTreeSet, paramVarArgs);
    return localTreeSet;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.collect.Sets
 * JD-Core Version:    0.7.0.1
 */