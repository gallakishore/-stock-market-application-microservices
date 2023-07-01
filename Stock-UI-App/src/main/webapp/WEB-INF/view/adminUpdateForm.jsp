<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Info From</title>
<link rel="stylesheet" type="text/css" href="../../css/updateForm.css">

</head>
<body>
	<h1>Update Your Information</h1>
	<c:if test="${errorMessage ne null }">
		<h2 style="text-align: center; color: red;">${errorMessage}</h2>
	</c:if>
	<form action="updateAdminDataInfo" method="post">
		<table class="table">
			<tr>
				<th>ID</th>
				<td><input type="text" name="aid" id=""
					required="required" class="input"  value="${adminInfo.aid }" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>FullName</th>
				<td><input type="text" name="adimName" id=""
					required="required" class="input"  value="${adminInfo.aname }" /></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="email" name="adimEmail" id=""
					required="required" class="input"  value="${adminInfo.amail }" readonly="readonly"/></td>
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
				<th></th>
				<td><input type="submit" value="update" class="submitButton"></td>
			</tr>
		</table>
	</form>


</body>
</html>