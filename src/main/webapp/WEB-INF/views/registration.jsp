<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Please enter your user details here if you'd like to buy something from our store.</h1>
<h4 style="color:red">${message}</h4>
<form method="post" action="${pageContext.request.contextPath}/registration">
    login: <input type="text" name="login">
    password: <input type="password" name="pwd">
    please, repeat your password: <input type="password" name="pwd-repeat">
    <button type="submit">register</button>
</form>
</body>
</html>
