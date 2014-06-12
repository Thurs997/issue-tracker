<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Zagadnienie</title>
    <link href="<c:url value="/resources/css/ui-lightness/jquery-ui-1.10.4.custom.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.10.4.custom.min.js" />"></script>
    <script type="text/javascript">
        function sliderChange( event, ui ) {
            var color = {};
            color.r = parseInt(ui.value > 50 ? 255 : (255*ui.value/50));
            color.g = parseInt(ui.value < 50 ? 255 : 255-(255*(ui.value-50)/50));
            color.b = 0;
            var colorText = "rgb("+color.r+","+color.g+","+color.b+")";
            $("#prioritySlider .ui-slider-range-min").css("background", colorText);
            $("#priorityValue").attr("value", ui.value);
        }
        $(function(){
            $("#prioritySlider").slider({
                range: "min",
                min: 0,
                max: 100,
                value: <c:out value="${issue.priority}" />,
                slide: sliderChange,
                change: sliderChange
            });
            sliderChange(null, {value: <c:out value="${issue.priority}" />});
        })
    </script>
</head>
<body>
  <%@ include file="TopBar.jsp" %>
        <c:choose>
            <c:when test="${empty issue}">
                Zagadnienie nie istnieje.
            </c:when>
            <c:otherwise>
                <div class="page-header">
                    <h1>Zagadnienie</h1>
                </div>
                <form:form action="/project/${projectId}/edit-issue" method="post" modelAttribute="issue">
                    <form:hidden path="id" /><form:hidden path="status" /><form:hidden path="created" /><form:hidden path="completed" />
                    <div class="input-group">
                        <span class="input-group-addon">Nazwa</span>
                        <form:input class="form-control" path="name"/>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">Typ</span>
                        <form:select class="form-control" path="type"><form:options items="${issueTypes}" itemLabel="name" /></form:select>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">Priorytet</span>
                        <form:hidden path="priority" id="priorityValue" />
                        <div id="prioritySlider" style="margin: 10px 10px -8px 10px;"></div><br />
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">Osoba odpowiedzialna</span>
                        <form:input class="form-control" path="assignee" /><br />
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">Opis</span>
                        <form:textarea class="form-control" path="description" /><br />
                    </div>
                    <div>
                        <input id="addButton" type="submit" class="btn btn-default btn-lg" value="<c:choose><c:when test="${empty issue.id}">Dodaj</c:when><c:otherwise>Edytuj</c:otherwise></c:choose>"/>
                    </div>
                </form:form>
            </c:otherwise>
        </c:choose>
    </body>
</html>
