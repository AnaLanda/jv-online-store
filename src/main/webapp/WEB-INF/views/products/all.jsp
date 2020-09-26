<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp"%>
<html>
<head>
    <title>Products</title>
</head>
<body>
<div>
    <h1>Products</h1>
    <div class="text">
        <table class="table">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
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
                        <c:out value="${product.price} USD"/>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/cart/products/add?id=${product.id}">buy</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <hr>
        </div>
    <br />
    </div>
</div>
</body>
</html>
