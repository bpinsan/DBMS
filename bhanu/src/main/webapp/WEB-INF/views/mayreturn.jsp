<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Total amount:${order.total_price }<br>
Amount paid:${order.grand_total }<br>
Employee:${order.employee }<br>
<br><br>
<c:forEach items="${list }" var="item">
Product_ID:${item.product_id }<br>
Quantity:${item.quantity }<br><br>
For Returning Product:<br>
<form action="/bhanu/admin/returnitem">
	<input type="hidden" name="order_id" value="${order.order_id }">
	<input type="hidden" name="product_id" value="${item.product_id }">
	Quantity:<input type="number" name="quantity">
	Customer: <input type="text" name="customer">
	Deadline: <input type="date" name="deadline">
	<input type="submit" name="mayreturn"> 	
</form>
For Product fitting:<br>
<form action="/bhanu/admin/productfitting">
	<input type="hidden" name="order_id" value="${order.order_id }">
	<input type="hidden" name="product_id" value="${item.product_id }">
	Quantity:<input type="number" name="quantity"><br>
	Customer: <input type="text" name="customer"><br>
	Deadline: <input type="date" name="deadline"><br>
	Details: <input type="text" name="details"><br>
	<input type="submit" name="mayreturn"><br>
</form>
<br><br><br><br><br>
</c:forEach>
</body>
</html>