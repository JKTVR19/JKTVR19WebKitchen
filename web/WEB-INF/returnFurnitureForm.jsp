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
    <title>Return furniture</title>
  </head>
  <body>
    <h1>Return furniture:</h1>
    <form action="returnFurniture" method="POST">
        <select name="historyId">
          <option value="">Choose returned furniture</option>
              <c:forEach var="history" items="${listReadFurnitures}" varStatus="status">
                  <option value="${history.id}">This book "${history.furniture.name}" read ${history.buyer.firstname} ${history.buyer.lastname}</option>
              </c:forEach>
        </select>
      <br><br>
      <input type="submit" value="Return furniture">
    </form>
  </body>
</html>