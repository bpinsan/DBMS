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
<form:form action="" method="post" modelAttribute="record">

Month:<form:input path="month" value="${month }"/><br>
Year:<form:input path="year" value="${year }"/><br>
Salary:<form:input path="salary" value="${salary }"/><br>

<input type="submit" value="submit">
</form:form>

<a href="/bhanu/admin/employeesalaryrecords/${employee_id }">Salary record</a>
</body>
</html>