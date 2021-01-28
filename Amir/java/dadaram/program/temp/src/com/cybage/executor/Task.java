package com.cybage.executor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task extends Thread{
	
	@Override
	public void run() {
		System.out.println("exeucting task by " + getName() +  getId());
 
	            for (int i = 0; i<=10; i++) 
	            { 
	            	int sum =0 ;
	                sum = sum+ i; 
	               
	            } 
	            System.out.println(getName()+" complete"); 
	 
	          
	}
	
}
