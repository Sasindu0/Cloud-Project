<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HMR
  Date: 7/10/2022
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>-->

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Garages</title>
    <%@ include file="../imports.jspf" %>
<%--    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        /* Style the header */
        header {
            background-color: #666;
            padding: 30px;
            text-align: center;
            font-size: 35px;
            color: white;
            font-family: "Pristina";
        }

        /* Create two columns/boxes that floats next to each other */
        nav {
            float: left;
            width: 30%;
            height: 300px; /* only for demonstration, should be removed */
            background: #ccc;
            padding: 20px;
        }

        /* Style the list inside the menu */
        nav ul {
            list-style-type: none;
            padding: 0;
        }

        article {
            float: left;
            padding: 20px;
            width: 70%;
            background-color: #f1f1f1;
            height: 300px; /* only for demonstration, should be removed */
        }

        /* Clear floats after the columns */
        section::after {
            content: "";
            display: table;
            clear: both;
        }

        /* Style the footer */
        footer {
            background-color: #777;
            padding: 10px;
            text-align: center;
            color: white;
        }

        /* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
        @media (max-width: 600px) {
            nav, article {
                width: 100%;
                height: auto;
            }
        }
    </style>--%>
</head>
<body>
    <c:set var="title" value="Available garages"/>
    <%@ include file="../navigation bar.jspf" %>
    <div class="py-4"></div>
    <br>

    <div class="container-fluid">
        <div class="row d-flex justify-content-center">
            <div class="col-sm-12 col-md-8">
                <c:if test="${garages.size() != 0}">
                    <table class="table table-responsive-sm">
                        <thead class="text-dark">
                        <tr>
                            <td>Name</td>
                            <td>Phone</td>
                            <td>Location</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="mechanic" items="${garages}">
                            <tr>
                                <td>${mechanic.name}</td>
                                <td>
                                        ${mechanic.garagePhone}
                                    <a href="tel:${mechanic.garagePhone}"
                                       class="btn btn-info float-end">
                                        <i class="fa fa-phone"></i>
                                    </a>
                                </td>
                                <td>
                                    <a class="btn btn-light" target="_blank" href="https://www.google.com/maps/dir/?api=1&destination=${mechanic.latitude},${mechanic.longitude}">
                                        <i class="fa fa-map-marker"></i>
                                    </a>
                                </td>
                            </tr>

                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
            <c:if test="${login.garageOwner}">
                <div class="col-sm-12 col-md-4 py-2">
                    <div class="card">
                        <div class="card-body">
                            <h3>Your garage</h3>
                            <br>
                            <table class="table table-hover">
                                <tr>
                                    <td>Name</td>
                                    <td>${my_garage.name}</td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td>${my_garage.garageEmail}</td>
                                </tr>
                                <tr>
                                    <td>Mobile number</td>
                                    <td>${my_garage.garagePhone}</td>
                                </tr>
                            </table>

                            <hr>
                            <a href="/garage/add" class="btn btn-success"><i class="fa fa-edit"></i>Edit info</a>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>

    </div>
</body>
</html>

