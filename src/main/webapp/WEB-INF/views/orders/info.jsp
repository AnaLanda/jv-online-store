<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order details</title>
    <style>
        div {text-align: center;}
        table {margin-left: auto; margin-right: auto;}
    </style>
</head>
<body>
<div>
    <h1>Order details</h1>
    <div>
        <table border="1">
            <tr>
                <th>ID</th>
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
</div>
</body>
</html>
