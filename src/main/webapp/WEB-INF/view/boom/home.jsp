<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Boom truck</title>

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
        #map-track {
            height: 25vw;
            /* The height is 400 pixels */
            width: 100%;
            /* The width is the width of the web page */
        }
    </style>



</head>
<body data-bs-target=".navbar">

<c:set var="title" value="Find a boom truck"/>
<%@ include file="../navigation bar.jspf" %>

<div class="container-fluid">

    <div class="py-4"></div>
    <br>

    <div class="row">
        <div class="col-sm-12 col-md-8">

            <c:choose>
                <c:when test="${login.driver}">

                    <div class="form-check form-switch">
                        <input class="form-check-input" type="checkbox" id="available">
                        <label class="form-check-label" for="available">I am available now</label>
                    </div>
                    <script>
                        let a = document.getElementById("available");
                        a.addEventListener('change', function() {
                            let b = this.checked;

                            let url = "/boom-truck/available?" +
                                "available=" + encodeURIComponent(b);
                            fetch(url)
                                .then(function(response) {
                                    return response.text();
                                })
                                .then(function(data) {
                                    console.log(data);
                                    if (data === "0"){
                                        a.checked = false;
                                        return;
                                    }
                                    if (data === "1"){
                                        a.checked = true;
                                        return;
                                    }
                                    alert(data);
                                })
                                .catch(function() {
                                    console.log("ERROR");
                                });

                        });
                    </script>
                    <hr>
                    <button onclick="update_my_location()" class="btn btn-light"><i class="fa fa-map-location"></i>Update my location</button>


                </c:when>
                <c:otherwise>
                    <%@ include file="customer truck list.jspf" %>
                </c:otherwise>
            </c:choose>

            <hr>

            <div class="accordion" id="boomingSessions">
                <div class="accordion-item">

                    <c:set var="key" value="on_going"/>
                    <c:set var="sessions" value="${on_going}"/>
                    <h2 class="accordion-header" id="heading${key}">
                        <button class="accordion-button" type="button"
                                data-bs-toggle="collapse" data-bs-target="#collapse${key}"
                                aria-expanded="true" aria-controls="collapse${key}">
                            <b>Active boom truck sessions (${sessions.size()})</b>
                        </button>
                    </h2>
                    <div id="collapse${key}" class="accordion-collapse collapse show"
                         aria-labelledby="heading${key}" data-bs-parent="#boomingSessions">
                        <div class="accordion-body">
                            <%@include file="booming sessions.jspf"%>
                        </div>
                    </div>

                </div>
                <div class="accordion-item">

                    <c:set var="key" value="un_approved"/>
                    <c:set var="sessions" value="${un_approved}"/>
                    <h2 class="accordion-header" id="heading${key}">
                        <button class="accordion-button" type="button"
                                data-bs-toggle="collapse" data-bs-target="#collapse${key}"
                                aria-expanded="true" aria-controls="collapse${key}">
                            <b>Pending boom truck sessions (${sessions.size()})</b>
                        </button>
                    </h2>
                    <div id="collapse${key}" class="accordion-collapse collapse"
                         aria-labelledby="heading${key}" data-bs-parent="#boomingSessions">
                        <div class="accordion-body">
                            <%@include file="booming sessions.jspf"%>
                        </div>
                    </div>

                </div>

                <div class="accordion-item">

                    <c:set var="key" value="cancelled"/>
                    <c:set var="sessions" value="${cancelled}"/>
                    <h2 class="accordion-header" id="heading${key}">
                        <button class="accordion-button" type="button"
                                data-bs-toggle="collapse" data-bs-target="#collapse${key}"
                                aria-expanded="true" aria-controls="collapse${key}">
                            <b>Cancelled boom truck sessions (${sessions.size()})</b>
                        </button>
                    </h2>
                    <div id="collapse${key}" class="accordion-collapse collapse"
                         aria-labelledby="heading${key}" data-bs-parent="#boomingSessions">
                        <div class="accordion-body">
                            <%@include file="booming sessions.jspf"%>
                        </div>
                    </div>

                </div>
                <div class="accordion-item">

                    <c:set var="key" value="completed"/>
                    <c:set var="sessions" value="${completed}"/>
                    <h2 class="accordion-header" id="heading${key}">
                        <button class="accordion-button" type="button"
                                data-bs-toggle="collapse" data-bs-target="#collapse${key}"
                                aria-expanded="true" aria-controls="collapse${key}">
                            <b>Completed boom truck sessions (${sessions.size()})</b>
                        </button>
                    </h2>
                    <div id="collapse${key}" class="accordion-collapse collapse"
                         aria-labelledby="heading${key}" data-bs-parent="#boomingSessions">
                        <div class="accordion-body">
                            <%@include file="booming sessions.jspf"%>
                        </div>
                    </div>

                </div>
                <div class="accordion-item">

                    <c:set var="key" value="expired"/>
                    <c:set var="sessions" value="${expired}"/>
                    <h2 class="accordion-header" id="heading${key}">
                        <button class="accordion-button" type="button"
                                data-bs-toggle="collapse" data-bs-target="#collapse${key}"
                                aria-expanded="true" aria-controls="collapse${key}">
                            <b>Expired boom truck sessions (${sessions.size()})</b>
                        </button>
                    </h2>
                    <div id="collapse${key}" class="accordion-collapse collapse"
                         aria-labelledby="heading${key}" data-bs-parent="#boomingSessions">
                        <div class="accordion-body">
                            <%@include file="booming sessions.jspf"%>
                        </div>
                    </div>

                </div>
            </div>


        </div>
        <div class="col-sm-12 col-md-4">

            <div class="card">
                <div class="card-header">
                    <i class="fa fa-person"></i>
                    Your details
                </div>
                <div class="card-body">
                    <table class="table table-hover">

                        <c:choose>
                            <c:when test="${login.driver}">
                                <c:if test="${boom_truck != null}">
                                    <tr>
                                        <th>Vehicle number</th>
                                        <td>${boom_truck.vehicleNumber}</td>
                                    </tr>
                                    <tr>
                                        <th>Price per km</th>
                                        <td>Rs. ${boom_truck.pricePerKmTxt}</td>
                                    </tr>
                                    <tr>
                                        <th>Licence number</th>
                                        <td>${boom_truck.licence}</td>
                                    </tr>
                                </c:if>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <th>Your name</th>
                                    <td>${login.name}</td>
                                </tr>
                                <tr>
                                    <th>Previous sessions</th>
                                    <td>${completed.size()}</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>



                    </table>

                    <c:if test="${login.driver}">
                        <br>
                        <c:choose>
                            <c:when test="${boom_truck==null}">
                                <button class="btn btn-info d-flex justify-content-end"
                                        data-bs-toggle="modal" data-bs-target="#editModal">
                                    <i class="fa fa-plus"></i>
                                    Add your truck
                                </button>

                            </c:when>
                            <c:otherwise>
                                <button class="btn btn-info d-flex justify-content-end"
                                        data-bs-toggle="modal" data-bs-target="#editModal">
                                    <i class="fa fa-edit"></i>
                                    Edit details
                                </button>

                            </c:otherwise>
                        </c:choose>
                    </c:if>

                    <hr>

                    <p>Your location</p>
                    <div id="map"></div>
                    <script
                            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB41DRUbKWJHPxaFjMAwdrzWzbVKartNGg&callback=initMap&v=weekly"
                            defer>
                    </script>


                </div>
            </div>



        </div>
    </div>

