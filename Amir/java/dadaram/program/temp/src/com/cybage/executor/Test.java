package com.cybage.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		System.out.println();
		ExecutorService pool = Executors.newFixedThreadPool(4);
		pool.execute(new Task()); 
        pool.execute(new Task()); 
        pool.execute(new Task()); 
        pool.execute(new Task()); 
        pool.execute(new Task());
        
        pool.shutdown();
	}
}
