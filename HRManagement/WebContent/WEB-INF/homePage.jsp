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
<s:actionmessage />
<s:fielderror />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
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
	<div align="right"
		style="margin-right: 7px; margin-top: -8px; font-size: 20px;">
		<b> Welcome,&nbsp;&nbsp;<span style="color: #b30000;"><s:property
					value="#session.id" /></span></b>
	</div>

	<div class="container-fluid" style="margin-top: 10px;">

		<div id="myCarousel" class="carousel slide" data-ride="carousel"
			style="border: solid black 8px;">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img
						src="http://charityworld.com/wp-content/uploads/2016/02/logo.jpg"
						alt="globsyn" style="width: 1390px; height: 350px">
				</div>

				<div class="item">
					<img
						src="http://www.studyhelpdesk.com/storage/school_gallery/2/globsyn-business-school-gbs-kolkata-7.jpg"
						alt="globsyn" style="width: 1390px; height: 350px;">
				</div>

				<div class="item">
					<img
						src="https://adekvat.no/wp-content/uploads/2017/01/HR-Toppbilde.jpg  "
						alt="globsyn" style="width: 1390px; height: 350px;">
				</div>
				<div class="item">
					<img
						src="https://thumbs.dreamstime.com/b/human-resources-hr-management-recruitment-employment-headhunting-concept-human-resources-hr-management-recruitment-employment-112471493.jpg  "
						alt="globsyn" style="width: 1390px; height: 350px;">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>

</body>
<s:include value="footer.jsp"></s:include>
</html>