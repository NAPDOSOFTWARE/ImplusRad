package gnu.math;

class MPN
{
  public static int add_1(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    long l1 = 0xFFFFFFFF & paramInt2;
    for (int i = 0; i < paramInt1; i++)
    {
      long l2 = l1 + (0xFFFFFFFF & paramArrayOfInt2[i]);
      paramArrayOfInt1[i] = ((int)l2);
      l1 = l2 >> 32;
    }
    return (int)l1;
  }
  
  public static int add_n(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int paramInt)
  {
    long l1 = 0L;
    for (int i = 0; i < paramInt; i++)
    {
      long l2 = l1 + ((0xFFFFFFFF & paramArrayOfInt2[i]) + (0xFFFFFFFF & paramArrayOfInt3[i]));
      paramArrayOfInt1[i] = ((int)l2);
      l1 = l2 >>> 32;
    }
    return (int)l1;
  }
  
  public static int chars_per_word(int paramInt)
  {
    int i = 16;
    if (paramInt < 10)
    {
      if (paramInt < 8)
      {
        if (paramInt <= 2) {
          i = 32;
        }
        do
        {
          return i;
          if (paramInt == 3) {
            return 20;
          }
        } while (paramInt == 4);
        return 18 - paramInt;
      }
      return 10;
    }
    if (paramInt < 12) {
      return 9;
    }
    if (paramInt <= i) {
      return 8;
    }
    if (paramInt <= 23) {
      return 7;
    }
    if (paramInt <= 40) {
      return 6;
    }
    if (paramInt <= 256) {
      return 4;
    }
    return 1;
  }
  
