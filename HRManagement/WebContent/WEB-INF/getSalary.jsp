<%@page import="java.util.Date"%>
<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:include value="headerForEmployees.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salary Details</title>
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
		<span style="font-size: 30px;">MY <span
			style="color: #cc0000;">SALARY </span> DETAILS</span>
		<hr />
	</div>


	<table class="table table-striped"
		style="font-size: 15px; font-weight: 600;">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Received On</th>
				<th scope="col">Amount Received</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator id="employee" value="empSalary">
				<tr>
					<th scope="row"><s:property value="#employee.empId" /></th>
					<td><s:property value="#employee.receiveDate" /></td>
					<td><s:property value="#employee.salary" /></td>

				</tr>
			</s:iterator>
		</tbody>
	</table>

	<div align="center">
		<s:form action="salary" method="post">
			<s:submit name="reset" value="Refresh" theme="simple"
				cssClass="btn btn-info"></s:submit>
		</s:form>
	</div>

</body>
</html>