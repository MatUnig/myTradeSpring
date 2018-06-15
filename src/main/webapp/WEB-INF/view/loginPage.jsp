<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
  Created by IntelliJ IDEA.
  User: tosiak
  Date: 31.05.18
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
<body>
<%@include file="header.jsp" %>
<c:if test="${not empty error}"><div>${error}</div></c:if>
<c:if test="${not empty message}"><div>${message}</div></c:if>
</br>
<div>
    <div class="container">
        <div class="row" id="top">
            <div class="col-lg-6 col-lg-offset-3 text-center">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="glyphicon glyphicon-lock"></span> Login
                    </div>
                    <div class="panel-body">
                        <form name='login' action="<c:url value='/loginPage' />" method='POST'>
                            <div class="form-group">
                                <label path="username" class="col-sm-3 control-label">
                                    </label>
                                <div class="col-sm-6">
                                    <input type="text" path="username" name="username" class="form-control"
                                           id="username" placeholder="Login"/>
                                    <errors path="username" name="username" id="username"/>
                                </div>
                            </div></br>
                            <div class="form-group">
                                <label  path="password" class="col-sm-3 control-label">
                                    </label>
                                <div class="col-lg-6 col-lg-offset-3 text-center">
                                    <input type="password" path="password" name="password" class="form-control"
                                           id="password" placeholder="Password"/>
                                    <errors path="password" name="password" id="password"/>
                                </div>
                            </div>
                            <div class="form-group last">
                                <div class="col-sm-offset-3 col-sm-6">
                                    <button type="submit" name="login" class="btn btn-success btn-sm">
                                        <input type="hidden"
                                               name="${_csrf.parameterName}"
                                               value="${_csrf.token}"/>
                                        Sign in</button>
                                    <button type="reset" name="login" class="btn btn-default btn-sm">
                                        Reset
                                    </button></br>
                                </div>
                            </div>
                        </form>
                    </div>

                    <div class="panel-footer" id="black-font">
                        Not Registred? <a href=/register>Register here</a></div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>


