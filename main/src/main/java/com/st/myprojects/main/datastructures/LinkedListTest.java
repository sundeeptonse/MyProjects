/**
 * 
 */
package com.st.myprojects.main.datastructures;

/**
 * @author sundeeptonse
 *
 */
public class LinkedListTest {

	public static void main(String... args) {

		LinkedListB list = new LinkedListB();
		list.add(10);
		list.add(20);
		list.add(40);
		list.add(50);
		LinkedListB.printLinkedList(list.getFirstNode());
		list.addAfter(1000, 30);
		LinkedListB.printLinkedList(list.getFirstNode());
		list.remove(2);
		LinkedListB.printLinkedList(list.getFirstNode());
		
		System.out.println("-----");
		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(10);
		list2.add(20);
		list2.add(40);
		list2.add(50);
		list2.printLinkedList(list2.getFirstNode());
		list2.addAfter(1000, 30);
		list2.printLinkedList(list2.getFirstNode());
		list2.remove(2);
		list2.printLinkedList(list2.getFirstNode());
	}
}

