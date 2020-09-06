<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 9/4/2020
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Use Management Application</title>
</head>
<body>
<center>
    <h1>Use management</h1>
    <h2>
        <a href="/products?action=create">Add New Product</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Product</h2></caption>
        <tr>
            <th>ID</th>
            <th>Type</th>
            <th>Name</th>
            <th>Brand</th>
            <th>Price</th>
            <th>Image</th>
            <th>Amount</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listProduct}" var="product">
            <tr>
                <td><a href="/products?action=view&id=${product.getId()}"><c:out value="${product.getId()}"></c:out></a></td>
                <td><c:out value="${product.getType()}"></c:out></td>
                <td><c:out value="${product.getName()}"></c:out></td>
                <td><c:out value="${product.getBrand()}"></c:out></td>
                <td><c:out value="${product.getPrice()}"></c:out></td>
                <td><img src="${product.getImage()}"/></td>
                <td><c:out value="${product.getAmount()}"></c:out></td>
                <td>
                    <a href="/products?action=edit&id=${product.getId()}">Edit</a>
                    <a href="/products?action=delete&id=${product.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
