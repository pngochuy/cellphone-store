<%-- 
    Document   : confirmAddProduct
    Created on : Jul 3, 2023, 6:01:06 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Hiện tên product -->
<h1 class="text-blue-900 mb-2 text-xl text-center">Do you really want to add this "${cellphone.getTitle()}"</h1>

<form action="addProductServlet" method="POST" >
    <div class="flex justify-center mb-2">
        <ul class="text-blue-900 rounded-lg shadow-md p-4 border-4 border-purple-700">
            <li class="mb-2">
                <b class="font-bold">Name:</b> ${cellphone.getTitle()}
            </li>
            <li class="mb-2">
                <b class="font-bold">Category:</b> ${cellphone.getCategory().getType()}
            </li>
            <li class="mb-2">
                <b class="font-bold">Color:</b> ${cellphone.getCategory().getColor()}
            </li>
            <li class="mb-2">
                <b class="font-bold">Storage:</b> ${cellphone.getCategory().getStorage()}GB
            </li>
            <li class="mb-2">
                <b class="font-bold">Image:</b>
                <div class="h-24">
                    <img src="images/${cellphone.getImage()}" alt="Product Image" class="max-h-full rounded-lg">
                </div>
            </li>
            <li class="mb-2">
                <b class="font-bold">Description:</b> ${cellphone.getDescription()}
            </li>
            <li>
                <b class="font-bold">Price:</b> $${cellphone.getPrice()}
            </li>
        </ul>
    </div>
    <div class="flex gap-2 justify-center">
        <input type="hidden" name="title" value="${cellphone.getTitle()}">
        <input type="hidden" name="type" value="${cellphone.getCategory().getType()}">
        <input type="hidden" name="color" value="${cellphone.getCategory().getColor()}">
        <input type="hidden" name="storage" value="${cellphone.getCategory().getStorage()}">
        <input type="hidden" name="fileName" value="${cellphone.getImage()}">
        <input type="hidden" name="description" value="${cellphone.getDescription()}">
        <input type="hidden" name="price" value="${cellphone.getPrice()}">
        <button name="action" value="yes" type="submit" class="px-4 py-1 rounded-md bg-green-700 text-white">Yes</button>
        <button name="action" value="no" type="submit" class="px-4 py-1 rounded-md bg-gray-500 text-white">No</button>
    </div>
</form>
