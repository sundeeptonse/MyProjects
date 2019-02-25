package com.permit;

/**
 * Created by stonse on 6/19/17.
 */
public class PermitChecker {

	private static String url = "https://www.recreation.gov/permits//r/entranceDetails.do?arvdate=06/19/2017&contractCode=NRSO&parkId=72201&entranceId=315840&pGroupSize=2";

	public static void main(String... args){

		HttpHelper httpHelper = new HttpHelper();
		System.out.println(httpHelper.request(url, "GET", null, null, null));

	}




}
