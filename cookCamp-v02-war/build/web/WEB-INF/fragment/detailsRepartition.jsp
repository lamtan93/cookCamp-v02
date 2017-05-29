<%-- 
    Document   : detailsRepartition
    Created on : 9 août 2016, 15:22:04
    Author     : cdi105
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="table  table-striped  table-bordered " >
    <thead>
        <tr>
            <th>designation</th>
            <th>quantite</th>
            <th>Prix ht</th>
            <th>prix ttc</th>
            <th></th>
        </tr>
    </thead>
    <tbody id="repartition">
    
   
    
 
    <c:forEach items="${ListeAjax}" var="l">
        <c:set var="ProduitLigne" value="${l}" />
        <tr class="maLigne">
            <td ><a href="#">${l.produit.nom}</a></td>
            <td>${l.quantite}</td>
            <td>${l.prix}</td> 
            <td></td> 
            <td>Total: ${l.prix*l.quantite}</td>
        </tr>
    </c:forEach>

</tbody>
</table>
<a href="ControleurMain?section=paiementaction=payer&idLigne=${ProduitLigne.id}" >Payer</a>
