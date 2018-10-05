<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<form:form method="post" modelAttribute="product" action="">
		
		
		
		Category: 
		<form:input path="Category" type="text" /> <!-- bind to user.name-->
		<form:errors path="Category" /><br>
		
		
		
		
		
		Brand:
		<form:input path="Brand" type="text" /> <!-- bind to user.name-->
		<form:errors path="Brand" /><br>
		
		
		
		Correspondence:
		<form:input path="Correspondence" type="text" /> <!-- bind to user.name-->
		<form:errors path="Correspondence" /><br>
		
		
		
		Type:
		<form:input path="Type" type="text" /> <!-- bind to user.name-->
		<form:errors path="Type" /><br>
		
		
		
		Size:
		<form:input path="Size" type="text" /> <!-- bind to user.name-->
		<form:errors path="Size" /><br>
		
		
		
		MRP:
		<form:input path="MRP" type="text" /> <!-- bind to user.name-->
		<form:errors path="MRP" /><br>
		
		
		
		Discount:
		<form:input path="Discount" type="text" /> <!-- bind to user.name-->
		<form:errors path="Discount" /><br>
		
		
		
		Quantity:
		<form:input path="Quantity" type="int" /> <!-- bind to user.name-->
		<form:errors path="Quantity" /><br>
		
		
			
			<input type="submit" value="Submit" /><br>
		
		
		${error}
		
		
	</form:form>