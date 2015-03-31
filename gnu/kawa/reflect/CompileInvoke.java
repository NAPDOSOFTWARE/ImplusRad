package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.PairClassType;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.TypeValue;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;

public class CompileInvoke
{
  private static void append(PrimProcedure[] paramArrayOfPrimProcedure, int paramInt, StringBuffer paramStringBuffer)
  {
    for (int i = 0; i < paramInt; i++)
    {
      paramStringBuffer.append("\n  candidate: ");
      paramStringBuffer.append(paramArrayOfPrimProcedure[i]);
    }
  }
  
  static Object[] checkKeywords(ObjectType paramObjectType, Expression[] paramArrayOfExpression, int paramInt, ClassType paramClassType)
  {
    int i = paramArrayOfExpression.length;
    for (int j = 0; (1 + (paramInt + j * 2) < i) && ((paramArrayOfExpression[(paramInt + j * 2)].valueIfConstant() instanceof Keyword)); j++) {}
    Object[] arrayOfObject = new Object[j];
    int k = 0;
    if (k < j)
    {
      String str = ((Keyword)paramArrayOfExpression[(paramInt + k * 2)].valueIfConstant()).getName();
      Object localObject = SlotSet.lookupMember(paramObjectType, str, paramClassType);
      if (localObject == null) {
        localObject = paramObjectType.getMethod(ClassExp.slotToMethodName("add", str), SlotSet.type1Array);
      }
      if (localObject != null) {}
      for (;;)
      {
        arrayOfObject[k] = localObject;
        k++;
        break;
        localObject = str;
      }
    }
    return arrayOfObject;
  }
  
  private static String getMethodName(Expression[] paramArrayOfExpression, char paramChar)
  {
    if (paramChar == 'N') {
      return "<init>";
    }
    if (paramChar == 'P') {}
    for (int i = 2; paramArrayOfExpression.length >= i + 1; i = 1) {
      return ClassMethods.checkName(paramArrayOfExpression[i], false);
    }
    return null;
  }
  
  protected static PrimProcedure[] getMethods(ObjectType paramObjectType, String paramString, ClassType paramClassType, Invoke paramInvoke)
  {
    char c1 = 'P';
    char c2 = paramInvoke.kind;
    if (c2 == c1) {}
    for (;;)
    {
      return ClassMethods.getMethods(paramObjectType, paramString, c1, paramClassType, paramInvoke.language);
      if ((c2 == '*') || (c2 == 'V')) {
        c1 = 'V';
      } else {
        c1 = '\000';
      }
    }
  }
  
  public static PrimProcedure getStaticMethod(ClassType paramClassType, String paramString, Expression[] paramArrayOfExpression)
  {
    for (;;)
    {
      try
      {
        PrimProcedure[] arrayOfPrimProcedure = getMethods(paramClassType, paramString, null, Invoke.invokeStatic);
        long l = selectApplicable(arrayOfPrimProcedure, paramClassType, paramArrayOfExpression, paramArrayOfExpression.length, 0, -1);
        int i = (int)(l >> 32);
        int j = (int)l;
        if (arrayOfPrimProcedure == null)
        {
          k = -1;
          if (k < 0)
          {
            localPrimProcedure = null;
            return localPrimProcedure;
          }
        }
        else
        {
          if (i <= 0) {
            break label95;
          }
          k = MethodProc.mostSpecific(arrayOfPrimProcedure, i);
          continue;
        }
        PrimProcedure localPrimProcedure = arrayOfPrimProcedure[k];
        continue;
        if (j != 1) {
          break label107;
        }
      }
      finally {}
      label95:
      int k = 0;
      continue;
      label107:
      k = -1;
    }
  }
  
  static int hasKeywordArgument(int paramInt, Expression[] paramArrayOfExpression)
  {
    for (int i = paramInt; i < paramArrayOfExpression.length; i++) {
      if ((paramArrayOfExpression[i].valueIfConstant() instanceof Keyword)) {
        return i;
      }
    }
    return paramArrayOfExpression.length;
  }
  
