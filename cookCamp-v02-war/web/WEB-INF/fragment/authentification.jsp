
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>

    <style type="text/css">
        @import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);
        @import url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300);


        body
        {
            background: #fff;

            color: #fff;
            font-family: Arial;
            font-size: 12px;
            background-image: url("img/imageBackground/restaurant02.jpeg");
            background-size: cover;

        }

        .body
        {
            -webkit-filter: blur(1.5px);
            z-index: 0;


        }
        .login
        {
            text-align: center;
            margin-top: -90px;
            margin-right: -300px;

        }
        .login input[type=password]{
            width: 250px;
            height: 30px;
            background: transparent;
            border: 1px solid rgba(255,255,255,0.6);
            border-radius: 2px;
            color: #fff;
            font-family: 'Exo', sans-serif;
            font-size: 16px;
            font-weight: 400;
            padding: 4px;
        }

        .login input[type=submit]{
            width: 250px;
            height: 35px;
            background: #fff;
            border: 1px solid #fff;
            cursor: pointer;
            border-radius: 2px;
            color: #a18d6c;
            font-family: 'Exo', sans-serif;
            font-size: 16px;
            font-weight: 400;
            padding: 6px;
            margin-top: 10px;

        }
        .login input[type=submit]:hover{
            opacity: 0.8;
        }

        .login input[type=submit]:active{
            opacity: 0.6;
        }

        .login input[type=password]:focus{
            outline: none;
            border: 1px solid rgba(255,255,255,0.9);
        }



        #titre
        {
            font-family: 'Exo', sans-serif;
            font-size: 35px;
            font-weight: 200;
            color: #fff;
            margin-top: 300px;
            margin-left: 300px;



        }
        #titre span
        {
            color: #5379fa !important;
        }

       

    </style>
    <link href="static/css/monCss.css" rel="stylesheet" type="text/css"/>
    <link href="static/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
    <link href="static/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="static/javascript/monJavascript.js" type="text/javascript"></script>
   
</head>

<body>


    <div class="body"></div>

  
    <div id="titre">Restaurant<span>Cook Camp</span></div></br>
    <div id="divBDD">
        <a href="ControleurMain?section=creer" id="hrefBDD">Créer la Base de Données</a>

     
    </div>
    </br>

    <c:set var="sessionEmploye" value="${sessionScope.sessionEmploye}"></c:set>
    <c:if test="${empty sessionEmploye}">
        <div class="login">
            <span  id="displayAjax"></span>
            <div id="aRemove">
                <input type="password" placeholder="mot de passe" name="login" id="loginAjax"><br>
                <input type="submit" value="Login" id="boutonAjax"/>
            </div>
            <!-----------Omarrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr----->
            <a href="ControleurMain?section=interfaceClient" class="btn btn-primary" style="width: 250px" >Client</a>
            <!---->
        </div>
    </c:if>

    <c:set var="sessionEmploye1" value="${sessionScope.sessionEmploye}"></c:set>
    <c:if test="${not empty sessionEmploye1}">

        <span   id="displayAjax"></span>
        <div id="boutonLogOut">       
            <!--<input class="btn btn-danger" type="submit"  name="boutonLogOut" value="LogOut" />-->
            <a href="ControleurMain?section=logOut" class="btn btn-danger btn-xs" style="margin-right: -300px;margin-top: 50px;" >Log-out</a>
        </div>

    </c:if>
        
        
</body>

