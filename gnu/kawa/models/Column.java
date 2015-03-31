package gnu.kawa.models;

import java.io.Serializable;

public class Column
  extends Box
  implements Viewable, Serializable
{
  public int getAxis()
  {
    return 1;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.models.Column
 * JD-Core Version:    0.7.0.1
 */