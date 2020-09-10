<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>Test</title>
    <style>
        div {text-align: center;
            font-family: "Courier New", Courier, monospace;margin-top: 5%}
        #data {margin-top: 5%}
    </style>
</head>
<body>
<div>
    <h4>Your test data has been added to the database.</h4>
    <div id="data">
        <a href="${pageContext.request.contextPath}/">Return to the main page</a>
        <br />
        <br />
        <a href="${pageContext.request.contextPath}/products/all">Take a look at our products!</a>
        <br />
        <br />
        <a href="${pageContext.request.contextPath}/users/all">See a list of our clients</a>
    </div>
</div>
</body>
</html>
