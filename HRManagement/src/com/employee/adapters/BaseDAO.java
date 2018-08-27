package com.employee.adapters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mysql.jdbc.Driver;

public class BaseDAO {

	protected Connection connection = null;
	protected Statement statement = null;
	protected ResultSet resultSet = null;
	ResourceBundle bundle = ResourceBundle.getBundle("hrapplication");
	String dburl = bundle.getString("dburl");
	String dbuser = bundle.getString("dbuser");
	String dbpass = bundle.getString("dbpass");

	protected void createConnection() {
		try {
			new Driver();
			connection = DriverManager.getConnection(dburl, dbuser, dbpass);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void closeConnection() {
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
