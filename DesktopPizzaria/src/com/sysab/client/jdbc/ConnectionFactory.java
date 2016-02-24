package com.sysab.client.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/pizzaria", "root", "1234");
		} catch (SQLException e) {
			throw new RuntimeException("Impossível realizar uma conexão com MySQL", e);
		}
	}
}
