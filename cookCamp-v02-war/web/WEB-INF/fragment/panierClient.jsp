

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="static/css/monCss.css" rel="stylesheet" type="text/css"/>
<link href="static/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
<link href="static/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="static/javascript/monJavascript.js" type="text/javascript"></script>



<h3>Panier Client </h3>
<c:set var="panierClient" value="${sessionScope.panierClient}"></c:set>
<c:if test="${empty panierClient}">
    <div class="alert-info">Votre panier est vide !</div>
</c:if>

<c:if test="${not empty panierClient}">
    <p>${sessionScope.problemePanier}</p>
    <table class="table table-inverse table-hover table-bordered">
        <thead>
        <td style="background-color: grey;color: white; font-size: 15px;">#Table ${sessionScope.EmplacementClient}</td>
        <tr class="alert-success">

            <td >#Produit</td>
            <td >Description</td>
            <td >Prix/unité</td>
            <td >Quantité</td>
            <td>Prix/ligne</td>


            <td>Stock</td>


        </tr>


    </thead>


    <tbody>

        <c:forEach var="panierClient" items="${sessionScope.panierClient}">
            <tr>

                <td><a href="ControleurMain?section=interfaceClient&detailProduit=${panierClient.produit.id}"> ${panierClient.produit.nom}</a><div id="iconOperations"><a href="ControleurMain?section=panier&action=deleteProduitClient&idProduit=${panierClient.produit.id}"><img class="img-circle zoom" src="img/icon/delete.png"  ></a></div></td>
                <td>${panierClient.produit.description}</td>
                <td>${panierClient.produit.prix} €</td>
                <td>${panierClient.quantite}      
                    <div id="iconOperations"><a href="ControleurMain?section=panier&action=plusQuantiteProduitClient&idProduit=${panierClient.produit.id}"><img class="img-circle zoom" src="img/icon/plus.png"  ></a> 
                        <a href="ControleurMain?section=panier&action=minusQuantiteProduitClient&idProduit=${panierClient.produit.id}"><img class="img-circle zoom" src="img/icon/minus.png"  ></a></div>
                </td>
                <td>${panierClient.prixLignePanier} €</td>


                <td>${panierClient.produit.stock}</td>


            </tr>

        </c:forEach>
        <c:if test="${not empty sessionScope.panierMenuClient}">
        <tr class="alert-warning">

            <td>#Menu</td>
            <td>Description</td>
            <td>Prix/menu</td>
            <td>Quantité</td>
            <td>Prix/ligne</td>
            <td colspan="4">Stock</td>
        </tr>
        <c:forEach var="panierMenuClient" items="${sessionScope.panierMenuClient}">
            <tr>
                <td id="idMenuNom">${panierMenuClient.menu.nom}
                    <div id="iconOperations"><a href="ControleurMain?section=panier&action=deleteMenuClient&idMenu=${panierMenuClient.menu.id}"><img class="img-circle zoom" src="img/icon/delete.png"  ></a></div>

                </td>
                <td>Manger au moins 3 produits laitiers par jour !</td>
                <td>${panierMenuClient.menu.prix}</td>
                <td>${panierMenuClient.quantite}
                    <div id="iconOperations"><a href="ControleurMain?section=panier&action=plusQuantiteMenuClient&idMenu=${panierMenuClient.menu.id}"><img class="img-circle zoom" src="img/icon/plus.png"  ></a> 
                        <a href="ControleurMain?section=panier&action=minusQuantiteMenuClient&idMenu=${panierMenuClient.menu.id}"><img class="img-circle zoom" src="img/icon/minus.png"  ></a></div>
                </td>
                <td>${panierMenuClient.prixLignePanier}</td>
                <td>Unlimited</td>
            </tr>
        
            <c:forEach items="${panierMenuClient.menu.produits}" var="produitMenu" >
                <div >
                <tr  >

                    <td id="elementsMenu" style="font-size: 10px;font-style: italic ">+${produitMenu.nom}<p style="float: right">${produitMenu.type.nom}</p></td>

                </tr>
                </div>
            </c:forEach>
        

   
</c:forEach>
</c:if>
<tr>
    <td colspan="4">Total</td>
    <td>${sessionScope.prixTotalClient} €</td>
    <td><a id="clickHidePanierClient" href="#" class="btn btn-primary btn-xs">Envoyer</a></td>
</tr>

</tbody>


</table>
</c:if>



