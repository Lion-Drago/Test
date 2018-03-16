package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Zapytannya {

	public static void zapyt1(String dep_name) {
		try (Connection c = DriverManager.getConnection("jdbc:sqlite:sqlite.db")) {

			String sql = "SELECT name, department,  head_of_department FROM employee WHERE head_of_department = 'true'";

			try (Statement stmt = c.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

				while (rs.next()) {

					String name = rs.getString(1);
					String department = rs.getString(2);

					if (department.contains(dep_name))
						System.out.println("Head of " + department + " department is " + name);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void zapyt2(String dep_name) {
		try (Connection c = DriverManager.getConnection("jdbc:sqlite:sqlite.db")) {

			String sql = "SELECT department, degree, COUNT(*) FROM employee GROUP BY department, degree";

			try (Statement stmt = c.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

				while (rs.next()) {

					String department = rs.getString(1);
					String degree = rs.getString(2);
					int count = rs.getInt(3);
					if (department.contains(dep_name))
						System.out.printf("%-20s %2d\n", degree, count);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void zapyt3(String dep_name) {
		try (Connection c = DriverManager.getConnection("jdbc:sqlite:sqlite.db")) {

			String sql = "SELECT department, AVG(salary) FROM employee GROUP  BY department";

			try (Statement stmt = c.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

				while (rs.next()) {

					String department = rs.getString(1);
					double avg = rs.getInt(2);
					if (department.contains(dep_name))
						System.out.println("The average salary of " + department + " is " + avg);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void zapyt4(String dep_name) {
		try (Connection c = DriverManager.getConnection("jdbc:sqlite:sqlite.db")) {

			String sql = "SELECT department, COUNT(*) FROM employee GROUP  BY department";

			try (Statement stmt = c.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

				while (rs.next()) {

					String department = rs.getString(1);
					int count = rs.getInt(2);
					if (department.contains(dep_name))
						System.out.printf("In the department of %-7s - %2d employees \n", department, count);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void zapyt5(String str) {
		try (Connection c = DriverManager.getConnection("jdbc:sqlite:sqlite.db")) {

			String sql = "SELECT DISTINCT name FROM employee";

			try (Statement stmt = c.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

				while (rs.next()) {

					String name = rs.getString(1);

					if (name.contains(str))
						System.out.println(name);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
