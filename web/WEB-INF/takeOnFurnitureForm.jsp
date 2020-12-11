<%-- 
    Document   : page
    Created on : Nov 28, 2020, 4:59:01 PM
    Author     : Juri
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Give out a furniture</title>
  </head>
  <body>
    <h1>Give out a furniture</h1>
    <form action="takeOnFurniture" method="POST">
        <p>Select furniture:</p>
        <select name="furnitureId">
          <option value="">Select furniture</option>
              <c:forEach var="furniture" items="${listFurnitures}" varStatus="status">
                  <option value="${furniture.id}">${bfurniture.name}. ${furniture.author}. ${furniture.publishedYear}</option>
              </c:forEach>
        </select>
        <p>Select buyer:</p>
        <select name="buyerId">
          <option value="">Select buyer</option>
              <c:forEach var="buyer" items="${listBuyers}" varStatus="status">
                  <option value="${buyer.id}">${buyer.firstname} ${buyer.lastname}. ${buyer.phone}</option>
              </c:forEach>
        </select>
        <br><br>
        <input type="submit" value="Give out a furniture">
    </form>
  </body>
</html>