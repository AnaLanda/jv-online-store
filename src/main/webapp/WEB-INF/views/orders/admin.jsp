<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp"%>
<html>
<head>
    <title>Admin Orders</title>
</head>
<body>
<div>
    <h1>Orders placed at the shop</h1>
    <div class="text">
        <table class="table">
            <tr>
                <th>ID</th>
                <th>User ID</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>
                        <c:out value="${order.id}"/>
                    </td>
                    <td>
                        <c:out value="${order.userId}"/>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/orders/info?id=${order.id}">details</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/orders/admin/delete?id=${order.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <hr>
</div>
</body>
</html>
