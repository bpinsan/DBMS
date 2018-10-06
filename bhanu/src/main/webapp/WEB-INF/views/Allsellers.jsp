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
	<c:forEach items="${list}" var="item">
		Seller ID: ${item.seller_id }<br>
		Name: ${item.name }<br>
		Address:${item.address }<br>
		Contact:${item.contact }<br>
		Email:${item.email }<br>
		<a href="/bhanu/admin/updateseller/${item.seller_id }">Update</a>
	</c:forEach>
</body>
</html>