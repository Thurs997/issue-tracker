<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projects</title>
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
    </head>
    <body>
        <%@include file="TopBar.jsp"%>
        <div id="content">
            <div>
                <div class="page-header">
                <h2>Projekty</h2>
                </div>
                <c:if test="${user.admin}">
                    <a href="<c:url value="/add-project" />">Dodaj projekt</a>
                </c:if>
                    <div>
                        <h3>Lista projektów</h3>
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>lp.</th>
                                <th>Nazwa</th>
                                <th>Liczba zagadnień</th>
                                <th>Liczba otwartych zagadnień</th>
                                <th>Ostatnie nowe zagadnienie</th>
                                <th>Ostatnia modyfikacja</th>
                                <c:if test="${user.admin}">
                                    <th></th>
                                </c:if>
                            </tr>
                            </thead>
                            <tbody>
                                <c:choose>
                                    <c:when test="${not empty projects}">
                                        <c:forEach var="project" items="${projects}" varStatus="status">
                                            <tr style="cursor: pointer" onclick="document.location = '<c:url value="/show-project/${project.id}" />'">
                                                <td class="col-md-1"><c:out value="${status.count}"/></td>
                                                <td class="col-md-5"><c:out value="${project.name}"/></td>
                                                <td class="col-md-2"><c:out value="${stats[status.index].issues}"/></td>
                                                <td class="col-md-2"><c:out value="${stats[status.index].openIssues}"/></td>
                                                <td class="col-md-2"><fmt:formatDate type="both" value="${stats[status.index].lastIssue}" /></td>
                                                <td class="col-md-2"><fmt:formatDate type="both" value="${stats[status.index].lastChange}" /></td>
                                                <c:if test="${user.admin}">
                                                    <td class="col-md-1"><a href="/manage-project/${project.id}">Zarządzaj</a></td>
                                                </c:if>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr><td colspan="6" style="text-align: center">Brak projektów</td></tr>
                                    </c:otherwise>
                                </c:choose>
                            </tbody>
                        </table>
                </div>
            </div>
        </div>
    </body>
</html>