<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../style.jsp"%>
<html>
<head>
    <title>Order details</title>
</head>
<body>
<div>
    <h1>Order details</h1>
    <div class="text">
        <table class="table">
            <tr>
                <th>ID</th>
                <th></th>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>
                        <c:out value="${product.id}"/>
                    </td>
                    <td>
                        <c:out value="${product.name}"/>
                    </td>
                    <td>
                        <c:out value="${product.price} UAH"/>
                </tr>
            </c:forEach>
        </table>
    </div>
    <hr>
    <div class="text">
        <a href="${pageContext.request.contextPath}/"><button>main page</button></a>
    </div>
</div>
</body>
</html>
