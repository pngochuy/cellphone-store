<%-- 
    Document   : orders
    Created on : Jun 29, 2023, 10:58:07 PM
    Author     : PC
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders Page</title>
        <style>
            .order-info {
                text-align: left;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                height: 100%;
            }
        </style>
    </head>
    <body>
        
        <h1 class="text-blue-900 mb-2 text-xl font-bold">Orders</h1>
        <table class="w-full mt-2">
            <thead>
                <tr>
                    <th class="border border-blue-200 p-1 bg-blue-100">ID</th>
                    <th class="border border-blue-200 p-1 bg-blue-100">Recipient</th>
                    <th class="border border-blue-200 p-1 bg-blue-100">Products</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${orderList != null}">
                    <% int index = 0;%>
                    <c:forEach var="order" items="${orderList}">
                        <tr>

                            <td class="border border-blue-200 p-1 text-center">${order.getDateCreated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}</td>
                            <td class="border border-blue-200 p-1">
                                <div class="order-info">
                                    ${order.getName()} - ${order.getEmail()}<br>
                                    ${order.getCity()} - ${order.getPostalCode()} <br>
                                    ${order.getAddress()} <br>
                                </div>
                            </td>

                            <%
                                ArrayList<ArrayList<Integer>> cellphoneTitleList = (ArrayList<ArrayList<Integer>>) session.getAttribute("titleList");
                                ArrayList<ArrayList<Integer>> cellphoneQuantityList = (ArrayList<ArrayList<Integer>>) session.getAttribute("quantityList");
                            %>
                            <td class="border border-blue-200 p-1">
                                <div class="order-info">
                                <%        for (int j = 0; j < cellphoneTitleList.get(index).size(); j++) {
                                %>

                                <%= cellphoneTitleList.get(index).get(j)%> x<%= cellphoneQuantityList.get(index).get(j)%> <br>

                                <%   } %>
                                </div>
                            </td>


                        </tr>  
                        <% ++index;%>
                    </c:forEach>
                </c:if>


            </tbody>
        </table>
    </body>
</html>
