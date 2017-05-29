

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="static/css/monCss.css" rel="stylesheet" type="text/css"/>
<link href="static/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
<link href="static/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="static/javascript/monJavascript.js" type="text/javascript"></script>
-->


<h4>Panier serveur </h4>
<c:set var="panierServeur" value="${sessionScope.panierServeur}"></c:set>
<c:if test="${empty panierServeur}">
    
    <div class="alert-info">Votre panier est vide !</div>
</c:if>

<c:if test="${not empty panierServeur}">
    <p>${sessionScope.problemePanier}</p>
    <table class="table table-inverse table-hover table-bordered">
        <thead>
           <td style="background-color: grey;color: white; font-size: 15px;">#Table ${sessionScope.EmplacementServeur}</td>
            <tr>
                
                <td >Produit</td>
                <td >Description</td>
                <td >Prix/unité</td>
                <td >Quantité</td>
                <td>Prix de la ligne</td>
                <td >Stock</td>


            </tr>

        </thead>


        <tbody>
            
            <c:forEach var="panierServeur" items="${sessionScope.panierServeur}">
                <tr>
                    
                    <td><a href="ControleurMain?section=interfaceClient&detailProduit=${panierServeur.produit.id}"> ${panierServeur.produit.nom}</a><div id="iconOperations"><a href="ControleurMain?section=panier&action=delete&idProduit=${panierServeur.produit.id}"><img class="img-circle zoom" src="img/icon/delete.png"  ></a></div></td>
                    <td>${panierServeur.produit.description}</td>
                    <td>${panierServeur.produit.prix} €</td>
                    <td>${panierServeur.quantite}      
                        <div id="iconOperations"><a href="ControleurMain?section=panier&action=plusQuantiteProduit&idProduit=${panierServeur.produit.id}"><img class="img-circle zoom" src="img/icon/plus.png"  ></a> <a href="ControleurMain?section=panier&action=minusQuantiteProduit&idProduit=${panierServeur.produit.id}"><img class="img-circle zoom" src="img/icon/minus.png"  ></a></div></td>
                    <td>${panierServeur.prixLignePanier} €</td>
                    <td>${panierServeur.produit.stock}</td>


                </tr>
            </c:forEach>

            <tr>
                <td colspan="4">Total</td>
                <td>${sessionScope.prixTotal} €</td>
                <td><a id="clickHidePanierServeur" href="ControleurMain?section=panier&action=validerPanier" class="btn btn-primary btn-xs">Valider</a></td>
            </tr>

        </tbody>


    </table>
</c:if>

