package gnu.kawa.lispexpr;

import gnu.lists.Pair;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderParens
  extends ReadTableEntry
{
  private static ReaderParens instance;
  char close;
  Object command;
  int kind;
  char open;
  
  public ReaderParens(char paramChar1, char paramChar2, int paramInt, Object paramObject)
  {
    this.open = paramChar1;
    this.close = paramChar2;
    this.kind = paramInt;
    this.command = paramObject;
  }
  
  public static ReaderParens getInstance(char paramChar1, char paramChar2)
  {
    return getInstance(paramChar1, paramChar2, 5);
  }
  
  public static ReaderParens getInstance(char paramChar1, char paramChar2, int paramInt)
  {
    if ((paramChar1 == '(') && (paramChar2 == ')') && (paramInt == 5))
    {
      if (instance == null) {
        instance = new ReaderParens(paramChar1, paramChar2, paramInt, null);
      }
      return instance;
    }
    return new ReaderParens(paramChar1, paramChar2, paramInt, null);
  }
  
  public static ReaderParens getInstance(char paramChar1, char paramChar2, int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return getInstance(paramChar1, paramChar2, paramInt);
    }
    return new ReaderParens(paramChar1, paramChar2, paramInt, paramObject);
  }
  
  public static Object readList(LispReader paramLispReader, int paramInt1, int paramInt2, int paramInt3)
    throws IOException, SyntaxException
  {
    LineBufferedReader localLineBufferedReader = paramLispReader.getPort();
    char c1;
    char c2;
    int i;
    int j;
    Object localObject1;
    if (paramInt3 == 93)
    {
      c1 = '[';
      c2 = paramLispReader.pushNesting(c1);
      i = localLineBufferedReader.getLineNumber();
      j = localLineBufferedReader.getColumnNumber();
      localObject1 = null;
    }
    Object localObject3;
    int k;
    int m;
    int n;
    int i1;
    label243:
    Object localObject4;
    label296:
    label308:
    label324:
    Object localObject6;
    for (;;)
    {
      ReadTable localReadTable;
      int i3;
      ReadTableEntry localReadTableEntry;
      try
      {
        localObject3 = paramLispReader.makeNil();
        k = 0;
        m = 0;
        localReadTable = ReadTable.getCurrent();
        n = localLineBufferedReader.getLineNumber();
        i1 = localLineBufferedReader.getColumnNumber();
        int i2 = localLineBufferedReader.read();
        i3 = i2;
        if (i3 == paramInt3)
        {
          return localObject3;
          c1 = '(';
          break;
        }
        if (i3 < 0) {
          paramLispReader.eofError("unexpected EOF in list starting here", i + 1, j);
        }
        if (i3 != 46) {
          break label308;
        }
        i3 = localLineBufferedReader.peek();
        localReadTableEntry = localReadTable.lookup(i3);
        int i4 = localReadTableEntry.getKind();
        if ((i4 != 1) && (i4 != 5) && (i4 != 0)) {
          break label296;
        }
        localLineBufferedReader.skip();
        i1++;
        if (i3 == paramInt3)
        {
          paramLispReader.error("unexpected '" + (char)paramInt3 + "' after '.'");
          continue;
        }
        if (i3 >= 0) {
          break label243;
        }
      }
      finally
      {
        paramLispReader.popNesting(c2);
      }
      paramLispReader.eofError("unexpected EOF in list starting here", i + 1, j);
      if (k == 0) {
        break label390;
      }
      paramLispReader.error("multiple '.' in list");
      localObject3 = paramLispReader.makeNil();
      localObject1 = null;
      m = 0;
      break label390;
      Object localObject5;
      for (;;)
      {
        localObject5 = paramLispReader.readValues(i3, localReadTableEntry, localReadTable);
        if (localObject5 != Values.empty) {
          break label324;
        }
        localObject3 = localObject4;
        break;
        i3 = 46;
        localReadTableEntry = ReadTableEntry.getConstituentInstance();
        break label393;
        localReadTableEntry = localReadTable.lookup(i3);
        localObject4 = localObject3;
      }
      localObject6 = paramLispReader.handlePostfix(localObject5, localReadTable, n, i1);
      if (m == 0) {
        break label400;
      }
      paramLispReader.error("multiple values after '.'");
      localObject3 = paramLispReader.makeNil();
      localObject1 = null;
      m = 0;
    }
    for (;;)
    {
      for (Object localObject7 = paramLispReader.makePair(localObject6, n, i1); localObject1 != null; localObject7 = localObject6)
      {
        paramLispReader.setCdr(localObject1, localObject7);
        break label421;
        label390:
        k = 1;
        label393:
        localObject4 = localObject3;
        break;
        label400:
        if (k == 0) {
          break label432;
        }
        m = 1;
      }
      localObject4 = localObject7;
      label421:
      localObject1 = localObject7;
      localObject3 = localObject4;
      break;
      label432:
      if (localObject1 == null)
      {
        n = i;
        i1 = j - 1;
      }
    }
  }
  
  public int getKind()
  {
    return this.kind;
  }
  
  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    Object localObject = readList((LispReader)paramLexer, paramInt1, paramInt2, this.close);
    if (this.command != null)
    {
      LineBufferedReader localLineBufferedReader = paramLexer.getPort();
      int i = localLineBufferedReader.getLineNumber();
      int j = localLineBufferedReader.getColumnNumber();
      Pair localPair = ((LispReader)paramLexer).makePair(this.command, i, j);
      ((LispReader)paramLexer).setCdr(localPair, localObject);
      localObject = localPair;
    }
    return localObject;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderParens
 * JD-Core Version:    0.7.0.1
 */