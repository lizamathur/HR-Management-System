package com.list;

public class ListForEmployees {

	String empId, name, mailId, deptName, designation;

	public ListForEmployees(String empId, String name, String mailId, String deptName, String designation) {
		super();
		this.empId = empId;
		this.name = name;
		this.mailId = mailId;
		this.deptName = deptName;
		this.designation = designation;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
