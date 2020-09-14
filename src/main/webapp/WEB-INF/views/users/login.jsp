<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <style>
        body {background: url(https://images.unsplash.com/photo-1573828718637-233537e3b9e2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1534&q=80);
            background-size: cover;
            background-position: center;}
        div {text-align: center;
            font-family: "Courier New", Courier, monospace;
            margin-top: 5%;}
        input {width: 10%}
        .text {margin-top: 5%;
            background: transparent;
            font-size: 1.3rem;
            font-weight: 450;}
    </style>
    <title>Login</title>
</head>
<body>
<div>
    <h1>Login</h1>
    <form method="post" action="${pageContext.request.contextPath}/login">
        login: <input type="text" required="required" name="login">
        password: <input type="password" required="required" name="pwd">
        <button type="submit">login</button>
    </form>
</div>
</body>
</html>
