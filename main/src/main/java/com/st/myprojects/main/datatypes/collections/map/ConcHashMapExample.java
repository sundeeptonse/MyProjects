/**
 * 
 */
package com.st.myprojects.main.datatypes.collections.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author sundeeptonse
 *
 */
public class ConcHashMapExample {

	static Map<String, AtomicLong> orders = new ConcurrentHashMap<>();

	public static void processOrders() {
		for (String city : orders.keySet()) {
			for (int i = 0; i < 50; i++) {
				orders.get(city).getAndIncrement();
				// This operation along with the get operation isn't atomic
				// orders.put();
			}

		}
	}

	public static void main(String... args) throws InterruptedException {
		orders.put("Bombay", new AtomicLong());
		orders.put("Shangai", new AtomicLong());
		orders.put("California", new AtomicLong());
		orders.put("New York", new AtomicLong());

		ExecutorService execService = Executors.newFixedThreadPool(2);
		
		execService.submit(ConcHashMapExample::processOrders);
		execService.submit(ConcHashMapExample::processOrders);

		execService.awaitTermination(1, TimeUnit.SECONDS);
		execService.shutdown();

		System.out.println(orders);

	}
}
