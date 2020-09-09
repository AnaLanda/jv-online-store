<%--
  Created by IntelliJ IDEA.
  User: anastasiamelnyk
  Date: 9/9/20
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
    <style>
        div {text-align: center;}
    </style>
</head>
<body>
<div>
    <h1>Please enter the details of the product you'd like to add to our store.</h1>
    <form method="post" action="${pageContext.request.contextPath}/products/add">
        name: <input type="text" required="required" name="name">
        price: <input type="number" required="required" name="price">
        <button type="submit">add</button>
    </form>
    <a href="${pageContext.request.contextPath}/">Return to the main page</a>
</div>
</body>
</html>