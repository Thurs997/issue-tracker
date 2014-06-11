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

            <table id="issueInfo" class="table table-bordered">
              <tbody>
                <tr>
                    <td class="col-md-1">Nazwa</td>
                    <td class="col-md-5">${issue.name}</td>
                </tr>
                <tr>
                    <td class="col-md-1">Typ</td>
                    <td class="col-md-5">${issue.type}</td>
                </tr>
                <tr>
                    <td class="col-md-1">Priorytet</td>
                    <td class="col-md-5">${issue.priority}</td>
                </tr>
              </tbody>
            </table>
            <h3>Opis</h3>
            <p>${issue.description}</p>
            </tr>
        </form:form>
    </c:otherwise>
</c:choose>
</body>
</html>
