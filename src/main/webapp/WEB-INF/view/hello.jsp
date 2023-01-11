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
    <style>
        .add-to-cart-button:disabled {
            filter: saturate(0);
            transition: all 0.2s ease;
        }
    </style>
    <title>Products</title>
</head>
<body>
<div style="margin: 30px" class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Kategoria</button>
    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <c:forEach var="category" items="${categories}">
            <a class="dropdown-item" href="http://localhost:8080/products/${category}?sortBy=${sortBy}&count=${param.count}&page=${param.page}">${category}</a>
        </c:forEach>
    </div>
    <a href="http://localhost:8080/products/${category}?sortBy=${sortBy}&count=1&page=${param.page}">1</a>
    <a href="http://localhost:8080/products/${category}?sortBy=${sortBy}&count=2&page=${param.page}">2</a>
</div>
<h1 style="margin: 30px">Kategoria: ${category}</h1>
<div style="margin: 30px">
    <a href="http://localhost:8080/products/${category}?sortBy=name&count=${param.count}&page=${param.page}">Sort all by product name</a>
    <br />
    <a href="http://localhost:8080/products/${category}?sortBy=name,price&count=${param.count}&page=${param.page}">Sort all by product name and category</a>
</div>
<div style="margin: 30px">
    <table class="table table-bordered" style="width: 500px">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Product Name</th>
            <th scope="col">Price</th>
            <th scope="col" style="border-style: hidden"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td style="border-style: hidden">
                    <form:form id="productToCart${product.id}" method="POST" action="/addToCart" modelAttribute="productToCart">
                        <form:input path="id" value="${product.id}" type="hidden" readonly="true"></form:input>
                        <form:input path="price" value="${product.price}" type="hidden" readonly="true"/>
                        <form:input path="weight" value="${product.weight}" type="hidden" readonly="true"/>
                        <button class="submit-form add-to-cart-button" id="${product.id}" value="productToShoppingCart" type="button" onclick="showDiv(this.id)">
                            <img src="/images/cart.png" alt="add_to_cart" width="50" height="60">
                        </button>
<%--                        <input id="submitProductToCart" type="button" value="Submit" />--%>
                    </form:form>
                    <span id="done${product.id}" style="display: none">Dodano!</span>
                </td>
            </tr>
        </c:forEach>
        <a href="http://localhost:8080/products/${category}?sortBy=${sortBy}&count=${param.count}&page=${previousPage}">Previous</a>
        <a href="http://localhost:8080/products/${category}?sortBy=${sortBy}&count=${param.count}&page=${nextPage}">Next</a>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script>
    window.onload=function()
    {
        var storedNames =${addedIds}

        for (var id of storedNames) {
            document.getElementById("done"+id).style.display="block"
            document.getElementById(id).disabled= true
        }
    }

    var names = [];

    function showDiv(id){
        document.getElementById("done"+id).style.display="block"
        document.getElementById(id).disabled= true
        names.push(id)
        localStorage.setItem("names", JSON.stringify(names))

        const oldCount = document.getElementById("value").innerHTML
        console.log(oldCount)
        document.getElementById("value").innerHTML = parseInt(oldCount) +1
        const ident = '#productToCart' + id;

        $.ajax({
            type:"post",
            data: $(ident).serialize(),
            url:"/addToCart"
        })
    }
</script>
<span id="value">${cartQuantity}</span><a href="/cart">Podsumowanie</a>
<a href="/authenticated">Back to user page</a>
</body>
</html>