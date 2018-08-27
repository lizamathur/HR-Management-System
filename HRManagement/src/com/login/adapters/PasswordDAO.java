package com.login.adapters;

import java.sql.SQLException;

import com.employee.adapters.BaseDAO;

public class PasswordDAO extends BaseDAO {
	boolean flag = false;
	int count = 0;

	public boolean changePassword(String id, String oldPassword, String newPassword) {
		createConnection();
		String sqlQuery = "UPDATE employee SET password='" + newPassword + "' WHERE empId='" + id + "' AND password='"
				+ oldPassword + "'";
		try {
			statement = connection.createStatement();
			count = statement.executeUpdate(sqlQuery);
			if (count > 0)
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
