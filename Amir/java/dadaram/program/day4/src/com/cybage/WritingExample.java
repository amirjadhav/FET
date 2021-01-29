package com.cybage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingExample {
	public static void main(String[] args) throws IOException  {
		//all variables in beginning....
		FileOutputStream output = null;
		String data = "i want to write this data in file...";
		
		//programming logic goes from here...
		try {
			output = new FileOutputStream("myfile.txt", true);
			output.write(data.getBytes());			
		}catch(FileNotFoundException fe) {
			System.out.println(fe.getMessage());
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}finally {
			output.close();			
		}	
	}
}
