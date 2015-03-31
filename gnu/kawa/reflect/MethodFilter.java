package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Filter;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;

class MethodFilter
  implements Filter
{
  ClassType caller;
  int modifiers;
  int modmask;
  String name;
  int nlen;
  ObjectType receiver;
  
  public MethodFilter(String paramString, int paramInt1, int paramInt2, ClassType paramClassType, ObjectType paramObjectType)
  {
    this.name = paramString;
    this.nlen = paramString.length();
    this.modifiers = paramInt1;
    this.modmask = paramInt2;
    this.caller = paramClassType;
    this.receiver = paramObjectType;
  }
  
  public boolean select(Object paramObject)
  {
    Method localMethod = (Method)paramObject;
    String str = localMethod.getName();
    int i = localMethod.getModifiers();
    if (((i & this.modmask) != this.modifiers) || ((i & 0x1000) != 0) || (!str.startsWith(this.name))) {}
    int j;
    do
    {
      return false;
      j = str.length();
      if (j == this.nlen) {
        break;
      }
      if ((j == 2 + this.nlen) && (str.charAt(this.nlen) == '$'))
      {
        int k = str.charAt(1 + this.nlen);
        if ((k == 86) || (k == 88)) {
          break;
        }
      }
    } while ((j != 4 + this.nlen) || (!str.endsWith("$V$X")));
    ClassType localClassType;
    if ((this.receiver instanceof ClassType))
    {
      localClassType = (ClassType)this.receiver;
      if ((this.caller != null) && (!this.caller.isAccessible(localClassType, this.receiver, localMethod.getModifiers()))) {
        break label198;
      }
    }
    label198:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      localClassType = localMethod.getDeclaringClass();
      break;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.MethodFilter
 * JD-Core Version:    0.7.0.1
 */