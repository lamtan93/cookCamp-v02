<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CookCamp</title>
        <link href="static/css/monCss.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
       <script src="static/javascript/monJavascript.js" type="text/javascript"></script>
        -->
        <style>
            .jumbotron
            {
                background:#000 url("img/imageBackground/restaurant01.jpg")center center;
            }

        </style>
    <div id="coverCache">
        <div class="jumbotron"></div>
    </div>
    
   
    
</head>

<body>


    <div  class="well-sm" id="choisirTableClient"><img src="img/icon/number1Black.png" class="img-circle" > Clicker pour choisir votre table</div>
    <div id="lesTablesClient">
        <c:import url="ControleurMain?section=serveur&action=emplacementClient"></c:import>
        </div>


        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <center><h1>CookCamp Consultings Corp</h1></center>
                    <c:if test="${not empty sessionScope.EmplacementClient}">
                <a href="ControleurMain?section=interfaceClient&aide=vrai&idEmp=${EmplacementClient}" class="btn btn-primary">Demander l'aide d'un serveur</a>
                </c:if>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-2">
                <c:if test="${sessionScope.listeTypes!=null}">
                    <c:forEach var ="type" items="${sessionScope.listeTypes}">
                        <a href="ControleurMain?section=interfaceClient&choixType=${type.nom}" class="btn btn-primary btn-lg btn-block">${type.nom}</a>
                    </c:forEach>
                    <a href="ControleurMain?section=interfaceClient&choixType=Menu" class="btn btn-primary btn-lg btn-block">Menus</a>
                </c:if>
            </div>
            <div class="col-lg-10">
                <c:if test="${sessionScope.produitDetail==null}">
                    <c:if test="${sessionScope.choixType==null}">
                        <p>Actuellement en promotions :</p>
                        <c:forEach items="${listeProduits}" var="produit">
                            <div class="col-xs-4 col-sm-3 col-md-3">
                                <c:set scope="request" var="produit" value="${produit}"/>
                                <c:url value="ControleurMain?section=interfaceClient&choixVignette=vignetteProduit" var="url"/>
                                <c:import url="${url}"/>
                            </div>
                        </c:forEach>
                        <c:forEach items="${listeMenus}" var="menu">
                            <div class="col-lg-5">
                                <table class="table table-striped">
                                    <c:set scope="session" var="menu" value="${menu}"/>
                                    <c:url value="ControleurMain?section=interfaceClient&choixVignette=vignetteProduit" var="url"/>
                                    <c:import url="${url}"/>
                                </table>
                            </div>
                        </c:forEach>

                    </c:if>
                    <c:if test="${sessionScope.choixType!=null}">
                        <c:if test="${choixType=='Menu'}">
                            <c:forEach var ="menu" items="${sessionScope.listeMenus}">
                                <div class="col-lg-5">
                                    <table class="table table-striped">
                                        <c:set scope="session" var="menu" value="${menu}"/>
                                        <c:url value="ControleurMain?section=interfaceClient&choixVignette=vignetteProduit" var="url"/>
                                        <c:import url="${url}"/>
                                    </table>
                                </div>
                            </c:forEach>
                        </c:if>
                        <c:if test="${choixType!='Menu'}">
                            <c:forEach var ="produit" items="${sessionScope.listeProduits}">
                                <div class="col-xs-4 col-sm-3 col-md-3">
                                    <c:set scope="request" var="produit" value="${produit}"/>
                                    <c:url value="ControleurMain?section=interfaceClient&choixVignette=vignetteProduit" var="url"/>
                                    <c:import url="${url}"/>
                                </div>
                            </c:forEach>
                        </c:if>
                    </c:if>
                </c:if>
                <c:if test="${sessionScope.produitDetail!=null}">
                    <c:url value="ControleurMain?section=interfaceClient&choixVignette=vignetteProduit" var="url"/>
                    <c:import url="${url}"/>
                </c:if>

            </div>
        </div>
    </div>
    <div class="well-sm" id="clickerPanierClient"><img src="img/icon/number3Black.png" class="img-circle" >
        Voir panier
        <span id="messageEnvoyePanier" style="font-style: italic; font-size: 12px; color: white;" >envoyé !</span>
        <span id="messageEnvoyePanierServeur" style="font-style: italic; font-size: 12px; color: white;" >validé !</span>
    </div>

    
    <div id="affichagePanierClient">
        <c:import url="ControleurMain?section=panier&action=voirPanierClient"></c:import>
        </div>

        <div id="affichagePanierServeur">
        <c:import url="ControleurMain?section=panier&action=voirPanierServeur"></c:import>
    </div>
</body>

<!-----------------------Footerrrrrrrrrrrrrrrrrrrrrrrrrrrrrr-->
<div id="footer">
    <div class="panel-footer panel-custom">
        <div id="footer01">
            <div id="footer-contact"> <a href="ControleurMain?section=serveur" class="btn btn-warning btn-xs" style="margin-left: -10px;"  >Serveur</a></div></br>
            <div id="footer-note"><a href="#">Note</a></div></br>
            <div id="footer-team"><a href="#">©2016</a></div></br>
        </div>

        <div id="footer02">
            <div id="footer-contact"><a href="#">Maps</a></div></br>
            <div id="footer-note"><a href="#">Team Developpeur</a></div></br>
            <div id="footer-team"><a href="#">All right reserved</a></div></br>
        </div>

        <div id="footer03">
            <div id="footer-contact"><a href="#">033-054585965</a></div></br>
            <div id="footer-note"><a href="#">Commentaires</a></div></br>
            <div id="iconNote"><img src="img/icon/note.png" class="img img-thumbnail"></div>
            <div id="footer-team" class="inputNote" ><input type="text" placeholder="à vous de jouer !" style="color: orange"/></div></br>
        </div>
    </div>  
</div>
</html>
