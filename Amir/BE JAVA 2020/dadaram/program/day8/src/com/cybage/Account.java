package com.cybage;

public class Account {
	public void print(int n) {

		synchronized (this) {
			for(int i = 0; i < 5 ; i++) {
				System.out.println("thread id: " + Thread.currentThread().getId() + " output: "+ (i*n));

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println(e.getLocalizedMessage());
				}
			}	
		}


		///more logic 
		
	}
}
