<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="ISO-8859-1">
    <meta charset="utf-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css"
          integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
    <style>
        .add-to-cart-button:disabled {
            filter: saturate(0);
            transition: all 0.2s ease;
        }
        body, html {
            height: 100%;
            background-color: lightskyblue;
        }

        .bgimg {
            background-image: url("/images/signSucc.jpg");
            height: 200%;
            width: 100%;
            background-position: center;
            background-size: cover;
            position: center;
        }

        .scrollable-menu {
            height: auto;
            max-height: 200px;
            overflow-x: hidden;
        }
    </style>
    <title>Productsddd</title>
</head>
<body>
<div class="bgimg" style="  padding-top: 2vh;">
    <div class="container align-items-center justify-content-center">

        <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Kategoria</button>
            <div class="dropdown-menu scrollable-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="http://localhost:8080/products/all?sortBy=${sortBy}&count=${param.count}&page=${param.page}">All</a>
                <c:forEach var="category" items="${categories}">
                    <a class="dropdown-item" href="http://localhost:8080/products/${category}?sortBy=${sortBy}&count=${param.count}&page=${param.page}">${category}</a>
                </c:forEach>
            </div>


            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Show on page
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a href="http://localhost:8080/products/${category}?sortBy=${sortBy}&count=10&page=${param.page}" class="link-info">10</a>
                    <a href="http://localhost:8080/products/${category}?sortBy=${sortBy}&count=20&page=${param.page}" class="link-info">20</a>
                </div>
            </div>
        </div>
        <blockquote class="blockquote text-center">
            <p class="mb-0">Kategoria: ${category}</p>
        </blockquote>
        <%--<h1 style="margin: 30px"></h1>--%>
        <div style="margin: 30px">


            <button onclick="location.href='http://localhost:8080/products/${category}?sortBy=name&count=${param.count}&page=${param.page}'" type="button" class="btn btn-primary btn-lg">Sort all by product name</button>
            <button onclick="location.href='http://localhost:8080/products/${category}?sortBy=price&count=${param.count}&page=${param.page}'" type="button" class="btn btn-secondary btn-lg">Sort all by product price</button>
            <button type="button" class="btn btn-secondary btn-lg" disabled><span id="value">In cart: ${cartQuantity}</span></button>

        <%--    <a href="http://localhost:8080/products/${category}?sortBy=name&count=${param.count}&page=${param.page}">Sort all by product name</a>--%>
            <br />
        <%--    <a href="http://localhost:8080/products/${category}?sortBy=name,price&count=${param.count}&page=${param.page}">Sort all by product name and category</a>--%>
        </div>
        <div style="margin: 30px">




            <table class="table table-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Product Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Image</th>
                    <th scope="col">Description</th>
                    <th scope="col" style="visibility: hidden;"></th>
                </tr>
                </thead>
                <tbody >
                <c:set var="count" value="0" scope="page" />
                <c:forEach var="product" items="${products}">
                    <tr>
                        <th scope="row">${count}</th>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td><img src="${product.thumbnail}" style="width: 30vh;"/></td>
                        <td>${product.description}</td>
                        <td style="border-style: hidden">
                            <c:set var="count" value="${count + 1}" scope="page"/>
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
        <%--         <a href="http://localhost:8080/products/${category}?sortBy=${sortBy}&count=${param.count}&page=${previousPage}">Previous</a>&ndash;%&gt;--%>
        <%--        <a href="http://localhost:8080/products/${category}?sortBy=${sortBy}&count=${param.count}&page=${nextPage}">Next</a>--%>
                </tbody>
            </table>
            <button onclick="location.href='http://localhost:8080/products/${category}?sortBy=${sortBy}&count=${param.count}&page=${previousPage}'" type="button" class="btn btn-outline-info"><- Previous</button>
            <button onclick="location.href='http://localhost:8080/products/${category}?sortBy=${sortBy}&count=${param.count}&page=${nextPage}'" type="button" class="btn btn-outline-info">Next -></button>

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

                const oldCount = document.getElementById("value").innerText.match(/(\d+)/)
                console.log(oldCount)
                document.getElementById("value").innerHTML = "In cart: "+parseInt(parseInt(oldCount) +1)
                const ident = '#productToCart' + id;

                $.ajax({
                    type:"post",
                    data: $(ident).serialize(),
                    url:"/addToCart"
                })
            }
        </script>
        <button onclick="location.href='/cart'" type="button" class="btn btn-primary btn-lg btn-block">Podsumowanie</button>
        <%--<a href="/authenticated">Back to user page</a>--%>
        <button onclick="location.href='/authenticated'" type="button" class="btn btn-secondary btn-lg btn-block">Back to user page</button>
    </div>
</div>
</body>
</html>