package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.InPort;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.text.Char;
import gnu.text.Path;
import kawa.lib.characters;
import kawa.lib.lists;
import kawa.lib.ports;
import kawa.lib.rnrs.unicode;
import kawa.standard.Scheme;
import kawa.standard.readchar;

public class ppfile
  extends ModuleBody
{
  public static final ppfile $instance;
  static final Char Lit0;
  static final Char Lit1;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3 = (SimpleSymbol)new SimpleSymbol("pprint-file").readResolve();
  static final ModuleMethod lambda$Fn3;
  public static final ModuleMethod pprint$Mnfile;
  public static final ModuleMethod pprint$Mnfilter$Mnfile;
  
  static
  {
    Lit2 = (SimpleSymbol)new SimpleSymbol("pprint-filter-file").readResolve();
    Lit1 = Char.make(10);
    Lit0 = Char.make(59);
    $instance = new ppfile();
    ppfile localppfile = $instance;
    pprint$Mnfilter$Mnfile = new ModuleMethod(localppfile, 3, Lit2, -4094);
    ModuleMethod localModuleMethod = new ModuleMethod(localppfile, 4, null, 4097);
    localModuleMethod.setProperty("source-location", "ppfile.scm:70");
    lambda$Fn3 = localModuleMethod;
    pprint$Mnfile = new ModuleMethod(localppfile, 5, Lit3, 8193);
    $instance.run();
  }
  
  public ppfile()
  {
    ModuleInfo.register(this);
  }
  
  static Object lambda3(Object paramObject)
  {
    return paramObject;
  }
  
  public static Object pprintFile(Object paramObject)
  {
    return pprintFile(paramObject, ports.current$Mnoutput$Mnport.apply0());
  }
  
  public static Object pprintFile(Object paramObject1, Object paramObject2)
  {
    return pprintFilterFile$V(paramObject1, lambda$Fn3, new Object[] { paramObject2 });
  }
  
  public static Object pprintFilterFile$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame localframe = new frame();
    localframe.filter = paramObject2;
    localframe.optarg = LList.makeList(paramArrayOfObject, 0);
    ModuleMethod localModuleMethod = localframe.lambda$Fn1;
    if (ports.isInputPort(paramObject1)) {
      return localframe.lambda1(paramObject1);
    }
    try
    {
      Path localPath = Path.valueOf(paramObject1);
      return ports.callWithInputFile(localPath, localModuleMethod);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "call-with-input-file", 1, paramObject1);
    }
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 4: 
      return lambda3(paramObject);
    }
    return pprintFile(paramObject);
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    if (paramModuleMethod.selector == 5) {
      return pprintFile(paramObject1, paramObject2);
    }
    return super.apply2(paramModuleMethod, paramObject1, paramObject2);
  }
  
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    if (paramModuleMethod.selector == 3)
    {
      Object localObject1 = paramArrayOfObject[0];
      Object localObject2 = paramArrayOfObject[1];
      int i = -2 + paramArrayOfObject.length;
      Object[] arrayOfObject = new Object[i];
      for (;;)
      {
        i--;
        if (i < 0) {
          return pprintFilterFile$V(localObject1, localObject2, arrayOfObject);
        }
        arrayOfObject[i] = paramArrayOfObject[(i + 2)];
      }
    }
    return super.applyN(paramModuleMethod, paramArrayOfObject);
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 5: 
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
    if (paramModuleMethod.selector == 5)
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 3)
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
    Object filter;
    final ModuleMethod lambda$Fn1;
    LList optarg;
    
    public frame()
    {
      this$1 = new ModuleMethod(this, 2, null, 4097);
      this$1.setProperty("source-location", "ppfile.scm:27");
      this.lambda$Fn1 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 2) {
        return lambda1(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda1(Object paramObject)
    {
      ppfile.frame0 localframe0 = new ppfile.frame0();
      localframe0.staticLink = this;
      localframe0.port = paramObject;
      ModuleMethod localModuleMethod = localframe0.lambda$Fn2;
      if (lists.isNull(this.optarg)) {}
      for (Object localObject = ports.current$Mnoutput$Mnport.apply0(); ports.isOutputPort(localObject); localObject = lists.car.apply1(this.optarg)) {
        return localframe0.lambda2(localObject);
      }
      try
      {
        Path localPath = Path.valueOf(localObject);
        return ports.callWithOutputFile(localPath, localModuleMethod);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "call-with-output-file", 1, localObject);
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 2)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame0
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn2;
    Object port;
    ppfile.frame staticLink;
    
    public frame0()
    {
      this$1 = new ModuleMethod(this, 1, null, 4097);
      this$1.setProperty("source-location", "ppfile.scm:34");
      this.lambda$Fn2 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 1) {
        return lambda2(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda2(Object paramObject)
    {
      localObject1 = readchar.peekChar.apply1(this.port);
      for (;;)
      {
        boolean bool1 = ports.isEofObject(localObject1);
        if (bool1)
        {
          if (bool1) {
            return Boolean.TRUE;
          }
          return Boolean.FALSE;
        }
        try
        {
          Char localChar1 = (Char)localObject1;
          if (unicode.isCharWhitespace(localChar1))
          {
            ports.display(readchar.readChar.apply1(this.port), paramObject);
            localObject1 = readchar.peekChar.apply1(this.port);
            continue;
          }
          Char localChar2 = ppfile.Lit0;
          try
          {
            Char localChar3 = (Char)localObject1;
            if (characters.isChar$Eq(localChar2, localChar3))
            {
              boolean bool3 = ports.isEofObject(localObject1);
              if (bool3)
              {
                if (bool3) {
                  return Boolean.TRUE;
                }
                return Boolean.FALSE;
              }
              localChar4 = ppfile.Lit1;
            }
          }
          catch (ClassCastException localClassCastException2)
          {
            Char localChar4;
            Char localChar5;
            InPort localInPort;
            Object localObject3;
            boolean bool2;
            throw new WrongType(localClassCastException2, "char=?", 2, localObject1);
          }
          try
          {
            localChar5 = (Char)localObject1;
            if (characters.isChar$Eq(localChar4, localChar5))
            {
              ports.display(readchar.readChar.apply1(this.port), paramObject);
              localObject1 = readchar.peekChar.apply1(this.port);
              continue;
            }
            ports.display(readchar.readChar.apply1(this.port), paramObject);
            localObject1 = readchar.peekChar.apply1(this.port);
          }
          catch (ClassCastException localClassCastException4)
          {
            throw new WrongType(localClassCastException4, "char=?", 2, localObject1);
          }
          localObject2 = this.port;
        }
        catch (ClassCastException localClassCastException1)
        {
          try
          {
            localInPort = (InPort)localObject2;
            localObject3 = ports.read(localInPort);
            bool2 = ports.isEofObject(localObject3);
            if (bool2)
            {
              if (bool2) {
                return Boolean.TRUE;
              }
              return Boolean.FALSE;
            }
            pp.prettyPrint(Scheme.applyToArgs.apply2(this.staticLink.filter, localObject3), paramObject);
            localObject1 = readchar.peekChar.apply1(this.port);
            if (Scheme.isEqv.apply2(ppfile.Lit1, localObject1) == Boolean.FALSE) {
              continue;
            }
            readchar.readChar.apply1(this.port);
            localObject1 = readchar.peekChar.apply1(this.port);
          }
          catch (ClassCastException localClassCastException3)
          {
            Object localObject2;
            throw new WrongType(localClassCastException3, "read", 1, localObject2);
          }
          localClassCastException1 = localClassCastException1;
          throw new WrongType(localClassCastException1, "char-whitespace?", 1, localObject1);
        }
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 1)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.ppfile
 * JD-Core Version:    0.7.0.1
 */