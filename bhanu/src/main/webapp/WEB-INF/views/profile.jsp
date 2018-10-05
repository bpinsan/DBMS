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
<table>
<tr><td>Name:</td><td>${Customer.name }</td></tr>	
<tr><td>Address:</td><td>${Customer.details }</td></tr>
<tr><td>contact:</td><td>${Customer.contact }</td></tr>
<tr><td>Pin Code:</td><td>${Customer.pincode }</td></tr>
<tr><td><a href="/bhanu/user/addcontact">Add contacts</a></td></tr>
<tr><td><a href="/bhanu/user/edit_profile">Edit profile</a></td></tr>
</table>
</body>
</html>