<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp"%>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<div>
    <h3>Please enter the details of the product you'd like to add to our store.</h3>
    <div id="registration" class="right">
        <form method="post" action="${pageContext.request.contextPath}/products/add">
            name: <input type="text" required="required" name="name">
            price: <input type="number" required="required" name="price">
            <button type="submit">add</button>
        </form>
    </div>
    <div class="text">
        <a href="${pageContext.request.contextPath}/products/admin">See all products</a>
    </div>
</div>
</body>
</html>
