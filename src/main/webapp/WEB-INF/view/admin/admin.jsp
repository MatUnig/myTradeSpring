<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>myTrade</title>
</head>
<body>
<%@include file="../header.jsp" %>
<div class="main">
    <table>
        <tr>
            <h1>${gzBuy}</h1>
            <td>Welcome ${firstname}</td>
        </tr>
        <tr>
            <td>Your current balance is ${balance}</td>
            <c:forEach items="${roles}" var="role">
        <tr>
            <td class="tg-yw4l">${role}</td>
        </tr>
        </c:forEach>
        </tr>
    </table>

        <tr>
            <td><a href="/showTrans">Show transactions</a></td>
            <td><a href="home">Home</a></td>
            <td><a href="/logout">Logout</a></td>
        </tr>
    </table>
</div>
</body>
</html>