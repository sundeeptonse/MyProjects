/**
 * 
 */
package com.st.myprojects.main.lambda.chap2;

import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;

/*-
 * @author sundeeptonse
 * 
 * Lambda Expression is a function.
 * 		There hasn't been a way to write free-standing function.
 * 
 * 		Lambdas can be understood as a kind of anonymous method with a more compact syntax
 * 		(that allows omission of modifiers, return type, throws clause and is some cases parameter types as well) 
 *
 * 		Syntax : 
 * 	  		Consist of a Parameter list seperated from a body by a function arrow
 *    	p -> p.translate(1,1)
 *    	i -> new Point(i,i+1)
 *     
 *    	(x,y) -> x + y
 *    	() -> 23
 *    	(int x, int y) -> x+y 
 *    		--> Explicitly Typed -> final and annotated.
 *    
 *    	Right side can be expressions like above or statements "statement lambda"
 *    	(Thread t) -> { t.start(); }
 *    	() {System.gc(); return 0; }
 *    
 *    	An expression Lambda
 *    		args -> expression
 *    
 *     	can be seen as
 *     	args -> { return expr; }
 *     
 *     
 * Lambda vs Anonymous Inner Classes
 *    	--> AIC -> Guaranteed to create a new object
 *    	--> No new Naming Scope, example this/super 
 *    
 * No Identity Crisis
 *     	Main aim is to represent a functional behavior
 *      No State, hence identity is unimportant.
 *      The language specification leaves it undetermined, 
 *      the only requirement being that a lambda must evaluate to an instance of a "Functional Interface"
 *      @FunctionalInterface
 *      
 * Scoping Rules for Lambda's:
 *      a)	Lambdas don't inherit names from SuperType
 *      	Hence redefinition of "Local Variables" is not allowed
 *        		--> Effect is to exclude from the scope of a lambda any declarations of its super-type.
 *      b) They may "shadow" "field names - instance or class level" i.e field name can be temp redeclared as a parameter
 *
 * 		This and Super will be of the Object where the Lambda is defined
 * 
 * 		With this, can a lambda refer to itself?
 * 
 * 
 * StateLess Lambda's or Non Capturing Lambda's :: Only Interact with arguments and return values
 * 		- No (this)
 * 		
 * 		
 * 
 *
 */
public class BasicsOfLambdas {

	public static void main(String... args) {
		new ScopeRules().scopingRules();
		new ScopeRules().r1.run();
		new ScopeRules().r2.run();

		// Returning a Lambda - Where applicable ?
		System.out.println("Lamdba Return:" + multiply(2));

		// Non-Capturing Lambda's or Stateless
		IntUnaryOperator mutiply = x -> x * 2;
		mutiply.applyAsInt(10);

		DoubleUnaryOperator sqrt = x -> Math.sqrt(x);
		sqrt.applyAsDouble(10);
		System.out.println(sqrt);

	}

	static IntUnaryOperator multiply(int value) {
		return i -> value * 2;
		// return i -> doCalc(value);
	}

	static int doCalc(int value2) {
		return value2 * 2;
	}

	static class ScopeRules {
		Object i, j;
		int x = 3;
		static int y = 4;
		// i can be re-used at this scope
		IntUnaryOperator iuo = i ->
		{
			int x = 4;
			int y = 10;
			int j = 3;
			return i + j;
		};

		void scopingRules() {
			final int i = 2;
			// This
			Runnable r = () ->
			{
				// Compile Error
				// int i=4;
				// This has access to the object rather the object of an inner
				// class
				System.out.println(this);
				System.out.println(super.toString());
			};
			Thread thread = new Thread(r);
			thread.start();
			Runnable r2 = () -> System.out.println("Hello");
			// Or this
			Thread t = new Thread(() -> System.out.println("Hello2"));
			t.start();
		}

		// Keywords this and super have same meanings
		Runnable r1 = () -> System.out.println(this);
		Runnable r2 = () -> System.out.println(toString());
		
		
		public String toString() {
			return "Hello, World";
		}

	}
}
