<%-- 
    Document   : login
    Created on : Jun 27, 2023, 8:28:30 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css"
              integrity="sha512-wnea99uKIC3TJF7v4eKk4Y+lMz2Mklv18+r4na2Gn1abDRPPOeef95xTzdwGD9e6zXJBteMIhZ1+68QC5byJZw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
        <form action="loginServlet" method="POST">
            <div class="bg-blue-900 w-screen h-screen flex items-center justify-center flex-col gap-3">
                <div class="text-center w-full">
                    <button type="submit" name="login" value="shopping" class="bg-white p-2 px-4 rounded-lg"><b>Go to shopping</b></button>
                </div>
                <div class="text-center w-full">
                    <button type="submit" name="login" value="loginAdmin" class="bg-white p-2 px-4 rounded-lg"><b>Login as Administrator</b></button>
                </div>
            </div>
        </form>
        
        <c:if test="${message != null}">
            <h3 style="color: red">${message}</h3>
        </c:if>
    </body>
</html>
