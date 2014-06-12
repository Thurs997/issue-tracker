<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <a href="<c:url value="/show-project/${issue.project.id}" />">W górę</a>
        </div>
        <c:if test="${user.author}">
            <a href="/edit-issue/${issue.id}">Modyfikuj</a>
        </c:if>
            <table id="issueInfo" class="table table-bordered">
              <tbody>
                <tr>
                    <td class="col-md-1">Nazwa</td>
                    <td class="col-md-5">${issue.name}</td>
                </tr>
                <tr>
                    <td class="col-md-1">Typ</td>
                    <td class="col-md-5">${issue.type.name}</td>
                </tr>
                <tr>
                    <td class="col-md-1">Priorytet</td>
                    <td class="col-md-5">${issue.priority}/100</td>
                </tr>
                <tr>
                    <td class="col-md-1">Osoba przypisana</td>
                    <td class="col-md-5">${issue.assignee}</td>
                </tr>
                <tr>
                    <td class="col-md-1">Zgłoszono</td>
                    <td class="col-md-5"><fmt:formatDate type="both" value="${issue.created}" /></td>
                </tr>
                <tr>
                    <td class="col-md-1">Zamknięto</td>
                    <td class="col-md-5"><fmt:formatDate type="both" value="${issue.completed}" /></td>
                </tr>
                <tr>
                    <td class="col-md-1">Ostatnia modyfikacja</td>
                    <td class="col-md-5"><fmt:formatDate type="both" value="${issue.lastModified}" /></td>
                </tr>
                <tr>
                    <td class="col-md-1">Status</td>
                    <td class="col-md-5">${issue.status.name}</td>
                </tr>
              </tbody>
            </table>
            <h3>Opis</h3>
            <p>${issue.description}</p
            <div class="page-header"> <h3>Komentarze</h3></div>
            <form:form action="/issue/${issue.id}/add-comment" method="post" modelAttribute="comment">
                <div class="input-group">
                    <span class="input-group-addon">Autor</span>
                    <form:input class="form-control" path="author" /><br />
                </div>
                <div class="input-group">
                    <span class="input-group-addon">Komentarz</span>
                    <form:textarea class="form-control" path="content" /><br />
                </div>
                <div>
                    <input id="addButton" type="submit" class="btn btn-default" value="Dodaj"/>
                </div>
            </form:form>
        <c:if test="${not empty issue.comments}">
             <c:forEach items="${issue.comments}" var="oldComment">
                    <div class="panel panel-default">
                        <div class="panel-heading"><b>${oldComment.author}</b> <fmt:formatDate type="both" value="${oldComment.time}" /></div>
                          <div class="panel-body">
                             <p>${oldComment.content}</p>
                          </div>
                        </div>
                </c:forEach>
        </c:if>
    </c:otherwise>
</c:choose>
</body>
</html>
