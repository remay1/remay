package com.dev.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;

public class Connector {

	public Connection getConnection() {
		// TODO Auto-generated method stub
		
		Context initContext;
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection( "jdbc:mariadb://localhost:3306/db_remay", "remay", "jojoho1");
			
			/*
			Class.forName("org.mariadb.jdbc.Driver");
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/MariaDB");
			conn = ds.getConnection();*/
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	void showTestData(Connection conn) {
		String sql = "select * from testdata";
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				String foo = rs.getString("foo");
				int bar = rs.getInt("bar");
				System.out.printf("%s, %d \n" , foo, bar);
			}
		}catch (SQLException e){
			
		}
	}

}
