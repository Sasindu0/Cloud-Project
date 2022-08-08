<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Profile</title>
    <%@ include file="../../imports.jspf" %>
    <style>
        body{
            margin-top:20px;
            color: #1a202c;
            text-align: left;
            background-color: #e2e8f0;
        }
        .main-body {
            padding: 15px;
        }
        .card {
            box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);
        }

        .card {
            position: relative;
            display: flex;
            flex-direction: column;
            min-width: 0;
            word-wrap: break-word;
            background-color: #fff;
            background-clip: border-box;
            border: 0 solid rgba(0,0,0,.125);
            border-radius: .25rem;
        }

        .card-body {
            flex: 1 1 auto;
            min-height: 1px;
            padding: 1rem;
        }

        .gutters-sm {
            margin-right: -8px;
            margin-left: -8px;
        }

        .gutters-sm>.col, .gutters-sm>[class*=col-] {
            padding-right: 8px;
            padding-left: 8px;
        }
        .mb-3, .my-3 {
            margin-bottom: 1rem!important;
        }

        .bg-gray-300 {
            background-color: #e2e8f0;
        }
        .h-100 {
            height: 100%!important;
        }
        .shadow-none {
            box-shadow: none!important;
        }
    </style>
    <style>
        body{
            background:#eee;
        }
        .widget-author {
            margin-bottom: 58px;
        }
        .author-card {
            position: relative;
            padding-bottom: 48px;
            background-color: #fff;
            box-shadow: 0 12px 20px 1px rgba(64, 64, 64, .09);
        }
        .author-card .author-card-cover {
            position: relative;
            width: 100%;
            height: 100px;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
        .author-card .author-card-cover::after {
            display: block;
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            content: '';
            opacity: 0.5;
        }
        .author-card .author-card-cover > .btn {
            position: absolute;
            top: 12px;
            right: 12px;
            padding: 0 10px;
        }
        .author-card .author-card-profile {
            display: table;
            position: relative;
            margin-top: -22px;
            padding-right: 15px;
            padding-bottom: 16px;
            padding-left: 20px;
            z-index: 5;
        }
        .author-card .author-card-profile .author-card-avatar, .author-card .author-card-profile .author-card-details {
            display: table-cell;
            vertical-align: middle;
        }
        .author-card .author-card-profile .author-card-avatar {
            width: 85px;
            border-radius: 50%;
            box-shadow: 0 8px 20px 0 rgba(0, 0, 0, .15);
            overflow: hidden;
        }
        .author-card .author-card-profile .author-card-avatar > img {
            display: block;
            width: 100%;
        }
        .author-card .author-card-profile .author-card-details {
            padding-top: 20px;
            padding-left: 15px;
        }
        .author-card .author-card-profile .author-card-name {
            margin-bottom: 2px;
            font-size: 14px;
            font-weight: bold;
        }
        .author-card .author-card-profile .author-card-position {
            display: block;
            color: #8c8c8c;
            font-size: 12px;
            font-weight: 600;
        }
        .author-card .author-card-info {
            margin-bottom: 0;
            padding: 0 25px;
            font-size: 13px;
        }
        .author-card .author-card-social-bar-wrap {
            position: absolute;
            bottom: -18px;
            left: 0;
            width: 100%;
        }
        .author-card .author-card-social-bar-wrap .author-card-social-bar {
            display: table;
            margin: auto;
            background-color: #fff;
            box-shadow: 0 12px 20px 1px rgba(64, 64, 64, .11);
        }
        .btn-style-1.btn-white {
            background-color: #fff;
        }
        .list-group-item i {
            display: inline-block;
            margin-top: -1px;
            margin-right: 8px;
            font-size: 1.2em;
            vertical-align: middle;
        }
        .mr-1, .mx-1 {
            margin-right: .25rem !important;
        }

        .list-group-item.active:not(.disabled) {
            border-color: #e7e7e7;
            background: #fff;
            color: #ac32e4;
            cursor: default;
            pointer-events: none;
        }
        .list-group-flush:last-child .list-group-item:last-child {
            border-bottom: 0;
        }

        .list-group-flush .list-group-item {
            border-right: 0 !important;
            border-left: 0 !important;
        }

        .list-group-flush .list-group-item {
            border-right: 0;
            border-left: 0;
            border-radius: 0;
        }
        .list-group-item.active {
            z-index: 2;
            color: #fff;
            background-color: #007bff;
            border-color: #007bff;
        }
        .list-group-item:last-child {
            margin-bottom: 0;
            border-bottom-right-radius: .25rem;
            border-bottom-left-radius: .25rem;
        }
        a.list-group-item, .list-group-item-action {
            color: #404040;
            font-weight: 600;
        }
        .list-group-item {
            padding-top: 16px;
            padding-bottom: 16px;
            -webkit-transition: all .3s;
            transition: all .3s;
            border: 1px solid #e7e7e7 !important;
            border-radius: 0 !important;
            color: #404040;
            font-size: 12px;
            font-weight: 600;
            letter-spacing: .08em;
            text-transform: uppercase;
            text-decoration: none;
        }
        .list-group-item {
            position: relative;
            display: block;
            padding: .75rem 1.25rem;
            margin-bottom: -1px;
            background-color: #fff;
            border: 1px solid rgba(0,0,0,0.125);
        }
        .list-group-item.active:not(.disabled)::before {
            background-color: #ac32e4;
        }

        .list-group-item::before {
            display: block;
            position: absolute;
            top: 0;
            left: 0;
            width: 3px;
            height: 100%;
            background-color: transparent;
            content: '';
        }
    </style>
</head>
<body>

<c:set var="title" value="Your profile"/>
<%@include file="../../navigation bar.jspf"%>
<div class="py-4"></div>

<div class="container">
    <div class="main-body">
        <div class="row gutters-sm">
            <div class="col-md-4 mb-3">

                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center">
                            <div class="row">
                                <div class="col-1">
                                    <a class="btn border border-0" href="/">
                                        <i class="fa fa-home"></i>
                                    </a>
                                </div>
                                <div class="col-11">
                                    <img src="${login.base64Img}" alt="Admin" class="rounded-circle" width="150">
                                </div>


                            </div>

                            <div class="mt-3">
                                <h4>${login.name}</h4>
                                <p class="text-secondary mb-1">${login.username}</p>
                                <button type="button" onclick="on_section_selected('section-change-picture')"
                                        class="btn btn-outline-primary">
                                    Change picture
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card mt-3">
                    <div class="wizard">
                        <nav class="list-group list-group-flush">

                            <a class="list-group-item active" id="section-profile-details"
                               onclick="on_section_selected('section-profile-details')">
                                <i class="fa fa-male text-muted"></i>
                                Profile details
                            </a>

                            <a class="list-group-item" id="section-profile-edit"
                               onclick="on_section_selected('section-profile-edit')">
                                <i class="fa fa-pencil text-muted"></i>
                                Edit profile
                            </a>

                            <a class="list-group-item active" id="section-change-picture"
                               onclick="on_section_selected('section-change-picture')">
                                <i class="fa fa-image text-muted"></i>
                                Profile picture
                            </a>


                        </nav>
                    </div>
                </div>

            </div>
            <div class="col-md-8">

                <div class="card mb-3" id="profile-view">
                    <div class="card-body">

                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">User name</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${login.username}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Full Name</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${login.name}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Age</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${login.age}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Email</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${login.email}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Phone</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${login.mobileNumber}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Account type</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${login.accountType}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Address</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${login.address}
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-10"></div>
                            <div class="col-sm-2 pt-3 pb-0">
                                <a class="btn btn-info " onclick="on_section_selected('section-profile-edit')">
                                    <i class="fa fa-pencil px-2"></i>
                                    Edit
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card mb-3" id="profile-edit">
                    <form class="card-body" action="/profile/update" method="post">

                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">User name</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <input type="text" class="form-control" placeholder=""
                                       value="${login.username}" id="code" required disabled>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Full Name</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <input type="text" class="form-control"
                                       placeholder="Enter your full name" value="${login.name}"
                                       id="full_name" name="full_name">
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Age</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <input type="number" min="12" max="99" class="form-control"
                                       placeholder="Enter your full name" value="${login.age}" id="age" name="age">
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Email</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <input type="email" class="form-control" placeholder="Enter your email"
                                       value="${login.email}" id="email" name="email">
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Phone</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <input type="text" class="form-control" placeholder="Enter your phone number" value="${login.mobileNumber}" id="phone" name="phone">
                            </div>
                        </div>
                        <hr>

                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Address</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <input type="text" class="form-control"
                                       placeholder="Enter your birthday" value="${login.address}" id="address"
                                       name="address">
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-10">
                            </div>
                            <div class="col-sm-2 pt-3 pb-0">
                                <button class="btn btn-info" type="submit">
                                    <i class="fa fa-save px-2"></i>
                                    Save
                                </button>
                            </div>
                        </div>

                    </form>
                </div>


                <div class="card mb-3" id="profile-picture">
                    <div class="card-body">

                        <div class="row">
                            <div class="col">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex flex-column align-items-center text-center">
                                            <div class="m-1">
                                                <h4>Current picture</h4>
                                            </div>
                                            <img src="${login.base64Img}" alt="Picture"
                                                 class="rounded-circle" width="150">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex flex-column align-items-center text-center">
                                            <div class="m-1">
                                                <h4>New picture</h4>
                                            </div>
                                            <img id="new-profile-img" src="${login.base64Img}" alt="Profile"
                                                 class="img-fluid rounded-circle" width="150">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="py-2"></div>

                        <form action="/profile/upload" method="post" enctype="multipart/form-data">
                            <div class="row justify-content-center">
                                <div class="col-sm-3">
                                    <label for="select" class="btn btn-outline-primary">Change picture</label>
                                    <input id="select" type="file" accept=".jpeg, .png, .jpg" onchange="previewFile()"
                                           hidden name="image">
                                </div>
                            </div>
                            <div class="py-1"></div>
                            <div class="row justify-content-center">
                                <div class="col-sm-3">
                                    <button  type="submit" class="btn btn-outline-primary" >
                                        Save picture
                                    </button>
                                </div>
                            </div>
                            <div class="py-2"></div>
                        </form>


                        <div id="select-icon">


                        </div>


                    </div>
                </div>

            </div>


        </div>

    </div>
</div>

<%--Chabge profile picture--%>
<script>
    let video = document.querySelector("#video");
    let click_button = document.querySelector("#click-photo");
    let canvas = document.querySelector("#canvas");


    click_button.addEventListener('click', function() {
        canvas.getContext('2d').drawImage(video, 0, 0, canvas.width, canvas.height);
        let image_data_url = canvas.toDataURL('image/jpeg');

        // data url of the image
        console.log(image_data_url);
    });


    function previewFile() {
        let preview = document.getElementById('new-profile-img');
        let file    = document.getElementById('select').files[0];
        let reader  = new FileReader();

        reader.onloadend = function () {
            preview.src = reader.result;
        }

        if (file) {
            reader.readAsDataURL(file);
        }
        else {
            // preview.src = "";
        }
    }
</script>

<%--Selection--%>
<script>
    let selected = "section-profile-details";
    let selection_names = ["section-profile-details", "section-profile-edit",
        "section-change-picture" ];
    let selection_contents = ["profile-view", "profile-edit", "profile-picture"];

    on_section_selected("section-profile-details");

    function on_section_selected(id) {

        selected = id;

        for (let i = 0; i < selection_names.length; i++){
            const x = selection_names[i];
            let y = document.getElementById(x);
            let z = document.getElementById(selection_contents[i]);

            if (x === selected){
                y.classList.add("active");
                z.style.display = "block";
            }else {
                y.classList.remove("active");
                z.style.display = "none";
            }
        }

    }


</script>

<%--Apply for--%>
<script>

    let radios = document.getElementsByName("profession-type");

    document.getElementById("radio-volunteer").checked = true;
    toggle("volunteer-apply", true);
    toggle("professional-apply", false);
    toggle("admin-apply", false);


    for (const radio of radios) {

        radio.addEventListener('change', function() {
            if (this.checked) {
                if (this.id === "radio-volunteer"){
                    toggle("volunteer-apply", true);
                    toggle("professional-apply", false);
                    toggle("admin-apply", false);
                }
                else if (this.id === "radio-professional"){
                    toggle("volunteer-apply", false);
                    toggle("professional-apply", true);
                    toggle("admin-apply", false);
                }
                else if (this.id === "radio-admin"){
                    toggle("volunteer-apply", false);
                    toggle("professional-apply", false);
                    toggle("admin-apply", true);
                }
            }
        });
    }

    function toggle(id, show) {
        let x = document.getElementById(id);
        if (show){
            x.style.display = "block";
        }else {
            x.style.display = "none";
        }
    }

</script>

<%--Profile picture--%>
<script>
    function selected_picture(img) {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/profile/save-picture-confirm");
        xhr.onload = function(event){
            let response = event.target.response;
            let a = document.getElementById("select-icon");
            a.innerHTML = response;
        };

        let formData = new FormData();
        formData.append("image", img);
        xhr.send(formData);
        location.reload();

    }


</script>

</body>
</html>