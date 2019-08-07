<%--
  Created by IntelliJ IDEA.
  User: 高杰
  Date: 2019/8/7
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>duixaing</title>
</head>
<body>

<%
    pageContext.setAttribute("ab","a");
    request.setAttribute("ab","b");
    session.setAttribute("ab","c");
    application.setAttribute("ab","d");
%>
EL:<br>
${ab}
</body>
</html>
