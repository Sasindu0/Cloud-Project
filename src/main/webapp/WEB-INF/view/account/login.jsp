<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="../imports.jspf"%>

</head>
<body>
<c:set var="title" value="Login"/>
<%@ include file="../pre navigation bar.jspf" %>
<div class="py-3"></div>

<div class="d-flex align-items-center" style="min-height: 80vh">
    <div class="container-fluid">
        <div class="d-flex justify-content-center ">
            <form class="card" action="/login/submit" method="post">
                <div class="card-body">
                    <div class="mb-3">
                        <label class="form-label">
                            Username
                            <input class="form-control" name="username" type="text">
                        </label>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">
                            Password
                            <input class="form-control" name="password" type="password">
                        </label>
                    </div>

                    <input class="btn btn-success float-end" type="submit" value="Login">
                    <div class="py-4"></div>

                    <div class="mb-1 d-flex justify-content-center">
                        <a href="/register">I don't have an account</a>
                    </div>

                </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>
