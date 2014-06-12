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
    <script type="text/javascript" src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/issue-validation.js" />"></script>
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
        });
    </script>
</head>
<body ng-app="editIssue" ng-controller="validationController">
  <%@ include file="TopBar.jsp" %>
        <c:choose>
            <c:when test="${empty issue}">
                Zagadnienie nie istnieje.
            </c:when>
            <c:otherwise>
                <script type="text/javascript">
                    window.issue = {
                        name: "<c:out value="${issue.name}" />",
                        assignee: "<c:out value="${issue.assignee}" />",
                        description: "<c:out value="${issue.description}" />"
                    }
                </script>
                <div class="page-header">
                    <h1>Zagadnienie</h1>
                </div>
                <form action="/project/${projectId}/edit-issue" method="post" name="issueEdit"
                      novalidate="novalidate" ng-submit="submitForm(issueEdit.$valid)">
                    <input type="hidden" name="id" value="<c:out value="${issue.id}" />" />
                    <div class="error" ng-show="issueEdit.name.$error.required || issueEdit.name.$error.minlength" class="input-group">
                        Nazwa projektu jest zbyt krótka
                    </div>
                    <div class="error" ng-show="issueEdit.name.$error.maxlength" class="input-group">
                        Nazwa projektu jest zbyt długa
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">Nazwa</span>
                        <input type="text" class="form-control" name="name"
                                required="required" ng-model="issue.name" ng-minlength="3" ng-maxlength="40"
                                ng-class="{ 'form-error' : issueEdit.name.$invalid }"/>
                    </div>
                    <c:choose>
                        <c:when test="${empty issue.id}">
                            <input type="hidden" name="status" value="<c:out value="${issue.status}" />" />
                        </c:when>
                        <c:otherwise>
                            <div class="input-group">
                                <span class="input-group-addon">Status</span>
                                <select class="form-control" name="status">
                                    <c:forEach var="statusType" items="${statusTypes}">
                                        <option value="<c:out value="${statusType}" />" <c:if test="${statusType == issue.status}">selected="selected"</c:if>><c:out value="${statusType.name}" /></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </c:otherwise>
                    </c:choose>
                    <div class="input-group">
                        <span class="input-group-addon">Typ</span>
                        <select class="form-control" name="type">
                            <c:forEach var="issueType" items="${issueTypes}">
                                <option value="<c:out value="${issueType}" />" <c:if test="${issueType == issue.type}">selected="selected"</c:if>><c:out value="${issueType.name}" /></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon" style="border-right: 1px solid #ccc; ">Priorytet</span>
                        <input type="hidden" name="priority" id="priorityValue" value="<c:out value="${issue.priority}" />"/>
                        <div id="prioritySlider" style="margin: 10px 10px -8px 10px;"></div>
                    </div>
                    <div class="error" ng-show="issueEdit.assignee.$error.minlength" class="input-group">
                        Imię i nazwisko osoby odpowiedzialnej jest zbyt krótkie
                    </div>
                    <div class="error" ng-show="issueEdit.assignee.$error.maxlength" class="input-group">
                        Imię i nazwisko osoby odpowiedzialnej jest zbyt długie
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">Osoba odpowiedzialna</span>
                        <input type="text" class="form-control" name="assignee"
                                ng-model="issue.assignee" ng-minlength="3" ng-maxlength="40"
                                ng-class="{ 'form-error' : issueEdit.assignee.$invalid }" />
                    </div>
                    <div class="error" ng-show="issueEdit.description.$error.required || issueEdit.description.$error.minlength" class="input-group">
                        Opis zagadnienia jest zbyt krótki
                    </div>
                    <div class="error" ng-show="issueEdit.description.$error.maxlength" class="input-group">
                        Opis zagadnienia jest zbyt długi
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">Opis</span>
                        <textarea class="form-control" name="description" style="height: 100px;"
                                ng-model="issue.description" required="required" ng-minlength="3" ng-maxlength="1000"
                                ng-class="{ 'form-error' : issueEdit.description.$invalid }">
                        </textarea>
                    </div>
                    <div>
                        <input id="addButton" type="submit" ng-disabled="issueEdit.$invalid" class="btn btn-default btn-lg" value="<c:choose><c:when test="${empty issue.id}">Dodaj</c:when><c:otherwise>Edytuj</c:otherwise></c:choose>"/>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>
    </body>
</html>
