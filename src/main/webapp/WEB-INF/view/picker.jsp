<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>myTrade</title>
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Lato|Quicksand'>
    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<%@include file="header.jsp" %>
</br>
<div>
    <h2>Choose a currency pair you want to trade:</h2>
    <form action="/pickProduct">
        <div class="sel">
            <select name="fromCurrency">
                <option value="From Currency" disabled>From Currency</option>
                <c:forEach items="${list}" var="shortName">
                    <option value="${shortName}">${shortName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="sel">
            <select name="toCurrency">
                <option value="To Currency" disabled>To Currency</option>
                <c:forEach items="${list}" var="shortName">
                    <option value="${shortName}">${shortName}</option>
                </c:forEach>
            </select>
        </div>
        </br>
        <button type="submit" class="button"><span>Pick product</span></button>
        <a class="button" href="/showTrans"><span>Show transactions</span></a>
    </form>
</div>
</div>
<%@include file="footer.jsp" %>
</div>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
<script src="js/index.js"></script>
</body>
</html>