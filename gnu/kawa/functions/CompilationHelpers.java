package gnu.kawa.functions;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.reflect.ArrayGet;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.Invoke;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.math.Numeric;
import gnu.text.Char;
import java.io.Externalizable;

public class CompilationHelpers
{
  public static final Declaration setterDecl;
  static final Field setterField;
  static final ClassType setterType;
  static final ClassType typeList = ClassType.make("java.util.List");
  
  static
  {
    setterType = ClassType.make("gnu.kawa.functions.Setter");
    setterField = setterType.getDeclaredField("setter");
    setterDecl = new Declaration("setter", setterField);
    setterDecl.noteValue(new QuoteExp(Setter.setter));
  }
  
  private static boolean nonNumeric(Expression paramExpression)
  {
    boolean bool1 = paramExpression instanceof QuoteExp;
    boolean bool2 = false;
    if (bool1)
    {
      Object localObject = ((QuoteExp)paramExpression).getValue();
      boolean bool3 = localObject instanceof Numeric;
      bool2 = false;
      if (!bool3)
      {
        boolean bool4 = localObject instanceof Char;
        bool2 = false;
        if (!bool4)
        {
          boolean bool5 = localObject instanceof Symbol;
          bool2 = false;
          if (!bool5) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  public static Expression validateApplyToArgs(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    Expression[] arrayOfExpression1 = paramApplyExp.getArgs();
    int i = -1 + arrayOfExpression1.length;
    if (i >= 0)
    {
      Expression localExpression = arrayOfExpression1[0];
      if (!localExpression.getFlag(1))
      {
        if ((localExpression instanceof LambdaExp))
        {
          Expression[] arrayOfExpression3 = new Expression[i];
          System.arraycopy(arrayOfExpression1, 1, arrayOfExpression3, 0, i);
          return paramInlineCalls.visit(new ApplyExp(localExpression, arrayOfExpression3).setLine(paramApplyExp), paramType);
        }
        localExpression = paramInlineCalls.visit(localExpression, null);
        arrayOfExpression1[0] = localExpression;
      }
      Type localType = localExpression.getType().getRealType();
      Compilation localCompilation = paramInlineCalls.getCompilation();
      Language localLanguage = localCompilation.getLanguage();
      if (localType.isSubtype(Compilation.typeProcedure))
      {
        Expression[] arrayOfExpression2 = new Expression[i];
        System.arraycopy(arrayOfExpression1, 1, arrayOfExpression2, 0, i);
        ApplyExp localApplyExp2 = new ApplyExp(localExpression, arrayOfExpression2);
        localApplyExp2.setLine(paramApplyExp);
        return localExpression.validateApply(localApplyExp2, paramInlineCalls, paramType, null);
      }
      int j = CompileReflect.checkKnownClass(localType, localCompilation);
      ApplyExp localApplyExp1 = null;
      if (j < 0) {}
      while (localApplyExp1 != null)
      {
        localApplyExp1.setLine(paramApplyExp);
        return paramInlineCalls.visitApplyOnly(localApplyExp1, paramType);
        if ((localType.isSubtype(Compilation.typeType)) || (localLanguage.getTypeFor(localExpression, false) != null))
        {
          localApplyExp1 = new ApplyExp(Invoke.make, arrayOfExpression1);
        }
        else if ((localType instanceof ArrayType))
        {
          localApplyExp1 = new ApplyExp(new ArrayGet(((ArrayType)localType).getComponentType()), arrayOfExpression1);
        }
        else
        {
          boolean bool1 = localType instanceof ClassType;
          localApplyExp1 = null;
          if (bool1)
          {
            ClassType localClassType = (ClassType)localType;
            boolean bool2 = localClassType.isSubclass(typeList);
            localApplyExp1 = null;
            if (bool2)
            {
              localApplyExp1 = null;
              if (i == 1)
              {
                Type[] arrayOfType = new Type[1];
                arrayOfType[0] = Type.intType;
                localApplyExp1 = new ApplyExp(localClassType.getMethod("get", arrayOfType), arrayOfExpression1);
              }
            }
          }
        }
      }
    }
    paramApplyExp.visitArgs(paramInlineCalls);
    return paramApplyExp;
  }
  
  public static Expression validateIsEqv(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if ((nonNumeric(arrayOfExpression[0])) || (nonNumeric(arrayOfExpression[1]))) {
      paramApplyExp = new ApplyExp(((IsEqv)paramProcedure).isEq, arrayOfExpression);
    }
    return paramApplyExp;
  }
  
  public static Expression validateSetter(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    Expression localExpression;
    Type localType;
    if (arrayOfExpression.length == 1)
    {
      localExpression = arrayOfExpression[0];
      localType = localExpression.getType();
      if (!(localType instanceof ArrayType)) {
        break label56;
      }
      paramApplyExp = new SetArrayExp(localExpression, (ArrayType)localType);
    }
    label56:
    Declaration localDeclaration1;
    do
    {
      Procedure localProcedure;
      do
      {
        Object localObject;
        do
        {
          do
          {
            do
            {
              return paramApplyExp;
              if ((!(localType instanceof ClassType)) || (!((ClassType)localType).isSubclass(typeList))) {
                break;
              }
            } while ((paramApplyExp instanceof SetListExp));
            return new SetListExp(paramApplyExp.getFunction(), arrayOfExpression);
            if ((localExpression instanceof ReferenceExp))
            {
              Declaration localDeclaration2 = ((ReferenceExp)localExpression).getBinding();
              if (localDeclaration2 != null) {
                localExpression = localDeclaration2.getValue();
              }
            }
          } while (!(localExpression instanceof QuoteExp));
          localObject = ((QuoteExp)localExpression).getValue();
        } while (!(localObject instanceof Procedure));
        localProcedure = ((Procedure)localObject).getSetter();
      } while (!(localProcedure instanceof Procedure));
      if ((localProcedure instanceof Externalizable)) {
        return new QuoteExp(localProcedure);
      }
      localDeclaration1 = Declaration.getDeclaration((Procedure)localProcedure);
    } while (localDeclaration1 == null);
    return new ReferenceExp(localDeclaration1);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.CompilationHelpers
 * JD-Core Version:    0.7.0.1
 */