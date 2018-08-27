package com.employee;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.employee.adapters.SalaryDAO;
import com.list.ListForReceivedSalary;
import com.list.ListForSalary;
import com.opensymphony.xwork2.ActionSupport;

public class Salary extends ActionSupport implements ServletRequestAware {

	List<ListForSalary> salaryList = new ArrayList<>();
	List<ListForReceivedSalary> empSalary = new ArrayList<>();
	List<ListForReceivedSalary> recdSalary=new ArrayList<>();
	HttpServletRequest request;
	HttpSession session = ServletActionContext.getRequest().getSession(false);
	
	

	public List<ListForReceivedSalary> getRecdSalary() {
		return recdSalary;
	}

	public void setRecdSalary(List<ListForReceivedSalary> recdSalary) {
		this.recdSalary = recdSalary;
	}

	public List<ListForSalary> getSalaryList() {
		return salaryList;
	}

	public void setSalaryList(List<ListForSalary> salaryList) {
		this.salaryList = salaryList;
	}

	public List<ListForReceivedSalary> getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(List<ListForReceivedSalary> empSalary) {
		this.empSalary = empSalary;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public String getDetailsOfAllEmployees() {

		SalaryDAO objForDAO = new SalaryDAO();
		salaryList = objForDAO.getAllDetails();
		recdSalary=objForDAO.getSalaryHistory();
		return SUCCESS;
	}

	public String salaryToTable() {
		String empId = request.getParameter("empid");
		String on = new java.util.Date().toString();
		String currentDate = on.substring(4, 10) + on.substring(23);
		int salary = Integer.parseInt(request.getParameter("salary"));
		boolean x;
		SalaryDAO objForDAO = new SalaryDAO();
		x = objForDAO.addSalaryNotificationToTable(empId, currentDate, salary);
		if (!x) {
			addActionError("Couldn't notify. Please try again after some time");
			return INPUT;
		}
		addActionMessage("Notification Sent!");
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public String getMySalaryReceivedNotification() {
		String empId = (String) session.getAttribute("id");
		SalaryDAO objForDAO = new SalaryDAO();
		empSalary = objForDAO.getmySalaryDetails(empId);
		return SUCCESS;
	}

}
