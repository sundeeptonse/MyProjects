package com.st.myprojects.main.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@MyCustomAnn2(age = 10, name = "Sundeep")
public class MyCustomAnnotation {
	
	@MyCustomAnn(age = 10, name = "Sundeep", newNames = { "" })
	public static void main(String... args) {
		System.out.println("Test");
	}
}

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface MyCustomAnn {

	String value() default "";

	String name();

	int age();

	String[] newNames();

}


@Documented
@Inherited
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE})
@interface MyCustomAnn2 {

	String value() default "";

	String name();

	int age();

	String[] newNames() default { "0", "1" };

}
