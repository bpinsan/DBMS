<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<form:form method="post" modelAttribute="seller" action="">
		
		
		
		Name:
		<form:input path="Name" type="int" value="${offer.Name }" /> <!-- bind to user.name-->
		<form:errors path="Name" /><br>
		
		
		
		Address:
		<form:input path="Address" type="int" value="${offer.status }" /> <!-- bind to user.name-->
		<form:errors path="Address" /><br>
		
		Contact:
		<form:input path="Contact" type="int" value="${offer.status }" /> <!-- bind to user.name-->
		<form:errors path="Contact" /><br>
		
		Email:
		<form:input path="Email" type="int" value="${offer.status }" /> <!-- bind to user.name-->
		<form:errors path="Email" /><br>
			
			<input type="submit" value="Submit" />
		
		
		${error}
		
		
	</form:form>