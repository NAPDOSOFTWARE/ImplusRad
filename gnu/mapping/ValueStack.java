package gnu.mapping;

import gnu.lists.Sequence;

public class ValueStack
  extends Values
  implements Sequence
{
  public void clear()
  {
    this.oindex = 0;
    super.clear();
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.ValueStack
 * JD-Core Version:    0.7.0.1
 */