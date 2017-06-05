package com.st.myprojects.main.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Demo {
	public static void main(String[] args) throws Exception {
		TestAnnotationParser parser = new TestAnnotationParser();
		parser.parse(Annotated.class);
	}
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test {
	String info() default "";
}

class Annotated {
	@Test(info = "AWESOME")
	public void foo(String myParam) {
		System.out.println("This is " + myParam);
	}
}

class TestAnnotationParser {
	public void parse(Class clazz) throws Exception {
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(Test.class)) {
				Test test = method.getAnnotation(Test.class);
				String info = test.info();
				if ("AWESOME".equals(info)) {
					System.out.println("info is awesome!");
					// try to invoke the method with param
					method.invoke(Annotated.class.newInstance(), info);
				}
			}
		}
	}
}
