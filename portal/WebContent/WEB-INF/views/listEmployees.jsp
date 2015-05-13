<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Salary</th>
	</tr>
	<c:forEach var="emp" items="${employees }">
		<tr>
			<td>${emp.id }</td>
			<td>${emp.name }</td>
			<td>${emp.salary}</td>
	</c:forEach>

</table>
