<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>

      <title>Mechanic</title>
        <%@ include file="../imports.jspf" %>

    </head>

    <body>

        <c:set var="title" value="Register as mechanic"/>
        <%@ include file="../navigation bar.jspf" %>
        <div class="py-5"></div>

        <div class="container-fluid">
            <div class="row d-flex justify-content-center">
                <div class="col-sm-12 col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <form action="/mechanic/add_mechanic" method="post">

                                <div class="mb-3">
                                    <label class="form-label">Mechanic Name</label>
                                    <input class="form-control" name="m_name" type="text">
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Mechanic Type</label>
                                    <select class="form-select" name="type">
                                        <option value="engine" >Engine</option>
                                        <option value="Brake and Transmission">Brake and Transmission</option>
                                        <option value="Body Refinishing">Body Refinishing</option>
                                        <option value="Electrician">Electrician</option>
                                        <option value="Auto vehicle Repair">Auto vehicle Repair</option>
                                        <option value="Heavy Duty vehicle Repair">Heavy Duty vehicle Repair</option>
                                    </select>

                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Latitude</label>
                                    <input class="form-control" type="number" id="latitude" step="any" name="latitude">
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Longitude</label>
                                    <input class="form-control" type="number" id="longitude" step="any" name="longitude">
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Hiring Price(Rs.)</label>
                                    <input class="form-control" type="number" id="price" min="0.00" step="0.01" name="price">
                                </div>

                                <div class="row">
                                    <div class="col">
                                        <input class="btn btn-success" type="submit" value="Add"><br>
                                    </div>
                                    <div class="col">
                                        <a href="/mechanic/search_page"
                                           class="btn btn-success" type="submit" >Search</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>


                </div>
            </div>


        </div>



    </body>

    </html>
