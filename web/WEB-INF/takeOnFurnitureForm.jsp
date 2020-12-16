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
    <a href="index.jsp">Home</a><br>
        <p>Select furniture:</p>
        <form method="post" action="takeOnFurniture">
        <select name="furnitureId">
          <option value="">Select furniture</option>
              <c:forEach var="furniture" items="${listFurnitures}" varStatus="status">
                  <option value="${furniture.id}">Название: ${furniture.name}.  Цвет: ${furniture.color}. Размер: ${furniture.size}. Цена: ${furniture.publishedYear}. Количество: ${furniture.amount}.</option>
              </c:forEach>
        </select>
        <p>Select buyer:</p>
        <select name="buyerId">
          <option value="">Select buyer</option>
              <c:forEach var="buyer" items="${listBuyers}" varStatus="status">
                  <option value="${buyer.id}">Имя: ${buyer.firstname}. Фамилия: ${buyer.lastname}. Телефон: ${buyer.phone}. Наличные: ${buyer.wallet}.</option>
              </c:forEach>
        </select>
        <br><br>
        
        <input type="submit" name="submit" value="Give out a furniture">
        </form>
        <!------------emptying the buyers wallet---->
        
       
    
  </body>
</html>