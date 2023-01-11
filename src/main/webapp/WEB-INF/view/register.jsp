<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h2 class="text-center">Spring MVC 5 Form Handling Example -
            Sign up Form</h2>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Sign Up</div>
            </div>
            <div class="panel-body">
                <form:form action="/register/save" cssClass="form-horizontal"
                           method="post" modelAttribute="user">

                    <div class="form-group">
                        <label for="firstName" class="col-md-3 control-label">First
                            Name</label>
                        <div class="col-md-9">
                            <form:input path="firstName" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="secondName" class="col-md-3 control-label">Second
                            Name</label>
                        <div class="col-md-9">
                            <form:input path="secondName" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="emailAddress" class="col-md-3 control-label">Email Address </label>
                        <div class="col-md-9">
                            <form:input path="emailAddress" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="login" class="col-md-3 control-label">Login</label>
                        <div class="col-md-9">
                            <form:password path="login" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="col-md-3 control-label">Password</label>
                        <div class="col-md-9">
                            <form:password path="password" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="country" class="col-md-3 control-label">Country</label>
                        <div class="col-md-9">
                            <form:input path="country" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="gender" class="col-md-3 control-label">Gender</label>
                        <div class="col-md-9">
                            <form:input path="gender" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="phoneNumber" class="col-md-3 control-label">Phone Number</label>
                        <div class="col-md-9">
                            <form:input path="phoneNumber" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">Submit</form:button>
                        </div>
                    </div>

                </form:form>
                <span>Already registered? <a href="/login">Login here</a></span>
                <span><a href="/home">Back to home page</a></span>
            </div>
        </div>
    </div>
</div>
</body>
</html>