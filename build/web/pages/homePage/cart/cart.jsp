<%-- 
    Document   : cart
    Created on : Jul 5, 2023, 2:23:14 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom-tags/cart-taglib.tld" %>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>

            .columnsWrapper {
                display: grid;
                grid-template-columns: 1.2fr .8fr;
                gap: 40px;
                margin-top: 40px;
            }

            .box {
                background-color: #fff;
                border-radius: 10px;
                padding: 30px;
            }

            .btnPayment {
                border: 0;
                padding: 10px 15px;
                border-radius: 5px;
                cursor: pointer;
                display: inline-flex;
                align-items: center;
                text-decoration: none;
                font-family: 'Roboto', sans-serif;
                font-weight: 500;

                display: block;
                width: 100%;

                background-color: #000;
                color: #fff;
                border: 1px solid #000;

            }

            .styledTableProductOrder {
                width: 100%;

            }

            .styledTableProductOrder th {
                text-align: left;
                text-transform: uppercase;
                color: #ccc;
                font-weight: 600;
                font-size: .7rem;
            }

            .styledTableProductOrder td {
                border-top: 1px solid rgba(0, 0, 0, .1);
            }

            .productInfoCell {
                padding: 10px 0;

            }

            .productImageBox {
                width: 100px;
                height: 100px;
                padding: 10px;
                border: 1px solid rgba(0, 0, 0, .1);
                border-radius: 10px;
                display: flex;
                justify-content: center;
                align-items: center;

            }

            .productImageBox img {
                max-width: 80px;
                max-height: 80px;
            }

            .quantityLabel {
                padding: 0 15px;
                display: inline-block;
            }

            .btnIncreOrDesc {
                border: 0;
                padding: 5px 15px;
                border-radius: 5px;
                cursor: pointer;
                display: inline-flex;
                align-items: center;
                text-decoration: none;
                font-family: "Poppins", sans-serif;
                font-weight: 500;
            }

            .styledInput {
                width: 100%;
                padding: 5px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-sizing: border-box;

            }

            .cityHolder {
                display: flex;
                gap: 5px;
            }
            .return {
                text-decoration: none;

                color: black;
                display: flex;
            }
            svg {
                height: 20px;
                margin-right: 5px;
            }
        </style>

    </head>
    <body>

        <form action="cartServlet" method="POST">

            <div class="center">

                <div class="columnsWrapper">
                    <div class="box">
                        <a href="handleClickHome?action=homePage" class="return">
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                            <path stroke-linecap="round" stroke-linejoin="round" d="M9 15L3 9m0 0l6-6M3 9h12a6 6 0 010 12h-3" />
                            </svg
                            <span>Continue Shopping</span>

                        </a>
                        <h2>Cart</h2>
                        <!-- Xử lí nếu cartProduct mà trống thì ỉn ra
                        <div>Your cart is empty</div> thay vì table -->
                        <c:if test="${cellphoneListCart == null}"> 
                            <div>Your cart is empty</div>
                        </c:if>
                        <c:if test="${cellphoneListCart != null}">
                            <table class="styledTableProductOrder">
                                <thead>
                                    <tr>
                                        <th>Product</th>
                                        <th>Quantity</th>
                                        <th>Price</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- xử lí vòng lặp custom tag ở đây -->
                                    <custom:cartItems />

                                    <tr id="totalRow">
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <strong id="totalAmount">$0</strong>
                                        </td>
                                    </tr>

                                </tbody>
                            </table>
                        </c:if>



                    </div>
                    <!-- Xử lí nếu cartProduct mà trống thì ko ra box dưới này -->
                    <div class="box">
                        <h2>Order infomation</h2>
                        <input type="text" name="name" placeholder="Name" class="styledInput" required="">
                        <input type="text" name="email" placeholder="Email" class="styledInput" required="">
                        <div class="cityHolder">
                            <input type="text" name="city" placeholder="City" class="styledInput" required="">
                            <input type="text" name="postalCode" placeholder="Postal Code" class="styledInput" required="">
                        </div>
                        <input type="text" name="address" placeholder="Address" class="styledInput" required="">

                        <!--thuộc tính còn lại, ko có nhập-->
                        <input type="hidden" name="totalPaid" value="totalPaid">
                        <%
                            LocalDateTime dateCreated = LocalDateTime.now();
                        %>
                        <input type="hidden" name="dateCreated" value="<%= dateCreated%>">

                        <button class="btnPayment" type="submit">Continue to payment</button>
                    </div>
                </div>
            </div>

        </form>  

        <script>


            document.addEventListener('DOMContentLoaded', function () {
                generateHiddenInputs();
            });

            function generateHiddenInputs() {
                var productElements = document.querySelectorAll('.productInfoCell strong');
                var cellphoneIds = [];

                for (var i = 0; i < productElements.length; i++) {
                    var cellphoneId = productElements[i].getAttribute('data-cellphone-id');
                    cellphoneIds.push(cellphoneId);
                }

//                var inputContainer = document.querySelector('#inputContainer');

                for (var i = 0; i < cellphoneIds.length; i++) {
                    var input = document.createElement('input');
                    input.type = 'hidden';
                    input.name = 'updatedCellphoneId[]';
                    input.value = cellphoneIds[i];
//                    inputContainer.appendChild(input);
                }
            }

            document.addEventListener('DOMContentLoaded', function () {
                var updatedQuantityInputs = document.querySelectorAll('.updatedQuantityInput');
                for (var i = 0; i < updatedQuantityInputs.length; i++) {
                    var input = updatedQuantityInputs[i];
                    if (input.value === '') {
                        input.value = '1';
                    }
                }
                calculateTotal(); // Calculate the initial total when the page loads
            });
            function increaseValue(button) {
                var quantityLabel = button.parentNode.querySelector(".quantityLabel");
                var incrementable = quantityLabel.dataset.incrementable === "true";
                if (incrementable) {
                    var currentValue = parseInt(quantityLabel.innerHTML);
                    quantityLabel.innerHTML = currentValue + 1;
                    updateHiddenInputValue(button.parentNode);
                    calculateTotal(); // Recalculate the total when the quantity is updated
                } else {
                    var currentValue = parseInt(quantityLabel.innerHTML);
                    updateHiddenInputValue(button.parentNode);
                    calculateTotal();
                }
            }

            function decreaseValue(button) {
                var quantityLabel = button.parentNode.querySelector(".quantityLabel");
                var incrementable = quantityLabel.dataset.incrementable === "true";
                if (incrementable) {
                    var currentValue = parseInt(quantityLabel.innerHTML);
                    if (currentValue > 1) {
                        quantityLabel.innerHTML = currentValue - 1;
                        updateHiddenInputValue(button.parentNode);
                        calculateTotal();
                    }
                } else {
                    var currentValue = parseInt(quantityLabel.innerHTML);
                    updateHiddenInputValue(button.parentNode);
                    calculateTotal();
                }
            }

            function updateHiddenInputValue(container) {
                var quantityLabel = container.querySelector(".quantityLabel");
                var updatedQuantityInput = container.querySelector(".updatedQuantityInput");
                updatedQuantityInput.value = quantityLabel.innerHTML;

            }

            function calculateTotal() {
                var quantityLabels = document.querySelectorAll('.quantityLabel');
                var priceElements = document.querySelectorAll('.styledTableProductOrder td:nth-child(3) strong');
                var total = 0.0;

                for (var i = 0; i < quantityLabels.length; i++) {
                    var quantity = parseInt(quantityLabels[i].innerHTML);
                    // data type using int, NOT double
                    var price = parseInt(priceElements[i].innerHTML.substring(1));
                    total += quantity * price;
                }

                var totalElement = document.querySelector('#totalRow #totalAmount');
                totalElement.innerHTML = '$' + total;

                var totalPaidInput = document.querySelector('input[name="totalPaid"]');
                totalPaidInput.value = total;
            }
        </script>


    </body>
</html>
