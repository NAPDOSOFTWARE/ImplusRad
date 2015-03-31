package gnu.bytecode;

public abstract interface Member
{
  public abstract ClassType getDeclaringClass();
  
  public abstract int getModifiers();
  
  public abstract String getName();
  
  public abstract boolean getStaticFlag();
  
  public abstract void setName(String paramString);
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.Member
 * JD-Core Version:    0.7.0.1
 */