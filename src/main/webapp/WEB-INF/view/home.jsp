<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HMR
  Date: 7/10/2022
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <%@ include file="imports.jspf" %>
</head>
<body data-bs-target=".navbar">

<c:set var="title" value="Home"/>
<%@ include file="navigation bar.jspf" %>

<div class="py-4"></div>
<br>

<div class="container-fluid">

    <div class="row ">
        <div class="col-sm-12 col-md-6 p-4">
            <div class="card">
                <a href="/shop/shop_page" class="btn btn-light card-body large_text">
                    Find a spare part shop
                </a>
            </div>
        </div>
        <div class="col-sm-12 col-md-6 p-4">
            <div class="card">
                <a href="/boom-truck" class="btn btn-light card-body">
                    Request a boom truck
                </a>
            </div>
        </div>
        <div class="col-sm-12 col-md-6 p-4">
            <div class="card">
                <a href="/garage/" class="btn btn-light card-body">
                    Find a nearby garage
                </a>
            </div>
        </div>
        <div class="col-sm-12 col-md-6 p-4">
            <div class="card">
                <a href="/mechanic/" class="btn btn-light card-body">
                    Find a Mechanic
                </a>
            </div>
        </div>

        <div class="col-sm-12 d-flex justify-content-center p-4">

            <div style="background-color: rgba(0, 0, 0, 0.6); padding: 20px; border-radius: 10px; margin-top: 70px;">
                <h2>
                    We are responsible for the solutions to all your emergency needs.
                    save your time and easily to fulfill your emergency needs whenever
                    you need.
                </h2>
            </div>

        </div>

    </div>

</div>


</body>
</html>
