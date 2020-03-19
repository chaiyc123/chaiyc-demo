<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/03/19
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table align="center" border="1">
        <tr>
            <td>ID</td>
            <td>Name</td>
        </tr>
        <c:forEach items="${students}" var="i">
            <tr>
                <td>${i.id}</td>
                <td>${i.name}</td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
