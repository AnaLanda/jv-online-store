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
            background: transparent;
            font-size: 1.3rem;
            font-weight: 450;}
    </style>
    <title>Registration</title>
</head>
<body>
<div>
    <h5>Please enter your user details here if you'd like to buy something from our store.</h5>
    <div class="text">
        <h4 style="color:#a9220e">${message}</h4>
        <form method="post" action="${pageContext.request.contextPath}/registration">
            name: <input type="text" required="required" name="name">
            login: <input type="text" required="required" name="login">
            password: <input type="password" required="required" name="pwd">
            confirm your password: <input type="password" required="required" name="pwd-repeat">
            <button type="submit">register</button>
        </form>
        <div>
            <a href="${pageContext.request.contextPath}/"><button>main page</button></a>
        </div>
    </div>
</div>
</body>
</html>
