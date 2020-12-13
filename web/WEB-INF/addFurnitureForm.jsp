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
        <title>Add Furniture</title>
    </head>
    <body>
        <div>Add Furniture</div>
        <p>${info}</p>
        <br>
        <a href="index.jsp">Home</a><br>
        <form action="createFurniture" method="POST">
            Furniture name: <input type="text" name="name" value="${name}"><br>
            Furniture color: <input type="text" name="color" value="${color}"><br>
            Furniture size: <input type="text" name="size" value="${size}"><br>
            Furniture price: <input type="text" name="publishedYear" value="${publishedYear}"><br>
            <input type="submit" name="submit" value="Add Furniture">
        </form>
    </body>
</html>
