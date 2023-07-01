<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/form.css">

</head>
<body>
	<h1 style="text-align: center;">Status</h1>
	<c:if test="${stockSaveInfo ne null }">
		<h1 style="text-align: center;">${stockSaveInfo }</h1>
	</c:if>
	<c:if test="${adminUpdateInfo ne null }">
		<h1 style="text-align: center;">${adminUpdateInfo }</h1>
	</c:if>
	<c:if test="${customerUpdateInfo ne null }">
		<h1 style="text-align: center;">${customerUpdateInfo }</h1>
	</c:if>
</body>
</html>