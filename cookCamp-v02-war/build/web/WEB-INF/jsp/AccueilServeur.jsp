<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <link href="static/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="static/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url var="style" value="static/css/style.css"/> 
        <link href="${style}" rel="stylesheet" type="text/css"/>
        <title>Accueil Serveur</title>
    </head>
    <body>
        <div>
            <h3 class="alert-info" style="margin-left: 10px;">Liste des commandes</h3> 

            <%--<a href="Controleur?section=serveur&choixCommande=${cmde.id}">Commande numero : ${cmde.id}</a>
            <a href="Controleur?section=serveur&action=afficherProduitByCmde&choixCommande=${cmde.id}">Commande numero : ${cmde.id}</a>
            --%>
            <table class="table table-hover table-bordered" style="margin-left: 10px;">
                <thead>
                    <tr class="alert-success">
                        <td>Id Commande</td>
                        <td>Etat Commande</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cmde" items="${mesCommandes}">
                        <tr>

                            <td class="alert-warning"><a href="ControleurMain?section=serveurfetah&action=afficherProduitByCmde&idCommande=${cmde.id}" >#numero${cmde.id}</a></td>
                           <%-- <td><a href="Controleur?section=serveurfetah&action=afficherMenuByCmde&idCommande=${cmde.id}" class="btn btn-info btn-xs">Commande numero : ${cmde.id}</a></td>--%>
                            <td>${cmde.etat}</td>
                        </tr>
                    </c:forEach>
                </tbody>


            </table>

            <a  href="#" class="btn btn-primary btn-xs">envoyer</a>

        </div>


        <!-- Produits par Commande !-->

        <h3 class="alert-info" style="margin-left: 10px;">Liste des produits par commande</h3>

        <div>
            <c:set var="verifProduit" value="${sessionScope.produitParCommande}"></c:set>
            <c:if test="${not empty verifProduit}">
                <table class="table table-hover table-bordered" style="margin-left: 10px;">
                    <thead>
                        <tr class="alert-success">
                            <td>Id produit</td>
                            <td>Nom</td>
                            <td>Prix</td>
                            <td>Desciption</td>
                        </tr>

                    </thead>
                    <tbody>
                        <c:forEach var="produitParCommande" items="${sessionScope.produitParCommande}">
                            <tr>
                                <td class="alert-warning">${produitParCommande.id}</td>
                                <td>${produitParCommande.nom}</td>
                                <td>${produitParCommande.prix}</td>
                                <td>${produitParCommande.description}</td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>

            </c:if>

            

            
            <a  href="#" class="btn btn-primary btn-xs">envoyer</a>

        </div>



        <h3 class="alert-info" style="margin-left: 10px;">Liste des menus par commande</h3>

        <div>
            <c:set var="verifMenu" value="${sessionScope.menuParCommande}"></c:set>
            <c:if test="${not empty verifMenu}">

                <table class="table table-hover table-bordered" style="margin-left: 10px;" >
                    <thead>
                        <tr class="alert-success" >
                            <td >Id menu</td>
                            <td>Nom</td>
                            <td>Prix</td>
                            <td>Type Moment</td>
                        </tr>

                    </thead>
                    <tbody>
                        <c:forEach var="menu" items="${sessionScope.menuParCommande}">
                            <tr>
                                <td class="alert-warning">${menu.id}</td>
                                <td>${menu.nom}</td>
                                <td>${menu.prix}</td>
                                <td>${menu.typeMoment}</td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>

            </c:if>
            
             <c:url value="/index.htm" var="url02" />
            <a  href="#" class="btn btn-primary btn-xs">envoyer</a>
        </div>
        
    </body>
</html>
