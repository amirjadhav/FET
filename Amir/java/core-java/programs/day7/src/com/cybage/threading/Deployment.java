package com.cybage.threading;

public class Deployment extends Thread {
	@Override
	public void run() {
		try {
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("3. i am Deploying code");
	}
}