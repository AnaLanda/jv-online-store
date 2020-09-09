<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products in shopping cart</title>
    <style>
        div {text-align: center;}
        table {margin-left: auto; margin-right: auto;}
    </style>
</head>
<body>
<div>
    <h1>Products in the shopping cart</h1>
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
                        <c:out value="${product.price}"/>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/cart/delete?id=${product.id}">remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br />
    <br />
    <a href="${pageContext.request.contextPath}/products/all">Add more items to your cart!</a>
    <br />
    <br />
    <a href="${pageContext.request.contextPath}/">Return to the main page</a>
</div>
</body>
</html>
