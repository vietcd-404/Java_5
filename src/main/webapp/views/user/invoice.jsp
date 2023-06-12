<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Hóa Đơn Chi Tiết</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <style>

    </style>
</head>
<body>
<%@include file="../layout/header.jsp" %>
<h1 style="margin-top: 120px">Invoice</h1>
<div class="container mt-3 " >

        <div class="row">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Brand</th>
                    <th scope="col">Address</th>
                    <th scope="col">Invoice creation date</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Total</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="sv" items="${list}">
                    <tr>

                        <td>${sv.product.name}</td>
                        <td>${sv.product.price}</td>
                        <td>${sv.product.brand}</td>
                        <td>${sv.order.address}</td>
                        <td>${sv.order.oderDate}</td>
                        <td>${sv.quantity}</td>
                        <td>${sv.total}</td>
<%--                        <td>${sv.order.status == 0 ? "Chưa nhận được" : "Đã nhận được"}</td>--%>
<%--                        <td><a href="${pageContext.request.contextPath}/user/order-detail/update/${sv.id}" class="btn btn-warning">--%>
<%--                            Nhận được hàng </a>--%>
<%--                        </td>--%>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

</div>

<%@include file="../layout/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>

</html>