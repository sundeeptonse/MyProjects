/**
 * 
 */
package com.st.myprojects.main.datatypes.enumt;

/**
 * @author sundeeptonse
 * 
 *         Enum Strategy Pattern
 *
 */
public enum PayrollDay {

	MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(
			PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY), FRIDAY(PayType.WEEKDAY), SATURDAY(
			PayType.WEEKDAY), SUNDAY(PayType.WEEKEND);
	private final PayType payType;

	PayrollDay(PayType payType) {
		this.payType = payType;
		System.out.println(this.ordinal());
	}

	double pay(double hours, double payRate) {
		return payType.pay(hours, payRate);
	}

	private enum PayType {
		WEEKDAY {
			@Override
			double overtimePay(double hours, double payRate) {
				// TODO Auto-generated method stub
				return 2;
			}
		},
		WEEKEND {
			@Override
			double overtimePay(double hours, double payRate) {
				// TODO Auto-generated method stub
				return 10;
			}
		};

		abstract double overtimePay(double hours, double payRate);

		double pay(double hours, double payRate) {
			return (hours * payRate) + overtimePay(hours, payRate);
		}

	}

	public static void main(String... args) {
		for(PayrollDay prd :PayrollDay.values()){
			System.out.println(prd.pay(10, 20));
		}
	}

}
