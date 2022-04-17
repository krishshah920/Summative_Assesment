<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
</head>
<body>
	<div align="center">
		<c:if test="${user != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${user == null}">
			<form action="insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${user != null}">
            			Edit User
            		</c:if>
					<c:if test="${user == null}">
            			Add New User
            		</c:if>
				</h2>
			</caption>
			<c:if test="${user != null}">
				<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
			</c:if>
			<tr>
				<th>First Name:</th>
				<td><input type="text" name="first_name" size="45"
					value="<c:out value='${user.first_name}' />" />
				</td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td><input type="text" name="last_name" size="45"
					value="<c:out value='${user.last_name}' />" /></td>
			</tr>
			<tr>
				<th>Address:</th>
				<td><input type="text" name="address" size="45"
					value="<c:out value='${user.address}' />" /></td>
			</tr>
			<tr>
				<th>Contact:</th>
				<td><input type="text" name="contact" size="15"
					value="<c:out value='${user.contact}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
