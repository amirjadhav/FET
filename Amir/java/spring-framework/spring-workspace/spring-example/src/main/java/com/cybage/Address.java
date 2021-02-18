package com.cybage;

public class Address {
	private int pin;
	private String location;
	public Address() {
		super();
	}
	public Address(int pin, String location) {
		super();
		this.pin = pin;
		this.location = location;
		System.out.println("address object created...");
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Address [pin=" + pin + ", location=" + location + "]";
	}
	
}
