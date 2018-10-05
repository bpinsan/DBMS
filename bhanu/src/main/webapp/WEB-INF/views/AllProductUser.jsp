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

Product_Id:${Product.product_id }<br>
Correspondence:${Product.correspondence }<br>
Category:${Product.category }<br>
Brand:${Product.brand }<br>
Type:${Product.type }<br>
Size:${Product.size }<br>
Price:${Product.price }<br>
Quantity:${Product.quantity }<br><br>


<form action="addtocart/${Product.product_id}">
<input type="number" name="quantity" max="${Product.quantity }" min="1" required>
<input value="Add to cart" type="submit" />
</form><br>


Feedbacks:<a href="/bhanu/user/feedbacks/${Product.product_id}">show</a><br>
Give Feedbacks:<a href="/bhanu/user/addfeedback/${Product.product_id}">Add</a><br><br>

</c:forEach>
</body>
</html>