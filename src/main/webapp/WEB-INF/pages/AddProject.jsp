<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
            <div class="page-header">
              <h1>Dodaj projekt</h1>
            </div>
            <form:form action="add-project" modelAttribute="project" method="post">

                <p>Wprowadź nazwę projektu</p>
                <form:input id="nameEntry" class="form-control" placeholder="Nazwa projektu" path="name"/>

                <div>
                    <input id="addButton" type="submit" class="btn btn-default btn-lg" value="Dodaj projekt"/>
                </div>

            </form:form>
        </div>
    </body>
</html>