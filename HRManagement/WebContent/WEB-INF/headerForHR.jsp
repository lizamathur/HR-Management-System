<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    
		<!-- <title>Home</title> -->
	
	</head>
	
	<body>
		<nav class="navbar navbar-inverse">
	        <div class="container-fluid">
	            <div class="navbar-header">
	                <a class="navbar-brand" href="toHomePage">HR Management</a>
	            </div>
	            <ul class="nav navbar-nav">
	                <li class="dropdown"><s:a class="dropdown-toggle" data-toggle="dropdown" href="#">Employees <span class="caret"></span></s:a>
	                    <ul class="dropdown-menu">
	                        <li><s:a href="add">Add</s:a></li>
	                        <li><s:a href="manage">Manage</s:a></li>
	                    </ul>
	                </li>
	                <li class="dropdown"><s:a class="dropdown-toggle" data-toggle="dropdown" href="#">Departments<span class="caret"></span></s:a>
	                
	                    <ul class="dropdown-menu">
	                    
	                        <li><s:a href="toDepartment?from=MARKETING">Marketing</s:a></li>
	                        <li><s:a href="toDepartment?from=PRODUCTION">Production</s:a></li>
	                        <li><s:a href="toDepartment?from=ACCOUNTS">Accounts</s:a></li>
	                        <li><s:a href="toDepartment?from=SALES">Sales</s:a></li>
	                        <li><s:a href="toDepartment?from=QUALITY ASSURANCE">Quality Assurance</s:a></li>
	                    </ul>
	                
	                </li>
	                <li><s:a href="manageleave">Manage Leave Applications</s:a></li>
	                <li><s:a href="payment">Pay Salary</s:a></li>
	            </ul>
	            <ul class="nav navbar-nav navbar-right">
	                <li><s:a href="logout"><span class="glyphicon glyphicon-log-in"></span> Logout</s:a></li>
	            </ul>
	        </div>
	    </nav>
	</body>
	
</html>