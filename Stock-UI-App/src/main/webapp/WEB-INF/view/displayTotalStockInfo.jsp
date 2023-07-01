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
	<h1 style="font-size: 55px">Stock Details</h1>
	<h2 style="text-align: center; color: red;">Total Amount for
		${quantity} shares of ${info.companyName } is ${info.totalAmount }
		rupees</h2>

	<br>
	<table class="bookTable">
		<tr>
			<th>Id</th>
			<th>COMPANY NAME</th>
			<th>COMPANY CEO</th>
			<th>COMPANY NETWORTH</th>
			<th>STOCK PRICE</th>
			<th>Total Amount</th>
		</tr>
		<tr>
			<td>${info.stockId }</td>
			<td>${info.companyName }</td>
			<td>${info.chairMan }</td>
			<td>${info.companyNetWorth }crore</td>
			<td>${info.stockPrice }rupees</td>
			<td>${info.totalAmount }rupees</td>
		</tr>
	</table>
</body>
</html>