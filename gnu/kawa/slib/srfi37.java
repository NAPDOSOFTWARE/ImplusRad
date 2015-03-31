package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.NumberCompare;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.call_with_values;

public class srfi37
  extends ModuleBody
{
  public static final srfi37 $instance;
  static final IntNum Lit0;
  static final Char Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11 = (SimpleSymbol)new SimpleSymbol("args-fold").readResolve();
  static final Char Lit2;
  static final IntNum Lit3;
  static final IntNum Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod args$Mnfold;
  public static final ModuleMethod option;
  public static final ModuleMethod option$Mnnames;
  public static final ModuleMethod option$Mnoptional$Mnarg$Qu;
  public static final ModuleMethod option$Mnprocessor;
  public static final ModuleMethod option$Mnrequired$Mnarg$Qu;
  static final Class option$Mntype;
  public static final ModuleMethod option$Qu;
  
  static
  {
    Lit10 = (SimpleSymbol)new SimpleSymbol("option-processor").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("option-optional-arg?").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("option-required-arg?").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("option-names").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("option").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("option?").readResolve();
    Lit4 = IntNum.make(0);
    Lit3 = IntNum.make(3);
    Lit2 = Char.make(61);
    Lit1 = Char.make(45);
    Lit0 = IntNum.make(1);
    $instance = new srfi37();
    option$Mntype = option.Mntype.class;
    srfi37 localsrfi37 = $instance;
    option$Qu = new ModuleMethod(localsrfi37, 25, Lit5, 4097);
    option = new ModuleMethod(localsrfi37, 26, Lit6, 16388);
    option$Mnnames = new ModuleMethod(localsrfi37, 27, Lit7, 4097);
    option$Mnrequired$Mnarg$Qu = new ModuleMethod(localsrfi37, 28, Lit8, 4097);
    option$Mnoptional$Mnarg$Qu = new ModuleMethod(localsrfi37, 29, Lit9, 4097);
    option$Mnprocessor = new ModuleMethod(localsrfi37, 30, Lit10, 4097);
    args$Mnfold = new ModuleMethod(localsrfi37, 31, Lit11, -4092);
    $instance.run();
  }
  
  public srfi37()
  {
    ModuleInfo.register(this);
  }
  
  public static Object argsFold$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object[] paramArrayOfObject)
  {
    frame localframe = new frame();
    localframe.options = paramObject2;
    localframe.unrecognized$Mnoption$Mnproc = paramObject3;
    localframe.operand$Mnproc = paramObject4;
    return localframe.lambda5scanArgs(paramObject1, LList.makeList(paramArrayOfObject, 0));
  }
  
  public static boolean isOption(Object paramObject)
  {
    return paramObject instanceof option.Mntype;
  }
  
  public static Object isOptionOptionalArg(option.Mntype paramMntype)
  {
    return paramMntype.optional$Mnarg$Qu;
  }
  
  public static Object isOptionRequiredArg(option.Mntype paramMntype)
  {
    return paramMntype.required$Mnarg$Qu;
  }
  
  public static option.Mntype option(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    option.Mntype localMntype = new option.Mntype();
    localMntype.names = paramObject1;
    localMntype.required$Mnarg$Qu = paramObject2;
    localMntype.optional$Mnarg$Qu = paramObject3;
    localMntype.processor = paramObject4;
    return localMntype;
  }
  
  public static Object optionNames(option.Mntype paramMntype)
  {
    return paramMntype.names;
  }
  
  public static Object optionProcessor(option.Mntype paramMntype)
  {
    return paramMntype.processor;
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 26: 
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 25: 
      if (isOption(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    try
    {
      option.Mntype localMntype4 = (option.Mntype)paramObject;
      return optionNames(localMntype4);
    }
    catch (ClassCastException localClassCastException4)
    {
      try
      {
        option.Mntype localMntype3 = (option.Mntype)paramObject;
        return isOptionRequiredArg(localMntype3);
      }
      catch (ClassCastException localClassCastException3)
      {
        option.Mntype localMntype2;
        option.Mntype localMntype1;
        throw new WrongType(localClassCastException3, "option-required-arg?", 1, paramObject);
      }
      try
      {
        localMntype2 = (option.Mntype)paramObject;
        return isOptionOptionalArg(localMntype2);
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "option-optional-arg?", 1, paramObject);
      }
      try
      {
        localMntype1 = (option.Mntype)paramObject;
        return optionProcessor(localMntype1);
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "option-processor", 1, paramObject);
      }
      localClassCastException4 = localClassCastException4;
      throw new WrongType(localClassCastException4, "option-names", 1, paramObject);
    }
  }
  
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (paramModuleMethod.selector == 26) {
      return option(paramObject1, paramObject2, paramObject3, paramObject4);
    }
    return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    if (paramModuleMethod.selector == 31)
    {
      Object localObject1 = paramArrayOfObject[0];
      Object localObject2 = paramArrayOfObject[1];
      Object localObject3 = paramArrayOfObject[2];
      Object localObject4 = paramArrayOfObject[3];
      int i = -4 + paramArrayOfObject.length;
      Object[] arrayOfObject = new Object[i];
      for (;;)
      {
        i--;
        if (i < 0) {
          return argsFold$V(localObject1, localObject2, localObject3, localObject4, arrayOfObject);
        }
        arrayOfObject[i] = paramArrayOfObject[(i + 4)];
      }
    }
    return super.applyN(paramModuleMethod, paramArrayOfObject);
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    int i = -786431;
    switch (paramModuleMethod.selector)
    {
    case 26: 
    default: 
      i = super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 30: 
    case 29: 
    case 28: 
    case 27: 
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
            } while (!(paramObject instanceof option.Mntype));
            paramCallContext.value1 = paramObject;
            paramCallContext.proc = paramModuleMethod;
            paramCallContext.pc = 1;
            return 0;
          } while (!(paramObject instanceof option.Mntype));
          paramCallContext.value1 = paramObject;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 1;
          return 0;
        } while (!(paramObject instanceof option.Mntype));
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      } while (!(paramObject instanceof option.Mntype));
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
  
  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 26)
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    }
    return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 31)
    {
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    }
    return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
  }
  
  public final void run(CallContext paramCallContext) {}
  
  public class frame
    extends ModuleBody
  {
    Object operand$Mnproc;
    Object options;
    Object unrecognized$Mnoption$Mnproc;
    
    public static Object lambda1find(Object paramObject1, Object paramObject2)
    {
      if (lists.isNull(paramObject1)) {
        return Boolean.FALSE;
      }
      if (Scheme.applyToArgs.apply2(paramObject2, lists.car.apply1(paramObject1)) != Boolean.FALSE) {
        return lists.car.apply1(paramObject1);
      }
      return lambda1find(lists.cdr.apply1(paramObject1), paramObject2);
    }
    
    public Object lambda2findOption(Object paramObject)
    {
      srfi37.frame0 localframe0 = new srfi37.frame0();
      localframe0.staticLink = this;
      localframe0.name = paramObject;
      return lambda1find(this.options, localframe0.lambda$Fn1);
    }
    
    /* Error */
    public Object lambda3scanShortOptions(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      // Byte code:
      //   0: new 73	gnu/kawa/slib/srfi37$frame1
      //   3: dup
      //   4: invokespecial 74	gnu/kawa/slib/srfi37$frame1:<init>	()V
      //   7: astore 5
      //   9: aload 5
      //   11: aload_0
      //   12: putfield 75	gnu/kawa/slib/srfi37$frame1:staticLink	Lgnu/kawa/slib/srfi37$frame;
      //   15: aload 5
      //   17: aload_1
      //   18: putfield 78	gnu/kawa/slib/srfi37$frame1:index	Ljava/lang/Object;
      //   21: aload 5
      //   23: aload_2
      //   24: putfield 81	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   27: aload 5
      //   29: aload_3
      //   30: putfield 84	gnu/kawa/slib/srfi37$frame1:args	Ljava/lang/Object;
      //   33: aload 5
      //   35: aload 4
      //   37: putfield 87	gnu/kawa/slib/srfi37$frame1:seeds	Ljava/lang/Object;
      //   40: getstatic 91	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
      //   43: astore 6
      //   45: aload 5
      //   47: getfield 78	gnu/kawa/slib/srfi37$frame1:index	Ljava/lang/Object;
      //   50: astore 7
      //   52: aload 5
      //   54: getfield 81	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   57: astore 8
      //   59: aload 8
      //   61: checkcast 93	java/lang/CharSequence
      //   64: astore 10
      //   66: aload 6
      //   68: aload 7
      //   70: aload 10
      //   72: invokestatic 99	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   75: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   78: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   81: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   84: if_acmpeq +18 -> 102
      //   87: aload_0
      //   88: aload 5
      //   90: getfield 84	gnu/kawa/slib/srfi37$frame1:args	Ljava/lang/Object;
      //   93: aload 5
      //   95: getfield 87	gnu/kawa/slib/srfi37$frame1:seeds	Ljava/lang/Object;
      //   98: invokevirtual 108	gnu/kawa/slib/srfi37$frame:lambda5scanArgs	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   101: areturn
      //   102: aload 5
      //   104: getfield 81	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   107: astore 11
      //   109: aload 11
      //   111: checkcast 93	java/lang/CharSequence
      //   114: astore 13
      //   116: aload 5
      //   118: getfield 78	gnu/kawa/slib/srfi37$frame1:index	Ljava/lang/Object;
      //   121: astore 14
      //   123: aload 14
      //   125: checkcast 110	java/lang/Number
      //   128: invokevirtual 114	java/lang/Number:intValue	()I
      //   131: istore 16
      //   133: aload 5
      //   135: aload 13
      //   137: iload 16
      //   139: invokestatic 118	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   142: putfield 121	gnu/kawa/slib/srfi37$frame1:name	C
      //   145: aload_0
      //   146: aload 5
      //   148: getfield 121	gnu/kawa/slib/srfi37$frame1:name	C
      //   151: invokestatic 127	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   154: invokevirtual 129	gnu/kawa/slib/srfi37$frame:lambda2findOption	(Ljava/lang/Object;)Ljava/lang/Object;
      //   157: astore 17
      //   159: aload 17
      //   161: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   164: if_acmpeq +128 -> 292
      //   167: aload 5
      //   169: aload 17
      //   171: putfield 132	gnu/kawa/slib/srfi37$frame1:option	Ljava/lang/Object;
      //   174: getstatic 135	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   177: astore 18
      //   179: getstatic 141	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   182: aload 5
      //   184: getfield 78	gnu/kawa/slib/srfi37$frame1:index	Ljava/lang/Object;
      //   187: getstatic 147	gnu/kawa/slib/srfi37:Lit0	Lgnu/math/IntNum;
      //   190: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   193: astore 19
      //   195: aload 5
      //   197: getfield 81	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   200: astore 20
      //   202: aload 20
      //   204: checkcast 93	java/lang/CharSequence
      //   207: astore 22
      //   209: aload 18
      //   211: aload 19
      //   213: aload 22
      //   215: invokestatic 99	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   218: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   221: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   224: astore 23
      //   226: aload 23
      //   228: checkcast 22	java/lang/Boolean
      //   231: invokevirtual 151	java/lang/Boolean:booleanValue	()Z
      //   234: istore 25
      //   236: iload 25
      //   238: ifeq +162 -> 400
      //   241: aload 5
      //   243: getfield 132	gnu/kawa/slib/srfi37$frame1:option	Ljava/lang/Object;
      //   246: astore 30
      //   248: aload 30
      //   250: checkcast 153	gnu/kawa/slib/option$Mntype
      //   253: astore 32
      //   255: aload 32
      //   257: invokestatic 157	gnu/kawa/slib/srfi37:isOptionRequiredArg	(Lgnu/kawa/slib/option$Mntype;)Ljava/lang/Object;
      //   260: astore 33
      //   262: aload 33
      //   264: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   267: if_acmpeq +54 -> 321
      //   270: aload 33
      //   272: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   275: if_acmpeq +71 -> 346
      //   278: aload 5
      //   280: getfield 160	gnu/kawa/slib/srfi37$frame1:lambda$Fn3	Lgnu/expr/ModuleMethod;
      //   283: aload 5
      //   285: getfield 163	gnu/kawa/slib/srfi37$frame1:lambda$Fn4	Lgnu/expr/ModuleMethod;
      //   288: invokestatic 169	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   291: areturn
      //   292: aload 5
      //   294: getfield 121	gnu/kawa/slib/srfi37$frame1:name	C
      //   297: invokestatic 127	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   300: invokestatic 175	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   303: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   306: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   309: aload_0
      //   310: getfield 177	gnu/kawa/slib/srfi37$frame:unrecognized$Mnoption$Mnproc	Ljava/lang/Object;
      //   313: invokestatic 180	gnu/kawa/slib/srfi37:option	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/slib/option$Mntype;
      //   316: astore 17
      //   318: goto -151 -> 167
      //   321: aload 5
      //   323: getfield 132	gnu/kawa/slib/srfi37$frame1:option	Ljava/lang/Object;
      //   326: astore 34
      //   328: aload 34
      //   330: checkcast 153	gnu/kawa/slib/option$Mntype
      //   333: astore 36
      //   335: aload 36
      //   337: invokestatic 183	gnu/kawa/slib/srfi37:isOptionOptionalArg	(Lgnu/kawa/slib/option$Mntype;)Ljava/lang/Object;
      //   340: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   343: if_acmpne -65 -> 278
      //   346: aload 5
      //   348: getfield 132	gnu/kawa/slib/srfi37$frame1:option	Ljava/lang/Object;
      //   351: astore 26
      //   353: aload 26
      //   355: checkcast 153	gnu/kawa/slib/option$Mntype
      //   358: astore 28
      //   360: aload 28
      //   362: invokestatic 157	gnu/kawa/slib/srfi37:isOptionRequiredArg	(Lgnu/kawa/slib/option$Mntype;)Ljava/lang/Object;
      //   365: astore 29
      //   367: aload 29
      //   369: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   372: if_acmpeq +36 -> 408
      //   375: aload 5
      //   377: getfield 84	gnu/kawa/slib/srfi37$frame1:args	Ljava/lang/Object;
      //   380: invokestatic 186	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   383: ifeq +33 -> 416
      //   386: aload 5
      //   388: getfield 189	gnu/kawa/slib/srfi37$frame1:lambda$Fn5	Lgnu/expr/ModuleMethod;
      //   391: aload 5
      //   393: getfield 192	gnu/kawa/slib/srfi37$frame1:lambda$Fn6	Lgnu/expr/ModuleMethod;
      //   396: invokestatic 169	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   399: areturn
      //   400: iload 25
      //   402: ifeq -56 -> 346
      //   405: goto -127 -> 278
      //   408: aload 29
      //   410: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   413: if_acmpne -27 -> 386
      //   416: aload 5
      //   418: getfield 195	gnu/kawa/slib/srfi37$frame1:lambda$Fn7	Lgnu/expr/ModuleMethod;
      //   421: aload 5
      //   423: getfield 198	gnu/kawa/slib/srfi37$frame1:lambda$Fn8	Lgnu/expr/ModuleMethod;
      //   426: invokestatic 169	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   429: areturn
      //   430: astore 9
      //   432: new 200	gnu/mapping/WrongType
      //   435: dup
      //   436: aload 9
      //   438: ldc 202
      //   440: iconst_1
      //   441: aload 8
      //   443: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   446: athrow
      //   447: astore 12
      //   449: new 200	gnu/mapping/WrongType
      //   452: dup
      //   453: aload 12
      //   455: ldc 207
      //   457: iconst_1
      //   458: aload 11
      //   460: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   463: athrow
      //   464: astore 15
      //   466: new 200	gnu/mapping/WrongType
      //   469: dup
      //   470: aload 15
      //   472: ldc 207
      //   474: iconst_2
      //   475: aload 14
      //   477: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   480: athrow
      //   481: astore 21
      //   483: new 200	gnu/mapping/WrongType
      //   486: dup
      //   487: aload 21
      //   489: ldc 202
      //   491: iconst_1
      //   492: aload 20
      //   494: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   497: athrow
      //   498: astore 24
      //   500: new 200	gnu/mapping/WrongType
      //   503: dup
      //   504: aload 24
      //   506: ldc 209
      //   508: bipush 254
      //   510: aload 23
      //   512: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   515: athrow
      //   516: astore 31
      //   518: new 200	gnu/mapping/WrongType
      //   521: dup
      //   522: aload 31
      //   524: ldc 211
      //   526: iconst_0
      //   527: aload 30
      //   529: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   532: athrow
      //   533: astore 35
      //   535: new 200	gnu/mapping/WrongType
      //   538: dup
      //   539: aload 35
      //   541: ldc 213
      //   543: iconst_0
      //   544: aload 34
      //   546: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   549: athrow
      //   550: astore 27
      //   552: new 200	gnu/mapping/WrongType
      //   555: dup
      //   556: aload 27
      //   558: ldc 211
      //   560: iconst_0
      //   561: aload 26
      //   563: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   566: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	567	0	this	frame
      //   0	567	1	paramObject1	Object
      //   0	567	2	paramObject2	Object
      //   0	567	3	paramObject3	Object
      //   0	567	4	paramObject4	Object
      //   7	415	5	localframe1	srfi37.frame1
      //   43	24	6	localNumberCompare1	NumberCompare
      //   50	19	7	localObject1	Object
      //   57	385	8	localObject2	Object
      //   430	7	9	localClassCastException1	ClassCastException
      //   64	7	10	localCharSequence1	CharSequence
      //   107	352	11	localObject3	Object
      //   447	7	12	localClassCastException2	ClassCastException
      //   114	22	13	localCharSequence2	CharSequence
      //   121	355	14	localObject4	Object
      //   464	7	15	localClassCastException3	ClassCastException
      //   131	7	16	i	int
      //   157	160	17	localObject5	Object
      //   177	33	18	localNumberCompare2	NumberCompare
      //   193	19	19	localObject6	Object
      //   200	293	20	localObject7	Object
      //   481	7	21	localClassCastException4	ClassCastException
      //   207	7	22	localCharSequence3	CharSequence
      //   224	287	23	localObject8	Object
      //   498	7	24	localClassCastException5	ClassCastException
      //   234	167	25	bool	boolean
      //   351	211	26	localObject9	Object
      //   550	7	27	localClassCastException6	ClassCastException
      //   358	3	28	localMntype1	option.Mntype
      //   365	44	29	localObject10	Object
      //   246	282	30	localObject11	Object
      //   516	7	31	localClassCastException7	ClassCastException
      //   253	3	32	localMntype2	option.Mntype
      //   260	11	33	localObject12	Object
      //   326	219	34	localObject13	Object
      //   533	7	35	localClassCastException8	ClassCastException
      //   333	3	36	localMntype3	option.Mntype
      // Exception table:
      //   from	to	target	type
      //   59	66	430	java/lang/ClassCastException
      //   109	116	447	java/lang/ClassCastException
      //   123	133	464	java/lang/ClassCastException
      //   202	209	481	java/lang/ClassCastException
      //   226	236	498	java/lang/ClassCastException
      //   248	255	516	java/lang/ClassCastException
      //   328	335	533	java/lang/ClassCastException
      //   353	360	550	java/lang/ClassCastException
    }
    
    public Object lambda4scanOperands(Object paramObject1, Object paramObject2)
    {
      srfi37.frame2 localframe2 = new srfi37.frame2();
      localframe2.staticLink = this;
      localframe2.operands = paramObject1;
      localframe2.seeds = paramObject2;
      if (lists.isNull(localframe2.operands)) {
        return Scheme.apply.apply2(misc.values, localframe2.seeds);
      }
      return call_with_values.callWithValues(localframe2.lambda$Fn9, localframe2.lambda$Fn10);
    }
    
    public Object lambda5scanArgs(Object paramObject1, Object paramObject2)
    {
      srfi37.frame3 localframe3 = new srfi37.frame3();
      localframe3.staticLink = this;
      localframe3.seeds = paramObject2;
      if (lists.isNull(paramObject1)) {
        return Scheme.apply.apply2(misc.values, localframe3.seeds);
      }
      Object localObject1 = lists.car.apply1(paramObject1);
      localframe3.args = lists.cdr.apply1(paramObject1);
      localframe3.arg = localObject1;
      if (strings.isString$Eq("--", localframe3.arg)) {
        return lambda4scanOperands(localframe3.args, localframe3.seeds);
      }
      localObject2 = localframe3.arg;
      for (;;)
      {
        try
        {
          CharSequence localCharSequence1 = (CharSequence)localObject2;
          if (strings.stringLength(localCharSequence1) > 4)
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            localChar4 = srfi37.Lit1;
            localObject16 = localframe3.arg;
          }
        }
        catch (ClassCastException localClassCastException1)
        {
          int i;
          Char localChar4;
          CharSequence localCharSequence12;
          boolean bool2;
          Char localChar5;
          CharSequence localCharSequence13;
          boolean bool3;
          Char localChar6;
          CharSequence localCharSequence14;
          int m;
          NumberCompare localNumberCompare;
          CharSequence localCharSequence15;
          Char localChar7;
          CharSequence localCharSequence16;
          int n;
          throw new WrongType(localClassCastException1, "string-length", 1, localObject2);
        }
        try
        {
          localCharSequence12 = (CharSequence)localObject16;
          bool2 = characters.isChar$Eq(localChar4, Char.make(strings.stringRef(localCharSequence12, 0)));
          if (bool2)
          {
            localChar5 = srfi37.Lit1;
            localObject17 = localframe3.arg;
          }
        }
        catch (ClassCastException localClassCastException12)
        {
          throw new WrongType(localClassCastException12, "string-ref", 1, localObject16);
        }
        try
        {
          localCharSequence13 = (CharSequence)localObject17;
          bool3 = characters.isChar$Eq(localChar5, Char.make(strings.stringRef(localCharSequence13, 1)));
          if (bool3)
          {
            localChar6 = srfi37.Lit2;
            localObject18 = localframe3.arg;
          }
        }
        catch (ClassCastException localClassCastException13)
        {
          throw new WrongType(localClassCastException13, "string-ref", 1, localObject17);
        }
        try
        {
          localCharSequence14 = (CharSequence)localObject18;
          m = 0x1 & true + characters.isChar$Eq(localChar6, Char.make(strings.stringRef(localCharSequence14, 2)));
          if (m != 0)
          {
            localObject3 = srfi37.Lit3;
            localNumberCompare = Scheme.numEqu;
            localObject19 = localframe3.arg;
          }
        }
        catch (ClassCastException localClassCastException14)
        {
          throw new WrongType(localClassCastException14, "string-ref", 1, localObject18);
        }
        try
        {
          localCharSequence15 = (CharSequence)localObject19;
          if (localNumberCompare.apply2(localObject3, Integer.valueOf(strings.stringLength(localCharSequence15))) != Boolean.FALSE)
          {
            localObject3 = Boolean.FALSE;
            localframe3.temp = localObject3;
            if (localframe3.temp != Boolean.FALSE)
            {
              return call_with_values.callWithValues(localframe3.lambda$Fn11, localframe3.lambda$Fn12);
              i = 0;
            }
          }
          else
          {
            localChar7 = srfi37.Lit2;
            localObject20 = localframe3.arg;
          }
        }
        catch (ClassCastException localClassCastException15)
        {
          throw new WrongType(localClassCastException15, "string-length", 1, localObject19);
        }
        try
        {
          localCharSequence16 = (CharSequence)localObject20;
        }
        catch (ClassCastException localClassCastException16)
        {
          throw new WrongType(localClassCastException16, "string-ref", 1, localObject20);
        }
        try
        {
          n = ((Number)localObject3).intValue();
          if (characters.isChar$Eq(localChar7, Char.make(strings.stringRef(localCharSequence16, n)))) {
            continue;
          }
          localObject3 = AddOp.$Pl.apply2(srfi37.Lit0, localObject3);
        }
        catch (ClassCastException localClassCastException17)
        {
          throw new WrongType(localClassCastException17, "string-ref", 2, localObject3);
        }
        if (m != 0)
        {
          localObject3 = Boolean.TRUE;
        }
        else
        {
          localObject3 = Boolean.FALSE;
          continue;
          if (bool3)
          {
            localObject3 = Boolean.TRUE;
          }
          else
          {
            localObject3 = Boolean.FALSE;
            continue;
            if (bool2)
            {
              localObject3 = Boolean.TRUE;
            }
            else
            {
              localObject3 = Boolean.FALSE;
              continue;
              if (i != 0) {
                localObject3 = Boolean.TRUE;
              } else {
                localObject3 = Boolean.FALSE;
              }
            }
          }
        }
      }
      localObject4 = localframe3.arg;
      do
      {
        for (;;)
        {
          try
          {
            CharSequence localCharSequence2 = (CharSequence)localObject4;
            if (strings.stringLength(localCharSequence2) > 3)
            {
              j = 1;
              if (j == 0) {
                continue;
              }
              localChar2 = srfi37.Lit1;
              localObject14 = localframe3.arg;
            }
          }
          catch (ClassCastException localClassCastException2)
          {
            int j;
            Char localChar2;
            CharSequence localCharSequence10;
            boolean bool1;
            Char localChar3;
            CharSequence localCharSequence11;
            CharSequence localCharSequence3;
            CharSequence localCharSequence4;
            Object localObject7;
            option.Mntype localMntype;
            Object localObject9;
            CharSequence localCharSequence5;
            int k;
            Char localChar1;
            CharSequence localCharSequence9;
            CharSequence localCharSequence6;
            CharSequence localCharSequence7;
            CharSequence localCharSequence8;
            throw new WrongType(localClassCastException2, "string-length", 1, localObject4);
          }
          try
          {
            localCharSequence10 = (CharSequence)localObject14;
            bool1 = characters.isChar$Eq(localChar2, Char.make(strings.stringRef(localCharSequence10, 0)));
            if (bool1)
            {
              localChar3 = srfi37.Lit1;
              localObject15 = localframe3.arg;
            }
          }
          catch (ClassCastException localClassCastException10)
          {
            throw new WrongType(localClassCastException10, "string-ref", 1, localObject14);
          }
          try
          {
            localCharSequence11 = (CharSequence)localObject15;
            if (characters.isChar$Eq(localChar3, Char.make(strings.stringRef(localCharSequence11, 1)))) {
              localObject5 = localframe3.arg;
            }
          }
          catch (ClassCastException localClassCastException11)
          {
            throw new WrongType(localClassCastException11, "string-ref", 1, localObject15);
          }
          try
          {
            localCharSequence3 = (CharSequence)localObject5;
            localObject6 = localframe3.arg;
          }
          catch (ClassCastException localClassCastException3)
          {
            throw new WrongType(localClassCastException3, "substring", 1, localObject5);
          }
          try
          {
            localCharSequence4 = (CharSequence)localObject6;
            localframe3.name = strings.substring(localCharSequence3, 2, strings.stringLength(localCharSequence4));
            localObject7 = lambda2findOption(localframe3.name);
            if (localObject7 != Boolean.FALSE)
            {
              localframe3.option = localObject7;
              localObject8 = localframe3.option;
            }
          }
          catch (ClassCastException localClassCastException4)
          {
            throw new WrongType(localClassCastException4, "string-length", 1, localObject6);
          }
          try
          {
            localMntype = (option.Mntype)localObject8;
            localObject9 = srfi37.isOptionRequiredArg(localMntype);
            if (localObject9 != Boolean.FALSE)
            {
              if (!lists.isPair(localframe3.args)) {
                continue;
              }
              return call_with_values.callWithValues(localframe3.lambda$Fn19, localframe3.lambda$Fn20);
              j = 0;
              continue;
              if (bool1) {
                continue;
              }
              localObject10 = localframe3.arg;
            }
          }
          catch (ClassCastException localClassCastException5)
          {
            throw new WrongType(localClassCastException5, "option-required-arg?", 0, localObject8);
          }
          try
          {
            localCharSequence5 = (CharSequence)localObject10;
            if (strings.stringLength(localCharSequence5) > 1)
            {
              k = 1;
              if (k == 0) {
                continue;
              }
              localChar1 = srfi37.Lit1;
              localObject13 = localframe3.arg;
            }
          }
          catch (ClassCastException localClassCastException6)
          {
            throw new WrongType(localClassCastException6, "string-length", 1, localObject10);
          }
          try
          {
            localCharSequence9 = (CharSequence)localObject13;
            if (characters.isChar$Eq(localChar1, Char.make(strings.stringRef(localCharSequence9, 0)))) {
              localObject11 = localframe3.arg;
            }
          }
          catch (ClassCastException localClassCastException9)
          {
            throw new WrongType(localClassCastException9, "string-ref", 1, localObject13);
          }
          try
          {
            localCharSequence6 = (CharSequence)localObject11;
            localObject12 = localframe3.arg;
          }
          catch (ClassCastException localClassCastException7)
          {
            throw new WrongType(localClassCastException7, "substring", 1, localObject11);
          }
          try
          {
            localCharSequence7 = (CharSequence)localObject12;
            localCharSequence8 = strings.substring(localCharSequence6, 1, strings.stringLength(localCharSequence7));
            return lambda3scanShortOptions(srfi37.Lit4, localCharSequence8, localframe3.args, localframe3.seeds);
          }
          catch (ClassCastException localClassCastException8)
          {
            throw new WrongType(localClassCastException8, "string-length", 1, localObject12);
          }
          if (j != 0)
          {
            continue;
            localObject7 = srfi37.option(LList.list1(localframe3.name), Boolean.FALSE, Boolean.FALSE, this.unrecognized$Mnoption$Mnproc);
            continue;
            if (localObject9 == Boolean.FALSE)
            {
              return call_with_values.callWithValues(localframe3.lambda$Fn21, localframe3.lambda$Fn22);
              k = 0;
            }
          }
        }
      } while (k != 0);
      return call_with_values.callWithValues(localframe3.lambda$Fn23, localframe3.lambda$Fn24);
    }
  }
  
  public class frame0
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn1;
    final ModuleMethod lambda$Fn2;
    Object name;
    srfi37.frame staticLink;
    
    public frame0()
    {
      this$1 = new ModuleMethod(this, 1, null, 4097);
      this$1.setProperty("source-location", "srfi37.scm:75");
      this.lambda$Fn2 = this$1;
      ModuleMethod localModuleMethod = new ModuleMethod(this, 2, null, 4097);
      localModuleMethod.setProperty("source-location", "srfi37.scm:72");
      this.lambda$Fn1 = localModuleMethod;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply1(paramModuleMethod, paramObject);
      case 1: 
        if (lambda7(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return lambda6(paramObject);
    }
    
    Object lambda6(Object paramObject)
    {
      try
      {
        option.Mntype localMntype = (option.Mntype)paramObject;
        return srfi37.frame.lambda1find(srfi37.optionNames(localMntype), this.lambda$Fn2);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "option-names", 0, paramObject);
      }
    }
    
    boolean lambda7(Object paramObject)
    {
      return IsEqual.apply(this.name, paramObject);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match1(paramModuleMethod, paramObject, paramCallContext);
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
  }
  
  public class frame1
    extends ModuleBody
  {
    Object args;
    Object index;
    final ModuleMethod lambda$Fn3 = new ModuleMethod(this, 3, null, 0);
    final ModuleMethod lambda$Fn4 = new ModuleMethod(this, 4, null, -4096);
    final ModuleMethod lambda$Fn5 = new ModuleMethod(this, 5, null, 0);
    final ModuleMethod lambda$Fn6 = new ModuleMethod(this, 6, null, -4096);
    final ModuleMethod lambda$Fn7 = new ModuleMethod(this, 7, null, 0);
    final ModuleMethod lambda$Fn8 = new ModuleMethod(this, 8, null, -4096);
    char name;
    Object option;
    Object seeds;
    Object shorts;
    srfi37.frame staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      switch (paramModuleMethod.selector)
      {
      case 4: 
      case 6: 
      default: 
        return super.apply0(paramModuleMethod);
      case 3: 
        return lambda8();
      case 5: 
        return lambda10();
      }
      return lambda12();
    }
    
    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      switch (paramModuleMethod.selector)
      {
      case 5: 
      case 7: 
      default: 
        return super.applyN(paramModuleMethod, paramArrayOfObject);
      case 4: 
        return lambda9$V(paramArrayOfObject);
      case 6: 
        return lambda11$V(paramArrayOfObject);
      }
      return lambda13$V(paramArrayOfObject);
    }
    
    Object lambda10()
    {
      Apply localApply = Scheme.apply;
      Object[] arrayOfObject = new Object[5];
      Object localObject = this.option;
      try
      {
        option.Mntype localMntype = (option.Mntype)localObject;
        arrayOfObject[0] = srfi37.optionProcessor(localMntype);
        arrayOfObject[1] = this.option;
        arrayOfObject[2] = Char.make(this.name);
        arrayOfObject[3] = lists.car.apply1(this.args);
        arrayOfObject[4] = this.seeds;
        return localApply.applyN(arrayOfObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "option-processor", 0, localObject);
      }
    }
    
    Object lambda11$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.lambda5scanArgs(lists.cdr.apply1(this.args), localLList);
    }
    
    Object lambda12()
    {
      Apply localApply = Scheme.apply;
      Object[] arrayOfObject = new Object[5];
      Object localObject = this.option;
      try
      {
        option.Mntype localMntype = (option.Mntype)localObject;
        arrayOfObject[0] = srfi37.optionProcessor(localMntype);
        arrayOfObject[1] = this.option;
        arrayOfObject[2] = Char.make(this.name);
        arrayOfObject[3] = Boolean.FALSE;
        arrayOfObject[4] = this.seeds;
        return localApply.applyN(arrayOfObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "option-processor", 0, localObject);
      }
    }
    
    Object lambda13$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.lambda3scanShortOptions(AddOp.$Pl.apply2(this.index, srfi37.Lit0), this.shorts, this.args, localLList);
    }
    
    /* Error */
    Object lambda8()
    {
      // Byte code:
      //   0: getstatic 82	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
      //   3: astore_1
      //   4: iconst_5
      //   5: anewarray 84	java/lang/Object
      //   8: astore_2
      //   9: aload_0
      //   10: getfield 86	gnu/kawa/slib/srfi37$frame1:option	Ljava/lang/Object;
      //   13: astore_3
      //   14: aload_3
      //   15: checkcast 88	gnu/kawa/slib/option$Mntype
      //   18: astore 5
      //   20: aload_2
      //   21: iconst_0
      //   22: aload 5
      //   24: invokestatic 94	gnu/kawa/slib/srfi37:optionProcessor	(Lgnu/kawa/slib/option$Mntype;)Ljava/lang/Object;
      //   27: aastore
      //   28: aload_2
      //   29: iconst_1
      //   30: aload_0
      //   31: getfield 86	gnu/kawa/slib/srfi37$frame1:option	Ljava/lang/Object;
      //   34: aastore
      //   35: aload_2
      //   36: iconst_2
      //   37: aload_0
      //   38: getfield 96	gnu/kawa/slib/srfi37$frame1:name	C
      //   41: invokestatic 102	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   44: aastore
      //   45: aload_0
      //   46: getfield 167	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   49: astore 6
      //   51: aload 6
      //   53: checkcast 173	java/lang/CharSequence
      //   56: astore 8
      //   58: getstatic 156	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   61: aload_0
      //   62: getfield 158	gnu/kawa/slib/srfi37$frame1:index	Ljava/lang/Object;
      //   65: getstatic 162	gnu/kawa/slib/srfi37:Lit0	Lgnu/math/IntNum;
      //   68: invokevirtual 165	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   71: astore 9
      //   73: aload 9
      //   75: checkcast 175	java/lang/Number
      //   78: invokevirtual 179	java/lang/Number:intValue	()I
      //   81: istore 11
      //   83: aload_0
      //   84: getfield 167	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   87: astore 12
      //   89: aload 12
      //   91: checkcast 173	java/lang/CharSequence
      //   94: astore 14
      //   96: aload_2
      //   97: iconst_3
      //   98: aload 8
      //   100: iload 11
      //   102: aload 14
      //   104: invokestatic 185	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   107: invokestatic 189	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   110: aastore
      //   111: aload_2
      //   112: iconst_4
      //   113: aload_0
      //   114: getfield 118	gnu/kawa/slib/srfi37$frame1:seeds	Ljava/lang/Object;
      //   117: aastore
      //   118: aload_1
      //   119: aload_2
      //   120: invokevirtual 120	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
      //   123: areturn
      //   124: astore 4
      //   126: new 122	gnu/mapping/WrongType
      //   129: dup
      //   130: aload 4
      //   132: ldc 124
      //   134: iconst_0
      //   135: aload_3
      //   136: invokespecial 127	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   139: athrow
      //   140: astore 7
      //   142: new 122	gnu/mapping/WrongType
      //   145: dup
      //   146: aload 7
      //   148: ldc 190
      //   150: iconst_1
      //   151: aload 6
      //   153: invokespecial 127	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   156: athrow
      //   157: astore 10
      //   159: new 122	gnu/mapping/WrongType
      //   162: dup
      //   163: aload 10
      //   165: ldc 190
      //   167: iconst_2
      //   168: aload 9
      //   170: invokespecial 127	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   173: athrow
      //   174: astore 13
      //   176: new 122	gnu/mapping/WrongType
      //   179: dup
      //   180: aload 13
      //   182: ldc 192
      //   184: iconst_1
      //   185: aload 12
      //   187: invokespecial 127	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   190: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	191	0	this	frame1
      //   3	116	1	localApply	Apply
      //   8	112	2	arrayOfObject	Object[]
      //   13	123	3	localObject1	Object
      //   124	7	4	localClassCastException1	ClassCastException
      //   18	5	5	localMntype	option.Mntype
      //   49	103	6	localObject2	Object
      //   140	7	7	localClassCastException2	ClassCastException
      //   56	43	8	localCharSequence1	CharSequence
      //   71	98	9	localObject3	Object
      //   157	7	10	localClassCastException3	ClassCastException
      //   81	20	11	i	int
      //   87	99	12	localObject4	Object
      //   174	7	13	localClassCastException4	ClassCastException
      //   94	9	14	localCharSequence2	CharSequence
      // Exception table:
      //   from	to	target	type
      //   14	20	124	java/lang/ClassCastException
      //   51	58	140	java/lang/ClassCastException
      //   73	83	157	java/lang/ClassCastException
      //   89	96	174	java/lang/ClassCastException
    }
    
    Object lambda9$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.lambda5scanArgs(this.args, localLList);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      case 4: 
      case 6: 
      default: 
        return super.match0(paramModuleMethod, paramCallContext);
      case 7: 
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      case 5: 
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }
    
    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      case 5: 
      case 7: 
      default: 
        return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
      case 8: 
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      case 6: 
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
  }
  
  public class frame2
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn10 = new ModuleMethod(this, 10, null, -4096);
    final ModuleMethod lambda$Fn9 = new ModuleMethod(this, 9, null, 0);
    Object operands;
    Object seeds;
    srfi37.frame staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 9) {
        return lambda14();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      if (paramModuleMethod.selector == 10) {
        return lambda15$V(paramArrayOfObject);
      }
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    }
    
    Object lambda14()
    {
      return Scheme.apply.apply3(this.staticLink.operand$Mnproc, lists.car.apply1(this.operands), this.seeds);
    }
    
    Object lambda15$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.lambda4scanOperands(lists.cdr.apply1(this.operands), localLList);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 9)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 10)
      {
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      }
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    }
  }
  
  public class frame3
    extends ModuleBody
  {
    Object arg;
    Object args;
    final ModuleMethod lambda$Fn11 = new ModuleMethod(this, 17, null, 0);
    final ModuleMethod lambda$Fn12 = new ModuleMethod(this, 18, null, 4097);
    final ModuleMethod lambda$Fn19 = new ModuleMethod(this, 19, null, 0);
    final ModuleMethod lambda$Fn20 = new ModuleMethod(this, 20, null, -4096);
    final ModuleMethod lambda$Fn21 = new ModuleMethod(this, 21, null, 0);
    final ModuleMethod lambda$Fn22 = new ModuleMethod(this, 22, null, -4096);
    final ModuleMethod lambda$Fn23 = new ModuleMethod(this, 23, null, 0);
    final ModuleMethod lambda$Fn24 = new ModuleMethod(this, 24, null, -4096);
    CharSequence name;
    Object option;
    Object seeds;
    srfi37.frame staticLink;
    Object temp;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      switch (paramModuleMethod.selector)
      {
      case 18: 
      case 20: 
      case 22: 
      default: 
        return super.apply0(paramModuleMethod);
      case 17: 
        return lambda16();
      case 19: 
        return lambda24();
      case 21: 
        return lambda26();
      }
      return lambda28();
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 18) {
        return lambda17(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      switch (paramModuleMethod.selector)
      {
      case 21: 
      case 23: 
      default: 
        return super.applyN(paramModuleMethod, paramArrayOfObject);
      case 20: 
        return lambda25$V(paramArrayOfObject);
      case 22: 
        return lambda27$V(paramArrayOfObject);
      }
      return lambda29$V(paramArrayOfObject);
    }
    
    /* Error */
    CharSequence lambda16()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 96	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   4: astore_1
      //   5: aload_1
      //   6: checkcast 98	java/lang/CharSequence
      //   9: astore_3
      //   10: aload_0
      //   11: getfield 100	gnu/kawa/slib/srfi37$frame3:temp	Ljava/lang/Object;
      //   14: astore 4
      //   16: aload 4
      //   18: checkcast 102	java/lang/Number
      //   21: invokevirtual 106	java/lang/Number:intValue	()I
      //   24: istore 6
      //   26: aload_3
      //   27: iconst_2
      //   28: iload 6
      //   30: invokestatic 112	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   33: areturn
      //   34: astore_2
      //   35: new 114	gnu/mapping/WrongType
      //   38: dup
      //   39: aload_2
      //   40: ldc 115
      //   42: iconst_1
      //   43: aload_1
      //   44: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   47: athrow
      //   48: astore 5
      //   50: new 114	gnu/mapping/WrongType
      //   53: dup
      //   54: aload 5
      //   56: ldc 115
      //   58: iconst_3
      //   59: aload 4
      //   61: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   64: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	65	0	this	frame3
      //   4	40	1	localObject1	Object
      //   34	6	2	localClassCastException1	ClassCastException
      //   9	18	3	localCharSequence	CharSequence
      //   14	46	4	localObject2	Object
      //   48	7	5	localClassCastException2	ClassCastException
      //   24	5	6	i	int
      // Exception table:
      //   from	to	target	type
      //   5	10	34	java/lang/ClassCastException
      //   16	26	48	java/lang/ClassCastException
    }
    
    Object lambda17(Object paramObject)
    {
      srfi37.frame4 localframe4 = new srfi37.frame4();
      localframe4.staticLink = this;
      localframe4.x = paramObject;
      return call_with_values.callWithValues(localframe4.lambda$Fn13, localframe4.lambda$Fn14);
    }
    
    Object lambda24()
    {
      Apply localApply = Scheme.apply;
      Object[] arrayOfObject = new Object[5];
      Object localObject = this.option;
      try
      {
        option.Mntype localMntype = (option.Mntype)localObject;
        arrayOfObject[0] = srfi37.optionProcessor(localMntype);
        arrayOfObject[1] = this.option;
        arrayOfObject[2] = this.name;
        arrayOfObject[3] = lists.car.apply1(this.args);
        arrayOfObject[4] = this.seeds;
        return localApply.applyN(arrayOfObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "option-processor", 0, localObject);
      }
    }
    
    Object lambda25$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.lambda5scanArgs(lists.cdr.apply1(this.args), localLList);
    }
    
    Object lambda26()
    {
      Apply localApply = Scheme.apply;
      Object[] arrayOfObject = new Object[5];
      Object localObject = this.option;
      try
      {
        option.Mntype localMntype = (option.Mntype)localObject;
        arrayOfObject[0] = srfi37.optionProcessor(localMntype);
        arrayOfObject[1] = this.option;
        arrayOfObject[2] = this.name;
        arrayOfObject[3] = Boolean.FALSE;
        arrayOfObject[4] = this.seeds;
        return localApply.applyN(arrayOfObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "option-processor", 0, localObject);
      }
    }
    
    Object lambda27$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.lambda5scanArgs(this.args, localLList);
    }
    
    Object lambda28()
    {
      return Scheme.apply.apply3(this.staticLink.operand$Mnproc, this.arg, this.seeds);
    }
    
    Object lambda29$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.lambda5scanArgs(this.args, localLList);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      case 18: 
      case 20: 
      case 22: 
      default: 
        return super.match0(paramModuleMethod, paramCallContext);
      case 23: 
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      case 21: 
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      case 19: 
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 18)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
    
    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      case 21: 
      case 23: 
      default: 
        return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
      case 24: 
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
  }
  
  public class frame4
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn13 = new ModuleMethod(this, 15, null, 0);
    final ModuleMethod lambda$Fn14 = new ModuleMethod(this, 16, null, 4097);
    srfi37.frame3 staticLink;
    Object x;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 15) {
        return lambda18();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 16) {
        return lambda19(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    /* Error */
    CharSequence lambda18()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 48	gnu/kawa/slib/srfi37$frame4:staticLink	Lgnu/kawa/slib/srfi37$frame3;
      //   4: getfield 53	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   7: astore_1
      //   8: aload_1
      //   9: checkcast 55	java/lang/CharSequence
      //   12: astore_3
      //   13: getstatic 61	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   16: aload_0
      //   17: getfield 48	gnu/kawa/slib/srfi37$frame4:staticLink	Lgnu/kawa/slib/srfi37$frame3;
      //   20: getfield 64	gnu/kawa/slib/srfi37$frame3:temp	Ljava/lang/Object;
      //   23: getstatic 70	gnu/kawa/slib/srfi37:Lit0	Lgnu/math/IntNum;
      //   26: invokevirtual 76	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   29: astore 4
      //   31: aload 4
      //   33: checkcast 78	java/lang/Number
      //   36: invokevirtual 82	java/lang/Number:intValue	()I
      //   39: istore 6
      //   41: aload_0
      //   42: getfield 48	gnu/kawa/slib/srfi37$frame4:staticLink	Lgnu/kawa/slib/srfi37$frame3;
      //   45: getfield 53	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   48: astore 7
      //   50: aload 7
      //   52: checkcast 55	java/lang/CharSequence
      //   55: astore 9
      //   57: aload_3
      //   58: iload 6
      //   60: aload 9
      //   62: invokestatic 88	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   65: invokestatic 92	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   68: areturn
      //   69: astore_2
      //   70: new 94	gnu/mapping/WrongType
      //   73: dup
      //   74: aload_2
      //   75: ldc 95
      //   77: iconst_1
      //   78: aload_1
      //   79: invokespecial 98	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   82: athrow
      //   83: astore 5
      //   85: new 94	gnu/mapping/WrongType
      //   88: dup
      //   89: aload 5
      //   91: ldc 95
      //   93: iconst_2
      //   94: aload 4
      //   96: invokespecial 98	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   99: athrow
      //   100: astore 8
      //   102: new 94	gnu/mapping/WrongType
      //   105: dup
      //   106: aload 8
      //   108: ldc 100
      //   110: iconst_1
      //   111: aload 7
      //   113: invokespecial 98	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   116: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	117	0	this	frame4
      //   7	72	1	localObject1	Object
      //   69	6	2	localClassCastException1	ClassCastException
      //   12	46	3	localCharSequence1	CharSequence
      //   29	66	4	localObject2	Object
      //   83	7	5	localClassCastException2	ClassCastException
      //   39	20	6	i	int
      //   48	64	7	localObject3	Object
      //   100	7	8	localClassCastException3	ClassCastException
      //   55	6	9	localCharSequence2	CharSequence
      // Exception table:
      //   from	to	target	type
      //   8	13	69	java/lang/ClassCastException
      //   31	41	83	java/lang/ClassCastException
      //   50	57	100	java/lang/ClassCastException
    }
    
    Object lambda19(Object paramObject)
    {
      srfi37.frame5 localframe5 = new srfi37.frame5();
      localframe5.staticLink = this;
      localframe5.x = paramObject;
      return call_with_values.callWithValues(localframe5.lambda$Fn15, localframe5.lambda$Fn16);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 15)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 16)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame5
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn15 = new ModuleMethod(this, 13, null, 0);
    final ModuleMethod lambda$Fn16 = new ModuleMethod(this, 14, null, 4097);
    srfi37.frame4 staticLink;
    Object x;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 13) {
        return lambda20();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 14) {
        return lambda21(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda20()
    {
      Object localObject = this.staticLink.staticLink.staticLink.lambda2findOption(this.staticLink.x);
      if (localObject != Boolean.FALSE) {
        return localObject;
      }
      return srfi37.option(LList.list1(this.staticLink.x), Boolean.TRUE, Boolean.FALSE, this.staticLink.staticLink.staticLink.unrecognized$Mnoption$Mnproc);
    }
    
    Object lambda21(Object paramObject)
    {
      srfi37.frame6 localframe6 = new srfi37.frame6();
      localframe6.staticLink = this;
      localframe6.x = paramObject;
      return call_with_values.callWithValues(localframe6.lambda$Fn17, localframe6.lambda$Fn18);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 13)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 14)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame6
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn17 = new ModuleMethod(this, 11, null, 0);
    final ModuleMethod lambda$Fn18 = new ModuleMethod(this, 12, null, -4096);
    srfi37.frame5 staticLink;
    Object x;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 11) {
        return lambda22();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      if (paramModuleMethod.selector == 12) {
        return lambda23$V(paramArrayOfObject);
      }
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    }
    
    Object lambda22()
    {
      Apply localApply = Scheme.apply;
      Object[] arrayOfObject = new Object[5];
      Object localObject = this.x;
      try
      {
        option.Mntype localMntype = (option.Mntype)localObject;
        arrayOfObject[0] = srfi37.optionProcessor(localMntype);
        arrayOfObject[1] = this.x;
        arrayOfObject[2] = this.staticLink.staticLink.x;
        arrayOfObject[3] = this.staticLink.x;
        arrayOfObject[4] = this.staticLink.staticLink.staticLink.seeds;
        return localApply.applyN(arrayOfObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "option-processor", 0, localObject);
      }
    }
    
    Object lambda23$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.staticLink.staticLink.staticLink.lambda5scanArgs(this.staticLink.staticLink.staticLink.args, localLList);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 11)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 12)
      {
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      }
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.srfi37
 * JD-Core Version:    0.7.0.1
 */