<%--
  Created by IntelliJ IDEA.
  User: tosiak
  Date: 07.06.18
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>myTrade</title>
</head>
<body>
<%@include file="header.jsp" %>
<h1 class="allerta">Economic calendar</h1>
<h4>You should always be prepared for new market information.</h4>
<iframe src="https://sslecal2.forexprostools.com?columns=exc_flags,exc_currency,exc_importance,exc_actual,exc_forecast,exc_previous&features=datepicker,timezone&countries=25,32,6,37,72,22,17,39,14,10,35,43,56,36,110,11,26,12,4,5&calType=day&timeZone=8&lang=1" width="650" height="467" frameborder="0" allowtransparency="true" marginwidth="0" marginheight="0"></iframe>
<%@include file="footer.jsp" %>
</body>
</html>
