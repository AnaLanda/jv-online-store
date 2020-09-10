<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <style>
        div {text-align: center;
            font-family: "Courier New", Courier, monospace;
            margin-top: 5%}
        table {margin-left: auto;
            margin-right: auto}
        .text {margin-top: 5%;
            margin-left: 20%;
            width: 60%;
            background: transparent;
            font-size: 1.3rem;
            font-weight: 450;}
    </style>
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
                        <c:out value="${product.price} UAH"/>
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
