package gnu.xml;

import gnu.lists.Consumer;
import gnu.text.LineBufferedReader;
import gnu.text.LineInputStreamReader;
import gnu.text.Path;
import gnu.text.SourceMessages;
import java.io.IOException;
import java.io.InputStream;

public class XMLParser
{
  private static final int ATTRIBUTE_SEEN_EQ_STATE = 11;
  private static final int ATTRIBUTE_SEEN_NAME_STATE = 8;
  static final String BAD_ENCODING_SYNTAX = "bad 'encoding' declaration";
  static final String BAD_STANDALONE_SYNTAX = "bad 'standalone' declaration";
  private static final int BEGIN_ELEMENT_STATE = 2;
  private static final int DOCTYPE_NAME_SEEN_STATE = 16;
  private static final int DOCTYPE_SEEN_STATE = 13;
  private static final int END_ELEMENT_STATE = 4;
  private static final int EXPECT_NAME_MODIFIER = 1;
  private static final int EXPECT_RIGHT_STATE = 27;
  private static final int INIT_LEFT_QUEST_STATE = 30;
  private static final int INIT_LEFT_STATE = 34;
  private static final int INIT_STATE = 0;
  private static final int INIT_TEXT_STATE = 31;
  private static final int INVALID_VERSION_DECL = 35;
  private static final int MAYBE_ATTRIBUTE_STATE = 10;
  private static final int PREV_WAS_CR_STATE = 28;
  private static final int SAW_AMP_SHARP_STATE = 26;
  private static final int SAW_AMP_STATE = 25;
  private static final int SAW_ENTITY_REF = 6;
  private static final int SAW_EOF_ERROR = 37;
  private static final int SAW_ERROR = 36;
  private static final int SAW_LEFT_EXCL_MINUS_STATE = 22;
  private static final int SAW_LEFT_EXCL_STATE = 20;
  private static final int SAW_LEFT_QUEST_STATE = 21;
  private static final int SAW_LEFT_SLASH_STATE = 19;
  private static final int SAW_LEFT_STATE = 14;
  private static final int SKIP_SPACES_MODIFIER = 2;
  private static final int TEXT_STATE = 1;
  
  public static LineInputStreamReader XMLStreamReader(InputStream paramInputStream)
    throws IOException
  {
    int i = -1;
    LineInputStreamReader localLineInputStreamReader = new LineInputStreamReader(paramInputStream);
    int j = localLineInputStreamReader.getByte();
    int k;
    int m;
    if (j < 0)
    {
      k = i;
      if (k >= 0) {
        break label81;
      }
      m = i;
      label31:
      if ((j != 239) || (k != 187) || (m != 191)) {
        break label90;
      }
      localLineInputStreamReader.resetStart(3);
      localLineInputStreamReader.setCharset("UTF-8");
    }
    label400:
    for (;;)
    {
      localLineInputStreamReader.setKeepFullLines(false);
      return localLineInputStreamReader;
      k = localLineInputStreamReader.getByte();
      break;
      label81:
      m = localLineInputStreamReader.getByte();
      break label31;
      label90:
      if ((j == 255) && (k == 254) && (m != 0))
      {
        localLineInputStreamReader.resetStart(2);
        localLineInputStreamReader.setCharset("UTF-16LE");
      }
      else if ((j == 254) && (k == 255) && (m != 0))
      {
        localLineInputStreamReader.resetStart(2);
        localLineInputStreamReader.setCharset("UTF-16BE");
      }
      else
      {
        if (m < 0) {}
        while ((j == 76) && (k == 111) && (m == 167) && (i == 148))
        {
          throw new RuntimeException("XMLParser: EBCDIC encodings not supported");
          i = localLineInputStreamReader.getByte();
        }
        localLineInputStreamReader.resetStart(0);
        if (((j == 60) && (((k == 63) && (m == 120) && (i == 109)) || ((k == 0) && (m == 63) && (i == 0)))) || ((j == 0) && (k == 60) && (m == 0) && (i == 63)))
        {
          char[] arrayOfChar = localLineInputStreamReader.buffer;
          if (arrayOfChar == null)
          {
            arrayOfChar = new char[8192];
            localLineInputStreamReader.buffer = arrayOfChar;
          }
          int n = 0;
          int i1 = 0;
          int i2;
          do
          {
            i2 = localLineInputStreamReader.getByte();
          } while (i2 == 0);
          if (i2 < 0) {}
          int i3;
          for (;;)
          {
            localLineInputStreamReader.pos = 0;
            localLineInputStreamReader.limit = n;
            break;
            i3 = n + 1;
            arrayOfChar[n] = ((char)(i2 & 0xFF));
            if (i1 != 0) {
              break label400;
            }
            if (i2 != 62) {
              break label375;
            }
            n = i3;
          }
          label375:
          if ((i2 == 39) || (i2 == 34)) {
            i1 = i2;
          }
          for (;;)
          {
            n = i3;
            break;
            if (i2 == i1) {
              i1 = 0;
            }
          }
        }
        localLineInputStreamReader.setCharset("UTF-8");
      }
    }
  }
  
