package gnu.mapping;

public class ThreadLocation
  extends NamedLocation
  implements Named
{
  public static final String ANONYMOUS = new String("(dynamic)");
  static int counter;
  static SimpleEnvironment env;
  SharedLocation global;
  private int hash;
  private ThreadLocal<NamedLocation> thLocal;
  
  public ThreadLocation()
  {
    this("param#" + nextCounter());
  }
  
  private ThreadLocation(Symbol paramSymbol)
  {
    super(paramSymbol, ANONYMOUS);
    this.thLocal = new InheritingLocation();
    if (paramSymbol == null) {}
    for (String str = null;; str = paramSymbol.toString())
    {
      this.global = new SharedLocation(Symbol.makeUninterned(str), null, 0);
      return;
    }
  }
  
  public ThreadLocation(Symbol paramSymbol, Object paramObject, SharedLocation paramSharedLocation)
  {
    super(paramSymbol, paramObject);
    this.hash = (paramSymbol.hashCode() ^ System.identityHashCode(paramObject));
    this.global = paramSharedLocation;
  }
  
  public ThreadLocation(String paramString)
  {
    super(Symbol.makeUninterned(paramString), ANONYMOUS);
    this.thLocal = new InheritingLocation();
    this.global = new SharedLocation(this.name, null, 0);
  }
  
  /* Error */
  public static ThreadLocation getInstance(Symbol paramSymbol, Object paramObject)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 97	gnu/mapping/ThreadLocation:env	Lgnu/mapping/SimpleEnvironment;
    //   6: ifnonnull +15 -> 21
    //   9: new 99	gnu/mapping/SimpleEnvironment
    //   12: dup
    //   13: ldc 101
    //   15: invokespecial 102	gnu/mapping/SimpleEnvironment:<init>	(Ljava/lang/String;)V
    //   18: putstatic 97	gnu/mapping/ThreadLocation:env	Lgnu/mapping/SimpleEnvironment;
    //   21: getstatic 97	gnu/mapping/ThreadLocation:env	Lgnu/mapping/SimpleEnvironment;
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 106	gnu/mapping/SimpleEnvironment:getLocation	(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;
    //   29: checkcast 108	gnu/mapping/IndirectableLocation
    //   32: astore_3
    //   33: aload_3
    //   34: getfield 112	gnu/mapping/IndirectableLocation:base	Lgnu/mapping/Location;
    //   37: ifnull +18 -> 55
    //   40: aload_3
    //   41: getfield 112	gnu/mapping/IndirectableLocation:base	Lgnu/mapping/Location;
    //   44: checkcast 2	gnu/mapping/ThreadLocation
    //   47: astore 5
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload 5
    //   54: areturn
    //   55: new 2	gnu/mapping/ThreadLocation
    //   58: dup
    //   59: aload_0
    //   60: aload_1
    //   61: aconst_null
    //   62: invokespecial 114	gnu/mapping/ThreadLocation:<init>	(Lgnu/mapping/Symbol;Ljava/lang/Object;Lgnu/mapping/SharedLocation;)V
    //   65: astore 4
    //   67: aload_3
    //   68: aload 4
    //   70: putfield 112	gnu/mapping/IndirectableLocation:base	Lgnu/mapping/Location;
    //   73: aload 4
    //   75: astore 5
    //   77: goto -28 -> 49
    //   80: astore_2
    //   81: ldc 2
    //   83: monitorexit
    //   84: aload_2
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramSymbol	Symbol
    //   0	86	1	paramObject	Object
    //   80	5	2	localObject1	Object
    //   32	36	3	localIndirectableLocation	IndirectableLocation
    //   65	9	4	localThreadLocation	ThreadLocation
    //   47	29	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	21	80	finally
    //   21	49	80	finally
    //   55	73	80	finally
  }
  
  public static ThreadLocation makeAnonymous(Symbol paramSymbol)
  {
    return new ThreadLocation(paramSymbol);
  }
  
  public static ThreadLocation makeAnonymous(String paramString)
  {
    return new ThreadLocation(paramString);
  }
  
  private static int nextCounter()
  {
    try
    {
      int i = 1 + counter;
      counter = i;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Object get(Object paramObject)
  {
    return getLocation().get(paramObject);
  }
  
  public NamedLocation getLocation()
  {
    NamedLocation localNamedLocation;
    if (this.property != ANONYMOUS) {
      localNamedLocation = Environment.getCurrent().getLocation(this.name, this.property, this.hash, true);
    }
    do
    {
      return localNamedLocation;
      localNamedLocation = (NamedLocation)this.thLocal.get();
    } while (localNamedLocation != null);
    SharedLocation localSharedLocation = new SharedLocation(this.name, this.property, 0);
    if (this.global != null) {
      localSharedLocation.setBase(this.global);
    }
    this.thLocal.set(localSharedLocation);
    return localSharedLocation;
  }
  
  public String getName()
  {
    if (this.name == null) {
      return null;
    }
    return this.name.toString();
  }
  
  public Object getSymbol()
  {
    if ((this.name != null) && (this.property == ANONYMOUS) && (this.global.getKeySymbol() == this.name)) {
      return this.name.toString();
    }
    return this.name;
  }
  
  public void set(Object paramObject)
  {
    getLocation().set(paramObject);
  }
  
  public void setGlobal(Object paramObject)
  {
    try
    {
      if (this.global == null) {
        this.global = new SharedLocation(this.name, null, 0);
      }
      this.global.set(paramObject);
      return;
    }
    finally {}
  }
  
  public void setName(String paramString)
  {
    throw new RuntimeException("setName not allowed");
  }
  
  public void setRestore(Object paramObject)
  {
    getLocation().setRestore(paramObject);
  }
  
  public Object setWithSave(Object paramObject)
  {
    return getLocation().setWithSave(paramObject);
  }
  
  public class InheritingLocation
    extends InheritableThreadLocal<NamedLocation>
  {
    public InheritingLocation() {}
    
    protected SharedLocation childValue(NamedLocation paramNamedLocation)
    {
      if (ThreadLocation.this.property != ThreadLocation.ANONYMOUS) {
        throw new Error();
      }
      if (paramNamedLocation == null) {
        paramNamedLocation = (SharedLocation)ThreadLocation.this.getLocation();
      }
      Object localObject = paramNamedLocation;
      if (((NamedLocation)localObject).base == null)
      {
        SharedLocation localSharedLocation1 = new SharedLocation(ThreadLocation.this.name, ThreadLocation.this.property, 0);
        localSharedLocation1.value = ((NamedLocation)localObject).value;
        ((NamedLocation)localObject).base = localSharedLocation1;
        ((NamedLocation)localObject).value = null;
        localObject = localSharedLocation1;
      }
      SharedLocation localSharedLocation2 = new SharedLocation(ThreadLocation.this.name, ThreadLocation.this.property, 0);
      localSharedLocation2.value = null;
      localSharedLocation2.base = ((Location)localObject);
      return localSharedLocation2;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.ThreadLocation
 * JD-Core Version:    0.7.0.1
 */