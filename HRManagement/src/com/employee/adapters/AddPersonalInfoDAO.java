package com.employee.adapters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.employee.Employee;

public class AddPersonalInfoDAO extends BaseDAO {

	public boolean insertDetails(Employee emp) {
		boolean flag = false;
		int count=0;
		createConnection();
		try {
			FileInputStream inputStream = new FileInputStream(emp.getPicture());
			String sqlQuery = "INSERT INTO personalinfo values('" + emp.getEmpId() + "','"+inputStream+"','" + emp.getDob() + "','"
					+ emp.getGender() + "','" + emp.getMaritalStatus() + "','" + emp.getAddress() + "','" + emp.getCity()
					+ "','" + emp.getState() + "','" + emp.getNationality() + "')";
			System.out.println(sqlQuery);
			statement=connection.createStatement();
			count=statement.executeUpdate(sqlQuery);
			if(count>0)
				flag=true;
		} catch (FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
