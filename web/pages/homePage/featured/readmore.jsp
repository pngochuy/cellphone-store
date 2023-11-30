
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Cellphone Details</title>
    <style>
        body {
            background-color: #000;
            color: #fff;
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            color: #00bfff;
        }

        .cellphone-image {
            max-width: 100%;
            margin-bottom: 20px;
        }

        .price {
            color: #00bfff;
            font-weight: bold;
            margin-bottom: 20px;
            font-size: 1.5rem;
        }

        .specifications {
            margin-bottom: 20px;
        }

        .specifications th {
            text-align: left;
        }

        .specifications td {
            padding-top: 5px;
            padding-bottom: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>${cellphone.getTitle()}</h1>
        <p>${cellphone.getDescription()}</p>
        <img class="cellphone-image" src="images/${cellphone.getImage()}" alt="cellphone Image">
        <p class="price">$${cellphone.getPrice()}</p>
        <table class="specifications">
            <tr>
                <th>Brand: </th>
                <td>${cellphone.getCategory().getType()}</td>
            </tr>
            <tr>
                <th>Color: </th>
                <td>${cellphone.getCategory().getColor()}</td>
            </tr>
            <tr>
                <th>Storage: </th>
                <td>${cellphone.getCategory().getStorage()} GB</td>
            </tr>
            <tr>
                <th>Color: </th>
                <td>${cellphone.getCategory().getColor()}</td>
            </tr>
        </table>
    </div>
</body>
</html>
