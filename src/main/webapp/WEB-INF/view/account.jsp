<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css"
          integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
    <title>Products</title>
</head>
<body>
<h1>ACCOUNT DATA</h1>
<form:form method="POST" action="/account/change" modelAttribute="currentUser">
    <form:input type="hidden" readonly="true" path="id" value="${currentUser.id}"></form:input>

    <form:label path="firstName">firstName</form:label>
    <form:input type="text" path="firstName" value="${currentUser.firstName}"></form:input>

    <form:label path="secondName">secondName</form:label>
    <form:input type="text" path="secondName" value="${currentUser.secondName}"/>

    <form:label path="emailAddress">emailAddress</form:label>
    <form:input type="text" path="emailAddress" value="${currentUser.emailAddress}"/>

    <form:label path="login">login</form:label>
    <form:input type="text" path="login" value="${currentUser.login}"/>

    <form:label path="password">password</form:label>
    <form:input type="text" path="password" value="Enter new password"/>

    <form:label path="country">country</form:label>
    <form:input type="text" path="country" value="${currentUser.country}"/>

    <form:label path="gender">gender</form:label>
    <form:input type="text" path="gender" value="${currentUser.gender}"/>

    <form:label path="phoneNumber">phoneNumber</form:label>
    <form:input type="text" path="phoneNumber" value="${currentUser.phoneNumber}"/>
    <button value="changeAccount" type="submit">
        Zapisz zmiany!
    </button>
</form:form>
<a href="/authenticated">Back to user page</a>
</body>
</html>