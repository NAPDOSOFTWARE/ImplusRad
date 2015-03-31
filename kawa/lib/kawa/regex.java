package kawa.lib.kawa;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kawa.lib.lists;
import kawa.standard.Scheme;

public class regex
  extends ModuleBody
{
  public static final regex $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7 = (SimpleSymbol)new SimpleSymbol("regex-replace*").readResolve();
  public static final ModuleMethod regex$Mnmatch;
  public static final ModuleMethod regex$Mnmatch$Mnpositions;
  public static final ModuleMethod regex$Mnmatch$Qu;
  public static final ModuleMethod regex$Mnquote;
  public static final ModuleMethod regex$Mnreplace;
  public static final ModuleMethod regex$Mnreplace$St;
  public static final ModuleMethod regex$Mnsplit;
  
  static
  {
    Lit6 = (SimpleSymbol)new SimpleSymbol("regex-replace").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("regex-split").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("regex-match-positions").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("regex-match").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("regex-match?").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("regex-quote").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("loop").readResolve();
    $instance = new regex();
    regex localregex = $instance;
    regex$Mnquote = new ModuleMethod(localregex, 2, Lit1, 4097);
    regex$Mnmatch$Qu = new ModuleMethod(localregex, 3, Lit2, 16386);
    regex$Mnmatch = new ModuleMethod(localregex, 6, Lit3, 16386);
    regex$Mnmatch$Mnpositions = new ModuleMethod(localregex, 9, Lit4, 16386);
    regex$Mnsplit = new ModuleMethod(localregex, 12, Lit5, 8194);
    regex$Mnreplace = new ModuleMethod(localregex, 13, Lit6, 12291);
    regex$Mnreplace$St = new ModuleMethod(localregex, 14, Lit7, 12291);
    $instance.run();
  }
  
  public regex()
  {
    ModuleInfo.register(this);
  }
  
  public static boolean isRegexMatch(Object paramObject, CharSequence paramCharSequence)
  {
    return isRegexMatch(paramObject, paramCharSequence, 0);
  }
  
  public static boolean isRegexMatch(Object paramObject, CharSequence paramCharSequence, int paramInt)
  {
    return isRegexMatch(paramObject, paramCharSequence, paramInt, paramCharSequence.length());
  }
  
  public static boolean isRegexMatch(Object paramObject, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramObject instanceof Pattern)) {}
    for (;;)
    {
      try
      {
        Pattern localPattern2 = (Pattern)paramObject;
        localPattern1 = localPattern2;
        Matcher localMatcher = localPattern1.matcher(paramCharSequence);
        localMatcher.region(paramInt1, paramInt2);
        return localMatcher.find();
      }
      catch (ClassCastException localClassCastException)
      {
        Pattern localPattern1;
        throw new WrongType(localClassCastException, "rex", -2, paramObject);
      }
      localPattern1 = Pattern.compile(paramObject.toString());
    }
  }
  
  public static Object regexMatch(Object paramObject, CharSequence paramCharSequence)
  {
    return regexMatch(paramObject, paramCharSequence, 0);
  }
  
  public static Object regexMatch(Object paramObject, CharSequence paramCharSequence, int paramInt)
  {
    return regexMatch(paramObject, paramCharSequence, paramInt, paramCharSequence.length());
  }
  
  public static Object regexMatch(Object paramObject, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramObject instanceof Pattern)) {}
    try
    {
      Pattern localPattern2 = (Pattern)paramObject;
      Matcher localMatcher;
      int i;
      Object localObject1;
      for (Pattern localPattern1 = localPattern2;; localPattern1 = Pattern.compile(paramObject.toString()))
      {
        localMatcher = localPattern1.matcher(paramCharSequence);
        localMatcher.region(paramInt1, paramInt2);
        if (!localMatcher.find()) {
          break label131;
        }
        i = localMatcher.groupCount();
        localObject1 = LList.Empty;
        if (i >= 0) {
          break;
        }
        return localObject1;
      }
      int j = localMatcher.start(i);
      if (j < 0) {}
      for (Object localObject2 = Boolean.FALSE;; localObject2 = paramCharSequence.subSequence(j, localMatcher.end(i)))
      {
        Pair localPair = lists.cons(localObject2, localObject1);
        i--;
        localObject1 = localPair;
        break;
      }
      label131:
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "rex", -2, paramObject);
    }
  }
  
  public static Object regexMatchPositions(Object paramObject, CharSequence paramCharSequence)
  {
    return regexMatchPositions(paramObject, paramCharSequence, 0);
  }
  
  public static Object regexMatchPositions(Object paramObject, CharSequence paramCharSequence, int paramInt)
  {
    return regexMatchPositions(paramObject, paramCharSequence, paramInt, paramCharSequence.length());
  }
  
  public static Object regexMatchPositions(Object paramObject, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramObject instanceof Pattern)) {}
    try
    {
      Pattern localPattern2 = (Pattern)paramObject;
      Matcher localMatcher;
      int i;
      Object localObject1;
      for (Pattern localPattern1 = localPattern2;; localPattern1 = Pattern.compile(paramObject.toString()))
      {
        localMatcher = localPattern1.matcher(paramCharSequence);
        localMatcher.region(paramInt1, paramInt2);
        if (!localMatcher.find()) {
          break label134;
        }
        i = localMatcher.groupCount();
        localObject1 = LList.Empty;
        if (i >= 0) {
          break;
        }
        return localObject1;
      }
      int j = localMatcher.start(i);
      if (j < 0) {}
      for (Object localObject2 = Boolean.FALSE;; localObject2 = lists.cons(Integer.valueOf(j), Integer.valueOf(localMatcher.end(i))))
      {
        Pair localPair = lists.cons(localObject2, localObject1);
        i--;
        localObject1 = localPair;
        break;
      }
      label134:
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "rex", -2, paramObject);
    }
  }
  
  public static String regexQuote(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    for (String str = null;; str = paramCharSequence.toString()) {
      return Pattern.quote(str);
    }
  }
  
  /* Error */
  public static CharSequence regexReplace(Object paramObject1, CharSequence paramCharSequence, Object paramObject2)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 118
    //   4: ifeq +98 -> 102
    //   7: aload_0
    //   8: checkcast 118	java/util/regex/Pattern
    //   11: astore 12
    //   13: aload 12
    //   15: astore_3
    //   16: aload_3
    //   17: aload_1
    //   18: invokevirtual 122	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   21: astore 4
    //   23: aload 4
    //   25: invokevirtual 132	java/util/regex/Matcher:find	()Z
    //   28: ifeq +72 -> 100
    //   31: new 210	java/lang/StringBuffer
    //   34: dup
    //   35: invokespecial 211	java/lang/StringBuffer:<init>	()V
    //   38: astore 5
    //   40: aload_2
    //   41: invokestatic 217	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   44: ifeq +79 -> 123
    //   47: getstatic 223	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   50: aload_2
    //   51: aload 4
    //   53: invokevirtual 226	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   56: invokevirtual 232	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: astore 9
    //   61: aconst_null
    //   62: astore 10
    //   64: aload 9
    //   66: ifnonnull +47 -> 113
    //   69: aload 10
    //   71: invokestatic 235	java/util/regex/Matcher:quoteReplacement	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 6
    //   76: aload 4
    //   78: aload 5
    //   80: aload 6
    //   82: invokevirtual 239	java/util/regex/Matcher:appendReplacement	(Ljava/lang/StringBuffer;Ljava/lang/String;)Ljava/util/regex/Matcher;
    //   85: pop
    //   86: aload 4
    //   88: aload 5
    //   90: invokevirtual 243	java/util/regex/Matcher:appendTail	(Ljava/lang/StringBuffer;)Ljava/lang/StringBuffer;
    //   93: pop
    //   94: aload 5
    //   96: invokevirtual 244	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   99: astore_1
    //   100: aload_1
    //   101: areturn
    //   102: aload_0
    //   103: invokevirtual 138	java/lang/Object:toString	()Ljava/lang/String;
    //   106: invokestatic 142	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   109: astore_3
    //   110: goto -94 -> 16
    //   113: aload 9
    //   115: invokevirtual 138	java/lang/Object:toString	()Ljava/lang/String;
    //   118: astore 10
    //   120: goto -51 -> 69
    //   123: aconst_null
    //   124: astore 6
    //   126: aload_2
    //   127: ifnull -51 -> 76
    //   130: aload_2
    //   131: invokevirtual 138	java/lang/Object:toString	()Ljava/lang/String;
    //   134: astore 6
    //   136: goto -60 -> 76
    //   139: astore 11
    //   141: new 144	gnu/mapping/WrongType
    //   144: dup
    //   145: aload 11
    //   147: ldc 146
    //   149: bipush 254
    //   151: aload_0
    //   152: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramObject1	Object
    //   0	156	1	paramCharSequence	CharSequence
    //   0	156	2	paramObject2	Object
    //   15	95	3	localPattern1	Pattern
    //   21	66	4	localMatcher	Matcher
    //   38	57	5	localStringBuffer	StringBuffer
    //   74	61	6	str1	String
    //   59	55	9	localObject	Object
    //   62	57	10	str2	String
    //   139	7	11	localClassCastException	ClassCastException
    //   11	3	12	localPattern2	Pattern
    // Exception table:
    //   from	to	target	type
    //   7	13	139	java/lang/ClassCastException
  }
  
  /* Error */
  public static CharSequence regexReplace$St(Object paramObject1, CharSequence paramCharSequence, Object paramObject2)
  {
    // Byte code:
    //   0: new 247	kawa/lib/kawa/regex$frame
    //   3: dup
    //   4: invokespecial 248	kawa/lib/kawa/regex$frame:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_2
    //   10: putfield 252	kawa/lib/kawa/regex$frame:repl	Ljava/lang/Object;
    //   13: aload_0
    //   14: instanceof 118
    //   17: ifeq +57 -> 74
    //   20: aload_0
    //   21: checkcast 118	java/util/regex/Pattern
    //   24: astore 9
    //   26: aload 9
    //   28: astore 4
    //   30: aload_3
    //   31: aload 4
    //   33: aload_1
    //   34: invokevirtual 122	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   37: putfield 255	kawa/lib/kawa/regex$frame:matcher	Ljava/util/regex/Matcher;
    //   40: aload_3
    //   41: new 210	java/lang/StringBuffer
    //   44: dup
    //   45: invokespecial 211	java/lang/StringBuffer:<init>	()V
    //   48: putfield 259	kawa/lib/kawa/regex$frame:sbuf	Ljava/lang/StringBuffer;
    //   51: aload_3
    //   52: getfield 252	kawa/lib/kawa/regex$frame:repl	Ljava/lang/Object;
    //   55: invokestatic 217	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   58: ifeq +28 -> 86
    //   61: aload_3
    //   62: aload_3
    //   63: getfield 261	kawa/lib/kawa/regex$frame:loop	Ljava/lang/Object;
    //   66: putfield 261	kawa/lib/kawa/regex$frame:loop	Ljava/lang/Object;
    //   69: aload_3
    //   70: invokevirtual 264	kawa/lib/kawa/regex$frame:lambda1loop	()Ljava/lang/String;
    //   73: areturn
    //   74: aload_0
    //   75: invokevirtual 138	java/lang/Object:toString	()Ljava/lang/String;
    //   78: invokestatic 142	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   81: astore 4
    //   83: goto -53 -> 30
    //   86: aload_3
    //   87: getfield 255	kawa/lib/kawa/regex$frame:matcher	Ljava/util/regex/Matcher;
    //   90: astore 5
    //   92: aload_3
    //   93: getfield 252	kawa/lib/kawa/regex$frame:repl	Ljava/lang/Object;
    //   96: astore 6
    //   98: aload 6
    //   100: ifnonnull +14 -> 114
    //   103: aconst_null
    //   104: astore 7
    //   106: aload 5
    //   108: aload 7
    //   110: invokevirtual 267	java/util/regex/Matcher:replaceAll	(Ljava/lang/String;)Ljava/lang/String;
    //   113: areturn
    //   114: aload 6
    //   116: invokevirtual 138	java/lang/Object:toString	()Ljava/lang/String;
    //   119: astore 7
    //   121: goto -15 -> 106
    //   124: astore 8
    //   126: new 144	gnu/mapping/WrongType
    //   129: dup
    //   130: aload 8
    //   132: ldc 146
    //   134: bipush 254
    //   136: aload_0
    //   137: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramObject1	Object
    //   0	141	1	paramCharSequence	CharSequence
    //   0	141	2	paramObject2	Object
    //   7	86	3	localframe	frame
    //   28	54	4	localPattern1	Pattern
    //   90	17	5	localMatcher	Matcher
    //   96	19	6	localObject	Object
    //   104	16	7	str	String
    //   124	7	8	localClassCastException	ClassCastException
    //   24	3	9	localPattern2	Pattern
    // Exception table:
    //   from	to	target	type
    //   20	26	124	java/lang/ClassCastException
  }
  
  public static LList regexSplit(Object paramObject, CharSequence paramCharSequence)
  {
    if ((paramObject instanceof Pattern)) {}
    for (;;)
    {
      try
      {
        Pattern localPattern2 = (Pattern)paramObject;
        localPattern1 = localPattern2;
        return LList.makeList(localPattern1.split(paramCharSequence, -1), 0);
      }
      catch (ClassCastException localClassCastException)
      {
        Pattern localPattern1;
        throw new WrongType(localClassCastException, "rex", -2, paramObject);
      }
      localPattern1 = Pattern.compile(paramObject.toString());
    }
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    if (paramModuleMethod.selector == 2) {}
    try
    {
      CharSequence localCharSequence = (CharSequence)paramObject;
      return regexQuote(localCharSequence);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "regex-quote", 1, paramObject);
    }
    return super.apply1(paramModuleMethod, paramObject);
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    try
    {
      CharSequence localCharSequence4 = (CharSequence)paramObject2;
      if (isRegexMatch(paramObject1, localCharSequence4)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException4)
    {
      try
      {
        CharSequence localCharSequence3 = (CharSequence)paramObject2;
        return regexMatch(paramObject1, localCharSequence3);
      }
      catch (ClassCastException localClassCastException3)
      {
        CharSequence localCharSequence2;
        CharSequence localCharSequence1;
        throw new WrongType(localClassCastException3, "regex-match", 2, paramObject2);
      }
      try
      {
        localCharSequence2 = (CharSequence)paramObject2;
        return regexMatchPositions(paramObject1, localCharSequence2);
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "regex-match-positions", 2, paramObject2);
      }
      try
      {
        localCharSequence1 = (CharSequence)paramObject2;
        return regexSplit(paramObject1, localCharSequence1);
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "regex-split", 2, paramObject2);
      }
      localClassCastException4 = localClassCastException4;
      throw new WrongType(localClassCastException4, "regex-match?", 2, paramObject2);
    }
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 283	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+52->56, 3:+62->66, 6:+97->101, 9:+122->126, 13:+147->151, 14:+162->166
    //   57: aload_1
    //   58: aload_2
    //   59: aload_3
    //   60: aload 4
    //   62: invokespecial 305	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: areturn
    //   66: aload_3
    //   67: checkcast 107	java/lang/CharSequence
    //   70: astore 18
    //   72: aload 4
    //   74: checkcast 307	java/lang/Number
    //   77: invokevirtual 310	java/lang/Number:intValue	()I
    //   80: istore 20
    //   82: aload_2
    //   83: aload 18
    //   85: iload 20
    //   87: invokestatic 105	kawa/lib/kawa/regex:isRegexMatch	(Ljava/lang/Object;Ljava/lang/CharSequence;I)Z
    //   90: ifeq +7 -> 97
    //   93: getstatic 295	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   96: areturn
    //   97: getstatic 176	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   100: areturn
    //   101: aload_3
    //   102: checkcast 107	java/lang/CharSequence
    //   105: astore 14
    //   107: aload 4
    //   109: checkcast 307	java/lang/Number
    //   112: invokevirtual 310	java/lang/Number:intValue	()I
    //   115: istore 16
    //   117: aload_2
    //   118: aload 14
    //   120: iload 16
    //   122: invokestatic 154	kawa/lib/kawa/regex:regexMatch	(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;
    //   125: areturn
    //   126: aload_3
    //   127: checkcast 107	java/lang/CharSequence
    //   130: astore 10
    //   132: aload 4
    //   134: checkcast 307	java/lang/Number
    //   137: invokevirtual 310	java/lang/Number:intValue	()I
    //   140: istore 12
    //   142: aload_2
    //   143: aload 10
    //   145: iload 12
    //   147: invokestatic 192	kawa/lib/kawa/regex:regexMatchPositions	(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;
    //   150: areturn
    //   151: aload_3
    //   152: checkcast 107	java/lang/CharSequence
    //   155: astore 8
    //   157: aload_2
    //   158: aload 8
    //   160: aload 4
    //   162: invokestatic 312	kawa/lib/kawa/regex:regexReplace	(Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   165: areturn
    //   166: aload_3
    //   167: checkcast 107	java/lang/CharSequence
    //   170: astore 6
    //   172: aload_2
    //   173: aload 6
    //   175: aload 4
    //   177: invokestatic 314	kawa/lib/kawa/regex:regexReplace$St	(Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   180: areturn
    //   181: astore 17
    //   183: new 144	gnu/mapping/WrongType
    //   186: dup
    //   187: aload 17
    //   189: ldc 57
    //   191: iconst_2
    //   192: aload_3
    //   193: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   196: athrow
    //   197: astore 19
    //   199: new 144	gnu/mapping/WrongType
    //   202: dup
    //   203: aload 19
    //   205: ldc 57
    //   207: iconst_3
    //   208: aload 4
    //   210: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   213: athrow
    //   214: astore 13
    //   216: new 144	gnu/mapping/WrongType
    //   219: dup
    //   220: aload 13
    //   222: ldc 53
    //   224: iconst_2
    //   225: aload_3
    //   226: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   229: athrow
    //   230: astore 15
    //   232: new 144	gnu/mapping/WrongType
    //   235: dup
    //   236: aload 15
    //   238: ldc 53
    //   240: iconst_3
    //   241: aload 4
    //   243: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   246: athrow
    //   247: astore 9
    //   249: new 144	gnu/mapping/WrongType
    //   252: dup
    //   253: aload 9
    //   255: ldc 49
    //   257: iconst_2
    //   258: aload_3
    //   259: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   262: athrow
    //   263: astore 11
    //   265: new 144	gnu/mapping/WrongType
    //   268: dup
    //   269: aload 11
    //   271: ldc 49
    //   273: iconst_3
    //   274: aload 4
    //   276: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   279: athrow
    //   280: astore 7
    //   282: new 144	gnu/mapping/WrongType
    //   285: dup
    //   286: aload 7
    //   288: ldc 41
    //   290: iconst_2
    //   291: aload_3
    //   292: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   295: athrow
    //   296: astore 5
    //   298: new 144	gnu/mapping/WrongType
    //   301: dup
    //   302: aload 5
    //   304: ldc 29
    //   306: iconst_2
    //   307: aload_3
    //   308: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   311: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	regex
    //   0	312	1	paramModuleMethod	ModuleMethod
    //   0	312	2	paramObject1	Object
    //   0	312	3	paramObject2	Object
    //   0	312	4	paramObject3	Object
    //   296	7	5	localClassCastException1	ClassCastException
    //   170	4	6	localCharSequence1	CharSequence
    //   280	7	7	localClassCastException2	ClassCastException
    //   155	4	8	localCharSequence2	CharSequence
    //   247	7	9	localClassCastException3	ClassCastException
    //   130	14	10	localCharSequence3	CharSequence
    //   263	7	11	localClassCastException4	ClassCastException
    //   140	6	12	i	int
    //   214	7	13	localClassCastException5	ClassCastException
    //   105	14	14	localCharSequence4	CharSequence
    //   230	7	15	localClassCastException6	ClassCastException
    //   115	6	16	j	int
    //   181	7	17	localClassCastException7	ClassCastException
    //   70	14	18	localCharSequence5	CharSequence
    //   197	7	19	localClassCastException8	ClassCastException
    //   80	6	20	k	int
    // Exception table:
    //   from	to	target	type
    //   66	72	181	java/lang/ClassCastException
    //   72	82	197	java/lang/ClassCastException
    //   101	107	214	java/lang/ClassCastException
    //   107	117	230	java/lang/ClassCastException
    //   126	132	247	java/lang/ClassCastException
    //   132	142	263	java/lang/ClassCastException
    //   151	157	280	java/lang/ClassCastException
    //   166	172	296	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 283	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+36->40, 3:+48->52, 6:+95->99, 9:+132->136
    //   41: aload_1
    //   42: aload_2
    //   43: aload_3
    //   44: aload 4
    //   46: aload 5
    //   48: invokespecial 318	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: areturn
    //   52: aload_3
    //   53: checkcast 107	java/lang/CharSequence
    //   56: astore 19
    //   58: aload 4
    //   60: checkcast 307	java/lang/Number
    //   63: invokevirtual 310	java/lang/Number:intValue	()I
    //   66: istore 21
    //   68: aload 5
    //   70: checkcast 307	java/lang/Number
    //   73: invokevirtual 310	java/lang/Number:intValue	()I
    //   76: istore 23
    //   78: aload_2
    //   79: aload 19
    //   81: iload 21
    //   83: iload 23
    //   85: invokestatic 114	kawa/lib/kawa/regex:isRegexMatch	(Ljava/lang/Object;Ljava/lang/CharSequence;II)Z
    //   88: ifeq +7 -> 95
    //   91: getstatic 295	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   94: areturn
    //   95: getstatic 176	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   98: areturn
    //   99: aload_3
    //   100: checkcast 107	java/lang/CharSequence
    //   103: astore 13
    //   105: aload 4
    //   107: checkcast 307	java/lang/Number
    //   110: invokevirtual 310	java/lang/Number:intValue	()I
    //   113: istore 15
    //   115: aload 5
    //   117: checkcast 307	java/lang/Number
    //   120: invokevirtual 310	java/lang/Number:intValue	()I
    //   123: istore 17
    //   125: aload_2
    //   126: aload 13
    //   128: iload 15
    //   130: iload 17
    //   132: invokestatic 157	kawa/lib/kawa/regex:regexMatch	(Ljava/lang/Object;Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   135: areturn
    //   136: aload_3
    //   137: checkcast 107	java/lang/CharSequence
    //   140: astore 7
    //   142: aload 4
    //   144: checkcast 307	java/lang/Number
    //   147: invokevirtual 310	java/lang/Number:intValue	()I
    //   150: istore 9
    //   152: aload 5
    //   154: checkcast 307	java/lang/Number
    //   157: invokevirtual 310	java/lang/Number:intValue	()I
    //   160: istore 11
    //   162: aload_2
    //   163: aload 7
    //   165: iload 9
    //   167: iload 11
    //   169: invokestatic 194	kawa/lib/kawa/regex:regexMatchPositions	(Ljava/lang/Object;Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   172: areturn
    //   173: astore 18
    //   175: new 144	gnu/mapping/WrongType
    //   178: dup
    //   179: aload 18
    //   181: ldc 57
    //   183: iconst_2
    //   184: aload_3
    //   185: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   188: athrow
    //   189: astore 20
    //   191: new 144	gnu/mapping/WrongType
    //   194: dup
    //   195: aload 20
    //   197: ldc 57
    //   199: iconst_3
    //   200: aload 4
    //   202: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   205: athrow
    //   206: astore 22
    //   208: new 144	gnu/mapping/WrongType
    //   211: dup
    //   212: aload 22
    //   214: ldc 57
    //   216: iconst_4
    //   217: aload 5
    //   219: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   222: athrow
    //   223: astore 12
    //   225: new 144	gnu/mapping/WrongType
    //   228: dup
    //   229: aload 12
    //   231: ldc 53
    //   233: iconst_2
    //   234: aload_3
    //   235: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   238: athrow
    //   239: astore 14
    //   241: new 144	gnu/mapping/WrongType
    //   244: dup
    //   245: aload 14
    //   247: ldc 53
    //   249: iconst_3
    //   250: aload 4
    //   252: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   255: athrow
    //   256: astore 16
    //   258: new 144	gnu/mapping/WrongType
    //   261: dup
    //   262: aload 16
    //   264: ldc 53
    //   266: iconst_4
    //   267: aload 5
    //   269: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   272: athrow
    //   273: astore 6
    //   275: new 144	gnu/mapping/WrongType
    //   278: dup
    //   279: aload 6
    //   281: ldc 49
    //   283: iconst_2
    //   284: aload_3
    //   285: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   288: athrow
    //   289: astore 8
    //   291: new 144	gnu/mapping/WrongType
    //   294: dup
    //   295: aload 8
    //   297: ldc 49
    //   299: iconst_3
    //   300: aload 4
    //   302: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   305: athrow
    //   306: astore 10
    //   308: new 144	gnu/mapping/WrongType
    //   311: dup
    //   312: aload 10
    //   314: ldc 49
    //   316: iconst_4
    //   317: aload 5
    //   319: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   322: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	regex
    //   0	323	1	paramModuleMethod	ModuleMethod
    //   0	323	2	paramObject1	Object
    //   0	323	3	paramObject2	Object
    //   0	323	4	paramObject3	Object
    //   0	323	5	paramObject4	Object
    //   273	7	6	localClassCastException1	ClassCastException
    //   140	24	7	localCharSequence1	CharSequence
    //   289	7	8	localClassCastException2	ClassCastException
    //   150	16	9	i	int
    //   306	7	10	localClassCastException3	ClassCastException
    //   160	8	11	j	int
    //   223	7	12	localClassCastException4	ClassCastException
    //   103	24	13	localCharSequence2	CharSequence
    //   239	7	14	localClassCastException5	ClassCastException
    //   113	16	15	k	int
    //   256	7	16	localClassCastException6	ClassCastException
    //   123	8	17	m	int
    //   173	7	18	localClassCastException7	ClassCastException
    //   56	24	19	localCharSequence3	CharSequence
    //   189	7	20	localClassCastException8	ClassCastException
    //   66	16	21	n	int
    //   206	7	22	localClassCastException9	ClassCastException
    //   76	8	23	i1	int
    // Exception table:
    //   from	to	target	type
    //   52	58	173	java/lang/ClassCastException
    //   58	68	189	java/lang/ClassCastException
    //   68	78	206	java/lang/ClassCastException
    //   99	105	223	java/lang/ClassCastException
    //   105	115	239	java/lang/ClassCastException
    //   115	125	256	java/lang/ClassCastException
    //   136	142	273	java/lang/ClassCastException
    //   142	152	289	java/lang/ClassCastException
    //   152	162	306	java/lang/ClassCastException
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 2)
    {
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    }
    return super.match1(paramModuleMethod, paramObject, paramCallContext);
  }
  
  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 12: 
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 9: 
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 6: 
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    }
    paramCallContext.value1 = paramObject1;
    if ((paramObject2 instanceof CharSequence))
    {
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    return -786430;
  }
  
  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 14: 
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786430;
    case 13: 
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786430;
    case 9: 
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786430;
    case 6: 
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786430;
    }
    paramCallContext.value1 = paramObject1;
    if ((paramObject2 instanceof CharSequence))
    {
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    }
    return -786430;
  }
  
  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    case 9: 
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.value4 = paramObject4;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 4;
        return 0;
      }
      return -786430;
    case 6: 
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.value4 = paramObject4;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 4;
        return 0;
      }
      return -786430;
    }
    paramCallContext.value1 = paramObject1;
    if ((paramObject2 instanceof CharSequence))
    {
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    }
    return -786430;
  }
  
  public final void run(CallContext paramCallContext) {}
  
  public class frame
    extends ModuleBody
  {
    Object loop = new ModuleMethod(this, 1, regex.Lit0, 0);
    Matcher matcher;
    Object repl;
    StringBuffer sbuf;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 1) {
        return lambda1loop();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public String lambda1loop()
    {
      Matcher localMatcher;
      StringBuffer localStringBuffer;
      Object localObject;
      if (this.matcher.find())
      {
        localMatcher = this.matcher;
        localStringBuffer = this.sbuf;
        localObject = Scheme.applyToArgs.apply2(this.repl, this.matcher.group());
        if (localObject != null) {
          break label78;
        }
      }
      label78:
      for (String str = null;; str = localObject.toString())
      {
        localMatcher.appendReplacement(localStringBuffer, Matcher.quoteReplacement(str));
        this.matcher.appendTail(this.sbuf);
        return this.sbuf.toString();
      }
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 1)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.kawa.regex
 * JD-Core Version:    0.7.0.1
 */