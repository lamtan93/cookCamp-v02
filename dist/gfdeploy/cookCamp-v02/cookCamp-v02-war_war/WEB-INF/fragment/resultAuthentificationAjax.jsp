
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link href="static/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
    <link href="static/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="static/css/monCss.css" rel="stylesheet" type="text/css"/>
    <script src="static/javascript/monJavascript.js" type="text/javascript"></script>
    
</head>

<div class="alert alert-danger" id="problemeLogin">
  <strong>Attention : </strong>${requestScope.problemeLogin}
</div>
<span style="color: orange">${requestScope.message}</span></br>
<%--${sessionScope.sessionEmploye}</br>
<c:forEach var="fonction" items="${requestScope.fonction}">
    ${fonction.nomFonction}</br>
</c:forEach>
--%>