  public static void parse(LineBufferedReader paramLineBufferedReader, SourceMessages paramSourceMessages, Consumer paramConsumer)
    throws IOException
  {
    XMLFilter localXMLFilter = new XMLFilter(paramConsumer);
    localXMLFilter.setMessages(paramSourceMessages);
    localXMLFilter.setSourceLocator(paramLineBufferedReader);
    localXMLFilter.startDocument();
    Path localPath = paramLineBufferedReader.getPath();
    if (localPath != null) {
      localXMLFilter.writeDocumentUri(localPath);
    }
    parse(paramLineBufferedReader, localXMLFilter);
    localXMLFilter.endDocument();
  }
  
  public static void parse(LineBufferedReader paramLineBufferedReader, SourceMessages paramSourceMessages, XMLFilter paramXMLFilter)
    throws IOException
  {
    paramXMLFilter.setMessages(paramSourceMessages);
    paramXMLFilter.setSourceLocator(paramLineBufferedReader);
    paramXMLFilter.startDocument();
    Path localPath = paramLineBufferedReader.getPath();
    if (localPath != null) {
      paramXMLFilter.writeDocumentUri(localPath);
    }
    parse(paramLineBufferedReader, paramXMLFilter);
    paramXMLFilter.endDocument();
    paramLineBufferedReader.close();
  }
  
