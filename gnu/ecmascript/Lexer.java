package gnu.ecmascript;

import gnu.expr.QuoteExp;
import gnu.lists.Sequence;
import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;

public class Lexer
  extends gnu.text.Lexer
{
  public static final Char colonToken;
  public static final Char commaToken;
  public static final Char condToken;
  public static final Char dotToken;
  public static final Reserved elseToken = new Reserved("else", 38);
  public static final Object eofToken;
  public static final Object eolToken;
  public static final Char equalToken;
  public static final Char lbraceToken;
  public static final Char lbracketToken;
  public static final Char lparenToken = Char.make(40);
  public static final Reserved newToken = new Reserved("new", 39);
  public static final Char notToken;
  public static final Char rbraceToken;
  public static final Char rbracketToken;
  static Hashtable reserved;
  public static final Char rparenToken = Char.make(41);
  public static final Char semicolonToken;
  public static final Char tildeToken;
  private boolean prevWasCR = false;
  
  static
  {
    lbraceToken = Char.make(123);
    rbraceToken = Char.make(125);
    lbracketToken = Char.make(91);
    rbracketToken = Char.make(93);
    dotToken = Char.make(46);
    condToken = Char.make(63);
    commaToken = Char.make(44);
    colonToken = Char.make(58);
    equalToken = Char.make(61);
    tildeToken = Char.make(126);
    notToken = Char.make(33);
    semicolonToken = Char.make(59);
    eolToken = Char.make(10);
    eofToken = Sequence.eofValue;
  }
  
  public Lexer(InPort paramInPort)
  {
    super(paramInPort);
  }
  
  public static Object checkReserved(String paramString)
  {
    if (reserved == null) {
      initReserved();
    }
    return reserved.get(paramString);
  }
  
  public static Object getToken(InPort paramInPort)
    throws IOException, SyntaxException
  {
    return new Lexer(paramInPort).getToken();
  }
  
  static void initReserved()
  {
    try
    {
      if (reserved == null)
      {
        reserved = new Hashtable(20);
        reserved.put("null", new QuoteExp(null));
        reserved.put("true", new QuoteExp(Boolean.TRUE));
        reserved.put("false", new QuoteExp(Boolean.FALSE));
        reserved.put("var", new Reserved("var", 30));
        reserved.put("if", new Reserved("if", 31));
        reserved.put("while", new Reserved("while", 32));
        reserved.put("for", new Reserved("for", 33));
        reserved.put("continue", new Reserved("continue", 34));
        reserved.put("break", new Reserved("break", 35));
        reserved.put("return", new Reserved("return", 36));
        reserved.put("with", new Reserved("with", 37));
        reserved.put("function", new Reserved("function", 41));
        reserved.put("this", new Reserved("this", 40));
        reserved.put("else", elseToken);
        reserved.put("new", newToken);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    Lexer localLexer = new Lexer(InPort.inDefault());
    try
    {
      Object localObject1;
      Object localObject2;
      do
      {
        localObject1 = localLexer.getToken();
        OutPort localOutPort = OutPort.outDefault();
        localOutPort.print("token:");
        localOutPort.print(localObject1);
        localOutPort.println(" [class:" + localObject1.getClass() + "]");
        localObject2 = Sequence.eofValue;
      } while (localObject1 != localObject2);
      return;
    }
    catch (Exception localException)
    {
      System.err.println("caught exception:" + localException);
    }
  }
  
  public String getIdentifier(int paramInt)
    throws IOException
  {
    int i = this.port.pos;
    int j = i - 1;
    int k = this.port.limit;
    char[] arrayOfChar = this.port.buffer;
    while ((i < k) && (Character.isJavaIdentifierPart(arrayOfChar[i]))) {
      i++;
    }
    this.port.pos = i;
    if (i < k) {
      return new String(arrayOfChar, j, i - j);
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(arrayOfChar, j, i - j);
    int m = this.port.read();
    if (m < 0) {}
    for (;;)
    {
      return localStringBuffer.toString();
      if (Character.isJavaIdentifierPart((char)m))
      {
        localStringBuffer.append((char)m);
        break;
      }
      this.port.unread_quick();
    }
  }
  
  public Double getNumericLiteral(int paramInt)
    throws IOException
  {
    int i = 10;
    int j;
    long l;
    int k;
    if (paramInt == 48)
    {
      paramInt = read();
      if ((paramInt == 120) || (paramInt == 88))
      {
        i = 16;
        paramInt = read();
      }
    }
    else
    {
      j = this.port.pos;
      if (paramInt >= 0) {
        j--;
      }
      this.port.pos = j;
      l = readDigitsInBuffer(this.port, i);
      if (this.port.pos <= j) {
        break label181;
      }
      k = 1;
      label81:
      if ((k == 0) || (this.port.pos >= this.port.limit)) {
        break label217;
      }
      char c = this.port.buffer[this.port.pos];
      if ((Character.isLetterOrDigit(c)) || (c == '.')) {
        break label217;
      }
      if (l < 0L) {
        break label187;
      }
    }
    label181:
    label187:
    for (double d = l;; d = IntNum.valueOf(this.port.buffer, j, this.port.pos - j, i, false).doubleValue())
    {
      return new Double(d);
      if ((paramInt == 46) || (paramInt == 101) || (paramInt == 69)) {
        break;
      }
      i = 8;
      break;
      k = 0;
      break label81;
    }
    label217:
    if (i != 10) {
      error("invalid character in non-decimal number");
    }
    StringBuffer localStringBuffer = new StringBuffer(20);
    if (k != 0) {
      localStringBuffer.append(this.port.buffer, j, this.port.pos - j);
    }
    int m = -1;
    int n;
    for (;;)
    {
      n = this.port.read();
      if (Character.digit((char)n, i) < 0) {
        break;
      }
      k = 1;
      localStringBuffer.append((char)n);
    }
    int i1 = 0;
    switch (n)
    {
    }
    for (;;)
    {
      if (n >= 0) {
        this.port.unread();
      }
      if (i1 != 0)
      {
        localStringBuffer.append('e');
        localStringBuffer.append(i1);
      }
      return new Double(localStringBuffer.toString());
      if (m >= 0)
      {
        error("duplicate '.' in number");
        break;
      }
      m = localStringBuffer.length();
      localStringBuffer.append('.');
      break;
      i1 = 0;
      if (i == 10)
      {
        int i2 = this.port.peek();
        if ((i2 != 43) && (i2 != 45))
        {
          int i3 = Character.digit((char)i2, 10);
          i1 = 0;
          if (i3 < 0) {}
        }
        else
        {
          if (k == 0) {
            error("mantissa with no digits");
          }
          i1 = readOptionalExponent();
          n = read();
        }
      }
    }
  }
  
  public String getStringLiteral(char paramChar)
    throws IOException, SyntaxException
  {
    int i = this.port.pos;
    int j = i;
    int k = this.port.limit;
    char[] arrayOfChar = this.port.buffer;
    StringBuffer localStringBuffer;
    char c1;
    for (;;)
    {
      if (i < k)
      {
        char c4 = arrayOfChar[i];
        if (c4 == paramChar)
        {
          this.port.pos = (i + 1);
          return new String(arrayOfChar, j, i - j);
        }
        if ((c4 != '\\') && (c4 != '\n') && (c4 != '\r')) {}
      }
      else
      {
        this.port.pos = i;
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(arrayOfChar, j, i - j);
        c1 = this.port.read();
        if (c1 != paramChar) {
          break;
        }
        return localStringBuffer.toString();
      }
      i++;
    }
    if (c1 < 0) {
      eofError("unterminated string literal");
    }
    if ((c1 == '\n') || (c1 == '\r')) {
      fatal("string literal not terminated before end of line");
    }
    if (c1 == '\\') {
      c1 = this.port.read();
    }
    switch (c1)
    {
    default: 
      if ((c1 >= '0') && (c1 <= '7')) {
        break;
      }
    case '"': 
    case '\'': 
    case '\\': 
    case 'ð¿¿': 
    case '\n': 
    case '\r': 
    case 'b': 
    case 't': 
    case 'n': 
    case 'f': 
    case 'r': 
      for (;;)
      {
        localStringBuffer.append((char)c1);
        break;
        eofError("eof following '\\' in string");
        fatal("line terminator following '\\' in string");
        continue;
        c1 = '\b';
        continue;
        c1 = '\t';
        continue;
        c1 = '\n';
        continue;
        c1 = '\f';
        continue;
        c1 = '\r';
      }
    case 'u': 
    case 'x': 
      char c2 = '\000';
      int m;
      if (c1 == 'x') {
        m = 2;
      }
      for (;;)
      {
        m--;
        int i1;
        if (m >= 0)
        {
          int n = this.port.read();
          if (n < 0) {
            eofError("eof following '\\" + (char)c1 + "' in string");
          }
          i1 = Character.forDigit((char)n, 16);
          if (i1 < 0)
          {
            error("invalid char following '\\" + (char)c1 + "' in string");
            c2 = '?';
          }
        }
        else
        {
          c1 = c2;
          break;
          m = 4;
          c2 = '\000';
          continue;
        }
        c2 = i1 + c2 * '\020';
      }
    }
    char c3 = '\000';
    int i2 = 3;
    for (;;)
    {
      i2--;
      int i4;
      if (i2 >= 0)
      {
        int i3 = this.port.read();
        if (i3 < 0) {
          eofError("eof in octal escape in string literal");
        }
        i4 = Character.forDigit((char)i3, 8);
        if (i4 < 0) {
          this.port.unread_quick();
        }
      }
      else
      {
        c1 = c3;
        break;
      }
      c3 = i4 + c3 * '\b';
    }
  }
  
  public Object getToken()
    throws IOException, SyntaxException
  {
    for (int i = read();; i = read())
    {
      Object localObject;
      if (i < 0) {
        localObject = eofToken;
      }
      String str;
      do
      {
        return localObject;
        if (Character.isWhitespace((char)i)) {
          break;
        }
        switch (i)
        {
        default: 
          if (!Character.isJavaIdentifierStart((char)i)) {
            break label882;
          }
          str = getIdentifier(i).intern();
          localObject = checkReserved(str);
        }
      } while (localObject != null);
      return str;
      if (i == 13)
      {
        this.prevWasCR = true;
        return eolToken;
      }
      if ((i == 10) && (!this.prevWasCR)) {
        return eolToken;
      }
      this.prevWasCR = false;
    }
    int j = this.port.peek();
    if ((j >= 48) && (j <= 57)) {
      return new QuoteExp(getNumericLiteral(46));
    }
    return dotToken;
    return new QuoteExp(getNumericLiteral(i));
    return new QuoteExp(getStringLiteral((char)i));
    return lparenToken;
    return rparenToken;
    return lbracketToken;
    return rbracketToken;
    return lbraceToken;
    return rbraceToken;
    return condToken;
    return colonToken;
    return semicolonToken;
    return commaToken;
    if (this.port.peek() == 61)
    {
      this.port.skip_quick();
      return Reserved.opEqual;
    }
    return equalToken;
    if (this.port.peek() == 61)
    {
      this.port.skip_quick();
      return Reserved.opNotEqual;
    }
    return notToken;
    return tildeToken;
    return maybeAssignment(Reserved.opTimes);
    return maybeAssignment(Reserved.opDivide);
    return maybeAssignment(Reserved.opBitXor);
    return maybeAssignment(Reserved.opRemainder);
    if (this.port.peek() == 43)
    {
      this.port.skip_quick();
      return maybeAssignment(Reserved.opPlusPlus);
    }
    return maybeAssignment(Reserved.opPlus);
    if (this.port.peek() == 45)
    {
      this.port.skip_quick();
      return maybeAssignment(Reserved.opMinusMinus);
    }
    return maybeAssignment(Reserved.opMinus);
    if (this.port.peek() == 38)
    {
      this.port.skip_quick();
      return maybeAssignment(Reserved.opBoolAnd);
    }
    return maybeAssignment(Reserved.opBitAnd);
    if (this.port.peek() == 124)
    {
      this.port.skip_quick();
      return maybeAssignment(Reserved.opBoolOr);
    }
    return maybeAssignment(Reserved.opBitOr);
    switch (this.port.peek())
    {
    default: 
      return Reserved.opGreater;
    case 62: 
      this.port.skip_quick();
      if (this.port.peek() == 62)
      {
        this.port.skip_quick();
        return maybeAssignment(Reserved.opRshiftUnsigned);
      }
      return maybeAssignment(Reserved.opRshiftSigned);
    }
    this.port.skip_quick();
    return Reserved.opGreaterEqual;
    switch (this.port.peek())
    {
    default: 
      return Reserved.opLess;
    case 60: 
      this.port.skip_quick();
      return maybeAssignment(Reserved.opLshift);
    }
    this.port.skip_quick();
    return Reserved.opLessEqual;
    label882:
    return Char.make((char)i);
  }
  
  public Object maybeAssignment(Object paramObject)
    throws IOException, SyntaxException
  {
    int i = read();
    if (i == 61) {
      error("assignment operation not implemented");
    }
    if (i >= 0) {
      this.port.unread_quick();
    }
    return paramObject;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.ecmascript.Lexer
 * JD-Core Version:    0.7.0.1
 */