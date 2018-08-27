package com.employee.adapters;

import java.sql.SQLException;

import com.employee.Employee;

public class SearchEmployeeDAO extends BaseDAO {

	public Employee searchForEmployee(String searchId) {
		createConnection();
		Employee employee = null;
		String sqlQuery = "";
		sqlQuery = "SELECT * FROM employee NATURAL JOIN personalinfo WHERE empId='" + searchId + "'";
		System.out.println(sqlQuery);
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			if (resultSet.next()) {
				employee = new Employee();
				employee.setEmpId(searchId);
				employee.setName(resultSet.getString("name"));
				employee.setMailId(resultSet.getString("mailId"));
				employee.setPassword(resultSet.getString("password"));
				employee.setDeptName(resultSet.getString("deptName"));
				employee.setPhone(resultSet.getLong("phone"));
				employee.setDoj(resultSet.getString("doj"));
				employee.setExperience(resultSet.getInt("experience"));
				employee.setQualification(resultSet.getString("qualification"));
				employee.setDesignation(resultSet.getString("designation"));
				employee.setPicture(null);
				employee.setDob(resultSet.getString("dob"));
				employee.setGender(resultSet.getString("gender"));
				employee.setMaritalStatus(resultSet.getString("maritalStatus"));
				employee.setAddress(resultSet.getString("address"));
				employee.setCity(resultSet.getString("city"));
				employee.setState(resultSet.getString("state"));
				employee.setNationality(resultSet.getString("nationality"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return employee;
	}

}
