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
        <title>List of Buyers</title>
    </head>
    <body>
        <h1>List of Buyers:</h1>
        <a href="index.jsp">Home</a><br>
                <li>
                    First Name. Last Name. Phone number. Wallet cash
                </li>
        <ol>
            <c:forEach var="buyer" items="${listBuyers}" varStatus="status">
                <li>
                    ${buyer.firstname}. ${buyer.lastname}. ${buyer.phone}. ${buyer.wallet}
                </li>
            </c:forEach>
        </ol>
    </body>
    
</html>
