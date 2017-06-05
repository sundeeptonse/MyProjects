/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sundeeptonse
 *
 */
public class RansomNote {

	Map<String, Integer> magazineMap = new HashMap<String, Integer>();
	Map<String, Integer> noteMap = new HashMap<String, Integer>();
	boolean sizeGreater = false;

	public RansomNote(String magazine, String note) {
		String[] magazineArr = magazine.split(" ");
		String[] noteArr = note.split(" ");
		if (noteArr.length > magazineArr.length) {
			sizeGreater = true;
			return;
		}
		convertStringToMap(magazineArr, magazineMap);
		convertStringToMap(noteArr, noteMap);
	
	}

	private void convertStringToMap(String[] stringArr, Map<String, Integer> map) {
		for (String string : stringArr) {
			Integer count = map.get(string);
			if (count == null) {
				map.put(string, 1);
			} else {
				map.put(string, ++count);
			}
		}
	}

	public boolean solve() {
		System.err.println(noteMap);
		System.err.println(magazineMap);
		if(sizeGreater){
			return false;
		}
		boolean answer = true;
		for (String key : noteMap.keySet()) {
			System.err.println("In" + magazineMap + ":Key:" + key);
			Integer noteMapCount = noteMap.get(key);
			if (!(magazineMap.containsKey(key) && magazineMap.get(key) >= noteMapCount)) {
				answer = false;
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		// Eat whitespace to beginning of next line
		scanner.nextLine();

		RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
		scanner.close();

		boolean answer = s.solve();
		if (answer)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}
