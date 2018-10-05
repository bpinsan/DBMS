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
<a href="/bhanu/admin/paysalary/${employee_id }">Add new payment record</a><br><br><br>
<body>
<c:forEach items="${list }" var="record">

Employee Id:${record.employee_id }<br>
Salary:${record.salary}<br>
Date:${record.month }/${record.year }<br>

<br><br>
</c:forEach>
</body>
</html>