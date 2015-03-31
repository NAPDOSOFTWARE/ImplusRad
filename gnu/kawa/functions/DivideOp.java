package gnu.kawa.functions;

import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RatNum;
import gnu.math.RealNum;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class DivideOp
  extends ArithOp
{
  public static final DivideOp $Sl = new DivideOp("/", 4);
  public static final DivideOp div;
  public static final DivideOp div0;
  public static final DivideOp idiv = new DivideOp("idiv", 7);
  public static final DivideOp mod;
  public static final DivideOp mod0;
  public static final DivideOp modulo;
  public static final DivideOp quotient = new DivideOp("quotient", 6);
  public static final DivideOp remainder = new DivideOp("remainder", 8);
  int rounding_mode;
  
  static
  {
    modulo = new DivideOp("modulo", 8);
    div = new DivideOp("div", 6);
    mod = new DivideOp("mod", 8);
    div0 = new DivideOp("div0", 6);
    mod0 = new DivideOp("mod0", 8);
    idiv.rounding_mode = 3;
    quotient.rounding_mode = 3;
    remainder.rounding_mode = 3;
    modulo.rounding_mode = 1;
    div.rounding_mode = 5;
    mod.rounding_mode = 5;
    div0.rounding_mode = 4;
    mod0.rounding_mode = 4;
  }
  
  public DivideOp(String paramString, int paramInt)
  {
    super(paramString, paramInt);
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyArithOp");
    Procedure.compilerKey.set(this, "*gnu.kawa.functions.CompileArith:forDiv");
  }
  
  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    int i = paramArrayOfObject.length;
    Object localObject3;
    if (i == 0)
    {
      localObject3 = IntNum.one();
      label12:
      return localObject3;
    }
    Object localObject1 = (Number)paramArrayOfObject[0];
    if (i == 1) {
      return apply2(IntNum.one(), localObject1);
    }
    int j = Arithmetic.classifyValue(localObject1);
    int k = 1;
    if (k < i)
    {
      Object localObject2 = paramArrayOfObject[k];
      int m = Arithmetic.classifyValue(localObject2);
      if (j < m) {
        j = m;
      }
      int n = j;
      if (j < 4) {}
      switch (this.op)
      {
      default: 
        if ((this.rounding_mode == 3) && ((j == 1) || (j == 2)))
        {
          label132:
          if ((this.op != 5) || (j > 10)) {
            break label280;
          }
          n = 10;
          if ((j != 8) && (j != 7)) {
            j = 9;
          }
        }
        break;
      }
      Numeric localNumeric1;
      for (;;)
      {
        switch (n)
        {
        case 3: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          localObject3 = Arithmetic.asNumeric(localObject1);
          localNumeric1 = Arithmetic.asNumeric(localObject2);
          if ((this.op != 8) || (!localNumeric1.isZero())) {
            break label973;
          }
          if (localNumeric1.isExact()) {
            break label12;
          }
          return ((Numeric)localObject3).toInexact();
          j = 4;
          n = j;
          break label132;
          n = 4;
          break label132;
          label280:
          if ((n == 8) || (n == 7))
          {
            n = 9;
            if (this.op == 7) {
              j = n;
            }
          }
          break;
        }
      }
      int i1 = Arithmetic.asInt(localObject1);
      int i2 = Arithmetic.asInt(localObject2);
      int i3;
      switch (this.op)
      {
      default: 
        i3 = i1 / i2;
        label355:
        localObject1 = Integer.valueOf(i3);
        if (j != n) {
          switch (j)
          {
          }
        }
        break;
      }
      for (;;)
      {
        k++;
        break;
        i3 = i1 % i2;
        break label355;
        long l1 = Arithmetic.asLong(localObject1);
        long l2 = Arithmetic.asLong(localObject2);
        switch (this.op)
        {
        }
        for (long l3 = l1 / l2;; l3 = l1 % l2)
        {
          localObject1 = Long.valueOf(l3);
          break;
        }
        switch (this.op)
        {
        case 5: 
        default: 
          break;
        case 4: 
          localObject1 = RatNum.make(Arithmetic.asIntNum(localObject1), Arithmetic.asIntNum(localObject2));
          if (!(localObject1 instanceof IntNum)) {}
        case 6: 
        case 7: 
        case 8: 
          for (j = 4;; j = 6)
          {
            n = j;
            break;
            localObject1 = IntNum.quotient(Arithmetic.asIntNum(localObject1), Arithmetic.asIntNum(localObject2), getRoundingMode());
            break;
            localObject1 = IntNum.remainder(Arithmetic.asIntNum(localObject1), Arithmetic.asIntNum(localObject2), getRoundingMode());
            break;
          }
          BigDecimal localBigDecimal1 = Arithmetic.asBigDecimal(localObject1);
          BigDecimal localBigDecimal2 = Arithmetic.asBigDecimal(localObject2);
          switch (getRoundingMode())
          {
          }
          MathContext localMathContext;
          do
          {
            RoundingMode localRoundingMode = RoundingMode.HALF_EVEN;
            for (;;)
            {
              localMathContext = new MathContext(0, localRoundingMode);
              switch (this.op)
              {
              case 5: 
              default: 
                break;
              case 4: 
                localObject1 = localBigDecimal1.divide(localBigDecimal2);
                break;
                localRoundingMode = RoundingMode.FLOOR;
                continue;
                localRoundingMode = RoundingMode.CEILING;
                continue;
                localRoundingMode = RoundingMode.DOWN;
              }
            }
          } while (localBigDecimal2.signum() < 0);
          for (;;) {}
          localObject1 = localBigDecimal1.divideToIntegralValue(localBigDecimal2, localMathContext);
          break;
          localObject1 = localBigDecimal1.divideToIntegralValue(localBigDecimal2, localMathContext).toBigInteger();
          n = 3;
          j = n;
          break;
          localObject1 = localBigDecimal1.remainder(localBigDecimal2, localMathContext);
          break;
          double d1 = Arithmetic.asDouble(localObject1);
          double d2 = Arithmetic.asDouble(localObject2);
          switch (this.op)
          {
          default: 
            break;
          case 4: 
          case 5: 
            localObject1 = DFloNum.make(d1 / d2);
            break;
          case 6: 
            localObject1 = Double.valueOf(RealNum.toInt(d1 / d2, getRoundingMode()));
            break;
          case 7: 
            localObject1 = RealNum.toExactInt(d1 / d2, getRoundingMode());
            n = 4;
            j = n;
            break;
          case 8: 
            if (d2 != 0.0D) {
              d1 -= d2 * RealNum.toInt(d1 / d2, getRoundingMode());
            }
            localObject1 = DFloNum.make(d1);
            break;
            label973:
            Numeric localNumeric2 = ((Numeric)localObject3).div(localNumeric1);
            if (this.op == 8)
            {
              Numeric localNumeric3 = ((RealNum)localNumeric2).toInt(getRoundingMode()).mul(localNumeric1);
              localNumeric2 = ((Numeric)localObject3).sub(localNumeric3);
            }
            switch (this.op)
            {
            default: 
              localObject1 = localNumeric2;
              break;
            case 7: 
              localObject1 = ((RealNum)localNumeric2).toExactInt(this.rounding_mode);
              j = 4;
              n = j;
              break;
            case 6: 
              localObject1 = ((RealNum)localNumeric2).toInt(this.rounding_mode);
              break;
            case 5: 
              localObject1 = localNumeric2.toInexact();
              break;
              localObject1 = Integer.valueOf(((Number)localObject1).intValue());
              continue;
              localObject1 = Long.valueOf(((Number)localObject1).longValue());
              continue;
              localObject1 = Float.valueOf(((Number)localObject1).floatValue());
              continue;
              localObject1 = Double.valueOf(((Number)localObject1).doubleValue());
              continue;
              localObject1 = Arithmetic.asBigInteger(localObject1);
            }
            break;
          }
          break;
        }
      }
    }
    return localObject1;
  }
  
  public int getRoundingMode()
  {
    return this.rounding_mode;
  }
  
  public int numArgs()
  {
    if (this.op == 4) {
      return -4095;
    }
    return 8194;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.DivideOp
 * JD-Core Version:    0.7.0.1
 */