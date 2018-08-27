<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<s:if test="%{#session.id=='admin'}">
	<s:include value="headerForHR.jsp" />
</s:if>
<s:else>
	<s:include value="headerForEmployees.jsp" />
</s:else>
<html>

<head>
<sx:head />
<s:fielderror />
<s:actionerror />
<s:actionmessage />
<title>Manage</title>
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


	<s:if test="%{#session.id=='admin'}">
		<s:form action="searchEmployee" theme="xhtml" method="get">
			<s:hidden name="source" value="search"></s:hidden>
			<div align="middle">
				Enter Employee ID&nbsp;&nbsp;&nbsp;
				<s:textfield name="searchId" theme="simple" />
				<s:submit name="inputButton" theme="simple" value="Search"></s:submit>
			</div>
		</s:form>
	</s:if>




	<s:form action="manageEmployee" theme="xhtml" method="post"
		enctype="multipart/form-data">
		<s:hidden name="source" value="manage"></s:hidden>
		<table id="table1">

			<tr>
				<td>Employee ID</td>
				<td><s:property value="empId" /></td>
				<s:hidden value="%{empId}" name="empId" />
				<td>Picture</td>
				<td>Nothing to display</td>
				
			</tr>
			<tr>
				<td>Name</td>
				<td><s:textfield name="name" theme="simple"></s:textfield></td>
				<td>Date Of Birth</td>
				<td><s:property value="dob" /></td>
				<s:hidden value="%{dob}" name="dob" />

			</tr>
			<tr>
				<td>Mail ID</td>
				<td><s:textfield name="mailId" theme="simple"></s:textfield></td>
				<td>Gender</td>
				<td><s:property value="gender" /></td>
				<s:hidden value="%{gender}" name="gender" />
			</tr>
			<tr>
				<td>Password</td>
				<td><s:url action="change" var="change" escapeAmp="false">
						<s:param name="requestedfor">
							<s:property value="empId" />
						</s:param>
					</s:url> <a href="<s:property value="#change" />">Change Password</a></td>
				<td>Marital Status</td>
				<td><s:select list="{'Single','Married','Divorced'}"
						name="maritalStatus" theme="simple"></s:select></td>
			</tr>
			<tr>
				<td>Department</td>
				<s:if test="%{#session.id=='admin'}">
					<td><s:select
							list="{'Marketing','Production','Accounts','Sales','Quality Assurance'}"
							name="deptName" theme="simple" /></td>
				</s:if>
				<s:else>
					<td><s:property value="deptName" /></td>
					<s:hidden value="%{deptName}" name="deptName" />
				</s:else>

				<td>Address</td>
				<td><s:textarea name="address" theme="simple" /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><s:textfield name="phone" theme="simple" /></td>
				<td>City</td>
				<td><s:textfield name="city" theme="simple" /></td>
			</tr>

			<tr>
				<td>Date Of Joining</td>
				<td><s:property value="doj" /></td>
				<s:hidden value="%{doj}" name="doj" />
				<td>State</td>
				<td><s:textfield name="state" theme="simple" /></td>
			</tr>
			<tr>
				<td>Experience</td>
				<td><s:property value="experience" /></td>
				<s:hidden value="%{experience}" name="experience" />
				<td>Nationality</td>
				<td><s:property value="nationality" /></td>
				<s:hidden value="%{nationality}" name="nationality" />
			</tr>
			<tr>
				<td>Qualification</td>
				<td><s:property value="qualification" /></td>
				<s:hidden value="%{qualification}" name="qualification" />
				<td>Designation</td>
				<s:if test="%{#session.id=='admin'}">
					<td><s:select list="{'Manager','Clerk','Staff'}"
							name="designation" theme="simple"></s:select></td>
				</s:if>
				<s:else>
					<td><s:property value="designation" /></td>
					<s:hidden value="%{designation}" name="designation" />
				</s:else>
			</tr>
			<tr></tr>
			<tr>
				<td><s:submit value="Save Changes" name="inputButton"
						theme="simple" onclick="this.form.reload();"
						cssClass="btn btn-success" /></td>
				<s:if test="%{#session.id=='admin'}">
					<td><s:submit value="Delete" name="inputButton" theme="simple"
							onclick="this.form.reload();" cssClass="btn btn-danger" /></td>
				</s:if>
				<td></td>
				<td></td>
			</tr>

		</table>
	</s:form>

	<div align="center">
		<s:if test="%{#session.id=='admin'}">
			<s:form action="manage" method="post">
				<s:submit name="reset" value="Reset" theme="simple"
					cssClass="btn btn-info"></s:submit>
			</s:form>
		</s:if>
	</div>
<s:include value="footer.jsp"></s:include>
</body>

</html>