package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.xml.TextUtils;
import gnu.xml.XName;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XStringType
  extends XDataType
{
  public static final XStringType ENTITYType = new XStringType("ENTITY", NCNameType, 47, null);
  public static final XStringType IDREFType;
  public static final XStringType IDType;
  public static final XStringType NCNameType;
  public static final XStringType NMTOKENType;
  public static final XStringType NameType;
  static ClassType XStringType = ClassType.make("gnu.kawa.xml.XString");
  public static final XStringType languageType;
  public static final XStringType normalizedStringType = new XStringType("normalizedString", stringType, 39, null);
  public static final XStringType tokenType = new XStringType("token", normalizedStringType, 40, null);
  Pattern pattern;
  
  static
  {
    languageType = new XStringType("language", tokenType, 41, "[a-zA-Z]{1,8}(-[a-zA-Z0-9]{1,8})*");
    NMTOKENType = new XStringType("NMTOKEN", tokenType, 42, "\\c+");
    NameType = new XStringType("Name", tokenType, 43, null);
    NCNameType = new XStringType("NCName", NameType, 44, null);
    IDType = new XStringType("ID", NCNameType, 45, null);
    IDREFType = new XStringType("IDREF", NCNameType, 46, null);
  }
  
  public XStringType(String paramString1, XDataType paramXDataType, int paramInt, String paramString2)
  {
    super(paramString1, XStringType, paramInt);
    this.baseType = paramXDataType;
    if (paramString2 != null) {
      this.pattern = Pattern.compile(paramString2);
    }
  }
  
  public static XString makeNCName(String paramString)
  {
    return (XString)NCNameType.valueOf(paramString);
  }
  
  public Object cast(Object paramObject)
  {
    if ((paramObject instanceof XString))
    {
      XString localXString = (XString)paramObject;
      if (localXString.getStringType() == this) {
        return localXString;
      }
    }
    return valueOf((String)stringType.cast(paramObject));
  }
  
  public boolean isInstance(Object paramObject)
  {
    if (!(paramObject instanceof XString)) {}
    for (;;)
    {
      return false;
      for (Object localObject = ((XString)paramObject).getStringType(); localObject != null; localObject = ((XDataType)localObject).baseType) {
        if (localObject == this) {
          return true;
        }
      }
    }
  }
  
  public String matches(String paramString)
  {
    boolean bool1;
    switch (this.typeCode)
    {
    case 41: 
    default: 
      if ((this.pattern == null) || (this.pattern.matcher(paramString).matches())) {
        bool1 = true;
      }
      break;
    }
    while (bool1)
    {
      return null;
      boolean bool2;
      if (this.typeCode != 39)
      {
        bool2 = true;
        label96:
        if (paramString != TextUtils.replaceWhitespace(paramString, bool2)) {
          break label115;
        }
      }
      label115:
      for (bool1 = true;; bool1 = false)
      {
        break;
        bool2 = false;
        break label96;
      }
      bool1 = XName.isName(paramString);
      continue;
      bool1 = XName.isNCName(paramString);
      continue;
      bool1 = XName.isNmToken(paramString);
      continue;
      bool1 = false;
    }
    return "not a valid XML " + getName();
  }
  
  public Object valueOf(String paramString)
  {
    if (this != normalizedStringType) {}
    String str;
    for (boolean bool = true;; bool = false)
    {
      str = TextUtils.replaceWhitespace(paramString, bool);
      if (matches(str) == null) {
        break;
      }
      throw new ClassCastException("cannot cast " + str + " to " + this.name);
    }
    return new XString(str, this);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.XStringType
 * JD-Core Version:    0.7.0.1
 */