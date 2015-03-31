package gnu.xml;

import gnu.kawa.xml.ElementType;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.lists.AbstractSequence;
import gnu.lists.SeqPosition;
import gnu.lists.TreeList;
import gnu.mapping.CharArrayOutPort;
import gnu.mapping.Symbol;
import gnu.text.Path;
import gnu.text.URIPath;

public class NodeTree
  extends TreeList
{
  static int counter;
  int id;
  int idCount;
  String[] idNames;
  int[] idOffsets;
  
  public static NodeTree make()
  {
    return new NodeTree();
  }
  
  public int ancestorAttribute(int paramInt, String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      if (paramInt == -1) {
        i = 0;
      }
      do
      {
        return i;
        i = getAttributeI(paramInt, paramString1, paramString2);
      } while (i != 0);
      paramInt = parentPos(paramInt);
    }
  }
  
  public Path baseUriOfPos(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    int i = posToDataIndex(paramInt);
    for (;;)
    {
      if (i == this.data.length) {
        return null;
      }
      int j = this.data[i];
      URIPath localURIPath;
      if (j == 61714)
      {
        int m = getIntN(i + 1);
        localURIPath = null;
        if (m >= 0) {
          localURIPath = URIPath.makeURI(this.objects[m]);
        }
        if (localURIPath == null) {
          break label163;
        }
        if ((localObject != null) && (paramBoolean)) {
          break label153;
        }
      }
      label153:
      for (localObject = localURIPath;; localObject = localURIPath.resolve((Path)localObject))
      {
        if ((!((Path)localObject).isAbsolute()) && (paramBoolean)) {
          break label163;
        }
        return localObject;
        if ((j < 40960) || (j > 45055))
        {
          localURIPath = null;
          if (j != 61704) {
            break;
          }
        }
        int k = getAttributeI(paramInt, "http://www.w3.org/XML/1998/namespace", "base");
        localURIPath = null;
        if (k == 0) {
          break;
        }
        localURIPath = URIPath.valueOf(KNode.getNodeValue(this, k));
        break;
      }
      label163:
      i = parentOrEntityI(i);
      if (i == -1) {
        return localObject;
      }
      paramInt = i << 1;
    }
  }
  
  void enterID(String paramString, int paramInt)
  {
    String[] arrayOfString = this.idNames;
    int[] arrayOfInt = this.idOffsets;
    int j;
    int n;
    int i1;
    int i2;
    if (arrayOfString == null)
    {
      j = 64;
      this.idNames = new String[j];
      this.idOffsets = new int[j];
      int m = paramString.hashCode();
      n = j - 1;
      i1 = m & n;
      i2 = 0x1 | (m ^ 0xFFFFFFFF) << 1;
    }
    for (;;)
    {
      String str1 = arrayOfString[i1];
      if (str1 == null)
      {
        arrayOfString[i1] = paramString;
        arrayOfInt[i1] = paramInt;
        this.idCount = (1 + this.idCount);
      }
      while (str1.equals(paramString))
      {
        return;
        int i = 4 * this.idCount;
        j = this.idNames.length;
        if (i < j * 3) {
          break;
        }
        this.idNames = new String[j * 2];
        this.idOffsets = new int[j * 2];
        this.idCount = 0;
        int k = j;
        for (;;)
        {
          k--;
          if (k < 0) {
            break;
          }
          String str2 = arrayOfString[k];
          if (str2 != null) {
            enterID(str2, arrayOfInt[k]);
          }
        }
        arrayOfString = this.idNames;
        arrayOfInt = this.idOffsets;
        j *= 2;
        break;
      }
      i1 = n & i1 + i2;
    }
  }
  
  public int getAttribute(int paramInt, String paramString1, String paramString2)
  {
    String str1;
    String str2;
    if (paramString1 == null)
    {
      str1 = null;
      str2 = null;
      if (paramString2 != null) {
        break label33;
      }
    }
    for (;;)
    {
      return getAttributeI(paramInt, str1, str2);
      str1 = paramString1.intern();
      break;
      label33:
      str2 = paramString2.intern();
    }
  }
  
  public int getAttributeI(int paramInt, String paramString1, String paramString2)
  {
    for (int i = firstAttributePos(paramInt);; i = nextPos(i))
    {
      if ((i == 0) || (getNextKind(i) != 35)) {
        i = 0;
      }
      while (((paramString2 == null) || (posLocalName(i) == paramString2)) && ((paramString1 == null) || (posNamespaceURI(i) == paramString1))) {
        return i;
      }
    }
  }
  
  public int getId()
  {
    if (this.id == 0)
    {
      int i = 1 + counter;
      counter = i;
      this.id = i;
    }
    return this.id;
  }
  
  public SeqPosition getIteratorAtPos(int paramInt)
  {
    return KNode.make(this, paramInt);
  }
  
  public int lookupID(String paramString)
  {
    String[] arrayOfString = this.idNames;
    int[] arrayOfInt = this.idOffsets;
    int i = this.idNames.length;
    int j = paramString.hashCode();
    int k = i - 1;
    int m = j & k;
    int n = 0x1 | (j ^ 0xFFFFFFFF) << 1;
    for (;;)
    {
      String str = arrayOfString[m];
      if (str == null) {
        return -1;
      }
      if (str.equals(paramString)) {
        return arrayOfInt[m];
      }
      m = k & m + n;
    }
  }
  
  public void makeIDtableIfNeeded()
  {
    if (this.idNames != null) {
      return;
    }
    this.idNames = new String[64];
    this.idOffsets = new int[64];
    int i = endPos();
    int j = 0;
    for (;;)
    {
      j = nextMatching(j, ElementType.anyElement, i, true);
      if (j == 0) {
        break;
      }
      int k = getAttributeI(j, "http://www.w3.org/XML/1998/namespace", "id");
      if (k != 0) {
        enterID(KNode.getNodeValue(this, k), j);
      }
    }
  }
  
  public int nextPos(int paramInt)
  {
    int i;
    int m;
    if ((paramInt & 0x1) != 0)
    {
      i = posToDataIndex(paramInt);
      int j = nextNodeIndex(i, 2147483647);
      if (j == i) {
        break label36;
      }
      m = j << 1;
    }
    label36:
    int k;
    do
    {
      return m;
      break;
      k = this.data.length;
      m = 0;
    } while (i == k);
    return 3 + (i << 1);
  }
  
  public int posFirstChild(int paramInt)
  {
    int i = gotoChildrenStart(posToDataIndex(paramInt));
    if (i < 0) {}
    int j;
    do
    {
      return -1;
      j = this.data[i];
    } while ((j == 61707) || (j == 61708) || (j == 61713));
    return i << 1;
  }
  
  public boolean posHasAttributes(int paramInt)
  {
    int i = gotoAttributesStart(posToDataIndex(paramInt));
    if (i < 0) {}
    while ((i < 0) || (this.data[i] != 61705)) {
      return false;
    }
    return true;
  }
  
  public boolean posIsDefaultNamespace(int paramInt, String paramString)
  {
    throw new Error("posIsDefaultNamespace not implemented");
  }
  
  public String posLocalName(int paramInt)
  {
    Object localObject = getNextTypeObject(paramInt);
    if ((localObject instanceof XName)) {
      return ((XName)localObject).getLocalPart();
    }
    if ((localObject instanceof Symbol)) {
      return ((Symbol)localObject).getLocalName();
    }
    return getNextTypeName(paramInt);
  }
  
  public String posLookupNamespaceURI(int paramInt, String paramString)
  {
    if (getNextKind(paramInt) != 33) {
      throw new IllegalArgumentException("argument must be an element");
    }
    Object localObject = getNextTypeObject(paramInt);
    if ((localObject instanceof XName)) {
      return ((XName)localObject).lookupNamespaceURI(paramString);
    }
    return null;
  }
  
  public String posLookupPrefix(int paramInt, String paramString)
  {
    throw new Error("posLookupPrefix not implemented");
  }
  
  public String posNamespaceURI(int paramInt)
  {
    Object localObject = getNextTypeObject(paramInt);
    if ((localObject instanceof XName)) {
      return ((XName)localObject).getNamespaceURI();
    }
    if ((localObject instanceof Symbol)) {
      return ((Symbol)localObject).getNamespaceURI();
    }
    return null;
  }
  
  public String posPrefix(int paramInt)
  {
    String str = getNextTypeName(paramInt);
    if (str == null) {}
    int i;
    do
    {
      return null;
      i = str.indexOf(':');
    } while (i < 0);
    return str.substring(0, i);
  }
  
  public String posTarget(int paramInt)
  {
    int i = posToDataIndex(paramInt);
    if (this.data[i] != 61716) {
      throw new ClassCastException("expected process-instruction");
    }
    return (String)this.objects[getIntN(i + 1)];
  }
  
  public int stableCompare(AbstractSequence paramAbstractSequence)
  {
    if (this == paramAbstractSequence) {
      return 0;
    }
    int i = super.stableCompare(paramAbstractSequence);
    int j;
    int k;
    if ((i == 0) && ((paramAbstractSequence instanceof NodeTree)))
    {
      j = getId();
      k = ((NodeTree)paramAbstractSequence).getId();
      if (j >= k) {
        break label48;
      }
      i = -1;
    }
    for (;;)
    {
      return i;
      label48:
      if (j > k) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public String toString()
  {
    CharArrayOutPort localCharArrayOutPort = new CharArrayOutPort();
    consume(new XMLPrinter(localCharArrayOutPort));
    localCharArrayOutPort.close();
    return localCharArrayOutPort.toString();
  }
  
  public Object typedValue(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    stringValue(posToDataIndex(paramInt), localStringBuffer);
    String str = localStringBuffer.toString();
    int i = getNextKind(paramInt);
    if ((i == 37) || (i == 36)) {
      return str;
    }
    return new UntypedAtomic(str);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.xml.NodeTree
 * JD-Core Version:    0.7.0.1
 */