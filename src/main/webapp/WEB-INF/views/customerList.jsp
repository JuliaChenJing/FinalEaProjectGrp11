<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<table border="0">
	<tr>
            <td align="center"><h2>All Customer List</h2></td>
    </tr>
                </table>
		<table border="1">
                
                
                <tr>
                
					<td>First Name</td>
					<td>Last Name</td>
					<td>Username</td>
					<td>email</td>
					<td>Street</td>
					<td>City</td>
					<td>Zip</td>
					<td>PhoneNumber</td> 
				</tr>
                
                <c:forEach var="users" items="${users}">
                
                <tr>
                    <td>${users.firstName}</td>
                   <td>${users.lastName}</td>
                    <td>${users.username}</td>
                    <td>${users.email}</td>
                    <td>${users.street}</td>
                     <td>${users.city}</td>
                     <td>${users.zip}</td>
                     <td>${users.phone}</td> 
                      <!-- <td><a href="/consumer/updateConsumer/${users.id}">Edit</a></td> -->
                     <td><a href="/consumer/deleteConsumer/${users.id}">Delete</a></td>
                </tr>
                
                </c:forEach>
          </table>
	</div>
</body>
</html>