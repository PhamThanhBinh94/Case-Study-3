<%--
  Created by IntelliJ IDEA.
  User: Pham Tuyen
  Date: 9/4/2020
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
    <h2>All bills list</h2>
    <table>
        <tr>
            <th>Bill ID</th>
            <th>Customer ID</th>
            <th>Create Date</th>
            <th>Address</th>
            <th>Status</th>
        </tr>
        <c:forEach var="bill" items="${bills}">
            <tr>
                <td><c:out value="${bill.getBill_id()}"/></td>
                <td><c:out value="${bill.getCustomer_id()}"/></td>
                <td><c:out value="${bill.getCreate_date()}"/></td>
                <td><c:out value="${bill.getAddress()}"/></td>
                <td><c:out value="${bill.getStatus()}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
