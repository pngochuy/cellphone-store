<%-- 
    Document   : loginAdmin
    Created on : Jun 27, 2023, 9:35:25 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="icon" type="image/png" href="images/icons/favicon.ico" />

        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />

        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">

        <meta name="robots" content="noindex, follow">

        <!--Handle exception Servlet when entering here!!-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/loginPage/loginAdmin/css/main.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/loginPage/loginAdmin/css/util.css">
        <link rel="icon" href="${pageContext.request.contextPath}/pages/loginPage/loginAdmin/images/icons/favicon.ico">
        <link rel="image" href="${pageContext.request.contextPath}/pages/loginPage/loginAdmin/images/img-01.png">
        <link rel="image" href="${pageContext.request.contextPath}/pages/loginPage/loginAdmin/images/Huy-Store-Logo.png">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/loginPage/loginAdmin/vendor/bootstrap/css/bootstrap.min.css">

    </head>
    <body>
        <div class="limiter">
            <div class="container-login100" style="background: rgb(2,0,36);
                 background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(9,9,121,1) 35%, rgba(0,212,255,1) 100%);">
                <div class="wrap-login100">
                    <div class="login100-pic">
                        <img src="${pageContext.request.contextPath}/pages/loginPage/loginAdmin/images/Huy-Store-Logo.png" alt="IMG">
                    </div>
                    <form class="login100-form" action="/Store/loginAdminServlet" method="POST">
                        <span class="login100-form-title" style="font-weight: bold">
                            Admin Login
                        </span>
                        <div class="wrap-input100" data-validate="Valid email is required: ex@abc.xyz">
                            <input class="input100" type="text" name="username" placeholder="Username"> 
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa-solid fa-user"aria-hidden="true"></i>
                            </span>
                        </div>
                        <div class="wrap-input100" data-validate="Password is required">
                            <input class="input100" type="password" name="password" placeholder="Password">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-lock" aria-hidden="true"></i>
                            </span>
                        </div>
                        <div class="container-login100-form-btn">
                            <button type="submit" class="login100-form-btn">
                                Login
                            </button>
                        </div>

                        <c:if test="${message != null}">
                            <div class="text-center">
                                <h3 style="color: red; margin-top: 20px">${message}</h3>
                                <c:set var="message" value="${null}" scope="session" />
                            </div> 

                        </c:if>
                        <div class="text-center p-t-12">

                        </div>
                        <div class="text-center p-t-136">

                    </form>
                </div>
            </div>
        </div>  


    </body>
</html>
