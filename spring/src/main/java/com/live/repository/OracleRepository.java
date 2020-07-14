package com.live.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.live.model.Employee;

public class OracleRepository implements EmployeeRepository {

	private static final String ORACLE_USER = "hr";
	private static final String ORACLE_PASSSWORD = "hr";
	private static final String ORACLE_CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";

	@Override
	public List<Employee> getEmployees() {

		List<Employee> empList = null ;
		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection(ORACLE_CONNECTION_STRING, ORACLE_USER,
					ORACLE_PASSSWORD);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select EMPLOYEE_ID,FIRST_NAME from Employees where employee_id <110");
			
			empList = new ArrayList<>();
			//Employee employee = new Employee();
			
			while (resultSet.next()) {
			Employee employee = new Employee();	
			employee.setEMPLOYEE_ID(resultSet.getInt("EMPLOYEE_ID"));
			employee.setFIRST_NAME(resultSet.getString("FIRST_NAME"));
			empList.add(employee);
			}

		} catch (SQLException e) {

			System.out.println("EXCEPTION :>> " + e);

		} catch (ClassNotFoundException e) {

			System.out.println("EXCEPTION :>> " + e);
		}

		System.out.println("MySQL Repository");
         


		return empList;

	}

}