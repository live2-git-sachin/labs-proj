package lab.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class SingletonDatabaseUtil {

//SET UP ALL THE DETAILS FOR DATABASE ACCESS

	private static final String ORACLE_USER = "hr";

	private static final String ORACLE_PASSSWORD = "hr";

	private static final String ORACLE_CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";



	private static final String MYSQL_USER = "root";

	private static final String MYSQL_PASSWORD = "mysql";

	private static final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/sakila";

   //Singleton implementation :
	
	//restrict user to create instance outside this class 
	private SingletonDatabaseUtil() {
		
	}
	
	//Create static instance of class 
	static SingletonDatabaseUtil SingletonDBUtilObj = new SingletonDatabaseUtil() ;

	
	
	
	public static SingletonDatabaseUtil getSingletonDBUtilObj() {
		return SingletonDBUtilObj;
	}
	
	
	public static Connection getConnection(DatabaseType databaseType) {

		switch (databaseType) {

		case ORACLEDB: {

			Connection connection = null;

			try {

				// Loaded the driver for Oracle.

				Class.forName("oracle.jdbc.driver.OracleDriver");

//				A connection (session) with a specific database. 

//				SQL statements are executed and results are returned within the context of a connection. 

				connection = DriverManager.getConnection(ORACLE_CONNECTION_STRING, ORACLE_USER,

						ORACLE_PASSSWORD);

				return connection;

			} catch (ClassNotFoundException e) {

				System.out.println("EXCEPTION :>> " + e);

			} catch (SQLException e) {

				System.out.println("EXCEPTION :>> " + e);

			}

			return connection;

		}

		case MYSQLDB: {
			
			Connection connection = null;

			try {

				// Loaded the driver for Oracle.

				// Deprecated Driver

				// Class.forName("com.mysql.jdbc.Driver");

				Class.forName("com.mysql.cj.jdbc.Driver");

				connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USER,

						MYSQL_PASSWORD);

				return connection;

			} catch (ClassNotFoundException e) {

				System.out.println("EXCEPTION :>> " + e);

			} catch (SQLException e) {

				System.out.println("EXCEPTION :>> " + e);

			}
			return connection;
		}

		}
		return null;

	
	}



	static public void testOracleConnection() {

		Connection connection = null;

		connection = SingletonDatabaseUtil.getConnection(DatabaseType.ORACLEDB);

		if(connection != null) {

			System.out.println("Connected to Oracle!");		

		}



	}



	static public void testMySQLConnection() {

		Connection connection = null;

		connection = SingletonDatabaseUtil.getConnection(DatabaseType.MYSQLDB);

		if(connection != null) {

		System.out.println("Connected to MySQL!");

		}

	}
	
	public static void processError(SQLException e) {
		
		System.out.println("Exception :>>  " + e.getMessage());
		
	}

}