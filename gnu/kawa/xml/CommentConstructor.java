package gnu.kawa.xml;

import gnu.lists.Consumer;
import gnu.lists.XConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;
import gnu.xml.TextUtils;
import gnu.xml.XMLFilter;

public class CommentConstructor
  extends MethodProc
{
  public static final CommentConstructor commentConstructor = new CommentConstructor();
  
  public void apply(CallContext paramCallContext)
  {
    Consumer localConsumer = paramCallContext.consumer;
    XMLFilter localXMLFilter = NodeConstructor.pushNodeContext(paramCallContext);
    for (;;)
    {
      StringBuffer localStringBuffer;
      int j;
      Object localObject2;
      try
      {
        localStringBuffer = new StringBuffer();
        String str = Location.UNBOUND;
        i = 1;
        j = 0;
        localObject2 = paramCallContext.getNextArg(str);
        if (localObject2 == str)
        {
          int k = localStringBuffer.length();
          char[] arrayOfChar = new char[k];
          localStringBuffer.getChars(0, k, arrayOfChar, 0);
          localXMLFilter.writeComment(arrayOfChar, 0, k);
          return;
        }
        if ((localObject2 instanceof Values))
        {
          Values localValues = (Values)localObject2;
          int m = 0;
          m = localValues.nextPos(m);
          if (m == 0) {
            break label182;
          }
          if (i == 0) {
            localStringBuffer.append(' ');
          }
          TextUtils.stringValue(localValues.getPosPrevious(m), localStringBuffer);
          i = 0;
          continue;
        }
        if (i != 0) {
          break label172;
        }
      }
      finally
      {
        NodeConstructor.popNodeContext(localConsumer, paramCallContext);
      }
      localStringBuffer.append(' ');
      label172:
      int i = 0;
      TextUtils.stringValue(localObject2, localStringBuffer);
      label182:
      j++;
    }
  }
  
  public int numArgs()
  {
    return 4097;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.CommentConstructor
 * JD-Core Version:    0.7.0.1
 */