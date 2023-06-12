<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Thanh toán thành công</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .container1 {
            max-width: 500px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .order-details .dong {
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px;
        }

        .order-details .row.total {
            font-weight: bold;
        }

        .order-details .label {
            color: #888;
        }

        .thank-you-message {
            text-align: center;
            margin-top: 20px;
        }

        .value {
            color: #333;
        }

        .total .value {
            color: #e91e63;
        }

    </style>
</head>
<body>
<%@include file="../layout/header.jsp" %>
<div class="container1" style="margin-top: 120px">
    <h1>Thanh toán thành công</h1>
    <p>Cảm ơn bạn đã hoàn thành thanh toán. Xem  <a class="link-opacity-100" href="/user/order-detail/view">hóa đơn chi tiết</a> của bạn
    </p>

<%--    <div class="order-details">--%>
<%--        <div class="dong">--%>
<%--            <div class="label">Sản phẩm:</div>--%>
<%--            <div class="value">Tên sản phẩm</div>--%>
<%--        </div>--%>
<%--        <div class="dong">--%>
<%--            <div class="label">Giá:</div>--%>
<%--            <div class="value">$100</div>--%>
<%--        </div>--%>
<%--        <div class="dong">--%>
<%--            <div class="label">Số lượng:</div>--%>
<%--            <div class="value">1</div>--%>
<%--        </div>--%>
<%--        <div class="dong total">--%>
<%--            <div class="label">Tổng cộng:</div>--%>
<%--            <div class="value">$100</div>--%>
<%--        </div>--%>
<%--    </div>--%>

    <div class="thank-you-message">
        <p>Cảm ơn bạn đã mua hàng!</p>
    </div>
</div>
<%@include file="../layout/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

</body>

</html>