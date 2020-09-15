<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../style.jsp"%>
<html>
<head>
    <title>Users</title>
</head>
<body>
<div>
    <h1>Registered users</h1>
    <div class="text">
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
    <div class="text">
        <a href="${pageContext.request.contextPath}/"><button>main page</button></a>
    </div>
</div>
</body>
</html>
