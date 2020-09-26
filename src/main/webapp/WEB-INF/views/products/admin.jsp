<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp"%>
<html>
<head>
    <title>Admin Products</title>
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
                        <a href="${pageContext.request.contextPath}/products/admin/delete?id=${product.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <hr>
    <br>
    <a href="${pageContext.request.contextPath}/products/add">Add a product</a>
</div>
</body>
</html>
