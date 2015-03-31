package com.google.appinventor.components.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface SimpleProperty
{
  PropertyCategory category() default PropertyCategory.UNSET;
  
  String description() default "";
  
  boolean userVisible() default true;
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.annotations.SimpleProperty
 * JD-Core Version:    0.7.0.1
 */