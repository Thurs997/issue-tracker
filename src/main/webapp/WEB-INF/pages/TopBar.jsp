<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="topBar">
    <div id="logo">

    </div>
    <div id="userChange">
        <form:form action="change-user" modelAttribute="user" method="post">
            <form:select path="user">
                <form:options items="${availableUsers}" />
            </form:select>
            <input type="submit" value="Zmień użytkownika"/>
        </form:form>
    </div>
</div>