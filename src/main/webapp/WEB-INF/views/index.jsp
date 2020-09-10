<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>Title</title>
    <style>
        div {text-align: center;
            font-family: "Courier New", Courier, monospace;
            margin-top: 5%}
        #data {margin-top: 5%}
    </style>
</head>
<body>
<div>
    <h1>Welcome to our store!</h1>
    <div id="data">
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
</div>
</body>
</html>
