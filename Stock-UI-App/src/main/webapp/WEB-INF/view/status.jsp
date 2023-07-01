<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../css/login.css">

<meta charset="ISO-8859-1">
<title>Status</title>
</head>
<body>
	<c:if test="${message ne null }">
		<h1 style="text-align: center;">${message }</h1>
	</c:if>
	<h1 style="text-align: center;">
		<a href="./">|HOME PAGE|</a>
	</h1>

</body>
</html>