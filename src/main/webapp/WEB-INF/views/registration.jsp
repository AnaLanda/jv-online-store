<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>Registration</title>
    <style>
        div {text-align: center;
            font-family: "Courier New", Courier, monospace;
            margin-top: 5%}
        #data {margin-top: 5%}
        input {width: 10%}
    </style>
</head>
<body>
<div>
    <h1>Please enter your user details here if you'd like to buy something from our store.</h1>
    <div id="data">
        <h4 style="color:#a9220e">${message}</h4>
        <form method="post" action="${pageContext.request.contextPath}/registration">
            name: <input type="text" required="required" name="name">
            login: <input type="text" required="required" name="login">
            password: <input type="password" required="required" name="pwd">
            confirm your password: <input type="password" required="required" name="pwd-repeat">
            <button type="submit">register</button>
        </form>
        <a href="${pageContext.request.contextPath}/">Return to the main page</a>
    </div>
</div>
</body>
</html>
