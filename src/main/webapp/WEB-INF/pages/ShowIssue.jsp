<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zagadnienie</title>
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
    </head>
    <body>
    <%@include file="TopBar.jsp"%>
    <c:choose>
    <c:when test="${empty issue}">
        ELOO błąd elo nie istnieje
    </c:when>
    <c:otherwise>
    <form:form method="post" action="/issue/${issue.id}/add-comment" modelAttribute="comment">
        Autor: <form:input path="author" /><br />
        Treść: <form:input path="content" /><br />
        <input type="submit" value="Dodaj komentarz" />
    </form:form>
    </c:otherwise>
    </c:choose>
    </body>
</html>
