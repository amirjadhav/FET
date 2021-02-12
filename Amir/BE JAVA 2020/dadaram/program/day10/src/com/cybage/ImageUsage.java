package com.cybage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

 

public class ImageUsage {
	public void addImage() throws Exception{
		//1. get connection
		Connection con = DbUtil.getCon();
		
		PreparedStatement ps = con.prepareStatement("insert into imagedb values(?, ?)");
		
		FileInputStream input = new FileInputStream("d:\\image.jpeg");
		
		ps.setString(1, "profilepic");
		ps.setBinaryStream(2, input);
		
		ps.executeUpdate();
		
		
		ps.close();
		con.close();	
	}
	
	public void getImage() throws Exception{
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement("select * from imagedb");
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Blob image = rs.getBlob(2);
			byte imageArray[] = image.getBytes(1, (int)image.length());
			
			FileOutputStream output = new FileOutputStream("d:\\myimage.jpeg");
			output.write(imageArray);
			output.close();
		}
		rs.close();
		ps.close();
		con.close();
	}
}