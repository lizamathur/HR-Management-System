package com.login;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.login.adapters.LoginDAO;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements SessionAware {

	String enteredUser;
	String enteredPassword;
	String loginButton;
	private SessionMap<String, Object> sessionMap;

	public String getEnteredUser() {
		return enteredUser;
	}

	public void setEnteredUser(String enteredUser) {
		this.enteredUser = enteredUser;
	}

	public String getEnteredPassword() {
		return enteredPassword;
	}

	public void setEnteredPassword(String enteredPassword) {
		this.enteredPassword = enteredPassword;
	}

	public String getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(String loginButton) {
		this.loginButton = loginButton;
	}

	public String redirectToLogin() {
		String userType = "employee";
		String idObtained = "";
		if (loginButton.equals("Admin Login"))
			userType = "admin";
		LoginDAO objectForLogin = new LoginDAO();
		idObtained = objectForLogin.login(userType, enteredUser, enteredPassword);
		if (idObtained.equals("")) {
			addFieldError("enteredUser", "Please Check UserId/Password");
			return INPUT;
		}
		sessionMap.put("id", idObtained);
		return SUCCESS;
	}

	public String logout() {

		sessionMap.invalidate();

		return Action.SUCCESS;

	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {

		this.sessionMap = (SessionMap<String, Object>) sessionMap;
		sessionMap.put("login", "true");

	}

}
