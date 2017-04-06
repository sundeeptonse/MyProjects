/**
 * 
 */
package com.st.myprojects.main.lambda.chap1;

import java.util.function.IntUnaryOperator;

/**
 * @author sundeeptonse
 *
 */
public class RecursiveLambda {
	/*
	 * TBD
	 * http://stackoverflow.com/questions/19429667/implement-recursive-lambda
	 * -function-using-java-8
	 */
	IntUnaryOperator fact;
	public RecursiveLambda() {
		fact = i -> i == 0 ? 1 : i * fact.applyAsInt(i - 1);
	}

}
