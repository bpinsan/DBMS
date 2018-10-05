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

Name:${employee.name }<br>
Salary:${employee.salary }<br>
Working Area:${employee.area }<br><br><br>

<c:if test="${empty list }">
<div style="margin-left:5%;"><h3>No order is assigned to this employee...</h3></div>
</c:if>
<c:forEach items="${list }" var="order">
Order id:${order.order_id }<br>
Address:${order.details }<br>
Amount :${order.total_price }<br>
Net amount :${order.grand_total }<br><br><br>
</c:forEach>
</body>
</html>