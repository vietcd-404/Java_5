<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--    <link rel="stylesheet" href="../css/custom/style.css" />--%>
    <%--    <link rel="stylesheet" href="../css/plugin/bootstrap.min.css" />--%>
    <%--    <link rel="stylesheet" href="../css/custom/index.css" />--%>
    <%--    <link rel="stylesheet" href="../assets/font-we/bootstrap-icons.css" />--%>
    <%--    <link rel="stylesheet" href="../css/custom/stylecopy.css" />--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body >

<%@include file="../layout/header.jsp" %>

<h1 style="margin-top: 120px">Shop</h1>
<div class="container">
    <div class="row">
        <c:forEach var="list" items="${list}">
            <div class="col-md-3 " style="margin-bottom: 35px">
                <div class="card" style="width: 18rem;">
                   <a href="/user/product/detail/${list.id}"><img src="/upload/${list.image}" class="card-img-top"></a>
                        <%--            <img src="../../assets/img/product-01.jpg" class="card-img-top" >--%>
                    <div class="card-body">
                        <h5 class="card-title">${list.name}</h5>
                        <p class="card-text">${list.price}</p>
                        <div style="text-align: center">
                           <form action="/cart/add" method="post">
                               <input type="hidden" name="productId" value="${list.id}" />
                               <button id="liveToastBtn"  type="submit" class="btn btn-primary">Add to cart</button>
                           </form>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:if test="${currentPage  > 1}">
            <li class="page-item">
                <a href="${pageContext.request.contextPath}/user/product/view?pageNum=${previousPage}"
                   class="page-link">Previous</a>
            </li>
            </c:if>

            <c:forEach begin="1" end="${totalPage}" varStatus="status">
                <li class="page-item">
                    <a href="${pageContext.request.contextPath}/user/product/view?pageNum=${status.index}"
                       class="page-link">${status.index}</a>
                </li>
            </c:forEach>
            <li class="page-item">
                <c:if test="${currentPage < totalPage}">
                <a href="${pageContext.request.contextPath}/user/product/view?pageNum=${nextPage}"
                   class="page-link">Next</a>
                </c:if>
            </li>
        </ul>
    </nav>

</div>
<%--<div class="toast-container position-fixed bottom-0 end-0 p-3">--%>
<%--    <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">--%>
<%--        <div class="toast-header">--%>
<%--            <strong class="me-auto">Bootstrap</strong>--%>
<%--            <small>11 mins ago</small>--%>
<%--            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>--%>
<%--        </div>--%>
<%--        <div class="toast-body">--%>
<%--            Hello, world! This is a toast message.--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<div class="toast align-items-center text-white bg-primary border-0" role="alert" aria-live="assertive" aria-atomic="true" id="liveToast">
    <div class="d-flex">
        <div class="toast-body">
            Sản phẩm đã được thêm vào giỏ hàng.
        </div>
        <button type="button" class="btn-close ms-auto me-2" data-bs-dismiss="toast" aria-label="Close"></button>
    </div>
</div>
<%@include file="../layout/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
<script>
    function showToast() {
        // Tạo một đối tượng toast mới
        var toast = new bootstrap.Toast(document.getElementById('liveToast'));

        // Hiển thị toast
        toast.show();
    }

    // Gắn sự kiện click cho nút "Add to cart"
    document.getElementById('liveToastBtn').addEventListener('click', function(event) {
        event.preventDefault(); // Ngăn chặn hành vi mặc định của form

        // Gọi hàm showToast để hiển thị thông báo
        showToast();
    });
</script>
</body>
</html>