package gnu.bytecode;

public class PrimType
  extends Type
{
  private static final String numberHierarchy = "A:java.lang.Byte;B:java.lang.Short;C:java.lang.Integer;D:java.lang.Long;E:gnu.math.IntNum;E:java.gnu.math.BitInteger;G:gnu.math.RatNum;H:java.lang.Float;I:java.lang.Double;I:gnu.math.DFloNum;J:gnu.math.RealNum;K:gnu.math.Complex;L:gnu.math.Quantity;K:gnu.math.Numeric;N:java.lang.Number;";
  
  protected PrimType(PrimType paramPrimType)
  {
    super(paramPrimType.this_name, paramPrimType.signature);
    this.size = paramPrimType.size;
    this.reflectClass = paramPrimType.reflectClass;
  }
  
  public PrimType(String paramString1, String paramString2, int paramInt, Class paramClass)
  {
    super(paramString1, paramString2);
    this.size = paramInt;
    this.reflectClass = paramClass;
    Type.registerTypeForClass(paramClass, this);
  }
  
  public static boolean booleanValue(Object paramObject)
  {
    return (!(paramObject instanceof Boolean)) || (((Boolean)paramObject).booleanValue());
  }
  
  public static int compare(PrimType paramPrimType1, PrimType paramPrimType2)
  {
    int i = -3;
    int j = -1;
    int k = paramPrimType1.signature.charAt(0);
    int m = paramPrimType2.signature.charAt(0);
    if (k == m) {
      j = 0;
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
              do
              {
                do
                {
                  return j;
                  if (k == 86) {
                    return 1;
                  }
                } while (m == 86);
                if ((k == 90) || (m == 90)) {
                  return i;
                }
                if (k != 67) {
                  break;
                }
              } while (paramPrimType2.size > 2);
              return i;
              if (m == 67)
              {
                if (paramPrimType1.size > 2) {
                  i = 1;
                }
                return i;
              }
              if (k == 68) {
                return 1;
              }
            } while (m == 68);
            if (k == 70) {
              return 1;
            }
          } while (m == 70);
          if (k == 74) {
            return 1;
          }
        } while (m == 74);
        if (k == 73) {
          return 1;
        }
      } while (m == 73);
      if (k == 83) {
        return 1;
      }
    } while (m == 83);
    return i;
  }
  
  private static char findInHierarchy(String paramString)
  {
    int i = -2 + "A:java.lang.Byte;B:java.lang.Short;C:java.lang.Integer;D:java.lang.Long;E:gnu.math.IntNum;E:java.gnu.math.BitInteger;G:gnu.math.RatNum;H:java.lang.Float;I:java.lang.Double;I:gnu.math.DFloNum;J:gnu.math.RealNum;K:gnu.math.Complex;L:gnu.math.Quantity;K:gnu.math.Numeric;N:java.lang.Number;".indexOf(paramString);
    if (i < 0) {
      return '\000';
    }
    return "A:java.lang.Byte;B:java.lang.Short;C:java.lang.Integer;D:java.lang.Long;E:gnu.math.IntNum;E:java.gnu.math.BitInteger;G:gnu.math.RatNum;H:java.lang.Float;I:java.lang.Double;I:gnu.math.DFloNum;J:gnu.math.RealNum;K:gnu.math.Complex;L:gnu.math.Quantity;K:gnu.math.Numeric;N:java.lang.Number;".charAt(i);
  }
  
  public ClassType boxedType()
  {
    String str;
    switch (getSignature().charAt(0))
    {
    default: 
      str = null;
    }
    for (;;)
    {
      return ClassType.make(str);
      str = "java.lang.Boolean";
      continue;
      str = "java.lang.Character";
      continue;
      str = "java.lang.Byte";
      continue;
      str = "java.lang.Short";
      continue;
      str = "java.lang.Integer";
      continue;
      str = "java.lang.Long";
      continue;
      str = "java.lang.Float";
      continue;
      str = "java.lang.Double";
    }
  }
  
  public char charValue(Object paramObject)
  {
    return ((Character)paramObject).charValue();
  }
  
  public Object coerceFromObject(Object paramObject)
  {
    if (paramObject.getClass() == this.reflectClass) {
      return paramObject;
    }
    if ((this.signature == null) || (this.signature.length() != 1)) {}
    for (int i = 32;; i = this.signature.charAt(0)) {
      switch (i)
      {
      default: 
        throw new ClassCastException("don't know how to coerce " + paramObject.getClass().getName() + " to " + getName());
      }
    }
    return Byte.valueOf(((Number)paramObject).byteValue());
    return Short.valueOf(((Number)paramObject).shortValue());
    return Integer.valueOf(((Number)paramObject).intValue());
    return Long.valueOf(((Number)paramObject).longValue());
    return Float.valueOf(((Number)paramObject).floatValue());
    return Double.valueOf(((Number)paramObject).doubleValue());
    return Boolean.valueOf(((Boolean)paramObject).booleanValue());
  }
  
  public int compare(Type paramType)
  {
    int m;
    if ((paramType instanceof PrimType))
    {
      if (paramType.getImplementationType() != paramType)
      {
        m = swappedCompareResult(paramType.compare(this));
        return m;
      }
      return compare(this, (PrimType)paramType);
    }
    if (!(paramType instanceof ClassType))
    {
      if ((paramType instanceof ArrayType)) {
        return -3;
      }
      return swappedCompareResult(paramType.compare(this));
    }
    int i = this.signature.charAt(0);
    String str = paramType.getName();
    if (str == null) {
      return -1;
    }
    int j = 0;
    switch (i)
    {
    }
    for (;;)
    {
      if (j != 0)
      {
        int k = findInHierarchy(str);
        if (k != 0)
        {
          m = 0;
          if (k == j) {
            break;
          }
          if (k < j)
          {
            return 1;
            return 1;
            boolean bool2 = str.equals("java.lang.Boolean");
            m = 0;
            if (bool2) {
              break;
            }
            boolean bool1 = str.equals("java.lang.Character");
            j = 0;
            if (!bool1) {
              continue;
            }
            return 0;
            j = 65;
            continue;
            j = 66;
            continue;
            j = 67;
            continue;
            j = 68;
            continue;
            j = 72;
            continue;
            j = 73;
            continue;
          }
          return -1;
        }
      }
    }
    if ((str.equals("java.lang.Object")) || (paramType == toStringType)) {
      return -1;
    }
    return -3;
  }
  
  public void emitCoerceFromObject(CodeAttr paramCodeAttr)
  {
    if ((this.signature == null) || (this.signature.length() != 1)) {}
    for (int i = 32; i == 90; i = this.signature.charAt(0))
    {
      paramCodeAttr.emitCheckcast(javalangBooleanType);
      paramCodeAttr.emitInvokeVirtual(booleanValue_method);
      return;
    }
    if (i == 86)
    {
      paramCodeAttr.emitPop(1);
      return;
    }
    paramCodeAttr.emitCheckcast(javalangNumberType);
    if ((i == 73) || (i == 83) || (i == 66))
    {
      paramCodeAttr.emitInvokeVirtual(intValue_method);
      return;
    }
    if (i == 74)
    {
      paramCodeAttr.emitInvokeVirtual(longValue_method);
      return;
    }
    if (i == 68)
    {
      paramCodeAttr.emitInvokeVirtual(doubleValue_method);
      return;
    }
    if (i == 70)
    {
      paramCodeAttr.emitInvokeVirtual(floatValue_method);
      return;
    }
    super.emitCoerceFromObject(paramCodeAttr);
  }
  
  public void emitCoerceToObject(CodeAttr paramCodeAttr)
  {
    int i = getSignature().charAt(0);
    ClassType localClassType = boxedType();
    if (i == 90)
    {
      paramCodeAttr.emitIfIntNotZero();
      paramCodeAttr.emitGetStatic(localClassType.getDeclaredField("TRUE"));
      paramCodeAttr.emitElse();
      paramCodeAttr.emitGetStatic(localClassType.getDeclaredField("FALSE"));
      paramCodeAttr.emitFi();
      return;
    }
    Type[] arrayOfType = { this };
    Method localMethod;
    if (paramCodeAttr.getMethod().getDeclaringClass().classfileFormatVersion >= 3211264) {
      localMethod = localClassType.getDeclaredMethod("valueOf", arrayOfType);
    }
    for (;;)
    {
      paramCodeAttr.emitInvoke(localMethod);
      return;
      localMethod = localClassType.getDeclaredMethod("<init>", arrayOfType);
      paramCodeAttr.emitNew(localClassType);
      paramCodeAttr.emitDupX();
      paramCodeAttr.emitSwap();
    }
  }
  
  public void emitIsInstance(CodeAttr paramCodeAttr)
  {
    if ((this.signature == null) || (this.signature.length() != 1)) {}
    for (int i = 32; i == 90; i = this.signature.charAt(0))
    {
      javalangBooleanType.emitIsInstance(paramCodeAttr);
      return;
    }
    if (i == 86)
    {
      paramCodeAttr.emitPop(1);
      paramCodeAttr.emitPushInt(1);
      return;
    }
    javalangNumberType.emitIsInstance(paramCodeAttr);
  }
  
  public Type promotedType()
  {
    switch (this.signature.charAt(0))
    {
    default: 
      return getImplementationType();
    }
    return Type.intType;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.PrimType
 * JD-Core Version:    0.7.0.1
 */