<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<form:form method="post" modelAttribute="product" action="">
		<table>
		
		<tr>
		<td>Category</td>
		<td><form:input path="Category" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Category" /></td>
		</tr>
		
		
		
		<tr>
		<td>Brand</td>
		<td><form:input path="Brand" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Brand" /></td>
		</tr>
		
		<tr>
		<td>Correspondence</td>
		<td><form:input path="Correspondence" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Correspondence" /></td>
		</tr>
		
		<tr>
		<td>Type</td>
		<td><form:input path="Type" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Type" /></td>
		</tr>
		
		<tr>
		<td>Size</td>
		<td><form:input path="Size" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Size" /></td>
		</tr>
		
		<tr>
		<td>MRP</td>
		<td><form:input path="MRP" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="MRP" /></td>
		</tr>
		
		<tr>
		<td>Discount</td>
		<td><form:input path="Discount" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="Discount" /></td>
		</tr>
		
		<tr>
		<td>Quantity</td>
		<td><form:input path="Quantity" type="int" /> </td><!-- bind to user.name-->
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