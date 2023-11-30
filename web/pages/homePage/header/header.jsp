<%-- 
    Document   : header
    Created on : Jul 2, 2023, 9:38:00 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header Page</title>
        <link rel="stylesheet" href="header.css"/>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/homePage/header/header.css">
        <style>

            .styledHeader {
                background-color: #222;
            }

            a.logo {
                color: white;
                text-decoration: none;
            }

            .center {
                max-width: 800px;
                margin: 0 auto;
                padding: 0 20px;
            }

            .wrapper {
                display: flex;
                justify-content: space-between;
                padding: 20px 0;
            }

            .navLink {
                color: #aaa;
                text-decoration: none;
            }

            .styledNav {
                display: flex;
                gap: 15px;
            }
        </style>
    </head>
    <body>
        <!-- Components header -->
        <div class="styledHeader">
            <header class="center">
                <div class="wrapper">
                    <a href="/Store/homePageServlet" class="logo">
                        Ecommerce
                    </a>
                    <nav class="styledNav">
                        <a href="/Store/homePageServlet" class="navLink">
                            Home
                        </a>
                        <a href="/Store/handleClickHome?action=categories" class="navLink">
                            Categories
                        </a>
<!--                        <a href="/Store/handleClickHome?action=account" class="navLink">
                            Account
                        </a>-->
                        <a href="/Store/handleClickHome?action=cart" class="navLink">

                            Cart(<c:choose>
                                <c:when test="${empty cellphoneListCart}">0</c:when>
                                <c:otherwise>${cellphoneListCart.size()}</c:otherwise>
                            </c:choose>)
                        </a>
                    </nav>
                </div>

            </header>
        </div>
    </body>
</html>
