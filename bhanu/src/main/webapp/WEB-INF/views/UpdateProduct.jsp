<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<form:form method="post" modelAttribute="product" action="">
		<table>
		
		<tr>
		<td>MRP</td>
		<td><form:input path="MRP" type="int" value="${product.MRP }" /> </td><!-- bind to user.name-->
		<td><form:errors path="MRP" /></td>
		</tr>
		
		<tr>
		<td>Discount</td>
		<td><form:input path="Discount" type="int" value="${product.discount }" /> </td><!-- bind to user.name-->
		<td><form:errors path="Discount" /></td>
		</tr>
		
		<tr>
		<td>Quantity</td>
		<td><form:input path="Quantity" type="" value="${product.quantity }" /> </td><!-- bind to user.name-->
		<td><form:errors path="Quantity" /></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
		</tr>
		<tr>
		<td>${error}</td>
		</tr>
		</table>
	</form:form>