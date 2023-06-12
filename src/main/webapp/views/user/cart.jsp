<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giỏ hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<%@include file="../layout/header.jsp" %>

<h1 style="margin-top: 120px">Cart</h1>

<table class="table">
    <thead >
    <tr>
        <th>Product Name</th>
        <th>Image</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${cart.items}" var="item">
        <tr>
            <td>${item.product.name}</td>
            <td style="width: 150px" >
                <img src="/upload/${item.product.image}" class="card-img-top">
            </td>
            <td>${item.quantity}</td>
            <td>${item.product.price}</td>
            <td>
                <form action="/cart/remove" method="POST">
                    <input type="hidden" name="productId" value="${item.product.id}" />
                    <button class="btn btn-warning" type="submit">Remove</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<form action="/cart/clear" method="POST">
    <button class="btn btn-danger" type="submit">Clear Cart</button>
</form>

<form action="/checkout" method="GET">
    <button class="btn btn-primary" type="submit">Checkout</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

<%@include file="../layout/footer.jsp" %>
</body>
</html>