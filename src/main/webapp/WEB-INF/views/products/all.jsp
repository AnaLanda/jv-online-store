<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <style>
        div {text-align: center;}
        table {margin-left: auto; margin-right: auto;}
    </style>
</head>
<body>
<div>
    <h1>Products</h1>
    <div>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
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
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/shopping-cart/products/buy?id=${product.id}">buy</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br>
    <a href="${pageContext.request.contextPath}/products/add">Add a product</a>
    <br />
    <br />
    <a href="${pageContext.request.contextPath}/shopping-cart/products">View your cart</a>
    <br />
    <h4 style="color:#a9220e">${message}</h4>
    <br />
    <a href="${pageContext.request.contextPath}/">Return to the main page</a>
</div>
</body>
</html>
