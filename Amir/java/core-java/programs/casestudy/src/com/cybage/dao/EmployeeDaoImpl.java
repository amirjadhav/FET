package com.cybage.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.cybage.db.DbUtil;
import com.cybage.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	FileWriter writer = null;
	FileReader reader = null;

	@Override
	public void add(Employee emp, String type) throws Exception {
//		writer = new FileWriter("db.txt", true);
//		writer.write(emp.toString());
//		writer.close();

		Connection con = DbUtil.getCon();

		int id = emp.getId();
		String name = emp.getName();
		String address = emp.getAddress();
		int compensation = emp.getCompensation();
		String sql = "insert into emp values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.setInt(4, compensation);
		ps.setString(5, type);

		ps.executeUpdate();

		ps.close();
		con.close();

	}

	@Override // you are trying modify definition of this method
				// useful to developer
	public void delete(int id) throws Exception {
		Connection con = DbUtil.getCon();
		System.out.println("deleting record with id");
		String sql = "delete from emp where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		int result = ps.executeUpdate();

		if (result == 1) {
			System.out.println("Record Deleted");
		} else {
			System.out.println("Cannot Delete Record");
		}

		ps.close();
		con.close();

	}

	@Override
	public void display() throws Exception {
//		reader = new FileReader("db.txt");
//		int data;
//		while ((data = reader.read()) != -1) {
//			System.out.print((char) data);
//		}
//		reader.close();

		Connection con = DbUtil.getCon();

		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery("select * from emp");

		while (result.next()) {
			System.out.println(result.getInt(1) + "   " + result.getString(2) + " " + result.getString(3) + " "
					+ result.getInt(4) + " " + result.getString(5));
		}

		result.close();
		statement.close();
		con.close();

	}

	@Override
	public void displayWithId(int id) throws Exception {
		int count = 0;
		Connection con = DbUtil.getCon();
		System.out.println("Fetched record with id");
		String sql = "select * from emp where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet result = ps.executeQuery();
		if (result.next()) {
			System.out.println(result.getInt(1) + "   " + result.getString(2) + " " + result.getString(3) + " "
					+ result.getInt(4) + " " + result.getString(5));
			count++;
		}
		if (count == 0) {
			System.out.println("No record found");

		}
		result.close();
		ps.close();
		con.close();

	}

	@Override
	public void update(int id, String name, String address, int compansation, String type) throws Exception {
		Connection con = DbUtil.getCon();

		System.out.println("Updating record of " + id);
		String sql = "update emp set name= ?, address = ?, compansation = ?, emptype= ? where id= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, address);
		ps.setInt(3, compansation);
		ps.setString(4, type);
		ps.setInt(5, id);
		int result = ps.executeUpdate();

		if (result == 1) {
			System.out.println("Record Updated");
		} else {
			System.out.println("Cannot update Record");
		}

		ps.close();
		con.close();

	}

}
