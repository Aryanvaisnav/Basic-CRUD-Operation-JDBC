package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentUpdate {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "Aryan@18";
		
		String sql = "Update student set name = 'Arjun', email = 'arjun@gmail.com' where id = 9";
		Connection connection = null;
		
		// STEP-1: Load/Register the driver
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2: Establish Connection
			connection = DriverManager.getConnection(url, username, password);
			
			// 3.Establish Statement
			Statement statement = connection.createStatement();
			
			// 4.Execute the Statement
			int a = statement.executeUpdate(sql);
			
			if(a>0) {
				System.out.println("UPDATED");
			}
			else {
				System.out.println("NOT UPDATED");
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
