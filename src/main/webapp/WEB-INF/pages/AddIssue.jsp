<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lucas
  Date: 11.06.14
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
//TODO formularz dodawania issue, action przekierowuje na /add-issue, dane POSTem
// wchodzi ${projects} żeby było z czego wybierać
<%@include file="TopBar.jsp"%>
<div id="content">
    <div class="page-header">
        <h1>Dodaj zagadnienie</h1>
    </div>
    <form:form action="add-issue" modelAttribute="issue" method="post">
        <p>Wprowadź nazwę zagadnienia</p>
        <form:input id="nameEntry" class="form-control" placeholder="Nazwa zagadnienia" path="name"/>
        <div>
            <input id="addButton" type="submit" class="btn btn-default btn-lg" value="Dodaj projekt"/>
        </div>

    </form:form>
    private Project project;
    private Type type;
    private Date created;
    private Date completed;
    private Integer priority = 0;
    private String assignee;
</body>
</html>
