<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<s:actionerror />
<s:actionmessage />
<s:fielderror cssClass="color:red;" />
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/login.css">
<title>Login</title>
</head>

<body>

	<div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>
			HR<span>Management</span>
		</div>
	</div>
	<br>

	<div class="login">
		<s:form method="post" action="redirectToLoginPage">
			<s:textfield placeholder="Username" name="enteredUser" />
			<br>
			<s:password placeholder="Password" name="enteredPassword" />
			<br>
			<s:submit value="Admin Login" name="loginButton"></s:submit>
			<s:submit value="Employee Login" name="loginButton"></s:submit>
		</s:form>
	</div>
</body>
</html>