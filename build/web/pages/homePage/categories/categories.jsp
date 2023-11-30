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
            .group2 {
                display: flex;
                align-items: center;
                justify-content: space-between;
                gap: 10px;
            }

            .search-container {
                display: flex;
                align-items: center;
                background-color: #fff;
                border-radius: 4px;
                overflow: hidden;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            }

            .search-input {
                flex: 1;
                padding: 10px;
                border: none;
                outline: none;
                font-size: 14px;
                color: #333;
            }

            .search-button {
                padding: 10px;
                background-color: #4c1d95;
                border: none;
                color: #fff;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            .search-button:hover {
                background-color: #4B4848;
            }

            .fa-search {
                font-size: 16px;
            }

        </style>
    </head>
    <body>
        <div class="center">
            <div class="group1">
                <h2 class="titleNewArrivals">Mobiles</h2> 
                <div class="group2">
                    <form id="formColor" action="categoriesServlet" >
                        <label class="custom-select">
                            <select id="selectColor" name="selectedColor" onchange="submitForm('formColor')">
                                <option value="all">All</option>
                                <option value="Black">Black</option>
                                <option value="Red">Red</option>
                                <option value="Blue">Blue</option>
                                <option value="Yellow">Yellow</option>
                            </select>
                        </label>
                    </form>

                    <form id="formSize" action="categoriesServlet" >
                        <label class="custom-select">
                            <select id="selectSize" name="selectedStorage" onchange="submitForm('formSize')">
                                <option value="all">All</option>
                                <option value="64">64</option>
                                <option value="128">128</option>
                                <option value="512">512</option>
                                <option value="1024">1024</option>
                            </select>
                        </label>
                    </form>

                    <form id="formPrice" action="categoriesServlet" >
                        <label class="custom-select">
                            <select id="selectPrice" name="selectedPrice" onchange="submitForm('formPrice')">
                                <option value="all">All</option>
                                <option value="asc">price, lowest first</option>
                                <option value="desc">price, highest first</option>
                            </select>
                        </label>
                    </form>



                </div>

            </div>

            <div class="productsGrid">

                <c:if test="${listChoice == null}"> 
                    <c:forEach var="cellphone" items="${cellphoneList}">
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
                </c:if>

                <c:if test="${listChoice != null}">
                    <c:forEach var="cellphone" items="${listChoice}">

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
                </c:if>


            </div>
        </div>

        <script>
            function submitForm(formId) {
                document.getElementById(formId).submit();
            }

            $(document).on('ready', function () {

                $('.field').on('focus', function () {
                    $('body').addClass('is-focus');
                });

                $('.field').on('blur', function () {
                    $('body').removeClass('is-focus is-type');
                });

                $('.field').on('keydown', function (event) {
                    $('body').addClass('is-type');
                    if ((event.which === 8) && $(this).val() === '') {
                        $('body').removeClass('is-type');
                    }
                });

            });

        </script>  
    </body>
</html>
