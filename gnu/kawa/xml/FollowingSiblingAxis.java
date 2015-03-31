package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class FollowingSiblingAxis
  extends TreeScanner
{
  public static FollowingSiblingAxis make(NodePredicate paramNodePredicate)
  {
    FollowingSiblingAxis localFollowingSiblingAxis = new FollowingSiblingAxis();
    localFollowingSiblingAxis.type = paramNodePredicate;
    return localFollowingSiblingAxis;
  }
  
  public void scan(AbstractSequence paramAbstractSequence, int paramInt, PositionConsumer paramPositionConsumer)
  {
    int i = paramAbstractSequence.endPos();
    for (;;)
    {
      paramInt = paramAbstractSequence.nextMatching(paramInt, this.type, i, false);
      if (paramInt == 0) {
        return;
      }
      paramPositionConsumer.writePosition(paramAbstractSequence, paramInt);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.FollowingSiblingAxis
 * JD-Core Version:    0.7.0.1
 */