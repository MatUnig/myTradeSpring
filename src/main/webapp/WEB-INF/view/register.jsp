<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="login.css">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
<div id="main">
    <div class="row" id="top">
        <div class="col-lg-6 col-lg-offset-3 text-center">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-lock"></span> Register
                </div>
                <div class="panel-body">
                    <form:form id="centerForm" modelAttribute="user" class="form-horizontal" action="registerProcess"
                               method="post">
                    <div class="form-group">
                        <form:label for="inputName" path="name" class="col-sm-3 control-label center">
                            </form:label>
                        <div class="col-sm-6">
                            <form:input type="text" path="name" name="name" class="form-control" id="name"
                                        placeholder="Name"/>
                            <form:errors path="username" name="username" id="username"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label for="inputSurname" path="name" class="col-sm-3 control-label">
                            Surname</form:label>
                        <div class="col-sm-6">
                            <form:input type="text" path="surname" name="surname" class="form-control" id="surname"
                                        placeholder="Surname"/>
                            <form:errors path="surname" name="surname" id="surname"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label for="inputUsername" path="username" class="col-sm-3 control-label">
                            Username</form:label>
                        <div class="col-sm-6">
                            <form:input type="text" path="username" name="username" class="form-control" id="username"
                                        placeholder="Username"/>
                            <form:errors path="username" name="username" id="username"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label for="inputPassword3" path="password" class="col-sm-3 control-label">
                            Password</form:label>
                        <div class="col-sm-6">
                            <form:input type="password" path="password" name="password" class="form-control"
                                        id="password" placeholder="Password"/>
                            <form:errors path="password" name="password" id="password"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label for="inputMail" path="email" class="col-sm-3 control-label">
                            E-mail</form:label>
                        <div class="col-sm-6">
                            <form:input type="text" path="email" name="email" class="form-control" id="email"
                                        placeholder="E-mail"/>
                            <form:errors path="email" name="email" id="email"/>
                        </div>
                    </div>
                    <div class="form-group last">
                        <div class="col-sm-offset-3 col-sm-6">
                            <form:button type="submit" id="register" name="register" class="btn btn-success btn-sm">
                                Register</form:button>
                            <button type="reset" id="login" class="btn btn-default btn-sm">
                                Reset
                            </button>
                        </div>
                    </div>
                </div>
                    </form:form>
                <a href="/">Home</a>


</body>
</html>