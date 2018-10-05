<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<form:form method="post" modelAttribute="employee" action="">

		
		
		Name:
		<form:input path="Name" type="text" /> <!-- bind to user.name-->
		<form:errors path="Name" /><br>
		
		
		
		
		
		Salary:
		<form:input path="Salary" type="text" /> <!-- bind to user.name-->
		<form:errors path="Salary" /><br>
		
		
		
		Area:
		<form:input path="Area" type="text" /> <!-- bind to user.name-->
		<form:errors path="Area" /><br>
		
		
		
		Type:
		<form:input path="Type" type="text" /> <!-- bind to user.name-->
		<form:errors path="Type" /><br>
		
		
		
		Details:
		<form:input path="Details" type="text" /> <!-- bind to user.name-->
		<form:errors path="Details" /><br>
		
		
		
		Pin code:
		<form:input path="Pincode" type="text" /> <!-- bind to user.name-->
		<form:errors path="Pincode" /><br>
		
		
		
		Joining_data:
		<form:input path="Joining_date" type="text" /> <!-- bind to user.name-->
		<form:errors path="Joining_date" /><br>
		
		
		
		Email:
		<form:input path="Email" type="text" /> <!-- bind to user.name-->
		<form:errors path="Email" /><br>
		
		
		
		
		Contact:
		<form:input path="Contact" type="text" /> <!-- bind to user.name-->
		<form:errors path="Contact" /><br>
		
		
		
		
			
			<input type="submit" value="Submit" />
		
		
		${error}
		
		</form:form>