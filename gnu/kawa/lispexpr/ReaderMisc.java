package gnu.kawa.lispexpr;

public class ReaderMisc
  extends ReadTableEntry
{
  int kind;
  
  public ReaderMisc(int paramInt)
  {
    this.kind = paramInt;
  }
  
  public int getKind()
  {
    return this.kind;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderMisc
 * JD-Core Version:    0.7.0.1
 */