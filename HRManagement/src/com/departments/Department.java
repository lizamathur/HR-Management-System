package com.departments;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.employee.adapters.GetDepartmentDetailsDAO;
import com.list.ListForEmployees;
import com.opensymphony.xwork2.ActionSupport;

public class Department extends ActionSupport implements ServletRequestAware {

	List<ListForEmployees> employeeList = new ArrayList<>();

	HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest request) {

		this.request = request;
	}

	public List<ListForEmployees> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<ListForEmployees> employeeList) {
		this.employeeList = employeeList;
	}

	public String getDepartmentName() {
		String from = request.getParameter("from");
		request.setAttribute("Department", from);
		System.out.println("Dep: " + from);

		GetDepartmentDetailsDAO objectForDepartmentDetails = new GetDepartmentDetailsDAO();
		employeeList = objectForDepartmentDetails.getDeptDetails(from);

		return SUCCESS;
	}

}
