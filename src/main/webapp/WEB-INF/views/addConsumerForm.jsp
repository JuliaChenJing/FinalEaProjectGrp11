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
	<h1>Sign Up Form</h1>

	<form:form action="/consumer/signUp" method="post"
		modelAttribute="newConsumer">
	 First Name: <form:input id="firstName" path="firstName" type="text" />
	 <form:errors path="firstName" cssStyle="color : red;" />
		<br>
	 Last Name: <form:input id="lastName" path="lastName" type="text" />
	 <form:errors path="lastName" cssStyle="color : red;" />
		<br>
	 Password: <form:input id="password" path="password" type="password" />
	 <form:errors path="password" cssStyle="color : red;" />
		<br> 
	 Street: <form:input id="street" path="street" type="text" />
	 <form:errors path="street" cssStyle="color : red;" />
		<br> 
	City:  <form:input id="city" path="city" type="text" />
	 <form:errors path="city" cssStyle="color : red;" />
		<br> 
	Zip:  <form:input id="zip" path="zip" type="text" />
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