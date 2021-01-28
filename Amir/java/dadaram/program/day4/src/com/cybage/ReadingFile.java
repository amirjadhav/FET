package com.cybage;

import java.io.FileInputStream;

public class ReadingFile {
	public static void main(String[] args) throws Exception{
		//declaration
		FileInputStream input = null;
		int data;
		
		//programming logic
		input = new FileInputStream("myfile.txt");
		
		while( (data = input.read()) != -1) {
			System.out.print((char)data);	
		}
		input.close();
		
	}
}
