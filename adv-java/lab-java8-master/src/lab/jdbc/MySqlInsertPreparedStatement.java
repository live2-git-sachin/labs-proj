package lab.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class MySqlInsertPreparedStatement {

	public static void main(String[] args) {

		Connection connection = SingletonDatabaseUtil.getConnection(DatabaseType.MYSQLDB);

		

		int actor_id = 201;

		String first_name = "actorFirstName1";
		
		String last_name = "actorLastName1";

		//Date last_update = Date.valueOf(now());

	   	//SingletonDatabaseUtil.testMySQLConnection();

		String queryString = "insert into actor values (?,?,?,now())";

		System.out.println(queryString);

		PreparedStatement preparedStatement;

		try {

			preparedStatement = connection.prepareStatement(queryString);

			

			//ASSIGN VALUES FOR THE PARAMETERS

			for(int rows = 0; rows<5; rows++) {

			preparedStatement.setInt(1, actor_id+rows);

			preparedStatement.setString(2, first_name+rows);
			
			preparedStatement.setString(3, last_name+rows);

			//preparedStatement.setDate(3, last_name+rows);

			int noOfRowsInserted = preparedStatement.executeUpdate();

			System.out.println("Rows Inserted :> " + 1);

			}

		} catch (SQLException e) {

			System.out.println("EXCEPTION :>> " + e);

		}



	}

}