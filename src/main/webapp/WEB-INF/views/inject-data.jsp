<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="style.jsp"%>
<html>
<head>
    <title>Test</title>
</head>
<body>
<div>
    <h3>Your test data has been added to the database.</h3>
    <div class="text">
        <a href="${pageContext.request.contextPath}/products/all">Take a look at our products!</a>
    </div>
    <div class="text">
        <a href="${pageContext.request.contextPath}/"><button>main page</button></a>
    </div>
    </div>
</div>
</body>
</html>
