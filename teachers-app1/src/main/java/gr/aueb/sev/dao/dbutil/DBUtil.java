package gr.aueb.sev.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This Utility class makes a connection between database an our Data Access
 * Object(DAO).
 * 
 * @author lazaros
 * @version 0.1
 *
 */
public class DBUtil {

	private static Connection conn;

	/**
	 * No instances of this class should be available.
	 */
	private DBUtil() {
	}

	public static Connection openConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/app?serverTimezone=UTC";
			String username = "appuser";
			String password = "1234";

			conn = DriverManager.getConnection(url, username, password);
			//System.out.println("Connection Open");
			return conn;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void closeConnection() throws SQLException {
		conn.close();
	}

}
