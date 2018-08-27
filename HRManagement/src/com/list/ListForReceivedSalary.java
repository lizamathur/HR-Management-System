package com.list;

public class ListForReceivedSalary {
	
	String empId,receiveDate;
	int salary;
	public ListForReceivedSalary(String empId, String receiveDate, int salary) {
		super();
		this.empId = empId;
		this.receiveDate = receiveDate;
		this.salary = salary;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
