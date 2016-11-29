/**
 * 
 */
package com.st.myprojects.main.datastructures.list.stack;

/**
 * @author sundeeptonse
 *
 */
public class StackTest {
	public static void main(String... args) {
		
		StackA<Integer> stack = new StackA<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println("Top:" + stack.top());
		
		stack.pop();
		System.out.println("Top:" + stack.top());
		
		stack.pop();
		System.out.println("Top:" + stack.top());
		
		stack.pop();
		System.out.println("Top:" + stack.top());
		
		stack.pop();
		System.out.println("Top:" + stack.top());
		
		stack.pop();
		System.out.println("Top:" + stack.top());
		
		stack.push(6);
		System.out.println("Top:" + stack.top());
		
		System.out.println("----");
		
		
		StackI<Integer> stackI = new StackA<>();
		stackI.push(1);
		stackI.push(2);
		stackI.push(3);
		stackI.push(4);
		stackI.push(5);
		System.out.println("Top:" + stackI.top());
		
		stackI.pop();
		System.out.println("Top:" + stackI.top());
		
		stackI.pop();
		System.out.println("Top:" + stackI.top());
		
		stackI.pop();
		System.out.println("Top:" + stackI.top());
		
		stackI.pop();
		System.out.println("Top:" + stackI.top());
		
		stackI.pop();
		System.out.println("Top:" + stackI.top());
		
		stackI.push(6);
		System.out.println("Top:" + stackI.top());
		
	}
}
