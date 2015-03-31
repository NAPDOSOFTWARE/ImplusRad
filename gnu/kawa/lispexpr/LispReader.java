package gnu.kawa.lispexpr;

import gnu.expr.Keyword;
import gnu.expr.QuoteExp;
import gnu.expr.Special;
import gnu.kawa.util.GeneralHashTable;
import gnu.lists.Convert;
import gnu.lists.F32Vector;
import gnu.lists.F64Vector;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.S16Vector;
import gnu.lists.S32Vector;
import gnu.lists.S64Vector;
import gnu.lists.S8Vector;
import gnu.lists.Sequence;
import gnu.lists.SimpleVector;
import gnu.lists.U16Vector;
import gnu.lists.U32Vector;
import gnu.lists.U64Vector;
import gnu.lists.U8Vector;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.CComplex;
import gnu.math.Complex;
import gnu.math.DComplex;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.RatNum;
import gnu.math.RealNum;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.math.BigDecimal;

public class LispReader
  extends Lexer
{
  static final int SCM_COMPLEX = 1;
  public static final int SCM_NUMBERS = 1;
  public static final char TOKEN_ESCAPE_CHAR = 'èøø';
  protected boolean seenEscapes;
  GeneralHashTable<Integer, Object> sharedStructureTable;
  
  public LispReader(LineBufferedReader paramLineBufferedReader)
  {
    super(paramLineBufferedReader);
  }
  
  public LispReader(LineBufferedReader paramLineBufferedReader, SourceMessages paramSourceMessages)
  {
    super(paramLineBufferedReader, paramSourceMessages);
  }
  
  static char getReadCase()
  {
    try
    {
      char c = Environment.getCurrent().get("symbol-read-case", "P").toString().charAt(0);
      if (c == 'P') {}
      do
      {
        return c;
        if (c == 'u') {
          return 'U';
        }
        if ((c == 'd') || (c == 'l') || (c == 'L')) {
          return 'D';
        }
      } while (c != 'i');
      return 'I';
    }
    catch (Exception localException) {}
    return 'P';
  }
  
  private boolean isPotentialNumber(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    int i = 0;
    int j = paramInt1;
    if (j < paramInt2)
    {
      char c = paramArrayOfChar[j];
      if (Character.isDigit(c)) {
        i++;
      }
      label62:
      label109:
      do
      {
        do
        {
          do
          {
            j++;
            break;
            if ((c != '-') && (c != '+')) {
              break label62;
            }
          } while (j + 1 != paramInt2);
          return false;
          if (c == '#') {
            return bool;
          }
          if ((!Character.isLetter(c)) && (c != '/') && (c != '_') && (c != '^')) {
            break label109;
          }
        } while (j != paramInt1);
        return false;
      } while (c == '.');
      return false;
    }
    if (i > 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static Object parseNumber(CharSequence paramCharSequence, int paramInt)
  {
    if ((paramCharSequence instanceof FString)) {}
    for (char[] arrayOfChar = ((FString)paramCharSequence).data;; arrayOfChar = paramCharSequence.toString().toCharArray()) {
      return parseNumber(arrayOfChar, 0, paramCharSequence.length(), '\000', paramInt, 1);
    }
  }
  
  public static Object parseNumber(char[] paramArrayOfChar, int paramInt1, int paramInt2, char paramChar, int paramInt3, int paramInt4)
  {
    int i = paramInt1 + paramInt2;
    Object localObject3;
    if (paramInt1 >= i)
    {
      localObject3 = "no digits";
      return localObject3;
    }
    int j = paramInt1 + 1;
    char c1 = paramArrayOfChar[paramInt1];
    while (c1 == '#')
    {
      if (j >= i) {
        return "no digits";
      }
      int i26 = j + 1;
      char c4 = paramArrayOfChar[j];
      int i29;
      int i30;
      int i27;
      switch (c4)
      {
      default: 
        i29 = 0;
        i30 = Character.digit(c4, 10);
        if (i30 < 0)
        {
          if ((c4 != 'R') && (c4 != 'r')) {
            break label384;
          }
          if (paramInt3 == 0) {
            break label357;
          }
          return "duplicate radix specifier";
        }
        break;
      case 'B': 
      case 'b': 
        if (paramInt3 != 0) {
          return "duplicate radix specifier";
        }
        paramInt3 = 2;
        i27 = i26;
      }
      for (;;)
      {
        if (i27 >= i)
        {
          return "no digits";
          if (paramInt3 != 0) {
            return "duplicate radix specifier";
          }
          paramInt3 = 8;
          i27 = i26;
          continue;
          if (paramInt3 != 0) {
            return "duplicate radix specifier";
          }
          paramInt3 = 10;
          i27 = i26;
          continue;
          if (paramInt3 != 0) {
            return "duplicate radix specifier";
          }
          paramInt3 = 16;
          i27 = i26;
          continue;
          if (paramChar != 0)
          {
            if (paramChar == ' ') {
              return "non-prefix exactness specifier";
            }
            return "duplicate exactness specifier";
          }
          paramChar = c4;
          i27 = i26;
          continue;
          i29 = i30 + i29 * 10;
          if (i26 >= i) {
            return "missing letter after '#'";
          }
          int i31 = i26 + 1;
          c4 = paramArrayOfChar[i26];
          i26 = i31;
          break;
          label357:
          if ((i29 < 2) || (i29 > 35)) {
            return "invalid radix specifier";
          }
          paramInt3 = i29;
          i27 = i26;
          continue;
          label384:
          return "unknown modifier '#" + c4 + '\'';
        }
      }
      int i28 = i27 + 1;
      c1 = paramArrayOfChar[i27];
      j = i28;
    }
    if (paramChar == 0) {
      paramChar = ' ';
    }
    int i25;
    label456:
    boolean bool1;
    label466:
    boolean bool2;
    int k;
    if (paramInt3 == 0)
    {
      i25 = paramInt2;
      i25--;
      if (i25 < 0) {
        paramInt3 = 10;
      }
    }
    else
    {
      if (c1 != '-') {
        break label523;
      }
      bool1 = true;
      bool2 = bool1;
      if ((c1 != '-') && (c1 != '+')) {
        break label529;
      }
      k = 1;
    }
    label523:
    label529:
    int m;
    for (;;)
    {
      if (k != 0)
      {
        if (j >= i)
        {
          return "no digits following sign";
          if (paramArrayOfChar[(paramInt1 + i25)] != '.') {
            break;
          }
          paramInt3 = 10;
          break label456;
          bool1 = false;
          break label466;
          k = 0;
          continue;
        }
        m = j + 1;
        c1 = paramArrayOfChar[j];
      }
    }
    for (;;)
    {
      if (((c1 == 'i') || (c1 == 'I')) && (m == i) && (paramInt1 == m - 2) && ((paramInt4 & 0x1) != 0))
      {
        int i24 = paramArrayOfChar[paramInt1];
        if ((i24 != 43) && (i24 != 45)) {
          return "no digits";
        }
        if ((paramChar == 'i') || (paramChar == 'I'))
        {
          if (bool1) {}
          for (double d6 = -1.0D;; d6 = 1.0D)
          {
            DComplex localDComplex = new DComplex(0.0D, d6);
            return localDComplex;
          }
        }
        if (bool1) {}
        for (CComplex localCComplex = Complex.imMinusOne();; localCComplex = Complex.imOne()) {
          return localCComplex;
        }
      }
      (m - 1);
      int n = -1;
      int i1 = -1;
      int i2 = -1;
      IntNum localIntNum1 = null;
      long l = 0L;
      label689:
      int i3 = Character.digit(c1, paramInt3);
      label745:
      int i5;
      if (i3 >= 0)
      {
        if ((0 != 0) && (i2 < 0)) {
          return "digit after '#' in number";
        }
        if (i1 < 0) {
          i1 = m - 1;
        }
        l = l * paramInt3 + i3;
        if (m != i) {
          break label1195;
        }
        if (i1 >= 0) {
          break label2188;
        }
        i5 = 0;
        if (k != 0)
        {
          int i17 = m + 4;
          i5 = 0;
          if (i17 < i)
          {
            int i18 = paramArrayOfChar[(m + 3)];
            i5 = 0;
            if (i18 == 46)
            {
              int i19 = paramArrayOfChar[(m + 4)];
              i5 = 0;
              if (i19 == 48)
              {
                if ((paramArrayOfChar[m] != 'i') || (paramArrayOfChar[(m + 1)] != 'n') || (paramArrayOfChar[(m + 2)] != 'f')) {
                  break label1214;
                }
                i5 = 105;
              }
            }
          }
        }
      }
      for (;;)
      {
        if (i5 != 0) {
          break label1273;
        }
        return "no digits";
        switch (c1)
        {
        default: 
          m--;
          break;
        case '.': 
          if (i2 >= 0) {
            return "duplicate '.' in number";
          }
          if (paramInt3 != 10) {
            return "'.' in non-decimal number";
          }
          i2 = m - 1;
          break;
        case 'D': 
        case 'E': 
        case 'F': 
        case 'L': 
        case 'S': 
        case 'd': 
        case 'e': 
        case 'f': 
        case 'l': 
        case 's': 
          if ((m == i) || (paramInt3 != 10))
          {
            m--;
            break label745;
          }
          char c3 = paramArrayOfChar[m];
          int i23 = m - 1;
          if ((c3 == '+') || (c3 == '-'))
          {
            m++;
            if ((m >= i) || (Character.digit(paramArrayOfChar[m], 10) < 0)) {
              return "missing exponent digits";
            }
          }
          else if (Character.digit(c3, 10) < 0)
          {
            m--;
            break label745;
          }
          if (n >= 0) {
            return "duplicate exponent";
          }
          if (paramInt3 != 10) {
            return "exponent in non-decimal number";
          }
          if (i1 < 0) {
            return "mantissa with no digits";
          }
          n = i23;
          do
          {
            m++;
            if (m >= i) {
              break;
            }
          } while (Character.digit(paramArrayOfChar[m], 10) >= 0);
          break;
        case '/': 
          if (localIntNum1 != null) {
            return "multiple fraction symbol '/'";
          }
          if (i1 < 0) {
            return "no digits before fraction symbol '/'";
          }
          if ((n >= 0) || (i2 >= 0)) {
            return "fraction symbol '/' following exponent or '.'";
          }
          localIntNum1 = valueOf(paramArrayOfChar, i1, m - i1, paramInt3, bool1, l);
          i1 = -1;
          l = 0L;
          bool1 = false;
          break;
          label1195:
          int i4 = m + 1;
          c1 = paramArrayOfChar[m];
          m = i4;
          break label689;
          label1214:
          int i20 = paramArrayOfChar[m];
          i5 = 0;
          if (i20 == 110)
          {
            int i21 = paramArrayOfChar[(m + 1)];
            i5 = 0;
            if (i21 == 97)
            {
              int i22 = paramArrayOfChar[(m + 2)];
              i5 = 0;
              if (i22 == 110) {
                i5 = 110;
              }
            }
          }
          break;
        }
      }
      label1273:
      int i6 = m + 5;
      for (;;)
      {
        int i7;
        label1312:
        int i8;
        double d5;
        label1332:
        Object localObject1;
        if (((0 != 0) || (0 == 0)) || ((paramChar == 'i') || (paramChar == 'I') || ((paramChar == ' ') && (0 != 0))))
        {
          i7 = 1;
          i8 = 0;
          if (i5 == 0) {
            break label1449;
          }
          if (i5 != 105) {
            break label1441;
          }
          d5 = (1.0D / 0.0D);
          if (bool1) {
            d5 = -d5;
          }
          localObject1 = new DFloNum(d5);
        }
        for (;;)
        {
          if ((paramChar == 'e') || (paramChar == 'E')) {
            localObject1 = ((RealNum)localObject1).toExact();
          }
          label1441:
          label1449:
          Object localObject4;
          if (i6 < i)
          {
            int i10 = i6 + 1;
            char c2 = paramArrayOfChar[i6];
            if (c2 == '@')
            {
              localObject3 = parseNumber(paramArrayOfChar, i10, i - i10, paramChar, 10, paramInt4);
              if ((localObject3 instanceof String)) {
                break;
              }
              if (!(localObject3 instanceof RealNum))
              {
                return "invalid complex polar constant";
                i7 = 0;
                break label1312;
                d5 = (0.0D / 0.0D);
                break label1332;
                if ((n >= 0) || (i2 >= 0))
                {
                  if ((i1 > i2) && (i2 >= 0)) {
                    i1 = i2;
                  }
                  if (localIntNum1 != null) {
                    return "floating-point number after fraction symbol '/'";
                  }
                  int i9 = i6 - i1;
                  String str = new String(paramArrayOfChar, i1, i9);
                  i8 = 0;
                  if (n >= 0)
                  {
                    i8 = Character.toLowerCase(paramArrayOfChar[n]);
                    if (i8 != 101)
                    {
                      int i15 = n - i1;
                      StringBuilder localStringBuilder = new StringBuilder().append(str.substring(0, i15)).append('e');
                      int i16 = i15 + 1;
                      str = str.substring(i16);
                    }
                  }
                  double d1 = Convert.parseDouble(str);
                  if (bool1) {
                    d1 = -d1;
                  }
                  localObject1 = new DFloNum(d1);
                  continue;
                }
                IntNum localIntNum2 = valueOf(paramArrayOfChar, i1, i6 - i1, paramInt3, bool1, l);
                if (localIntNum1 == null)
                {
                  localObject4 = localIntNum2;
                  label1645:
                  if ((i7 == 0) || (!((RealNum)localObject4).isExact())) {
                    break label2178;
                  }
                  if ((!bool2) || (!((RealNum)localObject4).isZero())) {
                    break label1795;
                  }
                }
                label1795:
                for (double d3 = 0.0D;; d3 = ((RealNum)localObject4).doubleValue())
                {
                  localObject1 = new DFloNum(d3);
                  i8 = 0;
                  break;
                  if (localIntNum2.isZero())
                  {
                    boolean bool3 = localIntNum1.isZero();
                    double d4;
                    if (i7 != 0) {
                      if (bool3) {
                        d4 = (0.0D / 0.0D);
                      }
                    }
                    label1721:
                    for (Object localObject5 = new DFloNum(d4);; localObject5 = RatNum.make(localIntNum1, localIntNum2))
                    {
                      localObject4 = localObject5;
                      break;
                      if (bool2)
                      {
                        d4 = (-1.0D / 0.0D);
                        break label1721;
                      }
                      d4 = (1.0D / 0.0D);
                      break label1721;
                      if (bool3) {
                        return "0/0 is undefined";
                      }
                    }
                  }
                  localObject4 = RatNum.make(localIntNum1, localIntNum2);
                  break label1645;
                }
              }
              RealNum localRealNum2 = (RealNum)localObject3;
              if ((((RealNum)localObject1).isZero()) && (!localRealNum2.isExact()))
              {
                DFloNum localDFloNum = new DFloNum(0.0D);
                return localDFloNum;
              }
              return Complex.polar((RealNum)localObject1, localRealNum2);
            }
            if ((c2 == '-') || (c2 == '+'))
            {
              int i11 = i10 - 1;
              Object localObject2 = parseNumber(paramArrayOfChar, i11, i - i11, paramChar, 10, paramInt4);
              if ((localObject2 instanceof String)) {
                return localObject2;
              }
              if (!(localObject2 instanceof Complex)) {
                return "invalid numeric constant (" + localObject2 + ")";
              }
              Complex localComplex = (Complex)localObject2;
              if (!localComplex.re().isZero()) {
                return "invalid numeric constant";
              }
              RealNum localRealNum1 = localComplex.im();
              return Complex.make((RealNum)localObject1, localRealNum1);
            }
            int i12 = 0;
            for (;;)
            {
              if (!Character.isLetter(c2)) {
                i10--;
              }
              do
              {
                if (i12 != 1) {
                  break label2058;
                }
                int i14 = paramArrayOfChar[(i10 - 1)];
                if ((i14 != 105) && (i14 != 73)) {
                  break label2058;
                }
                if (i10 >= i) {
                  break;
                }
                return "junk after imaginary suffix 'i'";
                i12++;
              } while (i10 == i);
              int i13 = i10 + 1;
              c2 = paramArrayOfChar[i10];
              i10 = i13;
            }
            return Complex.make(IntNum.zero(), (RealNum)localObject1);
            label2058:
            return "excess junk after number";
          }
          double d2;
          if (((localObject1 instanceof DFloNum)) && (i8 > 0) && (i8 != 101)) {
            d2 = ((RealNum)localObject1).doubleValue();
          }
          switch (i8)
          {
          default: 
            return localObject1;
          case 102: 
          case 115: 
            Float localFloat = Float.valueOf((float)d2);
            return localFloat;
          case 100: 
            Double localDouble = Double.valueOf(d2);
            return localDouble;
          }
          BigDecimal localBigDecimal = BigDecimal.valueOf(d2);
          return localBigDecimal;
          label2178:
          localObject1 = localObject4;
          i8 = 0;
        }
        label2188:
        i6 = m;
        i5 = 0;
      }
      m = j;
    }
  }
  
  public static Object readCharacter(LispReader paramLispReader)
    throws IOException, SyntaxException
  {
    int i = paramLispReader.read();
    if (i < 0) {
      paramLispReader.eofError("unexpected EOF in character literal");
    }
    int j = paramLispReader.tokenBufferLength;
    paramLispReader.tokenBufferAppend(i);
    paramLispReader.readToken(paramLispReader.read(), 'D', ReadTable.getCurrent());
    char[] arrayOfChar = paramLispReader.tokenBuffer;
    int k = paramLispReader.tokenBufferLength - j;
    if (k == 1) {
      return Char.make(arrayOfChar[j]);
    }
    String str = new String(arrayOfChar, j, k);
    int m = Char.nameToChar(str);
    if (m >= 0) {
      return Char.make(m);
    }
    int n = arrayOfChar[j];
    int i1;
    int i2;
    int i3;
    label152:
    int i5;
    if ((n == 120) || (n == 88))
    {
      i1 = 0;
      i2 = 1;
      if (i2 == k) {
        return Char.make(i1);
      }
      i3 = Character.digit(arrayOfChar[(j + i2)], 16);
      if (i3 >= 0) {}
    }
    else
    {
      int i4 = Character.digit(n, 8);
      if (i4 < 0) {
        break label228;
      }
      i5 = i4;
    }
    for (int i6 = 1;; i6++)
    {
      if (i6 == k)
      {
        return Char.make(i5);
        i1 = i3 + i1 * 16;
        if (i1 > 1114111) {
          break label152;
        }
        i2++;
        break;
      }
      int i7 = Character.digit(arrayOfChar[(j + i6)], 8);
      if (i7 < 0)
      {
        label228:
        paramLispReader.error("unknown character name: " + str);
        return Char.make(63);
      }
      i5 = i7 + i5 * 8;
    }
  }
  
  public static Object readNumberWithRadix(int paramInt1, LispReader paramLispReader, int paramInt2)
    throws IOException, SyntaxException
  {
    int i = paramLispReader.tokenBufferLength - paramInt1;
    paramLispReader.readToken(paramLispReader.read(), 'P', ReadTable.getCurrent());
    int j = paramLispReader.tokenBufferLength;
    Object localObject;
    if (i == j)
    {
      paramLispReader.error("missing numeric token");
      localObject = IntNum.zero();
    }
    do
    {
      return localObject;
      localObject = parseNumber(paramLispReader.tokenBuffer, i, j - i, '\000', paramInt2, 0);
      if ((localObject instanceof String))
      {
        paramLispReader.error((String)localObject);
        return IntNum.zero();
      }
    } while (localObject != null);
    paramLispReader.error("invalid numeric constant");
    return IntNum.zero();
  }
  
  public static SimpleVector readSimpleVector(LispReader paramLispReader, char paramChar)
    throws IOException, SyntaxException
  {
    int k;
    for (int i = 0;; i = k + i * 10)
    {
      int j = paramLispReader.read();
      if (j < 0) {
        paramLispReader.eofError("unexpected EOF reading uniform vector");
      }
      k = Character.digit((char)j, 10);
      if (k < 0)
      {
        if (((i == 8) || (i == 16) || (i == 32) || (i == 64)) && ((paramChar != 'F') || (i >= 32)) && (j == 40)) {
          break;
        }
        paramLispReader.error("invalid uniform vector syntax");
        return null;
      }
    }
    Object localObject = ReaderParens.readList(paramLispReader, 40, -1, 41);
    if (LList.listLength(localObject, false) < 0)
    {
      paramLispReader.error("invalid elements in uniform vector syntax");
      return null;
    }
    Sequence localSequence = (Sequence)localObject;
    switch (paramChar)
    {
    default: 
      return null;
    case 'F': 
      switch (i)
      {
      }
    case 'S': 
      switch (i)
      {
      }
      break;
    }
    switch (i)
    {
    default: 
      return null;
    case 8: 
      return new U8Vector(localSequence);
      return new F32Vector(localSequence);
      return new F64Vector(localSequence);
      return new S8Vector(localSequence);
      return new S16Vector(localSequence);
      return new S32Vector(localSequence);
      return new S64Vector(localSequence);
    case 16: 
      return new U16Vector(localSequence);
    case 32: 
      return new U32Vector(localSequence);
    }
    return new U64Vector(localSequence);
  }
  
  public static Object readSpecial(LispReader paramLispReader)
    throws IOException, SyntaxException
  {
    int i = paramLispReader.read();
    if (i < 0) {
      paramLispReader.eofError("unexpected EOF in #! special form");
    }
    Values localValues;
    if ((i == 47) && (paramLispReader.getLineNumber() == 0) && (paramLispReader.getColumnNumber() == 3))
    {
      ReaderIgnoreRestOfLine.getInstance().read(paramLispReader, 35, 1);
      localValues = Values.empty;
    }
    String str;
    boolean bool;
    do
    {
      return localValues;
      int j = paramLispReader.tokenBufferLength;
      paramLispReader.tokenBufferAppend(i);
      paramLispReader.readToken(paramLispReader.read(), 'D', ReadTable.getCurrent());
      int k = paramLispReader.tokenBufferLength - j;
      str = new String(paramLispReader.tokenBuffer, j, k);
      if (str.equals("optional")) {
        return Special.optional;
      }
      if (str.equals("rest")) {
        return Special.rest;
      }
      if (str.equals("key")) {
        return Special.key;
      }
      if (str.equals("eof")) {
        return Special.eof;
      }
      if (str.equals("void")) {
        return QuoteExp.voidExp;
      }
      if (str.equals("default")) {
        return Special.dfault;
      }
      if (str.equals("undefined")) {
        return Special.undefined;
      }
      if (str.equals("abstract")) {
        return Special.abstractSpecial;
      }
      bool = str.equals("null");
      localValues = null;
    } while (bool);
    paramLispReader.error("unknown named constant #!" + str);
    return null;
  }
  
  private static IntNum valueOf(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong)
  {
    if (paramInt2 + paramInt3 <= 28)
    {
      if (paramBoolean) {
        paramLong = -paramLong;
      }
      return IntNum.make(paramLong);
    }
    return IntNum.valueOf(paramArrayOfChar, paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  Object handlePostfix(Object paramObject, ReadTable paramReadTable, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    if (paramObject == QuoteExp.voidExp) {}
    Pair localPair;
    for (paramObject = Values.empty;; paramObject = PairWithPosition.make(LispLanguage.lookup_sym, localPair, this.port.getName(), paramInt1 + 1, paramInt2 + 1))
    {
      int i = this.port.peek();
      if ((i < 0) || (i != paramReadTable.postfixLookupOperator)) {
        return paramObject;
      }
      this.port.read();
      if (!validPostfixLookupStart(this.port.peek(), paramReadTable))
      {
        unread();
        return paramObject;
      }
      int j = this.port.read();
      Object localObject = readValues(j, paramReadTable.lookup(j), paramReadTable);
      localPair = LList.list2(paramObject, LList.list2(paramReadTable.makeSymbol("quasiquote"), localObject));
    }
  }
  
  protected Object makeNil()
  {
    return LList.Empty;
  }
  
  protected Pair makePair(Object paramObject, int paramInt1, int paramInt2)
  {
    return makePair(paramObject, LList.Empty, paramInt1, paramInt2);
  }
  
  protected Pair makePair(Object paramObject1, Object paramObject2, int paramInt1, int paramInt2)
  {
    String str = this.port.getName();
    if ((str != null) && (paramInt1 >= 0)) {
      return PairWithPosition.make(paramObject1, paramObject2, str, paramInt1 + 1, paramInt2 + 1);
    }
    return Pair.make(paramObject1, paramObject2);
  }
  
  protected Object readAndHandleToken(int paramInt1, int paramInt2, ReadTable paramReadTable)
    throws IOException, SyntaxException
  {
    readToken(paramInt1, getReadCase(), paramReadTable);
    int i = this.tokenBufferLength;
    if (!this.seenEscapes)
    {
      Object localObject2 = parseNumber(this.tokenBuffer, paramInt2, i - paramInt2, '\000', 0, 1);
      if ((localObject2 != null) && (!(localObject2 instanceof String))) {
        return localObject2;
      }
    }
    int j = getReadCase();
    int i14;
    int k;
    label193:
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    label211:
    int i12;
    int i13;
    if (j == 73)
    {
      i14 = 0;
      int i15 = 0;
      int i16 = paramInt2;
      if (i16 < i)
      {
        int i17 = this.tokenBuffer[i16];
        if (i17 == 65535) {
          i16++;
        }
        for (;;)
        {
          i16++;
          break;
          if (Character.isLowerCase(i17)) {
            i15++;
          } else if (Character.isUpperCase(i17)) {
            i14++;
          }
        }
      }
      if (i15 == 0) {
        j = 68;
      }
    }
    else
    {
      if ((i < paramInt2 + 2) || (this.tokenBuffer[(i - 1)] != '}') || (this.tokenBuffer[(i - 2)] == 65535) || (peek() != 58)) {
        break label297;
      }
      k = 1;
      m = -1;
      n = -1;
      i1 = -1;
      i2 = 0;
      i3 = paramInt2;
      i4 = paramInt2;
      if (i3 >= i) {
        break label459;
      }
      i12 = this.tokenBuffer[i3];
      if (i12 != 65535) {
        break label303;
      }
      i3++;
      if (i3 >= i) {
        break label730;
      }
      char[] arrayOfChar3 = this.tokenBuffer;
      i13 = i4 + 1;
      arrayOfChar3[i4] = this.tokenBuffer[i3];
    }
    for (;;)
    {
      i3++;
      i4 = i13;
      break label211;
      if (i14 == 0)
      {
        j = 85;
        break;
      }
      j = 80;
      break;
      label297:
      k = 0;
      break label193;
      label303:
      if (k != 0)
      {
        if (i12 != 123) {
          break label362;
        }
        if (n < 0)
        {
          n = i4;
          label324:
          i2++;
        }
      }
      else
      {
        label327:
        if (i2 <= 0) {
          break label400;
        }
      }
      for (;;)
      {
        char[] arrayOfChar2 = this.tokenBuffer;
        i13 = i4 + 1;
        arrayOfChar2[i4] = i12;
        break;
        if (i2 != 0) {
          break label324;
        }
        break label324;
        label362:
        if (i12 != 125) {
          break label327;
        }
        i2--;
        if ((i2 < 0) || (i2 != 0)) {
          break label327;
        }
        if (i1 < 0)
        {
          i1 = i4;
          break label327;
        }
        break label327;
        label400:
        if (i12 == 58)
        {
          if (m >= 0) {}
          for (m = -1;; m = i4) {
            break;
          }
        }
        char c;
        if (j == 85) {
          c = Character.toUpperCase(i12);
        } else if (j == 68) {
          c = Character.toLowerCase(c);
        }
      }
      label459:
      int i5 = i4;
      int i6 = i5 - paramInt2;
      if ((n >= 0) && (i1 > n))
      {
        char[] arrayOfChar1;
        int i11;
        if (n > 0)
        {
          arrayOfChar1 = this.tokenBuffer;
          i11 = n - paramInt2;
        }
        for (String str3 = new String(arrayOfChar1, paramInt2, i11);; str3 = null)
        {
          int i9 = n + 1;
          String str4 = new String(this.tokenBuffer, i9, i1 - i9);
          read();
          int i10 = read();
          Object localObject1 = readValues(i10, paramReadTable.lookup(i10), paramReadTable);
          if (!(localObject1 instanceof SimpleSymbol)) {
            error("expected identifier in symbol after '{URI}:'");
          }
          return Symbol.valueOf(localObject1.toString(), str4, str3);
        }
      }
      if ((paramReadTable.initialColonIsKeyword) && (m == paramInt2) && (i6 > 1))
      {
        int i8 = paramInt2 + 1;
        String str2 = new String(this.tokenBuffer, i8, i5 - i8);
        return Keyword.make(str2.intern());
      }
      if (paramReadTable.finalColonIsKeyword)
      {
        int i7 = i5 - 1;
        if ((m == i7) && ((i6 > 1) || (this.seenEscapes)))
        {
          String str1 = new String(this.tokenBuffer, paramInt2, i6 - 1);
          return Keyword.make(str1.intern());
        }
      }
      return paramReadTable.makeSymbol(new String(this.tokenBuffer, paramInt2, i6));
      label730:
      i13 = i4;
    }
  }
  
  public Object readCommand()
    throws IOException, SyntaxException
  {
    return readObject();
  }
  
  public int readEscape()
    throws IOException, SyntaxException
  {
    int i = read();
    if (i < 0)
    {
      eofError("unexpected EOF in character literal");
      return -1;
    }
    return readEscape(i);
  }
  
  public final int readEscape(int paramInt)
    throws IOException, SyntaxException
  {
    switch ((char)paramInt)
    {
    default: 
    case 'a': 
    case 'b': 
    case 't': 
    case 'n': 
    case 'v': 
    case 'f': 
    case 'r': 
    case 'e': 
    case '"': 
    case '\\': 
    case '\t': 
    case '\n': 
    case '\r': 
    case ' ': 
    case 'M': 
    case 'C': 
    case '^': 
    case '0': 
    case '1': 
    case '2': 
    case '3': 
    case '4': 
    case '5': 
    case '6': 
    case '7': 
      for (;;)
      {
        return paramInt;
        paramInt = 7;
        continue;
        paramInt = 8;
        continue;
        paramInt = 9;
        continue;
        paramInt = 10;
        continue;
        paramInt = 11;
        continue;
        paramInt = 12;
        continue;
        paramInt = 13;
        continue;
        paramInt = 27;
        continue;
        paramInt = 34;
        continue;
        paramInt = 92;
        continue;
        paramInt = read();
        if (paramInt < 0)
        {
          eofError("unexpected EOF in literal");
          return -1;
        }
        if (paramInt == 10)
        {
          if (paramInt != 10) {}
        }
        else
        {
          int i4;
          do
          {
            i4 = read();
            if (i4 < 0)
            {
              eofError("unexpected EOF in literal");
              return -1;
              if (paramInt == 13)
              {
                if (peek() == 10) {
                  skip();
                }
                paramInt = 10;
                break label322;
              }
              if ((paramInt == 32) || (paramInt == 9)) {
                break;
              }
              unread(paramInt);
              break label322;
            }
          } while ((i4 == 32) || (i4 == 9));
          unread(i4);
          return -2;
          if (read() != 45)
          {
            error("Invalid escape character syntax");
            return 63;
          }
          int i3 = read();
          if (i3 == 92) {
            i3 = readEscape();
          }
          return i3 | 0x80;
          if (read() != 45)
          {
            error("Invalid escape character syntax");
            return 63;
          }
          int i2 = read();
          if (i2 == 92) {
            i2 = readEscape();
          }
          if (i2 == 63) {
            return 127;
          }
          return i2 & 0x9F;
          paramInt -= 48;
          int m = 0;
          int n;
          for (;;)
          {
            m++;
            if (m >= 3) {
              break;
            }
            n = read();
            int i1 = Character.digit((char)n, 8);
            if (i1 < 0) {
              break label562;
            }
            paramInt = i1 + (paramInt << 3);
          }
          if (n >= 0) {
            unread(n);
          }
        }
      }
    case 'u': 
      label322:
      paramInt = 0;
      label562:
      int i = 4;
      for (;;)
      {
        i--;
        if (i < 0) {
          break;
        }
        int j = read();
        if (j < 0) {
          eofError("premature EOF in \\u escape");
        }
        int k = Character.digit((char)j, 16);
        if (k < 0) {
          error("non-hex character following \\u");
        }
        paramInt = k + paramInt * 16;
      }
    }
    return readHexEscape();
  }
  
  public int readHexEscape()
    throws IOException, SyntaxException
  {
    int j;
    int k;
    for (int i = 0;; i = k + (i << 4))
    {
      j = read();
      k = Character.digit((char)j, 16);
      if (k < 0) {
        break;
      }
    }
    if ((j != 59) && (j >= 0)) {
      unread(j);
    }
    return i;
  }
  
  public final void readNestedComment(char paramChar1, char paramChar2)
    throws IOException, SyntaxException
  {
    int i = 1;
    int j = this.port.getLineNumber();
    int k = this.port.getColumnNumber();
    do
    {
      char c = read();
      if (c == '|')
      {
        c = read();
        if (c == paramChar1) {
          i--;
        }
      }
      while (c < 0)
      {
        eofError("unexpected end-of-file in " + paramChar1 + paramChar2 + " comment starting here", j + 1, k - 1);
        return;
        if (c == paramChar1)
        {
          c = read();
          if (c == paramChar2) {
            i++;
          }
        }
      }
    } while (i > 0);
  }
  
  public Object readObject()
    throws IOException, SyntaxException
  {
    char c = ((InPort)this.port).readState;
    int i = this.tokenBufferLength;
    ((InPort)this.port).readState = ' ';
    try
    {
      ReadTable localReadTable = ReadTable.getCurrent();
      int j;
      int k;
      Object localObject3;
      do
      {
        j = this.port.getLineNumber();
        k = this.port.getColumnNumber();
        int m = this.port.read();
        if (m < 0)
        {
          Object localObject2 = Sequence.eofValue;
          return localObject2;
        }
        localObject3 = readValues(m, localReadTable);
      } while (localObject3 == Values.empty);
      Object localObject4 = handlePostfix(localObject3, localReadTable, j, k);
      return localObject4;
    }
    finally
    {
      this.tokenBufferLength = i;
      ((InPort)this.port).readState = c;
    }
  }
  
  public final Object readObject(int paramInt)
    throws IOException, SyntaxException
  {
    unread(paramInt);
    return readObject();
  }
  
  void readToken(int paramInt, char paramChar, ReadTable paramReadTable)
    throws IOException, SyntaxException
  {
    int i = 0;
    int j = 0;
    ReadTableEntry localReadTableEntry;
    int k;
    if (paramInt < 0)
    {
      if (i != 0) {
        eofError("unexpected EOF between escapes");
      }
    }
    else
    {
      localReadTableEntry = paramReadTable.lookup(paramInt);
      k = localReadTableEntry.getKind();
      if (k != 0) {
        break label93;
      }
      if (i != 0)
      {
        tokenBufferAppend(65535);
        tokenBufferAppend(paramInt);
      }
    }
    for (;;)
    {
      paramInt = read();
      break;
      if (paramInt == 125)
      {
        j--;
        if (j >= 0)
        {
          tokenBufferAppend(paramInt);
          continue;
        }
      }
      unread(paramInt);
      return;
      label93:
      if ((paramInt == paramReadTable.postfixLookupOperator) && (i == 0))
      {
        int n = this.port.peek();
        if (n == paramReadTable.postfixLookupOperator)
        {
          unread(paramInt);
          return;
        }
        if (validPostfixLookupStart(n, paramReadTable)) {
          k = 5;
        }
      }
      if (k == 3)
      {
        int m = read();
        if (m < 0) {
          eofError("unexpected EOF after single escape");
        }
        if ((paramReadTable.hexEscapeAfterBackslash) && ((m == 120) || (m == 88))) {
          m = readHexEscape();
        }
        tokenBufferAppend(65535);
        tokenBufferAppend(m);
        this.seenEscapes = true;
      }
      else
      {
        if (k == 4)
        {
          if (i == 0) {}
          for (i = 1;; i = 0)
          {
            this.seenEscapes = true;
            break;
          }
        }
        if (i != 0)
        {
          tokenBufferAppend(65535);
          tokenBufferAppend(paramInt);
        }
        else
        {
          switch (k)
          {
          case 3: 
          default: 
            break;
          case 1: 
            unread(paramInt);
            return;
          case 2: 
            if ((paramInt == 123) && (localReadTableEntry == ReadTableEntry.brace)) {
              j++;
            }
          case 6: 
            tokenBufferAppend(paramInt);
            break;
          case 4: 
            i = 1;
            this.seenEscapes = true;
          }
        }
      }
    }
    unread(paramInt);
  }
  
  public Object readValues(int paramInt, ReadTable paramReadTable)
    throws IOException, SyntaxException
  {
    return readValues(paramInt, paramReadTable.lookup(paramInt), paramReadTable);
  }
  
  public Object readValues(int paramInt, ReadTableEntry paramReadTableEntry, ReadTable paramReadTable)
    throws IOException, SyntaxException
  {
    int i = this.tokenBufferLength;
    this.seenEscapes = false;
    switch (paramReadTableEntry.getKind())
    {
    case 2: 
    case 3: 
    case 4: 
    default: 
      return readAndHandleToken(paramInt, i, paramReadTable);
    case 0: 
      String str = "invalid character #\\" + (char)paramInt;
      if (this.interactive) {
        fatal(str);
      }
      for (;;)
      {
        return Values.empty;
        error(str);
      }
    case 1: 
      return Values.empty;
    }
    return paramReadTableEntry.read(this, paramInt, -1);
  }
  
  protected void setCdr(Object paramObject1, Object paramObject2)
  {
    ((Pair)paramObject1).setCdrBackdoor(paramObject2);
  }
  
  protected boolean validPostfixLookupStart(int paramInt, ReadTable paramReadTable)
    throws IOException
  {
    if ((paramInt < 0) || (paramInt == 58) || (paramInt == paramReadTable.postfixLookupOperator)) {}
    int i;
    do
    {
      return false;
      if (paramInt == 44) {
        return true;
      }
      i = paramReadTable.lookup(paramInt).getKind();
    } while ((i != 2) && (i != 6) && (i != 4) && (i != 3));
    return true;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.LispReader
 * JD-Core Version:    0.7.0.1
 */