package com.st.myprojects.main.patterns.singleton;

public class SingletonFact1 extends Singleton{
	private SingletonFact1(){};
}

class SingletonFact2 extends Singleton{
	private SingletonFact2(){};
}

class SingletonFact3 extends Singleton{
	private SingletonFact3(){};
	public void test3(){
		System.out.println("Hello:" + this);
	}
}

class Singleton{
	public void test(){
		System.out.println("Hello:" + this);
	}
}
