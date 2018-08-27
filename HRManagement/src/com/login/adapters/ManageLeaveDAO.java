package com.login.adapters;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employee.adapters.BaseDAO;
import com.list.ListForLeave;
import com.list.ListForReceivedSalary;
import com.list.ListForSalary;

public class ManageLeaveDAO extends BaseDAO {
	public List<ListForLeave> getListOfLeaveApplications() {
		resultSet = null;
		String tempAction = "Pending";
		createConnection();
		List<ListForLeave> leaveList = new ArrayList<>();
		String sqlQuery = "SELECT * FROM leaveapplication";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()) {

				System.out.println(resultSet.getString("empId") + " " + resultSet.getString("leaveType") + " "
						+ resultSet.getString("fromDate") + " " + resultSet.getString("toDate") + " "
						+ resultSet.getInt("days") + " " + resultSet.getString("action"));
				if (resultSet.getString("action") == null)
					tempAction = "Pending";
				else
					tempAction = resultSet.getString("action");
				System.out.println("Action: " + tempAction);
				ListForLeave applications = new ListForLeave(resultSet.getString("empId"),
						resultSet.getString("leaveType"), resultSet.getString("fromDate"),
						resultSet.getString("toDate"), resultSet.getInt("days"), tempAction);
				leaveList.add(applications);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return leaveList;
	}
	
	

	public List<ListForLeave> getStatus(String user) {
		resultSet = null;
		String tempAction = "Pending";
		createConnection();
		List<ListForLeave> leaveList = new ArrayList<>();
		String sqlQuery = "SELECT * FROM leaveapplication WHERE empId='" + user + "'";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()) {

				System.out.println(resultSet.getString("empId") + " " + resultSet.getString("leaveType") + " "
						+ resultSet.getString("fromDate") + " " + resultSet.getString("toDate") + " "
						+ resultSet.getInt("days") + " " + resultSet.getString("action"));
				if (resultSet.getString("action") == null)
					tempAction = "Pending";
				else
					tempAction = resultSet.getString("action");
				System.out.println("Action: " + tempAction);
				ListForLeave applications = new ListForLeave(resultSet.getString("empId"),
						resultSet.getString("leaveType"), resultSet.getString("fromDate"),
						resultSet.getString("toDate"), resultSet.getInt("days"), tempAction);
				leaveList.add(applications);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return leaveList;
	}
}
