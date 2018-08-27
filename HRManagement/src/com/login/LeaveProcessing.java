package com.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.login.adapters.LeaveApprovalDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LeaveProcessing extends ActionSupport implements ServletRequestAware {
	HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public String processLeaveApplication() {
		String id = request.getParameter("empid");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String actionRequested = request.getParameter("action");
		if (actionRequested.equals("approve")) {
			LeaveApprovalDAO objForApproval = new LeaveApprovalDAO();
			objForApproval.processLeave(id, "Approved", from, to);
			addActionMessage("You just Approved a Leave!");
		}
		if (actionRequested.equals("reject")) {
			LeaveApprovalDAO objForApproval = new LeaveApprovalDAO();
			objForApproval.processLeave(id, "Rejected", from, to);
			addActionMessage("You just Rejected a Leave!");
		}

		return SUCCESS;
	}

}
