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
	<form action="updateCustomerDataInfo" method="post">
		<table class="table">
			<tr>
				<th>ID</th>
				<td><input type="text" name="cid" id=""
					required="required" class="input"  value="${customerInfo.cid }" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>FullName</th>
				<td><input type="text" name="customerName" id=""
					required="required" class="input"  value="${customerInfo.cname }" /></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="email" name="customerEmail" id=""
					required="required" class="input"  value="${customerInfo.cmail }" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>Gender</th>
				<td><input type="radio" name="customerGender" value="male"
					id="male"> <label for="male">Male</label> <input
					type="radio" name="customerGender" value="female" id="female">
					<label for="female">Female</label><br>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="customerPassword" id="pass"
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