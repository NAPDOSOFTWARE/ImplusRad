package gnu.text;

import java.net.URI;

class URIStringPath
  extends URIPath
{
  String uriString;
  
  public URIStringPath(URI paramURI, String paramString)
  {
    super(paramURI);
    this.uriString = paramString;
  }
  
  public String toURIString()
  {
    return this.uriString;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.text.URIStringPath
 * JD-Core Version:    0.7.0.1
 */