/**
 * 
 */
package com.st.myprojects.main.util;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author sundeeptonse
 *
 */
public class NumberUtil {

	public static void main(String... args) {
		int[] array = { 1, 1, 2, 2, 4 };

		BigInteger number = new BigInteger("1");
		number.multiply(new BigInteger("2"));
		System.out.println(number);
		System.out.println("Remove Duplicates" + removeDuplicates(array));
		
		int value = (int)Math.pow(10, 0);
		int numberRep =0;
        numberRep += numberRep*(int)Math.pow(10, 1);  
	}

	public static final int removeDuplicates(int[] array) {
		Deque<Integer> queue = new ArrayDeque<>();
		for (int value : array) {
			if (!(queue.size() > 0 && queue.peekLast() == value)) {
				queue.add(value);
			}
		}
		int i = 0;
		int size = queue.size();
		while (!queue.isEmpty()) {
			array[i++] = queue.pollFirst();
		}
		return size;
	}

	public static final int stringToInt(String string) {
		int returnValue = 0;
		int radix = 10;
		// Remove Leading and Ending Trail Spaces
		String newString = string.trim();

		if (newString.length() > 0) {
			int i = 0;
			boolean isNeg = false;
			if (newString.charAt(i) == '-') {
				isNeg = true;
				i++;
			} else if (newString.charAt(i) == '+') {
				i++;
			}

			int maxAllowedValue = isNeg ? -Integer.MIN_VALUE
					: Integer.MAX_VALUE;

			boolean leadingCharacter = true;
			int numberOfDigit = 0;
			while (i < newString.length()) {
				char charAtI = newString.charAt(i++);
				if (charAtI >= '0' && charAtI <= '9') {
					// If leadingCharacter and the initial Characters start with
					// '0'
					if (leadingCharacter && charAtI == '0') {
						continue;
					}
					leadingCharacter = false;
					int numericValue = Character.getNumericValue(charAtI);

					numberOfDigit++;
					if (numberOfDigit > 10) {
						returnValue = maxAllowedValue;
						break;
					} else {
						returnValue *= radix;
						if (maxAllowedValue - (returnValue + numericValue) <= 0) {
							returnValue = maxAllowedValue;
							break;
						} else {
							returnValue += numericValue;
						}
					}
				} else {
					break;
				}
			}
			returnValue = isNeg ? -returnValue : returnValue;
		}
		return returnValue;
	}

	public static final int reverseNumber(int number) {
		char[] charArray = String.valueOf(number).toCharArray();
		char[] finalArray;
		int i = 0;
		if (number < 0) {
			finalArray = new char[charArray.length - 1];
			i++;
		} else {
			finalArray = new char[charArray.length];
		}
		for (; i < charArray.length; i++) {
			finalArray[charArray.length - i - 1] = charArray[i];
		}
		int newNumber = 0;
		try {
			newNumber = Integer.parseInt(new String(finalArray));
		} catch (NumberFormatException nfe) {

		}
		return number < 0 ? -newNumber : newNumber;
	}

	public static final int reverseNumber2(int number) {
		String stringV = Integer.toString(number);
		StringBuilder str = new StringBuilder(stringV.length());
		int i = stringV.length() - 1;
		int end = 0;
		if (number < 0) {
			str.append("-");
			end++;
		}
		for (; i >= end;) {
			str.append(stringV.charAt(i--));
		}
		int newNumber = 0;
		try {
			newNumber = Integer.parseInt(str.toString());
		} catch (NumberFormatException nfe) {
		}
		return newNumber;
	}

	public static final boolean isEven(int number) {
		return (number % 2 == 0) ? true : false;
	}

	/*
	 * 
	 * Checks if an Integer is a prime number of not
	 * 
	 * The simplest primality test is trial division: Given an input number n,
	 * check whether any prime integer m from 2 to √n evenly divides n (the
	 * division leaves no remainder). If n is divisible by any m then n is
	 * composite, otherwise it is prime.[1]
	 * 
	 * For example, we can do a trial division to test the primality of 100.
	 * Let's look at all the divisors of 100:
	 * 
	 * 2, 4, 5, 10, 20, 25, 50 Here we see that the largest factor is 100/2 =
	 * 50. This is true for all n: all divisors are less than or equal to n/2.
	 * If we take a closer look at the divisors, we will see that some of them
	 * are redundant. If we write the list differently:
	 * 
	 * 100 = 2 × 50 = 4 × 25 = 5 × 20 = 10 × 10 = 20 × 5 = 25 × 4 = 50 × 2 the
	 * redundancy becomes obvious. Once we reach 10, which is √100, the divisors
	 * just flip around and repeat. Therefore, we can further eliminate testing
	 * divisors greater than √n.[1] We can also eliminate all the even numbers
	 * greater than 2, since if an even number can divide n, so can 2.
	 * 
	 * Let's look at another example, and use trial division to test the
	 * primality of 17. Since we now know we do not need to test using divisors
	 * greater than √n, we only need to use integer divisors less than or equal
	 * to SQRT(17). Those would be 2, 3, and 4. As stated above, we can skip 4
	 * because if 4 evenly divides 17, 2 must also evenly divide 17, which we
	 * already would have checked before that. That leaves us with just 2 and 3.
	 * After dividing, we find that 17 is not divisible by 2 or 3, and we can
	 * confirm that 17 must be prime.
	 * 
	 * The algorithm can be improved further by observing that all primes are of
	 * the form 6k ± 1, with the exception of 2 and 3. This is because all
	 * integers can be expressed as (6k + i) for some integer k and for i = −1,
	 * 0, 1, 2, 3, or 4; 2 divides (6k + 0), (6k + 2), (6k + 4); and 3 divides
	 * (6k + 3). So a more efficient method is to test if n is divisible by 2 or
	 * 3, then to check through all the numbers of form 6k+-1. This is 3 times
	 * as fast as testing all m.
	 */
	public static final boolean isPrime(int number) {

		if (number <= 1) {
			return false;
		}

		// 2 and 3
		if (number <= 3) {
			return true;
		}

		/*
		 * Check the 6k+2/4, 6k+3,
		 */
		if (number % 2 == 0 || number % 3 == 0) {
			return false;
		}

		// For the rest put it through the loop, 6k +- 1 = 5,7, 11
		// Till Root number
		for (int i = 5; i * i <= number; i = i + 6) {
			if (number % i == 0 || number % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}

	/*- 
	 * 
	 * Generates a set of Integer Primes till number n
	 * Sieve of Eratosthenes
	 * 
	 * Example :100
	 *  4, 6, 8 , 10, 12, 24...100
	 *  9, 12, 15, 18 ... 
	 *  25, 50, 75
	 *  49, 98
	 *    
	 * */
	public static final List<Integer> generatePrimes(int number) {
		List<Integer> primeArray = new ArrayList<>();
		boolean[] booleanArray = new boolean[number];

		if (number > 2) {
			booleanArray[0] = true;
			booleanArray[1] = true;
			for (int i = 2; i * i < number; i++) {
				// If True, then skip
				if (!booleanArray[i]) {
					for (int j = i * i; j < number; j = j + i) {
						if (!booleanArray[j]) {
							booleanArray[j] = true;
						}
					}
				}
			}
		}

		for (int i = 0; i < booleanArray.length; i++) {
			if (!booleanArray[i]) {
				primeArray.add(i);
			}
		}

		return primeArray;
	}
}
