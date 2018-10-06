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

Name:${Customer.name }<br>
Address:${Customer.details }<br>
contact:${Customer.contact }<br>
Pin Code:${Customer.pincode }<br>
Contacts:<br>
<c:forEach items="${contacts}" var="item">
	${item.contact } <a href="/bhanu/user/deletecontact/${item.contact_id }">Delete</a><br>
</c:forEach><br>
<a href="/bhanu/user/addcontact">Add contacts</a><br>
<a href="/bhanu/user/edit_profile">Edit profile</a><br>

</body>
</html>