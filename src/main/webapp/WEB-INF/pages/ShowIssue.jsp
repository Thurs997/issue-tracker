<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lucas
  Date: 11.06.14
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
//TODO wyświetlanie, wchodzi tu obiekt ${issue}
//Sprawdzić czy nie wchodzi empty
<c:if test="${empty issue}">
    ELOO
</c:if>
</body>
</html>
