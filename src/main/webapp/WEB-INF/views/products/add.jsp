<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>Add Product</title>
    <style>
        div {text-align: center;
            font-family: "Courier New", Courier, monospace;
            margin-top: 5%}
        input {width: 20%}
        .text {margin-top: 5%}
    </style>
</head>
<body>
<div>
    <h1>Please enter the details of the product you'd like to add to our store.</h1>
    <div class="text">
        <form method="post" action="${pageContext.request.contextPath}/products/add">
            name: <input type="text" required="required" name="name">
            price: <input type="number" required="required" name="price">
            <button type="submit">add</button>
        </form>
        <br>
        <a href="${pageContext.request.contextPath}/products/admin">See all products</a>
    </div>
</div>
</body>
</html>
