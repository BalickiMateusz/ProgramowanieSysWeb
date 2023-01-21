<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Login</title></head>
<body>
<section class="vh-100">
    <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                     class="img-fluid" alt="Sample image">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form name='f' action="/login" method='POST'>

                    <c:if test="${param.error ne null}">
                        <div style="color:red;" class="text-center text-lg-start mt-4 pt-2">
                            <p class="small fw-bold mt-2 pt-1 mb-0">
                                Login Failed!!!<br />
                                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                            </p>
                        </div>
                    </c:if>

                    <c:if test="${param.logout ne null}">
                        <div style="color:red;" class="text-center text-lg-start mt-4 pt-2">
                            <p class="small fw-bold mt-2 pt-1 mb-0">
                                Logged out!!!! <br />
                            </p>
                        </div>
                    </c:if>

                    <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                        <p class="lead fw-normal mb-0 me-3">Sign in</p>
                    </div>

                    <div class="divider d-flex align-items-center my-4">
                        <p class="text-center fw-bold mx-3 mb-0">Or</p>
                    </div>

                    <div class="form-outline mb-4">
<%--                        DAJ TU POTEM TYPE EMAIL--%>
                        <input type="text" name="username" value="" id="form3Example3" class="form-control form-control-lg"
                               placeholder="Enter a valid email address" />
                        <label class="form-label" for="form3Example3">Email address</label>
                    </div>

                    <div class="form-outline mb-3">
                        <input type="password" name="password" id="form3Example4" class="form-control form-control-lg"
                               placeholder="Enter password" />
                        <label class="form-label" for="form3Example4">Password</label>
                    </div>

                    <div class="d-flex justify-content-between align-items-center">
                    </div>

                    <div class="text-center text-lg-start mt-4 pt-2">
                        <button type="submit" name="submit" value="submit" class="btn btn-primary btn-lg"
                                style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>

                        <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="/register"
                                                                                          class="link-danger">Register</a></p>

                        <p class="small fw-bold mt-2 pt-1 mb-0">Back to home page? <a href="/home"
                                                                                          class="link-danger">Home page</a></p>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
    </div>
</section>
</body>
</html>