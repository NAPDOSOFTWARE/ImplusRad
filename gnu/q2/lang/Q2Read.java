package gnu.q2.lang;

import gnu.expr.Keyword;
import gnu.expr.QuoteExp;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.xml.MakeAttribute;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.Sequence;
import gnu.mapping.InPort;
import gnu.text.LineBufferedReader;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import kawa.standard.begin;

public class Q2Read
  extends LispReader
{
  int curIndentation;
  int expressionStartColumn;
  String expressionStartFile;
  int expressionStartLine;
  
  public Q2Read(InPort paramInPort)
  {
    super(paramInPort);
    init();
  }
  
  public Q2Read(InPort paramInPort, SourceMessages paramSourceMessages)
  {
    super(paramInPort, paramSourceMessages);
    init();
  }
  
  public static Object readObject(InPort paramInPort)
    throws IOException, SyntaxException
  {
    return new Q2Read(paramInPort).readObject();
  }
  
  void init()
  {
    ((InPort)this.port).readState = ' ';
  }
  
  public Object readCommand()
    throws IOException, SyntaxException
  {
    int i = skipIndentation();
    Object localObject;
    if (i < 0) {
      localObject = Sequence.eofValue;
    }
    do
    {
      return localObject;
      this.curIndentation = i;
      localObject = readIndentCommand();
    } while (this.interactive);
    this.port.reset();
    return localObject;
  }
  
  public Object readCommand(boolean paramBoolean)
    throws IOException, SyntaxException
  {
    this.port.getLineNumber();
    int i = this.port.getColumnNumber();
    int j = i;
    Object localObject1 = LList.Empty;
    Object localObject2 = null;
    Object localObject3 = null;
    int k = read();
    if (k < 0) {
      label41:
      if (!paramBoolean)
      {
        if (localObject1 != localObject3) {
          break label497;
        }
        localObject1 = ((PairWithPosition)localObject3).getCar();
      }
    }
    label157:
    label186:
    label497:
    while (localObject3 != null)
    {
      return localObject1;
      if ((k == 32) || (k == 9)) {
        break;
      }
      unread();
      if (k == 41) {
        break label41;
      }
      int m = this.port.getLineNumber();
      int n = this.port.getColumnNumber();
      do
      {
        if ((k != 13) && (k != 10)) {
          break label157;
        }
        if (singleLine()) {
          break;
        }
        read();
        skipIndentation();
        n = this.port.getColumnNumber();
        k = peek();
      } while (n > i);
      if ((n <= i) && (localObject3 != null)) {
        break label41;
      }
      Object localObject4;
      PairWithPosition localPairWithPosition1;
      if ((n == j) && (localObject3 != null))
      {
        localObject4 = readCommand();
        if (localObject4 == Sequence.eofValue) {
          break label409;
        }
        j = n;
        String str = this.port.getName();
        localPairWithPosition1 = PairWithPosition.make(localObject4, LList.Empty, str, m + 1, n + 1);
        if (localObject3 != null) {
          break label411;
        }
        localObject2 = localPairWithPosition1;
        localObject1 = localPairWithPosition1;
      }
      for (;;)
      {
        localObject3 = localPairWithPosition1;
        break;
        if ((n < j) && (localObject3 != null))
        {
          Object localObject5 = localObject2;
          for (;;)
          {
            Object localObject6 = ((PairWithPosition)localObject5).getCdr();
            if (localObject6 == LList.Empty) {}
            PairWithPosition localPairWithPosition4;
            for (;;)
            {
              localObject4 = readCommand();
              break;
              localPairWithPosition4 = (PairWithPosition)localObject6;
              int i1 = -1 + localPairWithPosition4.getColumnNumber();
              if (i1 < n) {
                break label395;
              }
              if (i1 > n) {
                error('e', "some tokens on previous line indented more than current line");
              }
              Object localObject7 = localPairWithPosition4.getCdr();
              if (localObject7 != LList.Empty)
              {
                if (-1 + ((PairWithPosition)localObject7).getColumnNumber() == n)
                {
                  localObject5 = (PairWithPosition)localObject7;
                  break label263;
                }
                localObject3 = (PairWithPosition)makePair(localPairWithPosition4, this.port.getLineNumber(), n);
                ((PairWithPosition)localObject5).setCdrBackdoor(localObject3);
              }
            }
            localObject5 = localPairWithPosition4;
          }
        }
        localObject4 = readObject();
        break label186;
        break label41;
        if ((((PairWithPosition)localObject3).getCar() instanceof Keyword))
        {
          QuoteExp localQuoteExp = new QuoteExp(((Keyword)((PairWithPosition)localObject3).getCar()).getName());
          MakeAttribute localMakeAttribute = MakeAttribute.makeAttribute;
          PairWithPosition localPairWithPosition2 = new PairWithPosition((SourceLocator)localObject3, localQuoteExp, localPairWithPosition1);
          PairWithPosition localPairWithPosition3 = new PairWithPosition((SourceLocator)localObject3, localMakeAttribute, localPairWithPosition2);
          ((PairWithPosition)localObject3).setCar(localPairWithPosition3);
          break;
        }
        ((PairWithPosition)localObject3).setCdrBackdoor(localPairWithPosition1);
      }
    }
    label263:
    label395:
    label409:
    label411:
    return QuoteExp.voidExp;
  }
  
  Object readIndentCommand()
    throws IOException, SyntaxException
  {
    int i = this.curIndentation;
    label24:
    label114:
    label249:
    int i2;
    label205:
    label207:
    int i3;
    for (Object localObject1 = LList.Empty;; localObject1 = makePair(readObject(), localObject1, i2, i3))
    {
      int j = read();
      if (j < 0) {
        break label114;
      }
      do
      {
        do
        {
          return LList.reverseInPlace(localObject1);
          if ((j == 32) || (j == 9)) {
            break;
          }
          unread();
        } while (j == 41);
        if ((j != 13) && (j != 10)) {
          break label249;
        }
      } while (singleLine());
      read();
      this.port.mark(2147483647);
      int k = skipIndentation();
      Object localObject2 = LList.Empty;
      this.curIndentation = k;
      for (;;)
      {
        if (this.curIndentation == -1) {}
        int m;
        for (;;)
        {
          if (localObject2 == LList.Empty) {
            break label205;
          }
          localObject1 = new Pair(new Pair(begin.begin, LList.reverseInPlace(localObject2)), localObject1);
          break;
          if (k == this.curIndentation)
          {
            m = Q2.compareIndentation(k, i);
            if (m == -2147483648)
            {
              error('e', "cannot compare indentation - mix of tabs and spaces");
            }
            else
            {
              if ((m != -1) && (m != 1)) {
                break label207;
              }
              error('e', "indentation must differ by 2 or more");
            }
          }
        }
        break label24;
        if (m <= 0) {
          break;
        }
        int n = this.port.getLineNumber();
        int i1 = this.port.getColumnNumber();
        localObject2 = makePair(readIndentCommand(), localObject2, n, i1);
      }
      i2 = this.port.getLineNumber();
      i3 = this.port.getColumnNumber();
    }
  }
  
  void saveExpressionStartPosition()
  {
    this.expressionStartFile = this.port.getName();
    this.expressionStartLine = this.port.getLineNumber();
    this.expressionStartColumn = this.port.getColumnNumber();
  }
  
  boolean singleLine()
  {
    return (this.interactive) && (this.nesting == 0);
  }
  
  int skipIndentation()
    throws IOException, SyntaxException
  {
    int i = 0;
    int k;
    for (int j = this.port.read();; j = this.port.read())
    {
      k = 0;
      if (j != 9) {
        break;
      }
      i++;
    }
    while (j == 32)
    {
      k++;
      j = this.port.read();
    }
    if (j < 0) {
      return -1;
    }
    this.port.unread();
    return k + (i << 16);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.q2.lang.Q2Read
 * JD-Core Version:    0.7.0.1
 */