<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.List" %>
<%@ page import="com.bhanu.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${list }" var="item">
Name:${item.name }<br>
Salary:${item.salary }<br>
Working Area:${item.area }<br>
<a href="orderemployee/${item.employee_id}">Orders assigned</a><br><br>
</c:forEach>
</body>
</html>