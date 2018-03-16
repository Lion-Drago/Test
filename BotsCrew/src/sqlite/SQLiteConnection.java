package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnection {

	public static void connect() {
		
		Connection conn = null;
		try {

			String url = "jdbc:sqlite:sqlite.db";

			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.\n");

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
			
			while (rs.next()) {
				System.out.printf("%2d %-15s %-20s %5d %-12s %5s\n",						
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getInt(4),
							rs.getString(5),
							rs.getString(6));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		connect();

	}
}
