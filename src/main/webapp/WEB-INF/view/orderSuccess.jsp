<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css"
          integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
    <title>Order placed</title>
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
            height: 100%;
            background-position: center;
            background-size: cover;
            position: center;
        }
    </style>
</head>
<body>
<div class="bgimg">
    <div class="container align-items-center justify-content-center">
        <blockquote class="blockquote text-center">
            <p class="mb-0"><h1>Order Placed Successfully!</h1></p>
        </blockquote>
        <button onclick="location.href='/authenticated'" type="button" class="btn btn-secondary btn-lg btn-block">Back to user page</button>
    </div>
</div>
</body>
</html>