package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.ScopeExp;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.IdentityHashMap;
import java.util.Vector;

public class SyntaxTemplate
  implements Externalizable
{
  static final int BUILD_CONS = 1;
  static final int BUILD_DOTS = 5;
  static final int BUILD_LIST1 = 8;
  static final int BUILD_LITERAL = 4;
  static final int BUILD_MISC = 0;
  static final int BUILD_NIL = 16;
  static final int BUILD_SYNTAX = 24;
  static final int BUILD_VAR = 2;
  static final int BUILD_VAR_CAR = 3;
  static final int BUILD_VECTOR = 40;
  static final int BUILD_WIDE = 7;
  static final String dots3 = "...";
  Object[] literal_values;
  int max_nesting;
  String patternNesting;
  String template_program;
  
  protected SyntaxTemplate() {}
  
  public SyntaxTemplate(Object paramObject, SyntaxForm paramSyntaxForm, Translator paramTranslator)
  {
    if ((paramTranslator == null) || (paramTranslator.patternScope == null)) {}
    for (String str = "";; str = paramTranslator.patternScope.patternNesting.toString())
    {
      this.patternNesting = str;
      StringBuffer localStringBuffer = new StringBuffer();
      Vector localVector = new Vector();
      convert_template(paramObject, paramSyntaxForm, localStringBuffer, 0, localVector, new IdentityHashMap(), false, paramTranslator);
      this.template_program = localStringBuffer.toString();
      this.literal_values = new Object[localVector.size()];
      localVector.copyInto(this.literal_values);
      return;
    }
  }
  
  public SyntaxTemplate(String paramString1, String paramString2, Object[] paramArrayOfObject, int paramInt)
  {
    this.patternNesting = paramString1;
    this.template_program = paramString2;
    this.literal_values = paramArrayOfObject;
    this.max_nesting = paramInt;
  }
  
  private int get_count(Object paramObject, int paramInt, int[] paramArrayOfInt)
  {
    for (int i = 0; i < paramInt; i++) {
      paramObject = ((Object[])(Object[])paramObject)[paramArrayOfInt[i]];
    }
    return ((Object[])paramObject).length;
  }
  
  static int indexOf(Vector paramVector, Object paramObject)
  {
    int i = paramVector.size();
    for (int j = 0; j < i; j++) {
      if (paramVector.elementAt(j) == paramObject) {
        return j;
      }
    }
    return -1;
  }
  
  public int convert_template(Object paramObject1, SyntaxForm paramSyntaxForm, StringBuffer paramStringBuffer, int paramInt, Vector paramVector, Object paramObject2, boolean paramBoolean, Translator paramTranslator)
  {
    while ((paramObject1 instanceof SyntaxForm))
    {
      paramSyntaxForm = (SyntaxForm)paramObject1;
      paramObject1 = paramSyntaxForm.getDatum();
    }
    int i7;
    if (((paramObject1 instanceof Pair)) || ((paramObject1 instanceof FVector)))
    {
      IdentityHashMap localIdentityHashMap = (IdentityHashMap)paramObject2;
      if (localIdentityHashMap.containsKey(paramObject1))
      {
        paramTranslator.syntaxError("self-referential (cyclic) syntax template");
        i7 = -2;
        return i7;
      }
      localIdentityHashMap.put(paramObject1, paramObject1);
    }
    Pair localPair1;
    int i2;
    int i3;
    Object localObject1;
    if ((paramObject1 instanceof Pair))
    {
      localPair1 = (Pair)paramObject1;
      i2 = -2;
      i3 = paramStringBuffer.length();
      localObject1 = localPair1.getCar();
      if (paramTranslator.matches(localObject1, "..."))
      {
        Object localObject3 = Translator.stripSyntax(localPair1.getCdr());
        if ((localObject3 instanceof Pair))
        {
          Pair localPair3 = (Pair)localObject3;
          if ((localPair3.getCar() == "...") && (localPair3.getCdr() == LList.Empty))
          {
            paramObject1 = "...";
            label166:
            int n = indexOf(paramVector, paramObject1);
            if (n < 0)
            {
              n = paramVector.size();
              paramVector.addElement(paramObject1);
            }
            if ((paramObject1 instanceof Symbol))
            {
              ScopeExp localScopeExp = paramTranslator.currentScope();
              paramTranslator.noteAccess(paramObject1, localScopeExp);
            }
            if ((!(paramObject1 instanceof SyntaxForm)) && (paramObject1 != "...")) {
              paramStringBuffer.append('\030');
            }
            paramStringBuffer.append((char)(4 + n * 8));
            if (paramObject1 != "...") {
              break label730;
            }
          }
        }
      }
    }
    label724:
    label730:
    for (int i1 = -1;; i1 = -2)
    {
      return i1;
      int i4 = paramVector.size();
      paramStringBuffer.append('\b');
      int i5 = 0;
      Object localObject2 = localPair1.getCdr();
      for (;;)
      {
        Pair localPair2;
        if ((localObject2 instanceof Pair))
        {
          localPair2 = (Pair)localObject2;
          if (paramTranslator.matches(localPair2.getCar(), "...")) {}
        }
        else
        {
          int i6 = paramInt + i5;
          i7 = convert_template(localObject1, paramSyntaxForm, paramStringBuffer, i6, paramVector, paramObject2, false, paramTranslator);
          LList localLList2 = LList.Empty;
          if (localObject2 != localLList2)
          {
            paramStringBuffer.setCharAt(i3, (char)(1 + (-1 + (paramStringBuffer.length() - i3) << 3)));
            i2 = convert_template(localObject2, paramSyntaxForm, paramStringBuffer, paramInt, paramVector, paramObject2, paramBoolean, paramTranslator);
          }
          if (i5 <= 0) {
            break;
          }
          if (i7 < 0) {
            paramTranslator.syntaxError("... follows template with no suitably-nested pattern variable");
          }
          int i8 = i5;
          for (;;)
          {
            i8--;
            if (i8 < 0) {
              break;
            }
            char c = (char)(5 + (i7 << 3));
            paramStringBuffer.setCharAt(1 + (i3 + i8), c);
            int i9 = paramInt + i5;
            if (i9 >= this.max_nesting) {
              this.max_nesting = i9;
            }
          }
        }
        i5++;
        localObject2 = localPair2.getCdr();
        paramStringBuffer.append('\005');
      }
      if (i7 >= 0) {
        break;
      }
      if (i2 >= 0) {
        return i2;
      }
      if ((i7 == -1) || (i2 == -1)) {
        return -1;
      }
      if (paramBoolean) {
        return -2;
      }
      paramVector.setSize(i4);
      paramStringBuffer.setLength(i3);
      break label166;
      if ((paramObject1 instanceof FVector))
      {
        paramStringBuffer.append('(');
        return convert_template(LList.makeList((FVector)paramObject1), paramSyntaxForm, paramStringBuffer, paramInt, paramVector, paramObject2, true, paramTranslator);
      }
      LList localLList1 = LList.Empty;
      if (paramObject1 == localLList1)
      {
        paramStringBuffer.append('\020');
        return -2;
      }
      if ((!(paramObject1 instanceof Symbol)) || (paramTranslator == null) || (paramTranslator.patternScope == null)) {
        break label166;
      }
      int i = indexOf(paramTranslator.patternScope.pattern_names, paramObject1);
      if (i < 0) {
        break label166;
      }
      int j = this.patternNesting.charAt(i);
      int k;
      if ((j & 0x1) != 0)
      {
        k = 3;
        int m = j >> 1;
        if (m > paramInt) {
          paramTranslator.syntaxError("inconsistent ... nesting of " + paramObject1);
        }
        paramStringBuffer.append((char)(k + i * 8));
        if (m != paramInt) {
          break label724;
        }
      }
      for (;;)
      {
        return i;
        k = 2;
        break;
        i = -1;
      }
    }
  }
  
  Object execute(int paramInt1, Object[] paramArrayOfObject, int paramInt2, int[] paramArrayOfInt, Translator paramTranslator, TemplateScope paramTemplateScope)
  {
    int m;
    String str;
    for (int i = this.template_program.charAt(paramInt1); (i & 0x7) == 7; i = m | str.charAt(paramInt1))
    {
      m = i - 7 << 13;
      str = this.template_program;
      paramInt1++;
    }
    Object localObject6;
    if (i == 8) {
      localObject6 = executeToList(paramInt1 + 1, paramArrayOfObject, paramInt2, paramArrayOfInt, paramTranslator, paramTemplateScope);
    }
    LList localLList;
    do
    {
      return localObject6;
      if (i == 16) {
        return LList.Empty;
      }
      if (i != 24) {
        break;
      }
      localObject6 = execute(paramInt1 + 1, paramArrayOfObject, paramInt2, paramArrayOfInt, paramTranslator, paramTemplateScope);
      localLList = LList.Empty;
    } while (localObject6 == localLList);
    return SyntaxForms.makeForm(localObject6, paramTemplateScope);
    if ((i & 0x7) == 1)
    {
      Pair localPair = null;
      Object localObject3 = null;
      do
      {
        int k = paramInt1 + 1;
        Object localObject4 = executeToList(k, paramArrayOfObject, paramInt2, paramArrayOfInt, paramTranslator, paramTemplateScope);
        if (localPair == null) {
          localObject3 = localObject4;
        }
        while ((localObject4 instanceof Pair))
        {
          localPair = (Pair)localObject4;
          localObject4 = localPair.getCdr();
          continue;
          localPair.setCdrBackdoor(localObject4);
        }
        paramInt1 = k + (i >> 3);
        i = this.template_program.charAt(paramInt1);
      } while ((i & 0x7) == 1);
      Object localObject5 = execute(paramInt1, paramArrayOfObject, paramInt2, paramArrayOfInt, paramTranslator, paramTemplateScope);
      if (localPair == null) {
        localObject3 = localObject5;
      }
      for (;;)
      {
        return localObject3;
        localPair.setCdrBackdoor(localObject5);
      }
    }
    if (i == 40)
    {
      Object localObject2 = execute(paramInt1 + 1, paramArrayOfObject, paramInt2, paramArrayOfInt, paramTranslator, paramTemplateScope);
      FVector localFVector = new FVector((LList)localObject2);
      return localFVector;
    }
    if ((i & 0x7) == 4)
    {
      int j = i >> 3;
      return this.literal_values[j];
    }
    if ((i & 0x6) == 2)
    {
      Object localObject1 = get_var(i >> 3, paramArrayOfObject, paramArrayOfInt);
      if ((i & 0x7) == 3) {
        localObject1 = ((Pair)localObject1).getCar();
      }
      return localObject1;
    }
    throw new Error("unknown template code: " + i + " at " + paramInt1);
  }
  
  public Object execute(Object[] paramArrayOfObject, TemplateScope paramTemplateScope)
  {
    return execute(0, paramArrayOfObject, 0, new int[this.max_nesting], (Translator)Compilation.getCurrent(), paramTemplateScope);
  }
  
  public Object execute(Object[] paramArrayOfObject, Translator paramTranslator, TemplateScope paramTemplateScope)
  {
    return execute(0, paramArrayOfObject, 0, new int[this.max_nesting], paramTranslator, paramTemplateScope);
  }
  
  LList executeToList(int paramInt1, Object[] paramArrayOfObject, int paramInt2, int[] paramArrayOfInt, Translator paramTranslator, TemplateScope paramTemplateScope)
  {
    int i = paramInt1;
    int i1;
    String str;
    for (int j = this.template_program.charAt(paramInt1); (j & 0x7) == 7; j = i1 | str.charAt(paramInt1))
    {
      i1 = j - 7 << 13;
      str = this.template_program;
      paramInt1++;
    }
    Object localObject2;
    if ((j & 0x7) == 3)
    {
      Pair localPair3 = (Pair)get_var(j >> 3, paramArrayOfObject, paramArrayOfInt);
      localObject2 = Translator.makePair(localPair3, localPair3.getCar(), LList.Empty);
    }
    for (;;)
    {
      return localObject2;
      if ((j & 0x7) != 5) {
        break;
      }
      int k = get_count(paramArrayOfObject[(j >> 3)], paramInt2, paramArrayOfInt);
      localObject2 = LList.Empty;
      Pair localPair2 = null;
      int m = paramInt1 + 1;
      for (int n = 0; n < k; n++)
      {
        paramArrayOfInt[paramInt2] = n;
        LList localLList = executeToList(m, paramArrayOfObject, paramInt2 + 1, paramArrayOfInt, paramTranslator, paramTemplateScope);
        if (localPair2 == null) {
          localObject2 = localLList;
        }
        while ((localLList instanceof Pair))
        {
          localPair2 = (Pair)localLList;
          localLList = (LList)localPair2.getCdr();
          continue;
          localPair2.setCdrBackdoor(localLList);
        }
      }
    }
    Object localObject1 = execute(i, paramArrayOfObject, paramInt2, paramArrayOfInt, paramTranslator, paramTemplateScope);
    Pair localPair1 = new Pair(localObject1, LList.Empty);
    return localPair1;
  }
  
  Object get_var(int paramInt, Object[] paramArrayOfObject, int[] paramArrayOfInt)
  {
    Object localObject = paramArrayOfObject[paramInt];
    if (paramInt < this.patternNesting.length())
    {
      int i = this.patternNesting.charAt(paramInt) >> '\001';
      for (int j = 0; j < i; j++) {
        localObject = ((Object[])(Object[])localObject)[paramArrayOfInt[j]];
      }
    }
    return localObject;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.patternNesting = ((String)paramObjectInput.readObject());
    this.template_program = ((String)paramObjectInput.readObject());
    this.literal_values = ((Object[])paramObjectInput.readObject());
    this.max_nesting = paramObjectInput.readInt();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.patternNesting);
    paramObjectOutput.writeObject(this.template_program);
    paramObjectOutput.writeObject(this.literal_values);
    paramObjectOutput.writeInt(this.max_nesting);
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.SyntaxTemplate
 * JD-Core Version:    0.7.0.1
 */