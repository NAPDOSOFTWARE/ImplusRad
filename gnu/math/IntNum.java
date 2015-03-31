package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class IntNum
  extends RatNum
  implements Externalizable
{
  static final int maxFixNum = 1024;
  static final int minFixNum = -100;
  static final int numFixNum = 1125;
  static final IntNum[] smallFixNums = new IntNum[1125];
  public int ival;
  public int[] words;
  
  static
  {
    int i = 1125;
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      smallFixNums[i] = new IntNum(i - 100);
    }
  }
  
  public IntNum() {}
  
  public IntNum(int paramInt)
  {
    this.ival = paramInt;
  }
  
  public static IntNum abs(IntNum paramIntNum)
  {
    if (paramIntNum.isNegative()) {
      paramIntNum = neg(paramIntNum);
    }
    return paramIntNum;
  }
  
  public static final IntNum add(int paramInt1, int paramInt2)
  {
    return make(paramInt1 + paramInt2);
  }
  
  public static IntNum add(IntNum paramIntNum, int paramInt)
  {
    if (paramIntNum.words == null) {
      return add(paramIntNum.ival, paramInt);
    }
    IntNum localIntNum = new IntNum(0);
    localIntNum.setAdd(paramIntNum, paramInt);
    return localIntNum.canonicalize();
  }
  
  public static IntNum add(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return add(paramIntNum1, paramIntNum2, 1);
  }
  
  public static IntNum add(IntNum paramIntNum1, IntNum paramIntNum2, int paramInt)
  {
    if ((paramIntNum1.words == null) && (paramIntNum2.words == null)) {
      return make(paramInt * paramIntNum2.ival + paramIntNum1.ival);
    }
    if (paramInt != 1) {
      if (paramInt != -1) {
        break label63;
      }
    }
    label63:
    for (paramIntNum2 = neg(paramIntNum2); paramIntNum1.words == null; paramIntNum2 = times(paramIntNum2, make(paramInt))) {
      return add(paramIntNum2, paramIntNum1.ival);
    }
    if (paramIntNum2.words == null) {
      return add(paramIntNum1, paramIntNum2.ival);
    }
    if (paramIntNum2.ival > paramIntNum1.ival)
    {
      IntNum localIntNum2 = paramIntNum1;
      paramIntNum1 = paramIntNum2;
      paramIntNum2 = localIntNum2;
    }
    IntNum localIntNum1 = alloc(1 + paramIntNum1.ival);
    int i = paramIntNum2.ival;
    long l1 = MPN.add_n(localIntNum1.words, paramIntNum1.words, paramIntNum2.words, i);
    long l2;
    if (paramIntNum2.words[(i - 1)] < 0) {
      l2 = 4294967295L;
    }
    while (i < paramIntNum1.ival)
    {
      long l3 = l1 + (l2 + (0xFFFFFFFF & paramIntNum1.words[i]));
      localIntNum1.words[i] = ((int)l3);
      l1 = l3 >>> 32;
      i++;
      continue;
      l2 = 0L;
    }
    if (paramIntNum1.words[(i - 1)] < 0) {
      l2 -= 1L;
    }
    localIntNum1.words[i] = ((int)(l1 + l2));
    localIntNum1.ival = (i + 1);
    return localIntNum1.canonicalize();
  }
  
  public static IntNum alloc(int paramInt)
  {
    if (paramInt <= 1) {
      return new IntNum();
    }
    IntNum localIntNum = new IntNum();
    localIntNum.words = new int[paramInt];
    return localIntNum;
  }
  
  public static IntNum asIntNumOrNull(Object paramObject)
  {
    if ((paramObject instanceof IntNum)) {
      return (IntNum)paramObject;
    }
    if ((paramObject instanceof BigInteger)) {
      return valueOf(paramObject.toString(), 10);
    }
    if (((paramObject instanceof Number)) && (((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte)))) {
      return make(((Number)paramObject).longValue());
    }
    return null;
  }
  
  public static int compare(IntNum paramIntNum, long paramLong)
  {
    long l;
    if (paramIntNum.words == null)
    {
      l = paramIntNum.ival;
      if (l >= paramLong) {}
    }
    else
    {
      boolean bool1;
      label55:
      label92:
      do
      {
        return -1;
        bool1 = paramIntNum.isNegative();
        if (paramLong < 0L) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          if (bool1 == bool2) {
            break label55;
          }
          if (bool1) {
            break;
          }
          return 1;
        }
        if (paramIntNum.words == null) {}
        for (int i = 1;; i = paramIntNum.ival)
        {
          if (i != 1) {
            break label92;
          }
          l = paramIntNum.words[0];
          break;
        }
        if (i == 2)
        {
          l = paramIntNum.longValue();
          break;
        }
      } while (bool1);
      return 1;
    }
    if (l > paramLong) {
      return 1;
    }
    return 0;
  }
  
  public static int compare(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    int i = 1;
    if ((paramIntNum1.words == null) && (paramIntNum2.words == null)) {
      if (paramIntNum1.ival >= paramIntNum2.ival) {}
    }
    boolean bool1;
    do
    {
      return -1;
      if (paramIntNum1.ival > paramIntNum2.ival) {
        return i;
      }
      return 0;
      bool1 = paramIntNum1.isNegative();
      if (bool1 == paramIntNum2.isNegative()) {
        break;
      }
    } while (bool1);
    return i;
    int j;
    int k;
    if (paramIntNum1.words == null)
    {
      j = i;
      if (paramIntNum2.words != null) {
        break label120;
      }
      k = i;
      label83:
      if (j == k) {
        break label134;
      }
      boolean bool2 = false;
      if (j > k) {
        bool2 = i;
      }
      if (bool2 == bool1) {
        break label129;
      }
    }
    for (;;)
    {
      return i;
      j = paramIntNum1.ival;
      break;
      label120:
      k = paramIntNum2.ival;
      break label83;
      label129:
      i = -1;
    }
    label134:
    return MPN.cmp(paramIntNum1.words, paramIntNum2.words, j);
  }
  
  public static void divide(long paramLong1, long paramLong2, IntNum paramIntNum1, IntNum paramIntNum2, int paramInt)
  {
    if (paramInt == 5)
    {
      if (paramLong2 < 0L) {
        paramInt = 2;
      }
    }
    else
    {
      if (paramLong1 >= 0L) {
        break label105;
      }
      i = 1;
      if (paramLong1 != -9223372036854775808L) {
        break label56;
      }
      divide(make(paramLong1), make(paramLong2), paramIntNum1, paramIntNum2, paramInt);
    }
    label56:
    int j;
    label105:
    label111:
    long l1;
    label129:
    long l2;
    int k;
    int m;
    do
    {
      return;
      paramInt = 1;
      break;
      paramLong1 = -paramLong1;
      for (;;)
      {
        if (paramLong2 >= 0L) {
          break label275;
        }
        j = 1;
        if (paramLong2 != -9223372036854775808L) {
          break label129;
        }
        if (paramInt != 3) {
          break label111;
        }
        if (paramIntNum1 != null) {
          paramIntNum1.set(0);
        }
        if (paramIntNum2 == null) {
          break;
        }
        paramIntNum2.set(paramLong1);
        return;
        i = 0;
      }
      divide(make(paramLong1), make(paramLong2), paramIntNum1, paramIntNum2, paramInt);
      return;
      paramLong2 = -paramLong2;
      l1 = paramLong1 / paramLong2;
      l2 = paramLong1 % paramLong2;
      k = i ^ j;
      boolean bool = l2 < 0L;
      m = 0;
      if (bool) {
        m = 0;
      }
      switch (paramInt)
      {
      case 3: 
      default: 
        if (paramIntNum1 != null)
        {
          if (m != 0) {
            l1 += 1L;
          }
          if (k != 0) {
            l1 = -l1;
          }
          paramIntNum1.set(l1);
        }
        break;
      }
    } while (paramIntNum2 == null);
    if (m != 0)
    {
      l2 = paramLong2 - l2;
      if (i != 0) {
        break label338;
      }
    }
    label275:
    label338:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        l2 = -l2;
      }
      paramIntNum2.set(l2);
      return;
      j = 0;
      break;
      if (paramInt == 1) {}
      for (int n = 1;; n = 0)
      {
        m = 0;
        if (k != n) {
          break;
        }
        m = 1;
        break;
      }
      if (l2 > paramLong2 - (1L & l1) >> 1) {}
      for (m = 1;; m = 0) {
        break;
      }
    }
  }
  
  public static void divide(IntNum paramIntNum1, IntNum paramIntNum2, IntNum paramIntNum3, IntNum paramIntNum4, int paramInt)
  {
    if (((paramIntNum1.words == null) || (paramIntNum1.ival <= 2)) && ((paramIntNum2.words == null) || (paramIntNum2.ival <= 2)))
    {
      long l1 = paramIntNum1.longValue();
      long l2 = paramIntNum2.longValue();
      if ((l1 != -9223372036854775808L) && (l2 != -9223372036854775808L))
      {
        divide(l1, l2, paramIntNum3, paramIntNum4, paramInt);
        return;
      }
    }
    boolean bool1 = paramIntNum1.isNegative();
    boolean bool2 = paramIntNum2.isNegative();
    int i = bool1 ^ bool2;
    if (paramIntNum2.words == null) {}
    Object localObject1;
    for (int j = 1;; j = paramIntNum2.ival)
    {
      localObject1 = new int[j];
      paramIntNum2.getAbsolute((int[])localObject1);
      while ((j > 1) && (localObject1[(j - 1)] == 0)) {
        j--;
      }
    }
    if (paramIntNum1.words == null) {}
    Object localObject2;
    int m;
    for (int k = 1;; k = paramIntNum1.ival)
    {
      localObject2 = new int[k + 2];
      paramIntNum1.getAbsolute((int[])localObject2);
      for (m = k; (m > 1) && (localObject2[(m - 1)] == 0); m--) {}
    }
    int n = MPN.cmp((int[])localObject2, m, (int[])localObject1, j);
    int i3;
    int i4;
    if (n < 0)
    {
      Object localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      i3 = m;
      i4 = 1;
      localObject2[0] = 0;
    }
    label248:
    int i1;
    int i2;
    while ((i3 > 1) && (localObject1[(i3 - 1)] == 0))
    {
      i3--;
      continue;
      if (n == 0)
      {
        localObject2[0] = 1;
        i4 = 1;
        localObject1[0] = 0;
        i3 = 1;
      }
      else if (j == 1)
      {
        i4 = m;
        i3 = 1;
        int i14 = localObject1[0];
        localObject1[0] = MPN.divmod_1((int[])localObject2, (int[])localObject2, m, i14);
      }
      else
      {
        i1 = MPN.count_leading_zeros(localObject1[(j - 1)]);
        if (i1 != 0)
        {
          MPN.lshift((int[])localObject1, 0, (int[])localObject1, j, i1);
          int i12 = MPN.lshift((int[])localObject2, 0, (int[])localObject2, m, i1);
          int i13 = m + 1;
          localObject2[m] = i12;
          m = i13;
        }
        if (m != j) {
          break label893;
        }
        i2 = m + 1;
        localObject2[m] = 0;
      }
    }
    for (;;)
    {
      MPN.divide((int[])localObject2, i2, (int[])localObject1, j);
      i3 = j;
      MPN.rshift0((int[])localObject1, (int[])localObject2, 0, i3, i1);
      i4 = i2 + 1 - j;
      if (paramIntNum3 == null) {
        break label248;
      }
      for (int i5 = 0; i5 < i4; i5++) {
        localObject2[i5] = localObject2[(i5 + j)];
      }
      break label248;
      if (localObject1[(i3 - 1)] < 0)
      {
        localObject1[i3] = 0;
        i3++;
      }
      int i6;
      if (i3 <= 1)
      {
        int i11 = localObject1[0];
        i6 = 0;
        if (i11 == 0) {}
      }
      else
      {
        if (paramInt == 5)
        {
          if (!bool2) {
            break label683;
          }
          paramInt = 2;
        }
        i6 = 0;
      }
      label621:
      IntNum localIntNum3;
      switch (paramInt)
      {
      case 3: 
      default: 
        if (paramIntNum3 != null)
        {
          if (localObject2[(i4 - 1)] < 0)
          {
            localObject2[i4] = 0;
            i4++;
          }
          paramIntNum3.set((int[])localObject2, i4);
          if (i == 0) {
            break label823;
          }
          if (i6 != 0) {
            paramIntNum3.setInvert();
          }
        }
        else
        {
          if (paramIntNum4 == null) {
            break;
          }
          paramIntNum4.set((int[])localObject1, i3);
          if (i6 == 0) {
            break label883;
          }
          if (paramIntNum2.words != null) {
            break label850;
          }
          localIntNum3 = paramIntNum4;
          if (!bool2) {
            break label836;
          }
        }
        break;
      }
      label683:
      label823:
      label836:
      for (int i9 = localObject1[0] + paramIntNum2.ival;; i9 = localObject1[0] - paramIntNum2.ival)
      {
        localIntNum3.set(i9);
        if (!bool1) {
          break label876;
        }
        paramIntNum4.setNegative(localIntNum3);
        return;
        paramInt = 1;
        break;
        if (paramInt == 1) {}
        for (int i10 = 1;; i10 = 0)
        {
          i6 = 0;
          if (i != i10) {
            break;
          }
          i6 = 1;
          break;
        }
        IntNum localIntNum1;
        if (paramIntNum4 == null)
        {
          localIntNum1 = new IntNum();
          label733:
          localIntNum1.set((int[])localObject1, i3);
          IntNum localIntNum2 = shift(localIntNum1, 1);
          if (bool2) {
            localIntNum2.setNegative();
          }
          int i7 = compare(localIntNum2, paramIntNum2);
          if (bool2) {
            i7 = -i7;
          }
          if ((i7 != 1) && ((i7 != 0) || ((0x1 & localObject2[0]) == 0))) {
            break label810;
          }
        }
        for (i6 = 1;; i6 = 0)
        {
          break;
          localIntNum1 = paramIntNum4;
          break label733;
        }
        paramIntNum3.setNegative();
        break label621;
        if (i6 == 0) {
          break label621;
        }
        paramIntNum3.setAdd(1);
        break label621;
      }
      label810:
      label850:
      if (bool2) {}
      for (int i8 = 1;; i8 = -1)
      {
        localIntNum3 = add(paramIntNum4, paramIntNum2, i8);
        break;
      }
      label876:
      paramIntNum4.set(localIntNum3);
      return;
      label883:
      if (!bool1) {
        break;
      }
      paramIntNum4.setNegative();
      return;
      label893:
      i2 = m;
    }
  }
  
  public static boolean equals(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    if ((paramIntNum1.words == null) && (paramIntNum2.words == null)) {
      if (paramIntNum1.ival != paramIntNum2.ival) {}
    }
    int i;
    do
    {
      do
      {
        return true;
        return false;
        if ((paramIntNum1.words == null) || (paramIntNum2.words == null) || (paramIntNum1.ival != paramIntNum2.ival)) {
          return false;
        }
        i = paramIntNum1.ival;
        i--;
      } while (i < 0);
    } while (paramIntNum1.words[i] == paramIntNum2.words[i]);
    return false;
  }
  
  public static final int gcd(int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1)
    {
      int j = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = j;
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        return paramInt1;
      }
      if (paramInt2 == 1) {
        return paramInt2;
      }
      int i = paramInt2;
      paramInt2 = paramInt1 % paramInt2;
      paramInt1 = i;
    }
  }
  
  public static IntNum gcd(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    int i = paramIntNum1.ival;
    int j = paramIntNum2.ival;
    if (paramIntNum1.words == null)
    {
      if (i == 0) {
        return abs(paramIntNum2);
      }
      if ((paramIntNum2.words == null) && (i != -2147483648) && (j != -2147483648))
      {
        if (i < 0) {
          i = -i;
        }
        if (j < 0) {
          j = -j;
        }
        return make(gcd(i, j));
      }
      i = 1;
    }
    if (paramIntNum2.words == null)
    {
      if (j == 0) {
        return abs(paramIntNum1);
      }
      j = 1;
    }
    if (i > j) {}
    for (int k = i;; k = j)
    {
      int[] arrayOfInt1 = new int[k];
      int[] arrayOfInt2 = new int[k];
      paramIntNum1.getAbsolute(arrayOfInt1);
      paramIntNum2.getAbsolute(arrayOfInt2);
      int m = MPN.gcd(arrayOfInt1, arrayOfInt2, k);
      IntNum localIntNum = new IntNum(0);
      if (arrayOfInt1[(m - 1)] < 0)
      {
        int n = m + 1;
        arrayOfInt1[m] = 0;
        m = n;
      }
      localIntNum.ival = m;
      localIntNum.words = arrayOfInt1;
      return localIntNum.canonicalize();
    }
  }
  
  public static int intValue(Object paramObject)
  {
    IntNum localIntNum = (IntNum)paramObject;
    if (localIntNum.words != null) {
      throw new ClassCastException("integer too large");
    }
    return localIntNum.ival;
  }
  
  public static IntNum lcm(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    if ((paramIntNum1.isZero()) || (paramIntNum2.isZero())) {
      return zero();
    }
    IntNum localIntNum1 = abs(paramIntNum1);
    IntNum localIntNum2 = abs(paramIntNum2);
    IntNum localIntNum3 = new IntNum();
    divide(times(localIntNum1, localIntNum2), gcd(localIntNum1, localIntNum2), localIntNum3, null, 3);
    return localIntNum3.canonicalize();
  }
  
  public static IntNum make(int paramInt)
  {
    if ((paramInt >= -100) && (paramInt <= 1024)) {
      return smallFixNums[(paramInt + 100)];
    }
    return new IntNum(paramInt);
  }
  
  public static IntNum make(long paramLong)
  {
    if ((paramLong >= -100L) && (paramLong <= 1024L)) {
      return smallFixNums[(100 + (int)paramLong)];
    }
    int i = (int)paramLong;
    if (i == paramLong) {
      return new IntNum(i);
    }
    IntNum localIntNum = alloc(2);
    localIntNum.ival = 2;
    localIntNum.words[0] = i;
    localIntNum.words[1] = ((int)(paramLong >> 32));
    return localIntNum;
  }
  
  public static IntNum make(int[] paramArrayOfInt)
  {
    return make(paramArrayOfInt, paramArrayOfInt.length);
  }
  
  public static IntNum make(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return make(paramInt);
    }
    int i = wordsNeeded(paramArrayOfInt, paramInt);
    if (i <= 1)
    {
      if (i == 0) {
        return zero();
      }
      return make(paramArrayOfInt[0]);
    }
    IntNum localIntNum = new IntNum();
    localIntNum.words = paramArrayOfInt;
    localIntNum.ival = i;
    return localIntNum;
  }
  
  public static IntNum makeU(long paramLong)
  {
    if (paramLong >= 0L) {
      return make(paramLong);
    }
    IntNum localIntNum = alloc(3);
    localIntNum.ival = 3;
    localIntNum.words[0] = ((int)paramLong);
    localIntNum.words[1] = ((int)(paramLong >> 32));
    localIntNum.words[2] = 0;
    return localIntNum;
  }
  
  public static IntNum minusOne()
  {
    return smallFixNums[99];
  }
  
  public static IntNum modulo(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return remainder(paramIntNum1, paramIntNum2, 1);
  }
  
  public static IntNum neg(IntNum paramIntNum)
  {
    if ((paramIntNum.words == null) && (paramIntNum.ival != -2147483648)) {
      return make(-paramIntNum.ival);
    }
    IntNum localIntNum = new IntNum(0);
    localIntNum.setNegative(paramIntNum);
    return localIntNum.canonicalize();
  }
  
  public static boolean negate(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    long l1 = 1L;
    if (paramArrayOfInt2[(paramInt - 1)] < 0) {}
    for (int i = 1;; i = 0) {
      for (int j = 0; j < paramInt; j++)
      {
        long l2 = l1 + (0xFFFFFFFF & (0xFFFFFFFF ^ paramArrayOfInt2[j]));
        paramArrayOfInt1[j] = ((int)l2);
        l1 = l2 >> 32;
      }
    }
    return (i != 0) && (paramArrayOfInt1[(paramInt - 1)] < 0);
  }
  
  public static final IntNum one()
  {
    return smallFixNums[101];
  }
  
  public static IntNum power(IntNum paramIntNum, int paramInt)
  {
    if (paramInt <= 0) {
      if (paramInt == 0) {
        paramIntNum = one();
      }
    }
    while (paramIntNum.isZero())
    {
      return paramIntNum;
      throw new Error("negative exponent");
    }
    int i;
    int k;
    label69:
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int m;
    if (paramIntNum.words == null)
    {
      i = 1;
      int j = (paramInt * paramIntNum.intLength() >> 5) + i * 2;
      if ((!paramIntNum.isNegative()) || ((paramInt & 0x1) == 0)) {
        break label158;
      }
      k = 1;
      localObject1 = new int[j];
      localObject2 = new int[j];
      localObject3 = new int[j];
      paramIntNum.getAbsolute((int[])localObject1);
      m = 1;
      localObject2[0] = 1;
    }
    for (;;)
    {
      if ((paramInt & 0x1) != 0)
      {
        MPN.mul((int[])localObject3, (int[])localObject1, i, (int[])localObject2, m);
        Object localObject5 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject5;
        m += i;
        for (;;)
        {
          if (localObject2[(m - 1)] == 0)
          {
            m--;
            continue;
            i = paramIntNum.ival;
            break;
            label158:
            k = 0;
            break label69;
          }
        }
      }
      paramInt >>= 1;
      if (paramInt == 0)
      {
        if (localObject2[(m - 1)] < 0) {
          m++;
        }
        if (k != 0) {
          negate((int[])localObject2, (int[])localObject2, m);
        }
        return make((int[])localObject2, m);
      }
      MPN.mul((int[])localObject3, (int[])localObject1, i, (int[])localObject1, i);
      Object localObject4 = localObject3;
      localObject3 = localObject1;
      localObject1 = localObject4;
      i *= 2;
      while (localObject1[(i - 1)] == 0) {
        i--;
      }
    }
  }
  
  public static IntNum quotient(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return quotient(paramIntNum1, paramIntNum2, 3);
  }
  
  public static IntNum quotient(IntNum paramIntNum1, IntNum paramIntNum2, int paramInt)
  {
    IntNum localIntNum = new IntNum();
    divide(paramIntNum1, paramIntNum2, localIntNum, null, paramInt);
    return localIntNum.canonicalize();
  }
  
  public static IntNum remainder(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return remainder(paramIntNum1, paramIntNum2, 3);
  }
  
  public static IntNum remainder(IntNum paramIntNum1, IntNum paramIntNum2, int paramInt)
  {
    if (paramIntNum2.isZero()) {
      return paramIntNum1;
    }
    IntNum localIntNum = new IntNum();
    divide(paramIntNum1, paramIntNum2, null, localIntNum, paramInt);
    return localIntNum.canonicalize();
  }
  
  public static int shift(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 32) {}
    int i;
    do
    {
      return 0;
      if (paramInt2 >= 0) {
        return paramInt1 << paramInt2;
      }
      i = -paramInt2;
      if (i < 32) {
        break;
      }
    } while (paramInt1 >= 0);
    return -1;
    return paramInt1 >> i;
  }
  
  public static long shift(long paramLong, int paramInt)
  {
    if (paramInt >= 32) {}
    int i;
    do
    {
      return 0L;
      if (paramInt >= 0) {
        return paramLong << paramInt;
      }
      i = -paramInt;
      if (i < 32) {
        break;
      }
    } while (paramLong >= 0L);
    return -1L;
    return paramLong >> i;
  }
  
  public static IntNum shift(IntNum paramIntNum, int paramInt)
  {
    if (paramIntNum.words == null) {
      if (paramInt <= 0) {
        if (paramInt > -32)
        {
          j = paramIntNum.ival >> -paramInt;
          paramIntNum = make(j);
        }
      }
    }
    while (paramInt == 0)
    {
      for (;;)
      {
        return paramIntNum;
        int i = paramIntNum.ival;
        int j = 0;
        if (i < 0) {
          j = -1;
        }
      }
      if (paramInt < 32) {
        return make(paramIntNum.ival << paramInt);
      }
    }
    IntNum localIntNum = new IntNum(0);
    localIntNum.setShift(paramIntNum, paramInt);
    return localIntNum.canonicalize();
  }
  
  public static IntNum sub(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return add(paramIntNum1, paramIntNum2, -1);
  }
  
  public static final IntNum ten()
  {
    return smallFixNums[110];
  }
  
  public static final IntNum times(int paramInt1, int paramInt2)
  {
    return make(paramInt1 * paramInt2);
  }
  
  public static final IntNum times(IntNum paramIntNum, int paramInt)
  {
    if (paramInt == 0) {
      paramIntNum = zero();
    }
    while (paramInt == 1) {
      return paramIntNum;
    }
    int[] arrayOfInt = paramIntNum.words;
    int i = paramIntNum.ival;
    if (arrayOfInt == null) {
      return make(i * paramInt);
    }
    IntNum localIntNum = alloc(i + 1);
    if (arrayOfInt[(i - 1)] < 0)
    {
      j = 1;
      negate(localIntNum.words, arrayOfInt, i);
      arrayOfInt = localIntNum.words;
      if (paramInt < 0) {
        if (j != 0) {
          break label137;
        }
      }
    }
    label137:
    for (int j = 1;; j = 0)
    {
      paramInt = -paramInt;
      localIntNum.words[i] = MPN.mul_1(localIntNum.words, arrayOfInt, i, paramInt);
      localIntNum.ival = (i + 1);
      if (j != 0) {
        localIntNum.setNegative();
      }
      return localIntNum.canonicalize();
      j = 0;
      break;
    }
  }
  
  public static final IntNum times(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    if (paramIntNum2.words == null) {
      return times(paramIntNum1, paramIntNum2.ival);
    }
    if (paramIntNum1.words == null) {
      return times(paramIntNum2, paramIntNum1.ival);
    }
    int i = paramIntNum1.ival;
    int j = paramIntNum2.ival;
    int k;
    Object localObject1;
    label83:
    Object localObject2;
    if (paramIntNum1.isNegative())
    {
      k = 1;
      localObject1 = new int[i];
      negate((int[])localObject1, paramIntNum1.words, i);
      if (!paramIntNum2.isNegative()) {
        break label188;
      }
      if (k != 0) {
        break label182;
      }
      k = 1;
      localObject2 = new int[j];
      negate((int[])localObject2, paramIntNum2.words, j);
    }
    for (;;)
    {
      if (i < j)
      {
        Object localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        int m = i;
        i = j;
        j = m;
      }
      IntNum localIntNum = alloc(i + j);
      MPN.mul(localIntNum.words, (int[])localObject1, i, (int[])localObject2, j);
      localIntNum.ival = (i + j);
      if (k != 0) {
        localIntNum.setNegative();
      }
      return localIntNum.canonicalize();
      localObject1 = paramIntNum1.words;
      k = 0;
      break;
      label182:
      k = 0;
      break label83;
      label188:
      localObject2 = paramIntNum2.words;
    }
  }
  
  public static IntNum valueOf(String paramString)
    throws NumberFormatException
  {
    return valueOf(paramString, 10);
  }
  
  public static IntNum valueOf(String paramString, int paramInt)
    throws NumberFormatException
  {
    int i = paramString.length();
    if (i + paramInt <= 28)
    {
      if ((i > 1) && (paramString.charAt(0) == '+') && (Character.digit(paramString.charAt(1), paramInt) >= 0)) {
        paramString = paramString.substring(1);
      }
      return make(Long.parseLong(paramString, paramInt));
    }
    byte[] arrayOfByte = new byte[i];
    boolean bool = false;
    int j = 0;
    int k = 0;
    char c;
    int m;
    if (j < i)
    {
      c = paramString.charAt(j);
      if ((c == '-') && (j == 0))
      {
        bool = true;
        m = k;
      }
    }
    for (;;)
    {
      j++;
      k = m;
      break;
      if ((c == '+') && (j == 0))
      {
        m = k;
      }
      else
      {
        if (c != '_')
        {
          if (k == 0)
          {
            if (c == ' ') {
              break label235;
            }
            if (c == '\t')
            {
              m = k;
              continue;
            }
          }
          int n = Character.digit(c, paramInt);
          if (n < 0) {
            throw new NumberFormatException("For input string: \"" + paramString + '"');
          }
          m = k + 1;
          arrayOfByte[k] = ((byte)n);
          continue;
          return valueOf(arrayOfByte, k, bool, paramInt);
        }
        label235:
        m = k;
      }
    }
  }
  
  public static IntNum valueOf(byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int[] arrayOfInt = new int[1 + paramInt1 / MPN.chars_per_word(paramInt2)];
    int i = MPN.set_str(arrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
    if (i == 0) {
      return zero();
    }
    if (arrayOfInt[(i - 1)] < 0)
    {
      int j = i + 1;
      arrayOfInt[i] = 0;
      i = j;
    }
    if (paramBoolean) {
      negate(arrayOfInt, arrayOfInt, i);
    }
    return make(arrayOfInt, i);
  }
  
  public static IntNum valueOf(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    int i = 0;
    int j = 0;
    char c;
    int k;
    if (i < paramInt2)
    {
      c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '-')
      {
        paramBoolean = true;
        k = j;
      }
    }
    for (;;)
    {
      i++;
      j = k;
      break;
      if (c != '_')
      {
        if (j == 0)
        {
          if (c == ' ') {
            break label123;
          }
          if (c == '\t')
          {
            k = j;
            continue;
          }
        }
        int m = Character.digit(c, paramInt3);
        if (m < 0) {
          return valueOf(arrayOfByte, j, paramBoolean, paramInt3);
        }
        k = j + 1;
        arrayOfByte[j] = ((byte)m);
        continue;
      }
      label123:
      k = j;
    }
  }
  
  public static int wordsNeeded(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramInt;
    int j;
    if (i > 0)
    {
      i--;
      j = paramArrayOfInt[i];
      if (j != -1) {
        break label47;
      }
      int k;
      do
      {
        if (i <= 0) {
          break;
        }
        k = paramArrayOfInt[(i - 1)];
        if (k >= 0) {
          break;
        }
        i--;
      } while (k == -1);
    }
    label47:
    label69:
    for (;;)
    {
      return i + 1;
      for (;;)
      {
        if ((j != 0) || (i <= 0)) {
          break label69;
        }
        j = paramArrayOfInt[(i - 1)];
        if (j < 0) {
          break;
        }
        i--;
      }
    }
  }
  
  public static final IntNum zero()
  {
    return smallFixNums[100];
  }
  
  public Numeric add(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof IntNum)) {
      return add(this, (IntNum)paramObject, paramInt);
    }
    if (!(paramObject instanceof Numeric)) {
      throw new IllegalArgumentException();
    }
    return ((Numeric)paramObject).addReversed(this, paramInt);
  }
  
  public BigDecimal asBigDecimal()
  {
    if (this.words == null) {
      return new BigDecimal(this.ival);
    }
    if (this.ival <= 2) {
      return BigDecimal.valueOf(longValue());
    }
    return new BigDecimal(toString());
  }
  
  public BigInteger asBigInteger()
  {
    if ((this.words == null) || (this.ival <= 2)) {
      return BigInteger.valueOf(longValue());
    }
    return new BigInteger(toString());
  }
  
  public IntNum canonicalize()
  {
    if (this.words != null)
    {
      int i = wordsNeeded(this.words, this.ival);
      this.ival = i;
      if (i <= 1)
      {
        if (this.ival == 1) {
          this.ival = this.words[0];
        }
        this.words = null;
      }
    }
    if ((this.words == null) && (this.ival >= -100) && (this.ival <= 1024)) {
      this = smallFixNums[(100 + this.ival)];
    }
    return this;
  }
  
  boolean checkBits(int paramInt)
  {
    int i = 1;
    if (paramInt <= 0) {}
    do
    {
      return false;
      if (this.words != null) {
        break;
      }
    } while ((paramInt <= 31) && ((this.ival & -1 + (i << paramInt)) == 0));
    return i;
    for (int j = 0; j < paramInt >> 5; j++) {
      if (this.words[j] != 0) {
        return i;
      }
    }
    if (((paramInt & 0x1F) != 0) && ((this.words[j] & -1 + (i << (paramInt & 0x1F))) != 0)) {}
    for (;;)
    {
      return i;
      i = 0;
    }
  }
  
  public int compare(Object paramObject)
  {
    if ((paramObject instanceof IntNum)) {
      return compare(this, (IntNum)paramObject);
    }
    return ((RealNum)paramObject).compareReversed(this);
  }
  
  public final IntNum denominator()
  {
    return one();
  }
  
  public Numeric div(Object paramObject)
  {
    if ((paramObject instanceof RatNum))
    {
      RatNum localRatNum = (RatNum)paramObject;
      return RatNum.make(times(this, localRatNum.denominator()), localRatNum.numerator());
    }
    if (!(paramObject instanceof Numeric)) {
      throw new IllegalArgumentException();
    }
    return ((Numeric)paramObject).divReversed(this);
  }
  
  public double doubleValue()
  {
    if (this.words == null) {
      return this.ival;
    }
    if (this.ival <= 2) {
      return longValue();
    }
    if (isNegative()) {
      return neg(this).roundToDouble(0, true, false);
    }
    return roundToDouble(0, false, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof IntNum))) {
      return false;
    }
    return equals(this, (IntNum)paramObject);
  }
  
  public void format(int paramInt, StringBuffer paramStringBuffer)
  {
    if (paramInt == 10)
    {
      if (this.words == null)
      {
        paramStringBuffer.append(this.ival);
        return;
      }
      if (this.ival <= 2)
      {
        paramStringBuffer.append(longValue());
        return;
      }
    }
    paramStringBuffer.append(toString(paramInt));
  }
  
  public void format(int paramInt, StringBuilder paramStringBuilder)
  {
    if (this.words == null) {
      if (paramInt == 10) {
        paramStringBuilder.append(this.ival);
      }
    }
    label216:
    int i1;
    for (;;)
    {
      return;
      paramStringBuilder.append(Integer.toString(this.ival, paramInt));
      return;
      if (this.ival <= 2)
      {
        long l = longValue();
        if (paramInt == 10)
        {
          paramStringBuilder.append(l);
          return;
        }
        paramStringBuilder.append(Long.toString(l, paramInt));
        return;
      }
      boolean bool = isNegative();
      int[] arrayOfInt;
      if ((bool) || (paramInt != 16))
      {
        arrayOfInt = new int[this.ival];
        getAbsolute(arrayOfInt);
      }
      int i;
      for (;;)
      {
        i = this.ival;
        if (paramInt != 16) {
          break label216;
        }
        if (bool) {
          paramStringBuilder.append('-');
        }
        int i5 = paramStringBuilder.length();
        int i6 = i;
        for (;;)
        {
          i6--;
          if (i6 < 0) {
            break;
          }
          int i7 = arrayOfInt[i6];
          int i8 = 8;
          for (;;)
          {
            i8--;
            if (i8 < 0) {
              break;
            }
            int i9 = 0xF & i7 >> i8 * 4;
            if ((i9 > 0) || (paramStringBuilder.length() > i5)) {
              paramStringBuilder.append(Character.forDigit(i9, 16));
            }
          }
        }
        break;
        arrayOfInt = this.words;
      }
      int j = MPN.chars_per_word(paramInt);
      int k = paramInt;
      int m = j;
      for (;;)
      {
        m--;
        if (m <= 0) {
          break;
        }
        k *= paramInt;
      }
      int n = paramStringBuilder.length();
      do
      {
        i1 = MPN.divmod_1(arrayOfInt, arrayOfInt, i, k);
        while ((i > 0) && (arrayOfInt[(i - 1)] == 0)) {
          i--;
        }
        int i2 = j;
        i2--;
        if ((i2 >= 0) && ((i != 0) || (i1 != 0))) {
          break;
        }
      } while (i != 0);
      if (bool) {
        paramStringBuilder.append('-');
      }
      for (int i3 = -1 + paramStringBuilder.length(); n < i3; i3--)
      {
        char c = paramStringBuilder.charAt(n);
        paramStringBuilder.setCharAt(n, paramStringBuilder.charAt(i3));
        paramStringBuilder.setCharAt(i3, c);
        n++;
      }
    }
    int i4;
    if (i1 < 0)
    {
      i4 = (int)((0xFFFFFFFF & i1) % paramInt);
      i1 /= paramInt;
    }
    for (;;)
    {
      paramStringBuilder.append(Character.forDigit(i4, paramInt));
      break;
      i4 = i1 % paramInt;
      i1 /= paramInt;
    }
  }
  
  public void getAbsolute(int[] paramArrayOfInt)
  {
    int i;
    if (this.words == null)
    {
      i = 1;
      paramArrayOfInt[0] = this.ival;
    }
    for (;;)
    {
      if (paramArrayOfInt[(i - 1)] < 0) {
        negate(paramArrayOfInt, paramArrayOfInt, i);
      }
      int k = paramArrayOfInt.length;
      for (;;)
      {
        k--;
        if (k <= i) {
          break;
        }
        paramArrayOfInt[k] = 0;
      }
      i = this.ival;
      int j = i;
      for (;;)
      {
        j--;
        if (j < 0) {
          break;
        }
        paramArrayOfInt[j] = this.words[j];
      }
    }
  }
  
  public int hashCode()
  {
    if (this.words == null) {
      return this.ival;
    }
    return this.words[0] + this.words[(-1 + this.ival)];
  }
  
  public boolean inIntRange()
  {
    return inRange(-2147483648L, 2147483647L);
  }
  
  public boolean inLongRange()
  {
    return inRange(-9223372036854775808L, 9223372036854775807L);
  }
  
  public boolean inRange(long paramLong1, long paramLong2)
  {
    return (compare(this, paramLong1) >= 0) && (compare(this, paramLong2) <= 0);
  }
  
  public int intLength()
  {
    if (this.words == null) {
      return MPN.intLength(this.ival);
    }
    return MPN.intLength(this.words, this.ival);
  }
  
  public int intValue()
  {
    if (this.words == null) {
      return this.ival;
    }
    return this.words[0];
  }
  
  public final boolean isMinusOne()
  {
    return (this.words == null) && (this.ival == -1);
  }
  
  public final boolean isNegative()
  {
    if (this.words == null) {}
    for (int i = this.ival; i < 0; i = this.words[(-1 + this.ival)]) {
      return true;
    }
    return false;
  }
  
  public final boolean isOdd()
  {
    if (this.words == null) {}
    for (int i = this.ival;; i = this.words[0])
    {
      int j = i & 0x1;
      boolean bool = false;
      if (j != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public final boolean isOne()
  {
    return (this.words == null) && (this.ival == 1);
  }
  
  public final boolean isZero()
  {
    return (this.words == null) && (this.ival == 0);
  }
  
  public long longValue()
  {
    if (this.words == null) {
      return this.ival;
    }
    if (this.ival == 1) {
      return this.words[0];
    }
    return (this.words[1] << 32) + (0xFFFFFFFF & this.words[0]);
  }
  
  public Numeric mul(Object paramObject)
  {
    if ((paramObject instanceof IntNum)) {
      return times(this, (IntNum)paramObject);
    }
    if (!(paramObject instanceof Numeric)) {
      throw new IllegalArgumentException();
    }
    return ((Numeric)paramObject).mulReversed(this);
  }
  
  public Numeric neg()
  {
    return neg(this);
  }
  
  public final IntNum numerator()
  {
    return this;
  }
  
  public Numeric power(IntNum paramIntNum)
  {
    if (isOne()) {}
    do
    {
      do
      {
        return this;
        if (!isMinusOne()) {
          break;
        }
      } while (paramIntNum.isOdd());
      return one();
      if ((paramIntNum.words == null) && (paramIntNum.ival >= 0)) {
        return power(this, paramIntNum.ival);
      }
      if (!isZero()) {
        break;
      }
    } while (!paramIntNum.isNegative());
    return RatNum.infinity(-1);
    return super.power(paramIntNum);
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    int i = paramObjectInput.readInt();
    if (i <= -1073741824)
    {
      i &= 0x7FFFFFFF;
      if (i != 1) {
        break label38;
      }
      i = paramObjectInput.readInt();
    }
    for (;;)
    {
      this.ival = i;
      return;
      label38:
      int[] arrayOfInt = new int[i];
      int j = i;
      for (;;)
      {
        j--;
        if (j < 0) {
          break;
        }
        arrayOfInt[j] = paramObjectInput.readInt();
      }
      this.words = arrayOfInt;
    }
  }
  
  public Object readResolve()
    throws ObjectStreamException
  {
    return canonicalize();
  }
  
  public void realloc(int paramInt)
  {
    if (paramInt == 0) {
      if (this.words != null)
      {
        if (this.ival > 0) {
          this.ival = this.words[0];
        }
        this.words = null;
      }
    }
    while ((this.words != null) && (this.words.length >= paramInt) && (this.words.length <= paramInt + 2)) {
      return;
    }
    int[] arrayOfInt = new int[paramInt];
    if (this.words == null)
    {
      arrayOfInt[0] = this.ival;
      this.ival = 1;
    }
    for (;;)
    {
      this.words = arrayOfInt;
      return;
      if (paramInt < this.ival) {
        this.ival = paramInt;
      }
      System.arraycopy(this.words, 0, arrayOfInt, 0, this.ival);
    }
  }
  
  public double roundToDouble(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = intLength();
    int j = paramInt + (i - 1);
    if (j < -1075)
    {
      if (paramBoolean1) {
        return 0.0D;
      }
      return 0.0D;
    }
    if (j > 1023)
    {
      if (paramBoolean1) {
        return (-1.0D / 0.0D);
      }
      return (1.0D / 0.0D);
    }
    int k;
    int m;
    long l1;
    if (j >= -1022)
    {
      k = 53;
      m = i - (k + 1);
      if (m <= 0) {
        break label168;
      }
      if (this.words != null) {
        break label150;
      }
      l1 = this.ival >> m;
    }
    for (;;)
    {
      if ((j == 1023) && (l1 >> 1 == 9007199254740991L))
      {
        if ((paramBoolean2) || (checkBits(i - k)))
        {
          if (paramBoolean1)
          {
            return (-1.0D / 0.0D);
            k = 1022 + (j + 53);
            break;
            label150:
            l1 = MPN.rshift_long(this.words, this.ival, m);
            continue;
            label168:
            l1 = longValue() << -m;
            continue;
          }
          return (1.0D / 0.0D);
        }
        if (paramBoolean1) {
          return -1.797693134862316E+308D;
        }
        return 1.7976931348623157E+308D;
      }
    }
    long l2;
    long l3;
    label275:
    int n;
    if (((1L & l1) == 1L) && (((0x2 & l1) == 2L) || (paramBoolean2) || (checkBits(m))))
    {
      l1 += 2L;
      if ((0x0 & l1) != 0L)
      {
        j++;
        l1 >>= 1;
      }
    }
    else
    {
      l2 = l1 >> 1;
      if (!paramBoolean1) {
        break label331;
      }
      l3 = -9223372036854775808L;
      n = 1023 + j;
      if (n > 0) {
        break label337;
      }
    }
    label331:
    label337:
    for (long l4 = 0L;; l4 = n << 52)
    {
      return Double.longBitsToDouble(l2 & 0xFFFFFFFF | l3 | l4);
      if ((k != 52) || ((0x0 & l1) == 0L)) {
        break;
      }
      j++;
      break;
      l3 = 0L;
      break label275;
    }
  }
  
  public final void set(int paramInt)
  {
    this.words = null;
    this.ival = paramInt;
  }
  
  public final void set(long paramLong)
  {
    int i = (int)paramLong;
    if (i == paramLong)
    {
      this.ival = i;
      this.words = null;
      return;
    }
    realloc(2);
    this.words[0] = i;
    this.words[1] = ((int)(paramLong >> 32));
    this.ival = 2;
  }
  
  public final void set(IntNum paramIntNum)
  {
    if (paramIntNum.words == null) {
      set(paramIntNum.ival);
    }
    while (this == paramIntNum) {
      return;
    }
    realloc(paramIntNum.ival);
    System.arraycopy(paramIntNum.words, 0, this.words, 0, paramIntNum.ival);
    this.ival = paramIntNum.ival;
  }
  
  public final void set(int[] paramArrayOfInt, int paramInt)
  {
    this.ival = paramInt;
    this.words = paramArrayOfInt;
  }
  
  public final void setAdd(int paramInt)
  {
    setAdd(this, paramInt);
  }
  
  public void setAdd(IntNum paramIntNum, int paramInt)
  {
    if (paramIntNum.words == null)
    {
      set(paramIntNum.ival + paramInt);
      return;
    }
    int i = paramIntNum.ival;
    realloc(i + 1);
    long l1 = paramInt;
    for (int j = 0; j < i; j++)
    {
      long l2 = l1 + (0xFFFFFFFF & paramIntNum.words[j]);
      this.words[j] = ((int)l2);
      l1 = l2 >> 32;
    }
    if (paramIntNum.words[(i - 1)] < 0) {
      l1 -= 1L;
    }
    this.words[i] = ((int)l1);
    this.ival = wordsNeeded(this.words, i + 1);
  }
  
  void setInvert()
  {
    if (this.words == null) {
      this.ival = (0xFFFFFFFF ^ this.ival);
    }
    for (;;)
    {
      return;
      int i = this.ival;
      for (;;)
      {
        i--;
        if (i < 0) {
          break;
        }
        this.words[i] = (0xFFFFFFFF ^ this.words[i]);
      }
    }
  }
  
  public final void setNegative()
  {
    setNegative(this);
  }
  
  public void setNegative(IntNum paramIntNum)
  {
    int i = paramIntNum.ival;
    if (paramIntNum.words == null)
    {
      if (i == -2147483648)
      {
        set(-i);
        return;
      }
      set(-i);
      return;
    }
    realloc(i + 1);
    if (negate(this.words, paramIntNum.words, i))
    {
      int[] arrayOfInt = this.words;
      int j = i + 1;
      arrayOfInt[i] = 0;
      i = j;
    }
    this.ival = i;
  }
  
  void setShift(IntNum paramIntNum, int paramInt)
  {
    if (paramInt > 0)
    {
      setShiftLeft(paramIntNum, paramInt);
      return;
    }
    setShiftRight(paramIntNum, -paramInt);
  }
  
  void setShiftLeft(IntNum paramIntNum, int paramInt)
  {
    if (paramIntNum.words == null) {
      if (paramInt < 32) {
        set(paramIntNum.ival << paramInt);
      }
    }
    for (;;)
    {
      return;
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = paramIntNum.ival;
      int j;
      int k;
      int m;
      for (int i = 1;; i = paramIntNum.ival)
      {
        j = paramInt >> 5;
        k = paramInt & 0x1F;
        m = i + j;
        if (k != 0) {
          break;
        }
        realloc(m);
        int i3 = i;
        for (;;)
        {
          i3--;
          if (i3 < 0) {
            break;
          }
          this.words[(i3 + j)] = arrayOfInt[i3];
        }
        arrayOfInt = paramIntNum.words;
      }
      m++;
      realloc(m);
      int n = MPN.lshift(this.words, j, arrayOfInt, i, k);
      int i1 = 32 - k;
      this.words[(m - 1)] = (n << i1 >> i1);
      this.ival = m;
      int i2 = j;
      for (;;)
      {
        i2--;
        if (i2 < 0) {
          break;
        }
        this.words[i2] = 0;
      }
    }
  }
  
  void setShiftRight(IntNum paramIntNum, int paramInt)
  {
    int i = -1;
    if (paramIntNum.words == null) {
      if (paramInt >= 32) {}
    }
    boolean bool;
    int k;
    int m;
    do
    {
      i = paramIntNum.ival >> paramInt;
      for (;;)
      {
        set(i);
        return;
        if (paramIntNum.ival >= 0) {
          i = 0;
        }
      }
      if (paramInt == 0)
      {
        set(paramIntNum);
        return;
      }
      bool = paramIntNum.isNegative();
      int j = paramInt >> 5;
      k = paramInt & 0x1F;
      m = paramIntNum.ival - j;
      if (m <= 0)
      {
        if (bool) {}
        for (;;)
        {
          set(i);
          return;
          i = 0;
        }
      }
      if ((this.words == null) || (this.words.length < m)) {
        realloc(m);
      }
      MPN.rshift0(this.words, paramIntNum.words, j, m, k);
      this.ival = m;
    } while (!bool);
    int[] arrayOfInt = this.words;
    int n = m - 1;
    arrayOfInt[n] |= -2 << 31 - k;
  }
  
  public int sign()
  {
    int i = this.ival;
    int[] arrayOfInt = this.words;
    if (arrayOfInt == null) {
      if (i <= 0) {}
    }
    int j;
    int k;
    do
    {
      return 1;
      if (i < 0) {
        return -1;
      }
      return 0;
      j = i - 1;
      k = arrayOfInt[j];
    } while (k > 0);
    if (k < 0) {
      return -1;
    }
    do
    {
      if (j == 0) {
        return 0;
      }
      j--;
    } while (arrayOfInt[j] == 0);
    return 1;
  }
  
  public IntNum toExactInt(int paramInt)
  {
    return this;
  }
  
  public RealNum toInt(int paramInt)
  {
    return this;
  }
  
  public String toString(int paramInt)
  {
    if (this.words == null) {
      return Integer.toString(this.ival, paramInt);
    }
    if (this.ival <= 2) {
      return Long.toString(longValue(), paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder(this.ival * (1 + MPN.chars_per_word(paramInt)));
    format(paramInt, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    int i;
    int k;
    if (this.words == null)
    {
      i = 1;
      if (i > 1) {
        break label101;
      }
      if (this.words != null) {
        break label59;
      }
      k = this.ival;
      label27:
      if (k < -1073741824) {
        break label83;
      }
      paramObjectOutput.writeInt(k);
    }
    for (;;)
    {
      return;
      i = wordsNeeded(this.words, this.ival);
      break;
      label59:
      int j = this.words.length;
      k = 0;
      if (j == 0) {
        break label27;
      }
      k = this.words[0];
      break label27;
      label83:
      paramObjectOutput.writeInt(-2147483647);
      paramObjectOutput.writeInt(k);
      return;
      label101:
      paramObjectOutput.writeInt(0x80000000 | i);
      for (;;)
      {
        i--;
        if (i < 0) {
          break;
        }
        paramObjectOutput.writeInt(this.words[i]);
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.math.IntNum
 * JD-Core Version:    0.7.0.1
 */