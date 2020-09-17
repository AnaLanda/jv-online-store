<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../style.jsp"%>
<html>
<head>
    <title>Products in shopping cart</title>
</head>
<body>
<div>
    <h1>Products in the shopping cart</h1>
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
                        <c:out value="${product.price} UAH"/>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/cart/products/delete?id=${product.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <hr>
    <div class="text">
        <a href="${pageContext.request.contextPath}/products/all">Add more items to your cart!</a>
        <br \>
        <br \>
        <a href="${pageContext.request.contextPath}/orders/all">See your orders</a>
    </div>
    <div class="text">
        <a href="${pageContext.request.contextPath}/order/complete"><button>complete order</button></a>
    </div>
</div>
</body>
</html>
