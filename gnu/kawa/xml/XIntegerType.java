package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.kawa.functions.Arithmetic;
import gnu.math.IntNum;
import gnu.math.RealNum;
import java.math.BigDecimal;

public class XIntegerType
  extends XDataType
{
  public static final XIntegerType byteType;
  public static final XIntegerType intType;
  public static final XIntegerType integerType;
  public static final XIntegerType longType;
  public static final XIntegerType negativeIntegerType;
  public static final XIntegerType nonNegativeIntegerType;
  public static final XIntegerType nonPositiveIntegerType;
  public static final XIntegerType positiveIntegerType = new XIntegerType("positiveInteger", nonNegativeIntegerType, 17, IntNum.one(), null);
  public static final XIntegerType shortType;
  static ClassType typeIntNum = ClassType.make("gnu.math.IntNum");
  public static final XIntegerType unsignedByteType;
  public static final XIntegerType unsignedIntType;
  public static final XIntegerType unsignedLongType;
  public static final XIntegerType unsignedShortType;
  boolean isUnsignedType;
  public final IntNum maxValue;
  public final IntNum minValue;
  
  static
  {
    integerType = new XIntegerType("integer", decimalType, 5, null, null);
    longType = new XIntegerType("long", integerType, 8, IntNum.make(-9223372036854775808L), IntNum.make(9223372036854775807L));
    intType = new XIntegerType("int", longType, 9, IntNum.make(-2147483648), IntNum.make(2147483647));
    shortType = new XIntegerType("short", intType, 10, IntNum.make(-32768), IntNum.make(32767));
    byteType = new XIntegerType("byte", shortType, 11, IntNum.make(-128), IntNum.make(127));
    nonPositiveIntegerType = new XIntegerType("nonPositiveInteger", integerType, 6, null, IntNum.zero());
    negativeIntegerType = new XIntegerType("negativeInteger", nonPositiveIntegerType, 7, null, IntNum.minusOne());
    nonNegativeIntegerType = new XIntegerType("nonNegativeInteger", integerType, 12, IntNum.zero(), null);
    unsignedLongType = new XIntegerType("unsignedLong", nonNegativeIntegerType, 13, IntNum.zero(), IntNum.valueOf("18446744073709551615"));
    unsignedIntType = new XIntegerType("unsignedInt", unsignedLongType, 14, IntNum.zero(), IntNum.make(4294967295L));
    unsignedShortType = new XIntegerType("unsignedShort", unsignedIntType, 15, IntNum.zero(), IntNum.make(65535));
    unsignedByteType = new XIntegerType("unsignedByte", unsignedShortType, 16, IntNum.zero(), IntNum.make(255));
  }
  
  public XIntegerType(Object paramObject, XDataType paramXDataType, int paramInt, IntNum paramIntNum1, IntNum paramIntNum2)
  {
    super(paramObject, typeIntNum, paramInt);
    this.minValue = paramIntNum1;
    this.maxValue = paramIntNum2;
    this.baseType = paramXDataType;
  }
  
  public XIntegerType(String paramString, XDataType paramXDataType, int paramInt, IntNum paramIntNum1, IntNum paramIntNum2)
  {
    this(paramString, paramXDataType, paramInt, paramIntNum1, paramIntNum2);
    this.isUnsignedType = paramString.startsWith("unsigned");
  }
  
  public Object cast(Object paramObject)
  {
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue()) {}
      for (IntNum localIntNum = IntNum.one();; localIntNum = IntNum.zero()) {
        return valueOf(localIntNum);
      }
    }
    if ((paramObject instanceof IntNum)) {
      return valueOf((IntNum)paramObject);
    }
    if ((paramObject instanceof BigDecimal)) {
      return valueOf(Arithmetic.asIntNum((BigDecimal)paramObject));
    }
    if ((paramObject instanceof RealNum)) {
      return valueOf(((RealNum)paramObject).toExactInt(3));
    }
    if ((paramObject instanceof Number)) {
      return valueOf(RealNum.toExactInt(((Number)paramObject).doubleValue(), 3));
    }
    return super.cast(paramObject);
  }
  
  public Object coerceFromObject(Object paramObject)
  {
    return valueOf((IntNum)paramObject);
  }
  
  public boolean isInstance(Object paramObject)
  {
    if (!(paramObject instanceof IntNum)) {}
    for (;;)
    {
      return false;
      if (this == integerType) {
        return true;
      }
      Object localObject;
      if ((paramObject instanceof XInteger)) {
        localObject = ((XInteger)paramObject).getIntegerType();
      }
      while (localObject != null) {
        if (localObject == this)
        {
          return true;
          localObject = integerType;
        }
        else
        {
          localObject = ((XDataType)localObject).baseType;
        }
      }
    }
  }
  
  public boolean isUnsignedType()
  {
    return this.isUnsignedType;
  }
  
  public IntNum valueOf(IntNum paramIntNum)
  {
    if (this != integerType)
    {
      if (((this.minValue != null) && (IntNum.compare(paramIntNum, this.minValue) < 0)) || ((this.maxValue != null) && (IntNum.compare(paramIntNum, this.maxValue) > 0))) {
        throw new ClassCastException("cannot cast " + paramIntNum + " to " + this.name);
      }
      paramIntNum = new XInteger(paramIntNum, this);
    }
    return paramIntNum;
  }
  
  public IntNum valueOf(String paramString, int paramInt)
  {
    return valueOf(IntNum.valueOf(paramString.trim(), paramInt));
  }
  
  public Object valueOf(String paramString)
  {
    return valueOf(IntNum.valueOf(paramString.trim(), 10));
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.XIntegerType
 * JD-Core Version:    0.7.0.1
 */