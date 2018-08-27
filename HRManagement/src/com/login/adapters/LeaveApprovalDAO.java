package com.login.adapters;

import java.sql.SQLException;

import com.employee.adapters.BaseDAO;

public class LeaveApprovalDAO extends BaseDAO {

	public void processLeave(String id, String actionRequested, String from, String to) {

		createConnection();
		String sqlQuery = "UPDATE leaveapplication SET action='" + actionRequested + "' WHERE empId='" + id
				+ "' AND fromDate='" + from + "' AND toDate='" + to + "'";
		System.out.println(sqlQuery);
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sqlQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
