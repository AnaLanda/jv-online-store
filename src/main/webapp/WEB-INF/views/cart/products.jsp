<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>Products in shopping cart</title>
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
    <h1>Products in the shopping cart</h1>
    <div id="data">
        <table class="table">
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
                </tr>
            </c:forEach>
        </table>
    </div>
    <hr>
    <br />
    <a href="${pageContext.request.contextPath}/order/complete"><button>complete order</button></a>
    <br />
    <br />
    <a href="${pageContext.request.contextPath}/products/all">Add more items to your cart!</a>
    <br />
    <br />
    <a href="${pageContext.request.contextPath}/orders/all">See your orders</a>
    <br />
    <br />
    <a href="${pageContext.request.contextPath}/">Return to the main page</a>
</div>
</body>
</html>
