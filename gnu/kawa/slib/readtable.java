package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.kawa.lispexpr.ReaderDispatch;
import gnu.kawa.lispexpr.ReaderMacro;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.text.Char;

public class readtable
  extends ModuleBody
{
  public static final readtable $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6 = (SimpleSymbol)new SimpleSymbol("define-reader-ctor").readResolve();
  public static final ModuleMethod current$Mnreadtable;
  public static final ModuleMethod define$Mnreader$Mnctor;
  public static final ModuleMethod get$Mndispatch$Mnmacro$Mntable;
  public static final ModuleMethod make$Mndispatch$Mnmacro$Mncharacter;
  public static final ModuleMethod readtable$Qu;
  public static final ModuleMethod set$Mndispatch$Mnmacro$Mncharacter;
  public static final ModuleMethod set$Mnmacro$Mncharacter;
  
  static
  {
    Lit5 = (SimpleSymbol)new SimpleSymbol("get-dispatch-macro-table").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("set-dispatch-macro-character").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("make-dispatch-macro-character").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("set-macro-character").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("readtable?").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("current-readtable").readResolve();
    $instance = new readtable();
    readtable localreadtable = $instance;
    current$Mnreadtable = new ModuleMethod(localreadtable, 1, Lit0, 0);
    readtable$Qu = new ModuleMethod(localreadtable, 2, Lit1, 4097);
    set$Mnmacro$Mncharacter = new ModuleMethod(localreadtable, 3, Lit2, 16386);
    make$Mndispatch$Mnmacro$Mncharacter = new ModuleMethod(localreadtable, 6, Lit3, 12289);
    set$Mndispatch$Mnmacro$Mncharacter = new ModuleMethod(localreadtable, 9, Lit4, 16387);
    get$Mndispatch$Mnmacro$Mntable = new ModuleMethod(localreadtable, 11, Lit5, 12290);
    define$Mnreader$Mnctor = new ModuleMethod(localreadtable, 13, Lit6, 12290);
    $instance.run();
  }
  
  public readtable()
  {
    ModuleInfo.register(this);
  }
  
  public static ReadTable currentReadtable()
  {
    return ReadTable.getCurrent();
  }
  
  public static void defineReaderCtor(Symbol paramSymbol, Procedure paramProcedure)
  {
    defineReaderCtor(paramSymbol, paramProcedure, currentReadtable());
  }
  
  public static void defineReaderCtor(Symbol paramSymbol, Procedure paramProcedure, ReadTable paramReadTable)
  {
    if (paramSymbol == null) {}
    for (String str = null;; str = paramSymbol.toString())
    {
      paramReadTable.putReaderCtor(str, paramProcedure);
      return;
    }
  }
  
  public static Object getDispatchMacroTable(char paramChar1, char paramChar2)
  {
    return getDispatchMacroTable(paramChar1, paramChar2, currentReadtable());
  }
  
  public static Object getDispatchMacroTable(char paramChar1, char paramChar2, ReadTable paramReadTable)
  {
    ReadTableEntry localReadTableEntry = paramReadTable.lookup(paramChar1);
    try
    {
      ReaderDispatch localReaderDispatch = (ReaderDispatch)localReadTableEntry;
      Object localObject = localReaderDispatch.lookup(paramChar2);
      if (localObject == null) {
        localObject = Boolean.FALSE;
      }
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "disp-entry", -2, localReadTableEntry);
    }
  }
  
  public static boolean isReadtable(Object paramObject)
  {
    return paramObject instanceof ReadTable;
  }
  
  public static void makeDispatchMacroCharacter(char paramChar)
  {
    makeDispatchMacroCharacter(paramChar, false);
  }
  
  public static void makeDispatchMacroCharacter(char paramChar, boolean paramBoolean)
  {
    makeDispatchMacroCharacter(paramChar, paramBoolean, currentReadtable());
  }
  
  public static void makeDispatchMacroCharacter(char paramChar, boolean paramBoolean, ReadTable paramReadTable)
  {
    paramReadTable.set(paramChar, new ReaderDispatch(paramBoolean));
  }
  
  public static void setDispatchMacroCharacter(char paramChar1, char paramChar2, Object paramObject)
  {
    setDispatchMacroCharacter(paramChar1, paramChar2, paramObject, currentReadtable());
  }
  
  /* Error */
  public static void setDispatchMacroCharacter(char paramChar1, char paramChar2, Object paramObject, ReadTable paramReadTable)
  {
    // Byte code:
    //   0: aload_3
    //   1: iload_0
    //   2: invokevirtual 130	gnu/kawa/lispexpr/ReadTable:lookup	(I)Lgnu/kawa/lispexpr/ReadTableEntry;
    //   5: astore 4
    //   7: aload 4
    //   9: checkcast 132	gnu/kawa/lispexpr/ReaderDispatch
    //   12: astore 6
    //   14: aload_2
    //   15: checkcast 170	gnu/mapping/Procedure
    //   18: astore 8
    //   20: aload 6
    //   22: iload_1
    //   23: new 172	gnu/kawa/lispexpr/ReaderDispatchMacro
    //   26: dup
    //   27: aload 8
    //   29: invokespecial 175	gnu/kawa/lispexpr/ReaderDispatchMacro:<init>	(Lgnu/mapping/Procedure;)V
    //   32: invokevirtual 176	gnu/kawa/lispexpr/ReaderDispatch:set	(ILjava/lang/Object;)V
    //   35: return
    //   36: astore 5
    //   38: new 141	gnu/mapping/WrongType
    //   41: dup
    //   42: aload 5
    //   44: ldc 178
    //   46: bipush 254
    //   48: aload 4
    //   50: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   53: athrow
    //   54: astore 7
    //   56: new 141	gnu/mapping/WrongType
    //   59: dup
    //   60: aload 7
    //   62: ldc 180
    //   64: iconst_1
    //   65: aload_2
    //   66: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramChar1	char
    //   0	70	1	paramChar2	char
    //   0	70	2	paramObject	Object
    //   0	70	3	paramReadTable	ReadTable
    //   5	44	4	localReadTableEntry	ReadTableEntry
    //   36	7	5	localClassCastException1	ClassCastException
    //   12	9	6	localReaderDispatch	ReaderDispatch
    //   54	7	7	localClassCastException2	ClassCastException
    //   18	10	8	localProcedure	Procedure
    // Exception table:
    //   from	to	target	type
    //   7	14	36	java/lang/ClassCastException
    //   14	20	54	java/lang/ClassCastException
  }
  
  public static void setMacroCharacter(char paramChar, Object paramObject)
  {
    setMacroCharacter(paramChar, paramObject, false);
  }
  
  public static void setMacroCharacter(char paramChar, Object paramObject, boolean paramBoolean)
  {
    setMacroCharacter(paramChar, paramObject, paramBoolean, currentReadtable());
  }
  
  public static void setMacroCharacter(char paramChar, Object paramObject, boolean paramBoolean, ReadTable paramReadTable)
  {
    try
    {
      Procedure localProcedure = (Procedure)paramObject;
      paramReadTable.set(paramChar, new ReaderMacro(localProcedure, paramBoolean));
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "gnu.kawa.lispexpr.ReaderMacro.<init>(gnu.mapping.Procedure,boolean)", 1, paramObject);
    }
  }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    if (paramModuleMethod.selector == 1) {
      return currentReadtable();
    }
    return super.apply0(paramModuleMethod);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 2: 
      if (isReadtable(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    try
    {
      char c = ((Char)paramObject).charValue();
      makeDispatchMacroCharacter(c);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "make-dispatch-macro-character", 1, paramObject);
    }
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
      char c4 = ((Char)paramObject1).charValue();
      setMacroCharacter(c4, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException7)
    {
      try
      {
        c3 = ((Char)paramObject1).charValue();
      }
      catch (ClassCastException localClassCastException5)
      {
        char c3;
        Boolean localBoolean;
        boolean bool;
        label98:
        char c1;
        char c2;
        Symbol localSymbol;
        Procedure localProcedure;
        throw new WrongType(localClassCastException5, "make-dispatch-macro-character", 1, paramObject1);
      }
      try
      {
        localBoolean = Boolean.FALSE;
        if (paramObject2 != localBoolean)
        {
          bool = true;
          makeDispatchMacroCharacter(c3, bool);
          return Values.empty;
        }
        bool = false;
        break label98;
      }
      catch (ClassCastException localClassCastException6)
      {
        throw new WrongType(localClassCastException6, "make-dispatch-macro-character", 2, paramObject2);
      }
      try
      {
        c1 = ((Char)paramObject1).charValue();
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "get-dispatch-macro-table", 1, paramObject1);
      }
      try
      {
        c2 = ((Char)paramObject2).charValue();
        return getDispatchMacroTable(c1, c2);
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "get-dispatch-macro-table", 2, paramObject2);
      }
      try
      {
        localSymbol = (Symbol)paramObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "define-reader-ctor", 1, paramObject1);
      }
      try
      {
        localProcedure = (Procedure)paramObject2;
        defineReaderCtor(localSymbol, localProcedure);
        return Values.empty;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "define-reader-ctor", 2, paramObject2);
      }
      localClassCastException7 = localClassCastException7;
      throw new WrongType(localClassCastException7, "set-macro-character", 1, paramObject1);
    }
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    i = 1;
    switch (paramModuleMethod.selector)
    {
    case 4: 
    case 5: 
    case 7: 
    case 8: 
    case 10: 
    case 12: 
    default: 
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    case 3: 
    case 6: 
      for (;;)
      {
        try
        {
          c6 = ((Char)paramObject1).charValue();
        }
        catch (ClassCastException localClassCastException12)
        {
          try
          {
            char c6;
            Boolean localBoolean2;
            int k;
            char c5;
            Boolean localBoolean1;
            ReadTable localReadTable3;
            c3 = ((Char)paramObject1).charValue();
          }
          catch (ClassCastException localClassCastException7)
          {
            char c3;
            char c4;
            char c1;
            char c2;
            ReadTable localReadTable2;
            Symbol localSymbol;
            Procedure localProcedure;
            ReadTable localReadTable1;
            throw new WrongType(localClassCastException7, "set-dispatch-macro-character", i, paramObject1);
          }
          try
          {
            c4 = ((Char)paramObject2).charValue();
            setDispatchMacroCharacter(c3, c4, paramObject3);
            return Values.empty;
          }
          catch (ClassCastException localClassCastException8)
          {
            throw new WrongType(localClassCastException8, "set-dispatch-macro-character", 2, paramObject2);
          }
          try
          {
            c1 = ((Char)paramObject1).charValue();
          }
          catch (ClassCastException localClassCastException4)
          {
            throw new WrongType(localClassCastException4, "get-dispatch-macro-table", i, paramObject1);
          }
          try
          {
            c2 = ((Char)paramObject2).charValue();
          }
          catch (ClassCastException localClassCastException5)
          {
            throw new WrongType(localClassCastException5, "get-dispatch-macro-table", 2, paramObject2);
          }
          try
          {
            localReadTable2 = (ReadTable)paramObject3;
            return getDispatchMacroTable(c1, c2, localReadTable2);
          }
          catch (ClassCastException localClassCastException6)
          {
            throw new WrongType(localClassCastException6, "get-dispatch-macro-table", 3, paramObject3);
          }
          try
          {
            localSymbol = (Symbol)paramObject1;
          }
          catch (ClassCastException localClassCastException1)
          {
            throw new WrongType(localClassCastException1, "define-reader-ctor", i, paramObject1);
          }
          try
          {
            localProcedure = (Procedure)paramObject2;
          }
          catch (ClassCastException localClassCastException2)
          {
            throw new WrongType(localClassCastException2, "define-reader-ctor", 2, paramObject2);
          }
          try
          {
            localReadTable1 = (ReadTable)paramObject3;
            defineReaderCtor(localSymbol, localProcedure, localReadTable1);
            return Values.empty;
          }
          catch (ClassCastException localClassCastException3)
          {
            throw new WrongType(localClassCastException3, "define-reader-ctor", 3, paramObject3);
          }
          localClassCastException12 = localClassCastException12;
          throw new WrongType(localClassCastException12, "set-macro-character", i, paramObject1);
        }
        try
        {
          localBoolean2 = Boolean.FALSE;
          if (paramObject3 != localBoolean2)
          {
            int j = i;
            setMacroCharacter(c6, paramObject2, j);
            return Values.empty;
          }
          k = 0;
          continue;
        }
        catch (ClassCastException localClassCastException13)
        {
          throw new WrongType(localClassCastException13, "set-macro-character", 3, paramObject3);
        }
        try
        {
          c5 = ((Char)paramObject1).charValue();
        }
        catch (ClassCastException localClassCastException9)
        {
          throw new WrongType(localClassCastException9, "make-dispatch-macro-character", i, paramObject1);
        }
        try
        {
          localBoolean1 = Boolean.FALSE;
          if (paramObject2 == localBoolean1) {}
        }
        catch (ClassCastException localClassCastException10)
        {
          throw new WrongType(localClassCastException10, "make-dispatch-macro-character", 2, paramObject2);
        }
        try
        {
          localReadTable3 = (ReadTable)paramObject3;
          makeDispatchMacroCharacter(c5, i, localReadTable3);
          return Values.empty;
        }
        catch (ClassCastException localClassCastException11)
        {
          throw new WrongType(localClassCastException11, "make-dispatch-macro-character", 3, paramObject3);
        }
        i = 0;
      }
    }
  }
  
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
    case 3: 
      for (;;)
      {
        try
        {
          c3 = ((Char)paramObject1).charValue();
        }
        catch (ClassCastException localClassCastException4)
        {
          try
          {
            char c3;
            Boolean localBoolean;
            boolean bool;
            ReadTable localReadTable2;
            c1 = ((Char)paramObject1).charValue();
          }
          catch (ClassCastException localClassCastException1)
          {
            char c1;
            char c2;
            ReadTable localReadTable1;
            throw new WrongType(localClassCastException1, "set-dispatch-macro-character", 1, paramObject1);
          }
          try
          {
            c2 = ((Char)paramObject2).charValue();
          }
          catch (ClassCastException localClassCastException2)
          {
            throw new WrongType(localClassCastException2, "set-dispatch-macro-character", 2, paramObject2);
          }
          try
          {
            localReadTable1 = (ReadTable)paramObject4;
            setDispatchMacroCharacter(c1, c2, paramObject3, localReadTable1);
            return Values.empty;
          }
          catch (ClassCastException localClassCastException3)
          {
            throw new WrongType(localClassCastException3, "set-dispatch-macro-character", 4, paramObject4);
          }
          localClassCastException4 = localClassCastException4;
          throw new WrongType(localClassCastException4, "set-macro-character", 1, paramObject1);
        }
        try
        {
          localBoolean = Boolean.FALSE;
          if (paramObject3 != localBoolean) {
            bool = true;
          }
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "set-macro-character", 3, paramObject3);
        }
        try
        {
          localReadTable2 = (ReadTable)paramObject4;
          setMacroCharacter(c3, paramObject2, bool, localReadTable2);
          return Values.empty;
        }
        catch (ClassCastException localClassCastException6)
        {
          throw new WrongType(localClassCastException6, "set-macro-character", 4, paramObject4);
        }
        bool = false;
      }
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
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 6: 
      if ((paramObject instanceof Char))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
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
    default: 
      i = super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
          } while (!(paramObject1 instanceof Symbol));
          paramCallContext.value1 = paramObject1;
          if (!(paramObject2 instanceof Procedure)) {
            return -786430;
          }
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        } while (!(paramObject1 instanceof Char));
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof Char))
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
        return -786430;
      } while (!(paramObject1 instanceof Char));
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    } while (!(paramObject1 instanceof Char));
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }
  
  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    int i = -786431;
    switch (paramModuleMethod.selector)
    {
    case 4: 
    case 5: 
    case 7: 
    case 8: 
    case 10: 
    case 12: 
    default: 
      i = super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
            } while (!(paramObject1 instanceof Symbol));
            paramCallContext.value1 = paramObject1;
            if (!(paramObject2 instanceof Procedure)) {
              return -786430;
            }
            paramCallContext.value2 = paramObject2;
            if (!(paramObject3 instanceof ReadTable)) {
              return -786429;
            }
            paramCallContext.value3 = paramObject3;
            paramCallContext.proc = paramModuleMethod;
            paramCallContext.pc = 3;
            return 0;
          } while (!(paramObject1 instanceof Char));
          paramCallContext.value1 = paramObject1;
          if ((paramObject2 instanceof Char))
          {
            paramCallContext.value2 = paramObject2;
            if (!(paramObject3 instanceof ReadTable)) {
              return -786429;
            }
          }
          else
          {
            return -786430;
          }
          paramCallContext.value3 = paramObject3;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 3;
          return 0;
        } while (!(paramObject1 instanceof Char));
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof Char))
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.value3 = paramObject3;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 3;
          return 0;
        }
        return -786430;
      } while (!(paramObject1 instanceof Char));
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      if (!(paramObject3 instanceof ReadTable)) {
        return -786429;
      }
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    } while (!(paramObject1 instanceof Char));
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 3;
    return 0;
  }
  
  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    int i = -786428;
    switch (paramModuleMethod.selector)
    {
    default: 
      i = super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    }
    label120:
    do
    {
      do
      {
        return i;
        if (!(paramObject1 instanceof Char)) {
          break;
        }
        paramCallContext.value1 = paramObject1;
        if (!(paramObject2 instanceof Char)) {
          break label120;
        }
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
      } while (!(paramObject4 instanceof ReadTable));
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
      return -786431;
      return -786430;
      if (!(paramObject1 instanceof Char)) {
        break;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
    } while (!(paramObject4 instanceof ReadTable));
    paramCallContext.value4 = paramObject4;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 4;
    return 0;
    return -786431;
  }
  
  public final void run(CallContext paramCallContext) {}
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.readtable
 * JD-Core Version:    0.7.0.1
 */