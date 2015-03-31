package kawa.lib.rnrs;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.UnicodeUtils;
import gnu.lists.FString;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.text.Char;
import java.util.Locale;
import kawa.lib.misc;

public class unicode
  extends ModuleBody
{
  public static final unicode $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final SimpleSymbol Lit28 = (SimpleSymbol)new SimpleSymbol("string-normalize-nfkc").readResolve();
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod char$Mnalphabetic$Qu;
  public static final ModuleMethod char$Mnci$Eq$Qu;
  public static final ModuleMethod char$Mnci$Gr$Eq$Qu;
  public static final ModuleMethod char$Mnci$Gr$Qu;
  public static final ModuleMethod char$Mnci$Ls$Eq$Qu;
  public static final ModuleMethod char$Mnci$Ls$Qu;
  public static final ModuleMethod char$Mndowncase;
  public static final ModuleMethod char$Mnfoldcase;
  public static final ModuleMethod char$Mngeneral$Mncategory;
  public static final ModuleMethod char$Mnlower$Mncase$Qu;
  public static final ModuleMethod char$Mnnumeric$Qu;
  public static final ModuleMethod char$Mntitle$Mncase$Qu;
  public static final ModuleMethod char$Mntitlecase;
  public static final ModuleMethod char$Mnupcase;
  public static final ModuleMethod char$Mnupper$Mncase$Qu;
  public static final ModuleMethod char$Mnwhitespace$Qu;
  public static final ModuleMethod string$Mnci$Eq$Qu;
  public static final ModuleMethod string$Mnci$Gr$Eq$Qu;
  public static final ModuleMethod string$Mnci$Gr$Qu;
  public static final ModuleMethod string$Mnci$Ls$Eq$Qu;
  public static final ModuleMethod string$Mnci$Ls$Qu;
  public static final ModuleMethod string$Mndowncase;
  public static final ModuleMethod string$Mnfoldcase;
  public static final ModuleMethod string$Mnnormalize$Mnnfc;
  public static final ModuleMethod string$Mnnormalize$Mnnfd;
  public static final ModuleMethod string$Mnnormalize$Mnnfkc;
  public static final ModuleMethod string$Mnnormalize$Mnnfkd;
  public static final ModuleMethod string$Mntitlecase;
  public static final ModuleMethod string$Mnupcase;
  
  static
  {
    Lit27 = (SimpleSymbol)new SimpleSymbol("string-normalize-nfc").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("string-normalize-nfkd").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("string-normalize-nfd").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("string-ci>=?").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("string-ci<=?").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("string-ci>?").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("string-ci<?").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("string-ci=?").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("string-foldcase").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("string-titlecase").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("string-downcase").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("string-upcase").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("char-general-category").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("char-ci>=?").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("char-ci<=?").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("char-ci>?").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("char-ci<?").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("char-ci=?").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("char-foldcase").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("char-title-case?").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("char-lower-case?").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("char-upper-case?").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("char-whitespace?").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("char-numeric?").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("char-alphabetic?").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("char-titlecase").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("char-downcase").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("char-upcase").readResolve();
    $instance = new unicode();
    unicode localunicode = $instance;
    char$Mnupcase = new ModuleMethod(localunicode, 1, Lit0, 4097);
    char$Mndowncase = new ModuleMethod(localunicode, 2, Lit1, 4097);
    char$Mntitlecase = new ModuleMethod(localunicode, 3, Lit2, 4097);
    char$Mnalphabetic$Qu = new ModuleMethod(localunicode, 4, Lit3, 4097);
    char$Mnnumeric$Qu = new ModuleMethod(localunicode, 5, Lit4, 4097);
    char$Mnwhitespace$Qu = new ModuleMethod(localunicode, 6, Lit5, 4097);
    char$Mnupper$Mncase$Qu = new ModuleMethod(localunicode, 7, Lit6, 4097);
    char$Mnlower$Mncase$Qu = new ModuleMethod(localunicode, 8, Lit7, 4097);
    char$Mntitle$Mncase$Qu = new ModuleMethod(localunicode, 9, Lit8, 4097);
    char$Mnfoldcase = new ModuleMethod(localunicode, 10, Lit9, 4097);
    char$Mnci$Eq$Qu = new ModuleMethod(localunicode, 11, Lit10, 8194);
    char$Mnci$Ls$Qu = new ModuleMethod(localunicode, 12, Lit11, 8194);
    char$Mnci$Gr$Qu = new ModuleMethod(localunicode, 13, Lit12, 8194);
    char$Mnci$Ls$Eq$Qu = new ModuleMethod(localunicode, 14, Lit13, 8194);
    char$Mnci$Gr$Eq$Qu = new ModuleMethod(localunicode, 15, Lit14, 8194);
    char$Mngeneral$Mncategory = new ModuleMethod(localunicode, 16, Lit15, 4097);
    string$Mnupcase = new ModuleMethod(localunicode, 17, Lit16, 4097);
    string$Mndowncase = new ModuleMethod(localunicode, 18, Lit17, 4097);
    string$Mntitlecase = new ModuleMethod(localunicode, 19, Lit18, 4097);
    string$Mnfoldcase = new ModuleMethod(localunicode, 20, Lit19, 4097);
    string$Mnci$Eq$Qu = new ModuleMethod(localunicode, 21, Lit20, 8194);
    string$Mnci$Ls$Qu = new ModuleMethod(localunicode, 22, Lit21, 8194);
    string$Mnci$Gr$Qu = new ModuleMethod(localunicode, 23, Lit22, 8194);
    string$Mnci$Ls$Eq$Qu = new ModuleMethod(localunicode, 24, Lit23, 8194);
    string$Mnci$Gr$Eq$Qu = new ModuleMethod(localunicode, 25, Lit24, 8194);
    string$Mnnormalize$Mnnfd = new ModuleMethod(localunicode, 26, Lit25, 4097);
    string$Mnnormalize$Mnnfkd = new ModuleMethod(localunicode, 27, Lit26, 4097);
    string$Mnnormalize$Mnnfc = new ModuleMethod(localunicode, 28, Lit27, 4097);
    string$Mnnormalize$Mnnfkc = new ModuleMethod(localunicode, 29, Lit28, 4097);
    $instance.run();
  }
  
  public unicode()
  {
    ModuleInfo.register(this);
  }
  
  public static Char charDowncase(Char paramChar)
  {
    return Char.make(Character.toLowerCase(paramChar.intValue()));
  }
  
  public static Char charFoldcase(Char paramChar)
  {
    int i = paramChar.intValue();
    int j;
    if (i == 304)
    {
      j = 1;
      if (j == 0) {
        break label29;
      }
      if (j == 0) {
        break label36;
      }
    }
    label29:
    while (i == 305)
    {
      return paramChar;
      j = 0;
      break;
    }
    label36:
    return Char.make(Character.toLowerCase(Character.toUpperCase(i)));
  }
  
  public static Symbol charGeneralCategory(Char paramChar)
  {
    return UnicodeUtils.generalCategory(paramChar.intValue());
  }
  
  public static Char charTitlecase(Char paramChar)
  {
    return Char.make(Character.toTitleCase(paramChar.intValue()));
  }
  
  public static Char charUpcase(Char paramChar)
  {
    return Char.make(Character.toUpperCase(paramChar.intValue()));
  }
  
  public static boolean isCharAlphabetic(Char paramChar)
  {
    return Character.isLetter(paramChar.intValue());
  }
  
  public static boolean isCharCi$Eq(Char paramChar1, Char paramChar2)
  {
    return Character.toUpperCase(paramChar1.intValue()) == Character.toUpperCase(paramChar2.intValue());
  }
  
  public static boolean isCharCi$Gr(Char paramChar1, Char paramChar2)
  {
    return Character.toUpperCase(paramChar1.intValue()) > Character.toUpperCase(paramChar2.intValue());
  }
  
  public static boolean isCharCi$Gr$Eq(Char paramChar1, Char paramChar2)
  {
    return Character.toUpperCase(paramChar1.intValue()) >= Character.toUpperCase(paramChar2.intValue());
  }
  
  public static boolean isCharCi$Ls(Char paramChar1, Char paramChar2)
  {
    return Character.toUpperCase(paramChar1.intValue()) < Character.toUpperCase(paramChar2.intValue());
  }
  
  public static boolean isCharCi$Ls$Eq(Char paramChar1, Char paramChar2)
  {
    return Character.toUpperCase(paramChar1.intValue()) <= Character.toUpperCase(paramChar2.intValue());
  }
  
  public static boolean isCharLowerCase(Char paramChar)
  {
    return Character.isLowerCase(paramChar.intValue());
  }
  
  public static boolean isCharNumeric(Char paramChar)
  {
    return Character.isDigit(paramChar.intValue());
  }
  
  public static boolean isCharTitleCase(Char paramChar)
  {
    return Character.isTitleCase(paramChar.intValue());
  }
  
  public static boolean isCharUpperCase(Char paramChar)
  {
    return Character.isUpperCase(paramChar.intValue());
  }
  
  public static boolean isCharWhitespace(Char paramChar)
  {
    return UnicodeUtils.isWhitespace(paramChar.intValue());
  }
  
  public static boolean isStringCi$Eq(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return UnicodeUtils.foldCase(paramCharSequence1).equals(UnicodeUtils.foldCase(paramCharSequence2));
  }
  
  public static boolean isStringCi$Gr(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return UnicodeUtils.foldCase(paramCharSequence1).compareTo(UnicodeUtils.foldCase(paramCharSequence2)) > 0;
  }
  
  public static boolean isStringCi$Gr$Eq(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return UnicodeUtils.foldCase(paramCharSequence1).compareTo(UnicodeUtils.foldCase(paramCharSequence2)) >= 0;
  }
  
  public static boolean isStringCi$Ls(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return UnicodeUtils.foldCase(paramCharSequence1).compareTo(UnicodeUtils.foldCase(paramCharSequence2)) < 0;
  }
  
  public static boolean isStringCi$Ls$Eq(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return UnicodeUtils.foldCase(paramCharSequence1).compareTo(UnicodeUtils.foldCase(paramCharSequence2)) <= 0;
  }
  
  public static CharSequence stringDowncase(CharSequence paramCharSequence)
  {
    return new FString(paramCharSequence.toString().toLowerCase(Locale.ENGLISH));
  }
  
  public static CharSequence stringFoldcase(CharSequence paramCharSequence)
  {
    return new FString(UnicodeUtils.foldCase(paramCharSequence));
  }
  
  public static CharSequence stringNormalizeNfc(CharSequence paramCharSequence)
  {
    return (CharSequence)misc.error$V("unicode string normalization not available", new Object[0]);
  }
  
  public static CharSequence stringNormalizeNfd(CharSequence paramCharSequence)
  {
    return (CharSequence)misc.error$V("unicode string normalization not available", new Object[0]);
  }
  
  public static CharSequence stringNormalizeNfkc(CharSequence paramCharSequence)
  {
    return (CharSequence)misc.error$V("unicode string normalization not available", new Object[0]);
  }
  
  public static CharSequence stringNormalizeNfkd(CharSequence paramCharSequence)
  {
    return (CharSequence)misc.error$V("unicode string normalization not available", new Object[0]);
  }
  
  public static CharSequence stringTitlecase(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    for (String str = null;; str = paramCharSequence.toString()) {
      return new FString(UnicodeUtils.capitalize(str));
    }
  }
  
  public static CharSequence stringUpcase(CharSequence paramCharSequence)
  {
    return new FString(paramCharSequence.toString().toUpperCase(Locale.ENGLISH));
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    }
    try
    {
      Char localChar11 = (Char)paramObject;
      return charUpcase(localChar11);
    }
    catch (ClassCastException localClassCastException19)
    {
      try
      {
        Char localChar10 = (Char)paramObject;
        return charDowncase(localChar10);
      }
      catch (ClassCastException localClassCastException18)
      {
        Char localChar9;
        Char localChar8;
        Char localChar7;
        Char localChar6;
        Char localChar5;
        Char localChar4;
        Char localChar3;
        Char localChar2;
        Char localChar1;
        CharSequence localCharSequence8;
        CharSequence localCharSequence7;
        CharSequence localCharSequence6;
        CharSequence localCharSequence5;
        CharSequence localCharSequence4;
        CharSequence localCharSequence3;
        CharSequence localCharSequence2;
        CharSequence localCharSequence1;
        throw new WrongType(localClassCastException18, "char-downcase", 1, paramObject);
      }
      try
      {
        localChar9 = (Char)paramObject;
        return charTitlecase(localChar9);
      }
      catch (ClassCastException localClassCastException17)
      {
        throw new WrongType(localClassCastException17, "char-titlecase", 1, paramObject);
      }
      try
      {
        localChar8 = (Char)paramObject;
        if (isCharAlphabetic(localChar8)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException16)
      {
        throw new WrongType(localClassCastException16, "char-alphabetic?", 1, paramObject);
      }
      try
      {
        localChar7 = (Char)paramObject;
        if (isCharNumeric(localChar7)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException15)
      {
        throw new WrongType(localClassCastException15, "char-numeric?", 1, paramObject);
      }
      try
      {
        localChar6 = (Char)paramObject;
        if (isCharWhitespace(localChar6)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException14)
      {
        throw new WrongType(localClassCastException14, "char-whitespace?", 1, paramObject);
      }
      try
      {
        localChar5 = (Char)paramObject;
        if (isCharUpperCase(localChar5)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException13)
      {
        throw new WrongType(localClassCastException13, "char-upper-case?", 1, paramObject);
      }
      try
      {
        localChar4 = (Char)paramObject;
        if (isCharLowerCase(localChar4)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException12)
      {
        throw new WrongType(localClassCastException12, "char-lower-case?", 1, paramObject);
      }
      try
      {
        localChar3 = (Char)paramObject;
        if (isCharTitleCase(localChar3)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException11)
      {
        throw new WrongType(localClassCastException11, "char-title-case?", 1, paramObject);
      }
      try
      {
        localChar2 = (Char)paramObject;
        return charFoldcase(localChar2);
      }
      catch (ClassCastException localClassCastException10)
      {
        throw new WrongType(localClassCastException10, "char-foldcase", 1, paramObject);
      }
      try
      {
        localChar1 = (Char)paramObject;
        return charGeneralCategory(localChar1);
      }
      catch (ClassCastException localClassCastException9)
      {
        throw new WrongType(localClassCastException9, "char-general-category", 1, paramObject);
      }
      try
      {
        localCharSequence8 = (CharSequence)paramObject;
        return stringUpcase(localCharSequence8);
      }
      catch (ClassCastException localClassCastException8)
      {
        throw new WrongType(localClassCastException8, "string-upcase", 1, paramObject);
      }
      try
      {
        localCharSequence7 = (CharSequence)paramObject;
        return stringDowncase(localCharSequence7);
      }
      catch (ClassCastException localClassCastException7)
      {
        throw new WrongType(localClassCastException7, "string-downcase", 1, paramObject);
      }
      try
      {
        localCharSequence6 = (CharSequence)paramObject;
        return stringTitlecase(localCharSequence6);
      }
      catch (ClassCastException localClassCastException6)
      {
        throw new WrongType(localClassCastException6, "string-titlecase", 1, paramObject);
      }
      try
      {
        localCharSequence5 = (CharSequence)paramObject;
        return stringFoldcase(localCharSequence5);
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "string-foldcase", 1, paramObject);
      }
      try
      {
        localCharSequence4 = (CharSequence)paramObject;
        return stringNormalizeNfd(localCharSequence4);
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "string-normalize-nfd", 1, paramObject);
      }
      try
      {
        localCharSequence3 = (CharSequence)paramObject;
        return stringNormalizeNfkd(localCharSequence3);
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "string-normalize-nfkd", 1, paramObject);
      }
      try
      {
        localCharSequence2 = (CharSequence)paramObject;
        return stringNormalizeNfc(localCharSequence2);
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-normalize-nfc", 1, paramObject);
      }
      try
      {
        localCharSequence1 = (CharSequence)paramObject;
        return stringNormalizeNfkc(localCharSequence1);
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "string-normalize-nfkc", 1, paramObject);
      }
      localClassCastException19 = localClassCastException19;
      throw new WrongType(localClassCastException19, "char-upcase", 1, paramObject);
    }
  }
  
  /* Error */
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 412	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+76 -> 80, 11:+84->88, 12:+114->118, 13:+144->148, 14:+174->178, 15:+204->208, 16:+76->80, 17:+76->80, 18:+76->80, 19:+76->80, 20:+76->80, 21:+234->238, 22:+264->268, 23:+294->298, 24:+324->328, 25:+354->358
    //   81: aload_1
    //   82: aload_2
    //   83: aload_3
    //   84: invokespecial 470	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: areturn
    //   88: aload_2
    //   89: checkcast 275	gnu/text/Char
    //   92: astore 41
    //   94: aload_3
    //   95: checkcast 275	gnu/text/Char
    //   98: astore 43
    //   100: aload 41
    //   102: aload 43
    //   104: invokestatic 472	kawa/lib/rnrs/unicode:isCharCi$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   107: ifeq +7 -> 114
    //   110: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   113: areturn
    //   114: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast 275	gnu/text/Char
    //   122: astore 37
    //   124: aload_3
    //   125: checkcast 275	gnu/text/Char
    //   128: astore 39
    //   130: aload 37
    //   132: aload 39
    //   134: invokestatic 474	kawa/lib/rnrs/unicode:isCharCi$Ls	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   137: ifeq +7 -> 144
    //   140: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   143: areturn
    //   144: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   147: areturn
    //   148: aload_2
    //   149: checkcast 275	gnu/text/Char
    //   152: astore 33
    //   154: aload_3
    //   155: checkcast 275	gnu/text/Char
    //   158: astore 35
    //   160: aload 33
    //   162: aload 35
    //   164: invokestatic 476	kawa/lib/rnrs/unicode:isCharCi$Gr	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   167: ifeq +7 -> 174
    //   170: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   173: areturn
    //   174: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   177: areturn
    //   178: aload_2
    //   179: checkcast 275	gnu/text/Char
    //   182: astore 29
    //   184: aload_3
    //   185: checkcast 275	gnu/text/Char
    //   188: astore 31
    //   190: aload 29
    //   192: aload 31
    //   194: invokestatic 478	kawa/lib/rnrs/unicode:isCharCi$Ls$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   197: ifeq +7 -> 204
    //   200: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   203: areturn
    //   204: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   207: areturn
    //   208: aload_2
    //   209: checkcast 275	gnu/text/Char
    //   212: astore 25
    //   214: aload_3
    //   215: checkcast 275	gnu/text/Char
    //   218: astore 27
    //   220: aload 25
    //   222: aload 27
    //   224: invokestatic 480	kawa/lib/rnrs/unicode:isCharCi$Gr$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   227: ifeq +7 -> 234
    //   230: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   233: areturn
    //   234: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   237: areturn
    //   238: aload_2
    //   239: checkcast 364	java/lang/CharSequence
    //   242: astore 21
    //   244: aload_3
    //   245: checkcast 364	java/lang/CharSequence
    //   248: astore 23
    //   250: aload 21
    //   252: aload 23
    //   254: invokestatic 482	kawa/lib/rnrs/unicode:isStringCi$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   257: ifeq +7 -> 264
    //   260: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   263: areturn
    //   264: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   267: areturn
    //   268: aload_2
    //   269: checkcast 364	java/lang/CharSequence
    //   272: astore 17
    //   274: aload_3
    //   275: checkcast 364	java/lang/CharSequence
    //   278: astore 19
    //   280: aload 17
    //   282: aload 19
    //   284: invokestatic 484	kawa/lib/rnrs/unicode:isStringCi$Ls	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   287: ifeq +7 -> 294
    //   290: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   293: areturn
    //   294: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   297: areturn
    //   298: aload_2
    //   299: checkcast 364	java/lang/CharSequence
    //   302: astore 13
    //   304: aload_3
    //   305: checkcast 364	java/lang/CharSequence
    //   308: astore 15
    //   310: aload 13
    //   312: aload 15
    //   314: invokestatic 486	kawa/lib/rnrs/unicode:isStringCi$Gr	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   317: ifeq +7 -> 324
    //   320: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   323: areturn
    //   324: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   327: areturn
    //   328: aload_2
    //   329: checkcast 364	java/lang/CharSequence
    //   332: astore 9
    //   334: aload_3
    //   335: checkcast 364	java/lang/CharSequence
    //   338: astore 11
    //   340: aload 9
    //   342: aload 11
    //   344: invokestatic 488	kawa/lib/rnrs/unicode:isStringCi$Ls$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   347: ifeq +7 -> 354
    //   350: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   353: areturn
    //   354: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   357: areturn
    //   358: aload_2
    //   359: checkcast 364	java/lang/CharSequence
    //   362: astore 5
    //   364: aload_3
    //   365: checkcast 364	java/lang/CharSequence
    //   368: astore 7
    //   370: aload 5
    //   372: aload 7
    //   374: invokestatic 490	kawa/lib/rnrs/unicode:isStringCi$Gr$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   377: ifeq +7 -> 384
    //   380: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   383: areturn
    //   384: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   387: areturn
    //   388: astore 40
    //   390: new 463	gnu/mapping/WrongType
    //   393: dup
    //   394: aload 40
    //   396: ldc 152
    //   398: iconst_1
    //   399: aload_2
    //   400: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   403: athrow
    //   404: astore 42
    //   406: new 463	gnu/mapping/WrongType
    //   409: dup
    //   410: aload 42
    //   412: ldc 152
    //   414: iconst_2
    //   415: aload_3
    //   416: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   419: athrow
    //   420: astore 36
    //   422: new 463	gnu/mapping/WrongType
    //   425: dup
    //   426: aload 36
    //   428: ldc 148
    //   430: iconst_1
    //   431: aload_2
    //   432: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   435: athrow
    //   436: astore 38
    //   438: new 463	gnu/mapping/WrongType
    //   441: dup
    //   442: aload 38
    //   444: ldc 148
    //   446: iconst_2
    //   447: aload_3
    //   448: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   451: athrow
    //   452: astore 32
    //   454: new 463	gnu/mapping/WrongType
    //   457: dup
    //   458: aload 32
    //   460: ldc 144
    //   462: iconst_1
    //   463: aload_2
    //   464: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   467: athrow
    //   468: astore 34
    //   470: new 463	gnu/mapping/WrongType
    //   473: dup
    //   474: aload 34
    //   476: ldc 144
    //   478: iconst_2
    //   479: aload_3
    //   480: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   483: athrow
    //   484: astore 28
    //   486: new 463	gnu/mapping/WrongType
    //   489: dup
    //   490: aload 28
    //   492: ldc 140
    //   494: iconst_1
    //   495: aload_2
    //   496: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   499: athrow
    //   500: astore 30
    //   502: new 463	gnu/mapping/WrongType
    //   505: dup
    //   506: aload 30
    //   508: ldc 140
    //   510: iconst_2
    //   511: aload_3
    //   512: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   515: athrow
    //   516: astore 24
    //   518: new 463	gnu/mapping/WrongType
    //   521: dup
    //   522: aload 24
    //   524: ldc 136
    //   526: iconst_1
    //   527: aload_2
    //   528: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   531: athrow
    //   532: astore 26
    //   534: new 463	gnu/mapping/WrongType
    //   537: dup
    //   538: aload 26
    //   540: ldc 136
    //   542: iconst_2
    //   543: aload_3
    //   544: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   547: athrow
    //   548: astore 20
    //   550: new 463	gnu/mapping/WrongType
    //   553: dup
    //   554: aload 20
    //   556: ldc 112
    //   558: iconst_1
    //   559: aload_2
    //   560: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   563: athrow
    //   564: astore 22
    //   566: new 463	gnu/mapping/WrongType
    //   569: dup
    //   570: aload 22
    //   572: ldc 112
    //   574: iconst_2
    //   575: aload_3
    //   576: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   579: athrow
    //   580: astore 16
    //   582: new 463	gnu/mapping/WrongType
    //   585: dup
    //   586: aload 16
    //   588: ldc 108
    //   590: iconst_1
    //   591: aload_2
    //   592: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   595: athrow
    //   596: astore 18
    //   598: new 463	gnu/mapping/WrongType
    //   601: dup
    //   602: aload 18
    //   604: ldc 108
    //   606: iconst_2
    //   607: aload_3
    //   608: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   611: athrow
    //   612: astore 12
    //   614: new 463	gnu/mapping/WrongType
    //   617: dup
    //   618: aload 12
    //   620: ldc 104
    //   622: iconst_1
    //   623: aload_2
    //   624: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   627: athrow
    //   628: astore 14
    //   630: new 463	gnu/mapping/WrongType
    //   633: dup
    //   634: aload 14
    //   636: ldc 104
    //   638: iconst_2
    //   639: aload_3
    //   640: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   643: athrow
    //   644: astore 8
    //   646: new 463	gnu/mapping/WrongType
    //   649: dup
    //   650: aload 8
    //   652: ldc 100
    //   654: iconst_1
    //   655: aload_2
    //   656: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   659: athrow
    //   660: astore 10
    //   662: new 463	gnu/mapping/WrongType
    //   665: dup
    //   666: aload 10
    //   668: ldc 100
    //   670: iconst_2
    //   671: aload_3
    //   672: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   675: athrow
    //   676: astore 4
    //   678: new 463	gnu/mapping/WrongType
    //   681: dup
    //   682: aload 4
    //   684: ldc 96
    //   686: iconst_1
    //   687: aload_2
    //   688: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   691: athrow
    //   692: astore 6
    //   694: new 463	gnu/mapping/WrongType
    //   697: dup
    //   698: aload 6
    //   700: ldc 96
    //   702: iconst_2
    //   703: aload_3
    //   704: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   707: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	708	0	this	unicode
    //   0	708	1	paramModuleMethod	ModuleMethod
    //   0	708	2	paramObject1	Object
    //   0	708	3	paramObject2	Object
    //   676	7	4	localClassCastException1	ClassCastException
    //   362	9	5	localCharSequence1	CharSequence
    //   692	7	6	localClassCastException2	ClassCastException
    //   368	5	7	localCharSequence2	CharSequence
    //   644	7	8	localClassCastException3	ClassCastException
    //   332	9	9	localCharSequence3	CharSequence
    //   660	7	10	localClassCastException4	ClassCastException
    //   338	5	11	localCharSequence4	CharSequence
    //   612	7	12	localClassCastException5	ClassCastException
    //   302	9	13	localCharSequence5	CharSequence
    //   628	7	14	localClassCastException6	ClassCastException
    //   308	5	15	localCharSequence6	CharSequence
    //   580	7	16	localClassCastException7	ClassCastException
    //   272	9	17	localCharSequence7	CharSequence
    //   596	7	18	localClassCastException8	ClassCastException
    //   278	5	19	localCharSequence8	CharSequence
    //   548	7	20	localClassCastException9	ClassCastException
    //   242	9	21	localCharSequence9	CharSequence
    //   564	7	22	localClassCastException10	ClassCastException
    //   248	5	23	localCharSequence10	CharSequence
    //   516	7	24	localClassCastException11	ClassCastException
    //   212	9	25	localChar1	Char
    //   532	7	26	localClassCastException12	ClassCastException
    //   218	5	27	localChar2	Char
    //   484	7	28	localClassCastException13	ClassCastException
    //   182	9	29	localChar3	Char
    //   500	7	30	localClassCastException14	ClassCastException
    //   188	5	31	localChar4	Char
    //   452	7	32	localClassCastException15	ClassCastException
    //   152	9	33	localChar5	Char
    //   468	7	34	localClassCastException16	ClassCastException
    //   158	5	35	localChar6	Char
    //   420	7	36	localClassCastException17	ClassCastException
    //   122	9	37	localChar7	Char
    //   436	7	38	localClassCastException18	ClassCastException
    //   128	5	39	localChar8	Char
    //   388	7	40	localClassCastException19	ClassCastException
    //   92	9	41	localChar9	Char
    //   404	7	42	localClassCastException20	ClassCastException
    //   98	5	43	localChar10	Char
    // Exception table:
    //   from	to	target	type
    //   88	94	388	java/lang/ClassCastException
    //   94	100	404	java/lang/ClassCastException
    //   118	124	420	java/lang/ClassCastException
    //   124	130	436	java/lang/ClassCastException
    //   148	154	452	java/lang/ClassCastException
    //   154	160	468	java/lang/ClassCastException
    //   178	184	484	java/lang/ClassCastException
    //   184	190	500	java/lang/ClassCastException
    //   208	214	516	java/lang/ClassCastException
    //   214	220	532	java/lang/ClassCastException
    //   238	244	548	java/lang/ClassCastException
    //   244	250	564	java/lang/ClassCastException
    //   268	274	580	java/lang/ClassCastException
    //   274	280	596	java/lang/ClassCastException
    //   298	304	612	java/lang/ClassCastException
    //   304	310	628	java/lang/ClassCastException
    //   328	334	644	java/lang/ClassCastException
    //   334	340	660	java/lang/ClassCastException
    //   358	364	676	java/lang/ClassCastException
    //   364	370	692	java/lang/ClassCastException
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 29: 
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 28: 
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 27: 
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 26: 
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 20: 
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 19: 
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 18: 
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 17: 
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 16: 
      if (!(paramObject instanceof Char)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 10: 
      if (!(paramObject instanceof Char)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 9: 
      if (!(paramObject instanceof Char)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 8: 
      if (!(paramObject instanceof Char)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 7: 
      if (!(paramObject instanceof Char)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 6: 
      if (!(paramObject instanceof Char)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 5: 
      if (!(paramObject instanceof Char)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 4: 
      if (!(paramObject instanceof Char)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 3: 
      if (!(paramObject instanceof Char)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2: 
      if (!(paramObject instanceof Char)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    if (!(paramObject instanceof Char)) {
      return -786431;
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }
  
  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    default: 
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 25: 
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof CharSequence))
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 24: 
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof CharSequence))
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 23: 
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof CharSequence))
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 22: 
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof CharSequence))
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 21: 
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof CharSequence))
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 15: 
      if (!(paramObject1 instanceof Char)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Char)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 14: 
      if (!(paramObject1 instanceof Char)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Char)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 13: 
      if (!(paramObject1 instanceof Char)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Char)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 12: 
      if (!(paramObject1 instanceof Char)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Char)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    if (!(paramObject1 instanceof Char)) {
      return -786431;
    }
    paramCallContext.value1 = paramObject1;
    if (!(paramObject2 instanceof Char)) {
      return -786430;
    }
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }
  
  public final void run(CallContext paramCallContext) {}
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.rnrs.unicode
 * JD-Core Version:    0.7.0.1
 */