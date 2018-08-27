package com.employee.adapters;

import java.sql.SQLException;

import com.employee.Employee;

public class DeletePersonalInfoDAO extends BaseDAO {

	public boolean deletePersonalInfo(Employee emp) {
		int count = 0;
		boolean flag = false;
		createConnection();
		String sqlQuery = "DELETE FROM Personalinfo WHERE empId='" + emp.getEmpId() + "'";
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
	
	public boolean deleteSalary(Employee emp) {
		int count = 0;
		boolean flag = false;
		createConnection();
		String sqlQuery = "DELETE FROM salary WHERE empId='" + emp.getEmpId() + "'";
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
	
	public boolean deleteLeave(Employee emp) {
		int count = 0;
		boolean flag = false;
		createConnection();
		String sqlQuery = "DELETE FROM leaveapplication WHERE empId='" + emp.getEmpId() + "'";
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
	
	public boolean deleteEmployee(Employee emp) {
		int count = 0;
		boolean flag = false;
		createConnection();
		String sqlQuery = "DELETE FROM employee WHERE empId='" + emp.getEmpId() + "'";
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
