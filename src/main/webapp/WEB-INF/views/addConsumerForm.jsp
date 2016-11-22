<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up Form</title>
</head>
<body>
	<%-- <spring:message code="message.field" text="Default Text" /> --%>
				<br /> Language : <a href="?lang=en">English</a>|<a href="?lang=np">Nepali ma Januhos</a><br />
				 <%-- Current Locale : ${pageContext.response.locale} --%>
	<h1>Sign Up Form</h1>
	
	<form:form action="/consumer/signUp" method="post"
		modelAttribute="newConsumer">
		
	 <spring:message code="message.first" text="Default Text" /><form:input id="firstName" path="firstName" type="text" />
	 <form:errors path="firstName" cssStyle="color : red;" />
		<br>
	<spring:message code="message.lastname" text="Default Text" /> <form:input id="lastName" path="lastName" type="text" />
	 <form:errors path="lastName" cssStyle="color : red;" />
		<br>
	<spring:message code="message.username" text="Default Text" /><form:input id="username" path="username" type="text" /><br>
	 
	 <spring:message code="message.password" text="Default Text" /> <form:input id="password" path="password" type="password" />
	 <form:errors path="password" cssStyle="color : red;" />
		<br> 
	 <spring:message code="message.street" text="Default Text" /> <form:input id="street" path="street" type="text" />
	 <form:errors path="street" cssStyle="color : red;" />
		<br> 
	 <spring:message code="message.city" text="Default Text" /> <form:input id="city" path="city" type="text" />
	 <form:errors path="city" cssStyle="color : red;" />
		<br> 
	Zip:<form:input id="zip" path="zip" type="text" />
	<form:errors path="zip" cssStyle="color : red;" />
		<br> 
	
	 Phone:<form:input id="phone" path="phone" type="text" />
	 <form:errors path="phone" cssStyle="color : red;" />
		<br>	 
	 Email:<form:input id="email" path="email" type="text" />
	 <form:errors path="email" cssStyle="color : red;" />
		<br>
		<br>

		<input type="submit" id="btnAdd" value=" Sign Up" />

	</form:form>


</body>
</html>