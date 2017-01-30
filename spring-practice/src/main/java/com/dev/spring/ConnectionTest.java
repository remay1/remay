package com.dev.spring;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionTest {

	@Test
	public void test() throws SQLException {
		Connector connector = new Connector();
		Connection conn = connector.getConnection();
		assertNotNull(conn);
		
		connector.showTestData(conn);
		
	}

}
