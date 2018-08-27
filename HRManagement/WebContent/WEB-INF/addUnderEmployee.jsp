<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<s:include value="headerForHR.jsp"></s:include>

<html>

<head>
<sx:head />

<s:fielderror />
<s:actionerror />
<s:actionmessage />

<title>Add Employee</title>
<style type="text/css">
form {
	margin-left: 30px;
}

#table1 {
	border-collapse: separate;
	border-spacing: 5em 1em;
}

body {
	background-image:
		url(https://png.pngtree.com/thumb_back/fw800/back_pic/04/48/50/00585a3568a0a7d.jpg);
	background-size: cover;
	font-weight: bolder;
}
</style>
</head>


<body>


	<s:form action="addEmployee" theme="xhtml" method="post"
		validate="true" enctype="multipart/form-data">

		<s:hidden name="source" value="add"></s:hidden>
		<table id="table1">

			<tr>
				<td>Employee ID</td>
				<td><s:textfield name="empId" theme="simple"></s:textfield></td>
				<td>Picture</td>
				<td><s:file name="picture" theme="simple"></s:file></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><s:textfield name="name" theme="simple"></s:textfield></td>
				<td>Date Of Birth</td>
				<td><sx:datetimepicker name="dob" displayFormat="dd-MMM-yyyy"
						value="%{'2000-01-01'}" /></td>

			</tr>
			<tr>
				<td>Mail ID</td>
				<td><s:textfield name="mailId" theme="simple"></s:textfield></td>
				<td>Gender</td>
				<td><s:select list="{'F','M'}" name="gender"
						theme="simple"></s:select></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><s:password name="password" theme="simple"></s:password></td>
				<td>Marital Status</td>
				<td><s:select
						list="{'Single','Married','Divorced'}"
						name="maritalStatus" theme="simple"></s:select></td>
			</tr>
			<tr>
				<td>Department</td>
				<td><s:select list="{'Marketing','Production','Accounts','Sales','Quality Assurance'}"
						name="deptName" theme="simple"></s:select></td>
				<td>Address</td>
				<td><s:textarea name="address" theme="simple"></s:textarea></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><s:textfield name="phone" theme="simple" required="true"></s:textfield></td>
				<td>City</td>
				<td><s:textfield name="city" theme="simple"></s:textfield></td>
			</tr>

			<tr>
				<td>Date Of Joining</td>
				<td><sx:datetimepicker name="doj" displayFormat="dd-MMM-yyyy"
						value="%{'today'}" /></td>
				<td>State</td>
				<td><s:textfield name="state" theme="simple"></s:textfield></td>
			</tr>
			<tr>
				<td>Experience</td>
				<td><s:textfield name="experience" theme="simple"
						required="true" /></td>
				<td>Nationality</td>
				<td><s:textfield name="nationality" theme="simple"></s:textfield></td>
			</tr>
			<tr>
				<td>Qualification</td>
				<td><s:select
						list="{'Bachelors','Masters','CA','CS','CMA'}"
						name="qualification" theme="simple"></s:select></td>
				<td>Designation</td>
				<td><s:select
						list="{'Manager','Clerk','Staff'}"
						name="designation" theme="simple"></s:select></td>
			</tr>
			<tr>
				<td></td>
				<td><s:submit name="inputButton" value="Add Employee"
						theme="simple" onclick="this.form.reload();"
						cssClass="btn btn-success"></s:submit></td>
				<td></td>
				<td></td>
			</tr>

		</table>
	</s:form>
	<div align="center">
		<s:form action="add" method="post">
			<s:submit name="reset" value="Reset"
							theme="simple"
							cssClass="btn btn-info"></s:submit>
		</s:form>
	</div>
	<s:include value="footer.jsp"></s:include>
</body>

</html>