package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {

	public synchronized Connection getConnection() throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection newConnection = null;
			String ip = "localhost";
			String port = "3306";
			String db = "Tazty";
			String username = "root";
			String password = "root";
			String url = "jdbc:mysql://127.0.0.1:3306/tazty?user=root&serverTimezone=UTC&useSSL=false";
			newConnection = DriverManager.getConnection(url,username,password);
			return newConnection;
		}catch (Exception e) {
			System.out.println("Connessione fallita"+e);
		}

		return null;
	}
	
	public static synchronized void releaseConnection(Connection connection) 
			throws SQLException {
		if(connection != null) connection.close();
	}	
	
	
}
