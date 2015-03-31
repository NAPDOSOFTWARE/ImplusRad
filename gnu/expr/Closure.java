package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.Type;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.MethodProc;
import java.lang.reflect.Array;

class Closure
  extends MethodProc
{
  Object[][] evalFrames;
  LambdaExp lambda;
  
  public Closure(LambdaExp paramLambdaExp, CallContext paramCallContext)
  {
    this.lambda = paramLambdaExp;
    Object[][] arrayOfObject = paramCallContext.evalFrames;
    if (arrayOfObject != null)
    {
      for (int i = arrayOfObject.length; (i > 0) && (arrayOfObject[(i - 1)] == null); i--) {}
      this.evalFrames = new Object[i][];
      System.arraycopy(arrayOfObject, 0, this.evalFrames, 0, i);
    }
    setSymbol(this.lambda.getSymbol());
  }
  
  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    int i = ScopeExp.nesting(this.lambda);
    Object[] arrayOfObject = paramCallContext.values;
    Object[][] arrayOfObject1 = paramCallContext.evalFrames;
    if (this.evalFrames == null) {}
    for (int j = 0;; j = this.evalFrames.length)
    {
      if (i >= j) {
        j = i;
      }
      Object[][] arrayOfObject; = new Object[j + 10][];
      if (this.evalFrames != null) {
        System.arraycopy(this.evalFrames, 0, arrayOfObject;, 0, this.evalFrames.length);
      }
      arrayOfObject;[i] = arrayOfObject;
      paramCallContext.evalFrames = arrayOfObject;;
      try
      {
        if (this.lambda.body != null) {
          break;
        }
        StringBuffer localStringBuffer = new StringBuffer("procedure ");
        String str = this.lambda.getName();
        if (str == null) {
          str = "<anonymous>";
        }
        localStringBuffer.append(str);
        int k = this.lambda.getLineNumber();
        if (k > 0)
        {
          localStringBuffer.append(" at line ");
          localStringBuffer.append(k);
        }
        localStringBuffer.append(" was called before it was expanded");
        throw new RuntimeException(localStringBuffer.toString());
      }
      finally
      {
        paramCallContext.evalFrames = arrayOfObject1;
      }
    }
    this.lambda.body.apply(paramCallContext);
    paramCallContext.evalFrames = arrayOfObject1;
  }
  
  public Object getProperty(Object paramObject1, Object paramObject2)
  {
    Object localObject = super.getProperty(paramObject1, paramObject2);
    if (localObject == null) {
      localObject = this.lambda.getProperty(paramObject1, paramObject2);
    }
    return localObject;
  }
  
  public int match0(CallContext paramCallContext)
  {
    return matchN(new Object[0], paramCallContext);
  }
  
  public int match1(Object paramObject, CallContext paramCallContext)
  {
    return matchN(new Object[] { paramObject }, paramCallContext);
  }
  
  public int match2(Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    return matchN(new Object[] { paramObject1, paramObject2 }, paramCallContext);
  }
  
  public int match3(Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    return matchN(new Object[] { paramObject1, paramObject2, paramObject3 }, paramCallContext);
  }
  
  public int match4(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    return matchN(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }, paramCallContext);
  }
  
  public int matchN(Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    int i = numArgs();
    int j = paramArrayOfObject.length;
    int k = i & 0xFFF;
    if (j < k) {
      return 0xFFF10000 | k;
    }
    int m = i >> 12;
    if ((j > m) && (m >= 0)) {
      return 0xFFF20000 | m;
    }
    Object[] arrayOfObject1 = new Object[this.lambda.frameSize];
    int n;
    int i1;
    label91:
    int i2;
    int i3;
    Declaration localDeclaration;
    int i4;
    int i5;
    int i7;
    Object localObject1;
    int i6;
    if (this.lambda.keywords == null)
    {
      n = 0;
      if (this.lambda.defaultArgs != null) {
        break label237;
      }
      i1 = 0;
      i2 = 0;
      i3 = this.lambda.min_args;
      localDeclaration = this.lambda.firstDecl();
      i4 = 0;
      i5 = 0;
      if (localDeclaration == null) {
        break label565;
      }
      if (i5 >= i3) {
        break label253;
      }
      i7 = i5 + 1;
      localObject1 = paramArrayOfObject[i5];
      i6 = i4;
    }
    for (;;)
    {
      for (;;)
      {
        if (localDeclaration.type != null) {}
        try
        {
          Object localObject2 = localDeclaration.type.coerceFromObject(localObject1);
          localObject1 = localObject2;
          if (localDeclaration.isIndirectBinding())
          {
            Location localLocation = localDeclaration.makeIndirectLocationFor();
            localLocation.set(localObject1);
            localObject1 = localLocation;
          }
          arrayOfObject1[localDeclaration.evalIndex] = localObject1;
          localDeclaration = localDeclaration.nextDecl();
          i4 = i6;
          i5 = i7;
        }
        catch (ClassCastException localClassCastException1)
        {
          label237:
          label253:
          int i8;
          Type localType;
          Object[] arrayOfObject2;
          int i9;
          Keyword[] arrayOfKeyword;
          Keyword localKeyword;
          Special localSpecial;
          return 0xFFF40000 | i7;
        }
      }
      n = this.lambda.keywords.length;
      break;
      i1 = this.lambda.defaultArgs.length - n;
      break label91;
      if (i5 < i3 + i1)
      {
        if (i5 < j)
        {
          i7 = i5 + 1;
          localObject1 = paramArrayOfObject[i5];
        }
        for (;;)
        {
          i2++;
          i6 = i4;
          break;
          localObject1 = this.lambda.evalDefaultArg(i2, paramCallContext);
          i7 = i5;
        }
      }
      if ((this.lambda.max_args < 0) && (i5 == i3 + i1))
      {
        if ((localDeclaration.type instanceof ArrayType))
        {
          i8 = j - i5;
          localType = ((ArrayType)localDeclaration.type).getComponentType();
          if (localType == Type.objectType)
          {
            arrayOfObject2 = new Object[i8];
            System.arraycopy(paramArrayOfObject, i5, arrayOfObject2, 0, i8);
            localObject1 = arrayOfObject2;
            i6 = i4;
            i7 = i5;
            continue;
          }
          localObject1 = Array.newInstance(localType.getReflectClass(), i8);
          i9 = 0;
          while (i9 < i8)
          {
            int i10 = i5 + i9;
            try
            {
              Object localObject3 = localType.coerceFromObject(paramArrayOfObject[i10]);
              Array.set(localObject1, i9, localObject3);
              i9++;
            }
            catch (ClassCastException localClassCastException2)
            {
              return 0xFFF40000 | i5 + i9;
            }
          }
        }
        localObject1 = LList.makeList(paramArrayOfObject, i5);
        i6 = i4;
        i7 = i5;
      }
      else
      {
        arrayOfKeyword = this.lambda.keywords;
        i6 = i4 + 1;
        localKeyword = arrayOfKeyword[i4];
        localObject1 = Keyword.searchForKeyword(paramArrayOfObject, i3 + i1, localKeyword);
        localSpecial = Special.dfault;
        if (localObject1 == localSpecial) {
          localObject1 = this.lambda.evalDefaultArg(i2, paramCallContext);
        }
        i2++;
        i7 = i5;
      }
    }
    label565:
    paramCallContext.values = arrayOfObject1;
    paramCallContext.where = 0;
    paramCallContext.next = 0;
    paramCallContext.proc = this;
    return 0;
  }
  
  public int numArgs()
  {
    return this.lambda.min_args | this.lambda.max_args << 12;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.Closure
 * JD-Core Version:    0.7.0.1
 */