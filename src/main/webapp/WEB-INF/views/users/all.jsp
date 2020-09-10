<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>Users</title>
    <style>
        div {text-align: center;
            font-family: "Courier New", Courier, monospace;
            margin-top: 5%}
        #data {margin-top: 5%}
    </style>
</head>
<body>
<div>
    <h1>Registered users</h1>
    <div id="data">
        <table class="table">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Login</th>
                <th></th>
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