  public static int cmp(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return 1;
    }
    if (paramInt1 < paramInt2) {
      return -1;
    }
    return cmp(paramArrayOfInt1, paramArrayOfInt2, paramInt1);
  }
  
  public static int cmp(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i;
    int j;
    do
    {
      
      if (paramInt < 0) {
        break;
      }
      i = paramArrayOfInt1[paramInt];
      j = paramArrayOfInt2[paramInt];
    } while (i == j);
    if ((i ^ 0x80000000) > (0x80000000 ^ j)) {
      return 1;
    }
    return -1;
    return 0;
  }
  
  public static int count_leading_zeros(int paramInt)
  {
    if (paramInt == 0)
    {
      i = 32;
      return i;
    }
    int i = 0;
    int j = 16;
    label14:
    int k;
    if (j > 0)
    {
      k = paramInt >>> j;
      if (k != 0) {
        break label37;
      }
      i += j;
    }
    for (;;)
    {
      j >>= 1;
      break label14;
      break;
      label37:
      paramInt = k;
    }
  }
  
  public static void divide(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    int i = paramInt1;
    label188:
    do
    {
      int j;
      int k;
      if (paramArrayOfInt1[i] == paramArrayOfInt2[(paramInt2 - 1)])
      {
        j = -1;
        if (j != 0) {
          k = submul_1(paramArrayOfInt1, i - paramInt2, paramArrayOfInt2, paramInt2, j);
        }
      }
      else
      {
        long l2;
        for (long l1 = (0xFFFFFFFF & paramArrayOfInt1[i]) - (0xFFFFFFFF & k);; l1 = l2 - 1L)
        {
          if (l1 == 0L) {
            break label188;
          }
          j--;
          l2 = 0L;
          int m = 0;
          for (;;)
          {
            if (m < paramInt2)
            {
              long l3 = l2 + ((0xFFFFFFFF & paramArrayOfInt1[(m + (i - paramInt2))]) + (0xFFFFFFFF & paramArrayOfInt2[m]));
              paramArrayOfInt1[(m + (i - paramInt2))] = ((int)l3);
              l2 = l3 >>> 32;
              m++;
              continue;
              j = (int)udiv_qrnnd((paramArrayOfInt1[i] << 32) + (0xFFFFFFFF & paramArrayOfInt1[(i - 1)]), paramArrayOfInt2[(paramInt2 - 1)]);
              break;
            }
          }
          paramArrayOfInt1[i] = ((int)(l2 + paramArrayOfInt1[i]));
        }
      }
      paramArrayOfInt1[i] = j;
      i--;
    } while (i >= paramInt2);
  }
  
  public static int divmod_1(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    int i = paramInt1 - 1;
    long l1 = paramArrayOfInt2[i];
    long l2;
    if ((l1 & 0xFFFFFFFF) >= (0xFFFFFFFF & paramInt2)) {
      l2 = 0L;
    }
    while (i >= 0)
    {
      int k = paramArrayOfInt2[i];
      l2 = udiv_qrnnd(0x0 & l2 | 0xFFFFFFFF & k, paramInt2);
      paramArrayOfInt1[i] = ((int)l2);
      i--;
      continue;
      int j = i - 1;
      paramArrayOfInt1[i] = 0;
      l2 = l1 << 32;
      i = j;
    }
    return (int)(l2 >> 32);
  }
  
  static int findLowestBit(int paramInt)
  {
    for (int i = 0; (paramInt & 0xF) == 0; i += 4) {
      paramInt >>= 4;
    }
    if ((paramInt & 0x3) == 0)
    {
      paramInt >>= 2;
      i += 2;
    }
    if ((paramInt & 0x1) == 0) {
      i++;
    }
    return i;
  }
  
  static int findLowestBit(int[] paramArrayOfInt)
  {
    for (int i = 0;; i++) {
      if (paramArrayOfInt[i] != 0) {
        return i * 32 + findLowestBit(paramArrayOfInt[i]);
      }
    }
  }
  
  public static int gcd(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    int j = paramArrayOfInt1[i] | paramArrayOfInt2[i];
    int k;
    int m;
    int n;
    Object localObject1;
    if (j != 0)
    {
      k = i;
      m = findLowestBit(j);
      n = paramInt - k;
      rshift0(paramArrayOfInt1, paramArrayOfInt1, k, n, m);
      rshift0(paramArrayOfInt2, paramArrayOfInt2, k, n, m);
      if ((0x1 & paramArrayOfInt1[0]) == 0) {
        break label91;
      }
      localObject1 = paramArrayOfInt1;
    }
    int i1;
    for (Object localObject2 = paramArrayOfInt2;; localObject2 = paramArrayOfInt1)
    {
      for (i1 = 0; localObject2[i1] == 0; i1++) {}
      i++;
      break;
      label91:
      localObject1 = paramArrayOfInt2;
    }
    if (i1 > 0)
    {
      for (int i8 = 0; i8 < n - i1; i8++) {
        localObject2[i8] = localObject2[(i8 + i1)];
      }
      while (i8 < n)
      {
        localObject2[i8] = 0;
        i8++;
      }
    }
    int i2 = findLowestBit(localObject2[0]);
    if (i2 > 0) {
      rshift((int[])localObject2, (int[])localObject2, 0, n, i2);
    }
    int i3 = cmp((int[])localObject1, (int[])localObject2, n);
    if (i3 == 0)
    {
      if (k + m <= 0) {
        break label372;
      }
      if (m <= 0) {
        break label339;
      }
      int i6 = lshift(paramArrayOfInt1, k, paramArrayOfInt1, n, m);
      if (i6 != 0)
      {
        int i7 = n + 1;
        paramArrayOfInt1[(n + k)] = i6;
        n = i7;
      }
    }
    for (;;)
    {
      int i5 = k;
      for (;;)
      {
        i5--;
        if (i5 < 0) {
          break;
        }
        paramArrayOfInt1[i5] = 0;
      }
      if (i3 > 0)
      {
        sub_n((int[])localObject1, (int[])localObject1, (int[])localObject2, n);
        Object localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      while ((localObject1[(n - 1)] == 0) && (localObject2[(n - 1)] == 0))
      {
        n--;
        continue;
        sub_n((int[])localObject2, (int[])localObject2, (int[])localObject1, n);
      }
      break;
      label339:
      int i4 = n;
      for (;;)
      {
        i4--;
        if (i4 < 0) {
          break;
        }
        paramArrayOfInt1[(i4 + k)] = paramArrayOfInt1[i4];
      }
    }
    n += k;
    label372:
    return n;
  }
  
  public static int intLength(int paramInt)
  {
    if (paramInt < 0) {
      paramInt ^= 0xFFFFFFFF;
    }
    return 32 - count_leading_zeros(paramInt);
  }
  
  public static int intLength(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramInt - 1;
    return intLength(paramArrayOfInt[i]) + i * 32;
  }
  
  public static int lshift(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int paramInt3)
  {
    int i = 32 - paramInt3;
    int j = paramInt2 - 1;
    int k = paramArrayOfInt2[j];
    int m = k >>> i;
    int n = paramInt1 + 1;
    for (;;)
    {
      j--;
      if (j < 0) {
        break;
      }
      int i1 = paramArrayOfInt2[j];
      paramArrayOfInt1[(n + j)] = (k << paramInt3 | i1 >>> i);
      k = i1;
    }
    paramArrayOfInt1[(n + j)] = (k << paramInt3);
    return m;
  }
  
  public static void mul(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int[] paramArrayOfInt3, int paramInt2)
  {
    paramArrayOfInt1[paramInt1] = mul_1(paramArrayOfInt1, paramArrayOfInt2, paramInt1, paramArrayOfInt3[0]);
    for (int i = 1; i < paramInt2; i++)
    {
      long l1 = 0xFFFFFFFF & paramArrayOfInt3[i];
      long l2 = 0L;
      for (int j = 0; j < paramInt1; j++)
      {
        long l3 = l2 + (l1 * (0xFFFFFFFF & paramArrayOfInt2[j]) + (0xFFFFFFFF & paramArrayOfInt1[(i + j)]));
        paramArrayOfInt1[(i + j)] = ((int)l3);
        l2 = l3 >>> 32;
      }
      paramArrayOfInt1[(i + paramInt1)] = ((int)l2);
    }
  }
  
  public static int mul_1(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    long l1 = 0xFFFFFFFF & paramInt2;
    long l2 = 0L;
    for (int i = 0; i < paramInt1; i++)
    {
      long l3 = l2 + l1 * (0xFFFFFFFF & paramArrayOfInt2[i]);
      paramArrayOfInt1[i] = ((int)l3);
      l2 = l3 >>> 32;
    }
    return (int)l2;
  }
  
  public static int rshift(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 32 - paramInt3;
    int j = paramArrayOfInt2[paramInt1];
    int k = j << i;
    for (int m = 1; m < paramInt2; m++)
    {
      int n = paramArrayOfInt2[(paramInt1 + m)];
      paramArrayOfInt1[(m - 1)] = (j >>> paramInt3 | n << i);
      j = n;
    }
    paramArrayOfInt1[(m - 1)] = (j >>> paramInt3);
    return k;
  }
  
  public static void rshift0(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0) {
      rshift(paramArrayOfInt1, paramArrayOfInt2, paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      return;
      for (int i = 0; i < paramInt2; i++) {
        paramArrayOfInt1[i] = paramArrayOfInt2[(i + paramInt1)];
      }
    }
  }
  
  public static long rshift_long(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = paramInt2 >> 5;
    int j = paramInt2 & 0x1F;
    int k;
    int m;
    label30:
    int n;
    int i1;
    label45:
    int i2;
    if (paramArrayOfInt[(paramInt1 - 1)] < 0)
    {
      k = -1;
      if (i < paramInt1) {
        break label119;
      }
      m = k;
      n = i + 1;
      if (n < paramInt1) {
        break label127;
      }
      i1 = k;
      if (j != 0)
      {
        i2 = n + 1;
        if (i2 < paramInt1) {
          break label136;
        }
      }
    }
    label136:
    for (int i3 = k;; i3 = paramArrayOfInt[i2])
    {
      m = m >>> j | i1 << 32 - j;
      i1 = i1 >>> j | i3 << 32 - j;
      return i1 << 32 | 0xFFFFFFFF & m;
      k = 0;
      break;
      label119:
      m = paramArrayOfInt[i];
      break label30;
      label127:
      i1 = paramArrayOfInt[n];
      break label45;
    }
  }
  
  public static int set_str(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i10;
    int k;
    int i14;
    if ((paramInt2 & paramInt2 - 1) == 0)
    {
      int i7 = 0;
      int i8 = 0;
      int i9 = paramInt2;
      for (;;)
      {
        i9 >>= 1;
        if (i9 == 0) {
          break;
        }
        i8++;
      }
      i10 = 0;
      int i11 = paramInt1;
      k = 0;
      i11--;
      if (i11 >= 0)
      {
        int i13 = paramArrayOfByte[i11];
        i10 |= i13 << i7;
        i7 += i8;
        if (i7 < 32) {
          break label296;
        }
        i14 = k + 1;
        paramArrayOfInt[k] = i10;
        i7 -= 32;
        i10 = i13 >> i8 - i7;
      }
    }
    for (;;)
    {
      k = i14;
      break;
      if (i10 != 0)
      {
        int i12 = k + 1;
        paramArrayOfInt[k] = i10;
        return i12;
        int i = chars_per_word(paramInt2);
        int j = 0;
        k = 0;
        if (j < paramInt1)
        {
          int m = paramInt1 - j;
          if (m > i) {
            m = i;
          }
          int n = j + 1;
          int i1 = paramArrayOfByte[j];
          int i2 = paramInt2;
          int i6;
          for (j = n;; j = i6)
          {
            m--;
            if (m <= 0) {
              break;
            }
            int i5 = i1 * paramInt2;
            i6 = j + 1;
            i1 = i5 + paramArrayOfByte[j];
            i2 *= paramInt2;
          }
          int i3;
          label238:
          int i4;
          if (k == 0)
          {
            i3 = i1;
            if (i3 == 0) {
              break label286;
            }
            i4 = k + 1;
            paramArrayOfInt[k] = i3;
          }
          for (;;)
          {
            k = i4;
            break;
            i3 = mul_1(paramArrayOfInt, paramArrayOfInt, k, i2) + add_1(paramArrayOfInt, paramArrayOfInt, k, i1);
            break label238;
            label286:
            i4 = k;
          }
        }
      }
      return k;
      label296:
      i14 = k;
    }
  }
  
  public static int sub_n(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (j < paramInt)
    {
      int k = paramArrayOfInt3[j];
      int m = paramArrayOfInt2[j];
      int n = k + i;
      int i1;
      label47:
      int i2;
      if ((n ^ 0x80000000) < (i ^ 0x80000000))
      {
        i1 = 1;
        i2 = m - n;
        if ((i2 ^ 0x80000000) <= (m ^ 0x80000000)) {
          break label95;
        }
      }
      label95:
      for (int i3 = 1;; i3 = 0)
      {
        i = i1 + i3;
        paramArrayOfInt1[j] = i2;
        j++;
        break;
        i1 = 0;
        break label47;
      }
    }
    return i;
  }
  
  public static int submul_1(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int paramInt3)
  {
    long l1 = 0xFFFFFFFF & paramInt3;
    int i = 0;
    int j = 0;
    long l2 = l1 * (0xFFFFFFFF & paramArrayOfInt2[j]);
    int k = (int)l2;
    int m = (int)(l2 >> 32);
    int n = k + i;
    if ((0x80000000 ^ n) < (0x80000000 ^ i)) {}
    for (int i1 = 1;; i1 = 0)
    {
      i = i1 + m;
      int i2 = paramArrayOfInt1[(paramInt1 + j)];
      int i3 = i2 - n;
      if ((0x80000000 ^ i3) > (0x80000000 ^ i2)) {
        i++;
      }
      paramArrayOfInt1[(paramInt1 + j)] = i3;
      j++;
      if (j < paramInt2) {
        break;
      }
      return i;
    }
  }
  
  public static long udiv_qrnnd(long paramLong, int paramInt)
  {
    long l1 = paramLong >>> 32;
    long l2 = paramLong & 0xFFFFFFFF;
    long l8;
    long l10;
    if (paramInt >= 0) {
      if (l1 < (0xFFFFFFFF & paramInt - l1 - (l2 >>> 31)))
      {
        l8 = paramLong / paramInt;
        l10 = paramLong % paramInt;
      }
    }
    for (;;)
    {
      return l10 << 32 | 0xFFFFFFFF & l8;
      long l11 = paramLong - (paramInt << 31);
      long l12 = l11 / paramInt;
      l10 = l11 % paramInt;
      l8 = l12 - 2147483648L;
      continue;
      long l3 = paramInt >>> 1;
      long l4 = paramLong >>> 1;
      if ((l1 < l3) || (l1 >> 1 < l3))
      {
        if (l1 < l3) {
          l8 = l4 / l3;
        }
        long l7;
        for (long l9 = l4 % l3;; l9 = l3 - 1L - l7)
        {
          l10 = 2L * l9 + (1L & l2);
          if ((paramInt & 0x1) == 0) {
            break;
          }
          if (l10 < l8) {
            break label231;
          }
          l10 -= l8;
          break;
          long l5 = 0xFFFFFFFF ^ l4 - (l3 << 32);
          long l6 = l5 / l3;
          l7 = l5 % l3;
          l8 = 0xFFFFFFFF & (0xFFFFFFFF ^ l6);
        }
        label231:
        if (l8 - l10 <= (0xFFFFFFFF & paramInt))
        {
          l10 = l10 - l8 + paramInt;
          l8 -= 1L;
        }
        else
        {
          l10 = l10 - l8 + paramInt + paramInt;
          l8 -= 2L;
        }
      }
      else if (l2 >= (0xFFFFFFFF & -paramInt))
      {
        l8 = -1L;
        l10 = l2 + paramInt;
      }
      else
      {
        l8 = -2L;
        l10 = l2 + paramInt + paramInt;
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.math.MPN
 * JD-Core Version:    0.7.0.1
 */