package com.cybage;

public class ElectronicProduct extends Product implements Rating{
	//id, name, price and quantity will be inherited
	private String model;
	private int warrenty;
	public ElectronicProduct() {
		super();
	}
	public ElectronicProduct(int id, String name, int qunatity, double price) {
		super(id, name, qunatity, price);
	}
	public ElectronicProduct(int id, String name, int qunatity, double price, String model, int warrenty) {
		super(id, name, qunatity, price);
		this.model = model;
		this.warrenty = warrenty;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getWarrenty() {
		return warrenty;
	}
	public void setWarrenty(int warrenty) {
		this.warrenty = warrenty;
	}
	@Override
	public String toString() {
		return "ElectronicProduct [model=" + model + ", warrenty=" + warrenty + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getQunatity()=" + getQunatity() + ", getPrice()=" + getPrice() + "]";
	}

	@Override
	public void print() {
		System.out.println("in the electronics product class");
	}
	@Override
	public void calculateRating() {
		System.out.println("calculating rating for electronic product");		
	}	
}
