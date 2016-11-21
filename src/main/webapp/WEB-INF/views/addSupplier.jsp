<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Supplier</title>
</head>
<body>
	<h1>Add Supplier</h1>
	<form:form action="/supplier/addsupplier" method="post"
		modelAttribute="newSupplier">
	 Name: <form:input id="supplierName" path="supplierName" type="text" />
		<br>
	 Activated Date:<form:input id="activatedDate" path="activatedDate" type="text" />	<br><br>

		<input type="submit" id="btnAdd" value="Add Supplier" />

	</form:form>
	
</body>
</html>