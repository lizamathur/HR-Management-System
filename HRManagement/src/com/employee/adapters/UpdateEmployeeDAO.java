package com.employee.adapters;

import java.sql.SQLException;

import com.employee.Employee;

public class UpdateEmployeeDAO extends BaseDAO {

	public boolean updateEmployeeDetails(Employee emp) {
		boolean flag = false;
		int count = 0;
		createConnection();
		String sqlQuery = "UPDATE employee SET name='" + emp.getName() + "', mailId='" + emp.getMailId() + "',"
				+ "deptName='" + emp.getDeptName() + "',phone=" + emp.getPhone() + ", designation='"
				+ emp.getDesignation() + "' WHERE empId='" + emp.getEmpId() + "'";
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

	public boolean updatePersonalInfoDetails(Employee emp) {
		boolean flag = false;
		int count = 0;
		createConnection();
		String sqlQuery = "UPDATE personalinfo SET maritalStatus='" + emp.getMaritalStatus() + "', address='"
				+ emp.getAddress() + "'," + "city='" + emp.getCity() + "',state='" + emp.getState() + "' WHERE empId='"
				+ emp.getEmpId() + "'";
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
