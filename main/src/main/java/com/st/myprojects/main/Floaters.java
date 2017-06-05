/**
 * 
 */
package com.st.myprojects.main;

import java.math.BigDecimal;

/**
 * @author sundeeptonse
 *
 */
public class Floaters {

	public static void main(String... args) {

		System.out.println(1.03 - 0.42);
		System.out.println(1.00 - 9 * .1);

		/**
		 * Candy Buying, if one candy costs $10 cents more than the other Answer
		 * should be 40cents
		 * */
		double funds = 1.00;
		int itemsBought = 0;
		for (double price = .10; funds >= price; price += .10) {
			funds -= price;
			itemsBought++;
		}

		System.out.println("ItemsBought:" + itemsBought);
		System.out.println("Change:" + funds);

		final BigDecimal TenCents = new BigDecimal("0.10");
		int itemsBought2 = 0;
		BigDecimal funds2 = new BigDecimal("1.00");
		for (BigDecimal price = TenCents; funds2.compareTo(price) >= 0; price = price
				.add(TenCents)) {
			funds2 = funds2.subtract(price);
			itemsBought2++;
		}

		System.out.println("itemsBought2:" + itemsBought2);
		System.out.println("Change2:" + funds2);

	}

}
