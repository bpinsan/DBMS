<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>

<head>
<title>Custom Login Page</title>

<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
}
</style>
</head>
<body onload='document.loginForm.j_username.focus();'>
	<h3>Custom Login Page</h3>

	<%
		String errorString = (String) request.getAttribute("error");
		if (errorString != null && errorString.trim().equals("true")) {
			out.println("<span class=\"errorblock\">Incorrect login name or password. Please try again");
			
		}
	%>

	<form name='loginForm' action="<c:url value='login' />" method='POST'>

		
			
				User:
				<input type='text' name='username' value=''><br>
			
			
				Password:
				<input type='password' name='password' /><br>
			
			
				<input name="submit" type="submit" value="submit" />
				<input name="reset" type="reset" />
			
		

	</form>
</body>
</html>
