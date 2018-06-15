<%--
  Created by IntelliJ IDEA.
  User: tosiak
  Date: 05.06.18
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Currencies</title>
</head>
<body>
<%@include file="../header.jsp" %>
<form action="/remove" method="post">
    <table class="center">
        <tr>
            <th class="tg-yw4l">Name</th>
            <th class="tg-yw4l">Short name</th>
            <th class="tg-yw4l">Symbol</th>
        </tr>
        <c:forEach items="${currencies}" var="currency">
            <tr>
                <td class="tg-yw4l">${currency.name}</td>
                <td class="tg-yw4l">${currency.shortName}</td>
                <td class="tg-yw4l">${currency.symbol}</td>
                <td class="tg-yw4l"><button type="submit" name="close" value="${currency.id}">Remove</button></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/add-currency">Add new currency</a>
    <%@include file="../footer.jsp" %>
</form>
</body>
</html>
