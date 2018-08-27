package com.login;

import com.login.adapters.LeaveDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LeaveApplication extends ActionSupport {

	String leaveId;
	String leaveType;
	String fromDate;
	String toDate;

	public String getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
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
		this.fromDate = fromDate.substring(0, 10);
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate.substring(0, 10);
	}

	@Override
	public void validate() {
		if (leaveType == null || fromDate == null || toDate == null) {
			addFieldError("toDate", "All fields Required!");
		}
	}

	public String insertLeave() {
		LeaveDAO dao = new LeaveDAO();
		Boolean flag = dao.requestLeave(this);
		if (!flag) {
			addActionError("There was some problem!");
			return "input";
		}
		addActionError("Your leave application has been submitted!");
		return SUCCESS;
	}
}
