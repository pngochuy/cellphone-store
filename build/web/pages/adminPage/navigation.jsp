<%-- 
    Document   : navigation
    Created on : Jun 29, 2023, 10:20:47 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Navigation Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css"
              integrity="sha512-wnea99uKIC3TJF7v4eKk4Y+lMz2Mklv18+r4na2Gn1abDRPPOeef95xTzdwGD9e6zXJBteMIhZ1+68QC5byJZw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
        <div class="bg-blue-900 min-h-screen flex">
            <aside class="text-white p-4 pr-0">
                <!--By default, the <a> tag generates a GET request.-->
                <!--homePageServlet-->
                <a href="/Store/homePageServlet" class="flex gap-1 mb-4 mr-4">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                         stroke="currentColor" class="w-6 h-6">
                    <path stroke-linecap="round" stroke-linejoin="round"
                          d="M13.5 21v-7.5a.75.75 0 01.75-.75h3a.75.75 0 01.75.75V21m-4.5 0H2.36m11.14 0H18m0 0h3.64m-1.39 0V9.349m-16.5 11.65V9.35m0 0a3.001 3.001 0 003.75-.615A2.993 2.993 0 009.75 9.75c.896 0 1.7-.393 2.25-1.016a2.993 2.993 0 002.25 1.016c.896 0 1.7-.393 2.25-1.016a3.001 3.001 0 003.75.614m-16.5 0a3.004 3.004 0 01-.621-4.72L4.318 3.44A1.5 1.5 0 015.378 3h13.243a1.5 1.5 0 011.06.44l1.19 1.189a3 3 0 01-.621 4.72m-13.5 8.65h3.75a.75.75 0 00.75-.75V13.5a.75.75 0 00-.75-.75H6.75a.75.75 0 00-.75.75v3.75c0 .415.336.75.75.75z" />
                    </svg>
                    <span>EcommerceAdmin</span>
                </a>
                <nav class="flex flex-col gap-2">
                    <!-- Xử lí class của tất cả thẻ a là sự kiện khi click vào sẽ chuyển màu background, đc xử lí trong Servlet 
    
                        -> biến lúc đầu đc gắn vào class của thẻ a
                            const inactiveLink = 'flex gap-1 p-1';
                    
                        -> biến lúc sau khi click vào, đc gắn vào class của thẻ a
                            const activeLink = inactiveLink + ' bg-white text-blue-900 rounded-l-lg';
                    
                    -->


                    <a href="/Store/handleClickAdmin?action=dashboard" 
                       class="flex gap-1 p-1 ${isDashboard == true ? activeLink : inactiveLink}">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                             stroke="currentColor" class="w-6 h-6">
                        <path stroke-linecap="round" stroke-linejoin="round"
                              d="M2.25 12l8.954-8.955c.44-.439 1.152-.439 1.591 0L21.75 12M4.5 9.75v10.125c0 .621.504 1.125 1.125 1.125H9.75v-4.875c0-.621.504-1.125 1.125-1.125h2.25c.621 0 1.125.504 1.125 1.125V21h4.125c.621 0 1.125-.504 1.125-1.125V9.75M8.25 21h8.25" />
                        </svg>
                        Dashboard
                    </a>
                    <!--pages/products/products.html-->
                    <a href="/Store/handleClickAdmin?action=products" 
                       class="flex gap-1 p-1 ${isProducts == true ? activeLink : inactiveLink}
                       ${(isAddProductPage == true || isEditProductPage == true) ? activeLink : inactiveLink}
                       ${isdeleteProductPage == true ? activeLink : inactiveLink}">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                             stroke="currentColor" class="w-6 h-6">
                        <path stroke-linecap="round" stroke-linejoin="round"
                              d="M20.25 7.5l-.625 10.632a2.25 2.25 0 01-2.247 2.118H6.622a2.25 2.25 0 01-2.247-2.118L3.75 7.5M10 11.25h4M3.375 7.5h17.25c.621 0 1.125-.504 1.125-1.125v-1.5c0-.621-.504-1.125-1.125-1.125H3.375c-.621 0-1.125.504-1.125 1.125v1.5c0 .621.504 1.125 1.125 1.125z" />
                        </svg>
                        Products
                    </a>
                    <a href="/Store/handleClickAdmin?action=orders" 
                       class="flex gap-1 p-1 ${isOrders == true ? activeLink : inactiveLink}">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                             stroke="currentColor" class="w-6 h-6">
                        <path stroke-linecap="round" stroke-linejoin="round"
                              d="M3.75 12h16.5m-16.5 3.75h16.5M3.75 19.5h16.5M5.625 4.5h12.75a1.875 1.875 0 010 3.75H5.625a1.875 1.875 0 010-3.75z" />
                        </svg>
                        Orders
                    </a>
                    <a href="/Store/handleClickAdmin?action=setting" 
                       class="flex gap-1 p-1 ${isSetting == true ? activeLink : inactiveLink}">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                             stroke="currentColor" class="w-6 h-6">
                        <path stroke-linecap="round" stroke-linejoin="round"
                              d="M9.594 3.94c.09-.542.56-.94 1.11-.94h2.593c.55 0 1.02.398 1.11.94l.213 1.281c.063.374.313.686.645.87.074.04.147.083.22.127.324.196.72.257 1.075.124l1.217-.456a1.125 1.125 0 011.37.49l1.296 2.247a1.125 1.125 0 01-.26 1.431l-1.003.827c-.293.24-.438.613-.431.992a6.759 6.759 0 010 .255c-.007.378.138.75.43.99l1.005.828c.424.35.534.954.26 1.43l-1.298 2.247a1.125 1.125 0 01-1.369.491l-1.217-.456c-.355-.133-.75-.072-1.076.124a6.57 6.57 0 01-.22.128c-.331.183-.581.495-.644.869l-.213 1.28c-.09.543-.56.941-1.11.941h-2.594c-.55 0-1.02-.398-1.11-.94l-.213-1.281c-.062-.374-.312-.686-.644-.87a6.52 6.52 0 01-.22-.127c-.325-.196-.72-.257-1.076-.124l-1.217.456a1.125 1.125 0 01-1.369-.49l-1.297-2.247a1.125 1.125 0 01.26-1.431l1.004-.827c.292-.24.437-.613.43-.992a6.932 6.932 0 010-.255c.007-.378-.138-.75-.43-.99l-1.004-.828a1.125 1.125 0 01-.26-1.43l1.297-2.247a1.125 1.125 0 011.37-.491l1.216.456c.356.133.751.072 1.076-.124.072-.044.146-.087.22-.128.332-.183.582-.495.644-.869l.214-1.281z" />
                        <path stroke-linecap="round" stroke-linejoin="round" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z" />
                        </svg>
                        Settings
                    </a>
                    <a href="/Store/logoutServlet" class="flex gap-1 p-1">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M15.75 9V5.25A2.25 2.25 0 0013.5 3h-6a2.25 2.25 0 00-2.25 2.25v13.5A2.25 2.25 0 007.5 21h6a2.25 2.25 0 002.25-2.25V15M12 9l-3 3m0 0l3 3m-3-3h12.75" />
                        </svg>
                        <input type="hidden" name="admin" value="">
                        Logout
                    </a>
                </nav>
            </aside>

            <!-- Xử lí nếu admin chọn Dashboard,... thì hiển thị nội dung (do lấy tạm trang products.html làm nội dung nên vào Java phải xử lí If else trong JSP) ra phần bên phải cạnh Navigation
            - Xóa dòng chữ để hiển thị nội dung phù hợp
            -->
            <div class="bg-white flex-grow mt-2 mr-2 mb-2 rounded-lg p-4">
                <!--For dashboard's pages-->
                <c:if test="${isDashboard == true}">
                    <c:set var="orderList" value="${orderList}" scope="session" />
                    <c:set var="cellphoneList" value="${cellphoneList}" scope="session" />
                    <%@include file="dashboard/dashboard.jsp" %> 
                </c:if>

                <!--For product's pages-->
                <c:if test="${isProducts == true}">
                    <c:if test="${message != null}">
                        <h2 style="font-size: 20px;
                            font-weight: 600;
                            background-image: radial-gradient(ellipse, #553c9a, #ee4b2b);
                            color: transparent;
                            background-clip: text;
                            -webkit-background-clip: text;">
                            ${message}
                        </h2>
                        <c:set var="message" value="${null}" scope="session" />
                    </c:if>

                    <c:set var="listCellphone" value="${listCellphone}" scope="request" />
                    <%@include file="products/products.jsp" %>  
                </c:if>

                <c:if test="${isAddProductPage == true}">
                    <%@include file="products/addProduct.jsp" %>  
                </c:if>

                <c:if test="${isConfirmAddProduct == true}">
                    <%@include file="products/confirmAddProduct.jsp" %>  
                </c:if>

                <c:if test="${isEditProductPage == true}">
                    <%@include file="products/editProduct.jsp" %>  
                </c:if>

                <c:if test="${isDeleteProductPage == true}">
                    <%@include file="products/deleteProduct.jsp" %>  
                </c:if>

                <!--For orders's pages-->
                <c:if test="${isOrders == true}">
                    <c:set var="orderList" value="${orderList}" scope="session" />
                    <c:set var="titleList" value="${titleList}" scope="session" />
                    <c:set var="quantityList" value="${quantityList}" scope="session" />

                    <%@include file="orders/orders.jsp" %> 
                </c:if>

                <!--For setting's pages-->
                <c:if test="${isSetting == true}">
                    <c:if test="${messageSetting != null}">
                        <h2 style="font-size: 20px;
                            font-weight: 600;
                            background-image: radial-gradient(ellipse, #553c9a, #ee4b2b);
                            color: transparent;
                            background-clip: text;
                            -webkit-background-clip: text;">
                            ${message}
                        </h2>
                        <c:set var="message" value="${null}" scope="session" />
                    </c:if>

                    <c:set var="listCellphone" value="${listCellphone}" scope="request" />
                    <%@include file="setting/setting.jsp" %> 
                </c:if>
            </div>
        </div>
    </body>
</html>
