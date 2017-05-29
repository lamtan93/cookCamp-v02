
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Accueil Caisse</title>
    </head>
    <body>
        <div class="container">
            <div  class="row">
                <div id="teteCaisse" class=" page-header col-md-11  col-xs-12  " >
                    <p>div d'entete</p>

                </div>
            </div>
            <div class="panel panel-heading ">
            <div class="row">
               <!-- <div id="menuCaisse" class="col-md-2 col-xs-2 ">
       
                </div>-->
                <div id="affichageCaisse" class="col-md-6 col-xs-4"> 
                    <c:url value="WEB-INF/fragment/ChoixCaisse.jsp" var ="choixCaisse"/>
                    <c:import url="${choixCaisse}"/>
                </div>
                <div id="actionCaisse" class="col-md-2 col-xs-4">
                    <p></p>

                </div>

            </div>
                <div class=" panel panel-footer panel-warning">
                    <p>CookCamp all rights reserved</p>
                </div>
            </div>


        </div>
                
                



    </body>
</html>
