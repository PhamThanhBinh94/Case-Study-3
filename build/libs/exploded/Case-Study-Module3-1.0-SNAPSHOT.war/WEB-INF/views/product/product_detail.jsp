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
    <title>Chi tiết sản phẩm</title>
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
        table{
            border-collapse: collapse;
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
<div>

    <table border="1" cellpadding="5" class="table table-hover col-5" style="float: left">
        <tr>
            <th  colspan="2"> Chi tiết sản phẩm</th>
        </tr>
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
    <img style="margin-left: 200px;"  src="<c:out value="${product.getImage()}" />" width="300px" height="300px"/>
    <p style="clear: both"> Information: </p>
    <table class="table table">
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
</div>
</body>
</html>
