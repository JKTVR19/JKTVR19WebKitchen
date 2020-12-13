<%-- 
    Document   : listBooks
    Created on : Dec 1, 2020, 10:44:36 AM
    Author     : Juri
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Furnitures</title>
    </head>
    <body>
        <h1>List of Furnitures:</h1>
        <a href="index.jsp">Home</a><br>
        <ol>
            <c:forEach var="furniture" items="${listFurnitures}" varStatus="status">
                <li>
                    ${furniture.name}. ${furniture.color}. ${furniture.size} ${furniture.publishedYear}
                </li>
            </c:forEach>
        </ol>
    </body>
</html>
