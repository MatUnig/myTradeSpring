<%--
  Created by IntelliJ IDEA.
  User: tosiak
  Date: 05.06.18
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>myTrade</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/table.css">
</head>

<body>
<%@include file="header.jsp" %>
<form action="/close" method="post">
    <section class="wrapper">
        <!-- Row title -->
        <main class="row title">
            <ul>
                <li>Product</li>
                <%--<li>Buy date</li>--%>
                <li>Quantity</li>
                <li>Buy Price</li>
                <li>Current price</li>
                <li>Current profit</li>
                <li>Booked profit</li>
                <li>Status</li>
                <li>Close transaction</li>
            </ul>
        </main>
        <!-- Row 1 - fadeIn -->
        <c:forEach items="${trans}" var="trans">
        <section class="row-fadeIn-wrapper">
            <article class="row fadeIn nfl">
                <ul>
                    <li>${trans.product}</li>
                    <%--<li>${trans.date}</li>--%>
                    <li>${trans.quantity}</li>
                    <li>${trans.price}</li>
                    <li>${trans.currentPrice}</li>
                    <li><p class="${trans.status}">${trans.profit}</p></li>
                    <li>${trans.bookedProfit}</li>
                    <li>${trans.status}</li>
                    <li>
                        <button type="submit" name="close" value="${trans.id}" class="${trans.status}">Close</button>
                    </li>
                </ul>
                <ul class="more-content">
                    <li>Your transaction is closed with result: ${trans.bookedProfit}</li>
                </ul>
            </article>
        </section>
        </c:forEach>
</form>
<%@include file="footer.jsp" %>
</body>
</html>