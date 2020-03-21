<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/03/19
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="../../res/bootstrap-3.3.7.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="i">
        <tr>
            <td>${i.id}</td>
            <td>${i.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
