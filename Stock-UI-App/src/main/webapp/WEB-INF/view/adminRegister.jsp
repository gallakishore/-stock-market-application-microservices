<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Register Form</title>
<link rel="stylesheet" type="text/css" href="../../css/formRegister.css">

</head>
<body>
	<br>
	<br>
	<h1>WELCOME TO STOCK PRICE INFORMATION APPLICATION</h1>
	<h1>Admin Registration</h1>
	<form action="adminDataRegister" method="post">
		<table class="table">
			<tr>
				<th>FullName</th>
				<td><input type="text" name="adimName" id=""
					required="required" class="input" /></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="email" name="adimEmail" id=""
					required="required" class="input" /></td>
			</tr>
			<tr>
				<th>Gender</th>
				<td><input type="radio" name="adminGender" value="male"
					id="male"> <label for="male">Male</label> <input
					type="radio" name="adminGender" value="female" id="female">
					<label for="female">Female</label><br>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="adimPassword" id="pass"
					required="required" class="input" /></td>
			</tr>
			<tr>
				<th>Confirm password</th>
				<td><input type="text" name="adimConfirmPassword" id=""
					required="required" class="input" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="register" class="submitButton"></td>
			</tr>
		</table>
	</form>

	<c:if test="${message ne null }">
		<h1 style="color: red">"${message}"</h1>
	</c:if>
</body>
</html>