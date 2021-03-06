package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import java.util.List;

public class Setter
  extends Procedure1
  implements HasSetter
{
  public static final Setter setter = new Setter();
  
  static
  {
    setter.setName("setter");
    setter.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompilationHelpers:validateSetter");
  }
  
  public static Object setter(Procedure paramProcedure)
  {
    return paramProcedure.getSetter();
  }
  
  public Object apply1(Object paramObject)
  {
    if (!(paramObject instanceof Procedure))
    {
      if ((paramObject instanceof List)) {
        return new SetList((List)paramObject);
      }
      if (paramObject.getClass().isArray()) {
        return new SetArray(paramObject, Language.getDefaultLanguage());
      }
    }
    return ((Procedure)paramObject).getSetter();
  }
  
  public void set1(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    ((Procedure)paramObject1).setSetter((Procedure)paramObject2);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.Setter
 * JD-Core Version:    0.7.0.1
 */