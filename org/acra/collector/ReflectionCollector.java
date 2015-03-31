package org.acra.collector;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ReflectionCollector
{
  public static String collectConstants(Class<?> paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Field[] arrayOfField = paramClass.getFields();
    int i = arrayOfField.length;
    int j = 0;
    for (;;)
    {
      if (j < i)
      {
        Field localField = arrayOfField[j];
        localStringBuilder.append(localField.getName()).append("=");
        try
        {
          localStringBuilder.append(localField.get(null).toString());
          localStringBuilder.append("\n");
          j++;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            localStringBuilder.append("N/A");
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            localStringBuilder.append("N/A");
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String collectStaticGettersResults(Class<?> paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Method[] arrayOfMethod = paramClass.getMethods();
    int i = arrayOfMethod.length;
    int j = 0;
    for (;;)
    {
      Method localMethod;
      if (j < i)
      {
        localMethod = arrayOfMethod[j];
        if ((localMethod.getParameterTypes().length != 0) || ((!localMethod.getName().startsWith("get")) && (!localMethod.getName().startsWith("is"))) || (localMethod.getName().equals("getClass"))) {}
      }
      try
      {
        localStringBuilder.append(localMethod.getName());
        localStringBuilder.append('=');
        localStringBuilder.append(localMethod.invoke(null, (Object[])null));
        localStringBuilder.append("\n");
        label118:
        j++;
        continue;
        return localStringBuilder.toString();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        break label118;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        break label118;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label118;
      }
    }
  }
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     org.acra.collector.ReflectionCollector
 * JD-Core Version:    0.7.0.1
 */