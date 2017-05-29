<%-- 
    Document   : caisse
    Created on : 19 juil. 2016, 10:00:33
    Author     : cdi105
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="js/repartition.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Caisse</title>
    </head>
    <body>
        <div>
            <header>
                <h1>Caisse</h1>
            </header>
            
        </div>
        <div>
            <aside>
                <ul>
                    <li><a href="#"> Paiement total</a></li>
                    <li><a href="#">répartir</a></li>
                </ul>
            </aside>
        </div>
        <div>
            <h1>Emplacement à encaisser</h1> 
        <c:if test="${ not empty mesCommandes }">
                <table>
                <c:forEach items="${mesCommandes}" var="ldcp">
                  <c:set var="emplacement" value="${ldcp.commande.emplacement.numero}"/>
                    <%--<c:if test="emplacement equal ${ldcp.commande.emplacement.numero}">--%>
                    <tr>
                        <th>${ldcp.commande.emplacement.numero}</th>
                        <td>${ldcp}</td>
                    </tr>
                 <%--  </c:if>--%>
                    
                </c:forEach>
                    
                </table>
            </c:if>
        </div>
    </body>
</html>
