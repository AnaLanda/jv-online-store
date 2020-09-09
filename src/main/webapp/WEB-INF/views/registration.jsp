<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <style>
        div {text-align: center;}
    </style>
</head>
<body>
<div>
    <h1>Please enter your user details here if you'd like to buy something from our store.</h1>
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
</body>
</html>
