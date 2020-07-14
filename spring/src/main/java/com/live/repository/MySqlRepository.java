package com.live.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.live.model.Product;

public class MySqlRepository implements ProductRepository {

	@Override
	public List<Product> getProducts() {

		System.out.println("MySQL Repository");

		List<Product> products = new ArrayList<>();

		Product product = new Product();

		product.setProductId("P11");

		product.setProductName("MySQl");

		products.add(product);

		return products;

	}
	
	
	try ( // Establish a connection

			Connection connection = DatabaseUtil.getConnection(DatabaseType.ORACLEDB);

			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

			ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES where employee_id < 105");) {

		while (resultSet.next()) {

			int employeeId = resultSet.getInt("EMPLOYEE_ID");

			String firstName = resultSet.getString("FIRST_NAME");

			System.out.println(employeeId + "   " + firstName);

		}


	} catch (Exception e) {

		System.out.println("EXCEPTION :>> " + e);

	}

}