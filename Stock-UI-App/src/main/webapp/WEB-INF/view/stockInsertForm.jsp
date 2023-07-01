<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Info From</title>
<link rel="stylesheet" type="text/css" href="../../css/form.css">

</head>
<body>
	<h1>Add Stock Information</h1>
	<c:if test="${errorMessage ne null }">
		<h2 style="text-align: center; color: red;">${errorMessage}</h2>
	</c:if>
	<form action="saveStockInfo" method="post">
		<table class="tab">
			<tr>
				<th>Company Name</th>
				<td><input type="text" name="companyName" id="" required
					class="s1" /></td>
			</tr>
			<tr>
				<th>CEO Company</th>
				<td><input type="text" name="chairMan" id="" required
					class="s1" /></td>
			</tr>
			<tr>
				<th>Stock Price (rupees)</th>
				<td><input type="text" name="stockPrice" id="pass" required
					class="s1" /></td>
			</tr>
			<tr>
				<th>Company Net Worth (crore)</th>
				<td><input type="text" name="companyNetWorth" id="" required
					class="s1" /></td>
			</tr>

			<tr>
				<th></th>
				<td><input type="submit" value="save" class="submitButton"></td>
			</tr>
		</table>
	</form>

</body>
</html>