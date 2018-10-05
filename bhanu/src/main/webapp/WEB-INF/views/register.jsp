<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<form:form method="post" modelAttribute="customer" action="register">
		
		User name:
		<form:input path="Username" type="text" /> <!-- bind to user.name-->
		<form:errors path="Username" /><br>
		
		
		Password:
		<form:input path="Password" type="password" /> <!-- bind to user.name-->
		<form:errors path="Password" /><br>
		
		Confirm password:
		
		<form:input path="mPassword" type="password" /> <!-- bind to user.name-->
		<form:errors path="mPassword" /><br>
		
		
		Name:
		
		<form:input path="Name" type="text" /> <!-- bind to user.name-->
		<form:errors path="Name" /><br>
		
		Email:
		
		<form:input path="Email" type="Email" /> <!-- bind to user.name-->
		<form:errors path="Email" /><br>
		
		Gender:
		
		<form:input path="Gender" type="text" /> <!-- bind to user.name-->
		<form:errors path="Gender" /><br>
		
		
		Contact:
		
		<form:input path="Contact" type="text" /> <!-- bind to user.name-->
		<form:errors path="Contact" /><br>
		
		Address:
		
		<form:input path="Details" type="text" /> <!-- bind to user.name-->
		<form:errors path="Details" /><br>
		
		Pin code:
		
		<form:input path="Pincode" type="int" /> <!-- bind to user.name-->
		<form:errors path="Pincode" /><br>
		
		
			
			<input type="submit" value="Submit" />
			
		${error}
		
	</form:form>