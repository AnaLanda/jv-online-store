<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<div>
    <h3>Please enter your personal details.</h3>
    <div class="text">
        <h4 style="color:#a9220e">${message}</h4>
        <div id="registration" class="right">
            <form method="post" action="${pageContext.request.contextPath}/registration">
                name: <input type="text" required="required" name="name">
                <br \>
                <br \>
                login: <input type="text" required="required" name="login">
                <br \>
                <br \>
                password: <input type="password" required="required" name="pwd">
                <br \>
                <br \>
                confirm your password: <input type="password" required="required" name="pwd-repeat">
                <br \>
                <br \>
                <button type="submit" class="center">register</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
