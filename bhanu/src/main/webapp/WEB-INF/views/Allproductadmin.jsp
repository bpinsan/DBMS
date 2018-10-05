<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty list }">
<h4>No Products Available...</h4>
</c:if>
<c:forEach items="${list }" var="Product">
<div style="float:left;width:30%;margin-left:5%;background-color:red;margin-top:3%">
<table>
<tr><td>Product_Id:</td>
<td>${Product.product_id }</td></tr>
<tr><td>Correspondence:</td>
<td>${Product.correspondence }</td></tr>
<tr><td>Category:</td>
<td>${Product.category }</td></tr>
<tr><td>Brand:</td>
<td>${Product.brand }</td></tr>
<tr><td>Type:</td>
<td>${Product.type }</td></tr>
<tr><td>Size:</td>
<td>${Product.size }</td></tr>
<tr><td>Price:</td>
<td>${Product.price }</td></tr>
<tr><td>Quantity:</td>
<td>${Product.quantity }</td></tr>
<tr><td><form action="addtocart/${Product.product_id}">
<input type="number" name="quantity" max="${Product.quantity }" min="1" required>
<input value="Add to cart" type="submit" />
</form></td></tr>
<tr><td>Feedbacks:</td>
<td><a href="/bhanu/admin/feedbacks/${Product.product_id}">show</a></td></tr>
</table></div>
</c:forEach>
</body>
</html>