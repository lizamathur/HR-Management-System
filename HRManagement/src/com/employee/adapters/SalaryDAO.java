package com.employee.adapters;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.list.ListForReceivedSalary;
import com.list.ListForSalary;

public class SalaryDAO extends BaseDAO{
	
	public List<ListForSalary> getAllDetails() {
		resultSet=null;
		List<ListForSalary> details=new ArrayList<>();
		createConnection();
		String sqlQuery="select * from Employee NATURAL JOIN Designation WHERE empId NOT IN (SELECT empId FROM Salary)";
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sqlQuery);
			while (resultSet.next()) {
				ListForSalary list=new ListForSalary(resultSet.getString("empId"), resultSet.getString("name"), resultSet.getString("deptName"), resultSet.getString("designation"), resultSet.getInt("salary"));
				details.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return details;
	}

	public boolean addSalaryNotificationToTable(String empId, String on, int salary) {
		int count=0;
		boolean flag=false;
		createConnection();
		String sqlQuery="INSERT INTO Salary values('"+empId+"','"+on+"',"+salary+")";
		try {
			statement=connection.createStatement();
			count=statement.executeUpdate(sqlQuery);
			if(count>0)
				flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return flag;
		
	}
	
	
	public List<ListForReceivedSalary> getSalaryHistory() {
		resultSet = null;
		createConnection();
		List<ListForReceivedSalary> salHistory = new ArrayList<>();
		String sqlQuery = "SELECT * FROM salary";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()) {

				ListForReceivedSalary historyOfSalary = new ListForReceivedSalary(resultSet.getString("empId"),
						resultSet.getString("receiveDate"), resultSet.getInt("salary"));
				salHistory.add(historyOfSalary);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return salHistory;
	}
	
	
	
	public List<ListForReceivedSalary> getmySalaryDetails(String id) {
		resultSet=null;
		List<ListForReceivedSalary> salaryDetails=new ArrayList<>();
		createConnection();
		String sqlQuery="select * from Salary WHERE empId='"+id+"'";
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sqlQuery);
			while (resultSet.next()) {
				ListForReceivedSalary detail=new ListForReceivedSalary(resultSet.getString("empId"), resultSet.getString("receiveDate"), resultSet.getInt("salary"));
				salaryDetails.add(detail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return salaryDetails;
	}
}
