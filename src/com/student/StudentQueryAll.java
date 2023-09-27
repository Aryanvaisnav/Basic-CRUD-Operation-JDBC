package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentQueryAll {
	public static void main(String [] args) {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "Aryan@18";
		
		String sql = "Select * from student";
		Connection connection = null;
		
		// STEP-1: Load/Register the driver
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2: Establish Connection
			connection = DriverManager.getConnection(url, username, password);
			
			// 3.Establish Statement
			Statement statement = connection.createStatement();
			
			// 4.Execute the Statement
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println("==========================================================================================");
				
			}
			
			
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
