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

Name:<input name="name" value="${customer.name}" type="text"/><br><br>
Address:<input name="details" value="${customer.details}" type="text"/><br><br>
contact:<input name="contact" value="${customer.contact}" type="text"/><br><br>
Pin code:<input name="pincode" value="${customer.pincode}" type="text"/><br><br>
E-mail:<input name="email" value="${customer.email}" type="text"/><br><br>

<input type="submit" value="Save">
</form>
</body>
</html>