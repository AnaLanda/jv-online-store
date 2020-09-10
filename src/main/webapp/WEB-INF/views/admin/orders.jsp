<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <style>
        div {text-align: center;}
        table {margin-left: auto; margin-right: auto;}
    </style>
</head>
<body>
<div>
    <h1>All orders placed at the shop</h1>
    <div>
        <table border="1">
            <tr>
                <th>Order ID</th>
                <th>User ID</th>
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
                        <a href="${pageContext.request.contextPath}/admin/orders/delete?id=${order.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
