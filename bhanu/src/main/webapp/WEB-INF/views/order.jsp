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
Order ID:${order.order_id}<br>
Address:${order.details},${order.pincode}<br>
Total amount:${order.total_price }<br>
Amount paid:${order.grand_total }<br>
<br>
<c:forEach items="${list }" var="item">
Product_ID:<a href="../product/${item.product_id }">${item.product_id }</a><br>
Quantity:${item.quantity }<br><br>
</c:forEach>
</body>
</html>