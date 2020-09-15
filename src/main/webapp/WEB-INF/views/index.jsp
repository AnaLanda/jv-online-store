<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="style.jsp"%>
<html>
<head>
    <title>Shop</title>
</head>
<body>
<div>
    <h1>Welcome to our store!</h1>
    <div class="text">
        <a href="${pageContext.request.contextPath}/inject-data">Enter test data into the database</a>
        <br />
        <br />
        <a href="${pageContext.request.contextPath}/products/all">Take a look at our products!</a>
        <div>
            <a href="${pageContext.request.contextPath}/logout"><button>logout</button></a>
        </div>
    </div>
</div>
</body>
</html>
