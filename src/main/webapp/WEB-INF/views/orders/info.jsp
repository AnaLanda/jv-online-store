<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <style>
        body {background: url(https://images.unsplash.com/photo-1539438286255-f600677a2d34?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80);
            background-size: cover;
            background-position: center;}
        div {text-align: center;
            font-family: "Courier New", Courier, monospace;
            margin-top: 5%;}
        .text {margin-top: 5%;
            margin-left: 20%;
            width: 60%;
            background: transparent;
            font-size: 1.3rem;
            font-weight: 450;}
    </style>
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
                        <c:out value="${product.price}"/>
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
