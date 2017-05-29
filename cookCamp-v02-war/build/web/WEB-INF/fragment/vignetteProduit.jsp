<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>-->
    <script src="static/javascript/monJavascript.js" type="text/javascript"></script>

    <script>
        /* var valueRadio = [];
           function abc ()
           {
            $(':radio:checked').each(function () {
                var valueRadio = [];
               
                valueRadio.push($(this).val());
                
                
                alert(valueRadio);
                
               document.getElementById("valueRadio").value = valueRadio;
            });   
           }*/
            
            

    </script>
</head>

<c:if test="${sessionScope.menu==null}">
    <c:if test="${sessionScope.produitDetail==null}">
        <center>

            <!-- Cette Partie sert a savoir si le produit a une promo ou non et la met en session --> 
            <c:if test="${not empty produit.promotions}">
                <c:forEach var="promo" items="${produit.promotions}">
                    <c:if test="${promo.dateDebut.time < today.time}">
                        <c:if test="${today.time < promo.dateFin.time}">
                            <c:set scope="session" var="remise" value="${promo.remise}"/>
                        </c:if>
                    </c:if>
                </c:forEach>
            </c:if>

            <a href="ControleurMain?section=interfaceClient&detailProduit=${produit.id}">
                <p>
                    <img class="img-thumbnail img-responsive" src="${produit.urlImage}" alt="image" title=""/>
                    ${produit.nom}</br>
                    <c:if test="${not empty remise}">
                        ${produit.prix-(produit.prix*remise)}€ (-${remise*100}%!) </br>
                    <s>${produit.prix}€</s>
                    </c:if>
                    <c:if test="${empty remise}">
                        ${produit.prix}€
                </c:if>
                <c:remove scope="session" var="remise"/>
                </p>
            </a>
            <a href="ControleurMain?section=panier&action=ajouter&idProduit=${produit.id}" class="btn btn-info btn-xs">Ajouter Panier Serveur</a>
            <a href="ControleurMain?section=panier&action=ajouterPanierClient&idProduit=${produit.id}" class="btn btn-info btn-xs">Ajouter Panier Client</a>
        </center>
    </c:if>
    <c:if test="${sessionScope.produitDetail!=null}">

        <!-- Cette Partie sert a savoir si le produit a une promo ou non et la met en session --> 
        <c:if test="${not empty produitDetail.promotions}">
            <c:forEach var="promo" items="${produitDetail.promotions}">
                <c:if test="${promo.dateDebut.time < today.time}">
                    <c:if test="${today.time < promo.dateFin.time}">
                        <c:set scope="session" var="remise" value="${promo.remise}"/>
                    </c:if>
                </c:if>
            </c:forEach>
        </c:if>

        <a href="Controleur?section=interfaceClient&detailProduit=${produitDetail.id}">
            <center><img class="img-rounded" src="${produitDetail.urlImage}" alt="image" title=""/><br/>
                ${produitDetail.nom}<br/>

                <c:if test="${not empty remise}">
                    ${produitDetail.prix-(produitDetail.prix*remise)}€ (-${remise*100}%!) </br>
                    <s>${produitDetail.prix}€</s></br>
                    </c:if>
                    <c:if test="${empty remise}">
                        ${produitDetail.prix}€
                </c:if>
                <c:remove scope="session" var="remise"/>

                ${produitDetail.description}
            </center>
        </a>
    </c:if>
    <div class="row">
        <div class="col-lg-6">
            <c:if test="${not empty produitDetail.informations}">
                <table class="table table-striped">
                    <thead>
                    <th class="center-block">Informations</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${produitDetail.informations}" var="info">
                            <tr>
                                <td>${info.nom}</td>
                                <td>${info.valeur}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
        <div class="col-lg-6">
            <c:if test="${not empty produitDetail.ingredients}">
                <table class="table table-striped">
                    <thead>
                    <th>Ingredients</th>
                    <th>Origine</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${produitDetail.ingredients}" var="ingredient">
                            <tr>
                                <td>${ingredient.nom}</td>
                                <td>${ingredient.origine}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
    <c:remove var="produitDetail" scope="session" />
</c:if>

<c:if test="${sessionScope.menu!=null}">

    <!-- Cette Partie sert a savoir si le produit a une promo ou non et la met en session --> 
    <c:if test="${not empty menu.promotions}">
        <c:forEach var="promo" items="${menu.promotions}">
            <c:if test="${promo.dateDebut.time < today.time}">
                <c:if test="${today.time < promo.dateFin.time}">
                    <c:set scope="session" var="remise" value="${promo.remise}"/>
                </c:if>
            </c:if>
        </c:forEach>
    </c:if>


    <thead>
    <th>${menu.nom}</th>
    <th>
        <c:if test="${not empty remise}">
            ${menu.prix-(menu.prix*remise)}€ (-${remise*100}%!)
        <s>${menu.prix}€</s>
        </c:if>
        <c:if test="${empty remise}">
            ${menu.prix}€
    </c:if>
    <c:remove scope="session" var="remise"/>
</th>
</thead>
<tbody>
  

    <c:forEach items="${menu.produits}" var="produit">

        <c:forEach items="${listeTypes}" var="type">

            <c:if test="${type.nom==produit.type.nom}">

                <%--<tr>
                    <td>${produit.type.nom}</td>
                
                    <td><input type="radio" class="classRadio" name="radioSelected" value="${produit.id}" />${produit.nom}</td>
              
                </tr>--%>

                <tr>
                    <td>${produit.type.nom}</td>
                    <td><input  type="radio" class="classRadio" name="${produit.type.nom}" value="${produit.id}"  >${produit.nom} </td>

                </tr>

            </c:if>

        </c:forEach>

    </c:forEach>

<a href="ControleurMain?section=panier&action=ajouterMenu&idMenu=${menu.id}" class="btn btn-info btn-xs" >Ajouter Menu</a>
  


</tbody>


<c:remove scope="session" var="menu"/>

</c:if>

