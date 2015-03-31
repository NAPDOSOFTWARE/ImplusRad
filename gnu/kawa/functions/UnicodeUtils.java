package gnu.kawa.functions;

import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import java.text.BreakIterator;

public class UnicodeUtils
{
  static final Symbol Cc;
  static final Symbol Cf;
  static final Symbol Cn;
  static final Symbol Co;
  static final Symbol Cs;
  static final Symbol Ll;
  static final Symbol Lm;
  static final Symbol Lo;
  static final Symbol Lt;
  static final Symbol Lu;
  static final Symbol Mc;
  static final Symbol Me;
  static final Symbol Mn;
  static final Symbol Nd;
  static final Symbol Nl;
  static final Symbol No;
  static final Symbol Pc;
  static final Symbol Pd;
  static final Symbol Pe;
  static final Symbol Pf;
  static final Symbol Pi;
  static final Symbol Po;
  static final Symbol Ps;
  static final Symbol Sc;
  static final Symbol Sk;
  static final Symbol Sm;
  static final Symbol So;
  static final Symbol Zl;
  static final Symbol Zp;
  static final Symbol Zs;
  
  static
  {
    Namespace localNamespace = Namespace.EmptyNamespace;
    Mc = localNamespace.getSymbol("Mc");
    Pc = localNamespace.getSymbol("Pc");
    Cc = localNamespace.getSymbol("Cc");
    Sc = localNamespace.getSymbol("Sc");
    Pd = localNamespace.getSymbol("Pd");
    Nd = localNamespace.getSymbol("Nd");
    Me = localNamespace.getSymbol("Me");
    Pe = localNamespace.getSymbol("Pe");
    Pf = localNamespace.getSymbol("Pf");
    Cf = localNamespace.getSymbol("Cf");
    Pi = localNamespace.getSymbol("Pi");
    Nl = localNamespace.getSymbol("Nl");
    Zl = localNamespace.getSymbol("Zl");
    Ll = localNamespace.getSymbol("Ll");
    Sm = localNamespace.getSymbol("Sm");
    Lm = localNamespace.getSymbol("Lm");
    Sk = localNamespace.getSymbol("Sk");
    Mn = localNamespace.getSymbol("Mn");
    Lo = localNamespace.getSymbol("Lo");
    No = localNamespace.getSymbol("No");
    Po = localNamespace.getSymbol("Po");
    So = localNamespace.getSymbol("So");
    Zp = localNamespace.getSymbol("Zp");
    Co = localNamespace.getSymbol("Co");
    Zs = localNamespace.getSymbol("Zs");
    Ps = localNamespace.getSymbol("Ps");
    Cs = localNamespace.getSymbol("Cs");
    Lt = localNamespace.getSymbol("Lt");
    Cn = localNamespace.getSymbol("Cn");
    Lu = localNamespace.getSymbol("Lu");
  }
  
  public static String capitalize(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    BreakIterator localBreakIterator = BreakIterator.getWordInstance();
    localBreakIterator.setText(paramString);
    int i = localBreakIterator.first();
    int j = localBreakIterator.next();
    if (j != -1)
    {
      int k = i;
      label37:
      int m = 0;
      if (k < j)
      {
        if (Character.isLetter(paramString.codePointAt(k))) {
          m = 1;
        }
      }
      else
      {
        if (m != 0) {
          break label94;
        }
        localStringBuilder.append(paramString, i, j);
      }
      for (;;)
      {
        i = j;
        j = localBreakIterator.next();
        break;
        k++;
        break label37;
        label94:
        localStringBuilder.append(Character.toTitleCase(paramString.charAt(i)));
        localStringBuilder.append(paramString.substring(i + 1, j).toLowerCase());
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String foldCase(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    String str;
    if (i == 0)
    {
      str = "";
      return str;
    }
    StringBuilder localStringBuilder = null;
    int j = 0;
    for (int k = 0;; k++)
    {
      int m;
      label34:
      int n;
      if (k == i)
      {
        m = -1;
        if ((m != 931) && (m != 963) && (m != 962)) {
          break label164;
        }
        n = 1;
      }
      for (;;)
      {
        if ((m < 0) || (m == 304) || (m == 305) || (n != 0))
        {
          if ((localStringBuilder == null) && (m >= 0)) {
            localStringBuilder = new StringBuilder();
          }
          if (k > j)
          {
            str = paramCharSequence.subSequence(j, k).toString().toUpperCase().toLowerCase();
            if (localStringBuilder == null) {
              break;
            }
            localStringBuilder.append(str);
          }
          if (m < 0)
          {
            return localStringBuilder.toString();
            m = paramCharSequence.charAt(k);
            break label34;
            label164:
            n = 0;
            continue;
          }
          if (n != 0) {
            m = 963;
          }
          localStringBuilder.append(m);
          j = k + 1;
        }
      }
    }
  }
  
  public static Symbol generalCategory(int paramInt)
  {
    switch (Character.getType(paramInt))
    {
    case 17: 
    default: 
      return Cn;
    case 8: 
      return Mc;
    case 23: 
      return Pc;
    case 15: 
      return Cc;
    case 26: 
      return Sc;
    case 20: 
      return Pd;
    case 9: 
      return Nd;
    case 7: 
      return Me;
    case 22: 
      return Pe;
    case 30: 
      return Pf;
    case 16: 
      return Cf;
    case 29: 
      return Pi;
    case 10: 
      return Nl;
    case 13: 
      return Zl;
    case 2: 
      return Ll;
    case 25: 
      return Sm;
    case 4: 
      return Lm;
    case 27: 
      return Sk;
    case 6: 
      return Mn;
    case 5: 
      return Lo;
    case 11: 
      return No;
    case 24: 
      return Po;
    case 28: 
      return So;
    case 14: 
      return Zp;
    case 18: 
      return Co;
    case 12: 
      return Zs;
    case 21: 
      return Ps;
    case 19: 
      return Cs;
    case 3: 
      return Lt;
    }
    return Lu;
  }
  
  public static boolean isWhitespace(int paramInt)
  {
    boolean bool;
    if ((paramInt == 32) || ((paramInt >= 9) && (paramInt <= 13))) {
      bool = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool;
            bool = false;
          } while (paramInt < 133);
          if ((paramInt == 133) || (paramInt == 160) || (paramInt == 5760) || (paramInt == 6158)) {
            return true;
          }
          bool = false;
        } while (paramInt < 8192);
        bool = false;
      } while (paramInt > 12288);
      if ((paramInt <= 8202) || (paramInt == 8232) || (paramInt == 8233) || (paramInt == 8239) || (paramInt == 8287)) {
        break;
      }
      bool = false;
    } while (paramInt != 12288);
    return true;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.UnicodeUtils
 * JD-Core Version:    0.7.0.1
 */