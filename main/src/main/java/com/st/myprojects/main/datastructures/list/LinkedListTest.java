/**
 * 
 */
package com.st.myprojects.main.datastructures.list;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author sundeeptonse
 *
 */
public class LinkedListTest {

	public static void main(String... args) {

		//
		// LinkedListB list = new LinkedListB();
		// list.add(10);
		// list.add(20);
		// list.add(40);
		// list.add(50);
		// LinkedListB.printLinkedList(list.getFirstNode());
		// list.addAfter(1000, 30);
		// LinkedListB.printLinkedList(list.getFirstNode());
		// list.remove(2);
		// LinkedListB.printLinkedList(list.getFirstNode());

//		try {
//			System.setOut(new PrintStream(
//					"/Users/sundeeptonse/Desktop/output-file.txt"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("-----");
//		LinkedList<Integer> list2 = new LinkedList<>();
//		list2.add(10);
//		list2.add(20);
//		list2.add(40);
//		list2.add(50);
//		list2.add(70);
//		LinkedListCommonUtil.printLinkedList(list2);

		// LinkedListCommonUtil.printLinkedList(list2);
		// list2.remove(2);
		// LinkedListCommonUtil.printLinkedList(list2);
		// System.out.println("-----");
		// LinkedListCommonUtil.printLinkedList(list2);
		// System.out.println("Reverse");
		//
		//
		// LinkedList.LinkedListUtil.reverseLinkedListS(list2);
		// LinkedListCommonUtil.printLinkedList(list2);
		//
		// System.out.println("Reverse2");
		// LinkedList.LinkedListUtil.reverseLinkedListN(list2);
		// LinkedListCommonUtil.printLinkedList(list2);
		// System.out.println(LinkedListCommonUtil.getElementatKFromEnd(list2,
		// 1));

		LinkedList<Character> pali = new LinkedList<>();
		pali.add('c');
		pali.add('u');
		pali.add('d');
		//pali.add('b');
		pali.add('d');
		pali.add('u');
		pali.add('c');

		//System.out.println(LinkedListCommonUtil.isPalindrome(pali));
		
		System.out.println(LinkedListCommonUtil.getElementKToLast(pali,1));

		//
		// LinkedListQ<Integer> integerLL = new LinkedListQ<>();
		// integerLL.add(1);
		// integerLL.add(2);
		// integerLL.add(3);
		// integerLL.add(4);
		// integerLL.add(5);
		// System.out.println(integerLL.removeFirst());
		// System.out.println(integerLL.removeFirst());
		// System.out.println(integerLL.removeFirst());
		// System.out.println(integerLL.removeFirst());
		// System.out.println(integerLL.removeFirst());
		//
		// LinkedListQ.LinkedListUtil.printLinkedList(integerLL);

	}
}
