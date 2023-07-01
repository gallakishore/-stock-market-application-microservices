<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info Page</title>
<link rel="stylesheet" type="text/css" href="../../css/displayInfo.css">

</head>
<body>
	<h1 style="font-size: 55px">Your Details</h1>
	<br>
	<br>
	<c:if test="${customerInfo ne null }">
		<table class="bookTable">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>GENDER</th>
				<th>MAIL</th>
				<th>ACTION</th>
			</tr>
			<tr>
				<td>${customerInfo.cid }</td>
				<td>${customerInfo.cname }</td>
				<td>${customerInfo.gender }</td>
				<td>${customerInfo.cmail }</td>
				<td><a
					href="customerUpdateForm?customerMail=${customerInfo.cmail}"><input
						type="button" name="" value="edit" class="editButton"></a></td>
			</tr>
		</table>
	</c:if>
	
</body>
</html>