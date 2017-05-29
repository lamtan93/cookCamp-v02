<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
                    <h1>Emplacement à encaisser</h1> 
                   
                    <c:forEach items="${mesCommandes}" var="co">
                                <a id="emplacementCaisse" href="ControleurMain?section=paiement&numCo=${co.id}&numEmp=${co.emplacement.numero}" class="btn btn btn-primary btn-lg"> table numero :${co.emplacement.numero }</a> 

                            </c:forEach>

                </div>