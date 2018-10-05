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
<h4>No feedback available for this item...</h4>
</c:if>
<c:forEach items="${list }" var="feedback">
Id:${feedback.feedback_id }<br>
Content:${feedback.details }<br><br><br>
</c:forEach>
</body>
</html>