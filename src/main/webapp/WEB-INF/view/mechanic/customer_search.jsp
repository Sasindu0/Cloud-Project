<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <head>
        <title>Mechanic</title>
        <%@ include file="../imports.jspf" %>

    </head>

    <body data-bs-target=".navbar">

        <c:set var="title" value="Search a mechanic"/>
        <%@ include file="../navigation bar.jspf" %>
        <div class="py-5"></div>

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12 col-md-8">
                    <c:if test="${mechanics.size() != 0}">
                        <table class="table table-responsive-sm">
                            <thead class="text-dark">
                            <tr>
                                <td>Name</td>
                                <td>Type</td>
                                <td>Phone</td>
                                <td>Location</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="mechanic" items="${mechanics}">
                                <tr>
                                    <td>${mechanic.mechanicName}</td>
                                    <td>${mechanic.type}</td>
                                    <td>
                                            ${mechanic.account.mobileNumber}
                                        <a href="tel:${mechanic.account.mobileNumber}"
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
            </div>
        </div>


    </body>

</html>