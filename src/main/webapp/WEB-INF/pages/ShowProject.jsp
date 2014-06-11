<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lucas
  Date: 11.06.14
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Project</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
</head>
<body>
<%@ include file="TopBar.jsp" %>
<c:choose>
    <c:when test="${not empty project}">
        <div>
            <div>Nazwa: </div><div>${project.name}</div>
            <c:choose>
                <c:when test="${not empty project.issues}">
                    <ul>
                        <c:forEach items="${project.issues}" var="issue">
                            <li>${issue.name}</li>
                        </c:forEach>
                    </ul>
                </c:when>
                <c:otherwise>
                    <div>Brak zagadnień</div>
                </c:otherwise>
            </c:choose>
        </div>
    </c:when>
    <c:otherwise>
        //TODO @Agnieszka redirect na stronę z nieznalexionym projektem
    </c:otherwise>
</c:choose>
</body>
</html>
