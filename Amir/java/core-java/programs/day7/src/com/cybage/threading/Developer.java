package com.cybage.threading;

public class Developer extends Thread {
	@Override
	public void run() {
		try {
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("1. i am developing code");
	}

}