package gnu.expr;

import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.WrongType;

public class GenericProc
  extends MethodProc
{
  int count;
  int maxArgs;
  protected MethodProc[] methods;
  int minArgs;
  
  public GenericProc() {}
  
  public GenericProc(String paramString)
  {
    setName(paramString);
  }
  
  public static GenericProc make(Object[] paramArrayOfObject)
  {
    GenericProc localGenericProc = new GenericProc();
    localGenericProc.setProperties(paramArrayOfObject);
    return localGenericProc;
  }
  
  public static GenericProc makeWithoutSorting(Object... paramVarArgs)
  {
    GenericProc localGenericProc = new GenericProc();
    int i = paramVarArgs.length;
    int j = 0;
    if (j < i)
    {
      Object localObject = paramVarArgs[j];
      if ((localObject instanceof Keyword))
      {
        Keyword localKeyword = (Keyword)localObject;
        j++;
        localGenericProc.setProperty(localKeyword, paramVarArgs[j]);
      }
      for (;;)
      {
        j++;
        break;
        localGenericProc.addAtEnd((MethodProc)localObject);
      }
    }
    return localGenericProc;
  }
  
  /* Error */
  public void add(MethodProc paramMethodProc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	gnu/expr/GenericProc:count	I
    //   6: istore_3
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 36	gnu/expr/GenericProc:addAtEnd	(Lgnu/mapping/MethodProc;)V
    //   12: iconst_0
    //   13: istore 4
    //   15: iload 4
    //   17: iload_3
    //   18: if_icmpge +47 -> 65
    //   21: aload_1
    //   22: aload_0
    //   23: getfield 41	gnu/expr/GenericProc:methods	[Lgnu/mapping/MethodProc;
    //   26: iload 4
    //   28: aaload
    //   29: invokestatic 45	gnu/mapping/MethodProc:mostSpecific	(Lgnu/mapping/MethodProc;Lgnu/mapping/MethodProc;)Lgnu/mapping/MethodProc;
    //   32: aload_1
    //   33: if_acmpne +35 -> 68
    //   36: aload_0
    //   37: getfield 41	gnu/expr/GenericProc:methods	[Lgnu/mapping/MethodProc;
    //   40: iload 4
    //   42: aload_0
    //   43: getfield 41	gnu/expr/GenericProc:methods	[Lgnu/mapping/MethodProc;
    //   46: iload 4
    //   48: iconst_1
    //   49: iadd
    //   50: iload_3
    //   51: iload 4
    //   53: isub
    //   54: invokestatic 51	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   57: aload_0
    //   58: getfield 41	gnu/expr/GenericProc:methods	[Lgnu/mapping/MethodProc;
    //   61: iload 4
    //   63: aload_1
    //   64: aastore
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: iinc 4 1
    //   71: goto -56 -> 15
    //   74: astore_2
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	GenericProc
    //   0	79	1	paramMethodProc	MethodProc
    //   74	4	2	localObject	Object
    //   6	48	3	i	int
    //   13	56	4	j	int
    // Exception table:
    //   from	to	target	type
    //   2	12	74	finally
    //   21	65	74	finally
  }
  
  protected void add(MethodProc[] paramArrayOfMethodProc)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        i = paramArrayOfMethodProc.length;
        if (this.methods != null) {
          break label51;
        }
        this.methods = new MethodProc[i];
      }
      finally {}
      if (j < i)
      {
        add(paramArrayOfMethodProc[j]);
        j++;
      }
      else
      {
        return;
        label51:
        j = 0;
      }
    }
  }
  
  /* Error */
  public void addAtEnd(MethodProc paramMethodProc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	gnu/expr/GenericProc:count	I
    //   6: istore_3
    //   7: aload_0
    //   8: getfield 41	gnu/expr/GenericProc:methods	[Lgnu/mapping/MethodProc;
    //   11: ifnonnull +84 -> 95
    //   14: aload_0
    //   15: bipush 8
    //   17: anewarray 4	gnu/mapping/MethodProc
    //   20: putfield 41	gnu/expr/GenericProc:methods	[Lgnu/mapping/MethodProc;
    //   23: aload_0
    //   24: getfield 41	gnu/expr/GenericProc:methods	[Lgnu/mapping/MethodProc;
    //   27: iload_3
    //   28: aload_1
    //   29: aastore
    //   30: aload_1
    //   31: invokevirtual 57	gnu/mapping/MethodProc:minArgs	()I
    //   34: istore 5
    //   36: iload 5
    //   38: aload_0
    //   39: getfield 59	gnu/expr/GenericProc:minArgs	I
    //   42: if_icmplt +10 -> 52
    //   45: aload_0
    //   46: getfield 39	gnu/expr/GenericProc:count	I
    //   49: ifne +9 -> 58
    //   52: aload_0
    //   53: iload 5
    //   55: putfield 59	gnu/expr/GenericProc:minArgs	I
    //   58: aload_1
    //   59: invokevirtual 61	gnu/mapping/MethodProc:maxArgs	()I
    //   62: istore 6
    //   64: iload 6
    //   66: iconst_m1
    //   67: if_icmpeq +12 -> 79
    //   70: iload 6
    //   72: aload_0
    //   73: getfield 63	gnu/expr/GenericProc:maxArgs	I
    //   76: if_icmple +9 -> 85
    //   79: aload_0
    //   80: iload 6
    //   82: putfield 63	gnu/expr/GenericProc:maxArgs	I
    //   85: aload_0
    //   86: iload_3
    //   87: iconst_1
    //   88: iadd
    //   89: putfield 39	gnu/expr/GenericProc:count	I
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: iload_3
    //   96: aload_0
    //   97: getfield 41	gnu/expr/GenericProc:methods	[Lgnu/mapping/MethodProc;
    //   100: arraylength
    //   101: if_icmplt -78 -> 23
    //   104: iconst_2
    //   105: aload_0
    //   106: getfield 41	gnu/expr/GenericProc:methods	[Lgnu/mapping/MethodProc;
    //   109: arraylength
    //   110: imul
    //   111: anewarray 4	gnu/mapping/MethodProc
    //   114: astore 4
    //   116: aload_0
    //   117: getfield 41	gnu/expr/GenericProc:methods	[Lgnu/mapping/MethodProc;
    //   120: iconst_0
    //   121: aload 4
    //   123: iconst_0
    //   124: iload_3
    //   125: invokestatic 51	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   128: aload_0
    //   129: aload 4
    //   131: putfield 41	gnu/expr/GenericProc:methods	[Lgnu/mapping/MethodProc;
    //   134: goto -111 -> 23
    //   137: astore_2
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_2
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	GenericProc
    //   0	142	1	paramMethodProc	MethodProc
    //   137	4	2	localObject	Object
    //   6	119	3	i	int
    //   114	16	4	arrayOfMethodProc	MethodProc[]
    //   34	20	5	j	int
    //   62	19	6	k	int
    // Exception table:
    //   from	to	target	type
    //   2	23	137	finally
    //   23	52	137	finally
    //   52	58	137	finally
    //   58	64	137	finally
    //   70	79	137	finally
    //   79	85	137	finally
    //   85	92	137	finally
    //   95	134	137	finally
  }
  
  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    if (this.count == 1) {
      return this.methods[0].applyN(paramArrayOfObject);
    }
    checkArgCount(this, paramArrayOfObject.length);
    CallContext localCallContext = CallContext.getInstance();
    for (int i = 0; i < this.count; i++) {
      if (this.methods[i].matchN(paramArrayOfObject, localCallContext) == 0) {
        return localCallContext.runUntilValue();
      }
    }
    throw new WrongType(this, -1, null);
  }
  
  public MethodProc getMethod(int paramInt)
  {
    if (paramInt >= this.count) {
      return null;
    }
    return this.methods[paramInt];
  }
  
  public int getMethodCount()
  {
    return this.count;
  }
  
  public int isApplicable(Type[] paramArrayOfType)
  {
    int i = -1;
    int j = this.count;
    for (;;)
    {
      j--;
      int k;
      if (j >= 0)
      {
        k = this.methods[j].isApplicable(paramArrayOfType);
        if (k == 1) {
          i = 1;
        }
      }
      else
      {
        return i;
      }
      if (k == 0) {
        i = 0;
      }
    }
  }
  
  public int match0(CallContext paramCallContext)
  {
    int k;
    if (this.count == 1)
    {
      k = this.methods[0].match0(paramCallContext);
      return k;
    }
    for (int i = 0;; i++)
    {
      if (i >= this.count) {
        break label57;
      }
      int j = this.methods[i].match0(paramCallContext);
      k = 0;
      if (j == 0) {
        break;
      }
    }
    label57:
    paramCallContext.proc = null;
    return -1;
  }
  
  public int match1(Object paramObject, CallContext paramCallContext)
  {
    int k;
    if (this.count == 1)
    {
      k = this.methods[0].match1(paramObject, paramCallContext);
      return k;
    }
    for (int i = 0;; i++)
    {
      if (i >= this.count) {
        break label61;
      }
      int j = this.methods[i].match1(paramObject, paramCallContext);
      k = 0;
      if (j == 0) {
        break;
      }
    }
    label61:
    paramCallContext.proc = null;
    return -1;
  }
  
  public int match2(Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    int k;
    if (this.count == 1)
    {
      k = this.methods[0].match2(paramObject1, paramObject2, paramCallContext);
      return k;
    }
    for (int i = 0;; i++)
    {
      if (i >= this.count) {
        break label66;
      }
      int j = this.methods[i].match2(paramObject1, paramObject2, paramCallContext);
      k = 0;
      if (j == 0) {
        break;
      }
    }
    label66:
    paramCallContext.proc = null;
    return -1;
  }
  
  public int match3(Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    int k;
    if (this.count == 1)
    {
      k = this.methods[0].match3(paramObject1, paramObject2, paramObject3, paramCallContext);
      return k;
    }
    for (int i = 0;; i++)
    {
      if (i >= this.count) {
        break label70;
      }
      int j = this.methods[i].match3(paramObject1, paramObject2, paramObject3, paramCallContext);
      k = 0;
      if (j == 0) {
        break;
      }
    }
    label70:
    paramCallContext.proc = null;
    return -1;
  }
  
  public int match4(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    if (this.count == 1) {
      return this.methods[0].match4(paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    }
    for (int i = 0; i < this.count; i++) {
      if (this.methods[i].match4(paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext) == 0) {
        return 0;
      }
    }
    paramCallContext.proc = null;
    return -1;
  }
  
  public int matchN(Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    if (this.count == 1) {
      return this.methods[0].matchN(paramArrayOfObject, paramCallContext);
    }
    int i = paramArrayOfObject.length;
    Type[] arrayOfType = new Type[i];
    Language localLanguage = Language.getDefaultLanguage();
    int j = 0;
    if (j < i)
    {
      Object localObject1 = paramArrayOfObject[j];
      Object localObject2;
      if (localObject1 == null) {
        localObject2 = Type.nullType;
      }
      for (;;)
      {
        arrayOfType[j] = localObject2;
        j++;
        break;
        Class localClass = localObject1.getClass();
        if (localLanguage != null) {
          localObject2 = localLanguage.getTypeFor(localClass);
        } else {
          localObject2 = Type.make(localClass);
        }
      }
    }
    int[] arrayOfInt = new int[this.count];
    int k = 0;
    int m = 0;
    int n = -1;
    int i1 = 0;
    if (i1 < this.count)
    {
      int i4 = this.methods[i1].isApplicable(arrayOfType);
      if ((k == 0) && (i4 >= 0)) {
        n = i1;
      }
      if (i4 > 0) {
        k++;
      }
      for (;;)
      {
        arrayOfInt[i1] = i4;
        i1++;
        break;
        if (i4 == 0) {
          m++;
        }
      }
    }
    if ((k == 1) || ((k == 0) && (m == 1))) {
      return this.methods[n].matchN(paramArrayOfObject, paramCallContext);
    }
    int i2 = 0;
    if (i2 < this.count)
    {
      int i3 = arrayOfInt[i2];
      if ((i3 < 0) || ((i3 == 0) && (k > 0))) {}
      while (this.methods[i2].matchN(paramArrayOfObject, paramCallContext) != 0)
      {
        i2++;
        break;
      }
      return 0;
    }
    paramCallContext.proc = null;
    return -1;
  }
  
  public int numArgs()
  {
    return this.minArgs | this.maxArgs << 12;
  }
  
  public final void setProperties(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    int j = 0;
    if (j < i)
    {
      Object localObject = paramArrayOfObject[j];
      if ((localObject instanceof Keyword))
      {
        Keyword localKeyword = (Keyword)localObject;
        j++;
        setProperty(localKeyword, paramArrayOfObject[j]);
      }
      for (;;)
      {
        j++;
        break;
        add((MethodProc)localObject);
      }
    }
  }
  
  public void setProperty(Keyword paramKeyword, Object paramObject)
  {
    String str = paramKeyword.getName();
    if (str == "name")
    {
      setName(paramObject.toString());
      return;
    }
    if (str == "method")
    {
      add((MethodProc)paramObject);
      return;
    }
    super.setProperty(paramKeyword.asSymbol(), paramObject);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.GenericProc
 * JD-Core Version:    0.7.0.1
 */