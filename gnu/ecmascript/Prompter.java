package gnu.ecmascript;

import gnu.mapping.InPort;
import gnu.mapping.Procedure1;

class Prompter
  extends Procedure1
{
  public Object apply1(Object paramObject)
  {
    return prompt((InPort)paramObject);
  }
  
  String prompt(InPort paramInPort)
  {
    return "(EcmaScript:" + (1 + paramInPort.getLineNumber()) + ") ";
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.ecmascript.Prompter
 * JD-Core Version:    0.7.0.1
 */