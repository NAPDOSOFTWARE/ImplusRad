package gnu.math;

public class BitOps
{
  static final byte[] bit4_count = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };
  
  public static IntNum and(IntNum paramIntNum, int paramInt)
  {
    if (paramIntNum.words == null) {
      return IntNum.make(paramInt & paramIntNum.ival);
    }
    if (paramInt >= 0) {
      return IntNum.make(paramInt & paramIntNum.words[0]);
    }
    int i = paramIntNum.ival;
    int[] arrayOfInt = new int[i];
    arrayOfInt[0] = (paramInt & paramIntNum.words[0]);
    for (;;)
    {
      i--;
      if (i <= 0) {
        break;
      }
      arrayOfInt[i] = paramIntNum.words[i];
    }
    return IntNum.make(arrayOfInt, paramIntNum.ival);
  }
  
  public static IntNum and(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    if (paramIntNum2.words == null) {
      return and(paramIntNum1, paramIntNum2.ival);
    }
    if (paramIntNum1.words == null) {
      return and(paramIntNum2, paramIntNum1.ival);
    }
    if (paramIntNum1.ival < paramIntNum2.ival)
    {
      IntNum localIntNum = paramIntNum1;
      paramIntNum1 = paramIntNum2;
      paramIntNum2 = localIntNum;
    }
    if (paramIntNum2.isNegative()) {}
    int[] arrayOfInt;
    int j;
    for (int i = paramIntNum1.ival;; i = paramIntNum2.ival)
    {
      arrayOfInt = new int[i];
      for (j = 0; j < paramIntNum2.ival; j++) {
        arrayOfInt[j] = (paramIntNum1.words[j] & paramIntNum2.words[j]);
      }
    }
    while (j < i)
    {
      arrayOfInt[j] = paramIntNum1.words[j];
      j++;
    }
    return IntNum.make(arrayOfInt, i);
  }
  
  public static int bitCount(int paramInt)
  {
    int i = 0;
    while (paramInt != 0)
    {
      i += bit4_count[(paramInt & 0xF)];
      paramInt >>>= 4;
    }
    return i;
  }
  
  public static int bitCount(IntNum paramIntNum)
  {
    int[] arrayOfInt = paramIntNum.words;
    int i;
    if (arrayOfInt == null) {
      i = 1;
    }
    for (int j = bitCount(paramIntNum.ival);; j = bitCount(arrayOfInt, i))
    {
      if (paramIntNum.isNegative()) {
        j = i * 32 - j;
      }
      return j;
      i = paramIntNum.ival;
    }
  }
  
  public static int bitCount(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    for (;;)
    {
      paramInt--;
      if (paramInt < 0) {
        break;
      }
      i += bitCount(paramArrayOfInt[paramInt]);
    }
    return i;
  }
  
  public static IntNum bitOp(int paramInt, IntNum paramIntNum1, IntNum paramIntNum2)
  {
    switch (paramInt)
    {
    default: 
      IntNum localIntNum = new IntNum();
      setBitOp(localIntNum, paramInt, paramIntNum1, paramIntNum2);
      paramIntNum1 = localIntNum.canonicalize();
    case 3: 
      return paramIntNum1;
    case 0: 
      return IntNum.zero();
    case 1: 
      return and(paramIntNum1, paramIntNum2);
    case 5: 
      return paramIntNum2;
    }
    return IntNum.minusOne();
  }
  
  public static boolean bitValue(IntNum paramIntNum, int paramInt)
  {
    int i = paramIntNum.ival;
    if (paramIntNum.words == null) {
      if (paramInt >= 32) {
        if (i >= 0) {}
      }
    }
    int j;
    do
    {
      do
      {
        do
        {
          return true;
          return false;
        } while ((0x1 & i >> paramInt) != 0);
        return false;
        j = paramInt >> 5;
        if (j < i) {
          break;
        }
      } while (paramIntNum.words[(i - 1)] < 0);
      return false;
    } while ((0x1 & paramIntNum.words[j] >> paramInt) != 0);
    return false;
  }
  
  static int[] dataBufferFor(IntNum paramIntNum, int paramInt)
  {
    int i = paramIntNum.ival;
    int j = paramInt + 1 >> 5;
    int[] arrayOfInt;
    if (paramIntNum.words == null)
    {
      if (j == 0) {
        j = 1;
      }
      arrayOfInt = new int[j];
      arrayOfInt[0] = i;
      if (i < 0) {
        for (int i2 = 1; i2 < j; i2++) {
          arrayOfInt[i2] = -1;
        }
      }
    }
    else
    {
      int k = paramInt + 1 >> 5;
      if (k > i) {}
      for (int m = k;; m = i)
      {
        arrayOfInt = new int[m];
        int n = i;
        for (;;)
        {
          n--;
          if (n < 0) {
            break;
          }
          arrayOfInt[n] = paramIntNum.words[n];
        }
      }
      if (arrayOfInt[(i - 1)] < 0) {
        for (int i1 = i; i1 < k; i1++) {
          arrayOfInt[i1] = -1;
        }
      }
    }
    return arrayOfInt;
  }
  
  public static IntNum extract(IntNum paramIntNum, int paramInt1, int paramInt2)
  {
    int i6;
    if (paramInt2 < 32) {
      if (paramIntNum.words == null)
      {
        i6 = paramIntNum.ival;
        paramIntNum = IntNum.make((i6 & (0xFFFFFFFF ^ -1 << paramInt2)) >> paramInt1);
      }
    }
    int i;
    boolean bool;
    do
    {
      return paramIntNum;
      i6 = paramIntNum.words[0];
      break;
      if (paramIntNum.words != null) {
        break label176;
      }
      if (paramIntNum.ival >= 0)
      {
        if (paramInt1 >= 31) {}
        for (int i5 = 0;; i5 = paramIntNum.ival >> paramInt1) {
          return IntNum.make(i5);
        }
      }
      i = 1;
      bool = paramIntNum.isNegative();
      if (paramInt2 <= i * 32) {
        break label184;
      }
      paramInt2 = i * 32;
    } while ((!bool) && (paramInt1 == 0));
    label116:
    int j = paramInt2 - paramInt1;
    if (j < 64)
    {
      int i3;
      int i4;
      if (paramIntNum.words == null)
      {
        i3 = paramIntNum.ival;
        if (paramInt1 >= 32) {
          i4 = 31;
        }
      }
      label151:
      for (long l = i3 >> i4;; l = MPN.rshift_long(paramIntNum.words, i, paramInt1))
      {
        return IntNum.make(l & (0xFFFFFFFF ^ -1L << j));
        label176:
        i = paramIntNum.ival;
        break;
        label184:
        i = paramInt2 + 31 >> 5;
        break label116;
        i4 = paramInt1;
        break label151;
      }
    }
    int k = paramInt1 >> 5;
    int[] arrayOfInt = new int[1 + (paramInt2 >> 5) - k];
    int i2;
    if (paramIntNum.words == null) {
      if (paramInt1 >= 32)
      {
        i2 = -1;
        arrayOfInt[0] = i2;
      }
    }
    for (;;)
    {
      int i1 = j >> 5;
      arrayOfInt[i1] &= (0xFFFFFFFF ^ -1 << j);
      return IntNum.make(arrayOfInt, i1 + 1);
      i2 = paramIntNum.ival >> paramInt1;
      break;
      int m = i - k;
      int n = paramInt1 & 0x1F;
      MPN.rshift0(arrayOfInt, paramIntNum.words, k, m, n);
    }
  }
  
  public static IntNum ior(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return bitOp(7, paramIntNum1, paramIntNum2);
  }
  
  public static int lowestBitSet(int paramInt)
  {
    int i;
    if (paramInt == 0) {
      i = -1;
    }
    do
    {
      return i;
      for (i = 0; (paramInt & 0xFF) == 0; i += 8) {
        paramInt >>>= 8;
      }
      while ((paramInt & 0x3) == 0)
      {
        paramInt >>>= 2;
        i += 2;
      }
    } while ((paramInt & 0x1) != 0);
    return i + 1;
  }
  
  public static int lowestBitSet(IntNum paramIntNum)
  {
    int[] arrayOfInt = paramIntNum.words;
    if (arrayOfInt == null) {
      return lowestBitSet(paramIntNum.ival);
    }
    int i = paramIntNum.ival;
    while (i < 0)
    {
      int j = lowestBitSet(arrayOfInt[0]);
      if (j >= 0) {
        return j + 0;
      }
    }
    return -1;
  }
  
  public static IntNum not(IntNum paramIntNum)
  {
    return bitOp(12, paramIntNum, IntNum.zero());
  }
  
  public static IntNum reverseBits(IntNum paramIntNum, int paramInt1, int paramInt2)
  {
    int i = paramIntNum.ival;
    if ((paramIntNum.words == null) && (paramInt2 < 63))
    {
      long l1 = i;
      int i9 = paramInt1;
      for (int i10 = paramInt2 - 1; i9 < i10; i10--)
      {
        long l2 = 1L & l1 >> i9;
        long l3 = 1L & l1 >> i10;
        l1 = l1 & (0xFFFFFFFF ^ (1L << i9 | 1L << i10)) | l2 << i10 | l3 << i9;
        i9++;
      }
      return IntNum.make(l1);
    }
    int[] arrayOfInt = dataBufferFor(paramIntNum, paramInt2 - 1);
    int j = paramInt1;
    int k = paramInt2 - 1;
    if (j < k)
    {
      int m = j >> 5;
      int n = k >> 5;
      int i1 = arrayOfInt[m];
      int i2 = 0x1 & i1 >> j;
      int i7;
      if (m == n)
      {
        int i8 = 0x1 & i1 >> k;
        i7 = (int)(i1 & (0xFFFFFFFF ^ (1L << j | 1L << k))) | i2 << k | i8 << j;
      }
      for (;;)
      {
        arrayOfInt[m] = i7;
        j++;
        k--;
        break;
        int i3 = arrayOfInt[n];
        int i4 = 0x1 & i3 >> (k & 0x1F);
        int i5 = i1 & (0xFFFFFFFF ^ 1 << (j & 0x1F));
        int i6 = i3 & (0xFFFFFFFF ^ 1 << (k & 0x1F));
        i7 = i5 | i4 << (j & 0x1F);
        arrayOfInt[n] = (i6 | i2 << (k & 0x1F));
      }
    }
    return IntNum.make(arrayOfInt, arrayOfInt.length);
  }
  
  public static void setBitOp(IntNum paramIntNum1, int paramInt, IntNum paramIntNum2, IntNum paramIntNum3)
  {
    label7:
    int i;
    int j;
    label23:
    int k;
    int m;
    label39:
    int[] arrayOfInt;
    int n;
    if (paramIntNum3.words == null)
    {
      if (paramIntNum3.words != null) {
        break label229;
      }
      i = paramIntNum3.ival;
      j = 1;
      if (paramIntNum2.words != null) {
        break label246;
      }
      k = paramIntNum2.ival;
      m = 1;
      if (m > 1) {
        paramIntNum1.realloc(m);
      }
      arrayOfInt = paramIntNum1.words;
      n = 0;
    }
    int i2;
    int i3;
    label188:
    label229:
    label246:
    int i4;
    switch (paramInt)
    {
    default: 
      i2 = -1;
      i1 = 0;
    case 0: 
      for (;;)
      {
        if (i1 + 1 == m) {
          n = 0;
        }
        switch (n)
        {
        default: 
          i3 = i1;
          paramIntNum1.ival = i3;
          return;
          if ((paramIntNum2.words != null) && (paramIntNum2.ival >= paramIntNum3.ival)) {
            break label7;
          }
          IntNum localIntNum = paramIntNum2;
          paramIntNum2 = paramIntNum3;
          paramIntNum3 = localIntNum;
          paramInt = swappedOp(paramInt);
          break label7;
          i = paramIntNum3.words[0];
          j = paramIntNum3.ival;
          break label23;
          k = paramIntNum2.words[0];
          m = paramIntNum2.ival;
          break label39;
          n = 0;
          i1 = 0;
          i2 = 0;
        }
      }
      label275:
      i4 = i1 + 1;
      arrayOfInt[i1] = i2;
      k = paramIntNum2.words[i4];
      i = paramIntNum3.words[i4];
    }
    for (int i1 = i4;; i1 = 0)
    {
      i2 = k & i;
      if (i1 + 1 < j) {
        break label275;
      }
      n = 0;
      if (i >= 0) {
        break;
      }
      n = 1;
      break;
      label340:
      int i5 = i1 + 1;
      arrayOfInt[i1] = i2;
      k = paramIntNum2.words[i5];
      i = paramIntNum3.words[i5];
      for (i1 = i5;; i1 = 0)
      {
        i2 = k & (i ^ 0xFFFFFFFF);
        if (i1 + 1 < j) {
          break label340;
        }
        n = 0;
        if (i < 0) {
          break;
        }
        n = 1;
        break;
        i2 = k;
        n = 1;
        i1 = 0;
        break;
        label420:
        int i6 = i1 + 1;
        arrayOfInt[i1] = i2;
        k = paramIntNum2.words[i6];
        i = paramIntNum3.words[i6];
        for (i1 = i6;; i1 = 0)
        {
          i2 = i & (k ^ 0xFFFFFFFF);
          if (i1 + 1 < j) {
            break label420;
          }
          n = 0;
          if (i >= 0) {
            break;
          }
          n = 2;
          break;
          label487:
          int i7 = i1 + 1;
          arrayOfInt[i1] = i2;
          paramIntNum2.words[i7];
          i = paramIntNum3.words[i7];
          for (i1 = i7;; i1 = 0)
          {
            i2 = i;
            if (i1 + 1 < j) {
              break label487;
            }
            n = 0;
            break;
            label540:
            int i8 = i1 + 1;
            arrayOfInt[i1] = i2;
            k = paramIntNum2.words[i8];
            i = paramIntNum3.words[i8];
            for (i1 = i8;; i1 = 0)
            {
              i2 = k ^ i;
              if (i1 + 1 < j) {
                break label540;
              }
              if (i < 0) {}
              for (n = 2;; n = 1) {
                break;
              }
              label608:
              int i9 = i1 + 1;
              arrayOfInt[i1] = i2;
              k = paramIntNum2.words[i9];
              i = paramIntNum3.words[i9];
              for (i1 = i9;; i1 = 0)
              {
                i2 = k | i;
                if (i1 + 1 < j) {
                  break label608;
                }
                n = 0;
                if (i < 0) {
                  break;
                }
                n = 1;
                break;
                label673:
                int i10 = i1 + 1;
                arrayOfInt[i1] = i2;
                k = paramIntNum2.words[i10];
                i = paramIntNum3.words[i10];
                for (i1 = i10;; i1 = 0)
                {
                  i2 = 0xFFFFFFFF ^ (k | i);
                  if (i1 + 1 < j) {
                    break label673;
                  }
                  n = 0;
                  if (i < 0) {
                    break;
                  }
                  n = 2;
                  break;
                  label740:
                  int i11 = i1 + 1;
                  arrayOfInt[i1] = i2;
                  k = paramIntNum2.words[i11];
                  i = paramIntNum3.words[i11];
                  for (i1 = i11;; i1 = 0)
                  {
                    i2 = 0xFFFFFFFF ^ k ^ i;
                    if (i1 + 1 < j) {
                      break label740;
                    }
                    if (i >= 0) {}
                    for (n = 2;; n = 1) {
                      break;
                    }
                    label810:
                    int i12 = i1 + 1;
                    arrayOfInt[i1] = i2;
                    paramIntNum2.words[i12];
                    i = paramIntNum3.words[i12];
                    for (i1 = i12;; i1 = 0)
                    {
                      i2 = i ^ 0xFFFFFFFF;
                      if (i1 + 1 < j) {
                        break label810;
                      }
                      n = 0;
                      break;
                      label865:
                      int i13 = i1 + 1;
                      arrayOfInt[i1] = i2;
                      k = paramIntNum2.words[i13];
                      i = paramIntNum3.words[i13];
                      for (i1 = i13;; i1 = 0)
                      {
                        i2 = k | i ^ 0xFFFFFFFF;
                        if (i1 + 1 < j) {
                          break label865;
                        }
                        n = 0;
                        if (i >= 0) {
                          break;
                        }
                        n = 1;
                        break;
                        i2 = k ^ 0xFFFFFFFF;
                        n = 2;
                        i1 = 0;
                        break;
                        label947:
                        int i14 = i1 + 1;
                        arrayOfInt[i1] = i2;
                        k = paramIntNum2.words[i14];
                        i = paramIntNum3.words[i14];
                        for (i1 = i14;; i1 = 0)
                        {
                          i2 = i | k ^ 0xFFFFFFFF;
                          if (i1 + 1 < j) {
                            break label947;
                          }
                          n = 0;
                          if (i < 0) {
                            break;
                          }
                          n = 2;
                          break;
                          label1014:
                          int i15 = i1 + 1;
                          arrayOfInt[i1] = i2;
                          k = paramIntNum2.words[i15];
                          i = paramIntNum3.words[i15];
                          for (i1 = i15;; i1 = 0)
                          {
                            i2 = 0xFFFFFFFF ^ k & i;
                            if (i1 + 1 < j) {
                              break label1014;
                            }
                            n = 0;
                            if (i >= 0) {
                              break;
                            }
                            n = 2;
                            break;
                            if ((i1 == 0) && (arrayOfInt == null))
                            {
                              paramIntNum1.ival = i2;
                              return;
                            }
                            i3 = i1 + 1;
                            arrayOfInt[i1] = i2;
                            break label188;
                            arrayOfInt[i1] = i2;
                            i3 = i1;
                            for (;;)
                            {
                              i3++;
                              if (i3 >= m) {
                                break;
                              }
                              arrayOfInt[i3] = paramIntNum2.words[i3];
                            }
                            arrayOfInt[i1] = i2;
                            i3 = i1;
                            for (;;)
                            {
                              i3++;
                              if (i3 >= m) {
                                break;
                              }
                              arrayOfInt[i3] = (0xFFFFFFFF ^ paramIntNum2.words[i3]);
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static IntNum setBitValue(IntNum paramIntNum, int paramInt1, int paramInt2)
  {
    int i = 31;
    int j = paramInt2 & 0x1;
    int k = paramIntNum.ival;
    if (paramIntNum.words == null)
    {
      if (paramInt1 < i) {
        i = paramInt1;
      }
      if ((0x1 & k >> i) != j) {}
    }
    for (;;)
    {
      return paramIntNum;
      int m;
      int n;
      if (paramInt1 < 63)
      {
        return IntNum.make(k ^ 1 << paramInt1);
        m = paramInt1 >> 5;
        if (m < k) {
          break label137;
        }
        if (paramIntNum.words[(k - 1)] >= 0) {
          break label131;
        }
        n = 1;
      }
      while (n != j)
      {
        int[] arrayOfInt = dataBufferFor(paramIntNum, paramInt1);
        int i1 = paramInt1 >> 5;
        arrayOfInt[i1] ^= 1 << (paramInt1 & 0x1F);
        return IntNum.make(arrayOfInt, arrayOfInt.length);
        label131:
        n = 0;
        continue;
        label137:
        n = 0x1 & paramIntNum.words[m] >> paramInt1;
      }
    }
  }
  
  public static int swappedOp(int paramInt)
  {
    return "".charAt(paramInt);
  }
  
  public static boolean test(IntNum paramIntNum, int paramInt)
  {
    if (paramIntNum.words == null) {
      return (paramInt & paramIntNum.ival) != 0;
    }
    boolean bool;
    if (paramInt >= 0)
    {
      int i = paramInt & paramIntNum.words[0];
      bool = false;
      if (i == 0) {}
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  public static boolean test(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    if (paramIntNum2.words == null) {
      return test(paramIntNum1, paramIntNum2.ival);
    }
    if (paramIntNum1.words == null) {
      return test(paramIntNum2, paramIntNum1.ival);
    }
    if (paramIntNum1.ival < paramIntNum2.ival)
    {
      IntNum localIntNum = paramIntNum1;
      paramIntNum1 = paramIntNum2;
      paramIntNum2 = localIntNum;
    }
    for (int i = 0; i < paramIntNum2.ival; i++) {
      if ((paramIntNum1.words[i] & paramIntNum2.words[i]) != 0) {
        return true;
      }
    }
    return paramIntNum2.isNegative();
  }
  
  public static IntNum xor(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return bitOp(6, paramIntNum1, paramIntNum2);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.math.BitOps
 * JD-Core Version:    0.7.0.1
 */