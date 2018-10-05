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
</c:forEach>
</body>
</html>