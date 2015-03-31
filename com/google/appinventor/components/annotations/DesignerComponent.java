package com.google.appinventor.components.annotations;

import com.google.appinventor.components.common.ComponentCategory;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface DesignerComponent
{
  ComponentCategory category() default ComponentCategory.UNINITIALIZED;
  
  String description() default "";
  
  String designerHelpDescription() default "";
  
  String iconName() default "";
  
  boolean nonVisible() default false;
  
  boolean showOnPalette() default true;
  
  int version();
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.annotations.DesignerComponent
 * JD-Core Version:    0.7.0.1
 */