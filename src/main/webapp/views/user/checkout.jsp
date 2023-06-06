<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../layout/header.jsp" %>
<html>
<head>
    <title>Thanh Toán</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    <%--    <link rel="stylesheet" href="../../css/custom/style.css" />--%>
    <%--    <link rel="stylesheet" href="../../css/plugin/bootstrap.min.css" />--%>
    <%--    <link rel="stylesheet" href="../../css/custom/index.css" />--%>
    <%--    <link rel="stylesheet" href="../../assets/font-we/bootstrap-icons.css" />--%>
    <%--    <link rel="stylesheet" href="../../css/custom/stylecopy.css" /--%>

</head>
<body>
<h1>Checkout</h1>
<div class="container">
    <h2>Cart Summary</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Product</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${cart.items}">
            <tr>
                <td>${item.product.name}</td>
                <td>${item.quantity}</td>
                <td>${item.product.price}</td>
                <td>${item.product.price * item.quantity}</td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="3">Total Price:</td>
            <td>${totalPrice}</td>
        </tr>
        </tfoot>
    </table>

    <form action="/checkout" method="post">
        <h2>Shipping Information</h2>
        <div class="form-group">
            <label class="form-label">Address:</label>
            <input name="address"
                   type="text"
                   class="form-control" required/>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Place Order</button>
    </form>
</div>
<%@include file="../layout/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>

</body>

<html>