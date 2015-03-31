package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.expr.Compilation;
import gnu.expr.PrimProcedure;
import gnu.expr.Special;
import gnu.kawa.xml.CommentConstructor;
import gnu.kawa.xml.MakeAttribute;
import gnu.kawa.xml.MakeCDATA;
import gnu.kawa.xml.MakeProcInst;
import gnu.kawa.xml.MakeText;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import gnu.xml.XName;
import java.io.IOException;

public class ReaderXmlElement
  extends ReadTableEntry
{
  static final String DEFAULT_ELEMENT_NAMESPACE = "[default-element-namespace]";
  
  public static void namedEntity(LispReader paramLispReader, String paramString)
  {
    String str = paramString.intern();
    int i = 63;
    if (str == "lt") {
      i = 60;
    }
    for (;;)
    {
      paramLispReader.tokenBufferAppend(i);
      return;
      if (str == "gt") {
        i = 62;
      } else if (str == "amp") {
        i = 38;
      } else if (str == "quot") {
        i = 34;
      } else if (str == "apos") {
        i = 39;
      } else {
        paramLispReader.error("unknown enity reference: '" + str + "'");
      }
    }
  }
  
  public static Pair quote(Object paramObject)
  {
    return LList.list2(Namespace.EmptyNamespace.getSymbol("quote"), paramObject);
  }
  
  static void readCharRef(LispReader paramLispReader)
    throws IOException, SyntaxException
  {
    int i = paramLispReader.read();
    int j;
    int k;
    if (i == 120)
    {
      j = 16;
      i = paramLispReader.read();
      k = 0;
    }
    for (;;)
    {
      int m;
      if (i >= 0)
      {
        m = Character.digit((char)i, j);
        if (m >= 0) {
          break label62;
        }
      }
      label62:
      while (k >= 134217728)
      {
        if (i == 59) {
          break label83;
        }
        paramLispReader.unread(i);
        paramLispReader.error("invalid character reference");
        return;
        j = 10;
        break;
      }
      k = m + k * j;
      i = paramLispReader.read();
    }
    label83:
    if (((k > 0) && (k <= 55295)) || ((k >= 57344) && (k <= 65533)) || ((k >= 65536) && (k <= 1114111)))
    {
      paramLispReader.tokenBufferAppend(k);
      return;
    }
    paramLispReader.error("invalid character value " + k);
  }
  
  public static Pair readContent(LispReader paramLispReader, char paramChar, Pair paramPair)
    throws IOException, SyntaxException
  {
    paramLispReader.tokenBufferLength = 0;
    int i = 0;
    for (;;)
    {
      Object localObject = null;
      String str = null;
      int j = 1 + paramLispReader.getLineNumber();
      int k = paramLispReader.getColumnNumber();
      char c = paramLispReader.read();
      if (c < 0)
      {
        paramLispReader.error("unexpected end-of-file");
        localObject = Special.eof;
      }
      for (;;)
      {
        if ((localObject != null) && (paramLispReader.tokenBufferLength > 0))
        {
          str = paramLispReader.tokenBufferString();
          paramLispReader.tokenBufferLength = 0;
        }
        if (str != null)
        {
          PairWithPosition localPairWithPosition2 = PairWithPosition.make(Pair.list2(MakeText.makeText, str), paramLispReader.makeNil(), null, -1, -1);
          paramPair.setCdrBackdoor(localPairWithPosition2);
          paramPair = localPairWithPosition2;
        }
        if (localObject != Special.eof) {
          break;
        }
        return paramPair;
        if (c == paramChar)
        {
          int i2;
          if (paramChar == '<')
          {
            int i1 = paramLispReader.tokenBufferLength;
            str = null;
            if (i1 > 0)
            {
              str = paramLispReader.tokenBufferString();
              paramLispReader.tokenBufferLength = 0;
            }
            i2 = paramLispReader.read();
            if (i2 == 47) {
              localObject = Special.eof;
            }
          }
          for (;;)
          {
            i = 0;
            break;
            localObject = readXMLConstructor(paramLispReader, i2, true);
            continue;
            if (paramLispReader.checkNext(paramChar))
            {
              paramLispReader.tokenBufferAppend(paramChar);
              localObject = null;
              str = null;
            }
            else
            {
              localObject = Special.eof;
              str = null;
            }
          }
        }
        if (c == '&')
        {
          int m = paramLispReader.read();
          if (m == 35) {
            readCharRef(paramLispReader);
          }
          for (;;)
          {
            i = 1;
            break;
            if ((m == 40) || (m == 123))
            {
              if (paramLispReader.tokenBufferLength <= 0)
              {
                str = null;
                if (i == 0) {}
              }
              else
              {
                str = paramLispReader.tokenBufferString();
              }
              paramLispReader.tokenBufferLength = 0;
              localObject = readEscapedExpression(paramLispReader, m);
            }
            else
            {
              localObject = readEntity(paramLispReader, m);
              str = null;
              if (i != 0)
              {
                int n = paramLispReader.tokenBufferLength;
                str = null;
                if (n == 0) {
                  str = "";
                }
              }
            }
          }
        }
        if ((paramChar != '<') && ((c == '\t') || (c == '\n') || (c == '\r'))) {
          c = ' ';
        }
        if (c == '<') {
          paramLispReader.error('e', "'<' must be quoted in a direct attribute value");
        }
        paramLispReader.tokenBufferAppend((char)c);
        localObject = null;
        str = null;
      }
      if (localObject != null)
      {
        PairWithPosition localPairWithPosition1 = PairWithPosition.make(localObject, paramLispReader.makeNil(), null, j, k);
        paramPair.setCdrBackdoor(localPairWithPosition1);
        paramPair = localPairWithPosition1;
      }
    }
  }
  
  public static Object readElementConstructor(LispReader paramLispReader, int paramInt)
    throws IOException, SyntaxException
  {
    int i = 1 + paramLispReader.getLineNumber();
    int j = -2 + paramLispReader.getColumnNumber();
    Object localObject1 = readQNameExpression(paramLispReader, paramInt, true);
    if (paramLispReader.tokenBufferLength == 0) {}
    PairWithPosition localPairWithPosition1;
    Object localObject2;
    Object localObject3;
    int k;
    int m;
    for (String str1 = null;; str1 = paramLispReader.tokenBufferString())
    {
      localPairWithPosition1 = PairWithPosition.make(localObject1, LList.Empty, paramLispReader.getName(), i, j);
      localObject2 = localPairWithPosition1;
      localObject3 = LList.Empty;
      k = 0;
      m = paramLispReader.readUnicodeChar();
      while ((m >= 0) && (Character.isWhitespace(m)))
      {
        m = paramLispReader.read();
        k = 1;
      }
    }
    int i1;
    if ((m < 0) || (m == 62) || (m == 47))
    {
      int n = m;
      i1 = 0;
      if (n == 47)
      {
        m = paramLispReader.read();
        if (m != 62) {
          break label510;
        }
        i1 = 1;
      }
    }
    label439:
    label482:
    label510:
    int i2;
    String str2;
    String str3;
    int i3;
    int i4;
    for (;;)
    {
      if (i1 == 0)
      {
        if (m != 62)
        {
          paramLispReader.error("missing '>' after start element");
          return Boolean.FALSE;
          if (k == 0) {
            paramLispReader.error("missing space before attribute");
          }
          Object localObject4 = readQNameExpression(paramLispReader, m, false);
          (1 + paramLispReader.getLineNumber());
          (1 + paramLispReader.getColumnNumber() - paramLispReader.tokenBufferLength);
          int i5 = paramLispReader.tokenBufferLength;
          String str5 = null;
          if (i5 >= 5)
          {
            int i7 = paramLispReader.tokenBuffer[0];
            str5 = null;
            if (i7 == 120)
            {
              int i8 = paramLispReader.tokenBuffer[1];
              str5 = null;
              if (i8 == 109)
              {
                int i9 = paramLispReader.tokenBuffer[2];
                str5 = null;
                if (i9 == 108)
                {
                  int i10 = paramLispReader.tokenBuffer[3];
                  str5 = null;
                  if (i10 == 110)
                  {
                    int i11 = paramLispReader.tokenBuffer[4];
                    str5 = null;
                    if (i11 == 115)
                    {
                      if (paramLispReader.tokenBufferLength != 5) {
                        break label439;
                      }
                      str5 = "";
                    }
                  }
                }
              }
            }
          }
          PairWithPosition localPairWithPosition2;
          for (;;)
          {
            if (skipSpace(paramLispReader, 32) != 61) {
              paramLispReader.error("missing '=' after attribute");
            }
            int i6 = skipSpace(paramLispReader, 32);
            localPairWithPosition2 = PairWithPosition.make(MakeAttribute.makeAttribute, LList.Empty, paramLispReader.getName(), i, j);
            PairWithPosition localPairWithPosition3 = PairWithPosition.make(localObject4, LList.Empty, paramLispReader.getName(), i, j);
            paramLispReader.setCdr(localPairWithPosition2, localPairWithPosition3);
            readContent(paramLispReader, (char)i6, localPairWithPosition3);
            if (str5 == null) {
              break label482;
            }
            PairWithPosition localPairWithPosition4 = new PairWithPosition(localPairWithPosition3, Pair.make(str5, localPairWithPosition3.getCdr()), localObject3);
            localObject3 = localPairWithPosition4;
            break;
            int i12 = paramLispReader.tokenBuffer[5];
            str5 = null;
            if (i12 == 58) {
              str5 = new String(paramLispReader.tokenBuffer, 6, -6 + paramLispReader.tokenBufferLength);
            }
          }
          PairWithPosition localPairWithPosition5 = PairWithPosition.make(localPairWithPosition2, paramLispReader.makeNil(), null, -1, -1);
          ((Pair)localObject2).setCdrBackdoor(localPairWithPosition5);
          localObject2 = localPairWithPosition5;
          break;
          paramLispReader.unread(m);
          i1 = 0;
          continue;
        }
        readContent(paramLispReader, '<', (Pair)localObject2);
        i2 = paramLispReader.readUnicodeChar();
        if (XName.isNameStart(i2))
        {
          paramLispReader.tokenBufferLength = 0;
          do
          {
            paramLispReader.tokenBufferAppend(i2);
            i2 = paramLispReader.readUnicodeChar();
          } while ((XName.isNamePart(i2)) || (i2 == 58));
          str2 = paramLispReader.tokenBufferString();
          if ((str1 == null) || (!str2.equals(str1)))
          {
            str3 = paramLispReader.getName();
            i3 = 1 + paramLispReader.getLineNumber();
            i4 = paramLispReader.getColumnNumber() - paramLispReader.tokenBufferLength;
            if (str1 != null) {
              break label719;
            }
          }
        }
      }
    }
    label719:
    for (String str4 = "computed start tag closed by '</" + str2 + ">'";; str4 = "'<" + str1 + ">' closed by '</" + str2 + ">'")
    {
      paramLispReader.error('e', str3, i3, i4, str4);
      paramLispReader.tokenBufferLength = 0;
      if (skipSpace(paramLispReader, i2) != 62) {
        paramLispReader.error("missing '>' after end element");
      }
      LList localLList = LList.reverseInPlace(localObject3);
      return PairWithPosition.make(MakeXmlElement.makeXml, Pair.make(localLList, localPairWithPosition1), paramLispReader.getName(), i, j);
    }
  }
  
  static Object readEntity(LispReader paramLispReader, int paramInt)
    throws IOException, SyntaxException
  {
    int i = paramLispReader.tokenBufferLength;
    for (;;)
    {
      int j;
      if (paramInt >= 0)
      {
        j = (char)paramInt;
        if (XName.isNamePart(j)) {}
      }
      else
      {
        if (paramInt == 59) {
          break;
        }
        paramLispReader.unread(paramInt);
        paramLispReader.error("invalid entity reference");
        return "?";
      }
      paramLispReader.tokenBufferAppend(j);
      paramInt = paramLispReader.read();
    }
    String str = new String(paramLispReader.tokenBuffer, i, paramLispReader.tokenBufferLength - i);
    paramLispReader.tokenBufferLength = i;
    namedEntity(paramLispReader, str);
    return null;
  }
  
  static Object readEscapedExpression(LispReader paramLispReader, int paramInt)
    throws IOException, SyntaxException
  {
    if (paramInt == 40)
    {
      paramLispReader.unread(paramInt);
      return paramLispReader.readObject();
    }
    LineBufferedReader localLineBufferedReader = paramLispReader.getPort();
    char c = paramLispReader.pushNesting('{');
    int i = localLineBufferedReader.getLineNumber();
    int j = localLineBufferedReader.getColumnNumber();
    try
    {
      Pair localPair1 = paramLispReader.makePair(new PrimProcedure(Compilation.typeValues.getDeclaredMethod("values", 1)), i, j);
      Object localObject2 = localPair1;
      ReadTable localReadTable = ReadTable.getCurrent();
      for (;;)
      {
        int k = localLineBufferedReader.getLineNumber();
        int m = localLineBufferedReader.getColumnNumber();
        int n = localLineBufferedReader.read();
        if (n == 125)
        {
          paramLispReader.tokenBufferLength = 0;
          if (localObject2 != localPair1.getCdr()) {
            break;
          }
          Object localObject3 = ((Pair)localObject2).getCar();
          return localObject3;
        }
        if (n < 0) {
          paramLispReader.eofError("unexpected EOF in list starting here", i + 1, j);
        }
        Object localObject4 = paramLispReader.readValues(n, localReadTable.lookup(n), localReadTable);
        if (localObject4 != Values.empty)
        {
          Pair localPair2 = paramLispReader.makePair(paramLispReader.handlePostfix(localObject4, localReadTable, k, m), k, m);
          paramLispReader.setCdr(localObject2, localPair2);
          localObject2 = localPair2;
        }
      }
      return localPair1;
    }
    finally
    {
      paramLispReader.popNesting(c);
    }
  }
  
  public static Object readQNameExpression(LispReader paramLispReader, int paramInt, boolean paramBoolean)
    throws IOException, SyntaxException
  {
    paramLispReader.getName();
    int i = 1 + paramLispReader.getLineNumber();
    int j = paramLispReader.getColumnNumber();
    paramLispReader.tokenBufferLength = 0;
    if (XName.isNameStart(paramInt))
    {
      int k = -1;
      do
      {
        for (;;)
        {
          paramLispReader.tokenBufferAppend(paramInt);
          paramInt = paramLispReader.readUnicodeChar();
          if ((paramInt != 58) || (k >= 0)) {
            break;
          }
          k = paramLispReader.tokenBufferLength;
        }
      } while (XName.isNamePart(paramInt));
      paramLispReader.unread(paramInt);
      if ((k >= 0) || (paramBoolean))
      {
        int m = -1 + (paramLispReader.tokenBufferLength - k);
        String str1 = new String(paramLispReader.tokenBuffer, k + 1, m).intern();
        if (k < 0) {}
        for (String str2 = "[default-element-namespace]";; str2 = new String(paramLispReader.tokenBuffer, 0, k).intern())
        {
          Symbol localSymbol = Namespace.EmptyNamespace.getSymbol(str2);
          return new Pair(ResolveNamespace.resolveQName, PairWithPosition.make(localSymbol, new Pair(str1, LList.Empty), paramLispReader.getName(), i, j));
        }
      }
      return quote(Namespace.getDefaultSymbol(paramLispReader.tokenBufferString().intern()));
    }
    if ((paramInt == 123) || (paramInt == 40)) {
      return readEscapedExpression(paramLispReader, paramInt);
    }
    paramLispReader.error("missing element name");
    return null;
  }
  
  static Object readXMLConstructor(LispReader paramLispReader, int paramInt, boolean paramBoolean)
    throws IOException, SyntaxException
  {
    int i = 1 + paramLispReader.getLineNumber();
    int j = -2 + paramLispReader.getColumnNumber();
    if (paramInt == 33)
    {
      int n = paramLispReader.read();
      if (n == 45)
      {
        n = paramLispReader.peek();
        if (n == 45)
        {
          paramLispReader.skip();
          if (!paramLispReader.readDelimited("-->")) {
            paramLispReader.error('f', paramLispReader.getName(), i, j, "unexpected end-of-file in XML comment starting here - expected \"-->\"");
          }
          String str4 = paramLispReader.tokenBufferString();
          return LList.list2(CommentConstructor.commentConstructor, str4);
        }
      }
      if (n == 91)
      {
        n = paramLispReader.read();
        if (n == 67)
        {
          n = paramLispReader.read();
          if (n == 68)
          {
            n = paramLispReader.read();
            if (n == 65)
            {
              n = paramLispReader.read();
              if (n == 84)
              {
                n = paramLispReader.read();
                if (n == 65)
                {
                  n = paramLispReader.read();
                  if (n == 91)
                  {
                    if (!paramLispReader.readDelimited("]]>")) {
                      paramLispReader.error('f', paramLispReader.getName(), i, j, "unexpected end-of-file in CDATA starting here - expected \"]]>\"");
                    }
                    String str3 = paramLispReader.tokenBufferString();
                    return LList.list2(MakeCDATA.makeCDATA, str3);
                  }
                }
              }
            }
          }
        }
      }
      paramLispReader.error('f', paramLispReader.getName(), i, j, "'<!' must be followed by '--' or '[CDATA['");
      while ((n >= 0) && (n != 62) && (n != 10) && (n != 13)) {
        n = paramLispReader.read();
      }
      return null;
    }
    if (paramInt == 63)
    {
      int k = paramLispReader.readUnicodeChar();
      if ((k < 0) || (!XName.isNameStart(k))) {
        paramLispReader.error("missing target after '<?'");
      }
      do
      {
        paramLispReader.tokenBufferAppend(k);
        k = paramLispReader.readUnicodeChar();
      } while (XName.isNamePart(k));
      String str1 = paramLispReader.tokenBufferString();
      int m = 0;
      while ((k >= 0) && (Character.isWhitespace(k)))
      {
        m++;
        k = paramLispReader.read();
      }
      paramLispReader.unread(k);
      char c = paramLispReader.pushNesting('?');
      try
      {
        if (!paramLispReader.readDelimited("?>")) {
          paramLispReader.error('f', paramLispReader.getName(), i, j, "unexpected end-of-file looking for \"?>\"");
        }
        paramLispReader.popNesting(c);
        if ((m == 0) && (paramLispReader.tokenBufferLength > 0)) {
          paramLispReader.error("target must be followed by space or '?>'");
        }
        String str2 = paramLispReader.tokenBufferString();
        return LList.list3(MakeProcInst.makeProcInst, str1, str2);
      }
      finally
      {
        paramLispReader.popNesting(c);
      }
    }
    return readElementConstructor(paramLispReader, paramInt);
  }
  
  static int skipSpace(LispReader paramLispReader, int paramInt)
    throws IOException, SyntaxException
  {
    for (;;)
    {
      if ((paramInt < 0) || (!Character.isWhitespace(paramInt))) {
        return paramInt;
      }
      paramInt = paramLispReader.readUnicodeChar();
    }
  }
  
  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    LispReader localLispReader = (LispReader)paramLexer;
    return readXMLConstructor(localLispReader, localLispReader.readUnicodeChar(), false);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderXmlElement
 * JD-Core Version:    0.7.0.1
 */