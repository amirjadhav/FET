package com.cybage;

public abstract class Product  {
	//instance variables
	private int id;
	private String name;
	private int qunatity;
	private double price;
	public Product() {
	}
	public Product(int id, String name, int qunatity, double price) {
		super();
		this.id = id;
		this.name = name;
		this.qunatity = qunatity;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQunatity() {
		return qunatity;
	}
	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", qunatity=" + qunatity + ", price=" + price + "]";
	}
	
	public abstract void print();		//abstract method, has to be implemented by child
}