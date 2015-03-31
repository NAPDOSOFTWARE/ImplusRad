package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.GenericProc;
import gnu.expr.Language;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.lists.FString;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import java.util.Vector;

public class ClassMethods
  extends Procedure2
{
  public static final ClassMethods classMethods = new ClassMethods();
  
  static
  {
    classMethods.setName("class-methods");
  }
  
  public static MethodProc apply(ObjectType paramObjectType, String paramString, char paramChar, Language paramLanguage)
  {
    PrimProcedure[] arrayOfPrimProcedure = getMethods(paramObjectType, paramString, paramChar, null, paramLanguage);
    GenericProc localGenericProc = null;
    Object localObject = null;
    for (int i = 0; i < arrayOfPrimProcedure.length; i++)
    {
      PrimProcedure localPrimProcedure = arrayOfPrimProcedure[i];
      if ((localObject != null) && (localGenericProc == null))
      {
        localGenericProc = new GenericProc();
        localGenericProc.add((MethodProc)localObject);
      }
      localObject = localPrimProcedure;
      if (localGenericProc != null) {
        localGenericProc.add((MethodProc)localObject);
      }
    }
    if (localGenericProc != null)
    {
      localGenericProc.setName(paramObjectType.getName() + "." + paramString);
      return localGenericProc;
    }
    return localObject;
  }
  
  public static MethodProc apply(Procedure paramProcedure, Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 instanceof Class)) {
      paramObject1 = Type.make((Class)paramObject1);
    }
    ClassType localClassType;
    if ((paramObject1 instanceof ClassType)) {
      localClassType = (ClassType)paramObject1;
    }
    MethodProc localMethodProc;
    while (((paramObject2 instanceof String)) || ((paramObject2 instanceof FString)) || ((paramObject2 instanceof Symbol)))
    {
      String str = paramObject2.toString();
      if (!"<init>".equals(str)) {
        str = Compilation.mangleName(str);
      }
      localMethodProc = apply(localClassType, str, '\000', Language.getDefaultLanguage());
      if (localMethodProc != null) {
        break label182;
      }
      throw new RuntimeException("no applicable method named `" + str + "' in " + localClassType.getName());
      if (((paramObject1 instanceof String)) || ((paramObject1 instanceof FString)) || ((paramObject1 instanceof Symbol))) {
        localClassType = ClassType.make(paramObject1.toString());
      } else {
        throw new WrongType(paramProcedure, 0, null);
      }
    }
    throw new WrongType(paramProcedure, 1, null);
    label182:
    return localMethodProc;
  }
  
  static String checkName(Expression paramExpression)
  {
    boolean bool1 = paramExpression instanceof QuoteExp;
    String str = null;
    Object localObject;
    if (bool1)
    {
      localObject = ((QuoteExp)paramExpression).getValue();
      if ((!(localObject instanceof FString)) && (!(localObject instanceof String))) {
        break label40;
      }
      str = localObject.toString();
    }
    label40:
    boolean bool2;
    do
    {
      return str;
      bool2 = localObject instanceof Symbol;
      str = null;
    } while (!bool2);
    return ((Symbol)localObject).getName();
  }
  
  static String checkName(Expression paramExpression, boolean paramBoolean)
  {
    boolean bool1 = paramExpression instanceof QuoteExp;
    String str = null;
    Object localObject;
    if (bool1)
    {
      localObject = ((QuoteExp)paramExpression).getValue();
      if ((!(localObject instanceof FString)) && (!(localObject instanceof String))) {
        break label51;
      }
    }
    for (str = localObject.toString(); Compilation.isValidJavaName(str); str = ((Symbol)localObject).getName())
    {
      label51:
      boolean bool2;
      do
      {
        return str;
        bool2 = localObject instanceof Symbol;
        str = null;
      } while (!bool2);
    }
    return Compilation.mangleName(str, paramBoolean);
  }
  
  public static PrimProcedure[] getMethods(ObjectType paramObjectType, String paramString, char paramChar, ClassType paramClassType, Language paramLanguage)
  {
    ClassType localClassType = Type.tostring_type;
    if (paramObjectType == localClassType) {
      paramObjectType = Type.string_type;
    }
    ObjectType localObjectType;
    int i;
    label57:
    Vector localVector;
    int j;
    if (paramChar == 'P')
    {
      localObjectType = null;
      MethodFilter localMethodFilter = new MethodFilter(paramString, 0, 0, paramClassType, localObjectType);
      if ((paramChar != 'P') && (!"<init>".equals(paramString))) {
        break label249;
      }
      i = 1;
      localVector = new Vector();
      if (i == 0) {
        break label255;
      }
      j = 0;
      label74:
      paramObjectType.getMethods(localMethodFilter, j, localVector);
      if ((i == 0) && ((!(paramObjectType instanceof ClassType)) || (((ClassType)paramObjectType).isInterface()))) {
        Type.pointer_type.getMethods(localMethodFilter, 0, localVector);
      }
      if (i == 0) {
        break label261;
      }
    }
    PrimProcedure[] arrayOfPrimProcedure;
    label261:
    for (int k = localVector.size();; k = removeRedundantMethods(localVector))
    {
      arrayOfPrimProcedure = new PrimProcedure[k];
      int m = k;
      int i1;
      for (int n = 0;; n = i1)
      {
        m--;
        if (m < 0) {
          break;
        }
        Method localMethod = (Method)localVector.elementAt(m);
        if ((i == 0) && (localMethod.getDeclaringClass() != paramObjectType))
        {
          Type localType = paramObjectType.getImplementationType();
          if ((localType instanceof ClassType)) {
            localMethod = new Method(localMethod, (ClassType)localType);
          }
        }
        PrimProcedure localPrimProcedure = new PrimProcedure(localMethod, paramChar, paramLanguage);
        i1 = n + 1;
        arrayOfPrimProcedure[n] = localPrimProcedure;
      }
      localObjectType = paramObjectType;
      break;
      label249:
      i = 0;
      break label57;
      label255:
      j = 2;
      break label74;
    }
    return arrayOfPrimProcedure;
  }
  
  private static int removeRedundantMethods(Vector paramVector)
  {
    int i = paramVector.size();
    int j = 1;
    while (j < i)
    {
      Method localMethod1 = (Method)paramVector.elementAt(j);
      ClassType localClassType = localMethod1.getDeclaringClass();
      Type[] arrayOfType1 = localMethod1.getParameterTypes();
      int k = arrayOfType1.length;
      int m = 0;
      if (m < j)
      {
        Method localMethod2 = (Method)paramVector.elementAt(m);
        Type[] arrayOfType2 = localMethod2.getParameterTypes();
        if (k != arrayOfType2.length) {}
        int n;
        do
        {
          m++;
          break;
          n = k;
          do
          {
            n--;
          } while ((n >= 0) && (arrayOfType1[n] == arrayOfType2[n]));
        } while (n >= 0);
        if (localClassType.isSubtype(localMethod2.getDeclaringClass())) {
          paramVector.setElementAt(localMethod1, m);
        }
        paramVector.setElementAt(paramVector.elementAt(i - 1), j);
        i--;
      }
      else
      {
        j++;
      }
    }
    return i;
  }
  
  public static int selectApplicable(PrimProcedure[] paramArrayOfPrimProcedure, int paramInt)
  {
    int i = paramArrayOfPrimProcedure.length;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    while (n < i)
    {
      int i1 = paramArrayOfPrimProcedure[n].numArgs();
      int i2 = Procedure.minArgs(i1);
      int i3 = Procedure.maxArgs(i1);
      int i4 = 0;
      if (paramInt < i2) {
        k++;
      }
      for (;;)
      {
        if (i4 == 0) {
          break label95;
        }
        m++;
        n++;
        break;
        if ((paramInt > i3) && (i3 >= 0))
        {
          j++;
          i4 = 0;
        }
        else
        {
          i4 = 1;
        }
      }
      label95:
      PrimProcedure localPrimProcedure = paramArrayOfPrimProcedure[(i - 1)];
      paramArrayOfPrimProcedure[(i - 1)] = paramArrayOfPrimProcedure[n];
      paramArrayOfPrimProcedure[n] = localPrimProcedure;
      i--;
    }
    if (m > 0) {
      return m;
    }
    if (k > 0) {
      return -983040;
    }
    if (j > 0) {
      return -917504;
    }
    return 0;
  }
  
  public static long selectApplicable(PrimProcedure[] paramArrayOfPrimProcedure, Type[] paramArrayOfType)
  {
    int i = paramArrayOfPrimProcedure.length;
    int j = 0;
    int k = 0;
    int m = 0;
    while (m < i)
    {
      int n = paramArrayOfPrimProcedure[m].isApplicable(paramArrayOfType);
      if (n < 0)
      {
        PrimProcedure localPrimProcedure2 = paramArrayOfPrimProcedure[(i - 1)];
        paramArrayOfPrimProcedure[(i - 1)] = paramArrayOfPrimProcedure[m];
        paramArrayOfPrimProcedure[m] = localPrimProcedure2;
        i--;
      }
      else if (n > 0)
      {
        PrimProcedure localPrimProcedure1 = paramArrayOfPrimProcedure[j];
        paramArrayOfPrimProcedure[j] = paramArrayOfPrimProcedure[m];
        paramArrayOfPrimProcedure[m] = localPrimProcedure1;
        j++;
        m++;
      }
      else
      {
        k++;
        m++;
      }
    }
    return (j << 32) + k;
  }
  
  public Object apply2(Object paramObject1, Object paramObject2)
  {
    return apply(this, paramObject1, paramObject2);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.ClassMethods
 * JD-Core Version:    0.7.0.1
 */