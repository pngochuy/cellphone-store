<%-- 
    Document   : newProducts
    Created on : Jul 2, 2023, 11:31:02 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="pages/homePage/newProducts/newProducts.css"/>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/homePage/newProducts/newProducts.css">
        <style>
            /*s*/
            /* Custom Select */

            .custom-select select {
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
                background-color: #d7d7d7;
                color: #000;
                font-size: 14px;
                transition: border-color 0.3s, background-color 0.3s;
            }

            .custom-select select:hover,
            .custom-select select:focus {
                border-color: #000;
                background-color: #d7d7d7;
                outline: none;
            }

            /*s*/
            .productsGrid {
                display: grid;
                grid-template-columns: 1fr 1fr 1fr 1fr;
                gap: 20px;
                margin-bottom: 30px;
            }

            .productBox {
            }

            .whiteBox {
                background-color: #fff;
                padding: 20px;
                height: 120px;
                text-align: center;
                display: flex;
                align-items: center;
                justify-content: center;
                border-radius: 10px;
            }

            .imgNewProduct {
                max-width: 100%;
                max-height: 100px;
            }

            .productWrapper {
            }

            .titleNewProduct {
                text-decoration: none;
                font-size: 1.1rem;
                font-weight: 700;
                margin: 0;
                color: inherit;
            }

            .productInfoBox {
                margin-top: 10px;
            }

            .priceRow {
                display: flex;
                align-items: center;
                justify-content: space-between;
                margin-top: 2px;
            }

            .price {
                font-size: 1.4rem;
                font-weight: 600;
            }

            .buttonNewProduct {
                border: 0;
                padding: 5px 15px;
                border-radius: 5px;
                cursor: pointer;
                display: inline-flex;
                align-items: center;
                font-weight: bold;
                padding: 10px 20px;

                background-color: transparent;
                color: #4c1d95;
                border: 1px solid #4c1d95;
                transition: background-color 0.3s cubic-bezier(0.25, 0.1, 0.25, 1);
            }
            svg {
                height: 16px;
                margin-right: 5px;
            }

            .buttonNewProduct:hover {
                background-color: #4c1d95;
                color: #fff;
            }


            .titleNewArrivals {
                font-size: 2rem;
                margin: 30px 0 20px;
                font-weight: normal;
            }

            .group1 {
                display: flex;
                align-items: center;
                justify-content: space-between;
            }

            .tag {
                background: #eee;
                border-radius: 10px;
                color: #999;
                display: inline-block;
                height: 26px;
                line-height: 26px;
                padding: 0 20px 0 23px;
                position: relative;
                margin: 0 10px 10px 0;
                text-decoration: none;
                -webkit-transition: color 0.2s;
            }

            .tag::before {
                /*background: #fff;*/
                border-radius: 10px;
                /*box-shadow: inset 0 1px rgba(0, 0, 0, 0.25);*/
                content: '';
                height: 6px;
                left: 10px;
                position: absolute;
                width: 6px;
                top: 10px;
            }

            .tag::after {
                content: '';
                position: absolute;
                right: 0;
                top: 0;
            }

            .tag:hover {
                background-color: #4c1d95;
                color: white;
            }

            .tag:hover::after {
                border-left-color: crimson;
            }
            .active {
                background-color: #4c1d95;
                color: white;
            }

        </style>
    </head>
    <body>

        <div class="center">
            <h2 class="titleNewArrivals">New Arrivals</h2> 

            <div class="productsGrid">
                <c:forEach var="cellphone" items="${listCellphone}">

                    <div class="productWrapper">
                        <!-- Xử lí khi click vào product_image -->
                        <a href="readmoreServlet?id=${cellphone.getId()}" class="whiteBox">
                            <div> 
                                <img class="imgNewProduct"
                                     src="images/${cellphone.getImage()}"
                                     alt="">
                            </div>
                        </a>
                        <div class="productInfoBox">
                            <a href="" class="titleNewProduct">${cellphone.getTitle()}</a>
                            <div class="priceRow">
                                <div class="price">$${cellphone.getPrice()}</div>
                                <form action="addToCartServlet" method="POST">
                                    <input type="hidden" name="id" value="${cellphone.getId()}">   
                                    <button class="buttonNewProduct">Add to cart</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>

            <c:if test="${endPage != null}">
                <c:if test="${tag > 1}">
                    <a class="tag" href="homePageServlet?index=${tag-1}">
                        Previous
                    </a>
                </c:if>

                <c:forEach begin="1" end="${endPage}" var="i">
                    <a class="tag ${tag == i ? "active": ""}" href="homePageServlet?index=${i}">
                        ${i}
                    </a>
                </c:forEach>

                <c:if test="${tag < endPage}">
                    <a class="tag" href="homePageServlet?index=${tag+1}">                  
                        Next
                    </a>
                </c:if>

            </c:if>

        </div>

    </body>
</html>
