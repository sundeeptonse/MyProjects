package com.st.myprojects.main.datatypes.enumt;

import java.util.HashMap;
import java.util.Map;

//Outside Class Enum Example
enum Company2 {

}

public class EnumTest {

	
	
	public enum Company {
		EBAY(30), PAYPAL(10, 20), GOOGLE(15, 20), YAHOO(20, 20), ATT(25, 25), SUNDEEP(
				50, 60, 70);
		private int value1;
		private int value2;
		private int value3;

		private Company(int value1) {
			this.value1 = value1;
		}

		private Company(int value1, int value2) {
			this(value1);
			this.value2 = value2;
		}

		private Company(int value1, int value2, int value3) {
			this(value1, value2);
			this.value3 = value3;
		}
	}

	public enum Values {
		GO, EXIT, START
	}

	public static void main(String[] args) {

		for (Company cName : Company.values()) {
			System.out
					.printf("Company:%s;Company Value1:%s; Company Value2:%s;Company Value3:%s\n",
							cName, cName.value1, cName.value2, cName.value3);

		}

		if (Company.EBAY.equals("EBAY")) {
			System.out.println("Ehll");
			System.out
					.println(Company.EBAY.value1 + "::" + Company.EBAY.value2);
		}

		Values value = Values.GO;
		switch (value) {
		case GO:
			System.out.println("GO GO GO");
			break;
		default:
			break;
		}

		double x = 10;
		double y = 20;

		System.out.println("------------------------");
		for (Operation op : Operation.values()) {
			System.out.printf("%f %s %f = %f\n", x, op, y, op.apply(x, y));
			System.out.printf("Operation %s;Operation to String %s;Operation from String(original value) \n", op,
					op.toString());
			
		}
		
		
		System.out.println("Operation:" + Operation.fromString("/"));

	}

}

/*
 * Operation Test - Method Values upon call
 */
enum Operation {
	
	PLUS("+") {
		@Override
		double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		@Override
		double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		@Override
		double apply(double x, double y) {
			
			return x * y;
		}
	},
	DIVIDE("/") {
		@Override
		double apply(double x, double y) {
			return x / y;
		}
	},
	SUBTRACTNDIVIDE("-/") {
		@Override
		double apply(double x, double y) {
			x  = MINUS.apply(x, y);
			return x / y;
		} 
	};
	
	abstract double apply(double x, double y);

	private final String symbol;
	private static String test = "Operation Yeah";
	private static final Map<String,Operation> stringToEnum = new HashMap<>();
	
	static {
		System.out.println("Test:" + test);
	}
	
	static{
		for(Operation op : values()){
			//??
			stringToEnum.put(op.toString(), op);
		}
	}
	
	public static Operation fromString(String symbol){
		return stringToEnum.get(symbol);
	}

	Operation(String symbol) {
		this.symbol = symbol;
	}

	/*
	 * 
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.symbol;
	}
}
