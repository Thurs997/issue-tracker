<%--
  Created by IntelliJ IDEA.
  User: lucas
  Date: 27.04.14
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="projects" type="java.util.List<pl.edu.pw.elka.pik.issueTracker.model.Project>"--%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hibernate Via JPA Example</title>
    <style type="text/css">
        .label {
            display: block;
        }
    </style>
</head>
<body>
<h1>Dodaj projekt</h1>

<form:form action="${pageContext.servletContext.contextPath}/index.htm" commandName="index">

    <div>
        <form:label cssClass="label" path="name">Nazwa: </form:label>
        <form:input path="name"/>
    </div>

    <div>
        <input type="submit" value="Dodaj projekt"/>
    </div>

</form:form>

<hr/>
<a href="${pageContext.servletContext.contextPath}/index/list-projects">Show all users</a>
<div>1.2
    <h2>Lista projektów</h2>

    <c:if test="${not empty lists}">
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

</body>
</html>