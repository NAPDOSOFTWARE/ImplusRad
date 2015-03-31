package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ModuleContext;
import gnu.mapping.SimpleSymbol;
import kawa.lang.SyntaxForm;

public class IfFeature
{
  public static boolean hasFeature(String paramString)
  {
    if (paramString == "kawa") {}
    label143:
    Declaration localDeclaration;
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return true;
          } while ((paramString == "srfi-0") || (paramString == "srfi-4") || (paramString == "srfi-6") || (paramString == "srfi-8") || (paramString == "srfi-9") || (paramString == "srfi-11") || (paramString == "srfi-16") || (paramString == "srfi-17") || (paramString == "srfi-23") || (paramString == "srfi-25") || (paramString == "srfi-26") || (paramString == "srfi-28") || (paramString == "srfi-30") || (paramString == "srfi-39"));
          if ((paramString != "in-http-server") && (paramString != "in-servlet")) {
            break label143;
          }
          i = ModuleContext.getContext().getFlags();
          if (paramString != "in-http-server") {
            break;
          }
        } while ((i & ModuleContext.IN_HTTP_SERVER) != 0);
        return false;
        if (paramString != "in-servlet") {
          break;
        }
      } while ((i & ModuleContext.IN_SERVLET) != 0);
      return false;
      String str = ("%provide%" + paramString).intern();
      localDeclaration = Compilation.getCurrent().lookup(str, -1);
    } while ((localDeclaration != null) && (!localDeclaration.getFlag(65536L)));
    return false;
  }
  
  public static boolean testFeature(Object paramObject)
  {
    if ((paramObject instanceof SyntaxForm)) {
      paramObject = ((SyntaxForm)paramObject).getDatum();
    }
    if (((paramObject instanceof String)) || ((paramObject instanceof SimpleSymbol))) {
      return hasFeature(paramObject.toString());
    }
    return false;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.IfFeature
 * JD-Core Version:    0.7.0.1
 */