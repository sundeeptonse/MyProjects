package com.st.myprojects.main.patterns.singleton;

import com.st.myprojects.main.util.DateUtil.Time;

public class MMC {

	public static void main(String[] args) {

		try {
			SingletonFactory.setStats(true, Time.ms);
			
			SingletonFactory.getSingletonInstance(null);
			
			SingletonFactory.getSingletonInstance(SingletonFact1.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact1.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact1.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact1.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact1.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact1.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact1.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact1.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact1.class).test();

			SingletonFactory.getSingletonInstance(SingletonFact2.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact2.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact2.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact2.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact2.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact2.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact2.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact2.class).test();
			SingletonFactory.getSingletonInstance(SingletonFact2.class).test();

			SingletonFactory.getSingletonInstance(SingletonFact3.class).test3();
			SingletonFactory.getSingletonInstance(SingletonFact3.class).test3();
			SingletonFactory.getSingletonInstance(SingletonFact3.class).test3();
			SingletonFactory.getSingletonInstance(SingletonFact3.class).test3();
			SingletonFactory.getSingletonInstance(SingletonFact3.class).test3();
			SingletonFactory.getSingletonInstance(SingletonFact3.class).test3();
			SingletonFactory.getSingletonInstance(SingletonFact3.class).test3();
			SingletonFactory.getSingletonInstance(SingletonFact3.class).test3();
			SingletonFactory.getSingletonInstance(SingletonFact3.class).test3();
			SingletonFactory.getSingletonInstance(SingletonFact3.class).test3();
			SingletonFactory.getSingletonInstance(SingletonFact3.class).test3();

		
		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		}

	}

}
