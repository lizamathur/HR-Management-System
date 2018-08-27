package com.login.adapters;

import java.sql.SQLException;

import com.employee.adapters.BaseDAO;
import com.login.LeaveApplication;

public class LeaveDAO extends BaseDAO {
	boolean flag;

	public boolean requestLeave(LeaveApplication leaveApplication) {

		int count = 0;
		createConnection();
		String sqlQuery = "INSERT INTO Leaveapplication VALUES('" + leaveApplication.getLeaveId() + "','"
				+ leaveApplication.getLeaveType() + "','" + leaveApplication.getFromDate() + "','"
				+ leaveApplication.getToDate() + "',(to_days('" + leaveApplication.getToDate() + "')-to_days('"
				+ leaveApplication.getFromDate() + "')+1),NULL)";
		System.out.println(sqlQuery);
		try {
			statement = connection.createStatement();
			count = statement.executeUpdate(sqlQuery);
			if (count > 0)
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return flag;
	}
}
