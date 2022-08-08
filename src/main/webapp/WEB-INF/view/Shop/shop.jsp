<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>

      <title>Shop</title>

      <link rel="icon" type="image/png"
        href="https://github.com/Sasindu0/Cloud-Resources/blob/main/img/fav.png?raw=true">

      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

      <!-- Bootstrap CSS v5.0.2 -->
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    </head>

    <body data-bs-target=".navbar">

      <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;800;900&display=swap');

        body {
          font-family: "Roboto", sans-serif;
        }

        h1,h2,h3,h4,h5,h6 {
          font-weight: 900 !important;
        }

        .navbar {
          box-shadow: 0 25px 40px rgba(0, 0, 0, 0.2);
          font-size: larger;
        }

        section {
          padding-top: 80px;
          padding-bottom: 80px;
          z-index: 2;
        }

        #reg-ui {
          background-color: rgba(0, 0, 0, 0.6);
          padding: 20px;
          border-radius: 10px;
          margin-top: 70px;
        }

        #reg-ui h2 {
          color: #ECECEC;
          text-align: center;
        }

        #reg-ui .btn-outline-success {
          color: white;
          border-color: white;
        }

        #reg-ui .form-control {
          opacity: 0.8;
        }

        .bg-cover{
                background-image: url(https://github.com/Sasindu0/Cloud-Resources/blob/main/img/background.jpg?raw=true);
                min-height: 100%;
                min-width: 100%;
                background-position: center;
                background-repeat: no-repeat;
                background-size:cover;
                background-attachment: fixed;
        }
      </style>

      <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
        <div class="container">
          <a class="navbar-brand" href="#">
            <img src="https://github.com/Sasindu0/Cloud-Resources/blob/main/img/logo.png?raw=true" alt="" width="64"
              height="64" /> VEHICLE EMERGENCY SERVICE</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">

              <li class="nav-item">
                <form action="/shop/sp_page" method="get">
                  <input type="submit" value="Spare Parts" class="btn btn-light" style="height: auto;width: 150px;">
                </form>
              </li>
              <li class="nav-item">
                <form action="/shop/search_page" method="get">
                  <input type="submit" value="Search Items" class="btn btn-light" style="height: auto;width: 150px;">
                </form>
              </li>
              <li class="nav-item">
                <form action="/shop/profile" method="get">
                  <input type="submit" value="Profile" class="btn btn-light" style="height: auto;width: 100px;">
                </form>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <form action="/shop/add_shops" method="post">
        <section id="shop_sec" class="bg-cover home-section" >
          <div class="container text-white">
            <div class="row">
              <div class="col-lg-3"></div>
              <div class="col-lg-6">
                <div id="reg-ui">

                  <form class="form-group">
                    <h2>SHOP DETAILS
                  </FORM>
                  </h2>
                  
                  <label for="shop_name">Shop Name:</label>
                  <input type="text" id="shop_name" name="shop_name" class="form-control" placeholder="HyperLoop">
                   
                  <div class="row">
                    <div class="col-lg-6">
                      <label for="latitude">Latitiude:</label>
                      <input type="number" id="latitude" step="any" name="latitude" class="form-control"
                        placeholder="82.789304">
                    </div>
                    <div class="col-lg-6">
                      <label for="longitude">Longtitude:</label>
                      <input type="number" id="longitude" step="any" name="longitude" class="form-control"
                        placeholder="8.7325647">
                    </div>
                  </div>
                  <label for="Semail">Shop Email:</label>
                  <input type="email" id="Semail" name="Semail" class="form-control"
                    placeholder="example@gmail.com"><br>
                  <div class="text-center">
                    <input type="submit" value="ADD" class="btn btn-outline-success"
                      style="height: auto;width: 100px;"><br>
                  </div>
      </form>
      </div>
      </div>
      </div>
      </div>
      </section>
      </form>


      <!-- Bootstrap JavaScript Libraries -->
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>

    </body>

    </html>