<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Quản lý thể loại</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<%--    <link rel="stylesheet" href="../../css/custom/style.css" />--%>
<%--    <link rel="stylesheet" href="../../css/plugin/bootstrap.min.css" />--%>
<%--    <link rel="stylesheet" href="../../css/custom/index.css" />--%>
<%--    <link rel="stylesheet" href="../../assets/font-we/bootstrap-icons.css" />--%>
<%--    <link rel="stylesheet" href="../../css/custom/stylecopy.css" />--%>
    <style>

    </style>
</head>
<body>
<%@include file="../layout/header.jsp" %>
<h1 style="margin-top: 120px">Categories</h1>
<div class="container mt-3 " style="margin-top: 120px">


        <frm:form action="" method="post" modelAttribute="categories">
        <div class="mb-3">
            <label class="form-label">Name</label>
            <frm:input type="text" value="${categoriesList.name}" path="name" class="form-control"/>
            <frm:errors path="name" cssStyle="color: red; font-weight: bold"/>
        </div>

            <div class="mb-3">
                <label class="form-label">Status</label>
            <select class="form-select" aria-label="Default select example" name="status">
                <option value="1" ${categoriesList.status ==1?"selected": ""}>Còn</option>
                <option value="0" ${categoriesList.status ==0?"selected": ""}>Hết</option>
            </select>
            </div>

       <div class="col-2">
           <button formaction="/admin/categories/add" type="submit" class="btn btn-primary">Thêm</button>
           <button formaction="/admin/categories/update/${categoriesList.id}" type="submit" class="btn btn-primary">Sửa</button>
       </div>

        <div class="row">
            <table class="table table-hover">
                <thead>
                <tr>

                    <th scope="col">Name</th>
                    <th scope="col">Status</th>
                    <th scope="col">Function</th>

                </tr>

                </thead>

                <tbody>
                <c:forEach var="sv" items="${list}">
                    <tr>

                        <td>${sv.name}</td>
                        <td>${sv.status==0?"Hết": "Còn"}</td>

                        <td><a href="/admin/categories/edit/${sv.id}" class="btn btn-warning">
                            Edit </a>
                            <a href="/admin/categories/delete/${sv.id}"
                               class="btn btn-danger"> Delete </a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </frm:form>

</div>
<%@include file="../layout/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

</body>

</html>