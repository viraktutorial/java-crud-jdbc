package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	
	public static Connection getMySQLConnection() {
			

			String dbURL = "jdbc:mysql://localhost:8889/empdb";
			String username = "root";
			String password = "root";
			
			 Connection conn=null;
			 
			try {
			 
			    conn = DriverManager.getConnection(dbURL, username, password);
			 
			    if (conn != null) {
			        System.out.println("Connected");
			    }
			} catch (SQLException ex) {
			    ex.printStackTrace();
			}
			return conn;
				
	}
	
}
