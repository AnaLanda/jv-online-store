<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <style>
        div {text-align: center;}
    </style>
</head>
<body>
<div>
    <h1>Your test data has been added to the database.</h1>
    <a href="${pageContext.request.contextPath}/">Return to the main page</a>
    <br />
    <br />
    <a href="${pageContext.request.contextPath}/products/all">Take a look at our products!</a>
    <br />
    <br />
    <a href="${pageContext.request.contextPath}/users/all">See a list of our clients</a>
</div>
</body>
</html>
