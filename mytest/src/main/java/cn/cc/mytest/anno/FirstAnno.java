package cn.cc.mytest.anno;

import java.lang.annotation.Documented;   
import java.lang.annotation.ElementType;   
import java.lang.annotation.Retention;   
import java.lang.annotation.RetentionPolicy;   
import java.lang.annotation.Target;   
  
@Documented   
@Retention(RetentionPolicy.RUNTIME)   
@Target(ElementType.TYPE)   
public @interface FirstAnno {   
	String value() default "FirstAnno";   
} 
