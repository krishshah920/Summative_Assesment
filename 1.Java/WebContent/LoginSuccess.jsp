<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="employeemanagement.dao.*"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

	<jsp:useBean id="login"
		class="employeemanagement.web.EmployeeLogin" />

	<jsp:setProperty property="*" name="login" />

	<%
   EmployeeDaoLogin employeedaologin = new EmployeeDaoLogin();
   boolean status = employeedaologin.validate(login);
   if (status) {
           out.print("<h1>You have logined successfully</h1>");
   }
 %>
</body>

</html>