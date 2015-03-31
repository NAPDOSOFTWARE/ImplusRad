package gnu.ecmascript;

public class Convert
{
  public static double toInteger(double paramDouble)
  {
    if (Double.isNaN(paramDouble)) {
      return 0.0D;
    }
    if (paramDouble < 0.0D) {
      return Math.ceil(paramDouble);
    }
    return Math.floor(paramDouble);
  }
  
  public static double toInteger(Object paramObject)
  {
    return toInteger(toNumber(paramObject));
  }
  
  public static double toNumber(Object paramObject)
  {
    double d1 = (0.0D / 0.0D);
    if ((paramObject instanceof Number)) {
      d1 = ((Number)paramObject).doubleValue();
    }
    do
    {
      return d1;
      if ((paramObject instanceof Boolean))
      {
        if (((Boolean)paramObject).booleanValue()) {
          return 1.0D;
        }
        return 0.0D;
      }
    } while (!(paramObject instanceof String));
    try
    {
      double d2 = Double.valueOf((String)paramObject).doubleValue();
      return d2;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return d1;
  }
  
  public int toInt32(double paramDouble)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) {
      return 0;
    }
    return (int)paramDouble;
  }
  
  public int toInt32(Object paramObject)
  {
    return toInt32(toNumber(paramObject));
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.ecmascript.Convert
 * JD-Core Version:    0.7.0.1
 */