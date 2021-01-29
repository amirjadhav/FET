package com.cybage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriting {
	public static void main(String[] args) throws IOException {
		FileOutputStream f = null;
		String data = "Data into file\n";
		try {
			f = new FileOutputStream("myfile.txt",true);
			f.write(data.getBytes());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		finally {
			f.close();
		}
	}
}
