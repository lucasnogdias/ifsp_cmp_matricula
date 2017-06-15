package ch.makery.address.model;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
	 * SqlConnector class.
	 * Now it is just a stub, in the future the connector should connect to the DB and have functions that do the needed queries.
	 */
public class SqlConnector {
	/**
	 * Constructor for the SqlConnector class.
	 * It's just a stub now, so it must be implemented. I believe the DB address can be passed as a parameter to this constructor.
	 * The connection itself should probably be stored in a private class variable, but it will depend on how the connection actually works.
	 */
	public SqlConnector(String addr){
		//TODO: Connect to the DB and save the connection on a class private variable. The adress, if needed, should be passed as parameter.
		System.out.println("Creating SQL Connector to connect on "+addr+"... Still a empty stub, check 'TODO' to implement.");
		String url = "jdbc:mysql://localhost:3307/javabase";
		String username = "root";
		String password = "root";

		System.out.println("Connecting database...");

		try (java.sql.Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
}
