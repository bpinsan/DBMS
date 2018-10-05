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
<form:form modelAttribute="feedback" method="post">

Write feedback:
<form:input path="details" type="text"/>
<form:errors path="details"></form:errors>

<form:hidden path="customer" value="${feedback.customer }"/>
<form:hidden path="product" value="${feedback.product }"/>
<input type="submit">

</form:form>
</body>
</html>