<%@ page import="java.io.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Zarządzanie projektem</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
</head>
<body>
 <%@ include file="TopBar.jsp" %>
 <div class="page-header">
 <h1>Projekt ${project.name}</h1>
 </div>
 <c:if test="${user.manager}">
   <a href="/project/${project.id}/add-issue">Dodaj zagadnienie</a>
 </c:if>
 <div>
  <p id="infoLabel">Zmień nazwę projektu</p>
     <form:form action="/manage-project" modelAttribute="project" method="post">
        <form:hidden path="id" />
         <div class="input-group">
           <form:input class="form-control" path="name"/>
           <div class="input-group-btn">
             <input type="submit" class="btn btn-default" value="Ustaw"/>
           </div>
         </div>

     </form:form>

 </div>
</body>
</html>
