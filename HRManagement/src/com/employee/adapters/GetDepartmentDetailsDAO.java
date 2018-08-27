package com.employee.adapters;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.list.ListForEmployees;

public class GetDepartmentDetailsDAO extends BaseDAO {

	public List<ListForEmployees> getDeptDetails(String deptName) {
		resultSet = null;
		createConnection();
		List<ListForEmployees> employeeList = new ArrayList<>();
		String sqlQuery = "SELECT * FROM employee WHERE deptName='" + deptName + "'";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				ListForEmployees emp = new ListForEmployees(resultSet.getString("empId"), resultSet.getString("name"),
						resultSet.getString("mailId"), resultSet.getString("deptName"),
						resultSet.getString("designation"));
				employeeList.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return employeeList;
	}

}
