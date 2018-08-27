<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:include value="headerForEmployees.jsp" />


<html>

<head>
<s:actionerror />
<s:fielderror />
<s:actionmessage />

<title>Leave Status</title>
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
		<span style="font-size: 30px;">Status Of <span
			style="color: #cc0000;">Leave Application</span>
		</span>
		<hr />
	</div>
	<table class="table table-striped"
		style="font-size: 15px; font-weight: 900;">
		<thead>
			<tr>
				<th scope="col">Leave Type</th>
				<th scope="col">From</th>
				<th scope="col">To</th>
				<th scope="col">Number of Days</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator id="leave" value="leaveApplication">
				<tr>
					<td><s:property value="#leave.leaveType" /></td>
					<td><s:property value="#leave.fromDate" /></td>
					<td><s:property value="#leave.toDate" /></td>
					<td><s:property value="#leave.days" /></td>
					<td>
						<s:if test="%{#leave.action=='Approved'}">
							<span style="color: #00cc00"><s:property value="#leave.action" /></span>
						</s:if>
						<s:if test="%{#leave.action=='Rejected'}">
							<span style="color: #e62e00"><s:property value="#leave.action" /></span>
						</s:if>
						<s:if test="%{#leave.action=='Pending'}">
							<s:property value="#leave.action" />
						</s:if>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>

</body>
<s:include value="footer.jsp"></s:include>
</html>