package com.cybage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadingFIle {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fin = null;
		int data;
		fin = new FileInputStream("myfile.txt");

		while ((data = fin.read()) != -1) {
			System.out.print((char)data);
		}
		fin.close();
	}
}
