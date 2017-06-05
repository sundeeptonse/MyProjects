package com.st.myprojects.main;

public class RunTimeTest {

	@SuppressWarnings("deprecation")
	public static void main(String... args) {
		Object obj= new Object();
		
		RunTimeTest rtt = new RunTimeTest();
		
		
		
		Runtime.runFinalizersOnExit(Boolean.TRUE);
	}
}
