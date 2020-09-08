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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        header{
            border-bottom: solid 1px #c0c0c0;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <header class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">ADMIN</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <%--                    <li class="nav-item active">--%>
                    <a class="navbar-brand" href="http://localhost:8080/users">Khách hàng <span class="sr-only">(current)</span></a>
                    <a class="navbar-brand" href="http://localhost:8080/bill">Hóa đơn<span class="sr-only">(current)</span></a>
                    <%--                    </li>--%>
                    <%--                    <li class="nav-item">--%>
                    <%--                        <a class="nav-link" href="#">Link</a>--%>
                    <%--                    </li>--%>
                    <li class="nav-item dropdown ">
                        <a class="nav-link dropdown-toggle navbar-brand" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Sản phẩm
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/products">Toàn bộ sản phẩm</a>
                            <a class="dropdown-item" href="/products?type=tivi">Tivi</a>
                            <a class="dropdown-item" href="/products?type=tu-lanh">Tủ lạnh</a>
                            <a class="dropdown-item" href="/products?type=dieu-hoa-nhiet-do">Điều hòa</a>
                            <a class="dropdown-item" href="/products?type=may-giat">Máy giặt</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Khác</a>
                        </div>
                    </li>
                    <%--                    <li class="nav-item">--%>
                    <%--                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>--%>
                    <%--                    </li>--%>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Tìm kiếm" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm sản phẩm</button>
                </form>
            </div>
        </nav>

    </header>
</div>
<div align="center">
    <h3>Chi tiết hóa đơn </h3>
    <table align="center" border="1" cellpadding="5" class="table table-hover col-md-3">
        <tr>
            <th class="thead-dark">Bill ID:</th>
            <td><c:out value="${bill.getBill_id()}"/></td>
        </tr>
        <tr>
            <th class="thead-dark">Customer Number:</th>
            <td><c:out value="${bill.getCustomer_id()}"/></td>
        </tr>
        <tr>
            <th class="thead-dark">Create Date:</th>
            <td><c:out value="${bill.getCreate_date()}"/></td>
        </tr>
        <tr>
            <th class="thead-dark">Address :</th>
            <td><c:out value="${bill.getAddress()}"/></td>
        </tr>
        <tr>
            <th class="thead-dark">Status:</th>
            <td><c:out value="${bill.getStatus()}"/></td>
        </tr>
    </table>
    <p>Customer information</p>
    <h5 >Hóa đơn</h5>
    <table border="1" cellpadding="5" class="table table-hover col-md-3 ">
        <tr class="thead-dark">
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
</div>
</body>
</html>
