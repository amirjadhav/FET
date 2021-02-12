package com.cybage;

 

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

 

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.METHOD,
    ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
//@Retention(RetentionPolicy.SOURCE)
//@Retention(RetentionPolicy.CLASS)
@Retention(RetentionPolicy.RUNTIME)    //how to access annotations --> reflections
public @interface MyAnnotation {
    String address() default "pune";
    int salary() default 123;
}
 