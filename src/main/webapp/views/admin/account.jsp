<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<html>
<head>
    <title>Quản lý tài khoản</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<%--    <link rel="stylesheet" href="../../css/plugin/bootstrap.min.css" />--%>
<%--    <link rel="stylesheet" href="../../css/custom/index.css" />--%>
<%--    <link rel="stylesheet" href="../../assets/font-we/bootstrap-icons.css" />--%>
<%--    <link rel="stylesheet" href="../../css/custom/stylecopy.css" />--%>
</head>
<body>
<%@include file="../layout/header.jsp" %>
<div class="container mt-3" >
    <frm:form action="" method="post" class="row g-3" modelAttribute="account">
        <div class="col-md-3">
            <label class="form-label">Name</label>
            <frm:input
                    value="${account.name}"
                    path="name"
                    type="text"
                    class="form-control"

            />
            <frm:errors path="name" cssStyle="color: red; font-weight: bold"/>
        </div>
        <div class="col-md-3">
            <label class="form-label">Email</label>
            <frm:input
                    value="${account.email}"
                    path="email"
                    type="text"
                    class="form-control"

            />
            <frm:errors path="email" cssStyle="color: red; font-weight: bold"/>
        </div>
        <div class="col-md-3">
            <label class="form-label">Username</label>
            <frm:input
                    value="${account.username}"
                    path="username"
                    type="text"
                    class="form-control"
            />
            <frm:errors path="username" cssStyle="color: red; font-weight: bold"/>
        </div>
        <div class="col-md-3">
            <label class="form-label">Pass</label>
            <frm:input
                    value="${account.pass}"
                    path="pass"
                    type="text"
                    class="form-control"

            />
            <frm:errors path="pass" cssStyle="color: red; font-weight: bold"/>
        </div>
        <div class="col-md-4">
            <label class="form-label">Avatar</label>
            <frm:input
                    value="${account.avatar}"
                    path="avatar"
                    type="text"
                    class="form-control"

            />
            <frm:errors path="avatar" cssStyle="color: red; font-weight: bold"/>
        </div>
        <div class="col-md-4">
            <label class="form-label">Role</label>
            <select class="form-select" aria-label="Default select example" name="role">
                <option value="1" ${categoriesList.status ==1?"selected": ""}>User</option>
                <option value="0" ${categoriesList.status ==0?"selected": ""}>Admin</option>
            </select>
        </div>
        <div class="col-md-4">
            <label class="form-label">Status</label>
            <input
                    value="${account.status}"
                    name="status"
                    type="text"
                    class="form-control"
                    required
            />
        </div>
        <div class="col-md-12">
            <button formaction="/admin/account/add" type="submit" class="btn btn-primary">Thêm</button>
            <button formaction="/admin/account/update/${account.id}" type="submit" class="btn btn-primary">Sửa</button>
        </div>


        <div class="row">
            <table class="table table-hover">
                <thead>
                <tr>

                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Username</th>
                    <th scope="col">Pass</th>
                    <th scope="col">Avatar</th>
                    <th scope="col">Role</th>
                    <th scope="col">Status</th>
                    <th scope="col">Function</th>

                </tr>

                </thead>

                <tbody>
                <c:forEach var="sv" items="${list}">
                    <tr>

                        <td>${sv.name}</td>
                        <td>${sv.email}</td>
                        <td>${sv.username}</td>
                        <td>${sv.pass}</td>
                        <td>${sv.avatar}</td>
                        <td>${sv.role==0?"Admin" : "User"}</td>
                        <td>${sv.status==0?"Hoạt động": "Không hoạt động"}</td>

                        <td><a href="/admin/account/edit/${sv.id}" class="btn btn-warning">
                            Edit </a>
                            <a href="/admin/account/delete/${sv.id}"
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