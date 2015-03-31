package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.lists.ItemPredicate;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class OccurrenceType
  extends ObjectType
  implements Externalizable, TypeValue
{
  public static final Type emptySequenceType = getInstance(SingletonType.instance, 0, 0);
  static final Method isInstanceMethod = typeOccurrenceType.getDeclaredMethod("isInstance", 1);
  public static final ClassType typeOccurrenceType = ClassType.make("gnu.kawa.reflect.OccurrenceType");
  Type base;
  int maxOccurs;
  int minOccurs;
  
  public OccurrenceType(Type paramType, int paramInt1, int paramInt2)
  {
    this.base = paramType;
    this.minOccurs = paramInt1;
    this.maxOccurs = paramInt2;
  }
  
  public static Type getInstance(Type paramType, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (paramInt2 == 1)) {
      return paramType;
    }
    if ((paramInt1 == 0) && (paramInt2 < 0) && ((paramType == SingletonType.instance) || (paramType == Type.pointer_type))) {
      return Type.pointer_type;
    }
    return new OccurrenceType(paramType, paramInt1, paramInt2);
  }
  
  public static char itemCountCode(Type paramType)
  {
    int i = itemCountRange(paramType);
    int j = i & 0xFFF;
    int k = i >> 12;
    if (k == 0) {
      return '0';
    }
    if (j == 0)
    {
      if (k == 1) {
        return '?';
      }
      return '*';
    }
    if ((j == 1) && (k == 1)) {
      return '1';
    }
    return '+';
  }
  
  public static boolean itemCountIsOne(Type paramType)
  {
    return itemCountRange(paramType) == 4097;
  }
  
  public static boolean itemCountIsZeroOrOne(Type paramType)
  {
    return itemCountRange(paramType) >> 13 == 0;
  }
  
  public static int itemCountRange(Type paramType)
  {
    if ((paramType instanceof SingletonType)) {}
    label169:
    do
    {
      return 4097;
      if ((paramType instanceof OccurrenceType))
      {
        OccurrenceType localOccurrenceType = (OccurrenceType)paramType;
        int j = localOccurrenceType.minOccurs();
        int k = localOccurrenceType.maxOccurs();
        int m = itemCountRange(localOccurrenceType.getBase());
        if (((j == 1) && (k == 1)) || (m == 0)) {
          return m;
        }
        if (k > 1048575) {
          k = -1;
        }
        if (k == 0) {
          return 0;
        }
        int n = m & 0xFFF;
        int i1 = m >> 12;
        if (m != 4097)
        {
          if (j > 4095) {
            j = 4095;
          }
          j *= n;
          if (j > 4095) {
            j = 4095;
          }
          if ((k >= 0) && (i1 >= 0)) {
            break label169;
          }
          k = -1;
        }
        for (;;)
        {
          if (k > 1048575) {
            k = -1;
          }
          return j | k << 12;
          k *= i1;
        }
      }
      if ((paramType instanceof PrimType))
      {
        boolean bool = paramType.isVoid();
        int i = 0;
        if (bool) {}
        for (;;)
        {
          return i;
          i = 4097;
        }
      }
    } while (((paramType instanceof ArrayType)) || (((paramType instanceof ObjectType)) && (paramType.compare(Compilation.typeValues) == -3)));
    return -4096;
  }
  
  public static Type itemPrimeType(Type paramType)
  {
    while ((paramType instanceof OccurrenceType)) {
      paramType = ((OccurrenceType)paramType).getBase();
    }
    if (itemCountIsOne(paramType)) {
      return paramType;
    }
    return SingletonType.instance;
  }
  
  public Object coerceFromObject(Object paramObject)
  {
    if ((paramObject instanceof Values)) {}
    while (!isInstance(paramObject))
    {
      throw new ClassCastException();
      if ((this.minOccurs <= 1) && (this.maxOccurs != 0)) {
        paramObject = this.base.coerceFromObject(paramObject);
      }
    }
    return paramObject;
  }
  
  public int compare(Type paramType)
  {
    if ((paramType instanceof OccurrenceType))
    {
      OccurrenceType localOccurrenceType = (OccurrenceType)paramType;
      if ((this.minOccurs == localOccurrenceType.minOccurs) && (this.maxOccurs == localOccurrenceType.maxOccurs)) {
        return this.base.compare(localOccurrenceType.getBase());
      }
    }
    return -2;
  }
  
  public Expression convertValue(Expression paramExpression)
  {
    return null;
  }
  
  public void emitIsInstance(Variable paramVariable, Compilation paramCompilation, Target paramTarget)
  {
    InstanceOf.emitIsInstance(this, paramVariable, paramCompilation, paramTarget);
  }
  
  public void emitTestIf(Variable paramVariable, Declaration paramDeclaration, Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    if (paramVariable != null) {
      localCodeAttr.emitLoad(paramVariable);
    }
    if (paramDeclaration != null)
    {
      localCodeAttr.emitDup();
      paramDeclaration.compileStore(paramCompilation);
    }
    paramCompilation.compileConstant(this);
    localCodeAttr.emitSwap();
    localCodeAttr.emitInvokeVirtual(isInstanceMethod);
    localCodeAttr.emitIfIntNotZero();
  }
  
  public Type getBase()
  {
    return this.base;
  }
  
  public Procedure getConstructor()
  {
    return null;
  }
  
  public Type getImplementationType()
  {
    return Type.pointer_type;
  }
  
  public boolean isInstance(Object paramObject)
  {
    int i = 1;
    Values localValues;
    int m;
    int n;
    boolean bool3;
    boolean bool1;
    if ((paramObject instanceof Values))
    {
      localValues = (Values)paramObject;
      m = localValues.startPos();
      boolean bool2 = this.base instanceof ItemPredicate;
      n = 0;
      if (bool2)
      {
        ItemPredicate localItemPredicate = (ItemPredicate)this.base;
        bool3 = localItemPredicate.isInstancePos(localValues, m);
        m = localValues.nextPos(m);
        if (m == 0) {
          if ((n >= this.minOccurs) && ((this.maxOccurs < 0) || (n <= this.maxOccurs))) {
            bool1 = i;
          }
        }
      }
    }
    int k;
    do
    {
      int j;
      do
      {
        do
        {
          return bool1;
          i = 0;
          break;
          bool1 = false;
        } while (!bool3);
        n++;
        break;
        Object localObject;
        do
        {
          n++;
          m = localValues.nextPos(m);
          if (m == 0)
          {
            if ((n >= this.minOccurs) && ((this.maxOccurs < 0) || (n <= this.maxOccurs))) {}
            for (;;)
            {
              return i;
              i = 0;
            }
          }
          localObject = localValues.getPosPrevious(m);
        } while (this.base.isInstance(localObject));
        return false;
        j = this.minOccurs;
        bool1 = false;
      } while (j > i);
      k = this.maxOccurs;
      bool1 = false;
    } while (k == 0);
    return this.base.isInstance(paramObject);
  }
  
  public int maxOccurs()
  {
    return this.maxOccurs;
  }
  
  public int minOccurs()
  {
    return this.minOccurs;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.base = ((Type)paramObjectInput.readObject());
    this.minOccurs = paramObjectInput.readInt();
    this.maxOccurs = paramObjectInput.readInt();
  }
  
  public String toString()
  {
    String str = this.base.toString();
    int i;
    StringBuffer localStringBuffer;
    if ((str == null) || (str.indexOf(' ') >= 0))
    {
      i = 1;
      localStringBuffer = new StringBuffer();
      if (i != 0) {
        localStringBuffer.append('(');
      }
      localStringBuffer.append(str);
      if (i != 0) {
        localStringBuffer.append(')');
      }
      if ((this.minOccurs != 1) || (this.maxOccurs != 1)) {
        break label85;
      }
    }
    for (;;)
    {
      return localStringBuffer.toString();
      i = 0;
      break;
      label85:
      if ((this.minOccurs == 0) && (this.maxOccurs == 1))
      {
        localStringBuffer.append('?');
      }
      else if ((this.minOccurs == 1) && (this.maxOccurs == -1))
      {
        localStringBuffer.append('+');
      }
      else
      {
        if ((this.minOccurs != 0) || (this.maxOccurs != -1)) {
          break label161;
        }
        localStringBuffer.append('*');
      }
    }
    label161:
    localStringBuffer.append('{');
    localStringBuffer.append(this.minOccurs);
    localStringBuffer.append(',');
    if (this.maxOccurs >= 0) {
      localStringBuffer.append(this.maxOccurs);
    }
    for (;;)
    {
      localStringBuffer.append('}');
      break;
      localStringBuffer.append('*');
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.base);
    paramObjectOutput.writeInt(this.minOccurs);
    paramObjectOutput.writeInt(this.maxOccurs);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.OccurrenceType
 * JD-Core Version:    0.7.0.1
 */