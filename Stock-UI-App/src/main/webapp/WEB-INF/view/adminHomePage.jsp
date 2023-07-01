<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h1>WELCOME TO STOCK ADMIN PORTAL</h1>
		
	</div>
	<div class="nav">
		<nav class="navbar">
			<div class="content">
				<ul class="ulist">
				    <br>
				    <br>
					<li><a href="../../api/stock/insert" target="body">INSERT</a></li>
					<li><a href="../../api/stock/search" target="body">SEARCH</a></li>
					<li><a href="../../api/register/adminDetails?adminMail=${adminMail }" target="body">ABOUT</a></li>
					<li><a href="../../api/register/">LOGOUT</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="body">
		<br> <br>
		<iframe width="950px" height="600px" name="body" frameborder="0"></iframe>
	</div>

</body>
</html>