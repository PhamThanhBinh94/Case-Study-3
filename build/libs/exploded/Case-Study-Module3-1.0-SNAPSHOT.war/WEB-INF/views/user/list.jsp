<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 9/5/2020
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>Phone</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
            <td><c:out value="${user.getPhone()}"></c:out></td>
            <td><c:out value="${user.getName()}"></c:out></td>
            <td><c:out value="${user.getEmail()}"></c:out></td>
            <td><c:out value="${user.getAddress()}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
