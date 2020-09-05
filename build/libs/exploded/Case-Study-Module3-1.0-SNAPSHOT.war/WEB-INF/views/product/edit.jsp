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
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="products?action=products">List All Product</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Product
                </h2>
            </caption>
            <c:if test="${product != null}">
                <input type="hidden" name="id" value="<c:out value="${product.getId()}"/> "/>
            </c:if>
            <tr>
                <th>ID: </th>
                <td>
                    <c:out value="${product.getId()}"/>
                </td>
            </tr>
            <tr>
                <th>Type: </th>
                <td>
                    <input type="text" name="type" value="<c:out value="${product.getType()}"/> ">
                </td>
            </tr>
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" value="<c:out value="${product.getName()}"/> ">
                </td>
            </tr>
            <tr>
                <th>Brand: </th>
                <td>
                    <input type="text" name="brand" value="<c:out value="${product.getBrand()}"/> ">
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" value="<c:out value="${product.getPrice()}"/> ">
                </td>
            </tr>
            <tr>
                <th>Image: </th>
                <td>
                    <input type="text" name="image" value="<c:out value="${product.getImage()}"/> ">
                </td>
            </tr>
            <tr>
                <th>Amount: </th>
                <td>
                    <input type="text" name="amount" value="<c:out value="${product.getAmount()}"/> ">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
