<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <%@include file="../imports.jspf"%>
</head>

<body>
<c:set var="title" value="Register"/>
<%@ include file="../pre navigation bar.jspf" %>
<div class="py-3"></div>
<div class="d-flex align-items-center" style="min-height: 95vh">
    <div class="container-fluid">
        <div class="d-flex justify-content-center ">
            <form class="card" action="/register/submit" method="post">
                <div class="card-body">
                    <div class="row d-flex justify-content-center">
                        <div class="col-sm-12 col-md-4">
                            <div class="mb-3">
                                <label class="form-label">
                                    Name
                                    <input class="form-control" name="name" type="text">
                                </label>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">
                                    Age
                                    <input class="form-control" name="age" type="number" min="12" max="99">
                                </label>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">
                                    Phone
                                    <input class="form-control" name="phone" type="tel">
                                </label>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">
                                    Address
                                    <textarea class="form-control" rows="3" name="address" type="text"></textarea>
                                </label>
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-4">
                            <div class="mb-3">
                                <label class="form-label">
                                    Type
                                    <select name="type" class="form-select">
                                        <option value="Customer" selected>Customer</option>
                                        <option value="Garage" >Garage owner</option>
                                        <option value="Driver" >Boom truck driver</option>
                                        <option value="Shop" >Spare part shop</option>
                                    </select>
                                </label>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">
                                    Username
                                    <input class="form-control" name="username" type="text">
                                </label>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">
                                    Email
                                    <input class="form-control" name="email" type="email">
                                </label>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">
                                    Password
                                    <input class="form-control" name="password" type="password">
                                </label>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">
                                    Confirm Password
                                    <input class="form-control" name="password-conf" type="password">
                                </label>
                            </div>

                            <input class="btn btn-success float-end" type="submit" value="Register">
                        </div>
                        <div class="col-12">
                            <div class="mb-1 d-flex justify-content-center">
                                <a href="/login">I have an account</a>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
