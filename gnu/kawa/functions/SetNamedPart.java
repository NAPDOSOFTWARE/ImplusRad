package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.reflect.SlotSet;
import gnu.mapping.Environment;
import gnu.mapping.HasSetter;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure3;
import gnu.mapping.Symbol;
import gnu.mapping.Values;

public class SetNamedPart
  extends Procedure3
  implements HasSetter
{
  public static final SetNamedPart setNamedPart = new SetNamedPart();
  
  static
  {
    setNamedPart.setName("setNamedPart");
    setNamedPart.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateSetNamedPart");
  }
  
  public Object apply3(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Namespace localNamespace;
    if ((paramObject1 instanceof Namespace))
    {
      localNamespace = (Namespace)paramObject1;
      String str = localNamespace.getName();
      if (str.startsWith("class:")) {
        paramObject1 = ClassType.make(str.substring(6));
      }
    }
    else
    {
      if ((paramObject1 instanceof Class)) {
        paramObject1 = (ClassType)Type.make((Class)paramObject1);
      }
      if (!(paramObject1 instanceof ClassType)) {
        break label113;
      }
    }
    try
    {
      SlotSet.setStaticField(paramObject1, paramObject2.toString(), paramObject3);
      Values localValues = Values.empty;
      return localValues;
    }
    catch (Throwable localThrowable) {}
    Symbol localSymbol = localNamespace.getSymbol(paramObject2.toString());
    Environment.getCurrent();
    Environment.getCurrent().put(localSymbol, paramObject3);
    return Values.empty;
    label113:
    SlotSet.setField(paramObject1, paramObject2.toString(), paramObject3);
    return Values.empty;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.SetNamedPart
 * JD-Core Version:    0.7.0.1
 */