<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h4 class="d-flex justify-content-center">Boom truck details</h4>
<table class="table table-hover">
    <tr>
        <th>Truck number</th>
        <td>${session.truck.vehicleNumber}</td>
    </tr>
    <tr>
        <th>Driver name</th>
        <td>${session.truck.driver.name}</td>
    </tr>
    <tr>
        <th>Price per km</th>
        <td>Rs. ${session.truck.pricePerKmTxt}</td>
    </tr>
</table>
<div class="py-1"></div><hr>

<h4 class="d-flex justify-content-center">Customer details</h4>
<table class="table table-hover">
    <tr>
        <th>Customer name</th>
        <td>${session.customer.name}</td>
    </tr>
    <tr>
        <th>Vehicle number</th>
        <td>${session.customerVehicle.numberPlate}</td>
    </tr>
    <tr>
        <th>Vehicle type</th>
        <td>${session.customerVehicle.vehicleType}</td>
    </tr>
</table>
<div class="py-1"></div><hr>

<h4 class="d-flex justify-content-center">Session details</h4>
<table class="table table-hover">
    <tr>
        <th>Requested time</th>
        <td>${session.timeRequested}</td>
    </tr>
    <tr>
        <th>Status</th>
        <td>${session.status}</td>
    </tr>
</table>

