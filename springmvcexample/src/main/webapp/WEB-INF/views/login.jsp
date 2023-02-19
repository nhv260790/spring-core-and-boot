<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
	<form:form method="post" modelAttribute="employee">
		<form:input path="firstName" name="firstName" id="firstName"/>
		<form:input path="password" name="password" id="password"/>
		<form:button name="login" id="login">Login</form:button>
	</form:form>
	
</body>
</html>