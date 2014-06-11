<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projects</title>
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
    </head>
    <body>
        <%@include file="TopBar.jsp"%>
        <div id="content">
            <div>
                <h2>Lista projektów</h2>
                <c:if test="${user.admin}">
                    <a href="<c:url value="/add-project" />">Dodaj projekt</a>
                </c:if>
                <div>
                    <h3>Projekty:</h3>
                    <table border="1">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nazwa</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:choose>
                            <c:when test="${not empty projects}">
                                <c:forEach var="project" items="${projects}">
                                    <tr>
                                        <td><c:out value="${project.id}"/></td>
                                        <td><c:out value="${project.name}"/></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr><td colspan="2">Brak projektów</td></tr>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>