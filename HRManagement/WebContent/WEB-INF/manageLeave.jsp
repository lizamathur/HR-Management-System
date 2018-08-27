<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:include value="headerForHR.jsp" />


<html>

<head>
<s:actionerror />
<s:fielderror />
<s:actionmessage />

<title>Manage Leave Applications</title>
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
		<span style="font-size: 30px;">Pending List Of<span
			style="color: #cc0000;">&nbsp;Leave</span>&nbsp;Application
		</span>
		<hr />
	</div>
	<table class="table table-striped"
		style="font-size: 15px; font-weight: 900;">
		<thead>
			<tr>
				<th scope="col">Employee Id</th>
				<th scope="col">Leave Type</th>
				<th scope="col">From</th>
				<th scope="col">To</th>
				<th scope="col">Number of Days</th>
				<th scope="col">Action</th>
				<th scope="col">Approve</th>
				<th scope="col">Reject</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator id="leave" value="leaveApplication">
				<s:if test="%{#leave.action=='Pending'}">
					<tr>
						<th scope="row"><s:property value="#leave.empId" /></th>
						<td><s:property value="#leave.leaveType" /></td>
						<td><s:property value="#leave.fromDate" /></td>
						<td><s:property value="#leave.toDate" /></td>
						<td><s:property value="#leave.days" /></td>
						<td><s:property value="#leave.action" /></td>

						<td><s:url action="approveLeave" var="urlTagForApproval"
								escapeAmp="false">
								<s:param name="empid">
									<s:property value="#leave.empId" />
								</s:param>
								<s:param name="from">
									<s:property value="#leave.fromDate" />
								</s:param>
								<s:param name="to">
									<s:property value="#leave.toDate" />
								</s:param>
								<s:param name="action">approve</s:param>
							</s:url> <a href="<s:property value="urlTagForApproval" />"><span
								style="color: #00cc00;">Approve</span></a></td>

						<td><s:url action="rejectLeave" var="urlTagForRejection"
								escapeAmp="false">
								<s:param name="empid">
									<s:property value="#leave.empId" />
								</s:param>
								<s:param name="from">
									<s:property value="#leave.fromDate" />
								</s:param>
								<s:param name="to">
									<s:property value="#leave.toDate" />
								</s:param>
								<s:param name="action">reject</s:param>
							</s:url> <a href="<s:property value="urlTagForRejection" />"><span
								style="color: #e62e00;">Reject</span></a></td>
					</tr>
				</s:if>
			</s:iterator>
		</tbody>
	</table>
	
	
	<div align="center">
		<span style="font-size: 30px;">History Of <span
			style="color: #cc0000;">Leave Applications</span>
		</span>
		<hr />
	</div>
	<table class="table table-striped"
		style="font-size: 15px; font-weight: 900;">
		<thead>
			<tr>
				<th scope="col">Employee Id</th>
				<th scope="col">Leave Type</th>
				<th scope="col">From</th>
				<th scope="col">To</th>
				<th scope="col">Number of Days</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator id="leave" value="leaveApplication">
				<s:if test="%{#leave.action!='Pending'}">
					<tr>
						<th scope="row"><s:property value="#leave.empId" /></th>
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
				</s:if>
			</s:iterator>
		</tbody>
	</table>
	
	
	
	

</body>
<s:include value="footer.jsp"></s:include>
</html>