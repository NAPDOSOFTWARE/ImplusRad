package gnu.q2.lang;

import gnu.mapping.InPort;
import gnu.mapping.Procedure1;

class Prompter
  extends Procedure1
{
  public Object apply1(Object paramObject)
  {
    InPort localInPort = (InPort)paramObject;
    int i = 1 + localInPort.getLineNumber();
    char c = localInPort.readState;
    if (c == ']') {
      return "<!--Q2:" + i + "-->";
    }
    if (c == '\n') {
      c = '-';
    }
    return "#|--Q2:" + i + "|#" + c;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.q2.lang.Prompter
 * JD-Core Version:    0.7.0.1
 */