<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../header.jsp" %>
<h3>${success}</h3>
<form:form method="post" modelAttribute="currency">
    Currency full name
    <form:input path="name"/>
    Currency short name
    <form:input path="shortName"/>
    Currency symbol
    <form:input path="symbol"/>
    <input type="submit" value="Add"/>
</form:form>
<%@include file="../footer.jsp" %>
</body>

</html>