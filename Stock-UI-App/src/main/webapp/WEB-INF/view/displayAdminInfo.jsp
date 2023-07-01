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
	<c:if test="${adminInfo ne null }">
		<table class="bookTable">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>GENDER</th>
				<th>MAIL</th>
				<th>ACTION</th>
			</tr>
			<tr>
				<td>${adminInfo.aid }</td>
				<td>${adminInfo.aname }</td>
				<td>${adminInfo.gender }</td>
				<td>${adminInfo.amail }</td>
				<td><a
					href="adminUpdateForm?adminMail=${adminInfo.amail}"><input
						type="button" name="" value="edit" class="editButton"></a></td>
			</tr>
		</table>
	</c:if>
	
</body>
</html>