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
    <h1>User Management</h1>
    <h2>
        <a href="products?action=products">List All Products</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Product</h2>
            </caption>
            <tr>
                <th>ID: </th>
                <td>
                    <input type="text" name="id" id="id"/>
                </td>
            </tr>
            <tr>
                <th>Type: </th>
                <td>
                    <input type="text" name="type" id="type"/>
                </td>
            </tr>
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" id="name"/>
                </td>
            </tr>
            <tr>
                <th>Brand: </th>
                <td>
                    <input type="text" name="brand" id="brand"/>
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" id="price"/>
                </td>
            </tr>
            <tr>
                <th>Image: </th>
                <td>
                    <input type="text" name="image" id="image"/>
                </td>
            </tr>
            <tr>
                <th>Amount: </th>
                <td>
                    <input type="text" name="amount" id="amount"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Create"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
