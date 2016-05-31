package com.st.myprojects.main.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * Double Main
 * */
public class NewComparable {

	public static void main(String[] args) {

		String[] args2 = { "0", "1" };
		WordList.addAndPrint(args2);
		WordList.addAndPrint("4", "3", "1", "2");

	}

}

class WordList {

	public static void addAndPrint(String... args) {
		// Doesn't auto sort
		List<String> list = new ArrayList<>();
		Collections.addAll(list, args);
		System.out.println(list);

		//Does an Auto Sort - TreeSet.addAll Method Does the Corresponding Sort		
		Set<String> set1 = new TreeSet<>();
		
		Collections.addAll(set1, args);
		System.out.println(set1);

	}
}