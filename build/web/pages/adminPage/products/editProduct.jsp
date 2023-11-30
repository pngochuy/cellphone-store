
<!-- X? lí form -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--nên dùng `addProductServlet?id=${product.id}`-->

<form action="editProductServlet" method="POST">
    <input type="hidden" name="id" value="${cellphone.getId()}">
    <h1 class="text-blue-900 mb-2 text-xl">Edit Product</h1>

    <label for="" class="text-blue-900">Product Name</label>
    <!-- X? lí input co value cu-->
    <input name="title"
           value="${cellphone.getTitle()}"
           type="text" placeholder="product name"
           class="border-2 border-gray-300 rounded-md px-1 w-full mb-2 focus-within\:border-blue-900">
    
    <label for="" class="text-blue-900">Category</label>
    <select name="type" class="border-2 border-gray-300 rounded-md px-1 w-full mb-2 focus-within\:border-blue-900">
            <%
                String[] listT = {"No parent category", "iPhone", "Samsung", "Huawei"};
                request.setAttribute("listType", listT);
            %>

            <c:forEach var="type" items="${listType}">
                <option value="${cellphone.getCategory().getType()}" 
                        ${cellphone.getCategory().getType().equals(type) ? "selected" : "" }>
                    ${type}
                </option>
            </c:forEach>
    </select>
    
    <label for="" class="text-blue-900">Color</label>
    <select name="color" class="border-2 border-gray-300 rounded-md px-1 w-full mb-2 focus-within:border-blue-900">
            <%
                String[] listC = {"No parent category", "Black", "Red", "Blue", "Yellow"};
                request.setAttribute("listColor", listC);
            %>

            <c:forEach var="color" items="${listColor}">
                <option value="${cellphone.getId()}" 
                        ${cellphone.getCategory().getColor().trim().equals(color.trim()) ? "selected" : ""}>
                    ${color}
                </option>
            </c:forEach>
    </select>

    <label for="" class="text-blue-900">Storage (GB)</label>
    <select name="storage" class="border-2 border-gray-300 rounded-md px-1 w-full mb-2 focus-within\:border-blue-900">
            <%
                String[] listS = {"No parent category", "64", "128", "512", "1024"};
                request.setAttribute("listStorage", listS);
            %>

            <c:forEach var="storage" items="${listStorage}">
                <option value="${cellphone.getCategory().getStorage()}"
                        ${cellphone.getCategory().getStorage().toString().equals(storage) ? "selected" : "" }>
                    ${storage}
                </option>
            </c:forEach>
    </select>
        
    <!-- X? lí upload photo -->
    <label for="">Photos</label>
    <div class="mb-2 flex flex-wrap gap-2">
        <div class="h-24">
            <img src="images/${cellphone.getImage()}" alt="image" class="max-h-full rounded-lg"/>
        </div> 
  
        <label class="w-24 h-24 text-center flex flex-col items-center justify-center text-sm gap-1 text-gray-500 rounded-lg bg-gray-300 cursor-pointer">
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                    stroke="currentColor" class="w-4 h-4">
                <path stroke-linecap="round" stroke-linejoin="round"
                   d="M3 16.5v2.25A2.25 2.25 0 005.25 21h13.5A2.25 2.25 0 0021 18.75V16.5m-13.5-9L12 3m0 0l4.5 4.5M12 3v13.5" />
            </svg>
            <div>Upload</div>

            <input name="image" value="${cellphone.getImage()}" type="file" class="hidden">
        </label>
    
    <!-- N?u ko có photo thì in ra thông báo ko có -->
    <!-- <div>No photo in this product</div> -->

    </div>

    <label for="" class="text-blue-900">Description</label>
        <!-- X? lí textarea co value cu-->
    <textarea name="description" placeholder="description" class="border-2 border-gray-300 rounded-md px-1 w-full mb-2 focus-within\:border-blue-900">
${cellphone.getDescription()}</textarea>
    
    <label for="" class="text-blue-900">Price (in USD)</label>
        <!-- X? lí input co value cu-->
    <input name="price"
            value="${cellphone.getPrice()}"
            type="number" placeholder="price"
            class="border-2 border-gray-300 rounded-md px-1 w-full mb-2 focus-within\:border-blue-900">

            <!-- btn-primary -->
    <button type="submit" class="bg-blue-900 text-white px-4 py-1 rounded-md">
            Save
    </button>
</form>