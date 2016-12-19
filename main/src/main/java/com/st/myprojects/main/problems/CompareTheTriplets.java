/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.Scanner;

/**
 * @author sundeeptonse
 *
 */
public class CompareTheTriplets {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a0 = in.nextInt();
		int a1 = in.nextInt();
		int a2 = in.nextInt();
		int b0 = in.nextInt();
		int b1 = in.nextInt();
		int b2 = in.nextInt();

		int[] scores = new int[2];
		scores = getScore(a0, b0, scores);
		scores = getScore(a1, b1, scores);
		scores = getScore(a2, b2, scores);
		System.out.println(scores[0] + " " + scores[1]);
		
		
	}
	

	public static int[] getScore(int a, int b, int[] scores) {
		if (a != b) {
			if (a > b) {
				scores[0]++;
			} else {
				scores[1]++;
			}
		}
		return scores;
	}
}
