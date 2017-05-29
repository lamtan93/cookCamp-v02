
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="static/css/monCss.css" rel="stylesheet" type="text/css"/>
<link href="static/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
<link href="static/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="static/javascript/monJavascript.js" type="text/javascript"></script>--%>

<table class="table table-hover table-bordered">
    <thead>
        <tr>
            <td>Numéro de table</td>
            <td>Capacité</td>
            <td>Etat</td>
            <td >Action</td>
        </tr>
    </thead>
    <c:forEach var="e" items="${requestScope.emplacements}">
        <tbody>
            <<tr>
                <td>${e.numero}</td>
                <td>${e.capacite}</td>
                <td>${e.etat}</td>
                <td ><a href="ControleurMain?section=panier&action=choisirEmplacementServeur&idEmplacement=${e.numero}" class="btn btn-success btn-xs">Choisir</a>
                    |<a href="ControleurMain?section=panier&idEmplacement=${e.numero}" class="btn btn-group-xs">Annuler</a>|
                    <a href="ControleurMain?section=panier&action=afficherCommande&idEmplacement=${e.numero}" class="btn btn-danger btn-xs">Afficher commande</a>
                </td>

            </tr>

        </tbody>
    </c:forEach>
</table>