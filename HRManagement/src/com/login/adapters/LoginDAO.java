package com.login.adapters;

import java.sql.SQLException;

import com.employee.adapters.BaseDAO;

public class LoginDAO extends BaseDAO {
	public String login(String userType, String userId, String userPass) {
		String sqlQuery;
		String result = "";
		createConnection();
		if (userType.equals("admin"))
			sqlQuery = "SELECT * FROM hr WHERE hrId='" + userId + "'AND hrPassword='" + userPass + "'";
		else
			sqlQuery = "SELECT * FROM employee WHERE empId='" + userId + "'AND password='" + userPass + "'";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			if (resultSet.next())
				result = userId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return result;

	}
}
