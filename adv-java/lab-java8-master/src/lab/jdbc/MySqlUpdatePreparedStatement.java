package lab.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class MySqlUpdatePreparedStatement {

	public static void main(String[] args) {

		Connection connection = SingletonDatabaseUtil.getConnection(DatabaseType.MYSQLDB);

		String queryString = "update actor set first_name = ? , last_update = now() where actor_id = ?";

		System.out.println(queryString);

		PreparedStatement preparedStatement;

		try {

			preparedStatement = connection.prepareStatement(queryString);

			

			//ASSIGN VALUES FOR THE PARAMETERS

			preparedStatement.setString(1, "updateFirstName1");

			preparedStatement.setInt(2, 201);


			int noOfRowsUpdated = preparedStatement.executeUpdate();

			System.out.println("Rows Updated :> " + noOfRowsUpdated);


		} catch (SQLException e) {

			System.out.println("EXCEPTION :>> " + e);

		}



	}

}