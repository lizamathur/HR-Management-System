<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<s:include value="headerForEmployees.jsp"></s:include>
<html>

<head>
<sx:head />
<s:fielderror />
<s:actionerror />
<s:actionmessage />
<title>Leave Application</title>
<style type="text/css">
body {
	background-image:
		url(https://png.pngtree.com/thumb_back/fw800/back_pic/04/48/50/00585a3568a0a7d.jpg);
	background-size: cover;
	font-weight: bolder;
}

form {
	margin-left: 30px;
}

#table1 {
	border-collapse: separate;
	border-spacing: 5em 1em;
}
</style>
</head>


<body>
	<div align="center">
		<h1>
			<b>LEAVE APPLICATION</b>
		</h1>
		<hr/>
	</div>
	<div align="center">
		<s:form action="leaveapplication" theme="xhtml" method="post"
			enctype="multipart/form-data">

			<s:hidden name="source" value="add"></s:hidden>
			<table id="table1">

				<tr>
					<td>Employee ID</td>

					<td><s:property value="#session.id" /> <s:hidden
							name="leaveId" value="%{#session.id}"></s:hidden></td>

				</tr>
				<tr>
					<td>Leave</td>

					<td><s:select list="{'PL','CL'}" name="leaveType"
							theme="simple"></s:select></td>
				</tr>
				<tr>
					<td>From Date</td>
					<td><sx:datetimepicker name="fromDate"
							displayFormat="dd-MMM-yyyy" value="%{'today'}" /></td>
				</tr>

				<tr>

					<td>To Date</td>
					<td><sx:datetimepicker name="toDate"
							displayFormat="dd-MMM-yyyy" value="%{'today'}" /></td>

				</tr>

				<tr>
					<td></td>
					<td><s:submit name="inputButton" value="Request"
							theme="simple" cssClass="btn btn-info"></s:submit></td>

				</tr>

			</table>
		</s:form>
	</div>
</body>
<s:include value="footer.jsp"></s:include>

</html>