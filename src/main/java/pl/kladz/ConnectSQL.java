package pl.kladz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSQL {
	
	static String jdbcUrl = "jdbc:postgresql://localhost:5432/quiz";
	static String username = "postgres";
	static String password = "postgres";
	
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	public static void connectToSQL() {
		
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(jdbcUrl, username, password);
			stmt = conn.createStatement();

		} catch (ClassNotFoundException ex) {
			System.out.println("Nie udalo sie podlaczyc do bazy");
			ex.printStackTrace();
		}

		catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Problem z zalogowaniem sie do servera");
		}
	}
}
