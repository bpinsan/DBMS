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
	<c:forEach items="${list }" var="item">
		Username:${item.username }<br>
		Name:${item.name }<br>
		E-mail:${item.email }<br>
		Contact:${item.contact }<br>
		Gender:${item.gender }<br>
		Address:${item.details },${item.pincode }<br>
		Status:${item.enabled }<br>
		<a href="/bhanu/admin/changeuserstatus/${item.username }">Change Status</a><br>
		<a href="/bhanu/admin/customerorder/${item.username }">Customer orders</a><br><br><br>
	</c:forEach>	
</body>
</html>