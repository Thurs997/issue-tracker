<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projects</title>
        <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
    </head>
    <body>
        <%@include file="TopBar.jsp"%>
        <div id="content">
            <div>
                <div class="page-header">
                <h2>Lista projektów</h2>
                </div>
                <c:if test="${user.admin}">
                    <a href="<c:url value="/add-project" />">Dodaj projekt</a>
                </c:if>
                <div>
                    <h3>Projekty</h3>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nazwa</th>
                            <th></th>
                            <c:if test="${user.manager}">
                              <th></th>
                            </c:if>
                        </tr>
                        </thead>
                        <tbody>
                        <c:choose>
                            <c:when test="${not empty projects}">
                                <c:forEach var="project" items="${projects}" varStatus="status">
                                    <tr>
                                        <td class="col-md-1"><c:out value="${status.count}"/></td>
                                        <td class="col-md-5"><c:out value="${project.name}"/></td>
                                        <td class="col-md-1"><a href="/show-project?projectId=${project.id}">Zawartość</a></td>
                                        <c:if test="${user.manager}">
                                            <td class="col-md-1"><a href="/manage-project?projectId=${project.id}">Zarządzaj</a></td>
                                        </c:if>
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