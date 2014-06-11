<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="topBar">
    <div id="logo">
        <img src="<c:url value="/resources/img/logo.png" />" />
    </div>
    <div id="userChange">
        <form:form action="change-user" modelAttribute="user" method="post">
            <form:select path="user" onchange="this.form.submit()">
                <form:options items="${availableUsers}" itemLabel="label" />
            </form:select>
        </form:form>
    </div>
</div>