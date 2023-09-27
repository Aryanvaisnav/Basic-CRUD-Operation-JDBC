package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSave {
	public static void main(String [] args) {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "Aryan@18";
		
		String sql = "INSERT INTO demo VALUES(1, 'ABC', 'abc@gmail.com')";
		Connection connection = null;
		
		// STEP-1: Load/Register the driver
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2: Establish Connection
			connection = DriverManager.getConnection(url, username, password);
			
			// 3.Establish Statement
			Statement statement = connection.createStatement();
			
			// 4.Execute the Statement
			statement.execute(sql);
			
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				// Close Connection
				connection.close();
				System.out.println("All Good");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

}

