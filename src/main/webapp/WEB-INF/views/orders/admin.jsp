<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>Admin Orders</title>
    <style>
        div {text-align: center;
            font-family: "Courier New", Courier, monospace;
            margin-top: 5%}
        table {margin-left: auto;
            margin-right: auto;
            width: 60%;}
        #data {margin-top: 5%}
    </style>
</head>
<body>
<div>
    <h1>Orders placed at the shop</h1>
    <div id="data">
        <table class="table">
            <tr>
                <th>ID</th>
                <th>User ID</th>
                <th></th>
                <th></th>
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
                        <a href="${pageContext.request.contextPath}/orders/admin/delete?id=${order.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <hr>
    <br />
    <br />
    <a href="${pageContext.request.contextPath}/">Return to the main page</a>
</div>
</body>
</html>
