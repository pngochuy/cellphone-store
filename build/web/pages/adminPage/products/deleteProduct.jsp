<%-- 
    Document   : deleteProduct
    Created on : Jul 1, 2023, 8:16:58 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Hiện tên product -->
<h1 class="text-blue-900 mb-2 text-xl text-center">Do you really want to delete <b>"${cellphone.getTitle()}"</b></h1>
<form action="deleteProductServlet" method="POST" class="flex gap-2 justify-center">
    <input type="hidden" name="id" value="${cellphone.getId()}">
    <!-- Yes: sẽ vào Servlet để xóa Product -->
    <button name="action" value="yes" type="submit" class="px-4 py-1 rounded-md bg-red-800 text-white">Yes</button>
    <button name="action" value="no" type="submit" class="px-4 py-1 rounded-md bg-gray-500 text-white">No</button>
</form>
