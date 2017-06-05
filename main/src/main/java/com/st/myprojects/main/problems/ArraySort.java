/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author sundeeptonse
 *
 */

public class ArraySort {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for (int i = 0; i < n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		scan.close();

		Arrays.parallelSort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}
}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

class Checker implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		if(o1 == null || o2 == null){
            throw new NullPointerException();
        }
        else{
            int scoreDiff = o2.score - o1.score;
            if(scoreDiff == 0){
                return o1.name.compareToIgnoreCase(o2.name);
            }else{
                return scoreDiff;
            }
        }
	}

}