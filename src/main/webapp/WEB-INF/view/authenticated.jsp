<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="ISO-8859-1">
    <meta charset="utf-8">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css"
          integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
    <title>User page</title>
    <style>

        body, html {
            height: 100%
        }

        .bgimg {
            background-image: url(/images/forestbridge.jpg);
            height: 100%;
            background-position: center;
            background-size: cover;
            position: center;
            color: white;
            font-family: "Courier New", Courier, monospace;
            font-size: 25px;
        }

        a:visited {
            color: lightgray;
            background-color: transparent;
            text-decoration: none;
        }

        .topleft {
            position: absolute;
            top: 0;
            left: 16px;
        }

        .bottomleft {
            position: absolute;
            bottom: 0;
            left: 16px;
        }

        .middle {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
        }

        hr {
            margin: auto;
            width: 40%;
        }
    </style>
</head>
<body>
<div class="bgimg">
    <div class="topleft">
        <p>DrutexCompany Ltd.</p>
    </div>
    <div class="middle">
        <h1>WELCOME ${currentUser.login} !</h1>
        <hr>
        <p>
            <button onclick="location.href='/products/all'" type="button" class="btn btn-outline-info">View our products</button>
            <button onclick="location.href='/account'" type="button" class="btn btn-outline-info">Account data management</button>
            <button onclick="location.href='/home'" type="button" class="btn btn-outline-info">Home page</button>
        </p>
    </div>
    <div class="bottomleft">
        <p>Best quality, best price!</p>
    </div>
</div>
</body>
</html>