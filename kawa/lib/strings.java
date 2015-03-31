package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.CharSeq;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Strings;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.text.Char;

public class strings
  extends ModuleBody
{
  public static final strings $instance;
  public static final ModuleMethod $make$string$;
  static final Char Lit0;
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
  static final SimpleSymbol Lit22 = (SimpleSymbol)new SimpleSymbol("string-append/shared").readResolve();
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod list$Mn$Grstring;
  public static final ModuleMethod make$Mnstring;
  public static final ModuleMethod string$Eq$Qu;
  public static final ModuleMethod string$Gr$Eq$Qu;
  public static final ModuleMethod string$Gr$Qu;
  public static final ModuleMethod string$Ls$Eq$Qu;
  public static final ModuleMethod string$Ls$Qu;
  public static final ModuleMethod string$Mn$Grlist;
  public static final ModuleMethod string$Mnappend;
  public static final ModuleMethod string$Mnappend$Slshared;
  public static final ModuleMethod string$Mncapitalize;
  public static final ModuleMethod string$Mncapitalize$Ex;
  public static final ModuleMethod string$Mncopy;
  public static final ModuleMethod string$Mndowncase$Ex;
  public static final ModuleMethod string$Mnfill$Ex;
  public static final ModuleMethod string$Mnlength;
  public static final ModuleMethod string$Mnref;
  public static final ModuleMethod string$Mnset$Ex;
  public static final ModuleMethod string$Mnupcase$Ex;
  public static final ModuleMethod string$Qu;
  public static final ModuleMethod substring;
  
  public static CharSequence $make$string$(Object... paramVarArgs)
  {
    int i = paramVarArgs.length;
    FString localFString = new FString(i);
    for (int j = 0; j < i; j++) {
      localFString.setCharAt(j, ((Char)paramVarArgs[j]).charValue());
    }
    return localFString;
  }
  
  static
  {
    Lit21 = (SimpleSymbol)new SimpleSymbol("string-append").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("string-capitalize").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("string-capitalize!").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("string-downcase!").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("string-upcase!").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("string-fill!").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("string-copy").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("list->string").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("string->list").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("substring").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("string>=?").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("string<=?").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("string>?").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("string<?").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("string=?").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("string-set!").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("string-ref").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("string-length").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("$make$string$").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("make-string").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("string?").readResolve();
    Lit0 = Char.make(32);
    $instance = new strings();
    strings localstrings = $instance;
    string$Qu = new ModuleMethod(localstrings, 1, Lit1, 4097);
    make$Mnstring = new ModuleMethod(localstrings, 2, Lit2, 8193);
    $make$string$ = new ModuleMethod(localstrings, 4, Lit3, -4096);
    string$Mnlength = new ModuleMethod(localstrings, 5, Lit4, 4097);
    string$Mnref = new ModuleMethod(localstrings, 6, Lit5, 8194);
    string$Mnset$Ex = new ModuleMethod(localstrings, 7, Lit6, 12291);
    string$Eq$Qu = new ModuleMethod(localstrings, 8, Lit7, 8194);
    string$Ls$Qu = new ModuleMethod(localstrings, 9, Lit8, 8194);
    string$Gr$Qu = new ModuleMethod(localstrings, 10, Lit9, 8194);
    string$Ls$Eq$Qu = new ModuleMethod(localstrings, 11, Lit10, 8194);
    string$Gr$Eq$Qu = new ModuleMethod(localstrings, 12, Lit11, 8194);
    substring = new ModuleMethod(localstrings, 13, Lit12, 12291);
    string$Mn$Grlist = new ModuleMethod(localstrings, 14, Lit13, 4097);
    list$Mn$Grstring = new ModuleMethod(localstrings, 15, Lit14, 4097);
    string$Mncopy = new ModuleMethod(localstrings, 16, Lit15, 4097);
    string$Mnfill$Ex = new ModuleMethod(localstrings, 17, Lit16, 8194);
    string$Mnupcase$Ex = new ModuleMethod(localstrings, 18, Lit17, 4097);
    string$Mndowncase$Ex = new ModuleMethod(localstrings, 19, Lit18, 4097);
    string$Mncapitalize$Ex = new ModuleMethod(localstrings, 20, Lit19, 4097);
    string$Mncapitalize = new ModuleMethod(localstrings, 21, Lit20, 4097);
    string$Mnappend = new ModuleMethod(localstrings, 22, Lit21, -4096);
    string$Mnappend$Slshared = new ModuleMethod(localstrings, 23, Lit22, -4096);
    $instance.run();
  }
  
  public strings()
  {
    ModuleInfo.register(this);
  }
  
  public static boolean isString(Object paramObject)
  {
    return paramObject instanceof CharSequence;
  }
  
  public static boolean isString$Eq(Object paramObject1, Object paramObject2)
  {
    return paramObject1.toString().equals(paramObject2.toString());
  }
  
  public static boolean isString$Gr(Object paramObject1, Object paramObject2)
  {
    return paramObject1.toString().compareTo(paramObject2.toString()) > 0;
  }
  
  public static boolean isString$Gr$Eq(Object paramObject1, Object paramObject2)
  {
    return paramObject1.toString().compareTo(paramObject2.toString()) >= 0;
  }
  
  public static boolean isString$Ls(Object paramObject1, Object paramObject2)
  {
    return paramObject1.toString().compareTo(paramObject2.toString()) < 0;
  }
  
  public static boolean isString$Ls$Eq(Object paramObject1, Object paramObject2)
  {
    return paramObject1.toString().compareTo(paramObject2.toString()) <= 0;
  }
  
  /* Error */
  public static CharSequence list$To$String(LList paramLList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 272	kawa/lib/lists:length	(Lgnu/lists/LList;)I
    //   4: istore_1
    //   5: new 57	gnu/lists/FString
    //   8: dup
    //   9: iload_1
    //   10: invokespecial 61	gnu/lists/FString:<init>	(I)V
    //   13: astore_2
    //   14: iconst_0
    //   15: istore_3
    //   16: iload_3
    //   17: iload_1
    //   18: if_icmpge +129 -> 147
    //   21: aload_0
    //   22: checkcast 274	gnu/lists/Pair
    //   25: astore 5
    //   27: aload_2
    //   28: checkcast 276	gnu/lists/CharSeq
    //   31: astore 7
    //   33: aload 5
    //   35: invokevirtual 279	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   38: astore 8
    //   40: aload 8
    //   42: checkcast 63	gnu/text/Char
    //   45: invokevirtual 67	gnu/text/Char:charValue	()C
    //   48: istore 10
    //   50: aload 7
    //   52: iload_3
    //   53: iload 10
    //   55: invokestatic 283	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   58: aload 5
    //   60: invokevirtual 286	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   63: astore 11
    //   65: aload 11
    //   67: checkcast 288	gnu/lists/LList
    //   70: astore_0
    //   71: iinc 3 1
    //   74: goto -58 -> 16
    //   77: astore 4
    //   79: new 290	gnu/mapping/WrongType
    //   82: dup
    //   83: aload 4
    //   85: ldc_w 292
    //   88: bipush 254
    //   90: aload_0
    //   91: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   94: athrow
    //   95: astore 6
    //   97: new 290	gnu/mapping/WrongType
    //   100: dup
    //   101: aload 6
    //   103: ldc 147
    //   105: iconst_0
    //   106: aload_2
    //   107: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   110: athrow
    //   111: astore 9
    //   113: new 290	gnu/mapping/WrongType
    //   116: dup
    //   117: aload 9
    //   119: ldc 147
    //   121: iconst_2
    //   122: aload 8
    //   124: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   127: athrow
    //   128: astore 12
    //   130: new 290	gnu/mapping/WrongType
    //   133: dup
    //   134: aload 12
    //   136: ldc_w 297
    //   139: bipush 254
    //   141: aload 11
    //   143: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   146: athrow
    //   147: aload_2
    //   148: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramLList	LList
    //   4	15	1	i	int
    //   13	135	2	localFString	FString
    //   15	57	3	j	int
    //   77	7	4	localClassCastException1	ClassCastException
    //   25	34	5	localPair	Pair
    //   95	7	6	localClassCastException2	ClassCastException
    //   31	20	7	localCharSeq	CharSeq
    //   38	85	8	localObject1	Object
    //   111	7	9	localClassCastException3	ClassCastException
    //   48	6	10	c	char
    //   63	79	11	localObject2	Object
    //   128	7	12	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   21	27	77	java/lang/ClassCastException
    //   27	33	95	java/lang/ClassCastException
    //   40	50	111	java/lang/ClassCastException
    //   65	71	128	java/lang/ClassCastException
  }
  
  public static CharSequence makeString(int paramInt)
  {
    return makeString(paramInt, Lit0);
  }
  
  public static CharSequence makeString(int paramInt, Object paramObject)
  {
    try
    {
      char c = ((Char)paramObject).charValue();
      return new FString(paramInt, c);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "gnu.lists.FString.<init>(int,char)", 2, paramObject);
    }
  }
  
  public static LList string$To$List(CharSequence paramCharSequence)
  {
    LList localLList = LList.Empty;
    int i = stringLength(paramCharSequence);
    for (Object localObject = localLList;; localObject = new Pair(Char.make(stringRef(paramCharSequence, i)), localObject))
    {
      i--;
      if (i < 0) {
        return localObject;
      }
    }
  }
  
  public static FString stringAppend(Object... paramVarArgs)
  {
    FString localFString = new FString();
    localFString.addAllStrings(paramVarArgs, 0);
    return localFString;
  }
  
  public static CharSequence stringAppend$SlShared(Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return new FString();
    }
    localObject = paramVarArgs[0];
    if ((localObject instanceof FString)) {}
    try
    {
      FString localFString2 = (FString)localObject;
      localFString1 = localFString2;
    }
    catch (ClassCastException localClassCastException2)
    {
      try
      {
        CharSequence localCharSequence = (CharSequence)localObject;
        FString localFString1 = stringCopy(localCharSequence);
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "string-copy", 0, localObject);
      }
      localClassCastException2 = localClassCastException2;
      throw new WrongType(localClassCastException2, "fstr", -2, localObject);
    }
    localFString1.addAllStrings(paramVarArgs, 1);
    return localFString1;
  }
  
  public static CharSequence stringCapitalize(CharSequence paramCharSequence)
  {
    FString localFString = stringCopy(paramCharSequence);
    Strings.makeCapitalize(localFString);
    return localFString;
  }
  
  public static CharSequence stringCapitalize$Ex(CharSeq paramCharSeq)
  {
    Strings.makeCapitalize(paramCharSeq);
    return paramCharSeq;
  }
  
  public static FString stringCopy(CharSequence paramCharSequence)
  {
    return new FString(paramCharSequence);
  }
  
  public static CharSequence stringDowncase$Ex(CharSeq paramCharSeq)
  {
    Strings.makeLowerCase(paramCharSeq);
    return paramCharSeq;
  }
  
  public static void stringFill$Ex(CharSeq paramCharSeq, char paramChar)
  {
    paramCharSeq.fill(paramChar);
  }
  
  public static int stringLength(CharSequence paramCharSequence)
  {
    return paramCharSequence.length();
  }
  
  public static char stringRef(CharSequence paramCharSequence, int paramInt)
  {
    return paramCharSequence.charAt(paramInt);
  }
  
  public static void stringSet$Ex(CharSeq paramCharSeq, int paramInt, char paramChar)
  {
    paramCharSeq.setCharAt(paramInt, paramChar);
  }
  
  public static CharSequence stringUpcase$Ex(CharSeq paramCharSeq)
  {
    Strings.makeUpperCase(paramCharSeq);
    return paramCharSeq;
  }
  
  public static CharSequence substring(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return new FString(paramCharSequence, paramInt1, paramInt2 - paramInt1);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 17: 
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 1: 
      if (isString(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    try
    {
      int i = ((Number)paramObject).intValue();
      return makeString(i);
    }
    catch (ClassCastException localClassCastException9)
    {
      try
      {
        CharSequence localCharSequence4 = (CharSequence)paramObject;
        return Integer.valueOf(stringLength(localCharSequence4));
      }
      catch (ClassCastException localClassCastException8)
      {
        CharSequence localCharSequence3;
        LList localLList;
        CharSequence localCharSequence2;
        CharSeq localCharSeq3;
        CharSeq localCharSeq2;
        CharSeq localCharSeq1;
        CharSequence localCharSequence1;
        throw new WrongType(localClassCastException8, "string-length", 1, paramObject);
      }
      try
      {
        localCharSequence3 = (CharSequence)paramObject;
        return string$To$List(localCharSequence3);
      }
      catch (ClassCastException localClassCastException7)
      {
        throw new WrongType(localClassCastException7, "string->list", 1, paramObject);
      }
      try
      {
        localLList = (LList)paramObject;
        return list$To$String(localLList);
      }
      catch (ClassCastException localClassCastException6)
      {
        throw new WrongType(localClassCastException6, "list->string", 1, paramObject);
      }
      try
      {
        localCharSequence2 = (CharSequence)paramObject;
        return stringCopy(localCharSequence2);
      }
      catch (ClassCastException localClassCastException5)
      {
        throw new WrongType(localClassCastException5, "string-copy", 1, paramObject);
      }
      try
      {
        localCharSeq3 = (CharSeq)paramObject;
        return stringUpcase$Ex(localCharSeq3);
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "string-upcase!", 1, paramObject);
      }
      try
      {
        localCharSeq2 = (CharSeq)paramObject;
        return stringDowncase$Ex(localCharSeq2);
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "string-downcase!", 1, paramObject);
      }
      try
      {
        localCharSeq1 = (CharSeq)paramObject;
        return stringCapitalize$Ex(localCharSeq1);
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-capitalize!", 1, paramObject);
      }
      try
      {
        localCharSequence1 = (CharSequence)paramObject;
        return stringCapitalize(localCharSequence1);
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "string-capitalize", 1, paramObject);
      }
      localClassCastException9 = localClassCastException9;
      throw new WrongType(localClassCastException9, "make-string", 1, paramObject);
    }
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    case 3: 
    case 4: 
    case 5: 
    case 7: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    default: 
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    try
    {
      int j = ((Number)paramObject1).intValue();
      return makeString(j, paramObject2);
    }
    catch (ClassCastException localClassCastException5)
    {
      try
      {
        CharSequence localCharSequence;
        int i;
        localCharSeq = (CharSeq)paramObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        CharSeq localCharSeq;
        char c;
        throw new WrongType(localClassCastException1, "string-fill!", 1, paramObject1);
      }
      try
      {
        c = ((Char)paramObject2).charValue();
        stringFill$Ex(localCharSeq, c);
        return Values.empty;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-fill!", 2, paramObject2);
      }
      localClassCastException5 = localClassCastException5;
      throw new WrongType(localClassCastException5, "make-string", 1, paramObject1);
    }
    try
    {
      localCharSequence = (CharSequence)paramObject1;
    }
    catch (ClassCastException localClassCastException3)
    {
      throw new WrongType(localClassCastException3, "string-ref", 1, paramObject1);
    }
    try
    {
      i = ((Number)paramObject2).intValue();
      return Char.make(stringRef(localCharSequence, i));
    }
    catch (ClassCastException localClassCastException4)
    {
      throw new WrongType(localClassCastException4, "string-ref", 2, paramObject2);
    }
    if (isString$Eq(paramObject1, paramObject2)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    if (isString$Ls(paramObject1, paramObject2)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    if (isString$Gr(paramObject1, paramObject2)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    if (isString$Ls$Eq(paramObject1, paramObject2)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    if (isString$Gr$Eq(paramObject1, paramObject2)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 382	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+28->32, 7:+38->42, 13:+76->80
    //   33: aload_1
    //   34: aload_2
    //   35: aload_3
    //   36: aload 4
    //   38: invokespecial 446	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: areturn
    //   42: aload_2
    //   43: checkcast 276	gnu/lists/CharSeq
    //   46: astore 12
    //   48: aload_3
    //   49: checkcast 397	java/lang/Number
    //   52: invokevirtual 400	java/lang/Number:intValue	()I
    //   55: istore 14
    //   57: aload 4
    //   59: checkcast 63	gnu/text/Char
    //   62: invokevirtual 67	gnu/text/Char:charValue	()C
    //   65: istore 16
    //   67: aload 12
    //   69: iload 14
    //   71: iload 16
    //   73: invokestatic 283	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   76: getstatic 442	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   79: areturn
    //   80: aload_2
    //   81: checkcast 241	java/lang/CharSequence
    //   84: astore 6
    //   86: aload_3
    //   87: checkcast 397	java/lang/Number
    //   90: invokevirtual 400	java/lang/Number:intValue	()I
    //   93: istore 8
    //   95: aload 4
    //   97: checkcast 397	java/lang/Number
    //   100: invokevirtual 400	java/lang/Number:intValue	()I
    //   103: istore 10
    //   105: aload 6
    //   107: iload 8
    //   109: iload 10
    //   111: invokestatic 448	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   114: areturn
    //   115: astore 11
    //   117: new 290	gnu/mapping/WrongType
    //   120: dup
    //   121: aload 11
    //   123: ldc 147
    //   125: iconst_1
    //   126: aload_2
    //   127: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   130: athrow
    //   131: astore 13
    //   133: new 290	gnu/mapping/WrongType
    //   136: dup
    //   137: aload 13
    //   139: ldc 147
    //   141: iconst_2
    //   142: aload_3
    //   143: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   146: athrow
    //   147: astore 15
    //   149: new 290	gnu/mapping/WrongType
    //   152: dup
    //   153: aload 15
    //   155: ldc 147
    //   157: iconst_3
    //   158: aload 4
    //   160: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   163: athrow
    //   164: astore 5
    //   166: new 290	gnu/mapping/WrongType
    //   169: dup
    //   170: aload 5
    //   172: ldc 123
    //   174: iconst_1
    //   175: aload_2
    //   176: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   179: athrow
    //   180: astore 7
    //   182: new 290	gnu/mapping/WrongType
    //   185: dup
    //   186: aload 7
    //   188: ldc 123
    //   190: iconst_2
    //   191: aload_3
    //   192: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   195: athrow
    //   196: astore 9
    //   198: new 290	gnu/mapping/WrongType
    //   201: dup
    //   202: aload 9
    //   204: ldc 123
    //   206: iconst_3
    //   207: aload 4
    //   209: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	strings
    //   0	213	1	paramModuleMethod	ModuleMethod
    //   0	213	2	paramObject1	Object
    //   0	213	3	paramObject2	Object
    //   0	213	4	paramObject3	Object
    //   164	7	5	localClassCastException1	ClassCastException
    //   84	22	6	localCharSequence	CharSequence
    //   180	7	7	localClassCastException2	ClassCastException
    //   93	15	8	i	int
    //   196	7	9	localClassCastException3	ClassCastException
    //   103	7	10	j	int
    //   115	7	11	localClassCastException4	ClassCastException
    //   46	22	12	localCharSeq	CharSeq
    //   131	7	13	localClassCastException5	ClassCastException
    //   55	15	14	k	int
    //   147	7	15	localClassCastException6	ClassCastException
    //   65	7	16	c	char
    // Exception table:
    //   from	to	target	type
    //   42	48	115	java/lang/ClassCastException
    //   48	57	131	java/lang/ClassCastException
    //   57	67	147	java/lang/ClassCastException
    //   80	86	164	java/lang/ClassCastException
    //   86	95	180	java/lang/ClassCastException
    //   95	105	196	java/lang/ClassCastException
  }
  
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 4: 
      return $make$string$(paramArrayOfObject);
    case 22: 
      return stringAppend(paramArrayOfObject);
    }
    return stringAppend$SlShared(paramArrayOfObject);
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 17: 
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 21: 
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 20: 
      if (!(paramObject instanceof CharSeq)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 19: 
      if (!(paramObject instanceof CharSeq)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 18: 
      if (!(paramObject instanceof CharSeq)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 16: 
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 15: 
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 14: 
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 5: 
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 2: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }
  
  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    int i = -786431;
    switch (paramModuleMethod.selector)
    {
    case 3: 
    case 4: 
    case 5: 
    case 7: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    default: 
      i = super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 17: 
    case 12: 
    case 11: 
    case 10: 
    case 9: 
    case 8: 
    case 6: 
      do
      {
        do
        {
          return i;
        } while (!(paramObject1 instanceof CharSeq));
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof Char))
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
        return -786430;
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      } while (!(paramObject1 instanceof CharSequence));
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }
  
  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 13: 
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786431;
    }
    if (!(paramObject1 instanceof CharSeq)) {
      return -786431;
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    if ((paramObject3 instanceof Char))
    {
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    }
    return -786429;
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 23: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 22: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    }
    paramCallContext.values = paramArrayOfObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 5;
    return 0;
  }
  
  public final void run(CallContext paramCallContext) {}
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.strings
 * JD-Core Version:    0.7.0.1
 */