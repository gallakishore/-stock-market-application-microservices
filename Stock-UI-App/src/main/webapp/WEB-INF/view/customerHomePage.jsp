<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../../css/adminHome.css">

<title>Student Home</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	%>

	<div class="divTop">
		<h1>WELCOME TO STOCK CUSTOMER PORTAL</h1>
		
	</div>
	<div class="nav">
		<nav class="navbar">
			<div class="content">
				<ul class="ulist">
				    <br>
				    <br>
				    <br>
					<li><a href="../../api/stock/customerSearch" target="body">SEARCH</a></li>
					<li><a href="../../api/stock/calculate" target="body">CALCULATE</a></li>
					<li><a href="../../api/register/customerDetails?customerMail=${customerMail }" target="body">ABOUT</a></li>
					<li><a href="../../api/register/" >LOGOUT</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="body">
		<br> <br>
		<iframe  width="950px" height="900px" name="body" frameborder="0"></iframe>
	</div>

</body>
</html>