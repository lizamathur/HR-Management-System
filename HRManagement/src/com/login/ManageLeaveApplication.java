package com.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.list.ListForLeave;
import com.login.adapters.ManageLeaveDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ManageLeaveApplication extends ActionSupport {

	HttpSession session = ServletActionContext.getRequest().getSession(false);

	List<ListForLeave> leaveApplication = new ArrayList<>();

	public List<ListForLeave> getLeaveApplication() {
		return leaveApplication;
	}

	public void setLeaveApplication(List<ListForLeave> leaveApplication) {
		this.leaveApplication = leaveApplication;
	}

	public String manageLeave() {
		ManageLeaveDAO objectForLeaveManagement = new ManageLeaveDAO();
		leaveApplication = objectForLeaveManagement.getListOfLeaveApplications();
		return SUCCESS;
	}

	public String showStatus() {
		String user = (String) session.getAttribute("id");
		System.out.println("USER LOGGED IN: " + user);
		ManageLeaveDAO objectForLeaveManagement = new ManageLeaveDAO();
		leaveApplication = objectForLeaveManagement.getStatus(user);
		return SUCCESS;
	}

}
