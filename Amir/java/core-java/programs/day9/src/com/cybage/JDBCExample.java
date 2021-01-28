package com.cybage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {

	public void getRecord() throws Exception {

		Connection con = DbUtil.getCon();
		// 3. now we can talk to database through con connection
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery("select * from customer");

		while (result.next()) {
			System.out.println(result.getInt(1) + "   " + result.getString(2)+" "+result.getInt(3));
		}

		result.close();
		statement.close();
		con.close();
	}

	public void addRecord() throws Exception {

		Connection con = DbUtil.getCon();
		// 3. now we can talk to database through con connection
		PreparedStatement ps = con.prepareStatement("insert into customer values (? , ?, ?)");
		ps.setInt(1, 1247);
		ps.setString(2, "dmjadhav2");
		ps.setInt(3, 23254);

		if (!ps.execute()) {
			System.out.println("record added successfully...");
		} else {
			System.out.println("could not add record in database...");
		}
		ps.close();
		con.close();
	}
}