package com.login;

import com.login.adapters.PasswordDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePassword extends ActionSupport {

	String oldPassword, newPassword, requestedfor;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRequestedfor() {
		return requestedfor;
	}

	public void setRequestedfor(String requestedfor) {
		this.requestedfor = requestedfor;
	}

	@Override
	public void validate() {
		if (requestedfor == null || oldPassword == null || newPassword == null) {
			addFieldError("requestedfor", "All Fields required!");
		}
	}

	public String changePassword() {
		boolean resultForPass = false;
		PasswordDAO objectForPassword = new PasswordDAO();
		resultForPass = objectForPassword.changePassword(requestedfor, oldPassword, newPassword);
		if (!resultForPass) {
			addActionError("Incorrect Password");
			return INPUT;
		}
		addActionMessage("Password Changed Successfully!");
		return SUCCESS;
	}

}
