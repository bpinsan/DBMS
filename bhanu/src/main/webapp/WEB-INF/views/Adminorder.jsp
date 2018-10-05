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
<form action="/bhanu/admin/assignemployee/${orderId }" method="post" id="assign">
<select name="empId">
<c:forEach items="${employees }" var="employee">
<option value="${employee.employee_id }">${employee.employee_id }  ${employee.name }</option>
</c:forEach>
</select>
<!-- <input name="empId" type="number"> -->
<input type="submit" value="submit">
</form>
<c:forEach items="${list }" var="item">
<div style="margin-left:10%;margin-right:10%;margin-top:3%;background-color:red;">
<table>
<tr><td>
Product_id:</td>
<td>${item.product_id }</td></tr>
<tr><td>Quantity:</td><td>${item.quantity }</td></tr>
</table></div>
</c:forEach>
</body>
</html>