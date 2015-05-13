<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Login</h1>
	<p><%= request.getAttribute("error") %>
	<form id="login" method="post" action="login.do">
		<table>
			<tr>
				<td>User Name</td>
				<td><input type="text" id="userName" name="userName"></td>
			</tr>
			<tr>
				<td>Passwor</td>
				<td><input type="password" id="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>