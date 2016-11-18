/**
 * 
 */
package com.st.myprojects.main.datastructures.list;

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
		LinkedList.LinkedListUtil.printLinkedList(list2);
		list2.addAfter(1000, 30);
		LinkedList.LinkedListUtil.printLinkedList(list2);
		list2.remove(2);
		LinkedList.LinkedListUtil.printLinkedList(list2);
		System.out.println("-----");
		LinkedList.LinkedListUtil.printLinkedList(list2);
		System.out.println("Reverse");
		
		
		LinkedList.LinkedListUtil.reverseLinkedListS(list2);
		LinkedList.LinkedListUtil.printLinkedList(list2);
		
		System.out.println("Reverse2");
		LinkedList.LinkedListUtil.reverseLinkedListN(list2);
		LinkedList.LinkedListUtil.printLinkedList(list2);
		
	}
}

