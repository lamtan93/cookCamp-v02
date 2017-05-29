<%-- 
    Document   : AccueilCuisinier
    Created on : 10 août 2016, 15:03:28
    Author     : cdi104
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="static/css/monCss.css" rel="stylesheet" type="text/css" />

        <link href="static/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="static/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        
         <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="static/javascript/monJavascript.js" type="text/javascript"></script>
        -->
        
        <title>Cusinier</title>
    </head>
    <body>
        <h1>Cuisinier</h1>
         <div>
             <a href="ControleurMain?section=cuisinier&rechercher=vrai">Rechercher les commandes</a>
            <h1>Liste des commandes</h1>
            <table class="table-bordered">
                <thead>
                    <tr>
                        <td>Id Commande</td>
                        <td>Etat Commande</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cmde" items="${mesCommandesEnCours}">
                        <tr>
                            <td>Commande numero : ${cmde.id}</td>
                           <%-- <td><a href="Controleur?section=serveurfetah&action=afficherMenuByCmde&idCommande=${cmde.id}" class="btn btn-info btn-xs">Commande numero : ${cmde.id}</a></td>--%>
                            <td>${cmde.etat}</td>
                            <td><a class="btn btn-primary" href="ControleurMain?section=cuisinier&etat=pret&id=${cmde.id}">Passer a pret</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
            
            
            
            
            <!-- Produits par Commande !-->

        <h1>Liste des produits par commande</h1>

        <div>
            <c:set var="verifProduit" value="${sessionScope.produitParCommande}"></c:set>
            <c:if test="${not empty verifProduit}">
                <table class="table table-hover table-bordered" >
                    <thead>
                        <tr>
                            <td>Id produit</td>
                            <td>Nom</td>
                            <td>Prix</td>
                            <td>Desciption</td>
                        </tr>

                    </thead>
                    <tbody>
                        <c:forEach var="produitParCommande" items="${sessionScope.produitParCommande}">
                            <tr>
                                <td>${produitParCommande.id}</td>
                                <td>${produitParCommande.nom}</td>
                                <td>${produitParCommande.prix}</td>
                                <td>${produitParCommande.description}</td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>

            </c:if>

            
            
            <c:url value="/index.htm" var="url02" />
            <a href="${url02}">envoyer</a>

        </div>
    </body>
</html>
