
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:url var="style" value="static/css/style.css"/> 
        <link href="${style}" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="static/javascript/jquery-3.1.0.js" type="text/javascript"></script>
        <link href="static/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="static/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="static/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="static/javascript/bootstrap.js" type="text/javascript"></script>
        <script src="static/javascript/bootstrap.min.js" type="text/javascript"></script>
        <script src="static/javascript/npm.js" type="text/javascript"></script>
        <script src="static/javascript/repartition.js" type="text/javascript"></script>
        <script src="static/javascript/jquery-ui.min.js" type="text/javascript"></script>
        <link href="static/javascript/jquery-ui.theme.css" rel="stylesheet" type="text/css"/>
        <title>Paiement</title>
    </head>
    <body>
        <div id="dialog-confirm" title="Confirmation du paiement " style="display:none;">
            <p>
                <span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
                Etes-vous sûr de vouloir valider le paiement de cette table ?    </p>
        </div>
        <div class="container">
            <div  class="row">
                <div id="teteCaisse" class=" page-header col-md-11  col-xs-12  " >
                    <p>div d'entete</p>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="panel panel-primary">
                        <div class ="panel panel-heading ">
                            <h2> table numero ${emp}</h2>
                        </div>

                        <table class="table  table-striped  table-bordered ">
                            <thead>
                                <tr>
                                    <th>designation</th>
                                    <th>Prix ht</th>
                                    <th>action</th>
                                    <th><a class="btn btn-primary" id="confirm" href="ControleurMain?section=paiement&action=payer&idCo=${commande}">Payer  toute la commande </a></th>

                                </tr>
                            </thead> 
                            <tbody> 

                                <c:forEach items="${ListeProduits}" var="ligne">



                                   <%-- <c:forEach var="i" begin="1" end="${ligne.quantite}" step="1">  --%>
                                        <tr class="maLigne"> 
                                            <td >${ligne.produit.nom} </td>
                                            <td>${ligne.prix}</td> 
                                            <td><a class="btn btn-primary diviser " href="#&idLigne=${ligne.produit.id}">Sous total</a></td>
                                        </tr>
                                   <%-- </c:forEach> --%>

                                </c:forEach>

                            </tbody>  
                        </table>

                    </div> 
                </div>
            </div>
            <c:if test="${not empty paiement}">                            
                <div class="col-md-4 ">
                    <div class="panel panel-heading panel-success">
                        <h2>Paiement Validé</h2>
                        <div class="panel-body">
                            <p>Le paiement est valide le : ${paiement.datePaiement}</p>
                            <p> Numero de validation du paiement : ${paiement.idPaiement}</p>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
        <div class="divison">

        </div>
    </body>
</html>
<%-- ${ligne.prix*((ligne.produit.tva/100)+1)}--%>