</div>


<%--Request booming truck--%>
<div class="modal fade " id="requestModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Apply for a truck</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col">
                            <div class="mb-3">
                                <label for="vn" class="form-label">Vehicle number</label>
                                <input id="vn" class="form-control" name="vehicle number">
                            </div>
                            <div class="mb-3">
                                <label for="vt" class="form-label">Vehicle type</label>
                                <select id="vt" class="form-select" name="vehicle type">
                                    <option class="form-control" value="Motor cycle" selected>Motor cycle</option>
                                    <option class="form-control" value="Three wheeler" >Three wheeler</option>
                                    <option class="form-control" value="Car" >Car</option>
                                    <option class="form-control" value="Van" >Van</option>
                                    <option class="form-control" value="Bus" >Bus</option>
                                    <option class="form-control" value="Lorry" >Lorry</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="bi" class="form-label">Boom truck id</label>
                                <input id="bi" class="form-control" name="truck id" disabled>
                            </div>

                    </div>
                </div>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary" onclick="apply_session()">Apply</button>
            </div>
        </div>
    </div>
</div>

<%--Edit driver details--%>
<div class="modal fade " id="editModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Update your details</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col">
                        <div class="mb-3">
                            <label class="form-label">Vehicle number</label>
                            <input id="d_vehicle" type="text" class="form-control" name="vehicle" value="${boom_truck.vehicleNumber}">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Your driver licence number</label>
                            <input id="d_license" type="text" class="form-control" name="license" value="${boom_truck.licence}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Price per km</label>
                            <input id="d_price" type="text" class="form-control" name="price" value="${boom_truck.pricePerKmTxt}">
                        </div>

                    </div>
                </div>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary" onclick="save_driver_details()">Update</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade " id="detailsModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Session details</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" id="detail-body" style="max-height: 50vh; overflow-y: scroll; overflow-x: hidden">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Okay</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade " id="trackModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Track your session</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div id="map-track"></div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Okay</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade " id="completeModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Did your booming session complete?</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-bs-dismiss="modal">No</button>
                <button type="button" class="btn btn-primary" >Yes</button>
            </div>
        </div>
    </div>
