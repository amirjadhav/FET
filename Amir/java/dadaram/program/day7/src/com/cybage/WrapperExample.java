package com.cybage;

import java.util.ArrayList;
import java.util.List;

public class WrapperExample {
	public static void main(String[] args) {
		System.out.println("wrapper classes example");
		int salary = 123;
		
		Integer iObj = new Integer(100);	//created new object
		Integer iObj1 = 12345;		//values
		
		System.out.println(iObj.MAX_VALUE);
		System.out.println(iObj.MIN_VALUE);
		
		Integer sum = iObj + iObj1;		//auto-unboxing , auto-boxing
		Integer sum1 = iObj.intValue() + iObj1.intValue();		//auto-boxing
		
		Integer sum2 = new Integer(iObj.intValue() + iObj1.intValue()); //no auto-unboxing, no auto-boxing
		
		Double d1 = new Double(123);
	
		System.out.println(sum);
		
	}
}
