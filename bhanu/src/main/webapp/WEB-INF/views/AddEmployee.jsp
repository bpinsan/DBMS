<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<form:form method="post" modelAttribute="employee" action="">
<table>
		
		<tr>
		<td>Name</td>
		<td><form:input path="Name" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Name" /></td>
		</tr>
		
		
		
		<tr>
		<td>Salary</td>
		<td><form:input path="Salary" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Salary" /></td>
		</tr>
		
		<tr>
		<td>Area</td>
		<td><form:input path="Area" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Area" /></td>
		</tr>
		
		<tr>
		<td>Type</td>
		<td><form:input path="Type" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Type" /></td>
		</tr>
		
		<tr>
		<td>Details</td>
		<td><form:input path="Details" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Details" /></td>
		</tr>
		
		<tr>
		<td>Pincode</td>
		<td><form:input path="Pincode" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Pincode" /></td>
		</tr>
		
		<tr>
		<td>Joining_data</td>
		<td><form:input path="Joining_date" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Joining_date" /></td>
		</tr>
		
		<tr>
		<td>Email</td>
		<td><form:input path="Email" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Email" /></td>
		</tr>
		<tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
		</tr>
		<tr>
		<td>${error}</td>
		</tr>
		</table></form:form>