<%-- 
    Document   : homePage
    Created on : Jun 29, 2023, 11:02:45 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: 'Roboto', sans-serif;
                background-color: #eee;
            }
        </style>
    </head>
    <body>
        <!-- Components header -->
        <c:set var="cellphoneList" value="${cellphoneList}" scope="session" />
        <c:set var="cellphoneFeatured" value="${cellphoneFeatured}" scope="session" />
        <%@include file="header/header.jsp" %> 

        <c:if test="${isHomePage == true}">
            <c:set var="cellphoneList" value="${cellphoneList}" scope="session" />
            <c:set var="cellphoneFeatured" value="${cellphoneFeatured}" scope="session" />
            <!-- Components featured -->
            <%@include file="featured/featured.jsp" %>

            <!-- Components newProducts -->
            <%@include file="newProducts/newProducts.jsp" %>
        </c:if>

        <c:if test="${isReadmore == true}">
            <!-- Components cart -->
            <%@include file="featured/readmore.jsp" %>
        </c:if> 

        <c:if test="${isCategories == true}">
            <!-- Components cart -->
            <%@include file="categories/categories.jsp" %>
        </c:if>

        <c:if test="${isCart == true}">
            <!-- Components cart -->
            <%@include file="cart/cart.jsp" %>
        </c:if> 

        <!--nếu cart success (Đồng ý trả tiền) thì tới trang này-->
        <c:if test="${isCartSuccess == true}">
            <!-- Components cart -->
            <%@include file="cart/cartSuccess.jsp" %>
            <c:if test="${cellphoneListCart != null}">

                <c:set var="cellphoneListCart" value="${null}" scope="session" />
            </c:if>

            <%--<c:set var="cellphoneListCart" value="${cellphoneListCart}" scope="session" />--%>
        </c:if>

        <%@include file="footer/footer.jsp" %>
    </body>
</html>
