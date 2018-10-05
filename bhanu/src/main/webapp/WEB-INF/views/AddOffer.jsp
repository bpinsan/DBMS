<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<form:form method="post" modelAttribute="offer" action="">

		
		
		Name:
		<form:input path="Name" type="text" /> <!-- bind to user.name-->
		<form:errors path="Name" /><br>
		
		
		
		Discount:
		<form:input path="Discount" type="text" /> <!-- bind to user.name-->
		<form:errors path="Discount" /><br>
		
			
		
		Status:
		<form:input path="Status" type="int" /> <!-- bind to user.name-->
		<form:errors path="Status" /><br>
		
		
		
			
			<input type="submit" value="Submit" />
		
		
		${error}
		
		</form:form>