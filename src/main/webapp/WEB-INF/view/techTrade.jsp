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
<h1 class="allerta">Technical summary view</h1>
<h4>Take a quick look on main market products.</h4>
<iframe src="https://ssltsw.forexprostools.com?lang=1&forex=1,2,3,5,7,9,10&commodities=8830,8836,8831,8849,8833,8862,8832&indices=175,166,172,27,179,170,174&stocks=334,345,346,347,348,349,350&tabs=1,2,3,4" width="317" height="467"></iframe>
<%@include file="footer.jsp" %>
</body>
</html>
