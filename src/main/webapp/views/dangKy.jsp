<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        .register-container {
            /*max-width: 400px;*/
            /*margin: 0 auto;*/
            /*padding: 20px;*/
            /*background-color: white;*/
            /*border: 1px solid #ccc;*/
            /*border-radius: 4px;*/

            max-width: 400px;
            margin: 0 auto;
            padding: 40px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .login-title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-label {
            display: block;
            font-weight: bold;
        }

        .form-control {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .btn-login {
            display: block;
            width: 100%;
            padding: 10px;
            font-size: 16px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-login:hover {
            background-color: #0069d9;
        }

        .login-links {
            margin-top: 10px;
            text-align: center;
        }

        .login-links a {
            text-decoration: none;
            color: #888;
        }

        .login-links a:hover {
            color: #555;
        }

    </style>
</head>

<body>
<!-- Existing login form code -->

<div class="register-container">
    <div class="login-title">Register</div>
    <frm:form  method="POST" modelAttribute="account">
        <div class="form-group">
            <label for="username" class="form-label">Username</label>
            <frm:input type="text" id="username" path="username" class="form-control" placeholder="Username" />
            <frm:errors path="username" cssStyle="color: red"/>
        </div>
        <div class="form-group">
            <label for="password" class="form-label">Password</label>
            <frm:input type="password" id="password" path="pass" class="form-control" placeholder="Password" />
            <frm:errors path="pass" cssStyle="color: red"/>
        </div>
        <div class="form-group">
            <label for="name" class="form-label">Name</label>
            <frm:input type="text" id="name" path="name" class="form-control" placeholder="Your Name" />
            <frm:errors path="name" cssStyle="color: red"/>
        </div>
        <div class="form-group">
            <label for="email" class="form-label">Email</label>
            <frm:input type="text" id="email" path="email" class="form-control" placeholder="Your Email" />
            <frm:errors path="email" cssStyle="color: red"/>
        </div>
        <button formaction="/register" type="submit" class="btn-login">Register</button>
        <div class="login-links">
            <a href="/login">Login</a>
        </div>
        <div class="login-links">
            <a href="#">Already have an account?</a>
        </div>
    </frm:form>
</div>

</body>
</html>