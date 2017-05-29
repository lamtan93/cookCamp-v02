<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="static/css/monCss.css" rel="stylesheet" type="text/css"/>
        <title>Page Responsable</title>
    </head>
    <body>
        <div id="infosEmploye">
        <h1>Responsable</h1>

        ${sessionScope.sessionEmploye}
        </div>
        </br>
        </br>
        <a href="#" id="linkGestion">Caisse</a>|<a href="#" id="linkGestion">Employe</a>
        </br>
        
        <form action="ControleurMain?section=logOut" method="POST" accept-charset="UFT-8">
            <div >       

                <input type="submit"  name="boutonLogOut" value="LogOut" />
            </div>
        </form>
        </br>
    </body>
</html>
