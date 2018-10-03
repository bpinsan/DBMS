<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form action="admin/addproduct" method="get">
            <table>
            <tr>
            <td>Add Product: </td>
            <td><input type="submit"> </td>
            </tr>
            </table>
            </form>
            <form action="admin/addemployee" method="get">
            <table>
            <tr>
            <td>Add Employee: </td>
            <td><input type="submit"> </td>
            </tr>
            </table>
            </form>
            <form action="admin/addoffer" method="get">
            <table>
            <tr>
            <td>Add Offer: </td>
            <td><input type="submit"> </td>
            </tr>
            </table>
            </form>
            <form action="admin/allproduct" method="get">
            <table>
            <tr>
            <td>All Product: </td>
            <td><input type="submit"> </td>
            </tr>
            </table>
            </form>
            <form action="admin/alloffer" method="get">
            <table>
            <tr>
            <td>All Offer: </td>
            <td><input type="submit"> </td>
            </tr>
            </table>
            </form>
            <form action="admin/addcustomer" method="get">
				<input type="submit" value="addcustomer"><br>
			</form>
            <a
                href="<c:url value="/j_spring_security_logout" />"> Logout</a>
    </c:if>
</body>
</html>
