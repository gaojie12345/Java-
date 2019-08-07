<%--
  Created by IntelliJ IDEA.
  User: 高杰
  Date: 2019/8/7
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" align="center" width="100%">
    <tr>
        <th>UserId</th>
        <th>UserName</th>
        <td>UserAddr</td>
    </tr>
    <c:forEach items="${userListKey}" var="user">
        <tr>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.userAddr}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>