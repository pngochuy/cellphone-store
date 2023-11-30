<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- X? lí form -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css"
      integrity="sha512-wnea99uKIC3TJF7v4eKk4Y+lMz2Mklv18+r4na2Gn1abDRPPOeef95xTzdwGD9e6zXJBteMIhZ1+68QC5byJZw=="
      crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdn.tailwindcss.com"></script>
<!--<link rel="stylesheet" href="${pageContext.request.contextPath}/pages/loginPage/loginAdmin/css/main.css">-->

<form action="confirmAddProduct" method="POST" enctype="multipart/form-data">
    <h1 class="text-blue-900 mb-2 text-xl">New Product</h1>

    <label for="" class="text-blue-900">Product Name</label>
    <input type="text" name="title" placeholder="product name" 
           class="border-2 border-gray-300 rounded-md px-1 w-full mb-2 focus-within\:border-blue-900">

    <label for="" class="text-blue-900">Category</label>
    <select name="type" class="border-2 border-gray-300 rounded-md px-1 w-full mb-2 focus-within\:border-blue-900">
        <option value="">No parent category</option>
         <!--Xử lí xuất option trong DB--> 
        <option value="iPhone">iPhone</option>
        <option value="Samsung">Samsung</option>
        <option value="Huawei">Huawei</option>
    </select>

    <label for="" class="text-blue-900">Color</label>
    <select name="color" class="border-2 border-gray-300 rounded-md px-1 w-full mb-2 focus-within\:border-blue-900">
        <option value="">No parent category</option>
         <!--Xử lí xuất option trong DB--> 
        <option value="Black">Black</option>
        <option value="Red">Red</option>
        <option value="Blue">Blue</option>
        <option value="Yellow">Yellow</option>
    </select>

    <label for="" class="text-blue-900">Storage (GB)</label>
    <select name="storage" class="border-2 border-gray-300 rounded-md px-1 w-full mb-2 focus-within\:border-blue-900">
        <option value="">No parent category</option>
         <!--Xử lí xuất option trong DB--> 
        <option value="64">64</option>
        <option value="128">128</option>
        <option value="512">512</option>
        <option value="1024">1024</option>
    </select>

    <!-- X? lí upload photo -->
    <label for="" class="text-blue-900">Photos</label>
    <div class="mb-2 flex flex-wrap gap-1">
        <!-- <c:if test="${fileName != null}">
            <div class="h-24">
                <img src="images/${fileName}" alt="Product Image" class="max-h-full rounded-lg">
            </div>
        </c:if> -->
        <div name="spinner"></div>
        <label
            class="w-24 h-24 text-center flex flex-col items-center justify-center text-sm gap-1 text-gray-500 rounded-lg bg-gray-300 cursor-pointer">
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                 stroke="currentColor" class="w-4 h-4">
            <path stroke-linecap="round" stroke-linejoin="round"
                  d="M3 16.5v2.25A2.25 2.25 0 005.25 21h13.5A2.25 2.25 0 0021 18.75V16.5m-13.5-9L12 3m0 0l4.5 4.5M12 3v13.5" />
            </svg>
            <div>Upload</div>
            <input name="image" type="file" class="hidden">
        </label>
        <!-- N?u ko có photo thì in ra thông báo ko có -->
        <!-- <div>No photo in this product</div> -->

    </div>

    <label for="" class="text-blue-900">Description</label>
    <!-- X? lí textarea -->
    <textarea name="description" placeholder="description" class="border-2 border-gray-300 rounded-md px-1 w-full mb-2 focus-within\:border-blue-900"></textarea>

    <label for="" class="text-blue-900">Price (in USD)</label>
    <!-- X? lí input -->
    <input name="price" type="number" placeholder="price"
           class="border-2 border-gray-300 rounded-md px-1 w-full mb-2 focus-within\:border-blue-900">

    <!-- btn-primary -->
    <button type="submit" class="bg-blue-900 text-white px-4 py-1 rounded-md">Save</button>
</form>