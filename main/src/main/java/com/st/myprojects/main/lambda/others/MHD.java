package com.st.myprojects.main.lambda.others;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class MHD {

	private static Lookup lookup = MethodHandles.lookup();

	public static void main(String[] args) throws Throwable {

		MethodHandle mh = lookup.findStatic(MHD.class, "hello",
				MethodType.methodType(void.class));
		mh.invokeExact();
	}

	static void hello() {
		System.out.println("hello");
	}
}
