<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@page session="true"%>
<html>
<body>
       <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="/bhanu/user/allproducts">All products</a><br>
        <a href="/bhanu/user/cart">cart</a><br>
        <a href="/bhanu/user/allorders">Your orders</a><br>
        <a href="/bhanu/user/profile">Profile</a><br>
        <a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
    </c:if>
</body>
</html>
