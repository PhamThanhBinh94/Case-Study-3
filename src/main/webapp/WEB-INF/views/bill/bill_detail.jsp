<%--
  Created by IntelliJ IDEA.
  User: Pham Tuyen
  Date: 9/5/2020
  Time: 1:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bill detail</title>
</head>
<body>
    <h3>Bill detail</h3>
    <table>
        <tr>
            <th>Bill ID:</th>
            <td><c:out value="${bill.getBill_id()}"/></td>
        </tr>
        <tr>
            <th>Customer Number:</th>
            <td><c:out value="${bill.getCustomer_id()}"/></td>
        </tr>
        <tr>
            <th>Create Date:</th>
            <td><c:out value="${bill.getCreate_date()}"/></td>
        </tr>
        <tr>
            <th>Address :</th>
            <td><c:out value="${bill.getAddress()}"/></td>
        </tr>
        <tr>
            <th>Status:</th>
            <td><c:out value="${bill.getStatus()}"/></td>
        </tr>
    </table>
    <p>Customer information</p>
    <p>Bill:</p>
    <table>
        <tr>
            <th>NO</th>
            <th>Product ID</th>
            <th>Unit price</th>
            <th>Amount</th>
        </tr>
        <c:forEach var="detail" items="${details}">
            <tr>
                <td><c:out value="${details.indexOf(detail) + 1}"/></td>
                <c:forTokens items="${detail}" delims="__" var="token">
                    <td><c:out value="${token}"/></td>
                </c:forTokens>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td>Total</td>
            <td colspan="2"><c:out value="${total}"/></td>
        </tr>
    </table>
</body>
</html>
