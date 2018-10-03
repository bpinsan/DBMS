<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<form:form method="post" modelAttribute="offer" action="">
<table>
		
		<tr>
		<td>Name</td>
		<td><form:input path="Name" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Name" /></td>
		</tr>
		
		<tr>
		<td>Discount</td>
		<td><form:input path="Discount" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Discount" /></td>
		</tr>
			
		<tr>
		<td>Status</td>
		<td><form:input path="Status" type="int" /> </td><!-- bind to user.name-->
		<td><form:errors path="Status" /></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
		</tr>
		<tr>
		<td>${error}</td>
		</tr>
		</table></form:form>