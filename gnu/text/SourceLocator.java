package gnu.text;

import org.xml.sax.Locator;

public abstract interface SourceLocator
  extends Locator
{
  public abstract int getColumnNumber();
  
  public abstract String getFileName();
  
  public abstract int getLineNumber();
  
  public abstract String getPublicId();
  
  public abstract String getSystemId();
  
  public abstract boolean isStableSourceLocation();
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.text.SourceLocator
 * JD-Core Version:    0.7.0.1
 */