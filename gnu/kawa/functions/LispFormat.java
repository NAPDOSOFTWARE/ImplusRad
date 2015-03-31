package gnu.kawa.functions;

import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.math.IntNum;
import gnu.text.CaseConvertFormat;
import gnu.text.Char;
import gnu.text.CompoundFormat;
import gnu.text.FlushFormat;
import gnu.text.LiteralFormat;
import gnu.text.ReportFormat;
import java.text.Format;
import java.text.ParseException;
import java.util.Stack;
import java.util.Vector;

public class LispFormat
  extends CompoundFormat
{
  public static final String paramFromCount = "<from count>";
  public static final String paramFromList = "<from list>";
  public static final String paramUnspecified = "<unspecified>";
  
  public LispFormat(String paramString)
    throws ParseException
  {
    this(paramString.toCharArray());
  }
  
  public LispFormat(char[] paramArrayOfChar)
    throws ParseException
  {
    this(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public LispFormat(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws ParseException
  {
    super(null, 0);
    int i = -1;
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer(100);
    Stack localStack = new Stack();
    int k = paramInt1 + paramInt2;
    int n;
    for (int m = paramInt1;; m = n)
    {
      if (((m >= k) || (paramArrayOfChar[m] == '~')) && (localStringBuffer.length() > 0))
      {
        localStack.push(new LiteralFormat(localStringBuffer));
        localStringBuffer.setLength(0);
      }
      if (m >= k)
      {
        if (m <= k) {
          break label2923;
        }
        throw new IndexOutOfBoundsException();
      }
      n = m + 1;
      char c1 = paramArrayOfChar[m];
      if (c1 == '~') {
        break;
      }
      localStringBuffer.append(c1);
    }
    int i1 = localStack.size();
    int i2 = n + 1;
    char c2 = paramArrayOfChar[n];
    label160:
    if (c2 == '#')
    {
      localStack.push("<from count>");
      int i36 = i2 + 1;
      c2 = paramArrayOfChar[i2];
      i2 = i36;
    }
    label191:
    int i5;
    label202:
    boolean bool1;
    boolean bool2;
    label222:
    boolean bool4;
    label309:
    int i30;
    for (;;)
    {
      if (c2 != ',')
      {
        i5 = i2;
        bool1 = false;
        bool2 = false;
        int i29;
        for (m = i5; c2 == ':'; m = i29)
        {
          bool1 = true;
          i29 = m + 1;
          c2 = paramArrayOfChar[m];
        }
        if ((c2 == 'v') || (c2 == 'V'))
        {
          localStack.push("<from list>");
          int i3 = i2 + 1;
          c2 = paramArrayOfChar[i2];
          i2 = i3;
        }
        else if ((c2 == '-') || (Character.digit(c2, 10) >= 0))
        {
          if (c2 == '-')
          {
            bool4 = true;
            if (!bool4) {
              break label2992;
            }
            i30 = i2 + 1;
            c2 = paramArrayOfChar[i2];
          }
        }
      }
    }
    for (;;)
    {
      int i31 = 0;
      int i32 = i30;
      label333:
      int i33 = Character.digit(c2, 10);
      if (i33 < 0)
      {
        if (i30 - i32 >= 8) {
          break label424;
        }
        if (bool4) {
          i31 = -i31;
        }
      }
      label424:
      for (IntNum localIntNum = IntNum.make(i31);; localIntNum = IntNum.valueOf(paramArrayOfChar, i32, i30 - i32, 10, bool4))
      {
        localStack.push(localIntNum);
        i2 = i30;
        break;
        bool4 = false;
        break label309;
        i31 = i33 + i31 * 10;
        int i34 = i30 + 1;
        c2 = paramArrayOfChar[i30];
        i30 = i34;
        break label333;
      }
      if (c2 == '\'')
      {
        int i35 = i2 + 1;
        localStack.push(Char.make(paramArrayOfChar[i2]));
        i2 = i35 + 1;
        c2 = paramArrayOfChar[i35];
        break label191;
      }
      if (c2 == ',')
      {
        localStack.push("<unspecified>");
        break label191;
        int i4 = i2 + 1;
        c2 = paramArrayOfChar[i2];
        i2 = i4;
        break label160;
        if (c2 == '@')
        {
          bool2 = true;
          break label222;
        }
        char c3 = Character.toUpperCase(c2);
        int i6 = localStack.size() - i1;
        int i22;
        label912:
        Object localObject;
        switch (c3)
        {
        default: 
          throw new ParseException("unrecognized format specifier ~" + c3, m);
        case 'B': 
        case 'D': 
        case 'O': 
        case 'R': 
        case 'X': 
          int i21 = i1;
          if (c3 == 'R')
          {
            int i28 = i21 + 1;
            i22 = getParam(localStack, i21);
            i21 = i28;
            int i23 = getParam(localStack, i21);
            int i24 = getParam(localStack, i21 + 1);
            int i25 = getParam(localStack, i21 + 2);
            int i26 = getParam(localStack, i21 + 3);
            int i27 = 0;
            if (bool1) {
              i27 = 0x0 | 0x1;
            }
            if (bool2) {
              i27 |= 0x2;
            }
            localObject = IntegerFormat.getInstance(i22, i23, i24, i25, i26, i27);
          }
          break;
        }
        for (;;)
        {
          label995:
          localStack.setSize(i1);
          localStack.push(localObject);
          break;
          if (c3 == 'D')
          {
            i22 = 10;
            break label912;
          }
          if (c3 == 'O')
          {
            i22 = 8;
            break label912;
          }
          if (c3 == 'X')
          {
            i22 = 16;
            break label912;
          }
          i22 = 2;
          break label912;
          localObject = LispPluralFormat.getInstance(bool1, bool2);
          continue;
          LispRealFormat localLispRealFormat = new LispRealFormat();
          localLispRealFormat.op = c3;
          localLispRealFormat.arg1 = getParam(localStack, i1);
          localLispRealFormat.arg2 = getParam(localStack, i1 + 1);
          localLispRealFormat.arg3 = getParam(localStack, i1 + 2);
          localLispRealFormat.arg4 = getParam(localStack, i1 + 3);
          if (c3 != '$')
          {
            localLispRealFormat.arg5 = getParam(localStack, i1 + 4);
            if ((c3 == 'E') || (c3 == 'G'))
            {
              localLispRealFormat.arg6 = getParam(localStack, i1 + 5);
              localLispRealFormat.arg7 = getParam(localStack, i1 + 6);
            }
          }
          localLispRealFormat.showPlus = bool2;
          localLispRealFormat.internalPad = bool1;
          if (localLispRealFormat.argsUsed == 0)
          {
            localObject = localLispRealFormat.resolve(null, 0);
          }
          else
          {
            localObject = localLispRealFormat;
            continue;
            boolean bool3;
            label1258:
            ObjectFormat localObjectFormat;
            int i16;
            int i17;
            int i18;
            int i19;
            ReportFormat localReportFormat;
            if (c3 != 'A')
            {
              bool3 = true;
              localObjectFormat = ObjectFormat.getInstance(bool3);
              if (i6 <= 0) {
                break label2978;
              }
              i16 = getParam(localStack, i1);
              i17 = getParam(localStack, i1 + 1);
              i18 = getParam(localStack, i1 + 2);
              i19 = getParam(localStack, i1 + 3);
              localReportFormat = (ReportFormat)localObjectFormat;
              if (!bool2) {
                break label1357;
              }
            }
            label1357:
            for (int i20 = 0;; i20 = 100)
            {
              localObject = new LispObjectFormat(localReportFormat, i16, i17, i18, i19, i20);
              break;
              bool3 = false;
              break label1258;
            }
            if (i6 > 0) {}
            for (int i15 = getParam(localStack, i1);; i15 = -1610612736)
            {
              localObject = LispCharacterFormat.getInstance(i15, 1, bool2, bool1);
              break;
            }
            localObject = new LispRepositionFormat(getParam(localStack, i1), bool1, bool2);
            continue;
            char c4;
            if (bool1) {
              if (bool2) {
                c4 = 'U';
              }
            }
            for (;;)
            {
              CaseConvertFormat localCaseConvertFormat = new CaseConvertFormat(null, c4);
              localStack.setSize(i1);
              localStack.push(localCaseConvertFormat);
              localStack.push(IntNum.make(i));
              i = i1;
              break;
              c4 = 'C';
              continue;
              if (bool2) {
                c4 = 'T';
              } else {
                c4 = 'L';
              }
            }
            if ((i < 0) || (!(localStack.elementAt(i) instanceof CaseConvertFormat))) {
              throw new ParseException("saw ~) without matching ~(", m);
            }
            ((CaseConvertFormat)localStack.elementAt(i)).setBaseFormat(popFormats(localStack, i + 2, i1));
            i = ((IntNum)localStack.pop()).intValue();
            break;
            LispIterationFormat localLispIterationFormat3 = new LispIterationFormat();
            localLispIterationFormat3.seenAt = bool2;
            localLispIterationFormat3.maxIterations = 1;
            localLispIterationFormat3.atLeastOnce = true;
            localObject = localLispIterationFormat3;
            continue;
            LispIterationFormat localLispIterationFormat2 = new LispIterationFormat();
            localLispIterationFormat2.seenAt = bool2;
            localLispIterationFormat2.seenColon = bool1;
            localLispIterationFormat2.maxIterations = getParam(localStack, i1);
            localStack.setSize(i1);
            localStack.push(localLispIterationFormat2);
            localStack.push(IntNum.make(i));
            i = i1;
            break;
            if ((i < 0) || (!(localStack.elementAt(i) instanceof LispIterationFormat))) {
              throw new ParseException("saw ~} without matching ~{", m);
            }
            LispIterationFormat localLispIterationFormat1 = (LispIterationFormat)localStack.elementAt(i);
            localLispIterationFormat1.atLeastOnce = bool1;
            if (i1 > i + 2) {
              localLispIterationFormat1.body = popFormats(localStack, i + 2, i1);
            }
            i = ((IntNum)localStack.pop()).intValue();
            break;
            LispPrettyFormat localLispPrettyFormat3 = new LispPrettyFormat();
            localLispPrettyFormat3.seenAt = bool2;
            if (bool1) {
              localLispPrettyFormat3.prefix = "(";
            }
            for (localLispPrettyFormat3.suffix = ")";; localLispPrettyFormat3.suffix = "")
            {
              localStack.setSize(i1);
              localStack.push(localLispPrettyFormat3);
              localStack.push(IntNum.make(i));
              localStack.push(IntNum.make(j));
              i = i1;
              j = 0;
              break;
              localLispPrettyFormat3.prefix = "";
            }
            if ((i < 0) || (!(localStack.elementAt(i) instanceof LispPrettyFormat))) {
              throw new ParseException("saw ~> without matching ~<", m);
            }
            localStack.push(popFormats(localStack, j + (i + 3), i1));
            LispPrettyFormat localLispPrettyFormat2 = (LispPrettyFormat)localStack.elementAt(i);
            localLispPrettyFormat2.segments = getFormats(localStack, i + 3, localStack.size());
            localStack.setSize(i + 3);
            ((IntNum)localStack.pop()).intValue();
            i = ((IntNum)localStack.pop()).intValue();
            if (bool1)
            {
              int i14 = localLispPrettyFormat2.segments.length;
              if (i14 > 3) {
                throw new ParseException("too many segments in Logical Block format", m);
              }
              if (i14 >= 2)
              {
                if (!(localLispPrettyFormat2.segments[0] instanceof LiteralFormat)) {
                  throw new ParseException("prefix segment is not literal", m);
                }
                localLispPrettyFormat2.prefix = ((LiteralFormat)localLispPrettyFormat2.segments[0]).content();
              }
              for (localLispPrettyFormat2.body = localLispPrettyFormat2.segments[1]; i14 >= 3; localLispPrettyFormat2.body = localLispPrettyFormat2.segments[0])
              {
                if ((localLispPrettyFormat2.segments[2] instanceof LiteralFormat)) {
                  break label2129;
                }
                throw new ParseException("suffix segment is not literal", m);
              }
              label2129:
              localLispPrettyFormat2.suffix = ((LiteralFormat)localLispPrettyFormat2.segments[2]).content();
              break;
            }
            throw new ParseException("not implemented: justfication i.e. ~<...~>", m);
            LispChoiceFormat localLispChoiceFormat2 = new LispChoiceFormat();
            localLispChoiceFormat2.param = getParam(localStack, i1);
            if (localLispChoiceFormat2.param == -1073741824) {
              localLispChoiceFormat2.param = -1610612736;
            }
            if (bool1) {
              localLispChoiceFormat2.testBoolean = true;
            }
            if (bool2) {
              localLispChoiceFormat2.skipIfFalse = true;
            }
            localStack.setSize(i1);
            localStack.push(localLispChoiceFormat2);
            localStack.push(IntNum.make(i));
            localStack.push(IntNum.make(j));
            i = i1;
            j = 0;
            break;
            if (i >= 0)
            {
              if ((localStack.elementAt(i) instanceof LispChoiceFormat))
              {
                LispChoiceFormat localLispChoiceFormat1 = (LispChoiceFormat)localStack.elementAt(i);
                if (bool1) {
                  localLispChoiceFormat1.lastIsDefault = true;
                }
                localStack.push(popFormats(localStack, j + (i + 3), i1));
                j++;
                break;
              }
              if ((localStack.elementAt(i) instanceof LispPrettyFormat))
              {
                LispPrettyFormat localLispPrettyFormat1 = (LispPrettyFormat)localStack.elementAt(i);
                if (bool2) {
                  localLispPrettyFormat1.perLine = true;
                }
                localStack.push(popFormats(localStack, j + (i + 3), i1));
                j++;
                break;
              }
            }
            throw new ParseException("saw ~; without matching ~[ or ~<", m);
            if ((i < 0) || (!(localStack.elementAt(i) instanceof LispChoiceFormat))) {
              throw new ParseException("saw ~] without matching ~[", m);
            }
            localStack.push(popFormats(localStack, j + (i + 3), i1));
            ((LispChoiceFormat)localStack.elementAt(i)).choices = getFormats(localStack, i + 3, localStack.size());
            localStack.setSize(i + 3);
            j = ((IntNum)localStack.pop()).intValue();
            i = ((IntNum)localStack.pop()).intValue();
            break;
            localObject = new LispEscapeFormat(getParam(localStack, i1), getParam(localStack, i1 + 1), getParam(localStack, i1 + 2));
            continue;
            if (bool2) {
              localStringBuffer.append(c3);
            }
            if (bool1) {
              break;
            }
            while (m < k)
            {
              int i13 = m + 1;
              if (!Character.isWhitespace(paramArrayOfChar[m]))
              {
                m = i13 - 1;
                break;
                localObject = FlushFormat.getInstance();
                break label995;
                localObject = new LispTabulateFormat(getParam(localStack, i1), getParam(localStack, i1 + 1), getParam(localStack, i1 + 2), bool2);
                break label995;
                localObject = new LispFreshlineFormat(getParam(localStack, i1));
                break label995;
                int i12 = getParam(localStack, i1);
                if (i12 == -1073741824) {
                  i12 = 0;
                }
                localObject = LispIndentFormat.getInstance(i12, bool1);
                break label995;
                int i10 = getParam(localStack, i1);
                if (i10 == -1073741824) {
                  i10 = 1;
                }
                label2744:
                int i11;
                if ((bool1) && (bool2))
                {
                  if ((!bool2) || (!bool1)) {
                    break label2773;
                  }
                  i11 = 82;
                }
                for (;;)
                {
                  localObject = LispNewlineFormat.getInstance(i10, i11);
                  break;
                  break label2744;
                  label2773:
                  if (bool2) {
                    i11 = 77;
                  } else if (bool1) {
                    i11 = 70;
                  } else {
                    i11 = 78;
                  }
                }
                if (i6 == 0)
                {
                  localStringBuffer.append(c3);
                  break;
                }
                int i8 = getParam(localStack, i1);
                if (i8 == -1073741824) {
                  i8 = 1;
                }
                int i9 = getParam(localStack, i1 + 1);
                if (i9 == -1073741824) {
                  if (c3 != '|') {
                    break label2884;
                  }
                }
                label2884:
                for (i9 = 12;; i9 = 126)
                {
                  localObject = LispCharacterFormat.getInstance(i9, i8, false, false);
                  break;
                }
                int i7 = getParam(localStack, i1);
                if (i7 == -1073741824) {
                  i7 = 1;
                }
                localObject = LispNewlineFormat.getInstance(i7, 76);
                break label995;
                label2923:
                if (i >= 0) {
                  throw new ParseException("missing ~] or ~}", m);
                }
                this.length = localStack.size();
                this.formats = new Format[this.length];
                localStack.copyInto(this.formats);
                return;
              }
              m = i13;
            }
            label2978:
            localObject = localObjectFormat;
          }
        }
      }
      i5 = i2;
      break label202;
      label2992:
      i30 = i2;
    }
  }
  
  public static Object[] asArray(Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      return (Object[])paramObject;
    }
    if (!(paramObject instanceof Sequence)) {
      return null;
    }
    int i = ((Sequence)paramObject).size();
    Object[] arrayOfObject = new Object[i];
    int m;
    for (int j = 0; (paramObject instanceof Pair); j = m)
    {
      Pair localPair = (Pair)paramObject;
      m = j + 1;
      arrayOfObject[j] = localPair.getCar();
      paramObject = localPair.getCdr();
    }
    if (j < i)
    {
      if (!(paramObject instanceof Sequence)) {
        return null;
      }
      int k = j;
      Sequence localSequence = (Sequence)paramObject;
      while (j < i)
      {
        arrayOfObject[j] = localSequence.get(k + j);
        j++;
      }
    }
    return arrayOfObject;
  }
  
  static Format[] getFormats(Vector paramVector, int paramInt1, int paramInt2)
  {
    Format[] arrayOfFormat = new Format[paramInt2 - paramInt1];
    for (int i = paramInt1; i < paramInt2; i++) {
      arrayOfFormat[(i - paramInt1)] = ((Format)paramVector.elementAt(i));
    }
    return arrayOfFormat;
  }
  
  public static int getParam(Vector paramVector, int paramInt)
  {
    if (paramInt >= paramVector.size()) {}
    Object localObject;
    do
    {
      return -1073741824;
      localObject = paramVector.elementAt(paramInt);
      if (localObject == "<from list>") {
        return -1610612736;
      }
      if (localObject == "<from count>") {
        return -1342177280;
      }
    } while (localObject == "<unspecified>");
    return getParam(localObject, -1073741824);
  }
  
  static Format popFormats(Vector paramVector, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1 + 1) {}
    for (Object localObject = (Format)paramVector.elementAt(paramInt1);; localObject = new CompoundFormat(getFormats(paramVector, paramInt1, paramInt2)))
    {
      paramVector.setSize(paramInt1);
      return localObject;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.LispFormat
 * JD-Core Version:    0.7.0.1
 */