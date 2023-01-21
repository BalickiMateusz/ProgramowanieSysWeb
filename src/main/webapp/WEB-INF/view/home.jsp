<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css"
          integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
    <title>Home</title>
    <style>* {
        box-sizing: border-box;
    }
    body {
        font-family: Arial, Helvetica, sans-serif;
        margin: 0;
    }

    .header {
        padding: 80px;
        text-align: center;
        background: #1abc9c;
        color: white;
    }

    .header h1 {
        font-size: 40px;
    }

    .navbar {
        overflow: hidden;
        background-color: #333;
    }

    .navbar a {
        float: left;
        display: block;
        color: white;
        text-align: center;
        padding: 14px 20px;
        text-decoration: none;
    }

    .navbar a.right {
        float: right;
    }

    .navbar a:hover {
        background-color: #ddd;
        color: black;
    }

    .row {
        display: flex;
        flex-wrap: wrap;
    }


    .side {
        flex: 30%;
        background-color: #f1f1f1;
        padding: 20px;
    }

    .main {
        flex: 70%;
        background-color: white;
        padding: 20px;
    }

    .fakeimg {
        width: 100%;
        padding: 20px;
    }

    .footer {
        padding: 20px;
        text-align: center;
        background: #ddd;
    }

    @media screen and (max-width: 700px) {
        .row {
            flex-direction: column;
        }
    }

    @media screen and (max-width: 400px) {
        .navbar a {
            float: none;
            width:100%;
        }
    }
    </style>
</head>
<body>

<div class="header">
    <h1>Welcome to KebApp</h1>
    <p>The best e-commerce application ever made</p>
</div>

<div class="navbar">
    <sec:authorize access="isAnonymous()">
    <a href="/register">Register</a>
    <a href="/login" class="left">Login</a>
    </sec:authorize>

    <sec:authorize url="authenticated.jsp">
        <a href="/authenticated">User page</a>
        <a href="/logout" class="right">Logout</a>
    </sec:authorize>
</div>

<div class="row">
    <div class="side">
        <h2>We sell</h2>
        <h5>You eat...</h5>
        <div class="fakeimg container text-center" style="height:200px; margin-bottom: auto"><img style="height:200px;" src="/images/kebab.png" class="img-fluid fit-image"/></div>
        <br><p>You can eat this monstrosity for only 23.99 PLN</p>
        <h3>IT'S WORTH IT</h3>
        <p>Just do it</p>
        <div class="fakeimg container text-center" style="height:100px;"><img style="height:100px;" src="/images/kebab2.png" class="img-fluid fit-image"/></div><br>
        <div class="fakeimg container text-center" style="height:100px;"><img style="height:100px;" src="/images/kebab3.png" class="img-fluid fit-image"/></div><br>
        <div class="fakeimg container text-center" style="height:100px;"><img style="height:100px;" src="/images/kebab4.png" class="img-fluid fit-image"/></div>
    </div>
    <div class="main">
        <h2>WE SELL HEAVEN</h2>
        <h5>The best food in the world!</h5>
        <div class="fakeimg container text-center" style="height:200px; margin-bottom: auto;"><img style="height:200px;" src="/images/kebabMan.jpg" class="img-fluid fit-image"/></div>
        <br><br<p>Someone famous once said: "the best kebab is with baranina and ostry sos on grube ciasto. Falafel should you take not.</p>
        <br>
        <h2>IT'S HEALTHY</h2>
        <h5>Meat, tons of veggies</h5>
        <div class="fakeimg container text-center" style="height:200px;">><img style="height:320px;" src="/images/health.jpg" class="img-fluid fit-image"/></div>
    </div>
</div>
</body>
</html>