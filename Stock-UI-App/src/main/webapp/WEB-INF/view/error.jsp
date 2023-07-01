<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../css/form.css">

<meta charset="ISO-8859-1">
<title>Status</title>
</head>
<body>

	<h1 style="text-align: center;">Status</h1>
	<c:if test="${errorMessage ne null }">
		<h1 style="text-align: center; color: red;">${errorMessage }</h1>
	</c:if>

</body>
</html>