/**
 * 
 */
package com.st.myprojects.main.datastructures.list.tree;

import java.util.Scanner;

/**
 * @author sundeeptonse
 *
 */
public class TrieTest {

	private static String Operation_add = "add ";
	private static String Operation_find = "find ";

	public static void main(String... args) {
		prefixCheck();
	}

	public static void prefixCheck() {

		Scanner in = new Scanner(System.in).useDelimiter("\\n");
		int n = in.nextInt();

		Trie trie = new Trie(true);
		String stringArr[] = new String[n];
		for (int i = 0; i < n; i++) {
			stringArr[i] = in.next();
		}
		in.close();

		boolean isSetBad = false;
		String badString = "";
		for (String string : stringArr) {
			try {
				trie.add(string);
			} catch (PrefixCheckException e) {
				isSetBad = true;
				badString = string;
				break;
			}
		}

		if (isSetBad) {
			System.out.println("BAD SET");
			System.out.println(badString);
		} else {
			System.out.println("GOOD SET");
		}

	}

	public static void findCount() {

		Scanner in = new Scanner(System.in).useDelimiter("\\n");
		int n = in.nextInt();

		Trie trie = new Trie(false);
		for (int i = 0; i < n; i++) {
			String sentence = in.next();
			if (sentence.startsWith(Operation_add)) {
				String addString = sentence.substring(
						sentence.indexOf(Operation_add)
								+ Operation_add.length(), sentence.length());
				try {
					trie.add(addString);
				} catch (PrefixCheckException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (sentence.startsWith(Operation_find)) {

				String findString = sentence.substring(
						sentence.indexOf(Operation_find)
								+ Operation_find.length(), sentence.length());
				System.out.println(trie.findCount(findString));
			}
		}

		trie.getNoOfWords();
		in.close();
	}

	public static void treeBasic() {

		Trie trie = new Trie(false);
		try {
			trie.add("Sundeep");
			trie.add("Sunny");
			trie.add("Nikhil");
			trie.add("Nik");
			trie.add("Nika");
			trie.add("Nike");
			trie.add("Niki");

		} catch (PrefixCheckException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(trie.getNoOfWords());

		System.out.println("Sund:" + trie.findCount("Sund"));
		System.out.println("Sun:" + trie.findCount("Sun"));
		System.out.println("XX:" + trie.findCount("XX"));
		System.out.println("Nik:" + trie.findCount("Nik"));
		System.out.println("Nikeee:" + trie.findCount("Nikee"));
		System.out.println("Nikhil:" + trie.findCount("Nikhil"));
	}
}
