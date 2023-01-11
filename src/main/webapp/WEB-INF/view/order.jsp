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
<h1>Items in Your cart:</h1>
<span>Total price: ${totalPrice}</span>
<span>Total weight: ${totalWeight}</span>
<form:form method="POST" action="/placeOrder" modelAttribute="order">
    <div>
        <form:label path="address.houseNumber" for="houseNumber">House number</form:label>
        <form:input path="address.houseNumber" type="text" id="houseNumber" name="houseNumber" autocomplete="house number" enterkeyhint="next"></form:input>
    </div>
    <div>
        <form:label path="address.streetName" for="street-address">Street name</form:label>
        <form:input path="address.streetName" type="text" id="street-address" name="street-address" autocomplete="street name" enterkeyhint="next"></form:input>
    </div>
    <div>
        <form:label path="address.city" for="city">City</form:label>
        <form:input path="address.city" type="text" id="city" name="city" autocomplete="city" enterkeyhint="next"></form:input>
    </div>
    <div>
        <form:label path="address.state" for="state">State</form:label>
        <form:input path="address.state" type="text" id="state" name="state" autocomplete="state" enterkeyhint="next"></form:input>
    </div>
    <div>
        <form:label path="address.postalCode" for="postalCode">Postal code</form:label>
        <form:input path="address.postalCode" type="text" id="postalCode" name="postalCode" autocomplete="postal code" enterkeyhint="next"></form:input>
    </div>
    <div>
        <form:label path="address.country" for="state">Country</form:label>
        <form:input path="address.country" type="text" id="country" name="country" autocomplete="country" enterkeyhint="next"></form:input>
    </div>

    <form:textarea rows="5" maxlength="120" path="additionalRemarks"/>
    <c:forEach var="supplier" items="${suppliers}">
        <form:radiobutton id="${supplier.id}" path="supplier" value="${supplier}"/>
        <form:label path="supplier" for="${supplier.id}">${supplier.name} - ${supplier.type}</form:label>
    </c:forEach>
    <button value="placeOrder">
        Zloz zamowienie
    </button>
</form:form>
<a href="/authenticated">Back to user page</a>
</body>
</html>