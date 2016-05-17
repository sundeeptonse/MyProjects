package com.st.myprojects.main.datatypes.array;

import com.st.myprojects.main.util.DateUtil;
import com.st.myprojects.main.util.DateUtil.Time;

public class Autoboxing {

	public static void main(String... args) {
		int value =0XFF;
		System.out.println("value" + value);
		
		new Autoboxing().testSpeed(Boolean.TRUE);
		new Autoboxing().testSpeed(Boolean.FALSE);

	}

	public void testSpeed(boolean isPrimitive) {
		long timeInNano = System.nanoTime();
		if (isPrimitive) {
			long sum = 0L;
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				sum+=i;
			}
			System.out.println("Primitive:" + isPrimitive + ":Sum is:" + sum);
		} else {
			Long sum = 0L;
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				sum+=i;
			}
			System.out.println("Primitive:" + isPrimitive + ":Sum is:" + sum);
		}
		DateUtil.printDateDifference(timeInNano, Time.ms);
	}

}
