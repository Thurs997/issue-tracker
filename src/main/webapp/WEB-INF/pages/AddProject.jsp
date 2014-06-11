<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projects</title>
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.1.min.js" />"></script>
        <script type="text/javascript">
            var valid = false;
            function projectExists(projectName, callback){
                $.get("<c:url value="/project-exists/" />"+projectName, callback);
            }
            function processData(data){
                valid = !(data.exists);
                $("#nameEntry")
                        .css("background-color", valid ? "green" : "red")
                        .css("color", "#fff");
            }
        </script>
    </head>
    <body>
        <%@include file="TopBar.jsp"%>
        <div id="content">
            <div class="page-header">
              <h1>Dodaj projekt</h1>
            </div>
            <form:form action="add-project" modelAttribute="project" method="post">

                <p>Wprowadź nazwę projektu</p>
                <form:input id="nameEntry" onkeyup="projectExists(this.value, function(data){ processData(data); })" class="form-control" path="name"/>

                <div>
                    <input id="addButton" type="submit" class="btn btn-default btn-lg" value="Dodaj projekt" onclick="return valid;" />
                </div>

            </form:form>
        </div>
    </body>
</html>