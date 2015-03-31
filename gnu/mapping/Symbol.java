package gnu.mapping;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class Symbol
  implements EnvironmentKey, Comparable, Externalizable
{
  public static final Symbol FUNCTION = makeUninterned("(function)");
  public static final Symbol PLIST = makeUninterned("(property-list)");
  protected String name;
  Namespace namespace;
  
  public Symbol() {}
  
  public Symbol(Namespace paramNamespace, String paramString)
  {
    this.name = paramString;
    this.namespace = paramNamespace;
  }
  
  public static boolean equals(Symbol paramSymbol1, Symbol paramSymbol2)
  {
    if (paramSymbol1 == paramSymbol2) {}
    Namespace localNamespace1;
    Namespace localNamespace2;
    do
    {
      return true;
      if ((paramSymbol1 == null) || (paramSymbol2 == null)) {
        return false;
      }
      if (paramSymbol1.name != paramSymbol2.name) {
        break;
      }
      localNamespace1 = paramSymbol1.namespace;
      localNamespace2 = paramSymbol2.namespace;
      if ((localNamespace1 == null) || (localNamespace2 == null)) {
        break;
      }
    } while (localNamespace1.name == localNamespace2.name);
    return false;
    return false;
  }
  
  public static Symbol make(Object paramObject, String paramString)
  {
    if ((paramObject instanceof String)) {}
    for (Namespace localNamespace = Namespace.valueOf((String)paramObject); (localNamespace == null) || (paramString == null); localNamespace = (Namespace)paramObject) {
      return makeUninterned(paramString);
    }
    return localNamespace.getSymbol(paramString.intern());
  }
  
  public static Symbol make(String paramString1, String paramString2, String paramString3)
  {
    return Namespace.valueOf(paramString1, paramString3).getSymbol(paramString2.intern());
  }
  
  public static Symbol makeUninterned(String paramString)
  {
    return new Symbol(null, paramString);
  }
  
  public static Symbol makeWithUnknownNamespace(String paramString1, String paramString2)
  {
    return Namespace.makeUnknownNamespace(paramString2).getSymbol(paramString1.intern());
  }
  
  public static Symbol parse(String paramString)
  {
    int i = paramString.length();
    int j = -1;
    int k = -1;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3;
    label57:
    String str1;
    if (i1 < i)
    {
      i3 = paramString.charAt(i1);
      if ((i3 == 58) && (m == 0))
      {
        n = i1;
        i2 = i1 + 1;
      }
    }
    else
    {
      if ((j < 0) || (k <= 0)) {
        break label203;
      }
      str1 = paramString.substring(j + 1, k);
      if (n <= 0) {
        break label197;
      }
    }
    label197:
    for (String str2 = paramString.substring(0, n);; str2 = null)
    {
      return valueOf(paramString.substring(i2), str1, str2);
      if (i3 == 123)
      {
        if (j < 0)
        {
          n = i1;
          j = i1;
        }
        m++;
      }
      if (i3 == 125)
      {
        m--;
        if (m == 0)
        {
          k = i1;
          if ((i1 < i) && (paramString.charAt(i1 + 1) == ':')) {}
          for (i2 = i1 + 2;; i2 = i1 + 1) {
            break;
          }
        }
        if (m < 0)
        {
          i2 = n;
          break label57;
        }
      }
      i1++;
      break;
    }
    label203:
    if (n > 0) {
      return makeWithUnknownNamespace(paramString.substring(i2), paramString.substring(0, n));
    }
    return valueOf(paramString);
  }
  
  public static SimpleSymbol valueOf(String paramString)
  {
    return (SimpleSymbol)Namespace.EmptyNamespace.getSymbol(paramString.intern());
  }
  
  public static Symbol valueOf(String paramString, Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Boolean.FALSE)) {
      return makeUninterned(paramString);
    }
    Namespace localNamespace;
    if ((paramObject instanceof Namespace)) {
      localNamespace = (Namespace)paramObject;
    }
    for (;;)
    {
      return localNamespace.getSymbol(paramString.intern());
      if (paramObject == Boolean.TRUE) {
        localNamespace = Namespace.EmptyNamespace;
      } else {
        localNamespace = Namespace.valueOf(((CharSequence)paramObject).toString());
      }
    }
  }
  
  public static Symbol valueOf(String paramString1, String paramString2, String paramString3)
  {
    return Namespace.valueOf(paramString2, paramString3).getSymbol(paramString1.intern());
  }
  
  public int compareTo(Object paramObject)
  {
    Symbol localSymbol = (Symbol)paramObject;
    if (getNamespaceURI() != localSymbol.getNamespaceURI()) {
      throw new IllegalArgumentException("comparing Symbols in different namespaces");
    }
    return getLocalName().compareTo(localSymbol.getLocalName());
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Symbol)) && (equals(this, (Symbol)paramObject));
  }
  
  public final Object getKeyProperty()
  {
    return null;
  }
  
  public final Symbol getKeySymbol()
  {
    return this;
  }
  
  public final String getLocalName()
  {
    return this.name;
  }
  
  public final String getLocalPart()
  {
    return this.name;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final Namespace getNamespace()
  {
    return this.namespace;
  }
  
  public final String getNamespaceURI()
  {
    Namespace localNamespace = getNamespace();
    if (localNamespace == null) {
      return null;
    }
    return localNamespace.getName();
  }
  
  public final String getPrefix()
  {
    Namespace localNamespace = this.namespace;
    if (localNamespace == null) {
      return "";
    }
    return localNamespace.prefix;
  }
  
  public final boolean hasEmptyNamespace()
  {
    Namespace localNamespace = getNamespace();
    String str;
    if (localNamespace != null) {
      str = localNamespace.getName();
    }
    return (str == null) || (str.length() == 0);
  }
  
  public int hashCode()
  {
    if (this.name == null) {
      return 0;
    }
    return this.name.hashCode();
  }
  
  public boolean matches(EnvironmentKey paramEnvironmentKey)
  {
    return (equals(paramEnvironmentKey.getKeySymbol(), this)) && (paramEnvironmentKey.getKeyProperty() == null);
  }
  
  public boolean matches(Symbol paramSymbol, Object paramObject)
  {
    return (equals(paramSymbol, this)) && (paramObject == null);
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.namespace = ((Namespace)paramObjectInput.readObject());
    this.name = ((String)paramObjectInput.readObject());
  }
  
  public Object readResolve()
    throws ObjectStreamException
  {
    if (this.namespace == null) {
      return this;
    }
    return make(this.namespace, getName());
  }
  
  public final void setNamespace(Namespace paramNamespace)
  {
    this.namespace = paramNamespace;
  }
  
  public String toString()
  {
    return toString('P');
  }
  
  public String toString(char paramChar)
  {
    int i = 1;
    String str1 = getNamespaceURI();
    String str2 = getPrefix();
    int j;
    if ((str1 != null) && (str1.length() > 0))
    {
      j = i;
      if ((str2 == null) || (str2.length() <= 0)) {
        break label160;
      }
    }
    for (;;)
    {
      String str3 = getName();
      if ((j != 0) || (i != 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if ((i != 0) && ((paramChar != 'U') || (j == 0))) {
          localStringBuilder.append(str2);
        }
        if ((j != 0) && ((paramChar != 'P') || (i == 0)))
        {
          localStringBuilder.append('{');
          localStringBuilder.append(getNamespaceURI());
          localStringBuilder.append('}');
        }
        localStringBuilder.append(':');
        localStringBuilder.append(str3);
        str3 = localStringBuilder.toString();
      }
      return str3;
      j = 0;
      break;
      label160:
      i = 0;
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(getNamespace());
    paramObjectOutput.writeObject(getName());
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.Symbol
 * JD-Core Version:    0.7.0.1
 */