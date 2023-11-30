<%-- 
    Document   : featured
    Created on : Jul 2, 2023, 9:43:49 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Featured Page</title>
        <link rel="stylesheet" href="featured.css"/>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/homePage/featured/featured.css">
        <style>

            .bg {
                background-color: #222;
                color: #fff;
                padding: 50px 0;
            }

            .title {
                margin: 0;
                font-weight: normal;
                font-size: 3rem;
            }

            .desc {
                color: #aaa;
                font-size: .8rem;
            }

            .columnWrapper {
                display: grid;
                grid-template-columns: .9fr 1.1fr;
                gap: 40px;
            }

            .imgFeatured {
                max-width: 100%;
            }

            .column {
                display: flex;
                align-items: center;
            }

            .buttonWrapper {
                display: flex;
                gap: 10px;
                margin-top: 25px;
            }

            .buttonFeatured1,
            .buttonFeatured2 {
                border: 0;
                padding: 5px 15px;
                border-radius: 5px;
                cursor: pointer;
                display: inline-flex;
                align-items: center;
                font-weight: bold;

                font-size: 1.2rem;
                padding: 10px 20px;
            }

            .svgFeatured {
                height: 20px;
                margin-right: 5px;
            }

            .buttonFeatured1 {

                background-color: transparent;
                color: #fff;
                border: 1px solid #fff;
            }

            .buttonFeatured2 {
                background-color: #fff;
                color: #222;
                border: 1px solid #fff;
            }
        </style>
    </head>
    <body>
        <!-- Components featured -->

        <div class="bg">
            <div class="center">
                <div class="columnWrapper">
                    <div class="column">
                        <div>
                            <h1 class="title">${cellphoneFeatured.getTitle()}</h1>
                            <p class="desc">${cellphoneFeatured.getDescription()}</p>
                            <div class="buttonWrapper">
                                <form action="readmoreServlet">
                                    <input type="hidden" name="id" value="${cellphoneFeatured.getId()}">
                                    <button type="submit" class="buttonFeatured1">Read more</button>
                                </form>

                                <form action="addToCartServlet" method="POST">
                                    <input type="hidden" name="id" value="${cellphoneFeatured.getId()}">  

                                    <button class="buttonFeatured2">
                                        <svg class="svgFeatured" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
                                             fill="currentColor" class="w-6 h-6">
                                        <path
                                            d="M2.25 2.25a.75.75 0 000 1.5h1.386c.17 0 .318.114.362.278l2.558 9.592a3.752 3.752 0 00-2.806 3.63c0 .414.336.75.75.75h15.75a.75.75 0 000-1.5H5.378A2.25 2.25 0 017.5 15h11.218a.75.75 0 00.674-.421 60.358 60.358 0 002.96-7.228.75.75 0 00-.525-.965A60.864 60.864 0 005.68 4.509l-.232-.867A1.875 1.875 0 003.636 2.25H2.25zM3.75 20.25a1.5 1.5 0 113 0 1.5 1.5 0 01-3 0zM16.5 20.25a1.5 1.5 0 113 0 1.5 1.5 0 01-3 0z" />
                                        </svg>
                                        Add to cart</button>
                                </form>
                            </div>
                        </div>

                    </div>
                    <div>
                        <img class="imgFeatured"
                             src="images/${cellphoneFeatured.getImage()}"
                             alt="">
                    </div>
                </div>

            </div>

        </div>
    </body>
</html>
