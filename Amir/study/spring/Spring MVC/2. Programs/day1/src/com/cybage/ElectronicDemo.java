package com.cybage;

public class ElectronicDemo {
	public static void main(String[] args) {
		System.out.println("Electronic product demo...");
		Product ep = new ElectronicProduct(101, "Computer", 5, 35000, "2020Model", 3);
		System.out.println(ep);				//ep.toString() --> from ElectronicProduct
		ep.print();
		
		
		Product cloths = new ClothsProduct(105, "Shirt", 5, 2100, 40, "White");
		System.out.println(cloths);		//cloths.toString()	--> from ClothsProduct
		cloths.print();
	}
}