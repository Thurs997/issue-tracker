<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
    <h1>Dodaj projekt</h1>
    <form:form action="add-project" modelAttribute="project" method="post">

        <div>
            <form:label path="name">Nazwa:</form:label>
            <form:input path="name"/>
        </div>

        <div>
            <input type="submit" value="Dodaj projekt"/>
        </div>

    </form:form>

    <hr/>
    <a href="${pageContext.servletContext.contextPath}/list-projects">Pokaż projekty</a>
    <div>
        <h2>Lista projektów</h2>

        <c:if test="${not empty projects}">
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
                    <c:forEach var="project" items="${projects}">
                        <tr>
                            <td><c:out value="${project.id}"/></td>
                            <td><c:out value="${project.name}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </c:if>
    </div>
</div>
</body>
</html>