</div>


<script>

    let lat, lon, map;
    let map2;


    function check_location_access() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (location) {
                const marker = new google.maps.Marker({
                    position: {lat : location.coords.latitude, lng : location.coords.longitude},
                    map: map,
                });
            });
        }
    }

    function enableLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (location) {
                lat = location.coords.latitude;
                lon = location.coords.longitude;
                getNearestTrucks(location.coords.latitude, location.coords.longitude);
                const marker = new google.maps.Marker({
                    position: {lat:lat, lng:lon},
                    map: map,
                });
            });
        } else {
            alert("Unable to find your location!");
        }
    }
    function getNearestTrucks(latitude, longitude) {
        let url = "/boom-truck/near?lat="+ encodeURIComponent(latitude)+ "&lon=" +encodeURIComponent(longitude);
        fetch(url)
            .then(function(response) {
            return response.text();
        })
            .then(function(data) {
            let x = data.split(" ", 2);
            if (x[0] === "E"){
                alert(x[1]);
            }else {
                let a = document.getElementById("enable");
                a.innerHTML = "<h4>Near by trucks</h4>"
                let b = document.getElementById("trucks");
                console.log(data);
                b.innerHTML = data;

            }
        })
            .catch(function() {
            console.log("ERROR");
        });
    }
    function request(id) {
        let a = document.getElementsByName("truck id")[0];
        a.value = id;
    }
    function apply_session() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (location) {
                lat = location.coords.latitude;
                lon = location.coords.longitude;

                let number = document.getElementById("vn").value;
                let type = document.getElementById("vt").value;
                let id = document.getElementsByName("truck id")[0].value;

                if (number.length < 3) {
                    alert("Invalid vehicle number!");
                    return;
                }
                if (type.length < 3) {
                    alert("Invalid vehicle type!");
                    return;
                }
                if (id.length < 1) {
                    alert("Invalid truck!");
                    return;
                }


                if (lat == null || lon == null || lat < 0 || lon < 0) {
                    alert("Invalid location of your vehicle!");
                    return;
                }

                let url = "/boom-truck/request?" +
                    "vehicle=" + encodeURIComponent(number) + "&" +
                    "type=" + encodeURIComponent(type) + "&" +
                    "id=" + encodeURIComponent(id) + "&" +
                    "lat=" + encodeURIComponent(lat) + "&" +
                    "lon=" + encodeURIComponent(lon);

                fetch(url)
                    .then(function(response) {
                        return response.text();
                    })
                    .then(function(data) {
                        console.log(data);
                        if (data !== "0"){
                            alert(data);
                            return;
                        }
                        window.location.reload();
                    })
                    .catch(function() {
                        console.log("ERROR");
                    });

            });
        }
        else {
            alert("Enable your location to continue!");
        }
    }
    function cancel(id) {
        let url = "/boom-truck/cancel?" +
            "id=" + encodeURIComponent(id);
        fetch(url)
            .then(function(response) {
                return response.text();
            })
            .then(function(data) {
                console.log(data);
                if (data !== "0"){
                    alert(data);
                    return;
                }
                alert(data);
                window.location.reload();
            })
            .catch(function() {
                console.log("ERROR");
            });

    }
    function complete(id) {
        let url = "/boom-truck/complete?" +
            "id=" + encodeURIComponent(id);
        fetch(url)
            .then(function(response) {
                return response.text();
            })
            .then(function(data) {
                console.log(data);
                if (data !== "0"){
                    alert(data);
                    return;
                }
                window.location.reload();
            })
            .catch(function() {
                console.log("ERROR");
            });

    }
    function track(id) {

        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (location) {
                lat = location.coords.latitude;
                lon = location.coords.longitude;

                let url = "/boom-truck/track?" +
                    "id=" + encodeURIComponent(id);
                fetch(url)
                    .then(function(response) {
                        return response.text();
                    })
                    .then(function(data) {
                        if (data.startsWith("0")){
                            let modal = new bootstrap.Modal(document.getElementById("trackModal"), {});
                            let a = data.split(" ");
                            console.log(data);
                            const marker = new google.maps.Marker({
                                position: {lat : lat, lng : lon},
                                map: map2,
                                label: "Your location"
                            });
                            const marker2 = new google.maps.Marker({
                                position: {lat : parseFloat(a[2]), lng : parseFloat(a[3])},
                                map: map2,
                                label: a[1] + " location"
                            });
                            modal.show();
                        }else {
                            show_toast(data);
                        }


                    })
                    .catch(function(e) {
                        console.log(e + "ERROR");
                    });


            });
        } else {
            alert("Please enable your location!");
        }


    }
    function update_my_location() {

        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (location) {
                lat = location.coords.latitude;
                lon = location.coords.longitude;
                let url = "/boom-truck/update-location?" +
                    "lat=" + encodeURIComponent(lat) + "&" +
                    "lon=" + encodeURIComponent(lon)
                ;
                fetch(url)
                    .then(function(response) {
                        return response.text();
                    })
                    .then(function(data) {
                        if (data !== "0"){
                            alert(data);
                            return;
                        }
                        show_toast("Your location was updated!");
                    })
                    .catch(function() {
                        console.log("ERROR");
                    });
            });
        } else {
            alert("Please allow location access!");
        }



    }
    function details(id) {
        let url = "/boom-truck/info?" +
            "id=" + encodeURIComponent(id);
        fetch(url)
            .then(function(response) {
                return response.text();
            })
            .then(function(data) {
                let modal = new bootstrap.Modal(document.getElementById("detailsModal"), {});
                document.getElementById("detail-body").innerHTML = data;
                modal.show();
            })
            .catch(function(e) {
                console.log(e + "ERROR");
            });

    }
    function approve(id) {
        let url = "/boom-truck/approve?" +
            "id=" + encodeURIComponent(id);
        fetch(url)
            .then(function(response) {
                return response.text();
            })
            .then(function(data) {
                console.log(data);
                if (data !== "0"){
                    alert(data);
                    return;
                }
                show_toast("Boom session was accepted!");
                window.location.reload();
            })
            .catch(function() {
                console.log("ERROR");
            });

    }

    function save_driver_details() {
        if (lat == null || lon == null){
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(function (location) {
                    lat = location.coords.latitude;
                    lon = location.coords.longitude;
                    save_driver_details();
                });
            }else {
                alert("Allow location access to continue!");
                save_driver_details();
            }
            return;
        }

        let vehicle = document.getElementById("d_vehicle").value;
        let licence = document.getElementById("d_license").value;
        let price = document.getElementById("d_price").value;

        let url = "/boom-truck/update?" +
            "vehicle=" + encodeURIComponent(vehicle) + "&" +
            "licence=" + encodeURIComponent(licence) + "&" +
            "price=" + encodeURIComponent(price) + "&" +
            "lat=" + encodeURIComponent(lat) + "&" +
            "lon=" + encodeURIComponent(lon);
        fetch(url)
            .then(function(response) {
                return response.text();
            })
            .then(function(data) {
                console.log(data);
                if (data === "0"){
                    window.location.reload();
                    return;
                }
                alert(data);
            })
            .catch(function() {
                console.log("ERROR");
            });
    }

    // Initialize and add the map

    function initMap() {
        // The location of Sri lanka
        const lanka = { lat: 7.8731, lng: 80.7718 };

        map = new google.maps.Map(document.getElementById("map"), {
            zoom: 6,
            center: lanka,
        });

        map2 = new google.maps.Map(document.getElementById("map-track"), {
            zoom: 6,
            center: lanka,
        });
        // The marker, positioned at Uluru

    }

    window.initMap = initMap;

    check_location_access();


</script>

</body>
</html>
