<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SignupSuccess</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css"
          integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
    <style>
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
                <div class="align-items-center justify-content-center">
                    <blockquote class="blockquote text-center">
                        <p class="mb-0">${message}</p>
                        <footer class="blockquote-footer">Welcome on our<cite title="Source Title"> webpage</cite></footer>
                    </blockquote>
                    <table class="table table-dark">
                        <thead>
                        <tr>
                            <th scope="col">Attribute</th>
                            <th scope="col">Value</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">First Name: </th>
                            <td>${user.firstName}</td>
                        </tr>
                        <tr>
                            <th scope="row">Last Name: </th>
                            <td>${user.secondName}</td>
                        </tr>
                        <tr>
                            <th scope="row">Login: </th>
                            <td>${user.login}</td>
                        </tr>
                        <tr>
                            <th scope="row">Email: </th>
                            <td>${user.emailAddress}</td>
                        </tr>
                        </tbody>
                    </table>

            <%--        <table class="table table-striped table-bordered">--%>
            <%--            <tr>--%>
            <%--                <td><b>First Name </b>: ${user.firstName}</td>--%>
            <%--            </tr>--%>
            <%--            <tr>--%>
            <%--                <td><b>Last Name </b> : ${user.secondName}</td>--%>
            <%--            </tr>--%>
            <%--            <tr>--%>
            <%--                <td><b>Login </b> : ${user.login}</td>--%>
            <%--            </tr>--%>
            <%--            <tr>--%>
            <%--                <td><b>Email </b>: ${user.emailAddress}</td>--%>
            <%--            </tr>--%>
            <%--        </table>--%>
                    <button onclick="location.href='/login'" type="button" class="btn btn-outline-info">Login here</button>
                    <button onclick="location.href='/home'" type="button" class="btn btn-outline-info">Back to home page</button>
            <%--        <span><a href="/login">Login here</a></span>--%>
            <%--        <span><a href="/home">Back to home page</a></span>--%>
                </div>
            </div>
        </div>
</body>
</html>