  public static void parse(LineBufferedReader paramLineBufferedReader, XMLFilter paramXMLFilter)
  {
    char[] arrayOfChar = paramLineBufferedReader.buffer;
    int i = paramLineBufferedReader.pos;
    int j = paramLineBufferedReader.limit;
    int k = 0;
    char c = '<';
    int m = 14;
    int n = 32;
    int i3 = 0;
    int i4 = -1;
    String str1 = null;
    int i5 = j;
    for (;;)
    {
      label212:
      label215:
      label379:
      int i12;
      switch (k)
      {
      case 18: 
      case 22: 
      default: 
        i6 = i;
      case 0: 
      case 31: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 1: 
      case 28: 
      case 12: 
      case 15: 
      case 23: 
      case 29: 
      case 32: 
      case 3: 
      case 5: 
      case 7: 
      case 9: 
      case 17: 
      case 24: 
      case 33: 
        for (;;)
        {
          if (i6 < j)
          {
            i = i6 + 1;
            n = arrayOfChar[i6];
            break;
            k = 31;
            i6 = i;
            continue;
            if (n == 60)
            {
              k = 34;
              i6 = i;
            }
            else
            {
              k = 1;
              break;
              if (n == 63)
              {
                i5 = i;
                k = 33;
                i6 = i;
              }
              else
              {
                k = 14;
                break;
                i = i4;
                str1 = "invalid xml version specifier";
                paramLineBufferedReader.pos = i;
                paramXMLFilter.error('e', str1);
                do
                {
                  int i34 = i;
                  if (i34 >= j) {
                    return;
                  }
                  i = i34 + 1;
                  n = arrayOfChar[i34];
                } while (n != 62);
                k = 1;
                i6 = i;
                continue;
                paramLineBufferedReader.pos = i;
                paramXMLFilter.error('f', "unexpected end-of-file");
                return;
                i5 = i - 1;
                int i28 = i;
                i6 = i;
                for (;;)
                {
                  if (n == c) {
                    k = m;
                  }
                  for (int i31 = i6;; i31 = i6)
                  {
                    label394:
                    i3 = i31 - i28;
                    if (i3 > 0)
                    {
                      paramLineBufferedReader.pos = i31;
                      paramXMLFilter.textFromParser(arrayOfChar, i5, i3);
                    }
                    i5 = arrayOfChar.length;
                    i6 = i31;
                    break;
                    if (n != 38) {
                      break label450;
                    }
                    k = 25;
                  }
                  label450:
                  int i33;
                  if (n == 13)
                  {
                    i3 = i6 - i28;
                    paramLineBufferedReader.pos = i6;
                    if (i3 > 0) {
                      paramXMLFilter.textFromParser(arrayOfChar, i5, i3);
                    }
                    if (i6 < j)
                    {
                      n = arrayOfChar[i6];
                      if (n == 10)
                      {
                        i5 = i6;
                        i33 = i6 + 1;
                        i28 = i33;
                        label518:
                        paramLineBufferedReader.incrLineNumber(1, i33);
                        i6 = i33;
                      }
                    }
                  }
                  for (;;)
                  {
                    if (i6 != j) {
                      break label702;
                    }
                    i28--;
                    i31 = i6;
                    break label394;
                    paramXMLFilter.linefeedFromParser();
                    if (n == 133)
                    {
                      i33 = i6 + 1;
                      i5 = i6;
                      i28 = i33 + 1;
                      break label518;
                    }
                    paramLineBufferedReader.incrLineNumber(1, i6);
                    i5 = i6;
                    int i32 = i6 + 1;
                    i28 = i32;
                    i6 = i32;
                    break label379;
                    paramXMLFilter.linefeedFromParser();
                    k = 28;
                    break;
                    if ((n == 133) || (n == 8232))
                    {
                      int i29 = i6 - i28;
                      paramLineBufferedReader.pos = (i6 - 1);
                      if (i29 > 0) {
                        paramXMLFilter.textFromParser(arrayOfChar, i5, i29);
                      }
                      paramXMLFilter.linefeedFromParser();
                      paramLineBufferedReader.incrLineNumber(1, i6);
                      i28 = i6 + 1;
                      i5 = i6;
                    }
                    else if (n == 10)
                    {
                      paramLineBufferedReader.incrLineNumber(1, i6);
                    }
                  }
                  label702:
                  int i30 = i6 + 1;
                  n = arrayOfChar[i6];
                  i6 = i30;
                }
                k = 1;
                int i26;
                if (n == 10)
                {
                  i26 = 1;
                  label734:
                  if (n != 133) {
                    break label771;
                  }
                }
                label771:
                for (int i27 = 1;; i27 = 0)
                {
                  if ((i27 | i26) == 0) {
                    break label777;
                  }
                  paramLineBufferedReader.incrLineNumber(1, i);
                  i6 = i;
                  break;
                  i26 = 0;
                  break label734;
                }
                label777:
                paramLineBufferedReader.incrLineNumber(1, i - 1);
                break;
                if (n == 32) {
                  break label212;
                }
                if (n == 9)
                {
                  i6 = i;
                }
                else if ((n == 10) || (n == 13) || (n == 133) || (n == 8232))
                {
                  paramLineBufferedReader.incrLineNumber(1, i);
                  i6 = i;
                }
                else
                {
                  k -= 2;
                  break;
                  i3 = i5 + 1;
                  int i25;
                  for (i6 = i;; i6 = i25)
                  {
                    if (((n < 97) || (n > 122)) && ((n < 65) || (n > 90)) && (n != 95) && (n != 58) && ((n < 192) || ((n > 767) && ((n < 880) || (((n > 8191) || (n == 894)) && ((n < 8204) || ((n > 8205) && ((n < 8304) || (n > 8591)) && ((n < 11264) || (n > 12271)) && ((n < 12289) || (n > 55295)) && ((n < 63744) || (n > 65533)))))))) && ((i6 <= i3) || (n < 48) || (n > 57)) && (n != 46) && (n != 45) && (n != 183) && ((n <= 768) || ((n > 879) && ((n < 8255) || (n > 8256))))) {
                      break label1125;
                    }
                    if (i6 >= j) {
                      break;
                    }
                    i25 = i6 + 1;
                    n = arrayOfChar[i6];
                  }
                  label1125:
                  k--;
                  i3 = i6 - i3;
                  if (i3 != 0) {
                    break label3813;
                  }
                  if (k == 8) {
                    str1 = "missing or invalid attribute name";
                  }
                  for (;;)
                  {
                    k = 36;
                    i = i6;
                    break;
                    if ((k == 2) || (k == 4)) {
                      str1 = "missing or invalid element name";
                    } else {
                      str1 = "missing or invalid name";
                    }
                  }
                  label1187:
                  if ((n == 120) && (i4 == 0))
                  {
                    i4 = 16;
                    if (i6 >= j) {
                      continue;
                    }
                    i12 = i6 + 1;
                    n = arrayOfChar[i6];
                  }
                }
              }
            }
          }
        }
      }
      for (int i6 = i12;; i6 = i)
      {
        if (n != 59) {
          break label1187;
        }
        paramLineBufferedReader.pos = i6;
        paramXMLFilter.emitCharacterReference(i3, arrayOfChar, i5, i6 - 1 - i5);
        k = 1;
        break label215;
        if (i3 >= 134217728)
        {
          label1268:
          paramLineBufferedReader.pos = i6;
          paramXMLFilter.error('e', "invalid character reference");
          k = 1;
          break label215;
        }
        if (i4 == 0) {}
        for (int i10 = 10;; i10 = i4)
        {
          int i11 = Character.digit(n, i10);
          if (i11 < 0) {
            break label1268;
          }
          i3 = i11 + i3 * i10;
          break;
        }
        if (n == 35)
        {
          k = 26;
          i5 = i;
          i6 = i;
          i3 = 0;
          i4 = 0;
          break label215;
        }
        i5 = i - 1;
        k = 7;
        break;
        paramLineBufferedReader.pos = i;
        if (n != 59) {
          paramXMLFilter.error('w', "missing ';'");
        }
        paramXMLFilter.emitEntityReference(arrayOfChar, i5, i3);
        i5 = j;
        k = 1;
        i6 = i;
        break label215;
        if (n == 47)
        {
          k = 19;
          i6 = i;
          break label215;
        }
        if (n == 63)
        {
          i5 = i;
          k = 24;
          i6 = i;
          break label215;
        }
        if (n == 33)
        {
          k = 20;
          i5 = i;
          i6 = i;
          break label215;
        }
        i5 = i - 1;
        k = 3;
        break;
        paramLineBufferedReader.pos = (i - i3);
        paramXMLFilter.emitStartElement(arrayOfChar, i5, i3);
        k = 12;
        i5 = j;
        break;
        label1520:
        int i1;
        label1939:
        label2644:
        label2777:
        int i14;
        if (i4 < 0)
        {
          i4 = i - 1;
          label2738:
          int i17;
          for (i6 = i;; i6 = i17)
          {
            if (n == 62)
            {
              int i18 = i6 - 2;
              if ((arrayOfChar[i18] == '?') && (i18 >= i4))
              {
                paramLineBufferedReader.pos = i6;
                if ((i3 == 3) && (arrayOfChar[i5] == 'x') && (arrayOfChar[(i5 + 1)] == 'm') && (arrayOfChar[(i5 + 2)] == 'l'))
                {
                  if (k == 30)
                  {
                    if ((i18 <= i4 + 7) || (arrayOfChar[i4] != 'v') || (arrayOfChar[(i4 + 1)] != 'e') || (arrayOfChar[(i4 + 2)] != 'r') || (arrayOfChar[(i4 + 3)] != 's') || (arrayOfChar[(i4 + 4)] != 'i') || (arrayOfChar[(i4 + 5)] != 'o') || (arrayOfChar[(i4 + 6)] != 'n'))
                    {
                      i = i4;
                      str1 = "xml declaration without version";
                      k = 36;
                      break;
                    }
                    i4 += 7;
                    for (i1 = arrayOfChar[i4]; Character.isWhitespace(i1); i1 = arrayOfChar[i4])
                    {
                      i4++;
                      if (i4 >= i18) {
                        break;
                      }
                    }
                    if (i1 != 61)
                    {
                      k = 35;
                      i = i6;
                      break;
                    }
                    i4++;
                    for (i1 = arrayOfChar[i4]; Character.isWhitespace(i1); i1 = arrayOfChar[i4])
                    {
                      i4++;
                      if (i4 >= i18) {
                        break;
                      }
                    }
                    if ((i1 != 39) && (i1 != 34))
                    {
                      k = 35;
                      i = i6;
                      break;
                    }
                    int i19 = i1;
                    i4++;
                    for (int i20 = i4;; i20++)
                    {
                      if (i20 == i18)
                      {
                        k = 35;
                        i = i6;
                        break;
                      }
                      i1 = arrayOfChar[i20];
                      if (i1 == i19)
                      {
                        if ((i20 == i4 + 3) && (arrayOfChar[i4] == '1') && (arrayOfChar[(i4 + 1)] == '.'))
                        {
                          i1 = arrayOfChar[(i4 + 2)];
                          if (i1 == 48) {}
                        }
                        else
                        {
                          if (i1 != 49) {
                            break label1939;
                          }
                        }
                        for (i4 = i20 + 1; (i4 < i18) && (Character.isWhitespace(arrayOfChar[i4])); i4++) {}
                      }
                    }
                    k = 35;
                    i = i6;
                    break;
                    if ((i18 > i4 + 7) && (arrayOfChar[i4] == 'e') && (arrayOfChar[(i4 + 1)] == 'n') && (arrayOfChar[(i4 + 2)] == 'c') && (arrayOfChar[(i4 + 3)] == 'o') && (arrayOfChar[(i4 + 4)] == 'd') && (arrayOfChar[(i4 + 5)] == 'i') && (arrayOfChar[(i4 + 6)] == 'n') && (arrayOfChar[(i4 + 7)] == 'g'))
                    {
                      i4 += 8;
                      for (i1 = arrayOfChar[i4]; Character.isWhitespace(i1); i1 = arrayOfChar[i4])
                      {
                        i4++;
                        if (i4 >= i18) {
                          break;
                        }
                      }
                      if (i1 != 61)
                      {
                        str1 = "bad 'encoding' declaration";
                        k = 36;
                        i = i6;
                        break;
                      }
                      i4++;
                      for (i1 = arrayOfChar[i4]; Character.isWhitespace(i1); i1 = arrayOfChar[i4])
                      {
                        i4++;
                        if (i4 >= i18) {
                          break;
                        }
                      }
                      if ((i1 != 39) && (i1 != 34))
                      {
                        str1 = "bad 'encoding' declaration";
                        k = 36;
                        i = i6;
                        break;
                      }
                      int i23 = i1;
                      i4++;
                      for (int i24 = i4;; i24++)
                      {
                        if (i24 == i18)
                        {
                          str1 = "bad 'encoding' declaration";
                          k = 36;
                          i = i6;
                          break;
                        }
                        i1 = arrayOfChar[i24];
                        if (i1 == i23)
                        {
                          String str2 = new String(arrayOfChar, i4, i24 - i4);
                          if ((paramLineBufferedReader instanceof LineInputStreamReader)) {
                            ((LineInputStreamReader)paramLineBufferedReader).setCharset(str2);
                          }
                          for (i4 = i24 + 1; (i4 < i18) && (Character.isWhitespace(arrayOfChar[i4])); i4++) {}
                        }
                      }
                    }
                    if ((i18 > i4 + 9) && (arrayOfChar[i4] == 's') && (arrayOfChar[(i4 + 1)] == 't') && (arrayOfChar[(i4 + 2)] == 'a') && (arrayOfChar[(i4 + 3)] == 'n') && (arrayOfChar[(i4 + 4)] == 'd') && (arrayOfChar[(i4 + 5)] == 'a') && (arrayOfChar[(i4 + 6)] == 'l') && (arrayOfChar[(i4 + 7)] == 'o') && (arrayOfChar[(i4 + 8)] == 'n') && (arrayOfChar[(i4 + 9)] == 'e'))
                    {
                      i4 += 10;
                      for (i1 = arrayOfChar[i4]; Character.isWhitespace(i1); i1 = arrayOfChar[i4])
                      {
                        i4++;
                        if (i4 >= i18) {
                          break;
                        }
                      }
                      if (i1 != 61)
                      {
                        str1 = "bad 'standalone' declaration";
                        k = 36;
                        i = i6;
                        break;
                      }
                      i4++;
                      for (i1 = arrayOfChar[i4]; Character.isWhitespace(i1); i1 = arrayOfChar[i4])
                      {
                        i4++;
                        if (i4 >= i18) {
                          break;
                        }
                      }
                      if ((i1 != 39) && (i1 != 34))
                      {
                        str1 = "bad 'standalone' declaration";
                        k = 36;
                        i = i6;
                        break;
                      }
                      int i21 = i1;
                      i4++;
                      int i22 = i4;
                      if (i22 == i18)
                      {
                        str1 = "bad 'standalone' declaration";
                        k = 36;
                        i = i6;
                        break;
                      }
                      i1 = arrayOfChar[i22];
                      if (i1 == i21) {
                        if ((i22 != i4 + 3) || (arrayOfChar[i4] != 'y') || (arrayOfChar[(i4 + 1)] != 'e') || (arrayOfChar[(i4 + 2)] != 's')) {
                          break label2644;
                        }
                      }
                      while ((i22 == i4 + 2) && (arrayOfChar[i4] == 'n') && (arrayOfChar[(i4 + 1)] == 'o'))
                      {
                        for (i4 = i22 + 1; (i4 < i18) && (Character.isWhitespace(arrayOfChar[i4])); i4++) {}
                        i22++;
                        break;
                      }
                      str1 = "bad 'standalone' declaration";
                      k = 36;
                      i = i6;
                      break;
                    }
                    if (i18 == i4) {
                      break label2738;
                    }
                    str1 = "junk at end of xml declaration";
                    i = i4;
                    k = 36;
                    break;
                  }
                  str1 = "<?xml must be at start of file";
                  k = 36;
                  i = i6;
                  break;
                }
                paramXMLFilter.processingInstructionFromParser(arrayOfChar, i5, i3, i4, i18 - i4);
                i5 = j;
                i4 = -1;
                k = 1;
                break label215;
              }
            }
            if (i6 >= j) {
              break label215;
            }
            i17 = i6 + 1;
            i1 = arrayOfChar[i6];
          }
          if (i6 >= j) {
            break label215;
          }
          i14 = i6 + 1;
          i1 = arrayOfChar[i6];
        }
        for (i6 = i14;; i6 = i)
        {
          if (i1 == 62)
          {
            i3 = i6 - 1 - i5;
            if ((i3 >= 4) && (arrayOfChar[i5] == '-') && (arrayOfChar[(i5 + 1)] == '-'))
            {
              if ((arrayOfChar[(i6 - 2)] != '-') || (arrayOfChar[(i6 - 3)] != '-')) {
                break label2777;
              }
              paramLineBufferedReader.pos = i6;
              paramXMLFilter.commentFromParser(arrayOfChar, i5 + 2, i3 - 4);
            }
            for (;;)
            {
              i5 = j;
              k = 1;
              break;
              if ((i3 >= 6) && (arrayOfChar[i5] == '[') && (arrayOfChar[(i5 + 1)] == 'C') && (arrayOfChar[(i5 + 2)] == 'D') && (arrayOfChar[(i5 + 3)] == 'A') && (arrayOfChar[(i5 + 4)] == 'T') && (arrayOfChar[(i5 + 5)] == 'A') && (arrayOfChar[(i5 + 6)] == '['))
              {
                if ((arrayOfChar[(i6 - 2)] != ']') || (arrayOfChar[(i6 - 3)] != ']')) {
                  break label2777;
                }
                paramLineBufferedReader.pos = i6;
                paramXMLFilter.writeCDATA(arrayOfChar, i5 + 7, i6 - 10 - i5);
              }
            }
          }
          int i13 = i5 + 7;
          if ((i6 != i13) || (arrayOfChar[i5] != 'D') || (arrayOfChar[(i5 + 1)] != 'O') || (arrayOfChar[(i5 + 2)] != 'C') || (arrayOfChar[(i5 + 3)] != 'T') || (arrayOfChar[(i5 + 4)] != 'Y') || (arrayOfChar[(i5 + 5)] != 'P') || (i1 != 69)) {
            break label2777;
          }
          i5 = j;
          k = 15;
          break label215;
          k = 17;
          i5 = i - 1;
          break;
          if (i4 < 0)
          {
            i4 = i - 1 - i5 << 1;
            c = '\000';
            i6 = i;
          }
          for (;;)
          {
            label3154:
            if ((i1 == 39) || (i1 == 34)) {
              if (c == 0) {
                c = i1;
              }
            }
            label3254:
            do
            {
              while (i6 < j)
              {
                int i15 = i6 + 1;
                i1 = arrayOfChar[i6];
                i6 = i15;
                break label3154;
                if (c == i1)
                {
                  c = '\000';
                  continue;
                  if (c == 0) {
                    if (i1 == 91)
                    {
                      i4 |= 0x1;
                    }
                    else
                    {
                      if (i1 != 93) {
                        break label3254;
                      }
                      i4 &= 0xFFFFFFFE;
                    }
                  }
                }
              }
            } while ((i1 != 62) || ((i4 & 0x1) != 0));
            paramLineBufferedReader.pos = i6;
            int i16 = i5 + (i4 >> 1);
            paramXMLFilter.emitDoctypeDecl(arrayOfChar, i5, i3, i16, i6 - 1 - i16);
            c = '<';
            i5 = j;
            i4 = -1;
            k = 1;
            break label215;
            c = '<';
            m = 14;
            if (i1 == 47)
            {
              paramLineBufferedReader.pos = i;
              paramXMLFilter.emitEndAttributes();
              paramXMLFilter.emitEndElement(null, 0, 0);
              k = 27;
              i6 = i;
              break label215;
            }
            if (i1 == 62)
            {
              paramLineBufferedReader.pos = i;
              paramXMLFilter.emitEndAttributes();
              k = 1;
              i6 = i;
              break label215;
            }
            i5 = i - 1;
            k = 9;
            break;
            if ((i1 == 32) || (i1 == 9) || (i1 == 13) || (i1 == 10) || (i1 == 133)) {
              break label212;
            }
            if (i1 == 8232)
            {
              i6 = i;
              break label215;
            }
            paramLineBufferedReader.pos = (i - i3);
            paramXMLFilter.emitStartAttribute(arrayOfChar, i5, i3);
            i5 = j;
            if (i1 == 61)
            {
              k = 11;
              i6 = i;
              break label215;
            }
            paramXMLFilter.emitEndAttributes();
            str1 = "missing or misplaced '=' after attribute name";
            k = 36;
            break;
            if ((i1 == 39) || (i1 == 34))
            {
              c = i1;
              m = 12;
              k = 1;
              i6 = i;
              break label215;
            }
            if ((i1 == 32) || (i1 == 9) || (i1 == 13) || (i1 == 10) || (i1 == 133)) {
              break label212;
            }
            if (i1 == 8232)
            {
              i6 = i;
              break label215;
            }
            str1 = "missing or unquoted attribute value";
            k = 36;
            break;
            i5 = i - 1;
            k = 5;
            break;
            paramLineBufferedReader.pos = i;
            paramXMLFilter.emitEndElement(arrayOfChar, i5, i3);
            i5 = j;
            k = 29;
            break;
            if (i1 != 62)
            {
              str1 = "missing '>'";
              k = 36;
              break;
            }
            k = 1;
            i6 = i;
            break label215;
            int i7 = i6 - i5;
            if (i7 > 0) {}
            label3794:
            for (;;)
            {
              try
              {
                paramLineBufferedReader.pos = i5;
                paramLineBufferedReader.mark(i7 + 1);
                paramLineBufferedReader.pos = i6;
                if (paramLineBufferedReader.read() < 0)
                {
                  if (k == 1) {
                    break label3831;
                  }
                  if (k != 28) {
                    break label3835;
                  }
                  break label3831;
                }
                if (i7 > 0)
                {
                  paramLineBufferedReader.reset();
                  paramLineBufferedReader.skip(i7);
                  int i8 = paramLineBufferedReader.pos;
                  arrayOfChar = paramLineBufferedReader.buffer;
                  j = paramLineBufferedReader.limit;
                  if (i7 <= 0) {
                    break label3794;
                  }
                  i5 = i8 - i7;
                  int i9 = i8 + 1;
                  int i2 = arrayOfChar[i8];
                  i = i9;
                  break;
                }
                paramLineBufferedReader.unread_quick();
                continue;
                i5 = j;
              }
              catch (IOException localIOException)
              {
                throw new RuntimeException(localIOException.getMessage());
              }
            }
            i6 = i;
          }
          i6 = i;
          break label1520;
          label3813:
          i = i6;
          break;
        }
      }
      label3831:
      return;
      label3835:
      k = 37;
      i = i6;
    }
  }
  
  public static void parse(InputStream paramInputStream, Object paramObject, SourceMessages paramSourceMessages, Consumer paramConsumer)
    throws IOException
  {
    LineInputStreamReader localLineInputStreamReader = XMLStreamReader(paramInputStream);
    if (paramObject != null) {
      localLineInputStreamReader.setName(paramObject);
    }
    parse(localLineInputStreamReader, paramSourceMessages, paramConsumer);
    localLineInputStreamReader.close();
  }
  
  public static void parse(Object paramObject, SourceMessages paramSourceMessages, Consumer paramConsumer)
    throws IOException
  {
    parse(Path.openInputStream(paramObject), paramObject, paramSourceMessages, paramConsumer);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.xml.XMLParser
 * JD-Core Version:    0.7.0.1
 */