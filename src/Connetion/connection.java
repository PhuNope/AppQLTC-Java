package Connetion;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connection {
		
		public static Connection getConnection() {
			Connection connection = null;
			try {
			     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			     try {
			    	 String urlString = "jdbc:sqlserver://LAPTOP-DHUMLTKG:1433;databaseName=QLY;integratedSecurity=true";
			    	 connection = DriverManager.getConnection(urlString, "sa", "123@");
			     } catch (SQLException e) {
			    	 e.printStackTrace();
			    	 
			     }
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
			return connection;
		}
}
