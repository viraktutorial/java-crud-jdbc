package controller;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection getMyConnection() throws ClassNotFoundException, SQLException {
		
		//You may be replaced by other Database
		return MySQLConnUtils.getMySQLConnection();
		
	}
}
