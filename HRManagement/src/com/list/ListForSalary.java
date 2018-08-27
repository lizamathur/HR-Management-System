package com.list;

public class ListForSalary {
	
	String empId,name,deptName,designation;
	int salary;
	
	public ListForSalary(String empId, String name, String deptName, String designation, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.deptName = deptName;
		this.designation = designation;
		this.salary = salary;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	

}
