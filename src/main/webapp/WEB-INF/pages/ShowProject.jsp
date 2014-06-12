<%@ page import="java.io.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Project</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
</head>
<body>
<%@ include file="TopBar.jsp" %>
<c:choose>
    <c:when test="${not empty project}">
        <div>
            <div class="page-header"><h1>Projekt ${project.name} </h1></div>
            <c:choose>
                <c:when test="${not empty project.issues}">
                    <h3>Zagadnienia</h3>
                    <ul>
                        <c:forEach items="${project.issues}" var="issue">
                            <li><a href="/show-issue/${issue.id}">${issue.name}</a></li>
                        </c:forEach>
                    </ul>
                </c:when>
                <c:otherwise>
                    <div>Brak zagadnień w tym projekcie.</div>
                </c:otherwise>
            </c:choose>
        </div>
    </c:when>
    <c:otherwise>
        <error-page>
            <error-code>404</error-code>
            <location>/WEB-INF/pages/NotFound.jsp</location>
        </error-page>
    </c:otherwise>
</c:choose>
</body>
</html>
