<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div {text-align: center;}
    </style>
</head>
<body>
<div>
    <h1>Welcome to our store!</h1>
    <a href="${pageContext.request.contextPath}/inject-data">Enter test data into the database</a>
    <br />
    <br />
    <a href="${pageContext.request.contextPath}/products/all">Take a look at our products!</a>
    <br />
    <br />
    <a href="${pageContext.request.contextPath}/users/all">See a list of our clients</a>
    <br />
    <br />
    <a href="${pageContext.request.contextPath}/registration">Register</a>
</div>
</body>
</html>
