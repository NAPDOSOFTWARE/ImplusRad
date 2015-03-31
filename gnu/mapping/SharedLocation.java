package gnu.mapping;

public class SharedLocation
  extends NamedLocation
{
  int timestamp;
  
  public SharedLocation(Symbol paramSymbol, Object paramObject, int paramInt)
  {
    super(paramSymbol, paramObject);
    this.timestamp = paramInt;
  }
  
  /* Error */
  public final Object get(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	gnu/mapping/SharedLocation:base	Lgnu/mapping/Location;
    //   6: ifnull +18 -> 24
    //   9: aload_0
    //   10: getfield 19	gnu/mapping/SharedLocation:base	Lgnu/mapping/Location;
    //   13: aload_1
    //   14: invokevirtual 23	gnu/mapping/Location:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: astore_3
    //   18: aload_3
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: aload_0
    //   25: getfield 27	gnu/mapping/SharedLocation:value	Ljava/lang/Object;
    //   28: getstatic 31	gnu/mapping/Location:UNBOUND	Ljava/lang/String;
    //   31: if_acmpeq -11 -> 20
    //   34: aload_0
    //   35: getfield 27	gnu/mapping/SharedLocation:value	Ljava/lang/Object;
    //   38: astore_1
    //   39: goto -19 -> 20
    //   42: astore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_2
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	SharedLocation
    //   0	47	1	paramObject	Object
    //   42	4	2	localObject1	Object
    //   17	2	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	42	finally
    //   24	39	42	finally
  }
  
  /* Error */
  public boolean isBound()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	gnu/mapping/SharedLocation:base	Lgnu/mapping/Location;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 19	gnu/mapping/SharedLocation:base	Lgnu/mapping/Location;
    //   13: invokevirtual 35	gnu/mapping/Location:isBound	()Z
    //   16: istore 5
    //   18: iload 5
    //   20: istore 4
    //   22: aload_0
    //   23: monitorexit
    //   24: iload 4
    //   26: ireturn
    //   27: aload_0
    //   28: getfield 27	gnu/mapping/SharedLocation:value	Ljava/lang/Object;
    //   31: astore_2
    //   32: getstatic 31	gnu/mapping/Location:UNBOUND	Ljava/lang/String;
    //   35: astore_3
    //   36: aload_2
    //   37: aload_3
    //   38: if_acmpeq +9 -> 47
    //   41: iconst_1
    //   42: istore 4
    //   44: goto -22 -> 22
    //   47: iconst_0
    //   48: istore 4
    //   50: goto -28 -> 22
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	SharedLocation
    //   53	4	1	localObject1	Object
    //   31	6	2	localObject2	Object
    //   35	3	3	str	java.lang.String
    //   20	29	4	bool1	boolean
    //   16	3	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	53	finally
    //   27	36	53	finally
  }
  
  public final void set(Object paramObject)
  {
    for (;;)
    {
      try
      {
        if (this.base == null)
        {
          this.value = paramObject;
          return;
        }
        if (this.value == DIRECT_ON_SET)
        {
          this.base = null;
          this.value = paramObject;
          continue;
        }
        if (!this.base.isConstant()) {
          break label74;
        }
      }
      finally {}
      getEnvironment().put(getKeySymbol(), getKeyProperty(), paramObject);
      continue;
      label74:
      this.base.set(paramObject);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.SharedLocation
 * JD-Core Version:    0.7.0.1
 */