package gnu.mapping;

import gnu.lists.LList;
import gnu.lists.Pair;

public class PropertyLocation
  extends Location
{
  Pair pair;
  
  public static Object getProperty(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return getProperty(paramObject1, paramObject2, paramObject3, Environment.getCurrent());
  }
  
  public static Object getProperty(Object paramObject1, Object paramObject2, Object paramObject3, Environment paramEnvironment)
  {
    if (!(paramObject1 instanceof Symbol))
    {
      if ((paramObject1 instanceof String)) {
        paramObject1 = Namespace.getDefaultSymbol((String)paramObject1);
      }
    }
    else {
      return paramEnvironment.get((Symbol)paramObject1, paramObject2, paramObject3);
    }
    return plistGet(paramEnvironment.get(Symbol.PLIST, paramObject1, LList.Empty), paramObject2, paramObject3);
  }
  
  public static Object getPropertyList(Object paramObject)
  {
    return Environment.getCurrent().get(Symbol.PLIST, paramObject, LList.Empty);
  }
  
  public static Object getPropertyList(Object paramObject, Environment paramEnvironment)
  {
    return paramEnvironment.get(Symbol.PLIST, paramObject, LList.Empty);
  }
  
  public static Object plistGet(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    while ((paramObject1 instanceof Pair))
    {
      Pair localPair = (Pair)paramObject1;
      if (localPair.getCar() == paramObject2) {
        paramObject3 = ((Pair)localPair.getCdr()).getCar();
      }
    }
    return paramObject3;
  }
  
  public static Object plistPut(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Pair localPair2;
    for (Object localObject = paramObject1; (localObject instanceof Pair); localObject = localPair2.getCdr())
    {
      Pair localPair1 = (Pair)localObject;
      localPair2 = (Pair)localPair1.getCdr();
      if (localPair1.getCar() == paramObject2)
      {
        localPair2.setCar(paramObject3);
        return paramObject1;
      }
    }
    return new Pair(paramObject2, new Pair(paramObject3, paramObject1));
  }
  
  public static Object plistRemove(Object paramObject1, Object paramObject2)
  {
    Object localObject1 = null;
    Object localObject2 = paramObject1;
    for (;;)
    {
      Pair localPair2;
      if ((localObject2 instanceof Pair))
      {
        Pair localPair1 = (Pair)localObject2;
        localPair2 = (Pair)localPair1.getCdr();
        localObject2 = localPair2.getCdr();
        if (localPair1.getCar() != paramObject2) {
          break label57;
        }
        if (localObject1 == null) {
          paramObject1 = localObject2;
        }
      }
      else
      {
        return paramObject1;
      }
      localObject1.setCdr(localObject2);
      return paramObject1;
      label57:
      localObject1 = localPair2;
    }
  }
  
  public static void putProperty(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    putProperty(paramObject1, paramObject2, paramObject3, Environment.getCurrent());
  }
  
  public static void putProperty(Object paramObject1, Object paramObject2, Object paramObject3, Environment paramEnvironment)
  {
    if (!(paramObject1 instanceof Symbol))
    {
      if ((paramObject1 instanceof String)) {
        paramObject1 = Namespace.getDefaultSymbol((String)paramObject1);
      }
    }
    else
    {
      Location localLocation1 = paramEnvironment.lookup((Symbol)paramObject1, paramObject2);
      if (localLocation1 == null) {
        break label92;
      }
      Location localLocation3 = localLocation1.getBase();
      if (!(localLocation3 instanceof PropertyLocation)) {
        break label92;
      }
      ((PropertyLocation)localLocation3).set(paramObject3);
      return;
    }
    Location localLocation4 = paramEnvironment.getLocation(Symbol.PLIST, paramObject1);
    localLocation4.set(plistPut(localLocation4.get(LList.Empty), paramObject2, paramObject3));
    return;
    label92:
    Location localLocation2 = paramEnvironment.getLocation(Symbol.PLIST, paramObject1);
    Pair localPair = new Pair(paramObject3, localLocation2.get(LList.Empty));
    localLocation2.set(new Pair(paramObject2, localPair));
    PropertyLocation localPropertyLocation = new PropertyLocation();
    localPropertyLocation.pair = localPair;
    paramEnvironment.addLocation((Symbol)paramObject1, paramObject2, localPropertyLocation);
  }
  
  public static boolean removeProperty(Object paramObject1, Object paramObject2)
  {
    return removeProperty(paramObject1, paramObject2, Environment.getCurrent());
  }
  
  public static boolean removeProperty(Object paramObject1, Object paramObject2, Environment paramEnvironment)
  {
    Location localLocation = paramEnvironment.lookup(Symbol.PLIST, paramObject1);
    if (localLocation == null) {}
    Object localObject1;
    do
    {
      return false;
      localObject1 = localLocation.get(LList.Empty);
    } while (!(localObject1 instanceof Pair));
    Pair localPair1 = (Pair)localObject1;
    Pair localPair2 = null;
    label42:
    Object localObject3;
    if (localPair1.getCar() == paramObject2)
    {
      localObject3 = ((Pair)localPair1.getCdr()).getCdr();
      if (localPair2 != null) {
        break label123;
      }
      localLocation.set(localObject3);
    }
    for (;;)
    {
      if ((paramObject1 instanceof Symbol)) {
        paramEnvironment.remove((Symbol)paramObject1, paramObject2);
      }
      return true;
      Object localObject2 = localPair1.getCdr();
      if (!(localObject2 instanceof Pair)) {
        break;
      }
      localPair2 = localPair1;
      localPair1 = (Pair)localObject2;
      break label42;
      label123:
      localPair2.setCdr(localObject3);
    }
  }
  
  public static void setPropertyList(Object paramObject1, Object paramObject2)
  {
    setPropertyList(paramObject1, paramObject2, Environment.getCurrent());
  }
  
  /* Error */
  public static void setPropertyList(Object paramObject1, Object paramObject2, Environment paramEnvironment)
  {
    // Byte code:
    //   0: aload_2
    //   1: monitorenter
    //   2: aload_2
    //   3: getstatic 39	gnu/mapping/Symbol:PLIST	Lgnu/mapping/Symbol;
    //   6: aload_0
    //   7: invokevirtual 82	gnu/mapping/Environment:lookup	(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;
    //   10: astore 4
    //   12: aload_0
    //   13: instanceof 23
    //   16: ifeq +38 -> 54
    //   19: aload_0
    //   20: checkcast 23	gnu/mapping/Symbol
    //   23: astore 5
    //   25: aload 4
    //   27: getstatic 45	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   30: invokevirtual 94	gnu/mapping/Location:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: astore 6
    //   35: aload 6
    //   37: instanceof 53
    //   40: ifne +23 -> 63
    //   43: aload_1
    //   44: astore 7
    //   46: aload 7
    //   48: instanceof 53
    //   51: ifne +61 -> 112
    //   54: aload 4
    //   56: aload_1
    //   57: invokevirtual 97	gnu/mapping/Location:set	(Ljava/lang/Object;)V
    //   60: aload_2
    //   61: monitorexit
    //   62: return
    //   63: aload 6
    //   65: checkcast 53	gnu/lists/Pair
    //   68: astore 15
    //   70: aload 15
    //   72: invokevirtual 57	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   75: astore 16
    //   77: aload_1
    //   78: aload 16
    //   80: aconst_null
    //   81: invokestatic 48	gnu/mapping/PropertyLocation:plistGet	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   84: ifnull +12 -> 96
    //   87: aload_2
    //   88: aload 5
    //   90: aload 16
    //   92: invokevirtual 113	gnu/mapping/Environment:remove	(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: pop
    //   96: aload 15
    //   98: invokevirtual 60	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   101: checkcast 53	gnu/lists/Pair
    //   104: invokevirtual 60	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   107: astore 6
    //   109: goto -74 -> 35
    //   112: aload 7
    //   114: checkcast 53	gnu/lists/Pair
    //   117: astore 8
    //   119: aload 8
    //   121: invokevirtual 57	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   124: astore 9
    //   126: aload_2
    //   127: aload 5
    //   129: aload 9
    //   131: invokevirtual 82	gnu/mapping/Environment:lookup	(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;
    //   134: astore 10
    //   136: aload 10
    //   138: ifnull +52 -> 190
    //   141: aload 10
    //   143: invokevirtual 86	gnu/mapping/Location:getBase	()Lgnu/mapping/Location;
    //   146: astore 11
    //   148: aload 11
    //   150: instanceof 2
    //   153: ifeq +37 -> 190
    //   156: aload 11
    //   158: checkcast 2	gnu/mapping/PropertyLocation
    //   161: astore 12
    //   163: aload 8
    //   165: invokevirtual 60	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   168: checkcast 53	gnu/lists/Pair
    //   171: astore 14
    //   173: aload 12
    //   175: aload 14
    //   177: putfield 100	gnu/mapping/PropertyLocation:pair	Lgnu/lists/Pair;
    //   180: aload 14
    //   182: invokevirtual 60	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   185: astore 7
    //   187: goto -141 -> 46
    //   190: new 2	gnu/mapping/PropertyLocation
    //   193: dup
    //   194: invokespecial 98	gnu/mapping/PropertyLocation:<init>	()V
    //   197: astore 12
    //   199: aload_2
    //   200: aload 5
    //   202: aload 9
    //   204: aload 12
    //   206: invokevirtual 104	gnu/mapping/Environment:addLocation	(Lgnu/mapping/Symbol;Ljava/lang/Object;Lgnu/mapping/Location;)Lgnu/mapping/NamedLocation;
    //   209: pop
    //   210: goto -47 -> 163
    //   213: astore_3
    //   214: aload_2
    //   215: monitorexit
    //   216: aload_3
    //   217: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramObject1	Object
    //   0	218	1	paramObject2	Object
    //   0	218	2	paramEnvironment	Environment
    //   213	4	3	localObject1	Object
    //   10	45	4	localLocation1	Location
    //   23	178	5	localSymbol	Symbol
    //   33	75	6	localObject2	Object
    //   44	142	7	localObject3	Object
    //   117	47	8	localPair1	Pair
    //   124	79	9	localObject4	Object
    //   134	8	10	localLocation2	Location
    //   146	11	11	localLocation3	Location
    //   161	44	12	localPropertyLocation	PropertyLocation
    //   171	10	14	localPair2	Pair
    //   68	29	15	localPair3	Pair
    //   75	16	16	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	213	finally
    //   35	43	213	finally
    //   46	54	213	finally
    //   54	62	213	finally
    //   63	96	213	finally
    //   96	109	213	finally
    //   112	136	213	finally
    //   141	163	213	finally
    //   163	187	213	finally
    //   190	210	213	finally
    //   214	216	213	finally
  }
  
  public final Object get(Object paramObject)
  {
    return this.pair.getCar();
  }
  
  public boolean isBound()
  {
    return true;
  }
  
  public final void set(Object paramObject)
  {
    this.pair.setCar(paramObject);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.PropertyLocation
 * JD-Core Version:    0.7.0.1
 */