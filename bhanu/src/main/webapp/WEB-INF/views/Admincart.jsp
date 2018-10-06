<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${empty list }">
<h3>You don't have any item in your cart...</h3>
</c:if>

<c:if test="${not empty list }">

	Total Amount is:${price }<br>
	Net price:${net_price }<br>

<form action="order/${net_price }">

	<input type="hidden" value="${offer_id }" name="offer_id"><br>
	User name: <input type="text" name="username"><br><br>
	Details:<input type="text"  name="details"><br><br>
	Pin code:<input type="number" name="pincode"><br><br>
	<input type="submit" value="Place order"><br><br>

</form>



<form action="applyoffer">
	<select name="offer_id" required="required">
		<c:forEach items="${offers }" var="offer">
		<option value="${offer.offer_id }">${offer.name }(${offer.discount } %off)</option>
		</c:forEach>
	</select>
	<input type="submit" value="select offer">
</form>

</c:if>

<c:forEach items="${list }" var="item">
	
	Correspondence:${item.correspondence }<br>
	Category:${item.category }<br>
	Brand:${item.brand }<br>
	Type:${item.type }<br>
	Size:${item.size }<br>
	Price:${item.price }*(${item.quantity })<br>
	Quantity:${item.quantity }<br>
	Product_ID:${item.product_id }<br>
	
	<a href="/bhanu/admin/removefromcart/${item.product_id }">Remove from cart</a><br><br>

</c:forEach>
</body>
</html>