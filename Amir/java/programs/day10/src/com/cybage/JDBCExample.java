package com.cybage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class JDBCExample {

	public void getResultInfo() throws Exception {

		String sql = "select * from customer";

		// 1. get connection
		Connection con = DbUtil.getCon();

		// 2 . Create preparedStatement
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		ResultSetMetaData metaData = rs.getMetaData();

		System.out.println("Number of Records" + metaData.getColumnCount());

	}

	public void getInfo() throws Exception {
		Connection con = DbUtil.getCon();

		java.sql.DatabaseMetaData dbMetaData = con.getMetaData();
		System.out.println(dbMetaData.getUserName());
		System.out.println(dbMetaData.getDriverName());
		System.out.println(dbMetaData.getDriverVersion());
		System.out.println(dbMetaData.getDriverMinorVersion());
	}

	public void txnMgmnt() throws Exception {
		Connection con = DbUtil.getCon();
		con.setAutoCommit(false);
		PreparedStatement ps = con.prepareStatement("insert into customer(1245,'amirjadhav',2354");
		ps.executeUpdate();
		
		
		
		con.
	}
}