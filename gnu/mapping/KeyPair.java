package gnu.mapping;

public class KeyPair
  implements EnvironmentKey
{
  Symbol name;
  Object property;
  
  public KeyPair(Symbol paramSymbol, Object paramObject)
  {
    this.name = paramSymbol;
    this.property = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof KeyPair)) {}
    KeyPair localKeyPair;
    do
    {
      do
      {
        return false;
        localKeyPair = (KeyPair)paramObject;
      } while (this.property != localKeyPair.property);
      if (this.name != null) {
        break;
      }
    } while (localKeyPair.name != null);
    for (;;)
    {
      return true;
      if (!this.name.equals(localKeyPair.name)) {
        break;
      }
    }
  }
  
  public Object getKeyProperty()
  {
    return this.property;
  }
  
  public Symbol getKeySymbol()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    return this.name.hashCode() ^ System.identityHashCode(this.property);
  }
  
  public final boolean matches(EnvironmentKey paramEnvironmentKey)
  {
    return (Symbol.equals(paramEnvironmentKey.getKeySymbol(), this.name)) && (paramEnvironmentKey.getKeyProperty() == this.property);
  }
  
  public final boolean matches(Symbol paramSymbol, Object paramObject)
  {
    return (Symbol.equals(paramSymbol, this.name)) && (paramObject == this.property);
  }
  
  public String toString()
  {
    return "KeyPair[sym:" + this.name + " prop:" + this.property + "]";
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.KeyPair
 * JD-Core Version:    0.7.0.1
 */