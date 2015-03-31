package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.math.DateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class XTimeType
  extends XDataType
{
  public static final XTimeType dateTimeType;
  public static final XTimeType dateType;
  private static TimeZone fixedTimeZone;
  public static final XTimeType gDayType = new XTimeType("gDay", 26);
  public static final XTimeType gMonthDayType;
  public static final XTimeType gMonthType;
  public static final XTimeType gYearMonthType;
  public static final XTimeType gYearType;
  public static final XTimeType timeType;
  static ClassType typeDateTime = ClassType.make("gnu.math.DateTime");
  
  static
  {
    dateTimeType = new XTimeType("dateTime", 20);
    dateType = new XTimeType("date", 21);
    timeType = new XTimeType("time", 22);
    gYearMonthType = new XTimeType("gYearMonth", 23);
    gYearType = new XTimeType("gYear", 24);
    gMonthType = new XTimeType("gMonth", 27);
    gMonthDayType = new XTimeType("gMonthDay", 25);
  }
  
  XTimeType(String paramString, int paramInt)
  {
    super(paramString, typeDateTime, paramInt);
  }
  
  static int components(int paramInt)
  {
    int i = 126;
    switch (paramInt)
    {
    default: 
      i = 0;
    case 20: 
    case 28: 
      return i;
    case 21: 
      return 14;
    case 22: 
      return 112;
    case 23: 
      return 6;
    case 24: 
      return 2;
    case 25: 
      return 12;
    case 26: 
      return 8;
    case 27: 
      return 4;
    case 29: 
      return 6;
    }
    return 120;
  }
  
  private static TimeZone fixedTimeZone()
  {
    try
    {
      if (fixedTimeZone == null) {
        fixedTimeZone = DateTime.minutesToTimeZone(TimeZone.getDefault().getRawOffset() / 60000);
      }
      TimeZone localTimeZone = fixedTimeZone;
      return localTimeZone;
    }
    finally {}
  }
  
  public static DateTime parseDateTime(String paramString, int paramInt)
  {
    DateTime localDateTime = DateTime.parse(paramString, paramInt);
    if (localDateTime.isZoneUnspecified()) {
      localDateTime.setTimeZone(fixedTimeZone());
    }
    return localDateTime;
  }
  
  public boolean isInstance(Object paramObject)
  {
    if (!(paramObject instanceof DateTime)) {}
    while (components(this.typeCode) != ((DateTime)paramObject).components()) {
      return false;
    }
    return true;
  }
  
  public DateTime now()
  {
    return new DateTime(0x80 | components(this.typeCode), (GregorianCalendar)Calendar.getInstance(fixedTimeZone()));
  }
  
  public Object valueOf(String paramString)
  {
    return parseDateTime(paramString, components(this.typeCode));
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.XTimeType
 * JD-Core Version:    0.7.0.1
 */