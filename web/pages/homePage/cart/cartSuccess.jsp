<%-- 
    Document   : cartSuccess
    Created on : Jul 5, 2023, 9:08:56 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .columnsWrapper {
                display: grid;
                grid-template-columns: 1.2fr .8fr;
                gap: 40px;
                margin-top: 40px;
            }

            .box {
                background-color: #fff;
                border-radius: 10px;
                padding: 30px;
            }
            .return {
                text-decoration: none;

                color: black;
                display: flex;
            }
            svg {
                height: 20px;
                margin-right: 5px;
            }
        </style>
    </head>
    <body>
        <div class="center">
            <div class="columnsWrapper">
                <div class="box">
                    <a href="handleClickHome?action=homePage" class="return">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M9 15L3 9m0 0l6-6M3 9h12a6 6 0 010 12h-3" />
                        </svg
                        <span>Continue Shopping</span>

                    </a>
                    <h1>Thanks for your order!</h1>
                    <p>We will email you when your order will be sent.</p>
                </div>
            </div>
        </div>
    </body>
</html>
