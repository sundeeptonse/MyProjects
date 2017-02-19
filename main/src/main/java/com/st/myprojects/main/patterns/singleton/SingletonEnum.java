package com.st.myprojects.main.patterns.singleton;

public enum SingletonEnum {
	INSTANCE;

	private static int testS = 0;
	private int test = 0;

	public void incrementAndPrint() {
		System.out.println("Value is Set:" + test++);
	}

	public static void main(String[] args) {
		SingletonEnum.INSTANCE.incrementAndPrint();
		SingletonEnum.INSTANCE.incrementAndPrint();
		SingletonEnum.INSTANCE.incrementAndPrint();
		SingletonEnum.INSTANCE.incrementAndPrint();
		
		for (SingletonEnum values: SingletonEnum.values())
		{
		  System.out.println(values);
		}
	}

}
