package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.expr.PairClassType;
import gnu.expr.PrimProcedure;
import gnu.expr.TypeValue;
import gnu.kawa.lispexpr.ClassNamespace;
import gnu.lists.FString;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import java.lang.reflect.Array;

public class Invoke
  extends ProcedureN
{
  public static final Invoke invoke = new Invoke("invoke", '*');
  public static final Invoke invokeSpecial = new Invoke("invoke-special", 'P');
  public static final Invoke invokeStatic = new Invoke("invoke-static", 'S');
  public static final Invoke make = new Invoke("make", 'N');
  char kind;
  Language language;
  
  public Invoke(String paramString, char paramChar)
  {
    this(paramString, paramChar, Language.getDefaultLanguage());
  }
  
  public Invoke(String paramString, char paramChar, Language paramLanguage)
  {
    super(paramString);
    this.kind = paramChar;
    this.language = paramLanguage;
    setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileInvoke:validateApplyInvoke");
  }
  
  public static PrimProcedure getStaticMethod(ClassType paramClassType, String paramString, Expression[] paramArrayOfExpression)
  {
    try
    {
      PrimProcedure localPrimProcedure = CompileInvoke.getStaticMethod(paramClassType, paramString, paramArrayOfExpression);
      return localPrimProcedure;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static Object invoke$V(Object[] paramArrayOfObject)
    throws Throwable
  {
    return invoke.applyN(paramArrayOfObject);
  }
  
  public static Object invokeStatic$V(Object[] paramArrayOfObject)
    throws Throwable
  {
    return invokeStatic.applyN(paramArrayOfObject);
  }
  
  public static Object make$V(Object[] paramArrayOfObject)
    throws Throwable
  {
    return make.applyN(paramArrayOfObject);
  }
  
  public static ApplyExp makeInvokeStatic(ClassType paramClassType, String paramString, Expression[] paramArrayOfExpression)
  {
    PrimProcedure localPrimProcedure;
    try
    {
      localPrimProcedure = getStaticMethod(paramClassType, paramString, paramArrayOfExpression);
      if (localPrimProcedure == null) {
        throw new RuntimeException("missing or ambiguous method `" + paramString + "' in " + paramClassType.getName());
      }
    }
    finally {}
    ApplyExp localApplyExp = new ApplyExp(localPrimProcedure, paramArrayOfExpression);
    return localApplyExp;
  }
  
  private static ObjectType typeFrom(Object paramObject, Invoke paramInvoke)
  {
    if ((paramObject instanceof Class)) {
      paramObject = Type.make((Class)paramObject);
    }
    if ((paramObject instanceof ObjectType)) {
      return (ObjectType)paramObject;
    }
    if (((paramObject instanceof String)) || ((paramObject instanceof FString))) {
      return ClassType.make(paramObject.toString());
    }
    if ((paramObject instanceof Symbol)) {
      return ClassType.make(((Symbol)paramObject).getName());
    }
    if ((paramObject instanceof ClassNamespace)) {
      return ((ClassNamespace)paramObject).getClassType();
    }
    throw new WrongType(paramInvoke, 0, paramObject, "class-specifier");
  }
  
  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Object[] arrayOfObject1 = paramCallContext.getArgs();
    if ((this.kind == 'S') || (this.kind == 'V') || (this.kind == 's') || (this.kind == '*'))
    {
      int i = arrayOfObject1.length;
      Procedure.checkArgCount(this, i);
      Object localObject1 = arrayOfObject1[0];
      Object localObject2;
      MethodProc localMethodProc;
      if ((this.kind == 'S') || (this.kind == 's'))
      {
        localObject2 = typeFrom(localObject1, this);
        localMethodProc = lookupMethods((ObjectType)localObject2, arrayOfObject1[1]);
        if (this.kind != 'S') {
          break label190;
        }
      }
      label190:
      for (int j = 2;; j = 1)
      {
        Object[] arrayOfObject2 = new Object[i - j];
        int m;
        if (this.kind != 'V')
        {
          int n = this.kind;
          m = 0;
          if (n != 42) {}
        }
        else
        {
          int k = 0 + 1;
          arrayOfObject2[0] = arrayOfObject1[0];
          m = k;
        }
        System.arraycopy(arrayOfObject1, 2, arrayOfObject2, m, i - 2);
        localMethodProc.checkN(arrayOfObject2, paramCallContext);
        return;
        localObject2 = Type.make(localObject1.getClass());
        break;
      }
    }
    paramCallContext.writeValue(applyN(arrayOfObject1));
  }
  
  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    if (this.kind == 'P') {
      throw new RuntimeException(getName() + ": invoke-special not allowed at run time");
    }
    int i = paramArrayOfObject.length;
    Procedure.checkArgCount(this, i);
    Object localObject1 = paramArrayOfObject[0];
    Object localObject2;
    if ((this.kind != 'V') && (this.kind != '*')) {
      localObject2 = typeFrom(localObject1, this);
    }
    while (this.kind == 'N')
    {
      Object localObject8;
      if ((localObject2 instanceof TypeValue))
      {
        Procedure localProcedure = ((TypeValue)localObject2).getConstructor();
        if (localProcedure != null)
        {
          int i14 = i - 1;
          Object[] arrayOfObject4 = new Object[i14];
          System.arraycopy(paramArrayOfObject, 1, arrayOfObject4, 0, i14);
          localObject8 = localProcedure.applyN(arrayOfObject4);
          return localObject8;
          localObject2 = (ObjectType)Type.make(localObject1.getClass());
          continue;
        }
      }
      if ((localObject2 instanceof PairClassType)) {
        localObject2 = ((PairClassType)localObject2).instanceType;
      }
      boolean bool = localObject2 instanceof ArrayType;
      localObject3 = null;
      if (!bool) {
        break label429;
      }
      Type localType = ((ArrayType)localObject2).getComponentType();
      int i8 = -1 + paramArrayOfObject.length;
      int i9;
      int i10;
      if ((i8 >= 2) && ((paramArrayOfObject[1] instanceof Keyword)))
      {
        String str3 = ((Keyword)paramArrayOfObject[1]).getName();
        if (("length".equals(str3)) || ("size".equals(str3)))
        {
          i9 = ((Number)paramArrayOfObject[2]).intValue();
          i10 = 3;
        }
      }
      for (int i11 = 1;; i11 = 0)
      {
        localObject8 = Array.newInstance(localType.getReflectClass(), i9);
        int i12 = 0;
        while (i10 <= i8)
        {
          Object localObject9 = paramArrayOfObject[i10];
          String str2;
          if ((i11 != 0) && ((localObject9 instanceof Keyword)) && (i10 < i8)) {
            str2 = ((Keyword)localObject9).getName();
          }
          try
          {
            int i13 = Integer.parseInt(str2);
            i12 = i13;
            i10++;
            localObject9 = paramArrayOfObject[i10];
            Object localObject10 = localType.coerceFromObject(localObject9);
            Array.set(localObject8, i12, localObject10);
            i12++;
            i10++;
          }
          catch (Throwable localThrowable)
          {
            throw new RuntimeException("non-integer keyword '" + str2 + "' in array constructor");
          }
        }
        i9 = i8;
        i10 = 1;
      }
    }
    Object localObject3 = paramArrayOfObject[1];
    label429:
    MethodProc localMethodProc1 = lookupMethods((ObjectType)localObject2, localObject3);
    if (this.kind != 'N')
    {
      if ((this.kind == 'S') || (this.kind == 's')) {}
      for (int i4 = 2;; i4 = 1)
      {
        Object[] arrayOfObject3 = new Object[i - i4];
        int i6;
        if (this.kind != 'V')
        {
          int i7 = this.kind;
          i6 = 0;
          if (i7 != 42) {}
        }
        else
        {
          int i5 = 0 + 1;
          arrayOfObject3[0] = paramArrayOfObject[0];
          i6 = i5;
        }
        System.arraycopy(paramArrayOfObject, 2, arrayOfObject3, i6, i - 2);
        return localMethodProc1.applyN(arrayOfObject3);
      }
    }
    CallContext localCallContext = CallContext.getInstance();
    for (int j = 0;; j++)
    {
      int k = paramArrayOfObject.length;
      if ((j >= k) || ((paramArrayOfObject[j] instanceof Keyword))) {
        break;
      }
    }
    int m = -1;
    int n = paramArrayOfObject.length;
    Object localObject4;
    if (j == n)
    {
      m = localMethodProc1.matchN(paramArrayOfObject, localCallContext);
      if (m == 0) {
        return localCallContext.runUntilValue();
      }
      MethodProc localMethodProc3 = ClassMethods.apply((ClassType)localObject2, "valueOf", '\000', this.language);
      if (localMethodProc3 != null)
      {
        Object[] arrayOfObject2 = new Object[i - 1];
        System.arraycopy(paramArrayOfObject, 1, arrayOfObject2, 0, i - 1);
        m = localMethodProc3.matchN(arrayOfObject2, localCallContext);
        if (m == 0) {
          return localCallContext.runUntilValue();
        }
      }
      localObject4 = localMethodProc1.apply1(paramArrayOfObject[0]);
    }
    MethodProc localMethodProc2;
    for (int i1 = j;; i1 += 2)
    {
      Object localObject6;
      if (i1 + 1 < paramArrayOfObject.length)
      {
        localObject6 = paramArrayOfObject[i1];
        if ((localObject6 instanceof Keyword)) {}
      }
      else
      {
        int i2 = paramArrayOfObject.length;
        if (j == i2) {
          i1 = 1;
        }
        if (i1 == paramArrayOfObject.length) {
          break label872;
        }
        localMethodProc2 = ClassMethods.apply((ClassType)localObject2, "add", '\000', this.language);
        if (localMethodProc2 != null) {
          break label836;
        }
        throw MethodProc.matchFailAsException(m, localMethodProc1, paramArrayOfObject);
        Object[] arrayOfObject1 = new Object[j];
        System.arraycopy(paramArrayOfObject, 0, arrayOfObject1, 0, j);
        localObject4 = localMethodProc1.applyN(arrayOfObject1);
        break;
      }
      Keyword localKeyword = (Keyword)localObject6;
      Object localObject7 = paramArrayOfObject[(i1 + 1)];
      String str1 = localKeyword.getName();
      SlotSet.apply(false, localObject4, str1, localObject7);
    }
    label836:
    while (i1 < paramArrayOfObject.length)
    {
      int i3 = i1 + 1;
      Object localObject5 = paramArrayOfObject[i1];
      localMethodProc2.apply2(localObject4, localObject5);
      i1 = i3;
    }
    label872:
    return localObject4;
  }
  
  protected MethodProc lookupMethods(ObjectType paramObjectType, Object paramObject)
  {
    char c = 'P';
    String str2;
    if (this.kind == 'N')
    {
      str2 = "<init>";
      if (this.kind != c) {
        break label152;
      }
    }
    MethodProc localMethodProc;
    for (;;)
    {
      localMethodProc = ClassMethods.apply(paramObjectType, str2, c, this.language);
      if (localMethodProc != null) {
        break label181;
      }
      throw new RuntimeException(getName() + ": no method named `" + str2 + "' in class " + paramObjectType.getName());
      if (((paramObject instanceof String)) || ((paramObject instanceof FString))) {}
      for (String str1 = paramObject.toString();; str1 = ((Symbol)paramObject).getName())
      {
        str2 = Compilation.mangleName(str1);
        break;
        if (!(paramObject instanceof Symbol)) {
          break label141;
        }
      }
      label141:
      throw new WrongType(this, 1, null);
      label152:
      if ((this.kind == '*') || (this.kind == 'V')) {
        c = 'V';
      } else {
        c = '\000';
      }
    }
    label181:
    return localMethodProc;
  }
  
  public int numArgs()
  {
    if (this.kind == 'N') {}
    for (int i = 1;; i = 2) {
      return i | 0xFFFFF000;
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.Invoke
 * JD-Core Version:    0.7.0.1
 */