<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script crossorigin="anonymous"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script crossorigin="anonymous"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
    body {background: url(https://images.unsplash.com/photo-1573828718637-233537e3b9e2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1534&q=80);
        background-size: cover;
        background-position: center;}
    div {text-align: center;
        font-family: "Courier New", Courier, monospace;}
    h1 {margin-top: 5%;}
    h3 {margin-top: 3%;}
    h4 {padding-top: 4%;}
    input {width: 300px;}
    #registration{
        margin-top: 5%;
        margin-right: 50%;
        width: 80%;}
    .center {margin-right: 20%;}
    .right {text-align: right}
    .text {margin-top: 5%;
        margin-left: 20%;
        width: 60%;
        background: transparent;
        font-weight: 450;}
</style>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="mx-auto order-0">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/inject-data">Inject Data</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/products/all">Products</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/cart/products">Shopping Cart</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/orders/all">My Orders</a>
            </li>
        </ul>
    </div>
    <div class="navbar-collapse collapse w-100 order-2 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/products/admin">Edit Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/users/all">Edit Users</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/orders/admin">Edit Orders</a>
            </li>
        </ul>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
                <button type="button" class="btn btn-dark"><a class="nav-link" href="${pageContext.request.contextPath}/login">Sign In</a></button>
            </li>
            <li class="nav-item active">
                <button type="button" class="btn btn-dark"><a class="nav-link" href="${pageContext.request.contextPath}/registration">Sign Up</a></button>
            </li>
            <li class="nav-item active">
                <button type="button" class="btn btn-dark"><a class="nav-link" href="${pageContext.request.contextPath}/logout">Log Out</a></button>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>
