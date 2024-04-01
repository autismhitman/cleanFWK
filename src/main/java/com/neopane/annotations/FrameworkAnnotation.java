package com.neopane.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.neopane.enums.CategoryType;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({METHOD, TYPE})
public @interface FrameworkAnnotation {
	
	 String[] author() default {"navin sharma"};
	 CategoryType[] category() default {CategoryType.SMOKE};
}

 