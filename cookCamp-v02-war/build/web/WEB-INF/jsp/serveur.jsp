

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <style>
            .jumbotron
            {
                background:#000 url("img/imageBackground/serveur.jpg")center center;
            }
            

        </style>

        <link href="static/css/monCss.css" rel="stylesheet" type="text/css" />

        <link href="static/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="static/css/bootstrap.css" rel="stylesheet" type="text/css"/>

        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="static/javascript/monJavascript.js" type="text/javascript"></script>
        -->
        <title>Serveur</title>
        <div id="infosEmploye">
            <h1>Serveur</h1>

            ${sessionScope.sessionEmploye}
        </div>
        </br>
        </br>
        <div>
            <a href="ControleurMain?section=serveur" id="linkGestion" class="serveur">Gestion Panier</a>|<a href="ControleurMain?section=caisse" id="linkGestion" class="serveur">Caisse</a>
            <a href="ControleurMain?section=serveurfetah&action=affichageCommande" id="linkGestion" class="serveur">Commande serveur</a>
            <c:if test="${not empty applicationScope.aide}">
                <p>La table ${aide} à besoin d'aide</p><a href="ControleurMain?section=serveur&ok=ok" class="btn btn-primary">OK</a>
            </c:if>
            <c:if test="${not empty applicationScope.CommandePrete}">
                <p>La commande ${CommandePrete.id} est prete</p><a href="ControleurMain?section=serveur&recuperer=recup" class="btn btn-primary">Recuperer</a>
            </c:if>
        </div>
    </head>


    <body id="colorBodyServeur">
        
    </body>
        <!--<div id="coverCache">
            <div class="jumbotron"></div>
        </div>-->

        
        

       
        <div id="boutonLogOut">       
            <!--<input class="btn btn-danger" type="submit"  name="boutonLogOut" value="LogOut" />-->
            <a href="ControleurMain?section=logOut" class="btn btn-danger btn-xs">Log-out</a>
        </div>
       
        </br>

        <div id="bodyServeur">

          


                <div id="interfaceProduit">
                <c:import url="ControleurMain?section=interfaceClient"></c:import>
                </div>




              

        </div>

    </body>
    
</html>
