/**
 * 
 */
package com.st.myprojects.main.datastructures.list.tree;

import java.util.ArrayList;
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

	public List<Customer> customerList = new ArrayList<>();

	public PriorityQueue<Customer> customerWaitTimeList = new PriorityQueue<Customer>(
			Customer.customerWaitTimeComparator);

	public static void main(String... args) {
		MininumAvgTime mavt = new MininumAvgTime();

		Scanner input = new Scanner(System.in).useDelimiter("\\n");
		int numberofCustomers = input.nextInt();
		for (int i = 0; i < numberofCustomers; i++) {
			String line = input.next();
			String[] array = line.split(" ");
			if (array.length == 2) {
				int entryTime = Integer.parseInt(array[0]);
				int cookTime = Integer.parseInt(array[1]);
				mavt.addCustomerToList(entryTime, cookTime);
			}
		}

		Collections.sort(mavt.customerList,
				Customer.customerEntryTimeCookTimeComparator);

		System.out.println("Min Avg Time:" + mavt.getMinAvgTime());
		input.close();
	}

	public int getMinAvgTime() {
		int exitTime = 0;

		int minWaitTime = 0;
		int customerSize = customerList.size();
		System.out.println(customerList);

		for (Customer customer : customerList) {

			/*- 
			 * If no more entries remaining with the exitTime
			 * Increment the minWaitTime Time with the top of the list and keep doing so till the EntryTime > exitTime
			 * Keep Looping through the list till the customer.entryTime is Greater
			 */
			while (customerWaitTimeList.size() > 0
					&& customer.entryTime > exitTime) {
				Customer customerWithLeastWaitTime = customerWaitTimeList
						.poll();
				int[] customerExitWaitTimeArray = getCustomerExitWaitTime(
						customerWithLeastWaitTime, exitTime);
				//Increment the Exit Time with the Exit Time in the Array
				exitTime+=customerExitWaitTimeArray[0];
				//Increment the Wait Time with the Wait Time in the Array
				minWaitTime+=customerExitWaitTimeArray[1];
			}

			if (customer.entryTime <= exitTime) {

				// Add Customer to the Wait Time List with the Calculated Wait
				// Time
				int[] customerExitWaitTimeArray = getCustomerExitWaitTime(
						customer, exitTime);
				exitTime+=customerExitWaitTimeArray[0];
				customer.waitTime = customerExitWaitTimeArray[1];
				customerWaitTimeList.add(customer);
			}
		}

		// Now Poll with the Remaining Data Left in the WaitTime List
		// This is already sorted with the best difference
		while (customerWaitTimeList.size() > 0) {
			// minWaitTime += getCustomerWaitTime(minWaitTime);
		}

		return minWaitTime / customerSize;

	}

	/*-
	 * 
	 * 
	 * a) If MinTime >= entryTime
	 * example: 0 3, 4 1
	 * Exit Time = CustomerEntryTime + CustomerCookTime = 5
	 * 
	 * b) If MinTime < entryTime
	 * ExitTime = PrevExitTime + CustomerCookTime
	 * 
	 * b1)example: 0 3, 2 1
	 * Exit Time : 3 + 1 = 4
	 * 
	 * b2)example: 0 3, 0 4
	 * Exit Time : 3 + 4  = 7
	 * 
	 * Wait Time = Exit Time - Entry Time
	 * 
	 * a)  Wait Time =  5 - 4 = 1
	 * b1) Wait Time =  4 - 2 = 2
	 * b2) Wait Time =  7 - 0 = 7
	 * 
	 * 
	 * */

	public int[] getCustomerExitWaitTime(Customer customer, int prevExitTime) {
		// Exit Time is stored at int[0]
		// Wait Time is stored at int[1]
		int[] exitWaitTimeArray = new int[2];

		if (prevExitTime >= customer.entryTime) {
			exitWaitTimeArray[0] = customer.entryTime + customer.cookTime;
		} else {
			exitWaitTimeArray[0] = prevExitTime + customer.cookTime;
		}
		exitWaitTimeArray[1] = customer.entryTime - exitWaitTimeArray[0];
		return exitWaitTimeArray;
	}

	private void addCustomerToList(int entryTime, int cookTime) {
		Customer customer = new Customer(entryTime, cookTime);
		customerList.add(customer);
		System.out.println(customerList.size());
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
		return "Customer [entryTime=" + entryTime + ", cookTime=" + cookTime
				+ "]";
	}

	public static Comparator<Customer> customerWaitTimeComparator = new Comparator<Customer>() {
		public int compare(Customer customer1, Customer customer2) {
			return (customer1.waitTime - customer2.waitTime);
		}
	};

	public static Comparator<Customer> customerEntryTimeCookTimeComparator = new Comparator<Customer>() {
		public int compare(Customer customer1, Customer customer2) {
			int compareDiff = customer1.entryTime - customer2.entryTime;
			return compareDiff == 0 ? customer1.cookTime - customer2.cookTime
					: compareDiff;
		}
	};
}
