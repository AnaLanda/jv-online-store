<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../style.jsp"%>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<div>
    <h1>Your orders</h1>
    <div class="text">
        <table class="table">
            <tr>
                <th>ID</th>
                <th></th>
            </tr>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>
                        <c:out value="${order.id}"/>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/orders/info?id=${order.id}">details</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <hr>
</div>
<div class="text">
    <a href="${pageContext.request.contextPath}/"><button>main page</button></a>
</div>
</body>
</html>
