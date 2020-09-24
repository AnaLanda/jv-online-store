<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <h1>Login</h1>
    <h4 style="color:#a9220e">${errorMessage}</h4>
    <form method="post" action="${pageContext.request.contextPath}/login">
        login: <input type="text" required="required" name="login">
        password: <input type="password" required="required" name="pwd">
        <button type="submit">login</button>
    </form>
</div>
</body>
</html>
