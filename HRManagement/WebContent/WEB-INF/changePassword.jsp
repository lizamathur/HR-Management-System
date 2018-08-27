<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="%{#session.id=='admin'}">
	<s:include value="headerForHR.jsp" />
</s:if>
<s:else>
	<s:include value="headerForEmployees.jsp" />
</s:else>
<html>
<head>
<s:fielderror />
<s:actionerror />
<s:actionmessage />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<style type="text/css">
table {
	border-collapse: separate;
	border-spacing: 3em 1em;
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

	<div align="center">
		<span style="font-size: 30px;">Change Password</span>
		<hr />
	</div>

	<div align="center">

		<s:form action="changePassword" method="post">

			<table>

				<tr>
					<td>User Id</td>
					<td><s:property value="%{#parameters.requestedfor[0]}" /> <s:hidden
							value="%{#parameters.requestedfor[0]}" name="requestedfor"></s:hidden>
					</td>

				</tr>

				<tr>
					<td>Old Password</td>
					<td><s:password name="oldPassword" theme="simple" /></td>

				</tr>

				<tr>
					<td>New Password</td>
					<td><s:password name="newPassword" theme="simple" /></td>

				</tr>
				<tr>

					<td><s:submit value="Change Password" cssClass="btn btn-info"></s:submit>
					</td>

				</tr>

			</table>

		</s:form>

	</div>

</body>
<s:include value="footer.jsp"></s:include>
</html>