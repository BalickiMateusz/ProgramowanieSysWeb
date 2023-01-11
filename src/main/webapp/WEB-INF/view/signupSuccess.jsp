<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>javaguides.net</title>
</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h1>${message}</h1>
        <hr />

        <table class="table table-striped table-bordered">
            <tr>
                <td><b>First Name </b>: ${user.firstName}</td>
            </tr>
            <tr>
                <td><b>Last Name </b> : ${user.secondName}</td>
            </tr>
            <tr>
                <td><b>Login </b> : ${user.login}</td>
            </tr>
            <tr>
                <td><b>Email </b>: ${user.emailAddress}</td>
            </tr>
        </table>
        <span><a href="/login">Login here</a></span>
        <span><a href="/home">Back to home page</a></span>
    </div>
</div>
</body>
</html>