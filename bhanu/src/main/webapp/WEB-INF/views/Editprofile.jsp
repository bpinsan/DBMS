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
<form action="" method="post" >
<table>
<tr><td>Name:</td><td><input name="name" value="${customer.name}" type="text"/></td></tr>
<tr><td>Address:</td><td><input name="details" value="${customer.details}" type="text"/></td></tr>
<tr><td>contact:</td><td><input name="contact" value="${customer.contact}" type="text"/></td></tr>
<tr><td>Pincode:</td><td><input name="pincode" value="${customer.pincode}" type="text"/></td></tr>
</table>
<input type="submit" value="Save">
</form>
</body>
</html>