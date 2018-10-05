<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<form:form method="post" modelAttribute="customer" action="register">
		<table><tr><td>
		Username</td><td>
		<form:input path="Username" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Username" /></td></tr>
		
		<tr><td>
		Password</td><td>
		<form:input path="Password" type="password" /> </td><!-- bind to user.name-->
		<td><form:errors path="Password" /></td></tr>
		
		<tr><td>Confirm password</td>
		<td>
		<form:input path="mPassword" type="password" /> </td><!-- bind to user.name-->
		<td><form:errors path="mPassword" /></td></tr>
		
		
		<tr><td>Name</td>
		<td>
		<form:input path="Name" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Name" /></td></tr>
		
		<tr><td>Email</td>
		<td>
		<form:input path="Email" type="Email" /> </td><!-- bind to user.name-->
		<td><form:errors path="Email" /></td></tr>
		
		<tr><td>Gender</td>
		<td>
		<form:input path="Gender" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Gender" /></td></tr>
		<tr>
		
		<tr><td>Contact</td>
		<td>
		<form:input path="Contact" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Contact" /></td></tr>
		
		<tr><td>Address</td>
		<td>
		<form:input path="Details" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Details" /></td></tr>
		
		<tr><td>Pincode</td>
		<td>
		<form:input path="Pincode" type="int" /> </td><!-- bind to user.name-->
		<td><form:errors path="Pincode" /></td></tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>