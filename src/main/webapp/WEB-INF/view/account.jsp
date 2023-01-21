<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script async="" src="https://www.clarity.ms/eus2-e/s/0.7.1/clarity.js"></script>

    <link rel="stylesheet" id="roboto-subset.css-css" href="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/css/mdb5/fonts/roboto-subset.css?ver=3.9.0-update.5" type="text/css" media="all">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <%--    <link rel="stylesheet" href="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/css/dist/mdb5/standard/core.min.css">--%>
    <link rel="stylesheet" id="roboto-subset.css-css" href="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/css/mdb5/fonts/roboto-subset.css?ver=3.9.0-update.5" type="text/css" media="all">
    <link rel="shortcut icon" href="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/favicon.ico">
    <link rel="canonical" href="https://mdbootstrap.com/docs/standard/extended/registration/">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Account</title>
    <style>
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
</head>
<body>




<section class="vh-100" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">

            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px; background-image: url('https://cms-assets.tutsplus.com/cdn-cgi/image/width=1700/uploads/users/107/posts/26488/final_image/41-space-scrolling-background850-2.jpg');
                                            background-size:    contain;    background-repeat:   no-repeat; background-position:160%;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">

                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Account details</p>

                                <form:form action="/account/change" class="mx-1 mx-md-4"
                                           method="post" modelAttribute="currentUser" cssStyle="width: 100%;">
                                    <form:input type="hidden" readonly="true" path="id" value="${currentUser.id}"></form:input>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:label path="firstName" class="form-label" for="form3Example1c">First
                                                Name</form:label>
                                            <form:input path="firstName" value="${currentUser.firstName}" type="text" id="form3Example1c" class="form-control active" />
                                        </div>
                                        <div  class="col-md-4"><form:errors path="firstName" cssClass="error" /></div>
                                        <div  class="col-md-4"></div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:label path="secondName" class="form-label" for="form3Example11c">Second
                                                Name</form:label>
                                            <form:input path="secondName" value="${currentUser.secondName}" type="text" id="form3Example11c" class="form-control active" />

                                        </div>
                                        <div  class="col-md-4"><form:errors path="secondName" cssClass="error" /></div><div  class="col-md-4"></div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:label path="emailAddress" class="form-label" for="form3Example3c">Your Email</form:label>
                                            <form:input path="emailAddress" value="${currentUser.emailAddress}" type="email" id="form3Example3c" class="form-control active" />

                                        </div>
                                        <div  class="col-md-4"><form:errors path="emailAddress" cssClass="error" /></div><div  class="col-md-4"></div>

                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:label path="login" class="form-label" for="form3Example12c">Login</form:label>
                                            <form:input path="login" value="${currentUser.login}" type="text" id="form3Example12c" class="form-control active" />

                                        </div>
                                        <div  class="col-md-4"><form:errors path="login" cssClass="error" /></div><div  class="col-md-4"></div>

                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:label path="password" for="orm3Example4c" class="form-label">Password</form:label>
                                            <form:password path="password" value="Enter new password" id="form3Example4c" class="form-control active" />

                                        </div>
                                        <div  class="col-md-4"><form:errors path="password" cssClass="error" /></div><div  class="col-md-4"></div>

                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:label path="country" class="form-label" for="form3Example13c">Country</form:label>
                                            <form:input path="country" value="${currentUser.country}" type="text" id="form3Example13c" class="form-control active" />

                                        </div>
                                        <div  class="col-md-4"><form:errors path="country" cssClass="error" /></div><div  class="col-md-4"></div>

                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:label path="gender" class="form-label" for="form3Example14c">Gender</form:label>
                                            <form:input path="gender" value="${currentUser.gender}" type="text" id="form3Example14c" class="form-control active" />

                                        </div>
                                        <div  class="col-md-4"><form:errors path="gender" cssClass="error" /></div><div  class="col-md-4"></div>

                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:label path="phoneNumber" class="form-label" for="form3Example15c">Phone Number</form:label>
                                            <form:input path="phoneNumber" value="${currentUser.phoneNumber}" type="text" id="form3Example15c" class="form-control active" />

                                        </div>
                                        <div  class="col-md-4"><form:errors path="phoneNumber" cssClass="error" /></div><div  class="col-md-4"></div>

                                    </div>









                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:label path="houseNumber" class="form-label" for="form3Example15c">House Number</form:label>
                                            <form:input path="houseNumber" value="${currentUser.houseNumber}" type="text" id="form3Example15c" class="form-control active" />

                                        </div>
                                        <div  class="col-md-4"><form:errors path="houseNumber" cssClass="error" /></div><div  class="col-md-4"></div>

                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:label path="streetName" class="form-label" for="form3Example15c">Street Name</form:label>
                                            <form:input path="streetName" value="${currentUser.streetName}" type="text" id="form3Example15c" class="form-control active" />

                                        </div>
                                        <div  class="col-md-4"><form:errors path="streetName" cssClass="error" /></div><div  class="col-md-4"></div>

                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:label path="city" class="form-label" for="form3Example15c">City</form:label>
                                            <form:input path="city" value="${currentUser.city}" type="text" id="form3Example15c" class="form-control active" />

                                        </div>
                                        <div  class="col-md-4"><form:errors path="city" cssClass="error" /></div><div  class="col-md-4"></div>

                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:label path="state" class="form-label" for="form3Example15c">State</form:label>
                                            <form:input path="state" value="${currentUser.state}" type="text" id="form3Example15c" class="form-control active" />

                                        </div>
                                        <div  class="col-md-4"><form:errors path="state" cssClass="error" /></div><div  class="col-md-4"></div>

                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:label path="postalCode" class="form-label" for="form3Example15c">Postal Code</form:label>
                                            <form:input path="postalCode" value="${currentUser.postalCode}" type="text" id="form3Example15c" class="form-control active" />

                                        </div>
                                        <div  class="col-md-4"><form:errors path="postalCode" cssClass="error" /></div><div  class="col-md-4"></div>

                                    </div>








                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <form:button value="changeAccount" type="submit" class="btn btn-primary btn-lg">Save changes!!</form:button>
                                    </div>
                                    <div class="form-check d-flex justify-content-center mb-5">
                                        <label class="form-check-label">
                                            Back to home page? <a href="/home">Click here</a>
                                        </label>
                                    </div>

                                </form:form>



                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>










