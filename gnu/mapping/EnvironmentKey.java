package gnu.mapping;

public abstract interface EnvironmentKey
{
  public static final Object FUNCTION = Symbol.FUNCTION;
  
  public abstract Object getKeyProperty();
  
  public abstract Symbol getKeySymbol();
  
  public abstract boolean matches(EnvironmentKey paramEnvironmentKey);
  
  public abstract boolean matches(Symbol paramSymbol, Object paramObject);
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.EnvironmentKey
 * JD-Core Version:    0.7.0.1
 */