package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Future;
import gnu.mapping.Procedure;
import gnu.mapping.RunnableClosure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.Quantity;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.standard.sleep;

public class thread
  extends ModuleBody
{
  public static final ModuleMethod $Prvt$$Pcmake$Mnfuture;
  public static final thread $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SyntaxRules Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4 = (SimpleSymbol)new SimpleSymbol("runnable").readResolve();
  public static final Macro future;
  public static final ModuleMethod runnable;
  public static final ModuleMethod sleep;
  
  public static Future $PcMakeFuture(Procedure paramProcedure)
  {
    Future localFuture = new Future(paramProcedure);
    localFuture.start();
    return localFuture;
  }
  
  static
  {
    Lit3 = (SimpleSymbol)new SimpleSymbol("%make-future").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol = (SimpleSymbol)new SimpleSymbol("future").readResolve();
    Lit1 = localSimpleSymbol;
    arrayOfObject1[0] = localSimpleSymbol;
    SyntaxRule[] arrayOfSyntaxRule = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Lit3;
    arrayOfObject2[1] = ((SimpleSymbol)new SimpleSymbol("lambda").readResolve());
    arrayOfSyntaxRule[0] = new SyntaxRule(localSyntaxPattern, "\001", "\021\030\004\b\021\030\f\t\020\b\003", arrayOfObject2, 0);
    Lit2 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule, 1);
    Lit0 = (SimpleSymbol)new SimpleSymbol("sleep").readResolve();
    $instance = new thread();
    thread localthread = $instance;
    sleep = new ModuleMethod(localthread, 1, Lit0, 4097);
    future = Macro.make(Lit1, Lit2, $instance);
    $Prvt$$Pcmake$Mnfuture = new ModuleMethod(localthread, 2, Lit3, 4097);
    runnable = new ModuleMethod(localthread, 3, Lit4, 4097);
    $instance.run();
  }
  
  public thread()
  {
    ModuleInfo.register(this);
  }
  
  public static RunnableClosure runnable(Procedure paramProcedure)
  {
    return new RunnableClosure(paramProcedure);
  }
  
  public static void sleep(Quantity paramQuantity)
  {
    sleep.sleep(paramQuantity);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    }
    try
    {
      Quantity localQuantity = (Quantity)paramObject;
      sleep(localQuantity);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException3)
    {
      try
      {
        Procedure localProcedure2 = (Procedure)paramObject;
        return $PcMakeFuture(localProcedure2);
      }
      catch (ClassCastException localClassCastException2)
      {
        Procedure localProcedure1;
        throw new WrongType(localClassCastException2, "%make-future", 1, paramObject);
      }
      try
      {
        localProcedure1 = (Procedure)paramObject;
        return runnable(localProcedure1);
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new WrongType(localClassCastException1, "runnable", 1, paramObject);
      }
      localClassCastException3 = localClassCastException3;
      throw new WrongType(localClassCastException3, "sleep", 1, paramObject);
    }
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    int i = -786431;
    switch (paramModuleMethod.selector)
    {
    default: 
      i = super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
    do
    {
      do
      {
        do
        {
          return i;
        } while (!(paramObject instanceof Procedure));
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      } while (!(paramObject instanceof Procedure));
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    } while (!(paramObject instanceof Quantity));
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }
  
  public final void run(CallContext paramCallContext) {}
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.thread
 * JD-Core Version:    0.7.0.1
 */