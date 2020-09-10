<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <style>
        div {text-align: center;}
        table {margin-left: auto; margin-right: auto;}
    </style>
</head>
<body>
<div>
    <h1>Registered users</h1>
    <div>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Login</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>
                        <c:out value="${user.id}"/>
                    </td>
                    <td>
                        <c:out value="${user.name}"/>
                    </td>
                    <td>
                        <c:out value="${user.login}"/>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/users/delete?id=${user.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br>
    <a href="${pageContext.request.contextPath}/">Return to the main page</a>
</div>
</body>
</html>
