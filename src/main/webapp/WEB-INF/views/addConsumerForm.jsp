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
	
	 <form:form  modelAttribute="newConsumer">
	 First Name: <form:input id="firstName" path="firstName" type="text"/><br>
	 Last Name: <form:input id="lastName" path="lastName" type="text"/><br>
	 <%-- Password: <form:input id="password" path="password" type="text"/><br>
	 Confirmed Password: <form:input id="confirmed" path="confirmed" type="text"/><br>
	 Address: <form:input id="address" path="address" type="text"/><br>
	 Email:<form:input id="email" path="email" type="text"/><br>
	 Phone:<form:input id="phone" path="phone" type="text"/><br>	 
	  --%>
	 <input type="submit" id="btnAdd" value ="AddProduct"/>
	 
	 </form:form>
	

</body>
</html>