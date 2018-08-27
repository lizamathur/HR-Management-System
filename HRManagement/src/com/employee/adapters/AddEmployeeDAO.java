package com.employee.adapters;

import java.sql.SQLException;

import com.employee.Employee;

public class AddEmployeeDAO extends BaseDAO {

	public boolean insertDetails(Employee emp) {
		boolean flag = false;
		int count = 0;
		createConnection();
		String sqlQuery = "INSERT INTO employee values('" + emp.getEmpId() + "','" + emp.getName() + "','"
				+ emp.getMailId() + "','" + emp.getPassword() + "','" + emp.getDeptName() + "'," + emp.getPhone() + ",'"
				+ emp.getDoj() + "'," + emp.getExperience() + ",'" + emp.getQualification() + "','"
				+ emp.getDesignation() + "')";
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
