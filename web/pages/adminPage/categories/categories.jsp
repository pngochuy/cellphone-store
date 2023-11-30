<%-- 
    Document   : categories
    Created on : Jul 1, 2023, 7:27:13 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Xử lí form Categories-->
<h1 class="text-blue-900 mb-2 text-xl font-bold">Categories</h1>
<label class="text-blue-900">New category name</label>
<form action="" method="" class="flex gap-1">
    <input type="text" name="categoryName" placeholder="Category name"
           class="border-2 border-gray-300 rounded-md px-1 w-full mb-0 focus-within\:border-blue-900">

    <select class="border-2 border-gray-300 rounded-md px-1 w-full mb-0 focus-within\:border-blue-900">
        <option value="">No parent category</option>
        <!-- Xử lí xuất option trong DB -->
        <option value="1">Iphone</option>
        <option value="2">Samsung</option>
    </select>
    <!-- btn-primary -->
    <button type="submit" class="bg-blue-900 text-white px-4 py-1 rounded-md">Save</button>
</form>

