/**
 * 
 */
package com.st.myprojects.main.datastructures.list.tree;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*-
 * @author sundeeptonse Tieu owns a pizza restaurant and he manages it in his
 *         own way. While in a normal restaurant, a customer is served by
 *         following the first-come, first-served rule, Tieu simply minimizes
 *         the average waiting time of his customers. So he gets to decide who
 *         is served first, regardless of how sooner or later a person comes.
 * 
 *         Different kinds of pizzas take different amounts of time to cook.
 *         Also, once he starts cooking a pizza, he cannot cook another pizza
 *         until the first pizza is completely cooked. Let's say we have three
 *         customers who come at time t=0, t=1, & t=2 respectively, and the time
 *         needed to cook their pizzas is 3, 9, & 6 respectively. If Tieu
 *         applies first-come, first-served rule, then the waiting time of three
 *         customers is 3, 11, & 16 respectively. The average waiting time in
 *         this case is (3 + 11 + 16) / 3 = 10. This is not an optimized
 *         solution. After serving the first customer at time t=3, Tieu can
 *         choose to serve the third customer. In that case, the waiting time
 *         will be 3, 7, & 17 respectively. Hence the average waiting time is (3
 *         + 7 + 17) / 3 = 9.
 * 
 *         Help Tieu achieve the minimum average waiting time. For the sake of
 *         simplicity, just find the integer part of the minimum average waiting
 *         time.
 * 
 *         Input Format
 * 
 *         The first line contains an integer N, which is the number of
 *         customers. In the next N lines, the ith line contains two space
 *         separated numbers Ti and Li. Ti is the time when ith customer order a
 *         pizza, and Li is the time required to cook that pizza. Output Format
 * 
 *         Display the integer part of the minimum average waiting time.
 *         Constraints
 * 
 *         1 ≤ N ≤ 105 0 ≤ Ti ≤ 109 1 ≤ Li ≤ 109 
 *
 *         Note
 *
 *         The waiting time is calculated as the difference between the time a
 *         customer orders pizza (the time at which they enter the shop) and the
 *         time she is served.
 * 
 *         Cook does not know about the future orders.
 * 
 *         Sample Input #00
 * 
 *         3
 *         0 3
 *         1 9 
 *         2 6
 *         3 1
 *         4 6
 *         
 *         Sample Output #00 :: 9
 * 
 *         3
 *         0 3
 *         1 9
 *         2 5
 *         Sample Output #00 :: 8
 *
 */
public class MininumAvgTime {

	public static void main(String... args) {
		Scanner in = new Scanner(System.in);
		int totalSize = in.nextInt();

		List<Customer> customerList = new ArrayList<>(totalSize);
		in.nextLine();
		while (totalSize > 0) {
			Customer customer = new Customer(in.nextInt(), in.nextInt());
			customerList.add(customer);
			totalSize--;
		}

		System.out.println(customerList.toString());

		System.out.println(getMinAvgTime(customerList));

	}

	public static int getMinAvgTime(List<Customer> customerList) {

		PriorityQueue<Customer> pq = new PriorityQueue<>(
				Customer.waitTimeComparator);

		customerList.sort(Customer.entryTimeComparator);
		// Initialize the Entry Time with the first users Time
		int totalTimeWaitTime = 0;
		int currentTime = 0;

		List<Customer> tempList = new ArrayList<>();

		for (int i = 0; i < customerList.size();) {
			Customer customer = customerList.get(i);
			int entryTime = customer.entryTime;
			System.out.println("Current Customer" + customer + ":Current Time:"
					+ currentTime + ":Total Wait Time: " + totalTimeWaitTime);

			if (entryTime <= currentTime) {
				// Add to the tempList
				tempList.add(customer);
				i++;
			} else {
				// Process the Temp List by Emptying it into the PQ
				pq.addAll(tempList);
				if (pq.size() > 0) {
					// Get the Top Most Element, i.e the one with the least Wait
					// Time
					Customer minWaitTimeCustomer = pq.poll();
					int waitTime = minWaitTimeCustomer.cookTime
							- minWaitTimeCustomer.entryTime;

					// Increment the total Wait Time
					totalTimeWaitTime += waitTime;

					System.out.println("Customer:" + minWaitTimeCustomer + ":waitTime:"
							+ waitTime + ":TotalWaitTime:" + totalTimeWaitTime);

					// Increment the current time as well
					currentTime += waitTime;

					if (pq.size() > 0) {
						// Fill up the TempList with the Rest of the Customers
						tempList = new ArrayList<>(pq);
					}
				} else {
					// If size is 0 and we have entered here, it means that the
					// entryTime isn't sufficient

					// So we get the next in loop
					if (i + 1 < customerList.size()) {
						// Increase the Current Time
						currentTime += customerList.get(i + 1).entryTime;
						i++;
					}
				}
			}
		}

		// After all this, if we have any elements in the tempList, process them
		pq.addAll(tempList);
		while (pq.size() > 0) {
			// Get the Top Most Element, i.e the one with the least Wait
			// Time
			Customer customer = pq.poll();
			int waitTime = customer.cookTime - customer.entryTime;

			// Increment the total Wait Time
			totalTimeWaitTime += waitTime;

			System.out.println("Customer:" + customer + ":waitTime:"
					+ waitTime + ":TotalWaitTime:" + totalTimeWaitTime);
			
			// Increment the current time as well
			currentTime += waitTime;

			if (pq.size() > 0) {
				// Fill up the TempList with the Rest of the Customers
				tempList = new ArrayList<>(pq);
			}
		}

		return totalTimeWaitTime / customerList.size();
	}
}

class Customer {
	int entryTime, cookTime;

	public static Comparator<Customer> entryTimeComparator = new Comparator<Customer>() {
		@Override
		public int compare(Customer o1, Customer o2) {
			return o1.entryTime - o2.entryTime;
		}
	};

	public static Comparator<Customer> waitTimeComparator = new Comparator<Customer>() {
		@Override
		public int compare(Customer o1, Customer o2) {
			return (o1.entryTime - o1.cookTime) - (o2.entryTime - o2.cookTime);
		}
	};

	Customer(int entryTime, int cookTime) {
		this.entryTime = entryTime;
		this.cookTime = cookTime;
	}

	@Override
	public String toString() {
		return "Customer [entryTime=" + entryTime + ", cookTime=" + cookTime
				+ "]";
	}

}
