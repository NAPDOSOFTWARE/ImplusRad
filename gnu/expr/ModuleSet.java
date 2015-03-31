package gnu.expr;

public abstract class ModuleSet
{
  public static final String MODULES_MAP = "$ModulesMap$";
  ModuleSet next;
  
  public abstract void register(ModuleManager paramModuleManager);
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ModuleSet
 * JD-Core Version:    0.7.0.1
 */