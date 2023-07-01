<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Login Page</title>
<link rel="stylesheet" type="text/css" href="../../css/login.css">

</head>
<body>
	<br>
	<br>
	<h1>WELCOME TO STOCK PRICE INFORMATION APPLICATION</h1>
	<h1>Customer login</h1>
	<form action="customerLoginPortal" method="post">
		<table class="table">
			<tr>
				<th>User Mail</th>
				<td><input type="text" name="customerMail" id="" required="required"
					class="input" placeholder="Enter mail" /></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="customerPassword" id=""
					required="required" class="input" placeholder="Enter password" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="sign in" class="loginButton" />
					<a href="customerRegister"> <input type="button"
						value="sign up" class="signUpButton" />
				</a></td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<h1 style="color: red">
		<c:if test="${errorMessage ne null }">
      ${errorMessage }
</c:if>
	</h1>

</body>
</html>