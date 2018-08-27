<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="%{#session.id=='admin'}">
	<s:include value="headerForHR.jsp" />
</s:if>
<s:else>
	<s:include value="headerForEmployees.jsp" />
</s:else>


<html>

<head>
<s:actionerror />
<s:fielderror />
<s:actionmessage />

<title><%=request.getAttribute("Department")%></title>
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
		<span style="font-size: 30px;">Employee Details For <span
			style="color: #cc0000;"><%=request.getAttribute("Department")%></span>
			Department
		</span>
		<hr />
	</div>
	<table class="table table-striped" style="font-size: 15px; font-weight: 900;">
		<thead>
			<tr>
				<th scope="col">Employee Id</th>
				<th scope="col">Name</th>
				<th scope="col">Mail Id</th>
				<th scope="col">Department Name</th>
				<th scope="col">Designation</th>
				<s:if test="%{#session.id=='admin'}">
					<th scope="col">Update</th>
					<th scope="col">Delete</th>
				</s:if>
			</tr>
		</thead>
		<tbody>
			<s:iterator id="employee" value="employeeList">
				<tr>
					<th scope="row"><s:property value="#employee.empId" /></th>
					<td><s:property value="#employee.name" /></td>
					<td><s:property value="#employee.mailId" /></td>
					<td><s:property value="#employee.deptName" /></td>
					<td><s:property value="#employee.designation" /></td>
					<td><s:if test="%{#session.id=='admin'}">
							<s:url action="searchEmployee" var="urlTagForUpdate"
								escapeAmp="false">
								<s:param name="empid">
									<s:property value="#employee.empId" />
								</s:param>
								<s:param name="action">update</s:param>
							</s:url>
							<a href="<s:property value="#urlTagForUpdate" />">Update</a>
						</s:if></td>
					<td><s:if test="%{#session.id=='admin'}">
							<s:url action="manageEmployee" var="urlTagForDelete"
								escapeAmp="false">
								<s:param name="empid">
									<s:property value="#employee.empId" />
								</s:param>
								<s:param name="action">delete</s:param>
							</s:url>
							<a href="<s:property value="#urlTagForDelete" />"><span
								style="color: #e62e00;">Delete</span></a>
						</s:if></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>

</body>
<s:include value="footer.jsp"></s:include>
</html>