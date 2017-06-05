package com.st.myprojects.main.lambda.others;

public class Sample {

	public static void main(String... args) {

		/*- Old Way
			Function has
		 		Name
				Paramaters (Lambda)
				Body (Lambda)
				Return Type
		 * */

		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("In Thread");

			}
		});
		th.start();
		System.out.println("In Main");

		//Question --> How did it know to execute run and not anything else
		Thread thL = new Thread(() -> System.out.println("In Thread Lambda"));
		thL = new Thread(() -> System.out.println("In Thread Lambda"));
		thL = new Thread(() -> System.out.println("In Thread Lambda"));
		thL = new Thread(() -> System.out.println("In Thread Lambda"));
		thL = new Thread(() -> System.out.println("In Thread Lambda"));
		thL = new Thread(() -> System.out.println("In Thread Lambda"));
		thL = new Thread(() -> System.out.println("In Thread Lambda"));
		thL = new Thread(() -> System.out.println("In Thread Lambda"));
		thL = new Thread(() -> System.out.println("In Thread Lambda"));
		thL.start();
		System.out.println("In Main2");

	}
}
