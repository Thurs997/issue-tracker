<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="topBar">
    <nav class="navbar navbar-default" role="navigation">
    <div id="logo">
        <a href="/"><img src="<c:url value="/resources/img/logo.png" />" /></a>
    </div>
    <div id="userChange">
        <form:form action="/change-user" modelAttribute="user" method="post">
            <form:select class="form-control" path="user" onchange="this.form.submit()">
                <form:options items="${availableUsers}" itemLabel="label" />
            </form:select>
        </form:form>
    </div>
    </nav>
</div>