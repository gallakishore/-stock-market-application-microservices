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
	<h1>Total Amount Calculator </h1>
	<c:if test="${errorMessage ne null }">
		<h2 style="text-align: center; color: red;">${errorMessage}</h2>
	</c:if>
	<form action="stockTotalPriceCalculate" method="post">
		<table class="tab">
			<tr>
				<th>Company Name</th>
				<td><input type="text" name="companyName" id="" required
					class="s1" /></td>
			</tr>
			<tr>
				<th>Quantity</th>
				<td><input type="number" name="quantity" id="" required
					class="s1" /></td>
			</tr>
			
			<tr>
				<th></th>
				<td><input type="submit" value="get" class="submitButton"></td>
			</tr>
		</table>
	</form>

</body>
</html>