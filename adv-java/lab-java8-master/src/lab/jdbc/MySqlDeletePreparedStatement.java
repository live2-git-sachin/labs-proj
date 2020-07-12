package lab.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class MySqlDeletePreparedStatement {

	public static void main(String[] args) {

		Connection connection = SingletonDatabaseUtil.getConnection(DatabaseType.MYSQLDB);

		String queryString = "delete from actor  where actor_id = ?";

		System.out.println(queryString);

		PreparedStatement preparedStatement;

		try {

			preparedStatement = connection.prepareStatement(queryString);

			//ASSIGN VALUES FOR THE PARAMETERS

			preparedStatement.setInt(1, 203);

			int noOfRowsDeleted = preparedStatement.executeUpdate();

			System.out.println("Rows Deleted :> " +noOfRowsDeleted );

		} catch (SQLException e) {

			System.out.println("EXCEPTION :>> " + e);

		}

	}

}