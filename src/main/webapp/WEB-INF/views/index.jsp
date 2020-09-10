<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <style>
        body {background: url(https://images.unsplash.com/photo-1539438286255-f600677a2d34?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80);
            background-size: cover;
            background-position: center;}
        div {text-align: center;
            font-family: "Courier New", Courier, monospace;
            margin-top: 5%;}
        .text {margin-top: 5%;
            margin-left: 20%;
            width: 60%;
            background: transparent;
            font-size: 1.3rem;
            font-weight: 450;}
        #mock-data {color: #4a4949}
    </style>
    <title>Shop</title>
</head>
<body>
<div>
    <h1>Welcome to our store!</h1>
    <div class="text">
        <a id="mock-data" href="${pageContext.request.contextPath}/inject-data">Enter test data into the database</a>
        <br />
        <br />
        <a href="${pageContext.request.contextPath}/products/all">Take a look at our products!</a>
        <br />
        <br />
        <a href="${pageContext.request.contextPath}/users/all">See a list of our clients</a>
        <div>
            <a href="${pageContext.request.contextPath}/registration"><button>register</button></a>
        </div>
    </div>
</div>
</body>
</html>
