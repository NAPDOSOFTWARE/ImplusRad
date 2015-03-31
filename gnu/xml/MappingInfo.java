package gnu.xml;

import gnu.mapping.Symbol;

final class MappingInfo
{
  int index = -1;
  String local;
  NamespaceBinding namespaces;
  MappingInfo nextInBucket;
  String prefix;
  Symbol qname;
  int tagHash;
  XName type;
  String uri;
  
  static boolean equals(String paramString, StringBuffer paramStringBuffer)
  {
    int i = paramStringBuffer.length();
    if (paramString.length() != i) {
      return false;
    }
    for (int j = 0;; j++)
    {
      if (j >= i) {
        break label41;
      }
      if (paramStringBuffer.charAt(j) != paramString.charAt(j)) {
        break;
      }
    }
    label41:
    return true;
  }
  
  static boolean equals(String paramString, char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramString.length() != paramInt2) {
      return false;
    }
    for (int i = 0;; i++)
    {
      if (i >= paramInt2) {
        break label40;
      }
      if (paramArrayOfChar[(paramInt1 + i)] != paramString.charAt(i)) {
        break;
      }
    }
    label40:
    return true;
  }
  
  static int hash(String paramString1, String paramString2)
  {
    int i = paramString2.hashCode();
    if (paramString1 != null) {
      i ^= paramString1.hashCode();
    }
    return i;
  }
  
  static int hash(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    int k = -1;
    int m = 0;
    if (m < paramInt2)
    {
      int n = paramArrayOfChar[(paramInt1 + m)];
      if ((n == 58) && (k < 0))
      {
        k = m;
        j = i;
      }
      for (i = 0;; i = n + i * 31)
      {
        m++;
        break;
      }
    }
    return j ^ i;
  }
  
  boolean match(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.prefix != null)
    {
      int i = this.local.length();
      int j = this.prefix.length();
      return (paramInt2 == i + (j + 1)) && (paramArrayOfChar[j] == ':') && (equals(this.prefix, paramArrayOfChar, paramInt1, j)) && (equals(this.local, paramArrayOfChar, 1 + (paramInt1 + j), i));
    }
    return equals(this.local, paramArrayOfChar, paramInt1, paramInt2);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.xml.MappingInfo
 * JD-Core Version:    0.7.0.1
 */