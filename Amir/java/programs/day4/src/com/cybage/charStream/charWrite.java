package com.cybage.charStream;


import java.io.FileWriter;


public class charWrite {
    public static void main(String[] args) throws Exception {
        FileWriter writer = null;
        String data = "writing data into file using FileWriter";
        
        //programming
        writer = new FileWriter("charStream.txt");
        writer.write(data);
        
        writer.close();
    }
}
 