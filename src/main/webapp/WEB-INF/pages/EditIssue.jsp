<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                Informacja, że takie issue nie istnieje. Agnieszka doklej coś ładnego ;)
            </c:when>
            <c:otherwise>
                <form:form action="/project/${projectId}/edit-issue" method="post" modelAttribute="issue">
                    <form:hidden path="id" /><form:hidden path="status" /><form:hidden path="created" /><form:hidden path="completed" />
                    Nazwa: <form:input path="name" /><br />
                    Typ: <form:select path="type"><form:options items="${issueTypes}" itemLabel="name" /></form:select><br />
                    Priorytet: <form:input path="priority" /><br />
                    Osoba odpowiedzialna: <form:input path="assignee" /><br />
                    Opis: <form:textarea path="description" /><br />
                    <input type="submit" value="Dodaj" />
                </form:form>
            </c:otherwise>
        </c:choose>
    </body>
</html>
