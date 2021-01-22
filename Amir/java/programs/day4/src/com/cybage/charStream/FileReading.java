package com.cybage.charStream;

import java.io.FileReader;

public class FileReading {
	public static void main(String[] args) throws Exception {
		FileReader reader = null;
		int data;

		// programming logic
		reader = new FileReader("charStream.txt");

		while ((data = reader.read()) != -1) {
			System.out.print((char) data);
		}

		reader.close();
	}
}