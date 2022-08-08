<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HMR
  Date: 7/10/2022
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>-->

<%@page import="java.sql.*,java.util.*"%>

<!DOCTYPE html>
<html lang="en">

<c:set var="title" value=""/>
<c:choose>
    <c:when test="${garage==null}">
        <c:set var="title" value="Add garage"/>
    </c:when>
    <c:otherwise>
        <c:set var="title" value="Update garage"/>
    </c:otherwise>
</c:choose>
<head>
    <title></title>
    <%@ include file="../imports.jspf" %>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <style rel="stylesheet">
        /* Set the size of the div element that contains the map */
        #map {
            height: 25vw;
            /* The height is 400 pixels */
            width: 100%;
            /* The width is the width of the web page */
        }
    </style>
</head>
<body>

<%@include file="../navigation bar.jspf"%>

<div class="container-fluid">

    <div class="py-5"></div>
    <form action="/garage/add" method="post">
        <div class="row justify-content-center">

            <div class="col-sm-12 col-md-4">
                <div class="mb-3">
                    <label class="form-label">Shop Name</label>
                    <input class="form-control" name="name" type="text" value="${garage.name}" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Telephone</label>
                    <input class="form-control" name="phone" type="tel" value="${garage.garagePhone}" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input class="form-control" name="email" type="email" value="${garage.garageEmail}" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Latitude</label>
                    <input class="form-control" style="background-color: #e9ecef" type="text" id="latitude" name="latitude" value="${garage.latitude}" required readonly>
                </div>
                <div class="mb-3">
                    <label class="form-label">Longitude</label>
                    <input class="form-control" style="background-color: #e9ecef" type="text" id="longitude" name="longitude" required readonly value="${garage.longitude}" >
                </div>

            </div>
            <div class="col-sm-12 col-md-4">
                <div class="mb-3">
                    <div id="map"></div>
                    <script
                            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB41DRUbKWJHPxaFjMAwdrzWzbVKartNGg&callback=initMap&v=weekly"
                            defer>
                    </script>
                </div>
                <div class="mb-3">
                    <input class="btn btn-success float-end" type="submit" value="${title}">
                </div>
            </div>

        </div>
    </form>


</div>


<script>
    // Note: This example requires that you consent to location sharing when
    // prompted by your browser. If you see the error "The Geolocation service
    // failed.", it means you probably did not give permission for the browser to
    // locate you.
    let map, infoWindow;

    function initMap() {
        map = new google.maps.Map(document.getElementById("map"), {
            center: { lat: 7.8543697118737015, lng: 80.59892649020685 },
            zoom: 7,
        });
        infoWindow = new google.maps.InfoWindow();

        const locationButton = document.createElement("button");
        locationButton.classList.add("btn", "btn-info");
        locationButton.setAttribute("type", "button");

        locationButton.textContent = "Select your garage loocation";
        locationButton.classList.add("custom-map-control-button");
        map.controls[google.maps.ControlPosition.TOP_CENTER].push(locationButton);
        locationButton.addEventListener("click", () => {
            // Try HTML5 geolocation.
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(
                    (position) => {
                        const pos = {
                            lat: position.coords.latitude,
                            lng: position.coords.longitude,
                        };

                        document.getElementById("latitude").value = pos.lat;
                        document.getElementById("longitude").value = pos.lng;

                        infoWindow.setPosition(pos);
                        infoWindow.setContent("Your location.");
                        infoWindow.open(map);
                        map.setCenter(pos);
                    },
                    () => {
                        handleLocationError(true, infoWindow, map.getCenter());
                    }
                );
            }
            else {
                // Browser doesn't support Geolocation
                handleLocationError(false, infoWindow, map.getCenter());
            }
        });
    }

    function handleLocationError(browserHasGeolocation, infoWindow, pos) {
        infoWindow.setPosition(pos);
        infoWindow.setContent(
            browserHasGeolocation
                ? "Error: The Geolocation service failed."
                : "Error: Your browser doesn't support geolocation."
        );
        infoWindow.open(map);
    }

    window.initMap = initMap;
</script>


</body>
</html>

