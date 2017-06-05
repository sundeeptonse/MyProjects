/**
 * 
 */
package com.st.myprojects.main.recursionndynamicprogramming;

import java.util.Stack;

/*-
 * @author sundeeptonse
 * 
 * If we have three towers with N disks of Different Sizes which can slide onto any tower.
 * The Puzzle starts with disks sorted in ascending order of size from top to bottom.
 * 
 * Constraints:
 * 1) Only one disk can be moved at a time
 * 2) A disk is slid off the top of one tower and onto another tower.
 * 3) A disk cannot be placed on top of a smaller disk
 *  
 * Write a program to move the disks from the first tower to the last tower
 *	
 */
public class TowersOfHanoi {

	public static void main(String... args) {
		move(5);
	}

	public static void move(int n) {

		int noOfTowers = 3;
		Tower[] tower = new Tower[noOfTowers];
		while (noOfTowers > 0) {
			tower[--noOfTowers] = new Tower(noOfTowers);
		}

		// Add disks
		for (int i = n ; i > 0; i--) {
			tower[0].add(i);
		}

		System.out.println("Source:" + tower[0]);
		System.out.println("Destination:" + tower[2]);

		tower[0].moveDisks(n, tower[2], tower[1]);

		System.out.println("Source:" + tower[0]);
		System.out.println("Destination:" + tower[2]);
	}

	/*-
	 * Each Tower contains a Stack of Integers and the index of the Tower i.e 1,2,3 
	 */
	public static class Tower {
		private Stack<Integer> disks;
		private int index;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return index + ":" + disks.toString();
		}

		public Tower(int index) {
			disks = new Stack<>();
			this.index = index;
		}

		public int getIndex() {
			return this.index;
		}

		public void add(int d) {
			if (!disks.isEmpty() && disks.peek() <= d) {
				System.out.println("Error placing disk on index:" + index + "-"
						+ d + ":" + disks.peek());
			} else {
				disks.push(d);
			}
		}

		public void moveTopTo(Tower t) {
			System.out.println("Move Top of " + this.index + " to "
					+ t.getIndex());
			if (!disks.isEmpty()) {
				int top = disks.pop();
				t.add(top);
			} else {
				System.out.println("No Disks to Move");
			}
		}

		/*-
		 * Given value n, moves the disks from Source to destination with a Buffer tower
		 * 
		 * Base Case:
		 * if n = 1, then move directly to the destination
		 * if n = 2, then move 1 to the buffer, move 2 to the destination, from 1 from buffer to destination
		 * if n = 3, repeat 2 with moving 1,2 to buffer and 3 to destination 
		 * 			and move 1,2 to destination by keeping the source as buffer
		 * 
		 * */
		public void moveDisks(int n, Tower destination, Tower buffer) {
			if (n > 0) {
				System.out.println("Move " + n + " Disks from "
						+ this.getIndex() + " to " + destination.getIndex());
				/*-
				 * Move n-1 from Source to the buffer with the destination as a temp buffer
				 * 
				 */
				this.moveDisks(n - 1, buffer, destination);
				/*
				 * Move the top Disk to the destination
				 */

				this.moveTopTo(destination);
				
				/*
				 * Move the n -1 disks in buffer to the destination, by keep the
				 * source as the buffer
				 */
				buffer.moveDisks(n - 1, destination, this);
			}
		}

	}
}
