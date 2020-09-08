<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Please enter your user details here if you'd like to buy something from our store.</h1>
<form method="post" action="${pageContext.request.contextPath}/registration">
    login: <input type="text" name="login">
    password: <input type="text" name="password">
    <button type="submit">register</button>
</form>
</body>
</html>
