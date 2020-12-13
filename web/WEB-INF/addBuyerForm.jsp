<%-- 
    Document   : page
    Created on : Nov 28, 2020, 4:59:01 PM
    Author     : Juri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Buyer</title>
    </head>
    <body>
        <div>Add Buyer</div>
        <p>${info}</p>
        <br>
        <a href="index.jsp">Home</a><br>
        <form action="createBuyer" method="POST">
            Buyers first name: <input type="text" name="firstname" value="${firstname}"><br>
            Buyers last name: <input type="text" name="lastname" value="${lastname}"><br>
            Phone number: <input type="text" name="phone" value="${phone}"><br>
            Buyers wallet: <input type="text" name="wallet" value="${wallet}"><br>
            <input type="submit" name="submit" value="Add Buyer">
        </form>
    </body>
</html>
