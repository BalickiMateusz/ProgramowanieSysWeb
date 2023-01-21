<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cite" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css"
          integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
    <title>Order</title>

    <style>
        .add-to-cart-button:disabled {
            filter: saturate(0);
            transition: all 0.2s ease;
        }
        body, html {
            height: 100%
        }

        .bgimg {
            background-image: url("/images/signSucc.jpg");
            height: 200%;
            width: 100%;
            background-position: center;
            background-size: cover;
            position: center;
            background-repeat: repeat-y;
        }

        .error {
            color: red
        }

        /* Form container */
        .form-container {
            padding: 30px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        /* Form inputs */
        .form-control {
            padding: 12px;
            border-radius: 5px;
            border: none;
            margin-bottom: 20px;
            box-shadow: 0 0 5px rgba(0,0,0,0.1);
        }

        /* Form label */
        label {
            font-weight: bold;
            font-size: 14px;
            margin-bottom: 10px;
            display: block;
        }

        /* Form button */
        .form-btn {
            background-color: #3498db;
            color: #fff;
            padding: 12px 20px;
            border-radius: 5px;
            border: none;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        /* Form button hover */
        .form-btn:hover {
            background-color: #2980b9;
        }

        /* Error message */
        .error {
            color: red;
            font-size: 18px;
            margin-top: 5px;
        }
        .form-control{
            border: 2px solid black;
        }
    </style>
    <script
            src="https://code.jquery.com/jquery-3.6.3.js"
            integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
            crossorigin="anonymous"></script>

</head>
<body>
<div class="bgimg">
    <div class="container align-items-center justify-content-center">

        <blockquote class="blockquote text-center">
            <p class="mb-0"><h1>Items in Your cart:</h1></p>
            <p class="mb-0"><span id="total">Total price: ${totalPrice}</span></p>
            <p class="mb-0"><span>Total weight: ${totalWeight}</span></p>
        </blockquote>

        <form:form method="POST" action="/placeOrder" class="mx-1 mx-md-4" id="myForm" modelAttribute="order">
<%--            <div>--%>
<%--                <form:label path="address.houseNumber" for="houseNumber">House number</form:label>--%>
<%--                <form:input path="address.houseNumber" type="text" id="houseNumber" name="houseNumber" autocomplete="house number" enterkeyhint="next"></form:input>--%>
<%--            </div>--%>

            <div class="d-flex flex-row align-items-center mb-4">
                <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                <div class="form-outline flex-fill mb-0">
                    <form:label class="form-label" path="address.houseNumber" for="houseNumber">House number</form:label>
                    <form:input value="${user.houseNumber}" class="xd form-control active" path="address.houseNumber" type="text" id="houseNumber" name="houseNumber" autocomplete="house number" enterkeyhint="next"></form:input>
                </div>
                <div  class="col-md-2"><form:errors path="address.houseNumber" cssClass="error" /></div><div  class="col-md-4"></div>
            </div>


<%--            <div>--%>
<%--                <form:label path="address.streetName" for="street-address">Street name</form:label>--%>
<%--                <form:input path="address.streetName" type="text" id="street-address" name="street-address" autocomplete="street name" enterkeyhint="next"></form:input>--%>
<%--            </div>--%>


            <div class="d-flex flex-row align-items-center mb-4">
                <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                <div class="form-outline flex-fill mb-0">
                    <form:label class="form-label" path="address.streetName" for="street-address">Street name</form:label>
                    <form:input value="${user.streetName}"  class="xd form-control active" path="address.streetName" type="text" id="street-address" name="street-address" autocomplete="street name" enterkeyhint="next"></form:input>
                </div>
                <div  class="col-md-2"><form:errors path="address.streetName" cssClass="error" /></div><div  class="col-md-4"></div>

            </div>


<%--            <div>--%>
<%--                <form:label path="address.city" for="city">City</form:label>--%>
<%--                <form:input path="address.city" type="text" id="city" name="city" autocomplete="city" enterkeyhint="next"></form:input>--%>
<%--            </div>--%>

            <div class="d-flex flex-row align-items-center mb-4">
                <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                <div class="form-outline flex-fill mb-0">
                    <form:label class="form-label" path="address.city" for="city">City</form:label>
                    <form:input value="${user.city}"  class="xd form-control active" path="address.city" type="text" id="city" name="city" autocomplete="city" enterkeyhint="next"></form:input>
                </div>
                <div  class="col-md-2"><form:errors path="address.city" cssClass="error" /></div><div  class="col-md-4"></div>

            </div>

<%--            <div>--%>
<%--                <form:label path="address.state" for="state">State</form:label>--%>
<%--                <form:input path="address.state" type="text" id="state" name="state" autocomplete="state" enterkeyhint="next"></form:input>--%>
<%--            </div>--%>

            <div class="d-flex flex-row align-items-center mb-4">
                <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                <div class="form-outline flex-fill mb-0">
                    <form:label class="form-label" path="address.state" for="state">State</form:label>
                    <form:input value="${user.state}"  class="xd form-control active" path="address.state" type="text" id="state" name="state" autocomplete="state" enterkeyhint="next"></form:input>
                </div>
                <div  class="col-md-2"><form:errors path="address.state" cssClass="error" /></div><div  class="col-md-4"></div>

            </div>

<%--            <div>--%>
<%--                <form:label path="address.postalCode" for="postalCode">Postal code</form:label>--%>
<%--                <form:input path="address.postalCode" type="text" id="postalCode" name="postalCode" autocomplete="postal code" enterkeyhint="next"></form:input>--%>
<%--            </div>--%>



            <div class="d-flex flex-row align-items-center mb-4">
                <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                <div class="form-outline flex-fill mb-0">
                    <form:label class="form-label" path="address.postalCode" for="postalCode">Postal code</form:label>
                    <form:input value="${user.postalCode}"  class="xd form-control active" path="address.postalCode" type="text" id="postalCode" name="postalCode" autocomplete="postal code" enterkeyhint="next"></form:input>
                </div>
                <div  class="col-md-2"><form:errors path="address.postalCode" cssClass="error" /></div><div  class="col-md-4"></div>

            </div>

<%--            <div>--%>
<%--                <form:label path="address.country" for="state">Country</form:label>--%>
<%--                <form:input path="address.country" type="text" id="country" name="country" autocomplete="country" enterkeyhint="next"></form:input>--%>
<%--            </div>--%>


            <div class="d-flex flex-row align-items-center mb-4">
                <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                <div class="form-outline flex-fill mb-0">
                    <form:label class="form-label"  path="address.country" for="state">Country</form:label>
                    <form:input value="${user.country}" class="xd form-control active" path="address.country" type="text" id="country" name="country" autocomplete="country" enterkeyhint="next"></form:input>
                </div>
                <div  class="col-md-2"><form:errors path="address.country" cssClass="error" /></div><div  class="col-md-4"></div>

            </div>

<%--            <div>--%>
<%--            <form:textarea rows="5" maxlength="120" path="additionalRemarks"/>--%>
<%--            </div>--%>

            <div class="d-flex flex-row align-items-center mb-4">
                <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                <div class="form-outline flex-fill mb-0">
                    Additional remarks:
                    <form:textarea class="form-control" rows="5" maxlength="120" path="additionalRemarks"/>
                </div>
                <div  class="col-md-2"><form:errors path="additionalRemarks" cssClass="error" /></div><div  class="col-md-4"></div>
            </div>
            <div class="container">
                <div  class="col-md-5"><form:errors path="supplier" cssClass="error" /></div>
                <c:forEach var="supplier" items="${suppliers}">
                    <div class="d-flex flex-fill align-items-left col-md-5" style="text-align: left; margin-bottom: 8px;">
                        <div class="col-md-7" style="padding: 0px; text-align: left;">
                            <form:label class="form-label"  path="supplier" for="${supplier.id}">${supplier.name} - ${supplier.type} - ${supplier.deliveryPrice}</form:label>
                        </div>
                        <div class="col-md-5">
                            <form:radiobutton class="form-control price" style="margin: 0px; padding: 0px;" onclick="addPrice('${supplier.id}', '${supplier.deliveryPrice}')" id="${supplier.id}" path="supplier" value="${supplier}"/>
                        </div>
                    </div>
                    <div  class="col-md-3"></div>
                </c:forEach>
            </div>


            <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                <form:button class="btn btn-primary btn-lg" value="placeOrder">Place an order</form:button>
            </div>

<%--            <button value="placeOrder">--%>
<%--                Zloz zamowienie--%>
<%--            </button>--%>
            <form:input  style="display: none" path="totalPrice" type="text" id="totalPrice"></form:input>

        </form:form>
<%--        <a href="/authenticated">Back to user page</a>--%>
        <button onclick="location.href='/authenticated'" type="button" class="btn btn-secondary btn-lg btn-block">Back to user page</button>

    </div>
</div>
<script>

    function addPrice(id, price){
        document.getElementById("total").innerHTML = "Total price: " + (parseFloat(${totalPrice}) + parseFloat(price))
        document.getElementById("totalPrice").innerHTML = parseFloat(${totalPrice}) + parseFloat(price)
        document.getElementById("totalPrice").value = parseFloat(${totalPrice}) + parseFloat(price)
    }

    function notPropagate(){
       var err = document.getElementsByClassName("error")

        var flag = false

        Array.prototype.forEach.call(err, function(er) {;
            if (er.innerHTML.localeCompare("")!==0){
                flag = true
            }
        });

       if (flag){

           var inputs = document.getElementsByClassName("xd")
           Array.prototype.forEach.call(inputs, function(input) {
               input.setAttribute("value", sessionStorage.getItem(input.id))

           });
       }
    }

    $('#myForm').submit(function(event) {


        event.preventDefault();

        var inputs = document.getElementsByClassName("xd")

        for (var i = 0; i < inputs.length; i++) {
            sessionStorage.setItem(inputs[i].id, inputs[i].value);
        }

        // Array.prototype.forEach.call(inputs, function(inputs) {
        //     sessionStorage.setItem($(this).id, $(this).val());
        // });
        document.getElementById("myForm").submit();
    })

    window.onload = notPropagate()
</script>
</body>
</html>