package gnu.kawa.util;

import java.util.Map.Entry;

public class HashNode<K, V>
  implements Map.Entry<K, V>
{
  int hash;
  K key;
  public HashNode<K, V> next;
  V value;
  
  public HashNode(K paramK, V paramV)
  {
    this.key = paramK;
    this.value = paramV;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof HashNode)) {}
    HashNode localHashNode;
    label28:
    do
    {
      do
      {
        return false;
        localHashNode = (HashNode)paramObject;
        if (this.key != null) {
          break;
        }
      } while (localHashNode.key != null);
      if (this.value != null) {
        break label61;
      }
    } while (localHashNode.value != null);
    for (;;)
    {
      return true;
      if (!this.key.equals(localHashNode.key)) {
        break;
      }
      break label28;
      label61:
      if (!this.value.equals(localHashNode.value)) {
        break;
      }
    }
  }
  
  public V get(V paramV)
  {
    return getValue();
  }
  
  public K getKey()
  {
    return this.key;
  }
  
  public V getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    int i;
    int j;
    if (this.key == null)
    {
      i = 0;
      Object localObject = this.value;
      j = 0;
      if (localObject != null) {
        break label35;
      }
    }
    for (;;)
    {
      return i ^ j;
      i = this.key.hashCode();
      break;
      label35:
      j = this.value.hashCode();
    }
  }
  
  public V setValue(V paramV)
  {
    Object localObject = this.value;
    this.value = paramV;
    return localObject;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.util.HashNode
 * JD-Core Version:    0.7.0.1
 */