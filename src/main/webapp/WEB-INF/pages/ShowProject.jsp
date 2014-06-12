<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Project</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.1.min.js" />"></script>
    <script type="text/javascript">
        function setRowColor(rowId, priority){
            var color = {};
            color.r = parseInt((priority > 50 ? 255 : (255*priority/50))*2/3);
            color.g = parseInt((priority < 50 ? 255 : 255-(255*(priority-50)/50))*2/3);
            color.b = 0;
            var colorText = "rgb("+color.r+","+color.g+","+color.b+")";
            $("#"+rowId).css("background", colorText);
        }
    </script>
</head>
<body>
    <%@ include file="TopBar.jsp" %>
    <div class="page-header">
        <h1>Projekt ${project.name} </h1>
        <a href="<c:url value="/" />">W górę</a>
    </div>

    <a href="<c:url value="/project/${project.id}/add-issue" />">Dodaj zagadnienie</a>
    <c:choose>
        <c:when test="${not empty project}">
            <div>
                <h3>Lista zagadnień</h3>
                <table class="table">
                    <thead>
                    <tr>
                        <th>lp.</th>
                        <th>Nazwa</th>
                        <th>Typ</th>
                        <th>Status</th>
                        <th>Utworzone</th>
                        <th>Zmodyfikowane</th>
                        <th>Zamknięte</th>
                        <th>Osoba odpowiedzialna</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${not empty project.issues}">
                                <c:forEach var="issue" items="${project.issues}" varStatus="status">
                                    <tr id="row<c:out value="${status.count}"/>" style="cursor: pointer; font-size: 95%; color: #fff;" onclick="document.location = '<c:url value="/show-issue/${issue.id}" />'">
                                        <td class="col-md-1"><c:out value="${status.count}"/></td>
                                        <td class="col-md-2"><c:out value="${issue.name}"/></td>
                                        <td class="col-md-1"><c:out value="${issue.type.name}"/></td>
                                        <td class="col-md-1"><c:out value="${issue.status.name}"/></td>
                                        <td class="col-md-1"><fmt:formatDate type="both" value="${issue.created}" /></td>
                                        <td class="col-md-1"><fmt:formatDate type="both" value="${issue.lastModified}" /></td>
                                        <td class="col-md-1"><fmt:formatDate type="both" value="${issue.completed}" /></td>
                                        <td class="col-md-1"><c:out value="${issue.assignee}"/></td>
                                    </tr>
                                    <script type="text/javascript">
                                        setRowColor("row<c:out value="${status.count}"/>", <c:out value="${issue.priority}"/>);
                                    </script>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr><td colspan="8" style="text-align: center">Brak zagadnień</td></tr>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
            </div>
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
