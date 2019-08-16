<%@ page import="java.util.List" %>
<%@ page import="com.qing.vo.Items" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>--%>
<html>
<head>
    <title>ShowItemsPageInformation</title>
</head>
<body>

<table border="1" width="100%" align="center">
    <tr>
        <th>ItemsID</th>
        <th>ItemsName</th>
        <th>ItemsPrice</th>
        <%--<td>ItemsCreateTime</td>--%>
    </tr>

    <%
        List<Items> itemsList = (List<Items>) request.getAttribute("itemsListKey");
        for (Iterator it = itemsList.iterator();it.hasNext();) {
            Items items = (Items) it.next();
    %>
    <tr>
        <td>
            <%=items.getItemId()%>
        </td>
        <td>
            <%=items.getItemsName()%>
        </td>
        <td>
            <%=items.getItemsPrice()%>
        </td>
        <td>
        </td>
    </tr>

    <%}%>

    <%--<c:forEach items="${itemsListKey}" var="itemsVar">
        <tr>
            <td>${itemsVar.itemsId}</td>
            <td>${itemsVar.itemsName}</td>
            <td>${itemsVar.itemsPrice}</td>
        </tr>
    </c:forEach>--%>
</table>

</body>
</html>
