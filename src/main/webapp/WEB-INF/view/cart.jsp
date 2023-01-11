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
<c:forEach var="product" items="${products}">
    <tr>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <span id="ltZero" style="display: none">Quantity can not be lower than zero!</span>
        <span id="bgStock" style="display: none">We do not have enough items to cover that quantity!</span>
        <td style="border-style: hidden">
            <form:form id="quantity${product.id}" method="POST" action="/quantity" modelAttribute="quantity">
                <form:input path="product" value="${product.id}" type="hidden" readonly="true"></form:input>
                <form:input id="input${product.id}" type="text" path="quantity" class="quantity-text" value="${mapCartItems.get(product.id)}" onchange="displayButton(${product.id})"/>
                <button id="button${product.id}" value="productToShoppingCart" type="button" style="display: none" onclick="sendForm(${product.id})">
                    Potwierdz
                </button>
                <span id="span${product.id}" style="display: none">Sukces!</span>
            </form:form>
        </td>
    </tr>
</c:forEach>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script>
    function displayButton(id){
        document.getElementById("button"+id).style.display = "block";
        document.getElementById("span"+id).style.display = "none";
    }
    function sendForm(id) {
        document.getElementById("button"+id).style.display = "none";
        document.getElementById("span"+id).style.display = "block";
        const ident = '#quantity' + id;

        $.ajax({
            type: "post",
            data: $(ident).serialize(),
            url: "/quantity",
            success: function (data) {
                if (data == "ltZero"){
                    alert('lala')
                    document.getElementById("ltZero").style.display="block";
                    document.querySelectorAll('input.quantity-text').forEach(elem => {
                        elem.disabled= true;
                    });
                    document.getElementById("input"+id).disabled = false;
                    document.getElementById("span"+id).innerText="Insert proper value!"
                }else if (data == "btStock"){
                    document.getElementById("bgStock").style.display="block";
                    document.querySelectorAll('input.quantity-text').forEach(elem => {
                        elem.disabled= true;
                    });
                    document.getElementById("input"+id).disabled = false;
                    document.getElementById("span"+id).innerText="Insert proper value!"
                }else{
                    document.getElementById("ltZero").style.display="none";
                    document.getElementById("bgStock").style.display="none";
                    document.querySelectorAll("input.quantity-text").forEach(elem => {
                        elem.disabled = false;
                    });
                    document.getElementById("span"+id).innerText="Success!"
                }
            }
        })
    }
</script>
<span id="value"></span><a href="/order">Szczegoly zamowienia</a>
<a href="/authenticated">Back to user page</a>
</body>
</html>