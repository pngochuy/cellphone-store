<%-- 
    Document   : categories
    Created on : Jul 1, 2023, 7:27:13 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Xử lí form Categories-->
<h1 class="text-blue-900 mb-2 text-xl font-bold">Settting</h1>
<label class="text-blue-900">Featured product</label>
<form action="settingServlet" method="" class="flex flex-col gap-2 w-1/3">
    <select name="id" class="p-3 border-2 border-gray-300 rounded-md px-1 w-full mb-0 focus-within\:border-blue-900">
        <c:forEach var="cellphone" items="${listCellphone}">
            <option value="${cellphone.getId()}">${cellphone.getTitle()}</option>
        </c:forEach> 
    </select>
    <!-- btn-primary -->
    <button type="submit" class="bg-blue-900 text-white px-4 py-1 rounded-md">Save settings</button>
</form>
