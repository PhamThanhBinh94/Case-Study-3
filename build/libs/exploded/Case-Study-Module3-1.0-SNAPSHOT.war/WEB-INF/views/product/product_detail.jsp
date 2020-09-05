<%--
  Created by IntelliJ IDEA.
  User: Pham Tuyen
  Date: 9/6/2020
  Time: 12:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Detail</title>
</head>
<body>
    <h3>Product detail</h3>
    <table>
        <tr>
            <th>ID: </th>
            <td><c:out value="${product.getId()}"/></td>
        </tr>
        <tr>
            <th>Type: </th>
            <td><c:out value="${product.getType()}"/></td>
        </tr>
        <tr>
            <th>Name: </th>
            <td><c:out value="${product.getName()}"/></td>
        </tr>
        <tr>
            <th>Brand: </th>
            <td><c:out value="${product.getBrand()}"/></td>
        </tr>
        <tr>
            <th>Price: </th>
            <td><c:out value="${product.getPrice()}"/></td>
        </tr>
        <tr>
            <th>Amount: </th>
            <td><c:out value="${product.getAmount()}"/></td>
        </tr>
    </table>
    <p>Image: </p>
    <img src="<c:out value="${product.getImage()}"/>"/>
    <p>Information: </p>
    <table>
        <c:forEach var="detail" items="${details}">
            <c:forTokens items="${detail}" delims="#" var="token">
                <c:forTokens items="${token}" delims="===" var="token1">
                    <tr style="border: 1px black solid">
                        <c:forTokens items="${token1}" delims="__" var="token2">
                            <td style="border: 1px black solid"><c:out value="${token2}"/></td>
                        </c:forTokens>
                    </tr>
                </c:forTokens>
            </c:forTokens>
        </c:forEach>
    </table>
</body>
</html>
