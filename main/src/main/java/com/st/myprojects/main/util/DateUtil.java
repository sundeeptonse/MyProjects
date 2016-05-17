package com.st.myprojects.main.util;


public class DateUtil {

	public enum Time {
		ns(1),
		mis(TimeConvert.mis_ns.value*Time.ns.value),
		ms(TimeConvert.ms_mis.value*Time.mis.value), 
		ss(TimeConvert.ss_ms.value*Time.ms.value), 
		mm(TimeConvert.mm_ss.value*Time.ss.value), 
		hh(TimeConvert.hh_mm.value*Time.mm.value),
		DD(TimeConvert.DD_hh.value*Time.hh.value), 
		YY(TimeConvert.YY_DD.value*Time.DD.value);
		
		long value;
		Time(long pValue){
			this.value = pValue;
		}
		
	}
	
	private enum TimeConvert {
		mis_ns(1000),ms_mis(1000),ss_ms(1000),mm_ss(60),hh_mm(60),DD_hh(24),YY_DD(365);
		long value;
		TimeConvert(long pValue){
			this.value = pValue;
		}
	}
	
	public static final void printDateDifference(long timeInNano, Time time){
		long dateDiff = System.nanoTime() - timeInNano;
		dateDiff/=time.value;
		StringBuilder sb = new StringBuilder();
		sb.append("Date Difference in ").append(time).append(" is ").append(dateDiff);
		System.out.println(sb.toString());
			
	}
}
