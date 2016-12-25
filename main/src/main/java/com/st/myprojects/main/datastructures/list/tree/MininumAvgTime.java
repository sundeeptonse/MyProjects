/**
 * 
 */
package com.st.myprojects.main.datastructures.list.tree;

import java.util.Comparator;
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
		MininumAvgTime mavt = new MininumAvgTime();

		Scanner input = new Scanner(System.in).useDelimiter("\\n");
		int numberofCustomers = input.nextInt();
		for (int i = 0; i < numberofCustomers; i++) {
			String line = input.next();
			String[] array = line.split(" ");
			System.out.println(line + ":" + array.length);
			if (array.length == 2) {
				int entryTime = Integer.parseInt(array[0]);
				int cookTime = Integer.parseInt(array[1]);
				mavt.addCustomerToQueue(entryTime, cookTime);
			}
		}
		input.close();

		System.out.println(mavt.customerQueue);

	}

	private int totalWaitTime;
	public PriorityQueue<Customer> customerQueue = new PriorityQueue<Customer>(
			new Comparator<Customer>() {
				@Override
				public int compare(Customer cust1, Customer cust2) {
					int compareDiff = cust1.entryTime - cust2.entryTime;
					if (compareDiff == 0) {
						compareDiff = cust1.cookTime - cust2.cookTime;
					}
					return compareDiff;
				}
			});

	public PriorityQueue<Customer> cookQueue = new PriorityQueue<Customer>(
			new Comparator<Customer>() {
				@Override
				public int compare(Customer cust1, Customer cust2) {
					return cust1.waitTime - cust2.waitTime;
				}
			});

	private void addCustomerToQueue(int entryTime, int cookTime) {
		Customer customer = new Customer(entryTime, cookTime);
		customerQueue.add(customer);
	}

	public void populateCookQueue(Customer customer) {
		cookQueue.add(customer);		
	}

	public void calculateWaitTime(Customer customer) {

	}

}

class Customer {
	int entryTime, cookTime, waitTime;

	Customer(int entryTime, int cookTime) {
		this.entryTime = entryTime;
		this.cookTime = cookTime;
	}

	@Override
	public String toString() {
		return this.entryTime + ":" + this.cookTime + ":" + this.waitTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cookTime;
		result = prime * result + entryTime;
		result = prime * result + waitTime;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (cookTime != other.cookTime)
			return false;
		if (entryTime != other.entryTime)
			return false;
		if (waitTime != other.waitTime)
			return false;
		return true;
	}

}
