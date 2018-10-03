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
<h4>No Products Available...</h4>
</c:if>
<c:forEach items="${list }" var="Offer">
<div style="float:left;width:30%;margin-left:5%;background-color:red;margin-top:3%">
<table>
<tr><td>Offer_id:</td>
<td>${Offer.offer_id }</td></tr>
<tr><td>Name:</td>
<td>${Offer.name }</td></tr>
<tr><td>Discount:</td>
<td>${Offer.discount }</td></tr>
<tr><td>Status:</td>
<td>${Offer.status }</td></tr>
<tr><td>Update:</td>
<td><a href="/bhanu/admin/updateoffer/${Offer.offer_id }">Update</a>
</td></tr>

</table></div>
</c:forEach>
</body>
</html>