package gnu.mapping;

import java.util.Map.Entry;

public abstract class NamedLocation
  extends IndirectableLocation
  implements Map.Entry, EnvironmentKey
{
  final Symbol name;
  NamedLocation next;
  final Object property;
  
  public NamedLocation(NamedLocation paramNamedLocation)
  {
    this.name = paramNamedLocation.name;
    this.property = paramNamedLocation.property;
  }
  
  public NamedLocation(Symbol paramSymbol, Object paramObject)
  {
    this.name = paramSymbol;
    this.property = paramObject;
  }
  
  public boolean entered()
  {
    return this.next != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof NamedLocation)) {
      break label28;
    }
    label28:
    Object localObject1;
    Object localObject2;
    do
    {
      NamedLocation localNamedLocation;
      do
      {
        do
        {
          return false;
          localNamedLocation = (NamedLocation)paramObject;
          if (this.name != null) {
            break;
          }
        } while (localNamedLocation.name != null);
      } while (this.property != localNamedLocation.property);
      localObject1 = getValue();
      localObject2 = localNamedLocation.getValue();
      if (localObject1 == localObject2)
      {
        return true;
        if (this.name.equals(localNamedLocation.name)) {
          break;
        }
        return false;
      }
    } while ((localObject1 == null) || (localObject2 == null));
    return localObject1.equals(localObject2);
  }
  
  public Environment getEnvironment()
  {
    for (NamedLocation localNamedLocation = this; localNamedLocation != null; localNamedLocation = localNamedLocation.next) {
      if (localNamedLocation.name == null)
      {
        Environment localEnvironment = (Environment)localNamedLocation.value;
        if (localEnvironment != null) {
          return localEnvironment;
        }
      }
    }
    return super.getEnvironment();
  }
  
  public final Object getKey()
  {
    if (this.property == null) {
      this = this.name;
    }
    return this;
  }
  
  public final Object getKeyProperty()
  {
    return this.property;
  }
  
  public final Symbol getKeySymbol()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    int i = this.name.hashCode() ^ System.identityHashCode(this.property);
    Object localObject = getValue();
    if (localObject != null) {
      i ^= localObject.hashCode();
    }
    return i;
  }
  
  public final boolean matches(EnvironmentKey paramEnvironmentKey)
  {
    return (Symbol.equals(paramEnvironmentKey.getKeySymbol(), this.name)) && (paramEnvironmentKey.getKeyProperty() == this.property);
  }
  
  public final boolean matches(Symbol paramSymbol, Object paramObject)
  {
    return (Symbol.equals(paramSymbol, this.name)) && (paramObject == this.property);
  }
  
  public void setRestore(Object paramObject)
  {
    for (;;)
    {
      try
      {
        if (this.value == INDIRECT_FLUIDS)
        {
          this.base.setRestore(paramObject);
          return;
        }
        if ((paramObject instanceof Location))
        {
          this.value = null;
          this.base = ((Location)paramObject);
          continue;
        }
        this.value = paramObject;
      }
      finally {}
      this.base = null;
    }
  }
  
  /* Error */
  public Object setWithSave(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	gnu/mapping/NamedLocation:value	Ljava/lang/Object;
    //   6: getstatic 80	gnu/mapping/NamedLocation:INDIRECT_FLUIDS	Ljava/lang/Object;
    //   9: if_acmpne +22 -> 31
    //   12: aload_0
    //   13: getfield 84	gnu/mapping/NamedLocation:base	Lgnu/mapping/Location;
    //   16: aload_1
    //   17: invokevirtual 92	gnu/mapping/Location:setWithSave	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: astore 6
    //   22: aload 6
    //   24: astore 5
    //   26: aload_0
    //   27: monitorexit
    //   28: aload 5
    //   30: areturn
    //   31: aload_0
    //   32: getfield 21	gnu/mapping/NamedLocation:name	Lgnu/mapping/Symbol;
    //   35: invokestatic 98	gnu/mapping/ThreadLocation:makeAnonymous	(Lgnu/mapping/Symbol;)Lgnu/mapping/ThreadLocation;
    //   38: astore_3
    //   39: aload_3
    //   40: getfield 102	gnu/mapping/ThreadLocation:global	Lgnu/mapping/SharedLocation;
    //   43: aload_0
    //   44: getfield 84	gnu/mapping/NamedLocation:base	Lgnu/mapping/Location;
    //   47: putfield 105	gnu/mapping/SharedLocation:base	Lgnu/mapping/Location;
    //   50: aload_3
    //   51: getfield 102	gnu/mapping/ThreadLocation:global	Lgnu/mapping/SharedLocation;
    //   54: aload_0
    //   55: getfield 46	gnu/mapping/NamedLocation:value	Ljava/lang/Object;
    //   58: putfield 106	gnu/mapping/SharedLocation:value	Ljava/lang/Object;
    //   61: aload_0
    //   62: aload_3
    //   63: invokevirtual 110	gnu/mapping/NamedLocation:setAlias	(Lgnu/mapping/Location;)V
    //   66: aload_3
    //   67: invokevirtual 114	gnu/mapping/ThreadLocation:getLocation	()Lgnu/mapping/NamedLocation;
    //   70: astore 4
    //   72: aload 4
    //   74: aload_1
    //   75: putfield 46	gnu/mapping/NamedLocation:value	Ljava/lang/Object;
    //   78: aload 4
    //   80: aconst_null
    //   81: putfield 84	gnu/mapping/NamedLocation:base	Lgnu/mapping/Location;
    //   84: aload_3
    //   85: getfield 102	gnu/mapping/ThreadLocation:global	Lgnu/mapping/SharedLocation;
    //   88: astore 5
    //   90: goto -64 -> 26
    //   93: astore_2
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_2
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	NamedLocation
    //   0	98	1	paramObject	Object
    //   93	4	2	localObject1	Object
    //   38	47	3	localThreadLocation	ThreadLocation
    //   70	9	4	localNamedLocation	NamedLocation
    //   24	65	5	localObject2	Object
    //   20	3	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	93	finally
    //   31	90	93	finally
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.NamedLocation
 * JD-Core Version:    0.7.0.1
 */