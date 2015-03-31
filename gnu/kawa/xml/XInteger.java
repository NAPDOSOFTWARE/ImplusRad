package gnu.kawa.xml;

import gnu.math.IntNum;

public class XInteger
  extends IntNum
{
  private XIntegerType type;
  
  XInteger(IntNum paramIntNum, XIntegerType paramXIntegerType)
  {
    this.words = paramIntNum.words;
    this.ival = paramIntNum.ival;
    this.type = paramXIntegerType;
  }
  
  public XIntegerType getIntegerType()
  {
    return this.type;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.XInteger
 * JD-Core Version:    0.7.0.1
 */