  private static long selectApplicable(PrimProcedure[] paramArrayOfPrimProcedure, ObjectType paramObjectType, Expression[] paramArrayOfExpression, int paramInt1, int paramInt2, int paramInt3)
  {
    Type[] arrayOfType = new Type[paramInt1];
    int i = 0;
    if (paramInt3 >= 0)
    {
      int k = 0 + 1;
      arrayOfType[0] = paramObjectType;
      i = k;
    }
    int j = paramInt2;
    if ((j < paramArrayOfExpression.length) && (i < arrayOfType.length))
    {
      Expression localExpression = paramArrayOfExpression[j];
      Object localObject;
      if (InlineCalls.checkIntValue(localExpression) != null) {
        localObject = Type.intType;
      }
      for (;;)
      {
        arrayOfType[i] = localObject;
        j++;
        i++;
        break;
        if (InlineCalls.checkLongValue(localExpression) != null)
        {
          localObject = Type.longType;
        }
        else
        {
          localObject = null;
          if (0 == 0) {
            localObject = localExpression.getType();
          }
        }
      }
    }
    return ClassMethods.selectApplicable(paramArrayOfPrimProcedure, arrayOfType);
  }
  
  public static Expression validateApplyInvoke(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    Invoke localInvoke1 = (Invoke)paramProcedure;
    char c1 = localInvoke1.kind;
    Compilation localCompilation = paramInlineCalls.getCompilation();
    Expression[] arrayOfExpression1 = paramApplyExp.getArgs();
    int i = arrayOfExpression1.length;
    if ((!localCompilation.mustCompile) || (i == 0) || (((c1 == 'V') || (c1 == '*')) && (i == 1)))
    {
      paramApplyExp.visitArgs(paramInlineCalls);
      return paramApplyExp;
    }
    Expression localExpression1 = paramInlineCalls.visit(arrayOfExpression1[0], null);
    arrayOfExpression1[0] = localExpression1;
    Type localType1;
    Object localObject1;
    label133:
    String str1;
    int j;
    int k;
    int m;
    if ((c1 == 'V') || (c1 == '*'))
    {
      localType1 = localExpression1.getType();
      if ((!(localType1 instanceof PairClassType)) || (c1 != 'N')) {
        break label414;
      }
      localObject1 = ((PairClassType)localType1).instanceType;
      str1 = getMethodName(arrayOfExpression1, c1);
      if ((c1 != 'V') && (c1 != '*')) {
        break label438;
      }
      j = i - 1;
      k = 2;
      m = 0;
    }
    for (;;)
    {
      if ((c1 == 'N') && ((localObject1 instanceof ArrayType)))
      {
        ArrayType localArrayType = (ArrayType)localObject1;
        Type localType4 = localArrayType.getComponentType();
        int i28 = arrayOfExpression1.length;
        int i29 = 0;
        Object localObject7 = null;
        if (i28 >= 3)
        {
          boolean bool1 = arrayOfExpression1[1] instanceof QuoteExp;
          i29 = 0;
          localObject7 = null;
          if (bool1)
          {
            Object localObject9 = ((QuoteExp)arrayOfExpression1[1]).getValue();
            boolean bool2 = localObject9 instanceof Keyword;
            i29 = 0;
            localObject7 = null;
            if (bool2)
            {
              String str4 = ((Keyword)localObject9).getName();
              if (!"length".equals(str4))
              {
                boolean bool3 = "size".equals(str4);
                i29 = 0;
                localObject7 = null;
                if (!bool3) {}
              }
              else
              {
                localObject7 = arrayOfExpression1[2];
                i29 = 1;
              }
            }
          }
        }
        if (localObject7 == null) {
          localObject7 = QuoteExp.getInstance(new Integer(-1 + arrayOfExpression1.length));
        }
        PrimType localPrimType = Type.intType;
        Expression localExpression3 = paramInlineCalls.visit((Expression)localObject7, localPrimType);
        ApplyExp localApplyExp3 = new ApplyExp(new ArrayNew(localType4), new Expression[] { localExpression3 });
        localApplyExp3.setType(localArrayType);
        if ((i29 != 0) && (arrayOfExpression1.length == 3))
        {
          return localApplyExp3;
          localType1 = localInvoke1.language.getTypeFor(localExpression1);
          break;
          label414:
          if ((localType1 instanceof ObjectType))
          {
            localObject1 = (ObjectType)localType1;
            break label133;
          }
          localObject1 = null;
          break label133;
          label438:
          if (c1 == 'N')
          {
            j = i;
            m = -1;
            k = 0;
            continue;
          }
          if ((c1 == 'S') || (c1 == 's'))
          {
            j = i - 2;
            k = 2;
            m = -1;
            continue;
          }
          if (c1 == 'P')
          {
            j = i - 2;
            k = 3;
            m = 1;
            continue;
          }
          paramApplyExp.visitArgs(paramInlineCalls);
          return paramApplyExp;
        }
        LetExp localLetExp2 = new LetExp(new Expression[] { localApplyExp3 });
        Declaration localDeclaration2 = localLetExp2.addDeclaration((String)null, localArrayType);
        localDeclaration2.noteValue(localApplyExp3);
        BeginExp localBeginExp2 = new BeginExp();
        int i30 = 0;
        int i31;
        if (i29 != 0) {
          i31 = 3;
        }
        String str3;
        for (;;)
        {
          int i32 = arrayOfExpression1.length;
          if (i31 >= i32) {
            break;
          }
          Expression localExpression4 = arrayOfExpression1[i31];
          if ((i29 != 0) && (i31 + 1 < arrayOfExpression1.length) && ((localExpression4 instanceof QuoteExp)))
          {
            Object localObject8 = ((QuoteExp)localExpression4).getValue();
            if ((localObject8 instanceof Keyword)) {
              str3 = ((Keyword)localObject8).getName();
            }
          }
          try
          {
            i30 = Integer.parseInt(str3);
            i31++;
            localExpression4 = arrayOfExpression1[i31];
            Expression localExpression5 = paramInlineCalls.visit(localExpression4, localType4);
            ArraySet localArraySet = new ArraySet(localType4);
            Expression[] arrayOfExpression8 = new Expression[3];
            arrayOfExpression8[0] = new ReferenceExp(localDeclaration2);
            arrayOfExpression8[1] = QuoteExp.getInstance(new Integer(i30));
            arrayOfExpression8[2] = localExpression5;
            localBeginExp2.add(new ApplyExp(localArraySet, arrayOfExpression8));
            i30++;
            i31++;
          }
          catch (Throwable localThrowable)
          {
            localCompilation.error('e', "non-integer keyword '" + str3 + "' in array constructor");
            return paramApplyExp;
          }
          i31 = 1;
          i30 = 0;
        }
        localBeginExp2.add(new ReferenceExp(localDeclaration2));
        localLetExp2.body = localBeginExp2;
        return localLetExp2;
      }
    }
    if ((localObject1 != null) && (str1 != null))
    {
      if (((localObject1 instanceof TypeValue)) && (c1 == 'N'))
      {
        Procedure localProcedure = ((TypeValue)localObject1).getConstructor();
        if (localProcedure != null)
        {
          Expression[] arrayOfExpression7 = new Expression[i - 1];
          System.arraycopy(arrayOfExpression1, 1, arrayOfExpression7, 0, i - 1);
          return paramInlineCalls.visit(new ApplyExp(localProcedure, arrayOfExpression7), paramType);
        }
      }
      ClassType localClassType;
      Object localObject2;
      if (localCompilation == null)
      {
        localClassType = null;
        localObject2 = localObject1;
      }
      PrimProcedure[] arrayOfPrimProcedure;
      int n;
      int i1;
      int i19;
      Object[] arrayOfObject;
      StringBuffer localStringBuffer3;
      for (;;)
      {
        try
        {
          arrayOfPrimProcedure = getMethods(localObject2, str1, localClassType, localInvoke1);
          n = ClassMethods.selectApplicable(arrayOfPrimProcedure, j);
          i1 = -1;
          if (c1 != 'N') {
            break label1720;
          }
          i19 = hasKeywordArgument(1, arrayOfExpression1);
          if (i19 >= arrayOfExpression1.length)
          {
            if (n > 0) {
              break label1720;
            }
            Type[] arrayOfType = new Type[1];
            arrayOfType[0] = Compilation.typeClassType;
            if (ClassMethods.selectApplicable(arrayOfPrimProcedure, arrayOfType) >> 32 != 1L) {
              break label1720;
            }
          }
          arrayOfObject = checkKeywords(localObject2, arrayOfExpression1, i19, localClassType);
          if ((2 * arrayOfObject.length != arrayOfExpression1.length - i19) && (ClassMethods.selectApplicable(ClassMethods.getMethods(localObject2, "add", 'V', null, localInvoke1.language), 2) <= 0)) {
            break label1720;
          }
          localStringBuffer3 = null;
          int i20 = 0;
          int i21 = arrayOfObject.length;
          if (i20 >= i21) {
            break label1204;
          }
          if ((arrayOfObject[i20] instanceof String))
          {
            if (localStringBuffer3 == null)
            {
              localStringBuffer3 = new StringBuffer();
              localStringBuffer3.append("no field or setter ");
              localStringBuffer3.append('`');
              Object localObject6 = arrayOfObject[i20];
              localStringBuffer3.append(localObject6);
              localStringBuffer3.append('\'');
            }
          }
          else
          {
            i20++;
            continue;
            if (localCompilation.curClass != null)
            {
              localClassType = localCompilation.curClass;
              break;
            }
            localClassType = localCompilation.mainClass;
          }
        }
        catch (Exception localException)
        {
          localCompilation.error('w', "unknown class: " + ((ObjectType)localObject1).getName());
          return paramApplyExp;
        }
        localStringBuffer3.append(", ");
      }
      label1204:
      if (localStringBuffer3 != null)
      {
        localStringBuffer3.append(" in class ");
        String str2 = ((ObjectType)localObject1).getName();
        localStringBuffer3.append(str2);
        localCompilation.error('w', localStringBuffer3.toString());
        return paramApplyExp;
      }
      ApplyExp localApplyExp2;
      int i22;
      label1317:
      Object localObject5;
      Type localType3;
      if (i19 < arrayOfExpression1.length)
      {
        Expression[] arrayOfExpression6 = new Expression[i19];
        System.arraycopy(arrayOfExpression1, 0, arrayOfExpression6, 0, i19);
        localApplyExp2 = (ApplyExp)paramInlineCalls.visit(new ApplyExp(paramApplyExp.getFunction(), arrayOfExpression6), localObject2);
        localApplyExp2.setType(localObject2);
        localObject4 = localApplyExp2;
        if (arrayOfExpression1.length <= 0) {
          break label1708;
        }
        i22 = 0;
        int i23 = arrayOfObject.length;
        if (i22 >= i23) {
          break label1515;
        }
        localObject5 = arrayOfObject[i22];
        if (!(localObject5 instanceof Method)) {
          break label1488;
        }
        localType3 = ((Method)localObject5).getParameterTypes()[0];
      }
      for (;;)
      {
        if (localType3 != null) {
          localType3 = localInvoke1.language.getLangTypeFor(localType3);
        }
        Expression localExpression2 = paramInlineCalls.visit(arrayOfExpression1[(1 + (i19 + i22 * 2))], localType3);
        Expression[] arrayOfExpression5 = new Expression[3];
        arrayOfExpression5[0] = localApplyExp2;
        arrayOfExpression5[1] = new QuoteExp(localObject5);
        arrayOfExpression5[2] = localExpression2;
        SlotSet localSlotSet = SlotSet.setFieldReturnObject;
        localApplyExp2 = new ApplyExp(localSlotSet, arrayOfExpression5);
        localApplyExp2.setType(localObject2);
        i22++;
        break label1317;
        PrimProcedure localPrimProcedure3 = arrayOfPrimProcedure[0];
        Expression[] arrayOfExpression3 = { localExpression1 };
        localApplyExp2 = new ApplyExp(localPrimProcedure3, arrayOfExpression3);
        break;
        label1488:
        if ((localObject5 instanceof Field)) {
          localType3 = ((Field)localObject5).getType();
        } else {
          localType3 = null;
        }
      }
      label1515:
      if (i19 == arrayOfExpression1.length) {}
      LetExp localLetExp1;
      Declaration localDeclaration1;
      BeginExp localBeginExp1;
      for (int i24 = 1;; i24 = i19 + 2 * arrayOfObject.length)
      {
        localObject4 = localApplyExp2;
        int i25 = arrayOfExpression1.length;
        if (i24 >= i25) {
          break label1708;
        }
        localLetExp1 = new LetExp(new Expression[] { localObject4 });
        localDeclaration1 = localLetExp1.addDeclaration((String)null, localObject2);
        localDeclaration1.noteValue((Expression)localObject4);
        localBeginExp1 = new BeginExp();
        for (int i26 = i24;; i26++)
        {
          int i27 = arrayOfExpression1.length;
          if (i26 >= i27) {
            break;
          }
          Expression[] arrayOfExpression4 = new Expression[3];
          arrayOfExpression4[0] = new ReferenceExp(localDeclaration1);
          arrayOfExpression4[1] = QuoteExp.getInstance("add");
          arrayOfExpression4[2] = arrayOfExpression1[i26];
          localBeginExp1.add(paramInlineCalls.visit(new ApplyExp(Invoke.invoke, arrayOfExpression4), null));
        }
      }
      localBeginExp1.add(new ReferenceExp(localDeclaration1));
      localLetExp1.body = localBeginExp1;
      Object localObject4 = localLetExp1;
      label1708:
      return paramInlineCalls.checkType(((Expression)localObject4).setLine(paramApplyExp), paramType);
      label1720:
      label1751:
      label1888:
      int i3;
      label1808:
      label1846:
      label1856:
      label1995:
      int i2;
      label1939:
      label1945:
      StringBuilder localStringBuilder;
      label2184:
      char c4;
      if (n >= 0)
      {
        int i11 = 1;
        if (i11 < i)
        {
          int i12 = i - 1;
          int i13;
          Object localObject3;
          if (i11 == i12)
          {
            i13 = 1;
            if (((c1 != 'P') || (i11 != 2)) && ((c1 == 'N') || (i11 != 1))) {
              break label1808;
            }
            localObject3 = null;
          }
          for (;;)
          {
            arrayOfExpression1[i11] = paramInlineCalls.visit(arrayOfExpression1[i11], (Type)localObject3);
            i11++;
            break;
            i13 = 0;
            break label1751;
            if ((c1 == 'P') && (i11 == 1))
            {
              localObject3 = localObject2;
            }
            else
            {
              localObject3 = null;
              if (n > 0)
              {
                int i14;
                int i16;
                PrimProcedure localPrimProcedure2;
                int i17;
                int i18;
                if (c1 == 'N')
                {
                  i14 = 1;
                  int i15 = i11 - i14;
                  i16 = 0;
                  if (i16 < n)
                  {
                    localPrimProcedure2 = arrayOfPrimProcedure[i16];
                    if ((c1 == 'S') || (!localPrimProcedure2.takesTarget())) {
                      break label1939;
                    }
                    i17 = 1;
                    i18 = i15 + i17;
                    if ((i13 == 0) || (!localPrimProcedure2.takesVarArgs()) || (i18 != localPrimProcedure2.minArgs())) {
                      break label1945;
                    }
                    localObject3 = null;
                  }
                }
                for (;;)
                {
                  if (localObject3 == null) {
                    break label1995;
                  }
                  i16++;
                  break label1856;
                  break;
                  i14 = k;
                  break label1846;
                  i17 = 0;
                  break label1888;
                  Type localType2 = localPrimProcedure2.getParameterType(i18);
                  if (i16 == 0) {
                    localObject3 = localType2;
                  } else if (localType2 instanceof PrimType != localObject3 instanceof PrimType) {
                    localObject3 = null;
                  } else {
                    localObject3 = Type.lowestCommonSuperType((Type)localObject3, localType2);
                  }
                }
              }
            }
          }
        }
        long l2 = selectApplicable(arrayOfPrimProcedure, localObject2, arrayOfExpression1, j, k, m);
        i3 = (int)(l2 >> 32);
        i2 = (int)l2;
        int i4 = arrayOfPrimProcedure.length;
        if ((i3 + i2 == 0) && (c1 == 'N'))
        {
          Invoke localInvoke2 = Invoke.invokeStatic;
          arrayOfPrimProcedure = getMethods(localObject2, "valueOf", localClassType, localInvoke2);
          k = 1;
          j = i - 1;
          long l1 = selectApplicable(arrayOfPrimProcedure, localObject2, arrayOfExpression1, j, k, -1);
          i3 = (int)(l1 >> 32);
          i2 = (int)l1;
        }
        if (i3 + i2 != 0) {
          break label2401;
        }
        if ((c1 == 'P') || (localCompilation.warnInvokeUnknownMethod()))
        {
          if (c1 == 'N') {
            str1 = str1 + "/valueOf";
          }
          localStringBuilder = new StringBuilder();
          if (i4 + arrayOfPrimProcedure.length != 0) {
            break label2342;
          }
          localStringBuilder.append("no accessible method '");
          localStringBuilder.append(str1);
          localStringBuilder.append("' in ");
          localStringBuilder.append(((ObjectType)localObject1).getName());
          if (c1 != 'P') {
            break label2394;
          }
          c4 = 'e';
          label2223:
          localCompilation.error(c4, localStringBuilder.toString());
        }
      }
      label2580:
      for (;;)
      {
        label2453:
        label2584:
        if (i1 >= 0)
        {
          Expression[] arrayOfExpression2 = new Expression[j];
          PrimProcedure localPrimProcedure1 = arrayOfPrimProcedure[i1];
          localPrimProcedure1.takesVarArgs();
          int i5 = 0;
          if (m >= 0)
          {
            int i9 = 0 + 1;
            arrayOfExpression2[0] = arrayOfExpression1[m];
            i5 = i9;
          }
          int i6 = k;
          for (;;)
          {
            int i7 = arrayOfExpression1.length;
            if (i6 >= i7) {
              break;
            }
            int i8 = arrayOfExpression2.length;
            if (i5 >= i8) {
              break;
            }
            arrayOfExpression2[i5] = arrayOfExpression1[i6];
            i6++;
            i5++;
          }
          i2 = 0;
          i3 = 0;
          break;
          label2342:
          if (n == -983040)
          {
            localStringBuilder.append("too few arguments for method '");
            break label2184;
          }
          if (n == -917504)
          {
            localStringBuilder.append("too many arguments for method '");
            break label2184;
          }
          localStringBuilder.append("no possibly applicable method '");
          break label2184;
          label2394:
          c4 = 'w';
          break label2223;
          label2401:
          if ((i3 == 1) || ((i3 == 0) && (i2 == 1)))
          {
            i1 = 0;
          }
          else if (i3 > 0)
          {
            i1 = MethodProc.mostSpecific(arrayOfPrimProcedure, i3);
            int i10;
            if ((i1 < 0) && (c1 == 'S'))
            {
              i10 = 0;
              if (i10 < i3)
              {
                if (!arrayOfPrimProcedure[i10].getStaticFlag()) {
                  break label2584;
                }
                if (i1 < 0) {
                  break label2580;
                }
                i1 = -1;
              }
            }
            if ((i1 < 0) && ((c1 == 'P') || (localCompilation.warnInvokeUnknownMethod())))
            {
              StringBuffer localStringBuffer2 = new StringBuffer();
              localStringBuffer2.append("more than one definitely applicable method `");
              localStringBuffer2.append(str1);
              localStringBuffer2.append("' in ");
              localStringBuffer2.append(((ObjectType)localObject1).getName());
              append(arrayOfPrimProcedure, i3, localStringBuffer2);
              if (c1 == 'P') {}
              for (char c3 = 'e';; c3 = 'w')
              {
                localCompilation.error(c3, localStringBuffer2.toString());
                break;
                i1 = i10;
                i10++;
                break label2453;
              }
            }
          }
          else if ((c1 == 'P') || (localCompilation.warnInvokeUnknownMethod()))
          {
            StringBuffer localStringBuffer1 = new StringBuffer();
            localStringBuffer1.append("more than one possibly applicable method '");
            localStringBuffer1.append(str1);
            localStringBuffer1.append("' in ");
            localStringBuffer1.append(((ObjectType)localObject1).getName());
            append(arrayOfPrimProcedure, i2, localStringBuffer1);
            if (c1 == 'P') {}
            for (char c2 = 'e';; c2 = 'w')
            {
              localCompilation.error(c2, localStringBuffer1.toString());
              break;
            }
            ApplyExp localApplyExp1 = new ApplyExp(localPrimProcedure1, arrayOfExpression2);
            localApplyExp1.setLine(paramApplyExp);
            return paramInlineCalls.visitApplyOnly(localApplyExp1, paramType);
          }
        }
      }
    }
    paramApplyExp.visitArgs(paramInlineCalls);
    return paramApplyExp;
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.CompileInvoke
 * JD-Core Version:    0.7.0.1
 */