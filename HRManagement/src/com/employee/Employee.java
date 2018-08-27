package com.employee;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.employee.adapters.AddEmployeeDAO;
import com.employee.adapters.AddPersonalInfoDAO;
import com.employee.adapters.DeletePersonalInfoDAO;
import com.employee.adapters.SearchEmployeeDAO;
import com.employee.adapters.UpdateEmployeeDAO;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;

public class Employee extends ActionSupport implements ServletRequestAware {

	private String empId, name, mailId, password, deptName, designation, qualification;
	private long phone;
	private int experience;
	private String doj;
	private String source;

	private File picture;
	private String dob, gender, maritalStatus, address, city, state, nationality;

	private String searchId;
	Employee emp = null;
	public String inputButton;

	HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public String getInputButton() {
		return inputButton;
	}

	public void setInputButton(String inputButton) {
		this.inputButton = inputButton;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
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

	@EmailValidator(message = "Please Enter a valid Email Address", key = "i18n.key", shortCircuit = true)
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getPhone() {
		return phone;
	}

	@RegexFieldValidator(expression = "[6789][0-9]{9}", message = "Please enter a valid phone number")
	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj.substring(0, 10);
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob.substring(0, 10);
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public void validate() {
		if (inputButton != null) {
			if (inputButton.equals("Add Employee") || inputButton.equals("Save Changes")) {
				if (!inputButton.equals("Save Changes") && picture == null) {
					addActionError("Picture Required!");
				} else if (dob.trim() == null || gender == null || maritalStatus == null || address.trim() == null
						|| city.trim() == null || state.trim() == null || nationality.trim() == null || phone <= 0
						|| experience < 0 || doj == null || empId.trim() == null || name.trim() == null
						|| mailId.trim() == null || deptName == null || designation == null || qualification == null)
					addActionError("All fields required!");
			}
		}
	}

	public String addEmployee() {

		AddEmployeeDAO objForEmployee = new AddEmployeeDAO();
		boolean x = objForEmployee.insertDetails(this);
		System.out.println(x);
		AddPersonalInfoDAO objForPersonalInfo = new AddPersonalInfoDAO();
		x = objForPersonalInfo.insertDetails(this);
		System.out.println("Success/Not: " + x);
		System.out.println(x);
		if (x) {
			addActionMessage("An employee has been registered!");
		} else
			addActionError("There was some problem!");
		return "success";
	}

	public String searchEmployee() {
		String actionRequired = null;
		System.out.println("1: " + request.getParameter("action"));
		System.out.println("2: " + request.getParameter("empid"));
		if (request.getParameter("action") != null) {
			actionRequired = request.getParameter("action");
		}
		if (actionRequired != null || inputButton.equals("Search")) {
			if (actionRequired != null && actionRequired.equals("update"))
				this.setSearchId(request.getParameter("empid"));
			SearchEmployeeDAO objForSearch = new SearchEmployeeDAO();
			emp = objForSearch.searchForEmployee(searchId);
			if (emp != null) {
				this.setEmpId(emp.getEmpId());
				this.setName(emp.getName());
				this.setMailId(emp.getMailId());
				this.setPassword(emp.getPassword());
				this.setDeptName(emp.getDeptName());
				this.setPhone(emp.getPhone());
				this.setDoj(emp.getDoj());
				this.setExperience(emp.getExperience());
				this.setQualification(emp.getQualification());
				// this.setPicture(null);
				this.setDob(emp.getDob());
				this.setGender(emp.getGender());
				this.setMaritalStatus(emp.getMaritalStatus());
				this.setAddress(emp.getAddress());
				this.setCity(emp.getCity());
				this.setState(emp.getState());
				this.setNationality(emp.getNationality());
				this.setDesignation(emp.getDesignation());
			} else
				addFieldError("searchId", "No employee with empId " + searchId);
		}
		return Action.SUCCESS;
	}

	public String manageEmployee() {
		// if (source.equals("manage")) {
		String actionRequired = null;
		if (request.getParameter("action") != null)
			actionRequired = request.getParameter("action");
		if (actionRequired != null || inputButton.equals("Delete")) {
			if (actionRequired != null && actionRequired.equals("delete"))
				this.setEmpId(request.getParameter("empid"));
			DeletePersonalInfoDAO objectForDeletePersonalInfo = new DeletePersonalInfoDAO();
			objectForDeletePersonalInfo.deletePersonalInfo(this);
			objectForDeletePersonalInfo.deleteSalary(this);
			objectForDeletePersonalInfo.deleteLeave(this);
			boolean x = objectForDeletePersonalInfo.deleteEmployee(this);

			// DeleteEmployeeDAO objectForDeleteEmployee = new DeleteEmployeeDAO();
			// boolean x = objectForDeleteEmployee.deleteEmployee(this);
			if (x) {
				/*
				 * if(request.getParameter("action")!=null) {
				 * request.setAttribute("Department",deptName); return "redirectToDept"; }
				 */
				addActionMessage(empId+"'s details successfully removed! ");
				return "deleted";

			} else
				addActionError("There was some problem in deleting!");
		} else if (inputButton.equals("Save Changes") || inputButton.equals("Update")) {
			UpdateEmployeeDAO objectForUpdateEmployee = new UpdateEmployeeDAO();
			boolean x = objectForUpdateEmployee.updateEmployeeDetails(this);
			x = objectForUpdateEmployee.updatePersonalInfoDetails(this);
			if (x)
				addActionMessage("Details successfully Updated!");
			else
				addActionError("There was some problem updating the Details. Please check the details provided!");
		}

		// }
		return Action.SUCCESS;
	}

}
