package rishabhSQL;

import java.sql.*;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedstatement = null;
	private ResultSet resultset = null;
	
	MySQLAccess(String args, String args2) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://"+args+"/MyDB?"
							+ "user=root&password=" + args2);
			// Display();
		} catch (Exception e) {
			System.out.println("In Constructor:");
			e.printStackTrace();
			System.out.println("Error message:" + e.getMessage());
		}
	}

	public void insert(String name, int salary) {
		try {
			preparedstatement = connect
					.prepareStatement("insert into MyDB.employees values (default, ? ,?)");
			preparedstatement.setString(1, name);
			preparedstatement.setInt(2, salary);
			preparedstatement.executeUpdate();
			System.out.println("Table after inserting:" + name);
			Display();
		} catch (Exception e) {
			System.out.println("In Insert:");
			e.printStackTrace();
			System.out.println("Error message:" + e.getMessage());
		}
	}

	public void deleteByName(String name) {
		try {
			preparedstatement = connect
					.prepareStatement("delete from MyDB.employees where name= ? ; ");
			preparedstatement.setString(1, name);
			preparedstatement.executeUpdate();
			System.out.println("Table after deleting:" + name);
			Display();
		} catch (Exception e) {
			System.out.println("In Delete:");
			e.printStackTrace();
			System.out.println("Error message:" + e.getMessage());
		}
	}

	public void Display() {
		try {

			statement = connect.createStatement();
			resultset = statement.executeQuery("select * from MyDB.employees ");
			while (resultset.next()) {
				String name = resultset.getString("name");
				int salary = resultset.getInt(3);
				System.out.println("Name: " + name);
				System.out.println("Salary: " + salary);
			}
		} catch (Exception e) {
			System.out.println("In Display:");
			e.printStackTrace();
			System.out.println("Error message:" + e.getMessage());
		}
	}

	public void close() {
		try {
			if (resultset != null) {
				resultset.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			System.out.println("In Close:");
			e.printStackTrace();
			System.out.println("Error message:" + e.getMessage());
		}
	}

}
