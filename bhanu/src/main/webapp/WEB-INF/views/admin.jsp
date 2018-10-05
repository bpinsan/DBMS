<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form action="admin/addproduct" method="get">
            Add Product: <input type="submit"> 
            </form>
            
            <form action="admin/addemployee" method="get">
            Add Employee: <input type="submit"> 
            </form>
            
            <form action="admin/addoffer" method="get">
            Add Offer: <input type="submit"> 
            </form>
            
            <form action="admin/allproduct" method="get">
            All Product: 
            <input type="submit"> 
            </form>
            
            <form action="admin/alloffer" method="get">
            All Offer: 
            <input type="submit"> 
            </form>
            <form action="/bhanu/admin/searchCustomer">
            	Search Customer: <input type="text" name="phoneno.">
            	<input type="submit">
            </form>
            
            <a href="/bhanu/admin/orders">All Orders</a><br><br>
            <a href="/bhanu/admin/unassignedorders">Assign Employee to orders</a><br><br>
            <a href="/bhanu/admin/employees">All Employees</a><br><br>
            <a href="/bhanu/admin/addorder">Add order</a><br><br>
            <form action="/bhanu/admin/addcustomer" method="get">
				<input type="submit" value="addcustomer"><br>
			</form>
            <a
                href="<c:url value="/j_spring_security_logout" />"> Logout</a>
    </c:if>
</body>
</html>
