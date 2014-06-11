<%@ page import="java.io.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Zagadnienie</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
</head>
<body>
  <%@ include file="TopBar.jsp" %>
        <c:choose>
            <c:when test="${empty issue}">
                Zagadnienie nie istnieje.
            </c:when>
            <c:otherwise>
                <div class="page-header">
                    <h1>Zagadnienie</h1>
                </div>
                <form:form action="/edit-issue" method="post" modelAttribute="issue">
                    <form:hidden path="id" /><form:hidden path="project.id" /><form:hidden path="project.name" />
                    <div class="input-group">
                        <span class="input-group-addon">Nazwa</span>
                        <form:input class="form-control" path="name"/>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">Typ</span>
                        <form:select class="form-control" path="type"><form:options items="${issueTypes}" itemLabel="name" /></form:select>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">Priorytet</span>
                        <form:input class="form-control" path="priority" /><br />

                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">Osoba odpowiedzialna</span>
                        <form:input class="form-control" path="assignee" /><br />
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">Opis</span>
                        <form:textarea class="form-control" path="description" /><br />
                    </div>
                    <div>
                        <input id="addButton" type="submit" class="btn btn-default btn-lg" value="Dodaj"/>
                    </div>
                </form:form>
            </c:otherwise>
        </c:choose>
    </body>
</html>
