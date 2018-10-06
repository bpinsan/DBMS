<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<form:form method="post" modelAttribute="seller" action="">

		
		
		Name
		<form:input path="Name" type="text" /> <!-- bind to user.name-->
		<form:errors path="Name" /><br>
		
		
		
		
		
		Email:
		<form:input path="Email" type="text" /> <!-- bind to user.name-->
		<form:errors path="Email" /><br>
		
		
		
		Contact:
		<form:input path="Contact" type="text" /> <!-- bind to user.name-->
		<form:errors path="Contact" /><br>
		
		
		
		Address:
		<form:input path="Address" type="text" /> <!-- bind to user.name-->
		<form:errors path="Address" /><br>
		
		
		
			
			<input type="submit" value="Submit" />
		
		
		${error}
		
		</form:form>