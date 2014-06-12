<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Zarządzanie projektem</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
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
 <%@ include file="TopBar.jsp" %>
 <div class="page-header">
 <h1>Projekt ${project.name}</h1>
 </div>
 <div>
  <p id="infoLabel">Zmień nazwę projektu</p>
     <form:form action="/manage-project" modelAttribute="project" method="post">
        <form:hidden path="id" />
         <div class="input-group">
           <form:input id="nameEntry" class="form-control" path="name" onkeyup="projectExists(this.value, function(data){ processData(data); })" />
           <div class="input-group-btn">
             <input type="submit" class="btn btn-default" value="Ustaw" onclick="return valid;"/>
           </div>
         </div>

     </form:form>

 </div>
</body>
</html>
