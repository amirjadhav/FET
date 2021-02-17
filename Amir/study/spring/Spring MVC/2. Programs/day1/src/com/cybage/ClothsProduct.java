package com.cybage;

public class ClothsProduct extends Product implements Rating{
	private int size;
	private String color;
	public ClothsProduct() {
		super();
	}
	public ClothsProduct(int id, String name, int qunatity, double price) {
		super(id, name, qunatity, price);
	}
	public ClothsProduct(int id, String name, int qunatity, double price, int size, String color) {
		super(id, name, qunatity, price);
		this.size = size;
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "ClothsProduct [size=" + size + ", color=" + color + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getQunatity()=" + getQunatity() + ", getPrice()=" + getPrice() + "]";
	}
	@Override
	public void print() {
		System.out.println("in the cloths product class");
	}
	@Override
	public void calculateRating() {
		System.out.println("Calculate rating for cloths...");
	}
}