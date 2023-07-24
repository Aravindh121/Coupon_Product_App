package com.aravindh.cnp.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import javax.naming.*;



public class ConnectionUtil {
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:comp/env/myResource");
			connection = ds.getConnection();
			System.out.println(connection);
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
}
