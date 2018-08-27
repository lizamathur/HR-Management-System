package com.list;

public class ListForLeave {

	String empId, leaveType, fromDate, toDate, action;
	int days;

	public ListForLeave(String empId, String leaveType, String fromDate, String toDate, int days, String action) {
		super();
		this.empId = empId;
		this.leaveType = leaveType;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.days = days;
		this.action = action;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
