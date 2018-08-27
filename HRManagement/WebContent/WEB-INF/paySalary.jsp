<%@page import="java.util.Date"%>
<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:include value="headerForHR.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salary Notifier</title>
<style type="text/css">
body {
	background-image:
		url(https://png.pngtree.com/thumb_back/fw800/back_pic/04/48/50/00585a3568a0a7d.jpg);
	background-size: cover;
	font-weight: bolder;
}
</style>
</head>
<body>
	<div align="center">
		<span style="font-size: 30px;">SEND <span
			style="color: #cc0000;">SALARY RECEIVED</span> NOTIFICATION</span>
		<hr />
	</div>

	<table class="table table-striped"
		style="font-size: 15px; font-weight: 600;">
		<thead>
			<tr>
				<th scope="col">Employee Id</th>
				<th scope="col">Name</th>
				<th scope="col">Department Name</th>
				<th scope="col">Designation</th>
				<th scope="col">Salary</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator id="employee" value="salaryList">
				<tr>
					<th scope="row"><s:property value="#employee.empId" /></th>
					<td><s:property value="#employee.name" /></td>
					<td><s:property value="#employee.deptName" /></td>
					<td><s:property value="#employee.designation" /></td>
					<td><s:property value="#employee.salary" /></td>
					<td><s:url action="paymentToTable" var="urlTagForPayment"
							escapeAmp="false">
							<s:param name="empid">
								<s:property value="#employee.empId" />
							</s:param>
							<s:param name="salary">
								<s:property value="#employee.salary" />
							</s:param>
						</s:url> <a href="<s:property value="#urlTagForPayment" />">Send
							Payment Notification</a></td>

				</tr>
			</s:iterator>
		</tbody>
	</table>
	
	
	<div align="center">
		<span style="font-size: 30px;">SALARY <span
			style="color: #cc0000;">HISTORY</span></span>
		<hr />
	</div>

	<table class="table table-striped"
		style="font-size: 15px; font-weight: 600;">
		<thead>
			<tr>
				<th scope="col">Employee Id</th>
				<th scope="col">Salary</th>
				<th scope="col">Payment Made On</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator id="salaryemployee" value="recdSalary">
				<tr>
					<th scope="row"><s:property value="#salaryemployee.empId" /></th>
					<td><s:property value="#salaryemployee.salary" /></td>
					<td><s:property value="#salaryemployee.receiveDate" /></td>

				</tr>
			</s:iterator>
		</tbody>
	</table>
	
	<div align="center">
		<s:form action="payment" method="post">
			<s:submit name="reset" value="Reset" theme="simple"
				cssClass="btn btn-info"></s:submit>
		</s:form>
	</div>

</body>
</html>