<%--<h1>ACCOUNT DATA</h1>--%>
<%--<form:form method="POST" action="/account/change" modelAttribute="currentUser">--%>
<%--    <form:input type="hidden" readonly="true" path="id" value="${currentUser.id}"></form:input>--%>

<%--    <form:label path="firstName">firstName</form:label>--%>
<%--    <form:input type="text" path="firstName" value="${currentUser.firstName}"></form:input>--%>

<%--    <form:label path="secondName">secondName</form:label>--%>
<%--    <form:input type="text" path="secondName" value="${currentUser.secondName}"/>--%>

<%--    <form:label path="emailAddress">emailAddress</form:label>--%>
<%--    <form:input type="text" path="emailAddress" value="${currentUser.emailAddress}"/>--%>

<%--    <form:label path="login">login</form:label>--%>
<%--    <form:input type="text" path="login" value="${currentUser.login}"/>--%>

<%--    <form:label path="password">password</form:label>--%>
<%--    <form:input type="text" path="password" value="Enter new password"/>--%>

<%--    <form:label path="country">country</form:label>--%>
<%--    <form:input type="text" path="country" value="${currentUser.country}"/>--%>

<%--    <form:label path="gender">gender</form:label>--%>
<%--    <form:input type="text" path="gender" value="${currentUser.gender}"/>--%>

<%--    <form:label path="phoneNumber">phoneNumber</form:label>--%>
<%--    <form:input type="text" path="phoneNumber" value="${currentUser.phoneNumber}"/>--%>
<%--    <button value="changeAccount" type="submit">--%>
<%--        Zapisz zmiany!--%>
<%--    </button>--%>
<%--</form:form>--%>
<%--<a href="/authenticated">Back to user page</a>--%>
</body>
</html>