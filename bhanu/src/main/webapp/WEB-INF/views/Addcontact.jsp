<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<form:form method="post" modelAttribute="contact" action="addcontact">
		Contact:<form:input path="Contact" type="text" /> <!-- bind to user.name-->
				<form:errors path="Contact" />
			<input type="submit" value="Submit" />
		${error}
	</form:form>