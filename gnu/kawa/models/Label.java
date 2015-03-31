package gnu.kawa.models;

import java.io.Serializable;

public class Label
  extends Model
  implements Viewable, Serializable
{
  String text;
  
  public Label() {}
  
  public Label(String paramString)
  {
    this.text = paramString;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public void makeView(Display paramDisplay, Object paramObject)
  {
    paramDisplay.addLabel(this, paramObject);
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
    notifyListeners("text");
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.models.Label
 * JD-Core Version:    0.7.0.1
 */