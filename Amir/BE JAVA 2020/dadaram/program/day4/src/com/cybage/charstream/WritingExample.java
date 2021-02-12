package com.cybage.charstream;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WritingExample {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileWriter writer = null;
		String data = "i want to write this data using filewriter";
		
		//programming
		writer = new FileWriter("charstream.txt");
		writer.write(data);
		
		writer.close();
	}
}
